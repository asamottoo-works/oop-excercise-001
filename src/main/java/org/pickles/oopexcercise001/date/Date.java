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
		this.month = new Month(monthString);
		this.day = new Day(dayString);
	}

	public Date(Year year, int month, int day) {
		this.year = year;
		this.month = new Month(month);
		this.day = new Day(day);
	}
}
