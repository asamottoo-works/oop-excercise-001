package org.pickles.oopexcercise001;

public class ReiwaHoliday {

	/**
	 * 要求仕様
	 * ・入力された日付文字列が令和の休日かどうかを返す。
	 * ・休日である場合はtrue, そうでない場合はfalseとなる。
	 * ・休日の定義は内閣府発行の休日の定義に基づく。
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

		} else if (Integer.parseInt(in.substring(5, 7)) < 1) {
			throw new IllegalArgumentException();

		} else if (Integer.parseInt(in.substring(5, 7)) == 1) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 || Integer.parseInt(in.substring(8, 10)) > 31) {
				throw new IllegalArgumentException();

			} else if (Integer.parseInt(in.substring(0, 4)) == 2019) {
				throw new IllegalArgumentException();

			} else {
				if (Integer.parseInt(in.substring(8, 10)) == 1) {
					return true;
				} else if (Integer.parseInt(in.substring(8, 10)) / 7 == 1 &&
						isMonday(Integer.parseInt(in.substring(0, 4)),
								Integer.parseInt(in.substring(5, 7)),
								Integer.parseInt(in.substring(8, 10)))) {
					return true;
				}
				return false;
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
				return false;
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
				return false;
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
				return false;
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
					return false;
				} else {
					if (Integer.parseInt(in.substring(8, 10)) == 3) {
						return true;
					} else if (Integer.parseInt(in.substring(8, 10)) == 4) {
						return true;
					} else if (Integer.parseInt(in.substring(8, 10)) == 5) {

						return true;
					}
					return false;
				}
			}

		} else if (Integer.parseInt(in.substring(5, 7)) == 6) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 || Integer.parseInt(in.substring(8, 10)) > 30) {
				throw new IllegalArgumentException();

			} else {
				return false;
			}

		} else if (Integer.parseInt(in.substring(5, 7)) == 7) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 || Integer.parseInt(in.substring(8, 10)) > 31) {
				throw new IllegalArgumentException();
			} else if (Integer.parseInt(in.substring(8, 10)) / 7 == 2 &&
					isMonday(Integer.parseInt(in.substring(0, 4)),
							Integer.parseInt(in.substring(5, 7)),
							Integer.parseInt(in.substring(8, 10)))) {
				return true;
			} else {
				return false;
			}

		} else if (Integer.parseInt(in.substring(5, 7)) == 8) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 || Integer.parseInt(in.substring(8, 10)) > 31) {
				throw new IllegalArgumentException();
			} else {
				if (Integer.parseInt(in.substring(8, 10)) == 11) {
					return true;
				} else {
					return false;
				}
			}

		} else if (Integer.parseInt(in.substring(5, 7)) == 9) {
			if (Integer.parseInt(in.substring(8, 10)) < 1 || Integer.parseInt(in.substring(8, 10)) > 30) {
				throw new IllegalArgumentException();
			} else {
				if (Integer.parseInt(in.substring(8, 10)) / 7 == 2 &&
						isMonday(Integer.parseInt(in.substring(0, 4)),
								Integer.parseInt(in.substring(5, 7)),
								Integer.parseInt(in.substring(8, 10)))) {
					return true;
				} else if (Integer.parseInt(in.substring(8, 10)) == 23) {

				} else {
					return false;
				}
			}

		} else if (Integer.parseInt(in.substring(5, 7)) == 10) {

		} else if (Integer.parseInt(in.substring(5, 7)) == 11) {

		} else if (Integer.parseInt(in.substring(5, 7)) == 12) {

		} else {
			throw new IllegalArgumentException();

		}


		return false;
	}

	private boolean isMonday(int year, int month, int day) {
		return true;
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
