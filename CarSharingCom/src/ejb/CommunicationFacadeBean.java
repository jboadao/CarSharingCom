package ejb;

import java.util.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import jpa.MessageJPA;
import jpa.DriverCommentJPA;
import ejb.CommunicationFacadeRemote;

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
	 * Method that adds a question
	 */
	public void askQuestion(int tripId, int questionId, String driver, String subject, String body) throws PersistenceException {

		MessageJPA message = new MessageJPA();
		message.setTripId(tripId);
		message.setQuestionId(questionId);
		message.setDriver(driver);
		message.setSubject(subject);
		message.setBody(body);
		try
		{
			entman.persist(message);
			
		}catch (PersistenceException e) {
			System.out.println(e);
		} 
	}	
	  
	/**
	 * Method that replies a question
	 */
	public void replyQuestion(int tripId, int questionId, String driver, String subject, String body) throws PersistenceException {

		MessageJPA message = new MessageJPA();
		message.setTripId(tripId);
		message.setQuestionId(questionId);
		message.setDriver(driver);
		message.setSubject(subject);
		message.setBody(body);
		try
		{
			entman.persist(message);
			
		}catch (PersistenceException e) {
			System.out.println(e);
		} 
	}	
	
		  
	/**
	 * Method that rate a driver
	 */
	public void rateDriver(String driver, String passenger, String comment, int rate)throws PersistenceException {
		DriverCommentJPA driverComment = new DriverCommentJPA();
		driverComment.setDriver(driver);
		driverComment.setPassenger(passenger);
		driverComment.setComment(comment);
		driverComment.setRate(rate);
		try
		{
			entman.persist(driverComment);
			
		}catch (PersistenceException e) {
			System.out.println(e);
		} 
		
	}	
	
}
