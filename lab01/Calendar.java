import java.util.Scanner;
public class Calendar {
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
		
        int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[][] monthAliases = {
            {"january", "jan", "jan."},
            {"february", "feb", "feb."},
            {"march", "mar", "mar."},
            {"april", "apr", "apr."},
            {"may"},
            {"june", "jun"},
            {"july", "jul"},
            {"august", "aug", "aug."},
            {"september", "sep", "sept", "sept."},
            {"october", "oct", "oct."},
            {"november", "nov", "nov."},
            {"december", "dec", "dec."}
        };
        String[] sMonth = {
            "january","february","march","april","may","june",
            "july","august","september","october","november","december"
        };
		
        int month = -1;
        int year = -1;
        
        // điền tháng
        while (month == -1) {
            System.out.print("Month: ");
            String inputMonth = keyboard.nextLine().trim().toLowerCase();
            
            try {
                int monthNum = Integer.parseInt(inputMonth);
                if (monthNum >= 1 && monthNum <= 12) {
                    month = monthNum;
                } else {
                    System.out.println("Invalid month. Please try again.");
                }
            }
            catch (NumberFormatException e) {
                boolean found = false;
                for (int i = 0; i < monthAliases.length && !found; i++) {
                    for (String alias : monthAliases[i]) {
                        if (alias.equals(inputMonth)) {
                            month = i + 1;
                            found = true;
                            break;       
                        }
                    }
                }
                if (month == -1) {
                    System.out.println("Invalid month. Please try again.");
                }
            }
        }
        // điền năm
        while (year < 0) {
            System.out.print("Year: ");
            String inputYear = keyboard.nextLine();
            try {
                year = Integer.parseInt(inputYear);
                if (year < 0) {
                    System.out.println("Invalid year. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please try again.");
            }
        }

        int days = day[month - 1];
        if (month == 2 && isLeapYear(year)) {
            days = 29;
        }

        String monthName = sMonth[month - 1];
        monthName = monthName.substring(0, 1).toUpperCase() + monthName.substring(1);
        System.out.println("There are " + days + " days in " + monthName + " of " + year);
        keyboard.close();
    }
}
