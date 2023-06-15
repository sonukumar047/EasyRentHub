package com.masaischool.dao;

import com.masaischool.entity.Property;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWentWrongException;

public interface PropertyDAO {
	void updateProperty(Property property) throws SomeThingWentWrongException, NoRecordFoundException;
}
