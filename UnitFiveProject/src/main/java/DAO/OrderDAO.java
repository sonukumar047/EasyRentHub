package DAO;

import EXCEPTION.SomeThingWentWrongException;

public interface OrderDAO {

	void purchaseProperty(int propertyId,String propertyName) throws SomeThingWentWrongException;
}
