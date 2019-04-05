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
import jkt.hms.masters.business.WorkNoDepartment;
import jkt.hms.workservices.controller.AgendaDTO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MinorWorkDetailsApprovalDataServiceImpl extends
		HibernateDaoSupport implements MinorWorkDetailsApprovalDataService {
	@SuppressWarnings("unchecked")
	public Map<String, Object> showMinorWorkDetailsApprovalJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasWorkCategory> workCategoryList = new ArrayList<MasWorkCategory>();
		List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
		List<MasMinorWorkDetail> minorWorkDetailList = new ArrayList<MasMinorWorkDetail>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<WorkNoDepartment> workNoDepartmentList = new ArrayList<WorkNoDepartment>();

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
		workNoDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.WorkNoDepartment as isc");
		map.put("workNoDepartmentList", workNoDepartmentList);
		map.put("masDepartmentList", masDepartmentList);

		// TODO Need to check
		map.put("session", session);
		map.put("workCategoryList", workCategoryList);
		map.put("workTypeList", worktypeList);
		map.put("minorWorkDetailList", minorWorkDetailList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMinorWorkDetailsApproval(
			AgendaDTO minorWorkDetailsApproval) {
		List<MasMinorWorkDetail> searchMinorWorkDetailsApprovalList = new ArrayList<MasMinorWorkDetail>();
		List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();

		List<WorkNoDepartment> workNoDepartmentList = new ArrayList<WorkNoDepartment>();

		Map<String, Object> minorWorkDetailsApprovalFieldsMap = new HashMap<String, Object>();

		jkt.hms.masters.business.MasWorkType minorWorkType = new MasWorkType();
		jkt.hms.masters.business.MasWorkCategory minorWorkCategory = new MasWorkCategory();
		String minorWorkNo = "";
		String department = "";
		String workDetails = "";
		DateFormat formatter;
		Date toDate = new Date();
		Date fromDate = null;
		Session session = (Session) getSession();
		formatter = new SimpleDateFormat("dd/MM/yyyy");
		if (minorWorkDetailsApproval.getFromDate() != null) {
			try {
				fromDate = (Date) formatter.parse(minorWorkDetailsApproval
						.getFromDate());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		if (minorWorkDetailsApproval.getToDate() != null) {
			try {
				toDate = formatter.parse(minorWorkDetailsApproval.getToDate());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		if (minorWorkDetailsApproval.getMinorWorkNo() != null
				&& !minorWorkDetailsApproval.getMinorWorkNo().equalsIgnoreCase(
						"")) {
			minorWorkNo = minorWorkDetailsApproval.getMinorWorkNo();
		}
		if (minorWorkDetailsApproval.getWorkCategoryName() != null
				&& !minorWorkDetailsApproval.getWorkCategoryName()
						.equalsIgnoreCase("")) {
			minorWorkCategory.setId(Integer.parseInt(minorWorkDetailsApproval
					.getWorkCategoryName()));
		}
		if (minorWorkDetailsApproval.getWorkTypeName() != null) {
			minorWorkType.setId(Integer.parseInt(minorWorkDetailsApproval
					.getWorkTypeName()));
		}
		if (minorWorkDetailsApproval.getDepartment() != null) {
			department = minorWorkDetailsApproval.getDepartment();
		}
		if (minorWorkDetailsApproval.getWorkDetails() != null) {
			workDetails = minorWorkDetailsApproval.getWorkDetails();
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
			if (minorWorkCategory.getId() != null
					&& minorWorkCategory.getId() != 0) {
				crit = crit.createAlias("WorkCategory", "wc").add(
						Restrictions.eq("wc.Id", minorWorkCategory.getId()));
			}
			if (minorWorkType.getId() != null && minorWorkType.getId() != 0) {
				crit = crit.createAlias("WorkType", "wt").add(
						Restrictions.eq("wt.Id", minorWorkType.getId()));
			}
			if (!workDetails.equals("")) {
				crit = crit.add(Restrictions.like("MinorWorkDetail", "%"
						+ workDetails + "%"));
			}

			if (!department.equals("")) {
				crit = crit.add(Restrictions.like("DepartmentName", "%"
						+ department + "%"));
			}

			searchMinorWorkDetailsApprovalList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		worktypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasWorkType ");
		masDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");

		minorWorkDetailsApprovalFieldsMap.put("masDepartmentList",
				masDepartmentList);
		workNoDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.WorkNoDepartment as isc");
		minorWorkDetailsApprovalFieldsMap.put("workNoDepartmentList",
				workNoDepartmentList);
		minorWorkDetailsApprovalFieldsMap.put("workTypeList", worktypeList);
		minorWorkDetailsApprovalFieldsMap.put(
				"searchMinorWorkDetailSearchForCompletionWorkList",
				searchMinorWorkDetailsApprovalList);
		return minorWorkDetailsApprovalFieldsMap;
	}
}
