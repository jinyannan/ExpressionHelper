package org.antlr.ext.ConditionExpression.Visitor;

import java.lang.reflect.Method;

//import ExpressionParser;
//import FunctionInfo;


import org.antlr.ext.ConditionExpression.Generated.ExpressionLexer;
import org.antlr.runtime.tree.Tree;

public class DotExpression extends BaseExpression {
	public DotExpression(BaseExpression exp, Tree tree) {
		super(exp, tree);
	}

	@Override
	public Object Evaluate(Object data) throws Exception {
		Tree left = _tree.getChild(0);
		Tree right = _tree.getChild(1);
		Object leftResult = super.VisitSubTree(left, data);
		Object rightResult = super.VisitSubTree(right, data);

		// 孙岩峰增加处理dot方法
		if (rightResult instanceof FunctionInfo) {
			FunctionInfo f = (FunctionInfo) rightResult;
			return this.invokeMethod(leftResult, f.funcname, f.params,
					f.classes);
		} else {
			return getProperty(leftResult, rightResult.toString());
		}

	}

	private Object invokeMethod(Object target, String funcname,
			Object[] params, Class[] classes) {
		Object result = null;

		Method setter = null;
		for (Class superInterface : target.getClass().getInterfaces()) {
			try {
				setter = target.getClass().getMethod(funcname, superInterface);
				break;
			} catch (NoSuchMethodException ex) {
				continue;
			}
		}
		if (setter == null) {
			try {
				setter = target.getClass().getMethod(funcname, classes);
			} catch (NoSuchMethodException ex) {
				//ex.printStackTrace();
				return null; //Aardwolf.K
			}
		}

		try {
			result = setter.invoke(target, params);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	private Object getProperty(Object data, String propsname) {
		Object result;

		try {
			result = this.invokeMethod(data, "get" + colToMethodName(propsname),
					null, null);
			if (result == null) {
				Object obj = this.invokeMethod(data, "getId", null, null);
				result = this.invokeMethod(obj, "get" + colToMethodName(propsname),
						null, null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result = null;
		}
		return result;
	}

	private String toUpperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder())
					.append(Character.toUpperCase(s.charAt(0)))
					.append(s.substring(1)).toString();
	}

	private String colToMethodName(String s) {
		String[] strs = s.toLowerCase().split("_");
		String result = "";
		for (int i = 0; i < strs.length; i++) {
			result += toUpperCaseFirstOne(strs[i]);
		}
		return result;
	}

}