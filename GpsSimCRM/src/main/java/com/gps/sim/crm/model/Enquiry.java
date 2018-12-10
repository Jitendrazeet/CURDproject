package com.gps.sim.crm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "INQUIRY")
public class Enquiry implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "postedBy")
	private User postedBy;

	@ManyToOne
	@JoinColumn(name = "assignedTo")
	private User assignedTo;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date postedOn;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date resolvedOn;

	@ManyToOne
	@JoinColumn(name = "moduleId")
	private Module module;

	private String status;
	private String message;
	private String resolution;
	private int reopen;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getPostedBy() {

		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getResolvedOn() {
		return resolvedOn;
	}

	public void setResolvedOn(Date resolvedOn) {
		this.resolvedOn = resolvedOn;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public int getReopen() {
		return reopen;
	}

	public void setReopen(int reopen) {
		this.reopen = reopen;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
}
