package UI;


import java.util.Scanner;

public class MainUI {

//	//Color code 
//    static String Black = "\u001b[30m";
//    static String Red = "\u001b[31m";
//    static String Green = "\u001b[32m";
//    static String Yellow = "\u001b[33m";
//    static String Blue = "\u001b[34m";
//    static String Magenta = "\u001b[35m";
//    static String Cyan = "\u001b[36m";
//    static String White = "\u001b[37m";
//    static String BrightBlack = "\u001b[30;1m";
//    static String BrightRed = "\u001b[31;1m";
//    static String BrightGreen = "\u001b[32;1m";
//    static String BrightYellow = "\u001b[33;1m";
//    static String BrightBlue = "\u001b[34;1m";
//    static String BrightMagenta = "\u001b[35;1m";
//    static String BrightCyan = "\u001b[36;1m";
//    static String BrightWhite = "\u001b[37;1m";
//    static String Reset = "\u001b[0m";
//
//    static String BackgroundBlack = "\u001b[40m";
//    static String BackgroundRed = "\u001b[41m";
//    static String BackgroundGreen = "\u001b[42m";
//    static String BackgroundYellow = "\u001b[43m";
//    static String BackgroundBlue = "\u001b[44m";
//    static String BackgroundMagenta = "\u001b[45m";
//    static String BackgroundCyan = "\u001b[46m";
//    static String BackgroundWhite = "\u001b[47m";
//    static String BackgroundBrightBlack = "\u001b[40;1m";
//    static String BackgroundBrightRed = "\u001b[41;1m";
//    static String BackgroundBrightGreen = "\u001b[42;1m";
//    static String BackgroundBrightYellow = "\u001b[43;1m";
//    static String BackgroundBrightBlue = "\u001b[44;1m";
//    static String BackgroundBrightMagenta = "\u001b[45;1m";
//    static String BackgroundBrightCyan = "\u001b[46;1m";
//    static String BackgroundBrightWhite = "\u001b[47;1m";
//    
//    //color code End Here
	
	static void displayAdminMenu() {
		System.out.println(ConsoleColors.LIGHT_GREEN+"1. Add New Property"+ConsoleColors.RED+" \u2665"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.LIGHT_GREEN+"2. View All Property"+ConsoleColors.BROWN+" \uD83D\uDCF7"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.LIGHT_GREEN+"3. Update Property Details"+ConsoleColors.TEAL+" \u2666"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.LIGHT_GREEN+"4. View All Renter"+ConsoleColors.BLUE+" \uD83D\uDDFA"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.LIGHT_GREEN+"5. Delete Property"+ConsoleColors.RED+" \u2717"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.LIGHT_GREEN+"0. Logout"+ConsoleColors.BANANA_YELLOW+" \uD83D\uDE80"+ConsoleColors.RESET);
	}

	public static void adminMenu(Scanner sc) {

		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print(ConsoleColors.PURPLE_BOLD_BRIGHT+"Enter Selection "+" \u2713"+ConsoleColors.RESET);
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				AdminUI.addProperty(sc);
				break;
			case 2:
				AdminUI.viewProperty();
				break;
			case 3:
				AdminUI.updatePropertyDetails(sc);
				break;
			case 4:
				AdminUI.viewAllRenter(sc);
				break;
			case 5:
				AdminUI.DeletePropertyById(sc);
				break;
			case 0:
				System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Bye Bye Admin"+" \u263A"+ConsoleColors.RESET);
				break;
			default:
				System.out.println(ConsoleColors.RED_STRIKE+"Invalid Selection, try again"+" \u2717"+ConsoleColors.RESET);
			}
		} while (choice != 0);
	}

	public static void LoginAsAdmin(Scanner sc) {

		System.out.print(ConsoleColors.LIGHT_PINK+"Enter username"+ConsoleColors.RESET);
		String username = sc.next();
		System.out.print(ConsoleColors.LIGHT_PINK+"Enter password "+ConsoleColors.GREEN+" \uD83D\uDD11"+ConsoleColors.RESET);
		String password = sc.next();
		if (username.equals("admin") && password.equals("admin")) {
			adminMenu(sc);
		} else {
			System.out.println(ConsoleColors.RED_STRIKE+"Invalid Username or Password"+"\u2717"+ConsoleColors.RESET);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice;
		do {
			System.out.println("\u001B[32m      /\\");
	        System.out.println("\u001B[32m     /  \\");
	        System.out.println("\u001B[32m    /    \\");
	        System.out.println("\u001B[33m   /------\\");
	        System.out.println("\u001B[33m   |      |");
	        System.out.println("\u001B[33m   |  []  |");
	        System.out.println("\u001B[33m   |      |");
	        System.out.println("\u001B[33m   |______|");
	        System.out.println("\u001B[34m  /|      |\\");
	        System.out.println("\u001B[34m / |  {}  | \\");
	        System.out.println("\u001B[34m/  |______|  \\");
	        System.out.println("\u001B[35m|____________|");
	        System.out.println("\u001B[35m|    ______  |");
	        System.out.println("\u001B[35m|   |    | | |");
	        System.out.println("\u001B[35m|   |__@_| | |");
	        System.out.println("\u001B[35m|          | |");
	        System.out.println("\u001B[35m|__________|/");

			System.out.println(ConsoleColors.TEAL+"**********"+ConsoleColors.RED_UNDERLINED+"WELCOME TO EasyRentHub"+ConsoleColors.TEAL+"**********"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.BOXING+ConsoleColors.BLUE_ITALIC+"Let's Enjoy The Housing System"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.ORANGE+"1. Login As Admin"+ConsoleColors.GREEN_BOLD+" \uD83D\uDD11"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.ORANGE+"2. Login As Renter"+ConsoleColors.GREEN_BOLD+" \uD83D\uDD11"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.ORANGE+"3. Renter Registration"+ConsoleColors.RED+" \u273F"+ConsoleColors.RESET);
			System.out.println(ConsoleColors.ORANGE+"0. Exit"+ConsoleColors.RED+" \u2665"+ConsoleColors.RESET);
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				LoginAsAdmin(sc);
				break;
				
			case 2:
				RenterUI.userLogin(sc);
				break;
			case 3:
				RenterUI.userRegistration(sc);
				break;
			case 0:
				System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Thanks for using the services"+ConsoleColors.RESET);
				break;
			default:
				System.out.println(ConsoleColors.RED_STRIKE+"Invalid Selection, try again"+ConsoleColors.RESET);
			}
		} while (choice != 0);
	}
}

