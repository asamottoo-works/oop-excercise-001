package org.pickles.oopexcercise001;

import org.junit.Test;

import java.util.function.Supplier;

import static org.junit.Assert.*;

public class ReiwaHolidayTest {

	private static <T> boolean isCatchException(Supplier<T> supplier) {
		try {
			supplier.get();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	@Test
	public void checkIllegalArgumentException() {
		ReiwaHoliday checker = new ReiwaHoliday();
		assertTrue(isCatchException(() -> checker.check(null)));
		assertTrue(isCatchException(() -> checker.check("")));
		assertTrue(isCatchException(() -> checker.check("19/05/01")));
		assertTrue(isCatchException(() -> checker.check("2019-05-01")));
		assertTrue(isCatchException(() -> checker.check("2019/05/-1")));
		assertTrue(isCatchException(() -> checker.check("2019/04/30")));
		assertTrue(isCatchException(() -> checker.check("2019/05/32")));
		assertTrue(isCatchException(() -> checker.check("2019/05/00")));

		assertTrue(isCatchException(() -> checker.check("2021/01/00")));
		assertTrue(isCatchException(() -> checker.check("2021/01/32")));
		assertTrue(isCatchException(() -> checker.check("2021/02/00")));
		assertTrue(isCatchException(() -> checker.check("2021/02/29")));
		assertTrue(isCatchException(() -> checker.check("2021/03/00")));
		assertTrue(isCatchException(() -> checker.check("2021/03/32")));
		assertTrue(isCatchException(() -> checker.check("2021/04/00")));
		assertTrue(isCatchException(() -> checker.check("2021/04/31")));
		assertTrue(isCatchException(() -> checker.check("2021/05/00")));
		assertTrue(isCatchException(() -> checker.check("2021/05/32")));
		assertTrue(isCatchException(() -> checker.check("2021/06/00")));
		assertTrue(isCatchException(() -> checker.check("2021/06/31")));
		assertTrue(isCatchException(() -> checker.check("2021/07/00")));
		assertTrue(isCatchException(() -> checker.check("2021/07/32")));
		assertTrue(isCatchException(() -> checker.check("2021/08/00")));
		assertTrue(isCatchException(() -> checker.check("2021/08/32")));
		assertTrue(isCatchException(() -> checker.check("2021/09/00")));
		assertTrue(isCatchException(() -> checker.check("2021/09/31")));
		assertTrue(isCatchException(() -> checker.check("2021/10/00")));
		assertTrue(isCatchException(() -> checker.check("2021/10/32")));
		assertTrue(isCatchException(() -> checker.check("2021/11/00")));
		assertTrue(isCatchException(() -> checker.check("2021/11/31")));
		assertTrue(isCatchException(() -> checker.check("2021/12/00")));
		assertTrue(isCatchException(() -> checker.check("2021/12/32")));
	}

	@Test
	public void checkPublicHoliday2019() {
		ReiwaHoliday checker = new ReiwaHoliday();
		assertTrue(checker.check("2019/05/01"));
		assertTrue(checker.check("2019/05/03"));
		assertTrue(checker.check("2019/05/04"));
		assertTrue(checker.check("2019/05/05"));
		assertTrue(checker.check("2019/07/15"));
		assertTrue(checker.check("2019/08/11"));
		assertTrue(checker.check("2019/09/16"));
		assertTrue(checker.check("2019/09/23"));
		assertTrue(checker.check("2019/10/14"));
		assertTrue(checker.check("2019/10/22"));
		assertTrue(checker.check("2019/11/03"));
		assertTrue(checker.check("2019/11/23"));
	}

	@Test
	public void checkPublicHoliday2020() {
		ReiwaHoliday checker = new ReiwaHoliday();
		assertTrue(checker.check("2020/01/01"));
		assertTrue(checker.check("2020/01/13"));
		assertTrue(checker.check("2020/02/11"));
		assertTrue(checker.check("2020/02/23"));
		assertTrue(checker.check("2020/03/21"));
		assertTrue(checker.check("2020/04/29"));
		assertTrue(checker.check("2020/05/03"));
		assertTrue(checker.check("2020/05/04"));
		assertTrue(checker.check("2020/05/05"));
		assertTrue(checker.check("2020/07/23"));
		assertTrue(checker.check("2020/07/24"));
		assertTrue(checker.check("2020/08/10"));
		assertTrue(checker.check("2020/09/21"));
		assertTrue(checker.check("2020/09/23"));
		assertTrue(checker.check("2020/11/03"));
		assertTrue(checker.check("2020/11/23"));
	}

	@Test
	public void checkPublicHoliday2021() {
		ReiwaHoliday checker = new ReiwaHoliday();
		assertTrue(checker.check("2021/01/01"));
		assertTrue(checker.check("2021/01/11"));
		assertTrue(checker.check("2021/02/11"));
		assertTrue(checker.check("2021/02/23"));
		assertTrue(checker.check("2021/03/21"));
		assertTrue(checker.check("2021/04/29"));
		assertTrue(checker.check("2021/05/01"));
		assertTrue(checker.check("2021/05/03"));
		assertTrue(checker.check("2021/05/04"));
		assertTrue(checker.check("2021/05/05"));
		assertTrue(checker.check("2021/07/19"));
		assertTrue(checker.check("2021/08/11"));
		assertTrue(checker.check("2021/09/20"));
		assertTrue(checker.check("2021/09/23"));
		assertTrue(checker.check("2021/10/11"));
		assertTrue(checker.check("2021/11/03"));
		assertTrue(checker.check("2021/11/23"));
	}

	@Test
	public void checkWeekdayBeforePublicHoliday2019() {
		ReiwaHoliday checker = new ReiwaHoliday();
		assertFalse(checker.check("2019/10/21"));
		assertFalse(checker.check("2019/11/22"));
	}

	@Test
	public void checkWeekdayAfterPublicHoliday2019() {
		ReiwaHoliday checker = new ReiwaHoliday();
		assertFalse(checker.check("2019/07/16"));
		assertFalse(checker.check("2019/09/17"));
		assertFalse(checker.check("2019/09/24"));
		assertFalse(checker.check("2019/10/15"));
		assertFalse(checker.check("2019/10/23"));
	}

	@Test
	public void checkWeekdayBeforePublicHoliday2020() {
		ReiwaHoliday checker = new ReiwaHoliday();
		assertFalse(checker.check("2019/12/31"));
		assertFalse(checker.check("2020/02/10"));
		assertFalse(checker.check("2020/03/20"));
		assertFalse(checker.check("2020/04/28"));
		assertFalse(checker.check("2020/07/22"));
		assertFalse(checker.check("2020/11/02"));
	}

	@Test
	public void checkWeekdayAfterPublicHoliday2020() {
		ReiwaHoliday checker = new ReiwaHoliday();
		assertFalse(checker.check("2020/01/02"));
		assertFalse(checker.check("2020/01/14"));
		assertFalse(checker.check("2020/02/12"));
		assertFalse(checker.check("2020/04/30"));
		assertFalse(checker.check("2020/08/11"));
		assertFalse(checker.check("2020/09/24"));
		assertFalse(checker.check("2020/11/04"));
		assertFalse(checker.check("2020/11/24"));
	}
}
