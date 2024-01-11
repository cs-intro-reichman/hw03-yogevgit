/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
		

	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
	    //int debugDaysCounter = 0; 

		int sundayCounter = 0;


		while ( year <= 1999 && month <= 12 && dayOfMonth <= 31){
				System.out.print(dayOfMonth + "/" + month + "/" + year);
				if ((dayOfWeek == 1 && dayOfMonth == 1) || dayOfWeek == 1) {
					System.out.print(" Sunday");
					sundayCounter++;
				}
					
				System.out.println();
				advance();
					
				}
		System.out.println("During the 20th century, " + sundayCounter+  " Sundays fell on the first day of the month");
				

		}
		

	 

	
	 











	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		dayOfMonth++;
		dayOfWeek++;

		if (dayOfWeek > 7) {
			dayOfWeek = 1;
			
		}
		if (dayOfMonth > nDaysInMonth) {

			dayOfMonth = 1;
			month ++;
			nDaysInMonth = nDaysInMonth(month,year);

		}
		if (month > 12) {
			year++;
			month = 1;
			nDaysInMonth = nDaysInMonth(month,year);
		}
	 } 
