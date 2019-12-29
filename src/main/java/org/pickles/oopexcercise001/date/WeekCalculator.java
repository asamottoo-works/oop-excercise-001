package org.pickles.oopexcercise001.date;

public class WeekCalculator {
	public static Week execute(Date targetDate) {
		// 日:0, 月:1, 火:2, 水:3, 木:4, 金:5, 土:6
		Week dayOfWeek = Week.REIWA_FIRST;
		Year indexYear = new Year(2019);
		while (indexYear.lessThan(targetDate.year)) {
			dayOfWeek = indexYear.isLeapYear() ? dayOfWeek.dayAfter(2) : dayOfWeek.tomorrow();
			indexYear = indexYear.next();
		}

		Month baseMonth = Month.JANUARY;
		while (baseMonth.lessThan(targetDate.month)) {
			dayOfWeek = dayOfWeek.dayAfter(LastDaysOfMonthCalculator.execute(targetDate.year, baseMonth));
			baseMonth = baseMonth.next();
		}
		return dayOfWeek.dayAfter(targetDate.day.previous());
	}
}
