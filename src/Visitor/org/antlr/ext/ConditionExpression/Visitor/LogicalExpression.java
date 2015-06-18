package org.antlr.ext.ConditionExpression.Visitor;

import org.antlr.ext.ConditionExpression.Generated.ExpressionLexer;
import org.antlr.runtime.tree.Tree;

public class LogicalExpression extends BaseExpression
{
	public LogicalExpression(BaseExpression exp, Tree tree)
	{
		super(exp, tree);
	}

	@Override
	public Object Evaluate(Object data, Object local) throws Exception
	{
		Tree left = _tree.getChild(0);
		Tree right = _tree.getChild(1);

		switch (_tree.getType())
		{
			case ExpressionLexer.AND:
				if (!Boolean.parseBoolean(super.VisitSubTree(left, data, local).toString()))
				{
					return false;
				}
				else
				{
					return Boolean.parseBoolean(super.VisitSubTree(right, data, local).toString());
				}

			case ExpressionLexer.OR:
				if (Boolean.parseBoolean(super.VisitSubTree(left, data, local).toString()))
				{
					return true;
				}
				else
				{
					return Boolean.parseBoolean(super.VisitSubTree(right, data, local).toString());
				}

			default:
				throw GetTreeException(String.format("无法识别的操作符[%1$s]", _tree.getType()));
		}

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