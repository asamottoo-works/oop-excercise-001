package org.pickles.oopexcercise001;

import org.pickles.oopexcercise001.date.*;

public class ReiwaHoliday {

	/**
	 * 要求仕様
	 * ・入力された日付文字列が令和の休日かどうかを返す。
	 * ・休日である場合はtrue, そうでない場合はfalseとなる。
	 * ・土日は休日とする。
	 * ・祝日の定義は内閣府発行の「国民の祝日」の定義に基づく。
	 * ・ただし、春分の日と秋分の日は毎年定義が変わるため、このプロジェクトでは春分の日：3/21, 秋分の日：9/23を固定とする。
	 * ・入力値に問題がある場合は例外を投げる。
	 * ・令和開始日時である2019年05月01日以前の日付を入力すると例外を投げる。
	 * ・入力する日付のフォーマットはyyyy/MM/ddとし、それ以外は例外を投げる。
	 */
	public boolean check(String in) {

		if (in == null) {
			throw new IllegalArgumentException();
		}

		if (in.length() != 10) {
			throw new IllegalArgumentException();
		}

		if (!in.substring(4, 5).equals("/") || !in.substring(7, 8).equals("/")) {
			throw new IllegalArgumentException();
		}

		Date targetDate = new Date(in);

		if (targetDate.year.isBeforeFirstReiwaYear()) {
			throw new IllegalArgumentException();
		}

		if (targetDate.month.lessThan(Month.JANUARY)) {
			throw new IllegalArgumentException();
		}

		if (isPublicHoliday(targetDate)) {
			return true;
		}

		if (isNormalHoliday(targetDate)) {
			return true;
		}

		if (isAdditionalHoliday(in)) {
			return true;
		}

		return false;
	}

	private boolean isAdditionalHoliday(String in) {
		Date targetDate = new Date(in);

		Date yesterday = targetDate.getYesterday();
		Date tomorrow = targetDate.getTomorrow();

		if (targetDate.month.same(Month.MAY) && targetDate.day.same(6) && WeekCalculator.execute(targetDate).isIncludeOf(Week.MONDAY, Week.TUESDAY, Week.WEDNESDAY)) {
			return true;
		}

		if (isMonday(targetDate) && isPublicHoliday(yesterday)) {
			return true;
		}

		if (isPublicHoliday(yesterday) && isPublicHoliday(tomorrow)) {
			return true;
		}

		return false;
	}

	private boolean isPublicHoliday(Date targetDate) {
 		if (targetDate.month.same(Month.JANUARY)) {
			if (targetDate.day.lessThan(1) || targetDate.day.moreThan(31)) {
				throw new IllegalArgumentException();
			}

			if (targetDate.year.isFirstReiwaYear()) {
				throw new IllegalArgumentException();
			}

			if (targetDate.day.same(Day.FIRST)) {
				return true;
			}

			if (targetDate.day.isWeekOfMonthOf(1) && isMonday(targetDate)) {
				return true;
			}
		}

		if (targetDate.month.same(Month.FEBRUARY)) {
			if (targetDate.day.lessThan(Day.FIRST) || targetDate.day.moreThan(LastDaysOfMonthCalculator.execute(targetDate.year, targetDate.month))) {
				throw new IllegalArgumentException();
			}

			if (targetDate.year.isFirstReiwaYear()) {
				throw new IllegalArgumentException();

			}

			if (targetDate.day.same(11)) {
				return true;
			}

			if (targetDate.day.same(23)) {
				return true;
			}
		}

		if (targetDate.month.same(Month.MARCH)) {
			if (targetDate.day.same(Day.FIRST) || targetDate.day.same(31)) {
				throw new IllegalArgumentException();
			}

			if (targetDate.year.isFirstReiwaYear()) {
				throw new IllegalArgumentException();
			}

			if (targetDate.day.same(21)) {
				return true;
			}
		}

		if (targetDate.month.same(Month.APRIL)) {
			if (targetDate.day.lessThan(1) || targetDate.day.moreThan(30)) {
				throw new IllegalArgumentException();
			}

			if (targetDate.year.isFirstReiwaYear()) {
				throw new IllegalArgumentException();
			}

			if (targetDate.day.same(29)) {
				return true;
			}
		}

		if (targetDate.month.same(Month.MAY)) {
			if (targetDate.day.lessThan(1) || targetDate.day.moreThan(31)) {
				throw new IllegalArgumentException();

			}

			if (targetDate.year.isFirstReiwaYear() && targetDate.day.same(1)) {
				return true;
			}

			if (targetDate.day.same(3)) {
				return true;
			}

			if (targetDate.day.same(4)) {
				return true;
			}

			if (targetDate.day.same(5)) {
				return true;
			}
		}

		if (targetDate.month.same(Month.JUNE)) {
			if (targetDate.day.lessThan(1) || targetDate.day.moreThan(30)) {
				throw new IllegalArgumentException();
			}
		}

		if (targetDate.month.same(Month.JULY)) {
			if (targetDate.day.lessThan(1) || targetDate.day.moreThan(31)) {
				throw new IllegalArgumentException();
			}

			if (!targetDate.year.isSecondTokyoOlympicYear() && targetDate.day.isWeekOfMonthOf(2) && isMonday(targetDate)) {
				return true;
			}

			if (targetDate.year.isSecondTokyoOlympicYear() && (targetDate.day.same(23) || targetDate.day.same(24))) {
				return true;
			}
		}

		if (targetDate.month.same(Month.AUGUST)) {
			if (targetDate.day.lessThan(1) || targetDate.day.moreThan(31)) {
				throw new IllegalArgumentException();
			}

			if (targetDate.year.isSecondTokyoOlympicYear() && targetDate.day.same(10)) {
				return true;
			}

			if (!targetDate.year.isSecondTokyoOlympicYear() && targetDate.day.same(11)) {
				return true;
			}
		}

		if (targetDate.month.same(Month.SEPTEMBER)) {
			if (targetDate.day.lessThan(1) || targetDate.day.moreThan(30)) {
				throw new IllegalArgumentException();
			}

			if (targetDate.day.isWeekOfMonthOf(2) && isMonday(targetDate)) {
				return true;
			}

			if (targetDate.day.same(23)) {
				return true;
			}
		}

		if (targetDate.month.same(Month.OCTOBER)) {
			if (targetDate.day.lessThan(1) || targetDate.day.moreThan(31)) {
				throw new IllegalArgumentException();
			}

			if (!targetDate.year.isSecondTokyoOlympicYear() && targetDate.day.isWeekOfMonthOf(1) && isMonday(targetDate)) {
				return true;
			}

			if (targetDate.year.isFirstReiwaYear() && targetDate.day.same(22)) {
				return true;
			}
		}

		if (targetDate.month.same(Month.NOVEMBER)) {
			if (targetDate.day.lessThan(1) || targetDate.day.moreThan(30)) {
				throw new IllegalArgumentException();
			}

			if (targetDate.day.same(3)) {
				return true;
			}

			if (targetDate.day.same(23)) {
				return true;
			}
		}

		if (targetDate.month.same(Month.DECEMBER)) {
			if (targetDate.day.lessThan(1) || targetDate.day.moreThan(31)) {
				throw new IllegalArgumentException();
			}
		}
		return false;
	}

	private boolean isNormalHoliday(Date targetDate) {
		return WeekCalculator.execute(targetDate).isIncludeOf(Week.SUNDAY, Week.SATURDAY);
	}

	private boolean isMonday(Date targetDate) {
		return WeekCalculator.execute(targetDate).isIncludeOf(Week.MONDAY);
	}
}
