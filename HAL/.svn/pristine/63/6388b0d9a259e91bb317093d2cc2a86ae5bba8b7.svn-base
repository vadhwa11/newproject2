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
import jkt.hms.masters.business.MasDepartmentType;
import jkt.hms.masters.business.MasMinorWorkDetail;
import jkt.hms.masters.business.MasWorkCategory;
import jkt.hms.masters.business.MasWorkType;
import jkt.hms.masters.business.WorkNoDepartment;
import jkt.hms.workservices.controller.AgendaDTO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MinorWorkDetailSearchForCompletionWorkDataServiceImpl extends
		HibernateDaoSupport implements
		MinorWorkDetailSearchForCompletionWorkDataService {
	Map<String, Object> map = new HashMap<String, Object>();

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMinorWorkDetailSearchForCompletionWorkJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasWorkCategory> workCategoryList = new ArrayList<MasWorkCategory>();
		List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
		List<MasMinorWorkDetail> minorWorkDetailList = new ArrayList<MasMinorWorkDetail>();
		List<WorkNoDepartment> workNoDepartmentList = new ArrayList<WorkNoDepartment>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();

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
		masDepartmentList = hbt
				.find("from jkt.hms.masters.business.MasDepartmentType");
		workCategoryList = hbt
				.find("from jkt.hms.masters.business.MasWorkCategory ");
		worktypeList = hbt.find("from jkt.hms.masters.business.MasWorkType ");
		minorWorkDetailList = hbt
				.find("from jkt.hms.masters.business.MasMinorWorkDetail");
		workNoDepartmentList = hbt
				.find("from jkt.hms.masters.business.WorkNoDepartment as isc");

		// TODO Need to check
		map.put("session", session);
		map.put("workCategoryList", workCategoryList);
		map.put("masDepartmentList", masDepartmentList);

		map.put("workNoDepartmentList", workNoDepartmentList);
		map.put("workTypeList", worktypeList);
		map.put("minorWorkDetailList", minorWorkDetailList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMinorWorkDetailSearchForCompletionWork(
			AgendaDTO minorWorkDetailSearchForCompletionWork) {
		List<MasMinorWorkDetail> searchMinorWorkDetailsApprovalList = new ArrayList<MasMinorWorkDetail>();
		List<MasWorkType> worktypeList = new ArrayList<MasWorkType>();
		List<MasDepartmentType> masDepartmentList = new ArrayList<MasDepartmentType>();

		List<WorkNoDepartment> workNoDepartmentList = new ArrayList<WorkNoDepartment>();

		Map<String, Object> minorWorkDetailSearchForCompletionWorkMap = new HashMap<String, Object>();

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
		if (minorWorkDetailSearchForCompletionWork.getFromDate() != null) {
			try {
				fromDate = (Date) formatter
						.parse(minorWorkDetailSearchForCompletionWork
								.getFromDate());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		if (minorWorkDetailSearchForCompletionWork.getToDate() != null) {
			try {
				toDate = formatter.parse(minorWorkDetailSearchForCompletionWork
						.getToDate());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		if (minorWorkDetailSearchForCompletionWork.getMinorWorkNo() != null
				&& !minorWorkDetailSearchForCompletionWork.getMinorWorkNo()
						.equalsIgnoreCase("")) {
			minorWorkNo = minorWorkDetailSearchForCompletionWork
					.getMinorWorkNo();
		}
		if (minorWorkDetailSearchForCompletionWork.getWorkCategoryName() != null) {
			minorWorkCategory.setId(Integer
					.parseInt(minorWorkDetailSearchForCompletionWork
							.getWorkCategoryName()));
		}
		if (minorWorkDetailSearchForCompletionWork.getWorkTypeName() != null) {
			minorWorkType.setId(Integer
					.parseInt(minorWorkDetailSearchForCompletionWork
							.getWorkTypeName()));
		}
		if (minorWorkDetailSearchForCompletionWork.getDepartment() != null) {
			department = minorWorkDetailSearchForCompletionWork.getDepartment();
		}
		if (minorWorkDetailSearchForCompletionWork.getWorkDetails() != null) {
			workDetails = minorWorkDetailSearchForCompletionWork
					.getWorkDetails();
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
				"from jkt.hms.masters.business.MasDepartmentType ");

		minorWorkDetailSearchForCompletionWorkMap.put("masDepartmentList",
				masDepartmentList);
		workNoDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.WorkNoDepartment as isc");
		minorWorkDetailSearchForCompletionWorkMap.put("workNoDepartmentList",
				workNoDepartmentList);
		minorWorkDetailSearchForCompletionWorkMap.put("workTypeList",
				worktypeList);
		minorWorkDetailSearchForCompletionWorkMap.put(
				"searchMinorWorkDetailsApprovalList",
				searchMinorWorkDetailsApprovalList);
		return minorWorkDetailSearchForCompletionWorkMap;
	}
}
