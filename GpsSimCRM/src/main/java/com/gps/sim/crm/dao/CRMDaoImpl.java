package com.gps.sim.crm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gps.sim.crm.model.Enquiry;
import com.gps.sim.crm.model.Module;
import com.gps.sim.crm.model.User;

@Repository
public class CRMDaoImpl implements CRMDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public User logInValidator(User User) {
		User userNew = new User();
		Query query = this.sessionFactory.getCurrentSession().createQuery("from User where logInId=:logInId");
		query.setString("logInId", User.getLogInId());
		List<User> userList = query.list();
		if (userList.isEmpty()) {
			userNew = null;
			return userNew;
		} else {
			for (User userListNew : userList) {
				userNew.setPassword(userListNew.getPassword());
			}
		}
		return userNew;
	}

	@Override
	public User getDetails(String logInId) {
		User user = (User) this.sessionFactory.getCurrentSession().get(User.class, logInId);
		return user;
	}

	@Override
	public void postEnquiry(Enquiry enquiry) {
		this.sessionFactory.getCurrentSession().save(enquiry);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Module> getModule() {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Module");
		List<Module> moduleList = query.list();
		return moduleList;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Enquiry> getInquiries(int setFirstRow, int setResult) {

		List result = null;
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Enquiry");
		query = query.setFirstResult(setFirstRow);
		query.setMaxResults(setResult);
		result = query.list();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Enquiry getPostedDetails(String postedOn) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Enquiry where postedOn=:postedOn")
				.setString("postedOn", postedOn);
		List<Enquiry> enqDetails = query.list();
		if (enqDetails != null && enqDetails.size() > 0) {
			return enqDetails.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersByRoleId(int roleId) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from User where roleId=:roleId ")
				.setInteger("roleId", roleId);
		List<User> listOfemp = query.list();
		if (listOfemp != null && listOfemp.size() > 0) {
			return listOfemp;

		} else {
			return null;
		}

	}

	@Override
	public void assignTo(Enquiry enquiry) {
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				"update Enquiry set assignedTo = :assignedTo , set status=:status where postedOn = :postedOn");
		query.setString("assignedTo", enquiry.getAssignedTo().getLogInId());
		query.setDate("postedOn", enquiry.getPostedOn());
		query.setString("status", enquiry.getStatus());
		query.executeUpdate();

	}
}
