/**
 * This course project is copyright of CyberTek ©CyberTek[2017]. All rights reserved. 
 * Any redistribution or reproduction of part or all of the contents in any form is 
 * prohibited without the express consent of CyberTek.
 */
package date;


public class Main {

	public static void main(String[] args) {
		Date d1 = new Date(12,27,1997);
		
		System.out.println("Date:"+d1);
		if(Date.isValid(1, 21, 2011)){
			System.out.println(d1 + " is a valid date");
		}else{
			System.out.println(d1 + " is NOT a valid date");
		}
		
		System.out.println("Age:"+d1.age());
		
		System.out.println((new Date(12,1,2017)).dateToWords());
	}

}
