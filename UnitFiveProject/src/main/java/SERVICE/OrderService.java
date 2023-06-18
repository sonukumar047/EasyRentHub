package SERVICE;

import EXCEPTION.SomeThingWentWrongException;

public interface OrderService {

	public void renterProperty(int propertyId, String propertyName)throws SomeThingWentWrongException;
}
