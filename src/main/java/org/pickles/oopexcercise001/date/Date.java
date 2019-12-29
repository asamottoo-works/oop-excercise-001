package org.pickles.oopexcercise001.date;

public class Date {
	public Year year;
	public Month month;
	public Day day;

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

	public String toString() {
		return year.toString() + "/" + month.toString() + "/" + day.toString();
	}
}
