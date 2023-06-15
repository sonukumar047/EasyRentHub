package com.masaischool.dao;

import java.util.List;

import com.masaischool.entity.Landlord;
import com.masaischool.entity.LoggedInUserId;
import com.masaischool.exception.SomeThingWentWrongException;
import com.masaischool.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class LandlordDAOImpl implements LandlordDAO{

	@Override
	public void addLandlord(Landlord landlord) throws SomeThingWentWrongException {
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			//check if company with same username exists
			Query query = em.createQuery("SELECT count(l) FROM Landlord l WHERE username = :username");
			query.setParameter("username", landlord.getUsername());
			if((Long)query.getSingleResult() > 0) {
				//you are here means company with given name exists so throw exceptions
				throw new SomeThingWentWrongException("The username" + landlord.getUsername() + " is already occupied");
			}
			
			//you are here means no company with given name
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(landlord);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}
	
	@Override
	public void login(String username, String password) throws SomeThingWentWrongException{
		EntityManager em = null;
		try {
			em = EMUtils.getEntityManager();
			
			Query query = em.createQuery("SELECT l.id FROM Landlord l WHERE username = :username AND password = :password AND isDeleted = 0");
			query.setParameter("username", username);
			query.setParameter("password", password);
			List<Integer> listInt = (List<Integer>)query.getResultList();
			if(listInt.size() == 0) {
				//you are here means company with given name exists so throw exceptions
				throw new SomeThingWentWrongException("The username or password is incorrect");
			}
			LoggedInUserId.loggedInUserId = listInt.get(0);
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}finally{
			em.close();
		}
	}
}
