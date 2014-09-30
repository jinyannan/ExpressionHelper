package  org.antlr.ext.ConditionExpression.Utility;

public class StringUtility
{
	/** 
	 截取字符串
	 
	 @param str
	 @param from 从1开始
	 @param length
	 @return 
	*/
	public static String Mid(String str, int from, int length)
	{
		int stringLength = str.length();
		if (from > stringLength)
		{
			return "";
		}

		return str.substring(from - 1, from - 1 + Math.min(length, stringLength - from + 1));
	}

	public static String Left(String str, int length)
	{
		return Mid(str, 1, length);
	}
	
	public static String Right(String str, int length)
	{
		if (str.length() < length)
		{
			return str;
		}

		return str.substring(str.length() - length, str.length() - length + length);
	}
}