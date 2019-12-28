package org.pickles.oopexcercise001;

import org.pickles.oopexcercise001.date.Date;
import org.pickles.oopexcercise001.date.Year;

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

		if (targetDate.month.value < 1) {
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

		Date yesterday = getYesterday(targetDate);
		Date tomorrow = getTomorrow(targetDate);

		if (targetDate.month.value == 5 && targetDate.day.value == 6 && getDayOfWeekNumber(targetDate) == 3) {
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

	private Date getYesterday(Date targetDate) {
		Year resYear = targetDate.year;
		int resMonth = targetDate.month.value;
		int resDay = targetDate.day.value;
		resDay -= 1;
		if (resDay < 1) {
			resMonth -= 1;
			if (resMonth < 1) {
				resYear = targetDate.year.previousYear();
				resMonth = 12;
			}
			int[] daysOfMonth = getDaysOfMonth(resYear);
			resDay = daysOfMonth[resMonth];
		}
		return new Date(resYear, resMonth, resDay);
	}

	private Date getTomorrow(Date targetDate) {
		Year resYear = targetDate.year;
		int resMonth = targetDate.month.value;
		int resDay = targetDate.day.value;

		int[] targetDaysOfMonth = getDaysOfMonth(targetDate.year);

		resDay += 1;
		if (resDay > targetDaysOfMonth[targetDate.month.value]) {
			resMonth += 1;
			if (resMonth > 12) {
				resYear = targetDate.year.nextYear();
				resMonth = 1;
			}
			resDay = 1;
		}
		return new Date(resYear, resMonth, resDay);
	}

	private boolean isPublicHoliday(Date targetDate) {
 		if (targetDate.month.value == 1) {
			if (targetDate.day.value < 1 || targetDate.day.value > 31) {
				throw new IllegalArgumentException();
			}

			if (targetDate.year.isFirstReiwaYear()) {
				throw new IllegalArgumentException();
			}

			if (targetDate.day.value == 1) {
				return true;
			}

			if ((targetDate.day.value - 1) / 7 == 1 &&
					isMonday(targetDate)) {
				return true;
			}

		}

		if (targetDate.month.value == 2) {
			if (targetDate.day.value < 1 || targetDate.day.value > (targetDate.year.isLeapYear() ? 29 : 28)) {
				throw new IllegalArgumentException();
			}

			if (targetDate.year.isFirstReiwaYear()) {
				throw new IllegalArgumentException();

			}

			if (targetDate.day.value == 11) {
				return true;
			}

			if (targetDate.day.value == 23) {
				return true;
			}
		}

		if (targetDate.month.value == 3) {
			if (targetDate.day.value < 1 || targetDate.day.value > 31) {
				throw new IllegalArgumentException();
			}

			if (targetDate.year.isFirstReiwaYear()) {
				throw new IllegalArgumentException();
			}

			if (targetDate.day.value == 21) {
				return true;
			}
		}

		if (targetDate.month.value == 4) {
			if (targetDate.day.value < 1 || targetDate.day.value > 30) {
				throw new IllegalArgumentException();
			}

			if (targetDate.year.isFirstReiwaYear()) {
				throw new IllegalArgumentException();
			}

			if (targetDate.day.value == 29) {
				return true;
			}
		}

		if (targetDate.month.value == 5) {
			if (targetDate.day.value < 1 || targetDate.day.value > 31) {
				throw new IllegalArgumentException();

			}

			if (targetDate.year.isFirstReiwaYear() && targetDate.day.value == 1) {
				return true;
			}

			if (targetDate.day.value == 3) {
				return true;
			}

			if (targetDate.day.value == 4) {
				return true;
			}

			if (targetDate.day.value == 5) {
				return true;
			}

		}

		if (targetDate.month.value == 6) {
			if (targetDate.day.value < 1 || targetDate.day.value > 30) {
				throw new IllegalArgumentException();
			}

		}

		if (targetDate.month.value == 7) {
			if (targetDate.day.value < 1 || targetDate.day.value > 31) {
				throw new IllegalArgumentException();
			}

			if (!targetDate.year.isSecondTokyoOlympicYear() && (targetDate.day.value - 1) / 7 == 2 && isMonday(targetDate)) {
				return true;
			}

			if (targetDate.year.isSecondTokyoOlympicYear() && (targetDate.day.value == 23 || targetDate.day.value == 24)) {
				return true;
			}

		}

		if (targetDate.month.value == 8) {
			if (targetDate.day.value < 1 || targetDate.day.value > 31) {
				throw new IllegalArgumentException();
			}

			if (targetDate.year.isSecondTokyoOlympicYear() && targetDate.day.value == 10) {
				return true;
			}

			if (!targetDate.year.isSecondTokyoOlympicYear() && targetDate.day.value == 11) {
				return true;
			}

		}

		if (targetDate.month.value == 9) {
			if (targetDate.day.value < 1 || targetDate.day.value > 30) {
				throw new IllegalArgumentException();
			}

			if ((targetDate.day.value - 1) / 7 == 2 && isMonday(targetDate)) {
				return true;
			}

			if (targetDate.day.value == 23) {
				return true;
			}

		}

		if (targetDate.month.value == 10) {
			if (targetDate.day.value < 1 || targetDate.day.value > 31) {
				throw new IllegalArgumentException();
			}

			if (!targetDate.year.isSecondTokyoOlympicYear() && (targetDate.day.value - 1) / 7 == 1 && isMonday(targetDate)) {
				return true;
			}

			if (targetDate.year.isFirstReiwaYear() && targetDate.day.value == 22) {
				return true;
			}

		}

		if (targetDate.month.value == 11) {
			if (targetDate.day.value < 1 || targetDate.day.value > 30) {
				throw new IllegalArgumentException();
			}

			if (targetDate.day.value == 3) {
				return true;
			}

			if (targetDate.day.value == 23) {
				return true;
			}

		}

		if (targetDate.month.value == 12) {
			if (targetDate.day.value < 1 || targetDate.day.value > 31) {
				throw new IllegalArgumentException();
			}
		}
		return false;
	}

	private boolean isNormalHoliday(Date targetDate) {
		int dayOfWeek = getDayOfWeekNumber(targetDate);
		return dayOfWeek == 0 || dayOfWeek == 6;
	}

	private boolean isMonday(Date targetDate) {
		return getDayOfWeekNumber(targetDate) == 1;
	}

	private int getDayOfWeekNumber(Date targetDate) {
		// 日:0, 月:1, 火:2, 水:3, 木:4, 金:5, 土:6
		int dayOfWeek = 2; // 2019/01/01は火曜日
		Year indexYear = new Year(2019);
		while (indexYear.lessThan(targetDate.year)) {
			dayOfWeek += indexYear.isLeapYear() ? 2 : 1;
			indexYear = indexYear.nextYear();
		}

		int[] daysOfMonth = getDaysOfMonth(targetDate.year);
		for (int baseMonth = 1; baseMonth < targetDate.month.value; baseMonth++) {
			dayOfWeek += daysOfMonth[baseMonth];
		}
		dayOfWeek += targetDate.day.value - 1;
		return dayOfWeek % 7;
	}

	private int[] getDaysOfMonth(Year year) {
		int[] res = new int[13];
		res[0] = 0;
		res[1] = 31;
		res[2] = year.isLeapYear() ? 29 : 28;
		res[3] = 31;
		res[4] = 30;
		res[5] = 31;
		res[6] = 30;
		res[7] = 31;
		res[8] = 31;
		res[9] = 30;
		res[10] = 31;
		res[11] = 30;
		res[12] = 31;
		for (int index = 1; index <= 12; index++) {
			res[0] += res[index];
		}
		return res;
	}
}
