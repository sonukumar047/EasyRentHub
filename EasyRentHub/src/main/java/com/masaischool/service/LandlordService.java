package com.masaischool.service;

import com.masaischool.entity.Landlord;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWentWrongException;

public interface LandlordService {
	void addLandlord(Landlord landLord) throws SomeThingWentWrongException;

	void login(String username, String password)throws SomeThingWentWrongException, NoRecordFoundException;

}
