package com.ewaves.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HostelFaculties implements Serializable {

	private static final long serialVersionUID = -2093306356754450050L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private boolean tv;
	private boolean wifi;
	private boolean ac;
	private boolean nonVegetarian;
	private boolean washingMachine;
	private boolean hotWater;
	@ManyToOne(cascade = CascadeType.MERGE)
	private HostelDetails hostelDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isAc() {
		return ac;
	}

	public void setAc(boolean ac) {
		this.ac = ac;
	}

	public boolean isNonVegetarian() {
		return nonVegetarian;
	}

	public void setNonVegetarian(boolean nonVegetarian) {
		this.nonVegetarian = nonVegetarian;
	}

	public boolean isWashingMachine() {
		return washingMachine;
	}

	public void setWashingMachine(boolean washingMachine) {
		this.washingMachine = washingMachine;
	}

	public boolean isHotWater() {
		return hotWater;
	}

	public void setHotWater(boolean hotWater) {
		this.hotWater = hotWater;
	}

	public HostelDetails getHostelDetails() {
		return hostelDetails;
	}

	public void setHostelDetails(HostelDetails hostelDetails) {
		this.hostelDetails = hostelDetails;
	}

	@Override
	public String toString() {
		return "HostelFaculties [id=" + id + ", tv=" + tv + ", wifi=" + wifi + ", ac=" + ac + ", nonVegetarian="
				+ nonVegetarian + ", washingMachine=" + washingMachine + ", hotWater=" + hotWater + ", hostelDetails="
				+ hostelDetails + "]";
	}

}
