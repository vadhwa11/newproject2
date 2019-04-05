package jkt.hms.agendapoints.dataservice;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasAgendaPointForWorkServices;
import jkt.hms.masters.business.MasDepartment;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AgendaReportDataServiceImpl extends HibernateDaoSupport implements
		AgendaReportDataService {

	public Map<String, Object> showAgendaRegister() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAgendaPointForWorkServices> masAgendaPointForWorkServices = new ArrayList<MasAgendaPointForWorkServices>();
		masAgendaPointForWorkServices = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasAgendaPointForWorkServices ");
		map.put("masAgendaPointForWorkServices", masAgendaPointForWorkServices);
		return map;
	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	public Map<String, Object> showMomRegister() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasAgendaPointForWorkServices> masAgendaPointForWorkServices = new ArrayList<MasAgendaPointForWorkServices>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		try {
			masAgendaPointForWorkServices = session.createCriteria(
					MasAgendaPointForWorkServices.class).add(
					Restrictions.eq("Status", "y")).list();
			departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment ");
			if (departmentList.size() > 0) {

				map.put("departmentList", departmentList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("masAgendaPointForWorkServices", masAgendaPointForWorkServices);
		// TODO Auto-generated method stub
		return map;
	}
}
