package UI;

import java.util.List;
import java.util.Scanner;

import ENTITY.Property;
import EXCEPTION.NoRecordFoundException;
import EXCEPTION.SomeThingWentWrongException;
import SERVICE.PropertyService;
import SERVICE.PropertyServiceImpl;
import SERVICE.RenterService;
import SERVICE.RenterServiceImpl;

public class AdminUI {

	public static void addProperty(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print(ConsoleColors.BLUE_ITALIC+"Enter property name "+ConsoleColors.RESET);
		String propertyName = sc.next();
		System.out.print(ConsoleColors.BLUE_ITALIC+"Enter ESTD year"+ConsoleColors.RESET);
		int estd = sc.nextInt();
		System.out.println(ConsoleColors.BLUE_ITALIC+"Enter rentel price"+ConsoleColors.RESET);
		int rentPrice = sc.nextInt();
		System.out.print(ConsoleColors.BLUE_ITALIC+"Enter location "+ConsoleColors.RESET);
		String propertylocation = sc.next();
		
		Property property = new Property(propertyName, estd, rentPrice, propertylocation, null);

//		 Create an object of Service Layer here	
		PropertyService propertyService = new PropertyServiceImpl();
		try {
			propertyService.addProperty(property);
			System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"Property Added Successfully"+ConsoleColors.RESET);
		} catch (SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage() );
		}
	}

	public static void viewProperty() {
		// TODO Auto-generated method stub
		PropertyService propertyService = new PropertyServiceImpl();
		
		try {
			List<Property> propertyList = propertyService.getPropertyList();
			propertyList.forEach(property -> System.out
					.println("Id: " + property.getId() + " Property Name:" + property.getPropertyName() + " Property Estd Year:"
							+ property.getEstd() + "Property Rental Price" + property.getRentPrice()+ "Property Location " + property.getPropertlocation()));
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void updatePropertyDetails(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print(ConsoleColors.PURPLE_ITALIC+"Enter id "+ConsoleColors.RESET);
		int id = sc.nextInt();
		System.out.print(ConsoleColors.PURPLE_ITALIC+"Enter property name "+ConsoleColors.RESET);
		String propertyName = sc.next();
		System.out.print(ConsoleColors.PURPLE_ITALIC+"Enter ESTD year"+ConsoleColors.RESET);
		int estd = sc.nextInt();
		System.out.println(ConsoleColors.PURPLE_ITALIC+"Enter rentel price"+ConsoleColors.RESET);
		int rentPrice = sc.nextInt();
		System.out.print(ConsoleColors.PURPLE_ITALIC+"Enter location "+ConsoleColors.RESET);
		String propertylocation = sc.next();

		// code to create Company Entity object
		Property property = new Property();
		property.setId(id);
		property.setPropertyName(propertyName);
		property.setEstd(estd);
		property.setPropertlocation(propertylocation);
		property.setRentPrice(rentPrice);

		PropertyService propertyService = new PropertyServiceImpl();

		try {
			propertyService.updateProperty(property);
			System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT+"property updated successfully"+ConsoleColors.BANANA_YELLOW+" \uD83C\uDFC6"+ConsoleColors.RESET);
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}

	}

	
	
	public static void DeletePropertyById(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println(ConsoleColors.BLACK_ITALIC+"Enter property Id"+ConsoleColors.RESET);
		int id = sc.nextInt();

		PropertyService propertyService = new PropertyServiceImpl();
		try {
			propertyService.DeletePropertyById(id);
			System.out.println(ConsoleColors.RED_BOLD_BRIGHT+"Property Deleted Successfully"+ConsoleColors.RED+" \u2717"+ConsoleColors.RESET);
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void viewAllRenter(Scanner sc) {
		// TODO Auto-generated method stub
		try {
			RenterService renterService = new RenterServiceImpl();
			List<Object[]> renterList = renterService.getRenterList();
			for (Object obj[] : renterList) {
				System.out.println("Name: " + obj[0] + " Username: " + obj[1] + " Date of Birth: " + obj[2]
						);
			}
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

}
