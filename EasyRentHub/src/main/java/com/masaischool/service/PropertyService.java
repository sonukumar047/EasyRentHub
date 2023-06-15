package com.masaischool.service;

import com.masaischool.entity.Property;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWentWrongException;

public interface PropertyService {

	void updateProperty(Property property) throws SomeThingWentWrongException, NoRecordFoundException;
}
