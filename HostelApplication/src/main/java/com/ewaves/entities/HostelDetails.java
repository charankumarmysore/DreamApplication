package com.ewaves.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String street;
	private String landmark;
	private String state;
	private String city;
	private String country;
	private String pinCode;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "hostelDeails", orphanRemoval = true)
	private HostelFaculties facultiesList;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hostelDetails", orphanRemoval = true)
	private List<StudentRequest> studentRequests;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "hostelDetails", orphanRemoval = true)
	private RoomDetails roomDetails;

	private boolean isEnable;

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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public boolean getIsEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<StudentRequest> getStudentRequests() {
		return studentRequests;
	}

	public void setStudentRequests(List<StudentRequest> studentRequests) {
		this.studentRequests = studentRequests;
	}

	public RoomDetails getRoomDetails() {
		return roomDetails;
	}

	public void setRoomDetails(RoomDetails roomDetails) {
		this.roomDetails = roomDetails;
	}

	@Override
	public String toString() {
		return "HostelDetails [hostelId=" + hostelId + ", hostelName=" + hostelName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", address1="
				+ address1 + ", address2=" + address2 + ", street=" + street + ", landmark=" + landmark + ", state="
				+ state + ", city=" + city + ", country=" + country + ", pinCode=" + pinCode + ", facultiesList="
				+ facultiesList + ", studentRequests=" + studentRequests + ", isEnable=" + isEnable + "]";
	}

}
