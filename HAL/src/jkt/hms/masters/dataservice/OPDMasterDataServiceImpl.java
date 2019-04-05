package jkt.hms.masters.dataservice;

import static jkt.hms.util.RequestConstants.*;

import java.io.InputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import jkt.hms.masters.business.AppEquipmentMaster;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasQaOptionValue;
import jkt.hms.masters.business.MasQuestionHeading;
import jkt.hms.masters.business.MasAllergyType;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasInjuryNature;
import jkt.hms.masters.business.MasItemClass;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasOpdFrequency;
import jkt.hms.masters.business.MasPhysiotherapyTreatment;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasVaccineItem;
import jkt.hms.masters.business.MlcCase;
import jkt.hms.masters.business.OpdDifferentialDisease;
import jkt.hms.masters.business.OpdHoliday;
import jkt.hms.masters.business.OpdInstructionTreatment;
import jkt.hms.masters.business.OpdQaMaster;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.OpdTemplateInvestigation;
import jkt.hms.masters.business.OpdTemplateTreatment;
import jkt.hms.masters.business.OpdVaccinMst;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientFamilyHistory;
import jkt.hms.masters.business.UserUsergroupHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OPDMasterDataServiceImpl extends HibernateDaoSupport implements
		OPDMasterDataService {
	Properties properties = new Properties();{
		try{
					ClassLoader loader =getClass().getClassLoader();
					InputStream inStream = loader.getResourceAsStream("stores.properties");
			        properties.load(inStream);
			        }catch (IOException e) {
			    	//
			    	e.printStackTrace();
			       }
		}
	// ****************************************** Start Of OPD Template by Mansi
	// ****************************//
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOpdTemplate(String templateCode,
			String templateName) {
		List<OpdTemplate> searchOpdTemplateList = new ArrayList<OpdTemplate>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

		Map<String, Object> opdTemplateFieldsMap = new HashMap<String, Object>();
		try {
			if ((templateName != null) || (templateCode == null)) {

				searchOpdTemplateList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.OpdTemplate imc where upper(imc.TemplateName) like upper('"
										+ templateName
										+ "%') order by imc.TemplateName");
			} else {
				searchOpdTemplateList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.OpdTemplate imc where upper(imc.TemplateCode) like upper('"
										+ templateCode
										+ "%') order by imc.TemplateCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment mm where mm.DepartmentType.Id='1'and mm.Status ='y'");
		opdTemplateFieldsMap.put("departmentList", departmentList);
		opdTemplateFieldsMap
				.put("searchOpdTemplateList", searchOpdTemplateList);
		return opdTemplateFieldsMap;
	}

	public boolean addOpdTemplate(OpdTemplate opdTemplate) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(opdTemplate);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteOpdTemplate(int templateId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		OpdTemplate opdTemplate = new OpdTemplate();
		opdTemplate = (OpdTemplate) getHibernateTemplate().get(
				OpdTemplate.class, templateId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				opdTemplate.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				opdTemplate.setStatus("y");
				dataDeleted = false;
			}
		}
		opdTemplate.setLastChgBy(changedBy);
		opdTemplate.setLastChgDate(currentDate);
		opdTemplate.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(opdTemplate);
		return dataDeleted;
	}

	public boolean editOpdTemplateToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String templateName = "";
		@SuppressWarnings("unused")
		String templateCode = "";
		int templateId = 0;
		int departmentId = 0;
		String templateType = "";
		String changedBy = "";
		try {
			templateId = (Integer) generalMap.get("id");
			templateCode = (String) generalMap.get("templateCode");
			templateName = (String) generalMap.get("name");
			departmentId = (Integer) generalMap.get("departmentId");
			templateType = (String) generalMap.get("templateType");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		} catch (Exception e) {
			e.printStackTrace();
		}

		OpdTemplate opdTemplate = (OpdTemplate) getHibernateTemplate().get(
				OpdTemplate.class, templateId);

		opdTemplate.setId(templateId);
		opdTemplate.setTemplateName(templateName);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		opdTemplate.setDepartment(masDepartment);

		opdTemplate.setTemplateType(templateType);
		opdTemplate.setLastChgBy(changedBy);
		opdTemplate.setLastChgDate(currentDate);
		opdTemplate.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(opdTemplate);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOpdTemplateJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<OpdTemplate> searchOpdTemplateList = new ArrayList<OpdTemplate>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<String> departmentTypeCode = new ArrayList<String>();
		departmentTypeCode.add("CR");
		departmentTypeCode.add("OPD1");
		departmentTypeCode.add("SpltOPD");
		departmentTypeCode.add("DIAG");

		searchOpdTemplateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdTemplate ");
		Criteria criteria = session.createCriteria(MasDepartment.class)
				.createAlias("DepartmentType", "dt").add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.in("dt.DepartmentTypeCode",
								departmentTypeCode)).addOrder(Order.asc("DepartmentName"));
		departmentList = criteria.list();
		masDepartmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment as mm where mm.Status ='y'");
		map.put("searchOpdTemplateList", searchOpdTemplateList);
		map.put("departmentList", departmentList);
		map.put("masDepartmentList", masDepartmentList);
		return map;
	}

	// ****************************************** End Of OPD Template by Mansi
	// ****************************//

	// //****************************************** Start Of OPD Treatment
	// Template by Mansi ****************************//

	public boolean addOpdHoliday(OpdHoliday opdHoliday) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(opdHoliday);
		successfullyAdded = true;
		}catch(Exception e)
		{
		 e.printStackTrace();
		} finally {
			// --------Session Closing----------
			session.close();
		}
		return successfullyAdded;

	}

	public boolean deleteOpdHoliday(int holidayId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		OpdHoliday opdHoliday = new OpdHoliday();
		opdHoliday = (OpdHoliday) getHibernateTemplate().get(OpdHoliday.class,
				holidayId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				opdHoliday.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				opdHoliday.setStatus("y");
				dataDeleted = false;
			}
		}
		opdHoliday.setLastChgBy(changedBy);
		opdHoliday.setLastChgDate(currentDate);
		opdHoliday.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(opdHoliday);
		return dataDeleted;
	}

	public boolean editOpdHolidayToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String holidayName = "";
		@SuppressWarnings("unused")
		String holidayCode = "";
		int holidayId = 0;
		Date holidayDate = new Date();
		String changedBy = "";
		try {
			holidayId = (Integer) generalMap.get("id");
			holidayCode = (String) generalMap.get("holidayCode");
			holidayName = (String) generalMap.get("name");
			holidayDate = (Date) generalMap.get("holidayDate");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		} catch (Exception e) {
			e.printStackTrace();
		}

		OpdHoliday opdHoliday = (OpdHoliday) getHibernateTemplate().get(
				OpdHoliday.class, holidayId);

		opdHoliday.setId(holidayId);
		opdHoliday.setHolidayName(holidayName);
		opdHoliday.setHolidayDate(holidayDate);
		opdHoliday.setLastChgBy(changedBy);
		opdHoliday.setLastChgDate(currentDate);
		opdHoliday.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(opdHoliday);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOpdHoliday(String holidayCode,
			String holidayName) {
		List<OpdHoliday> searchOpdHolidayList = new ArrayList<OpdHoliday>();

		Map<String, Object> opdHolidayFieldsMap = new HashMap<String, Object>();
		try {
			if ((holidayName != null) || (holidayCode == null)) {

				searchOpdHolidayList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.OpdHoliday imc where imc.HolidayName like '"
								+ holidayName + "%' order by imc.HolidayName");
			} else {
				searchOpdHolidayList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.OpdHoliday imc where imc.HolidayCode like '"
								+ holidayCode + "%' order by imc.HolidayCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		opdHolidayFieldsMap.put("searchOpdHolidayList", searchOpdHolidayList);
		return opdHolidayFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOpdHolidayJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdHoliday> searchOpdHolidayList = new ArrayList<OpdHoliday>();
		searchOpdHolidayList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdHoliday ");
		map.put("searchOpdHolidayList", searchOpdHolidayList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOpdTemplateTreatmentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdTemplateTreatment> searchOpdTemplateTreatmentList = new ArrayList<OpdTemplateTreatment>();
		List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<OpdInstructionTreatment> opdInstructionTreatmentList = new ArrayList<OpdInstructionTreatment>();
		searchOpdTemplateTreatmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdTemplateTreatment");
		opdTemplateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdTemplate as tm order by tm.TemplateName asc");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment mm where mm.DepartmentType.Id in ('1','13','17') and mm.Status ='y' order by mm.DepartmentName asc");
		frequencyList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasFrequency as mm where mm.Status ='y' order by mm.FrequencyName asc");
		opdInstructionTreatmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.OpdInstructionTreatment as mm where mm.Status ='y' order by mm.OpdInstructionTreatmentName asc");
		map.put("opdTemplateList", opdTemplateList);
		map.put("departmentList", departmentList);
		map.put("searchOpdTemplateTreatmentList",
				searchOpdTemplateTreatmentList);
		map.put("frequencyList", frequencyList);
		map.put("opdInstructionTreatmentList", opdInstructionTreatmentList);
		return map;
	}

	public boolean addOpdTemplateTreatment(
			OpdTemplateTreatment opdTemplateTreatment) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(opdTemplateTreatment);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteOpdTemplateTreatment(int templateTreatmentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		OpdTemplateTreatment opdTemplateTreatment = new OpdTemplateTreatment();
		opdTemplateTreatment = (OpdTemplateTreatment) getHibernateTemplate()
				.get(OpdTemplateTreatment.class, templateTreatmentId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				opdTemplateTreatment.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				opdTemplateTreatment.setStatus("y");
				dataDeleted = false;
			}
		}
		opdTemplateTreatment.setLastChgBy(changedBy);
		opdTemplateTreatment.setLastChgDate(currentDate);
		opdTemplateTreatment.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(opdTemplateTreatment);
		return dataDeleted;
	}

	public boolean editOpdTemplateTreatment(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int templateTreatmentId = 0;
		int departmentId = 0;
		int frequencyId = 0;
		@SuppressWarnings("unused")
		int itemId = 0;
		int templateId = 0;
		int instructionId = 0;
		int noofdays = 0;
		int total = 0;
		String dosage = "";
		String changedBy = "";
		try {
			templateTreatmentId = (Integer) generalMap.get("id");
			templateId = (Integer) generalMap.get("templateId");
			frequencyId = (Integer) generalMap.get("frequencyId");
			instructionId = (Integer) generalMap.get("instructionId");
			departmentId = (Integer) generalMap.get("departmentId");
			noofdays = (Integer) generalMap.get("noofdays");
			total = (Integer) generalMap.get("total");
			itemId = (Integer) generalMap.get("itemId");
			dosage = (String) generalMap.get("dosage");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		} catch (Exception e) {
			e.printStackTrace();
		}

		OpdTemplateTreatment opdTemplateTreatment = (OpdTemplateTreatment) getHibernateTemplate()
				.get(OpdTemplateTreatment.class, templateTreatmentId);

		opdTemplateTreatment.setId(templateTreatmentId);

		opdTemplateTreatment.setDosage(dosage);

		opdTemplateTreatment.setNoofdays(noofdays);

		opdTemplateTreatment.setTotal(total);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		opdTemplateTreatment.setDepartment(masDepartment);

		MasFrequency masFrequency = new MasFrequency();
		masFrequency.setId(frequencyId);
		opdTemplateTreatment.setFrequency(masFrequency);

		OpdTemplate opdTemplate = new OpdTemplate();
		opdTemplate.setId(templateId);
		opdTemplateTreatment.setTemplate(opdTemplate);

		MasStoreItem masStoreItem = new MasStoreItem();
		masStoreItem.setId(itemId);
		opdTemplateTreatment.setItem(masStoreItem);
		if (instructionId != 0) {
			OpdInstructionTreatment opdInstructionTreatment = new OpdInstructionTreatment();
			opdInstructionTreatment.setId(instructionId);
			opdTemplateTreatment
					.setOpdInstructionTreatment(opdInstructionTreatment);
		} else {
			opdTemplateTreatment.setOpdInstructionTreatment(null);
		}
		opdTemplateTreatment.setLastChgBy(changedBy);
		opdTemplateTreatment.setLastChgDate(currentDate);
		opdTemplateTreatment.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(opdTemplateTreatment);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOpdTemplateTreatment(String templateGroup) {
		List<OpdTemplateTreatment> searchOpdTemplateTreatmentList = new ArrayList<OpdTemplateTreatment>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<OpdInstructionTreatment> opdInstructionTreatmentList = new ArrayList<OpdInstructionTreatment>();

		Map<String, Object> opdTemplateTreatmentFieldsMap = new HashMap<String, Object>();
		try {
			if ((templateGroup != null)) {

				searchOpdTemplateTreatmentList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.OpdTemplateTreatment imc where imc.Template.TemplateName like '"
										+ templateGroup
										+ "%' order by imc.Template.TemplateName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment mm where mm.DepartmentType.Id='1'and mm.Status ='y'");
		opdTemplateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdTemplate ");
		frequencyList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasFrequency as mm where mm.Status ='y'");
		opdInstructionTreatmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.OpdInstructionTreatment as mm where mm.Status ='y'");
		opdTemplateTreatmentFieldsMap.put("departmentList", departmentList);
		opdTemplateTreatmentFieldsMap.put("opdTemplateList", opdTemplateList);
		opdTemplateTreatmentFieldsMap.put("searchOpdTemplateTreatmentList",
				searchOpdTemplateTreatmentList);
		opdTemplateTreatmentFieldsMap.put("frequencyList", frequencyList);
		opdTemplateTreatmentFieldsMap.put("opdInstructionTreatmentList",
				opdInstructionTreatmentList);

		return opdTemplateTreatmentFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getTemplateGroup(int templateId, int deptId) {
		List showList = new ArrayList();
		List<OpdTemplateTreatment> searchOpdTemplateTreatmentList = new ArrayList<OpdTemplateTreatment>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<OpdInstructionTreatment> opdInstructionTreatmentList = new ArrayList<OpdInstructionTreatment>();

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		session = (Session) getSession();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// Criteria nursinCareSetupCriteria =
			// session.createCriteria(NursingcareSetup.class)

			// .createCriteria(NursingcareSetup.PROP_NURSING)
			// .add(Expression.eq(MasNursingCare.PROP_ID, careId));

			// showList = nursinCareSetupCriteria.list();

			showList = session.createCriteria(OpdTemplateTreatment.class).add(
					Restrictions.eq("Template.Id", templateId)).add(
					Restrictions.eq("Department.Id", deptId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		frequencyList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasFrequency as mm where mm.Status ='y'");
		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment mm where mm.DepartmentType.Id='1'and mm.Status ='y'");
		opdTemplateList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdTemplate ");
		frequencyList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasFrequency as mm where mm.Status ='y'");
		searchOpdTemplateTreatmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdTemplateTreatment");
		opdInstructionTreatmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdInstructionTreatment");
		map.put("frequencyList", frequencyList);
		map.put("departmentList", departmentList);
		map.put("opdTemplateList", opdTemplateList);
		map.put("searchOpdTemplateTreatmentList",
				searchOpdTemplateTreatmentList);
		map.put("showList", showList);
		map.put("opdInstructionTreatmentList", opdInstructionTreatmentList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> fillItemsInGrid(Map map) {

		Session session = (Session) getSession();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		@SuppressWarnings("unused")
		int deptId = 0;
		try {
			if (map.get("deptId") != null) {
				deptId = Integer.parseInt("" + map.get("deptId"));
			}
			String str = "" + map.get("pvmsNo");
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", str));
			itemList = c.list();
			map.put("itemList", itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemList(Map map) {
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		@SuppressWarnings("unused")
		int deptId = 0;
		deptId = Integer.parseInt("" + map.get("deptId"));
		try {
			String str = map.get("autoHint") + "%";
			String query = "SELECT DISTINCT (sib.Nomenclature),sib.PvmsNo from  MasStoreItem as sib where sib.Department.Id='24' and  upper(sib.Nomenclature) like upper('"
					+ str + "')";
			Query q = session.createQuery(query);
			q.setFirstResult(0);
			q.setMaxResults(10);
			itemList = q.list();
			Iterator itr = itemList.iterator();
			while (itr.hasNext()) {
				Object[] pair = (Object[]) itr.next();
				@SuppressWarnings("unused")
				String nomenclature = (String) pair[0];
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	// ****************************************** End Of OPD Treatment Template
	// by Mansi ****************************//

	// //****************************************** Start Of OPD Instruction
	// Treatment by Mansi ****************************//

	public boolean addOpdInstructionTreatment(
			OpdInstructionTreatment opdInstructionTreatment) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(opdInstructionTreatment);
		successfullyAdded = true;
		return successfullyAdded;

	}

	public boolean deleteOpdInstructionTreatment(int opdInstructionTreatmentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		OpdInstructionTreatment opdInstructionTreatment = new OpdInstructionTreatment();
		opdInstructionTreatment = (OpdInstructionTreatment) getHibernateTemplate()
				.get(OpdInstructionTreatment.class, opdInstructionTreatmentId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				opdInstructionTreatment.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				opdInstructionTreatment.setStatus("y");
				dataDeleted = false;
			}
		}
		opdInstructionTreatment.setLastChgBy(changedBy);
		opdInstructionTreatment.setLastChgDate(currentDate);
		opdInstructionTreatment.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(opdInstructionTreatment);
		return dataDeleted;
	}

	public boolean editOpdInstructionTreatmentToDatabase(
			Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String opdInstructionTreatmentName = "";
		@SuppressWarnings("unused")
		String opdInstructionTreatmentCode = "";
		int opdInstructionTreatmentId = 0;
		String changedBy = "";
		try {
			opdInstructionTreatmentId = (Integer) generalMap.get("id");
			opdInstructionTreatmentCode = (String) generalMap
					.get("opdInstructionTreatmentCode");
			opdInstructionTreatmentName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		} catch (Exception e) {
			e.printStackTrace();
		}

		OpdInstructionTreatment opdInstructionTreatment = (OpdInstructionTreatment) getHibernateTemplate()
				.get(OpdInstructionTreatment.class, opdInstructionTreatmentId);

		opdInstructionTreatment.setId(opdInstructionTreatmentId);
		opdInstructionTreatment
				.setOpdInstructionTreatmentName(opdInstructionTreatmentName);
		opdInstructionTreatment.setLastChgBy(changedBy);
		opdInstructionTreatment.setLastChgDate(currentDate);
		opdInstructionTreatment.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(opdInstructionTreatment);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOpdInstructionTreatment(
			String opdInstructionTreatmentCode,
			String opdInstructionTreatmentName) {
		List<OpdInstructionTreatment> searchOpdInstructionTreatmentList = new ArrayList<OpdInstructionTreatment>();

		Map<String, Object> opdInstructionTreatmentFieldsMap = new HashMap<String, Object>();
		try {
			if ((opdInstructionTreatmentName != null)
					|| (opdInstructionTreatmentCode == null)) {

				searchOpdInstructionTreatmentList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.OpdInstructionTreatment imc where imc.OpdInstructionTreatmentName like '"
										+ opdInstructionTreatmentName
										+ "%' order by imc.OpdInstructionTreatmentName");
			} else {
				searchOpdInstructionTreatmentList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.OpdInstructionTreatment imc where imc.OpdInstructionTreatmentCode like '"
										+ opdInstructionTreatmentCode
										+ "%' order by imc.OpdInstructionTreatmentCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		opdInstructionTreatmentFieldsMap.put(
				"searchOpdInstructionTreatmentList",
				searchOpdInstructionTreatmentList);
		return opdInstructionTreatmentFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOpdInstructionTreatmentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdInstructionTreatment> searchOpdInstructionTreatmentList = new ArrayList<OpdInstructionTreatment>();
		searchOpdInstructionTreatmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdInstructionTreatment ");
		map.put("searchOpdInstructionTreatmentList",
				searchOpdInstructionTreatmentList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getInvestigationTemplateGroup(int templateId,
			int deptId) {
		List showInvList = new ArrayList();

		List<OpdTemplateInvestigation> searchOpdTemplateInvestigationList = new ArrayList<OpdTemplateInvestigation>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		session = (Session) getSession();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// Criteria nursinCareSetupCriteria =
			// session.createCriteria(NursingcareSetup.class)

			// .createCriteria(NursingcareSetup.PROP_NURSING)
			// .add(Expression.eq(MasNursingCare.PROP_ID, careId));

			// showList = nursinCareSetupCriteria.list();

			showInvList = session
					.createCriteria(OpdTemplateInvestigation.class).add(
							Restrictions.eq("Template.Id", templateId)).add(
							Restrictions.eq("Department.Id", deptId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		departmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment mm where mm.DepartmentType.Id='1' and mm.Status ='y'");
		opdTemplateList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.OpdTemplate as op where op.TemplateType ='I' and op.Status ='y'");
		searchOpdTemplateInvestigationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdTemplateInvestigation");

		map.put("departmentList", departmentList);
		map.put("opdTemplateList", opdTemplateList);
		map.put("searchOpdTemplateInvestigationList",
				searchOpdTemplateInvestigationList);
		map.put("showInvList", showInvList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> fillChargeCodeInGrid(Map map) {

		Session session = (Session) getSession();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		@SuppressWarnings("unused")
		int deptId = 0;
		try {
			if (map.get("deptId") != null) {
				deptId = Integer.parseInt("" + map.get("deptId"));
			}
			String str = "" + map.get("chargeCodeCode");
			Criteria c = session.createCriteria(MasChargeCode.class).add(
					Restrictions.eq("ChargeCodeCode", str));
			chargeCodeList = c.list();
			map.put("chargeCodeList", chargeCodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOpdTemplateInvestigationJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdTemplateInvestigation> searchOpdTemplateInvestigationList = new ArrayList<OpdTemplateInvestigation>();
		List<OpdTemplate> opdTemplateList = new ArrayList<OpdTemplate>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		searchOpdTemplateInvestigationList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.OpdTemplateInvestigation");
		opdTemplateList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.OpdTemplate as op where op.TemplateType ='I' and op.Status ='y' order by op.TemplateName asc");
		List<String> departmentTypeCode = new ArrayList<String>();
		departmentTypeCode.add("CR");
		departmentTypeCode.add("OPD1");
		departmentTypeCode.add("SpltOPD");
		departmentTypeCode.add("DIAG");
		Criteria criteria = session.createCriteria(MasDepartment.class)
				.createAlias("DepartmentType", "dt").add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.in("dt.DepartmentTypeCode",
								departmentTypeCode)).addOrder(Order.asc("DepartmentName"));
		departmentList = criteria.list();

		map.put("opdTemplateList", opdTemplateList);
		map.put("departmentList", departmentList);
		map.put("searchOpdTemplateInvestigationList",
				searchOpdTemplateInvestigationList);
		return map;
	}

	public boolean addOpdTemplateInvestigation(
			OpdTemplateInvestigation opdTemplateInvestigation) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(opdTemplateInvestigation);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean deleteOpdTemplateInvestigation(int templateInvestigationId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		OpdTemplateInvestigation opdTemplateInvestigation = new OpdTemplateInvestigation();
		opdTemplateInvestigation = (OpdTemplateInvestigation) getHibernateTemplate()
				.get(OpdTemplateInvestigation.class, templateInvestigationId);

		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				opdTemplateInvestigation.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				opdTemplateInvestigation.setStatus("y");
				dataDeleted = false;
			}
		}

		opdTemplateInvestigation.setLastChgBy(changedBy);
		opdTemplateInvestigation.setLastChgDate(currentDate);
		opdTemplateInvestigation.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(opdTemplateInvestigation);
		return dataDeleted;
	}

	public boolean editOpdTemplateInvestigation(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		int templateInvestigationId = 0;
		int departmentId = 0;
		@SuppressWarnings("unused")
		int chargeCodeId = 0;
		int templateId = 0;
		int templateInvestigationQty = 0;
		String clinicalNotes = "";
		String changedBy = "";
		try {
			templateInvestigationId = (Integer) generalMap.get("id");
			templateId = (Integer) generalMap.get("templateId");
			departmentId = (Integer) generalMap.get("departmentId");
			templateInvestigationQty = (Integer) generalMap
					.get("templateInvestigationQty");
			chargeCodeId = (Integer) generalMap.get("chargeCodeId");
			clinicalNotes = (String) generalMap.get("clinicalNotes");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		} catch (Exception e) {
			e.printStackTrace();
		}

		OpdTemplateInvestigation opdTemplateInvestigation = (OpdTemplateInvestigation) getHibernateTemplate()
				.get(OpdTemplateInvestigation.class, templateInvestigationId);

		opdTemplateInvestigation.setId(templateInvestigationId);

		opdTemplateInvestigation.setClinicalNotes(clinicalNotes);

		opdTemplateInvestigation
				.setTemplateInvestigationQty(templateInvestigationQty);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		opdTemplateInvestigation.setDepartment(masDepartment);

		OpdTemplate opdTemplate = new OpdTemplate();
		opdTemplate.setId(templateId);
		opdTemplateInvestigation.setTemplate(opdTemplate);

		MasChargeCode masChargeCode = new MasChargeCode();
		masChargeCode.setId(chargeCodeId);
		opdTemplateInvestigation.setChargeCode(masChargeCode);

		opdTemplateInvestigation.setLastChgBy(changedBy);
		opdTemplateInvestigation.setLastChgDate(currentDate);
		opdTemplateInvestigation.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(opdTemplateInvestigation);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeCodeList(Map<String, Object> map) {
		List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
		Session session = (Session) getSession();
		@SuppressWarnings("unused")
		int deptId = 0;
		deptId = Integer.parseInt("" + map.get("deptId"));
		try {
			String str = "%" + map.get("autoHint") + "%";
			//String chargeType = "DIAG";
			String labradiologyCheck=(String)map.get("labradiologyCheck");
			//chargeList=getHibernateTemplate().find("select mcc from jkt.hms.masters.business.DgMasInvestigation as dmi join dmi.ChargeCode as mcc join mcc.ChargeType as ct where ct.ChargeTypeCode='"+chargeType+"' and  upper(mcc.ChargeCodeName) like upper('"+str+"') ");
			
			Criteria crit = session						
					.createCriteria(DgMasInvestigation.class)
					.createAlias("ChargeCode", "chargeCode")
					.createAlias("chargeCode.Department", "dept")
					.add(Restrictions.like("chargeCode.ChargeCodeName", str).ignoreCase())
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("chargeCode.Status", "y").ignoreCase());
					
			
			if(labradiologyCheck!=null &&  !labradiologyCheck.equalsIgnoreCase("") && labradiologyCheck.equalsIgnoreCase("Lab"))
			{
				crit.add(Restrictions.eq("dept.DepartmentCode", "Lab".toLowerCase()).ignoreCase());
			}
			else if(labradiologyCheck!=null &&  !labradiologyCheck.equalsIgnoreCase("") && labradiologyCheck.equalsIgnoreCase("Radio"))
			{
				crit.add(Restrictions.or(Restrictions.eq("dept.DepartmentCode", "Radio".toLowerCase()).ignoreCase(), Restrictions.eq("dept.DepartmentCode", "CT".toLowerCase()).ignoreCase()));
			}
			else if(labradiologyCheck!=null &&  !labradiologyCheck.equalsIgnoreCase(""))
			{
				Criterion rest1 = Restrictions.or(Restrictions.eq("dept.DepartmentCode", "Radio").ignoreCase(),
						Restrictions.eq("dept.DepartmentCode", "CT".toLowerCase()).ignoreCase());
				
				crit.add(Restrictions.or(rest1,Restrictions.eq("dept.DepartmentCode", "Lab".toLowerCase()).ignoreCase()));

			}
			crit.setProjection(Projections.projectionList().add(Projections.groupProperty("ChargeCode")));
			chargeList = crit.list();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("chargeList", chargeList);
		return map;

	}

	// //****************************************** Start Methods by Vishal
	// ****************************//
	// --------------------------Equipment
	// Master-----------------------------------
	public Map<String, Object> showOpdEquipmentJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<AppEquipmentMaster> searchOpdEquipmentList = new ArrayList<AppEquipmentMaster>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 19;

		departmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).createAlias("DepartmentType",
				"dt").add(Restrictions.in("dt.Id", dept)).addOrder(Order.asc("DepartmentName")).list();
		searchOpdEquipmentList = getHibernateTemplate().find(
				"from AppEquipmentMaster ");

		map.put("departmentList", departmentList);
		map.put("searchOpdEquipmentList", searchOpdEquipmentList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOpdEquipment(String equipmentCode,
			String equipmentName) {
		List<AppEquipmentMaster> searchOpdEquipmentList = new ArrayList<AppEquipmentMaster>();
		Map<String, Object> opdEquipmentFieldsMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		// Map<String,Object> map = new HashMap<String,Object>();
		try {
			if ((equipmentName != null) || (equipmentCode == null)) {
				searchOpdEquipmentList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.AppEquipmentMaster as aem where aem.EquipmentName like '"
										+ equipmentName
										+ "%' order by aem.EquipmentName");
			} else {
				searchOpdEquipmentList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.AppEquipmentMaster as aem where aem.EquipmentCode like '"
										+ equipmentCode
										+ "%' order by aem.EquipmentCode");
			}
			Integer dept[] = new Integer[3];
			dept[0] = 1;
			dept[1] = 4;
			dept[2] = 19;

			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias(
					"DepartmentType", "dt").add(Restrictions.in("dt.Id", dept))
					.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		opdEquipmentFieldsMap.put("searchOpdEquipmentList",
				searchOpdEquipmentList);
		opdEquipmentFieldsMap.put("departmentList", departmentList);
		return opdEquipmentFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public boolean addOpdEquipment(AppEquipmentMaster appEquipmentMaster) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(appEquipmentMaster);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editOpdEquipmentToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String equipmentName = "";
		@SuppressWarnings("unused")
		String equipmentCode = "";
		int equipmentId = 0;
		int departmentId = 0;
		int noOfEquipment = 0;
		String changedBy = "";
		try {
			equipmentId = (Integer) generalMap.get("id");
			equipmentCode = (String) generalMap.get("equipmentCode");
			equipmentName = (String) generalMap.get("name");
			noOfEquipment = (Integer) generalMap.get("noOfEquipment");
			departmentId = (Integer) generalMap.get("departmentId");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		} catch (Exception e) {
			e.printStackTrace();
		}

		AppEquipmentMaster appEquipmentMaster = (AppEquipmentMaster) getHibernateTemplate()
				.get(AppEquipmentMaster.class, equipmentId);

		appEquipmentMaster.setId(equipmentId);
		appEquipmentMaster.setEquipmentName(equipmentName);
		appEquipmentMaster.setNoOfEquipments(noOfEquipment);
		if (departmentId != 0) {
			MasDepartment department = new MasDepartment();
			department.setId(departmentId);
			appEquipmentMaster.setDepartment(department);
		}
		appEquipmentMaster.setLastChgBy(changedBy);
		appEquipmentMaster.setLastChgDate(currentDate);
		appEquipmentMaster.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(appEquipmentMaster);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteOpdEquipment(int equipmentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		AppEquipmentMaster appEquipmentMaster = new AppEquipmentMaster();
		appEquipmentMaster = (AppEquipmentMaster) getHibernateTemplate().get(
				AppEquipmentMaster.class, equipmentId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				appEquipmentMaster.setEquipmentStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				appEquipmentMaster.setEquipmentStatus("y");
				dataDeleted = false;
			}
		}
		appEquipmentMaster.setLastChgBy(changedBy);
		appEquipmentMaster.setLastChgDate(currentDate);
		appEquipmentMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(appEquipmentMaster);
		return dataDeleted;
	}

	// ------------------------Vaccine master----------------------------
	public Map<String, Object> showOpdVaccinJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdVaccinMst> searchOpdVaccinList = new ArrayList<OpdVaccinMst>();
		
		Session session = (Session)getSession();
		searchOpdVaccinList = session.createCriteria(OpdVaccinMst.class)
								.add(Restrictions.eq("Status", "y").ignoreCase())
								//.addOrder(Order.asc("MasStoreItem.Id"))
								//.addOrder(Order.asc("VaccinName")) 
								//.addOrder(Order.asc("VaccinCode"))//govind code 14-7-2016
								.addOrder(Order.asc("SrNo")) 
								.list();
		List<MasAdministrativeSex> genderList = new ArrayList<MasAdministrativeSex>();
		genderList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("searchOpdVaccinList", searchOpdVaccinList);
		map.put("genderList", genderList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOpdVaccin(String vaccinCode,
			String vaccinName) {
		List<OpdVaccinMst> searchOpdVaccinList = new ArrayList<OpdVaccinMst>();
		Map<String, Object> opdVaccinFieldsMap = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasAdministrativeSex> genderList = new ArrayList<MasAdministrativeSex>();
		
		// Map<String,Object> map = new HashMap<String,Object>();
		try {
			if ((vaccinName != null) || (vaccinCode == null)) {
				searchOpdVaccinList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.OpdVaccinMst as mv where mv.VaccinName like '"
								+ vaccinName + "%' order by mv.VaccinName");
			} else {
				searchOpdVaccinList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.OpdVaccinMst as mv where mv.VaccinCode like '"
								+ vaccinCode + "%' order by mv.VaccinCode");

			}
			
			genderList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		opdVaccinFieldsMap.put("searchOpdVaccinList", searchOpdVaccinList);
		opdVaccinFieldsMap.put("genderList", genderList);


		return opdVaccinFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public boolean addOpdVaccin(OpdVaccinMst opdVaccin) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(opdVaccin);
		successfullyAdded = true;
		return successfullyAdded;

	}

	public boolean editOpdVaccinToDatabase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		
		String vaccinName = "";
		@SuppressWarnings("unused")
		String vaccinCode = "";
		int vaccinId = 0;
		int vaccinDuration = 0;
		String changedBy = "";
		int userId = 0;
		int masStoreItemId = 0;
		int dose=0;
		int maxDays=0;
		int genderId=0;
		try {
			vaccinId = (Integer) generalMap.get("id");
			genderId = (Integer) generalMap.get("genderId");
			vaccinCode = (String) generalMap.get("vaccinCode");
			vaccinName = (String) generalMap.get("name");
			vaccinDuration = (Integer) generalMap.get("vaccinDuration");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			userId = (Integer)generalMap.get("userId");
			masStoreItemId = (Integer)generalMap.get("masStoreItemId");
			Box box=(Box)generalMap.get("box");
			dose=box.getInt("vaccineDose");
			if(generalMap.get("maxDays")!=null){
				maxDays=(Integer)generalMap.get("maxDays");
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		OpdVaccinMst opdVaccin = (OpdVaccinMst) getHibernateTemplate().get(
				OpdVaccinMst.class, vaccinId);

		opdVaccin.setId(vaccinId);
		opdVaccin.setVaccinName(vaccinName);
		opdVaccin.setVaccinDuration(vaccinDuration);
		opdVaccin.setVaccinToDays(maxDays);
		
		Users users = new Users();
		users.setId(userId);
		opdVaccin.setLastChgBy(users);
		opdVaccin.setLastChgDate(currentDate);
		opdVaccin.setLastChgTime(currentTime);
		if(masStoreItemId!=0){
			MasStoreItem item=new MasStoreItem(masStoreItemId);
			opdVaccin.setMasStoreItem(item);
		}
		
		
		MasAdministrativeSex gender=new MasAdministrativeSex();
		gender.setId(genderId);
		opdVaccin.setGender(gender);
		
		opdVaccin.setDose(dose);
		opdVaccin.setVaccinType((String)generalMap.get("type")); // added by amit das on 05-08-2016
		
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(opdVaccin);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}
	

	@SuppressWarnings("unchecked")
	public boolean deleteOpdVaccin(int vaccinId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		OpdVaccinMst opdVaccin = new OpdVaccinMst();
		opdVaccin = (OpdVaccinMst) getHibernateTemplate().get(
				OpdVaccinMst.class, vaccinId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		userId = (Integer)generalMap.get("userId");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				opdVaccin.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				opdVaccin.setStatus("y");
				dataDeleted = false;
			}
		}
		Users users = new Users();
		users.setId(userId);
		opdVaccin.setLastChgBy(users);
		opdVaccin.setLastChgDate(currentDate);
		opdVaccin.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(opdVaccin);
		return dataDeleted;
	}


	// //-------------------------------------End Methods by Vishal Jain
	// --------------------------

	// //****************************************** Start Of OPD Instruction
	// Treatment by Mansi ****************************//

	public boolean addOpdFrequency(MasOpdFrequency opdFrequency) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(opdFrequency);
		successfullyAdded = true;
		return successfullyAdded;

	}

	public boolean deleteOpdFrequency(int opdFrequencyId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasOpdFrequency opdFrequency = new MasOpdFrequency();
		opdFrequency = (MasOpdFrequency) getHibernateTemplate().get(
				MasOpdFrequency.class, opdFrequencyId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				opdFrequency.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				opdFrequency.setStatus("y");
				dataDeleted = false;
			}
		}
		opdFrequency.setLastChgBy(changedBy);
		opdFrequency.setLastChgDate(currentDate);
		opdFrequency.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(opdFrequency);
		return dataDeleted;
	}

	public boolean editOpdFrequencyToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String opdFrequencyName = "";
		@SuppressWarnings("unused")
		String opdFrequencyCode = "";
		int opdFrequencyId = 0;
		String changedBy = "";
		try {
			opdFrequencyId = (Integer) generalMap.get("id");
			opdFrequencyCode = (String) generalMap.get("opdFrequencyCode");
			opdFrequencyName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		} catch (Exception e) {
			e.printStackTrace();
		}

		MasOpdFrequency opdFrequency = (MasOpdFrequency) getHibernateTemplate()
				.get(MasOpdFrequency.class, opdFrequencyId);

		opdFrequency.setId(opdFrequencyId);
		opdFrequency.setFrequencyName(opdFrequencyName);
		opdFrequency.setLastChgBy(changedBy);
		opdFrequency.setLastChgDate(currentDate);
		opdFrequency.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(opdFrequency);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOpdFrequency(String opdFrequencyCode,
			String opdFrequencyName) {
		List<MasOpdFrequency> searchOpdFrequencyList = new ArrayList<MasOpdFrequency>();

		Map<String, Object> opdFrequencyFieldsMap = new HashMap<String, Object>();
		try {
			if ((opdFrequencyName != null) || (opdFrequencyCode == null)) {

				searchOpdFrequencyList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasOpdFrequency imc where imc.FrequencyName like '"
										+ opdFrequencyName
										+ "%' order by imc.FrequencyName");
			} else {
				searchOpdFrequencyList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasOpdFrequency imc where imc.FrequencyCode like '"
										+ opdFrequencyCode
										+ "%' order by imc.FrequencyCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		opdFrequencyFieldsMap.put("searchOpdFrequencyList",
				searchOpdFrequencyList);
		return opdFrequencyFieldsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOpdFrequencyJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasOpdFrequency> searchOpdFrequencyList = new ArrayList<MasOpdFrequency>();
		searchOpdFrequencyList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasOpdFrequency ");
		map.put("searchOpdFrequencyList", searchOpdFrequencyList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOpdPhysiotherapyTreatmentJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		List<MasPhysiotherapyTreatment> searchOpdPhysiotherapyTreatmentList = new ArrayList<MasPhysiotherapyTreatment>();
		Criteria criteria = session
				.createCriteria(MasPhysiotherapyTreatment.class);

		searchOpdPhysiotherapyTreatmentList = criteria.list();

		map.put("searchOpdPhysiotherapyTreatmentList",
				searchOpdPhysiotherapyTreatmentList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchOpdPhysiotherapyTreatment(
			String treatmentCode, String treatmentName) {
		List<MasPhysiotherapyTreatment> searchOpdPhysiotherapyTreatmentList = new ArrayList<MasPhysiotherapyTreatment>();
		Session session = (Session) getSession();

		Map<String, Object> opdTreatmentFieldsMap = new HashMap<String, Object>();
		try {
			if ((treatmentName != null) || (treatmentCode == null)) {
				Criteria criteria = session.createCriteria(
						MasPhysiotherapyTreatment.class).add(
						Restrictions.like("TreatmentName", treatmentName,
								MatchMode.ANYWHERE)).addOrder(
						Order.asc("TreatmentName"));
				searchOpdPhysiotherapyTreatmentList = criteria.list();
			} else {
				Criteria criteria = session.createCriteria(
						MasPhysiotherapyTreatment.class).add(
						Restrictions.like("TreatmentCode", treatmentCode,
								MatchMode.ANYWHERE)).addOrder(
						Order.asc("TreatmentCode"));
				searchOpdPhysiotherapyTreatmentList = criteria.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		opdTreatmentFieldsMap.put("searchOpdPhysiotherapyTreatmentList",
				searchOpdPhysiotherapyTreatmentList);
		return opdTreatmentFieldsMap;
	}

	public boolean addOpdPhysiotherapyTreatment(
			MasPhysiotherapyTreatment masPhysiotherapyTreatment) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masPhysiotherapyTreatment);
		hbt.refresh(masPhysiotherapyTreatment);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean editOpdPhysiotherapyTreatmentToDatabase(
			Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String treatmentName = "";
		@SuppressWarnings("unused")
		String treatmentCode = "";
		int treatmentId = 0;
		String changedBy = "";
		try {
			treatmentId = (Integer) generalMap.get("id");
			treatmentCode = (String) generalMap.get("treatmentCode");
			treatmentName = (String) generalMap.get("treatmentName");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		} catch (Exception e) {
			e.printStackTrace();
		}

		MasPhysiotherapyTreatment masPhysiotherapyTreatment = (MasPhysiotherapyTreatment) getHibernateTemplate()
				.get(MasPhysiotherapyTreatment.class, treatmentId);

		masPhysiotherapyTreatment.setId(treatmentId);
		masPhysiotherapyTreatment.setTreatmentName(treatmentName);

		masPhysiotherapyTreatment.setLastChgBy(changedBy);
		masPhysiotherapyTreatment.setLastChgDate(currentDate);
		masPhysiotherapyTreatment.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masPhysiotherapyTreatment);
			hbt.refresh(masPhysiotherapyTreatment);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public boolean deleteOpdPhysiotherapyTreatment(int treatmentId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasPhysiotherapyTreatment masPhysiotherapyTreatment = new MasPhysiotherapyTreatment();
		masPhysiotherapyTreatment = (MasPhysiotherapyTreatment) getHibernateTemplate()
				.get(MasPhysiotherapyTreatment.class, treatmentId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masPhysiotherapyTreatment.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masPhysiotherapyTreatment.setStatus("y");
				dataDeleted = false;
			}
		}
		masPhysiotherapyTreatment.setLastChgBy(changedBy);
		masPhysiotherapyTreatment.setLastChgDate(currentDate);
		masPhysiotherapyTreatment.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masPhysiotherapyTreatment);
		hbt.refresh(masPhysiotherapyTreatment);
		return dataDeleted;
	}

	@Override
	public boolean addAllergyType(MasAllergyType masAllergyType) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masAllergyType);
		successfullyAdded = true;
		}catch(Exception e)
		{
		 e.printStackTrace();
		}
		return successfullyAdded;

	}

	public boolean deleteAllergyType(int allergyTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int changedBy = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasAllergyType masAllergyType = new MasAllergyType();
		masAllergyType = (MasAllergyType) getHibernateTemplate().get(MasAllergyType.class,
				allergyTypeId);
		changedBy = (Integer) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masAllergyType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masAllergyType.setStatus("y");
				dataDeleted = false;
			}
		}
		
		Users users = new Users();
		users.setId(changedBy);
		masAllergyType.setLastChgBy(users);
		
		masAllergyType.setLastChgDate(currentDate);
		masAllergyType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(masAllergyType);
		return dataDeleted;
	}

	public boolean editAllergyTypeToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String allergyTypeName = "";
		@SuppressWarnings("unused")
		String allergyTypeCode = "";
		int allergyTypeId = 0;
		int changedBy = 0;
		try {
			allergyTypeId = (Integer) generalMap.get("id");
			allergyTypeCode = (String) generalMap.get("allergyTypeCode");
			allergyTypeName = (String) generalMap.get("name");
			changedBy = (Integer) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");

		} catch (Exception e) {
			e.printStackTrace();
		}

		MasAllergyType masAllergyType = (MasAllergyType) getHibernateTemplate().get(
				MasAllergyType.class, allergyTypeId);
		Users users = new Users();
		users.setId(changedBy);
		masAllergyType.setLastChgBy(users);
		
		masAllergyType.setId(allergyTypeId);
		masAllergyType.setAllergyTypeName(allergyTypeName);
		masAllergyType.setLastChgDate(currentDate);
		masAllergyType.setLastChgTime(currentTime);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(masAllergyType);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@Override
	public Map<String, Object> showAllergyTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAllergyType> searchAllergyTypeList = new ArrayList<MasAllergyType>();
		Session session = (Session)getSession();
		searchAllergyTypeList = session.createCriteria(MasAllergyType.class).list();
		map.put("searchAllergyTypeList", searchAllergyTypeList);
		return map;
	}

	public boolean submitDifferentialDisease(Box box) {
		boolean differentialDiseaseFlag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		
		try {
			OpdDifferentialDisease opdDifferentialDisease = new OpdDifferentialDisease();
			
			opdDifferentialDisease.setDifferentialDiseaseName(box.getString(DIFFERENTIAL_DISEASE_NAME));
			opdDifferentialDisease.setSynonyms(box.getString(SYNONYMS));
			opdDifferentialDisease.setSignSymptoms(box.getString(SIGN_SYMPTOMS));
			opdDifferentialDisease.setInvestigation(box.getString(INVESTIGATION));
			opdDifferentialDisease.setTreatments(box.getString(TREATMENTS));
			opdDifferentialDisease.setDrugs(box.getString(DRUGS));
			opdDifferentialDisease.setSurgery(box.getString(SURGERY));
			opdDifferentialDisease.setOtherAdvice(box.getString(OTHER_ADVICE));
			
			Users user = new Users();
			user.setId(box.getInt("userId"));
			opdDifferentialDisease.setLastChgBy(user);
			opdDifferentialDisease.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			opdDifferentialDisease.setLastChgTime(box.getString(CHANGED_TIME));
		//	MasHospital hospital = new MasHospital();
		//	hospital.setId(box.getInt("hospitalId"));
		//	opdDifferentialDisease.setHospital(hospital);
			hbt.save(opdDifferentialDisease);
			differentialDiseaseFlag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return differentialDiseaseFlag;
	}


	@Override
	public Map<String, Object> searchAllergyType(String allergyTypeCode,
			String allergyTypeName) {
		List<MasAllergyType> searchAllergyTypeList = new ArrayList<MasAllergyType>();

		Map<String, Object> allergyTypeFieldsMap = new HashMap<String, Object>();
		try {
			if ((allergyTypeName != null) || (allergyTypeCode == null)) {

				searchAllergyTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasAllergyType imc where upper(imc.AllergyTypeName) like upper('"
										+ allergyTypeName
										+ "%') order by imc.AllergyTypeName");
			} else {
				searchAllergyTypeList = getHibernateTemplate()
						.find(
								"from jkt.hms.masters.business.MasAllergyType imc where upper(imc.AllergyTypeCode) like upper('"
										+ allergyTypeCode
										+ "%') order by imc.AllergyTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		allergyTypeFieldsMap
				.put("searchAllergyTypeList", searchAllergyTypeList);
		return allergyTypeFieldsMap;
	
	}



	@Override
	public boolean addFamilyHistory(PatientFamilyHistory patientFamilyHistory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(patientFamilyHistory);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@Override
	public Map<String, Object> showFamilyHistoryJsp() {
		Session session =(Session)getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<PatientFamilyHistory> searchPatientFamilyHistoryList = new ArrayList<PatientFamilyHistory>();
		searchPatientFamilyHistoryList =session.createCriteria(PatientFamilyHistory.class).add(Restrictions.eq("TemplateCode","FH")).addOrder(Order.asc("PatientHistoryCode")).list();
		
		map.put("searchPatientFamilyHistoryList", searchPatientFamilyHistoryList);
		return map;
	}

	@Override
	public boolean deleteFamilyHistory(int familyHistoryId,
			Map<String, Object> generalMap) {
		  boolean dataDeleted=false;
		  int userId = 0;
		  Date currentDate = new Date();
		  String currentTime= "";
		  currentTime =(String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		  try{
			  PatientFamilyHistory patientFamilyHistory= new PatientFamilyHistory();
			  patientFamilyHistory=(PatientFamilyHistory)getHibernateTemplate().load(PatientFamilyHistory.class,familyHistoryId); 
		  userId =(Integer)generalMap.get("changedBy");
		  currentDate=(Date)generalMap.get("currentDate");
		  currentTime=(String)generalMap.get("currentTime");
		  if (patientFamilyHistory.getStatus().equalsIgnoreCase("y")){
			  patientFamilyHistory.setStatus("n");
		  dataDeleted=true; 
		  }else{
			  patientFamilyHistory.setStatus("y");
		  dataDeleted=false;
		  }
		  Users users = new Users();
		  users.setId(userId);
		  patientFamilyHistory.setLastChgBy(users);
		  patientFamilyHistory.setLastChgDate(currentDate);
		  patientFamilyHistory.setLastChgTime(currentTime);
		  org.springframework.orm.hibernate3.HibernateTemplate hbt =
		  getHibernateTemplate();
		  hbt.setFlushModeName("FLUSH_EAGER");
		  hbt.setCheckWriteOperations(false);
		  hbt.update(patientFamilyHistory);
		  }catch
		  (Exception e) { 
		  } return dataDeleted;
	  }

	@Override
	public boolean editFamilyHistoryToDatabase(Map<String, Object> generalMap) {
		  boolean dataUpdated=false;
		  Date currentDate = new Date();
		  String currentTime = "";
		  currentTime =(String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
		  String familyHistoryName=""; 
		 String familyHistoryCode="";
		 int familyHistoryId=0;
		 int userId = 0;
		  familyHistoryId=(Integer)generalMap.get("id");
		  familyHistoryCode=(String)generalMap.get("familyHistoryCode");
		  familyHistoryName=(String)generalMap.get("name");
		  userId = (Integer)generalMap.get("userId");
		  currentDate=(Date)generalMap.get("currentDate");
		  currentTime=(String)generalMap.get("currentTime");
		  System.out.println("familyHistoryId---------"+familyHistoryId);
		  
		  PatientFamilyHistory patientFamilyHistory =(PatientFamilyHistory)getHibernateTemplate().load(PatientFamilyHistory.class, familyHistoryId);
		  
		  patientFamilyHistory.setId(familyHistoryId);
		  
		  patientFamilyHistory.setPatientHistoryName(familyHistoryName);
		  
		  patientFamilyHistory.setTemplateCode("FH");
		  Users users = new Users();
		  users.setId(userId);
		  patientFamilyHistory.setLastChgBy(users);
		  
		  patientFamilyHistory.setLastChgDate(currentDate);
		  patientFamilyHistory.setLastChgTime(currentTime);
		  org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		  hbt.setFlushModeName("FLUSH_EAGER");
		  hbt.setCheckWriteOperations(false);
		  hbt.update(patientFamilyHistory);
		  dataUpdated = true; 
	  return dataUpdated;
	  }

	@Override
	public Map<String, Object> searchFamilyHistory(String familyHistoryCode,
			String familyHistoryName) { 
		  List<PatientFamilyHistory> searchPatientFamilyHistoryList=new ArrayList<PatientFamilyHistory>();
		  Map patientFamilyHistoryMap = new HashMap();
			Session session =(Session)getSession();
		  try{
		  if((familyHistoryName!=null) ||(familyHistoryCode==null)){
			  
			  searchPatientFamilyHistoryList =session.createCriteria(PatientFamilyHistory.class).add(Restrictions.like("PatientHistoryName","%"+familyHistoryName+"%").ignoreCase()).add(Restrictions.eq("TemplateCode","FH")).addOrder(Order.asc("PatientHistoryName")).list();
	  	 } else{
	  		 
	  		searchPatientFamilyHistoryList =session.createCriteria(PatientFamilyHistory.class).add(Restrictions.like("PatientHistoryCode","%"+familyHistoryCode+"%").ignoreCase()).add(Restrictions.eq("TemplateCode","FH")).addOrder(Order.asc("PatientHistoryCode")).list();
	  		 }
		  }catch (Exception e) {
	   }
		  patientFamilyHistoryMap.put("searchPatientFamilyHistoryList",searchPatientFamilyHistoryList);
	  return patientFamilyHistoryMap;
	  }

	

	@Override
	public Map<String, Object> searchPresentComplaint(
			String patientPresentComplaintName) { 
		  List<PatientFamilyHistory> searchPatientFamilyHistoryList=new ArrayList<PatientFamilyHistory>();
		  List<MasDepartment> departmentList=new ArrayList<MasDepartment>();
		  Map patientFamilyHistoryMap = new HashMap();
			Session session =(Session)getSession();
			String	departmentTypeCode =HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentTypeCodeForOpd");
		  try{
		  if((patientPresentComplaintName!=null)){
			  
			  searchPatientFamilyHistoryList =session.createCriteria(PatientFamilyHistory.class).add(Restrictions.like("PatientPresentComplaintName","%"+patientPresentComplaintName+"%").ignoreCase()).add(Restrictions.eq("TemplateCode","CH")).addOrder(Order.asc("PatientPresentComplaintName")).list();
	  	 } 
		  
		  departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.or(Restrictions.eq("dt.DepartmentTypeCode",departmentTypeCode), Restrictions.eq("dt.DepartmentTypeCode","OT")))
												
					.addOrder(Order.asc("DepartmentName"))
					.list();

		   
		  }catch (Exception e) {
	   }
		  patientFamilyHistoryMap.put("departmentList",departmentList);
		  patientFamilyHistoryMap.put("searchPatientFamilyHistoryList",searchPatientFamilyHistoryList);
	  return patientFamilyHistoryMap;
	  }

	@Override
	public Map showPresentComplaintJsp() {
		Session session =(Session)getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<PatientFamilyHistory> searchPatientFamilyHistoryList = new ArrayList<PatientFamilyHistory>();
		searchPatientFamilyHistoryList =session.createCriteria(PatientFamilyHistory.class).add(Restrictions.eq("TemplateCode","CH")).addOrder(Order.asc("PatientPresentComplaintName")).list();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		 String	departmentTypeCode =HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentTypeCodeForOpd");
			
		   departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.or(Restrictions.eq("dt.DepartmentTypeCode",departmentTypeCode), Restrictions.eq("dt.DepartmentTypeCode","OT")))
												
					.addOrder(Order.asc("DepartmentName"))
					.list();

		   map.put("departmentList", departmentList);
		map.put("searchPatientFamilyHistoryList", searchPatientFamilyHistoryList);
		return map;
	}

	@Override
	public boolean addPresentComplaint(PatientFamilyHistory patientFamilyHistory) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(patientFamilyHistory);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@Override
	public boolean editPresentComplaintToDatabase(Map<String, Object> generalMap) {
		  boolean dataUpdated=false;
		  Date currentDate = new Date();
		  String currentTime = "";
		  currentTime =(String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
		  String patientPresentComplaintName=""; 
		 int patientFamilyHistoryId=0;
		 int userId = 0;
		 int deptId = 0;
		 patientFamilyHistoryId=(Integer)generalMap.get("id");
		  
		 patientPresentComplaintName=(String)generalMap.get("name");
		  userId = (Integer)generalMap.get("userId");
		  deptId = (Integer)generalMap.get("deptId");
		  currentDate=(Date)generalMap.get("currentDate");
		  currentTime=(String)generalMap.get("currentTime");
		  System.out.println("familyHistoryId---------"+patientFamilyHistoryId);
		  
		  PatientFamilyHistory patientFamilyHistory =(PatientFamilyHistory)getHibernateTemplate().load(PatientFamilyHistory.class, patientFamilyHistoryId);
		  
		  patientFamilyHistory.setId(patientFamilyHistoryId);
		  
		  patientFamilyHistory.setPatientPresentComplaintName(patientPresentComplaintName);
		  patientFamilyHistory.setDepartmentId(new MasDepartment(deptId));
		  patientFamilyHistory.setTemplateCode("CH");
		  Users users = new Users();
		  users.setId(userId);
		  patientFamilyHistory.setLastChgBy(users);
		  
		  patientFamilyHistory.setLastChgDate(currentDate);
		  patientFamilyHistory.setLastChgTime(currentTime);
		  org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		  hbt.setFlushModeName("FLUSH_EAGER");
		  hbt.setCheckWriteOperations(false);
		  hbt.update(patientFamilyHistory);
		  dataUpdated = true; 
	  return dataUpdated;
	  }

	@Override
	public boolean deletePresentComplaint(int patientFamilyHistoryId,Map<String, Object> generalMap) {
		  boolean dataDeleted=false;
		  int userId = 0;
		  Date currentDate = new Date();
		  String currentTime= "";
		  currentTime =(String)HMSUtil.getCurrentDateAndTime().get("currentTime");
		  try{
			  PatientFamilyHistory patientFamilyHistory= new PatientFamilyHistory();
			  patientFamilyHistory=(PatientFamilyHistory)getHibernateTemplate().load(PatientFamilyHistory.class,patientFamilyHistoryId); 
		  userId =(Integer)generalMap.get("userId");
		  currentDate=(Date)generalMap.get("currentDate");
		  currentTime=(String)generalMap.get("currentTime");
		  if (patientFamilyHistory.getStatus().equalsIgnoreCase("y")){
			  patientFamilyHistory.setStatus("n");
		  dataDeleted=true; 
		  }else{
			  patientFamilyHistory.setStatus("y");
		  dataDeleted=false;
		  }
		  Users users = new Users();
		  users.setId(userId);
		  patientFamilyHistory.setLastChgBy(users);
		  patientFamilyHistory.setLastChgDate(currentDate);
		  patientFamilyHistory.setLastChgTime(currentTime);
		  org.springframework.orm.hibernate3.HibernateTemplate hbt =
		  getHibernateTemplate();
		  hbt.setFlushModeName("FLUSH_EAGER");
		  hbt.setCheckWriteOperations(false);
		  hbt.update(patientFamilyHistory);
		  }catch
		  (Exception e) { 
		  } return dataDeleted;
	  }


	@Override
	public Map<String, Object> showOpdQuestionnaireJsp() {
		Session session =(Session)getSession();
		List<MasQuestionHeading> questionHeadingList = new ArrayList<MasQuestionHeading>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdQaMaster> searchOpdQuestionnaireList=new ArrayList<OpdQaMaster>();
		List<MasQaOptionValue> masQaOptionValueList=new ArrayList<MasQaOptionValue>();
			

		try {
			  
			
			  searchOpdQuestionnaireList =session.createCriteria(OpdQaMaster.class).list();

			  
			  questionHeadingList = session.createCriteria(MasQuestionHeading.class).add(
						Restrictions.eq("Status", "y"))
						.addOrder(Order.asc("QuestionHeadingName")).list();
			  
			  
			  masQaOptionValueList = session.createCriteria(MasQaOptionValue.class).add(
						Restrictions.eq("Status", "y"))
						.addOrder(Order.asc("QaOptionValueCode")).list();
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchOpdQuestionnaireList",searchOpdQuestionnaireList);
		map.put("questionHeadingList", questionHeadingList);
		map.put("masQaOptionValueList", masQaOptionValueList);
		return map;
	}



	@Override
	public Map<String, Object> addOpdQuestionnaire(Box box) {Map<String, Object> map = new HashMap<String, Object>();
	int questionId = box.getInt("questionId");
	String question =  box.getString("question");
	int userId = box.getInt("userId");
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	boolean flag = false;
	Transaction tx = null;
	String message = "";
	Session session = (Session)getSession();
	//int opdQuestionId  = box.getInt(COMMON_ID);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTimeWithoutSc");
	int optionValue=box.getInt("optionValue");
	System.out.println(optionValue);
	try {
		tx= session.beginTransaction();
		List<OpdQaMaster> opdQaMasterList = new ArrayList<OpdQaMaster>();
		opdQaMasterList = session.createCriteria(OpdQaMaster.class).add(Restrictions.eq("QuestionHeading.Id", questionId))
				  .add(Restrictions.eq("Question",question)).list();
	
			if(opdQaMasterList.size()==0){
				
					
					/*int Id = list.getId().intValue();
					UserUsergroupHospital userUsergroupHospital=(UserUsergroupHospital)hbt.load(UserUsergroupHospital.class, Id);*/
					OpdQaMaster opdQa =new OpdQaMaster();
					
					MasQuestionHeading  questionHeading = new MasQuestionHeading();
					questionHeading.setId( box.getInt("questionId"));
                     opdQa.setQuestionHeading(questionHeading);
                     
                     
                     opdQa.setQuestion(question);
                     opdQa.setStatus("y");
                     Users users = new Users();
                     users.setId(userId);
                     opdQa.setLastChgBy(users);
                     /*opdQa.setOptionValue(optionValue);*/
                     opdQa.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
                     opdQa.setLastChgTime(time);
					 hbt.save(opdQa);
					 message = "Record added successfully.";
				}
			else{
				message = "Question Heading and Question are already exist.";
			}
	
		
		flag=true;
		tx.commit();
		} catch (Exception e) {
		message = "Some Problem Occured.";
		if(tx !=null){
			tx.rollback();
		}
		e.printStackTrace();
	}
	map.put("message", message);
	return map;
	}
	@Override
	public Map<String, Object> updateOpdQuestionnaire(Box box) {Map<String, Object> map = new HashMap<String, Object>();
	int questionId = box.getInt("questionId");
	String question =  box.getString("question");
	int userId = box.getInt("userId");
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	boolean flag = false;
	Transaction tx = null;
	String message = "";
	Session session = (Session)getSession();
	int opdQuestionId  = box.getInt(COMMON_ID);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTimeWithoutSc");
	int optionValue=box.getInt("optionValue");
	System.out.println(optionValue);
	try {
		tx= session.beginTransaction();
		List<OpdQaMaster> opdQaMasterList = new ArrayList<OpdQaMaster>();
		opdQaMasterList = session.createCriteria(OpdQaMaster.class).add(Restrictions.ne("Id", opdQuestionId)).add(Restrictions.eq("QuestionHeading.Id", questionId))
				  .add(Restrictions.like("Question",question)).list();
	
			if(opdQaMasterList.size()==0){
				
					
				
					 OpdQaMaster opdQa =(OpdQaMaster)hbt.load(OpdQaMaster.class, opdQuestionId);					
					 MasQuestionHeading  questionHeading = new MasQuestionHeading();
						questionHeading.setId( box.getInt("questionId"));
	                     opdQa.setQuestionHeading(questionHeading);
	                     
                     opdQa.setQuestion(question);
                     opdQa.setStatus("y");
                     Users users = new Users();
                     users.setId(userId);
                     opdQa.setLastChgBy(users);
                     opdQa.setOptionValue(optionValue);
                     opdQa.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
                     opdQa.setLastChgTime(time);
					 hbt.update(opdQa);
					 message = "Updated added successfully.";
				}
			else{
				message = "Question Heading and Question are already exist.";
			}
	
		
		flag=true;
		tx.commit();
		} catch (Exception e) {
		message = "Some Problem Occured.";
		if(tx !=null){
			tx.rollback();
		}
		e.printStackTrace();
	}
	map.put("message", message);
	return map;
	}

	
	@Override
	public Map<String, Object> searchOpdQuestionnaire(int questionIdSearch) { 
		  List<OpdQaMaster> searchOpdQuestionnaireList=new ArrayList<OpdQaMaster>();
		  Map<String,Object> mapOpdQuestionnaire = new HashMap<String,Object>();
		  List<MasQuestionHeading> questionHeadingList = new ArrayList<MasQuestionHeading>();
			Session session =(Session)getSession();
			List<MasQaOptionValue> masQaOptionValueList=new ArrayList<MasQaOptionValue>();
		  try{
			  
				Properties properties = new Properties();
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("adt.properties");

				
				
		  if((questionIdSearch!=0)){
			  
			  searchOpdQuestionnaireList =session.createCriteria(OpdQaMaster.class).add(Restrictions.eq("QuestionHeading.Id",questionIdSearch)).list();
	  	 } else{
	  		 searchOpdQuestionnaireList =session.createCriteria(OpdQaMaster.class).list();
	  	 }
		  }catch (Exception e) {
	   }
		  questionHeadingList = session.createCriteria(MasQuestionHeading.class).add(
					Restrictions.eq("Status", "y"))
					.addOrder(Order.asc("QuestionHeadingName")).list();
		  
		  masQaOptionValueList = session.createCriteria(MasQaOptionValue.class).add(
					Restrictions.eq("Status", "y"))
					.addOrder(Order.asc("QaOptionValueCode")).list();
		  
		  mapOpdQuestionnaire.put("searchOpdQuestionnaireList",searchOpdQuestionnaireList);
		  mapOpdQuestionnaire.put("questionHeadingList", questionHeadingList);
		  mapOpdQuestionnaire.put("masQaOptionValueList", masQaOptionValueList);
		  
		
	  return mapOpdQuestionnaire;
	  }

	@Override
	public boolean deleteOpdQuestionnaire(int opdQuestionId,Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		int userId = 0;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		OpdQaMaster opdQaMaster = new OpdQaMaster();
		opdQaMaster = (OpdQaMaster) getHibernateTemplate().get(
				OpdQaMaster.class, opdQuestionId);
		userId = (Integer) generalMap.get("userId");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				opdQaMaster.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				opdQaMaster.setStatus("y");
				dataDeleted = false;
			}
		}
		 Users users = new Users();
         users.setId(userId);
         opdQaMaster.setLastChgBy(users);
		opdQaMaster.setLastChgDate(currentDate);
		opdQaMaster.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.saveOrUpdate(opdQaMaster);
		return dataDeleted;
	}
	
	// ---------------------Question Heading--------------------------------------------

		@SuppressWarnings("unchecked")
		public Map<String, Object> showQuestionHeadingJsp() {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasQuestionHeading> searchQuestionHeadingList = new ArrayList<MasQuestionHeading>();
			searchQuestionHeadingList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasQuestionHeading ");
			map.put("searchQuestionHeadingList", searchQuestionHeadingList);
			return map;
		}

		@SuppressWarnings("unchecked")
		public Map<String, Object> searchQuestionHeading(String questionHeadingCode,
				String questionHeadingName) {
			List<MasQuestionHeading> searchQuestionHeadingList = new ArrayList<MasQuestionHeading>();
			Map questionHeadingFieldsMap = new HashMap();
			try {
				if ((questionHeadingName != null) || (questionHeadingCode == null)) {
					searchQuestionHeadingList = getHibernateTemplate()
							.find(
									"from jkt.hms.masters.business.MasQuestionHeading mat where mat.QuestionHeadingName like '"
											+ questionHeadingName
											+ "%' order by mat.QuestionHeadingName");
				} else {
					searchQuestionHeadingList = getHibernateTemplate()
							.find(
									"from jkt.hms.masters.business.MasQuestionHeading mat where mat.QuestionHeadingCode like '"
											+ questionHeadingCode
											+ "%' order by mat.QuestionHeadingCode");
				}
			} catch (Exception e) {
				//System.out.println("Ds excp in searchQuestionHeading  " + e);
			}
			questionHeadingFieldsMap.put("searchQuestionHeadingList",
					searchQuestionHeadingList);
			return questionHeadingFieldsMap;
		}

		public boolean addQuestionHeading(MasQuestionHeading masQuestionHeading) {
			boolean dataSaved = false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masQuestionHeading);
			dataSaved = true;
			return dataSaved;
		}

		public boolean deleteQuestionHeading(int questionHeadingId,
				Map<String, Object> generalMap) {
			boolean dataDeleted = false;
			String changedBy = "";
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			MasQuestionHeading masQuestionHeading = new MasQuestionHeading();
			masQuestionHeading = (MasQuestionHeading) getHibernateTemplate().get(
					MasQuestionHeading.class, questionHeadingId);
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			if (generalMap.get("flag") != null) {
				String flag = (String) generalMap.get("flag");
				if (flag.equals("InActivate")) {
					masQuestionHeading.setStatus("n");
					dataDeleted = true;
				} else if (flag.equals("Activate")) {
					masQuestionHeading.setStatus("y");
					dataDeleted = false;
				}
			}
			masQuestionHeading.setLastChgBy(changedBy);
			masQuestionHeading.setLastChgDate(currentDate);
			masQuestionHeading.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masQuestionHeading);
			return dataDeleted;
		}

		public boolean editQuestionHeadingToDatabase(Map<String, Object> generalMap) {
			boolean dataUpdated = false;
			Date currentDate = new Date();
			String currentTime = "";
			currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			String questionHeadingName = "";
			@SuppressWarnings("unused")
			String questionHeadingCode = "";
			int questionHeadingId = 0;
			String changedBy = "";
			questionHeadingId = (Integer) generalMap.get("id");
			questionHeadingCode = (String) generalMap.get("questionHeadingCode");
			questionHeadingName = (String) generalMap.get("name");
			changedBy = (String) generalMap.get("changedBy");
			currentDate = (Date) generalMap.get("currentDate");
			currentTime = (String) generalMap.get("currentTime");
			MasQuestionHeading masQuestionHeading = (MasQuestionHeading) getHibernateTemplate()
					.get(MasQuestionHeading.class, questionHeadingId);

			masQuestionHeading.setId(questionHeadingId);
			masQuestionHeading.setQuestionHeadingName(questionHeadingName);
			masQuestionHeading.setLastChgBy(changedBy);
			masQuestionHeading.setLastChgDate(currentDate);
			masQuestionHeading.setLastChgTime(currentTime);
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.update(masQuestionHeading);
			dataUpdated = true;
			return dataUpdated;
		}
		
		// ---------------------Question Heading--------------------------------------------

				@SuppressWarnings("unchecked")
				public Map<String, Object> showQaOptionValueJsp() {
					Map<String, Object> map = new HashMap<String, Object>();
					List<MasQaOptionValue> searchQaOptionValueList = new ArrayList<MasQaOptionValue>();
					Session session = (Session)getSession();
					/*searchQaOptionValueList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.MasQaOptionValue  mqv INNER JOIN FETCH mqv.Question q INNER JOIN FETCH q.QuestionHeading");*/
					searchQaOptionValueList = session.createCriteria(MasQaOptionValue.class)
							.setFetchMode("Question", FetchMode.EAGER).list();
					map.put("searchQaOptionValueList", searchQaOptionValueList); 
					
					List<MasQuestionHeading> questionHeadingList = new ArrayList<MasQuestionHeading>();
					List<OpdQaMaster> questionnaireList = new ArrayList<OpdQaMaster>();		

					try {
						  
						  questionHeadingList = session.createCriteria(MasQuestionHeading.class).add(
									Restrictions.eq("Status", "y"))
									.addOrder(Order.asc("QuestionHeadingName")).list();
						  
						  questionnaireList = session.createCriteria(OpdQaMaster.class).add(
									Restrictions.eq("Status", "y"))
									.addOrder(Order.asc("Question")).list();
						  
						  
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					map.put("questionHeadingList", questionHeadingList);
					map.put("questionnaireList", questionnaireList);
					
					return map;
				}

				@SuppressWarnings("unchecked")
				public Map<String, Object> searchQaOptionValue(String qaOptionValueCode,
						String qaOptionValueName) {
					List<MasQaOptionValue> searchQaOptionValueList = new ArrayList<MasQaOptionValue>();
					Map qaOptionValueFieldsMap = new HashMap();
					try {
						if ((qaOptionValueName != null) || (qaOptionValueCode == null)) {
							searchQaOptionValueList = getHibernateTemplate()
									.find(
											"from jkt.hms.masters.business.MasQaOptionValue mat where mat.QaOptionValueName like '"
													+ qaOptionValueName
													+ "%' order by mat.QaOptionValueName");
						} else {
							searchQaOptionValueList = getHibernateTemplate()
									.find(
											"from jkt.hms.masters.business.MasQaOptionValue mat where mat.QaOptionValueCode like '"
													+ qaOptionValueCode
													+ "%' order by mat.QaOptionValueCode");
						}
					} catch (Exception e) {
						//System.out.println("Ds excp in searchQaOptionValue  " + e);
					}
					qaOptionValueFieldsMap.put("searchQaOptionValueList",
							searchQaOptionValueList);
					return qaOptionValueFieldsMap;
				}

				@SuppressWarnings("unchecked")
				public Map<String, Object> searchQaOptions(Box box) {
					List<MasQaOptionValue> searchQaOptionValueList = new ArrayList<MasQaOptionValue>();
					Session session = (Session)getSession();
					Map qaOptionValueFieldsMap = new HashMap();
					try {
					/*	if ((qaOptionValueName != null) || (qaOptionValueCode == null)) {
							searchQaOptionValueList = getHibernateTemplate()
									.find(
											"from jkt.hms.masters.business.MasQaOptionValue mat where mat.QaOptionValueName like '"
													+ qaOptionValueName
													+ "%' order by mat.QaOptionValueName");
						} else {
							searchQaOptionValueList = getHibernateTemplate()
									.find(
											"from jkt.hms.masters.business.MasQaOptionValue mat where mat.QaOptionValueCode like '"
													+ qaOptionValueCode
													+ "%' order by mat.QaOptionValueCode");
						}*/
						
					/*	searchQaOptionValueList = (List<MasQaOptionValue>)session.createQuery("from jkt.hms.masters.business.MasQaOptionValue mat inner join mat.Question qus where qus.Id ="
												+ box.getInt("questionnaireId")).list();*/
						
						searchQaOptionValueList = session.createCriteria(MasQaOptionValue.class)
								.setFetchMode("Question", FetchMode.SELECT)
								.add(Restrictions.eq("Question.Id",box.getInt("questionnaireId"))).list();
						System.out.println("searchQaOptionValueList"+searchQaOptionValueList.size());
						
					} catch (Exception e) {
						//System.out.println("Ds excp in searchQaOptionValue  " + e);
					}
					qaOptionValueFieldsMap.put("searchQaOptionValueList",
							searchQaOptionValueList);
					return qaOptionValueFieldsMap;
				}

				public boolean deleteQaOptionValue(int qaOptionValueId,
						Map<String, Object> generalMap) {
					boolean dataDeleted = false;
					String changedBy = "";
					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
							"currentTime");
					MasQaOptionValue masQaOptionValue = new MasQaOptionValue();
					masQaOptionValue = (MasQaOptionValue) getHibernateTemplate().get(
							MasQaOptionValue.class, qaOptionValueId);
					changedBy = (String) generalMap.get("changedBy");
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");
					if (generalMap.get("flag") != null) {
						String flag = (String) generalMap.get("flag");
						if (flag.equals("InActivate")) {
							masQaOptionValue.setStatus("n");
							dataDeleted = true;
						} else if (flag.equals("Activate")) {
							masQaOptionValue.setStatus("y");
							dataDeleted = false;
						}
					}
					masQaOptionValue.setLastChgBy(changedBy);
					masQaOptionValue.setLastChgDate(currentDate);
					masQaOptionValue.setLastChgTime(currentTime);
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(masQaOptionValue);
					return dataDeleted;
				}

			
				
				
				
				

				@Override
				public Map<String, Object> addQaOptionValue(Box box) {Map<String, Object> map = new HashMap<String, Object>();
				int optionSNo = box.getInt("optionSNo");
				String optionValueCode =  box.getString(CODE);
				String optionValueName =  box.getString(SEARCH_NAME);
				int userId = box.getInt("userId");
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				boolean flag = false;
				Transaction tx = null;
				String message = "";
				Session session = (Session)getSession();
				//int opdQuestionId  = box.getInt(COMMON_ID);
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTimeWithoutSc");
				String changedBy = (String) box.getString("changedBy");
				try {
					tx= session.beginTransaction();
				/*	List<MasQaOptionValue> qaOptionValueList = new ArrayList<MasQaOptionValue>();*/
				/*
					if(optionValueName!=""){
						qaOptionValueList = session.createCriteria(MasQaOptionValue.class)
								 .add(Restrictions.eq("QaOptionValueName",optionValueName)).list();
					}
					if(optionValueCode!=""){
						qaOptionValueList = session.createCriteria(MasQaOptionValue.class)
								 .add(Restrictions.eq("QaOptionValueCode",optionValueCode)).list();
					}
					//if(optionSNo!=0){
						qaOptionValueList = session.createCriteria(MasQaOptionValue.class)
								 .add(Restrictions.eq("OptionSNo",optionSNo)).list();
					//}
*/					
					
					
					

				     /* Criterion c1 = Restrictions.eq("QaOptionValueCode",optionValueCode);
				      Criterion c2 = Restrictions.eq("QaOptionValueName",optionValueName);
				      Criterion c3 = Restrictions.eq("OptionSNo",optionSNo);*/
				      
				      
				      
				/*	qaOptionValueList = session.createCriteria(MasQaOptionValue.class) 
							.add(Restrictions.eq("Question.Id", box.getInt("questionnaireId")))
							.add(Restrictions.or(Restrictions.or(c1, c2), c3)).list();*/
					
					/*qaOptionValueList = session.createCriteria(MasQaOptionValue.class) .add(Restrictions.eq("QaOptionValueCode",optionValueCode))
							 .add(Restrictions.eq("QaOptionValueName",optionValueName))
							  .add(Restrictions.eq("OptionSNo",optionSNo)).list();
					*/
					
					
				
						/*if(qaOptionValueList.size()==0){*/
							
					if(true){	
							MasQaOptionValue masQaOptionValue =new MasQaOptionValue();
								
								
			                     
			                     
							masQaOptionValue.setOptionSNo(optionSNo);
							masQaOptionValue.setStatus("y");
			                     Users users = new Users();
			                     users.setId(userId);
			                     masQaOptionValue.setLastChgBy(changedBy);
			                     masQaOptionValue.setQaOptionValueCode(optionValueCode);
			                     masQaOptionValue.setQaOptionValueName(optionValueName);
			                     masQaOptionValue.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			                     masQaOptionValue.setLastChgTime(time);
			                     OpdQaMaster questionHeader = new OpdQaMaster();
			                     questionHeader.setId(box.getInt("questionnaireId"));
			                     masQaOptionValue.setQuestion(questionHeader);
								 hbt.save(masQaOptionValue);
								 message = "Record added successfully.";
							}
						else{
							message = "Records are already exist.";
						}
				
					
					flag=true;
					tx.commit();
					} catch (Exception e) {
					message = "Some Problem Occured.";
					if(tx !=null){
						tx.rollback();
					}
					e.printStackTrace();
				}
				map.put("message", message);
				return map;
				}
				@Override
				public Map<String, Object> editQaOptionValueToDatabase(Box box) {
					Map<String, Object> map = new HashMap<String, Object>();
				
				int optionSNo = box.getInt("optionSNo");
				String optionValueCode =  box.getString(CODE);
				String optionValueName =  box.getString(SEARCH_NAME);
				
				
				int userId = box.getInt("userId");
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				boolean flag = false;
				Transaction tx = null;
				String message = "";
				Session session = (Session)getSession();
				int opdQuestionId  = box.getInt(COMMON_ID);
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTimeWithoutSc");
				String changedBy = (String) box.getString("changedBy");
				try {
					tx= session.beginTransaction();
				/*	List<MasQaOptionValue> qaOptionValueList = new ArrayList<MasQaOptionValue>();
									
					
					 Criterion c1 = Restrictions.eq("QaOptionValueCode",optionValueCode);
				      Criterion c2 = Restrictions.like("QaOptionValueName",optionValueName);
				      Criterion c3 = Restrictions.eq("OptionSNo",optionSNo);*/
				      
				      
				      
				/*	qaOptionValueList = session.createCriteria(MasQaOptionValue.class) .add(Restrictions.ne("Id", opdQuestionId))
							.add(Restrictions.or(Restrictions.or(c1, c2), c3)).list();*/
					
						/*if(qaOptionValueList.size()==0){*/
					if(true){	
								
							
							MasQaOptionValue masQaOptionValue =(MasQaOptionValue)hbt.load(MasQaOptionValue.class, opdQuestionId);					
								
							
							
							
							masQaOptionValue.setOptionSNo(optionSNo);
							masQaOptionValue.setStatus("y");
			                     Users users = new Users();
			                     users.setId(userId);
			                     masQaOptionValue.setLastChgBy(changedBy);
			                     masQaOptionValue.setQaOptionValueCode(optionValueCode);
			                     masQaOptionValue.setQaOptionValueName(optionValueName);
			                     masQaOptionValue.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			                     masQaOptionValue.setLastChgTime(time);
			                     OpdQaMaster questionHeader = new OpdQaMaster();
			                     questionHeader.setId(box.getInt("questionnaireId"));
			                     System.out.println("box.getInt()"+box.getInt("questionnaireId"));
			                     masQaOptionValue.setQuestion(questionHeader);
								 hbt.update(masQaOptionValue);
								 message = "Updated added successfully.";
							}
						else{
							message = "Records are already exist.";
						}
				
					
					flag=true;
					tx.commit();
					} catch (Exception e) {
					message = "Some Problem Occured.";
					if(tx !=null){
						tx.rollback();
					}
					e.printStackTrace();
				}
				map.put("message", message);
				return map;
				}

				@Override
				public Map<String, Object> getVaccinationList(Box box) {
					Map<String,Object> dataMap=new HashMap<String,Object>(); 
					int sectionId=Integer.parseInt(properties.getProperty("store.vaccine_id"));
					Session session=(Session) getSession();
					Criteria criteria=session.createCriteria(MasStoreItem.class)
							.add(Restrictions.eq("Section.Id", sectionId));
					List<MasStoreItem> masStoreItems=criteria.list();
					dataMap.put("masStoreItems", masStoreItems);
					return dataMap;
				}
				
				public Map checkExistingVaccineMaster(Map<String, Object> generalMap) {
					Map<String, Object> dataMap=new HashMap<String,Object>();
					boolean dataUpdated = false; 
					String vaccinCode = ""; 
					int masStoreItemId = 0;
					int dose=0; 
					String vaccinName="";
					int genderId=0;
					int vaccinId=0;
					org.hibernate.Session session=getSession();
					try {
						 
						vaccinCode = (String) generalMap.get("code");
						genderId = (Integer) generalMap.get("genderId");
						masStoreItemId = (Integer)generalMap.get("masStoreItemId");
						vaccinId= (Integer)generalMap.get("id");
						 List<OpdVaccinMst> vaccinMstsList= new ArrayList<OpdVaccinMst>();
							
						/*Box box=(Box)generalMap.get("box");
						dose=box.getInt("vaccineDose");   
						 Criteria criteria=session.createCriteria(OpdVaccinMst.class)
								 .add(Restrictions.eq("VaccinName", vaccinName)) 
								 .add(Restrictions.eq("MasStoreItem.Id", masStoreItemId))
								 .add(Restrictions.eq("Dose", dose));*/
						 
			if(vaccinId!=0){
				vaccinName = (String) generalMap.get("name");
				System.out.println(vaccinName+"vaccinName");
				if(!vaccinName.equals("")){
				 Criteria criteria=session.createCriteria(OpdVaccinMst.class)
						 .add(Restrictions.eq("VaccinCode", vaccinCode))
						.add(Restrictions.ne("Id", vaccinId)) 
						.add(Restrictions.like("VaccinName", vaccinName)) 
						 .add(Restrictions.eq("Gender.Id", genderId))
						 ;
				 vaccinMstsList=criteria.list();	
				}else{
					Criteria criteria=session.createCriteria(OpdVaccinMst.class)
							 .add(Restrictions.eq("VaccinCode", vaccinCode))
							.add(Restrictions.ne("Id", vaccinId)) 
							 .add(Restrictions.eq("Gender.Id", genderId))
							 .add(Restrictions.eq("MasStoreItem.Id", masStoreItemId));
					 vaccinMstsList=criteria.list();
				}
				
			}else{
						 Criteria criteria=session.createCriteria(OpdVaccinMst.class)
								 .add(Restrictions.eq("VaccinCode", vaccinCode))
								 //.add(Restrictions.eq("VaccinName", vaccinName)) 
								 .add(Restrictions.eq("Gender.Id", genderId))
								 .add(Restrictions.eq("MasStoreItem.Id", masStoreItemId));
						 vaccinMstsList=criteria.list();	
			}	 
							
						 	
			dataMap.put("duplicateMastersList", vaccinMstsList);		
							
							
					} catch (DataAccessException e) {
						e.printStackTrace();
					}
					 catch (Exception e) {
							e.printStackTrace();
						} 
					return dataMap;
				}



				public Map<String, Object> getConnection() {
					Session session = (Session) getSession();
					Connection con = (Connection) session.connection();
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("conn", con);
					return map;
				}
				
				public Map<String, Object> showNewOpdVaccinJsp() {
					Map<String, Object> map = new HashMap<String, Object>();
					List<MasVaccineItem> searchOpdVaccinList = new ArrayList<MasVaccineItem>();
					
					Session session = (Session)getSession();
					searchOpdVaccinList = session.createCriteria(MasVaccineItem.class)
											//.add(Restrictions.eq("Status", "y").ignoreCase())
											//.addOrder(Order.asc("MasStoreItem.Id"))
											//.addOrder(Order.asc("VaccinName")) 
											//.addOrder(Order.asc("VaccinCode"))//govind code 14-7-2016
											//.addOrder(Order.asc("SrNo")) 
											.list();
					//List<MasAdministrativeSex> genderList = new ArrayList<MasAdministrativeSex>();
					//genderList = session.createCriteria(MasAdministrativeSex.class)
							//.add(Restrictions.eq("Status", "y").ignoreCase()).list();
					map.put("searchOpdVaccinList", searchOpdVaccinList);
					//map.put("genderList", genderList);

					return map;
				}

				public boolean addOpdVaccinNew(MasVaccineItem masVaccine){
					boolean successfullyAdded = false;
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.save(masVaccine);
					successfullyAdded = true;
					return successfullyAdded;

				}

				public Map checkExistingVaccineNewMaster(Map<String, Object> generalMap) {
								Map<String, Object> dataMap=new HashMap<String,Object>();
								//boolean dataUpdated = false; 
								//String vaccinCode = ""; 
								//int masStoreItemId = 0;
								//int dose=0; 
								String vaccineName="";
								//int genderId=0;
								int vaccinId=0;
								int orderNo=0;
								org.hibernate.Session session=getSession();
								try {
									 
									//vaccinCode = (String) generalMap.get("code");
									orderNo = (Integer) generalMap.get("orderNo");
									//genderId = (Integer) generalMap.get("genderId");
									//masStoreItemId = (Integer)generalMap.get("masStoreItemId");
									vaccinId= (Integer)generalMap.get("id");
									 List<MasVaccineItem> vaccinMstsList= new ArrayList<MasVaccineItem>();
										
									/*Box box=(Box)generalMap.get("box");
									dose=box.getInt("vaccineDose");   
									 Criteria criteria=session.createCriteria(OpdVaccinMst.class)
											 .add(Restrictions.eq("VaccineName", VaccineName)) 
											 .add(Restrictions.eq("MasStoreItem.Id", masStoreItemId))
											 .add(Restrictions.eq("Dose", dose));*/
									 vaccineName = (String) generalMap.get("vaccineName");		 
						if(vaccinId!=0){
							
							System.out.println(vaccineName+"vaccineName");
							if(!vaccineName.equals("")){
							 Criteria criteria=session.createCriteria(MasVaccineItem.class)
									// .add(Restrictions.eq("VaccinCode", vaccinCode))
									.add(Restrictions.ne("Id", vaccinId)) 
									//.add(Restrictions.like("VaccineName", vaccineName)) 
									 .add(Restrictions.or(Restrictions.eq("VaccineName", vaccineName), Restrictions.eq("OrderNo", orderNo)));
									// .add(Restrictions.eq("Gender.Id", genderId))
									 ;
							 vaccinMstsList=criteria.list();	
							}else{
								Criteria criteria=session.createCriteria(OpdVaccinMst.class)
										// .add(Restrictions.eq("VaccinCode", vaccinCode))
										.add(Restrictions.ne("Id", vaccinId));
										// .add(Restrictions.eq("Gender.Id", genderId))
										// .add(Restrictions.eq("MasStoreItem.Id", masStoreItemId));
								 vaccinMstsList=criteria.list();
							}
							
						}else{
									 Criteria criteria=session.createCriteria(MasVaccineItem.class)
											// .add(Restrictions.eq("VaccinCode", vaccinCode))
											 //.add(Restrictions.eq("VaccineName", VaccineName)) 
											// .add(Restrictions.eq("Gender.Id", genderId))
											 .add(Restrictions.or(Restrictions.eq("VaccineName", vaccineName), Restrictions.eq("OrderNo", orderNo)));
											 //.add(Restrictions.eq("MasStoreItem.Id", masStoreItemId));
									 vaccinMstsList=criteria.list();	
									 System.out.println("fsaff"+vaccineName +" orderNo="+orderNo);
						}	 
										
									 	
						dataMap.put("duplicateMastersList", vaccinMstsList);		
										
										
								} catch (DataAccessException e) {
									e.printStackTrace();
								}
								 catch (Exception e) {
										e.printStackTrace();
									} 
								return dataMap;
							}
			
				public boolean editNewOpdVaccinToDatabase(Map<String, Object> generalMap) {
					boolean dataUpdated = false;
					Date currentDate = null;
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
							"currentTime");
					int vaccinId = 0;
					int orderNo = 0;
					String vaccinName ="";
					int userId = 0;
		
					try {
						vaccinId = (Integer) generalMap.get("id");
						orderNo = (Integer) generalMap.get("orderNo");
						//genderId = (Integer) generalMap.get("genderId");
						//vaccinCode = (String) generalMap.get("vaccinCode");

						vaccinName = (String) generalMap.get("vaccineName");
						//vaccinDuration = (Integer) generalMap.get("vaccinDuration");
						//changedBy = (String) generalMap.get("changedBy");
						currentDate = (Date) generalMap.get("currentDate");
						currentTime = (String) generalMap.get("currentTime");
						userId = (Integer)generalMap.get("userId");
						//masStoreItemId = (Integer)generalMap.get("masStoreItemId");
						
						//dose=box.getInt("vaccineDose");
					/*	if(generalMap.get("maxDays")!=null){
							maxDays=(Integer)generalMap.get("maxDays");
						}*/
						
						

					} catch (Exception e) {
						e.printStackTrace();
					}

					MasVaccineItem opdVaccin = (MasVaccineItem) getHibernateTemplate().get(
							MasVaccineItem.class, vaccinId);
					System.out.println("vaccinId"+vaccinId);
					opdVaccin.setId(vaccinId);
					opdVaccin.setOrderNo(orderNo);
					opdVaccin.setVaccineName(vaccinName);
					//opdVaccin.setVaccinDuration(vaccinDuration);
					//opdVaccin.setVaccinToDays(maxDays);
					
					Users users = new Users();
					users.setId(userId);
					opdVaccin.setLastChgBy(users);
					opdVaccin.setLastChgDate(currentDate);
					opdVaccin.setLastChgTime(currentTime);
				/*	if(masStoreItemId!=0){
						MasStoreItem item=new MasStoreItem(masStoreItemId);
						opdVaccin.setMasStoreItem(item);
					}*/
					
					
					/*MasAdministrativeSex gender=new MasAdministrativeSex();
					gender.setId(genderId);
					opdVaccin.setGender(gender);
					
					opdVaccin.setDose(dose);
					opdVaccin.setVaccinType((String)generalMap.get("type")); // added by amit das on 05-08-2016
					*/
					try {
						org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
						hbt.update(opdVaccin);
						dataUpdated = true;
					} catch (DataAccessException e) {
						e.printStackTrace();
					}
					return dataUpdated;
				}
				
				@SuppressWarnings("unchecked")
				public boolean deleteNewOpdVaccin(int vaccinId, Map<String, Object> generalMap) {
					boolean dataDeleted = false;
					String changedBy = "";
					int userId = 0;
					Date currentDate = new Date();
					String currentTime = "";
					currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
							"currentTime");
					MasVaccineItem opdVaccin = new MasVaccineItem();
					opdVaccin = (MasVaccineItem) getHibernateTemplate().get(
							MasVaccineItem.class, vaccinId);
					changedBy = (String) generalMap.get("changedBy");
					currentDate = (Date) generalMap.get("currentDate");
					currentTime = (String) generalMap.get("currentTime");
					userId = (Integer)generalMap.get("userId");
					if (generalMap.get("flag") != null) {
						String flag = (String) generalMap.get("flag");
						if (flag.equals("InActivate")) {
							opdVaccin.setStatus("n");
							dataDeleted = true;
						} else if (flag.equals("Activate")) {
							opdVaccin.setStatus("y");
							dataDeleted = false;
						}
					}
					Users users = new Users();
					users.setId(userId);
					//opdVaccin.setLastChgBy(users);
					//opdVaccin.setLastChgDate(currentDate);
					//opdVaccin.setLastChgTime(currentTime);
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.saveOrUpdate(opdVaccin);
					return dataDeleted;
				}
				
				
				
				
				@Override
				public boolean addTreatmentAdvice(PatientFamilyHistory patientFamilyHistory) {
					boolean successfullyAdded = false;
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.save(patientFamilyHistory);
					successfullyAdded = true;
					return successfullyAdded;
				}

				@Override
				public Map<String, Object> showTreatmentAdviceJsp() {
					Session session =(Session)getSession();
					Map<String, Object> map = new HashMap<String, Object>();
					List<PatientFamilyHistory> searchPatientFamilyHistoryList = new ArrayList<PatientFamilyHistory>();
					searchPatientFamilyHistoryList =session.createCriteria(PatientFamilyHistory.class).add(Restrictions.eq("TemplateCode","TA")).addOrder(Order.asc("PatientPresentComplaintName")).list();
					List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
					 String	departmentTypeCode =HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentTypeCodeForOpd");
						
					   departmentList = session.createCriteria(MasDepartment.class)
								.add(Restrictions.eq("Status","y").ignoreCase())
								.createAlias("DepartmentType", "dt")
								.add(Restrictions.or(Restrictions.eq("dt.DepartmentTypeCode",departmentTypeCode), Restrictions.eq("dt.DepartmentTypeCode","OT")))
															
								.addOrder(Order.asc("DepartmentName"))
								.list();

					   map.put("departmentList", departmentList);
					map.put("searchPatientFamilyHistoryList", searchPatientFamilyHistoryList);
					return map;
				}

				@Override
				public boolean deleteTreatmentAdvice(int familyHistoryId,
						Map<String, Object> generalMap) {
					  boolean dataDeleted=false;
					  int userId = 0;
					  Date currentDate = new Date();
					  String currentTime= "";
					  currentTime =(String)HMSUtil.getCurrentDateAndTime().get("currentTime");
					  try{
						  PatientFamilyHistory patientFamilyHistory= new PatientFamilyHistory();
						  patientFamilyHistory=(PatientFamilyHistory)getHibernateTemplate().load(PatientFamilyHistory.class,familyHistoryId); 
					  userId =(Integer)generalMap.get("changedBy");
					  currentDate=(Date)generalMap.get("currentDate");
					  currentTime=(String)generalMap.get("currentTime");
					  if (patientFamilyHistory.getStatus().equalsIgnoreCase("y")){
						  patientFamilyHistory.setStatus("n");
					  dataDeleted=true; 
					  }else{
						  patientFamilyHistory.setStatus("y");
					  dataDeleted=false;
					  }
					  Users users = new Users();
					  users.setId(userId);
					  patientFamilyHistory.setLastChgBy(users);
					  patientFamilyHistory.setLastChgDate(currentDate);
					  patientFamilyHistory.setLastChgTime(currentTime);
					  org.springframework.orm.hibernate3.HibernateTemplate hbt =
					  getHibernateTemplate();
					  hbt.setFlushModeName("FLUSH_EAGER");
					  hbt.setCheckWriteOperations(false);
					  hbt.update(patientFamilyHistory);
					  }catch
					  (Exception e) { 
					  } return dataDeleted;
				  }

				@Override
				public boolean editTreatmentAdviceToDatabase(Map<String, Object> generalMap) {
					  boolean dataUpdated=false;
					  Date currentDate = new Date();
					  String currentTime = "";
					  currentTime =(String)HMSUtil.getCurrentDateAndTime().get("currentTime"); 
					  String patientPresentComplaintName=""; 
					 int patientFamilyHistoryId=0;
					 int userId = 0;
					 int deptId = 0;
					 patientFamilyHistoryId=(Integer)generalMap.get("id");
					  
					 patientPresentComplaintName=(String)generalMap.get("name");
					  userId = (Integer)generalMap.get("userId");
					  deptId = (Integer)generalMap.get("deptId");
					  currentDate=(Date)generalMap.get("currentDate");
					  currentTime=(String)generalMap.get("currentTime");
					  System.out.println("familyHistoryId---------"+patientFamilyHistoryId);
					  
					  PatientFamilyHistory patientFamilyHistory =(PatientFamilyHistory)getHibernateTemplate().load(PatientFamilyHistory.class, patientFamilyHistoryId);
					  
					  patientFamilyHistory.setId(patientFamilyHistoryId);
					  
					  patientFamilyHistory.setPatientPresentComplaintName(patientPresentComplaintName);
					  patientFamilyHistory.setDepartmentId(new MasDepartment(deptId));
					  patientFamilyHistory.setTemplateCode("TA");
					  Users users = new Users();
					  users.setId(userId);
					  patientFamilyHistory.setLastChgBy(users);
					  
					  patientFamilyHistory.setLastChgDate(currentDate);
					  patientFamilyHistory.setLastChgTime(currentTime);
					  org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					  hbt.setFlushModeName("FLUSH_EAGER");
					  hbt.setCheckWriteOperations(false);
					  hbt.update(patientFamilyHistory);
					  dataUpdated = true; 
				  return dataUpdated;
				  }

				@Override
				public Map<String, Object> searchTreatmentAdvice(String patientPresentComplaintName) { 
					  List<PatientFamilyHistory> searchPatientFamilyHistoryList=new ArrayList<PatientFamilyHistory>();
					  List<MasDepartment> departmentList=new ArrayList<MasDepartment>();
					  Map patientFamilyHistoryMap = new HashMap();
						Session session =(Session)getSession();
						String	departmentTypeCode =HMSUtil.getValuesFromPropertiesFile("adt.properties", "departmentTypeCodeForOpd");
					  try{
					  if((patientPresentComplaintName!=null)){
						  
						  searchPatientFamilyHistoryList =session.createCriteria(PatientFamilyHistory.class).add(Restrictions.like("PatientPresentComplaintName","%"+patientPresentComplaintName+"%").ignoreCase()).add(Restrictions.eq("TemplateCode","TA")).addOrder(Order.asc("PatientPresentComplaintName")).list();
				  	 } 
					  
					  departmentList = session.createCriteria(MasDepartment.class)
								.add(Restrictions.eq("Status","y").ignoreCase())
								.createAlias("DepartmentType", "dt")
								.add(Restrictions.or(Restrictions.eq("dt.DepartmentTypeCode",departmentTypeCode), Restrictions.eq("dt.DepartmentTypeCode","OT")))
															
								.addOrder(Order.asc("DepartmentName"))
								.list();

					   
					  }catch (Exception e) {
				   }
					  patientFamilyHistoryMap.put("departmentList",departmentList);
					  patientFamilyHistoryMap.put("searchPatientFamilyHistoryList",searchPatientFamilyHistoryList);
				  return patientFamilyHistoryMap;
				  }

				

}
