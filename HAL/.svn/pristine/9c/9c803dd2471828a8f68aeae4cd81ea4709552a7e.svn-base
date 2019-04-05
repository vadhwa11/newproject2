package jkt.hms.workservices.dataservice;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasMinorWorkDetail;
import jkt.hms.masters.business.MasWorkType;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MinorWorkNotYetReleasedReportDataServiceImpl extends
		HibernateDaoSupport implements MinorWorkNotYetReleasedReportDataService {
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	// **************************************************************************************************
	// Minor Work Yet Released
	// **************************************************************************************************
	public Map<String, Object> showMinorWorkYetReleased() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasMinorWorkDetail> masMinorWorkDetail = new ArrayList<MasMinorWorkDetail>();
		List<MasWorkType> masWorkTypeList = new ArrayList<MasWorkType>();

		// TODO Auto-generated method stub
		return map;
	}

	// **************************************************************************************************
	// Minor Work Yet Not Released
	// **************************************************************************************************
	@SuppressWarnings("unchecked")
	public Map<String, Object> showMinorWorkNotYetReleased() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasMinorWorkDetail> masMinorWorkDetail = new ArrayList<MasMinorWorkDetail>();
		List<MasWorkType> masWorkTypeList = new ArrayList<MasWorkType>();
		try {

			masWorkTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasWorkType ");
			//System.out.println("listSize" + masWorkTypeList.size());
			if (masWorkTypeList.size() > 0) {

				map.put("masWorkTypeList", masWorkTypeList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("masMinorWorkDetail", masMinorWorkDetail);
		// TODO Auto-generated method stub
		return map;
	}
}
