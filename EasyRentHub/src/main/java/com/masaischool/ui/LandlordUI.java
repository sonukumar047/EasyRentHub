package com.masaischool.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.masaischool.entity.Landlord;
import com.masaischool.entity.Property;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWentWrongException;
import com.masaischool.service.LandlordService;
import com.masaischool.service.LandlordServiceImpl;
import com.masaischool.service.PropertyService;
import com.masaischool.service.PropertyServiceImpl;

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
		
	}

	
//	public static void createProperty(Scanner sc) {
//		
//		System.out.print("Enter rent amount ");
//		double amount = sc.nextDouble();
//		System.out.print("Enter location ");
//		String location = sc.next();
//		System.out.print("Enter property details");
//		String propertyDet = sc.next();	
//		try {
//			//Create an object of Service Layer here
//			LandlordService landlordService = new LandlordServiceImpl();
//			Landlord landlord = landlordService.getCompanyObjectByName(companyName);
//			
//			//Create an object of Plan for given data
//			Property plan = new Property(amount, location, propertyDet);
//						
//			Set<AgeBandWisePremiumForPlan> ageBandWisePremiumForPlanSet = new HashSet<AgeBandWisePremiumForPlan>();
//			int ageBands[][] = {{18, 35}, {36, 50}, {51, 70}};
//			for(int ageBand[] : ageBands) {
//				System.out.println("For age band" + ageBand[0] + "-" + ageBand[1]);
//				System.out.print("Enter premium ");
//				double premiumAmount = sc.nextDouble();
//				System.out.print("Enter surcharge ");
//				double surchargeAmount = sc.nextDouble();
//				ageBandWisePremiumForPlanSet.add(new AgeBandWisePremiumForPlan(plan, null, premiumAmount, surchargeAmount));				
//			}
//			
//			plan.setAgeBandWisePremiumSet(ageBandWisePremiumForPlanSet);
//			
//			PlanService planService = new PlanServiceImpl();
//			planService.addPlan(plan);
//			System.out.println("Plan added successfully");
//		}catch(SomeThingWentWrongException | NoRecordFoundException ex) {
//			System.out.println(ex.getMessage());
//		}
//	}
	
	public static void updatePropertyAndStatus(Scanner sc) {
		System.out.print("Enter id ");
		int id = sc.nextInt();
		System.out.print("Enter Property Name ");
		String propertyName = sc.next();
		System.out.print("Enter Estd Year");
		int estd = sc.nextInt();
		System.out.print("Enter rent amount ");
		double amount = sc.nextDouble();
		System.out.print("Enter location ");
		String location = sc.next();
		System.out.print("Enter property details");
		String propertyDet = sc.next();
		try {
			//get company entity details from company name
			PropertyService propertyService = new PropertyServiceImpl();
//			Property property = propertyService.getPropertyObjectByName(propertyName);
			
			//Create Plan object with updated information
			Property property = new Property(propertyName, estd, amount, location, propertyDet);
			property.setId(id);
			
			propertyService.updateProperty(property);
			System.out.println("Property updated successfully");
		}catch(SomeThingWentWrongException | NoRecordFoundException ex){
			System.out.println(ex.getMessage());
		}
	}

	

}
