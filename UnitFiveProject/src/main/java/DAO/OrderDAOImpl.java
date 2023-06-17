package DAO;

import java.util.Set;

import ENTITY.LoggedInUserId;
import ENTITY.Property;
import ENTITY.Renter;
import EXCEPTION.SomeThingWentWrongException;
import UTILITY.EMUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public void renterProperty(int propertyId, String propertyName) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub

		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("FROM Property p WHERE propertyName = :propertyName");
			query.setParameter("propertyName", propertyName);
			// Here we can use getSingleResult because we are sure that plan exists with
			// given name
			Property property = (Property) query.getSingleResult();
			// get the entity of Customer
			Renter renter = em.find(Renter.class, LoggedInUserId.loggedInUserId);

			Set<Property> propertySet = renter.getPropertySet();
			propertySet.add(property);
			renter.setPropertySet(propertySet);

//			Set<Renter> renterSet = (Set<Renter>) property.getRe();
//			renterSet.add(renter);
//			property.setRe(renterSet);

			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(renter);
			et.commit();
		} catch (PersistenceException | IllegalArgumentException ex) {
			ex.printStackTrace();
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
	}

}
