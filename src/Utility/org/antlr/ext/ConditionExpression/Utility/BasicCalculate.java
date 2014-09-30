package  org.antlr.ext.ConditionExpression.Utility;

import java.util.Date;

/** 
 基本的计算+ - * / 乘方
 为了和C#中的ole自动化日期匹配，加减运算以小时计 by MZHY
*/
public class BasicCalculate
{
	public static Object Plus(Object leftValue, Object rightValue)
	{
		/**两边都是字符串，则直接字符串拼接
		*/
		if (leftValue instanceof String && rightValue instanceof String)
		{
			return (String)leftValue + (String)rightValue;
		}
		//左边是日期，右边是数字, by MZHY
		else if(leftValue instanceof Date){
			long newdate=DataType.ConvertDoubleToLong( (((Date) leftValue).getTime() + DataType.ConvertToDouble(rightValue) * 24 * 60 * 60 * 1000));
			return new Date(newdate);  
		}
		//左边是日期，右边是数字 by MZHY
		else if(rightValue instanceof Date){
			long newdate=DataType.ConvertDoubleToLong( (((Date) rightValue).getTime() + DataType.ConvertToDouble(leftValue) * 24 * 60 * 60 * 1000));
			return new Date(newdate); 
		}
		//其他类型全都转化成数字相加
		else
		{
			return DataType.ConvertToDouble(leftValue) + DataType.ConvertToDouble(rightValue);
		}
		//else if (leftValue is int && rightValue is int)
		//{
		//    return leftValue + rightValue;
		//}
		//else if ((DataType.IsNumber(leftValue) || leftValue is bool)
		//    && (DataType.IsNumber(rightValue) || rightValue is bool))
		//{
		//    return Convert.ToDouble(leftValue) + Convert.ToDouble(rightValue);
		//}
		//else
		//{
		//    throw new ExpressionException(string.Format("不支持的数据类型：left:[{0}]:{1},right:[{2}]:{3}",
		//        leftValue, leftValue.GetType(),
		//        rightValue, rightValue.GetType()));
		//}
	}

	public static Object Minus(Object leftValue, Object rightValue)
	{
		// 对于日期的减运行，只能 左边是日期，右边是数字, by MZHY
		if (leftValue instanceof Date) {
			long newdate = DataType
					.ConvertDoubleToLong((((Date) leftValue).getTime() - DataType
							.ConvertToDouble(rightValue) * 24 * 60 * 60 * 1000));
			return new Date(newdate);
		} else
			return DataType.ConvertToDouble(leftValue)
					- DataType.ConvertToDouble(rightValue);
		// if (leftValue is int && rightValue is int)
		//{
		//    return leftValue - rightValue;
		//}
		//else if ((DataType.IsNumber(leftValue) || leftValue is bool)
		//    && (DataType.IsNumber(rightValue) || rightValue is bool))
		//{
		//    return Convert.ToDouble(leftValue) - Convert.ToDouble(rightValue);
		//}
		//else
		//{
		//    throw new ExpressionException(string.Format("不支持的数据类型：left:[{0}]:{1},right:[{2}]:{3}",
		//        leftValue, leftValue.GetType(),
		//        rightValue, rightValue.GetType()));
		//}
	}


	public static Object Multiplication(Object leftValue, Object rightValue)
	{
		return DataType.ConvertToDouble(leftValue) * DataType.ConvertToDouble(rightValue);
		//if (leftValue is int && rightValue is int)
		//{
		//    return leftValue * rightValue;
		//}
		//else
		////if ((DataType.IsNumber(leftValue) || leftValue is bool)
		////    && (DataType.IsNumber(rightValue) || rightValue is bool))
		//{
		//    return Convert.ToDouble(leftValue) * Convert.ToDouble(rightValue);
		//}
		//else
		//{
		//    throw new ExpressionException(string.Format("不支持的数据类型：left:[{0}]:{1},right:[{2}]:{3}",
		//        leftValue, leftValue.GetType(),
		//        rightValue, rightValue.GetType()));
		//}
	}

	public static Object Division(Object leftValue, Object rightValue)
	{
		return DataType.ConvertToDouble(leftValue) / DataType.ConvertToDouble(rightValue);
		////if ((DataType.IsNumber(leftValue) || leftValue is bool)
		////    && (DataType.IsNumber(rightValue) || rightValue is bool))
		////{
		//    return Convert.ToDouble(leftValue) / Convert.ToDouble(rightValue);
		////}
		////else
		////{
		////    throw new ExpressionException(string.Format("不支持的数据类型：left:[{0}]:{1},right:[{2}]:{3}",
		////        leftValue, leftValue.GetType(),
		////        rightValue, rightValue.GetType()));
		////}
	}

	public static Object Power(Object leftValue, Object rightValue)
	{
		return Math.pow(DataType.ConvertToDouble(leftValue), DataType.ConvertToDouble(rightValue));
		//if ((DataType.IsNumber(leftValue) || leftValue is bool)
		//    && (DataType.IsNumber(rightValue) || rightValue is bool))
		//{
		//    return (double)Math.Pow(Convert.ToDouble(leftValue), Convert.ToDouble(rightValue));
		//}
		//else
		//{
		//    throw new ExpressionException(string.Format("不支持的数据类型：left:[{0}]:{1},right:[{2}]:{3}",
		//        leftValue, leftValue.GetType(),
		//        rightValue, rightValue.GetType()));
		//}
	}
}