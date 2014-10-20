package ExpressionHelper;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.regex.*;

import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;

import org.antlr.ext.ConditionExpression.Generated.ExpressionParser.stringLiteral_return;
import org.antlr.ext.ConditionExpression.Visitor.IGetValue;
import org.antlr.gunit.gUnitParser.file_return;

public class EntryHelper implements IGetValue {

	private String _funcName = null;
	private Object[] _funcParams = null;
	private CachedRowSet _entry_head = null;
	private CachedRowSet _entry_list = null;
	private CachedRowSet _entry_certificate = null;
	private CachedRowSet _entry_container = null;

	private int _index = 0;
	private Object _resultObject = null;
	private int[] _bookmark = null;
	private String _statusWord = null;

	@Override	
	public Object GetValue(String funcName, Object[] funcParams, Object data) {

		_funcName = funcName;
		_funcParams = funcParams;
		HashMap<String, Object> hm = (HashMap<String, Object>) data;
		_entry_head = (CachedRowSet) hm.get("ENTRY_HEAD");
		_entry_list = (CachedRowSet) hm.get("ENTRY_LIST");
		_entry_container = (CachedRowSet) hm.get("ENTRY_CONTAINER");
		_entry_certificate = (CachedRowSet) hm.get("ENTRY_CERTIFICATE");
		
		_bookmark = (int[]) hm.get("BOOKMARK");
		_statusWord = hm.get("STATUSWORD").toString();

		_index = _bookmark[1];
		String colName = "";

		if (isHeadField(_funcName))
			return getHeadValue(_funcName);
		else if (isListField(_funcName))
			return getListValue(_funcName);
		else if (isContainerField(_funcName))
			return getContainerValue(_funcName);
		else if (isCertificateField(_funcName))
			return getCertValue(_funcName);

		switch (funcName.toUpperCase()) {
		case "HEAD":
			_resultObject = getHeadValue("");
			break;
		case "LIST":
			_resultObject = getListValue("");
			break;
		case "CERT":
			_resultObject = getCertValue("");
			break;
		case "CONTAINER":
			_resultObject = getContainerValue("");
			break;
		case "LISTNUM":
			_resultObject = listNum();
			break;
		case "LISTSUM":
			_resultObject = listSum();
			break;
		case "LIKE":
			_resultObject = like();
			break;
		case "SW":
			_resultObject = sw();
			break;
		default:
			break;
		}
		return _resultObject;
	}

	/**
	 * 目前不再支持多参数，如果需要截取字符串，请用mid,left,right一类方法
	 * 
	 * @param fieldName
	 * @return
	 */
	private <T> T getHeadValue(String fieldName) {
		Object object = null;
		if (fieldName.equals("")) {
			checkParams(1);
			fieldName = _funcParams[0].toString();
			if (_funcParams[0].toString().toUpperCase()
					.equals("STATUS_RESULT")) {
				return (T) _statusWord;
			}
		}
		try {
			_entry_head.first();
			T result = (T) _entry_head.getObject(fieldName);
			if (!_entry_head.wasNull())
				object = _entry_head.getObject(fieldName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (T) object;
	}

	/**
	 * 目前不再支持多参数，如果需要截取字符串，请用mid,left,right一类方法
	 * 
	 * @param fieldName
	 * @return
	 */
	private <T> T getListValue(String fieldName) {
		Object object = null;
		fieldName = fieldName.equals("") ? _funcParams[0].toString()
				: fieldName;
		if (!isEmptyResult(_entry_list)) {
			try {
				_entry_list.absolute(_index);
				T result = (T) _entry_list.getObject(fieldName);
				if (!_entry_list.wasNull())
					object = _entry_list.getObject(fieldName);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return (T) object;
	}

	private <T> T getCertValue(String fieldName) {
		Object object = null;
		checkParams(1);
		fieldName = fieldName.equals("") ? _funcParams[0].toString()
				: fieldName;
		try {
			_entry_certificate.absolute(_index);
			T result = (T) _entry_certificate.getObject(fieldName);
			if (!_entry_certificate.wasNull())
				object = _entry_certificate.getObject(fieldName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (T) object;
	}

	private <T> T getContainerValue(String fieldName) {
		Object object = null;
		checkParams(1);
		fieldName = fieldName.equals("") ? _funcParams[0].toString()
				: fieldName;
		try {
			_entry_container.absolute(_index);
			T result = (T) _entry_container.getObject(fieldName);
			if (!_entry_container.wasNull())
				object = _entry_container.getObject(fieldName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (T) object;
	}

	private boolean isHeadField(String funcName) {
		boolean result = false;
		RowSetMetaData rsm;
		try {
			rsm = (RowSetMetaData) _entry_head.getMetaData();
			int colCount = rsm.getColumnCount();
			for (int i = 1; i <= colCount; i++) {
				if (rsm.getColumnName(i).toUpperCase()
						.equals(funcName.toUpperCase()))
					result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private boolean isListField(String funcName) {
		boolean result = false;
		RowSetMetaData rsm;
		try {
			rsm = (RowSetMetaData) _entry_list.getMetaData();
			int colCount = rsm.getColumnCount();
			for (int i = 1; i <= colCount; i++) {
				if (rsm.getColumnName(i).toUpperCase()
						.equals(funcName.toUpperCase()))
					result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private boolean isContainerField(String funcName) {
		boolean result = false;
		RowSetMetaData rsm;
		try {
			rsm = (RowSetMetaData) _entry_container.getMetaData();
			int colCount = rsm.getColumnCount();
			for (int i = 1; i <= colCount; i++) {
				if (rsm.getColumnName(i).toUpperCase()
						.equals(funcName.toUpperCase()))
					result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private boolean isCertificateField(String funcName) {
		boolean result = false;
		RowSetMetaData rsm;
		try {
			rsm = (RowSetMetaData) _entry_certificate.getMetaData();
			int colCount = rsm.getColumnCount();
			for (int i = 1; i <= colCount; i++) {
				if (rsm.getColumnName(i).toUpperCase()
						.equals(funcName.toUpperCase()))
					result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	private void checkParams(int paramsLength) {
		if (_funcParams.length < paramsLength) {
			throw new RuntimeException(String.format("函数参数个数错！"));
		}
	}

	private Double listSum() {
		checkParams(1);
		String fieldName = _funcParams[0].toString();
		double sum = 0;
		if (!isEmptyResult(_entry_list)) {
			try {
				_entry_list.beforeFirst();
				while (_entry_list.next()) {
					sum += _entry_list.getDouble(fieldName);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sum;
	}
	
	private int listNum() {
		int count = 0;
		if (!isEmptyResult(_entry_list)) {
			try {
				_entry_list.beforeFirst();
				while (_entry_list.next()) {
					count ++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	
	/**
	 * 判断结果集是否为空
	 * @param resultName
	 * @return
	 */
	private boolean isEmptyResult(CachedRowSet table) {

		boolean isEmpty = true;
		try {
			table.beforeFirst();
			if (table.next())
				isEmpty = false;
		} catch (SQLException e) {
			isEmpty = true;
		}
		return isEmpty;
	}
	
	private boolean like() {
		boolean result = false;
		checkParams(2);
		String str = _funcParams[0].toString();
		String condition = _funcParams[1].toString();
		condition = condition.replaceAll("\\*", ".*");
		return regex(str, condition);
	}
	
	private boolean regex(String str, String condition){
		boolean result = false;

		Pattern pattern = Pattern.compile(condition);
		Matcher matcher = pattern.matcher(str);
		result = matcher.matches();
		return result;
	}
	
	private String sw() {
		return _statusWord.substring(Integer.parseInt(_funcParams[0].toString()) - 1, 1);
	}
}