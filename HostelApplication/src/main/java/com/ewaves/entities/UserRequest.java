package com.ewaves.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ewaves.converter.LocalDateConverter;
import com.ewaves.converter.LocalDateDeserializer;
import com.ewaves.converter.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class UserRequest implements Serializable {

	private static final long serialVersionUID = 3536384242164351894L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private String sharingPerference;
	private String noOfBeds;
	private LocalDateTime insertedOn;
	private LocalDateTime UpdatedOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSharingPerference() {
		return sharingPerference;
	}

	public void setSharingPerference(String sharingPerference) {
		this.sharingPerference = sharingPerference;
	}

	public String getNoOfBeds() {
		return noOfBeds;
	}

	public void setNoOfBeds(String noOfBeds) {
		this.noOfBeds = noOfBeds;
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

	@Override
	public String toString() {
		return "UserRequest [id=" + id + ", name=" + name + ", email=" + email + ", sharingPerference=" + sharingPerference
				+ ", noOfBeds=" + noOfBeds + ", insertedOn=" + insertedOn + ", UpdatedOn=" + UpdatedOn + "]";
	}

}
