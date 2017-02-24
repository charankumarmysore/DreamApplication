package com.ewaves.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ewaves.converter.LocalDateConverter;
import com.ewaves.converter.LocalDateDeserializer;
import com.ewaves.converter.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class SharingDetails implements Serializable {

	private static final long serialVersionUID = 3917958235490067667L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String sharingType;
	private String noOfPersonAvailability;
	@ManyToOne(cascade = CascadeType.MERGE)
	private RoomDetails roomDetails;

	private LocalDateTime insertedOn;
	private LocalDateTime UpdatedOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSharingType() {
		return sharingType;
	}

	public void setSharingType(String sharingType) {
		this.sharingType = sharingType;
	}

	public RoomDetails getRoomDetails() {
		return roomDetails;
	}

	public void setRoomDetails(RoomDetails roomDetails) {
		this.roomDetails = roomDetails;
	}

	public String getNoOfPersonAvailability() {
		return noOfPersonAvailability;
	}

	public void setNoOfPersonAvailability(String noOfPersonAvailability) {
		this.noOfPersonAvailability = noOfPersonAvailability;
	}

	@Convert(converter = LocalDateConverter.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	public LocalDateTime getInsertedOn() {
		return insertedOn;
	}

	public void setInsertedOn(LocalDateTime insertedOn) {
		this.insertedOn = insertedOn;
	}

	@Convert(converter = LocalDateConverter.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	public LocalDateTime getUpdatedOn() {
		return UpdatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		UpdatedOn = updatedOn;
	}

}
