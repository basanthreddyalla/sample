package com.aws.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4143678334616288576L;
	@Id
	@GeneratedValue
	private int customerId;
	private String firstName;
	private String lastName;
	
	
	public int getCustomerId() {
		return customerId;
	}
	
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
