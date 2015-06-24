package org.antlr.ext.ConditionExpression.Visitor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.antlr.codegen.ObjCTarget;
import org.antlr.ext.ConditionExpression.Generated.ExpressionParser.boolLiteral_return;
import org.antlr.ext.ConditionExpression.Utility.Compare;
import org.antlr.ext.ConditionExpression.Utility.DataType;
import org.antlr.ext.ConditionExpression.Utility.ReflectionHelper;
import org.antlr.runtime.tree.Tree;
import org.antlr.ext.ConditionExpression.Utility.StringUtility;
import org.antlr.grammar.v3.ANTLRParser.range_return;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.LocalAttribute;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class TypeFunctionExpression extends TypeExpression {
	public TypeFunctionExpression(BaseExpression exp, Tree tree) {
		super(exp, tree);
	}

	@Override
	public Object Evaluate(Object data, Object local) throws Exception {
		double value;
		String funcName = _tree.getChild(0).toString();
		if (funcName.toUpperCase().equals("BT")) {
			return BT(funcName);
		} else if (funcName.toUpperCase().equals("IN")) {
			return IN(funcName);
		} else if (funcName.toUpperCase().equals("IIF")) {
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
			CheckParamCount(funcName, 2);
			return RIGHT(_tree, data, local);
		} else if (funcName.toUpperCase().equals("LEN")) {
			CheckParamCount(funcName, 1);
			return LEN(_tree, data, local);
		} else if (funcName.toUpperCase().equals("UPPER")) {
			CheckParamCount(funcName, 2);
			return UPPER(_tree, data, local);
		} else if (funcName.toUpperCase().equals("LOWER")) {
			CheckParamCount(funcName, 2);
			return LOWER(_tree, data, local);
		} else if (funcName.toUpperCase().equals("INSTR")) {
			CheckParamCount(funcName, 2);
			return INSTR(_tree, data, local);
		} else if (funcName.toUpperCase().equals("LIKE")) {
			CheckParamCount(funcName, 2);
			return LIKE(_tree, data, local);
		} else if (funcName.toUpperCase().equals("CHARINDEX")) {
			CheckParamCount(funcName, 1);
			return CHARINDEX(_tree, data, local);
		} else if (funcName.toUpperCase().equals("INT")) {
			CheckParamCount(funcName, 1);
			return INT(_tree, data, local);
		} else if (funcName.toUpperCase().equals("SQRT")) {
			CheckParamCount(funcName, 1);
			return SQRT(_tree, data, local);
		}
		/**
		 * 计算日期类型 Aardwolf.K
		 */
		else if (funcName.toUpperCase().equals("DAYOFWEEK")) {
			return intClass();
		} else if (funcName.toUpperCase().equals("DATEDIFF")) {
			CheckParamCount(funcName, 2);
			return DATEDIFF(_tree, data, local);
		} else if (funcName.toUpperCase().equals("NOW")) {
			return NOW(funcName);
		} else if (funcName.toUpperCase().equals("DATE")) {
			return NOW(funcName);
		} else if (funcName.toUpperCase().equals("TIME")) {
			return TIME(funcName);
		} else if (funcName.toUpperCase().equals("HOUR")) {
			CheckParamCount(funcName, 0);
			return intClass();
		}
		// FIXME
		else if (funcName.toUpperCase().equals("YEAR")) {
			CheckParamCount(funcName, 0);
			return intClass();
		} else if (funcName.toUpperCase().equals("MONTH")) {
			CheckParamCount(funcName, 0);
			return intClass();
		} else if (funcName.toUpperCase().equals("DAY")) {
			return intClass();
		} else if (funcName.toUpperCase().equals("ISNULL")) {
			CheckParamCount(funcName, 1);
			return Boolean.class;
		} else if (funcName.equalsIgnoreCase("IsNotNull")) {
			CheckParamCount(funcName, 1);
			return Boolean.class;
		} else if (funcName.toUpperCase().equals("EXISTOBJECT")) {
			return Boolean.class;
		} else if (funcName.toUpperCase().equals("GLOBALVAR")) {
			return Object.class;
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
			return null;
		} else if (funcName.equalsIgnoreCase("IsDate")) {
			return isDate(_tree, data, local);
		} else if (funcName.equalsIgnoreCase("ToDate")) {
			return toDate(_tree, data, local);
		} else {
			return CallUserFunction(funcName, _tree, data, local);
		}
	}

	private Object TIME(String funcName) {
		CheckParamCount(funcName, 0);
		return String.class;
	}

	private Object NOW(String funcName) {
		CheckParamCount(funcName, 0);
		return Date.class;
	}

	private Object intClass() {
		return Integer.class;
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

	/**
	 * 处理形如BT(aaa,1,3,6,9,11)这样的函数 即：(aaa>1 && aaa<3) || (aaa>6 && aaa<9) ||
	 * (aaa>11)
	 * 
	 * @param tree
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private Object BT(String funcName) throws Exception {
		CheckMinParamCount(funcName, 2);
		return Boolean.class;
	}

	/**
	 * @param tree
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private Object IN(String funcName) throws Exception {
		CheckMinParamCount(funcName, 2);
		return Boolean.class;
	}

	/**
	 * @param tree
	 * @param data
	 * @return
	 * @throws Exception
	 */
	private Object IIF(Tree tree, Object data, Object local) throws Exception {
		// return VisitSubTree(tree.getChild(2), data, local);
		return new TypeExpression(_tree.getChild(2)).Evaluate(data, local);
	}

	private Object MID(Tree tree, Object data, Object local)
			throws NumberFormatException, Exception {
		return String.class;
	}

	private Object LEFT(Tree tree, Object data, Object local) throws Exception {
		return String.class;
	}

	private Object RIGHT(Tree tree, Object data, Object local) throws Exception {
		return String.class;
	}

	private Object UPPER(Tree tree, Object data, Object local) throws Exception {
		return String.class;
	}

	private Object LOWER(Tree tree, Object data, Object local) throws Exception {
		return String.class;
	}

	private Object TRIM(Tree tree, Object data, Object local) throws Exception {
		return String.class;
	}

	private Object LEN(Tree tree, Object data, Object local) throws Exception {
		return String.class;
	}

	private Object INSTR(Tree tree, Object data, Object local) throws Exception {
		return Boolean.class;
	}

	private Object LIKE(Tree tree, Object data, Object local) throws Exception {
		return Boolean.class;
	}

	private Object CHARINDEX(Tree tree, Object data, Object local)
			throws Exception {
		return intClass();
	}

	private Object INT(Tree tree, Object data, Object local) throws Exception {
		return intClass();
	}

	private Object SQRT(Tree tree, Object data, Object local) throws Exception {
		return intClass();
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
	private Object DATEDIFF(Tree tree, Object data, Object local)
			throws Exception {

		return Integer.class;
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

		if (VisitSubTree(tree.getChild(1), data, local) == null) {
			return null;
		}
		if (VisitSubTree(tree.getChild(2), data, local) == null) {
			return null;
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date now = df.parse(String.valueOf(VisitSubTree(
				tree.getChild(1), data, local)));
		java.util.Date date = df.parse(String.valueOf(VisitSubTree(
				tree.getChild(2), data, local)));
		long l = now.getTime() - date.getTime();
		return l / (24 * 60 * 60 * 1000);
	}

	private Object filter(Tree tree, Object data, Object local)
			throws Exception {
		return VisitSubTree(_tree.getChild(1), data, local);
	}

	private Object count(Tree tree, Object data, Object local) throws Exception {
		return intClass();
	}

	private Object exist(Tree tree, Object data, Object local) throws Exception {

		return Boolean.class;
	}

	private Object min(Tree tree, Object data, Object local) throws Exception {
		return getAggregateReturnType(data, local);
	}

	private Object max(Tree tree, Object data, Object local) throws Exception {
		return getAggregateReturnType(data, local);
	}

	private Object getAggregateReturnType(Object data, Object local)
			throws Exception {
		Class<?> obj = (Class<?>) VisitSubTree(_tree.getChild(1), data, local);
		String propsname = _tree.getChild(_tree.getChildCount() - 1).getText();
		Object result;
		try {
			result = ReflectionHelper.getPropertyType(obj, (String) propsname);
		} catch (Exception e) {
			result = ReflectionHelper.getMethodReturnType(obj, propsname, null);
		}

		return result;
	}

	private Object sum(Tree tree, Object data, Object local) throws Exception {

		return getAggregateReturnType(data, local);
	}

	private Object avg(Tree tree, Object data, Object local) throws Exception {

		return getAggregateReturnType(data, local);
	}

	private Object existKey(Tree tree, Object data, Object local)
			throws Exception {
		return Boolean.class;
	}

	private Object isNull(Tree tree, Object data, Object local)
			throws Exception {
		return Boolean.class;
	}

	private Object isNotNull(Tree tree, Object data, Object local)
			throws Exception {
		return Boolean.class;
	}

	private Object isDate(Tree tree, Object data, Object local)
			throws Exception {
		return Boolean.class;
	}

	private Object toDate(Tree tree, Object data, Object local)
			throws Exception {
		return Date.class;
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