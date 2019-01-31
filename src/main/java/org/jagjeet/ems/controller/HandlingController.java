package org.jagjeet.ems.controller;

import java.util.Map;

import javax.validation.Valid;

import org.jagjeet.ems.model.Enquiry;
import org.jagjeet.ems.model.User;
import org.jagjeet.ems.service.EnquiryManagementSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Jagjeet
 *
 */
@Controller
public class HandlingController {

	@Autowired
	private EnquiryManagementSystemService service;

	@Autowired
	private Enquiry enquiry;

	/**
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	/**
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm(@ModelAttribute("user") User user) {
		return "login";
	}

	/**
	 * @param user
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateLoginForm(@ModelAttribute("user") @Valid User user, BindingResult result, Map model) {

		if (result.hasErrors() || !service.isUserAuthentic(user.getUserName(), user.getPassword())) {
			model.put("errroMessage", "Please enter correct information !!");
			return "login";
		}

		user = service.getUser(user.getUserName(), user.getPassword());
		model.put("userId", user.getUserId());
		return "enquiry";
	}

	/**
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterForm(@ModelAttribute("user") User user) {
		return "registration";
	}

	/**
	 * @param user
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String validateRegistrationForm(@ModelAttribute("user") @Valid User user, BindingResult result, Map model) {
		if (result.hasErrors()) {
			model.put("errroMessage", "Please enter correct information !!");
			return "registration";
		}
		int userId = service.addUser(user);
		model.put("userId", userId);
		return "enquiry";
	}

	/**
	 * @param model
	 * @param userId
	 * @param course
	 * @return
	 */
	@RequestMapping(value = "/createEnquiry", method = RequestMethod.POST)
	public String createEnquiry(@RequestParam(value = "userId", required = true) Integer userId,
			@RequestParam(value = "course", required = true) String course) {

		User user = service.getUser(userId);

		enquiry.setUser(user);
		enquiry.setCourses(course);
		int enquiryId = service.createEnquiry(enquiry);

		return "enquiry";
	}

	/**
	 * @param model
	 * @param userId
	 * @param course
	 * @return
	 */
	@RequestMapping(value = "/editEnquiry", method = RequestMethod.POST)
	public String editEnquiry(@RequestParam(value = "userId", required = true) Integer userId,
			@RequestParam(value = "course", required = true) String course) {

		User user = service.getUser(userId);

		enquiry.setCourses(course);
		enquiry.setUser(user);
		service.updateEnquiry(enquiry);

		return "enquiry";

	}

	/**
	 * @param model
	 * @param enquiryId
	 * @return
	 */
	@RequestMapping(value = "/deleteEnquiry", method = RequestMethod.POST)
	public String deleteEnquiry(@RequestParam(value = "enquiryId", required = true) Integer enquiryId) {

		service.deleteEnquiry(enquiryId);

		return "enquiry";

	}

}
