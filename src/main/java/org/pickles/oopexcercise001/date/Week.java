package org.pickles.oopexcercise001.date;

public enum Week {
	SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6);
	public static Week REIWA_FIRST = TUESDAY; // 2019/01/01は火曜日

	private final int value;

	Week(int value) {
		this.value = value;
	}

	public Week tomorrow() {
		if (this == SATURDAY) return SUNDAY;
		return numberOf(this.value + 1);
	}

	public Week dayAfter(int num) {
		Week ret = this;
		for (int index = 0; index < num; index++) {
			ret = ret.tomorrow();
		}
		return ret;
	}

	public Week dayAfter(Day day) {

		Week ret = this;
		Day.Counter counter = day.counter();
		while (counter.doNext()) {
			ret = ret.tomorrow();
		}
		return ret;
	}

	public boolean isIncludeOf(Week... weeks) {
		for (Week week : weeks) {
			if (this == week) return true;
		}
		return false;
	}

	private static Week numberOf(int target) {
		for (Week week : values()) {
			if (week.value == target) return week;
		}
		throw new IllegalArgumentException();
	}
}
