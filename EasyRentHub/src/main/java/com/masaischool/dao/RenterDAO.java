package com.masaischool.dao;

import com.masaischool.entity.Renter;
import com.masaischool.exception.SomeThingWentWrongException;

public interface RenterDAO {

	void addRenter(Renter renter) throws SomeThingWentWrongException;
	void login(String username, String password) throws SomeThingWentWrongException;
}
