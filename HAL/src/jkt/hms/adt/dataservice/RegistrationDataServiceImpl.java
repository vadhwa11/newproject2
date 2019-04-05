/**
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * RegistrationDataServiceImpl.java –
 * Purpose of the class - This is for Registration, Visit Module.
 * It contains Registration and Visit of the patient.
 * @author  Ritu Sahu
 * Create Date: 3rd Jan,2008
 * Revision Date:
 * Revision By: Purpose
 * @version 1.0
 **/

package jkt.hms.adt.dataservice;

import static jkt.hms.util.RequestConstants.ACTION_TAKEN;
import static jkt.hms.util.RequestConstants.AGE;
import static jkt.hms.util.RequestConstants.AIRCRAFT_TYPE_ID;
import static jkt.hms.util.RequestConstants.AMBULANCE_RUN_DATE;
import static jkt.hms.util.RequestConstants.AMBULANCE_RUN_TIME;
import static jkt.hms.util.RequestConstants.ATTENDED_TIME;
import static jkt.hms.util.RequestConstants.CALL_ATTND_TIME;
import static jkt.hms.util.RequestConstants.CALL_RCD_DATE;
import static jkt.hms.util.RequestConstants.CALL_RCD_TIME;
import static jkt.hms.util.RequestConstants.CALL_SENT_DATE;
import static jkt.hms.util.RequestConstants.CALL_SENT_TIME;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.COMPLAINT_DESC;
import static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DESTINATION;
import static jkt.hms.util.RequestConstants.DIAGNOSIS;
import static jkt.hms.util.RequestConstants.DISPOSAL;
import static jkt.hms.util.RequestConstants.DMO_ATTND_DATE;
import static jkt.hms.util.RequestConstants.EMERGENCY_TYPE;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.FIRST_NAME;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.FROM_SMC;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.ITEM_ID;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_DATE;
import static jkt.hms.util.RequestConstants.LAST_CHANGED_TIME;
import static jkt.hms.util.RequestConstants.LAST_NAME;
import static jkt.hms.util.RequestConstants.LOCATION;
import static jkt.hms.util.RequestConstants.MARITAL_STATUS_ID;
import static jkt.hms.util.RequestConstants.MEDICAL_OFFICER;
import static jkt.hms.util.RequestConstants.MEDICAL_OFFICER_ID;
import static jkt.hms.util.RequestConstants.MIDDLE_NAME;
import static jkt.hms.util.RequestConstants.NAME_OF_MH;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.PILOT;
import static jkt.hms.util.RequestConstants.P_FIRST_NAME;
import static jkt.hms.util.RequestConstants.RANK_CATEGORY_ID;
import static jkt.hms.util.RequestConstants.RANK_ID;
import static jkt.hms.util.RequestConstants.REFERRAL_DATE;
import static jkt.hms.util.RequestConstants.REFERRED_BY;
import static jkt.hms.util.RequestConstants.REFERRED_FOR;
import static jkt.hms.util.RequestConstants.REFER_TO;
import static jkt.hms.util.RequestConstants.REG_DATE;
import static jkt.hms.util.RequestConstants.REG_TIME;
import static jkt.hms.util.RequestConstants.RELATION_ID;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.REPORTED_BY;
import static jkt.hms.util.RequestConstants.REPORTED_DATE;
import static jkt.hms.util.RequestConstants.REPORTED_TIME;
import static jkt.hms.util.RequestConstants.SECTION_ID;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_PERSON_NAME;
import static jkt.hms.util.RequestConstants.SERVICE_STATUS_ID;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID;
import static jkt.hms.util.RequestConstants.SESSION_ID;
import static jkt.hms.util.RequestConstants.SEX;
import static jkt.hms.util.RequestConstants.SEX_ID;
import static jkt.hms.util.RequestConstants.SOURCE_FROM;
import static jkt.hms.util.RequestConstants.STATION_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TRADE_ID;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.VISIT_ID;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.*;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.apache.tools.ant.util.DateUtils;
import org.dcm4che.srom.Request;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v21.segment.EVN;
import ca.uhn.hl7v2.model.v22.segment.NK1;
import ca.uhn.hl7v2.model.v23.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v23.message.ORU_R01;
import ca.uhn.hl7v2.model.v23.segment.MSH;
import ca.uhn.hl7v2.model.v23.segment.ORC;
import ca.uhn.hl7v2.model.v23.segment.PID;
import ca.uhn.hl7v2.model.v23.segment.PV1;
import ca.uhn.hl7v2.model.v23.segment.PV2;
import ca.uhn.hl7v2.model.v23.segment.RXE;
import ca.uhn.hl7v2.model.v25.datatype.*;
import ca.uhn.hl7v2.model.v251.group.RDE_O11_PATIENT;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

public class RegistrationDataServiceImpl extends HibernateDaoSupport implements
		RegistrationDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showRegistrationJsp(int hospitalId) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
	/*	List<Object[]> serviceTypeList = null;
	
		List<Object[]> rankList = null;
		List<Object[]> unitList = null;
		List<Object[]> titleList = null;
		List<Object[]> maritalStatusList = null;
		List<Object[]> othersCategoryList = null;
		List<Object[]> tradeList = null;
	//	List<Object[]> countryList = null;
		List<Object[]> stateList = null;
		List<Object[]> districtList = null;
		List<Object[]> bloodGroupList = null;
		List<Object[]> occupationList = null;
		List<Object[]> employeeList = null;
		
		List<Object[]> serviceStatusList = null;
		List<Object[]> stationList = null;
		List<Object[]> sectionList = null;
		List<Object[]> commandList = null;
		List<MasRecordOfficeAddress> recordOfficeAddressList = null;
		List<Object[]> religionList = null;
		List<PatientFamilyHistory> familyHistoryList = null;
		List<Object[]> categoryList = null;*/
		List<Object[]> sexList = null;
		List<Object[]> relationList = null;
		List<MasDepartment> departmentList = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String departmentTypeCodeForOpd="";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			properties.load(resourcePath.openStream());			 
			departmentTypeCodeForOpd=properties.getProperty("departmentTypeCodeForOpd");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			/*serviceTypeList = hbt.find("select Id,ServiceTypeName from MasServiceType mst where mst.Status='y' order by ServiceTypeName");
			rankList = hbt.find("select Id,RankName,rank.ServiceType.Id, rank.ServiceStatus.Id,rank.HicCode from MasRank as rank  where rank.Status='y'  order by rank.RankName ");
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).createAlias("Station", "station",CriteriaSpecification.LEFT_JOIN).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))
							.add(Projections.property("station.StationName")).add(Projections.property("HicCode"))).addOrder(
					Order.asc("UnitName")).list();
			titleList = hbt.find("select Id,TitleName,TitleCode from MasTitle mt where mt.Status ='y' order by TitleName");
			maritalStatusList = hbt.find("select Id,MaritalStatusName,HicCode from MasMaritalStatus mms where mms.Status='y' order by mms.MaritalStatusName");
			othersCategoryList = hbt.find("select Id,CategoryName,CategoryCode from MasOthersCategory moc where moc.Status='y' order by moc.CategoryName");
			tradeList =hbt.find("select Id,TradeName from MasTrade mt where mt.Status='y' order by mt.TradeName");
		//	countryList = hbt.find("from MasCountry mc where mc.Status='y'");
			stateList = hbt.find("select Id,StateName from MasState ms where ms.Status='y' order by StateName");
			districtList =hbt.find("select  Id, DistrictName,md.State.Id from MasDistrict as md  where md.Status='y' order by md.DistrictName ");
		
			
			occupationList = hbt.find("select Id,OccupationName from MasOccupation as dist order by dist.OccupationName ");
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("EmpCategory", "ec",CriteriaSpecification.LEFT_JOIN).createAlias("Rank", "r")
							.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
							.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("FirstName")).add(Projections.property("MiddleName")).add(Projections.property("LastName"))
									.add(Projections.property("ec.EmpCategoryCode")).add(Projections.property("r.RankName"))
							.add(Projections.property("Department.Id")).add(Projections.property("RoomNo")))
							.addOrder(Order.asc("FirstName")).list();
			bloodGroupList = hbt.find("select Id,BloodGroupName,HicCode from MasBloodGroup as dist where dist.Status='y' order by dist.BloodGroupName");
			religionList = session.createCriteria(MasReligion.class).add(Restrictions.eq("Status", "y"))
					.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("ReligionName"))
							.add(Projections.property("HicCode")))
			.addOrder(Order.asc("ReligionName")).list();
			recordOfficeAddressList = session.createCriteria(MasRecordOfficeAddress.class).add(Restrictions.eq("Status", "y")).list();
			
			sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y"))
						.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
						.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("SectionName")))
						.addOrder(Order.asc("SectionName")).list();
			stationList = hbt.find("select Id,StationName,mas.Command.Id from MasStation mas where mas.Status='y' order by mas.StationName");
			commandList = hbt.find("select Id,CommandName from MasCommand mas where mas.Status='y' order by mas.CommandName");
			serviceStatusList = hbt.find("select Id,ServiceStatusName from MasServiceStatus mss where mss.Status='y' ");
			familyHistoryList = hbt.find("select Id,PatientHistoryName from PatientFamilyHistory mss where mss.Status='y' order by PatientHistoryName");
			categoryList = hbt.find("select Categoryid,Categories from Category c order by Categories");*/
			sexList = hbt.find("Select Id, AdministrativeSexName, AdministrativeSexCode,HicCode from MasAdministrativeSex mas where mas.Status='y' order by AdministrativeSexName");
			relationList =hbt.find("select Id,NewRelationName from MasRelation as mr where mr.Status='y' order by NewRelationName");
			departmentList=session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.DepartmentTypeCode", departmentTypeCodeForOpd))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.addOrder(Order.asc("DepartmentName"))
					.list();
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("departmentList", departmentList);
		map.put("sexList", sexList);
		map.put("relationList", relationList);
	/*	map.put("serviceTypeList", serviceTypeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("maritalStatusList", maritalStatusList);
		map.put("othersCategoryList", othersCategoryList);		
		map.put("tradeList", tradeList);
		map.put("bloodGroupList", bloodGroupList);
		
		map.put("titleList", titleList);
	//	map.put("countryList", countryList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		
		map.put("occupationList", occupationList);
		map.put("employeeList", employeeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("sectionList", sectionList);
		map.put("stationList", stationList);
		map.put("commandList", commandList);
		map.put("recordOfficeAddressList", recordOfficeAddressList);
		map.put("religionList", religionList);
		map.put("familyHistoryList", familyHistoryList);
		map.put("categoryList", categoryList);*/
		

		return map;
	}
	

	@SuppressWarnings("unchecked")
	public Map<String, Object> showRegistrationJspOtherPatient(int hospitalId) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> stateList = null;
		List<Object[]> districtList = null;
		List<Object[]> othersCategoryList = null;
		List<Object[]> religionList = null; 
		List<Object[]> maritalStatusList = null;
		List<Object[]> categoryList = null;
	/*	List<Object[]> serviceTypeList = null;
	
		List<Object[]> rankList = null;
		List<Object[]> unitList = null;
		List<Object[]> titleList = null;
		
		
		List<Object[]> tradeList = null;
	//	List<Object[]> countryList = null;
		
		
		List<Object[]> bloodGroupList = null;
		List<Object[]> occupationList = null;
		List<Object[]> employeeList = null;
		
		List<Object[]> serviceStatusList = null;
		List<Object[]> stationList = null;
		List<Object[]> sectionList = null;
		List<Object[]> commandList = null;
		List<MasRecordOfficeAddress> recordOfficeAddressList = null;
		
		List<PatientFamilyHistory> familyHistoryList = null;
		*/
		List<Object[]> sexList = null;
		List<Object[]> relationList = null;
		List<MasDepartment> departmentList = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String departmentTypeCodeForOpd="";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			properties.load(resourcePath.openStream());			 
			departmentTypeCodeForOpd=properties.getProperty("departmentTypeCodeForOpd");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			/*serviceTypeList = hbt.find("select Id,ServiceTypeName from MasServiceType mst where mst.Status='y' order by ServiceTypeName");
			rankList = hbt.find("select Id,RankName,rank.ServiceType.Id, rank.ServiceStatus.Id,rank.HicCode from MasRank as rank  where rank.Status='y'  order by rank.RankName ");
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).createAlias("Station", "station",CriteriaSpecification.LEFT_JOIN).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))
							.add(Projections.property("station.StationName")).add(Projections.property("HicCode"))).addOrder(
					Order.asc("UnitName")).list();
			titleList = hbt.find("select Id,TitleName,TitleCode from MasTitle mt where mt.Status ='y' order by TitleName");
			
			
			tradeList =hbt.find("select Id,TradeName from MasTrade mt where mt.Status='y' order by mt.TradeName");
		//	countryList = hbt.find("from MasCountry mc where mc.Status='y'");
			
		
			
			occupationList = hbt.find("select Id,OccupationName from MasOccupation as dist order by dist.OccupationName ");
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("EmpCategory", "ec",CriteriaSpecification.LEFT_JOIN).createAlias("Rank", "r")
							.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
							.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("FirstName")).add(Projections.property("MiddleName")).add(Projections.property("LastName"))
									.add(Projections.property("ec.EmpCategoryCode")).add(Projections.property("r.RankName"))
							.add(Projections.property("Department.Id")).add(Projections.property("RoomNo")))
							.addOrder(Order.asc("FirstName")).list();
			bloodGroupList = hbt.find("select Id,BloodGroupName,HicCode from MasBloodGroup as dist where dist.Status='y' order by dist.BloodGroupName");
			
			recordOfficeAddressList = session.createCriteria(MasRecordOfficeAddress.class).add(Restrictions.eq("Status", "y")).list();
			
			sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y"))
						.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
						.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("SectionName")))
						.addOrder(Order.asc("SectionName")).list();
			stationList = hbt.find("select Id,StationName,mas.Command.Id from MasStation mas where mas.Status='y' order by mas.StationName");
			commandList = hbt.find("select Id,CommandName from MasCommand mas where mas.Status='y' order by mas.CommandName");
			serviceStatusList = hbt.find("select Id,ServiceStatusName from MasServiceStatus mss where mss.Status='y' ");
			familyHistoryList = hbt.find("select Id,PatientHistoryName from PatientFamilyHistory mss where mss.Status='y' order by PatientHistoryName");
			*/
			categoryList = hbt.find("select Categoryid,Categories from Category c order by Categories");
			othersCategoryList = hbt.find("select Id,CategoryName,CategoryCode from MasOthersCategory moc where moc.Status='y' order by moc.CategoryName");
			religionList = session.createCriteria(MasReligion.class).add(Restrictions.eq("Status", "y"))
					.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("ReligionName"))
							.add(Projections.property("HicCode")))
			.addOrder(Order.asc("ReligionName")).list();
			stateList = hbt.find("select Id,StateName from MasState ms where ms.Status='y' order by StateName");
			districtList =hbt.find("select  Id, DistrictName,md.State.Id from MasDistrict as md  where md.Status='y' order by md.DistrictName ");
			maritalStatusList = hbt.find("select Id,MaritalStatusName,HicCode from MasMaritalStatus mms where mms.Status='y' order by mms.MaritalStatusName");
			sexList = hbt.find("Select Id, AdministrativeSexName, AdministrativeSexCode,HicCode from MasAdministrativeSex mas where mas.Status='y' order by AdministrativeSexName");
			relationList =hbt.find("select Id,NewRelationName from MasRelation as mr where mr.Status='y' order by NewRelationName");
			departmentList=session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.DepartmentTypeCode", departmentTypeCodeForOpd))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.addOrder(Order.asc("DepartmentName"))
					.list();
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("departmentList", departmentList);
		map.put("sexList", sexList);
		map.put("relationList", relationList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("othersCategoryList", othersCategoryList);	
		map.put("religionList", religionList);
		map.put("maritalStatusList", maritalStatusList);
	/*	map.put("serviceTypeList", serviceTypeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		
			
		map.put("tradeList", tradeList);
		map.put("bloodGroupList", bloodGroupList);
		
		map.put("titleList", titleList);
		map.put("countryList", countryList);
		
		
		map.put("occupationList", occupationList);
		map.put("employeeList", employeeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("sectionList", sectionList);
		map.put("stationList", stationList);
		map.put("commandList", commandList);
		map.put("recordOfficeAddressList", recordOfficeAddressList);
		
		map.put("familyHistoryList", familyHistoryList);
		map.put("categoryList", categoryList);*/
		

		return map;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitPatientInformation(
			Map<String, Object> objectMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	//	boolean addedTrade = false;
		Session session = (Session) getSession();
		List<Visit> visitList = new ArrayList<Visit>();
		int regHinId =0;
		if(objectMap.get("regHinId")!= null){
			regHinId = (Integer)objectMap.get("regHinId");
		}
		int selfRegHin =0;
		if(objectMap.get("selfRegHin")!= null){
			selfRegHin = (Integer)objectMap.get("selfRegHin");
		}
		MasHospital hospital = new MasHospital();
		if(objectMap.get("masHospital")!=null){
			hospital = (MasHospital)objectMap.get("masHospital");
		}
		Users user= new Users();
		if(objectMap.get("user")!=null){
			user = (Users)objectMap.get("user");
		}
		Transaction tx = null;
		Properties properties = new Properties();
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
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			MasCommand masCommand = new MasCommand();
			if (objectMap.get("masCommand") != null) {
				masCommand = (MasCommand) objectMap.get("masCommand");
				hbt.save(masCommand);
				hbt.refresh(masCommand);
			}
			MasStation masStation = new MasStation();
			if (objectMap.get("masStation") != null) {
				masStation = (MasStation) objectMap.get("masStation");
				
				MasCommand mainMasCommand = new MasCommand();
				if(objectMap.get("command") != null)
				{
					mainMasCommand = (MasCommand)objectMap.get("command");
					masStation.setCommand(mainMasCommand);
				}
				else
				{
					masStation.setCommand(masCommand);
					hbt.save(masStation);
					hbt.refresh(masStation);
				}
				
				
			}
			
			int unitId =0;
			MasUnit masUnit = new MasUnit();
			if (objectMap.get("masUnitObj") != null) {
				masUnit = (MasUnit) objectMap.get("masUnitObj");
				System.out.println("masUnit="+masUnit);
				
				
				if(objectMap.get("station") != null)
				{
					String station = (String)objectMap.get("station"); 
					// here station contaimns the string value so we need to extract ID value from the table based on station name
					List<MasStation> listA = new ArrayList<MasStation>();
					Criteria cr = null;
					int nStation = 0;
					cr= session.createCriteria(MasStation.class).add(Restrictions.like("StationName", station)).add(Restrictions.eq("Status", "y").ignoreCase());
					listA= cr.list();
					if(listA.size()>0)
					{
						for(MasStation temp : listA)
						{
							nStation = temp.getId();
						}
					}
					listA.clear();
					
					System.out.println("nStation="+nStation);
					MasStation mainMasStation = new MasStation();
					mainMasStation.setId(nStation);
					masUnit.setStation(mainMasStation);
					hbt.save(masUnit);
					hbt.refresh(masUnit);
					
				}
				else
				{
					if(masStation != null){
						masUnit.setStation(masStation);
						hbt.save(masUnit);
						hbt.refresh(masUnit);
						
					}
				}
				
				
				
				
				unitId = masUnit.getId();
			}
			MasSection masSection = new MasSection();
			if (objectMap.get("masSection") != null) {
				masSection = (MasSection) objectMap.get("masSection");
				
				hbt.save(masSection);
				hbt.refresh(masSection);
			}
			MasTrade masTrade = null;
			if(objectMap.get("masTradeObj")!=null){
				
				masTrade = (MasTrade)objectMap.get("masTradeObj");				
				boolean addedTrade=addTrade(masTrade , masTrade.getTradeName());
			}
			
			String hinNo = "";
			List<Patient> existingHinNoList = new ArrayList<Patient>();

			if (objectMap.get("hinNo") != null) {
				hinNo = (String) objectMap.get("hinNo");
				/*existingHinNoList = hbt
						.find("from jkt.hms.masters.business.Patient p where p.HinNo = '"
								+ hinNo + "'");*/
				existingHinNoList = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", hinNo)).list();
				map.put("existingHinNoList", existingHinNoList);
			}
			List<Integer> sectionList = new ArrayList<Integer>();
			MasSection section = new MasSection();
			List<Integer> commandList = new ArrayList<Integer>();
			List<Integer> unitList = new ArrayList<Integer>();
			List<Integer> tradeList = new ArrayList<Integer>();
			
			if (objectMap.get("masCommand") != null) {
				String qry = "select max(id) from jkt.hms.masters.business.MasCommand mu where mu.CommandName = :command";
				commandList = session.createQuery(qry).setParameter("command", masCommand.getCommandName()).list();
			}
		
			/*if (objectMap.get("masUnitObj") != null) {
				String qry = "select max(id) from jkt.hms.masters.business.MasUnit mu where mu.UnitName = :unit";
				unitList = session.createQuery(qry).setParameter("unit", masUnit.getUnitName()).list();
			
			}*/
			
			if (objectMap.get("masSection") != null) {
				String qry = "select max(id) from jkt.hms.masters.business.MasSection mu where mu.SectionName = :section";
				sectionList = session.createQuery(qry).setParameter("section", masSection.getSectionName()).list();
			
			}
			
			if (objectMap.get("masTradeObj") != null && masTrade!=null) {
				String qry = "select max(mu.Id) from jkt.hms.masters.business.MasTrade mu where mu.TradeName  = :trade";
				tradeList = session.createQuery(qry).setParameter("trade", masTrade.getTradeName()).list();
				
			}
			Patient patient = new Patient();
			if (existingHinNoList.size() == 0) {
				if (objectMap.get("patient") != null && !hinNo.equals("")) {
					patient = (Patient) objectMap.get("patient");
					if (objectMap.get("visitObjList") != null) {
						patient.setCurrentVisitNo(1);
					}else{
						patient.setCurrentVisitNo(0);
					}
					if (commandList.size()>0) {
						MasCommand command = new MasCommand();
						command.setId(commandList.get(0));
						patient.setCommand(command);
					}
				
					if (unitId !=0) {
						MasUnit masUnitObj = new MasUnit();
						masUnitObj.setId(unitId);
						patient.setUnit(masUnitObj);
					}
					
					if (sectionList.size()>0) {
						section.setId(sectionList.get(0));
						patient.setSection(section);
					}
					
					if (tradeList.size()>0) {
						masTrade.setId(tradeList.get(0));
						patient.setTrade(masTrade);
					}
					
					hbt.save(patient);
					hbt.refresh(patient);
				
					String userSrNo = (String)objectMap.get("userSrNo");
					/**
					 * Updating HIC Employee table
					 */
					if(hicDbConfigure.equals("yes")) {
					Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
					conn = DriverManager.getConnection(hicDB, hicUser, hicPwd);
					String procSql = "{ call SMC_HIC_UPDATE_EMPLOYEEINFO (" +
						"?,?,?,?,?,?,?,?)}";
					CallableStatement csstmt = conn.prepareCall(procSql);
					csstmt.setString(1, patient.getServiceNo()  );
					csstmt.setString(2, (patient.getCommand()!=null ? patient.getCommand().getCommandName() :"")  );
					csstmt.setString(3, (patient.getStation() !=null ? patient.getStation() : "") );
					csstmt.setString(4, (patient.getSection() !=null ? patient.getSection().getSectionName() : "") );
					csstmt.setString(5, (patient.getUnit() !=null ? patient.getUnit().getUnitName() : "") );
					csstmt.setString(6, (patient.getRank() !=null ? patient.getRank().getRankName() : "") );
					csstmt.setString(7, (patient.getTrade() !=null ? patient.getTrade().getTradeName() : "") );
					csstmt.setInt(8, Integer.parseInt(userSrNo));
					csstmt.execute();
					}
				}
				String ldapData = "";
				if(objectMap.get("ldapData")!=null){
					ldapData = (String)objectMap.get("ldapData");
				}
				
				int maxHinId = getMaxHinId();
				int currentVisitNo =0;
				if (objectMap.get("visitObjList") != null) {
					List<Visit> visitObjList = new ArrayList<Visit>();
					visitObjList = (List<Visit>)objectMap.get("visitObjList");
					
					for (int i = 0; i < visitObjList.size(); i++) {
							Visit visit = new Visit();
							visit = visitObjList.get(i);
						int token = 0;
						if(visit.getTokenNo() != null){
							token = visit.getTokenNo();
						}
						/*if(objectMap.get("currentVisitNo")!= null){
							currentVisitNo = (Integer)objectMap.get("currentVisitNo");
						}*/
						if(!hinNo.equals("")){
							Patient patientObj = new Patient();
							patientObj.setId(maxHinId);
							visit.setHin(patientObj);
							currentVisitNo = 1;
							visit.setVisitNo(1);
						}else if(hinNo.equals("")){
							Patient patientObj = new Patient();
							if(regHinId != 0){
								patientObj.setId(regHinId);
							}else if(selfRegHin != 0){
								patientObj.setId(selfRegHin);
							}
							visit.setHin(patientObj);
							
							Patient hinPt = new Patient();
							if(selfRegHin != 0 && regHinId == 0)
								hinPt = (Patient)hbt.load(Patient.class, selfRegHin);
							else if(regHinId!=0)
								hinPt = (Patient)hbt.load(Patient.class, regHinId);
							
							currentVisitNo = hinPt.getCurrentVisitNo()+1;
							visit.setVisitNo(currentVisitNo);
						}
						visit.setTokenStatus("n");
						hbt.save(visit);
						
					//	hbt.refresh(visit);
						if(token != 0){
							visitList = session.createCriteria(Visit.class).add(
								Restrictions.eq("TokenNo", token)).add(
								Restrictions.eq("Hin.Id", maxHinId)).list();
						}else{
							visitList = session.createCriteria(Visit.class).add(
									Restrictions.eq("VisitNo", currentVisitNo)).add(
									Restrictions.eq("Hin.Id", maxHinId)).list();
							
						}
					}
				}
				
				/**
				 * Update patient records
				 */
				Patient hin = new Patient();
				if(hinNo.equals("")){
					
					if(selfRegHin != 0 && regHinId == 0)
						hin = (Patient)hbt.load(Patient.class, selfRegHin);
					else if(regHinId!=0)
						hin = (Patient)hbt.load(Patient.class, regHinId);

					/*if(hin.getRelation().getId()==8 && !ldapData.equals("yes")){
						if(objectMap.get("pFirstName")!=null){
							hin.setPFirstName((String)objectMap.get("pFirstName"));
						}
						if(objectMap.get("pMiddleName")!=null){
							hin.setPMiddleName((String)objectMap.get("pMiddleName"));
						}
						if(objectMap.get("pLastName")!=null){
							hin.setPLastName((String)objectMap.get("pLastName"));
						}
						if(objectMap.get("pDob")!=null){
							hin.setDateOfBirth((Date)objectMap.get("pDob"));
						}
					}else if(hin.getRelation().getId()!=8){*/
						if(objectMap.get("pFirstName")!=null){
							hin.setPFirstName((String)objectMap.get("pFirstName"));
						}
						if(objectMap.get("pMiddleName")!=null){
							hin.setPMiddleName((String)objectMap.get("pMiddleName"));
						}
						if(objectMap.get("pLastName")!=null){
							hin.setPLastName((String)objectMap.get("pLastName"));
						}
						if(objectMap.get("pDob")!=null){
							hin.setDateOfBirth((Date)objectMap.get("pDob"));
						}
					//}
					if(objectMap.get("pSex")!=null){
						hin.setSex((MasAdministrativeSex)objectMap.get("pSex"));
					}
					if(objectMap.get("pAge")!=null){
						hin.setAge((String)objectMap.get("pAge"));
					}
					if(objectMap.get("ptMaritalStatus")!=null){
						hin.setMaritalStatus((MasMaritalStatus)objectMap.get("ptMaritalStatus"));
					}
					if(objectMap.get("ptBloodGroup")!=null){
						hin.setBloodGroup((MasBloodGroup)objectMap.get("ptBloodGroup"));
						if(hin.getRelation().getId()==8){
							hin.setSrBloodGroup((MasBloodGroup)objectMap.get("ptBloodGroup"));
						}
					}
						
					if(objectMap.get("masOccupation")!=null){
						hin.setOccupation((MasOccupation)objectMap.get("masOccupation"));
					}
					if(objectMap.get("contactNo")!=null){
						hin.setContactNo((String)objectMap.get("contactNo"));
					}
					if(objectMap.get("afnetNo")!=null){
						hin.setAfnetNo((String)objectMap.get("afnetNo"));
					}
					if(objectMap.get("category")!=null){
						hin.setCategory((Category)objectMap.get("category"));
					}
					if(objectMap.get("medCatPeriod")!=null){
						hin.setMedCatPeriod((String)objectMap.get("medCatPeriod"));
					}
					if(objectMap.get("medCatDate")!=null){
						hin.setMedCatDate((Date)objectMap.get("medCatDate"));
					}
					if(objectMap.get("income")!=null){
						hin.setIncome((String)objectMap.get("income"));
					}
					if(objectMap.get("dependencyDate")!=null){
						hin.setDependencyDate((Date)objectMap.get("dependencyDate"));
					}
					if(objectMap.get("authority")!=null){
						hin.setAuthority((String)objectMap.get("authority"));
					}
					if(objectMap.get("dependencyRemovalDate")!=null){
						hin.setDependencyRemovalDate((Date)objectMap.get("dependencyRemovalDate"));
					}
					if(objectMap.get("masDistrict")!=null){
						hin.setDistrict((MasDistrict)objectMap.get("masDistrict"));
					}
					if(objectMap.get("address")!=null){
						hin.setAddress((String)objectMap.get("address"));
					}
					if(objectMap.get("contactNo")!=null){
						hin.setContactNo((String)objectMap.get("contactNo"));
					}
					if(objectMap.get("otherFamilyHistory")!=null){
						hin.setOtherFamilyHistory((String)objectMap.get("otherFamilyHistory"));
					}
					if(objectMap.get("masState")!=null){
						hin.setState((MasState)objectMap.get("masState"));
					}
					if(objectMap.get("alcohol")!=null){
						hin.setAlcohol((String)objectMap.get("alcohol"));
					}
					if(objectMap.get("policeStation")!=null){
						hin.setPoliceStation((String)objectMap.get("policeStation"));
					}
					if(objectMap.get("pinCode")!=null){
						hin.setPinCode((String)objectMap.get("pinCode"));
					}
					if(objectMap.get("mobileNo")!=null){
						hin.setMobileNumber((String)objectMap.get("mobileNo"));
					}
					if(objectMap.get("smokerLess10")!=null){
						hin.setSmokerLess10((String)objectMap.get("smokerLess10"));
					}
					if(objectMap.get("smokerMore10")!=null){
						hin.setSmokerMore10((String)objectMap.get("smokerMore10"));
					}
					
					if(objectMap.get("allergies")!=null){
						hin.setDrugAllergies((String)objectMap.get("allergies"));
					}else if(objectMap.get("srallergies")!=null){
						hin.setDrugAllergies((String)objectMap.get("srallergies"));
					}
					if(objectMap.get("depMarriageDate")!=null){
						hin.setDepMarriageDate((Date)objectMap.get("depMarriageDate"));
					}
					if(objectMap.get("depIdentificationMark1")!=null){
						hin.setDepIdentificationMark1((String)objectMap.get("depIdentificationMark1"));
					}
					if(objectMap.get("depIdentificationMark2")!=null){
						hin.setDepIdentificationMark2((String)objectMap.get("depIdentificationMark2"));
					}
					if(objectMap.get("nok1Name")!=null){
						hin.setNextOfKinName((String)objectMap.get("nok1Name"));
					}
					if(objectMap.get("nok1Phone")!=null){
						hin.setNextOfKinPhoneNumber((String)objectMap.get("nok1Phone"));
					}
					if(objectMap.get("nok1Address")!=null){
						hin.setNextOfKinAddress((String)objectMap.get("nok1Address"));
					}
					if(objectMap.get("nok1Relation")!=null){
						hin.setNextOfKinRelation((MasRelation)objectMap.get("nok1Relation"));
					}
					if(objectMap.get("nok1PoliceStation")!=null){
						hin.setNok1PoliceStation((String)objectMap.get("nok1PoliceStation"));
					}
					if(objectMap.get("nok1PinCode")!=null){
						hin.setNok1PinCode((String)objectMap.get("nok1PinCode"));
					}

					if(objectMap.get("nok2Name")!=null){
						hin.setNok2Name((String)objectMap.get("nok2Name"));
					}
					if(objectMap.get("nok2Relation")!=null){
						hin.setNok2Relation((MasRelation)objectMap.get("nok2Relation"));
					}
					if(objectMap.get("nok2ContactNo")!=null){
						hin.setNok2ContactNo((String)objectMap.get("nok2ContactNo"));
					}
					if(objectMap.get("nok2Address")!=null){
						hin.setNok2Address((String)objectMap.get("nok2Address"));
					}
					if(objectMap.get("nok2PoliceStation")!=null){
						hin.setNok2PoliceStation((String)objectMap.get("nok2PoliceStation"));
					}
					if(objectMap.get("nok2PinCode")!=null){
						hin.setNok2PinCode((String)objectMap.get("nok2PinCode"));
					}
					if (objectMap.get("visitObjList") != null) {
						currentVisitNo = hin.getCurrentVisitNo()+1;
					}
					hin.setCurrentVisitNo(currentVisitNo);
					hbt.update(hin);
				}
				String userSrNo = (String)objectMap.get("userSrNo");
				if(hicDbConfigure.equals("yes")) {
				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
				conn = DriverManager.getConnection(hicDB, hicUser, hicPwd);
				String procSql = "{ call SMC_HIC_UPDATE_EMPLOYEEINFO (" +
					"?,?,?,?,?,?,?,?)}";
				CallableStatement csstmt = conn.prepareCall(procSql);
				csstmt.setString(1, hin.getServiceNo()  );
				csstmt.setString(2, (hin.getCommand()!=null ? hin.getCommand().getCommandName() :"")  );
				csstmt.setString(3, (hin.getStation() !=null ? hin.getStation() : "") );
				csstmt.setString(4, (hin.getSection() !=null ? hin.getSection().getSectionName() : "") );
				csstmt.setString(5, (hin.getUnit() !=null ? hin.getUnit().getUnitName() : "") );
				csstmt.setString(6, (hin.getRank() !=null ? hin.getRank().getRankName() : "") );
				csstmt.setString(7, (hin.getTrade() !=null ? hin.getTrade().getTradeName() : "") );
				csstmt.setInt(8, Integer.parseInt(userSrNo));
				csstmt.execute();
				}

				/**
				 *  Update All records for service no
				 */
				
				
				List<Patient> listForSrNo = new ArrayList<Patient>();
				listForSrNo = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", hin.getServiceNo())).list();
				if(listForSrNo.size() > 0){
					for (Patient ptObj : listForSrNo) {
						Patient ptUpdateObj = (Patient)hbt.load(Patient.class, ptObj.getId());
						if(objectMap.get("prefix")!=null){
							ptUpdateObj.setPrefix((String)objectMap.get("prefix"));
						}
						if(objectMap.get("suffix")!=null){
							ptUpdateObj.setSuffix((String)objectMap.get("suffix"));
						}
						/**
						 * If data is coming from LDAP then rank,name,trade,dob will not update
						 */
						/**
						 * Commented By Ritu 
						 * Date 19 oct 2012
						 */
					//	if(!ldapData.equalsIgnoreCase("yes")){
							if(objectMap.get("masRank")!=null){
								ptUpdateObj.setRank((MasRank)objectMap.get("masRank"));
							}
							if(objectMap.get("sFirstName")!=null){
								ptUpdateObj.setSFirstName((String)objectMap.get("sFirstName"));
							}
							if(objectMap.get("sMiddleName")!=null){
								ptUpdateObj.setSMiddleName((String)objectMap.get("sMiddleName"));
							}
							if(objectMap.get("sLastName")!=null){
								ptUpdateObj.setSLastName((String)objectMap.get("sLastName"));
							}

							if(objectMap.get("masTrade")!=null){
								ptUpdateObj.setTrade((MasTrade)objectMap.get("masTrade"));
							}
							if(objectMap.get("srDob")!=null){
								ptUpdateObj.setSrDob((Date)objectMap.get("srDob"));
							}
							
							if(objectMap.get("masTrade")!=null){
								ptUpdateObj.setTrade((MasTrade)objectMap.get("masTrade"));
							}else if(tradeList.size()>0){
								MasTrade trd = new MasTrade();
								trd.setId(tradeList.get(0));
								ptUpdateObj.setTrade(trd); // For new Trade. added from registration
							}
					//	}
							if(ptUpdateObj.getRelation().getId()==8){
								if(objectMap.get("srallergies")!=null){
									ptUpdateObj.setDrugAllergies((String)objectMap.get("srallergies"));
								}
							}
						if(objectMap.get("masRecordOfficeAddress")!=null){
							ptUpdateObj.setRecordOfficeAddress((MasRecordOfficeAddress)objectMap.get("masRecordOfficeAddress"));
						}
						if(objectMap.get("masUnit")!=null){
							ptUpdateObj.setUnit((MasUnit)objectMap.get("masUnit"));
						}else if(unitList.size()>0){
							MasUnit unit = new MasUnit();
							unit.setId(unitList.get(0));
							ptUpdateObj.setUnit(unit); // For new unit. added from registration
						}
						if(objectMap.get("command")!=null){
							ptUpdateObj.setCommand((MasCommand)objectMap.get("command"));
						}else if(commandList.size()>0){
							MasCommand cmd = new MasCommand();
							cmd.setId(commandList.get(0));
							ptUpdateObj.setCommand(cmd); // For new Command. added from registration
						}
						if(objectMap.get("commisionDate")!=null){
							ptUpdateObj.setCommissionDate((Date)objectMap.get("commisionDate"));
						}
						if(objectMap.get("totalService")!=null){
							ptUpdateObj.setServiceYears((Float)objectMap.get("totalService"));
						}
						if(objectMap.get("station")!=null){
							ptUpdateObj.setStation((String)objectMap.get("station"));
						}else if(objectMap.get("masStation")!=null){
							ptUpdateObj.setStation(((MasStation)objectMap.get("masStation")).getStationName()); // For new Station. added from registration
						}
						if(objectMap.get("srSex")!=null){
							ptUpdateObj.setSrSex((MasAdministrativeSex)objectMap.get("srSex"));
						}
						if(objectMap.get("srAge")!=null){
							ptUpdateObj.setSrAge((String)objectMap.get("srAge"));
						}
						if(objectMap.get("maritalStatus")!=null){
							ptUpdateObj.setSrMaritalStatus((MasMaritalStatus)objectMap.get("maritalStatus"));
						}
						if(objectMap.get("section")!=null){
							ptUpdateObj.setSection((MasSection)objectMap.get("section"));
						}else if(sectionList.size() >0){
							MasSection sec = new MasSection();
							sec.setId(sectionList.get(0));
							ptUpdateObj.setSection(sec); // For new section. added from registration
						}
						
						if(objectMap.get("srBloodGroup")!=null){
							hin.setSrBloodGroup((MasBloodGroup)objectMap.get("srBloodGroup"));
						}
						if(objectMap.get("telephoneNo")!=null){
							ptUpdateObj.setPhoneNumber((String)objectMap.get("telephoneNo"));
						}
						/*if(objectMap.get("masState")!=null){
							ptUpdateObj.setState((MasState)objectMap.get("masState"));
						}*/
														
						if(objectMap.get("masReligion")!=null){
							ptUpdateObj.setReligion((MasReligion)objectMap.get("masReligion"));
						}
						if(objectMap.get("permanentAddress")!=null){
							ptUpdateObj.setPermanentAddress((String)objectMap.get("permanentAddress"));
						}
						
						if(objectMap.get("telephoneResi")!=null){
							ptUpdateObj.setTelephoneResi((String)objectMap.get("telephoneResi"));
						}
						if(objectMap.get("permanentCity")!=null){
							ptUpdateObj.setPermanentCity((MasDistrict)objectMap.get("permanentCity"));
						}
						if(objectMap.get("permanentState")!=null){
							ptUpdateObj.setPermanentState((MasState)objectMap.get("permanentState"));
						}
						if(objectMap.get("telephoneNoPerm")!=null){
							ptUpdateObj.setTelephoneNoPerm((String)objectMap.get("telephoneNoPerm"));
						}
						if(objectMap.get("otherContactNo")!=null){
							ptUpdateObj.setOtherContactNo((String)objectMap.get("otherContactNo"));
						}
						if(objectMap.get("srMarriageDate")!=null){
							ptUpdateObj.setSrMarriageDate((Date)objectMap.get("srMarriageDate"));
						}
						if(objectMap.get("identificationMark1")!=null){
							ptUpdateObj.setSrIdentificationMark1((String)objectMap.get("identificationMark1"));
						}
						if(objectMap.get("identificationMark2")!=null){
							ptUpdateObj.setSrIdentificationMark2((String)objectMap.get("identificationMark2"));
						}
						hbt.update(ptUpdateObj);
					}
				}
				/**
				 * 
				 */
				
					
					/**
					 * Immunization
					 */
					List<Integer> immuDtIdList  = new ArrayList<Integer>();
					List<String> immuNameList  = new ArrayList<String>();
					List<String> dateList  = new ArrayList<String>();
					List<String> doseList  = new ArrayList<String>();
					List<String> routeList  = new ArrayList<String>();
					List<String> batchNoList  = new ArrayList<String>();
					List<String> domList  = new ArrayList<String>();
					List<String> doeList  = new ArrayList<String>();
				//	List<Integer> immunizationIdList = new ArrayList<Integer>();
					
					if(objectMap.get("immuDtIdList")!=null){
						immuDtIdList = (List<Integer>)objectMap.get("immuDtIdList");
					}
					/*if(objectMap.get("immunizationIdList")!=null){
						immunizationIdList = (List<Integer>)objectMap.get("immunizationIdList");
					}*/
					if(objectMap.get("immuNameList")!=null){
						immuNameList = (List<String>)objectMap.get("immuNameList");
					}
					if(objectMap.get("dateList")!=null){
						dateList = (List<String>)objectMap.get("dateList");
					}
					if(objectMap.get("doseList")!=null){
						doseList = (List<String>)objectMap.get("doseList");
					}
					if(objectMap.get("routeList")!=null){
						routeList = (List<String>)objectMap.get("routeList");
					}
					if(objectMap.get("batchNoList")!=null){
						batchNoList = (List<String>)objectMap.get("batchNoList");
					}
					if(objectMap.get("domList")!=null){
						domList = (List<String>)objectMap.get("domList");
					}
					if(objectMap.get("doeList")!=null){
						doeList = (List<String>)objectMap.get("doeList");
					}
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
					String time = (String) utilMap.get("currentTimeWithoutSc");
					if(immuNameList.size() > 0){
						int hinIdToDelete = 0;
						Patient patientObj = new Patient();
						if(!hinNo.equals("")){
							patientObj.setId(maxHinId);
							hinIdToDelete= maxHinId;
						}else if(hinNo.equals("")){
							if(regHinId != 0){
								patientObj.setId(regHinId);
								hinIdToDelete= regHinId;
							}else if(selfRegHin != 0){
								patientObj.setId(selfRegHin);
								hinIdToDelete= selfRegHin;
							}
						}
						Query query = session.createQuery("delete from PatientImmunizationDetails where Hin.Id="+hinIdToDelete);
						query.executeUpdate();
						
						for (int i = 0; i < immuNameList.size(); i++) {
							if(!immuNameList.get(i).equals("")){
								PatientImmunizationDetails immunizationDetails = new PatientImmunizationDetails();
								
								immunizationDetails.setHin(patientObj);
								immunizationDetails.setHospital(hospital);
								/*if(immunizationIdList.get(i)!=0){
								MasImmunization immunization = new MasImmunization();
								immunization.setId(immunizationIdList.get(i));
								immunizationDetails.setImmunization(immunization);
								}*/
								immunizationDetails.setImmunizationDetail(immuNameList.get(i));
								immunizationDetails.setDose(doseList.get(i));
								immunizationDetails.setRoute(routeList.get(i));
								immunizationDetails.setBatchNo(batchNoList.get(i));
								if(!dateList.get(i).equals(""))
									immunizationDetails.setImmunizationDate(HMSUtil.convertStringTypeDateToDateType(dateList.get(i)));
								if(!domList.get(i).equals(""))
									immunizationDetails.setDom(HMSUtil.convertStringTypeDateToDateType(domList.get(i)));
								if(!doeList.get(i).equals(""))
									immunizationDetails.setDoe(HMSUtil.convertStringTypeDateToDateType(doeList.get(i)));
							//	immunizationDetails.setRemarks(remarksList.get(i));
								immunizationDetails.setLastChgBy(user);
								immunizationDetails.setLastChgDate(new Date());
								immunizationDetails.setLastChgTime(time);
								hbt.save(immunizationDetails);
								
							}
						}
					}
					
					/**
					 * End Immunization
					 */
					
				/**
				 * Allergy Details
				 */
					int consultingDoctorId = 0;
					if(objectMap.get("consultingDoctorId")!=null){
						consultingDoctorId = (Integer)objectMap.get("consultingDoctorId");
					}
				List<Integer> allergyDetailsIdList  = new ArrayList<Integer>();
				List<String> allergyNameList  = new ArrayList<String>();
				List<String> descList  = new ArrayList<String>();
				List<String> severityList  = new ArrayList<String>();
				List<String> sinceList  = new ArrayList<String>();
				List<String> remarksList  = new ArrayList<String>();
				
				if(objectMap.get("allergyDetailsIdList")!=null){
					allergyDetailsIdList = (List<Integer>)objectMap.get("allergyDetailsIdList");
				}
				if(objectMap.get("allergyNameList")!=null){
					allergyNameList = (List<String>)objectMap.get("allergyNameList");
				}
				if(objectMap.get("descList")!=null){
					descList = (List<String>)objectMap.get("descList");
				}
				if(objectMap.get("severityList")!=null){
					severityList = (List<String>)objectMap.get("severityList");
				}
				if(objectMap.get("sinceList")!=null){
					sinceList = (List<String>)objectMap.get("sinceList");
				}
				if(objectMap.get("remarksList")!=null){
					remarksList = (List<String>)objectMap.get("remarksList");
				}
				if(allergyNameList.size() > 0){
					
					for (int i = 0; i < allergyNameList.size(); i++) {
						if(allergyDetailsIdList.get(i)==0 && !allergyNameList.get(i).equals("")){
							AllergyDetail allergyDetail = new AllergyDetail();
							
							//MasAllergyType masAllergyType = new MasAllergyType();
							
							//masAllergyType.setId(allergyTypeIdList.get(i));
							//allergyDetail.setAllergyType(masAllergyType);
							allergyDetail.setAllergyName(allergyNameList.get(i));
							allergyDetail.setDescription(descList.get(i));
							allergyDetail.setRemarks(remarksList.get(i));
							allergyDetail.setSeverity(severityList.get(i));
							allergyDetail.setSince(sinceList.get(i));
							
							Patient patientObj = new Patient();
							if(!hinNo.equals("")){
								patientObj.setId(maxHinId);
							}else if(hinNo.equals("")){
								if(regHinId != 0){
									patientObj.setId(regHinId);
								}else if(selfRegHin != 0){
									patientObj.setId(selfRegHin);
								}
							}
							allergyDetail.setHin(patientObj);
							allergyDetail.setHospital(hospital);
							allergyDetail.setStatus("y");
							MasEmployee medicalOfficer =new MasEmployee();
							medicalOfficer.setId(consultingDoctorId);
							allergyDetail.setMedicalOfficer(medicalOfficer);		
							allergyDetail.setLastChgBy(user);
							allergyDetail.setLastChgDate(new Date());
							allergyDetail.setLastChgTime(time);
							hbt.save(allergyDetail);
							
						}
					}
				}
				String[] familyHistoryArray = null;
				if(objectMap.get("familyHistoryArray")!=null) {
					familyHistoryArray = (String[])objectMap.get("familyHistoryArray");
				}
				if(familyHistoryArray!=null && familyHistoryArray.length > 0) {
					int hinId = 0;
					if(!hinNo.equals("")){
						hinId = maxHinId;
					}else if(hinNo.equals("")){
						if(regHinId != 0){
							hinId=regHinId;
						}else if(selfRegHin != 0){
							hinId = selfRegHin;
						}
					}
					Query query = session.createQuery("delete from MasMedicalExamFamilyHis where Hin.Id="+hinId);
					query.executeUpdate();
					
					
					for (int i = 0; i < familyHistoryArray.length; i++) {
						if(Integer.parseInt(""+familyHistoryArray[i])!=0){
							//existingFamilyHis = session.createCriteria(MasMedicalExamFamilyHis.class).createAlias("Hin", "h").add(Restrictions.eq("h.Id", hinId)).createAlias("PatientFamilyHistory", "pfh").add(Restrictions.eq("pfh.Id", Integer.parseInt(""+familyHistoryArray[i]))).list();
						//	if(existingFamilyHis.size() == 0){
								MasMedicalExamFamilyHis masExamFamilyHis = new MasMedicalExamFamilyHis();
								Patient patientObj = new Patient();
								if(!hinNo.equals("")){
									patientObj.setId(maxHinId);
								}else if(hinNo.equals("")){
									if(regHinId != 0){
										patientObj.setId(regHinId);
									}else if(selfRegHin != 0){
										patientObj.setId(selfRegHin);
									}
								}
								masExamFamilyHis.setHin(patientObj);
								PatientFamilyHistory familyHistory = new PatientFamilyHistory();
								familyHistory.setId(Integer.parseInt(""+familyHistoryArray[i]));
								masExamFamilyHis.setPatientFamilyHistory(familyHistory);
								hbt.save(masExamFamilyHis);
							}
						//}
					}
				}
				/**
				 * Life Style Factors
				 * 
				 */
				if(!hinNo.equals("")){
					
					List<PatientLifeStyleFactor> lifeStList = new ArrayList<PatientLifeStyleFactor>();
					lifeStList = session.createCriteria(PatientLifeStyleFactor.class).add(Restrictions.eq("HinNo", hinNo)).list();
					if(lifeStList.size() > 0){
						for(PatientLifeStyleFactor lifFactor : lifeStList){
							PatientLifeStyleFactor lifeStyleFactor = new PatientLifeStyleFactor();
							lifeStyleFactor = (PatientLifeStyleFactor)session.load(PatientLifeStyleFactor.class, lifFactor.getId());
							Patient patientObj = new Patient();
							patientObj.setId(maxHinId);
							lifeStyleFactor.setHin(patientObj);
							hbt.update(lifeStyleFactor);
						}
						
					}
					List<PatientGyneDetails> gyneList = new ArrayList<PatientGyneDetails>();
					gyneList = session.createCriteria(PatientGyneDetails.class).add(Restrictions.eq("HinNo", hinNo)).list();
					if(gyneList.size() > 0){
						PatientGyneDetails patientGynDt = new PatientGyneDetails();
						patientGynDt = (PatientGyneDetails)session.load(PatientGyneDetails.class, gyneList.get(0).getId());
						Patient patientObj = new Patient();
						patientObj.setId(maxHinId);
						patientGynDt.setHin(patientObj);
						hbt.update(patientGynDt);
						
					}
					List<ContraceptiveDetails> contList = new ArrayList<ContraceptiveDetails>();
					contList = session.createCriteria(ContraceptiveDetails.class).add(Restrictions.eq("HinNo", hinNo)).list();
					if(contList.size() > 0){
						for(ContraceptiveDetails conDetails : contList){
							ContraceptiveDetails contraceptiveDetails = new ContraceptiveDetails();
							contraceptiveDetails = (ContraceptiveDetails)session.load(ContraceptiveDetails.class, conDetails.getId());
							Patient patientObj = new Patient();
							patientObj.setId(maxHinId);
							contraceptiveDetails.setHin(patientObj);
							hbt.update(contraceptiveDetails);
						}
						
					}
					
					
					List<HrtDetails> hrtList = new ArrayList<HrtDetails>();
					hrtList = session.createCriteria(HrtDetails.class).add(Restrictions.eq("HinNo", hinNo)).list();
					if(hrtList.size() > 0){
						for(HrtDetails hdt : hrtList){
							HrtDetails hrtDetails = new HrtDetails();
							hrtDetails = (HrtDetails)session.load(HrtDetails.class, hdt.getId());
							Patient patientObj = new Patient();
							patientObj.setId(maxHinId);
							hrtDetails.setHin(patientObj);
							hbt.update(hrtDetails);
						}
						
					}
				}
				/**
				 * end
				 */
		
			Box box = (Box)objectMap.get("box");
		    boolean flag =  saveOtherPatientDetails(box);  // For Dependents
			succesfullyAdded = true;
			
			tx.commit();
			}
		}catch (HibernateException e){
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			//session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}

		map.put("succesfullyAdded", succesfullyAdded);
		map.put("visitList", visitList);

		return map;		
	}
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitPatientInformationEmployeeVisit(
			Map<String, Object> objectMap, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
		boolean visitFlag = true;
		String msg="";
		int savedHinId = 0;
	//	boolean addedTrade = false;
		Session session = (Session) getSession();
		MasEmployee emp = new MasEmployee();
		List<Visit> visitList = new ArrayList<Visit>();
		int regHinId =0;
		int empId = 0;
		String serNo = ""; 
		if(objectMap.get("regHinId")!= null){
			regHinId = (Integer)objectMap.get("regHinId");
		}
		System.out.println("regHinId"+regHinId);
		int selfRegHin =0;
		if(objectMap.get("selfRegHin")!= null){
			selfRegHin = (Integer)objectMap.get("selfRegHin");
		}
		System.out.println("selfRegHin"+selfRegHin);
		MasHospital hospital = new MasHospital();
		if(objectMap.get("hospitalId")!=null){
			hospital.setId((Integer)objectMap.get("hospitalId"));
		}
		int hospitalId = (Integer)objectMap.get("hospitalId");
		System.out.println("hospitalId"+hospitalId);
		Users user= new Users();
		if(objectMap.get("user")!=null){
			user = (Users)objectMap.get("user");
		}		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		Transaction tx = null;
		int doctorId =	0;
		 int sessionId =	0;
		 int departmentId =	0;
		 int priority =	0;
		 String DepartmentName = "";
		 String SessionName = "";
		 MasDepartment md = new MasDepartment();
		 MasSession ms = new MasSession();
		 
		 
	
		try {
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			Patient patient = new Patient();
			if(objectMap.get("patient")!=null)
			{
				patient = (Patient) objectMap.get("patient");
				serNo = patient.getServiceNo();
				emp = (MasEmployee)session.createCriteria(MasEmployee.class)						
						.add(Restrictions.eq("ServiceNo", serNo)).list().get(0);				
			}
			
			String hinNo = "";
			List<Patient> existingHinNoList = new ArrayList<Patient>();

			if (objectMap.get("hinNo") != null) {
				hinNo = (String) objectMap.get("hinNo");
				/*existingHinNoList = hbt
						.find("from jkt.hms.masters.business.Patient p where p.HinNo = '"
								+ hinNo + "'");*/
				existingHinNoList = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", hinNo))
						.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
				map.put("existingHinNoList", existingHinNoList);
			}
			
			int divCount = Integer.parseInt(request.getParameter("divCount"));
			for(int v =1; v<=divCount; v++)
			{
				tx = session.beginTransaction();
				 doctorId =	Integer.parseInt(request.getParameter("consultingDoctor"+v));
				  sessionId =	Integer.parseInt(request.getParameter("sessionId"+v));
				  departmentId =	Integer.parseInt(request.getParameter("departmentId"+v));
				  priority =	Integer.parseInt(request.getParameter("priority"+v));
				   md = (MasDepartment)session.get(MasDepartment.class, departmentId);
				   ms = (MasSession)session.get(MasSession.class, sessionId);
				 visitFlag = true;
			if(existingHinNoList.size()>0)
			{
				Patient hin = existingHinNoList.get(0);
				if(hin.getPatientStatus()==null || hin.getPatientStatus().trim().equalsIgnoreCase("Out Patient"))
				{
					
				
				
				 Date regDate = (Date)objectMap.get("regDate");						
				
				Set<Visit> visitSet = new HashSet<Visit>();
				if(hin.getVisits()!=null)
				{
					visitSet = hin.getVisits();
					for(Visit visit: visitSet)
					{
						
						 System.out.println("visit date"+visit.getVisitDate()+"regdate"+regDate);
						 if(visit.getVisitDate().equals(regDate) && visit.getDepartment().getId()==departmentId && visit.getSession().getId()==sessionId)
						 {
							 visitFlag = false;
							 msg += "<div style='float: left; font-size: 18px; width:665px;'><font color='red'>Visit Already Created For "+visit.getDepartment().getDepartmentName()+" Department And "+visit.getSession().getSessionName()+" Session</font></div><br>";
						 }
					}
				}
				List<AppPatientAppointments> appPatientAppointmentList = session.createCriteria(AppPatientAppointments.class)
						.add(Restrictions.eq("Hin.Id", hin.getId()))
						.add(Restrictions.eq("AppointmentDate", regDate))
						.add(Restrictions.eq("Department.Id", departmentId))
						.add(Restrictions.eq("AppSession.Id", sessionId))
						.add(Restrictions.eq("AppointmentStatus", "y").ignoreCase())
						.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
				System.out.println("Hin.Id"+ hin.getId());
				System.out.println("AppointmentDate"+ regDate);
				System.out.println("Department.Id"+ departmentId);
				System.out.println("AppSession.Id"+ sessionId);
				
				System.out.println("appPatientAppointmentList="+appPatientAppointmentList);
				if(appPatientAppointmentList.size() > 0)
				{
					
							 visitFlag = false;
							 msg += "<div style='float: left; font-size: 18px; width:665px;'><font color='red'>Online Appointment Already Taken For "+appPatientAppointmentList.get(0).getDepartment().getDepartmentName()+" Department And "+appPatientAppointmentList.get(0).getAppSession().getSessionName()+" Session</font></div><br>";
					
				}
					   
				
				}
				else{
					 visitFlag = false;
					 msg += "<div style='float: left; font-size: 18px; width:665px;'><font color='red'>Patient is Already Admitted</font></div>";
				}
			
			}
		
			
			if (visitFlag) {
				if(existingHinNoList.size() > 0)
				{
					patient = (Patient) objectMap.get("patient");
					patient.setId(existingHinNoList.get(0).getId());					
					hbt.clear();
					patient.setCurrentVisitNo(((existingHinNoList.get(0).getCurrentVisitNo()!=null?existingHinNoList.get(0).getCurrentVisitNo():0)+1));
				}
				else
				{
					patient = (Patient) objectMap.get("patient");					
					patient.setCurrentVisitNo(1);
					System.out.println("in new patient block ");
				}
				if (objectMap.get("patient") != null && !hinNo.equals("")) {
					
				
				
					if (objectMap.get("patientTypeName") != null && !(objectMap.get("patientTypeName").toString().trim().equals(""))) {
						String patientTypeName = (String)objectMap.get("patientTypeName");
						List<MasPatientType> masPatientType = hbt.find("from MasPatientType mpt where mpt.PatientTypeName ='"+patientTypeName+"'");
						patient.setPatientType(masPatientType.get(0));
					}
					patient.setEmployee(emp);
					hbt.saveOrUpdate(patient);
					savedHinId = patient.getId();
					System.out.println("savedHinId"+savedHinId);
					hbt.flush();
					
				
				}
				
				
				int maxHinId = getMaxHinId();
				int currentVisitNo =0;
			
							Visit visit = new Visit();
					
							
						String token = "";
						if(true){
							  doctorId =	Integer.parseInt(request.getParameter("consultingDoctor"+v));
							  sessionId =	Integer.parseInt(request.getParameter("sessionId"+v));
							  departmentId =	Integer.parseInt(request.getParameter("departmentId"+v));
							  priority =	Integer.parseInt(request.getParameter("priority"+v));
							token = getTokenNoForDepartment(doctorId, sessionId, departmentId, request);
							System.out.println("tokedddn"+token);
							if(HMSUtil.isInteger(token))
							{
								visit.setTokenNo(Integer.parseInt(token));
								
							}
							else{
								visitFlag = false;
								msg = token;
							}
							
						
						}
						String visitByAdmin = "";
						if (objectMap.get("visitByAdmin") != null && objectMap.get("visitByAdmin").toString().trim().equalsIgnoreCase("y")) {
							visitByAdmin = (String) objectMap.get("visitByAdmin");
							visit.setVisitByAdmin("y");							
						}
						else
						{
							visit.setVisitByAdmin("n");	
						}
						
					    visit.setVisitDate(new Date());
					    visit.setVisitTime(time);
					    visit.setAddEditDate(new Date());
					    visit.setAddEditTime(time);
					    visit.setStatus("y");
					    visit.setAppointmentType("D");
					    visit.setVisitStatus("w");
					    visit.setReportingFor("OPD");
					    visit.setAddEditBy(user);
					    visit.setHospital(hospital);
						visit.setHin(patient);
						visit.setVisitNo(patient.getCurrentVisitNo());
						visit.setTokenStatus("n");
						MasDepartment department = new MasDepartment();
						department.setId(departmentId);
						MasEmployee employee = new MasEmployee();
						employee.setId(doctorId);
						MasSession mses = new MasSession();
						mses.setId(sessionId);						
						visit.setDepartment(department);
						visit.setDivision(patient.getEmployee().getDivision()!=null?patient.getEmployee().getDivision():null);
						visit.setDoctor(employee);
						visit.setIntDoctor(employee);
						visit.setSession(mses);
						visit.setPriority(priority);
						hbt.save(visit);
						hbt.flush();
						map.put("visit_id", visit.getId());
						
			
			
				
			succesfullyAdded = true;
		
			if(visitFlag)
			{
				tx.commit();
				msg+="<div style='float: left; font-size: 18px; width:665px;'><font color='green'>Visit Created Successfully For "+md.getDepartmentName()+" Department For "+ms.getSessionName()+" Session</font></div>"
						+ "<div style='width: 160px; float: right;'><input type='button' name='yes' value='Print Token Card' class='button'	onclick=\"openWindow('/hms/hms/registration?method=printTokenCard&visit_id="+visit.getId()+"&hinNo="+(visit.getHin().getHinNo() != null ? visit.getHin().getHinNo() : "")+"&priscriptionSlip=o');\" /></div><br>";
						/*+ "<div style='width: 160px; float: right;'><input type='button' name='yes' value='Print Token Card' class='button'	onclick=\"submitForm('messageAdt','/hms/hms/registration?method=printTokenCard&visit_id="+visit.getId()+"&priscriptionSlip=o');\" /></div><br>";*/
			}
			else
			{
				if(tx!=null)
				tx.rollback();
				succesfullyAdded = false;
				msg+="<div style='float: left; font-size: 18px; width:665px;'><font color='red'>Some problem Occured! Try Again For "+md.getDepartmentName()+" Department For "+ms.getSessionName()+" Session</font></div><br>";
			}
			
			}
		}
			
		}catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			msg+="<div style='float: left; font-size: 18px; width:665px;'><font color='red'>Some problem Occured! Try Again For "+md.getDepartmentName()+" Department For "+ms.getSessionName()+" Session</font></div><br>";
		}
        map.put("msg", msg); 
		map.put("succesfullyAdded", succesfullyAdded);
		map.put("visitList", visitList);

		return map;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitPatientInformationOnlineEmployeeVisit(
			Map<String, Object> objectMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		AppPatientAppointments aPAppointment = null;
		boolean succesfullyAdded = false;
		boolean visitFlag = true;
		int savedHinId = 0;
		String msg="";
	//	boolean addedTrade = false;
		Session session = (Session) getSession();
		MasEmployee emp = new MasEmployee();
		String serNo = "";
		List<Visit> visitList = new ArrayList<Visit>();
		int regHinId =0;
		if(objectMap.get("regHinId")!= null){
			regHinId = (Integer)objectMap.get("regHinId");
		}
		int selfRegHin =0;
		if(objectMap.get("selfRegHin")!= null){
			selfRegHin = (Integer)objectMap.get("selfRegHin");
		}
		MasHospital hospital = new MasHospital();
		if(objectMap.get("masHospital")!=null){
			hospital = (MasHospital)objectMap.get("masHospital");
		}
		Users user= new Users();
		if(objectMap.get("user")!=null){
			user = (Users)objectMap.get("user");
		}
		Transaction tx = null;
		Properties properties = new Properties();
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
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			Patient patient = new Patient();
			if(objectMap.get("patient")!=null)
			{
				patient = (Patient) objectMap.get("patient");
				serNo = patient.getServiceNo();
				emp = (MasEmployee)session.createCriteria(MasEmployee.class)						
						.add(Restrictions.eq("ServiceNo", serNo)).list().get(0);				
			}
		
		
			String hinNo = "";
			List<Patient> existingHinNoList = new ArrayList<Patient>();

			if (objectMap.get("hinNo") != null) {
				hinNo = (String) objectMap.get("hinNo");
				/*existingHinNoList = hbt
						.find("from jkt.hms.masters.business.Patient p where p.HinNo = '"
								+ hinNo + "'");*/
				existingHinNoList = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", hinNo)).list();
				map.put("existingHinNoList", existingHinNoList);
			}
			
			
			
			if(existingHinNoList.size()>0)
			{
				Patient hin = existingHinNoList.get(0);
				if(hin.getPatientStatus()==null || hin.getPatientStatus().trim().equalsIgnoreCase("Out Patient"))
				{
				
				int doctorId =	(Integer)objectMap.get("consultingDoctorId");
				 int sessionId =	(Integer)objectMap.get("consultingsessionId");
				 int departmentId =	(Integer)objectMap.get("departmentId");
				 Date regDate = (Date)objectMap.get("regDate");				
				
				
				Set<Visit> visitSet = new HashSet<Visit>();
				if(hin.getVisits()!=null)
				{
					visitSet = hin.getVisits();
					for(Visit visit: visitSet)
					{
						
						 System.out.println("visit date"+visit.getVisitDate()+"regdate"+regDate);
						 if(visit.getVisitDate().equals(regDate) && visit.getDepartment().getId()==departmentId && visit.getSession().getId()==sessionId)
						 {
							 visitFlag = false;
							 msg = "<font color='red'>Visit Already Created For This Department And Session</font>";
						 }
					}
				}
					   
				}else{
					 visitFlag = false;
					 msg = "<font color='red'>Patient is Already Admitted</font>";
				}
			}
			
			if (visitFlag) {
				if(existingHinNoList.size() > 0)
				{
					patient = (Patient) objectMap.get("patient");
					patient.setId(existingHinNoList.get(0).getId());
					hbt.clear();
					patient.setCurrentVisitNo((existingHinNoList.get(0).getCurrentVisitNo()!=null?existingHinNoList.get(0).getCurrentVisitNo():0)+1);
					
					
				}
				else
				{
					patient = (Patient) objectMap.get("patient");
					patient.setCurrentVisitNo(1);
				}
				if (objectMap.get("patient") != null && !hinNo.equals("")) {
					
					
						
					
					
					if (objectMap.get("patientTypeName") != null && !(objectMap.get("patientTypeName").toString().trim().equals(""))) {
						String patientTypeName = (String)objectMap.get("patientTypeName");
						List<MasPatientType> masPatientType = hbt.find("from MasPatientType mpt where mpt.PatientTypeName ='"+patientTypeName+"'");
						patient.setPatientType(masPatientType.get(0));
					}
					patient.setEmployee(emp);
					hbt.saveOrUpdate(patient);
					savedHinId = patient.getId();
					hbt.flush();
					hbt.refresh(patient);
				
				}
				
				
				int maxHinId = getMaxHinId();
				int currentVisitNo =0;
				if (objectMap.get("visitObjList") != null) {
					List<Visit> visitObjList = new ArrayList<Visit>();
					visitObjList = (List<Visit>)objectMap.get("visitObjList");
					
					for (int i = 0; i < visitObjList.size(); i++) {
							Visit visit = new Visit();
							visit = visitObjList.get(i);
						String token = "";
						if(true){
						    int doctorId =	(Integer)objectMap.get("consultingDoctorId");
						    int sessionId =	(Integer)objectMap.get("consultingsessionId");
						    int departmentId =	(Integer)objectMap.get("departmentId");
							/*token = getTokenNoForDepartment(doctorId, sessionId, departmentId);
							if(HMSUtil.isInteger(token))
							{
								visit.setTokenNo(Integer.parseInt(token));
								
							}
							else{
								msg = token;
							}*/
							
							/*token = visit.getTokenNo();*/
						}
					
						visit.setHin(patient);
						visit.setAppointmentType("o");
						visit.setVisitNo(patient.getCurrentVisitNo());
						visit.setTokenStatus("n");
						visit.setDivision(patient.getEmployee().getDivision()!=null?patient.getEmployee().getDivision():null);
						visit.setIntDoctor(visit.getDoctor());
						hbt.save(visit);
						map.put("visit_id", visit.getId());
						
						int aPAId =0;
						if(objectMap.get("aPAId")!= null){
							aPAId = (Integer)objectMap.get("aPAId");
						}
						
						if(objectMap.get("user")!=null){
							user = (Users)objectMap.get("user");
						}
						Map<String, Object> utilMap = new HashMap<String, Object>();
						utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
						String time = (String) utilMap.get("currentTimeWithoutSc");
						
						aPAppointment = (AppPatientAppointments)hbt.load(AppPatientAppointments.class, aPAId);		
						if(aPAppointment!=null)
						{
							aPAppointment.setAppointmentStatus("w");
							aPAppointment.setLastChgBy(user);
							aPAppointment.setLastChgDate(new Date());
							aPAppointment.setLastChgTime(time);
							/*aPAppointment.setAppointmentCancelDate(new Date());		*/		
							hbt.update(aPAppointment);				
							hbt.flush();
							
						}
						
						
					
					}
				}
				
			
				
			succesfullyAdded = true;
			if(msg.trim().equals(""))
			{
				tx.commit();
			}
			else
			{
				if(tx!=null)
				tx.rollback();
				succesfullyAdded = false;
			}
			
			}
			
		}catch (HibernateException e){
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			//session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}
        map.put("msg", msg); 
		map.put("succesfullyAdded", succesfullyAdded);
		map.put("visitList", visitList);

		return map;
	}

	

	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> cancleOnlineAppointment(
			Map<String, Object> objectMap) {
		AppPatientAppointments aPAppointment = null;
		boolean succesfullyAdded = false;
		Session session = (Session) getSession();
		
		
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int aPAId =0;
			if(objectMap.get("aPAId")!= null){
				aPAId = (Integer)objectMap.get("aPAId");
			}
			Users user= new Users();
			if(objectMap.get("user")!=null){
				user = (Users)objectMap.get("user");
			}
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String time = (String) utilMap.get("currentTimeWithoutSc");
			
			aPAppointment = (AppPatientAppointments)hbt.load(AppPatientAppointments.class, aPAId);		
			if(aPAppointment!=null)
			{
				aPAppointment.setAppointmentStatus("c");
				aPAppointment.setLastChgBy(user);
				aPAppointment.setLastChgDate(new Date());
				aPAppointment.setLastChgTime(time);
				aPAppointment.setAppointmentCancelDate(new Date());				
				hbt.update(aPAppointment);				
				hbt.flush();
				succesfullyAdded = true;
			}
			
			tx.commit();		
			
		}catch (HibernateException e){
			e.printStackTrace();
			succesfullyAdded = false;
			if(tx!=null)
				tx.rollback();
			//session.close();
		} catch (Exception e) {
			e.printStackTrace();
			succesfullyAdded = false;
			if(tx!=null)
				tx.rollback();
		}
       
		objectMap.put("succesfullyAdded", succesfullyAdded);
		return objectMap;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitPatientInformationOtherPatientVisit(
			Map<String, Object> objectMap, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
		boolean visitFlag = true;
		int savedHinId = 0;
	//	boolean addedTrade = false;
		String msg = "";
		Session session = (Session) getSession();
		List<Visit> visitList = new ArrayList<Visit>();
		int regHinId =0;
		if(objectMap.get("regHinId")!= null){
			regHinId = (Integer)objectMap.get("regHinId");
		}
		int selfRegHin =0;
		if(objectMap.get("selfRegHin")!= null){
			selfRegHin = (Integer)objectMap.get("selfRegHin");
		}
		MasHospital hospital = new MasHospital();
		if(objectMap.get("masHospital")!=null){
			hospital = (MasHospital)objectMap.get("masHospital");
		}
		Users user= new Users();
		if(objectMap.get("user")!=null){
			user = (Users)objectMap.get("user");
		}
		String selfRelationName="";
		MasRelation masR = new MasRelation();
		Properties propadt = new Properties();
		URL resourcePathadt = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			propadt.load(resourcePathadt.openStream());	
			
			selfRelationName=propadt.getProperty("selfRelationName");
			List<MasRelation> mr = session.createCriteria(MasRelation.class)
					.add(Restrictions.eq("NewRelationName", selfRelationName).ignoreCase())
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			masR = mr.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Transaction tx = null;
			
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.clear();
		
			
			String hinNo = "";
			List<Patient> existingHinNoList = new ArrayList<Patient>();

			if (objectMap.get("regHinId") != null) {
				
				/*existingHinNoList = hbt
						.find("from jkt.hms.masters.business.Patient p where p.HinNo = '"
								+ hinNo + "'");*/
				/*existingHinNoList.add((Patient)session.load(Patient.class , regHinId));
				map.put("existingHinNoList", existingHinNoList);*/
			}
			Patient hin = new Patient();
			if(objectMap.get("visitObjList") != null && (regHinId != 0 || selfRegHin != 0))
			{
				int doctorId =	(Integer)objectMap.get("consultingDoctorId");
				 int sessionId =	(Integer)objectMap.get("consultingsessionId");
				 int departmentId =	(Integer)objectMap.get("departmentId");
				 Date regDate = (Date)objectMap.get("regDate");				
				
				if(selfRegHin != 0 && regHinId == 0)
					hin = (Patient)hbt.load(Patient.class, selfRegHin);
				else if(regHinId!=0)
				hin = (Patient)hbt.load(Patient.class, regHinId);
				hin.setServiceNo(hin.getHinNo());
				if(hin.getPatientStatus()==null || hin.getPatientStatus().trim().equalsIgnoreCase("Out Patient"))
				{
				Set<Visit> visitSet = new HashSet<Visit>();
				if(hin.getVisits()!=null)
				{
					visitSet = hin.getVisits();
					for(Visit visit: visitSet)
					{
						
						 System.out.println("visit date"+visit.getVisitDate()+"regdate"+regDate);
						 if(visit.getVisitDate().equals(regDate) && visit.getDepartment().getId()==departmentId && visit.getSession().getId()==sessionId)
						 {
							 visitFlag = false;
							 msg = "Visit Already Created For This Department And Session";
						 }
					}
				}
			}
				else{
					 visitFlag = false;
					 msg = "Patient is Already Admitted";
				}
					   
				
			}
			
			if (visitFlag) {
			Patient patient = new Patient();
			if (true) {
				if (objectMap.get("patient") != null && regHinId == 0 && selfRegHin == 0) {
					System.out.println("In New Patient Block");
					patient = (Patient) objectMap.get("patient");
					patient.setCurrentVisitNo(1);	
					patient.setServiceNo(patient.getHinNo());
					
					if (objectMap.get("patientTypeName") != null && !(objectMap.get("patientTypeName").toString().trim().equals(""))) {
						String patientTypeName = (String)objectMap.get("patientTypeName");
						List<MasPatientType> masPatientType = hbt.find("from MasPatientType mpt where mpt.PatientTypeName ='"+patientTypeName+"'");
						patient.setPatientType(masPatientType.get(0));
					}
					patient.setVisitCreated("y");
					patient.setRelation(masR);
					savedHinId =(Integer) hbt.save(patient);
					objectMap.put("hinNo", patient.getHinNo());
					hbt.refresh(patient);
				
				}
						
				
				
				/**
				 * Update patient records
				 */
				
				if(regHinId != 0 || selfRegHin != 0){
					System.out.println("In Old Patient Block");
					patient = (Patient) objectMap.get("patient");
					/*if(selfRegHin != 0 && regHinId == 0)
						hin = (Patient)hbt.load(Patient.class, selfRegHin);
					else if(regHinId!=0)
						hin = (Patient)hbt.load(Patient.class, regHinId);*/
					patient.setHinNo(hin.getHinNo());
					patient.setServiceNo(hin.getHinNo());
					patient.setBillable(hin.getBillable());
					patient.setApprovedBy(hin.getApprovedBy());
					patient.setCurrentVisitNo(hin.getCurrentVisitNo()+1);
					patient.setVisitCreated("y");
					hbt.clear();
					if(selfRegHin != 0 && regHinId == 0)
						patient.setId(selfRegHin);
					else if(regHinId!=0)
						patient.setId(regHinId);
					
				
					
					if (objectMap.get("patientTypeName") != null && !(objectMap.get("patientTypeName").toString().trim().equals(""))) {
						String patientTypeName = (String)objectMap.get("patientTypeName");
						List<MasPatientType> masPatientType = hbt.find("from MasPatientType mpt where mpt.PatientTypeName ='"+patientTypeName+"'");
						patient.setPatientType(masPatientType.get(0));
					}				
					patient.setRelation(masR);
					hbt.update(patient);
					savedHinId = patient.getId();
					objectMap.put("hinNo", patient.getHinNo());
					hbt.flush();
					hbt.clear();
					
				}
				
				int maxHinId = getMaxHinId();
				int currentVisitNo =0;
				if (objectMap.get("visitObjList") != null) {
					List<Visit> visitObjList = new ArrayList<Visit>();
					visitObjList = (List<Visit>)objectMap.get("visitObjList");
					
					for (int i = 0; i < visitObjList.size(); i++) {
							Visit visit = new Visit();
							visit = visitObjList.get(i);
						String token = "";
						if(true){
						    int doctorId =	(Integer)objectMap.get("consultingDoctorId");
						    int sessionId =	(Integer)objectMap.get("consultingsessionId");
						    int departmentId =	(Integer)objectMap.get("departmentId");
							token = getTokenNoForDepartment(doctorId, sessionId, departmentId, request);
							if(HMSUtil.isInteger(token))
							{
								visit.setTokenNo(Integer.parseInt(token));
								
							}
							else{
								msg = token;
							}
							
							/*token = visit.getTokenNo();*/
						}
					
						Patient patientObj = new Patient();
						patientObj.setId(savedHinId);
						visit.setHin(patientObj);
						
						
							
							Patient hinPt = new Patient();
							if(selfRegHin != 0 && regHinId == 0)
								hinPt = (Patient)hbt.load(Patient.class, selfRegHin);
							else if(regHinId!=0)
								hinPt = (Patient)hbt.load(Patient.class, regHinId);
							hinPt.setServiceNo(hinPt.getHinNo());
							currentVisitNo = hinPt.getCurrentVisitNo();
							visit.setVisitNo(currentVisitNo);
							visit.setIntDoctor(visit.getDoctor());
						
						visit.setTokenStatus("n");
						hbt.save(visit);
						map.put("visit_id", visit.getId());
					
					}
				}
			}	
			

		
			/*Box box = (Box)objectMap.get("box");
		    boolean flag =  saveOtherPatientDetails(box);*/  // For Dependents
			succesfullyAdded = true;
			if(msg.trim().equals(""))
			{
				tx.commit();
			}
			else
			{
				if(tx!=null)
				tx.rollback();
				succesfullyAdded = false;
			}
	
			}
			/*if(!visitFlag)
			{
				msg = "Visit Already Created For This Department And Session";
			}*/
		}catch (HibernateException e){
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			//session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}
		map.put("msg", msg); 
		map.put("succesfullyAdded", succesfullyAdded);
		map.put("visitList", visitList);

		return map;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitPatientInformationHAL(
			Map<String, Object> objectMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	//	boolean addedTrade = false;
		Session session = (Session) getSession();
		List<Visit> visitList = new ArrayList<Visit>();
		int regHinId =0;
		if(objectMap.get("regHinId")!= null){
			regHinId = (Integer)objectMap.get("regHinId");
		}
		int selfRegHin =0;
		if(objectMap.get("selfRegHin")!= null){
			selfRegHin = (Integer)objectMap.get("selfRegHin");
		}
		MasHospital hospital = new MasHospital();
		if(objectMap.get("masHospital")!=null){
			hospital = (MasHospital)objectMap.get("masHospital");
		}
		Users user= new Users();
		if(objectMap.get("user")!=null){
			user = (Users)objectMap.get("user");
		}
		String selfRelationName="";
		MasRelation masR = new MasRelation();
		Properties propadt = new Properties();
		URL resourcePathadt = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			propadt.load(resourcePathadt.openStream());	
			
			selfRelationName=propadt.getProperty("selfRelationName");
			List<MasRelation> mr = session.createCriteria(MasRelation.class)
					.add(Restrictions.eq("NewRelationName", selfRelationName).ignoreCase())
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			masR = mr.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			String hinNo = "";
			List<Patient> existingHinNoList = new ArrayList<Patient>();					
			Patient patient = new Patient();
			if (true) {
				if (objectMap.get("patient") != null && regHinId == 0 && selfRegHin == 0) {
					patient = (Patient) objectMap.get("patient");
					
					patient.setCurrentVisitNo(0);
					
					if (objectMap.get("patientTypeName") != null && !(objectMap.get("patientTypeName").toString().trim().equals(""))) {
						String patientTypeName = (String)objectMap.get("patientTypeName");
						List<MasPatientType> masPatientType = hbt.find("from MasPatientType mpt where mpt.PatientTypeName ='"+patientTypeName+"'");
						patient.setPatientType(masPatientType.get(0));
					}
					patient.setRelation(masR);
					hbt.save(patient);
					objectMap.put("hinNo", patient.getHinNo());
					hbt.refresh(patient);
				
				}
				
				
				int maxHinId = getMaxHinId();
				int currentVisitNo =0;
			
				
				/**
				 * Update patient records
				 */
				Patient hin = new Patient();
				if(regHinId != 0 || selfRegHin != 0){
					patient = (Patient) objectMap.get("patient");
					if(selfRegHin != 0 && regHinId == 0)
						hin = (Patient)hbt.load(Patient.class, selfRegHin);
					else if(regHinId!=0)
						hin = (Patient)hbt.load(Patient.class, regHinId);
					patient.setHinNo(hin.getHinNo());
					patient.setBillable(hin.getBillable());
					patient.setApprovedBy(hin.getApprovedBy());
					patient.setCurrentVisitNo(hin.getCurrentVisitNo());
					hbt.clear();
					if(selfRegHin != 0 && regHinId == 0)
						patient.setId(selfRegHin);
					else if(regHinId!=0)
						patient.setId(regHinId);
					
					
					
					if (objectMap.get("patientTypeName") != null && !(objectMap.get("patientTypeName").toString().trim().equals(""))) {
						String patientTypeName = (String)objectMap.get("patientTypeName");
						List<MasPatientType> masPatientType = hbt.find("from MasPatientType mpt where mpt.PatientTypeName ='"+patientTypeName+"'");
						patient.setPatientType(masPatientType.get(0));
					}
					

					
					
					patient.setRelation(masR);
					hbt.update(patient);
					objectMap.put("hinNo", patient.getHinNo());
					hbt.flush();
					hbt.clear();
					
				}		

		
			/*Box box = (Box)objectMap.get("box");
		    boolean flag =  saveOtherPatientDetails(box);*/  // For Dependents
			succesfullyAdded = true;
			
			tx.commit();
			}
		}catch (HibernateException e){
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			//session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}

		map.put("succesfullyAdded", succesfullyAdded);
		map.put("visitList", visitList);

		return map;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> updateOtherPatientInformation(
			Map<String, Object> objectMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	//	boolean addedTrade = false;
		Session session = (Session) getSession();
		List<Visit> visitList = new ArrayList<Visit>();
		int regHinId =0;
		if(objectMap.get("regHinId")!= null){
			regHinId = (Integer)objectMap.get("regHinId");
		}
		int selfRegHin =0;
		if(objectMap.get("selfRegHin")!= null){
			selfRegHin = (Integer)objectMap.get("selfRegHin");
		}
		MasHospital hospital = new MasHospital();
		if(objectMap.get("masHospital")!=null){
			hospital = (MasHospital)objectMap.get("masHospital");
		}
		Users user= new Users();
		if(objectMap.get("user")!=null){
			user = (Users)objectMap.get("user");
		}
		String selfRelationName="";
		MasRelation masR = new MasRelation();
		Properties propadt = new Properties();
		URL resourcePathadt = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			propadt.load(resourcePathadt.openStream());	
			
			selfRelationName=propadt.getProperty("selfRelationName");
			List<MasRelation> mr = session.createCriteria(MasRelation.class)
					.add(Restrictions.eq("NewRelationName", selfRelationName).ignoreCase())
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			masR = mr.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Transaction tx = null;
		
	
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			String hinNo = "";
			List<Patient> existingHinNoList = new ArrayList<Patient>();					
			Patient patient = null;
			if (true) {
				/*if (objectMap.get("patient") != null && regHinId == 0 && selfRegHin == 0) {
					patient = (Patient) objectMap.get("patient");
					
					patient.setCurrentVisitNo(0);
					
					if (objectMap.get("patientTypeName") != null && !(objectMap.get("patientTypeName").toString().trim().equals(""))) {
						String patientTypeName = (String)objectMap.get("patientTypeName");
						List<MasPatientType> masPatientType = hbt.find("from MasPatientType mpt where mpt.PatientTypeName ='"+patientTypeName+"'");
						patient.setPatientType(masPatientType.get(0));
					}
					patient.setRelation(masR);
					hbt.save(patient);
					objectMap.put("hinNo", patient.getHinNo());
					hbt.refresh(patient);
				
				}*/
				
				
				int maxHinId = getMaxHinId();
				int currentVisitNo =0;
			
				
				/**
				 * Update patient records
				 */
				Patient hin = null;
				if(regHinId != 0 || selfRegHin != 0){
					patient = (Patient) objectMap.get("patient");
					if(selfRegHin != 0 && regHinId == 0)
						hin = (Patient)hbt.load(Patient.class, selfRegHin);
					else if(regHinId!=0)
						hin = (Patient)hbt.load(Patient.class, regHinId);
					patient.setHinNo(hin.getHinNo());
					patient.setBillable(hin.getBillable());
					patient.setApprovedBy(hin.getApprovedBy());
					patient.setCurrentVisitNo(hin.getCurrentVisitNo());
					patient.setRelation(hin.getRelation());
					patient.setRegDate(hin.getRegDate());
					patient.setRegTime(hin.getRegTime());
					patient.setHospital(hin.getHospital());
					patient.setStatus(hin.getStatus());
					patient.setPatientStatus(hin.getPatientStatus());
					patient.setInpatientNo(hin.getInpatientNo());
					patient.setPaymentStatus(hin.getPaymentStatus());
					patient.setVisitCreated(hin.getVisitCreated());
					patient.setPreviousHinNo(hin.getPreviousHinNo());
					
 					hbt.clear();
					if(selfRegHin != 0 && regHinId == 0)
						patient.setId(selfRegHin);
					else if(regHinId!=0)
						patient.setId(regHinId);
					    hin = patient;
					
					
					if (objectMap.get("patientTypeName") != null && !(objectMap.get("patientTypeName").toString().trim().equals(""))) {
						String patientTypeName = (String)objectMap.get("patientTypeName");
						List<MasPatientType> masPatientType = hbt.find("from MasPatientType mpt where mpt.PatientTypeName ='"+patientTypeName+"'");
						patient.setPatientType(masPatientType.get(0));
					}
									
					
					
					hbt.update(patient);
					objectMap.put("hinNo", patient.getHinNo());
					hbt.flush();
					hbt.clear();
					
				}		

		
			/*Box box = (Box)objectMap.get("box");
		    boolean flag =  saveOtherPatientDetails(box);*/  // For Dependents
			succesfullyAdded = true;
			
			tx.commit();
			}
		}catch (HibernateException e){
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			//session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}

		map.put("succesfullyAdded", succesfullyAdded);
		map.put("visitList", visitList);

		return map;
	}
	
	@SuppressWarnings("unchecked")
	private Boolean  saveOtherPatientDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		map.put("serviceNo", box.getString("serviceNo"));
		map.put("serviceTypeId", box.getInt("serviceTypeId"));
		map.put("serviceStatusId", box.getInt("serviceStatusId"));
		int maxHinId = getMaxHinId();
		
		Patient patient = (Patient)hbt.load(Patient.class, maxHinId);
		int depCount = box.getInt("depCount");
		for (int i = 1; i < depCount; i++) {
			
			Patient patientForChild=new Patient();
			patientForChild.setServiceType(patient.getServiceType());
			patientForChild.setServiceStatus(patient.getServiceStatus());
			patientForChild.setServiceNo(box.getString("serviceNo"));
			if(patient.getPrefix()!= null)
				patientForChild.setPrefix(patient.getPrefix());
			if(patient.getSuffix()!= null)
				patientForChild.setSuffix(patient.getSuffix());
			patientForChild.setRank(patient.getRank());
			patientForChild.setSFirstName(patient.getSFirstName());
			if(patient.getSMiddleName()!= null){
				patientForChild.setSMiddleName(patient.getSMiddleName());
			}
			if(patient.getSLastName()!= null){
				patientForChild.setSLastName(patient.getSLastName());
			}
			patientForChild.setSrSex(patient.getSrSex());
			if(patient.getSrDob()!= null){
				patientForChild.setSrDob(patient.getSrDob());
			}
			if(patient.getSrAge()!= null){
				patientForChild.setSrAge(patient.getSrAge());
			}
			if(patient.getSrMaritalStatus()!= null){
				patientForChild.setSrMaritalStatus(patient.getSrMaritalStatus());
			}
			if(patient.getCommand()!= null){
				patientForChild.setCommand(patient.getCommand());
			}
			if(patient.getStation()!= null){
				patientForChild.setStation(patient.getStation());
			}
			if(patient.getUnit()!= null){
				patientForChild.setUnit(patient.getUnit());
			}
			if(patient.getSection()!= null){
				patientForChild.setSection(patient.getSection());
			}
			if(patient.getTrade()!= null){
				patientForChild.setTrade(patient.getTrade());
			}
			if(patient.getCommissionDate()!= null){
				patientForChild.setCommissionDate(patient.getCommissionDate());
			}
			if(patient.getServiceYears()!= null){
				patientForChild.setServiceYears(patient.getServiceYears());
			}
			if(patient.getTotalServicePeriod()!= null){
				patientForChild.setTotalServicePeriod(patient.getTotalServicePeriod());
			}
			if(patient.getRecordOfficeAddress()!= null){
				patientForChild.setRecordOfficeAddress(patient.getRecordOfficeAddress());
			}
			if(patient.getReligion()!= null){
				patientForChild.setReligion(patient.getReligion());
			}
			if(patient.getSrBloodGroup()!= null){
				patientForChild.setSrBloodGroup(patient.getSrBloodGroup());
			}
			if(patient.getPhoneNumber()!= null){
				patientForChild.setPhoneNumber(patient.getPhoneNumber());
			}
			if(patient.getMobileNumber()!= null){
				patientForChild.setMobileNumber(patient.getMobileNumber());
			}
			if(patient.getAfnetNo()!= null){
				patientForChild.setAfnetNo(patient.getAfnetNo());
			}
			if(patient.getHospital()!= null){
				patientForChild.setHospital(patient.getHospital());
			}
			patientForChild.setPatientStatus("Out Patient");
			patientForChild.setStatus("y");
			if(patient.getAddEditBy()!= null){
				patientForChild.setAddEditBy(patient.getAddEditBy());
			}
			if(patient.getAddEditDate()!= null){
				patientForChild.setAddEditDate(patient.getAddEditDate());
			}
			if(patient.getAddEditTime()!= null){
				patientForChild.setAddEditTime(patient.getAddEditTime());
			}
			if(patient.getRegDate()!= null){
				patientForChild.setRegDate(patient.getRegDate());
			}
			if(patient.getRegTime()!= null){
				patientForChild.setRegTime(patient.getRegTime());
			}
			String pName = box.getString("depnName"+i);
			String fName = "";
			String mName = "";
			String lName = "";
			if((pName).indexOf(' ') >= 0)
				fName = (pName).substring(0,(pName).indexOf(' '));
			else
				fName = pName;
			
			if((pName).indexOf(' ') >= 0 && (pName).lastIndexOf(' ') >=0)
				mName = (pName).substring((pName).indexOf(' '),(pName).lastIndexOf(' '));
			
			
			if((pName).lastIndexOf(' ') >=0)
				lName = (pName).substring((pName).lastIndexOf(' '));
			
			String relation = box.getString("rel"+i);
			List<Integer> relationIdList = new ArrayList<Integer>();
			Session session = (Session)getSession();
			relationIdList = session.createCriteria(MasRelation.class).add(Restrictions.eq("RelationName", relation).ignoreCase()).setProjection(Projections.property("Id")).list();
			//relationIdList = hbt.find("select Id from MasRelation where upper(RelationName) = upper('"+relation+"')");
			int sex = box.getInt("depSex"+i);
		/*	List<Integer> sexIdList = new ArrayList<Integer>();
			sexIdList = hbt.find("select Id from MasAdministrativeSex where upper(AdministrativeSexCode) = upper('"+sex+"')");
			*/
			map.put("relationId", relationIdList.get(0));
			if((!fName.equalsIgnoreCase(box.getString(P_FIRST_NAME)) && (Integer)relationIdList.get(0) != box.getInt(RELATION_ID))){
				String hin = getHin(map);
				patientForChild.setHinNo(hin);
				patientForChild.setPFirstName(fName);
				patientForChild.setPMiddleName(mName);
				patientForChild.setPLastName(lName);
				if(!box.getString("depDob").equals("")){
					patientForChild.setDateOfBirth(HMSUtil.convertStringTypeDateToDateType(box.getString("depDob")));
					patientForChild.setAge(calculateAge(box.getString("depDob")));
				}
				MasAdministrativeSex admSex = new MasAdministrativeSex();
				admSex.setId(sex);
				patientForChild.setSex(admSex);
				
				MasRelation masRelationObj = new MasRelation();
				masRelationObj.setId(relationIdList.get(0));
				patientForChild.setRelation(masRelationObj);
				patientForChild.setCurrentVisitNo(0);
				
				hbt.save(patientForChild);
				
			}
			
			
		}
		
		return flag;
	}

	public String calculateAge(String dob) {
		Date dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(dob);
		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateOfBirth);

		int calculatedDays, calculatedMonth, calculatedYear;
		int currentDays = now.get(Calendar.DATE);
		int birthDays = cal.get(Calendar.DATE);
		int currentMonth = now.get(Calendar.MONTH);
		int birthMonth = cal.get(Calendar.MONTH);
		int currentYear = now.get(Calendar.YEAR);
		int birthYear = cal.get(Calendar.YEAR);

		calculatedMonth = currentMonth - birthMonth;
		if (calculatedMonth == 1) {
			calculatedDays = currentDays + (31 - birthDays);
		} else {
			calculatedDays = currentDays - birthDays;
		}

		calculatedYear = currentYear - birthYear;
		int age = calculatedYear;
		String period = "";

		if (calculatedYear == 0 && calculatedMonth != 0
				&& calculatedDays != 0) {
			if (calculatedMonth == 1 && calculatedDays < 30) {
				age = calculatedDays;
				period = "Days";
			} else {
				age = calculatedMonth;
				period = "Months";
			}

		} else if (age == 0 && calculatedMonth == 0 && calculatedDays != 0) {
			age = calculatedDays;
			period = "Days";
		} else if (age == 0 && calculatedMonth == 0 && calculatedDays == 0) {
			age = 0;
			period = "Days";
		} else {

			period = "Years";
		}
		String pAge="";
		pAge = age+" "+period;
		return pAge;
	}
	
	private String getHin(Map<String, Object> map) {
		String serviceNo = "";
		String hinNo = "";
		serviceNo = (String)map.get("serviceNo");
		
		int serviceTypeId = (Integer)map.get("serviceTypeId");
		
		Map<String, Object> serviceAndRelationMap = new HashMap<String, Object>();

		serviceAndRelationMap = getServiceTypeAndRelation(map);
		String relationCode = (String) serviceAndRelationMap.get("relationCode");
		String serviceTypeCode = (String) serviceAndRelationMap.get("serviceTypeCode");
		String serviceStatusCode = (String) serviceAndRelationMap.get("serviceStatusCode");
		String maxSequenceNo = "";
		maxSequenceNo = getHinId(serviceNo,serviceTypeId);
		Integer i;
		if (!maxSequenceNo.equals("")) {
			i = Integer.parseInt(maxSequenceNo) + 1;
		} else {
			i = 01;
		}
		String seqNo = "";
		if (i <= 9) {
			seqNo = "0" + i.toString();
		} else {
			seqNo = i.toString();
		}
		if (!serviceNo.equals("0")) {
			hinNo = serviceTypeCode.concat(serviceStatusCode).concat(serviceNo)
					.concat(relationCode).concat(seqNo.toString());
		} else {
			hinNo = serviceTypeCode.concat(seqNo.toString());
		}
		return hinNo;
	}

	@SuppressWarnings("unchecked")
	public String getHinId(String serviceNo, int serviceTypeId) {
		Session session = (Session) getSession();
		String previousHinNo = "";
		String maxSequenceNo = "";
		List<Patient> previousHinNoList = new ArrayList<Patient>();
		try {
			if (!serviceNo.equals("0") && serviceNo != null) {
				previousHinNoList = session.createCriteria(Patient.class).add(
						Restrictions.eq("ServiceNo", serviceNo)).list();
			} else {
				previousHinNoList = session.createCriteria(Patient.class)
						.list();
			}
			if (previousHinNoList.size() > 0) {

				ArrayList hinNoSequenceList = new ArrayList();
				for (Patient patient : previousHinNoList) {
					if (patient.getServiceType().getId() == serviceTypeId) {
						previousHinNo = patient.getHinNo();
						int length = previousHinNo.length() - 2;
						String sequenceNo = previousHinNo.substring(length,
								previousHinNo.length());
						int i = Integer.parseInt(sequenceNo);
						hinNoSequenceList.add(i);
					}
				}

				if (hinNoSequenceList.size() > 0) {
					maxSequenceNo = Collections.max(hinNoSequenceList)
							.toString();
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		//	session.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return maxSequenceNo;

	}

	@SuppressWarnings("unchecked")
	public String getHinIdHAL(String patientCode, HttpServletRequest request) {
		Session session = (Session) getSession();
		String previousHinNo = "";
		String maxSequenceNo = "";
		List<Patient> previousHinNoList = new ArrayList<Patient>();
		HttpSession ses = request.getSession();
		int hospitalId = 0;
		if (ses.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) ses.getAttribute(HOSPITAL_ID);
		}
		try {
			
				previousHinNoList = session.createCriteria(Patient.class).createAlias("PatientType", "pt")
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("pt.PatientTypeCode", patientCode)).list();
				System.out.println("patientCode"+patientCode);
			
			if (previousHinNoList.size() > 0) {

				ArrayList hinNoSequenceList = new ArrayList();
				for (Patient patient : previousHinNoList) {
					
						previousHinNo = patient.getHinNo();						
						String sequenceNo = previousHinNo.substring(2);
						int i = Integer.parseInt(sequenceNo);
						hinNoSequenceList.add(i);
						
					
				}

				if (hinNoSequenceList.size() > 0) {
					maxSequenceNo = Collections.max(hinNoSequenceList)
							.toString();
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		//	session.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return maxSequenceNo;

	}
	
	@SuppressWarnings("unchecked")
	public int getMaxHinId() {
		List<Integer> patientList = new ArrayList<Integer>();
		patientList = getHibernateTemplate()
				.find(
						"select max(patient.Id) from jkt.hms.masters.business.Patient as patient");
		Integer maxHinId = (Integer) patientList.get(0);
		return maxHinId;
	}

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
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		Date appointmentDate = null;
		int hinId = 0;
		Session session = (Session) getSession();

		if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("serviceTypeId") != null) {
			serviceTypeId = (Integer) mapForDs.get("serviceTypeId");
		}
		if (mapForDs.get("rankId") != null) {
			rankId = (Integer) mapForDs.get("rankId");
		}
		if (mapForDs.get("unitId") != null) {
			unitId = (Integer) mapForDs.get("unitId");
		}
		if (mapForDs.get("serPersonFName") != null) {
			serPersonFName = (String) mapForDs.get("serPersonFName");
		}
		if (mapForDs.get("serPersonMName") != null) {
			serPersonMName = (String) mapForDs.get("serPersonMName");
		}
		if (mapForDs.get("serPersonLName") != null) {
			serPersonLName = (String) mapForDs.get("serPersonLName");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("patientMName") != null) {
			patientMName = (String) mapForDs.get("patientMName");
		}
		if (mapForDs.get("patientLName") != null) {
			patientLName = (String) mapForDs.get("patientLName");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("appointmentDate") != null) {
			appointmentDate = (Date) mapForDs.get("appointmentDate");
		}
		try {
			Criteria crit = session.createCriteria(Patient.class).add(
					Restrictions.eq("PatientStatus", "Out Patient"));
			if (hinId == 0) {
				if (!serviceNo.equals("")) {
					crit = crit.add(Restrictions.eq("ServiceNo", serviceNo));
				}
				if (!hinNo.equals("")) {
					crit = crit.add(Restrictions.eq("HinNo", hinNo.trim()));
				}
				if (!patientFName.equals("")) {
					crit = crit.add(Restrictions.like("PFirstName", patientFName.trim()+ "%").ignoreCase()); 
							
				}
				if (!patientMName.equals("")) {
					crit = crit.add(Restrictions.like("PMiddleName", patientMName.trim()+ "%").ignoreCase());
							
				}
				if (!patientLName.equals("")) {
					crit = crit.add(Restrictions.like("PLastName", patientLName.trim()+ "%").ignoreCase());
							
				}
				if (!serPersonFName.equals("")) {
					crit = crit.add(Restrictions.like("SFirstName", serPersonFName.trim()+ "%").ignoreCase());
						
				}
				if (!serPersonMName.equals("")) {
					crit = crit.add(Restrictions.like("SMiddleName", serPersonMName.trim()+ "%").ignoreCase());
					//		+ "%"));
				}
				if (!serPersonLName.equals("")) {
					crit = crit.add(Restrictions.like("SLastName", serPersonLName.trim()+ "%").ignoreCase());
						
				}
				if (serviceTypeId != 0) {
					crit = crit.createAlias("ServiceType", "st").add(
							Restrictions.eq("st.Id", serviceTypeId));
				}
				if (rankId != 0) {
					crit = crit.createAlias("Rank", "rank").add(
							Restrictions.eq("rank.Id", rankId));
				}
				if (unitId != 0) {
					crit = crit.createAlias("Unit", "unit").add(
							Restrictions.eq("unit.Id", unitId));
				}
				if (appointmentDate != null) {
					crit = crit.createAlias("AppPatientAppointments", "ap").add(
							Restrictions.eq("ap.AppointmentDate", appointmentDate))
							.add(Restrictions.eq("ap.AppointmentStatus", "y"));

				}
			} else if (hinId != 0) {
				crit = crit.add(Restrictions.idEq(hinId));
			}
			patientList = crit.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		return map;
	}
	

	@SuppressWarnings("unchecked")
	public Map<String, Object> getVisitDetails() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasComplaint> complaintList = new ArrayList<MasComplaint>();
		List<MasCaseType> caseTypeList = new ArrayList<MasCaseType>();
		List<MasDiagnosisConclusion> diagnosisList = new ArrayList<MasDiagnosisConclusion>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		Session session = (Session) getSession();

		List<String> departmentTypeCode = new ArrayList<String>();
		departmentTypeCode.add("CR");
		departmentTypeCode.add("OPD1");
		departmentTypeCode.add("SpltOPD");

		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).createAlias("DepartmentType",
					"deptType").add(
					Restrictions.in("deptType.DepartmentTypeCode",
							departmentTypeCode)).list();

			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("EmpCategory",
					"empCat").add(Restrictions.eq("empCat.EmpCategoryCode", "01"))
					.list();
			complaintList = session.createCriteria(MasComplaint.class).add(
					Restrictions.eq("Status", "y")).list();
			caseTypeList = session.createCriteria(MasCaseType.class).add(
					Restrictions.eq("Status", "y")).list();
			diagnosisList = session.createCriteria(MasDiagnosisConclusion.class)
					.add(Restrictions.eq("Status", "y")).list();
			disposalList = session.createCriteria(MasDisposal.class).add(
					Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//	session.close();
		}

		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		map.put("complaintList", complaintList);
		map.put("caseTypeList", caseTypeList);
		map.put("diagnosisList", diagnosisList);
		map.put("disposalList", disposalList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> saveVisitInformation(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		Set<AppPatientAppointments> patientAppSet = new HashSet<AppPatientAppointments>();
		List<Visit> visitList = new ArrayList<Visit>();
		Visit visit = (Visit) mapForDs.get("visit");
		int currenVisitNo = (Integer) mapForDs.get("currenVisitNo");
		int hinId = (Integer) mapForDs.get("hinId");
		boolean successfullyAdded = false;
		Session session = (Session) getSession();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(visit);

			Patient patient = (Patient) hbt.load(Patient.class, hinId);
			patient.setCurrentVisitNo(currenVisitNo);
			hbt.update(patient);
			patientAppSet = patient.getAppPatientAppointments();
			for (AppPatientAppointments appPatientAppointments : patientAppSet) {

				if (HMSUtil.convertDateToStringWithoutTime(
						appPatientAppointments.getAppointmentDate()).equals(
						currentDate)
						&& appPatientAppointments.getAppointmentStatus()
								.equals("y")) {
					AppPatientAppointments patientAppObj = (AppPatientAppointments) hbt
							.load(AppPatientAppointments.class,
									appPatientAppointments.getId());
					patientAppObj.setAppointmentStatus("v");
					hbt.update(patientAppObj);
				}
			}

			visitList = session.createCriteria(Visit.class).createAlias("Hin",
					"Hin").add(Restrictions.eq("Hin.Id", patient.getId())).add(
					Restrictions.eq("Hin.CurrentVisitNo", currenVisitNo)).add(
					Restrictions.eq("Status", "y")).list();

			successfullyAdded = true;
		}catch (HibernateException e){
			e.printStackTrace();
			successfullyAdded = false;
		//	session.close();
		} catch (Exception e) {
			e.printStackTrace();
			successfullyAdded = false;

		}

		map.put("successfullyAdded", successfullyAdded);
		map.put("visitList", visitList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public List commonQueryForList(String tblName) {
		List list = new ArrayList();
		list = getHibernateTemplate().find(
				"from jkt.hms.masters.business." + tblName
						+ " as mr where mr.Status='y'");
		return list;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getUpdateRegistrationDetails() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasReligion> religionList = null;
		List<MasTitle> titleList = null;
		List<MasOccupation> occupationList = null;
		List<MasMaritalStatus> maritalStatusList = null;
		List<MasRelation> relationList = null;
		List<MasReference> referenceList = null;
		List<MasCountry> countryList = null;
		List<MasState> stateList = null;
		List<MasDistrict> districtList = null;
		List<MasBlock> blockList = null;
		List<MasRecordOfficeAddress> recordOfficeAddressList = null;
		List<MasBloodGroup> bloodGroupList = null;
		List<MasDiagnosisConclusion> diagnosisList = null;
		List<MasDisposal> disposalList = null;
		List<MasAdministrativeSex> sexList =null;
		List<MasUnit> unitList = null;
		List<MasTrade> tradeList = null;
		Session session = (Session) getSession();

		try {
			unitList = session.createQuery(
					"select dist from MasUnit as dist order by dist.UnitName ")
					.list();
			titleList = session.createCriteria(MasTitle.class).add(
					Restrictions.eq("Status", "y")).list();
			maritalStatusList = session.createCriteria(MasMaritalStatus.class)
					.add(Restrictions.eq("Status", "y")).list();
			countryList = session.createCriteria(MasCountry.class).add(
					Restrictions.eq("Status", "y")).list();
			stateList = session.createCriteria(MasState.class).add(
					Restrictions.eq("Status", "y")).list();
			districtList = session.createCriteria(MasDistrict.class).add(
					Restrictions.eq("Status", "y")).list();
			blockList = session.createCriteria(MasBlock.class).add(
					Restrictions.eq("Status", "y")).list();
			religionList = session.createCriteria(MasReligion.class).add(
					Restrictions.eq("Status", "y")).list();
			relationList = session.createCriteria(MasRelation.class).add(
					Restrictions.eq("Status", "y")).list();
			occupationList = session.createCriteria(MasOccupation.class).add(
					Restrictions.eq("Status", "y")).list();
			referenceList = session.createCriteria(MasReference.class).add(
					Restrictions.eq("Status", "y")).list();
			recordOfficeAddressList = session.createCriteria(
					MasRecordOfficeAddress.class).add(
					Restrictions.eq("Status", "y")).list();
			bloodGroupList = session.createCriteria(MasBloodGroup.class).add(
					Restrictions.eq("Status", "y")).list();
			diagnosisList = session
					.createCriteria(MasDiagnosisConclusion.class).add(
							Restrictions.eq("Status", "y")).list();
			disposalList = session.createCriteria(MasDisposal.class).add(
					Restrictions.eq("Status", "y")).list();
			sexList = session.createCriteria(MasAdministrativeSex.class).add(
					Restrictions.eq("Status", "y")).list();
			tradeList = session.createCriteria(MasTrade.class).list();
		}catch (HibernateException e){
			e.printStackTrace();
			//session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		map.put("maritalStatusList", maritalStatusList);
		map.put("recordOfficeAddressList", recordOfficeAddressList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("diagnosisList", diagnosisList);
		map.put("disposalList", disposalList);
		map.put("sexList", sexList);
		map.put("titleList", titleList);
		map.put("countryList", countryList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("blockList", blockList);
		map.put("religionList", religionList);
		map.put("relationList", relationList);
		map.put("occupationList", occupationList);
		map.put("referenceList", referenceList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	/*public boolean updateRegistrationInformation(Map<String, Object> mapForDs) {
		boolean updatedSuccessfully = false;

		int hinId = (Integer) mapForDs.get("hinId");
		Session session = (Session) getSession();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			if (mapForDs.get("masUnitObj") != null) {
				MasUnit masUnit = (MasUnit) mapForDs.get("masUnitObj");
				hbt.save(masUnit);
			}
			Patient patientObj = (Patient) hbt.load(Patient.class, hinId);
			if (mapForDs.get("masUnitObj") != null) {
				unitList = hbt
						.find("select max(id) from jkt.hms.masters.business.MasUnit");
				MasUnit masUnitObj = new MasUnit();
				masUnitObj.setId(Integer.parseInt("" + unitList.get(0)));
				patientObj.setUnit(masUnitObj);
			}
			if (mapForDs.get("titleId") != null) {
				int titleId = (Integer) mapForDs.get("titleId");
				MasTitle masTitle = new MasTitle();
				masTitle.setId(titleId);
				patientObj.setTitle(masTitle);
			}
			if (mapForDs.get("rankId") != null) {
				int rankId = (Integer) mapForDs.get("rankId");
				MasRank masRank = new MasRank();
				masRank.setId(rankId);
				patientObj.setRank(masRank);
			}

			if (mapForDs.get("tradeId") != null) {
				int tradeId = (Integer) mapForDs.get("tradeId");
				MasTrade masTrade = new MasTrade();
				masTrade.setId(tradeId);
				patientObj.setTrade(masTrade);
			}

			if (mapForDs.get("sFirstName") != null) {
				String SfirstName = (String) mapForDs.get("sFirstName");
				patientObj.setSFirstName(SfirstName);
			}
			if (mapForDs.get("sMiddleName") != null) {
				String SmiddleName = (String) mapForDs.get("sMiddleName");
				patientObj.setSMiddleName(SmiddleName);
			}
			if (mapForDs.get("sLastName") != null) {
				String SlastName = (String) mapForDs.get("sLastName");
				patientObj.setSLastName(SlastName);
			}

			if (mapForDs.get("pFirstName") != null) {
				String firstName = (String) mapForDs.get("pFirstName");
				patientObj.setPFirstName(firstName);
			}
			if (mapForDs.get("pMiddleName") != null) {
				String middleName = (String) mapForDs.get("pMiddleName");
				patientObj.setPMiddleName(middleName);
			}
			if (mapForDs.get("unitId") != null) {
				Integer unitId = Integer.parseInt("" + mapForDs.get("unitId"));
				MasUnit masUnit = new MasUnit();
				masUnit.setId(unitId);
				patientObj.setUnit(masUnit);
			}
			if (mapForDs.get("pLastName") != null) {
				String lastName = (String) mapForDs.get("pLastName");
				patientObj.setPLastName(lastName);
			}
			if (mapForDs.get("address") != null) {
				String address = (String) mapForDs.get("address");
				patientObj.setAddress(address);
			}
			if (mapForDs.get("dateOfBirth") != null) {
				Date dateOfBirth = (Date) mapForDs.get("dateOfBirth");
				patientObj.setDateOfBirth(dateOfBirth);
			}
			if (mapForDs.get("age") != null) {
				String age = (String) mapForDs.get("age");
				patientObj.setAge(age);
			}
			if (mapForDs.get("phoneNumber") != null) {
				String phoneNo = (String) mapForDs.get("phoneNumber");
				patientObj.setPhoneNumber(phoneNo);
			}
			if (mapForDs.get("countryId") != null) {
				int countryId = (Integer) mapForDs.get("countryId");
				MasCountry masCountry = new MasCountry();
				masCountry.setId(countryId);
				patientObj.setCountry(masCountry);
			}
			if (mapForDs.get("stateId") != null) {
				int stateId = (Integer) mapForDs.get("stateId");
				MasState masState = new MasState();
				masState.setId(stateId);
				patientObj.setState(masState);
			}
			if (mapForDs.get("genderId") != null) {
				int genderId = (Integer) mapForDs.get("genderId");
				MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
				masAdministrativeSex.setId(genderId);
				patientObj.setSex(masAdministrativeSex);
			}

			if (mapForDs.get("dateOfBirth") != null) {
				Date dateOfBirth = (Date) mapForDs.get("dateOfBirth");
				patientObj.setDateOfBirth(dateOfBirth);
			}
			if (mapForDs.get("religionId") != null) {
				int religion = (Integer) mapForDs.get("religionId");
				patientObj.setReligion(new MasReligion(religion));
			}

			if (mapForDs.get("city") != null) {
				String city = (String) mapForDs.get("city");
				patientObj.setCity(city);
			}
			if (mapForDs.get("districtId") != null) {
				int districtId = (Integer) mapForDs.get("districtId");
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(districtId);
				patientObj.setDistrict(masDistrict);
			}
			if (mapForDs.get("blockId") != null) {
				int blockId = (Integer) mapForDs.get("blockId");
				MasBlock masBlock = new MasBlock();
				masBlock.setId(blockId);
				patientObj.setBlock(masBlock);
			}
			if (mapForDs.get("pinCode") != null) {
				String pincode = (String) mapForDs.get("pinCode");
				patientObj.setPinCode(pincode);
			}
			if (mapForDs.get("patientDistrict") != null) {
				String patientDistrict = (String) mapForDs
						.get("patientDistrict");
				patientObj.setPatientDistrict(patientDistrict);
			}
			if (mapForDs.get("postOffice") != null) {
				String postOffice = (String) mapForDs.get("postOffice");
				patientObj.setPostOffice(postOffice);
			}
			if (mapForDs.get("policeStation") != null) {
				String policeStation = (String) mapForDs.get("policeStation");
				patientObj.setPoliceStation(policeStation);
			}
			if (mapForDs.get("mobileNo") != null) {
				String mobileNo = (String) mapForDs.get("mobileNo");
				patientObj.setMobileNumber(mobileNo);
			}
			if (mapForDs.get("emailId") != null) {
				String emailId = (String) mapForDs.get("emailId");
				patientObj.setEmailId(emailId);
			}
			if (mapForDs.get("occupationId") != null) {
				int occupationId = (Integer) mapForDs.get("occupationId");
				MasOccupation masOccupation = new MasOccupation();
				masOccupation.setId(occupationId);
				patientObj.setOccupation(masOccupation);
			}
			if (mapForDs.get("bloodGroupId") != null) {
				int bloodGroupId = (Integer) mapForDs.get("bloodGroupId");
				MasBloodGroup masBloodGroup = new MasBloodGroup();
				masBloodGroup.setId(bloodGroupId);
				patientObj.setBloodGroup(masBloodGroup);
			}
			if (mapForDs.get("maritalStatusId") != null) {
				int maritalStatusId = (Integer) mapForDs.get("maritalStatusId");
				MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
				masMaritalStatus.setId(maritalStatusId);
				patientObj.setMaritalStatus(masMaritalStatus);
			}
			if (mapForDs.get("relativeName") != null) {
				String relativeName = (String) mapForDs.get("relativeName");
				patientObj.setNextOfKinName(relativeName);
			}
			if (mapForDs.get("nokAddress") != null) {
				String nokAddress = (String) mapForDs.get("nokAddress");
				patientObj.setNextOfKinAddress(nokAddress);
			}
			if (mapForDs.get("nokPhone") != null) {
				String nokPhone = (String) mapForDs.get("nokPhone");
				patientObj.setNextOfKinPhoneNumber(nokPhone);
			}
			if (mapForDs.get("nokRelationId") != null) {
				int nokRelationId = (Integer) mapForDs.get("nokRelationId");
				MasRelation masRelationObj = new MasRelation();
				masRelationObj.setId(nokRelationId);
				patientObj.setNextOfKinRelation(masRelationObj);
			}
			if (mapForDs.get("formation") != null) {
				String formation = (String) mapForDs.get("formation");
				patientObj.setFormation(formation);
			}
			if (mapForDs.get("totalService") != null) {
				String servYear = (String) mapForDs.get("totalService");
				Float totalService = Float.parseFloat(servYear);
				patientObj.setServiceYears(totalService);
			}
			if (mapForDs.get("station") != null) {
				String station = (String) mapForDs.get("station");
				patientObj.setStation(station);
			}
			if (mapForDs.get("cdAccNo") != null) {
				String cdAccNo = (String) mapForDs.get("cdAccNo");
				patientObj.setCdaAccountNo(cdAccNo);
			}
			if (mapForDs.get("remarks") != null) {
				String remarks = (String) mapForDs.get("remarks");
				patientObj.setRemarks(remarks);
			}
			if (mapForDs.get("referenceId") != null) {
				int referenceId = (Integer) mapForDs.get("referenceId");
				MasReference masReference = new MasReference();
				masReference.setId(referenceId);
				patientObj.setReference(masReference);
			}
			if (mapForDs.get("recordOfficeAddId") != null) {
				int recordOfficeAddId = (Integer) mapForDs
						.get("recordOfficeAddId");
				MasRecordOfficeAddress masRecordOfficeAddress = new MasRecordOfficeAddress();
				masRecordOfficeAddress.setId(recordOfficeAddId);
				patientObj.setRecordOfficeAddress(masRecordOfficeAddress);
			}
			Date addEditDate = null;
			if (mapForDs.get("addEditDate") != null) {
				addEditDate = (Date) mapForDs.get("addEditDate");
				patientObj.setAddEditDate(addEditDate);
			}
			String addEditTime = "";
			if (mapForDs.get("addEditTime") != null) {
				addEditTime = (String) mapForDs.get("addEditTime");
				patientObj.setAddEditTime(addEditTime);
			}
			int userId = 0;
			if (mapForDs.get("userId") != null) {
				userId = (Integer) mapForDs.get("userId");
				Users users = new Users();
				users.setId(userId);
				patientObj.setAddEditBy(users);
			}

			if (mapForDs.get("ICardVer") != null) {
				String ICardVer = (String) mapForDs.get("ICardVer");
				patientObj.setServiceCardStatus(ICardVer);

				if (ICardVer.equals("n")) {
					patientObj.setServiceCardValidityDate(null);
				} else {
					if (mapForDs.get("ICardDate") != null) {
						Date ICardDate = (Date) mapForDs.get("ICardDate");
						patientObj.setServiceCardValidityDate(ICardDate);
					}
				}

				if (ICardVer.equals("n")) {
					patientObj.setDependentCardIssueDate(null);
				} else {
					if (mapForDs.get("DCardDate") != null) {
						Date DCardDate = (Date) mapForDs.get("DCardDate");
						patientObj.setDependentCardIssueDate(DCardDate);
					}
				}
			}
			hbt.update(patientObj);

			List<Visit> visitList = new ArrayList<Visit>();
			visitList = session.createCriteria(Visit.class).add(
					Restrictions.eq("VisitNo", 1)).createAlias("Hin", "p").add(
					Restrictions.eq("p.Id", hinId)).list();
			int visitId = 0;
			if (visitList.size() > 0) {
				Visit visitObj = new Visit();
				for (Visit visit : visitList) {
					visitId = (Integer) visit.getId();
					visitObj = (Visit) hbt.load(Visit.class, visitId);
					if (mapForDs.get("diagnosisId") != null) {
						String diagnosis = (String) mapForDs.get("diagnosisId");
						visitObj.setDiagnosisString(diagnosis);
					}
					if (mapForDs.get("disposalId") != null) {
						int disposalId = (Integer) mapForDs.get("disposalId");
						MasDisposal masDisposal = new MasDisposal();
						masDisposal.setId(disposalId);
						visitObj.setDisposal(masDisposal);
					}
					Users users = new Users();
					users.setId(userId);
					visitObj.setAddEditBy(users);
					visitObj.setAddEditDate(addEditDate);
					visitObj.setAddEditTime(addEditTime);

				}
				hbt.update(visitObj);
			}

			updatedSuccessfully = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return updatedSuccessfully;
	}
*/

	// commented by Vishal in Bangalore and place new code from Noida
	public boolean updateRegistrationInformation(Map<String, Object> mapForDs) {
		boolean updatedSuccessfully = false;

		int hinId = (Integer) mapForDs.get("hinId");
		Session session = (Session) getSession();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			if (mapForDs.get("masUnitObj") != null) {
				MasUnit masUnit = (MasUnit) mapForDs.get("masUnitObj");
				hbt.save(masUnit);
			}
			Patient patientObj = (Patient) hbt.load(Patient.class, hinId);
			if (mapForDs.get("masUnitObj") != null) {
				unitList = hbt
						.find("select max(id) from jkt.hms.masters.business.MasUnit");
				MasUnit masUnitObj = new MasUnit();
				masUnitObj.setId(Integer.parseInt("" + unitList.get(0)));
				patientObj.setUnit(masUnitObj);
			}

			if (mapForDs.get("masTradeObj") != null) {
				MasTrade masTrade = (MasTrade) mapForDs.get("masTradeObj");
				hbt.save(masTrade);
				hbt.refresh(masTrade);
				patientObj.setTrade(masTrade);
			}

			if (mapForDs.get("titleId") != null) {
				int titleId = (Integer) mapForDs.get("titleId");
				MasTitle masTitle = new MasTitle();
				masTitle.setId(titleId);
				patientObj.setTitle(masTitle);
			}
			if (mapForDs.get("rankId") != null) {
				int rankId = (Integer) mapForDs.get("rankId");
				MasRank masRank = new MasRank();
				masRank.setId(rankId);
				patientObj.setRank(masRank);
			}

			if (mapForDs.get("sFirstName") != null) {
				String SfirstName = (String) mapForDs.get("sFirstName");
				patientObj.setSFirstName(SfirstName);
			}
			if (mapForDs.get("sMiddleName") != null) {
				String SmiddleName = (String) mapForDs.get("sMiddleName");
				patientObj.setSMiddleName(SmiddleName);
			}
			if (mapForDs.get("sLastName") != null) {
				String SlastName = (String) mapForDs.get("sLastName");
				patientObj.setSLastName(SlastName);
			}

			if (mapForDs.get("pFirstName") != null) {
				String firstName = (String) mapForDs.get("pFirstName");
				patientObj.setPFirstName(firstName);
			}
			if (mapForDs.get("pMiddleName") != null) {
				String middleName = (String) mapForDs.get("pMiddleName");
				patientObj.setPMiddleName(middleName);
			}
			if (mapForDs.get("unitId") != null) {
				Integer unitId = Integer.parseInt("" + mapForDs.get("unitId"));
				MasUnit masUnit = new MasUnit();
				masUnit.setId(unitId);
				patientObj.setUnit(masUnit);
			}
			if (mapForDs.get("tradeId") != null) {
				Integer tradeId = Integer.parseInt("" + mapForDs.get("tradeId"));
				MasTrade masTrade = new MasTrade();
				masTrade.setId(tradeId);
				patientObj.setTrade(masTrade);
			}
			if (mapForDs.get("pLastName") != null) {
				String lastName = (String) mapForDs.get("pLastName");
				patientObj.setPLastName(lastName);
			}
			if (mapForDs.get("address") != null) {
				String address = (String) mapForDs.get("address");
				patientObj.setAddress(address);
			}
			if (mapForDs.get("dateOfBirth") != null) {
				Date dateOfBirth = (Date) mapForDs.get("dateOfBirth");
				patientObj.setDateOfBirth(dateOfBirth);
			}
			if (mapForDs.get("age") != null) {
				String age = (String) mapForDs.get("age");
				patientObj.setAge(age);
			}
			if (mapForDs.get("phoneNumber") != null) {
				String phoneNo = (String) mapForDs.get("phoneNumber");
				patientObj.setPhoneNumber(phoneNo);
			}
			if (mapForDs.get("countryId") != null) {
				int countryId = (Integer) mapForDs.get("countryId");
				MasCountry masCountry = new MasCountry();
				masCountry.setId(countryId);
				patientObj.setCountry(masCountry);
			}
			if (mapForDs.get("stateId") != null) {
				int stateId = (Integer) mapForDs.get("stateId");
				MasState masState = new MasState();
				masState.setId(stateId);
				patientObj.setState(masState);
			}
			if (mapForDs.get("genderId") != null) {
				int genderId = (Integer) mapForDs.get("genderId");
				MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
				masAdministrativeSex.setId(genderId);
				patientObj.setSex(masAdministrativeSex);
			}

			if (mapForDs.get("dateOfBirth") != null) {
				Date dateOfBirth = (Date) mapForDs.get("dateOfBirth");
				patientObj.setDateOfBirth(dateOfBirth);
			}
			if (mapForDs.get("religionId") != null) {
				int religion = (Integer) mapForDs.get("religionId");
				patientObj.setReligion(new MasReligion(religion));
			}

			if (mapForDs.get("city") != null) {
				String city = (String) mapForDs.get("city");
				patientObj.setCity(city);
			}
			if (mapForDs.get("districtId") != null) {
				int districtId = (Integer) mapForDs.get("districtId");
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(districtId);
				patientObj.setDistrict(masDistrict);
			}
			if (mapForDs.get("blockId") != null) {
				int blockId = (Integer) mapForDs.get("blockId");
				MasBlock masBlock = new MasBlock();
				masBlock.setId(blockId);
				patientObj.setBlock(masBlock);
			}
			if (mapForDs.get("pinCode") != null) {
				String pincode = (String) mapForDs.get("pinCode");
				patientObj.setPinCode(pincode);
			}
			if (mapForDs.get("patientDistrict") != null) {
				String patientDistrict = (String) mapForDs
						.get("patientDistrict");
				patientObj.setPatientDistrict(patientDistrict);
			}
			if (mapForDs.get("postOffice") != null) {
				String postOffice = (String) mapForDs.get("postOffice");
				patientObj.setPostOffice(postOffice);
			}
			if (mapForDs.get("policeStation") != null) {
				String policeStation = (String) mapForDs.get("policeStation");
				patientObj.setPoliceStation(policeStation);
			}
			if (mapForDs.get("mobileNo") != null) {
				String mobileNo = (String) mapForDs.get("mobileNo");
				patientObj.setMobileNumber(mobileNo);
			}
			if (mapForDs.get("emailId") != null) {
				String emailId = (String) mapForDs.get("emailId");
				patientObj.setEmailId(emailId);
			}
			if (mapForDs.get("occupationId") != null) {
				int occupationId = (Integer) mapForDs.get("occupationId");
				MasOccupation masOccupation = new MasOccupation();
				masOccupation.setId(occupationId);
				patientObj.setOccupation(masOccupation);
			}
			if (mapForDs.get("bloodGroupId") != null) {
				int bloodGroupId = (Integer) mapForDs.get("bloodGroupId");
				MasBloodGroup masBloodGroup = new MasBloodGroup();
				masBloodGroup.setId(bloodGroupId);
				patientObj.setBloodGroup(masBloodGroup);
			}
			if (mapForDs.get("maritalStatusId") != null) {
				int maritalStatusId = (Integer) mapForDs.get("maritalStatusId");
				MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
				masMaritalStatus.setId(maritalStatusId);
				patientObj.setMaritalStatus(masMaritalStatus);
			}
			if (mapForDs.get("relativeName") != null) {
				String relativeName = (String) mapForDs.get("relativeName");
				patientObj.setNextOfKinName(relativeName);
			}
			if (mapForDs.get("nokAddress") != null) {
				String nokAddress = (String) mapForDs.get("nokAddress");
				patientObj.setNextOfKinAddress(nokAddress);
			}
			if (mapForDs.get("nokPhone") != null) {
				String nokPhone = (String) mapForDs.get("nokPhone");
				patientObj.setNextOfKinPhoneNumber(nokPhone);
			}
			if (mapForDs.get("nokRelationId") != null) {
				int nokRelationId = (Integer) mapForDs.get("nokRelationId");
				MasRelation masRelationObj = new MasRelation();
				masRelationObj.setId(nokRelationId);
				patientObj.setNextOfKinRelation(masRelationObj);
			}
			if (mapForDs.get("formation") != null) {
				String formation = (String) mapForDs.get("formation");
				patientObj.setFormation(formation);
			}
			Float totalService=null;
			String servicePeriod="";
			if (mapForDs.get("totalService") != null) {
				 totalService =(Float) mapForDs.get("totalService");
				patientObj.setServiceYears(totalService);
			}
			if (mapForDs.get("servicePeriod") != null) {
				servicePeriod = (String) mapForDs.get("servicePeriod");
				patientObj.setTotalServicePeriod(servicePeriod);
			}
			if (mapForDs.get("station") != null) {
				String station = (String) mapForDs.get("station");
				patientObj.setStation(station);
			}
			if (mapForDs.get("cdAccNo") != null) {
				String cdAccNo = (String) mapForDs.get("cdAccNo");
				patientObj.setCdaAccountNo(cdAccNo);
			}
			if (mapForDs.get("remarks") != null) {
				String remarks = (String) mapForDs.get("remarks");
				patientObj.setRemarks(remarks);
			}
			if (mapForDs.get("referenceId") != null) {
				int referenceId = (Integer) mapForDs.get("referenceId");
				MasReference masReference = new MasReference();
				masReference.setId(referenceId);
				patientObj.setReference(masReference);
			}
			if (mapForDs.get("recordOfficeAddId") != null) {
				int recordOfficeAddId = (Integer) mapForDs
						.get("recordOfficeAddId");
				MasRecordOfficeAddress masRecordOfficeAddress = new MasRecordOfficeAddress();
				masRecordOfficeAddress.setId(recordOfficeAddId);
				patientObj.setRecordOfficeAddress(masRecordOfficeAddress);
			}
			Date addEditDate = null;
			if (mapForDs.get("addEditDate") != null) {
				addEditDate = (Date) mapForDs.get("addEditDate");
				patientObj.setAddEditDate(addEditDate);
			}
			String addEditTime = "";
			if (mapForDs.get("addEditTime") != null) {
				addEditTime = (String) mapForDs.get("addEditTime");
				patientObj.setAddEditTime(addEditTime);
			}
			int userId = 0;
			if (mapForDs.get("userId") != null) {
				userId = (Integer) mapForDs.get("userId");
				Users users = new Users();
				users.setId(userId);
				patientObj.setAddEditBy(users);
			}

			if (mapForDs.get("ICardVer") != null) {
				String ICardVer = (String) mapForDs.get("ICardVer");
				patientObj.setServiceCardStatus(ICardVer);

				if (ICardVer.equals("n")) {
					patientObj.setServiceCardValidityDate(null);
				} else {
					if (mapForDs.get("ICardDate") != null) {
						Date ICardDate = (Date) mapForDs.get("ICardDate");
						patientObj.setServiceCardValidityDate(ICardDate);
					}
				}

				if (ICardVer.equals("n")) {
					patientObj.setDependentCardIssueDate(null);
				} else {
					if (mapForDs.get("DCardDate") != null) {
						Date DCardDate = (Date) mapForDs.get("DCardDate");
						patientObj.setDependentCardIssueDate(DCardDate);
					}
				}
			}
			hbt.update(patientObj);

			List<Visit> visitList = new ArrayList<Visit>();
			visitList = session.createCriteria(Visit.class).add(
					Restrictions.eq("VisitNo", 1)).createAlias("Hin", "p").add(
					Restrictions.eq("p.Id", hinId)).list();
			int visitId = 0;
			if (visitList.size() > 0) {
				Visit visitObj = new Visit();
				for (Visit visit : visitList) {
					visitId = (Integer) visit.getId();
					visitObj = (Visit) hbt.load(Visit.class, visitId);
					if (mapForDs.get("diagnosisId") != null) {
						String diagnosis = (String) mapForDs.get("diagnosisId");
						/*visitObj.setDiagnosisString(diagnosis);*/
					}
					if (mapForDs.get("disposalId") != null) {
						int disposalId = (Integer) mapForDs.get("disposalId");
						MasDisposal masDisposal = new MasDisposal();
						masDisposal.setId(disposalId);
						visitObj.setDisposal(masDisposal);
					}
					Users users = new Users();
					users.setId(userId);
					visitObj.setAddEditBy(users);
					visitObj.setAddEditDate(addEditDate);
					visitObj.setAddEditTime(addEditTime);

				}
				hbt.update(visitObj);
			}

			updatedSuccessfully = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			//session.close();
		}

		return updatedSuccessfully;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getServiceTypeAndRelation(
			Map<String, Object> parameterMap) {
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasServiceStatus> serviceStatusList = new ArrayList<MasServiceStatus>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		Map<String, Object> map = new HashMap<String, Object>();

		int relationId = 0;
		int serviceTypeId = 0;
		int serviceStatusId = 0;

		if (parameterMap.get("serviceTypeId") != null) {
			serviceTypeId = (Integer) parameterMap.get("serviceTypeId");
		}
		if (parameterMap.get("serviceStatusId") != null) {
			serviceStatusId = (Integer) parameterMap.get("serviceStatusId");
		}
		if (parameterMap.get("relationId") != null) {
			relationId = (Integer) parameterMap.get("relationId");
		}

		Session session = (Session) getSession();

		serviceTypeList = session.createCriteria(MasServiceType.class).add(
				Restrictions.idEq(serviceTypeId)).list();
		String serviceTypeCode = "";
		for (MasServiceType masServiceType : serviceTypeList) {
			serviceTypeCode = masServiceType.getServiceTypeCode();
			map.put("serviceTypeCode", serviceTypeCode);
		}
		relationList = session.createCriteria(MasRelation.class).add(
				Restrictions.idEq(relationId)).list();
		String relationCode = "";
		for (MasRelation masRelation : relationList) {
			relationCode = masRelation.getRelationCode();
			map.put("relationCode", relationCode);
		}
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(
				Restrictions.idEq(serviceStatusId)).list();
		String serviceStatusCode = "";
		for (MasServiceStatus masServiceStatus : serviceStatusList) {
			serviceStatusCode = masServiceStatus.getServiceStatusCode();
			map.put("serviceStatusCode", serviceStatusCode);
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientTypeCodeAndRelationCode(
			HttpServletRequest request) {
		List<MasRelation> masRelationList = new ArrayList<MasRelation>();
		List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();	
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession ses = request.getSession();
		Session session = (Session) getSession();

		int relationId = 0;
		int patientTypeId = 0;
		String patientTypeName = "";
		int hospitalId = 0;
		if (ses.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) ses.getAttribute(HOSPITAL_ID);
		}


		if (request.getParameter("relationId") != null && !request.getParameter("relationId").trim().equals("")) {
			relationId =  Integer.parseInt(request.getParameter("relationId"));
		}
		
		masRelationList = session.createCriteria(MasRelation.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.idEq(relationId)).list();
		String relationCode = "";
		for (MasRelation masRelation : masRelationList) {
			relationCode = masRelation.getNewRelationCode();
			map.put("relationCode", relationCode);
		}	
		
		Criteria cr = session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase());
		if (request.getParameter("patientTypeId") != null && !request.getParameter("patientTypeId").trim().equals("")) {
			patientTypeId =  Integer.parseInt(request.getParameter("patientTypeId"));
			cr.add(Restrictions.idEq(patientTypeId));		}
		if (request.getParameter("patientTypeName") != null && !request.getParameter("patientTypeName").trim().equals("")) {
			patientTypeName = (String) request.getParameter("patientTypeName");
			cr.add(Restrictions.eq("PatientTypeName",patientTypeName));
		}
		patientTypeList = cr.list();
			
		
		String patientCode = "";
		for (MasPatientType masPatientType : patientTypeList) {
			patientCode = masPatientType.getPatientTypeCode();
			map.put("patientCode", patientCode);
		}
		return map;
	}

	
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitPendingForApproval(
			HttpServletRequest request) {		
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
        Patient patient = new Patient();
        boolean successfullyupdated= false;
		try{
			if (request.getParameter("flag") != null && !request.getParameter("flag").trim().equals("")) {
				String PaymentApproval = (String)request.getParameter("flag");
				int approvedBy = Integer.parseInt(request.getParameter("approvedBy"));
				MasEmployee emp = new MasEmployee();
				emp.setId(approvedBy);
				System.out.println("PaymentApproval"+PaymentApproval);
				Integer id = Integer.parseInt(request.getParameter("patientId"));
				patient = (Patient)session.load(Patient.class, id);
				patient.setBillable(PaymentApproval);
				patient.setApprovedBy(emp);
				session.update(patient);
				session.flush();
				successfullyupdated = true;
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		map.put("successfullyupdated", successfullyupdated);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitReferral(
			HttpServletRequest request) {		
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
        Patient patient = new Patient();
        OpdPatientDetails opdPDetails = new OpdPatientDetails();
        boolean succesfullyAdded= false;
        int hinId = 0;
        int opdPDetailsId = 0;
        /*int maxHinId = getMaxHinId();*/
		int currentVisitNo =0;
		String rptForArr = "";
		int deptId = 0;
		int consultingDoctorId = 0;
		int consultingsessionId= 0;
		Visit visit = new Visit();
		String tokenAndDoctor = "";
		int tokenNo = 0;
		String msg = "";
		HttpSession ses = request.getSession();
		int servicePersonRelationId = 0;
		int serTypeId = 0;
		String hinNo = "";
		String serviceNo = "";
		Map<String, Object> objectMap = new HashMap<String, Object>();
		Users user = (Users) ses.getAttribute("users");
		patient.setAddEditBy(user);
		objectMap.put("user", user);
		int hospitalId = (Integer) ses.getAttribute(HOSPITAL_ID);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		Date addEditDate = null;
		String token = "";
		if (request.getParameter(CHANGED_DATE) != null) {
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			patient.setAddEditDate(addEditDate);
		}

		String addEditTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			addEditTime = request.getParameter(CHANGED_TIME);
			patient.setAddEditTime(addEditTime);
		}

		Date regDate = null;
		if (request.getParameter(REG_DATE) != null) {
			regDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(REG_DATE));
			patient.setRegDate(regDate);
		}
		String regTime = "";
		if (request.getParameter(REG_TIME) != null) {
			regTime = request.getParameter(REG_TIME);
			patient.setRegTime(regTime);
		}
		
		String departmentTypeCodeForOpd="";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			properties.load(resourcePath.openStream());			 
			departmentTypeCodeForOpd=properties.getProperty("departmentTypeCodeForOpd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (request.getParameter("opdPDetailsId") != null && !request.getParameter("opdPDetailsId").trim().equals("")) {
				opdPDetailsId = Integer.parseInt(request.getParameter("opdPDetailsId"));	
				opdPDetails = (OpdPatientDetails)hbt.load(OpdPatientDetails.class, opdPDetailsId);
				hinId = opdPDetails.getVisit().getHin().getId();
				 patient = (Patient)session.load(Patient.class, hinId);
				
				        visit.setReportingFor("OPD");						
						if (request.getParameter(DEPARTMENT_ID) != null
								&& !request.getParameter(DEPARTMENT_ID).trim().equals("")) {
							MasDepartment masDepartment = new MasDepartment();
							deptId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
							masDepartment.setId(deptId);							
							visit.setDepartment(masDepartment);
						}
						
						
						if (request.getParameter(EMPLOYEE_ID) != null
								&& !request.getParameter(EMPLOYEE_ID).trim().equals("") && request.getParameter(SESSION_ID) != null
										&& !request.getParameter(SESSION_ID).equals("0")) {
							consultingDoctorId = Integer.parseInt(request
									.getParameter(EMPLOYEE_ID));
							consultingsessionId = Integer.parseInt(request
									.getParameter(SESSION_ID));
							MasEmployee consultingDoctorObj = new MasEmployee();
							consultingDoctorObj.setId(consultingDoctorId);
							visit.setDoctor(consultingDoctorObj);
							MasSession consultingSessionobj = new MasSession();
							consultingSessionobj.setId(consultingsessionId);
							visit.setSession(consultingSessionobj);						
							
							 token = getTokenNoForDepartment(consultingDoctorId, consultingsessionId, deptId, request);
								if(HMSUtil.isInteger(token))
								{
									visit.setTokenNo(Integer.parseInt(token));
									tokenAndDoctor = token + "#" + consultingDoctorId;
									
								}
								else{
									msg = token;
								}
							
						}
						
							
							
						System.out.println("tokenNo-->"+tokenNo);
						System.out.println("consultingDoctorId"+consultingDoctorId+"consultingsessionId"+consultingsessionId+"deptId"+deptId);						
						visit.setTokenDoctor(tokenAndDoctor);
						visit.setHospital(masHospital);
						visit.setAddEditBy(user);
						/*visit.setAge(age);*/
						visit.setVisitDate(addEditDate);
						visit.setVisitTime(addEditTime);
						visit.setAddEditDate(addEditDate);
						visit.setAddEditTime(addEditTime);
						visit.setVisitTime(addEditTime);						
						visit.setStatus("y"); 
						// visit.setEdStatus("n");

						visit.setAppointmentType("D");
						visit.setVisitStatus("w");						

						if (request.getParameter("priority") != null) {
							visit.setPriority(Integer.parseInt(request
									.getParameter("priority")));
						}		
													
						visit.setHin(patient);		
					    
						currentVisitNo = patient.getCurrentVisitNo()+1;
						patient.setCurrentVisitNo(currentVisitNo);
						visit.setVisitNo(currentVisitNo);
						
						visit.setTokenStatus("n");
						visit.setPriority(opdPDetails.getReferralPriority());
						
						
						hbt.saveOrUpdate(patient);
						hbt.save(visit);
						opdPDetails.setReferredStatus("r");
						opdPDetails.setReferralVisit(visit);
						hbt.update(opdPDetails);				
						
						hbt.flush();
						succesfullyAdded = true;			
				
				
			}
			if(msg.trim().equals(""))
			{
				tx.commit();
			}
			else
			{
				if(tx!=null)
				tx.rollback();
				succesfullyAdded = false;
			}
			
		}catch (HibernateException e){
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			//session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}				
		map.put("msg", msg); 
		map.put("succesfullyAdded", succesfullyAdded);
		map.put("visit_id", visit.getId());
		return map;
	}
	@SuppressWarnings("unchecked")
	public String getMothersName(String motherHinNo) {
		List<Patient> list = new ArrayList<Patient>();
		String motherName = "";
		Session session = (Session) getSession();
		list = session.createCriteria(Patient.class).add(
				Restrictions.eq("HinNo", motherHinNo)).list();
		if (list.size() > 0) {
			Patient patient = list.get(0);
			motherName = patient.getPFirstName() + " " + patient.getPLastName();
		}
		return motherName;
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
		public synchronized String getTokenNoForDepartment(int doctorId, int sessionId, int deptId, HttpServletRequest request) {
	        List<Integer> tokenNoList = new ArrayList<Integer>();
	        List<AppPatientAppointments> appPAList = new ArrayList<AppPatientAppointments>();
	        List<DoctorRoaster> docRoasterList = new ArrayList<DoctorRoaster>();
             Criteria crit = null;
             String tokenNoDisplayflag =null;
        
             if(request.getAttribute("tokenNoDisplayflag")!=null && request.getAttribute("tokenNoDisplayflag").equals("n"))
            	 tokenNoDisplayflag ="n";
	        int tokenNo = 0;
	        boolean flag = false;
	        String tokenMsg ="";
	        int cancelledCount = 0;
	        HttpSession ses = request.getSession();
			int hospitalId = 0;
			if (ses.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) ses.getAttribute(HOSPITAL_ID);
			}
	        
	        Session session = (Session) getSession();
	        // tokenNoList = getHibernateTemplate().find("select max(v.TokenNo) from
	        // Visit v join v.Department as dept where dept.Id="+departmentId+"	and
	        // v.VisitDate="+date);
	        Date today = new Date();
	        String dateString = HMSUtil.convertDateToStringFormat(today, "yyyy-MM-dd");
            Date date= null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}     
	        
	        
	    
	       
		
	       
	        System.out.println(doctorId+""+sessionId+""+deptId+""+date);
	        
	        try {
	        	
	        	int mrngSesId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "sessionIdForMrng"));
	        	int evngSesId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "sessionIdForEvng"));
	        	
	        	docRoasterList =session.createCriteria(DoctorRoaster.class)
		        /*.add(Restrictions.eq("v.VisitDate", dateString))*/
				.add(Restrictions.eq("RoasterDate", date))
				.add(Restrictions.eq("Doctor.Id", doctorId))
				//.add(Restrictions.eq("Hospital.Id", hospitalId))
		        .createAlias("Department", "dept").add(Restrictions.eq("dept.Id", deptId)).list();
	     
	        	if(docRoasterList.size()>0)
	        	{
	        		docRoasterList.clear();
	        		crit =session.createCriteria(DoctorRoaster.class)
	        		        /*.add(Restrictions.eq("v.VisitDate", dateString))*/
	        				.add(Restrictions.eq("RoasterDate", date))
	        				.add(Restrictions.eq("Doctor.Id", doctorId))
	        				//.add(Restrictions.eq("Hospital.Id", hospitalId))
	        		        .createAlias("Department", "dept").add(Restrictions.eq("dept.Id", deptId));
	        		if(sessionId==mrngSesId)
		        		crit.add(Restrictions.like("RoasterValue", "y%"));
		        	else if(sessionId==evngSesId)
		        		crit.add(Restrictions.like("RoasterValue", "%y"));
		        	docRoasterList =crit.list();
		        	if(docRoasterList.size()>0)
		        	{
		        	
				tokenNoList = session.createCriteria(Visit.class, "v")
				        /*.add(Restrictions.eq("v.VisitDate", dateString))*/
						.add(Restrictions.eq("v.VisitDate", date))
						.add(Restrictions.eq("v.Hospital.Id", hospitalId))
						.add(Restrictions.ne("v.AppointmentType", "o").ignoreCase())
				        .createAlias("Department", "dept").add(Restrictions.eq("dept.Id", deptId))
				        .createAlias("IntDoctor", "doctor").add(Restrictions.eq("doctor.Id", doctorId))
				        .createAlias("Session", "session").add(Restrictions.eq("session.Id", sessionId))
				        .setProjection(Projections.projectionList().add(Projections.max("TokenNo"))).list();
				 if (tokenNoList.get(0) != null) {
					 tokenNo = tokenNoList.get(0);
					 System.out.println("tokenNo="+tokenNo);
					 
				}
				 else{
					 tokenNo = 0;
				 }
				 do{
					 System.out.println("tokenNo1="+tokenNo);
					 tokenNo++;
					 // checking whether same token no is already book for the online appointment
					 appPAList = session.createCriteria(AppPatientAppointments.class)
						        .add(Restrictions.eq("AppointmentDate", date))	
                                .add(Restrictions.eq("Hospital.Id", hospitalId))	
                                .add(Restrictions.ne("AppointmentStatus", "c").ignoreCase())	             // this condition is for not skipping cancelled token
						        .createAlias("Department", "dept").add(Restrictions.eq("dept.Id", deptId))
						        .createAlias("Employee", "doctor").add(Restrictions.eq("doctor.Id", doctorId))
						        .createAlias("AppSession", "session").add(Restrictions.eq("session.Id", sessionId))
						        .add(Restrictions.eq("QueuePriority", tokenNo)).list();
					 if(appPAList.size()==0)
					 {
						 flag = false;
					 }
					 else
					 {
						 flag = true;
					 }
					 
			      }while(flag);
				 
				 List<AppSetup> setupList=new ArrayList<AppSetup>();				 	
				 String dayName = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
				 System.out.println(new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime()));
				 // getting total no of available token for a doctor 
				 setupList=session.createCriteria(AppSetup.class)
						    .add(Restrictions.eq("Hospital.Id", hospitalId)) 
						    .add(Restrictions.eq("Dept.Id", deptId))
						    .add(Restrictions.eq("Days", dayName))
							.add(Restrictions.eq("Doctor.Id", doctorId))
							.add(Restrictions.eq("Session.Id", sessionId))
							.list();
				 // getting total no of cancelled tokens for a perticular date
				/* cancelledCount = (Integer)session.createCriteria(AppPatientAppointments.class)  // commented because now there is unlimited token provision
						    .add(Restrictions.eq("Hospital.Id", hospitalId))
					        .add(Restrictions.eq("AppointmentDate", date))
					        .add(Restrictions.eq("AppointmentStatus", "c").ignoreCase())
					        .createAlias("Department", "dept").add(Restrictions.eq("dept.Id", deptId))
					        .createAlias("Employee", "doctor").add(Restrictions.eq("doctor.Id", doctorId))
					        .createAlias("AppSession", "session").add(Restrictions.eq("session.Id", sessionId))
					        .setProjection(Projections.rowCount()).uniqueResult();*/
				 System.out.println("cancelledCount"+cancelledCount);
				if(setupList.size()>0)
				{
					if(tokenNo > (setupList.get(0).getTotalToken()+cancelledCount))
					{
						tokenNo = 0;
						//if(tokenNoDisplayflag!=null && tokenNoDisplayflag.equalsIgnoreCase("n"))
							//tokenMsg = String.valueOf(tokenNo);
						//else
						   tokenMsg="Token Full";
					}
					else{
							tokenMsg = String.valueOf(tokenNo);
						
					}
				}
				else
				{
					tokenMsg ="No Appointment Setup";
				} 
		        	}
		        	else
		        		tokenMsg ="Doctor is on leave";
							
	        	}
	        	else
	        		tokenMsg ="Doctor Roaster is not updated";
	        	
				
			} catch (HibernateException e) {
				
				e.printStackTrace();
				//session.close();
			}	        
	        
	        return tokenMsg;
	    }

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientListForName(
			Map<String, Object> parameterMap) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Patient> patientListForInfo = new ArrayList<Patient>();
		int relationId = 0;
		int serviceTypeId = 0;
		int serviceStatusId = 0;
		String serviceNo = "";
		String patientName = "";
		Session session = (Session) getSession();
		if (parameterMap.get("serviceTypeId") != null) {
			serviceTypeId = (Integer) parameterMap.get("serviceTypeId");
		}
		if (parameterMap.get("serviceStatusId") != null) {
			serviceStatusId = (Integer) parameterMap.get("serviceStatusId");
		}
		if (parameterMap.get("relationId") != null) {
			relationId = (Integer) parameterMap.get("relationId");
		}
		if (parameterMap.get("serviceNo") != null) {
			serviceNo = (String) parameterMap.get("serviceNo");
		}
		if (parameterMap.get("patientName") != null) {
			patientName = (String) parameterMap.get("patientName");
		}
		try {
			if (relationId == 8 || relationId == 2 || relationId == 3)
				if (serviceTypeId != 0 && serviceStatusId != 0
						&& relationId != 0 && !(serviceNo.equals(""))
						&& !(patientName.equals(""))) {
					patientList = session.createCriteria(Patient.class).add(
							Restrictions.eq("ServiceNo", serviceNo))
							.createAlias("ServiceType", "ST").add(Restrictions.eq("ST.Id", serviceTypeId))
							.createAlias("ServiceStatus", "SS").add(Restrictions.eq("SS.Id", serviceStatusId))
							.createAlias("Relation","Re").add(Restrictions.eq("Re.Id",relationId )).list();
				}
			patientListForInfo = session.createCriteria(Patient.class).add(
						Restrictions.eq("ServiceNo", serviceNo))
						.createAlias("ServiceType", "ST").add(Restrictions.eq("ST.Id", serviceTypeId))
						.createAlias("ServiceStatus", "SS").add(Restrictions.eq("SS.Id", serviceStatusId))
					.list();
			/*session.createCriteria(Patient.class).add(
			Restrictions.eq("ServiceNo", serviceNo)).add(
			Restrictions.eq("ServiceType.Id", serviceTypeId)).add(
			Restrictions.eq("ServiceStatus.Id", serviceStatusId))*/
		}catch (HibernateException e){
			e.printStackTrace();
			//session.close();
		}catch (Exception e) {
			e.printStackTrace();

		}
		detailMap.put("patientList", patientList);
		detailMap.put("patientListForInfo", patientListForInfo);
		return detailMap;
	}

	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientListForNameHAL(
			Map<String, Object> parameterMap) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Patient> patientListForInfo = new ArrayList<Patient>();
		int relationId = 0;
		int serviceTypeId = 0;
		int serviceStatusId = 0;
		String serviceNo = "";
		String patientName = "";
		Session session = (Session) getSession();
		if (parameterMap.get("serviceTypeId") != null) {
			serviceTypeId = (Integer) parameterMap.get("serviceTypeId");
		}
		if (parameterMap.get("serviceStatusId") != null) {
			serviceStatusId = (Integer) parameterMap.get("serviceStatusId");
		}
		if (parameterMap.get("relationId") != null) {
			relationId = (Integer) parameterMap.get("relationId");
		}
		if (parameterMap.get("serviceNo") != null) {
			serviceNo = (String) parameterMap.get("serviceNo");
		}
		if (parameterMap.get("patientName") != null) {
			patientName = (String) parameterMap.get("patientName");
		}
		try {
			if (relationId == 8 || relationId == 2 || relationId == 3)
				if (serviceTypeId != 0 && serviceStatusId != 0
						&& relationId != 0 && !(serviceNo.equals(""))
						&& !(patientName.equals(""))) {
					patientList = session.createCriteria(Patient.class).add(
							Restrictions.eq("ServiceNo", serviceNo))							
							.createAlias("Relation","Re").add(Restrictions.eq("Re.Id",relationId )).list();
				}
			patientListForInfo = session.createCriteria(Patient.class).add(
						Restrictions.eq("ServiceNo", serviceNo))				
					.list();
			/*session.createCriteria(Patient.class).add(
			Restrictions.eq("ServiceNo", serviceNo)).add(
			Restrictions.eq("ServiceType.Id", serviceTypeId)).add(
			Restrictions.eq("ServiceStatus.Id", serviceStatusId))*/
		}catch (HibernateException e){
			e.printStackTrace();
			//session.close();
		}catch (Exception e) {
			e.printStackTrace();

		}
		detailMap.put("patientList", patientList);
		detailMap.put("patientListForInfo", patientListForInfo);
		return detailMap;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> getHinNoList(String serviceNo) {
		Session session = (Session) getSession();
		List<Object[]> patientList = new ArrayList<Object[]>();
		try {
			if (!serviceNo.equals("")) {
				patientList = session.createCriteria(Patient.class).add(
						Restrictions.eq("ServiceNo", serviceNo)).add(
						Restrictions.not(Restrictions.eq("PatientStatus",
								"Expired")))
								.createAlias("Relation", "rel")
						.setProjection(Projections.projectionList()
						.add(Projections.property("Id")).add(Projections.property("HinNo"))
						.add(Projections.property("PFirstName"))
						.add(Projections.property("PMiddleName"))
						.add(Projections.property("PLastName"))
						.add(Projections.property("rel.RelationName")))
						.list();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			//session.close();
		}
		return patientList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForUpdate(
			Map<String, Object> parameterMap) {Map<String, Object> map = new HashMap<String, Object>();
			String hinNo = "";
			Session session = (Session) getSession();
			List<Patient> patientList = new ArrayList<Patient>();
			List<Object> visitList = new ArrayList<Object>();
			List<Object> rankList = new ArrayList<Object>();
			int serviceType = 0;
			try {
				if (parameterMap.get("hinNo") != null) {
					hinNo = (String) parameterMap.get("hinNo");
					patientList = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", hinNo))
					         .add(Restrictions.not(Restrictions.eq("PatientStatus","Expired"))).list();
					visitList = session.createCriteria(Visit.class).add(Restrictions.eq("VisitNo", 1))
					           .createAlias("Hin", "p").add(Restrictions.eq("p.HinNo", hinNo)).list();
				}

				for (Patient patient : patientList) {
					serviceType = patient.getServiceType().getId();
				}

				rankList = session.createCriteria(MasRank.class).add(
						Restrictions.eq("ServiceType.Id", serviceType)).add(
						Restrictions.eq("Status", "y")).list();
				List<UploadDocuments>documentList=new ArrayList<UploadDocuments>();

				String uploadURL = (String) parameterMap.get("uploadURL");

				documentList = session.createCriteria(UploadDocuments.class).add(Restrictions.eq("PatientName", hinNo)).list();

				map.put("documentList", documentList);
				//String[] files = null;
				/*if (documentList.size() > 0) {
					files = new String[documentList.size()];
					Iterator iterator = documentList.iterator();
					int counter = 0;
					while (iterator.hasNext()) {
						UploadDocuments uploadDocuments = (UploadDocuments) iterator
								.next();
						files[counter] = uploadDocuments.getFileName() + "."
								+ uploadDocuments.getFileExtension();
						// //System.out.println("filename="+files[counter]);
						try {
							FileOutputStream is = new FileOutputStream(uploadURL
									+ "\\" + uploadDocuments.getFileName() + "."
									+ uploadDocuments.getFileExtension());
							//System.out.println("filePath update ::"+uploadURL
									 + uploadDocuments.getFileName() + "."
									+ uploadDocuments.getFileExtension());
							is.write(uploadDocuments.getPatientDocument());
							is.flush();
							is.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						counter++;
					}

				}*/
			}catch (HibernateException e){
				e.printStackTrace();
			//	session.close();
			}catch (Exception e) {
				e.printStackTrace();

			}
			map.put("patientList", patientList);
			map.put("visitList", visitList);
			map.put("rankList", rankList);
			return map;
}

	@SuppressWarnings("unchecked")
	public List<Visit> getVisitNo(String hinNo) {
		Session session = (Session) getSession();
		List<Visit> visitList = new ArrayList<Visit>();
		try {
			visitList = session.createCriteria(Visit.class).createAlias("Hin", "p")
					.add(Restrictions.eq("p.HinNo", hinNo)).addOrder(
							Order.desc("VisitNo")).list();
		} catch (HibernateException e) {
			
			e.printStackTrace();
		//	session.close();
		}
		return visitList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientVisitDetailsForUpdate(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		int visitNo = 0;
		String hinNo = "";
		if (parameterMap.get("hinNo") != null) {
			hinNo = (String) parameterMap.get("hinNo");
		}
		Session session = (Session) getSession();
		List<Object> visitList = new ArrayList<Object>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		try {
			if (parameterMap.get("visitNo") != null) {
				visitNo = (Integer) parameterMap.get("visitNo");
				visitList = session.createCriteria(Visit.class).add(
						Restrictions.eq("VisitNo", visitNo))
						.createAlias("Hin", "p").add(
								Restrictions.eq("p.HinNo", hinNo)).list();
			}
			Visit visit = (Visit) visitList.get(0);
			doctorList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("EmpCategory",
					"empCat").add(Restrictions.eq("empCat.EmpCategoryCode", "01"))
					.createAlias("Department", "dept").add(
							Restrictions.eq("dept.Id", visit.getDepartment()
									.getId())).list();
		} catch (HibernateException e) {
			
			e.printStackTrace();
		//	session.close();
		}

		map.put("visitList", visitList);
		map.put("doctorList", doctorList);
		return map;
	}

	public Map<String, Object> updateVisitDetails(
			Map<String, Object> parameterMap) {
		boolean updatedSuccessfully = false;
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitList = new ArrayList<Visit>();
		int visitId = (Integer) parameterMap.get("visitId");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			Visit visit = (Visit) hbt.load(Visit.class, visitId);

			if (parameterMap.get("complaintId") != null
					&& !parameterMap.get("complaintId").equals("")) {
				String complaint = (String) parameterMap.get("complaintId");
				/*visit.setComplaintString(complaint);*/
			}
			if (parameterMap.get("tokenNo") != null)
			 {
				int tokenNo = (Integer)parameterMap.get("tokenNo");
				visit.setTokenNo(tokenNo);
			}
			if (parameterMap.get("caseTypeId") != null) {
				int caseTypeId = Integer.parseInt(""
						+ parameterMap.get("caseTypeId"));
				if (caseTypeId != 0) {
					MasCaseType masCaseType = new MasCaseType();
					masCaseType.setId(caseTypeId);
					visit.setCaseType(masCaseType);
				}
			}
			if (parameterMap.get("diagnosisId") != null
					&& !parameterMap.get("diagnosisId").equals("")) {
				String diagnosis = (String) parameterMap.get("diagnosisId");
				/*visit.setDiagnosisString(diagnosis);*/
			}
			if (parameterMap.get("disposalId") != null) {
				int disposalId = (Integer) parameterMap.get("disposalId");
				if (disposalId != 0) {
					MasDisposal masDisposal = new MasDisposal();
					masDisposal.setId(disposalId);
					visit.setDisposal(masDisposal);
				}
			}
			if (parameterMap.get("consultingDoctor") != null) {
				int doctorId = Integer.parseInt(""
						+ parameterMap.get("consultingDoctor"));
				if (doctorId != 0) {
					MasEmployee masemployee = new MasEmployee();
					masemployee.setId(doctorId);
					visit.setDoctor(masemployee);
				}
			}
			if (parameterMap.get("userId") != null) {
				int userId = (Integer) parameterMap.get("userId");
				Users users = new Users();
				users.setId(userId);
				visit.setAddEditBy(users);
			}
			Date addEditDate = null;
			if (parameterMap.get("addEditDate") != null) {
				addEditDate = (Date) parameterMap.get("addEditDate");
				visit.setAddEditDate(addEditDate);
			}
			String addEditTime = "";
			if (parameterMap.get("addEditTime") != null) {
				addEditTime = (String) parameterMap.get("addEditTime");
				visit.setAddEditTime(addEditTime);
			}
			if (parameterMap.get("hospitalStaff") != null) {
				visit.setHospitalStaff((String) parameterMap
						.get("hospitalStaff"));
			} else {
				visit.setHospitalStaff("n");
			}
			hbt.update(visit);
			hbt.refresh(visit);
			visitList.add(visit);
			map.put("visitList", visitList);
			updatedSuccessfully = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("updatedSuccessfully", updatedSuccessfully);
		return map;
	}

	public boolean updateVisitInformation(Map<String, Object> parameterMap) {
		boolean updatedSuccessfully = false;

		int visitId = (Integer) parameterMap.get("visitId");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			Visit visit = (Visit) hbt.load(Visit.class, visitId);

			if (parameterMap.get("complaintId") != null
					&& !parameterMap.get("complaintId").equals("")) {
				String complaint = (String) parameterMap.get("complaintId");
				/*visit.setComplaintString(complaint);*/
			}
			if (parameterMap.get("caseTypeId") != null) {
				int caseTypeId = Integer.parseInt(""
						+ parameterMap.get("caseTypeId"));
				if (caseTypeId != 0) {
					MasCaseType masCaseType = new MasCaseType();
					masCaseType.setId(caseTypeId);
					visit.setCaseType(masCaseType);
				}
			}
			if (parameterMap.get("diagnosisId") != null
					&& !parameterMap.get("diagnosisId").equals("")) {
				String diagnosis = (String) parameterMap.get("diagnosisId");
				/*visit.setDiagnosisString(diagnosis);*/
			}
			if (parameterMap.get("disposalId") != null) {
				int disposalId = (Integer) parameterMap.get("disposalId");
				if (disposalId != 0) {
					MasDisposal masDisposal = new MasDisposal();
					masDisposal.setId(disposalId);
					visit.setDisposal(masDisposal);
				}
			}
			if (parameterMap.get("consultingDoctor") != null) {
				int doctorId = Integer.parseInt(""
						+ parameterMap.get("consultingDoctor"));
				if (doctorId != 0) {
					MasEmployee masemployee = new MasEmployee();
					masemployee.setId(doctorId);
					visit.setDoctor(masemployee);
				}
			}
			if (parameterMap.get("userId") != null) {
				int userId = (Integer) parameterMap.get("userId");
				Users users = new Users();
				users.setId(userId);
				visit.setAddEditBy(users);
			}
			Date addEditDate = null;
			if (parameterMap.get("addEditDate") != null) {
				addEditDate = (Date) parameterMap.get("addEditDate");
				visit.setAddEditDate(addEditDate);
			}
			String addEditTime = "";
			if (parameterMap.get("addEditTime") != null) {
				addEditTime = (String) parameterMap.get("addEditTime");
				visit.setAddEditTime(addEditTime);
			}
			if (parameterMap.get("hospitalStaff") != null) {
				visit.setHospitalStaff((String) parameterMap
						.get("hospitalStaff"));
			} else {
				visit.setHospitalStaff("n");
			}
			hbt.update(visit);
			updatedSuccessfully = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return updatedSuccessfully;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForVisit() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();

		Session session = (Session) getSession();

		try {
			rankList = session
					.createQuery(
							"select rank from MasRank as rank where rank.Status='y'  order by rank.RankName ")
					.list();
			serviceTypeList = session.createCriteria(MasServiceType.class).add(
					Restrictions.eq("Status", "y")).list();
			unitList = session.createQuery(
					"select dist from MasUnit as dist order by dist.UnitName ")
					.list();

			map.put("rankList", rankList);
			map.put("serviceTypeList", serviceTypeList);
			map.put("unitList", unitList);

		}catch (HibernateException e){
			e.printStackTrace();
		//	session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getServicePersonName(String serviceNo,
			int serviceTypeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> list = new ArrayList<Patient>();
		List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();
		List<Object[]> rankList = new ArrayList<Object[]>();
		List<Object[]> unitList = new ArrayList<Object[]>();
		List<Object[]> tradeList = new ArrayList<Object[]>();
		List<Object[]> sectionList = new ArrayList<Object[]>();
		List<Object[]> bloodGroupList = new ArrayList<Object[]>();
		List<Object[]> sexList = new ArrayList<Object[]>();
		List<Object[]> stationList = new ArrayList<Object[]>();
		List<MasEmployee> srEmployeeList = new ArrayList<MasEmployee>();
		List<Object[]> commandList = new ArrayList<Object[]>();
		List<Object[]> maritalStatusList = new ArrayList<Object[]>();
		List<Object[]> religionList = new ArrayList<Object[]>();
		List<Object[]> serviceTypeList = null;
		List<Object[]> relationList = null;
		List<Object[]> districtList = null;
		List<Object[]> serviceStatusList = null;
		List<Object[]> stateList = null;
		List<PatientFamilyHistory> familyHistoryList = null;
		List<Object[]> categoryList = null;
		
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
		
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(
					Order.asc("UnitName")).list();
			serviceTypeList =	session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("ServiceTypeName"))).addOrder(
								Order.asc("ServiceTypeName")).list();
			rankList=	session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("RankName"))
							.add(Projections.property("ServiceType.Id")).add(Projections.property("ServiceStatus.Id")).add(Projections.property("HicCode")))
							.addOrder(Order.asc("RankName")).list();
			maritalStatusList =	session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("MaritalStatusName")).add(Projections.property("HicCode"))).addOrder(
					Order.asc("MaritalStatusName")).list();
			tradeList =	session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("TradeName"))).addOrder(
					Order.asc("TradeName")).list();
			stateList =	session.createCriteria(MasState.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("StateName"))).addOrder(
					Order.asc("StateName")).list();
			districtList =	session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("DistrictName")).add(Projections.property("State.Id"))).addOrder(
					Order.asc("DistrictName")).list();
			relationList =	session.createCriteria(MasRelation.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("RelationName"))).addOrder(
					Order.asc("RelationName")).list();
			bloodGroupList =	session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("BloodGroupName")).add(Projections.property("HicCode"))).addOrder(
					Order.asc("BloodGroupName")).list();
			sexList =	session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("AdministrativeSexName")).add(Projections.property("AdministrativeSexCode")).add(Projections.property("HicCode"))).addOrder(
					Order.asc("AdministrativeSexName")).list();
			
			religionList = session.createCriteria(MasReligion.class).add(Restrictions.eq("Status", "y"))
							.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("ReligionName"))
								.add(Projections.property("HicCode")))
								.addOrder(Order.asc("ReligionName")).list();
			recordOfficeAddressList = session.createCriteria(MasRecordOfficeAddress.class).add(Restrictions.eq("Status", "y")).list();
			sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y"))
						.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("SectionName")))
						.addOrder(Order.asc("SectionName")).list();
			stationList =	session.createCriteria(MasStation.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("StationName")).add(Projections.property("Command.Id"))).addOrder(
					Order.asc("StationName")).list();
			commandList =	session.createCriteria(MasCommand.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("CommandName"))).addOrder(
					Order.asc("CommandName")).list();
			serviceStatusList =	session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("ServiceStatusName"))).addOrder(
					Order.asc("ServiceStatusName")).list();
			familyHistoryList =	session.createCriteria(PatientFamilyHistory.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("PatientHistoryName"))).addOrder(
					Order.asc("PatientHistoryName")).list();
			categoryList =	session.createCriteria(Category.class).setProjection(Projections.projectionList().add(Projections.property("Categoryid")).add(Projections.property("Categories"))).addOrder(
					Order.asc("Categories")).list();
			//serviceTypeList = hbt.find("select Id,ServiceTypeName from MasServiceType mst where mst.Status='y' order by ServiceTypeName");
		//	rankList = hbt.find("select Id,RankName,rank.ServiceType.Id, rank.ServiceStatus.Id,rank.HicCode from MasRank as rank  where rank.Status='y'  order by rank.RankName ");
		//	maritalStatusList = hbt.find("select Id,MaritalStatusName,HicCode from MasMaritalStatus mms where mms.Status='y' order by mms.MaritalStatusName");
		//	tradeList =hbt.find("select Id,TradeName from MasTrade mt where mt.Status='y' order by mt.TradeName");
		//	stateList = hbt.find("select Id,StateName from MasState ms where ms.Status='y' order by StateName");
		//	districtList =hbt.find("select  Id, DistrictName,md.State.Id from MasDistrict as md  where md.Status='y' order by md.DistrictName ");
		//	relationList =hbt.find("select Id,RelationName from MasRelation as mr where mr.Status='y' order by RelationName");
		//	bloodGroupList = hbt.find("select Id,BloodGroupName,HicCode from MasBloodGroup as dist where dist.Status='y' order by dist.BloodGroupName");
			
		//	sexList = hbt.find("Select Id, AdministrativeSexName, AdministrativeSexCode,HicCode from MasAdministrativeSex mas where mas.Status='y' order by AdministrativeSexName");
			
//			stationList = hbt.find("select Id,StationName,mas.Command.Id from MasStation mas where mas.Status='y' order by mas.StationName");
//			commandList = hbt.find("select Id,CommandName from MasCommand mas where mas.Status='y' order by mas.CommandName");
//			serviceStatusList = hbt.find("select Id,ServiceStatusName from MasServiceStatus mss where mss.Status='y' ");
//			familyHistoryList = hbt.find("select Id,PatientHistoryName from PatientFamilyHistory mss where mss.Status='y' order by PatientHistoryName");
//			categoryList = hbt.find("select Categoryid,Categories from Category c order by Categories");
	
			List<Patient> servPersList = new ArrayList<Patient>();
			servPersList = session.createCriteria(Patient.class).add(
						Restrictions.eq("ServiceNo", serviceNo)).createAlias(
						"ServiceType", "st").add(
						Restrictions.eq("st.Id", serviceTypeId)).createAlias("Relation", "rel").add(Restrictions.eq("rel.Id", 8)).list();
			list = session.createCriteria(Patient.class).add(
				Restrictions.eq("ServiceNo", serviceNo)).createAlias(
				"ServiceType", "st").add(
				Restrictions.eq("st.Id", serviceTypeId)).addOrder(Order.asc("Id")).list();
		
			if (servPersList.size() > 0) {
				map.put("servPersList", servPersList);
			}
			if (list.size() > 0) {
				map.put("list", list);
			}
			if(list.size() == 0 && servPersList.size() == 0)
			{
				if(serviceTypeId == 2){
				srEmployeeList = session.createCriteria(MasEmployee.class).add(
						Restrictions.eq("ServiceNo", serviceNo)).list();
				map.put("srEmployeeList", srEmployeeList);
				}
			}

			map.put("rankList", rankList);
			map.put("unitList", unitList);
			map.put("tradeList", tradeList);
			map.put("recordOfficeAddressList", recordOfficeAddressList);
			map.put("sectionList", sectionList);
			map.put("bloodGroupList", bloodGroupList);
			map.put("sexList", sexList);
			map.put("stationList", stationList);
			map.put("serviceTypeId", serviceTypeId);
	
			map.put("commandList", commandList);
			map.put("maritalStatusList", maritalStatusList);
			map.put("religionList", religionList);
			map.put("serviceTypeList", serviceTypeList);
			map.put("relationList", relationList);
			map.put("districtList", districtList);
			map.put("serviceStatusList", serviceStatusList);
			map.put("stateList", stateList);
			map.put("familyHistoryList", familyHistoryList);
			map.put("categoryList", categoryList);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		//	session.close();
		}
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> responseForVisitOfHALEmployees(String serviceNo,
			int serviceTypeId, int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> list = new ArrayList<Patient>();
		/*List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();*/
		List<Object[]> rankList = new ArrayList<Object[]>();
		/*List<Object[]> unitList = new ArrayList<Object[]>();
		List<Object[]> tradeList = new ArrayList<Object[]>();
		List<Object[]> sectionList = new ArrayList<Object[]>();*/
		List<Object[]> bloodGroupList = new ArrayList<Object[]>();
		List<Object[]> sexList = new ArrayList<Object[]>();
		/*List<Object[]> stationList = new ArrayList<Object[]>();*/
		List<MasEmployee> srEmployeeList = new ArrayList<MasEmployee>();
		/*List<Object[]> commandList = new ArrayList<Object[]>();*/
		List<Object[]> maritalStatusList = new ArrayList<Object[]>();
		List<Object[]> religionList = new ArrayList<Object[]>();
		/*List<Object[]> serviceTypeList = null;*/
		List<Object[]> relationList = null;
		List<Object[]> districtList = null;
		/*List<Object[]> serviceStatusList = null;*/
		List<Object[]> stateList = null;
		/*List<PatientFamilyHistory> familyHistoryList = null;*/
		List<Object[]> categoryList = null;
		List<MasDepartment> departmentList = null;
		
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		String departmentTypeCodeForOpd="";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			properties.load(resourcePath.openStream());			 
			departmentTypeCodeForOpd=properties.getProperty("departmentTypeCodeForOpd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
		
			departmentList=session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status","y").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.DepartmentTypeCode",departmentTypeCodeForOpd))
					.addOrder(Order.asc("DepartmentName"))
					.list();
			
			rankList=	session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("RankName"))
							.add(Projections.property("HicCode")))
							.addOrder(Order.asc("RankName")).list();
			maritalStatusList =	session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("MaritalStatusName")).add(Projections.property("HicCode"))).addOrder(
					Order.asc("MaritalStatusName")).list();
			
			stateList =	session.createCriteria(MasState.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("StateName"))).addOrder(
					Order.asc("StateName")).list();
			districtList =	session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("DistrictName")).add(Projections.property("State.Id"))).addOrder(
					Order.asc("DistrictName")).list();
			relationList =	session.createCriteria(MasRelation.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("RelationName")).add(Projections.property("RelationCode"))).addOrder(
					Order.asc("RelationName")).list();
			bloodGroupList =	session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("BloodGroupName")).add(Projections.property("HicCode"))).addOrder(
					Order.asc("BloodGroupName")).list();
			sexList =	session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("AdministrativeSexName")).add(Projections.property("AdministrativeSexCode")).add(Projections.property("HicCode"))).addOrder(
					Order.asc("AdministrativeSexName")).list();
			
			religionList = session.createCriteria(MasReligion.class).add(Restrictions.eq("Status", "y"))
							.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("ReligionName"))
								.add(Projections.property("HicCode")))
								.addOrder(Order.asc("ReligionName")).list();
			/*recordOfficeAddressList = session.createCriteria(MasRecordOfficeAddress.class).add(Restrictions.eq("Status", "y")).list();
			sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y"))
						.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("SectionName")))
						.addOrder(Order.asc("SectionName")).list();
		
			familyHistoryList =	session.createCriteria(PatientFamilyHistory.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("PatientHistoryName"))).addOrder(
					Order.asc("PatientHistoryName")).list();*/
			categoryList =	session.createCriteria(Category.class).setProjection(Projections.projectionList().add(Projections.property("Categoryid")).add(Projections.property("Categories"))).addOrder(
					Order.asc("Categories")).list();
		
			List<Patient> servPersList = new ArrayList<Patient>();
			servPersList = session.createCriteria(Patient.class).add(
						Restrictions.eq("ServiceNo", serviceNo)).createAlias("Relation", "rel").add(Restrictions.eq("rel.RelationName", "Self").ignoreCase())						
					    .add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			list = session.createCriteria(Patient.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("ServiceNo", serviceNo)).createAlias("Relation", "rel").add(Restrictions.eq("rel.RelationName", "Self").ignoreCase()).addOrder(Order.asc("Id")).list();
		
			if (servPersList.size() > 0) {
				map.put("servPersList", servPersList);
			}
			if (list.size() > 0) {
				map.put("list", list);
			}
			
				
				srEmployeeList = session.createCriteria(MasEmployee.class)
						.add(Restrictions.eq("Status","y").ignoreCase())
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("ServiceNo", serviceNo)).list();
				map.put("srEmployeeList", srEmployeeList);
				
			
            map.put("srEmployeeListGrid", srEmployeeList);
			map.put("departmentList", departmentList);	  
			map.put("rankList", rankList);
		/*	map.put("unitList", unitList);
			map.put("tradeList", tradeList);
			map.put("recordOfficeAddressList", recordOfficeAddressList);
			map.put("sectionList", sectionList);*/
			map.put("bloodGroupList", bloodGroupList);
			map.put("sexList", sexList);
			/*map.put("stationList", stationList);*/
			map.put("serviceTypeId", serviceTypeId);
	
			/*map.put("commandList", commandList);*/
			map.put("maritalStatusList", maritalStatusList);
			map.put("religionList", religionList);
			/*map.put("serviceTypeList", serviceTypeList);*/
			map.put("relationList", relationList);
			map.put("districtList", districtList);
			/*map.put("serviceStatusList", serviceStatusList);*/
			map.put("stateList", stateList);
			/*map.put("familyHistoryList", familyHistoryList);*/
			map.put("categoryList", categoryList);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		//	session.close();
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getServicePersonNameHAL(String serviceNo,
			int serviceTypeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> list = new ArrayList<Patient>();
		List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();
		List<Object[]> rankList = new ArrayList<Object[]>();
		List<Object[]> unitList = new ArrayList<Object[]>();
		List<Object[]> tradeList = new ArrayList<Object[]>();
		List<Object[]> sectionList = new ArrayList<Object[]>();
		List<Object[]> bloodGroupList = new ArrayList<Object[]>();
		List<Object[]> sexList = new ArrayList<Object[]>();
		List<Object[]> stationList = new ArrayList<Object[]>();
		List<MasEmployee> srEmployeeList = new ArrayList<MasEmployee>();
		List<Object[]> commandList = new ArrayList<Object[]>();
		List<Object[]> maritalStatusList = new ArrayList<Object[]>();
		List<Object[]> religionList = new ArrayList<Object[]>();
		List<Object[]> serviceTypeList = null;
		List<Object[]> relationList = null;
		List<Object[]> districtList = null;
		List<Object[]> serviceStatusList = null;
		List<Object[]> stateList = null;
		List<PatientFamilyHistory> familyHistoryList = null;
		List<Object[]> categoryList = null;
		List<Object[]> othersCategoryList = null;
		
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
		
			/*unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(
					Order.asc("UnitName")).list();*/
			/*serviceTypeList =	session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("ServiceTypeName"))).addOrder(
								Order.asc("ServiceTypeName")).list();*/
			/*rankList=	session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("RankName"))
							.add(Projections.property("ServiceType.Id")).add(Projections.property("ServiceStatus.Id")).add(Projections.property("HicCode")))
							.addOrder(Order.asc("RankName")).list();*/
			maritalStatusList =	session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("MaritalStatusName")).add(Projections.property("HicCode"))).addOrder(
					Order.asc("MaritalStatusName")).list();
			/*tradeList =	session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("TradeName"))).addOrder(
					Order.asc("TradeName")).list();*/
			stateList =	session.createCriteria(MasState.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("StateName"))).addOrder(
					Order.asc("StateName")).list();
			districtList =	session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("DistrictName")).add(Projections.property("State.Id"))).addOrder(
					Order.asc("DistrictName")).list();
			relationList =	session.createCriteria(MasRelation.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("RelationName"))).addOrder(
					Order.asc("RelationName")).list();
			bloodGroupList =	session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("BloodGroupName")).add(Projections.property("HicCode"))).addOrder(
					Order.asc("BloodGroupName")).list();
			sexList =	session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("AdministrativeSexName")).add(Projections.property("AdministrativeSexCode")).add(Projections.property("HicCode"))).addOrder(
					Order.asc("AdministrativeSexName")).list();
			
			religionList = session.createCriteria(MasReligion.class).add(Restrictions.eq("Status", "y"))
							.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("ReligionName"))
								.add(Projections.property("HicCode")))
								.addOrder(Order.asc("ReligionName")).list();
			recordOfficeAddressList = session.createCriteria(MasRecordOfficeAddress.class).add(Restrictions.eq("Status", "y")).list();
			sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y"))
						.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("SectionName")))
						.addOrder(Order.asc("SectionName")).list();
			stationList =	session.createCriteria(MasStation.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("StationName")).add(Projections.property("Command.Id"))).addOrder(
					Order.asc("StationName")).list();
			/*commandList =	session.createCriteria(MasCommand.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("CommandName"))).addOrder(
					Order.asc("CommandName")).list();*/
			serviceStatusList =	session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("ServiceStatusName"))).addOrder(
					Order.asc("ServiceStatusName")).list();
			familyHistoryList =	session.createCriteria(PatientFamilyHistory.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("PatientHistoryName"))).addOrder(
					Order.asc("PatientHistoryName")).list();
			categoryList =	session.createCriteria(Category.class).setProjection(Projections.projectionList().add(Projections.property("Categoryid")).add(Projections.property("Categories"))).addOrder(
					Order.asc("Categories")).list(); 
			othersCategoryList = hbt.find("select Id,CategoryName,CategoryCode from MasOthersCategory moc where moc.Status='y' order by moc.CategoryName");
			//serviceTypeList = hbt.find("select Id,ServiceTypeName from MasServiceType mst where mst.Status='y' order by ServiceTypeName");
		//	rankList = hbt.find("select Id,RankName,rank.ServiceType.Id, rank.ServiceStatus.Id,rank.HicCode from MasRank as rank  where rank.Status='y'  order by rank.RankName ");
		//	maritalStatusList = hbt.find("select Id,MaritalStatusName,HicCode from MasMaritalStatus mms where mms.Status='y' order by mms.MaritalStatusName");
		//	tradeList =hbt.find("select Id,TradeName from MasTrade mt where mt.Status='y' order by mt.TradeName");
		//	stateList = hbt.find("select Id,StateName from MasState ms where ms.Status='y' order by StateName");
		//	districtList =hbt.find("select  Id, DistrictName,md.State.Id from MasDistrict as md  where md.Status='y' order by md.DistrictName ");
		//	relationList =hbt.find("select Id,RelationName from MasRelation as mr where mr.Status='y' order by RelationName");
		//	bloodGroupList = hbt.find("select Id,BloodGroupName,HicCode from MasBloodGroup as dist where dist.Status='y' order by dist.BloodGroupName");
			
		//	sexList = hbt.find("Select Id, AdministrativeSexName, AdministrativeSexCode,HicCode from MasAdministrativeSex mas where mas.Status='y' order by AdministrativeSexName");
			
//			stationList = hbt.find("select Id,StationName,mas.Command.Id from MasStation mas where mas.Status='y' order by mas.StationName");
//			commandList = hbt.find("select Id,CommandName from MasCommand mas where mas.Status='y' order by mas.CommandName");
//			serviceStatusList = hbt.find("select Id,ServiceStatusName from MasServiceStatus mss where mss.Status='y' ");
//			familyHistoryList = hbt.find("select Id,PatientHistoryName from PatientFamilyHistory mss where mss.Status='y' order by PatientHistoryName");
//			categoryList = hbt.find("select Categoryid,Categories from Category c order by Categories");
	
			/*List<Patient> servPersList = new ArrayList<Patient>();
			servPersList = session.createCriteria(Patient.class).add(
						Restrictions.eq("HinNo", serviceNo)).createAlias("Relation", "rel").add(Restrictions.eq("rel.Id", 8)).list();*/
			list = session.createCriteria(Patient.class).add(
				Restrictions.eq("HinNo", serviceNo)).addOrder(Order.asc("Id")).list();
		
			/*if (servPersList.size() > 0) {
				map.put("servPersList", servPersList);
			}*/
			if (list.size() > 0) {
				map.put("list", list);
			}
			/*if(list.size() == 0 && servPersList.size() == 0)
			{
				if(serviceTypeId == 2){
				srEmployeeList = session.createCriteria(MasEmployee.class).add(
						Restrictions.eq("HinNo", serviceNo)).list();
				map.put("srEmployeeList", srEmployeeList);
				}
			}*/

			map.put("rankList", rankList);
			map.put("unitList", unitList);
			map.put("tradeList", tradeList);
			map.put("othersCategoryList", othersCategoryList);
			map.put("recordOfficeAddressList", recordOfficeAddressList);
			map.put("sectionList", sectionList);
			map.put("bloodGroupList", bloodGroupList);
			map.put("sexList", sexList);
			map.put("stationList", stationList);
			map.put("serviceTypeId", serviceTypeId);
	
			map.put("commandList", commandList);
			map.put("maritalStatusList", maritalStatusList);
			map.put("religionList", religionList);
			map.put("serviceTypeList", serviceTypeList);
			map.put("relationList", relationList);
			map.put("districtList", districtList);
			map.put("serviceStatusList", serviceStatusList);
			map.put("stateList", stateList);
			map.put("familyHistoryList", familyHistoryList);
			map.put("categoryList", categoryList);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		//	session.close();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getVisitData(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> vistList = new ArrayList<Visit>();
		List<Patient> list = new ArrayList<Patient>();
		Session session = (Session) getSession();
		String hinNo = "";
		String visitDate = "";
		String visitDiagnosis = "";
		int hinIn = 0;
		hinNo = "" + dataMap.get("hinNo");
		try {
			list = session.createCriteria(Patient.class).add(
					Restrictions.eq("HinNo", hinNo)).list();
			for (Patient patient : list) {
				hinIn = Integer.parseInt("" + patient.getId());
			}
			vistList = session.createCriteria(Visit.class).add(
					Restrictions.eq("Hin.Id", hinIn)).list();
			for (Visit visit : vistList) {
				visitDate = "" + visit.getVisitDate();
			/*	if (visit.getDiagnosisString() != null
						&& !visit.getDiagnosisString().equals(""))
					visitDiagnosis = visit.getDiagnosisString();*/
			}
		} catch (HibernateException e) {
			
			e.printStackTrace();
		//	session.close();
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		}

		map.put("visitDate", visitDate);
		map.put("visitDiagnosis", visitDiagnosis);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getTokenNo(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> vistList = new ArrayList<Visit>();
		List<Patient> list = new ArrayList<Patient>();
		Session session = (Session) getSession();
		String hinNo = "";
		String tokenNo = "";
		int hinIn = 0;
		hinNo = "" + dataMap.get("hinNo");
		list = session.createCriteria(Patient.class).add(
				Restrictions.eq("HinNo", hinNo)).list();
		for (Patient patient : list) {
			hinIn = Integer.parseInt("" + patient.getId());
		}
		vistList = session.createCriteria(Visit.class).add(
				Restrictions.eq("Hin.Id", hinIn)).list();
		for (Visit visit : vistList) {
			tokenNo = "" + visit.getTokenNo();
		}

		map.put("tokenNo", tokenNo);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> populatePatientDetails(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		int serviceTypeId = 0;
		if (dataMap.get("serviceNo") != null) {
			serviceNo = "" + dataMap.get("serviceNo");
		}
		if (dataMap.get("serviceTypeId") != null) {
			serviceTypeId = Integer.parseInt("" + dataMap.get("serviceTypeId"));
		}
		Session session = (Session) getSession();

		List<Patient> patientList = new ArrayList<Patient>();
		try {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).add(
					Restrictions.eq("ServiceType.Id", serviceTypeId)).list();
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		//	session.close();
		}
		map.put("patientList", patientList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> populatePatientDetailsHAL(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		int serviceTypeId = 0;
		if (dataMap.get("serviceNo") != null) {
			serviceNo = "" + dataMap.get("serviceNo");
		}
	/*	if (dataMap.get("serviceTypeId") != null) {
			serviceTypeId = Integer.parseInt("" + dataMap.get("serviceTypeId"));
		}*/
		Session session = (Session) getSession();

		List<Patient> patientList = new ArrayList<Patient>();
		try {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("HinNo", serviceNo)).list();
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		//	session.close();
		}
		map.put("patientList", patientList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public String populatePatientDetailsHAL(
			String patientType) {

		Session session = (Session) getSession();
		String patientTypeId = "";
	
		try {
			List<MasPatientType> patientTypeIdList = session.createCriteria(MasPatientType.class).add(
					Restrictions.eq("PatientTypeName", patientType).ignoreCase()).list();
		    patientTypeId = patientTypeIdList.get(0).getPatientTypeCode();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		//	session.close();
		}
	
		return patientTypeId;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAdmissionNoList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		if (dataMap.get("serviceNo") != null) {
			serviceNo = (String) dataMap.get("serviceNo");
		}
		if (dataMap.get("hinNo") != null) {
			hinNo = (String) dataMap.get("hinNo");
		}
		List<Object> inpatientList = new ArrayList<Object>();
		
		
		Session session = (Session)getSession();
		try {
			if (!serviceNo.equals("")) {
				Query ipQry = session.createQuery("from Inpatient ip join ip.Hin as p where p.ServiceNo =:srNo");
				ipQry.setString("srNo",serviceNo);
				inpatientList = ipQry.list();
				/*inpatientList = getHibernateTemplate().find(
						"from Inpatient ip join ip.Hin as p where p.ServiceNo = '"
								+ serviceNo + "'");*/
			}
			if (!hinNo.equals("")) {
				Query ipQry = session.createQuery("from Inpatient ip join ip.Hin as p where p.HinNo =:hinNo");
				ipQry.setString("hinNo",hinNo);
				inpatientList = ipQry.list();
				/*inpatientList = getHibernateTemplate().find(
						"from Inpatient ip join ip.Hin as p where p.HinNo = '"
								+ hinNo + "'");*/
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("inpatientList", inpatientList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public List<Visit> checkPatientVisit(Box box) {
		List<Visit> patientVisitList = new ArrayList<Visit>();

		int hinId = box.getInt("hinId");
		Date visitDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("visitDate"));

		Session session = (Session) getSession();

		try {
			patientVisitList = session.createCriteria(Visit.class).add(
					Restrictions.eq("VisitDate", visitDate)).createAlias("Hin",
					"hin").add(Restrictions.eq("hin.Id", hinId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		//	session.close();
		}

		return patientVisitList;
	}

	@SuppressWarnings("unchecked")
	public String getConsulationRoom(int consultingDoctor) {
		List<String> employeeList = new ArrayList<String>();
		String consultationRoom = "";
		Session session = (Session) getSession();
		employeeList = session.createCriteria(MasEmployee.class).setProjection(
				Projections.property("ConsultationRoom")).add(
				Restrictions.eq("Id", consultingDoctor)).list();
		if (employeeList.size() > 0) {
			consultationRoom = employeeList.get(0);
		}
		return consultationRoom;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAdmissionDetails() {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDiet> dietList = new ArrayList<MasDiet>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasAdmissionType> admissionTypeList = new ArrayList<MasAdmissionType>();
		List<MasBed> bedList = new ArrayList<MasBed>();
		List<MasCaseType> caseTypeList = new ArrayList<MasCaseType>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<MasTrade> masTradeList = new ArrayList<MasTrade>();
		// List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasDocument> documentList = new ArrayList<MasDocument>();
		List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>();
		List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();
		Session session = (Session) getSession();

		try {
			maritalStatusList = session.createCriteria(MasMaritalStatus.class)
					.add(Restrictions.eq("Status", "y")).list();
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
			dietList = session.createCriteria(MasDiet.class).add(
					Restrictions.eq("Status", "y")).list();
			bloodGroupList = session.createCriteria(MasBloodGroup.class).add(
					Restrictions.eq("Status", "y")).list();
			rankList = session
					.createQuery(
							"select rank from MasRank as rank where rank.Status='y'  order by rank.RankName ")
					.list();
			admissionTypeList = session.createCriteria(MasAdmissionType.class)
					.add(Restrictions.eq("Status", "y")).list();
			bedList = session.createCriteria(MasBed.class).add(
					Restrictions.eq("Status", "y")).list();
			caseTypeList = session.createCriteria(MasCaseType.class).add(
					Restrictions.eq("Status", "y")).list();
			relationList = session.createCriteria(MasRelation.class).add(
					Restrictions.eq("Status", "y")).list();
			sexList = session.createCriteria(MasAdministrativeSex.class).add(
					Restrictions.eq("Status", "y")).list();
			unitList = session
					.createQuery(
							"select dist from MasUnit as dist where dist.Status ='y' order by dist.UnitName ")
					.list();
			documentList = session.createCriteria(MasDocument.class).add(
					Restrictions.eq("Status", "y")).list();
			recordOfficeAddressList = session.createCriteria(
					MasRecordOfficeAddress.class).add(
					Restrictions.eq("Status", "y")).list();
			masTradeList = session.createCriteria(
					MasTrade.class).add(
					Restrictions.eq("Status", "y")).list();
			// unitList=session.createQuery("select dist from MasUnit as dist order by dist.UnitName "
			// ).list();
		}catch (HibernateException e){
			e.printStackTrace();
		//	session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		map.put("maritalStatusList", maritalStatusList);
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		map.put("dietList", dietList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("rankList", rankList);
		map.put("admissionTypeList", admissionTypeList);
		map.put("bedList", bedList);
		map.put("caseTypeList", caseTypeList);
		map.put("relationList", relationList);
		map.put("sexList", sexList);
		map.put("unitList", unitList);
		map.put("documentList", documentList);
		map.put("recordOfficeAddressList", recordOfficeAddressList);
		map.put("masTradeList",masTradeList);
		map.put("unitList", unitList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAppointmentTypeNoneList(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<AppPatientAppointments> appPatientAppointmentsList = new ArrayList<AppPatientAppointments>();
		Session session = (Session) getSession();
		try {
			appPatientAppointmentsList = session.createCriteria(
					AppPatientAppointments.class).add(
					Restrictions.isNull("Hin")).add(
					Restrictions.eq("AppointmentStatus", "y")).add(
					Restrictions.eq("AppointmentDate", new Date())).list();
		}catch (HibernateException e){
			e.printStackTrace();
		//	session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		map.put("appPatientAppointmentsList", appPatientAppointmentsList);
		return map;
	}

	public boolean addTrade(MasTrade masTrade, String s) {
		boolean addedTrade = false;
		try {
			List lst = getHibernateTemplate().find(
					"from MasTrade m where m.TradeName='" + s + "'");
			if (lst.size() == 0) {
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(masTrade);
				Query qyery = getSession()
						.createSQLQuery(
								"insert into mas_trade (last_chg_date,last_chg_time) values(sysdate(),time(sysdate()))");
				addedTrade = true ;
			} else {
				addedTrade = false ;
			}
		} catch (Exception e) {
			addedTrade = true ;
		}
		return addedTrade;
	}

	public Map<String, Object> addPhotoFile(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session)getSession();
		String filename = "";
		if(generalMap.get("filename")!= null){
			filename =(String) generalMap.get("filename");
		}
		
		String hinNo = "";
		if(generalMap.get("hinNo")!= null){
			hinNo =(String) generalMap.get("hinNo");
		}
		String gender = "";
		if(generalMap.get("gender")!= null){
			gender =(String) generalMap.get("gender");
		}
		String age = "";
		if(generalMap.get("age")!= null){
			age =(String) generalMap.get("age");
		}
		String address = "";
		if(generalMap.get("address")!= null){
			address =(String) generalMap.get("address");
		}
		int hinId=0;
		if(generalMap.get("hinId")!= null){
			hinId =(Integer) generalMap.get("hinId");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		int hospitalId = (Integer) generalMap.get("hospitalId");
		String userName = (String)generalMap.get("userName");
		String fileExtension=null;
		 File file=null;
		 try {
				HibernateTemplate hbt=getHibernateTemplate();
				//hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
		/*		file = new File(generalMap.get("uploadURL") + "/"+generalMap.get("filename"));

	    	     FileInputStream is = new FileInputStream(file);
	    	     long length = file.length();
	    	     ByteBuffer byteBuff=null;
	    	   //  int modLength=length/
	    	     if (length > Integer.MAX_VALUE) {
	            // File is too large
	    	     }
	    	     // Create the byte array to hold the data
	    	     byte[] bytes = new byte[(int)length];
	    	     int offset = 0;
	    	     int numRead = 0;
	    	     while (offset < bytes.length
	    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	    	    	 offset += numRead;
	    	     }

	    	     if (offset < bytes.length) {
	    	    	 throw new IOException("Could not completely read file "+file.getName());

	    	     }
	    	     is.close();*/
	        // Close the input stream and return bytes
	    	    StringTokenizer strToken=new StringTokenizer(filename,".");

	    	   filename=strToken.nextToken();
	    	     fileExtension=strToken.nextToken();
	    	     UploadDocuments uploadDocuments = new UploadDocuments();
					/*String dataInput = new String(bytes);

					uploadDocuments.setPatientDocument(bytes);*/

					uploadDocuments.setPatientName(hinNo);
					uploadDocuments.setAddress(address);
					uploadDocuments.setSex(gender);
					uploadDocuments.setAge(age);
					if (hinId != 0) {
						Patient patient = new Patient();
						patient.setId(hinId);
						uploadDocuments.setHin(patient);
					}
					uploadDocuments.setDescription("Registration Done");
					uploadDocuments.setFileExtension(fileExtension);
					uploadDocuments.setFileName(filename);
					uploadDocuments.setUploadDate(date);
					uploadDocuments.setLastChgDate(date);
					uploadDocuments.setLastChgTime(time);
					uploadDocuments.setLastChgBy(userName);
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					uploadDocuments.setHospital(masHospital);
					hbt.save(uploadDocuments);

					//file.delete();


	    }// end of 'try' loop
		catch (Exception e) {
	      e.printStackTrace();
	    }
		return map;
	}



	@SuppressWarnings("unchecked")
	public Map<String, Object> displayRegisPhoto(String hinNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session)getSession();
		try {
			patientList = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo",hinNo)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		//	session.close();
		}
		map.put("patientList", patientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAircraftEmergencyJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAircraftType> aircraftTypeList = new ArrayList<MasAircraftType>();
		List<MasStation> stationList = new ArrayList<MasStation>();
		List<Object[]> unitList = new ArrayList<Object[]>();
		List<MasLocation> locationList = new ArrayList<MasLocation>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<AvPilotRegistrationDt> avPilotRegistrationDtList = null;
//		List<Patient> patient =null; 
		List<MasRank> rankList = null;
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		
		Session session = (Session)getSession();
		try {
			aircraftTypeList = session.createCriteria(MasAircraftType.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("AircraftTypeName")).list();
			stationList = session.createCriteria(MasStation.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("StationName")).list();
			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status","y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(Order.asc("UnitName")).list();
			locationList = session.createCriteria(MasLocation.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("LocationName")).list();
			doctorList = session.createCriteria(MasEmployee.class)
							.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).createAlias("EmpCategory", "ec").add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor)).add(Restrictions.eq("Status","y")).addOrder(Order.asc("FirstName")).list();
			rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("RankName")).list();
			avPilotRegistrationDtList = session.createCriteria(AvPilotRegistrationDt.class).list();
//			patient = session.createCriteria(Patient.class).add(Restrictions.eq("Status", "y")).list();
		
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("aircraftTypeList", aircraftTypeList);
		map.put("stationList", stationList);
		map.put("unitList", unitList);
		map.put("locationList", locationList);
		map.put("doctorList", doctorList);
//		map.put("patient", patient);
		map.put("avPilotRegistrationDtList", avPilotRegistrationDtList);
		map.put("rankList", rankList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> saveAirCraftEmergencyDetails(Box box,Map<String, Object> infoMap) {
		Map<String,Object> map = new HashMap<String, Object>();
		boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			AirCraftEmergency airCraftEmergency = new AirCraftEmergency();
			airCraftEmergency.setCallRcdDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CALL_RCD_DATE)));
			airCraftEmergency.setCallRcdTime(box.getString(CALL_RCD_TIME));
			airCraftEmergency.setActionTaken(box.getString(ACTION_TAKEN));
			airCraftEmergency.setAttendedTime(box.getString(ATTENDED_TIME));
			airCraftEmergency.setEmergencyType(box.getString(EMERGENCY_TYPE));
			airCraftEmergency.setPilot(box.getString(PILOT));
			airCraftEmergency.setRemarks(box.getString(REMARKS));
			airCraftEmergency.setSourceFrom(box.getString(SOURCE_FROM));
			airCraftEmergency.setReportedBy(box.getString(REPORTED_BY));
			airCraftEmergency.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			airCraftEmergency.setLastChgTime(box.getString(LAST_CHANGED_TIME));
			
			if(box.getInt(AIRCRAFT_TYPE_ID) != 0){
				MasAircraftType aircraftType = new MasAircraftType();
				aircraftType.setId(box.getInt(AIRCRAFT_TYPE_ID));
				airCraftEmergency.setTypeOfAircraft(aircraftType);
			}
			airCraftEmergency.setLocation(box.getString(LOCATION));
			
			if(box.getInt(STATION_ID) != 0){
				MasStation station = new MasStation();
				station.setId(box.getInt(STATION_ID));
				airCraftEmergency.setStation(station);
			}
			if(box.getInt(UNIT_ID) != 0){
				MasUnit unit = new MasUnit();
				unit.setId(box.getInt(UNIT_ID));
				airCraftEmergency.setUnit(unit);
			}
			if(box.getInt(MEDICAL_OFFICER_ID) != 0){
				MasEmployee employee = new MasEmployee();
				employee.setId(box.getInt(MEDICAL_OFFICER_ID));
				airCraftEmergency.setMedicalOfficer(employee);
			}
			
			Users user = new Users();
			user.setId(box.getInt("userId"));
			airCraftEmergency.setLastChgBy(user);
			
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			airCraftEmergency.setHospital(hospital);
			
			hbt.save(airCraftEmergency);
			
			
			
			List<String> serviceNoList = new ArrayList<String>();
			List<Integer> rankList = new ArrayList<Integer>();
			List<Integer> hinList = new ArrayList<Integer>();
			List<String> nameList = new ArrayList<String>();
			List<String> ageList = new ArrayList<String>();
			List<Integer> pilotList = new ArrayList<Integer>();
			serviceNoList = (List) infoMap.get("serviceNoList");
			rankList = (List) infoMap.get("rankList");
			hinList = (List) infoMap.get("hinList");
			nameList = (List) infoMap.get("nameList");
			ageList = (List) infoMap.get("ageList");
			pilotList= (List) infoMap.get("pilotList");
			
			
			for (int i = 0; i < serviceNoList.size(); i++) {
				AirCraftEmergencyDt airCraftEmergencyDt = new AirCraftEmergencyDt();
				 
				 if(serviceNoList.get(i)!=null){
					 airCraftEmergencyDt.setServiceNo(serviceNoList.get(i));
				 }
				 if(nameList.get(i)!=null){
					 airCraftEmergencyDt.setFullName(nameList.get(i));
				 }
				 if(ageList.get(i)!=null){
					 airCraftEmergencyDt.setAge(ageList.get(i));
				 }
				 
				 if(Integer.parseInt(hinList.get(i).toString())!=0){
					 Patient patient=new Patient();
					 patient.setId(hinList.get(i));
					 airCraftEmergencyDt.setHin(patient);
				 }
				 
				 if(Integer.parseInt(pilotList.get(i).toString())!=0){
					 AvPilotRegistrationDt avPilotRegistrationDt=new AvPilotRegistrationDt();
					 avPilotRegistrationDt.setId(pilotList.get(i));
					 airCraftEmergencyDt.setPilot(avPilotRegistrationDt);
				 }
				 if(rankList.get(i)!=null && !rankList.get(i).equals("0")){
					 MasRank masRank=new MasRank();
					 masRank.setId(rankList.get(i));
					 airCraftEmergencyDt.setRank(masRank);
				 }
			
				 airCraftEmergencyDt.setAirCraftEmergency(airCraftEmergency);
				 hbt.save(airCraftEmergencyDt);
			 }
			
			flag = true;
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map = showAircraftEmergencyJsp(box.getInt("hospitalId"));
		map.put("flag", flag);
		return map;
	}

	public Map<String, Object> saveEmergencyPerformaDetails(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			EmergencyPerforma emergencyPerforma = new EmergencyPerforma();
			emergencyPerforma.setCallRcdDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CALL_RCD_DATE)));
			emergencyPerforma.setCallRcdTime(box.getString(CALL_RCD_TIME));
			emergencyPerforma.setAttendedTime(box.getString(ATTENDED_TIME));
			emergencyPerforma.setRemarks(box.getString(REMARKS));
			emergencyPerforma.setSourceFrom(box.getString(SOURCE_FROM));
			emergencyPerforma.setReportedBy(box.getString(REPORTED_BY));
			emergencyPerforma.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			emergencyPerforma.setLastChgTime(box.getString(LAST_CHANGED_TIME));
			emergencyPerforma.setLocation(box.getString(LOCATION));
			emergencyPerforma.setEmergencyType(box.getString(EMERGENCY_TYPE));
			emergencyPerforma.setActionTaken(box.getString(ACTION_TAKEN));
			emergencyPerforma.setCasualties(box.getString("casualties"));
			if(box.getInt(MEDICAL_OFFICER_ID) != 0){
				MasEmployee employee = new MasEmployee();
				employee.setId(box.getInt(MEDICAL_OFFICER_ID));
				emergencyPerforma.setMedicalOfficer(employee);
			}
			
			Users user = new Users();
			user.setId(box.getInt("userId"));
			emergencyPerforma.setLastChgBy(user);
			
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			emergencyPerforma.setHospital(hospital);
			
			hbt.save(emergencyPerforma);
			flag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map = showAircraftEmergencyJsp(box.getInt("hospitalId"));
		map.put("flag", flag);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMHReferralRegisterJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientDetails> referralList = new ArrayList<OpdPatientDetails>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		int hospitalId = box.getInt("hospitalId");
		Session session = (Session)getSession();
		Criteria crit = null;
		
		
		try {
			Date myDate = new Date();
			
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(myDate);
			cal1.add(Calendar.DAY_OF_YEAR, -60);
//			cal1.add(Calendar.MONTH ,  -2 );
			Date previousDate = cal1.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date dateWthoutTime = formatter.parse(formatter.format(previousDate)); 
			crit =session.createCriteria(OpdPatientDetails.class).createAlias("Hospital", "h").createAlias("Visit", "v").createAlias("v.Hin", "hin")
			.add(Restrictions.eq("h.Id", hospitalId)).add(Restrictions.eq("MhRun", "y")).add(Restrictions.ge("OpdDate",dateWthoutTime)).addOrder(Order.desc("OpdDate"));
			
			if(!box.getString(REFERRAL_DATE).equals("")) {
				crit = crit.add(Restrictions.eq("OpdDate", HMSUtil.convertStringTypeDateToDateType(box.getString(REFERRAL_DATE))));
			}
			if(!box.getString(SERVICE_NO).equals("")) {
				crit = crit.add(Restrictions.eq("hin.ServiceNo",box.getString(SERVICE_NO)));
			}
			if(!box.getString(HIN_NO).equals("")) {
				crit = crit.add(Restrictions.eq("hin.HinNo",box.getString(HIN_NO)));			
			}
			if(!box.getString(PATIENT_NAME).equals("")) {
				crit = crit.add(Restrictions.like("hin.PFirstName",box.getString(PATIENT_NAME)+"%"));
			}
			if(box.getInt(RELATION_ID)!=0) {
				crit = crit.createAlias("hin.Relation", "rel").add(Restrictions.eq("rel.Id",box.getInt(RELATION_ID)));
			}
			if(box.getInt(RANK_ID)!=0) {
				crit = crit.createAlias("hin.Rank", "rank").add(Restrictions.eq("rank.Id",box.getInt(RANK_ID)));
			}
			if(!box.getString(SERVICE_PERSON_NAME).equals("")) {
				crit = crit.add(Restrictions.like("hin.SFirstName",box.getString(SERVICE_PERSON_NAME)+"%"));
			}
			if(box.getInt(SEX_ID)!=0) {
				crit = crit.createAlias("hin.Sex", "sex").add(Restrictions.eq("sex.Id",box.getInt(SEX_ID)));
			}
			if(!box.getString(AGE).equals("")) {
				crit = crit.add(Restrictions.eq("hin.Age",box.getString(AGE)));
			}
			if(!box.getString(DIAGNOSIS).equals("")) {
				
			}
			if(box.getInt(REFERRED_BY)!=0) {
				crit = crit.createAlias("Employee", "emp").add(Restrictions.eq("emp.Id",box.getInt(REFERRED_BY)));
			}
			referralList = crit.list();
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
							.add(Restrictions.eq("h.Id", hospitalId)).createAlias("EmpCategory", "ec")
							.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
							.add(Restrictions.eq("Status","y")).addOrder(Order.asc("FirstName")).list();
			
			rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("RankName")).list();
			relationList = session.createCriteria(MasRelation.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("RelationName")).list();
			sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("AdministrativeSexName")).list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		map.put("referralList", referralList);
		map.put("doctorList", doctorList);
		map.put("rankList", rankList);
		map.put("relationList", relationList);
		map.put("sexList", sexList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPatientDetailsForServiceNo(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> patientList = new ArrayList<Inpatient>();
		String serviceNo = box.getString("serviceNo");
		Session session = (Session)getSession();
		patientList = session.createCriteria(Inpatient.class).createAlias("Hin", "hin").add(Restrictions.eq("hin.ServiceNo", serviceNo)).add(Restrictions.eq("AdStatus", "A")).list();
		map.put("patientList", patientList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> saveMHReferralRegisterDetails(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		List<Patient> patientList = new ArrayList<Patient>();
		int counter = box.getInt("counter");
		try {
			for(int i=1;i<=counter;i++) {
				//if(box.getInt("opdId"+i)!=0) {
				System.out.println("rowval---"+box.getString("rowval"+i));
				if(box.getString("rowval"+i).equals("y")){
					MhReferral mhReferral = new MhReferral();
					if(!box.getString("referredDate"+i).equals(""))
						mhReferral.setReferralDate(HMSUtil.convertStringTypeDateToDateType(box.getString("referredDate"+i)));
					mhReferral.setServiceNo(box.getString("serviceNo"+i));
					mhReferral.setDiagnosis(box.getString("diagnosis"+i));
					mhReferral.setAge(box.getString("age"+i));
					mhReferral.setPatientName(box.getString("pName"+i));
					MasEmployee employee = new MasEmployee();
					employee.setId(box.getInt(REFERRED_BY+i));
					mhReferral.setReferredBy(employee);
					mhReferral.setReferredFor(box.getString(REFERRED_FOR+i));
					mhReferral.setReferTo(box.getString(REFER_TO+i));
					mhReferral.setServicePersonName(box.getString("sName"+i));
					mhReferral.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
					mhReferral.setLastChgTime(box.getString(LAST_CHANGED_TIME));
					mhReferral.setRunDate(HMSUtil.convertStringTypeDateToDateType(box.getString("runDate")));
					mhReferral.setMhName(box.getString("mhName"+i));
					mhReferral.setMobileNo(box.getString("mobileNo"+i));
					if(box.getInt("hinId"+i) !=0){
						Patient patient = new Patient();
						patient.setId(box.getInt("hinId"+i));
						mhReferral.setHin(patient);
					}
					if(box.getInt(RANK_ID+i) != 0){
						MasRank rank = new MasRank();
						rank.setId(box.getInt(RANK_ID+i));
						mhReferral.setRank(rank);
					}
					if(box.getInt(RELATION_ID+i) != 0){
						MasRelation relation = new MasRelation();
						relation.setId(box.getInt(RELATION_ID+i));
						mhReferral.setRelation(relation);
					}
					if(box.getInt(SEX_ID+i) != 0){
						MasAdministrativeSex sex= new MasAdministrativeSex();
						sex.setId(box.getInt(SEX_ID+i));
						mhReferral.setSex(sex);
					}
					Users user = new Users();
					user.setId(box.getInt("userId"));
					mhReferral.setLastChgBy(user);

					MasHospital hospital = new MasHospital();
					hospital.setId(box.getInt("hospitalId"));
					mhReferral.setHospital(hospital);

					hbt.save(mhReferral);

					int opdId = box.getInt("opdId"+i);
					if(opdId!=0){
					OpdPatientDetails patientDetails = (OpdPatientDetails)hbt.load(OpdPatientDetails.class, opdId);
					patientDetails.setMhRun("r");
					hbt.update(patientDetails);
					}
				}

			}
			//patientList = session.createCriteria(Patient.class).add(Restrictions.idEq(mhReferral.getHin().getId())).list();
			flag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map = showMHReferralRegisterJsp(box);
		map.put("flag", flag);
		map.put("patientList", patientList);
		return map;
	}

	/*@SuppressWarnings("unchecked")
	public Map<String, Object> saveMHReferralRegisterDetails(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session)getSession();
		List<Patient> patientList = new ArrayList<Patient>();
		
		try {
			MhReferral mhReferral = new MhReferral();
			mhReferral.setReferralDate(HMSUtil.convertStringTypeDateToDateType(box.getString(REFERRAL_DATE)));
			mhReferral.setServiceNo(box.getString(SERVICE_NO));
			mhReferral.setDiagnosis(box.getString(DIAGNOSIS));
//			mhReferral.setMhName(box.getString(NAME_OF_MH));
			mhReferral.setAge(box.getString(AGE));
			mhReferral.setPatientName(box.getString(PATIENT_NAME));
			MasEmployee employee = new MasEmployee();
			employee.setId(box.getInt(REFERRED_BY));
			mhReferral.setReferredBy(employee);
			mhReferral.setReferredFor(box.getString(REFERRED_FOR));
			mhReferral.setReferTo(box.getString(REFER_TO));
			mhReferral.setServicePersonName(box.getString(SERVICE_PERSON_NAME));
//			mhReferral.setSMiddleName(box.getString(MIDDLE_NAME));
//			mhReferral.setSLastName(box.getString(LAST_NAME));
			mhReferral.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			mhReferral.setLastChgTime(box.getString(LAST_CHANGED_TIME));
			mhReferral.setRunDate(HMSUtil.convertStringTypeDateToDateType(box.getString("runDate")));
			
			if(box.getInt(HIN_ID) !=0){
				Patient patient = new Patient();
				patient.setId(box.getInt(HIN_ID));
				mhReferral.setHin(patient);
			}
			if(box.getInt(RANK_ID) != 0){
				MasRank rank = new MasRank();
				rank.setId(box.getInt(RANK_ID));
				mhReferral.setRank(rank);
			}
			if(box.getInt(RELATION_ID) != 0){
				MasRelation relation = new MasRelation();
				relation.setId(box.getInt(RELATION_ID));
				mhReferral.setRelation(relation);
			}
			if(box.getInt(SEX_ID) != 0){
				MasAdministrativeSex sex= new MasAdministrativeSex();
				sex.setId(box.getInt(SEX_ID));
				mhReferral.setSex(sex);
			}
			if(box.getInt(DISPOSAL_ID) != 0){
				MasDisposedTo disposedTo = new MasDisposedTo();
				disposedTo.setId(box.getInt(DISPOSAL_ID));
				mhReferral.setDisposal(disposedTo);
			}	
			if(box.getInt(BLOOD_GROUP_ID) != 0){
				MasBloodGroup bloodGrp = new MasBloodGroup();
				bloodGrp.setId(box.getInt(BLOOD_GROUP_ID));
				mhReferral.setBloodGroup(bloodGrp);
			}	
			Users user = new Users();
			user.setId(box.getInt("userId"));
			mhReferral.setLastChgBy(user);
			
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			mhReferral.setHospital(hospital);
			
			hbt.save(mhReferral);
			
			int opdId = box.getInt("opdId");
			OpdPatientDetails patientDetails = (OpdPatientDetails)hbt.load(OpdPatientDetails.class, opdId);
			patientDetails.setMhRun("r");
			hbt.update(patientDetails);
			
			
			patientList = session.createCriteria(Patient.class).add(Restrictions.idEq(mhReferral.getHin().getId())).list();
			flag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map = showMHReferralRegisterJsp(box);
		map.put("flag", flag);
		map.put("patientList", patientList);
		return map;
	}
*/
	@SuppressWarnings("unchecked")
	public Map<String, Object> getServiceNoDetailsForReg(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = box.getString("serviceNo");
		int serviceTypeId = box.getInt(SERVICE_TYPE_ID);
		List<Patient> dependentList = new ArrayList<Patient>();
		org.hibernate.Session session = getSession();
		dependentList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
		.createAlias("ServiceType", "st").add(Restrictions.eq("st.Id", serviceTypeId)).add(Restrictions.eq("Status", "y")).list();
//		List<MasEmployeeDependent> dependentList = new ArrayList<MasEmployeeDependent>();
		/*dependentList = session.createCriteria(MasEmployeeDependent.class).createAlias("Employee", "emp")
							.add(Restrictions.eq("emp.ServiceNo", serviceNo))
							.createAlias("emp.ServiceType", "st").add(Restrictions.eq("st.Id", serviceTypeId)).add(Restrictions.eq("Status", "y")).list();*/
		map.put("dependentList",dependentList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getServiceNoDetailsForRegHAL(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = box.getString("serviceNo");
		List<MasEmployee> srEmployeeList = new ArrayList<MasEmployee>();
		List<MasRelation> masRelationList = new ArrayList<MasRelation>();
		List<Patient> dependentList = new ArrayList<Patient>();
		org.hibernate.Session session = getSession();
		int hospitalId = box.getInt("hospitalId");
		/*dependentList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
		.createAlias("ServiceType", "st").add(Restrictions.eq("st.Id", serviceTypeId)).add(Restrictions.eq("Status", "y")).list();*/
//		List<MasEmployeeDependent> dependentList = new ArrayList<MasEmployeeDependent>();
		/*dependentList = session.createCriteria(MasEmployeeDependent.class).createAlias("Employee", "emp")
							.add(Restrictions.eq("emp.ServiceNo", serviceNo))
							.createAlias("emp.ServiceType", "st").add(Restrictions.eq("st.Id", serviceTypeId)).add(Restrictions.eq("Status", "y")).list();*/
		srEmployeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("ServiceNo", serviceNo))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		masRelationList = session.createCriteria(MasRelation.class).add(
				Restrictions.eq("Status", 'y').ignoreCase()).list();
		
		
		map.put("masRelationList",masRelationList);
		map.put("srEmployeeListGrid",srEmployeeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getServPersonPatientDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int empDependentId = box.getInt("dependentId");
		List<MasEmployeeDependent> detailsList = new ArrayList<MasEmployeeDependent>();
		org.hibernate.Session session = getSession();
		
	//	detailsList = session.createCriteria(MasEmployeeDependent.class).add(Restrictions.eq("Id", empDependentId)).add(Restrictions.eq("Status", "y")).list();
		MasEmployeeDependent employeeDependent = new MasEmployeeDependent();
		
		List<Patient> patientList = new ArrayList<Patient>(); 
		//if(detailsList.size() > 0){
			//employeeDependent = detailsList.get(0);
			
			String firstName = "";
		/*	if(employeeDependent.getEmployeeDependentName().indexOf(" ") >= 0)
				firstName = employeeDependent.getEmployeeDependentName().substring(0, employeeDependent.getEmployeeDependentName().indexOf(" "));
			else
				firstName = employeeDependent.getEmployeeDependentName().substring(0);*/
			
			if(box.getString("depnName").indexOf(" ") >= 0)
				firstName = box.getString("depnName").substring(0, box.getString("depnName").indexOf(" "));
			else
				firstName = box.getString("depnName").substring(0);
			patientList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", box.getString("serviceNo")))
						.add(Restrictions.like("PFirstName", firstName+"%")).list();
	//	}
		
		if(patientList.size() > 0){
			map.put("message", "Patient already Regsitered.");
			map.put("hinId", patientList.get(0).getId());
		}
		map.put("detailsList",detailsList);
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		int cnt = box.getInt("cnt");
		String relation = box.getString("rel"+cnt);
		List<Integer> relationIdList = new ArrayList<Integer>();
		relationIdList = session.createCriteria(MasRelation.class).add(Restrictions.eq("HicCode", relation).ignoreCase()).setProjection(Projections.property("Id")).list();
//		relationIdList = hbt.find("select Id from MasRelation where upper(HicCode) = upper('"+relation+"')");
		if(relationIdList.size() > 0){
		map.put("relationIdList", relationIdList);
		}
		
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getSrPhoto(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int serviceTypeId = 0;
		String serviceNo = "";

	//	serviceTypeId = box.getInt("serviceTypeId");
	//	serviceNo = box.get("serviceNo");
		int hinId = box.getInt("photoHinId");
		org.hibernate.Session session = getSession();
		List<Patient>documentList=new ArrayList<Patient>();
	//	List<UploadDocuments>documentList=new ArrayList<UploadDocuments>();

	/*	documentList = session.createCriteria(UploadDocuments.class)
				.createAlias("Hin", "hin").add(Restrictions.eq("hin.ServiceNo", serviceNo)).add(Restrictions.eq("hin.ServiceType.Id", serviceTypeId)).list();*/
		documentList = session.createCriteria(Patient.class).add(Restrictions.idEq(hinId)).list();
		
		map.put("documentList", documentList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getMhReferralDetailsForEdit(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int opdId =  box.getInt("opdId");
		org.hibernate.Session session = getSession();
//		List<MhReferral> referralList=new ArrayList<MhReferral>();
		List<OpdPatientDetails> referralList=new ArrayList<OpdPatientDetails>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
//		referralList = session.createCriteria(MhReferral.class).add(Restrictions.idEq(referralId)).list();
		referralList = session.createCriteria(OpdPatientDetails.class).add(Restrictions.idEq(opdId)).list();
		doctorList = session.createCriteria(MasEmployee.class).createAlias("Hospital", "h")
			.add(Restrictions.eq("h.Id", box.getInt("hospitalId"))).createAlias("EmpCategory", "ec")
			.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor)).list();
		map.put("referralList", referralList);
		map.put("doctorList", doctorList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> updateMHReferralRegisterDetails(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		org.hibernate.Session session = getSession();
		List<Patient> patientList = new ArrayList<Patient>();
		
		try {
			MhReferral mhReferral = (MhReferral)hbt.load(MhReferral.class, box.getInt("referralId"));
			mhReferral.setReferralDate(HMSUtil.convertStringTypeDateToDateType(box.getString(REFERRAL_DATE)));
			mhReferral.setDiagnosis(box.getString(DIAGNOSIS));
			mhReferral.setMhName(box.getString(NAME_OF_MH));
			mhReferral.setAge(box.getString(AGE));
			MasEmployee employee = new MasEmployee();
			employee.setId(box.getInt(REFERRED_BY));
			mhReferral.setReferredBy(employee);
			mhReferral.setReferredFor(box.getString(REFERRED_FOR));
			mhReferral.setReferTo(box.getString(REFER_TO));
			mhReferral.setSFirstName(box.getString(FIRST_NAME));
			mhReferral.setSMiddleName(box.getString(MIDDLE_NAME));
			mhReferral.setSLastName(box.getString(LAST_NAME));
			mhReferral.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			mhReferral.setLastChgTime(box.getString(LAST_CHANGED_TIME));
			
			Users user = new Users();
			user.setId(box.getInt("userId"));
			mhReferral.setLastChgBy(user);
			
				
			hbt.update(mhReferral);
			patientList = session.createCriteria(Patient.class).add(Restrictions.idEq(mhReferral.getHin().getId())).list();
			flag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map = showMHReferralRegisterJsp(box);
		map.put("patientList", patientList);
		map.put("flag", flag);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientInfoForVisit(Box box) {
		Map<String, Object> map =new HashMap<String, Object>();
		org.hibernate.Session session = getSession();
		List<Patient> patientList = new ArrayList<Patient>();
		int hinId = box.getInt(HIN_ID);
		patientList = session.createCriteria(Patient.class).add(Restrictions.idEq(hinId)).list();
		List<Visit> maxVisitList = new ArrayList<Visit>();
		maxVisitList = session.createCriteria(Visit.class).createAlias("Hin", "hin").add(Restrictions.eq("hin.Id", hinId)).add(Restrictions.eq("VisitStatus", "w")).list();
		
		map.put("patientList", patientList);
		map.put("maxVisitList", maxVisitList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientInfoForVisitHAL(Box box) {
		Map<String, Object> map =new HashMap<String, Object>();
		org.hibernate.Session session = getSession();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		MasEmployee emp = new MasEmployee();
		Patient patient = new Patient();
		List<MasEmployeeDependent> depList = new ArrayList<MasEmployeeDependent>();
		int relationId = box.getInt(HIN_ID);
		int hospitalId = box.getInt("hospitalId");
		String serviceNoId = box.get("serviceNo");
		System.out.println("realtionId"+relationId);
		System.out.println("serviceNoId"+serviceNoId);
		patientList = session.createCriteria(Patient.class)
				.createAlias("Relation", "rel")
				.add(Restrictions.eq("rel.Id", relationId))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("ServiceNo", serviceNoId)).list();
		System.out.println("patientList="+patientList.size());
		if(patientList.size()==0)
		{
			 depList = session.createCriteria(MasEmployeeDependent.class)
					.createAlias("Relation", "rel")
					.createAlias("Employee", "emp")
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("rel.Id", relationId))
					.add(Restrictions.eq("emp.ServiceNo", serviceNoId)).list();
			 if(depList.size()>0)
			 {
			 patient.setPFirstName(depList.get(0).getEmployeeDependentFName());
			 patient.setPMiddleName(depList.get(0).getEmployeeDependentMName());
			 patient.setPLastName(depList.get(0).getEmployeeDependentLName());
			 patient.setSex(depList.get(0).getGender());
			 patient.setDateOfBirth(depList.get(0).getDateOfBirth());
			 patient.setContactNo(depList.get(0).getContactNo());
			 patient.setAddress(depList.get(0).getAddress());
			 patient.setRelation(depList.get(0).getRelation());
			 patient.setBloodGroup(depList.get(0).getBloodGroup());	
			 }
			 else
			 {
				 System.out.println("service No"+serviceNoId);
				 empList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("ServiceNo", serviceNoId)).list();
				 patient.setPFirstName(empList.get(0).getFirstName());
				 patient.setPMiddleName(empList.get(0).getMiddleName());
				 patient.setPLastName(empList.get(0).getLastName());
				 patient.setSex(empList.get(0).getGender());
				 patient.setDateOfBirth(empList.get(0).getDateOfBirth());
				 patient.setContactNo(empList.get(0).getTelNoEmergency());
				 patient.setAddress(empList.get(0).getLocalAddress());
				 patient.setBloodGroup(empList.get(0).getBloodGroup());	
				 //code start for getting self relation object 
				 
				    String selfRelationName="";
					MasRelation masR = new MasRelation();
					Properties propadt = new Properties();
					URL resourcePathadt = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");

					try {
						propadt.load(resourcePathadt.openStream());	
						
						selfRelationName=propadt.getProperty("selfRelationName");
						List<MasRelation> mr = session.createCriteria(MasRelation.class)
								.add(Restrictions.eq("NewRelationName", selfRelationName).ignoreCase())
								.add(Restrictions.eq("Status", "y").ignoreCase()).list();
						masR = mr.get(0);
					} catch (Exception e) {
						e.printStackTrace();
					}
					//code end for getting self relation object 	
					
				 patient.setRelation(masR);
			 }
			 patientList.add(patient);
		}
		else
		{
			
			 depList = session.createCriteria(MasEmployeeDependent.class)
						.createAlias("Relation", "rel")
						.createAlias("Employee", "emp")
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("rel.Id", relationId))
						.add(Restrictions.eq("emp.ServiceNo", serviceNoId)).list();
				 if(depList.size()>0)
				 {
					 patientList.get(0).setBloodGroup(depList.get(0).getBloodGroup());				
				 }
				 else
				 {
					 
					 empList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("ServiceNo", serviceNoId)).list();
					 patientList.get(0).setBloodGroup(empList.get(0).getBloodGroup());
					
				 }
			
		}
		/*List<Visit> maxVisitList = new ArrayList<Visit>();
		maxVisitList = session.createCriteria(Visit.class).createAlias("Hin", "hin").add(Restrictions.eq("hin.Id", relationId)).add(Restrictions.eq("VisitStatus", "w")).list();*/
		
		map.put("patientList", patientList);
		/*map.put("maxVisitList", maxVisitList);*/
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getOutPatientHinNo(Box box) {
		Map<String, Object> map =new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Object[]> hinNoList = new ArrayList<Object[]>();
		String serviceNo = box.getString(SERVICE_NO);
		try {
			if (!serviceNo.equals("")) {
				hinNoList = session.createCriteria(Patient.class).add(
						Restrictions.eq("ServiceNo", serviceNo)).add(Restrictions.eq("PatientStatus","Out Patient"))
						.createAlias("Relation", "rel")
						.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("HinNo"))
						.add(Projections.property("PFirstName"))
						.add(Projections.property("PMiddleName"))
						.add(Projections.property("PLastName")).add(Projections.property("rel.RelationName")))
						.list();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		//	session.close();
		}
		map.put("hinNoList", hinNoList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getDetailsForDMOCallRegister(int hospitalId) {
		Map<String, Object> map =new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
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
			.add(Restrictions.eq("h.Id", hospitalId)).createAlias("EmpCategory", "ec")
			.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor)).add(Restrictions.eq("Status", "y")).list();
		map.put("doctorList", doctorList);
		return map;
	}

	@Override
	public Map<String, Object> saveDMOCallRegisterDetails(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			DmoCallRegister dmoCallRegister = new DmoCallRegister();
			dmoCallRegister.setPatientReportedDate(HMSUtil.convertStringTypeDateToDateType(box.getString(REPORTED_DATE)));
			dmoCallRegister.setPatientReportedTime(box.getString(REPORTED_TIME));
			dmoCallRegister.setCallSentDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CALL_SENT_DATE)));
			dmoCallRegister.setCallSentTime(box.getString(CALL_SENT_TIME));
			dmoCallRegister.setDmoAttendedDate(HMSUtil.convertStringTypeDateToDateType(box.getString(DMO_ATTND_DATE)));
			dmoCallRegister.setCallAttendedTime(box.getString(CALL_ATTND_TIME));
			MasEmployee employee = new MasEmployee();
			employee.setId(box.getInt(MEDICAL_OFFICER_ID));
			dmoCallRegister.setMedicalOfficer(employee);
			dmoCallRegister.setDisposal(box.getString(DISPOSAL));
			dmoCallRegister.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			dmoCallRegister.setLastChgTime(box.getString(LAST_CHANGED_TIME));
			
			if(box.getInt(HIN_ID) !=0){
				Patient patient = new Patient();
				patient.setId(box.getInt(HIN_ID));
				dmoCallRegister.setHin(patient);
			}
			Users user = new Users();
			user.setId(box.getInt("userId"));
			dmoCallRegister.setLastChgBy(user);
			
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			dmoCallRegister.setHospital(hospital);
			
			hbt.save(dmoCallRegister);
			
			flag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map = getDetailsForDMOCallRegister(box.getInt("hospitalId"));
		map.put("flag", flag);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showAmbulanceRunRegister() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<MasServiceStatus> serviceStatusList = new ArrayList<MasServiceStatus>();
		List<Object[]> unitList = new ArrayList<Object[]>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(
				Order.asc("RankName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).list();
		unitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).createAlias("Station", "station",CriteriaSpecification.LEFT_JOIN).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))
						.add(Projections.property("station.StationName"))).addOrder(
				Order.asc("UnitName")).list();
		relationList =session.createCriteria(MasRelation.class).add(Restrictions.eq("Status", "y")).addOrder(
				Order.asc("RelationName")).list();
		map.put("serviceTypeList", serviceTypeList);
		map.put("rankList", rankList);
		map.put("sexList", sexList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("relationList", relationList);
		map.put("unitList", unitList);
		return map;
	}

	@Override
	public Map<String, Object> saveAmbulanceRunRegisterDetails(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			AmbulanceRunRegister ambulanceRunRegister = new AmbulanceRunRegister();
			ambulanceRunRegister.setAmbulanceRunDate(HMSUtil.convertStringTypeDateToDateType(box.getString(AMBULANCE_RUN_DATE)));
			ambulanceRunRegister.setAmbulanceRunTime(box.getString(AMBULANCE_RUN_TIME));
			ambulanceRunRegister.setFromSmc(box.getString(FROM_SMC));
			ambulanceRunRegister.setToDestination(box.getString(DESTINATION));
			
			ambulanceRunRegister.setPatientName(box.getString(PATIENT_NAME));
			ambulanceRunRegister.setServicePersonName(box.getString(SERVICE_PERSON_NAME));
			ambulanceRunRegister.setDiagnosis(box.getString(DIAGNOSIS));
			ambulanceRunRegister.setRemarks(box.getString(REMARKS));
			ambulanceRunRegister.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			ambulanceRunRegister.setLastChgTime(box.getString(LAST_CHANGED_TIME));
			ambulanceRunRegister.setServiceNo(box.getString(SERVICE_NO));
			
			if(box.getInt(HIN_ID) != 0){
				Patient patient = new Patient();
				patient.setId(box.getInt(HIN_ID));
				ambulanceRunRegister.setHin(patient);
			}
			
			if(box.getInt(RELATION_ID) != 0){
				MasRelation relation = new MasRelation();
				relation.setId(box.getInt(RELATION_ID));
				ambulanceRunRegister.setRelation(relation);
			}
			if(box.getInt(UNIT_ID) != 0){
				MasUnit unit = new MasUnit();
				unit.setId(box.getInt(UNIT_ID));
				ambulanceRunRegister.setUnit(unit);
			}
			if(!box.getString(AGE).equals(""))
				ambulanceRunRegister.setAge(box.getString(AGE));
			
			if(box.getInt(RANK_ID)!=0){
				MasRank rank = new MasRank();
				rank.setId(box.getInt(RANK_ID));
				ambulanceRunRegister.setRank(rank);
			}
			if(box.getInt(SEX)!=0){
				MasAdministrativeSex sex = new MasAdministrativeSex();
				sex.setId(box.getInt(SEX));
				ambulanceRunRegister.setSex(sex);
			}
			Users user = new Users();
			user.setId(box.getInt("userId"));
			ambulanceRunRegister.setLastChgBy(user);
			
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			ambulanceRunRegister.setHospital(hospital);
			
			ambulanceRunRegister.setAttendants(box.getString("attendants"));
			if(!box.getString("charge").equals(""))
				ambulanceRunRegister.setCharge(new BigDecimal(box.getString("charge")));
			
			hbt.save(ambulanceRunRegister);
			
			flag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map = showAmbulanceRunRegister();
		map.put("flag", flag);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showDMARegister(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = (Integer)dataMap.get("hospitalId");
		int deptId = (Integer)dataMap.get("deptId");
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();

		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y")).list();
		List opdIssueNo = new ArrayList();
		opdIssueNo = session.createQuery(
				"select syd from StoreFyDocumentNo as syd where syd.Department.Id="
				+ deptId).list();
		String opdIssueNoFromDB = "";
		String opdIssuenoIncremented = "";
		StoreFyDocumentNo storeFyDocumentNo = new StoreFyDocumentNo();
		if(opdIssueNo.size() > 0){
			storeFyDocumentNo = (StoreFyDocumentNo) opdIssueNo.get(0);
			opdIssueNoFromDB = storeFyDocumentNo.getOpdIssueNo();
			opdIssuenoIncremented = getMaxNo(opdIssueNoFromDB);
		}else {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			opdIssuenoIncremented = getMaxNo("");
			storeFyDocumentNo.setOpdIssueNo(opdIssuenoIncremented);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			storeFyDocumentNo.setDepartment(masDepartment);
			hbt.save(storeFyDocumentNo);
			hbt.refresh(storeFyDocumentNo);
			
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
		doctorList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Hospital", "h")
						.add(Restrictions.eq("h.Id", hospitalId)).createAlias("EmpCategory", "ec")
						.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor)).list();
		disposalList = session.createCriteria(MasDisposal.class).add(Restrictions.eq("Status", "y")).list();
		map.put("doctorList", doctorList);
		map.put("disposalList", disposalList);
		map.put("storeFyDocumentNo", storeFyDocumentNo);
		map.put("opdIssuenoIncremented", opdIssuenoIncremented);
		map.put("frequencyList", frequencyList);
		return map;
	}
	
	public String getMaxNo(String no) {
		String maxNo = "";
		String y1 = "";
		String y2 = "";
		String y3 = "";
		int tempMonth = 0;
		if ((no == null) || (no.equals("0"))) {
			no = "";
		}
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		int currentMonth = gregorianCalendar.get(Calendar.MONTH) + 1;
		String currentYear = "" + gregorianCalendar.get(Calendar.YEAR);
		try {
			if ((Integer.parseInt(currentYear.substring(2)) - 1) <= 9)
				y1 = "0" + (Integer.parseInt(currentYear.substring(2)) - 1);
			else
				y1 = "" + (Integer.parseInt(currentYear.substring(2)) - 1);

			if (Integer.parseInt(currentYear.substring(2)) <= 9)
				y2 = "0" + Integer.parseInt(currentYear.substring(2));
			else
				y2 = "" + Integer.parseInt(currentYear.substring(2));
			if ((Integer.parseInt(currentYear.substring(2)) + 1) <= 9)
				y3 = "0" + (Integer.parseInt(currentYear.substring(2)) + 1);
			else
				y3 = "" + (Integer.parseInt(currentYear.substring(2)) + 1);
		} catch (Exception e) {
e.printStackTrace();
		}
		try {
			if (!no.equals("")) {
				StringTokenizer stringTokenizer = new StringTokenizer(no, "/");
				tempMonth = Integer.parseInt(stringTokenizer.nextToken());
				tempMonth++;
				if (currentMonth < 4) {
					if (tempMonth < 10) {
						maxNo = "0" + tempMonth + "/" + y1 + "-" + y2;
					} else {
						maxNo = tempMonth + "/" + y1 + "-" + y2;
					}
				} else {
					if (tempMonth < 10) {
						maxNo = "0" + tempMonth + "/" + y2 + "-" + y3;
					} else {
						maxNo = tempMonth + "/" + y2 + "-" + y3;
					}
				}

			} else {
				if (currentMonth < 4) {
					maxNo = "01" + "/" + y1 + "-" + y2;
				} else {
					maxNo = "01" + "/" + y2 + "-" + y3;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxNo;
	}

	public Map<String, Object> updatePatientImage(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		//Session session = (Session)getSession();
		String uploadURL="";
		if(generalMap.get("uploadURL")!= null){
			uploadURL =(String) generalMap.get("uploadURL");
		}
		String hinNo = "";
		if(generalMap.get("hinNo")!= null){
			hinNo =(String) generalMap.get("hinNo");
		}
		String extension = "";
		if(generalMap.get("extension")!=null) {
			extension = (String)generalMap.get("extension");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String time = (String)utilMap.get("currentTimeWithoutSc");
		//String fileExtension=null;
		 File file=null;
		 Session session = (Session)getSession();
		 try {
				HibernateTemplate hbt=getHibernateTemplate();
				hbt.setCheckWriteOperations(false);
				hbt.setFlushModeName("FLUSH_EAGER");
				//patientList=hbt.find("from  jkt.hms.masters.business.Patient as patient where patient.HinNo='"+hinNo+"'");
				patientList=session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", hinNo)).list();
				if(patientList.size()>0){
					int hinId=0;
					for (Patient patient : patientList) {
						hinId=patient.getId();
					}
					if(hinId>0){

						String filename = "";
					//	filename =hinNo+".jpg";
						filename =hinNo+"."+extension;
						String fileSeparator = System.getProperty("file.separator");
				//		file = new File(uploadURL +fileSeparator+hinNo+".jpg");
						file = new File(uploadURL +fileSeparator+hinNo+"."+extension);

						File f = new File(uploadURL);
						System.out.println("file url===="+f);
						try {
							if (f.exists()) {
								f.delete();
								f.mkdir();
								FileInputStream is = new FileInputStream(file);
								long length = file.length();
								
								if (length > Integer.MAX_VALUE) {
									// File is too large
								}
								// Create the byte array to hold the data
								byte[] bytes = new byte[(int)length];
								int offset = 0;
								int numRead = 0;
								while (offset < bytes.length
										&& (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
									offset += numRead;
								}

								if (offset < bytes.length) {
									throw new IOException("Could not completely read file "+file.getName());
								}
							
								Patient patient=new Patient();
								patient=(Patient)hbt.load(Patient.class, hinId);
								patient.setFileName(hinNo);
								patient.setPatientImage(bytes);
								patient.setImageFileExtension(extension);
								patient.setPatientImageDate(new Date());
								patient.setPatientImageTime(time);
								hbt.update(patient);
								hbt.refresh(patient);
								is.close();
							} else {
								f.mkdir();
								FileInputStream is = new FileInputStream(file);
								long length = file.length();
								//ByteBuffer byteBuff=null;
								//  int modLength=length/
								if (length > Integer.MAX_VALUE) {
									// File is too large
								}
								// Create the byte array to hold the data
								byte[] bytes = new byte[(int)length];
								int offset = 0;
								int numRead = 0;
								while (offset < bytes.length
										&& (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
									offset += numRead;
								}

								if (offset < bytes.length) {
									throw new IOException("Could not completely read file "+file.getName());
								}
								is.close();
								
								Patient patient=new Patient();
								patient=(Patient)hbt.load(Patient.class, hinId);
								patient.setFileName(hinNo);
								patient.setPatientImage(bytes);
								patient.setImageFileExtension(extension);
								patient.setPatientImageDate(new Date());
								patient.setPatientImageTime(time);
								hbt.update(patient);
								hbt.refresh(patient);
							}
							
							StringTokenizer strToken=new StringTokenizer(filename,".");
							filename=strToken.nextToken();
							//fileExtension=strToken.nextToken();

						} catch (Exception e) {
							e.printStackTrace();
						}
						// Close the input stream and return bytes
					}
				}
	    	   //  bytes;
	    	     		//file.delete();


	    }// end of 'try' loop
		catch (Exception e) {
	      e.printStackTrace();
	    }
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getItemBatch(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
		int deptId = box.getInt("deptId");
		int itemId =  box.getInt("itemId");
		int hospitalId = box.getInt("hospitalId");
		Session session = (Session)getSession();
		batchList = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item").add(Restrictions.eq("item.Id", itemId))
		  				.createAlias("Department", "dept").add(Restrictions.eq("dept.Id", deptId)).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
		map.put("batchList", batchList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	/*public Map<String, Object> submitDMAStockDetails(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		Session session = (Session)getSession();
		int dmaHeaderId = box.getInt("dmaHeaderId");

		try {
			tx = session.beginTransaction();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			DmaRegisterHeader dmaRegisterHeader = new DmaRegisterHeader();
			Patient patient = new Patient();
			patient.setId(box.getInt(HIN_ID));
			if(dmaHeaderId==0){
				dmaRegisterHeader.setHin(patient);
				Users user = new Users();
				user.setId(box.getInt("userId"));
				dmaRegisterHeader.setDMA(user);
				dmaRegisterHeader.setHospital(masHospital);
				dmaRegisterHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				dmaRegisterHeader.setLastChgTime(box.getString(CHANGED_TIME));
				dmaRegisterHeader.setDmaRegisterDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));

				hbt.save(dmaRegisterHeader);
			}else{
				dmaRegisterHeader.setId(dmaHeaderId);
			}

			*//**
			 * Saving Data in OPDIssueM
			 *//*
			StoreOpPatientIssueM storeOpPatientIssueM =  new StoreOpPatientIssueM();
			List opdIssueNo = new ArrayList();
			opdIssueNo = session.createQuery(
					"select syd from StoreFyDocumentNo as syd where syd.Department.Id="
					+ box.getInt("deptId")).list();
			String opdIssueNoFromDB = "";
			String opdIssuenoIncremented = "";
			StoreFyDocumentNo storeFyDocumentNo = new StoreFyDocumentNo();
			if(opdIssueNo.size() > 0){
				storeFyDocumentNo = (StoreFyDocumentNo) opdIssueNo.get(0);
				opdIssueNoFromDB = storeFyDocumentNo.getOpdIssueNo();
				opdIssuenoIncremented = getMaxNo(opdIssueNoFromDB);
				storeFyDocumentNo.setOpdIssueNo(opdIssuenoIncremented);
				hbt.update(storeFyDocumentNo);
			}else {
				opdIssuenoIncremented = getMaxNo("");
				storeFyDocumentNo.setOpdIssueNo(opdIssuenoIncremented);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(box.getInt("deptId"));
				storeFyDocumentNo.setDepartment(masDepartment);
				hbt.save(storeFyDocumentNo);
				hbt.refresh(storeFyDocumentNo);

			}

			MasDepartment department = new MasDepartment();
			department.setId(box.getInt("deptId"));
			storeOpPatientIssueM.setDepartment(department);
			storeOpPatientIssueM.setHospital(masHospital);

			storeOpPatientIssueM.setIssueType("I");
			storeOpPatientIssueM.setTypeOfIssue("P");
			storeOpPatientIssueM.setHin(patient);
			storeOpPatientIssueM.setServiceNo(box.getString(SERVICE_NO));

			storeOpPatientIssueM.setIssueNo(opdIssuenoIncremented);
			storeOpPatientIssueM.setIssueDate(new Date());
			storeOpPatientIssueM.setStatus("y");
			MasEmployee masEmployee = new MasEmployee();
			if(empId != 0){
				masEmployee.setId(empId);
				storeOpPatientIssueM.setEmp(masEmployee);
				}

			storeOpPatientIssueM.setLastChgBy(box.getString("userName"));
			storeOpPatientIssueM.setLastChgDate(new Date());
			storeOpPatientIssueM.setLastChgTime(box.getString(CHANGED_TIME));
			try {
				hbt.save(storeOpPatientIssueM);
			} catch (Exception e) {
			//	if (tx != null)
				//	tx.rollback();
				e.printStackTrace();
			}

			*//**
			 * End
			 *//*

			int counter = box.getInt("hdb");
			for (int i = 1; i < counter; i++) {
				if(box.getInt("issueQty"+i)!=0){
					DmaRegisterDetails dmaRegisterDetails = new DmaRegisterDetails();
					dmaRegisterDetails.setDosage(box.getString("dosage"+i));
					dmaRegisterDetails.setRemarks(box.getString("remarks"+i));
					MasFrequency frequency = new MasFrequency();
					frequency.setId(box.getInt("frequency"+i));
					dmaRegisterDetails.setFrequency(frequency);
					dmaRegisterDetails.setIssueQty(box.getInt("issueQty"+i));
					MasStoreItem item = new MasStoreItem();
					item.setId(box.getInt(ITEM_ID+i));
					dmaRegisterDetails.setItem(item);
					StoreItemBatchStock batchStock = new StoreItemBatchStock();
					batchStock.setId(box.getInt("batchId"+i));
					dmaRegisterDetails.setStock(batchStock);
					dmaRegisterDetails.setDmaRegisterHeader(dmaRegisterHeader);
					dmaRegisterDetails.setRoute(box.getString("route"+i));
					dmaRegisterDetails.setNoOfDays(box.getInt("noOfDays"+i));

					try {
						hbt.save(dmaRegisterDetails);
					} catch (Exception e) {
					//	if (tx != null)
						//	tx.rollback();
						e.printStackTrace();
					}

					*//**
					 * Saving Data in patient issue
					 *//*
					StoreOpPatientIssueT storeOpPatientIssueT = new StoreOpPatientIssueT();
					storeOpPatientIssueT.setOpIssue(storeOpPatientIssueM);
					storeOpPatientIssueT.setItemIdRequire(item);
					storeOpPatientIssueT.setItemIdIssue(item);
					storeOpPatientIssueT.setBatchNo(box.getString("batchNo"+i));
					if(!box.getString("expDate"+i).equals("")){
						Date expiryDateToInsert=HMSUtil.convertStringTypeDateToDateType(box.getString("expDate"+i));
						storeOpPatientIssueT.setExpiryDate(expiryDateToInsert);
					}
					storeOpPatientIssueT.setQtyIssued(new BigDecimal(box.getInt("issueQty"+i)));
					if(!box.getString("costPrice"+i).equals("")){
						storeOpPatientIssueT.setRate(new BigDecimal(box.getString("costPrice"+i)));
					}
					storeOpPatientIssueT.setOpIssueType("");
					try {
						hbt.save(storeOpPatientIssueT);
					} catch (Exception e) {
						//if (tx != null)
						//	tx.rollback();
						e.printStackTrace();
					}



					StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock)hbt.load(StoreItemBatchStock.class, box.getInt("batchId"+i));
					BigDecimal issueStock = new BigDecimal(0);
					BigDecimal clStock = new BigDecimal(0);

					if(storeItemBatchStock.getClosingStock()!= null){
						clStock = storeItemBatchStock.getClosingStock();
					}
					if(storeItemBatchStock.getIssueQty()!= null){
						issueStock = storeItemBatchStock.getIssueQty();
					}
					storeItemBatchStock.setIssueQty(issueStock.add(new BigDecimal(box.getInt("issueQty"+i))));
					storeItemBatchStock.setClosingStock(clStock.subtract(new BigDecimal(box.getInt("issueQty"+i))));

					try {
						hbt.update(storeItemBatchStock);
					} catch (Exception e) {
						//if (tx != null)
						//	tx.rollback();
						e.printStackTrace();
					}


				}
			}
			List<Integer> dmaMaxIdList = new ArrayList<Integer>();
			dmaMaxIdList = session.createCriteria(DmaRegisterHeader.class).setProjection(Projections.max("Id")).list();
			if(dmaMaxIdList.size()>0)
				map.put("dmaHeaderId", dmaMaxIdList.get(0));
			tx.commit();
			flag = true;
		}catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

		map.put("flag", flag);
		return map;
	}*/
	
	public Map<String, Object> saveDmaRegisterDetails(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		Session session = (Session)getSession();
	
		try {
			tx = session.beginTransaction();
			int dmaHeaderId = box.getInt("dmaHeaderId");
			// -------------------- Dinesh 08/12/2012--------------------------------
			DmaRegisterHeader dmaRegisterHeader=null;
			/*if(dmaHeaderId!=0)
			{	
			dmaRegisterHeader = (DmaRegisterHeader)hbt.load(DmaRegisterHeader.class, dmaHeaderId);
			dmaRegisterHeader.setComplaints(box.getString(COMPLAINT_DESC));
			dmaRegisterHeader.setDmoCalled(box.getString("dmoCalled"));
			dmaRegisterHeader.setWorkingDiagnosis(box.getString("workingDiagnosis"));
			dmaRegisterHeader.setCallTime(box.getString(CALL_SENT_TIME));
			dmaRegisterHeader.setDmoTransAmbu(box.getString("dmoTransAmbu"));
			dmaRegisterHeader.setTptAmbSentTime(box.getString("tptAmbSentTime"));
			dmaRegisterHeader.setDmoArrivedTime(box.getString("dmoArrivedTime"));
			if(box.getInt(MEDICAL_OFFICER_ID)!= 0){
				MasEmployee employee = new MasEmployee();
				employee.setId(box.getInt(MEDICAL_OFFICER_ID));
				dmaRegisterHeader.setDMO(employee);
			}
			dmaRegisterHeader.setTimeAttended(box.getString(CALL_ATTND_TIME));
			dmaRegisterHeader.setRemarks(box.getString(REMARKS));
			if(box.getInt(DISPOSAL)!= 0){
				MasDisposal disposal = new MasDisposal();
				disposal.setId(box.getInt(DISPOSAL));
				dmaRegisterHeader.setDisposal(disposal);
			}
			dmaRegisterHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			dmaRegisterHeader.setLastChgTime(box.getString(CHANGED_TIME));
			dmaRegisterHeader.setDmaRegisterDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));

			hbt.update(dmaRegisterHeader);
			}else
			{*/
			
			Patient patient = new Patient();
			patient.setId(box.getInt(HIN_ID));
			Users user = new Users();
			user.setId(box.getInt("userId"));
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
				dmaRegisterHeader =  new DmaRegisterHeader();
				
			
				dmaRegisterHeader.setHin(patient);
				dmaRegisterHeader.setDMA(user);
				dmaRegisterHeader.setHospital(masHospital);
				dmaRegisterHeader.setComplaints(box.getString(COMPLAINT_DESC));
				dmaRegisterHeader.setDmoCalled(box.getString("dmoCalled"));
				dmaRegisterHeader.setWorkingDiagnosis(box.getString("workingDiagnosis"));
				dmaRegisterHeader.setCallTime(box.getString(CALL_SENT_TIME));
				dmaRegisterHeader.setDmoTransAmbu(box.getString("dmoTransAmbu"));
				dmaRegisterHeader.setTptAmbSentTime(box.getString("tptAmbSentTime"));
				dmaRegisterHeader.setDmoArrivedTime(box.getString("dmoArrivedTime"));
				dmaRegisterHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				dmaRegisterHeader.setLastChgTime(box.getString(CHANGED_TIME));
				dmaRegisterHeader.setDmaRegisterDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));

				if(box.getInt(MEDICAL_OFFICER_ID)!= 0){
					MasEmployee employee = new MasEmployee();
					employee.setId(box.getInt(MEDICAL_OFFICER_ID));
					dmaRegisterHeader.setDMO(employee);
				}
				dmaRegisterHeader.setTimeAttended(box.getString(CALL_ATTND_TIME));
				dmaRegisterHeader.setRemarks(box.getString(REMARKS));
				if(box.getInt(DISPOSAL)!= 0){
					MasDisposal disposal = new MasDisposal();
					disposal.setId(box.getInt(DISPOSAL));
					dmaRegisterHeader.setDisposal(disposal);
				}
				hbt.save(dmaRegisterHeader);
				
				/**
				 * Create visit in case of DMO called
				 */
				Visit visit = new Visit();
				visit.setReportingFor("OPD");
				if (box.getInt(DEPARTMENT_ID)!=0) {
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(box.getInt(DEPARTMENT_ID));
					visit.setDepartment(masDepartment);
				}
				String tokenAndDoctor = "";
				
				/*if (request.getParameter(TOKEN_NO) != null
						&& !(request.getParameter(TOKEN_NO).equals(""))) {
					visit.setTokenNo(Integer.parseInt(request.getParameter(TOKEN_NO)));
					tokenAndDoctor = request.getParameter(TOKEN_NO);
				}*/
				int tokenNo = 0;
		      
				int consultingDoctorId = 0;
				if (box.getInt(MEDICAL_OFFICER_ID)!= 0) {
					consultingDoctorId = box.getInt(MEDICAL_OFFICER_ID);
					MasEmployee consultingDoctorObj = new MasEmployee();
					consultingDoctorObj.setId(consultingDoctorId);
					visit.setDoctor(consultingDoctorObj);
		            int maxTokenNo = 0;
		            /*maxTokenNo =getTokenNoForDepartment(consultingDoctorId);*/
		            tokenNo = maxTokenNo + 1;
					
					tokenAndDoctor = tokenNo+"#"+consultingDoctorId;
				}else{
					  tokenNo = 0;
					  tokenAndDoctor = tokenNo+"#"+consultingDoctorId;
				}
				 Patient hin = (Patient)hbt.load(Patient.class, box.getInt(HIN_ID));
				 int currentVisitNo = hin.getCurrentVisitNo()+1;
				 hin.setCurrentVisitNo(currentVisitNo);
				 hbt.update(hin);
				
				 visit.setVisitNo(currentVisitNo);
				visit.setHin(patient);
				visit.setTokenNo(tokenNo);
				visit.setTokenDoctor(tokenAndDoctor);
		
				visit.setHospital(masHospital);
				visit.setAddEditBy(user);
				visit.setAge(box.getString("age"));
				visit.setVisitDate(new Date());
				visit.setVisitTime(box.getString(CHANGED_TIME));
				visit.setAddEditDate(new Date());
				visit.setAddEditTime(box.getString(CHANGED_TIME));
				
				visit.setStatus("y");
				
				visit.setAppointmentType("D");
				visit.setVisitStatus("w");
								
				visit.setPriority(3);
				hbt.save(visit);
		//}
			
			/**
			 *  Start Code for saving stock details
			 */
				
			/**
			 * Saving Data in OPDIssueM
			 */
			StoreOpPatientIssueM storeOpPatientIssueM =  new StoreOpPatientIssueM();
			List opdIssueNo = new ArrayList();
			opdIssueNo = session.createQuery(
					"select syd from StoreFyDocumentNo as syd where syd.Department.Id="
					+ box.getInt("deptId")).list();
			String opdIssueNoFromDB = "";
			String opdIssuenoIncremented = "";
			StoreFyDocumentNo storeFyDocumentNo = new StoreFyDocumentNo();
			if(opdIssueNo.size() > 0){
				storeFyDocumentNo = (StoreFyDocumentNo) opdIssueNo.get(0);
				opdIssueNoFromDB = storeFyDocumentNo.getOpdIssueNo();
				opdIssuenoIncremented = getMaxNo(opdIssueNoFromDB);
				storeFyDocumentNo.setOpdIssueNo(opdIssuenoIncremented);
				hbt.update(storeFyDocumentNo);
			}else {
				opdIssuenoIncremented = getMaxNo("");
				storeFyDocumentNo.setOpdIssueNo(opdIssuenoIncremented);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(box.getInt("deptId"));
				storeFyDocumentNo.setDepartment(masDepartment);
				hbt.save(storeFyDocumentNo);
				hbt.refresh(storeFyDocumentNo);

			}

			MasDepartment department = new MasDepartment();
			department.setId(box.getInt("deptId"));
			storeOpPatientIssueM.setDepartment(department);
			storeOpPatientIssueM.setHospital(masHospital);

			storeOpPatientIssueM.setIssueType("I");
			storeOpPatientIssueM.setTypeOfIssue("P");
			storeOpPatientIssueM.setHin(patient);
			storeOpPatientIssueM.setServiceNo(box.getString(SERVICE_NO));

			storeOpPatientIssueM.setIssueNo(opdIssuenoIncremented);
			storeOpPatientIssueM.setIssueDate(new Date());
			storeOpPatientIssueM.setStatus("y");
			storeOpPatientIssueM.setLastChgBy(box.getString("userName"));
			storeOpPatientIssueM.setLastChgDate(new Date());
			storeOpPatientIssueM.setLastChgTime(box.getString(CHANGED_TIME));
			hbt.save(storeOpPatientIssueM);
			

			/**
			 * End
			 */

			int counter = box.getInt("hdb");
			for (int i = 1; i <= counter; i++) {
				if(box.getInt("total"+i)!=0){
					DmaRegisterDetails dmaRegisterDetails = new DmaRegisterDetails();
					dmaRegisterDetails.setDosage(box.getString("dosage"+i));
					dmaRegisterDetails.setRemarks(box.getString("remarks"+i));
					MasFrequency frequency = new MasFrequency();
					frequency.setId(box.getInt("frequency"+i));
					dmaRegisterDetails.setFrequency(frequency);
					dmaRegisterDetails.setIssueQty(box.getInt("total"+i));
					MasStoreItem item = new MasStoreItem();
					
					int index1 = box.getString("nomenclature"+i).lastIndexOf("(");
					 int index2 = box.getString("nomenclature"+i).lastIndexOf(")");
					
					 index1++;
					int itemId =Integer.parseInt(box.getString("nomenclature"+i).substring(index1, index2));
					item.setId(itemId);
//					item.setId(box.getInt(ITEM_ID+i));
					dmaRegisterDetails.setItem(item);
					StoreItemBatchStock batchStock = new StoreItemBatchStock();
					batchStock.setId(box.getInt("batchId"+i));
					dmaRegisterDetails.setStock(batchStock);
					dmaRegisterDetails.setDmaRegisterHeader(dmaRegisterHeader);
					dmaRegisterDetails.setRoute(box.getString("route"+i));
					dmaRegisterDetails.setNoOfDays(box.getInt("noOfDays"+i));
					hbt.save(dmaRegisterDetails);
				

					/**
					 * Saving Data in patient issue
					 */
					StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock)hbt.load(StoreItemBatchStock.class, box.getInt("batchId"+i));
					BigDecimal issueStock = new BigDecimal(0);
					BigDecimal clStock = new BigDecimal(0);
					
					StoreOpPatientIssueT storeOpPatientIssueT = new StoreOpPatientIssueT();
					storeOpPatientIssueT.setOpIssue(storeOpPatientIssueM);
					storeOpPatientIssueT.setItemIdRequire(item);
					storeOpPatientIssueT.setItemIdIssue(item);
					storeOpPatientIssueT.setBatchNo(storeItemBatchStock.getBatchNo());
					
					if(storeItemBatchStock.getExpiryDate()!=null && !storeItemBatchStock.getExpiryDate().equals("")){
						Date expiryDateToInsert=storeItemBatchStock.getExpiryDate();
						storeOpPatientIssueT.setExpiryDate(expiryDateToInsert);
					}
					storeOpPatientIssueT.setQtyIssued(new BigDecimal(box.getInt("total"+i)));
					if(storeItemBatchStock.getCostPrice()!=null && !storeItemBatchStock.getCostPrice().equals("")){
						storeOpPatientIssueT.setRate(storeItemBatchStock.getCostPrice());
					}
					storeOpPatientIssueT.setOpIssueType("");
					hbt.save(storeOpPatientIssueT);
					

					if(storeItemBatchStock.getClosingStock()!= null){
						clStock = storeItemBatchStock.getClosingStock();
					}
					if(storeItemBatchStock.getIssueQty()!= null){
						issueStock = storeItemBatchStock.getIssueQty();
					}
					storeItemBatchStock.setIssueQty(issueStock.add(new BigDecimal(box.getInt("total"+i))));
					storeItemBatchStock.setClosingStock(clStock.subtract(new BigDecimal(box.getInt("total"+i))));

					hbt.update(storeItemBatchStock);
					
				}
			}
			/**
			 * End Stock
			 */
			
			
			
			
			/**
			 * For Procedures
			 */
			int procCount = box.getInt("procCount");
			int procId = 0;
			for (int l = 1; l <= procCount; l++) {
				procId = box.getInt("procedureId"+l);
				if(procId >0){
					break;
				}
			}
			if(procId > 0){
				ProcedureHeader procedureHeader = new ProcedureHeader();
				procedureHeader.setHin(patient);
				procedureHeader.setHospital(masHospital);
				procedureHeader.setStatus("c");
				if(box.getInt(MEDICAL_OFFICER_ID)!= 0){
					MasEmployee employee = new MasEmployee();
					employee.setId(box.getInt(MEDICAL_OFFICER_ID));
					procedureHeader.setMedicalOfficer(employee);
				}
				procedureHeader.setLastChgBy(user);
				procedureHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				procedureHeader.setLastChgTime(box.getString(CHANGED_TIME));
				procedureHeader.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				procedureHeader.setProcedureDate(new Date());
				procedureHeader.setDmaRegister(dmaRegisterHeader);
				hbt.save(procedureHeader);
				
				for (int j = 1; j <= procCount; j++) {
					ProcedureDetails procedureDetails = new ProcedureDetails();
					MasNursingCare nursingCare = new MasNursingCare();
					nursingCare.setId(box.getInt("procedureId"+j));
					procedureDetails.setNursingCare(nursingCare);
					procedureDetails.setProcedureHeader(procedureHeader);
					procedureDetails.setRemarks(box.getString("proremarks"+j));
					procedureDetails.setStatus("c");
					hbt.save(procedureDetails);
				}
			}
			
			/**
			 * For Injection
			 */
					
			int injCount = box.getInt("injCount");
			int injId = 0;
			for (int l = 1; l <= injCount; l++) {
				injId = box.getInt("injectionId"+l);
				if(injId >0){
					break;
				}
			}
			
			if(injId > 0){
				InjectionRegister injectionRegister = new InjectionRegister();
			//	injectionRegister.setAdverseReaction(box.getString("adverseReaction"));
			//	injectionRegister.setAllergicTesting(box.getString("allergicTesting"));
				injectionRegister.setInjectionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("injDate")));
				injectionRegister.setInjectionTime(box.getString("injtime"));
				injectionRegister.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("injDate")));
				injectionRegister.setHin(patient);
				injectionRegister.setHospital(masHospital);
				injectionRegister.setStatus("c");
				injectionRegister.setLastChgBy(user);
				if(box.getInt(MEDICAL_OFFICER_ID)!= 0){
					MasEmployee employee = new MasEmployee();
					employee.setId(box.getInt(MEDICAL_OFFICER_ID));
					injectionRegister.setMedicalOfficer(employee);
				}
				injectionRegister.setLastChgDate(new Date());
				injectionRegister.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				injectionRegister.setLastChgTime(box.getString(CHANGED_TIME));
				injectionRegister.setDmaRegister(dmaRegisterHeader);
				hbt.save(injectionRegister);
				
				for(int k=1;k<=injCount;k++){
					InjectionRegisterDetails injectionDetails = new InjectionRegisterDetails();
					injectionDetails.setDose(box.getString("dosageInj"+k));
					MasFrequency frequency = new MasFrequency();
					frequency.setId(box.getInt("injFrequencyId"+k));
					injectionDetails.setFrequency(frequency);
					injectionDetails.setRoute(box.getString("routeInj"+k));
					MasStoreItem item = new MasStoreItem();
					item.setId(box.getInt("injectionId"+k));
					injectionDetails.setItem(item);
					injectionDetails.setInjectionRegister(injectionRegister);
					injectionDetails.setAdverseReaction(box.getString("adverseReaction"));
					injectionDetails.setAllergicTesting(box.getString("allergicTesting"));
					hbt.save(injectionDetails);
				
				}
				
			}
			
			if(!box.getString("treatment").equals("")){
				PatientDetentionRegister patientDetentionRegister = new PatientDetentionRegister();
				patientDetentionRegister.setTreatment(box.getString("treatment"));
				if(!box.getString("detentionFromDate").equals(""))
					patientDetentionRegister.setDetainedFrom(HMSUtil.convertStringTypeDateToDateType(box.getString("detentionFromDate")));
				if(!box.getString("detentionToDate").equals(""))
					patientDetentionRegister.setDetainedTo(HMSUtil.convertStringTypeDateToDateType(box.getString("detentionToDate")));
				patientDetentionRegister.setFromTime(box.getString("fromTime"));
				patientDetentionRegister.setToTime(box.getString("toTime"));
				patientDetentionRegister.setLastChgBy(user);
				patientDetentionRegister.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				patientDetentionRegister.setDetentionRegisterDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				patientDetentionRegister.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
				patientDetentionRegister.setLastChgTime(box.getString(CHANGED_TIME));
				patientDetentionRegister.setHin(patient);
				patientDetentionRegister.setStatus("c");
				patientDetentionRegister.setHospital(masHospital);
				if(box.getInt(MEDICAL_OFFICER_ID)!= 0){
					MasEmployee employee = new MasEmployee();
					employee.setId(box.getInt(MEDICAL_OFFICER_ID));
					patientDetentionRegister.setMedicalOfficer(employee);
				}
				patientDetentionRegister.setDmaRegister(dmaRegisterHeader);
				hbt.save(patientDetentionRegister);
			}
			flag=true;
			tx.commit();
		}catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		map.put("flag",flag);
		return map;
	}
	/*public Map<String, Object> saveDmaRegisterDetails(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		Session session = (Session)getSession();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTimeWithoutSc");
 
		try {
			tx = session.beginTransaction();
			DmaRegisterHeader dmaRegisterHeader = new DmaRegisterHeader();
			dmaRegisterHeader.setComplaints(box.getString(COMPLAINT_DESC));
			Patient patient = new Patient();
			patient.setId(box.getInt(HIN_ID));
			dmaRegisterHeader.setHin(patient);
			Users user = new Users();
			user.setId(box.getInt("userId"));
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			dmaRegisterHeader.setHospital(masHospital);
			dmaRegisterHeader.setDMA(user);
			dmaRegisterHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			dmaRegisterHeader.setLastChgTime(box.getString(LAST_CHANGED_TIME));
			dmaRegisterHeader.setDmaRegisterDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			try {
				hbt.save(dmaRegisterHeader);
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
			
			
			*//**
			 * Saving data in Patient Prescription Details
			 *//*
			
			PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
			patientPrescriptionHeader.setHin(patient);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(box.getInt("deptId"));
			patientPrescriptionHeader.setDepartment(masDepartment);
			Visit visit = new Visit();
			visit.setId(box.getInt("visitId"));
			patientPrescriptionHeader.setVisit(visit);
			
			patientPrescriptionHeader.setHospital(masHospital);
			patientPrescriptionHeader.setStatus("p");
			patientPrescriptionHeader
					.setPrescriptionDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			patientPrescriptionHeader.setPrescriptionTime(time);
//			patientPrescriptionHeader.setEmpId(empId);
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			mapForDS.put("userName", box.getString("userName"));
			int prescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);
			patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
		
			try {
				hbt.save(patientPrescriptionHeader);
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
			
			*//**
			 * End
			 *//*
			*//**
			 * Saving Data in OPDIssueM
			 *//*
			StoreOpPatientIssueM storeOpPatientIssueM =  new StoreOpPatientIssueM();
			if(box.getInt("storeFyDocumentNoId") !=0){
			int storeFyDocumentNoId = box.getInt("storeFyDocumentNoId");
			String opdIssueno = box.getString("opdIssueno");
			
			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) hbt.load(
 					StoreFyDocumentNo.class, storeFyDocumentNoId);
 			String opdPatientIssueNoFromDB = "";
 			if(storeFyDocumentNo.getOpdIssueNo() != null)
 				opdPatientIssueNoFromDB = storeFyDocumentNo.getOpdIssueNo();
             
 			if (!opdPatientIssueNoFromDB.equals(opdIssueno))
 			{
 			    storeFyDocumentNo.setOpdIssueNo(opdIssueno);
 				hbt.update(storeFyDocumentNo);

 				
 				storeOpPatientIssueM.setDepartment(masDepartment);
 				storeOpPatientIssueM.setHospital(masHospital);
                
 				storeOpPatientIssueM.setPatientPrescriptionHeader(patientPrescriptionHeader);
 				
 				storeOpPatientIssueM.setIssueType("I");
 				storeOpPatientIssueM.setTypeOfIssue("P");
 				storeOpPatientIssueM.setHin(patient);
 				storeOpPatientIssueM.setServiceNo(box.getString(SERVICE_NO));
 				
 				storeOpPatientIssueM.setIssueNo(opdIssueno);
 				storeOpPatientIssueM.setIssueDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
 				storeOpPatientIssueM.setStatus("y");
// 				storeOpPatientIssueM.setPrescriptionNo(prescriptionNo);
 				MasEmployee masEmployee = new MasEmployee();
 				if(empId != 0){
 				masEmployee.setId(empId);
 				storeOpPatientIssueM.setEmp(masEmployee);
 				}

 				storeOpPatientIssueM.setLastChgBy(box.getString("userName"));
 				storeOpPatientIssueM.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
 				storeOpPatientIssueM.setLastChgTime(time);
 				try {
					hbt.save(storeOpPatientIssueM);
				} catch (Exception e) {
					if (tx != null)
						tx.rollback();
					e.printStackTrace();
				}
 			}
			}
 				*//**
 				 * End
 				 *//*
			int counter = box.getInt("hdb");
			for (int i = 1; i <= counter; i++) {
				
				if(box.getInt(ITEM_ID+i) != 0){
					DmaRegisterDetails dmaRegisterDetails = new DmaRegisterDetails();
					dmaRegisterDetails.setDosage(box.getString("dosage"+i));
					dmaRegisterDetails.setRemarks(box.getString("remarks"+i));
					MasFrequency frequency = new MasFrequency();
					frequency.setId(box.getInt("frequency"+i));
					dmaRegisterDetails.setFrequency(frequency);
					dmaRegisterDetails.setIssueQty(box.getInt("issueQty"+i));
					MasStoreItem item = new MasStoreItem();
					item.setId(box.getInt(ITEM_ID+i));
					dmaRegisterDetails.setItem(item);
					StoreItemBatchStock batchStock = new StoreItemBatchStock();
					batchStock.setId(box.getInt("batchId"+i));
					dmaRegisterDetails.setStock(batchStock);
					dmaRegisterDetails.setDmaRegisterHeader(dmaRegisterHeader);
					
					try {
						hbt.save(dmaRegisterDetails);
					} catch (Exception e) {
						if (tx != null)
							tx.rollback();
						e.printStackTrace();
					}
					
					*//**
					 * Saving data in Patient Prescription Details
					 *//*
					
						PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
						MasStoreItem masStoreItem = new MasStoreItem();
						masStoreItem.setId(box.getInt(ITEM_ID+i));
						patientPrescriptionDetails.setItem(masStoreItem);
						MasFrequency masFrequency = new MasFrequency();
						masFrequency.setId(box.getInt("frequency"+i));
						patientPrescriptionDetails.setFrequency(masFrequency);
						patientPrescriptionDetails.setDosage(box.getString("dosage"+i));
						patientPrescriptionDetails.setRemarks(box.getString("remarks"+i));
						patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
						patientPrescriptionDetails.setTotal(box.getInt("issueQty"+i));
						patientPrescriptionDetails.setDetailStatus("a");
						try {
							hbt.save(patientPrescriptionDetails);
						} catch (Exception e) {
							if (tx != null)
								tx.rollback();
							e.printStackTrace();
						}
					
					*//**
					 * End
					 *//*
					*//**
					 * Saving Data in patient issue
					 *//*
         				StoreOpPatientIssueT storeOpPatientIssueT = new StoreOpPatientIssueT();
         				storeOpPatientIssueT.setOpIssue(storeOpPatientIssueM);
         				storeOpPatientIssueT.setItemIdRequire(masStoreItem);
         				storeOpPatientIssueT.setItemIdIssue(masStoreItem);
         				storeOpPatientIssueT.setBatchNo(box.getString("batchNo"+i));
         				Date expiryDateToInsert=HMSUtil.convertStringTypeDateToDateType(box.getString("expDate"+i));
         				storeOpPatientIssueT.setExpiryDate(expiryDateToInsert);
         				storeOpPatientIssueT.setQtyIssued(new BigDecimal(box.getInt("issueQty"+i)));
         				if(!box.getString("costPrice"+i).equals("")){
         					storeOpPatientIssueT.setRate(new BigDecimal(box.getString("costPrice"+i)));
         				}
         				StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock)hbt.load(StoreItemBatchStock.class, box.getInt("batchId"+i));
         				BigDecimal issueStock = new BigDecimal(0);
         				BigDecimal clStock = new BigDecimal(0);
    					
    					if(storeItemBatchStock.getClosingStock()!= null){
    						clStock = storeItemBatchStock.getClosingStock();
    					}
         				if(storeItemBatchStock.getIssueQty()!= null){
    						issueStock = storeItemBatchStock.getIssueQty();
    					}
    					storeItemBatchStock.setIssueQty(issueStock.add(new BigDecimal(box.getInt("issueQty"+i))));
    					storeItemBatchStock.setClosingStock(clStock.subtract(new BigDecimal(box.getInt("issueQty"+i))));
		 				
		 				try {
							hbt.save(storeOpPatientIssueT);
							hbt.update(storeItemBatchStock);
						} catch (Exception e) {
							if (tx != null)
								tx.rollback();
							e.printStackTrace();
						}
								
								
						
				*//**
				 * 
				 *//*
					
					
				}
				
				
			}
			flag = true;
			tx.commit();
		} catch (DataAccessException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		
		map.put("flag", flag);
		return map;
	}
*/
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getHinNoForDMA(Box box) {
		Map<String, Object> map =new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Object[]> hinNoList = new ArrayList<Object[]>();
		String serviceNo = box.getString(SERVICE_NO);
		try {
			if (!serviceNo.equals("")) {
			/*	hinNoList = session.createCriteria(Visit.class).createAlias("Hin", "hin").add(
						Restrictions.eq("hin.ServiceNo", serviceNo)).add(Restrictions.eq("hin.PatientStatus","Out Patient")).add(Restrictions.eq("ReportingFor", "DMA"))
						.setProjection(Projections.projectionList().add(Projections.property("hin.Id")).add(Projections.property("hin.HinNo"))).list();
			*/
				hinNoList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo)).add(Restrictions.eq("PatientStatus","Out Patient"))
								.createAlias("Relation", "rel")				
								.setProjection(Projections.projectionList()
								.add(Projections.property("Id")).add(Projections.property("HinNo"))
								.add(Projections.property("PFirstName"))
								.add(Projections.property("PMiddleName"))
								.add(Projections.property("PLastName"))
								.add(Projections.property("rel.RelationName")))
								.list();	
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("hinNoList", hinNoList);
		return map;
	}
	public int getTransactionSequenceNoForPrescriptionNo(Map mapForDS) {
		Session session = (Session) getSession();

		String userName = (String) mapForDS.get("userName");
		List<TransactionSequence> orderNoList = new ArrayList<TransactionSequence>();
		String tableName = "PATIENT_PRESCRIPTION_HEADER";
		int currentYearInt=-1;
		int orderNo=0;
		int oldYear=-1;
		 Map<String, Object> utilMap = new HashMap<String, Object>();
         utilMap = (Map) HMSUtil.getCurrentDateAndTime();
         String date = (String) utilMap.get("currentDate");

         String currentYear = date.substring(date.lastIndexOf("/") + 1);
         currentYearInt=Integer.parseInt(currentYear);
         String currentMonth = date.substring(date.indexOf("/") + 1, date
                         .lastIndexOf("/"));
     	TransactionSequence tranSeq=new TransactionSequence();
		tranSeq.setTransactionSequenceName("PrescriptionNo");
		tranSeq.setTransactionPrefix("PRNO");
		tranSeq.setTablename(tableName);
		tranSeq.setCreatedby(userName);
		tranSeq.setStatus("y");
		tranSeq.setServiceType(null);
		tranSeq.setMonth(currentYearInt);

		try {
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
         
		try {

			Criteria crit = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("Tablename", tableName));
			orderNoList = crit.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		if(orderNoList!=null && orderNoList.size()>0)
		{
		 TransactionSequence transactionSequence = orderNoList.get(0);
		 orderNo = transactionSequence.getTransactionSequenceNumber();
		 oldYear=transactionSequence.getMonth(); 
		 if(currentYearInt>oldYear)
		 {
			    orderNo=0;
			    transactionSequence.setMonth(currentYearInt);
			    transactionSequence.setCreatedby(userName);
			    transactionSequence.setTransactionSequenceNumber(orderNo);
				hbt.update(transactionSequence);
		 }else
		 {      
			    orderNo=orderNo+1;
			    transactionSequence.setCreatedby(userName);
			    transactionSequence.setTransactionSequenceNumber(orderNo);
			    hbt.update(transactionSequence);
		 }
		}else
		{
			tranSeq.setTransactionSequenceNumber(orderNo);
			hbt.save(tranSeq);
		}
	//	tx.commit();
		} catch (Exception e) {
			//if (tx != null)
			//	tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			
		}
		return orderNo;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getHinNoForMinorSurgery(Box box) {
		Map<String, Object> map =new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Object[]> hinNoList = new ArrayList<Object[]>();
		String serviceNo = box.getString(SERVICE_NO);
	//	Date currentDate = new Date();
		try {
			if (!serviceNo.equals("")) {
				hinNoList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo)).add(Restrictions.eq("PatientStatus","Out Patient"))
						.setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("HinNo")))).list();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("hinNoList", hinNoList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPatientDetailsForMinorSurgery(Box box) {
		Map<String, Object> map =new HashMap<String, Object>();
//		List<Visit> visitList = new ArrayList<Visit>();
//		int visitId = box.getInt(VISIT_ID);
		List<Patient> patientList = new ArrayList<Patient>();
		int hinId = box.getInt(HIN_ID);
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		Session session = (Session)getSession();
//		visitList = session.createCriteria(Visit.class).add(Restrictions.idEq(visitId)).list();
		patientList =  session.createCriteria(Patient.class).add(Restrictions.idEq(hinId)).list();
		map.put("patientList", patientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> saveMinorSurgeryDetails(Box box) {
		Map<String, Object> map =new HashMap<String, Object>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		boolean flag = false;
		Transaction tx = null;
		Session session = (Session)getSession();
		try {
			tx = session.beginTransaction();
			int procCount = box.getInt("procCount");
			/*ProcedureHeader procedureHeader = new ProcedureHeader();
			Patient patient =  new Patient();
			patient.setId(box.getInt(HIN_ID));
			procedureHeader.setHin(patient);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			procedureHeader.setHospital(masHospital);
			procedureHeader.setStatus("c");
			Users user = new Users();
			user.setId(box.getInt("userId"));
			procedureHeader.setLastChgBy(user);
			procedureHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			procedureHeader.setLastChgTime(box.getString(LAST_CHANGED_TIME));
			
			hbt.save(procedureHeader);*/
			
			int procHdId = box.getInt("procHdId");
			for (int j = 1; j <= procCount; j++) {
				if(box.getInt("proDtId"+j)==0){
					ProcedureDetails procedureDetails = new ProcedureDetails();
					MasNursingCare nursingCare = new MasNursingCare();
					nursingCare.setId(box.getInt("procedureId"+j));
					procedureDetails.setNursingCare(nursingCare);
					ProcedureHeader procHeader = new ProcedureHeader();
					procHeader.setId(procHdId);
					procedureDetails.setProcedureHeader(procHeader);
					procedureDetails.setRemarks(box.getString("remraks"+j));
					procedureDetails.setStatus("c");
					hbt.save(procedureDetails);
				}else{
					if(box.getInt("checkProcedureDtId"+j)!=0){
						ProcedureDetails procedureDetails = (ProcedureDetails)hbt.load(ProcedureDetails.class, box.getInt("proDtId"+j));
						procedureDetails.setStatus("c");
						hbt.update(procedureDetails);
					}
				}
			}
			
			String pendingProc = "";
			List<ProcedureDetails> procedureDetailsList = session.createCriteria(ProcedureDetails.class).createAlias("ProcedureHeader", "ph").add(Restrictions.eq("ph.Id", procHdId)).list();
			for (ProcedureDetails procedureDetails : procedureDetailsList) {
					if(procedureDetails.getStatus().equalsIgnoreCase("p")){
						pendingProc = "yes";
						break;
					}
			}
			ProcedureHeader procedureHeader = (ProcedureHeader)hbt.load(ProcedureHeader.class, box.getInt("procHdId"));
			procedureHeader.setProcedureDate(HMSUtil.convertStringTypeDateToDateType(box.getString("prcDate")));
			procedureHeader.setProcedureTime(box.getString("prcTime"));
			if(pendingProc.equals("")){
				procedureHeader.setStatus("c");
			}
			hbt.update(procedureHeader);
			flag = true;
			tx.commit();
		} catch (DataAccessException e) {
			if(tx!= null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Visit> getVisitNoForMinorSurgery(int hinId) {
		Session session = (Session) getSession();
		List<Visit> visitList = new ArrayList<Visit>();
		try {
			visitList = session.createCriteria(Visit.class).createAlias("Hin", "p")
					.add(Restrictions.eq("p.Id", hinId)).addOrder(
							Order.desc("VisitNo")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return visitList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showECGRecordJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasEcgType> ecgTypeList = new ArrayList<MasEcgType>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		doctorList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Hospital", "h")
						.add(Restrictions.eq("h.Id", hospitalId)).createAlias("EmpCategory", "ec")
						.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor)).list();
		
		ecgTypeList = session.createCriteria(MasEcgType.class).add(Restrictions.eq("Status", "y")).list();
		
		map.put("doctorList", doctorList);
		map.put("ecgTypeList", ecgTypeList);
		
		return map;
	}

	@Override
	public Map<String, Object> saveECGRecordDetails(Box box) {
		Map<String, Object> map =new HashMap<String, Object>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		boolean flag = false;
		
		try {
			EcgRecordRegister ecgRecordRegister = new EcgRecordRegister();
			
			Patient hin =  new Patient();
			hin.setId(box.getInt(HIN_ID));
			ecgRecordRegister.setHin(hin);
			Visit visit = new Visit();
			visit.setId(box.getInt(VISIT_ID));
			ecgRecordRegister.setVisit(visit);
			MasEcgType ecgType = new MasEcgType();
			ecgType.setId(box.getInt("typeOfEcg"));
			ecgRecordRegister.setEcgType(ecgType);
			MasEmployee employee = new MasEmployee();
			employee.setId(box.getInt("validateByDoctor"));
			ecgRecordRegister.setValidateByDoctor(employee);
			ecgRecordRegister.setRemarks(box.getString(REMARKS));
			ecgRecordRegister.setEcgDate(HMSUtil.convertStringTypeDateToDateType(box.getString("ecgDate")));
			ecgRecordRegister.setEcgTime(box.getString("ecgTime"));
			Users user = new Users();
			user.setId(box.getInt("userId"));
			ecgRecordRegister.setLastChgBy(user);
			ecgRecordRegister.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			ecgRecordRegister.setLastChgTime(box.getString(LAST_CHANGED_TIME));
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			ecgRecordRegister.setHospital(masHospital);
			ecgRecordRegister.setDiagnosis(box.getString(DIAGNOSIS));
			hbt.save(ecgRecordRegister);
			flag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getInjectionListForAutoComplete(Map<String, Object> mapForDS) {
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			String str = "%" + mapForDS.get("autoHint") + "%";
			String query = "from MasStoreItem as mst where upper(mst.Nomenclature) like upper( :str )";
			Query q = session.createQuery(query);
			q.setParameter("str",str);
			q.setFirstResult(0);
			q.setMaxResults(10);
			itemList = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	@Override
	public Map<String, Object> savePatientDetentionDetails(Box box) {
		Map<String, Object> map =new HashMap<String, Object>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		boolean flag = false;
		
		try {
			PatientDetentionRegister patientDetentionRegister = (PatientDetentionRegister)hbt.load(PatientDetentionRegister.class,box.getInt("detentionId"));
			patientDetentionRegister.setDetainedFrom(HMSUtil.convertStringTypeDateToDateType(box.getString("detentionFromDate")));
			patientDetentionRegister.setDetainedTo(HMSUtil.convertStringTypeDateToDateType(box.getString("detentionToDate")));
			patientDetentionRegister.setFromTime(box.getString("fromTime"));
			patientDetentionRegister.setToTime(box.getString("toTime"));
			Users user = new Users();
			user.setId(box.getInt("userId"));
			patientDetentionRegister.setLastChgBy(user);
			patientDetentionRegister.setDetentionRegisterDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			patientDetentionRegister.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			patientDetentionRegister.setLastChgTime(box.getString(LAST_CHANGED_TIME));
			patientDetentionRegister.setStatus("c");
			hbt.update(patientDetentionRegister);
			flag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getServiceNoDetailsFromHIC(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = box.getString("hicSrNo");
		String flag = box.getString("flag");
		Connection conn = null;
		Properties properties = new Properties();
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
		ResultSet rs = null;
		ResultSet rsEmp = null;
		if(hicDbConfigure.equals("yes")) {
		try{
			if(flag.equalsIgnoreCase("true")){
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			conn = DriverManager.getConnection(hicDB, hicUser, hicPwd);
			Statement stmt = conn.createStatement();
			Statement stmtEmp = conn.createStatement();
			/**
			 * Query for SMC DB
			 */
			/*rs = stmt.executeQuery("select med.employee_dependent_name,mr.relation_name,med.date_of_birth,med.gender,med.date_of_dependency" +
					" from mas_employee_dependent med inner join mas_employee me on med.employee_id=me.employee_id " +
					" left join mas_relation mr on med.relation_id=mr.relation_id"+
					"	where me.service_no ='"+serviceNo+"' and med.status='y'");
		 
			 
			rsEmp = stmtEmp.executeQuery("select  me.first_name,me.middle_name,me.last_name,me.rank_id,me.unit_id,me.service_no"+
					" from mas_employee me " +
					"	where me.service_no ='"+serviceNo+"'");*/
			
			
			/**
			 * Query for HIC DB
			 */
			PreparedStatement prepStmt = conn.prepareStatement("select med.name,med.relation,med.dob,med.sex,med.date_of_dependency,med.age,med.occupation,med.por_no,med.income" +
					" from dependents med "+
					"	where med.serviceno = ?");
			prepStmt.setString(1, serviceNo);
			rs = prepStmt.executeQuery();
		/*	rs = stmt.executeQuery("select med.name,med.relation,med.dob,med.sex,med.date_of_dependency,med.age,med.occupation,med.por_no,med.income" +
					" from dependents med "+
					"	where med.serviceno ='"+serviceNo+"'");*/
		 
			PreparedStatement prepStmtEmp = conn.prepareStatement("select  me.first_name,me.middle_name,me.last_name,me.rank_code,me.unit_code,me.serviceno,"+
					" me.sex,me.dob,me.blood_group,me.datecommision,me.age,me.branch_code,me.SERVICENO_SUFFIX,me.religion,me.card_address,fw.marital_status,"+
					" me.identification1,me.identification2,nok.name,nok.address,nok.telephone,nok.pin"+
					" from employee me left join familywelfare fw on me.sysid=fw.employee_sysid" +
					" left join next_of_kin nok on me.sysid= nok.employee_sysid" +
					"	where me.serviceno =?");
			prepStmtEmp.setString(1, serviceNo);
			rsEmp = prepStmtEmp.executeQuery();
			/*rsEmp = stmtEmp.executeQuery("select  me.first_name,me.middle_name,me.last_name,me.rank_code,me.unit_code,me.serviceno,"+
					" me.sex,me.dob,me.blood_group,me.datecommision,me.age,me.branch_code,me.SERVICENO_SUFFIX,me.religion,me.card_address,fw.marital_status,"+
					" me.identification1,me.identification2,nok.name,nok.address,nok.telephone,nok.pin"+
					" from employee me left join familywelfare fw on me.sysid=fw.employee_sysid" +
					" left join mext_of_kin nok on me.sysid= nok.employee_sysid" +
					"	where me.serviceno ='"+serviceNo+"'");*/
			
			}else if( flag.equalsIgnoreCase("false") ){
				map.put("srStatus", "Not Authenticated.");
				
			}else{
			
				map.put("srStatus", "Please re-scan finger print.");
			}
			List<Patient> patientList = new ArrayList<Patient>();
			Session session = (Session)getSession();
			patientList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", box.getString("serviceNo")))
					.createAlias("Relation", "rel").add(Restrictions.eq("rel.RelationName", "Self")).list();
			map.put("patientList", patientList);
			
			map.put("rsEmp", rsEmp);
			map.put("rs",rs);
		}catch (Exception e) {
			map.put("srStatus", "Please re-scan finger print.");
			e.printStackTrace();
		}
		}
		return map;
	}

	@Override
	public Map<String, Object> getMedExamForHICUpdate() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasMedicalExaminationReportOnEntry> medExamList  = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Session session = (Session)getSession();
		medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("HicStatus", "n")).add(Restrictions.eq("medicalExamType", "Annual Medical Exam(AFMSF-3B)")).list();
		
		map.put("medExamList", medExamList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getProcedureForAutoComplete(Map<String, Object> map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasNursingCare> procedureList  = new ArrayList<MasNursingCare>();
		Session session = (Session)getSession();
		String str = (String)map.get("autoHint");
		String procedureType = null;
		if(map.get("procedureType")!=null)
		procedureType =  (String)map.get("procedureType");
		
		Criteria crit = session.createCriteria(MasNursingCare.class).add(Restrictions.sqlRestriction("upper(nursing_name) like upper('%"+str+"%')"))
						.add(Restrictions.eq("Status", "y"));
		if(procedureType!=null)
			crit.add(Restrictions.eq("NursingType", procedureType));
		else
			crit.add(Restrictions.eq("NursingType", "p"));
		
		procedureList = crit.list();
		dataMap.put("procedureList", procedureList);
		return dataMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPendingProcedureList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProcedureHeader> pendingProcList = new ArrayList<ProcedureHeader>();
		Session session = (Session)getSession();
		Criteria crit = null;
		
		crit = session.createCriteria(ProcedureHeader.class).add(Restrictions.eq("Status","p").ignoreCase())
						.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", box.getInt("hospitalId")));
		
		if(!box.getString(FROM_DATE).equals("") && !box.getString(TO_DATE).equals("")){
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE));
			Date toDate = HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE));
			crit  = crit.add(Restrictions.between("RequisitionDate", fromDate, toDate));
		}
		if(!box.getString(SERVICE_NO).equals("")){
			crit  = crit.createAlias("Hin", "hin").add(Restrictions.eq("hin.ServiceNo",box.getString(SERVICE_NO)));
		}
		if(box.getInt(MEDICAL_OFFICER)!=0){
			crit  = crit.createAlias("MedicalOfficer", "mo").add(Restrictions.eq("mo.Id",box.getInt(MEDICAL_OFFICER)));
		}
		if(box.getInt("procedure")!=0){
			crit  = crit.createAlias("ProcedureDetails", "p").add(Restrictions.eq("p.Status","p").ignoreCase()).createAlias("p.NursingCare", "mnc").add(Restrictions.eq("mnc.Id",box.getInt("procedure")));
		}
		pendingProcList = crit.list();
		map = getDetailsForProcWaitList(box.getInt("hospitalId"));
		map.put("pendingProcList", pendingProcList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getDetailsForProcWaitList(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<MasNursingCare> procedureList = new ArrayList<MasNursingCare>();
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
		doctorList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Hospital", "h")
						.add(Restrictions.eq("h.Id", hospitalId)).createAlias("EmpCategory", "ec")
						.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor)).addOrder(Order.asc("FirstName")).list();
		procedureList = session.createCriteria(MasNursingCare.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("NursingType", "p").ignoreCase()).addOrder(Order.asc("NursingName")).list();
		
		List<ProcedureHeader> pendingProcList = new ArrayList<ProcedureHeader>();
		Date fromDate = new Date();
		Date toDate =  new Date();
		
		pendingProcList = session.createCriteria(ProcedureHeader.class).add(Restrictions.eq("Status","p").ignoreCase())
						.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).add(Restrictions.between("RequisitionDate", fromDate, toDate)).list();
		map.put("doctorList", doctorList);
		map.put("procedureList", procedureList);
		map.put("pendingProcList", pendingProcList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPendingProcedureDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProcedureDetails> procDtList = new ArrayList<ProcedureDetails>();
		Session session = (Session)getSession();
		Criteria crit = null;
		
		crit = session.createCriteria(ProcedureDetails.class).add(Restrictions.eq("Status", "p").ignoreCase())
					.createAlias("ProcedureHeader", "ph").add(Restrictions.eq("ph.Id", box.getInt("procHeaderId")));
		if(box.getInt("procedureId")!= 0){
			crit = crit.createAlias("NursingCare", "mnc").add(Restrictions.eq("mnc.Id",box.getInt("procedureId")));
		}
		procDtList = crit.list();
		map = getDetailsForProcWaitList(box.getInt("hospitalId"));
		map.put("procDtList", procDtList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showMHReferralRegisterReportJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		doctorList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Hospital", "h")
						.add(Restrictions.eq("h.Id", hospitalId)).createAlias("EmpCategory", "ec")
						.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor)).addOrder(Order.asc("FirstName")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		
		map.put("doctorList", doctorList);
		map.put("rankList", rankList);
		
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showAmbulanceRegisterReportJsp(int hospitalId) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<Object[]> unitList = null;
		List<MasTrade> tradeList = null;
		
		tradeList =session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		unitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).createAlias("Station", "station",CriteriaSpecification.LEFT_JOIN).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))
						.add(Projections.property("station.StationName")).add(Projections.property("HicCode"))).addOrder(
				Order.asc("UnitName")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		
		map.put("tradeList", tradeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getDoctorList(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
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
		doctorList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Hospital", "h")
						.add(Restrictions.eq("h.Id", hospitalId)).createAlias("EmpCategory", "ec")
						.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor)).addOrder(Order.asc("FirstName")).list();
		map.put("doctorList", doctorList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPendingDetentionList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PatientDetentionRegister> pendingDetentionList = new ArrayList<PatientDetentionRegister>();
		Session session = (Session)getSession();
		Criteria crit = null;
		
		crit = session.createCriteria(PatientDetentionRegister.class).add(Restrictions.eq("Status","p").ignoreCase())
						.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", box.getInt("hospitalId")));
		
		if(!box.getString(FROM_DATE).equals("") && !box.getString(TO_DATE).equals("")){
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE));
			Date toDate = HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE));
			crit  = crit.add(Restrictions.between("RequisitionDate", fromDate, toDate));
		}else {
			crit  = crit.add(Restrictions.eq("RequisitionDate", new Date()));
		}
		if(!box.getString(SERVICE_NO).equals("")){
			crit  = crit.createAlias("Hin", "hin").add(Restrictions.eq("hin.ServiceNo",box.getString(SERVICE_NO)));
		}
		if(box.getInt(MEDICAL_OFFICER)!=0){
			crit  = crit.createAlias("MedicalOfficer", "mo").add(Restrictions.eq("mo.Id",box.getInt(MEDICAL_OFFICER)));
		}
	
		pendingDetentionList = crit.list();
		map = getDoctorList(box.getInt("hospitalId"));
		map.put("pendingDetentionList", pendingDetentionList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPendingDetentionDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PatientDetentionRegister> detentionList = new ArrayList<PatientDetentionRegister>();
		Session session = (Session)getSession();
		Criteria crit = null;
		int visitId = box.getInt("visitId");
		crit = session.createCriteria(PatientDetentionRegister.class).add(Restrictions.eq("Status", "p").ignoreCase())
					.add(Restrictions.eq("Id", box.getInt("detentionId")));
		detentionList = crit.list();
		
		List<PatientInvestigationDetails> investigationList = new ArrayList<PatientInvestigationDetails>();
		investigationList = session.createCriteria(PatientInvestigationDetails.class).createAlias("InvestigationHeader", "ih").createAlias("ih.Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
		
		List<PatientPrescriptionDetails> prescriptionList = new ArrayList<PatientPrescriptionDetails>();
		prescriptionList = session.createCriteria(PatientPrescriptionDetails.class).createAlias("Prescription", "p").createAlias("p.Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
		
		List<ProcedureDetails> procedureList = new ArrayList<ProcedureDetails>();
		procedureList = session.createCriteria(ProcedureDetails.class).createAlias("ProcedureHeader", "p").createAlias("p.Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
		
		map = getDetailsForProcWaitList(box.getInt("hospitalId"));
		map.put("prescriptionList", prescriptionList);
		map.put("investigationList", investigationList);
		map.put("detentionList", detentionList);
		map.put("procedureList", procedureList);
		return map;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getDetailsForReport(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList = null;
		List<MasRank> rankList = null;
		List<MasDepartment> departmentList = null;
		List<Object[]> unitList = null;
		List<MasMaritalStatus> maritalStatusList = null;
		List<MasDivision> divisionList = null;
		List<MasEmployee> employeeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasSection> sectionList = null;
		List<MasDisposal> disposalList = null;
		//List<MasRelation> relationList= null;
		List<Object[]> relationList = new ArrayList<Object[]>();
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
		
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("Id")).list();
		
		
		String departmentTypeCode = null;


		try {
			properties.load(resourcePath.openStream());
			
			departmentTypeCode = properties.getProperty("departmentTypeCodeForOpd");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		departmentList = session.createCriteria(MasDepartment.class)
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.eq("dt.DepartmentTypeCode",departmentTypeCode))
				.add(Restrictions.eq("Status", "y"))
				.addOrder(Order.asc("DepartmentName")).list();
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y"))
						.createAlias("Station", "station",CriteriaSpecification.LEFT_JOIN).setProjection(Projections.projectionList()
						.add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(Order.asc("UnitName")).list();
		maritalStatusList = session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("MaritalStatusName")).list();
		divisionList = session.createCriteria(MasDivision.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DivisionName")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.createAlias("EmpCategory", "ec")
						.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
					.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("SectionName")).list();
		disposalList = session.createCriteria(MasDisposal.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DisposalName")).list();
		//relationList = session.createCriteria(MasRelation.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RelationName")).list()	;
		relationList = session.createCriteria(MasRelation.class)
				.setProjection(Projections.projectionList().add(Projections.groupProperty("RelationCode")).add(Projections.groupProperty("RelationName"))).list();
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("rankList", rankList);
		map.put("divisionList", divisionList);
		map.put("unitList", unitList);
		map.put("maritalStatusList", maritalStatusList);
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		map.put("sexList", sexList);
		map.put("sectionList", sectionList);
		map.put("disposalList", disposalList);
		map.put("relationList", relationList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getOPDRegisterData(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<Object[]> opdRegisterList = new ArrayList<Object[]>();
		String qryStr = "";
		/*if(box.getInt(SERVICE_TYPE_ID)!=0){
			qryStr += " and patient.service_type_id =:serviceType";
		}
		if(box.getInt(SERVICE_STATUS_ID)!=0){
			qryStr += " and patient.service_status_id =:serviceStatus";
		}
		if(box.getInt("fromRankId")!=0 && box.getInt("toRankId")!=0){
			qryStr += " and patient.rank_id between :fromRank and :toRank";
		}*/
		if(box.getInt(DEPARTMENT_ID)!=0){
			qryStr += " and dep.department_id =:depId";
		}
		if(box.getInt("divisionId")!=0){
			qryStr += " and di.division_id =:dId";
		}
	/*	if(box.getInt(UNIT_ID)!=0){
			qryStr += " and patient.unit_id =:unit";
		}
		if(box.getInt(SECTION_ID)!=0){
			qryStr += " and patient.section_id =:section";
		}
		if(box.getInt(MARITAL_STATUS_ID)!=0){
			qryStr += " and patient.marital_status_id = :mrStatus";
		}*/
		if(box.getInt(SEX_ID)!=0){
			qryStr += " and patient.sex_id = :sex";
		}
		if (!(box.getString(RELATION_ID).equals(""))) {
			qryStr += " and mas_relation.relation_code = :relation";
		}
		if (!(box.getString(SERVICE_NO).equals(""))) {
			qryStr += " and patient.service_no=:srNo";
		}
		if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
			qryStr +=" and substr(patient.age,0,INSTR(patient.age,' ')) >=:fromAge " +
					" and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))=:fromAgeUnit" +
					" and substr(patient.age,0,INSTR(patient.age,' ')) <=:toAge " +
					" and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))=:toAgeUnit";
			
		}
		/*if (!(box.getString("fromServ").equals("")) && !(box.getString("fromServUnit").equals(""))
				&& !(box.getString("toServ").equals("")) && !(box.getString("toServUnit").equals(""))) {
			qryStr +=" and patient.service_years >=:fromServ " +
					" and  total_service_period=:fromServUnit" +
					" and patient.service_years <=:toServ" +
					" and  total_service_period=:toServUnit";
		}*/
		if(box.getInt(CONSULTING_DOCTOR)!=0){
			qryStr += " and visit.doctor_id =:doctor";
		}
		if ( !(box.getString("icd").equals(""))) {
			String icd = box.getString("icd");
			 int index1=icd.lastIndexOf("[");
			  int index2=icd.lastIndexOf("]");
			   index1++;
			//   String icdCode =""+icd.substring(index1, index2);
//			   qryStr += " and icd.icd_code='"+icdCode+"'";
			   int icdCode =Integer.parseInt(""+icd.substring(index1, index2));
			   qryStr += " and icd.icd_id="+icdCode+"";
		}
		/*if (!(box.getString("icdNo").equals(""))) {
			qryStr += " and icd.icd_code= :icdCode ";
		}*/
		if ((box.getInt("icdId")!=0)) {
			qryStr += " and icd.icd_id=:icdCode";
		}
	/*	if(!(box.getString("disposal").equals(""))){
			qryStr += " and opd.disposal = :disposal";
		}
		*/
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String qry = "";
		qry = "SELECT visit_date,patient.service_no AS patient_service_no," +
		" (patient.p_first_name + ' ' + COALESCE(patient.p_middle_name,'') + ' ' + COALESCE(patient.p_last_name,''))AS patientName," +
		"  mas_relation.relation_name AS mas_relation_relation_name," +
		" mas_rank.rank_name AS mas_rank_rank_name,"+
		" (patient.s_first_name + ' ' + COALESCE(patient.s_middle_name,'')  + ' ' + COALESCE(patient.s_last_name,''))AS servicePersonName," +
		/*"  mas_unit.unit_name as unit_name," +*/
		" CASE WHEN charindex('NOT AVAILABLE IN ICD',icd.icd_name) = 0  THEN icd.icd_name ELSE isnull(opd.initial_diagnosis,'')  END as diagnosis,"+
		 "dep.department_name as dep_name,"+ 
		"di.division_name as division_name," +
		" (mas_employee.first_name+ ' ' + mas_employee.middle_name + ' ' + mas_employee.last_name)AS doctorName," +
		/*" (case when (COALESCE(opd.disposal,0) !='0' ) then (opd.disposal) else ' ' end) as disposal," +*/
		"  (case when (COALESCE(opd.days,0)!=0) then (opd.days + ' days') else ' '  end) as days," +
		" hospital.hospital_name as hospital_name,visit.visit_id" +
		" FROM " +
		" patient patient right JOIN visit visit ON patient.hin_id = visit.hin_id" +
		" LEFT OUTER JOIN mas_rank mas_rank ON patient.rank_id = mas_rank.rank_id" +
		/*" LEFT OUTER JOIN mas_unit mas_unit ON patient.unit_id = mas_unit.unit_id " +*/
		" LEFT OUTER JOIN mas_relation mas_relation ON patient.relation_id = mas_relation.relation_id" +
		" left outer join mas_hospital hospital on patient.hospital_id=hospital.hospital_id" +
		" left outer join mas_employee mas_employee on visit.doctor_id=mas_employee.employee_id" +
		" LEFT OUTER JOIN mas_rank emp_mas_rank ON mas_employee.rank_id = emp_mas_rank.rank_id"+
		" left outer join opd_patient_details opd on visit.visit_id=opd.visit_id" +
		" left outer join mas_department dep on dep.department_id=visit.department_id"+
		" left outer join mas_employee mas_emp on patient.employee_id=mas_emp.employee_id" +
		" left outer join mas_division di on di.division_id=mas_emp.division_id"+
		" left outer join discharge_icd_code dic on visit.visit_id=dic.visit_id" +
		" left outer join mas_icd icd on dic.icd_id=icd.icd_id"+
		" where visit.visit_date between :fromDate and :toDate " +
		" and  dic.visit_id is not null" +
		" and visit.hospital_id= :hospitalId and reporting_for in ('OPD','FollowUp') " +qryStr;
		/*" order by visit.visit_date asc"*/
		SQLQuery sqlQry = session.createSQLQuery(qry);
		sqlQry.setParameter("fromDate", sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE))));
		sqlQry.setParameter("toDate", sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE))));
		sqlQry.setParameter("hospitalId",box.getInt("hospitalId"));
		/*if(box.getInt(SERVICE_TYPE_ID)!=0){
			sqlQry.setParameter("serviceType", box.getInt(SERVICE_TYPE_ID));
		}
		if(box.getInt(SERVICE_STATUS_ID)!=0){
			sqlQry.setParameter("serviceStatus", box.getInt(SERVICE_STATUS_ID));
		}*/
	/*	if(box.getInt("fromRankId")!=0 && box.getInt("toRankId")!=0){
			sqlQry.setParameter("fromRank", box.getInt("fromRankId"));
			sqlQry.setParameter("toRank", box.getInt("toRankId"));
		}*/
		if(box.getInt(DEPARTMENT_ID)!=0){
			sqlQry.setParameter("depId", box.getInt(DEPARTMENT_ID));
		}
		if(box.getInt("divisionId")!=0){
			sqlQry.setParameter("dId", box.getInt("divisionId"));
		}
		/*if(box.getInt(UNIT_ID)!=0){
			sqlQry.setParameter("unit", box.getInt(UNIT_ID));
		}
		if(box.getInt(SECTION_ID)!=0){
			sqlQry.setParameter("section", box.getInt(SECTION_ID));
		}
		if(box.getInt(MARITAL_STATUS_ID)!=0){
			sqlQry.setParameter("mrStatus", box.getInt(MARITAL_STATUS_ID));
		}*/
		if(box.getInt(SEX_ID)!=0){
			sqlQry.setParameter("sex", box.getInt(SEX_ID));
		}
		if (!(box.getString(RELATION_ID).equals(""))) {
			sqlQry.setParameter("relation", box.getString(RELATION_ID));
		}
		if (!(box.getString(SERVICE_NO).equals(""))) {
			sqlQry.setParameter("srNo", box.getString(SERVICE_NO));
		}
		if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
			sqlQry.setParameter("fromAge", box.getInt("fromAge"));
			sqlQry.setParameter("fromAgeUnit", box.getString("fromAgeUnit"));
			sqlQry.setParameter("toAge", box.getInt("toAge"));
			sqlQry.setParameter("toAgeUnit", box.getString("toAgeUnit"));
		}
		/*if (!(box.getString("fromServ").equals("")) && !(box.getString("fromServUnit").equals(""))
				&& !(box.getString("toServ").equals("")) && !(box.getString("toServUnit").equals(""))) {
			sqlQry.setParameter("fromServ", box.getInt("fromServ"));
			sqlQry.setParameter("fromServUnit", box.getString("fromServUnit"));
			sqlQry.setParameter("toServ", box.getInt("toServ"));
			sqlQry.setParameter("toServUnit", box.getString("toServUnit"));
			
		}*/
		if(box.getInt(CONSULTING_DOCTOR)!=0){
			sqlQry.setParameter("doctor", box.getInt(CONSULTING_DOCTOR));
		}
		
		if ((box.getInt("icdId")!=0)) {
			sqlQry.setParameter("icdCode",box.getInt("icdId"));
		}
		
/*		if (!(box.getString("disposal").equals(""))) {
			sqlQry.setParameter("disposal", box.getString("disposal"));
		}*/
		
		
		
		
		opdRegisterList = sqlQry.list();
			
		map.put("opdRegisterList", opdRegisterList);
		
		return map;
	}

	@Override
	public Map<String, Object> showOPDStatisticsGraph(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<Object[]> opdRegisterList = new ArrayList<Object[]>();
		String qryStr = "";
		String subqryStr = "";
		if(box.getInt(SERVICE_TYPE_ID)!=0){
			qryStr += " and patient.service_type_id = :serviceType";
			subqryStr += " and p.service_type_id = :serviceType";
		}
		if(box.getInt(SERVICE_STATUS_ID)!=0){
			qryStr += " and patient.service_status_id = :serviceStatus";
			subqryStr += " and p.service_status_id = :serviceStatus";
		}
		if(box.getInt("fromRankId")!=0 && box.getInt("toRankId")!=0){
			qryStr += " and patient.rank_id between  :fromRank and :toRank";
			subqryStr += " and p.rank_id between  :fromRank and :toRank";
		}
		if(box.getInt(RANK_CATEGORY_ID)!=0){
			qryStr += " and mas_rank.rank_category_id =:rankCat";
			subqryStr += " and mr.rank_category_id = :rankCat";
		}
		if(box.getInt(TRADE_ID)!=0){
			qryStr += " and patient.trade_id = :trade";
			subqryStr += " and p.trade_id = :trade";
		}
		if(box.getInt(UNIT_ID)!=0){
			qryStr += " and patient.unit_id =:unit";
			subqryStr += " and p.unit_id = :unit";
		}
		if(box.getInt(SECTION_ID)!=0){
			qryStr += " and patient.section_id = :section";
			subqryStr += " and p.section_id =:section";
		}
		if(box.getInt(MARITAL_STATUS_ID)!=0){
			qryStr += " and patient.marital_status_id = :mrStatus";
			subqryStr += " and p.marital_status_id = :mrStatus";
		}
		if(box.getInt(SEX_ID)!=0){
			qryStr += " and patient.sex_id = :sex";
			subqryStr += " and p.sex_id =:sex";
		}
		if(box.getInt(RELATION_ID)!=0){
			qryStr += " and patient.relation_id = :relation";
			subqryStr += " and p.relation_id = :relation";
		}
		if (!(box.getString(SERVICE_NO).equals(""))) {
			qryStr += " and patient.service_no=:srNo";
			subqryStr += " and p.service_no=:srNo";
		}
		if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
		
			qryStr +=" and substr(patient.age,0,INSTR(patient.age,' ')) >=:fromDate" +
					" and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))=:fromAgeUnit" +
					" and substr(patient.age,0,INSTR(patient.age,' ')) <=:toAge" +
					" and  substr(patient.age,INSTR(patient.age,' ')+1,length(patient.age))=:toAgeUnit";
			subqryStr +=" and substr(p.age,0,INSTR(p.age,' ')) >=:fromDate" +
			" and  substr(p.age,INSTR(p.age,' ')+1,length(p.age))=:fromAgeUnit" +
			" and substr(p.age,0,INSTR(p.age,' ')) <=:toAge " +
			" and  substr(p.age,INSTR(p.age,' ')+1,length(p.age))=:toAgeUnit";
		}
		if (!(box.getString("fromServ").equals("")) && !(box.getString("fromServUnit").equals(""))
				&& !(box.getString("toServ").equals("")) && !(box.getString("toServUnit").equals(""))) {
			qryStr +=" and patient.service_years >=:fromServ " +
					" and  total_service_period=:fromServUnit" +
					" and patient.service_years <=:toServ" +
					" and  total_service_period=:toServUnit";
			
			subqryStr +=" and p.service_years >=:fromServ  " +
			" and  total_service_period=:fromServUnit" +
			" and p.service_years <=:toServ" +
			" and  total_service_period=:toServUnit";
			
		}
		if(box.getInt(CONSULTING_DOCTOR)!=0){
			qryStr += " and visit.doctor_id = :doctor";
			subqryStr += " and v.doctor_id =  :doctor";
		}
		if ( !(box.getString("icd").equals(""))) {
			String icd = box.getString("icd");
			 int index1=icd.lastIndexOf("[");
			  int index2=icd.lastIndexOf("]");
			   index1++;
			/*   String icdCode =""+icd.substring(index1, index2);
			qryStr += " and icd.icd_code='"+icdCode+"'";
			subqryStr += " and i.icd_code='"+icdCode+"'";*/
			   int icdCode =Integer.parseInt(""+icd.substring(index1, index2));
				qryStr += " and icd.icd_id="+icdCode+"";
				subqryStr += " and i.icd_id="+icdCode+"";
		}
		/*if (!(box.getString("icdNo").equals(""))) {
			qryStr += " and icd.icd_code=:icdCode";
			subqryStr += " and i.icd_code=:icdCode";
		}*/
		if ((box.getInt("icdId")!=0)) {
			qryStr += " and icd.icd_id=:icdCode";
			subqryStr += " and i.icd_id=:icdCode";
		}
		if(!(box.getString("disposal").equals(""))){
			qryStr += " and opd.disposal = :disposal";
			subqryStr += " and o.disposal = :disposal";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String qry = "";
	//	String fromDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		//String toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		qry = "SELECT distinct visit.visit_date as visit_date," +
		"(select count(distinct v.visit_id) from visit v left join patient p on v.hin_id=p.hin_id  " +
		" left join mas_rank mr on p.rank_id=mr.rank_id " +
		" left outer join discharge_icd_code d on v.visit_id=d.visit_id" +
		" left outer join mas_icd i on d.icd_id=i.icd_id"+
		" left outer join opd_patient_details o on v.visit_id=o.visit_id" +
		" where visit_date between :fromDate and :toDate " +
		" and visit_date=visit.visit_date and p.service_type_id=1 " +
		" and v.hospital_id=:hospitalId  and reporting_for in ('OPD','FollowUp') " +subqryStr+
		" group by visit_date ) as army," +
		"(select count(distinct v.visit_id)  from visit v left join patient p on v.hin_id=p.hin_id " +
		" left join mas_rank mr on p.rank_id=mr.rank_id " +
		" left outer join discharge_icd_code d on v.visit_id=d.visit_id" +
		" left outer join mas_icd i on d.icd_id=i.icd_id"+
		" left outer join opd_patient_details o on v.visit_id=o.visit_id" +
		" where visit_date between  :fromDate and :toDate  " +
		" and visit_date=visit.visit_date and p.service_type_id=2 " +
		" and v.hospital_id=:hospitalId  and reporting_for in ('OPD','FollowUp') " +subqryStr+
		" group by visit_date ) as airforce," +
		"(select count(distinct v.visit_id)  from visit v left join patient p on v.hin_id=p.hin_id " +
		" left join mas_rank mr on p.rank_id=mr.rank_id " +
		" left outer join discharge_icd_code d on v.visit_id=d.visit_id" +
		" left outer join mas_icd i on d.icd_id=i.icd_id"+
		" left outer join opd_patient_details o on v.visit_id=o.visit_id" +
		" where visit_date between  :fromDate and :toDate  " +
		" and visit_date=visit.visit_date and p.service_type_id=4 " +
		" and v.hospital_id=:hospitalId  and reporting_for in ('OPD','FollowUp') " +subqryStr+
		" group by visit_date ) as coastguard," +
		"(select count(distinct v.visit_id)  from visit v left join patient p on v.hin_id=p.hin_id " +
		" left join mas_rank mr on p.rank_id=mr.rank_id " +
		" left outer join discharge_icd_code d on v.visit_id=d.visit_id" +
		" left outer join mas_icd i on d.icd_id=i.icd_id"+
		" left outer join opd_patient_details o on v.visit_id=o.visit_id" +
		" where visit_date between  :fromDate and :toDate  " +
		" and visit_date=visit.visit_date and p.service_type_id=7 " +
		" and v.hospital_id=:hospitalId  and reporting_for in ('OPD','FollowUp') " +subqryStr+
		" group by visit_date ) as NE, " +
		"(select count(distinct v.visit_id)  from visit v left join patient p on v.hin_id=p.hin_id " +
		" left join mas_rank mr on p.rank_id=mr.rank_id " +
		" left outer join discharge_icd_code d on v.visit_id=d.visit_id" +
		" left outer join mas_icd i on d.icd_id=i.icd_id"+
		" left outer join opd_patient_details o on v.visit_id=o.visit_id" +
		" where visit_date between  :fromDate and :toDate  " +
		" and visit_date=visit.visit_date and p.service_type_id=41 " +
		" and v.hospital_id=:hospitalId  and reporting_for in ('OPD','FollowUp') " +subqryStr+
		" group by visit_date ) as oth " +
		" FROM " +
		" patient patient right JOIN visit visit ON patient.hin_id = visit.hin_id" +
		" LEFT OUTER JOIN mas_service_type st ON patient.service_type_id = st.service_type_id" +
		" left join mas_rank mas_rank on patient.rank_id=mas_rank.rank_id " +
		" left outer join opd_patient_details opd on visit.visit_id=opd.visit_id" +
		" left outer join discharge_icd_code dic on visit.visit_id=dic.visit_id" +
		" left outer join mas_icd icd on dic.icd_id=icd.icd_id"+
		" where visit.visit_date between  :fromDate and :toDate  " +
		" and visit.hospital_id=:hospitalId  and reporting_for in ('OPD','FollowUp') " +qryStr+
		" order by visit.visit_date asc";
		
		
		SQLQuery sqlQry = session.createSQLQuery(qry);
		sqlQry.setParameter("fromDate", sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE))));
		sqlQry.setParameter("toDate", sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE))));
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
		if(box.getInt(RELATION_ID)!=0){
			sqlQry.setParameter("relation", box.getInt(RELATION_ID));
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
		
		if (!(box.getString("disposal").equals(""))) {
			sqlQry.setString("disposal", box.getString("disposal"));
		}
		
		opdRegisterList = sqlQry.list();
		map.put("opdRegisterList", opdRegisterList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPrintAircraftEmergencyRegisterReport(
			Box box) {	
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<AirCraftEmergencyDt> airCraftEmergencyList = new ArrayList<AirCraftEmergencyDt>();
		Criteria crit = null;
		crit = session.createCriteria(AirCraftEmergencyDt.class)
				.createAlias("AirCraftEmergency", "AFM").add(Restrictions.eq("AFM.Hospital.Id", box.getInt("hospitalId")))
			.add(Restrictions.between("AFM.CallRcdDate", HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)), HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE))));
		if(!box.getString(CALL_RCD_TIME ).equals("")){
			crit=crit.add(Restrictions.eq("AFM.CallRcdTime", box.getString(CALL_RCD_TIME )));
		}
		
		if(!box.getString(SOURCE_FROM ).equals("")){
			crit=crit.add(Restrictions.eq("AFM.SourceFrom", box.getString(SOURCE_FROM )));
		}
		if(box.getInt(AIRCRAFT_TYPE_ID)!=0){
			crit=crit.createAlias("AFM.TypeOfAircraft", "toa",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("toa.Id", box.getInt(AIRCRAFT_TYPE_ID )));	
		}
		if(!box.getString(EMERGENCY_TYPE).equals("")){
			crit=crit.add(Restrictions.eq("AFM.EmergencyType", box.getString(EMERGENCY_TYPE )));
		}
		if(!box.getString(LOCATION ).equals("")){
			crit=crit.add(Restrictions.eq("AFM.Location", box.getString(LOCATION )));
		}
		if(box.getInt(UNIT_ID )!=0){
			crit=crit.createAlias("AFM.Unit", "unit",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("unit.Id",(box.getInt(UNIT_ID ))));
		}
		if(box.getInt(MEDICAL_OFFICER_ID )!=0){
			crit=crit.createAlias("AFM.MedicalOfficer", "mo",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("mo.Id",(box.getInt(MEDICAL_OFFICER_ID ))));
		}
		
		crit.addOrder(Order.desc("AFM.Id"));
		airCraftEmergencyList=crit.list();
		map.put("airCraftEmergencyList", airCraftEmergencyList);
		return map;
		}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showOtherEmeregencyReportOnScreen(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<EmergencyPerforma> emergencyPerformaList = new ArrayList<EmergencyPerforma>();
		Criteria crit = null;
		crit = session.createCriteria(EmergencyPerforma.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).add(Restrictions.between("CallRcdDate", HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)), HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE))));
		if(!box.getString(CALL_RCD_TIME ).equals("")){
			crit=crit.add(Restrictions.eq("CallRcdTime", box.getString(CALL_RCD_TIME )));
		}
		
		if(!box.getString(SOURCE_FROM ).equals("")){
			crit=crit.add(Restrictions.eq("SourceFrom", box.getString(SOURCE_FROM )));
		}
		
		if(!box.getString(EMERGENCY_TYPE ).equals("")){
			crit=crit.add(Restrictions.eq("EmergencyType", box.getString(EMERGENCY_TYPE )));
		}
		if(!box.getString(LOCATION ).equals("")){
			crit=crit.add(Restrictions.eq("Location", box.getString(LOCATION )));
		}
		if(box.getInt(MEDICAL_OFFICER_ID )!=0){
			crit=crit.createAlias("MedicalOfficer", "mo",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("mo.Id",(box.getInt(MEDICAL_OFFICER_ID ))));
		}
		
		emergencyPerformaList=crit.list();
		map.put("emergencyPerformaList", emergencyPerformaList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPrintMHReferralRegisterReport(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MhReferral> mhReferralList = new ArrayList<MhReferral>();
		Criteria crit = null;
		crit=session.createCriteria(MhReferral.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).add(Restrictions.between("RunDate", HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)), HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE))));
		if(!box.getString(REFERRAL_DATE).equals("")){
			crit=crit.add(Restrictions.eq("ReferralDate",HMSUtil.convertStringTypeDateToDateType(box.getString(REFERRAL_DATE))));	
		}
		if(!box.getString(REFER_TO).equals("")){
			crit=crit.add(Restrictions.eq("ReferTo",box.getString(REFER_TO)));	
		}
		if(box.getInt(RANK_ID)!=0){
			crit=crit.createAlias("Rank", "r",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("r.Id",box.getInt(RANK_ID)));	
		}
		if(box.getInt(REFERRED_BY)!=0){
			crit=crit.createAlias("ReferredBy", "rb",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("rb.Id",box.getInt(REFERRED_BY)));	
		}
		
		mhReferralList=crit.list();
		map.put("mhReferralList", mhReferralList);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPrintAmbulanceRegisterReport(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<AmbulanceRunRegister> ambulanceRunRegisterList = new ArrayList<AmbulanceRunRegister>();
		Criteria crit = null;
		crit=session.createCriteria(AmbulanceRunRegister.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).add(Restrictions.between("AmbulanceRunDate", HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)), HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE))));
		if(!box.getString("fromTime").equals("") && !box.getString("toTime").equals("")){
			crit=crit.add(Restrictions.between("AmbulanceRunTime",box.getString("fromTime"),box.getString("toTime")));	
		}
		if(box.getInt(UNIT_ID)!=0){
			crit=crit.createAlias("Unit", "unit",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("unit.Id",box.getInt(UNIT_ID)));	
		}	
		
		if(box.getInt(RANK_ID)!=0){
			crit=crit.createAlias("Rank", "rank",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("rank.Id",box.getInt(RANK_ID)));	
		}
		if(box.getInt(TRADE_ID)!=0){
			crit=crit.createAlias("Hin", "hin",CriteriaSpecification.LEFT_JOIN).createAlias("hin.Trade", "trade",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("trade.Id",box.getInt(TRADE_ID)));	
		}
		
		ambulanceRunRegisterList=crit.list();
		map.put("ambulanceRunRegisterList", ambulanceRunRegisterList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPrintProcedureRegisterReport(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<ProcedureHeader> procedureDetailsList = new ArrayList<ProcedureHeader>();
		Criteria crit = null;
		crit=session.createCriteria(ProcedureHeader.class).createAlias("Hin", "hin", CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
		.add(Restrictions.between("ProcedureDate", HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)), HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE))));
		if(box.getInt(RANK_ID)!=0){
			crit=crit.createAlias("hin.Rank", "r",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("r.Id",box.getInt(RANK_ID)));	
		}
		if(box.getInt(UNIT_ID)!=0){
			crit=crit.createAlias("hin.Unit", "u",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("u.Id",box.getInt(UNIT_ID)));	
		}
		if(box.getInt(TRADE_ID)!=0){
			crit=crit.createAlias("hin.Trade", "t",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("t.Id",box.getInt(TRADE_ID)));
		}
		if(box.getInt(MEDICAL_OFFICER_ID)!=0){
			crit = crit.createAlias("MedicalOfficer", "mo",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("mo.Id",box.getInt(MEDICAL_OFFICER_ID)));
		}
		if(box.getInt("procedure")!=0 ){
			crit = crit.createAlias("ProcedureDetails", "pd").createAlias("pd.NursingCare","nc",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("nc.Id",box.getInt("procedure")));
		}
		if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
			String fromAge = box.getString("fromAge");
			String toAge = box.getString("toAge");
			String qryStr =" substr(age,0,INSTR(age,' ')) >="+fromAge+" " +
			" and  substr(age,INSTR(age,' ')+1,length(age))='"+box.getString("fromAgeUnit")+"'" +
			" and substr(age,0,INSTR(age,' ')) <="+toAge+" " +
			" and  substr(age,INSTR(age,' ')+1,length(age))='"+box.getString("toAgeUnit")+"'";
			crit = crit.add(Restrictions.sqlRestriction(qryStr));
		}
		procedureDetailsList=crit.list();
		map.put("procedureDetailsList", procedureDetailsList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showprintDetentionRegisterReport(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<PatientDetentionRegister> patientDetentionRegisterList = new ArrayList<PatientDetentionRegister>();
		Criteria crit = null;
		crit=session.createCriteria(PatientDetentionRegister.class).createAlias("Hin", "h",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
		.add(Restrictions.between("DetentionRegisterDate", HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)), HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE))));
	
		if(box.getInt(UNIT_ID)!=0){
			crit=crit.createAlias("h.Unit", "u",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("u.Id",box.getInt(UNIT_ID)));	
		}
		
		if(box.getInt(RANK_ID)!=0){
			crit=crit.createAlias("h.Rank", "r",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("r.Id",box.getInt(RANK_ID)));	
		}
		
		if(box.getInt(TRADE_ID)!=0){
			crit=crit.createAlias("h.Trade", "t",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("t.Id",box.getInt(TRADE_ID)));	
		}
		if(box.getInt(REFERRED_BY)!=0){
			crit=crit.createAlias("MedicalOfficer", "mo",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("mo.Id",box.getInt(REFERRED_BY)));	
		}
		patientDetentionRegisterList=crit.list();
		map.put("patientDetentionRegisterList", patientDetentionRegisterList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getItemId(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		String pvmsNo=  box.getString("pvmsNo");
		Session session = (Session)getSession();
		itemList = session.createCriteria(MasStoreItem.class).add(Restrictions.eq("PvmsNo", pvmsNo))
		  				.list();
		map.put("itemList", itemList);
		return map;
	}

	@Override
	public Map<String, Object> showMHReferralGraph(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<Object[]> mhRegisterList = new ArrayList<Object[]>();
		String qryStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		if(!(box.getString(REFERRAL_DATE).equals(""))){
			//qryStr += " and mh_referral.referral_date = :referalDate";
			qryStr += " and mh.referral_date = :referalDate";
		}
		if(box.getString(REFER_TO)!=null && !(box.getString(REFER_TO).equals(""))){
			//qryStr += " and mh_referral.refer_to = :referTo";
			qryStr += " and mh.refer_to = :referTo";
		}
		
		if(box.getInt(RANK_ID)!=0){
			//qryStr += " and mh_referral.rank_id = :rankId";
			qryStr += " and mh.rank_id = :rankId";
		}
		if(box.getInt(REFERRED_BY)!=0){
			//qryStr += " and mh_referral.mh_referral_id = :referredBy";
			qryStr += " and mh.mh_referral_id = :referredBy";
		}
		
		String qry = "";
		String fromDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		String toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		qry = "SELECT mh.run_date as run_date," +
		" (select count(*) from mh_referral m left join patient p on m.hin_id=p.hin_id" +
		" where run_date between :fromDate and :toDate" +
		" and run_date=mh.run_date and p.service_type_id=1 group by run_date ) as army," +
		" (select count(*) from mh_referral m left join patient p on m.hin_id=p.hin_id" +
		" where run_date between :fromDate and :toDate " +
		" and run_date=mh.run_date and p.service_type_id=2 group by run_date ) as airforce," +
		" (select count(*) from mh_referral m left join patient p on m.hin_id=p.hin_id" +
		" where run_date between :fromDate and :toDate" +
		" and run_date=mh.run_date  and p.service_type_id=4 group by run_date ) as coastguard," +
		" (select count(*) from mh_referral m left join patient p on m.hin_id=p.hin_id" +
		" where run_date between :fromDate and :toDate" +
		" and run_date=mh.run_date  and p.service_type_id=7 group by run_date ) as NE," +
		" (select count(*) from mh_referral m left join patient p on m.hin_id=p.hin_id" +
		" where run_date between :fromDate and :toDate" +
		" and run_date=mh.run_date  and p.service_type_id=41 group by run_date ) as oth" +
		" FROM" +
		"  patient patient right JOIN mh_referral mh ON patient.hin_id = mh.hin_id" +
		" LEFT OUTER JOIN mas_service_type st ON patient.service_type_id = st.service_type_id" +
		" where mh.run_date between :fromDate and :toDate" +
		" and mh.hospital_id=:hospitalId " +qryStr+
		" group by mh.run_date order by mh.run_date asc";
		System.out.println("sanjay>>>>>>>>>>>"+qry);
		SQLQuery query = session.createSQLQuery(qry);
		query.setParameter("fromDate", fromDate);
		query.setParameter("toDate", toDate);
		query.setParameter("hospitalId",  box.getInt("hospitalId"));
		
		query.setParameter("referalDate",sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(REFERRAL_DATE))));
		if(box.getString(REFER_TO)!=null && !(box.getString(REFER_TO).equals(""))){
			query.setParameter("referTo",box.getString(REFER_TO));
		}
		if(box.getInt(RANK_ID)!=0){
			query.setParameter("rankId",box.getString(RANK_ID));
		}
		if(box.getInt(REFERRED_BY)!=0){
			query.setParameter("referredBy",box.getString(REFERRED_BY));
		}
		mhRegisterList = query.list();
		map.put("mhRegisterList", mhRegisterList);
		return map;
	}

	@Override
	public Map<String, Object> showProcedureGraph(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<Object[]> procedureList = new ArrayList<Object[]>();
		String qryStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		
		if(box.getInt(RANK_ID)!=0){
			qryStr += " and p.rank_id = :rank";
		}
		if(box.getInt(UNIT_ID)!=0){
			qryStr += " and p.unit_id = :unit";
		}
		if(box.getInt(TRADE_ID)!=0){
			qryStr += " and p.trade_id = :trade";
		}
		if(box.getInt(MEDICAL_OFFICER_ID)!=0){
			qryStr += " and ph.medical_officer_id=:moId";
		}
		if(box.getInt("procedure")!=0){
			qryStr += " and pd.procedure_id=:procedure";
		}
		
		if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
			 qryStr ="and substr(age,0,INSTR(age,' ')) >=:fromAge " +
			" and  substr(age,INSTR(age,' ')+1,length(age))=:fromAgeUnit" +
			" and substr(age,0,INSTR(age,' ')) <=:toAge " +
			" and  substr(age,INSTR(age,' ')+1,length(age))=:toAgeUnit";
			
		}
		String qry = "";
		String fromDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		String toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		qry = "SELECT ph.procedure_date as procedure_date," +
			" (select count(*) from procedure_header m left join patient p on m.hin_id=p.hin_id" +
			" where procedure_date between  :fromDate and :toDate" +
			" and procedure_date=ph.procedure_date and p.service_type_id=1 group by procedure_date ) as army," +
			" (select count(*) from procedure_header m left join patient p on m.hin_id=p.hin_id" +
			" where procedure_date between  :fromDate and :toDate" +
			" and procedure_date=ph.procedure_date and p.service_type_id=2 group by procedure_date ) as airforce," +
			" (select count(*) from procedure_header m left join patient p on m.hin_id=p.hin_id" +
			" where procedure_date between  :fromDate and :toDate" +
			" and procedure_date=ph.procedure_date  and p.service_type_id=4 group by procedure_date ) as coastguard," +
			" (select count(*) from procedure_header m left join patient p on m.hin_id=p.hin_id" +
			"  where procedure_date between  :fromDate and :toDate" +
			" and procedure_date=ph.procedure_date  and p.service_type_id=7 group by procedure_date ) as NE," +
			" (select count(*) from procedure_header m left join patient p on m.hin_id=p.hin_id" +
			" where procedure_date between  :fromDate and :toDate" +
			" and procedure_date=ph.procedure_date  and p.service_type_id=41 group by procedure_date ) as oth" +
			" from procedure_details pd left join procedure_header ph on pd.PROCEDURE_HEADER_ID=ph.PROCEDURE_HEADER_ID" +
			" left join mas_nursing_care nc on pd.procedure_id= nc.nursing_id" +
			" left join patient p on ph.hin_id=p.hin_id" +
			" left join mas_hospital h on ph.hospital_id=h.hospital_id" +
			" where procedure_date between  :fromDate and :toDate" +
			"  and ph.hospital_id=:hospitalId " +qryStr+
			" group by ph.procedure_date order by ph.procedure_date asc ";
		
		SQLQuery sqlQry = session.createSQLQuery(qry);
		sqlQry.setParameter("fromDate", fromDate);
		sqlQry.setParameter("toDate", toDate);
		sqlQry.setParameter("hospitalId", box.getInt("hospitalId"));
		if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
			sqlQry.setParameter("fromAge",box.getString("fromAge"));
			sqlQry.setParameter("fromAgeUnit",box.getString("fromAgeUnit"));
			sqlQry.setParameter("toAge",box.getString("toAge"));
			sqlQry.setParameter("toAgeUnit",box.getString("toAgeUnit"));
		}
		if(box.getInt(RANK_ID)!=0){
			sqlQry.setParameter("rank", box.getInt(RANK_ID));
		}
		if(box.getInt(UNIT_ID)!=0){
			sqlQry.setParameter("unit", box.getInt(UNIT_ID));
		}
		if(box.getInt(TRADE_ID)!=0){
			sqlQry.setParameter("trade", box.getInt(TRADE_ID));
		}
		if(box.getInt(MEDICAL_OFFICER_ID)!=0){
			sqlQry.setParameter("moId", box.getInt(MEDICAL_OFFICER_ID));
		}
		if(box.getInt("procedure")!=0){
			sqlQry.setParameter("procedure", box.getInt("procedure"));
		}
		procedureList = sqlQry.list();
		map.put("procedureList", procedureList);
		return map;
	}

	@Override
	public Map<String, Object> showAmbulanceRegisterGraph(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<Object[]> ambulanceRegisterList = new ArrayList<Object[]>();
		String qryStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		if(!(box.getString("fromTime").equals("")) && !(box.getString("toTime").equals(""))){
			qryStr += " and ambulance_run_register.ambulance_run_time between :fromTime  and :toTime";
		}
		if(box.getInt(RANK_ID)!=0){
			qryStr += " and p.rank_id = :rank ";
		}
		if(box.getInt(UNIT_ID)!=0){
			qryStr += " and p.unit_id = :unit";
		}
		if(box.getInt(TRADE_ID)!=0){
			qryStr += " and p.trade_id = :trade";
		}
		
		String qry = "";
		String fromDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		String toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		qry = "SELECT amr.ambulance_run_date as ambulance_run_date," +
			" (select count(*) from ambulance_run_register am left join patient p on am.hin_id=p.hin_id" +
			" where ambulance_run_date between :fromDate and :toDate" +
			" and ambulance_run_date=amr.ambulance_run_date and p.service_type_id=1 group by ambulance_run_date ) as army," +
			" (select count(*) from ambulance_run_register am left join patient p on am.hin_id=p.hin_id" +
			" where ambulance_run_date between :fromDate and :toDate" +
			" and ambulance_run_date=amr.ambulance_run_date and p.service_type_id=2 group by ambulance_run_date ) as airforce," +
			" (select count(*) from ambulance_run_register am left join patient p on am.hin_id=p.hin_id" +
			" where ambulance_run_date between :fromDate and :toDate" +
			" and ambulance_run_date=amr.ambulance_run_date  and p.service_type_id=4 group by ambulance_run_date ) as coastguard," +
			" (select count(*) from ambulance_run_register am left join patient p on am.hin_id=p.hin_id" +
			"  where ambulance_run_date between :fromDate and :toDate" +
			" and ambulance_run_date=amr.ambulance_run_date  and p.service_type_id=7 group by ambulance_run_date ) as NE," +
			" (select count(*) from ambulance_run_register am left join patient p on am.hin_id=p.hin_id" +
			" where ambulance_run_date between :fromDate and :toDate" +
			" and ambulance_run_date=amr.ambulance_run_date  and p.service_type_id=41 group by ambulance_run_date ) as oth" +
			" from ambulance_run_register amr " +
			" left join patient p on amr.hin_id=p.hin_id" +
			" left join mas_hospital h on amr.hospital_id=h.hospital_id" +
			" where ambulance_run_date between :fromDate and :toDate" +
			"  and amr.hospital_id=:hospitalId " +qryStr+
			" group by amr.ambulance_run_date order by amr.ambulance_run_date asc ";
		
		SQLQuery sqlQry = session.createSQLQuery(qry);
		sqlQry.setParameter("fromDate", fromDate);
		sqlQry.setParameter("toDate", toDate);
		sqlQry.setParameter("hospitalId", box.getInt("hospitalId"));
		
		if(!(box.getString("fromTime").equals("")) && !(box.getString("toTime").equals(""))){
			sqlQry.setParameter("fromTime", box.getString("fromTime"));
			sqlQry.setParameter("toTime", box.getString("toTime"));
		}
		if(box.getInt(RANK_ID)!=0){
			sqlQry.setParameter("rank", box.getInt(RANK_ID));
		}
		if(box.getInt(UNIT_ID)!=0){
			sqlQry.setParameter("unit", box.getInt(UNIT_ID));
		}
		if(box.getInt(TRADE_ID)!=0){
			sqlQry.setParameter("trade", box.getInt(TRADE_ID));
		}
		ambulanceRegisterList = sqlQry.list();
		map.put("ambulanceRegisterList", ambulanceRegisterList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showAircraftRegisterGraph(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<Object[]> aircraftRegisterList = new ArrayList<Object[]>();
		String qryStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		if(!box.getString(CALL_RCD_TIME).equals("")){
			qryStr += " and amr.call_rcd_time= :callRcdTime";
		}
		if(!box.getString(SOURCE_FROM).equals("")){
			qryStr += " and amr.source_from=:sourceFrom";
		}
		if(box.getInt(AIRCRAFT_TYPE_ID)!=0 ){
			qryStr += " and amr.type_of_aircraft_id=:aircraftTypeId";
		}
		if(!box.getString(EMERGENCY_TYPE).equals("")){
			qryStr += " and amr.emergency_type=:emergencyType";
		}
		if(!box.getString(LOCATION).equals("")){
			qryStr += " and amr.location=:location";
		}
		
		if(box.getInt(MEDICAL_OFFICER_ID)!=0 ){
			qryStr += " and amr.medical_officer=:moId";
		}
		if(box.getInt(UNIT_ID)!=0){
			qryStr += " and amr.unit_id = :unit";
		}
	
		String qry = "";
		String fromDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		String toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		qry = "SELECT amr.call_rcd_date as call_rcd_date,count(*) " +
		" from air_craft_emergency amr" +
		" left join mas_hospital h on amr.hospital_id=h.hospital_id" +
		" where call_rcd_date between  :fromDate and :toDate" +
		" and amr.hospital_id= :hospitalId " +qryStr+
		" group by amr.call_rcd_date order by amr.call_rcd_date asc";
		
		SQLQuery sqlQry = session.createSQLQuery(qry);
		sqlQry.setParameter("fromDate", fromDate);
		sqlQry.setParameter("toDate", toDate);
		sqlQry.setParameter("hospitalId", box.getInt("hospitalId"));
		
		if(!box.getString(CALL_RCD_TIME).equals("")){
			sqlQry.setParameter("callRcdTime", box.getString(CALL_RCD_TIME));
		}
		if(!box.getString(SOURCE_FROM).equals("")){
			sqlQry.setParameter("sourceFrom", box.getString(SOURCE_FROM));
		}
		if(box.getInt(AIRCRAFT_TYPE_ID)!=0 ){
			sqlQry.setParameter("aircraftTypeId", box.getInt(AIRCRAFT_TYPE_ID));
		}
		if(!box.getString(EMERGENCY_TYPE).equals("")){
			sqlQry.setParameter("emergencyType", box.getString(EMERGENCY_TYPE));
		}
		if(!box.getString(LOCATION).equals("")){
			sqlQry.setParameter("location", box.getString(LOCATION));
		}
		
		if(box.getInt(MEDICAL_OFFICER_ID)!=0 ){
			sqlQry.setParameter("moId", box.getInt(MEDICAL_OFFICER_ID));
		}
		if(box.getInt(UNIT_ID)!=0){
			sqlQry.setParameter("unit", box.getInt(UNIT_ID));
		}
		aircraftRegisterList = sqlQry.list();
		
		map.put("aircraftRegisterList", aircraftRegisterList);
		return map;
	}

	@Override
	public Map<String, Object> saveUnwillingnessCertificate(Box box) {
		Map<String, Object> map =new HashMap<String, Object>();
		boolean flag = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			UnwillingnessCertificate unwillingnessCertificate = new UnwillingnessCertificate();
			unwillingnessCertificate.setServiceNo(box.getString(SERVICE_NO));
			unwillingnessCertificate.setDiagnosis(box.getString(DIAGNOSIS));
			Patient hin = new Patient();
			hin.setId(box.getInt(HIN_ID));
			unwillingnessCertificate.setHin(hin);
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			unwillingnessCertificate.setHospital(hospital);
			unwillingnessCertificate.setReason(box.getString("reason"));
			unwillingnessCertificate.setTreatmentRefused(box.getString("treatmentRefused"));
			Users user = new Users();
			user.setId(box.getInt("userId"));
			unwillingnessCertificate.setLastChgBy(user);
			unwillingnessCertificate.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			unwillingnessCertificate.setLastChgTime(box.getString(CHANGED_TIME));
			hbt.save(unwillingnessCertificate);
			flag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("saved", flag);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showOtherEmergencyGraph(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<Object[]> otherEmergencyList = new ArrayList<Object[]>();
		String qryStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		
		if(!box.getString(CALL_RCD_TIME).equals("")){
			qryStr += " and amr.call_rcd_time= :callRcdTime";
		}
		if(!box.getString(SOURCE_FROM).equals("")){
			qryStr += " and amr.source_from=:sourceFrom";
		}
		
		if(!box.getString(EMERGENCY_TYPE).equals("")){
			qryStr += " and amr.emergency_type=:emergencyType";
		}
		if(!box.getString(LOCATION).equals("")){
			qryStr += " and amr.location=:location";
		}
		
		if(box.getInt(MEDICAL_OFFICER_ID)!=0 ){
			qryStr += " and amr.medical_officer_id=:moId";
		}
	
	
		String qry = "";
		String fromDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		String toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		qry = "SELECT amr.call_rcd_date as call_rcd_date,count(*) " +
		" from emergency_performa amr" +
		" left join mas_hospital h on amr.hospital_id=h.hospital_id" +
		" where call_rcd_date between :fromDate and :toDate" +
		" and amr.hospital_id= :hospitalId " +qryStr+
		" group by amr.call_rcd_date order by amr.call_rcd_date asc";
		
		SQLQuery sqlQry = session.createSQLQuery(qry);
		sqlQry.setParameter("fromDate", fromDate);
		sqlQry.setParameter("toDate", toDate);
		sqlQry.setParameter("hospitalId", box.getInt("hospitalId"));
		
		if(!box.getString(CALL_RCD_TIME).equals("")){
			sqlQry.setParameter("callRcdTime", box.getString(CALL_RCD_TIME));
		}
		if(!box.getString(SOURCE_FROM).equals("")){
			sqlQry.setParameter("sourceFrom", box.getString(SOURCE_FROM));
		}
	
		if(!box.getString(EMERGENCY_TYPE).equals("")){
			sqlQry.setParameter("emergencyType", box.getString(EMERGENCY_TYPE));
		}
		if(!box.getString(LOCATION).equals("")){
			sqlQry.setParameter("location", box.getString(LOCATION));
		}
		
		if(box.getInt(MEDICAL_OFFICER_ID)!=0 ){
			sqlQry.setParameter("moId", box.getInt(MEDICAL_OFFICER_ID));
		}
		
		otherEmergencyList = sqlQry.list();
		map.put("otherEmergencyList", otherEmergencyList);
		return map;
	}

	@Override
	public Map<String, Object> showDetentionRegisterGraph(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<Object[]> detentionRegisterList = new ArrayList<Object[]>();
		String qryStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		
		if(box.getInt(RANK_ID)!=0){
			qryStr += " and p.rank_id = :rank";
		}
		if(box.getInt(UNIT_ID)!=0){
			qryStr += " and p.unit_id = :unit";
		}
		if(box.getInt(TRADE_ID)!=0){
			qryStr += " and p.trade_id = :trade";
		}
		if(box.getInt(MEDICAL_OFFICER_ID)!=0){
			qryStr += " and ph.medical_officer_id=:moId";
		}
	
		String qry = "";
		String fromDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		String toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		qry = "SELECT ph.detention_register_date as detention_register_date," +
			" (select count(*) from patient_detention_register m left join patient p on m.hin_id=p.hin_id" +
			" where detention_register_date between  :fromDate and :toDate" +
			" and detention_register_date=ph.detention_register_date and p.service_type_id=1 group by detention_register_date ) as army," +
			" (select count(*) from patient_detention_register m left join patient p on m.hin_id=p.hin_id" +
			" where detention_register_date between  :fromDate and :toDate" +
			" and detention_register_date=ph.detention_register_date and p.service_type_id=2 group by detention_register_date ) as airforce," +
			" (select count(*) from patient_detention_register m left join patient p on m.hin_id=p.hin_id" +
			" where detention_register_date between  :fromDate and :toDate" +
			" and detention_register_date=ph.detention_register_date  and p.service_type_id=4 group by detention_register_date ) as coastguard," +
			" (select count(*) from patient_detention_register m left join patient p on m.hin_id=p.hin_id" +
			"  where detention_register_date between  :fromDate and :toDate" +
			" and detention_register_date=ph.detention_register_date  and p.service_type_id=7 group by detention_register_date ) as NE," +
			" (select count(*) from patient_detention_register m left join patient p on m.hin_id=p.hin_id" +
			" where detention_register_date between  :fromDate and :toDate" +
			" and detention_register_date=ph.detention_register_date  and p.service_type_id=41 group by detention_register_date ) as oth" +
			" from  patient_detention_register ph" +
			" left join patient p on ph.hin_id=p.hin_id" +
			" left join mas_hospital h on ph.hospital_id=h.hospital_id" +
			" where detention_register_date between  :fromDate and :toDate" +
			"  and ph.hospital_id= :hospitalId " +qryStr+
			" group by ph.detention_register_date order by ph.detention_register_date asc ";
		
		SQLQuery sqlQry = session.createSQLQuery(qry);
		sqlQry.setParameter("fromDate", fromDate);
		sqlQry.setParameter("toDate", toDate);
		sqlQry.setParameter("hospitalId", box.getInt("hospitalId"));
		
		if(box.getInt(RANK_ID)!=0){
			sqlQry.setParameter("rank", box.getInt(RANK_ID));
		}
		if(box.getInt(UNIT_ID)!=0){
			sqlQry.setParameter("unit", box.getInt(UNIT_ID));
		}
		if(box.getInt(TRADE_ID)!=0){
			sqlQry.setParameter("trade", box.getInt(TRADE_ID));
		}
		if(box.getInt(MEDICAL_OFFICER_ID)!=0){
			sqlQry.setParameter("moId",box.getInt(MEDICAL_OFFICER_ID));
		}
		detentionRegisterList = sqlQry.list();
		map.put("detentionRegisterList", detentionRegisterList);
		return map;
	}

	@Override
	public Map<String, Object> showInjectionRegisterGraph(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<Object[]> injectionRegisterList = new ArrayList<Object[]>();
		String qryStr = "";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

		if(box.getInt(RANK_ID)!=0){
			qryStr += " and p.rank_id = :rank";
		}
		if(box.getInt(UNIT_ID)!=0){
			qryStr += " and p.unit_id = :unit";
		}
		if(box.getInt(TRADE_ID)!=0){
			qryStr += " and p.trade_id = :trade";
		}
		if(box.getInt(MEDICAL_OFFICER_ID)!=0){
			qryStr += " and ph.medical_officer_id=:moId";
		}
		if(box.getInt("injectionName")!=0){
			qryStr += " and pd.item_id=:injectionName";
		}
		
		String qry = "";
		String fromDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		String toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		qry = "SELECT ph.injection_date as injection_date," +
			" (select count(*) from injection_register m left join patient p on m.hin_id=p.hin_id" +
			" where injection_date between  :fromDate and :toDate" +
			" and injection_date=ph.injection_date and p.service_type_id=1 group by injection_date ) as army," +
			" (select count(*) from injection_register m left join patient p on m.hin_id=p.hin_id" +
			" where injection_date between  :fromDate and :toDate" +
			" and injection_date=ph.injection_date and p.service_type_id=2 group by injection_date ) as airforce," +
			" (select count(*) from injection_register m left join patient p on m.hin_id=p.hin_id" +
			" where injection_date between  :fromDate and :toDate" +
			" and injection_date=ph.injection_date  and p.service_type_id=4 group by injection_date ) as coastguard," +
			" (select count(*) from injection_register m left join patient p on m.hin_id=p.hin_id" +
			"  where injection_date between  :fromDate and :toDate" +
			" and injection_date=ph.injection_date  and p.service_type_id=7 group by injection_date ) as NE," +
			" (select count(*) from injection_register m left join patient p on m.hin_id=p.hin_id" +
			" where injection_date between  :fromDate and :toDate" +
			" and injection_date=ph.injection_date  and p.service_type_id=41 group by injection_date ) as oth" +
			" from injection_register_details pd left join injection_register ph on pd.injection_register_id=ph.injection_register_id" +
			" left join mas_store_item msi on pd.item_id= msi.item_id" +
			" left join patient p on ph.hin_id=p.hin_id" +
			" left join mas_hospital h on ph.hospital_id=h.hospital_id" +
			" where injection_date between  :fromDate and :toDate" +
			"  and ph.hospital_id= :hospitalId" +qryStr+
			" group by ph.injection_date order by ph.injection_date asc ";
		
		SQLQuery sqlQry = session.createSQLQuery(qry);
		sqlQry.setParameter("fromDate", fromDate);
		sqlQry.setParameter("toDate", toDate);
		sqlQry.setParameter("hospitalId", box.getInt("hospitalId"));
		
		if(box.getInt(RANK_ID)!=0){
			sqlQry.setParameter("rank", box.getInt(RANK_ID));
		}
		if(box.getInt(UNIT_ID)!=0){
			sqlQry.setParameter("unit", box.getInt(UNIT_ID));
		}
		if(box.getInt(TRADE_ID)!=0){
			sqlQry.setParameter("trade", box.getInt(TRADE_ID));
		}
		if(box.getInt(MEDICAL_OFFICER_ID)!=0){
			sqlQry.setParameter("moId",box.getInt(MEDICAL_OFFICER_ID));
		}
		if(box.getInt("injectionName")!=0){
			sqlQry.setParameter("moId",box.getInt("injectionName"));
		}
		injectionRegisterList =sqlQry.list();
		map.put("injectionRegisterList", injectionRegisterList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPrintInjectionRegisterReport(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<InjectionRegisterDetails> injectionRegisterList = new ArrayList<InjectionRegisterDetails>();
		Criteria crit = null;
		crit=session.createCriteria(InjectionRegisterDetails.class).createAlias("InjectionRegister", "ir").createAlias("ir.Hin", "hin", CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("ir.Hospital.Id", box.getInt("hospitalId")))
				.add(Restrictions.between("ir.InjectionDate", HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)), HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE))));
		if(box.getInt(RANK_ID)!=0){
			crit=crit.createAlias("hin.Rank", "r",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("r.Id",box.getInt(RANK_ID)));	
		}
		if(box.getInt(UNIT_ID)!=0){
			crit=crit.createAlias("hin.Unit", "u",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("u.Id",box.getInt(UNIT_ID)));	
		}
		if(box.getInt(TRADE_ID)!=0){
			crit=crit.createAlias("hin.Trade", "t",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("t.Id",box.getInt(TRADE_ID)));
		}
		if(box.getInt(MEDICAL_OFFICER_ID)!=0){
			crit = crit.createAlias("p.MedicalOfficer", "mo",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("mo.Id",box.getInt(MEDICAL_OFFICER_ID)));
		}
		if(box.getInt("injectionName")!=0 ){
			crit = crit.createAlias("Item","i",CriteriaSpecification.LEFT_JOIN).add(Restrictions.eq("i.Id",box.getInt("injectionName")));
		}
		if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
			String fromAge = box.getString("fromAge");
			String toAge = box.getString("toAge");
			String qryStr =" substr(age,0,INSTR(age,' ')) >="+fromAge+" " +
					" and  substr(age,INSTR(age,' ')+1,length(age))='"+box.getString("fromAgeUnit")+"'" +
					" and substr(age,0,INSTR(age,' ')) <="+toAge+" " +
					" and  substr(age,INSTR(age,' ')+1,length(age))='"+box.getString("toAgeUnit")+"'";
			crit = crit.add(Restrictions.sqlRestriction(qryStr));
		}
		
		injectionRegisterList=crit.list();
		map.put("injectionRegisterList", injectionRegisterList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getImmunizationForAutoComplete(Map<String, Object> map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasImmunization> immunizationList  = new ArrayList<MasImmunization>();
		Session session = (Session)getSession();
		String str = (String)map.get("autoHint") ;
		immunizationList = session.createCriteria(MasImmunization.class).add(Restrictions.ilike("ImmunizationName", str+"%"))
						.add(Restrictions.eq("Status", "y")).list();
		dataMap.put("immunizationList", immunizationList);
		return dataMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getImmunizationId(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasImmunization> immunizationList = new ArrayList<MasImmunization>();
		String immunizationCode=  box.getString("immunizationCode");
		Session session = (Session)getSession();
		immunizationList = session.createCriteria(MasImmunization.class).add(Restrictions.eq("ImmunizationCode", immunizationCode)).add(Restrictions.eq("Flag", "A"))
		  				.list();
		map.put("immunizationList", immunizationList);
		return map;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPendingInjectionList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PatientPrescriptionHeader> pendingInjectionList = new ArrayList<PatientPrescriptionHeader>();
		List<InjAppointmentHeader> pendingInjectionAppList = new ArrayList<InjAppointmentHeader>();
		
		Session session = (Session)getSession();
		Criteria crit = null;
		
		/*crit = session.createCriteria(InjectionRegister.class).add(Restrictions.eq("Status","p").ignoreCase())
						.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", box.getInt("hospitalId")));
		*/
		/*crit = session.createCriteria(PatientPrescriptionHeader.class).add(Restrictions.eq("InjectionStatus","p").ignoreCase()).createAlias("Hospital", "h").add(Restrictions.eq("h.Id", box.getInt("hospitalId")));
		if(!box.getString(FROM_DATE).equals("") && !box.getString(TO_DATE).equals("")){
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE));
			Date toDate = HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE));
			crit  = crit.add(Restrictions.between("PrescriptionDate", fromDate, toDate));
		}else{
			crit  = crit.add(Restrictions.eq("PrescriptionDate", (new Date())));
		}
		if(!box.getString(SERVICE_NO).equals("")){
			crit  = crit.createAlias("Hin", "hin").add(Restrictions.eq("hin.ServiceNo",box.getString(SERVICE_NO)));
		}
		if(box.getInt(MEDICAL_OFFICER)!=0){
			crit  = crit.createAlias("Emp", "mo").add(Restrictions.eq("mo.Id",box.getInt(MEDICAL_OFFICER)));
		}
	
		pendingInjectionList = crit.list();*/
		
		
		Criteria critApp = null;
		critApp = session.createCriteria(InjAppointmentHeader.class).add(Restrictions.eq("Status", "p").ignoreCase()).createAlias("Hospital", "h").add(Restrictions.eq("h.Id", box.getInt("hospitalId")));
		if(!box.getString(FROM_DATE).equals("") && !box.getString(TO_DATE).equals("")){
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE));
			Date toDate = HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE));
			critApp  = critApp.add(Restrictions.between("AppointmentDate", fromDate, toDate));
		}else{
			critApp  = critApp.add(Restrictions.eq("AppointmentDate", (new Date())));
		}
		if(!box.getString(SERVICE_NO).equals("")){
			critApp  = critApp.createAlias("Visit", "v").createAlias("v.Hin", "hin").add(Restrictions.eq("hin.ServiceNo",box.getString(SERVICE_NO)));
		}
		if(box.getInt(MEDICAL_OFFICER)!=0){
			critApp  = critApp.createAlias("Prescription", "ph").createAlias("ph.Emp", "mo").add(Restrictions.eq("mo.Id",box.getInt(MEDICAL_OFFICER)));
		}
		
		pendingInjectionAppList = critApp.list();
		map = getDoctorList(box.getInt("hospitalId"));
		map.put("pendingInjectionAppList", pendingInjectionAppList);
//		map.put("pendingInjectionList", pendingInjectionList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getInjectionDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PatientPrescriptionHeader> injectionList = new ArrayList<PatientPrescriptionHeader>();
		List<InjAppointmentHeader> injectionAppList = new ArrayList<InjAppointmentHeader>();
		Session session = (Session)getSession();
		Criteria crit = null;
	
		/*if(box.getInt("prescriptionHeaderId")!=0){
			crit = session.createCriteria(PatientPrescriptionHeader.class).add(Restrictions.eq("InjectionStatus","p").ignoreCase())
			.add(Restrictions.eq("Id", box.getInt("prescriptionHeaderId")));
			injectionList = crit.list();
		}else */
		if(box.getInt("appointmentId")!=0){
			/*crit = session.createCriteria(InjAppointmentHeader.class).add(Restrictions.eq("Status","p").ignoreCase())
			.add(Restrictions.eq("Id", box.getInt("appointmentId")));
			injectionAppList = crit.list();*/
			/*String sqlStr = "select  * from inj_appointment_details a where" +
					"  rowid in  (select min(rowid) from inj_appointment_details b" +
					"  where   b.inj_appointment_header_id = a.inj_appointment_header_id" +
					" and b.item_id = a.item_id" +
					" ) and status='p' and inj_appointment_header_id="+box.getInt("appointmentId");*/
			String sqlStr = "from InjAppointmentDetails as a  where" +
			"  rowid in  (select min(rowid) from InjAppointmentDetails b" +
			"  where   b.InjAppointmentHeader.Id = a.InjAppointmentHeader.Id" +
			" and b.Item.Id = a.Item.Id" +
			" and Status='p' and InjAppointmentHeader.Id="+box.getInt("appointmentId")+") " ;
			//" and a1.Hospital.Id="+box.getInt("hospitalId") ;
			injectionAppList = session.createQuery(sqlStr).list();
		}
		map = getDetailsForProcWaitList(box.getInt("hospitalId"));
	//	map.put("injectionList", injectionList);
		map.put("injectionAppList", injectionAppList);
		return map;
	}
	
	public Map<String, Object> saveInjectionRegisterDetails(Box box) {
		Map<String, Object> map =new HashMap<String, Object>();
		Session session = (Session)getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		boolean flag = false;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			InjectionRegister injectionRegister = new InjectionRegister();
		
			Patient patientInj = new Patient();
			patientInj.setId(box.getInt("hinId"));
			injectionRegister.setHin(patientInj);
			Visit visitInj = new Visit();
			visitInj.setId(box.getInt("visitId"));
			injectionRegister.setVisit(visitInj);
			MasHospital masHospitalInj = new MasHospital();
			masHospitalInj.setId(box.getInt("hospitalId"));
			injectionRegister.setHospital(masHospitalInj);
			
			injectionRegister.setStatus("p");
			injectionRegister.setLastChgTime(time);
			Users user = new Users();
			user.setId(box.getInt("userId"));
			injectionRegister.setLastChgBy(user);
			injectionRegister.setLastChgDate(date);
			injectionRegister.setRequisitionDate(date);
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(box.getInt("moId"));
			injectionRegister.setMedicalOfficer(masEmployee);
			injectionRegister.setInjectionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("injDate")));
			injectionRegister.setInjectionTime(box.getString("injTime"));
			/*injectionRegister.setAllergicTesting(box.getString("allergicTesting"));
			injectionRegister.setAdverseReaction(box.getString("adverseReaction"));*/
			injectionRegister.setStatus("c");
			hbt.save(injectionRegister);
			int injCount = box.getInt("injCount");
			for(int k=1;k<injCount;k++){
			/*	if(box.getInt("presDtId"+k)!=0){
					InjectionRegisterDetails injectionDetails = new InjectionRegisterDetails();
					injectionDetails.setDose(box.getString("dose"+k));
					MasFrequency frequency = new MasFrequency();
					frequency.setId(box.getInt("frequencyId"+k));
					injectionDetails.setFrequency(frequency);
					injectionDetails.setRoute(box.getString("route"+k));
					MasStoreItem item = new MasStoreItem();
					item.setId(box.getInt("injectionId"+k));
					injectionDetails.setItem(item);
					injectionDetails.setInjectionRegister(injectionRegister);
					injectionDetails.setNoOfDays(box.getInt("noOfDays"+k));
					hbt.save(injectionDetails);
					
					PatientPrescriptionDetails prescriptionDetails = (PatientPrescriptionDetails)hbt.load(PatientPrescriptionDetails.class, box.getInt("presDtId"+k));
					int injGivenQty = 1;
					if(prescriptionDetails.getInjGivenQty()!=null){
						injGivenQty = prescriptionDetails.getInjGivenQty()+1;
						prescriptionDetails.setInjGivenQty(injGivenQty);
					}else{
						prescriptionDetails.setInjGivenQty(injGivenQty);
					}
					
						if(injGivenQty == prescriptionDetails.getTotal()){
							prescriptionDetails.setInjectionStatus("c");
						}
					hbt.update(prescriptionDetails);
				}else*/
				if(box.getInt("appDtId"+k)!=0){

					InjectionRegisterDetails injectionDetails = new InjectionRegisterDetails();
					injectionDetails.setDose(box.getString("dose"+k));
					MasFrequency frequency = new MasFrequency();
					frequency.setId(box.getInt("frequencyId"+k));
					injectionDetails.setFrequency(frequency);
					injectionDetails.setRoute(box.getString("route"+k));
					MasStoreItem item = new MasStoreItem();
					item.setId(box.getInt("injectionId"+k));
					injectionDetails.setItem(item);
					injectionDetails.setInjectionRegister(injectionRegister);
					injectionDetails.setNoOfDays(box.getInt("noOfDays"+k));
					injectionDetails.setAdverseReaction(box.getString("adverseReaction"+k));
					injectionDetails.setAllergicTesting(box.getString("allergicTesting"+k));
					hbt.save(injectionDetails);
					InjAppointmentDetails injAppointmentDetails = (InjAppointmentDetails)hbt.load(InjAppointmentDetails.class, box.getInt("appDtId"+k));
					injAppointmentDetails.setStatus("c");
					hbt.update(injAppointmentDetails);
				
					
				}
			
			}
			
			/*if( box.getInt("prescriptionHeaderId")!=0){
				String pendingInj = "";
				List<PatientPrescriptionDetails> prescriptionDetailsList = session.createCriteria(PatientPrescriptionDetails.class).createAlias("Prescription", "ph").add(Restrictions.eq("ph.Id", box.getInt("prescriptionHeaderId"))).list();
				for (PatientPrescriptionDetails pDetails : prescriptionDetailsList) {
					if(pDetails.getInjectionStatus().equalsIgnoreCase("p")){
						pendingInj = "yes";
						break;
					}
				}
				if(pendingInj.equals("")){
					PatientPrescriptionHeader presHeader = (PatientPrescriptionHeader)hbt.load(PatientPrescriptionHeader.class, box.getInt("prescriptionHeaderId"));
					presHeader.setStatus("c");
					hbt.update(presHeader);
				}
			}else */	
			if( box.getInt("appointmentHeaderId")!=0){
				String pendingInj = "";
				List<InjAppointmentDetails> appointmentDetailsList = session.createCriteria(InjAppointmentDetails.class).createAlias("InjAppointmentHeader", "ph").add(Restrictions.eq("ph.Id", box.getInt("appointmentHeaderId"))).list();
				for (InjAppointmentDetails pDetails : appointmentDetailsList) {
					if(pDetails.getStatus().equalsIgnoreCase("p")){
						pendingInj = "yes";
						break;
					}
				}
				if(pendingInj.equals("")){
					InjAppointmentHeader appHeader = (InjAppointmentHeader)hbt.load(InjAppointmentHeader.class, box.getInt("appointmentHeaderId"));
					appHeader.setStatus("c");
					hbt.update(appHeader);
				}
			}
			flag = true;
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


	@Override
	public Map<String, Object> getInjectionDetailsForAppointment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<InjAppointmentDetails> injectionList = new ArrayList<InjAppointmentDetails>();
		Session session = (Session)getSession();
		int count = box.getInt("injCount");
		String appIdsd="";
		if(count>0){
			for (int i = 1; i <count; i++) {
				if(box.getInt("appDtId"+i)!=0){
					if(appIdsd.equals("")){
						appIdsd=""+box.getInt("appDtId"+i);
					}else{
						appIdsd +=" , "+box.getInt("appDtId"+i);
					}
					
				}
			}
		}
		String sqlStr = "";
		if(box.getString("flag").equals("beforeSave")){
		sqlStr = "from InjAppointmentDetails a where" +
			" rowid in  (select min(rowid) from InjAppointmentDetails b" +
			"  where   b.InjAppointmentHeader.Id = a.InjAppointmentHeader.Id" +
			" and b.Item.Id = a.Item.Id" +
			" and b.Id in ("+appIdsd+") ) ";
		}else if(box.getString("flag").equals("afterSave")){
			sqlStr = "from InjAppointmentDetails a where" +
			"  rowid in  (select min(rowid) from InjAppointmentDetails b" +
			"  where   b.InjAppointmentHeader.Id = a.InjAppointmentHeader.Id" +
			" and b.Item.Id = a.Item.Id" +
			" and InjAppointmentHeader.Id="+box.getInt("appointmentId")+") " ;
		}
		injectionList = session.createQuery(sqlStr).list();
	
		map = getDetailsForProcWaitList(box.getInt("hospitalId"));
		map.put("injectionList", injectionList);
		return map;
	}

	@Override
	public Map<String, Object> saveInjectionAppointment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Transaction tx = null;
		boolean flag = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			tx = session.beginTransaction();
			InjAppointmentHeader injAppointmentHeader = new InjAppointmentHeader();
			injAppointmentHeader.setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(box.getString("injAppDate")));
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			injAppointmentHeader.setHin(patient);
			Visit visit = new Visit();
			visit.setId(box.getInt("visitId"));
			injAppointmentHeader.setVisit(visit);
			injAppointmentHeader.setStatus("p");
			Users user = new Users();
			user.setId(box.getInt("userId"));
			injAppointmentHeader.setLastChgBy(user);
			injAppointmentHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE)));
			injAppointmentHeader.setLastChgTime(box.getString(CHANGED_TIME));
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			injAppointmentHeader.setHospital(hospital);
			PatientPrescriptionHeader prescriptionHeader = new PatientPrescriptionHeader();
			prescriptionHeader.setId(box.getInt("presHdId"));
			injAppointmentHeader.setPrescription(prescriptionHeader);
			hbt.save(injAppointmentHeader);
			
			int counter = box.getInt("hdb");
			if(counter > 0){
				for (int i = 1; i <= counter; i++) {
					if(box.getInt("appPresDtId"+i)!=0){
						InjAppointmentDetails injAppointmentDetails = new InjAppointmentDetails();
						injAppointmentDetails.setAppointmentTime(box.get("appTime"+i));
						injAppointmentDetails.setDose(box.getString("appDose"+i));
						MasFrequency frequency = new MasFrequency();
						frequency.setId(box.getInt("appFrequencyId"+i));
						injAppointmentDetails.setFrequency(frequency);
						injAppointmentDetails.setRoute(box.getString("appRoute"+i));
						MasStoreItem item = new MasStoreItem();
						item.setId(box.getInt("appInjectionId"+i));
						injAppointmentDetails.setItem(item);
						injAppointmentDetails.setInjAppointmentHeader(injAppointmentHeader);
						injAppointmentDetails.setNoOfDays(box.getInt("appNoOfDays"+i));
						PatientPrescriptionDetails ptDetails = new PatientPrescriptionDetails();
						ptDetails.setId(box.getInt("appPresDtId"+i));
						injAppointmentDetails.setPatientPrescriptionDetails(ptDetails);
						injAppointmentDetails.setStatus("p");
						hbt.save(injAppointmentDetails);
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
	public Map<String, Object> getInjectionAppointmentDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<InjAppointmentDetails> injectionAppList = new ArrayList<InjAppointmentDetails>();
		Session session = (Session)getSession();
		injectionAppList = session.createCriteria(InjAppointmentDetails.class).add(Restrictions.eq("Status","p").ignoreCase())
							.createAlias("InjAppointmentHeader", "iah").add(Restrictions.eq("iah.AppointmentDate", HMSUtil.convertStringTypeDateToDateType(box.getString("injAppDate"))))
							.createAlias("iah.Hospital", "h").add(Restrictions.eq("h.Id", box.getInt("hospitalId"))).list();
		map.put("injectionAppList", injectionAppList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPatientImmunizationDetails(int hinId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PatientImmunizationDetails> immunizationList = new ArrayList<PatientImmunizationDetails>();
		List<MasImmunization> masImmunizationList = new ArrayList<MasImmunization>();
		List<InjAppointmentDetails> injAppointmentDetailList = new ArrayList<InjAppointmentDetails>();
		List<StoreOpPatientIssueT> storeOpPatientIssueTList = new ArrayList<StoreOpPatientIssueT>();
		List<Integer> prescriptionIdList = new ArrayList<Integer>();
		Session session = (Session)getSession();
		injAppointmentDetailList = session.createCriteria(InjAppointmentDetails.class).createAlias("InjAppointmentHeader", "header")
					.createAlias("header.Hin", "hin").add(Restrictions.eq("hin.Id", hinId)).list();
		int prescriptionId = 0;
		if(injAppointmentDetailList.size()>0){
			for(InjAppointmentDetails injAppointmentDetails : injAppointmentDetailList){
				if(injAppointmentDetails.getInjAppointmentHeader().getPrescription() != null){
					prescriptionId = injAppointmentDetails.getInjAppointmentHeader().getPrescription().getId();
					prescriptionIdList.add(prescriptionId);
				}
			}
			storeOpPatientIssueTList = session.createCriteria(StoreOpPatientIssueT.class)
								.createAlias("OpIssue", "storeIssueM")
								.createAlias("storeIssueM.PatientPrescriptionHeader", "header").add(Restrictions.in("header.Id", prescriptionIdList)).list();
			
		}
		immunizationList = session.createCriteria(PatientImmunizationDetails.class).createAlias("Hin", "hin").add(Restrictions.eq("hin.Id", hinId)).list();
	     masImmunizationList = session.createCriteria(MasImmunization.class).add(Restrictions.eq("Status", "y")).list();
	     map.put("masImmunizationList", masImmunizationList);
		map.put("immunizationList", immunizationList);
		map.put("storeOpPatientIssueTList", storeOpPatientIssueTList);
		map.put("injAppointmentDetailList", injAppointmentDetailList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPatientAllergyDetails(int hinId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AllergyDetail> allergyDetailsList = new ArrayList<AllergyDetail>();
		Session session = (Session)getSession();
		allergyDetailsList = session.createCriteria(AllergyDetail.class).createAlias("Hin", "hin").add(Restrictions.eq("hin.Id", hinId)).list();
		map.put("allergyDetailsList", allergyDetailsList);
		return map;
	}

	@Override
	public Map<String, Object> inactivatePatientAllergies(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int count = box.getInt("allergyCount");
		boolean saved = false;
		try {
			if(count>0) {
				for (int i = 1; i <= count; i++) {
					if(box.getInt("checkAllergyId"+i)!=0) {
						AllergyDetail allergyDetail = (AllergyDetail)hbt.load(AllergyDetail.class, box.getInt("checkAllergyId"+i));
						allergyDetail.setStatus("n");
						hbt.update(allergyDetail);
					}
				}
				saved = true;
			}
			map =  getPatientAllergyDetails(box.getInt("hinId"));
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("saved", saved);
		return map;
	}
	//-------------------------- Dinesh ----start here---------------------------------------
	public boolean saveImmunizationDetails(Map<String, Object> objectMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<Integer> immuDtIdList  = new ArrayList<Integer>();
		List<Integer> immuIdList  = new ArrayList<Integer>();
		List<String> dateList  = new ArrayList<String>();
		List<String> doseList  = new ArrayList<String>();
		List<String> routeList  = new ArrayList<String>();
		List<String> batchNoList  = new ArrayList<String>();
		List<String> domList  = new ArrayList<String>();
		List<String> doeList  = new ArrayList<String>();
		List<String> immuNameList=new ArrayList<String>();
		List<Integer> storeOpIssueTIdList  = new ArrayList<Integer>();
		boolean status=false;
		Session session = (Session)getSession();
		try
		{   String deleteVal="";
			int hospitalId=0;
			int hinId=0;
			System.out.println("deleteVal----->"+objectMap.get("deleteVal"));
			/*if(objectMap.get("deleteVal")!=null && (!objectMap.get("deleteVal").equals("")))
			{
				deleteVal = (String)objectMap.get("deleteVal");
				String arr[]=deleteVal.split(",");
				if(arr.length>0)
				{
					for(int i=1;i<arr.length;i++)
					{
						try
						{
							int id=Integer.parseInt(arr[i]);
				            PatientImmunizationDetails patientImmunizationDetails=(PatientImmunizationDetails)hbt.load(PatientImmunizationDetails.class,id);
							hbt.delete(patientImmunizationDetails);
							status=true;
						}catch(Exception e)
						{
							e.printStackTrace();
						}
					}
				}
			}*/
			if(objectMap.get("hospitalId")!=null){
				hospitalId = (Integer)objectMap.get("hospitalId");
			}
			if(objectMap.get("hinId")!=null){
				hinId = (Integer)objectMap.get("hinId");
			}
		if(objectMap.get("immuDtIdList")!=null){
			immuDtIdList = (List<Integer>)objectMap.get("immuDtIdList");
		}
		if(objectMap.get("storeOpIssueTIdList")!=null){
			storeOpIssueTIdList = (List<Integer>)objectMap.get("storeOpIssueTIdList");
		}
		if(objectMap.get("immuIdList")!=null){
			immuIdList = (List<Integer>)objectMap.get("immuIdList");
		}
		if(objectMap.get("dateList")!=null){
			dateList = (List<String>)objectMap.get("dateList");
		}
		if(objectMap.get("doseList")!=null){
			doseList = (List<String>)objectMap.get("doseList");
		}
		if(objectMap.get("routeList")!=null){
			routeList = (List<String>)objectMap.get("routeList");
		}
		if(objectMap.get("batchNoList")!=null){
			batchNoList = (List<String>)objectMap.get("batchNoList");
		}
		if(objectMap.get("immuNameList")!=null){
			immuNameList = (List<String>)objectMap.get("immuNameList");
		}
		if(objectMap.get("domList")!=null){
			domList = (List<String>)objectMap.get("domList");
		}
		if(objectMap.get("doeList")!=null){
			doeList = (List<String>)objectMap.get("doeList");
		}
		MasHospital masHospital=new MasHospital();
		masHospital.setId(hospitalId);
		Patient patientObj = new Patient();
		patientObj.setId(hinId);
	     if(immuNameList.size() > 0){
	    	 Query query = session.createQuery("delete from PatientImmunizationDetails where Hin.Id="+hinId);
				query.executeUpdate();
		   for (int i = 0; i < immuNameList.size(); i++)
		   {
			/*if(immuDtIdList.get(i)== 0 && !immuNameList.get(i).equals(""))
			{
				System.out.println("====in if====");
				PatientImmunizationDetails immunizationDetails = new PatientImmunizationDetails();
				immunizationDetails.setHin(patientObj);
				immunizationDetails.setHospital(masHospital);
			  MasImmunization immunization = new MasImmunization();
				immunization.setId(immuIdList.get(i));
				immunizationDetails.setImmunization(immunization);
				immunizationDetails.setImmunizationDetail(immuNameList.get(i));
				immunizationDetails.setDose(doseList.get(i));
				immunizationDetails.setRoute(routeList.get(i));
				immunizationDetails.setBatchNo(batchNoList.get(i));
				if(!dateList.get(i).equals(""))
					immunizationDetails.setImmunizationDate(HMSUtil.convertStringTypeDateToDateType(dateList.get(i)));
				if(!domList.get(i).equals(""))
					immunizationDetails.setDom(HMSUtil.convertStringTypeDateToDateType(domList.get(i)));
				if(!doeList.get(i).equals(""))
					immunizationDetails.setDoe(HMSUtil.convertStringTypeDateToDateType(doeList.get(i)));
 			    //immunizationDetails.setRemarks(remarksList.get(i));
				//immunizationDetails.setLastChgBy(user);
				//immunizationDetails.setLastChgDate(new Date());
				//immunizationDetails.setLastChgTime(time);
				hbt.save(immunizationDetails);
				status=true;
			}else */if(!immuNameList.get(i).equals("")){
				
								PatientImmunizationDetails immunizationDetails = new PatientImmunizationDetails();
								
								immunizationDetails.setHin(patientObj);
								immunizationDetails.setHospital(masHospital);
								/*if(immunizationIdList.get(i)!=0){
								MasImmunization immunization = new MasImmunization();
								immunization.setId(immunizationIdList.get(i));
								immunizationDetails.setImmunization(immunization);
								}*/
								immunizationDetails.setImmunizationDetail(immuNameList.get(i));
								immunizationDetails.setDose(doseList.get(i));
								immunizationDetails.setRoute(routeList.get(i));
								immunizationDetails.setBatchNo(batchNoList.get(i));
								if(!dateList.get(i).equals(""))
									immunizationDetails.setImmunizationDate(HMSUtil.convertStringTypeDateToDateType(dateList.get(i)));
								if(!domList.get(i).equals(""))
									immunizationDetails.setDom(HMSUtil.convertStringTypeDateToDateType(domList.get(i)));
								if(!doeList.get(i).equals(""))
									immunizationDetails.setDoe(HMSUtil.convertStringTypeDateToDateType(doeList.get(i)));
							//	immunizationDetails.setRemarks(remarksList.get(i));
								/*immunizationDetails.setLastChgBy(user);
								immunizationDetails.setLastChgDate(new Date());
								immunizationDetails.setLastChgTime(time);*/
								hbt.save(immunizationDetails);
								status=true;
							}
		}
	}
	}catch (Exception e)
	{
	    e.printStackTrace();
	}
	   return status;
	}
	public boolean saveAllergiesDetails(Map<String, Object> objectMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
	
		List<Integer> allergyDetailsIdList  = new ArrayList<Integer>();
	    List<Integer> allergyTypeIdList  = new ArrayList<Integer>();
	    List<String> descList  = new ArrayList<String>();
    	List<String> severityList  = new ArrayList<String>();
	    List<String> sinceList  = new ArrayList<String>();
	    List<String> remarksList  = new ArrayList<String>();
	    boolean status=false;
	   try
	   {   String deleteVal="";
		int hospitalId=0;
		int hinId=0;
		if(objectMap.get("deleteVal")!=null && (!objectMap.get("deleteVal").equals("")))
		{
			deleteVal = (String)objectMap.get("deleteVal");
			String arr[]=deleteVal.split(",");
			if(arr.length>0)
			{
				for(int i=1;i<arr.length;i++)
				{
					try
					{
						int id=Integer.parseInt(arr[i]);
						AllergyDetail allergyDetail=(AllergyDetail)hbt.load(AllergyDetail.class,id);
						hbt.delete(allergyDetail);
						status=true;
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		if(objectMap.get("hospitalId")!=null){
			hospitalId = (Integer)objectMap.get("hospitalId");
		}
		if(objectMap.get("hinId")!=null){
			hinId = (Integer)objectMap.get("hinId");
		}
	if(objectMap.get("allergyDetailsIdList")!=null){
		allergyDetailsIdList = (List<Integer>)objectMap.get("allergyDetailsIdList");
	}
	if(objectMap.get("allergyTypeIdList")!=null){
		allergyTypeIdList = (List<Integer>)objectMap.get("allergyTypeIdList");
	}
	if(objectMap.get("descList")!=null){
		descList = (List<String>)objectMap.get("descList");
	}
	if(objectMap.get("severityList")!=null){
		severityList = (List<String>)objectMap.get("severityList");
	}
	if(objectMap.get("sinceList")!=null){
		sinceList = (List<String>)objectMap.get("sinceList");
	}
	if(objectMap.get("remarksList")!=null){
		remarksList = (List<String>)objectMap.get("remarksList");
	}
	MasHospital masHospital=new MasHospital();
	masHospital.setId(hospitalId);
	Patient patientObj = new Patient();
	patientObj.setId(hinId);
	
	if(allergyTypeIdList.size() > 0){
		
		for (int i = 0; i < allergyTypeIdList.size(); i++) 
		{
			if(allergyDetailsIdList.get(i)==0 && allergyTypeIdList.get(i)!=0)
			{
				AllergyDetail allergyDetail = new AllergyDetail();
				
				MasAllergyType masAllergyType = new MasAllergyType();
				masAllergyType.setId(allergyTypeIdList.get(i));
				allergyDetail.setAllergyType(masAllergyType);
				allergyDetail.setDescription(descList.get(i));
				allergyDetail.setRemarks(remarksList.get(i));
				allergyDetail.setSeverity(severityList.get(i));
				allergyDetail.setSince(sinceList.get(i));
				allergyDetail.setHin(patientObj);
				allergyDetail.setHospital(masHospital);
				allergyDetail.setStatus("y");
				/*MasEmployee medicalOfficer =new MasEmployee();
				medicalOfficer.setId(consultingDoctorId);
				allergyDetail.setMedicalOfficer(medicalOfficer);*/		
				//allergyDetail.setLastChgBy(user);
				//allergyDetail.setLastChgDate(new Date());
				//allergyDetail.setLastChgTime(time);
				hbt.save(allergyDetail);
				hbt.refresh(allergyDetail);
				status=true;
			}
		}
	}

	}catch (Exception e)
	{
	    e.printStackTrace();
	}
	   return status;
	}	
	//----------------------------------------------Dinesh ------------- end here --------------------------

	@Override
	public Map<String, Object> getPatientList(String hinNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session)getSession();
		patientList = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", hinNo)).list();
		map.put("patientList", patientList);
		return map;
	}

	@Override
	public Map<String, Object> issueInjectionFromReception(Box box) {

		Map<String,Object> map = new HashMap<String, Object>();
		boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		Session session = (Session)getSession();
		int dmaHeaderId = box.getInt("dmaHeaderId");

		try {
			tx = session.beginTransaction();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			Patient patient = new Patient();
			patient.setId(box.getInt(HIN_ID));
			

			/**
			* Saving Data in StoreOpPatientIssueM
			*/
			StoreOpPatientIssueM storeOpPatientIssueM =  new StoreOpPatientIssueM();
			List opdIssueNo = new ArrayList();
			opdIssueNo = session.createQuery(
					"select syd from StoreFyDocumentNo as syd where syd.Department.Id="
					+ box.getInt("deptId")).list();
			String opdIssueNoFromDB = "";
			String opdIssuenoIncremented = "";
			StoreFyDocumentNo storeFyDocumentNo = new StoreFyDocumentNo();
			if(opdIssueNo.size() > 0){
				storeFyDocumentNo = (StoreFyDocumentNo) opdIssueNo.get(0);
				opdIssueNoFromDB = storeFyDocumentNo.getOpdIssueNo();
				opdIssuenoIncremented = getMaxNo(opdIssueNoFromDB);
				storeFyDocumentNo.setOpdIssueNo(opdIssuenoIncremented);
				hbt.update(storeFyDocumentNo);
			}else {
				opdIssuenoIncremented = getMaxNo("");
				storeFyDocumentNo.setOpdIssueNo(opdIssuenoIncremented);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(box.getInt("deptId"));
				storeFyDocumentNo.setDepartment(masDepartment);
				hbt.save(storeFyDocumentNo);
				hbt.refresh(storeFyDocumentNo);

			}

			MasDepartment department = new MasDepartment();
			department.setId(box.getInt("deptId"));
			storeOpPatientIssueM.setDepartment(department);
			storeOpPatientIssueM.setHospital(masHospital);

			storeOpPatientIssueM.setIssueType("I");
			storeOpPatientIssueM.setTypeOfIssue("P");
			storeOpPatientIssueM.setHin(patient);
			storeOpPatientIssueM.setServiceNo(box.getString(SERVICE_NO));

			storeOpPatientIssueM.setIssueNo(opdIssuenoIncremented);
			storeOpPatientIssueM.setIssueDate(new Date());
			storeOpPatientIssueM.setStatus("y");
			storeOpPatientIssueM.setLastChgBy(box.getString("userName"));
			storeOpPatientIssueM.setLastChgDate(new Date());
			storeOpPatientIssueM.setLastChgTime(box.getString(CHANGED_TIME));
			PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
			patientPrescriptionHeader.setId(box.getInt("prescriptionHeaderId"));
			storeOpPatientIssueM.setPatientPrescriptionHeader(patientPrescriptionHeader);
			hbt.save(storeOpPatientIssueM);
			

			/**
			* End
			*/

			/**
			 * Saving Data in StoreOpPatientIssueT
			 */
			int counter = box.getInt("hdb");
			for (int i = 1; i < counter; i++) {
				if(box.getInt("issueQty"+i)!=0){
					
					MasStoreItem item = new MasStoreItem();
					item.setId(box.getInt(ITEM_ID+i));
					StoreItemBatchStock batchStock = new StoreItemBatchStock();
					batchStock.setId(box.getInt("batchId"+i));
					StoreOpPatientIssueT storeOpPatientIssueT = new StoreOpPatientIssueT();
					storeOpPatientIssueT.setOpIssue(storeOpPatientIssueM);
					storeOpPatientIssueT.setItemIdRequire(item);
					storeOpPatientIssueT.setItemIdIssue(item);
					storeOpPatientIssueT.setBatchNo(box.getString("batchNo"+i));
					if(!box.getString("expDate"+i).equals("")){
						Date expiryDateToInsert=HMSUtil.convertStringTypeDateToDateType(box.getString("expDate"+i));
						storeOpPatientIssueT.setExpiryDate(expiryDateToInsert);
					}
					storeOpPatientIssueT.setQtyIssued(new BigDecimal(box.getInt("issueQty"+i)));
					if(!box.getString("costPrice"+i).equals("")){
						storeOpPatientIssueT.setRate(new BigDecimal(box.getString("costPrice"+i)));
					}
					storeOpPatientIssueT.setOpIssueType("");
					
					hbt.save(storeOpPatientIssueT);
				



					StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock)hbt.load(StoreItemBatchStock.class, box.getInt("batchId"+i));
					BigDecimal issueStock = new BigDecimal(0);
					BigDecimal clStock = new BigDecimal(0);

					if(storeItemBatchStock.getClosingStock()!= null){
						clStock = storeItemBatchStock.getClosingStock();
					}
					if(storeItemBatchStock.getIssueQty()!= null){
						issueStock = storeItemBatchStock.getIssueQty();
					}
					storeItemBatchStock.setIssueQty(issueStock.add(new BigDecimal(box.getInt("issueQty"+i))));
					storeItemBatchStock.setClosingStock(clStock.subtract(new BigDecimal(box.getInt("issueQty"+i))));

					hbt.update(storeItemBatchStock);
				


				}
			}
		
			tx.commit();
			flag = true;
		}catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

		map.put("flag", flag);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> saveLifeStyleFactors(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
	
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Vector habits = box.getVector("habit");
		Vector quantity = box.getVector("quantity");
		Vector durations = box.getVector("duration");
		Vector durationUnits = box.getVector("durationUnit");
		Vector startAge = box.getVector("startAge");
		Vector quitAge = box.getVector("quitAge");
		Vector quit = box.getVector("quit");
		Vector lifeStyleFactorId = box.getVector("lifeStyleFactorId");
		
		Transaction tx = null;
		Session session = (Session)getSession();
		/*List<PatientLifeStyleFactor> lifeStList = new ArrayList<PatientLifeStyleFactor>();
		List<PatientGyneDetails> gyneList = new ArrayList<PatientGyneDetails>();
		List<ContraceptiveDetails> contList = new ArrayList<ContraceptiveDetails>();
		List<HrtDetails> hrtList = new ArrayList<HrtDetails>();
		
		lifeStList = session.createCriteria(PatientLifeStyleFactor.class).add(Restrictions.eq("HinNo", hinNo)).list();
		gyneList = session.createCriteria(PatientGyneDetails.class).add(Restrictions.eq("HinNo", hinNo)).list();
		contList = session.createCriteria(ContraceptiveDetails.class).add(Restrictions.eq("HinNo", hinNo)).list();
		hrtList = session.createCriteria(HrtDetails.class).add(Restrictions.eq("HinNo", hinNo)).list();
		
*/		try {
			tx = session.beginTransaction();
			/**
			 * Life Style Factor
			 */
			if(habits.size() > 0){
				for(int i=0;i<habits.size();i++){
					int lifeStyleId = Integer.parseInt(lifeStyleFactorId.get(i).toString());
					if(lifeStyleId == 0){
						PatientLifeStyleFactor lifeStyleFactor = new PatientLifeStyleFactor();
						lifeStyleFactor.setHabit(habits.get(i).toString());
						lifeStyleFactor.setQuantity(quantity.get(i).toString());
						if(!durations.get(i).equals("")){
							lifeStyleFactor.setDuration(Integer.parseInt(durations.get(i).toString()));
							lifeStyleFactor.setDurationUnit(durationUnits.get(i).toString());
						}
						if(!startAge.get(i).equals(""))
							lifeStyleFactor.setStartAge(Integer.parseInt(startAge.get(i).toString()));
						lifeStyleFactor.setQuit(quit.get(i).toString());
						if(!quitAge.get(i).equals(""))
							lifeStyleFactor.setQuitAge(Integer.parseInt(quitAge.get(i).toString()));
						if(!box.getString("hinNo").equals("")){
							lifeStyleFactor.setHinNo(box.getString("hinNo"));
						}else if(box.getInt("hinId")!=0){
							Patient patient = new Patient();
							patient.setId(box.getInt("hinId"));
							lifeStyleFactor.setHin(patient);
						}
						hbt.save(lifeStyleFactor);
					}else{
						PatientLifeStyleFactor lifeStyleFactor = (PatientLifeStyleFactor)hbt.load(PatientLifeStyleFactor.class, lifeStyleId);
						lifeStyleFactor.setQuantity(quantity.get(i).toString());
						if(!durations.get(i).equals("")){
							lifeStyleFactor.setDuration(Integer.parseInt(durations.get(i).toString()));
							lifeStyleFactor.setDurationUnit(durationUnits.get(i).toString());
						}
						if(!startAge.get(i).equals(""))
							lifeStyleFactor.setStartAge(Integer.parseInt(startAge.get(i).toString()));
						lifeStyleFactor.setQuit(quit.get(i).toString());
						if(!quitAge.get(i).equals(""))
							lifeStyleFactor.setQuitAge(Integer.parseInt(quitAge.get(i).toString()));
						hbt.update(lifeStyleFactor);	
					}
				}
			}
			/**
			 * End
			 */
			
			
			
			if(box.getInt("gender")==2){ // For female only
				/**
				 * Gyn Details
				 */
				
				if(box.getInt("gynDetailsId") == 0 ){
					PatientGyneDetails patientGyneDetails = new PatientGyneDetails();
					if(!box.getString("menstrualHistory").equals("")){
						patientGyneDetails.setMenstrualHistoryUnknown(box.getString("menstrualHistory"));
					}
					patientGyneDetails.setMenstrualStatus(box.getString("menstrualStatus"));
					if(!box.getString("lmp").equals(""))
						patientGyneDetails.setLmp(HMSUtil.convertStringTypeDateToDateType(box.getString("lmp")));
					if(!box.getString("lmpUnknown").equals("")){
						patientGyneDetails.setLmpUnknown(box.getString("lmpUnknown"));
					}else{
						patientGyneDetails.setLmpUnknown("n");
					}
					patientGyneDetails.setMenarcheAge(box.getString("menarcheAge"));
					patientGyneDetails.setMenopauseAge(box.getString("menopauseAge"));
					patientGyneDetails.setMenstrualCycle(box.getString("menstrualCycle"));
					patientGyneDetails.setMenstrualFlow(box.getString("menstrualFlow"));
					patientGyneDetails.setDysmenorrhea(box.getString("dysmenorrhea"));
					patientGyneDetails.setMenstrualAbnormalities(box.getString("menstrualAbnormalities"));
					if(!box.getString("obstetricHistoryUnknown").equals("")){
						patientGyneDetails.setObstetricHistoryUnknown(box.getString("obstetricHistoryUnknown"));
					}else{
						patientGyneDetails.setObstetricHistoryUnknown("n");
					}
					if(!box.getString("obstetricHistoryNotApplicable").equals("")){
						patientGyneDetails.setObstetricNotApplicable(box.getString("obstetricHistoryNotApplicable"));
					}else{
						patientGyneDetails.setObstetricNotApplicable("n");
					}
					patientGyneDetails.setGravida(box.getInt("gravida"));
					patientGyneDetails.setPara(box.getInt("para"));
					patientGyneDetails.setAbortions(box.getInt("abortions"));
					patientGyneDetails.setChildren(box.getInt("children"));
					if(!box.getString("pregnent").equals("")){
						patientGyneDetails.setPregnent(box.getString("pregnent"));
					}
					if(!box.getString("lactating").equals("")){
						patientGyneDetails.setLactating(box.getString("lactating"));
					}
					patientGyneDetails.setFirstDeliveryAge(box.getString("firstDeliveryAge"));
					patientGyneDetails.setLastDeliveryAge(box.getString("lastDeliveryAge"));
					patientGyneDetails.setBreastFeeding(box.getString("breastFeeding"));
					patientGyneDetails.setBreastFeedingDuration(box.getString("breastFeedingDuration"));
					patientGyneDetails.setMolarPregnency(box.getString("molarPregnency"));
					if(!box.getString("hinNo").equals("")){
						patientGyneDetails.setHinNo(box.getString("hinNo"));
					}else if(box.getInt("hinId")!=0){
						Patient patient = new Patient();
						patient.setId(box.getInt("hinId"));
						patientGyneDetails.setHin(patient);
					}
					hbt.save(patientGyneDetails);
				}else if (box.getInt("gynDetailsId") != 0 ) {
					int gnDetailsId = box.getInt("gynDetailsId");
					PatientGyneDetails patientGyneDetails = (PatientGyneDetails)hbt.load(PatientGyneDetails.class, gnDetailsId);
					if(!box.getString("menstrualHistory").equals("")){
						patientGyneDetails.setMenstrualHistoryUnknown(box.getString("menstrualHistory"));
					}
					patientGyneDetails.setMenstrualStatus(box.getString("menstrualStatus"));
					if(!box.getString("lmp").equals(""))
						patientGyneDetails.setLmp(HMSUtil.convertStringTypeDateToDateType(box.getString("lmp")));
					if(!box.getString("lmpUnknown").equals("")){
						patientGyneDetails.setLmpUnknown(box.getString("lmpUnknown"));
					}else{
						patientGyneDetails.setLmpUnknown("n");
					}
					patientGyneDetails.setMenarcheAge(box.getString("menarcheAge"));
					patientGyneDetails.setMenopauseAge(box.getString("menopauseAge"));
					patientGyneDetails.setMenstrualCycle(box.getString("menstrualCycle"));
					patientGyneDetails.setMenstrualFlow(box.getString("menstrualFlow"));
					patientGyneDetails.setDysmenorrhea(box.getString("dysmenorrhea"));
					patientGyneDetails.setMenstrualAbnormalities(box.getString("menstrualAbnormalities"));
					if(!box.getString("obstetricHistoryUnknown").equals("")){
						patientGyneDetails.setObstetricHistoryUnknown(box.getString("obstetricHistoryUnknown"));
					}else{
						patientGyneDetails.setObstetricHistoryUnknown("n");
					}
					if(!box.getString("obstetricHistoryNotApplicable").equals("")){
						patientGyneDetails.setObstetricNotApplicable(box.getString("obstetricHistoryNotApplicable"));
					}else{
						patientGyneDetails.setObstetricNotApplicable("n");
					}
					patientGyneDetails.setGravida(box.getInt("gravida"));
					patientGyneDetails.setPara(box.getInt("para"));
					patientGyneDetails.setAbortions(box.getInt("abortions"));
					patientGyneDetails.setChildren(box.getInt("children"));
					if(!box.getString("pregnent").equals("")){
						patientGyneDetails.setPregnent(box.getString("pregnent"));
					}
					if(!box.getString("lactating").equals("")){
						patientGyneDetails.setLactating(box.getString("lactating"));
					}
					patientGyneDetails.setFirstDeliveryAge(box.getString("firstDeliveryAge"));
					patientGyneDetails.setLastDeliveryAge(box.getString("lastDeliveryAge"));
					patientGyneDetails.setBreastFeeding(box.getString("breastFeeding"));
					patientGyneDetails.setBreastFeedingDuration(box.getString("breastFeedingDuration"));
					patientGyneDetails.setMolarPregnency(box.getString("molarPregnency"));
					
					hbt.update(patientGyneDetails);
				}
				/**
				 * End
				 */
				/**
				 * Contraceptive Details
				 */
				Vector contraDetailsId = box.getVector("contraDetailsId");
				Vector contraceptive = box.getVector("contraceptive");
				Vector contraDuration = box.getVector("contraDuration");
				Vector contraDurationUnit = box.getVector("contraDurationUnit");
				if(contraceptive.size() > 0){
					for(int j=0;j<contraceptive.size();j++){
						if(contraDetailsId.get(j).toString().equals("") || Integer.parseInt(contraDetailsId.get(j).toString()) == 0){
							ContraceptiveDetails contraceptiveDetails = new ContraceptiveDetails();
							contraceptiveDetails.setContraceptive(contraceptive.get(j).toString());
							if(!contraDuration.get(j).equals(""))
								contraceptiveDetails.setDuration(Integer.parseInt(contraDuration.get(j).toString()));
							contraceptiveDetails.setDurationUnit(contraDurationUnit.get(j).toString());
							if(!box.getString("hinNo").equals("")){
								contraceptiveDetails.setHinNo(box.getString("hinNo"));
							}else if(box.getInt("hinId")!=0){
								Patient patient = new Patient();
								patient.setId(box.getInt("hinId"));
								contraceptiveDetails.setHin(patient);
							}

							hbt.save(contraceptiveDetails);
						}else{
							ContraceptiveDetails contraceptiveDetails = (ContraceptiveDetails)hbt.load(ContraceptiveDetails.class, Integer.parseInt(contraDetailsId.get(j).toString()));
							contraceptiveDetails.setContraceptive(contraceptive.get(j).toString());
							if(!contraDuration.get(j).equals(""))
								contraceptiveDetails.setDuration(Integer.parseInt(contraDuration.get(j).toString()));
							contraceptiveDetails.setDurationUnit(contraDurationUnit.get(j).toString());
							hbt.update(contraceptiveDetails);	
						}
					}
				}
				/**
				 * End
				 */
				/**
				 * HRT Details
				 */
				Vector hrtDetailsId = box.getVector("hrtDetailsId");
				Vector hormons = box.getVector("hormons");
				Vector fromDate = box.getVector("fromDate");
				Vector toDate = box.getVector("fromDate");
				Vector route = box.getVector("route");
				Vector indexCancer = box.getVector("indexCancer");
				if(hormons.size() > 0){
					for(int j=0;j<hormons.size();j++){
						if(hrtDetailsId.get(j).toString().equals("") || Integer.parseInt(hrtDetailsId.get(j).toString()) == 0){
							HrtDetails hrtDetails = new HrtDetails();
							hrtDetails.setHormone(hormons.get(j).toString());
							if(!fromDate.get(j).equals(""))
								hrtDetails.setFromDate(HMSUtil.convertStringTypeDateToDateType(fromDate.get(j).toString()));
							if(!toDate.get(j).equals(""))
								hrtDetails.setToDate(HMSUtil.convertStringTypeDateToDateType(toDate.get(j).toString()));

							try {     
								String indexCn = indexCancer.get(j).toString();
								hrtDetails.setIndexCancer(indexCn);
							} catch ( IndexOutOfBoundsException e ) {   
								hrtDetails.setIndexCancer("n");
							} 
							hrtDetails.setRoute(route.get(j).toString());
							if(!box.getString("hinNo").equals("")){
								hrtDetails.setHinNo(box.getString("hinNo"));
							}else if(box.getInt("hinId")!=0){
								Patient patient = new Patient();
								patient.setId(box.getInt("hinId"));
								hrtDetails.setHin(patient);
							}

							hbt.save(hrtDetails);
						}else if(Integer.parseInt(hrtDetailsId.get(j).toString()) != 0){
							HrtDetails hrtDetails = (HrtDetails)hbt.load(HrtDetails.class, Integer.parseInt(hrtDetailsId.get(j).toString()));
							hrtDetails.setHormone(hormons.get(j).toString());
							if(!fromDate.get(j).equals(""))
								hrtDetails.setFromDate(HMSUtil.convertStringTypeDateToDateType(fromDate.get(j).toString()));
							if(!toDate.get(j).equals(""))
								hrtDetails.setToDate(HMSUtil.convertStringTypeDateToDateType(toDate.get(j).toString()));

							try {     
								String indexCn = indexCancer.get(j).toString();
								hrtDetails.setIndexCancer(indexCn);
							} catch ( IndexOutOfBoundsException e ) {   
								hrtDetails.setIndexCancer("n");
							} 
							hrtDetails.setRoute(route.get(j).toString());
							hbt.update(hrtDetails);
						}
					}
				}
				/**
				 * End
				 */
			}
			flag = true;
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

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showLifestyleJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hinId = box.getInt("hinId");
		String hinNo= box.getString("hinNo");
		Session session = (Session)getSession();
		List<PatientLifeStyleFactor> lifeStList = new ArrayList<PatientLifeStyleFactor>();
		List<PatientGyneDetails> gyneList = new ArrayList<PatientGyneDetails>();
		List<ContraceptiveDetails> contList = new ArrayList<ContraceptiveDetails>();
		List<HrtDetails> hrtList = new ArrayList<HrtDetails>();
		if(!hinNo.equals("")){
			lifeStList = session.createCriteria(PatientLifeStyleFactor.class).add(Restrictions.eq("HinNo", hinNo)).list();
			gyneList = session.createCriteria(PatientGyneDetails.class).add(Restrictions.eq("HinNo", hinNo)).list();
			contList = session.createCriteria(ContraceptiveDetails.class).add(Restrictions.eq("HinNo", hinNo)).list();
			hrtList = session.createCriteria(HrtDetails.class).add(Restrictions.eq("HinNo", hinNo)).list();
		}else if(hinId!=0 && hinNo.equals("")){
			lifeStList = session.createCriteria(PatientLifeStyleFactor.class).add(Restrictions.eq("Hin.Id", hinId)).list();
			gyneList = session.createCriteria(PatientGyneDetails.class).add(Restrictions.eq("Hin.Id", hinId)).list();
			contList = session.createCriteria(ContraceptiveDetails.class).add(Restrictions.eq("Hin.Id", hinId)).list();
			hrtList = session.createCriteria(HrtDetails.class).add(Restrictions.eq("Hin.Id", hinId)).list();
		}
		
		map.put("lifeStList", lifeStList);
		map.put("gyneList", gyneList);
		map.put("contList", contList);
		map.put("hrtList", hrtList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getServiceNoDetailsForMHRun(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		
		List<Patient> patientList = new ArrayList<Patient>();
		patientList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo",box.getString("ServiceNo"))).list();
		map.put("patientList", patientList);
		return map;
	}
	
	@Override
	public Map<String, Object> fillAVPilotRegServiceDetail(
			Map<String, Object> dataMap) {
				Session session = (Session) getSession();
				Map<String, Object> map = new HashMap<String, Object>();
				List<Patient> patientList = new ArrayList<Patient>();
				List<AvPilotRegistrationDt> avPilotRegistrationDtList = new ArrayList<AvPilotRegistrationDt>();
				@SuppressWarnings("unused")
				int deptId = 0;
				try {
					String str = "" + dataMap.get("serviceNo");
					Criteria c = session.createCriteria(Patient.class).add(
							Restrictions.eq("ServiceNo", str));
					patientList = c.list();
					avPilotRegistrationDtList=session.createCriteria(AvPilotRegistrationDt.class).add(Restrictions.eq("ServiceNo", str)).list();
					map.put("avPilotRegistrationDtList", avPilotRegistrationDtList);
					map.put("patientList", patientList);
				} catch (Exception e) {
					e.printStackTrace();
				}

			return map;}
//------------Added By dipali for HL7 Message---
	@Override
	public synchronized boolean addRecordForHL7() {
		boolean saveOrUpdate = false;
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTimeWithoutSc");
		String mshPidPv1OrcObr="";
		String mshPidPv1="";
		
		Transaction tx = null;
		org.hibernate.Session session = getSession();
		Date DOB = null;
		Date DOA = null;
		String TOA = null;
		String adtym = "";
		String doa_val = null;
		try {
			
		inpatientList=session.createCriteria(Inpatient.class).add(Restrictions.isNull("HL7Flag"))
							.list();
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int i=1;
				for(Inpatient inpatient:inpatientList){
					//Start creating message
					ca.uhn.hl7v2.model.v23.message.ADT_A01 adt1 = new ca.uhn.hl7v2.model.v23.message.ADT_A01();
					ORU_R01 message1 = new ORU_R01();

					message1.getMSH().getEncodingCharacters().setValue("^~\\&");
					message1.getMSH().getFieldSeparator().setValue("|");
					//ORU_R01_ORDER_OBSERVATION orderObservation = message1.getPATIENT_RESULT().getORDER_OBSERVATION();
					ORU_R01_ORDER_OBSERVATION orderObservation = message1.getRESPONSE().getORDER_OBSERVATION();
					//ORU_R01_ORDER_OBSERVATION orderObservation = null;//= message1.getDSC().getContinuationPointer().

					// Populate the MSH Segment

					MSH mshSegment = adt1.getMSH();
					mshSegment.getMsh1_FieldSeparator().setValue("|");
					mshSegment.getMsh2_EncodingCharacters().setValue("^~\\&");
					//mshSegment.getMsh3_SendingApplication().setValue("HMS");
					mshSegment.getMsh3_SendingApplication().getHd1_NamespaceID().setValue("HMS");
					//mshSegment.getMsh4_SendingFacility().setValue("RIH");
					//mshSegment.getMsh5_ReceivingApplication().setValue("EKG");
					mshSegment.getMsh5_ReceivingApplication().getHd1_NamespaceID().setValue("ADMISSION");

					//mshSegment.getMsh6_ReceivingFacility().setValue("EKG");
					mshSegment.getMsh7_DateTimeOfMessage().getTimeOfAnEvent().setValue(new Date()+ time);
					mshSegment.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ORM");
					mshSegment.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("O01");
					//mshSegment.getMsh10_MessageControlID().setValue("1001");
					mshSegment.getMsh10_MessageControlID().setValue(inpatient.getHin().getServiceNo());
					mshSegment.getMsh11_ProcessingID().getProcessingMode().setValue("P");
					mshSegment.getMsh12_VersionID().setValue(adt1.getVersion());

					DOB = inpatient.getHin().getDateOfBirth();
					String abc ="";
					if(DOB!=null){
						abc = HMSUtil.changeDateToddMMyyyy(DOB);
					}
					// Populate the PID Segment
					PID pid = adt1.getPID();
					pid.getPid3_PatientIDInternalID(0).getID().setValue(inpatient.getHin().getId().toString());
					//pid.getPid4_AlternatePatientID().getID().setValue(res.getString("hin_id"));
					pid.getPid5_PatientName().getFamilyName().setValue(inpatient.getHin().getPLastName());
					pid.getPid5_PatientName().getMiddleInitialOrName().setValue(inpatient.getHin().getPMiddleName());
					pid.getPid5_PatientName().getGivenName().setValue(inpatient.getHin().getPFirstName());
					pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(abc);
					pid.getPid8_Sex().setValue(inpatient.getHin().getSex().getAdministrativeSexCode());

					
					ca.uhn.hl7v2.model.v23.segment.NK1 nk1=adt1.getNK1();
					nk1.getNk11_SetIDNextOfKin().setValue(inpatient.getId().toString());
					nk1.getNk12_NKName(0).getGivenName().setValue(inpatient.getHin().getNextOfKinName()) ;
					if(inpatient.getHin().getNextOfKinRelation() !=null){
					nk1.getNk13_Relationship().getCe1_Identifier().setValue(inpatient.getHin().getNextOfKinRelation().getRelationName());}
					if(inpatient.getHin().getNextOfKinAddress() !=null){
					nk1.getNk14_Address(0).getStreetAddress().setValue(inpatient.getHin().getNextOfKinAddress());}
					if(inpatient.getHin().getNextOfKinPhoneNumber() !=null){
					nk1.getNk15_PhoneNumber(0).getPhoneNumber().setValue(inpatient.getHin().getNextOfKinPhoneNumber());
					}
					ca.uhn.hl7v2.model.v23.segment.DG1 dg1=adt1.getDG1();
					if(inpatient.getDiagnosis() !=null){
					dg1.getDg11_SetIDDiagnosis().setValue(inpatient.getDiagnosis().getId().toString());
					dg1.getDg13_DiagnosisCode().getCe2_Text().setValue(inpatient.getDiagnosis().getIcdCode());
					dg1.getDg14_DiagnosisDescription().setValue(inpatient.getDiagnosis().getIcdCode());
					}
					// Now, let's encode the message and look at the output
					char BeginFormat = (char)0x0B;
					//char EndFormat1 = (char)0x1C;
					char EndFormat2 = (char)0x0D;

					Parser p1 = new PipeParser();
					String encodedMessage = p1.encode(adt1);
					String[] mainStr=encodedMessage.split("PID");
					String mshStr=mainStr[0].trim();
					String pidAndNk1Str=mainStr[1].trim();
					String[] mainStr2=pidAndNk1Str.split("NK1");
					String[] mainStr3=pidAndNk1Str.split("DG1");
					String pidStr="PID"+mainStr2[0].trim();
					String nk1Str="NK1"+mainStr2[1].trim();
					String dg1Str="DG1"+mainStr3[0].trim();

					String encMsg = p1.encode(message1);
				//	String newString = encMsg.substring(8);
					//String[] mainStr3=encMsg.split("DG1");
					//String dg1Str="DG1"+mainStr3[0].trim();
//------------------------
					mshPidPv1OrcObr=BeginFormat+mshStr+"\r"+pidStr+"\r"+nk1Str+"\r"+dg1Str+EndFormat2;
					System.out.println("final msg created at client----> "+mshPidPv1OrcObr);
					List<TransactionSequence> adNoList = new ArrayList<TransactionSequence>();
					int inpNo = 0;
					String inpSeqNo = "";
					adNoList = session.createCriteria(TransactionSequence.class)
								.add(Restrictions.eq("TransactionPrefix", "ADTH"))
								//.add(Restrictions.eq("Hospital.Id", 1))
								.list();
						
					if (adNoList.size() > 0) {
				//	for (TransactionSequence transactionSequence : adNoList) {
						TransactionSequence transactionSequence = new TransactionSequence();
						transactionSequence = adNoList.get(0);
						int id = transactionSequence.getId();
						int seqNo = transactionSequence.getTransactionSequenceNumber();
						TransactionSequence transactionSequenceObj = new TransactionSequence();
						transactionSequenceObj = (TransactionSequence) session.load(TransactionSequence.class, id);
						inpNo = seqNo+1;
						transactionSequenceObj.setTransactionSequenceNumber(inpNo);
						try {
							session.update(transactionSequenceObj);
							session.flush();
							session.refresh(transactionSequenceObj);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if (adNoList.size() == 0) {
						TransactionSequence tsObj = new TransactionSequence();
						tsObj.setStatus("y");
						tsObj.setTablename("Inpatient");
						tsObj.setTransactionPrefix("ADTH");
						tsObj.setTransactionSequenceName("Adt");
						tsObj.setTransactionSequenceNumber(0);
						tsObj.setCreatedby("jktuser");
						tsObj.setStatus("y");
						hbt.save(tsObj);
					}
					inpSeqNo = String.valueOf(inpNo);
					HibernateTemplate hbt1 = getHibernateTemplate();
					hbt1.setFlushModeName("FLUSH_EAGER");
					hbt1.setCheckWriteOperations(false);	
				Hl7Message hl7Message =new Hl7Message();
				hl7Message.setServiceNo(inpatient.getHin().getServiceNo());
				hl7Message.setHinNo(inpatient.getHin().getHinNo());
				hl7Message.setMainMessage(mshPidPv1OrcObr);
				hl7Message.setMsgNo(inpSeqNo);
				hl7Message.setMsgType("A01");
				session.save(hl7Message);
				Inpatient inpat = new Inpatient();
				inpat = (Inpatient)session.load(Inpatient.class, inpatient.getId());
				inpat.setHL7Flag(inpSeqNo);
				session.merge(inpat);
				System.out.println("end loop---"+i);
		}
				
				
//----------Message for  Transfer a Patient (A02)---
				
				List<Transfer> transferList = new ArrayList<Transfer>();
				transferList=session.createCriteria(Transfer.class).add(Restrictions.isNull("HL7Flag"))
				.list();
				for(Transfer transfer :transferList){
					
					//Start creating message
					ca.uhn.hl7v2.model.v23.message.ADT_A02 adt2 = new ca.uhn.hl7v2.model.v23.message.ADT_A02();
					ORU_R01 message1 = new ORU_R01();

					message1.getMSH().getEncodingCharacters().setValue("^~\\&");
					message1.getMSH().getFieldSeparator().setValue("|");

					// Populate the MSH Segment

					MSH mshSegment = adt2.getMSH();
					mshSegment.getMsh1_FieldSeparator().setValue("|");
					mshSegment.getMsh2_EncodingCharacters().setValue("^~\\&");
					//mshSegment.getMsh3_SendingApplication().setValue("HMS");
					mshSegment.getMsh3_SendingApplication().getHd1_NamespaceID().setValue("HMS");
					//mshSegment.getMsh4_SendingFacility().setValue("RIH");
					//mshSegment.getMsh5_ReceivingApplication().setValue("EKG");
					mshSegment.getMsh5_ReceivingApplication().getHd1_NamespaceID().setValue("TRANSFER");

					//mshSegment.getMsh6_ReceivingFacility().setValue("EKG");
					mshSegment.getMsh7_DateTimeOfMessage().getTimeOfAnEvent().setValue(new Date()+ time);
					mshSegment.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ORM");
					mshSegment.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("A02");
					//mshSegment.getMsh10_MessageControlID().setValue("1001");
					mshSegment.getMsh10_MessageControlID().setValue(transfer.getId().toString());
					mshSegment.getMsh11_ProcessingID().getProcessingMode().setValue("C");
					mshSegment.getMsh12_VersionID().setValue(adt2.getVersion());
					Date birthDate=null;
					birthDate = transfer.getHin().getDateOfBirth();
					String abc ="";
					if(birthDate!=null){
						abc = HMSUtil.changeDateToddMMyyyy(birthDate);
					}
					// Populate the PID Segment
					PID pid = adt2.getPID();
					pid.getPid3_PatientIDInternalID(0).getID().setValue(transfer.getHin().getId().toString());
					//pid.getPid4_AlternatePatientID().getID().setValue(res.getString("hin_id"));
					pid.getPid5_PatientName().getFamilyName().setValue(transfer.getHin().getPLastName());
					pid.getPid5_PatientName().getMiddleInitialOrName().setValue(transfer.getHin().getPMiddleName());
					pid.getPid5_PatientName().getGivenName().setValue(transfer.getHin().getPFirstName());
					pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(abc);
					pid.getPid8_Sex().setValue(transfer.getHin().getSex().getAdministrativeSexCode());
					
					PV1 pv1 = adt2.getPV1();
					
					String patientType=transfer.getHin().getPatientStatus();
					String patientTypeFinal="";
					String vistIdAndPatient="";
					String roomType="";
					if(patientType.equalsIgnoreCase("Out Patient")){
						List<Visit> visitList = new ArrayList<Visit>();
						visitList=session.createCriteria(Visit.class)
							.add(Restrictions.eq("Hin.Id",transfer.getHin().getId())).list();
						Visit visit = (Visit) visitList.get(0);
						patientTypeFinal="O";
						String visitId = visit.getId().toString();
						pv1.getPv119_VisitNumber().getID().setValue(visitId);
						vistIdAndPatient=visit.getId().toString();
						if(visit.getDepartment() !=null){
						roomType =visit.getDepartment().getDepartmentName();}
						if(visit.getVisitDate() != null || visit.getVisitTime() != null)
						{
							DOA = visit.getVisitDate();
							TOA = visit.getVisitTime();

							TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
						//	TOA =  TOA.substring(0, 4).concat(TOA.substring(5));

							doa_val = HMSUtil.convertDateTypeToStringWithoutTime(DOA);
							adtym = adtym.concat(doa_val).concat(TOA);
							pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
							
							pv1.getPv12_PatientClass().setValue(patientTypeFinal);

							pv1.getPv13_AssignedPatientLocation().getRoom().setValue(roomType);
							if(visit.getDoctor() !=null){
							pv1.getPv18_ReferringDoctor(0).getIDNumber().setValue(visit.getDoctor().getId().toString());
							pv1.getPv18_ReferringDoctor(0).getFamilyName().setValue(visit.getDoctor().getFirstName());
							}
						}
					}else if (patientType.equalsIgnoreCase("In Patient")) {
						
						List<Inpatient> inpatList = new ArrayList<Inpatient>();
						inpatList=session.createCriteria(Inpatient.class)
							.add(Restrictions.eq("Hin.Id",transfer.getHin().getId())).list();
						Inpatient inpat = (Inpatient) inpatList.get(0);
						patientTypeFinal="I";
						String inpatient_id = inpat.getId().toString();
						pv1.getPv119_VisitNumber().getID().setValue(inpatient_id);
						vistIdAndPatient=inpat.getId().toString();
						roomType ="";
						if(inpat.getDateOfAddmission() != null || inpat.getTimeOfAddmission() != null)
						{
							DOA = inpat.getDateOfAddmission();
							TOA = inpat.getTimeOfAddmission();

							TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
							//TOA =  TOA.substring(0, 4).concat(TOA.substring(5));

							doa_val = HMSUtil.convertDateTypeToStringWithoutTime(DOA);
							adtym = adtym.concat(doa_val).concat(TOA);
							pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
							
							pv1.getPv12_PatientClass().setValue(patientTypeFinal);

							pv1.getPv13_AssignedPatientLocation().getRoom().setValue(roomType);
							pv1.getPv18_ReferringDoctor(0).getIDNumber().setValue(inpat.getDoctor().getId().toString());
							pv1.getPv18_ReferringDoctor(0).getFamilyName().setValue(inpat.getDoctor().getFirstName());
						}
					}
					String mshPidPv1A02="";
					// Now, let's encode the message and look at the output
					char BeginFormat = (char)0x0B;
					//char EndFormat1 = (char)0x1C;
					char EndFormat2 = (char)0x0D;

					Parser p1 = new PipeParser();
					String encodedMessage = p1.encode(adt2);

					String[] mainStr=encodedMessage.split("PID");
					String mshStr=mainStr[0].trim();
					String pidAndPv1Str=mainStr[1].trim();
					String[] mainStr2=pidAndPv1Str.split("PV1");
					String pidStr="PID"+mainStr2[0].trim();
					String pv1Str="PV1"+mainStr2[1].trim();
					
					mshPidPv1A02=BeginFormat+mshStr+"\r"+pidStr+"\r"+pv1Str+EndFormat2;
					System.out.println("mshPidPv1A02--->"+mshPidPv1A02);
					
					List<TransactionSequence> transferNoList = new ArrayList<TransactionSequence>();
					int traNo = 0;
					String traSeqNo = "";
					transferNoList = session.createCriteria(TransactionSequence.class)
								.add(Restrictions.eq("TransactionPrefix", "TRA"))
								//.add(Restrictions.eq("Hospital.Id", 1))
								.list();
					
					if (transferNoList.size() > 0) {
				//	for (TransactionSequence transactionSequence : adNoList) {
						TransactionSequence transactionSequence = new TransactionSequence();
						transactionSequence = transferNoList.get(0);
						int id = transactionSequence.getId();
						int seqNo = transactionSequence.getTransactionSequenceNumber();
						TransactionSequence transactionSequenceObj = new TransactionSequence();
						transactionSequenceObj = (TransactionSequence) session.load(TransactionSequence.class, id);
						traNo = seqNo+1;
						transactionSequenceObj.setTransactionSequenceNumber(traNo);
						try {
							session.update(transactionSequenceObj);
							session.flush();
							session.refresh(transactionSequenceObj);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else if (transferNoList.size() == 0) {
						TransactionSequence tsObj = new TransactionSequence();
						tsObj.setStatus("y");
						tsObj.setTablename("Transfer");
						tsObj.setTransactionPrefix("TRA");
						tsObj.setTransactionSequenceName("TRA");
						tsObj.setTransactionSequenceNumber(0);
						tsObj.setCreatedby("jktuser");
						tsObj.setStatus("y");
						hbt.save(tsObj);
					}
					traSeqNo = String.valueOf(traNo);

				Hl7Message hl7Message2 =new Hl7Message();
				hl7Message2.setServiceNo(transfer.getHin().getServiceNo());
				hl7Message2.setHinNo(transfer.getHin().getHinNo());
				hl7Message2.setMainMessage(mshPidPv1A02);
				hl7Message2.setMsgNo(traSeqNo);
				
				hl7Message2.setMsgType("A02");
				session.save(hl7Message2);
				
				Transfer tranA02 = new Transfer();
				tranA02 = (Transfer)session.load(Transfer.class, transfer.getId());
				tranA02.setHL7Flag(traSeqNo);
				session.merge(tranA02);
					
				}
			//----------Message for  Transfer a Patient (A02)---
			
		List<PatientDischargeSlip> dischargeList = new ArrayList<PatientDischargeSlip>();
			dischargeList=session.createCriteria(PatientDischargeSlip.class).add(Restrictions.isNull("HL7Flag"))
							.list();
			for(PatientDischargeSlip discharge :dischargeList){
				//Start creating message
				ca.uhn.hl7v2.model.v23.message.ADT_A03 adt3 = new ca.uhn.hl7v2.model.v23.message.ADT_A03();
				ORU_R01 message1 = new ORU_R01();

				message1.getMSH().getEncodingCharacters().setValue("^~\\&");
				message1.getMSH().getFieldSeparator().setValue("|");

				// Populate the MSH Segment

				MSH mshSegment = adt3.getMSH();
				mshSegment.getMsh1_FieldSeparator().setValue("|");
				mshSegment.getMsh2_EncodingCharacters().setValue("^~\\&");
				//mshSegment.getMsh3_SendingApplication().setValue("HMS");
				mshSegment.getMsh3_SendingApplication().getHd1_NamespaceID().setValue("HMS");
				//mshSegment.getMsh4_SendingFacility().setValue("RIH");
				//mshSegment.getMsh5_ReceivingApplication().setValue("EKG");
				mshSegment.getMsh5_ReceivingApplication().getHd1_NamespaceID().setValue("DISCHARGE");

				//mshSegment.getMsh6_ReceivingFacility().setValue("EKG");
				mshSegment.getMsh7_DateTimeOfMessage().getTimeOfAnEvent().setValue(new Date()+ time);
				mshSegment.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ORM");
				mshSegment.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("A03");
				//mshSegment.getMsh10_MessageControlID().setValue("1001");
				mshSegment.getMsh10_MessageControlID().setValue(discharge.getId().toString());
				mshSegment.getMsh11_ProcessingID().getProcessingMode().setValue("C");
				mshSegment.getMsh12_VersionID().setValue(adt3.getVersion());
				Date birthDate=null;
				birthDate = discharge.getHin().getDateOfBirth();
				String abc ="";
				if(birthDate!=null){
					abc = HMSUtil.changeDateToddMMyyyy(birthDate);
				}
				// Populate the PID Segment
				PID pid = adt3.getPID();
				pid.getPid3_PatientIDInternalID(0).getID().setValue(discharge.getHin().getId().toString());
				//pid.getPid4_AlternatePatientID().getID().setValue(res.getString("hin_id"));
				pid.getPid5_PatientName().getFamilyName().setValue(discharge.getHin().getPLastName());
				pid.getPid5_PatientName().getMiddleInitialOrName().setValue(discharge.getHin().getPMiddleName());
				pid.getPid5_PatientName().getGivenName().setValue(discharge.getHin().getPFirstName());
				pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(abc);
				pid.getPid8_Sex().setValue(discharge.getHin().getSex().getAdministrativeSexCode());
				
				
				PV1 pv1 = adt3.getPV1();
				String patientType=discharge.getHin().getPatientStatus();
				String patientTypeFinal="";
				String vistIdAndPatient="";
				String roomType="";
				if(patientType.equalsIgnoreCase("Out Patient")){
					List<Visit> visitList = new ArrayList<Visit>();
					visitList=session.createCriteria(Visit.class)
						.add(Restrictions.eq("Hin.Id",discharge.getHin().getId())).list();
				if(visitList !=null && visitList.size() >0){
					Visit visit = (Visit) visitList.get(0);
					patientTypeFinal="O";
					String visitId = visit.getId().toString();
					pv1.getPv119_VisitNumber().getID().setValue(visitId);
					vistIdAndPatient=visit.getId().toString();
					if(visit.getDepartment() !=null){
					roomType =visit.getDepartment().getDepartmentName();}
					if(visit.getVisitDate() != null || visit.getVisitTime() != null)
					{
						DOA = visit.getVisitDate();
						TOA = visit.getVisitTime();

						TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
					//	TOA =  TOA.substring(0, 4).concat(TOA.substring(5));

						doa_val = HMSUtil.convertDateTypeToStringWithoutTime(DOA);
						adtym = adtym.concat(doa_val).concat(TOA);
						pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
						
						pv1.getPv12_PatientClass().setValue(patientTypeFinal);

						pv1.getPv13_AssignedPatientLocation().getRoom().setValue(roomType);
						if(visit.getDoctor() !=null){
						pv1.getPv18_ReferringDoctor(0).getIDNumber().setValue(visit.getDoctor().getId().toString());
						pv1.getPv18_ReferringDoctor(0).getFamilyName().setValue(visit.getDoctor().getFirstName());
					}
					}
					}
				}else if (patientType.equalsIgnoreCase("In Patient")) {
					
					List<Inpatient> inpatList = new ArrayList<Inpatient>();
					inpatList=session.createCriteria(Inpatient.class)
						.add(Restrictions.eq("Hin.Id",discharge.getHin().getId())).list();
					Inpatient inpat = (Inpatient) inpatList.get(0);
					patientTypeFinal="I";
					String inpatient_id = inpat.getId().toString();
					pv1.getPv119_VisitNumber().getID().setValue(inpatient_id);
					vistIdAndPatient=inpat.getId().toString();
					roomType ="";
					if(inpat.getDateOfAddmission() != null || inpat.getTimeOfAddmission() != null)
					{
						DOA = inpat.getDateOfAddmission();
						TOA = inpat.getTimeOfAddmission();

						TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
						//TOA =  TOA.substring(0, 4).concat(TOA.substring(5));

						doa_val = HMSUtil.convertDateTypeToStringWithoutTime(DOA);
						adtym = adtym.concat(doa_val).concat(TOA);
						pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
						
						pv1.getPv12_PatientClass().setValue(patientTypeFinal);

						pv1.getPv13_AssignedPatientLocation().getRoom().setValue(roomType);
						pv1.getPv18_ReferringDoctor(0).getIDNumber().setValue(inpat.getDoctor().getId().toString());
						pv1.getPv18_ReferringDoctor(0).getFamilyName().setValue(inpat.getDoctor().getFirstName());
					}
				}
				String mshPidPv1A02="";
				// Now, let's encode the message and look at the output
				char BeginFormat = (char)0x0B;
				//char EndFormat1 = (char)0x1C;
				char EndFormat2 = (char)0x0D;

				Parser p1 = new PipeParser();
				String encodedMessage = p1.encode(adt3);

				String[] mainStr=encodedMessage.split("PID");
				String mshStr=mainStr[0].trim();
				String pidAndPv1Str=mainStr[1].trim();
				String[] mainStr2=pidAndPv1Str.split("PV1");
				String pidStr="PID"+mainStr2[0].trim();
				String pv1Str="";
				System.out.println("mainStr2--->"+mainStr2.toString().indexOf(1));
				if(mainStr2.toString().indexOf(1) >0){
				 pv1Str="PV1"+mainStr2[1].trim();
				}
				mshPidPv1A02=BeginFormat+mshStr+"\r"+pidStr+"\r"+pv1Str+EndFormat2;
				System.out.println("mshPidPv1A02--->"+mshPidPv1A02);
				
				List<TransactionSequence> dischargeNoList = new ArrayList<TransactionSequence>();
				int disNo = 0;
				String discSeqNo = "";
				dischargeNoList = session.createCriteria(TransactionSequence.class)
							.add(Restrictions.eq("TransactionPrefix", "DISA"))
							//.add(Restrictions.eq("Hospital.Id", 1))
							.list();
				
				if (dischargeNoList.size() > 0) {
					//	for (TransactionSequence transactionSequence : adNoList) {
					TransactionSequence transactionSequence = new TransactionSequence();
					transactionSequence = dischargeNoList.get(0);
					int id = transactionSequence.getId();
					int seqNo = transactionSequence.getTransactionSequenceNumber();
					TransactionSequence transactionSequenceObj = new TransactionSequence();
					transactionSequenceObj = (TransactionSequence) session.load(TransactionSequence.class, id);
					disNo = seqNo+1;
					transactionSequenceObj.setTransactionSequenceNumber(disNo);
					try {
						session.update(transactionSequenceObj);
						session.flush();
						session.refresh(transactionSequenceObj);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (dischargeNoList.size() == 0) {
					TransactionSequence tsObj = new TransactionSequence();
					tsObj.setStatus("y");
					tsObj.setTablename("PatientDischargeSlip");
					tsObj.setTransactionPrefix("DISA");
					tsObj.setTransactionSequenceName("DISA");
					tsObj.setTransactionSequenceNumber(0);
					tsObj.setCreatedby("jktuser");
					tsObj.setStatus("y");
					hbt.save(tsObj);
				}
				discSeqNo = String.valueOf(disNo);

			Hl7Message hl7Message2 =new Hl7Message();
			hl7Message2.setServiceNo(discharge.getHin().getServiceNo());
			hl7Message2.setHinNo(discharge.getHin().getHinNo());
			hl7Message2.setMainMessage(mshPidPv1A02);
			hl7Message2.setMsgNo(discSeqNo);
			hl7Message2.setMsgType("A03");
			session.save(hl7Message2);
			System.out.println("PatientDischargeSlip---id----"+discharge.getId());
			PatientDischargeSlip discA03 = new PatientDischargeSlip();
			discA03 = (PatientDischargeSlip)session.load(PatientDischargeSlip.class, discharge.getId());
			discA03.setHL7Flag(discSeqNo);
			session.merge(discA03);
	}
			
			//--------------For A04
			List<Patient> patientList = new ArrayList<Patient>();
			patientList=session.createCriteria(Patient.class).add(Restrictions.isNull("HL7Flag"))
			.list();
			for(Patient patient :patientList){
				//Start creating message
				ca.uhn.hl7v2.model.v23.message.ADT_A04 adt4 = new ca.uhn.hl7v2.model.v23.message.ADT_A04();
				ORU_R01 message1 = new ORU_R01();

				message1.getMSH().getEncodingCharacters().setValue("^~\\&");
				message1.getMSH().getFieldSeparator().setValue("|");

				// Populate the MSH Segment

				MSH mshSegment = adt4.getMSH();
				mshSegment.getMsh1_FieldSeparator().setValue("|");
				mshSegment.getMsh2_EncodingCharacters().setValue("^~\\&");
				//mshSegment.getMsh3_SendingApplication().setValue("HMS");
				mshSegment.getMsh3_SendingApplication().getHd1_NamespaceID().setValue("HMS");
				//mshSegment.getMsh4_SendingFacility().setValue("RIH");
				//mshSegment.getMsh5_ReceivingApplication().setValue("EKG");
				mshSegment.getMsh5_ReceivingApplication().getHd1_NamespaceID().setValue("REGISTER");

				//mshSegment.getMsh6_ReceivingFacility().setValue("EKG");
				mshSegment.getMsh7_DateTimeOfMessage().getTimeOfAnEvent().setValue(new Date()+ time);
				mshSegment.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ORM");
				mshSegment.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("A03");
				//mshSegment.getMsh10_MessageControlID().setValue("1001");
				mshSegment.getMsh10_MessageControlID().setValue(patient.getId().toString());
				mshSegment.getMsh11_ProcessingID().getProcessingMode().setValue("C");
				mshSegment.getMsh12_VersionID().setValue(adt4.getVersion());
				Date birthDate=null;
				birthDate = patient.getDateOfBirth();
				String abc ="";
				if(birthDate!=null){
					abc = HMSUtil.changeDateToddMMyyyy(birthDate);
				}
				// Populate the PID Segment
				PID pid = adt4.getPID();
				pid.getPid3_PatientIDInternalID(0).getID().setValue(patient.getId().toString());
				//pid.getPid4_AlternatePatientID().getID().setValue(res.getString("hin_id"));
				pid.getPid5_PatientName().getFamilyName().setValue(patient.getPLastName());
				pid.getPid5_PatientName().getMiddleInitialOrName().setValue(patient.getPMiddleName());
				pid.getPid5_PatientName().getGivenName().setValue(patient.getPFirstName());
				pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(abc);
				pid.getPid8_Sex().setValue(patient.getSex().getAdministrativeSexCode());
				
				
				PV1 pv1 = adt4.getPV1();
				String patientType=patient.getPatientStatus();
				String patientTypeFinal="";
				String vistIdAndPatient="";
				String roomType="";
			/*	if(patientType.equalsIgnoreCase("Out Patient")){
					List<Visit> visitList = new ArrayList<Visit>();
					visitList=session.createCriteria(Visit.class)
						.add(Restrictions.eq("Hin.Id",patient.getId())).list();
					Visit visit = (Visit) visitList.get(0);
					patientTypeFinal="O";
					String visitId = visit.getId().toString();
					pv1.getPv119_VisitNumber().getID().setValue(visitId);
					vistIdAndPatient=visit.getId().toString();
					if(visit.getDepartment() !=null){
					roomType =visit.getDepartment().getDepartmentName();}
					if(visit.getVisitDate() != null || visit.getVisitTime() != null)
					{
						DOA = visit.getVisitDate();
						TOA = visit.getVisitTime();

						TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
					//	TOA =  TOA.substring(0, 4).concat(TOA.substring(5));

						doa_val = HMSUtil.convertDateTypeToStringWithoutTime(DOA);
						adtym = adtym.concat(doa_val).concat(TOA);
						pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
						
						pv1.getPv12_PatientClass().setValue(patientTypeFinal);

						pv1.getPv13_AssignedPatientLocation().getRoom().setValue(roomType);
						if(visit.getDoctor() !=null){
						pv1.getPv18_ReferringDoctor(0).getIDNumber().setValue(visit.getDoctor().getId().toString());
						pv1.getPv18_ReferringDoctor(0).getFamilyName().setValue(visit.getDoctor().getFirstName());
					}
					}
				}else if (patientType.equalsIgnoreCase("In Patient")) {
					
					List<Inpatient> inpatList = new ArrayList<Inpatient>();
					inpatList=session.createCriteria(Inpatient.class)
						.add(Restrictions.eq("Hin.Id",patient.getId())).list();
					Inpatient inpat = (Inpatient) inpatList.get(0);
					patientTypeFinal="I";
					String inpatient_id = inpat.getId().toString();
					pv1.getPv119_VisitNumber().getID().setValue(inpatient_id);
					vistIdAndPatient=inpat.getId().toString();
					roomType ="";
					if(inpat.getDateOfAddmission() != null || inpat.getTimeOfAddmission() != null)
					{
						DOA = inpat.getDateOfAddmission();
						TOA = inpat.getTimeOfAddmission();

						TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
						//TOA =  TOA.substring(0, 4).concat(TOA.substring(5));

						doa_val = HMSUtil.convertDateTypeToStringWithoutTime(DOA);
						adtym = adtym.concat(doa_val).concat(TOA);
						pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
						
						pv1.getPv12_PatientClass().setValue(patientTypeFinal);

						pv1.getPv13_AssignedPatientLocation().getRoom().setValue(roomType);
						pv1.getPv18_ReferringDoctor(0).getIDNumber().setValue(inpat.getDoctor().getId().toString());
						pv1.getPv18_ReferringDoctor(0).getFamilyName().setValue(inpat.getDoctor().getFirstName());
					}
				}*/
				String mshPidPv1A02="";
				// Now, let's encode the message and look at the output
				char BeginFormat = (char)0x0B;
				//char EndFormat1 = (char)0x1C;
				char EndFormat2 = (char)0x0D;

				Parser p1 = new PipeParser();
				String encodedMessage = p1.encode(adt4);

				String[] mainStr=encodedMessage.split("PID");
				String mshStr=mainStr[0].trim();
				String pidAndPv1Str=mainStr[1].trim();
				String[] mainStr2=pidAndPv1Str.split("PV1");
				String pidStr="PID"+mainStr2[0].trim();
				String pv1Str="PV1";
				
				mshPidPv1A02=BeginFormat+mshStr+"\r"+pidStr+"\r"+pv1Str+EndFormat2;
				
				List<TransactionSequence> regNoList = new ArrayList<TransactionSequence>();
				int regNo = 0;
				String regSeqNo = "";
				regNoList = session.createCriteria(TransactionSequence.class)
							.add(Restrictions.eq("TransactionPrefix", "REG"))
							//.add(Restrictions.eq("Hospital.Id", 1))
							.list();
				
				if (regNoList.size() > 0) {
					//	for (TransactionSequence transactionSequence : adNoList) {
					TransactionSequence transactionSequence = new TransactionSequence();
					transactionSequence = regNoList.get(0);
					int id = transactionSequence.getId();
					int seqNo = transactionSequence.getTransactionSequenceNumber();
					TransactionSequence transactionSequenceObj = new TransactionSequence();
					transactionSequenceObj = (TransactionSequence) session.load(TransactionSequence.class, id);
					regNo = seqNo+1;
					transactionSequenceObj.setTransactionSequenceNumber(regNo);
					try {
						session.update(transactionSequenceObj);
						session.flush();
						session.refresh(transactionSequenceObj);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (regNoList.size() == 0) {
					TransactionSequence tsObj = new TransactionSequence();
					tsObj.setStatus("y");
					tsObj.setTablename("Patient");
					tsObj.setTransactionPrefix("REG");
					tsObj.setTransactionSequenceName("Reg");
					tsObj.setTransactionSequenceNumber(0);
					tsObj.setCreatedby("jktuser");
					tsObj.setStatus("y");
					hbt.save(tsObj);
				}
				regSeqNo = String.valueOf(regNo);

			Hl7Message hl7Message2 =new Hl7Message();
			hl7Message2.setServiceNo(patient.getServiceNo());
			hl7Message2.setHinNo(patient.getHinNo());
			hl7Message2.setMainMessage(mshPidPv1A02);
			hl7Message2.setMsgNo(regSeqNo);
			hl7Message2.setMsgType("A04");
			session.save(hl7Message2);
			
			Patient patHin = new Patient();
			patHin = (Patient)session.load(Patient.class, patient.getId());
			patHin.setHL7Flag(regSeqNo);
			session.merge(patHin);
	}
			tx.commit();
			//-------------For lab Message---
		
		//List<DgOrderdt> orderDtList = new ArrayList<DgOrderdt>();
			/*String query = "SELECT * FROM dg_orderhd dg left outer join dg_orderdt dt on dt.orderhd_id = dg.orderhd_id "+
			" left outer join  patient p on  p.hin_id = dg.hin_id  "+
			" left outer join mas_administrative_sex sexid on sexid.administrative_sex_id  = p.sex_id "+
			" left outer join  mas_employee emp on dg.prescribed_by = emp.employee_id "+
			" left outer join inpatient inp on dg.inpatient_id = inp.inpatient_id "+
			" left outer join mas_charge_code mcc on dt.charge_code_id = mcc.charge_code_id "+
			" left outer join visit v on dg.visit_id= v.visit_id "+
			" left outer join mas_department dept on v.department_id= dept.department_id "+
			"left outer join mas_department deptInv on inp.department_id= deptInv.department_id "+
			" WHERE dt.HL7_flag is null";
			orderDtList = session.createSQLQuery(query).list();*/
	//	orderDtList=session.createCriteria(DgOrderdt.class).add(Restrictions.isNull("HL7Flag")).list();
			List<DgResultEntryDetail> resultDtList = new ArrayList<DgResultEntryDetail>();
			resultDtList=session.createCriteria(DgResultEntryDetail.class).add(Restrictions.isNull("HL7Flag")).list();
			for(DgResultEntryDetail resultDt:resultDtList)
				{
				Transaction txp=null;
				txp = session.beginTransaction();
					int accessionNo = resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getId();
					System.out.println("result_dt ---id-----"+accessionNo);
					int mainChargeCodeId = resultDt.getSampleCollectionDetails().getOrderdt().getMainChargecode().getId();
				//String mainQuery = "select main_chargecode_name from mas_main_chargecode where main_chargecode_id = "+mainChargeCodeId;
				String mainQueryRaidio="";
				/*mainQueryRaidio="select main_chargecode_name from mas_main_chargecode mmc left outer join mas_department dept on dept.department_id= mmc.department_id"+ 
				" left outer join mas_department_type deptType on deptType.department_type_id= dept.department_type_id where mmc.main_chargecode_id = "+mainChargeCodeId;
				chargeCodeList = session.createSQLQuery(mainQueryRaidio).list();*/
				List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
				chargeCodeList=session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("MainChargecode.Id",mainChargeCodeId)).list();
				String mshPidPv1OrcOb="";
				/*for(MasChargeCode chargeCode:chargeCodeList)
				{*/
				String mainCName = resultDt.getSampleCollectionDetails().getOrderdt().getMainChargecode().getMainChargecodeName();
				System.out.println("mainCName----"+mainCName);
				/*if(mainCName.equalsIgnoreCase("XRAY") || mainCName.equalsIgnoreCase("ULTRASOUND")
			  || mainCName.equalsIgnoreCase("CT SCAN") || mainCName.equalsIgnoreCase("MRI"))
		   	  {*/
				//Start creating message
				ca.uhn.hl7v2.model.v23.message.ADT_A01 adt1 = new ca.uhn.hl7v2.model.v23.message.ADT_A01();
				ORU_R01 message1 = new ORU_R01();

				message1.getMSH().getEncodingCharacters().setValue("^~\\&");
				message1.getMSH().getFieldSeparator().setValue("|");
				//ORU_R01_ORDER_OBSERVATION orderObservation = message1.getPATIENT_RESULT().getORDER_OBSERVATION();
				ORU_R01_ORDER_OBSERVATION orderObservation = message1.getRESPONSE().getORDER_OBSERVATION();
				//ORU_R01_ORDER_OBSERVATION orderObservation = null;//= message1.getDSC().getContinuationPointer().

				// Populate the MSH Segment

				MSH mshSegment = adt1.getMSH();
				mshSegment.getMsh1_FieldSeparator().setValue("|");
				mshSegment.getMsh2_EncodingCharacters().setValue("^~\\&");
				//mshSegment.getMsh3_SendingApplication().setValue("HMS");
				mshSegment.getMsh3_SendingApplication().getHd1_NamespaceID().setValue("HMS");
				//mshSegment.getMsh4_SendingFacility().setValue("RIH");
				//mshSegment.getMsh5_ReceivingApplication().setValue("EKG");
				mshSegment.getMsh5_ReceivingApplication().getHd1_NamespaceID().setValue("ORDER");

				//mshSegment.getMsh6_ReceivingFacility().setValue("EKG");
				mshSegment.getMsh7_DateTimeOfMessage().getTimeOfAnEvent().setValue(HMSUtil.convertDateTypeToStringWithoutTime(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getOrderDate())
						+ (resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getOrderTime()));
				mshSegment.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ORM");
				mshSegment.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("O01");
				
				 
				//mshSegment.getMsh10_MessageControlID().setValue("1001");
				mshSegment.getMsh10_MessageControlID().setValue(""+accessionNo);
				mshSegment.getMsh11_ProcessingID().getProcessingMode().setValue("P");
				mshSegment.getMsh12_VersionID().setValue(adt1.getVersion());

				DOB = resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getHin().getDateOfBirth();
				String abc ="";
				if(DOB!=null){
					abc = HMSUtil.changeDateToddMMyyyy(DOB);
				}
				// Populate the PID Segment
				PID pid = adt1.getPID();
				pid.getPid3_PatientIDInternalID(0).getID().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getHin().getId().toString());
				//pid.getPid4_AlternatePatientID().getID().setValue(res.getString("hin_id"));
				pid.getPid5_PatientName().getFamilyName().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getHin().getPLastName());
				pid.getPid5_PatientName().getMiddleInitialOrName().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getHin().getPMiddleName());
				pid.getPid5_PatientName().getGivenName().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getHin().getPFirstName());
				pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(abc);
				pid.getPid8_Sex().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getHin().getSex().getAdministrativeSexCode());

				PV1 pv1 = adt1.getPV1();
				String patientType=resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getPatientType();
				String patientTypeFinal="";
				String vistIdAndPatient="";
				String roomType="";
				System.out.println("patientType----"+patientType);
				if(patientType.equalsIgnoreCase("OP")){
					
					patientTypeFinal="O";
					if(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getVisit() !=null){
					String visitId = resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getVisit().getId().toString();
					pv1.getPv119_VisitNumber().getID().setValue(visitId);
					vistIdAndPatient=resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getVisit().getId().toString();
					roomType =resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getDepartment().getDepartmentName();
					if(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getVisit().getVisitDate() != null || 
							resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getVisit().getVisitTime() != null)
					{
						DOA = resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getVisit().getVisitDate();
						TOA = resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getVisit().getVisitTime();

						TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
					//	TOA =  TOA.substring(0, 4).concat(TOA.substring(5));

						doa_val = HMSUtil.convertDateTypeToStringWithoutTime(DOA);
						adtym = adtym.concat(doa_val).concat(TOA);
						pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
					}
					}
				}else if (patientType.equalsIgnoreCase("IP")) {
					patientTypeFinal="I";
					if(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getInpatient() !=null){
					String inpatient_id = resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getInpatient().getId().toString();
					pv1.getPv119_VisitNumber().getID().setValue(inpatient_id);
					vistIdAndPatient=resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getInpatient().getId().toString();
					roomType =resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getDepartment().getDepartmentName();
					if(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getInpatient().getDateOfAddmission() != null ||
							resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getInpatient().getTimeOfAddmission() != null)
					{
						DOA = resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getInpatient().getDateOfAddmission();
						TOA = resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getInpatient().getTimeOfAddmission();

						TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
						//TOA =  TOA.substring(0, 4).concat(TOA.substring(5));

						doa_val =HMSUtil.convertDateTypeToStringWithoutTime(DOA);
						adtym = adtym.concat(doa_val).concat(TOA);
						pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
					}
				}
				}
				pv1.getPv12_PatientClass().setValue(patientTypeFinal);
				pv1.getPv13_AssignedPatientLocation().getRoom().setValue(roomType);
				if(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getPrescribedBy() !=null){
				pv1.getPv18_ReferringDoctor(0).getIDNumber().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getPrescribedBy().getId().toString());
				pv1.getPv18_ReferringDoctor(0).getFamilyName().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getPrescribedBy().getLastName());
				pv1.getPv18_ReferringDoctor(0).getGivenName().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getPrescribedBy().getFirstName());
				}
				ORC orc = orderObservation.getORC();
				orc.getOrc1_OrderControl().setValue("NW");      
				
				//orc.getOrc2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue("1001");
				 
				//orc.getOrc2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue(""+accessionNo);

				orc.insertOrc2_PlacerOrderNumber(0).getEi1_EntityIdentifier().setValue(""+accessionNo);
				orc.getOrc5_OrderStatus().setValue("SC");             // ( = In Progress Scheduled)
				orc.getDateTimeOfTransaction().getTs1_TimeOfAnEvent().setValue(HMSUtil.convertDateTypeToStringWithoutTime(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getOrderDate()));
				
				orc.getOrc10_EnteredBy().getIDNumber().setValue("1234"); //Order Entry Person (ID)
				 
				if(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getPrescribedBy() !=null){
				orc.getOrc10_EnteredBy().getIDNumber().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getPrescribedBy().getId().toString()); //Order Entry Person (ID)
				//orc.getOrc10_EnteredBy().getCn2_FamilyName().setValue("Abhi Gupta"); //Order Entry Person (Name)
				orc.getOrc10_EnteredBy().getFamilyName().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getPrescribedBy().getLastName());
				orc.getOrc10_EnteredBy().getGivenName().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getPrescribedBy().getFirstName());
				orc.getOrc10_EnteredBy().getMiddleInitialOrName().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getPrescribedBy().getMiddleName());
				}
				// Populate the OBR
				ca.uhn.hl7v2.model.v23.segment.OBR obr = orderObservation.getOBR();
				//obr.getObr2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue("1001");
				 
				obr.insertObr2_PlacerOrderNumber(0).getEi1_EntityIdentifier().setValue(""+accessionNo);


				obr.getObr3_FillerOrderNumber().getEi1_EntityIdentifier().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getOrderNo());

				obr.getObr3_FillerOrderNumber().getEi2_NamespaceID().setValue(vistIdAndPatient);
				obr.getObr3_FillerOrderNumber().getEi3_UniversalID().setValue(patientTypeFinal);
				obr.getObr4_UniversalServiceIdentifier().getCe1_Identifier().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getChargeCode().getChargeCodeCode());
				obr.getObr4_UniversalServiceIdentifier().getCe2_Text().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getChargeCode().getChargeCodeName());
				//obr.getObr7_ObservationDateTime().getTs1_TimeOfAnEvent().setValue(DateUtils.now("yyyyMMdd")+DateUtils.now("Hmmss"));
				obr.getObr7_ObservationDateTime().getTs1_TimeOfAnEvent().setValue(HMSUtil.convertDateTypeToStringWithoutTime(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getOrderDate()));
				obr.getObr13_RelevantClinicalInformation().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getClinicalNote());

				if(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getPrescribedBy() !=null){
				obr.getObr16_OrderingProvider(0).getIDNumber().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getPrescribedBy().getId().toString());
				obr.getObr16_OrderingProvider(0).getFamilyName().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getPrescribedBy().getLastName());
				obr.getObr16_OrderingProvider(0).getGivenName().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getPrescribedBy().getFirstName());
				obr.getObr16_OrderingProvider(0).getMiddleInitialOrName().setValue(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getPrescribedBy().getMiddleName());
				//obr.getObr16_OrderingProvider().getCn3_GivenName().setValue(res.getString("first_name").concat(res.getString("last_name")));
				}
				obr.getObr24_DiagnosticServiceSectionID().setValue(mainCName);

				obr.getObr36_ScheduledDateTime().getTs1_TimeOfAnEvent().setValue(HMSUtil.convertDateTypeToStringWithoutTime(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getOrderDate())
						);
				//Order Scheduling Details (will not be present if HIS does not have scheduling engine

				// Now, let's encode the message and look at the output
				char BeginFormat = (char)0x0B;
				//char EndFormat1 = (char)0x1C;
				char EndFormat2 = (char)0x0D;

				Parser p1 = new PipeParser();
				String encodedMessage = p1.encode(adt1);

				String[] mainStr=encodedMessage.split("PID");
				String mshStr=mainStr[0].trim();
				String pidAndPv1Str=mainStr[1].trim();
				String[] mainStr2=pidAndPv1Str.split("PV1");
				String pidStr="PID"+mainStr2[0].trim();
				String pv1Str="PV1"+mainStr2[1].trim();

				String encMsg = p1.encode(message1);
				String newString = encMsg.substring(8);
				String[] mainStringORCAndOBR=newString.split("OBR");
				String orcStr="";
				String obrStr="OBR";
				orcStr=mainStringORCAndOBR[0].trim();
				obrStr="OBR"+mainStringORCAndOBR[1].trim();
				
//------------------------
				mshPidPv1OrcObr=BeginFormat+mshStr+"\r"+pidStr+"\r"+pv1Str+"\r"+orcStr+"\r"+obrStr+EndFormat2;
			//	mshPidPv1OrcObr=BeginFormat+mshStr+"\r"+pidStr+"\r"+pv1Str+"\r"+orcStr+"\r"+obrStr+EndFormat2;
				System.out.println("final msg--------> "+mshPidPv1OrcObr);
				
				List<TransactionSequence> orderNoList = new ArrayList<TransactionSequence>();
				Integer orderNo = 0;
				String orderSeqNo = "";
				orderNoList = session.createCriteria(TransactionSequence.class)
							.add(Restrictions.eq("TransactionPrefix", "OR"))
							//.add(Restrictions.eq("Hospital.Id", 1))
							.list();
				
				if (orderNoList.size() > 0) {
					//	for (TransactionSequence transactionSequence : adNoList) {
					TransactionSequence transactionSequence = new TransactionSequence();
					transactionSequence = orderNoList.get(0);
					int id = transactionSequence.getId();
					int seqNo = transactionSequence.getTransactionSequenceNumber();
					System.out.println("seqNo--->"+seqNo);
					TransactionSequence transactionSequenceObj = new TransactionSequence();
					transactionSequenceObj = (TransactionSequence) session.load(TransactionSequence.class, id);
					orderNo = seqNo+1;
					System.out.println("orderNo-Seq--After Increment--->"+orderNo);
					transactionSequenceObj.setTransactionSequenceNumber(orderNo);
					try {
						session.update(transactionSequenceObj);
						System.out.println("after update");
						session.flush();
						session.refresh(transactionSequenceObj);
						System.out.println("after refresh");
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (orderNoList.size() == 0) {
					TransactionSequence tsObj = new TransactionSequence();
					tsObj.setStatus("y");
					tsObj.setTablename("DgOrderdt");
					tsObj.setTransactionPrefix("OR");
					tsObj.setTransactionSequenceName("Or");
					tsObj.setTransactionSequenceNumber(0);
					tsObj.setCreatedby("jktuser");
					tsObj.setStatus("y");
					hbt.save(tsObj);
				}
				orderSeqNo = String.valueOf(orderNo);
System.out.println("orderSeqNo---For tran Seq------>"+orderSeqNo);
			Hl7Message hl7MessageOrder =new Hl7Message();
			hl7MessageOrder.setServiceNo(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getHin().getServiceNo());
			hl7MessageOrder.setHinNo(resultDt.getSampleCollectionDetails().getOrderdt().getOrderhd().getHin().getHinNo());
			hl7MessageOrder.setMainMessage(mshPidPv1OrcObr);
			hl7MessageOrder.setMsgNo(orderSeqNo);
			hl7MessageOrder.setMsgType("ORU");
			session.save(hl7MessageOrder);
			System.out.println("orderSeqNo---of hl7 message ----final----->"+orderSeqNo);
			
			DgResultEntryDetail resultOrderdt = new DgResultEntryDetail();
			resultOrderdt = (DgResultEntryDetail)session.load(DgResultEntryDetail.class, resultDt.getId());
			resultOrderdt.setHL7Flag(orderSeqNo);
			session.merge(resultOrderdt);
			
			System.out.println("---end of for loop oreder dt---");
		//}
			//}
				txp.commit();
		}			
			
			//------------End of lab Message
		
			/**/
				//------------Patient Prescription-------
			/*	List<PatientPrescriptionDetails> patientPrescList = new ArrayList<PatientPrescriptionDetails>();
				patientPrescList=session.createCriteria(PatientPrescriptionDetails.class)
						.add(Restrictions.isNull("HL7Flag")).list();
	           System.out.println("patientPrescList---22--->"+patientPrescList.size());
					for(PatientPrescriptionDetails prescriptionDetails:patientPrescList){
					Transaction txpp=null;
					txpp = session.beginTransaction();
					 ca.uhn.hl7v2.model.v25.message.RDE_O11 rde1 = new ca.uhn.hl7v2.model.v25.message.RDE_O11();
					 rde1.getMSH().getEncodingCharacters().setValue("^~\\&");
					 rde1.getMSH().getFieldSeparator().setValue("|");
					 
					 ca.uhn.hl7v2.model.v25.segment.MSH mshSegment = rde1.getMSH();
						mshSegment.getMsh1_FieldSeparator().setValue("|");
						mshSegment.getMsh2_EncodingCharacters().setValue("^~\\&");
						//mshSegment.getMsh3_SendingApplication().setValue("HMS");
						mshSegment.getMsh3_SendingApplication().getHd1_NamespaceID().setValue("HMS");
						//mshSegment.getMsh4_SendingFacility().setValue("RIH");
						//mshSegment.getMsh5_ReceivingApplication().setValue("EKG");
						mshSegment.getMsh5_ReceivingApplication().getHd1_NamespaceID().setValue("PHARMACY");

					
						//mshSegment.getMsh6_ReceivingFacility().setValue("EKG");
						mshSegment.getMsh7_DateTimeOfMessage().getTime().setValue(new Date()+ time);
						mshSegment.getMsh9_MessageType().getMsg1_MessageCode().setValue("PHA");
						mshSegment.getMsh9_MessageType().getMsg2_TriggerEvent().setValue("RDE_O01");
						
						 
				//      +mshSegment.getMsh10_MessageControlID().setValue("1001");
						mshSegment.getMsh10_MessageControlID().setValue(prescriptionDetails.getPrescription().getHin().getServiceNo());
						mshSegment.getMsh11_ProcessingID().getProcessingMode().setValue("P");
				//		mshSegment.getMsh12_VersionID().setValue(rde1.getVersion());

						DOB = prescriptionDetails.getPrescription().getHin().getDateOfBirth();
						String abc ="";
						if(DOB!=null){
							abc = HMSUtil.changeDateToddMMyyyy(DOB);
						}
						// Populate the PID Segment
						ca.uhn.hl7v2.model.v25.segment.PID pid = rde1.getPATIENT().getPID();
						pid.getPid3_PatientIdentifierList(0).getIDNumber().setValue(prescriptionDetails.getPrescription().getHin().getId().toString());
						//pid.getPid4_AlternatePatientID().getID().setValue(res.getString("hin_id"));
						
						pid.getPid5_PatientName().setValue(prescriptionDetails.getPrescription().getHin().getPLastName()); 
						prescriptionDetails.getPrescription().getHin().getPid5_PatientName().getMiddleInitialOrName().setValue(patient.getPMiddleName());
						pid.getPid5_PatientName().getGivenName().setValue(prescriptionDetails.getPrescription().getHin().getPFirstName());
						
						
						pid.getPid7_DateTimeOfBirth().getTs1_Time().setValue(abc);
						pid.getPid8_AdministrativeSex().setValue(prescriptionDetails.getPrescription().getHin().getSex().getAdministrativeSexCode());

						ca.uhn.hl7v2.model.v25.segment.RXE rxe = rde1.getORDER().getRXE();
						
						// Now, let's encode the message and look at the output
						char BeginFormat = (char)0x0B;
						//char EndFormat1 = (char)0x1C;
						char EndFormat2 = (char)0x0D;

						Parser p2 = new PipeParser();
						String encodedMessage = p2.encode(rde1);
						String[] mainStrr=encodedMessage.split("PID");
						String mshStrr=mainStrr[0].trim();
						String pidStrr=mainStrr[1].trim();
					//	String[] mainStr22=pidAndNk1Strr.split("NK1");
					//  String pidStrr="PID"+mainStr22[0].trim();
	 //------------------------
						mshPidPv1=BeginFormat+mshStrr+"\r"+pidStrr+EndFormat2;
						
					//	mshPidPv1OrcObr=BeginFormat+mshStr+"\r"+pidStr+"\r"+pv1Str+"\r"+orcStr+"\r"+obrStr+EndFormat2;
						System.out.println("mshPidPv1--22----> "+mshPidPv1);
						List<TransactionSequence> pharNoList = new ArrayList<TransactionSequence>();
						int pharNo = 0;
						String pharSeqNo = "";
							pharNoList = session.createCriteria(TransactionSequence.class)
									.add(Restrictions.eq("TransactionPrefix", "PH"))
									//.add(Restrictions.eq("Hospital.Id", 1))
									.list();
						
						if (pharNoList.size() > 0) {
							for (TransactionSequence transactionSequence : pharNoList) {
								int id = transactionSequence.getId();
								int seqNo = transactionSequence.getTransactionSequenceNumber();
								TransactionSequence transactionSequenceObj = (TransactionSequence) session
										.load(TransactionSequence.class, id);
								pharNo = ++seqNo;
								transactionSequenceObj.setTransactionSequenceNumber(pharNo);
								hbt.update(transactionSequenceObj);
							}
						} else if (pharNoList.size() == 0) {
							TransactionSequence tsObj = new TransactionSequence();
							tsObj.setStatus("y");
							tsObj.setTablename("PatientPrescriptionDetails");
							tsObj.setTransactionPrefix("PH");
							tsObj.setTransactionSequenceName("Pha");
							tsObj.setTransactionSequenceNumber(0);
							tsObj.setCreatedby("jktuser");
							tsObj.setStatus("y");
							hbt.save(tsObj);
						}
						pharSeqNo = String.valueOf(pharNo);

					Hl7Message hl7MessagePre =new Hl7Message();
					hl7MessagePre.setServiceNo(prescriptionDetails.getPrescription().getHin().getServiceNo());
					hl7MessagePre.setHinNo(prescriptionDetails.getPrescription().getHin().getHinNo());
					hl7MessagePre.setMainMessage(mshPidPv1);
					hl7MessagePre.setMsgNo(pharSeqNo);
					
					HibernateTemplate hbtt = getHibernateTemplate();
					hbtt.setFlushModeName("FLUSH_EAGER");
					hbtt.setCheckWriteOperations(false);
					hl7MessagePre.setMsgType("RDE_O01");
					
					hbtt.save(hl7MessagePre);
					
					PatientPrescriptionDetails patPresDetail = new PatientPrescriptionDetails();
					patPresDetail = (PatientPrescriptionDetails)session.load(PatientPrescriptionDetails.class, prescriptionDetails.getId());
					patPresDetail.setHL7Flag(pharSeqNo);
					hbt.merge(patPresDetail);
						
					txpp.commit();
				
				}*/
	//------------------------
			saveOrUpdate=true;
			
		} catch (DataTypeException e) {
				if (tx != null)
				tx.rollback();
				e.printStackTrace();
		} catch (HL7Exception e) {
			
			e.printStackTrace();
		}
		return saveOrUpdate;
	
}

	@Override
	public Map<String, Object> getIcdId(String icdNo) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> icdIdList = new ArrayList<Integer>();
		icdIdList = session.createCriteria(MasIcd.class).add(Restrictions.eq("IcdCode", icdNo)).setProjection(Projections.property("Id")).list();
		map.put("icdIdList", icdIdList);
		return map;
	}
	
	public Map<String, Object> checkPopUpForReg(
			Map<String, Object> parameterMap) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		/*List<Patient> patientList = new ArrayList<Patient>();*/
		List<Patient> patientListForInfo = new ArrayList<Patient>();
		List<Patient> patientListForInfoHIS = new ArrayList<Patient>();
		int relationId = 0;
		int serviceTypeId = 0;
		int serviceStatusId = 0;
		String serviceNo = "";
		String patientName = "";
		Session session = (Session) getSession();
		if (parameterMap.get("serviceTypeId") != null) {
			serviceTypeId = (Integer) parameterMap.get("serviceTypeId");
		}
		if (parameterMap.get("serviceStatusId") != null) {
			serviceStatusId = (Integer) parameterMap.get("serviceStatusId");
		}
		if (parameterMap.get("relationId") != null) {
			relationId = (Integer) parameterMap.get("relationId");
		}
		if (parameterMap.get("serviceNo") != null) {
			serviceNo = (String) parameterMap.get("serviceNo");
		}
		
		try {
			
			List objectList = new ArrayList();
			String relQry = " SELECT mr.Id FROM MasRelation  mr where mr.RelationCode in (select mr1.RelationCode from MasRelation  mr1 where mr1.Id="+relationId+")";
			objectList = (List) session.createQuery(relQry).list();
			
			String aa="";
			for(int i=0;i<objectList.size();i++)
			{
				if(aa.equalsIgnoreCase("")) 
				{
					aa+=objectList.get(i);
				}
				else
				{
					aa+=","+objectList.get(i);
				}
				
				
			}
			
			
			patientListForInfo = session.createCriteria(Patient.class).add(
						Restrictions.eq("ServiceNo", serviceNo)).add(Restrictions.isNull("PreviousHinNo"))
						.createAlias("ServiceType", "ST").add(Restrictions.eq("ST.Id", serviceTypeId))
						.createAlias("ServiceStatus", "SS").add(Restrictions.eq("SS.Id", serviceStatusId))
						.createAlias("Relation","Re").add(Restrictions.in("Re.Id", objectList)).list();
			
			String query="select pp.HIN_ID,pp.service_no,pp.service_type_id,pp.relation_id,pp.hin_no,pp.rank_id," +
					"pp.unit_id,pp.title_id,pp.p_first_name,pp.p_middle_name,pp.p_last_name,pp.trade_id,pp.service_years,pp.religion_id," +
					"pp.inpatient_no,pp.trade_name,pp.service_status_id from his.patient pp where pp.service_no='"+serviceNo+
					"' and pp.service_type_id="+serviceTypeId+
					"and pp.service_status_id="+serviceStatusId + 
					"and pp.relation_id in ("+aa+") and pp.previous_hin_no is null";
		
			patientListForInfoHIS = (List) session.createSQLQuery(query).list();
			
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	
		detailMap.put("patientListForInfo", patientListForInfo);
		detailMap.put("patientListForInfoHIS", patientListForInfoHIS);
		return detailMap;
	}
	
	public Map<String, Object> checkPopUpForRegHAL(
			Map<String, Object> parameterMap) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		/*List<Patient> patientList = new ArrayList<Patient>();*/
		List<Patient> patientListForInfo = new ArrayList<Patient>();
		List<Patient> patientListForInfoHIS = new ArrayList<Patient>();
		int relationId = 0;
		int serviceTypeId = 0;
		int serviceStatusId = 0;
		String serviceNo = "";
		String patientName = "";
		Session session = (Session) getSession();
		if (parameterMap.get("serviceTypeId") != null) {
			serviceTypeId = (Integer) parameterMap.get("serviceTypeId");
		}
		if (parameterMap.get("serviceStatusId") != null) {
			serviceStatusId = (Integer) parameterMap.get("serviceStatusId");
		}
		if (parameterMap.get("relationId") != null) {
			relationId = (Integer) parameterMap.get("relationId");
		}
		if (parameterMap.get("serviceNo") != null) {
			serviceNo = (String) parameterMap.get("serviceNo");
		}
		
		try {
			
			List objectList = new ArrayList();
			String relQry = " SELECT mr.Id FROM MasRelation  mr where mr.RelationCode in (select mr1.RelationCode from MasRelation  mr1 where mr1.Id="+relationId+")";
			objectList = (List) session.createQuery(relQry).list();
			
			String aa="";
			for(int i=0;i<objectList.size();i++)
			{
				if(aa.equalsIgnoreCase("")) 
				{
					aa+=objectList.get(i);
				}
				else
				{
					aa+=","+objectList.get(i);
				}
				
				
			}
			
			
			patientListForInfo = session.createCriteria(Patient.class).add(
						Restrictions.eq("ServiceNo", serviceNo)).add(Restrictions.isNull("PreviousHinNo"))						
						.createAlias("Relation","Re").add(Restrictions.in("Re.Id", objectList)).list();
			
			String query="select pp.HIN_ID,pp.service_no,pp.service_type_id,pp.relation_id,pp.hin_no,pp.rank_id," +
					"pp.unit_id,pp.title_id,pp.p_first_name,pp.p_middle_name,pp.p_last_name,pp.trade_id,pp.service_years,pp.religion_id," +
					"pp.inpatient_no,pp.trade_name,pp.service_status_id from his.patient pp where pp.service_no='"+serviceNo+
					"'and pp.relation_id in ("+aa+") and pp.previous_hin_no is null";
		
			patientListForInfoHIS = (List) session.createSQLQuery(query).list();
			
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	
		detailMap.put("patientListForInfo", patientListForInfo);
		detailMap.put("patientListForInfoHIS", patientListForInfoHIS);
		return detailMap;
	}
	
	public Map<String, Object> getRelationListForServiceNo(
			Map<String, Object> parameterMap) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		/*List<Patient> patientList = new ArrayList<Patient>();*/
		List<Patient> patientListForInfo = new ArrayList<Patient>();
		//List<Patient> patientListForInfoHIS = new ArrayList<Patient>();
		List <Object[]> patientListForInfoHIS=new ArrayList<Object[]>();
		List<MasRelation> masRelationList = new ArrayList<MasRelation>();

		int relationId = 0;
		int serviceTypeId = 0;
		int serviceStatusId = 0;
		String serviceNo = "";
		String patientName = "";
		Session session = (Session) getSession();
		if (parameterMap.get("serviceTypeId") != null) {
			serviceTypeId = (Integer) parameterMap.get("serviceTypeId");
		}
		if (parameterMap.get("serviceStatusId") != null) {
			serviceStatusId = (Integer) parameterMap.get("serviceStatusId");
		}
		if (parameterMap.get("relationId") != null) {
			relationId = (Integer) parameterMap.get("relationId");
		}
		if (parameterMap.get("serviceNo") != null) {
			serviceNo = (String) parameterMap.get("serviceNo");
		}
		
		try {
			
			List objectList = new ArrayList();
			String relQry = " SELECT mr.Id FROM MasRelation  mr where mr.RelationCode in (select mr1.RelationCode from MasRelation  mr1 where mr1.Id="+relationId+")";
			objectList = (List) session.createQuery(relQry).list();
			
			String aa="";
			for(int i=0;i<objectList.size();i++)
			{
				if(aa.equalsIgnoreCase("")) 
				{
					aa+=objectList.get(i);
				}
				else
				{
					aa+=","+objectList.get(i);
				}
				
				
			}
			
			masRelationList=session.createCriteria(MasRelation.class).add(Restrictions.in("Id", objectList)).list();
			
			patientListForInfo = session.createCriteria(Patient.class).add(
						Restrictions.eq("ServiceNo", serviceNo)).add(Restrictions.isNull("PreviousHinNo"))
						.createAlias("ServiceType", "ST").add(Restrictions.eq("ST.Id", serviceTypeId))
						.createAlias("ServiceStatus", "SS").add(Restrictions.eq("SS.Id", serviceStatusId))
						.createAlias("Relation","Re").add(Restrictions.in("Re.Id", objectList)).list();
			/*session.createCriteria(Patient.class).add(
			Restrictions.eq("ServiceNo", serviceNo)).add(
			Restrictions.eq("ServiceType.Id", serviceTypeId)).add(
			Restrictions.eq("ServiceStatus.Id", serviceStatusId))*/
			String query="select pp.HIN_ID,pp.service_no,pp.service_type_id,pp.relation_id,pp.hin_no,pp.rank_id," +
					"pp.unit_id,pp.title_id,pp.p_first_name,pp.p_middle_name,pp.p_last_name,pp.DATE_OF_BIRTH,pp.trade_id,pp.service_years,pp.religion_id," +
					"pp.inpatient_no,pp.trade_name,pp.service_status_id,ml.relation_name from his.patient pp left join mas_relation ml on pp.relation_id=ml.relation_id where pp.service_no='"+serviceNo+
					"' and pp.service_type_id="+serviceTypeId+
					"and pp.service_status_id="+serviceStatusId + 
					"and pp.relation_id in ("+aa+") and pp.previous_hin_no is null";
			//System.out.println(query);
			patientListForInfoHIS = (List) session.createSQLQuery(query).list();
		}catch (HibernateException e){
			e.printStackTrace();
			session.close();
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		/*detailMap.put("patientList", patientList);*/
		detailMap.put("masRelationList", masRelationList);
		detailMap.put("patientListForInfo", patientListForInfo);
		detailMap.put("patientListForInfoHIS", patientListForInfoHIS);
		return detailMap;
	}
	
	public Map<String, Object> updateHinNo(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Box box = (Box) dataMap.get("box");
		Vector HinIdHIS = box.getVector("hinIdHIS");
		Vector HinIdHMS = box.getVector("hinIdHMS");
		Vector HinNoHMS = box.getVector("hinNoHMS");
		Vector HinNoHIS = box.getVector("hinNoHIS");
		String newHinNo="";
		int result=0;
		String syncHMS="no";
		String syncHIS="no";
		int relationIdForUpdate=0;
		
		List<Integer> hinidHISList = new ArrayList();
		List<Integer> hinidHMSList = new ArrayList();
		List<String> hinNoHISList = new ArrayList();
		List<String> hinNoHMSList = new ArrayList();
		if(dataMap.get("newHinNo")!=null && !dataMap.get("newHinNo").equals(""))
		{
			newHinNo=""+dataMap.get("newHinNo");
		}
		if(box.getInt("relationIdForUpdate")!=0)
		{
			relationIdForUpdate=box.getInt("relationIdForUpdate");
		}
	
		String saved = "no";
		try{
			//To get Hin IDS from Relation pop up Connected to prod_gndc
		for (int i = 0; i < HinIdHIS.size(); i++) {

			if(HinIdHIS.get(i)!=null && !HinIdHIS.get(i).equals(""))
			{
				hinidHISList.add(Integer.parseInt(HinIdHIS.get(i)+""));
			}
		 }
		//To get Hin iDS from relation pop up connected to HMS
		for (int i = 0; i < HinIdHMS.size(); i++) {

			if(HinIdHMS.get(i)!=null && !HinIdHMS.get(i).equals(""))
			{
				hinidHMSList.add(Integer.parseInt(HinIdHMS.get(i)+""));
			}
		 }
		//To get Hin No's from relation pop up connected to prod_gndc
		for (int i = 0; i < HinNoHIS.size(); i++) {

			if(HinNoHIS.get(i)!=null && !HinNoHIS.get(i).equals(""))
			{
				hinNoHISList.add((String)(HinNoHIS.get(i)+""));
			}
		 }
		//To get Hin No's from relation pop up connected to HMS
		for (int i = 0; i < HinNoHMS.size(); i++) {

			if(HinNoHMS.get(i)!=null && !HinNoHMS.get(i).equals(""))
			{
				hinNoHMSList.add((String)(HinNoHMS.get(i)+""));
			}
		 }
		
			if(hinidHISList.size()!=0 && hinidHISList!=null )
			{
				for(int i=0;i<hinidHISList.size();i++)
				{
					if(hinNoHISList.get(i)!=null && !hinNoHISList.get(i).equalsIgnoreCase("") && !hinNoHISList.get(i).equalsIgnoreCase("null"))
					{
						String Query = "Update his.patient pp" +
								" Set pp.hin_no='"+newHinNo+
								"',pp.previous_hin_no='"+hinNoHISList.get(i)+"',pp.relation_id="+relationIdForUpdate+" where pp.hin_id="+hinidHISList.get(i);
						result+= session.createSQLQuery(Query).executeUpdate();
						syncHIS="yes";
					}
					else
					{
						String Query = "Update his.patient pp" +
								" Set pp.hin_no='"+newHinNo+
								"',pp.previous_hin_no='"+newHinNo+"',pp.relation_id="+relationIdForUpdate+" where pp.hin_id="+hinidHISList.get(i);
						result+= session.createSQLQuery(Query).executeUpdate();
						syncHIS="yes";
					}
				  
				}
				
			
			}
			if(hinidHMSList.size()!=0 && hinidHMSList!=null && hinNoHMSList!=null && hinNoHMSList.size()!=0 )
			{
				
				for(int i=0;i<hinidHMSList.size();i++)
				{
					if(hinNoHMSList.get(i)!=null && !hinNoHMSList.get(i).equalsIgnoreCase("") && !hinNoHMSList.get(i).equalsIgnoreCase("null"))
					{
						String Query = "Update patient " +
								" Set hin_no='"+newHinNo+
								"', previous_hin_no='"+hinNoHMSList.get(i)+
								"', relation_id="+relationIdForUpdate+" where hin_id="+hinidHMSList.get(i);
						result+= session.createSQLQuery(Query).executeUpdate();
						syncHMS="yes";
					}
					else
					{
						String Query = "Update patient " +
								" Set hin_no='"+newHinNo+
								"', previous_hin_no='"+newHinNo+
								"', relation_id="+relationIdForUpdate+" where hin_id="+hinidHMSList.get(i);
						result+= session.createSQLQuery(Query).executeUpdate();
						syncHMS="yes";
					}
				
				}
			
			}
			if(result!=0)
			{
				saved="yes";
			}
		}
		catch (Exception e) {

			e.printStackTrace();
		
		}
	
		
		map.put("saved", saved);
		map.put("syncHIS", syncHIS);
		map.put("syncHMS", syncHMS);
		map.put("newHinNo", newHinNo);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getListOfPendingForApproval(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		List<Patient> patientList = new ArrayList<Patient>();		
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));
		
		String patientTypeNameForOther="";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			properties.load(resourcePath.openStream());			 
			patientTypeNameForOther=properties.getProperty("patientTypeNameForOther");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cr = session.createCriteria(Patient.class).createAlias("PatientType", "mpt")
				.add(Restrictions.eq("mpt.PatientTypeName", patientTypeNameForOther))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.isNull("Billable"));
		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		patientList = cr.list();
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+patientList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();
		
		
	
	
		map.put("patientList", patientList);		
		map.put("totalRecords", totalRecords);

				
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getListOfPatientVisitReferral(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		List<OpdPatientDetails> opdPatientDetailsList = new ArrayList<OpdPatientDetails>();		
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));
		
		String patientTypeNameForOther="";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			properties.load(resourcePath.openStream());			 
			patientTypeNameForOther=properties.getProperty("patientTypeNameForOther");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cr = session.createCriteria(OpdPatientDetails.class)
				.add(Restrictions.eq("ReferredStatus", "y").ignoreCase())
				.add(Restrictions.eq("ReferredType", "Internal").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.createAlias("Visit", "v")
				.createAlias("v.Hin", "p")
				.add(Restrictions.or(Restrictions.eq("p.Billable", "n").ignoreCase(), Restrictions.and(Restrictions.eq("p.Billable", "y").ignoreCase(),Restrictions.eq("p.PaymentStatus", "y").ignoreCase())));
		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		opdPatientDetailsList = cr.list();
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+opdPatientDetailsList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();
		
		
	
	
		map.put("opdPatientDetailsList", opdPatientDetailsList);		
		map.put("totalRecords", totalRecords);

				
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPendingOtherVisitJsp(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		List<Patient> patientList = new ArrayList<Patient>();	
		List<MasDepartment> departmentList = null;
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));
		
		
		String departmentTypeCodeForOpd="";
		String patientTypeNameForOther="";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			properties.load(resourcePath.openStream());			 
			patientTypeNameForOther=properties.getProperty("patientTypeNameForOther");
			departmentTypeCodeForOpd=properties.getProperty("departmentTypeCodeForOpd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cr = session.createCriteria(Patient.class).createAlias("PatientType", "mpt")
				.add(Restrictions.eq("mpt.PatientTypeName", patientTypeNameForOther))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.or(Restrictions.isNull("VisitCreated"), Restrictions.eq("VisitCreated", "n")))
				.add(Restrictions.or(Restrictions.eq("Billable", 'n').ignoreCase(), Restrictions.and(Restrictions.eq("Billable", 'y').ignoreCase(),Restrictions.eq("PaymentStatus", 'y').ignoreCase())));
		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		patientList = cr.list();
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+patientList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();
		
		
		departmentList=session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.eq("dt.DepartmentTypeCode", departmentTypeCodeForOpd))
				.addOrder(Order.asc("DepartmentName"))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.list();
	
		map.put("departmentList", departmentList);
		map.put("patientList", patientList);		
		map.put("totalRecords", totalRecords);

				
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showOtherVisitJsp(int hospitalId) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> serviceTypeList = null;
		List<Object[]> relationList = null;
		List<Object[]> rankList = null;
		List<Object[]> unitList = null;
		List<Object[]> titleList = null;
		List<Object[]> maritalStatusList = null;
		List<Object[]> tradeList = null;
	//	List<Object[]> countryList = null;
		List<Object[]> stateList = null;
		List<Object[]> districtList = null;
		List<Object[]> bloodGroupList = null;
		List<Object[]> occupationList = null;
		List<Object[]> employeeList = null;
		List<Object[]> sexList = null;
		List<Object[]> serviceStatusList = null;
		List<Object[]> stationList = null;
		List<Object[]> sectionList = null;
		List<Object[]> commandList = null;
		List<MasRecordOfficeAddress> recordOfficeAddressList = null;
		List<Object[]> religionList = null;
		List<PatientFamilyHistory> familyHistoryList = null;
		List<Object[]> categoryList = null;
		List<MasDepartment> departmentList = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String departmentTypeCodeForOpd="";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			properties.load(resourcePath.openStream());			 
			departmentTypeCodeForOpd=properties.getProperty("departmentTypeCodeForOpd");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			serviceTypeList = hbt.find("select Id,ServiceTypeName from MasServiceType mst where mst.Status='y' order by ServiceTypeName");
			rankList = hbt.find("select Id,RankName,rank.ServiceType.Id, rank.ServiceStatus.Id,rank.HicCode from MasRank as rank  where rank.Status='y'  order by rank.RankName ");
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).createAlias("Station", "station",CriteriaSpecification.LEFT_JOIN).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))
							.add(Projections.property("station.StationName")).add(Projections.property("HicCode"))).addOrder(
					Order.asc("UnitName")).list();
			titleList = hbt.find("select Id,TitleName,TitleCode from MasTitle mt where mt.Status ='y' order by TitleName");
			maritalStatusList = hbt.find("select Id,MaritalStatusName,HicCode from MasMaritalStatus mms where mms.Status='y' order by mms.MaritalStatusName");
			tradeList =hbt.find("select Id,TradeName from MasTrade mt where mt.Status='y' order by mt.TradeName");
		//	countryList = hbt.find("from MasCountry mc where mc.Status='y'");
			stateList = hbt.find("select Id,StateName from MasState ms where ms.Status='y' order by StateName");
			districtList =hbt.find("select  Id, DistrictName,md.State.Id from MasDistrict as md  where md.Status='y' order by md.DistrictName ");
			relationList =hbt.find("select Id,NewRelationName from MasRelation as mr where mr.Status='y' order by NewRelationName");
			occupationList = hbt.find("select Id,OccupationName from MasOccupation as dist order by dist.OccupationName ");
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("EmpCategory", "ec",CriteriaSpecification.LEFT_JOIN).createAlias("Rank", "r")
							.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
							.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("FirstName")).add(Projections.property("MiddleName")).add(Projections.property("LastName"))
									.add(Projections.property("ec.EmpCategoryCode")).add(Projections.property("r.RankName"))
							.add(Projections.property("Department.Id")).add(Projections.property("RoomNo")))
							.addOrder(Order.asc("FirstName")).list();
			bloodGroupList = hbt.find("select Id,BloodGroupName,HicCode from MasBloodGroup as dist where dist.Status='y' order by dist.BloodGroupName");
			religionList = session.createCriteria(MasReligion.class).add(Restrictions.eq("Status", "y"))
					.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("ReligionName"))
							.add(Projections.property("HicCode")))
			.addOrder(Order.asc("ReligionName")).list();
			recordOfficeAddressList = session.createCriteria(MasRecordOfficeAddress.class).add(Restrictions.eq("Status", "y")).list();
			sexList = hbt.find("Select Id, AdministrativeSexName, AdministrativeSexCode,HicCode from MasAdministrativeSex mas where mas.Status='y' order by AdministrativeSexName");
			sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y"))
						.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
						.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("SectionName")))
						.addOrder(Order.asc("SectionName")).list();
			stationList = hbt.find("select Id,StationName,mas.Command.Id from MasStation mas where mas.Status='y' order by mas.StationName");
			commandList = hbt.find("select Id,CommandName from MasCommand mas where mas.Status='y' order by mas.CommandName");
			serviceStatusList = hbt.find("select Id,ServiceStatusName from MasServiceStatus mss where mss.Status='y' ");
			familyHistoryList = hbt.find("select Id,PatientHistoryName from PatientFamilyHistory mss where mss.Status='y' order by PatientHistoryName");
			categoryList = hbt.find("select Categoryid,Categories from Category c order by Categories");
			departmentList=session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.DepartmentTypeCode", departmentTypeCodeForOpd))
					.addOrder(Order.asc("DepartmentName"))
					.list();
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("departmentList", departmentList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("maritalStatusList", maritalStatusList);
		map.put("tradeList", tradeList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("sexList", sexList);
		map.put("titleList", titleList);
	//	map.put("countryList", countryList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("relationList", relationList);
		map.put("occupationList", occupationList);
		map.put("employeeList", employeeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("sectionList", sectionList);
		map.put("stationList", stationList);
		map.put("commandList", commandList);
		map.put("recordOfficeAddressList", recordOfficeAddressList);
		map.put("religionList", religionList);
		map.put("familyHistoryList", familyHistoryList);
		map.put("categoryList", categoryList);
		

		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getDepartmentList(int hospitalId) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = null;
		List<MasSession> sessionList = new ArrayList<MasSession>();
		String departmentTypeCodeForOpd="";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			properties.load(resourcePath.openStream());			 
			departmentTypeCodeForOpd=properties.getProperty("departmentTypeCodeForOpd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		departmentList=session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status","y").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.eq("dt.DepartmentTypeCode", departmentTypeCodeForOpd))
				.addOrder(Order.asc("DepartmentName"))
				.list();	
		sessionList = session.createCriteria(MasSession.class)
				.add(Restrictions.eq("Status","y").ignoreCase()).list();
		map.put("sessionList", sessionList);
        map.put("departmentList", departmentList);  
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getListOnlinePatients(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		List<AppPatientAppointments> aPAppointmentList = new ArrayList<AppPatientAppointments>();	
		List<DoctorRoaster> docRoasterList= new ArrayList<DoctorRoaster>();
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));
		
		String selfRelationName="";
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");

		try {
			properties.load(resourcePath.openStream());			 
			selfRelationName=properties.getProperty("selfRelationName");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int mrngSesId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "sessionIdForMrng"));
    	int evngSesId = Integer.parseInt(HMSUtil.getProperties("adt.properties", "sessionIdForEvng"));
		
		cr = session.createCriteria(AppPatientAppointments.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("AppointmentStatus", "y").ignoreCase())
		        .add(Restrictions.eq("AppointmentDate", new Date()));
		if(box.get("empNo")!=null && !box.getString("empNo").equalsIgnoreCase(""))
			cr = cr.add(Restrictions.eq("ServiceNo",box.getString("empNo")));
		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		aPAppointmentList = cr.list();
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+aPAppointmentList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();
		
		
		for(AppPatientAppointments apo: aPAppointmentList){
			
			apo.setServicePersonName(apo.getQueuePriority().toString());
			
    		Criteria crit =session.createCriteria(DoctorRoaster.class)
    		        /*.add(Restrictions.eq("v.VisitDate", dateString))*/
    				.add(Restrictions.eq("RoasterDate", apo.getAppointmentDate()))
    				.add(Restrictions.eq("Doctor.Id", apo.getEmployee().getId()))
    				//.add(Restrictions.eq("Hospital.Id", hospitalId))
    		        .createAlias("Department", "dept").add(Restrictions.eq("dept.Id", apo.getDepartment().getId()));
    		docRoasterList =crit.list();
    		
    		if(docRoasterList.size()>0)
    		{
    			if(apo.getAppSession().getId()==mrngSesId)
            		crit.add(Restrictions.like("RoasterValue", "y%"));
            	else if(apo.getAppSession().getId()==evngSesId)
            		crit.add(Restrictions.like("RoasterValue", "%y"));
            	docRoasterList =crit.list();
            	if(docRoasterList.size()==0)
            	{
            		apo.setServicePersonName("Doctor is on leave");  //inserted queue preority value in service_person_name column temporarly becaue queue priority type is int and it can't store string message
            	}
            	
    		}
    		else{
    			apo.setServicePersonName("Doctor Roaster is not updated");  //inserted queue preority value in service_person_name column temporarly becaue queue priority type is int and it can't store string message
    		}
    		
			
		}
		
	
	
		map.put("aPAppointmentList", aPAppointmentList);
		map.put("selfRelationName", selfRelationName);
		map.put("totalRecords", totalRecords);

				
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getOPDVisitList(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitList = new ArrayList<Visit>();
	    Criteria cr =null;		
		int hospitalId = box.getInt("hospitalId");
		int deptId = box.getInt("deptId");
		int doctorId = box.getInt("doctorId");
		int sesId = box.getInt("sesId");
		String visitstatus  =  box.getString("visitstatus");
     
		

		Date date = new Date();
		try {
	
			cr=session.createCriteria(Visit.class)
					.createAlias("Doctor", "doc",CriteriaSpecification.LEFT_JOIN)
					.createAlias("Session", "sess",CriteriaSpecification.LEFT_JOIN)
					.createAlias("Department", "dep",CriteriaSpecification.LEFT_JOIN)
					.createAlias("Hospital", "hosp",CriteriaSpecification.LEFT_JOIN);
					cr = cr.add(Restrictions.eq("VisitDate",date));
					cr = cr.addOrder(Order.asc("IntDoctor.Id")).addOrder(Order.asc("VisitTime"));
			if(doctorId != 0)
				cr = cr.add(Restrictions.eq("doc.Id",doctorId));
			if(deptId != 0)
				cr = cr.add(Restrictions.eq("dep.Id",deptId));
			if(sesId != 0)
				cr = cr.add(Restrictions.eq("sess.Id",sesId));
			
			String[] arr= {"w","c"};
			if(!visitstatus.equalsIgnoreCase("0"))
				cr = cr.add(Restrictions.eq("VisitStatus",visitstatus).ignoreCase());
			else
			{
				cr = cr.add(Restrictions.in("VisitStatus",arr));
			}
			
		
			
			visitList = cr.list();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("visitList", visitList);
		
		
		return map;
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public  Map<String, Object> transferPatientVisitList(
			Map<String, Object> objectMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean succesfullyAdded = false;
	     String msg="";
		Session session = (Session) getSession();
		MasEmployee emp = new MasEmployee();
		List<Integer> visitIdList = new ArrayList<Integer>();
		List<AppSetup> appSetupList = new ArrayList<AppSetup>();

		int hospitalId = (Integer)objectMap.get("hospitalId");
		System.out.println("hospitalId"+hospitalId);	
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Users user= new Users();
		if(objectMap.get("user")!=null){
			user = (Users)objectMap.get("user");
		}
		 Box box = (Box)objectMap.get("box");
	 
		Transaction tx = null;

		 int refereddoctor =	0;
		 int referdepartment =	0;
		 int referredsesId =	0;
	     int lastTokenNo =0;
	     int interval=0;
		 MasDepartment md = new MasDepartment();
		 MasSession ms = new MasSession();
	
		 Date date = new Date();

	String currentDay = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
			   int totalVisiCount = box.getInt("totalPatient");
			    refereddoctor =	box.getInt("refereddoctor");
				  referdepartment =	box.getInt("referdepartment");
				  referredsesId =	box.getInt("referredsesId");
				  MasDepartment masReferredDept= new MasDepartment();
				  masReferredDept.setId(referdepartment);
				  MasEmployee masReferredDoc =  new MasEmployee();
				  masReferredDoc.setId(refereddoctor);
				  MasSession masReferredSes =  new MasSession();
				  masReferredSes.setId(referredsesId);
				  
			 hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			session.clear();
			hbt.clear();
		Visit v =null;
		
			
			appSetupList = session.createCriteria(AppSetup.class).add(Restrictions.eq("Dept.Id", referdepartment))
					.add(Restrictions.eq("Doctor.Id", refereddoctor)).add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Session.Id", referredsesId)).add(Restrictions.eq("Days", currentDay))
					.list();
			
			if(appSetupList.size()>0)
			{
				interval = appSetupList.get(0).getTotalInterval();
				lastTokenNo = appSetupList.get(0).getStartToken()+(appSetupList.get(0).getTotalToken()-1)*interval;
			}
			System.out.println("totalVisiCount="+totalVisiCount);
			for (int i = 0; i < totalVisiCount; i++) {
				System.out.println("1="+i +" "+totalVisiCount +" fdf "+box.getString("transferRadio"+i) +" s "+box.getString("transferVisitId"+i));
				if( box.getString("transferRadio"+i)!=null &&  !box.getString("transferRadio"+i).equals(""))
				{
					if( box.getString("transferVisitId"+i)!=null &&  !box.getString("transferVisitId"+i).equals(""))
					{
						visitIdList.add(box.getInt("transferVisitId"+i));
					
					}
					
				}
			}
			
			System.out.println("lastTokenNo "+lastTokenNo);
		/*	  int doctorId =	Integer.parseInt(request.getParameter("consultingDoctor"+v));
			  int sessionId =	Integer.parseInt(request.getParameter("sessionId"+v));
			  int departmentId =	Integer.parseInt(request.getParameter("departmentId"+v));*/
			  //int priority =	Integer.parseInt(request.getParameter("priority"+v));
			HttpServletRequest request = (HttpServletRequest)objectMap.get("request");
		int i=0;
			for(int visitId : visitIdList)
			{
				v = (Visit)hbt.load(Visit.class, visitId);
				String token = getTokenNoForDepartment(refereddoctor, referredsesId, referdepartment, request);
				//System.out.println("tokedddn"+token);
				if(HMSUtil.isInteger(token))
				{
					v.setTokenNo(Integer.parseInt(token));
					v.setDepartment(masReferredDept);
					v.setDoctor(masReferredDoc);
					v.setIntDoctor(masReferredDoc);
					v.setSession(masReferredSes);
					v.setVisitTime(time);
					v.setAppointmentType("t");
					hbt.update(v);
					i++;
				}
				else{
					msg = token;
				}
				
				
				//lastTokenNo+=1;
				//v.setTokenNo(lastTokenNo);
				
				
				
				
			}
				tx.commit();
				succesfullyAdded =true;
				//msg+="<font color='green'>Transferred Successfully For "+masReferredDept.getDepartmentName()+" Department And "+masReferredSes.getSessionName()+" Session</font><br>";
				String d =  i!=visitIdList.size()?""+i+" patient(s)":"";
				msg+="<br/><font color='green'>"+d+"Transferred Successfully..</font><br/>";
			    
		}catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			msg+="<font color='red'>Some problem Occured! Try Again</font><br>";
		}
        map.put("msg", msg); 
		map.put("succesfullyAdded", succesfullyAdded);
		//map.put("visitList", visitList);

		return map;
	}
	@Override
	public Map<String, Object> getPatientAppointmentList(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		List<AppPatientAppointments> patientList = new ArrayList<AppPatientAppointments>();
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		int deptId = box.getInt("deptId");
		int empId = box.getInt("empId");
		int sessId = box.getInt("sessId");
		String appointmentDate = box.getString("appointmentDate");
		System.out.println("empId="+empId);
		System.out.println("deptId="+deptId);
		System.out.println("hospitalId="+hospitalId);
		System.out.println("sessId="+sessId);
		System.out.println("appointmentDate="+appointmentDate);
		
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));	
		Date date = new Date();
		
		
		cr = session.createCriteria(AppPatientAppointments.class)				
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Department.Id", deptId))
				
				.add(Restrictions.eq("Employee.Id", empId))
				.add(Restrictions.eq("AppointmentStatus", "y").ignoreCase());
		
		if(sessId !=0)
		{
			cr= cr.createAlias("AppSession", "sess").add(Restrictions.eq("sess.Id", sessId));
			
		}
		if(!appointmentDate.equalsIgnoreCase("NA"))
		{
			cr= cr.add(Restrictions.eq("AppointmentDate", HMSUtil.convertStringTypeDateToDateType(appointmentDate)));
		}
		else
		{		
				
				cr= cr.add(Restrictions.gt("AppointmentDate", date));		
			
		}
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		patientList = cr.list();
		System.out.println("totalMatches"+totalMatches.size());
		System.out.println("totalMatches"+patientList.size());

		int totalRecords = totalMatches.size();
		totalMatches.clear();	
		map.put("patientList", patientList);		
		map.put("totalRecords", totalRecords);
		
				
		return map;
	}
	
	
	
	
	
	
	
}
