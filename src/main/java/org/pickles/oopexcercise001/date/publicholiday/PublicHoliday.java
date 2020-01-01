package org.pickles.oopexcercise001.date.publicholiday;

import org.pickles.oopexcercise001.date.Date;

import java.util.Arrays;
import java.util.List;

abstract public class PublicHoliday {
	public static PublicHoliday 元旦 = new FixedPublicHoliday(1, 1);
	public static PublicHoliday 建国記念日 = new FixedPublicHoliday(2, 11);
	public static PublicHoliday 天皇誕生日 = new FixedPublicHoliday(2, 23);
	public static PublicHoliday 春分の日 = new FixedPublicHoliday(3, 21);
	public static PublicHoliday 昭和の日 = new FixedPublicHoliday(4, 29);
	public static PublicHoliday 憲法記念日 = new FixedPublicHoliday(5, 3);
	public static PublicHoliday みどりの日 = new FixedPublicHoliday(5, 4);
	public static PublicHoliday こどもの日 = new FixedPublicHoliday(5, 5);
	public static PublicHoliday 山の日 = new FixedPublicHoliday(8, 11);
	public static PublicHoliday 秋分の日 = new FixedPublicHoliday(9, 23);
	public static PublicHoliday 文化の日 = new FixedPublicHoliday(11, 3);
	public static PublicHoliday 勤労感謝の日 = new FixedPublicHoliday(11, 23);
	public static PublicHoliday 成人の日 = new MondayPublicHoliday(1, 2);
	public static PublicHoliday 海の日 = new MondayPublicHoliday(7, 3);
	public static PublicHoliday 敬老の日 = new MondayPublicHoliday(9, 3);
	public static PublicHoliday 体育の日 = new MondayPublicHoliday(10, 2);

	public static PublicHoliday 天皇の即位の日2019 = new FixedPublicHoliday(5, 1);
	public static PublicHoliday 即位礼正殿の儀2019 = new FixedPublicHoliday(10, 22);

	public static PublicHoliday 海の日2020 = new FixedPublicHoliday(7, 23);
	public static PublicHoliday 体育の日2020 = new FixedPublicHoliday(7, 24);
	public static PublicHoliday 山の日2020 = new FixedPublicHoliday(8, 10);

	private static List<PublicHoliday> commonPublicHoliday = Arrays.asList(
			元旦,建国記念日,天皇誕生日,春分の日,昭和の日,
			憲法記念日,みどりの日,こどもの日,秋分の日,
			文化の日, 勤労感謝の日,成人の日,敬老の日
	);

	private static List<PublicHoliday> publicHoliday2020 = Arrays.asList(海の日2020, 体育の日2020, 山の日2020);

	private static List<PublicHoliday> publicHolidayIgnore2020 = Arrays.asList(海の日, 体育の日, 山の日);

	private static List<PublicHoliday> publicHoliday2019 = Arrays.asList(天皇の即位の日2019, 即位礼正殿の儀2019);

	abstract public boolean match(Date target);

	public static boolean isPublicHoliday(Date target) {
		for (PublicHoliday holiday : commonPublicHoliday) {
			if (holiday.match(target)) return true;
		}

		if (target.year.isSecondTokyoOlympicYear()) {
			for (PublicHoliday holiday : publicHoliday2020) {
				if (holiday.match(target)) return true;
			}
		} else {
			for (PublicHoliday holiday : publicHolidayIgnore2020) {
				if (holiday.match(target)) return true;
			}
		}

		if (target.year.isFirstReiwaYear()) {
			for (PublicHoliday holiday : publicHoliday2019) {
				if (holiday.match(target)) return true;
			}
		}

		return false;
	}
}
