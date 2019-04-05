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

import jkt.hms.agendapoints.controller.AgendaPointSearchDTO;
import jkt.hms.masters.business.MasAgendaPointForWorkServices;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AgendaPointSearchDataServiceImpl extends HibernateDaoSupport
		implements AgendaPointSearchDataService {
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAgendaPointSearchJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAgendaPointForWorkServices> agendaPointsList = new ArrayList<MasAgendaPointForWorkServices>();

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
		agendaPointsList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasAgendaPointForWorkServices");
		// TODO Need to check
		map.put("session", session);
		map.put("agendaPointsList", agendaPointsList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchAgendaPointSearch(
			AgendaPointSearchDTO agendaPointSearch) {
		List<MasAgendaPointForWorkServices> searchAgendaPointSearchList = new ArrayList<MasAgendaPointForWorkServices>();
		Map<String, Object> agendaPointSearchFieldsMap = new HashMap<String, Object>();
		String agendaNo = "";
		DateFormat formatter;
		Date toDate = new Date();
		Date fromDate = null;
		Session session = (Session) getSession();
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		if (agendaPointSearch.getFromDate() != null) {
			try {
				fromDate = (Date) formatter.parse(agendaPointSearch
						.getFromDate());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		if (agendaPointSearch.getToDate() != null) {
			try {
				toDate = formatter.parse(agendaPointSearch.getToDate());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		if (agendaPointSearch.getAgendaNo() != null
				&& !agendaPointSearch.getAgendaNo().equalsIgnoreCase("")) {
			agendaNo = agendaPointSearch.getAgendaNo();
		}

		try {
			Criteria crit = session
					.createCriteria(MasAgendaPointForWorkServices.class);

			if (fromDate != null) {
				crit = crit.add(Restrictions.between("AgendaDate", fromDate,
						toDate));
			}
			if (!agendaNo.equals("")) {
				crit = crit.add(Restrictions.like("AgendaNo", agendaNo));
			}
			searchAgendaPointSearchList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		agendaPointSearchFieldsMap.put("searchAgendaPointSearchList",
				searchAgendaPointSearchList);
		return agendaPointSearchFieldsMap;
	}
}
