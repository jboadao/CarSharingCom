package ejb;

import java.util.Collection;

import javax.ejb.Remote;


/**
 * Session EJB Remote Interfaces
 */
@Remote
public interface CommunicationFacadeRemote {
	  /**
	   * Remotely invoked method.
	   */
	 	  
	  public Collection<?>showTripComments(int tripId);
	  public Collection<?>showDriverComments(String driver);
	  public void askQuestion(int tripId, String passenger, String subject, String body);
	  public void replyQuestion(int tripId, int questionId, String driver, String subject, String body);
	  public void rateDriver(String driver, String passenger, String comment, int rate);
	  
}
