package SERVICE;


import java.util.List;

import DAO.PropertyDAO;
import DAO.PropertyDAOImpl;
import ENTITY.Property;
import EXCEPTION.NoRecordFoundException;
import EXCEPTION.SomeThingWentWrongException;

public class PropertyServiceImpl implements PropertyService {
	



	@Override
	public List<Property> getPropertyList() throws SomeThingWentWrongException, NoRecordFoundException {
		PropertyDAO propertyDAO = new PropertyDAOImpl();
		return propertyDAO.getPropertyLists();
	}

	@Override
	public void updateProperty(Property property) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		PropertyDAO propertyDAO = new PropertyDAOImpl();
		propertyDAO.updateProperty(property);
		
	}

	@Override
	public void DeletePropertyById(int id) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		PropertyDAO propertyDAO = new PropertyDAOImpl();
		propertyDAO.DeletePropertyById(id);
	}

	@Override
	public void addProperty(Property p) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		PropertyDAO propertyDAO = new PropertyDAOImpl();
		propertyDAO.addProperty(p);
		
	}






}
