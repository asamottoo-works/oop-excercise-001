package org.pickles.oopexcercise001.date.publicholiday;

import org.pickles.oopexcercise001.date.*;

public class MondayPublicHoliday extends PublicHoliday {

	private Month month;
	private Day.WeekOfMonth weekOfMonth;

	MondayPublicHoliday(int month, int weekOfMonth) {
		this.month = Month.numberOf(month);
		this.weekOfMonth = new Day.WeekOfMonth(weekOfMonth);
	}

	public boolean match(Date target) {
		return this.month.same(target.month) && this.weekOfMonth.same(target.day.weekOfMonth()) && WeekCalculator.execute(target).isIncludeOf(Week.MONDAY);
	}
}
