package com.ewaves.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RoomAvailability implements Serializable {

	private static final long serialVersionUID = -1269500454352113964L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String noOfPersonAvailability;
	@ManyToOne(cascade = CascadeType.MERGE)
	private RoomDetails roomDetails;
	@ManyToOne(cascade = CascadeType.MERGE)
	private SharingDetails sharingDetails;
	private LocalDate insertedOn;
	private LocalDate UpdatedOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNoOfPersonAvailability() {
		return noOfPersonAvailability;
	}

	public void setNoOfPersonAvailability(String noOfPersonAvailability) {
		this.noOfPersonAvailability = noOfPersonAvailability;
	}

	public RoomDetails getRoomDetails() {
		return roomDetails;
	}

	public void setRoomDetails(RoomDetails roomDetails) {
		this.roomDetails = roomDetails;
	}

	public SharingDetails getSharingDetails() {
		return sharingDetails;
	}

	public void setSharingDetails(SharingDetails sharingDetails) {
		this.sharingDetails = sharingDetails;
	}

	public LocalDate getInsertedOn() {
		return insertedOn;
	}

	public void setInsertedOn(LocalDate insertedOn) {
		this.insertedOn = insertedOn;
	}

	public LocalDate getUpdatedOn() {
		return UpdatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		UpdatedOn = updatedOn;
	}

}
