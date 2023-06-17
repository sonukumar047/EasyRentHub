package UI;


import java.util.Scanner;

public class MainUI {

	static void displayAdminMenu() {
		System.out.println("1. Add New Property");
		System.out.println("2. View All Property");
		System.out.println("3. Update Property Details");
		System.out.println("4. View All Renter");
		System.out.println("5. Delete Property");
		System.out.println("0. Logout");
	}

	public static void adminMenu(Scanner sc) {

		int choice = 0;
		do {
			displayAdminMenu();
			System.out.print("Enter selection ");
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
				System.out.println("Bye Bye Admin");
				break;
			default:
				System.out.println("Invalid Selection, try again");
			}
		} while (choice != 0);
	}

	public static void LoginAsAdmin(Scanner sc) {

		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if (username.equals("admin") && password.equals("admin")) {
			adminMenu(sc);
		} else {
			System.out.println("Invalid Username or Password");
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice;
		do {

			System.out.println("1. Login As Admin");
			System.out.println("2. Login As Renter");
			System.out.println("3. Renter Registration");
			System.out.println("0. Exit");
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
				System.out.println("Thanks for using the services");
				break;
			default:
				System.out.println("Invalid Selection, try again");
			}
		} while (choice != 0);
	}
}

