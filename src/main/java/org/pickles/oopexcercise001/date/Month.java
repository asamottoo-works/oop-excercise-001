package org.pickles.oopexcercise001.date;

public enum Month {
	JANUARY(1),
	FEBRUARY(2),
	MARCH(3),
	APRIL(4),
	MAY(5),
	JUNE(6),
	JULY(7),
	AUGUST(8),
	SEPTEMBER(9),
	OCTOBER(10),
	NOVEMBER(11),
	DECEMBER(12);

	private int value;

	Month(int value) {
		this.value = value;
	}

	public boolean lessThan(Month month) {
		return this.value < month.value;
	}

	public boolean moreThan(Month month) {
		return this.value > month.value;
	}

	public boolean same(Month month) {
		return this == month;
	}

	public Month previous() {
		if (this.value == 1) return DECEMBER;
		return numberOf(this.value - 1);
	}

	public Month next() {
		if (this.value == 12) return JANUARY;
		return numberOf(this.value + 1);
	}

	public static Month numberOf(int target) {
		for (Month month : values()) {
			if (month.value == target) return month;
		}
		throw new IllegalArgumentException();
	}

	public static Month numberOf(String target) {
		return numberOf(Integer.parseInt(target));
	}


	public String toString() {
		return String.valueOf(this.value);
	}
}
