package jkt.hms.masters.dataservice;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.CommutationWeightage;
import jkt.hms.masters.business.GroupMaster;
import jkt.hms.masters.business.Holidaycalendar;
import jkt.hms.masters.business.HrMasCourse;
import jkt.hms.masters.business.HrMasInstitute;
import jkt.hms.masters.business.HrMasLeave;
import jkt.hms.masters.business.HrMasQualification;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDepartmentType;
import jkt.hms.masters.business.MasDesignation;
import jkt.hms.masters.business.MasDivision;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasLocation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasTransactionType;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.HMSUtil;

import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SystemRelatedMasterDataServiceImpl extends HibernateDaoSupport
		implements SystemRelatedMasterDataService {
	Map<String, Object> map = new HashMap<String, Object>();

	// ------------------------------------------ Department Type
	// -------------------------------
	public boolean addDepartmentType(MasDepartmentType masDepartmentType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDepartmentType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDepartmentTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartmentType> searchDepartmentTypeList = new ArrayList<MasDepartmentType>();
		Session session=(Session)getSession();
		/*searchDepartmentTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartmentType ");
		*/
		searchDepartmentTypeList=session.createCriteria(MasDepartmentType.class).list();
		map.put("searchDepartmentTypeList", searchDepartmentTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDepartmentType(String departmentTypeCode,
			String departmentTypeName) {
		List<MasDepartmentType> searchDepartmentTypeList = new ArrayList<MasDepartmentType>();
		Map<String, Object> departmentTypeFieldsMap = new HashMap<String, Object>();
		Session session=(Session)getSession();
		try {
			if ((departmentTypeName != null) || (departmentTypeCode == null)) {

				/*searchDepartmentTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDepartmentType imc where imc.DepartmentTypeName like '"
										+ departmentTypeName
										+ "%' order by imc.DepartmentTypeName");
				
				*/
				searchDepartmentTypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.like("DepartmentTypeName","%"+ departmentTypeName+"%"))
				.addOrder(Order.asc("DepartmentTypeName")).list();
			} else {
				/*searchDepartmentTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDepartmentType imc where imc.DepartmentTypeCode like '"
										+ departmentTypeCode
										+ "%' order by imc.DepartmentTypeCode");
				*/
				searchDepartmentTypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.like("DepartmentTypeCode","%"+ departmentTypeCode+"%"))
				.addOrder(Order.asc("DepartmentTypeCode")).list();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		departmentTypeFieldsMap.put("searchDepartmentTypeList",
				searchDepartmentTypeList);
		return departmentTypeFieldsMap;

	}

	public boolean editDepartmentTypeToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String departmentTypeName = "";
		@SuppressWarnings("unused")
		String departmentTypeCode = "";
		int departmentTypeId = 0;
		String changedBy = "";
		departmentTypeId = (Integer) generalMap.get("id");
		departmentTypeCode = (String) generalMap.get("departmentTypeCode");
		departmentTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDepartmentType masDepartmentType = (MasDepartmentType) getHibernateTemplate()
				.load(MasDepartmentType.class, departmentTypeId);

		masDepartmentType.setId(departmentTypeId);
		masDepartmentType.setDepartmentTypeName(departmentTypeName);
		masDepartmentType.setLastChgBy(changedBy);
		masDepartmentType.setLastChgDate(currentDate);
		masDepartmentType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDepartmentType);
		dataUpdated = true;
		return dataUpdated;
	}

	public boolean deleteDepartmentType(int departmentTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDepartmentType masDepartmentType = new MasDepartmentType();
		masDepartmentType = (MasDepartmentType) getHibernateTemplate().load(
				MasDepartmentType.class, departmentTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDepartmentType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDepartmentType.setStatus("y");
				dataDeleted = false;
			}
		}
		masDepartmentType.setLastChgBy(changedBy);
		masDepartmentType.setLastChgDate(currentDate);
		masDepartmentType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDepartmentType);
		return dataDeleted;
	}

	// ------------------------------------------ Transaction Type
	// --------------------------------------------
	public boolean addTransactionType(MasTransactionType masTransactionType) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masTransactionType);
		successfullyAdded = true;
		return successfullyAdded;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showTransactionTypeJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTransactionType> searchTransactionTypeList = new ArrayList<MasTransactionType>();
		searchTransactionTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasTransactionType ");
		map.put("searchTransactionTypeList", searchTransactionTypeList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchTransactionType(
			String transactionTypeCode, String transactionTypeName) {
		List<MasTransactionType> searchTransactionTypeList = new ArrayList<MasTransactionType>();
		Map<String, Object> transactionTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((transactionTypeName != null) || (transactionTypeCode == null)) {

				searchTransactionTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasTransactionType imc where imc.TransactionTypeName like '"
										+ transactionTypeName
										+ "%' order by imc.TransactionTypeName");
			} else {
				searchTransactionTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasTransactionType imc where imc.TransactionTypeCode like '"
										+ transactionTypeCode
										+ "%' order by imc.TransactionTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		transactionTypeFieldsMap.put("searchTransactionTypeList",
				searchTransactionTypeList);
		return transactionTypeFieldsMap;
	}

	public boolean editTransactionTypeToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String transactionTypeName = "";
		@SuppressWarnings("unused")
		String transactionTypeCode = "";
		int transactionTypeId = 0;
		String changedBy = "";
		transactionTypeId = (Integer) generalMap.get("id");
		transactionTypeCode = (String) generalMap.get("transactionTypeCode");
		transactionTypeName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasTransactionType masTransactionType = (MasTransactionType) getHibernateTemplate()
				.load(MasTransactionType.class, transactionTypeId);

		masTransactionType.setId(transactionTypeId);
		masTransactionType.setTransactionTypeName(transactionTypeName);
		masTransactionType.setLastChgBy(changedBy);
		masTransactionType.setLastChgDate(currentDate);
		masTransactionType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masTransactionType);
		dataUpdated = true;
		return dataUpdated;

	}

	public boolean deleteTransactionType(int transactionTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasTransactionType masTransactionType = new MasTransactionType();
		masTransactionType = (MasTransactionType) getHibernateTemplate().load(
				MasTransactionType.class, transactionTypeId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masTransactionType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masTransactionType.setStatus("y");
				dataDeleted = false;
			}
		}
		masTransactionType.setLastChgBy(changedBy);
		masTransactionType.setLastChgDate(currentDate);
		masTransactionType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masTransactionType);
		return dataDeleted;

	}

	// ---------------------------------- Frequency
	// -------------------------------------

	public boolean addFrequency(MasFrequency masFrequency) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masFrequency);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteFrequency(int frequencyId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasFrequency masFrequency = new MasFrequency();
		masFrequency = (MasFrequency) getHibernateTemplate().load(
				MasFrequency.class, frequencyId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masFrequency.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masFrequency.setStatus("y");
				dataDeleted = false;
			}
		}
		masFrequency.setLastChgBy(changedBy);
		masFrequency.setLastChgDate(currentDate);
		masFrequency.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masFrequency);
		return dataDeleted;
	}

	public boolean editFrequencyToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String frequencyName = "";
		@SuppressWarnings("unused")
		String frequencyCode = "";
		int frequencyId = 0;
		String changedBy = "";
		int orderNo=0;
		BigDecimal fvalue = null;
		frequencyId = (Integer) generalMap.get("id");
		frequencyCode = (String) generalMap.get("frequencyCode");
		frequencyName = (String) generalMap.get("name");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		orderNo=  (Integer) generalMap.get("orderNo");
		fvalue=  (BigDecimal) generalMap.get("fvalue");
		MasFrequency masFrequency = (MasFrequency) getHibernateTemplate().load(
				MasFrequency.class, frequencyId);

		masFrequency.setId(frequencyId);
		masFrequency.setFrequencyName(frequencyName);
		masFrequency.setOrderNo(orderNo);
		masFrequency.setFeq(fvalue);
		masFrequency.setLastChgBy(changedBy);
		masFrequency.setLastChgDate(currentDate);
		masFrequency.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masFrequency);
		dataUpdated = true;
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchFrequency(String frequencyCode,
			String frequencyName) {

		List<MasFrequency> searchFrequencyList = new ArrayList<MasFrequency>();
		Map<String, Object> frequencyFieldsMap = new HashMap<String, Object>();
		Session session=(Session)getSession(); 
		try {
			if ((frequencyName != null) || (frequencyCode == null)) {
/*				searchFrequencyList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasFrequency imc where imc.FrequencyName like '"
								+ frequencyName
								+ "%' order by imc.FrequencyName");
				
*/				
				searchFrequencyList=session.createCriteria(MasFrequency.class).add(Restrictions.like("FrequencyName","%"+ frequencyName+"%")).list();
				
				
			} else {
				/*searchFrequencyList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasFrequency imc where imc.FrequencyCode like '"
								+ frequencyCode
								+ "%' order by imc.FrequencyCode");*/
				searchFrequencyList=session.createCriteria(MasFrequency.class).add(Restrictions.like("FrequencyCode","%"+ frequencyCode+"%")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		frequencyFieldsMap.put("searchFrequencyList", searchFrequencyList);
		return frequencyFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showFrequencyJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasFrequency> searchFrequencyList = new ArrayList<MasFrequency>();
		Session session=(Session)getSession();
		/*searchFrequencyList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasFrequency ");
		*/
		searchFrequencyList = session.createCriteria(MasFrequency.class).list();
		map.put("searchFrequencyList", searchFrequencyList);
		return map;
	}

	// ------------------------------------------- Department
	// -----------------------------

	public boolean addDepartment(MasDepartment masDepartment) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDepartment);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteDepartment(int departmentId,
			Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasDepartment masDepartment = new MasDepartment();
		masDepartment = (MasDepartment) getHibernateTemplate().load(
				MasDepartment.class, departmentId);
		@SuppressWarnings("unused")
		Integer departmentTypeId = masDepartment.getDepartmentType().getId();
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		Session session=(Session)getSession(); 

		if (generalMap.get("flag") != null) {
			@SuppressWarnings("unused")
/*			List departmentTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartmentType as isc where isc.Id='"
							+ departmentId + "' and isc.Status='y'");
			
*/			List departmentTypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("Id", departmentId)).add(Restrictions.eq("Status", "y")).list();
			
			@SuppressWarnings("unused")
			/*List costCenterLsit = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasCostCenter as isc where isc.Id='"
							+ departmentId + "' and isc.Status='y'");*/
			
			List costCenterLsit = session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Id", departmentId)).add(Restrictions.eq("Status", "y")).list();
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
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDepartment);
		return dataDeleted;

	}

	public boolean editDepartmentToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int departmentTypeId = 0;
		int costCenterId = 0;
		int divisionId=0;
		String deptNo="";
		String departmentName = "";
		@SuppressWarnings("unused")
		String departmentCode = "";
		int departmentId = 0;
		String changedBy = "";
		//String breadRequired = "";
		departmentId = (Integer) generalMap.get("id");
		departmentCode = (String) generalMap.get("departmentCode");
		departmentName = (String) generalMap.get("name");
		deptNo = (String) generalMap.get("deptNo");
		//breadRequired = (String) generalMap.get("breadRequired");
		departmentTypeId = (Integer) generalMap.get("departmentTypeId");
		costCenterId = (Integer) generalMap.get("costCenterId");
		divisionId = (Integer) generalMap.get("divisionId");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDepartment masDepartment = (MasDepartment) getHibernateTemplate()
				.load(MasDepartment.class, departmentId);

		masDepartment.setId(departmentId);
		masDepartment.setDepartmentName(departmentName);

		MasDepartmentType masDepartmentType = new MasDepartmentType();
		masDepartmentType.setId(departmentTypeId);
		masDepartment.setDepartmentType(masDepartmentType);
		//masDepartment.setBreadRequired(breadRequired);
		MasCostCenter masCostCenter = new MasCostCenter();
		masCostCenter.setId(costCenterId);
		//masDepartment.setCostCenter(masCostCenter);

		
		MasDivision masDivision = new MasDivision();
		masDivision.setId(divisionId);
		masDepartment.setDivision(masDivision);
		masDepartment.setDepartmentNo(deptNo);
		masDepartment.setLastChgBy(changedBy);
		masDepartment.setLastChgDate(currentDate);
		masDepartment.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDepartment);
		dataUpdated = true;
		return dataUpdated;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDepartment(String departmentCode,
			String departmentName,int divisionIdSearch) {
		List<MasDepartment> searchDepartmentList = new ArrayList<MasDepartment>();
		List departmentTypeList = null;
		List costCenterList = null;
		Map<String, Object> departmentFieldsMap = new HashMap<String, Object>();
		List gridCostCenterList = null;
		List gridDepartmentTypeList = null;
		Session session=(Session)getSession();
		List<MasDivision> gridDivisionList = new ArrayList<MasDivision>();
		List<MasDivision> divisionList = new ArrayList<MasDivision>();
		try {
			System.out.println(divisionIdSearch+"------------");
			if ((departmentName != null) && (departmentCode == null) && (divisionIdSearch==0)) {

/*				searchDepartmentList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDepartment as i where i.DepartmentName like '"
										+ departmentName
										+ "%' order by i.DepartmentName");
				
*/				
				searchDepartmentList=session.createCriteria(MasDepartment.class).add(Restrictions.like("DepartmentName","%"+departmentName+"%")).addOrder(Order.asc("DepartmentName"))	.list();			
			} 
			
			if ((departmentName == null) &&  (departmentCode == null) && (divisionIdSearch!=0)) {
				searchDepartmentList=session.createCriteria(MasDepartment.class).createAlias("Division", "d").add(Restrictions.eq("d.Id", divisionIdSearch)).addOrder(Order.asc("DepartmentCode")).list();
			}
				if ((departmentCode != null) && (departmentName == null) && (divisionIdSearch==0)) {
				/*searchDepartmentList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDepartment as i where i.DepartmentCode like '"
										+ departmentCode
										+ "%' order by i.DepartmentCode");
				*/
				searchDepartmentList=session.createCriteria(MasDepartment.class).add(Restrictions.like("DepartmentCode","%"+departmentCode+"%")).addOrder(Order.asc("DepartmentCode")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		departmentTypeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasDepartmentType as isc where isc.Status = 'y'");
		gridDepartmentTypeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasDepartmentType as isc");

		costCenterList = getHibernateTemplate()	.find("from jkt.hms.masters.business.MasCostCenter as isc where isc.Status = 'y'");
		gridCostCenterList = getHibernateTemplate().find("from jkt.hms.masters.business.MasCostCenter as isc");

		
		divisionList=session.createCriteria(MasDivision.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("DivisionName")).list();
		gridDivisionList=session.createCriteria(MasDivision.class).list();
		
		departmentFieldsMap.put("gridDepartmentTypeList",gridDepartmentTypeList);
		departmentFieldsMap.put("gridCostCenterList", gridCostCenterList);
		departmentFieldsMap.put("searchDepartmentList", searchDepartmentList);
		departmentFieldsMap.put("departmentTypeList", departmentTypeList);
		departmentFieldsMap.put("costCenterList", costCenterList);
		
		departmentFieldsMap.put("divisionList", divisionList);
		departmentFieldsMap.put("gridDivisionList", gridDivisionList);
		return departmentFieldsMap;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDepartmentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> searchDepartmentList = new ArrayList<MasDepartment>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasDivision> divisionList = new ArrayList<MasDivision>();
		List<MasDepartmentType> departmentTypeList = new ArrayList<MasDepartmentType>();

		List<MasCostCenter> gridCostCenterList = new ArrayList<MasCostCenter>();
		List<MasDivision> gridDivisionList = new ArrayList<MasDivision>();
		List<MasDepartmentType> gridDepartmentTypeList = new ArrayList<MasDepartmentType>();
		Session session=(Session)getSession();
		
		/*searchDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment ");
		*/
		searchDepartmentList=session.createCriteria(MasDepartment.class).
				//add(Restrictions.eq("Status", "y")).
				list();
		
		/*departmentTypeList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartmentType as isc where isc.Status = 'y'");*/
		
		departmentTypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("Status", "y")).list();
		/*gridDepartmentTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartmentType as isc");*/
		gridDepartmentTypeList=session.createCriteria(MasDepartmentType.class).add(Restrictions.eq("Status", "y")).list();
		
		/*costCenterList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasCostCenter as isc where isc.Status = 'y' order by isc.CostCenterName asc");*/
		
		costCenterList=session.createCriteria(MasCostCenter.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("CostCenterName")).list();
		divisionList=session.createCriteria(MasDivision.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DivisionName")).list();
		/*gridCostCenterList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasCostCenter as isc");
		
		*/
		gridCostCenterList=session.createCriteria(MasCostCenter.class).list();
		gridDivisionList=session.createCriteria(MasDivision.class).list();
		map.put("searchDepartmentList", searchDepartmentList);
		map.put("gridDepartmentTypeList", gridDepartmentTypeList);
		map.put("gridCostCenterList", gridCostCenterList);

		map.put("departmentTypeList", departmentTypeList);
		map.put("costCenterList", costCenterList);
		
		map.put("divisionList", divisionList);
		map.put("gridDivisionList", gridDivisionList);

		return map;
	}

	// ----------------------------Designation
	// Master-----------------------------

	public Map<String, Object> showDesignationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> searchDesignationList = new ArrayList<MasDepartment>();
		List<GroupMaster> groupMasterList = new ArrayList<GroupMaster>();
		searchDesignationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDesignation ");
		groupMasterList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.GroupMaster");
		map.put("searchDesignationList", searchDesignationList);
		map.put("groupMasterList", groupMasterList);
		return map;
	}

	public boolean addDesignation(MasDesignation masDesignation) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masDesignation);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchDesignation(String designationCode,
			String designation) {
		List<MasDesignation> searchDesignationList = new ArrayList<MasDesignation>();
		List<GroupMaster> groupMasterList = new ArrayList<GroupMaster>();
		Map<String, Object> fieldMap = new HashMap<String, Object>();

		try {
			if ((designation != null) || (designationCode == null)) {

				searchDesignationList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDesignation as i where i.DesignationName like '"
										+ designation
										+ "%' order by i.DesignationName");
			} else {
				searchDesignationList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasDesignation as i where i.DesignationCode like '"
										+ designationCode
										+ "%' order by i.DesignationCode");
			}
			groupMasterList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.GroupMaster");
		} catch (Exception e) {
			e.printStackTrace();
		}
		fieldMap.put("groupMasterList", groupMasterList);
		fieldMap.put("searchDesignationList", searchDesignationList);

		return fieldMap;

	}

	public boolean deleteDesignation(int designationId,
			Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		MasDesignation masDesignation = (MasDesignation) getHibernateTemplate()
				.load(MasDesignation.class, designationId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {

			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masDesignation.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masDesignation.setStatus("y");
				dataDeleted = false;
			}
		}
		masDesignation.setLastChgBy(changedBy);
		masDesignation.setLastChgDate(currentDate);
		masDesignation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDesignation);
		return dataDeleted;

	}

	public boolean editDesignation(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		String designation = "";
		@SuppressWarnings("unused")
		String designationCode = "";
		int designationId = 0;
		String changedBy = "";
		int groupMasterId = 0;
		String type = "";
		designationId = (Integer) generalMap.get("id");
		designationCode = (String) generalMap.get("designationCode");
		designation = (String) generalMap.get("name");
		groupMasterId = (Integer) generalMap.get("groupMasterId");
		type = (String) generalMap.get("type");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		MasDesignation masDesignation = (MasDesignation) getHibernateTemplate()
				.load(MasDesignation.class, designationId);

		// masDesignation.setId(designationId);
		masDesignation.setDesignationName(designation);
		masDesignation.setDesignationCode(designationCode);
		GroupMaster groupMaster = new GroupMaster();
		groupMaster.setId(groupMasterId);
		masDesignation.setGroup(groupMaster);
		masDesignation.setType(type);
		masDesignation.setLastChgBy(changedBy);
		masDesignation.setLastChgDate(currentDate);
		masDesignation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masDesignation);
		dataUpdated = true;
		return dataUpdated;

	}

	// -------------------------Group
	// Master-------------------------------------

	public Map<String, Object> showGroupMaster() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<GroupMaster> searchGroupList = new ArrayList<GroupMaster>();

		searchGroupList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.GroupMaster ");

		map.put("searchGroupList", searchGroupList);

		return map;
	}

	public boolean addGroupMaster(GroupMaster groupMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(groupMaster);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public Map<String, Object> searchGroupMaster(String groupCode,
			String groupName) {
		List<GroupMaster> searchGroupList = new ArrayList<GroupMaster>();

		Map<String, Object> fieldMap = new HashMap<String, Object>();

		try {
			if ((groupName != null) || (groupCode == null)) {

				searchGroupList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.GroupMaster as i where i.GroupName like '"
								+ groupName + "%' order by i.GroupName");
			} else {
				searchGroupList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.GroupMaster as i where i.GroupCode like '"
								+ groupCode + "%' order by i.GroupCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		fieldMap.put("searchGroupList", searchGroupList);

		return fieldMap;

	}

	public boolean deleteGroupMaster(int groupId, Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		GroupMaster groupMaster = (GroupMaster) getHibernateTemplate().load(
				GroupMaster.class, groupId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {

			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				groupMaster.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				groupMaster.setStatus("y");
				dataDeleted = false;
			}
		}
		groupMaster.setLastChgBy(changedBy);
		groupMaster.setLastChgDate(currentDate);
		groupMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(groupMaster);
		return dataDeleted;

	}

	public boolean editGroupMaster(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		String groupName = "";

		String groupCode = "";
		int groupId = 0;
		String changedBy = "";
		int retirementAge = 0;
		groupId = (Integer) generalMap.get("id");
		groupCode = (String) generalMap.get("groupCode");
		groupName = (String) generalMap.get("name");
		retirementAge = (Integer) generalMap.get("retirementAge");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		GroupMaster groupMaster = (GroupMaster) getHibernateTemplate().load(
				GroupMaster.class, groupId);

		groupMaster.setGroupName(groupName);
		groupMaster.setGroupCode(groupCode);
		groupMaster.setRetirementAge(retirementAge);
		groupMaster.setLastChgBy(changedBy);
		groupMaster.setLastChgDate(currentDate);
		groupMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(groupMaster);
		dataUpdated = true;
		return dataUpdated;

	}

	// ----------------------Commutation Weightage
	// master-------------------------------

	public Map<String, Object> showCommutationWeightageMasterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<CommutationWeightage> searchCommutationList = new ArrayList<CommutationWeightage>();

		searchCommutationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.CommutationWeightage ");

		map.put("searchCommutationList", searchCommutationList);

		return map;
	}

	public boolean addCommutationWeightageMaster(
			CommutationWeightage commutationWeightage) {
		boolean successfullyAdded = false;
		//System.out.println("in add commutation weightage master in ds layer");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(commutationWeightage);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchCommutationWeightageMaster(
			String weightageCode, int age) {
		List<CommutationWeightage> searchCommutationList = new ArrayList<CommutationWeightage>();

		Map<String, Object> fieldMap = new HashMap<String, Object>();

		try {
			if ((weightageCode != null) || (age == 0)) {

				searchCommutationList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.CommutationWeightage as i where i.CommutationWeightageCode like '"
										+ weightageCode
										+ "%' order by i.CommutationWeightageCode");
			} else {
				searchCommutationList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.CommutationWeightage as i where i.Age= '"
								+ age + "' ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		fieldMap.put("searchCommutationList", searchCommutationList);

		return fieldMap;

	}

	public boolean deleteCommutationWeightage(int commutationId,
			Map<String, Object> generalMap) {

		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		CommutationWeightage commutationWeightage = (CommutationWeightage) getHibernateTemplate()
				.load(CommutationWeightage.class, commutationId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");

		if (generalMap.get("flag") != null) {

			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				commutationWeightage.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				commutationWeightage.setStatus("y");
				dataDeleted = false;
			}
		}
		commutationWeightage.setLastChgBy(changedBy);
		commutationWeightage.setLastChgDate(currentDate);
		commutationWeightage.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(commutationWeightage);
		return dataDeleted;

	}

	public boolean editCommutationWeightage(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		int age = 0;
		@SuppressWarnings("unused")
		String weightageCode = "";
		int commutationId = 0;
		String changedBy = "";
		BigDecimal cmValue = null;
		commutationId = (Integer) generalMap.get("id");
		weightageCode = (String) generalMap.get("weightageCode");
		age = (Integer) generalMap.get("age");
		cmValue = (BigDecimal) generalMap.get("cmValue");
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		CommutationWeightage commutationWeightage = (CommutationWeightage) getHibernateTemplate()
				.load(CommutationWeightage.class, commutationId);

		commutationWeightage.setAge(age);
		commutationWeightage.setCommutationWeightageCode(weightageCode);
		commutationWeightage.setCmValue(cmValue);
		commutationWeightage.setLastChgBy(changedBy);
		commutationWeightage.setLastChgDate(currentDate);
		commutationWeightage.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(commutationWeightage);
		dataUpdated = true;
		return dataUpdated;

	}
	//---------------------- Transaction Sequence Master By Mansi

	@Override
	public boolean addTransactionSequence(TransactionSequence transactionSequence) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(transactionSequence);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@Override
	public boolean editTransactionSequence(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int tSqNo=0;
		String tSqName="";
		String tPrefix="";
		String tableName="";
		int month=0;
		int serviceTypeId=0;
		int tSqId = 0;
		String changedBy = "";
		tSqId = (Integer) generalMap.get("id");
		tSqNo = (Integer) generalMap.get("tSqNo");
		month = (Integer) generalMap.get("month");
		serviceTypeId = (Integer) generalMap.get("serviceTypeId");
		
		tableName = (String) generalMap.get("tableName");
		tSqName = (String) generalMap.get("tSqName");
		tPrefix = (String) generalMap.get("tPrefix");
		
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		TransactionSequence transactionSequence = (TransactionSequence) getHibernateTemplate()
				.load(TransactionSequence.class, tSqId);

		transactionSequence.setId(tSqId);
		
		transactionSequence.setTransactionSequenceName(tSqName);
		transactionSequence.setTablename(tableName);
		transactionSequence.setTransactionSequenceNumber(tSqNo);
		transactionSequence.setMonth(month);
		transactionSequence.setTransactionPrefix(tPrefix);
		
	/*	MasServiceType masServiceType = new MasServiceType(); 
		masServiceType.setId(serviceTypeId);
		transactionSequence.setServiceType(masServiceType);*/
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(transactionSequence);
		dataUpdated = true;
		return dataUpdated;
	}

	@Override
	public Map<String, Object> existingMasters(Map<String, Object> generalMap) {
		List<TransactionSequence> transactionSequenceList = new ArrayList<TransactionSequence>();
		Map<String, Object> departmentTypeFieldsMap = new HashMap<String, Object>();
		
		String tSqName="";
		String tPrefix="";
		String tableName="";
		int serviceTypeId=0;
	
		
		
		serviceTypeId = (Integer) generalMap.get("serviceTypeId");
		tableName = (String) generalMap.get("tableName");
		tSqName = (String) generalMap.get("tSqName");
		tPrefix = (String) generalMap.get("tPrefix");
		
		Session session = (Session) getSession();
		System.out.println("tSqName-->"+tSqName);
		System.out.println("tPrefix--->"+tPrefix);
	//	System.out.println("serviceTypeId--->"+serviceTypeId);
		System.out.println("tableName--->"+tableName);
		try {
		
				transactionSequenceList = session.createCriteria(TransactionSequence.class).add(
						Restrictions.eq("Tablename", tableName)).add(
						Restrictions.eq("TransactionSequenceName", tSqName)).add(Restrictions.eq("TransactionPrefix", tPrefix)).list();
				
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}

		departmentTypeFieldsMap.put("transactionSequenceList",
				transactionSequenceList);
		return departmentTypeFieldsMap;

	}

	@Override
	public Map<String, Object> showTransactionSequenceJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		List<TransactionSequence> searchTransactionSequenceList = new ArrayList<TransactionSequence>();
		searchTransactionSequenceList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.TransactionSequence ");
		map.put("searchTransactionSequenceList", searchTransactionSequenceList);
		return map;

		
	}
	
	
	public Map<String, Object> showLeaveJsp() {
		Map<String,Object>  map=new HashMap<String,Object>();
		List<HrMasLeave>  masLeaveList=new ArrayList<HrMasLeave>();
		List<MasHospital> hospitalList=new ArrayList<MasHospital>();
		masLeaveList=getHibernateTemplate().find( "from jkt.hms.masters.business.HrMasLeave ");
		hospitalList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasHospital as mh where mh.Status = 'y'");
	
		map.put("masLeaveList",masLeaveList);
		map.put("hospitalList",hospitalList);
		
		return map;
	}
	public Map<String, Object> addLeave(HrMasLeave hrMasLeave) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLeave> existingDescriptionList = new ArrayList<HrMasLeave>();
		List<HrMasLeave> masLeaveList = new ArrayList<HrMasLeave>(); 
		List<MasHospital> hospitalList=new ArrayList<MasHospital>();
		Session session = (Session)getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String description = hrMasLeave.getDescription();
		existingDescriptionList = getHibernateTemplate().find("from jkt.hms.masters.business.HrMasLeave as msc where msc.Description = '"+description+"'");
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).list();
		System.out.println("hospitalList--in data service add---"+hospitalList.size());
		if(existingDescriptionList.size()>0){
			message = "Record already exist...";
		}else{
			hbt.save(hrMasLeave);
			message = "Record save successfully !!";
		}
		masLeaveList = session.createCriteria(HrMasLeave.class).add(Restrictions.eq("Status", "y")).list();
		map.put("masLeaveList", masLeaveList);
		map.put("existingDescriptionList", existingDescriptionList);
		map.put("hospitalList", hospitalList);
		map.put("message", message);
		return map;
	}
	public Map<String, Object> editLeave(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLeave> existingDescriptionList = new ArrayList<HrMasLeave>();
		List<HrMasLeave> masLeaveList = new ArrayList<HrMasLeave>(); 
		List<MasHospital> hospitalList=new ArrayList<MasHospital>();
		Session session = (Session)getSession();
		int leaveId = 0;
		if (generalMap.get("leaveId")!= null) {
			leaveId = (Integer)generalMap.get("leaveId"); 
		}
		int hospitalId=0;
		if (generalMap.get("hospitalId")!= null) {
			hospitalId = (Integer)generalMap.get("hospitalId"); 
		}
		String description = "";
		if (generalMap.get("description")!= null) {
			description = (String)generalMap.get("description"); 
		}
		String changedBy ="";
		if (generalMap.get("changedBy")!= null) {
			changedBy = (String)generalMap.get("changedBy"); 
		}	
	
		Date currentDate = null; 
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate"); 
		}
		String currentTime = "";
		if (generalMap.get("currentTime")!= null) {
			currentTime = (String)generalMap.get("currentTime"); 
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasLeave hrMasLeave = (HrMasLeave)hbt.load(HrMasLeave.class, leaveId);
		hrMasLeave.setDescription(description);
		
		/*MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		hrMasLeave.setCompany(masHospital);*/
		
		Users user= new Users();
		user.setId(Integer.parseInt(changedBy));
		hrMasLeave.setLastChgBy(user);
		
		/*hrMasLeave.setLastChgBy(changedBy);*/
		hrMasLeave.setLastChgDate(currentDate);
		hrMasLeave.setLastChgTime(currentTime);
		existingDescriptionList = getHibernateTemplate().find("from jkt.hms.masters.business.HrMasLeave as msc where msc.Description = '"+description+"' and msc.Id != '"+leaveId+"'");
		masLeaveList = session.createCriteria(HrMasLeave.class).add(Restrictions.eq("Status", "y")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).list();
		String message = "";
		if(existingDescriptionList.size()>0){
			message = "Record already exist";
		}else{
			hbt.update(hrMasLeave);
			message = "Record update successfully !!";
		}
		
		map.put("masLeaveList", masLeaveList);
		map.put("existingDescriptionList", existingDescriptionList);
		map.put("hospitalList", hospitalList);
		map.put("message", message);
		return map;
		}

	public Map<String, Object> searchLeave(String description) {
		List<HrMasLeave> masLeaveList=new ArrayList<HrMasLeave>();
		Map<String,Object>  leaveFieldsMap = new HashMap<String,Object>();
		try{
			if((description !=null)){
				
				masLeaveList=getHibernateTemplate().find("from jkt.hms.masters.business.HrMasLeave imc where imc.Description like '"+ description+"%' order by imc.Description");
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
			leaveFieldsMap.put("masLeaveList",masLeaveList);
		return leaveFieldsMap;	
	}
	public Map<String, Object> deleteLeave(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLeave> masLeaveList = new ArrayList<HrMasLeave>();
		List<HrMasLeave> hospitalList = new ArrayList<HrMasLeave>();
		Session session = (Session)getSession();
		 boolean dataDeleted=false;
		int leaveId = 0;
		if (generalMap.get("leaveId")!= null) {
			leaveId = (Integer)generalMap.get("leaveId"); 
		}
		String changedBy ="";
		if (generalMap.get("changedBy")!= null) {
			changedBy = (String)generalMap.get("changedBy"); 
		}
		Date currentDate = new Date(); 
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate"); 
		}
		String currentTime = "";
		if (generalMap.get("currentTime")!= null) {
			currentTime = (String)generalMap.get("currentTime"); 
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		HrMasLeave hrMasLeave = (HrMasLeave)hbt.load(HrMasLeave.class, leaveId);
		Users user= new Users();
		user.setId(Integer.parseInt(changedBy));
		hrMasLeave.setLastChgBy(user);
		
		/*hrMasLeave.setLastChgBy(changedBy);*/
		hrMasLeave.setLastChgDate(currentDate);
		hrMasLeave.setLastChgTime(currentTime);
		hospitalList=getHibernateTemplate().find("from jkt.hms.masters.business.MasHospital as isc where isc.Id='"+leaveId+"' and isc.Status='y'");
		if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  hrMasLeave.setStatus("n");
			   dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  hrMasLeave.setStatus("y");
				  dataDeleted=false;
			  }
			  hbt.update(hrMasLeave);
		  }
		String message = "";
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		masLeaveList = session.createCriteria(HrMasLeave.class).list();
		map.put("masLeaveList", masLeaveList);
		map.put("hospitalList",hospitalList);
		map.put("message", message);
		return map;
	}
	public Map<String, Object> showHolidayMasterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Holidaycalendar> holidayMasterList = new ArrayList<Holidaycalendar>();
		List<MasLocation> masLocation = new ArrayList<MasLocation>();
		Session session = (Session)getSession();
		holidayMasterList = session.createCriteria(Holidaycalendar.class).list();
		masLocation = session.createCriteria(MasLocation.class).add(Restrictions.eq("Status", "y")).list();
		map.put("holidayMasterList", holidayMasterList);
		map.put("masLocation", masLocation);
		return map;
	}
	public Map<String, Object> addHolidayMaster(Holidaycalendar holidaycalendar) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Holidaycalendar> holidayMasterList = new ArrayList<Holidaycalendar>();
		List<Holidaycalendar> existingHolidayMasterList = new ArrayList<Holidaycalendar>();
		Session session = (Session)getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String year = holidaycalendar.getHolidayListYear();
		SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
		String holidayDate =sdf.format(holidaycalendar.getHolidayDate());
		//String holidayDate =HMSUtil.convertDateToStringWithoutTime(holidaycalendar.getHolidayDate());
		//existingHolidayMasterList = getHibernateTemplate().find("from jkt.hrms.masters.business.Holidaycalendar as hc where hc.HolidayDate = '"+holidayDate+"' and hc.HolidayListYear = '"+year+"'");
		if(existingHolidayMasterList.size()>0){
			message = "Record already exist...";
		}else{
			hbt.save(holidaycalendar);
			message = "Record save successfully !!";
		}
			holidayMasterList = session.createCriteria(Holidaycalendar.class).list();
			map.put("holidayMasterList", holidayMasterList);
			List<MasLocation> masLocation = new ArrayList<MasLocation>();
			masLocation = session.createCriteria(MasLocation.class).add(Restrictions.eq("Status", "y")).list();
			map.put("masLocation", masLocation);
			
			
		map.put("message", message);
		return map;
	}
	public Map<String, Object> editHolidayMaster(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Holidaycalendar> holidayMasterList = new ArrayList<Holidaycalendar>();
		List<Holidaycalendar> existingHolidayMasterList = new ArrayList<Holidaycalendar>();
		Session session = (Session)getSession();
		int holidayMasterId = 0;
		if(generalMap.get("holidayMasterId")!= null){
			holidayMasterId = (Integer)generalMap.get("holidayMasterId");
		}
		String year = "";
		if(generalMap.get("year")!= null){
			year = (String)generalMap.get("year");
		}
		String description = "";
		if(generalMap.get("description")!= null){
			description = (String)generalMap.get("description");
		}
		Date holidayDate = null;
		if(generalMap.get("holidayDate")!= null){
			holidayDate = (Date)generalMap.get("holidayDate");
		}
		String rh= "";
		if(generalMap.get("rh")!= null){
			rh = (String)generalMap.get("rh");
		}
		String changedBy = "";
		if(generalMap.get("changedBy")!= null){
			changedBy = (String)generalMap.get("changedBy");
		}
		Date changedDate= new Date();
		if(generalMap.get("changedDate")!= null){
			changedDate = (Date)generalMap.get("changedDate");
		}
		String changedTime = "";
		if(generalMap.get("changedTime")!= null){
			changedTime = (String)generalMap.get("changedTime");
		}
		int locId=0;
		if(generalMap.get("locId")!= null){
			locId = Integer.parseInt(""+generalMap.get("locId"));
			
			
		}
		System.out.println("loc>>"+locId);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Holidaycalendar holidaycalendar = (Holidaycalendar)hbt.load(Holidaycalendar.class, holidayMasterId);
		holidaycalendar.setTitle(description);
		holidaycalendar.setLastChgBy(changedBy);
		holidaycalendar.setLastChgDate(changedDate);
		holidaycalendar.setLastChgTime(changedTime);
		holidaycalendar.setHolidayDate(holidayDate);
		holidaycalendar.setHolidayListYear(year);
		holidaycalendar.setRh(rh);
		MasLocation ms = new MasLocation();
		 ms.setId(locId);
		 //holidaycalendar.setLocation(ms);
		
		/*existingHolidayMasterList = getHibernateTemplate().find("from jkt.hms.masters.business.Holidaycalendar as hc where hc.HolidayDate = convert(datetime,"+holidayDate+") and hc.HolidayListYear = '"+year+"'");*/
		 existingHolidayMasterList = session.createCriteria(Holidaycalendar.class)
				                     .add(Restrictions.eq("HolidayDate", holidayDate))
				                     .add(Restrictions.eq("HolidayListYear", year)).list();
				
		String message = "";
		if(existingHolidayMasterList.size()>0){
			message = "Record already exist";
		}else{
			hbt.update(holidaycalendar);
			message = "Record update successfully !!";
		}
		
		holidayMasterList = session.createCriteria(Holidaycalendar.class).add(Restrictions.eq("Status", "y")).list();
		List<MasLocation> masLocation = new ArrayList<MasLocation>();
		masLocation = session.createCriteria(MasLocation.class).add(Restrictions.eq("Status", "y")).list();
		map.put("masLocation", masLocation);
		System.out.println("for holiday1>>>>"+masLocation.size());
		map.put("holidayMasterList", holidayMasterList);
		map.put("message", message);
		return map;
	}
	public Map<String, Object> deleteHolidayMaster(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Holidaycalendar> holidayMasterList = new ArrayList<Holidaycalendar>();
		Session session = (Session)getSession();
		boolean dataDeleted=false;
		int holidayMasterId = 0;
		if(generalMap.get("holidayMasterId")!= null){
			holidayMasterId = (Integer)generalMap.get("holidayMasterId");
		}
		String changedBy = "";
		if(generalMap.get("changedBy")!= null){
			changedBy = (String)generalMap.get("changedBy");
		}
		Date changedDate= new Date();
		if(generalMap.get("changedDate")!= null){
			changedDate = (Date)generalMap.get("changedDate");
		}
		String changedTime = "";
		if(generalMap.get("changedTime")!= null){
			changedTime = (String)generalMap.get("changedTime");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Holidaycalendar holidaycalendar = (Holidaycalendar)hbt.load(Holidaycalendar.class, holidayMasterId);
		holidaycalendar.setLastChgBy(changedBy);
		holidaycalendar.setLastChgDate(changedDate);
		holidaycalendar.setLastChgTime(changedTime);
		if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  holidaycalendar.setStatus("n");
			   dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  holidaycalendar.setStatus("y");
				  dataDeleted=false;
			  }
			  hbt.update(holidaycalendar);
		  }
		String message = "";
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		holidayMasterList = session.createCriteria(Holidaycalendar.class).list();
		map.put("holidayMasterList", holidayMasterList);
		map.put("message", message);
		return map;
	}
	public Map<String, Object> searchHolidayMaster(String name, String year) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Holidaycalendar> holidayMasterList = new ArrayList<Holidaycalendar>();
			try{
			if((name!=null) || (year == null)){
				
				holidayMasterList = getHibernateTemplate().find("from jkt.hms.masters.business.Holidaycalendar hc where hc.Title like '"+name+"%' ");
			}
			else{
				holidayMasterList=getHibernateTemplate().find("from jkt.hms.masters.business.Holidaycalendar hc where hc.HolidayListYear like '"+year+"'");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("year", year);
		map.put("name", name);
		map.put("holidayMasterList", holidayMasterList);
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showReligionJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasReligion> searchReligionList = new ArrayList<MasReligion>();
		searchReligionList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasReligion ");
		map.put("searchReligionList", searchReligionList);
		return map;
	}

	
	//*************************************** Start of Course Master By Atul *******************************//
	
	
		@SuppressWarnings("unchecked")
		public Map<String, Object> showCourseMasterJsp() {
			Map<String, Object> map=new HashMap<String, Object>();
			List<HrMasCourse> searchCourseMasterList=new ArrayList<HrMasCourse>();
			
			searchCourseMasterList = getHibernateTemplate().find("from jkt.hms.masters.business.HrMasCourse");
			map.put("searchCourseMasterList", searchCourseMasterList);
			return map;
		}
		
		@SuppressWarnings("unchecked")
		public Map<String, Object> searchCourseMaster(String courseCode,String courseName) {
			List<HrMasCourse> searchCourseMasterList = new ArrayList<HrMasCourse>();
			Map<String, Object> courseMasterFieldsMap =new HashMap<String, Object>();
			
			try {
				if((courseCode !=null)||(courseName ==null)) {
					searchCourseMasterList =getHibernateTemplate().find("from jkt.hms.masters.business.HrMasCourse ms where ms.CourseCode like '"+ courseCode+"%' order by ms.CourseCode");
				}else {
					searchCourseMasterList=getHibernateTemplate().find("from jkt.hms.masters.business.HrMasCourse ms where ms.CourseName like '"+ courseName+"%' order by ms.CourseName");
				}
				}catch(Exception e) {
					e.printStackTrace();
			}
				courseMasterFieldsMap.put("searchCourseMasterList", searchCourseMasterList);
			return courseMasterFieldsMap;
		}
		
		@SuppressWarnings("unchecked")
		public boolean addCourseMaster(HrMasCourse hrMasCourse) {
			boolean successfullyAdded=false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(hrMasCourse);
			successfullyAdded = true;
			return successfullyAdded;
		}

		@SuppressWarnings("unchecked")
		public boolean editCourseMaster(Map<String, Object> map) {
			boolean dataUpdated=false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			String courseCode="";
			String courseName="";
			int hospitalId=0;
			int courseId=0;
						
			String changedBy = "";
			Date changedDate = null;
			String changedTime = "";
			
			try {
			courseId=(Integer)map.get("id");
			hospitalId = (Integer)map.get("hospitalId");
			courseCode=(String)map.get("code");
			courseName=(String)map.get("name");
					
			changedBy = (String)map.get("changedBy");
			currentDate=(Date)map.get("currentDate");
			currentTime=(String)map.get("currentTime");
			HrMasCourse hrMasCourse=(HrMasCourse)getHibernateTemplate().load(HrMasCourse.class,courseId);
			
			hrMasCourse.setId(courseId);
			hrMasCourse.setCourseCode(courseCode);
			hrMasCourse.setCourseName(courseName);
					
					
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasCourse.setCompany(masHospital);
					
			hrMasCourse.setLastChgBy(changedBy);
			hrMasCourse.setLastChgDate(currentDate);
			hrMasCourse.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasCourse);
			dataUpdated = true;
			}catch (Exception e) {
				System.out.println("eXCP in DS "+e);
			}
			return dataUpdated;
		}
		
		@SuppressWarnings("unchecked")
		public boolean deleteCourseMaster(int courseId,Map<String, Object> generalMap) {
			boolean dataDeleted=false;
			  String changedBy = "";
			  Date currentDate = new Date();
			  String currentTime = "";
			  currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			try{
			HrMasCourse hrMasCourse =new HrMasCourse();
			hrMasCourse=(HrMasCourse)getHibernateTemplate().load(HrMasCourse.class,courseId);
		    changedBy = (String)generalMap.get("changedBy");
		    currentDate=(Date)generalMap.get("currentDate");
		    currentTime=(String)generalMap.get("currentTime");
			if (hrMasCourse.getStatus().equals("y")){
					hrMasCourse.setStatus("n");
				dataDeleted=true;
			}else{
				hrMasCourse.setStatus("y");
				dataDeleted=false;
			}
			hrMasCourse.setLastChgBy(changedBy);
			hrMasCourse.setLastChgDate(currentDate);
			hrMasCourse.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasCourse);
			}catch (Exception e) {
				System.out.println("exc in DS "+e);
			}
			return dataDeleted;

		}
		
		public Map checkForExistingMasters(Map<String, Object> generalMap) {
			Map<String,Object> map = new HashMap<String, Object>();
			List duplicateMastersList = new ArrayList();
			List duplicateGeneralNameList = new ArrayList();
			List duplicateGeneralCodeList = new ArrayList();
			List duplicateGeneralAddressList = new ArrayList();
			int id = 0;
			String pojoPropertyCode = "";
			String pojoPropertyAddress = "";
			String pojoPropertyName = "";
			if(generalMap.get("id") != null){
				id = (Integer)generalMap.get("id");
			}
			String name = (String)generalMap.get("name");
			String pojoName = (String)generalMap.get("pojoName");
			if(generalMap.get("pojoPropertyName") != null)
				pojoPropertyName = (String)generalMap.get("pojoPropertyName");
			
			if(generalMap.get("pojoPropertyCode") != null){
				pojoPropertyCode = (String)generalMap.get("pojoPropertyCode");
			}
			if(generalMap.get("pojoPropertyAddress") != null){
				pojoPropertyAddress = (String)generalMap.get("pojoPropertyAddress");
			}
			if(generalMap.get("flag") == null){
				String code = (String)generalMap.get("code");
				String address = (String)generalMap.get("address");
				
				if(!pojoPropertyCode.equals("")){
					duplicateGeneralCodeList = getHibernateTemplate().find("from jkt.hms.masters.business."+pojoName+" as g where g."+pojoPropertyCode+" ='"+code+"'");
				}
				if(!pojoPropertyName.equals("")){
					duplicateGeneralNameList = getHibernateTemplate().find("from jkt.hms.masters.business."+pojoName+" as g where g."+pojoPropertyName+" = '"+name+"'");
				}
				if(!pojoPropertyAddress.equals("")){
					duplicateGeneralAddressList = getHibernateTemplate().find("from jkt.hms.masters.business."+pojoName+" as g where g."+pojoPropertyAddress+" ='"+address+"'");
				}
				
			}
			else if(generalMap.get("flag") != null){
				boolean flag = (Boolean)generalMap.get("flag");
				duplicateMastersList = getHibernateTemplate().find("from jkt.hms.masters.business."+pojoName+" as g where g."+pojoPropertyName+" = '"+name+"' and g.Id != "+id);
			}
			map.put("duplicateGeneralNameList", duplicateGeneralNameList);
			map.put("duplicateGeneralCodeList", duplicateGeneralCodeList);
			map.put("duplicateGeneralAddressList", duplicateGeneralAddressList);
			map.put("duplicateMastersList", duplicateMastersList);

			return map;
		}
		//*************************************** End of Course Master By Atul *******************************//
		
		
		
		//*************************************** Start of Qualification Master By Atul *******************************//
		
		@SuppressWarnings("unchecked")
		public Map<String, Object> showQualificationMasterJsp() {
			Map<String, Object> map=new HashMap<String, Object>();
			List<HrMasQualification> searchQualificationMasterList=new ArrayList<HrMasQualification>();
			
			searchQualificationMasterList = getHibernateTemplate().find("from jkt.hms.masters.business.HrMasQualification");
			map.put("searchQualificationMasterList", searchQualificationMasterList);
			return map;
		}
		
		@SuppressWarnings("unchecked")
		public boolean addQualificationMaster(HrMasQualification hrMasQualification) {
			boolean successfullyAdded=false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(hrMasQualification);
			successfullyAdded = true;
			return successfullyAdded;
		}
		
		@SuppressWarnings("unchecked")
		public Map<String, Object> searchQualificationMaster(String qualificationCode,String qualificationName) {
			List<HrMasQualification> searchQualificationMasterList = new ArrayList<HrMasQualification>();
			Map<String, Object> qualificationMasterFieldsMap =new HashMap<String, Object>();
			try {
				if((qualificationCode !=null)||(qualificationName ==null)) {
					searchQualificationMasterList =getHibernateTemplate().find("from jkt.hms.masters.business.HrMasQualification ms where ms.QualificationCode like '"+ qualificationCode+"%' order by ms.QualificationCode");
				}else {
					searchQualificationMasterList=getHibernateTemplate().find("from jkt.hms.masters.business.HrMasQualification ms where ms.QualificationName like '"+ qualificationName+"%' order by ms.QualificationName");
				}
				}catch(Exception e) {
					e.printStackTrace();
			}
				qualificationMasterFieldsMap.put("searchQualificationMasterList", searchQualificationMasterList);
			return qualificationMasterFieldsMap;
		}
		
		
		@SuppressWarnings("unchecked")
		public boolean editQualificationMaster(Map<String, Object> generalMap) {
			boolean dataUpdated=false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			String qualificationCode="";
			String qualificationName="";
			int hospitalId=0;
			int qualificationId=0;
						
			String changedBy = "";
			Date changedDate = null;
			String changedTime = "";
			
			try {
			qualificationId=(Integer)generalMap.get("id");
			hospitalId = (Integer)generalMap.get("hospitalId");
			qualificationCode=(String)generalMap.get("code");
			qualificationName=(String)generalMap.get("name");
					
			changedBy = (String)generalMap.get("changedBy");
			currentDate=(Date)generalMap.get("currentDate");
			currentTime=(String)generalMap.get("currentTime");
			HrMasQualification hrMasQualification=(HrMasQualification)getHibernateTemplate().load(HrMasQualification.class,qualificationId);
			
			hrMasQualification.setId(qualificationId);
			hrMasQualification.setQualificationCode(qualificationCode);
			hrMasQualification.setQualificationName(qualificationName);
					
					
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasQualification.setCompany(masHospital);
					
			hrMasQualification.setLastChgBy(changedBy);
			hrMasQualification.setLastChgDate(currentDate);
			hrMasQualification.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasQualification);
			dataUpdated = true;
			}catch (Exception e) {
				System.out.println("eXCP in DS "+e);
			}
			return dataUpdated;
		}

		
		@SuppressWarnings("unchecked")
		public boolean deleteQualificationMaster(int qualificationId,Map<String, Object> generalMap) {
			boolean dataDeleted=false;
			  String changedBy = "";
			  Date currentDate = new Date();
			  String currentTime = "";
			  currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			try{
			HrMasQualification hrMasQualification =new HrMasQualification();
			hrMasQualification=(HrMasQualification)getHibernateTemplate().load(HrMasQualification.class,qualificationId);
		    changedBy = (String)generalMap.get("changedBy");
		    currentDate=(Date)generalMap.get("currentDate");
		    currentTime=(String)generalMap.get("currentTime");
			if (hrMasQualification.getStatus().equals("y")){
					hrMasQualification.setStatus("n");
				dataDeleted=true;
			}else{
				hrMasQualification.setStatus("y");
				dataDeleted=false;
			}
			hrMasQualification.setLastChgBy(changedBy);
			hrMasQualification.setLastChgDate(currentDate);
			hrMasQualification.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasQualification);
			}catch (Exception e) {
				System.out.println("exc in DS "+e);
			}
			return dataDeleted;

		}
		
		//*************************************** End of Qualification Master By Atul *******************************//


		//****************************************** Start Of Institute Master by Atul ****************************//
		@SuppressWarnings("unchecked")
		public Map<String, Object> showInstituteMasterJsp() {
			List<HrMasInstitute> searchInstituteMasterList =new ArrayList<HrMasInstitute>();
			Map<String, Object> generalMap =new HashMap<String, Object>();
			
			searchInstituteMasterList= getHibernateTemplate().find("from jkt.hms.masters.business.HrMasInstitute");
			generalMap.put("searchInstituteMasterList", searchInstituteMasterList);
			return generalMap;
		}

		@SuppressWarnings("unchecked")
		public boolean addInstituteMaster(HrMasInstitute hrmasInstitute) {
			boolean successfullyAdded=false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(hrmasInstitute);
			successfullyAdded = true;
			return successfullyAdded;
		}
		
		public Map<String, Object> searchInstituteMaster(String instituteCode, String instituteName){
			List<HrMasInstitute> searchInstituteMasterList =new ArrayList<HrMasInstitute>();
			Map<String, Object>  instituteMasterFieldMap =new HashMap<String, Object>();
		try {
			if((instituteCode !=null) ||(instituteName ==null)) {
				searchInstituteMasterList=getHibernateTemplate().find("from jkt.hms.masters.business.HrMasInstitute mi where mi.InstituteCode like '"+ instituteCode +"%' order by mi.InstituteCode");
			}else {
				searchInstituteMasterList=getHibernateTemplate().find("from jkt.hms.masters.business.HrMasInstitute mi where mi.InstituteName like '"+ instituteName +"%' order by mi.InstituteName");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		instituteMasterFieldMap.put("searchInstituteMasterList", searchInstituteMasterList);
		return instituteMasterFieldMap;
		}
		
		@SuppressWarnings("unchecked")
		public boolean editInstituteMaster(Map<String, Object> generalMap) {
			boolean dataUpdated=false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			String instituteCode="";
			String instituteName="";
			int hospitalId=0;
			int instituteId=0;
						
			String changedBy = "";
			Date changedDate = null;
			String changedTime = "";
			
			try {
			instituteId=(Integer)generalMap.get("id");
			hospitalId = (Integer)generalMap.get("hospitalId");
			instituteCode=(String)generalMap.get("code");
			instituteName=(String)generalMap.get("name");
					
			changedBy = (String)generalMap.get("changedBy");
			currentDate=(Date)generalMap.get("currentDate");
			currentTime=(String)generalMap.get("currentTime");
			HrMasInstitute hrMasInstitute=(HrMasInstitute)getHibernateTemplate().load(HrMasInstitute.class,instituteId);
			
			hrMasInstitute.setId(instituteId);
			hrMasInstitute.setInstituteCode(instituteCode);
			hrMasInstitute.setInstituteName(instituteName);
					
					
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasInstitute.setCompany(masHospital);
					
			hrMasInstitute.setLastChgBy(changedBy);
			hrMasInstitute.setLastChgDate(currentDate);
			hrMasInstitute.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasInstitute);
			dataUpdated = true;
			}catch (Exception e) {
				System.out.println("eXCP in DS "+e);
			}
			return dataUpdated;
		}
		
		@SuppressWarnings("unchecked")
		public boolean deleteInstituteMaster(int instituteId,Map<String, Object> generalMap) {
			boolean dataDeleted=false;
			  String changedBy = "";
			  Date currentDate = new Date();
			  String currentTime = "";
			  currentTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
			try{
			HrMasInstitute hrMasInstitute =new HrMasInstitute();
			hrMasInstitute=(HrMasInstitute)getHibernateTemplate().load(HrMasInstitute.class,instituteId);
		    changedBy = (String)generalMap.get("changedBy");
		    currentDate=(Date)generalMap.get("currentDate");
		    currentTime=(String)generalMap.get("currentTime");
			if (hrMasInstitute.getStatus().equals("y")){
					hrMasInstitute.setStatus("n");
				dataDeleted=true;
			}else{
				hrMasInstitute.setStatus("y");
				dataDeleted=false;
			}
			hrMasInstitute.setLastChgBy(changedBy);
			hrMasInstitute.setLastChgDate(currentDate);
			hrMasInstitute.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(hrMasInstitute);
			}catch (Exception e) {
				System.out.println("exc in DS "+e);
			}
			return dataDeleted;

		}

		
		
	
}
