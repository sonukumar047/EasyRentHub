package com.masaischool.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.masaischool.entity.Landlord;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWentWrongException;
import com.masaischool.service.LandlordService;
import com.masaischool.service.LandlordServiceImpl;

public class LandlordUI {

	public static void registerLandlordAccount(Scanner sc) {
		System.out.print("Enter name ");
		String name = sc.next();
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		System.out.print("Enter date of birth ");
		LocalDate dateOfBirth = LocalDate.parse(sc.next());
		
		//Create an object of customer
		Landlord landlord = new Landlord(name, username, password, dateOfBirth);
		
		try {
			//Create an object of CustomerService
			LandlordService landlordService = new LandlordServiceImpl();
			landlordService.addLandlord(landlord);
			System.out.println("Landlord added successfully");
		}catch(SomeThingWentWrongException ex) {
			System.out.println(ex);
		}
		
	}

	public static void logInLandlordAccount(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		try {
			LandlordService customerService = new LandlordServiceImpl();
			customerService.login(username, password);
			App.landlordMenu(sc);
		}catch(NoRecordFoundException | SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
		}
		o
	}

}
