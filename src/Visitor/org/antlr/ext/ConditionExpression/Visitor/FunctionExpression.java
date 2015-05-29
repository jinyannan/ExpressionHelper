﻿package org.antlr.ext.ConditionExpression.Visitor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.antlr.ext.ConditionExpression.Utility.Compare;
import org.antlr.ext.ConditionExpression.Utility.DataType;
import org.antlr.runtime.tree.Tree;
import org.antlr.ext.ConditionExpression.Utility.StringUtility;
import org.antlr.grammar.v3.ANTLRParser.range_return;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FunctionExpression extends BaseExpression {
	public FunctionExpression(BaseExpression exp, Tree tree) {
		super(exp, tree);
	}

	@Override
	public Object Evaluate(Object data) throws Exception {
		double value;
		String funcName = _tree.getChild(0).toString();
		// C# TO JAVA CONVERTER NOTE: The following 'switch' operated on a
		// string member and was converted to Java 'if-else' logic:
		// switch (funcName.ToUpper())
		// ORIGINAL LINE: case "BT":
		if (funcName.toUpperCase().equals("BT")) {
			CheckMinParamCount(funcName, 2);
			return BT(_tree, data);
		}
		// ORIGINAL LINE: case "IN":
		else if (funcName.toUpperCase().equals("IN")) {
			CheckMinParamCount(funcName, 2);
			return IN(_tree, data);
		}
		// ORIGINAL LINE: case "IIF":
		else if (funcName.toUpperCase().equals("IIF")) {
			CheckParamCount(funcName, 3);
			return IIF(_tree, data);

		}
		// ORIGINAL LINE: case "MID":
		else if (funcName.toUpperCase().equals("MID")) {
			CheckParamCount(funcName, 3);
			return MID(_tree, data);
		}
		// ORIGINAL LINE: case "LEFT":
		else if (funcName.toUpperCase().equals("LEFT")) {
			CheckParamCount(funcName, 2);
			return LEFT(_tree, data);
		}
		// ORIGINAL LINE: case "RIGHT":
		else if (funcName.toUpperCase().equals("RIGHT")) {
			CheckParamCount(funcName, 2);
			return RIGHT(_tree, data);
		} else if (funcName.toUpperCase().equals("TRIM")) {
			CheckParamCount(funcName, 2);
			return RIGHT(_tree, data);
		}
		// ORIGINAL LINE: case "LEN":
		else if (funcName.toUpperCase().equals("LEN")) {
			CheckParamCount(funcName, 1);
			return LEN(_tree, data);
		}

		else if (funcName.toUpperCase().equals("UPPER")) {
			CheckParamCount(funcName, 2);
			return UPPER(_tree, data);
		} else if (funcName.toUpperCase().equals("LOWER")) {
			CheckParamCount(funcName, 2);
			return LOWER(_tree, data);
		}
		// ORIGINAL LINE: case "INSTR":
		else if (funcName.toUpperCase().equals("INSTR")) {
			CheckParamCount(funcName, 2);
			return INSTR(_tree, data);
		}
		// ORIGINAL LINE: case "LIKE":
		else if (funcName.toUpperCase().equals("LIKE")) {
			CheckParamCount(funcName, 2);
			return LIKE(_tree, data);
		} else if (funcName.toUpperCase().equals("CHARINDEX")) {
			CheckParamCount(funcName, 1);
			return CHARINDEX(_tree, data);
		}
		// ORIGINAL LINE: case "INT":
		else if (funcName.toUpperCase().equals("INT")) // /向下取整
		{
			CheckParamCount(funcName, 1);
			value = Double.parseDouble(VisitSubTree(_tree.getChild(1), data)
					.toString());
			return (int) Math.floor(value);
		}
		// ORIGINAL LINE: case "SQRT":
		else if (funcName.toUpperCase().equals("SQRT")) {
			CheckParamCount(funcName, 1);
			value = Double.parseDouble(VisitSubTree(_tree.getChild(1), data)
					.toString());
			return Math.sqrt(value);

		}

		/**
		 * 计算日期类型 Aardwolf.K
		 */
		// ORIGINAL LINE: case "DAYOFWEEK":
		// FIXME
		else if (funcName.toUpperCase().equals("DAYOFWEEK")) {
			CheckParamCount(funcName, 0);
			Calendar c = Calendar.getInstance();
			// return (int)Calendar.DAY_OF_WEEK-1; ///周日是0，周六是6
			return (int) (c.get(Calendar.DAY_OF_WEEK) - 1);
		} else if (funcName.toUpperCase().equals("DATEDIFF")) {
			CheckParamCount(funcName, 2);
			return DATEDIFF(_tree, data);
		}
		// ORIGINAL LINE: case "NOW":
		else if (funcName.toUpperCase().equals("NOW")) {
			CheckParamCount(funcName, 0);
			return new java.util.Date();
		}
		// ORIGINAL LINE: case "DATE":
		else if (funcName.toUpperCase().equals("DATE")) {
			CheckParamCount(funcName, 0);
			return new Date();
		}
		// ORIGINAL LINE: case "TIME":
		else if (funcName.toUpperCase().equals("TIME")) {
			CheckParamCount(funcName, 0);
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

			return formatter.format(new Date());
			// return new Date().ToString("HH:mm:ss");
		}
		// ORIGINAL LINE: case "HOUR":
		// FIXME 此处是否返回当天小时
		else if (funcName.toUpperCase().equals("HOUR")) {
			CheckParamCount(funcName, 0);
			Calendar ca = Calendar.getInstance();
			// return new Date().getHours();
			return ca.get(Calendar.HOUR_OF_DAY);
		}
		// ORIGINAL LINE: case "YEAR":
		// FIXME
		else if (funcName.toUpperCase().equals("YEAR")) {
			CheckParamCount(funcName, 0);
			Calendar ca = Calendar.getInstance();
			// return new java.util.Date().getYear();
			return ca.get(Calendar.YEAR);
		}
		// ORIGINAL LINE: case "MONTH":
		else if (funcName.toUpperCase().equals("MONTH")) {
			CheckParamCount(funcName, 0);
			Calendar ca = Calendar.getInstance();
			// return new java.util.Date().getMonth();
			return ca.get(Calendar.MONTH) + 1;
		}
		// ORIGINAL LINE: case "DAY":
		// FIXME error
		else if (funcName.toUpperCase().equals("DAY")) {
			CheckParamCount(funcName, 0);
			// return new java.util.Date().getDay();
			Calendar ca = Calendar.getInstance();
			return ca.get(Calendar.DATE);
		} else if (funcName.toUpperCase().equals("ISNULL")) {
			CheckParamCount(funcName, 1);
			return (Boolean) (VisitSubTree(_tree.getChild(1), data) == null);
		} else if (funcName.equalsIgnoreCase("IsNotNull")) {
			CheckParamCount(funcName, 1);
			return (Boolean) (VisitSubTree(_tree.getChild(1), data) != null);
		} else if (funcName.toUpperCase().equals("EXISTOBJECT")) {
			return true;
		} else if (funcName.toUpperCase().equals("GLOBALVAR")) {
			return "0";
		}
		/**
		 * 集合函数
		 */
		else if (funcName.equalsIgnoreCase("filter")) {
			return filter(_tree, data);
		} else if (funcName.equalsIgnoreCase("Count")) {
			return count(_tree, data);
		} else if (funcName.equalsIgnoreCase("Exist")) {
			return exist(_tree, data);
		} else if (funcName.equalsIgnoreCase("Min")) {
			return min(_tree, data);
		} else if (funcName.equalsIgnoreCase("Max")) {
			return max(_tree, data);
		} else if (funcName.equalsIgnoreCase("Sum")) {
			return sum(_tree, data);
		} else if (funcName.equalsIgnoreCase("Avg")) {
			return avg(_tree, data);
		} else if (funcName.equalsIgnoreCase("rand")) {
			return Math.random();
		} else if (funcName.equalsIgnoreCase("ExistKey")) {
			return existKey(_tree, data);
		} else if (funcName.equalsIgnoreCase("IsNull")) {
			return isNull(_tree, data);
		} else if (funcName.equalsIgnoreCase("IsNotNull")) {
			return isNotNull(_tree, data);
		} else if (funcName.equalsIgnoreCase("GlobalVar")) {
			return true;
		} else if (funcName.equalsIgnoreCase("Valid")) {
			return null;
		} else if (funcName.equalsIgnoreCase("IsDate")) {
			return isDate(_tree, data);
		} else if (funcName.equalsIgnoreCase("ToDate")) {
			return toDate(_tree, data);
		} else {
			return CallUserFunction(funcName, _tree, data);
		}
	}

	private Object CallUserFunction(String funcName, Tree tree, Object data)
			throws Exception {
		java.util.ArrayList<Object> funParams = new java.util.ArrayList<Object>();
		for (int i = 1; i < tree.getChildCount(); i++) {
			funParams.add(VisitSubTree(tree.getChild(i), data));
		}

		if (this.getUserFunction() != null) {
			// C# TO JAVA CONVERTER TODO TASK: There is no Java equivalent to
			// the C# 'Object' keyword:
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

	/**
	 * 处理形如BT(aaa,1,3,6,9,11)这样的函数 即：(aaa>1 && aaa<3) || (aaa>6 && aaa<9) ||
	 * (aaa>11)
	 * 
	 * @param tree
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private Object BT(Tree tree, Object data) throws Exception {
		/**
		 * Aardwolf.K 如果数据库为null，则返回false
		 */
		if (VisitSubTree(tree.getChild(1), data) == null) {
			return false;
		}

		Object value = VisitSubTree(tree.getChild(1), data);

		for (int i = 2; i < tree.getChildCount(); i += 2) {
			if (Compare.IsGreaterOrEqual(value,
					VisitSubTree(tree.getChild(i), data))) {
				if (i + 1 >= tree.getChildCount()) // /如果只有小值，那待比较值比小值大就返回true
				{
					return true;
				} else if (Compare.IsLessOrEqual(value,
						VisitSubTree(tree.getChild(i + 1), data))) {
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
	 * @param tree
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private Object IN(Tree tree, Object data) throws Exception {
		Object value = VisitSubTree(tree.getChild(1), data);
		for (int i = 2; i < tree.getChildCount(); i++) {
			/**
			 * 碰到第一个相等的就退出
			 */
			if (Compare.AreEqual(value, VisitSubTree(tree.getChild(i), data))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param tree
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private Object IIF(Tree tree, Object data) throws Exception {
		boolean condition = Boolean.parseBoolean(VisitSubTree(tree.getChild(1),
				data).toString());
		if (condition) {
			return VisitSubTree(tree.getChild(2), data);
		} else {
			return VisitSubTree(tree.getChild(3), data);
		}
	}

	private Object MID(Tree tree, Object data) throws NumberFormatException,
			Exception {
		/**
		 * Aardwolf.K 如果数据库为null，则返回false
		 */
		if (VisitSubTree(tree.getChild(1), data) == null) {
			return "";
		}
		if (VisitSubTree(tree.getChild(2), data) == null) {
			return "";
		}
		if (VisitSubTree(tree.getChild(3), data) == null) {
			return "";
		}

		String str = String.valueOf(VisitSubTree(tree.getChild(1), data));
		int from = Integer.parseInt(VisitSubTree(tree.getChild(2), data)
				.toString());
		int length = Integer.parseInt(VisitSubTree(tree.getChild(3), data)
				.toString());

		/**
		 * 为了跟老版本兼容，采用1为起始坐标 判断一下是否合法
		 */
		return StringUtility.Mid(str, from, length);
	}

	private Object LEFT(Tree tree, Object data) throws Exception {
		/**
		 * Aardwolf.K 如果数据库为null，则返回false
		 */
		if (VisitSubTree(tree.getChild(1), data) == null) {
			return "";
		}
		if (VisitSubTree(tree.getChild(2), data) == null) {
			return "";
		}
		String str = String.valueOf(VisitSubTree(tree.getChild(1), data));
		int length = Integer.parseInt(VisitSubTree(tree.getChild(2), data)
				.toString());
		// StringUtility.Mid(str, from, length);
		return StringUtility.Left(str, length);
	}

	private Object RIGHT(Tree tree, Object data) throws Exception {
		/**
		 * Aardwolf.K 如果数据库为null，则返回false
		 */
		if (VisitSubTree(tree.getChild(1), data) == null) {
			return "";
		}
		if (VisitSubTree(tree.getChild(2), data) == null) {
			return "";
		}
		String str = String.valueOf(VisitSubTree(tree.getChild(1), data));
		int length = Integer.parseInt(VisitSubTree(tree.getChild(2), data)
				.toString());

		return StringUtility.Right(str, length);
	}

	private Object UPPER(Tree tree, Object data) throws Exception {
		/**
		 * Aardwolf.K 如果数据库为null，则返回false
		 */
		if (VisitSubTree(tree.getChild(1), data) == null) {
			return "";
		}
		String str = String.valueOf(VisitSubTree(tree.getChild(1), data));

		return str.toUpperCase();
	}

	private Object LOWER(Tree tree, Object data) throws Exception {
		/**
		 * Aardwolf.K 如果数据库为null，则返回false
		 */
		if (VisitSubTree(tree.getChild(1), data) == null) {
			return "";
		}
		String str = String.valueOf(VisitSubTree(tree.getChild(1), data));

		return str.toLowerCase();
	}

	private Object TRIM(Tree tree, Object data) throws Exception {
		/**
		 * Aardwolf.K 如果数据库为null，则返回false
		 */
		if (VisitSubTree(tree.getChild(1), data) == null) {
			return "";
		}
		String str = String.valueOf(VisitSubTree(tree.getChild(1), data));

		return str.trim();
	}

	private Object LEN(Tree tree, Object data) throws Exception {
		/**
		 * Aardwolf.K 如果数据库为null，则返回0
		 */
		if (VisitSubTree(tree.getChild(1), data) == null) {
			return 0;
		}
		String str = String.valueOf(VisitSubTree(tree.getChild(1), data)
				.toString());
		return str.length();
	}

	private Object INSTR(Tree tree, Object data) throws Exception {
		/**
		 * Aardwolf.K 如果数据库为null，则返回false
		 */
		if (VisitSubTree(tree.getChild(1), data) == null) {
			return false;
		}
		if (VisitSubTree(tree.getChild(2), data) == null) {
			return false;
		}

		String str = String.valueOf(VisitSubTree(tree.getChild(1), data));
		String find = String.valueOf(VisitSubTree(tree.getChild(2), data));

		return str.indexOf(find) > -1;
	}

	private Object LIKE(Tree tree, Object data) throws Exception {
		/**
		 * Aardwolf.K 如果数据库为null，则返回false
		 */
		if (VisitSubTree(tree.getChild(1), data) == null) {
			return false;
		}
		if (VisitSubTree(tree.getChild(2), data) == null) {
			return false;
		}
		String str = String.valueOf(VisitSubTree(tree.getChild(1), data));
		String find = String.valueOf(VisitSubTree(tree.getChild(2), data));
		return str.matches(find);
	}

	private Object CHARINDEX(Tree tree, Object data) throws Exception {
		/**
		 * Aardwolf.K 如果数据库为null，则返回false
		 */
		if (VisitSubTree(tree.getChild(1), data) == null) {
			return false;
		}
		if (VisitSubTree(tree.getChild(2), data) == null) {
			return false;
		}

		String str = String.valueOf(VisitSubTree(tree.getChild(1), data));
		String find = String.valueOf(VisitSubTree(tree.getChild(2), data));

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
	 * 返回两个日期相差的天数
	 * 
	 * @param tree
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private Object DATEDIFF(Tree tree, Object data) throws Exception {

		if (VisitSubTree(tree.getChild(1), data) == null) {
			return null;
		}
		if (VisitSubTree(tree.getChild(2), data) == null) {
			return null;
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date now = df.parse(String.valueOf(VisitSubTree(
				tree.getChild(1), data)));
		java.util.Date date = df.parse(String.valueOf(VisitSubTree(
				tree.getChild(2), data)));
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
	private Object CONTAIN(Tree tree, Object data) throws Exception {

		if (VisitSubTree(tree.getChild(1), data) == null) {
			return null;
		}
		if (VisitSubTree(tree.getChild(2), data) == null) {
			return null;
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date now = df.parse(String.valueOf(VisitSubTree(
				tree.getChild(1), data)));
		java.util.Date date = df.parse(String.valueOf(VisitSubTree(
				tree.getChild(2), data)));
		long l = now.getTime() - date.getTime();
		return l / (24 * 60 * 60 * 1000);
	}

	private Object filter(Tree tree, Object data) throws Exception {
		ArrayList<?> collection = (ArrayList<?>) VisitSubTree(
				_tree.getChild(1), data);
		String key = (String) VisitSubTree(_tree.getChild(2), data);
		String filter = (String) VisitSubTree(_tree.getChild(3), data);
		HashMap<String, Object> hpData = (HashMap<String, Object>) data;
		HashMap<String, Object> local = new HashMap<String, Object>();
		return ExpressionFunctionHelper.filter(collection, key, filter, hpData,
				local);
	}

	private Object count(Tree tree, Object data) throws Exception {
		if (_tree.getChildCount() - 1 == 1) {
			if (VisitSubTree(tree.getChild(1), data) == null) {
				return null;
			}
			ArrayList collection = (ArrayList) VisitSubTree(
					_tree.getChild(1), data);
			return ExpressionFunctionHelper.count(collection);
		} else {
			if (VisitSubTree(tree.getChild(1), data) == null
					|| VisitSubTree(tree.getChild(2), data) == null
					|| VisitSubTree(tree.getChild(3), data) == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) VisitSubTree(
					_tree.getChild(1), data);
			String key = (String) VisitSubTree(_tree.getChild(2), data);
			String filter = (String) VisitSubTree(_tree.getChild(3), data);
			HashMap<String, Object> hpData = (HashMap<String, Object>) data;
			HashMap<String, Object> local = new HashMap<String, Object>();
			return ExpressionFunctionHelper.count(collection, key, filter,
					hpData, local);
		}
	}

	private Object exist(Tree tree, Object data) throws Exception {

		if (VisitSubTree(tree.getChild(1), data) == null
				|| VisitSubTree(tree.getChild(2), data) == null
				|| VisitSubTree(tree.getChild(3), data) == null) {
			return null;
		}
		ArrayList<?> collection = (ArrayList<?>) VisitSubTree(
				_tree.getChild(1), data);
		String key = (String) VisitSubTree(_tree.getChild(2), data);
		String filter = (String) VisitSubTree(_tree.getChild(3), data);
		HashMap<String, Object> hpData = (HashMap<String, Object>) data;
		HashMap<String, Object> local = new HashMap<String, Object>();
		return ExpressionFunctionHelper.exist(collection, key, filter, hpData,
				local);
	}
	
	private Object min(Tree tree, Object data) throws Exception {

		if (_tree.getChildCount() - 1 == 2) {
			if (VisitSubTree(tree.getChild(1), data) == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) VisitSubTree(
					_tree.getChild(1), data);
			String field = String.valueOf(VisitSubTree(
					_tree.getChild(1), data));
			return ExpressionFunctionHelper.min(collection, field);
		} else if (_tree.getChildCount() - 1 == 4) {
			if (VisitSubTree(tree.getChild(1), data) == null
					|| VisitSubTree(tree.getChild(2), data) == null
					|| VisitSubTree(tree.getChild(3), data) == null
					|| VisitSubTree(tree.getChild(4), data) == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) VisitSubTree(
					_tree.getChild(1), data);
			String key = (String) VisitSubTree(_tree.getChild(2), data);
			String filter = (String) VisitSubTree(_tree.getChild(3), data);
			String field = (String) VisitSubTree(_tree.getChild(4), data);
			HashMap<String, Object> hpData = (HashMap<String, Object>) data;
			HashMap<String, Object> local = new HashMap<String, Object>();
			return ExpressionFunctionHelper.min(collection, key, field, filter,
					hpData, local);
		}else {
			return null;
		}
	}

	private Object max(Tree tree, Object data) throws Exception {

		if (_tree.getChildCount() - 1 == 2) {
			if (VisitSubTree(tree.getChild(1), data) == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) VisitSubTree(
					_tree.getChild(1), data);
			String field = String.valueOf(VisitSubTree(
					_tree.getChild(1), data));
			return ExpressionFunctionHelper.max(collection, field);
		} else if (_tree.getChildCount() - 1 == 4) {
			if (VisitSubTree(tree.getChild(1), data) == null
					|| VisitSubTree(tree.getChild(2), data) == null
					|| VisitSubTree(tree.getChild(3), data) == null
					|| VisitSubTree(tree.getChild(4), data) == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) VisitSubTree(
					_tree.getChild(1), data);
			String key = (String) VisitSubTree(_tree.getChild(2), data);
			String filter = (String) VisitSubTree(_tree.getChild(3), data);
			String field = (String) VisitSubTree(_tree.getChild(4), data);
			HashMap<String, Object> hpData = (HashMap<String, Object>) data;
			HashMap<String, Object> local = new HashMap<String, Object>();
			return ExpressionFunctionHelper.max(collection, key, field, filter,
					hpData, local);
		}else {
			return null;
		}
	}
	
	private Object sum(Tree tree, Object data) throws Exception {

		if (_tree.getChildCount() - 1 == 2) {
			if (VisitSubTree(tree.getChild(1), data) == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) VisitSubTree(
					_tree.getChild(1), data);
			String field = String.valueOf(VisitSubTree(
					_tree.getChild(1), data));
			return ExpressionFunctionHelper.sum(collection, field);
		} else if (_tree.getChildCount() - 1 == 4) {
			if (VisitSubTree(tree.getChild(1), data) == null
					|| VisitSubTree(tree.getChild(2), data) == null
					|| VisitSubTree(tree.getChild(3), data) == null
					|| VisitSubTree(tree.getChild(4), data) == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) VisitSubTree(
					_tree.getChild(1), data);
			String key = (String) VisitSubTree(_tree.getChild(2), data);
			String filter = (String) VisitSubTree(_tree.getChild(3), data);
			String field = (String) VisitSubTree(_tree.getChild(4), data);
			HashMap<String, Object> hpData = (HashMap<String, Object>) data;
			HashMap<String, Object> local = new HashMap<String, Object>();
			return ExpressionFunctionHelper.sum(collection, key, field, filter,
					hpData, local);
		}else {
			return null;
		}
	}
	
	private Object avg(Tree tree, Object data) throws Exception {

		if (_tree.getChildCount() - 1 == 2) {
			if (VisitSubTree(tree.getChild(1), data) == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) VisitSubTree(
					_tree.getChild(1), data);
			String field = String.valueOf(VisitSubTree(
					_tree.getChild(1), data));
			return ExpressionFunctionHelper.avg(collection, field);
		} else if (_tree.getChildCount() - 1 == 4) {
			if (VisitSubTree(tree.getChild(1), data) == null
					|| VisitSubTree(tree.getChild(2), data) == null
					|| VisitSubTree(tree.getChild(3), data) == null
					|| VisitSubTree(tree.getChild(4), data) == null) {
				return null;
			}
			ArrayList<?> collection = (ArrayList<?>) VisitSubTree(
					_tree.getChild(1), data);
			String key = (String) VisitSubTree(_tree.getChild(2), data);
			String filter = (String) VisitSubTree(_tree.getChild(3), data);
			String field = (String) VisitSubTree(_tree.getChild(4), data);
			HashMap<String, Object> hpData = (HashMap<String, Object>) data;
			HashMap<String, Object> local = new HashMap<String, Object>();
			return ExpressionFunctionHelper.avg(collection, key, field, filter,
					hpData, local);
		}else {
			return null;
		}
	}
	
	private Object existKey(Tree tree, Object data) throws Exception{
		if (VisitSubTree(tree.getChild(1), data) == null) {
			return null;
		}
		String key = (String) VisitSubTree(_tree.getChild(1), data);
		HashMap<String, Object> hpData = (HashMap<String, Object>) data;
		HashMap<String, Object> local = new HashMap<String, Object>();
		return ExpressionFunctionHelper.existKey(key, hpData, local);
	}
	
	private Object isNull(Tree tree, Object data) throws Exception{
		if (VisitSubTree(tree.getChild(1), data) == null) {
			return null;
		}
		Object obj = (String) VisitSubTree(_tree.getChild(1), data);
		return ExpressionFunctionHelper.isNull(obj);
	}
	
	private Object isNotNull(Tree tree, Object data) throws Exception{
		if (VisitSubTree(tree.getChild(1), data) == null) {
			return null;
		}
		Object obj = (String) VisitSubTree(_tree.getChild(1), data);
		return ExpressionFunctionHelper.isNotNull(obj);
	}
	
	private Object isDate(Tree tree, Object data) throws Exception{
		if (VisitSubTree(tree.getChild(1), data) == null) {
			return null;
		}
		Object obj = (String) VisitSubTree(_tree.getChild(1), data);
		return ExpressionFunctionHelper.isDate(obj);
	}
	
	private Object toDate(Tree tree, Object data) throws Exception{
		if (VisitSubTree(tree.getChild(1), data) == null) {
			return null;
		}
		String str = (String) VisitSubTree(_tree.getChild(1), data);
		return ExpressionFunctionHelper.toDate(str);
	}
}