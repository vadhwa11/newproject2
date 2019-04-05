package jkt.hms.masters.business.dao;

import org.hibernate.Session;

import jkt.hms.masters.business.base.BaseStoreIssueMDAO;


public class StoreIssueMDAO extends BaseStoreIssueMDAO implements jkt.hms.masters.business.dao.iface.StoreIssueMDAO {

	public StoreIssueMDAO () {}
	
	public StoreIssueMDAO (Session session) {
		super(session);
	}


}