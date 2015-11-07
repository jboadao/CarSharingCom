package jpa;
import java.io.Serializable;

import javax.persistence.*;

/**
 * JPA Class DriverCommentJPA
 */
@Entity
@Table(name="carsharing.car")
public class DriverCommentJPA implements Serializable {
	@OneToOne(cascade=CascadeType.PERSIST)

	private static final long serialVersionUID = 1L;

	private String driver;
	private String passenger;
	private String comment;
	private int rate;
	
		
	/**
	 * Class constructor methods
	 */
	public DriverCommentJPA() {
		super();
	}
	public DriverCommentJPA(String driver, String passenger, String comment, int rate) {		
		this.driver = driver;
		this.passenger = passenger;
		this.comment = comment;
		this.rate = rate;
		
	}
	

	/**
	 *  Methods get/set the fields of database
	 */
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getPassenger() {
		return passenger;
	}
	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	
		
	
}
