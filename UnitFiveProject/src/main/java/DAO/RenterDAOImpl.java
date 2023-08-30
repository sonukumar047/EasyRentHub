package DAO;

import java.util.List;
import java.util.Set;

import ENTITY.Property;
import ENTITY.Renter;
import ENTITY.LoggedInUserId;
import EXCEPTION.NoRecordFoundException;
import EXCEPTION.SomeThingWentWrongException;
import UTILITY.EMUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class RenterDAOImpl implements RenterDAO {

	@Override
	public List<Object[]> getRenterList() throws SomeThingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		List<Object[]> renterList = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("SELECT r.name, r.username, r.dateOfBirth, r.isDeleted FROM Renter r");
			renterList = query.getResultList();
			if (renterList.size() == 0) {
				throw new NoRecordFoundException("No Renter Found");
			}
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
		return renterList;
	}

	@Override
	public void login(String username, String password) throws SomeThingWentWrongException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery(
					"SELECT r.id FROM Renter r WHERE username = :username AND password = :password AND isDeleted = 0");
			query.setParameter("username", username);
			query.setParameter("password", password);
			List<Integer> listInt = (List<Integer>) query.getResultList();
			if (listInt.size() == 0) {
				// you are here means company with given name exists so throw exceptions
				throw new SomeThingWentWrongException("The username or password is incorrect");
			}
			LoggedInUserId.loggedInUserId = listInt.get(0);
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
	}

	@Override
	public void ViewRentedProperty() throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			Renter renter = em.find(Renter.class, LoggedInUserId.loggedInUserId);
			Set<Property> rentedPropertyList = renter.getPropertySet();

			if (rentedPropertyList.isEmpty()) {
				throw new NoRecordFoundException("No Property Rented By You");
			}
			for (Property p : rentedPropertyList) {
				System.out.println("Id : " + p.getId() + " Name : " + p.getPropertyName() + " Price : " + p.getRentPrice()
						+ " Estd Year : " + p.getEstd());
			}

		} catch (PersistenceException | IllegalArgumentException ex) {
			ex.printStackTrace();
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}

	}

	

//	@Override
//	public void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException {
//		// TODO Auto-generated method stub
//		EntityManager em = null;
//		try {
//			em = EMUtils.getEntityManager();
//			Query query = em.createQuery("SELECT count(r) FROM Renter r WHERE password = :oldPassword AND id = :id");
//			query.setParameter("oldPassword", oldPassword);
//			query.setParameter("id", LoggedInUserId.loggedInUserId);
//			Long userCount = (Long) query.getSingleResult();
//			if (userCount == 0) {
//				// you are here old password is incorrect for logged in user
//				throw new SomeThingWentWrongException("Invalid old password");
//			}
//			// You are here means all checks done, We can proceed for changing the password
//			Renter renter = em.find(Renter.class, LoggedInUserId.loggedInUserId);
//			EntityTransaction et = em.getTransaction();
//			et.begin();
//			renter.setPassword(newPassword);
//			et.commit();
//		} catch (PersistenceException ex) {
//			throw new SomeThingWentWrongException("Unable to process request, try again later");
//		} finally {
//			em.close();
//		}
//
//	}
	
	@Override
	public void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException {
	    EntityManager em = null;
	    try {
	        em = EMUtils.getEntityManager();
	        // ... other code
	        Query query = em.createQuery("SELECT count(r) FROM Renter r WHERE password = :oldPassword AND id = :id");
			query.setParameter("oldPassword", oldPassword);
			query.setParameter("id", LoggedInUserId.loggedInUserId);
			Long userCount = (Long) query.getSingleResult();
			if (userCount == 0) {
				// you are here old password is incorrect for logged in user
				throw new SomeThingWentWrongException("Invalid old password");
			}
	        
	        Renter renter = em.find(Renter.class, LoggedInUserId.loggedInUserId);
	        if (!renter.verifyPassword(oldPassword)) {
	            throw new SomeThingWentWrongException("Invalid old password");
	        }
	        
	        EntityTransaction et = em.getTransaction();
	        et.begin();
	        renter.setPassword(newPassword); // Set the new hashed password
	        et.commit();
	    } catch (PersistenceException ex) {
	        throw new SomeThingWentWrongException("Unable to process request, try again later");
	    } finally {
	        em.close();
	    }
	}


	@Override
	public void deleteAccount() throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			Renter renter = em.find(Renter.class, LoggedInUserId.loggedInUserId);
			EntityTransaction et = em.getTransaction();
			et.begin();
			renter.setIsDeleted(1);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}

	@Override
	public void addRenter(Renter renter) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			//check if customer with same username exists
			Query query = em.createQuery("SELECT count(r) FROM Renter r WHERE username = :username");
			query.setParameter("username", renter.getUsername());  
			if((Long)query.getSingleResult() > 0) {
				//you are here means customer with given name exists so throw exceptions
				throw new SomeThingWentWrongException("The username" + renter.getUsername() + " is already occupied");
			}
			//you are here means no customer with given name
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(renter);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
		
	}
	

    @Override
    public Renter findById(int id) throws SomeThingWentWrongException {
        EntityManager em = null;
        try {
            em = EMUtils.getEntityManager();
            return em.find(Renter.class, id);
        } catch (PersistenceException ex) {
            throw new SomeThingWentWrongException("Unable to process request, try again later");
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void updateRenter(Renter renter) throws SomeThingWentWrongException {
        EntityManager em = null;
        try {
            em = EMUtils.getEntityManager();
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(renter);
            et.commit();
        } catch (PersistenceException ex) {
            throw new SomeThingWentWrongException("Unable to process request, try again later");
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
	
}
