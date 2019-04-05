package jkt.hms.masters.dataservice;

import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import jkt.hms.masters.business.DiagParam;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasCaseType;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasChargeType;
import jkt.hms.masters.business.MasComplaint;
import jkt.hms.masters.business.MasComplication;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasDeathCause;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDepartmentType;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasIcdMainCategory;
import jkt.hms.masters.business.MasIcdSubCategory;
import jkt.hms.masters.business.MasIcdcausegrp;
import jkt.hms.masters.business.MasImpanneledHospital;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasMajorCategoryCode;
import jkt.hms.masters.business.MasOt;
import jkt.hms.masters.business.MasPatientStatus;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasRoom;
import jkt.hms.masters.business.MasRoomType;
import jkt.hms.masters.business.MasSample;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasSubTest;
import jkt.hms.masters.business.MasUnitOfMeasurement;
import jkt.hms.masters.business.OtBed;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HospitalDetailsMasterDataServiceImpl extends HibernateDaoSupport
		implements HospitalDetailsMasterDataService {

	// -----------------------------------Case Type--------------------- -------
	public boolean addCaseType(MasCaseType masCaseType) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCaseType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteCaseType(int caseTypeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasCaseType masCaseType = new MasCaseType();
		masCaseType = (MasCaseType) getHibernateTemplate().get(
				MasCaseType.class, caseTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCaseType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCaseType.setStatus("y");
				dataDeleted = false;
			}
		}
		masCaseType.setLastChgBy(changedBy);
		masCaseType.setLastChgDate(currentDate);
		masCaseType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCaseType);
		return dataDeleted;
	}

	public boolean editCaseTypeToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String caseTypeName = "";
		@SuppressWarnings("unused")
		String caseTypeCode = "";
		int caseTypeId = 0;
		String changedBy = "";
		caseTypeId = (Integer) generalMap.get("id");
		caseTypeCode = (String) generalMap.get("caseTypeCode");
		caseTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasCaseType masCaseType = (MasCaseType) getHibernateTemplate().get(
				MasCaseType.class, caseTypeId);

		masCaseType.setId(caseTypeId);
		masCaseType.setCaseTypeName(caseTypeName);
		masCaseType.setLastChgBy(changedBy);
		masCaseType.setLastChgDate(currentDate);
		masCaseType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCaseType);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> showCaseTypeJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCaseType> searchCaseTypeList = new ArrayList<MasCaseType>();
		searchCaseTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCaseType ");
		map.put("searchCaseTypeList", searchCaseTypeList);
		return map;
	}

	public Map<String, Object> searchCaseType(String caseTypeCode,
			String caseTypeName) {
		List<MasCaseType> searchCaseTypeList = new ArrayList<MasCaseType>();
		Map<String, Object> caseTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((caseTypeName != null) || (caseTypeCode == null)) {
				searchCaseTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasCaseType imc where imc.CaseTypeName like '"
										+ caseTypeName
										+ "%' order by imc.CaseTypeName");
			} else {
				searchCaseTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasCaseType imc where imc.CaseTypeCode like '"
										+ caseTypeCode
										+ "%' order by imc.CaseTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		caseTypeFieldsMap.put("searchCaseTypeList", searchCaseTypeList);
		return caseTypeFieldsMap;
	}

	// -----------------------------Main Charge Code
	// -------------------------------------

	public boolean addMainChargecode(MasMainChargecode masMainChargecode) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masMainChargecode);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteMainChargecode(int mainChargecodeId,
			Map<String, Object> generalMap) {
		Date currentDate = new Date();
		boolean dataDeleted = false;
		String changedBy = "";

		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode = (MasMainChargecode) getHibernateTemplate().get(
				MasMainChargecode.class, mainChargecodeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masMainChargecode.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masMainChargecode.setStatus("y");
				dataDeleted = false;
			}
		}
		masMainChargecode.setLastChgBy(changedBy);
		masMainChargecode.setLastChgDate(currentDate);
		masMainChargecode.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masMainChargecode);
		return dataDeleted;
	}

	public boolean editMainChargecodeToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String mainChargecodeName = "";
		@SuppressWarnings("unused")
		String mainChargecodeCode = "";
		String mainChargeType = "";
		int departmentId = 0;
		int mainChargecodeId = 0;
		String changedBy = "";
		departmentId = (Integer) generalMap.get("departmentId");
		mainChargecodeId = (Integer) generalMap.get("id");
		mainChargecodeCode = (String) generalMap.get("mainChargecodeCode");
		mainChargecodeName = (String) generalMap.get("name");
		mainChargeType = (String) generalMap.get("mainChargeType");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasMainChargecode masMainChargecode = (MasMainChargecode) getHibernateTemplate()
				.get(MasMainChargecode.class, mainChargecodeId);

		masMainChargecode.setId(mainChargecodeId);
		masMainChargecode.setMainChargecodeName(mainChargecodeName);
		masMainChargecode.setMainchargeType(mainChargeType);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		masMainChargecode.setDepartment(masDepartment);
		masMainChargecode.setLastChgBy(changedBy);
		masMainChargecode.setLastChgDate(currentDate);
		masMainChargecode.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masMainChargecode);
		dataUpdated = true;
		return dataUpdated;

	}

	public Map<String, Object> searchMainChargecode(String mainChargecodeCode,
			String mainChargecodeName) {

		List<MasMainChargecode> searchMainChargecodeList = new ArrayList<MasMainChargecode>();
		Map<String, Object> mainChargecodeFieldsMap = new HashMap<String, Object>();
		try {
			if ((mainChargecodeName != null) || (mainChargecodeCode == null)) {
				searchMainChargecodeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasMainChargecode imc where imc.MainChargecodeName like '"
										+ mainChargecodeName
										+ "%' order by imc.MainChargecodeName");
			} else {
				searchMainChargecodeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasMainChargecode imc where imc.MainChargecodeCode like '"
										+ mainChargecodeCode
										+ "%' order by imc.MainChargecodeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mainChargecodeFieldsMap.put("searchMainChargecodeList",
				searchMainChargecodeList);
		return mainChargecodeFieldsMap;
	}

	public Map<String, Object> showMainChargecodeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasMainChargecode> searchMainChargecodeList = new ArrayList<MasMainChargecode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();

		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as isc where isc.Status = 'y' order by isc.DepartmentName asc");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		searchMainChargecodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMainChargecode ");
		map.put("searchMainChargecodeList", searchMainChargecodeList);
		map.put("gridDepartmentList", gridDepartmentList);
		map.put("departmentList", departmentList);
		return map;
	}

	// -----------------------------Cost Center
	// --------------------------------------
	public Map<String, Object> showCostCenterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCostCenter> searchCostCenterList = new ArrayList<MasCostCenter>();
		searchCostCenterList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCostCenter ");
		map.put("searchCostCenterList", searchCostCenterList);
		return map;
	}

	public boolean addCostCenter(MasCostCenter masCostCenter) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masCostCenter);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteCostCenter(int costCenterId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasCostCenter masCostCenter = new MasCostCenter();
		masCostCenter = (MasCostCenter) getHibernateTemplate().get(
				MasCostCenter.class, costCenterId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCostCenter.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCostCenter.setStatus("y");
				dataDeleted = false;
			}
		}
		masCostCenter.setLastChgBy(changedBy);
		masCostCenter.setLastChgDate(currentDate);
		masCostCenter.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCostCenter);
		return dataDeleted;
	}

	public boolean editCostCenterToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String costCenterName = "";
		@SuppressWarnings("unused")
		String costCenterCode = "";
		int costCenterId = 0;
		String changedBy = "";
		costCenterId = (Integer) generalMap.get("id");
		costCenterCode = (String) generalMap.get("costCenterCode");
		costCenterName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasCostCenter masCostCenter = (MasCostCenter) getHibernateTemplate()
				.get(MasCostCenter.class, costCenterId);
		masCostCenter.setId(costCenterId);
		masCostCenter.setCostCenterName(costCenterName);
		masCostCenter.setLastChgBy(changedBy);
		masCostCenter.setLastChgDate(currentDate);
		masCostCenter.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCostCenter);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchCostCenter(String costCenterCode,
			String costCenterName) {
		List<MasCostCenter> searchCostCenterList = new ArrayList<MasCostCenter>();
		Map costCenterFieldsMap = new HashMap();
		try {
			if ((costCenterName != null) || (costCenterCode == null)) {
				searchCostCenterList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasCostCenter sc where sc.CostCenterName like '"
								+ costCenterName
								+ "%' order by sc.CostCenterName");
			} else {
				searchCostCenterList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasCostCenter sc where sc.CostCenterCode like '"
								+ costCenterCode
								+ "%' order by sc.CostCenterCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		costCenterFieldsMap.put("searchCostCenterList", searchCostCenterList);
		return costCenterFieldsMap;
	}

	// -----------------------------Major Category Code
	// --------------------------------------

	public Map<String, Object> showMajorCategoryCodeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasMajorCategoryCode> searchMajorCategoryCodeList = new ArrayList<MasMajorCategoryCode>();
		searchMajorCategoryCodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMajorCategoryCode ");
		map.put("searchMajorCategoryCodeList", searchMajorCategoryCodeList);
		return map;
	}

	public Map<String, Object> searchMajorCategoryCode(
			String majorCategoryCode, String majorCategoryName) {
		List<MasMajorCategoryCode> searchMajorCategoryCodeList = new ArrayList<MasMajorCategoryCode>();
		Map majorCategoryFieldsMap = new HashMap();
		try {
			if ((majorCategoryName != null) || (majorCategoryCode == null)) {
				searchMajorCategoryCodeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasMajorCategoryCode sc where sc.MajorCategoryName like '"
										+ majorCategoryName
										+ "%' order by sc.MajorCategoryName");
			} else {
				searchMajorCategoryCodeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasMajorCategoryCode sc where sc.MajorCategoryCode like '"
										+ majorCategoryCode
										+ "%' order by sc.MajorCategoryCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchMajorCategoryCode  " + e);
		}
		majorCategoryFieldsMap.put("searchMajorCategoryCodeList",
				searchMajorCategoryCodeList);
		return majorCategoryFieldsMap;
	}

	public boolean addMajorCategoryCode(
			MasMajorCategoryCode masMajorCategoryCode) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masMajorCategoryCode);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteMajorCategoryCode(int majorCategoryCodeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasMajorCategoryCode masMajorCategoryCode = new MasMajorCategoryCode();
		masMajorCategoryCode = (MasMajorCategoryCode) getHibernateTemplate()
				.get(MasMajorCategoryCode.class, majorCategoryCodeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masMajorCategoryCode.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masMajorCategoryCode.setStatus("y");
				dataDeleted = false;
			}
		}
		masMajorCategoryCode.setLastChgBy(changedBy);
		masMajorCategoryCode.setLastChgDate(currentDate);
		masMajorCategoryCode.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masMajorCategoryCode);
		return dataDeleted;
	}

	public boolean editMajorCategoryCodeToDatabase(
			Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String majorCategoryName = "";
		@SuppressWarnings("unused")
		String majorCategoryCode = "";
		int majorCategoryId = 0;
		String changedBy = "";
		majorCategoryId = (Integer) generalMap.get("id");
		majorCategoryCode = (String) generalMap.get("majorCategoryCode");
		majorCategoryName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasMajorCategoryCode masMajorCategoryCode = (MasMajorCategoryCode) getHibernateTemplate()
				.get(MasMajorCategoryCode.class, majorCategoryId);
		masMajorCategoryCode.setId(majorCategoryId);
		masMajorCategoryCode.setMajorCategoryName(majorCategoryName);
		masMajorCategoryCode.setLastChgBy(changedBy);
		masMajorCategoryCode.setLastChgDate(currentDate);
		masMajorCategoryCode.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masMajorCategoryCode);
		dataUpdated = true;
		return dataUpdated;
	}

	// ------------------------------- Death Cause
	// -------------------------------------------

	public Map<String, Object> showDeathCauseJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDeathCause> searchDeathCauseList = new ArrayList<MasDeathCause>();
		searchDeathCauseList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDeathCause ");
		map.put("searchDeathCauseList", searchDeathCauseList);
		return map;
	}

	public Map<String, Object> searchDeathCause(String deathCauseCode,
			String deathCauseName) {
		List<MasDeathCause> searchDeathCauseList = new ArrayList<MasDeathCause>();
		Map deathCauseFieldsMap = new HashMap();
		try {
			if ((deathCauseName != null) || (deathCauseCode == null)) {
				searchDeathCauseList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDeathCause sc where sc.DeathCauseName like '"
								+ deathCauseName
								+ "%' order by sc.DeathCauseName");
			} else {
				searchDeathCauseList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasDeathCause sc where sc.DeathCauseCode like '"
								+ deathCauseCode
								+ "%' order by sc.DeathCauseCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchMajorCategoryCode  " + e);
		}
		deathCauseFieldsMap.put("searchDeathCauseList", searchDeathCauseList);
		return deathCauseFieldsMap;
	}

	public boolean editDeathCauseToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String deathCauseName = "";
		@SuppressWarnings("unused")
		String deathCauseCode = "";
		int deathCauseId = 0;
		String changedBy = "";
		deathCauseId = (Integer) generalMap.get("id");
		deathCauseCode = (String) generalMap.get("deathCauseCode");
		deathCauseName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDeathCause masDeathCause = (MasDeathCause) getHibernateTemplate()
				.get(MasDeathCause.class, deathCauseId);

		masDeathCause.setId(deathCauseId);
		masDeathCause.setDeathCauseName(deathCauseName);
		masDeathCause.setLastChgBy(changedBy);
		masDeathCause.setLastChgDate(currentDate);
		masDeathCause.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDeathCause);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean addDeathCause(MasDeathCause masDeathCause) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDeathCause);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteDeathCause(int deathCauseId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDeathCause masDeathCause = new MasDeathCause();
		masDeathCause = (MasDeathCause) getHibernateTemplate().get(
				MasDeathCause.class, deathCauseId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDeathCause.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDeathCause.setStatus("y");
				dataDeleted = false;
			}
		}
		masDeathCause.setLastChgBy(changedBy);
		masDeathCause.setLastChgDate(currentDate);
		masDeathCause.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDeathCause);
		return dataDeleted;
	}

	// ------------------------------------Patient
	// Status------------------------------------------
	public Map<String, Object> showPatientStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPatientStatus> searchPatientStatusList = new ArrayList<MasPatientStatus>();
		searchPatientStatusList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPatientStatus ");
		map.put("searchPatientStatusList", searchPatientStatusList);
		return map;
	}

	public Map<String, Object> searchPatientStatus(String patientStatusCode,
			String patientStatusName) {
		List<MasPatientStatus> searchPatientStatusList = new ArrayList<MasPatientStatus>();
		Map patientStatusFieldsMap = new HashMap();
		try {
			if ((patientStatusName != null) || (patientStatusCode == null)) {
				searchPatientStatusList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasPatientStatus mbg where mbg.PatientStatusName like '"
										+ patientStatusName
										+ "%' order by mbg.PatientStatusName");
			} else {
				searchPatientStatusList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasPatientStatus mbg where mbg.PatientStatusCode like '"
										+ patientStatusCode
										+ "%' order by mbg.PatientStatusCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchPatientStatus  " + e);
		}
		patientStatusFieldsMap.put("searchPatientStatusList",
				searchPatientStatusList);
		return patientStatusFieldsMap;
	}

	public boolean addPatientStatus(MasPatientStatus masPatientStatus) {
		boolean dataSaved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masPatientStatus);
		dataSaved = true;
		return dataSaved;
	}

	@SuppressWarnings("unchecked")
	public boolean deletePatientStatus(int patientStatusId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasPatientStatus masPatientStatus = new MasPatientStatus();
		masPatientStatus = (MasPatientStatus) getHibernateTemplate().get(
				MasPatientStatus.class, patientStatusId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masPatientStatus.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masPatientStatus.setStatus("y");
				dataDeleted = false;
			}
		}
		masPatientStatus.setLastChgBy(changedBy);
		masPatientStatus.setLastChgDate(currentDate);
		masPatientStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masPatientStatus);
		return dataDeleted;
	}

	public boolean editPatientStatusToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String patientStatusName = "";
		@SuppressWarnings("unused")
		String patientStatusCode = "";
		int patientStatusId = 0;
		String changedBy = "";
		patientStatusId = (Integer) generalMap.get("id");
		patientStatusCode = (String) generalMap.get("patientStatusCode");
		patientStatusName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasPatientStatus masPatientStatus = (MasPatientStatus) getHibernateTemplate()
				.get(MasPatientStatus.class, patientStatusId);
		masPatientStatus.setId(patientStatusId);
		masPatientStatus.setPatientStatusName(patientStatusName);
		masPatientStatus.setLastChgBy(changedBy);
		masPatientStatus.setLastChgDate(currentDate);
		masPatientStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masPatientStatus);
		dataUpdated = true;
		return dataUpdated;
	}

	// -------------------------------- Bed
	// Master-----------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showBedJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasRoom> roomList = new ArrayList<MasRoom>();
		List<MasBedStatus> bedStatusList = new ArrayList<MasBedStatus>();
		List<MasBed> searchBedList = new ArrayList<MasBed>();
		Session session=(Session)getSession();
/*		hospitalList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasHospital as md where md.Status = 'y' order by md.HospitalName asc");
*/		hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).list();
		/*departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y' order by md.DepartmentName asc");*/
		
		/*roomList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRoom as mr where mr.Status = 'y' order by mr.RoomCode asc");
		*/
		roomList =session.createCriteria(MasRoom.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RoomCode")).list();
		/*bedStatusList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasBedStatus as mbs where mbs.Status = 'y' order by mbs.BedStatusName asc");*/
		
		bedStatusList=session.createCriteria(MasBedStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BedStatusName")).list();
		
		/*searchBedList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasBed as mb where mb.Hospital.Id="+hospitalId+"  order by mb.BedNo");
		*/
		searchBedList=session.createCriteria(MasBed.class).add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("BedNo")).list();
		
		
		List<MasDepartment> searchDepartmentList = new ArrayList<MasDepartment>();
		
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		 String departmentTypeCodeForOT = properties.getProperty("departmentTypeCodeForOT");
		 String departmentTypeCodeForWard = properties.getProperty("departmentTypeCodeForWard");
			List<String> arrayDeptCode = new ArrayList<String>();
			arrayDeptCode.add(departmentTypeCodeForWard);
			arrayDeptCode.add(departmentTypeCodeForOT);
			
			
		
	
		try {
			departmentList =session.createCriteria(MasDepartment.class)
					.createAlias("DepartmentType", "dt").add(Restrictions.in("dt.DepartmentTypeCode", arrayDeptCode))	
					.add(Restrictions.eq("Status", "y")).list(); 
					//session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DepartmentName")).list();
			
			searchDepartmentList = session.createCriteria(MasDepartment.class)
					.createAlias("DepartmentType", "dt").add(Restrictions.in("dt.DepartmentTypeCode", arrayDeptCode))	
					.add(Restrictions.eq("Status", "y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchDepartmentList", searchDepartmentList);
		
		map.put("departmentList", departmentList);
		map.put("roomList", roomList);
		map.put("bedStatusList", bedStatusList);
		map.put("searchBedList", searchBedList);
		map.put("hospitalList", hospitalList);
		return map;
	}

	public Map<String, Object> searchBed(int depId,int hospitalId) {
		List<MasBed> searchBedList = new ArrayList<MasBed>();
		Map<String, Object> bedFieldsMap = new HashMap<String, Object>();
		List departmentList = new ArrayList();
		List roomList = new ArrayList();
		List bedStatusList = new ArrayList();
		Session session=(Session)getSession();
		try {
			if ((depId != 0)) {
				searchBedList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasBed as  mb where mb.Department.Id ="
								+ depId + " and mb.Hospital.Id="+hospitalId+" order by mb.BedNo");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchBedList  " + e);
		}
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y' order by DepartmentName");
		roomList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRoom as mr where mr.Status = 'y' order by RoomCode");
		bedStatusList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasBedStatus as mbs where mbs.Status = 'y' order by BedStatusName");
		

		
		List<MasDepartment> searchDepartmentList = new ArrayList<MasDepartment>();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");
		String departmentTypeCodeForWard="";
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		departmentTypeCodeForWard =properties.getProperty("departmentTypeCodeForWard");
		try {
			searchDepartmentList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasDepartment as ms where ms.DepartmentType.DepartmentTypeCode='"+departmentTypeCodeForWard+"' order by ms.DepartmentName");
		} catch (Exception e) {
			e.printStackTrace();
		}
		bedFieldsMap.put("searchDepartmentList", searchDepartmentList);
		bedFieldsMap.put("searchBedList", searchBedList);
		bedFieldsMap.put("departmentList", departmentList);
		bedFieldsMap.put("roomList", roomList);
		bedFieldsMap.put("bedStatusList", bedStatusList);
		return bedFieldsMap;
	}

	public boolean addBed(MasBed masBed) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masBed);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteBed(int bedId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasBed masBed = new MasBed();
		masBed = (MasBed) getHibernateTemplate().get(MasBed.class, bedId);
			int userId=0; 
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
	
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masBed.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masBed.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users=new Users();
		users.setId(userId);
		masBed.setLastChgBy(users);
		
		
		masBed.setLastChgDate(currentDate);
		masBed.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masBed);
		return dataDeleted;
	}

	public boolean editBedToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String bedNumber = "";
		int bedId = 0;
		int roomId = 0;
		int bedStatusId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		String adNo = "";
		String dietType = "";
		String attached = "";
		String changedBy = "";
		String currentTime = "";
		Date changedDate = new Date();
		bedId = (Integer) generalMap.get("id");
		bedNumber = (String) generalMap.get("bedNumber");
		departmentId = (Integer) generalMap.get("departmentId");
		roomId = (Integer) generalMap.get("roomId");
		bedStatusId = (Integer) generalMap.get("bedStatusId");
		adNo = (String) generalMap.get("adNo");
		dietType = (String) generalMap.get("dietType");
		attached = (String) generalMap.get("attached");
		int userId=0; 
		userId = (Integer) generalMap.get("userId");
		changedDate = (Date) generalMap.get("changedDate");
		currentTime = (String) generalMap.get("currentTime");
		hospitalId = (Integer) generalMap.get("hospitalId");

		MasBed masBed = (MasBed) getHibernateTemplate()
				.get(MasBed.class, bedId);

		masBed.setId(bedId);
		masBed.setBedNo(bedNumber);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		masBed.setDepartment(masDepartment);

		MasBedStatus masBedStatus = new MasBedStatus();
		masBedStatus.setId(bedStatusId);
		masBed.setBedStatus(masBedStatus);
if(roomId!=0){
		MasRoom masRoom = new MasRoom();
		masRoom.setId(roomId);
		masBed.setRoom(masRoom);
}
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		masBed.setHospital(hospital);

		masBed.setDietType(dietType);
		masBed.setAdNo(adNo);
		masBed.setAttached(attached);

		masBed.setStatus("y");
		Users users=new Users();
		users.setId(userId);
		masBed.setLastChgBy(users);
		
		masBed.setLastChgDate(changedDate);
		masBed.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masBed);
			dataUpdated = true;
		} catch (Exception e) {
			//System.out.println("eeeeeeee  " + e);
		}
		return dataUpdated;
	}

	// ----------------------------------COMPLAINT--------------
	public Map<String, Object> showComplaintJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasComplaint> searchComplaintList = new ArrayList<MasComplaint>();
		searchComplaintList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplaint ");
		map.put("searchComplaintList", searchComplaintList);
		return map;
	}

	public Map<String, Object> searchComplaint(String complaintCode,
			String complaintName) {

		List<MasComplaint> searchComplaintList = new ArrayList<MasComplaint>();
		Map<String, Object> complaintFieldsMap = new HashMap<String, Object>();
		try {
			if ((complaintName != null) || (complaintCode == null)) {
				searchComplaintList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasComplaint imc where imc.ComplaintName like '"
								+ complaintName
								+ "%' order by imc.ComplaintName");
			} else {
				searchComplaintList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasComplaint imc where imc.ComplaintCode like '"
								+ complaintCode
								+ "%' order by imc.ComplaintCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchComplaintList  " + e);
		}
		complaintFieldsMap.put("searchComplaintList", searchComplaintList);
		return complaintFieldsMap;
	}

	public boolean addComplaint(MasComplaint masComplaint) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masComplaint);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editComplaintToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String complaintName = "";
		@SuppressWarnings("unused")
		String complaintCode = "";
		int complaintId = 0;
		String changedBy = "";
		complaintId = (Integer) generalMap.get("id");
		complaintCode = (String) generalMap.get("complaintCode");
		complaintName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasComplaint masComplaint = (MasComplaint) getHibernateTemplate().get(
				MasComplaint.class, complaintId);
		masComplaint.setId(complaintId);
		masComplaint.setComplaintName(complaintName);
		masComplaint.setLastChgBy(changedBy);
		masComplaint.setLastChgDate(currentDate);
		masComplaint.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masComplaint);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteComplaint(int complaintId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasComplaint masComplaint = new MasComplaint();
		masComplaint = (MasComplaint) getHibernateTemplate().get(
				MasComplaint.class, complaintId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masComplaint.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masComplaint.setStatus("y");
				dataDeleted = false;
			}
		}
		masComplaint.setLastChgBy(changedBy);
		masComplaint.setLastChgDate(currentDate);
		masComplaint.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masComplaint);
		return dataDeleted;
	}

	// -----------------------------------------Main Charge
	// Code-------------------------------------
	public boolean addMainChargecode(Map<String, Object> mainChargecodeMap) {
		boolean saveFlag = false;
		Date finalCurrentDate = new Date();
		String mainChargecodeCode = (String) mainChargecodeMap
				.get("mainChargecodeCode");
		String mainChargecodeName = (String) mainChargecodeMap
				.get("mainChargecodeName");
		String status = (String) mainChargecodeMap.get("status");
		String changedBy = (String) mainChargecodeMap.get("changedBy");
		String currentDate = (String) mainChargecodeMap.get("currentDate");
		String currentTime = (String) mainChargecodeMap.get("currentTime");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			finalCurrentDate = sdf.parse(currentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setMainChargecodeCode(mainChargecodeCode);
		masMainChargecode.setMainChargecodeName(mainChargecodeName);
		masMainChargecode.setStatus(status);
		masMainChargecode.setLastChgBy(changedBy);
		masMainChargecode.setLastChgDate(finalCurrentDate);
		masMainChargecode.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masMainChargecode);
		saveFlag = true;
		return saveFlag;
	}

	@SuppressWarnings("unchecked")
	public List getMainChargecodeListByName(
			Map<String, Object> mainChargecodeEnquiryMap) {
		List listByMainChargecodeName = new ArrayList();
		String mainChargecodeName = (String) mainChargecodeEnquiryMap
				.get("mainChargecodeName");
		listByMainChargecodeName = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMainChargecode  as mcm order by ctm.MainChargecodeName "
								+ "where mcm.Status = 'y' and mcm.MainChargecodeName like '"
								+ mainChargecodeName + "%'");
		return listByMainChargecodeName;
	}

	// --------------------------------------------------COMPLICATION-----------------------------

	public boolean addComplication(MasComplication masComplication) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masComplication);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editComplicationToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String complicationName = "";
		@SuppressWarnings("unused")
		String complicationCode = "";
		int complicationId = 0;
		String changedBy = "";
		complicationId = (Integer) generalMap.get("id");
		complicationCode = (String) generalMap.get("complicationCode");
		complicationName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasComplication masComplication = (MasComplication) getHibernateTemplate()
				.get(MasComplication.class, complicationId);

		masComplication.setId(complicationId);
		masComplication.setComplicationName(complicationName);
		masComplication.setLastChgBy(changedBy);
		masComplication.setLastChgDate(currentDate);
		masComplication.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masComplication);
		dataUpdated = true;
		return dataUpdated;

	}

	public Map<String, Object> searchComplication(String complicationCode,
			String complicationName) {
		List<MasComplication> searchComplicationList = new ArrayList<MasComplication>();
		Map<String, Object> complicationFieldsMap = new HashMap<String, Object>();
		try {
			if ((complicationName != null) || (complicationCode == null)) {
				searchComplicationList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasComplication imc where imc.ComplicationName like '"
										+ complicationName
										+ "%' order by imc.ComplicationName");
			} else {
				searchComplicationList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasComplication imc where imc.ComplicationCode like '"
										+ complicationCode
										+ "%' order by imc.ComplicationCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		complicationFieldsMap.put("searchComplicationList",
				searchComplicationList);
		return complicationFieldsMap;
	}

	public Map<String, Object> showComplicationJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasComplication> searchComplicationList = new ArrayList<MasComplication>();
		searchComplicationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasComplication ");
		map.put("searchComplicationList", searchComplicationList);
		return map;

	}

	public boolean deleteComplication(int complicationId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasComplication masComplication = new MasComplication();
		masComplication = (MasComplication) getHibernateTemplate().get(
				MasComplication.class, complicationId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masComplication.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masComplication.setStatus("y");
				dataDeleted = false;
			}
		}
		masComplication.setLastChgBy(changedBy);
		masComplication.setLastChgDate(currentDate);
		masComplication.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masComplication);

		return dataDeleted;
	}

	// ------------------------------- Authoraizer
	// -------------------------------

	public boolean addAuthorizer(MasAuthorizer masAuthorizer) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masAuthorizer);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editAuthorizerToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String authorizerName = "";
		@SuppressWarnings("unused")
		String authorizerCode = "";
		int authorizerId = 0;
		String changedBy = "";
		authorizerId = (Integer) generalMap.get("id");
		authorizerCode = (String) generalMap.get("authorizerCode");
		authorizerName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasAuthorizer masAuthorizer = (MasAuthorizer) getHibernateTemplate()
				.get(MasAuthorizer.class, authorizerId);

		masAuthorizer.setId(authorizerId);
		masAuthorizer.setAuthorizerName(authorizerName);
		masAuthorizer.setLastChgBy(changedBy);
		masAuthorizer.setLastChgDate(currentDate);
		masAuthorizer.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masAuthorizer);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> searchAuthorizer(String authorizerCode,
			String authorizerName) {

		List<MasAuthorizer> searchAuthorizerList = new ArrayList<MasAuthorizer>();
		Map<String, Object> authorizerFieldsMap = new HashMap<String, Object>();
		try {
			if ((authorizerName != null) || (authorizerCode == null)) {
				searchAuthorizerList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasAuthorizer imc where imc.AuthorizerName like '"
										+ authorizerName
										+ "%' order by imc.AuthorizerName");
			} else {
				searchAuthorizerList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasAuthorizer imc where imc.AuthorizerCode like '"
										+ authorizerCode
										+ "%' order by imc.AuthorizerCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		authorizerFieldsMap.put("searchAuthorizerList", searchAuthorizerList);
		return authorizerFieldsMap;
	}

	public Map<String, Object> showAuthorizerJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAuthorizer> searchAuthorizerList = new ArrayList<MasAuthorizer>();
		searchAuthorizerList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasAuthorizer ");
		map.put("searchAuthorizerList", searchAuthorizerList);
		return map;
	}

	public boolean deleteAuthorizer(int authorizerId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasAuthorizer masAuthorizer = new MasAuthorizer();
		masAuthorizer = (MasAuthorizer) getHibernateTemplate().get(
				MasAuthorizer.class, authorizerId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masAuthorizer.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masAuthorizer.setStatus("y");
				dataDeleted = false;
			}
		}
		masAuthorizer.setLastChgBy(changedBy);
		masAuthorizer.setLastChgDate(currentDate);
		masAuthorizer.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masAuthorizer);
		return dataDeleted;
	}

	// --------------------------------Department ---------------------

	@SuppressWarnings("unchecked")
	public List<MasDepartmentType> getDepartmentTypeList() {
		List<MasDepartmentType> departmentTypeList = new ArrayList<MasDepartmentType>();
		departmentTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartmentType as dtm where dtm.Status = 'y'");
		return departmentTypeList;
	}

	@SuppressWarnings("unchecked")
	public List<MasCostCenter> getCostCenterList() {
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		costCenterList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasCostCenter as dtm where dtm.Status = 'y'");
		return costCenterList;
	}

	public boolean addDepartment(MasDepartment masDepartment) {
		boolean dataSaved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDepartment);
		dataSaved = true;
		return dataSaved;
	}

	public boolean updateDepartment(Map<String, Object> generalMap) {
		boolean dataFixed = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int departmentId = 0;
		String departmentName = "";
		int departmentTypeId = 0;
		int costCenterId = 0;
		String status = "";
		String changedBy = "";
		departmentId = (Integer) generalMap.get("id");
		departmentName = (String) generalMap.get("name");
		departmentTypeId = (Integer) generalMap.get("departmentTypeId");
		costCenterId = (Integer) generalMap.get("costCenterId");
		status = (String) generalMap.get("status");
		changedBy = (String) generalMap.get("userName");

		MasDepartment masDepartment = (MasDepartment) getHibernateTemplate()
				.get(MasDepartment.class, departmentId);

		masDepartment.setDepartmentName(departmentName);

		MasDepartmentType masDepartmentType = new MasDepartmentType();
		masDepartmentType.setId(departmentTypeId);
		masDepartment.setDepartmentType(masDepartmentType);

		MasCostCenter masCostCenter = new MasCostCenter();
		masCostCenter.setId(costCenterId);
		masDepartment.setCostCenter(masCostCenter);

		masDepartment.setStatus(status);
		masDepartment.setLastChgBy(changedBy);
		masDepartment.setLastChgDate(currentDate);
		masDepartment.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDepartment);
		dataFixed = true;

		return dataFixed;
	}

	public boolean deleteDepartment(int departmentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDepartment masDepartment = new MasDepartment();
		masDepartment = (MasDepartment) getHibernateTemplate().get(
				MasDepartment.class, departmentId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDepartment.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDepartment.setStatus("y");
				dataDeleted = false;
			}
		}
		masDepartment.setLastChgBy(changedBy);
		masDepartment.setLastChgDate(currentDate);
		masDepartment.setLastChgTime(currentTime);
		masDepartment.setLastChgBy(changedBy);
		masDepartment.setLastChgDate(currentDate);
		masDepartment.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDepartment);
		return dataDeleted;
	}

	// ---------------------------- Room ---------------------------

	public boolean addRoom(MasRoom masRoom) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masRoom);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editRoomToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int roomTypeId = 0;
		int departmentId = 0;
		@SuppressWarnings("unused")
		String roomCode = "";
		int roomId = 0;
		String changedBy = "";
		roomId = (Integer) generalMap.get("id");
		roomCode = (String) generalMap.get("roomCode");
		roomTypeId = (Integer) generalMap.get("roomTypeId");
		departmentId = (Integer) generalMap.get("departmentId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasRoom masRoom = (MasRoom) getHibernateTemplate().get(MasRoom.class,
				roomId);
		masRoom.setId(roomId);

		MasRoomType masRoomType = new MasRoomType();
		masRoomType.setId(roomTypeId);
		masRoom.setRoomType(masRoomType);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		masRoom.setDepartment(masDepartment);

		masRoom.setLastChgBy(changedBy);
		masRoom.setLastChgDate(currentDate);
		masRoom.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRoom);
		dataUpdated = true;
		return dataUpdated;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchRoom(String roomCode) {
		List<MasRoom> searchRoomList = new ArrayList<MasRoom>();
		List roomTypeList = null;
		List departmentList = null;
		Map<String, Object> roomFieldsMap = new HashMap<String, Object>();
		List gridRoomTypeList = null;
		List gridDepartmentList = null;
		try {
			if (roomCode != null) {
				searchRoomList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasRoom as i where i.RoomCode like '"
								+ roomCode + "%' order by i.RoomCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchRoomList  " + e);
		}
		roomTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRoomType as isc where isc.Status = 'y'");
		gridRoomTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRoomType as isc");

		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as isc where isc.Status = 'y'");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment as isc");

		roomFieldsMap.put("gridRoomTypeList", gridRoomTypeList);
		roomFieldsMap.put("gridDepartmentList", gridDepartmentList);
		roomFieldsMap.put("searchRoomList", searchRoomList);
		roomFieldsMap.put("roomTypeList", roomTypeList);
		roomFieldsMap.put("departmentList", departmentList);
		return roomFieldsMap;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showRoomJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRoom> searchRoomList = new ArrayList<MasRoom>();
		List<MasRoomType> roomTypeList = new ArrayList<MasRoomType>();
		List<MasRoomType> gridRoomTypeList = new ArrayList<MasRoomType>();

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();
		Session session=(Session)getSession();
	/*	searchRoomList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRoom ");*/
		searchRoomList=session.createCriteria(MasRoom.class).list();
		
		
		/*gridRoomTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRoomType as isc");
		*/
		gridRoomTypeList=session.createCriteria(MasRoomType.class).list();
/*		roomTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasRoomType as isc where isc.Status = 'y' order by isc.RoomTypeName asc");

		
*/		roomTypeList=session.createCriteria(MasRoomType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RoomTypeName")).list();
/*		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment as isc");
		
*/		
		gridDepartmentList=session.createCriteria(MasDepartment.class).list();
/*		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as isc where isc.Status = 'y' order by isc.DepartmentName asc");
*/		
		departmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DepartmentName")).list();
		map.put("searchRoomList", searchRoomList);
		map.put("roomTypeList", roomTypeList);
		map.put("gridRoomTypeList", gridRoomTypeList);
		map.put("departmentList", departmentList);
		map.put("gridDepartmentList", gridDepartmentList);
		return map;
	}

	public boolean deleteRoom(int roomId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasRoom masRoom = new MasRoom();
		masRoom = (MasRoom) getHibernateTemplate().get(MasRoom.class, roomId);
		@SuppressWarnings("unused")
		Integer roomTypeId = masRoom.getRoomType().getId();
		Integer departmentId = masRoom.getDepartment().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			@SuppressWarnings("unused")
			List roomTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasRoomType as isc where isc.Id='"
							+ roomId + "' and isc.Status='y'");
			List departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment as isc where isc.Id='"
							+ roomId + "' and isc.Status='y'");

			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masRoom.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masRoom.setStatus("y");
				dataDeleted = false;
			}
		}
		masRoom.setLastChgBy(changedBy);
		masRoom.setLastChgDate(currentDate);
		masRoom.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masRoom);
		return dataDeleted;
	}

	// -----------------------ICD Sub Category
	// -----------------------------------
	public boolean addIcdSubCategory(MasIcdSubCategory masIcdSubCategory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masIcdSubCategory);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteIcdSubCategory(int icdSubCategoryId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasIcdSubCategory masIcdSubCategory = new MasIcdSubCategory();
		masIcdSubCategory = (MasIcdSubCategory) getHibernateTemplate().get(
				MasIcdSubCategory.class, icdSubCategoryId);
		@SuppressWarnings("unused")
		Integer icdMainCategoryId = masIcdSubCategory.getIcdMaincategory()
				.getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			List icdMainCategoryList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasIcdMainCategory as isc where isc.Id='"
							+ icdSubCategoryId + "' and isc.Status='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masIcdSubCategory.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masIcdSubCategory.setStatus("y");
				dataDeleted = false;
			}
		}
		masIcdSubCategory.setLastChgBy(changedBy);
		masIcdSubCategory.setLastChgDate(currentDate);
		masIcdSubCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masIcdSubCategory);
		return dataDeleted;
	}

	public boolean editIcdSubCategoryToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int icdMainCategoryId = 0;
		String icdSubCategoryName = "";
		@SuppressWarnings("unused")
		String icdSubCategoryCode = "";
		int icdSubCategoryId = 0;
		String changedBy = "";
		icdSubCategoryId = (Integer) generalMap.get("id");
		icdSubCategoryCode = (String) generalMap.get("icdSubCategoryCode");
		icdSubCategoryName = (String) generalMap.get("name");
		icdMainCategoryId = (Integer) generalMap.get("icdMainCategoryId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasIcdSubCategory masIcdSubCategory = (MasIcdSubCategory) getHibernateTemplate()
				.get(MasIcdSubCategory.class, icdSubCategoryId);

		masIcdSubCategory.setId(icdSubCategoryId);
		masIcdSubCategory.setIcdSubCategoryName(icdSubCategoryName);

		MasIcdMainCategory masIcdMainCategory = new MasIcdMainCategory();
		masIcdMainCategory.setId(icdMainCategoryId);
		masIcdSubCategory.setIcdMaincategory(masIcdMainCategory);

		masIcdSubCategory.setLastChgBy(changedBy);
		masIcdSubCategory.setLastChgDate(currentDate);
		masIcdSubCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masIcdSubCategory);
		dataUpdated = true;
		return dataUpdated;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchIcdSubCategory(String icdSubCategoryCode,
			String icdSubCategoryName) {
		List<MasIcdSubCategory> searchIcdSubCategoryList = new ArrayList<MasIcdSubCategory>();
		List icdMainCategoryList = null;
		Map<String, Object> icdSubCategoryFieldsMap = new HashMap<String, Object>();
		List gridIcdMainCategoryList = null;
		try {
			if ((icdSubCategoryName != null) || (icdSubCategoryCode == null)) {
				searchIcdSubCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasIcdSubCategory as i where i.IcdSubCategoryName like '"
										+ icdSubCategoryName
										+ "%' order by i.IcdSubCategoryName");
			} else {
				searchIcdSubCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasIcdSubCategory as i where i.IcdSubCategoryCode like '"
										+ icdSubCategoryCode
										+ "%' order by i.IcdSubCategoryCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchIcdList  " + e);
		}

		icdMainCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasIcdMainCategory as isc where isc.Status = 'y'");
		gridIcdMainCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdMainCategory as isc");
		icdSubCategoryFieldsMap.put("gridIcdMainCategoryList",
				gridIcdMainCategoryList);
		icdSubCategoryFieldsMap.put("searchIcdSubCategoryList",
				searchIcdSubCategoryList);
		icdSubCategoryFieldsMap.put("icdMainCategoryList", icdMainCategoryList);
		return icdSubCategoryFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showIcdSubCategoryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIcdSubCategory> searchIcdSubCategoryList = new ArrayList<MasIcdSubCategory>();
		List<MasIcdMainCategory> icdMainCategoryList = new ArrayList<MasIcdMainCategory>();
		List<MasIcdMainCategory> gridIcdMainCategoryList = new ArrayList<MasIcdMainCategory>();
		searchIcdSubCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdSubCategory ");
		gridIcdMainCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdMainCategory as isc");
		icdMainCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasIcdMainCategory as isc where isc.Status = 'y' order by isc.IcdMaincategoryName asc");
		map.put("searchIcdSubCategoryList", searchIcdSubCategoryList);
		map.put("icdMainCategoryList", icdMainCategoryList);
		map.put("gridIcdMainCategoryList", gridIcdMainCategoryList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public List<MasDepartment> getDepartmentList() {
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as dm where dm.Status='y'");
		return departmentList;
	}

	// -------------------------------------Charge Code
	// Master--------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchChargeCode(String chargeCodeCode,
			String chargeCodeName) {
		List<MasChargeCode> searchChargeCodeList = new ArrayList<MasChargeCode>();
		List chargeTypeList = null;
		List departmentList = null;
		List mainChargecodeList = null;
		List subChargecodeList = null;
		List sampleList = null;
		List unitOfMeasurementList = null;
		List subTestList = null;

		List gridChargeTypeList = null;
		List gridDepartmentList = null;
		List gridMainChargecodeList = null;
		List gridSubChargecodeList = null;
		List gridUnitOfMeasurementList = null;
		List gridSampleList = null;
		List gridSubTestList = null;
		Map<String, Object> chargeCodeFieldsMap = new HashMap<String, Object>();
		try {
			if ((chargeCodeName != null) || (chargeCodeCode == null)) {
				searchChargeCodeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasChargeCode as i where i.ChargeCodeName like '"
										+ chargeCodeName
										+ "%' order by i.ChargeCodeName");
			} else {
				searchChargeCodeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasChargeCode as i where i.ChargeCodeCode like '"
										+ chargeCodeCode
										+ "%' order by i.ChargeCodeCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchChargeCodeList  " + e);
		}
		chargeTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasChargeType as isc where isc.Status = 'y'");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as isc where isc.Status = 'y'");
		subChargecodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSubChargecode as isc where isc.Status = 'y'");
		sampleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSample as isc where isc.Status = 'y'");
		mainChargecodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMainChargecode as isc where isc.Status = 'y'");
		unitOfMeasurementList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnitOfMeasurement as uomm where uomm.Status='y'");
		subTestList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSubTest as stm where stm.Status = 'y'");

		gridChargeTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeType");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		gridSubChargecodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSubChargecode ");
		gridSampleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSample ");
		gridMainChargecodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMainChargecode");
		gridUnitOfMeasurementList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnitOfMeasurement ");
		gridSubTestList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSubTest ");

		chargeCodeFieldsMap.put("gridChargeTypeList", gridChargeTypeList);
		chargeCodeFieldsMap.put("gridDepartmentList", gridDepartmentList);
		chargeCodeFieldsMap.put("gridSubChargecodeList", gridSubChargecodeList);
		chargeCodeFieldsMap.put("gridSubTestList", gridSubTestList);
		chargeCodeFieldsMap.put("gridSampleList", gridSampleList);
		chargeCodeFieldsMap.put("gridMainChargecodeList",
				gridMainChargecodeList);
		chargeCodeFieldsMap.put("gridUnitOfMeasurementList",
				gridUnitOfMeasurementList);

		chargeCodeFieldsMap.put("searchChargeCodeList", searchChargeCodeList);
		chargeCodeFieldsMap.put("subTestList", subTestList);
		chargeCodeFieldsMap.put("chargeTypeList", chargeTypeList);
		chargeCodeFieldsMap.put("subChargecodeList", subChargecodeList);
		chargeCodeFieldsMap.put("departmentList", departmentList);
		chargeCodeFieldsMap.put("mainChargecodeList", mainChargecodeList);
		chargeCodeFieldsMap.put("subChargecodeList", subChargecodeList);
		chargeCodeFieldsMap.put("sampleList", sampleList);
		chargeCodeFieldsMap.put("unitOfMeasurementList", unitOfMeasurementList);

		return chargeCodeFieldsMap;

	}

	@SuppressWarnings("unchecked")
	public List<MasUnitOfMeasurement> getUnitOfMeasurementList() {
		List<MasUnitOfMeasurement> unitOfMeasurementList = new ArrayList<MasUnitOfMeasurement>();
		unitOfMeasurementList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnitOfMeasurement as uomm where uomm.Status='y'");
		return unitOfMeasurementList;
	}

	public boolean addChargeCode(MasChargeCode masChargeCode) {
		boolean dataSaved = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masChargeCode);
			dataSaved = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSaved;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showChargeCodeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeCode> searchChargeCodeList = new ArrayList<MasChargeCode>();
		List<MasChargeType> chargeTypeList = new ArrayList<MasChargeType>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasMainChargecode> mainChargecodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<MasUnitOfMeasurement> unitOfMeasurementList = new ArrayList<MasUnitOfMeasurement>();
		List<MasSubTest> subTestList = new ArrayList<MasSubTest>();

		List<MasChargeType> gridChargeTypeList = new ArrayList<MasChargeType>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();
		List<MasMainChargecode> gridMainChargecodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> gridSubChargecodeList = new ArrayList<MasSubChargecode>();
		List<MasSample> gridSampleList = new ArrayList<MasSample>();
		List<MasUnitOfMeasurement> gridUnitOfMeasurementList = new ArrayList<MasUnitOfMeasurement>();
		List<MasSubTest> gridSubTestList = new ArrayList<MasSubTest>();

		searchChargeCodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeCode ");

		chargeTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasChargeType as isc where isc.Status = 'y' order by isc.ChargeTypeName asc");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as isc where isc.Status = 'y' order by isc.DepartmentName asc");
		subChargecodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSubChargecode as isc where isc.Status = 'y' order by isc.SubChargecodeName asc");
		sampleList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSample as isc where isc.Status = 'y' order by isc.SampleDescription asc");
		mainChargecodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMainChargecode as isc where isc.Status = 'y' order by isc.MainChargecodeName asc");
		unitOfMeasurementList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasUnitOfMeasurement as uomm where uomm.Status='y' order by uomm.UnitOfMeasurementName asc");
		subTestList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSubTest as stm where stm.Status = 'y' order by stm.SubTestName asc");

		gridChargeTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeType");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		gridSubChargecodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSubChargecode ");
		gridSampleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSample ");
		gridMainChargecodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMainChargecode");
		gridUnitOfMeasurementList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasUnitOfMeasurement ");
		gridSubTestList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSubTest ");

		map.put("gridChargeTypeList", gridChargeTypeList);
		map.put("gridDepartmentList", gridDepartmentList);
		map.put("gridSubChargecodeList", gridSubChargecodeList);
		map.put("gridSubTestList", gridSubTestList);
		map.put("gridSampleList", gridSampleList);
		map.put("gridMainChargecodeList", gridMainChargecodeList);
		map.put("gridUnitOfMeasurementList", gridUnitOfMeasurementList);
		map.put("searchChargeCodeList", searchChargeCodeList);
		map.put("subTestList", subTestList);
		map.put("chargeTypeList", chargeTypeList);
		map.put("subChargecodeList", subChargecodeList);
		map.put("departmentList", departmentList);
		map.put("mainChargecodeList", mainChargecodeList);
		map.put("subChargecodeList", subChargecodeList);
		map.put("sampleList", sampleList);
		map.put("unitOfMeasurementList", unitOfMeasurementList);

		return map;
	}

	public boolean deleteSubTest(Integer subTestId) {
		@SuppressWarnings("unused")
		boolean deletedSuccesfully = false;
		try {
			MasSubTest test = (MasSubTest) getHibernateTemplate().get(
					MasSubTest.class, subTestId);
			test.setStatus("n");
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(test);
			deletedSuccesfully = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedSuccesfully;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteChargeCode(Integer chargeCodeId) {

		boolean dataDeleted = false;
		List<MasSubTest> subTestListForSaving = new ArrayList<MasSubTest>();
		MasChargeCode masChargeCode = new MasChargeCode();
		masChargeCode = (MasChargeCode) getHibernateTemplate().get(
				MasChargeCode.class, chargeCodeId);
		@SuppressWarnings("unused")
		Integer mainChargecodeId = masChargeCode.getMainChargecode().getId();
		Integer subChargecodeId = masChargeCode.getSubChargecode().getId();
		Integer departmentId = masChargeCode.getDepartment().getId();
		Integer chargeTypeId = masChargeCode.getChargeType().getId();
		Integer sampleId = masChargeCode.getSample().getId();
		Integer unitOfMeasurementId = masChargeCode.getUnitOfMeasurement()
				.getId();
		if (masChargeCode.getStatus().equals("y")) {
			List subTestList = (List) masChargeCode.getMasSubTests();

			if (subTestList != null) {
				for (Iterator subTestIterator = subTestList.iterator(); subTestIterator
						.hasNext();) {
					MasSubTest subTest = (MasSubTest) subTestIterator.next();
					subTest.setStatus("n");
					MasChargeCode masChargeCode1 = new MasChargeCode();
					masChargeCode1.setId(masChargeCode.getId());
					subTest.setChargeCode(masChargeCode);
					subTestListForSaving.add(subTest);
				}
			}
			@SuppressWarnings("unused")
			List mainChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasMainChargecode as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
			List subChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasSubChargecode as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
			List departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
			List chargeTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasChargeType as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
			List sampleList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasSample as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
			@SuppressWarnings("unused")
			List unitOfMeasurementList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasUnitOfMeasurement as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
			masChargeCode.setStatus("n");
			dataDeleted = true;
		} else {
			masChargeCode.setStatus("y");
			List subTestList = (List) masChargeCode.getMasSubTests();
			if (subTestList != null) {
				for (Iterator subTestIterator = subTestList.iterator(); subTestIterator
						.hasNext();) {
					MasSubTest subTest = (MasSubTest) subTestIterator.next();
					subTest.setStatus("y");
					MasChargeCode masChargeCode1 = new MasChargeCode();
					masChargeCode1.setId(masChargeCode.getId());
					subTest.setChargeCode(masChargeCode);
					subTestListForSaving.add(subTest);
				}
			}
			dataDeleted = false;
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masChargeCode);
		if (!subTestListForSaving.isEmpty()) {
			for (int k = 0; k < subTestListForSaving.size(); k++) {
				MasSubTest subTest = subTestListForSaving.get(k);
				getHibernateTemplate().saveOrUpdate(subTest);
			}

		}

		return dataDeleted;

	}

	@SuppressWarnings("unchecked")
	public boolean checkChargeCodeExsist(String chargeCodeCode,
			String chargeCodeName) {
		List chargeCodeExsistList = null;
		boolean chargeCodeExsist = true;
		try {
			chargeCodeExsistList = getHibernateTemplate()
					.find(
							"from jkt.hms.masters.business.MasChargeCode as ccm where ccm.ChargeCodeCode = '"
									+ chargeCodeCode
									+ "' or ccm.ChargeCodeName = '"
									+ chargeCodeName + "' ");
			if (chargeCodeExsistList.size() > 0) {
				chargeCodeExsist = false;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return chargeCodeExsist;
	}

	@SuppressWarnings("unchecked")
	public boolean checkChargeCodeNameExsistForEditing(int chargeCodeId,
			String chargeCodeName) {
		List chargeCodeExsistList = null;
		boolean chargeCodeNameExsistForEdition = true;
		chargeCodeExsistList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasChargeCode as ccm where ccm.ChargeCodeName = '"
								+ chargeCodeName
								+ "'and ccm.Id != "
								+ chargeCodeId);
		if (chargeCodeExsistList.size() > 0) {
			chargeCodeNameExsistForEdition = false;
		}
		return chargeCodeNameExsistForEdition;
	}

	@SuppressWarnings("unchecked")
	public boolean editChargeCode(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int mainChargecodeId = 0;
		String chargecodeName = "";
		@SuppressWarnings("unused")
		String chargecodeCode = "";
		int subChargecodeId = 0;
		String changedBy = "";
		int departmentId = 0;
		int subchargeCodeId = 0;
		int chargeId = 0;
		float charge = 0;
		int chargeTypeId = 0;
		departmentId = (Integer) generalMap.get("departmentId");
		charge = (Float) generalMap.get("charge");
		chargeTypeId = (Integer) generalMap.get("chargeTypeId");
		subchargeCodeId = (Integer) generalMap.get("subchargeCodeId");
		chargeId = (Integer) generalMap.get("id");
		subChargecodeId = (Integer) generalMap.get("id");
		chargecodeCode = (String) generalMap.get("chargecodeCode");
		chargecodeName = (String) generalMap.get("chargecodeName");
		mainChargecodeId = (Integer) generalMap.get("mainChargecodeId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasChargeCode masCharge = (MasChargeCode) getHibernateTemplate().get(
				MasChargeCode.class, chargeId);

		masCharge.setId(chargeId);
		masCharge.setChargeCodeCode(chargecodeCode);
		masCharge.setChargeCodeName(chargecodeName);
		masCharge.setCharge(charge);

		MasChargeType masChargeType = new MasChargeType();
		masChargeType.setId(chargeTypeId);
		masCharge.setChargeType(masChargeType);

		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setId(mainChargecodeId);
		masCharge.setMainChargecode(masMainChargecode);

		MasSubChargecode masSub = new MasSubChargecode();
		masSub.setId(subchargeCodeId);
		masCharge.setSubChargecode(masSub);

		MasDepartment masDep = new MasDepartment();
		masDep.setId(departmentId);
		masCharge.setDepartment(masDep);
		masCharge.setLastChgBy(changedBy);
		masCharge.setLastChgDate(currentDate);
		masCharge.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCharge);
		dataUpdated = true;
		return dataUpdated;

	}

	// --------------------------sub charge code-----------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSubChargeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSubChargecode> searchSubChargeList = new ArrayList<MasSubChargecode>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasMainChargecode> gridMainChargeList = new ArrayList<MasMainChargecode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();

		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as isc where isc.Status = 'y' order by isc.DepartmentName asc");
		searchSubChargeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSubChargecode ");
		gridMainChargeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMainChargecode as id");
		mainChargeCodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMainChargecode as mc where mc.Status = 'y' order by mc.MainChargecodeName asc");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		map.put("searchSubChargeList", searchSubChargeList);
		map.put("mainChargeCodeList", mainChargeCodeList);
		map.put("gridMainChargeList", gridMainChargeList);
		map.put("departmentList", departmentList);
		map.put("gridDepartmentList", gridDepartmentList);
		return map;
	}

	public boolean addSubCharge(MasSubChargecode subChargecodeMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(subChargecodeMaster);
		successfullyAdded = true;
		return successfullyAdded;

	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public Map searchSubCharge(String subChargecodeCode,
			String subChargecodeName) {

		List<MasSubChargecode> searchSubChargeList = new ArrayList<MasSubChargecode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();

		List mainChargeCodeList = null;
		Map subChargeFieldsMap = new HashMap();
		List gridMainChargeList = null;
		try {
			if ((subChargecodeName != null) || (subChargecodeCode == null)) {

				searchSubChargeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasSubChargecode sc where sc.SubChargecodeName like '"
										+ subChargecodeName
										+ "%' order by sc.SubChargecodeName");
			} else {

				searchSubChargeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasSubChargecode sc where sc.SubChargecodeCode like '"
										+ subChargecodeCode
										+ "%' order by sc.SubChargecodeCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchSubCharge  " + e);
		}
		mainChargeCodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMainChargecode as mc where mc.Status = 'y'");
		gridMainChargeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMainChargecode as mainChargecodeCode");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as isc where isc.Status = 'y'");

		subChargeFieldsMap.put("gridMainChargeList", gridMainChargeList);
		subChargeFieldsMap.put("searchSubChargeList", searchSubChargeList);
		subChargeFieldsMap.put("mainChargeCodeList", mainChargeCodeList);
		subChargeFieldsMap.put("departmentList", departmentList);
		subChargeFieldsMap.put("gridDepartmentList", gridDepartmentList);

		return subChargeFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteSubCharge(Integer subChargecodeId,
			Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasSubChargecode masSubChargecode = new MasSubChargecode();
		masSubChargecode = (MasSubChargecode) getHibernateTemplate().get(
				MasSubChargecode.class, subChargecodeId);
		@SuppressWarnings("unused")
		Integer mainChargeCodeId = masSubChargecode.getMainChargecode().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			@SuppressWarnings("unused")
			List mainChargeCodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasMainChargecode as isc where isc.Id='"
							+ subChargecodeId + "' and isc.Status='y'");

			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masSubChargecode.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masSubChargecode.setStatus("y");
				dataDeleted = false;
			}
		}
		masSubChargecode.setLastChgBy(changedBy);
		masSubChargecode.setLastChgDate(currentDate);
		masSubChargecode.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masSubChargecode);
		return dataDeleted;
	}

	public boolean editSubChargeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int mainChargecodeId = 0;
		String subChargecodeName = "";
		@SuppressWarnings("unused")
		String subChargecodeCode = "";
		int subChargecodeId = 0;
		String changedBy = "";
		int departmentId = 0;
		departmentId = (Integer) generalMap.get("departmentId");
		subChargecodeId = (Integer) generalMap.get("id");
		subChargecodeCode = (String) generalMap.get("subChargecodeCode");
		subChargecodeName = (String) generalMap.get("name");
		mainChargecodeId = (Integer) generalMap.get("mainChargecodeId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasSubChargecode subChargecodeMaster = (MasSubChargecode) getHibernateTemplate()
				.get(MasSubChargecode.class, subChargecodeId);

		subChargecodeMaster.setId(subChargecodeId);
		subChargecodeMaster.setSubChargecodeName(subChargecodeName);

		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setId(mainChargecodeId);
		subChargecodeMaster.setMainChargecode(masMainChargecode);

		MasDepartment masDep = new MasDepartment();
		masDep.setId(departmentId);
		subChargecodeMaster.setDepartment(masDep);
		subChargecodeMaster.setLastChgBy(changedBy);
		subChargecodeMaster.setLastChgDate(currentDate);
		subChargecodeMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(subChargecodeMaster);
		dataUpdated = true;
		return dataUpdated;

	}

	// -----------------------------I C D
	// MASTER--------------------------------------------
	public boolean addIcd(MasIcd masIcd) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masIcd);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteIcd(int icdId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasIcd masIcd = new MasIcd();
		masIcd = (MasIcd) getHibernateTemplate().get(MasIcd.class, icdId);
		@SuppressWarnings("unused")
		Integer icdSubCategoryId = masIcd.getIcdSubCategory().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			List icdSubCategoryList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasIcdSubCategory as isc where isc.Id='"
							+ icdId + "' and isc.Status='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masIcd.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masIcd.setStatus("y");
				dataDeleted = false;
			}
		}
		masIcd.setLastChgBy(changedBy);
		masIcd.setLastChgDate(currentDate);
		masIcd.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masIcd);
		return dataDeleted;

	}

	public boolean editIcdToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int icdSubCategoryId = 0;
		int icdCauseId = 0;
		String icdName = "";
		@SuppressWarnings("unused")
		String icdCode = "";
		int icdId = 0;
		String changedBy = "";
		icdId = (Integer) generalMap.get("id");
		icdCode = (String) generalMap.get("icdCode");
		icdName = (String) generalMap.get("name");
		icdSubCategoryId = (Integer) generalMap.get("icdSubCategoryId");
		icdCauseId = (Integer) generalMap.get("icdCauseId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasIcd masIcd = (MasIcd) getHibernateTemplate()
				.get(MasIcd.class, icdId);

		masIcd.setId(icdId);
		masIcd.setIcdName(icdName);

		if (icdSubCategoryId != 0) {
			MasIcdSubCategory masIcdSubCategory = new MasIcdSubCategory();
			masIcdSubCategory.setId(icdSubCategoryId);
			masIcd.setIcdSubCategory(masIcdSubCategory);
		}
		if (icdCauseId != 0) {
			MasIcdcausegrp masIcdcausegrp = new MasIcdcausegrp();
			masIcdcausegrp.setId(icdCauseId);
			masIcd.setIcdCause(masIcdcausegrp);
		}

		masIcd.setLastChgBy(changedBy);
		masIcd.setLastChgDate(currentDate);
		masIcd.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masIcd);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchIcd(String icdCode, String icdName) {
		List<MasIcd> searchIcdList = new ArrayList<MasIcd>();
		List icdSubCategoryList = null;
		Map<String, Object> icdFieldsMap = new HashMap<String, Object>();
		List<MasIcdcausegrp> icdCauseList = new ArrayList<MasIcdcausegrp>();
		List gridIcdSubCategoryList = null;
		List gridIcdCauseList = null;
		try {
			if ((icdName != null) || (icdCode == null)) {
				searchIcdList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasIcd as i where i.IcdName like '"
								+ icdName + "%' order by i.IcdName");
			} else {
				searchIcdList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasIcd as i where i.IcdCode like '"
								+ icdCode + "%' order by i.IcdCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		icdSubCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasIcdSubCategory as isc where isc.Status = 'y'");
		gridIcdSubCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdSubCategory as isc");
		icdCauseList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasIcdcausegrp as isc where isc.Status = 'y'");
		gridIcdCauseList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdcausegrp as isc");
		icdFieldsMap.put("gridIcdSubCategoryList", gridIcdSubCategoryList);
		icdFieldsMap.put("gridIcdCauseList", gridIcdCauseList);
		icdFieldsMap.put("searchIcdList", searchIcdList);
		icdFieldsMap.put("icdSubCategoryList", icdSubCategoryList);
		icdFieldsMap.put("icdCauseList", icdCauseList);
		return icdFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showIcdJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIcd> searchIcdList = new ArrayList<MasIcd>();
		List<MasIcdSubCategory> icdSubCategoryList = new ArrayList<MasIcdSubCategory>();
		List<MasIcdSubCategory> gridIcdSubCategoryList = new ArrayList<MasIcdSubCategory>();
		List<MasIcdcausegrp> icdCauseList = new ArrayList<MasIcdcausegrp>();
		List<MasIcdcausegrp> gridIcdCauseList = new ArrayList<MasIcdcausegrp>();

		searchIcdList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcd ");
		gridIcdSubCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdSubCategory as isc");
		icdSubCategoryList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasIcdSubCategory as isc where isc.Status = 'y' order by isc.IcdSubCategoryName asc ");
		icdCauseList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdcausegrp as isc order by isc.IcdCauseName asc");
		gridIcdCauseList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasIcdcausegrp as isc where isc.Status = 'y'");

		map.put("searchIcdList", searchIcdList);
		map.put("icdSubCategoryList", icdSubCategoryList);
		map.put("gridIcdSubCategoryList", gridIcdSubCategoryList);
		map.put("icdCauseList", icdCauseList);
		map.put("gridIcdCauseList", gridIcdCauseList);
		return map;
	}

	// ---------------------------ICD Main
	// Category-------------------------------------

	public Map<String, Object> searchIcdMainCategory(
			String icdMainCategoryCode, String icdMainCategoryName) {
		List<MasIcdMainCategory> searchIcdMainCategoryList = new ArrayList<MasIcdMainCategory>();
		Map<String, Object> icdMainCategoryFieldsMap = new HashMap<String, Object>();
		try {
			if ((icdMainCategoryName != null) || (icdMainCategoryCode == null)) {
				searchIcdMainCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasIcdMainCategory as i where i.IcdMaincategoryName like '"
										+ icdMainCategoryName
										+ "%' order by i.IcdMaincategoryName");
			} else {
				searchIcdMainCategoryList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasIcdMainCategory as i where i.IcdMaincategoryCode like '"
										+ icdMainCategoryCode
										+ "%' order by i.IcdMaincategoryCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchIcdList  " + e);
		}

		icdMainCategoryFieldsMap.put("searchIcdMainCategoryList",
				searchIcdMainCategoryList);

		return icdMainCategoryFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showIcdMainCategoryJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIcdMainCategory> searchIcdMainCategoryList = new ArrayList<MasIcdMainCategory>();
		searchIcdMainCategoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdMainCategory ");
		map.put("searchIcdMainCategoryList", searchIcdMainCategoryList);
		return map;
	}

	public boolean addIcdMainCategory(MasIcdMainCategory masIcdMainCategory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masIcdMainCategory);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editIcdMainCategoryToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String icdMainCategoryName = "";
		@SuppressWarnings("unused")
		String icdMainCategoryCode = "";
		int icdMainCategoryId = 0;
		String changedBy = "";
		icdMainCategoryId = (Integer) generalMap.get("id");
		icdMainCategoryCode = (String) generalMap.get("icdMainCategoryCode");
		icdMainCategoryName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasIcdMainCategory masIcdMainCategory = (MasIcdMainCategory) getHibernateTemplate()
				.get(MasIcdMainCategory.class, icdMainCategoryId);

		masIcdMainCategory.setId(icdMainCategoryId);
		masIcdMainCategory.setIcdMaincategoryName(icdMainCategoryName);
		masIcdMainCategory.setLastChgBy(changedBy);
		masIcdMainCategory.setLastChgDate(currentDate);
		masIcdMainCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masIcdMainCategory);
		dataUpdated = true;
		return dataUpdated;

	}

	public boolean deleteIcdMainCategory(int icdMainCategoryId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasIcdMainCategory masIcdMainCategory = new MasIcdMainCategory();
		masIcdMainCategory = (MasIcdMainCategory) getHibernateTemplate().get(
				MasIcdMainCategory.class, icdMainCategoryId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masIcdMainCategory.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masIcdMainCategory.setStatus("y");
				dataDeleted = false;
			}
		}
		masIcdMainCategory.setLastChgBy(changedBy);
		masIcdMainCategory.setLastChgDate(currentDate);
		masIcdMainCategory.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masIcdMainCategory);
		return dataDeleted;

	}

	// ------------------------------------------ Service Type
	// ---------------------------

	public boolean addServiceType(MasServiceType masServiceType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masServiceType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteServiceType(int serviceTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasServiceType masServiceType = new MasServiceType();
		masServiceType = (MasServiceType) getHibernateTemplate().get(
				MasServiceType.class, serviceTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masServiceType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masServiceType.setStatus("y");
				dataDeleted = false;
			}
		}
		masServiceType.setLastChgBy(changedBy);
		masServiceType.setLastChgDate(currentDate);
		masServiceType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masServiceType);
		return dataDeleted;
	}

	public boolean editServiceTypeToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String serviceTypeName = "";
		@SuppressWarnings("unused")
		String serviceTypeCode = "";
		String shortDescription = "";
		int serviceTypeId = 0;
		String changedBy = "";
		serviceTypeId = (Integer) generalMap.get("id");
		serviceTypeCode = (String) generalMap.get("serviceTypeCode");
		serviceTypeName = (String) generalMap.get("name");
		shortDescription = (String) generalMap.get("shortDescription");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasServiceType masServiceType = (MasServiceType) getHibernateTemplate()
				.get(MasServiceType.class, serviceTypeId);

		masServiceType.setId(serviceTypeId);
		masServiceType.setServiceTypeName(serviceTypeName);
		masServiceType.setServiceNameShortDesc(shortDescription);
		masServiceType.setLastChgBy(changedBy);
		masServiceType.setLastChgDate(currentDate);
		masServiceType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masServiceType);
		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> showServiceTypeJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> searchServiceTypeList = new ArrayList<MasServiceType>();
		Session session=(Session)getSession();
/*		searchServiceTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceType ");
*/		session.createCriteria(MasServiceType.class).list();
		map.put("searchServiceTypeList", searchServiceTypeList);
		return map;
	}

	public Map<String, Object> searchServiceType(String serviceTypeCode,
			String serviceTypeName) {
		List<MasServiceType> searchServiceTypeList = new ArrayList<MasServiceType>();
		Map<String, Object> serviceTypeFieldsMap = new HashMap<String, Object>();
		Session session=(Session)getSession();
		try {
			if ((serviceTypeName != null) || (serviceTypeCode == null)) {
/*				searchServiceTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasServiceType imc where imc.ServiceTypeName like '"
										+ serviceTypeName
										+ "%' order by imc.ServiceTypeName");
*/			
				searchServiceTypeList=session.createCriteria(MasServiceType.class)
				.add(Restrictions.like("ServiceTypeName","%"+serviceTypeName+"%"))
				.addOrder(Order.asc("ServiceTypeName")).list();
				
			} else {
				/*searchServiceTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasServiceType imc where imc.ServiceTypeCode like '"
										+ serviceTypeCode
										+ "%' order by imc.ServiceTypeCode");*/
			
			
				searchServiceTypeList=session.createCriteria(MasServiceType.class)			
				.add(Restrictions.like("ServiceTypeCode","%"+serviceTypeCode+"%"))
				.addOrder(Order.asc("ServiceTypeName")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		serviceTypeFieldsMap
				.put("searchServiceTypeList", searchServiceTypeList);
		return serviceTypeFieldsMap;
	}

	// --------------------------------------- Service Status-------
	// ---------------------------

	public boolean addServiceStatus(MasServiceStatus masServiceStatus) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masServiceStatus);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteServiceStatus(int serviceStatusId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasServiceStatus masServiceStatus = new MasServiceStatus();
		masServiceStatus = (MasServiceStatus) getHibernateTemplate().get(
				MasServiceStatus.class, serviceStatusId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masServiceStatus.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masServiceStatus.setStatus("y");
				dataDeleted = false;
			}
		}
		masServiceStatus.setLastChgBy(changedBy);
		masServiceStatus.setLastChgDate(currentDate);
		masServiceStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masServiceStatus);
		return dataDeleted;
	}

	public boolean editServiceStatusToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String serviceStatusName = "";
		@SuppressWarnings("unused")
		String serviceStatusCode = "";
		int serviceStatusId = 0;
		String changedBy = "";
		serviceStatusId = (Integer) generalMap.get("id");
		serviceStatusCode = (String) generalMap.get("serviceStatusCode");
		serviceStatusName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasServiceStatus masServiceStatus = (MasServiceStatus) getHibernateTemplate()
				.get(MasServiceStatus.class, serviceStatusId);

		masServiceStatus.setId(serviceStatusId);
		masServiceStatus.setServiceStatusName(serviceStatusName);
		masServiceStatus.setLastChgBy(changedBy);
		masServiceStatus.setLastChgDate(currentDate);
		masServiceStatus.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masServiceStatus);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchServiceStatus(String serviceStatusCode,
			String serviceStatusName) {
		List<MasServiceStatus> searchServiceStatusList = new ArrayList<MasServiceStatus>();
		Map<String, Object> serviceStatusFieldsMap = new HashMap<String, Object>();
		Session session=(Session)getSession();
		try {
			if ((serviceStatusName != null) || (serviceStatusCode == null)) {
			/*	searchServiceStatusList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasServiceStatus imc where imc.ServiceStatusName like '"
										+ serviceStatusName
										+ "%' order by imc.ServiceStatusName");*/
				
				searchServiceStatusList=session.createCriteria(MasServiceStatus.class)
				.add(Restrictions.like("ServiceStatusName","%"+serviceStatusName+"%"))
				.addOrder(Order.asc("ServiceStatusName")).list();
				
			} else {
				/*searchServiceStatusList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasServiceStatus imc where imc.ServiceStatusCode like '"
										+ serviceStatusCode
										+ "%' order by imc.ServiceStatusCode");*/
				searchServiceStatusList=session.createCriteria(MasServiceStatus.class)
				.add(Restrictions.like("ServiceStatusCode","%"+serviceStatusCode+"%"))
				.addOrder(Order.asc("ServiceStatusName")).list();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		serviceStatusFieldsMap.put("searchServiceStatusList",
				searchServiceStatusList);
		return serviceStatusFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showServiceStatusJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceStatus> searchServiceStatusList = new ArrayList<MasServiceStatus>();
		/*searchServiceStatusList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasServiceStatus ");*/
		Session session=(Session)getSession();
		searchServiceStatusList=session.createCriteria(MasServiceStatus.class).list();
		map.put("searchServiceStatusList", searchServiceStatusList);
		return map;

	}

	public Map<String, Object> getConnection() {
		Session session = (Session) getSession();
		Connection con = (Connection) session.connection();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("conn", con);
		return map;
	}

	// ---------------------------------Patient
	// Type----------------------------------

	public boolean addPatientType(MasPatientType masPatientType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masPatientType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editPatientTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String patientTypeName = "";
		@SuppressWarnings("unused")
		String patientTypeCode = "";
		int patientTypeId = 0;
		String changedBy = "";
		patientTypeId = (Integer) generalMap.get("id");
		patientTypeCode = (String) generalMap.get("patientTypeCode");
		patientTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasPatientType masPatientType = (MasPatientType) getHibernateTemplate()
				.get(MasPatientType.class, patientTypeId);

		masPatientType.setId(patientTypeId);
		masPatientType.setPatientTypeName(patientTypeName);
		masPatientType.setLastChgBy(changedBy);
		masPatientType.setLastChgDate(currentDate);
		masPatientType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masPatientType);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPatientType(String patientTypeCode,
			String patientTypeName) {
		List<MasPatientType> searchPatientTypeList = new ArrayList<MasPatientType>();
		Map<String, Object> patientTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((patientTypeName != null) || (patientTypeCode == null)) {
				searchPatientTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasPatientType imc where imc.PatientTypeName like '"
										+ patientTypeName
										+ "%' order by imc.PatientTypeName");
				
				
			} else {
				searchPatientTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasPatientType imc where imc.PatientTypeCode like '"
										+ patientTypeCode
										+ "%' order by imc.PatientTypeCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchPatientTypeList  " + e);
		}
		patientTypeFieldsMap
				.put("searchPatientTypeList", searchPatientTypeList);
		return patientTypeFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPatientTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPatientType> searchPatientTypeList = new ArrayList<MasPatientType>();
		searchPatientTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasPatientType ");
		map.put("searchPatientTypeList", searchPatientTypeList);
		return map;
	}

	public boolean deletePatientType(int patientTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasPatientType masPatientType = new MasPatientType();
		masPatientType = (MasPatientType) getHibernateTemplate().get(
				MasPatientType.class, patientTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masPatientType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masPatientType.setStatus("y");
				dataDeleted = false;
			}
		}
		masPatientType.setLastChgBy(changedBy);
		masPatientType.setLastChgDate(currentDate);
		masPatientType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masPatientType);
		return dataDeleted;
	}

	// --------------------------------IcdCausegrp----------------------------
	public Map<String, Object> showIcdCauseJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIcdcausegrp> searchCauseList = new ArrayList<MasIcdcausegrp>();
		searchCauseList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasIcdcausegrp ");
		map.put("searchCauseList", searchCauseList);
		return map;
	}

	public Map<String, Object> searchIcdCause(String causeCode, String causeName) {
		List<MasIcdcausegrp> searchCauseList = new ArrayList<MasIcdcausegrp>();
		Map causeFieldsMap = new HashMap();
		try {
			if ((causeName != null) || (causeCode == null)) {
				searchCauseList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasIcdcausegrp sc where sc.IcdCauseName like '"
								+ causeName + "%' order by sc.IcdCauseName");
			} else {
				searchCauseList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasIcdcausegrp sc where sc.IcdCauseCode like '"
								+ causeCode + "%' order by sc.IcdCauseCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		causeFieldsMap.put("searchCauseList", searchCauseList);
		return causeFieldsMap;
	}

	public boolean editIcdCauseToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String causeName = "";
		@SuppressWarnings("unused")
		String causeCode = "";
		int causeId = 0;
		String changedBy = "";
		causeId = (Integer) generalMap.get("id");
		causeCode = (String) generalMap.get("deathCauseCode");
		causeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasIcdcausegrp masIcdcausegrp = (MasIcdcausegrp) getHibernateTemplate()
				.get(MasIcdcausegrp.class, causeId);

		masIcdcausegrp.setId(causeId);
		masIcdcausegrp.setIcdCauseName(causeName);
		masIcdcausegrp.setLastChgBy(changedBy);
		masIcdcausegrp.setLastChgDate(currentDate);
		masIcdcausegrp.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masIcdcausegrp);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean addIcdCause(MasIcdcausegrp masDeathCause) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDeathCause);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteIcdCause(int causeId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasIcdcausegrp masIcdcausegrp = new MasIcdcausegrp();
		masIcdcausegrp = (MasIcdcausegrp) getHibernateTemplate().get(
				MasIcdcausegrp.class, causeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masIcdcausegrp.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masIcdcausegrp.setStatus("y");
				dataDeleted = false;
			}
		}
		masIcdcausegrp.setLastChgBy(changedBy);
		masIcdcausegrp.setLastChgDate(currentDate);
		masIcdcausegrp.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masIcdcausegrp);
		return dataDeleted;
	}

	public boolean deleteChargeCode1(int chargeCodeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasChargeCode masCaseType = new MasChargeCode();
		masCaseType = (MasChargeCode) getHibernateTemplate().get(
				MasChargeCode.class, chargeCodeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			List mainChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasMainChargecode as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
			List subChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasSubChargecode as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
			List departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
			List chargeTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasChargeType as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
			List sampleList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasSample as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");
			@SuppressWarnings("unused")
			List unitOfMeasurementList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasUnitOfMeasurement as isc where isc.Id='"
							+ chargeCodeId + "' and isc.Status='y'");

			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCaseType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCaseType.setStatus("y");
				dataDeleted = false;
			}
		}
		masCaseType.setLastChgBy(changedBy);
		masCaseType.setLastChgDate(currentDate);
		masCaseType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCaseType);
		return dataDeleted;
	}

	/** methods for diag param **/
	@SuppressWarnings("unchecked")
	public Map<String, Object> showParamJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DiagParam> searchParamList = new ArrayList<DiagParam>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasMainChargecode> gridMainChargeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasSubChargecode> gridSubChargeList = new ArrayList<MasSubChargecode>();

		searchParamList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DiagParam ");
		gridMainChargeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMainChargecode as id");
		mainChargeCodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMainChargecode as mc where mc.Status = 'y'");
		gridSubChargeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSubChargecode as id");
		subChargeCodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSubChargecode as mc where mc.Status = 'y'");
		map.put("searchParamList", searchParamList);
		map.put("mainChargeCodeList", mainChargeCodeList);
		map.put("gridMainChargeList", gridMainChargeList);

		map.put("gridSubChargeList", gridSubChargeList);
		map.put("subChargeCodeList", subChargeCodeList);
		return map;
	}

	public boolean addDiagParam(DiagParam diagParam) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(diagParam);
		successfullyAdded = true;
		return successfullyAdded;

	}

	@SuppressWarnings("unchecked")
	public boolean editDiagParam(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		@SuppressWarnings("unused")
		String changedBy = "";
		int diagId = 0;
		int sequenceNo = 0;
		String prefix = "";
		String criteria = "";

		diagId = (Integer) generalMap.get("id");
		sequenceNo = (Integer) generalMap.get("sequenceNo");
		prefix = (String) generalMap.get("prefix");
		criteria = (String) generalMap.get("criteria");

		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		DiagParam diagParam = (DiagParam) getHibernateTemplate().get(
				DiagParam.class, diagId);

		diagParam.setId(diagId);
		diagParam.setSeqNo(sequenceNo);
		diagParam.setPrefix(prefix);
		diagParam.setCriteria(criteria);
		diagParam.setLastChgBy(changedBy);
		diagParam.setLastChgDate(currentDate);
		diagParam.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(diagParam);
		dataUpdated = true;
		return dataUpdated;

	}

	@SuppressWarnings("unchecked")
	public boolean deleteDiagParam(Integer diagId,
			Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		DiagParam diagParam = new DiagParam();
		diagParam = (DiagParam) getHibernateTemplate().get(DiagParam.class,
				diagId);
		@SuppressWarnings("unused")
		Integer mainChargeCodeId = diagParam.getMainCharge().getId();
		Integer subChargeId = diagParam.getSubCharge().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {
			@SuppressWarnings("unused")
			List mainChargeCodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasMainChargecode as isc where isc.Id='"
							+ diagId + "' and isc.Status='y'");
			List subChargeCodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasSubChargecode as isc where isc.Id='"
							+ diagId + "' and isc.Status='y'");
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				diagParam.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				diagParam.setStatus("y");
				dataDeleted = false;
			}
		}
		diagParam.setLastChgBy(changedBy);
		diagParam.setLastChgDate(currentDate);
		diagParam.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(diagParam);
		return dataDeleted;
	}

	public Map<String, Object> getSubchargeList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
		subChargecodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DiagParam as mi where  mi.SubCharge.Id = "
						+ box.getInt(RequestConstants.SUB_CHARGECODE_ID)
						+ " and mi.SubCharge.Status ='y'");
		map.put("subChargecodeList", subChargecodeList);
		return map;
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public Map searchSubChargeInDiagParam(String subChargecodeCode,
			String subChargecodeName) {

		List<DiagParam> searchParamList = new ArrayList<DiagParam>();
		List mainChargeCodeList = null;
		Map subChargeFieldsMap = new HashMap();
		List gridMainChargeList = null;
		List<MasSubChargecode> subChargeCodeList = null;
		List<MasSubChargecode> gridSubChargeList = null;
		try {
			if ((subChargecodeName != null) || (subChargecodeCode == null)) {

				searchParamList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.DiagParam sc where sc.SubCharge.SubChargecodeName like '"
										+ subChargecodeName
										+ "%' order by sc.SubCharge.SubChargecodeName");
			} else {

				searchParamList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.DiagParam sc where sc.SubCharge.SubChargecodeCode like '"
										+ subChargecodeCode
										+ "%' order by sc.SubCharge.SubChargecodeCode");
			}
		} catch (Exception e) {
			//System.out.println("Ds excp in searchSubCharge  " + e);
		}

		mainChargeCodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMainChargecode as mc where mc.Status = 'y'");
		gridMainChargeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasMainChargecode as mainChargecodeCode");
		gridSubChargeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSubChargecode as id");
		subChargeCodeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasSubChargecode as mc where mc.Status = 'y'");
		subChargeFieldsMap.put("gridMainChargeList", gridMainChargeList);
		subChargeFieldsMap.put("searchParamList", searchParamList);
		subChargeFieldsMap.put("mainChargeCodeList", mainChargeCodeList);
		subChargeFieldsMap.put("gridSubChargeList", gridSubChargeList);
		subChargeFieldsMap.put("subChargeCodeList", subChargeCodeList);
		return subChargeFieldsMap;
	}

	@Override
	public Map<String, Object> checkExistingBedNo(Map<String, Object> generalMap) {
		Map<String,Object> map = new HashMap<String, Object>();
		String bedNo = (String)generalMap.get("name");
		int hospitalId = (Integer)generalMap.get("hospitalId");
		int departmentId = (Integer)generalMap.get("departmentId");
		
		Session session = (Session)getSession();
		List<MasBed> bedNumberList = new ArrayList<MasBed>();
		
		bedNumberList = session.createCriteria(MasBed.class).createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
		.add(Restrictions.eq("Department.Id", departmentId))
		.add(Restrictions.eq("BedNo", bedNo)).list();
		map.put("bedNumberList", bedNumberList);
		
		return map;
	}
	

	// ---------------------------------------------Session
				// -------------------------------------------
				public boolean addSession(MasSession masSession) {
					boolean successfullyAdded = false;
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.save(masSession);
					successfullyAdded = true;
					return successfullyAdded;
				}

				public boolean deleteSession(int sessionId, Map<String, Object> generalMap) {
					boolean dataDeleted = false;
					String changedBy = "";
					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
							"currentTime");

					MasSession masSession = new MasSession();
					masSession = (MasSession) getHibernateTemplate().load(MasSession.class, sessionId);
					int userId=0; 
					userId = (Integer) generalMap.get("userId");
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");
					if (generalMap.get("flag") != null) {
						String flag = (String) generalMap.get("flag");
						if (flag.equals("InActivate")) {
							masSession.setStatus("N");
							dataDeleted = true;
						} else if (flag.equals("Activate")) {
							masSession.setStatus("Y");
							dataDeleted = false;
						}
					}
					Users users = new Users();
					users.setId(userId);
					masSession.setLastChgBy(users);
					masSession.setLastChgDate(currentDate);
					masSession.setLastChgTime(currentTime);
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masSession);
					return dataDeleted;
				}

				public boolean editSessionToDatabase(Map<String, Object> generalMap) {

					boolean dataUpdated = false;
					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
							"currentTime");
					String sessionName = "";
					int sessionId = 0;
					int userId=0;
					int hospitalId=0;
					String fromTime="";
					String toTime="";
					hospitalId=(Integer) generalMap.get("hospitalId");
					userId = (Integer) generalMap.get("userId");
					sessionId = (Integer) generalMap.get("id");
					sessionName = (String) generalMap.get("name");
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");
					fromTime = (String) generalMap.get("fromTime");
					toTime = (String) generalMap.get("toTime");
					MasSession masSession = (MasSession) getHibernateTemplate().load(MasSession.class,
							sessionId);

					masSession.setId(sessionId);
					masSession.setSessionName(sessionName);
					
					masSession.setFromTime(fromTime);
					masSession.setToTime(toTime);
					Users users = new Users();
					users.setId(userId);
					masSession.setLastChgBy(users);
					masSession.setLastChgDate(currentDate);
					
					masSession.setLastChgTime(currentTime);
					
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					masSession.setHospital(masHospital);
					
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masSession);
					dataUpdated = true;
					return dataUpdated;
				}

				@SuppressWarnings("unchecked")
				public Map<String, Object> searchSession(String sessionName) {
					List<MasSession> searchSessionList = new ArrayList<MasSession>();
					Map<String, Object> sessionFieldsMap = new HashMap<String, Object>();
					try {
						if ((sessionName != null)) {
							searchSessionList = getHibernateTemplate().find(
									"from jkt.hms.masters.business.MasSession imc where imc.SessionName like '"
											+ sessionName + "%' order by imc.SessionName");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					sessionFieldsMap.put("searchSessionList", searchSessionList);
					return sessionFieldsMap;
				}

				@SuppressWarnings("unchecked")
				public Map<String, Object> showSessionJsp(Box box) {
					Map<String, Object> map = new HashMap<String, Object>();
					int hospitalId=0;
					if(box.get(RequestConstants.HOSPITAL_ID)!=null){
						hospitalId=box.getInt(RequestConstants.HOSPITAL_ID);
					}
					List<MasSession> searchSessionList = new ArrayList<MasSession>();
					Session session=(Session)getSession();
					 Criteria criteria=session.createCriteria(MasSession.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId));
					 searchSessionList=criteria.list();
					/*searchSessionList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasSession ");*/
					map.put("searchSessionList", searchSessionList);
					return map;
				}

				@Override
				public Map<String, Object> checkSession(Map<String, Object> dataMap) {
					Session session=(Session)getSession();
					Map<String, Object> map = new HashMap<String, Object>();
					List<MasSession> searchSessionList = new ArrayList<MasSession>();
					int hospitalId=0;
					String visitSessionName="";
					if(dataMap.get(RequestConstants.HOSPITAL_ID)!=null){
						hospitalId=Integer.parseInt(dataMap.get(RequestConstants.HOSPITAL_ID).toString());
					}
					if(dataMap.get("name")!=null){
						visitSessionName=dataMap.get("name").toString();
					}
					Criteria criteria=session.createCriteria(MasSession.class)
							.add(Restrictions.eq("Hospital.Id", hospitalId))
							.add(Restrictions.eq("SessionName", visitSessionName.trim()).ignoreCase());
							 searchSessionList=criteria.list();
							 map.put("duplicateGeneralNameList", searchSessionList);
					return map;
				}

				public Map<String, Object> getHospitalName(Map<String, Object> mapForDs) {
					Map<String, Object> mapResponse = new HashMap<String, Object>();
					Session session = (Session) getSession();
					Integer hospitalId = 0;
					if (mapForDs.get("hospitalId") != null) {
						hospitalId = (Integer) mapForDs.get("hospitalId");
					}
					try {
						List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
						masHospitaList = session.createCriteria(MasHospital.class)
								.add(Restrictions.eq("Id", hospitalId)).add(Restrictions.eq("Status","y")).list();
						mapResponse.put("masHospitaList", masHospitaList);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return mapResponse;
				}

				
				// -------------------------------- Ot			// Master-----------------------------------
				@SuppressWarnings("unchecked")
				public Map<String, Object> showOtJsp() {
					Map<String, Object> map = new HashMap<String, Object>();
					List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
					List<MasBedStatus> bedStatusList = new ArrayList<MasBedStatus>();
					List<OtBed> searchOtBedList = new ArrayList<OtBed>();
					
					List<MasOt> otListGrid = new ArrayList<MasOt>();
					List<MasDepartment> departmentListGrid = new ArrayList<MasDepartment>();
					List<MasRoom> roomListGrid = new ArrayList<MasRoom>();
					List<MasBedStatus> bedStatusListGrid = new ArrayList<MasBedStatus>();
					Session session = (Session)getSession();
					
					
					List<MasBed> searchBedList = new ArrayList<MasBed>();

					departmentList = getHibernateTemplate()
							.find("select md from jkt.hms.masters.business.MasDepartment md left join md.DepartmentType as dt where lower(md.Status) = 'y' and upper(dt.DepartmentTypeCode) ='OT'");
					
					bedStatusList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasBedStatus as mbs where lower(mbs.Status) = 'y'");
					otListGrid= getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasOt as mbs where lower(mbs.Status) = 'y'");
					
					departmentListGrid = getHibernateTemplate()
							.find("select md from jkt.hms.masters.business.MasDepartment md left join md.DepartmentType as dt where  upper(dt.DepartmentTypeCode) ='OT'");
					
					bedStatusListGrid = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasBedStatus as mbs");
					searchBedList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasBed where flag='OT'");
					
					searchOtBedList = session.createCriteria(OtBed.class).createAlias("Bed", "b")
							.add(Restrictions.eq("b.Flag", "OT"))
							.addOrder(Order.asc("b.BedNo")).list();
					map.put("departmentList", departmentList);
					map.put("bedStatusList", bedStatusList);
					
					map.put("departmentListGrid", departmentListGrid);
					map.put("roomListGrid", roomListGrid);
					map.put("bedStatusListGrid", bedStatusListGrid);
					map.put("searchOtBedList", searchOtBedList);
					map.put("otListGrid", otListGrid);
					map.put("searchBedList", searchBedList);
					return map;
				}

				public Map<String, Object> searchOt(String bedNumber) {
					List<MasBed> searchBedList = new ArrayList<MasBed>();
					List<OtBed> searchOtBedList = new ArrayList<OtBed>();
					Map<String, Object> bedFieldsMap = new HashMap<String, Object>();
					List departmentList = new ArrayList();
					List roomList = new ArrayList();
					List<MasOt> otListGrid = new ArrayList<MasOt>();
					List bedStatusList = new ArrayList();
					List<MasDepartment> departmentListGrid = new ArrayList<MasDepartment>();
					List<MasBedStatus> bedStatusListGrid = new ArrayList<MasBedStatus>();
					Session session = (Session)getSession();
					try {
						if ((bedNumber != null)) {
						/*	searchBedList = getHibernateTemplate().find(
									"from jkt.hms.masters.business.MasBed as mb where  mb.flag ='OT' and lower(mb.BedNo) like '"
											+ bedNumber.toLowerCase() + "%'  order by mb.BedNo");
							*/
							
							searchBedList = session.createCriteria(MasBed.class).add(Restrictions.like("BedNo", bedNumber).ignoreCase())
									.add(Restrictions.eq("Flag", "OT"))
									.addOrder(Order.asc("BedNo")).list();
							
							searchOtBedList = session.createCriteria(OtBed.class).createAlias("Bed", "b").add(Restrictions.like("b.BedNo", bedNumber).ignoreCase())
									.add(Restrictions.eq("b.Flag", "OT"))
									.addOrder(Order.asc("b.BedNo")).list();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					otListGrid= getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasOt as mbs where lower(mbs.Status) = 'y'");
				
					departmentList = getHibernateTemplate()
							.find("select md from jkt.hms.masters.business.MasDepartment md left join md.DepartmentType as dt where lower(md.Status) = 'y' and upper(dt.DepartmentTypeCode) ='OT'");
					
					bedStatusList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasBedStatus as mbs where lower(mbs.Status) = 'y'");
					
					
					departmentListGrid = getHibernateTemplate()
							.find("select md from jkt.hms.masters.business.MasDepartment md left join md.DepartmentType as dt where  upper(dt.DepartmentTypeCode) ='OT'");
				
					bedStatusListGrid = getHibernateTemplate()
							.find("from jkt.hms.masters.business.MasBedStatus as mbs");
					bedFieldsMap.put("departmentListGrid", departmentListGrid);
					bedFieldsMap.put("bedStatusListGrid", bedStatusListGrid);
					bedFieldsMap.put("searchBedList", searchBedList);
					bedFieldsMap.put("searchOtBedList", searchOtBedList);
					bedFieldsMap.put("departmentList", departmentList);
					bedFieldsMap.put("roomList", roomList);
					bedFieldsMap.put("bedStatusList", bedStatusList);
					bedFieldsMap.put("otListGrid", otListGrid);
					return bedFieldsMap;
				}

				public boolean addOt(MasBed masBed,int otId) {
					boolean successfullyAdded = false;
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.save(masBed);
					hbt.flush();
					hbt.clear();
					
					 OtBed otBed = new OtBed();
					 otBed.setBed(masBed);
					 
					 MasOt masOt = new MasOt();
					 masOt.setId(otId);
					 otBed.setOt(masOt);
					
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.save(otBed);
						
					successfullyAdded = true;
					return successfullyAdded;
				}

				public boolean deleteOt(int bedId, Map<String, Object> generalMap) {
					boolean dataDeleted = false;
					String changedBy = "";
					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
							"currentTime");
					MasBed masBed = new MasBed();
					masBed = (MasBed) getHibernateTemplate().get(MasBed.class, bedId);
					@SuppressWarnings("unused")
					Integer departmentId = masBed.getDepartment().getId();
					Integer bedStatusId = masBed.getBedStatus().getId();
					changedBy = (String) generalMap.get("changedBy");
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");
					int userId=(Integer)generalMap.get(RequestConstants.USER_ID);

					if (generalMap.get("flag") != null) {
						List departmentList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.MasDepartment as isc where isc.Id='"
										+ bedId + "' and lower(isc.Status)='y'");
						List bedStatusList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.MasBedStatus as isc where isc.Id='"
										+ bedId + "' and lower(isc.Status)='y'");
					
						String flag = (String) generalMap.get("flag");
						if (flag.equals("InActivate")) {
							masBed.setStatus("n");
							dataDeleted = true;
						} else if (flag.equals("Activate")) {
							masBed.setStatus("y");
							dataDeleted = false;
						}
					}
					Users users=new Users();
					users.setId(userId);
					masBed.setLastChgBy(users);
					masBed.setLastChgDate(currentDate);
					masBed.setLastChgTime(currentTime);
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masBed);
					return dataDeleted;
				}

				public boolean editOtToDatabase(Map<String, Object> generalMap) {
					boolean dataUpdated = false;
					String bedNumber = "";
					int bedId = 0;
					int bedStatusId = 0;
					Session session = (Session)getSession();
					List<OtBed> otBedList = new ArrayList<OtBed>();
					int departmentId = 0;
					String adNo = "";
					String dietType = "";
					String attached = "";
					String currentTime = "";
					int otId=0;
					Date changedDate = new Date();
					bedId = (Integer) generalMap.get("id");
					otId = (Integer) generalMap.get("otId");
					bedNumber = (String) generalMap.get("bedNumber");
					departmentId = (Integer) generalMap.get("departmentId");
					bedStatusId = (Integer) generalMap.get("bedStatusId");
					adNo = (String) generalMap.get("adNo");
					dietType = (String) generalMap.get("dietType");
					attached = (String) generalMap.get("attached");
					changedDate = (Date) generalMap.get("changedDate");
					currentTime = (String) generalMap.get("currentTime");
					int userId=(Integer)generalMap.get(RequestConstants.USER_ID);

					MasBed masBed = (MasBed) getHibernateTemplate()
							.get(MasBed.class, bedId);

					masBed.setId(bedId);
					masBed.setBedNo(bedNumber);

					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(departmentId);
					masBed.setDepartment(masDepartment);

					MasBedStatus masBedStatus = new MasBedStatus();
					masBedStatus.setId(bedStatusId);
					masBed.setBedStatus(masBedStatus);

				

					masBed.setDietType(dietType);
					masBed.setAdNo(adNo);
					masBed.setAttached(attached);
					
					masBed.setFlag("OT");
					
					masBed.setStatus("y");
					Users users=new Users();
					users.setId(userId);
					masBed.setLastChgBy(users);
					masBed.setLastChgDate(changedDate);
					masBed.setLastChgTime(currentTime);
					
					
					Criteria criteria=session.createCriteria(OtBed.class)
							.add(Restrictions.eq("Bed.Id", bedId));
							 otBedList=criteria.list();
					if(otBedList.size()>0)
					{
						OtBed otBed = new OtBed();
						HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
						int otBedId = otBedList.get(0).getId();
						otBed = (OtBed) hbt.load(
								OtBed.class, otBedId);
						
										 otBed.setBed(masBed);
					 
					 MasOt masOt = new MasOt();
					 masOt.setId(otId);
					 otBed.setOt(masOt);
					hbt.update(otBed);
					}
					try {
						org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
						hbt.update(masBed);
						dataUpdated = true;
					} catch (Exception e) {
						e.printStackTrace();
					}
					return dataUpdated;
				}
				
				public Map checkForExistingMastersForHospital(Map<String, Object> generalMap) {

					Map<String, Object> map = new HashMap<String, Object>();
					List duplicateMastersList = new ArrayList();
					List duplicateGeneralNameList = new ArrayList();
					List duplicateGeneralCodeList = new ArrayList();
					List duplicateGeneralAddressList = new ArrayList();
					int id = 0;
					int hospitalid=0;
					String pojoPropertyCode = "";
					String pojoPropertyAddress = "";
					String pojoPropertyName = "";
					if (generalMap.get("id") != null) {
						id = (Integer) generalMap.get("id");
					}
					hospitalid=(Integer)generalMap.get("hospitalid");
					String name = (String) generalMap.get("name");
					String pojoName = (String) generalMap.get("pojoName");
					if (generalMap.get("pojoPropertyName") != null) {
						pojoPropertyName = (String) generalMap.get("pojoPropertyName");
					}

					if (generalMap.get("pojoPropertyCode") != null) {
						pojoPropertyCode = (String) generalMap.get("pojoPropertyCode");
					}
					if (generalMap.get("pojoPropertyAddress") != null) {
						pojoPropertyAddress = (String) generalMap
								.get("pojoPropertyAddress");
					}
			System.out.println("pojoPropertyCode  "+pojoPropertyCode);
			System.out.println("pojoPropertyName  "+pojoPropertyName);
			System.out.println("pojoName  "+pojoName);
					if (generalMap.get("flag") == null) {

						int code = Integer.parseInt(generalMap.get("code").toString());
						String address = (String) generalMap.get("address");
						if (!pojoPropertyCode.equals("")) {
							duplicateGeneralCodeList = getHibernateTemplate().find(
									"from jkt.hms.masters.business." + pojoName
											+ " as g where g." + pojoPropertyCode + " ='"
											+ code + "' and " + pojoPropertyName + " ='"
											+ name + "' and g.Hospital"+"='"+hospitalid+"'");
						}

					} else if (generalMap.get("flag") != null) {
						duplicateMastersList = getHibernateTemplate().find(
								"from jkt.hms.masters.business." + pojoName
										+ " as g where g." + pojoPropertyName + " = '"
										+ name + "' and g.Id != '" + id+"' and g.Hospital"+"='"+hospitalid+"' ");
					}
					map.put("duplicateGeneralNameList", duplicateGeneralNameList);
					map.put("duplicateGeneralCodeList", duplicateGeneralCodeList);
					map.put("duplicateGeneralAddressList", duplicateGeneralAddressList);
					map.put("duplicateMastersList", duplicateMastersList);

					return map;
				}

			
}
