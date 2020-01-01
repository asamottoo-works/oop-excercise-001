package org.pickles.oopexcercise001.date;

public class Day {
	public static Day FIRST = new Day(1);

	private final int value;

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

	public WeekOfMonth weekOfMonth() {
		return new WeekOfMonth(this);
	}

	public static class WeekOfMonth {
		private int value;

		public WeekOfMonth(Day day) {
			this.value = ((day.value - 1) / 7) + 1;
		}

		public WeekOfMonth(int value) {
			if (value < 1 || value > 5) throw new IllegalArgumentException();
			this.value = value;
		}

		public boolean same(WeekOfMonth target) {
			return this.value == target.value;
		}
	}
}
