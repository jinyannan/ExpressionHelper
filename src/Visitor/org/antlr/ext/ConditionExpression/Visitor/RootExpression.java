package org.antlr.ext.ConditionExpression.Visitor;

import org.antlr.runtime.tree.Tree;

public class RootExpression extends BaseExpression
{
	public RootExpression(Tree tree)
	{
		super(tree);
	}

	public RootExpression(BaseExpression exp, Tree tree)
	{
		super(exp, tree);
	}

	@Override
	public Object Evaluate(Object data) throws Exception
	{
		return super.VisitSubTree(_tree, data, null);
	}
	
	@Override
	public Object Evaluate(Object data, Object local) throws Exception
	{
		return super.VisitSubTree(_tree, data, local);
	}

	@Override
	public Object Evaluate() {
		// TODO Auto-generated method stub
		return null;
	}
}