package jpa;
import java.io.Serializable;

import javax.persistence.*;

/**
 * JPA Class MessageJPA
 */
@Entity
@Table(name="carsharing.car")
public class MessageJPA implements Serializable {
	@OneToOne(cascade=CascadeType.PERSIST)

	private static final long serialVersionUID = 1L;

	private int tripId;
	private int questionId;
	private String driver;
	private String subject;
	private String body;
	
		
	/**
	 * Class constructor methods
	 */
	public MessageJPA() {
		super();
	}
	public MessageJPA(int tripId, int questionId, String driver, String subject, String body) {		
		this.tripId = tripId;
		this.questionId = questionId;
		this.driver = driver;
		this.subject = subject;
		this.body = body;
		
	}
	

	/**
	 *  Methods get/set the fields of database
	 */
	
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	@Id
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
		
	
}
