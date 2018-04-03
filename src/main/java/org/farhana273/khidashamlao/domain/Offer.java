package org.farhana273.khidashamlao.domain;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Offers")
public class Offer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Value("${some.key:0}")
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@Column(name = "discount_percentage")
	private String discountPercentage;

	@Column(name = "start_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String startDate;

	@Column(name = "end_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String endDate;

	@Column(name = "food_id")
	private long foodId;

	@Column(name = "restaurant_id")
	private long restaurantId;

	@Column(name = "created_at")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String createdAt;

	@Column(name = "modified_at")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String modifiedAt;

	@Column(name = "deletedAt")
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

	public String getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(String discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public long getRestaurantID() {
		return restaurantId;
	}

	public void setRestaurantID(long restaurantID) {
		this.restaurantId = restaurantID;
	}

	public long getFoodID() {
		return foodId;
	}

	public void setFoodID(long foodID) {
		this.foodId = foodID;
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