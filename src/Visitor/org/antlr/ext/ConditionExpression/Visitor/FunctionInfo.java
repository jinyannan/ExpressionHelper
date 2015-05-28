package org.antlr.ext.ConditionExpression.Visitor;

public class FunctionInfo {
	public String funcname;
	public Object[] params;
	public Class[] classes;
	
	public FunctionInfo(String name,Object[] params,Class[] c)
	{
		this.funcname=name;
		this.params=params;
		this.classes=c;
	}
}
