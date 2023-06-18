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
		RenterDAO renterDAO = new RenterDAOImpl();
		return renterDAO.getRenterList();
	}

	@Override
	public void login(String username, String password) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		RenterDAO renterDAO = new RenterDAOImpl();
		renterDAO.login(username, password);		
	}

	@Override
	public void ViewRentedProperty() throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		RenterDAO renterDAO = new RenterDAOImpl();
		renterDAO.ViewRentedProperty();		
	}


	@Override
	public void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		RenterDAO renterDAO = new RenterDAOImpl();
		renterDAO.changePassword( oldPassword,  newPassword);
		
	}

	@Override
	public void deleteAccount() throws SomeThingWentWrongException {
		RenterDAO renterDAO = new RenterDAOImpl();
		renterDAO.deleteAccount();
		
	}

	@Override
	public void addRenter(Renter customer) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		RenterDAO renterDAO = new RenterDAOImpl();
		renterDAO.addRenter(customer);
		
	}

}
