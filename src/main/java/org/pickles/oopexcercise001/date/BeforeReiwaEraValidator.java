package org.pickles.oopexcercise001.date;

public class BeforeReiwaEraValidator {
	public static boolean isInvalid(Date date) {
		if (date.year.isBeforeFirstReiwaYear()) return true;
		if (date.year.isFirstReiwaYear() && date.month.lessThan(Month.MAY)) return true;
		return false;
	}
}
