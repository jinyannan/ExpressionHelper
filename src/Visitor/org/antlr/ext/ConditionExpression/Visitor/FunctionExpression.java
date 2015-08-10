package org.antlr.ext.ConditionExpression.Visitor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.antlr.codegen.ObjCTarget;
import org.antlr.ext.ConditionExpression.Expression;
import org.antlr.ext.ConditionExpression.Utility.Compare;
import org.antlr.ext.ConditionExpression.Utility.DataType;
import org.antlr.ext.ConditionExpression.Utility.DateHelper;
import org.antlr.ext.ConditionExpression.Utility.PersistenceSwitchHelper;
import org.antlr.runtime.tree.Tree;
import org.antlr.ext.ConditionExpression.Utility.StringUtility;
import org.antlr.grammar.v3.ANTLRParser.range_return;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.LocalAttribute;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FunctionExpression extends BaseExpression {
	public FunctionExpression(BaseExpression exp, Tree tree) {
		super(exp, tree);
	}

	@Override
	public Object Evaluate(Object data, Object local) throws Exception {
		double value;
		String funcName = _tree.getChild(0).toString();
		// string member and was converted to Java 'if-else' logic:
		// switch (funcName.ToUpper())
		if (funcName.toUpperCase().equals("BT")) {
			CheckMinParamCount(funcName, 2);
			return BT(_tree, data, local);
		} else if (funcName.toUpperCase().equals("IN")) {
			CheckMinParamCount(funcName, 2);
			return IN(_tree, data, local);
		} else if (funcName.toUpperCase().equals("CONTAINS")) {
			CheckMinParamCount(funcName, 2);
			return CONTAINS(_tree, data, local);
		} else if (funcName.toUpperCase().equals("IIF")) {
			CheckParamCount(funcName, 3);
			return IIF(_tree, data, local);

		} else if (funcName.toUpperCase().equals("MID")) {
			CheckParamCount(funcName, 3);
			return MID(_tree, data, local);
		} else if (funcName.toUpperCase().equals("LEFT")) {
			CheckParamCount(funcName, 2);
			return LEFT(_tree, data, local);
		} else if (funcName.toUpperCase().equals("RIGHT")) {
			CheckParamCount(funcName, 2);
			return RIGHT(_tree, data, local);
		} else if (funcName.toUpperCase().equals("TRIM")) {
			CheckParamCount(funcName, 1);
			return TRIM(_tree, data, local);
		} else if (funcName.toUpperCase().equals("LEN")) {
			CheckParamCount(funcName, 1);
			return LEN(_tree, data, local);
		}

		else if (funcName.toUpperCase().equals("UPPER")) {
			CheckParamCount(funcName, 1);
			return UPPER(_tree, data, local);
		} else if (funcName.toUpperCase().equals("LOWER")) {
			CheckParamCount(funcName, 1);
			return LOWER(_tree, data, local);
		} else if (funcName.toUpperCase().equals("INSTR")) {
			CheckParamCount(funcName, 2);
			return INSTR(_tree, data, local);
		} else if (funcName.toUpperCase().equals("LIKE")) {
			CheckParamCount(funcName, 2);
			return LIKE(_tree, data, local);
		} else if (funcName.toUpperCase().equals("CHARINDEX")) {
			CheckParamCount(funcName, 2);
			return CHARINDEX(_tree, data, local);
		} else if (funcName.toUpperCase().equals("INT")) // /向下取整
		{
			CheckParamCount(funcName, 1);
			value = Double.parseDouble(VisitSubTree(_tree.getChild(1), data,
					local).toString());
			return (int) Math.floor(value);
		} else if (funcName.toUpperCase().equals("SQRT")) {
			CheckParamCount(funcName, 1);
			value = Double.parseDouble(VisitSubTree(_tree.getChild(1), data,
					local).toString());
			return Math.sqrt(value);

		}

		/**
		 * 计算日期类型 Aardwolf.K
		 */
		else if (funcName.toUpperCase().equals("DAYOFWEEK")) {
			CheckParamCount(funcName, 0);
			Calendar c = Calendar.getInstance();
			// return (int)Calendar.DAY_OF_WEEK-1; ///周日是0，周六是6
			return (int) (c.get(Calendar.DAY_OF_WEEK) - 1);
		} else if (funcName.toUpperCase().equals("DATEDIFF")) {
			CheckParamCount(funcName, 2);
			return DATEDIFF(_tree, data, local);
		}
		else if (funcName.toUpperCase().equals("NOW")) {
			CheckParamCount(funcName, 0);
			return new java.util.Date();
		}
		else if (funcName.toUpperCase().equals("DATE")) {
			CheckParamCount(funcName, 0);
			return DateHelper.getCurrentDate();
			// return new Date();
		}
		else if (funcName.toUpperCase().equals("TIME")) {
			CheckParamCount(funcName, 0);
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

			return formatter.format(new Date());
			// return new Date().ToString("HH:mm:ss");
		}
		else if (funcName.toUpperCase().equals("HOUR")) {
			CheckParamCount(funcName, 0);
			Calendar ca = Calendar.getInstance();
			// return new Date().getHours();
			return ca.get(Calendar.HOUR_OF_DAY);
		}
		else if (funcName.toUpperCase().equals("YEAR")) {
			CheckParamCount(funcName, 0);
			Calendar ca = Calendar.getInstance();
			// return new java.util.Date().getYear();
			return ca.get(Calendar.YEAR);
		}
		else if (funcName.toUpperCase().equals("MONTH")) {
			CheckParamCount(funcName, 0);
			Calendar ca = Calendar.getInstance();
			// return new java.util.Date().getMonth();
			return ca.get(Calendar.MONTH) + 1;
		}
		else if (funcName.toUpperCase().equals("DAY")) {
			CheckParamCount(funcName, 0);
			// return new java.util.Date().getDay();
			Calendar ca = Calendar.getInstance();
			return ca.get(Calendar.DATE);
		} else if (funcName.toUpperCase().equals("ISNULL")) {
			CheckParamCount(funcName, 1);
			return (Boolean) (VisitSubTree(_tree.getChild(1), data, local) == null);
		} else if (funcName.equalsIgnoreCase("IsNotNull")) {
			CheckParamCount(funcName, 1);
			return (Boolean) (VisitSubTree(_tree.getChild(1), data, local) != null);
		} else if (funcName.toUpperCase().equals("EXISTOBJECT")) {
			return true;
		} else if (funcName.toUpperCase().equals("GLOBALVAR")) {
			return "0";
		}
		/**
		 * 集合函数
		 */
		else if (funcName.equalsIgnoreCase("filter")) {
			return filter(_tree, data, local);
		} else if (funcName.equalsIgnoreCase("Count")) {
			return count(_tree, data, local);
		} else if (funcName.equalsIgnoreCase("Exist")) {
			return exist(_tree, data, local);
		} else if (funcName.equalsIgnoreCase("Min")) {
			return min(_tree, data, local);
		} else if (funcName.equalsIgnoreCase("Max")) {
			return max(_tree, data, local);
		} else if (funcName.equalsIgnoreCase("Sum")) {
			return sum(_tree, data, local);
		} else if (funcName.equalsIgnoreCase("Avg")) {
			return avg(_tree, data, local);
		} else if (funcName.equalsIgnoreCase("rand")) {
			return Math.random();
		} else if (funcName.equalsIgnoreCase("ExistKey")) {
			return existKey(_tree, data, local);
		} else if (funcName.equalsIgnoreCase("IsNull")) {
			return isNull(_tree, data, local);
		} else if (funcName.equalsIgnoreCase("IsNotNull")) {
			return isNotNull(_tree, data, local);
		} else if (funcName.equalsIgnoreCase("GlobalVar")) {
			return true;
		} else if (funcName.equalsIgnoreCase("Valid")) {
			//XXX该函数尚未确定暂时返回true
			return true;
		} else if (funcName.equalsIgnoreCase("IsDate")) {
			return isDate(_tree, data, local);
		} else if (funcName.equalsIgnoreCase("ToDate")) {
			return toDate(_tree, data, local);
		} else if (funcName.equalsIgnoreCase("GetColValue")) {
			return GetColValue(_tree, data, local);
		}else if (funcName.equalsIgnoreCase("GetValueByCondition")) {
			return GetValueByCondition(_tree, data, local);
		}
		else {
			return CallUserFunction(funcName, _tree, data, local);
		}
	}

	private Object CallUserFunction(String funcName, Tree tree, Object data,
			Object local) throws Exception {
		java.util.ArrayList<Object> funParams = new java.util.ArrayList<Object>();
		for (int i = 1; i < tree.getChildCount(); i++) {
			funParams.add(VisitSubTree(tree.getChild(i), data, local));
		}

		if (this.getUserFunction() != null) {
			Object result = this.getUserFunction().GetValue(funcName,
					funParams.toArray(new Object[] {}), data);
			if (DataType.IsNumber(result)) {
				return Double.parseDouble(result.toString());
			} else if (result instanceof java.util.Date
					|| result instanceof String || result instanceof Boolean) {
				return result;
			} else if (result == null) {
				return null;
			} else {
				return result.toString();
			}
		} else {
			StringBuilder paramString = new StringBuilder();
			for (Object m : funParams) {
				if (paramString.length() > 0) {
					paramString.append(",");
				}
				if (m instanceof String) {
					paramString.append(String.format("\"{0}\"", m));
				} else {
					paramString.append(String.format("{0}", m));
				}
			}
			String errMsg = String.format("{0}({1})无法计算值", funcName,
					paramString);

			throw new Exception(errMsg);
		}
	}

	private Object GetColValue(Tree tree, Object data, Object local) throws Exception{
		Object value = VisitSubTree(tree.getChild(1), data, local);
		String propsname = (String) VisitSubTree(tree.getChild(2), data, local);

		if (value == null || propsname == null) {
			return false;
		}
		
		PersistenceSwitchHelper persistence = new PersistenceSwitchHelper();
		return persistence.getFieldValue(value, propsname);
	}
	/**
	 * 返回特殊行列的值
	 * 参数有
	 * @param tree
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	
	private Object GetValueByCondition(Tree tree, Object data, Object local) throws Exception{
		ArrayList<?> value = (ArrayList<?>)VisitSubTree(tree.getChild(1), data, local);
		//String key = (String)VisitSubTree(tree.getChild(2), data, local);
		Integer pos = (Integer)VisitSubTree(tree.getChild(2), data, local);
		String fieldName = (String)VisitSubTree(tree.getChild(3), data, local);
		
//		HashMap<String, Object> hmlocal = (HashMap<String, Object>)local;
//		hmlocal.put(key, value.get(pos));

		if (value == null || pos == null || fieldName == null) {
			return false;
		}
		
		PersistenceSwitchHelper persistence = new PersistenceSwitchHelper();
//		hmlocal.remove(key);
		
		return persistence.getFieldValue(value.get(pos), fieldName);
	}
	
	/**
	 * 处理形如BT(aaa,1,3,6,9,11)这样的函数 即：(aaa>1 && aaa<3) || (aaa>6 && aaa<9) ||
	 * (aaa>11) 判断arg1是否在arg2与arg3之间， 参数可成对变长，参数支持字符串、日期、数字，在范围之内则返回true，
	 * 反之false。arg3若不传入则arg1<arg2既返回true SAMPLE:BT(2,1,3),BT(2,1),BT(2,3,4,1,5)
	 * 
	 * @param tree
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private Object BT(Tree tree, Object data, Object local) throws Exception {

		Object value = VisitSubTree(tree.getChild(1), data, local);

		if (value == null) {
			return false;
		}

		for (int i = 2; i < tree.getChildCount(); i += 2) {
			if (Compare.IsGreaterOrEqual(value,
					VisitSubTree(tree.getChild(i), data, local))) {
				if (i + 1 >= tree.getChildCount()) // /如果只有小值，那待比较值比小值大就返回true
				{
					return true;
				} else if (Compare.IsLessOrEqual(value,
						VisitSubTree(tree.getChild(i + 1), data, local))) {
					return true; // /落到了某个区间，可以退出了
				}
			}
		}

		/**
		 * 都做完没有返回就是没找到
		 */
		return false;
	}

	/**
	 * 如果输入参数不为空且同时包含指定的多个元素，返回True，否则返回False。
		参数1：数据对象OBJECT，可以为STRING或LIST
		参数2-n：元素OBJECT
		返回值：BOOL
		例如：CONTAINS($EMS_LIST.G_MODEL,"三文鱼","15厘米")
	 * @param tree
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	private Object CONTAINS(Tree tree, Object data, Object local) throws Exception {
		String value = (String)VisitSubTree(tree.getChild(1), data, local);
		Boolean result = true;
		String param = "";
		for (int i = 2; i < tree.getChildCount(); i++) {
			/**
			 * 匹配所有的参数才算true
			 */
			param = (String)VisitSubTree(tree.getChild(i), data, local);
			if (!value.contains(param)) {
				result = false;
			}
		}
		return result;
	}
	
	/**
	 * IN(Object arg1,Object arg2,...)
	 * arg1若与arg2~argn中任意一数值匹配则返回true，都不匹配返回false 参数支持字符串与数字 IN("A","A","B","C")
	 * 
	 * @param tree
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private Object IN(Tree tree, Object data, Object local) throws Exception {
		Object value = VisitSubTree(tree.getChild(1), data, local);
		for (int i = 2; i < tree.getChildCount(); i++) {
			/**
			 * 碰到第一个相等的就退出
			 */
			if (Compare.AreEqual(value,
					VisitSubTree(tree.getChild(i), data, local))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * IIF(Boolean expr, Object truepart, Object falsepart)
	 * 第一个参数expr为表达式，为true则返回truepart，为false则返回falsepart IIF("1=1","A","B")
	 * 
	 * @param tree
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private Object IIF(Tree tree, Object data, Object local) throws Exception {
		boolean condition = Boolean.parseBoolean(VisitSubTree(tree.getChild(1),
				data, local).toString());
		if (condition) {
			return VisitSubTree(tree.getChild(2), data, local);
		} else {
			return VisitSubTree(tree.getChild(3), data, local);
		}
	}

	/**
	 * MID(String str,int from,int length) 取str中自from位置起始，length长度的字符串
	 * 
	 * @param tree
	 * @param data
	 * @param local
	 * @return
	 * @throws NumberFormatException
	 * @throws Exception
	 */

	private Object MID(Tree tree, Object data, Object local)
			throws NumberFormatException, Exception {

		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		if (value1 == null) {
			return "";
		}

		Object value2 = VisitSubTree(tree.getChild(2), data, local);
		if (value2 == null) {
			return "";
		}
		Object value3 = VisitSubTree(tree.getChild(3), data, local);
		if (value3 == null) {
			return "";
		}

		String str = String.valueOf(value1);
		int from = Integer.parseInt(String.valueOf(value2));
		int length = Integer.parseInt(String.valueOf(value3));

		/**
		 * 为了跟老版本兼容，采用1为起始坐标 判断一下是否合法
		 */
		return StringUtility.Mid(str, from, length);
	}

	/**
	 * LEFT(String str,int length) 取str左面length长度的字符串 LEFT("ABCD",2)
	 * 
	 * @param tree
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	private Object LEFT(Tree tree, Object data, Object local) throws Exception {

		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		if (value1 == null) {
			return "";
		}
		Object value2 = VisitSubTree(tree.getChild(2), data, local);
		if (value2 == null) {
			return "";
		}
		String str = String.valueOf(value1);
		int length = Integer.parseInt(value2.toString());
		return StringUtility.Left(str, length);
	}

	/**
	 * RIGHT(String str,int length) 取str右面length长度的字符串 RIGHT("ABCD",2)
	 * 
	 * @param tree
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */

	private Object RIGHT(Tree tree, Object data, Object local) throws Exception {
		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		if (value1 == null) {
			return "";
		}
		Object value2 = VisitSubTree(tree.getChild(2), data, local);
		if (value2 == null) {
			return "";
		}
		String str = String.valueOf(value1);
		int length = Integer.parseInt(value2.toString());

		return StringUtility.Right(str, length);
	}

	/**
	 * UPPER(String str) str变大写 UPPER("abc)
	 * 
	 * @param tree
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	private Object UPPER(Tree tree, Object data, Object local) throws Exception {
		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		if (value1 == null) {
			return "";
		}
		String str = String.valueOf(value1);

		return str.toUpperCase();
	}

	/**
	 * LOWER(String str) str转换为小写 LOWER("abc")
	 * 
	 * @param tree
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	private Object LOWER(Tree tree, Object data, Object local) throws Exception {
		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		if (value1 == null) {
			return "";
		}
		String str = String.valueOf(value1);

		return str.toLowerCase();
	}

	/**
	 * TRIM(String str) 去掉str两边空格 TRIM("  ABC   ")
	 * 
	 * @param tree
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	private Object TRIM(Tree tree, Object data, Object local) throws Exception {
		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		if (value1 == null) {
			return "";
		}
		String str = String.valueOf(value1);

		return str.trim();
	}

	/**
	 * LEN(String str) 获得str的长度 LEN("ABC")
	 * 
	 * @param tree
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	private Object LEN(Tree tree, Object data, Object local) throws Exception {
		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		if (value1 == null) {
			return 0;
		}
		String str = String.valueOf(value1.toString());
		return str.length();
	}

	/**
	 * INSTR(String str,String find) 判断str中是否包含find，如包含返回true，反之返回false
	 * INSTR("ABC","A")
	 * 
	 * @param tree
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	private Object INSTR(Tree tree, Object data, Object local) throws Exception {
		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		if (value1 == null) {
			return false;
		}
		Object value2 = VisitSubTree(tree.getChild(2), data, local);
		if (value2 == null) {
			return false;
		}

		String str = String.valueOf(value1);
		String find = String.valueOf(value2);

		return str.indexOf(find) > -1;
	}

	/**
	 * LIKE(String str,String find)
	 * 检查输入的非空字符串是否与模板匹配，find为正则表达式，匹配返回True，否则返回False。 LIKE("ABC","[A]*")
	 * 
	 * @param tree
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	private Object LIKE(Tree tree, Object data, Object local) throws Exception {
		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		if (value1 == null) {
			return false;
		}
		Object value2 = VisitSubTree(tree.getChild(2), data, local);
		if (value2 == null) {
			return false;
		}
		String str = String.valueOf(value1);
		String find = String.valueOf(value2);
		return str.matches(find);
	}

	/**
	 * CHARINDEX(String str,String find):int
	 * 输入2个不为空的字符串，在第1个字符串中，从指定的开始位置搜索第2个字符串第1次出现的位置。返回找到的位置，没找到则返回0
	 * 参数1：字符串，参数2：字符串，返回值：位置（整形） CHARINDEX("ABC","B")
	 * 
	 * @param tree
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	private Object CHARINDEX(Tree tree, Object data, Object local)
			throws Exception {
		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		if (value1 == null) {
			return false;
		}
		Object value2 = VisitSubTree(tree.getChild(2), data, local);
		if (value2 == null) {
			return false;
		}

		String str = String
				.valueOf(VisitSubTree(tree.getChild(1), data, local));
		String find = String
				.valueOf(VisitSubTree(tree.getChild(2), data, local));

		return str.indexOf(find);
	}

	/**
	 * Aardwolf.K 检查函数的参数个数，如果不对，直接报错
	 * 
	 * @param funName
	 * @param expectParamCount
	 *            期望的参数个数
	 */
	private void CheckParamCount(String funName, int expectParamCount) {
		/**
		 * 第一个child是函数名
		 */
		int actualParamCount = _tree.getChildCount() - 1;
		if (actualParamCount != expectParamCount) {
			throw GetTreeException(String.format("函数%1$s需要%2$s个参数，实际有%3$s个参数",
					funName, expectParamCount, actualParamCount));
		}
	}

	/**
	 * 检查参数个数
	 * 
	 * @param funName
	 * @param minExpectParamCount
	 *            最少包含的参数个数
	 */
	private void CheckMinParamCount(String funName, int minExpectParamCount) {
		/**
		 * 第一个child是函数名
		 */
		int actualParamCount = _tree.getChildCount() - 1;
		if (actualParamCount < minExpectParamCount) {
			throw GetTreeException(String.format("函数%1$s至少有%2$s个参数，实际有%3$s个参数",
					funName, minExpectParamCount, actualParamCount));
		}
	}

	/**
	 * 计算两个日期相差的天数
	 * 
	 * @param tree
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private Object DATEDIFF(Tree tree, Object data, Object local)
			throws Exception {

		Object left = VisitSubTree(tree.getChild(1), data, local);
		Object right = VisitSubTree(tree.getChild(2), data, local);
		java.util.Date now = null;
		java.util.Date date = null;

		if (left == null) {
			return null;
		}
		if (right == null) {
			return null;
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (left instanceof Date) {
			now = (Date) left;
		} else {
			now = df.parse(String.valueOf(left));
		}

		if (right instanceof Date) {
			date = (Date) right;
		} else {
			// date = df.parse(String.valueOf(right));
			date = DateHelper.convertToDate(String.valueOf(right));
		}

		// now = left instanceof Date ? (Date)left :
		// df.parse(String.valueOf(left));
		// date = right instanceof Date ? (Date)right :
		// df.parse(String.valueOf(right));

		long l = now.getTime() - date.getTime();
		return l / (24 * 60 * 60 * 1000);
	}

	/**
	 * 
	 * @param tree
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private Object CONTAIN(Tree tree, Object data, Object local)
			throws Exception {
		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		if (value1 == null) {
			return null;
		}
		Object value2 = VisitSubTree(tree.getChild(2), data, local);
		if (value2 == null) {
			return null;
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date now = df.parse(String.valueOf(value1));
		java.util.Date date = df.parse(String.valueOf(value2));
		long l = now.getTime() - date.getTime();
		return l / (24 * 60 * 60 * 1000);
	}

	private Object filter(Tree tree, Object data, Object local)
			throws Exception {
		ArrayList<?> collection = (ArrayList<?>) VisitSubTree(
				_tree.getChild(1), data, local);
		String key = (String) VisitSubTree(_tree.getChild(2), data, local);
		String filter = (String) VisitSubTree(_tree.getChild(3), data, local);
		HashMap<String, Object> hpData = (HashMap<String, Object>) data;
		HashMap<String, Object> localHm = (HashMap<String, Object>) local;
		return ExpressionFunctionHelper.filter(collection, key, filter, hpData,
				localHm);
	}

	private Object count(Tree tree, Object data, Object local) throws Exception {
		if (_tree.getChildCount() - 1 == 1) {
			Object value1 = VisitSubTree(tree.getChild(1), data, local);
			if (value1 == null) {
				return null;
			}
			ArrayList collection = (ArrayList) VisitSubTree(_tree.getChild(1),
					data, local);
			return ExpressionFunctionHelper.count(collection);
		} else {
			Object value1 = VisitSubTree(tree.getChild(1), data, local);
			Object value2 = VisitSubTree(tree.getChild(2), data, local);
			Object value3 = VisitSubTree(tree.getChild(3), data, local);
			if (value1 == null || value2 == null || value3 == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) value1;
			String key = (String) value2;
			String filter = (String) value3;
			HashMap<String, Object> hpData = (HashMap<String, Object>) data;
			HashMap<String, Object> hpLocal = (HashMap<String, Object>) local;
			return ExpressionFunctionHelper.count(collection, key, filter,
					hpData, hpLocal);
		}
	}

	private Object exist(Tree tree, Object data, Object local) throws Exception {

		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		Object value2 = VisitSubTree(tree.getChild(2), data, local);
		Object value3 = VisitSubTree(tree.getChild(3), data, local);
		if (value1 == null || value2 == null || value3 == null) {
			return null;
		}
		ArrayList<?> collection = (ArrayList<?>) value1;
		String key = (String) value2;
		String filter = (String) value3;
		HashMap<String, Object> hpData = (HashMap<String, Object>) data;
		HashMap<String, Object> hplocal = (HashMap<String, Object>) local;
		return ExpressionFunctionHelper.exist(collection, key, filter, hpData,
				hplocal);
	}

	private Object min(Tree tree, Object data, Object local) throws Exception {

		if (_tree.getChildCount() - 1 == 3) {
			Object value1 = VisitSubTree(tree.getChild(1), data, local);
			Object value2 = VisitSubTree(tree.getChild(2), data, local);
			Object value3 = VisitSubTree(tree.getChild(3), data, local);
			if (value1 == null || value2 == null || value3 == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) value1;
			String key = String.valueOf(value2);
			String exprCond = String.valueOf(value3); 
			return ExpressionFunctionHelper.min(collection, key, exprCond);
		} else if (_tree.getChildCount() - 1 == 4) {
			Object value1 = VisitSubTree(tree.getChild(1), data, local);
			Object value2 = VisitSubTree(tree.getChild(2), data, local);
			Object value3 = VisitSubTree(tree.getChild(3), data, local);
			Object value4 = VisitSubTree(tree.getChild(4), data, local);
			if (value1 == null || value2 == null || value3 == null
					|| value4 == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) value1;
			String key = String.valueOf(value2);
			String filterCond = String.valueOf(value3);
			String exprCond = String.valueOf(value4); 
			ArrayList<?> filterResult = getFilterObject(collection, key, filterCond);
			if (filterResult == null) {
				return null;
			}
			return ExpressionFunctionHelper.min(filterResult, key, exprCond);
		} else {
			return null;
		}
	}
	
	private ArrayList<?> getFilterObject(ArrayList list, String key, String filterCond){
		ArrayList resultList = new ArrayList();
		Boolean resultBoolean;
		HashMap<String, Object> hmdata = new HashMap<String, Object>();
		for (int i = 0; i < list.size(); i++) {
			hmdata.put(key, list.get(i));
			resultBoolean = (Boolean)new Expression().ExecuteExpression(filterCond, hmdata);
			if (resultBoolean) {
				resultList.add(list.get(i));
			}
		}
		return resultList;
	}

	private Object max(Tree tree, Object data, Object local) throws Exception {

		if (_tree.getChildCount() - 1 == 3) {
			Object value1 = VisitSubTree(tree.getChild(1), data, local);
			Object value2 = VisitSubTree(tree.getChild(2), data, local);
			Object value3 = VisitSubTree(tree.getChild(3), data, local);
			if (value1 == null || value2 == null || value3 == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) value1;
			String key = String.valueOf(value2);
			String fieldCond = String.valueOf(value3); 
			return ExpressionFunctionHelper.max(collection, key, fieldCond);
		} else if (_tree.getChildCount() - 1 == 4) {
			Object value1 = VisitSubTree(tree.getChild(1), data, local);
			Object value2 = VisitSubTree(tree.getChild(2), data, local);
			Object value3 = VisitSubTree(tree.getChild(3), data, local);
			Object value4 = VisitSubTree(tree.getChild(4), data, local);
			if (value1 == null || value2 == null || value3 == null
					|| value4 == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) value1;
			String key = String.valueOf(value2);
			String filterCond = String.valueOf(value3);
			String fieldCond = String.valueOf(value4); 
			ArrayList<?> filterResult = getFilterObject(collection, key, filterCond);
			if (filterResult == null) {
				return null;
			}
			return ExpressionFunctionHelper.max(filterResult, key, fieldCond);
		} else {
			return null;
		}
	}

	private Object sum(Tree tree, Object data, Object local) throws Exception {

		if (_tree.getChildCount() - 1 == 3) {
			Object value1 = VisitSubTree(tree.getChild(1), data, local);
			Object value2 = VisitSubTree(tree.getChild(2), data, local);
			Object value3 = VisitSubTree(tree.getChild(3), data, local);
			if (value1 == null || value2 == null || value3 == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) value1;
			String key = String.valueOf(value2);
			String fieldCond = String.valueOf(value3); 
			return ExpressionFunctionHelper.sum(collection, key, fieldCond);
		} else if (_tree.getChildCount() - 1 == 4) {
			Object value1 = VisitSubTree(tree.getChild(1), data, local);
			Object value2 = VisitSubTree(tree.getChild(2), data, local);
			Object value3 = VisitSubTree(tree.getChild(3), data, local);
			Object value4 = VisitSubTree(tree.getChild(4), data, local);
			if (value1 == null || value2 == null || value3 == null
					|| value4 == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) value1;
			String key = String.valueOf(value2);
			String filterCond = String.valueOf(value3);
			String fieldCond = String.valueOf(value4); 
			ArrayList<?> filterResult = getFilterObject(collection, key, filterCond);
			if (filterResult == null) {
				return null;
			}
			return ExpressionFunctionHelper.sum(filterResult, key, fieldCond);
		} else {
			return null;
		}
	}

	private Object avg(Tree tree, Object data, Object local) throws Exception {

		if (_tree.getChildCount() - 1 == 3) {
			Object value1 = VisitSubTree(tree.getChild(1), data, local);
			Object value2 = VisitSubTree(tree.getChild(2), data, local);
			Object value3 = VisitSubTree(tree.getChild(3), data, local);
			if (value1 == null || value2 == null || value3 == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) value1;
			String key = String.valueOf(value2);
			String fieldCond = String.valueOf(value3); 
			return ExpressionFunctionHelper.avg(collection, key, fieldCond);
		} else if (_tree.getChildCount() - 1 == 4) {
			Object value1 = VisitSubTree(tree.getChild(1), data, local);
			Object value2 = VisitSubTree(tree.getChild(2), data, local);
			Object value3 = VisitSubTree(tree.getChild(3), data, local);
			Object value4 = VisitSubTree(tree.getChild(4), data, local);
			if (value1 == null || value2 == null || value3 == null
					|| value4 == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) value1;
			String key = String.valueOf(value2);
			String filterCond = String.valueOf(value3);
			String fieldCond = String.valueOf(value4); 
			ArrayList<?> filterResult = getFilterObject(collection, key, filterCond);
			if (filterResult == null) {
				return null;
			}
			return ExpressionFunctionHelper.avg(filterResult, key, fieldCond);
		} else {
			return null;
		}
	}

	private Object existKey(Tree tree, Object data, Object local)
			throws Exception {

		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		if (value1 == null) {
			return null;
		}
		String key = (String) value1;
		HashMap<String, Object> hpData = (HashMap<String, Object>) data;
		HashMap<String, Object> hplocal = (HashMap<String, Object>) local;
		return ExpressionFunctionHelper.existKey(key, hpData, hplocal);
	}

	private Object isNull(Tree tree, Object data, Object local)
			throws Exception {
		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		if (value1 == null) {
			return null;
		}
		if (value1 == null) {
			return null;
		}
		Object obj = (String) value1;
		return ExpressionFunctionHelper.isNull(obj);
	}

	private Object isNotNull(Tree tree, Object data, Object local)
			throws Exception {
		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		if (value1 == null ) {
			return null;
		}

		Object obj = (String) value1;
		return ExpressionFunctionHelper.isNotNull(obj);
	}

	private Object isDate(Tree tree, Object data, Object local)
			throws Exception {
		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		if (value1 == null) {
			return null;
		}
		return ExpressionFunctionHelper.isDate(value1);
	}

	private Object toDate(Tree tree, Object data, Object local)
			throws Exception {
		Object value1 = VisitSubTree(tree.getChild(1), data, local);
		if (value1 == null) {
			return null;
		}
		String str = (String) value1;
		return ExpressionFunctionHelper.toDate(str);
	}

	@Override
	public Object Evaluate(Object data) throws Exception {
		return Evaluate(data, null);
	}

	@Override
	public Object Evaluate() {
		// TODO Auto-generated method stub
		return null;
	}
}