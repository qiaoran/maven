package com.shangqiu.school.util.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public abstract class HibernateDaoSupport  {
	private SessionFactory sessionFactory;

	/**
	 * Set the Hibernate SessionFactory that should be used to create
	 * Hibernate Sessions.
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Return the Hibernate SessionFactory used by this DAO.
	 */
	public final SessionFactory getSessionFactory() {
		return (this.sessionFactory != null ? sessionFactory: null);
	}


	protected final Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
}
