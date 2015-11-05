package ejb;

import java.util.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import jpa.CarJPA;
import ejb.UserFacadeRemote;

/**
 * EJB Session Bean Class 
 */
@Stateless
public class CommunicationFacadeBean implements CommunicationFacadeRemote {
	
	//Persistence Unit Context
	@PersistenceContext(unitName="carsharing") 
	private EntityManager entman;
	
	/**
	 * Method that returns Collection of comments of one trip
	 */
	public java.util.Collection<?> showTripComments(int tripId) throws PersistenceException {
		@SuppressWarnings("unchecked")
		Collection<MessageJPA> tripComments = entman.createQuery("FROM MessageJPA b WHERE b.tripId = :tripId").setParameter("tripId", tripId).getResultList();
		
	    return tripComments;
	}
   
	/**
	 * Method that returns Collection of comments of one driver
	 */
	public java.util.Collection<?> showDriverComments(String driver) throws PersistenceException {
		@SuppressWarnings("unchecked")
		Collection<DriverCommentJPA> driverComments = entman.createQuery("FROM DriverCommentJPA b WHERE b.driver = :driver").setParameter("driver", driver).getResultList();
		
	    return driverComments;
	}
	/**
	 * Method that adds a car
	 */
	public void addCar(String nif, String carRegistrationId, String brand, String model, String color) throws PersistenceException {

		CarJPA car = new CarJPA();
		car.setNif(nif);
		car.setCarRegistrationId(carRegistrationId);
		car.setBrand(brand);
		car.setModel(model);
		car.setColor(color);
		try
		{
			entman.persist(car);
			
		}catch (PersistenceException e) {
			System.out.println(e);
		} 
	}	
	  
	
	
	  
	/**
	 * Method that delete a instance of the class car
	 */
	public void deleteCar(String carRegistrationId)throws PersistenceException {
		try
		{
			entman.createQuery("DELETE FROM CarJPA b WHERE b.carRegistrationId = ?1").setParameter(1, carRegistrationId).executeUpdate();
			
		}catch (PersistenceException e) {
			System.out.println(e);
		} 
	}	
	
	/**
	 * Method that verify the existences of as car
	 */
	public boolean existsCar(String carRegistrationId)throws PersistenceException {
		@SuppressWarnings("unchecked")
		Collection<CarJPA> cars = entman.createQuery("FROM CarJPA b WHERE b.carRegistrationId = ?1").setParameter(1, carRegistrationId).getResultList();
		if (cars.isEmpty()) return false; 
		else return true;
	}	
}
