package org.jagjeet.ems.dao;

import org.jagjeet.ems.model.Enquiry;
import org.jagjeet.ems.model.User;

/**
 * @author Jagjeet
 *
 */
public interface EnquiryManagementSystemDao {
	
	//User

	public User isUserAuthentic(String userName, String password);

	public int addUser(User user);

	public User getUser(int userId);

	public User getUser(String userName, String password);
	
	//Enquiry

	public int createEnquiry(Enquiry enquiry);

	public void editEnquiry(Enquiry enquiry);

	public void deleteEnquiry(int enquiryId);

}
