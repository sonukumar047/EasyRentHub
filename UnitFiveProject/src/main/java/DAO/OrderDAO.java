package DAO;

import EXCEPTION.SomeThingWentWrongException;

public interface OrderDAO {

	void renterProperty(int propertyId,String propertyName) throws SomeThingWentWrongException;
}
