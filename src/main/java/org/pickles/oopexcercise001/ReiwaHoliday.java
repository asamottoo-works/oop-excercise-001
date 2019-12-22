package org.pickles.oopexcercise001;

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

		} else if (in.length() != 10) {
			throw new IllegalArgumentException();

		} else if (Integer.parseInt(in.substring(0, 4)) < 2019) {
			throw new IllegalArgumentException();

		} else if (!in.substring(4, 5).equals("/") || !in.substring(7, 8).equals("/")) {
			throw new IllegalArgumentException();

		} else if (Integer.parseInt(in.substring(5, 7)) < 1) {
			throw new IllegalArgumentException();

		} else if (isPublicHoliday(in)) {
			return true;

		} else if (isNormalHoliday(Integer.parseInt(in.substring(0, 4)),
				Integer.parseInt(in.substring(5, 7)),
				Integer.parseInt(in.substring(8, 10)))) {
			return true;
		} else if (isAdditionalHoliday(in)) {
			return true;
		}
		return false;
	}

	private String dateString(int[] targetDate) {
		String year = String.valueOf(targetDate[0]);
		String month = (targetDate[1] < 10 ? "0" : "") + String.valueOf(targetDate[1]);
		String day = (targetDate[2] < 10 ? "0" : "") + String.valueOf(targetDate[2]);
		return year + "/" + month + "/" + day;
	}

	private boolean isAdditionalHoliday(String in) {
		int[] targetDate = new int[3];
		targetDate[0] = Integer.parseInt(in.substring(0, 4));
		targetDate[1] = Integer.parseInt(in.substring(5, 7));
		targetDate[2] = Integer.parseInt(in.substring(8, 10));

		int[] yesterday = getYesterday(targetDate);
		String yesterdayString = dateString(yesterday);

		int[] tomorrow = getTomorrow(targetDate);
		String tomorrowString = dateString(tomorrow);

		if (targetDate[1] == 5 && targetDate[2] == 6 && getDayOfWeekNumber(targetDate[0], targetDate[1], targetDate[2]) == 3) {
			return true;
		} else if (isMonday(targetDate[0], targetDate[1], targetDate[2]) && isPublicHoliday(yesterdayString)) {
			return true;
		} else if (isPublicHoliday(yesterdayString) && isPublicHoliday(tomorrowString)) {
			return true;
		}

		return false;
	}

	private int[] getYesterday(int[] targetDate) {
		int[] res = new int[3];
		res[0] = targetDate[0];
		res[1] = targetDate[1];
		res[2] = targetDate[2];
		res[2] -= 1;
		if (res[2] < 1) {
			res[1] -= 1;
			if (res[1] < 1) {
				res[0] -= 1;
				res[1] = 12;
			}
			int[] daysOfMonth = getDaysOfMonth(res[0]);
			res[2] = daysOfMonth[res[1]];
		}
		return res;
	}

	private int[] getTomorrow(int[] targetDate) {
		int[] res = new int[3];
		res[0] = targetDate[0];
		res[1] = targetDate[1];
		res[2] = targetDate[2];

		int[] targetDaysOfMonth = getDaysOfMonth(targetDate[0]);

		res[2] += 1;
		if (res[2] > targetDaysOfMonth[targetDate[1]]) {
			res[1] += 1;
			if (res[1] > 12) {
				res[0] += 1;
				res[1] = 1;
			}
			res[2] = 1;
		}
		return res;
	}

	private boolean isPublicHoliday(String in) {
 		if (Integer.parseInt(in.substring(5, 7)) == 1) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 || Integer.parseInt(in.substring(8, 10)) > 31) {
				throw new IllegalArgumentException();

			} else if (Integer.parseInt(in.substring(0, 4)) == 2019) {
				throw new IllegalArgumentException();

			} else {
				if (Integer.parseInt(in.substring(8, 10)) == 1) {
					return true;
				} else if ((Integer.parseInt(in.substring(8, 10)) - 1) / 7 == 1 &&
						isMonday(Integer.parseInt(in.substring(0, 4)),
								Integer.parseInt(in.substring(5, 7)),
								Integer.parseInt(in.substring(8, 10)))) {
					return true;
				}
			}

		} else if (Integer.parseInt(in.substring(5, 7)) == 2) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 ||
					Integer.parseInt(in.substring(8, 10)) > (isLeapYear(Integer.parseInt(in.substring(0, 4))) ? 29 : 28)) {
				throw new IllegalArgumentException();

			} else if (Integer.parseInt(in.substring(0, 4)) == 2019) {
				throw new IllegalArgumentException();

			} else {
				if (Integer.parseInt(in.substring(8, 10)) == 11) {
					return true;
				}
				if (Integer.parseInt(in.substring(8, 10)) == 23) {
					return true;
				}
			}

		} else if (Integer.parseInt(in.substring(5, 7)) == 3) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 || Integer.parseInt(in.substring(8, 10)) > 31) {
				throw new IllegalArgumentException();

			} else if (Integer.parseInt(in.substring(0, 4)) == 2019) {
				throw new IllegalArgumentException();

			} else {
				if (Integer.parseInt(in.substring(8, 10)) == 21) {
					return true;
				}
			}

		} else if (Integer.parseInt(in.substring(5, 7)) == 4) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 || Integer.parseInt(in.substring(8, 10)) > 30) {
				throw new IllegalArgumentException();

			} else if (Integer.parseInt(in.substring(0, 4)) == 2019) {
				throw new IllegalArgumentException();

			} else {
				if (Integer.parseInt(in.substring(8, 10)) == 29) {
					return true;
				}
			}

		} else if (Integer.parseInt(in.substring(5, 7)) == 5) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 || Integer.parseInt(in.substring(8, 10)) > 31) {
				throw new IllegalArgumentException();

			} else {
				if (Integer.parseInt(in.substring(0, 4)) == 2019) {
					if (Integer.parseInt(in.substring(8, 10)) == 1) {
						return true;
					} else if (Integer.parseInt(in.substring(8, 10)) == 3) {
						return true;
					} else if (Integer.parseInt(in.substring(8, 10)) == 4) {
						return true;
					} else if (Integer.parseInt(in.substring(8, 10)) == 5) {
						return true;
					}
				} else {
					if (Integer.parseInt(in.substring(8, 10)) == 3) {
						return true;
					} else if (Integer.parseInt(in.substring(8, 10)) == 4) {
						return true;
					} else if (Integer.parseInt(in.substring(8, 10)) == 5) {
						return true;
					}
				}
			}

		} else if (Integer.parseInt(in.substring(5, 7)) == 6) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 || Integer.parseInt(in.substring(8, 10)) > 30) {
				throw new IllegalArgumentException();
			}

		} else if (Integer.parseInt(in.substring(5, 7)) == 7) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 || Integer.parseInt(in.substring(8, 10)) > 31) {
				throw new IllegalArgumentException();
			} else if (Integer.parseInt(in.substring(0, 4)) != 2020 && (Integer.parseInt(in.substring(8, 10)) - 1) / 7 == 2 &&
					isMonday(Integer.parseInt(in.substring(0, 4)),
							Integer.parseInt(in.substring(5, 7)),
							Integer.parseInt(in.substring(8, 10)))) {
				return true;
			} else if (Integer.parseInt(in.substring(0, 4)) == 2020 && (Integer.parseInt(in.substring(8, 10)) == 23 || Integer.parseInt(in.substring(8, 10)) == 24)) {
				return true;
			}

		} else if (Integer.parseInt(in.substring(5, 7)) == 8) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 || Integer.parseInt(in.substring(8, 10)) > 31) {
				throw new IllegalArgumentException();
			} else {
				if (Integer.parseInt(in.substring(0, 4)) == 2020 && Integer.parseInt(in.substring(8, 10)) == 10) {
					return true;
				} else if (Integer.parseInt(in.substring(0, 4)) != 2020 && Integer.parseInt(in.substring(8, 10)) == 11) {
					return true;
				}
			}

		} else if (Integer.parseInt(in.substring(5, 7)) == 9) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 || Integer.parseInt(in.substring(8, 10)) > 30) {
				throw new IllegalArgumentException();
			} else {
				if ((Integer.parseInt(in.substring(8, 10)) - 1) / 7 == 2 &&
						isMonday(Integer.parseInt(in.substring(0, 4)),
								Integer.parseInt(in.substring(5, 7)),
								Integer.parseInt(in.substring(8, 10)))) {
					return true;
				} else if (Integer.parseInt(in.substring(8, 10)) == 23) {
					return true;
				}
			}

		} else if (Integer.parseInt(in.substring(5, 7)) == 10) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 || Integer.parseInt(in.substring(8, 10)) > 31) {
				throw new IllegalArgumentException();
			} else {
				if (Integer.parseInt(in.substring(0, 4)) != 2020 && (Integer.parseInt(in.substring(8, 10)) - 1) / 7 == 1 &&
						isMonday(Integer.parseInt(in.substring(0, 4)),
								Integer.parseInt(in.substring(5, 7)),
								Integer.parseInt(in.substring(8, 10)))) {
					return true;
				} else if (Integer.parseInt(in.substring(0, 4)) == 2019 && Integer.parseInt(in.substring(8, 10)) == 22) {
					return true;
				}
			}

		} else if (Integer.parseInt(in.substring(5, 7)) == 11) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 || Integer.parseInt(in.substring(8, 10)) > 30) {
				throw new IllegalArgumentException();
			} else {
				if (Integer.parseInt(in.substring(8, 10)) == 3) {
					return true;
				} else if (Integer.parseInt(in.substring(8, 10)) == 23) {
					return true;
				}
			}

		} else if (Integer.parseInt(in.substring(5, 7)) == 12) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 || Integer.parseInt(in.substring(8, 10)) > 31) {
				throw new IllegalArgumentException();
			} else {
				return false;
			}
		}
		return false;
	}

	private boolean isNormalHoliday(int year, int month, int day) {
		int dayOfWeek = getDayOfWeekNumber(year, month, day);
		return dayOfWeek == 0 || dayOfWeek == 6;
	}

	private boolean isMonday(int year, int month, int day) {
		return getDayOfWeekNumber(year, month, day) == 1;
	}

	private int getDayOfWeekNumber(int year, int month, int day) {
		// 日:0, 月:1, 火:2, 水:3, 木:4, 金:5, 土:6
		int dayOfWeek = 2; // 2019/01/01は火曜日
		for (int baseYear = 2019; baseYear < year; baseYear++) {
			dayOfWeek += isLeapYear(baseYear) ? 2 : 1;
		}
		int[] daysOfMonth = getDaysOfMonth(year);
		for (int baseMonth = 1; baseMonth < month; baseMonth++) {
			dayOfWeek += daysOfMonth[baseMonth];
		}
		dayOfWeek += day - 1;
		return dayOfWeek % 7;
	}

	private boolean isLeapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}

	private int[] getDaysOfMonth(int year) {
		int[] res = new int[13];
		res[0] = 0;
		res[1] = 31;
		res[2] = isLeapYear(year) ? 29 : 28;
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
