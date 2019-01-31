package org.jagjeet.ems.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jagjeet.ems.model.Enquiry;
import org.jagjeet.ems.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Jagjeet
 *
 */
@Repository
public class EnquiryManagementSystemDaoImpl implements EnquiryManagementSystemDao {

	@Autowired
	org.hibernate.SessionFactory sessionFactory;

	/**
	 * @return
	 */
	private EntityManager getEntityManager() {
		return sessionFactory.getCurrentSession().getEntityManagerFactory().createEntityManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jagjeet.ems.dao.EnquiryManagementSystemDao#isUserAuthentic(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public User isUserAuthentic(String userName, String password) {
		EntityManager entityManager = getEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> root = criteria.from(User.class);
		criteria.select(root);
		criteria.where(builder.equal(root.get("userName"), userName), builder.equal(root.get("password"), password));

		try {
			User user = entityManager.createQuery(criteria).getSingleResult();
			return user;
		} catch (NoResultException e) {

		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jagjeet.ems.dao.EnquiryManagementSystemDao#addUser(org.jagjeet.ems.model.
	 * User)
	 */
	@Override
	public int addUser(User user) {
		return (int) sessionFactory.getCurrentSession().save(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jagjeet.ems.dao.EnquiryManagementSystemDao#getUser(int)
	 */
	@Override
	public User getUser(int userId) {
		return sessionFactory.getCurrentSession().get(User.class, userId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jagjeet.ems.dao.EnquiryManagementSystemDao#getUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public User getUser(String userName, String password) {
		EntityManager entityManager = getEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> root = criteria.from(User.class);
		criteria.select(root);
		criteria.where(builder.equal(root.get("userName"), userName), builder.equal(root.get("password"), password));

		User user = entityManager.createQuery(criteria).getSingleResult();
		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jagjeet.ems.dao.EnquiryManagementSystemDao#createEnquiry(org.jagjeet.ems.
	 * model.Enquiry)
	 */
	@Override
	public int createEnquiry(Enquiry enquiry) {
		return (int) sessionFactory.getCurrentSession().save(enquiry);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.jagjeet.ems.dao.EnquiryManagementSystemDao#editEnquiry(org.jagjeet.ems.
	 * model.Enquiry)
	 */
	@Override
	public void editEnquiry(Enquiry enquiry) {
		sessionFactory.getCurrentSession().update(enquiry);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jagjeet.ems.dao.EnquiryManagementSystemDao#deleteEnquiry(int)
	 */
	@Override
	public void deleteEnquiry(int enquiryId) {

		Enquiry enquiry = new Enquiry();
		enquiry.setEnquiryId(enquiryId);
		sessionFactory.getCurrentSession().delete(enquiryId);

	}

}
