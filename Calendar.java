public class Calendar {//yogev
	// Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2; // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January

	// Gets a year (command-line argument), and tests the functions isLeapYear and
	// nDaysInMonth.
	public static void main(String args[]) {

		int currentYear = Integer.parseInt(args[0]);

		while (year <= currentYear && month <= 12 && dayOfMonth <= 31) {

			if (year == currentYear) {

				System.out.print(dayOfMonth + "/" + month + "/" + year);
				if ((dayOfWeek == 1 && dayOfMonth == 1) || dayOfWeek == 1) {
					System.out.print(" Sunday");
				}
				System.out.println();

			}

			advance();

		}

	}

	private static void advance() {
		dayOfMonth++;
		dayOfWeek++;

		if (dayOfWeek > 7) {
			dayOfWeek = 1;

		}
		if (dayOfMonth > nDaysInMonth) {

			dayOfMonth = 1;
			month++;
			nDaysInMonth = nDaysInMonth(month, year);

		}
		if (month > 12) {
			year++;
			month = 1;
			nDaysInMonth = nDaysInMonth(month, year);
		}

	}

	private static boolean isLeapYear(int year) {
		boolean isLeapYear;
		isLeapYear = ((year % 400) == 0);
		isLeapYear = isLeapYear || (((year % 4) == 0) && ((year % 100) != 0));

		return isLeapYear;

	}

	private static int nDaysInMonth(int month, int year) {
		if ((month == 4) || (month == 6) || (month == 9) || (month == 11))
			return 30;
		else {
			if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10)
					|| (month == 12)) {
				return 31;
			} else {
				if (isLeapYear(year))
					return 29;
				else
					return 28;

			}
		}

	}
}
