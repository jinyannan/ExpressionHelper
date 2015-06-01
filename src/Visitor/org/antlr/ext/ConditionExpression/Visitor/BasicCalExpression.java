package org.antlr.ext.ConditionExpression.Visitor;

import org.antlr.ext.ConditionExpression.Generated.ExpressionLexer;
import org.antlr.ext.ConditionExpression.Utility.BasicCalculate;
import org.antlr.runtime.tree.Tree;

public class BasicCalExpression extends BaseExpression
{
	public BasicCalExpression(BaseExpression exp, Tree tree)
	{
		super(exp, tree);
	}
	
	@Override
	public Object Evaluate(Object data) throws Exception {
		return Evaluate(data, null);
	}

	@Override
	public Object Evaluate(Object data, Object local) throws Exception
	{
//C# TO JAVA CONVERTER TODO TASK: There is no Java equivalent to the C# 'Object' keyword:
		Object leftResult = super.VisitSubTree(_tree.getChild(0), data, local);
//C# TO JAVA CONVERTER TODO TASK: There is no Java equivalent to the C# 'Object' keyword:
		Object rightResult = super.VisitSubTree(_tree.getChild(1), data, local);

		switch (_tree.getType())
		{
			case ExpressionLexer.PLUS:
				return BasicCalculate.Plus(leftResult, rightResult);

			case ExpressionLexer.MINUS:
				return BasicCalculate.Minus(leftResult, rightResult);

			case ExpressionLexer.MUL:
				return BasicCalculate.Multiplication(leftResult, rightResult);

			case ExpressionLexer.DIV:
				return BasicCalculate.Division(leftResult, rightResult);

			case ExpressionLexer.POW:
				return BasicCalculate.Power(leftResult, rightResult);

			default:
				throw GetTreeException(String.format("无法识别的操作符[%1$s]", _tree.getType()));
		}
	}



}