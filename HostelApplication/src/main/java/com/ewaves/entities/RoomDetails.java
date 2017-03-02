package com.ewaves.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ewaves.converter.LocalDateConverter;
import com.ewaves.converter.LocalDateDeserializer;
import com.ewaves.converter.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class RoomDetails implements Serializable {

	private static final long serialVersionUID = -7730375444679768125L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "roomId", unique = true, nullable = false)
	private Integer roomId;
	// roomType means AC/Non AC
	private String roomType;
	private String tv;
	private String hotWaterAvailable;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "roomDetails", orphanRemoval = true)
	private List<SharingDetails> sharingType;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	private HostelDetails hostelDetails;

	private LocalDate insertedOn;
	private LocalDate UpdatedOn;

	public RoomDetails() {
		sharingType = new ArrayList<SharingDetails>();

	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}

	public String getHotWaterAvailable() {
		return hotWaterAvailable;
	}

	public void setHotWaterAvailable(String hotWaterAvailable) {
		this.hotWaterAvailable = hotWaterAvailable;
	}

	public List<SharingDetails> getSharingType() {
		return sharingType;
	}

	public void setSharingType(List<SharingDetails> sharingType) {
		this.sharingType = sharingType;
	}

	@Convert(converter = LocalDateConverter.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	public LocalDate getInsertedOn() {
		return insertedOn;
	}

	public void setInsertedOn(LocalDate insertedOn) {
		this.insertedOn = LocalDate.now();
	}

	@Convert(converter = LocalDateConverter.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	public LocalDate getUpdatedOn() {
		return UpdatedOn;
	}

	public void setUpdatedOn(LocalDate updatedOn) {
		UpdatedOn = LocalDate.now();
	}

	public HostelDetails getHostelDetails() {
		return hostelDetails;
	}

	public void setHostelDetails(HostelDetails hostelDetails) {
		this.hostelDetails = hostelDetails;
	}

}
