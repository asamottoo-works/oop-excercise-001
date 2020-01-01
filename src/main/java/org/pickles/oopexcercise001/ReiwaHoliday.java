package org.pickles.oopexcercise001;

import org.pickles.oopexcercise001.date.*;
import org.pickles.oopexcercise001.date.publicholiday.PublicHoliday;

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

		if (BeforeReiwaEraValidator.isInvalid(targetDate)) {
			throw new IllegalArgumentException();
		}

		if (RangeOfDaysOfMonthFactory.generate(targetDate).outOfRange(targetDate.day)) {
			throw new IllegalArgumentException();
		}

		if (PublicHoliday.isPublicHoliday(targetDate)) {
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

		if (isMonday(targetDate) && PublicHoliday.isPublicHoliday(yesterday)) {
			return true;
		}

		if (PublicHoliday.isPublicHoliday(yesterday) && PublicHoliday.isPublicHoliday(tomorrow)) {
			return true;
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
