package org.farhana273.khidashamlao.domain;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Food")
public class Sustenance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Value("${some.key:0}")
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "restaurant_id")
	private long restaurantId;

	@Column(name = "sustenance_type")
	private SustenanceType sustenanceType;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@Column(name = "unit_price")
	private double unitPrice;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getRestaurantID() {
		return restaurantId;
	}

	public void setRestaurantID(long restaurantID) {
		this.restaurantId = restaurantID;
	}

	public SustenanceType getSustenanceType() {
		return sustenanceType;
	}

	public void setSustenanceType(SustenanceType sustenanceType) {
		this.sustenanceType= sustenanceType;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
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