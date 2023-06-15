package com.masaischool.service;

import com.masaischool.dao.RenterDAO;
import com.masaischool.dao.RenterDAOImpl;
import com.masaischool.entity.Renter;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWentWrongException;

public class RenterServiceImpl implements RenterService {

	@Override
	public void addRenter(Renter renter) throws SomeThingWentWrongException {
		RenterDAO renterDAO = new RenterDAOImpl();
		renterDAO.addRenter(renter);
		
	}

	@Override
	public void login(String username, String password) throws SomeThingWentWrongException, NoRecordFoundException {
		RenterDAO customerDAO = new RenterDAOImpl();
		customerDAO.login(username, password);
		
	}

	
}
