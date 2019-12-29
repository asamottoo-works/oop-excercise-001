package org.pickles.oopexcercise001.date;

public class LastDaysOfMonthCalculator {
	public static Day execute(Year year, Month month) {
		switch (month) {
			case JANUARY:
				return new Day(31);
			case FEBRUARY:
				return new Day(year.isLeapYear() ? 29 : 28);
			case MARCH:
				return new Day(31);
			case APRIL:
				return new Day(30);
			case MAY:
				return new Day(31);
			case JUNE:
				return new Day(30);
			case JULY:
				return new Day(31);
			case AUGUST:
				return new Day(31);
			case SEPTEMBER:
				return new Day(30);
			case OCTOBER:
				return new Day(31);
			case NOVEMBER:
				return new Day(30);
			case DECEMBER:
				return new Day(31);
			default:
				throw new IllegalArgumentException();
		}
	}
}
