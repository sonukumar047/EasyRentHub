package com.masaischool.service;

import com.masaischool.dao.PropertyDAO;
import com.masaischool.dao.PropertyDAOImpl;
import com.masaischool.entity.Property;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWentWrongException;

public class PropertyServiceImpl implements PropertyService {

	@Override
	public void updateProperty(Property property) throws SomeThingWentWrongException, NoRecordFoundException{
		//Create an object of DAO class here
		PropertyDAO propertyDAO = new PropertyDAOImpl();
		propertyDAO.updateProperty(property);
	}
}
