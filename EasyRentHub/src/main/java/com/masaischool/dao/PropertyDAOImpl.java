package com.masaischool.dao;

import com.masaischool.entity.Property;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWentWrongException;
import com.masaischool.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class PropertyDAOImpl implements PropertyDAO {

	public void updateProperty(Property property) throws SomeThingWentWrongException, NoRecordFoundException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			// check if company with company with given id exists
			Property propertyFromDB = em.find(Property.class, property.getId());
			if (propertyFromDB == null)
				throw new NoRecordFoundException("No Property found with the given id " + property.getId());

			// You are here means company exists with given id
			// check if company is to be renamed
			if (!propertyFromDB.getPropertyName().equals(property.getPropertyName())) {
				// you are here means company is to be renamed, check for no existing company
				// with new name.
				// check if company with same name exists
				Query query = em.createQuery("SELECT count(p) FROM Property p WHERE propertyName = :propertyName");
				query.setParameter("companyName", property.getPropertyName());
				if ((Long) query.getSingleResult() > 0) {
					// you are here means property with given name exists so throw exceptions
					throw new SomeThingWentWrongException(
							"Company already exists with name " + property.getPropertyName());
				}
			}

			// proceed for update operation

			EntityTransaction et = em.getTransaction();
			et.begin();
			propertyFromDB.setPropertyName(property.getPropertyName());
			propertyFromDB.setEstdYear(property.getEstdYear());
			propertyFromDB.setLocation(property.getLocation());
			propertyFromDB.setDetails(property.getDetails());
			propertyFromDB.setAmount(property.getAmount());
			et.commit();
		} catch (PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		} finally {
			em.close();
		}
	}
}
