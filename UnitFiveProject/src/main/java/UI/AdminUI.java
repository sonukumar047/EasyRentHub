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
		System.out.print("Enter property name ");
		String propertyName = sc.next();
		System.out.print("Enter ESTD year");
		int estd = sc.nextInt();
		System.out.println("Enter rentel price");
		int rentPrice = sc.nextInt();
		System.out.print("Enter location ");
		String propertylocation = sc.next();
		
		Property property = new Property(propertyName, estd, rentPrice, propertylocation, null);

//		 Create an object of Service Layer here	
		PropertyService propertyService = new PropertyServiceImpl();
		try {
			propertyService.addProperty(property);
			System.out.println("Property added successfully");
		} catch (SomeThingWentWrongException ex) {
			System.out.println(ex.getMessage());
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
		System.out.print("Enter id ");
		int id = sc.nextInt();
		System.out.print("Enter property name ");
		String propertyName = sc.next();
		System.out.print("Enter ESTD year");
		int estd = sc.nextInt();
		System.out.println("Enter rentel price");
		int rentPrice = sc.nextInt();
		System.out.print("Enter location ");
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
			System.out.println("property updated successfully");
		} catch (SomeThingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void DeletePropertyById(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter property Id");
		int id = sc.nextInt();

		PropertyService propertyService = new PropertyServiceImpl();
		try {
			propertyService.DeletePropertyById(id);
			System.out.println("property Deleted Successfully");
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
