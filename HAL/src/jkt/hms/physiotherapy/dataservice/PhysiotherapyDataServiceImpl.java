package jkt.hms.physiotherapy.dataservice;

import static jkt.hms.util.RequestConstants.APPOINTMENT_DATE;


import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.FROM_TIME;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_DATE;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_TIME;
import static jkt.hms.util.RequestConstants.MARITAL_STATUS_ID;
import static jkt.hms.util.RequestConstants.MEDICAL_OFFICER;
import static jkt.hms.util.RequestConstants.MEDICAL_OFFICER_ID;
import static jkt.hms.util.RequestConstants.RANK_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.SECTION_ID;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_STATUS_ID;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID;
import static jkt.hms.util.RequestConstants.SEX_ID;
import static jkt.hms.util.RequestConstants.THERAPY_TYPE;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TO_TIME;
import static jkt.hms.util.RequestConstants.TRADE_ID;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.VISIT_ID;
import static jkt.hms.util.RequestConstants.RADIO_FOR_TABLE;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;


import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import jkt.hms.masters.business.InjAppointmentDetails;
import jkt.hms.masters.business.InjAppointmentHeader;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasSection;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasTherapyType;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.PhysioAppointmentDetail;
import jkt.hms.masters.business.PhysioAppointmentHeader;
import jkt.hms.masters.business.PhysioRequisitionDetail;
import jkt.hms.masters.business.PhysioRequisitionHeader;
import jkt.hms.masters.business.PhysioVisitEntryDetail;
import jkt.hms.masters.business.PhysioVisitEntryHeader;
import jkt.hms.masters.business.PhysiotherapyAppointment;
import jkt.hms.masters.business.PhysiotherapyDetails;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PhysiotherapyDataServiceImpl extends HibernateDaoSupport implements PhysiotherapyDataService {

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showTherapyTypeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTherapyType> searchTherapyTypeList = new ArrayList<MasTherapyType>();
		Session session = (Session)getSession();
		searchTherapyTypeList = session.createCriteria(MasTherapyType.class).list();
		map.put("searchTherapyTypeList", searchTherapyTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> searchTherapyType(String therapyTypeCode,
			String therapyTypeName) {
		List<MasTitle> searchTherapyTypeList = new ArrayList<MasTitle>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			if ((therapyTypeName != null) || (therapyTypeCode == null)) {
				String str= therapyTypeName+"%";
				searchTherapyTypeList = session.createCriteria(MasTherapyType.class)
				.add(Restrictions.like("TherapyTypeName", str).ignoreCase())
				.addOrder(Order.asc("TherapyTypeName")).list();
			//getHibernateTemplate().find(
				//		"from jkt.hms.masters.business.MasTherapyType imc where imc.TherapyTypeName like '"
								//+ therapyTypeName + "%' order by imc.TherapyTypeName");
			} else {
				String strn = therapyTypeCode + "%";
				searchTherapyTypeList = session.createCriteria(MasTherapyType.class)
				.add(Restrictions.like("TherapyTypeCode", strn).ignoreCase())
				.addOrder(Order.asc("TherapyTypeCode")).list();
					//getHibernateTemplate().find(
						//"from jkt.hms.masters.business.MasTherapyType imc where imc.TherapyTypeCode like '"
							//	+ therapyTypeCode + "%' order by imc.TherapyTypeCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchTherapyTypeList", searchTherapyTypeList);
		return map;
	}

	@Override
	public boolean addTherapyType(MasTherapyType therapyType) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(therapyType);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@Override
	public boolean editTherapyType(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		Date currentDate = new Date();
		String therapyTypeCode="";
		String therapyTypeName="";
		int therapyTypeId	=0;
		String changedTime = "";
		int userId = 0;
		try {
			therapyTypeId = (Integer) generalMap.get("id");
			therapyTypeCode = (String) generalMap.get("code");
			therapyTypeName = (String) generalMap.get("name");
			userId = (Integer) generalMap.get("userId");
			currentDate = (Date) generalMap.get("currentDate");
			changedTime = (String) generalMap.get("currentTime");
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasTherapyType therapyType = (MasTherapyType) getHibernateTemplate().get(MasTherapyType.class, therapyTypeId);

		therapyType.setTherapyTypeCode(therapyTypeCode);
		therapyType.setTherapyTypeName(therapyTypeName);
		therapyType.setStatus("y");
		Users chgBy = new Users();
		chgBy.setId(userId);
		therapyType.setLastChgBy(chgBy);
		therapyType.setLastChgDate(currentDate);
		therapyType.setLastChgTime(changedTime);
		
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(therapyType);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	@Override
	public boolean deleteTherapyType(int therapyTypeId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		int userId = (Integer) generalMap.get("userId");
		MasTherapyType masTherapyType = new MasTherapyType();
		masTherapyType = (MasTherapyType) getHibernateTemplate().get(MasTherapyType.class,therapyTypeId);
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masTherapyType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masTherapyType.setStatus("y");
				dataDeleted = false;
			}
		}
		Users user = new Users();
		user.setId(userId);
		masTherapyType.setLastChgBy(user);
		masTherapyType.setLastChgDate(currentDate);
		masTherapyType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masTherapyType);
		return dataDeleted;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPhyWaitingList(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
//		List<Visit> patientList = new ArrayList<Visit>();
		List<PhysioRequisitionHeader> patientList = new ArrayList<PhysioRequisitionHeader>();
		Map<String, Object> map = new HashMap<String, Object>();
		String currentDate = "";
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		if(mapForDS.get("currentDate") != null){
			currentDate = (String)mapForDS.get("currentDate");
		}
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		try {
		/*	patientList = session.createCriteria(Visit.class).createAlias("ReportingFor", "rf").add(
					Restrictions.eq("rf.ReportingName", "Physiotherapy")).add(
					Restrictions.eq("VisitStatus", "w")).addOrder(
					Order.asc("TokenNo")).createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).list();
*/
			
			patientList = session.createCriteria(PhysioRequisitionHeader.class).add(Restrictions.eq("Status", "p"))
							.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
							.add(Restrictions.eq("ReqDate", date)).list();
					
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getDetailsForPhysiotherapy(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int physioTharapyHeaderId = box.getInt("physioTharapyHeaderId");
		List<MasTherapyType> therapyTypeList = new ArrayList<MasTherapyType>();
		List<PhysioRequisitionDetail> phyVisitList = new ArrayList<PhysioRequisitionDetail>();
		List<MasFrequency>frequencyList = new ArrayList<MasFrequency>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<PhysioAppointmentDetail> nextAppointmentList = new ArrayList<PhysioAppointmentDetail>();
		Session session =(Session)getSession();
		Date currentDate = new Date();
		
		therapyTypeList = session.createCriteria(MasTherapyType.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("TherapyTypeName")).list();
		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y")).list();
		phyVisitList = session.createCriteria(PhysioRequisitionDetail.class).createAlias("PhysioRequisitionHeader", "header").add(Restrictions.eq("header.Id", physioTharapyHeaderId)).list();
		if(phyVisitList.size()>0){
			for(PhysioRequisitionDetail physioRequisitionDetail :phyVisitList){
				int therapyId = physioRequisitionDetail.getTharaphy().getId();
				nextAppointmentList = session.createCriteria(PhysioAppointmentDetail.class).add(Restrictions.gt("AppointmentDate", currentDate)).add(Restrictions.eq("Therapy.Id", therapyId))
				.createAlias("AppointmentHeader", "header").createAlias("header.Visit", "visit")
				.add(Restrictions.eq("visit.Id", box.getInt("visitId"))).addOrder(Order.asc("Id")).setFirstResult(1).list();
				
			}
		}
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		
		doctorList = session.createCriteria(MasEmployee.class).createAlias("Hospital", "h")
			.add(Restrictions.eq("h.Id", box.getInt("hospitalId"))).createAlias("EmpCategory", "ec")
			.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
			.add(Restrictions.eq("Status","y")).addOrder(Order.asc("FirstName")).list();
		map.put("doctorList", doctorList);
		map.put("nextAppointmentList", nextAppointmentList);
		map.put("therapyTypeList", therapyTypeList);
		map.put("phyVisitList", phyVisitList);
		map.put("frequencyList", frequencyList);
		return map;
	}
	@Override
	public Map<String, Object> getDetailsForPhysiotherapyVisitForAppointement(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int physioTharapyAppointmentHeaderId = box.getInt("physioTharapyAppointmentHeaderId");
		int physioRequisitionId = box.getInt("physioRequisitionHeaderId");
		List<MasTherapyType> therapyTypeList = new ArrayList<MasTherapyType>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		Session session =(Session)getSession();
		List<MasFrequency>frequencyList = new ArrayList<MasFrequency>();
		List<PhysioRequisitionDetail> physioRequisitionList = new ArrayList<PhysioRequisitionDetail>();
		
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		
		doctorList = session.createCriteria(MasEmployee.class).createAlias("Hospital", "h")
			.add(Restrictions.eq("h.Id", box.getInt("hospitalId"))).createAlias("EmpCategory", "ec")
			.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
			.add(Restrictions.eq("Status","y")).addOrder(Order.asc("FirstName")).list();
		therapyTypeList = session.createCriteria(MasTherapyType.class).add(Restrictions.eq("Status","y")).list();
		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y")).list();
		List<PhysioAppointmentDetail> phyAppointmentList = new ArrayList<PhysioAppointmentDetail>();
		phyAppointmentList = session.createCriteria(PhysioAppointmentDetail.class).createAlias("AppointmentHeader", "header").add(Restrictions.eq("header.Id", physioTharapyAppointmentHeaderId)).list();
		List<MasDepartment> searchMasDepartmentList = new ArrayList<MasDepartment>();
			searchMasDepartmentList =session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y")).list();
			physioRequisitionList = session.createCriteria(PhysioRequisitionDetail.class).createAlias("PhysioRequisitionHeader", "header").add(Restrictions.eq("header.Id", physioRequisitionId)).list();
		
		map.put("therapyTypeList", therapyTypeList);
		map.put("doctorList", doctorList);
		//map.put("patientList", patientList);
		map.put("phyAppointmentList", phyAppointmentList);
		map.put("physioRequisitionList", physioRequisitionList);
		map.put("frequencyList", frequencyList);
		map.put("searchMasDepartmentList", searchMasDepartmentList);
		return map;
	}
	@Override
	public Map<String, Object> searchPhyWaitingListJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<PhysioRequisitionHeader> patientList = new ArrayList<PhysioRequisitionHeader>();
		List<PhysioAppointmentHeader> appointmentList = new ArrayList<PhysioAppointmentHeader>();
		List<MasTherapyType> therapyTypeList = new ArrayList<MasTherapyType>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
		
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		doctorList = session.createCriteria(MasEmployee.class).createAlias("Hospital", "h")
			.add(Restrictions.eq("h.Id", box.getInt("hospitalId"))).createAlias("EmpCategory", "ec")
			.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
			.add(Restrictions.eq("Status","y")).addOrder(Order.asc("FirstName")).list();
		therapyTypeList = session.createCriteria(MasTherapyType.class).add(Restrictions.eq("Status","y")).list();		
			//patientList = session.createCriteria(PhysioRequisitionHeader.class).add(Restrictions.eq("Status", "p")).createAlias("Hospital", "h").add(Restrictions.eq("h.Id", box.getInt("hospitalId"))).list();
			if(box.getInt(SELECTED_RADIO) == 1 || box.getInt(SELECTED_RADIO) == 3){
				Criteria crit = session.createCriteria(PhysioRequisitionHeader.class)
				.add(Restrictions.eq("Status", "p"))
				.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", box.getInt("hospitalId")));

				if(!box.getString(FROM_DATE).equals("") && !box.getString(TO_DATE).equals("")){
					Date fromDate = HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE));
					Date toDate = HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE));
					crit  = crit.add(Restrictions.between("ReqDate", fromDate, toDate));
				}
				if (box.getInt(MEDICAL_OFFICER) != 0) {
					crit = crit.createAlias("MedicalOfficer", "mo").add(Restrictions.eq("mo.Id", box.getInt(MEDICAL_OFFICER)));
				}
				if(box.getString(DEPARTMENT_ID).equals("OP")){
					crit = crit.add(Restrictions.eq("PatientType", "OP"));
				}else{
					crit = crit.add(Restrictions.eq("PatientType", "IP"));
				}
				if(box.getInt(THERAPY_TYPE) != 0){
					crit = crit.createAlias("PhysioRequisitionDetails", "detail").createAlias("detail.Tharaphy", "tharaphy").add(Restrictions.eq("tharaphy.Id", box.getInt(THERAPY_TYPE) ));

				}
				patientList = crit.list();
			}
			
			if(box.getInt(SELECTED_RADIO) == 2 || box.getInt(SELECTED_RADIO) == 3){
				Criteria criteria = session.createCriteria(PhysioAppointmentHeader.class)
				.add(Restrictions.eq("Status", "A"))
				 .createAlias("Hospital", "h").add(Restrictions.eq("h.Id", box.getInt("hospitalId")));
				
				if(!box.getString(FROM_DATE).equals("") && !box.getString(TO_DATE).equals("")){
					Date fromDate = HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE));
					Date toDate = HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE));
					criteria  = criteria.add(Restrictions.between("AppointmentDate", fromDate, toDate));
				}
				if (box.getInt(MEDICAL_OFFICER) != 0) {
					criteria = criteria.createAlias("MedicalOfficer", "mo").add(Restrictions.eq("mo.Id", box.getInt(MEDICAL_OFFICER) ));
				}
				if(box.getString(DEPARTMENT_ID).equals("OP")){
					criteria = criteria.add(Restrictions.eq("PatientType", "OP"));
				}else {
					criteria = criteria.add(Restrictions.eq("PatientType", "IP"));
				}
				if(box.getInt(THERAPY_TYPE) != 0){
					criteria = criteria.createAlias("PhysioAppointmentDetails", "detail").createAlias("detail.Tharaphy", "tharaphy").add(Restrictions.eq("tharaphy.Id", box.getInt(THERAPY_TYPE) ));
		
				}
		
				appointmentList = criteria.list();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		map.put("doctorList", doctorList);
		map.put("therapyTypeList", therapyTypeList);
		map.put("appointmentList", appointmentList);
		return map;
	}

	@Override
	public Map<String, Object> savePhysiotherapyDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Transaction tx = null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean saved = false;
		boolean appointmentFlag = false;
		int physioRequisitionHeaderId = 0;
		Session session = (Session)getSession();
		List<PhysioVisitEntryDetail> physioDirectVisitDetailList = new ArrayList<PhysioVisitEntryDetail>();
		
		try {
			tx = session.beginTransaction();
			String flagString = "";
			if(!box.getString("flag").equals("")){
				flagString =box.getString("flag");
			}
			int tharapyCount = box.getInt("tharapyCount");
			//---------------save data in visit table for direct visit Entry---------------------
			Visit visitForPhysio = new Visit();	
			if(box.getInt(VISIT_ID) == 0 && box.getInt("inpatientId")==0){
			List<Patient> patientListForVisitNo = new ArrayList<Patient>();
			patientListForVisitNo = session.createCriteria(Patient.class).add(Restrictions.idEq(box.getInt(HIN_ID))).list();
			int visitNo = 0;
			int currentVisitNo = 0;
			String age = "";
			if(patientListForVisitNo.size()>0){
				Patient pt = patientListForVisitNo.get(0);
				visitNo = pt.getCurrentVisitNo();
				currentVisitNo = visitNo+1;
				age = pt.getAge();
			}
			Patient patientForVisit =(Patient)hbt.load(Patient.class, box.getInt(HIN_ID));
			patientForVisit.setCurrentVisitNo(currentVisitNo);
			hbt.update(patientForVisit);
		
			visitForPhysio.setVisitNo(currentVisitNo);
			visitForPhysio.setVisitDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			visitForPhysio.setVisitTime(box.getString(LAST_CHANGED_TIME));
	        Patient patientObj = new Patient();
	        patientObj.setId(box.getInt(HIN_ID));
			visitForPhysio.setHin(patientObj);	
			visitForPhysio.setAge(age);	
			Users userObj = new Users();
			userObj.setId(box.getInt("userId"));
			visitForPhysio.setAddEditBy(userObj);
			visitForPhysio.setAddEditDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			visitForPhysio.setAddEditTime(box.getString(LAST_CHANGED_TIME));
			visitForPhysio.setStatus("y");
			visitForPhysio.setVisitStatus("C");
			visitForPhysio.setAppointmentType("D");
			MasHospital hosp = new MasHospital();
			hosp.setId(box.getInt("hospitalId"));
			visitForPhysio.setHospital(hosp);
			visitForPhysio.setReportingFor("Physiotherapy");
			visitForPhysio.setTokenNo(0);
			visitForPhysio.setPhyStatus("CV");
			visitForPhysio.setPriority(3);
			hbt.save(visitForPhysio);
			}
			//=------------------------------------------------------------------------
			PhysioVisitEntryHeader physioVisitEntryHeader = new PhysioVisitEntryHeader();
			Patient patient = new Patient();
			patient.setId(box.getInt(HIN_ID));
			physioVisitEntryHeader.setHin(patient);
			if(box.getInt(VISIT_ID) != 0  && box.getInt("inpatientId")==0){
			Visit visit = new Visit();
			visit.setId(box.getInt(VISIT_ID));
			physioVisitEntryHeader.setVisit(visit);
			}else if(box.getInt(VISIT_ID) == 0 && box.getInt("inpatientId")==0){
				physioVisitEntryHeader.setVisit(visitForPhysio);
			}
			if(box.getInt(INPATIENT_ID)!=0){
				Inpatient inpatient = new Inpatient();
				inpatient.setId(box.getInt(INPATIENT_ID));
				physioVisitEntryHeader.setInpatient(inpatient);
			}
			if(box.getInt(MEDICAL_OFFICER_ID)!= 0){
			MasEmployee employee = new MasEmployee();
			employee.setId(box.getInt(MEDICAL_OFFICER_ID));
			physioVisitEntryHeader.setMedicalOfficer(employee);
			}
			if(!box.getString("phyCompleted").equals("")){
				physioVisitEntryHeader.setPhyStatus("C");
			}
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			physioVisitEntryHeader.setHospital(hospital);
			Users user = new Users();
			user.setId(box.getInt("userId"));
			physioVisitEntryHeader.setLastChgBy(user);
			physioVisitEntryHeader.setStatus("y");
			if(box.getInt("physioRequisitionHeaderId") != 0){
				PhysioRequisitionHeader physioRequisitionHeader = new PhysioRequisitionHeader();
				physioRequisitionHeader.setId(box.getInt("physioRequisitionHeaderId"));
				physioVisitEntryHeader.setPhysioRequisition(physioRequisitionHeader);
			}
			physioVisitEntryHeader.setPatientType("OP");
			physioVisitEntryHeader.setVisitStatus("CV");
			physioVisitEntryHeader.setPhysioVisitDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			physioVisitEntryHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			physioVisitEntryHeader.setLastChgTime(box.getString(LAST_CHANGED_TIME));
			physioVisitEntryHeader.setDiagnosis(box.getString("diagnosis"));
			hbt.save(physioVisitEntryHeader);
			for (int j = 1; j <= tharapyCount; j++) {
				PhysioVisitEntryDetail physioVisitEntryDetail = new PhysioVisitEntryDetail();
				if(box.getInt("therapyId"+j) != 0){
				MasTherapyType therapyType = new MasTherapyType();
				therapyType.setId(box.getInt("therapyId"+j));
				physioVisitEntryDetail.setTharapy(therapyType);
				MasFrequency masFrequency = new MasFrequency();
				if(box.getInt("frequency"+j) != 0){
				masFrequency.setId(box.getInt("frequency"+j));
				physioVisitEntryDetail.setFrequency(masFrequency);
				}
				physioVisitEntryDetail.setVisitEntryHeader(physioVisitEntryHeader);
				physioVisitEntryDetail.setDuration(box.getString("duration"+j).trim());
				physioVisitEntryDetail.setNoOfDays(box.getInt("noOfDays"+j));
				physioVisitEntryDetail.setSittingTime(box.getString("sittingTime"+j));
				if(box.getString("remarks"+j) != null){
					physioVisitEntryDetail.setRemarks(box.getString("remarks"+j));
				}
				physioVisitEntryDetail.setTimeBegin(box.getString("timeBegin"+j));
				physioVisitEntryDetail.setTimeComplete(box.getString("timeComplete"+j));
				/*if(!box.getString("nextApptDate").equals(""))
					physioVisitEntryDetail.setNextAppDate(HMSUtil.convertStringTypeDateToDateType(box.getString("nextAppointmentDate"+j)));
				if(!box.getString("nextAppointmentTime").equals("")){
				physioVisitEntryDetail.setNextAppTime(box.getString("nextAppointmentTime"+j));
				}*/
				hbt.save(physioVisitEntryDetail);
				hbt.flush();
			//	physioDirectVisitDetailList.add(physioVisitEntryDetail);
				}
				
			}
			for (int j = 1; j <= tharapyCount; j++) {
				if(box.getInt("noOfDays"+j)>1 && box.getInt("frequency"+j) != 1 ){
					appointmentFlag = true;
					break;
				}
				
			}
			System.out.println("appointmentFlag------>"+appointmentFlag);
			//if(!box.getString("phyCompleted").equals("")){
			if(box.getInt("physioRequisitionHeaderId")!=0){
				 physioRequisitionHeaderId = box.getInt("physioRequisitionHeaderId");
				PhysioRequisitionHeader physioRequisitionHeader2 = (PhysioRequisitionHeader)hbt.load(PhysioRequisitionHeader.class, physioRequisitionHeaderId);
				physioRequisitionHeader2.setStatus("c");
				hbt.update(physioRequisitionHeader2);
				
			 }
			//}
			if(box.getString("flag").equals("visitWaiting") && box.getInt(VISIT_ID)!= 0){
				Visit visit = (Visit)hbt.load(Visit.class, box.getInt(VISIT_ID));
				visit.setVisitStatus("c");
				hbt.update(visit);
			}
			
			saved = true;
			tx.commit();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		System.out.println("saved-----------------------------------<>>>>>>>>"+saved);
		map.put("physioDirectVisitDetailList", physioDirectVisitDetailList);
		map.put("saved", saved);
		map.put("appointmentFlag", appointmentFlag);
		map.put("physioRequisitionHeaderId", physioRequisitionHeaderId);
		return map;
	}
	@Override
	public Map<String, Object> saveVisitEntryForAppointmentDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Transaction tx = null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean flag = false;
		Session session = (Session)getSession();
		try {
			tx = session.beginTransaction();
			int tharapyCount = box.getInt("tharapyCount");
			PhysioVisitEntryHeader physioVisitEntryHeader = new PhysioVisitEntryHeader();
			
			Patient patient = new Patient();
			patient.setId(box.getInt(HIN_ID));
			physioVisitEntryHeader.setHin(patient);
			Visit visit = new Visit();
			visit.setId(box.getInt(VISIT_ID));
			physioVisitEntryHeader.setVisit(visit);
			MasEmployee employee = new MasEmployee();
			employee.setId(box.getInt(MEDICAL_OFFICER_ID));
			physioVisitEntryHeader.setMedicalOfficer(employee);
			/*if(!box.getString("phyCompleted").equals("")){
				physioVisitEntryHeader.setPhyStatus("C");
			}*/
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			physioVisitEntryHeader.setHospital(hospital);
			Users user = new Users();
			user.setId(box.getInt("userId"));
			physioVisitEntryHeader.setLastChgBy(user);
			physioVisitEntryHeader.setStatus("y");
			physioVisitEntryHeader.setPhysioVisitDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			physioVisitEntryHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			physioVisitEntryHeader.setLastChgTime(box.getString(LAST_CHANGED_TIME));
			physioVisitEntryHeader.setDiagnosis(box.getString("diagnosis"));
			physioVisitEntryHeader.setVisitStatus("VC");
			if(box.getInt("physioReqHeaderId") != 0){
			PhysioRequisitionHeader physioRequisitionHeader = new PhysioRequisitionHeader();
			physioRequisitionHeader.setId(box.getInt("physioReqHeaderId"));
			physioVisitEntryHeader.setPhysioRequisition(physioRequisitionHeader);
			}
			hbt.save(physioVisitEntryHeader);
			for (int j = 1; j <= tharapyCount; j++) {
				PhysioVisitEntryDetail physioVisitEntryDetail = new PhysioVisitEntryDetail();
				if(box.getInt("therapyId"+j) != 0){
				MasTherapyType therapyType = new MasTherapyType();
				therapyType.setId(box.getInt("therapyId"+j));
				physioVisitEntryDetail.setTharapy(therapyType);
				MasFrequency masFrequency = new MasFrequency();
				if(box.getInt("frequency"+j) != 0){
				masFrequency.setId(box.getInt("frequency"+j));
				physioVisitEntryDetail.setFrequency(masFrequency);
				}
				physioVisitEntryDetail.setVisitEntryHeader(physioVisitEntryHeader);
				physioVisitEntryDetail.setDuration(box.getString("duration"+j).trim());
				physioVisitEntryDetail.setNoOfDays(box.getInt("noOfDays"+j));
				physioVisitEntryDetail.setSittingTime(box.getString("sittingTime"+j));
				if(box.getString("remarks"+j) != null){
					physioVisitEntryDetail.setRemarks(box.getString("remarks"+j));
				}
				physioVisitEntryDetail.setTimeBegin(box.getString("timeBegin"+j));
				physioVisitEntryDetail.setTimeComplete(box.getString("timeComplete"+j));
				if(!box.getString("nextApptDate").equals(""))
					physioVisitEntryDetail.setNextAppDate(HMSUtil.convertStringTypeDateToDateType(box.getString("nextAppointmentDate"+j)));
				if(!box.getString("nextAppointmentTime").equals("")){
				physioVisitEntryDetail.setNextAppTime(box.getString("nextAppointmentTime"+j));
				}
				hbt.save(physioVisitEntryDetail);
				}
			}
			if(box.getInt("physioReqHeaderId")!= 0){
				int physioRequisitionHeaderId = box.getInt("physioReqHeaderId");
				PhysioRequisitionHeader physioRequisitionHeader1 = (PhysioRequisitionHeader)hbt.load(PhysioRequisitionHeader.class, physioRequisitionHeaderId);
				physioRequisitionHeader1.setStatus("c");
				hbt.update(physioRequisitionHeader1);
				
			 }
			
			flag = true;
			tx.commit();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}
	@SuppressWarnings("deprecation")
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPhysiotherapyVisitDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int therapyTypeId = box.getInt("therapyType");
		int visitId = box.getInt("visitId");
		List<PhysiotherapyDetails> patientList = new ArrayList<PhysiotherapyDetails>();
		Session session = (Session) getSession();
		patientList = session.createCriteria(PhysiotherapyDetails.class).createAlias("TherapyType", "t").add(Restrictions.eq("t.Id", therapyTypeId))
					.createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
		
		map.put("patientList", patientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getHinNoForAppointment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = box.getString("serviceNo");
		List<Object[]> hinNoList = new ArrayList<Object[]>();
		Session session = (Session) getSession();
		
		hinNoList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo)).setProjection(Projections.projectionList().add(Projections.property("HinNo")).add(Projections.property("Id"))).list();
		map.put("hinNoList", hinNoList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getDetailsForHinNo(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		
		patientList = session.createCriteria(Patient.class).add(Restrictions.idEq(box.getInt("hinId"))).list();
		map.put("patientList", patientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPhysiotherapyAppointmentJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTherapyType> therapyTypeList = new ArrayList<MasTherapyType>();
		List<PhysioRequisitionDetail> physioReqDetailList = new ArrayList<PhysioRequisitionDetail>();
		List<PhysioAppointmentDetail> physioAppDetailList = new ArrayList<PhysioAppointmentDetail>();
		List<PhysioVisitEntryDetail> physioDirectVisitDetailList = new ArrayList<PhysioVisitEntryDetail>();
		List<PhysioAppointmentDetail> appointmentList = new ArrayList<PhysioAppointmentDetail>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		Date date = new Date();
		therapyTypeList = session.createCriteria(MasTherapyType.class).add(Restrictions.eq("Status", "y")).list();
		if(box.getString("flag").equals("Appointment")){
			physioAppDetailList = session.createCriteria(PhysioAppointmentDetail.class).createAlias("AppointmentHeader", "header")
			.add(Restrictions.eq("header.Id", box.getInt("physioRequisitionHeaderId")))
			.add(Restrictions.eq("header.Status", "A")).list();
		}else if(box.getString("flag").equals("OPD")){
			physioReqDetailList = session.createCriteria(PhysioRequisitionDetail.class).createAlias("PhysioRequisitionHeader", "header")
			.add(Restrictions.eq("header.Id", box.getInt("physioRequisitionHeaderId")))
			//.add(Restrictions.eq("header.Status", "p"))
			.list();
		}else{
		  physioDirectVisitDetailList = session.createCriteria(PhysioVisitEntryDetail.class).createAlias("VisitEntryHeader", "header")
		                                 .add(Restrictions.eq("header.Hin.Id", box.getInt("hinId"))).add(Restrictions.eq("header.PhysioVisitDate", date)).list();
		}
		appointmentList = session.createCriteria(PhysioAppointmentDetail.class).add(Restrictions.eq("VisitStatus","A").ignoreCase())
				.createAlias("AppointmentHeader", "header").add(Restrictions.eq("header.Hin.Id", box.getInt("hinId"))).add(Restrictions.ge("AppointmentDate", date))
					.createAlias("header.Hospital", "h").add(Restrictions.eq("h.Id", box.getInt("hospitalId"))).addOrder(
							Order.asc("header.AppointmentDate")).list();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		
		doctorList = session.createCriteria(MasEmployee.class).createAlias("Hospital", "h")
			.add(Restrictions.eq("h.Id", box.getInt("hospitalId"))).createAlias("EmpCategory", "ec")
			.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
			.add(Restrictions.eq("Status","y")).addOrder(Order.asc("FirstName")).list();
		map.put("doctorList", doctorList);
		map.put("therapyTypeList", therapyTypeList);
		map.put("physioReqDetailList", physioReqDetailList);
		map.put("physioAppDetailList", physioAppDetailList);
		map.put("appointmentList", appointmentList);
		map.put("physioDirectVisitDetailList", physioDirectVisitDetailList);
		return map;
	}
	@Override
	public Map<String, Object> savePhysioTheraphyAppointment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean flag = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			tx = session.beginTransaction();
			PhysioAppointmentHeader physioAppointmentHeader = new PhysioAppointmentHeader();
			//physioAppointmentHeader.setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(box.getString("injAppDate")));
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			physioAppointmentHeader.setHin(patient);
			if(box.getInt("visitId") != 0){
				Visit visit = new Visit();
			visit.setId(box.getInt("visitId"));
			physioAppointmentHeader.setVisit(visit);
			}
			if(box.getInt("inpatientId") != 0){
				Inpatient inpatient = new Inpatient();
				inpatient.setId(box.getInt("inpatientId"));
				physioAppointmentHeader.setInpatient(inpatient);
			}
			physioAppointmentHeader.setStatus("A");
			Users user = new Users();
			user.setId(box.getInt("userId"));
			physioAppointmentHeader.setLastChgBy(user);
			if(box.getInt("moId") != 0){
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(box.getInt("moId"));
			physioAppointmentHeader.setMedicalOfficer(masEmployee);
			}
			physioAppointmentHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			physioAppointmentHeader.setLastChgTime(box.getString(CHANGED_TIME));
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			physioAppointmentHeader.setHospital(hospital);
			if(box.getInt("physioReqHeaderId") != 0){
				PhysioRequisitionHeader physioRequisitionHeader = new PhysioRequisitionHeader();
			physioRequisitionHeader.setId(box.getInt("physioReqHeaderId"));
			physioAppointmentHeader.setPhysioRequisition(physioRequisitionHeader);
			}
			physioAppointmentHeader.setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(box.getString("physioAppDate")));
			physioAppointmentHeader.setPatientType("OP");

			hbt.save(physioAppointmentHeader);
			
			int counter = box.getInt("hdb");
			if(counter > 0){
				for (int i = 1; i <= counter; i++) {
					if(box.getInt("appPresDtId"+i)!=0){
						PhysioAppointmentDetail physioAppointmentDetail = new PhysioAppointmentDetail();
						physioAppointmentDetail.setAppointmentTime(box.getString("appTime"+i));
						MasFrequency frequency = new MasFrequency();
						frequency.setId(box.getInt("appFrequencyId"+i));
						physioAppointmentDetail.setFrequency(frequency);
						MasTherapyType masTherapyType= new MasTherapyType();
						masTherapyType.setId(box.getInt("appTherapyId"+i));
						physioAppointmentDetail.setTherapy(masTherapyType);
						physioAppointmentDetail.setAppointmentHeader(physioAppointmentHeader);
						physioAppointmentDetail.setNoOfDays(box.getInt("appNoOfDays"+i));
						//PatientPrescriptionDetails ptDetails = new PatientPrescriptionDetails();
						//ptDetails.setId(box.getInt("appPresDtId"+i));
						//injAppointmentDetails.setPatientPrescriptionDetails(ptDetails);
						physioAppointmentDetail.setRemarks(box.getString("remarks"+i));
						physioAppointmentDetail.setDuration(box.getString("appTherapyId"+i));
						physioAppointmentDetail.setVisitStatus("A");
						physioAppointmentDetail.setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(box.getString("physioAppDate")));
						hbt.save(physioAppointmentDetail);
					}
				}
				
			}
			if(box.getInt("physioReqHeaderId") != 0){
					int physioRequisitionHeaderId = box.getInt("physioReqHeaderId");
					PhysioRequisitionHeader physioRequiHeader = (PhysioRequisitionHeader)hbt.load(PhysioRequisitionHeader.class, physioRequisitionHeaderId);
					physioRequiHeader.setStatus("A");
					hbt.update(physioRequiHeader);
					
				
				}
//-----------------------data save in visit Entry Table-------------------------------------------------------
			PhysioVisitEntryHeader physioVisitEntryHeader = new PhysioVisitEntryHeader();
			//physioAppointmentHeader.setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(box.getString("injAppDate")));
			patient.setId(box.getInt("hinId"));
			physioVisitEntryHeader.setHin(patient);
			if(box.getInt("visitId") != 0){
				Visit visitObj = new Visit();
				visitObj.setId(box.getInt("visitId"));
				physioAppointmentHeader.setVisit(visitObj);
			}
			if(box.getInt("inpatientId") != 0){
				Inpatient inpatientObj = new Inpatient();
				inpatientObj.setId(box.getInt("inpatientId"));
				physioAppointmentHeader.setInpatient(inpatientObj);
			}
			physioVisitEntryHeader.setStatus("A");
			physioVisitEntryHeader.setVisitStatus("FV");
			user.setId(box.getInt("userId"));
			physioVisitEntryHeader.setLastChgBy(user);
			if(box.getInt("moId") != 0){
				MasEmployee employee = new MasEmployee();
				employee.setId(box.getInt("moId"));
				physioVisitEntryHeader.setMedicalOfficer(employee);
			}
			physioVisitEntryHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			physioVisitEntryHeader.setLastChgTime(box.getString(CHANGED_TIME));
			hospital.setId(box.getInt("hospitalId"));
			physioVisitEntryHeader.setHospital(hospital);
			if(box.getInt("physioReqHeaderId") != 0){
				PhysioRequisitionHeader physioRequisitionHeader1 = new PhysioRequisitionHeader();
			physioRequisitionHeader1.setId(box.getInt("physioReqHeaderId"));
			physioVisitEntryHeader.setPhysioRequisition(physioRequisitionHeader1);
			}
			//physioVisitEntryHeader.setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(box.getString("physioAppDate")));
			physioVisitEntryHeader.setPatientType("OP");

			hbt.save(physioVisitEntryHeader);
			
			if(counter > 0){
				for (int i = 1; i <= counter; i++) {
					if(box.getInt("appPresDtId"+i)!=0){
						PhysioVisitEntryDetail physioVisitEntryDetail = new PhysioVisitEntryDetail();
						physioVisitEntryDetail.setNextAppTime(box.getString("appTime"+i));
						MasFrequency frequency = new MasFrequency();
						frequency.setId(box.getInt("appFrequencyId"+i));
						physioVisitEntryDetail.setFrequency(frequency);
						MasTherapyType masTherapyType= new MasTherapyType();
						masTherapyType.setId(box.getInt("appTherapyId"+i));
						physioVisitEntryDetail.setTharapy(masTherapyType);
						physioVisitEntryDetail.setVisitEntryHeader(physioVisitEntryHeader);
						physioVisitEntryDetail.setNoOfDays(box.getInt("appNoOfDays"+i));
						//PatientPrescriptionDetails ptDetails = new PatientPrescriptionDetails();
						//ptDetails.setId(box.getInt("appPresDtId"+i));
						//injAppointmentDetails.setPatientPrescriptionDetails(ptDetails);
						physioVisitEntryDetail.setRemarks(box.getString("remarks"+i));
						physioVisitEntryDetail.setDuration(box.getString("appDuration"+i));
						//physioVisitEntryDetail.setVisitStatus("A");
						//physioVisitEntryDetail.setNextAppDate(HMSUtil.convertStringTypeDateToDateType(box.getString("physioAppDate")));
						hbt.save(physioVisitEntryDetail);
					}
				}
				
			}
			tx.commit();
			flag = true;
		} catch (DataAccessException e) {
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		
		map.put("flag", flag);
		
		return map;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> savePhysiotherapyAppointment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean flag = false;
		try {
			Vector fromTimes = box.getVector(FROM_TIME);
			Vector toTimes = box.getVector(TO_TIME);
			Vector therapyTypes = box.getVector(THERAPY_TYPE);
			Vector hinIds = box.getVector(HIN_ID);
			
			if(hinIds.size()>0){
				for (int i = 0; i < hinIds.size(); i++) {
					PhysiotherapyAppointment phyAppointment = new PhysiotherapyAppointment();
					phyAppointment.setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(box.getString(APPOINTMENT_DATE)));
					phyAppointment.setFromTime((String)fromTimes.get(i));
					phyAppointment.setToTime((String)toTimes.get(i));
					Patient patient = new Patient();
					patient.setId(Integer.parseInt((String)hinIds.get(i)));
					phyAppointment.setHin(patient);
					MasTherapyType therapyType = new MasTherapyType();
					therapyType.setId(Integer.parseInt((String)therapyTypes.get(i)));
					phyAppointment.setTherapyType(therapyType);
					phyAppointment.setStatus("y");
					
					MasHospital hospital = new MasHospital();
					hospital.setId(box.getInt("hospitalId"));
					phyAppointment.setHospital(hospital);
					
					Users user = new Users();
					user.setId(box.getInt("userId"));
					phyAppointment.setLastChgBy(user);
					
					phyAppointment.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
					phyAppointment.setLastChgTime(box.getString(LAST_CHANGED_TIME));
					
					hbt.save(phyAppointment);
					flag = true;
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("flag", flag);
		
		return map;
	}

	
	public Map<String, Object> getTherapyTypeListForAutoComplete(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTherapyType> therapyTypeList = new ArrayList<MasTherapyType>();
		Session session = (Session) getSession();
		try {
			String str =  generalMap.get("autoHint") + "%";
			//String query
			therapyTypeList= session.createCriteria(MasTherapyType.class)
			.add(Restrictions.like("TherapyTypeName", str).ignoreCase())
			.setMaxResults(10).list();
				//"from MasTherapyType as mtt where upper(TherapyTypeName) like upper('"
					//+ str + "')";
			
			//Query q = session.createQuery(query);
			//q.setFirstResult(0);
			//q.setMaxResults(10);
			//therapyTypeList = q.list();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		map.put("therapyTypeList", therapyTypeList);
		return map;
	}

	@Override
	public Map<String, Object> getPhysioAppointmentDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhysioAppointmentDetail> physioAppList = new ArrayList<PhysioAppointmentDetail>();
		Session session = (Session)getSession();
		physioAppList = session.createCriteria(PhysioAppointmentDetail.class).add(Restrictions.eq("VisitStatus","A").ignoreCase())
							.createAlias("AppointmentHeader", "header").add(Restrictions.eq("header.Hin.Id", box.getInt("hinId"))).add(Restrictions.eq("AppointmentDate", HMSUtil.convertStringTypeDateToDateType(box.getString("physioAppDate"))))
							.createAlias("header.Hospital", "h").add(Restrictions.eq("h.Id", box.getInt("hospitalId"))).list();
		map.put("physioAppList", physioAppList);
		return map;
	}

	@Override
	public Map<String, Object> getPatientDetailsFordirectVisitEntry(
			String serviceNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Patient> hinNoList = new ArrayList<Patient>();
		try {
			if (!serviceNo.equals("")) {
				hinNoList = session.createCriteria(Patient.class).add(
						Restrictions.eq("ServiceNo", serviceNo)).add(Restrictions.eq("PatientStatus", "Out Patient")).list();
			}
			map.put("hinNoList", hinNoList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> getPatientDetails(Box box) {
		Map<String, Object>map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasFrequency>frequencyList = new ArrayList<MasFrequency>();
		Session session = (Session)getSession();
		patientList = session.createCriteria(Patient.class).add(Restrictions.idEq(box.getInt("hinId"))).list();
		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y")).list();
		map.put("frequencyList", frequencyList);
		map.put("patientList", patientList);
		return map;
	}

	@Override
	public Map<String, Object> showDirectTherapyVisitEntryJps(Box box) {
		Map<String, Object>map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasFrequency>frequencyList = new ArrayList<MasFrequency>();
	
		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y")).list();
		map.put("frequencyList", frequencyList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPhyTreatmentRegisterJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList = null;
		List<MasRank> rankList = null;
		List<MasRankCategory> rankCategoryList = null;
		List<Object[]> unitList = null;
		List<MasMaritalStatus> maritalStatusList = null;
		List<MasTrade> tradeList = null;
		List<MasEmployee> employeeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasSection> sectionList = null;
		Session session = (Session)getSession();
		Properties properties = new Properties();
		List<MasTherapyType> therapyList = null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("Id")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y"))
						.createAlias("Station", "station").setProjection(Projections.projectionList()
						.add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(Order.asc("UnitName")).list();
		maritalStatusList = session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("MaritalStatusName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("EmpCategory", "ec")
						.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
					.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("SectionName")).list();
		therapyList = session.createCriteria(MasTherapyType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TherapyTypeName")).list();
		map.put("therapyList", therapyList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankList", rankList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("unitList", unitList);
		map.put("maritalStatusList", maritalStatusList);
		map.put("tradeList", tradeList);
		map.put("employeeList", employeeList);
		map.put("sexList", sexList);
		map.put("sectionList", sectionList);
		return map;
	}

	@Override
	public Map<String, Object> showPhysioTherapyTreatmentRegiterGraph(Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session)getSession();
	List<Object[]> treatmentRegister = new ArrayList<Object[]>();
	String qryStr = "";
	String joinQry = "";
	
	
	if(box.getInt(SERVICE_TYPE_ID)!=0){
		qryStr += " and patient.service_type_id = :serviceType";
		
	}
	if(box.getInt(SERVICE_STATUS_ID)!=0){
		qryStr += " and patient.service_status_id = :serviceStatus";
		
	}
	if(box.getInt("fromRankId")!=0 && box.getInt("toRankId")!=0){
		qryStr += " and patient.rank_id between :fromRank and :toRank";
		
	}
	if(box.getInt(RANK_CATEGORY_ID)!=0){
		qryStr += " and mas_rank.rank_category_id =:rankCat";
	
	}
	if(box.getInt(TRADE_ID)!=0){
		qryStr += " and patient.trade_id = :trade";
	
	}
	if(box.getInt(UNIT_ID)!=0){
		qryStr += " and patient.unit_id = :unit";
	
	}
	if(box.getInt(SECTION_ID)!=0){
		qryStr += " and patient.section_id = :section";
	
	}
	if(box.getInt(MARITAL_STATUS_ID)!=0){
		qryStr += " and patient.marital_status_id = :mrStatus";
	
	}
	if(box.getInt(SEX_ID)!=0){
		qryStr += " and patient.sex_id = :sex";
	
	}
	if (!(box.getString(SERVICE_NO).equals(""))) {
		qryStr += " and patient.service_no= :srNo";
	
	}
	if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
			&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
		String fromAge = box.getString("fromAge");
		String toAge = box.getString("toAge");
	//	qry += " and patient.age>='"+fromAge+"' and patient.age<='"+toAge+"'";
		qryStr +=" and substr(patient.age,0,INSTR(patient.age,' ')) >=:fromAge " +
				" and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))=:fromAgeUnit" +
				" and substr(patient.age,0,INSTR(patient.age,' ')) <=:toAge " +
				" and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))=:toAgeUnit";
		
		
	}
	if (!(box.getString("fromServ").equals("")) && !(box.getString("fromServUnit").equals(""))
			&& !(box.getString("toServ").equals("")) && !(box.getString("toServUnit").equals(""))) {
		String fromServ = box.getString("fromServ");
		String toServ = box.getString("toServ");
		qryStr +=" and patient.service_years >=:fromServ " +
			" and  total_service_period=:fromServUnit" +
			" and patient.service_years <=:toServ" +
			" and  total_service_period=:toServUnit";

				
	}

	if(box.getInt(CONSULTING_DOCTOR)!=0){
		qryStr += " and visit.doctor_id = :doctor";
		
	}

	/*if ( !(box.getString("icd").equals(""))) {
		String icd = box.getString("icd");
		 int index1=icd.lastIndexOf("[");
		  int index2=icd.lastIndexOf("]");
		   index1++;
		   String icdCode =""+icd.substring(index1, index2);
		qryStr += " and icd.icd_code='"+icdCode+"'";
	}
	if (!(box.getString("icdNo").equals(""))) {
		joinQry += " left join discharge_icd_code dic on PHYSIO_VISIT_ENTRY_HEADER.visitid=dic.visit_id" +
		" left outer join mas_icd icd on dic.icd_id=icd.icd_id";
		qryStr += " and icd.icd_code='"+box.getString("icdNo")+"'";
	}
	if(!(box.getString("therapyId").equals(""))){
		qryStr += " and MAS_THERAPY_TYPE.therapyId = '"+box.getInt("therapyId")+"'";
	}*/
	

	SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	String qry = "";
	String fromDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
	String toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
	
	qry = "SELECT distinct th.THERAPY_TYPE_NAME," +
			"(select count(*) from PHYSIO_VISIT_ENTRY_DETAIL detail " +
			" left join PHYSIO_VISIT_ENTRY_HEADER header  " +
			" on header.VISIT_ENTRY_HEADER_ID = detail.VISIT_ENTRY_HEADER_ID " +
			" left join patient p on header.hinid=p.hin_id " +
			" left join MAS_THERAPY_TYPE therapy on detail.THARAPY_ID = therapy.THERAPY_TYPE_ID " +
			" where PHYSIO_VISIT_DATE between  :fromDate and :toDate  " +
			" and header.PHYSIO_VISIT_DATE=hd.PHYSIO_VISIT_DATE  and p.service_type_id=1 group by header.PHYSIO_VISIT_DATE) as army, " +
		//	" and detail.THARAPY_ID=dt.THARAPY_ID  and p.service_type_id=1 group by detail.THARAPY_ID) as army, " + 
			"(select count(*) from PHYSIO_VISIT_ENTRY_DETAIL detail " +
			" left join PHYSIO_VISIT_ENTRY_HEADER header  " +
			" on header.VISIT_ENTRY_HEADER_ID = detail.VISIT_ENTRY_HEADER_ID " +
			" left join patient p on header.hinid=p.hin_id " +
			" left join MAS_THERAPY_TYPE therapy on detail.THARAPY_ID = therapy.THERAPY_TYPE_ID " +
			" where PHYSIO_VISIT_DATE between  :fromDate and :toDate  " +
			" and header.PHYSIO_VISIT_DATE=hd.PHYSIO_VISIT_DATE  and p.service_type_id=2 group by header.PHYSIO_VISIT_DATE) as airforce, " + 
		//	" and detail.THARAPY_ID=dt.THARAPY_ID  and p.service_type_id=2 group by detail.THARAPY_ID) as airforce, " + 
			"(select count(*) from PHYSIO_VISIT_ENTRY_DETAIL detail " +
			" left join PHYSIO_VISIT_ENTRY_HEADER header  " +
			" on header.VISIT_ENTRY_HEADER_ID = detail.VISIT_ENTRY_HEADER_ID " +
			" left join patient p on header.hinid=p.hin_id " +
			" left join MAS_THERAPY_TYPE therapy on detail.THARAPY_ID = therapy.THERAPY_TYPE_ID " +
			" where PHYSIO_VISIT_DATE between  :fromDate and :toDate  " +
			" and header.PHYSIO_VISIT_DATE=hd.PHYSIO_VISIT_DATE  and p.service_type_id=4 group by header.PHYSIO_VISIT_DATE) as coastguard, " + 
//			" and detail.THARAPY_ID=dt.THARAPY_ID  and p.service_type_id=4 group by detail.THARAPY_ID) as coastguard, " + 
			"(select count(*) from PHYSIO_VISIT_ENTRY_DETAIL detail " +
			" left join PHYSIO_VISIT_ENTRY_HEADER header  " +
			" on header.VISIT_ENTRY_HEADER_ID = detail.VISIT_ENTRY_HEADER_ID " +
			" left join patient p on header.hinid=p.hin_id " +
			" left join MAS_THERAPY_TYPE therapy on detail.THARAPY_ID = therapy.THERAPY_TYPE_ID " +
			" where PHYSIO_VISIT_DATE between  :fromDate and :toDate  " +
			" and header.PHYSIO_VISIT_DATE=hd.PHYSIO_VISIT_DATE  and p.service_type_id=7 group by header.PHYSIO_VISIT_DATE) as NE, " + 
		//	" and detail.THARAPY_ID=dt.THARAPY_ID  and p.service_type_id=7 group by detail.THARAPY_ID) as NE, " + 
			"(select count(*) from PHYSIO_VISIT_ENTRY_DETAIL detail " +
			" left join PHYSIO_VISIT_ENTRY_HEADER header  " +
			" on header.VISIT_ENTRY_HEADER_ID = detail.VISIT_ENTRY_HEADER_ID " +
			" left join patient p on header.hinid=p.hin_id " +
			" left join MAS_THERAPY_TYPE therapy on detail.THARAPY_ID = therapy.THERAPY_TYPE_ID " +
			" where PHYSIO_VISIT_DATE between  :fromDate and :toDate  " +
			" and header.PHYSIO_VISIT_DATE=hd.PHYSIO_VISIT_DATE   and p.service_type_id=41 group by header.PHYSIO_VISIT_DATE) as oth " + 
		//	" and detail.THARAPY_ID=dt.THARAPY_ID  and p.service_type_id=41 group by detail.THARAPY_ID) as oth " + 
					
			"  FROM PHYSIO_VISIT_ENTRY_HEADER hd inner JOIN PHYSIO_VISIT_ENTRY_DETAIL dt " +
			" ON hd.VISIT_ENTRY_HEADER_ID = dt.VISIT_ENTRY_HEADER_ID left join patient pt " +
			" on hd.hinid = pt.hin_id LEFT OUTER JOIN mas_service_type st" +
			" ON pt.service_type_id = st.service_type_id left join MAS_THERAPY_TYPE th " +
			" on dt.THARAPY_ID = th.THERAPY_TYPE_ID " +
			" where hd.PHYSIO_VISIT_DATE between  :fromDate and :toDate  " +
					" and hd.hospital_id=:hospitalId"+qryStr;
	
	SQLQuery sqlQry = session.createSQLQuery(qry);
	sqlQry.setParameter("fromDate", fromDate);
	sqlQry.setParameter("toDate", toDate);
	sqlQry.setParameter("hospitalId",box.getInt("hospitalId"));
	
	

	if(box.getInt(SERVICE_TYPE_ID)!=0){
		sqlQry.setParameter("serviceType", box.getInt(SERVICE_TYPE_ID));
	}
	if(box.getInt(SERVICE_STATUS_ID)!=0){
		sqlQry.setParameter("serviceStatus", box.getInt(SERVICE_STATUS_ID));
	}
	if(box.getInt("fromRankId")!=0 && box.getInt("toRankId")!=0){
		sqlQry.setParameter("fromRank", box.getInt("fromRankId"))
		.setParameter("toRank", box.getInt("toRankId"));
	}
	if(box.getInt(RANK_CATEGORY_ID)!=0){
		sqlQry.setParameter("rankCat", box.getInt(RANK_CATEGORY_ID));
	}
	if(box.getInt(TRADE_ID)!=0){
		sqlQry.setParameter("trade", box.getInt(TRADE_ID));
	}
	if(box.getInt(UNIT_ID)!=0){
		sqlQry.setParameter("unit", box.getInt(UNIT_ID));
	}
	if(box.getInt(SECTION_ID)!=0){
		sqlQry.setParameter("section", box.getInt(SECTION_ID));
	}
	if(box.getInt(MARITAL_STATUS_ID)!=0){
		sqlQry.setParameter("mrStatus", box.getInt(MARITAL_STATUS_ID));
	}
	if(box.getInt(SEX_ID)!=0){
		sqlQry.setParameter("sex", box.getInt(SEX_ID));
	}
	
	if (!(box.getString(SERVICE_NO).equals(""))) {
		sqlQry.setParameter("srNo", box.getInt(SERVICE_NO));
	}
	if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
			&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
		sqlQry.setParameter("fromAge", box.getInt("fromAge"));
		sqlQry.setParameter("fromAgeUnit", box.getString("fromAgeUnit"));
		sqlQry.setParameter("toAge", box.getInt("toAge"));
		sqlQry.setParameter("toAgeUnit", box.getString("toAgeUnit"));
	}
	if (!(box.getString("fromServ").equals("")) && !(box.getString("fromServUnit").equals(""))
			&& !(box.getString("toServ").equals("")) && !(box.getString("toServUnit").equals(""))) {
		sqlQry.setParameter("fromServ", box.getInt("fromServ"));
		sqlQry.setParameter("fromServUnit", box.getString("fromServUnit"));
		sqlQry.setParameter("toServ", box.getInt("toServ"));
		sqlQry.setParameter("toServUnit", box.getString("toServUnit"));
		
	}
	if(box.getInt(CONSULTING_DOCTOR)!=0){
		sqlQry.setParameter("doctor", box.getInt(CONSULTING_DOCTOR));
	}
	

	treatmentRegister = sqlQry.list();
	map.put("treatmentRegister", treatmentRegister);
		return map;
	}

	@Override
	public Map<String, Object> showPhysiotherapyAppointmentRegister(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = null;
		List<Object[]> unitList = null;
		List<MasMaritalStatus> maritalStatusList = null;
		List<MasTrade> tradeList = null;
		List<MasEmployee> employeeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasSection> sectionList = null;
		
		Session session = (Session)getSession();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("Id")).list();
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y"))						.createAlias("Station", "station").setProjection(Projections.projectionList()
						.add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(Order.asc("UnitName")).list();
		maritalStatusList = session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("MaritalStatusName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("EmpCategory", "ec")
						.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
					.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("SectionName")).list();
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("maritalStatusList", maritalStatusList);
		map.put("tradeList", tradeList);
		map.put("employeeList", employeeList);
		map.put("sexList", sexList);
		map.put("sectionList", sectionList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPhysiotherapyVisitWaitingList(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> physioWaitingList = new ArrayList<Visit>();
		
		Session session = (Session)getSession();
		physioWaitingList = session.createCriteria(Visit.class).add(
						Restrictions.eq("VisitDate", new Date())).add(
						Restrictions.eq("VisitStatus", "w")).add(Restrictions.eq("ReportingFor", "Physiotherapy"))
						.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("VisitTime")).list();
		map.put("physioWaitingList", physioWaitingList);
		return map;
	}

	@Override
	public Map<String, Object> showPhyAppointmentRegisterReport(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> physiotheraphyAppointmentList = new ArrayList<Object[]>();
		String qryStr = "";
		Session session = (Session)getSession();
		if(box.getInt("fromRankId")!=0 ){
			qryStr += " and patient.rank_id = :fromRank";
		}
		if(box.getInt(TRADE_ID)!=0){
			qryStr += " and patient.trade_id = :trade";
		}
		if(box.getInt(UNIT_ID)!=0){
			qryStr += " and patient.unit_id =  :unit";
		}
		if(box.getInt(SECTION_ID)!=0){
			qryStr += " and patient.section_id = :section";
		}
		if(box.getInt(MARITAL_STATUS_ID)!=0){
			qryStr += " and patient.marital_status_id = :mrStatus";
		}
		if(box.getInt(SEX_ID)!=0){
			qryStr += " and patient.sex_id = :sex";
		}
		if (!(box.getString(SERVICE_NO).equals(""))) {
			//qryStr += " and patient.service_no='"+box.getString(SERVICE_NO)+"'";
			qryStr += " and patient.service_no =:service_no";
		}
		if(box.getInt(CONSULTING_DOCTOR)!=0){
			qryStr += " and visit.doctor_id = :doctor";
		}
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String qry = "";
		String fromDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		String toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		
		qry = " SELECT  distinct PATIENT.SERVICE_NO AS PATIENT_SERVICE_NO,(PATIENT.P_FIRST_NAME||' '||PATIENT.P_MIDDLE_NAME||' '||PATIENT.P_LAST_NAME)AS PATIENT_NAME," +
		 		" MAS_THERAPY_TYPE.THERAPY_TYPE_NAME AS THERAPY_TYPE,PHYSIO_APPOINTMENT_HEADER.APPOINTMENT_DATE AS appDateHd," +
 				" PHYSIO_APPOINTMENT_DETAIL.APPOINTMENT_DATE AS appDateDt, PHYSIO_APPOINTMENT_DETAIL.APPOINTMENT_TIME AS appTime,PHYSIO_APPOINTMENT_DETAIL.NO_OF_DAYS AS NO_OF_DAYS, PHYSIO_APPOINTMENT_DETAIL.DURATION AS duration," +
				" (PATIENT.S_FIRST_NAME || ' ' || PATIENT.S_MIDDLE_NAME || ' ' || PATIENT.S_LAST_NAME)as srName,MAS_RANK.RANK_NAME AS MAS_RANK_RANK_NAME, " +
				" mas_relation.relation_name as relation, mas_unit.UNIT_NAME as unit,(mas_employee.FIRST_NAME ||' ' || mas_employee.MIDDLE_NAME ||' '|| mas_employee.LAST_NAME)as eName," +
				" VISIT.VISIT_ID AS PHYSIOTHERAPY_DETAILS_VISIT_ID" +
				" FROM PATIENT PATIENT RIGHT OUTER JOIN PHYSIO_APPOINTMENT_HEADER PHYSIO_APPOINTMENT_HEADER ON PATIENT.HIN_ID = PHYSIO_APPOINTMENT_HEADER.HIN_ID " +
				" left outer join  PHYSIO_APPOINTMENT_DETAIL PHYSIO_APPOINTMENT_DETAIL on PHYSIO_APPOINTMENT_DETAIL.APPOINTMENT_HEADER_ID = PHYSIO_APPOINTMENT_HEADER.APPOINTMENT_HEADER_ID LEFT OUTER JOIN MAS_HOSPITAL MAS_HOSPITAL ON " +
				" PHYSIO_APPOINTMENT_HEADER.HOSPITAL_ID = MAS_HOSPITAL.HOSPITAL_ID LEFT OUTER JOIN VISIT VISIT ON PHYSIO_APPOINTMENT_HEADER.VISIT_ID = VISIT.VISIT_ID " +
				" LEFT OUTER JOIN MAS_THERAPY_TYPE MAS_THERAPY_TYPE ON PHYSIO_APPOINTMENT_DETAIL.THERAPY_ID = MAS_THERAPY_TYPE.THERAPY_TYPE_ID INNER JOIN MAS_RANK MAS_RANK ON PATIENT.RANK_ID = MAS_RANK.RANK_ID left join " +
				" mas_relation mas_relation on patient.RELATION_ID = mas_relation.RELATION_ID left join mas_unit mas_unit on patient.unit_id = mas_unit.unit_id " +
				" left join mas_employee mas_employee on PHYSIO_APPOINTMENT_HEADER.MEDICAL_OFFICER_ID =mas_employee.EMPLOYEE_ID " +
				" where PHYSIO_APPOINTMENT_DETAIL.APPOINTMENT_DATE between  :fromDate and :toDate  "+
				" and PHYSIO_APPOINTMENT_HEADER.hospital_id=:hospitalId" +qryStr+
				" order by PHYSIO_APPOINTMENT_DETAIL.APPOINTMENT_DATE asc,PHYSIO_APPOINTMENT_DETAIL.APPOINTMENT_TIME";
		
		SQLQuery sqlQry = session.createSQLQuery(qry);
		sqlQry.setParameter("fromDate", fromDate);
		sqlQry.setParameter("toDate", toDate);
		sqlQry.setParameter("hospitalId",box.getInt("hospitalId"));
		
		
		//physiotheraphyAppointmentList = session.createSQLQuery(qry).list();
		//Query q=session.createSQLQuery(qry);
		
		if (!(box.getString(SERVICE_NO).equals(""))) {
			//qryStr += " and patient.service_no='"+box.getString(SERVICE_NO)+"'";
			//q.setParameter("service_no", );
			sqlQry.setParameter("service_no", box.getString(SERVICE_NO));
			
		}
		
		if(box.getInt("fromRankId")!=0){
			sqlQry.setParameter("fromRank", box.getInt("fromRankId"));
			
		}
		if(box.getInt(TRADE_ID)!=0){
			sqlQry.setParameter("trade", box.getInt(TRADE_ID));
		}
		if(box.getInt(UNIT_ID)!=0){
			sqlQry.setParameter("unit", box.getInt(UNIT_ID));
		}
		if(box.getInt(SECTION_ID)!=0){
			sqlQry.setParameter("section", box.getInt(SECTION_ID));
		}
		if(box.getInt(MARITAL_STATUS_ID)!=0){
			sqlQry.setParameter("mrStatus", box.getInt(MARITAL_STATUS_ID));
		}
		if(box.getInt(SEX_ID)!=0){
			sqlQry.setParameter("sex", box.getInt(SEX_ID));
		}
		
		if(box.getInt(CONSULTING_DOCTOR)!=0){
			sqlQry.setParameter("doctor", box.getInt(CONSULTING_DOCTOR));
		}
		
		physiotheraphyAppointmentList = sqlQry.list();
		map.put("physiotheraphyAppointmentList", physiotheraphyAppointmentList);
		return map;
	}

	

	

	
	
	
}
