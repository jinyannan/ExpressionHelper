package ExpressionHelper;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;

import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;

import org.antlr.ext.ConditionExpression.Generated.ExpressionParser.stringLiteral_return;
import org.antlr.ext.ConditionExpression.Visitor.IGetValue;
import org.antlr.gunit.gUnitParser.file_return;

public class EntryHelper implements IGetValue{

	private CachedRowSet entry_head;
	private CachedRowSet entry_list;
	int index;
	Object resultObject;
	int [] bookmark; 
	
	@Override
	public Object GetValue(String funcName, Object[] funcParams, Object data) {
		
		HashMap<String, Object> hm = (HashMap<String, Object>)data;
		entry_head = (CachedRowSet) hm.get("ENTRY_HEAD");
		entry_list = (CachedRowSet) hm.get("ENTRY_LIST");
		bookmark = (int []) hm.get("BOOKMARK");
		index = bookmark[1];
		String colName = "";
		
		if(isHeadField(funcName)){
			return getHeadValue(funcName);
			
		}else if (isListField(funcName)) {
			return getListValue(funcName);
		}
		
		switch (funcName) {
		case "HEAD":
			colName = (String)funcParams[0];
			resultObject = getHeadValue(colName);
			break;
		case "LIST":
			colName = (String)funcParams[0];
			resultObject = getListValue(colName);
		default:
			break;
		}
		return resultObject;
	}

	private <T> T getHeadValue(String fieldName){
		Object object = null;
		try {
			entry_head.first();
			T result = (T) entry_head.getObject(fieldName);
			if(!entry_head.wasNull())
				object = entry_head.getObject(fieldName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (T)object;
	}
	
	private <T> T getListValue(String fieldName){
		Object object = null;
		try {
        	entry_list.absolute(index);
			T result = (T) entry_list.getObject(fieldName);
			if(!entry_list.wasNull())
				object = entry_list.getObject(fieldName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (T)object;
	}
	
	private boolean isHeadField(String funcName){
		boolean result = false;
		RowSetMetaData rsm;
		try {
			rsm = (RowSetMetaData) entry_head.getMetaData();
			int colCount = rsm.getColumnCount();
			for(int i = 1; i <= colCount; i++){
				if(rsm.getColumnName(i).toUpperCase().equals(funcName.toUpperCase()))
					result = true;
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return result;
	}
	
	private boolean isListField(String funcName){
		boolean result = false;
		RowSetMetaData rsm;
		try {
			rsm = (RowSetMetaData) entry_list.getMetaData();
			int colCount = rsm.getColumnCount();
			for(int i = 1; i <= colCount; i++){
				if(rsm.getColumnName(i).toUpperCase().equals(funcName.toUpperCase()))
					result = true;
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return result;
	}
}
