package jkt.hms.masters.business.dao;

import org.hibernate.Session;

import jkt.hms.masters.business.base.BaseStorePoDetailDAO;


public class StorePoDetailDAO extends BaseStorePoDetailDAO implements jkt.hms.masters.business.dao.iface.StorePoDetailDAO {

	public StorePoDetailDAO () {}
	
	public StorePoDetailDAO (Session session) {
		super(session);
	}


}