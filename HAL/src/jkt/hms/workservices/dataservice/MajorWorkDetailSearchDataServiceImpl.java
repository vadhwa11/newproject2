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
import jkt.hms.masters.business.MasMajorWorkDetail;
import jkt.hms.masters.business.MasWorkCategory;
import jkt.hms.masters.business.MasWorkType;
import jkt.hms.workservices.controller.MajorWorkDetailSearchDTO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MajorWorkDetailSearchDataServiceImpl extends HibernateDaoSupport
		implements MajorWorkDetailSearchDataService {
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMajorWorkDetailSearchJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasWorkCategory> workCategoryList = new ArrayList<MasWorkCategory>();
		List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
		List<MasMajorWorkDetail> majorWorkDetailList = new ArrayList<MasMajorWorkDetail>();
		List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();
		departmentTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment ");

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
		majorWorkDetailList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMajorWorkDetail");
		map.put("departmentTypeList", departmentTypeList);

		map.put("session", session);
		map.put("workCategoryList", workCategoryList);
		map.put("workTypeList", worktypeList);
		map.put("majorWorkDetailList", majorWorkDetailList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMajorWorkDetailSearch(
			MajorWorkDetailSearchDTO majorWorkDetailSearch) {
		List<MasMajorWorkDetail> searchMajorWorkDetailSearchList = new ArrayList<MasMajorWorkDetail>();
		List<MasWorkCategory> workCategoryList = new ArrayList<MasWorkCategory>();
		List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
		Map<String, Object> majorWorkDetailSearchFieldsMap = new HashMap<String, Object>();
		List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();
		departmentTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment ");

		jkt.hms.masters.business.MasWorkType majorWorkType = new MasWorkType();
		jkt.hms.masters.business.MasWorkCategory majorWorkCategory = new MasWorkCategory();
		String majorWorkNo = "";
		DateFormat formatter;
		Date toDate = null;
		Date fromDate = null;
		Session session = (Session) getSession();
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		String department = "";
		String workDetails = "";
		if (majorWorkDetailSearch.getFromDate() != null) {
			try {
				fromDate = (Date) formatter.parse(majorWorkDetailSearch
						.getFromDate());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		if (majorWorkDetailSearch.getToDate() != null) {
			try {
				toDate = formatter.parse(majorWorkDetailSearch.getToDate());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		if (majorWorkDetailSearch.getMajorWorkNo() != null) {
			majorWorkNo = majorWorkDetailSearch.getMajorWorkNo();
		}
		if (majorWorkDetailSearch.getWorkCategoryName() != null) {
			// majorWorkCategory.setId(Integer.parseInt(majorWorkDetailSearch.getWorkCategoryName()));
		}
		if (majorWorkDetailSearch.getWorkTypeName() != null) {
			majorWorkType.setId(Integer.parseInt(majorWorkDetailSearch
					.getWorkTypeName()));
		}
		if (majorWorkDetailSearch.getDepartment() != null) {
			department = majorWorkDetailSearch.getDepartment();
		}
		if (majorWorkDetailSearch.getWorkDetails() != null) {
			workDetails = majorWorkDetailSearch.getWorkDetails();
		}

		try {
			Criteria crit = session.createCriteria(MasMajorWorkDetail.class);

			if (fromDate != null && toDate != null) {
				crit = crit.add(Restrictions.between("MajorWorkDetailDate",
						fromDate, toDate));
			}
			if (!majorWorkNo.equals("")) {
				crit = crit.add(Restrictions.like("MajorWorkDetailNo",
						majorWorkNo + "%"));
			}
			if (majorWorkDetailSearch != null
					&& majorWorkDetailSearch.getWorkCategoryName() != null
					&& !majorWorkDetailSearch.getWorkCategoryName()
							.equalsIgnoreCase("0")) {
				crit = crit.add(Restrictions.eq("WorkCategoryName",
						majorWorkDetailSearch.getWorkCategoryName() != null));

			}
			if (majorWorkType.getId() != null && majorWorkType.getId() != 0) {
				crit = crit.createAlias("WorkType", "wt").add(
						Restrictions.eq("wt.Id", majorWorkType.getId()));
			}
			if (!department.equals("")) {
				crit = crit.add(Restrictions.like("DepartmentName", department
						+ "%"));
			}
			if (!workDetails.equals("")) {
				crit = crit.add(Restrictions.like("MinorWorkDetail",
						workDetails + "%"));
			}
			searchMajorWorkDetailSearchList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		workCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkCategory ");
		worktypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkType ");
		majorWorkDetailSearchFieldsMap
				.put("workCategoryList", workCategoryList);
		majorWorkDetailSearchFieldsMap.put("workTypeList", worktypeList);
		majorWorkDetailSearchFieldsMap.put("departmentTypeList",
				departmentTypeList);

		majorWorkDetailSearchFieldsMap.put("searchMajorWorkDetailSearchList",
				searchMajorWorkDetailSearchList);
		return majorWorkDetailSearchFieldsMap;
	}
}
