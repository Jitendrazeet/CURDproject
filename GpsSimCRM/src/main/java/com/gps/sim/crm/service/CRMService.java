package com.gps.sim.crm.service;

import java.util.List;

import com.gps.sim.crm.model.Enquiry;
import com.gps.sim.crm.model.Module;
import com.gps.sim.crm.model.Role;
import com.gps.sim.crm.model.User;

public interface CRMService {
	public List<Role> getRoles();

	public User logInValidator(User User);

	public User getDetails(String logInId);

	public void postEnquiry(Enquiry enquiry);

	public List<Module> getModule();

	public List<Enquiry> getInquiries(int setFirstRow, int setResult);

	public Enquiry getPostedDetails(String postedBy);
	
	public List<User> getUsersByRoleId(int roleId);
	
	public void assignTo(Enquiry enquiry);
}
