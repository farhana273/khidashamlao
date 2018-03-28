package org.farhana273.khidashamlao.domain;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "restaurant")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Value("${some.key:0}")
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "zipCode")
	private String zipCode;

	@Column(name = "branch")
	private String branch;

	@Column(name = "opening_time")
	private String openingTime;

	@Column(name = "closing_time")
	private String closingTime;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@Column(name = "cuisine_speciality")
	private Cuisine cuisineSpeciality;

	@Column(name = "environment_type")
	private Environment environmentType;

	@Column(name = "advanced_booking")
	private boolean advancedBooking;
	
	@Column(name = "service_charge")
	private double serviceCharge;

	@Column(name = "delivery")
	private boolean delivery;

	@Column(name = "created_at")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String createdAt;

	@Column(name = "modified_at")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String modifiedAt;

	@Column(name = "deleted_at")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String deletedAt;

	public long getId() {
		return id;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}

	public String getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(String closingTime) {
		this.closingTime = closingTime;
	}

	public Cuisine getCuisineSpecialty() {
		return cuisineSpeciality;
	}

	public void setCuisineSpecialty(Cuisine cuisineSpeciality) {
		this.cuisineSpeciality = cuisineSpeciality;
	}

	public Environment getEnvironment() {
		return environmentType;
	}

	public void setEnvironment(Environment environmentType) {
		this.environmentType = environmentType;
	}

	public boolean getAdvancedBooking() {
		return advancedBooking;
	}

	public void setAdvancedBooking(Boolean advancedBooking) {
		this.advancedBooking = advancedBooking;
	}
	
	public double getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public boolean getDelivery() {
		return delivery;
	}

	public void setDelivery(Boolean delivery) {
		this.delivery = delivery;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getLastModifiedAt() {
		return modifiedAt;
	}

	public void setLastModifiedAt(String lastModifiedAt) {
		this.modifiedAt = lastModifiedAt;
	}

	public String getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}

}