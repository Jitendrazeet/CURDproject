package com.gps.sim.crm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String logInId;
	private String password;
	private String firstName;

	@ManyToOne
	@JoinColumn(name = "roleId")
	private Role role;

	@OneToMany(mappedBy = "postedBy", cascade = CascadeType.ALL)
	private Set<Enquiry> postedByEnquiries = new HashSet<Enquiry>();

	@OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL)
	private Set<Enquiry> assignedEnquiries = new HashSet<Enquiry>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Set<Enquiry> getPostedByEnquiries() {
		return postedByEnquiries;
	}

	public void setPostedByEnquiries(Set<Enquiry> postedByEnquiries) {
		this.postedByEnquiries = postedByEnquiries;
	}

	public Set<Enquiry> getAssignedEnquiries() {
		return assignedEnquiries;
	}

	public void setAssignedEnquiries(Set<Enquiry> assignedEnquiries) {
		this.assignedEnquiries = assignedEnquiries;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getLogInId() {
		return logInId;
	}

	public void setLogInId(String logInId) {
		this.logInId = logInId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
