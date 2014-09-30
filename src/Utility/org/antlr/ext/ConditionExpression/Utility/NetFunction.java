package org.antlr.ext.ConditionExpression.Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NetFunction {
	private static long ONE_DAY = 24L * 60 * 60 * 1000;

	public static boolean isValidDate(String str) {
		boolean convertSuccess = false;
		SimpleDateFormat[] formats = { new SimpleDateFormat("yyyy-MM-dd"),
				new SimpleDateFormat("yyyy/MM/dd") };
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

	private static Date baseFor() {
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(1899, 11, 30, 0, 0, 0);
		return c.getTime();
	}
}
