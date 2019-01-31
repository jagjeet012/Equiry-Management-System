package org.jagjeet.ems.service;

import org.jagjeet.ems.model.Enquiry;
import org.jagjeet.ems.model.User;

/**
 * @author Jagjeet
 *
 */
public interface EnquiryManagementSystemService {
	
	//User

	boolean isUserAuthentic(String userName, String password);

	public User getUser(int userId);

	public int addUser(User user);

	User getUser(String userName, String password);
	
	//Enquiry

	public int createEnquiry(Enquiry enquiry);

	public void updateEnquiry(Enquiry enquiry);

	public void deleteEnquiry(int enquiryId);

}
