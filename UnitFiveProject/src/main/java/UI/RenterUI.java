package UI;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;

import ENTITY.LoggedInUserId;
import ENTITY.Renter;
import EXCEPTION.NoRecordFoundException;
import EXCEPTION.SomeThingWentWrongException;
import SERVICE.OrderService;
import SERVICE.OrderServiceImpl;
import SERVICE.RenterService;
import SERVICE.RenterServiceImpl;

public class RenterUI {

	public static void userRegistration(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print(ConsoleColors.PURPLE_ITALIC+"Enter name "+ConsoleColors.RED+" \u2665"+ConsoleColors.RESET);
		String name = sc.next();
		System.out.print(ConsoleColors.PURPLE_ITALIC+"Enter username "+ConsoleColors.BROWN+" \u2615"+ConsoleColors.RESET);
		String username = sc.next();
		System.out.print(ConsoleColors.PURPLE_ITALIC+"Enter password "+ConsoleColors.GREEN+" \uD83D\uDD11"+ConsoleColors.RESET);
		String password = sc.next();
		System.out.print(ConsoleColors.PURPLE_ITALIC+"Enter date of birth "+ConsoleColors.BANANA_YELLOW+" \u2602"+ConsoleColors.RESET);
		LocalDate dateOfBirth = LocalDate.parse(sc.next());
		
		Renter renter = new Renter(name,username,password,dateOfBirth, new HashSet<>());
		
		try {
			RenterService customerService = new RenterServiceImpl();
			customerService.addRenter(renter);
			System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Renter Regestered Successfully"+ConsoleColors.FOREST_GREEN+" \u2713"+ConsoleColors.RESET);
		}catch(SomeThingWentWrongException ex) {
			System.out.println(ex);
		}
		
	}
	public static void userLogin(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print(ConsoleColors.BLUE+"Enter username "+ConsoleColors.BROWN+" \u2602"+ConsoleColors.RESET);
		String username = sc.next();
		System.out.print(ConsoleColors.BLUE+"Enter password "+ConsoleColors.GREEN+" \uD83D\uDD11"+ConsoleColors.RESET);
		String password = sc.next();
		try {
			RenterService renterService = new RenterServiceImpl();
			renterService.login(username, password);
			System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Loged in Successfully"+ConsoleColors.YELLOW+" \uD83C\uDFC6"+ConsoleColors.RESET);
			userMenu(sc);
		} catch (NoRecordFoundException | SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void rentNewProperty(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println(ConsoleColors.DARK_BLUE+"Enter Property Id"+ConsoleColors.WHITE+" \u2605"+ConsoleColors.RESET);
		int id = sc.nextInt();
		System.out.print(ConsoleColors.DARK_BLUE+"Enter Property name "+ConsoleColors.BLUE+" \uD83C\uDF0D"+ConsoleColors.RESET);
		String propertyName = sc.next();
		try {
			OrderService orderService = new OrderServiceImpl();
			orderService.renterProperty(id, propertyName);
			System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Property Rented Successfully"+ConsoleColors.FOREST_GREEN+" \uD83C\uDFC6"+ConsoleColors.RESET);
		} catch (SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}

	private static void ViewRenterProperties(Scanner sc) {
		// TODO Auto-generated method stub
		try {
			RenterService renterService = new RenterServiceImpl();
			renterService.ViewRentedProperty();
		} catch (NoRecordFoundException | SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}


	private static void ChangePassword(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print(ConsoleColors.BLACK_BRIGHT+"Enter old password "+ConsoleColors.GREEN+" \uD83D\uDD11"+ConsoleColors.RESET);
		String oldPassword = sc.next();
		System.out.print(ConsoleColors.GREEN+"Enter new password "+ConsoleColors.GREEN+" \uD83D\uDD11"+ConsoleColors.RESET);
		String newPassword = sc.next();
		System.out.print(ConsoleColors.GREEN_BOLD+"Re-Enter new password "+ConsoleColors.GREEN+" \uD83D\uDD11"+ConsoleColors.RESET);
		String reEnterNewPassword = sc.next();
		
		if(!newPassword.equals(reEnterNewPassword)) {
			System.out.println(ConsoleColors.RED_STRIKE+"New password and Re-Entered password mismtached"+ConsoleColors.RED+" \u2717"+ConsoleColors.RESET);
			return;
		}else if(newPassword.equals(oldPassword)) {
			System.out.println(ConsoleColors.YELLOW_BOLD+"New password and old password must be different"+ConsoleColors.BLACK_BOLD+" \uD83D\uDCA3"+ConsoleColors.RESET);
			return;
		}

		try {
			RenterService customerService = new RenterServiceImpl();
			customerService.changePassword(oldPassword, reEnterNewPassword);
			System.out.println(ConsoleColors.GREEN_BOLD+"Password updated"+ConsoleColors.BROWN+" \u2615"+ConsoleColors.RESET);
		}catch(SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private static void DeleteAccount(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print(ConsoleColors.RED_BOLD_BRIGHT+"Are you sure you want to delete your account?[y/n] "+ConsoleColors.RED+" \u2717"+ConsoleColors.RESET);
		char choice = sc.next().toLowerCase().charAt(0);
		if(choice == 'y') {
			try {
				RenterService renterService = new RenterServiceImpl();
				renterService.deleteAccount();
				System.out.println(ConsoleColors.RED_BOLD+"Its really sad to see you go, As per your request account is deleted"+ConsoleColors.BLUE_BOLD+" \u270C"+ConsoleColors.RESET);			
			}catch(SomeThingWentWrongException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
	}
	private static void userMenu(Scanner sc) {
		int choice = 0;
		do {
			displayUserMenu();
			System.out.print(ConsoleColors.CYAN+"Enter selection "+ConsoleColors.GREEN+" \u2713"+ConsoleColors.RESET);
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				AdminUI.viewProperty();
				break;
			case 2:
				rentNewProperty(sc);
				break;
			case 3:
				ViewRenterProperties(sc);
				break;
			case 4:
				ChangePassword(sc);
				break;
			case 5 :
				DeleteAccount(sc);
				System.out.println(ConsoleColors.RED_BOLD+"Account Deleted Successfully"+ConsoleColors.RED+" \u2717"+ConsoleColors.RESET);
				break;
			case 0:
				LoggedInUserId.loggedInUserId = -1; 
				System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"LogedOut Successfully"+ConsoleColors.BANANA_YELLOW+" \uD83D\uDE80"+ConsoleColors.RESET);
				break;
			default:
				System.out.println(ConsoleColors.RED_STRIKE+"Invalid Selection, try again"+ConsoleColors.BLACK_BOLD+" \uD83D\uDCA3"+ConsoleColors.RESET);
			}
		} while (choice != 0);

	}
	private static void displayUserMenu() {
		System.out.println(ConsoleColors.PURPLE+"1. View All Property"+ConsoleColors.BANANA_YELLOW+" \uD83D\uDCFD"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.PURPLE+"2. Rent a new Property"+ConsoleColors.RED+" \u2665"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.PURPLE+"3. View Rented Property"+ConsoleColors.BLACK+" \uD83D\uDCF7"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.PURPLE+"4. Change Password"+ConsoleColors.GREEN+" \uD83D\uDD11"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.PURPLE+"5. Delete Account"+ConsoleColors.RED+" \u2717"+ConsoleColors.RESET);
		System.out.println(ConsoleColors.PURPLE+"0. Logout"+ConsoleColors.YELLOW+" \uD83D\uDE80"+ConsoleColors.RESET);

	}



}
