package org.pickles.oopexcercise001.date;

public class Date {
	public final Year year;
	public final Month month;
	public final Day day;

	public Date(String dateString) {
		String yearString = dateString.substring(0, 4);
		String monthString = dateString.substring(5, 7);
		String dayString = dateString.substring(8, 10);

		this.year = new Year(yearString);
		this.month = Month.numberOf(monthString);
		this.day = new Day(dayString);
	}

	public Date(Year year, Month month, Day day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public Date getYesterday() {
		Year resYear = this.year;
		Month resMonth = this.month;
		Day resDay = this.day;
		if (resDay.same(1)) {
			if (this.month.same(Month.JANUARY)) {
				resYear = this.year.previous();
			}
			resMonth = this.month.previous();
			resDay = LastDaysOfMonthCalculator.execute(this.year, resMonth);
		} else {
			resDay = this.day.previous();
		}
		return new Date(resYear, resMonth, resDay);
	}

	public Date getTomorrow() {
		Year resYear = this.year;
		Month resMonth = this.month;
		Day resDay = this.day;

		if (!resDay.same(LastDaysOfMonthCalculator.execute(this.year, this.month))) {
			return new Date(resYear, resMonth, resDay.next());
		}

		if (resMonth.same(Month.DECEMBER)) {
			resYear = this.year.next();
		}
		resMonth = resMonth.next();
		return new Date(resYear, resMonth, Day.FIRST);
	}

	public String toString() {
		return year.toString() + "/" + month.toString() + "/" + day.toString();
	}
}
