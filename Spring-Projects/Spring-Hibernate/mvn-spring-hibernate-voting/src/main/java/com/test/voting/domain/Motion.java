package com.test.voting.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "motion")
public class Motion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false, unique = true)
	@NotNull(message = "Motion name must not be empty")
	@Size(min = 5, max = 50)
	private String name;

	@Column(name = "description", nullable = false)
	@NotNull(message = "Motion description must not be empty")
	@Size(min = 5, max = 255)
	private String description;

	@Column(name = "maxallowedvotes", nullable = false)
	@NotNull(message = "Motion max allowed votes must not be empty")
	@Min(value = 5, message = "Motion max allowed votes must be greater or equal to 5")
	@Max(value = 5000, message = "Motion max allowed votes must be less than or equal to 5000")
	private Integer maxAllowedVotes;

	@Column(name = "status", nullable = false)
	@NotNull(message = "Motion status must not be empty")
	@Min(value = 0, message = "Motion status must be greater or equal to 0")
	@Max(value = 5000, message = "Motion status must be less than or equal to 5")
	private Integer status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Integer getMaxAllowedVotes() {
		return maxAllowedVotes;
	}

	public void setMaxAllowedVotes(Integer maxAllowedVotes) {
		this.maxAllowedVotes = maxAllowedVotes;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Motion [id=").append(id).append(", name=").append(name).append(", maxAllowedVotes=").append(maxAllowedVotes).append(", status=").append(status).append("]");
		return builder.toString();
	}
}
