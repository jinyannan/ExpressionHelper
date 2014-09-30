package  org.antlr.ext.ConditionExpression.Utility;

public class Compare
{
	public static boolean AreEqual(Object leftValue, Object rightValue)
	{
		if (leftValue instanceof String && rightValue instanceof String)
		{
			return leftValue.equals(rightValue);
		}else if (leftValue instanceof Boolean && rightValue instanceof Boolean) {
			return leftValue == rightValue;
		}
		else
		{
			return DoubleUtility.AreEqual(DataType.ConvertToDouble(leftValue), DataType.ConvertToDouble(rightValue));
		}

		/////都是数字，按double类型比较
		//if ((DataType.IsNumber(leftValue) || leftValue is bool)
		//    && (DataType.IsNumber(rightValue) || rightValue is bool))
		//{
		//    return Utility.DoubleUtility.AreEqual(Convert.ToDouble(leftValue),
		//        Convert.ToDouble(rightValue));
		//}
		//else
		//{
		//    ///为提高效率，不再尝试转化为时间类型了
		//    DateTime leftDT, rightDT;
		//    leftDT = DataType.GetDateTime(leftValue);
		//    rightDT = DataType.GetDateTime(rightValue);
		//    if (leftDT != DateTime.MinValue && rightDT != DateTime.MinValue)    //都是时间类型
		//    {
		//        return leftDT.Equals(rightDT);
		//    }
		//    else  ///其他类型都按字符串比较
		//    {
		//        return Convert.ToString(leftValue).Equals(Convert.ToString(rightValue));
		//    }
		//    //return Convert.ToString(leftValue).Equals(Convert.ToString(rightValue));
		//}
	}


	public static boolean AreNotEqual(Object leftValue, Object rightValue)
	{
		return !AreEqual(leftValue, rightValue);
	}

	public static boolean IsGreaterThan(Object leftValue, Object rightValue)
	{
		if (leftValue instanceof String && rightValue instanceof String)
		{
			return ((String)leftValue).compareTo((String)rightValue) > 0;
		}
		else
		{
			return DoubleUtility.IsGreaterThan(DataType.ConvertToDouble(leftValue), DataType.ConvertToDouble(rightValue));
		}

		/**都是数字，按double类型比较
		//if ((DataType.IsNumber(leftValue) || leftValue is bool)
		//    && (DataType.IsNumber(rightValue) || rightValue is bool))
		//{
		//    return Utility.DoubleUtility.IsGreaterThan(Convert.ToDouble(leftValue),
		//        Convert.ToDouble(rightValue));
		//}
		//else
		//{
		//    ///为提高效率，不再尝试转化为时间类型了，直接按字符串比较
		//    //DateTime leftDT, rightDT;
		//    //leftDT = DataType.GetDateTime(leftValue);
		//    //rightDT = DataType.GetDateTime(rightValue);
		//    //if (leftDT != DateTime.MinValue && rightDT != DateTime.MinValue)    //都是时间类型
		//    //{
		//    //    return leftDT.CompareTo(rightDT)>0;
		//    //}
		//    //else  ///其他类型都按字符串比较
		//    //{
		//    //    return leftValue.ToString().CompareTo(rightValue.ToString())>0;
		//    //}
		//    return Convert.ToString(leftValue).CompareTo(Convert.ToString(rightValue)) > 0;
		//}
		*/

	}

	public static boolean IsGreaterOrEqual(Object leftValue, Object rightValue)
	{
		if (leftValue instanceof String && rightValue instanceof String)
		{
			return ((String)leftValue).compareTo((String)rightValue) >= 0;
		}
		else
		{
			return DoubleUtility.IsGreaterOrEqual(DataType.ConvertToDouble(leftValue), DataType.ConvertToDouble(rightValue));
		}

		/**都是数字，按double类型比较
		//if ((DataType.IsNumber(leftValue) || leftValue is bool)
		//    && (DataType.IsNumber(rightValue) || rightValue is bool))
		//{
		//    return Utility.DoubleUtility.IsGreaterOrEqual(Convert.ToDouble(leftValue),
		//        Convert.ToDouble(rightValue));
		//}
		//else
		//{
		//    ///为提高效率，不再尝试转化为时间类型了，直接按字符串比较
		//    //DateTime leftDT, rightDT;
		//    //leftDT = DataType.GetDateTime(leftValue);
		//    //rightDT = DataType.GetDateTime(rightValue);
		//    //if (leftDT != DateTime.MinValue && rightDT != DateTime.MinValue)    //都是时间类型
		//    //{
		//    //    return leftDT.CompareTo(rightDT) >= 0;
		//    //}
		//    //else  ///其他类型都按字符串比较
		//    //{
		//    //    return leftValue.ToString().CompareTo(rightValue.ToString()) >= 0;
		//    //}
		//    return Convert.ToString(leftValue).CompareTo(Convert.ToString(rightValue)) >= 0;
		//}
		*/
	}

	public static boolean IsLessThan(Object leftValue, Object rightValue)
	{
		return !IsGreaterOrEqual(leftValue, rightValue);
	}

	public static boolean IsLessOrEqual(Object leftValue, Object rightValue)
	{
		return !IsGreaterThan(leftValue, rightValue);
	}
}