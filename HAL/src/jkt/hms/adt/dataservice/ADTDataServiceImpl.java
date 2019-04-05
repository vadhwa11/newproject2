package jkt.hms.adt.dataservice;

import static jkt.hms.util.RequestConstants.AGE;
import static jkt.hms.util.RequestConstants.AGE_UNIT;
import static jkt.hms.util.RequestConstants.APPOINTMENT_DATE;
import static jkt.hms.util.RequestConstants.APPOINTMENT_TIME;
import static jkt.hms.util.RequestConstants.BOARD_HELD_ON;
import static jkt.hms.util.RequestConstants.BROUGHT_BY;
import static jkt.hms.util.RequestConstants.CARE_SUMMARY;
import static jkt.hms.util.RequestConstants.CARE_TYPE_ID;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR;
import static jkt.hms.util.RequestConstants.DATE;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_NAME;
import static jkt.hms.util.RequestConstants.DIET_ID;
import static jkt.hms.util.RequestConstants.DIET_TYPE;
import static jkt.hms.util.RequestConstants.DISCHARGE_DATE;
import static jkt.hms.util.RequestConstants.DISCHARGE_IN_MEDICAL_CATEGORY;
import static jkt.hms.util.RequestConstants.DISCHARGE_STATUS_ID;
import static jkt.hms.util.RequestConstants.DISCHARGE_TIME;
import static jkt.hms.util.RequestConstants.DISPOSAL_ID;
import static jkt.hms.util.RequestConstants.DISPOSED_TO_ID;
import static jkt.hms.util.RequestConstants.DOCTOR_NAME;
import static jkt.hms.util.RequestConstants.FOLLOW_UP;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.INJURY_NATURE_ID;
import static jkt.hms.util.RequestConstants.INJURY_REPORT_INITIATED_ON;
import static jkt.hms.util.RequestConstants.INJURY_TYPE;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.INSTRUCTIONS;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_DATE;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_TIME;
import static jkt.hms.util.RequestConstants.MARITAL_STATUS_ID;
import static jkt.hms.util.RequestConstants.MLC_NO;
import static jkt.hms.util.RequestConstants.NATURE_OF_MLC;
import static jkt.hms.util.RequestConstants.POLICE_STATION;
import static jkt.hms.util.RequestConstants.P_FIRST_NAME;
import static jkt.hms.util.RequestConstants.RANK_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.RELATION_ID;
import static jkt.hms.util.RequestConstants.SECTION_ID;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_STATUS_ID;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID;
import static jkt.hms.util.RequestConstants.SEX_ID;
import static jkt.hms.util.RequestConstants.S_FIRST_NAME;
import static jkt.hms.util.RequestConstants.S_LAST_NAME;
import static jkt.hms.util.RequestConstants.S_MIDDLE_NAME;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TRADE_ID;
import static jkt.hms.util.RequestConstants.UNIT_ID;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.masters.business.AttachInpatient;
import jkt.hms.masters.business.DietDetails;
import jkt.hms.masters.business.Discharge;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.DischargeSummary;
import jkt.hms.masters.business.EmpGroups;
import jkt.hms.masters.business.ExpiryDetails;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.InpatientDocument;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAdmissionType;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasBlock;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasBodyPart;
import jkt.hms.masters.business.MasCareType;
import jkt.hms.masters.business.MasCaseType;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDeathCause;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiagnosisConclusion;
import jkt.hms.masters.business.MasDiet;
import jkt.hms.masters.business.MasDietCombination;
import jkt.hms.masters.business.MasDietType;
import jkt.hms.masters.business.MasDischargeStatus;
import jkt.hms.masters.business.MasDisposal;
import jkt.hms.masters.business.MasDisposedTo;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasDocument;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasInjuryNature;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasMedicalExaminationDetail;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasRecordOfficeAddress;
import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasSection;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStation;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MlcCase;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.OpdSurgeryHeader;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAppointment;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.SilDilStatus;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Transfer;
import jkt.hms.masters.business.UserEmpGroup;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
//import oracle.jdbc.driver.OracleTypes;

import oracle.jdbc.OracleTypes;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ADTDataServiceImpl extends HibernateDaoSupport implements ADTDataService{
	Session session;
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();

		String serviceNo = "";
		String hinNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonFName = "";
		String serPersonMName = "";
		String serPersonLName = "";
		int sectionId = 0;
		int tradeId = 0;
		int commandId = 0;
		String stationName = "";
		int hinId = 0;
		int hospitalId = 0;
		Session session = (Session)getSession();
		Criteria crit = null;
		try{
		if(mapForDs.get("serviceNo") != null){
			serviceNo = (String)mapForDs.get("serviceNo");
		}
		if(mapForDs.get("hinNo") != null){
			hinNo = (String)mapForDs.get("hinNo");
		}
		if(mapForDs.get("serviceTypeId") != null){
			serviceTypeId = (Integer)mapForDs.get("serviceTypeId");
		}
		if(mapForDs.get("rankId") != null){
			rankId = (Integer)mapForDs.get("rankId");
		}
		if(mapForDs.get("unitId") != null){
			unitId = (Integer)mapForDs.get("unitId");
		}
		if(mapForDs.get("serPersonFName") != null){
			serPersonFName = (String)mapForDs.get("serPersonFName");
		}
		if(mapForDs.get("serPersonMName") != null){
			serPersonMName = (String)mapForDs.get("serPersonMName");
		}
		if(mapForDs.get("serPersonLName") != null){
			serPersonLName = (String)mapForDs.get("serPersonLName");
		}
		if(mapForDs.get("sectionId") != null){
			sectionId = (Integer)mapForDs.get("sectionId");
		}
		if(mapForDs.get("stationName") != null){
			stationName = (String)mapForDs.get("stationName");
		}
		if(mapForDs.get("commandId") != null){
			commandId = (Integer)mapForDs.get("commandId");
		}
		if(mapForDs.get("tradeId") != null){
			tradeId = (Integer)mapForDs.get("tradeId");
		}
		if(mapForDs.get("hinId") != null){
			hinId = (Integer)mapForDs.get("hinId");
		}
		String adNo = "";
		if(mapForDs.get("admissionNo") != null){
			adNo = (String)mapForDs.get("admissionNo");
		}
		String patientType = "";
		if(mapForDs.get("patientType")!=null){
			patientType = (String)mapForDs.get("patientType");
		}
		int departmentId = 0;
		if(mapForDs.get("departmentId") != null){
			departmentId = (Integer)mapForDs.get("departmentId");
		}
		if(mapForDs.get("hospitalId") != null){
			hospitalId = (Integer)mapForDs.get("hospitalId");
		}
		String mobileNo = "";
		if(mapForDs.get("mobileNo")!=null){
			mobileNo = (String)mapForDs.get("mobileNo");
		}
		
		crit = session.createCriteria(Patient.class);
		if(!patientType.equals("")){
			crit = crit.add(Restrictions.eq("PatientStatus", patientType));
		}
		if(hinId == 0){
			if(!adNo.equals("") || departmentId!=0){
				crit = crit.createAlias("Inpatients", "ip",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("ip.AdStatus","A"))
					.add(Restrictions.eq("ip.Hospital.Id",hospitalId));
				if(!adNo.equals("")){
					crit = crit.add(Restrictions.eq("ip.AdNo", adNo));
				}
				if(departmentId!=0){
					crit = crit.add(Restrictions.eq("ip.Department.Id", departmentId));
				}
			}
			if(!serviceNo.equals("") ){
				crit = crit.add(Restrictions.eq("ServiceNo", serviceNo));
			}
			if(!hinNo.equals("")){
				crit = crit.add(Restrictions.eq("HinNo", hinNo));
			}
			if(!serPersonFName.equals("")){
				crit = crit.add(Restrictions.ilike("SFirstName", serPersonFName+"%"));
			}
			if(!serPersonMName.equals("")){
				crit = crit.add(Restrictions.ilike("SMiddleName", serPersonMName+"%"));
			}
			if(!serPersonLName.equals("")){
				crit = crit.add(Restrictions.ilike("SLastName", serPersonLName+"%"));
			}
			if(serviceTypeId != 0 ){
				crit = crit.createAlias("ServiceType", "st").add(Restrictions.eq("st.Id", serviceTypeId));
			}
			if(rankId != 0 ){
				crit = crit.createAlias("Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
			}
			if(unitId != 0 ){
				crit = crit.createAlias("Unit", "unit").add(Restrictions.eq("unit.Id", unitId));
			}
			if(sectionId != 0 ){
				crit = crit.createAlias("Section", "section").add(Restrictions.eq("section.Id", sectionId));
			}
			if(!stationName.equals("")){
				crit = crit.add(Restrictions.eq("Station", stationName));
			}
			if(commandId != 0 ){
				crit = crit.createAlias("Command", "cmd").add(Restrictions.eq("cmd.Id", commandId));
			}
			if(tradeId != 0 ){
				crit = crit.createAlias("Trade", "trd").add(Restrictions.eq("trd.Id", tradeId));
			}
			if(!mobileNo.equals("")){
				crit = crit.add(Restrictions.eq("MobileNumber", mobileNo));
			}
			}else {
				crit = crit.add(Restrictions.eq("Id",hinId));
			}
			patientList = crit.list();
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		}catch (Exception e) {
			e.printStackTrace();

		}
			map.put("patientList", patientList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsHAL(Map<String, Object> mapForDs, Transaction tx, org.hibernate.Session session) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();

		String serviceNo = "";
		String hinNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonFName = "";
		String serPersonMName = "";
		String serPersonLName = "";
		int sectionId = 0;
		int tradeId = 0;
		int commandId = 0;
		String stationName = "";
		int hinId = 0;
		int hospitalId = 0;
		
		Criteria crit = null;
		try{
		if(mapForDs.get("serviceNo") != null){
			serviceNo = (String)mapForDs.get("serviceNo");
		}
		if(mapForDs.get("hinNo") != null){
			hinNo = (String)mapForDs.get("hinNo");
		}
		if(mapForDs.get("serviceTypeId") != null){
			serviceTypeId = (Integer)mapForDs.get("serviceTypeId");
		}
		if(mapForDs.get("rankId") != null){
			rankId = (Integer)mapForDs.get("rankId");
		}
		if(mapForDs.get("unitId") != null){
			unitId = (Integer)mapForDs.get("unitId");
		}
		if(mapForDs.get("serPersonFName") != null){
			serPersonFName = (String)mapForDs.get("serPersonFName");
		}
		if(mapForDs.get("serPersonMName") != null){
			serPersonMName = (String)mapForDs.get("serPersonMName");
		}
		if(mapForDs.get("serPersonLName") != null){
			serPersonLName = (String)mapForDs.get("serPersonLName");
		}
		if(mapForDs.get("sectionId") != null){
			sectionId = (Integer)mapForDs.get("sectionId");
		}
		if(mapForDs.get("stationName") != null){
			stationName = (String)mapForDs.get("stationName");
		}
		if(mapForDs.get("commandId") != null){
			commandId = (Integer)mapForDs.get("commandId");
		}
		if(mapForDs.get("tradeId") != null){
			tradeId = (Integer)mapForDs.get("tradeId");
		}
		if(mapForDs.get("hinId") != null){
			hinId = (Integer)mapForDs.get("hinId");
		}
		String adNo = "";
		if(mapForDs.get("admissionNo") != null){
			adNo = (String)mapForDs.get("admissionNo");
		}
		String patientType = "";
		if(mapForDs.get("patientType")!=null){
			patientType = (String)mapForDs.get("patientType");
		}
		int departmentId = 0;
		if(mapForDs.get("departmentId") != null){
			departmentId = (Integer)mapForDs.get("departmentId");
		}
		if(mapForDs.get("hospitalId") != null){
			hospitalId = (Integer)mapForDs.get("hospitalId");
		}
		String mobileNo = "";
		if(mapForDs.get("mobileNo")!=null){
			mobileNo = (String)mapForDs.get("mobileNo");
		}
		
		crit = session.createCriteria(Patient.class);
		if(!patientType.equals("")){
			crit = crit.add(Restrictions.eq("PatientStatus", patientType));
		}
		if(hinId == 0){
			if(!adNo.equals("") || departmentId!=0){
				crit = crit.createAlias("Inpatients", "ip",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("ip.AdStatus","A"))
					.add(Restrictions.eq("ip.Hospital.Id",hospitalId));
				if(!adNo.equals("")){
					crit = crit.add(Restrictions.eq("ip.AdNo", adNo));
				}
				if(departmentId!=0){
					crit = crit.add(Restrictions.eq("ip.Department.Id", departmentId));
				}
			}
			if(!serviceNo.equals("") ){
				crit = crit.add(Restrictions.eq("ServiceNo", serviceNo));
			}
			if(!hinNo.equals("")){
				crit = crit.add(Restrictions.eq("HinNo", hinNo));
			}
			if(!serPersonFName.equals("")){
				crit = crit.add(Restrictions.ilike("SFirstName", serPersonFName+"%"));
			}
			if(!serPersonMName.equals("")){
				crit = crit.add(Restrictions.ilike("SMiddleName", serPersonMName+"%"));
			}
			if(!serPersonLName.equals("")){
				crit = crit.add(Restrictions.ilike("SLastName", serPersonLName+"%"));
			}
			if(serviceTypeId != 0 ){
				crit = crit.createAlias("ServiceType", "st").add(Restrictions.eq("st.Id", serviceTypeId));
			}
			if(rankId != 0 ){
				crit = crit.createAlias("Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
			}
			if(unitId != 0 ){
				crit = crit.createAlias("Unit", "unit").add(Restrictions.eq("unit.Id", unitId));
			}
			if(sectionId != 0 ){
				crit = crit.createAlias("Section", "section").add(Restrictions.eq("section.Id", sectionId));
			}
			if(!stationName.equals("")){
				crit = crit.add(Restrictions.eq("Station", stationName));
			}
			if(commandId != 0 ){
				crit = crit.createAlias("Command", "cmd").add(Restrictions.eq("cmd.Id", commandId));
			}
			if(tradeId != 0 ){
				crit = crit.createAlias("Trade", "trd").add(Restrictions.eq("trd.Id", tradeId));
			}
			if(!mobileNo.equals("")){
				crit = crit.add(Restrictions.eq("MobileNumber", mobileNo));
			}
			}else {
				crit = crit.add(Restrictions.eq("Id",hinId));
			}
			patientList = crit.list();
		}catch (HibernateException e){
			e.printStackTrace();
			/*session.close();*/
		}catch (Exception e) {
			e.printStackTrace();

		}
			map.put("patientList", patientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAdmissionDetails(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDiet> dietList = new ArrayList<MasDiet>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<MasAdmissionType> admissionTypeList = new ArrayList<MasAdmissionType>();
		List<MasBed> bedList = new ArrayList<MasBed>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasDocument> documentList = new ArrayList<MasDocument>();
		List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();
		List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
	/*	List<UserEmpGroup> userEmpGroupList = new ArrayList<UserEmpGroup>();
		List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();*/

		List<OpdPatientDetails> admissionWaitList = new ArrayList<OpdPatientDetails>();
		Session session = (Session) getSession();
		List<MasDepartment> departmentList = null;
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String disposalForAdmitted="";
		try{
			String qry = "select distinct a.department_id, a.department_name from mas_department a left join mas_bed b on a.department_id=b.department_id" +
					" left join mas_department_type c on a.department_type_id=c.department_type_id"+
					" where c.department_type_name='Ward' and  b.hospital_id=:hospitalId order by a.department_name";
			departmentList = session.createCriteria(MasDepartment.class)
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.DepartmentTypeName", "Ward").ignoreCase())
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.addOrder(Order.asc("DepartmentName")).list();
			String departmentTypeCodeForOpd = properties.getProperty("departmentTypeCodeForOpd"); 
			
			//maritalStatusList = session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status", "y")).list();
			//employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y").ignoreCase()).createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("Department", "d")
					.createAlias("d.DepartmentType","dt")
					.add(Restrictions.eq("dt.DepartmentTypeCode", departmentTypeCodeForOpd))
					.addOrder(Order.asc("FirstName")).list();
			dietList = session.createCriteria(MasDiet.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DietName")).list();
			bloodGroupList = session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BloodGroupName")).list();
			admissionTypeList = session.createCriteria(MasAdmissionType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdmissionTypeName")).list();
			bedList = session.createCriteria(MasBed.class).add(Restrictions.eq("Status", "y")).createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).list();
			relationList = session.createCriteria(MasRelation.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RelationName")).list();
			documentList = session.createCriteria(MasDocument.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DocumentName")).list();
			disposalForAdmitted = properties.getProperty("disposalForAdmitted"); 
			
			admissionWaitList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v")
					.createAlias("v.Hin", "h")
					.add(Restrictions.eq("h.PatientStatus", "Out Patient"))
					.add(Restrictions.eq("Disposal", disposalForAdmitted))
					.add(Restrictions.eq("AdmissionAdvised", 'y').ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.addOrder(Order.desc("OpdDate")).list();
			
			
			dischargeIcdCodeList = session.createCriteria(DischargeIcdCode.class)
					.createAlias("OpdPatientDetails", "opd")
					.createAlias("opd.Visit", "v")
					.createAlias("v.Hin", "h")
					.add(Restrictions.eq("h.PatientStatus", "Out Patient"))
					.add(Restrictions.eq("opd.Disposal", disposalForAdmitted))
					.add(Restrictions.eq("opd.AdmissionAdvised", 'y').ignoreCase())
					/*.add(Restrictions.eq("opd.OpdDate", new Date()))*/
					.add(Restrictions.eq("opd.Hospital.Id", hospitalId)).list();
			
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		}catch(Exception e){
			e.printStackTrace();

		}
		map.put("maritalStatusList",maritalStatusList);
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		System.out.println("departmentList>>"+departmentList.size());
		map.put("dietList", dietList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("admissionTypeList", admissionTypeList);
		map.put("bedList", bedList);
		map.put("relationList", relationList);
		map.put("documentList", documentList);
		map.put("admissionWaitList",admissionWaitList);
		map.put("dischargeIcdCodeList",dischargeIcdCodeList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getAdmissionDetailsHAL(int hospitalId, Transaction tx, org.hibernate.Session session) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDiet> dietList = new ArrayList<MasDiet>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<MasAdmissionType> admissionTypeList = new ArrayList<MasAdmissionType>();
		List<MasBed> bedList = new ArrayList<MasBed>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasDocument> documentList = new ArrayList<MasDocument>();
		List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();
	/*	List<UserEmpGroup> userEmpGroupList = new ArrayList<UserEmpGroup>();
		List<EmpGroups> empGroupList = new ArrayList<EmpGroups>();*/

		List<OpdPatientDetails> admissionWaitList = new ArrayList<OpdPatientDetails>();
		
		List<MasDepartment> departmentList = null;
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String disposalForAdmitted="";
		try{
			String qry = "select distinct a.department_id, a.department_name from mas_department a left join mas_bed b on a.department_id=b.department_id" +
					" left join mas_department_type c on a.department_type_id=c.department_type_id"+
					" where c.department_type_name='Ward' and  b.hospital_id=:hospitalId order by a.department_name";
			departmentList = session.createCriteria(MasDepartment.class)
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.DepartmentTypeName", "Ward").ignoreCase())
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.addOrder(Order.asc("DepartmentName")).list();
			
			//maritalStatusList = session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status", "y")).list();
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y").ignoreCase()).createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
			dietList = session.createCriteria(MasDiet.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DietName")).list();
			bloodGroupList = session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BloodGroupName")).list();
			admissionTypeList = session.createCriteria(MasAdmissionType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdmissionTypeName")).list();
			bedList = session.createCriteria(MasBed.class).add(Restrictions.eq("Status", "y")).createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).list();
			relationList = session.createCriteria(MasRelation.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RelationName")).list();
			documentList = session.createCriteria(MasDocument.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DocumentName")).list();
			disposalForAdmitted = properties.getProperty("disposalForAdmitted");
			admissionWaitList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").createAlias("v.Hin", "h").add(Restrictions.eq("h.PatientStatus", "Out Patient")).add(Restrictions.eq("Disposal", disposalForAdmitted)).add(Restrictions.eq("OpdDate", new Date()))
									.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			System.out.println("departmentList"+departmentList.size());
			System.out.println("employeeList"+employeeList.size());
			System.out.println("dietList"+dietList.size());
			System.out.println("bloodGroupList"+bloodGroupList.size());
			
			System.out.println("admissionTypeList"+admissionTypeList.size());
			System.out.println("bedList"+bedList.size());
			System.out.println("relationList"+relationList.size());
			
			System.out.println("documentList"+documentList.size());
			System.out.println("disposalForAdmitted"+disposalForAdmitted);
			System.out.println("admissionWaitList"+admissionWaitList.size());
		}catch (HibernateException e){
			e.printStackTrace();
			/*session.close();*/
		}catch(Exception e){
			e.printStackTrace();

		}
		map.put("maritalStatusList",maritalStatusList);
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		System.out.println("departmentList>>"+departmentList.size());
		map.put("dietList", dietList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("admissionTypeList", admissionTypeList);
		map.put("bedList", bedList);
		map.put("relationList", relationList);
		map.put("documentList", documentList);
		map.put("admissionWaitList",admissionWaitList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Session getSes() {
		 return (Session)getSession();

		
	}
	@SuppressWarnings("unchecked")
	public HibernateTemplate getHibernateTemplateObject() {
		 return (HibernateTemplate)getHibernateTemplate();

		
	}
	public boolean addTrade(MasTrade masTrade, String s) {
		boolean addedTrade = false;
		try {
			java.util.List lst = getHibernateTemplate().find(
					"from MasTrade m where m.TradeName='" + s + "'");
			if (lst.size() == 0) {
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(masTrade);
				/*Query qyery = getSession()
						.createSQLQuery(
								"insert into mas_trade (last_chg_date,last_chg_time) values(sysdate(),time(sysdate()))");*/
				addedTrade = true ;
			} else {
				addedTrade = false ;
			}
		} catch (Exception e) {
			addedTrade = true ;
		}
		return addedTrade;
	}
	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> submitAdmissionInformation(Map<String, Object> admissionMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		String admissionFlag = "false";
		Patient patient = null;
		Inpatient inpatient = null;
		Discharge discharge = null;
		DischargeIcdCode dischargeIcdCode1 = null;
		String nextOfKinAddress = "";
		String nextOfKinName = "";
		String nextOfKinPhoneNo = "";
		int nextOfKinRelationId = 0;
		String nok2Name = "";
		String nok2Address = "";
		String nok2ContactNo = "";
		int nok2RelationId = 0;
		String patientStatus ="";
		int bloodGroupId = 0;
		int maritalStatusId = 0;
		int hinId = 0;
		int bedId = 0;
		String ab64 = "";
		String adNo = "";
		String[] documentIdArray = null;
		String[] diagnosidIdArray = null;
		String toa ="";
		java.sql.Date doa =null;
		String oldAdmission ="no";
		String cdaAccountNo = "";
//		Date addEditDate = new Date();
		int userId = 0;
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<MasUnit> unitList = new ArrayList<MasUnit>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
	    Transaction tx = null;
		Map<String,Object> utilMap = new HashMap<String,Object>();
		String date="";
		String currentTime="";
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		 date = (String)utilMap.get("currentDate");
		 currentTime = (String)utilMap.get("currentTimeWithoutSc");
		 SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		 SimpleDateFormat formatterOut = new  SimpleDateFormat("yyyy-MM-dd");
		 String date4MySQL =null;
		try {
			date4MySQL = formatterOut.format(formatterIn.parse(date));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		 java.sql.Date currentDate = java.sql.Date.valueOf(date4MySQL);
	    List<Inpatient> inpatientList =new ArrayList<Inpatient>();
		try {
			tx = session.beginTransaction();

			if(admissionMap.get("masUnitObj")!=null){
				MasUnit masUnit = (MasUnit)admissionMap.get("masUnitObj");
				hbt.save(masUnit);
			}

			int bedStatusOccupiedId = Integer.parseInt(properties.getProperty("bedStatusOccupiedId"));
			String inpatientStatus = properties.getProperty("inpatientStatus");


			if(admissionMap.get("userId") != null){
				userId = Integer.parseInt(""+admissionMap.get("userId")) ;
			}
			// Only for BAck date Admission
			if(admissionMap.get("doa") != null){
				doa = java.sql.Date.valueOf(""+admissionMap.get("doa"));
			}
				if(admissionMap.get("toa") != null){
				toa = (String)admissionMap.get("toa");
			}

			if(admissionMap.get("documentIdArray") != null){
				documentIdArray = (String[])admissionMap.get("documentIdArray");
			}
			/*if(admissionMap.get("diagnosidIdArray") != null){
				diagnosidIdArray = (String[])admissionMap.get("diagnosidIdArray");
			}*/
			if(admissionMap.get("patient") != null){
				patient = (Patient)admissionMap.get("patient");
			}
			if(admissionMap.get("inpatient") != null){
				inpatient = (Inpatient)admissionMap.get("inpatient");
			}
			if(admissionMap.get("patientMap") != null){
				patientMap = (Map)admissionMap.get("patientMap");
			}
			if(admissionMap.get("discharge") != null){
				discharge = (Discharge)admissionMap.get("discharge");
			}
			if(admissionMap.get("dischargeIcdCode") != null){
				dischargeIcdCode1 = (DischargeIcdCode)admissionMap.get("dischargeIcdCode");
			}

			if(admissionMap.get("hinId") != null){
				hinId = (Integer)admissionMap.get("hinId");
			}

			if(patientMap.get("nextOfKinName") != null){
				nextOfKinName = (String)patientMap.get("nextOfKinName");
			}
			if(patientMap.get("nextOfKinAddress") != null){
				nextOfKinAddress = (String)patientMap.get("nextOfKinAddress");
			}
			if(patientMap.get("nextOfKinPhoneNo") != null){
				nextOfKinPhoneNo = (String)patientMap.get("nextOfKinPhoneNo");
			}
			if(patientMap.get("nok2Name") != null){
				nok2Name = (String)patientMap.get("nok2Name");
			}
			if(patientMap.get("nok2Address") != null){
				nok2Address = (String)patientMap.get("nok2Address");
			}
			if(patientMap.get("nok2ContactNo") != null){
				nok2ContactNo = (String)patientMap.get("nok2ContactNo");
			}
			if(patientMap.get("patientStatus") != null){
				patientStatus = (String)patientMap.get("patientStatus");
			}
			if(patientMap.get("ab64") != null){
				ab64 = (String)patientMap.get("ab64");
			}
			if(patientMap.get("cdaAccountNo") != null){
				cdaAccountNo = (String)patientMap.get("cdaAccountNo");
			}
			if(admissionMap.get("adNo") != null){
				adNo = (String)admissionMap.get("adNo");
			}
			if(admissionMap.get("oldAdmission") != null){
				oldAdmission ="" +admissionMap.get("oldAdmission");
			}
			if(oldAdmission.equals("yes")){
				inpatient.setDateOfAddmission(doa);
				inpatient.setTimeOfAddmission(toa);
				inpatient.setListDate(doa);
				inpatient.setAddEditTime(toa);
				inpatient.setAddEditDate(doa);
				inpatient.setListTime(toa);
			}else{
				inpatient.setDateOfAddmission(currentDate);
				inpatient.setTimeOfAddmission(currentTime);
				inpatient.setListDate(currentDate);
				inpatient.setAddEditTime(currentTime);
				inpatient.setAddEditDate(currentDate);
				inpatient.setListTime(currentTime);
			}
			hbt.save(inpatient);
			hbt.refresh(inpatient);
			////////////////////////////////////////////////////////////////
			/*if(admissionMap.get("condition").equals("Dead")){
				discharge.setInpatient(inpatient);
				dischargeIcdCode1.setInpatient(inpatient);
				hbt.save(discharge);
				hbt.refresh(discharge);
				hbt.save(dischargeIcdCode1);
				hbt.refresh(dischargeIcdCode1);

			}
			else{
			//-----------------------------------Start Storing multiple Diagnosis --------------------------------
				String query ="";
				List objectList=new ArrayList();
				int icdId =0;
				if(diagnosidIdArray !=null)
				if(diagnosidIdArray.length > 0)
				for(int i = 0 ; i<diagnosidIdArray.length; i++){
					DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
					if(!diagnosidIdArray[i].equals("0") ){
						Patient patient2 = new Patient();
						patient2.setId(hinId);
						dischargeIcdCode.setHin(patient2);
						dischargeIcdCode.setInpatient(inpatient);
						try{
						MasIcd masIcd = new MasIcd();
						query ="select icd_id from mas_icd where icd_code='"+diagnosidIdArray[i]+"'";
						objectList = (List) session.createSQLQuery(query).list();
						masIcd.setId(Integer.parseInt(""+objectList.get(0)));
						dischargeIcdCode.setIcd(masIcd);
						Users userObject = new Users();
						userObject.setId(userId);
						dischargeIcdCode.setAddEditBy(userObject);
						dischargeIcdCode.setZ03("n");
						dischargeIcdCode.setZ09("n");
						if(oldAdmission.equals("yes")){
							dischargeIcdCode.setAddEditDate(doa);
							dischargeIcdCode.setAddEditTime(toa);
						}else{
						dischargeIcdCode.setAddEditDate(currentDate);
						dischargeIcdCode.setAddEditTime(currentTime);
						}
						dischargeIcdCode.setStatus("y");
						dischargeIcdCode.setDiagnosisStatus("p");
						hbt.save(dischargeIcdCode);
						}catch (HibernateException e){
							e.printStackTrace();
							session.close();
						}catch (Exception e) {
							e.printStackTrace();
						}

					}
				}*/

			//-----------------------------------End Storing multiple Diagnosis --------------------------------
			inpatientList=session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).list();
			//inpatientList=hbt.find("from Inpatient inp where inp.AdNo='"+adNo+"'");

			//-----------------------------------Storing data in SilDilStatus----------------
			try{
			if(admissionMap.get("condition").equals("Critical")){
			int inpatientId =0;
			for(Inpatient inpatient2 :inpatientList){
				 inpatientId =inpatient2.getId();
			}
			SilDilStatus dilStatus =new SilDilStatus();
			dilStatus.setInpatient(new Inpatient(inpatientId));
		//	if(icdId !=0)
		//	dilStatus.setIcd(new MasIcd(icdId));
			dilStatus.setTreatment("");
			dilStatus.setRemarks(""+admissionMap.get("condition"));
			dilStatus.setDepartment(new MasDepartment(Integer.parseInt(""+admissionMap.get("departmentId"))));
			dilStatus.setConditionStatus(""+admissionMap.get("conditionStatus"));
			dilStatus.setNok("no");
			dilStatus.setLastChgBy("");
			if(oldAdmission.equals("yes")){
				dilStatus.setLastChgDate(doa);
				dilStatus.setLastChgTime(toa);
			}else{
				dilStatus.setLastChgDate(currentDate);
				dilStatus.setLastChgTime(currentTime);
			}

			if(admissionMap.get("consultingDoctorId") !=null)
			dilStatus.setPlacedBy(new MasEmployee(Integer.parseInt(""+admissionMap.get("consultingDoctorId"))));

			hbt.save(dilStatus);
			}
			}catch (HibernateException e){
				e.printStackTrace();
				session.close();
			}catch (Exception e) {
				e.printStackTrace();

			}
//	}// end for dead condition
			//-------------------Storing multiple mas_document entries for Inpatient----------
			if(documentIdArray !=null)
			if(documentIdArray.length>0)
			for (int i = 0; i < documentIdArray.length; i++) {
				if(!documentIdArray[i].equals("0") ){
				InpatientDocument document=new InpatientDocument();

				MasDocument masDocument=new MasDocument();
				masDocument.setId(Integer.parseInt(""+documentIdArray[i]));
				document.setDocument(masDocument);
				document.setInpatient(inpatient);
				hbt.save(document);
				}
			}

			Patient patientObj = (Patient)hbt.load(Patient.class, hinId);

			patientObj.setNextOfKinName(nextOfKinName);
			patientObj.setNextOfKinAddress(nextOfKinAddress);
			patientObj.setNextOfKinPhoneNumber(nextOfKinPhoneNo);
			patientObj.setNok2Name(nok2Name);
			patientObj.setNok2Address(nok2Address);
			patientObj.setNok2ContactNo(nok2ContactNo);
			if(!patientStatus.equals("")){
				patientObj.setPatientStatus(patientStatus);
			}else{
				patientObj.setPatientStatus(inpatientStatus);
			}
			patientObj.setAb64Available(ab64);
			patientObj.setCdaAccountNo(cdaAccountNo);
			if(patientMap.get("nextOfKinRelationId") != null){
				nextOfKinRelationId = (Integer)patientMap.get("nextOfKinRelationId");
				if(nextOfKinRelationId!=0){
					MasRelation masRelation = new MasRelation();
					masRelation.setId(nextOfKinRelationId);
					patientObj.setNextOfKinRelation(masRelation);
				}
			}
			if(patientMap.get("nok2RelationId") != null){
				nok2RelationId = (Integer)patientMap.get("nok2RelationId");
				if(nok2RelationId!=0){
					MasRelation masRelation = new MasRelation();
					masRelation.setId(nok2RelationId);
					patientObj.setNok2Relation(masRelation);
				}
			}
			int unitId =0;
			if(patientMap.get("unitId") != null){
				unitId = (Integer)patientMap.get("unitId");
				MasUnit masUnit = new MasUnit();
				masUnit.setId(unitId);
				patientObj.setUnit(masUnit);
			}
			if(patientMap.get("bloodGroupId") != null){
				bloodGroupId = (Integer)patientMap.get("bloodGroupId");
				MasBloodGroup bloodGroup = new MasBloodGroup();
				bloodGroup.setId(bloodGroupId);
				patientObj.setBloodGroup(bloodGroup);
			}
			if(patientMap.get("maritalStatusId") != null){
				maritalStatusId = (Integer)patientMap.get("maritalStatusId");
				MasMaritalStatus maritalStatus = new MasMaritalStatus();
				maritalStatus.setId(maritalStatusId);
				patientObj.setMaritalStatus(maritalStatus);
			}
			Float totalService =null;
			String totalServicePeriod ="";
			if(admissionMap.get("totalService") != null){
				totalService = new Float(""+admissionMap.get("totalService")) ;
				patientObj.setServiceYears(totalService);
			}
		/*	if(admissionMap.get("iCardValididy") != null && !admissionMap.get("iCardValididy").equals("")){
				patientObj.setServiceCardValidityDate(currentDate);
			}
			try{
			if(admissionMap.get("dependenetCardIssueDate") != null && !admissionMap.get("dependenetCardIssueDate").equals("")){
				SimpleDateFormat formatterIn1 = new SimpleDateFormat("dd/MM/yyyy");
				 SimpleDateFormat formatterOut1 = new  SimpleDateFormat("yyyy-MM-dd");
				 if(admissionMap.get("iCardValididy")!=null){
				 String date4MySQL1=formatterOut1.format(formatterIn1.parse(""+admissionMap.get("iCardValididy")));
				 Date date1 = java.sql.Date.valueOf(date4MySQL1);
				 patientObj.setDependentCardIssueDate(date1);
				}

			}
			}catch (Exception e) {
				e.printStackTrace();


			}
			if(admissionMap.get("iCardVerified") != null){
				patientObj.setServiceCardStatus((""+admissionMap.get("iCardVerified")));

			}*/
			if(admissionMap.get("totalServicePeriod") != null){
				totalServicePeriod = (""+admissionMap.get("totalServicePeriod")) ;
				patientObj.setTotalServicePeriod(totalServicePeriod);
			}

			if(patientMap.get("rankId") != null){
				 int rankId = Integer.parseInt(""+patientMap.get("rankId")) ;
				 MasRank masRank =new MasRank();
				 masRank.setId(rankId);
				 patientObj.setRank(masRank);
			}
			if(admissionMap.get("masUnitObj")!=null){
				unitList = hbt.find("select max(id) from jkt.hms.masters.business.MasUnit mu ");
				MasUnit masUnitObj = new MasUnit();
				masUnitObj.setId(Integer.parseInt(""+unitList.get(0)) );
				patientObj.setUnit(masUnitObj);
			}
			/*if(admissionMap.get("tradeId")!=null){
				MasTrade masTrade = new MasTrade();
				masTrade.setId(Integer.parseInt(""+admissionMap.get("tradeId")));
				patientObj.setTrade(masTrade);

			}
			MasTrade masTradeObj = null;
			if(admissionMap.get("masTradeObj")!=null){
				masTradeObj =(MasTrade)admissionMap.get("masTradeObj");
				addTrade(masTradeObj , masTradeObj.getTradeName());
				List<Integer> tradeList = hbt.find("select max(mt.Id) from jkt.hms.masters.business.MasTrade mt where mt.TradeName = '"+masTradeObj.getTradeName()+"'");
				masTradeObj.setId(Integer.parseInt(""+tradeList.get(0)) );
				patientObj.setTrade(masTradeObj);
			}*/

			hbt.update(patientObj);
			if(admissionMap.get("bedId") != null){
				bedId = (Integer)admissionMap.get("bedId");
				MasBed masBed = (MasBed)hbt.load(MasBed.class, bedId);
				MasBedStatus bedStatus = new MasBedStatus();
				bedStatus.setId(bedStatusOccupiedId);
				masBed.setBedStatus(bedStatus);
				hbt.update(masBed);
			}

			admissionFlag = "true";
			tx.commit();
		} catch (Exception e) {
			 if (tx != null) tx.rollback();
		        //throw e; // or display error message
			    e.printStackTrace();

		}

		map.put("admissionFlag", admissionFlag);
		map.put("inpatientList",inpatientList);
		return map;
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> submitAdmissionInformationHAL(Map<String, Object> admissionMap, Transaction tx, org.hibernate.Session session) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		String admissionFlag = "false";
		Patient patient = null;
		Inpatient inpatient = null;
		Discharge discharge = null;
		DischargeIcdCode dischargeIcdCode1 = null;
		String nextOfKinAddress = "";
		String nextOfKinName = "";
		String nextOfKinPhoneNo = "";
		int nextOfKinRelationId = 0;
		String nok2Name = "";
		String nok2Address = "";
		String nok2ContactNo = "";
		int nok2RelationId = 0;
		String patientStatus ="";
		int bloodGroupId = 0;
		int maritalStatusId = 0;
		int hinId = 0;
		int bedId = 0;
		String ab64 = "";
		String adNo = "";
		String[] documentIdArray = null;
		String[] diagnosidIdArray = null;
		String toa ="";
		java.sql.Date doa =null;
		String oldAdmission ="no";
		String cdaAccountNo = "";
//		Date addEditDate = new Date();
		int userId = 0;
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<MasUnit> unitList = new ArrayList<MasUnit>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		session = (Session)getSession();
	    
		Map<String,Object> utilMap = new HashMap<String,Object>();
		String date="";
		String currentTime="";
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		 date = (String)utilMap.get("currentDate");
		 currentTime = (String)utilMap.get("currentTimeWithoutSc");
		 SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		 SimpleDateFormat formatterOut = new  SimpleDateFormat("yyyy-MM-dd");
		 String date4MySQL =null;
		try {
			date4MySQL = formatterOut.format(formatterIn.parse(date));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		 java.sql.Date currentDate = java.sql.Date.valueOf(date4MySQL);
	    List<Inpatient> inpatientList =new ArrayList<Inpatient>();
		try {
			

			if(admissionMap.get("masUnitObj")!=null){
				MasUnit masUnit = (MasUnit)admissionMap.get("masUnitObj");
				hbt.save(masUnit);
			}

			int bedStatusOccupiedId = Integer.parseInt(properties.getProperty("bedStatusOccupiedId"));
			String inpatientStatus = properties.getProperty("inpatientStatus");


			if(admissionMap.get("userId") != null){
				userId = Integer.parseInt(""+admissionMap.get("userId")) ;
			}
			// Only for BAck date Admission
			if(admissionMap.get("doa") != null){
				doa = java.sql.Date.valueOf(""+admissionMap.get("doa"));
			}
				if(admissionMap.get("toa") != null){
				toa = (String)admissionMap.get("toa");
			}

			if(admissionMap.get("documentIdArray") != null){
				documentIdArray = (String[])admissionMap.get("documentIdArray");
			}
			/*if(admissionMap.get("diagnosidIdArray") != null){
				diagnosidIdArray = (String[])admissionMap.get("diagnosidIdArray");
			}*/
			if(admissionMap.get("patient") != null){
				patient = (Patient)admissionMap.get("patient");
			}
			
			if(admissionMap.get("inpatient") != null){
				inpatient = (Inpatient)admissionMap.get("inpatient");
			}
			if(admissionMap.get("patientMap") != null){
				patientMap = (Map)admissionMap.get("patientMap");
			}
			if(admissionMap.get("discharge") != null){
				discharge = (Discharge)admissionMap.get("discharge");
			}
			if(admissionMap.get("dischargeIcdCode") != null){
				dischargeIcdCode1 = (DischargeIcdCode)admissionMap.get("dischargeIcdCode");
			}

			if(admissionMap.get("hinId") != null){
				hinId = (Integer)admissionMap.get("hinId");
			}

			if(patientMap.get("nextOfKinName") != null){
				nextOfKinName = (String)patientMap.get("nextOfKinName");
			}
			if(patientMap.get("nextOfKinAddress") != null){
				nextOfKinAddress = (String)patientMap.get("nextOfKinAddress");
			}
			if(patientMap.get("nextOfKinPhoneNo") != null){
				nextOfKinPhoneNo = (String)patientMap.get("nextOfKinPhoneNo");
			}
			if(patientMap.get("nok2Name") != null){
				nok2Name = (String)patientMap.get("nok2Name");
			}
			if(patientMap.get("nok2Address") != null){
				nok2Address = (String)patientMap.get("nok2Address");
			}
			if(patientMap.get("nok2ContactNo") != null){
				nok2ContactNo = (String)patientMap.get("nok2ContactNo");
			}
			if(patientMap.get("patientStatus") != null){
				patientStatus = (String)patientMap.get("patientStatus");
			}
			if(patientMap.get("ab64") != null){
				ab64 = (String)patientMap.get("ab64");
			}
			if(patientMap.get("cdaAccountNo") != null){
				cdaAccountNo = (String)patientMap.get("cdaAccountNo");
			}
			if(admissionMap.get("adNo") != null){
				adNo = (String)admissionMap.get("adNo");
			}
			if(admissionMap.get("oldAdmission") != null){
				oldAdmission ="" +admissionMap.get("oldAdmission");
			}
			if(oldAdmission.equals("yes")){
				inpatient.setDateOfAddmission(doa);
				inpatient.setTimeOfAddmission(toa);
				inpatient.setListDate(doa);
				inpatient.setAddEditTime(toa);
				inpatient.setAddEditDate(doa);
				inpatient.setListTime(toa);
			}else{
				inpatient.setDateOfAddmission(currentDate);
				inpatient.setTimeOfAddmission(currentTime);
				inpatient.setListDate(currentDate);
				inpatient.setAddEditTime(currentTime);
				inpatient.setAddEditDate(currentDate);
				inpatient.setListTime(currentTime);
			}
			Visit vis = new Visit();
			int visitId= 0;
			if(admissionMap.get("visitId") != null){
				visitId = (Integer)admissionMap.get("visitId");
				vis.setId(visitId);
				inpatient.setVisit(vis);
			}
			
			
			hbt.save(inpatient);
			hbt.refresh(inpatient);
			//code starts for updating opd_surgery_header table if surgery is already given from opd
			List<OpdSurgeryHeader> surgeryHeaderList = new ArrayList<OpdSurgeryHeader>();
			surgeryHeaderList = session.createCriteria(OpdSurgeryHeader.class)
			.add(Restrictions.eq("Visit.Id", visitId))
			.add(Restrictions.isNull("Inpatient.Id")).list();
			for(OpdSurgeryHeader sh : surgeryHeaderList)
			{
				sh.setInpatient(inpatient);
				sh.setPatientStatus("In Patient");
				hbt.update(sh);
				hbt.flush();
			}
				
				
			//code ends for updating opd_surgery_header table if surgery is already given from opd	
				
			////////////////////////////////////////////////////////////////
			/*if(admissionMap.get("condition").equals("Dead")){
				discharge.setInpatient(inpatient);
				dischargeIcdCode1.setInpatient(inpatient);
				hbt.save(discharge);
				hbt.refresh(discharge);
				hbt.save(dischargeIcdCode1);
				hbt.refresh(dischargeIcdCode1);

			}
			else{
			//-----------------------------------Start Storing multiple Diagnosis --------------------------------
				String query ="";
				List objectList=new ArrayList();
				int icdId =0;
				if(diagnosidIdArray !=null)
				if(diagnosidIdArray.length > 0)
				for(int i = 0 ; i<diagnosidIdArray.length; i++){
					DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
					if(!diagnosidIdArray[i].equals("0") ){
						Patient patient2 = new Patient();
						patient2.setId(hinId);
						dischargeIcdCode.setHin(patient2);
						dischargeIcdCode.setInpatient(inpatient);
						try{
						MasIcd masIcd = new MasIcd();
						query ="select icd_id from mas_icd where icd_code='"+diagnosidIdArray[i]+"'";
						objectList = (List) session.createSQLQuery(query).list();
						masIcd.setId(Integer.parseInt(""+objectList.get(0)));
						dischargeIcdCode.setIcd(masIcd);
						Users userObject = new Users();
						userObject.setId(userId);
						dischargeIcdCode.setAddEditBy(userObject);
						dischargeIcdCode.setZ03("n");
						dischargeIcdCode.setZ09("n");
						if(oldAdmission.equals("yes")){
							dischargeIcdCode.setAddEditDate(doa);
							dischargeIcdCode.setAddEditTime(toa);
						}else{
						dischargeIcdCode.setAddEditDate(currentDate);
						dischargeIcdCode.setAddEditTime(currentTime);
						}
						dischargeIcdCode.setStatus("y");
						dischargeIcdCode.setDiagnosisStatus("p");
						hbt.save(dischargeIcdCode);
						}catch (HibernateException e){
							e.printStackTrace();
							session.close();
						}catch (Exception e) {
							e.printStackTrace();
						}

					}
				}*/

			//-----------------------------------End Storing multiple Diagnosis --------------------------------
			inpatientList=session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).list();
			//inpatientList=hbt.find("from Inpatient inp where inp.AdNo='"+adNo+"'");

			//-----------------------------------Storing data in SilDilStatus----------------
			try{
			if(admissionMap.get("condition").equals("Critical")){
			int inpatientId =0;
			for(Inpatient inpatient2 :inpatientList){
				 inpatientId =inpatient2.getId();
			}
			SilDilStatus dilStatus =new SilDilStatus();
			dilStatus.setInpatient(new Inpatient(inpatientId));
		//	if(icdId !=0)
		//	dilStatus.setIcd(new MasIcd(icdId));
			dilStatus.setTreatment("");
			dilStatus.setRemarks(""+admissionMap.get("condition"));
			dilStatus.setDepartment(new MasDepartment(Integer.parseInt(""+admissionMap.get("departmentId"))));
			dilStatus.setConditionStatus(""+admissionMap.get("conditionStatus"));
			dilStatus.setNok("no");
			dilStatus.setLastChgBy("");
			if(oldAdmission.equals("yes")){
				dilStatus.setLastChgDate(doa);
				dilStatus.setLastChgTime(toa);
			}else{
				dilStatus.setLastChgDate(currentDate);
				dilStatus.setLastChgTime(currentTime);
			}

			if(admissionMap.get("consultingDoctorId") !=null)
			dilStatus.setPlacedBy(new MasEmployee(Integer.parseInt(""+admissionMap.get("consultingDoctorId"))));

			hbt.save(dilStatus);
			}
			}catch (HibernateException e){
				e.printStackTrace();
				/*session.close();*/
			}catch (Exception e) {
				e.printStackTrace();

			}
//	}// end for dead condition
			//-------------------Storing multiple mas_document entries for Inpatient----------
			if(documentIdArray !=null)
			if(documentIdArray.length>0)
			for (int i = 0; i < documentIdArray.length; i++) {
				if(!documentIdArray[i].equals("0") ){
				InpatientDocument document=new InpatientDocument();

				MasDocument masDocument=new MasDocument();
				masDocument.setId(Integer.parseInt(""+documentIdArray[i]));
				document.setDocument(masDocument);
				document.setInpatient(inpatient);
				hbt.save(document);
				}
			}

			Patient patientObj = (Patient)hbt.load(Patient.class, hinId);

			patientObj.setNextOfKinName(nextOfKinName);
			patientObj.setNextOfKinAddress(nextOfKinAddress);
			patientObj.setNextOfKinPhoneNumber(nextOfKinPhoneNo);
			patientObj.setNok2Name(nok2Name);
			patientObj.setNok2Address(nok2Address);
			patientObj.setNok2ContactNo(nok2ContactNo);
			if(!patientStatus.equals("")){
				patientObj.setPatientStatus(patientStatus);
			}else{
				patientObj.setPatientStatus(inpatientStatus);
			}
			patientObj.setAb64Available(ab64);
			patientObj.setCdaAccountNo(cdaAccountNo);
			if(patientMap.get("nextOfKinRelationId") != null){
				nextOfKinRelationId = (Integer)patientMap.get("nextOfKinRelationId");
				if(nextOfKinRelationId!=0){
					MasRelation masRelation = new MasRelation();
					masRelation.setId(nextOfKinRelationId);
					patientObj.setNextOfKinRelation(masRelation);
				}
			}
			if(patientMap.get("nok2RelationId") != null){
				nok2RelationId = (Integer)patientMap.get("nok2RelationId");
				if(nok2RelationId!=0){
					MasRelation masRelation = new MasRelation();
					masRelation.setId(nok2RelationId);
					patientObj.setNok2Relation(masRelation);
				}
			}
			int unitId =0;
			if(patientMap.get("unitId") != null){
				unitId = (Integer)patientMap.get("unitId");
				MasUnit masUnit = new MasUnit();
				masUnit.setId(unitId);
				patientObj.setUnit(masUnit);
			}
			if(patientMap.get("bloodGroupId") != null){
				bloodGroupId = (Integer)patientMap.get("bloodGroupId");
				MasBloodGroup bloodGroup = new MasBloodGroup();
				bloodGroup.setId(bloodGroupId);
				patientObj.setBloodGroup(bloodGroup);
			}
			if(patientMap.get("maritalStatusId") != null){
				maritalStatusId = (Integer)patientMap.get("maritalStatusId");
				MasMaritalStatus maritalStatus = new MasMaritalStatus();
				maritalStatus.setId(maritalStatusId);
				patientObj.setMaritalStatus(maritalStatus);
			}
			Float totalService =null;
			String totalServicePeriod ="";
			if(admissionMap.get("totalService") != null){
				totalService = new Float(""+admissionMap.get("totalService")) ;
				patientObj.setServiceYears(totalService);
			}
		/*	if(admissionMap.get("iCardValididy") != null && !admissionMap.get("iCardValididy").equals("")){
				patientObj.setServiceCardValidityDate(currentDate);
			}
			try{
			if(admissionMap.get("dependenetCardIssueDate") != null && !admissionMap.get("dependenetCardIssueDate").equals("")){
				SimpleDateFormat formatterIn1 = new SimpleDateFormat("dd/MM/yyyy");
				 SimpleDateFormat formatterOut1 = new  SimpleDateFormat("yyyy-MM-dd");
				 if(admissionMap.get("iCardValididy")!=null){
				 String date4MySQL1=formatterOut1.format(formatterIn1.parse(""+admissionMap.get("iCardValididy")));
				 Date date1 = java.sql.Date.valueOf(date4MySQL1);
				 patientObj.setDependentCardIssueDate(date1);
				}

			}
			}catch (Exception e) {
				e.printStackTrace();


			}
			if(admissionMap.get("iCardVerified") != null){
				patientObj.setServiceCardStatus((""+admissionMap.get("iCardVerified")));

			}*/
			if(admissionMap.get("totalServicePeriod") != null){
				totalServicePeriod = (""+admissionMap.get("totalServicePeriod")) ;
				patientObj.setTotalServicePeriod(totalServicePeriod);
			}

			if(patientMap.get("rankId") != null){
				 int rankId = Integer.parseInt(""+patientMap.get("rankId")) ;
				 MasRank masRank =new MasRank();
				 masRank.setId(rankId);
				 patientObj.setRank(masRank);
			}
			if(admissionMap.get("masUnitObj")!=null){
				unitList = hbt.find("select max(id) from jkt.hms.masters.business.MasUnit mu ");
				MasUnit masUnitObj = new MasUnit();
				masUnitObj.setId(Integer.parseInt(""+unitList.get(0)) );
				patientObj.setUnit(masUnitObj);
			}
			/*if(admissionMap.get("tradeId")!=null){
				MasTrade masTrade = new MasTrade();
				masTrade.setId(Integer.parseInt(""+admissionMap.get("tradeId")));
				patientObj.setTrade(masTrade);

			}
			MasTrade masTradeObj = null;
			if(admissionMap.get("masTradeObj")!=null){
				masTradeObj =(MasTrade)admissionMap.get("masTradeObj");
				addTrade(masTradeObj , masTradeObj.getTradeName());
				List<Integer> tradeList = hbt.find("select max(mt.Id) from jkt.hms.masters.business.MasTrade mt where mt.TradeName = '"+masTradeObj.getTradeName()+"'");
				masTradeObj.setId(Integer.parseInt(""+tradeList.get(0)) );
				patientObj.setTrade(masTradeObj);
			}*/

			hbt.update(patientObj);
			if(admissionMap.get("bedId") != null){
				bedId = (Integer)admissionMap.get("bedId");
				MasBed masBed = (MasBed)hbt.load(MasBed.class, bedId);
				MasBedStatus bedStatus = new MasBedStatus();
				bedStatus.setId(bedStatusOccupiedId);
				masBed.setBedStatus(bedStatus);
				hbt.update(masBed);
			}

			admissionFlag = "true";
			
		} catch (Exception e) {
			
			    e.printStackTrace();

		}

		map.put("admissionFlag", admissionFlag);
		map.put("inpatientList",inpatientList);
		return map;
	}

	@SuppressWarnings({"unchecked","unused"})
	public String getMotherName(String motherAdNo) {
		Session session = (Session)getSession();
		boolean flag = false;
		String name = "";
		try{
			List<Inpatient> motherAdList = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", motherAdNo)).list();
			for (Inpatient inpatient : motherAdList) {
				Patient patient = inpatient.getHin();
				String middleName = "";
				String lastName = "";
				if(patient.getPMiddleName() != null){
					middleName = patient.getPMiddleName();
				}
				if(patient.getPLastName() != null){
					lastName = patient.getPLastName();
				}
				name = patient.getPFirstName()+" "+middleName+" "+lastName;
			}
		}catch(HibernateException e){
			e.printStackTrace();
			session.close();
		}
		return name;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getServiceTypeAndRelation(Map<String, Object> parameterMap) {
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasServiceStatus> serviceStatusList = new ArrayList<MasServiceStatus>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		Map<String, Object> map = new HashMap<String, Object>();

		int relationId = 0;
		int serviceTypeId = 0;
		int serviceStatusId = 0;

		if(parameterMap.get("serviceTypeId") != null){
			serviceTypeId = (Integer)parameterMap.get("serviceTypeId");
		}
		if(parameterMap.get("serviceStatusId") != null){
			serviceStatusId = (Integer)parameterMap.get("serviceStatusId");
		}
		if(parameterMap.get("relationId") != null){
			relationId = (Integer)parameterMap.get("relationId");
		}

		 Session session = (Session) getSession();

		try {
			serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.idEq(serviceTypeId)).list();
			String serviceTypeCode = "";
			for (MasServiceType masServiceType : serviceTypeList) {
				serviceTypeCode = masServiceType.getServiceTypeCode();
				map.put("serviceTypeCode", serviceTypeCode);
			}
			relationList = session.createCriteria(MasRelation.class).add(Restrictions.idEq(relationId)).list();
			String relationCode = "";
			for (MasRelation masRelation : relationList) {
				relationCode = masRelation.getRelationCode();
				map.put("relationCode", relationCode);
			}
			serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.idEq(serviceStatusId)).list();
			String serviceStatusCode = "";
			for (MasServiceStatus masServiceStatus : serviceStatusList) {
				serviceStatusCode = masServiceStatus.getServiceStatusCode();
				map.put("serviceStatusCode", serviceStatusCode);
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
		}
		return map;
	}

	public String getHinId(String serviceNo, int serviceTypeId) {
		Session session = (Session)getSession();
		String previousHinNo = "";
		String maxSequenceNo= "";
		List<Patient> previousHinNoList = new ArrayList<Patient>();
		try {
			if(!serviceNo.equals("0") && serviceNo != null){
				previousHinNoList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();
			}else{
				previousHinNoList = session.createCriteria(Patient.class).list();
			}
				if(previousHinNoList.size() > 0){

					ArrayList hinNoSequenceList = new ArrayList();
					for (Patient patient : previousHinNoList) {
						if(patient.getServiceType().getId() == serviceTypeId){
							previousHinNo = patient.getHinNo();
							int length = previousHinNo.length()-2;
							String sequenceNo = previousHinNo.substring(length, previousHinNo.length());
							//int i = Integer.parseInt(sequenceNo);
							hinNoSequenceList.add(sequenceNo);
						}
					}

					if(hinNoSequenceList.size() > 0){
						maxSequenceNo = Collections.max(hinNoSequenceList).toString();
					}
				}


		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return maxSequenceNo;

	}
	public String getHinNo(int serviceTypeId,int relationId,int serviceStatusId,String serviceNo) {
		Map<String, Object> map = new HashMap<String, Object>();

		String hinNo = "";
		Session session = (Session)getSession();
//		int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
//		int relationId = Integer.parseInt(request.getParameter("relationId"));
//		int serviceStatusId = Integer.parseInt(request.getParameter("serviceStatus"));

		Map<String, Object> serviceAndRelationMap = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("serviceTypeId", serviceTypeId);
		parameterMap.put("relationId", relationId);
		parameterMap.put("serviceStatusId", serviceStatusId);
		serviceAndRelationMap = getServiceTypeAndRelation(parameterMap);
		String relationCode = (String)serviceAndRelationMap.get("relationCode");
		String serviceTypeCode = (String)serviceAndRelationMap.get("serviceTypeCode");
		String serviceStatusCode = (String)serviceAndRelationMap.get("serviceStatusCode");
		String maxSequenceNo = "";
		maxSequenceNo = getHinId(serviceNo,serviceTypeId);
		try{
		Integer i ;
		if(!maxSequenceNo.equals("")){
			i = Integer.parseInt(maxSequenceNo)+1;
		}else{
			i = 01;
		}
		String seqNo = "";
		if(i<=9){
			seqNo = "0"+i.toString();
		}else{
			seqNo = i.toString();
		}
		if(!serviceNo.equals("0")){
			hinNo = serviceTypeCode.concat(serviceStatusCode).concat(serviceNo).concat(relationCode).concat(seqNo.toString());
		}
		else{
			hinNo = serviceTypeCode.concat(seqNo.toString());
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		//String jsp = AJAX_MESSAGE_JSP;

		String message=hinNo;
		map.put("message", message);
		return hinNo;
	}
	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> saveAttachedAdmission(Map<String, Object> attachMap) {
		//AttachInpatient attachInpatientObj = null;
		Map<String, Object> adMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String attachFlag = "false";
		Transaction transaction = null;
		int dietId = 0;
		int sexId = 0;
		int relationId = 0;
		int wardId = 0;
		int hinId = 0;
		int bedId = 0;
		String age ="";
		String attachName = "";
		String parentAdNo ="";
		int hospitalId = 0;
		int deptId= 0;
		Box box=null;
		String andNo ="";
		String atOrDt ="" ;
		String serviceNo ="";
		int serviceTypeId =0;
		serviceTypeId = Integer.parseInt(""+attachMap.get("serviceTypeId"));
		relationId = Integer.parseInt(""+attachMap.get("relationId"));
		serviceNo = (""+attachMap.get("serviceNo"));
		box=(Box) attachMap.get("box");
		parentAdNo=""+box.get("parentAdNo");
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Session session=(Session)getSession();
		  List<Inpatient> inpatientList =new ArrayList<Inpatient>();
		 //checking the patient registation
		  List<Patient> patientList =new ArrayList<Patient>();
		  try {
			if(relationId ==2 || relationId ==3 || relationId ==8)
			  patientList =session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo",serviceNo))
			  												     .add(Restrictions.eq("ServiceType.Id", serviceTypeId))
			  												     .add(Restrictions.eq("Relation.Id", relationId)).list();

			  inpatientList=session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", parentAdNo)).list();
		} catch (HibernateException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			session.close();
		}
		  Inpatient inpatient2=inpatientList.get(0);
		int bedStatusOccupiedId = Integer.parseInt(properties.getProperty("bedStatusOccupiedId"));
		String inpatientStatus = (properties.getProperty("inpatientStatus"));

		if(attachMap.get("attachName") != null){
			attachName = (String)attachMap.get("attachName");
		}
		if(attachMap.get("deptId") != null){
			deptId = Integer.parseInt(""+attachMap.get("deptId")) ;
		}
		if(attachMap.get("sexId") != null){
			sexId = Integer.parseInt(""+attachMap.get("sexId"));
		}
		if(attachMap.get("age") != null){
			age = (""+attachMap.get("age"));
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);


		 /* List<MasBed> bedList = new ArrayList<MasBed>();
		  bedList = session.createCriteria(MasBed.class).add(Restrictions.eq("Status", "y")).list();*/

			int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));

			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			 String date = (String)utilMap.get("currentDate");
			  String time = (String)utilMap.get("currentTimeWithoutSc");
			 SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
				String date4MySQL="";
				try {
					date4MySQL = formatterOut.format(formatterIn.parse(date));

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


		try {
			//transaction = session.beginTransaction();
			Date lastChgDate = java.sql.Date.valueOf(date4MySQL);
			try{
			if(attachMap.get("dietId") != null){
				dietId = (Integer)attachMap.get("dietId");
				MasDiet masDiet = new MasDiet();
				masDiet.setId(dietId);
				//attachInpatientObj.setDiet(masDiet);
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
			if(attachMap.get("sexId") != null){
				sexId = (Integer)attachMap.get("sexId");
				MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
				masAdministrativeSex.setId(sexId);
				//attachInpatientObj.setSex(masAdministrativeSex);
			}
			if(attachMap.get("relationId") != null){
				relationId = (Integer)attachMap.get("relationId");
				MasRelation masRelation = new MasRelation();
				masRelation.setId(relationId);
				//attachInpatientObj.setRelation(masRelation);
			}

			if(attachMap.get("hinId") != null){
				hinId = (Integer)attachMap.get("hinId");
				Patient patient3 = new Patient();
				patient3.setId(hinId);
				//attachInpatientObj.setHin(patient3);
			}
			Patient patient =(Patient)hbt.load(Patient.class, hinId);
			adMap.put("serviceTypeCode", ""+patient.getServiceType().getServiceNameShortDesc());
			adMap.put("date", date);
			adMap.put("serviceTypeId", serviceTypeId);
			andNo=generateAdNumber(adMap);
			//attachInpatientObj.setAdNo(andNo);
			//hbt.save(attachInpatientObj);
			//---------Creating Patient entry for attached patient ------------------------------------
			Patient patient2=new Patient();
			String newHinNo ="";
			if(patientList.size() > 0){
				int ptId =0;
				for(Patient pt : patientList){
					if(relationId ==pt.getRelation().getId())
						ptId=pt.getId();
					newHinNo = pt.getHinNo();
				}
				patient2.setId(ptId);
				hospitalId=Integer.parseInt(""+patient.getHospital().getId()) ;

			}else{
			patient2.setServiceNo(patient.getServiceNo());

			MasServiceType serviceType=new MasServiceType();
			serviceType.setId(patient.getServiceType().getId());
			patient2.setServiceType(serviceType);

			MasRelation relation=new MasRelation();
			relation.setId(relationId);
			patient2.setRelation(relation);

			MasHospital hospital=new MasHospital();
			hospitalId=Integer.parseInt(""+patient.getHospital().getId()) ;
			hospital.setId(patient.getHospital().getId());
			patient2.setHospital(hospital);

			MasRank masRank=new MasRank();
			masRank.setId(patient.getRank().getId());
			patient2.setRank(masRank);

			MasUnit masUnit=new MasUnit();
			masUnit.setId(patient.getUnit().getId());
			patient2.setUnit(masUnit);
			if(patient.getTitle() !=null){
			MasTitle title=new MasTitle();
			title.setId(patient.getTitle().getId());
			patient2.setTitle(title);
				}
			patient2.setPFirstName(attachName);
			patient2.setPMiddleName("");
			patient2.setPLastName("");

			patient2.setSFirstName(patient.getSFirstName());
			patient2.setSMiddleName(patient.getSMiddleName());
			patient2.setSLastName(patient.getSLastName());
			patient2.setServiceNo(patient.getServiceNo());
			patient2.setTotalServicePeriod(patient.getTotalServicePeriod());
			patient2.setServiceYears(patient.getServiceYears());


			MasAdministrativeSex sex = new MasAdministrativeSex();
			sex.setId(sexId);
			patient2.setSex(sex);

			patient2.setDateOfBirth(null);
			patient2.setMaritalStatus(null);
			newHinNo=getHinNo(patient.getServiceType().getId(), patient.getRelation().getId(),patient.getServiceStatus().getId(),patient.getServiceNo());
			patient2.setHinNo(newHinNo);
			if(patient.getTrade() != null){
			MasTrade masTrade=new MasTrade();
			masTrade.setId(patient.getTrade().getId());
			patient2.setTrade(masTrade);
			}
			patient2.setRecordOfficeAddress(patient.getRecordOfficeAddress());
			patient2.setCdaAccountNo(patient.getCdaAccountNo());
			patient2.setServiceYears(null);
			MasReligion religion=new MasReligion();
			religion.setId(patient.getReligion().getId());
			patient2.setReligion(religion);

			patient2.setStation(patient.getStation());
			patient2.setFormation(patient.getFormation());
			patient2.setAb64Available(patient.getAb64Available());
			patient2.setCdaAccountNo(patient.getCdaAccountNo());
			patient2.setPatientDistrict(patient.getPatientDistrict());
			patient2.setBlock(null);

			MasDistrict district=new MasDistrict();
			district.setId(patient.getDistrict().getId());
			patient2.setDistrict(district);

			MasState state=new MasState();
			state.setId(patient.getState().getId());
			patient2.setState(state);

			MasCountry country=new MasCountry();
			country.setId(patient.getCountry().getId());
			patient2.setCountry(country);

			if(patient.getReference() !=null){
			MasReference reference=new MasReference();
			reference.setId(patient.getReference().getId());
			patient2.setReference(reference);
			}

			if(patient.getBloodGroup() !=null)	{
			MasBloodGroup group=new MasBloodGroup();
			group.setId(patient.getBloodGroup().getId());
			patient2.setBloodGroup(group);
			}
			patient2.setCurrentVisitNo(patient.getCurrentVisitNo());
			patient2.setInpatientNo(patient.getInpatientNo());
			patient2.setCity(patient.getCity());
			patient2.setPoliceStation(patient.getPoliceStation());


			patient2.setPostOffice(patient.getPostOffice());
			patient2.setPinCode(patient.getPinCode());
			patient2.setEmailId(patient.getEmailId());

			if(patient.getRecordOfficeAddress() !=null){
				MasRecordOfficeAddress recordOfficeAddress=new MasRecordOfficeAddress();
				recordOfficeAddress.setId(patient.getRecordOfficeAddress().getId());
				patient2.setRecordOfficeAddress(recordOfficeAddress);
			}

			if(patient.getOccupation() !=null){
				MasOccupation masOccupation =new MasOccupation();
				masOccupation.setId(patient.getOccupation().getId());
				patient2.setOccupation(masOccupation);
			}

			patient2.setPhoneNumber(patient.getPhoneNumber());
			patient2.setMobileNumber(patient.getMobileNumber());
			patient2.setNextOfKinName(patient.getNextOfKinName());
			patient2.setNextOfKinAddress(patient.getNextOfKinAddress());
			patient2.setNextOfKinPhoneNumber(patient.getNextOfKinPhoneNumber());
			patient2.setNextOfKinMobileNumber(patient.getNextOfKinMobileNumber());

			if(patient.getNextOfKinRelation() !=null){
				MasRelation relation2=new MasRelation();
				relation2.setId(patient.getNextOfKinRelation().getId());
				patient2.setNextOfKinRelation(relation2);
			}
			patient2.setRemarks(patient.getRemarks());
			if(patient.getAddEditBy() !=null){
				Users users=new Users();
				users.setId(patient.getAddEditBy().getId());
			patient2.setAddEditBy(users);
			}

			patient2.setAddEditDate(patient.getAddEditDate());
			patient2.setAddEditTime(patient.getAddEditTime());
			patient2.setPatientStatus(inpatientStatus);
			patient2.setStatus(patient.getStatus());
			patient2.setMotherHinNo(patient.getMotherHinNo());
			patient2.setServiceCardValidityDate(patient.getServiceCardValidityDate());
			patient2.setDependentCardIssueDate(patient.getDependentCardIssueDate());
			patient2.setServiceCardStatus(patient.getServiceCardStatus());
			patient2.setAddress(patient.getAddress());
			patient2.setRegDate(patient.getRegDate());
			patient2.setRegTime(patient.getRegTime());
			patient2.setSuffix(patient.getSuffix());
			patient2.setPrefix(patient.getPrefix());
			MasServiceStatus serviceStatus=new MasServiceStatus();
			serviceStatus.setId(patient.getServiceStatus().getId());
			patient2.setServiceStatus(serviceStatus);
			patient2.setOldHinNo("");
			patient2.setAge(age);
			patient2.setAb64Available("n");
			patient2.setServiceYears(patient.getServiceYears());
			hbt.save(patient2);
			hbt.refresh(patient2);
			}
			//----------------------------------------------------


			//-------------Creating AND entry for attached patient-----------------
			Inpatient inpatient=new Inpatient();

			inpatient.setHin(patient2);

			MasHospital hospital2=new MasHospital();
			hospital2.setId(hospitalId);
			inpatient.setHospital(hospital2);
			inpatient.setAdNo(andNo);
			try{
			MasDepartment department=new MasDepartment();
			department.setId(box.getInt(DEPARTMENT_ID));
			inpatient.setDepartment(department);
			MasDepartment department2=new MasDepartment();
			department2.setId(box.getInt(DEPARTMENT_ID));
			inpatient.setAdWardId(department2);
			}catch (Exception e) {
				e.printStackTrace();
			}
			inpatient.setAge(age);
		//--This block is for checking vacancy of bed
		//--If bed is not available,then record will not be saved
		if(attachMap.get("bedId") != null){
				bedId = (Integer)attachMap.get("bedId");
		}
		MasBed bed=new MasBed();
		bed.setId(bedId);
		inpatient.setBed(bed);
		MasBed masBed = (MasBed)hbt.load(MasBed.class, bedId);
		MasBedStatus bedStatus = new MasBedStatus();
		bedStatus.setId(bedStatusOccupiedId);
		masBed.setBedStatus(bedStatus);
		hbt.update(masBed);

		inpatient.setDateOfAddmission(lastChgDate);
		inpatient.setTimeOfAddmission(time);
		inpatient.setDietType(box.get(DIET_TYPE));
		MasDiet diet=new MasDiet();
		diet.setId(box.getInt(DIET_ID));
		inpatient.setDiet(diet);
		inpatient.setServiceCardStatus("n");
		inpatient.setMlc("n");
		inpatient.setAdStatus("A");
		inpatient.setStatus("y");
		inpatient.setPatientCondition("Normal");
		inpatient.setConditionStatus("Normal");
		inpatient.setHinNo(newHinNo);
		inpatient.setParentAdNo(parentAdNo);
		inpatient.setAttachedPatient("y");
		inpatient.setInitDiagnosis(""+attachMap.get("atOrDt"));
		if(inpatient2.getRecordOfficeAddress() !=null){
		MasRecordOfficeAddress recordOfficeAddress=new MasRecordOfficeAddress();
		recordOfficeAddress.setId(inpatient2.getRecordOfficeAddress().getId());
		inpatient.setRecordOfficeAddress(recordOfficeAddress);
		}
		if(inpatient2.getDoctor() !=null){
		MasEmployee doctor=new MasEmployee();
		doctor.setId(inpatient2.getDoctor().getId());
		inpatient.setDoctor(doctor);
		try{
		inpatient.setAtOrDt(""+attachMap.get("atOrDt"));
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
		if(attachMap.get("hsrReceiptNo") != null){
			inpatient.setHsrReceiptNo(""+attachMap.get("hsrReceiptNo"));
		}
		if(attachMap.get("hsrAmount") != null){
			inpatient.setHsrAmount(new BigDecimal(""+attachMap.get("hsrAmount")));
		}
		inpatient.setAdNoType("a");
		hbt.save(inpatient);
		hbt.refresh(inpatient);
			//---------------------------------------------------------------------
			attachFlag = "true";
			//transaction.commit();
			}catch (HibernateException e){
				e.printStackTrace();
				session.close();
			}catch (Exception e) {
				transaction.rollback();

		        e.printStackTrace();
		    }
			map.put("adNo", andNo);
			map.put("attachFlag",attachFlag);
			map.put("inpatientList", inpatientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForMLC() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDiet> bodyPartList = new ArrayList<MasDiet>();
		List<MasInjuryNature> injuryNatureList = new ArrayList<MasInjuryNature>();
		List<MasDiagnosisConclusion> diagnosisList = new ArrayList<MasDiagnosisConclusion>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

		Session session = (Session) getSession();

		try{
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			bodyPartList = session.createCriteria(MasBodyPart.class).add(Restrictions.eq("Status", "y")).list();
			injuryNatureList = session.createCriteria(MasInjuryNature.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("InjuryNatureName")).list();
			diagnosisList = session.createCriteria(MasDiagnosisConclusion.class).add(Restrictions.eq("Status", "y")).list();
			departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();

		}catch(HibernateException e){
			e.printStackTrace();
			session.close();
		}
		map.put("employeeList", employeeList);
		map.put("bodyPartList", bodyPartList);
		map.put("injuryNatureList", injuryNatureList);
		map.put("diagnosisList", diagnosisList);
		map.put("departmentList", departmentList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForMLCHAL(Transaction tx, org.hibernate.Session session) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDiet> bodyPartList = new ArrayList<MasDiet>();
		List<MasInjuryNature> injuryNatureList = new ArrayList<MasInjuryNature>();
		List<MasDiagnosisConclusion> diagnosisList = new ArrayList<MasDiagnosisConclusion>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

		

		try{
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			bodyPartList = session.createCriteria(MasBodyPart.class).add(Restrictions.eq("Status", "y")).list();
			injuryNatureList = session.createCriteria(MasInjuryNature.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("InjuryNatureName")).list();
			diagnosisList = session.createCriteria(MasDiagnosisConclusion.class).add(Restrictions.eq("Status", "y")).list();
			departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();

		}catch(HibernateException e){
			e.printStackTrace();
		/*	session.close();*/
		}
		map.put("employeeList", employeeList);
		map.put("bodyPartList", bodyPartList);
		map.put("injuryNatureList", injuryNatureList);
		map.put("diagnosisList", diagnosisList);
		map.put("departmentList", departmentList);
		return map;
	}

	
	@SuppressWarnings({"unchecked","unused"})
	public String generateAdNumberOld(Map<String, Object> adMap) {
		// Instance variable declaration
		int serviceTypeId = 0;
		String adNo = "";
		List<TransactionSequence> adList = new ArrayList<TransactionSequence>();
		List<Inpatient> admissionNoList = new ArrayList<Inpatient>();
		String serviceTypeCode = (String)adMap.get("serviceTypeCode");
		serviceTypeId = Integer.parseInt(""+adMap.get("serviceTypeId"));
		String date = (String)adMap.get("date");
		String lastAdNo = "";
		String lastAdmMonth = "";
		String stCode = "";
		String sNo = "";
		String lastAdmYear = "";
		String currentMonth = "";

		// Calculating the current month in MM format
		currentMonth = date.substring(date.indexOf("/")+1, date.lastIndexOf("/"));
		Session session = (Session) getSession();
		try{

		//Getting Inpatient List excluding manual(Back Date Entry List )
		admissionNoList = session.createCriteria(Inpatient.class).add((Restrictions.ne("AdNoType", "m"))).list();
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		}catch (Exception e) {
			e.printStackTrace();

		}
		//Finding Last auto generated AdNo
		for (Inpatient inpatient : admissionNoList) {
			lastAdNo = inpatient.getAdNo();
		}
		//Calculating the month in Last auto generated AdNo
			StringTokenizer str = new StringTokenizer(lastAdNo,"/");
			while(str.hasMoreTokens()){
				stCode = str.nextToken();
				sNo = str.nextToken();
				lastAdmMonth = str.nextToken();
				lastAdmYear = str.nextToken();

			}
			//Getting the list From TransactionSequence with given serviceTypeId
		try{
			adList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "AD"))
			.add(Restrictions.eq("ServiceType.Id",serviceTypeId))
			.list();
		}catch(HibernateException e){
			e.printStackTrace();
			session.close();
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

			if(adList.size() > 0 ){
			for (TransactionSequence transactionSequence : adList) {
				TransactionSequence obj = (TransactionSequence)adList.get(0);
				int id = obj.getId();
				int seqNo = 0;

				if(currentMonth.equals(lastAdmMonth)){
					seqNo = obj.getTransactionSequenceNumber();
				}else{
					seqNo = 0;
				}

				TransactionSequence transactionSequenceObj = (TransactionSequence)hbt.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(seqNo+1);
				++seqNo;
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				adNo = serviceTypeCode.concat("/");
				adNo = adNo.concat(String.valueOf(seqNo)).concat("/");
				date = date.substring(3, date.length());
				adNo = adNo.concat(date);
			}
		}else if(adList.size() == 0){
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("Inpatient");
			tsObj.setTransactionPrefix("AD");
			tsObj.setTransactionSequenceName("Ad No");
			tsObj.setTransactionSequenceNumber(1);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			adNo = serviceTypeCode.concat("/");
			adNo = adNo.concat(String.valueOf(1)).concat("/");
			date = date.substring(3, date.length());
			adNo = adNo.concat(date);
		}

		return adNo;
	}

	@SuppressWarnings({"unchecked","unused"})
	public String generateMLCNo(Map<String, Object> adMap) {
		List<TransactionSequence> mlcList = new ArrayList<TransactionSequence>();
		String date = (String)adMap.get("date");
		int hospitalId = 0;
		hospitalId = (Integer)adMap.get("hospitalId");
		Session session = (Session) getSession();
		String mlcNo = "";

		try{
			mlcList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "MLC")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		}catch(HibernateException e){
			e.printStackTrace();
			session.close();
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if(mlcList.size() > 0 ){
			for (TransactionSequence transactionSequence : mlcList) {
				TransactionSequence obj = (TransactionSequence)mlcList.get(0);
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = (TransactionSequence)hbt.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
				hbt.update(transactionSequenceObj);

				mlcNo = mlcNo.concat(String.valueOf(seqNo)).concat("/");
				date = date.substring(3, date.length());
				mlcNo = mlcNo.concat(date);
			}
		}else if(mlcList.size() == 0){
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MlcCase");
			tsObj.setTransactionPrefix("MLC");
			tsObj.setTransactionSequenceName("MLC No");
			tsObj.setTransactionSequenceNumber(0);
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			tsObj.setHospital(hospital);
			hbt.save(tsObj);
		}

		return mlcNo;
	}
	
	@SuppressWarnings({"unchecked","unused"})
	public String generateMLCNoHAL(Map<String, Object> adMap, Transaction tx, org.hibernate.Session session) {
		List<TransactionSequence> mlcList = new ArrayList<TransactionSequence>();
		String date = (String)adMap.get("date");
		int hospitalId = 0;
		hospitalId = (Integer)adMap.get("hospitalId");		
		String mlcNo = "";

		try{
			mlcList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "MLC")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		}catch(HibernateException e){
			e.printStackTrace();
		/*	session.close();*/
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if(mlcList.size() > 0 ){
			for (TransactionSequence transactionSequence : mlcList) {
				TransactionSequence obj = (TransactionSequence)mlcList.get(0);
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = (TransactionSequence)hbt.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
				hbt.update(transactionSequenceObj);

				mlcNo = mlcNo.concat(String.valueOf(seqNo)).concat("/");
				date = date.substring(3, date.length());
				mlcNo = mlcNo.concat(date);
			}
		}else if(mlcList.size() == 0){
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MlcCase");
			tsObj.setTransactionPrefix("MLC");
			tsObj.setTransactionSequenceName("MLC No");
			tsObj.setTransactionSequenceNumber(0);
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			tsObj.setHospital(hospital);
			hbt.save(tsObj);
		}

		return mlcNo;
	}

@SuppressWarnings("unchecked")
	public Map<String, Object> getTransferDetails(int hospitalId ) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasBed> bedList = new ArrayList<MasBed>();
		List<Transfer> transferNoList = new ArrayList<Transfer>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();


		Session session = (Session) getSession();

		try {
//			departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			String qry = "select distinct a.department_id, a.department_name,c.department_type_code from mas_department a left join mas_bed b on a.department_id=b.department_id" +
			" left join mas_department_type c on a.department_type_id=c.department_type_id"+
			" where c.department_type_name='Ward' and  b.hospital_id="+hospitalId+"  and a.status='y' order by a.department_name";
			departmentList = session.createSQLQuery(qry).list();
			bedList = session.createCriteria(MasBed.class).add(Restrictions.eq("Status", "y")).list();
			transferNoList = session.createCriteria(Transfer.class).list();
			employeeList = session.createCriteria(MasEmployee.class).createAlias("Hospital", "hospital").add(Restrictions.eq("hospital.Id", hospitalId)).add(Restrictions.eq("Status", "y")).list();



		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		map.put("departmentList", departmentList);
		map.put("bedList", bedList);
		map.put("transferNoList", transferNoList);
		map.put("employeeList", employeeList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForTransfer(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Object> inPatientList = new ArrayList<Object>();
		List<UserEmpGroup> userRights = new ArrayList<UserEmpGroup>();
		Session session = (Session)getSession();

		String serviceNo = "";
		String hinNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonFName = "";
		String serPersonMName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		int inpatientId = 0;
		String adNo = "";
		int wardId = 0;
		Users user = null;

		if(mapForDs.get("serviceNo") != null){
			serviceNo = (String)mapForDs.get("serviceNo");
		}
		if(mapForDs.get("hinNo") != null){
			hinNo = (String)mapForDs.get("hinNo");
		}
		if(mapForDs.get("serviceTypeId") != null){
			serviceTypeId = (Integer)mapForDs.get("serviceTypeId");
		}
		if(mapForDs.get("rankId") != null){
			rankId = (Integer)mapForDs.get("rankId");
		}
		if(mapForDs.get("unitId") != null){
			unitId = (Integer)mapForDs.get("unitId");
		}
		if(mapForDs.get("serPersonFName") != null){
			serPersonFName = (String)mapForDs.get("serPersonFName");
		}
		if(mapForDs.get("serPersonMName") != null){
			serPersonMName = (String)mapForDs.get("serPersonMName");
		}
		if(mapForDs.get("serPersonLName") != null){
			serPersonLName = (String)mapForDs.get("serPersonLName");
		}
		if(mapForDs.get("patientFName") != null){
			patientFName = (String)mapForDs.get("patientFName");
		}
		if(mapForDs.get("patientMName") != null){
			patientMName = (String)mapForDs.get("patientMName");
		}
		if(mapForDs.get("patientLName") != null){
			patientLName = (String)mapForDs.get("patientLName");
		}
		if(mapForDs.get("inpatientId") != null){
			inpatientId = (Integer)mapForDs.get("inpatientId");
		}
		if(mapForDs.get("wardId") != null){
			wardId = (Integer)mapForDs.get("wardId");
		}
		if(mapForDs.get("adNo") != null){
			adNo = (String)mapForDs.get("adNo");
		}
		if(mapForDs.get("user") != null){
			user = (Users) mapForDs.get("user");
		}
		List objectList=new ArrayList();
		objectList.add("A");
		try {
			Criteria crit = session.createCriteria(Inpatient.class).add(Restrictions.in("AdStatus", objectList));
			if(inpatientId == 0){
				if(!adNo.equals("") ){
					crit = crit.add(Restrictions.eq("AdNo", adNo));
				}
				if(adNo.equals("")){
					crit = crit.createAlias("Hin", "hin");
				}
				if(!serviceNo.equals("") ){
					crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo));
				}
				if(!hinNo.equals("")){
					crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
				}
				if(!patientFName.equals("")){
					crit = crit.add(Restrictions.like("hin.PFirstName", patientFName+"%"));
				}
				if(!patientMName.equals("")){
					crit = crit.add(Restrictions.like("hin.PMiddleName", patientMName+"%"));
				}
				if(!patientLName.equals("")){
					crit = crit.add(Restrictions.like("hin.PLastName", patientLName+"%"));
				}
				if(!serPersonFName.equals("")){
					crit = crit.add(Restrictions.like("hin.SFirstName", serPersonFName+"%"));
				}
				if(!serPersonMName.equals("")){
					crit = crit.add(Restrictions.like("hin.SMiddleName", serPersonMName+"%"));
				}
				if(!serPersonLName.equals("")){
					crit = crit.add(Restrictions.like("hin.SLastName", serPersonLName+"%"));
				}
				if(serviceTypeId != 0 ){
					crit = crit.createAlias("hin.ServiceType", "st").add(Restrictions.eq("st.Id", serviceTypeId));
				}
				if(rankId != 0 ){
					crit = crit.createAlias("hin.Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
				}
				if(unitId != 0 ){
					crit = crit.createAlias("hin.Unit", "unit").add(Restrictions.eq("unit.Id", unitId));
				}
				if(wardId != 0){
					crit = crit.createAlias("Department", "dept").add(Restrictions.eq("dept.Id", wardId));
				}
			}else if(inpatientId != 0){
				crit = crit.add(Restrictions.idEq(inpatientId));
				List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
				List<Inpatient> inpatientList = new ArrayList<Inpatient>();
				inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.idEq(inpatientId)).list();
				int hinId = 0;
				hinId = inpatientList.get(0).getHin().getId();
				diagnosisList = session.createCriteria(DischargeIcdCode.class).createAlias("Hin", "h").add(Restrictions.eq("h.Id", hinId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
				List<MasMedicalExaminationDetail> disabilityList = new ArrayList<MasMedicalExaminationDetail>();
				disabilityList = session.createCriteria(MasMedicalExaminationDetail.class).createAlias("MasMedicalReport", "mer")
					.add(Restrictions.eq("mer.Hin.Id", hinId)).add(Restrictions.isNotNull("MasIcd")).addOrder(Order.desc("Serviceid")).setMaxResults(1).list();
				map.put("diagnosisList", diagnosisList);
				map.put("disabilityList", disabilityList);
			}

			inPatientList = crit.list();

			userRights = session.createCriteria(UserEmpGroup.class)
			.add(Restrictions.eq("Status", "y"))
			.add(Restrictions.eq("User.Id", user.getId()))
			.add(Restrictions.eq("EmpGroup.id", 1)).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
		}

		map.put("inpatientList", inPatientList);
		map.put("userRights", userRights);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean submitTransferInformation(Map<String, Object> transferMap) {
		boolean transferedSuccessfully = false;
		System.out.println("transferedSuccessfullytop"+transferedSuccessfully);

		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

		

		Session session = (Session)getSession();
		Transaction tx = session.beginTransaction();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		try {
			System.out.println("transferedSuccessfully"+transferedSuccessfully);
			int bedStatusOccupiedId = Integer.parseInt(properties.getProperty("bedStatusOccupiedId"));
			int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));
			Transfer transfer = (Transfer)transferMap.get("transfer");
			int fromBedId = (Integer)transferMap.get("fromBedId");
			int toBedId = (Integer)transferMap.get("toBedId");
			String adNo = (String)transferMap.get("adNo");
			int toWardId = (Integer)transferMap.get("toWardId");
			int toDoctorId = (Integer)transferMap.get("toDoctorId");
			int hospitalId = (Integer)transferMap.get("hospitalId");
			int adId = 0;

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(transfer);

			inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("AdNo", adNo)).list();
			for (Inpatient inpatient : inpatientList) {
				adId = (Integer)inpatient.getId();
			}
			Inpatient inpatientObj = (Inpatient)hbt.load(Inpatient.class, adId);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(toWardId);
			inpatientObj.setDepartment(masDepartment);
          
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(toDoctorId);
			inpatientObj.setDoctor(masEmployee);
						
			MasBed masBed = new MasBed();
			masBed.setId(toBedId);
			inpatientObj.setBed(masBed);
			System.out.println("transferedSuccessfully"+transferedSuccessfully);
			hbt.update(inpatientObj);

			
			
			
			List<Inpatient> patinetOnSameBed = new ArrayList<Inpatient>();
			patinetOnSameBed = session.createCriteria(Inpatient.class)
			.add(Restrictions.eq("Bed.Id", fromBedId)).list();
			if(patinetOnSameBed.size()==1)
			{
				MasBed fromMasBed = (MasBed)hbt.load(MasBed.class, fromBedId);
				MasBedStatus fromMasBedStatus = new MasBedStatus();
				fromMasBedStatus.setId(bedStatusUnOccupiedId);
				fromMasBed.setBedStatus(fromMasBedStatus);
				hbt.update(fromMasBed);
			}
			
			
			MasBed fromMasBed = (MasBed)hbt.load(MasBed.class, fromBedId);
			MasBedStatus fromMasBedStatus = new MasBedStatus();
			fromMasBedStatus.setId(bedStatusUnOccupiedId);
			fromMasBed.setBedStatus(fromMasBedStatus);
			hbt.update(fromMasBed);
			
			System.out.println("transferedSuccessfully2"+transferedSuccessfully);
			MasBed toMasBed = (MasBed)hbt.load(MasBed.class, toBedId);
			MasBedStatus toMasBedStatus = new MasBedStatus();
			toMasBedStatus.setId(bedStatusOccupiedId);
			toMasBed.setBedStatus(toMasBedStatus);
			hbt.update(toMasBed);
            System.out.println("transferedSuccessfully3"+transferedSuccessfully);
			transferedSuccessfully = true;
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();			
			session.close();
		}
		session.clear();
		return transferedSuccessfully;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDischargeDetails() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDiagnosisConclusion> diagnosisList = new ArrayList<MasDiagnosisConclusion>();
		List<MasDisposedTo> disposedToList = new ArrayList<MasDisposedTo>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		List<MasCareType> careTypeList = new ArrayList<MasCareType>();
		List<Discharge> dischargeNoList = new ArrayList<Discharge>();
		//List<MasIcd> icdNoList = new ArrayList<MasIcd>();
		List<MasDischargeStatus> dischargeStatusList = new ArrayList<MasDischargeStatus>();

		Session session = (Session)getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
			diagnosisList = session.createCriteria(MasDiagnosisConclusion.class).add(Restrictions.eq("Status", "y")).list();
			disposedToList = session.createCriteria(MasDisposedTo.class).add(Restrictions.eq("Status", "y")).list();
			disposalList = session.createCriteria(MasDisposal.class).add(Restrictions.eq("Status", "y")).list();
			careTypeList = session.createCriteria(MasCareType.class).add(Restrictions.eq("Status", "y")).list();
			dischargeStatusList = session.createCriteria(MasDischargeStatus.class).add(Restrictions.eq("Status", "y")).list();
		} catch (DataAccessException e) {
			e.printStackTrace();
			session.close();
		}
		map.put("employeeList", employeeList);
		map.put("diagnosisList", diagnosisList);
		map.put("disposedToList", disposedToList);
		map.put("disposalList", disposalList);
		map.put("careTypeList", careTypeList);
		map.put("dischargeStatusList", dischargeStatusList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitDischargeInformation(Map<String, Object> dischargeMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		boolean dis = true;
		int inpatientId = (Integer)dischargeMap.get("inpatientId");
		Discharge discharge = (Discharge)dischargeMap.get("discharge");
		List<DischargeIcdCode> icdCodeList = new ArrayList<DischargeIcdCode>();
		String addEditTime = "";
		String adNo = "";
		Date addEditDate = null;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, +1);
		Date nextDate = cal.getTime();

		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));
		if(dischargeMap.get("icdCodeList") != null){
			icdCodeList = (List<DischargeIcdCode>)dischargeMap.get("icdCodeList");
		}
		if(dischargeMap.get("adNo") != null && !dischargeMap.get("adNo").equals("")){
			adNo = String.valueOf(""+dischargeMap.get("adNo"));
		}
		String userSrNo = (String)dischargeMap.get("userSrNo");
		Session session=(Session)getSession();
		String[] icdIdArr = null;
			if(dischargeMap.get("icdIdArr") != null){
				icdIdArr = (String[])dischargeMap.get("icdIdArr");
			}
			//Transaction initialization
			Transaction transaction =null;
		try {
			//Transaction Begin
			transaction =session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<Discharge>  DischargeList=new ArrayList<Discharge>();

			DischargeList=getHibernateTemplate().find( "from jkt.hms.masters.business.Discharge d where d.AdNo='"+adNo+"'");
		   if(DischargeList.size() == 0){

			hbt.save(discharge);
			hbt.refresh(discharge);
				int disposed = discharge.getDisposedTo().getId();
				int disStatus = discharge.getDischargeStatus().getId();
			String query ="";
			List objectList=new ArrayList();
			if(icdCodeList.size()>0){

				for(int i=0;i<icdCodeList.size();i++)
				{
					DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
					dischargeIcdCode = (DischargeIcdCode) icdCodeList.get(i);
					MasIcd masIcd = new MasIcd();
					if(icdIdArr[i] !=null)
					if(!icdIdArr[i].equals("0") && !icdIdArr[i].equals("") ){
					query ="select icd_id from mas_icd where icd_code='"+icdIdArr[i]+"'";
					objectList = (List) session.createSQLQuery(query).list();
					masIcd.setId(Integer.parseInt(""+objectList.get(0)));
					dischargeIcdCode.setIcd(masIcd);
					hbt.save(dischargeIcdCode);
					hbt.refresh(dischargeIcdCode);
					}
				}
			}//End of icd Code if
			String serviceNo = "";
			Inpatient inpatient = (Inpatient)hbt.load(Inpatient.class, inpatientId);
				int bedId = inpatient.getBed().getId();
				serviceNo = inpatient.getHin().getServiceNo();
				/*if(disStatus != 3 && disStatus !=15){
			inpatient.setAdStatus("R");
				}else if(disStatus == 3 || disStatus == 15){*/
					inpatient.setAdStatus("D");
					inpatient.setStatus("n");

					Patient patient = (Patient)hbt.load(Patient.class, discharge.getHin().getId());
					if(disStatus == 3){
						patient.setPatientStatus("Expired");
					}else{
						patient.setPatientStatus("Out Patient");
					}
					patient.setInpatientNo(0);
					hbt.update(patient);

					MasBed masBed = (MasBed)hbt.load(MasBed.class, bedId);
					MasBedStatus masBedStatus = new MasBedStatus();
					masBedStatus.setId(bedStatusUnOccupiedId);
					masBed.setBedStatus(masBedStatus);
					hbt.update(masBed);
			
					List<AttachInpatient> attachPatientList = new ArrayList<AttachInpatient>();
					attachPatientList = session.createCriteria(AttachInpatient.class).add(Restrictions.eq("AdNo", adNo)).add(Restrictions.eq("Status", "y")).list();
					if(attachPatientList.size() > 0){
						for (AttachInpatient attachInpatient : attachPatientList) {
							int attachedId = attachInpatient.getId();
							AttachInpatient attInpatient = (AttachInpatient) hbt.load(AttachInpatient.class, attachedId);
							attInpatient.setStatus("n");
//							attInpatient.setDischargeDate(dischargeDate);
//							attInpatient.setDischargeTransfer(dischargeTime);
							hbt.update(attInpatient);

							if(attachInpatient.getBed() != null){
								int attBedId = (Integer)attachInpatient.getBed().getId();
								MasBed masBedObj = (MasBed)hbt.load(MasBed.class, attBedId);
								MasBedStatus masBedStatusObj = new MasBedStatus();
								masBedStatusObj.setId(bedStatusUnOccupiedId);
								masBedObj.setBedStatus(masBedStatusObj);
								hbt.update(masBedObj);
							}
						}

					}

					int dateOfMonth, month, year;
					Calendar calendar = Calendar.getInstance();
					calendar.setTime( nextDate );
					StringBuffer dateOnly = new StringBuffer();
					year = calendar.get(Calendar.YEAR);
					dateOnly.append(year);
					dateOnly.append("/");
					month = calendar.get(Calendar.MONTH) + 1;
					if (month < 10)
						dateOnly.append("0");
					dateOnly.append(month);
					dateOnly.append("/");
					dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
					if (dateOfMonth < 10)
					dateOnly.append("0");
					dateOnly.append( dateOfMonth );
					
				
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
				 Map<String,Object> utilMap = new HashMap<String,Object>();
				 utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				 String date = (String)utilMap.get("currentDate");
				 Date currentDate = new Date();
					String hql="delete from jkt.hms.masters.business.DietDetails as a where (a.DietDate)='"+sdf.format(currentDate)+"' and a.Hin.Id in("+inpatient.getHin().getId()+")";
					Query query1 = session.createQuery(hql);
					int row = query1.executeUpdate();
			//	}
			if(dischargeMap.get("addEditTime") !=null){
				inpatient.setDischargeTime(""+dischargeMap.get("addEditTime"));
			}
			Date dischargeDate = null;
			if(dischargeMap.get("addEditDate") !=null){
				dischargeDate=(Date)dischargeMap.get("addEditDate");
				inpatient.setDischargeDate(dischargeDate);
			}
			hbt.update(inpatient);
			hbt.refresh(inpatient);
			saved = true;

			List<DischargeSummary> dischargeSummaryList = new ArrayList<DischargeSummary>();
			dischargeSummaryList = session.createCriteria(DischargeSummary.class).add(Restrictions.eq("AdNo",inpatient.getAdNo())).list();
			String hospCrs = "";
			if(dischargeSummaryList.size() > 0){
				for(DischargeSummary dischargeSummary : dischargeSummaryList){
					if(dischargeSummary.getLabel().equals("Hosp. Course")){
						hospCrs = dischargeSummary.getItemReply();
					}
				}
			}
			List<DischargeIcdCode> dischargeIcdList = new ArrayList<DischargeIcdCode>();
			dischargeIcdList = session.createCriteria(DischargeIcdCode.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id",inpatient.getId())).list();
			String icds = "";
			String icdNames = "";
			if(dischargeIcdList.size() > 0){
				int i=1;
				for(DischargeIcdCode dischargeIcdCode : dischargeIcdList){
						if(i!=1){
							icds +=" /";
							icdNames +=" /";
						}
						icds = icds.concat(dischargeIcdCode.getIcd().getIcdCode());
						icdNames =icdNames.concat(dischargeIcdCode.getIcd().getIcdName());

					i++;
				}
			}
			
			/**
			 * For Inserting data in HIC Database
			 * @author ritu.sahu
			 * Date: 5 Aug 2011
			 */
			Connection conn = null;
			URL resourcePathHIC = Thread.currentThread().getContextClassLoader().getResource("hicDetails.properties");
			try {
				properties.load(resourcePathHIC.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			String hicDB = properties.getProperty("hicDB");
			String hicUser = properties.getProperty("hicUser");
			String hicPwd = properties.getProperty("hicPwd");
			String hicDbConfigure =  properties.getProperty("hicDbConfigure");
			try{
				if(hicDbConfigure.equals("yes")) {
				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
				conn = DriverManager.getConnection(hicDB, hicUser, hicPwd);
			
				String procSql1 = "{ call SMC_HIC_INSERT_HOSPITALIZATION (" +
					"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				CallableStatement csstmt = conn.prepareCall(procSql1);
				csstmt.setInt(1, inpatient.getId());
				csstmt.setString(2, sdf.format(inpatient.getDateOfAddmission()));
				csstmt.setString(3,sdf.format(discharge.getDateOfDischarge()));				
				csstmt.setString(4, "");		//PURPOSEOFADMISSION		
				csstmt.setString(5,icdNames);				//DISEASE
				csstmt.setString(6,discharge.getDisposal().getDisposalName());				//DISABILITY_AT_DISCHARGE 
				csstmt.setInt(7, Integer.parseInt(userSrNo));
				csstmt.setString(8, icds);	        // ICD No
				csstmt.setString(9, inpatient.getHospital().getHospitalName());	   
				csstmt.setString(10, "");            //hospital category
				csstmt.setString(11, inpatient.getHin().getServiceNo());           
				csstmt.setString(12, inpatient.getHin().getUnit().getUnitName());   
				String doctor = "";
				doctor =discharge.getDoctor().getFirstName();
				if(discharge.getDoctor().getMiddleName()!=null){
					doctor += " "+discharge.getDoctor().getMiddleName();
				}
				if(discharge.getDoctor().getLastName()!=null){
					doctor += " "+discharge.getDoctor().getLastName();
				}
				csstmt.setString(13, doctor);    
				csstmt.setString(14, (discharge.getDoctor().getRank()!= null ? discharge.getDoctor().getRank().getRankName() :"" ));   
				csstmt.setString(15, (discharge.getDoctor().getUnit()!= null ? discharge.getDoctor().getUnit().getUnitName() : ""));           
				csstmt.setString(16, (discharge.getDoctor().getDesignation()!=null ? discharge.getDoctor().getDesignation():""));  
				csstmt.registerOutParameter(17,OracleTypes.CURSOR);
				csstmt.execute();
				csstmt.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			/**
			 * End
			 */
			//Transaction End
			transaction.commit();

		 }else{
			 dis = false;
		 }
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		}catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();

		}
		map.put("saved", saved);
		map.put("dis",dis);
		return map;
	}

	@SuppressWarnings("unchecked")
	public List<MasDepartment> getDepartmentList() {
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session)getSession();
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
		} catch (DataAccessException e) {
			e.printStackTrace();
			session.close();
		}

		return departmentList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDischargePatientList(Map<String, Object> dischargeMap) {

		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		int departmentId = 0;

		if(dischargeMap.get("serviceNo") != null){
			serviceNo = (String)dischargeMap.get("serviceNo");
		}
		if(dischargeMap.get("hin") != null){
			hinNo = (String)dischargeMap.get("hin");
		}
		if(dischargeMap.get("adNo") != null){
			adNo = (String)dischargeMap.get("adNo");
		}
		if(dischargeMap.get("departmentId") != null){
			departmentId = (Integer)dischargeMap.get("departmentId");
		}

		List<Discharge> dischargeList = new ArrayList<Discharge>();
		Map<String, Object> map = new HashMap<String, Object>();
		 Map<String,Object> utilMap = new HashMap<String,Object>();
		 utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		 String date = (String)utilMap.get("currentDate");
		Session session = (Session)getSession();

		try {
			Criteria crit = session.createCriteria(Discharge.class).add(Restrictions.eq("DischargeAdviced", "y"));

			if(!serviceNo.equals("") || !hinNo.equals("")){
				crit = crit.createAlias("Hin", "hin");
			}
			if(!serviceNo.equals("") ){
				crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo));
			}
			if(!hinNo.equals("")){
					crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
			}
			if(!adNo.equals("") ){
					crit = crit.add(Restrictions.eq("AdNo", adNo));
			}
			if(departmentId != 0){
					crit = crit.createAlias("Ward", "dept").add(Restrictions.eq("dept.Id", departmentId));
			}
			        crit = crit.add(Restrictions.le("DateOfDischarge", HMSUtil.convertStringTypeDateToDateType(date)));
			dischargeList = crit.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
		}
		if(dischargeList.size() > 0){
			map.put("dischargeList", dischargeList);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAttachPatientDetails(Map<String, Object> attachPatientMap) {
		Map<String, Object> attachDetailsMap = new HashMap<String, Object>();
		List<Patient> hinList = new ArrayList<Patient>();
		List<Inpatient> existenceAttachedList = new ArrayList<Inpatient>();
		Session session = (Session)getSession();
		int hinId =0;
		hinId=Integer.parseInt(""+attachPatientMap.get("hinId")) ;
		String parentAdNo ="";
		parentAdNo=""+attachPatientMap.get("parentAdNo");
		try{
			hinList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
			existenceAttachedList = session.createCriteria(Inpatient.class).add(Restrictions.eq("ParentAdNo", parentAdNo)).add(Restrictions.eq("AttachedPatient", "y")).list();
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		}catch(Exception e){
			e.printStackTrace();

		}
		attachDetailsMap.put("hinList", hinList);
		attachDetailsMap.put("existenceAttachedList",existenceAttachedList);
		return attachDetailsMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getAttachPatientDetailsHAL(Map<String, Object> attachPatientMap, Transaction tx, org.hibernate.Session session) {
		Map<String, Object> attachDetailsMap = new HashMap<String, Object>();
		List<Patient> hinList = new ArrayList<Patient>();
		List<Inpatient> existenceAttachedList = new ArrayList<Inpatient>();
		
		int hinId =0;
		hinId=Integer.parseInt(""+attachPatientMap.get("hinId")) ;
		String parentAdNo ="";
		parentAdNo=""+attachPatientMap.get("parentAdNo");
		try{
			hinList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
			existenceAttachedList = session.createCriteria(Inpatient.class).add(Restrictions.eq("ParentAdNo", parentAdNo)).add(Restrictions.eq("AttachedPatient", "y")).list();
		}catch (HibernateException e){
			e.printStackTrace();
			/*session.close();*/
		}catch(Exception e){
			e.printStackTrace();

		}
		attachDetailsMap.put("hinList", hinList);
		attachDetailsMap.put("existenceAttachedList",existenceAttachedList);
		return attachDetailsMap;
	}



	@SuppressWarnings("unchecked")
	public Map<String, Object> dischargePatient(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String dischargeSuccessfully = "false";
		int dischargeId = (Integer)detailsMap.get("dischargeId");
		int inpatientId = 0;
		Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTime();
//		Date dischargeDate = HMSUtil.convertStringTypeDateToDateType((String) utilMap.get("currentDate"));
//		String dischargeTime = (String)utilMap.get("currentTimeWithoutSc");
		List<Discharge> dischargeList = new ArrayList<Discharge>();
		Session session = (Session)getSession();
		Transaction tx = null;
		int hinId = 0;
		String adNo = "";
		int dis_status = 0;

		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

		int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));

		try {

			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Discharge discharge = (Discharge)hbt.load(Discharge.class, dischargeId);
//			discharge.setDateOfDischarge(dischargeDate);
//			discharge.setTimeOfDischarge(dischargeTime);
			discharge.setDischargeAdviced("n");
			hbt.update(discharge);

			dischargeList = session.createCriteria(Discharge.class).add(Restrictions.idEq(dischargeId)).list();
			for (Discharge dischargeObj : dischargeList) {
				hinId = dischargeObj.getHin().getId();
				adNo = dischargeObj.getAdNo();
				dis_status = dischargeObj.getDischargeStatus().getId();
			}

			Patient patient = (Patient)hbt.load(Patient.class, hinId);
             if(dis_status == 3){
            	 patient.setPatientStatus("Expired");
			 }else{
			  patient.setPatientStatus("Out Patient");
			 }
			patient.setInpatientNo(0);
			hbt.update(patient);

			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).list();
			if(inpatientList.size() > 0){
				for (Inpatient inpatient : inpatientList) {
					 inpatientId = inpatient.getId();
					 int bedId = inpatient.getBed().getId();
					Inpatient inpatientObj = (Inpatient)hbt.load(Inpatient.class, inpatientId);
					inpatientObj.setAdStatus("S");
					inpatientObj.setStatus("n");
//					inpatientObj.setDischargeDate(dischargeDate);
//					inpatientObj.setDischargeTime(dischargeTime);
					hbt.update(inpatientObj);


					/*MasBed masBed = (MasBed)hbt.load(MasBed.class, bedId);
					MasBedStatus masBedStatus = new MasBedStatus();
					masBedStatus.setId(bedStatusUnOccupiedId);
					masBed.setBedStatus(masBedStatus);
					hbt.update(masBed);*/
				}
			}

			List<AttachInpatient> attachPatientList = new ArrayList<AttachInpatient>();
			attachPatientList = session.createCriteria(AttachInpatient.class).add(Restrictions.eq("AdNo", adNo)).add(Restrictions.eq("Status", "y")).list();
			if(attachPatientList.size() > 0){
				for (AttachInpatient attachInpatient : attachPatientList) {
					int attachedId = attachInpatient.getId();
					AttachInpatient attInpatient = (AttachInpatient) hbt.load(AttachInpatient.class, attachedId);
					attInpatient.setStatus("n");
//					attInpatient.setDischargeDate(dischargeDate);
//					attInpatient.setDischargeTransfer(dischargeTime);
					hbt.update(attInpatient);

					if(attachInpatient.getBed() != null){
						int attBedId = (Integer)attachInpatient.getBed().getId();
						MasBed masBedObj = (MasBed)hbt.load(MasBed.class, attBedId);
						MasBedStatus masBedStatusObj = new MasBedStatus();
						masBedStatusObj.setId(bedStatusUnOccupiedId);
						masBedObj.setBedStatus(masBedStatusObj);
						hbt.update(masBedObj);
					}
				}

			}

			dischargeSuccessfully = "true";
			tx.commit();
		}catch (DataAccessException e) {
			if (tx != null) tx.rollback();
			session.close();
			e.printStackTrace();
		}
		map.put("dischargeSuccessfully", dischargeSuccessfully);
		map.put("inpatientId", inpatientId);
		return map;
	}


	@SuppressWarnings("unchecked")
	public Map<String, Object> showExpiryDetails(Map<String, Object> patientDetailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String  adNo  = ""+patientDetailsMap.get("adNo");
		String search = ""+patientDetailsMap.get("search");
		int hinId =0;
		int inpatientId = 0;
		boolean  status = false;
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<MasDeathCause> deathCauseList = new ArrayList<MasDeathCause>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasBlock> blockList = new ArrayList<MasBlock>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<Discharge> dischargeList = new ArrayList<Discharge>();
		List<ExpiryDetails> expDetailsList = new ArrayList<ExpiryDetails>();
		Session session = (Session)getSession();

		try {
			inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).list();
			dischargeList = session.createCriteria(Discharge.class).add(Restrictions.eq("AdNo", adNo)).list();
			if(inpatientList.size() > 0){
				for(Inpatient inpatient :inpatientList){
					hinId =Integer.parseInt(""+inpatient.getHin().getId());
					inpatientId =Integer.parseInt(""+inpatient.getId());
				}
			}
			patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
			deathCauseList = session.createCriteria(MasDeathCause.class).add(Restrictions.eq("Status", "y")).list();
			countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
			stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status", "y")).list();
			districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).list();
			blockList = session.createCriteria(MasBlock.class).add(Restrictions.eq("Status", "y")).list();
			relationList = session.createCriteria(MasRelation.class).add(Restrictions.eq("Status", "y")).list();
			expDetailsList = session.createCriteria(ExpiryDetails.class).add(Restrictions.eq("Inpatient.Id", inpatientId)).list();

			if(dischargeList != null && dischargeList.size() >0){
				Discharge dis = (Discharge) dischargeList.get(0);

				if(dis.getDischargeStatus() != null ){
					if(dis.getDischargeStatus().getId() == 3 && dis.getDisposal().getId()==8 && dis.getDisposedTo().getId()==16){
						status = true;
					}
				}
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
			session.close();
		}
		map.put("patientList", patientList);
		map.put("inpatientList", inpatientList);
		map.put("deathCauseList", deathCauseList);
		map.put("countryList", countryList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("blockList", blockList);
		map.put("relationList", relationList);
		map.put("dischargeList", dischargeList);
		map.put("expDetailsList", expDetailsList);
		map.put("status", status);

		return map;
	}

	public boolean submitExpiryDetails(Map<String, Object> expiryDetilsMap) {
		boolean saved = false;
		ExpiryDetails expiryDetails = (ExpiryDetails)expiryDetilsMap.get("expiryDetails");
		int hinId = (Integer)expiryDetilsMap.get("hinId");
		try {

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(expiryDetails);

			Patient patient = (Patient)hbt.load(Patient.class, hinId);
			patient.setPatientStatus("Expired");
			hbt.update(patient);

			saved = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return saved;
	}
	public boolean updateExpiryDetails(Map<String, Object> expiryDetilsMap) {
		boolean saved = false;
		ExpiryDetails expiryDetails = (ExpiryDetails)expiryDetilsMap.get("expiryDetails");
		int hinId = (Integer)expiryDetilsMap.get("hinId");
		try {

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(expiryDetails);


			saved = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return saved;
	}

	@SuppressWarnings("deprecation")
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		map.put("conn",con);
		return map;
	}

	@SuppressWarnings("unchecked")
	public List getAdmissionNoList(Map<String, Object> detailsMap) {
		String serviceNo = "";
		String hinNo = "";
		if(detailsMap.get("serviceNo") != null){
			serviceNo = (String)detailsMap.get("serviceNo");
		}
		if(detailsMap.get("hinNo") != null){
			hinNo = (String)detailsMap.get("hinNo");
		}
		List<Object> inpatientList = new ArrayList<Object>();
		Session session = (Session)getSession();
		try {
			if(!serviceNo.equals("")){
				//inpatientList = getHibernateTemplate().find("from Inpatient ip join ip.Hin as p where p.ServiceNo = '"+serviceNo+"'");
				Query ipQry = session.createQuery("from Inpatient ip join ip.Hin as p where p.ServiceNo =:srNo");
				ipQry.setParameter("srNo",serviceNo);
				inpatientList = ipQry.list();
			}
			if(!hinNo.equals("")){
				inpatientList = getHibernateTemplate().find("from Inpatient ip join ip.Hin as p where p.HinNo = '"+hinNo+"'");
				Query ipQry = session.createQuery("from Inpatient ip join ip.Hin as p where p.HinNo =:hinNo");
				ipQry.setString("hinNo",hinNo);
				inpatientList = ipQry.list();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return inpatientList;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getHinNoList(String serviceNo) {
		Session session = (Session)getSession();
		List<Object> patientList = new ArrayList<Object>();

		try {
			patientList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		return patientList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getServiceTypeDepartmentCategory() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).list();
			serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).list();
			rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		map.put("departmentList", departmentList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("rankCategoryList", rankCategoryList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getVisitDates(String hinNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitDateList = new ArrayList<Visit>();
		Session session = (Session)getSession();
		try {
			visitDateList = session.createCriteria(Visit.class).createAlias("Hin", "patient").add(Restrictions.eq("patient.HinNo", hinNo)).addOrder(Order.asc("VisitDate")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("visitDateList", visitDateList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDiagnosis(Date visitDate) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*List<Visit> diagnosisList = new ArrayList<Visit>();*/
		List<OpdPatientDetails> diagnosisList = new ArrayList<OpdPatientDetails>();
		Session session = (Session)getSession();
		try {
//			diagnosisList = session.createCriteria(Visit.class).add(Restrictions.eq("VisitDate", visitDate)).list();
			diagnosisList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").add(Restrictions.eq("v.VisitDate", visitDate)).addOrder(Order.asc("id")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("diagnosisList", diagnosisList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientAdmissionDetailsForUpdate(String adNo) {
			Map<String, Object> map = new HashMap<String, Object>();

			Session session = (Session)getSession();
			List<Inpatient> admissionDetailsList = new ArrayList<Inpatient>();
			List<InpatientDocument> inpatientDocumentList = new ArrayList<InpatientDocument>();
			try {
				if(!adNo.equals("")){
					admissionDetailsList = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).list();
					inpatientDocumentList = session.createCriteria(InpatientDocument.class).list();
				}
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.close();
			}
			map.put("admissionDetailsList", admissionDetailsList);
			map.put("inpatientDocumentList", inpatientDocumentList);
			return map;
	}

	public boolean updateAdmissionInformation(Map<String, Object> parameterMap) {
		int inpatientId = 0;
		int hinId = 0;
		int departmentId = 0;
		boolean updatedSuccessfully = false;
		String[] documentIdArray = null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		if(parameterMap.get("inpatientId") != null){
			inpatientId = (Integer)parameterMap.get("inpatientId");
		}
		if(parameterMap.get("hinId") != null){
			hinId = (Integer)parameterMap.get("hinId");
		}
		if(parameterMap.get("departmentId") != null){
			departmentId = (Integer)parameterMap.get("departmentId");
		}



		try {

			if(parameterMap.get("documentIdArray") != null){
				documentIdArray = (String[])parameterMap.get("documentIdArray");
			}

			Inpatient inpatient = (Inpatient)hbt.load(Inpatient.class, inpatientId);
			Patient patient = (Patient)hbt.load(Patient.class, hinId);
			if(documentIdArray !=null)
			if(documentIdArray.length>0){
				try{
				 String hql="delete from jkt.hms.masters.business.InpatientDocument as a where a.Inpatient.Id='"+inpatientId+"'";
					Query query = session.createQuery(hql);
					int row = query.executeUpdate();
			}catch (HibernateException e){
				e.printStackTrace();
				session.close();
			}catch (Exception e) {
				e.printStackTrace();

			}
				for (int i = 0; i < documentIdArray.length; i++) {

					if(!documentIdArray[i].equals("0") ){
					InpatientDocument document=new InpatientDocument();
					MasDocument masDocument=new MasDocument();
					masDocument.setId(Integer.parseInt(""+documentIdArray[i]));
					document.setDocument(masDocument);
					document.setInpatient(inpatient);
					hbt.save(document);
					}
				}
			}
			if(parameterMap.get("hsrAmount") != null){
				BigDecimal hsrAmount = new BigDecimal(""+parameterMap.get("hsrAmount")) ;
				inpatient.setHsrAmount(hsrAmount);
			}
			if(parameterMap.get("hsrReceiptNo") != null){
				String hsrReceiptNo = (""+parameterMap.get("hsrReceiptNo")) ;
				inpatient.setHsrReceiptNo(hsrReceiptNo);
			}
			if(parameterMap.get("consultingDoctorId") != null){
				int consultingDoctorId = (Integer)parameterMap.get("consultingDoctorId");
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(consultingDoctorId);
				inpatient.setDoctor(masEmployee);
			}

			if(parameterMap.get("caseTypeId") != null){
				int caseTypeId = (Integer)parameterMap.get("caseTypeId");
				MasCaseType caseType = new MasCaseType();
				caseType.setId(caseTypeId);
				inpatient.setCaseType(caseType);
			}
			if(parameterMap.get("admissionTypeId") != null){
				int admissionTypeId = (Integer)parameterMap.get("admissionTypeId");
				MasAdmissionType admissionType = new MasAdmissionType();
				admissionType.setId(admissionTypeId);
				inpatient.setAdmissionType(admissionType);
			}
			if(parameterMap.get("diagnosisId") != null){
				int diagnosisId = (Integer)parameterMap.get("diagnosisId");
				MasIcd masIcd = new MasIcd();
				masIcd.setId(diagnosisId);
				inpatient.setDiagnosis(masIcd);
			}
			if(parameterMap.get("dietId") != null){
				int dietId = (Integer)parameterMap.get("dietId");
				MasDiet diet = new MasDiet();
				diet.setId(dietId);
				inpatient.setDiet(diet);
			}
			if(parameterMap.get("documentId") != null){
				int documentId = (Integer)parameterMap.get("documentId");
				MasDocument masDocument = new MasDocument();
				masDocument.setId(documentId);
				inpatient.setDocument(masDocument);
			}
			if(parameterMap.get("recordOfficeAddressId") != null){
				int recordOfficeAddressId = (Integer)parameterMap.get("recordOfficeAddressId");
				MasRecordOfficeAddress masRecordOfficeAddress = new MasRecordOfficeAddress();
				masRecordOfficeAddress.setId(recordOfficeAddressId);
				inpatient.setRecordOfficeAddress(masRecordOfficeAddress);
			}
			if(parameterMap.get("dietType") != null){
				String dietType = (String)parameterMap.get("dietType");
				inpatient.setDietType(dietType);
			}


			if(parameterMap.get("nextOfKinName") != null){

                String relativeName =
(String)parameterMap.get("nextOfKinName");

                patient.setNextOfKinName(relativeName);

          }

          if(parameterMap.get("nextOfKinAddress") != null){

                String nextOfKinAddress =
(String)parameterMap.get("nextOfKinAddress");

                patient.setNextOfKinAddress(nextOfKinAddress);

          }

          if(parameterMap.get("nextOfKinPhoneNo") != null){

                String nokPhone =
(String)parameterMap.get("nextOfKinPhoneNo");

                patient.setNextOfKinPhoneNumber(nokPhone);

          }

          if(parameterMap.get("nextOfKinRelationId") != null){

                int nokRelationId =
(Integer)parameterMap.get("nextOfKinRelationId");

                MasRelation masRelationObj = new MasRelation();

                masRelationObj.setId(nokRelationId);

                patient.setNextOfKinRelation(masRelationObj);

          }


			if(parameterMap.get("userId") != null){
				int userId = (Integer)parameterMap.get("userId");
				Users users = new Users();
				users.setId(userId);
				inpatient.setAddEditBy(users);
			}
			Date addEditDate = null;
			if(parameterMap.get("addEditDate") != null){
				addEditDate = (Date)parameterMap.get("addEditDate") ;
				inpatient.setAddEditDate(addEditDate);
			}
			String addEditTime = "";
			if(parameterMap.get("addEditTime") != null){
				addEditTime = (String)parameterMap.get("addEditTime") ;
				inpatient.setAddEditTime(addEditTime);
			}

			if(departmentId != 0){
				inpatient.setAdWardId(new MasDepartment(departmentId));
				inpatient.setDepartment(new MasDepartment(departmentId));
			}

			hbt.update(inpatient);
			hbt.update(patient);
			updatedSuccessfully = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return updatedSuccessfully;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getMLCNo(String hinNo) {
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = (Session)getSession();
		List<MlcCase> mlcNoList = new ArrayList<MlcCase>();

		try {
			mlcNoList = session.createCriteria(MlcCase.class).createAlias("Hin", "p").add(Restrictions.eq("p.HinNo", hinNo)).list();
			map.put("mlcNoList", mlcNoList);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForSearch(int hospitalId) {
		Map<String , Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = null;
		List<MasServiceType> serviceTypeList = null;
		List<Object[]> unitList = null;
		List<MasDepartment> wardList = null;
		List<MasTrade> masTradeList = null;
		List<MasStation> stationList = null;
		List<MasSection> sectionList = null;
		List<MasCommand> commandList = null;
		List<MasRelation> relationList = null;
		List<MasAdministrativeSex> sexList = null;
		List<Object[]> departmentList = null;
		List<MasEmployee> employeeList = null;
		List<MasDiet> dietList = null;
		Session session = (Session)getSession();

		try {
			rankList=session.createQuery("select rank from MasRank as rank where rank.Status='y'  order by rank.RankName " ).list();
			serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y"))
						.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(Order.asc("UnitName")).list();
			wardList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y")).createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.DepartmentTypeName", "Ward")).addOrder(Order.asc("DepartmentName")).list();
			
			masTradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("TradeName")).list();
			stationList = session.createCriteria(MasStation.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("StationName")).list();
			sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("SectionName")).list();
			commandList = session.createCriteria(MasCommand.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("CommandName")).list();
			relationList = session.createCriteria(MasRelation.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("RelationName")).list();
			sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
			String qry = "select distinct a.department_id, a.department_name from mas_department a left join mas_bed b on a.department_id=b.department_id" +
			" left join mas_department_type c on a.department_type_id=c.department_type_id"+
			" where c.department_type_name='Ward' and  b.hospital_id="+hospitalId+" and a.status='y' order by a.department_name";
			departmentList = session.createSQLQuery(qry).list();	
	
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Hospital", "h")
							.add(Restrictions.eq("h.Id", hospitalId)).createAlias("EmpCategory", "ec")
							.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor)).addOrder(Order.asc("FirstName")).list();
			dietList = session.createCriteria(MasDiet.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DietName")).list();
			map.put("rankList", rankList);
			map.put("dietList", dietList);
			map.put("serviceTypeList", serviceTypeList);
			map.put("unitList", unitList);
			map.put("wardList", wardList);
			map.put("masTradeList", masTradeList);
			map.put("stationList", stationList);
			map.put("sectionList", sectionList);
			map.put("commandList", commandList);
			map.put("relationList", relationList);
			map.put("sexList", sexList);
			map.put("departmentList", departmentList);
			map.put("employeeList", employeeList);
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForDischarge(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inPatientTempList = new ArrayList<Inpatient>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		List<DischargeSummary> dischargeSummaryList = new ArrayList<DischargeSummary>();
		List<UserEmpGroup> userRights = new ArrayList<UserEmpGroup>();
		Session session = (Session)getSession();
		String hinNo = "";
		int inpatientId = 0;
		String adNo = "";
		int wardId = 0;
		String serviceNo = "";
		Users user = null;
		int hospitalId = 0;
		if(mapForDs.get("hospitalId") != null){
			hospitalId = (Integer)mapForDs.get("hospitalId");
		}
		if(mapForDs.get("serviceNo") != null){
			serviceNo = (String)mapForDs.get("serviceNo");
		}
		if(mapForDs.get("hinNo") != null){
			hinNo = (String)mapForDs.get("hinNo");
		}
		if(mapForDs.get("inpatientId") != null){
			inpatientId = (Integer)mapForDs.get("inpatientId");
		}
		if(mapForDs.get("wardId") != null){
			wardId = (Integer)mapForDs.get("wardId");
		}
		if(mapForDs.get("adNo") != null){
			adNo = (String)mapForDs.get("adNo");
		}
		if(mapForDs.get("user") != null){
			user = (Users) mapForDs.get("user");
		}

		List objectList=new ArrayList();
		objectList.add("A");
		try {
			Criteria crit = session.createCriteria(Inpatient.class).add(Restrictions.in("AdStatus", objectList)).createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId));
			crit = crit.createAlias("Hin", "hinP");
			if(inpatientId == 0){
				if(!adNo.equals("") ){
					crit = crit.add(Restrictions.eq("AdNo", adNo));
				}
				if(adNo.equals("")){
					crit = crit.add(Restrictions.eq("hinP.PatientStatus", "In Patient"));
				}
				if(!serviceNo.equals("") ){
					crit = crit.add(Restrictions.eq("hinP.ServiceNo", serviceNo));
				}
				if(!hinNo.equals("")){
					crit = crit.add(Restrictions.eq("hinP.HinNo", hinNo));
				}
				if(wardId != 0){
					crit = crit.createAlias("Department", "dept").add(Restrictions.eq("dept.Id", wardId));
				}
			}else if(inpatientId != 0){
				crit = crit.add(Restrictions.idEq(inpatientId));
			}

//			inPatientTempList = crit.list();
			inPatientList=crit.list();

//This part is commented because of new requirement That is patient will discharged without discharge Summary

			for (Inpatient inpatient : inPatientTempList) {
				String admNo = inpatient.getAdNo();
				dischargeSummaryList = session.createCriteria(DischargeSummary.class).add(Restrictions.eq("AdNo", admNo)).list();
			}

			userRights = session.createCriteria(UserEmpGroup.class)
			                          .add(Restrictions.eq("Status", "y"))
			                          .add(Restrictions.eq("User.Id", user.getId()))
			                          .add(Restrictions.eq("EmpGroup.id", 1)).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
		}


    	map.put("dischargeSummaryList", dischargeSummaryList);
//		map.put("inpatientTempList", inPatientTempList);
		map.put("inpatientList", inPatientList);
		map.put("userRights", userRights);
		return map;
	}
	///////////////////
	@SuppressWarnings("unchecked")
	public Map<String, Object> getUserRights(Users userObj) {
		Map<String, Object> map1 = new HashMap<String, Object>();
		List<UserEmpGroup> userRights = new ArrayList<UserEmpGroup>();
		Session session = (Session)getSession();
		Users user = null;
		if(userObj != null){
			user = userObj;
		}
		try {
			userRights = session.createCriteria(UserEmpGroup.class)
			                          .add(Restrictions.eq("Status", "y"))
			                          .add(Restrictions.eq("User.Id", user.getId()))
			                          .add(Restrictions.eq("EmpGroup.id", 1)).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
		}
	 	map1.put("userRights", userRights);
		return map1;
	}
	////////////////////




	@SuppressWarnings("unchecked")
	public int getHospitalStaffSLNo() {
		int hospStaffSeqNo = 0;
		List<TransactionSequence> hospStaffSeqNoList = new ArrayList<TransactionSequence>();

		Session session = (Session) getSession();
		try{
			hospStaffSeqNoList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "HS")).list();
		}catch(HibernateException e){
			e.printStackTrace();
			session.close();
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);

		if(hospStaffSeqNoList.size() > 0 ){
			for (TransactionSequence transactionSequence : hospStaffSeqNoList) {
				int id = transactionSequence.getId();
				int seqNo = transactionSequence.getTransactionSequenceNumber();
				TransactionSequence transactionSequenceObj = (TransactionSequence)hbt.load(TransactionSequence.class, id);
				hospStaffSeqNo = ++seqNo;
				transactionSequenceObj.setTransactionSequenceNumber(hospStaffSeqNo);
				hbt.update(transactionSequenceObj);
			}
		}else if(hospStaffSeqNoList.size() == 0){
			hospStaffSeqNo = 1;
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("Inpatient");
			tsObj.setTransactionPrefix("HS");
			tsObj.setTransactionSequenceName("Hospital Staff SL. No");
			tsObj.setTransactionSequenceNumber(hospStaffSeqNo);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");

			hbt.save(tsObj);

		}

		return hospStaffSeqNo;
	}

	public boolean saveAdditionalInfoForDischarge(Map<String, Object> parameterMap) {

		String movementCode = "";
		String warrantNo = "";
		String shr = "";
		String remarks = "";
		int dischargeId = 0;
		boolean flag= false;

		if(parameterMap.get("movementCode") != null){
			movementCode = (String)parameterMap.get("movementCode");
		}
		if(parameterMap.get("warrantNo") != null){
			warrantNo = (String)parameterMap.get("warrantNo");
		}
		if(parameterMap.get("shr") != null){
			shr = (String)parameterMap.get("shr");
		}
		if(parameterMap.get("remarks") != null){
			remarks = (String)parameterMap.get("remarks");
		}
		if(parameterMap.get("dischargeId") != null){
			dischargeId = (Integer)parameterMap.get("dischargeId");
		}

			try {
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

				Discharge discharge = (Discharge)hbt.load(Discharge.class, dischargeId);
				discharge.setMovementCode(movementCode);
				discharge.setWarrantNo(warrantNo);
				discharge.setShr(shr);
				discharge.setRemarks(remarks);
				hbt.update(discharge);
				flag = true;
			} catch (DataAccessException e) {
				e.printStackTrace();
			}

		return flag;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDiagnosis(String adNo, int inpatientId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DischargeIcdCode> dischargeIcdList = new ArrayList<DischargeIcdCode>();

		Session session = (Session)getSession();
		try {
			if(inpatientId == 0){
				if(!adNo.equals("")){
					dischargeIcdList = session.createCriteria(DischargeIcdCode.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.AdNo", adNo)).list();
				}
			}else if(inpatientId != 0){
				dischargeIcdList = session.createCriteria(DischargeIcdCode.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", inpatientId)).list();
			}

			if(dischargeIcdList.size() > 0){
				map.put("dischargeIcdList", dischargeIcdList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}

		return map;
	}

	public boolean cancelAdmissionInformation(Map<String, Object> parameterMap) {

		Map<String, Object> patientMap = new HashMap<String, Object>();
		boolean admissionFlag = false;
		String nextOfKinAddress = "";
		String nextOfKinName = "";
		String nextOfKinPhoneNo = "";
		int nextOfKinRelationId = 0;
		String patientStatus ="";
		int bloodGroupId = 0;
		int hinId = 0;
		int bedId = 0;
		String ab64 = "";
		String parentAdNo ="";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Session session = (Session)getSession();
	    Transaction tx = null;

		int inpatientId =0;
		if(parameterMap.get("inpatientId") != null){
			inpatientId = (Integer)parameterMap.get("inpatientId");
		}
		if(parameterMap.get("parentAdNo") != null){
			parentAdNo= ""+parameterMap.get("parentAdNo");
		}
		Box box=null;
		box=(Box) parameterMap.get("box");

		int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<Inpatient>  inpatientList=new ArrayList<Inpatient>();
		inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Id",inpatientId)).list();
		int patientId =0;
		for(Inpatient inpatient :inpatientList){
			patientId =inpatient.getHin().getId();
		}
		try {
			tx = session.beginTransaction();
			//-----Parent admission cancilation----------------
			Inpatient inpatient = (Inpatient)hbt.load(Inpatient.class, inpatientId);
			inpatient.setStatus("n");
			inpatient.setAdStatus("C");
			hbt.update(inpatient);
			if(parameterMap.get("bedId") != null){
				bedId = (Integer)parameterMap.get("bedId");
				MasBed masBed = (MasBed)hbt.load(MasBed.class, bedId);
				MasBedStatus bedStatus = new MasBedStatus();
				bedStatus.setId(bedStatusUnOccupiedId);
				masBed.setBedStatus(bedStatus);
				hbt.update(masBed);
			}
			//----------------------------------------
//			//----Attached patients cancilation----------------------------
//			if(attachedList.size() > 0)
//			for(Inpatient attachedInpatient :attachedList){
//				Inpatient attachedInpatientObj = (Inpatient)hbt.load(Inpatient.class, attachedInpatient.getId());
//				attachedInpatientObj.setStatus("n");
//				attachedInpatientObj.setAdStatus("C");
//				hbt.update(attachedInpatientObj);
//
//					bedId = (Integer)attachedInpatient.getBed().getId();
//					MasBed masBed = (MasBed)hbt.load(MasBed.class, bedId);
//					MasBedStatus bedStatus = new MasBedStatus();
//					bedStatus.setId(bedStatusUnOccupiedId);
//					masBed.setBedStatus(bedStatus);
//					hbt.update(masBed);
//
//				}
			//----------------------------------------------------------
			if(patientId !=0){
			Patient patient = (Patient)hbt.load(Patient.class, patientId);
			patient.setPatientStatus("Out Patient");
			hbt.update(patient);
			}
			admissionFlag = true;
			tx.commit();
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			 if (tx != null) tx.rollback();
		        e.printStackTrace();

		}
		return admissionFlag;

	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public Map<String, Object> getSiDiData(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String adNo="";
		String initDiagnosis ="";
		if(dataMap.get("adNo") !=null){
			adNo=""+dataMap.get("adNo");
		}
		Session session = (Session)getSession();
		Connection connection = session.connection();
		Connection con = connection;
		map.put("conn",con);

		List<SilDilStatus>  siDiList=new ArrayList<SilDilStatus>();
		List<Inpatient>  list=new ArrayList<Inpatient>();
		int inpatientId =0;

		try{
			list =(List<Inpatient>) session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).list();
			String time = null;
			Date date =new Date();
			for(Inpatient inpatient : list){
				inpatientId =inpatient.getId();
				initDiagnosis =inpatient.getInitDiagnosis();
				try{
					time = inpatient.getListTime();

					date = inpatient.getListDate();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(date !=null || time != null){
				/*siDiList =(List<SilDilStatus>) session.createCriteria(SilDilStatus.class)
				.add(Restrictions.eq("Inpatient.Id", inpatientId))
				.add(Restrictions.eq("LastChgDate", date))
				.add(Restrictions.eq("LastChgTime", time))
				.list();*/
				siDiList =(List<SilDilStatus>) session.createCriteria(SilDilStatus.class)
				.add(Restrictions.eq("Inpatient.Id", inpatientId))
				.addOrder(Order.asc("Id"))
				.list();
			}else{
				siDiList =(List<SilDilStatus>) session.createCriteria(SilDilStatus.class)
				.add(Restrictions.eq("Inpatient.Id", inpatientId))
				.addOrder(Order.asc("Id"))
				.list();
			}
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		}catch (Exception e) {
			e.printStackTrace();

		}
		String placed_by ="";
		String Placed_on = "";
		String si_di = "";
		String si_di_date = "";
		String si_di_time = "";
		String diagnosis = "";
		String nok_status = "";
		String si_di_previous ="";
		String placedOrTakenOffBy ="";
		int silDilId =0;
		if(siDiList.size() > 0){
			for(SilDilStatus dilStatus :siDiList){

				placed_by=""+dilStatus.getPlacedBy().getFirstName()+dilStatus.getPlacedBy().getLastName();
				if(dilStatus.getConditionStatus().equalsIgnoreCase("sil") || dilStatus.getConditionStatus().equalsIgnoreCase("dil")){
					Placed_on="Placed on :";
					placedOrTakenOffBy="Placed by:";
				}else {
					Placed_on="Taken of:";
					placedOrTakenOffBy="Taken of by:";
				}
				si_di=""+dilStatus.getConditionStatus();
				if(si_di.equals("Normal")){
					si_di=si_di_previous;
				}

				si_di_previous=""+dilStatus.getConditionStatus();
				si_di_date=""+dilStatus.getLastChgDate();
				si_di_time=""+dilStatus.getLastChgTime();
				if(dilStatus.getIcd() != null){
				diagnosis=dilStatus.getIcd().getIcdSubCategory().getIcdSubCategoryName()+dilStatus.getIcd().getIcdName();
				}
				nok_status=""+dilStatus.getNok();
				silDilId=dilStatus.getId();

			}

		}else{

		}
		if(diagnosis.equals("")){
			diagnosis = initDiagnosis;
		}
	
		map.put("placed_by",placed_by);
		map.put("Placed_on",Placed_on);
		map.put("si_di",si_di);
		map.put("si_di_date",si_di_date);
		map.put("si_di_time",si_di_time);
		map.put("diagnosis",diagnosis);
		map.put("nok_status",nok_status);
		map.put("placedOrTakenOffBy",placedOrTakenOffBy);
		return map;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public Map<String, Object> getDiagnosisAndDocInit(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> adList =new ArrayList<Inpatient>();
		List<DischargeIcdCode> diagList =new ArrayList<DischargeIcdCode>();
		List<InpatientDocument> docList =new ArrayList<InpatientDocument>();
		List<Inpatient> inpatientList =new ArrayList<Inpatient>();
		@SuppressWarnings("unused")
		int inpatientId = 0;
		Session session = (Session)getSession();
		@SuppressWarnings("unused")
		String adNo = "";
		String docString ="";
		String diagnosisString ="";
		if(dataMap.get("adNo") !=null){
			adNo = "" + dataMap.get("adNo");
		}
		try{
			adList =(List<Inpatient>) session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).list();
		for(Inpatient inpatient : adList){
			inpatientId =inpatient.getId();
		}
		inpatientList =(List<Inpatient>) session.createCriteria(Inpatient.class).add(Restrictions.eq("Id", inpatientId)).list();
		diagList =(List<DischargeIcdCode>) session.createCriteria(DischargeIcdCode.class).add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
		docList = (List<InpatientDocument>) session.createCriteria(InpatientDocument.class).add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
		for(DischargeIcdCode dischargeIcdCode :diagList){
			diagnosisString =""+diagnosisString+dischargeIcdCode.getIcd().getIcdSubCategory().getIcdSubCategoryName()+" : "+dischargeIcdCode.getIcd().getIcdName()+",";
		}
		for(InpatientDocument inpatientDocument : docList){
			docString = ""+docString+inpatientDocument.getDocument().getDocumentName()+",";
		}
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		}catch (Exception e) {
			e.printStackTrace();

		}
		Connection connection = session.connection();
		Connection con = connection;
		map.put("conn",con);
		map.put("docString", docString);
		map.put("diagnosisString", diagnosisString);
		map.put("inpatientList", inpatientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> chechBed(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		int wardId =0;
		if(dataMap.get("wardId") !=null){
			wardId =Integer.parseInt(""+dataMap.get("wardId"));
		}
		int fromBedId =0;
		if(dataMap.get("fromBedId") !=null){
			fromBedId =Integer.parseInt(""+dataMap.get("fromBedId"));
		}
		int hospitalId = 0;
		if(dataMap.get("hospitalId") !=null){
			hospitalId =Integer.parseInt(""+dataMap.get("hospitalId"));
		}
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));
		Session session = (Session)getSession();
		List<MasBed> bedList =new ArrayList<MasBed>();
		bedList =(List<MasBed>) session.createCriteria(MasBed.class).createAlias("Hospital", "h").add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Department.Id",wardId))
		.add(Restrictions.eq("BedStatus.Id", bedStatusUnOccupiedId)).add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("Id"))
		.list();
		MasBed fromMB = (MasBed)session.get(MasBed.class, fromBedId);
		if(fromMB !=null)
		{
			bedList.add(fromMB);
		}
		
		map.put("bedList", bedList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> checkAdNoDuplication(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		try{

		String adNo ="";
		int hinId =0;

		if(dataMap.get("hinId") !=null){
			hinId =Integer.parseInt(""+dataMap.get("hinId")) ;
		}
		if(dataMap.get("adNo") !=null){
			adNo =""+dataMap.get("adNo");
		}
		List<Inpatient> inpatientList =new ArrayList<Inpatient>();
		inpatientList =(List<Inpatient>) session.createCriteria(Inpatient.class)
		.add((Restrictions.eq("Hin.Id",hinId)))
		.add(Restrictions.eq("AdStatus", "A"))
		.list();
		map.put("inpatientList", inpatientList);
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		}catch (Exception e) {
			e.printStackTrace();

		}

		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> checkAdNoDuplicationHAL(Map<String, Object> dataMap, Transaction tx, org.hibernate.Session session) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{

		String adNo ="";
		int hinId =0;

		if(dataMap.get("hinId") !=null){
			hinId =Integer.parseInt(""+dataMap.get("hinId")) ;
		}
		if(dataMap.get("adNo") !=null){
			adNo =""+dataMap.get("adNo");
		}
		List<Inpatient> inpatientList =new ArrayList<Inpatient>();
		inpatientList =(List<Inpatient>) session.createCriteria(Inpatient.class)
		.add((Restrictions.eq("Hin.Id",hinId)))
		.add(Restrictions.or(Restrictions.or(Restrictions.eq("AdStatus", "A"), Restrictions.eq("AdStatus", "W")),Restrictions.eq("AdStatus", "R")))
		.list();
		map.put("inpatientList", inpatientList);
		}catch (Exception e) {
			e.printStackTrace();

		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> checkForDuplicateOfAdnoInAttach(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		@SuppressWarnings("unused")
		List<Patient> patientList =new ArrayList<Patient>();
		List<Inpatient> ipList =new ArrayList<Inpatient>();
		String serviceNo ="";
		@SuppressWarnings("unused")
		int relationId =0;
		int serviceTypeId =0;
		@SuppressWarnings("unused")
		int hinId = 0;
		Session session=(Session)getSession();
		List objectList=new ArrayList();
		if(dataMap.get("serviceNo") !=null){
			serviceNo = ""+dataMap.get("serviceNo");
		}
		if(dataMap.get("relationId") != null){
			relationId =Integer.parseInt(""+dataMap.get("relationId")) ;
		}
		if(dataMap.get("serviceTypeId") !=null){
			serviceTypeId = Integer.parseInt(""+dataMap.get("serviceTypeId"));
		}
		String qry ="select p.relation_id,concat(p.p_first_name,' ',p.p_middle_name,' ',p.p_last_name),concat(p.s_first_name,' ',p.s_middle_name,' ',p.s_last_name),rank.rank_name,relation.relation_name from inpatient as ip,patient as p,mas_rank as rank,mas_relation as relation where p.hin_id = ip.hin_id and  p.rank_id = rank.rank_id and p.service_no ='"+serviceNo+"' and p.service_type_id = '"+serviceTypeId+"' and  ip.ad_status in ('A','W') and relation.relation_id=p.relation_id ;";
		try {
			objectList = (List) session.createSQLQuery(qry).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
		}
		map.put("objectList", objectList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getIcdWithIcdCode(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasIcd> masIcdList =new ArrayList<MasIcd>();
		String icdCode ="";
		Session session=(Session)getSession();
		if(dataMap.get("icdCode") !=null){
			icdCode = dataMap.get("icdCode").toString().trim();
		}
		try {
			masIcdList=(List<MasIcd>) session.createCriteria(MasIcd.class)
			.add(Restrictions.eq("Status", "y"))
			.add(Restrictions.eq("IcdCode", icdCode)).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
		}
		map.put("masIcdList", masIcdList);
	return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDischargeDetails(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo ="";
		Session session=(Session)getSession();
		if(dataMap.get("serviceNo") !=null){
			serviceNo = ""+dataMap.get("serviceNo");
		}
		List objectList=new ArrayList();
		String qry ="select inpatient_id,ad_no from inpatient ip,patient p where p.hin_id = ip.hin_id and ip.ad_status in ('D','R','S') and  p.service_no ='"+serviceNo+"'";
		try {
			objectList = (List) session.createSQLQuery(qry).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
		}
		map.put("objectList", objectList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsOfDischarge(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inpatientList =new ArrayList<Inpatient>();
		@SuppressWarnings("unused")
		List<Discharge> dischargeList =new ArrayList<Discharge>();
		List<DischargeIcdCode> dischargeIcdCodeList =new ArrayList<DischargeIcdCode>();
		int inpatientId =0;
		String admissionNo ="";
		Session session=(Session)getSession();
		if(dataMap.get("inpatientId") !=null){
			inpatientId =Integer.parseInt(""+dataMap.get("inpatientId")) ;
		}
		if(dataMap.get("admissionNo") !=null){
			admissionNo=(""+dataMap.get("admissionNo")) ;
		}
		try {
			inpatientList=session.createCriteria(Inpatient.class).add(Restrictions.eq("Id", inpatientId)).list();
			dischargeList=session.createCriteria(Discharge.class).add(Restrictions.eq("AdNo", admissionNo)).list();
			dischargeIcdCodeList=session.createCriteria(DischargeIcdCode.class).add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
		}
		map.put("inpatientList",inpatientList);
		map.put("dischargeList", dischargeList);
		map.put("dischargeIcdCodeList",dischargeIcdCodeList);
		return map;
	}

	public Map<String, Object> updateDischarge(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session=(Session)getSession();
		Box box =null;
		if(dataMap.get("box") !=null){
			box=(Box) dataMap.get("box");
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String[] diagnosidIdArray = null;
		String saved="n";
		String dischargeDate ="";
		String dischargeTime ="";
		int dischargeId =0;
		int inpatientId =0;
		int hinId =0;
		int userId =0;
		int dId =0;
		int dischargeNo =0;
		String deleteDiagnosis ="";
		if(dataMap.get("deleteDiagnosis") !=null)
		deleteDiagnosis =""+dataMap.get("deleteDiagnosis");

		List objectList2=new ArrayList();
		String qry ="SELECT max(discharge_no) FROM discharge d";
		objectList2 = (List) session.createSQLQuery(qry).list();
		if(objectList2.get(0) !=null){
			dischargeNo =1+Integer.parseInt(""+objectList2.get(0));
		}

		if(dataMap.get("userId")!= null){
			userId=Integer.parseInt(""+dataMap.get("userId")) ;
			}

		if(dataMap.get("dId")!= null){
			dId=Integer.parseInt(""+dataMap.get("dId")) ;
			}
			if(dataMap.get("hinId")!= null){
			hinId=Integer.parseInt(""+dataMap.get("hinId")) ;
			}
	
		if(dataMap.get("diagnosidIdArray")!= null){
			diagnosidIdArray=(String[]) dataMap.get("diagnosidIdArray");
			}
		if(dataMap.get("dischargeDate")!= null){
			dischargeDate=(String) dataMap.get("dischargeDate");
			}
		if(dataMap.get("dischargeTime")!= null){
			dischargeTime=(String) dataMap.get("dischargeTime");
			}
		if(dataMap.get("dischargeId")!= null){
			dischargeId=Integer.parseInt(""+dataMap.get("dischargeId"));
			}
		if(dataMap.get("inpatientId")!= null){
			inpatientId=Integer.parseInt(""+dataMap.get("inpatientId"));
			}

		String query ="";
		 List objectList=new ArrayList();
			int multiIcdId =0;
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentTime = (String)utilMap.get("currentTimeWithoutSc");
			String date = (String)utilMap.get("currentDate");
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			 SimpleDateFormat formatterOut = new  SimpleDateFormat("yyyy-MM-dd");
			 String date4MySQL2 =null;
			 String date4MySQLDis =null;
			try {
				date4MySQL2 = formatterOut.format(formatterIn.parse(dischargeDate));
				date4MySQLDis = formatterOut.format(formatterIn.parse(dischargeDate));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


			SimpleDateFormat formatterIn2 = new SimpleDateFormat("dd/MM/yyyy");
			 SimpleDateFormat formatterOut2 = new  SimpleDateFormat("yyyy-MM-dd");
			 String curDate =null;
			try {
				curDate = formatterOut.format(formatterIn.parse(date));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		String icdCode ="";
		try{
			if(deleteDiagnosis.equals("yes")){
				String hql2="delete from jkt.hms.masters.business.DischargeIcdCode as dic where dic.Inpatient.Id='"+inpatientId+"' and dic.DiagnosisStatus='f'";
				Query query2 = session.createQuery(hql2);
				@SuppressWarnings("unused")
				int row2 = query2.executeUpdate();
			}
			if(dId ==0){
				Discharge discharge=new Discharge();
				if(dataMap.get("discharge")!= null){
					discharge=(Discharge) dataMap.get("discharge");
					}
				discharge.setDateOfDischarge(java.sql.Date.valueOf(date4MySQL2));
				discharge.setTimeOfDischarge(dischargeTime);
				discharge.setAddEditDate(java.sql.Date.valueOf(curDate));
				discharge.setAddEditTime(currentTime);
				Users userObject2 = new Users();
				userObject2.setId(userId);
				discharge.setAddEditBy(userObject2);
				discharge.setDischargeNo(dischargeNo);
				hbt.save(discharge);
			}else{
				//Update Discharge,  dischargeDate and dischargeTime
				Discharge discharge = (Discharge)hbt.load(Discharge.class, dischargeId);
					discharge.setDateOfDischarge(java.sql.Date.valueOf(date4MySQL2));
					discharge.setTimeOfDischarge(dischargeTime);
					if(box.get(DOCTOR_NAME) != null){
						discharge.setDoctor(new MasEmployee(Integer.parseInt(""+box.get(DOCTOR_NAME))));
					}
					if(box.get(DISPOSAL_ID) != null){
						discharge.setDisposal(new MasDisposal(Integer.parseInt(""+box.get(DISPOSAL_ID))));
					}
					if(box.get(DISPOSED_TO_ID) != null){
						discharge.setDisposedTo(new MasDisposedTo(Integer.parseInt(""+box.get(DISPOSED_TO_ID))));
					}
					if(box.get(CARE_TYPE_ID) != null && !box.get(CARE_TYPE_ID).equals("") && !box.get(CARE_TYPE_ID).equals("0")){
						discharge.setCareType(new MasCareType(Integer.parseInt(""+box.get(CARE_TYPE_ID))));
					}
					if(box.get(INJURY_REPORT_INITIATED_ON) != null && !box.get(INJURY_REPORT_INITIATED_ON).equals("")){
						SimpleDateFormat formatterIn5 = new SimpleDateFormat("dd/MM/yyyy");
						 SimpleDateFormat formatterOut5 = new  SimpleDateFormat("yyyy-MM-dd");
						 String date4MySQL =null;
						try {
							date4MySQL = formatterOut5.format(formatterIn5.parse(box.get(INJURY_REPORT_INITIATED_ON)));
							 discharge.setInjuryReportInitiatedOn(java.sql.Date.valueOf(date4MySQL));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}


					}
					if(box.get("injury_report_init_at") != null && !box.get("injury_report_init_at").equals("")){
						discharge.setInjuryReportInitAt(""+box.get("injury_report_init_at"));
					}
					if(box.get(BOARD_HELD_ON) != null && !box.get(BOARD_HELD_ON).equals("")){
						SimpleDateFormat formatterIn6 = new SimpleDateFormat("dd/MM/yyyy");
						 SimpleDateFormat formatterOut6 = new  SimpleDateFormat("yyyy-MM-dd");
						 String date4MySQL6 =null;
						try {
							date4MySQL2 = formatterOut6.format(formatterIn6.parse(box.get(BOARD_HELD_ON)));
							 discharge.setBoardHeldOn(java.sql.Date.valueOf(date4MySQL2));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}


					}
					if(box.get(FOLLOW_UP) != null && !box.get(FOLLOW_UP).equals("")){
						SimpleDateFormat formatterIn3 = new SimpleDateFormat("dd/MM/yyyy");
						 SimpleDateFormat formatterOut3 = new  SimpleDateFormat("yyyy-MM-dd");
						 String date4MySQL3 =null;
						try {
							date4MySQL3 = formatterOut3.format(formatterIn3.parse(box.get(FOLLOW_UP)));
							 discharge.setFollowUpDate(java.sql.Date.valueOf(date4MySQL3));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}


					}
					if(box.get(DISCHARGE_IN_MEDICAL_CATEGORY) != null && !box.get(DISCHARGE_IN_MEDICAL_CATEGORY).equals("")){
						discharge.setDischargeInMedicalCategory(""+box.get(DISCHARGE_IN_MEDICAL_CATEGORY));
					}
					if(box.get(DISCHARGE_STATUS_ID) != null && !box.get(DISCHARGE_STATUS_ID).equals("")){
						discharge.setDischargeStatus(new MasDischargeStatus(Integer.parseInt(""+box.get(DISCHARGE_STATUS_ID))));
					}
					if(box.get(CARE_SUMMARY) != null){
						discharge.setCareSummary(""+box.get(CARE_SUMMARY));
					}
					if(box.get(INSTRUCTIONS) != null){
						discharge.setInstructionsToPatient(""+box.get(INSTRUCTIONS));
					}
					if(box.get("document_initiated") != null){
						discharge.setDocumentInitiated(""+box.get("document_initiated"));
					}
					if(box.get("workingDiagnosis") != null){
						discharge.setWorkingDiagnosis(""+box.get("workingDiagnosis"));
					}
					if(box.get(DISCHARGE_DATE) != null && !box.get(DISCHARGE_DATE).equals("")){
						SimpleDateFormat formatterIn4 = new SimpleDateFormat("dd/MM/yyyy");
						 SimpleDateFormat formatterOut4 = new  SimpleDateFormat("yyyy-MM-dd");
						 String date4MySQL4 =null;
						try {
							date4MySQL4 = formatterOut4.format(formatterIn4.parse(box.get(DISCHARGE_DATE)));
							 discharge.setDateOfDischarge(java.sql.Date.valueOf(date4MySQL4));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}


					}
					if(box.get(DISCHARGE_TIME) != null){
						discharge.setTimeOfDischarge(""+box.get(DISCHARGE_TIME));
					}
					discharge.setAddEditDate(java.sql.Date.valueOf(curDate));
					discharge.setAddEditTime(currentTime);
					Users userObject2 = new Users();
					userObject2.setId(userId);
					discharge.setAddEditBy(userObject2);
				hbt.update(discharge);
			}
			//Update Inpatient ListDate and listTime
			Inpatient inpatient = (Inpatient)hbt.load(Inpatient.class,inpatientId);
				inpatient.setListDate(java.sql.Date.valueOf(date4MySQL2));
				inpatient.setListTime(dischargeTime);
				inpatient.setDischargeDate(java.sql.Date.valueOf(date4MySQLDis));
				inpatient.setDischargeTime(dischargeTime);
				inpatient.setAddEditDate(java.sql.Date.valueOf(curDate));
				inpatient.setAddEditTime(currentTime);
				Users userObject3 = new Users();
				userObject3.setId(userId);
				inpatient.setAddEditBy(userObject3);
			hbt.update(inpatient);



			//Storing diagnosis in DichargeIcdCode
		if(diagnosidIdArray !=null ){
			for(int i = 0 ; i<diagnosidIdArray.length; i++){
				 if(diagnosidIdArray[i].equals("") || diagnosidIdArray[i].equals("0")){
					   continue;
				   }
					   int index1=diagnosidIdArray[i].lastIndexOf("[");
					   int index2=diagnosidIdArray[i].lastIndexOf("]");
					   index1++;
					   icdCode=""+diagnosidIdArray[i].substring(index1, index2);
				query ="select icd_id from mas_icd where icd_code='"+icdCode+"'";
				objectList = (List) session.createSQLQuery(query).list();
				multiIcdId=(Integer.parseInt(""+objectList.get(0)));
				DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
					if(hinId !=0){
					Patient patient = new Patient();
					patient.setId(hinId);
					dischargeIcdCode.setHin(patient);
					}
					Inpatient inpatient2 = new Inpatient();
					inpatient2.setId(inpatientId);
					dischargeIcdCode.setInpatient(inpatient2);
					dischargeIcdCode.setDiagnosisStatus("f");
					if(userId !=0){
					Users userObject = new Users();
					userObject.setId(userId);
					dischargeIcdCode.setAddEditBy(userObject);
					}
					dischargeIcdCode.setAddEditDate(java.sql.Date.valueOf(curDate));
					dischargeIcdCode.setAddEditTime(currentTime);
					dischargeIcdCode.setStatus("y");
					dischargeIcdCode.setIcd(new MasIcd(multiIcdId));
					dischargeIcdCode.setZ03("n");
					if(diagnosidIdArray[i].contains("{OLD}")){
						dischargeIcdCode.setZ09("y");
					}else{
						dischargeIcdCode.setZ09("n");
					}


					hbt.save(dischargeIcdCode);
			}



	}
		saved="y";
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		}catch (Exception e) {
		e.printStackTrace();

		}
		map.put("saved",saved);
		return map;
	}


	public Map<String, Object> getICDDetails(Box box)
	{
		List<MasIcd> masIcdList  = new ArrayList<MasIcd>();
		Map<String ,Object> map= new HashMap<String, Object>();
		Session session = (Session)getSession();
		try
		{
			String str = box.get("icd_name");
			if (str!=null && str.length()>0)
			{
			str = str.replace(" ", "%")+ "%";
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			//masIcdList = session.createCriteria(MasIcd.class).add(Restrictions.like("IcdName", str)).list();
			String query =	"select icd from MasIcd as icd , MasIcdSubCategory as sub where sub.Id =icd.IcdSubCategory.Id and upper(concat(sub.IcdSubCategoryName,':',icd.IcdName)) like  upper('"+str+"')";
			Query q=session.createQuery(query);
	  		masIcdList=q.list();
			}
			map.put("masIcdList", masIcdList);
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			session.close();
		}
		return map;
	}

	public Map<String, Object> searchExpiryDetails(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inPatientTempList = new ArrayList<Inpatient>();
		List<Discharge> dischargeList = new ArrayList<Discharge>();
		List<DischargeSummary> dischargeSummaryList = new ArrayList<DischargeSummary>();
		Session session = (Session)getSession();
		String hinNo = "";
		int inpatientId = 0;
		String adNo = "";
		int wardId = 0;
		String serviceNo = "";

		if(dataMap.get("serviceNo") != null){
			serviceNo = (String)dataMap.get("serviceNo");
		}
		if(dataMap.get("hinNo") != null){
			hinNo = (String)dataMap.get("hinNo");
		}
		if(dataMap.get("inpatientId") != null){
			inpatientId = (Integer)dataMap.get("inpatientId");
		}
		if(dataMap.get("wardId") != null){
			wardId = (Integer)dataMap.get("wardId");
		}
		if(dataMap.get("adNo") != null){
			adNo = (String)dataMap.get("adNo");
		}
		List objectList=new ArrayList();
		String qry ="SELECT hin_id FROM expiry_details";
		Criteria crit =null;

		try {
			objectList = (List) session.createSQLQuery(qry).list();
			if(objectList.size() >0){
			 crit = session.createCriteria(Discharge.class).add(Restrictions.eq("DischargeStatus.Id", 3)).add(Restrictions.not(Restrictions.in("Hin.Id", objectList)));
			}else{
				 crit = session.createCriteria(Discharge.class).add(Restrictions.eq("DischargeStatus.Id", 3));
			}
				if(!adNo.equals("") ){
					crit = crit.add(Restrictions.eq("AdNo", adNo));
				}
				if(!serviceNo.equals("") ){
					crit = crit.createAlias("Hin", "hin");
					crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo));
				}
				if(!hinNo.equals("")){
					crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
				}
				if(wardId != 0){
					crit = crit.createAlias("Ward", "dept").add(Restrictions.eq("dept.Id", wardId));
				}

			dischargeList=crit.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
		}
		map.put("dischargeList", dischargeList);
		return map;

	}

	@SuppressWarnings("deprecation")
	public Map<String, Object> printExpiryDetails(Map<String, Object> dataMap) {
		@SuppressWarnings("unused")
		int inpatientId =0;
		String placed_on ="";
		if(dataMap.get("inpatientId") !=null){
			inpatientId =Integer.parseInt(""+dataMap.get("inpatientId")) ;
		}
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		inPatientList=(List<Inpatient>)session.createCriteria(Inpatient.class).add(Restrictions.eq("Id", inpatientId)).list() ;
		if(inPatientList.size() > 0){
			for(Inpatient inpatient :inPatientList){
				if(!inpatient.getConditionStatus().equals("Normal")){
					placed_on = inpatient.getConditionStatus()+" ";
					try{
					 SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
					 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
					 String date4MySQL=formatterOut.format(formatterIn.parse(""+inpatient.getListDate()));
					 placed_on=placed_on+" "+date4MySQL+" ";
					}catch (Exception e) {
						e.printStackTrace();
					}
					 placed_on =placed_on+inpatient.getListTime();
				}
			}
		}

		Connection con = session.connection();
		map.put("conn",con);
		map.put("placed_on",placed_on);
		return map;
	}

	public Map<String, Object> searchPatientDischarge(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();

		List<Object> inPatientList = new ArrayList<Object>();
		Session session = (Session)getSession();

		String serviceNo = "";
		String hinNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonFName = "";
		String serPersonMName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		int inpatientId = 0;
		String adNo = "";
		int wardId = 0;

		if(dataMap.get("serviceNo") != null){
			serviceNo = (String)dataMap.get("serviceNo");
		}
		if(dataMap.get("hinNo") != null){
			hinNo = (String)dataMap.get("hinNo");
		}
		if(dataMap.get("serviceTypeId") != null){
			serviceTypeId = (Integer)dataMap.get("serviceTypeId");
		}
		if(dataMap.get("rankId") != null){
			rankId = (Integer)dataMap.get("rankId");
		}
		if(dataMap.get("unitId") != null){
			unitId = (Integer)dataMap.get("unitId");
		}
		if(dataMap.get("serPersonFName") != null){
			serPersonFName = (String)dataMap.get("serPersonFName");
		}
		if(dataMap.get("serPersonMName") != null){
			serPersonMName = (String)dataMap.get("serPersonMName");
		}
		if(dataMap.get("serPersonLName") != null){
			serPersonLName = (String)dataMap.get("serPersonLName");
		}
		if(dataMap.get("patientFName") != null){
			patientFName = (String)dataMap.get("patientFName");
		}
		if(dataMap.get("patientMName") != null){
			patientMName = (String)dataMap.get("patientMName");
		}
		if(dataMap.get("patientLName") != null){
			patientLName = (String)dataMap.get("patientLName");
		}
		if(dataMap.get("inpatientId") != null){
			inpatientId = (Integer)dataMap.get("inpatientId");
		}
		if(dataMap.get("wardId") != null){
			wardId = (Integer)dataMap.get("wardId");
		}
		if(dataMap.get("adNo") != null){
			adNo = (String)dataMap.get("adNo");
		}
		List objectList=new ArrayList();
		objectList.add("D");
		objectList.add("R");
		objectList.add("S");
		Criteria crit=null;
		try {
			crit = session.createCriteria(Inpatient.class).add(Restrictions.in("AdStatus", objectList));
			if(inpatientId == 0){
				if(!adNo.equals("") ){
					crit = crit.add(Restrictions.eq("AdNo", adNo));
				}
				if(adNo.equals("")){
					crit = crit.createAlias("Hin", "hin");
				}
				if(!serviceNo.equals("") ){
					crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo));
				}
				if(!hinNo.equals("")){
					crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
				}
				if(!patientFName.equals("")){
					crit = crit.add(Restrictions.like("hin.PFirstName", patientFName+"%"));
				}
				if(!patientMName.equals("")){
					crit = crit.add(Restrictions.like("hin.PMiddleName", patientMName+"%"));
				}
				if(!patientLName.equals("")){
					crit = crit.add(Restrictions.like("hin.PLastName", patientLName+"%"));
				}
				if(!serPersonFName.equals("")){
					crit = crit.add(Restrictions.like("hin.SFirstName", serPersonFName+"%"));
				}
				if(!serPersonMName.equals("")){
					crit = crit.add(Restrictions.like("hin.SMiddleName", serPersonMName+"%"));
				}
				if(!serPersonLName.equals("")){
					crit = crit.add(Restrictions.like("hin.SLastName", serPersonLName+"%"));
				}
				if(serviceTypeId != 0 ){
					crit = crit.createAlias("hin.ServiceType", "st").add(Restrictions.eq("st.Id", serviceTypeId));
				}
				if(rankId != 0 ){
					crit = crit.createAlias("hin.Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
				}
				if(unitId != 0 ){
					crit = crit.createAlias("hin.Unit", "unit").add(Restrictions.eq("unit.Id", unitId));
				}
				if(wardId != 0){
					crit = crit.createAlias("Department", "dept").add(Restrictions.eq("dept.Id", wardId));
				}
			}else if(inpatientId != 0){
				crit = crit.add(Restrictions.idEq(inpatientId));
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.close();
		}

		inPatientList = crit.list();
		map.put("inpatientList", inPatientList);
		return map;

	}
	@SuppressWarnings("unused")
	public Map<String, Object> checkCancelAdmissionState(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		int inpatientId =0;
		String cancelState ="no";
		if(dataMap.get("inpatientId") !=null){
			inpatientId =Integer.parseInt(""+dataMap.get("inpatientId")) ;
		}
		Session session=getSession();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		List objectList=new ArrayList();
		String qry ="select date_of_addmission,DATE_ADD(inpatient.`date_of_addmission`,INTERVAL '1'DAY) from inpatient where inpatient_id ='"+inpatientId+"';";
		try {
			objectList = (List) session.createSQLQuery(qry).list();
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			session.close();
		}

		//Current Date and Time
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String currentTime = (String)utilMap.get("currentTimeWithoutSc");
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		 SimpleDateFormat formatterOut = new  SimpleDateFormat("yyyy-MM-dd");
		 String date4Cancel ="";
		 try {
			 date4Cancel=formatterOut.format(formatterIn.parse(currentDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int mm=0;
		int hh=0;
		int ss=0;
		StringTokenizer str = new StringTokenizer(currentTime,":");
		while(str.hasMoreTokens()){
			 hh =Integer.parseInt(""+str.nextToken()) ;
			 mm =Integer.parseInt(""+str.nextToken()) ;
			 ss =Integer.parseInt(""+str.nextToken()) ;
			}
		String currAdDate ="";
		String  nextAdDate ="";
		if(objectList.size()>0){
			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
				currAdDate = ""+object[0];
				nextAdDate =""+object[1];
			}
		}
	if(date4Cancel.equals(currAdDate)){
		cancelState="yes";
	}else if(date4Cancel.equals(nextAdDate)){
		if(hh<2){
			cancelState="yes";
		}

	}
	map.put("cancelState", cancelState);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> checkOffLineAdNoDuplicationFor(Map<String, Object> dataMap) {
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session)getSession();
			try{

			String adNo ="";

			if(dataMap.get("adNo") !=null){
				adNo =""+dataMap.get("adNo");
			}
			List<Inpatient> inpatientList =new ArrayList<Inpatient>();
			inpatientList =(List<Inpatient>) session.createCriteria(Inpatient.class)
			.add((Restrictions.eq("AdNo",adNo)))
			.list();
			map.put("inpatientList", inpatientList);
			}catch (HibernateException e){
				e.printStackTrace();
				session.close();
			}catch (Exception e) {
				e.printStackTrace();

			}
			return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> cancelDischarge(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		List<DietDetails> dietDetailList = new ArrayList<DietDetails>();
		List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
		List<MasDietCombination> dietCombinationList = new ArrayList<MasDietCombination>();
		Session session = (Session)getSession();
		@SuppressWarnings("unused")
		int inpatientId =0;
		String saved ="no";
		String adNo ="";
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, +1);
		Date nextDate = cal.getTime();
		if(dataMap.get("inpatientId") !=null){
			inpatientId=Integer.parseInt(""+dataMap.get("inpatientId")) ;
		}

		Transaction tx = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			//--------------Transaction Started----------
			tx = session.beginTransaction();
			List objectList=new ArrayList();
			objectList.add("R");
			objectList.add("S");
			inPatientList=session.createCriteria(Inpatient.class)
			.add(Restrictions.eq("Id", inpatientId))
			.add(Restrictions.in("AdStatus", objectList)).list();
			dietTypeList = session.createCriteria(MasDietType.class).add(Restrictions.eq("Status", "y")).list();
			dietCombinationList = session.createCriteria(MasDietCombination.class).add(Restrictions.eq("Status", "y")).list();
			if(inPatientList.size() >0){
				for(Inpatient inpatient :inPatientList){
					adNo =""+inpatient.getAdNo();
				dietDetailList = session.createCriteria(DietDetails.class)
				 .add(Restrictions.eq("Inpatient.Id", inpatientId))
				 .add(Restrictions.eq("DietDate", nextDate)).list();

				if(dietDetailList.size() == 0){
		/////////////// Inserting new patient diet details////////////////
					DietDetails dietDetailsObj = new DietDetails();
					dietDetailsObj.setDiet(inpatient.getDiet());
					String category = inpatient.getHin().getRank().getRankCategory().getRankCategoryName();
					String dietCategory = "";
					String patientCategory = "";
					if(category.equalsIgnoreCase("Officer")) {
						dietCategory = "Officer";
					}else {
						dietCategory = "Other";
					}
					String relation =  inpatient.getHin().getRelation().getRelationName();
					if(category.equalsIgnoreCase("Officer")) {
						patientCategory = "Officer";
					}else if(category.equalsIgnoreCase("Officer Family")) {
						patientCategory = "Officer Family";
					}else if(!category.equalsIgnoreCase("Officer") && !category.equalsIgnoreCase("Officer Family") && relation.equalsIgnoreCase("Self")) {
						patientCategory = "Others";
					}else if(!category.equalsIgnoreCase("Officer") && !category.equalsIgnoreCase("Officer Family") && !relation.equalsIgnoreCase("Self")) {
						patientCategory = "Others Family";
					}

					dietDetailsObj.setDepartment(inpatient.getDepartment());
					dietDetailsObj.setDietCategory(dietCategory);
					dietDetailsObj.setPatientCategory(patientCategory);
					dietDetailsObj.setDietDate(nextDate);
					dietDetailsObj.setHin(inpatient.getHin());
					dietDetailsObj.setHospital(inpatient.getHospital());
					dietDetailsObj.setInpatient(inpatient);
					dietDetailsObj.setStatus("y");
					dietDetailsObj.setPatientCondition("B");
					int dietTypeId = 0;
					for (MasDietType masDietType : dietTypeList) {
						if(inpatient.getDietType().equalsIgnoreCase(masDietType.getDietTypeName())) {
							dietTypeId = masDietType.getId();
							dietDetailsObj.setDietType(masDietType);
						}
					}

					for(MasDietCombination dietCombination : dietCombinationList) {
						if(inpatient.getDiet().getId() == dietCombination.getDiet().getId() && dietTypeId == dietCombination.getDietType().getId() && dietCombination.getDemandDisplay().equals("n")) {
							dietDetailsObj.setDietCombination(dietCombination);
						}
					}
					try {
						hbt.save(dietDetailsObj);
					} catch (RuntimeException e) {
						e.printStackTrace();
					}
                  ////////////// End Patient Diet Details/////////////////

				}
				}
				@SuppressWarnings("unused")
				Inpatient inpatient=(Inpatient)getHibernateTemplate().load(Inpatient.class,inpatientId);
				inpatient.setAdStatus("A");
				inpatient.setDischargeDate(null);
				inpatient.setDischargeTime(null);

				String hql="delete from jkt.hms.masters.business.Discharge as a where a.AdNo='"+adNo+"'";
				Query query = session.createQuery(hql);
				@SuppressWarnings("unused")
				int row = query.executeUpdate();

				String hql2="delete from jkt.hms.masters.business.DischargeIcdCode as dic where dic.Inpatient.Id='"+inpatientId+"' and dic.DiagnosisStatus='f'";
				Query query2 = session.createQuery(hql2);
				@SuppressWarnings("unused")
				int row2 = query2.executeUpdate();

				hbt.update(inpatient);
				saved="yes";
			}
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();

		}
		map.put("saved",saved);
		return map;
	}

	@SuppressWarnings("unchecked")
	public String generateTransactionSequence(Map<String, Object> map, org.hibernate.Session session) throws Exception{
		// Instance variable declaration
		int serviceTypeId = 0;
		String seqNumber = "1";
		List<TransactionSequence> transactionSequenceList = new ArrayList<TransactionSequence>();
		TransactionSequence tansSeqObj = new TransactionSequence();
		List<MasStoreFinancial> finacialList = new ArrayList<MasStoreFinancial>();
		/*String serviceTypeCode = (String)adMap.get("serviceTypeCode");*/
		/*serviceTypeId = Integer.parseInt(""+adMap.get("serviceTypeId"));*/
		/*Date date = new Date();
		String year = String.valueOf(date.getYear());
		int month = date.getMonth();*/
		Calendar date = Calendar.getInstance();
		System.out.println("Date"+date);
		String year = String.valueOf(date.get(Calendar.YEAR));
		int month =(date.get(Calendar.MONTH) + 1);
		System.out.println("year"+year);
		System.out.println("month"+month);
		
		/*currentMonth =Integer.parseInt(""+date.substring(date.indexOf("/")+1, date.lastIndexOf("/"))) ;*/
		Integer hospitalId = null;
		String tableObjectName = (String)map.get("tableObjectName");
		String isMonthly = (String)(map.get("isMonthly"));
		String isYearly = (String)map.get("isYearly");
		String isHospitalWise =(String)map.get("isHospitalWise");
		String isPrefix = (String)map.get("isPrefix");
		String transactionPrefix = "";
		
		/*String transactionPrefix = (String)map.get("transactionPrefix");
		String transactionSequenceName = (String)map.get("transactionSequenceName");*/
		int lastAdmMonth = 0;
		int currentMonth = 0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		
		try{
			
			/*transactionSequenceList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "AD")).add(Restrictions.eq("ServiceType.Id",serviceTypeId)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();*/
			finacialList = session.createCriteria(MasStoreFinancial.class)
					        .add(Restrictions.eq("Status", "y").ignoreCase())
					        .add(Restrictions.like("FinancialYear", year+"%").ignoreCase()).list();
			Criteria cr = session.createCriteria(TransactionSequence.class)
					     .add(Restrictions.eq("Tablename", tableObjectName));
			tansSeqObj.setTablename(tableObjectName);
			
			if(isHospitalWise!=null && isHospitalWise.trim().equalsIgnoreCase("y"))
			{
				System.out.println("hospoitalWise True");
				hospitalId = (Integer)map.get("hospitalId");
				cr.add(Restrictions.eq("Hospital.Id", hospitalId));
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				tansSeqObj.setHospital(masHospital);
			}
			if(isPrefix!=null && isPrefix.trim().equalsIgnoreCase("y"))
			{
				System.out.println("prefix True");
				transactionPrefix = (String)map.get("transactionPrefix");
				cr.add(Restrictions.eq("TransactionPrefix", transactionPrefix));
				tansSeqObj.setTransactionPrefix(transactionPrefix);
				seqNumber=transactionPrefix+"/"+seqNumber;
			}
			if(isMonthly!=null && isMonthly.trim().equalsIgnoreCase("y"))
			{
				System.out.println("monthly True");
				cr.add(Restrictions.eq("Month", month));
				tansSeqObj.setMonth(month);
				seqNumber=seqNumber +"/"+month;
			}
			if(isYearly!=null && isYearly.trim().equalsIgnoreCase("y"))
			{ 
				System.out.println("yearly True");
				if(finacialList.size()>0)
				{
					cr.add(Restrictions.eq("Financial.Id", finacialList.get(0).getId()));
					tansSeqObj.setFinancial(finacialList.get(0));
					seqNumber=seqNumber +"/"+year;
				}
				
			}
			
			
			transactionSequenceList = cr.list();		
            System.out.println("transactionSequenceList.size()"+transactionSequenceList.size());
			if(transactionSequenceList.size() > 0 ){
			TransactionSequence transactionSequence = transactionSequenceList.get(0);
			transactionSequence.setTransactionSequenceNumber(transactionSequence.getTransactionSequenceNumber()+1);		
			hbt.update(transactionSequence);
			hbt.flush();
			seqNumber = String.valueOf(transactionSequence.getTransactionSequenceNumber());
		
			if(isPrefix!=null && isPrefix.trim().equalsIgnoreCase("y"))
			{
				seqNumber=transactionPrefix+"/"+seqNumber;
			}
			if(isMonthly!=null && isMonthly.trim().equalsIgnoreCase("y"))
			{
				seqNumber=seqNumber +"/"+month;
			}
			if(isYearly!=null && isYearly.trim().equalsIgnoreCase("y"))
			{
				if(finacialList.size()>0)
				{
					
					seqNumber=seqNumber +"/"+year;
				}
				
			}
			
			hbt.clear();
			
		}else if(transactionSequenceList.size() == 0){			
			tansSeqObj.setStatus("y");			
			tansSeqObj.setTransactionSequenceNumber(1);				
			hbt.save(tansSeqObj);				
			
			//adNo="NO";
		}
		
		}catch(Exception e){		
			
			e.printStackTrace();
			throw e;

		}
		return seqNumber;
	}
	@SuppressWarnings("unchecked")
	public String generateAdNumber(Map<String, Object> adMap) {
		// Instance variable declaration
		int serviceTypeId = 0;
		String adNo = "NO";
		List<TransactionSequence> transactionSequenceList = new ArrayList<TransactionSequence>();
		/*String serviceTypeCode = (String)adMap.get("serviceTypeCode");*/
		/*serviceTypeId = Integer.parseInt(""+adMap.get("serviceTypeId"));*/
		String date = (String)adMap.get("date");
		int hospitalId = (Integer)adMap.get("hospitalId");
		int lastAdmMonth = 0;
		int currentMonth = 0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		Transaction transaction =null;
		// ===========================Calculating the current month in MM format===============
			currentMonth =Integer.parseInt(""+date.substring(date.indexOf("/")+1, date.lastIndexOf("/"))) ;

		//==============Getting the list From TransactionSequence with given serviceTypeId============
		try{
			transaction=session.beginTransaction();
			/*transactionSequenceList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "AD")).add(Restrictions.eq("ServiceType.Id",serviceTypeId)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();*/
			transactionSequenceList = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("TransactionPrefix", "AD")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();

			if(transactionSequenceList.size() > 0 ){
			for (TransactionSequence transactionSequence : transactionSequenceList) {
				int transactionSequenceId = transactionSequence.getId();
				int seqNo = 0;
				lastAdmMonth=transactionSequence.getMonth();
				if(currentMonth==lastAdmMonth){
					seqNo = transactionSequence.getTransactionSequenceNumber();
				}else{
					@SuppressWarnings("unused")
					List<TransactionSequence> tempList = new ArrayList<TransactionSequence>();
					tempList=session.createCriteria(TransactionSequence.class).list();
					for(TransactionSequence sequence :tempList){
						if(sequence.getId() !=7 && sequence.getId() !=16 && sequence.getId() !=17){
						TransactionSequence ts = (TransactionSequence)hbt.load(TransactionSequence.class, sequence.getId());
						ts.setTransactionSequenceNumber(0);
						ts.setMonth(Integer.parseInt(""+currentMonth));
						hbt.update(ts);
						hbt.refresh(ts);
						}
					}
				}
				//========================Generating ADNO ================
				TransactionSequence transactionSequenceObj = (TransactionSequence)hbt.load(TransactionSequence.class, transactionSequenceId);
				transactionSequenceObj.setTransactionSequenceNumber(seqNo+1);
				++seqNo;
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				/*adNo = serviceTypeCode.concat("/");
				adNo = adNo.concat(String.valueOf(seqNo)).concat("/");*/
				
				adNo = String.valueOf(seqNo).concat("/");
				date = date.substring(3, date.length());
				adNo = adNo.concat(date);
			}
		}else if(transactionSequenceList.size() == 0){
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("Inpatient");
			tsObj.setTransactionPrefix("AD");
			tsObj.setTransactionSequenceName("Admission");
			tsObj.setTransactionSequenceNumber(0);
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			tsObj.setHospital(hospital);
			/*MasServiceType serviceType = new MasServiceType();
			serviceType.setId(serviceTypeId);
			tsObj.setServiceType(serviceType);*/
			tsObj.setMonth(Integer.parseInt(""+currentMonth));
			hbt.save(tsObj);
			
			
			//adNo="NO";
		}
			transaction.commit();
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		}catch(Exception e){
			if(transaction !=null)
				transaction.rollback();
			    adNo="NO";
			e.printStackTrace();

		}
		return adNo;
	}

//	-----------Start of Methods written by KALYAN-------------------
	@SuppressWarnings("unchecked")

		public Map<String, Object> showUnitValidateJsp() {
			Map<String,Object>  map=new HashMap<String,Object>();
			List<MasUnit>  searchUnitList=new ArrayList<MasUnit>();
			searchUnitList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasUnit isc where isc.Status = 't' ");
			/*List<Inpatient> tempPatientList  = new ArrayList<Inpatient>();
			List<Inpatient> inPatientList  = new ArrayList<Inpatient>();
			List<MasUnit>  unitList=new ArrayList<MasUnit>();
			List<MasUnit> selectedUnitList = new ArrayList<MasUnit>();
			List<Patient>  patientDetailsList=new ArrayList<Patient>();
			Session session = (Session) getSession();*/
			map.put("searchUnitList", searchUnitList);
			return map;
		}



		public Map<String, Object> searchUnit(String unitName,String unitAddress){
			Map<String,Object>  map=new HashMap<String,Object>();
			List<MasUnit>  searchUnitList=new ArrayList<MasUnit>();
			List<Inpatient> tempPatientList  = new ArrayList<Inpatient>();
			List<Inpatient> inPatientList  = new ArrayList<Inpatient>();
			List<MasUnit>  unitList=new ArrayList<MasUnit>();
			List<MasUnit> selectedUnitList = new ArrayList<MasUnit>();
			List<Patient>  patientDetailsList=new ArrayList<Patient>();
			try{
				if((unitName!=null) || (unitAddress==null)){
					searchUnitList=getHibernateTemplate().find("from jkt.hms.masters.business.MasUnit u where u.UnitName like '%"+ unitName+"%' and u.Status ='t' order by u.UnitName");
				}
				else{
					searchUnitList=getHibernateTemplate().find("from jkt.hms.masters.business.MasUnit u where u.UnitAddress like '%"+ unitAddress+"%' and u.Status ='t' order by u.UnitAddress");
					}
		 	}
			     catch (Exception e) {
				}
			map.put("searchUnitList", searchUnitList);
	      return map;
		}

		public Map<String, Object> getUnitDetails(int unitId){
			Map<String,Object>  map=new HashMap<String,Object>();
			List<Inpatient> tempPatientList  = new ArrayList<Inpatient>();
			List<Inpatient> inPatientList  = new ArrayList<Inpatient>();
			List<MasUnit>  unitList=new ArrayList<MasUnit>();
			List<Patient>  patientDetailsList=new ArrayList<Patient>();
			List<MasUnit>  allUnitList=new ArrayList<MasUnit>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			//List<EmpAfmsfDet> empAfmsfListOfUnit = new ArrayList<EmpAfmsfDet>();

			unitList=getHibernateTemplate().find("from jkt.hms.masters.business.MasUnit u where u.Id='"+unitId+"' order by u.Id");
			patientDetailsList=getHibernateTemplate().find("from jkt.hms.masters.business.Patient p where p.Unit='"+unitId+"' order by p.HinNo");
			allUnitList=getHibernateTemplate().find("from jkt.hms.masters.business.MasUnit u where u.Status ='y' order by u.Id");
			employeeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee emp where emp.Unit='"+unitId+"'");

			//empAfmsfList = getHibernateTemplate().find("from jkt.hms.masters.business.EmpAfmsfDet");
			for (Patient patientdetails : patientDetailsList) {

		    	String pHinNo=patientdetails.getHinNo();
		    	tempPatientList=getHibernateTemplate().find("from jkt.hms.masters.business.Inpatient i where i.HinNo='"+pHinNo+"' order by i.HinNo");
		    	inPatientList.addAll(tempPatientList);
			 }

			/*for (EmpAfmsfDet empAfmsfDet : empAfmsfList) {
				if(empAfmsfDet.getUnit() != null && empAfmsfDet.getUnit().getId() == unitId){
					empAfmsfListOfUnit.add(empAfmsfDet);
				}else if(empAfmsfDet.getPostedFrom() != null && empAfmsfDet.getPostedFrom().getId() == unitId){
					empAfmsfListOfUnit.add(empAfmsfDet);
				}else if(empAfmsfDet.getPostedTo() != null && empAfmsfDet.getPostedTo().getId() == unitId){
					empAfmsfListOfUnit.add(empAfmsfDet);
				}
			}
		   map.put("empAfmsfListOfUnit", empAfmsfListOfUnit);*/
		   map.put("employeeList", employeeList);
		   map.put("allUnitList", allUnitList);
		   map.put("unitList",unitList);
		   map.put("patientDetailsList", patientDetailsList);
		   map.put("inPatientList", inPatientList);
			return map;
		}


		public Map<String, Object> deleteValidateUnit(int unitId) {
			Map<String , Object> map = new HashMap<String, Object>();
			List<MasUnit> searchUnitList = new ArrayList<MasUnit>();
			Session session = (Session)getSession();
			try {
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				String message ="";
				try {
					MasUnit masUnit = (MasUnit)hbt.load(MasUnit.class, unitId);
					hbt.delete(masUnit);
					message ="Unit deleted Successfully";
				} catch (Exception e) {
					message ="Some problem occured";
					e.printStackTrace();
				}

				searchUnitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "t")).list();
				map.put("searchUnitList", searchUnitList);
				map.put("message", message);

			} catch (DataAccessException e) {
				e.printStackTrace();
				session.close();
			}
			return map;
		}

		@SuppressWarnings("unchecked")
		public Map<String, Object> updateUnit(Map<String, Object> dataMap) {
			Map<String, Object> map = new HashMap<String, Object>();
			String localUnit="";
		//	ExpiryDetails expiryDetails = (ExpiryDetails)expiryDetilsMap.get("expiryDetails");
			int unitId = (Integer)dataMap.get("id");
			try {
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				//hbt.save(expiryDetails);
				MasUnit masUnit = (MasUnit)hbt.load(MasUnit.class, unitId);
				if(dataMap.get("unitName")!= null)
				masUnit.setUnitName((String)dataMap.get("unitName"));
				masUnit.setUnitAddress((String)dataMap.get("unitAddress"));
				masUnit.setStatus("y");
				localUnit =(String)dataMap.get("localuUnit");

				if(localUnit.equals("n")){
					masUnit.setLocalUnit("n");
				}else if(localUnit.equals("on")){
					masUnit.setLocalUnit("y");
				}
				hbt.update(masUnit);

				List<MasUnit>  searchUnitList=new ArrayList<MasUnit>();
				searchUnitList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasUnit isc where isc.Status = 't' ");

				map.put("searchUnitList", searchUnitList);

			}catch (Exception e) {
				e.printStackTrace();
			}
			return map;

		}


		@SuppressWarnings("unchecked")
	public Map<String, Object> updateValidateUnit(Map<String, Object> dataMap,Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasUnit>  searchUnitList=new ArrayList<MasUnit>();
	List<Patient>  patientUnitrelation=new ArrayList<Patient>();
	List<MasEmployee>  empUnitrelation=new ArrayList<MasEmployee>();

	String localUnit="";
	boolean data = false;
	int newId = (Integer)dataMap.get("newId");
	int oldId = (Integer)dataMap.get("oldId");

	Vector employeeId = box.getVector("newLocalUnitEmpAfmsf");
	Vector patientId = box.getVector("newLocalUnit");

	Session session= (Session)getSession();

	try {
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		//hbt.save(expiryDetails);
		if(patientId.size() > 0){
			int length = patientId.size();
			localUnit =(String)dataMap.get("localuUnit");
			for (int i = 0; i < length; i++) {
		               if(!patientId.get(i).toString().equals("")){
				       Patient patientObj = (Patient)hbt.load(Patient.class, Integer.parseInt(patientId.get(i).toString()));
		               	MasUnit masUnitObj =new MasUnit();
						masUnitObj.setId(Integer.parseInt(""+newId) );
						patientObj.setUnit(masUnitObj);
						hbt.update(patientObj);
						hbt.refresh(patientObj);
		               }
			}
			patientUnitrelation=getHibernateTemplate().find("from jkt.hms.masters.business.Patient p where p.Unit='"+oldId+"' order by p.HinNo");

		}
		if(employeeId.size() > 0){
			int length = employeeId.size();
			localUnit =(String)dataMap.get("localuUnit");
			for (int i = 0; i < length; i++) {
	               if(!patientId.get(i).toString().equals("")){
		               MasEmployee emp = (MasEmployee)hbt.load(MasEmployee.class, Integer.parseInt(employeeId.get(i).toString()));
						MasUnit masUnitObj1 =new MasUnit();
						masUnitObj1.setId(Integer.parseInt(""+newId) );
						emp.setUnit(masUnitObj1);
						hbt.update(emp);
						hbt.refresh(emp);
	               }
			}
			empUnitrelation=getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee e where e.Unit='"+oldId+"'");

		}
		if(patientUnitrelation.size() == 0 && empUnitrelation.size() == 0){
			String hql="delete from jkt.hms.masters.business.MasUnit as u where u.Id='"+oldId+"'";
			Query query = session.createQuery(hql);
			int row = query.executeUpdate();
			data = true;

		}

		searchUnitList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasUnit isc where isc.Status = 't' ");

		map.put("searchUnitList", searchUnitList);
		map.put("data", data);

	}catch (HibernateException e){
		e.printStackTrace();
		session.close();
	}catch (Exception e) {
		e.printStackTrace();

	}

	return map;
}
		@SuppressWarnings("unchecked")
		public Map<String, Object> getNewUnitDetails(Map<String, Object> dataMap) {
			Map<String,Object>  map=new HashMap<String,Object>();
			List<MasUnit>  newUnitList=new ArrayList<MasUnit>();
			int newUnitId = (Integer)dataMap.get("newUnitId");

			newUnitList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasUnit u where u.Id='"+newUnitId+"'");
			map.put("newUnitList", newUnitList);
			return map;
		}

		public Map<String, Object> showUnitSearchJsp(Box box) {

			List<MasUnit> masUnitList  = new ArrayList<MasUnit>();
			Map<String ,Object> map= new HashMap<String, Object>();
			Session session = (Session)getSession();
			try
			{
				String str = box.get("unit_name");
				if (str!=null && str.length()>0)
				{
				str = "%"+ str.replace(" ", "%")+ "%";

				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				//masIcdList = session.createCriteria(MasIcd.class).add(Restrictions.like("IcdName", str)).list();
				String query=	"from MasUnit as unit  where unit.UnitName like '"+str+"' and unit.Status='y'" ;
		  		Query q=session.createQuery(query);
		  		masUnitList=q.list();
				}
				map.put("masUnitList", masUnitList);
			}catch (HibernateException e){
				e.printStackTrace();
				session.close();
			}catch (Exception e)
			{
				e.printStackTrace();

			}
			return map;

		}

		public Map<String, Object> getMlcDetails(Map<String, Object> parameterMap) {
			boolean status = false;
			Map<String ,Object> map= new HashMap<String, Object>();
			String adNo = "";
			int visitNo = 0;
			String condition="";
			if(parameterMap.get("adNo") != null)
			 adNo =(String) parameterMap.get("adNo");

			if(parameterMap.get("visitNo")!=null)
			 visitNo =(Integer) parameterMap.get("visitNo");

			String hin = (String) parameterMap.get("hinNo");

			List<Inpatient> inpatientList  = new ArrayList<Inpatient>();
			List<Patient> patientList = new ArrayList<Patient>();
			List<MlcCase> mlcList= new ArrayList<MlcCase>();

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session)getSession();

			if(adNo != null && adNo != ""){
//			inpatientList=getHibernateTemplate().find("from jkt.hms.masters.business.Inpatient p where p.AdNo='"+adNo+"'");
			inpatientList=session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).list();
				
			Inpatient inpatient = new Inpatient();
			if(inpatientList.size() > 0){
				inpatient = (Inpatient)inpatientList.get(0);
				if(inpatient.getMlc().equals("y")){
					condition =inpatient.getConditionStatus();
					status =true;
				}
				condition =inpatient.getConditionStatus();
			}
			}


			if(visitNo != 0){
			 patientList = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", hin)).list();
			//patientList = getHibernateTemplate().find("from jkt.hms.masters.business.Patient p where p.HinNo='"+hin+"'");
			 Patient patient = new Patient();
			 if(patientList.size() >0){
				 patient = (Patient)patientList.get(0);
			//	mlcList = getHibernateTemplate().find("from jkt.hms.masters.business.MlcCase m where m.Hin.Id='"+patient.getId()+"' and m.Visit.VisitNo='"+visitNo+"'");
				mlcList = session.createCriteria(MlcCase.class).add(Restrictions.eq("Hin.Id", patient.getId())).add(Restrictions.eq("Visit.VisitNo", visitNo)).list();
			 }
			  if(mlcList.size() >0){
				  MlcCase mlcCase = new MlcCase();
				  mlcCase = (MlcCase) mlcList.get(0);
				  String id = mlcCase.getMlcNo();
				  status = true;
			  }
			}


			map.put("status",status);
			map.put("condition",condition);
			return map;
		}
// cancel final discharge

		public Map<String, Object> getFinalDischargePatientList(Map<String, Object> dischargeMap) {

			String serviceNo = "";
			String hinNo = "";
			String adNo = "";

			if(dischargeMap.get("serviceNo") != null){
				serviceNo = (String)dischargeMap.get("serviceNo");
			}
			if(dischargeMap.get("hin") != null){
				hinNo = (String)dischargeMap.get("hin");
			}
			if(dischargeMap.get("adNo") != null){
				adNo = (String)dischargeMap.get("adNo");
			}

			List<Discharge> dischargeList = new ArrayList<Discharge>();
			Map<String, Object> map = new HashMap<String, Object>();

			Session session = (Session)getSession();

			Criteria crit = session.createCriteria(Discharge.class).add(Restrictions.eq("DischargeAdviced", "n"));
			if(!serviceNo.equals("") && serviceNo != null || !hinNo.equals("") && hinNo != null){
				crit = crit.createAlias("Hin", "hin");
			}
			if(!serviceNo.equals("") && serviceNo != null ){
				crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo));
				crit = crit.add(Restrictions.eq("hin.PatientStatus", "Out Patient"));
			}
			if(!hinNo.equals("") && hinNo != null){
				crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
			}

			if(!adNo.equals("") && adNo != null ){
				crit = crit.add(Restrictions.eq("AdNo", adNo));
			}
			dischargeList = crit.list();
			List<Inpatient> inpatientList =new ArrayList<Inpatient>();
			//inpatientList =(List<Inpatient>)
			try {
				Criteria crit1 = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdStatus","D"));

				if(!adNo.equals("") && adNo != null ){
					crit1 = crit1.add(Restrictions.eq("AdNo", adNo));
				}
				if(!serviceNo.equals("") && serviceNo != null || !hinNo.equals("") && hinNo != null){
					crit1 = crit1.createAlias("Hin", "hin");
				}
				if(!serviceNo.equals("") && serviceNo != null ){
					crit1 = crit1.add(Restrictions.eq("hin.ServiceNo", serviceNo));
					crit1 = crit1.add(Restrictions.eq("hin.PatientStatus", "Out Patient"));
				}
				inpatientList = crit1.list();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.close();
			}

			if(dischargeList.size() > 0 && inpatientList.size() > 0){
				map.put("dischargeList", dischargeList);
			}
			return map;
		}

		public Map<String, Object> canceldischargePatient(
				Map<String, Object> dataMap) {
			// TODO Auto-generated method stub
			Map<String, Object> map = new HashMap<String, Object>();
			String dischargeSuccessfully = "false";
			int dischargeId = 0;
			Transaction tx = null;
			dischargeId = (Integer)dataMap.get("dischargeId");
			int inpatientId = 0;
			Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTime();
			List<Discharge> dischargeList = new ArrayList<Discharge>();
			Session session = (Session)getSession();
			int hinId = 0;
			String adNo = "";
			int dis_status = 0;
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, +1);
			Date nextDate = cal.getTime();

			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));
			int bedStatusOccupiedId = Integer.parseInt(properties.getProperty("bedStatusOccupiedId"));

			try {
				tx = session.beginTransaction();
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

				dischargeList = session.createCriteria(Discharge.class).add(Restrictions.idEq(dischargeId)).list();
				for (Discharge dischargeObj : dischargeList) {
					hinId = dischargeObj.getHin().getId();
					adNo = dischargeObj.getAdNo();
					dis_status = dischargeObj.getDischargeStatus().getId();
				}

				Patient patient = (Patient)hbt.load(Patient.class, hinId);
				patient.setPatientStatus("In Patient");
				patient.setInpatientNo(null);
				hbt.update(patient);

				List<Inpatient> inpatientList = new ArrayList<Inpatient>();
				List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
				List<MasDietCombination> dietCombinationList = new ArrayList<MasDietCombination>();
				inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).list();
				dietTypeList = session.createCriteria(MasDietType.class).add(Restrictions.eq("Status", "y")).list();
				dietCombinationList = session.createCriteria(MasDietCombination.class).add(Restrictions.eq("Status", "y")).list();
				if(inpatientList.size() > 0){
					for (Inpatient inpatient : inpatientList) {
						inpatientId = inpatient.getId();

						Inpatient inpatientObj = (Inpatient)hbt.load(Inpatient.class, inpatientId);
						inpatientObj.setAdStatus("A");
						inpatientObj.setStatus("y");
						inpatientObj.setDischargeDate(null);
						inpatientObj.setDischargeTime(null);

						int bedId = inpatient.getBed().getId();
						//	int departmentId = inpatient.getDepartment().getId();
						MasBed masBed = (MasBed)hbt.load(MasBed.class, bedId);

						int bedstatus = masBed.getBedStatus().getId();
						int departmentId = masBed.getDepartment().getId();
						if(bedstatus == bedStatusOccupiedId){
							List<MasBed> masBedList = new ArrayList<MasBed>();
							masBedList = session.createCriteria(MasBed.class)
							.createAlias("Department", "d")
							.createAlias("BedStatus", "b")
							.add(Restrictions.eq("d.Id", departmentId))
							.add(Restrictions.eq("b.Id", bedStatusUnOccupiedId)).list();
							if(masBedList.size() > 0){
								MasBed masbed = (MasBed) masBedList.get(0);
								inpatientObj.setBed(new MasBed(masbed.getId()));
							}
						}else {
							masBed.setBedStatus(new MasBedStatus(bedStatusOccupiedId));
						}
						hbt.update(inpatientObj);
						/////////////// Inserting new patient diet details////////////////
						DietDetails dietDetailsObj = new DietDetails();
						dietDetailsObj.setDiet(inpatient.getDiet());
						String category = inpatient.getHin().getRank().getRankCategory().getRankCategoryName();
						String dietCategory = "";
						String patientCategory = "";
						if(category.equalsIgnoreCase("Officer")) {
							dietCategory = "Officer";
						}else {
							dietCategory = "Other";
						}
						String relation =  inpatient.getHin().getRelation().getRelationName();
						if(category.equalsIgnoreCase("Officer")) {
							patientCategory = "Officer";
						}else if(category.equalsIgnoreCase("Officer Family")) {
							patientCategory = "Officer Family";
						}else if(!category.equalsIgnoreCase("Officer") && !category.equalsIgnoreCase("Officer Family") && relation.equalsIgnoreCase("Self")) {
							patientCategory = "Others";
						}else if(!category.equalsIgnoreCase("Officer") && !category.equalsIgnoreCase("Officer Family") && !relation.equalsIgnoreCase("Self")) {
							patientCategory = "Others Family";
						}

						dietDetailsObj.setDepartment(inpatient.getDepartment());
						dietDetailsObj.setDietCategory(dietCategory);
						dietDetailsObj.setPatientCategory(patientCategory);
						dietDetailsObj.setDietDate(nextDate);
						dietDetailsObj.setHin(inpatient.getHin());
						dietDetailsObj.setHospital(inpatient.getHospital());
						dietDetailsObj.setInpatient(inpatient);
						dietDetailsObj.setStatus("y");
						dietDetailsObj.setPatientCondition("B");
						int dietTypeId = 0;
						for (MasDietType masDietType : dietTypeList) {
							if(inpatient.getDietType().equalsIgnoreCase(masDietType.getDietTypeName())) {
								dietTypeId = masDietType.getId();
								dietDetailsObj.setDietType(masDietType);
							}
						}

						for(MasDietCombination dietCombination : dietCombinationList) {
							if(inpatient.getDiet().getId() == dietCombination.getDiet().getId() && dietTypeId == dietCombination.getDietType().getId() && dietCombination.getDemandDisplay().equals("n")) {
								dietDetailsObj.setDietCombination(dietCombination);
							}
						}
						try {
							hbt.save(dietDetailsObj);
						} catch (RuntimeException e) {
							e.printStackTrace();
						}
                      ////////////// End Patient Diet Details/////////////////


					}
				}

				List<AttachInpatient> attachPatientList = new ArrayList<AttachInpatient>();
				attachPatientList = session.createCriteria(AttachInpatient.class).add(Restrictions.eq("AdNo", adNo)).add(Restrictions.eq("Status", "y")).list();
				if(attachPatientList.size() > 0){
					for (AttachInpatient attachInpatient : attachPatientList) {
						int attachedId = attachInpatient.getId();
						AttachInpatient attInpatient = (AttachInpatient) hbt.load(AttachInpatient.class, attachedId);
						attInpatient.setStatus("y");

						hbt.update(attInpatient);

						if(attachInpatient.getBed() != null){
							int attBedId = (Integer)attachInpatient.getBed().getId();
							MasBed masBedObj = (MasBed)hbt.load(MasBed.class, attBedId);

							int attDepartment = masBedObj.getDepartment().getId();
							int bedstatus = masBedObj.getBedStatus().getId();
							if(bedstatus == bedStatusOccupiedId){
								List<MasBed> masBedList = new ArrayList<MasBed>();
								masBedList = session.createCriteria(MasBed.class)
								.createAlias("Department", "d1")
								.createAlias("BedStatus", "b1")
								.add(Restrictions.eq("d1.Id", attDepartment))
								.add(Restrictions.eq("b1.Id", bedStatusUnOccupiedId)).list();
								if(masBedList.size() > 0){
									MasBed masbed = (MasBed) masBedList.get(0);
									attInpatient.setBed(new MasBed(masbed.getId()));
								}

							}

							hbt.update(attInpatient);
						}
					}
				}
				if(dischargeId != 0 ){
					Discharge discharge = (Discharge)hbt.load(Discharge.class, dischargeId);
					hbt.delete(discharge);

					List<Discharge> dischargeIcdCodeList = new ArrayList<Discharge>();
					dischargeIcdCodeList = session.createCriteria(DischargeIcdCode.class)
					.createAlias("Inpatient", "p")
					.add(Restrictions.eq("p.Id", inpatientId))
					.add(Restrictions.eq("DiagnosisStatus", "f"))
					.list();
					if(dischargeIcdCodeList.size() >0){
						String hql="delete from jkt.hms.masters.business.DischargeIcdCode as a where a.Inpatient='"+inpatientId+"' and a.DiagnosisStatus='f'";
						Query query = session.createQuery(hql);
						@SuppressWarnings("unused")
						int row = query.executeUpdate();
					}
				}

				dischargeSuccessfully = "true";
				tx.commit();

			}catch (DataAccessException e) {
				if (tx != null) tx.rollback();
				e.printStackTrace();
				session.close();
			}
			map.put("dischargeSuccessfully", dischargeSuccessfully);
			map.put("inpatientId", inpatientId);
			return map;

		}

		@SuppressWarnings("unchecked")
		public boolean updateBedStatics(){
			boolean flag=false;

			Transaction tx = null;
			Session session = (Session)getSession();
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));

			try{

				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);


				tx = session.beginTransaction();
				int inpatientId =0;
				List<Inpatient>inpatientList=new ArrayList<Inpatient>();
				inpatientList = hbt.find("from Inpatient where AdStatus = 'S'");
				if(inpatientList.size() > 0){
					for (Inpatient inpatient : inpatientList) {
						inpatientId = inpatient.getId();
						int bedId = inpatient.getBed().getId();
						Inpatient inpatientObj = (Inpatient)hbt.get(Inpatient.class, inpatientId);
						inpatientObj.setAdStatus("D");
						//inpatientObj.setStatus("n");
						hbt.update(inpatientObj);

						MasBed masBed1 = (MasBed)hbt.get(MasBed.class, bedId);
						MasBedStatus masBedStatus = new MasBedStatus();
						masBedStatus.setId(bedStatusUnOccupiedId);
						masBed1.setBedStatus(masBedStatus);
						hbt.update(masBed1);

					}
				}
				//session.flush();
				flag=true;
				tx.commit();
			} catch (DataAccessException e)  {
				if (tx != null) tx.rollback();
	         	e.printStackTrace();
	         	session.close();
			}
			return flag;
		}

		public Map<String, Object> checkTodayTransactions(Map<String, Object> dataMap) {
			// TODO Auto-generated method stub
			Map<String, Object> map = new HashMap<String, Object>();
			List<Transfer> transferList = new ArrayList<Transfer>();
			List<SilDilStatus> silDilStatusList = new ArrayList<SilDilStatus>();
			List<Discharge> dischargeList = new ArrayList<Discharge>();
			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");
			String adNo = "";
			String status = "false";
			if(dataMap.get("adNo") != null){
				adNo = (String)dataMap.get("adNo");
			}
			Session session = (Session)getSession();
			try {
				transferList = session.createCriteria(Transfer.class).add(Restrictions.eq("AdNo",adNo))
				.add(Restrictions.eq("DateOfTransfer", HMSUtil.convertStringTypeDateToDateType(currentDate))).list();
				if(transferList.size() > 0){
					status = "true";
				}
				inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).list();
				int inpatientId = 0;
				if(inpatientList.size() > 0){
					Inpatient inpatient = (Inpatient)inpatientList.get(0);
					inpatientId = inpatient.getId();
				}

				silDilStatusList= session.createCriteria(SilDilStatus.class).add(Restrictions.eq("Inpatient.Id",inpatientId))
				.add(Restrictions.eq("LastChgDate", HMSUtil.convertStringTypeDateToDateType(currentDate))).list();
				if(silDilStatusList.size() > 0){
					status = "true";
				}

				dischargeList = session.createCriteria(Discharge.class).add(Restrictions.eq("AdNo", adNo))
				.add(Restrictions.eq("DateOfDischarge", HMSUtil.convertStringTypeDateToDateType(currentDate))).list();

				if(dischargeList.size() > 0){
					status = "true";
				}
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.close();
			}
			map.put("status", status);
			return map;
		}

// cancel final discharge

//		-----------Start of Methods written by Vineet-------------------
		@SuppressWarnings("unchecked")

			public Map<String, Object> showTradeValidateJsp() {
				Map<String,Object>  map=new HashMap<String,Object>();
				List<MasTrade>  searchTradeList=new ArrayList<MasTrade>();
				searchTradeList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasTrade isc where isc.Status = 'n' ");
				map.put("searchTradeList", searchTradeList);
				return map;
			}

		/*public Map<String, Object> getTradeDetails(int tradeId){
			Map<String,Object>  map=new HashMap<String,Object>();
			List<Inpatient> tempPatientList  = new ArrayList<Inpatient>();
			List<Inpatient> inPatientList  = new ArrayList<Inpatient>();
			List<MasTrade>  tradeList=new ArrayList<MasTrade>();
			List<Patient>  patientDetailsList=new ArrayList<Patient>();
			List<MasTrade>  allTradeList=new ArrayList<MasTrade>();
			List<EmpAfmsfDet> empAfmsfList = new ArrayList<EmpAfmsfDet>();
//System.out.println("trade id in dss "+tradeId);
List<EmpAfmsfDet> empAfmsfListOfTrade = new ArrayList<EmpAfmsfDet>();
			tradeList=getHibernateTemplate().find("from jkt.hms.masters.business.MasTrade u where u.Id='"+tradeId+"' order by u.Id");
			patientDetailsList=getHibernateTemplate().find("from jkt.hms.masters.business.Patient p where p.Trade='"+tradeId+"' order by p.HinNo");
			allTradeList=getHibernateTemplate().find("from jkt.hms.masters.business.MasTrade u where u.Status ='y' order by u.Id");
			empAfmsfList = getHibernateTemplate().find("from jkt.hms.masters.business.EmpAfmsfDet");
			//System.out.println("atientDetailsList.size() in dss"+patientDetailsList.size());
			for (Patient patientdetails : patientDetailsList) {

		    	String pHinNo=patientdetails.getHinNo();
		    	tempPatientList=getHibernateTemplate().find("from jkt.hms.masters.business.Inpatient i where i.HinNo='"+pHinNo+"' order by i.HinNo");
		    	inPatientList.addAll(tempPatientList);
			 }

			for (EmpAfmsfDet empAfmsfDet : empAfmsfList) {
				if(empAfmsfDet.getTrade() != null && empAfmsfDet.getTrade().getId() == tradeId){
					empAfmsfListOfTrade.add(empAfmsfDet);
				}else if(empAfmsfDet.getPostedFrom() != null && empAfmsfDet.getPostedFrom().getId() == tradeId){
					empAfmsfListOfTrade.add(empAfmsfDet);
				}else if(empAfmsfDet.getPostedTo() != null && empAfmsfDet.getPostedTo().getId() == tradeId){
					empAfmsfListOfTrade.add(empAfmsfDet);
				}
			}

		   map.put("empAfmsfListOfTrade", empAfmsfListOfTrade);
		   map.put("allTradeList", allTradeList);
		   map.put("tradeList",tradeList);
		   map.put("patientDetailsList", patientDetailsList);
		   map.put("inPatientList", inPatientList);
			return map;
		}*/
		public Map<String, Object> getTradeDetails(int tradeId){
			Map<String,Object>  map=new HashMap<String,Object>();
			List<Inpatient> tempPatientList  = new ArrayList<Inpatient>();
			List<Inpatient> inPatientList  = new ArrayList<Inpatient>();
			List<MasTrade>  tradeList=new ArrayList<MasTrade>();
			List<Patient>  patientDetailsList=new ArrayList<Patient>();
			List<MasTrade>  allTradeList=new ArrayList<MasTrade>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			//List<EmpAfmsfDet> empAfmsfList = new ArrayList<EmpAfmsfDet>();
			Session session = (Session)getSession();
			//List<EmpAfmsfDet> empAfmsfListOfTrade = new ArrayList<EmpAfmsfDet>();
			tradeList=getHibernateTemplate().find("from jkt.hms.masters.business.MasTrade u where u.Id='"+tradeId+"' order by u.Id");
			allTradeList=getHibernateTemplate().find("from jkt.hms.masters.business.MasTrade u where u.Status ='y' order by u.Id");
			//empAfmsfList = getHibernateTemplate().find("from jkt.hms.masters.business.EmpAfmsfDet");
			patientDetailsList=getHibernateTemplate().find("from jkt.hms.masters.business.Patient p where p.Trade='"+tradeId+"' order by p.HinNo");
			employeeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee emp where emp.Trade='"+tradeId+"'");
			//patientDetailsList = session.createCriteria(Patient.class).createAlias(arg0, arg1)
			for (Patient patientdetails : patientDetailsList) {

		    	String pHinNo=patientdetails.getHinNo();
		    	tempPatientList=getHibernateTemplate().find("from jkt.hms.masters.business.Inpatient i where i.HinNo='"+pHinNo+"' order by i.HinNo");
		    	inPatientList.addAll(tempPatientList);
			 }

			/*for (EmpAfmsfDet empAfmsfDet : empAfmsfList) {
				if(empAfmsfDet.getTrade() != null && empAfmsfDet.getTrade().getId() == tradeId){
					empAfmsfListOfTrade.add(empAfmsfDet);
				}else if(empAfmsfDet.getPostedFrom() != null && empAfmsfDet.getPostedFrom().getId() == tradeId){
					empAfmsfListOfTrade.add(empAfmsfDet);
				}else if(empAfmsfDet.getPostedTo() != null && empAfmsfDet.getPostedTo().getId() == tradeId){
					empAfmsfListOfTrade.add(empAfmsfDet);
				}
			}
		   map.put("empAfmsfListOfTrade", empAfmsfListOfTrade);*/
		   map.put("allTradeList", allTradeList);
		   map.put("employeeList", employeeList);
		   map.put("tradeList",tradeList);
		   map.put("patientDetailsList", patientDetailsList);
		   map.put("inPatientList", inPatientList);
			return map;
		}

		public Map<String, Object> searchTrade(String tradeName){
			Map<String,Object>  map=new HashMap<String,Object>();
			List<MasTrade>  searchTradeList=new ArrayList<MasTrade>();
			List<Inpatient> tempPatientList  = new ArrayList<Inpatient>();
			List<Inpatient> inPatientList  = new ArrayList<Inpatient>();
			List<MasTrade>  tradeList=new ArrayList<MasTrade>();
			List<MasTrade> selectedTradeList = new ArrayList<MasTrade>();
			List<Patient>  patientDetailsList=new ArrayList<Patient>();
			try{
				if((tradeName!=null)){
					searchTradeList=getHibernateTemplate().find("from jkt.hms.masters.business.MasTrade u where u.TradeName like '%"+ tradeName+"%' and u.Status ='n' order by u.TradeName");
				}
		 	}
			     catch (Exception e) {
			    	 e.printStackTrace();
				}
			map.put("searchTradeList", searchTradeList);
	      return map;
		}

		@SuppressWarnings("unchecked")
		public Map<String, Object> updateTrade(Map<String, Object> dataMap) {
			Map<String, Object> map = new HashMap<String, Object>();

		//	ExpiryDetails expiryDetails = (ExpiryDetails)expiryDetilsMap.get("expiryDetails");
			int tradeId = (Integer)dataMap.get("id");
			try {
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				//hbt.save(expiryDetails);
				MasTrade masTrade = (MasTrade)hbt.load(MasTrade.class, tradeId);
				masTrade.setTradeName((String)dataMap.get("tradeName"));
				masTrade.setStatus("y");


				hbt.update(masTrade);

				List<MasTrade>  searchTradeList=new ArrayList<MasTrade>();
				searchTradeList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasTrade isc where isc.Status = 'n' ");

				map.put("searchTradeList", searchTradeList);

			}catch (Exception e) {
				e.printStackTrace();
			}
			return map;

		}


		@SuppressWarnings("unchecked")
	/*public Map<String, Object> updateValidateTrade(Map<String, Object> dataMap,Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasTrade>  searchTradeList=new ArrayList<MasTrade>();
	List<Patient>  patientTraderelation=new ArrayList<Patient>();
	List<EmpAfmsfDet>  empAfmsfTraderelation=new ArrayList<EmpAfmsfDet>();


	boolean data = false;
	int newId = (Integer)dataMap.get("newId");
	int oldId = (Integer)dataMap.get("oldId");

	Vector empAfmsfId = box.getVector("newLocalTradeEmpAfmsf");
	Vector patientId = box.getVector("newLocalTrade");

	session= (Session)getSession();

	try {
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		//hbt.save(expiryDetails);
		if(patientId.size() > 0){
			int length = patientId.size();

			for (int i = 0; i < length; i++) {
		               Patient patientObj = (Patient)hbt.load(Patient.class, Integer.parseInt(patientId.get(i).toString()));
						MasTrade masTradeObj =new MasTrade();
						masTradeObj.setId(Integer.parseInt(""+newId) );
						patientObj.setTrade(masTradeObj);
						hbt.update(patientObj);
			}
			patientTraderelation=getHibernateTemplate().find("from jkt.hms.masters.business.Patient p where p.Trade='"+oldId+"' order by p.HinNo");
				//System.out.println("patientTraderelation   "+patientTraderelation.size());
		}else if(empAfmsfId .size() > 0){

			int length = empAfmsfId.size();

			for(int j=0;j<length;j++){
				EmpAfmsfDet empAfmsfDet = (EmpAfmsfDet)hbt.load(EmpAfmsfDet.class, Integer.parseInt(empAfmsfId.get(j).toString()));

				if(empAfmsfDet.getTrade() != null && empAfmsfDet.getTrade().getId() == oldId){
						MasTrade trade  =new MasTrade();
						trade.setId(newId);
						empAfmsfDet.setTrade(trade);
				}


						hbt.update(empAfmsfDet);
			}

			List<EmpAfmsfDet> tempList = new ArrayList<EmpAfmsfDet>();
				tempList = session.createCriteria(EmpAfmsfDet.class).list();
				for (EmpAfmsfDet empAfmsfDet : tempList) {
					if(empAfmsfDet.getTrade() != null && empAfmsfDet.getTrade().getId() == oldId){
						empAfmsfTraderelation.add(empAfmsfDet);
					}else if(empAfmsfDet.getPostedFrom() != null && empAfmsfDet.getPostedFrom().getId() == oldId){
						empAfmsfTraderelation.add(empAfmsfDet);
					}else if(empAfmsfDet.getPostedTo() != null && empAfmsfDet.getPostedTo().getId() == oldId){
						empAfmsfTraderelation.add(empAfmsfDet);
					}
				}

		}


		if(patientTraderelation.size() == 0 || empAfmsfTraderelation.size() == 0){
			//System.out.println("OLd in IMPL"+oldId);
			String hql="delete from jkt.hms.masters.business.MasTrade as u where u.Id='"+oldId+"'";
			Query query = session.createQuery(hql);
			int row = query.executeUpdate();
			data = true;

		}

		searchTradeList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasTrade isc where isc.Status = 'n' ");

		map.put("searchTradeList", searchTradeList);
		//System.out.println("data  in data service "+data);
		map.put("data", data);

	}catch (Exception e) {
		e.printStackTrace();
	}

	return map;
}
*/
		public Map<String, Object> updateValidateTrade(Map<String, Object> dataMap,Box box) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasTrade>  searchTradeList=new ArrayList<MasTrade>();
	List<Patient>  patientTraderelation=new ArrayList<Patient>();
	List<MasEmployee>  empTraderelation=new ArrayList<MasEmployee>();


	boolean data = false;
	int newId = (Integer)dataMap.get("newId");
	int oldId = (Integer)dataMap.get("oldId");

	Vector employeeId = box.getVector("newLocalTradeEmpAfmsf");
	Vector patientId = box.getVector("newLocalTrade");

	session= (Session)getSession();

	try {
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		//hbt.save(expiryDetails);
		if(patientId.size() > 0){
			int length = patientId.size();

			for (int i = 0; i < length; i++) {
				       if(!patientId.get(i).toString().equals("")){
		               Patient patientObj = (Patient)hbt.load(Patient.class, Integer.parseInt(patientId.get(i).toString()));
						MasTrade masTradeObj =new MasTrade();
						masTradeObj.setId(Integer.parseInt(""+newId) );
						patientObj.setTrade(masTradeObj);
						hbt.update(patientObj);
				       }
			}
			patientTraderelation=getHibernateTemplate().find("from jkt.hms.masters.business.Patient p where p.Trade='"+oldId+"' order by p.HinNo");
		}

		if(employeeId.size() > 0){
			int length = employeeId.size();

			for (int i = 0; i < length; i++) {
				       if(employeeId.get(i).toString().equals("")){
		               MasEmployee emp = (MasEmployee)hbt.load(MasEmployee.class, Integer.parseInt(employeeId.get(i).toString()));
						MasTrade masTradeObj1 =new MasTrade();
						masTradeObj1.setId(Integer.parseInt(""+newId) );
						emp.setTrade(masTradeObj1);
						hbt.update(emp);
				       }
			}
			empTraderelation=getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee e where e.Trade='"+oldId+"' ");
		}


		if(patientTraderelation.size() == 0 && empTraderelation.size() == 0){
			String hql="delete from jkt.hms.masters.business.MasTrade as u where u.Id='"+oldId+"'";
			Query query = session.createQuery(hql);
			int row = query.executeUpdate();
			data = true;

		}

		searchTradeList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasTrade isc where isc.Status = 'n' ");

		map.put("searchTradeList", searchTradeList);
		map.put("data", data);

	}catch (Exception e) {
		e.printStackTrace();
	}

	return map;
}
		public Map<String, Object> deleteValidateTrade(int tradeId) {
			Map<String , Object> map = new HashMap<String, Object>();
			List<MasTrade> searchTradeList = new ArrayList<MasTrade>();
			Session session = (Session)getSession();
			try {
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				String message ="";
				try {
					MasTrade masTrade = (MasTrade)hbt.load(MasTrade.class, tradeId);
					hbt.delete(masTrade);
					message ="Trade deleted Successfully";
				} catch (Exception e) {
					message ="Some problem occured";
					e.printStackTrace();
				}

				searchTradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "n")).list();
				map.put("searchTradeList", searchTradeList);
				map.put("message", message);

			} catch (DataAccessException e) {
				e.printStackTrace();
				session.close();
			}
			return map;
		}
		public Map<String, Object> showTradeSearchJsp(Box box) {

			List<MasTrade> masTradeList  = new ArrayList<MasTrade>();
			Map<String ,Object> map= new HashMap<String, Object>();
			try
			{
				String str = box.get("trade_name");
				if (str!=null && str.length()>0)
				{
				str = "%"+ str.replace(" ", "%")+ "%";
				Session session = (Session)getSession();
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				String query=	"from MasTrade as trade  where trade.TradeName like '"+str+"' and trade.Status='y'" ;
		  		Query q=session.createQuery(query);
		  		masTradeList=q.list();
				}
				map.put("masTradeList", masTradeList);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return map;

		}
//		-----------End of Methods written by KALYAN-------------------
		public Map<String, Object> showInjuryReportJsp() {
			Session session = (Session) getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
			List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
			try {

				serviceTypeList = session.createCriteria(MasServiceType.class).add(
						Restrictions.eq("Status", "y")).list();
				disposalList = session.createCriteria(MasDisposal.class).add(
						Restrictions.eq("Status", "y")).list();

			} catch (HibernateException e) {
				e.printStackTrace();
			}

			map.put("serviceTypeList", serviceTypeList);
			map.put("disposalList", disposalList);
			return map;
		}

//		-----------End of Methods written by VISHAL-------------------
		public void closeHibernateSession(){
			try{
				Session session = (Session)getSession();
				session.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		@SuppressWarnings("unchecked")
		public Map<String, Object> getHinNoForAdm(String serviceNo) {
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			List<Object[]> hinNoList = new ArrayList<Object[]>();
			try {
				if (!serviceNo.equals("")) {
					hinNoList = session.createCriteria(Patient.class).add(
							Restrictions.eq("ServiceNo", serviceNo)).add(
							Restrictions.eq("PatientStatus","Out Patient"))
							.createAlias("Relation", "rel")
							.setProjection(Projections.projectionList()
									.add(Projections.property("Id")).add(Projections.property("HinNo"))
									.add(Projections.property("PFirstName"))
								.add(Projections.property("PMiddleName"))
								.add(Projections.property("PLastName"))
								.add(Projections.property("rel.RelationName")))
									.list();
				}
				map.put("hinNoList", hinNoList);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return map;
		}

		@Override
		public Map<String, Object> searchPatientTrack(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			String date = box.getString(DATE);
			Date visitDate = new Date();
			if(!date.equals("")){
				visitDate = HMSUtil.convertStringTypeDateToDateType(date);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
			String serviceNo = box.getString("serviceNo");
			String hin = box.getString("hinNo");
			String sFName = box.getString(S_FIRST_NAME);
			String sMName = box.getString(S_MIDDLE_NAME);
			String sLName = box.getString(S_LAST_NAME);
			int rankId = box.getInt("rankId");
			int serviceTypeId = box.getInt(SERVICE_TYPE_ID);
			int tradeId = box.getInt("tradeId");
			int sectionId = box.getInt("sectionId");
			String stationName = box.getString("stationId");
			int commandId = box.getInt("commandId");
			int relationId = box.getInt(RELATION_ID);
			int unitId = box.getInt("unitId");
			String mobileNo = box.getString("mobileNo");
			String afnetNo = box.getString("afnetNo");
			String pName = box.getString(P_FIRST_NAME);
			int hinId = box.getInt("hinId");
			int hospitalId = box.getInt("hospitalId");
			
			List<Object[]> ptTrackList = new ArrayList<Object[]>();
		/*	String qry = "select visit_id,(visit_date || ' ' || visit_time) as visit," +
					//" (select service_no from patient where hin_id=v.hin_id) as srno," +
			" pt.service_no as srno, "+
			"(pt.p_first_name || ' ' || nvl(pt.p_middle_name,'') || ' '||nvl(pt.p_last_name,'')), "+
			//		" (select (p_first_name || ' ' || nvl(p_middle_name,'') || ' '||nvl(p_last_name,'')) from patient where hin_id=v.hin_id) as ptn," +
					" (select (opd_date || ' ' || opd_time) from opd_patient_details where visit_id=v.visit_id) as opd," +
					" (select (issue_date || ' ' || last_chg_time) from PATIENT_PRESCRIPTION_HEADER pph" +
					" left join STORE_OP_PATIENT_ISSUE_M sopi on pph.prescription_id=sopi.prescription_id where v.visit_id=pph.visit_id) as disp," +
					" (select distinct sample_validation_date from dg_orderhd oh" +
					" left join dg_sample_collection_header sc on oh.orderhd_id=sc.order_id" +
					" right join dg_sample_collection_details scd on sc.SAMPLE_COLLECTION_HEADER_ID=scd.sample_collection_header_id" +
					" where scd.maincharge=2 and oh.visit_id=v.visit_id) as lab," +
					" (select distinct sample_validation_date from dg_orderhd oh" +
					" left join dg_sample_collection_header sc on oh.orderhd_id=sc.order_id" +
					" right join dg_sample_collection_details scd on sc.SAMPLE_COLLECTION_HEADER_ID=scd.sample_collection_header_id" +
					" where scd.maincharge=1 and oh.visit_id=v.visit_id) as radology," +
					" (select (phy_visit_date || ' ' || time_begin) from physiotherapy_details where visit_id=v.visit_id) as physio," +
					" least((select (DETAined_from||' '||from_time) as dt from patient_detention_register where visit_id=v.visit_id) ," +
					" (select (injection_DATE||' '||injection_time) as inj from injection_register where visit_id=v.visit_id))  as tr" +
					" from visit v left join patient pt on v.hin_id=pt.hin_id " +
					" left join mas_rank mr on pt.rank_id=mr.rank_id"+
					" left join mas_service_type mst on pt.service_type_id=mst.service_type_id"+
					" left join mas_unit mu on pt.unit_id=mu.unit_id"+
					" left join mas_trade mt on pt.trade_id=mt.trade_id"+
					" left join mas_section mse on pt.section_id=mse.section_id"+
					" left join mas_command mc on pt.command_id=mc.command_id"+
					" where visit_date='"+sdf.format(visitDate)+"' and reporting_for='OPD' ";*/
			
			String qry = "select v.visit_id,(to_char(visit_date,'dd/mm/yyyy') || ' ' || substr(visit_time,1,5)) as visit, pt.service_no as srno, " +
					" (pt.p_first_name || ' ' || nvl(pt.p_middle_name,'') || ' '||nvl(pt.p_last_name,'')) pname," +
					" (select min(to_char(opd_date,'dd/mm/yyyy')  || ' ' || substr(opd_time,1,5)) from opd_patient_details where visit_id=v.visit_id) as opd," +
					" (select min(to_char(issue_date,'dd/mm/yyyy') || ' ' || last_chg_time) from PATIENT_PRESCRIPTION_HEADER pph" +
					" left join STORE_OP_PATIENT_ISSUE_M sopi on pph.prescription_id=sopi.prescription_id" +
					" where v.visit_id=pph.visit_id group by visit_id) as disp," +
					" (select min (to_char(sample_validation_date,'dd/mm/yyyy') || ' ' ||  substr(sample_validation_time,1,5)) from dg_orderhd oh left join dg_sample_collection_header sc on oh.orderhd_id=sc.order_id right join dg_sample_collection_details scd on sc.SAMPLE_COLLECTION_HEADER_ID=scd.sample_collection_header_id where scd.maincharge=2 and oh.visit_id=v.visit_id) as lab," +
					" (select min (to_char(sample_validation_date,'dd/mm/yyyy') || ' ' ||  substr(sample_validation_time,1,5)) from dg_orderhd oh left join dg_sample_collection_header sc on oh.orderhd_id=sc.order_id right join dg_sample_collection_details scd on sc.SAMPLE_COLLECTION_HEADER_ID=scd.sample_collection_header_id where scd.maincharge=1 and oh.visit_id=v.visit_id) as radology," +
					" (to_char(phy_visit_date,'dd/mm/yyyy') || ' ' || substr(time_begin,1,5))  as physio," +
					" (case when (DETAined_from is not null and injection_DATE is null ) then  (to_char(DETAined_from,'dd/mm/yyyy')||' '||substr(from_time,1,5))" +
					" when (DETAined_from is null and injection_DATE is not null ) then (to_char(injection_DATE,'dd/mm/yyyy')||' '||substr(injection_time,1,5))" +
					" else least((to_char(detained_from,'dd/mm/yyyy')||' '||substr(from_time,1,5)) , (to_char(injection_DATE,'dd/mm/yyyy')||' '||substr(injection_time,1,5) )) end) as tr " +
					" from visit v" +
					" left join patient pt on v.hin_id=pt.hin_id  left join mas_rank mr on pt.rank_id=mr.rank_id" +
					" left join mas_service_type mst on pt.service_type_id=mst.service_type_id" +
					" left join mas_unit mu on pt.unit_id=mu.unit_id left join mas_trade mt on pt.trade_id=mt.trade_id" +
					" left join mas_section mse on pt.section_id=mse.section_id left join mas_command mc on pt.command_id=mc.command_id" +
					" left join physiotherapy_details phyd on phyd.visit_id=v.visit_id" +
					" left join patient_detention_register det on det.visit_id=v.visit_id" +
					" left join injection_register inj on inj.visit_id=v.visit_id" +
					" where v.visit_date=:visitDate and reporting_for='OPD' and v.hospital_id=:hospitalId";
			
			
		
			if(hinId!=0){
				qry += " and pt.hin_id = :hinId";
			}
			if(!serviceNo.equals("")){
				qry += " and pt.service_no = :serviceNo";
			}
			if(!hin.equals("")){
				qry += " and pt.hin_no = :hin";
			}
			if(!sFName.equals("")){
				qry += " and upper(pt.s_first_name) like upper(:sFName) ";
			}
			if(!sMName.equals("")){
				qry += " and upper(pt.s_middle_name) like upper(:sMName) ";
			}
			if(!sLName.equals("")){
				qry += " and upper(pt.s_last_name) like upper(:sLName) ";
			}
			if(!pName.equals("")){
				qry += " and upper(pt.p_first_name) like upper(:pName) ";
			}
			if(!stationName.equals("")){
				qry += " and pt.station = :stationName ";
			}
			if(!mobileNo.equals("")){
				qry += " and pt.mobile_number = :mobileNo ";
			}
			if(!afnetNo.equals("")){
				qry += " and afnet_no =:afnetNo";
			}
			if(rankId!=0){
				qry += " and pt.rank_id = :rankId";
			}
			if(tradeId!=0){
				qry += " and pt.trade_id = :tradeId";
			}
			if(unitId!=0){
				qry += " and pt.unit_id = :unitId";
			}
			if(sectionId!=0){
				qry += " and pt.section_id = :sectionId";
			}
			if(commandId!=0){
				qry += " and pt.command_id = :commandId";
			}
			if(relationId!=0){
				qry += " and pt.relation_id = :relationId";
			}
			if(serviceTypeId!=0){
				qry += " and pt.service_type_id = :serviceTypeId";
			}
			qry +=" order by visit_date,visit_time asc";
			
			SQLQuery sqlQry = session.createSQLQuery(qry);
			sqlQry.setParameter("visitDate", sdf.format(visitDate));
			sqlQry.setParameter("hospitalId", hospitalId);
			if(hinId!=0){
				sqlQry.setParameter("hinId", hinId);
			}
			if(!serviceNo.equals("")){
				sqlQry.setParameter("serviceNo", serviceNo);
			}
			if(!hin.equals("")){
				sqlQry.setParameter("hin", hin);
			}
			if(!sFName.equals("")){
				sqlQry.setParameter("sFName", sFName+"%");
				
			}
			if(!sMName.equals("")){
				sqlQry.setParameter("sMName", sMName+"%");
				
			}
			if(!sLName.equals("")){
				sqlQry.setParameter("sLName", sLName+"%");
			}
			if(!pName.equals("")){
				sqlQry.setParameter("pName", pName+"%");
				
			}
			if(!stationName.equals("")){
				sqlQry.setParameter("stationName", stationName);
				
			}
			if(!mobileNo.equals("")){
				sqlQry.setParameter("mobileNo", mobileNo);
				
			}
			if(!afnetNo.equals("")){
				sqlQry.setParameter("afnetNo", afnetNo);
				
			}
			if(rankId!=0){
				sqlQry.setParameter("rankId", rankId);
			}
			if(tradeId!=0){
				sqlQry.setParameter("tradeId", tradeId);
				
			}
			if(unitId!=0){
				sqlQry.setParameter("unitId", unitId);
				
			}
			if(sectionId!=0){
				sqlQry.setParameter("sectionId", sectionId);
				
			}
			if(commandId!=0){
				sqlQry.setParameter("commandId", commandId);
				
			}
			if(relationId!=0){
				sqlQry.setParameter("relationId", relationId);
				
			}
			if(serviceTypeId!=0){
				sqlQry.setParameter("serviceTypeId", serviceTypeId);
			}
			
			ptTrackList = sqlQry.list();
			map.put("ptTrackList", ptTrackList);
			return map;
		}

		@Override
		public Map<String, Object> getHinDetailsForAppointment(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Patient> patientList = new ArrayList<Patient>();
			Session session = getSession();
			patientList = session.createCriteria(Patient.class).add(Restrictions.idEq(box.getInt(HIN_ID))).list();
			map.put("patientList",patientList);
			return map;
		}

		@Override
		public Map<String, Object> submitPatientAppointment(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			boolean flag = false;
			Session session = getSession();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				int counter = box.getInt("cnt");
				if(counter>0){
					for(int i=1;i<=counter;i++){
						if(box.getInt("appId"+i)==0){
							PatientAppointment appointment = new PatientAppointment();
							appointment.setServiceNo(box.getString("serviceNo"+i));
							appointment.setPatientName(box.getString("patientName"+i));
							appointment.setServPersName(box.getString("servPersName"+i));
							if(box.getInt("relationId"+i)!=0){
								MasRelation relation = new MasRelation();
								relation.setId(box.getInt("relationId"+i));
								appointment.setRelation(relation);
							}
							if(box.getInt("rankId"+i)!=0){
								MasRank rank = new MasRank();
								rank.setId(box.getInt("rankId"+i));
								appointment.setRank(rank);
							}
							if(!box.getString("age"+i).equals("")){
								appointment.setAge(box.getString("age"+i));
							}
							if(box.getInt("sex"+i)!=0){
								MasAdministrativeSex sex = new MasAdministrativeSex();
								sex.setId(box.getInt("sex"+i));
								appointment.setSex(sex);
							}
							if(box.getInt("mo"+i)!=0){
								MasEmployee employee = new MasEmployee();
								employee.setId(box.getInt("mo"+i));
								appointment.setMedicalOfficer(employee);
							}
							appointment.setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(box.getString("appDate"+i)));
							appointment.setAppointmentTime(box.getString("appTime"+i));
							appointment.setDepartment(box.getString("department"+i));
							Users user = new Users();
							user.setId(box.getInt("userId"));
							appointment.setLastChgBy(user);
							MasHospital hospital = new MasHospital();
							hospital.setId(box.getInt("hospitalId"));
							appointment.setHospital(hospital);
							int hinId = 0;
							if(box.getInt("patientNameHin"+i)!=0){
								Patient patient = new Patient();
								hinId = box.getInt("patientNameHin"+i);
								patient.setId(box.getInt("patientNameHin"+i));
								appointment.setHin(patient);
							}
							appointment.setStatus("p");
							Map<String,Object> utilMap = new HashMap<String,Object>();
							utilMap = (Map)HMSUtil.getCurrentDateAndTime();
							String currentDate = (String)utilMap.get("currentDate");  
							String currentTime = (String)utilMap.get("currentTimeWithoutSc");

							appointment.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
							appointment.setLastChgTime(currentTime);
							
							
		//---------code by anamika for entry in visit----------------------------------//
							Visit visitObj = new Visit();
							List<Patient> patientListForVisitNo = new ArrayList<Patient>();
							patientListForVisitNo = session.createCriteria(Patient.class).add(Restrictions.idEq(hinId)).list();
							int visitNo = 0;
							int currentVisitNo = 0;
							String age = "";
							if(patientListForVisitNo.size()>0){
								Patient pt = patientListForVisitNo.get(0);
								visitNo = pt.getCurrentVisitNo();
								currentVisitNo = visitNo+1;
								age = pt.getAge();
								int consultingDoctorId = 0;
								int tokenNo = 0;
								String tokenAndDoctor = "";
								if (box.getInt("mo"+i) != 0) {
									consultingDoctorId = box.getInt("mo"+i);
									MasEmployee consultingDoctorObj = new MasEmployee();
									consultingDoctorObj.setId(consultingDoctorId);
									visitObj.setDoctor(consultingDoctorObj);
						            int maxTokenNo = 0;
						            maxTokenNo = getTokenNoForDepartment(consultingDoctorId);
						            tokenNo = maxTokenNo + 1;
						        	tokenAndDoctor = tokenNo+"#"+consultingDoctorId;
								}else{
									  tokenNo = 0;
									  tokenAndDoctor = tokenNo+"#"+consultingDoctorId;
								}
								
							visitObj.setTokenNo(tokenNo);
							visitObj.setTokenDoctor(tokenAndDoctor);
							Patient patientForVisit =(Patient)hbt.load(Patient.class, box.getInt("patientNameHin"+i));
							patientForVisit.setCurrentVisitNo(currentVisitNo);
							hbt.update(patientForVisit);
						
							if (box.getInt("deptId"+i)!=0) {
								MasDepartment masDepartment = new MasDepartment();
								masDepartment.setId(box.getInt("deptId"+i));
								visitObj.setDepartment(masDepartment);
							}
							
							visitObj.setVisitNo(currentVisitNo);
							visitObj.setVisitDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
							visitObj.setVisitTime(currentTime);
							visitObj.setPriority(3);
							if(!box.getString("department"+i).equals("")){
								visitObj.setReportingFor(box.getString("department"+i));
							}
							if(box.getInt("patientNameHin"+i)!=0){
					        Patient patientObj = new Patient();
					        patientObj.setId(box.getInt("patientNameHin"+i));
					        visitObj.setHin(patientObj);
							}
					        visitObj.setAge(age);	
							Users userObj = new Users();
							userObj.setId(box.getInt("userId"));
							visitObj.setAddEditBy(userObj);
							visitObj.setAddEditDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
							visitObj.setAddEditTime(currentTime);
							visitObj.setStatus("y");
							visitObj.setVisitStatus("w");
							visitObj.setAppointmentType("A");
							MasHospital hosp = new MasHospital();
							hosp.setId(box.getInt("hospitalId"));
							visitObj.setHospital(hosp);
							hbt.save(visitObj);
						 }
							hbt.save(appointment);
							flag = true;
					  }
						
					
					}
				}
			/*	Session session = getSession();
				List<PatientAppointment> appointmentList = new ArrayList<PatientAppointment>();
				appointmentList = session.createCriteria(PatientAppointment.class).add(Restrictions.idEq(appointment.getId())).list();
				if(appointmentList.size() > 0){
					map.put("appointmentList", appointmentList);
				}
				*/
				tx.commit();
			} catch (DataAccessException e) {
				if(tx!=null){
					tx.rollback();
				}
				e.printStackTrace();
			}
			map.put("flag", flag);
			return map;
		}


	public int getTokenNoForDepartment(int doctorId) {
	    List<Integer> tokenNoList = new ArrayList<Integer>();
	    int tokenNo = 0;
	    Date date = new Date();
	    Session session = (Session) getSession();
	    // tokenNoList = getHibernateTemplate().find("select max(v.TokenNo) from
	    // Visit v join v.Department as dept where dept.Id="+departmentId+"	and
	    // v.VisitDate="+date);
	    try {
			tokenNoList = session.createCriteria(Visit.class, "v")
			        .add(Restrictions.eq("v.VisitDate", date))
			        .createAlias("Doctor", "doctor").add(Restrictions.eq("doctor.Id", doctorId))
			        .setProjection(Projections.projectionList().add(Projections.max("TokenNo"))).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//session.close();
		}
	    if (tokenNoList.get(0) != null) {
	        tokenNo = tokenNoList.get(0);
	    }
	    return tokenNo;
	}

		@Override
		public boolean cancelPatientAppointment(Box box) {
			boolean flag = false;
			
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			try {
				PatientAppointment appointment = (PatientAppointment)hbt.load(PatientAppointment.class, box.getInt("radioAppId"));
				appointment.setStatus("c");
				hbt.update(appointment);
			
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return flag;
		}

		@Override
		public Map<String, Object> searchAppointments(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			String fromAppDate = box.getString("fromAppDate");
			String toAppDate = box.getString("toAppDate");
			Date fromAppointmentDate = new Date();
			Date toAppointmentDate = new Date();
			if(!fromAppDate.equals("")){
				fromAppointmentDate = HMSUtil.convertStringTypeDateToDateType(fromAppDate);
			}
			if(!toAppDate.equals("")){
				toAppointmentDate = HMSUtil.convertStringTypeDateToDateType(toAppDate);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
			String serviceNo = box.getString("searchServNo");
			String hin = box.getString("hinNo");
			String pName = box.getString(P_FIRST_NAME);
			String sName = box.getString(S_FIRST_NAME);
			int rankId = box.getInt("rankId");
			int relationId = box.getInt(RELATION_ID);
			int sexId = box.getInt(SEX_ID);
			String age = box.getString(AGE);
			String ageUnit = box.getString(AGE_UNIT);
			String appTime = box.getString(APPOINTMENT_TIME);
			String dept = box.getString(DEPARTMENT_NAME);
			int employeeId = box.getInt(DOCTOR_NAME);
			List<PatientAppointment> appointmentList = new ArrayList<PatientAppointment>();
			Criteria crit=null;
			crit = session.createCriteria(PatientAppointment.class).add(Restrictions.eq("Status", "p"));
			if(box.getString("flag").equals("search")){
				crit = crit.add(Restrictions.between("AppointmentDate",fromAppointmentDate,toAppointmentDate));
			}else if(box.getString("flag").equals("appointment")){
				crit = crit.add(Restrictions.eq("AppointmentDate",HMSUtil.convertStringTypeDateToDateType(box.getString(APPOINTMENT_DATE))));
			}
			if(!serviceNo.equals("")){
				crit = crit.add(Restrictions.eq("ServiceNo", serviceNo));
			}
			if(!hin.equals("")){
				crit = crit.createAlias("Hin", "hin").add(Restrictions.eq("hin.HinNo", hin));
			}
			if(!pName.equals("")){
				crit = crit.add(Restrictions.like("PatientName", pName+"%").ignoreCase());
			}
			if(!sName.equals("")){
				crit = crit.add(Restrictions.like("ServPersName", sName+"%").ignoreCase());
			}
			if(!age.equals("")){
				crit = crit.add(Restrictions.like("Age", age+" "+ageUnit));
			}
			if(!appTime.equals("")){
				crit = crit.add(Restrictions.like("AppointmentTime", appTime));
			}
			if(!dept.equals("")){
				crit = crit.add(Restrictions.like("Department", dept));
			}
			if(rankId!=0){
				crit = crit.createAlias("Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
			}
			if(relationId!=0){
				crit = crit.createAlias("Relation", "relation").add(Restrictions.eq("relation.Id", relationId));
			}
			if(sexId!=0){
				crit = crit.createAlias("Sex", "sex").add(Restrictions.eq("sex.Id", sexId));
			}
			if(employeeId!=0){
				crit = crit.createAlias("MedicalOfficer", "mo").add(Restrictions.eq("mo.Id", employeeId));
			}
			appointmentList =crit.list();
			map.put("appointmentList", appointmentList);
			return map;
		}

		@Override
		public boolean submitMLCDetails(Box box) {
			boolean mlcFlag = false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			try {
				MlcCase mlcCase = new MlcCase();
				if(box.getInt(HIN_ID)!=0){
					Patient patient = new Patient();
					patient.setId(box.getInt(HIN_ID));
					mlcCase.setHin(patient);
				}
				if(box.getInt(INPATIENT_ID)!=0){
					Inpatient inpatient = new Inpatient();
					inpatient.setId(box.getInt(INPATIENT_ID));
					mlcCase.setInpatient(inpatient);
				}
				
				mlcCase.setMlcNo(box.getString(MLC_NO));
				if(!box.getString("arrivalDate").equals(""))
					mlcCase.setArrivalDate(HMSUtil.convertStringTypeDateToDateType(box.getString("arrivalDate")));
				mlcCase.setArrivalTime(box.getString("arrivalTime"));
				mlcCase.setBroughtBy(box.getString(BROUGHT_BY));
				mlcCase.setNatureOfMlc(box.getString(NATURE_OF_MLC));
				if(box.getInt(INJURY_NATURE_ID)!=0){
					MasInjuryNature injuryNature = new MasInjuryNature();
					injuryNature.setId(box.getInt(INJURY_NATURE_ID));
					mlcCase.setInjuryNature(injuryNature);
				}
				mlcCase.setTypeOfInjury(box.getString(INJURY_TYPE));
				mlcCase.setPoliceDocketNo(box.getString("policeDocketNo"));
				mlcCase.setConstableName(box.getString("constableName"));
				mlcCase.setConstableNo(box.getString("constableNo"));
				mlcCase.setIdMark1(box.getString("idMark1"));
				mlcCase.setIdMark2(box.getString("idMark2"));
				mlcCase.setItemDeposited(box.getString("itemDeposited"));
				mlcCase.setItemDetails(box.getString("itemDetails"));
				mlcCase.setKitDeposited(box.getString("kitDeposited"));
				mlcCase.setInjuryPositionHistory(box.getString("injuryPoisonHistory"));
				mlcCase.setInjuryNomenclature(box.getString("injuryNomenclature"));
				mlcCase.setWeaponUsed(box.getString("weaponUsed"));
				mlcCase.setCaseSummary(box.getString("caseSummary"));
				mlcCase.setInjuryDescription(box.getString("injuryDescription"));
				mlcCase.setDisposal(box.getString("disposal"));
				mlcCase.setAgencyInformed(box.getString("agencyInformed"));
				mlcCase.setPoliceStation(box.getString(POLICE_STATION));
				if(!box.getString("sentDate").equals(""))
					mlcCase.setSentDate(HMSUtil.convertStringTypeDateToDateType(box.getString("sentDate")));
				mlcCase.setSentTime(box.getString("sentTime"));
				Users user = new Users();
				user.setId(box.getInt("userId"));
				mlcCase.setLastChgBy(user);
				mlcCase.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				mlcCase.setLastChgTime(box.getString(CHANGED_TIME));
				if(box.getInt("hospitalId")!=0){
					MasHospital hospital = new MasHospital();
					hospital.setId(box.getInt("hospitalId"));
					mlcCase.setHospital(hospital);
				}
				hbt.save(mlcCase);
				mlcFlag = true;
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			return mlcFlag;
		}

		@Override
		public Map<String, Object> getPatientNamesForApp(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			String serviceNo = box.getString("serviceNo");
			List<Patient> patientList = new ArrayList<Patient>();
			Session session = getSession();
			patientList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo)).add(Restrictions.eq("PatientStatus", "Out Patient")).list();
			map.put("patientList", patientList);
			return map;
		}

		@Override
		public Map<String, Object> getPatientDetailsForApp(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Patient> patientList = new ArrayList<Patient>();
			int hinId = box.getInt("hinId");
			Session session = getSession();
			patientList = session.createCriteria(Patient.class).add(Restrictions.idEq(hinId)).list();
			map.put("patientList", patientList);
			return map;
		}

		@Override
		public Map<String, Object> showIpAdmissionRegisterGraph(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session)getSession();
			List<Object[]> ipRegisterList = new ArrayList<Object[]>();
			String qryStr = "";
			String subqryStr = "";
			if(box.getInt(SERVICE_TYPE_ID)!=0){
				qryStr += " and patient.service_type_id = :serviceType";
				subqryStr += " and p.service_type_id = :serviceType";
			}
			if(box.getInt(SERVICE_STATUS_ID)!=0){
				qryStr += " and patient.service_status_id =  :serviceStatus";
				subqryStr += " and p.service_status_id =  :serviceStatus";
			}
			if(box.getInt("fromRankId")!=0 && box.getInt("toRankId")!=0){
				qryStr += " and patient.rank_id between :fromRank and :toRank";
				subqryStr += " and p.rank_id between :fromRank and :toRank";
			}
			if(box.getInt(RANK_CATEGORY_ID)!=0){
				qryStr += " and mas_rank.rank_category_id =:rankCat";
				subqryStr += " and mr.rank_category_id =:rankCat";
			}
			if(box.getInt(TRADE_ID)!=0){
				qryStr += " and patient.trade_id = :trade";
				subqryStr += " and p.trade_id = :trade";
			}
			if(box.getInt(UNIT_ID)!=0){
				qryStr += " and patient.unit_id = :unit";
				subqryStr += " and p.unit_id = :unit";
			}
			if(box.getInt(SECTION_ID)!=0){
				qryStr += " and patient.section_id =  :section";
				subqryStr += " and p.section_id =  :section";
			}
			if(box.getInt(MARITAL_STATUS_ID)!=0){
				qryStr += " and patient.marital_status_id =:mrStatus";
				subqryStr += " and p.marital_status_id =:mrStatus";
			}
			if(box.getInt(SEX_ID)!=0){
				qryStr += " and patient.sex_id =:sex";
				subqryStr += " and p.sex_id =:sex";
			}
			if (!(box.getString(SERVICE_NO).equals(""))) {
				qryStr += " and patient.service_no=:srNo";
				subqryStr += " and p.service_no=:srNo";
			}
			if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
					&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
				String fromAge = box.getString("fromAge");
				String toAge = box.getString("toAge");
			//	qry += " and patient.age>='"+fromAge+"' and patient.age<='"+toAge+"'";
				qryStr +=" and substr(patient.age,0,INSTR(patient.age,' ')) >=:fromDate " +
						" and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))=:fromAgeUnit" +
						" and substr(patient.age,0,INSTR(patient.age,' ')) <=:toAge " +
						" and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))=:toAgeUnit";
				subqryStr +=" and substr(p.age,0,INSTR(p.age,' ')) >=:fromDate " +
				" and  substr(p.age,INSTR(p.age,' ')+1,length(p.age))=:fromAgeUnit" +
				" and substr(p.age,0,INSTR(p.age,' ')) <=:toAge" +
				" and  substr(p.age,INSTR(p.age,' ')+1,length(p.age))=:toAgeUnit";
				
			}
			if (!(box.getString("fromServ").equals("")) && !(box.getString("fromServUnit").equals(""))
					&& !(box.getString("toServ").equals("")) && !(box.getString("toServUnit").equals(""))) {
				String fromServ = box.getString("fromServ");
				String toServ = box.getString("toServ");
				qryStr +=" and patient.service_years >=:fromServ " +
					" and  total_service_period=:fromServUnit" +
					" and patient.service_years <=:toServ" +
					" and  total_service_period=:toServUnit";
		
				subqryStr +=" and p.service_years >=:fromServ  " +
				" and  total_service_period=:fromServUnit" +
				" and p.service_years <=:toServ" +
				" and  total_service_period=:toServUnit";
				
			}
			if (!(box.getString("fromAdNo").equals(""))) {
				qryStr += " and inpatient.ad_no =:fromAdNo";
				subqryStr += " and i.ad_no =:fromAdNo";
			}
			if(box.getInt(CONSULTING_DOCTOR)!=0){
				qryStr += " and inpatient.doctor_id =  :doctor";
				subqryStr += " and i.doctor_id =  :doctor";
			}
			if (!(box.getString("icd").equals(""))) {
				String icd = box.getString("icd");
				 int index1=icd.lastIndexOf("[");
				  int index2=icd.lastIndexOf("]");
				   index1++;
				/*   String icdCode =""+icd.substring(index1, index2);
				qryStr += " and icd.icd_code='"+icdCode+"'";
				subqryStr += " and ic.icd_code='"+icdCode+"'";*/
				   int icdCode =Integer.parseInt(""+icd.substring(index1, index2));
					qryStr += " and icd.icd_id="+icdCode+"";
					subqryStr += " and ic.icd_id="+icdCode+"";
			}
			/*if (!(box.getString("icdNo").equals(""))) {
				qryStr += " and icd.icd_code=:icdCode";
				subqryStr += " and ic.icd_code=:icdCode";
			}*/
			if ((box.getInt("icdId")!=0)) {
				qryStr += " and icd.icd_id=:icdCode";
				subqryStr += " and ic.icd_id=:icdCode";
			}
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			String qry = "";
			String fromDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
			String toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
			qry = "SELECT distinct inpatient.date_of_addmission as admission_date," +
				" (select count(*) from inpatient i left join patient p on i.hin_id=p.hin_id" +
				" left join mas_rank mr on p.rank_id=mr.rank_id " +
				" left outer join discharge_icd_code d on i.inpatient_id=d.inpatient_id" +
				" left outer join mas_icd ic on d.icd_id=ic.icd_id"+
				" where date_of_addmission between :fromDate and :toDate  " +
				" and date_of_addmission=inpatient.date_of_addmission and p.service_type_id=1 " +
				" and i.hospital_id="+ box.getInt("hospitalId")+" " +subqryStr+
				" group by date_of_addmission ) as army," +
				" (select count(*)  from inpatient i left join patient p on i.hin_id=p.hin_id" +
				" left join mas_rank mr on p.rank_id=mr.rank_id " +
				" left outer join discharge_icd_code d on i.inpatient_id=d.inpatient_id" +
				" left outer join mas_icd ic on d.icd_id=ic.icd_id"+
				" where date_of_addmission between :fromDate and :toDate  " +
				" and date_of_addmission=inpatient.date_of_addmission and p.service_type_id=2 " +
				" and i.hospital_id="+ box.getInt("hospitalId")+" " +subqryStr+
				" group by date_of_addmission ) as airforce," +
				" (select count(*)  from inpatient i left join patient p on i.hin_id=p.hin_id" +
				" left join mas_rank mr on p.rank_id=mr.rank_id " +
				" left outer join discharge_icd_code d on i.inpatient_id=d.inpatient_id" +
				" left outer join mas_icd ic on d.icd_id=ic.icd_id"+
				" where date_of_addmission between :fromDate and :toDate  " +
				"  and date_of_addmission=inpatient.date_of_addmission and p.service_type_id=4 " +
				" and i.hospital_id="+ box.getInt("hospitalId")+" " +subqryStr+
				" group by date_of_addmission ) as coastguard," +
				" (select count(*)  from inpatient i left join patient p on i.hin_id=p.hin_id" +
				" left join mas_rank mr on p.rank_id=mr.rank_id " +
				" left outer join discharge_icd_code d on i.inpatient_id=d.inpatient_id" +
				" left outer join mas_icd ic on d.icd_id=ic.icd_id"+
				" where date_of_addmission between :fromDate and :toDate  " +
				" and date_of_addmission=inpatient.date_of_addmission and p.service_type_id=7 " +
				" and i.hospital_id="+ box.getInt("hospitalId")+" " +subqryStr+
				" group by date_of_addmission ) as NE," +
				" (select count(*)  from inpatient i left join patient p on i.hin_id=p.hin_id" +
				" left join mas_rank mr on p.rank_id=mr.rank_id " +
				" left outer join discharge_icd_code d on i.inpatient_id=d.inpatient_id" +
				" left outer join mas_icd ic on d.icd_id=ic.icd_id"+
				" where date_of_addmission between :fromDate and :toDate  " +
				" and date_of_addmission=inpatient.date_of_addmission and p.service_type_id=41 " +
				" and i.hospital_id="+ box.getInt("hospitalId")+" " +subqryStr+
				" group by date_of_addmission ) as oth" +
				" FROM patient patient right JOIN inpatient inpatient ON patient.hin_id = inpatient.hin_id" +
				" LEFT OUTER JOIN mas_service_type st ON patient.service_type_id = st.service_type_id" +
				" left join mas_rank mas_rank on patient.rank_id=mas_rank.rank_id " +
				" left outer join discharge_icd_code dic on inpatient.inpatient_id=dic.inpatient_id" +
				" left outer join mas_icd icd on dic.icd_id=icd.icd_id"+
				" where inpatient.date_of_addmission between :fromDate and :toDate   " +
				" and inpatient.hospital_id="+ box.getInt("hospitalId")+" " +qryStr+
				" order by inpatient.date_of_addmission asc";
			
			
			SQLQuery sqlQry = session.createSQLQuery(qry);
			sqlQry.setParameter("fromDate", fromDate);
			sqlQry.setParameter("toDate", toDate);
			
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
			
			/*if (!(box.getString("icdNo").equals(""))) {
				sqlQry.setString("icdCode", box.getString("icdNo"));
			}*/
			if ((box.getInt("icdId")!=0)) {
				sqlQry.setParameter("icdCode",box.getInt("icdId"));
			}
			if (!(box.getString("fromAdNo").equals(""))) {
				sqlQry.setString("fromAdNo", box.getString("fromAdNo"));
			}
			ipRegisterList = sqlQry.list();
			map.put("ipRegisterList", ipRegisterList);
			return map;
		}

		@Override
		public Map<String, Object> showIPRegisterOnScreen(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session)getSession();
			List<Object[]> ipRegisterList = new ArrayList<Object[]>();
			String qryStr = "";
			if(box.getInt(SERVICE_TYPE_ID)!=0){
				qryStr += " and patient.service_type_id = :serviceType";
			}
			if(box.getInt(SERVICE_STATUS_ID)!=0){
				qryStr += " and patient.service_status_id =  :serviceStatus";
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
				qryStr += " and patient.section_id =  :section";
			}
			if(box.getInt(MARITAL_STATUS_ID)!=0){
				qryStr += " and patient.marital_status_id =:mrStatus";
			}
			if(box.getInt(SEX_ID)!=0){
				qryStr += " and patient.sex_id =:sex";
			}
			if (!(box.getString(SERVICE_NO).equals(""))) {
				qryStr += " and patient.service_no=:srNo";
			}
			if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
					&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
				String fromAge = box.getString("fromAge");
				String toAge = box.getString("toAge");
			//	qry += " and patient.age>='"+fromAge+"' and patient.age<='"+toAge+"'";
				qryStr +=" and substr(patient.age,0,INSTR(patient.age,' ')) >=:fromDate " +
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
			if (!(box.getString("fromAdNo").equals(""))) {
				qryStr += " and inpatient.ad_no =:fromAdNo";
			}
			if(box.getInt(CONSULTING_DOCTOR)!=0){
				qryStr += " and inpatient.doctor_id =  :doctor";
			}
			if (!(box.getString("icd").equals(""))) {
				String icd = box.getString("icd");
				 int index1=icd.lastIndexOf("[");
				  int index2=icd.lastIndexOf("]");
				   index1++;
				  /* String icdCode =""+icd.substring(index1, index2);
				qryStr += " and icd.icd_code='"+icdCode+"'";*/
				   int icdCode =Integer.parseInt(""+icd.substring(index1, index2));
					qryStr += " and icd.icd_id="+icdCode+"";
			}
			/*if (!(box.getString("icdNo").equals(""))) {
				qryStr += " and icd.icd_code=:icdCode";
			}*/
			if ((box.getInt("icdId")!=0)) {
				qryStr += " and icd.icd_id=:icdCode";
			}
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			String qry = "";
			String fromDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
			String toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
			qry = "SELECT distinct inpatient.date_of_addmission as date_of_addmission,patient.service_no AS patient_service_no," +
			" (patient.p_first_name || ' ' || nvl(patient.p_middle_name,'') || ' ' || nvl(patient.p_last_name,''))AS patientName," +
			"  mas_relation.relation_name AS mas_relation_relation_name," +
			" mas_rank.rank_name AS mas_rank_rank_name,"+
			" (patient.s_first_name || ' ' || nvl(patient.s_middle_name,'')  || ' ' || nvl(patient.s_last_name,''))AS servicePersonName," +
			"  mas_unit.unit_name as unit_name," +
			" inpatient.ad_no as adno," +
			"  inpatient.init_diagnosis AS diagnosis, "+
			" inpatient.time_of_addmission as time_of_addmission"+
			" FROM " +
			" patient patient right JOIN inpatient inpatient ON patient.hin_id = inpatient.hin_id" +
			" LEFT OUTER JOIN mas_rank mas_rank ON patient.rank_id = mas_rank.rank_id" +
			" LEFT OUTER JOIN mas_unit mas_unit ON patient.unit_id = mas_unit.unit_id " +
			" LEFT OUTER JOIN mas_relation mas_relation ON patient.relation_id = mas_relation.relation_id" +
			" left outer join mas_hospital hospital on patient.hospital_id=hospital.hospital_id" +
			" left outer join mas_employee mas_employee on inpatient.doctor_id=mas_employee.employee_id" +
			" left outer join discharge_icd_code dic on inpatient.inpatient_id=dic.inpatient_id" +
			" left outer join mas_icd icd on dic.icd_id=icd.icd_id"+
			" where inpatient.date_of_addmission between :fromDate and :toDate " +
			" and inpatient.hospital_id="+ box.getInt("hospitalId")+" " +qryStr+
			" order by inpatient.date_of_addmission asc";
			
			SQLQuery sqlQry = session.createSQLQuery(qry);
			sqlQry.setParameter("fromDate", fromDate);
			sqlQry.setParameter("toDate", toDate);
			
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
			
		/*	if (!(box.getString("icdNo").equals(""))) {
				sqlQry.setString("icdCode", box.getString("icdNo"));
			}*/
			if ((box.getInt("icdId")!=0)) {
				sqlQry.setParameter("icdCode",box.getInt("icdId"));
			}
			if (!(box.getString("fromAdNo").equals(""))) {
				
				sqlQry.setParameter("fromAdNo",box.getString("fromAdNo"));
			}
			ipRegisterList =sqlQry.list();
			map.put("ipRegisterList", ipRegisterList);
			return map;
		}


		public Map<String, Object> getBedStatus(Box box) {
			List<MasBed> masBedList = new ArrayList<MasBed>();
			Map<String, Object> map = new HashMap<String, Object>();
			int hospitalId = 0;
			hospitalId =box.getInt("hospitalId");
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				int deptId = box.getInt("wardId");
				int fromBedId = box.getInt("fromBedId");
				Session session = (Session) getSession();
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);			
				
				int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));				
				masBedList = session.createCriteria(MasBed.class).add(
						Restrictions.eq("Department.Id", deptId)).add(
						Restrictions.eq("BedStatus.Id", bedStatusUnOccupiedId))
						.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
				MasBed fromMB = (MasBed)session.get(MasBed.class, fromBedId);
				if(fromMB !=null)
				{
					masBedList.add(fromMB);
				}
				map.put("masBedList", masBedList);
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return map;
		}
	
		public Map<String, Object> cancelAdmission(Map<String, Object> dataMap) {	
			Map<String,Object> map = new HashMap<String,Object>();
			Session	 session=(Session)getSession();
			Transaction tx=session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
	
			List<Visit> patientList = new ArrayList<Visit>();
			
			boolean result= false;
			Criteria crt=null;
			int hospitalId = (Integer)dataMap.get("hospitalId");
			int opdPatientDtId = (Integer)dataMap.get("id");
			
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			OpdPatientDetails opdPDetails = (OpdPatientDetails)hbt.get(OpdPatientDetails.class,opdPatientDtId);
			String currentTime= HMSUtil.currentTime();
					if(opdPDetails != null)
					{			
						    opdPDetails.setAdmissionAdvised("X");
							hbt.update(opdPDetails);
							result= true;
						tx.commit();
					}
					map.put("result", result);
					return map;
			}
}

