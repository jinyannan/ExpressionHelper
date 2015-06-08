package org.antlr.ext.ConditionExpression.Visitor;

import org.antlr.ext.ConditionExpression.Generated.ExpressionLexer;
import org.antlr.runtime.tree.Tree;

public class UnaryExpression extends BaseExpression
{
	public UnaryExpression(BaseExpression exp, Tree tree)
	{
		super(exp, tree);
	}

	@Override
	public Object Evaluate(Object data, Object local) throws Exception
	{
		Tree left = _tree.getChild(0);
		Tree right = _tree.getChild(1);
		Object result = super.VisitSubTree(right, data, local);

		switch (_tree.getType())
		{
			case ExpressionLexer.UNARY:
				switch (left.getType())
				{
					case ExpressionLexer.NOT:
						return !Boolean.parseBoolean(result.toString());

					case ExpressionLexer.MINUS:
						if (result.getClass() == Integer.class)
						{
							return -(Integer)result;
						}
						else
						{
							return -Double.parseDouble(result.toString());
						}

					case ExpressionLexer.PLUS:
						return result;

					default:
						return null;
				}

			default:
				throw GetTreeException(String.format("无法识别的操作符[%1$s]", _tree.getType()));
		}
	}

	@Override
	public Object Evaluate(Object data) throws Exception {
		return Evaluate(data, null);
	}
}