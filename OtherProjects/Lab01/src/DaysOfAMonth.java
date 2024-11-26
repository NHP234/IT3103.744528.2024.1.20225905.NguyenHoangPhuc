import java.util.Scanner;
public class DaysOfAMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = -1;
        int year = -1;
        while (true) {
            System.out.print("Nguyen Hoang Phuc 20225905\nEnter a month: ");
            String monthInput = scanner.next();
            month = getMonthNumber(monthInput);
            if (month == -1) {
                System.out.println("Invalid month input. Please try again.");
                continue;
            }
            System.out.print("Enter a year: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year < 0 ) {
                    System.out.println("Invalid year input. Please try again.");
                    continue;
                }
            } else {
                System.out.println("Invalid year input. Please try again.");
                scanner.next(); // Clear the invalid input
                continue;
            }
            int days = getDaysInMonth(month, year);
            System.out.println("There are " + days + " days.");
            break;
        }
        scanner.close();
    }

    public static int getMonthNumber(String monthInput) {
        switch (monthInput) {
            case "1":
            case "January":
            case "Jan.":
            case "Jan":
                return 1;
            case "2":
            case "February":
            case "Feb.":
            case "Feb":
                return 2;
            case "3":
            case "March":
            case "Mar.":
            case "Mar":
                return 3;
            case "4":
            case "April":
            case "Apr.":
            case "Apr":
                return 4;
            case "5":
            case "May":
                return 5;
            case "6":
            case "June":
            case "Jun":
                return 6;
            case "7":
            case "July":
            case "Jul":
                return 7;
            case "8":
            case "August":
            case "Aug.":
            case "Aug":
                return 8;
            case "9":
            case "September":
            case "Sept.":
            case "Sep":
            case "Sept":
                return 9;
            case "10":
            case "October":
            case "Oct.":
            case "Oct":
                return 10;
            case "11":
            case "November":
            case "Nov.":
            case "Nov":
                return 11;
            case "12":
            case "December":
            case "Dec.":
            case "Dec":
                return 12;
            default:
                return -1;
        }
    }

    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 31;
        }
    }
}
