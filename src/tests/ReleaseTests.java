/**
 * This course project is copyright of CyberTek ©CyberTek[2017]. All rights reserved. 
 * Any redistribution or reproduction of part or all of the contents in any form is 
 * prohibited without the express consent of CyberTek.
 */
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import date.Date;

public class ReleaseTests {
	
	@Test
	public void isLeapTest(){
		Date d1 = new Date(11,18,2016);
		Date d2 = new Date(1,1,1900);
		assertEquals(true, Date.isLeapYear(d1.getYear()));
		assertEquals(false, Date.isLeapYear(d2.getYear()));
	}
	
	@Test
	public void isValidTest(){
		assertEquals(false, Date.isValid(2, 29, 2011));
		assertEquals(true, Date.isValid(2,29,2000));
	}
	
	@Test
	public void toStringTest(){
		Date d1 = new Date(10, 15, 2017);
		Date d2 = new Date(2, 28, 2017);
		assertEquals("10/15/2017", d1.toString());
		assertEquals("2/28/2017", d2.toString());
	}
	
	@Test
	public void compareToTest(){
		Date d1 = new Date(10, 9, 1987);
		Date d2 = new Date(9, 10, 1987);
		Date d3 = new Date(10, 9, 1987);
		Date d4 = new Date(9, 10, 2007);
		assertEquals(-1, d2.compareTo(d1));
		assertEquals(0, d1.compareTo(d3));
		assertEquals(-1, d2.compareTo(d3));
		assertEquals(1, d4.compareTo(d3));
	}
	
	@Test
	public void toWordsTest(){
		Date d1 = new Date(11, 19, 2017);
		Date d2 = new Date(1, 1, 2000);
		Date d3 = new Date(4, 29, 1919);
		assertEquals("November Nineteen Two Thousand Seventeen", d1.dateToWords().trim());
		assertEquals("January One Two Thousand", d2.dateToWords().trim());
		assertEquals("April Twenty Nine One Thousand Nine Hundred Nineteen", d3.dateToWords().trim());
		
	}
	
	@Test
	public void testAge(){
		Date date = new Date(12, 29, 1987);
		assertEquals(29, date.age());
		date = new Date(12, 1, 1987);
		assertEquals(30, date.age());
		date = new Date(10, 1, 2010);
		assertEquals(7, date.age());
		date = new Date(12, 1, 1985);
		assertEquals(32, date.age());
	}

	
	
}
