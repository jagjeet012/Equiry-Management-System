package org.jagjeet.ems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

/**
 * @author Jagjeet
 *
 */
@Component
@Entity
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int enquiryId;
	private String courses;
	@OneToOne
	private User user;

	public int getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
