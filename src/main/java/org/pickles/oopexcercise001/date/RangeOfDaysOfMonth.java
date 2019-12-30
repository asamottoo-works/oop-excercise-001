package org.pickles.oopexcercise001.date;

public class RangeOfDaysOfMonth {
	private final Day from = Day.FIRST;
	private final Day to;

	public RangeOfDaysOfMonth(Day to) {
		this.to = to;
	}

	public boolean outOfRange(Day target) {
		return target.lessThan(from) || target.moreThan(to);
	}
}
