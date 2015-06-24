package org.antlr.ext.ConditionExpression.Visitor;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import org.antlr.ext.ConditionExpression.ExpressionException;
import org.antlr.ext.ConditionExpression.Generated.ExpressionLexer;
import org.antlr.ext.ConditionExpression.Utility.ReflectionHelper;
import org.antlr.runtime.tree.Tree;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class TypeExpression extends BaseExpression {

	public TypeExpression(Tree tree) {
		super(tree);
	}

	public TypeExpression(BaseExpression exp, Tree tree) {
		super(exp, tree);
	}
	
	@Override
	public Object VisitSubTree(Tree tree, Object data, Object local)
			throws Exception {
		return new TypeExpression(tree).Evaluate(data, local);
	}

	@Override
	public Object Evaluate() throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		HashMap<String, Object> local = new HashMap<String, Object>();
		Object object = Evaluate((Object) data, (Object) local);
		return object;
	}

	@Override
	@SuppressWarnings(value = { "unchecked", "unused" })
	public Object Evaluate(Object data, Object local) throws Exception {

		Object leftResult, rightResult;

		switch (_tree.getType()) {
		case ExpressionLexer.TYPE_INTEGER:
			return Integer.class;
		case ExpressionLexer.TYPE_STRING:
			return String.class;
		case ExpressionLexer.TYPE_DOUBLE:
			return Double.class;
		case ExpressionLexer.TYPE_BOOLEAN:
			return Boolean.class;
		case ExpressionLexer.TYPE_DATETIME:
			return java.util.Date.class;
		case ExpressionLexer.IDENTIFIER:
			return _tree.getText();
		case ExpressionLexer.PLUS:
			return mathPlus(
					new TypeExpression(_tree.getChild(0)).Evaluate(data, local),
					new TypeExpression(_tree.getChild(1)).Evaluate(data, local));
		case ExpressionLexer.MINUS:
			return mathMinus(
					new TypeExpression(_tree.getChild(0)).Evaluate(data, local),
					new TypeExpression(_tree.getChild(1)).Evaluate(data, local));
		case ExpressionLexer.MUL:
			return mathMul(
					new TypeExpression(_tree.getChild(0)).Evaluate(data, local),
					new TypeExpression(_tree.getChild(1)).Evaluate(data, local));
		case ExpressionLexer.DIV:
			return mathDiv(
					new TypeExpression(_tree.getChild(0)).Evaluate(data, local),
					new TypeExpression(_tree.getChild(1)).Evaluate(data, local));
		case ExpressionLexer.POW:
		case ExpressionLexer.AND:
			return logicAnd(
					new TypeExpression(_tree.getChild(0)).Evaluate(data, local),
					new TypeExpression(_tree.getChild(1)).Evaluate(data, local));
		case ExpressionLexer.OR:
			return logicOr(
					new TypeExpression(_tree.getChild(0)).Evaluate(data, local),
					new TypeExpression(_tree.getChild(1)).Evaluate(data, local));
		case ExpressionLexer.EQUALS:
		case ExpressionLexer.NOTEQUALS:
		case ExpressionLexer.GT:
		case ExpressionLexer.GTEQ:
		case ExpressionLexer.LT:
		case ExpressionLexer.LTEQ:
			return Boolean.class;
		case ExpressionLexer.DOT:
			return DOT(data, local);
		case ExpressionLexer.UNARY:
			return UNARY(data, local);
		case ExpressionLexer.DATA:
			return DATA(data, local);
		case ExpressionLexer.FUNCTION:
			return func(data, local);
		default:
			throw GetTreeException("无法识别的节点类型");
		}

	}

	private Object DATA(Object data, Object local) {
		String key = _tree.getText().substring(1, _tree.getText().length());
		return keyDollar(key, (HashMap<String, Object>) data,
				(HashMap<String, Object>) local);
	}

	private Object UNARY(Object data, Object local) throws Exception {
		Object rightResult;
		rightResult = new TypeExpression(_tree.getChild(1)).Evaluate(data,
				local);
		if (rightResult.equals(Integer.class)) {
			return Integer.class;
		} else {
			return Double.class;
		}
	}

	private Object DOT(Object data, Object local) throws Exception {
		Object leftResult;
		Object rightResult;
		leftResult = new TypeExpression(_tree.getChild(0)).Evaluate(data,
				local);
		rightResult = new TypeExpression(_tree.getChild(1)).Evaluate(data,
				local);

		if (rightResult instanceof FunctionInfo) {
			FunctionInfo f = (FunctionInfo) rightResult;
			return classMethodDot(leftResult, f);
		} else {
			return classPropertyDot(leftResult, rightResult.toString());
		}
	}

	@Override
	public Object Evaluate(Object data) throws Exception {
		return Evaluate(data, null);
	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object logicAnd(Object left, Object right) throws RuntimeException {
		return Boolean.class;
	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object logicOr(Object left, Object right) throws RuntimeException {
		return Boolean.class;
	}

	/**
	 * 
	 * @param o
	 */
	public Object logicNot(Object o) throws RuntimeException {
		return Boolean.class;
	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object mathMul(Object left, Object right) throws RuntimeException {
		if (left.equals(Double.class))
			return Double.class;
		if (right.equals(Double.class))
			return Double.class;

		return Integer.class;

	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object mathDiv(Object left, Object right) throws RuntimeException {

		if (left.equals(Double.class))
			return Double.class;
		if (right.equals(Double.class))
			return Double.class;

		return Integer.class;
	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object mathPlus(Object left, Object right) throws RuntimeException {
		// string
		if (left.equals(String.class) || right.equals(String.class))
			return String.class;
		// date
		if (left.equals(Date.class) || right.equals(Date.class))
			return Date.class;
		// double
		if (left.equals(Double.class) || right.equals(Double.class))
			return Double.class;
		// finally Integer
		return Integer.class;

	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object mathMinus(Object left, Object right) throws RuntimeException {

		// date
		if (left.equals(Date.class)) {
			if (right.equals(Date.class)) {
				return Integer.class;
			} else {
				return Date.class;
			}
		}

		// double
		if (left.equals(Double.class) || right.equals(Double.class))
			return Double.class;
		// finally Integer
		return Integer.class;

	}

	/**
	 * 
	 * @param o
	 */
	public Object unaryMinus(Object o) throws RuntimeException {

		if (o.equals(Integer.class)) {
			return Integer.class;
		} else {
			return Double.class;
		}
	}

	/**
	 * 
	 * @param o
	 */
	public Object unaryPlus(Object o) throws RuntimeException {
		if (o.equals(Integer.class)) {
			return Integer.class;
		} else {
			return Double.class;
		}
	}

	/**
	 * 
	 * @param target
	 * @param prop
	 */
	public Object classPropertyDot(Object target, String prop) throws Exception {
		return ReflectionHelper.getPropertyType((Class) target, prop);
	}

	/**
	 * 
	 * @param target
	 * @param info
	 */
	public Object classMethodDot(Object target, FunctionInfo info)
			throws Exception {
		Class[] temp = null;
		if (info.params != null) {
			temp = new Class[info.params.length];
			for (int i = 0; i < info.params.length; i++) {
				temp[i] = (Class) info.params[i];
			}
		}
		return ReflectionHelper.getMethodReturnType((Class) target,
				info.funcname, temp);
	}

	/**
	 * 
	 * @param key
	 * @param data
	 * @param local
	 * @return
	 * @throws RuntimeException
	 */
	public Object keyDollar(String key, HashMap<String, Object> data,
			HashMap<String, Object> local) throws RuntimeException {
		// first:find in local
		if (local.containsKey(key)) {
			if (local.get(key) instanceof Class)
				return local.get(key);
			return (local.get(key)).getClass();
		}
		// second:find in global data
		if (data.containsKey(key)) {
			if (data.get(key) instanceof Class)
				return data.get(key);
			return (data.get(key)).getClass();
		}
		// throw exception when key not found in both hashmap
		throw new ExpressionException();
	}

	/**
	 * 
	 * @param key
	 * @return
	 * @throws RuntimeException
	 * @throws ClassNotFoundException
	 */
	public Object keyDollar(String key) throws RuntimeException,
			ClassNotFoundException {
		String classname = getClassNameByKey(key);
		return Class.forName(classname);
	}

	@Deprecated
	public String getClassNameByKey(String key) {
		return "org.antlr.ext.TestCase.Dog";
	}

	public Object func(Object data, Object local) throws Exception {
		if (_tree.getParent() != null
				&& _tree.getParent().getType() == ExpressionLexer.DOT) {
			Object funcname = new TypeExpression(_tree.getChild(0)).Evaluate(
					data, local);
			Object[] params = null;
			Class[] classes = null;
			if (_tree.getChildCount() > 1) {
				params = new Object[_tree.getChildCount() - 1];
				classes = new Class[_tree.getChildCount() - 1];
			}
			for (int i = 0; i < _tree.getChildCount() - 1; i++) {
				params[i] = new TypeExpression(_tree.getChild(i + 1)).Evaluate(
						data, local);
				classes[i] = params[i].getClass();
			}
			// call class's member method
			return new FunctionInfo((String) funcname, params, classes);
		} else {
			return new TypeFunctionExpression(this, _tree).Evaluate(data, local);
		}
	}

}