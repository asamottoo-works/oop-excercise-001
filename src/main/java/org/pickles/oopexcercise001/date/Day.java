package org.pickles.oopexcercise001.date;

public class Day {
	public static Day FIRST = new Day(1);

	private int value;

	public Day(String value) {
		this.value = Integer.parseInt(value);
	}

	public Day(int value) {
		this.value = value;
	}

	public Day previous() {
		return new Day(this.value - 1);
	}

	public Day next() {
		return new Day(this.value + 1);
	}

	public boolean same(int target) {
		return this.value == target;
	}

	public boolean same(Day target) {
		return this.value == target.value;
	}

	public boolean lessThan(int target) {
		return this.value < target;
	}

	public boolean lessThan(Day target) {
		return this.value < target.value;
	}

	public boolean moreThan(int target) {
		return this.value > target;
	}

	public boolean moreThan(Day target) {
		return this.value > target.value;
	}

	public int weekOfMonth() {
		return (this.value - 1) / 7;
	}

	public boolean isWeekOfMonthOf(int target) {
		return this.weekOfMonth() == target;
	}

	public String toString() {
		return String.valueOf(this.value);
	}

	public Counter counter() {
		return new Counter(this);
	}

	public class Counter {
		private int index = 0;
		private final int target;

		public Counter(Day day) {
			this.target = day.value;
		}

		public boolean doNext() {
			index++;
			return index <= target;
		}
	}
}
