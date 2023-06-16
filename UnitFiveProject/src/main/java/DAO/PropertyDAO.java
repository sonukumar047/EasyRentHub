package DAO;

import java.util.List;

import ENTITY.Property;
import EXCEPTION.NoRecordFoundException;
import EXCEPTION.SomeThingWentWrongException;

public interface PropertyDAO {
	
	void addProperty(Property p) throws SomeThingWentWrongException;
	public List<Property> getPropertyLists() throws SomeThingWentWrongException, NoRecordFoundException;
	public void updateProperty(Property property) throws SomeThingWentWrongException, NoRecordFoundException;
	void DeletePropertyById(int id) throws SomeThingWentWrongException, NoRecordFoundException;
}
