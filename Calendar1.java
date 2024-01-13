public class Calendar1 {
    public static void main(String[] args) {
        int day = 1, month = 1, year = 1900;
        int dayOfWeek = 1; // Monday
        int sundayCount = 0;

        while (year < 2000) {
            // Print the current date and check for Sunday
            if (dayOfWeek == 7) {
                System.out.println(day + "/" + month + "/" + year + " Sunday");
                if (day == 1) {
                    sundayCount++;
                }
            } else {
                System.out.println(day + "/" + month + "/" + year);
            }

            // Advance the day
            day++;
            dayOfWeek = dayOfWeek % 7 + 1;

            // Check for end of month
            if (day > daysInMonth(month, year)) {
                day = 1;
                month++;

                // Check for end of year
                if (month > 12) {
                    month = 1;
                    year++;
                }
            }
        }

        System.out.println("During the 20th century, " + sundayCount + " Sundays fell on the first day of the month");
    }

    private static int daysInMonth(int month, int year) {
        if (month == 2) { // February
            return isLeapYear(year) ? 29 : 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) { // April, June, September, November
            return 30;
        }
        return 31;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }
}

			}
		}

	}
}
