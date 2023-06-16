package SERVICE;

import java.util.List;

import DAO.RenterDAO;
import DAO.RenterDAOImpl;
import ENTITY.Renter;
import EXCEPTION.NoRecordFoundException;
import EXCEPTION.SomeThingWentWrongException;

public class RenterServiceImpl implements RenterService {

	@Override
	public List<Object[]> getRenterList() throws SomeThingWentWrongException, NoRecordFoundException {
		//Create an object of CustomerDAO
		RenterDAO customerDAO = new RenterDAOImpl();
		return customerDAO.getRenterList();
	}

	@Override
	public void login(String username, String password) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		RenterDAO customerDAO = new RenterDAOImpl();
		customerDAO.login(username, password);		
	}

	@Override
	public void ViewPurchasedProperty() throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		RenterDAO customerDAO = new RenterDAOImpl();
		customerDAO.ViewPurchasedProperty();		
	}


	@Override
	public void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		RenterDAO customerDAO = new RenterDAOImpl();
		customerDAO.changePassword( oldPassword,  newPassword);
		
	}

	@Override
	public void deleteAccount() throws SomeThingWentWrongException {
		RenterDAO customerDAO = new RenterDAOImpl();
		customerDAO.deleteAccount();
		
	}

	@Override
	public void addRenter(Renter customer) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		RenterDAO customerDAO = new RenterDAOImpl();
		customerDAO.addRenter(customer);
		
	}

}
