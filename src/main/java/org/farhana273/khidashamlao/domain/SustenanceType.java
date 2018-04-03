package org.farhana273.khidashamlao.domain;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "sustenance_type")
public class SustenanceType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Value("${some.key:0}")
	@Column(name = "id")
	private long id;

	@Column(name = "type")
	private String type;

	@Column(name = "name")
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@Column(name = "description")
	private String description;
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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