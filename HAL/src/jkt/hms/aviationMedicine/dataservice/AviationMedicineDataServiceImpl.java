package jkt.hms.aviationMedicine.dataservice;

import static jkt.hms.util.RequestConstants.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadFile;

import jkt.hms.masters.business.AvAccident;
import jkt.hms.masters.business.AvAircraftAccident;
import jkt.hms.masters.business.AvAircrewLectureDt;
import jkt.hms.masters.business.AvAircrewRationDt;
import jkt.hms.masters.business.AvAircrewRationHd;
import jkt.hms.masters.business.AvAuthorisedItem;
import jkt.hms.masters.business.AvFlyingIncident;
import jkt.hms.masters.business.AvGridDetails;
import jkt.hms.masters.business.AvMedicalExamMaMo;
import jkt.hms.masters.business.AvMedicalUploadDocument;
import jkt.hms.masters.business.AvPilotRegistrationDt;
import jkt.hms.masters.business.AvPilotRegistrationHd;
import jkt.hms.masters.business.AvPreFlight;
import jkt.hms.masters.business.AvPreFlightDt;
import jkt.hms.masters.business.AvSpecialLocalFeature;
import jkt.hms.masters.business.AvTrainingStatusAircrew;
import jkt.hms.masters.business.AviAircrewMedicalLectures;
import jkt.hms.masters.business.AviCa34;
import jkt.hms.masters.business.AviCasualtyAirEvacuation;
import jkt.hms.masters.business.AviFlyingClothingInspection;
import jkt.hms.masters.business.AviationInvestResult;
import jkt.hms.masters.business.Category;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgResultEntryHeader;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAircraftType;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasBlock;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasCaLicence;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.masters.business.MasMedicalUploadDocument;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRecordOfficeAddress;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasSection;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStation;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.PatientInvestigationDetails;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.masters.business.StorePoHeader;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.PageUtil;
import jkt.hms.util.PagedArray;
import jkt.hms.util.RequestConstants;
import jkt.hms.masters.business.Patient;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lowagie.text.pdf.ByteBuffer;


public class AviationMedicineDataServiceImpl extends HibernateDaoSupport implements AviationMedicineDataService 
{
	@SuppressWarnings("unchecked")
	public Map<String, Object> showCAForm34AJsp(int hospitalId) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCountry> countryList = null;
		List<MasState> stateList = null;
		List<MasDistrict> districtList = null;
		List<MasOccupation> occupationList = null;
		List<MasBankMaster> bankList=null;
		List<MasTitle> titleList=null;
		List<MasCaLicence> caLicenceList=null;
		List<MasAdministrativeSex> sexList = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			
			countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("CountryName")).list();
			stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("StateName")).list();
			districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
			occupationList = session.createCriteria(MasOccupation.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("OccupationName")).list();
			bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BankName")).list();
			titleList = session.createCriteria(MasTitle.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TitleName")).list();
			caLicenceList = session.createCriteria(MasCaLicence.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("CaLicenceName")).list();
			sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
			
			} catch (HibernateException e) {
			e.printStackTrace();
			
		}
		map.put("sexList",sexList);
		map.put("countryList", countryList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("occupationList", occupationList);
		map.put("bankList", bankList);
		map.put("titleList", titleList);
		map.put("caLicenceList", caLicenceList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showRenewableApplicationJsp(int hospitalId) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCountry> countryList = null;
		List<MasState> stateList = null;
		List<MasDistrict> districtList = null;
		List<MasOccupation> occupationList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasTitle> titleList=null;
		List<MasCaLicence> caLicenceList=null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("CountryName")).list();
			stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("StateName")).list();
			districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DistrictName")).list();
			occupationList = session.createCriteria(MasOccupation.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("OccupationName")).list();
			titleList = session.createCriteria(MasTitle.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TitleName")).list();
			caLicenceList = session.createCriteria(MasCaLicence.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("CaLicenceName")).list();
			sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
			} catch (HibernateException e) {
			e.printStackTrace();
			
		}
		map.put("titleList", titleList);
		map.put("caLicenceList", caLicenceList);
		map.put("countryList", countryList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("occupationList", occupationList);
		map.put("sexList", sexList);
		return map;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Connection con = session.connection();
		map.put("conn",con);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showAircrewMedicalLectureJsp(int hospitalId) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasUnit> unitList = null;
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		//List<Patient> patientList = new ArrayList<Patient>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
			doctorList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
			.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
			/*patientList=session.createCriteria(Patient.class).createAlias("Relation", "rel")
			.add(Restrictions.eq("rel.RelationName", "Self")).list();*/
			} catch (HibernateException e) {
			e.printStackTrace();
			
		}
		//map.put("patientList", patientList);
		map.put("unitList", unitList);
		map.put("doctorList", doctorList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showFlyingClothingInspectionJsp(int hospitalId) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasUnit> unitList = null;
		List<MasRank> rankList = null;
		List<MasTrade> tradeList = null;
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<MasAdministrativeSex> sexList = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
			rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
			tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
			sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
			doctorList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
			.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
			} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("doctorList", doctorList);
		map.put("unitList", unitList);
		map.put("rankList", rankList);
		map.put("tradeList", tradeList);
		map.put("sexList", sexList);
		return map;
	}

	@Override
	public Map<String, Object> showCasualtyAirEvacuationJsp(int hospitalId) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasUnit> unitHoldList = new ArrayList<MasUnit>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasAdministrativeSex> genderList=new ArrayList<MasAdministrativeSex>();
	/*	List<Object[]> sexList = null;
		List<Object[]> unitList = null;
		List<Object[]> serviceStatusList = null;
		List<Object[]> stationList = null;
		List<Object[]> serviceTypeList = null;
		List<Object[]> tradeList = null;
		List<Object[]> rankList = null;
		List<Object[]> sectionList = null;
		List<Object[]> commandList = null;*/
		List<MasRecordOfficeAddress> recordOfficeAddressList = null;
		List<MasAircraftType> aircraftTypeList=new ArrayList<MasAircraftType>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			unitHoldList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
			rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
			tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
			genderList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
			aircraftTypeList= session.createCriteria(MasAircraftType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AircraftTypeName")).list();
			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
			/*.createAlias("Station", "station",CriteriaSpecification.LEFT_JOIN).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))
			.add(Projections.property("station.StationName")).add(Projections.property("HicCode"))).addOrder(
			Order.asc("UnitName")).list();
			sexList = hbt.find("Select Id, AdministrativeSexName, AdministrativeSexCode,HicCode from MasAdministrativeSex mas where mas.Status='y' order by AdministrativeSexName");
			sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y"))
						.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
						.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("SectionName")))
						.addOrder(Order.asc("SectionName")).list();
			stationList = hbt.find("select Id,StationName,mas.Command.Id from MasStation mas where mas.Status='y' order by mas.StationName");
			commandList = hbt.find("select Id,CommandName from MasCommand mas where mas.Status='y' order by mas.CommandName");
			serviceStatusList = hbt.find("select Id,ServiceStatusName from MasServiceStatus mss where mss.Status='y' ");
			serviceTypeList = hbt.find("select Id,ServiceTypeName from MasServiceType mst where mst.Status='y' order by ServiceTypeName");
			
			tradeList =hbt.find("select Id,TradeName from MasTrade mt where mt.Status='y' order by mt.TradeName");
			rankList = hbt.find("select Id,RankName,rank.ServiceType.Id, rank.ServiceStatus.Id,rank.HicCode from MasRank as rank  where rank.Status='y'  order by rank.RankName ");
			recordOfficeAddressList = session.createCriteria(MasRecordOfficeAddress.class).add(Restrictions.eq("Status", "y")).list();*/
			} catch (HibernateException e) {
			e.printStackTrace();
		}
			map.put("unitHoldList", unitHoldList);
			map.put("aircraftTypeList", aircraftTypeList);
			/*map.put("sexList", sexList);
			map.put("sectionList", sectionList);
			map.put("stationList", stationList);
			map.put("commandList", commandList);
			map.put("serviceStatusList",serviceStatusList);
			map.put("serviceTypeList", serviceTypeList);
			map.put("serviceTypeList", serviceTypeList);
			*/
			map.put("genderList", genderList);
			map.put("unitList", unitList);
			map.put("tradeList",tradeList);
			map.put("rankList", rankList);
			map.put("recordOfficeAddressList", recordOfficeAddressList);
		return map;
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showAircraftAccidentInvestigationJsp(int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();
		List<MasAircraftType> aircraftList = new ArrayList<MasAircraftType>();
		Session session = (Session) getSession();

	try {
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		maritalStatusList = session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("MaritalStatusName")).list();
		aircraftList = session.createCriteria(MasAircraftType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AircraftTypeName")).list();
		} catch (HibernateException e) {
		e.printStackTrace();
		}
		map.put("aircraftList",aircraftList);
		map.put("unitList", unitList);
		map.put("rankList", rankList);
		map.put("maritalStatusList", maritalStatusList);
		return map;
	}

	@Override
	public Boolean submitRenewableApplication(AviCa34 aviCa34, Patient patient,Visit visit, Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Boolean successfullyAdded = false;
		HibernateTemplate hbt = null;
		Transaction tx = null;
			String licenceNo="";
			int visitId=0;
			int hinnId=0;
			int avCA34=0;
			if(dataMap.get("licenceNo") !=null){
				licenceNo=(String)dataMap.get("licenceNo");
			}
			if(dataMap.get("visitId") !=null){
				visitId=(Integer)dataMap.get("visitId");
			}
			if(dataMap.get("hinId") !=null){
				hinnId=(Integer)dataMap.get("hinId");
			}
			if(dataMap.get("avCA34") !=null){
				avCA34=(Integer)dataMap.get("avCA34");
			}
			List<AviCa34> licenceNoExistList = new ArrayList<AviCa34>();
			licenceNoExistList=session.createCriteria(AviCa34.class).add(Restrictions.eq("LicenceNo", licenceNo)).list();
		try {
			tx = session.beginTransaction();
			hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			//--Save in patient table--
			if(hinnId==0){
			if(licenceNoExistList.size() ==0)
			{
				Integer hinId=(Integer)hbt.save(patient);
				//--Save in visit table--
				visit.setHin(patient);
				hbt.save(visit);
				//---Save in aviCa34 table---
				aviCa34.setVisit(visit);
				aviCa34.setHin(patient);
			    hbt.save(aviCa34);
			}}else{
				Patient visitHin=new Patient();
				visitHin.setId(hinnId);
				visit.setHin(visitHin);
				hbt.save(visit);
				AviCa34 aviCa34Obj = (AviCa34) hbt.load(AviCa34.class, avCA34);
				aviCa34Obj.setVisit(visit);
				aviCa34Obj.setStatus("w");
				hbt.update(aviCa34Obj);
				
				
			}
			
			successfullyAdded=true;
			tx.commit();
			}catch (Exception e) {
				if (tx != null)
					tx.rollback();
				successfullyAdded=false;
				e.printStackTrace();
			}
		return successfullyAdded;
	}

	@Override
	public Map<String, Object> getWaitingAppointMedExamList(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<AviCa34> medExamAviationWaitingList = new ArrayList<AviCa34>();
		List<MasCaLicence> masCaLicenceList = new ArrayList<MasCaLicence>();
		Date currentDate = new Date();
		medExamAviationWaitingList=session.createCriteria(AviCa34.class).add(Restrictions.eq("Status", "w")).add(Restrictions.eq("RenewalDueDate", currentDate)).list();
	//	.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).list();
		masCaLicenceList=session.createCriteria(MasCaLicence.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("CaLicenceName")).list();
		map.put("masCaLicenceList", masCaLicenceList);
		map.put("medExamAviationWaitingList", medExamAviationWaitingList);
		return map;
	}

	@Override
	public Map<String, Object> getMedExamWaitningList(Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<AviCa34> medExamWaitingList = new ArrayList<AviCa34>();
		Date fromAppDate = new Date();
		Date toAppDate = new Date();
		int typeOfLicence=0;
		if (mapForDs.get("fromAppDate") != null) {
			fromAppDate = (Date) mapForDs.get("fromAppDate");
		}
		if (mapForDs.get("toAppDate") != null) {
			toAppDate = (Date) mapForDs.get("toAppDate");
		}
		if (mapForDs.get("typeOfLicence") != null) {
			typeOfLicence = (Integer) mapForDs.get("typeOfLicence");
		}
		Session session = (Session) getSession();
		try {

			Criteria criteria = session.createCriteria(AviCa34.class).add(Restrictions.eq("Status", "w"))
								.add(Restrictions.between("RenewalDueDate", fromAppDate, toAppDate));
			if(typeOfLicence !=0){
				criteria=criteria.createAlias("TypeOfLicenceApplied", "lt")
									.add(Restrictions.eq("lt.Id", typeOfLicence));
			}
		medExamWaitingList=criteria.list();
		detailsMap.put("medExamWaitingList", medExamWaitingList);			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Boolean submitAircrewMedicalLecture(AviAircrewMedicalLectures aviAircrewMedicalLectures
			,Map<String, Object> infoMap) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(aviAircrewMedicalLectures);
		
		List<String> serviceNoList = new ArrayList<String>();
		List<Integer> rankList = new ArrayList<Integer>();
		List<Integer> hinList = new ArrayList<Integer>();
		List<String> nameList = new ArrayList<String>();
		
		serviceNoList = (List) infoMap.get("serviceNoList");
		rankList = (List) infoMap.get("rankList");
		hinList = (List) infoMap.get("hinList");
		nameList = (List) infoMap.get("nameList");
		for (int i = 0; i < serviceNoList.size(); i++) {
			 AvAircrewLectureDt aircrewLectureDt=new AvAircrewLectureDt();
			 if(serviceNoList.get(i)!=null){
				 aircrewLectureDt.setServiceNo(serviceNoList.get(i));
			 }
			 if(nameList.get(i)!=null){
				 aircrewLectureDt.setSName(nameList.get(i));
			 }
			 if(hinList.get(i)!=null && !hinList.get(i).equals("")){
				 Patient patient=new Patient();
				 patient.setId(hinList.get(i));
				 aircrewLectureDt.setHin(patient);
			 }
			 if(rankList.get(i)!=null && !rankList.get(i).equals("")){
				 MasRank masRank=new MasRank();
				 masRank.setId(rankList.get(i));
				 aircrewLectureDt.setRank(masRank);
			 }
			 aircrewLectureDt.setAircrewHdId(aviAircrewMedicalLectures);
			 hbt.save(aircrewLectureDt);
		 }
		
		successfullyAdded = true;
		return successfullyAdded;
	}
	//---------Save For Flying Clothing----
	public Map<String, Object> submitFlyingClothingInspectionJsp(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Session session = (Session) getSession();
		AviFlyingClothingInspection aviFlyingClothingInspection = new AviFlyingClothingInspection();
		if (infoMap.get("aviFlyingClothingInspection") != null) {
			aviFlyingClothingInspection = (AviFlyingClothingInspection) infoMap.get("aviFlyingClothingInspection");
		}
		Patient patient = new Patient();
		if (infoMap.get("patient") != null) {
			patient = (Patient) infoMap.get("patient");
		}
		int avAccidentId=0;
		if (infoMap.get("avAccidentId") != null) {
			avAccidentId = (Integer) infoMap.get("avAccidentId");
		}
		int hinId=0;
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		int avAccidentIdd=0;
		Transaction tx = null;
		try {
		tx = session.beginTransaction();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (infoMap.get("aviFlyingClothingInspection") != null) {
		if(avAccidentId !=0){
		AviFlyingClothingInspection flyClothObj = (AviFlyingClothingInspection) hbt.load(AviFlyingClothingInspection.class, avAccidentId);
		hbt.update(flyClothObj);
		avAccidentIdd = flyClothObj.getId();
		}else {
			aviFlyingClothingInspection = (AviFlyingClothingInspection) infoMap.get("aviFlyingClothingInspection");
		if(hinId == 0){
			hbt.save(patient);
		
		Patient patientHin=new Patient();
		patientHin.setId(patient.getId());
		aviFlyingClothingInspection.setHin(patientHin);
		}
		hbt.save(aviFlyingClothingInspection);
		avAccidentIdd = aviFlyingClothingInspection.getId();
		} 
			}
			saved = true;
		 tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		map.put("saved",saved);
		map.put("avAccidentIdd",avAccidentIdd);
		return map;
	}
	

	@SuppressWarnings("unchecked")
	public Map<String, Object> getServiceNoDetailsForReg(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = box.getInt("hospitalId");
		String serviceNo = box.getString("serviceNo");
		List<MasUnit> unitList = null;
		List<MasRank> rankList = null;
		List<MasTrade> tradeList = null;
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		List<AviFlyingClothingInspection> aviFlyingClothingInspectionList = new ArrayList<AviFlyingClothingInspection>();
		List<Patient> patientList = new ArrayList<Patient>();
		
		org.hibernate.Session session = getSession();
		
		aviFlyingClothingInspectionList = session.createCriteria(AviFlyingClothingInspection.class).add(Restrictions.eq("ServiceNo", serviceNo)).add(Restrictions.eq("Status", "y")).list();
		patientList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
			.add(Restrictions.eq("Status", "y")).createAlias("Relation", "rel")
			.add(Restrictions.eq("rel.RelationName", "Self")).list();
		doctorList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
		.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).list();
		
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();
		rankList =session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list(); 
		tradeList =session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).list(); 
		List<MasAdministrativeSex> sexList = null;
		sexList =session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).list();
		map.put("aviFlyingClothingInspectionList",aviFlyingClothingInspectionList);
		map.put("patientList",patientList);
		map.put("unitList", unitList);
		map.put("rankList", rankList);
		map.put("tradeList", tradeList);
		map.put("doctorList", doctorList);	
		map.put("sexList",sexList);
		return map;
	}
	
	
	@Override
	public Boolean updateFlyingClothingInspectionJsp(AviFlyingClothingInspection aviFlyingClothingInspection,
			Map<String, Object> generalMap) {

		boolean updatedSuccessfully = false;
		int aviFlyingClothingInspectionId = (Integer) generalMap.get("aviFlyingClothingInspectionId");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
		
			AviFlyingClothingInspection aviFlyingClothingInspectionObj = (AviFlyingClothingInspection) hbt.load(AviFlyingClothingInspection.class, aviFlyingClothingInspectionId);
			

			if (generalMap.get("hospitalId") != null) {
				int hospitalId = (Integer) generalMap.get("hospitalId");
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				aviFlyingClothingInspectionObj.setHospital(masHospital);
			}

			if (generalMap.get("departmentId") != null) {
				int departmentId = (Integer) generalMap.get("departmentId");
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				aviFlyingClothingInspection.setDepartment(masDepartment);
			}

			if (generalMap.get("rankId") != null) {
				int rankId = (Integer) generalMap.get("rankId");
				MasRank masRank = new MasRank();
				masRank.setId(rankId);
				aviFlyingClothingInspectionObj.setRank(masRank);
			}
			if (generalMap.get("serviceNo") != null) {
				String serviceNo = (String) generalMap.get("serviceNo");
				aviFlyingClothingInspectionObj.setServiceNo(serviceNo);
			}
			if (generalMap.get("fName") != null) {
				String SfirstName = (String) generalMap.get("fName");
				aviFlyingClothingInspectionObj.setFirstName(SfirstName);
			}
			if (generalMap.get("mName") != null) {
				String SmiddleName = (String) generalMap.get("mName");
				aviFlyingClothingInspectionObj.setMiddleName(SmiddleName);
			}
			if (generalMap.get("lName") != null) {
				String SlastName = (String) generalMap.get("lName");
				aviFlyingClothingInspectionObj.setLastName(SlastName);
			}

		
			if (generalMap.get("unitId") != null) {
				Integer unitId = Integer.parseInt("" + generalMap.get("unitId"));
				MasUnit masUnit = new MasUnit();
				masUnit.setId(unitId);
				aviFlyingClothingInspectionObj.setUnit(masUnit);
			}
			if (generalMap.get("tradeId") != null) {
				Integer tradeId = Integer.parseInt("" + generalMap.get("tradeId"));
				MasTrade masTrade = new MasTrade();
				masTrade.setId(tradeId);
				aviFlyingClothingInspectionObj.setTrade(masTrade);
			}
			
			if (generalMap.get("flyingDate") != null) {
				Date flyingDate = (Date) generalMap.get("flyingDate");
				aviFlyingClothingInspectionObj.setFlyingDate(flyingDate);
			}
			if (generalMap.get("maskStatus") != null) {
				String maskStatus = (String) generalMap.get("maskStatus");
				aviFlyingClothingInspectionObj.setMaskStatus(maskStatus);
			}
			if (generalMap.get("maskRemarks") != null) {
				String maskRemarks = (String) generalMap.get("maskRemarks");
				aviFlyingClothingInspectionObj.setMaskRemarks(maskRemarks);
			}
			

			if (generalMap.get("lastChgDate") != null) {
				Date lastChgDate = (Date) generalMap.get("lastChgDate");
				aviFlyingClothingInspectionObj.setLastChgDate(lastChgDate);
			}
		

			if (generalMap.get("antiGSuitRemarks") != null) {
				String antiGSuitRemarks = (String) generalMap.get("antiGSuitRemarks");
				aviFlyingClothingInspectionObj.setAntiGSuitRemarks(antiGSuitRemarks);
			}
		
		
			if (generalMap.get("antiGSuitStatus") != null) {
				String antiGSuitStatus = (String) generalMap.get("antiGSuitStatus");
				aviFlyingClothingInspectionObj.setAntiGSuitStatus(antiGSuitStatus);
			}
			
			
			

			if (generalMap.get("helmetRemarks") != null) {
				String helmetRemarks = (String) generalMap.get("helmetRemarks");
				aviFlyingClothingInspectionObj.setHelmetRemarks(helmetRemarks);
			}
		
		
			if (generalMap.get("helmetStatus") != null) {
				String helmetStatus = (String) generalMap.get("helmetStatus");
				aviFlyingClothingInspectionObj.setHelmetStatus(helmetStatus);
			}
			
			

			if (generalMap.get("otherRemarks") != null) {
				String otherRemarks = (String) generalMap.get("otherRemarks");
				aviFlyingClothingInspectionObj.setOtherRemarks(otherRemarks);
			}
		
			if (generalMap.get("otherStatus") != null) {
				String otherStatus = (String) generalMap.get("otherStatus");
				aviFlyingClothingInspectionObj.setOtherStatus(otherStatus);
			}
			
			String lastChgTime = "";
			if (generalMap.get("lastChgTime") != null) {
				lastChgTime = (String) generalMap.get("lastChgTime");
				aviFlyingClothingInspectionObj.setLastChgTime(lastChgTime);
			}
			aviFlyingClothingInspectionObj.setStatus("y");
			

			hbt.update(aviFlyingClothingInspectionObj);
			updatedSuccessfully = true;
	} catch (DataAccessException e) {
		e.printStackTrace();
		
	}
	return updatedSuccessfully;
	}
	//---------Assign---Appointment--By dipali---
	@Override
	public Boolean submitCheckedAppointment(Box box) {
		Session session = (Session) getSession();
		Boolean successfullyAdded = false;
		HibernateTemplate hbt = null;
		Transaction tx = null;
		
	try {
		tx = session.beginTransaction();
		hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Vector aviCa34Id = box.getVector("aviCa34Id");
		Vector checkedAppointValue = box.getVector("checkedAppointvalue");
		String appointmentDate = box.getString("appointmentDate");
		for (int inc = 0; inc<checkedAppointValue.size(); inc++) {
		AviCa34 aviCa34  =(AviCa34) hbt.load(AviCa34.class,Integer.parseInt((String) aviCa34Id.get(inc)));
		if (checkedAppointValue.get(inc) != null && !checkedAppointValue.get(inc).equals("")) {
			aviCa34.setStatus((String)checkedAppointValue.get(inc));}
			aviCa34.setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(appointmentDate));
		
		hbt.saveOrUpdate(aviCa34);
		hbt.refresh(aviCa34);
		}
		successfullyAdded=true;
		tx.commit();
		}catch (Exception e) {
			if (tx != null)
				tx.rollback();
			successfullyAdded=false;
			e.printStackTrace();
		}
		return successfullyAdded;
		}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getDetailBasedLicenceNo(Map<String, Object> mapForDs) {
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	String licenceNo="";
	int avCA34Id=0;
	if(mapForDs.get("licenceNo") !=null){
		licenceNo=(String)mapForDs.get("licenceNo");
	}
	if(mapForDs.get("avCA34Id") !=null){
		avCA34Id=(Integer)mapForDs.get("avCA34Id");
	}
	List<AviCa34> medExamWaitingList = new ArrayList<AviCa34>();
	List<MasTitle> titleList = new ArrayList<MasTitle>();
	List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
	List<MasDistrict> districtList =new ArrayList<MasDistrict>();
	List<MasCountry> countryList = new ArrayList<MasCountry>();
	List<MasState> stateList = new ArrayList<MasState>();
	List<MasCaLicence> caLicenceList=new ArrayList<MasCaLicence>();
	List<MasBankMaster> bankList=new ArrayList<MasBankMaster>();
	List<MasAdministrativeSex> sexList=new ArrayList<MasAdministrativeSex>();
	if(licenceNo !=""){
	medExamWaitingList=session.createCriteria(AviCa34.class)
						.add(Restrictions.eq("LicenceNo", licenceNo)).list();
	}
	if(avCA34Id !=0){
		medExamWaitingList=session.createCriteria(AviCa34.class)
		.add(Restrictions.eq("Id", avCA34Id)).list();
	}
	titleList=session.createCriteria(MasTitle.class).add(Restrictions.eq("Status", "y")).list();
	occupationList=session.createCriteria(MasOccupation.class).add(Restrictions.eq("Status", "y")).list();
	districtList=session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y")).list();
	countryList=session.createCriteria(MasCountry.class).add(Restrictions.eq("Status", "y")).list();
	stateList=session.createCriteria(MasState.class).add(Restrictions.eq("Status", "y")).list();
	caLicenceList=session.createCriteria(MasCaLicence.class).add(Restrictions.eq("Status", "y")).list();
	bankList=session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status", "y")).list();
	sexList=session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).list();
	
	map.put("sexList",sexList);
	map.put("medExamWaitingList", medExamWaitingList);
	map.put("titleList", titleList);
	map.put("occupationList", occupationList);
	map.put("districtList",districtList);
	map.put("countryList", countryList);
	map.put("stateList",stateList);
	map.put("caLicenceList", caLicenceList);
	map.put("bankList",bankList);
	return map;
	}
	//----Submit CA form 34--By Dipali(22/march/2012)----
	@Override
	public Boolean submitCAForm34A(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		boolean successfullyAdded=false;
		Box box = null;
		int avCA34Id=0;
		if (mapForDS.get("box") != null) {
			box = (Box) mapForDS.get("box");
		}
		if (mapForDS.get("avCA34Id") != null) {
			avCA34Id = (Integer) mapForDS.get("avCA34Id");
		}
		int departmentId = (Integer) mapForDS.get("departmentId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		HibernateTemplate hbt = null;
		Transaction tx = null;
		
	try {
		tx = session.beginTransaction();
		hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if(avCA34Id !=0){
			AviCa34 aviCa34 = (AviCa34) hbt.load(AviCa34.class, avCA34Id);
			if(!box.getString(LICENCE_NO).equals("") ){
				aviCa34.setLicenceNo((box.getString(LICENCE_NO).trim()).toUpperCase());
			}
			if (box.getInt(TITLE_ID)!=0) {
				int titleId = box.getInt(TITLE_ID);
				MasTitle masTitle = new MasTitle();
				masTitle.setId(titleId);
				aviCa34.setTitle(masTitle);
			}
			if(!box.getString(P_FIRST_NAME).equals("") ){
				aviCa34.setFirstName(box.getString(P_FIRST_NAME));
			}
			
			if (!box.getString(P_LAST_NAME).equals("") ){
				aviCa34.setLastName(box.getString(P_LAST_NAME));
			}
			if (!box.getString(PLACE_OF_BIRTH).equals("") ){
				aviCa34.setPlaceOfBirth((box.getString(PLACE_OF_BIRTH)));
			}
			if(!box.get(SR_DOB).equals("")){
				aviCa34.setDob(HMSUtil.convertStringTypeDateToDateType(box.getString(SR_DOB)));
			}
			if (!box.get(SR_AGE).equals("") ){
					String ageUnit = box.getString(SR_AGE_UNIT);
					String srage = box.getString(SR_AGE).concat(" ").concat(ageUnit);
					aviCa34.setAge(srage);
			}
			if (box.getInt(OCCUPATION_ID)!=0) {
				int occupationId = box.getInt(OCCUPATION_ID);
				MasOccupation masOccupation = new MasOccupation();
				masOccupation.setId(occupationId);
				aviCa34.setOccupation(masOccupation);
			}
			if (box.getInt(DISTRICT) !=0) {
				int districtId =box.getInt(DISTRICT);
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(districtId);
				aviCa34.setLocalDistrict(masDistrict);
			}
			if (!box.getString(ADDRESS).equals("") ){
				aviCa34.setLocalAddress(box.getString(ADDRESS));
			}

			if(box.getInt(STATE) !=0){
				int stateId = box.getInt(STATE);
				MasState masState = new MasState();
				masState.setId(stateId);
				aviCa34.setLocalState(masState);
			}
			if (!box.getString(TELEPHONE_NO).equals("") ){
				aviCa34.setTelephoneNo(box.getString(TELEPHONE_NO));
			}
			if (!box.getString(MOBILE_NO) .equals("") ){
				aviCa34.setMobileNo(box.getString(MOBILE_NO));
			}
			if(!box.getString(PERMANENT_ADDRESS).equals("") ){
				aviCa34.setPermanentAddress(box.getString(PERMANENT_ADDRESS));
			}
			if(box.getInt(PERMANENT_CITY_ID) !=0){
				int pdistrictId = box.getInt(PERMANENT_CITY_ID);
				MasDistrict permanentDistrict = new MasDistrict();
				permanentDistrict.setId(pdistrictId);
				aviCa34.setPermanentDistrict(permanentDistrict);
			}
			if(box.getInt(PERMANENT_STATE_ID) !=0){
				int pstateId = box.getInt(PERMANENT_STATE_ID);
				MasState permanentState = new MasState();
				permanentState.setId(pstateId);
				aviCa34.setPermanentState(permanentState);
			}
			if(box.getInt(TYPE_OF_LICENCE)!=0){
				MasCaLicence typeOfLicenceApplied = new MasCaLicence();
				typeOfLicenceApplied.setId(box.getInt(TYPE_OF_LICENCE));
				aviCa34.setTypeOfLicenceApplied(typeOfLicenceApplied);
			}
			if(box.getInt(LICENCE_HELD)!=0){
				MasCaLicence licenceHeld = new MasCaLicence();
				licenceHeld.setId(box.getInt(LICENCE_HELD));
				aviCa34.setLicenceHeld(licenceHeld);
			}
			
			if (!box.getString(AIRCRAFT_PRESENT_FLOWN).equals("")) {
				aviCa34.setAircraftPresentlyFlown(box.getString(AIRCRAFT_PRESENT_FLOWN));
			}
			if (box.getInt(FLYING_EXPERIENCE) != 0) {
				aviCa34.setFlyingExperience(box.getInt(FLYING_EXPERIENCE));
			}
			if (box.getInt(SINCE_LAST_EXAMINATION) != 0) {
				aviCa34.setSinceLastExamination(box.getInt(SINCE_LAST_EXAMINATION));
			}
			if (box.getString(PLACE) != null) {
				aviCa34.setPlace(box.getString(PLACE));
			}
			Date placeDate = null;
			if (!box.get(DATE) .equals("")) {
				placeDate = HMSUtil.convertStringTypeDateToDateType(box.getString(DATE));
				aviCa34.setLastExaminationDate(placeDate);
			}
			if (!box.getString(FINAL_OBSEZVATION).equals("")) {
				aviCa34.setFinalObservation(box.getString(FINAL_OBSEZVATION));
			}
			if (!box.getString("cause") .equals("")) {
				aviCa34.setUnfitReason(box.getString("cause"));
			}
			if (!box.getString(GENERAL) .equals("") ){
				aviCa34.setDgcaOfficeRefNo(box.getString(GENERAL));
			}
			Date dateOne = null;
			if (!box.getString(DATE_ONE).equals("")) {
				dateOne = HMSUtil.convertStringTypeDateToDateType(box.getString(DATE_ONE));
				aviCa34.setDgcaDate(dateOne);
			}
			if (!box.getString(ILLNESS).equals("")) {
				aviCa34.setWorkLoss(box.getString(ILLNESS));
			}
			if (!box.getString("detailsIllness").equals("")) {
				aviCa34.setWorkLossYesDetail(box.getString("detailsIllness"));
			}
			if (!box.getString(PHYSICAL) .equals("")) {
				aviCa34.setPhysicalCondition(box.getString(PHYSICAL));
			}
			if (!box.getString(DRUG) .equals("")) {
				aviCa34.setPresentDrug(box.get(DRUG));
			}
			if (!box.getString("detailDrug").equals("")) {
				aviCa34.setPresentDrugYesDetail(box.getString("detailDrug"));
			}
			if (!box.getString(PAYMENT_MODE).equals("")) {
				aviCa34.setPaymentMode(box.getString(PAYMENT_MODE));
			}
			if (box.getString(CHEQUE_NO) != null) {
				aviCa34.setDdNo(box.getString(CHEQUE_NO));
			}
			Date dateTwo = null;
			if (!box.getString(CHEQUE_DATE) .equals("") ){
				dateTwo = HMSUtil.convertStringTypeDateToDateType(box.getString(CHEQUE_DATE));
				aviCa34.setDdNoDate(dateTwo);
			}
			if (box.getInt(AMOUNT_RECEIVED) != 0) {
				aviCa34.setAmount(box.getInt(AMOUNT_RECEIVED));
			}
			if (box.getString(REMARKS) != null) {
				aviCa34.setRemarks(box.getString(REMARKS));
			}
			if (box.getInt(BANK_NAME)!=0) {
				int bankId =box.getInt(BANK_NAME);
				MasBankMaster masBankMaster = new MasBankMaster();
				masBankMaster.setId(bankId);
				aviCa34.setBank(masBankMaster);
			}
			Date lastChgDate = null;
			if (!box.getString(CHANGED_DATE) .equals("") ){
				lastChgDate = HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE));
				aviCa34.setLastChgDate(lastChgDate);
			}
			String lastChgTime = "";
			if (!box.getString(CHANGED_TIME).equals("") ){
				lastChgTime = box.getString(CHANGED_TIME);
				aviCa34.setLastChgTime(lastChgTime);
			}
			aviCa34.setStatus("a");
				hbt.update(aviCa34);
			}else{
				AviCa34 aviCaForm34=new AviCa34();
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				aviCaForm34.setHospital(masHospital);
				
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				aviCaForm34.setDepartment(masDepartment);
				
				if(!box.getString(LICENCE_NO).equals("") ){
					aviCaForm34.setLicenceNo((box.getString(LICENCE_NO).trim()).toUpperCase());
				}
				if (box.getInt(TITLE_ID)!=0) {
					int titleId = box.getInt(TITLE_ID);
					MasTitle masTitle = new MasTitle();
					masTitle.setId(titleId);
					aviCaForm34.setTitle(masTitle);
				}
				if(!box.getString(P_FIRST_NAME).equals("") ){
					aviCaForm34.setFirstName(box.getString(P_FIRST_NAME));
				}
				
				if (!box.getString(P_LAST_NAME).equals("") ){
					aviCaForm34.setLastName(box.getString(P_LAST_NAME));
				}
				if (!box.getString(PLACE_OF_BIRTH).equals("") ){
					aviCaForm34.setPlaceOfBirth((box.getString(PLACE_OF_BIRTH)));
				}
				if(!box.get(SR_DOB).equals("")){
					aviCaForm34.setDob(HMSUtil.convertStringTypeDateToDateType(box.getString(SR_DOB)));
				}
				if (!box.get(SR_AGE).equals("") ){
						String ageUnit = box.getString(SR_AGE_UNIT);
						String srage = box.getString(SR_AGE).concat(" ").concat(ageUnit);
						aviCaForm34.setAge(srage);
				}
				if (box.getInt(OCCUPATION_ID)!=0) {
					int occupationId = box.getInt(OCCUPATION_ID);
					MasOccupation masOccupation = new MasOccupation();
					masOccupation.setId(occupationId);
					aviCaForm34.setOccupation(masOccupation);
				}
				
				if (box.getInt(DISTRICT) !=0) {
					int districtId =box.getInt(DISTRICT);
					MasDistrict masDistrict = new MasDistrict();
					masDistrict.setId(districtId);
					aviCaForm34.setLocalDistrict(masDistrict);
				}
				if (!box.getString(ADDRESS).equals("") ){
					aviCaForm34.setLocalAddress(box.getString(ADDRESS));
				}

				if(box.getInt(STATE) !=0){
					int stateId = box.getInt(STATE);
					MasState masState = new MasState();
					masState.setId(stateId);
					aviCaForm34.setLocalState(masState);
				}
				
				if (!box.getString(TELEPHONE_NO).equals("") ){
					aviCaForm34.setTelephoneNo(box.getString(TELEPHONE_NO));
				}
				if (!box.getString(MOBILE_NO) .equals("") ){
					aviCaForm34.setMobileNo(box.getString(MOBILE_NO));
				}
				if(!box.getString(PERMANENT_ADDRESS).equals("") ){
					aviCaForm34.setPermanentAddress(box.getString(PERMANENT_ADDRESS));
				}
				if(box.getInt(PERMANENT_CITY_ID) !=0){
					int pdistrictId = box.getInt(PERMANENT_CITY_ID);
					MasDistrict permanentDistrict = new MasDistrict();
					permanentDistrict.setId(pdistrictId);
					aviCaForm34.setPermanentDistrict(permanentDistrict);
				}
				if(box.getInt(PERMANENT_STATE_ID) !=0){
					int pstateId = box.getInt(PERMANENT_STATE_ID);
					MasState permanentState = new MasState();
					permanentState.setId(pstateId);
					aviCaForm34.setPermanentState(permanentState);
				}
				if(box.getInt(TYPE_OF_LICENCE)!=0){
					MasCaLicence typeOfLicenceApplied = new MasCaLicence();
					typeOfLicenceApplied.setId(box.getInt(TYPE_OF_LICENCE));
					aviCaForm34.setTypeOfLicenceApplied(typeOfLicenceApplied);
				}
				if(box.getInt(LICENCE_HELD)!=0){
					MasCaLicence licenceHeld = new MasCaLicence();
					licenceHeld.setId(box.getInt(LICENCE_HELD));
					aviCaForm34.setLicenceHeld(licenceHeld);
				}
				
				if (!box.getString(AIRCRAFT_PRESENT_FLOWN).equals("")) {
					aviCaForm34.setAircraftPresentlyFlown(box.getString(AIRCRAFT_PRESENT_FLOWN));
				}
				if (box.getInt(FLYING_EXPERIENCE) != 0) {
					aviCaForm34.setFlyingExperience(box.getInt(FLYING_EXPERIENCE));
				}
				if (box.getInt(SINCE_LAST_EXAMINATION) != 0) {
					aviCaForm34.setSinceLastExamination(box.getInt(SINCE_LAST_EXAMINATION));
				}
				if (box.getString(PLACE) != null) {
					aviCaForm34.setPlace(box.getString(PLACE));
				}
				Date placeDate = null;
				if (!box.get(DATE) .equals("")) {
					placeDate = HMSUtil.convertStringTypeDateToDateType(box.getString(DATE));
					aviCaForm34.setLastExaminationDate(placeDate);
				}
				if (!box.getString(FINAL_OBSEZVATION).equals("")) {
					aviCaForm34.setFinalObservation(box.getString(FINAL_OBSEZVATION));
				}
				if (!box.getString("cause") .equals("")) {
					aviCaForm34.setUnfitReason(box.getString("cause"));
				}
				if (!box.getString(GENERAL) .equals("") ){
					aviCaForm34.setDgcaOfficeRefNo(box.getString(GENERAL));
				}
				Date dateOne = null;
				if (!box.getString(DATE_ONE).equals("")) {
					dateOne = HMSUtil.convertStringTypeDateToDateType(box.getString(DATE_ONE));
					aviCaForm34.setDgcaDate(dateOne);
				}
				if (!box.getString(ILLNESS).equals("")) {
					aviCaForm34.setWorkLoss(box.getString(ILLNESS));
				}
				if (!box.getString("detailsIllness") .equals("")) {
					aviCaForm34.setWorkLossYesDetail(box.getString("detailsIllness"));
				}
				if (!box.getString(PHYSICAL) .equals("")) {
					aviCaForm34.setPhysicalCondition(box.getString(PHYSICAL));
				}
				if (!box.getString(DRUG) .equals("")) {
					aviCaForm34.setPresentDrug(box.get(DRUG));
				}
				if (!box.getString("detailDrug").equals("")) {
					aviCaForm34.setPresentDrugYesDetail(box.getString("detailDrug"));
				}
				if (box.getString(DD_NO) != null) {
					aviCaForm34.setDdNo(box.getString(DD_NO));
				}
				Date dateTwo = null;
				if (!box.getString(DATE_TWO) .equals("") ){
					dateTwo = HMSUtil.convertStringTypeDateToDateType(box.getString(DATE_TWO));
					aviCaForm34.setDdNoDate(dateTwo);
				}
				if (box.getInt(AMOUNT) != 0) {
					aviCaForm34.setAmount(box.getInt(AMOUNT));
				}
				if (box.getString(REMARKS) != null) {
					aviCaForm34.setRemarks(box.getString(REMARKS));
				}
				if (box.getInt(BANK_ID)!=0) {
					int bankId =box.getInt(BANK_ID);
					MasBankMaster masBankMaster = new MasBankMaster();
					masBankMaster.setId(bankId);
					aviCaForm34.setBank(masBankMaster);
				}
				Date lastChgDate = null;
				if (!box.getString(CHANGED_DATE) .equals("") ){
					lastChgDate = HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE));
					aviCaForm34.setLastChgDate(lastChgDate);
				}
				String lastChgTime = "";
				if (!box.getString(CHANGED_TIME).equals("") ){
					lastChgTime = box.getString(CHANGED_TIME);
					aviCaForm34.setLastChgTime(lastChgTime);
				}
				aviCaForm34.setStatus("a");
				
			 hbt.save(aviCaForm34);
			}
			successfullyAdded=true;
			tx.commit();
	}catch (Exception e) {
		if (tx != null)
			tx.rollback();
		successfullyAdded=false;
		e.printStackTrace();
	}
	return successfullyAdded;
	}
	public Map<String, Object> submitCasualtyAirEvacuationJsp(
			Map<String, Object> infoMap) {
	/*	boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(aviCasualtyAirEvacuation);
		successfullyAdded = true;
		return successfullyAdded;*/

		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Session session = (Session) getSession();
		AviCasualtyAirEvacuation aviCasualtyAirEvacuation = new AviCasualtyAirEvacuation();
		if (infoMap.get("aviCasualtyAirEvacuation") != null) {
			aviCasualtyAirEvacuation = (AviCasualtyAirEvacuation) infoMap.get("aviCasualtyAirEvacuation");
		}
		int avAccidentId=0;
		if (infoMap.get("avAccidentId") != null) {
			avAccidentId = (Integer) infoMap.get("avAccidentId");
		}
		int avAccidentIdd=0;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (infoMap.get("aviCasualtyAirEvacuation") != null) {
			if(avAccidentId !=0){
				AviCasualtyAirEvacuation casualAirEvacObj = (AviCasualtyAirEvacuation) hbt.load(AviCasualtyAirEvacuation.class, avAccidentId);
			hbt.update(casualAirEvacObj);
			avAccidentIdd = casualAirEvacObj.getId();
			}else {
				aviCasualtyAirEvacuation = (AviCasualtyAirEvacuation) infoMap.get("aviCasualtyAirEvacuation");
				hbt.save(aviCasualtyAirEvacuation);
				avAccidentIdd = aviCasualtyAirEvacuation.getId();
			} 
			}
			saved = true;
		 tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		map.put("saved",saved);
		map.put("avAccidentIdd",avAccidentIdd);
		return map;
		
	
	
	}

	@Override
	public Boolean updateCasualtyAirEvacuationJsp(AviCasualtyAirEvacuation aviCasualtyAirEvacuation,
			Map<String, Object> generalMap) {


		boolean updatedSuccessfully = false;
		int aviCasualtyAirEvacuationId = (Integer) generalMap.get("aviCasualtyAirEvacuationId");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
		
			AviCasualtyAirEvacuation aviCasualtyAirEvacuationObj = (AviCasualtyAirEvacuation) hbt.load(AviCasualtyAirEvacuation.class, aviCasualtyAirEvacuationId);
			

			if (generalMap.get("hospitalId") != null) {
				int hospitalId = (Integer) generalMap.get("hospitalId");
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				aviCasualtyAirEvacuationObj.setHospital(masHospital);
			}

			if (generalMap.get("departmentId") != null) {
				int departmentId = (Integer) generalMap.get("departmentId");
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				aviCasualtyAirEvacuationObj.setDepartment(masDepartment);
			}

			if (generalMap.get("rankId") != null) {
				int rankId = (Integer) generalMap.get("rankId");
				MasRank masRank = new MasRank();
				masRank.setId(rankId);
				aviCasualtyAirEvacuationObj.setRank(masRank);
			}
			if (generalMap.get("serviceNo") != null) {
				String serviceNo = (String) generalMap.get("serviceNo");
				aviCasualtyAirEvacuationObj.setServiceNo(serviceNo);
			}
			if (generalMap.get("fName") != null) {
				String SfirstName = (String) generalMap.get("fName");
				aviCasualtyAirEvacuationObj.setFirstName(SfirstName);
			}
			if (generalMap.get("mName") != null) {
				String SmiddleName = (String) generalMap.get("mName");
				aviCasualtyAirEvacuationObj.setMiddleName(SmiddleName);
			}
			if (generalMap.get("lName") != null) {
				String SlastName = (String) generalMap.get("lName");
				aviCasualtyAirEvacuationObj.setLastName(SlastName);
			}

		
			if (generalMap.get("unitId") != null) {
				Integer unitId = Integer.parseInt("" + generalMap.get("unitId"));
				MasUnit masUnit = new MasUnit();
				masUnit.setId(unitId);
				aviCasualtyAirEvacuationObj.setUnit(masUnit);
			}
			if (generalMap.get("tradeId") != null) {
				Integer tradeId = Integer.parseInt("" + generalMap.get("tradeId"));
				MasTrade masTrade = new MasTrade();
				masTrade.setId(tradeId);
				aviCasualtyAirEvacuationObj.setTrade(masTrade);
			}
			if (generalMap.get("genderId") != null) {
				Integer genderId = Integer.parseInt("" + generalMap.get("genderId"));
				MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
				masAdministrativeSex.setId(genderId);
				aviCasualtyAirEvacuationObj.setGender(masAdministrativeSex);
			
			}
			
			if (generalMap.get("casualtyAirEvacuationDate") != null) {
				Date casualtyAirEvacuationDate = (Date) generalMap.get("casualtyAirEvacuationDate");
				aviCasualtyAirEvacuationObj.setCasualtyAirEvacuationDate(casualtyAirEvacuationDate);
			}
			if (generalMap.get("casualtyAirEvacuationTime") != null) {
				String casualtyAirEvacuationTime = (String) generalMap.get("casualtyAirEvacuationTime");
				aviCasualtyAirEvacuationObj.setCasualtyAirEvacuationTime(casualtyAirEvacuationTime);
			}
			if (generalMap.get("totalService") != null) {
				int totalService = (Integer) generalMap.get("totalService");
				aviCasualtyAirEvacuationObj.setTotalService(totalService);
			}
			if (generalMap.get("srage") != null) {
				String srage = (String) generalMap.get("srage");
				aviCasualtyAirEvacuationObj.setAge(srage);
			}
			if (generalMap.get("dateCasualtyArrival") != null) {
				Date dateCasualtyArrival = (Date) generalMap.get("dateCasualtyArrival");
				aviCasualtyAirEvacuationObj.setDateCasualtyArrival(dateCasualtyArrival);
			}
			if (generalMap.get("timeCasualtyArrival") != null) {
				String timeCasualtyArrival = (String) generalMap.get("timeCasualtyArrival");
				aviCasualtyAirEvacuationObj.setTimeCasualtyArrival(timeCasualtyArrival);
			}
			if (generalMap.get("clinical") != null) {
				String clinical = (String) generalMap.get("clinical");
				aviCasualtyAirEvacuationObj.setClinical(clinical);
			}
			if (generalMap.get("diagnosis") != null) {
				String diagnosis = (String) generalMap.get("diagnosis");
				aviCasualtyAirEvacuationObj.setDiagnosis(diagnosis);
			}
			if (generalMap.get("condition") != null) {
				String condition = (String) generalMap.get("condition");
				aviCasualtyAirEvacuationObj.setCondition(condition);
			}
			if (generalMap.get("conditionStatus") != null) {
				String conditionStatus = (String) generalMap.get("conditionStatus");
				aviCasualtyAirEvacuationObj.setConditionStatus(conditionStatus);
			}
			if (generalMap.get("timeCondition") != null) {
				String timeCondition = (String) generalMap.get("timeCondition");
				aviCasualtyAirEvacuationObj.setTimeCondition(timeCondition);
			}
			
			if (generalMap.get("dateCondition") != null) {
				Date dateCondition = (Date) generalMap.get("dateCondition");
				aviCasualtyAirEvacuationObj.setDateCondition(dateCondition);
			}
			
			if (generalMap.get("casualty") != null) {
				String casualty = (String) generalMap.get("casualty");
				aviCasualtyAirEvacuationObj.setCasualty(casualty);
			}
			
			if (generalMap.get("dateCasualty") != null) {
				Date dateCasualty = (Date) generalMap.get("dateCasualty");
				aviCasualtyAirEvacuationObj.setDateCasualty(dateCasualty);
			}
			if (generalMap.get("timeCasualty") != null) {
				String timeCasualty = (String) generalMap.get("timeCasualty");
				aviCasualtyAirEvacuationObj.setTimeCasualty(timeCasualty);
			}
			
			if (generalMap.get("diffculties") != null) {
				String diffculties = (String) generalMap.get("diffculties");
				aviCasualtyAirEvacuationObj.setDiffculties(diffculties);
			}
			
			if (generalMap.get("disposal") != null) {
				String disposal = (String) generalMap.get("disposal");
				aviCasualtyAirEvacuationObj.setDisposal(disposal);
			}
			
			if (generalMap.get("remarks") != null) {
				String remarks = (String) generalMap.get("remarks");
				aviCasualtyAirEvacuationObj.setRemarks(remarks);
			}
			
			if (generalMap.get("aircraftTypeId") != null) {
				Integer aircraftTypeId = Integer.parseInt("" + generalMap.get("aircraftTypeId"));
				MasAircraftType masAircraftType = new MasAircraftType();
				masAircraftType.setId(aircraftTypeId);
				aviCasualtyAirEvacuationObj.setAircraftType(masAircraftType);
			}
			if (generalMap.get("radioForTable") != null) {
				String radioForTable = (String) generalMap.get("radioForTable");
				aviCasualtyAirEvacuationObj.setRadioForTable(radioForTable);
			}
			
			if (generalMap.get("totalDuration") != null) {
				int totalDuration = (Integer) generalMap.get("totalDuration");
				aviCasualtyAirEvacuationObj.setTotalDuration(totalDuration);
			}
			
			if (generalMap.get("durationHolding") != null) {
				int durationHolding = (Integer) generalMap.get("durationHolding");
				aviCasualtyAirEvacuationObj.setDurationHolding(durationHolding);
			}
			
			if (generalMap.get("enrouteHoldingUnitId") != null) {
			Integer enrouteHoldingUnitId = Integer.parseInt("" + generalMap.get("enrouteHoldingUnitId"));
			MasUnit enrouteHoldingUnit = new MasUnit();
			enrouteHoldingUnit.setId(enrouteHoldingUnitId);
			aviCasualtyAirEvacuationObj.setEnrouteHoldingUnit(enrouteHoldingUnit);
			}
			if (generalMap.get("lastChgDate") != null) {
				Date lastChgDate = (Date) generalMap.get("lastChgDate");
				aviCasualtyAirEvacuationObj.setLastChgDate(lastChgDate);
			}
		

			
			
			String lastChgTime = "";
			if (generalMap.get("lastChgTime") != null) {
				lastChgTime = (String) generalMap.get("lastChgTime");
				aviCasualtyAirEvacuationObj.setLastChgTime(lastChgTime);
			}
			aviCasualtyAirEvacuationObj.setStatus("y");
			

			hbt.update(aviCasualtyAirEvacuationObj);
			updatedSuccessfully = true;
	} catch (DataAccessException e) {
		e.printStackTrace();
		
	}
	return updatedSuccessfully;
	
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getServiceNoDetailsForRegCasualty(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = box.getString("serviceNo");
		List<MasAircraftType> aircraftTypeList = new ArrayList<MasAircraftType>();
		List<AviCasualtyAirEvacuation> aviCasualtyAirEvacuationList = new ArrayList<AviCasualtyAirEvacuation>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		/*List<MasSection> sectionList = new ArrayList<MasSection>();
		List<MasStation> stationList = new ArrayList<MasStation>();
		List<MasServiceStatus> serviceStatusList = new ArrayList<MasServiceStatus>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasCommand>  commandList = new ArrayList<MasCommand>();*/
		List<MasRecordOfficeAddress> recordOffList = new ArrayList<MasRecordOfficeAddress>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasAdministrativeSex> genderList = new ArrayList<MasAdministrativeSex>();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		org.hibernate.Session session = getSession();
		
		aviCasualtyAirEvacuationList = session.createCriteria(AviCasualtyAirEvacuation.class).add(Restrictions.eq("ServiceNo", serviceNo)).add(Restrictions.eq("Status", "y")).list();
	patientList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
		.add(Restrictions.eq("Status", "y")).createAlias("Relation", "rel")
		.add(Restrictions.eq("rel.RelationName", "Self")).list();
	genderList=	session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).list();
	aircraftTypeList = session.createCriteria(MasAircraftType.class).add(Restrictions.eq("Status", "y")).list();
	unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();
	tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).list();
	/*serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).list();
	sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y")).list();
	serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).list();
	stationList = session.createCriteria(MasStation.class).add(Restrictions.eq("Status", "y")).list();
	commandList = session.createCriteria(MasCommand.class).add(Restrictions.eq("Status", "y")).list();*/
	rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
	recordOffList = session.createCriteria(MasRecordOfficeAddress.class).add(Restrictions.eq("Status", "y")).list();
		map.put("unitList", unitList);
		/*map.put("commandList", commandList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("sectionList", sectionList);
		map.put("stationList", stationList);
		map.put("serviceTypeList", serviceTypeList);*/
		map.put("genderList", genderList);
		map.put("rankList", rankList);
		map.put("patientList", patientList);
		map.put("tradeList", tradeList);
		map.put("recordOffList", recordOffList);
		map.put("aircraftTypeList", aircraftTypeList);
		map.put("aviCasualtyAirEvacuationList", aviCasualtyAirEvacuationList);	
		return map;
	}
	

	@Override
	public Map<String, Object> showWaitingForACForm34Jsp(Map<String, Object> mapforDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AviCa34> medExamWaitingList = new ArrayList<AviCa34>();
		Session session = (Session) getSession();
		Date currentDate = new Date();
		medExamWaitingList=session.createCriteria(AviCa34.class)
							.add(Restrictions.eq("Status", "y")).list();
		map.put("medExamWaitingList", medExamWaitingList);
		return map;
	}

	@Override
	public Map<String, Object> getWaitingCurrentCAForm34(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AviCa34> appointmentList = new ArrayList<AviCa34>();
		Date currentDate = new Date();

		Session session = (Session) getSession();
		Criteria crit = null;

		try {
			crit = session.createCriteria(AviCa34.class).add(
					Restrictions.eq("Status", "y")).add(
					Restrictions.eq("AppointmentDate", currentDate));
			appointmentList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("appointmentList", appointmentList);
		return map;
	}

	@Override
	public Map<String, Object> getWaitingForACForm34(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AviCa34> appointmentList = new ArrayList<AviCa34>();
		Date fromDate = new Date();
		Date toDate = new Date();
		if (detailsMap.get("fromDate") != null) {
			fromDate = (Date) detailsMap.get("fromDate");
		}
		if (detailsMap.get("toDate") != null) {
			toDate = (Date) detailsMap.get("toDate");
		}
		Session session = (Session) getSession();
		Criteria crit = null;
		try {
			appointmentList = session.createCriteria(AviCa34.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.between("AppointmentDate", fromDate,toDate)).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("appointmentList", appointmentList);
		return map;
	}
//---CancelAppointment By Dipali
	@Override
	public Boolean submitCancelAppointment(Box box) {
		Session session = (Session) getSession();
		Boolean successfullyAdded = false;
		HibernateTemplate hbt = null;
		Transaction tx = null;
		
	try {
		tx = session.beginTransaction();
		hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Vector aviCa34Id = box.getVector("aviCa34Id");
		Vector checkedAppointValue = box.getVector("checkedAppointvalue");
		String appointmentDate = box.getString("appointmentDate");
		for (int inc = 0; inc<checkedAppointValue.size(); inc++) {
		AviCa34 aviCa34  =(AviCa34) hbt.load(AviCa34.class,Integer.parseInt((String) aviCa34Id.get(inc)));
		if (checkedAppointValue.get(inc) != null && !checkedAppointValue.get(inc).equals("")) {
			aviCa34.setStatus("c");}
			aviCa34.setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(appointmentDate));
		
		hbt.saveOrUpdate(aviCa34);
		hbt.refresh(aviCa34);
		}
		successfullyAdded=true;
		tx.commit();
		}catch (Exception e) {
			if (tx != null)
				tx.rollback();
			successfullyAdded=false;
			e.printStackTrace();
		}
		return successfullyAdded;
		}

	@Override
	public Map<String, Object> showWaitingListForExaminationMA(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
	List<AviCa34> aviCa34List = new ArrayList<AviCa34>();
	Session session = (Session) getSession();
	Date currentDate = new Date();
	aviCa34List = session.createCriteria(AviCa34.class).add(Restrictions.eq("Status","a"))
			.add(Restrictions.eq("AppointmentDate", currentDate)).createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.desc("Id")).list();
	
	map.put("aviCa34List", aviCa34List);
	return map;
	}

	@Override
	public Map<String, Object> showCivilAviationMedExamMAJsp(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		List<Visit> visit = null;
		int avica34Id=0;
		if(dataMap.get("avica34Id") !=null){
			avica34Id=(Integer)dataMap.get("avica34Id");
		}
		int medExamMaMoId=0;
		if(dataMap.get("medExamMaMoId") !=null){
			medExamMaMoId=(Integer)dataMap.get("medExamMaMoId");
		}
		Session session = (Session) getSession();
		int visitId=(Integer)dataMap.get("visitId");
		int deptId=(Integer)dataMap.get("deptId");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		Query qry=session.createQuery("from Visit as v where v.Id=:visitId");
		if(visitId!=0){
			qry.setParameter("visitId", visitId);
		}
		visit = qry.list();
		
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		templateList = session.createCriteria(OpdTemplate.class).createAlias("Department", "dept").add(
				Restrictions.eq("dept.Id",deptId)).add(Restrictions.eq("Status", "y")).list();
		
		List<AviCa34> aviCa34List = new ArrayList<AviCa34>();
		aviCa34List = session.createCriteria(AviCa34.class).add(Restrictions.eq("Id",avica34Id)).list();
		List<AvMedicalExamMaMo> medicalExamMaMoList = new ArrayList<AvMedicalExamMaMo>();
		if(medExamMaMoId!=0)
		{			medicalExamMaMoList = session.createCriteria(AvMedicalExamMaMo.class).add(Restrictions.idEq(medExamMaMoId)).add(Restrictions.eq("AvStatus", "p").ignoreCase()).list();
		}else{
			medicalExamMaMoList = session.createCriteria(AvMedicalExamMaMo.class).add(Restrictions.eq("Visit.Id",visitId)).list();	  
		}
		Visit visitdata=null;
		List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();

		if(visit!=null&&visit.size()>0)
		{
			visitdata= visit.get(0);
		}
		int hinId=0;
		hinId=visitdata.getHin().getId();
		/*patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
		.createCriteria(PatientInvestigationHeader.class)
		.createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId))
				.createAlias("Hin", "p").add(Restrictions.eq("p.Id",visitdata.getHin().getId())).addOrder(Order.desc("Id"))
						.list();*/
		patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
		.createCriteria(PatientInvestigationHeader.class)
		.createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId))
				.addOrder(Order.desc("Id")).list();
		if (patientInvestigationHeaderList != null && patientInvestigationHeaderList.size() > 0) {
			patientInvestigationHeader = patientInvestigationHeaderList.get(0);
			map.put("patientInvestigationHeader",patientInvestigationHeader);

		}
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		dgOrderhdList = (List<DgOrderhd>) session
		.createCriteria(DgOrderhd.class)
		.createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();

		DgOrderhd dgOrderhd =null;
		if (dgOrderhdList != null && dgOrderhdList.size() > 0) {
			dgOrderhd = dgOrderhdList.get(0);
			map.put("dgOrderhd",dgOrderhd);

		}
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		resultList = session.createCriteria(DgResultEntryHeader.class)
		.createAlias("SampleCollectionHeader", "smColl").createAlias("smColl.Order", "order")
		.createAlias("order.Visit", "vst").add(Restrictions.eq("vst.Id", visitId))
		.add(Restrictions.eq("ResultStatus", "A")).list();
		if (resultList != null || resultList.size() > 0) {
			map.put("resultList", resultList);
		}			
		map.put("templateList",templateList);
		map.put("medicalExamMaMoList", medicalExamMaMoList);
		map.put("visit", visit);
		map.put("aviCa34List",aviCa34List);
		return map;
	}

	@Override
	public Map<String, Object> getForAviationMA(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AviCa34> aviCa34List = new ArrayList<AviCa34>();
		Session session = (Session) getSession();
		int hospitalId =0;
		Date appointmentDate = new Date();
		String name="";
		String licenceNo="";
		Criteria crit = null;
		if(detailsMap.get("hospitalId") !=null){
			hospitalId=(Integer)detailsMap.get("hospitalId");
		}
		if(detailsMap.get("appointmentDate") !=null){
			appointmentDate=(Date)detailsMap.get("appointmentDate");
		}
		crit  = session.createCriteria(AviCa34.class).add(Restrictions.eq("Status","a"))
		.add(Restrictions.eq("AppointmentDate", appointmentDate)).createAlias("Hospital", "h")
			.add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.desc("Id"));
		if (!name.equals("")) {
			crit = crit.add(Restrictions.like("FirstName", name + "%").ignoreCase());
		}
		if (!licenceNo.equals("")) {
			crit = crit.add(Restrictions.eq("LicenceNo", licenceNo));
		}
		/*if (!appointmentDate.equals("")) {
			crit = crit.add(Restrictions.eq("AppointmentDate", appointmentDate));
		}*/
		aviCa34List=crit.list();
		map.put("aviCa34List", aviCa34List);
		return map;
		}

	public Map<String, Object> submitAviationAccidentEntry(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Session session = (Session) getSession();
		AvAccident avAccident = new AvAccident();
		
		/*if (infoMap.get("avAccident") != null) {
			avAccident = (AvAccident) infoMap.get("avAccident");
		}*/
		int avAccidentId=0;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			try {
		    		if (infoMap.get("avAccident") != null) {
					avAccident = (AvAccident) infoMap.get("avAccident");
					hbt.save(avAccident);
					avAccidentId = avAccident.getId();
				
			Box box = null;
			if (infoMap.get("box") != null) {
				box = (Box) infoMap.get("box");
			}
			if(avAccidentId >0){
			Vector serviceNo = box.getVector("serviceNo");
			Vector rankId = box.getVector("rankId");
			Vector name = box.getVector("name");
			Vector crewStationSeating = box.getVector("crewStationSeating");
			Vector result = box.getVector("result");
			Vector enclUsedRing = box.getVector("enclUsedRing");
			for (int inc = 0; inc<serviceNo.size(); inc++) {
				AvGridDetails avGridDetails=new AvGridDetails();
				if(serviceNo.get(inc) !=null && !serviceNo.get(inc).equals("")){
				avGridDetails.setServiceNo(serviceNo.get(inc).toString());
				}
				if(name.get(inc) !=null && !name.get(inc).equals("")){
				avGridDetails.setName(name.get(inc).toString());
				}
				if(crewStationSeating.get(inc) !=null && !crewStationSeating.get(inc).equals("")){
				avGridDetails.setCrewStationSeating(crewStationSeating.get(inc).toString());
				}
				if(result.get(inc) !=null && !result.get(inc).equals("")){
				avGridDetails.setResult(result.get(inc).toString());
				}
				if(enclUsedRing.get(inc) !=null && !enclUsedRing.get(inc).equals("")){
				avGridDetails.setEnclUsed(enclUsedRing.get(inc).toString());}
				if (infoMap.get("avAccident") != null) {
					avGridDetails.setAvAccident(avAccident);
				}
				if(rankId.get(inc) !=null && !rankId.get(inc).equals("0")){
				MasRank masRank=new MasRank();
				masRank.setId(Integer.parseInt(rankId.get(inc).toString()));
				avGridDetails.setRank(masRank);
				}
				avGridDetails.setGridType("crewpassenger");
				hbt.save(avGridDetails);
			}
			
			Vector enclosursesDetails = box.getVector("enclosursesDetails");
			for (int inc = 0; inc<enclosursesDetails.size(); inc++) {
				AvGridDetails gridDetails=new AvGridDetails();
				if(enclosursesDetails.get(inc) !=null && !enclosursesDetails.get(inc).equals("")){
				gridDetails.setEnclosursDetail(enclosursesDetails.get(inc).toString());
				}
				if (infoMap.get("avAccident") != null) {
					gridDetails.setAvAccident(avAccident);
				}
				gridDetails.setGridType("enclosurses");
				hbt.save(gridDetails);
			}
			}
			saved = true;
		    		}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		 tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		map.put("saved",saved);
		map.put("avAccidentId",avAccidentId);
		return map;
	}

	@Override
	public Boolean submitAviationMA(AvMedicalExamMaMo avMedicalExamMaMo,
			Map<String, Object> infoMap) {
		String date = "";
		int visitId=0;
		int hinId=0;
		if(infoMap.get("visitId") !=null){
			visitId=(Integer)infoMap.get("visitId");
		}
		if(infoMap.get("hinId") !=null){
			hinId=(Integer)infoMap.get("hinId");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		org.hibernate.Session session = getSession();
		boolean successfullyAdded = false;
		boolean saveinvestigation = false;
		HibernateTemplate hbt = null;
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(avMedicalExamMaMo);
			saveinvestigation=saveInvestigationAdd(infoMap);
			
			//if (saveinvestigation) {
			//}
			successfullyAdded = true;
			 tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
			return successfullyAdded;
}
			public Boolean saveInvestigationAdd(Map mapForDS)
			{
				boolean saveinvestigation = false;
				int patientInvestigationHeaderId = 0;
				int dgOrderhdId = 0;
				int hinId = (Integer) mapForDS.get("hinId");
				int departmentId = (Integer) mapForDS.get("deptId");
				int visitId = (Integer) mapForDS.get("visitId");
				int hospitalId = (Integer) mapForDS.get("hospitalId");
				String orderSeqNo =(String)mapForDS.get("orderSeqNo");
				patientInvestigationHeaderId = (Integer) mapForDS
						.get("patientInvestigationHeaderId");
				dgOrderhdId = (Integer) mapForDS.get("dgOrderhdId");
				List<String> chargeCodeIdList = (List) mapForDS.get("chargeCodeIdList");
				List<String> investigationReferToMHList = (List) mapForDS
						.get("investigationReferToMHList");
				List<Integer> patientInvestigationdetailsIdList = (List) mapForDS
						.get("patientInvestigationdetailsIdList");
				List<Integer> dgOrderdtIdList = (List) mapForDS.get("dgOrderdtIdList");
				// List<Integer> patientInvestigationdetailsIdList = new
				// ArrayList<Integer>();
				// String
				// investigationDataStatus=(String)mapForDS.get("investigationDataStatus");
				String clinicalNotes1 = (String) mapForDS.get("clinicalNotes1");
				String userName = (String) mapForDS.get("userName");
				int empId = (Integer) mapForDS.get("empId");
				int userId = (Integer) mapForDS.get("userId");
				String lastChangedBy = (String) mapForDS.get("lastChangedBy");
				// Date lastChangedDate = (Date) mapForDS.get("lastChangedDate");
				String lastChangedTime = (String) mapForDS.get("lastChangedTime");
				/*
				 * Code commented by Mukesh Date 14 March 2012 //departmentId=117;
				 */

				departmentId = 117;
				// String deleatedValue=(String) mapForDS.get("deleatedValue");
				// String deleatedorderid=(String) mapForDS.get("deleatedorderid");
				Boolean data = false;
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

				if (patientInvestigationdetailsIdList.size() > 0
						&& patientInvestigationdetailsIdList.size() == chargeCodeIdList
								.size() && data == false) {
					saveinvestigation = true;
				} else if (chargeCodeIdList.size() > 0) {

					MasDepartment masDepartment = new MasDepartment();
					MasHospital masHospital = new MasHospital();
					Patient patient = new Patient();
					MasEmployee masEmployee2 = new MasEmployee();

					PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();

					DgOrderhd dgOrderhd = new DgOrderhd();
					if (patientInvestigationdetailsIdList.size() > 0) {
						patientInvestigationHeader.setId(patientInvestigationHeaderId);
						// dgOrderhd.setId(dgOrderhdId);
					} else if (patientInvestigationHeaderId > 0) {
						patientInvestigationHeader.setId(patientInvestigationHeaderId);
						// dgOrderhd.setId(dgOrderhdId);
					}
					if (dgOrderhdId > 0) {
						dgOrderhd.setId(dgOrderhdId);
					}
					if (hinId > 0) {
						patient.setId(hinId);
						patientInvestigationHeader.setHin(patient);
					}
					if (departmentId > 0) {
						masDepartment.setId(departmentId);
						patientInvestigationHeader.setDepartment(masDepartment);
					}
					Visit visit = new Visit();
					if (visitId > 0) {
						visit.setId(visitId);
						patientInvestigationHeader.setVisit(visit);
					}
					if (hospitalId > 0) {
						masHospital.setId(hospitalId);
						patientInvestigationHeader.setHospital(masHospital);
					}
					patientInvestigationHeader.setStatus("p");
					patientInvestigationHeader.setInvestigationDate(new Date());
					// String time=new Date().getTime();
					patientInvestigationHeader.setInvestigationTime(lastChangedTime);
					patientInvestigationHeader.setClinicalNotes(clinicalNotes1);

					// hbt.saveOrUpdate(patientInvestigationHeader);
					/*
					 * Code Commented By Mukesh 14 March 2012
					 * //hbt.save(patientInvestigationHeader);
					 */
					hbt.save(patientInvestigationHeader);

					dgOrderhd.setOrderDate(new Date());
					// dgOrderhd.setOrderTime(consultationTime);
					if (hospitalId > 0) {
						masHospital.setId(hospitalId);
						dgOrderhd.setHospital(masHospital);
					}
					if (hinId > 0) {
						patient.setId(hinId);
						dgOrderhd.setHin(patient);
					}
					if (departmentId > 0) {
						masDepartment.setId(departmentId);
						dgOrderhd.setDepartment(masDepartment);
					}
					if (empId != 0) {
						masEmployee2.setId(empId);
						dgOrderhd.setPrescribedBy(masEmployee2);
					}
					dgOrderhd.setPatientType("OP");
					dgOrderhd.setTestType("Regular");
					dgOrderhd.setCreatedby(lastChangedBy);
					dgOrderhd.setCreatedon(new Date());
					//String orderSeqNo = "";
					//orderSeqNo = generateOrderNumber(); By Tirath
					dgOrderhd.setOrderNo(orderSeqNo);
					if (visitId != 0) {
						visit = new Visit();
						visit.setId(visitId);
						dgOrderhd.setVisit(visit);
					}
					dgOrderhd.setClinicalNote(clinicalNotes1);
					dgOrderhd.setOrderStatus("P");
					dgOrderhd.setLabOrderStatus("P");
					dgOrderhd.setLastChgBy(userId);
					dgOrderhd.setLastChgDate(new Date());
					dgOrderhd.setLastChgTime(lastChangedTime);
					dgOrderhd.setOrderTime(lastChangedTime);
					dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
					// hbt.saveOrUpdate(dgOrderhd);
					/*
					 * Code Commented By Mukesh 14 March 2012 //hbt.save(dgOrderhd);
					 */
					hbt.save(dgOrderhd);
					int length = 0;
					for (int i = 0; i < chargeCodeIdList.size(); i++) {
						PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
						patientInvestigationDetails
								.setInvestigationHeader(patientInvestigationHeader);
						DgOrderdt dgOrderdt = new DgOrderdt();
						if (patientInvestigationdetailsIdList.size() > 0
								&& length != patientInvestigationdetailsIdList.size()) {
							++length;
							/*
							 * Code by Mukesh Date 01 Feb 2012
							 */

							if (patientInvestigationdetailsIdList.get(i) > 0) {
								patientInvestigationDetails
										.setId(patientInvestigationdetailsIdList.get(i));
							}
							if (dgOrderdtIdList.get(i) > 0) {
								dgOrderdt.setId(dgOrderdtIdList.get(i));
							}
							/*
							 * End of Code by Mukesh Date 01 Feb 2012
							 */
						}
						MasChargeCode masChargeCode = new MasChargeCode();
						masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
						patientInvestigationDetails.setChargeCode(masChargeCode);
						if (investigationReferToMHList != null) {
							patientInvestigationDetails
									.setReferToMh(investigationReferToMHList.get(i));
						}
						// hbt.saveOrUpdate(patientInvestigationDetails);
						hbt.save(patientInvestigationDetails);
						dgOrderdt.setOrderhd(dgOrderhd);
						masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
						dgOrderdt.setChargeCode(masChargeCode);
						dgOrderdt.setCreatedby(userName);
						dgOrderdt.setCreatedon(new Date());
						if (investigationReferToMHList != null) {
							dgOrderdt.setInvestigationToMH(investigationReferToMHList
									.get(i));
						}
						/*
						 * else { dgOrderdt. }
						 */

						dgOrderdt.setLastChgBy(userId);
						dgOrderdt.setLastChgDate(new Date());
						dgOrderdt.setLastChgTime(lastChangedTime);
						Map masChargeMap = getMasChargeCodeFromChargeId(Integer
								.parseInt(chargeCodeIdList.get(i)));
						MasChargeCode masChargeCodeObj = (MasChargeCode) masChargeMap
								.get("masChargeCode");
						int mainChargeId = masChargeCodeObj.getMainChargecode().getId();
						int subChargeId = masChargeCodeObj.getSubChargecode().getId();
						if (masChargeCodeObj.getMainChargecode()
								.getMainChargecodeCode().equalsIgnoreCase("Lab")) {
							dgOrderdt.setOrderStatus("P");
						} else {
							dgOrderdt.setOrderStatus("P");
						}
						MasMainChargecode masMainChargecode = new MasMainChargecode();
						masMainChargecode.setId(mainChargeId);
						dgOrderdt.setMainChargecode(masMainChargecode);
						MasSubChargecode masSubChargecode = new MasSubChargecode();
						masSubChargecode.setId(subChargeId);
						dgOrderdt.setSubChargeid(masSubChargecode);
						dgOrderdt.setInvestigation(new DgMasInvestigation(Integer
								.parseInt(chargeCodeIdList.get(i))));
						// hbt.saveOrUpdate(dgOrderdt);
						hbt.save(dgOrderdt);

						/*
						 * 
						 * Code By Mukesh Date 03 Feb 2012
						 * 
						 * Visit visitObj = (Visit)hbt.load(Visit.class, visitId);
						 * if(visitObj!=null) {
						 * 
						 * Code By Mukesh Date 03 Feb 2012
						 * 
						 * Priority Color Coding By Mukesh Normal Urgent Very Urgent New
						 * Data 3 2 1 Pending For Result 6 5 4 Rejected By MO 9 8 7
						 * 
						 * int priority=0; if(visitObj.getPriority()!=null){
						 * if(visitObj.getPriority()==1){ visitObj.setPriority(7);
						 * priority=7; }else if(visitObj.getPriority()==2){
						 * visitObj.setPriority(8); priority=8; }else
						 * if(visitObj.getPriority()==3){ visitObj.setPriority(9);
						 * priority=9; }else if(visitObj.getPriority()==4){
						 * visitObj.setPriority(7); priority=7; }else
						 * if(visitObj.getPriority()==5){ visitObj.setPriority(8);
						 * priority=8; }else if(visitObj.getPriority()==6){
						 * visitObj.setPriority(9); priority=9; }else
						 * if(visitObj.getPriority()==7){ visitObj.setPriority(7);
						 * priority=7; }else if(visitObj.getPriority()==8){
						 * visitObj.setPriority(8); priority=8; }else
						 * if(visitObj.getPriority()==9){ visitObj.setPriority(9);
						 * priority=9; } } //visitObj.setPriority(1);
						 * 
						 * hbt.update(visitObj); }
						 */
						saveinvestigation = true;
					}
				}
				return saveinvestigation;
			}
			public String generateOrderNumber(int hospitalId) {
				List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
				String date = "";

				Session session = (Session) getSession();
				String orderSeqNo = "";
				date = (String) utilMap.get("currentDate");
				String currentYear = date.substring(date.lastIndexOf("/") + 1);
				String lastOrderYear = "";
				int seqNo = 1;
				try {
					orderSeqNoList = session.createCriteria(TransactionSequence.class)
							.add(Restrictions.eq("TransactionPrefix", "ON")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
				} catch (HibernateException e) {
					e.printStackTrace();
				}

				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

				if (orderSeqNoList.size() > 0) {
				//	for (TransactionSequence transactionSequence : orderSeqNoList) {
						TransactionSequence obj = (TransactionSequence) orderSeqNoList
								.get(0);
						int id = obj.getId();
						String seqNoStr=obj.getTransactionSequenceNumber().toString();
						lastOrderYear=obj.getMonth().toString();
						if (currentYear.equals(lastOrderYear)) {
							
							seqNo = Integer.parseInt(seqNoStr);
						} else {
							seqNo = 0;
							lastOrderYear=currentYear;
						}
						seqNo=seqNo+1;
						TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				        
						orderSeqNo = orderSeqNo.concat(String.valueOf(seqNo));
						//orderSeqNo = orderSeqNo.concat("/").concat(String.valueOf(lastOrderYear));
						transactionSequenceObj.setTransactionSequenceNumber(Integer.parseInt(orderSeqNo));
						transactionSequenceObj.setMonth(Integer.parseInt(lastOrderYear));
						hbt.update(transactionSequenceObj);
				       hbt.refresh(transactionSequenceObj);
				       
				//	}
				} else if (orderSeqNoList.size() == 0) {
					TransactionSequence tsObj = new TransactionSequence();
					tsObj.setStatus("y");
					tsObj.setTablename("DgOrderhd");
					tsObj.setTransactionPrefix("ON");
					tsObj.setTransactionSequenceName("Order No");
					orderSeqNo = orderSeqNo.concat(String.valueOf(seqNo));
					//orderSeqNo = orderSeqNo.concat("/").concat(String.valueOf(currentYear));
					lastOrderYear=currentYear;
					tsObj.setTransactionSequenceNumber(Integer.parseInt(orderSeqNo));
					tsObj.setMonth(Integer.parseInt(currentYear));
					MasHospital hospital = new MasHospital();
					hospital.setId(hospitalId);
					tsObj.setHospital(hospital);
					hbt.save(tsObj);
				}
				orderSeqNo = orderSeqNo.concat("/").concat(String.valueOf(lastOrderYear));
				return orderSeqNo;
			}
			public Map<String, Object> getMasChargeCodeFromChargeId(int chargeId) {
				Session session = (Session) getSession();
				List<MasChargeCode> masChargeList = new ArrayList<MasChargeCode>();
				Map<String, Object> map = new HashMap<String, Object>();
				try {

					Criteria crit = session.createCriteria(MasChargeCode.class).add(
							Restrictions.eq("Id", chargeId));
					masChargeList = crit.list();
				} catch (HibernateException e) {
					e.printStackTrace();
				}
				MasChargeCode masChargeCode = masChargeList.get(0);

				map.put("masChargeCode", masChargeCode);

				return map;
			}

		@Override
		public Boolean updateAviationMA(Map<String, Object> infoMap) {
			String Labresult=(String)infoMap.get("Labresult");
			String data=(String)infoMap.get("data");
			int visitId=(Integer)infoMap.get("visitId");
			int avica34Id=(Integer)infoMap.get("avica34Id");
			boolean successfullyAdded = false;
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Date currentDate = new Date();
			try {
				AvMedicalExamMaMo avMedicalExamMaMo = new AvMedicalExamMaMo();
				if(infoMap.get("avMedicalExamMaMo") != null){
					avMedicalExamMaMo = (AvMedicalExamMaMo)infoMap.get("avMedicalExamMaMo");
				}
				boolean saveinvestigation = false;
				//saveinvestigation=saveInvestigationAdd(infoMap);
				saveinvestigation = updateInvestigation(infoMap);
				saveInvestigationResult(infoMap);
	            
	            if (saveinvestigation) {
	              hbt.update(avMedicalExamMaMo);
            	}
            	if(Labresult.equalsIgnoreCase("present") && data!=null)
            	{
            		Visit visit = (Visit)hbt.load(Visit.class, visitId);
            		visit.setVisitStatus("f");
            		hbt.update(visit);
            		
            		AviCa34 aviCa34 = (AviCa34)hbt.load(AviCa34.class, avica34Id);
            		aviCa34.setStatus("f");
            		aviCa34.setMedExamDate(currentDate);
            		hbt.update(aviCa34);
            		
            	}
	            	successfullyAdded = true;
	       	//------------
				} catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
				e.getCause();
			}
				
            	return successfullyAdded = true;
		}
			public Boolean saveInvestigationResult(Map mapForDS)
			{
				boolean saveinvestigation = false;
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				List<String> chargeCodeIdList = (List) mapForDS.get("chargeCodeIdList");
				List<String> investigationReferToMHList=(List)mapForDS.get("investigationReferToMHList");
				List<String> investResultList=(List)mapForDS.get("investResultList");
				String data=(String)mapForDS.get("data");
				Session session = (Session) getSession();
				int medExamMaMoId=(Integer)mapForDS.get("medExamMaMoId");
				if(data!=null)
				{
					List<AviationInvestResult> aviationResultList=session.createCriteria(AviationInvestResult.class)
					                          .add(Restrictions.eq("AvMedicalExamMaMo.Id", medExamMaMoId)).list();
					if(aviationResultList.size()>0)
					{
						for(AviationInvestResult aviationExam:aviationResultList)
						{
							session.delete(aviationExam);
						}
					}
					if(chargeCodeIdList.size()>0)
					{
						for(int i=0;i<chargeCodeIdList.size();i++)
						{
							AviationInvestResult aviationInvestResultObj=new AviationInvestResult();
							aviationInvestResultObj.setReferToMH(investigationReferToMHList.get(i));
							aviationInvestResultObj.setResult(investResultList.get(i));
							DgMasInvestigation dgMasInvestigation=new DgMasInvestigation();
							dgMasInvestigation.setId(Integer.parseInt(chargeCodeIdList.get(i)));
							aviationInvestResultObj.setDgMasInvestigation(dgMasInvestigation);
							AvMedicalExamMaMo medicalExamMaMoObj=new AvMedicalExamMaMo();
							medicalExamMaMoObj.setId(medExamMaMoId);
							aviationInvestResultObj.setAvMedicalExamMaMo(medicalExamMaMoObj);
							hbt.saveOrUpdate(aviationInvestResultObj);
							
						}
						saveinvestigation=true;
					}
				}
				
					
				return saveinvestigation;
			}

			@Override
			public Map<String, Object> showWaitingListForExaminationMO(
					int hospitalId) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<AvMedicalExamMaMo> aviationMaList = new ArrayList<AvMedicalExamMaMo>();
				Session session = (Session) getSession();
				Date currentDate = new Date();
				aviationMaList = session.createCriteria(AvMedicalExamMaMo.class).add(Restrictions.eq("AvStatus","f"))
						.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.desc("Id")).list();
				
				map.put("aviationMaList", aviationMaList);
				return map;
				}

			@Override
			public AvMedicalExamMaMo loadAviationExamObj(int medExamMaMoId) {
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				AvMedicalExamMaMo avMedicalExamMaMo = new AvMedicalExamMaMo();
				try {
					
					avMedicalExamMaMo = (AvMedicalExamMaMo)hbt.load(AvMedicalExamMaMo.class, medExamMaMoId);
				} catch (DataAccessException e) {
					e.printStackTrace();
				}
				return avMedicalExamMaMo;
			}

			@SuppressWarnings({ "null", "unchecked" })
			@Override
			public Map<String, Object> showCivilAviationMedExamMOJsp(
					Map<String, Object> dataMap) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<Visit> visit = null;
				/*int avica34Id=0;
				if(dataMap.get("avica34Id") !=null){
					avica34Id=(Integer)dataMap.get("avica34Id");
				}*/
				int medExamMaMoId=0;
				if(dataMap.get("medExamMaMoId") !=null){
					medExamMaMoId=(Integer)dataMap.get("medExamMaMoId");
				}
				Session session = (Session) getSession();
				int visitId=(Integer)dataMap.get("visitId");
				int deptId=(Integer)dataMap.get("deptId");
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				//visit =hbt.find("from Visit as v where v.Id='"+visitId+"'");
				Query qry=session.createQuery("from Visit as v where v.Id=:visitId");
				if(visitId!=0){
					qry.setParameter("visitId", visitId);
				}
				visit = qry.list();
				List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
				templateList = session.createCriteria(OpdTemplate.class).createAlias("Department", "dept").add(
						Restrictions.eq("dept.Id",deptId)).add(Restrictions.eq("Status", "y")).list();
				/*List<AviCa34> aviCa34List = new ArrayList<AviCa34>();
				aviCa34List = session.createCriteria(AviCa34.class).add(Restrictions.eq("Id",avica34Id)).list();*/
				List<AvMedicalExamMaMo> medicalExamMaMoList = new ArrayList<AvMedicalExamMaMo>();
				if(medExamMaMoId!=0)
				{					medicalExamMaMoList = session.createCriteria(AvMedicalExamMaMo.class).add(Restrictions.idEq(medExamMaMoId)).add(Restrictions.eq("AvStatus", "f").ignoreCase()).list();
				}else{
					medicalExamMaMoList = session.createCriteria(AvMedicalExamMaMo.class).add(Restrictions.eq("Visit.Id",visitId)).list();	  
				}
				Visit visitdata=null;
				List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
				PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();

				if(visit!=null && visit.size()>0)
				{
					visitdata= visit.get(0);
				}
				int hinId=0;
				hinId=visitdata.getHin().getId();
				/*patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
				.createCriteria(PatientInvestigationHeader.class)
				.createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId))
						.createAlias("Hin", "p").add(Restrictions.eq("p.Id",visitdata.getHin().getId())).addOrder(Order.desc("Id"))
								.list();*/
				patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
				.createCriteria(PatientInvestigationHeader.class)
				.createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId))
						.addOrder(Order.desc("Id")).list();
				if (patientInvestigationHeaderList != null && patientInvestigationHeaderList.size() > 0) {
					patientInvestigationHeader = patientInvestigationHeaderList.get(0);
					map.put("patientInvestigationHeader",patientInvestigationHeader);

				}
				List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
				dgOrderhdList = (List<DgOrderhd>) session
				.createCriteria(DgOrderhd.class)
				.createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();

				DgOrderhd dgOrderhd =null;
				if (dgOrderhdList != null && dgOrderhdList.size() > 0) {
					dgOrderhd = dgOrderhdList.get(0);
					map.put("dgOrderhd",dgOrderhd);

				}
				List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
				resultList = session.createCriteria(DgResultEntryHeader.class)
				.createAlias("SampleCollectionHeader", "smColl").createAlias("smColl.Order", "order")
				.createAlias("order.Visit", "vst").add(Restrictions.eq("vst.Id", visitId))
				.add(Restrictions.eq("ResultStatus", "A")).list();
				if (resultList != null || resultList.size() > 0) {
					map.put("resultList", resultList);
				}		
				map.put("templateList", templateList);
				map.put("medicalExamMaMoList", medicalExamMaMoList);
				map.put("visit", visit);
				//map.put("aviCa34List",aviCa34List);
				return map;
			}
			
			public Map<String, Object> showCAForm34AReportJsp(int hospitalId) {
				
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasCaLicence> caLicenceList= new ArrayList<MasCaLicence>();
				Session session = (Session) getSession();
				try {
					//caLicenceList= hbt.find("from MasCaLicence ms where ms.Status='y' order by ms.CaLicenceName asc");
					caLicenceList = session.createCriteria(MasCaLicence.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("CaLicenceName")).list();
					
					} catch (HibernateException e) {
					e.printStackTrace();
					
				}
				map.put("caLicenceList", caLicenceList);
				return map;
			}


		@Override
		public Map<String, Object> fillItemsForLicenceNo(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String licenceNo = "";
		if(dataMap.get("licenceNo") !=null){
			licenceNo=(String)dataMap.get("licenceNo");
		}
		List<AviCa34> aviCa34List = new ArrayList<AviCa34>();
		Session session = (Session) getSession();
		aviCa34List=session.createCriteria(AviCa34.class).add(Restrictions.eq("LicenceNo", licenceNo)).list();
		map.put("aviCa34List",aviCa34List);
		return map;
		}

		@Override
		public boolean submitPMRFileTracking(Map<String, Object> parameterMap) {
			Session session = (Session) getSession();
			Box box = null;
			if (parameterMap.get("box") != null) {
				box = (Box) parameterMap.get("box");
			}
			Boolean successfullyAdded = false;
			HibernateTemplate hbt = null;
			Transaction tx = null;
			
		try {
			tx = session.beginTransaction();
			hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Vector avic34Id = box.getVector("avic34Id");
			Vector receiveDate = box.getVector(RECEIVED_DATE);
			Vector receiveBy = box.getVector(RECEIVED_BY);
			Vector dispatchDate = box.getVector(DISPATCH_DATE);
			Vector dispatchBy = box.getVector(DISPATCHED_BY);
			Vector remarks = box.getVector(REMARKS);
			
			for (int inc = 0; inc<receiveDate.size(); inc++) {
			AviCa34 aviCa34  =(AviCa34) hbt.load(AviCa34.class,Integer.parseInt((String) avic34Id.get(inc)));
			if (receiveDate.get(inc) != null && !receiveDate.get(inc).equals("")) {
				if((String)remarks.get(inc) !=null ){
				aviCa34.setPmrRemarks((String)remarks.get(inc));}
				
				if(receiveDate.get(inc) !=null ){
					aviCa34.setPmrReceivedDate(HMSUtil.convertStringTypeDateToDateType(receiveDate.get(inc).toString()));}
				if(dispatchDate.get(inc) !=null && !dispatchBy.get(inc).equals("")){
					aviCa34.setPmrDispatchDate(HMSUtil.convertStringTypeDateToDateType(dispatchDate.get(inc).toString()));}
				if(receiveBy.get(inc) !=null && !receiveBy.get(inc).equals("0")){
				MasEmployee pmrReceiveBy=new MasEmployee();
				pmrReceiveBy.setId(Integer.parseInt(receiveBy.get(inc).toString()));
				aviCa34.setPmrReceiveBy(pmrReceiveBy);
				}
				if(dispatchBy.get(inc) !=null && !dispatchBy.get(inc).equals("0")){
					MasEmployee pmrDispatchBy=new MasEmployee();
					pmrDispatchBy.setId(Integer.parseInt(dispatchBy.get(inc).toString()));
					aviCa34.setPmrReceiveBy(pmrDispatchBy);
					}
			
			hbt.saveOrUpdate(aviCa34);
			hbt.refresh(aviCa34);
			}
			}
			successfullyAdded=true;
			tx.commit();
			}catch (Exception e) {
				if (tx != null)
					tx.rollback();
				successfullyAdded=false;
				e.printStackTrace();
			}
			return successfullyAdded;
			}

		@Override
		public Map<String, Object> getForPMRList(Map<String, Object> mapForDS) 
		{
			Session session = (Session) getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			// code by SKY
			employeeList=session.createCriteria(MasEmployee.class).createAlias("Rank", "mr").add(Restrictions.eq("Status","y")).addOrder(Order.asc("FirstName")).addOrder(Order.desc("mr.RankCategory")).list();
			map.put("employeeList",employeeList);
			return map;
		}

		@Override
		public Map<String, Object> getDetailAfterSearch(
				Map<String, Object> mapForDs) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<AviCa34> medExamPMRList = new ArrayList<AviCa34>();
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			String searchLicenceNo="";
			String searchName="";
			Date searchExamDate=null;
			Date searchAppointDate=null;
			if (mapForDs.get("searchLicenceNo") != null) {
				searchLicenceNo = (String) mapForDs.get("searchLicenceNo");
			}System.out.println(searchAppointDate+"<<<searchLicenceNo--DS----->"+searchLicenceNo);
			if (mapForDs.get("searchName") != null) {
				searchName = (String) mapForDs.get("searchName");
			}
			if (mapForDs.get("searchExamDate") != null) {
				searchExamDate = (Date) mapForDs.get("searchExamDate");
			}
			if (mapForDs.get("searchAppointDate") != null) {
				searchAppointDate = (Date) mapForDs.get("searchAppointDate");
			}
			Session session = (Session) getSession();
			try {
				employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
				Criteria criteria = session.createCriteria(AviCa34.class);
				if(searchLicenceNo!=""){
					
					criteria=criteria.add(Restrictions.eq("LicenceNo", searchLicenceNo.trim()));
					}											
				if(searchName !=""){
					
					criteria=criteria.add(Restrictions.eq("FirstName", searchName));
					}
				//if(!searchExamDate.equals("") ){
				if( searchExamDate != null ){
				
					criteria=criteria.add(Restrictions.eq("RenewalDueDate", searchExamDate));
					}
				//if(!searchAppointDate.equals("") ){
					if(searchAppointDate != null ){
					
					criteria=criteria.add(Restrictions.eq("AppointmentDate", searchAppointDate));
					}				
				medExamPMRList=criteria.list();
				map.put("medExamPMRList", medExamPMRList);		
				map.put("employeeList", employeeList);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return map;
		}
		@SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> showPaymentStatusJsp() {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasBankMaster> bankList=null;
			Session session = (Session) getSession();
			try {
				
				bankList = session.createCriteria(MasBankMaster.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("BankName")).list();
								
				} catch (HibernateException e) {
				e.printStackTrace();
				
			}
			map.put("bankList", bankList);
			return map;
		}
		@SuppressWarnings("unchecked")
		public Map<String, Object> getServiceNoDetailsForRegEquipmentInUse(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			String serviceNo = box.getString("serviceNo");
			List<MasUnit> unitList = null;
			List<MasRank> rankList = null;
			List<MasTrade> tradeList = null;
			List<Category> categoryList = null;
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			List<AvAccident> avAccidentList = new ArrayList<AvAccident>();
			List<Patient> patientList = new ArrayList<Patient>();
			org.hibernate.Session session = getSession();
			avAccidentList = session.createCriteria(AvAccident.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();
			patientList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
			.add(Restrictions.eq("Status", "y")).createAlias("Relation", "rel")
			.add(Restrictions.eq("rel.RelationName", "Self")).list();
			unitList =session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list(); 
			rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list(); 
			tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).list(); 
			categoryList = session.createCriteria(Category.class).list(); 
			map.put("avAccidentList",avAccidentList);
			map.put("patientList",patientList);
		
			map.put("unitList", unitList);
			map.put("rankList", rankList);
			map.put("tradeList", tradeList);
			map.put("categoryList", categoryList);
				
			return map;
		}

		@Override
		public AvAccident loadAviationAccident(int avAccidentId) {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			AvAccident avAccident = new AvAccident();
			try {
				
				avAccident = (AvAccident)hbt.load(AvAccident.class, avAccidentId);
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			return avAccident;
		}

		@Override
		public Map<String, Object> submitEquipmentFactors(Map<String, Object> infoMap) {
			Map<String, Object> map = new HashMap<String, Object>();
			boolean saved = false;
			Session session = (Session) getSession();
			AvAccident avAccident = new AvAccident();
			if (infoMap.get("avAccident") != null) {
				avAccident = (AvAccident) infoMap.get("avAccident");
			}
			int avAccidentId=0;
			if (infoMap.get("avAccidentId") != null) {
				avAccidentId = (Integer) infoMap.get("avAccidentId");
			}
			int avAccidentIdd=0;
			Transaction tx = null;
			try {
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				tx = session.beginTransaction();
				if (infoMap.get("avAccident") != null) {
				if(avAccidentId !=0){
					AvAccident avAccidentObj = (AvAccident) hbt.load(AvAccident.class, avAccidentId);
				hbt.update(avAccidentObj);
				avAccidentIdd = avAccidentObj.getId();
				}else {
					avAccident = (AvAccident) infoMap.get("avAccident");
					hbt.save(avAccident);
					avAccidentIdd = avAccident.getId();
				} 
				}
				saved = true;
			 tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
			map.put("saved",saved);
			map.put("avAccidentIdd",avAccidentIdd);
			return map;
		}

		@Override
		public Map<String, Object> submitAircraftAccident(
				Map<String, Object> infoMap) {
			Map<String, Object> map = new HashMap<String, Object>();
			boolean saved = false;
			Session session = (Session) getSession();
			AvAircraftAccident aircraftAccident = new AvAircraftAccident();
			if (infoMap.get("aircraftAccident") != null) {
				aircraftAccident = (AvAircraftAccident) infoMap.get("aircraftAccident");
			}
			int avAccidentId=0;
			if (infoMap.get("avAccidentId") != null) {
				avAccidentId = (Integer) infoMap.get("avAccidentId");
			}
			int avAccidentIdd=0;
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				if (infoMap.get("aircraftAccident") != null) {
				/*if(avAccidentId !=0){
					AvAircraftAccident aircraftAccidentObj = (AvAircraftAccident) hbt.load(AvAircraftAccident.class, avAccidentId);
				hbt.update(aircraftAccidentObj);
				avAccidentIdd = aircraftAccidentObj.getId();
				}else {
					aircraftAccident = (AvAircraftAccident) infoMap.get("aircraftAccident");
					hbt.save(aircraftAccident);
					avAccidentIdd = aircraftAccident.getId();
				} */
					
					aircraftAccident = (AvAircraftAccident) infoMap.get("aircraftAccident");
					hbt.save(aircraftAccident);
					avAccidentIdd = aircraftAccident.getId();
				}
				saved = true;
			 tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
			map.put("saved",saved);
			map.put("avAccidentIdd",avAccidentIdd);
			return map;
		}

		@Override
		public AvAircraftAccident loadAircraftAccident(int avAccidentId) {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			AvAircraftAccident aircraftAccident = new AvAircraftAccident();
			try {
				
				aircraftAccident = (AvAircraftAccident)hbt.load(AvAircraftAccident.class, avAccidentId);
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			return aircraftAccident;
		}

		@Override
		public AvFlyingIncident loadFlyingIncident(int avAccidentId) {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			AvFlyingIncident flyingIncident = new AvFlyingIncident();
			try {
				
				flyingIncident = (AvFlyingIncident)hbt.load(AvFlyingIncident.class, avAccidentId);
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			return flyingIncident;
		}

		@Override
		public Map<String, Object> submitFlyingIncident(
				Map<String, Object> infoMap) {
			Map<String, Object> map = new HashMap<String, Object>();
			boolean saved = false;
			Session session = (Session) getSession();
			AvFlyingIncident flyingIncident = new AvFlyingIncident();
			if (infoMap.get("flyingIncident") != null) {
				flyingIncident = (AvFlyingIncident) infoMap.get("flyingIncident");
			}
			int avAccidentId=0;
			if (infoMap.get("avAccidentId") != null) {
				avAccidentId = (Integer) infoMap.get("avAccidentId");
			}
			System.out.println("avAccidentId="+avAccidentId);
			int avAccidentIdd=0;
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				if (infoMap.get("flyingIncident") != null) {
				/*if(avAccidentId !=0){
					AvFlyingIncident aircraftAccidentObj = (AvFlyingIncident) hbt.load(AvFlyingIncident.class, avAccidentId);
				hbt.update(aircraftAccidentObj);
				avAccidentIdd = aircraftAccidentObj.getId();
				}else {
					flyingIncident = (AvFlyingIncident) infoMap.get("flyingIncident");
					hbt.save(flyingIncident);
					avAccidentIdd = flyingIncident.getId();
				} */
					flyingIncident = (AvFlyingIncident) infoMap.get("flyingIncident");
					hbt.save(flyingIncident);
					avAccidentIdd = flyingIncident.getId();
				}
				saved = true;
			 tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
			
			System.out.println("avAccidentIdd="+avAccidentIdd);
			map.put("saved",saved);
			map.put("avAccidentIdd",avAccidentIdd);
			return map;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> getSerNoDetailForIncident(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			String serviceNo = box.getString("serviceNo");
			List<AvFlyingIncident> flyingIncidentList = new ArrayList<AvFlyingIncident>();
			List<Patient> patientList = new ArrayList<Patient>();
			List<MasUnit> unitList = new ArrayList<MasUnit>();
			List<MasRank> rankList = new ArrayList<MasRank>();
			List<MasAdministrativeSex>sexList = new ArrayList<MasAdministrativeSex>();
			List<MasAircraftType> airCraftList = new ArrayList<MasAircraftType>();
			Session session = (Session) getSession();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			try {
			flyingIncidentList = session.createCriteria(AvFlyingIncident.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();
			patientList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
				.add(Restrictions.eq("Status", "y")).createAlias("Relation", "rel")
				.add(Restrictions.eq("rel.RelationName", "Self")).list();
		
			
				unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();
				rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
				sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).list();
				airCraftList = session.createCriteria(MasAircraftType.class).add(Restrictions.eq("Status", "y")).list();
				} catch (HibernateException e) {
				e.printStackTrace();
				}
				map.put("flyingIncidentList",flyingIncidentList);
				map.put("patientList", patientList);
				map.put("airCraftList",airCraftList);
				map.put("unitList", unitList);
				map.put("rankList", rankList);
				map.put("sexList", sexList);
				return map;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> showFlyingIncidentJsp() {
			Map<String, Object> map = new HashMap<String, Object>();
			List<MasUnit> unitList = new ArrayList<MasUnit>();
			List<MasRank> rankList = new ArrayList<MasRank>();
			List<MasAircraftType> airCraftList = new ArrayList<MasAircraftType>();
			List<MasAdministrativeSex>sexList = new ArrayList<MasAdministrativeSex>();
			Session session = (Session) getSession();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
		try {
			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
			rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
			airCraftList = session.createCriteria(MasAircraftType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AircraftTypeName")).list();
			sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			}
		map.put("airCraftList",airCraftList);
		map.put("unitList", unitList);
		map.put("rankList", rankList);
		map.put("sexList", sexList);
			return map;
		}

		@Override
		public Map<String, Object> getSerNoDetailForAccident(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			String serviceNo = box.getString("serviceNo");
			List<AvAircraftAccident> aircraftAccidentList = new ArrayList<AvAircraftAccident>();
			List<Patient> patientList = new ArrayList<Patient>();
			List<MasUnit> unitList = new ArrayList<MasUnit>();
			List<MasRank> rankList = new ArrayList<MasRank>();
			List<MasAdministrativeSex>sexList = new ArrayList<MasAdministrativeSex>();
			List<MasAircraftType> airCraftList = new ArrayList<MasAircraftType>();
			Session session = (Session) getSession();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			try {
				aircraftAccidentList = session.createCriteria(AvAircraftAccident.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();
				patientList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
						.add(Restrictions.eq("Status", "y")).createAlias("Relation", "rel")
						.add(Restrictions.eq("rel.RelationName", "Self")).list();
		
			
				unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();
				rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
				sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).list();
				airCraftList = session.createCriteria(MasAircraftType.class).add(Restrictions.eq("Status", "y")).list();
				} catch (HibernateException e) {
				e.printStackTrace();
				}
				map.put("aircraftAccidentList",aircraftAccidentList);
				map.put("patientList", patientList);
				map.put("airCraftList",airCraftList);
				map.put("unitList", unitList);
				map.put("rankList", rankList);
				map.put("sexList", sexList);
				return map;
		}

		@Override
		public Map<String, Object> submitTrainingStatusAirCrew(
				Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Session session = (Session) getSession();
		AvTrainingStatusAircrew trainingStatusAircrew = new AvTrainingStatusAircrew();
		if (infoMap.get("trainingStatusAircrew") != null) {
			trainingStatusAircrew = (AvTrainingStatusAircrew) infoMap.get("trainingStatusAircrew");
		}
		int avAccidentId=0;
		if (infoMap.get("avAccidentId") != null) {
			avAccidentId = (Integer) infoMap.get("avAccidentId");
		}
		int avAccidentIdd=0;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (infoMap.get("trainingStatusAircrew") != null) {
			if(avAccidentId !=0){
			AvTrainingStatusAircrew trainingStatusAircrewObj = (AvTrainingStatusAircrew) hbt.load(AvTrainingStatusAircrew.class, avAccidentId);
			hbt.update(trainingStatusAircrewObj);
			avAccidentIdd = trainingStatusAircrewObj.getId();
			}else {
			trainingStatusAircrew = (AvTrainingStatusAircrew) infoMap.get("trainingStatusAircrew");
			hbt.save(trainingStatusAircrew);
			avAccidentIdd = trainingStatusAircrew.getId();
			} 
			}
			saved = true;
		 tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		map.put("saved",saved);
		map.put("avAccidentIdd",avAccidentIdd);
		return map;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> getSerNoDetailForTraining(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			String serviceNo = box.getString("serviceNo");
			List<AvTrainingStatusAircrew> trainingAircrewList = new ArrayList<AvTrainingStatusAircrew>();
			List<Patient> patientList = new ArrayList<Patient>();
			List<MasUnit> unitList = new ArrayList<MasUnit>();
			List<MasRank> rankList = new ArrayList<MasRank>();
			List<MasAdministrativeSex>sexList = new ArrayList<MasAdministrativeSex>();
			List<MasAircraftType> aircraftList = new ArrayList<MasAircraftType>();
			List<AvAircrewLectureDt> lectureList = new ArrayList<AvAircrewLectureDt>();
			Session session = (Session) getSession();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
		try {
			trainingAircrewList = session.createCriteria(AvTrainingStatusAircrew.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();
			patientList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
			.add(Restrictions.eq("Status", "y")).createAlias("Relation", "rel")
			.add(Restrictions.eq("rel.RelationName", "Self")).list();
		
			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();
			rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
			sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).list();
			aircraftList = session.createCriteria(MasAircraftType.class).add(Restrictions.eq("Status", "y")).list();
			lectureList = session.createCriteria(AvAircrewLectureDt.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();
			} catch (HibernateException e) {
			e.printStackTrace();
			}
			
			map.put("lectureList",lectureList);
			map.put("trainingAircrewList",trainingAircrewList);
			map.put("patientList", patientList);
			map.put("aircraftList",aircraftList);
			map.put("unitList", unitList);
			map.put("rankList", rankList);
			map.put("sexList", sexList);
			return map;
	}
		@SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> getSerNoDetailPreFlight(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			String serviceNo = box.getString("serviceNo");
			List<AvPreFlight> preFlightList = new ArrayList<AvPreFlight>();
			List<Patient> patientList = new ArrayList<Patient>();
			List<MasUnit> unitList = new ArrayList<MasUnit>();
			List<MasRank> rankList = new ArrayList<MasRank>();
			List<MasAdministrativeSex>sexList = new ArrayList<MasAdministrativeSex>();
			List<MasAircraftType> aircraftList = new ArrayList<MasAircraftType>();
			Session session = (Session) getSession();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			try {
				preFlightList = session.createCriteria(AvPreFlight.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();
				patientList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
				.add(Restrictions.eq("Status", "y")).createAlias("Relation", "rel")
				.add(Restrictions.eq("rel.RelationName", "Self")).list();
		
			
				unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();
				rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
				sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).list();
				aircraftList = session.createCriteria(MasAircraftType.class).add(Restrictions.eq("Status", "y")).list();
				} catch (HibernateException e) {
				e.printStackTrace();
				}
				map.put("preFlightList",preFlightList);
				map.put("patientList", patientList);
				map.put("aircraftList",aircraftList);
				map.put("unitList", unitList);
				map.put("rankList", rankList);
				map.put("sexList", sexList);
				return map;
		}
		@Override
		public AvTrainingStatusAircrew loadTrainingStatusAircrew(int avAccidentId) {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			AvTrainingStatusAircrew trainingStatusAircrew = new AvTrainingStatusAircrew();
			try {
				
				trainingStatusAircrew = (AvTrainingStatusAircrew)hbt.load(AvTrainingStatusAircrew.class, avAccidentId);
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			return trainingStatusAircrew;
		}

		@Override
		public Map<String, Object> submitSpecialLocalFeature(Map<String, Object> infoMap) {
			Map<String, Object> map = new HashMap<String, Object>();
			AvSpecialLocalFeature specialLocalFeature = new AvSpecialLocalFeature();
			if(infoMap.get("specialLocalFeature") !=null){
				specialLocalFeature=(AvSpecialLocalFeature)infoMap.get("specialLocalFeature");
			}
			int avAccidentId=0;
			if (infoMap.get("avAccidentId") != null) {
				avAccidentId = (Integer) infoMap.get("avAccidentId");
			}
			boolean saved = false;
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if(avAccidentId !=0){
				hbt.update(specialLocalFeature);
			}else{
			hbt.save(specialLocalFeature);
			}
			saved = true;
			map.put("saved",saved);
			return map;
		}

		@Override
		public AvPreFlight loadPreFlight(int avAccidentId) {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			AvPreFlight preFlight = new AvPreFlight();
			try {
				
				preFlight = (AvPreFlight)hbt.load(AvPreFlight.class, avAccidentId);
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			return preFlight;
		}

		@Override
		public Map<String, Object> submitPreFlight(Map<String, Object> infoMap) {
			Map<String, Object> map = new HashMap<String, Object>();
			boolean saved = false;
			boolean savePhoto = false;
			Session session = (Session) getSession();
			AvPreFlight preFlight = new AvPreFlight();
			Patient patient = new Patient();
			Visit visit = new Visit();
			int hinId=0;
			if (infoMap.get("preFlight") != null) {
				preFlight = (AvPreFlight) infoMap.get("preFlight");
			}
			if (infoMap.get("patient") != null) {
				patient = (Patient) infoMap.get("patient");
			}
			if (infoMap.get("visit") != null) {
				visit = (Visit) infoMap.get("visit");
			}
			if(infoMap.get("hinId") !=null){
				hinId=(Integer)infoMap.get("hinId");
			}
			int avAccidentId=0;
			if (infoMap.get("avAccidentId") != null) {
				avAccidentId = (Integer) infoMap.get("avAccidentId");
			}
			//--For photo----
			String uploadURL="";
			if(infoMap.get("uploadURL")!= null){
				uploadURL =(String) infoMap.get("uploadURL");
			}
			String hinNo = "";
			if(infoMap.get("hinNo")!= null){
				hinNo =(String) infoMap.get("hinNo");
			}
			String extension = "";
			if(infoMap.get("extension")!=null) {
				extension = (String)infoMap.get("extension");
			}
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String time = (String)utilMap.get("currentTimeWithoutSc");
			//-------------------------------
			Box box = null;
			int avCA34Id=0;
			if (infoMap.get("box") != null) {
				box = (Box) infoMap.get("box");
			}
			int avAccidentIdd=0;
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				if (infoMap.get("preFlight") != null) {
				if(avAccidentId !=0){
					AvPreFlight avPreFlightObj = (AvPreFlight) hbt.load(AvPreFlight.class, avAccidentId);
				hbt.update(avPreFlightObj);
				avAccidentIdd = avPreFlightObj.getId();
				
				}else {
					/*patient = (Patient) infoMap.get("patient");
					hbt.save(patient);
					
					Patient visitHin=new Patient();
					visitHin.setId(patient.getId());
					visit.setHin(visitHin);
					hbt.save(visit);
					
					preFlight = (AvPreFlight) infoMap.get("preFlight");
					
					Patient preFlightHin=new Patient();
					preFlightHin.setId(patient.getId());
					preFlight.setHin(preFlightHin);*/
					
					hbt.save(preFlight);
					avAccidentIdd = preFlight.getId();
				} 
				
				List<String> serviceNoList = new ArrayList<String>();
				List<Integer> hinIdList = new ArrayList<Integer>();
				List<Integer> rankIdList = new ArrayList<Integer>();
				List<Integer> unitIdList = new ArrayList<Integer>();
				List<Integer> sexIdList = new ArrayList<Integer>();
				List<String> ageList = new ArrayList<String>();
				List<String> fullNameList = new ArrayList<String>();
				List<String> sortieList = new ArrayList<String>();
				List<String> visualInspectList = new ArrayList<String>();
				List<Integer> flightIdList = new ArrayList<Integer>();
				List<Integer> categoryIdList = new ArrayList<Integer>();
				serviceNoList=(List)infoMap.get("serviceNoList");
				hinIdList=(List)infoMap.get("hinIdList");
				rankIdList=(List)infoMap.get("rankIdList");
				unitIdList=(List)infoMap.get("unitIdList");
				sexIdList=(List)infoMap.get("sexIdList");
				ageList=(List)infoMap.get("ageList");
				fullNameList=(List)infoMap.get("fullNameList");
				sortieList=(List)infoMap.get("sortieList");
				visualInspectList=(List)infoMap.get("visualInspectList");
				flightIdList=(List)infoMap.get("flightIdList");
				categoryIdList=(List)infoMap.get("categoryIdList");
				File file=null;
				String filename = "";
				//	filename =hinNo+".jpg";
				
					
				for (int i = 0; i < serviceNoList.size(); i++) {
					if(serviceNoList.get(i) != null	&& serviceNoList.get(i) != ""){
						System.out.println("serviceNoList.get(i)="+serviceNoList.get(i));
					if(flightIdList.get(i) !=null && !flightIdList.get(i).equals("") && flightIdList.get(i) >0){
					AvPreFlightDt preFlightDt=(AvPreFlightDt) hbt
					.load(AvPreFlightDt.class,flightIdList.get(i));
					
					
						if (serviceNoList.get(i) != null && serviceNoList.get(i) != "") {
							preFlightDt.setServiceNo(serviceNoList.get(i));
						}
						if (hinIdList.get(i) != null && hinIdList.get(i) != 0) {
							Patient hin =new Patient();
							hin.setId(hinIdList.get(i));
							preFlightDt.setHin(hin);
						}
						if (rankIdList.get(i) != null && rankIdList.get(i) != 0) {
							MasRank rank =new MasRank();
							rank.setId(rankIdList.get(i));
							preFlightDt.setRank(rank);
						}
						if (unitIdList.get(i) != null && unitIdList.get(i) != 0) {
							MasUnit unit =new MasUnit();
							unit.setId(unitIdList.get(i));
							preFlightDt.setUnit(unit);
						}
						if (sexIdList.get(i) != null && sexIdList.get(i) != 0) {
							MasAdministrativeSex masGender =new MasAdministrativeSex();
							masGender.setId(sexIdList.get(i));
							preFlightDt.setSex(masGender);
						}
						if (ageList.get(i) != null && ageList.get(i) != "") {
							preFlightDt.setAge(ageList.get(i));
						}
						if (fullNameList.get(i) != null && fullNameList.get(i) != "") {
							preFlightDt.setFullName(fullNameList.get(i));
						}
						if (sortieList.get(i) != null && sortieList.get(i) != "") {
							preFlightDt.setSortieDay(sortieList.get(i));
						}
						
						if (visualInspectList.get(i) != null && visualInspectList.get(i) != "") {
							preFlightDt.setVisualInspect(visualInspectList.get(i));
						}
						
						if (categoryIdList.get(i) != null && categoryIdList.get(i) != 0) {
							Category category =new Category();
							category.setCategoryid(categoryIdList.get(i));
							preFlightDt.setMedCategory(category);
						}
						preFlightDt.setFlightHd(preFlight);
						preFlightDt.setCheckStatus("y");
						
				//-------------For photo----------
				if(serviceNoList !=null && extension !=null && !extension.equals("")){
				filename =serviceNoList.get(i)+"."+extension;
				String fileSeparator = System.getProperty("file.separator");
				file = new File(uploadURL +fileSeparator+serviceNoList.get(i)+"."+extension);
					File f = new File(uploadURL);
					
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
							/*Patient patient=new Patient();
							patient=(Patient)hbt.load(Patient.class, hinId);*/
							preFlightDt.setFileName(serviceNoList.get(i));
							preFlightDt.setServiceImage(bytes);
							preFlightDt.setImageFileExtension(extension);
							preFlightDt.setImageDate(new Date());
							preFlightDt.setImageTime(time);
						}
						StringTokenizer strToken=new StringTokenizer(filename,".");
						filename=strToken.nextToken();
						}hbt.update(preFlightDt);					
						
					}else{
						AvPreFlightDt preFlightDtObj=new AvPreFlightDt();
						if(serviceNoList !=null && extension !=null && !extension.equals("")){
				filename =serviceNoList.get(i)+"."+extension;
				String fileSeparator = System.getProperty("file.separator");
		//		file = new File(uploadURL +fileSeparator+hinNo+".jpg");
				file = new File(uploadURL +fileSeparator+serviceNoList.get(i)+"."+extension);
				File f = new File(uploadURL);
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
						
				preFlightDtObj.setFileName(serviceNoList.get(i));
				preFlightDtObj.setServiceImage(bytes);
				preFlightDtObj.setImageFileExtension(extension);
				preFlightDtObj.setImageDate(new Date());
				preFlightDtObj.setImageTime(time);
				StringTokenizer strToken=new StringTokenizer(filename,".");
				filename=strToken.nextToken();
						}		
					
						if(serviceNoList.get(i) != null	&& serviceNoList.get(i) != ""){
							if (serviceNoList.get(i) != null && serviceNoList.get(i) != "") {
								preFlightDtObj.setServiceNo(serviceNoList.get(i));
							}
							if (hinIdList.get(i) != null && hinIdList.get(i) != 0) {
								Patient hin =new Patient();
								hin.setId(hinIdList.get(i));
								preFlightDtObj.setHin(hin);
							}
							if (rankIdList.get(i) != null && rankIdList.get(i) != 0) {
								MasRank rank =new MasRank();
								rank.setId(rankIdList.get(i));
								preFlightDtObj.setRank(rank);
							}
							
								MasUnit unit =new MasUnit();
								unit.setId(preFlight.getUnit().getId());								
								preFlightDtObj.setUnit(unit);
							
							if (sexIdList.get(i) != null && sexIdList.get(i) != 0) {
								MasAdministrativeSex masGender =new MasAdministrativeSex();
								masGender.setId(sexIdList.get(i));
								preFlightDtObj.setSex(masGender);
							}
							if (ageList.get(i) != null && ageList.get(i) != "") {
								preFlightDtObj.setAge(ageList.get(i));
							}
							if (fullNameList.get(i) != null && fullNameList.get(i) != "") {
								preFlightDtObj.setFullName(fullNameList.get(i));
							}
							if (sortieList.get(i) != null && sortieList.get(i) != "") {
								preFlightDtObj.setSortieDay(sortieList.get(i));
							}
							
							if (visualInspectList.get(i) != null && visualInspectList.get(i) != "") {
								preFlightDtObj.setVisualInspect(visualInspectList.get(i));
							}
							if (categoryIdList.get(i) != null && categoryIdList.get(i) != 0) {
								Category category =new Category();
								category.setCategoryid(categoryIdList.get(i));
								preFlightDtObj.setMedCategory(category);
							}
							preFlightDtObj.setFlightHd(preFlight);
							preFlightDtObj.setCheckStatus("y");
							hbt.save(preFlightDtObj);	
					}
					}
					
					}
				}
				}
				saved = true;
			 tx.commit();
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			}
			map.put("saved",saved);
			map.put("avAccidentIdd",avAccidentIdd);
			return map;
		}

		@Override
		public Map<String, Object> getSerNoDetailForRation(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			String serviceNo = box.getString("serviceNo");
			List<AvAircrewRationHd> aircrewHdList = new ArrayList<AvAircrewRationHd>();
			List<Patient> patientList = new ArrayList<Patient>();
			List<MasUnit> unitList = new ArrayList<MasUnit>();
			List<MasRank> rankList = new ArrayList<MasRank>();
			List<MasAdministrativeSex>sexList = new ArrayList<MasAdministrativeSex>();
			Session session = (Session) getSession();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			try {
				aircrewHdList = session.createCriteria(AvAircrewRationHd.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();
			patientList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
			.add(Restrictions.eq("Status", "y")).createAlias("Relation", "rel")
			.add(Restrictions.eq("rel.RelationName", "Self")).list();
		
			
				unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();
				rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
				sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).list();
				} catch (HibernateException e) {
				e.printStackTrace();
				}
				
				map.put("aircrewHdList",aircrewHdList);
				map.put("patientList", patientList);
				map.put("unitList", unitList);
				map.put("rankList", rankList);
				map.put("sexList", sexList);
				return map;
		}

		@Override
		public AvAircrewRationHd loadAircrewRationHd(int avAccidentId) {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			AvAircrewRationHd aircrewRationHd = new AvAircrewRationHd();
			try {
				
				aircrewRationHd = (AvAircrewRationHd)hbt.load(AvAircrewRationHd.class, avAccidentId);
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			return aircrewRationHd;
		}

@Override
public Map<String, Object> submitAircrewRation(Map<String, Object> infoMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	boolean saved = false;
	Session session = (Session) getSession();
	AvAircrewRationHd aircrewRationHd = new AvAircrewRationHd();
	Box box = null;
	if (infoMap.get("box") != null) {
		box = (Box) infoMap.get("box");
	}
	if (infoMap.get("aircrewRationHd") != null) {
		aircrewRationHd = (AvAircrewRationHd) infoMap.get("aircrewRationHd");
	}
	int avAccidentId=0;
	if (infoMap.get("avAccidentId") != null) {
		avAccidentId = (Integer) infoMap.get("avAccidentId");
	}
	int avAccidentIdd=0;
	Transaction tx = null;
	try {
		tx = session.beginTransaction();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (infoMap.get("aircrewRationHd") != null) {
		if(avAccidentId !=0){
			AvAircrewRationHd aircrewRationHdObj = (AvAircrewRationHd) hbt.load(AvAircrewRationHd.class, avAccidentId);
		hbt.update(aircrewRationHdObj);
		avAccidentIdd = aircrewRationHdObj.getId();
		
         List<AvAircrewRationDt> aircrewDtList = session.createCriteria(AvAircrewRationDt.class)
               .createAlias("RationHdId", "cb").add(Restrictions.eq("cb.Id",infoMap.get("avAccidentId"))).list();
         hbt.deleteAll(aircrewDtList);
         
         Vector authItemId = box.getVector("authItemId");
			Vector suppliedItemQty = box.getVector("suppliedItemQty");
			for (int inc = 0; inc<suppliedItemQty.size(); inc++) {
				if (suppliedItemQty.get(inc) != null && !suppliedItemQty.get(inc).equals("")) {
					AvAircrewRationDt airRationDt=new AvAircrewRationDt();
					airRationDt.setRationHdId(aircrewRationHd);
					
					if (authItemId.get(inc) != null && !authItemId.get(inc).equals("0")) {
						AvAuthorisedItem authorisedItem=new AvAuthorisedItem();
						authorisedItem.setId(Integer.parseInt(authItemId.get(inc).toString()));
						airRationDt.setAuthItemId(authorisedItem);
					}
					airRationDt.setSuppliedQty(suppliedItemQty.get(inc).toString());
					
					hbt.saveOrUpdate(airRationDt);
					hbt.refresh(airRationDt);
			}
			}
		
		}else {
			aircrewRationHd = (AvAircrewRationHd) infoMap.get("aircrewRationHd");
			hbt.save(aircrewRationHd);
			avAccidentIdd = aircrewRationHd.getId();
			
			Vector authItemId = box.getVector("authItemId");
			Vector suppliedItemQty = box.getVector("suppliedItemQty");
			for (int inc = 0; inc<suppliedItemQty.size(); inc++) {
				if (suppliedItemQty.get(inc) != null && !suppliedItemQty.get(inc).equals("")) {
					AvAircrewRationDt aircrewRationDt=new AvAircrewRationDt();
					aircrewRationDt.setRationHdId(aircrewRationHd);
					
					if (authItemId.get(inc) != null && !authItemId.get(inc).equals("0")) {
						AvAuthorisedItem authorisedItem=new AvAuthorisedItem();
						authorisedItem.setId(Integer.parseInt(authItemId.get(inc).toString()));
						aircrewRationDt.setAuthItemId(authorisedItem);
					}
					aircrewRationDt.setSuppliedQty(suppliedItemQty.get(inc).toString());
					
					hbt.saveOrUpdate(aircrewRationDt);
					hbt.refresh(aircrewRationDt);
			}
			}
		} 
		}
		saved = true;
	 tx.commit();
	} catch (Exception e) {
		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	}
	map.put("saved",saved);
	map.put("avAccidentIdd",avAccidentIdd);
	return map;
}

@Override
public Map<String, Object> displayPreFlightPhoto(String hinNo) {
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

@Override
public AvSpecialLocalFeature loadLocalFeature(int avAccidentId) {
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	AvSpecialLocalFeature specialLocalFeature = new AvSpecialLocalFeature();
	try {
		
		specialLocalFeature = (AvSpecialLocalFeature)hbt.load(AvSpecialLocalFeature.class, avAccidentId);
	} catch (DataAccessException e) {
		e.printStackTrace();
	}
	return specialLocalFeature;
}

@Override
public Map<String, Object> showSpecialLocalFeatureJsp() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<AvSpecialLocalFeature>localFeatureList = new ArrayList<AvSpecialLocalFeature>();
	Session session = (Session) getSession();
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	
try {
	localFeatureList = session.createCriteria(AvSpecialLocalFeature.class).list();
	if(localFeatureList.size() >0){
		map.put("localFeatureList", localFeatureList);
	}
	} catch (HibernateException e) {
	e.printStackTrace();
	}
	return map;
}

@Override
public AviFlyingClothingInspection loadFlyingClothing(int avAccidentId) {
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	AviFlyingClothingInspection aviFlyingClothingInspection = new AviFlyingClothingInspection();
	try {
	aviFlyingClothingInspection = (AviFlyingClothingInspection)hbt.load(AviFlyingClothingInspection.class, avAccidentId);
	} catch (DataAccessException e) {
		e.printStackTrace();
	}
	return aviFlyingClothingInspection;
}

@Override
public Map<String, Object> fillAVServiceDetail(Map<String, Object> dataMap) {
	Session session = (Session) getSession();
	Map<String, Object> map = new HashMap<String, Object>();
	List<Patient> patientList = new ArrayList<Patient>();
	@SuppressWarnings("unused")
	int deptId = 0;
	try {
		String str = "" + dataMap.get("serviceNo");
		Criteria c = session.createCriteria(Patient.class).add(
				Restrictions.eq("ServiceNo", str)).createAlias("Relation", "rel")
				.add(Restrictions.eq("rel.RelationName", "Self"));
		patientList = c.list();
		map.put("patientList", patientList);
	} catch (Exception e) {
		e.printStackTrace();
	}

return map;}

@Override
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
	List<Object[]> employeeList = new ArrayList<Object[]>();
	List<Object[]> commandList = new ArrayList<Object[]>();
	List<Object[]> maritalStatusList = new ArrayList<Object[]>();
	List<Object[]> religionList = new ArrayList<Object[]>();
	List<Object[]> serviceTypeList = null;
	List<Object[]> relationList = null;
	List<Object[]> districtList = null;
	List<Object[]> serviceStatusList = null;
	List<Object[]> stateList = null;
	List<MasAircraftType> aircraftTypeList = new ArrayList<MasAircraftType>();
	List<MasUnit> unitHoldList = new ArrayList<MasUnit>();
	Session session = (Session) getSession();
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	try {
		unitHoldList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status","y")).list(); 
		//hbt.find("from MasUnit mc where mc.Status='y'");
	unitList = session.createCriteria(MasUnit.class).add(
			Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(
			Order.asc("UnitName")).list();
		
	serviceTypeList = session.createCriteria(MasServiceType.class)
	.add(Restrictions.eq("Status", "y"))
	.setProjection(Projections.projectionList()
					.add(Projections.property("Id")).add(Projections.property("ServiceTypeName")))
	.addOrder(Order.asc("ServiceTypeName")).list();
//hbt.find("select Id,ServiceTypeName from MasServiceType mst where mst.Status='y' order by ServiceTypeName");
	rankList = session.createCriteria(MasRank.class).add(
			Restrictions.eq("Status", "y")).setProjection(Projections.projectionList()
					.add(Projections.property("Id")).add(Projections.property("RankName"))
					.add(Projections.property("ServiceType.Id")).add(Projections.property("ServiceStatus.Id"))
					.add(Projections.property("HicCode")))
					.addOrder(Order.asc("RankName")).list();
		//hbt.find("select Id,RankName,rank.ServiceType.Id, rank.ServiceStatus.Id,rank.HicCode from" +
		//	" MasRank as rank  where rank.Status='y'  order by rank.RankName ");
	maritalStatusList = session.createCriteria(MasMaritalStatus.class).add(
			Restrictions.eq("Status", "y")).setProjection(Projections.projectionList()
					.add(Projections.property("Id")).add(Projections.property("MaritalStatusName"))
					.add(Projections.property("HicCode")))
					.addOrder(Order.asc("MaritalStatusName")).list();
//hbt.find("select Id,MaritalStatusName,HicCode from MasMaritalStatus mms where mms.Status='y' " +
//		"order by mms.MaritalStatusName");
	tradeList =session.createCriteria(MasTrade.class).add(
			Restrictions.eq("Status", "y")).setProjection(Projections.projectionList()
					.add(Projections.property("Id")).add(Projections.property("TradeName")))
					.addOrder(Order.asc("TradeName")).list();
//hbt.find("select Id,TradeName from MasTrade mt where mt.Status='y' order by mt.TradeName");
	stateList = session.createCriteria(MasState.class).add(
			Restrictions.eq("Status", "y")).setProjection(Projections.projectionList()
					.add(Projections.property("Id")).add(Projections.property("StateName")))
					.addOrder(Order.asc("StateName")).list();
//hbt.find("select Id,StateName from MasState ms where ms.Status='y' order by StateName");
	districtList =session.createCriteria(MasDistrict.class).add(
			Restrictions.eq("Status", "y")).setProjection(Projections.projectionList()
					.add(Projections.property("Id")).add(Projections.property("DistrictName"))
					.add(Projections.property("State.Id")))
					.addOrder(Order.asc("DistrictName")).list();
//hbt.find("select  Id, DistrictName,md.State.Id from MasDistrict as md  where md.Status='y' order by 
	//md.DistrictName ");
	relationList =session.createCriteria(MasRelation.class).add(
			Restrictions.eq("Status", "y")).setProjection(Projections.projectionList()
					.add(Projections.property("Id")).add(Projections.property("RelationName")))
					.addOrder(Order.asc("RelationName")).list();
//hbt.find("select Id,RelationName from MasRelation as mr where mr.Status='y' order by RelationName");
	bloodGroupList = session.createCriteria(MasBloodGroup.class).add(
			Restrictions.eq("Status", "y")).setProjection(Projections.projectionList()
					.add(Projections.property("Id")).add(Projections.property("BloodGroupName"))
					.add(Projections.property("HicCode")))
					.addOrder(Order.asc("BloodGroupName")).list();
//hbt.find("select Id,BloodGroupName,HicCode from MasBloodGroup as dist where dist.Status='y' " +
//		"order by dist.BloodGroupName");
	religionList = session.createCriteria(MasReligion.class).add(Restrictions.eq("Status", "y"))
			.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("ReligionName"))
					.add(Projections.property("HicCode")))
	.addOrder(Order.asc("ReligionName")).list();
	recordOfficeAddressList = session.createCriteria(MasRecordOfficeAddress.class).add(Restrictions.eq("Status", "y")).list();
	sexList = session.createCriteria(MasAdministrativeSex.class).add(
			Restrictions.eq("Status", "y")).setProjection(Projections.projectionList()
					.add(Projections.property("Id")).add(Projections.property("AdministrativeSexName"))
					.add(Projections.property("AdministrativeSexCode")).add(Projections.property("HicCode")))
					.addOrder(Order.asc("AdministrativeSexName")).list();
//hbt.find("Select Id, AdministrativeSexName, AdministrativeSexCode,HicCode from MasAdministrativeSex mas " +
//		"where mas.Status='y' order by AdministrativeSexName");
	sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y"))
				.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("SectionName")))
				.addOrder(Order.asc("SectionName")).list();
	stationList = session.createCriteria(MasStation.class).add(
			Restrictions.eq("Status", "y")).setProjection(Projections.projectionList()
					.add(Projections.property("Id")).add(Projections.property("StationName"))
					.add(Projections.property("Command.Id")))
					.addOrder(Order.asc("StationName")).list();
//hbt.find("select Id,StationName,mas.Command.Id from MasStation mas where mas.Status='y' " +
//		"order by mas.StationName");
	commandList = session.createCriteria(MasCommand.class).add(
			Restrictions.eq("Status", "y")).setProjection(Projections.projectionList()
					.add(Projections.property("Id")).add(Projections.property("CommandName")))
					.addOrder(Order.asc("CommandName")).list();
//hbt.find("select Id,CommandName from MasCommand mas where mas.Status='y' order by mas.CommandName");
	serviceStatusList = session.createCriteria(MasServiceStatus.class).add(
			Restrictions.eq("Status", "y")).setProjection(Projections.projectionList()
					.add(Projections.property("Id")).add(Projections.property("ServiceStatusName")))
					.list();
		//hbt.find("select Id,ServiceStatusName from MasServiceStatus mss where mss.Status='y' ");
	aircraftTypeList=session.createCriteria(MasAircraftType.class).add(Restrictions.eq("Status", "y")).list();
	list = session.createCriteria(Patient.class).add(
			Restrictions.eq("ServiceNo", serviceNo)).createAlias(
			"ServiceType", "st").add(
			Restrictions.eq("st.Id", serviceTypeId)).list();
	if (list.size() > 0) {
		map.put("list", list);
	}
	List<AviCasualtyAirEvacuation> aviCasualtyAirEvacuationList = new ArrayList<AviCasualtyAirEvacuation>();
	aviCasualtyAirEvacuationList = session.createCriteria(AviCasualtyAirEvacuation.class).add(Restrictions.eq("ServiceNo", serviceNo)).add(Restrictions.eq("Status", "y")).list();
	if (aviCasualtyAirEvacuationList.size() > 0) {
		map.put("aviCasualtyAirEvacuationList", aviCasualtyAirEvacuationList);
	}
	map.put("unitHoldList", unitHoldList);
	map.put("aircraftTypeList", aircraftTypeList);
	map.put("rankList", rankList);
	map.put("unitList", unitList);
	map.put("tradeList", tradeList);
	map.put("recordOfficeAddressList", recordOfficeAddressList);
	map.put("sectionList", sectionList);
	map.put("bloodGroupList", bloodGroupList);
	map.put("sexList", sexList);
	map.put("stationList", stationList);
	map.put("serviceTypeId", serviceTypeId);
	map.put("employeeList", employeeList);
	map.put("commandList", commandList);
	map.put("maritalStatusList", maritalStatusList);
	map.put("religionList", religionList);
	map.put("serviceTypeList", serviceTypeList);
	map.put("relationList", relationList);
	map.put("districtList", districtList);
	map.put("serviceStatusList", serviceStatusList);
	map.put("stateList", stateList);
} catch (HibernateException e) {
		e.printStackTrace();
	//	session.close();
	}
	return map;
}

@Override
public Map<String, Object> showAircrewRationJsp() {
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	List<MasAdministrativeSex>sexList = new ArrayList<MasAdministrativeSex>();
	List<AvAuthorisedItem> authorisedList = new ArrayList<AvAuthorisedItem>();
	Session session = (Session) getSession();
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	
	try {
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).list();
		authorisedList = session.createCriteria(AvAuthorisedItem.class).add(Restrictions.eq("Status", "y")).list();
		
	} catch (HibernateException e) {
		e.printStackTrace();
		}
	map.put("authorisedList", authorisedList);
	map.put("unitList", unitList);
	map.put("rankList", rankList);
	map.put("sexList", sexList);
	return map;
}

@Override
public Map<String, Object> showAircrewLectureRpt(int hospitalId,Map<String, Object> infoMap) {
	Session session = (Session) getSession();
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	List<AviAircrewMedicalLectures> medLectureList = new ArrayList<AviAircrewMedicalLectures>();
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	
	try {
		doctorList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
		.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
		
		} catch (HibernateException e) {
		e.printStackTrace();
		
	}
		map.put("medLectureList",medLectureList);
	map.put("doctorList", doctorList);
	return map;
}
public Boolean updateInvestigation(Map<String, Object> mapForDS) {
	boolean saveinvestigation = false;
	int patientInvestigationHeaderId = 0;
	int dgOrderhdId = 0;
	int hinId = (Integer) mapForDS.get("hinId");
	int departmentId = (Integer) mapForDS.get("deptId");
	int visitId = (Integer) mapForDS.get("visitId");
	int hospitalId = (Integer) mapForDS.get("hospitalId");
	patientInvestigationHeaderId = (Integer) mapForDS
			.get("patientInvestigationHeaderId");
	dgOrderhdId = (Integer) mapForDS.get("dgOrderhdId");
	List<String> chargeCodeIdList = (List) mapForDS.get("chargeCodeIdList");
	List<String> investigationReferToMHList = (List) mapForDS
			.get("investigationReferToMHList");
	List<Integer> patientInvestigationdetailsIdList = (List) mapForDS
			.get("patientInvestigationdetailsIdList");
	List<Integer> dgOrderdtIdList = (List) mapForDS.get("dgOrderdtIdList");
	// List<Integer> patientInvestigationdetailsIdList = new
	// ArrayList<Integer>();
	String investigationDataStatus = (String) mapForDS
			.get("investigationDataStatus");
	String clinicalNotes1 = (String) mapForDS.get("clinicalNotes1");
	String userName = (String) mapForDS.get("userName");
	int empId = (Integer) mapForDS.get("empId");
	int userId = (Integer) mapForDS.get("empId");
	String lastChangedBy = (String) mapForDS.get("lastChangedBy");
	Date lastChangedDate = (Date) mapForDS.get("lastChangedDate");
	String lastChangedTime = (String) mapForDS.get("lastChangedTime");
	departmentId = 117;
	String deleatedValue = (String) mapForDS.get("deleatedValue");
	String deleatedorderid = (String) mapForDS.get("deleatedorderid");
	Boolean data = false;
	Session session = (Session) getSession();
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	try {
	//	if (investigationDataStatus.equalsIgnoreCase("yes")) {
			List<PatientInvestigationDetails> patientInvestDetailsList = session
					.createCriteria(PatientInvestigationDetails.class).add(
							Restrictions.eq("InvestigationHeader.Id",
									patientInvestigationHeaderId)).list();
			List<String> addChargeCodeIdList = new ArrayList<String>();
			addChargeCodeIdList.addAll(chargeCodeIdList);
			List<String> investigationReferToMHNewList = new ArrayList<String>();
			investigationReferToMHNewList.addAll(investigationReferToMHList);
			List<DgOrderhd> dgOrderhdList = session.createCriteria(
					DgOrderhd.class).add(
					Restrictions.eq("InvestigationRequestionNo.Id",
							patientInvestigationHeaderId)).list();
			if (dgOrderhdList.size() > 0) {
				DgOrderhd dgOrderhd = dgOrderhdList.get(0);
				List<DgOrderdt> dgOrderdtFirstList = session.createCriteria(DgOrderdt.class)
						.add(Restrictions.eq("Orderhd.Id", dgOrderhd.getId())).list();
				List<String> removeChargeCodeId = new ArrayList<String>();
				for (DgOrderdt dgOrderdt : dgOrderdtFirstList) {
					removeChargeCodeId.add(""+ dgOrderdt.getChargeCode().getId());
				}
				if (dgOrderdtFirstList.size() > 0) {
					int a = 0;
					int[] arr = new int[15];
					for (String chargeCodeIdString : chargeCodeIdList) {
						int chargeCodeId = Integer
								.parseInt(chargeCodeIdString);
						arr[a] = chargeCodeId;
						int count = 0;
						for (int j = 0; j <= a; j++) {
							if (chargeCodeId == arr[j]) {
								count++;
							}
						}
						if (count < 2) {
						for (DgOrderdt dgOrderdt : dgOrderdtFirstList) {
						if (chargeCodeId == dgOrderdt.getChargeCode().getId()) {
							int indexPos = addChargeCodeIdList.indexOf("" + chargeCodeId);
							if (indexPos >= 0) {
								int rChargeCodeId = Integer
										.parseInt(addChargeCodeIdList
												.get(indexPos));
								if (chargeCodeId == rChargeCodeId) {

							addChargeCodeIdList.remove(indexPos);
							investigationReferToMHNewList.remove(indexPos);
							removeChargeCodeId.remove(""+ chargeCodeId);
						}
						}
						}
						}
						}
						a++;

					}
				List<Integer> deleteChargeCodeId = new ArrayList<Integer>();
				List<DgOrderdt> dgOrderdtList = session.createCriteria(DgOrderdt.class)
							.add(Restrictions.eq("Orderhd.Id", dgOrderhd.getId()))
							.add(Restrictions.eq("OrderStatus", "P")).list();
					for (DgOrderdt dgOrderdt : dgOrderdtList) {
						for (String chargeCodeIdStr : removeChargeCodeId) {
							int chargeCodeId = Integer.parseInt(chargeCodeIdStr);
							if (chargeCodeId == dgOrderdt.getChargeCode().getId()) {
								hbt.delete(dgOrderdt);
								deleteChargeCodeId.add(chargeCodeId);
							}
						}
					}

					for (PatientInvestigationDetails patientInvestDetails : patientInvestDetailsList) {
						for (Integer chargeCodeId : deleteChargeCodeId) {
							if (chargeCodeId.equals(patientInvestDetails.getChargeCode().getId())) {
								hbt.delete(patientInvestDetails);
							}
						}
					}
					int i = 0;
					DgOrderhd dgOrderhdObj = (DgOrderhd) session.get(DgOrderhd.class, dgOrderhdId);
					for (String chargeCodeIdString : addChargeCodeIdList) {
						PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
						patientInvestigationHeader.setId(patientInvestigationHeaderId);
						PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
						patientInvestigationDetails.setInvestigationHeader(patientInvestigationHeader);
						if (investigationReferToMHList != null) {
							patientInvestigationDetails.setReferToMh(investigationReferToMHList.get(i));
						}
						DgOrderdt dgOrderdt = new DgOrderdt();

						MasChargeCode masChargeCode = new MasChargeCode();
						masChargeCode.setId(Integer
								.parseInt(chargeCodeIdString));
						patientInvestigationDetails
								.setChargeCode(masChargeCode);
						hbt.saveOrUpdate(patientInvestigationDetails);
						dgOrderdt.setOrderhd(dgOrderhdObj);
						masChargeCode.setId(Integer
								.parseInt(chargeCodeIdString));
						dgOrderdt.setChargeCode(masChargeCode);
						dgOrderdt.setCreatedby(userName);
						dgOrderdt.setCreatedon(new Date());
						/*	dgOrderdt.setInvestigationToMH(investigationReferToMHNewList.get(i));*/
						if (investigationReferToMHList != null) {
						dgOrderdt.setInvestigationToMH(investigationReferToMHList.get(i));
						}							
						dgOrderdt.setLastChgBy(userId);
						dgOrderdt.setLastChgDate(new Date());
						dgOrderdt.setLastChgTime(lastChangedTime);
						Map masChargeMap = getMasChargeCodeFromChargeId(Integer
								.parseInt(chargeCodeIdString));
						MasChargeCode masChargeCodeObj = (MasChargeCode) masChargeMap
								.get("masChargeCode");
						int mainChargeId = masChargeCodeObj
								.getMainChargecode().getId();
						int subChargeId = masChargeCodeObj
								.getSubChargecode().getId();
						if (masChargeCodeObj.getMainChargecode()
								.getMainChargecodeCode().equalsIgnoreCase(
										"Lab")) {
							dgOrderdt.setOrderStatus("P");
						} else {
							dgOrderdt.setOrderStatus("P");
						}
						MasMainChargecode masMainChargecode = new MasMainChargecode();
						masMainChargecode.setId(mainChargeId);
						dgOrderdt.setMainChargecode(masMainChargecode);
						MasSubChargecode masSubChargecode = new MasSubChargecode();
						masSubChargecode.setId(subChargeId);
						dgOrderdt.setSubChargeid(masSubChargecode);
						dgOrderdt.setInvestigation(new DgMasInvestigation(
								Integer.parseInt(chargeCodeIdString)));
						hbt.saveOrUpdate(dgOrderdt);

						saveinvestigation = true;

						i++;
					}
					if (saveinvestigation) {
						if (dgOrderhdObj != null) {
							if (dgOrderhdObj.getOrderStatus()
									.equalsIgnoreCase("A")) {
								dgOrderhdObj.setOrderStatus("P");
								hbt.update(dgOrderhdObj);

							}
						}
					}

				}

			}
		//}
	} catch (Exception he) {
		he.printStackTrace();
	}
	return true;
}

@Override
public AviCasualtyAirEvacuation loadCasualAirEvac(int avAccidentId) {
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	AviCasualtyAirEvacuation aviCasualtyAirEvacuation = new AviCasualtyAirEvacuation();
	try {
		aviCasualtyAirEvacuation = (AviCasualtyAirEvacuation)hbt.load(AviCasualtyAirEvacuation.class, avAccidentId);
	} catch (DataAccessException e) {
		e.printStackTrace();
	}
	return aviCasualtyAirEvacuation;
}

	@Override
	public Map<String, Object> showPreFlightMedical(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAdministrativeSex>sexList = new ArrayList<MasAdministrativeSex>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<AvPreFlightDt> flightDtList = new ArrayList<AvPreFlightDt>();
		List<Category> categoryList = new ArrayList<Category>();
		int hospitalId=0;
		if(dataMap.get("hospitalId") !=null){
			hospitalId=(Integer)dataMap.get("hospitalId");
		}
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
	try {
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("AdministrativeSexName")).list();
		flightDtList = session.createCriteria(AvPreFlightDt.class).createAlias("FlightHd", "ph")
					.createAlias("ph.Hospital", "hl").add(Restrictions.eq("hl.Id", hospitalId))
					.add(Restrictions.eq("CheckStatus", "y")).addOrder(Order.asc("Id")).list();
		
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.createAlias("Hospital", "h").createAlias("EmpCategory", "ec").add(
						Restrictions.eq("h.Id", hospitalId)).add(Restrictions.eq("ec.EmpCategoryCode",
								empCategoryCodeForDoctor)).addOrder(Order.asc("FirstName")).list();

		map.put("employeeList", employeeList);
		categoryList=session.createCriteria(Category.class).list();
		
		
	
	} catch (HibernateException e) {
		e.printStackTrace();
		}
	map.put("categoryList", categoryList);
	map.put("flightDtList", flightDtList);
	map.put("unitList", unitList);
	map.put("rankList", rankList);
	map.put("sexList", sexList);
		return map;
	}

	@Override
	public Map<String, Object> fillRegisterDetail(Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<Category> categoryList = new ArrayList<Category>();
		List<MasMedicalExaminationReportOnEntry> categoryMedList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		int hospitalId=0;
		if (dataMap.get("hospitalId") != null) {
			 hospitalId = (Integer) dataMap.get("hospitalId");
		}
		try {
		String str = "" + dataMap.get("serviceNo");
		Criteria c = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", str))
				.createAlias("Relation", "rel").add(Restrictions.eq("rel.RelationName", "Self"))
				.createAlias("Hospital", "hl").add(Restrictions.eq("hl.Id", hospitalId));
		patientList = c.list();
		map.put("patientList", patientList);
		rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("Status","y")).list();
		sexList=session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status","y")).list();
		unitList=session.createCriteria(MasUnit.class).add(Restrictions.eq("Status","y")).list();
		
		categoryList=session.createCriteria(MasEmployee.class).list();
		categoryMedList=session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("medicalType", "MedicalBoard"))
		.add(Restrictions.eq("ServiceNo", str)).list();
		if(categoryMedList.size() >0){
			MasMedicalExaminationReportOnEntry examinationReportOnEntry= categoryMedList.get(0);
			map.put("examinationReportOnEntry",examinationReportOnEntry);
		}
		map.put("unitList", unitList);
		map.put("sexList",sexList);
		map.put("rankList",rankList);
		map.put("categoryMedList", categoryMedList);
		map.put("categoryList", categoryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> inactivePreFlight(Map<String, Object> infoMap) {
		
		Boolean saved = false;
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> checkList = new ArrayList<String>();
		List<Integer> flightIdList = new ArrayList<Integer>();
		if (infoMap.get("flightIdList") != null) {
			flightIdList = (List) infoMap.get("flightIdList");
		}
		if (infoMap.get("checkList") != null) {
			checkList = (List) infoMap.get("checkList");
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		for (int i = 1; i <= checkList.size(); i++) {

		AvPreFlightDt preFlightDt = (AvPreFlightDt) hbt.load(AvPreFlightDt.class, flightIdList.get(i));
		if(checkList.get(i).equalsIgnoreCase("y")){
		preFlightDt.setCheckStatus("n");
		}
		hbt.update(preFlightDt);
		}
		saved= true;
		map.put("saved", saved);
		return map;
	}

	@Override
	public Map<String, Object> displayAVRegisPhoto(String serviceNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AvPreFlightDt> preFlightDtList = new ArrayList<AvPreFlightDt>();
		Session session = (Session)getSession();
		try {
			preFlightDtList = session.createCriteria(AvPreFlightDt.class)
							.add(Restrictions.eq("ServiceNo",serviceNo)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		//	session.close();
		}
		map.put("preFlightDtList", preFlightDtList);
		return map;
	}
	public Map<String, Object> updatePatientImage(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AvPreFlightDt> preFlightDtList = new ArrayList<AvPreFlightDt>();
		Session session = (Session)getSession();
		String uploadURL="";
		if(generalMap.get("uploadURL")!= null){
			uploadURL =(String) generalMap.get("uploadURL");
		}
		String serviceNo="";
		if(generalMap.get("serviceNo")!= null){
			serviceNo =(String) generalMap.get("serviceNo");
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
		 try {
				HibernateTemplate hbt=getHibernateTemplate();
				hbt.setCheckWriteOperations(false);
				hbt.setFlushModeName("FLUSH_EAGER");
				Query qry=session.createQuery("from  jkt.hms.masters.business.AvPreFlightDt as patient where patient.ServiceNo=:serviceNo");
				if(!serviceNo.equals("")){
					qry.setParameter("serviceNo", serviceNo);
				}
				preFlightDtList = qry.list();

								
			//	if(preFlightDtList.size()>0){
					int flightDtId=0;
					for (AvPreFlightDt preFlightDt : preFlightDtList) {
						flightDtId=preFlightDt.getId();
					}
					if(flightDtId>0){

						String filename = "";
					//	filename =hinNo+".jpg";
						filename =serviceNo+"."+extension;
						String fileSeparator = System.getProperty("file.separator");
				//		file = new File(uploadURL +fileSeparator+hinNo+".jpg");
						file = new File(uploadURL +fileSeparator+serviceNo+"."+extension);

						File f = new File(uploadURL);
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
							if(preFlightDtList.size() >0){
								Patient patient=new Patient();
							//	patient=(Patient)hbt.load(Patient.class, hinId);
								patient.setFileName(serviceNo);
								patient.setPatientImage(bytes);
								patient.setImageFileExtension(extension);
								patient.setPatientImageDate(new Date());
								patient.setPatientImageTime(time);
								hbt.update(patient);
							}/*else{
								patient.setFileName(serviceNo);
								patient.setPatientImage(bytes);
								patient.setImageFileExtension(extension);
								patient.setPatientImageDate(new Date());
								patient.setPatientImageTime(time);
								hbt.save(patient);
							}*/
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
								
								/*Patient patient=new Patient();
								patient=(Patient)hbt.load(Patient.class, hinId);
								patient.setFileName(hinNo);
								patient.setPatientImage(bytes);
								patient.setImageFileExtension(extension);
								hbt.update(patient);*/
							}
							
							StringTokenizer strToken=new StringTokenizer(filename,".");
							filename=strToken.nextToken();
							//fileExtension=strToken.nextToken();

						} catch (Exception e) {
							e.printStackTrace();
						}
						// Close the input stream and return bytes
					//}
				}
	    	   //  bytes;
	    	     		//file.delete();


	    }// end of 'try' loop
		catch (Exception e) {
	      e.printStackTrace();
	    }
		return map;
	}
	public Map<String, Object> getViewUploadImage(Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
	  
		String serviceNo =(String)dataMap.get("serviceNo");
		int hospitalId =(Integer)dataMap.get("hospitalId");
		int preFlightId =(Integer)dataMap.get("preFlightId");
		String fileName=(String)dataMap.get("filename");
		//String folderName=(String)dataMap.get("folderName");
		String fileExtension=(String)dataMap.get("fileExtension");
	    try
	    {
	    	List<AvPreFlightDt> preFlDtList=session.createCriteria(AvPreFlightDt.class)
	    	.createAlias("FlightHd","flHd").add(Restrictions.eq("flHd.Id",preFlightId))
	    	   .add(Restrictions.eq("ServiceNo",serviceNo)).add(Restrictions.eq("flHd.Hospital.Id",hospitalId))
	    	   .add(Restrictions.eq("FileName",fileName)).add(Restrictions.eq("ImageFileExtension",fileExtension)).list();
	    	map.put("preFlDtList", preFlDtList);
	    }catch (HibernateException he)
	    {
		   he.printStackTrace();
	    }
	    return map;
	}

	@Override
	public Map<String, Object> getLectureDate(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<AviAircrewMedicalLectures> medLectureList = new ArrayList<AviAircrewMedicalLectures>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		Date from_date = null;
		Date to_date = null;
		int moName=0;
		int hospitalId=0;
		if(dataMap.get("from_date") !=null){
			from_date=(Date)dataMap.get("from_date");
		}
		if(dataMap.get("to_date") !=null){
			to_date=(Date)dataMap.get("to_date");
		}
		if(dataMap.get("moName") !=null){
			moName=(Integer)dataMap.get("moName");
		}
		if(dataMap.get("hospitalId") !=null){
			hospitalId=(Integer)dataMap.get("hospitalId");
		}
		Criteria criteria = session.createCriteria(AviAircrewMedicalLectures.class)
		.add(Restrictions.between("AircrewDate", from_date, to_date));
		if (moName != 0) {
			criteria = criteria.createAlias("MoName", "mo").add(
					Restrictions.eq("mo.Id", moName));
		}
		medLectureList=criteria.list();
		doctorList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
		.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).list();
		map.put("medLectureList",medLectureList);
		map.put("doctorList",doctorList);
		return map;
	}

	@Override
	public Map<String, Object> submitUploadDocuments(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String fileName = null;
		String fileExtension = null;
		int hinId = (Integer) mapForDS.get("hinId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		int avExamId = (Integer) mapForDS.get("avExamId");
		int investigationId = (Integer) mapForDS.get("investigationId");
		fileName = (String) mapForDS.get("filename");
		fileExtension = (String) mapForDS.get("fileExtension");
		MultipartFormDataRequest mrequest = (MultipartFormDataRequest) mapForDS.get("mrequest");
		boolean status = false;
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			File file = null;

			if (!fileName.equals("0")) {
				java.util.Hashtable files = mrequest.getFiles();
				UploadFile file12 = (UploadFile) files
						.get(RequestConstants.UPLOAD_FILENAME);
				InputStream is = file12.getInpuStream();
				long length = file12.getFileSize();
				ByteBuffer byteBuff = null;
				if (length > Integer.MAX_VALUE) {
					// File is too large
				}

				// Create the byte array to hold the data
				byte[] bytes = new byte[(int) length];
				int offset = 0;
				int numRead = 0;
				while (offset < bytes.length
						&& (numRead = is.read(bytes, offset, bytes.length
								- offset)) >= 0) {
					offset += numRead;

				}

				while (offset < bytes.length
						&& (numRead = is.read(bytes, offset, bytes.length
								- offset)) >= 0) {
					offset += 1000;
					if (offset > bytes.length)
						offset = offset - bytes.length;
				}

				if (offset < bytes.length) {
					throw new IOException("Could not completely read file "
							+ file.getName());

				}

				is.close();
				// Close the input stream and return bytes
				AvMedicalUploadDocument masUploadDocuments = new AvMedicalUploadDocument();
				String dataInput = new String(bytes);
				masUploadDocuments.setFileName(fileName);
				masUploadDocuments.setFileExtension(fileExtension);
				masUploadDocuments.setDocument(bytes);
				DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
				dgMasInvestigation.setId(investigationId);
				masUploadDocuments.setDgMasInvestigation(dgMasInvestigation);
				Patient patient = new Patient();
				patient.setId(hinId);
				masUploadDocuments.setHin(patient);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				masUploadDocuments.setHospital(masHospital);
				AvMedicalExamMaMo avMedicalExamReport = new AvMedicalExamMaMo();
				avMedicalExamReport.setId(avExamId);
				masUploadDocuments.setAvMedicalExamReport(avMedicalExamReport);

				hbt.save(masUploadDocuments);
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		map.put("status", status);
		return map;

	}

	@Override
	public Map<String, Object> viewUploadInvestDocument(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int hinId =(Integer)mapForDS.get("hinId");
		int hospitalId =(Integer)mapForDS.get("hospitalId");
		String filename =(String)mapForDS.get("filename");
		String fileExtension =(String)mapForDS.get("fileExtension");
		int investigationId =(Integer)mapForDS.get("invest_id");
		int avExamId =(Integer)mapForDS.get("avExamId");
		 
		try 
		{
		    List<AvMedicalUploadDocument> avUploadDocumentList=session.createCriteria(AvMedicalUploadDocument.class).add(Restrictions.eq("AvMedicalExamReport.Id",avExamId))
		    .add(Restrictions.eq("Hin.Id", hinId)).add(Restrictions.eq("DgMasInvestigation.Id", investigationId)).add(Restrictions.eq("Hospital.Id", hospitalId))
		    .add(Restrictions.eq("FileName", filename)).add(Restrictions.eq("FileExtension", fileExtension))
		    .list();
		    
		    map.put("avUploadDocumentList", avUploadDocumentList);
			
		}catch (Exception e)
		{
		  e.printStackTrace();
		}			
        return map;

	}

	@Override
	public Map<String, Object> viewUploadJsp(Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String fileName = null;
		String fileExtension = null;
		int hinId = (Integer) mapForDS.get("hinId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		int avExamId = (Integer) mapForDS.get("avExamId");
		int investigationId = (Integer) mapForDS.get("InvestId");
		try {
			List<AvMedicalUploadDocument> avUploadDocumentList= session
					.createCriteria(AvMedicalUploadDocument.class).add(
							Restrictions.eq("AvMedicalExamReport.Id",avExamId)).add(
							Restrictions.eq("Hin.Id", hinId)).add(Restrictions.eq("DgMasInvestigation.Id",
									investigationId)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			map.put("avUploadDocumentList",avUploadDocumentList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}
	
	//-------------- By Mansi on 8 March 2013
	@Override
	public Map<String, Object> showPilotRegistrationJsp(int hospitalId) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasUnit> unitList = null;
		List<AvPilotRegistrationHd> avPilotRegistrationHdList = null;
		List<AvPilotRegistrationDt> avPilotRegistrationDtList = null;
		List<MasRank> rankList = null;
//		List<Patient> patient =null; 
		List<Category> categoryList = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
			avPilotRegistrationHdList = session.createCriteria(AvPilotRegistrationHd.class).list();
			avPilotRegistrationDtList = session.createCriteria(AvPilotRegistrationDt.class).list();
			rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("RankName")).list();
//			patient = session.createCriteria(Patient.class).add(Restrictions.eq("Status", "y")).list();
			categoryList = session.createCriteria(Category.class).addOrder(Order.asc("Categories")).list();
			} catch (HibernateException e) {
			e.printStackTrace();
			
		}
		map.put("unitList", unitList);
//		map.put("patient", patient);
		map.put("rankList", rankList);
		map.put("avPilotRegistrationDtList", avPilotRegistrationDtList);
		map.put("avPilotRegistrationHdList", avPilotRegistrationHdList);
		map.put("categoryList", categoryList);
		return map;
	
	}

	@Override
	public Map<String, Object> fillAVPilotRegServiceDetail(
			Map<String, Object> dataMap) {
				Session session = (Session) getSession();
				Map<String, Object> map = new HashMap<String, Object>();
				List<Patient> patientList = new ArrayList<Patient>();
				//List<AvPilotRegistrationDt> avPilotDtList = new ArrayList<AvPilotRegistrationDt>();
				@SuppressWarnings("unused")
				int unitId = 0;
				if(dataMap.get("unitId") !=null){
					unitId=(Integer)dataMap.get("unitId");
				}
				try {
				String str = "" + dataMap.get("serviceNo");
				Criteria c = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", str))
						.createAlias("Relation", "rel").add(Restrictions.eq("rel.RelationName", "Self"));
				patientList = c.list();
				map.put("patientList", patientList);
					/*avPilotDtList=	session.createCriteria(AvPilotRegistrationDt.class)
							.createAlias("AvPilotRegistrationHd","pilotHd")
							.createAlias("pilotHd.Unit","un").add(Restrictions.eq("un.Id", unitId)).list();*/
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			return map;}

	@Override
	public Boolean submitPilotRegistration(
			AvPilotRegistrationHd avPilotRegistrationHd,
			Map<String, Object> infoMap) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		
		int unitId=0;
		if(infoMap.get("unitId") !=null){
			unitId=(Integer)infoMap.get("unitId");
		}
		List<AvPilotRegistrationHd> pilotRegHdList = new ArrayList<AvPilotRegistrationHd>();
		pilotRegHdList=session.createCriteria(AvPilotRegistrationHd.class)
					.add(Restrictions.eq("Unit.Id", unitId)).list();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		AvPilotRegistrationHd pilotRegHd=new AvPilotRegistrationHd();
		
		List<String> serviceNoList = new ArrayList<String>();
		List<Integer> rankList = new ArrayList<Integer>();
		List<Integer> hinList = new ArrayList<Integer>();
		List<String> nameList = new ArrayList<String>();
		List<String> ageList = new ArrayList<String>();
		List<Integer> categoryIdList = new ArrayList<Integer>();
		serviceNoList = (List) infoMap.get("serviceNoList");
		rankList = (List) infoMap.get("rankList");
		hinList = (List) infoMap.get("hinList");
		nameList = (List) infoMap.get("nameList");
		ageList = (List) infoMap.get("ageList");
		categoryIdList = (List) infoMap.get("categoryIdList");
		
		String dateOfLastME="";
		dateOfLastME= (String) infoMap.get("dateOfLastME");
		int pilotHdId=0;
		if(pilotRegHdList !=null && pilotRegHdList.size() >0){
			
			pilotRegHd=pilotRegHdList.get(0);

			AvPilotRegistrationHd pilotRegObj = (AvPilotRegistrationHd) hbt.load(AvPilotRegistrationHd.class, pilotRegHd.getId());
			hbt.update(pilotRegObj);
			pilotHdId = pilotRegObj.getId();
	
	         for (int i = 0; i < serviceNoList.size(); i++) {
				 AvPilotRegistrationDt avPilotRegistrationDt=new AvPilotRegistrationDt();
				 if(serviceNoList.get(i)!=null){
					 avPilotRegistrationDt.setServiceNo(serviceNoList.get(i));
				 }
				 if(nameList.get(i)!=null){
					 avPilotRegistrationDt.setFullName(nameList.get(i));
				 }
				 if(ageList.get(i)!=null){
					 avPilotRegistrationDt.setAge(ageList.get(i));
				 }
				 
				 if(Integer.parseInt(hinList.get(i).toString())!=0){
					 Patient patient=new Patient();
					 patient.setId(hinList.get(i));
					 avPilotRegistrationDt.setHin(patient);
				 }
				 if(rankList.get(i)!=null && !rankList.get(i).equals("")){
					 MasRank masRank=new MasRank();
					 masRank.setId(rankList.get(i));
					 avPilotRegistrationDt.setRank(masRank);
				 }
				 if(categoryIdList.get(i)!=null && !categoryIdList.get(i).equals("")){
					 Category category=new Category();
					 category.setCategoryid(categoryIdList.get(i));
					 avPilotRegistrationDt.setCategory(category);
				 }
				 avPilotRegistrationDt.setDateOfLastMe(HMSUtil
							.convertStringTypeDateToDateType(dateOfLastME));
				 avPilotRegistrationDt.setAvPilotRegistrationHd(pilotRegObj);
				 hbt.save(avPilotRegistrationDt);
			 }
		}else{
		hbt.save(avPilotRegistrationHd);
		
		for (int i = 0; i < serviceNoList.size(); i++) {
			 AvPilotRegistrationDt avPilotRegistrationDt=new AvPilotRegistrationDt();
			 if(serviceNoList.get(i)!=null){
				 avPilotRegistrationDt.setServiceNo(serviceNoList.get(i));
			 }
			 if(nameList.get(i)!=null){
				 avPilotRegistrationDt.setFullName(nameList.get(i));
			 }
			 if(ageList.get(i)!=null){
				 avPilotRegistrationDt.setAge(ageList.get(i));
			 }
			 
			 if(Integer.parseInt(hinList.get(i).toString())!=0){
				 Patient patient=new Patient();
				 patient.setId(hinList.get(i));
				 avPilotRegistrationDt.setHin(patient);
			 }
			 if(rankList.get(i)!=null && !rankList.get(i).equals("")){
				 MasRank masRank=new MasRank();
				 masRank.setId(rankList.get(i));
				 avPilotRegistrationDt.setRank(masRank);
			 }
			 if(categoryIdList.get(i)!=null && !categoryIdList.get(i).equals("")){
				 Category category=new Category();
				 category.setCategoryid(categoryIdList.get(i));
				 avPilotRegistrationDt.setCategory(category);
			 }
			 avPilotRegistrationDt.setDateOfLastMe(HMSUtil
						.convertStringTypeDateToDateType(dateOfLastME));
			 avPilotRegistrationDt.setAvPilotRegistrationHd(avPilotRegistrationHd);
			 hbt.save(avPilotRegistrationDt);
		 }
		}
		
		successfullyAdded = true;
		return successfullyAdded;
	}
	/*public Boolean updatePilotRegistration(Map<String, Object> infoMap) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		
		int unitId=0;
		if(infoMap.get("unitId") !=null){
			unitId=(Integer)infoMap.get("unitId");
		}
		List<AvPilotRegistrationHd> pilotRegHdList = new ArrayList<AvPilotRegistrationHd>();
		pilotRegHdList=session.createCriteria(AvPilotRegistrationHd.class)
					.add(Restrictions.eq("Unit.Id", unitId)).list();
		
		System.out.println("pilotRegHdList---in update--->"+pilotRegHdList.size());
		AvPilotRegistrationHd avPilotRegistrationHd = pilotRegHdList.get(0);
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		if(pilotRegHdList !=null && pilotRegHdList.size() >0){
			AvPilotRegistrationHd pilotRegObj = (AvPilotRegistrationHd) hbt.load(AvPilotRegistrationHd.class, avAccidentId);
		}else{
		hbt.save(avPilotRegistrationHd);
		//}
		List<String> serviceNoList = new ArrayList<String>();
		List<Integer> rankList = new ArrayList<Integer>();
		List<Integer> hinList = new ArrayList<Integer>();
		List<String> nameList = new ArrayList<String>();
		List<String> ageList = new ArrayList<String>();
		List<Integer> categoryIdList = new ArrayList<Integer>();
		serviceNoList = (List) infoMap.get("serviceNoList");
		rankList = (List) infoMap.get("rankList");
		hinList = (List) infoMap.get("hinList");
		nameList = (List) infoMap.get("nameList");
		ageList = (List) infoMap.get("ageList");
		categoryIdList = (List) infoMap.get("categoryIdList");
		
		String dateOfLastME="";
		dateOfLastME= (String) infoMap.get("dateOfLastME");
		for (int i = 0; i < serviceNoList.size(); i++) {
			 AvPilotRegistrationDt avPilotRegistrationDt=new AvPilotRegistrationDt();
			 if(serviceNoList.get(i)!=null){
				 avPilotRegistrationDt.setServiceNo(serviceNoList.get(i));
			 }
			 if(nameList.get(i)!=null){
				 avPilotRegistrationDt.setFullName(nameList.get(i));
			 }
			 if(ageList.get(i)!=null){
				 avPilotRegistrationDt.setAge(ageList.get(i));
			 }
			 
			 if(Integer.parseInt(hinList.get(i).toString())!=0){
				 Patient patient=new Patient();
				 patient.setId(hinList.get(i));
				 avPilotRegistrationDt.setHin(patient);
			 }
			 if(rankList.get(i)!=null && !rankList.get(i).equals("")){
				 MasRank masRank=new MasRank();
				 masRank.setId(rankList.get(i));
				 avPilotRegistrationDt.setRank(masRank);
			 }
			 if(categoryIdList.get(i)!=null && !categoryIdList.get(i).equals("")){
				 Category category=new Category();
				 category.setCategoryid(categoryIdList.get(i));
				 avPilotRegistrationDt.setCategory(category);
			 }
			 avPilotRegistrationDt.setDateOfLastMe(HMSUtil
						.convertStringTypeDateToDateType(dateOfLastME));
			 avPilotRegistrationDt.setAvPilotRegistrationHd(avPilotRegistrationHd);
			 hbt.save(avPilotRegistrationDt);
		 }
		
		successfullyAdded = true;
		return successfullyAdded;
	}*/
	@Override
	public Map findPilotDetail(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Vector<HashMap> vResult = new Vector<HashMap>();
		int unitNameId = box.getInt("unitNameId");
		HashMap[] testPageData = null;
		//PagedArray pagedArray = null;
		List<AvPilotRegistrationDt>pilotRegDtList = new ArrayList<AvPilotRegistrationDt>();
		List<AvPilotRegistrationHd>pilotRegHdList = new ArrayList<AvPilotRegistrationHd>();
		Session session = (Session) getSession();
		HashMap<String, Object> hData = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		/*pilotRegHdList = session.createCriteria(AvPilotRegistrationHd.class)
				.add(Restrictions.eq("Unit.Id", unitNameId)).list();*/
	//	AvPilotRegistrationHd pilotRegistrationHd = (AvPilotRegistrationHd) pilotRegHdList.get(0);
		pilotRegDtList = session.createCriteria(AvPilotRegistrationDt.class)
				.createAlias("AvPilotRegistrationHd", "avHd")
				.add(Restrictions.eq("avHd.Unit.Id", unitNameId)).list();
		
		/*int j=0;
		for (AvPilotRegistrationDt pilotRegDt : pilotRegDtList) {
			int pilot_hd_id = 0;
			int pilot_dt_id=0;
			String pilotName = null;
			String service_no = null;
			String rank = null;
			String age="";
			String unit="";
			String medCat="";

			if (pilotRegDt.getServiceNo() != null) {
				service_no = pilotRegDt.getServiceNo();
				pilot_hd_id = pilotRegDt.getAvPilotRegistrationHd().getId();
				pilot_dt_id = pilotRegDt.getId();
				pilotName=pilotRegDt.getFullName();
				if(pilotRegDt.getRank()!=null){
					rank=pilotRegDt.getRank().getRankName();
				}
				if(pilotRegDt.getAge()!=null){
					age=pilotRegDt.getAge();
				}
				if(pilotRegDt.getAvPilotRegistrationHd().getUnit() !=null){
					unit=pilotRegDt.getAvPilotRegistrationHd().getUnit().getUnitName();
				}
				if(pilotRegDt.getCategory() !=null){
					medCat=pilotRegDt.getCategory().getCategories();
				}
				hData = new HashMap<String, Object>();
				hData.put("pilot_hd_id", pilot_hd_id);
				hData.put("pilot_dt_id", pilot_dt_id);
				hData.put("pilotName", pilotName);
				hData.put("service_no", service_no);
				hData.put("rank", rank);
				hData.put("age", age);
				hData.put("unit", unit);
				hData.put("medCat", medCat);
				vResult.add(hData);
			}

	}
		if (vResult.size() > 0) {
			testPageData = new HashMap[vResult.size()];
			vResult.copyInto(testPageData);
		}

		map.put("pagedArray", pagedArray);
		try {
			pagedArray = new PageUtil().convertToPagedArrayIndexLen(testPageData,box,vResult.size());
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		map.put("pilotRegistrationList", pilotRegDtList);
		return map;
	}

	@Override
	public Map<String, Object> getAdjustmentList(int radioStr, int pageNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Category> categoryList = null;
		Session session = (Session) getSession();
		List<AvPilotRegistrationHd>pilotRegHdList = new ArrayList<AvPilotRegistrationHd>();
		List<AvPilotRegistrationDt>pilotRegDtList = new ArrayList<AvPilotRegistrationDt>();
		
		pilotRegHdList = session.createCriteria(AvPilotRegistrationHd.class)
		.add(Restrictions.eq("Id", radioStr)).list();
		
		pilotRegDtList = session.createCriteria(AvPilotRegistrationDt.class)
		.createAlias("AvPilotRegistrationHd", "avHd")
		.add(Restrictions.eq("avHd.Id", radioStr)).list();

		categoryList = session.createCriteria(Category.class).addOrder(Order.asc("Categories")).list();
		map.put("pilotRegHdList", pilotRegHdList);
		map.put("pilotRegistrationList", pilotRegDtList);
		map.put("categoryList", categoryList);
		return map;
		
	}
}