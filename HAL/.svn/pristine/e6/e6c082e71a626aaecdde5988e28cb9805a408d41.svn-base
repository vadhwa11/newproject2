/**
 * Copyright 2011 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class SHODataServiceImpl.java
 * Purpose of the class - This is for SHO
 * @author  Mukesh Narayan Singh
 * Create Date: 5th Aug,2011
 * Revision Date:
 * Revision By: Purpose
 * @version 1.0
 **/
package jkt.hms.sho.dataservice;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.EmpAfmsfDet;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasMedicalCategory;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MisConfirmedH1n1;
import jkt.hms.masters.business.MisFeedbackCounselor;
import jkt.hms.masters.business.MisLmcPsychiatric;
import jkt.hms.masters.business.MisNotifiable;
import jkt.hms.masters.business.MisWaterSampleAnalysis;
import jkt.hms.masters.business.Patient;
import jkt.hms.util.HMSUtil;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SHODataServiceImpl extends HibernateDaoSupport implements SHODataService {
	/*
	 * Logger Implemented By Mukesh Narayan Singh
	 * Date 5 Aug 2011
	 */
	static final Logger loger = Logger.getLogger(jkt.hms.sho.dataservice.SHODataServiceImpl.class);

	@Override
	public Map<String, Object> showNotifiableDisease(
			Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map.put("message", "Hi");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> printNotifiableDisease(
			Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map.put("message", "Hi");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	@Override
	public Map<String, Object> getHospitalName(Map<String, Object> mapHospital) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=0;
		if(mapHospital.get("hospitalId")!=null){
			hospitalId=(Integer)mapHospital.get("hospitalId");
		}
		
		try {
			String hospitalName="";
			String hospitalAdd="";
			List<MasHospital> list = session.createCriteria(MasHospital.class).add(
					Restrictions.eq("Status", "y")).add(
					Restrictions.eq("Id", hospitalId)).list();

			if (list != null && list.size() > 0) {
				MasHospital obj = (MasHospital) list.get(0);
				hospitalName = obj.getHospitalName();
				hospitalAdd = obj.getAddress();
			}
			map.put("hospitalName", hospitalName);
			map.put("hospitalAdd", hospitalAdd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> viewNotifiableDiseaseDetails(
			Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		String fromDate = "";
		String toDate = "";
		String serviceNo="";
		if(mapDetail.get("fromDate")!=null){
			fromDate=(String)mapDetail.get("fromDate");
		}
		if(mapDetail.get("toDate")!=null){
			toDate=(String)mapDetail.get("toDate");
		}
		if(mapDetail.get("serviceNo")!=null){
			serviceNo=(String)mapDetail.get("serviceNo");
		}
		Session session = (Session) getSession();
		try{
			List<MisNotifiable> misNotifiableList = new ArrayList<MisNotifiable>();
			Criteria c=null;
			c=session.createCriteria(MisNotifiable.class);
			if(serviceNo!=""){
				c.createAlias("Hin", "hin").add(Restrictions.eq("hin.ServiceNo", serviceNo)).add(Restrictions.between("NotifiableDate", HMSUtil.convertStringTypeDateToDateType(fromDate), HMSUtil.convertStringTypeDateToDateType(toDate)));
			}else{
				c.add(Restrictions.between("NotifiableDate", HMSUtil.convertStringTypeDateToDateType(fromDate), HMSUtil.convertStringTypeDateToDateType(toDate)));
			}
			misNotifiableList = c.list();
			map.put("misNotifiableList", misNotifiableList);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showLowMedCatPsychiatricPatientCounelingEntry(
			Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasMedicalCategory> masMedicalList = new ArrayList<MasMedicalCategory>();

		try {
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
			tradeList = session.createCriteria(MasTrade.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
			masMedicalList = session.createCriteria(MasMedicalCategory.class)
					.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("MedicalCategoryName")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("rankList", rankList);
		map.put("tradeList", tradeList);
		map.put("unitList", unitList);
		map.put("masMedicalList", masMedicalList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getHinNoForDiseaseSHO(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		String message = "";
		String respForm = "";
		if (dataMap.get("serviceNo") != null) {
			serviceNo = "" + dataMap.get("serviceNo");
		}
		if (dataMap.get("respForm") != null) {
			respForm = "" + dataMap.get("respForm");
		}
		//loger.info("1111111111111" + respForm);

		Session session = (Session) getSession();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasMedicalCategory> masMedicalList = new ArrayList<MasMedicalCategory>();
		
		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		List<Patient> patientList = new ArrayList<Patient>();
		
		try {
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
			tradeList = session.createCriteria(MasTrade.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
			masMedicalList = session.createCriteria(MasMedicalCategory.class)
					.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("MedicalCategoryName")).list();
			empAfmsfDetList = session.createCriteria(EmpAfmsfDet.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).list();

			patientList= session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).add(Restrictions.eq("Relation.Id",8)).list();
			// Relation Id=8 means Self
			
			//loger.info("present unit**********" + presentUnitList.size());
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("message", message);
		map.put("respForm", respForm);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		map.put("masMedicalList", masMedicalList);
		map.put("empAfmsfDetList", empAfmsfDetList);
		map.put("patientList", patientList);
		return map;
	}

	/**
	 * editAfmsfDef()is used for:- 1) if fetching records from MasEmployee then
	 * enter a new record in EmpAfmsfDet table. 2) else, it is fetching records
	 * from the EmpAfmsfDet table, then update the selected record in
	 * EmpAfmsfDet table. Receipt Status is set to 'R'.
	 */

	public Map<String, Object> editLowMedCatPsychiatricPatientCouneling(Map<String, Object> generalMap) {
		Session session = (Session) getSession();
		Map<String, Object> mapRespSave = new HashMap<String, Object>();
		boolean dataUpdated = false;
		String currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String changedBy = "";

		session = (Session) getSession();
		Transaction tx = null;

		int hospitalId = 0;
		int rankId = 0;
		//int empId = 0;
		int tradeId = 0;
		int medicalcategory = 0;
		int hin_id=0;
		String remarks = "";
		String serviceNo = null;
		int presentUnit = 0;
		String employeeName = null;
		Date nextreviewDate = null;
		Date dateOfPosting = null;
		Date lastMedBoardDate=null;
		String diagnosis = null;
		String lastName = null;
		
		
		serviceNo = (String) generalMap.get("serviceNo");


		employeeName = (String) generalMap.get("employeeName");
		//empId = (Integer) generalMap.get("employeeId");
		rankId = (Integer) generalMap.get("rankId");
		currentDate = (String) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		changedBy = (String) generalMap.get("changedBy");
		hospitalId = (Integer) generalMap.get("hospitalId");
		medicalcategory = (Integer) generalMap.get("medicalcategory");
		Date currentDateDate = HMSUtil
				.convertStringTypeDateToDateType(currentDate);
		remarks = (String) generalMap.get("remarks");
		presentUnit = (Integer) generalMap.get("presentUnit");
		tradeId = (Integer) generalMap.get("tradeId");
		diagnosis = (String) generalMap.get("diagnosis");
		lastName = (String) generalMap.get("lastName");
		if(generalMap.get("nextreviewDate")!=null){
			nextreviewDate = (Date) generalMap.get("nextreviewDate");
		}
		if(generalMap.get("lastMedBoardDate")!=null){
			lastMedBoardDate = (Date) generalMap.get("lastMedBoardDate");
		}
		if(generalMap.get("dateOfPosting")!=null){
			dateOfPosting = (Date) generalMap.get("dateOfPosting");
		}
		Date counselingDate=null;
		Date diagnosisDate=null;
		String warningLetter="";
		String retentionService="";
		String categoryName="";
		String entryFlag="";
		if(generalMap.get("counselingDate")!=null){
			counselingDate = (Date) generalMap.get("counselingDate");
		}
		if(generalMap.get("diagnosisDate")!=null){
			diagnosisDate = (Date) generalMap.get("diagnosisDate");
		}
		if(generalMap.get("warningLetter")!=null){
			warningLetter = (String) generalMap.get("warningLetter");
		}
		if(generalMap.get("retentionService")!=null){
			retentionService = (String) generalMap.get("retentionService");
		}
		if(generalMap.get("categoryName")!=null){
			categoryName = (String) generalMap.get("categoryName");
		}
		if(generalMap.get("entryFlag")!=null){
			entryFlag = (String) generalMap.get("entryFlag");
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			tx = session.beginTransaction();
			MisLmcPsychiatric misLmcPsychiatric=new MisLmcPsychiatric();
			
			if(hospitalId>0){
				MasHospital masHospital=new MasHospital();
				masHospital.setId(hospitalId);
				misLmcPsychiatric.setHospital(masHospital);
			}
			if(tradeId>0){
				MasTrade masTrade=new MasTrade();
				masTrade.setId(tradeId);
				misLmcPsychiatric.setTrade(masTrade);
			}
			if(presentUnit>0){
				MasUnit masUnit=new MasUnit();
				masUnit.setId(presentUnit);
				misLmcPsychiatric.setUnit(masUnit);
			}
			if(rankId>0){
				MasRank masRank=new MasRank();
				masRank.setId(rankId);
				misLmcPsychiatric.setRank(masRank);
			}
			if(hin_id>0){
				Patient patient=new Patient();
				patient.setId(hin_id);
				misLmcPsychiatric.setPatient(patient);
			}
			if(medicalcategory>0){
				MasMedicalCategory masMedicalCategory=new MasMedicalCategory();
				masMedicalCategory.setId(medicalcategory);
				misLmcPsychiatric.setMedicalCategory(masMedicalCategory);
			}
			
			misLmcPsychiatric.setSFirstName(employeeName);
			misLmcPsychiatric.setSLastName(lastName);
			misLmcPsychiatric.setServiceNo(serviceNo);
			
			misLmcPsychiatric.setLastMbDate(lastMedBoardDate);
			misLmcPsychiatric.setCounselingDate(counselingDate);
			
			misLmcPsychiatric.setRemarks(remarks);
			if(entryFlag.equals("lmc")){
				misLmcPsychiatric.setNextMbDate(nextreviewDate);
				misLmcPsychiatric.setDiagnosis(diagnosis);
			}else if(entryFlag.equals("cam")){
				misLmcPsychiatric.setDateOfPostingIn(dateOfPosting);
				misLmcPsychiatric.setDiagnosisDate(diagnosisDate);
				misLmcPsychiatric.setCategoryName(categoryName);
				misLmcPsychiatric.setWarningLetter(warningLetter);
				misLmcPsychiatric.setRetentionService(retentionService);
			}
			misLmcPsychiatric.setEntryFlag(entryFlag);
			
			misLmcPsychiatric.setStatus("y");
			misLmcPsychiatric.setLastChgBy(changedBy);
			misLmcPsychiatric.setLastChgTime(currentTime);
			misLmcPsychiatric.setLastChgDate(currentDateDate);
			hbt.save(misLmcPsychiatric);
			tx.commit();
			dataUpdated=true;
			loger.info("transaction");
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			//loger.info("exception in dsss   " + e);
			e.printStackTrace();
		}
		mapRespSave.put("dataUpdated", dataUpdated);
		return mapRespSave;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showConfirmedCasesH1N1(
			Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		
		List<MasAdministrativeSex> masAdministrativeSexList=null;
		List<MasRelation> relationList = null;
		try{
			
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
			tradeList = session.createCriteria(MasTrade.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
			masAdministrativeSexList = session.createCriteria(MasAdministrativeSex.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
			relationList = session.createCriteria(MasRelation.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("RelationName")).list();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		map.put("masAdministrativeSexList", masAdministrativeSexList);
		map.put("relationList", relationList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getHinNoSHO(Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		String serviceNo = "";
		Session session = (Session) getSession();
		try {
			if (mapDetail.get("serviceNo") != null) {
				serviceNo = "" + mapDetail.get("serviceNo");
			}
			if (!serviceNo.equals("")) {
				patientList = session.createCriteria(Patient.class).add(
						Restrictions.eq("ServiceNo", serviceNo)).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> confirmedCasesH1N1Response(
			Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		
		List<MasAdministrativeSex> masAdministrativeSexList=null;
		List<MasRelation> relationList = null;
		List<Patient> patientList = new ArrayList<Patient>();
		/*String serviceNo = "";
		if (mapDetail.get("serviceNo") != null) {
			serviceNo = "" + mapDetail.get("serviceNo");
		}*/
		String hinIdStr = "";
		int hinId = 0;
		if (mapDetail.get("hinId") != null) {
			hinIdStr = (String)mapDetail.get("hinId");
		}
		if(!hinIdStr.equalsIgnoreCase("")){
			hinId = Integer.parseInt(hinIdStr);
		}
		loger.info("hin No--->"+hinId);
		try{
			if(hinId>0){
				patientList = session.createCriteria(Patient.class).add(
						Restrictions.idEq(hinId)).list();
			}
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
			tradeList = session.createCriteria(MasTrade.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
			masAdministrativeSexList = session.createCriteria(MasAdministrativeSex.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
			relationList = session.createCriteria(MasRelation.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("RelationName")).list();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		map.put("masAdministrativeSexList", masAdministrativeSexList);
		map.put("relationList", relationList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> saveConfirmedCasesH1N1(
			Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasAdministrativeSex> masAdministrativeSexList=null;
		List<MasRelation> relationList = null;
		MisConfirmedH1n1 misConfirmedH1n1=new MisConfirmedH1n1();
		if(mapDetail.get("misConfirmedH1n1")!=null){
			misConfirmedH1n1=(MisConfirmedH1n1)mapDetail.get("misConfirmedH1n1");
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			hbt.save(misConfirmedH1n1);
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
			tradeList = session.createCriteria(MasTrade.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
			masAdministrativeSexList = session.createCriteria(MasAdministrativeSex.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
			relationList = session.createCriteria(MasRelation.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("RelationName")).list();
			tx.commit();
		}catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		loger.info("Save data H1N1");
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		map.put("masAdministrativeSexList", masAdministrativeSexList);
		map.put("relationList", relationList);
		return map;
	}

	@Override
	public Map<String, Object> showWaterAnalysis(Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		//Session session = (Session) getSession();
		try {
			/*
			 * Code block
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> saveWaterSampleForAnalysis(
			Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		MisWaterSampleAnalysis misWaterSampleAnalysis=new MisWaterSampleAnalysis();
		
		if(mapDetail.get("misWaterSampleAnalysis")!=null){
			misWaterSampleAnalysis=(MisWaterSampleAnalysis)mapDetail.get("misWaterSampleAnalysis");
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			hbt.save(misWaterSampleAnalysis);
			tx.commit();
		}catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		loger.info(" saveWaterSampleForAnalysis");
		return map;
	}

	@Override
	public Map<String, Object> showFeedBackOfCounselor(
			Map<String, Object> mapDetail) {List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			int deptId = (Integer) mapDetail.get("deptId");
			int hospitalId = (Integer) mapDetail.get("hospitalId");
			doctorList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("EmpCategory.Id",1)).add(Restrictions.eq("Status", "y"))
			.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
		     map.put("doctorList", doctorList);
		   return map;}

	@Override
	public Map<String, Object> saveFeedbackCounselor(
			Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		MisFeedbackCounselor misFeedbackCounselor=new MisFeedbackCounselor();
		
		
		if(mapDetail.get("misFeedbackCounselor")!=null){
			misFeedbackCounselor=(MisFeedbackCounselor)mapDetail.get("misFeedbackCounselor");
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			hbt.save(misFeedbackCounselor);
			tx.commit();
		}catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		loger.info(" saveFeedbackCounselor");
		return map;
	}

	@Override
	public Map<String, Object> showOccupationalExposureHIV(
			Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map.put("message", "showOccupationalExposureHIV");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public Map<String, Object> saveOccupationalExposureHIV(
			Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map.put("message", "saveOccupationalExposureHIV");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> saveBioMedicalWasteDisposalInspecting(
			Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map.put("message", "saveBioMedicalWasteDisposalInspecting");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> showBioMedicalWasteDisposalInspecting(
			Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map.put("message", "showBioMedicalWasteDisposalInspecting");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> saveMentalAndPhysicalRetardedChildren(
			Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();

		try {
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		return map;
	}

	@Override
	public Map<String, Object> showMentalAndPhysicalRetardedChildren(
			Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();

		try {
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		return map;
	}

	@Override
	public Map<String, Object> saveAccommodation(Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map.put("message", "saveAccommodation");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> showAccommodation(Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map.put("message", "showAccommodation");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showFoodHandler() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> tradeList = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		tradeList =hbt.find("select Id,TradeName from MasTrade mt where mt.Status='y' order by mt.TradeName");
		map.put("tradeList", tradeList);
		return map;
	}


}
