package SERVICE;

import DAO.OrderDAO;
import DAO.OrderDAOImpl;
import EXCEPTION.SomeThingWentWrongException;

public class OrderServiceImpl implements OrderService {

	@Override
	public void renterProperty(int propertyId, String propertyName) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub

		OrderDAO orderDAO = new OrderDAOImpl();
		orderDAO.renterProperty(propertyId, propertyName);
		
	}

	

}
