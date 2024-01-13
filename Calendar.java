public class Calendar {
    public static void main(String[] args) {
        // Check if a year is provided as command-line argument
        if (args.length < 1) {
            System.out.println("Please provide a year as a command-line argument.");
            return;
        }

        int year = Integer.parseInt(args[0]);
        int dayOfWeek = getDayOfWeek(1, 1, year); // Get the day of the week for January 1st of the given year

        for (int month = 1; month <= 12; month++) {
            for (int day = 1; day <= ndaysInMonth(month, year); day++) {
                if (dayOfWeek == 7) {
                    System.out.println(day + "/" + month + "/" + year + " Sunday");
                } else {
                    System.out.println(day + "/" + month + "/" + year);
                }
                dayOfWeek = dayOfWeek % 7 + 1;
            }
        }
    }

    private static int ndaysInMonth(int month, int year) {
        
		if (isLeapYear(year) == true && month == 2)
			return 29;
		else if (isLeapYear(year) == false && month == 2)
			return 28;
		else if ((month == 1))
			return 31;
		else if ((month == 3))
			return 31;
		else if ((month == 4))
			return 30;
		else if ((month == 5))
			return 31;
		else if ((month == 6))
			return 30;
		else if ((month == 7))
			return 31;
		else if ((month == 8))
			return 31;
		else if ((month == 9))
			return 30;
		else if ((month == 10))
			return 31;
		else if ((month == 11))
			return 30;
		else
			return 31;
    }

    private static boolean isLeapYear(int year) {
        boolean isLeapYear;
		isLeapYear = ((year % 400) == 0);
		isLeapYear = isLeapYear || (((year % 4) == 0) && ((year % 100) != 0));

		return isLeapYear;
    }

    private static int getDayOfWeek(int day, int month, int year) {
        // Calculate the day of the week for a given date
        // There are several algorithms for this, such as Zeller's Congruence
        // For simplicity, let's use a brute force approach, starting from 1/1/1900
        int totalDays = 0;
        for (int y = 1900; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        for (int m = 1; m < month; m++) {
            totalDays += ndaysInMonth(m, year);
        }

        totalDays += day - 1;

        // 1/1/1900 was a Monday, which is '1' in our system
        return totalDays % 7 + 1;
    }
}
