package com.masaischool.service;

import com.masaischool.dao.LandlordDAO;
import com.masaischool.dao.LandlordDAOImpl;
import com.masaischool.entity.Landlord;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWentWrongException;

public class LandlordServiceImpl implements LandlordService{

	@Override
	public void addLandlord(Landlord customer) throws SomeThingWentWrongException {
		//Create an object of CustomerDAO
		LandlordDAO landLordDAO = new LandlordDAOImpl();
		landLordDAO.addLandlord(customer);
	}
	
	@Override
	public void login(String username, String password) 
			throws SomeThingWentWrongException, NoRecordFoundException{
		//Create an object of CustomerDAO
		LandlordDAO customerDAO = new LandlordDAOImpl();
		customerDAO.login(username, password);		
	}
}
