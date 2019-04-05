package jkt.hms.hibernate;

import java.util.List;

import jkt.hms.masters.business.Patient;

import org.hibernate.Session;

public class DataFetcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Patient> pList = session.createQuery("from MasEmployee").list();
		//System.out.println(pList.size());
	}

}
