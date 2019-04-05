package jkt.hms.agendapoints.dataservice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.agendapoints.controller.MomWorkDetailSearchDTO;
import jkt.hms.masters.business.MasAgendaPointForWorkServices;
import jkt.hms.masters.business.MasDepartment;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MomWorkDetailSearchDataServiceImpl extends HibernateDaoSupport
		implements MomWorkDetailSearchDataService {
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMomWorkDetailSearchJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAgendaPointForWorkServices> momWorkDetailList = new ArrayList<MasAgendaPointForWorkServices>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Calendar c = Calendar.getInstance();
		Integer i;
		Integer year;
		Integer sessionyear = 0;
		String session = "";
		year = c.get(Calendar.YEAR);
		i = c.get(Calendar.MONTH) + 1;
		if (i >= 4) {
			sessionyear = year + 1;
			session = "" + year + "-" + sessionyear;

		} else {
			sessionyear = year - 1;
			session = "" + sessionyear + "-" + year;
		}

		momWorkDetailList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasAgendaPointForWorkServices");
		departmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");

		map.put("session", session);
		map.put("momWorkDetailList", momWorkDetailList);
		map.put("departmentList", departmentList);

		return map;

	}

	public Map<String, Object> searchMomWorkDetailSearch(
			MomWorkDetailSearchDTO momWorkDetailSearch) {
		List<MasAgendaPointForWorkServices> searchMomAgendaWorkDetailSearchList = new ArrayList<MasAgendaPointForWorkServices>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Map<String, Object> momWorkDetailSearchFieldsMap = new HashMap<String, Object>();

		String agendaWorkNo = "";
		DateFormat formatter;
		Date toDate = null;
		Date fromDate = null;
		Session session = (Session) getSession();
		formatter = new SimpleDateFormat("dd/MM/yyyy");

		if (momWorkDetailSearch.getFromDate() != null) {
			try {
				fromDate = (Date) formatter.parse(momWorkDetailSearch
						.getFromDate());

			} catch (ParseException e1) {
				e1.printStackTrace();

			}
		}
		if (momWorkDetailSearch.getToDate() != null) {
			try {
				toDate = formatter.parse(momWorkDetailSearch.getToDate());

			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		if (momWorkDetailSearch.getMomAgendaNo() != null) {
			agendaWorkNo = momWorkDetailSearch.getMomAgendaNo();

		}

		try {
			Criteria crit = session
					.createCriteria(MasAgendaPointForWorkServices.class);

			if (fromDate != null && toDate != null) {
				crit = crit.add(Restrictions.between("AgendaDate", fromDate,
						toDate));

			}

			if (agendaWorkNo != null) {
				crit = crit.add(Restrictions.like("AgendaNo", agendaWorkNo));

			}

			searchMomAgendaWorkDetailSearchList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		departmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		momWorkDetailSearchFieldsMap.put("departmentList", departmentList);
		momWorkDetailSearchFieldsMap.put("searchMomAgendaWorkDetailSearchList",
				searchMomAgendaWorkDetailSearchList);
		return momWorkDetailSearchFieldsMap;
	}

}
