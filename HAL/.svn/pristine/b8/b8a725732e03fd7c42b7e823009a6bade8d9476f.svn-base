package jkt.hms.medicalExam.dataservice;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.REPORTED_DATE;
import static jkt.hms.util.RequestConstants.TO_DATE;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadFile;
import jkt.hms.masters.business.Category;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgResultEntryHeader;
import jkt.hms.masters.business.Disability;
import jkt.hms.masters.business.Disabilitygroup;
import jkt.hms.masters.business.InjAppointmentDetails;
import jkt.hms.masters.business.InjAppointmentHeader;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasMedicalBoardExaminationDetail;
import jkt.hms.masters.business.MasMedicalExamFamilyHis;
import jkt.hms.masters.business.MasMedicalExamInvestResult;
import jkt.hms.masters.business.MasMedicalExamReportDt;
import jkt.hms.masters.business.MasMedicalExaminationDetail;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.masters.business.MasMedicalUploadDocument;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasRecordOfficeAddress;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasReporting;
import jkt.hms.masters.business.MasSection;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStation;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemConversion;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasSystemDiagnosis;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.OpdPatientHistory;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientFamilyHistory;
import jkt.hms.masters.business.PatientInvestigationDetails;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lowagie.text.pdf.ByteBuffer;

public class MedicalExamDataServiceImpl extends HibernateDaoSupport implements MedicalExamDataService 
{

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showMedicalExamRegistrationJsp(int hospitalId) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList = null;
		List<MasRelation> relationList = null;
		List<MasRank> rankList = null;
		List<Object[]> unitList = null;
		List<MasMaritalStatus> maritalStatusList = null;
		List<MasTrade> tradeList = null;
		List<MasBloodGroup> bloodGroupList = null;
		List<MasEmployee> employeeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<Visit> currentDateVisitList = null;
		List<MasServiceStatus> serviceStatusList = null;
		List<MasStation> stationList = null;
		List<MasSection> sectionList = null;
		List<MasReporting> reportingList = null;
		List<MasCommand> commandList = null;
		List<Category> categoryList = null;
		
		List<MasCountry> countryList = null;
		List<MasState> stateList = null;
		List<MasDistrict> districtList = null;
		List<MasRecordOfficeAddress> recordOfficeAddressList = null;
		List<MasReligion> religionList = null;
		List<PatientFamilyHistory> familyHistoryList = null;
		List<MasTitle> titleList = null;
		Date currentDate = new Date();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			
			/*serviceTypeList = hbt.find("from MasServiceType mst where mst.Status='y'");*/				
			serviceTypeList = session.createCriteria(MasServiceType.class ).add(Restrictions.eq("Status","y")).list();
			
			/*rankList = hbt.find("from MasRank as rank where rank.Status='y'  order by rank.RankName ");*/
			rankList = session.createCriteria( MasRank.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc ("RankName")).list();
			
			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).createAlias("Station", "station").setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))
							.add(Projections.property("station.StationName"))).addOrder(Order.asc("UnitName")).list();
			
			/*maritalStatusList = hbt.find("from MasMaritalStatus mms where mms.Status='y'");*/
			maritalStatusList = session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status","y")).list();
			/*tradeList =hbt.find("from MasTrade mt where mt.Status='y' order by mt.TradeName");*/
			tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("TradeName")).list();
			/*relationList =hbt.find("from MasRelation as mr where mr.Status='y'");*/
			relationList = session.createCriteria(MasRelation.class).add(Restrictions.eq("Status","y")).list();
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
							.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).list();
			/*bloodGroupList = hbt.find("from MasBloodGroup as dist where dist.Status='y' order by dist.BloodGroupName");*/
			bloodGroupList = session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("BloodGroupName")).list();
			/*sexList = hbt.find("from MasAdministrativeSex mas where mas.Status='y'");*/
			sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status","y")).list();
			sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y"))
						.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("SectionName")).list();
			/*stationList = hbt.find("from MasStation mas where mas.Status='y' order by mas.StationName");*/
			stationList = session.createCriteria(MasStation.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("StationName")).list();
			/*reportingList = hbt.find("from MasReporting mas where mas.Status='y'");*/
			reportingList = session.createCriteria(MasReporting.class).add(Restrictions.eq("Status","y")).list();
			/*commandList = hbt.find("from MasCommand mas where mas.Status='y' order by mas.CommandName");*/
			commandList = session.createCriteria(MasCommand.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("CommandName")).list();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		//	currentDateVisitList =hbt.find("from Visit as v where v.VisitDate='"+sdf.format(currentDate)+"'");
			currentDateVisitList = session.createCriteria(Visit.class).add(Restrictions.eq("VisitDate",sdf.format(currentDate))).list();
			/*serviceStatusList = hbt.find("from MasServiceStatus mss where mss.Status='y'");*/
			serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status","y")).list();
			/*countryList = hbt.find("from MasCountry mc where mc.Status='y'");*/
			countryList = session.createCriteria(MasCountry.class).add(Restrictions.eq("Status","y")).list();
			/*stateList = hbt.find("from MasState ms where ms.Status='y'");*/
			stateList = session.createCriteria(MasState.class).add(Restrictions.eq("Status","y")).list();
			/*districtList =hbt.find("from MasDistrict as md where md.Status='y' order by md.DistrictName ");*/
			districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("DistrictName")).list();
			religionList = session.createCriteria(MasReligion.class).add(Restrictions.eq("Status", "y")).list();			
			recordOfficeAddressList = session.createCriteria(MasRecordOfficeAddress.class).add(Restrictions.eq("Status", "y")).list();
			/*familyHistoryList = hbt.find("from PatientFamilyHistory mss where mss.Status='y'");*/
			familyHistoryList = session.createCriteria(PatientFamilyHistory.class).add(Restrictions.eq("Status","y")).list();
					
			/*titleList = hbt.find("from MasTitle mt where mt.Status ='y'");*/
			titleList = session.createCriteria(MasTitle.class).add(Restrictions.eq("Status","y")).list();
			/*categoryList = hbt.find("from Category c")*/;
			categoryList = session.createCriteria(Category.class).list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("serviceTypeList", serviceTypeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("maritalStatusList", maritalStatusList);
		map.put("tradeList", tradeList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("sexList", sexList);
		map.put("relationList", relationList);
		map.put("employeeList", employeeList);
		map.put("currentDateVisitList", currentDateVisitList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("sectionList", sectionList);
		map.put("stationList", stationList);
		map.put("reportingList", reportingList);
		map.put("commandList", commandList);
		map.put("countryList", countryList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("religionList", religionList);
		map.put("recordOfficeAddressList", recordOfficeAddressList);
		map.put("titleList", titleList);
		map.put("familyHistoryList", familyHistoryList);	
		map.put("categoryList", categoryList);
		
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showMedicalExamWaitingList(int hospitalId) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		List<Visit> meVisitList = new ArrayList<Visit>();		
		Session session = (Session) getSession();
	
		
		cr = session.createCriteria(Visit.class).add(Restrictions.eq("VisitStatus","c")).add(Restrictions.eq("MedStatus","w")).add(Restrictions.eq("ReportingFor", "MedExam"))
						.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
						.addOrder(Order.desc("Id"));	
		
		meVisitList = cr.list();

		List<String> labResultStausList=new ArrayList<String>();
		for(Visit visit:meVisitList)
		{
			String resultStatus="no";
			
			int visitId = visit.getId();
			System.out.println("visitId="+visitId);
			
			
		if(visit.getDgOrderhds()!=null)
			{
				resultStatus="pending";
         		Set<DgOrderhd> dgOrderhdSet=visit.getDgOrderhds();     		
         		
         		
         		for(DgOrderhd hd: dgOrderhdSet)
         		{
         			Set<DgOrderdt> dgOrderdtSet=hd.getDgOrderdts();	
         		
         		
         		
			    if(dgOrderhdSet.size()>0)
			    {	    		
			    				
			    				
			    			List<DgResultEntryHeader> dgResultEntryHeaderList=session.createCriteria(DgResultEntryHeader.class)
			    					.createAlias("SampleCollectionHeader", "collectionHeader")
			    					.createAlias("SampleCollectionHeader.Order", "dgOrder")			    					
                            .add(Restrictions.eq("dgOrder.Id",hd.getId()))
                            .add(Restrictions.eq("Verified","V")).list();
			    			if(dgResultEntryHeaderList.size()>0)
			    			{
			    				if(dgResultEntryHeaderList.size() == dgOrderdtSet.size())
			    				resultStatus="validated";
			    			}
			    			
			    			
			    		
			    	
			    }
         		}
			}
			//System.out.println("resultStatus="+resultStatus);
			labResultStausList.add(resultStatus);
		}
		System.out.println("meVisitList="+meVisitList.size());
		map.put("meVisitList", meVisitList);
		map.put("labResultStausList", labResultStausList);
	
		
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPrimaryExtMedExamJsp(Box box)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> meVisitList = new ArrayList<Visit>();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		org.hibernate.Session session = getSession();
		
		meVisitList = session.createCriteria(Visit.class).add(Restrictions.idEq(box.getInt("visitId")))
					//.add(Restrictions.eq("ReportingFor", "MedExam"))
					.add(Restrictions.eq("MedExamType", "Primary/Extension Med. Exam(AFMSF-2A)")).list();
		templateList = session.createCriteria(OpdTemplate.class).createAlias("Department", "dept").add(
						Restrictions.eq("dept.Id", box.getInt("deptId"))).add(Restrictions.eq("Status", "y")).list();
		int visitId=box.getInt("visitId");
		List<Visit> visit = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		// Commented by sanjay yadav
		/*visit =hbt.find("from Visit as v where v.Id='"+visitId+"'");*/
		visit =session.createCriteria(Visit.class).add(Restrictions.eq("Id",visitId)).list();
		 Visit visitdata=null;
		  PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
		  List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		 if(visit!=null&&visit.size()>0)
				  {
					  visitdata= visit.get(0);
				  }
		  patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
					.createCriteria(PatientInvestigationHeader.class)
					.createAlias("Visit", "v").add(
							Restrictions.eq("v.Id", visitId))
					.createAlias("Hin", "p").add(
							Restrictions.eq("p.Id",visitdata.getHin().getId())).list();
		          if (patientInvestigationHeaderList != null && patientInvestigationHeaderList.size() > 0) {
						patientInvestigationHeader = patientInvestigationHeaderList.get(0);
						map.put("patientInvestigationHeader",patientInvestigationHeader);
						List<PatientInvestigationDetails> patientInvestigationDetailsList=session.createCriteria(PatientInvestigationDetails.class)
						.add(Restrictions.eq("InvestigationHeader.Id",patientInvestigationHeader.getId() ))
						.addOrder(Order.asc("ReferToMh")).addOrder(Order.asc("ChargeCode.Id")).list();
						//.addOrder(Order.asc("Id")).list();
	                map.put("patientInvestigationDetailsList",patientInvestigationDetailsList);

						
					}
		          List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		          dgOrderhdList = (List<DgOrderhd>) session
					.createCriteria(DgOrderhd.class)
					.createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				      
		        DgOrderhd dgOrderhd =null;
		        if (dgOrderhdList != null && dgOrderhdList.size() > 0) {
		        	dgOrderhd = dgOrderhdList.get(0);
					map.put("dgOrderhd",dgOrderhd);
					List<DgOrderdt> dgOrderdtList=session.createCriteria(DgOrderdt.class).add(Restrictions.eq("Orderhd.Id", dgOrderhd.getId()))
		          	.addOrder(Order.asc("LastChgDate")).addOrder(Order.asc("LastChgTime")).list();

					map.put("dgOrderdtList",dgOrderdtList);
				}
				List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
				resultList = session.createCriteria(DgResultEntryHeader.class)
				.createAlias("SampleCollectionHeader", "smColl").createAlias("smColl.Order", "order")
				.createAlias("order.Visit", "vst").add(Restrictions.eq("vst.Id", visitId))
				.add(Restrictions.eq("ResultStatus", "A")).addOrder(Order.asc("LastChgdDate")).addOrder(Order.asc("LastChgdTime")).list();
	           if (resultList != null || resultList.size() > 0) {
	        	map.put("resultList", resultList);
	        }			
	           /**
	            * Getting data for dental from opd_patient_details
	            * Code By Ritu
	            * Date 03.12.2012
	            */
	           List<Visit> dentalVisitList = new ArrayList<Visit>();
	           dentalVisitList = session.createCriteria(Visit.class).add(Restrictions.eq("Hin.Id", visitdata.getHin().getId())).add(Restrictions.eq("DentalFlag", "MedExam2A")).addOrder(Order.desc("Id")).setMaxResults(1).list();
	           if(dentalVisitList.size() > 0){
	         	  List<OpdPatientDetails> opdDentalDetailsList = new ArrayList<OpdPatientDetails>();
	         	  opdDentalDetailsList = session.createCriteria(OpdPatientDetails.class).add(Restrictions.eq("Visit.Id", dentalVisitList.get(0).getId())).list();
	         	  map.put("opdDentalDetailsList", opdDentalDetailsList);
	           }
	           /**
	            * End
	            */
	           
	           List<MasEmployee>doctorList = new ArrayList<MasEmployee>();
	           doctorList = session.createCriteria(MasEmployee.class).add(
	 					Restrictions.eq("Status", "y")).createAlias("EmpCategory",
	 					"empCat").add(Restrictions.eq("empCat.EmpCategoryCode", "01")).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
	 					.addOrder(Order.asc("FirstName")).list();
	           map.put("doctorList", doctorList);
		map.put("meVisitList", meVisitList);
		map.put("templateList", templateList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> addMedicalExaminationBoardAnnual(
			MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry,
			List<MasMedicalBoardExaminationDetail> masMedicalBoardExaminationDetail,
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		String date = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		List<TransactionSequence> medicalWorkNoList = new ArrayList<TransactionSequence>();
        
		date = (String) utilMap.get("currentDate");
		String[] currentDate = date.split("/");
		String currentMonth = currentDate[1];
		org.hibernate.Session session = getSession();
		boolean successfullyAdded = false;
		boolean saveinvestigation = false;
		HibernateTemplate hbt = null;
		Transaction tx = null;
		String[] familyHistoryArray=(String[]) mapForDS.get("familyHistoryArray");
		try {
			tx = session.beginTransaction();
			hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			saveinvestigation=saveInvestigationAdd(mapForDS);
			
			if (saveinvestigation) {
			hbt.save(masMedicalExaminationReportOnEntry);
			int medExamId=masMedicalExaminationReportOnEntry.getId();
			map.put("medExamId",medExamId);
			List<Integer> serialnolist = new ArrayList<Integer>();
			List<String> fromlist = new ArrayList<String>();
			List<String> tolist = new ArrayList<String>();
			List<String> placelist = new ArrayList<String>();
			List<String> pnolist = new ArrayList<String>();
			List<String> illnessIcdlist = new ArrayList<String>();
			List<String> approximatedatelist1 = new ArrayList<String>();
			List<Date> particulardatelist = new ArrayList<Date>();
			//List<Integer> rankidlist = new ArrayList<Integer>();
			List<String> treatedlist = new ArrayList<String>();
			List<String> approximatedatelist = new ArrayList<String>();
			List<Integer> serialnolist1 = new ArrayList<Integer>();
			List<String> placelist1 = new ArrayList<String>();
			List<String> principallist = new ArrayList<String>();
			List<Date> origindatelist = new ArrayList<Date>();
			List<Date> medicalcatdatelist = new ArrayList<Date>();
			List<Date> nextcatdatelist = new ArrayList<Date>();
			List<String> investigationReferToMHList=new ArrayList<String>();
			int hiddenValue=1;
			int hiddenValue1=1;
			int hdbvalue=1;
			int hdbvalue1=1;
			int departmentId =(Integer) mapForDS.get("departmentId"); 
			int medicalOfficerId =(Integer) mapForDS.get("medicalOfficer"); 
			int visitId=(Integer) mapForDS.get("visitId");
			int hinId=(Integer) mapForDS.get("hinId");
			String allergies = (String)mapForDS.get("allergies");
			if(mapForDS.get("investigationReferToMHList")!= null)
			{
			investigationReferToMHList =  (List<String>) mapForDS.get("investigationReferToMHList");
			}
			if(allergies != null )
			{
			    Patient ptObj = (Patient)hbt.load(Patient.class, hinId);
			    ptObj.setDrugAllergies(allergies);
			    hbt.update(ptObj);
			}
			List<String> batchNoList = (List<String>) mapForDS.get("batchNoList");
			if(masMedicalExaminationReportOnEntry.getMedicalExamType().equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
			{
				 
				if(mapForDS.get("serialnolist") != null){
					serialnolist = (List) mapForDS.get("serialnolist");
				}
				if(mapForDS.get("fromlist") != null){
				  fromlist = (List) mapForDS.get("fromlist");
				}
				if(mapForDS.get("tolist") != null){
					tolist = (List) mapForDS.get("tolist");
				}
				if(mapForDS.get("placelist") != null){
				 placelist = (List) mapForDS.get("placelist");
				}
				if(mapForDS.get("pnolist") != null){
					pnolist = (List) mapForDS.get("pnolist");
				}
				if(mapForDS.get("hiddenValue") != null){
				  hiddenValue = (Integer) mapForDS.get("hiddenValue");
					
				}
				if(mapForDS.get("hdbvalue") != null){
					hdbvalue = (Integer) mapForDS.get("hdbvalue");
				}
				if(mapForDS.get("principallist") != null){
				  principallist = (List) mapForDS.get("principallist");
					
				}
				if(mapForDS.get("origindatelist") != null){
					origindatelist = (List) mapForDS.get("origindatelist");
				}
				if(mapForDS.get("medicalcatdatelist") != null){
					medicalcatdatelist = (List) mapForDS.get("medicalcatdatelist");
				}
				if(mapForDS.get("nextcatdatelist") != null){
					nextcatdatelist = (List) mapForDS.get("nextcatdatelist");
				}
				 
				 for (int i = 0; i < hdbvalue; i++) {
					 MasMedicalExaminationDetail masmedical=new MasMedicalExaminationDetail();
					 if(serialnolist.size()>0)
					 masmedical.setSerialno(serialnolist.get(i));
					 if(fromlist.size()>0 && fromlist!= null)
					 masmedical.setAddressfrom(HMSUtil.convertStringTypeDateToDateType(fromlist.get(i)));
					 if(tolist.size()>0 && tolist != null)
					 masmedical.setAddressto(HMSUtil.convertStringTypeDateToDateType(tolist.get(i)));
					 
					 if(placelist.size()>0)
					 masmedical.setPlace(placelist.get(i));
					 if(pnolist.size()>0)
					 masmedical.setPno(pnolist.get(i));
					 masmedical.setParticular("detail");
					 masmedical.setMasMedicalReport(masMedicalExaminationReportOnEntry);
					 /*if(principallist.size()>0){
						 String str="";
						 String principal ="";
						 str= (String)principallist.get(i);
						 int lastIndex=str.indexOf("[");
							if(lastIndex>0)
							{   
								principal=str.substring(0, lastIndex);
						    	
							}else{
								principal=str;
							}
							
					 masmedical.setPrincipal(principal);
					 }*/
					 if(origindatelist.size()>0)
					 masmedical.setOrigindate(origindatelist.get(i));
					 if(medicalcatdatelist.size()>0)
					 masmedical.setMedicalcatdate(medicalcatdatelist.get(i));
					 if(nextcatdatelist.size()>0)
					 masmedical.setNextcatdate(nextcatdatelist.get(i));
					 hbt.save(masmedical);
				 }
			}
			if(masMedicalExaminationReportOnEntry.getMedicalExamType().equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
		 	{
		 	 serialnolist1 = (List) mapForDS.get("serialnolist1");
		 	illnessIcdlist = (List) mapForDS.get("illnessIcdlist");
		 	
			 particulardatelist = (List) mapForDS.get("particulardatelist");
			 //rankidlist = (List) mapForDS.get("rankidlist");
			 treatedlist = (List) mapForDS.get("treatedlist");
			 approximatedatelist1 = (List) mapForDS.get("approximatedatelist1");
			 approximatedatelist = (List) mapForDS.get("approximatedatelist");
			 hiddenValue1 = (Integer) mapForDS.get("hiddenValue1");
			 hdbvalue1 = (Integer) mapForDS.get("hdbvalue1");
			 placelist1 = (List) mapForDS.get("placelist1");
		 for (int i = 0; i < illnessIcdlist.size(); i++) {
			 MasMedicalExaminationDetail masmedical1=new MasMedicalExaminationDetail();
			 if(illnessIcdlist != null && !(illnessIcdlist).equals("") && illnessIcdlist.size()>0 ){
			 MasIcd masIcd = new MasIcd();
			 masIcd.setId(Integer.parseInt(illnessIcdlist.get(i)));
			 masmedical1.setMasIcd(masIcd);
			 /*MasSystemDiagnosis masSystemDiagnosis = new MasSystemDiagnosis();
			 masSystemDiagnosis.setId(Integer.parseInt(illnessIcdlist.get(i)));
			 	masmedical1.setSystemDiagnosis(masSystemDiagnosis);
			*/
			 if(serialnolist1.size()>0)
			 masmedical1.setSerialNo1(serialnolist1.get(i));
			 
			
			 if(particulardatelist.size()>0)
			 masmedical1.setParticulardate(particulardatelist.get(i));
			 /*if(rankidlist.size()>0)
			 {
			 MasRank masrank=new MasRank();
			 masrank.setId(rankidlist.get(i));
			 masmedical1.setRankIndividual(masrank);
			 }*/
			 if(approximatedatelist.size()>0)
			 if(!approximatedatelist.get(i).equals(""))
				 masmedical1.setApproximatedate1(HMSUtil.convertStringTypeDateToDateType(approximatedatelist.get(i)));
			 if(approximatedatelist1.size()>0)
				 if(!approximatedatelist1.get(i).equals(""))
				 masmedical1.setApproximatedate2(HMSUtil.convertStringTypeDateToDateType(approximatedatelist1.get(i)));
			 if(placelist1.size()>0)
			 masmedical1.setPlace1(placelist1.get(i));
			 if(treatedlist.size()>0)
			 masmedical1.setTreated(treatedlist.get(i));
			 masmedical1.setBeforeDisability("n");
			 masmedical1.setParticular("particular");
			 masmedical1.setMasMedicalReport(masMedicalExaminationReportOnEntry);
			 hbt.save(masmedical1);
		   }
		  }
		 }
	//-----------code  before joining armed forces-------------------------//
			List<Integer> srNoList = new ArrayList<Integer>();
			List<String> icdIdList = new ArrayList<String>();
			List<String> pDateList = new ArrayList<String>();
			//List<String> particulardateBeforeList = new ArrayList<String>();
			List<String> particularPlaceList = new ArrayList<String>();
			List<String> whereTreatedList = new ArrayList<String>();
			List<String> beforeDisabilityBeforeList = new ArrayList<String>();
			int hdbBefore =0;
			if(masMedicalExaminationReportOnEntry.getMedicalExamType().equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
		 	{
				if(mapForDS.get("srNoList") != null){
					srNoList = (List) mapForDS.get("srNoList");
				}
				if(mapForDS.get("icdIdList") != null){
					icdIdList = (List) mapForDS.get("icdIdList");
				}
				//particulardateBeforeList = (List) mapForDS.get("particulardateBeforeList");
				if(mapForDS.get("hdbBefore") != null){
					hdbBefore = (Integer) mapForDS.get("hdbBefore");
				}
				if(mapForDS.get("particularPlaceList") != null){
					particularPlaceList = (List) mapForDS.get("particularPlaceList");
				}
				if(mapForDS.get("pDateList") != null){
					pDateList = (List) mapForDS.get("pDateList");
				}
				if(mapForDS.get("whereTreatedList") != null){
					whereTreatedList = (List) mapForDS.get("whereTreatedList");
				}
				if(mapForDS.get("beforeDisabilityBeforeList")!=null){
					beforeDisabilityBeforeList=(List)mapForDS.get("beforeDisabilityBeforeList");
				}
		 for (int i = 0; i < hdbBefore; i++) {
			 MasMedicalExaminationDetail masmedicalDt=new MasMedicalExaminationDetail();
			/* MasSystemDiagnosis systemDiagnosis = new MasSystemDiagnosis();
			 if(icdIdList.size()>0 && icdIdList != null){
				 systemDiagnosis.setId(Integer.parseInt(icdIdList.get(i)));
			   masmedicalDt.setSystemDiagnosis(systemDiagnosis);*/
			 
			 if(icdIdList.size()>0 && icdIdList != null){
				 MasIcd masIcd = new MasIcd();
				 masIcd.setId(Integer.parseInt(icdIdList.get(i)));
				 masmedicalDt.setMasIcd(masIcd);

				 if(srNoList.size()>0)
					 masmedicalDt.setSerialno(srNoList.get(i));

				 if(pDateList.size()>0)
					 masmedicalDt.setParticulardate(HMSUtil.convertStringTypeDateToDateType(pDateList.get(i)));

				 if(particularPlaceList.size()>0){
					 masmedicalDt.setPlace(particularPlaceList.get(i));
				 }
				 if(whereTreatedList.size()>0){
					 masmedicalDt.setTreated(whereTreatedList.get(i));
				 }
				 masmedicalDt.setParticular("particular");
				 if(beforeDisabilityBeforeList.get(i)!=null){
					 masmedicalDt.setBeforeDisability(beforeDisabilityBeforeList.get(i));
				 }
				 masmedicalDt.setMasMedicalReport(masMedicalExaminationReportOnEntry);
				 hbt.save(masmedicalDt);
			 }
		  }	
		 }
		
	hbt.refresh(masMedicalExaminationReportOnEntry);
//----Alcohal and otherFamilyHistory update in patient table(By Dipali)
	String otherFamilyHistory="";
	String  alcohol="";
	if(mapForDS.get("alcohol") !=null){
	alcohol = (String) mapForDS.get("alcohol");
	}
	Patient patient=(Patient)session.get(Patient.class,hinId);
	patient.setAlcohol(alcohol);
	if(mapForDS.get("presentMedicalCategoryId")!=null)
	{
		Category category = new Category();
		category.setCategoryid((Integer)mapForDS.get("presentMedicalCategoryId"));
		patient.setCategory(category);
		
	}
	if(mapForDS.get("identification1")!=null )
	{	
	patient.setSrIdentificationMark1((String)mapForDS.get("identification1"));
	}
	if(mapForDS.get("identification2")!=null )
	{	
    	patient.setSrIdentificationMark2((String)mapForDS.get("identification2"));
	}
    	if(mapForDS.get("otherFamilyHistory") !=null){
		otherFamilyHistory = (String) mapForDS.get("otherFamilyHistory");
		}
		patient.setOtherFamilyHistory(otherFamilyHistory);
		if(mapForDS.get("smokerLess10") !=null){
			patient.setSmokerLess10("y");
		}else{
			patient.setSmokerLess10("n");
		}
		if(mapForDS.get("smokerMore10") !=null){
			patient.setSmokerMore10("y");
		}else{
			patient.setSmokerMore10("n");
		}
	 hbt.update(patient);
	
	//----------------------------------	    
	      Visit visit=(Visit)session.get(Visit.class,visitId);
		     if(visit!=null)
		     {	    	
	    	 if(visit.getPriority()!=null){
	    		 if(visit.getPriority()==1){
	    			 visit.setPriority(4);		 
	    		 }else if(visit.getPriority()==2){
	    			 visit.setPriority(5);		 
	    		 }else if(visit.getPriority()==3){
	    			 visit.setPriority(6);		 
	    		 }
	    	 }
	    	if(medicalOfficerId != 0){
	    	MasEmployee masEmployee = new MasEmployee();
	    	masEmployee.setId(medicalOfficerId);
	    	visit.setDoctor(masEmployee);
	    	}
	    	if(departmentId != 0){
	    	MasDepartment masDepartment = new MasDepartment();
	    	masDepartment.setId(departmentId);
	    	visit.setDepartment(masDepartment);
	    	}
    		//visit.setPriority(1);		 

	    	 hbt.update(visit);
	     }
		/*String sqlQuery = "select max(id)from MasMedicalExaminationReportOnEntry";
		Query query = session.createQuery(sqlQuery);
		List list = query.list();
		int id = Integer.parseInt(list.get(0).toString());
		

		
		if (medicalExaminationBoard && masMedicalBoardExaminationDetail != null) {

			for (MasMedicalBoardExaminationDetail masMedicalExaminationBoardDetails : masMedicalBoardExaminationDetail) {
				MasMedicalExaminationReportOnEntry masMadicalExaminationBoard = new MasMedicalExaminationReportOnEntry();
				masMadicalExaminationBoard.setId(id);
				masMedicalExaminationBoardDetails
						.setMedicalExamination(masMadicalExaminationBoard);
				hbt.save(masMedicalExaminationBoardDetails);
			}
				
		}*/
		successfullyAdded = true;
		medicalWorkNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "MED")).add(Restrictions.eq("Hospital.Id", (Integer)mapForDS.get("hospitalId"))).list();
	

		if (successfullyAdded) {
			if(medicalWorkNoList.size() > 0){
			for (TransactionSequence transactionSequence : medicalWorkNoList) {
				TransactionSequence obj = transactionSequence;
				int id2 = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id2);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
				if (currentMonth.equalsIgnoreCase("01")) {
					transactionSequenceObj.setTransactionSequenceNumber(1);
					seqNo = 1;
				}
				hbt.update(transactionSequenceObj);
			}
		}else{


			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MasMedicalExamination");
			tsObj.setTransactionPrefix("MED");
			tsObj.setTransactionSequenceName("SerialNo");
			tsObj.setTransactionSequenceNumber(1);
			//tsObj.setCreatedby("admin");
			MasHospital hospital = new MasHospital();
			hospital.setId((Integer)mapForDS.get("hospitalId"));
			tsObj.setHospital(hospital);
			tsObj.setStatus("y");
			hbt.save(tsObj);
			
		
		
		}
		}
		if(familyHistoryArray!=null)
        {	
			 List<MasMedicalExamFamilyHis> masMedicalExamFamilyHisList=session.createCriteria(MasMedicalExamFamilyHis.class)
             .add(Restrictions.eq("Hin.Id",hinId )).list();
             if(masMedicalExamFamilyHisList.size()>0)
             {	
          	   for(MasMedicalExamFamilyHis masExamFamilyHis:masMedicalExamFamilyHisList)
                 {
              	   hbt.delete(masExamFamilyHis);
                 }
             } 
            Patient patientObj=(Patient)session.load(Patient.class, hinId);
          for(String familyHistoryId:familyHistoryArray)
          {
     	    int familyHisId=Integer.parseInt(familyHistoryId);
     	    MasMedicalExamFamilyHis masMedicalExamFamilyHis=new MasMedicalExamFamilyHis();
     	    PatientFamilyHistory patientFamilyHistory=new PatientFamilyHistory();
     	    patientFamilyHistory.setId(familyHisId);
     	    masMedicalExamFamilyHis.setPatientFamilyHistory(patientFamilyHistory);
     	    masMedicalExamFamilyHis.setMasMedicalExamReport(masMedicalExaminationReportOnEntry);
     	   masMedicalExamFamilyHis.setHin(patientObj);
     	    hbt.save(masMedicalExamFamilyHis);
         }
        } 
		
		Visit visitObj =new Visit();
		if(mapForDS.get("visit") !=null){
			visitObj=(Visit)mapForDS.get("visit");
		}
		Patient hin = (Patient)hbt.load(Patient.class, hinId);
		int currentVisitNo = hin.getCurrentVisitNo()+1;
		visitObj.setVisitNo(currentVisitNo);
		hbt.save(visitObj);
		hin.setCurrentVisitNo(currentVisitNo);
		hbt.update(hin);
		tx.commit();
		
		
		
		
			}
	} catch (Exception e) {
		if (tx != null)
			tx.rollback();
		e.printStackTrace();

	  } finally {
		// --------Session Closing----------
	//	session.close();
	  }
		map.put("successfullyAdded",successfullyAdded);
		return map;

	}
	//----------------------------------------------------
	public Boolean saveInvestigationResult(Map mapForDS)
	{
		boolean saveinvestigation = false;
		int patientInvestigationHeaderId=0;
		int dgOrderhdId=0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<String> chargeCodeIdList = (List) mapForDS.get("chargeCodeIdList");
		List<String> investigationReferToMHList=(List)mapForDS.get("investigationReferToMHList");
		List<String> investResultList=(List)mapForDS.get("investResultList");
		String data=(String)mapForDS.get("data");
		Session session = (Session) getSession();
		int masExamId=(Integer)mapForDS.get("medExamId");
		try
		{
			// if(data != null) commented by vinay
		if(true)
		{
			List<MasMedicalExamInvestResult> masMedicalExamInvestResultList=session.createCriteria(MasMedicalExamInvestResult.class)
			                          .add(Restrictions.eq("MasMedicalExaminationReportOnEntry.Id", masExamId)).list();
			if(masMedicalExamInvestResultList.size()>0)
			{
				for(MasMedicalExamInvestResult masMedicalExam:masMedicalExamInvestResultList)
				{
					session.delete(masMedicalExam);
				}
			}
			if(chargeCodeIdList.size()>0)
			{
				for(int i=0;i<chargeCodeIdList.size();i++)
				{
					MasMedicalExamInvestResult masMedicalExamInvestResult=new MasMedicalExamInvestResult();
					masMedicalExamInvestResult.setReferToMH(investigationReferToMHList.get(i));
					masMedicalExamInvestResult.setResult(investResultList.get(i));
					DgMasInvestigation dgMasInvestigation=new DgMasInvestigation();
					dgMasInvestigation.setId(Integer.parseInt(chargeCodeIdList.get(i)));
					masMedicalExamInvestResult.setDgMasInvestigation(dgMasInvestigation);
					MasMedicalExaminationReportOnEntry masMedicalExamReportEntry=new MasMedicalExaminationReportOnEntry();
					masMedicalExamReportEntry.setId(masExamId);
					masMedicalExamInvestResult.setMasMedicalExaminationReportOnEntry(masMedicalExamReportEntry);
					hbt.saveOrUpdate(masMedicalExamInvestResult);
					
				}
				saveinvestigation=true;
			}
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return saveinvestigation;
	}
	//----------------------------------------------------
	
	public Boolean saveInvestigationAdd(Map mapForDS)
	{
		boolean saveinvestigation = false;
		int patientInvestigationHeaderId=0;
		int dgOrderhdId=0;
		int hinId = (Integer) mapForDS.get("hinId");
		int departmentId = (Integer) mapForDS.get("deptId");
		int visitId = (Integer) mapForDS.get("visitId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		String orderSeqNo =(String)mapForDS.get("orderSeqNo");
	    patientInvestigationHeaderId = (Integer) mapForDS.get("patientInvestigationHeaderId");
	    dgOrderhdId = (Integer) mapForDS.get("dgOrderhdId");
		List<String> chargeCodeIdList = (List) mapForDS.get("chargeCodeIdList");
		List<String> investigationReferToMHList=(List)mapForDS.get("investigationReferToMHList");
		List<Integer> patientInvestigationdetailsIdList = (List) mapForDS.get("patientInvestigationdetailsIdList");
		List<Integer> dgOrderdtIdList = (List) mapForDS.get("dgOrderdtIdList");
		//List<Integer> patientInvestigationdetailsIdList = new ArrayList<Integer>();
		String investigationDataStatus=(String)mapForDS.get("investigationDataStatus");
		String clinicalNotes1 = (String) mapForDS.get("clinicalNotes1");
		String userName = (String) mapForDS.get("userName");
		int empId = (Integer) mapForDS.get("empId");
		int userId = (Integer) mapForDS.get("empId");
		String lastChangedBy = (String) mapForDS.get("lastChangedBy");
		Date lastChangedDate = (Date) mapForDS.get("lastChangedDate");
		String lastChangedTime = (String) mapForDS.get("lastChangedTime");
		departmentId=117; 
		String deleatedValue=(String) mapForDS.get("deleatedValue");
		String deleatedorderid=(String) mapForDS.get("deleatedorderid");
		Boolean data=false; 
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		if(patientInvestigationdetailsIdList.size()>0 && patientInvestigationdetailsIdList.size()==chargeCodeIdList.size()&&data==false)
		{
			saveinvestigation=true;
		}else if ( chargeCodeIdList.size() > 0) 
		{
			MasDepartment masDepartment = new MasDepartment();
			MasHospital masHospital = new MasHospital();
			Patient patient = new Patient();
			MasEmployee masEmployee2 = new MasEmployee();

			PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
		
			DgOrderhd dgOrderhd = new DgOrderhd();
			if(patientInvestigationdetailsIdList.size()>0)
			{
				if(patientInvestigationHeaderId != 0){
					patientInvestigationHeader.setId(patientInvestigationHeaderId);
				}
				if(dgOrderhdId != 0){
				 dgOrderhd.setId(dgOrderhdId);
				}
		    }
			patient.setId(hinId);
			patientInvestigationHeader.setHin(patient);

			masDepartment.setId(departmentId);
			patientInvestigationHeader.setDepartment(masDepartment);
			Visit visit = new Visit();
			visit.setId(visitId);
			patientInvestigationHeader.setVisit(visit);
			
			masHospital.setId(hospitalId);
			patientInvestigationHeader.setHospital(masHospital);
			patientInvestigationHeader.setStatus("p");
			patientInvestigationHeader
					.setInvestigationDate(new Date());
			//String time=new Date().getTime();
			patientInvestigationHeader.setInvestigationTime(lastChangedTime);
			patientInvestigationHeader.setClinicalNotes(clinicalNotes1);
			hbt.saveOrUpdate(patientInvestigationHeader);

			dgOrderhd.setOrderDate(new Date());
			dgOrderhd.setOrderTime(lastChangedTime);
			masHospital.setId(hospitalId);
			dgOrderhd.setHospital(masHospital);
			patient.setId(hinId);
			dgOrderhd.setHin(patient);
			masDepartment.setId(departmentId);
			dgOrderhd.setDepartment(masDepartment);
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
			dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
			hbt.saveOrUpdate(dgOrderhd);
			int length=1;
			for (int i = 0; i < chargeCodeIdList.size(); i++) {
				PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
				
				
				DgOrderdt dgOrderdt = new DgOrderdt();
				if(patientInvestigationdetailsIdList.size()>0 &&length!=patientInvestigationdetailsIdList.size())
				{
					++length;
					patientInvestigationDetails.setId(patientInvestigationdetailsIdList.get(i));
					if(dgOrderdtIdList.get(i)>0){
						dgOrderdt.setId(dgOrderdtIdList.get(i));
					}
			    }
				MasChargeCode masChargeCode = new MasChargeCode();
				masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
				patientInvestigationDetails.setChargeCode(masChargeCode);
				patientInvestigationDetails.setReferToMh(investigationReferToMHList.get(i));
				
				patientInvestigationDetails.setInvestigationHeader(patientInvestigationHeader);
				hbt.saveOrUpdate(patientInvestigationDetails);
				
				dgOrderdt.setOrderhd(dgOrderhd);
				masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
				dgOrderdt.setChargeCode(masChargeCode);
				dgOrderdt.setCreatedby(userName);
				dgOrderdt.setCreatedon(new Date());
				dgOrderdt.setInvestigationToMH(investigationReferToMHList.get(i));
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
				dgOrderdt.setInvestigation(new DgMasInvestigation(Integer.parseInt(chargeCodeIdList.get(i))));
				hbt.saveOrUpdate(dgOrderdt);
				saveinvestigation=true;
				}
			}
		return saveinvestigation;
	}
	//----------------------------------------------------
	public Boolean saveInvestigation(Map<String,Object> mapForDS)
	{
		boolean saveinvestigation = false;
		int patientInvestigationHeaderId=0;
		int dgOrderhdId=0;
		int hinId = (Integer) mapForDS.get("hinId");
		int departmentId = (Integer) mapForDS.get("deptId");
		int visitId = (Integer) mapForDS.get("visitId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
	    patientInvestigationHeaderId = (Integer) mapForDS.get("patientInvestigationHeaderId");
	    dgOrderhdId = (Integer) mapForDS.get("dgOrderhdId");
		List<String> chargeCodeIdList = (List) mapForDS.get("chargeCodeIdList");
		List<String> investigationReferToMHList=(List)mapForDS.get("investigationReferToMHList");
		List<Integer> patientInvestigationdetailsIdList = (List) mapForDS.get("patientInvestigationdetailsIdList");
		List<Integer> dgOrderdtIdList = (List) mapForDS.get("dgOrderdtIdList");
		//List<Integer> patientInvestigationdetailsIdList = new ArrayList<Integer>();
		String investigationDataStatus=(String)mapForDS.get("investigationDataStatus");
		String clinicalNotes1 = (String) mapForDS.get("clinicalNotes1");
		String userName = (String) mapForDS.get("userName");
		int empId = (Integer) mapForDS.get("empId");
		int userId = (Integer) mapForDS.get("empId");
		String lastChangedBy = (String) mapForDS.get("lastChangedBy");
		Date lastChangedDate = (Date) mapForDS.get("lastChangedDate");
		String lastChangedTime = (String) mapForDS.get("lastChangedTime");
		departmentId=117; 
		String deleatedValue=(String) mapForDS.get("deleatedValue");
		String deleatedorderid=(String) mapForDS.get("deleatedorderid");
		Boolean data=false; 
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
	   try
	   {
		if(investigationDataStatus.equalsIgnoreCase("yes"))
		{
			List<PatientInvestigationDetails> patientInvestDetailsList  = session.createCriteria(PatientInvestigationDetails.class).add(Restrictions.eq("InvestigationHeader.Id", patientInvestigationHeaderId)).list();
			List<String> addChargeCodeIdList=new ArrayList<String>();
			addChargeCodeIdList.addAll(chargeCodeIdList);
			List<String> investigationReferToMHNewList=new ArrayList<String>();
			investigationReferToMHNewList.addAll(investigationReferToMHList);
			List<DgOrderhd> dgOrderhdList=session.createCriteria(DgOrderhd.class).add(Restrictions.eq("InvestigationRequestionNo.Id", patientInvestigationHeaderId)).list();
			if(dgOrderhdList.size()>0)
			{
				DgOrderhd dgOrderhd=dgOrderhdList.get(0);
				List<DgOrderdt> dgOrderdtFirstList=session.createCriteria(DgOrderdt.class)
				.add(Restrictions.eq("Orderhd.Id", dgOrderhd.getId())).list();
				List<String> removeChargeCodeId=new ArrayList<String>();
				for(DgOrderdt dgOrderdt:dgOrderdtFirstList) 
                {
					removeChargeCodeId.add(""+dgOrderdt.getChargeCode().getId());
                }
				if(dgOrderdtFirstList.size()>0)
				{
					int a=0;
					int[] arr=new int[15];
					for(String chargeCodeIdString:chargeCodeIdList)
					{
						int chargeCodeId=Integer.parseInt(chargeCodeIdString);
						arr[a]=chargeCodeId;
						int count=0;
						for(int j=0;j<=a;j++)
						{
							if(chargeCodeId==arr[j])
							{
								count++;
							}
						}
						if(count<2)
						{	
						 for(DgOrderdt dgOrderdt:dgOrderdtFirstList)
						  {
							if(chargeCodeId==dgOrderdt.getChargeCode().getId())
							{
							  int indexPos=addChargeCodeIdList.indexOf(""+chargeCodeId);
							  if(indexPos>=0)
							  {	
								int rChargeCodeId=Integer.parseInt(addChargeCodeIdList.get(indexPos));
								 if(chargeCodeId==rChargeCodeId)
								 {	
									
								  addChargeCodeIdList.remove(indexPos);
								  investigationReferToMHNewList.remove(indexPos);
								  removeChargeCodeId.remove(""+chargeCodeId);
								  }
								}
							}
						  }
						}
						a++;
						
					}
					List<Integer> deleteChargeCodeId=new ArrayList<Integer>();
					List<DgOrderdt> dgOrderdtList=session.createCriteria(DgOrderdt.class)
					.add(Restrictions.eq("Orderhd.Id", dgOrderhd.getId())).add(Restrictions.eq("OrderStatus", "P")).list();
				    for(DgOrderdt dgOrderdt:dgOrderdtList)
				    {
				    	for(String chargeCodeIdStr:removeChargeCodeId)
				    	{
				    		int chargeCodeId=Integer.parseInt(chargeCodeIdStr);
				    		if(chargeCodeId==dgOrderdt.getChargeCode().getId())
				    		{
				    			hbt.delete(dgOrderdt);
				    			deleteChargeCodeId.add(chargeCodeId);
				    		}
				    	}
				    }
				    	
					for(PatientInvestigationDetails patientInvestDetails:patientInvestDetailsList)
					{
						for(Integer chargeCodeId:deleteChargeCodeId)
				    	{
				    		if(chargeCodeId.equals(patientInvestDetails.getChargeCode().getId()))
				    		{
				    			hbt.delete(patientInvestDetails);
				    			
				    		}
				    	}
					}
					int i=0;
					DgOrderhd dgOrderhdObj=(DgOrderhd)session.get(DgOrderhd.class, dgOrderhdId);
					
					for(String chargeCodeIdString:addChargeCodeIdList)
					{
						PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
						patientInvestigationHeader.setId(patientInvestigationHeaderId);
						PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
						patientInvestigationDetails.setInvestigationHeader(patientInvestigationHeader);
						
						DgOrderdt dgOrderdt = new DgOrderdt();
						
						MasChargeCode masChargeCode = new MasChargeCode();
						masChargeCode.setId(Integer.parseInt(chargeCodeIdString));
						patientInvestigationDetails.setChargeCode(masChargeCode);
						patientInvestigationDetails.setReferToMh(investigationReferToMHList.get(i));
						hbt.saveOrUpdate(patientInvestigationDetails);
						dgOrderdt.setOrderhd(dgOrderhdObj);
						masChargeCode.setId(Integer.parseInt(chargeCodeIdString));
						dgOrderdt.setChargeCode(masChargeCode);
						dgOrderdt.setCreatedby(userName);
						dgOrderdt.setCreatedon(new Date());
						dgOrderdt.setInvestigationToMH(investigationReferToMHNewList.get(i));
						dgOrderdt.setLastChgBy(userId);
						dgOrderdt.setLastChgDate(new Date());
						dgOrderdt.setLastChgTime(lastChangedTime);
						Map masChargeMap = getMasChargeCodeFromChargeId(Integer.parseInt(chargeCodeIdString));
						MasChargeCode masChargeCodeObj = (MasChargeCode) masChargeMap.get("masChargeCode");
						int mainChargeId = masChargeCodeObj.getMainChargecode().getId();
						int subChargeId = masChargeCodeObj.getSubChargecode().getId();
						if (masChargeCodeObj.getMainChargecode().getMainChargecodeCode().equalsIgnoreCase("Lab"))
						{
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
						dgOrderdt.setInvestigation(new DgMasInvestigation(Integer.parseInt(chargeCodeIdString)));
						hbt.saveOrUpdate(dgOrderdt);
						
						saveinvestigation=true;
					
					    i++;
					}	
					if(saveinvestigation)
					{	
					 if(dgOrderhdObj!=null)
					 {	
					   if(dgOrderhdObj.getOrderStatus().equalsIgnoreCase("A"))
					   {
						  dgOrderhdObj.setOrderStatus("P");
						  hbt.update(dgOrderhdObj);
						  
					    }
					  }
					}
					//	List<DgOrderdt> dgOrderdtSampleColList=session.createCriteria(DgOrderdt.class)
				//	.add(Restrictions.eq("Orderhd.Id", dgOrderhd.getId())).add(Restrictions.eq("OrderStatus", "C")).list();
				
				}
				
		  	}
		}
	   }catch (Exception he)
	   {
		   he.printStackTrace();
    	}	
		  /*	
			List<PatientInvestigationDetails> patientInvestDetailsList  = session.createCriteria(PatientInvestigationDetails.class).add(Restrictions.eq("InvestigationHeader.Id", patientInvestigationHeaderId)).list();
			if(patientInvestDetailsList.size()>0)
			{
				hbt.deleteAll(patientInvestDetailsList);
			}
			List<DgOrderdt> dgOrderdtList=session.createCriteria(DgOrderdt.class).add(Restrictions.eq("Orderhd.Id", dgOrderhdId)).list();
			if(dgOrderdtList.size()>0)
			{
				 hbt.deleteAll(dgOrderdtList);
			}	
			//-------------------------------------------
						for (int i = 0; i < chargeCodeIdList.size(); i++) 
						{
							PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader();
							patientInvestigationHeader.setId(patientInvestigationHeaderId);
							PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
							patientInvestigationDetails.setInvestigationHeader(patientInvestigationHeader);
							
							DgOrderhd dgOrderhd=new DgOrderhd();
							dgOrderhd.setId(dgOrderhdId);
							DgOrderdt dgOrderdt = new DgOrderdt();
							
							MasChargeCode masChargeCode = new MasChargeCode();
							masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
							patientInvestigationDetails.setChargeCode(masChargeCode);
							hbt.saveOrUpdate(patientInvestigationDetails);
							dgOrderdt.setOrderhd(dgOrderhd);
							masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
							dgOrderdt.setChargeCode(masChargeCode);
							dgOrderdt.setCreatedby(userName);
							dgOrderdt.setCreatedon(new Date());
							dgOrderdt.setInvestigationToMH(investigationReferToMHList.get(i));
							dgOrderdt.setLastChgBy(userId);
							dgOrderdt.setLastChgDate(new Date());
							dgOrderdt.setLastChgTime(lastChangedTime);
							Map masChargeMap = getMasChargeCodeFromChargeId(Integer
									.parseInt(chargeCodeIdList.get(i)));
							MasChargeCode masChargeCodeObj = (MasChargeCode) masChargeMap
									.get("masChargeCode");
							int mainChargeId = masChargeCodeObj.getMainChargecode()
									.getId();
							int subChargeId = masChargeCodeObj.getSubChargecode()
									.getId();
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
							dgOrderdt.setInvestigation(new DgMasInvestigation(Integer.parseInt(chargeCodeIdList.get(i))));
							hbt.saveOrUpdate(dgOrderdt);
							saveinvestigation=true;
							}
						*/
			 return true;
	}
	public String generateOrderNumber(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = "";

		Session session = (Session) getSession();
		String orderSeqNo = "";
		date = (String) utilMap.get("currentDate");
		String currentyear = "";
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String lastOrderNo = "";
		String lastOrderYear = "";
		int seqNo = 1;
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
       /*
		orderNoList = session.createCriteria(DgOrderhd.class).list();
		for (DgOrderhd dgOrderhd : orderNoList) {
			lastOrderNo = dgOrderhd.getOrderNo();
		}
		StringTokenizer str = new StringTokenizer(lastOrderNo, "/");
		while (str.hasMoreTokens()) {

			lastOrderYear = str.nextToken();

		}
		*/
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
			//for (TransactionSequence transactionSequence : orderSeqNoList) {
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

	@SuppressWarnings("unchecked")
	@Override
	public Map showAnnualMedExamJsp(Map<String, Object> mapds)
	{
		List<Visit> visit = null;
		List<MasServiceType> serviceTypeList = null;
        List<MasState> stateList = null;
        List<MasMaritalStatus> maritalStatusList = null;
        List<PatientFamilyHistory> patientFamilyHistoryList=null;  
        List<Visit> patientFamHistoryList=null;  
        List<MasMedicalExamFamilyHis> masMedicalExamFamilyHisList=null;
        Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int medExamId = (Integer)mapds.get("medExamId");
		int visitId=(Integer)mapds.get("visitId");
		int deptId=(Integer)mapds.get("deptId");
		int hospitalId = (Integer)mapds.get("hospitalId");
		String medExamType = (String)mapds.get("medExamType");
		String dentalFlag = "";
		if(medExamType.equals("Annual Medical Exam(AFMSF-3B)") || medExamType.equals("Prior To Proceedings Abroad Med. Exam(AFMSF-3B)")||medExamType.equals("High Altitude Med. Exam(AFMSF-3B)")){
			dentalFlag = "MedExam3B";
		}
		else if(medExamType.equals("Med. Exam On Release/Discharge(AFMSF-18)")){
			dentalFlag = "MedExam18";
		}
		
        HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		//visit =hbt.find("from Visit as v where v.Id='"+visitId+"'");
		visit=session.createCriteria(Visit.class).add(Restrictions.eq("Id", visitId)).list();
	//	patientFamHistoryList =hbt.find("from Visit as v where v.Id='"+visitId+"'");
		patientFamHistoryList=session.createCriteria(Visit.class).add(Restrictions.eq("Id", visitId)).list();
	     List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
         templateList = session.createCriteria(OpdTemplate.class)
        		 .createAlias("Department", "dept").add(Restrictions.eq("dept.Id",deptId))
        		 .createAlias("Hospital", "hospital").add(Restrictions.eq("hospital.Id",hospitalId))
        		 .add(Restrictions.eq("Status", "y")).list();
      // serviceTypeList = hbt.find("from MasServiceType mst where mst.Status='y'");
		 // stateList = hbt.find("from MasState ms where ms.Status='y'");
		 // maritalStatusList = hbt.find("from MasMaritalStatus mms where mms.Status='y'");
         serviceTypeList=session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).list();
         stateList=session.createCriteria(MasState.class).add(Restrictions.eq("Status", "y")).list();
         maritalStatusList=session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status", "y")).list();
		 
		  patientFamilyHistoryList=session.createCriteria(PatientFamilyHistory.class).add(Restrictions.eq("Status", "y")).list();
          Visit visitdata=null;
		  List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		  PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
		  int medExamId1=0;
		  if(visit!=null&&visit.size()>0)
		  {
			  visitdata= visit.get(0);
		  }
		  if(medExamId!=0)
		  {
		  medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.idEq(medExamId)).add(Restrictions.eq("Status", "p").ignoreCase()).list();
		     medExamId1=medExamId;
		
		  }else
		  {
		  medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("Visit.Id",visitId)).add(Restrictions.eq("Status", "p").ignoreCase()).list();	  
		  if(medExamList.size()>0)
		   {
			    medExamId1=medExamList.get(0).getId();
			
		   }
		  
		  }
		  List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		  /*patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
			.createCriteria(PatientInvestigationHeader.class)
			.createAlias("Visit", "v").add(
					Restrictions.eq("v.Id", visitId))
			.createAlias("Hin", "p").add(
					Restrictions.eq("p.Id",visitdata.getHin().getId()))
			.list();*/
		  
		  patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
			.createCriteria(PatientInvestigationHeader.class)
			.createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId))
					.addOrder(Order.desc("Id")).list();
			if (patientInvestigationHeaderList != null && patientInvestigationHeaderList.size() > 0) {
				patientInvestigationHeader = patientInvestigationHeaderList.get(0);
				map.put("patientInvestigationHeader",patientInvestigationHeader);

			}
			
			
		  if (patientInvestigationHeaderList != null && patientInvestigationHeaderList.size() > 0) {
				patientInvestigationHeader = patientInvestigationHeaderList.get(0);
				map.put("patientInvestigationHeader",patientInvestigationHeader);
				List<PatientInvestigationDetails> patientInvestigationDetailsList=session.createCriteria(PatientInvestigationDetails.class)
				.add(Restrictions.eq("InvestigationHeader.Id",patientInvestigationHeader.getId() )).addOrder(Order.asc("ReferToMh")).addOrder(Order.asc("ChargeCode.Id")).list();
                map.put("patientInvestigationDetailsList",patientInvestigationDetailsList);
                
			}
         
        
          List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
          employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				map.put("employeeList", employeeList);
			}
			List<MasRank> masRankList = null;
			masRankList= session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
			//masRankList = hbt.find("from MasRank as rank where rank.Status='y'  order by rank.RankName ");
			  List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
	          dgOrderhdList = (List<DgOrderhd>) session
				.createCriteria(DgOrderhd.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
			      
	        DgOrderhd dgOrderhd =null;
	        if (dgOrderhdList != null && dgOrderhdList.size() > 0) {
	        	dgOrderhd = dgOrderhdList.get(0);
	        	
				map.put("dgOrderhd",dgOrderhd);
				  List<DgOrderdt> dgOrderdtList=session.createCriteria(DgOrderdt.class).add(Restrictions.eq("Orderhd.Id", dgOrderhd.getId()))
		         	.addOrder(Order.asc("LastChgDate")).addOrder(Order.asc("LastChgTime")).list();
				   map.put("dgOrderdtList", dgOrderdtList);
			}
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			resultList = session.createCriteria(DgResultEntryHeader.class)
			.createAlias("SampleCollectionHeader", "smColl").createAlias("smColl.Order", "order")
			.createAlias("order.Visit", "vst").add(Restrictions.eq("vst.Id", visitId)).add(Restrictions.eq("ResultStatus", "A"))
				.addOrder(Order.asc("DgMasInvestigation.Id")).list();
		//	.addOrder(Order.asc("LastChgdDate")).addOrder(Order.asc("LastChgdTime")).list();
           if (resultList != null || resultList.size() > 0) {
        	map.put("resultList", resultList);
            }		   
           List<Category> categoryList = new ArrayList<Category>();
           categoryList = getHibernateTemplate().find("from jkt.hms.masters.business.Category ");
           List<MasMedicalExamReportDt> masMedicalExamReportDtList=session.createCriteria(MasMedicalExamReportDt.class)
           .createAlias("MasMedicalExamReport", "masMedicalExamReport")
          .add(Restrictions.eq("masMedicalExamReport.Id", medExamId1))
           .add(Restrictions.eq("masMedicalExamReport.Status", "p").ignoreCase()).list();
           if(visitdata!= null)
           {
           masMedicalExamFamilyHisList=session.createCriteria(MasMedicalExamFamilyHis.class)
                                .add(Restrictions.eq("Hin.Id", visitdata.getHin().getId())).list();
           }
           List<MasEmployee>doctorList = new ArrayList<MasEmployee>();
          doctorList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("EmpCategory",
					"empCat").add(Restrictions.eq("empCat.EmpCategoryCode", "01")).add(Restrictions.eq("Hospital.Id", hospitalId))
					.addOrder(Order.asc("FirstName")).list();
          
          /**
           * Getting data for dental from opd_patient_details
           * Code By Ritu
           * Date 03.12.2012
           */
          List<Visit> dentalVisitList = new ArrayList<Visit>();
          dentalVisitList = session.createCriteria(Visit.class).add(Restrictions.eq("Hin.Id", visitdata.getHin().getId())).add(Restrictions.eq("DentalFlag", dentalFlag)).addOrder(Order.desc("Id")).setMaxResults(1).list();
          if(dentalVisitList.size() > 0){
        	  List<OpdPatientDetails> opdDentalDetailsList = new ArrayList<OpdPatientDetails>();
        	  opdDentalDetailsList = session.createCriteria(OpdPatientDetails.class).add(Restrictions.eq("Visit.Id", dentalVisitList.get(0).getId())).list();
        	  map.put("opdDentalDetailsList", opdDentalDetailsList);
          }
          /**
           * End
           */
           
          map.put("doctorList", doctorList);
           map.put("patientFamHistoryList", patientFamHistoryList);
           map.put("categoryList", categoryList);
           map.put("masMedicalExamReportDtList", masMedicalExamReportDtList);
		  map.put("medExamList", medExamList);
		  map.put("templateList", templateList);
		  map.put("serviceTypeList", serviceTypeList);
		  map.put("masMedicalExamFamilyHisList",masMedicalExamFamilyHisList);
		  map.put("patientFamilyHistoryList", patientFamilyHistoryList);
		  map.put("stateList", stateList);
		  map.put("masRankList", masRankList);
		  map.put("maritalStatusList", maritalStatusList);
		  map.put("visit", visit);
			return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showMedicalOfficerAppointment(Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		int hospitalId = 0;
		int empId = 0;
		if(mapForDS.get("hospitalId") != null){
			hospitalId = (Integer)mapForDS.get("hospitalId");
		}
		if(mapForDS.get("empId") != null){
			empId = (Integer)mapForDS.get("empId");
		}
		String[] statusArr = { "s","m"};
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	    Criteria crit = null;
		//rankList = getHibernateTemplate().find("from jkt.hms.masters.business.MasRank ");
	    rankList= session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
		if (empId != 0 ) {
			patientDetailList = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
			.add(Restrictions.in("Status", statusArr)).add(Restrictions.eq("medicalType", "MedicalExam"))
			.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
				.createAlias("Visit", "visit").createAlias("visit.Doctor", "doctor").add(Restrictions.eq("doctor.Id", empId))
			.addOrder(Order.desc("Id")).list();
			map.put("empId", empId);
		} else {
			patientDetailList = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
			.add(Restrictions.in("Status", statusArr)).add(Restrictions.eq("medicalType", "MedicalExam"))
			.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
			.addOrder(Order.desc("Id")).list();
		}
		  doctorList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
			.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).list();
        map.put("patientDetailList", patientDetailList);		
		map.put("rankList", rankList);
		map.put("doctorList", doctorList);
		return map;
		}
	
	public Map<String, Object> searchMedicalExamMedicalOfficer(
			Map<String, Object> mapForDs) {
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String serviceNo = "";
		Date fromDate = new Date();
		Date toDate = new Date();
	    String patientFName = "";
	    Criteria crit = null;
	    int rankId=0;
            if (mapForDs.get("rankId") != null) {
            	rankId = (Integer) mapForDs.get("rankId");
		   }
		   if (mapForDs.get("toDate") != null) {
		  	toDate = (Date) mapForDs.get("toDate");
		}
           if (mapForDs.get("serviceNo") != null) {
			serviceNo = (String) mapForDs.get("serviceNo");
	    	}
           if (mapForDs.get("patientFName") != null) {
		   	patientFName = (String) mapForDs.get("patientFName");
		    }
           int hospitalId = 0;
           if(mapForDs.get("hospitalId") !=null){
        	   hospitalId = (Integer)mapForDs.get("hospitalId");
           }
          try {
		
				crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.createAlias("MasRank", "r").add(Restrictions.eq("r.Id", rankId)).add(Restrictions.eq("Status", "v"));
			
              
               patientDetailList = crit.list();
		       } catch (HibernateException e) {
			   e.printStackTrace();
		       }
              map.put("patientDetailList", patientDetailList);
              return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map showMedicalOfficerMedExamJsp(Box box)
	{
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		    Map<String, Object> map = new HashMap<String, Object>();
		    List<Visit> visit = null;
		    List<DgResultEntryHeader> resultList = null;
		    List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		    int visitId = box.getInt("visitId");
		    int medExamId = box.getInt("medExamId");
		    int deptId = box.getInt("deptId");
		    int empId = box.getInt("empId");
		    String accessjsp = box.getString("accessjsp");
		    String search = box.getString("search");
	        Session session = (Session) getSession();
	        List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	        List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
			employeeMoList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(empId)).list();
			map.put("employeeMoList", employeeMoList);
		
	        if(search.equalsIgnoreCase("true"))
	       {
	        	medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.idEq(medExamId)).list();	
	       }else if(search.equalsIgnoreCase("false"))
	       {
	    	   medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.idEq(medExamId)).list();
		    }
	        List<MasMedicalExamInvestResult> masMedicalExamInvestResultList=null;
	        List<MasMedicalExamReportDt> masMedicalExamReportDtList=null;
	        List<PatientFamilyHistory> patientFamilyHistoryList=null;  
	        patientFamilyHistoryList=session.createCriteria(PatientFamilyHistory.class).add(Restrictions.eq("Status", "y")).list();
	        MasMedicalExaminationReportOnEntry medMedicalExam=null;
	        if(medExamList.size()>0)
	        {	
	        	medMedicalExam=medExamList.get(0);
	        	masMedicalExamInvestResultList=session.createCriteria(MasMedicalExamInvestResult.class)
	        	                              .add(Restrictions.eq("MasMedicalExaminationReportOnEntry.Id", medMedicalExam.getId())).list();
	        	masMedicalExamReportDtList=session.createCriteria(MasMedicalExamReportDt.class)
                .add(Restrictions.eq("MasMedicalExamReport.Id",medMedicalExam.getId())).list();


	        	List<MasMedicalExamFamilyHis> masMedicalExamFamilyHisList=new ArrayList<MasMedicalExamFamilyHis>();
	        	masMedicalExamFamilyHisList=session.createCriteria(MasMedicalExamFamilyHis.class).createAlias("MasMedicalExamReport", "med").add(Restrictions.eq("med.Id", medMedicalExam.getId())).list();
	        	map.put("masMedicalExamFamilyHisList",masMedicalExamFamilyHisList);
	        } 
	       List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
            //visit =hbt.find("from Visit as v where v.Id='"+visitId+"'");
            visit=session.createCriteria(Visit.class).add(Restrictions.eq("Id",visitId)).list();
	        List<Integer> headerIdsInt = new ArrayList<Integer>();
	    	resultList = session.createCriteria(DgResultEntryHeader.class)
						.createAlias("SampleCollectionHeader", "smColl").createAlias("smColl.Order", "order")
						.createAlias("order.Visit", "vst").add(Restrictions.eq("vst.Id", visitId))
						.add(Restrictions.eq("ResultStatus", "A"))
						.addOrder(Order.asc("DgMasInvestigation.Id")).list();
						//.addOrder(Order.asc("LastChgdDate")).addOrder(Order.asc("LastChgdTime")).list();
	    	employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				map.put("employeeList", employeeList);
			}
			List<MasMaritalStatus> maritalStatusList = null;
          //  maritalStatusList = hbt.find("from MasMaritalStatus mms where mms.Status='y'");
			maritalStatusList=session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("MaritalStatusName")).list();
            List<MasServiceType> serviceTypeList = null;
           // serviceTypeList = hbt.find("from MasServiceType mst where mst.Status='y'");
            serviceTypeList=session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("ServiceTypeName")).list();
            map.put("serviceTypeList", serviceTypeList);
            if (resultList != null || resultList.size() > 0) {
				map.put("resultList", resultList);
			}	


			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				map.put("investigationList", investigationList);
			}
			 List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
			 PatientInvestigationHeader patientInvestigationHeader=null;
			/* commented by Dipali
			 * 
			 * patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
						.createCriteria(PatientInvestigationHeader.class)
						.createAlias("Visit", "v").add(
								Restrictions.eq("v.Id", visitId))
						.createAlias("Hin", "p").add(
								Restrictions.eq("p.Id",visit.get(0).getHin().getId()))
						.list();
				     
			          if (patientInvestigationHeaderList != null && patientInvestigationHeaderList.size() > 0) 
			          {
							patientInvestigationHeader = patientInvestigationHeaderList.get(0);
							List<PatientInvestigationDetails> patientInvestigationDetailsList=session.createCriteria(PatientInvestigationDetails.class)
							.add(Restrictions.eq("InvestigationHeader.Id",patientInvestigationHeader.getId() )).addOrder(Order.asc("ReferToMh")).addOrder(Order.asc("ChargeCode.Id")).list();
							
							map.put("patientInvestigationHeader",patientInvestigationHeader);
							map.put("patientInvestigationDetailsList",patientInvestigationDetailsList);
						}*/
			 //----Added by dipali
			 patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
				.createCriteria(PatientInvestigationHeader.class)
				.createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId))
						.addOrder(Order.desc("Id")).list();
				if (patientInvestigationHeaderList != null && patientInvestigationHeaderList.size() > 0) {
					patientInvestigationHeader = patientInvestigationHeaderList.get(0);
					

				
					List<PatientInvestigationDetails> patientInvestigationDetailsList=session.createCriteria(PatientInvestigationDetails.class)
					.add(Restrictions.eq("InvestigationHeader.Id",patientInvestigationHeader.getId() )).addOrder(Order.asc("ReferToMh")).addOrder(Order.asc("ChargeCode.Id")).list();
					
					map.put("patientInvestigationHeader",patientInvestigationHeader);
					map.put("patientInvestigationDetailsList",patientInvestigationDetailsList);
				
				}
			          List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();         
			          dgOrderhdList = (List<DgOrderhd>) session
			         			.createCriteria(DgOrderhd.class)
			         			.createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
			          DgOrderhd dgOrderhd =null;
			          if (dgOrderhdList != null && dgOrderhdList.size() > 0) {
			          	dgOrderhd = dgOrderhdList.get(0);
			          	List<DgOrderdt> dgOrderdtList=session.createCriteria(DgOrderdt.class).add(Restrictions.eq("Orderhd.Id", dgOrderhd.getId()))
			          	.addOrder(Order.asc("LastChgDate")).addOrder(Order.asc("LastChgTime")).list();
			          	map.put("dgOrderdtList",dgOrderdtList);
			          	map.put("dgOrderhd",dgOrderhd);
			  			
			  		}
			       
                 List<Category> categoryList = new ArrayList<Category>();
           	   /*	categoryList = getHibernateTemplate().find("from jkt.hms.masters.business.Category ");*/
                 categoryList=session.createCriteria(Category.class).addOrder(Order.asc("Categories")).list();
                 System.out.println("categoryList="+categoryList.size());
			         map.put("categoryList", categoryList);
                      
            map.put("visit", visit);
            
			map.put("maritalStatusList", maritalStatusList);
	        map.put("medExamList", medExamList);
	        map.put("masMedicalExamInvestResultList",masMedicalExamInvestResultList);
	        map.put("patientFamilyHistoryList", patientFamilyHistoryList);  
	        map.put("masMedicalExamReportDtList",masMedicalExamReportDtList);
            return map;
	}
	@SuppressWarnings("unchecked")
	public List<MasMedicalExaminationReportOnEntry> getExistingMedExamList(
			Box box) {
		List<MasMedicalExaminationReportOnEntry> existingMedExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Session session = (Session)getSession();
		existingMedExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
						.createAlias("Visit", "v").add(Restrictions.eq("v.Id", box.getInt("visitId")))
						.add(Restrictions.eq("Status", "p")).list();
		return existingMedExamList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showMOPrimaryMedExamJsp(Box box)
	{
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		    Map<String, Object> map = new HashMap<String, Object>();
		    List<Visit> visit = null;
		    List<DgOrderhd> resultList = null;
		    Session session = (Session) getSession();
		    List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		    int visitId = box.getInt("visitId");
		    int medExamId = box.getInt("medExamId");
		    int deptId = box.getInt("deptId");
		    int empId = box.getInt("empId");
		    String accessjsp = box.getString("accessjsp");
		    String search = box.getString("search");
		    int	hospitalId = (Integer) box.getInt("hospitalId");
		    List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
			employeeMoList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(empId)).list();
			map.put("employeeMoList", employeeMoList);
		
	     
	        List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	        medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.idEq(medExamId)).list();
		    List<MasMedicalExamInvestResult> masMedicalExamInvestResultList=null;
	        List<MasMedicalExamReportDt> masMedicalExamReportDtList=null;
	        MasMedicalExaminationReportOnEntry medMedicalExam=null;
	        if(medExamList.size()>0)
	        {	
	        	medMedicalExam=medExamList.get(0);
	        	masMedicalExamInvestResultList=session.createCriteria(MasMedicalExamInvestResult.class)
	        	                              .add(Restrictions.eq("MasMedicalExaminationReportOnEntry.Id", medMedicalExam.getId())).list();
	        	masMedicalExamReportDtList=session.createCriteria(MasMedicalExamReportDt.class)
                .add(Restrictions.eq("MasMedicalExamReport.Id",medMedicalExam.getId())).list();


	        } 

	         List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
          //  visit =hbt.find("from Visit as v where v.Id='"+visitId+"'");
            visit=session.createCriteria(Visit.class).add(Restrictions.eq("Id",visitId)).list();
	        List<Integer> headerIdsInt = new ArrayList<Integer>();
	    	resultList = session.createCriteria(DgResultEntryHeader.class)
						.createAlias("SampleCollectionHeader", "smColl").createAlias("smColl.Order", "order")
						.createAlias("order.Visit", "vst").add(Restrictions.eq("vst.Id", visitId))
						.add(Restrictions.eq("ResultStatus", "A")).addOrder(Order.asc("LastChgdDate")).addOrder(Order.asc("LastChgdTime")).list();
	    	employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").add(Restrictions.eq("dept.Id", deptId)).list();
	    	
			if (employeeList.size() > 0) {
				map.put("employeeList", employeeList);
			}
			List<MasMaritalStatus> maritalStatusList = null;
            //maritalStatusList = hbt.find("from MasMaritalStatus mms where mms.Status='y'");
            maritalStatusList=session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("MaritalStatusName")).list();
            List<MasServiceType> serviceTypeList = null;
          //  serviceTypeList = hbt.find("from MasServiceType mst where mst.Status='y'");
            serviceTypeList=session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("ServiceTypeName")).list();
            map.put("serviceTypeList", serviceTypeList);
            if (resultList != null || resultList.size() > 0) {
				map.put("resultList", resultList);
			}	


			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				map.put("investigationList", investigationList);
			}
			 List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>(); 
			 patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
						.createCriteria(PatientInvestigationHeader.class)
						.createAlias("Visit", "v").add(
								Restrictions.eq("v.Id", visitId))
						.createAlias("Hin", "p").add(
								Restrictions.eq("p.Id",visit.get(0).getHin().getId()))
						.list();
				      PatientInvestigationHeader patientInvestigationHeader=null;
			          if (patientInvestigationHeaderList != null && patientInvestigationHeaderList.size() > 0) {
							patientInvestigationHeader = patientInvestigationHeaderList.get(0);
							map.put("patientInvestigationHeader",patientInvestigationHeader);
							List<PatientInvestigationDetails> patientInvestigationDetailsList=session.createCriteria(PatientInvestigationDetails.class)
							.add(Restrictions.eq("InvestigationHeader.Id",patientInvestigationHeader.getId() ))
						.addOrder(Order.asc("ReferToMh")).addOrder(Order.asc("ChargeCode.Id")).list();
							//.addOrder(Order.asc("Id")).list();
		                  map.put("patientInvestigationDetailsList",patientInvestigationDetailsList);

						}
			          List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();         
			          dgOrderhdList = (List<DgOrderhd>) session
			         			.createCriteria(DgOrderhd.class)
			         			.createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
			          DgOrderhd dgOrderhd =null;
			          if (dgOrderhdList != null && dgOrderhdList.size() > 0) {
			          	dgOrderhd = dgOrderhdList.get(0);
			  			map.put("dgOrderhd",dgOrderhd);
			  			List<DgOrderdt> dgOrderdtList=session.createCriteria(DgOrderdt.class).add(Restrictions.eq("Orderhd.Id", dgOrderhd.getId()))
			          	.addOrder(Order.asc("LastChgDate")).addOrder(Order.asc("LastChgTime")).list();
			  			map.put("dgOrderdtList",dgOrderdtList);
			  			
			  		}
			       
                 List<Category> categoryList = new ArrayList<Category>();
           	   //	categoryList = getHibernateTemplate().find("from jkt.hms.masters.business.Category ");
           	 categoryList=session.createCriteria(Category.class).addOrder(Order.asc("Categories")).list();
			         map.put("categoryList", categoryList);
                      
            map.put("visit", visit);
           	map.put("maritalStatusList", maritalStatusList);
	        map.put("medExamList", medExamList);
	        map.put("masMedicalExamInvestResultList",masMedicalExamInvestResultList);
	         map.put("masMedicalExamReportDtList",masMedicalExamReportDtList);
            return map;
            
	}

	@Override
	public Boolean updateMedicalExaminationBoardAnnual(Map<String, Object> mapForDS) {
		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int visitId=(Integer)mapForDS.get("visitId");
		String data=(String)mapForDS.get("data");
		String Labresult=(String)mapForDS.get("Labresult");
		String[] familyHistoryArray=(String[]) mapForDS.get("familyHistoryArray");
		List<Date> giveOnList =(List<Date>) mapForDS.get("giveOnList");
		List<Date> domList = (List<Date>) mapForDS.get("domList");
		List<Date> doeList =(List<Date>) mapForDS.get("doeList");
		List<String> batchNoList = (List<String>) mapForDS.get("batchNoList");
		int hinId=(Integer) mapForDS.get("hinId");
		int hospitalId=(Integer) mapForDS.get("hospitalId");
		int medicalOfficerId =(Integer) mapForDS.get("medicalOfficerId");
		int departmentId =(Integer) mapForDS.get("departmentId");
		MasMedicalExaminationReportOnEntry masMedicalBoardProceedings = new MasMedicalExaminationReportOnEntry();
		if(mapForDS.get("masMedicalBoardProceedings") != null){
			masMedicalBoardProceedings = (MasMedicalExaminationReportOnEntry)mapForDS.get("masMedicalBoardProceedings");
		}
		
		try {
			boolean saveinvestigation = false;
			Session session = (Session) getSession();
           // saveinvestigation=saveInvestigation(mapForDS);
			saveinvestigation = updateInvestigation(mapForDS);
            saveInvestigationResult(mapForDS);
            
            if (saveinvestigation) {
			hbt.update(masMedicalBoardProceedings);
			List<Integer> serialnolist = new ArrayList<Integer>();
			List<String> fromlist = new ArrayList<String>();
			List<String> tolist = new ArrayList<String>();
			List<String> placelist = new ArrayList<String>();
			List<String> pnolist = new ArrayList<String>();
			List<Integer> serviceidlist = new ArrayList<Integer>();
			//List<String> principallist = new ArrayList<String>();
			List<Date> origindatelist = new ArrayList<Date>();
			List<Date> medicalcatdatelist = new ArrayList<Date>();
			List<Date> nextcatdatelist = new ArrayList<Date>();

			int hiddenValue=1;
			int hdbvalue=1;
			serviceidlist = (List) mapForDS.get("serviceidlist");
			 serialnolist = (List) mapForDS.get("serialnolist");
			 fromlist = (List) mapForDS.get("fromlist");
			 tolist = (List) mapForDS.get("tolist");
			 placelist = (List) mapForDS.get("placelist");
			 pnolist = (List) mapForDS.get("pnolist");
			 hdbvalue = (Integer) mapForDS.get("hdbvalue");
			 hiddenValue = (Integer) mapForDS.get("hiddenValue");
			int medExamId = (Integer) mapForDS.get("medExamId");
			//principallist = (List) mapForDS.get("principallist");
			origindatelist = (List) mapForDS.get("origindatelist");
			medicalcatdatelist = (List) mapForDS.get("medicalcatdatelist");
			nextcatdatelist = (List) mapForDS.get("nextcatdatelist");
			
			if(masMedicalBoardProceedings.getMedicalExamType().equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
			{
				List<MasMedicalExaminationDetail> detailList  = session.createCriteria(MasMedicalExaminationDetail.class).add(Restrictions.eq("MasMedicalReport.Id", medExamId)).add(Restrictions.eq("Particular", "detail")).list();
				hbt.deleteAll(detailList);
				 for (int i = 0; i <hdbvalue; i++) {
					 MasMedicalExaminationDetail masmedical=new MasMedicalExaminationDetail();
					 if(serialnolist.size()>0)
					 masmedical.setSerialno(serialnolist.get(i));
					 if(fromlist.size()>0 && fromlist!= null)
					 masmedical.setAddressfrom(HMSUtil.convertStringTypeDateToDateType(fromlist.get(i)));
					 if(tolist.size()>0 && tolist!= null)
					 masmedical.setAddressto(HMSUtil.convertStringTypeDateToDateType(tolist.get(i))); 
					 if(placelist.size()>0 && placelist!= null)
					 masmedical.setPlace(placelist.get(i));
					if(pnolist.size()>0 && pnolist!= null)
					 masmedical.setPno(pnolist.get(i));
					 masmedical.setMasMedicalReport(masMedicalBoardProceedings);
					 //masmedical.setServiceid(serviceidlist.get(i));
					 masmedical.setParticular("detail");
					 //---------commented by anamika
					/* if(principallist.size()>0)
					 masmedical.setPrincipal(principallist.get(i));*/
					 if(origindatelist.size()>0)
					 masmedical.setOrigindate(origindatelist.get(i));
					 if(medicalcatdatelist.size()>0)
					 masmedical.setMedicalcatdate(medicalcatdatelist.get(i));
					 if(nextcatdatelist.size()>0)
					 masmedical.setNextcatdate(nextcatdatelist.get(i));

					 hbt.save(masmedical);
				 }
					                
			}
				 if(masMedicalBoardProceedings.getMedicalExamType().equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
				 	{
					 int hiddenValue1=1;
					 int hdbvalue1=1;
		                List<String> illnesslist = new ArrayList<String>();
				        List<Date> particulardatelist = new ArrayList<Date>();
				        List<Integer> rankidlist = new ArrayList<Integer>();
				        List<String> treatedlist = new ArrayList<String>();
				        List<String> approximatedatelist = new ArrayList<String>();
				        List<Integer> serialnolist1 = new ArrayList<Integer>();
				        List<String> placelist1 = new ArrayList<String>();
				        List<Integer> illnessICDlist = new ArrayList<Integer>();
				        serialnolist1 = (List) mapForDS.get("serialnolist1");
				        illnesslist = (List) mapForDS.get("illnesslist");
				        particulardatelist = (List) mapForDS.get("particulardatelist");
				        rankidlist = (List) mapForDS.get("rankidlist");
				        treatedlist = (List) mapForDS.get("treatedlist");
				        approximatedatelist = (List) mapForDS.get("approximatedatelist");
				        hiddenValue1 = (Integer) mapForDS.get("hiddenValue1");
				        hdbvalue1 = (Integer) mapForDS.get("hdbvalue1");
				        placelist1 = (List) mapForDS.get("placelist1");
				        List<String> approximatedate2list = new ArrayList<String>();
		            	if(mapForDS.get("approximatedate2list")!=null){
		            		approximatedate2list=(List)mapForDS.get("approximatedate2list");
		            	}
		            	if(mapForDS.get("illnessICDlist")!=null){
		            		illnessICDlist=(List)mapForDS.get("illnessICDlist");
		            	}

				 List<MasMedicalExaminationDetail> detailList1  = session.createCriteria(MasMedicalExaminationDetail.class).add(Restrictions.eq("MasMedicalReport.Id", medExamId)).add(Restrictions.eq("Particular", "particular")).list();
					hbt.deleteAll(detailList1);
					 for (int i = 0; i <hdbvalue1; i++) {
						 MasMedicalExaminationDetail masmedical1=new MasMedicalExaminationDetail();
						 if(serialnolist1.size()>0)
						 masmedical1.setSerialNo1(serialnolist1.get(i));
						 if(illnesslist.size()>0)
						 masmedical1.setIllness(illnesslist.get(i));
						 if(rankidlist.size()>0)
						 {
						 MasRank masrank=new MasRank();
						 masrank.setId(rankidlist.get(i));
						 masmedical1.setRankIndividual(masrank);
						 }
						 if(particulardatelist.size()>0)
						 masmedical1.setParticulardate(particulardatelist.get(i));
						 if(approximatedatelist.size()>0)
						 masmedical1.setApproximatedate1(HMSUtil.convertStringTypeDateToDateType(approximatedatelist.get(i)));
						 if(approximatedate2list.get(i)!=null){
							 masmedical1.setApproximatedate2(HMSUtil.convertStringTypeDateToDateType(approximatedate2list.get(i)));
						}
						 if(placelist1.size()>0)
						 masmedical1.setPlace1(placelist1.get(i));
						 if(treatedlist.size()>0)
						 masmedical1.setTreated(treatedlist.get(i));
						 masmedical1.setParticular("particular");
						 masmedical1.setBeforeDisability("n");
						 masmedical1.setMasMedicalReport(masMedicalBoardProceedings);
						 if(illnessICDlist.get(i)>0){
							 /*MasSystemDiagnosis masSystemDiagnosis = new MasSystemDiagnosis();
							masSystemDiagnosis.setId(illnessICDlist.get(i));
							masmedical1.setSystemDiagnosis(masSystemDiagnosis);*/
							 MasIcd masIcd = new MasIcd();
							 masIcd.setId(illnessICDlist.get(i));
							 masmedical1.setMasIcd(masIcd);
						 }
						 hbt.save(masmedical1);
					 }
					 List<Integer> serialnoBeforeList = new ArrayList<Integer>();
	            		List<String> illnessBeforeList = new ArrayList<String>();
	    				
	            		List<Date> particulardateBeforeList = new ArrayList<Date>();
	            		List<String> treatedBeforeList = new ArrayList<String>();
	            		List<String> placeBeforeList = new ArrayList<String>();
	            		List<String> beforeDisabilityBeforeList = new ArrayList<String>();
	            		List<Integer> illnessICDBeforelist = new ArrayList<Integer>();
	            		if(mapForDS.get("illnessICDBeforelist")!=null){
	            			illnessICDBeforelist=(List)mapForDS.get("illnessICDBeforelist");
	            		}
	            		int hdbBefore=0;
	            		hdbBefore = (Integer) mapForDS.get("hdbBefore");
	            		if(mapForDS.get("serialnoBeforeList")!=null){
	            			serialnoBeforeList=(List)mapForDS.get("serialnoBeforeList");
	            		}
	            		if(mapForDS.get("illnessBeforeList")!=null){
	            			illnessBeforeList=(List)mapForDS.get("illnessBeforeList");
	            		}
	            		if(mapForDS.get("placeBeforeList")!=null){
	            			placeBeforeList=(List)mapForDS.get("placeBeforeList");
	            		}
	            		if(mapForDS.get("particulardateBeforeList")!=null){
	            			particulardateBeforeList=(List)mapForDS.get("particulardateBeforeList");
	            		}
	            		if(mapForDS.get("treatedBeforeList")!=null){
	            			treatedBeforeList=(List)mapForDS.get("treatedBeforeList");
	            		}
	            		if(mapForDS.get("beforeDisabilityBeforeList")!=null){
	            			beforeDisabilityBeforeList=(List)mapForDS.get("beforeDisabilityBeforeList");
	            		}
					 for(int i = 0; i < illnessICDBeforelist.size();i++){
	            			int serialNo=0;
	            			if(serialnoBeforeList.get(i)!=null){
	            				serialNo=serialnoBeforeList.get(i);
	            			}
	            			try {
								if(serialNo>0){
									MasMedicalExaminationDetail masmedical2=new MasMedicalExaminationDetail();
									if(serialnoBeforeList.get(i)!=null){
										masmedical2.setSerialno(serialnoBeforeList.get(i));
									}
									if(illnessBeforeList.get(i)!=null){
										masmedical2.setIllness(illnessBeforeList.get(i));
									}
									if(placeBeforeList.get(i)!=null){
										masmedical2.setPlace(placeBeforeList.get(i));
									}
									if(beforeDisabilityBeforeList.get(i)!=null){
										masmedical2.setBeforeDisability(beforeDisabilityBeforeList.get(i));
									}
									if(particulardateBeforeList.get(i)!=null){
										masmedical2.setParticulardate(particulardateBeforeList.get(i));
									}
									if(treatedBeforeList.get(i)!=null){
										masmedical2.setTreated(treatedBeforeList.get(i));
									}
									/*if(illnessICDBeforelist.get(i)>0){
										MasSystemDiagnosis systemDiagnosis = new MasSystemDiagnosis();
										systemDiagnosis.setId(illnessICDBeforelist.get(i));
										masmedical2.setSystemDiagnosis(systemDiagnosis);
									}*/
									if(illnessICDBeforelist.get(i)>0){
										 MasIcd masIcd = new MasIcd();
										 masIcd.setId(illnessICDBeforelist.get(i));
										 masmedical2.setMasIcd(masIcd);
									}
									
									 
									masmedical2.setParticular("particular");
									masmedical2.setMasMedicalReport(masMedicalBoardProceedings);
									session.save(masmedical2);
									//hbt1.refresh(masmedical2);
									//hbt1.flush();
								}
							} catch (Exception e) {
								
								e.printStackTrace();
							}
	            		}

				 	
				 	}
             if(Labresult.equalsIgnoreCase("present") && data!=null)
             {
             Visit visit = (Visit)hbt.load(Visit.class, visitId);
             
             if(medicalOfficerId != 0){
             MasEmployee masEmployee = new MasEmployee();
             masEmployee.setId(medicalOfficerId);
             visit.setDoctor(masEmployee);
             }
             if(departmentId != 0){
             MasDepartment masDepartment = new MasDepartment();
             masDepartment.setId(departmentId);
             visit.setDepartment(masDepartment);
             }
             visit.setMedStatus("f");
             hbt.update(visit);
             }
             successfullyAdded = true;
			}
           if(masMedicalBoardProceedings!=null)
           {	   
             List<MasMedicalExamReportDt> masMedicalExamReportDtList=session.createCriteria(MasMedicalExamReportDt.class)
                                                    .add(Restrictions.eq("MasMedicalExamReport.Id",masMedicalBoardProceedings.getId() )).list();
           for(MasMedicalExamReportDt masMedicalExamReportDt:masMedicalExamReportDtList)
           {
        	   hbt.delete(masMedicalExamReportDt);
           }
             	
           
           }
           
         //----Alcohal update in patient table(By Dipali)
       	String  alcohol="";
       	String otherFamilyHistory="";
       	if(mapForDS.get("alcohol") !=null){
       	alcohol = (String) mapForDS.get("alcohol");
       	Patient patient=(Patient)session.get(Patient.class,hinId);
       	if(mapForDS.get("otherFamilyHistory") !=null){
    		otherFamilyHistory = (String) mapForDS.get("otherFamilyHistory");
    	}
       	if(mapForDS.get("identification1")!=null )
    	{	
    	patient.setSrIdentificationMark1((String)mapForDS.get("identification1"));
    	}
    	if(mapForDS.get("identification2")!=null )
    	{	
        	patient.setSrIdentificationMark2((String)mapForDS.get("identification2"));
    	}
       	
       	patient.setOtherFamilyHistory(otherFamilyHistory);
    		
       	patient.setAlcohol(alcohol);
       	patient.setOtherFamilyHistory(otherFamilyHistory);
		if(mapForDS.get("smokerLess10") !=null){
			patient.setSmokerLess10("y");
		}else{
			patient.setSmokerLess10("n");
		}
		if(mapForDS.get("smokerMore10") !=null){
			patient.setSmokerMore10("y");
		}else{
			patient.setSmokerMore10("n");
		}
       	
       	 hbt.update(patient);
       	}
       	//------------
       	
           if(familyHistoryArray!=null)
           {
        	   List<MasMedicalExamFamilyHis> masMedicalExamFamilyHisList=session.createCriteria(MasMedicalExamFamilyHis.class)
               .add(Restrictions.eq("Hin.Id",masMedicalBoardProceedings.getHin().getId() )).list();
               if(masMedicalExamFamilyHisList.size()>0)
               {	
            	   for(MasMedicalExamFamilyHis masExamFamilyHis:masMedicalExamFamilyHisList)
                   {
                	   hbt.delete(masExamFamilyHis);
                   }
               } 
             for(String familyHistoryId:familyHistoryArray)
             {
        	    int familyHisId=Integer.parseInt(familyHistoryId);
        	    if(familyHisId!=0)
        	    {	
        	    MasMedicalExamFamilyHis masMedicalExamFamilyHis=new MasMedicalExamFamilyHis();
        	    PatientFamilyHistory patientFamilyHistory=new PatientFamilyHistory();
        	    patientFamilyHistory.setId(familyHisId);
        	    masMedicalExamFamilyHis.setPatientFamilyHistory(patientFamilyHistory);
        	    masMedicalExamFamilyHis.setMasMedicalExamReport(masMedicalBoardProceedings);
        	    masMedicalExamFamilyHis.setHin(masMedicalBoardProceedings.getHin());
        	    hbt.save(masMedicalExamFamilyHis);
        	    }
        	   }
           } 
           if(masMedicalBoardProceedings.getAdmissionStatus()!=null)
           {
        	   if(masMedicalBoardProceedings.getAdmissionStatus().equalsIgnoreCase("y"))
        	   {
        		   //----commented by anamika---------------------//
        		 /* Date lastChangedDate=(Date)mapForDS.get("lastChangedDate");
          		 Users user=(Users)mapForDS.get("user");
          		 String lastChangedTime=(String)mapForDS.get("lastChangedTime");
         	  	 Visit visitsave = new Visit();
       			 visitsave=(Visit) hbt.load(Visit.class, masMedicalBoardProceedings.getVisit().getId());
       			 visitsave.setDisposalName("Admit");
       			 hbt.update(visitsave);
       			OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
       			opdPatientDetails.setVisit(visitsave);
    			MasHospital masHospitalObj = new MasHospital();
    			masHospitalObj.setId(hospitalId);
    			opdPatientDetails.setHospital(masHospitalObj);
    			opdPatientDetails.setDisposal("Admit");
    			opdPatientDetails.setEmployee(user.getEmployee());
    			opdPatientDetails.setConsultationTime(lastChangedTime);
    			opdPatientDetails.setConsultationDate(lastChangedDate);
    			opdPatientDetails.setOpdDate(lastChangedDate);
    			opdPatientDetails.setOpdTime(lastChangedTime);
    			//opdPatientDetails.setMhRun("n");
    			hbt.save(opdPatientDetails);*/
        		//------------------------------------   
    			/*     Dinesh Dubey     Status - I  means patient is admitted       */
    			MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry=(MasMedicalExaminationReportOnEntry)session.load(MasMedicalExaminationReportOnEntry.class, masMedicalBoardProceedings.getId());
    			masMedicalExaminationReportOnEntry.setStatus("I");
    			hbt.update(masMedicalExaminationReportOnEntry);
        	   }
           }
           
			} catch (Exception e) {
			
			e.printStackTrace();
			e.getMessage();
			e.getCause();
		}
		return successfullyAdded;
	}

	
	@Override
	public MasMedicalExaminationReportOnEntry loadMedicalExamObj(int medExamId) {
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		MasMedicalExaminationReportOnEntry masMedExam = new MasMedicalExaminationReportOnEntry();
		try {
			
			masMedExam = (MasMedicalExaminationReportOnEntry)hbt.load(MasMedicalExaminationReportOnEntry.class, medExamId);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return masMedExam;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> pendingClwatingList(Map<String, Object> mapofds) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int commandId = 0;
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	    Criteria crit = null;
	    int hospitalId = 0;
        if(mapofds.get("hospitalId") !=null){
        	hospitalId = (Integer)mapofds.get("hospitalId");
        }

	    if(mapofds.get("commandId") != null){
	    	commandId = (Integer)mapofds.get("commandId");
	    }
	    crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("medicalType", "MedicalExam"))
	            .createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
	            .addOrder(Order.desc("Id"));
	    patientDetailList = crit.list();
        map.put("patientDetailList", patientDetailList);		
		

		return map;
	}

	@Override
	public Map<String, Object> validateMedExam(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int medExamId = box.getInt("medExamId");
		//String FM_DM=box.getString("FM_DM");
		String SIGNED_BY=box.getString("SIGNED_BY");
		String APPROVED_BY=box.getString("APPROVED_BY");
		String SEND_TO=box.getString("SEND_TO");
		String MED_CAT_REC=box.getString("MED_CAT_REC");
		String MEDICIN_REMARKS=box.getString("MEDICIN_REMARKS");
		String MissTeeth=box.getString("MissTeeth");
		String UnserTeeth=box.getString("UnserTeeth");
		 String finalObservation=box.getString("FINAL_OBSERVATION");
		 String Investigated = box.getString("Investigated");
		 
		 String userSrNo = box.getString("userSrNo");
		 
		boolean successfullyAdded= false;
		HibernateTemplate hbt = getHibernateTemplate();
		Transaction tx = null;
		String dataMessage=null;
		org.hibernate.Session session = getSession();
		try {
		
       // tx = session.beginTransaction();
		hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
			MasMedicalExaminationReportOnEntry masMedExam = new MasMedicalExaminationReportOnEntry();
			masMedExam = loadMedicalExamObj(medExamId);
			if(box.getString("flag").equals("command")){
				masMedExam.setStatus("c");
				masMedExam.setCommandRemarks(box.getString("cmMdRemarks"));
				Users cmUser = new Users();
				cmUser.setId(box.getInt("userId"));
				masMedExam.setCmUser(cmUser);
				masMedExam.setDateOfCompletion(new Date());
			}else {
				if(masMedExam.getMedicalExamType().equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
				{
					masMedExam.setStatus("o");
					masMedExam.setDateOfCompletion(new Date());
					masMedExam.setDateValidated(new Date());
				}else{
				masMedExam.setStatus("v");}
				//masMedExam.setMdRemarks(box.getString("cmMdRemarks"));
				Users mdUser = new Users();
				mdUser.setId(box.getInt("userId"));
				masMedExam.setMdUser(mdUser);
				masMedExam.setDateValidated(new Date());
				masMedExam.setInvestigated(Investigated);
				//masMedExam.setFmdm(FM_DM);
				masMedExam.setSignedBy(SIGNED_BY);
				masMedExam.setApprovedBy(APPROVED_BY);
				masMedExam.setSendTo(SEND_TO);
				masMedExam.setMedCatRec(MED_CAT_REC);
				masMedExam.setRemarks(MEDICIN_REMARKS);
				masMedExam.setSourceOfData("MEDNET");
				masMedExam.setUnserTeeth(UnserTeeth);
				masMedExam.setMissTeeth(MissTeeth);
				masMedExam.setFinalObservation(finalObservation);
				//---------code by anamika--------------
				masMedExam.setDateOfCompletion(new Date());
				//------------------------------------------
				/*
				 *Code for MO Medical Board 
				 *Code By Mukesh 
				 *Date 10-02-2012
				 */
				int member1=0;
				int member2=0;
				int president=0;
				String medRemarks="";
				String medDate="";
				
				member1=box.getInt("member1");
				member2=box.getInt("member2");
				president=box.getInt("president");
				medRemarks=box.getString("medRemarks");
				medDate=box.getString("medDate");
				String digitalIndividuals="";
				digitalIndividuals=box.getString("digitalIndividuals");
				masMedExam.setIndividualDigitalSign(digitalIndividuals);
				if(member1>0){
					MasEmployee masEmployee=new MasEmployee();
					masEmployee.setId(member1);
					masMedExam.setMedDetailMember1(masEmployee);
				}
				if(member2>0){
					MasEmployee masEmployee=new MasEmployee();
					masEmployee.setId(member2);
					masMedExam.setMedDetailMember2(masEmployee);
				}
				if(president>0){
					MasEmployee masEmployee=new MasEmployee();
					masEmployee.setId(president);
					masMedExam.setMedDetailPresident(masEmployee);
				}
				if(medRemarks!=null){
					masMedExam.setMedRemarks(medRemarks);
				}
				if(medDate!=null && medDate!=""){
					masMedExam.setMedDetailDate(HMSUtil.convertStringTypeDateToDateType(medDate));
				}
			}
			 //----------------If final observation is unfit then create visit for medical board form-15-----------------
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentTimeWithoutSecond();
			String time = (String) utilMap.get("currentTime");
	       if(finalObservation.equals("UnFit")){
	        	   MasMedicalExaminationReportOnEntry masExamEntry=(MasMedicalExaminationReportOnEntry)session.load(MasMedicalExaminationReportOnEntry.class, masMedExam.getId());
	   			List<Visit> visitList=getVisitNo(masExamEntry.getHin().getHinNo());
	   			int visitNo=1;
	   			if(visitList!=null && visitList.size()>0)
	   			{
	   			 Visit visit=visitList.get(0);
	   			 visitNo=visit.getVisitNo()+1;
	   			}
	   			Visit visit = new Visit();
	   			visit.setHin(masExamEntry.getHin());
	   			visit.setVisitNo(visitNo);
	   			visit.setTokenNo(0);
	   			visit.setHospital(masExamEntry.getHospital());
	   			visit.setAge(masExamEntry.getHin().getAge());
	   			visit.setStatus("y");
	   			visit.setAppointmentType("D");
	   			visit.setMedExamType("Initial Medical Board AFMSF 15");
	   			visit.setVisitStatus("c");
	   			visit.setMedStatus("w");
	   			visit.setReportingFor("MedBoard");
	   			visit.setTokenDoctor("0#0");
	   			Users user = new Users();
	   			user.setId(box.getInt("userId"));
	   			visit.setAddEditBy(user);
	   			visit.setVisitDate(new Date());
	   			visit.setVisitTime(time);
	   			visit.setAddEditDate(new Date());
	   			visit.setAddEditTime(time);
	   			visit.setPriority(3);
	   			visit.setTokenStatus("n");
	   			hbt.save(visit);
	          }
	       
	       
		//------------------------------------------------------------------	
			if(masMedExam.getMedicalType().equalsIgnoreCase("MedicalExam"))
			{
				hbt.update(masMedExam);
				Patient patient = (Patient)hbt.load(Patient.class, masMedExam.getHin().getId());
				if(box.getInt("medCat") != 0){
					Category category2=new Category();
					category2.setCategoryid(box.getInt("medCat"));
					patient.setCategory(category2);
				}
				if(!box.getString(REPORTED_DATE).equals(""))
					patient.setMedCatDate(HMSUtil.convertStringTypeDateToDateType(box.getString(REPORTED_DATE)));
				
				hbt.update(patient);
				
			}
			if(masMedExam.getMedicalType().equalsIgnoreCase("MedicalBoard"))
			{
				if(masMedExam.getMedicalType().equalsIgnoreCase("Initial Medical Board AFMSF 15")||masMedExam.getMedicalType().equalsIgnoreCase("Medical Board Review AFMSF 15"))
				{
				if(masMedExam.getSpecialistopinion()==null || !masMedExam.getSpecialistopinion().equalsIgnoreCase("YES"))
				{
					dataMessage="You Can Not Validate Before Special Opinion";
				}else{
					hbt.update(masMedExam);
				}
				}
				
				if(masMedExam.getMedicalType().equalsIgnoreCase("Medical Board Rel/Invalidment AFMSF 16"))
				{
				if(masMedExam.getCommandingOfficer()==null || !masMedExam.getCommandingOfficer().equalsIgnoreCase("YES"))
				{
					dataMessage="You Can Not Validate Before Commanding Officer validate";
				}else{
					hbt.update(masMedExam);
				}
				}
			}
			//------Medical Board Detail For MO-15 By Dipali
			BigDecimal temperature = new BigDecimal(0);
			if(!box.getString("temperature").equals("")){
			 temperature=new BigDecimal(box.getString("temperature"));
			}
			String bp1=box.getString("bp1");
			String generalPhysicalExam=box.getString("generalPhysicalExam");
			String cardiovascularSystem=box.getString("cardiovascularSystem");
			String respairatorySystem=box.getString("respairatorySystem");
			String gastroIntestinalSystem=box.getString("gastroIntestinalSystem");
			String breakDown=box.getString("breakDown");
			String centralNervousSystem=box.getString("centralNervousSystem");
			String localExamination=box.getString("localExamination");
			String remarksClinical=box.getString("remarksClinical");
			String rr=box.getString("rr");
			int medCatNowRecommend=box.getInt("medCatNowRecommend");
			String shapeFactorRec=box.getString("shapeFactorRec");
			String finalMedCat=box.getString("finalMedCat");
			String placeNextCat=box.getString("placeNextCat");
			String dateNextBoard = "";
			if(!box.getString("dateNextBoard").equals("") ){
			 dateNextBoard=box.getString("dateNextBoard");
			}
			String opinionMedicalBoard=box.getString("opinionMedicalBoard");
			String dissentNotes=box.getString("dissentNotes");
			String medComposite=box.getString("medComposite");
			String instructions=box.getString("instructions");
			String empRestrictions=box.getString("empRestrictions");
			BigDecimal medboardDuration = new BigDecimal(0);
			if(!box.getString("medboardDuration").equals("")){
			 medboardDuration=new BigDecimal(box.getString("medboardDuration"));
			}
			String presentConditions=box.getString("presentConditions");
			String medication=box.getString("medication");
			int category=box.getInt("category");
			//int referredToMhClinical=box.getInt("referredToMhClinical");
			String referredToMhClinical=box.getString("referredToMhClinical");
			int opdDeptClinical=box.getInt("opdDeptClinical");
			
			masMedExam.setMedboardDuration(medboardDuration);
			masMedExam.setPlaceNextCatBoard(placeNextCat);
			masMedExam.setOpinion(opinionMedicalBoard);
			masMedExam.setDissentNote(dissentNotes);
			masMedExam.setMedComposite(medComposite);
			masMedExam.setEmpabiltyRestric(empRestrictions);
			masMedExam.setMedInstructions(instructions);
			if(medCatNowRecommend>0){
				Category category2=new Category();
				category2.setCategoryid(medCatNowRecommend);
				masMedExam.setMedicalCategoryRecomended(category2);
			}
			if(box.getString("finalMedCat") !=null){
				masMedExam.setRecMedPeriod(finalMedCat);
				}if(box.getString("shapeFactorRec") !=null){
				masMedExam.setShapeFactorRec(shapeFactorRec);}
			if(!dateNextBoard.equals(""))
				masMedExam.setNextBoardDate(HMSUtil.convertStringTypeDateToDateType(dateNextBoard));
			
			
			//---update med category,shapeFactor,duration--By dipali (19-mar-2013)---
			Patient patientUpdate = (Patient)hbt.load(Patient.class, masMedExam.getHin().getId());
			if(medCatNowRecommend>0){
				Category category2=new Category();
				category2.setCategoryid(medCatNowRecommend);
				patientUpdate.setCategory(category2);
			}
			if(box.getString("finalMedCat") !=null){
				patientUpdate.setMedCatPeriod(box.getString("finalMedCat"));
				}
				
			if(!dateNextBoard.equals(""))
				patientUpdate.setMedCatDate(HMSUtil.convertStringTypeDateToDateType(dateNextBoard));
			
			hbt.update(patientUpdate);
			//-----------------------------------------
			masMedExam.setPresentCondition(presentConditions);
			masMedExam.setMedication(medication);
			masMedExam.setTemprature(temperature);
			masMedExam.setBp(bp1);
			if(box.getString("generalPhysicalExam") !=null){
			masMedExam.setGeneralPhysicalExam(generalPhysicalExam);
			}if(box.getString("cardiovascularSystem") !=null){
			masMedExam.setCardiovascularSystem(cardiovascularSystem);}
			if(box.getString("respairatorySystem") !=null){
			masMedExam.setRespiratorySystem(respairatorySystem);}
			if(box.getString("gastroIntestinalSystem") !=null){
			masMedExam.setGastroIntestinalSystem(gastroIntestinalSystem);}
			if(box.getString("breakDown") !=null){
			masMedExam.setCentralNervousSystemMMHG(breakDown);}
			if(box.getString("centralNervousSystem") !=null){
			masMedExam.setCentralNervousSystem(centralNervousSystem);}
			if(box.getString("localExamination") !=null){
			masMedExam.setLocalExamination(localExamination);}
			if(box.getString("remarksClinical") !=null){
			masMedExam.setRemarksClinical(remarksClinical);}
			if(box.getString("rr") !=null){
			masMedExam.setRrClinical(rr);}
			/*if(referredToMhClinical>0){
			MasHospital masHospital=new MasHospital();
			masHospital.setId(referredToMhClinical);
			masMedExam.setClinicalReferMh(masHospital);
			}*/
			if(box.getString("referredToMhClinical") !=null){
			masMedExam.setClinicalReferMh(referredToMhClinical);}
			if(opdDeptClinical>0){
			MasDepartment masDepartment=new MasDepartment();
			masDepartment.setId(opdDeptClinical);
			masMedExam.setClinicalOpdDept(masDepartment);
			}
			hbt.update(masMedExam);
			//-------
			//if(dataMessage== null)
			/**
			 * Write 3B(Annual Medical Exam) Form Data to HIC DB 
			 * Written by Ritu on 29 June 2011 
			 * 
			 */
			String medicalExamType  = "";
			if(box.get("medicalExamType")!=null){
				medicalExamType = (String)box.get("medicalExamType");
			}
			if(medicalExamType.equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)")){
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
				if(hicDbConfigure.equalsIgnoreCase("yes")){
					try{
						Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
						conn = DriverManager.getConnection(hicDB, hicUser, hicPwd);
						String ageWithUnit = "";
						String age= "";
						if(masMedExam.getVisit().getAge()!=null){
							ageWithUnit = masMedExam.getVisit().getAge();
							age = ageWithUnit.substring(0,ageWithUnit.indexOf(" "));

						}

						String procSql = "{ call SMC_HIC_INSERT_FORM3B_INFO(" +
						"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

						SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
						CallableStatement csstmt = conn.prepareCall(procSql);
						csstmt.setString(1, (masMedExam.getServiceNo()!=null ? masMedExam.getServiceNo() :""))	;
						csstmt.setString(2,(masMedExam.getServiceType()!=null ? masMedExam.getServiceType().getServiceTypeName() :""))	;
						csstmt.setString(3, age);
						csstmt.setString(4, (masMedExam.getTypeofcommision()!=null ? masMedExam.getTypeofcommision() : ""));
						csstmt.setString(5, (masMedExam.getTotalService()!= null ? masMedExam.getTotalService() : ""));
						csstmt.setString(6, (masMedExam.getPastmedicalhistory()!= null ? masMedExam.getPastmedicalhistory():"" ));
						csstmt.setString(7, (masMedExam.getPresentmedicalhistory()!= null ? masMedExam.getPresentmedicalhistory() :""));
						csstmt.setString(8, (masMedExam.getDateOfReporting()!= null ? sdf.format(masMedExam.getDateOfReporting()) :""));
						csstmt.setString(9, (masMedExam.getLastame()!= null ? masMedExam.getLastame() : ""));
						csstmt.setString(10, "");  //LAST_AME_DATE
						csstmt.setString(11, (masMedExam.getTotalTeeth() != null ? masMedExam.getTotalTeeth():""));
						csstmt.setString(12, (masMedExam.getTotalDefectiveTeeth()!=null ? masMedExam.getTotalDefectiveTeeth() :"" ));
						csstmt.setString(13, (masMedExam.getTotalNoDentalPoint()!= null ? masMedExam.getTotalNoDentalPoint() :"" ));
						csstmt.setString(14, (masMedExam.getConditionOfGums()!= null ? masMedExam.getConditionOfGums() :"" ));
						csstmt.setString(15, (masMedExam.getRemarksTeath()!= null ? masMedExam.getRemarksTeath() : ""));
						csstmt.setString(16, (""));
						csstmt.setString(17, (""));
						csstmt.setString(18, (""));
						csstmt.setString(19, (""));
						csstmt.setString(20, (""));
						csstmt.setString(21, (""));
						csstmt.setString(22, (""));
						csstmt.setString(23, (""));
						csstmt.setString(24, (""));
						csstmt.setString(25, (""));
						csstmt.setString(26, (""));
						csstmt.setString(27, (""));
						csstmt.setString(28, (""));
						csstmt.setString(29, (""));
						csstmt.setString(30, (""));
						csstmt.setString(31, (""));
						csstmt.setString(32, (""));
						csstmt.setString(33, (""));
						csstmt.setString(34, (""));
						csstmt.setString(35, (""));
						csstmt.setString(36, (""));
						csstmt.setString(37, (""));
						csstmt.setString(38, (masMedExam.getHeight() != null ? masMedExam.getHeight().toString():""));
						csstmt.setString(39, (masMedExam.getActualweight()!= null ? masMedExam.getActualweight() : "" ));
						csstmt.setString(40, (masMedExam.getIdealweight()!= null ? masMedExam.getIdealweight() : "" ));
						csstmt.setString(41, (masMedExam.getOverweight() != null ? masMedExam.getOverweight() : "" ));
						csstmt.setString(42, " ");															// OVER_UNDER_WEIGHT_PERCENT
						csstmt.setString(43, (masMedExam.getBhi()!=null ?  masMedExam.getBhi() : ""));
						csstmt.setString(44, (masMedExam.getWaist() != null ? masMedExam.getWaist():""));
						csstmt.setString(45, "");												// HIP
						csstmt.setString(46, "");																// WHR
						csstmt.setString(47, (masMedExam.getChestfullexpansion()!= null? masMedExam.getChestfullexpansion() : "" ));		//CHEST_EXPIRATION
						csstmt.setString(48, (masMedExam.getRangeofexpansion()!=null ? masMedExam.getRangeofexpansion() : ""));
						csstmt.setString(49,(masMedExam.getPulseRates()!= null ? masMedExam.getPulseRates() : ""));
						csstmt.setString(50, " ");															// PERIPHERAL_PULSATIONS
						csstmt.setString(51, (masMedExam.getHeartSize()!= null ? masMedExam.getHeartSize() :""));
						csstmt.setString(52, (masMedExam.getSounds()!= null ? masMedExam.getSounds() :""));
						csstmt.setString(53, (masMedExam.getRhythm()!=null ? masMedExam.getRhythm() : "" ));
						csstmt.setString(54, (masMedExam.getBp() !=null ? masMedExam.getBp() :""));
						csstmt.setString(55, "");																// BREATH_SOUNDS
						csstmt.setString(56,  "");																// TRACHEA
						csstmt.setString(57,  "");																// VH_VR
						csstmt.setString(58,  "");																// RHONCHI
						csstmt.setString(59,  (masMedExam.getRespiratorySystem() !=null ? masMedExam.getRespiratorySystem() :""));																// RS_REMARKS
						csstmt.setString(60, "");																// LIVER_PAL_STAT
						csstmt.setString(61,  "");															// SPLEEN_PAL_STAT
						csstmt.setString(62,  (masMedExam.getLiver() !=null ? masMedExam.getLiver() :""));// LIVER_PALPABLE
						csstmt.setString(63, (masMedExam.getSpleen() !=null ? masMedExam.getSpleen() :""));		// SPLEEN_PALPABLE
						csstmt.setString(64,  (masMedExam.getHigherMentalFunction()!=null ? masMedExam.getHigherMentalFunction() : ""));
						csstmt.setString(65,  (masMedExam.getSpeech()!=null ? masMedExam.getSpeech() : ""));
						csstmt.setString(66, (masMedExam.getReflexes()!=null ? masMedExam.getReflexes() :""));
						csstmt.setString(67, (masMedExam.getTremors()!=null ? masMedExam.getTremors() :""));
						csstmt.setString(68, (masMedExam.getSelfBalancingTest()!=null ? masMedExam.getSelfBalancingTest() : ""));
						csstmt.setString(69, (masMedExam.getLocomoterSystem()!=null ? masMedExam.getLocomoterSystem() :"" ));
						csstmt.setString(70,  (masMedExam.getSpine()!=null ? masMedExam.getSpine() :""));
						csstmt.setString(71, (masMedExam.getHerniaMusic()!=null ? masMedExam.getHerniaMusic() :""));
						csstmt.setString(72,  (masMedExam.getHydrocele()!=null ? masMedExam.getHydrocele() : ""));
						csstmt.setString(73,  (masMedExam.getHemorrhoids()!=null ? masMedExam.getHemorrhoids() :""));
						csstmt.setString(74,  (masMedExam.getBreasts()!=null ? masMedExam.getBreasts() :""));
						csstmt.setString(75,  "");															// HINFO_REMARKS
						csstmt.setString(76,  (masMedExam.getWthoutGlassesRDistant()!=null ? masMedExam.getWthoutGlassesRDistant():""));
						csstmt.setString(77,  (masMedExam.getWithoutGlassesLDistant()!=null ?masMedExam.getWithoutGlassesLDistant() :""));
						csstmt.setString(78, (masMedExam.getWithGlassesRDistant()!=null ? masMedExam.getWithGlassesRDistant() :""));
						csstmt.setString(79,  (masMedExam.getWithGlassesLDistant()!=null  ? masMedExam.getWithGlassesLDistant() :"" ));
						csstmt.setString(80, (masMedExam.getWithoutGlassesRNearvision()!=null ? masMedExam.getWithoutGlassesRNearvision() : "" ));
						csstmt.setString(81, (masMedExam.getWithoutGlassesLNearvision()!=null ? masMedExam.getWithoutGlassesLNearvision() :""));
						csstmt.setString(82,  (masMedExam.getWithGlassesRNearvision()!=null ? masMedExam.getWithGlassesRNearvision() :""));
						csstmt.setString(83, (masMedExam.getWithGlassesLNearvision()!= null ? masMedExam.getWithGlassesLNearvision() :""));
						csstmt.setString(84,  "");																// VISION_REMARKS
						csstmt.setString(85, "");																// COLOUR_PERCEPTION
						csstmt.setString(86, (masMedExam.getEarHearingRfw()!=null ? masMedExam.getEarHearingRfw().toString() :"" ));
						csstmt.setString(87, (masMedExam.getHearingRcv()!=null ? masMedExam.getHearingRcv().toString() :""));			// HEARING_R_EAR_CV
						csstmt.setString(88, (masMedExam.getEarHearingBothFw()!=null ? masMedExam.getEarHearingBothFw().toString() : "" ));
						csstmt.setString(89,  (masMedExam.getTympanicR()!=null ? masMedExam.getTympanicR() :""));	 // HEARING_R_EAR_TM_INTACT
						csstmt.setString(90, "");																// HEARING_R_EAR_TM_MOBILITY
						csstmt.setString(91, (masMedExam.getNoseThroatSinuses()!=null ? masMedExam.getNoseThroatSinuses() :"") );
						csstmt.setString(92, (masMedExam.getRemarksEar()!=null ? masMedExam.getRemarksEar() :""));
						csstmt.setString(93, (masMedExam.getEarHearingLfw()!=null ? masMedExam.getEarHearingLfw().toString() :""));
						csstmt.setString(94,  (masMedExam.getHearingLcv()!=null ? masMedExam.getHearingLcv().toString() :""));
						csstmt.setString(95,  (masMedExam.getHearingBothCv()!=null ? masMedExam.getHearingBothCv().toString() :""));
						csstmt.setString(96, (masMedExam.getTympanicL()!=null ? masMedExam.getTympanicL() :""));// HEARING_L_EAR_TM_INTACT
						csstmt.setString(97, " ");															// HEARING_L_EAR_TM_MOBILITY
						csstmt.setString(98,  (masMedExam.getAudiometryRecord()!=null ? masMedExam.getAudiometryRecord() :""));	// HEARING_EAR_AUDIOMETRY
						csstmt.setString(99,  " ");																// IMMUNISATION_STATUS
						csstmt.setString(100, (""));
						csstmt.setString(101, (masMedExam.getDrinker()!=null ? masMedExam.getDrinker() : ""));
						String hyperlypidemia ="No";
						if(masMedExam.getFmdm()!= null){
							if(masMedExam.getFmdm().equalsIgnoreCase("Hyperlypidemia")){
								hyperlypidemia = "Yes";
							}
						}
						String malignancy="No";
						if(masMedExam.getFmdm()!= null){
							if(masMedExam.getFmdm().equalsIgnoreCase("Malignancy")){
								malignancy = "Yes";
							}
						}
						String arthritis="No";
						if(masMedExam.getFmdm()!= null){
							if(masMedExam.getFmdm().equalsIgnoreCase("Arthritis")){
								arthritis = "Yes";
							}
						}
						csstmt.setString(102, hyperlypidemia);																// HYPERLIPIDEMIA
						csstmt.setString(103, arthritis);																// ARTHRITIS
						csstmt.setString(104, "");																// FAMILY_HO_EARLY_IHD
						csstmt.setString(105, "");																// FAMILY_HO_DM
						csstmt.setString(106, malignancy);															// MALIGNANCY
						csstmt.setString(107, (""));																//HYPERTENSION
						csstmt.setString(108, (masMedExam.getAllergies()!=null?masMedExam.getAllergies():""));																// UNKNOWN_ALLERGY
						csstmt.setString(109, "");																// LMC_OPINION
						csstmt.setString(110, (masMedExam.getMenstrualHistory()!=null ? masMedExam.getMenstrualHistory() : ""));
						csstmt.setString(111, (masMedExam.getLmp()!=null ? sdf.format(masMedExam.getLmp()):"" ));
						csstmt.setString(112, (masMedExam.getNoOfPregnancies()!=null ? masMedExam.getNoOfPregnancies().toString():""));
						csstmt.setString(113, (masMedExam.getNoOfAbortions()!=null ? masMedExam.getNoOfAbortions().toString() : ""));
						csstmt.setString(114, (masMedExam.getNoOfChildren()!=null ? masMedExam.getNoOfChildren().toString() :""));
						csstmt.setString(115, (masMedExam.getLastConfinementDate()!=null ? sdf.format(masMedExam.getLastConfinementDate()) :""));	// LAST_DT_OF_CONFINEMENT
						csstmt.setString(116, (masMedExam.getVaginalDischarge()!=null ? masMedExam.getVaginalDischarge() :""));
						csstmt.setString(117, (masMedExam.getProlapse() !=null ? masMedExam.getProlapse():""));
						csstmt.setString(118, (masMedExam.getUsgAbdomen()!=null ? masMedExam.getUsgAbdomen() :""));
						csstmt.setString(119, (masMedExam.getMedicalBoardFindings()!=null ? masMedExam.getMedicalBoardFindings() :"")); // FINDINGS_MEDBOARD
						csstmt.setString(120, (masMedExam.getFoundFitInCategory()!=null ? masMedExam.getFoundFitInCategory() :""));	// FIT_CATEGORY
						csstmt.setString(121, (masMedExam.getMoUser()!=null ? masMedExam.getMoUser().getEmployee().getFirstName() :""));
						csstmt.setString(122, (masMedExam.getDateMedicalBoardExam()!=null ? sdf.format(masMedExam.getDateMedicalBoardExam()):""));
						csstmt.setString(123, (masMedExam.getMoUser()!= null ?masMedExam.getMoUser().getEmployee().getRank().getRankName() :""));
						csstmt.setString(124, (masMedExam.getMoUser() !=null ? masMedExam.getMoUser().getEmployee().getUnit().getUnitName():""));
						csstmt.setString(125, (masMedExam.getMoUser()!=null ? masMedExam.getMoUser().getEmployee().getDesignation():""));
						csstmt.setString(126, (masMedExam.getApprovedBy()!=null ? masMedExam.getApprovedBy():""));																// APPROVER_NAME
						csstmt.setString(127, (masMedExam.getDateValidated()!=null ? sdf.format(masMedExam.getDateValidated()):""));																// APPROVER_DATE
						csstmt.setString(128, "");																// APPROVER_RANK
						csstmt.setString(129, "");																// APPROVER_UNIT
						csstmt.setString(130, "");																// APPROVER_DESIGNATION
						csstmt.setInt(131, 0);																// APPROVER_SYSID
						csstmt.setInt(132, Integer.parseInt(userSrNo));															// CREATEDBY
						csstmt.setString(133, "REGISTERED");															// REQUEST_STATUS
						csstmt.setInt(134, masMedExam.getId());															// SMCREGISTRATIONSYSID
						csstmt.registerOutParameter(135,Types.INTEGER);											// stat
						csstmt.setString(136, (masMedExam.getUnit()!=null ? masMedExam.getUnit().getUnitName() :"" ));
						csstmt.setString(137, (masMedExam.getRank()!=null ? masMedExam.getRank().getRankName() :"" ));
						csstmt.setString(138, (masMedExam.getTrade()!=null ? masMedExam.getTrade().getTradeName() :""));
						csstmt.setString(139, (masMedExam.getMaritalStatus()!=null ? masMedExam.getMaritalStatus().getMaritalStatusName():"none"));
						csstmt.setString(140, (masMedExam.getHin().getBloodGroup()!=null ? masMedExam.getHin().getBloodGroup().getBloodGroupName() :""));
						csstmt.setString(141, "");																// MISSINGUPPERRIGHT
						csstmt.setString(142, "");																// MISSINGUPPERLEFT
						csstmt.setString(143, "");																// MISSINGLOWERRIGHT
						csstmt.setString(144, "");																// MISSINGLOWERLEFT
						csstmt.setString(145, "");																// UNSAVEUPPERRIGHT
						csstmt.setString(146, "");																// UNSAVEUPPERLEFT
						csstmt.setString(147, "");																// UNSAVELOWERRIGHT
						csstmt.setString(148, "");																// UNSAVELOWERLEFT
						csstmt.setString(149, "");																// DONAME
						csstmt.setString(150, "");																// DEDATE
						csstmt.setString(151, (masMedExam.getDataOfNurveHic()!=null ? masMedExam.getDataOfNurveHic() :""));

						csstmt.registerOutParameter(152,OracleTypes.CURSOR);

						csstmt.execute();


						csstmt.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}else if(medicalExamType.equalsIgnoreCase("Initial Medical Board AFMSF 15")){
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
				if(hicDbConfigure.equalsIgnoreCase("yes")){
					try{

						Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
						conn = DriverManager.getConnection(hicDB, hicUser, hicPwd);

						String ageWithUnit = "";
						String age= "";
						if(masMedExam.getVisit().getAge()!=null){
							ageWithUnit = masMedExam.getVisit().getAge();
							age = ageWithUnit.substring(0,ageWithUnit.indexOf(" "));

						}
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
						String procSql = "{ call SMC_HIC_INSERT_FORM15 (" +
						"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
						CallableStatement csstmt = conn.prepareCall(procSql);
						csstmt.setString(1, masMedExam.getServiceNo())	;
						csstmt.setString(2,(masMedExam.getServiceType()!=null ? masMedExam.getServiceType().getServiceTypeName():"")); 
						csstmt.setString(3, age);
						csstmt.setString(4, (masMedExam.getHeight() != null ? masMedExam.getHeight().toString():""));
						csstmt.setString(5, (masMedExam.getActualweight()!= null ? masMedExam.getActualweight() : "" ));
						csstmt.setString(6, (masMedExam.getCeaseduty()!=null ? sdf.format(new Date()) :"" ));
						csstmt.setString(7, (masMedExam.getPastmedicalhistory()!= null ? masMedExam.getPastmedicalhistory():"" ));
						csstmt.setString(8, (masMedExam.getPresentMedicalCategory()!= null ? masMedExam.getPresentMedicalCategory().getCategories() :""));
						csstmt.setString(9, (masMedExam.getOpiniondate()!= null ? sdf.format(masMedExam.getOpiniondate()) : ""));
						csstmt.setString(10, (""));
						csstmt.setString(11, (masMedExam.getCaseSheet()!= null ? masMedExam.getCaseSheet() : ""));
						csstmt.setString(12, (masMedExam.getCaseSheet()!= null ? masMedExam.getCaseSheet() : ""));
						csstmt.setString(13,  (masMedExam.getDisability()!= null ? masMedExam.getDisability() :""));
						csstmt.setString(14,  (masMedExam.getDisabilityAttribute()!= null ? masMedExam.getDisabilityAttribute() :""));
						csstmt.setString(15,  (masMedExam.getAggravatedService()!= null ? masMedExam.getAggravatedService() :""));
						csstmt.setString(16,  (masMedExam.getAggravatedServiceDesc()!= null ? masMedExam.getAggravatedServiceDesc() :""));
						csstmt.setString(17,  (masMedExam.getPresentMedicalCategory()!= null ? masMedExam.getPresentMedicalCategory().getCategories() :""));
						csstmt.setString(18, (masMedExam.getCategorydate()!= null ? sdf.format(masMedExam.getCategorydate()) :""));
						csstmt.setString(19, (masMedExam.getCategoryplace()!= null ? masMedExam.getCategoryplace() :""));
						csstmt.setString(20, (masMedExam.getPastDisability()!= null ? masMedExam.getPastDisability().getDisability() :""));
						csstmt.setString(21, (masMedExam.getPresentDisability()!= null ? masMedExam.getPresentDisability().getDisability() :""));
						csstmt.setString(22,  (masMedExam.getReasopnsvariation()!=null ? masMedExam.getReasopnsvariation() :"" ));
						csstmt.setString(23, (masMedExam.getRestrictionemployment()!=null ? masMedExam.getRestrictionemployment() :"" ));
						csstmt.setString(24, (masMedExam.getInstructionByPresident()!=null ? masMedExam.getInstructionByPresident() :"" ));
						csstmt.setString(25, (""));
						csstmt.setString(26, (""));
						csstmt.setString(27, (""));
						csstmt.setString(28, sdf.format(new Date()));
						csstmt.setString(29, sdf.format(new Date()));
						csstmt.setString(30, (masMedExam.getMoUser().getEmployee() != null ? masMedExam.getMoUser().getEmployee().getFirstName() :""));
						csstmt.setString(31, (masMedExam.getMoUser().getEmployee() != null ? masMedExam.getMoUser().getEmployee().getFirstName() :""));
						csstmt.setString(32,  sdf.format(new Date()));//approval Date
						csstmt.setString(33, (masMedExam.getMoUser()!= null ?masMedExam.getMoUser().getEmployee().getRank().getRankName() :""));
						csstmt.setString(34, (masMedExam.getMoUser() !=null ? masMedExam.getMoUser().getEmployee().getUnit().getUnitName():""));
						csstmt.setString(35, (masMedExam.getMoUser()!=null ? masMedExam.getMoUser().getEmployee().getDesignation():""));
						csstmt.setString(36, (masMedExam.getMoUser()!=null ? masMedExam.getMoUser().getEmployee().getFirstName() :""));	
						csstmt.setString(37, (""));//approval place
						csstmt.setString(38, (masMedExam.getMoUser().getEmployee() != null ? masMedExam.getMoUser().getEmployee().getFirstName() :""));	
						csstmt.setString(39, (""));
						csstmt.setString(40, (masMedExam.getRank()!=null ? masMedExam.getRank().getRankName() :"" ));
						csstmt.setString(41, (masMedExam.getMoUser()!=null ? masMedExam.getMoUser().getEmployee().getDesignation():""));
						csstmt.setString(42, (masMedExam.getDateValidated()!= null ? sdf.format(masMedExam.getDateValidated()) :""));
						csstmt.setString(43, (masMedExam.getUnit()!=null ? masMedExam.getUnit().getUnitName() :"" ));
						csstmt.setString(44, "INSERT");
						csstmt.setString(45, (masMedExam.getPermanentAddress() != null ? masMedExam.getPermanentAddress():""));
						csstmt.setString(46, (masMedExam.getRecordoffice() != null ? masMedExam.getRecordoffice():""));
						csstmt.setString(47, (""));
						csstmt.setInt(48, Integer.parseInt(userSrNo));
						csstmt.setInt(49, masMedExam.getId());
						csstmt.setString(50, (masMedExam.getMoUser() !=null ? masMedExam.getMoUser().getEmployee().getUnit().getUnitName():""));
						csstmt.setString(51, (masMedExam.getMoUser()!= null ?masMedExam.getMoUser().getEmployee().getRank().getRankName() :""));
						csstmt.setString(52, (masMedExam.getMoUser().getEmployee().getTrade()!=null ? masMedExam.getMoUser().getEmployee().getTrade().getTradeName():""));
						csstmt.registerOutParameter(53,OracleTypes.CURSOR);
						csstmt.execute();
						csstmt.close();
						if(masMedExam.getMasmedicaldetail()!=null && masMedExam.getMasmedicaldetail().size()>0)
						{
							for(MasMedicalExaminationDetail setMedicalExam:masMedExam.getMasmedicaldetail()){
								String procSql1 = "{ call SMC_HIC_INESERT_DISABILITIES (" +
								"?,?,?,?,?,?,?,?,?,?)}";
								CallableStatement csstmt1 = conn.prepareCall(procSql1);
								csstmt1.setString(1, masMedExam.getServiceNo())	;
								csstmt1.setString(2,(setMedicalExam.getPrincipal()!=null ? setMedicalExam.getPrincipal():"")); 
								csstmt1.setString(3, (setMedicalExam.getPlace() != null ? setMedicalExam.getPlace():""));
								csstmt1.setString(4,(setMedicalExam.getOrigindate()!=null ? sdf.format(setMedicalExam.getOrigindate()) :"" ));

								csstmt1.setString(5, (setMedicalExam.getCategory()!= null ? setMedicalExam.getCategory().getCategories() : "" ));
								csstmt1.setString(6, (setMedicalExam.getMedicalcatdate()!=null ? sdf.format(setMedicalExam.getMedicalcatdate()) :"" ));
								csstmt1.setString(7, "");
								csstmt1.setString(8, (setMedicalExam.getNextcatdate()!= null ?  sdf.format(setMedicalExam.getNextcatdate()):"" ));
								csstmt1.setInt(9, (masMedExam.getId()!= null ? masMedExam.getId():0 ));
								csstmt1.setInt(10, Integer.parseInt(userSrNo));
								csstmt1.execute();
								csstmt1.close();
							}
						}
						//	tx.commit();
						successfullyAdded = true;

					}catch (Exception e) {

						if (tx != null)
							//			tx.rollback();
							session.close();
						e.printStackTrace();
					}
				}
				
			}
			/**
			 * End of Code
			 */
			
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("dataMessage", dataMessage);
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}

	@Override
	public Map<String, Object> rejectMedExam(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int medExamId = box.getInt("medExamId");
		int visitId = box.getInt("visitId");
		boolean successfullyAdded= false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			MasMedicalExaminationReportOnEntry masMedExam = new MasMedicalExaminationReportOnEntry();
			masMedExam = loadMedicalExamObj(medExamId);
			masMedExam.setStatus("p");
			masMedExam.setRejectStatus("r");
			masMedExam.setRejectDate(new Date());
			if(box.getString("flag").equals("command")){
				masMedExam.setCommandRemarks(box.getString("cmMdRemarks"));
				Users cmUser = new Users();
				cmUser.setId(box.getInt("userId"));
				masMedExam.setCmUser(cmUser);
			}else if(box.getString("flag").equals("md")){
				masMedExam.setMdRemarks(box.getString("cmMdRemarks"));
				Users mdUser = new Users();
				mdUser.setId(box.getInt("userId"));
				masMedExam.setMdUser(mdUser);
			}
			if(box.getString("MedicinRamarks")!=null){
				masMedExam.setRemarks(box.getString("MedicinRamarks"));
			}
			
			hbt.update(masMedExam);
			Visit visit = (Visit)hbt.load(Visit.class, visitId);
            visit.setMedStatus("w");
            
            /*
	    	  * Code By Dinesh
	    	  * Date 03 Feb 2012
	    	  */
	    	   /* Priority Color Coding By Dinesh
				*		    	 	  	Normal	Urgent	Very Urgent
				* New Data	   	   		3		   2		1
	    	    * Pending For Result	6		   5	 	6
	    	    * Rejected By MO		9		   8		7
	    	    */
            visit.setPriority(7);
            /*if(visit.getPriority()!=null){
	    		 if(visit.getPriority()==4){
	    			 visit.setPriority(7);		 
	    		 }else if(visit.getPriority()==5){
	    			 visit.setPriority(8);		 
	    		 }else if(visit.getPriority()==6){
	    			 visit.setPriority(9);		 
	    		 }
	    	 }*/
            
           // visit.setPriority(2);
            hbt.update(visit);
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}

	@Override
	public Map<String, Object> pendingMDWatingList(Map<String, Object> mapofds) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		Session session = (Session) getSession();
		int commandId = 0;
		String rejectStatus = "";
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		
		if (mapofds.get("commandId") != null) {
			commandId = (Integer) mapofds.get("commandId");
		}
		List<MasRankCategory> rankCategoryList = null;
		List<MasAdministrativeSex> genderList = null;
		List<MasTrade> tradeList = null;
		List<MasUnit> unitList = null;
		List<MasRank> rankList = null;
		List<MasCommand> commandList = null;
		List<MasSection> sectionList = null;
		List<Disabilitygroup> DisabilitygroupList = null;
		List<Category> CategoryList = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		  //-------------- commented by sanjay yadav -----------------//
		/*rankList = hbt.find("from MasRank as rank where rank.Status='y'  order by rank.RankName ");*/
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("Id")).list();
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("SectionName")).list();

		//------------commented by anamika--------------------//
		/*unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y"))
					.createAlias("Station","station").setProjection(Projections.projectionList()
					.add(Projections.property("Id")).add(Projections.property("UnitName"))
					.add(Projections.property("station.StationName"))).addOrder(Order.asc("UnitName")).list();*/
		  //----------------commented by sanjay-------------------//
		/*unitList = hbt.find("from MasUnit as unit where unit.Status='y'  order by unit.UnitName ");*/
		
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("UnitName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();

		// DisabilityList = session.createCriteria(Disability.class).list();
		DisabilitygroupList = session.createCriteria(Disabilitygroup.class).list();
		CategoryList = session.createCriteria(Category.class).list();
		
		/*tradeList = hbt.find("from MasTrade mt where mt.Status='y' order by mt.TradeName");*/
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("TradeName")).list();
		commandList =session.createCriteria(MasCommand.class).add(Restrictions.eq("Status", "y")).list();
		List<MasBloodGroup> bloodGroupList = null;
		//----------------------- Commented by sanjay yadav--------------//
		/*bloodGroupList = hbt.find("from MasBloodGroup as dist where dist.Status='y' order by dist.BloodGroupName");*/
		bloodGroupList = session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("BloodGroupName")).list();
		genderList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y")).list();
		/*int rankId = 0;
		int unitId = 0;
		int commandid = 0;
		int tradeId = 0;
		int disabilityId = 0;
		int Interval = 0;
		int bloodid = 0;
		int disabilityGroupId = 0;
		String CategoryId = null;
		String AgeFrom = null;
		String to = null;
		String group1 = null;
		Date DateAson = null;
		String weight = null;
		String LifeStyleFactor = null;
		Date IntervalFrom = null;
		Date IntervalTo = null;
		String Gender = null;
		String searchType = null;
		String serviceNo = "";
		String icdDiag="";
		Date fromDate = new Date();
		Date toDate = new Date();
		int icdId1 = 0;
		String overDue = "";
		if(mapofds.get("icdId")!=null){
			icdId1=(Integer)mapofds.get("icdId");
		}
		if(mapofds.get("icdDiag")!=null){
			icdDiag=(String)mapofds.get("icdDiag");
		}
		if(mapofds.get("rejectStatus")!=null){
			rejectStatus=(String)mapofds.get("rejectStatus");
		}
		if(mapofds.get("overDue")!=null){
			overDue=(String)mapofds.get("overDue");
		}
		if (mapofds.get("fromDate") != null) {
			fromDate = (Date) mapofds.get("fromDate");
		}
		if (mapofds.get("toDate") != null) {
			toDate = (Date) mapofds.get("toDate");
		}
		int fromrankId = 0;
		if(mapofds.get("fromrankId")!=null){
			fromrankId =(Integer)mapofds.get("fromrankId");
		}
		int toRankId = 0;
		if(mapofds.get("toRankId")!=null){
			toRankId =(Integer)mapofds.get("toRankId");
		}
		String fromTotalService = "";
		if(mapofds.get("fromTotalService")!=null){
			fromTotalService =(String)mapofds.get("fromTotalService");
		}
		String toTotalService = "";
		if(mapofds.get("toTotalService")!=null){
			toTotalService =(String)mapofds.get("toTotalService");
		}
		int serviceTypeId = 0;
		if(mapofds.get("serviceTypeId")!=null){
			serviceTypeId =(Integer)mapofds.get("serviceTypeId");
		}
		int serviceStatusId = 0;
		if(mapofds.get("serviceStatusId")!=null){
			serviceStatusId =(Integer)mapofds.get("serviceStatusId");
		}
		int rankCategoryId = 0;
		if(mapofds.get("rankCategoryId")!=null){
			rankCategoryId =(Integer)mapofds.get("rankCategoryId");
		}
		int sectionId = 0;
		if(mapofds.get("sectionId")!=null){
			sectionId =(Integer)mapofds.get("sectionId");
		}
		
		Date d = new Date();//intialize your date to any date 
		Date dateBefore = new Date(d.getTime() + 240 * 24 * 3600 * 1000 );
		
		if (mapofds.get("systemDiagnosis") != null) {
			String systemDiag = (String) mapofds.get("systemDiagnosis");
			List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = session
							.createCriteria(MasMedicalExaminationDetail.class)							
							.add(Restrictions.eq("Principal", systemDiag).ignoreCase()).list();
			  //.add(Restrictions.eq("Particular", "detail").ignoreCase())
			
			
			for (MasMedicalExaminationDetail masMedicalExamDetail : masMedicalExaminationDetailList) {
			Criteria crit = null;
			crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
			.add(Restrictions.eq("medicalType", "MedicalExam"))
					.add(Restrictions.eq("Id", masMedicalExamDetail.getMasMedicalReport().getId()));
			//.add(Restrictions.eq("Status", "p"))	
			if (mapofds.get("serviceNo") != null) {
				serviceNo = (String) mapofds.get("serviceNo");
				searchType = "search";
			}
			
			if (mapofds.get("Gender") != null) {
					Gender = (String) mapofds.get("Gender");
					searchType = "search";
				}

				if(!serviceNo.equals("")){
					crit = crit.add(Restrictions.eq("ServiceNo", serviceNo));
					searchType = "search";
				}
				if(fromrankId !=0 && toRankId !=0){
					crit = crit.createAlias("Rank", "r").add(Restrictions.between("r.Id", fromrankId, toRankId));
				}
				if (fromTotalService != null && toTotalService != null) {
					crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").add(Restrictions.gt("h.TotalServicePeriod", fromTotalService)).add(Restrictions.lt("h.TotalServicePeriod", toTotalService));
					searchType = "search";
				}
				if (serviceTypeId != 0) {
					crit = crit.add(Restrictions.eq("serviceType.Id", serviceTypeId));
					searchType = "search";
				}
				if (serviceStatusId != 0) {
					crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.ServiceStatus", "serviceStatus").add(Restrictions.eq("serviceStatus.Id", serviceStatusId));
					searchType = "search";
				}
				if (rankCategoryId != 0) {
					crit = crit.createAlias("Rank", "r").createAlias("r.RankCategory", "rc").add(Restrictions.eq("rc.Id", rankCategoryId));
				}
				if (sectionId != 0) {
					crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.Section", "section").add(Restrictions.eq("section.Id", sectionId));
				}
			
				if(!rejectStatus.equals("")){
					crit = crit.add(Restrictions.eq("RejectStatus", "r"));
					searchType = "search";
					if(fromDate!=null && toDate!=null){
						crit = crit.add(Restrictions.eq("RejectStatus", "r")).add(Restrictions.between("RejectDate",fromDate, toDate)); //reject date
					}
					searchType = "search";
				}else{
					if(fromDate!=null && toDate!=null){
						crit = crit.add(Restrictions.between("DateOfCompletion",fromDate, toDate)); //normal date
						searchType = "search";
					}
					
				}
				
				if (mapofds.get("unitId") != null) {unitId = (Integer) mapofds.get("unitId");
					searchType = "search";
				}
				if (unitId != 0) {
					crit = crit.createAlias("Unit", "u").add(Restrictions.eq("u.Id", unitId));
					searchType = "search";
				}
				if (mapofds.get("commandid") != null) {
					commandid = (Integer) mapofds.get("commandid");
					searchType = "search";
				}
				if (commandid != 0) {
					crit = crit.createAlias("Command", "c").add(Restrictions.eq("c.Id", commandid));
					searchType = "search";
				}
				if (mapofds.get("CategoryId") != null) {
					CategoryId = (String) mapofds.get("CategoryId");
					searchType = "search";
				}
				if (CategoryId != null) {
					crit = crit.createAlias("PresentMedicalCategory", "pmc")
							.add(Restrictions.eq("pmc.Categories", CategoryId));
					searchType = "search";
				}
				
				if (mapofds.get("tradeId") != null) {
					tradeId = (Integer) mapofds.get("tradeId");
					searchType = "search";
				}
				if (tradeId != 0) {
					crit = crit.createAlias("Trade", "t").add(Restrictions.eq("t.Id", tradeId));
					searchType = "search";
				}
				if (mapofds.get("AgeFrom") != null) {
					AgeFrom = (String) mapofds.get("AgeFrom");
				}
				if (mapofds.get("to") != null && mapofds.get("AgeFrom") != null) {
					to = (String) mapofds.get("to");

				}
				if (AgeFrom != null && to != null) {
					crit = crit.add(Restrictions.gt("ApparentAge", AgeFrom))
							.add(Restrictions.lt("ApparentAge", to));
					searchType = "search";
				}
				
				if (mapofds.get("DateAson") != null) {
					DateAson = (Date) mapofds.get("DateAson");
					searchType = "search";
				}
				if (DateAson != null)
					crit = crit.add(Restrictions.eq("DateOfCompletion", DateAson));

				if (mapofds.get("weight") != null) {
					weight = (String) mapofds.get("weight");

				}
				if (weight != null && !weight.equalsIgnoreCase("0")) {
					crit = crit.add(Restrictions.eq("Idealweight", weight));
					searchType = "search";
				}
				if(overDue != null && overDue.equals("y")){
					crit = crit.add(Restrictions.sqlRestriction("date_of_completion <= ADD_MONTHS(TRUNC(SYSDATE), -9)"));
					searchType = "search";
				}
				if (overDue != null && overDue.equalsIgnoreCase("1")) {
					crit = crit.add(Restrictions.sqlRestriction("select TRUNC(MONTHS_BETWEEN(TO_DATE(next_board_date, 'dd-mon-yyyy'), TO_DATE(sysdate,  'dd-mon-yyyy'))) from mas_medical_examination_report where TRUNC(MONTHS_BETWEEN(TO_DATE(next_board_date, 'dd-mon-yyyy'), TO_DATE(sysdate,  'dd-mon-yyyy'))) <=3 and select TRUNC(MONTHS_BETWEEN(TO_DATE(next_board_date, 'dd-mon-yyyy'), TO_DATE(sysdate,  'dd-mon-yyyy'))) from mas_medical_examination_report where TRUNC(MONTHS_BETWEEN(TO_DATE(next_board_date, 'dd-mon-yyyy'), TO_DATE(sysdate,  'dd-mon-yyyy'))) >0"));
					searchType = "search";
				}	
				//SELECT * from visit where 
				 //visit_date <= ADD_MONTHS(TRUNC(SYSDATE), -5)

				if (mapofds.get("bloodid") != null) {
					bloodid = (Integer) mapofds.get("bloodid");
					searchType = "search";
				}
				//if (Gender != null || bloodid != 0) {
				if (Gender != null) {
					crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h");
					searchType = "search";
				}
				if (bloodid != 0) {
					crit = crit.createAlias("h.BloodGroup", "b").add(Restrictions.eq("b.Id", bloodid));
					searchType = "search";
				}

				if (mapofds.get("LifeStyleFactor") != null) {
					LifeStyleFactor = (String) mapofds.get("LifeStyleFactor");
					searchType = "search";
				}
				//null<-CategoryId--commandid-->0<--unitId--->0<--rankId--->0<--tradeId--->0<---to-->null<--AgeFrom--->null<---DateAson-->null<--weight--->null
				if (Gender != null) {
					crit = crit.createAlias("h.Sex", "s").add(
							Restrictions.eq("s.AdministrativeSexName", Gender));
					searchType = "search";
				}
				int icdId=0;
				if(mapofds.get("icdId") !=null ){
					icdId=(Integer) mapofds.get("icdId"); 
				}
				
				List<MasMedicalExaminationReportOnEntry> masMedicalExamDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
				
				if (searchType != null) {
					masMedicalExamDetailList = crit.list();
				}
				
				for (MasMedicalExaminationReportOnEntry masMedicalExamEntry : masMedicalExamDetailList) {
					patientDetailList.add(masMedicalExamEntry);
				}
			}
		} else {
			Criteria crit = null;
			crit = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class)
					//.add(Restrictions.eq("Status", "f"))
					.add(Restrictions.eq("medicalType", "MedicalExam"));
			if (mapofds.get("Gender") != null) {
				Gender = (String) mapofds.get("Gender");
				// searchType="search";
			}
			if (mapofds.get("serviceNo") != null) {
				serviceNo = (String) mapofds.get("serviceNo");
				searchType = "search";
			}
			if(!serviceNo.equals("")){
				crit = crit.add(Restrictions.eq("ServiceNo", serviceNo));
				searchType = "search";
			}
			if(fromrankId !=0 && toRankId !=0){
				crit = crit.createAlias("Rank", "r").add(Restrictions.between("r.Id", fromrankId, toRankId));
				searchType = "search";
			}
			if (!fromTotalService.equals("") && !toTotalService.equals("")) {
				crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").add(Restrictions.gt("h.TotalServicePeriod", fromTotalService)).add(Restrictions.lt("h.TotalServicePeriod", toTotalService));
				searchType = "search";
			}
			if (serviceTypeId != 0) {
				crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.ServiceType", "serviceType").add(Restrictions.eq("serviceType.Id", serviceTypeId));
				searchType = "search";
			}
			if (serviceStatusId != 0) {
				crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.ServiceStatus", "serviceStatus").add(Restrictions.eq("serviceStatus.Id", serviceStatusId));
				searchType = "search";
			}
			if (rankCategoryId != 0) {
				crit = crit.createAlias("Rank", "r").createAlias("r.RankCategory", "rc").add(Restrictions.eq("rc.Id", rankCategoryId));
				searchType = "search";
			}
			if (sectionId != 0) {
				crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.Section", "section").add(Restrictions.eq("section.Id", sectionId));
				searchType = "search";
			}
		
			
			if (mapofds.get("unitId") != null) {
				unitId = (Integer) mapofds.get("unitId");
				// searchType="search";
			}
			if (unitId != 0) {
				crit = crit.createAlias("Unit", "u").add(
						Restrictions.eq("u.Id", unitId));
				searchType = "search";
			}
			if (mapofds.get("commandid") != null) {
				commandid = (Integer) mapofds.get("commandid");
				// searchType="search";
			}
			if (commandid != 0) {
				crit = crit.createAlias("Command", "c").add(
						Restrictions.eq("c.Id", commandid));
				searchType = "search";
			}
			if (mapofds.get("CategoryId") != null) {
				CategoryId = (String) mapofds.get("CategoryId");
				// searchType="search";
			}
			if (CategoryId != null) {
				crit = crit.createAlias("PresentMedicalCategory", "pmc").add(
						Restrictions.eq("pmc.Categories", CategoryId));
				searchType = "search";
			}
			if (mapofds.get("tradeId") != null) {
				tradeId = (Integer) mapofds.get("tradeId");
				// searchType="search";
			}
			if (tradeId != 0) {
				crit = crit.createAlias("Trade", "t").add(
						Restrictions.eq("t.Id", tradeId));
				searchType = "search";
			}
			*//**
			 * if (mapofds.get("disabilityId") != null) { disabilityId =
			 * (Integer) mapofds.get("disabilityId"); searchType="search"; }
			 * if(disabilityId!=0){ crit = crit.createAlias("Disability",
			 * "r").add(Restrictions.eq("r.Id", rankId)); } if
			 * (mapofds.get("disabilityGroupId") != null) { disabilityGroupId =
			 * (Integer) mapofds.get("disabilityGroupId"); searchType="search";
			 * }
			 *//*
			// if(disabilityGroupId!=0)
			// crit = crit.createAlias("Rank", "r").add(Restrictions.eq("r.Id",
			// rankId));

			if (mapofds.get("AgeFrom") != null) {
				AgeFrom = (String) mapofds.get("AgeFrom");
			}
			if (mapofds.get("to") != null && mapofds.get("AgeFrom") != null) {
				to = (String) mapofds.get("to");

			}
			if (AgeFrom != null && to != null) {
				crit = crit.add(Restrictions.gt("ApparentAge", AgeFrom)).add(
						Restrictions.lt("ApparentAge", to));
				searchType = "search";
			}

			// if (mapofds.get("group1") != null) {
			// group1 = (String) mapofds.get("group1");

			// }

			// if(group1!=null && ! group1.equalsIgnoreCase("Both_Sex"))
			// crit = crit.createAlias("h.Sex",
			// "s").add(Restrictions.eq("s.AdministrativeSexName", group1));

			if (mapofds.get("DateAson") != null) {
				DateAson = (Date) mapofds.get("DateAson");
				 searchType="search";
			}
			
			if (mapofds.get("weight") != null) {
				weight = (String) mapofds.get("weight");

			}
			if (weight != null && !weight.equalsIgnoreCase("0")) {
				crit = crit.add(Restrictions.eq("Idealweight", weight));
				searchType = "search";
			}
			if (mapofds.get("bloodid") != null) {
				bloodid = (Integer) mapofds.get("bloodid");
				// searchType="search";
			}
			if (Gender != null || bloodid != 0) {
				crit = crit.createAlias("Visit", "v").createAlias("v.Hin", "h");
				searchType = "search";
			}
			if (bloodid != 0) {
				crit = crit.createAlias("h.BloodGroup", "b").add(
						Restrictions.eq("b.Id", bloodid));
				searchType = "search";
			}

			if (mapofds.get("LifeStyleFactor") != null) {
				LifeStyleFactor = (String) mapofds.get("LifeStyleFactor");
				// searchType="search";
			}
			// if(LifeStyleFactor!=null)
			// crit = crit.add(Restrictions.eq("r.Id", rankId));

			if (Gender != null) {
				crit = crit.createAlias("h.Sex", "s").add(
						Restrictions.eq("s.AdministrativeSexName", Gender));
				searchType = "search";
			}
			if(!rejectStatus.equals("")){
				crit = crit.add(Restrictions.eq("RejectStatus", "r"));
				if(fromDate!=null && toDate!=null){
					crit = crit.add(Restrictions.eq("RejectStatus", "r")).add(Restrictions.between("RejectDate",fromDate, toDate)); //reject date
				}
				searchType = "search";
			}else{
				if(fromDate!=null && toDate!=null){
					crit = crit.add(Restrictions.between("DateOfCompletion",fromDate, toDate)); //normal date
					searchType = "search";
				}
				
			}
			if(overDue.equals("y")){
				crit = crit.add(Restrictions.sqlRestriction("date_of_completion <= ADD_MONTHS(TRUNC(SYSDATE), -9)"));
				searchType = "search";
			}

			
			 * if(mapofds.get("searchtype")!=null &&
			 * (mapofds.get("searchtype").equals("graph")||
			 * mapofds.get("searchtype").equals("graphInjsp"))) { List<Object[]>
			 * dataList = new ArrayList<Object[]>(); IntervalFrom = (Date)
			 * mapofds.get("IntervalFrom"); IntervalTo = (Date)
			 * mapofds.get("IntervalTo"); // Interval = (Integer)
			 * mapofds.get("Interval"); String pattern = "MM/dd/yyyy";
			 * SimpleDateFormat format = new SimpleDateFormat(pattern); Date
			 * date = new Date(); SimpleDateFormat sdf = new
			 * SimpleDateFormat(pattern); //sdf.format(date)
			 * 
			 * crit = crit.add(Restrictions.ge("DateValidated",
			 * IntervalFrom)).add(Restrictions.le("DateValidated", IntervalTo));
			 * 
			 * 
			 * crit=crit.setProjection(Projections.projectionList().add(Projections
			 * .rowCount()).add(Projections.groupProperty("DateValidated")));
			 * 
			 * dataList = crit.list();
			 * 
			 * // TimeSeries series1 = new TimeSeries("Temperature",
			 * Minute.class); // TimeSeries series2 = new TimeSeries("Pulse",
			 * Minute.class); // TimeSeriesCollection dataset = new
			 * TimeSeriesCollection(); // DefaultPieDataset dataset1 = new
			 * DefaultPieDataset(); DefaultCategoryDataset dataset2 = new
			 * DefaultCategoryDataset(); if(dataList.size()>0) { int count=0;
			 * int m=0; for(Object[] entry:dataList) { String
			 * yaxis=entry[0].toString(); String xaxis=entry[1].toString();
			 * dataset2.setValue(Integer.parseInt(yaxis),
			 * "No.Of Service Persion Done Medical Exam", xaxis);
			 * 
			 * } final CategoryItemRenderer renderer = new BarRenderer();
			 * renderer.setItemLabelsVisible(true); final CategoryPlot plot =
			 * new CategoryPlot(); plot.setDataset(dataset2);
			 * plot.setRenderer(renderer);
			 * 
			 * plot.setDomainAxis(new CategoryAxis("Medical Exam Date"));
			 * plot.setRangeAxis(new NumberAxis("Value"));
			 * 
			 * plot.setOrientation(PlotOrientation.VERTICAL);
			 * plot.setRangeGridlinesVisible(true);
			 * plot.setDomainGridlinesVisible(true); final JFreeChart chart =
			 * new JFreeChart(plot); chart.setTitle("TREND ANALYSIS GRAPH"); //
			 * chart.setLegend(new StandardLegend());
			 * chart.getBackgroundImage(); // add the chart to a panel... // get
			 * ImageMap
			 * 
			 * // populate the info
			 * 
			 * final ChartPanel chartPanel = new ChartPanel(chart);
			 * chartPanel.setPreferredSize(new java.awt.Dimension(500, 270)); //
			 * setContentPane(chartPanel); JFreeChartRenderer jfcRenderer = new
			 * JFreeChartRenderer(chart); map.put("jfcRenderer", jfcRenderer);
			 * map.put("chart", chart); Connection conn = session.connection();
			 * map.put("conn", conn);
			 * 
			 * }else // if record not exists in ipd_input_output_chart {
			 * map.put("status", "nodata"); }
			 * 
			 * 
			 * }
			 
			
			 * if(mapofds.get("searchtype")!=null &&
			 * mapofds.get("searchtype").equals("graphInjsp")) { List<Object[]>
			 * dataList = new ArrayList<Object[]>();
			 * 
			 * IntervalFrom = (Date) mapofds.get("IntervalFrom"); IntervalTo =
			 * (Date) mapofds.get("IntervalTo");
			 * 
			 * // Interval = (Integer) mapofds.get("Interval"); crit =
			 * crit.add(Restrictions.gt("DateValidated",
			 * IntervalFrom)).add(Restrictions.lt("DateValidated", IntervalTo));
			 * crit
			 * =crit.setProjection(Projections.projectionList().add(Projections
			 * .rowCount()).add(Projections.groupProperty("DateValidated")));
			 * 
			 * dataList = crit.list(); map.put("dataList", dataList); }
			 

			
			 * if(mapofds.get("searchtype")!=null &&
			 * mapofds.get("searchtype").equals("search")) {
			 * 
			 * }
			 
			if (searchType != null) {
				patientDetailList = crit.list();
			}
		}*/
		map.put("rankList", rankList);
		map.put("rankCategoryList", rankCategoryList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("serviceStatusList", serviceStatusList);
		map.put("sectionList", sectionList);
		map.put("unitList", unitList);
		map.put("commandList", commandList);
		map.put("tradeList", tradeList);
		// map.put("DisabilityList", DisabilityList);
		map.put("DisabilitygroupList", DisabilitygroupList);
		map.put("CategoryList", CategoryList);
		map.put("patientDetailList", patientDetailList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("genderList", genderList);
		return map;
	}
	public Map<String, Object> serchPendingMDWatingList(Map<String, Object> mapofds) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Session session = (Session) getSession();
		int hospitalId = 0;
		String rejectStatus = "";
		String overWeight = "";
		int rankId = 0;
		int unitId = 0;
		int commandid = 0;
		int tradeId = 0;
		int disabilityId = 0;
		int Interval = 0;
		int bloodid = 0;
		int disabilityGroupId = 0;
		String CategoryId = "";
		String AgeFrom = null;
		String to = null;
		String group1 = null;
		Date DateAson = null;
		String weight = null;
		String LifeStyleFactor = null;
		Date IntervalFrom = null;
		Date IntervalTo = null;
		int genderId = 0;
		String searchType = null;
		String serviceNo = "";
		String icdDiag="";
		Date fromDate = new Date();
		Date toDate = new Date();
		int icdId1 = 0;
		String overDue = "";
		if(mapofds.get("icdId")!=null){
			icdId1=(Integer)mapofds.get("icdId");
		}
		if(mapofds.get("icdDiag")!=null){
			icdDiag=(String)mapofds.get("icdDiag");
		}
		if(mapofds.get("rejectStatus")!=null){
			rejectStatus=(String)mapofds.get("rejectStatus");
		}
		if(mapofds.get("overWeight")!=null){
			overWeight=(String)mapofds.get("overWeight");
		}
		if(mapofds.get("overDue")!=null){
			overDue=(String)mapofds.get("overDue");
		}
		if (mapofds.get("fromDate") != null) {
			fromDate = (Date) mapofds.get("fromDate");
		}
		if (mapofds.get("toDate") != null) {
			toDate = (Date) mapofds.get("toDate");
		}
		int fromrankId = 0;
		if(mapofds.get("fromrankId")!=null){
			fromrankId =(Integer)mapofds.get("fromrankId");
		}
		int toRankId = 0;
		if(mapofds.get("toRankId")!=null){
			toRankId =(Integer)mapofds.get("toRankId");
		}
		if (mapofds.get("AgeFrom") != null) {
			AgeFrom = (String) mapofds.get("AgeFrom");
		}
		if (mapofds.get("to") != null && mapofds.get("AgeFrom") != null) {
			to = (String) mapofds.get("to");

		}
		Float fromTotalService = null;
		if(mapofds.get("fromTotalService")!=null){
			fromTotalService =(Float)mapofds.get("fromTotalService");
		}
		Float toTotalService = null;
		if(mapofds.get("toTotalService")!=null){
			toTotalService =(Float)mapofds.get("toTotalService");
		}
		String fromServUnit = "";
		if(mapofds.get("fromServUnit")!=null){
			fromServUnit =(String)mapofds.get("fromServUnit");
		}
		String toServUnit = "";
		if(mapofds.get("toServUnit")!=null){
			toServUnit =(String)mapofds.get("toServUnit");
		}
		
		int serviceTypeId = 0;
		if(mapofds.get("serviceTypeId")!=null){
			serviceTypeId =(Integer)mapofds.get("serviceTypeId");
		}
		int serviceStatusId = 0;
		if(mapofds.get("serviceStatusId")!=null){
			serviceStatusId =(Integer)mapofds.get("serviceStatusId");
		}
		int rankCategoryId = 0;
		if(mapofds.get("rankCategoryId")!=null){
			rankCategoryId =(Integer)mapofds.get("rankCategoryId");
		}
		if (mapofds.get("tradeId") != null) {
			tradeId = (Integer) mapofds.get("tradeId");
		}
		if (mapofds.get("CategoryId") != null) {
			CategoryId = (String) mapofds.get("CategoryId");
		}
		
		
		if (mapofds.get("hospitalId") != null) {
			hospitalId = (Integer) mapofds.get("hospitalId");
		}
		
		if (mapofds.get("genderId") != null) {
			genderId = (Integer) mapofds.get("genderId");
		}
		if (mapofds.get("unitId") != null) {
			unitId = (Integer) mapofds.get("unitId");
	     }
		if (mapofds.get("commandid") != null) {
			commandid = (Integer) mapofds.get("commandid");
		}
		int sectionId = 0;
		if(mapofds.get("sectionId")!=null){
			sectionId =(Integer)mapofds.get("sectionId");
		}
		if (mapofds.get("serviceNo") != null) {
			serviceNo = (String) mapofds.get("serviceNo");
			
		}
		
		Date d = new Date();//intialize your date to any date 
		Date dateBefore = new Date(d.getTime() + 240 * 24 * 3600 * 1000 );
		if (mapofds.get("systemDiagnosis") != null) {
			String systemDiag = (String) mapofds.get("systemDiagnosis");
			List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = session
							.createCriteria(MasMedicalExaminationDetail.class)							
							.add(Restrictions.eq("Principal", systemDiag).ignoreCase()).list();
			  //.add(Restrictions.eq("Particular", "detail").ignoreCase())
			
			
			for (MasMedicalExaminationDetail masMedicalExamDetail : masMedicalExaminationDetailList) {
			Criteria crit = null;
			crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
			.add(Restrictions.eq("medicalType", "MedicalExam")).createAlias("Hospital", "hospital").add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("Id", masMedicalExamDetail.getMasMedicalReport().getId()));
			//.add(Restrictions.eq("Status", "p"))	
			
			
			

				if(!serviceNo.equals("")){
					crit = crit.add(Restrictions.eq("ServiceNo", serviceNo));
					searchType = "search";
				}
				if(fromrankId !=0 && toRankId !=0 && rankCategoryId != 0 ){
					crit = crit.createAlias("Rank", "rank")
					.add(Restrictions.between("rank.Id", fromrankId, toRankId)).
						createAlias("rank.RankCategory", "rc").add(Restrictions.eq("rc.Id", rankCategoryId));
				searchType = "search";
				}else if(fromrankId !=0 && toRankId !=0 ){
					crit = crit.createAlias("Rank", "rank").add(Restrictions.between("rank.Id", fromrankId, toRankId));
					searchType = "search";
				}else if (rankCategoryId != 0) {
					crit = crit.createAlias("Rank", "rank").createAlias("rank.RankCategory", "rc").add(Restrictions.eq("rc.Id", rankCategoryId));
					searchType = "search";
				}
				
				if (fromTotalService != null && toTotalService != null && fromServUnit !=null && toServUnit !=null) {
					crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h")
							.add(Restrictions.gt("h.ServiceYears", fromTotalService))
							.add(Restrictions.gt("h.TotalServicePeriod", fromServUnit))
							.add(Restrictions.lt("h.ServiceYears", toTotalService))
							.add(Restrictions.lt("h.TotalServicePeriod", toServUnit));
					searchType = "search";
				}
				if (serviceTypeId != 0) {
					crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.ServiceType", "serviceType").add(Restrictions.eq("serviceType.Id", serviceTypeId));
					searchType = "search";
				}
				if (serviceStatusId != 0) {
					crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.ServiceStatus", "serviceStatus").add(Restrictions.eq("serviceStatus.Id", serviceStatusId));
					searchType = "search";
				}
				
				if (sectionId != 0) {
					crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.Section", "section").add(Restrictions.eq("section.Id", sectionId));
				}
			
				if(!rejectStatus.equals("")){
					crit = crit.add(Restrictions.eq("RejectStatus", "r"));
					searchType = "search";
					if(fromDate!=null && toDate!=null){
						crit = crit.add(Restrictions.eq("RejectStatus", "r")).add(Restrictions.between("RejectDate",fromDate, toDate)); //reject date
					}
					searchType = "search";
				}else{
					if(fromDate!=null && toDate!=null){
						crit = crit.add(Restrictions.between("DateOfCompletion",fromDate, toDate)); //normal date
						searchType = "search";
					}
					
				}
				/*if(!overWeight.equals("") && overWeight.equals("y")){
					
					crit = crit.add(Restrictions.between("Overweight", 20, 30));
					searchType = "search";
				}*/
				
				if (overWeight != null && overWeight.equalsIgnoreCase("y")) 
				   {
					 crit = crit.add(Restrictions.sqlRestriction("to_number(overweight)>=20.0 and to_number(overweight)<=30.0"));
					 searchType = "search";
					}
				if(overDue != null && overDue.equals("y")){
					crit = crit.add(Restrictions.sqlRestriction("date_of_completion <= ADD_MONTHS(TRUNC(SYSDATE), -9)"));
					searchType = "search";
				}
				
				
				if (unitId != 0) {
					crit = crit.createAlias("Unit", "u").add(Restrictions.eq("u.Id", unitId));
					searchType = "search";
				}
				
				if (commandid != 0) {
					crit = crit.createAlias("Command", "c").add(Restrictions.eq("c.Id", commandid));
					searchType = "search";
				}
				
				/*if (CategoryId != 0) {
					crit = crit.createAlias("PresentMedicalCategory", "pmc")
							.add(Restrictions.eq("pmc.Id", CategoryId));
					searchType = "search";
				}*/
				if (CategoryId != null && !CategoryId.equals("") ) {
					crit = crit.createAlias("PresentMedicalCategory", "pmc").add(
							Restrictions.eq("pmc.Categories", CategoryId));
					searchType = "search";
				}
				
				
				if (tradeId != 0) {
					crit = crit.createAlias("Trade", "t").add(Restrictions.eq("t.Id", tradeId));
					searchType = "search";
				}
				
				if (AgeFrom != null && to != null) {
					crit = crit.add(Restrictions.gt("ApparentAge", AgeFrom))
							.add(Restrictions.lt("ApparentAge", to));
					searchType = "search";
				}
				
				if (mapofds.get("DateAson") != null) {
					DateAson = (Date) mapofds.get("DateAson");
					searchType = "search";
				}
				if (DateAson != null)
					crit = crit.add(Restrictions.eq("DateOfCompletion", DateAson));

				if (mapofds.get("weight") != null) {
					weight = (String) mapofds.get("weight");

				}
				if (weight != null && !weight.equalsIgnoreCase("0")) {
					crit = crit.add(Restrictions.eq("Idealweight", weight));
					searchType = "search";
				}
				if (mapofds.get("bloodid") != null) {
					bloodid = (Integer) mapofds.get("bloodid");
					searchType = "search";
				}
				
				if (bloodid != 0) {
					crit = crit.createAlias("h.BloodGroup", "b").add(Restrictions.eq("b.Id", bloodid));
					searchType = "search";
				}

				if (mapofds.get("LifeStyleFactor") != null) {
					LifeStyleFactor = (String) mapofds.get("LifeStyleFactor");
					searchType = "search";
				}
				if (genderId != 0) {
					crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.Sex", "s").add(
							Restrictions.eq("s.Id", genderId));
					searchType = "search";
				}
				int icdId=0;
				if(mapofds.get("icdId") !=null ){
					icdId=(Integer) mapofds.get("icdId"); 
				}
				
				List<MasMedicalExaminationReportOnEntry> masMedicalExamDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
				
				if (searchType != null) {
					masMedicalExamDetailList = crit.list();
				}
				
				for (MasMedicalExaminationReportOnEntry masMedicalExamEntry : masMedicalExamDetailList) {
					patientDetailList.add(masMedicalExamEntry);
				}
			}
		} else {
			Criteria crit = null;
			crit = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class).createAlias("Hospital", "hospital").add(Restrictions.eq("hospital.Id", hospitalId))
					//.add(Restrictions.eq("Status", "f"))
					.add(Restrictions.eq("medicalType", "MedicalExam"));
			
			if (mapofds.get("serviceNo") != null) {
				serviceNo = (String) mapofds.get("serviceNo");
				searchType = "search";
			}
			if(!serviceNo.equals("")){
				crit = crit.add(Restrictions.eq("ServiceNo", serviceNo));
				searchType = "search";
			}
			if(fromrankId !=0 && toRankId !=0 && rankCategoryId != 0 ){
				crit = crit.createAlias("Rank", "rank")
				.add(Restrictions.between("rank.Id", fromrankId, toRankId)).
					createAlias("rank.RankCategory", "rc").add(Restrictions.eq("rc.Id", rankCategoryId));
			searchType = "search";
			}else if(fromrankId !=0 && toRankId !=0 ){
				crit = crit.createAlias("Rank", "rank").add(Restrictions.between("rank.Id", fromrankId, toRankId));
				searchType = "search";
			}else if (rankCategoryId != 0) {
				crit = crit.createAlias("Rank", "rank").createAlias("rank.RankCategory", "rc").add(Restrictions.eq("rc.Id", rankCategoryId));
				searchType = "search";
			}
			if (fromTotalService != null && toTotalService != null && fromServUnit !=null && toServUnit !=null) {
				crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h")
						.add(Restrictions.gt("h.ServiceYears", fromTotalService))
						.add(Restrictions.eq("h.TotalServicePeriod", fromServUnit))
						.add(Restrictions.lt("h.ServiceYears", toTotalService))
						.add(Restrictions.eq("h.TotalServicePeriod", toServUnit));
				searchType = "search";
			}
			if (serviceTypeId != 0) {
				crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.ServiceType", "serviceType").add(Restrictions.eq("serviceType.Id", serviceTypeId));
				searchType = "search";
			}
			if (serviceStatusId != 0) {
				crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.ServiceStatus", "serviceStatus").add(Restrictions.eq("serviceStatus.Id", serviceStatusId));
				searchType = "search";
			}
			
			if (sectionId != 0) {
				crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.Section", "section").add(Restrictions.eq("section.Id", sectionId));
				searchType = "search";
			}
		
			if (unitId != 0) {
				crit = crit.createAlias("Unit", "u").add(
						Restrictions.eq("u.Id", unitId));
				searchType = "search";
			}
			
			if (commandid != 0) {
				crit = crit.createAlias("Command", "c").add(
						Restrictions.eq("c.Id", commandid));
				searchType = "search";
			}
			
			
			if (CategoryId != null && !CategoryId.equals("")) {
				crit = crit.createAlias("PresentMedicalCategory", "pmc").add(
						Restrictions.eq("pmc.Categories", CategoryId));
				searchType = "search";
			}
			if (tradeId != 0) {
				crit = crit.createAlias("Trade", "t").add(
						Restrictions.eq("t.Id", tradeId));
				searchType = "search";
			}

			
			if (AgeFrom != null && to != null) {
				crit = crit.add(Restrictions.gt("ApparentAge", AgeFrom)).add(
						Restrictions.lt("ApparentAge", to));
				searchType = "search";
			}

			if (mapofds.get("weight") != null) {
				weight = (String) mapofds.get("weight");

			}
			if (weight != null && !weight.equalsIgnoreCase("0")) {
				crit = crit.add(Restrictions.eq("Idealweight", weight));
				searchType = "search";
			}
			if (mapofds.get("bloodid") != null) {
				bloodid = (Integer) mapofds.get("bloodid");
				// searchType="search";
			}
			

			if (mapofds.get("LifeStyleFactor") != null) {
				LifeStyleFactor = (String) mapofds.get("LifeStyleFactor");
				// searchType="search";
			}
			// if(LifeStyleFactor!=null)
			// crit = crit.add(Restrictions.eq("r.Id", rankId));

			if (genderId != 0) {
				crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.Sex", "s").add(
						Restrictions.eq("s.Id", genderId));
				searchType = "search";
			}
			/*if(overWeight.equals("y") && !overWeight.equals("")){
				crit = crit.add(Restrictions.or(Restrictions.isNotNull("Overweight"), Restrictions.ne("Overweight", "0")));
				searchType = "search";
			}*/
			
			if (overWeight != null && overWeight.equalsIgnoreCase("y")) 
			   {
				 crit = crit.add(Restrictions.sqlRestriction("to_number(overweight)>=20.0 and to_number(overweight)<=30.0"));
				 searchType = "search";
				}
			
			
			if(!rejectStatus.equals("")){
				crit = crit.add(Restrictions.eq("RejectStatus", "r"));
				if(fromDate!=null && toDate!=null){
					crit = crit.add(Restrictions.eq("RejectStatus", "r")).add(Restrictions.between("RejectDate",fromDate, toDate)); //reject date
				}
				searchType = "search";
			}else{
				if(fromDate!=null && toDate!=null){
					crit = crit.add(Restrictions.between("DateOfCompletion",fromDate, toDate)); //normal date
					searchType = "search";
				}
				
			}
			if(overDue != null && overDue.equals("y")){
				crit = crit.add(Restrictions.sqlRestriction("date_of_completion <= ADD_MONTHS(TRUNC(SYSDATE), -9)"));
				searchType = "search";
			}
			
			if (searchType != null) {
				patientDetailList = crit.list();
			}
		}
		map.put("patientDetailList", patientDetailList);
		return map;
	}
	public Map<String, Object> getICDList(Map map) {
		List<MasIcd> itemList = new ArrayList<MasIcd>();
		Session session = (Session) getSession();
		try {
			String str =(String)map.get("autoHint") + "%";
			String query = "from MasIcd as icd where upper (icd.IcdName) like upper('" + str
					+ "')";
			Query q = session.createQuery(query);
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
	public Map<String, Object> pendingMedicalExamReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> searchMasDepartmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> searchMasEmployeeList = new ArrayList<MasEmployee>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		try {
			
			/*searchMasDepartmentList = getHibernateTemplate().find("from jkt.hms.masters.business.MasDepartment");*/
			searchMasDepartmentList = session.createCriteria(MasDepartment.class).list();
			
			/*searchMasEmployeeList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmployee as emp where emp.EmpCategory.Id='1'");*/
			searchMasEmployeeList = session.createCriteria(MasEmployee.class).createAlias("EmpCategory","empCategory").add(Restrictions.eq("empCategory.Id", 1)).list();
			/*rankList = getHibernateTemplate().find("from jkt.hms.masters.business.MasRank ");*/
			rankList = session.createCriteria(MasRank.class).addOrder(Order.asc("RankName")).add(Restrictions.eq("Status","y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchMasDepartmentList", searchMasDepartmentList);
		map.put("searchMasEmployeeList", searchMasEmployeeList);
		map.put("rankList", rankList);
		return map;
	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	@Override
	public Map<String, Object> getMedicalExamDetails(
			Map<String, Object> mapfordata) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int commandId = 0;
		List<MasMedicalExaminationReportOnEntry> medicalDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	    Criteria crit = null;
	    String serviceNo = null;
	    int empId=0;
        if(mapfordata.get("serviceNo") !=null){
        	serviceNo = (String)mapfordata.get("serviceNo");
        }
        if(mapfordata.get("empId") !=null){
        	empId = (Integer)mapfordata.get("empId");
        }
        int hospitalId=0;
        if(mapfordata.get("hospitalId") !=null){
        	hospitalId = (Integer)mapfordata.get("hospitalId");
        }
        int unitId=0;
        employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Id", empId)).list();
        if(employeeList.size() >0){
        	for(MasEmployee masEmployee:employeeList){
        		unitId=masEmployee.getUnit().getId();
        	}
        }
        
        map.put("unitId",unitId);
   	    crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("ServiceNo", serviceNo)).add(Restrictions.eq("Hospital.Id", hospitalId))
	    //.add(Restrictions.eq("Status","f"))
	    .addOrder(Order.asc("DateOfReporting"));
/*   	    crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("medicalType", "MedicalExam")).add(Restrictions.eq("ServiceNo", serviceNo))
	    .add(Restrictions.eq("Status","f")).addOrder(Order.asc("DateOfReporting"));*/
	    medicalDetailList = crit.list();
        map.put("medicalDetailList", medicalDetailList);	
        List<MasMedicalExaminationReportOnEntry> medicalExamReportDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
       
        List<MasMedicalExaminationDetail> masMedicalExamDetailsList = new ArrayList<MasMedicalExaminationDetail>();
        List<String> disabilityList = new ArrayList<String>();
        List<Integer> disabilityIdList = new ArrayList<Integer>();
        if(medicalDetailList.size()>0)
        {
        	masMedicalExamDetailsList=session.createCriteria(MasMedicalExaminationDetail.class).createAlias("MasMedicalReport", "mmr")
        	.add(Restrictions.eq("mmr.Hospital.Id", hospitalId))
    			.add(Restrictions.eq("Particular", "detail")).add(Restrictions.eq("mmr.ServiceNo", serviceNo)).list();
        	/*for(MasMedicalExaminationReportOnEntry medicalExamReport:medicalDetailList)
        	{
    		String disabilityString="";
    		
    		int medExamId=medicalExamReport.getId();
    		masMedicalExamDetailsList=session.createCriteria(MasMedicalExaminationDetail.class)
    		.add(Restrictions.eq("MasMedicalReport.Id", medExamId)).add(Restrictions.eq("Particular", "detail")).list();
    		if(masMedicalExamDetailsList.size()>0)
    		{
    			int check=1;
    	     	for (MasMedicalExaminationDetail masMedicalExaminationDetail : masMedicalExamDetailsList) 
    			{			
    			if(masMedicalExaminationDetail.getPrincipal()!=null)
    			{ 
    				if(check==1)
    				{
    					disabilityString=disabilityString+masMedicalExaminationDetail.getPrincipal();
    					check++;
    				}else
    				{
    					disabilityString=disabilityString+","+masMedicalExaminationDetail.getPrincipal();
    				}
    			 }
    		
    		   }
    	     	disabilityList.add(disabilityString);
    	     	disabilityIdList.add(medExamId);
        	}else
        	{
        		disabilityList.add(disabilityString);
        		disabilityIdList.add(medExamId);
        	}
          }*/
        }
       
        map.put("disabilityList",disabilityList);
        map.put("disabilityIdList",disabilityIdList);
        map.put("masMedicalExamDetailsList",masMedicalExamDetailsList);
         return map;

	}
	/**
	 * By Ritu Getting Annual Exam Data from HIC
	 */
	public Map<String, Object> getPrevMedExamFromHIC(Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = (String) mapForDS.get("serviceNo");
		Session session = (Session)getSession();
		try {
			Connection con = null;
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
		
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
			Calendar calendar = Calendar.getInstance();
			
			if(hicDbConfigure.equals("yes")) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
				con = DriverManager.getConnection(hicDB, hicUser, hicPwd);
				
				OracleCallableStatement oraCallStmt   = null;
		        OracleResultSet medExamResultSet = null;
		        oraCallStmt = (OracleCallableStatement) con.prepareCall(
		            "{call SMC_HIC_GETFORM3BINFO(?,?)}"
		            );
		            oraCallStmt.setString(1, serviceNo);
		            oraCallStmt.registerOutParameter(2, OracleTypes.CURSOR);
		            oraCallStmt.execute();
		            String pt = "^/d*$";
	    			
		            medExamResultSet = (OracleResultSet) oraCallStmt.getCursor(2);
		          //  map.put("medExamResultSet", medExamResultSet);
		            //  oraCallStmt.close();
		            while(medExamResultSet.next()){
		            	if(!medExamResultSet.isBeforeFirst()){
		            	if(medExamResultSet.getDate(36)!=null){
			            	calendar.setTime(medExamResultSet.getDate(36));
			            	int year = calendar.get(Calendar.YEAR);
			            	 // String qry = "select * from mas_medical_examination_report where serviceno='"+serviceNo+"' and " +
			          // 		"to_char(date_of_reporting,'yyyy')="+year;
							
			            	medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
			            	.add(Restrictions.eq("ServiceNo", serviceNo))
			            	.add(Restrictions.sqlRestriction("to_char(date_of_reporting,'yyyy')="+year)).list();
			            		/*session.createSQLQuery(qry).list();
		medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
			            			.add(Restrictions.eq("Serviceno", serviceNo)).add(Restrictions.eq("to_char(DateOfReporting)", currentYear)).list();*/
			           
			            	
			            	if(medExamList.size() == 0){
						
			            	MasMedicalExaminationReportOnEntry medExam = new MasMedicalExaminationReportOnEntry();
			            	medExam.setDateOfReporting(medExamResultSet.getDate(36));
	//		            	medExam.setAuthority("");
			            	medExam.setServiceNo(medExamResultSet.getString(1));
			            	if(medExamResultSet.getString(14)!=null)
			            	{
				            	MasRank rank=new MasRank();
				            	List<MasRank>  rankList= new ArrayList<MasRank>();
				            	rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("HicCode", medExamResultSet.getString(14)).ignoreCase()).list();
				            //	String rankQry = " select * from mas_rank where upper(hic_code) = upper('"+ medExamResultSet.getString(14)+"')";
				            //	rankList = session.createSQLQuery(rankQry).list();
				            	if(rankList.size()>0)
				            	{
				            		rank=rankList.get(0);
				            		medExam.setRank(rank);
				            	}
			            	}
	
			            	medExam.setNameInFull(medExamResultSet.getString(2));
			            	if(medExamResultSet.getString(15)!=null)
			            	{
				            	MasUnit unit=new MasUnit();
				            	List<MasUnit>  unitList= new ArrayList<MasUnit>();
				            	unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("HicCode", medExamResultSet.getString(15))).list();
				            	if(unitList.size() >0)
				            	{
				            		unit=unitList.get(0);
				            		medExam.setUnit(unit);
				            	}
			            	
			            	}
	
			            	medExam.setServiceiaf(medExamResultSet.getString(8));
			            	if(medExamResultSet.getString(16)!=null)
			            	{
				            	MasTrade trade=new MasTrade();
				            	List<MasTrade>  tradeList= new ArrayList<MasTrade>();
				            	tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("HicCode", medExamResultSet.getString(16))).list();
				            	if(tradeList.size() >0)
				            	{
				            		trade=tradeList.get(0);
				            		medExam.setTrade(trade);
				            	}
			            	
			            	}
			            	medExam.setDateOfBirth(medExamResultSet.getDate(4));
			            	medExam.setTypeofcommision(medExamResultSet.getString(11));
			            	medExam.setDateofcommun(medExamResultSet.getDate(12));
			            	medExam.setTotalService(medExamResultSet.getString(18));
			            	medExam.setPastmedicalhistory(medExamResultSet.getString(30));
			            	medExam.setPresentmedicalhistory(medExamResultSet.getString(31));
			            	medExam.setLastConfinementDate(medExamResultSet.getDate(34));
			            	medExam.setLastame(medExamResultSet.getString(33));
			            	medExam.setTotalTeeth(medExamResultSet.getString(49));
			            	if(medExamResultSet.getString(45) != null && Pattern.matches(pt, medExamResultSet.getString(45)))
			            	medExam.setTotalDefectiveTeeth(medExamResultSet.getString(45));
			            	medExam.setTotalNoDentalPoint(medExamResultSet.getString(46));
	//		            	medExam.setMissingTeeth(missingTeeth);
	//		            	medExam.setUnservisableTeeth(unservisableTeeth);
			            	medExam.setConditionOfGums(medExamResultSet.getString(48));
			            	medExam.setRemarksTeath(medExamResultSet.getString(47));
			            	medExam.setHeight(new BigDecimal(medExamResultSet.getString(72)));
			            	medExam.setWeight(new BigDecimal(medExamResultSet.getString(73)));
			            	medExam.setIdealweight(medExamResultSet.getString(74));
			            	medExam.setOverweight(medExamResultSet.getString(75));
			            	medExam.setWaist(medExamResultSet.getString(78));
			            	medExam.setChestfullexpansion(medExamResultSet.getString(91));
			            	medExam.setRangeofexpansion(medExamResultSet.getString(92));
			            	medExam.setBhi(medExamResultSet.getString(77));
	//		            	medExam.setBodyfat(bodyfat)                //not available in HIC
	//		            	medExam.setSkin(skin)                       //not available in HIC
	//		            	medExam.setSportman(sportman)				 //not available in HIC
			            	medExam.setWithGlassesRDistant(medExamResultSet.getString(112));
			            	medExam.setWithGlassesLDistant(medExamResultSet.getString(113));
			               	medExam.setWithGlassesRNearvision(medExamResultSet.getString(116));
			               	medExam.setWithGlassesLNearvision(medExamResultSet.getString(117));
			               	medExam.setWthoutGlassesRDistant(medExamResultSet.getString(110));
			            	medExam.setWithoutGlassesLDistant(medExamResultSet.getString(111));
			               	medExam.setWithoutGlassesRNearvision(medExamResultSet.getString(114));
			               	medExam.setWithoutGlassesLNearvision(medExamResultSet.getString(115));
	//		               	medExam.setNearVisionWithGlassCp(nearVisionWithGlassCp);    //not available in HIC
	//		               	medExam.setNearVisionWithoutGlassCp(nearVisionWithoutGlassCp); //not available in HIC
			               	medExam.setHearingRcv(new BigDecimal(medExamResultSet.getString(121)));
			    			medExam.setHearingLcv(new BigDecimal(medExamResultSet.getString(126)));
			    			medExam.setEarHearingRfw(new BigDecimal(medExamResultSet.getString(120)));
			    			medExam.setEarHearingLfw(new BigDecimal(medExamResultSet.getString(125)));
			    			medExam.setEarHearingBothFw(new BigDecimal(medExamResultSet.getString(129)));
			    			medExam.setHearingBothCv(new BigDecimal(medExamResultSet.getString(130)));
			    			
			    			medExam.setTympanicR(medExamResultSet.getString(122));
			    			medExam.setTympanicL(medExamResultSet.getString(127));
	//		    			medExam.setMobility(medExamResultSet.getString(122))  //two columns for left and right ear in HIC
			    			medExam.setNosethroat(medExamResultSet.getString(131));
			    			medExam.setAudiometryRecord(medExamResultSet.getString(124));
	//		    		investigation details
			    			medExam.setEcg(medExamResultSet.getString(56));
			    			medExam.setXray(medExamResultSet.getString(70));
			    			medExam.setHb(medExamResultSet.getString(50));
			    			medExam.setTlc(medExamResultSet.getString(51));
			    			medExam.setDlc(medExamResultSet.getString(52));
			    			medExam.setEsr(medExamResultSet.getString(53));
			    			medExam.setCholesterol(medExamResultSet.getString(64));
			    			medExam.setTriglycerides(medExamResultSet.getString(65));
			    			medExam.setHld(medExamResultSet.getString(66));
			    			medExam.setVldl(medExamResultSet.getString(67));
			    			medExam.setLdl(medExamResultSet.getString(68));			    			
			    			medExam.setSourceOfData("HIC");
			    			medExam.setMedicalExamType("Annual Medical Exam(AFMSF-3B)");
			    			medExam.setMedicalType("MedicalExam");
			    			medExam.setStatus("f");
			    			medExam.setPulseRates(medExamResultSet.getString(81));
			    			medExam.setBp(medExamResultSet.getString(85));
	//		    			medExam.setArterialWalls(medExamResultSet.getString(185));   //not available in HIC
			    			medExam.setHeartSize(medExamResultSet.getString(83));
			    			medExam.setSounds(medExamResultSet.getString(84));
			    			medExam.setRhythm(medExamResultSet.getString(86));
			    			medExam.setRespiratorySystem(medExamResultSet.getString(93)); //not available in HIC
			    			medExam.setLiver(medExamResultSet.getString(95));
			    			medExam.setSpleen(medExamResultSet.getString(97));
			    			medExam.setHigherMentalFunction(medExamResultSet.getString(98));
			    			medExam.setSpeech(medExamResultSet.getString(100));
			    			medExam.setReflexes(medExamResultSet.getString(99));
			    			medExam.setTremors(medExamResultSet.getString(101));
			    			medExam.setSelfBalancingTest(medExamResultSet.getString(102));
			    			medExam.setLocomoterSystem(medExamResultSet.getString(103));
			    			medExam.setSpine(medExamResultSet.getString(104));
			    			medExam.setHerniaMusic(medExamResultSet.getString(105));
			    			medExam.setHydrocele(medExamResultSet.getString(106));
			    			medExam.setHemorrhoids(medExamResultSet.getString(107));
			    			medExam.setBreasts(medExamResultSet.getString(108));		           
			    			medExam.setMenstrualHistory(medExamResultSet.getString(146));
//			    			medExam.setLmp(medExamResultSet.getString(153));   //Date in HIC and varchar in SMC
			    		//	medExam.setLmp("");
			    			if(medExamResultSet.getString(147)!=null)
			    				medExam.setNoOfPregnancies(Integer.parseInt(medExamResultSet.getString(147)));	
			    			if(medExamResultSet.getString(148)!=null && Pattern.matches(pt, medExamResultSet.getString(148)))
			    				medExam.setNoOfAbortions(Integer.parseInt(medExamResultSet.getString(148)));
			    			if(medExamResultSet.getString(149)!=null)
			    				medExam.setNoOfChildren(Integer.parseInt(medExamResultSet.getString(149)));
			    			if(medExamResultSet.getDate(150)!=null)
			    				medExam.setLastConfinementDate(medExamResultSet.getDate(150));
			    			if(medExamResultSet.getString(151)!=null)
			    				medExam.setVaginalDischarge(medExamResultSet.getString(151));
			    			if(medExamResultSet.getString(152)!=null)
			    				medExam.setProlapse(medExamResultSet.getString(152));
			    			if(medExamResultSet.getString(154)!=null)
			    				medExam.setUsgAbdomen(medExamResultSet.getString(154));
	//		    			medExam.setGiveOn(giveOn)      //not available in HIC
	//		    			medExam.setBatchNo(batchNo)    //not available in HIC
	//		    			medExam.setDom(dom)            //not available in HIC
	//		    			medExam.setCoronaryRiskFactor(coronaryRiskFactor)     //not available in HIC
			    			String fmdm ="";
							if(medExamResultSet.getString(138)!=null){
								if(medExamResultSet.getString(138).equalsIgnoreCase("yes")){
									fmdm = "Malignancy";
								}
							}
							if(medExamResultSet.getString(142)!=null){
								if(medExamResultSet.getString(142).equalsIgnoreCase("yes")){
									fmdm = "Hyperlypidemia";
								}
							}
							if(medExamResultSet.getString(143)!=null){
								if(medExamResultSet.getString(143).equalsIgnoreCase("yes")){
									fmdm = "Arthritis";
								}
							}
										    			
			    			medExam.setFmdm(fmdm);
			    			medExam.setAllergies(medExamResultSet.getString(140));
	//		    			medExam.setFinalObservation(finalObservation)  //not available in HIC
	//		    			medExam.setMedCatRec(medCatRec)               //not available in HIC
	//		    			medExam.setSignedBy(signedBy)
			    			medExam.setApprovedBy(medExamResultSet.getString(40));
	//		    			medExam.setSendTo(sendTo)    //not available in HIC
	//		    			medExam.setRemarks(remarks)
			    			if(medExamResultSet.getString(165)!= null)
			    				medExam.setDataOfNurveHic(medExamResultSet.getString(165));
			    			try {
								hbt.save(medExam);
							} catch (DataAccessException e) {
								
								e.printStackTrace();
							}
			            }else{
			            }
			            }
		            	}
		            }
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
			
			/**
			 * End
			 */

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		return map;
	}

	@Override
	public Map<String, Object> getPrevMedExamFromSMC(Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session =(Session)getSession();
		List<Object> tempList = null;
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map connMap = HMSUtil.getConnectionForReportForHIS();
		Connection conn = (Connection) connMap.get("conn");
		Statement st = null;
		ResultSet rs = null;
		Statement st1 = null;
		ResultSet rs1 = null;
		try{
			st = conn.createStatement();
			st1 = conn.createStatement();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		String serviceNo = (String) mapForDS.get("serviceNo");
		String hinNo = (String) mapForDS.get("hinNo");
		
		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("ServiceNo", serviceNo))
		  .add(Restrictions.eq("Status", "v")).addOrder(Order.desc("Id")).list();
		
		if(medExamList.size() > 0){
			map.put("medExamList",medExamList);
		}
		
		String query = "SELECT distinct id, md_req_id, md_exam_date, unit_name, weight, bp, md_cat_name, rank_name, md_exam_type, hospital_name, md_exam_type_id, db_flag " +
				 " FROM ( " +
				"SELECT md_exam_assistant.id AS id,md_exam_request.id AS md_req_id,md_exam_assistant.date_of_exam AS md_exam_date,mas_unit.unit_name AS unit_name,"+
				"md_exam_assistant.weight AS weight, md_exam_assistant.cardio_bp AS bp,mas_medical_category.medical_category_name AS md_cat_name," +
				" mas_rank.rank_name AS rank_name,md_exam_type.md_exam_type_name AS md_exam_type,mas_hospital.hospital_name AS hospital_name,md_exam_type.id AS md_exam_type_id,'his' as db_flag " +
				"FROM md_exam_assistant LEFT JOIN mas_medical_category ON mas_medical_category.medical_category_id=md_exam_assistant.medical_cat_id "+
				"LEFT JOIN md_exam_request ON md_exam_request.id=md_exam_assistant.md_exam_id LEFT JOIN md_exam_type ON md_exam_type.id=" +
				"md_exam_request.md_exam_type LEFT JOIN patient ON patient.hin_id=md_exam_request.hin_id LEFT JOIN mas_unit ON patient.unit_id=" +
				"mas_unit.unit_id LEFT JOIN mas_rank ON patient.rank_id=mas_rank.rank_id LEFT JOIN mas_hospital ON mas_hospital.hospital_id=" +
				"md_exam_request.hospital_id WHERE patient.hin_no='"+hinNo +"'"+
				"UNION ALL " +
				"SELECT md_exam_assistant_form2.id AS id,md_exam_request.id AS md_req_id, md_exam_assistant_form2.date_of_exam AS md_exam_date, " +
				"mas_unit.unit_name AS unit_name, md_exam_physical_detail_form2.actual_weight AS weight, md_exam_physical_detail_form2.bp AS bp," +
				" null AS md_cat_name, mas_rank.rank_name AS rank_name, md_exam_type.md_exam_type_name AS md_exam_type,mas_hospital.hospital_name" +
				" AS hospital_name,md_exam_type.id AS md_exam_type_id,'his' as db_flag FROM md_exam_assistant_form2 left join md_exam_physical_detail_form2 on md_exam_physical_detail_form2.md_exam_id =" +
				" md_exam_assistant_form2.md_exam_id LEFT JOIN md_exam_request ON md_exam_request.id=md_exam_assistant_form2.md_exam_id " +
				"LEFT JOIN md_exam_type ON md_exam_type.id=md_exam_request.md_exam_type LEFT JOIN patient ON patient.hin_id=md_exam_request.hin_id " +
				"LEFT JOIN mas_unit  ON patient.unit_id=mas_unit.unit_id LEFT JOIN mas_rank ON patient.rank_id=mas_rank.rank_id " +
				"LEFT JOIN mas_hospital ON mas_hospital.hospital_id=md_exam_request.hospital_id WHERE patient.hin_no='"+hinNo +"'"+
				" ORDER BY md_exam_date DESC )";
				
			
		
		
		List<Object[]> medExamListHIS = new ArrayList<Object[]>();
		try{
			if(conn !=  null)
			{
			rs = st.executeQuery(query);
			int n = rs.getMetaData().getColumnCount();
			while(rs.next()){
				tempList = new ArrayList<Object>();
				for(int i=1; i<=n; i++){
					tempList.add(rs.getString(i));
				}
				medExamListHIS.add(tempList.toArray());
			}
		}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
		System.out.println("medExamList="+medExamList.size());
		System.out.println("medExamListHIS="+medExamListHIS.size());
		map.put("medExamListHIS",medExamListHIS);
		return map;
	}

	@Override
	public Map<String, Object> getPrevMedBoardFromSMC(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session =(Session)getSession();
		String serviceNo = (String) mapForDS.get("serviceNo");
		
		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("ServiceNo", serviceNo))
		  .add(Restrictions.eq("medicalType", "MedicalBoard")).addOrder(Order.desc("Id")).list();
		
		if(medExamList.size() > 0){
			map.put("medExamList",medExamList);
		}
		
		System.out.println("medExamList="+medExamList.size());
		
		return map;
	}

	public Map<String, Object> getPrevMedBoardFromHIC(Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = (String) mapForDS.get("serviceNo");
		Session session = (Session)getSession();
		Transaction tx = null;

		try {
			Connection con = null;
			tx = session.beginTransaction();
			Properties properties = new Properties();
			URL resourcePathHIC = Thread.currentThread().getContextClassLoader().getResource("hicDetails.properties");
			
				properties.load(resourcePathHIC.openStream());
			
			String hicDB = properties.getProperty("hicDB");
			String hicUser = properties.getProperty("hicUser");
			String hicPwd = properties.getProperty("hicPwd");
			String hicDbConfigure =  properties.getProperty("hicDbConfigure");
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);			
			List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
			Calendar calendar = Calendar.getInstance();
			
			if(hicDbConfigure.equals("yes")) {
				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
				con = DriverManager.getConnection(hicDB, hicUser, hicPwd);
				
				OracleCallableStatement oraCallStmt   = null;
		        OracleResultSet medExamResultSet = null;
		        oraCallStmt = (OracleCallableStatement) con.prepareCall(
		                "{call SMC_HIC_GETFORM15INFO(?,?)}"
		            );
		            oraCallStmt.setString(1, serviceNo);
		            oraCallStmt.registerOutParameter(2, OracleTypes.CURSOR);
		            oraCallStmt.execute();
		            String pt = "^/d*$";
	    			
		            medExamResultSet = (OracleResultSet) oraCallStmt.getCursor(2);
		           
		            while(medExamResultSet.next()){
		            	if(medExamResultSet.getDate(57)!=null){
			            	calendar.setTime(medExamResultSet.getDate(57));
			            	int year = calendar.get(Calendar.YEAR);
			            	SimpleDateFormat sdf = new SimpleDateFormat("mm-dd-yyyy");
			            	Date medDate=medExamResultSet.getDate(57);
			          
			            medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
			            			.add(Restrictions.eq("YearlySerialNo", serviceNo))
			            			.add(Restrictions.eq("DateValidated", medExamResultSet.getDate(57))).add(Restrictions.eq("medicalType", "MedicalBoard")).list();
			           
			            	
			            	if(medExamList.size() == 0){
			            	MasMedicalExaminationReportOnEntry medExam = new MasMedicalExaminationReportOnEntry();
			            	if(medExamResultSet.getDate(19)!=null)
			            	medExam.setDateOfReporting(medExamResultSet.getDate(19));
	//		            	medExam.setAuthority("");
			            	medExam.setServiceNo(serviceNo);
			            	medExam.setYearlySerialNo(serviceNo);
	//		            	medExam.setRank(rank);
			            	if(medExamResultSet.getString(19)!=null)
			            	medExam.setNameInFull(medExamResultSet.getString(1));
			            	if(medExamResultSet.getString(19)!=null)
			            	medExam.setNameInFull(medExamResultSet.getString(14));
			            	if(medExamResultSet.getString(14)!=null)
			            	{
			            	MasUnit unit=new MasUnit();
			            	List<MasUnit>  unitList= new ArrayList<MasUnit>();
			            	if(medExamResultSet.getString(14)!=null)
			            	unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("HicCode", medExamResultSet.getString(14))).list();
			            	if(unitList.size()>0)
			            	{
			            		unit=unitList.get(0);
			            		medExam.setUnit(unit);
			            	}
			            	
			            	}
			            	if(medExamResultSet.getString(12)!=null)
			            	medExam.setServiceiaf(medExamResultSet.getString(12));
	//		            	medExam.setTrade(trade);
			            	if(medExamResultSet.getDate(4)!=null)
			            	medExam.setDateOfBirth(medExamResultSet.getDate(4));
			            	if(medExamResultSet.getString(10)!=null)
			            	medExam.setTypeofcommision(medExamResultSet.getString(10));
			            	if(medExamResultSet.getDate(11)!=null)
			            	medExam.setDateofcommun(medExamResultSet.getDate(11));
			            	if(medExamResultSet.getString(16)!=null)
			            	medExam.setTotalService(medExamResultSet.getString(16));
			            	if(medExamResultSet.getString(17)!=null)
			            	medExam.setPastmedicalhistory(medExamResultSet.getString(17));
			            	if(medExamResultSet.getDate(19)!=null)
			            	medExam.setOpiniondate(medExamResultSet.getDate(19));
			            	if(medExamResultSet.getDate(57)!=null)
			            	medExam.setDateValidated(medExamResultSet.getDate(57));
			            	List<Category>  catList= new ArrayList<Category>();
			            	Category cate;
			            	if(medExamResultSet.getString(18)!=null)
			            	catList = session.createCriteria(Category.class).add(Restrictions.eq("Categories", medExamResultSet.getString(18))).list();
			            	if(catList.size()>0)
			            	{
			            		cate=catList.get(0);
			            	medExam.setPresentMedicalCategory(cate);
			            	}
			            	List<Disability>  disList= new ArrayList<Disability>();
			            	Disability dis;
			            	if(medExamResultSet.getString(52)!=null)
			        	    disList = session.createCriteria(Disability.class).add(Restrictions.eq("Disability", medExamResultSet.getString(52))).list();
			            	if(disList.size()>0)
			            	{
			         		dis=disList.get(0);
			            	medExam.setPastDisability(dis);
			            	}
			            	if(medExamResultSet.getDate(20)!=null)
			                medExam.setCeaseduty(medExamResultSet.getDate(20));
			            	medExam.setCaseSheet(medExamResultSet.getString(40));
			            	medExam.setDisability(medExamResultSet.getString(41));
			            	medExam.setDisabilityAttribute(medExamResultSet.getString(42));
			            	medExam.setAggravatedService(medExamResultSet.getString(43));
			            	medExam.setAggravatedServiceDesc(medExamResultSet.getString(44));
			            	medExam.setMedicalType("MedicalBoard");
			            	medExam.setSourceOfData("HIC");
			            	medExam.setMedicalExamType("Initial Medical Board AFMSF 15");
			    			medExam.setStatus("p");
			            //	medExam.setPresentmedicalhistory(medExamResultSet.getString(31));
			            	medExam.setCategorydate(medExamResultSet.getDate(46));
			            	medExam.setCategoryplace(medExamResultSet.getString(50));
			            	medExam.setRecordoffice(medExamResultSet.getString(47));
			            	//if(medExamResultSet.getString(45) != null && Pattern.matches(pt, medExamResultSet.getString(45)))
			            	medExam.setPermanentAddress(medExamResultSet.getString(48));
			            	medExam.setReasopnsvariation(medExamResultSet.getString(54));
	                        medExam.setRestrictionemployment(medExamResultSet.getString(55));
			            	medExam.setInstructionByPresident(medExamResultSet.getString(56));
			            	medExam.setHeight(new BigDecimal(medExamResultSet.getString(7)));
			            	if(medExamResultSet.getString(8)!=null)
			            	medExam.setWeight(new BigDecimal(medExamResultSet.getString(8)));
			            	hbt.save(medExam);    
								
							OracleCallableStatement oraCallStmt1   = null;
						    OracleResultSet medExamResultSet1 = null;
						    oraCallStmt1 = (OracleCallableStatement) con.prepareCall(
						                "{call SMC_HIC_GETDISABILITIES(?,?)}"
						            );
						    oraCallStmt1.setString(1, serviceNo);
						    oraCallStmt1.registerOutParameter(2, OracleTypes.CURSOR);
						    oraCallStmt1.execute();
						    String pt1 = "^/d*$";
					    			
						    medExamResultSet1 = (OracleResultSet) oraCallStmt1.getCursor(2);
						            
						            while(medExamResultSet1.next()){
						            	  
						    MasMedicalExaminationDetail masDetail =new MasMedicalExaminationDetail();
						    if(medExamResultSet1.getString(1)!=null)
						    masDetail.setPrincipal(medExamResultSet1.getString(1));
						    masDetail.setParticular("detail");
						    masDetail.setMasMedicalReport(medExam);
						    hbt.save(masDetail);  
						            }
						       
								tx.commit();
                        }else{
			            }
			            }
		            	}
			}
		           // }
			
			} catch (Exception e) {
				if (tx != null)
					tx.rollback();
				session.close();
				e.printStackTrace();
			}
			
			
		
	
		return map;
	}

/**
 * Code for getting Form 2A data from HIC DB
 * Ritu	
 */

	public Map<String, Object> getPrevForm2AFromHIC(Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = (String) mapForDS.get("serviceNo");
		Session session = (Session)getSession();
		try {
			Connection con = null;
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
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
			Calendar calendar = Calendar.getInstance();

			try {
				if(hicDbConfigure.equals("yes")) {
				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
				con = DriverManager.getConnection(hicDB, hicUser, hicPwd);

				OracleCallableStatement oraCallStmt   = null;
				OracleResultSet medExamResultSet = null;
				oraCallStmt = (OracleCallableStatement) con.prepareCall(
						"{call SMC_HIC_GetForm2AInfo(?,?)}"
				);
				oraCallStmt.setString(1, serviceNo);
				oraCallStmt.registerOutParameter(2, OracleTypes.CURSOR);
				oraCallStmt.execute();
				String pt = "^/d*$";

				medExamResultSet = (OracleResultSet) oraCallStmt.getCursor(2);
				//  map.put("medExamResultSet", medExamResultSet);
				//  oraCallStmt.close();
				while(medExamResultSet.next()){
					if(!medExamResultSet.isBeforeFirst()){
						if(medExamResultSet.getDate(36)!=null){
							calendar.setTime(medExamResultSet.getDate(36));
							int year = calendar.get(Calendar.YEAR);
							// Commented by Sanjay yadav
							/*String qry = "select * from mas_medical_examination_report where serviceno='"+serviceNo+"' and to_char(date_of_reporting,'yyyy')="+year;
							medExamList = session.createSQLQuery(qry).list();*/
							medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
		            			.add(Restrictions.eq("ServiceNo", serviceNo)).add(Restrictions.eq("to_char(DateOfReporting)", year)).list();


							if(medExamList.size() == 0){

								MasMedicalExaminationReportOnEntry medExam = new MasMedicalExaminationReportOnEntry();
								medExam.setDateOfReporting(medExamResultSet.getDate(36));
								//		            	medExam.setAuthority("");
								medExam.setServiceNo(medExamResultSet.getString(1));
								if(medExamResultSet.getString(14)!=null)
								{
									MasRank rank=new MasRank();
									List<MasRank>  rankList= new ArrayList<MasRank>();
									rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("HicCode", medExamResultSet.getString(14)).ignoreCase()).list();
									//	String rankQry = " select * from mas_rank where upper(hic_code) = upper('"+ medExamResultSet.getString(14)+"')";
									//	rankList = session.createSQLQuery(rankQry).list();
									if(rankList.size()>0)
									{
										rank=rankList.get(0);
										medExam.setRank(rank);
									}
								}

								medExam.setNameInFull(medExamResultSet.getString(2));
								if(medExamResultSet.getString(15)!=null)
								{
									MasUnit unit=new MasUnit();
									List<MasUnit>  unitList= new ArrayList<MasUnit>();
									unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("HicCode", medExamResultSet.getString(15))).list();
									if(unitList.size() >0)
									{
										unit=unitList.get(0);
										medExam.setUnit(unit);
									}

								}

								medExam.setServiceiaf(medExamResultSet.getString(8));
								if(medExamResultSet.getString(16)!=null)
								{
									MasTrade trade=new MasTrade();
									List<MasTrade>  tradeList= new ArrayList<MasTrade>();
									tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("HicCode", medExamResultSet.getString(16))).list();
									if(tradeList.size() >0)
									{
										trade=tradeList.get(0);
										medExam.setTrade(trade);
									}

								}
								medExam.setDateOfBirth(medExamResultSet.getDate(4));
								medExam.setTypeofcommision(medExamResultSet.getString(11));
								medExam.setDateofcommun(medExamResultSet.getDate(12));
								medExam.setTotalService(medExamResultSet.getString(18));
								medExam.setPastmedicalhistory(medExamResultSet.getString(30));
								medExam.setPresentmedicalhistory(medExamResultSet.getString(31));
								medExam.setLastConfinementDate(medExamResultSet.getDate(34));
								medExam.setLastame(medExamResultSet.getString(33));
								medExam.setTotalTeeth(medExamResultSet.getString(49));
								if(medExamResultSet.getString(45) != null && Pattern.matches(pt, medExamResultSet.getString(45)))
									medExam.setTotalDefectiveTeeth(medExamResultSet.getString(45));
								medExam.setTotalNoDentalPoint(medExamResultSet.getString(46));
								//		            	medExam.setMissingTeeth(missingTeeth);
								//		            	medExam.setUnservisableTeeth(unservisableTeeth);
								medExam.setConditionOfGums(medExamResultSet.getString(48));
								medExam.setRemarksTeath(medExamResultSet.getString(47));
								medExam.setHeight(new BigDecimal(medExamResultSet.getString(72)));
								medExam.setWeight(new BigDecimal(medExamResultSet.getString(73)));
								medExam.setIdealweight(medExamResultSet.getString(74));
								medExam.setOverweight(medExamResultSet.getString(75));
								medExam.setWaist(medExamResultSet.getString(78));
								medExam.setChestfullexpansion(medExamResultSet.getString(91));
								medExam.setRangeofexpansion(medExamResultSet.getString(92));
								medExam.setBhi(medExamResultSet.getString(77));
								//		            	medExam.setBodyfat(bodyfat)                //not available in HIC
								//		            	medExam.setSkin(skin)                       //not available in HIC
								//		            	medExam.setSportman(sportman)				 //not available in HIC
								medExam.setWithGlassesRDistant(medExamResultSet.getString(112));
								medExam.setWithGlassesLDistant(medExamResultSet.getString(113));
								medExam.setWithGlassesRNearvision(medExamResultSet.getString(116));
								medExam.setWithGlassesLNearvision(medExamResultSet.getString(117));
								medExam.setWthoutGlassesRDistant(medExamResultSet.getString(110));
								medExam.setWithoutGlassesLDistant(medExamResultSet.getString(111));
								medExam.setWithoutGlassesRNearvision(medExamResultSet.getString(114));
								medExam.setWithoutGlassesLNearvision(medExamResultSet.getString(115));
								//		               	medExam.setNearVisionWithGlassCp(nearVisionWithGlassCp);    //not available in HIC
								//		               	medExam.setNearVisionWithoutGlassCp(nearVisionWithoutGlassCp); //not available in HIC
								medExam.setHearingRcv(new BigDecimal(medExamResultSet.getString(121)));
								medExam.setHearingLcv(new BigDecimal(medExamResultSet.getString(126)));
								medExam.setEarHearingRfw(new BigDecimal(medExamResultSet.getString(120)));
								medExam.setEarHearingLfw(new BigDecimal(medExamResultSet.getString(125)));
								medExam.setEarHearingBothFw(new BigDecimal(medExamResultSet.getString(129)));
								medExam.setHearingBothCv(new BigDecimal(medExamResultSet.getString(130)));

								medExam.setTympanicR(medExamResultSet.getString(122));
								medExam.setTympanicL(medExamResultSet.getString(127));
								//		    			medExam.setMobility(medExamResultSet.getString(122))  //two columns for left and right ear in HIC
								medExam.setNosethroat(medExamResultSet.getString(131));
								medExam.setAudiometryRecord(medExamResultSet.getString(124));
								//		    		investigation details
								medExam.setEcg(medExamResultSet.getString(56));
								medExam.setXray(medExamResultSet.getString(70));
								medExam.setHb(medExamResultSet.getString(50));
								medExam.setTlc(medExamResultSet.getString(51));
								medExam.setDlc(medExamResultSet.getString(52));
								medExam.setEsr(medExamResultSet.getString(53));
								medExam.setCholesterol(medExamResultSet.getString(64));
								medExam.setTriglycerides(medExamResultSet.getString(65));
								medExam.setHld(medExamResultSet.getString(66));
								medExam.setVldl(medExamResultSet.getString(67));
								medExam.setLdl(medExamResultSet.getString(68));

								medExam.setSourceOfData("HIC");
								medExam.setPulseRates(medExamResultSet.getString(81));
								medExam.setBp(medExamResultSet.getString(85));
								//		    			medExam.setArterialWalls(medExamResultSet.getString(185));   //not available in HIC
								medExam.setHeartSize(medExamResultSet.getString(83));
								medExam.setSounds(medExamResultSet.getString(84));
								medExam.setRhythm(medExamResultSet.getString(86));
								medExam.setRespiratorySystem(medExamResultSet.getString(93)); //not available in HIC
								medExam.setLiver(medExamResultSet.getString(95));
								medExam.setSpleen(medExamResultSet.getString(97));
								medExam.setHigherMentalFunction(medExamResultSet.getString(98));
								medExam.setSpeech(medExamResultSet.getString(100));
								medExam.setReflexes(medExamResultSet.getString(99));
								medExam.setTremors(medExamResultSet.getString(101));
								medExam.setSelfBalancingTest(medExamResultSet.getString(102));
								medExam.setLocomoterSystem(medExamResultSet.getString(103));
								medExam.setSpine(medExamResultSet.getString(104));
								medExam.setHerniaMusic(medExamResultSet.getString(105));
								medExam.setHydrocele(medExamResultSet.getString(106));
								medExam.setHemorrhoids(medExamResultSet.getString(107));
								medExam.setBreasts(medExamResultSet.getString(108));		           
								medExam.setMenstrualHistory(medExamResultSet.getString(146));
								//		    			medExam.setLmp(medExamResultSet.getString(153));   //Date in HIC and varchar in SMC
								//medExam.setLmp("");
								if(medExamResultSet.getString(147)!=null)
									medExam.setNoOfPregnancies(Integer.parseInt(medExamResultSet.getString(147)));	
								if(medExamResultSet.getString(148)!=null && Pattern.matches(pt, medExamResultSet.getString(148)))
									medExam.setNoOfAbortions(Integer.parseInt(medExamResultSet.getString(148)));
								if(medExamResultSet.getString(149)!=null)
									medExam.setNoOfChildren(Integer.parseInt(medExamResultSet.getString(149)));
								if(medExamResultSet.getDate(150)!=null)
									medExam.setLastConfinementDate(medExamResultSet.getDate(150));
								if(medExamResultSet.getString(151)!=null)
									medExam.setVaginalDischarge(medExamResultSet.getString(151));
								if(medExamResultSet.getString(152)!=null)
									medExam.setProlapse(medExamResultSet.getString(152));
								if(medExamResultSet.getString(154)!=null)
									medExam.setUsgAbdomen(medExamResultSet.getString(154));
								//		    			medExam.setGiveOn(giveOn)      //not available in HIC
								//		    			medExam.setBatchNo(batchNo)    //not available in HIC
								//		    			medExam.setDom(dom)            //not available in HIC
								//		    			medExam.setCoronaryRiskFactor(coronaryRiskFactor)     //not available in HIC
								String fmdm ="";
								if(medExamResultSet.getString(138)!=null){
									if(medExamResultSet.getString(138).equalsIgnoreCase("yes")){
										fmdm = "Malignancy";
									}
								}
								if(medExamResultSet.getString(142)!=null){
									if(medExamResultSet.getString(142).equalsIgnoreCase("yes")){
										fmdm = "Hyperlypidemia";
									}
								}
								if(medExamResultSet.getString(143)!=null){
									if(medExamResultSet.getString(143).equalsIgnoreCase("yes")){
										fmdm = "Arthritis";
									}
								}

								medExam.setFmdm(fmdm);
								medExam.setAllergies(medExamResultSet.getString(140));
								//		    			medExam.setFinalObservation(finalObservation)  //not available in HIC
								//		    			medExam.setMedCatRec(medCatRec)               //not available in HIC
								//		    			medExam.setSignedBy(signedBy)
								medExam.setApprovedBy(medExamResultSet.getString(40));
								//		    			medExam.setSendTo(sendTo)    //not available in HIC
								//		    			medExam.setRemarks(remarks)
								if(medExamResultSet.getString(165)!= null)
									medExam.setDataOfNurveHic(medExamResultSet.getString(165));
								try {
									hbt.save(medExam);
								} catch (DataAccessException e) {
									
									e.printStackTrace();
								}
							}else{
							}
						}
					}
				}
				}
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}


			/**
			 * End
			 */

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showApprovingAWatingList(int hospitalId)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	    Criteria crit = null;   
	      
	      System.out.println("commandId in MedicalExam DataServiceLayer" +hospitalId);
	    // Commented by sanjay yadav
		/*rankList = getHibernateTemplate().find("from jkt.hms.masters.business.MasRank ");*/
	    rankList =  session.createCriteria(MasRank.class).list();
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
			   .createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId) )
				.add(Restrictions.eq("Status", "v")).add(Restrictions.eq("medicalType", "MedicalExam"))
				.addOrder(Order.desc("Id"));
				//.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
						

		  patientDetailList = crit.list();
		  System.out.println("patientDetailList======>For CommandId"+patientDetailList.size());
        map.put("patientDetailList", patientDetailList);		
		map.put("rankList", rankList);

		return map;
		}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showOCUnitWatingList(int hospitalId)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	    Criteria crit = null;
	    // Commented by sanjay yadav
		/*rankList = getHibernateTemplate().find("from jkt.hms.masters.business.MasRank ");*/
	    rankList = session.createCriteria(MasRank.class).list();
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.eq("Status", "o")).add(Restrictions.eq("medicalType", "MedicalExam"))
				.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
				.addOrder(Order.desc("Id"));

		  patientDetailList = crit.list();
        map.put("patientDetailList", patientDetailList);		
		map.put("rankList", rankList);

		return map;
		}

	
	public Map<String, Object> validateMedExamApprovingAuthority(Box box) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		int medExamId = box.getInt("medExamId");
		String aaFinalObservation=box.getString("aaFinalObservation");
		String aaRemarks=box.getString("aaRemarks");
		String aaSignedBy=box.getString("aaSignedBy");
		String aaSendTo=box.getString("aaSendTo");
		boolean successfullyAdded= false;
		HibernateTemplate hbt = getHibernateTemplate();
		String dataMessage=null;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
        
		try {
		
       hbt = getHibernateTemplate();
	   hbt.setFlushModeName("FLUSH_EAGER");
	   hbt.setCheckWriteOperations(false);
	   MasMedicalExaminationReportOnEntry masMedExam=(MasMedicalExaminationReportOnEntry)session.load(MasMedicalExaminationReportOnEntry.class,medExamId);
	   masMedExam.setStatus("a");	
	   /**
	    * Date Added by Ritu
	    * Using in monitoring module 
	    */
	   masMedExam.setAppAuthDate(HMSUtil.convertStringTypeDateToDateType(date));
	   /**
	    * End
	    */
	   
	   masMedExam.setAprovAuthFinalObservation(aaFinalObservation);
	   masMedExam.setApproAuthSendTo(aaSendTo);
	   masMedExam.setApprovAuthRemarks(aaRemarks);
	   masMedExam.setApprovAuthSignedBy(aaSignedBy);
	   hbt.update(masMedExam);	
	   map.put("masExamType",masMedExam.getMedicalExamType());
			successfullyAdded = true;
		} catch (DataAccessException e) 
		{
			e.printStackTrace();
		}
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}
 
	@Override
	public Map<String, Object> showMedicalExamPerAuthority(int hospitalId)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	    Criteria crit = null;
	    List<Object[]> unitList = null;
		/*rankList = getHibernateTemplate().find("from jkt.hms.masters.business.MasRank ");*/
	    rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y"))
	    					.add(Restrictions.eq("ServiceType.Id", 2)).addOrder(Order.asc("RankName")).list(); // for airforce service type id is 2 
		
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.eq("Status", "a")).add(Restrictions.eq("medicalType", "MedicalExam"))
				.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
				.addOrder(Order.desc("Id"));

		  patientDetailList = crit.list();
		  
		unitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(Order.asc("UnitName")).list();
        map.put("patientDetailList", patientDetailList);		
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		return map;
		}
	
	public Map<String, Object> validateMedExamPersusingAuthority(Map<String, Object> mapForDS) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		int medExamId = (Integer)mapForDS.get("medExamId");
		Date date= new Date();  
		
		   String currDate   = (String) mapForDS.get("date");
		   Date currentDate = HMSUtil.convertStringTypeDateToDateType((currDate ));
		String paFinalObservation=(String)mapForDS.get("paFinalObservation");
		String paRemarks=(String)mapForDS.get("paRemarks");
		String paSignedBy=(String)mapForDS.get("paSignedBy");
		String paSendTo=(String)mapForDS.get("paSendTo");
		boolean successfullyAdded= false;
		HibernateTemplate hbt = getHibernateTemplate();
		String dataMessage=null;
		Session session = (Session) getSession();
		
		try {
		
       hbt = getHibernateTemplate();
	   hbt.setFlushModeName("FLUSH_EAGER");
	   hbt.setCheckWriteOperations(false);
	   MasMedicalExaminationReportOnEntry masMedExam=(MasMedicalExaminationReportOnEntry)session.load(MasMedicalExaminationReportOnEntry.class,medExamId);
	  if(masMedExam.getMedicalExamType().equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)")||masMedExam.getMedicalExamType().equalsIgnoreCase("Primary/Extension Med. Exam(AFMSF-2A)"))
	  {	  
	   masMedExam.setStatus("f");
	  
	  }else if(masMedExam.getMedicalExamType().equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
	  {
		  masMedExam.setStatus("p");
	  }
	   masMedExam.setPerFinalObservation(paFinalObservation);
	   masMedExam.setPerApproAuthSendTo(paSendTo);
	   masMedExam.setPerAuthRemarks(paRemarks);
	   masMedExam.setPerApprovAuthSignedBy(paSignedBy);
	   masMedExam.setDateOfPerusing(currentDate);
	   hbt.update(masMedExam);	
		
			successfullyAdded = true;
		} catch (DataAccessException e) 
		{
			e.printStackTrace();
		}
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}
	public Map<String, Object> submitUploadDocuments(Map<String, Object> mapForDS) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String fileName = null;
		String fileExtension = null;
		int hinId =(Integer)mapForDS.get("hinId");
		int hospitalId =(Integer)mapForDS.get("hospitalId");
		int masMedicalExamId =(Integer)mapForDS.get("masMedicalExamId");
		int investigationId =(Integer)mapForDS.get("investigationId");
		fileName =(String)mapForDS.get("filename");
		fileExtension =(String)mapForDS.get("fileExtension");
		MultipartFormDataRequest mrequest =(MultipartFormDataRequest)mapForDS.get("mrequest");
	    boolean status=false;
		try
		{
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
        	File file = null;
			
			if (!fileName.equals("0")) 
			{
					java.util.Hashtable files = mrequest.getFiles();
					UploadFile file12 = (UploadFile) files.get(RequestConstants.UPLOAD_FILENAME);
					InputStream is=file12.getInpuStream();
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
					
					  while (offset < bytes.length && (numRead=is.read(bytes,
					  offset, bytes.length- offset)) >= 0) { offset += 1000;
					  if(offset>bytes.length) offset=offset-bytes.length; }
					 

					if (offset < bytes.length) {
						throw new IOException("Could not completely read file "
								+ file.getName());

					}

					is.close();
					// Close the input stream and return bytes
					MasMedicalUploadDocument masUploadDocuments = new MasMedicalUploadDocument();
					String dataInput = new String(bytes);
					masUploadDocuments.setFileName(fileName);
					masUploadDocuments.setFileExtension(fileExtension);
					masUploadDocuments.setDocument(bytes);
					DgMasInvestigation dgMasInvestigation=new DgMasInvestigation();
					dgMasInvestigation.setId(investigationId);
					masUploadDocuments.setDgMasInvestigation(dgMasInvestigation);
					Patient patient = new Patient();
					patient.setId(hinId);
					masUploadDocuments.setHin(patient);
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					masUploadDocuments.setHospital(masHospital);
					MasMedicalExaminationReportOnEntry masMedicalExamReport=new MasMedicalExaminationReportOnEntry();
					masMedicalExamReport.setId(masMedicalExamId);
					masUploadDocuments.setMasMedicalExamReport(masMedicalExamReport);
								
				    hbt.save(masUploadDocuments);
				    status=true;
				}

			
           
            }catch (Exception e)
            {
			  e.printStackTrace();
			  status=false;
		     }
            map.put("status", status);
		return map;

	}

	@Override
	public Map<String, Object> rejectMedExamAA(Box box)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		int medExamId = box.getInt("medExamId");
		String aaRemarks=box.getString("aaRemarks");
		String aaFinalObservation=box.getString("aaFinalObservation");
		String aaSignedBy=box.getString("aaSignedBy");
		
		boolean successfullyAdded= false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			MasMedicalExaminationReportOnEntry masMedExam = new MasMedicalExaminationReportOnEntry();
			masMedExam = loadMedicalExamObj(medExamId);
			masMedExam.setStatus("m");
			masMedExam.setRejectStatus("r");
			masMedExam.setRejectDate(new Date());
			masMedExam.setApprovAuthRemarks(aaRemarks);
			masMedExam.setApprovAuthSignedBy(aaSignedBy);
			masMedExam.setAprovAuthFinalObservation(aaFinalObservation);
			
			if(masMedExam.getMedicalExamType().equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
			{	
			 masMedExam.setPriority(71);	
			}else
			{
				masMedExam.setPriority(7);
			}
			 /*if(masMedExam.getPriority()!=null){
	    		 if(masMedExam.getPriority()==4){
	    			 masMedExam.setPriority(7);		 
	    		 }else if(masMedExam.getPriority()==5){
	    			 masMedExam.setPriority(8);		 
	    		 }else if(masMedExam.getPriority()==6){
	    			 masMedExam.setPriority(9);		 
	    		 }
	    	 }*/
			
			//masMedExam.setPriority(4);
			hbt.update(masMedExam);
			map.put("masExamType",masMedExam.getMedicalExamType());
	        successfullyAdded = true;
		} catch (DataAccessException e)
		{
			e.printStackTrace();
			successfullyAdded = false;
		}
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}
	public Map<String, Object> rejectMedExamPA(Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		int medExamId =(Integer)dataMap.get("medExamId");
		String paRemarks =(String)dataMap.get("paRemarks");
		String paFinalObservation =(String)dataMap.get("paFinalObservation");
		String paSignedBy =(String)dataMap.get("paSignedBy");
		boolean successfullyAdded= false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			MasMedicalExaminationReportOnEntry masMedExam = new MasMedicalExaminationReportOnEntry();
			masMedExam = loadMedicalExamObj(medExamId);
			if(masMedExam.getMedicalExamType().equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
			{
				masMedExam.setStatus("o");
				
			}else{
			     masMedExam.setStatus("v");
			}
			masMedExam.setRejectStatus("r");
			masMedExam.setRejectDate(new Date());
			masMedExam.setPerFinalObservation(paFinalObservation);
			masMedExam.setPerApprovAuthSignedBy(paSignedBy);
			masMedExam.setPerAuthRemarks(paRemarks);
		    masMedExam.setPriority(8);		 
	    		
			/*if(masMedExam.getPriority()!=null){
	    		 if(masMedExam.getPriority()==4){
	    			 masMedExam.setPriority(7);		 
	    		 }else if(masMedExam.getPriority()==5){
	    			 masMedExam.setPriority(8);		 
	    		 }else if(masMedExam.getPriority()==6){
	    			 masMedExam.setPriority(9);		 
	    		 }
	    	 }
			*/
			//masMedExam.setPriority(6);
			hbt.update(masMedExam);
	        successfullyAdded = true;
		} catch (DataAccessException e)
		{
			e.printStackTrace();
			successfullyAdded = false;
		}
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}
	
	public Map<String, Object> viewUploadJsp(Map<String, Object> mapForDS) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String fileName = null;
		String fileExtension = null;
		int hinId =(Integer)mapForDS.get("hinId");
		int hospitalId =(Integer)mapForDS.get("hospitalId");
		int masMedicalExamId =(Integer)mapForDS.get("masExamId");
		int investigationId =(Integer)mapForDS.get("InvestId");
		try 
		{
		    List<MasMedicalUploadDocument> masMedicalUploadDocumentList=session.createCriteria(MasMedicalUploadDocument.class).add(Restrictions.eq("MasMedicalExamReport.Id",masMedicalExamId))
		    .add(Restrictions.eq("Hin.Id", hinId)).add(Restrictions.eq("DgMasInvestigation.Id", investigationId)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		    
		    map.put("masMedicalUploadDocumentList", masMedicalUploadDocumentList);
			
		}catch (Exception e)
		{
		  e.printStackTrace();
		}			
        return map;

	}
	public Map<String, Object> viewUploadInvestDocument(Map<String, Object> mapForDS) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int hinId =(Integer)mapForDS.get("hinId");
		int hospitalId =(Integer)mapForDS.get("hospitalId");
		String filename =(String)mapForDS.get("filename");
		String fileExtension =(String)mapForDS.get("fileExtension");
		int investigationId =(Integer)mapForDS.get("invest_id");
		int masMedicalExamId =(Integer)mapForDS.get("medExamId");
		 
		try 
		{
		    List<MasMedicalUploadDocument> masMedicalUploadDocumentList=session.createCriteria(MasMedicalUploadDocument.class).add(Restrictions.eq("MasMedicalExamReport.Id",masMedicalExamId))
		    .add(Restrictions.eq("Hin.Id", hinId)).add(Restrictions.eq("DgMasInvestigation.Id", investigationId)).add(Restrictions.eq("Hospital.Id", hospitalId))
		    .add(Restrictions.eq("FileName", filename)).add(Restrictions.eq("FileExtension", fileExtension))
		    .list();
		    
		    map.put("masMedicalUploadDocumentList", masMedicalUploadDocumentList);
			
		}catch (Exception e)
		{
		  e.printStackTrace();
		}			
        return map;

	}
	
	
	public Map<String, Object> showMedicalExamPerAuthorityAFRO(int hospitalId)
	{
		Map<String,Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	    Criteria crit = null;
	    // Commented by sanjay yadav
		/*rankList = getHibernateTemplate().find("from jkt.hms.masters.business.MasRank ");*/
	    rankList = session.createCriteria(MasRank.class).list();
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.eq("Status", "p")).add(Restrictions.eq("medicalType", "MedicalExam"))
				.add(Restrictions.eq("medicalExamType", "Med. Exam On Release/Discharge(AFMSF-18)")).createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
				.addOrder(Order.desc("Id"));
		patientDetailList = crit.list();
        map.put("patientDetailList", patientDetailList);		
		map.put("rankList", rankList);

		return map;
	
	}
	public Map<String, Object> validateMedExamPersusingAuthorityAFRO(Map<String, Object> mapForDS) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		int medExamId = (Integer)mapForDS.get("medExamId");
		
		String paFinalObservation=(String)mapForDS.get("paAFROFinalObservation");
		String paRemarks=(String)mapForDS.get("paAFRORemarks");
		String paSignedBy=(String)mapForDS.get("paAFROSignedBy");
		
		boolean successfullyAdded= false;
		HibernateTemplate hbt = getHibernateTemplate();
		String dataMessage=null;
		Session session = (Session) getSession();
		
		try {
		
       hbt = getHibernateTemplate();
	   hbt.setFlushModeName("FLUSH_EAGER");
	   hbt.setCheckWriteOperations(false);
	   MasMedicalExaminationReportOnEntry masMedExam=(MasMedicalExaminationReportOnEntry)session.load(MasMedicalExaminationReportOnEntry.class,medExamId);
	   masMedExam.setStatus("f");
	   
	   masMedExam.setPaAFROFinalObservation(paFinalObservation);
	   masMedExam.setPaAFRORemarks(paRemarks);
	   masMedExam.setPaAFROSignedBy(paSignedBy);
	 
	   hbt.update(masMedExam);	
		
			successfullyAdded = true;
		} catch (DataAccessException e) 
		{
			e.printStackTrace();
		}
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}
	public Map<String, Object> rejectMedExamPAAFRO(Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		int medExamId =(Integer)dataMap.get("medExamId");
		String paAFRORemarks =(String)dataMap.get("paAFRORemarks");
		String paFinalObservation=(String)dataMap.get("paAFROFinalObservation");
		String paSignedBy=(String)dataMap.get("paAFROSignedBy");
	
		boolean successfullyAdded= false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		try {
			MasMedicalExaminationReportOnEntry masMedExam = new MasMedicalExaminationReportOnEntry();
			masMedExam = loadMedicalExamObj(medExamId);
			masMedExam.setPaAFRORemarks(paAFRORemarks);
			masMedExam.setPaAFROFinalObservation(paFinalObservation);
			masMedExam.setPaAFROSignedBy(paSignedBy);
			masMedExam.setRejectStatus("r");
			masMedExam.setRejectDate(new Date());
			
			masMedExam.setStatus("a");
			masMedExam.setPriority(9);
			hbt.update(masMedExam);
	        successfullyAdded = true;
		} catch (DataAccessException e)
		{
			e.printStackTrace();
			successfullyAdded = false;
		}
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}
	public List<MasMedicalExaminationReportOnEntry> getMedicalExamRecord(int medExamId)
	{
		
		Session session =(Session)getSession();
		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		
		try
		{
		medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("Id", medExamId)).list();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return medExamList;
	}
	//----------------------- Dinesh Dubey ------------------------------------------------
	public Map<String, Object> getMedicalExamRegisterGraph(Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> medicalExamRegisterList = new ArrayList<Object[]>();
		Session session = (Session) getSession();
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		//String fromDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		//String toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		String subQry = "";
	    int hospitalId=(Integer)dataMap.get("hospitalId");
	    String fromYear=(String)dataMap.get("fromYear");
	    String toYear=(String)dataMap.get("toYear");
	    
	    String fromQtr1="'01-april-"+fromYear+"'";
	    String toQtr1="'30-june-"+fromYear+"'";
	    String fromQtr2="'01-july-"+fromYear+"'";
	    String toQtr2="'30-sep-"+fromYear+"'";
	    String fromQtr3="'01-oct-"+fromYear+"'";
	    String toQtr3="'31-dec-"+fromYear+"'";
	    String fromQtr4="'01-jan-"+toYear+"'";
	    String toQtr4="'31-march-"+toYear+"'";
	   
	try{	
		String qry ="(select distinct (select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr1+" and "+toQtr1+" and mmer.status='f' and mmer.hospital_id="+hospitalId +" and medicaltype='MedicalExam' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 20 and 30) qrt1,"+
       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr2+" and "+toQtr2+" and mmer.hospital_id="+hospitalId+" and mmer.status='f' and medicaltype='MedicalExam' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 20 and 30) qrt2,"+
       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr3+" and "+toQtr3+" and mmer.hospital_id="+hospitalId+" and mmer.status='f' and medicaltype='MedicalExam' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 20 and 30) qrt3,"+
       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr4+" and "+toQtr4+" and mmer.hospital_id="+hospitalId+" and mmer.status='f' and medicaltype='MedicalExam' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 20 and 30) qrt4,"+
       " '20' as name from  mas_medical_examination_report ) union "+
       "(select distinct (select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr1+" and "+toQtr1+" and mmer.hospital_id="+hospitalId +" and mmer.status='f' and medicaltype='MedicalExam' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 30 and 40) qrt1,"+
       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr2+" and "+toQtr2+" and mmer.hospital_id="+hospitalId+" and mmer.status='f' and medicaltype='MedicalExam' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 30 and 40) qrt2,"+
       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr3+" and "+toQtr3+" and mmer.hospital_id="+hospitalId+" and mmer.status='f' and medicaltype='MedicalExam' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 30 and 40) qrt3,"+
       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr4+" and "+toQtr4+" and mmer.hospital_id="+hospitalId+" and mmer.status='f' and medicaltype='MedicalExam' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 30 and 40) qrt4,"+
       "'30' as name from  mas_medical_examination_report) union "+
       "(select distinct (select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr1+" and "+toQtr1+" and mmer.hospital_id="+hospitalId +" and mmer.status='f' and medicaltype='MedicalExam' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 40 and 50) qrt1,"+
       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr2+" and "+toQtr2+" and mmer.hospital_id="+hospitalId+" and mmer.status='f' and medicaltype='MedicalExam' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 40 and 50) qrt2,"+
       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr3+" and "+toQtr3+" and mmer.hospital_id="+hospitalId+" and mmer.status='f' and medicaltype='MedicalExam' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 40 and 50) qrt3,"+
       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr4+" and "+toQtr4+" and mmer.hospital_id="+hospitalId+" and mmer.status='f' and medicaltype='MedicalExam' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 40 and 50) qrt4,"+
       " '40' as name from  mas_medical_examination_report) union "+
       "(select distinct (select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr1+" and "+toQtr1+" and mmer.hospital_id="+hospitalId +" and mmer.status='f' and medicaltype='MedicalExam' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 50 and 60) qrt1,"+
       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr2+" and "+toQtr2+" and mmer.hospital_id="+hospitalId+" and mmer.status='f' and medicaltype='MedicalExam' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 50 and 60) qrt2,"+
       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr3+" and "+toQtr3+" and mmer.hospital_id="+hospitalId+" and mmer.status='f' and medicaltype='MedicalExam' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 50 and 60) qrt3,"+
       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr4+" and "+toQtr4+" and mmer.hospital_id="+hospitalId+" and mmer.status='f' and medicaltype='MedicalExam' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 50 and 60) qrt4,"+
       " '50' as name from  mas_medical_examination_report) order by name";
		
		medicalExamRegisterList = session.createSQLQuery(qry).list();	
	}catch(HibernateException he)
	{
	  he.printStackTrace();	
	}	
	map.put("medicalExamRegisterList", medicalExamRegisterList);
	return map;	
	}
	// ---------------------------- start addMedicalExam for 2A-----------------------------------
	@Override
	public Boolean addMedicalExaminationBoardAnnual2A(	
			
			MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry,Map<String, Object> mapForDS)
	{
		String date = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		List<TransactionSequence> medicalWorkNoList = new ArrayList<TransactionSequence>();
        
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
			saveinvestigation=saveInvestigationAdd(mapForDS);			

			if (saveinvestigation) {
			hbt.save(masMedicalExaminationReportOnEntry);
			// hbt.refresh(masMedicalExaminationReportOnEntry);
			int visitId=(Integer) mapForDS.get("visitId");
	    
	      Visit visit=(Visit)session.get(Visit.class,visitId);
	     if(visit!=null)
	     {
	    	 visit.setPriority(1);
	    	 hbt.update(visit);
	     }
		
		successfullyAdded = true;
		medicalWorkNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "MED")).add(Restrictions.eq("Hospital.Id", (Integer)mapForDS.get("hospitalId"))).list();
		int hinId=(Integer)mapForDS.get("hinId");
		if(hinId!=0)
		{	
		   Patient patient=(Patient)session.load(Patient.class, hinId);
		   if(mapForDS.get("identification1")!=null )
			{	
			patient.setSrIdentificationMark1((String)mapForDS.get("identification1"));
			}
			if(mapForDS.get("identification2")!=null )
			{	
		    	patient.setSrIdentificationMark2((String)mapForDS.get("identification2"));
			}
			hbt.update(patient);
		}   
		if (successfullyAdded) {
			if(medicalWorkNoList.size() > 0){
			for (TransactionSequence transactionSequence : medicalWorkNoList) {
				TransactionSequence obj = transactionSequence;
				int id2 = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id2);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
				if (currentMonth.equalsIgnoreCase("01")) {
					transactionSequenceObj.setTransactionSequenceNumber(1);
					seqNo = 1;
				}
				hbt.update(transactionSequenceObj);
			}
			}else{
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("MasMedicalExamination");
				tsObj.setTransactionPrefix("MED");
				tsObj.setTransactionSequenceName("SerialNo");
				tsObj.setTransactionSequenceNumber(1);
				//tsObj.setCreatedby("admin");
				MasHospital hospital = new MasHospital();
				hospital.setId((Integer)mapForDS.get("hospitalId"));
				tsObj.setHospital(hospital);
				tsObj.setStatus("y");
				hbt.save(tsObj);
			
			}
		}
		
		Visit visitObj =new Visit();
		if(mapForDS.get("visit") !=null){
			visitObj=(Visit)mapForDS.get("visit");
		}
		Patient hin = (Patient)hbt.load(Patient.class, hinId);
		int currentVisitNo = hin.getCurrentVisitNo()+1;
		visitObj.setVisitNo(currentVisitNo);
		hbt.save(visitObj);
		hin.setCurrentVisitNo(currentVisitNo);
		hbt.update(hin);
		tx.commit();
	  }
	} catch (Exception e)
	 {
		if (tx != null)
			tx.rollback();
		e.printStackTrace();

	  } finally {
		// --------Session Closing----------
	//	session.close();
	  }
		
		return successfullyAdded;

	}

	//--------------------------------------------------
	@Override
	public Boolean updateMedicalExaminationBoardAnnual2A(Map<String, Object> mapForDS) {
		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int visitId=(Integer)mapForDS.get("visitId");
		String data=(String)mapForDS.get("data");
		String Labresult=(String)mapForDS.get("Labresult");
		int medicalOfficerId = 0;
		if(mapForDS.get("medicalOfficerId") != null){
			medicalOfficerId = (Integer)mapForDS.get("medicalOfficerId");
		}
		int departmentId = 0;
		if(mapForDS.get("departmentId") != null){
			departmentId = (Integer)mapForDS.get("departmentId");
		}
		MasMedicalExaminationReportOnEntry masMedicalBoardProceedings = new MasMedicalExaminationReportOnEntry();
		if(mapForDS.get("masMedicalBoardProceedings") != null){
			masMedicalBoardProceedings = (MasMedicalExaminationReportOnEntry)mapForDS.get("masMedicalBoardProceedings");
		}
		
		try {
			boolean saveinvestigation = false;
			Session session = (Session) getSession();
           // saveinvestigation=saveInvestigationAdd(mapForDS);
			saveinvestigation = updateInvestigation(mapForDS);
			saveInvestigationResult(mapForDS);
            if (saveinvestigation) {
			hbt.update(masMedicalBoardProceedings);
	         if(Labresult.equalsIgnoreCase("present") && data!=null)
             {
             Visit visit = (Visit)hbt.load(Visit.class, visitId);
             if(medicalOfficerId != 0){
     	    	MasEmployee masEmployee = new MasEmployee();
     	    	masEmployee.setId(medicalOfficerId);
     	    	visit.setDoctor(masEmployee);
     	    	}
     	    	if(departmentId != 0){
     	    	MasDepartment masDepartment = new MasDepartment();
     	    	masDepartment.setId(departmentId);
     	    	visit.setDepartment(masDepartment);
     	    	}
             visit.setMedStatus("f");
             hbt.update(visit);
             }
             successfullyAdded = true;
			}
           if(masMedicalBoardProceedings!=null)
           {	   
             List<MasMedicalExamReportDt> masMedicalExamReportDtList=session.createCriteria(MasMedicalExamReportDt.class)
                                                    .add(Restrictions.eq("MasMedicalExamReport.Id",masMedicalBoardProceedings.getId() )).list();
           for(MasMedicalExamReportDt masMedicalExamReportDt:masMedicalExamReportDtList)
           {
        	   hbt.delete(masMedicalExamReportDt);
           }
           int hinId=(Integer)mapForDS.get("hinId");
           if(hinId!=0)
           {
        	   Patient patient=(Patient)session.load(Patient.class, hinId);
        	   if(mapForDS.get("identification1")!=null )
        		{	
        		patient.setSrIdentificationMark1((String)mapForDS.get("identification1"));
        		}
        		if(mapForDS.get("identification2")!=null )
        		{	
        	    	patient.setSrIdentificationMark2((String)mapForDS.get("identification2"));
        		}
        		if(mapForDS.get("alcohol")!=null ){
        			patient.setAlcohol((String)mapForDS.get("alcohol"));
        		}
        		if(mapForDS.get("drugAllergy")!=null ){
        			patient.setDrugAllergies((String)mapForDS.get("drugAllergy"));
        		}
        		if(mapForDS.get("smokerLess10")!=null ){
        			patient.setSmokerLess10((String)mapForDS.get("smokerLess10"));
        		}
        		if(mapForDS.get("smokerMore10")!=null ){
        			patient.setSmokerMore10((String)mapForDS.get("smokerMore10"));
        		}
        		
        		hbt.update(patient);
           }
         /* if(giveOnList.size()>0)
       	  {
       		
       		for(int i=0;i<giveOnList.size();i++)
       		{
       			MasMedicalExamReportDt masMedicalExamReportDt=new MasMedicalExamReportDt();
       			masMedicalExamReportDt.setVaccine(vaccineList.get(i));
    			masMedicalExamReportDt.setDose(doseList.get(i));
    			masMedicalExamReportDt.setRoute(routeList.get(i));
       			masMedicalExamReportDt.setGiveOn(giveOnList.get(i));
       			masMedicalExamReportDt.setBatchNo(batchNoList.get(i));
       			masMedicalExamReportDt.setDOE(doeList.get(i));
       			masMedicalExamReportDt.setDOM(domList.get(i));
       			masMedicalExamReportDt.setMasMedicalExamReport(masMedicalBoardProceedings);
       			hbt.save(masMedicalExamReportDt);
       		 }
          }*/
       	
           
           }
           
           if(masMedicalBoardProceedings.getAdmissionStatus()!=null)
           {
        	   if(masMedicalBoardProceedings.getAdmissionStatus().equalsIgnoreCase("y"))
        	   {
        		   Users user=(Users)mapForDS.get("user");
        		   int hospitalId=(Integer)mapForDS.get("hospitalId"); 
        		 Date lastChangedDate=(Date)mapForDS.get("lastChangedDate");
          		 String lastChangedTime=(String)mapForDS.get("lastChangedTime");
         	  	 Visit visitsave = new Visit();
       			 visitsave=(Visit) hbt.load(Visit.class, masMedicalBoardProceedings.getVisit().getId());
       			 visitsave.setDisposalName("Admit");
       			 hbt.update(visitsave);
       			OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
       			opdPatientDetails.setVisit(visitsave);
    			MasHospital masHospitalObj = new MasHospital();
    			masHospitalObj.setId(hospitalId);
    			opdPatientDetails.setHospital(masHospitalObj);
    			opdPatientDetails.setDisposal("Admit");
    			opdPatientDetails.setConsultationTime(lastChangedTime);
    			opdPatientDetails.setConsultationDate(lastChangedDate);
    			opdPatientDetails.setOpdDate(lastChangedDate);
    			opdPatientDetails.setOpdTime(lastChangedTime);
    			opdPatientDetails.setEmployee(user.getEmployee());      
    			//opdPatientDetails.setMhRun("n");
    			hbt.save(opdPatientDetails);
    		
    			/*     Dinesh Dubey     Status - I  means patient is admitted       */
    			MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry=(MasMedicalExaminationReportOnEntry)session.load(MasMedicalExaminationReportOnEntry.class, masMedicalBoardProceedings.getId());
    			masMedicalExaminationReportOnEntry.setStatus("I");
    			hbt.update(masMedicalExaminationReportOnEntry);
        	   }
           }
			} catch (Exception e)
			{
			 e.printStackTrace();
			}
		return successfullyAdded;
	}


	//-------------------------Dinesh Dubey -------------------------
	public Map<String, Object> displayFileUploadData(Map<String, Object> dataMap)
	{
		int hinId=(Integer)dataMap.get("hinId");
		int visitId=(Integer)dataMap.get("visitId");
		Session session=(Session)getSession();
		Map<String, Object> map=new HashMap<String, Object>();
		try
		{
			Patient patient=(Patient)session.get(Patient.class,hinId);
			Visit visit=(Visit)session.get(Visit.class, visitId);
			map.put("patient", patient)	;
			map.put("visit", visit)	;
			
		}catch (HibernateException e)
		{
		   e.printStackTrace();
		}
		return map;
	}
	
	public Map<String, Object> submitUploadDocumentsForMedicalExam(Map<String, Object> mapForDS)
	{
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			//String fileName = null;
			//String fileExtension = null;
			int hinId =(Integer)mapForDS.get("hinId");
			int hospitalId =(Integer)mapForDS.get("hospitalId");
			int masMedicalExamId =(Integer)mapForDS.get("masMedicalExamId");
			List<String> fileNameList=(List<String>)mapForDS.get("fileNameList");
			List<String> fileExtensionList=(List<String>)mapForDS.get("fileExtensionList");
			List<String> descriptionList=(List<String>)mapForDS.get("descriptionList");
			List<Integer> counterList=(List<Integer>)mapForDS.get("counterList");
			String folderName=(String)mapForDS.get("folderName");
			//fileName =(String)mapForDS.get("filename");
			//fileExtension =(String)mapForDS.get("fileExtension");
			MultipartFormDataRequest mrequest =(MultipartFormDataRequest)mapForDS.get("mrequest");
		    boolean status=false;
			try
			{
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
	        	File file = null;
	        int i=0;	
			for(String fileName:fileNameList )
			{	
				if (!fileName.equals("0")) 
				{
						java.util.Hashtable files = mrequest.getFiles();
						int j=counterList.get(i);
						UploadFile file12 = (UploadFile) files.get(RequestConstants.UPLOAD_FILENAME+j);
						InputStream is=file12.getInpuStream();
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
						
						  while (offset < bytes.length && (numRead=is.read(bytes,
						  offset, bytes.length- offset)) >= 0) { offset += 1000;
						  if(offset>bytes.length) offset=offset-bytes.length; }
						 

						if (offset < bytes.length) {
							throw new IOException("Could not completely read file "
									+ file.getName());

						}

						is.close();
						// Close the input stream and return bytes
						MasMedicalUploadDocument masUploadDocuments = new MasMedicalUploadDocument();
						String dataInput = new String(bytes);
						masUploadDocuments.setFileName(fileName);
						masUploadDocuments.setFileExtension(fileExtensionList.get(i));
						masUploadDocuments.setDocument(bytes);
						//DgMasInvestigation dgMasInvestigation=new DgMasInvestigation();
						//dgMasInvestigation.setId(investigationId);
						//masUploadDocuments.setDgMasInvestigation(dgMasInvestigation);
						Patient patient = new Patient();
						patient.setId(hinId);
						masUploadDocuments.setHin(patient);
						MasHospital masHospital = new MasHospital();
						masHospital.setId(hospitalId);
						masUploadDocuments.setHospital(masHospital);
						MasMedicalExaminationReportOnEntry masMedicalExamReport=new MasMedicalExaminationReportOnEntry();
						masMedicalExamReport.setId(masMedicalExamId);
						masUploadDocuments.setMasMedicalExamReport(masMedicalExamReport);
						masUploadDocuments.setDescription(descriptionList.get(i));		
						masUploadDocuments.setFileFlag(folderName); 
					    hbt.save(masUploadDocuments);
					    status=true;
					}
                    i++;
			    }
	           
	            }catch (Exception e)
	            {
				  e.printStackTrace();
				  status=false;
			     }
	            map.put("status", status);
			return map;

	

	}
	public Map<String, Object> getUploadDocumentDetails(Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int hinId =(Integer)dataMap.get("hinId");
		int hospitalId =(Integer)dataMap.get("hospitalId");
		int masExamId =(Integer)dataMap.get("masExamId");
		String folderName=(String)dataMap.get("folderName");
		int visitId=(Integer)dataMap.get("visitId");
	    try
	    {
	    	List<MasMedicalUploadDocument> masMedicalUploadDocumentList=session.createCriteria(MasMedicalUploadDocument.class)
	    	   .add(Restrictions.eq("MasMedicalExamReport.Id",masExamId)).add(Restrictions.eq("Hin.Id",hinId)).add(Restrictions.eq("Hin.Id",hinId))
	    	   .add(Restrictions.eq("Hospital.Id",hospitalId)).add(Restrictions.eq("FileFlag",folderName)).list();
	    	map.put("masMedicalUploadDocumentList", masMedicalUploadDocumentList);
	    	Patient patient=(Patient)session.get(Patient.class,hinId);
			Visit visit=(Visit)session.get(Visit.class, visitId);
			map.put("patient", patient)	;
			map.put("visit", visit)	;
	    }catch (HibernateException he)
	    {
		   he.printStackTrace();
	    }
	    return map;
	}
	public Map<String, Object> getUploadDocumentMedicalExamData(Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
	  
		int hinId =(Integer)dataMap.get("hinId");
		int hospitalId =(Integer)dataMap.get("hospitalId");
		int masExamId =(Integer)dataMap.get("medExamId");
		String fileName=(String)dataMap.get("filename");
		String folderName=(String)dataMap.get("folderName");
		String fileExtension=(String)dataMap.get("fileExtension");
	    try
	    {
	    	List<MasMedicalUploadDocument> masMedicalUploadDocumentList=session.createCriteria(MasMedicalUploadDocument.class)
	    	   .add(Restrictions.eq("MasMedicalExamReport.Id",masExamId)).add(Restrictions.eq("Hin.Id",hinId)).add(Restrictions.eq("Hin.Id",hinId))
	    	   .add(Restrictions.eq("Hospital.Id",hospitalId)).add(Restrictions.eq("FileFlag",folderName))
	    	   .add(Restrictions.eq("FileName",fileName)).add(Restrictions.eq("FileExtension",fileExtension)).list();
	    	map.put("masMedicalUploadDocumentList", masMedicalUploadDocumentList);
	    }catch (HibernateException he)
	    {
		   he.printStackTrace();
	    }
	    return map;
	}
	public Map<String, Object> submitUploadDocumentsInvestForMedicalExam(Map<String, Object> mapForDS)
	{
			Map<String, Object> map = new HashMap<String, Object>();
			Date currentDate = new Date();
			Session session = (Session) getSession();
			int hinId =(Integer)mapForDS.get("hinId");
			int hospitalId =(Integer)mapForDS.get("hospitalId");
			int investId=(Integer)mapForDS.get("investId");
			int masMedicalExamId =(Integer)mapForDS.get("masMedicalExamId");
			List<String> fileNameList=(List<String>)mapForDS.get("fileNameList");
			List<String> fileExtensionList=(List<String>)mapForDS.get("fileExtensionList");
			List<String> descriptionList=(List<String>)mapForDS.get("descriptionList");
			List<Integer> counterList=(List<Integer>)mapForDS.get("counterList");
			String folderName=(String)mapForDS.get("folderName");
				MultipartFormDataRequest mrequest =(MultipartFormDataRequest)mapForDS.get("mrequest");
		    boolean status=false;
			try
			{
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
	        	File file = null;
	        int i=0;	
			for(String fileName:fileNameList )
			{	
				if (!fileName.equals("0")) 
				{
						java.util.Hashtable files = mrequest.getFiles();
						int j=counterList.get(i);
						UploadFile file12 = (UploadFile) files.get(RequestConstants.UPLOAD_FILENAME+j);
						InputStream is=file12.getInpuStream();
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
						
						  while (offset < bytes.length && (numRead=is.read(bytes,
						  offset, bytes.length- offset)) >= 0) { offset += 1000;
						  if(offset>bytes.length) offset=offset-bytes.length; }
						 

						if (offset < bytes.length) {
							throw new IOException("Could not completely read file "
									+ file.getName());

						}

						is.close();
						// Close the input stream and return bytes
						MasMedicalUploadDocument masUploadDocuments = new MasMedicalUploadDocument();
						String dataInput = new String(bytes);
						masUploadDocuments.setFileName(fileName);
						masUploadDocuments.setFileExtension(fileExtensionList.get(i));
						masUploadDocuments.setDocument(bytes);
						DgMasInvestigation dgMasInvestigation=new DgMasInvestigation();
						dgMasInvestigation.setId(investId);
						masUploadDocuments.setDgMasInvestigation(dgMasInvestigation);
						Patient patient = new Patient();
						patient.setId(hinId);
						masUploadDocuments.setHin(patient);
						MasHospital masHospital = new MasHospital();
						masHospital.setId(hospitalId);
						masUploadDocuments.setHospital(masHospital);
						if(masMedicalExamId !=0){
						MasMedicalExaminationReportOnEntry masMedicalExamReport=new MasMedicalExaminationReportOnEntry();
						masMedicalExamReport.setId(masMedicalExamId);
						masUploadDocuments.setMasMedicalExamReport(masMedicalExamReport);
						}else{
							masUploadDocuments.setIdFlag("n");
							masUploadDocuments.setMedDate(currentDate);
						}
						masUploadDocuments.setDescription(descriptionList.get(i));		
						masUploadDocuments.setFileFlag(folderName); 
					    hbt.save(masUploadDocuments);
					    status=true;
					}
                    i++;
			    }
	           
	            }catch (Exception e)
	            {
				  e.printStackTrace();
				  status=false;
			     }
	            map.put("status", status);
			return map;

	

	}

	public Map<String, Object> getUploadDocumentInvestigationDetails(Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int hinId =(Integer)dataMap.get("hinId");
		int hospitalId =(Integer)dataMap.get("hospitalId");
		int masExamId =(Integer)dataMap.get("masExamId");
		int investId=(Integer)dataMap.get("investId");
		int visitId=(Integer)dataMap.get("visitId");
	    try
	    {
	    	List<MasMedicalUploadDocument> masMedicalUploadDocumentList=session.createCriteria(MasMedicalUploadDocument.class)
	    	   .add(Restrictions.eq("MasMedicalExamReport.Id",masExamId)).add(Restrictions.eq("Hin.Id",hinId)).add(Restrictions.eq("Hin.Id",hinId))
	    	   .add(Restrictions.eq("Hospital.Id",hospitalId)).add(Restrictions.eq("DgMasInvestigation.Id",investId)).list();
	    	map.put("masMedicalUploadDocumentList", masMedicalUploadDocumentList);
	    	Patient patient=(Patient)session.get(Patient.class,hinId);
			Visit visit=(Visit)session.get(Visit.class, visitId);
			map.put("patient", patient)	;
			map.put("visit", visit)	;
	    }catch (HibernateException he)
	    {
		   he.printStackTrace();
	    }
	    return map;
	}
	public Map<String, Object> getUploadDocumentMedicalExamInvestigationData(Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
	  
		int hinId =(Integer)dataMap.get("hinId");
		int hospitalId =(Integer)dataMap.get("hospitalId");
		int investId =(Integer)dataMap.get("investId");
		int masExamId =(Integer)dataMap.get("medExamId");
		String fileName=(String)dataMap.get("filename");
		String folderName=(String)dataMap.get("folderName");
		String fileExtension=(String)dataMap.get("fileExtension");

	    try
	    {
	    	List<MasMedicalUploadDocument> masMedicalUploadDocumentList=session.createCriteria(MasMedicalUploadDocument.class)
	    	   .add(Restrictions.eq("MasMedicalExamReport.Id",masExamId)).add(Restrictions.eq("Hin.Id",hinId)).add(Restrictions.eq("Hin.Id",hinId))
	    	   .add(Restrictions.eq("Hospital.Id",hospitalId)).add(Restrictions.eq("DgMasInvestigation.Id",investId))
	    	   .add(Restrictions.eq("FileName",fileName)).add(Restrictions.eq("FileExtension",fileExtension)).list();
	    	map.put("masMedicalUploadDocumentList", masMedicalUploadDocumentList);
	    	
	    }catch (HibernateException he)
	    {
		   he.printStackTrace();
	    }
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		//	session.close();
		}
		return visitList;
	}
	/*
     * Code By Dinesh
     * Status  
     *  i	 for create new medical exam
     */
	public boolean initiateNewMedicalExam(Map<String, Object> dataMap)
	{
		
		boolean status=false;
		Session session = (Session) getSession();
		Transaction tx=null;
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);  
		int medExamId=(Integer)dataMap.get("medExamId");
		Date lastChangedDate=(Date)dataMap.get("lastChangedDate");
		String lastChangedTime=(String)dataMap.get("lastChangedTime");
		int userId=(Integer)dataMap.get("userId");
		int hospitalId=(Integer)dataMap.get("hospitalId");
		try
		{
			 tx=session.beginTransaction();
				
			MasMedicalExaminationReportOnEntry masExamEntry=(MasMedicalExaminationReportOnEntry)session.load(MasMedicalExaminationReportOnEntry.class, medExamId);
			List<Visit> visitList=getVisitNo(masExamEntry.getHin().getHinNo());
			int visitNo=1;
			if(visitList!=null && visitList.size()>0)
			{
			 Visit visit=visitList.get(0);
			 visitNo=visit.getVisitNo()+1;
			}
			Visit visit = new Visit();
			visit.setHin(masExamEntry.getHin());
			visit.setVisitNo(visitNo);
			visit.setTokenNo(0);
			visit.setHospital(masExamEntry.getHospital());
			visit.setAge(masExamEntry.getHin().getAge());
			visit.setStatus("y");
			visit.setAppointmentType("D");
			visit.setMedExamType(masExamEntry.getMedicalExamType());
			visit.setVisitStatus("c");
			visit.setMedStatus("w");
			visit.setReportingFor("MedExam");
			visit.setTokenDoctor("0#0");
			Users user=new Users();
			user.setId(userId);
			visit.setAddEditBy(user);
			
			visit.setVisitDate(lastChangedDate);
			visit.setVisitTime(lastChangedTime);
			visit.setAddEditDate(lastChangedDate);
			visit.setAddEditTime(lastChangedTime);
			hbt.save(visit);
			masExamEntry.setStatus("i");
			hbt.update(masExamEntry);
			tx.commit();
			status=true;
		}catch (Exception e)
		{
			e.printStackTrace();
			tx.rollback();
			status=false;
		}
		return status;
	}
	/*
	 * Code By Mukesh narayan Singh
	 * Date 29 March 2012
	 * @see jkt.hms.medicalExam.dataservice.MedicalExamDataService#validateMedExamSpecialOpinion(jkt.hms.util.Box)
	 */
	public Map<String, Object> validateMedExamSpecialOpinion(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		int medExamId = box.getInt("medExamId");
		 String flagForward="";
		 flagForward=box.getString("flagForward");
		 
		boolean successfullyAdded= false;
		HibernateTemplate hbt = getHibernateTemplate();
		Transaction tx = null;
		String dataMessage=null;
		org.hibernate.Session session = getSession();
		try {
		
       // tx = session.beginTransaction();
		hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

	
			MasMedicalExaminationReportOnEntry masMedExam = new MasMedicalExaminationReportOnEntry();
			masMedExam = loadMedicalExamObj(medExamId);
			if(box.getString("flag").equals("command")){
				masMedExam.setStatus("c");
				masMedExam.setCommandRemarks(box.getString("cmMdRemarks"));
				Users cmUser = new Users();
				cmUser.setId(box.getInt("userId"));
				masMedExam.setCmUser(cmUser);
			}else {
				masMedExam.setStatus("f");
				String date = "";
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
				date = (String) utilMap.get("currentDate");
				masMedExam.setDateSpecialExam(HMSUtil.convertStringTypeDateToDateType(date));
				//masMedExam.setMdRemarks(box.getString("cmMdRemarks"));
				hbt.update(masMedExam);
				hbt.refresh(masMedExam);
			}
			/*
			 * This block is executute in case of forward from MO
			 */
			if(flagForward.equalsIgnoreCase("s")){
				masMedExam.setStatus("s");
				String date = "";
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
				date = (String) utilMap.get("currentDate");
				masMedExam.setDateSpecialExam(HMSUtil.convertStringTypeDateToDateType(date));
				//masMedExam.setMdRemarks(box.getString("cmMdRemarks"));
				hbt.update(masMedExam);
				hbt.refresh(masMedExam);
			}
			/**
			 * End of Code
			 */
			
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("dataMessage", dataMessage);
		map.put("successfullyAdded", successfullyAdded);
		return map;
	
	}
	public Map<String, Object> editMID_MedicalExam(
			Map<String, Object> mapfordata) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int commandId = 0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<MasMedicalExaminationReportOnEntry> medicalDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<MasUnit> unitList = null;
		List<Category> categoryList = null;
		Criteria crit = null;
	    String serviceNo = null;
        if(mapfordata.get("serviceNo") !=null){
        	serviceNo = (String)mapfordata.get("serviceNo");
        }

	  
	    crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("medicalType", "MedicalExam")).add(Restrictions.eq("YearlySerialNo", serviceNo))
	    .add(Restrictions.eq("Status","v")).addOrder(Order.asc("DateOfReporting"));
	    medicalDetailList = crit.list();
	    //Commented by sanjay yadav
	    /*unitList = hbt.find("from MasUnit mc where mc.Status='y'");*/
	    unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status","y")).list();
	    categoryList = hbt.find("from Category mc");
        map.put("medicalDetailList", medicalDetailList);	
        map.put("unitList", unitList);
        map.put("categoryList", categoryList);

		return map;

	}


	@Override
	public Boolean addMID_MedicalExam(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings,
			Map<String, Object> mapForDS) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masMedicalBoardProceedings);
		successfullyAdded = true;
		return successfullyAdded;
	}
	public Map<String, Object> getPatientDetailAndAddMedicalExam(String serviceNo)
	{
		Map<String, Object> map=new HashMap<String, Object>();
		Session session=(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
	
		try
		{
			List<Patient> patientList=session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();
			map.put("patientList", patientList);
			
			 List<Category> categoryList = new ArrayList<Category>();
	           /*categoryList = getHibernateTemplate().find("from jkt.hms.masters.business.Category ");*/
			 categoryList = session.createCriteria(Category.class).list();
	           map.put("categoryList", categoryList);
	         List<MasCommand> commandList=new ArrayList<MasCommand>();
	       	 /*commandList = hbt.find("from MasCommand mas where mas.Status='y' order by mas.CommandName");*/
	         commandList = session.createCriteria(MasCommand.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("CommandName")).list();
	       	 map.put("commandList", commandList);
	       	 List<PatientFamilyHistory> patientFamilyHistoryList=session.createCriteria(PatientFamilyHistory.class).add(Restrictions.eq("Status","y")).list();
	       	 map.put("patientFamilyHistoryList", patientFamilyHistoryList);
	       List<MasRank> rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
	       List<MasUnit> unitList = session.createCriteria(MasUnit.class)
	       .add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
		
	       map.put("rankList", rankList); 
	       map.put("unitList", unitList); 
	       
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
	public Map<String, Object> addOldMedicalExamData(Map<String, Object> dataMap)
	{
		Map<String, Object> map=new HashMap<String, Object>();
		Session session=(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		boolean status=false;
		try
		{
			tx=session.beginTransaction();
		 int hospitalId=(Integer)dataMap.get("hospitalId");
		 String serviceNo=(String)dataMap.get("serviceNo");
		 int hinId=(Integer)dataMap.get("hinId");
		 
		 String age=(String)dataMap.get("age");
		 
		 String smokerMore10=(String)dataMap.get("smokerMore10");
		 String smokerLess10=(String)dataMap.get("smokerLess10");
		 String alcohol=(String)dataMap.get("alcohol");
		 String	allergies=(String)dataMap.get("allergies");
		 String[] familyHistoryArray =(String[])dataMap.get("familyHistoryArray");
		 String otherFamilyHistory=(String)dataMap.get("otherFamilyHistory"); 
		 
		 Patient patient=(Patient)session.load(Patient.class, hinId);
		 patient.setAlcohol(alcohol);
		 patient.setSmokerLess10(smokerLess10);
		 patient.setSmokerMore10(smokerMore10);
		 patient.setDrugAllergies(allergies);
		 patient.setOtherFamilyHistory(otherFamilyHistory);
		 hbt.update(patient);

		 int  genderId=(Integer)dataMap.get("genderId");
		 int rankId=(Integer)dataMap.get("rankId");
		 int unitId=(Integer)dataMap.get("unitId");
         String patientName=(String)dataMap.get("patientName");
		 int  tradeId=0;
		 if(dataMap.get("tradeId")!=null)
		 tradeId=(Integer)dataMap.get("tradeId");

		Date dateofcommun =(Date)dataMap.get("dateofcommun");
		Category presentMedicalCategory=(Category)dataMap.get("presentMedicalCatId");
		String lastAmePlace=(String)dataMap.get("lastAmePlace");
		int commandId =0;
		 if(dataMap.get("commandId")!=null)
		commandId=(Integer)dataMap.get("commandId");
		Date reportedDate =(Date)dataMap.get("reportedDate");
		//Date lastAmeDate =(Date)dataMap.get("lastAmeDate");
		String period =(String)dataMap.get("period");
		//String waiver =(String)dataMap.get("waiver");
		String medExamType =(String)dataMap.get("medExamType");
		//int unitId =(Integer)dataMap.get("unitId");
		BigDecimal height=(BigDecimal)dataMap.get("height");
		BigDecimal weight =(BigDecimal)dataMap.get("weight");
        BigDecimal idealWeight =(BigDecimal)dataMap.get("idealWeight");
		BigDecimal overWeight =(BigDecimal)dataMap.get("overWeight");
		String waist=(String)dataMap.get("waist");
		String hip =(String)dataMap.get("hip");
		String whr =(String)dataMap.get("whr");
		String pulse =(String)dataMap.get("pulse");
		String bp =(String)dataMap.get("bp");
		//int deptId=(Integer)dataMap.get("deptId");
	     String lastChangedBy=(String)dataMap.get("lastChangedBy");
		Date lastChangedDate=(Date)dataMap.get("lastChangedDate");
		String lastChangedTime=(String)dataMap.get("lastChangedTime");
		List<String> systemDiagnosisList=(List<String>)dataMap.get("systemDiagnosisList");
		List<Integer> systemDiagnosisIdList=(List<Integer>)dataMap.get("systemDiagnosisIdList");
		List<Visit> visitList=getVisitNo(patient.getHinNo());
		int visitNo=1;
		 Users user=(Users)dataMap.get("user");
		MasHospital hospital=new MasHospital();
        hospital.setId(hospitalId);
     
		if(visitList!=null && visitList.size()>0)
		{
		 Visit visit=visitList.get(0);
		 visitNo=visit.getVisitNo()+1;
		}
		Visit visit = new Visit();
		visit.setHin(patient);
		visit.setVisitNo(visitNo);
		visit.setTokenNo(0);
		visit.setHospital(hospital);
		visit.setAge(age);
		visit.setStatus("y");
		visit.setAppointmentType("D");
		visit.setMedExamType(medExamType);
		visit.setVisitStatus("c");
		visit.setMedStatus("f");
		visit.setReportingFor("MedExam");
		visit.setAddEditBy(user);
		visit.setVisitDate(lastChangedDate);
		visit.setAddEditDate(lastChangedDate);
		visit.setAddEditTime(lastChangedTime);
		visit.setVisitTime(lastChangedTime);
	    hbt.save(visit);
		
        MasMedicalExaminationReportOnEntry masMedicalExamReport=new MasMedicalExaminationReportOnEntry();
          masMedicalExamReport.setHospital(hospital);
        masMedicalExamReport.setAdmissionStatus("n");
    	masMedicalExamReport.setSpecialistOpinnionStatus("n");
    	masMedicalExamReport.setServiceNo(serviceNo);
    	masMedicalExamReport.setYearlySerialNo(serviceNo);
    	//Patient patient=new Patient();
    	patient.setId(hinId);
    	masMedicalExamReport.setHin(patient);
    	MasRank rank=new MasRank();
    	rank.setId(rankId);
    	masMedicalExamReport.setRank(rank);
    	//MasAdministrativeSex sex=new MasAdministrativeSex();
    	//sex.setId(genderId);visit
    	masMedicalExamReport.setVisit(visit);
    	masMedicalExamReport.setNameInFull(patientName);
        if(tradeId!=0)
        {	
    	  MasTrade trade=new MasTrade();
          trade.setId(tradeId);
          masMedicalExamReport.setTrade(trade);
        }
          masMedicalExamReport.setDateofcommun(dateofcommun);
    	masMedicalExamReport.setPresentMedicalCategory(presentMedicalCategory);
    	masMedicalExamReport.setLastame(lastAmePlace);
    	masMedicalExamReport.setWaist(waist);
    	masMedicalExamReport.setHips(hip);
    	masMedicalExamReport.setWhr(whr);
    	masMedicalExamReport.setPulseRates(pulse);
    	masMedicalExamReport.setBp(bp);
    	
    	if(commandId!=0)
    	{	
    	 MasCommand command=new MasCommand();
    	 command.setId(commandId);
    	 masMedicalExamReport.setCommand(command);
    	}
    	 masMedicalExamReport.setDateOfReporting(reportedDate);
    	//masMedicalExamReport.setDateMedicalBoardSubsequent(lastAmeDate);
    	masMedicalExamReport.setPeriod(period);
    	masMedicalExamReport.setApparentAge(age);
    	//masMedicalExamReport.setAggravMaterialPeriod(period);
    	//masMedicalExamReport.setWaiver(waiver);
    	masMedicalExamReport.setMedicalExamType(medExamType);
    	MasUnit unit=new MasUnit();
    	unit.setId(unitId);
    	masMedicalExamReport.setUnit(unit); 
    	masMedicalExamReport.setHeight(height);
    	masMedicalExamReport.setWeight(weight);
    	masMedicalExamReport.setIdealweight(""+idealWeight);
    	masMedicalExamReport.setOverweight(""+overWeight);
    	masMedicalExamReport.setAllergies(allergies);
    	masMedicalExamReport.setLastChangedBy(lastChangedBy);
    	masMedicalExamReport.setLastChangedDate(lastChangedDate);
    	masMedicalExamReport.setLastChangedTime(lastChangedTime);
    	masMedicalExamReport.setStatus("f");
    	masMedicalExamReport.setMedicalType("MedicalExam");
    	hbt.save(masMedicalExamReport);
    	map.put("masMedicalExamReport",masMedicalExamReport);
      // 	List<String> systemDiagnosisList=(List<String>)dataMap.get("systemDiagnosisIdList");
//		List<Integer> systemDiagnosisIdList=(List<Integer>)dataMap.get("systemDiagnosisList");
        for(int i=0;i<systemDiagnosisList.size();i++)
        {
        	MasMedicalExaminationDetail masMedicalExaminationDetail=new MasMedicalExaminationDetail();
        	masMedicalExaminationDetail.setIllness(systemDiagnosisList.get(i));
			masMedicalExaminationDetail.setParticular("particular");
			if(systemDiagnosisIdList.get(i)!=null)
			{	
				MasSystemDiagnosis masSystemDiagnosis=new MasSystemDiagnosis();
				masSystemDiagnosis.setId(systemDiagnosisIdList.get(i));
				masMedicalExaminationDetail.setSystemDiagnosis(masSystemDiagnosis);
			}
			
			masMedicalExaminationDetail.setMasMedicalReport(masMedicalExamReport);
			hbt.save(masMedicalExaminationDetail);
			
			
        }   	
    	
    	
    		if(familyHistoryArray!=null && familyHistoryArray.length > 0) 
    		{ 
			   for(String  familyHistory:familyHistoryArray)
			    {	
				  int familyHistoryId=Integer.parseInt(familyHistory);  
				  if(familyHistoryId!=0)
				  {	  
			  	    List<MasMedicalExamFamilyHis> existingFamilyHis = new ArrayList<MasMedicalExamFamilyHis>();
				existingFamilyHis = session.createCriteria(MasMedicalExamFamilyHis.class).createAlias("Hin", "h")
				.add(Restrictions.eq("h.Id", hinId)).createAlias("PatientFamilyHistory", "pfh").add(Restrictions.eq("pfh.Id",familyHistoryId)).list();
				if(existingFamilyHis.size() == 0)
				{
					MasMedicalExamFamilyHis masExamFamilyHis = new MasMedicalExamFamilyHis();
					
					masExamFamilyHis.setHin(patient);
					PatientFamilyHistory familyHistoryObj = new PatientFamilyHistory();
					familyHistoryObj.setId(familyHistoryId);
					masExamFamilyHis.setPatientFamilyHistory(familyHistoryObj);
					hbt.save(masExamFamilyHis);
				  }
			   }
		      }
			
	      }
    		status=true;
		    tx.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		map.put("status",status);
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
				List<DgOrderhd> dgOrderhdList = session.createCriteria(DgOrderhd.class)
						.add(Restrictions.eq("InvestigationRequestionNo.Id",
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

	/**
	 * Code By Ritu for search in perusing authority wait list
	 * 20 Nov 2012
	 */
	@Override
	public Map<String, Object> searchMedicalExamPerAuthority(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	    Criteria crit = null;
	    List<Object[]> unitList = null;
	    
	    rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("ServiceType.Id", 2)).addOrder(Order.asc("RankName")).list(); // for airforce service type id is 2 
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.eq("Status", "a")).add(Restrictions.eq("medicalType", "MedicalExam"))
				.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", box.getInt("hospitalId")))
				.addOrder(Order.desc("Id"));
		
		if(!box.getString(FROM_DATE).equals("") && !box.getString(TO_DATE).equals("")){
			crit = crit.add(Restrictions.between("DateOfReporting", HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)), HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE))));
		}
		if(box.getInt("rankId")!=0){
			crit = crit.add(Restrictions.eq("Rank.Id", box.getInt("rankId")));
		}
		if(box.getInt("unitId")!=0){
			crit = crit.add(Restrictions.eq("Unit.Id", box.getInt("unitId")));
		}
		patientDetailList = crit.list();
		  
		unitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(Order.asc("UnitName")).list();
        map.put("patientDetailList", patientDetailList);		
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		return map;
		}
	//-------------------------code by anamika-----------------
	public Map<String, Object> validateMedExamSpecialistOpinion(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int medExamId = box.getInt("medExamId");
		 String flagForward="";
		 flagForward=box.getString("flagForward");
		boolean successfullyAdded= false;
		HibernateTemplate hbt = getHibernateTemplate();
		Transaction tx = null;
		String dataMessage=null;
		org.hibernate.Session session = getSession();
		try {
		
       // tx = session.beginTransaction();
		hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

			MasMedicalExaminationReportOnEntry masMedExam = new MasMedicalExaminationReportOnEntry();
			masMedExam = loadMedicalExamObj(medExamId);
			/*if(box.getString("flag").equals("command")){
				masMedExam.setStatus("c");
				masMedExam.setCommandRemarks(box.getString("cmMdRemarks"));
				Users cmUser = new Users();
				cmUser.setId(box.getInt("userId"));
				masMedExam.setCmUser(cmUser);
			}else {
				masMedExam.setStatus("f");
				String date = "";
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
				date = (String) utilMap.get("currentDate");
				masMedExam.setDateSpecialExam(HMSUtil.convertStringTypeDateToDateType(date));
				//masMedExam.setMdRemarks(box.getString("cmMdRemarks"));
				hbt.update(masMedExam);
				hbt.refresh(masMedExam);
			}*/
			/*
			 * This block is executute in case of forward from MO
			 */
			if(flagForward.equalsIgnoreCase("s")){
				masMedExam.setStatus("m");
				String date = "";
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
				date = (String) utilMap.get("currentDate");
				masMedExam.setDateSpecialExam(HMSUtil.convertStringTypeDateToDateType(date));
				//masMedExam.setMdRemarks(box.getString("cmMdRemarks"));
				hbt.update(masMedExam);
				hbt.refresh(masMedExam);
			}
			/**
			 * End of Code
			 */
			
			successfullyAdded = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("dataMessage", dataMessage);
		map.put("successfullyAdded", successfullyAdded);
		return map;
	
	}

	@Override
	public Map<String, Object> showMedicalExamSpecialist(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		// String[] statusArr = {"f","vr"};
		String[] statusArr = { "s" };
		//rankList = getHibernateTemplate().find(
				//"from jkt.hms.masters.business.MasRank ");
		rankList = session.createCriteria(MasRank.class).list();
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
			 .add(Restrictions.in("Status", statusArr)).add(Restrictions.eq("medicalType", "MedicalExam"))
			 .createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.desc("Id"));
		patientDetailList = crit.list();
		map.put("patientDetailList", patientDetailList);
		map.put("rankList", rankList);

		return map;
	}

	@Override
	public Map<String, Object> showMedicalExamListForSpecialist(Map<String, Object> mapForDS) {
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visit = null;
		List<DgOrderhd> resultList = null;
		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		int visitId = 0;
		if (mapForDS.get("visitId") != null) {
			visitId = (Integer) mapForDS.get("visitId");
		}
		int medExamId = 0;
		if (mapForDS.get("medExamId") != null) {
			medExamId = (Integer) mapForDS.get("medExamId");
		}
		int deptId = 0;
		if (mapForDS.get("deptId") != null) {
			deptId = (Integer) mapForDS.get("deptId");
		}
		int hospitalId = 0;
		if (mapForDS.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDS.get("hospitalId");
		}
		String search = "";
		String accessjsp = "";
		if (mapForDS.get("search") != null) {
			search = (String) mapForDS.get("search");
		}
		if (mapForDS.get("accessjsp") != null) {
			accessjsp = (String) mapForDS.get("accessjsp");
		}
		Session session = (Session) getSession();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		templateList = session.createCriteria(OpdTemplate.class).createAlias(
				"Department", "dept").add(Restrictions.eq("dept.Id", deptId))
				.add(Restrictions.eq("Status", "y")).list();
		map.put("templateList", templateList);
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		if (search.equalsIgnoreCase("true")) {
			medExamList = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).list();

		} else if (search.equalsIgnoreCase("false")) {
			medExamList = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).list();
		} else {
			medExamList = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).list();
		}
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		//visit = hbt.find("from Visit as v where v.Id='" + visitId + "'");
		visit = session.createCriteria(Visit.class)
		.add(Restrictions.eq("Id",visitId)).list();
		List<Integer> headerIdsInt = new ArrayList<Integer>();
		resultList = session.createCriteria(DgResultEntryHeader.class)
				.createAlias("SampleCollectionHeader", "smColl").createAlias(
						"smColl.Order", "order").createAlias("order.Visit",
						"vst").add(Restrictions.eq("vst.Id", visitId)).add(
						Restrictions.eq("ResultStatus", "A")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).createAlias("Hospital", "hosp")
				.add(Restrictions.eq("hosp.Id", hospitalId)).addOrder(
						Order.asc("FirstName")).list();
		if (employeeList.size() > 0) {
			map.put("employeeList", employeeList);
		}
		List<MasMaritalStatus> maritalStatusList = null;
		maritalStatusList = session.createCriteria(MasMaritalStatus.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("MaritalStatusName")).list();
			//hbt
				//.find("from MasMaritalStatus mms where mms.Status='y' order by mms.MaritalStatusName asc");
		List<Disability> disabilityList = new ArrayList<Disability>();
		disabilityList = session.createCriteria(Disability.class).list(); 
			//getHibernateTemplate().find(
				//"from jkt.hms.masters.business.Disability ");
		List<Category> categoryList = new ArrayList<Category>();
		categoryList =session.createCriteria(Category.class)
		.addOrder(Order.asc("Categories")).list();
			//getHibernateTemplate()
			//	.find(
				//		"from jkt.hms.masters.business.Category as cat order by cat.Categories asc");
		List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
				.createCriteria(PatientInvestigationHeader.class).createAlias(
						"Visit", "v").add(Restrictions.eq("v.Id", visitId))
				.createAlias("Hin", "p").add(
						Restrictions.eq("p.Id", visit.get(0).getHin().getId()))
				.addOrder(Order.desc("Id")).list();
		PatientInvestigationHeader patientInvestigationHeader = null;
		if (patientInvestigationHeaderList != null
				&& patientInvestigationHeaderList.size() > 0) {
			patientInvestigationHeader = patientInvestigationHeaderList.get(0);
			map.put("patientInvestigationHeader", patientInvestigationHeader);

		}
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		dgOrderhdList = (List<DgOrderhd>) session.createCriteria(
				DgOrderhd.class).createAlias("Visit", "v").add(
				Restrictions.eq("v.Id", visitId)).list();

		DgOrderhd dgOrderhd = null;
		if (dgOrderhdList != null && dgOrderhdList.size() > 0) {
			dgOrderhd = dgOrderhdList.get(0);
			map.put("dgOrderhd", dgOrderhd);

		}

		List<MasServiceType> serviceTypeList = null;
		serviceTypeList = session.createCriteria(MasServiceType.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("ServiceTypeName")).list(); 
			//hbt
				//.find("from MasServiceType mst where mst.Status='y' order by mst.ServiceTypeName asc");
		map.put("serviceTypeList", serviceTypeList);
		if (resultList != null || resultList.size() > 0) {
			map.put("resultList", resultList);
		}

		investigationList = session.createCriteria(DgMasInvestigation.class)
				.add(Restrictions.eq("Status", "y")).addOrder(
						Order.asc("InvestigationName")).list();
		if (investigationList.size() > 0) {
			map.put("investigationList", investigationList);
		}
		/**
		 * Commented By Ritu
		 */
		/*
		 * List<MasRank> masRankList1 = new ArrayList<MasRank>(); masRankList1 =
		 * getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.MasRank mr where mr.Status='y' order by mr.RankName asc"
		 * ); List<MasIcd> masIcdList = new ArrayList<MasIcd>(); masIcdList =
		 * getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.MasIcd mi where mi.Status='y' order by mi.IcdName asc"
		 * ); List<Disabilitygroup> disabilitygroupList = new
		 * ArrayList<Disabilitygroup>(); disabilitygroupList =
		 * getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.Disabilitygroup dg order by dg.DiseaseGroups asc"
		 * ); List<MasUnit> masUnitList = new ArrayList<MasUnit>(); masUnitList
		 * =getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.MasUnit mu where mu.Status='y' order by mu.UnitName asc"
		 * );
		 */
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		masHospitalList =session.createCriteria(MasHospital.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("HospitalName")).list();  
			//getHibernateTemplate()
				//.find(
			//"from jkt.hms.masters.business.MasHospital mh where mh.Status='y' order by mh.HospitalName asc");

		masDepartmentList = session.createCriteria(MasDepartment.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("DepartmentName")).list(); 
			//getHibernateTemplate()
				//.find(
			//"from jkt.hms.masters.business.MasDepartment md where md.Status='y' order by md.DepartmentName asc");

		/**
		 * Getting disabilities to display in specialist opinion Code By Ritu
		 * Date 7 May 2012
		 */
		List<MasMedicalExaminationDetail> medicalExamDetailsList = new ArrayList<MasMedicalExaminationDetail>();
		medicalExamDetailsList = session.createCriteria(
				MasMedicalExaminationDetail.class).add(
				Restrictions.eq("MasMedicalReport.Id", medExamId)).addOrder(Order.asc("Serviceid")).list();

		map.put("medicalExamDetailsList", medicalExamDetailsList);
		/**
		 * End
		 */
		map.put("masHospitalList", masHospitalList);
		map.put("masDepartmentList", masDepartmentList);

		map.put("visit", visit);
		map.put("maritalStatusList", maritalStatusList);
		map.put("medExamList", medExamList);
		map.put("disabilityList", disabilityList);
		map.put("categoryList", categoryList);
		/*
		 * map.put("masRankList1", masRankList1); map.put("masIcdList",
		 * masIcdList); map.put("disabilitygroupList", disabilitygroupList);
		 * map.put("masUnitList", masUnitList);
		 */
		return map;
	}

	@Override
	public Map<String, Object> updateMedicalExamEntryBySpecialist(Box box) {
		boolean successfullyAdded = false;
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Transaction tx = null;
		HibernateTemplate hbt = getHibernateTemplate();
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		/**
		 * update investigations
		 */
		List<Integer> dgOrderdtIdList = new ArrayList<Integer>();
		List<String> chargeCodeIdList = new ArrayList<String>();
		List<String> investigationReferToMHList = new ArrayList<String>();
		List<Integer> patientInvestigationdetailsIdList = new ArrayList<Integer>();
		List<String> investResultList = new ArrayList<String>();

		mapForDS.put("hinNoForreport", box.getInt("hinNoForreport"));
		mapForDS.put("visitNumberForReport", box.getInt("visitNumberForReport"));
		mapForDS.put("serviceNo", box.getInt("serviceNo"));
		mapForDS.put("hinId", box.getInt("hinId"));
		mapForDS.put("deptId", box.getInt("deptId"));
		mapForDS.put("visitId", box.getInt("visitId"));
		mapForDS.put("hospitalId", box.getInt("hospitalId"));
		mapForDS.put("patientInvestigationHeaderId", box.getInt("patientInvestigationHeaderId"));
		mapForDS.put("investigationDataStatus", box.getString("investigationDataStatus"));
		mapForDS.put("clinicalNotes1", box.getString("clinicalNotes1"));
		mapForDS.put("dgOrderhdId", box.getInt("dgOrderhdId"));
		mapForDS.put("empId", box.getInt("empId"));
		mapForDS.put("lastChangedBy", box.getString("lastChangedBy"));
		mapForDS.put("lastChangedDate", HMSUtil.convertStringTypeDateToDateType(currentDate));
		mapForDS.put("lastChangedTime", time);
		mapForDS.put("deleatedValue", box.getString("deleatedValue"));
		mapForDS.put("deleatedOrderid", box.getInt("deleatedOrderid"));
		int hiddenValue = box.getInt("hiddenValue");
		String data = box.getString("data");

		for (int i = 1; i <= hiddenValue; i++) {
			String chargeCodeNameWithId = box.getString("chargeCodeName" + i);
			int index1 = chargeCodeNameWithId.lastIndexOf("[");
			int index2 = chargeCodeNameWithId.lastIndexOf("]");
			index1++;
			String chargeCodeName = chargeCodeNameWithId.substring(0,
					(index1 - 1));
			String chargeCodeId = chargeCodeNameWithId
					.substring(index1, index2);
			if (!chargeCodeId.equals("")) {
				if (!box.getString("investigationReferToMH" + i).equals("")) {
					investigationReferToMHList.add("y");
				} else {
					investigationReferToMHList.add("n");
				}
				if (!data.equals("")) {

					if (!box.getString("Result" + i).equals("")) {
						investResultList.add(box.getString("Result" + i));

					} else {
						investResultList.add(" ");
					}
				}
				chargeCodeIdList.add(chargeCodeId);

				if (!box.getString("patientInvestigationdetailsId" + i).equals("")) {
					patientInvestigationdetailsIdList.add(Integer.parseInt(box
							.getString("patientInvestigationdetailsId" + i)));
				} else {
					patientInvestigationdetailsIdList.add(new Integer(0));
				}
				if (!box.getString("dgOrderdtId" + i).equals("")) {
					dgOrderdtIdList.add(Integer.parseInt(box.getString("dgOrderdtId" + i)));
				} else {
					dgOrderdtIdList.add(new Integer(0));
				}
			}
		}
		mapForDS.put("chargeCodeIdList", chargeCodeIdList);
		mapForDS.put("investResultList", investResultList);
		mapForDS.put("investigationReferToMHList", investigationReferToMHList);
		mapForDS.put("patientInvestigationdetailsIdList",
				patientInvestigationdetailsIdList);
		mapForDS.put("dgOrderdtIdList", dgOrderdtIdList);

		try {
			boolean saveinvestigation = false;

			saveinvestigation = updateInvestigation(mapForDS);
			if (saveinvestigation) {
				tx = session.beginTransaction();
				hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				int medExamId = box.getInt("medExamId");
				MasMedicalExaminationReportOnEntry medicalExaminationReportOnEntry = (MasMedicalExaminationReportOnEntry) hbt
						.load(MasMedicalExaminationReportOnEntry.class,medExamId);
				medicalExaminationReportOnEntry.setSplDisability(box.getString("splDisability"));
				medicalExaminationReportOnEntry.setLastReview(box.getString("lastReview"));
				medicalExaminationReportOnEntry.setCourseOfIllness(box.getString("courseOfIllness"));
				medicalExaminationReportOnEntry.setGeneralExam(box.getString("generalExam"));
				medicalExaminationReportOnEntry.setDisOnset(box.getString("disOnset"));
				if (!box.getString("heightWithoutShoose").equals(""))
					medicalExaminationReportOnEntry.setHeight(new BigDecimal(
									box.getString("heightWithoutShoose")));
				if (!box.getString("actulWeight").equals(""))
					medicalExaminationReportOnEntry.setActualweight(box.getString("actulWeight"));
				medicalExaminationReportOnEntry.setIdealweight(box.getString("idealweight"));
				medicalExaminationReportOnEntry.setOverweight(box.getString("overweight"));
				medicalExaminationReportOnEntry.setBhi(box.getString("bhi"));
				medicalExaminationReportOnEntry.setBodyfat(box.getString("bodyfat"));
				medicalExaminationReportOnEntry.setWaist(box.getString("waist"));
				medicalExaminationReportOnEntry.setHips(box.getString("Hips"));
				medicalExaminationReportOnEntry.setWhr(box.getString("WHR"));
				medicalExaminationReportOnEntry.setSignfoldthickness(box.getString("thickness"));
				medicalExaminationReportOnEntry.setChestfullexpansion(box.getString("chestfull"));
				medicalExaminationReportOnEntry.setRangeofexpansion(box.getString("rangeexpansion"));
				medicalExaminationReportOnEntry.setSportman(box	.getString("sport"));
				medicalExaminationReportOnEntry.setGeneralPhysicalExam(box
							.getString("generalPhysicalExam"));
				medicalExaminationReportOnEntry.setCardiovascularSystem(box
							.getString("cardiovascularSystem"));
				medicalExaminationReportOnEntry.setRespiratorySystem(box
							.getString("respairatorySystem"));
				medicalExaminationReportOnEntry.setGastroIntestinalSystem(box
							.getString("gastroIntestinalSystem"));
				medicalExaminationReportOnEntry.setCentralNervousSystemMMHG(box
							.getString("breakDown"));
				medicalExaminationReportOnEntry.setCentralNervousSystem(box
							.getString("centralNervousSystem"));
				if (box.getString("localExamination") != null
						&& !box.getString("localExamination").equals("")) {
					medicalExaminationReportOnEntry.setLocalExamination(box
							.getString("localExamination"));
				}
				if (box.getString("SpecilaistOpinionRemark") != null
						&& !box.getString("SpecilaistOpinionRemark").equals("")) {
					medicalExaminationReportOnEntry
							.setSpecilaistOpinionRemark(box
									.getString("SpecilaistOpinionRemark"));
				}
				if (box.getString("SpecilaistTreatmentAdvice") != null
						&& !box.getString("SpecilaistTreatmentAdvice").equals("")) {
					medicalExaminationReportOnEntry.setSpecilaistTreatmentAdvice(box
									.getString("SpecilaistTreatmentAdvice"));
				}
				if (!box.getString("SpecilaistOpinionDate").equals(""))
					medicalExaminationReportOnEntry.setSpecilaistOpinionDate(HMSUtil
					.convertStringTypeDateToDateType(box
											.getString("SpecilaistOpinionDate")));
				medicalExaminationReportOnEntry.setMedboardDuration(new BigDecimal(box.getString("medboardDuration")));
				int catgId = box.getInt("medCatNowRecommend");
				if (catgId != 0) {
					Category category = new Category();
					category.setCategoryid(catgId);
					medicalExaminationReportOnEntry
							.setMedicalCategoryRecomended(category);
				}
				/**
				 * Added By Mansi
				 */
				if (!box.getString("sd").equals("")){
						medicalExaminationReportOnEntry.setSD(box.getString("sd"));
				}
				/**
				 * End
				 */
				
				Users user = new Users();
				user.setId(box.getInt("userId"));
				medicalExaminationReportOnEntry.setSpecialistUser(user);
				hbt.update(medicalExaminationReportOnEntry);
				successfullyAdded = true;
				tx.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("directFlag", box.getString("directFlag"));
		map.put("admissionStatus", box.getString("admissionStatus"));
		map.put("medExamId", box.getInt("medExamId"));
		map.put("investigationReferToMHList", investigationReferToMHList);
		map.put("hinNoForreport", box.getString("hinNoForreport"));
		map.put("visitNumberForReport", box.getInt("visitNumberForReport"));
		map.put("serviceNo", box.getString("serviceNo"));
		map.put("successfullyAdded", successfullyAdded);
		return map;
	
	}
	@Override
	public Map<String, Object> showForm44Jsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> unitList = null;
		Session session = (Session)getSession();
		unitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(Order.asc("UnitName")).list();
		map.put("unitList", unitList);
		return map;
	}

	@Override
	public Map<String, Object> getRankList(int rankId, int tradeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		rankList = session.createCriteria(MasRank.class).add(Restrictions.idEq(rankId)).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.idEq(tradeId)).list();
		String rankName = "";
		String tradeName = "";
		if(rankList.size()>0){
			rankName = rankList.get(0).getRankName();
		}
		if(tradeList.size()>0){
		tradeName = tradeList.get(0).getTradeName();
		}
		map.put("rankName", rankName);
		map.put("tradeName", tradeName);
		return map;
	}

	@Override
	public Map<String, Object> showPrintValidateMOMedicalExam(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;

		String[] statusArr = { "v", "o" };
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.in("Status",statusArr)).add(Restrictions.eq("medicalType", "MedicalExam"))
				.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(
						Order.desc("Id"));

		patientDetailList = crit.list();
		map.put("patientDetailList", patientDetailList);

		return map;

 }
	@Override
	public Map<String, Object> getMedicalType(int visitId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> medicalTypeList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		String medicalType="";
		String[] statusArr = { "v", "o" };
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.in("Status", statusArr)).add(Restrictions.eq("medicalType", "MedicalExam"))
				.add(Restrictions.eq("Visit.Id",visitId));

		medicalTypeList = crit.list();
		for(MasMedicalExaminationReportOnEntry medTypeReport:medicalTypeList){
			medicalType=medTypeReport.getVisit().getMedExamType();
		}
		map.put("medicalType", medicalType);
		map.put("medicalTypeList", medicalTypeList);

		return map;
	}

	@Override
	public String getHospitalName(int hospitalId) {
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Session session = (Session)getSession();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.idEq(hospitalId)).list();
		String hospitalName = "";
		if(hospitalList.size()>0){
			hospitalName = hospitalList.get(0).getHospitalName();
		}
		return hospitalName;
	}

	@Override
	public Map<String, Object> submitAFMSF7AJsp(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		List<Integer> itemIdList = (List<Integer>) mapForDS.get("itemIdList");
		List<Integer> frequencyList = (List) mapForDS.get("frequencyList");
		List<String> otherMedicineList = (List) mapForDS.get("otherMedicineList");
		List<String> nomenclatureList =  (List) mapForDS.get("nomenclatureList");
		List<Integer> itemConversionList = (List) mapForDS.get("itemConversionList");
		List<String> ctList = (List) mapForDS.get("ctList");
		List<String> dosageList = (List) mapForDS.get("dosageList");
		
		List<String> routeList = new ArrayList<String>();
		routeList= (List) mapForDS.get("routeList");
		List<Integer> totalList = (List) mapForDS.get("totalList");
		List<Integer> noOfDaysList = (List) mapForDS.get("noOfDaysList");
		List<String> remarksList = (List) mapForDS.get("remarksList");
		List<String> chargeCodeIdList = (List) mapForDS.get("chargeCodeIdList");
		List<String> referToMhList = new ArrayList<String>();
		if((List)mapForDS.get("referToMhList") != null){
			referToMhList = (List)mapForDS.get("referToMhList");
		}
		int hinId = (Integer) mapForDS.get("hinId");
		int departmentId = (Integer) mapForDS.get("departmentId");
		int visitId = (Integer) mapForDS.get("visitId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		String height = (String) mapForDS.get("height");
		String whr = (String) mapForDS.get("whr");
		String weight = (String) mapForDS.get("weight");
		String pulse = (String) mapForDS.get("pulse");
		String disposal = (String) mapForDS.get("disposal");
		String days = (String) mapForDS.get("days");
		
		
		
		
		int empId = (Integer) mapForDS.get("empId");
		int empIdCurrnet= (Integer) mapForDS.get("empIdCurrnet");
		int userId = (Integer) mapForDS.get("userId");

		int deptId = (Integer) mapForDS.get("deptId");

		String bp = (String) mapForDS.get("bp");
		String userName = (String) mapForDS.get("userName");
		String temperature = (String) mapForDS.get("temperature");
		String afmsDescription = (String) mapForDS.get("afmsDescription");
		String consultationTime = (String) mapForDS.get("consultationTime");
		String consultationDate = (String) mapForDS.get("consultationDate");
		Date consultationDateToInsert = HMSUtil
				.convertStringTypeDateToDateType(consultationDate);
		String initialDiagnosis = (String) mapForDS.get("initialDiagnosis");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentTimeWithoutSecond();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		String plan = (String) mapForDS.get("plan");
		String nextVisitDate = (String) mapForDS.get("nextVisitDate");
		String onExamination = (String) mapForDS.get("onExamination");

		String presentComplain = (String) mapForDS.get("presentComplain");
		String allergies = "";
		if(mapForDS.get("allergies")!= null){
			allergies = (String)mapForDS.get("allergies");
		}
		String reviewAt = "";
		if(mapForDS.get("reviewAt")!= null){
			reviewAt = (String)mapForDS.get("reviewAt");
		}
		String referredDoctars = (String) mapForDS.get("referredDoctars");
		String riskFactor = (String) mapForDS.get("riskFactor");
		String bmi = (String) mapForDS.get("bmi");
		String idealWeight = (String) mapForDS.get("idealWeight");
		Date nextVisitDateToInsert = HMSUtil.convertStringTypeDateToDateType(nextVisitDate);

		String clinicalNotes1 = (String) mapForDS.get("clinicalNotes1");
		String returnfromHospital = (String) mapForDS.get("returnfromHospital");
		String referedToMH = (String) mapForDS.get("referedToMH");
		String gpe_examination = (String) mapForDS.get("gpe_examination");
		String rr =  (String)mapForDS.get("rr");
		String systamicExam="";
		if(mapForDS.get("systamicExam")!=null){
			systamicExam = (String) mapForDS.get("systamicExam");
		}
		String mhString = "";
		if(mapForDS.get("mh")!=null){
			mhString = (String) mapForDS.get("mh");
		}
		String mhDepartment = "";
		if(mapForDS.get("mhDepartment")!=null){
			mhDepartment = (String) mapForDS.get("mhDepartment");
		}
		String mhReferredFor = "";
		if(mapForDS.get("mhReferredFor")!=null){
			mhReferredFor = (String) mapForDS.get("mhReferredFor");
		}
	
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			
			
			
			
			OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
			Visit visitsave = new Visit();
			visitsave=(Visit) hbt.load(Visit.class, visitId);
			visitsave.setDiagnosisString(initialDiagnosis);
			visitsave.setDisposalName(disposal);
			visitsave.setDisposalDays(days);
		
			hbt.update(visitsave);
			Visit visitObj = new Visit();
			visitObj.setId(visitId);
						//visitObj.setDiagnosisString(initialDiagnosis);
			//hbt.update(visitObj);
			opdPatientDetails.setVisit(visitObj);
			if (empId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(empId);
				opdPatientDetails.setEmployee(masEmployee);
			}
			MasHospital masHospitalObj = new MasHospital();
			masHospitalObj.setId(hospitalId);
			opdPatientDetails.setHospital(masHospitalObj);
			opdPatientDetails.setHeight(height);
			opdPatientDetails.setWhr(whr);
			opdPatientDetails.setDisposal(disposal);
			opdPatientDetails.setDays(days);
			opdPatientDetails.setVweight(weight);
			opdPatientDetails.setPulse(pulse);
			opdPatientDetails.setBp(bp);
			if (temperature!=null) {
				opdPatientDetails.setTemperature(temperature);
			}
			opdPatientDetails.setAfmsDesc(afmsDescription);
			opdPatientDetails.setConsultationTime(consultationTime);
			opdPatientDetails.setConsultationDate(consultationDateToInsert);
			opdPatientDetails.setPlan(plan);
			opdPatientDetails.setInitialDiagnosis(initialDiagnosis);
	
			opdPatientDetails.setOpdDate(date);
			opdPatientDetails.setOpdTime(time);
			opdPatientDetails.setNextVisitDate(nextVisitDateToInsert);
			//opdPatientDetails.setReferredDept(referredDept);
			opdPatientDetails.setReferedDoctars(referredDoctars);
			opdPatientDetails.setOnExamination(onExamination);
			opdPatientDetails.setReturnfromHospital(returnfromHospital);
			opdPatientDetails.setMhRun(referedToMH);
			//if(referedToMH.equals("y")){
				opdPatientDetails.setMh(mhString);
				opdPatientDetails.setMhDepartment(mhDepartment);
				opdPatientDetails.setMhReferredFor(mhReferredFor);
			//}

			opdPatientDetails.setGpe_examination(gpe_examination);
			opdPatientDetails.setRr(rr);
			opdPatientDetails.setSystamicExam(systamicExam);
			opdPatientDetails.setBmi(bmi);
			opdPatientDetails.setIdealWeight(idealWeight);
			opdPatientDetails.setCaseNotes(clinicalNotes1);
	
			//---------commented by anamika---------//
			/*String delimiter = ",";
			String[] temp;
			temp = referredDept.split(delimiter);
			Boolean flag=false;
			for(int i =0; i < temp.length ; i++)
			{
				if(temp[i].equalsIgnoreCase("87"))
				{
					flag=true;
					
				}
			}
			if(flag)
			{
				opdPatientDetails.setPhyStatus("w");
			}else
			{
				opdPatientDetails.setPhyStatus("c");
			}*/
		//	
			opdPatientDetails.setPhyStatus("c");
			hbt.save(opdPatientDetails);

			
			
			
			
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings = new MasMedicalExaminationReportOnEntry();
			masMedicalBoardProceedings.setVisit(visitObj);
			
			String lastame="";
			lastame=(String)mapForDS.get("lastame");
			masMedicalBoardProceedings.setLastame(lastame);
			
			String conditionOfGums="";
			conditionOfGums = (String) mapForDS.get("conditionOfGums");
			masMedicalBoardProceedings.setConditionOfGums(conditionOfGums);
			
			
			String pName="";
			pName = (String) mapForDS.get("pName");
			masMedicalBoardProceedings.setNameInFull(pName);
			
			
			String serviceNo="";
			serviceNo = (String) mapForDS.get("serviceNo");
			masMedicalBoardProceedings.setYearlySerialNo(serviceNo);
			
			
			int catId = (Integer) mapForDS.get("catId");
			if(catId!=0)
			{
			Category categ2 = new Category();
			categ2.setCategoryid(catId);
			masMedicalBoardProceedings.setPresentMedicalCategory(categ2);
			}
			
			int rankId = (Integer) mapForDS.get("rankId");
			if(rankId!=0)
			{
			MasRank rank = new MasRank();
			rank.setId(rankId);
			masMedicalBoardProceedings.setRank(rank);
			}
			
			int tradeId = (Integer) mapForDS.get("tradeId");
			
			if(tradeId!=0)
			{
			MasTrade trade = new MasTrade();
			trade.setId(tradeId);
			masMedicalBoardProceedings.setTrade(trade);
				}
			
			String dateLast="";
			
			dateLast = (String) mapForDS.get("dateLast");
			if(dateLast!=""){
			masMedicalBoardProceedings.setDateMedicalBoardSubsequent(HMSUtil.convertStringTypeDateToDateType(dateLast));
			}else
			{
				masMedicalBoardProceedings.setDateMedicalBoardSubsequent(null);
			}
			
			
			hbt.save(masMedicalBoardProceedings);
			// --------------- values to be Opd Patient
			// History--------------------

			OpdPatientHistory opdPatientHistory = new OpdPatientHistory();

			MasDepartment md = new MasDepartment();
			md.setId(departmentId);
			opdPatientHistory.setDepartment(md);
     
			MasHospital mh = new MasHospital();
			mh.setId(hospitalId);
			opdPatientHistory.setHospital(mh);

			Patient p = new Patient();
			p.setId(hinId);
			opdPatientHistory.setHin(p);

			/*
			 * Visit visit = new Visit(); visit.setId(visitId);
			 */
			opdPatientHistory.setVisitInpatientId(visitId);

			opdPatientHistory.setLastChgTime(time);
			opdPatientHistory.setLastChgBy("admin");

			opdPatientHistory.setStatus("y");
			opdPatientHistory.setLastChgDate(date);

			//-----commented by anamika-------------
			//opdPatientHistory.setFamilyPastHistory(familyHistory);
			opdPatientHistory.setRiskFactor(riskFactor);
	
			opdPatientHistory.setPresentComplain(presentComplain);
	

			opdPatientHistory.setIpOpPacStatus("OP");

			opdPatientHistory.setOpdPatientDetails(opdPatientDetails);

			hbt.save(opdPatientHistory);
	
			//------------update Patient Table for other Family History-------------------//
			
			Patient ptObj = (Patient)hbt.load(Patient.class, hinId);
			ptObj.setDrugAllergies(allergies);
			hbt.update(ptObj);
			
			//-----------------------------------------------------------------------

			// --------------- values to be updated in visit table to change
			// it's status--------------------

			Visit visitObjToUpdate = (Visit) hbt.load(Visit.class, visitId);
			visitObjToUpdate.setVisitStatus("C");
			/* Original  token no and Doctor set at the time of visit creation */
			/*if(visitObjToUpdate.getDoctor()!=null){
				String tokenAndDoctor="";
				tokenAndDoctor=""+visitObjToUpdate.getTokenNo();
				tokenAndDoctor=tokenAndDoctor+"#"+visitObjToUpdate.getDoctor().getId();
				visitObjToUpdate.setTokenDoctor(tokenAndDoctor);
			}*/
			/* If Other Doctor will attend to patient then update doctor id in visit table  */
			if(empIdCurrnet>0){
				MasEmployee doctor=new MasEmployee();
				doctor.setId(empIdCurrnet);
				visitObjToUpdate.setDoctor(doctor);
			}
			hbt.update(visitObjToUpdate);

			// -----------------------------------------------------------------------------------

			// --------------values to be entered in discharge table for
			// diagnosis----------------------
		
			
			PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
			int item_category_id=0;
			if(itemIdList.size() > 0){
				Patient patient = new Patient();
				patient.setId(hinId);
				patientPrescriptionHeader.setHin(patient);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				patientPrescriptionHeader.setDepartment(masDepartment);
				Visit visit = new Visit();
				visit.setId(visitId);
				patientPrescriptionHeader.setVisit(visit);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				patientPrescriptionHeader.setHospital(masHospital);
				patientPrescriptionHeader.setStatus("p");
				patientPrescriptionHeader
						.setPrescriptionDate(consultationDateToInsert);
				patientPrescriptionHeader.setPrescriptionTime(consultationTime);
				/**
				 * Code By Ritu 
				 * Created Foreign key relation for emp id in Database
				 */
				MasEmployee employee = new MasEmployee();
				employee.setId(empId);
				patientPrescriptionHeader.setEmp(employee);
				
				/**
				 * End of code by Ritu
				 */
				int prescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);
				patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
				patientPrescriptionHeader.setOpdPatientDetails(opdPatientDetails);
				
				/*
				 * This block is use for Check Injection in Prescription List
				 */
				//----------------commented by anamika for itemId================
				String sqlItemId="";
			//	List<Integer> itemList = new ArrayList<Integer>();
				for (int i = 0; i < itemIdList.size(); i++) {
					/*String pvmsNo = (String) itemIdList.get(i);
					String nomenclature = (String) nomenclatureList.get(i);
					int itemId = getItemIdFromPVMS(nomenclature,pvmsNo,hospitalId);*/
					int itemId = (Integer)itemIdList.get(i);;
					if(i==0){
						sqlItemId=""+itemId;
					}else{
						sqlItemId +=" , "+itemId;
					}
				//	itemIdList.add(itemId);
				}
				List<MasStoreItem> masItemList=new ArrayList<MasStoreItem>();
				Properties properties = new Properties();
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("adt.properties");
				
				try {
					properties.load(resourcePath.openStream());

					String item_category_code = properties.getProperty("item_category_id");
					item_category_id=Integer.parseInt(item_category_code);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(!sqlItemId.equals(""))
			//		masItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id in ("+sqlItemId+") and ic.Id="+item_category_id);
				masItemList=session.createCriteria(MasStoreItem.class).createAlias("ItemCategory", "itg")
							.add(Restrictions.eq("Id", sqlItemId)).add(Restrictions.eq("itg.Id", item_category_id))
							.setProjection(Projections.projectionList().add(Projections.property("Id"))).list();
				if(masItemList.size()>0){
					patientPrescriptionHeader.setInjectionStatus("p");
				}else{
					patientPrescriptionHeader.setInjectionStatus("n");
				}
				/*
				 * End Of Code This block is use for Check Injection in Prescription List
				 */
				
				hbt.save(patientPrescriptionHeader);
			}/** else part added by Ritu for other treatment details **/
			else if(itemIdList.size() == 0 && mapForDS.get("otherTreatment")!=null && !(mapForDS.get("otherTreatment")).equals("")){

				Patient patient = new Patient();
				patient.setId(hinId);
				patientPrescriptionHeader.setHin(patient);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				patientPrescriptionHeader.setDepartment(masDepartment);
				Visit visit = new Visit();
				visit.setId(visitId);
				patientPrescriptionHeader.setVisit(visit);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				patientPrescriptionHeader.setHospital(masHospital);
				patientPrescriptionHeader.setStatus("p");
				patientPrescriptionHeader
						.setPrescriptionDate(consultationDateToInsert);
				patientPrescriptionHeader.setPrescriptionTime(consultationTime);
				
				MasEmployee employee = new MasEmployee();
				employee.setId(empId);
				patientPrescriptionHeader.setEmp(employee);
				
			
				int prescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);
				patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
				patientPrescriptionHeader.setOpdPatientDetails(opdPatientDetails);
		
				patientPrescriptionHeader.setInjectionStatus("n");
				patientPrescriptionHeader.setOtherTreatment((String)mapForDS.get("otherTreatment"));
				
				hbt.save(patientPrescriptionHeader);
			
				
			}
			if (itemIdList.size() > 0 ) {
				for (int i = 0; i < itemIdList.size(); i++) {
					if(itemIdList.get(i) !=0){
					List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
					PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
					if(itemIdList.get(i) != null){
						MasStoreItem masStoreItem = new MasStoreItem();
						masStoreItem.setId(itemIdList.get(i));
					patientPrescriptionDetails.setItem(masStoreItem);
					}
					if (frequencyList.get(i) != null && !frequencyList.get(i).equals("")) {
						MasFrequency masFrequency = new MasFrequency();
						masFrequency.setId(frequencyList.get(i));
						patientPrescriptionDetails.setFrequency(masFrequency);
						}
						if (dosageList.get(i) != null && !dosageList.get(i).equals("") && !dosageList.get(i).equals("0")) {
							patientPrescriptionDetails.setDosage(dosageList.get(i));
						}else{
							patientPrescriptionDetails.setDosage("0");
						}
						if (remarksList.get(i) != null && !remarksList.get(i).equals("")) {
							patientPrescriptionDetails.setRemarks(remarksList.get(i));
						}
						//patientPrescriptionDetails.setType(typeLeftRightList.get(i));
						if (noOfDaysList.get(i) != null && !noOfDaysList.get(i).equals("")) {
							patientPrescriptionDetails.setNoOfDays(noOfDaysList.get(i));
						}
						if (routeList.get(i) != null && !routeList.get(i).equals("")) {
							patientPrescriptionDetails.setRoute(routeList.get(i));
						}
						/*if (totalList.get(i) != null && !totalList.get(i).equals("")) {
							patientPrescriptionDetails.setTotal(Math.round(totalList.get(i).floatValue()));
						}*/
						if (totalList.get(i) != null && !totalList.get(i).equals("") && totalList.get(i) != 0) {
							patientPrescriptionDetails.setTotal(totalList.get(i));
						}else{
							patientPrescriptionDetails.setTotal(1);
						}
						patientPrescriptionDetails.setGivenQty(0);
					
					//patientPrescriptionDetails.setType(typeLeftRightList.get(i));
					
					//patientPrescriptionDetails.setInstruction(instructionList.get(i));
					
					
					patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
				
					patientPrescriptionDetails.setDetailStatus("a");
					List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
					//storeItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id="+itemIdList.get(i)+" and ic.Id="+item_category_id);
					storeItemList=session.createCriteria(MasStoreItem.class).createAlias("ItemCategory", "itg")
					.add(Restrictions.eq("Id", itemIdList.get(i))).add(Restrictions.eq("itg.Id", item_category_id))
					.setProjection(Projections.projectionList().add(Projections.property("Id"))).list();
					if(storeItemList.size() > 0){
						patientPrescriptionDetails.setInjectionStatus("p");
					}else{
						patientPrescriptionDetails.setInjectionStatus("n");
					}
					if(ctList.get(i).equals("y")){
						patientPrescriptionDetails.setCt("yes");
					}else{
						patientPrescriptionDetails.setCt("no");
					}
					
					hbt.save(patientPrescriptionDetails);
					
					/**
					 * This Code is use for Injection Appointment
					 * Code By Ritu Sahu
					 * Date 07 Nov 2011
					 */
					
					if(storeItemList.size()>0){
						List<InjAppointmentHeader> injectionRegisterList=new ArrayList<InjAppointmentHeader>();
						//injectionRegisterList=hbt.find("select inj from jkt.hms.masters.business.InjAppointmentHeader as inj join inj.Visit as visit where visit.Id="+visitId);
						injectionRegisterList=session.createCriteria(InjAppointmentHeader.class).add(Restrictions.eq("Visit.Id", visitId)).list();
						InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();
						
						 /* if(injectionRegisterList.size()>0) means , Data is already available In InjectionRegister table  */
						 
						if(injectionRegisterList.size()>0){
							for (InjAppointmentHeader injectionRegisterTemp : injectionRegisterList) {
								injectionAppointment.setId(injectionRegisterTemp.getId());
							}
						}else{
							injectionAppointment.setAppointmentDate(new Date());
							Patient patientInj = new Patient();
							patientInj.setId(hinId);
							injectionAppointment.setHin(patientInj);
							Visit visitInj = new Visit();
							visitInj.setId(visitId);
							injectionAppointment.setVisit(visitInj);
							MasHospital masHospitalInj = new MasHospital();
							masHospitalInj.setId(hospitalId);
							injectionAppointment.setHospital(masHospitalInj);
							
							injectionAppointment.setStatus("p");
							injectionAppointment.setLastChgTime(time);
							Users user = new Users();
							user.setId(userId);
							injectionAppointment.setLastChgBy(user);
							injectionAppointment.setLastChgDate(date);
							injectionAppointment.setPrescription(patientPrescriptionHeader);
							hbt.save(injectionAppointment);
						}
						int freqCount=0;
						if(frequencyList.get(i) > 10){
							freqCount = 1; /* if frequency is greater than 10 then only one entry will go in Injection Appointment table*/
						}else{
							freqCount = frequencyList.get(i);
						}
						if(freqCount > 0){	
							for (int j = 1; j <= freqCount; j++) {
								InjAppointmentDetails injAppointmentDetails = new InjAppointmentDetails();
								injAppointmentDetails.setAppointmentTime(time);
								injAppointmentDetails.setDose(dosageList.get(i));
								MasFrequency frequency = new MasFrequency();
								frequency.setId(frequencyList.get(i));
								injAppointmentDetails.setFrequency(frequency);
								injAppointmentDetails.setRoute(routeList.get(i));
								MasStoreItem item = new MasStoreItem();
								item.setId(itemIdList.get(i));
								injAppointmentDetails.setItem(item);
								injAppointmentDetails.setInjAppointmentHeader(injectionAppointment);
								injAppointmentDetails.setNoOfDays(noOfDaysList.get(i));
								injAppointmentDetails.setPatientPrescriptionDetails(patientPrescriptionDetails);
								injAppointmentDetails.setStatus("p");
								hbt.save(injAppointmentDetails);
							}
						}
					}
					/**
					 * END Of COde
					 * This Code is use for Injection
					 * Code By Ritu Sahu
					 * Date 07 Nov 2011
					 */
				}
				}
			}

			//-------------------------------------------------
			if(otherMedicineList != null && otherMedicineList.size() > 0){
				String sqlItemId="";
				int itemId = 0;
				/*PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
				Patient patient = new Patient();
				patient.setId(hinId);
				patientPrescriptionHeader.setHin(patient);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				patientPrescriptionHeader.setDepartment(masDepartment);
				Visit visit = new Visit();
				visit.setId(visitId);
				patientPrescriptionHeader.setVisit(visit);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				patientPrescriptionHeader.setHospital(masHospital);
				patientPrescriptionHeader.setStatus("p");
				patientPrescriptionHeader
						.setPrescriptionDate(consultationDateToInsert);
				patientPrescriptionHeader.setPrescriptionTime(consultationTime);
				*//**
				 * Code By Ritu 
				 * Created Foreign key relation for emp id in Database
				 *//*
				MasEmployee employee = new MasEmployee();
				employee.setId(empId);
				patientPrescriptionHeader.setEmp(employee);
				
				*//**
				 * End of code by Ritu
				 *//*
				int prescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);
				patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
		
				for(int i = 0; i < injCategoryList.size(); i++){
					if(injCategoryList.get(i).equals("y")){
						patientPrescriptionHeader.setInjectionStatus("p");
						break;
					}else{
						patientPrescriptionHeader.setInjectionStatus("n");
					}
				}
				
				 * End Of Code This block is use for Check Injection in Prescription List
				 
				
				hbt.save(patientPrescriptionHeader);*/

				List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
				String otherItem = "";
				if(otherMedicineList.size() >0){
				for(int i = 0; i < otherMedicineList.size(); i++){
					MasStoreItem masItem = new MasStoreItem();
					if(otherMedicineList.get(i) != null && !otherMedicineList.get(i).equals("")){
						otherItem =(String)otherMedicineList.get(i);
						masItem.setNomenclature(otherMedicineList.get(i));
						MasStoreSection masStoreSection = new MasStoreSection();
						masStoreSection.setId(1);
						masItem.setSection(masStoreSection);
						masItem.setStatus("y");
						masItem.setBrandedGeneric("B");
						if (itemConversionList.get(i) != null && !itemConversionList.get(i).equals("")) {
							MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
							masStoreItemConversion.setId(itemConversionList.get(i));
							masItem.setItemConversion(masStoreItemConversion);
							}
						MasItemType masItemType = new MasItemType();
						masItemType.setId(2);
						masItem.setItemType(masItemType);
						MasHospital masHospital = new MasHospital();
						masHospital.setId(hospitalId);
						masItem.setHospital(masHospital);
						masItem.setLastChgBy(userName);
						masItem.setLastChgDate(date);
						masItem.setLastChgTime(time);
						
						/*itemCodeList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo", "NIV%")).add(Restrictions.eq("Hospital.Id", hospitalId))
						.addOrder(Order.desc("Id")).setMaxResults(1).list();
						String itemNo = "";
						if(itemCodeList.size()>0){
							MasStoreItem masStoreItem =itemCodeList.get(0);
							String itemCode = masStoreItem.getPvmsNo();
							StringTokenizer str = new StringTokenizer(itemCode, "/");
							String itemNivCode = "";
							while (str.hasMoreTokens()) {

								itemNivCode = str.nextToken();

							}
							int itemNiv =Integer.parseInt(itemNivCode)+1;
							itemNo = "NIV/"+itemNiv;
						}else{
							itemNo = "NIV/011"; 
						}*/
						masItem.setPvmsNo("temp");
						hbt.save(masItem);

				
					PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
					if(masItem.getId() != null){
						MasStoreItem masStoreItem = new MasStoreItem();
						masStoreItem.setId(masItem.getId());
					patientPrescriptionDetails.setItem(masStoreItem);
					}
					if (frequencyList.get(i) != null && !frequencyList.get(i).equals("")) {
					MasFrequency masFrequency = new MasFrequency();
					masFrequency.setId(frequencyList.get(i));
					patientPrescriptionDetails.setFrequency(masFrequency);
					}
					if (dosageList.get(i) != null && !dosageList.get(i).equals("")) {
						patientPrescriptionDetails.setDosage(dosageList.get(i));
					}
					if (remarksList.get(i) != null && !remarksList.get(i).equals("")) {
					patientPrescriptionDetails.setRemarks(remarksList.get(i));
					}
					//patientPrescriptionDetails.setType(typeLeftRightList.get(i));
					if (noOfDaysList.get(i) != null && !noOfDaysList.get(i).equals("")) {
						patientPrescriptionDetails.setNoOfDays(noOfDaysList.get(i));
					}
					if (routeList.get(i) != null && !routeList.get(i).equals("")) {
						patientPrescriptionDetails.setRoute(routeList.get(i));
					}
					
					//patientPrescriptionDetails.setInstruction(instructionList.get(i));
					if (totalList.get(i) != null && !totalList.get(i).equals("")) {
						patientPrescriptionDetails.setTotal(totalList.get(i));
					}
					patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
					patientPrescriptionDetails.setGivenQty(0);
					patientPrescriptionDetails.setDetailStatus("a");
					List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
					/*if(injCategoryList.equals("y")){
						patientPrescriptionDetails.setInjectionStatus("p");
					}else{
						patientPrescriptionDetails.setInjectionStatus("n");
					}*/
					
					if(ctList.get(i).equals("y")){
						patientPrescriptionDetails.setCt("yes");
					}else{
						patientPrescriptionDetails.setCt("no");
					}
					
					
					hbt.save(patientPrescriptionDetails);
					
					/**
					 * This Code is use for Injection Appointment
					 * Code By Ritu Sahu
					 * Date 07 Nov 2011
					 */
					
					if(storeItemList.size()>0){
						List<InjAppointmentHeader> injectionRegisterList=new ArrayList<InjAppointmentHeader>();
						//injectionRegisterList=hbt.find("select inj from jkt.hms.masters.business.InjAppointmentHeader as inj join inj.Visit as visit where visit.Id="+visitId);
						injectionRegisterList=session.createCriteria(InjAppointmentHeader.class).add(Restrictions.eq("Visit.Id", visitId)).list();
						InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();
						
						 /* if(injectionRegisterList.size()>0) means , Data is already available In InjectionRegister table  */
						 
						if(injectionRegisterList.size()>0){
							for (InjAppointmentHeader injectionRegisterTemp : injectionRegisterList) {
								injectionAppointment.setId(injectionRegisterTemp.getId());
							}
						}else{
							injectionAppointment.setAppointmentDate(new Date());
							Patient patientInj = new Patient();
							patientInj.setId(hinId);
							injectionAppointment.setHin(patientInj);
							Visit visitInj = new Visit();
							visitInj.setId(visitId);
							injectionAppointment.setVisit(visitInj);
							MasHospital masHospitalInj = new MasHospital();
							masHospitalInj.setId(hospitalId);
							injectionAppointment.setHospital(masHospitalInj);
							
							injectionAppointment.setStatus("p");
							injectionAppointment.setLastChgTime(time);
							Users user = new Users();
							user.setId(userId);
							injectionAppointment.setLastChgBy(user);
							injectionAppointment.setLastChgDate(date);
							injectionAppointment.setPrescription(patientPrescriptionHeader);
							hbt.save(injectionAppointment);
						}
						int freqCount=0;
						if(frequencyList.get(i) > 10){
							freqCount = 1; /* if frequency is greater than 10 then only one entry will go in Injection Appointment table*/
						}else{
							freqCount = frequencyList.get(i);
						}
						if(freqCount > 0){	
							for (int j = 1; j <= freqCount; j++) {
								InjAppointmentDetails injAppointmentDetails = new InjAppointmentDetails();
								injAppointmentDetails.setAppointmentTime(time);
								injAppointmentDetails.setDose(dosageList.get(i));
								MasFrequency frequency = new MasFrequency();
								frequency.setId(frequencyList.get(i));
								injAppointmentDetails.setFrequency(frequency);
								injAppointmentDetails.setRoute(routeList.get(i));
								MasStoreItem item = new MasStoreItem();
								item.setId(itemIdList.get(i));
								injAppointmentDetails.setItem(item);
								injAppointmentDetails.setInjAppointmentHeader(injectionAppointment);
								injAppointmentDetails.setNoOfDays(noOfDaysList.get(i));
								injAppointmentDetails.setPatientPrescriptionDetails(patientPrescriptionDetails);
								injAppointmentDetails.setStatus("p");
								hbt.save(injAppointmentDetails);
							}
						}
					}
					}
					/**
					 * END Of COde
					 * This Code is use for Injection
					 * Code By Ritu Sahu
					 * Date 07 Nov 2011
					 */
				}
			}
			}
			
			
			// by Tirath for time without second
			Map<String, Object> utilMap1 = new HashMap<String, Object>();
			utilMap1 = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			
			String time1 = (String) utilMap1.get("currentTimeWithoutSc");
			
			if (chargeCodeIdList.size() > 0) {
				MasDepartment masDepartment = new MasDepartment();
				MasHospital masHospital = new MasHospital();
				Patient patient = new Patient();
				MasEmployee masEmployee2 = new MasEmployee();

				PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();

				patient.setId(hinId);
				patientInvestigationHeader.setHin(patient);

				masDepartment.setId(departmentId);
				patientInvestigationHeader.setDepartment(masDepartment);
				Visit visit = new Visit();
				visit.setId(visitId);
				patientInvestigationHeader.setVisit(visit);
				
				masHospital.setId(hospitalId);
				patientInvestigationHeader.setHospital(masHospital);
				patientInvestigationHeader.setStatus("p");
				patientInvestigationHeader
						.setInvestigationDate(consultationDateToInsert);
				patientInvestigationHeader.setInvestigationTime(consultationTime);
				patientInvestigationHeader.setClinicalNotes(clinicalNotes1);
				patientInvestigationHeader.setOpdPatientDetails(opdPatientDetails);
				hbt.save(patientInvestigationHeader);

				DgOrderhd dgOrderhd = new DgOrderhd();
				dgOrderhd.setOrderDate(consultationDateToInsert);
				dgOrderhd.setOrderTime(time1);
				masHospital.setId(hospitalId);
				dgOrderhd.setHospital(masHospital);
				patient.setId(hinId);
				dgOrderhd.setHin(patient);
				masDepartment.setId(departmentId);
				dgOrderhd.setDepartment(masDepartment);
				if (empId != 0) {
					masEmployee2.setId(empId);
					dgOrderhd.setPrescribedBy(masEmployee2);
				}
				dgOrderhd.setPatientType("OP");
				dgOrderhd.setTestType("Regular");
				dgOrderhd.setCreatedby(userName);
				dgOrderhd.setCreatedon(consultationDateToInsert);

	
				
				if (visitId != 0) {
					visit = new Visit();
					visit.setId(visitId);
					dgOrderhd.setVisit(visit);
				}
				dgOrderhd.setClinicalNote(clinicalNotes1);
				dgOrderhd.setOrderStatus("P");
				dgOrderhd.setLabOrderStatus("P");
				dgOrderhd.setLastChgBy(userId);
				dgOrderhd.setLastChgDate(consultationDateToInsert);
				dgOrderhd.setLastChgTime(consultationTime);
				dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
				hbt.save(dgOrderhd);
				for (int i = 0; i < chargeCodeIdList.size(); i++) {
					PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
					patientInvestigationDetails
					.setInvestigationHeader(patientInvestigationHeader);
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
					patientInvestigationDetails.setChargeCode(masChargeCode);
					//patientInvestigationDetails.setQuantity(quantityList.get(i));
					patientInvestigationDetails.setReferToMh(referToMhList.get(i));

					//patientInvestigationDetails.setClinicalNotes(clinicalList.get(i));
					hbt.save(patientInvestigationDetails);

					DgOrderdt dgOrderdt = new DgOrderdt();
					dgOrderdt.setOrderhd(dgOrderhd);
					masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
					dgOrderdt.setChargeCode(masChargeCode);
					//dgOrderdt.setOrderQty(quantityList.get(i));

					dgOrderdt.setCreatedby(userName);
					dgOrderdt.setCreatedon(consultationDateToInsert);
					dgOrderdt.setLastChgBy(userId);
					dgOrderdt.setLastChgDate(consultationDateToInsert);
					dgOrderdt.setLastChgTime(consultationTime);
					// method written for taking out the values of mascharge
					// code and subcharge
					Map masChargeMap = getMasChargeCodeFromChargeId(Integer
							.parseInt(chargeCodeIdList.get(i)));
					MasChargeCode masChargeCodeObj = (MasChargeCode) masChargeMap
					.get("masChargeCode");
					int mainChargeId = masChargeCodeObj.getMainChargecode()
					.getId();
					int subChargeId = masChargeCodeObj.getSubChargecode()
					.getId();
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
					dgOrderdt.setInvestigation(new DgMasInvestigation(Integer.parseInt(chargeCodeIdList.get(i))));
					dgOrderdt.setInvestigationToMH(referToMhList.get(i));
					dgOrderdt.setReferToMh(referToMhList.get(i));
					hbt.saveOrUpdate(dgOrderdt);
				}

			
				// for Lab Order Booking////////////
			}else if (chargeCodeIdList.size() == 0 && mapForDS.get("otherInvestigation")!=null && !(mapForDS.get("otherInvestigation")).equals("")) {
				MasDepartment masDepartment = new MasDepartment();
				MasHospital masHospital = new MasHospital();
				Patient patient = new Patient();
				MasEmployee masEmployee2 = new MasEmployee();

				PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();

				patient.setId(hinId);
				patientInvestigationHeader.setHin(patient);

				masDepartment.setId(departmentId);
				patientInvestigationHeader.setDepartment(masDepartment);
				Visit visit = new Visit();
				visit.setId(visitId);
				patientInvestigationHeader.setVisit(visit);
				
				masHospital.setId(hospitalId);
				patientInvestigationHeader.setHospital(masHospital);
				patientInvestigationHeader.setStatus("p");
				patientInvestigationHeader
						.setInvestigationDate(consultationDateToInsert);
				patientInvestigationHeader.setInvestigationTime(consultationTime);
				patientInvestigationHeader.setClinicalNotes(clinicalNotes1);
				patientInvestigationHeader.setOpdPatientDetails(opdPatientDetails);
				hbt.save(patientInvestigationHeader);

				DgOrderhd dgOrderhd = new DgOrderhd();
				dgOrderhd.setOrderDate(consultationDateToInsert);
				dgOrderhd.setOrderTime(time1);
				masHospital.setId(hospitalId);
				dgOrderhd.setHospital(masHospital);
				patient.setId(hinId);
				dgOrderhd.setHin(patient);
				masDepartment.setId(departmentId);
				dgOrderhd.setDepartment(masDepartment);
				if (empId != 0) {
					masEmployee2.setId(empId);
					dgOrderhd.setPrescribedBy(masEmployee2);
				}
				dgOrderhd.setPatientType("OP");
				dgOrderhd.setTestType("Regular");
				dgOrderhd.setCreatedby(userName);
				dgOrderhd.setCreatedon(consultationDateToInsert);

				if (visitId != 0) {
					visit = new Visit();
					visit.setId(visitId);
					dgOrderhd.setVisit(visit);
				}
				dgOrderhd.setClinicalNote(clinicalNotes1);
				dgOrderhd.setOrderStatus("P");
				dgOrderhd.setLabOrderStatus("P");
				dgOrderhd.setLastChgBy(userId);
				dgOrderhd.setLastChgDate(consultationDateToInsert);
				dgOrderhd.setLastChgTime(consultationTime);
				dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
				dgOrderhd.setOtherInvestigation((String)mapForDS.get("otherInvestigation"));
				hbt.save(dgOrderhd);
				
			}
	
		
			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
		//	session.close();
		}
		returnMap.put("visitId", visitId);
		returnMap.put("succesfullyAdded", succesfullyAdded);
		return returnMap;
	}
	
	public int getTransactionSequenceNoForPrescriptionNo(Map mapForDS) {
		Session session = (Session) getSession();

		int userId = (Integer) mapForDS.get("userId");
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
		//MasServiceType masserType=new MasServiceType();
		tranSeq.setServiceType(null);
		tranSeq.setMonth(currentYearInt);
		//Transaction tx = null;
		int hospitalId = (Integer)mapForDS.get("hospitalId");
		try {
				//	tx = session.beginTransaction();
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
         
		try {

			Criteria crit = session.createCriteria(TransactionSequence.class).add(Restrictions.eq("Hospital.Id", hospitalId))
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
			    orderNo=1;
			    transactionSequence.setMonth(currentYearInt);
			    transactionSequence.setCreatedby(userName);
			    transactionSequence.setTransactionSequenceNumber(orderNo+1);
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
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			tranSeq.setHospital(hospital);
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

	@Override
	public Map<String, Object> showAFMSF7AJsp(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		List<Visit> patientDataList = new ArrayList<Visit>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
		List<MasMedicalExaminationReportOnEntry> medicalList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<Category> categoryList = new ArrayList<Category>();
		HibernateTemplate hbt = getHibernateTemplate();
		int deptId = (Integer) mapForDS.get("deptId");
		int visitIdd = (Integer) mapForDS.get("visitId");
		try {
			patientDataList = session.createCriteria(Visit.class).add(
					Restrictions.eq("Id", visitIdd)).list();
			templateList = session.createCriteria(OpdTemplate.class)
					.createAlias("Department", "dept").add(
							Restrictions.eq("dept.Id", deptId)).add(
							Restrictions.eq("Status", "y")).list();
			frequencyList = session.createCriteria(MasFrequency.class).add(
					Restrictions.eq("Status", "y")).list();
			medicalList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.eq("Visit.Id",visitIdd )).list();
			itemConversionList = session.createCriteria(MasStoreItemConversion.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ItemUnitName")).list();
			categoryList=session.createCriteria(Category.class).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
		map.put("medicalList", medicalList);
		map.put("deptList", deptList);
		map.put("templateList", templateList); 
		map.put("frequencyList", frequencyList);	
		map.put("itemConversionList", itemConversionList);
		map.put("categoryList", categoryList);
		map.put("patientDataList", patientDataList);
		return map;

	}
	
	
	//---by kiran form 44
	
	public Map<String, Object> showMeForm44JSP(Map<String, Object> generalMap) 
	{
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIcd> diagnosisList = new ArrayList<MasIcd>();
		List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
		List<OpdPatientDetails> opdPatientDetailsList = new ArrayList<OpdPatientDetails>();
		
		  List<Visit> visit = null;
	
		
		int visitId=0;
		if(generalMap.get("visitId") != null )
		{
			visitId = (Integer)generalMap.get("visitId");
		}
		
		try {
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			//visit =hbt.find("from Visit as v where v.Id='"+visitId+"'");
			 visit=session.createCriteria(Visit.class).add(Restrictions.eq("Id",visitId)).list();
								
						
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("visit", visit);

		return map;

	}
	
	public boolean submitMedicalExamForm44(Map map)
	{ 
		boolean succesfullyAdded = false;
		Session session = (Session) getSession();
		//Map<String, Object> utilMap = new HashMap<String, Object>();
		
		int hospital_Id = 0;
		//int empId = 0;
		int hinNumber = 0;
		
		int hinId = 0;
		int visitId=0;
		
		String clinical = "";
		String disposal = "";
		
		if(map.get("hospitalId")!= null)
		{
			hospital_Id = (Integer)map.get("hospitalId");
		}
		
		/*if(map.get("empId")!= null)
		{
			empId = (Integer)map.get("empId");
		}*/
		
		if(map.get("hinNumber")!= null)
		{ 
			hinNumber =(Integer) map.get("hinNumber");
		}
		
		if(map.get("hinId")!= null)
		{    
			hinId = (Integer)map.get("hinId");
		}
		
		if(map.get("visitId") != null)
		{
			visitId = (Integer)map.get("visitId");
		}
		
		if(map.get("clinical")!= null)
		{
			clinical=(String)map.get("clinical");
		}
		
		if(map.get("disposal")!= null)
		{
			disposal=(String)map.get("disposal");
		}
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentTimeWithoutSecond();
		
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			Patient patient = new Patient();
			patient.setId (hinId);

			Visit visit = new Visit();
			
			MasEmployee employee = new MasEmployee();
			
			MasHospital masHospital = new MasHospital();
			
			OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
			//opdPatientDetails=(OpdPatientDetails) hbt.load(OpdPatientDetails.class, visitId);
			
			visit.setId(visitId);
			opdPatientDetails.setVisit(visit);
			
		/*	employee.setId(empId);
			opdPatientDetails.setEmployee(employee);*/
			
			masHospital.setId(hospital_Id);
			opdPatientDetails.setHospital(masHospital);
			
			opdPatientDetails.setInitialDiagnosis(clinical);
			opdPatientDetails.setDisposal(disposal);
			opdPatientDetails.setOpdDate(date);
			opdPatientDetails.setOpdTime(time);
			
			hbt.save(opdPatientDetails);
			hbt.refresh(opdPatientDetails);
		
			Visit visitData = (Visit) hbt.load(Visit.class, visitId);			
			visitData.setMedStatus("c");
			
			hbt.update(opdPatientDetails);
			hbt.refresh(opdPatientDetails);
						
			succesfullyAdded = true;
					
			int opdId=0;
			opdId=opdPatientDetails.getId();
			map.put("vId", visitId);
			map.put("opdId", opdId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return   succesfullyAdded;
	}

	@Override
	public Map<String, Object> showAmeDataEntryList() {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Object[]> categoryList = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
		
			categoryList = hbt.find("select Categoryid,Categories from Category c order by Categories");
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("categoryList", categoryList);
		

		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getServiceNo(Map<String, Object> dataMap){
		System.out.println("in method");
		Map<String, Object> map = new HashMap<String, Object>();
		
		String serviceNo = (String)dataMap.get("serviceNo");
		
		System.out.println("serviceNo-->"+serviceNo);
		
		
		List<Object[]> dependentList = new ArrayList<Object[]>();
		org.hibernate.Session session = getSession();
		dependentList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
		.add(Restrictions.eq("Status", "y"))
		.createAlias("Rank", "r").createAlias("Trade", "t").createAlias("Relation", "rel").add(Restrictions.eq("rel.Id",8))
		.setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("ServiceNo"))
				.add(Projections.property("r.Id")).add(Projections.property("r.RankName")).add(Projections.property("PFirstName")).add(Projections.property("PMiddleName")).add(Projections.property("PLastName")).add(Projections.property("t.Id")).add(Projections.property("t.TradeName")))).list();
		map.put("dependentList",dependentList);
		
		System.out.println("dependentList-->"+dependentList.size());
		return map;
	}

	@Override
	public Map<String, Object> addAmeDataEntry(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masMedicalBoardProceedings);
		successfullyAdded = true;
		
		map.put("successfullyAdded",successfullyAdded);
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getListOfMedicalExam(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		Criteria cr = null;
		List<Visit> meVisitList = new ArrayList<Visit>();		
		Session session = (Session) getSession();
		int pagingSize = 10;
		int pageNo = 1;	
		int hospitalId = box.getInt("hospitalId");
		String ServiceNo = box.getString("ServiceNo");
		
		if (box.getString("PN") != null)
			pageNo = Integer.parseInt(box.getString("PN"));
		
		String ExamType=box.getString("ExamType");
		System.out.println("ExamType="+ExamType);
		
		if(ExamType.equalsIgnoreCase("MedExam"))
		{
			cr = session.createCriteria(Visit.class).add(Restrictions.eq("VisitStatus","c"));
			
			if(ServiceNo.length()>1)
			{
				cr= cr.createAlias("Hin", "patient").add(Restrictions.eq("patient.ServiceNo", ServiceNo));
			}
					
					cr=cr.add(Restrictions.eq("MedStatus","w")).add(Restrictions.eq("ReportingFor", "MedExam"))
					.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
					.addOrder(Order.desc("Id"));	
		}
		if(ExamType.equalsIgnoreCase("MedBoard"))
		{
			cr = session.createCriteria(Visit.class).add(Restrictions.eq("VisitStatus", "c"));
			
			if(ServiceNo.length()>1)
			{
				cr= cr.createAlias("Hin", "patient").add(Restrictions.eq("patient.ServiceNo", ServiceNo));
			}
			
					cr= cr.add(Restrictions.eq("MedStatus", "w")).add(Restrictions.eq("ReportingFor", "MedBoard"))
					.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
					.addOrder(Order.desc("Id"));	
		}
		
		
		List totalMatches = cr.list();
		cr = cr.setFirstResult(pagingSize * (pageNo - 1));
		cr = cr.setMaxResults(pagingSize);
		meVisitList = cr.list();

		int totalRecords = totalMatches.size();
		totalMatches.clear();
		
		List<String> labResultStausList=new ArrayList<String>();
		for(Visit visit:meVisitList)
		{
			String resultStatus="no";
			
			int visitId = visit.getId();
			
			
			
		if(visit.getDgOrderhds()!=null)
			{
				
         		Set<DgOrderhd> dgOrderhdSet=visit.getDgOrderhds();     		
         		
         		
         		for(DgOrderhd hd: dgOrderhdSet)
         		{
         			Set<DgOrderdt> dgOrderdtSet=hd.getDgOrderdts();	
         		
         		
         		
			    if(dgOrderhdSet.size()>0)
			    {	    		
			    	resultStatus="pending";		
			    				
			    			List<DgResultEntryHeader> dgResultEntryHeaderList=session.createCriteria(DgResultEntryHeader.class)
			    					.createAlias("SampleCollectionHeader", "collectionHeader")
			    					.createAlias("SampleCollectionHeader.Order", "dgOrder")			    					
                            .add(Restrictions.eq("dgOrder.Id",hd.getId()))
                            .add(Restrictions.eq("Verified","V")).list();
			    			if(dgResultEntryHeaderList.size()>0)
			    			{
			    				if(dgResultEntryHeaderList.size() == dgOrderdtSet.size())
			    				resultStatus="validated";
			    			}
			    	 		
			    	
			    }
         		}
			}
		
			
			labResultStausList.add(resultStatus);
		}
	
		map.put("meVisitList", meVisitList);
		map.put("labResultStausList", labResultStausList);
		map.put("totalRecords", totalRecords);

				
		return map;
	}



}