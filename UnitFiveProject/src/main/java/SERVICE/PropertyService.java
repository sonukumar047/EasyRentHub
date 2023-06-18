package SERVICE;

import java.util.List;

import ENTITY.Property;
import EXCEPTION.NoRecordFoundException;
import EXCEPTION.SomeThingWentWrongException;

public interface PropertyService {


	void addProperty(Property p) throws SomeThingWentWrongException;
	List<Property> getPropertyList() throws SomeThingWentWrongException, NoRecordFoundException;
	void updateProperty(Property property) throws SomeThingWentWrongException, NoRecordFoundException;
	void DeletePropertyById(int id)throws SomeThingWentWrongException, NoRecordFoundException;
}
