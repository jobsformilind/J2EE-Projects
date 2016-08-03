package com.test.voting.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.test.voting.enums.Status;

@Entity
@Table(name = "motion")
public class Motion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	@NotBlank(message = "Motion name must not be empty")
	@Size(min = 5, max = 50, message = "Motion name must be minimum 5 or maximum 50 characters")
	private String name;

	@Column(name = "description", nullable = false)
	@NotBlank(message = "Motion description must not be empty")
	@Size(min = 5, max = 255, message = "Motion description must be minimum 5 or maximum 255 characters")
	private String description;

	@Column(name = "maxallowedvotes", nullable = false)
	@NotNull(message = "Motion max allowed votes must not be empty")
	@Min(value = 5, message = "Motion max allowed votes must be greater or equal to 5")
	@Max(value = 5000, message = "Motion max allowed votes must be less than or equal to 5000")
	private Integer maxAllowedVotes;

	@Column(name = "status")
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	@Column(name = "startdate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate = new Date();

	@OneToMany(mappedBy = "motion")
	private Set<MotionVoter> motionVoters = new HashSet<MotionVoter>();

	public Motion() {
	}

	public Motion(String name) {
		this.name = name;
		this.description = name + " Motion created.";
		this.maxAllowedVotes = 50;
		this.status = Status.NEW;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Set<MotionVoter> getMotionVoters() {
		return motionVoters;
	}

	public void setMotionVoters(Set<MotionVoter> motionVoters) {
		this.motionVoters = motionVoters;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Motion [id=").append(id).append(", name=").append(name).append(", maxAllowedVotes=").append(maxAllowedVotes).append(", status=").append(status).append("]");
		return builder.toString();
	}
}
