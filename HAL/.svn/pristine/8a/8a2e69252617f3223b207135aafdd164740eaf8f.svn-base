package jkt.hms.workservices.dataservice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasMinorWorkDetail;
import jkt.hms.masters.business.MasWorkCategory;
import jkt.hms.masters.business.MasWorkType;
import jkt.hms.workservices.controller.AgendaDTO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MinorWorkDetailSearchDataServiceImpl extends HibernateDaoSupport
		implements MinorWorkDetailSearchDataService {
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMinorWorkDetailSearchJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasWorkCategory> workCategoryList = new ArrayList<MasWorkCategory>();
		List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
		List<MasMinorWorkDetail> minorWorkDetailList = new ArrayList<MasMinorWorkDetail>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();

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
		workCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkCategory ");
		worktypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkType ");
		minorWorkDetailList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMinorWorkDetail");
		masDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		map.put("session", session);
		map.put("workCategoryList", workCategoryList);
		map.put("workTypeList", worktypeList);
		map.put("masDepartmentList", masDepartmentList);
		map.put("minorWorkDetailList", minorWorkDetailList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMinorWorkDetailSearch(
			AgendaDTO minorWorkDetailSearch) {
		List<MasMinorWorkDetail> searchMinorWorkDetailSearchList = new ArrayList<MasMinorWorkDetail>();
		List<MasWorkCategory> workCategoryList = new ArrayList<MasWorkCategory>();
		List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
		Map<String, Object> minorWorkDetailSearchFieldsMap = new HashMap<String, Object>();
		List<MasMinorWorkDetail> minorWorkDetailList = new ArrayList<MasMinorWorkDetail>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		jkt.hms.masters.business.MasWorkType minorWorkType = new MasWorkType();
		String minorWorkNo = "";
		String department = "";
		String workDetails = "";
		DateFormat formatter;
		Date toDate = new Date();
		Date fromDate = null;
		Session session = (Session) getSession();
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		if (minorWorkDetailSearch.getFromDate() != null) {
			try {
				fromDate = (Date) formatter.parse(minorWorkDetailSearch
						.getFromDate());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		if (minorWorkDetailSearch.getToDate() != null) {
			try {
				toDate = formatter.parse(minorWorkDetailSearch.getToDate());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		if (minorWorkDetailSearch.getMinorWorkNo() != null
				&& !minorWorkDetailSearch.getMinorWorkNo().equalsIgnoreCase("")) {
			minorWorkNo = minorWorkDetailSearch.getMinorWorkNo();
		}
		if (minorWorkDetailSearch.getWorkTypeName() != null) {
			minorWorkType.setId(Integer.parseInt(minorWorkDetailSearch
					.getWorkTypeName()));
		}
		if (minorWorkDetailSearch.getDepartment() != null) {
			department = minorWorkDetailSearch.getDepartment();
		}
		if (minorWorkDetailSearch.getWorkDetails() != null) {
			workDetails = minorWorkDetailSearch.getWorkDetails();
		}

		try {
			Criteria crit = session.createCriteria(MasMinorWorkDetail.class);

			if (fromDate != null) {
				crit = crit.add(Restrictions.between("MinorWorkDetailDate",
						fromDate, toDate));
			}
			if (!minorWorkNo.equals("")) {
				crit = crit.add(Restrictions.like("MinorWorkDetailNo",
						minorWorkNo + "%"));
			}
			if (minorWorkDetailSearch.getWorkCategoryName() != null) {
				crit = crit.add(Restrictions.like("WorkCategoryId",
						minorWorkDetailSearch.getWorkCategoryName() + "%"));
			}
			if (minorWorkType.getId() != null && minorWorkType.getId() != 0) {
				crit = crit.createAlias("WorkType", "wt").add(
						Restrictions.eq("wt.Id", minorWorkType.getId()));
			}
			if (!department.equals("")) {
				crit = crit.add(Restrictions.like("DepartmentName", department
						+ "%"));
			}
			if (!workDetails.equals("")) {
				crit = crit.add(Restrictions.like("MinorWorkDetail",
						workDetails + "%"));
			}
			searchMinorWorkDetailSearchList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// workCategoryList =
		// getHibernateTemplate().find("from jkt.hms.masters.business.MasWorkCategory ");
		worktypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkType ");
		masDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");

		// minorWorkDetailSearchFieldsMap.put("workCategoryList",
		// workCategoryList);
		minorWorkDetailSearchFieldsMap.put("workTypeList", worktypeList);
		minorWorkDetailSearchFieldsMap.put("masDepartmentList",
				masDepartmentList);
		minorWorkDetailSearchFieldsMap.put("searchMinorWorkDetailSearchList",
				searchMinorWorkDetailSearchList);
		return minorWorkDetailSearchFieldsMap;
	}
}
