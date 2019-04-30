package date;

/**
 * This course project is copyright of CyberTek ©CyberTek[2017]. All rights reserved. 
 * Any redistribution or reproduction of part or all of the contents in any form is 
 * prohibited without the express consent of CyberTek.
 */

import java.util.Calendar;

public class Date implements Comparable<Date> {

	private static final int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	protected final int month;
	protected final int day;
	protected final int year;

	/*
	 * Initialized a new date from the month, day and year.
	 * 
	 * @param month the month (between 1 and 12)
	 * 
	 * @param day the day (between 1 and 28-31, depending on the month)
	 * 
	 * @param year the year
	 * 
	 */

	public Date(int month, int day, int year) {
		if (!isValid(month, day, year)) {
			System.out.println("Invalid Date");
			throw new IllegalArgumentException();
		}
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/*
	 * @return month of that month
	 */
	public int getMonth() {
		return this.month;
	}

	/*
	 * @return day of that day
	 */
	public int getDay() {
		return this.day;
	}

	/*
	 * @return year of that year
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * This method checks if a given date is a valid calendar date
	 * 
	 * @param m month
	 * @param d day
	 * @param y year. (A year is no less than 1900, and no greater than 2100)
	 * @return true if the given date is a valid calendar date. false otherwise
	 */
	public static boolean isValid(int m, int d, int y) {
		if (m < 13 && m > 0 && d < 32 && d > 0 && y > 1900 && y < 2100) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @param year
	 * @return true if the given year is a leap year. false otherwise.
	 */
	public static boolean isLeapYear(int year) {
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			return true;
		}
		return false;
	}

	/**
	 * Compare this date to that date.
	 * 
	 * @return {a negative integer or zero or a positive integer}, depending on
	 *         whether this date is {before, equal to, after} that date
	 */

	public int compareTo(Date that) {
		// if this date is before that date -> -1
		// if this date is equal to that date -> 0
		// if this date is after that date -> 1
		// this.year to that.year
		// this.day to that.day
		// this.month to that.year
		// TODO
		if (this.year > that.year)
			return 1;
		if (this.year < that.year)
			return -1;
		if (this.year == that.year) {
			if (this.month > that.month)
				return 1;
			if (this.month < that.month)
				return -1;
			if (this.month == that.month) {
				if (this.day > that.day)
					return 1;
				if (this.day < that.day)
					return -1;
			}
		}
		return 0;
	}

	/**
	 * Return a string representation of this date.
	 * 
	 * @return the string representation in the format MM/DD/YYYY
	 */
	public String toString() {
		// TODO
		String date = "";

		date += this.month + "/" + this.day + "/" + this.year;
		return date;

	}

	/**
	 * 
	 * @return the word representation of the date. Example: (new
	 *         Date(12,1,2017)).dateToWords() returns "December One Two Thousand
	 *         Seventeen"
	 */
	public String dateToWords() {
		String[] monthWords = { "", "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		String[] numbersLessThanTen = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
				"Ten" };
		String[] numbersBetweenTenAndTwenty = { "", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
				"Seventeen", "Eighteen", "Nineteen" };
		String[] multiplesOfTen = { "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String[] yearWords = { "Hundred", "Thousand" };

		// TODO
		String date = "";

		date = date + monthWords[this.month] + " ";

		if (this.day <= 10) {

			date = date + numbersLessThanTen[this.day] + " ";

		} else if (this.day > 10 && this.day < 20) {

			date = date + numbersBetweenTenAndTwenty[this.day - 10] + " ";

		} else {

			if (this.day < 30)
				date = date + multiplesOfTen[1] + " ";
			else
				date = date + multiplesOfTen[2] + " ";

			date = date + numbersLessThanTen[this.day % 10] + " ";

		}

		if (this.year - 2000 >= 0)
			date = date + numbersLessThanTen[2] + " ";
		else
			date = date + numbersLessThanTen[1] + " ";

		date = date + yearWords[1] + " ";
		int temp = this.year;

		temp = temp % 1000;

		temp = temp / 100;

		date = date + numbersLessThanTen[temp] + " ";

		if (temp != 0)
			date = date + yearWords[0] + " ";

		temp = this.year;

		temp = temp % 100;

		temp = temp / 10;

		if (temp >= 2) {

			date = date + multiplesOfTen[temp - 1] + " ";

			temp = this.year;

			temp = temp % 10;

			date = date + numbersLessThanTen[temp];

		} else if (temp == 1) {

			temp = this.year;

			temp = temp % 10;

			date = date + numbersBetweenTenAndTwenty[temp];

		} else {

			temp = this.year;

			temp = temp % 10;

			date = date + numbersLessThanTen[temp];

		}
		return date;
	}

	public int age() {
		Calendar cal = Calendar.getInstance();
		int d = cal.get(Calendar.DAY_OF_MONTH);
		int m = cal.get(Calendar.MONTH); // starts from 0 to 11
		int y = cal.get(Calendar.YEAR);

		int age = 0;

		age = y - this.year;
		if (m < this.month) {
			age--;
		} else if (m == this.month) {
			if (this.day >= d) {
				age++;
			}
		}

		return age;
	}
}