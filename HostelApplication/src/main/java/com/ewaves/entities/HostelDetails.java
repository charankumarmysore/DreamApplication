package com.ewaves.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class HostelDetails implements Serializable {

	private static final long serialVersionUID = 7749423133637138708L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer hostelId;
	private String hostelName;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emailId;
	private String address1;
	private String address2;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "hostelDeails", orphanRemoval = true)
	private HostelFaculties facultiesList;

	public Integer getHostelId() {
		return hostelId;
	}

	public void setHostelId(Integer hostelId) {
		this.hostelId = hostelId;
	}

	public String getHostelName() {
		return hostelName;
	}

	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public HostelFaculties getFacultiesList() {
		return facultiesList;
	}

	public void setFacultiesList(HostelFaculties facultiesList) {
		this.facultiesList = facultiesList;
	}

	@Override
	public String toString() {
		return "HostelDeails [hostelId=" + hostelId + ", hostelName=" + hostelName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", address1="
				+ address1 + ", address2=" + address2 + ", facultiesList=" + facultiesList + "]";
	}

}
