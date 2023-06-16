package DAO;


import java.util.List;

import ENTITY.Property;
import EXCEPTION.NoRecordFoundException;
import EXCEPTION.SomeThingWentWrongException;
import UTILITY.EMUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class PropertyDAOImpl implements PropertyDAO {

	static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("propertyProject");
	}

	@Override
	public void addProperty(Property p) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			// check if stock with same name exists
			Query query = em.createQuery("SELECT count(s) FROM Property s WHERE propertyName = :propertyName");
			query.setParameter("propertyName",p.getPropertyName() );
			if ((Long) query.getSingleResult() > 0) {
				// you are here means company with given name exists so throw exceptions
				throw new SomeThingWentWrongException("Property already exists with name " + p.getPropertyName());
			}

			// you are here means no company with given name
			et = em.getTransaction();
			et.begin();
			em.persist(p);
			et.commit();
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
		
	}

	@Override
	public List<Property> getPropertyLists() throws SomeThingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		List<Property> propertyList = null;
		try {
			em = EMUtils.getEntityManager();
			Query query = em.createQuery("FROM Property s");
			propertyList = (List<Property>) query.getResultList();
			if (propertyList.size() == 0) {
				throw new NoRecordFoundException("No Property Found");
			}
		} catch (IllegalArgumentException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
		return propertyList;
	}

	@Override
	public void updateProperty(Property property) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			Property propertyFromDB = em.find(Property.class, property.getId());

			if (propertyFromDB == null) {
				throw new NoRecordFoundException("No Property found with the given id " + property.getId());
			}

			// You are here means company exists with given id
			// check if company is to be renamed
			if (!propertyFromDB.getPropertyName().equals(property.getPropertyName())) {
				// you are here means company is to be renamed, check for no existing company
				// with new name.
				// check if company with same name exists
				Query query = em.createQuery("SELECT count(s) FROM Property s WHERE propertyName = :propertyName");

				query.setParameter("stockName", property.getPropertyName());
				if ((Long) query.getSingleResult() > 0) {
					// you are here means company with given name exists so throw exceptions
					throw new SomeThingWentWrongException("Car already exists with name " + property.getPropertyName());
				}
			}

			// proceed for update operation

			EntityTransaction et = em.getTransaction();
			et.begin();
			propertyFromDB.setPropertyName(property.getPropertyName());
			propertyFromDB.setPropertlocation(property.getPropertlocation());
			propertyFromDB.setRentPrice(property.getRentPrice());
			et.commit();
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
		
	}

	
	
	
	@Override
	public void DeletePropertyById(int id) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = EMUtils.getEntityManager();
			// check if company with company with given id exists
			Property property = em.find(Property.class,id);
			if (property == null) {
				throw new NoRecordFoundException("No Property found with the given id " + id);
			}

			// You are here means company exists with given id
		
			et = em.getTransaction();
			et.begin();
			em.remove(property);
			et.commit();
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}

		
	}


}
