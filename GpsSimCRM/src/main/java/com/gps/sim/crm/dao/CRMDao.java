package com.gps.sim.crm.dao;

import java.util.List;

import com.gps.sim.crm.model.Enquiry;
import com.gps.sim.crm.model.Module;
import com.gps.sim.crm.model.User;

public interface CRMDao {

	public User logInValidator(User users);

	public User getDetails(String logInId);

	public List<Module> getModule();

	public void postEnquiry(Enquiry enquiry);

	public List<Enquiry> getInquiries(int setFirstRow, int setResult);

	public Enquiry getPostedDetails(String postedBy);
	
	public List<User> getUsersByRoleId(int roleId);
	
	public void assignTo(Enquiry enquiry);

}
