package com.masaischool.dao;

import com.masaischool.entity.Landlord;
import com.masaischool.exception.SomeThingWentWrongException;

public interface LandlordDAO {

	void addLandlord(Landlord landlord)throws SomeThingWentWrongException;

	void login(String username, String password) throws SomeThingWentWrongException;

}
