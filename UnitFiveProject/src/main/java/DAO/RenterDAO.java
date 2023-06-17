package DAO;

import java.util.List;

import ENTITY.Renter;
import EXCEPTION.NoRecordFoundException;
import EXCEPTION.SomeThingWentWrongException;

public interface RenterDAO {

	void addRenter(Renter renter) throws SomeThingWentWrongException;

	List<Object[]> getRenterList() throws SomeThingWentWrongException, NoRecordFoundException;

	void login(String username, String password) throws SomeThingWentWrongException;

	void ViewRentedProperty() throws SomeThingWentWrongException, NoRecordFoundException;

	void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException;

	void deleteAccount() throws SomeThingWentWrongException;

}
