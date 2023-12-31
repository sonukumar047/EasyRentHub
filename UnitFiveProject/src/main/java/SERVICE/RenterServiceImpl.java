package SERVICE;

import java.util.List;

import DAO.RenterDAO;
import DAO.RenterDAOImpl;
import ENTITY.LoggedInUserId;
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
	
		RenterDAO renterDAO = new RenterDAOImpl();
		renterDAO.ViewRentedProperty();		
	}


	@Override
    public void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException {
        // Retrieve renter by ID
		RenterDAO renterDAO = new RenterDAOImpl();
        Renter renter = renterDAO.findById(LoggedInUserId.loggedInUserId);
        
        // Verify old password
        if (!renter.verifyPassword(oldPassword)) {
            throw new SomeThingWentWrongException("Invalid old password");
        }
        
        // Set new hashed password
        renter.setPassword(newPassword);
        
        renterDAO.updateRenter(renter); // Update the renter in the database
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
