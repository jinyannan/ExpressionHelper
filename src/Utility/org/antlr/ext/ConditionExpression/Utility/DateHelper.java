package org.antlr.ext.ConditionExpression.Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	private static long ONE_DAY = 24L * 60 * 60 * 1000;
	private static SimpleDateFormat[] formats = {
			new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyy/MM/dd") };

	public static boolean isValidDate(String str) {
		boolean convertSuccess = false;
		for (SimpleDateFormat simpleDateFormat : formats) {
			try {
				simpleDateFormat.setLenient(false);
				simpleDateFormat.parse(str);
				convertSuccess = true;
				break;
			} catch (ParseException | NullPointerException e1) {
			}
		}
		return convertSuccess;
	}

	public static Date convertToDate(String str) {
		Date result = null;
		for (SimpleDateFormat simpleDateFormat : formats) {
			simpleDateFormat.setLenient(false);
			try {
				result = simpleDateFormat.parse(str);
				break;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}

	public static Date fromOADate(double d) {
		long wholeDays = (long) d;
		double fracDays = Math.abs(d - wholeDays);

		long offset = (ONE_DAY * wholeDays) + (long) (fracDays * ONE_DAY);

		Date base = baseFor();
		return new Date(base.getTime() + offset);
	}

	public static double toOADate(Date date) {
		long offset = date.getTime() - baseFor().getTime();
		double oa = (double) offset / ONE_DAY;
		return oa;
	}

	public static Date getCurrentDate() throws ParseException {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return formatter.parse(dateString);
	}

	public static String convertLongDateString(Date date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}

	private static Date baseFor() {
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(1899, 11, 30, 0, 0, 0);
		return c.getTime();
	}

}
