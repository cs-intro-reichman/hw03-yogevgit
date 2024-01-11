/*
 * Checks if a given year is a leap year or a common year,
 * and computes the number of days in a given month and a given year. 
 */
public class Calendar0 {	
	
	public static boolean isLeapYear(int year) {
    if (year % 4 == 0) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return true;
        }
    }
    return false;
}
public static int nDaysInMonth(int month, int year) {
    switch (month) {
        case 2:
            return isLeapYear(year) ? 29 : 28;
        case 4: 
        case 6:
        case 9:
        case 11:
            return 30;
        default:
            return 31;
    }
}
private static void nDaysInMonthTest(int year) {
    for (int month = 1; month <= 12; month++) {
        int days = nDaysInMonth(month, year);
        System.out.println("Month " + month + " has " + days + " days");
    }
}
}

	
	
