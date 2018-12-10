package com.gps.sim.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gps.sim.crm.dao.CRMDao;
import com.gps.sim.crm.dao.RoleDAO;
import com.gps.sim.crm.model.Enquiry;
import com.gps.sim.crm.model.Module;
import com.gps.sim.crm.model.Role;
import com.gps.sim.crm.model.User;

@Service
public class CRMServiceImpl implements CRMService {

	@Autowired
	private RoleDAO roleDao;

	@Autowired
	private CRMDao crmDao;

	@Override
	@Transactional
	public List<Role> getRoles() {
		return roleDao.getRoles();
	}

	@Override
	@Transactional
	public User logInValidator(User User) {
		return crmDao.logInValidator(User);
	}

	@Override
	@Transactional
	public User getDetails(String logInId) {
		return crmDao.getDetails(logInId);
	}

	@Override
	@Transactional
	public void postEnquiry(Enquiry enquiry) {
		crmDao.postEnquiry(enquiry);

	}

	@Override
	@Transactional
	public List<Module> getModule() {

		return crmDao.getModule();
	}

	@Override
	@Transactional
	public List<Enquiry> getInquiries(int setFirstRow, int setResult) {
		return crmDao.getInquiries(setFirstRow, setResult);
	}

	@Override
	@Transactional
	public Enquiry getPostedDetails(String postedBy) {
		return crmDao.getPostedDetails(postedBy);
	}

	@Override
	@Transactional
	public List<User> getUsersByRoleId(int roleId) {
		return crmDao.getUsersByRoleId(roleId);
	}

	@Override
	@Transactional
	public void assignTo(Enquiry enquiry) {
		crmDao.assignTo(enquiry);

	}

}
