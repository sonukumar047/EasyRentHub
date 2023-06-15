package com.masaischool.service;

import com.masaischool.entity.Renter;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWentWrongException;

public interface RenterService {

	void addRenter(Renter renter)throws SomeThingWentWrongException;
	void login(String username, String password)throws SomeThingWentWrongException, NoRecordFoundException;

}
