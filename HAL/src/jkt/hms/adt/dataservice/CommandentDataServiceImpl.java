package jkt.hms.adt.dataservice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.Inpatient;
import jkt.hms.util.HMSUtil;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CommandentDataServiceImpl extends HibernateDaoSupport implements
		CommandentDataService {

	Session session;

	/**
	 * ---------------------------------- Today Admission and SIL/DIL
	 * ------------------------------------- made by Mansi Gagrani
	 *
	 * @param generalMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Inpatient> showTodayAdmission(Map<String, Object> map) {
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		session = (Session) getSession();
		Date currentDate = null;
		int deptId = 0;
		currentDate = (Date) map.get("currentDate");
		deptId = (Integer) map.get("deptId");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		List<Inpatient> gCurrDateDischargeList = new ArrayList<Inpatient>();
		List<Inpatient> gCurrDateAdmissionList = new ArrayList<Inpatient>();
		gCurrDateAdmissionList = session.createCriteria(Inpatient.class).add(
				Restrictions.eq("DateOfAddmission", HMSUtil
						.convertStringTypeDateToDateType(date))).list();

		gCurrDateDischargeList = session.createCriteria(Inpatient.class).add(
				Restrictions.eq("DischargeDate", HMSUtil
						.convertStringTypeDateToDateType(date))).list();

		//System.out.println(":::::::size:::::" + gCurrDateDischargeList.size());
		String Alist = "";
		String Dlist = "";
		for (Inpatient Inpatient : gCurrDateDischargeList) {
			// objectList.add(discharge.getHin().getId());
			if (Dlist.length() > 0) {
				Dlist = Dlist + "," + Inpatient.getId() + "";
			} else {
				Dlist = Dlist + Inpatient.getId();
			}
		}

		for (Inpatient Inpatient : gCurrDateAdmissionList) {
			// objectList.add(discharge.getHin().getId());
			if (Alist.length() > 0) {
				Alist = Alist + "," + Inpatient.getId();
			} else {
				Alist = Alist + Inpatient.getId();
			}
		}

		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DAY_OF_MONTH, -1);
		Date nextDate = cal1.getTime();
		Calendar cal2 = Calendar.getInstance();
		// cal2.add(Calendar.DAY_OF_MONTH, -1);
		Date currDate = cal2.getTime();
		String nextDateForDB = "";
		String currDateForDB = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		nextDateForDB = sdf.format(nextDate);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
		currDateForDB = sdf1.format(currDate);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String qry = "select a " + " from Inpatient a where";
		if (Alist.length() > 0) {
			qry = qry + "(a.DateOfAddmission <= '" + nextDateForDB + "'"
					+ " and '" + currDateForDB
					+ "' <= nvl(a.DischargeDate,sysdate)" + " or a.Id in ("
					+ Alist + "))";
		} else {
			qry = qry + " a.DateOfAddmission <= '" + nextDateForDB + "'"
					+ " and '" + currDateForDB
					+ "' <= nvl(a.DischargeDate,sysdate)";
		}
		if (Dlist.length() > 0) {
			qry = qry + " and a.Id not in (" + Dlist + ") ";
		}

		qry = qry + " and a.AdStatus !='C' and a.Department.Id= '" + deptId
				+ "'";

		//System.out.println("qry:::::::" + qry);
		inpatientList = session.createQuery(qry).list();
		/*
		 * (date_of_addmission <= DATE_ADD('"+nextDateForDB+"',INTERVAL '-1'
		 * DAY) and " +" DATE_ADD('"+nextDateForDB+
		 * "',INTERVAL '-1' DAY) <= ifNull(discharge_date,NOW()) or inpatient_id in ("
		 * +Alist+"))" + " and inpatient_id not in ("+Dlist+") and ad_status
		 * !='C' and
		 */// inpatientList =
			// session.createCriteria(Inpatient.class).add(Restrictions.eq("DateOfAddmission",
			// currentDate)).add(Restrictions.eq("Department.Id",
			// deptId)).list();
		/*
		 * inpatientList =
		 * session.createCriteria(Inpatient.class).add(Restrictions
		 * .eq("Department.Id", deptId))
		 * .add(Restrictions.le("DateOfAddmission", nextDateForDB))
		 * .add(Restrictions.isNull(Restrictions.eq("DischargeDate",
		 * nextDateForDB))) .add(Restrictions.eq("AdStatus", "A")).list();
		 */

		//System.out.println("::::::::::" + inpatientList.size());
		return inpatientList;
	}

	@SuppressWarnings("unchecked")
	public List<Inpatient> showTodaySILDILJsp(Map<String, Object> map) {
		List<Inpatient> silDilStatusList = new ArrayList<Inpatient>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Date currentDate = null;
		int deptId = 0;
		currentDate = (Date) map.get("currentDate");
		deptId = (Integer) map.get("deptId");
		session = (Session) getSession();
		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DAY_OF_MONTH, -1);
		Date nextDate = cal1.getTime();
		String nextDateForDB = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		nextDateForDB = sdf.format(nextDate);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Calendar cal2 = Calendar.getInstance();
		// cal2.add(Calendar.DAY_OF_MONTH, -1);
		Date currDate = cal2.getTime();
		String currDateForDB = "";
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyyy");
		currDateForDB = sdf1.format(currDate);
		// silDilStatusList =
		// session.createCriteria(SilDilStatus.class).add(Restrictions.eq("Department.Id",
		// deptId)).add(Restrictions.ne("ConditionStatus",
		// "Normal")).add(Restrictions.eq("AdStatus", "A")).list();
		List l = new ArrayList();
		l.add("DIL");
		l.add("SIL");

		List<Inpatient> gCurrDateDischargeList = new ArrayList<Inpatient>();
		List<Inpatient> gCurrDateAdmissionList = new ArrayList<Inpatient>();
		gCurrDateAdmissionList = session.createCriteria(Inpatient.class).add(
				Restrictions.eq("DateOfAddmission", HMSUtil
						.convertStringTypeDateToDateType(date))).list();

		gCurrDateDischargeList = session.createCriteria(Inpatient.class).add(
				Restrictions.eq("DischargeDate", HMSUtil
						.convertStringTypeDateToDateType(date))).list();

		//System.out.println(":::::::size:::::" + gCurrDateDischargeList.size());
		String Alist = "";
		String Dlist = "";
		for (Inpatient Inpatient : gCurrDateDischargeList) {
			// objectList.add(discharge.getHin().getId());
			if (Dlist.length() > 0) {
				Dlist = Dlist + "," + Inpatient.getId() + "";
			} else {
				Dlist = Dlist + Inpatient.getId();
			}
		}

		for (Inpatient Inpatient : gCurrDateAdmissionList) {
			// objectList.add(discharge.getHin().getId());
			if (Alist.length() > 0) {
				Alist = Alist + "," + Inpatient.getId();
			} else {
				Alist = Alist + Inpatient.getId();
			}
		}
		String qry = "select a " + " from Inpatient a where ";

		if (Alist.length() > 0) {
			qry = qry + "(a.DateOfAddmission <= '" + nextDateForDB + "'"
					+ " and '" + currDateForDB
					+ "' <= NVL(a.DischargeDate,sysdate)" + " or a.Id in ("
					+ Alist + "))";
		} else {
			qry = qry + " a.DateOfAddmission <= '" + nextDateForDB + "'"
					+ " and '" + currDateForDB
					+ "' <= NVL(a.DischargeDate,sysdate)";
		}
		if (Dlist.length() > 0) {
			qry = qry + " and a.Id not in (" + Dlist + ") ";
		}

		qry = qry + " and ConditionStatus in ('DIL','SIL')"
				+ " and a.AdStatus !='C' and a.Department.Id= '" + deptId + "'";

		silDilStatusList = session.createQuery(qry).list();

		/*
		 * silDilStatusList = session.createCriteria(Inpatient.class)
		 * .add(Restrictions.eq("Department.Id",
		 * deptId)).add(Restrictions.in("ConditionStatus",l))
		 * .add(Restrictions.eq("AdStatus", "A")) .list();
		 */

		// String qry = "";

		//System.out.println("sildil status list:::::::::"+ silDilStatusList.size());
		return silDilStatusList;
	}

	/**
	 * ---------------------------------- ADT BED STATUS
	 * ------------------------------------- made by Priyanka Garg
	 *
	 * @return
	 */
	@SuppressWarnings( { "deprecation", "unchecked" })
	public Map<String, Object> showBedStateJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List bedStatusList = new ArrayList();
		List todayList = new ArrayList();
		List count = new ArrayList();
		Date currentDate = null;
		List sumList = new ArrayList();
		session = (Session) getSession();
		currentDate = (Date) generalMap.get("currentDate");
		int toYear = 1900 + currentDate.getYear();
		int toMonth = currentDate.getMonth() + 1;
		String dateTo = Integer.toString(toYear) + "-"
				+ Integer.toString(toMonth) + "-"
				+ Integer.toString(currentDate.getDate());
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		/*
		 * Stringqry=
		 * "select ifnull(adm,0) , ifnull(DIL,0),ifnull(SIL,0), dt.department_id, dt.department_name from mas_department dt left join "
		 * +
		 * "(SELECT count(*) adm ,department_id FROM inpatient where date_of_addmission='"
		 * +dateTo+"' group by department_id) a " +
		 * "on a.department_id=dt.department_id "+
		 * "left join (SELECT count(*) as DIL, department_id FROM sil_dil_status s "
		 * +"where last_chg_date='"+dateTo+
		 * "' and condition_status='DIL' group by department_id) b "+
		 * "on b.department_id=dt.department_id "+
		 * "left join (SELECT count(*) as SIL, department_id FROM sil_dil_status s "
		 * +"where last_chg_date='"+dateTo+
		 * "' and condition_status='SIL' group by department_id) c "+
		 * "on c.department_id=dt.department_id ";
		 *
		 * bedStatusList = session.createSQLQuery(qry).list();
		 *
		 * StringsumQry=
		 * "select sum(tot) as sumtot from (select (ifnull(adm,0)+ ifnull(DIL,0)+ ifnull(SIL,0)) tot from mas_department dt left join "
		 * +
		 * "(SELECT count(*) adm ,department_id FROM inpatient where date_of_addmission='"
		 * +dateTo+"' group by department_id) a " +
		 * "on a.department_id=dt.department_id "+
		 * "left join (SELECT count(*) as DIL, department_id FROM sil_dil_status s "
		 * +"where last_chg_date='"+dateTo+
		 * "' and condition_status='DIL' group by department_id) b "+
		 * "on b.department_id=dt.department_id "+
		 * "left join (SELECT count(*) as SIL, department_id FROM sil_dil_status s "
		 * +"where last_chg_date='"+dateTo+
		 * "' and condition_status='SIL' group by department_id) c "+
		 * "on c.department_id=dt.department_id)d ";
		 */
		Calendar cal1 = Calendar.getInstance();
		// cal1.add(Calendar.DAY_OF_MONTH, +1);
		Date nextDate = cal1.getTime();
		String nextDateForDB = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		nextDateForDB = sdf.format(nextDate);

		List objectList = new ArrayList();

		List<Inpatient> gCurrDateDischargeList = new ArrayList<Inpatient>();
		List<Inpatient> gCurrDateAdmissionList = new ArrayList<Inpatient>();
		gCurrDateAdmissionList = session.createCriteria(Inpatient.class).add(
				Restrictions.eq("DateOfAddmission", HMSUtil
						.convertStringTypeDateToDateType(date))).list();

		gCurrDateDischargeList = session.createCriteria(Inpatient.class).add(
				Restrictions.eq("DischargeDate", HMSUtil
						.convertStringTypeDateToDateType(date))).list();

		// //System.out.println(":::::::size:::::"+gCurrDateDischargeList.size());
		String Alist = "";
		String Dlist = "";
		for (Inpatient Inpatient : gCurrDateDischargeList) {
			// objectList.add(discharge.getHin().getId());
			if (Dlist.length() > 0) {
				Dlist = Dlist + "," + Inpatient.getId() + "";
			} else {
				Dlist = Dlist + Inpatient.getId();
			}
		}

		for (Inpatient Inpatient : gCurrDateAdmissionList) {
			// objectList.add(discharge.getHin().getId());
			if (Alist.length() > 0) {
				Alist = Alist + "," + Inpatient.getId();
			} else {
				Alist = Alist + Inpatient.getId();
			}
		}

		String qry = " select b.department_name, count(b.department_id) dept_count, "
				+ " sum(case condition_status when 'SIL' Then 1 else 0 end) condition_sil, "
				+ " sum(case condition_status when 'DIL' Then 1 else 0 end) condition_dil, "
				+ " sum(case diet_type when 'Veg' Then 1 else 0 end) diet_veg, "
				+ " sum(case diet_type when 'Non-Veg' Then 1 else 0 end) diet_nonveg, b.department_id, b.bed_strength "
				+ " from inpatient a , mas_department b " + " where ";

		if (Alist.length() > 0) {
			/*qry = qry + " (date_of_addmission <= DATE_ADD('" + nextDateForDB
					+ "',INTERVAL '-1' DAY)  and " + " DATE_ADD('"
					+ nextDateForDB
					+ "',INTERVAL '0' DAY) <= ifNull(discharge_date,NOW())"
					+ " or inpatient_id in (" + Alist + "))";*/
			qry = qry + " (trunc(date_of_addmission) <= trunc(sysdate-1) and trunc(sysdate) <= NVL(discharge_date,SYSDATE )"
					+ " or inpatient_id in (" + Alist + "))";
		} else {
			qry = qry + " trunc(date_of_addmission) <= trunc(sysdate-1) and trunc(sysdate) <= NVL(discharge_date,SYSDATE )";
		}

		if (Dlist.length() > 0) {

			qry = qry + " and inpatient_id not in (" + Dlist + ")";
		}

		qry = qry + " and ad_status !='C' and "
				+ " a.department_id = b.department_id "
				+ "  group by  b.department_name,b.department_id,condition_status,diet_type,b.bed_strength ";
		// //System.out.println("::::::::::::"+qry);
		bedStatusList = session.createSQLQuery(qry).list();

		// String query =
		// "select count(*) from inpatient where ad_status in ('A') or ad_no in ("+list+")";
		String query = "select NVL(a.ADM,0) + NVL(d.REMD,0) - NVL(c.DIS,0) as Total from "
				+ " (SELECT count(*) as ADM FROM inpatient inp where trunc(inp.date_of_addmission) = '"
				+ nextDateForDB
				+ "') a, "
				+ " (SELECT count(*) as Death FROM expiry_details where trunc(expiry_date)  = '"
				+ nextDateForDB
				+ "') b, "
				+ " (SELECT count(*) as DIS FROM discharge where trunc(discharge.date_of_discharge) = '"
				+ nextDateForDB
				+ "') c,"
				+ " (SELECT count(*) as REMD FROM inpatient inp2 where trunc(inp2.date_of_addmission) <= trunc(sysdate-1) and trunc(sysdate) <= NVL(trunc(inp2.discharge_date),SYSDATE ) and inp2.ad_status !='C') d ";

		// //System.out.println("::::::::::::"+query);

		count = session.createSQLQuery(query).list();

		String dquery = "select department_id,count(*) as TDIS from inpatient "
				+ "where discharge_date = '" + nextDateForDB
				+ "' group by department_id";
		todayList = session.createSQLQuery(dquery).list();
		int totcount = 0;
		if (count.size() > 0) {
			Iterator countvalue = count.iterator();
			while (countvalue.hasNext()) {
				totcount = Integer.parseInt(countvalue.next().toString());

			}

		}
		// //System.out.println("query:::::::"+totcount);
		// //System.out.println("bedstatus list::::::::"+bedStatusList.size());

		// sumList = session.createSQLQuery(sumQry).list();
		map.put("bedStatusList", bedStatusList);
		map.put("totcount", totcount);
		map.put("todayList", todayList);
		map.put("sumList", sumList);

		return map;
	}

}
