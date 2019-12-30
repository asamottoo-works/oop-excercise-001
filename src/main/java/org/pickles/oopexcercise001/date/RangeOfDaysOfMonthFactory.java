package org.pickles.oopexcercise001.date;

public class RangeOfDaysOfMonthFactory {
	public static RangeOfDaysOfMonth generate(Date date) {
		return new RangeOfDaysOfMonth(LastDaysOfMonthCalculator.execute(date.year, date.month));
	}
}
