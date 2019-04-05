package jkt.hms.masters.dataservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.HrClassMaster;
import jkt.hms.masters.business.HrDutyMaster;
import jkt.hms.masters.business.HrDutyTimeMaster;
import jkt.hms.masters.business.HrEstablishmentMaster;
import jkt.hms.masters.business.HrLeaveTypeMaster;
import jkt.hms.masters.business.HrMedicalCourseMaster;
import jkt.hms.masters.business.HrSpecialistMaster;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.util.HMSUtil;

import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HrRelatedMasterDataServiceImpl extends HibernateDaoSupport
		implements HrRelatedMasterDataService {
	/**
	 * ------- Speciality Master Added by Priyanka started on 29th April 2009
	 */
	public boolean addSpeciality(HrSpecialistMaster hrSpecialistMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrSpecialistMaster);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteSpeciality(int id, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		HrSpecialistMaster hrSpecialistMaster = new HrSpecialistMaster();
		hrSpecialistMaster = (HrSpecialistMaster) getHibernateTemplate().get(
				HrSpecialistMaster.class, id);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrSpecialistMaster.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrSpecialistMaster.setStatus("y");
				dataDeleted = false;
			}
		}
		hrSpecialistMaster.setLastChgBy(changedBy);
		hrSpecialistMaster.setLastChgDate(currentDate);
		hrSpecialistMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrSpecialistMaster);
		return dataDeleted;
	}

	public boolean editSpecialityToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String name = "";
		@SuppressWarnings("unused")
		String code = "";
		int id = 0;
		String changedBy = "";
		id = (Integer) generalMap.get("id");
		code = (String) generalMap.get("code");
		name = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		HrSpecialistMaster hrSpecialistMaster = (HrSpecialistMaster) getHibernateTemplate()
				.get(HrSpecialistMaster.class, id);

		hrSpecialistMaster.setId(id);
		hrSpecialistMaster.setSpecialistName(name);
		hrSpecialistMaster.setLastChgBy(changedBy);
		hrSpecialistMaster.setLastChgDate(currentDate);
		hrSpecialistMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrSpecialistMaster);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchSpeciality(String code, String name) {
		List<HrSpecialistMaster> searchSpecialityList = new ArrayList<HrSpecialistMaster>();
		Map<String, Object> specialityFieldsMap = new HashMap<String, Object>();
		List gridCurrencyList = null;
		try {
			if ((name != null) || (code == null)) {
				searchSpecialityList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.HrSpecialistMaster as i where i.SpecialistName like '"
										+ name + "%' order by i.SpecialistName");
			} else {
				searchSpecialityList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.HrSpecialistMaster as i where i.SpecialistCode like '"
										+ code + "%' order by i.SpecialistCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchSpecialityList  " + e);
		}
		specialityFieldsMap.put("searchSpecialityList", searchSpecialityList);
		return specialityFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSpecialityJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrSpecialistMaster> searchSpecialityList = new ArrayList<HrSpecialistMaster>();
		searchSpecialityList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrSpecialistMaster ");
		map.put("searchSpecialityList", searchSpecialityList);
		return map;
	}

	/**
	 * ------- Medical Course Master Added by Priyanka started on 30th April
	 * 2009
	 */
	public boolean addMedicalCourse(HrMedicalCourseMaster hrMedicalCourseMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrMedicalCourseMaster);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteMedicalCourse(int id, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		HrMedicalCourseMaster hrMedicalCourseMaster = new HrMedicalCourseMaster();
		hrMedicalCourseMaster = (HrMedicalCourseMaster) getHibernateTemplate()
				.get(HrMedicalCourseMaster.class, id);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrMedicalCourseMaster.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrMedicalCourseMaster.setStatus("y");
				dataDeleted = false;
			}
		}
		hrMedicalCourseMaster.setLastChgBy(changedBy);
		hrMedicalCourseMaster.setLastChgDate(currentDate);
		hrMedicalCourseMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrMedicalCourseMaster);
		return dataDeleted;
	}

	public boolean editMedicalCourseToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String name = "";
		@SuppressWarnings("unused")
		String code = "";
		int id = 0;
		String typeOfCourse = "";
		String changedBy = "";
		id = (Integer) generalMap.get("id");
		code = (String) generalMap.get("code");
		name = (String) generalMap.get("name");
		typeOfCourse = (String) generalMap.get("typeOfCourse");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		HrMedicalCourseMaster hrMedicalCourseMaster = (HrMedicalCourseMaster) getHibernateTemplate()
				.get(HrMedicalCourseMaster.class, id);

		hrMedicalCourseMaster.setId(id);
		hrMedicalCourseMaster.setCourseName(name);
		hrMedicalCourseMaster.setCourseCode(code);
		hrMedicalCourseMaster.setCourseType(typeOfCourse);
		hrMedicalCourseMaster.setLastChgBy(changedBy);
		hrMedicalCourseMaster.setLastChgDate(currentDate);
		hrMedicalCourseMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrMedicalCourseMaster);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchMedicalCourse(String code, String name) {
		List<HrMedicalCourseMaster> searchMedicalCourseList = new ArrayList<HrMedicalCourseMaster>();
		Map<String, Object> courseFieldsMap = new HashMap<String, Object>();
		List gridCurrencyList = null;
		try {
			if ((name != null) || (code == null)) {
				searchMedicalCourseList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.HrMedicalCourseMaster as i where i.CourseName like '"
										+ name + "%' order by i.CourseName");
			} else {
				searchMedicalCourseList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.HrMedicalCourseMaster as i where i.CourseCode like '"
										+ code + "%' order by i.CourseCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchMedicalCourseList  " + e);
		}
		courseFieldsMap.put("searchMedicalCourseList", searchMedicalCourseList);
		return courseFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMedicalCourseJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMedicalCourseMaster> searchMedicalCourseList = new ArrayList<HrMedicalCourseMaster>();
		searchMedicalCourseList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrMedicalCourseMaster ");
		map.put("searchMedicalCourseList", searchMedicalCourseList);
		return map;
	}

	/**
	 * ------- Leave Type Master Added by Priyanka started on 4th May 2009
	 */
	public boolean addLeaveType(HrLeaveTypeMaster hrLeaveTypeMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrLeaveTypeMaster);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteLeaveType(int id, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		HrLeaveTypeMaster hrLeaveTypeMaster = new HrLeaveTypeMaster();
		hrLeaveTypeMaster = (HrLeaveTypeMaster) getHibernateTemplate().get(
				HrLeaveTypeMaster.class, id);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrLeaveTypeMaster.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrLeaveTypeMaster.setStatus("y");
				dataDeleted = false;
			}
		}
		hrLeaveTypeMaster.setLastChgBy(changedBy);
		hrLeaveTypeMaster.setLastChgDate(currentDate);
		hrLeaveTypeMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrLeaveTypeMaster);
		return dataDeleted;
	}

	public boolean editLeaveTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String details = "";
		@SuppressWarnings("unused")
		String leaveType = "";
		int id = 0;
		int days = 0;
		String changedBy = "";
		id = (Integer) generalMap.get("id");
		leaveType = (String) generalMap.get("leaveType");
		details = (String) generalMap.get("details");
		days = (Integer) generalMap.get("days");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		HrLeaveTypeMaster hrLeaveTypeMaster = (HrLeaveTypeMaster) getHibernateTemplate()
				.get(HrLeaveTypeMaster.class, id);

		hrLeaveTypeMaster.setId(id);
		hrLeaveTypeMaster.setLeaveType(leaveType);
		hrLeaveTypeMaster.setDetails(details);
		hrLeaveTypeMaster.setDays(days);
		hrLeaveTypeMaster.setLastChgBy(changedBy);
		hrLeaveTypeMaster.setLastChgDate(currentDate);
		hrLeaveTypeMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrLeaveTypeMaster);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchLeaveType(String leaveType, String details) {
		List<HrLeaveTypeMaster> searchLeaveTypeList = new ArrayList<HrLeaveTypeMaster>();
		Map<String, Object> leaveFieldsMap = new HashMap<String, Object>();
		List gridCurrencyList = null;
		try {
			if ((leaveType != null) || (details == null)) {
				searchLeaveTypeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HrLeaveTypeMaster as i where i.LeaveType like '"
								+ leaveType + "%' order by i.LeaveType");
			} else {
				searchLeaveTypeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HrLeaveTypeMaster as i where i.Details like '"
								+ details + "%' order by i.Details");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchLeaveTypeList  " + e);
		}
		leaveFieldsMap.put("searchLeaveTypeList", searchLeaveTypeList);
		return leaveFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showLeaveTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrLeaveTypeMaster> searchLeaveTypeList = new ArrayList<HrLeaveTypeMaster>();
		searchLeaveTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrLeaveTypeMaster ");
		map.put("searchLeaveTypeList", searchLeaveTypeList);
		return map;
	}

	/**
	 * ------- Duty Time Master Added by Priyanka started on 4th May 2009
	 */
	public boolean addDutyTime(HrDutyTimeMaster hrDutyTimeMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrDutyTimeMaster);
		hbt.refresh(hrDutyTimeMaster);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteDutyTime(int id, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		HrDutyTimeMaster hrDutyTimeMaster = new HrDutyTimeMaster();
		hrDutyTimeMaster = (HrDutyTimeMaster) getHibernateTemplate().get(
				HrDutyTimeMaster.class, id);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrDutyTimeMaster.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrDutyTimeMaster.setStatus("y");
				dataDeleted = false;
			}
		}
		hrDutyTimeMaster.setLastChgBy(changedBy);
		hrDutyTimeMaster.setLastChgDate(currentDate);
		hrDutyTimeMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrDutyTimeMaster);
		return dataDeleted;
	}

	public boolean editDutyTimeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String fromTime = "";
		@SuppressWarnings("unused")
		String code = "";
		int id = 0;
		String toTime = "";
		String validOn = "";
		String changedBy = "";
		String shiftType = "";
		id = (Integer) generalMap.get("id");
		code = (String) generalMap.get("code");
		fromTime = (String) generalMap.get("fromTime");
		toTime = (String) generalMap.get("toTime");
		validOn = (String) generalMap.get("validOn");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		shiftType = (String) generalMap.get("shiftType");
		HrDutyTimeMaster hrDutyTimeMaster = (HrDutyTimeMaster) getHibernateTemplate()
				.get(HrDutyTimeMaster.class, id);

		hrDutyTimeMaster.setId(id);
		hrDutyTimeMaster.setDutyCode(code);
		hrDutyTimeMaster.setDutyFromTime(fromTime);
		hrDutyTimeMaster.setDutyToTime(toTime);
		hrDutyTimeMaster.setValidOn(validOn);
		hrDutyTimeMaster.setLastChgBy(changedBy);
		hrDutyTimeMaster.setLastChgDate(currentDate);
		hrDutyTimeMaster.setLastChgTime(currentTime);
		if (!shiftType.equals("")) {
			hrDutyTimeMaster.setDutyShiftType(shiftType);
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrDutyTimeMaster);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDutyTime(String code) {
		List<HrDutyTimeMaster> searchDutyTimeList = new ArrayList<HrDutyTimeMaster>();
		Map<String, Object> dutyFieldsMap = new HashMap<String, Object>();
		try {
			if ((code != null)) {
				searchDutyTimeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HrDutyTimeMaster as i where i.DutyCode like '"
								+ code + "%' order by i.DutyCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchDutyTimeList  " + e);
		}
		dutyFieldsMap.put("searchDutyTimeList", searchDutyTimeList);
		return dutyFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDutyTimeJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrDutyTimeMaster> searchDutyTimeList = new ArrayList<HrDutyTimeMaster>();
		List<HrDutyMaster> dutyList = new ArrayList<HrDutyMaster>();
		searchDutyTimeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrDutyTimeMaster ");
		dutyList = session.createCriteria(HrDutyMaster.class).add(
				Restrictions.eq("Status", "y")).list();
		map.put("searchDutyTimeList", searchDutyTimeList);
		map.put("dutyList", dutyList);
		return map;
	}

	/**
	 * ------- Establishment Master---------------- Added by Priyanka started on
	 * 4th May 2009
	 */
	public boolean addEstablishment(HrEstablishmentMaster hrEstablishmentMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrEstablishmentMaster);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteEstablishment(int id, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		HrEstablishmentMaster hrEstablishmentMaster = new HrEstablishmentMaster();
		hrEstablishmentMaster = (HrEstablishmentMaster) getHibernateTemplate()
				.get(HrEstablishmentMaster.class, id);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrEstablishmentMaster.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrEstablishmentMaster.setStatus("y");
				dataDeleted = false;
			}
		}
		hrEstablishmentMaster.setLastChgBy(changedBy);
		hrEstablishmentMaster.setLastChgDate(currentDate);
		hrEstablishmentMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrEstablishmentMaster);
		return dataDeleted;
	}

	public boolean editEstablishmentToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		@SuppressWarnings("unused")
		String changedBy = "";
		int id = 0;
		int unitId = 0;
		int rankId = 0;
		int specialityId = 0;
		int strength = 0;
		id = (Integer) generalMap.get("id");
		unitId = (Integer) generalMap.get("unitId");
		rankId = (Integer) generalMap.get("rankId");
		specialityId = (Integer) generalMap.get("specialityId");
		strength = (Integer) generalMap.get("strength");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		HrEstablishmentMaster hrEstablishmentMaster = (HrEstablishmentMaster) getHibernateTemplate()
				.get(HrEstablishmentMaster.class, id);

		hrEstablishmentMaster.setId(id);

		MasUnit masUnit = new MasUnit();
		masUnit.setId(unitId);
		hrEstablishmentMaster.setUnit(masUnit);

		HrSpecialistMaster hrSpecialistMaster = new HrSpecialistMaster();
		hrSpecialistMaster.setId(specialityId);
		hrEstablishmentMaster.setSpeciality(hrSpecialistMaster);

		MasRank masRank = new MasRank();
		masRank.setId(rankId);
		hrEstablishmentMaster.setRank(masRank);

		hrEstablishmentMaster.setStrength(strength);

		hrEstablishmentMaster.setLastChgBy(changedBy);
		hrEstablishmentMaster.setLastChgDate(currentDate);
		hrEstablishmentMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrEstablishmentMaster);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchEstablishment(String unitName,
			String specialityName) {
		List<HrEstablishmentMaster> searchEstablishmentList = new ArrayList<HrEstablishmentMaster>();
		Map<String, Object> dutyFieldsMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			if ((unitName != null) && !unitName.equals("")) {
				// searchEstablishmentList=getHibernateTemplate().find("from jkt.hms.masters.business.HrEstablishmentMaster as i where i.DutyCode like '"+
				// code+"%' order by i.DutyCode");
				searchEstablishmentList = session.createCriteria(
						HrEstablishmentMaster.class).createAlias("Unit", "u")
						.add(Restrictions.ilike("u.UnitName", unitName)).list();
			} else if (specialityName != null && !specialityName.equals("")) {
				searchEstablishmentList = session.createCriteria(
						HrEstablishmentMaster.class).createAlias("Speciality",
						"s").add(
						Restrictions.ilike("s.SpecialistName", specialityName))
						.list();
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchEstablishmentList  " + e);
		}
		dutyFieldsMap.put("searchEstablishmentList", searchEstablishmentList);
		return dutyFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showEstablishmentJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrEstablishmentMaster> searchEstablishmentList = new ArrayList<HrEstablishmentMaster>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<HrSpecialistMaster> specialityList = new ArrayList<HrSpecialistMaster>();
		List<MasRank> rankCodeForMWO = new ArrayList<MasRank>();

		searchEstablishmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrEstablishmentMaster ");
		unitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).list();
		rankCodeForMWO = session.createCriteria(MasRank.class).add(
				Restrictions.eq("RankName", "MWO")).list();
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions
						.ge("RankCode", rankCodeForMWO.get(0).getRankCode()))
				.createAlias("ServiceType", "mst").add(
						Restrictions.eq("mst.ServiceTypeName", "Air Force"))
				.list();
		specialityList = session.createCriteria(HrSpecialistMaster.class).add(
				Restrictions.eq("Status", "y")).list();

		map.put("searchEstablishmentList", searchEstablishmentList);
		map.put("unitList", unitList);
		map.put("rankList", rankList);
		map.put("specialityList", specialityList);

		return map;
	}

	/**
	 * ------- Class Master Added by Priyanka started on 8th July 2009
	 */
	public boolean addClass(HrClassMaster hrClassMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrClassMaster);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteClass(int id, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		HrClassMaster hrClassMaster = new HrClassMaster();
		hrClassMaster = (HrClassMaster) getHibernateTemplate().get(
				HrClassMaster.class, id);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrClassMaster.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrClassMaster.setStatus("y");
				dataDeleted = false;
			}
		}
		hrClassMaster.setLastChgBy(changedBy);
		hrClassMaster.setLastChgDate(currentDate);
		hrClassMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrClassMaster);
		return dataDeleted;
	}

	public boolean editClassToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String name = "";
		@SuppressWarnings("unused")
		String code = "";
		int id = 0;
		String changedBy = "";
		id = (Integer) generalMap.get("id");
		code = (String) generalMap.get("code");
		name = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		HrClassMaster hrClassMaster = (HrClassMaster) getHibernateTemplate()
				.get(HrClassMaster.class, id);

		hrClassMaster.setId(id);
		hrClassMaster.setClassName(name);
		hrClassMaster.setLastChgBy(changedBy);
		hrClassMaster.setLastChgDate(currentDate);
		hrClassMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrClassMaster);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchClass(String code, String name) {
		List<HrClassMaster> searchClassList = new ArrayList<HrClassMaster>();
		Map<String, Object> specialityFieldsMap = new HashMap<String, Object>();
		List gridCurrencyList = null;
		try {
			if ((name != null) || (code == null)) {
				searchClassList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HrClassMaster as i where i.ClassName like '"
								+ name + "%' order by i.ClassName");
			} else {
				searchClassList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HrClassMaster as i where i.ClassCode like '"
								+ code + "%' order by i.ClassCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchClassList  " + e);
		}
		specialityFieldsMap.put("searchClassList", searchClassList);
		return specialityFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showClassJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrClassMaster> searchClassList = new ArrayList<HrClassMaster>();
		List<HrSpecialistMaster> searchSpecialistList = new ArrayList<HrSpecialistMaster>();
		searchSpecialistList = session.createCriteria(HrSpecialistMaster.class)
				.add(Restrictions.eq("Status", "y")).list();
		searchClassList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrClassMaster ");
		map.put("searchClassList", searchClassList);
		map.put("searchSpecialistList", searchSpecialistList);

		return map;
	}

	/**
	 * ------- Duty Master Added by Priyanka started on 9th July 2009
	 */
	public boolean addDuty(HrDutyMaster hrDutyMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(hrDutyMaster);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteDuty(int id, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		HrDutyMaster hrDutyMaster = new HrDutyMaster();
		hrDutyMaster = (HrDutyMaster) getHibernateTemplate().get(
				HrDutyMaster.class, id);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrDutyMaster.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrDutyMaster.setStatus("y");
				dataDeleted = false;
			}
		}
		hrDutyMaster.setLastChgBy(changedBy);
		hrDutyMaster.setLastChgDate(currentDate);
		hrDutyMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrDutyMaster);
		return dataDeleted;
	}

	public boolean editDutyToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String name = "";
		@SuppressWarnings("unused")
		String code = "";
		int id = 0;
		String changedBy = "";
		id = (Integer) generalMap.get("id");
		code = (String) generalMap.get("code");
		name = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		HrDutyMaster hrDutyMaster = (HrDutyMaster) getHibernateTemplate().get(
				HrDutyMaster.class, id);

		hrDutyMaster.setId(id);
		hrDutyMaster.setDutyName(name);
		hrDutyMaster.setLastChgBy(changedBy);
		hrDutyMaster.setLastChgDate(currentDate);
		hrDutyMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(hrDutyMaster);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDuty(String code, String name) {
		List<HrDutyMaster> searchDutyList = new ArrayList<HrDutyMaster>();
		Map<String, Object> specialityFieldsMap = new HashMap<String, Object>();
		List gridCurrencyList = null;
		try {
			if ((name != null) || (code == null)) {
				searchDutyList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HrDutyMaster as i where i.DutyName like '"
								+ name + "%' order by i.DutyName");
			} else {
				searchDutyList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HrDutyMaster as i where i.DutyCode like '"
								+ code + "%' order by i.DutyCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchDutyList  " + e);
		}
		specialityFieldsMap.put("searchDutyList", searchDutyList);
		return specialityFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDutyJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrDutyMaster> searchDutyList = new ArrayList<HrDutyMaster>();
		searchDutyList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HrDutyMaster ");
		map.put("searchDutyList", searchDutyList);
		return map;
	}

}
