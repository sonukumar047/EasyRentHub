package SERVICE;

import EXCEPTION.SomeThingWentWrongException;

public interface OrderService {

	public void purchaseProperty(int propertyId, String propertyName)throws SomeThingWentWrongException;
}
