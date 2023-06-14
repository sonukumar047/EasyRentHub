package com.masaischool.ui;

import java.util.Scanner;

public class App {
	
	static void displaylandlordMenu() {
		
		System.out.println("1. Register for an Landlord account by providing necessary information");
		System.out.println("2. Log in to the Landlord account using registered credentials");
		System.out.println("3. Create and manage property listings");
		System.out.println("4. Update rental details and availability status of properties");
		System.out.println("5. Receive and review rental offers for the listed properties");
		System.out.println("6. Accept or reject rental offers based on Landlord preferences and criteria");
		System.out.println("7. Log out from the owner account");
//		System.out.println("0. Logout");
	}
	
	static void landlordMenu(Scanner sc) {
		int choice = 0;
		do {
			displaylandlordMenu();
			System.out.print("Enter selection ");
			choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				LandlordUI.registerLandlordAccount(sc);
    				break;
    			case 2:
    				LandlordUI.logInLandlordAccount();
    				break;
//    			case 3:
//    				LandlordUI.managePropertyList(sc);
//    				break;
//    			case 4:
//    				LandlordUI.updateProperty(sc);
//    				break;
//    			case 5:
//    				LandlordUI.receiveAndReviewTanentOffer();
//    				break;
//    			case 6:
//    				LandlordUI.acceptOrRejectTanentOffer(sc);
//    				break;
//    			case 7:
//    				LandlordUI.logOutOwenerAcc(sc);
//    				break;
    			case 0:
    				System.out.println("Bye Bye Land Lord");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);	
	}
	
	static void landlordLogin(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("admin") && password.equals("admin")) {
			landlordMenu(sc);
		}else {
			System.out.println("Invalid Username of Password");
		}
	}
	
    public static void main( String[] args ){
    	Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	do {
    		System.out.println("1. Admin Login");
    		System.out.println("2. Customer Login");
    		System.out.println("3. Customer Registration");
    		System.out.println("0. Exit");
    		System.out.print("Enter Selection ");
    		choice = sc.nextInt();
    		switch(choice) {
    			case 1:
    				landlordLogin(sc);
    				break;
//    			case 2:
//    				RenterUI.renterLogin(sc);
//    				break;
//    			case 3:
//    				RenterUI.renterRegistration(sc);
//    				break;
    			case 0:
    				System.out.println("Thanks for using the services");
    				break;
    			default:
    				System.out.println("Invalid Selection, try again");
    		}
    	}while(choice != 0);
    	sc.close();
    }
}
