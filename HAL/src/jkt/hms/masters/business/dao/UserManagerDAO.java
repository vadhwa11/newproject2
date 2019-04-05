package jkt.hms.masters.business.dao;

import org.hibernate.Session;

import jkt.hms.masters.business.base.BaseUserManagerDAO;


public class UserManagerDAO extends BaseUserManagerDAO implements jkt.hms.masters.business.dao.iface.UserManagerDAO {

	public UserManagerDAO () {}
	
	public UserManagerDAO (Session session) {
		super(session);
	}


}