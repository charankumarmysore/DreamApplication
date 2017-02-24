package com.ewaves.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	@ManyToOne(cascade = CascadeType.MERGE)
	private RoomDetails roomDetails;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sharingDetails", orphanRemoval = true)
	private List<RoomAvailability> roomAvailability;

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

	public List<RoomAvailability> getRoomAvailability() {
		return roomAvailability;
	}

	public void setRoomAvailability(List<RoomAvailability> roomAvailability) {
		this.roomAvailability = roomAvailability;
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
