package org.pickles.oopexcercise001.date.publicholiday;

import org.pickles.oopexcercise001.date.Date;
import org.pickles.oopexcercise001.date.Day;
import org.pickles.oopexcercise001.date.Month;

public class FixedPublicHoliday extends PublicHoliday {
	private Month month;
	private Day day;

	public FixedPublicHoliday(int month, int day) {
		this.month = Month.numberOf(month);
		this.day = new Day(day);
	}

	public boolean match(Date target) {
		return this.month.same(target.month) && this.day.same(target.day);
	}
}
