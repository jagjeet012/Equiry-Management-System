package org.jagjeet.ems.service;

import org.jagjeet.ems.dao.EnquiryManagementSystemDao;
import org.jagjeet.ems.model.Enquiry;
import org.jagjeet.ems.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jagjeet
 *
 */
@Service
public class EnquiryManagementSystemServiceImpl implements EnquiryManagementSystemService {

	@Autowired
	EnquiryManagementSystemDao dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jagjeet.ems.service.EnquiryManagementSystemService#isUserAuthentic(java.
	 * lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public boolean isUserAuthentic(String userName, String password) {
		if (dao.isUserAuthentic(userName, password) != null) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jagjeet.ems.service.EnquiryManagementSystemService#addUser(org.jagjeet.
	 * ems.model.User)
	 */
	@Override
	@Transactional
	public int addUser(User user) {
		return dao.addUser(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jagjeet.ems.service.EnquiryManagementSystemService#getUser(int)
	 */
	@Override
	@Transactional
	public User getUser(int userId) {
		return dao.getUser(userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jagjeet.ems.service.EnquiryManagementSystemService#getUser(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	@Transactional
	public User getUser(String userName, String password) {
		return dao.getUser(userName, password);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jagjeet.ems.service.EnquiryManagementSystemService#createEnquiry(org.
	 * jagjeet.ems.model.Enquiry)
	 */
	@Override
	@Transactional
	public int createEnquiry(Enquiry enquiry) {
		return dao.createEnquiry(enquiry);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jagjeet.ems.service.EnquiryManagementSystemService#updateEnquiry(org.
	 * jagjeet.ems.model.Enquiry)
	 */
	@Override
	@Transactional
	public void updateEnquiry(Enquiry enquiry) {
		dao.editEnquiry(enquiry);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jagjeet.ems.service.EnquiryManagementSystemService#deleteEnquiry(int)
	 */
	@Override
	@Transactional
	public void deleteEnquiry(int enquiryId) {
		dao.deleteEnquiry(enquiryId);
	}
}
