package org.antlr.ext.ConditionExpression.Visitor;

import org.antlr.ext.ConditionExpression.Generated.ExpressionLexer;
import org.antlr.ext.ConditionExpression.Utility.Compare;
import org.antlr.runtime.tree.Tree;

public class CompareExpression extends BaseExpression
{
	public CompareExpression(BaseExpression exp, Tree tree)
	{
		super(exp, tree);
	}

	@Override
	public Object Evaluate(Object data, Object local) throws Exception
	{
		Tree left = _tree.getChild(0);
		Tree right = _tree.getChild(1);
//C# TO JAVA CONVERTER TODO TASK: There is no Java equivalent to the C# 'Object' keyword:
		Object leftResult = super.VisitSubTree(left, data, local);
//C# TO JAVA CONVERTER TODO TASK: There is no Java equivalent to the C# 'Object' keyword:
		Object rightResult = super.VisitSubTree(right, data, local);

		switch (_tree.getType())
		{
			case ExpressionLexer.EQUALS:
				return Compare.AreEqual(leftResult, rightResult);

			case ExpressionLexer.NOTEQUALS:
				return Compare.AreNotEqual(leftResult, rightResult);

			case ExpressionLexer.GT:
				return Compare.IsGreaterThan(leftResult, rightResult);

			case ExpressionLexer.GTEQ:
				return Compare.IsGreaterOrEqual(leftResult, rightResult);

			case ExpressionLexer.LT:
				return Compare.IsLessThan(leftResult, rightResult);

			case ExpressionLexer.LTEQ:
				return Compare.IsLessOrEqual(leftResult, rightResult);

			default:
				throw GetTreeException(String.format("无法识别的操作符[%1$s]", _tree.getType()));
		}
	}

	@Override
	public Object Evaluate(Object data) throws Exception {
		return Evaluate(data, null);
	}
}