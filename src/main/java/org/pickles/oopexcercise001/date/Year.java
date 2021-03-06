package org.pickles.oopexcercise001.date;

public class Year {
	private final int value;

	public Year(String value) {
		this.value = Integer.parseInt(value);
	}

	public Year(int value) {
		this.value = value;
	}

	public boolean isBeforeFirstReiwaYear() {
		return this.value < 2019;
	}

	public boolean isFirstReiwaYear() {
		return this.value == 2019;
	}

	public boolean isSecondTokyoOlympicYear() {
		return this.value == 2020;
	}

	public boolean lessThan(Year target) {
		return this.value < target.value;
	}

	public boolean isLeapYear() {
		if (this.value % 4 == 0) {
			if (this.value % 100 == 0) {
				if (this.value % 400 == 0) {
					return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}

	public Year next() {
		return new Year(this.value + 1);
	}

	public Year previous() {
		return new Year(this.value - 1);
	}

	public String toString() {
		return String.valueOf(this.value);
	}
}
