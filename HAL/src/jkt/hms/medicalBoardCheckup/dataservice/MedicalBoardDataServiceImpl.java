package jkt.hms.medicalBoardCheckup.dataservice;

import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadFile;
import jkt.hms.masters.business.Category;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgResultEntryHeader;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSampleCollectionHeader;
import jkt.hms.masters.business.Disability;
import jkt.hms.masters.business.Disabilitygroup;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
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
import jkt.hms.masters.business.MasSection;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasSystemDiagnosis;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientFamilyHistory;
import jkt.hms.masters.business.PatientInvestigationDetails;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import net.sf.jasperreports.renderers.JFreeChartRenderer;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lowagie.text.pdf.ByteBuffer;

public class MedicalBoardDataServiceImpl extends HibernateDaoSupport implements
		medicalBoardDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMedicalExamWaitingList(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> meVisitList = new ArrayList<Visit>();
		org.hibernate.Session session = getSession();

		meVisitList = session.createCriteria(Visit.class).add(Restrictions.eq("VisitStatus", "c")).add(
				Restrictions.eq("MedStatus", "w")).add(Restrictions.eq("ReportingFor", "MedBoard")).createAlias(
				"Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
				.addOrder(Order.desc("Id")).list();
		List<String> labResultStausList = new ArrayList<String>();
		for (Visit visit : meVisitList) {
			String resultStatus = "no";
			if (visit.getDgOrderhds() != null) {
				resultStatus = "pending";
				Set<DgOrderhd> dgOrderhdSet = visit.getDgOrderhds();
				
			if (dgOrderhdSet.size() > 0) {
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
			}
			labResultStausList.add(resultStatus);
		}
		map.put("meVisitList", meVisitList);
		map.put("labResultStausList", labResultStausList);
		return map;
	}

	public Map<String, Object> showintialBoardJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> meVisitList = new ArrayList<Visit>();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		org.hibernate.Session session = getSession();

		meVisitList = session.createCriteria(Visit.class).add(Restrictions.idEq(box.getInt("visitId")))
				.add(Restrictions.eq("ReportingFor", "MedBoard")).add(
				Restrictions.eq("MedExamType","Primary/Extension Med. Exam(AFMSF-2A)")).list();
		templateList = session.createCriteria(OpdTemplate.class).createAlias("Department", "dept")
				.add(Restrictions.eq("dept.Id", box.getInt("deptId"))).add(
				Restrictions.eq("Status", "y")).list();
		map.put("meVisitList", meVisitList);
		map.put("templateList", templateList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showInitialMedicalBoardMedExamJsp(
			Map<String, Object> mapForDS) {
		List<Visit> visit = null;

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int visitId = (Integer) mapForDS.get("visitId");
		int deptId = (Integer) mapForDS.get("deptId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		String medExamType = (String)mapForDS.get("medExamType");
		String dentalFlag = "";
		if(medExamType.equals("Initial Medical Board AFMSF 15") || medExamType.equals("Medical Board Review AFMSF 15")){
			dentalFlag = "MedBoard15";
		}
		else if(medExamType.equals("Medical Board AFMSF 16")){
			dentalFlag = "MedBoard16";
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		//visit = hbt.find("from Visit as v where v.Id='" + visitId + "'");
		visit=session.createCriteria(Visit.class).add(Restrictions.eq("Id", visitId)).list();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		templateList = session.createCriteria(OpdTemplate.class)
				.createAlias("Department", "dept").add(Restrictions.eq("dept.Id", deptId))
				.createAlias("Hospital", "hp").add(Restrictions.eq("hp.Id", hospitalId))
				.add(Restrictions.eq("Status", "y")).list();
		/*
		 * 
		 * List<MasServiceType> serviceTypeList = null; List<MasState> stateList
		 * = null; serviceTypeList =
		 * hbt.find("from MasServiceType mst where mst.Status='y'"); stateList =
		 * hbt.find("from MasState ms where ms.Status='y'");
		 * List<MasMaritalStatus> maritalStatusList = null; maritalStatusList =
		 * hbt.find("from MasMaritalStatus mms where mms.Status='y'");
		 * List<MasRank> masRankList1 = new ArrayList<MasRank>(); masRankList1 =
		 * getHibernateTemplate
		 * ().find("from jkt.hms.masters.business.MasRank "); List<MasEmployee>
		 * employeeList = new ArrayList<MasEmployee>(); employeeList =
		 * session.createCriteria(MasEmployee.class).add(
		 * Restrictions.eq("Status", "y")).list(); if (employeeList.size() > 0)
		 * { map.put("employeeList", employeeList); } map.put("masRankList1",
		 * masRankList1); map.put("maritalStatusList", maritalStatusList);
		 * map.put("serviceTypeList", serviceTypeList); map.put("stateList",
		 * stateList);
		 */
		/**
		 * Commented By Ritu 
		 * Date 01 May 2012
		 */
		/*
		 * List<Disability> disabilityList = new ArrayList<Disability>();
		 * disabilityList =
		 * getHibernateTemplate().find("from jkt.hms.masters.business.Disability "
		 * ); map.put("disabilityList", disabilityList);
		 */
		/**
		 * End
		 */
		List<Category> categoryList = new ArrayList<Category>();
		//categoryList = getHibernateTemplate().find("from jkt.hms.masters.business.Category ");
		categoryList= session.createCriteria(Category.class).list();		
		int medExamId = (Integer) mapForDS.get("medExamId");
		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
		List<MasMedicalExaminationDetail> masMedicalExaminationIllList = new ArrayList<MasMedicalExaminationDetail>();
		if (medExamId != 0) {
			medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).add(Restrictions.eq("Status", "m").ignoreCase()).list();
			masMedicalExaminationDetailList = session.createCriteria(MasMedicalExaminationDetail.class)
					.createAlias("MasMedicalReport", "medReport").add(
					Restrictions.eq("medReport.Id", medExamId)).list();
			// --Added by dipali-(15-june-2012)-
			masMedicalExaminationIllList = session.createCriteria(MasMedicalExaminationDetail.class)
					.createAlias("MasMedicalReport", "medReport").add(Restrictions.eq("medReport.Id", medExamId))
					.add(Restrictions.eq("Particular", "particular")).addOrder(Order.asc("Serviceid")).list();
		} else {
			medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
					.add(Restrictions.eq("Visit.Id", visitId)).add(Restrictions.eq("Status", "p").ignoreCase()).list();
			masMedicalExaminationDetailList = session.createCriteria(MasMedicalExaminationDetail.class)
					.createAlias("MasMedicalReport", "medReport").add(
					Restrictions.eq("medReport.Visit.Id", visitId)).addOrder(Order.asc("Serviceid")).list();
			// --Added by dipali-(15-june-2012)-
			masMedicalExaminationIllList = session.createCriteria(MasMedicalExaminationDetail.class).createAlias(
					"MasMedicalReport", "medReport").add(Restrictions.eq("medReport.Visit.Id", visitId)).add(
					Restrictions.eq("Particular", "particular")).addOrder(Order.asc("Serviceid")).list();
		}

		Visit visitdata = null;
		List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();

		if (visit != null && visit.size() > 0) {
			visitdata = visit.get(0);
		}
		int hinId = 0;
		hinId = visitdata.getHin().getId();
		/*
		 * patientInvestigationHeaderList = (List<PatientInvestigationHeader>)
		 * session .createCriteria(PatientInvestigationHeader.class)
		 * .createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId))
		 * .createAlias("Hin",
		 * "p").add(Restrictions.eq("p.Id",visitdata.getHin()
		 * .getId())).addOrder(Order.desc("Id")) .list();
		 */
		patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
				.createCriteria(PatientInvestigationHeader.class).createAlias("Visit", "v")
						.add(Restrictions.eq("v.Id", visitId)).addOrder(Order.desc("Id")).list();
		if (patientInvestigationHeaderList != null && patientInvestigationHeaderList.size() > 0) {
			patientInvestigationHeader = patientInvestigationHeaderList.get(0);
			map.put("patientInvestigationHeader", patientInvestigationHeader);

		}
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		dgOrderhdList = (List<DgOrderhd>) session.createCriteria(DgOrderhd.class)
				.createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();

		DgOrderhd dgOrderhd = null;
		if (dgOrderhdList != null && dgOrderhdList.size() > 0) {
			dgOrderhd = dgOrderhdList.get(0);
			map.put("dgOrderhd", dgOrderhd);

		}
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		resultList = session.createCriteria(DgResultEntryHeader.class)
				.createAlias("SampleCollectionHeader", "smColl").createAlias("smColl.Order", "order")
						.createAlias("order.Visit","vst").add(Restrictions.eq("vst.Id", visitId)).add(
						Restrictions.eq("ResultStatus", "A")).list();
		
		if (resultList != null || resultList.size() > 0) {
			map.put("resultList", resultList);
		}
		/**
		 * Commented By Ritu Date 01 May 2012
		 */
		/*
		 * List<MasIcd> masIcdList = new ArrayList<MasIcd>(); masIcdList =
		 * getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.MasIcd as mi where mi.Status='y' order by mi.IcdName asc"
		 * ); List<Disabilitygroup> disabilitygroupList = new
		 * ArrayList<Disabilitygroup>(); disabilitygroupList =
		 * getHibernateTemplate
		 * ().find("from jkt.hms.masters.business.Disabilitygroup");
		 */
		/*
		 * List<MasUnit> masUnitList = new ArrayList<MasUnit>(); masUnitList =
		 * getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.MasUnit as mu where mu.Status='y' order by mu.UnitName asc"
		 * ); map.put("masUnitList", masUnitList);
		 * 
		 * List<MasSystemDiagnosis> masSystemDiagnosisList = new
		 * ArrayList<MasSystemDiagnosis>(); masSystemDiagnosisList =
		 * getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.MasSystemDiagnosis as msd where msd.Status='y' order by msd.SystemDiagnosisName asc"
		 * );
		 * 
		 * map.put("masSystemDiagnosisList", masSystemDiagnosisList);
		 */
		/**
		 * End
		 */

		List<PatientFamilyHistory> patientFamilyHistoryList = new ArrayList<PatientFamilyHistory>();
		List<MasMedicalExamFamilyHis> masMedicalExamFamilyHisList = new ArrayList<MasMedicalExamFamilyHis>();
		masMedicalExamFamilyHisList = session.createCriteria(MasMedicalExamFamilyHis.class)
				.add(Restrictions.eq("Hin.Id", hinId)).list();
		patientFamilyHistoryList = session.createCriteria(PatientFamilyHistory.class)
				.add(Restrictions.eq("Status", "y")).list();

		/**
		 * Code BY Ritu Date 01 May 2012
		 */
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
		/**
		 * End
		 */
		
		  /**
         * Getting data for dental from opd_patient_details
         * Code By Ritu
         * Date 11.12.2012
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
		map.put("masMedicalExamFamilyHisList", masMedicalExamFamilyHisList);
		map.put("patientFamilyHistoryList", patientFamilyHistoryList);
		map.put("medExamList", medExamList);
		map.put("masMedicalExaminationDetailList",
				masMedicalExaminationDetailList);
		map.put("templateList", templateList);
		map.put("visit", visit);
		map.put("masMedicalExaminationIllList", masMedicalExaminationIllList);
		map.put("categoryList", categoryList);
		// map.put("masIcdList", masIcdList);
		// map.put("disabilitygroupList", disabilitygroupList);
		return map;
	}
	public Map<String, Object> addMedicalBoardInit(
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
		int hinId = (Integer) mapForDS.get("hinId");
		int hdbvalue = 0;
		int hdbvalue1 = 0;
		int hdbvalue2 = 0;
		List<Integer> serialnolist = new ArrayList<Integer>();
		List<String> fromlist = new ArrayList<String>();
		List<Integer> presentMedicalCategoryList = new ArrayList<Integer>();
		List<String> disabilityAggravationList = new ArrayList<String>();
		List<String> disabilityRemarkList = new ArrayList<String>();

		List<String> tolist = new ArrayList<String>();
		List<String> placelist = new ArrayList<String>();
		List<String> pnolist = new ArrayList<String>();
		List<String> illnesslist = new ArrayList<String>();
		List<Date> particulardatelist = new ArrayList<Date>();
		List<Integer> rankidlist = new ArrayList<Integer>();
		List<String> treatedlist = new ArrayList<String>();
		List<Date> approximatedatelist = new ArrayList<Date>();
		List<Integer> serialnolist1 = new ArrayList<Integer>();
		List<String> placelist1 = new ArrayList<String>();
		List<String> principallist = new ArrayList<String>();
		List<Date> origindatelist = new ArrayList<Date>();
		List<Date> medicalcatdatelist = new ArrayList<Date>();
		List<Date> nextcatdatelist = new ArrayList<Date>();
		List<Integer> disabilityIdList = new ArrayList<Integer>();
		List<Integer> icdIdList = new ArrayList<Integer>();
		List<Integer> disabilitygroupIdList = new ArrayList<Integer>();
		List<Integer> disabilityList = new ArrayList<Integer>();
		List<Date> disabilitydateList = new ArrayList<Date>();
		List<Integer> disabilityrankList = new ArrayList<Integer>();
		List<String> disabilityplaceList = new ArrayList<String>();
		List<Integer> disabilityunitList = new ArrayList<Integer>();
		List<String> shapeFactorDetailList = new ArrayList<String>();
		List<String> medCatPeriodDisList = new ArrayList<String>();
		try {
			tx = session.beginTransaction();
			hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			saveinvestigation = saveInvestigation(mapForDS);
			if (saveinvestigation) {
				hbt.save(masMedicalExaminationReportOnEntry);
				hdbvalue = (Integer) mapForDS.get("hdbvalue");
				serialnolist = (List) mapForDS.get("serialnolist");
				fromlist = (List) mapForDS.get("fromlist");
				presentMedicalCategoryList = (List) mapForDS.get("presentMedicalCategoryList");
				if (mapForDS.get("disabilityAggravationList") != null) {
					disabilityAggravationList = (List) mapForDS.get("disabilityAggravationList");
				}
				if (mapForDS.get("disabilityRemarkList") != null) {
					disabilityRemarkList = (List) mapForDS.get("disabilityRemarkList");
				}
				tolist = (List) mapForDS.get("tolist");
				placelist = (List) mapForDS.get("placelist");
				pnolist = (List) mapForDS.get("pnolist");
				principallist = (List) mapForDS.get("principallist");
				origindatelist = (List) mapForDS.get("origindatelist");
				medicalcatdatelist = (List) mapForDS.get("medicalcatdatelist");
				nextcatdatelist = (List) mapForDS.get("nextcatdatelist");
				serialnolist1 = (List) mapForDS.get("serialnolist1");
				illnesslist = (List) mapForDS.get("illnesslist");
				particulardatelist = (List) mapForDS.get("particulardatelist");
				rankidlist = (List) mapForDS.get("rankidlist");
				treatedlist = (List) mapForDS.get("treatedlist");
				approximatedatelist = (List) mapForDS
						.get("approximatedatelist");
				if (mapForDS.get("hdbvalue1") != null) {
					hdbvalue1 = (Integer) mapForDS.get("hdbvalue1");
				}
				placelist1 = (List) mapForDS.get("placelist1");
				disabilityIdList = (List) mapForDS.get("disabilityIdList");
				icdIdList = (List) mapForDS.get("icdIdList");
				disabilitygroupIdList = (List) mapForDS.get("disabilitygroupIdList");
				shapeFactorDetailList  = (List) mapForDS.get("shapeFactorDetailList");
				medCatPeriodDisList  = (List) mapForDS.get("medCatPeriodDisList");
				/*
				 * This Code for Disibility
				 */

				int c = 0;
				for (int i = 1; i <= hdbvalue; i++) {
					if (principallist.size() > 0) {
						String principalStr = "";
						principalStr = principallist.get(c);
						int icdId = 0;
						if (!principalStr.equals("")) {
							MasMedicalExaminationDetail masmedical = new MasMedicalExaminationDetail();
							if (serialnolist.get(c) != null) {
								masmedical.setSerialno(serialnolist.get(c));
							}
							if (!fromlist.get(c).equals("")) {
								masmedical.setAddressfrom(HMSUtil
												.convertStringTypeDateToDateType(fromlist.get(c)));
							} else {
								masmedical.setAddressfrom(null);
							}
							if (presentMedicalCategoryList.size() > 0) {
								if (presentMedicalCategoryList.get(c) != null
										&& presentMedicalCategoryList.get(c) != 0) {
									Category category = new Category();
									category.setCategoryid(presentMedicalCategoryList.get(c));
									masmedical.setCategory(category);
									// masmedical.setAddressfrom(null);
								}
							}
							if (!tolist.get(c).equals("")) {
								masmedical.setAddressto(HMSUtil.convertStringTypeDateToDateType(tolist.get(c)));
							} else {
								masmedical.setAddressto(null);
							}
							if (placelist.size() > 0)
								masmedical.setPlace(placelist.get(c));
							if (pnolist.size() > 0)
								masmedical.setPno(pnolist.get(c));
							masmedical.setParticular("detail");
							masmedical.setMasMedicalReport(masMedicalExaminationReportOnEntry);
							/*
							 * if(principallist.size()>0)
							 * masmedical.setPrincipal(principallist.get(c));
							 */
							/*
							 * Code for ICD Mas
							 */

							String principal = "";
							int lastIndex = principalStr.indexOf("[");
							if (lastIndex > 0) {
								principal = principalStr
										.substring(0, lastIndex);
							} else {
								principal = principalStr;
							}
							masmedical.setPrincipal(principal);
							int index1 = principalStr.lastIndexOf("[");
							int index2 = principalStr.lastIndexOf("]");
							// icdId
							// =Integer.parseInt(principalStr.substring((index1+1),index2));
							try {
								icdId = Integer.parseInt(principalStr
										.substring((index1 + 1), index2));
							} catch (NumberFormatException e) {

								e.printStackTrace();
							}
							
							if(icdId>0){ 
								MasIcd masIcd=new MasIcd();
								masIcd.setId(icdId);
								masmedical.setMasIcd(masIcd); 
							}
							 
							/*if (icdId > 0) {
								MasSystemDiagnosis masIcd = new MasSystemDiagnosis();
								masIcd.setId(icdId);
								masmedical.setSystemDiagnosis(masIcd);
							}*/
							// masmedical.setPrincipal(principallist.get(c));

							if (origindatelist.size() > 0)
								masmedical.setOrigindate(origindatelist.get(c));
							if (medicalcatdatelist.size() > 0)
								masmedical.setMedicalcatdate(medicalcatdatelist.get(c));
							
							//--Added by dipali--
							
							if (shapeFactorDetailList .size() > 0)
								masmedical.setDisShapeFactor(shapeFactorDetailList.get(c));
							
							if (medCatPeriodDisList.size() > 0)
								masmedical.setDisMedCat(medCatPeriodDisList.get(c));
							
							if (nextcatdatelist.size() > 0)
								masmedical.setNextcatdate(nextcatdatelist.get(c));
							if (disabilityAggravationList.get(c) != null) {
								masmedical.setDisabilityAggravation(""
										+ disabilityAggravationList.get(c));
							}
							if (disabilityRemarkList.get(c) != null) {
								masmedical.setDisabilityRemarks(""+ disabilityRemarkList.get(c));
										
							}
							hbt.save(masmedical);
							++c;
						}
					}
				}
				/**
				 * Commented By Ritu
				 */
				/*
				 * int b=0; for (int i = 1; i <= hdbvalue1; i++) {
				 * 
				 * MasMedicalExaminationDetail masmedical1=new
				 * MasMedicalExaminationDetail(); if(serialnolist1.size()>0)
				 * masmedical1.setSerialNo1(serialnolist1.get(b));
				 * if(illnesslist.size()>0)
				 * masmedical1.setIllness(illnesslist.get(b));
				 * 
				 * 
				 * if(particulardatelist.size()>0)
				 * masmedical1.setParticulardate(particulardatelist.get(b));
				 * if(rankidlist.size()>0) { MasRank masrank=new MasRank();
				 * masrank.setId(rankidlist.get(b));
				 * masmedical1.setRankIndividual(masrank); }
				 * if(approximatedatelist.size()>0)
				 * masmedical1.setApproximatedate
				 * (approximatedatelist.get(b).toString());
				 * if(placelist1.size()>0)
				 * masmedical1.setPlace1(placelist1.get(b));
				 * if(treatedlist.size()>0)
				 * masmedical1.setTreated(treatedlist.get(b));
				 * if(disabilityIdList.size()>0) { Disability dis=new
				 * Disability(); dis.setDisabilityid(disabilityIdList.get(b));
				 * masmedical1.setDisability(dis); } if(icdIdList.size()>0) {
				 * MasIcd masicd=new MasIcd(); masicd.setId(icdIdList.get(b));
				 * masmedical1.setMasIcd(masicd); }
				 * if(disabilitygroupIdList.size()>0) { Disabilitygroup
				 * disgr=new Disabilitygroup();
				 * disgr.setGroupid(disabilitygroupIdList.get(b));
				 * masmedical1.setDisabilitygroup(disgr); }
				 * masmedical1.setParticular("particular");
				 * masmedical1.setMasMedicalReport
				 * (masMedicalExaminationReportOnEntry); hbt.save(masmedical1);
				 * ++b; }
				 */

				if (masMedicalExaminationReportOnEntry.getMedicalExamType()
						.equalsIgnoreCase("Medical Board Rel/Invalidment AFMSF 16")) {

					if (mapForDS.get("hdbvalue2") != null) {
						hdbvalue2 = (Integer) mapForDS.get("hdbvalue2");
					}

					disabilityList = (List) mapForDS.get("disabilityList");
					disabilityrankList = (List) mapForDS.get("disabilityrankList");
					disabilitydateList = (List) mapForDS.get("disabilitydateList");
					disabilityplaceList = (List) mapForDS.get("disabilityplaceList");
					disabilityunitList = (List) mapForDS.get("disabilityunitList");
					int a = 0;
					for (int i = 1; i <= hdbvalue2; i++) {

						MasMedicalExaminationDetail masmedical1 = new MasMedicalExaminationDetail();
						if (disabilityList.size() > 0) {
							Disability masrank = new Disability();
							masrank.setDisabilityid(disabilityList.get(a));
							masmedical1.setDisability(masrank);
						}
						if (disabilityrankList.size() > 0) {
							MasRank masrank = new MasRank();
							masrank.setId(disabilityrankList.get(a));
							masmedical1.setRankDisability(masrank);
						}
						if (disabilitydateList.size() > 0)
							masmedical1.setDisabilitydate(disabilitydateList.get(a));
						if (disabilityplaceList.size() > 0)
							masmedical1.setPlaceDisability(disabilityplaceList.get(a));

						if (disabilityunitList.size() > 0) {
							MasUnit dis = new MasUnit();
							dis.setId(disabilityunitList.get(a));
							masmedical1.setUnitDisability(dis);
						}

						masmedical1.setParticular("disability");
						masmedical1
								.setMasMedicalReport(masMedicalExaminationReportOnEntry);
						hbt.save(masmedical1);
						++a;
					}
				}
				hbt.refresh(masMedicalExaminationReportOnEntry);
				successfullyAdded = true;
				int hospitalId = (Integer)mapForDS.get("hospitalId");
				medicalWorkNoList = session.createCriteria(TransactionSequence.class).add(
						Restrictions.eq("TransactionPrefix", "MED")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();

				if (successfullyAdded) {
					if(medicalWorkNoList.size()>0){
					for (TransactionSequence transactionSequence : medicalWorkNoList) {
						TransactionSequence obj = transactionSequence;
						int id2 = obj.getId();
						int seqNo = obj.getTransactionSequenceNumber();
						TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
								.load(TransactionSequence.class, id2);
						transactionSequenceObj
								.setTransactionSequenceNumber(++seqNo);
						if (currentMonth.equalsIgnoreCase("01")) {
							transactionSequenceObj
									.setTransactionSequenceNumber(1);
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
						hospital.setId(hospitalId);
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
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}
		map.put("successfullyAdded", successfullyAdded);
		map.put("medExamId", masMedicalExaminationReportOnEntry.getId());
		return map;

	}

	public Map<String, Object> showUploadingDocumentsJsp(int visitId) {
		Session session = (Session) getSession();
		List<Visit> patientDataList = new ArrayList<Visit>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			patientDataList = session.createCriteria(Visit.class).add(
							Restrictions.eq("Id", visitId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDataList", patientDataList);
		return map;
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
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String lastOrderYear = "";
		int seqNo = 1;
		/*
		 * orderNoList = session.createCriteria(DgOrderhd.class).list(); for
		 * (DgOrderhd dgOrderhd : orderNoList) { lastOrderNo =
		 * dgOrderhd.getOrderNo(); } StringTokenizer str = new
		 * StringTokenizer(lastOrderNo, "/"); while (str.hasMoreTokens()) {
		 * 
		 * lastOrderYear = str.nextToken();
		 * 
		 * }
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
		//	for (TransactionSequence transactionSequence : orderSeqNoList) {
				TransactionSequence obj = (TransactionSequence) orderSeqNoList
						.get(0);
				int id = obj.getId();
				String seqNoStr = obj.getTransactionSequenceNumber().toString();
				lastOrderYear = obj.getMonth().toString();
				if (currentYear.equals(lastOrderYear)) {

					seqNo = Integer.parseInt(seqNoStr);
				} else {
					seqNo = 0;
					lastOrderYear = currentYear;
				}
				seqNo = seqNo + 1;
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);

				orderSeqNo = orderSeqNo.concat(String.valueOf(seqNo));
				// orderSeqNo =
				// orderSeqNo.concat("/").concat(String.valueOf(lastOrderYear));
				transactionSequenceObj.setTransactionSequenceNumber(Integer
						.parseInt(orderSeqNo));
				transactionSequenceObj
						.setMonth(Integer.parseInt(lastOrderYear));
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
			// orderSeqNo =
			// orderSeqNo.concat("/").concat(String.valueOf(currentYear));
			lastOrderYear = currentYear;
			tsObj.setTransactionSequenceNumber(Integer.parseInt(orderSeqNo));
			tsObj.setMonth(Integer.parseInt(currentYear));
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			tsObj.setHospital(hospital);
			hbt.save(tsObj);
		}
		orderSeqNo = orderSeqNo.concat("/").concat(
				String.valueOf(lastOrderYear));
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
	public Map<String, Object> showMedicalOfficerAppointmentInitial(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		
		int hospitalId = 0;
		int empId = 0;
		if(mapForDS.get("hospitalId") != null){
			hospitalId = (Integer)mapForDS.get("hospitalId");
		}
		if(mapForDS.get("empId") != null){
			empId = (Integer)mapForDS.get("empId");
		}
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		// String[] statusArr = {"f","vr"};

		String[] statusArr = { "f", "vr", "s", "sr", };

		rankList= session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
		/*crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.in("Status", statusArr)).add(
				Restrictions.eq("medicalType", "MedicalBoard")).createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.desc("Id"));
*/
		
		if (empId != 0 ) {
			System.out.println(hospitalId+"-2--"+empId);
			crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
			.add(Restrictions.in("Status", statusArr)).add(
			Restrictions.eq("medicalType", "MedicalBoard")).createAlias("Hospital", "h")
			.add(Restrictions.eq("h.Id", hospitalId))
				//.createAlias("Visit", "visit").createAlias("visit.Doctor", "doctor").add(Restrictions.eq("doctor.Id", empId))
			.createAlias("ForwardMO", "fmo").add(Restrictions.eq("fmo.Id", empId)).addOrder(Order.desc("Id"));
			map.put("empId", empId);
		} else {
			System.out.println("-1--");
			crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
			.add(Restrictions.in("Status", statusArr)).add(
			Restrictions.eq("medicalType", "MedicalBoard")).createAlias("Hospital", "h")
			.add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.desc("Id"));
		}
		patientDetailList = crit.list();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		 doctorList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
			.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).list();
		 
		 
		List<String> labResultStausList = new ArrayList<String>();
		for (MasMedicalExaminationReportOnEntry masMedicalExam : patientDetailList) {
			Visit visit = masMedicalExam.getVisit();
			String resultStatus = "no";
			if (visit.getDgOrderhds() != null) {
				resultStatus = "pending";
				Set<DgOrderhd> dgOrderhdSet = visit.getDgOrderhds();
				if (dgOrderhdSet.size() > 0) {
					for (DgOrderhd dgOrderhd : dgOrderhdSet) {
						List<DgOrderdt> dgOrderdtList = session.createCriteria(
								DgOrderdt.class).add(Restrictions.eq("InvestigationToMH", "n")).add(
								Restrictions.eq("Orderhd.Id", dgOrderhd.getId())).list();

						List<DgSampleCollectionHeader> dgSampleCollectionHeaderList = session
								.createCriteria(DgSampleCollectionHeader.class)
								.add(Restrictions.eq("Order.Id", dgOrderhd.getId())).list();
						if (dgSampleCollectionHeaderList.size() > 0) {
							int totalSize = 0;
							// DgSampleCollectionHeader
							// dgSampleCollectionHeader=dgSampleCollectionHeaderList.get(0);
					for (DgSampleCollectionHeader dgSampleCollectionHeader : dgSampleCollectionHeaderList) {
						List<DgSampleCollectionDetails> dgSampleCollectionDetails = session
								.createCriteria(DgSampleCollectionDetails.class).add(
										Restrictions.eq("SampleCollectionHeader.Id",
										dgSampleCollectionHeader.getId())).list();
						List<DgResultEntryHeader> dgResultEntryHeaderList = session
								.createCriteria(DgResultEntryHeader.class).add(
										Restrictions.eq("SampleCollectionHeader.Id",
											dgSampleCollectionHeader.getId()))
								.add(Restrictions.eq("Verified", "V")).list();
						totalSize = totalSize + dgSampleCollectionDetails.size();
					}

							if (dgOrderdtList.size() == totalSize) {
								resultStatus = "validated";
							}
						}

					}
				}
			}
			labResultStausList.add(resultStatus);
		}
		map.put("doctorList", doctorList);
		map.put("labResultStausList", labResultStausList);
		map.put("patientDetailList", patientDetailList);
		map.put("rankList", rankList);
//System.out.println(patientDetailList.get(0).getId()+"patientDetailList>>>"+patientDetailList.size());
		return map;
		
	}

	/*
	 * public Boolean saveInvestigation(Map mapForDS) { boolean
	 * saveinvestigation = false; int patientInvestigationHeaderId=0; int
	 * dgOrderhdId=0; HibernateTemplate hbt = getHibernateTemplate();
	 * hbt.setFlushModeName("FLUSH_EAGER"); hbt.setCheckWriteOperations(false);
	 * int hinId = (Integer) mapForDS.get("hinId"); int departmentId = (Integer)
	 * mapForDS.get("deptId"); int visitId = (Integer) mapForDS.get("visitId");
	 * int hospitalId = (Integer) mapForDS.get("hospitalId");
	 * patientInvestigationHeaderId = (Integer)
	 * mapForDS.get("patientInvestigationHeaderId"); dgOrderhdId = (Integer)
	 * mapForDS.get("dgOrderhdId"); List<String> chargeCodeIdList = (List)
	 * mapForDS.get("chargeCodeIdList"); List<Integer>
	 * patientInvestigationdetailsIdList = (List)
	 * mapForDS.get("patientInvestigationdetailsIdList"); List<Integer>
	 * dgOrderdtIdList = (List) mapForDS.get("dgOrderdtIdList"); //List<Integer>
	 * patientInvestigationdetailsIdList = new ArrayList<Integer>(); String
	 * clinicalNotes1 = (String) mapForDS.get("clinicalNotes1"); String
	 * refferToMhForInv = (String) mapForDS.get("refferToMhForInv"); String
	 * userName = (String) mapForDS.get("userName"); int empId = (Integer)
	 * mapForDS.get("empId"); int userId = (Integer) mapForDS.get("empId");
	 * String lastChangedBy = (String) mapForDS.get("lastChangedBy"); Date
	 * lastChangedDate = (Date) mapForDS.get("lastChangedDate"); String
	 * lastChangedTime = (String) mapForDS.get("lastChangedTime");
	 * departmentId=117; String deleatedValue=(String)
	 * mapForDS.get("deleatedValue"); String deleatedorderid=(String)
	 * mapForDS.get("deleatedorderid");
	 * 
	 * Boolean data=false; if(deleatedValue!="") { Session session = (Session)
	 * getSession(); String[] temp; String delimiter = ","; temp =
	 * deleatedValue.split(delimiter);
	 * 
	 * for(int i =0; i < temp.length ; i++) { List<PatientInvestigationDetails>
	 * detailList =
	 * session.createCriteria(PatientInvestigationDetails.class).add
	 * (Restrictions.eq("Id", Integer.parseInt(temp[i]))).list();
	 * hbt.deleteAll(detailList); data=true;
	 * if(patientInvestigationdetailsIdList.contains(temp[i])) {
	 * patientInvestigationdetailsIdList.remove(temp[i]); }
	 * 
	 * } String[] temp1; String delimiter1 = ","; temp1 =
	 * deleatedorderid.split(delimiter1);
	 * 
	 * for(int i =0; i < temp1.length ; i++) { List<DgOrderdt> DgOrderdtList =
	 * session.createCriteria(DgOrderdt.class).add(Restrictions.eq("Id",
	 * Integer.parseInt(temp1[i]))).list(); hbt.deleteAll(DgOrderdtList);
	 * if(dgOrderdtIdList.contains(temp1[i])) {
	 * dgOrderdtIdList.remove(temp1[i]); } } saveinvestigation=true; }
	 * if(patientInvestigationdetailsIdList.size()>0 &&
	 * patientInvestigationdetailsIdList
	 * .size()==chargeCodeIdList.size()&&data==false) { saveinvestigation=true;
	 * }else if ( chargeCodeIdList.size() > 0) {
	 * 
	 * MasDepartment masDepartment = new MasDepartment(); MasHospital
	 * masHospital = new MasHospital(); Patient patient = new Patient();
	 * MasEmployee masEmployee2 = new MasEmployee();
	 * 
	 * PatientInvestigationHeader patientInvestigationHeader = new
	 * PatientInvestigationHeader();
	 * 
	 * DgOrderhd dgOrderhd = new DgOrderhd();
	 * if(patientInvestigationdetailsIdList.size()>0) {
	 * patientInvestigationHeader.setId(patientInvestigationHeaderId);
	 * dgOrderhd.setId(dgOrderhdId); } patient.setId(hinId);
	 * patientInvestigationHeader.setHin(patient);
	 * 
	 * masDepartment.setId(departmentId);
	 * patientInvestigationHeader.setDepartment(masDepartment); Visit visit =
	 * new Visit(); visit.setId(visitId);
	 * patientInvestigationHeader.setVisit(visit);
	 * 
	 * masHospital.setId(hospitalId);
	 * patientInvestigationHeader.setHospital(masHospital);
	 * patientInvestigationHeader.setStatus("p"); patientInvestigationHeader
	 * .setInvestigationDate(new Date()); //String time=new Date().getTime();
	 * patientInvestigationHeader.setInvestigationTime(lastChangedTime);
	 * patientInvestigationHeader.setClinicalNotes(clinicalNotes1);
	 * hbt.saveOrUpdate(patientInvestigationHeader);
	 * 
	 * 
	 * dgOrderhd.setOrderDate(new Date());
	 * //dgOrderhd.setOrderTime(consultationTime);
	 * masHospital.setId(hospitalId); dgOrderhd.setHospital(masHospital);
	 * patient.setId(hinId); dgOrderhd.setHin(patient);
	 * masDepartment.setId(departmentId);
	 * dgOrderhd.setDepartment(masDepartment); if (empId != 0) {
	 * masEmployee2.setId(empId); dgOrderhd.setPrescribedBy(masEmployee2); }
	 * dgOrderhd.setPatientType("OP"); dgOrderhd.setTestType("Regular");
	 * dgOrderhd.setCreatedby(lastChangedBy); dgOrderhd.setCreatedon(new
	 * Date()); String orderSeqNo = ""; orderSeqNo = generateOrderNumber();
	 * dgOrderhd.setOrderNo(orderSeqNo); if (visitId != 0) { visit = new
	 * Visit(); visit.setId(visitId); dgOrderhd.setVisit(visit); }
	 * dgOrderhd.setClinicalNote(clinicalNotes1); dgOrderhd.setOrderStatus("P");
	 * dgOrderhd.setLabOrderStatus("P"); dgOrderhd.setLastChgBy(userId);
	 * dgOrderhd.setLastChgDate(new Date());
	 * dgOrderhd.setLastChgTime(lastChangedTime);
	 * dgOrderhd.setOrderTime(lastChangedTime);
	 * dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
	 * hbt.saveOrUpdate(dgOrderhd); int length=0; for (int i = 0; i <
	 * chargeCodeIdList.size(); i++) { PatientInvestigationDetails
	 * patientInvestigationDetails = new PatientInvestigationDetails();
	 * patientInvestigationDetails
	 * .setInvestigationHeader(patientInvestigationHeader); DgOrderdt dgOrderdt
	 * = new DgOrderdt(); if(patientInvestigationdetailsIdList.size()>0
	 * &&length!=patientInvestigationdetailsIdList.size()) { ++length;
	 * patientInvestigationDetails
	 * .setId(patientInvestigationdetailsIdList.get(i));
	 * dgOrderdt.setId(dgOrderdtIdList.get(i)); } MasChargeCode masChargeCode =
	 * new MasChargeCode();
	 * masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
	 * patientInvestigationDetails.setChargeCode(masChargeCode);
	 * patientInvestigationDetails.setReferToMh(refferToMhForInv);
	 * //patientInvestigationDetails.setQuantity(quantityList.get(i));
	 * //patientInvestigationDetails.setClinicalNotes(clinicalList.get(i));
	 * hbt.saveOrUpdate(patientInvestigationDetails);
	 * 
	 * 
	 * dgOrderdt.setOrderhd(dgOrderhd);
	 * masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
	 * dgOrderdt.setChargeCode(masChargeCode); //
	 * dgOrderdt.setOrderQty(quantityList.get(i));
	 * 
	 * dgOrderdt.setCreatedby(userName); dgOrderdt.setCreatedon(new Date());
	 * dgOrderdt.setLastChgBy(userId); dgOrderdt.setLastChgDate(new Date());
	 * dgOrderdt.setLastChgTime(lastChangedTime); // method written for taking
	 * out the values of mascharge // code and subcharge Map masChargeMap =
	 * getMasChargeCodeFromChargeId(Integer .parseInt(chargeCodeIdList.get(i)));
	 * MasChargeCode masChargeCodeObj = (MasChargeCode) masChargeMap
	 * .get("masChargeCode"); int mainChargeId =
	 * masChargeCodeObj.getMainChargecode() .getId(); int subChargeId =
	 * masChargeCodeObj.getSubChargecode() .getId(); if
	 * (masChargeCodeObj.getMainChargecode()
	 * .getMainChargecodeCode().equalsIgnoreCase("Lab")) {
	 * dgOrderdt.setOrderStatus("P"); } else { dgOrderdt.setOrderStatus("P"); }
	 * MasMainChargecode masMainChargecode = new MasMainChargecode();
	 * masMainChargecode.setId(mainChargeId);
	 * dgOrderdt.setMainChargecode(masMainChargecode); MasSubChargecode
	 * masSubChargecode = new MasSubChargecode();
	 * masSubChargecode.setId(subChargeId);
	 * dgOrderdt.setSubChargeid(masSubChargecode);
	 * dgOrderdt.setInvestigation(new
	 * DgMasInvestigation(Integer.parseInt(chargeCodeIdList.get(i))));
	 * hbt.saveOrUpdate(dgOrderdt); saveinvestigation=true; } } return
	 * saveinvestigation; }
	 */
	public Boolean saveInvestigation(Map mapForDS) {
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
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			lastChangedTime = (String) utilMap.get("currentTimeWithoutSc");
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

	public Map<String, Object> displayDocumentView(Map<String, Object> map) {
		Session session = (Session) getSession();

		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Visit> visitList = new ArrayList<Visit>();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");

		String inputField = (String) map.get("inputField");
		String flag = (String) map.get("flag");
		String flag1 = (String) map.get("flag1");
		String message = null;
		String destUploadURL = "";
		if (map.get("destUploadURL") != null
				&& !map.get("destUploadURL").equals("")) {
			destUploadURL = (String) map.get("destUploadURL");
		}
		Criteria criteria = null;
		if (flag.equals("upload") && !flag1.equals("viewDocuments")) {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("Status", "y")).add(
					Restrictions.eq("HinNo", inputField)).list();

			if (patientList.size() == 0) {
				inpatientList = session.createCriteria(Inpatient.class).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.eq("AdNo", inputField)).list();
			}

		if (visitList.size() == 0 && inpatientList.size() == 0 && patientList.size() == 0) {
				message = "No record Found !!";
			}
			map.put("message", message);
			map.put("patientList", patientList);
			map.put("inpatientList", inpatientList);

		} else if (flag.equals("view") || flag1.equals("viewDocuments")) {
			String uploadURL = (String) map.get("uploadURL");
			patientList = session.createCriteria(UploadDocuments.class)
					.createAlias("Hin", "p").add(Restrictions.eq("p.HinNo", inputField)).list();

			if (patientList.size() == 0) {
				inpatientList = session.createCriteria(UploadDocuments.class)
				.createAlias("Inpatient", "ip").add(Restrictions.eq("ip.AdNo", inputField)).list();
			}

			if (inpatientList.size() == 0 && patientList.size() == 0) {
				message = "No record Found !!";
			}
			map.put("message", message);
			map.put("patientList", patientList);
			map.put("inpatientList", inpatientList);
			String[] files = null;
			if (patientList.size() > 0) {
				files = new String[patientList.size()];
				Iterator iterator = patientList.iterator();
				int counter = 0;
				while (iterator.hasNext()) {
					UploadDocuments uploadDocuments = (UploadDocuments) iterator.next();
					files[counter] = uploadDocuments.getFileName() + "."
							+ uploadDocuments.getFileExtension();
					try {
						/*
						 * FileOutputStream is = new
						 * FileOutputStream(destUploadURL +
						 * uploadDocuments.getFileName() + "." +
						 * uploadDocuments.getFileExtension()); is.write(out);
						 * is.flush(); is.close();
						 */
						HMSUtil.copyCompletlyFolder(new File(uploadURL),
								new File(destUploadURL));

					} catch (Exception e) {
						e.printStackTrace();
					}
					counter++;
				}

			}
			if (inpatientList.size() > 0) {
				files = new String[inpatientList.size()];
				Iterator iterator = inpatientList.iterator();
				int counter = 0;
				while (iterator.hasNext()) {
					UploadDocuments uploadDocuments = (UploadDocuments) iterator
							.next();
					files[counter] = uploadDocuments.getFileName() + "."
							+ uploadDocuments.getFileExtension();
					try {
						/*
						 * FileOutputStream is = new FileOutputStream(uploadURL
						 * + files[counter]);
						 * 
						 * 
						 * is.write(uploadDocuments.getPatientDocument());
						 * is.flush(); is.close();
						 */
						File srcFile = new File(uploadURL
								+ uploadDocuments.getFileName() + "."
								+ uploadDocuments.getFileExtension());
						File destFile = new File(destUploadURL
								+ uploadDocuments.getFileName() + "."
								+ uploadDocuments.getFileExtension());

						HMSUtil.copyfile(srcFile, destFile);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					counter++;
				}
			}

		}
		return map;

	}

	public Map<String, Object> getItemListForDisabilityByAutocomplete(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		// String pvmsNo = null;
		// Box box = (Box) dataMap.get("box");
		int deptId = 0;
		deptId = Integer.parseInt("" + dataMap.get("deptId"));
		String autoHint = (String) dataMap.get("autoHint");
		List objectList = new ArrayList();
		List<Disability> disabilityList = new ArrayList<Disability>();
		try {
			/*disabilityList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.Disability where upper(Disability) like upper('"
							+ autoHint + "%')");*/
			
		disabilityList = session.createCriteria(Disability.class).add(Restrictions.like("Disability",  "%"+autoHint+"%").ignoreCase()).list();
			/*
			 * String str = (String) dataMap.get("autoHint");
			 * str=str.toUpperCase()+ "%"; String qry =
			 * "SELECT item_id FROM store_item_batch_stock where department_id="
			 * + deptId ; objectList = (List)
			 * session.createSQLQuery(qry).list(); if (objectList.size() != 0) {
			 * List<BigDecimal> objectNewList = new ArrayList<BigDecimal>();
			 * String sql=""; for (int i=0;i<objectList.size();i++) { if(i<100){
			 * if(i==0){ sql=""+objectList.get(i); }else{
			 * sql=sql+" , "+objectList.get(i); } } }
			 */
			/*
			 * Criteria c = session.createCriteria(MasStoreItem.class)
			 * .add(Restrictions.like("Nomenclature", str))
			 * 
			 * .add(Restrictions.in("Id", objectList)); c.setFirstResult(0);
			 * c.setMaxResults(10); itemList = c.list();
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("disabilityList", disabilityList);

		return map;
	}

	public Map<String, Object> showMedicalOfficerInitial(Map<String, Object> mapForDS) {
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
		List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
		masMedicalExaminationDetailList = session.createCriteria(
				MasMedicalExaminationDetail.class).createAlias(
				"MasMedicalReport", "medReport").add(
				Restrictions.eq("medReport.Id", medExamId)).addOrder(Order.asc("Serviceid")).list();
		map.put("masMedicalExaminationDetailList",
				masMedicalExaminationDetailList);
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		//visit = hbt.find("from Visit as v where v.Id='" + visitId + "'");
		visit=session.createCriteria(Visit.class).add(Restrictions.eq("Id",visitId)).list();

		List<Integer> headerIdsInt = new ArrayList<Integer>();
		resultList = session.createCriteria(DgResultEntryHeader.class)
				.createAlias("SampleCollectionHeader", "smColl").createAlias("smColl.Order", "order").createAlias("order.Visit",
						"vst").add(Restrictions.eq("vst.Id", visitId)).add(Restrictions.eq("ResultStatus", "A")).list();

		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties
				.getProperty("empCategoryCodeForDoctor");
		employeeList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).createAlias("Hospital", "h")
				.createAlias("EmpCategory", "ec").add(
						Restrictions.eq("h.Id", hospitalId)).add(
						Restrictions.eq("ec.EmpCategoryCode",
								empCategoryCodeForDoctor)).addOrder(
						Order.asc("FirstName")).list();

		if (employeeList.size() > 0) {
			map.put("employeeList", employeeList);
		}
		/*
		 * List<MasMaritalStatus> maritalStatusList = null; maritalStatusList =
		 * hbt.find(
		 * "from MasMaritalStatus mms where mms.Status='y' order by mms.MaritalStatusName asc"
		 * ); List<Disability> disabilityList = new ArrayList<Disability>();
		 * disabilityList =
		 * getHibernateTemplate().find("from jkt.hms.masters.business.Disability "
		 * ); map.put("maritalStatusList", maritalStatusList);
		 * map.put("disabilityList", disabilityList); List<MasServiceType>
		 * serviceTypeList = null; serviceTypeList =hbt.find(
		 * "from MasServiceType mst where mst.Status='y' order by mst.ServiceTypeName asc"
		 * ); map.put("serviceTypeList", serviceTypeList); List<MasRank>
		 * masRankList1 = new ArrayList<MasRank>(); masRankList1 =
		 * getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.MasRank mr where mr.Status='y' order by mr.RankName asc"
		 * ); map.put("masRankList1", masRankList1); List<MasIcd> masIcdList =
		 * new ArrayList<MasIcd>(); masIcdList =getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.MasIcd mi where mi.Status='y' order by mi.IcdName asc"
		 * ); map.put("masIcdList", masIcdList); List<Disabilitygroup>
		 * disabilitygroupList = new ArrayList<Disabilitygroup>();
		 * disabilitygroupList =getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.Disabilitygroup dg order by dg.DiseaseGroups asc"
		 * ); List<MasUnit> masUnitList = new ArrayList<MasUnit>(); masUnitList
		 * =getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.MasUnit mu where mu.Status='y' order by mu.UnitName asc"
		 * ); map.put("disabilitygroupList", disabilitygroupList);
		 * map.put("masUnitList", masUnitList);
		 */
		List<Category> categoryList = new ArrayList<Category>();
		categoryList = session.createCriteria(Category.class)
		.addOrder(Order.asc("Categories")).list();
			//getHibernateTemplate()
				//.find(
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

		if (resultList != null || resultList.size() > 0) {
			map.put("resultList", resultList);
		}

		investigationList = session.createCriteria(DgMasInvestigation.class)
				.add(Restrictions.eq("Status", "y")).addOrder(
						Order.asc("InvestigationName")).list();
		if (investigationList.size() > 0) {
			map.put("investigationList", investigationList);
		}

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

		map.put("masHospitalList", masHospitalList);
		map.put("masDepartmentList", masDepartmentList);

		map.put("visit", visit);

		map.put("medExamList", medExamList);
		map.put("categoryList", categoryList);

		return map;
	}

	@Override
	public MasMedicalExaminationReportOnEntry loadMedicalExamObj(int medExamId) {
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		MasMedicalExaminationReportOnEntry masMedExam = new MasMedicalExaminationReportOnEntry();
		try {

			masMedExam = (MasMedicalExaminationReportOnEntry) hbt.load(
					MasMedicalExaminationReportOnEntry.class, medExamId);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return masMedExam;
	}

	@Override
	public Boolean updateMedicalExaminationBoardInitial(
			Map<String, Object> mapForDS) {
		boolean successfullyAdded = false;

		int visitId = (Integer) mapForDS.get("visitId");
		String data = (String) mapForDS.get("data");

		String Labresult = (String) mapForDS.get("Labresult");
		int medExamId = (Integer) mapForDS.get("medExamId");
		MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry = new MasMedicalExaminationReportOnEntry();

		if (mapForDS.get("masMedicalBoardProceedings") != null) {
			masMedicalExaminationReportOnEntry = (MasMedicalExaminationReportOnEntry) mapForDS
					.get("masMedicalBoardProceedings");
		}
		Transaction tx = null;
		try {
			boolean saveinvestigation = false;
			/*
			 * Code Commented On 02 Apr 2012 By Mukesh
			 */
			saveinvestigation=saveInvestigationResult(mapForDS);

			//saveinvestigation = updateInvestigation(mapForDS);
			System.out.println("saveinvestigation="+saveinvestigation);
			
			if (saveinvestigation) {
				Session session = (Session) getSession();
				tx = session.beginTransaction();
				HibernateTemplate hbt = null;
				hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.update(masMedicalExaminationReportOnEntry);
				int hdbvalue = 1;
				int hdbvalue1 = 1;
				int hdbvalue2 = 1;
				List<Integer> serviceidlist = new ArrayList<Integer>();
				List<Integer> serialnolist = new ArrayList<Integer>();
				List<String> fromlist = new ArrayList<String>();
				List<String> tolist = new ArrayList<String>();
				List<String> placelist = new ArrayList<String>();
				List<String> pnolist = new ArrayList<String>();
				List<String> illnesslist = new ArrayList<String>();
				List<Date> particulardatelist = new ArrayList<Date>();
				List<Integer> rankidlist = new ArrayList<Integer>();
				List<String> treatedlist = new ArrayList<String>();
				List<Date> approximatedatelist = new ArrayList<Date>();
				List<Integer> serialnolist1 = new ArrayList<Integer>();
				List<String> placelist1 = new ArrayList<String>();
				List<String> principallist = new ArrayList<String>();
				List<Date> origindatelist = new ArrayList<Date>();
				List<Date> medicalcatdatelist = new ArrayList<Date>();
				List<Date> nextcatdatelist = new ArrayList<Date>();
				List<Integer> disabilityIdList = new ArrayList<Integer>();
				List<Integer> icdIdList = new ArrayList<Integer>();
				List<Integer> disabilitygroupIdList = new ArrayList<Integer>();
				List<Integer> disabilityList = new ArrayList<Integer>();
				List<Integer> disabilityrankList = new ArrayList<Integer>();
				List<Date> disabilitydateList = new ArrayList<Date>();
				List<String> disabilityplaceList = new ArrayList<String>();
				List<Integer> disabilityunitList = new ArrayList<Integer>();

				List<String> shapeFactorDetailList = new ArrayList<String>();
				List<String> medCatPeriodDisList = new ArrayList<String>();
				hdbvalue = (Integer) mapForDS.get("hdbvalue");
				serialnolist = (List) mapForDS.get("serialnolist");
				if (mapForDS.get("serviceidlist") != null) {
					serviceidlist = (List) mapForDS.get("serviceidlist");
				}
				fromlist = (List) mapForDS.get("fromlist");
				List<Integer> presentMedicalCategoryList = new ArrayList<Integer>();
				presentMedicalCategoryList = (List) mapForDS
						.get("presentMedicalCategoryList");
				List<String> disabilityAggravationList = new ArrayList<String>();
				List<String> disabilityRemarkList = new ArrayList<String>();

				List<String> prevDisabilitiesList = new ArrayList<String>();
				List<String> pastDisabilitiesList = new ArrayList<String>();
				List<String> variationReasonList = new ArrayList<String>();

				if (mapForDS.get("disabilityAggravationList") != null) {
					disabilityAggravationList = (List) mapForDS
							.get("disabilityAggravationList");
				}
				if (mapForDS.get("disabilityRemarkList") != null) {
					disabilityRemarkList = (List) mapForDS
							.get("disabilityRemarkList");
				}

				if (mapForDS.get("prevDisabilitiesList") != null) {
					prevDisabilitiesList = (List) mapForDS
							.get("prevDisabilitiesList");
				}
				if (mapForDS.get("pastDisabilitiesList") != null) {
					pastDisabilitiesList = (List) mapForDS
							.get("pastDisabilitiesList");
				}
				if (mapForDS.get("variationReasonList") != null) {
					variationReasonList = (List) mapForDS
							.get("variationReasonList");
				}
				List<Integer> categoryDislist = new ArrayList<Integer>();
				List<Integer> compCategoryList = new ArrayList<Integer>();
				List<String> medCatPeriodList = new ArrayList<String>();
				List<String> compCatePeriodList = new ArrayList<String>();
				if (mapForDS.get("categoryDislist") != null) {
					categoryDislist = (List<Integer>) mapForDS.get("categoryDislist");
				}
				if (mapForDS.get("compCategoryList") != null) {
					compCategoryList = (List<Integer>) mapForDS.get("compCategoryList");
				}
				if (mapForDS.get("medCatPeriodList") != null) {
					medCatPeriodList = (List) mapForDS
							.get("medCatPeriodList");
				}
				if (mapForDS.get("compCatePeriodList") != null) {
					compCatePeriodList = (List) mapForDS
							.get("compCatePeriodList");
				}
				tolist = (List) mapForDS.get("tolist");
				placelist = (List) mapForDS.get("placelist");
				pnolist = (List) mapForDS.get("pnolist");
				principallist = (List) mapForDS.get("principallist");
				origindatelist = (List) mapForDS.get("origindatelist");
				medicalcatdatelist = (List) mapForDS.get("medicalcatdatelist");
				shapeFactorDetailList  = (List) mapForDS.get("shapeFactorDetailList");
				medCatPeriodDisList  = (List) mapForDS.get("medCatPeriodDisList");
				nextcatdatelist = (List) mapForDS.get("nextcatdatelist");
				serialnolist1 = (List) mapForDS.get("serialnolist1");
				illnesslist = (List) mapForDS.get("illnesslist");
				particulardatelist = (List) mapForDS.get("particulardatelist");
				rankidlist = (List) mapForDS.get("rankidlist");
				treatedlist = (List) mapForDS.get("treatedlist");
				approximatedatelist = (List) mapForDS
						.get("approximatedatelist");
				if (mapForDS.get("hdbvalue1") != null) {
					hdbvalue1 = (Integer) mapForDS.get("hdbvalue1");
				}
				placelist1 = (List) mapForDS.get("placelist1");
				disabilityIdList = (List) mapForDS.get("disabilityIdList");
				icdIdList = (List) mapForDS.get("icdIdList");
				disabilitygroupIdList = (List) mapForDS
						.get("disabilitygroupIdList");
				List<MasMedicalExaminationDetail> detailList = session
						.createCriteria(MasMedicalExaminationDetail.class).add(
								Restrictions.eq("MasMedicalReport.Id",medExamId))
								.add(Restrictions.eq("Particular", "detail")).list();
				//hbt.deleteAll(detailList);
				List<MasMedicalExaminationDetail> detailList1 = session
						.createCriteria(MasMedicalExaminationDetail.class).add(
								Restrictions.eq("MasMedicalReport.Id",medExamId))
								.add(Restrictions.eq("Particular", "particular")).list();
				//hbt.deleteAll(detailList1);
				System.out.println(detailList.size()+"medExamId>> in update "+medExamId+"  hdbvalue>>>"+hdbvalue);
				int a = 0;

				for (int i = 1; i <= hdbvalue; i++) {
					if (principallist.size() > 0) {
						/*
						 * Code for ICD Mas
						 */
						String principalStr = "";

						principalStr = principallist.get(a);

						int icdId = 0;
						if (!principalStr.equals("")) {
						
							
							///MasMedicalExaminationDetail masMedicalExaimDetails = new MasMedicalExaminationDetail();
								MasMedicalExaminationDetail masMedicalExaimDetails= null;
								if(i<=detailList.size()){
							 masMedicalExaimDetails = (MasMedicalExaminationDetail)hbt.load(MasMedicalExaminationDetail.class, detailList.get(a).getServiceid());
								}else{
									masMedicalExaimDetails = new MasMedicalExaminationDetail();
								}
							if (serialnolist.size() > 0) {
								if (serialnolist.get(a) != null) {
									masMedicalExaimDetails
											.setSerialno(serialnolist.get(a));
								}
							}
							
							Date date = new Date();
							try {

								if (presentMedicalCategoryList.size() > 0) {
									if (presentMedicalCategoryList.get(a) != null
											&& presentMedicalCategoryList.get(a) != 0) {
										Category category = new Category();
										category.setCategoryid(presentMedicalCategoryList.get(a));
										masMedicalExaimDetails.setCategory(category);
										// masMedicalExaimDetails.setAddressfrom(null);
									}
								}
								if (fromlist.size() > 0) {
									if (fromlist.get(a) != null && !fromlist.get(a).equals("")) {
										masMedicalExaimDetails.setAddressfrom(HMSUtil
										.convertStringTypeDateToDateType((fromlist.get(a))));
										// masMedicalExaimDetails.setAddressfrom(null);
									}
								}
								if (tolist.size() > 0) {
									if (tolist.get(a) != null && !tolist.get(a).equals("")) {
										masMedicalExaimDetails.setAddressto(HMSUtil
										.convertStringTypeDateToDateType(((tolist.get(a)))));
										// masMedicalExaimDetails.setAddressto(null);
									}
								}
								if (placelist.size() > 0) {
									if (placelist.get(a) != null
											&& !placelist.get(a).equals("")) {
										masMedicalExaimDetails.setPlace(placelist.get(a));
									}
								}
								if (pnolist.size() > 0) {
									if (pnolist.get(a) != null
											&& !pnolist.get(a).equals("")) {
										masMedicalExaimDetails.setPno(pnolist.get(a));
									}
								}

								if (!prevDisabilitiesList.get(a).equals("")) {
									masMedicalExaimDetails
											.setPreDisability(new BigDecimal(
													prevDisabilitiesList.get(a)));
								} else {
									masMedicalExaimDetails
											.setPreDisability(new BigDecimal(0));
								}
								if (!pastDisabilitiesList.get(a).equals("")) {
									masMedicalExaimDetails
											.setPastDisability(new BigDecimal(
													pastDisabilitiesList.get(a)));
								} else {
									masMedicalExaimDetails
											.setPastDisability(new BigDecimal(0));
								}
								masMedicalExaimDetails
										.setReasonVariation(variationReasonList
												.get(a));
								masMedicalExaimDetails.setParticular("detail");
								masMedicalExaimDetails
										.setMasMedicalReport(masMedicalExaminationReportOnEntry);
								/*
								 * if(principallist.size()>0)
								 * masMedicalExaimDetails
								 * .setPrincipal(principallist.get(a));
								 */

								String principal = "";
								int lastIndex = principalStr.indexOf("[");
								if (lastIndex > 0) {
									principal = principalStr.substring(0,lastIndex);
								} else {
									principal = principalStr;
								}

								int index1 = principalStr.lastIndexOf("[");
								int index12 = principalStr.indexOf("[");
								String principalVal = principallist.get(a)
										.substring(0, index12);
								masMedicalExaimDetails
										.setPrincipal(principalVal);
								int index2 = principalStr.lastIndexOf("]");
								// icdId
								// =Integer.parseInt(principalStr.substring((index1+1),index2));
								try {
									icdId = Integer.parseInt(principalStr
											.substring((index1 + 1), index2));
								} catch (NumberFormatException e) {

									e.printStackTrace();
								}
								
								if(icdId>0){ 
									MasIcd masIcd=new MasIcd();
									masIcd.setId(icdId);
									masMedicalExaimDetails.setMasIcd(masIcd); 
								}
								 
								/*if (icdId > 0) {
									MasSystemDiagnosis masIcd = new MasSystemDiagnosis();
									masIcd.setId(icdId);
									masMedicalExaimDetails
											.setSystemDiagnosis(masIcd);
								}*/

								if (origindatelist.size() > 0)
									masMedicalExaimDetails
											.setOrigindate(origindatelist
													.get(a));
								if (medicalcatdatelist.size() > 0)
									masMedicalExaimDetails
											.setMedicalcatdate(medicalcatdatelist
													.get(a));
								//--Added by dipali--
								
								if (shapeFactorDetailList .size() > 0)
									masMedicalExaimDetails
											.setDisShapeFactor(shapeFactorDetailList.get(a));
								
								if (medCatPeriodDisList.size() > 0)
									masMedicalExaimDetails
											.setDisMedCat(medCatPeriodDisList.get(a));
								
								
								if (nextcatdatelist.size() > 0)
									masMedicalExaimDetails
											.setNextcatdate(nextcatdatelist.get(a));

								if (disabilityAggravationList.get(a) != null) {
									masMedicalExaimDetails
											.setDisabilityAggravation(""+ disabilityAggravationList.get(a));
								}
								if (disabilityRemarkList.get(a) != null) {
									masMedicalExaimDetails
											.setDisabilityRemarks(""+ disabilityRemarkList.get(a));
								}
								if (categoryDislist.get(a) != null) {
									Category category = new Category();
									category.setCategoryid(Integer.parseInt(categoryDislist.get(a).toString()));
									masMedicalExaimDetails.setCategoryDisability(category);
								}
								if (compCategoryList.get(a) != null) {
									Category categoryComp = new Category();
									categoryComp.setCategoryid(Integer.parseInt(compCategoryList.get(a).toString()));
									masMedicalExaimDetails.setCompositeCate(categoryComp);
								}
								if (medCatPeriodList.get(a) != null) {
									masMedicalExaimDetails.setCateDisPeriod(medCatPeriodList.get(a).toString());
								}
								if (compCatePeriodList.get(a) != null) {
									masMedicalExaimDetails.setCompCatePeriod(compCatePeriodList.get(a).toString());
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							/*
							 * if(saveOrUpdateFlag){
							 * hbt1.update(masMedicalExaimDetails); }else{
							 */
							
							hbt.saveOrUpdate(masMedicalExaimDetails);
							hbt.refresh(masMedicalExaimDetails);
							
							// }
							++a;
						}
					}
				}

				for (int k = 1; k <= hdbvalue1; k++) {
					MasMedicalExaminationDetail masmedical1 = new MasMedicalExaminationDetail();
					// if(serialnolist1.size()>0)
					// masmedical1.setSerialNo1(serialnolist1.get(k));
					// if(illnesslist.size()>0)
					// masmedical1.setIllness(illnesslist.get(k));
					// if(particulardatelist.size()>0)
					// masmedical1.setParticulardate(particulardatelist.get(k));
					/*
					 * if(rankidlist.size()>0) { MasRank masrank=new MasRank();
					 * masrank.setId(rankidlist.get(k));
					 * masmedical1.setRankIndividual(masrank); }
					 * if(approximatedatelist.size()>0)
					 * masmedical1.setApproximatedate
					 * (approximatedatelist.get(k).toString());
					 * if(placelist1.size()>0)
					 * masmedical1.setPlace1(placelist1.get(k));
					 * if(treatedlist.size()>0)
					 * masmedical1.setTreated(treatedlist.get(k));
					 * if(disabilityIdList.size()>0) { Disability dis=new
					 * Disability();
					 * dis.setDisabilityid(disabilityIdList.get(k));
					 * masmedical1.setDisability(dis); } if(icdIdList.size()>0)
					 * { MasIcd masicd=new MasIcd();
					 * masicd.setId(icdIdList.get(k));
					 * masmedical1.setMasIcd(masicd); }
					 * if(disabilitygroupIdList.size()>0) { Disabilitygroup
					 * disgr=new Disabilitygroup();
					 * disgr.setGroupid(disabilitygroupIdList.get(k));
					 * masmedical1.setDisabilitygroup(disgr); }
					 */
					masmedical1.setParticular("particular");
					masmedical1
							.setMasMedicalReport(masMedicalExaminationReportOnEntry);
					//hbt.save(masmedical1);
				}

				if (masMedicalExaminationReportOnEntry.getMedicalExamType()
						.equalsIgnoreCase(
								"Medical Board Rel/Invalidment AFMSF 16")) {
					List<MasMedicalExaminationDetail> detailList2 = session
							.createCriteria(MasMedicalExaminationDetail.class)
							.add(Restrictions.eq("MasMedicalReport.Id",medExamId))
							.add(Restrictions.eq("Particular", "disability"))
							.list();
					hbt.deleteAll(detailList2);

					hdbvalue2 = (Integer) mapForDS.get("hdbvalue2");
					disabilityList = (List) mapForDS.get("disabilityList");
					disabilityrankList = (List) mapForDS
							.get("disabilityrankList");
					disabilitydateList = (List) mapForDS
							.get("disabilitydateList");
					disabilityplaceList = (List) mapForDS
							.get("disabilityplaceList");
					disabilityunitList = (List) mapForDS
							.get("disabilityunitList");
					int b = 0;
					for (int i = 0; i < hdbvalue2; i++) {

						MasMedicalExaminationDetail masmedical1 = new MasMedicalExaminationDetail();
						if (disabilityList.size() > 0) {
							if (disabilityList.get(b) > 0) {
								Disability masrank = new Disability();
								masrank.setDisabilityid(disabilityList.get(b));
								masmedical1.setDisability(masrank);

							}
						}
						if (disabilityrankList.size() > 0) {
							if (disabilityrankList.get(b) > 0) {
								MasRank masrank = new MasRank();
								masrank.setId(disabilityrankList.get(b));
								masmedical1.setRankDisability(masrank);
							}
						}
						if (disabilitydateList.size() > 0) {
							if (disabilitydateList.get(b) != null) {
								masmedical1
										.setDisabilitydate(disabilitydateList
												.get(b));
							}
						}
						if (disabilityplaceList.size() > 0)
							masmedical1.setPlaceDisability(disabilityplaceList.get(b));
						if (disabilityunitList.size() > 0) {
							if (disabilityunitList.get(b) > 0) {
								MasUnit dis = new MasUnit();
								dis.setId(disabilityunitList.get(b));
								masmedical1.setUnitDisability(dis);
							}
						}

						masmedical1.setParticular("disability");
						masmedical1.setMasMedicalReport(masMedicalExaminationReportOnEntry);
						hbt.save(masmedical1);
						++b;
					}
				}

				if (Labresult.equalsIgnoreCase("present") && data != null) {
					Visit visit = (Visit) hbt.load(Visit.class, visitId);
					visit.setMedStatus("f");
					hbt.update(visit);
				} else {
					Visit visit = (Visit) hbt.load(Visit.class, visitId);
					if (visit != null) {
						/*
						 * Code By Mukesh Date 03 Feb 2012
						 */
						/*
						 * Priority Color Coding By Mukesh Normal Urgent Very
						 * Urgent New Data 3 2 1 Pending For Result 6 5 4
						 * Rejected By MO 9 8 7
						 */
						// int priority=0;
						if (visit.getPriority() != null) {
							if (visit.getPriority() == 1) {
								visit.setPriority(4);
							} else if (visit.getPriority() == 2) {
								visit.setPriority(5);
							} else if (visit.getPriority() == 3) {
								visit.setPriority(6);
							}/*
							 * else if(visit.getPriority()==4){
							 * visit.setPriority(7); priority=7; }else
							 * if(visit.getPriority()==5){ visit.setPriority(8);
							 * priority=8; }else if(visit.getPriority()==6){
							 * visit.setPriority(9); priority=9; }else
							 * if(visit.getPriority()==7){ visit.setPriority(7);
							 * priority=7; }else if(visit.getPriority()==8){
							 * visit.setPriority(8); priority=8; }else
							 * if(visit.getPriority()==9){ visit.setPriority(9);
							 * priority=9; }
							 */
						} else {
							/*
							 * default priority
							 */
							visit.setPriority(6);
						}
						// visit.setPriority(1);

						hbt.update(visit);
					}
				}
				successfullyAdded = true;
				tx.commit();
			}

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}

		return successfullyAdded;

	}

	@Override
	public Map<String, Object> showMoWatingList(Map<String, Object> mapofds) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int commandId = 0;
		int hospitalId = 0;

		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		if (mapofds.get("commandId") != null) {
			commandId = (Integer) mapofds.get("commandId");
		}
		if (mapofds.get("hospitalId") != null) {
			hospitalId = (Integer) mapofds.get("hospitalId");
		}
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.eq("medicalType", "MedicalBoard"))
				.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId));
		patientDetailList = crit.list();
		map.put("patientDetailList", patientDetailList);

		return map;

	}

	public Map<String, Object> submitUploadDocuments(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String fileName = null;
		String fileExtension = null;
		int hinId = (Integer) mapForDS.get("hinId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		int masMedicalExamId = (Integer) mapForDS.get("masMedicalExamId");
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
				MasMedicalUploadDocument masUploadDocuments = new MasMedicalUploadDocument();
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
				MasMedicalExaminationReportOnEntry masMedicalExamReport = new MasMedicalExaminationReportOnEntry();
				masMedicalExamReport.setId(masMedicalExamId);
				masUploadDocuments
						.setMasMedicalExamReport(masMedicalExamReport);

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

	public Map<String, Object> viewUploadJsp(Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String fileName = null;
		String fileExtension = null;
		int hinId = (Integer) mapForDS.get("hinId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		int masMedicalExamId = (Integer) mapForDS.get("masExamId");
		int investigationId = (Integer) mapForDS.get("InvestId");
		try {
			List<MasMedicalUploadDocument> masMedicalUploadDocumentList = session
					.createCriteria(MasMedicalUploadDocument.class).add(
							Restrictions.eq("MasMedicalExamReport.Id",masMedicalExamId)).add(
							Restrictions.eq("Hin.Id", hinId)).add(Restrictions.eq("DgMasInvestigation.Id",
									investigationId)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			map.put("masMedicalUploadDocumentList",
					masMedicalUploadDocumentList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	@Override
	public Map showMOFormJsp(Box box) {
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<MasRank> masRankList = new ArrayList<MasRank>();

		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visit = null;
		List<DgOrderhd> resultList = null;
		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		int visitId = box.getInt("visitId");
		int medExamId = box.getInt("medExamId");
		int deptId = box.getInt("deptId");
		String accessjsp = box.getString("accessjsp");
		Session session = (Session) getSession();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		if (accessjsp.equalsIgnoreCase("CommandLevel")) {

			medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).add(Restrictions.eq("Status", "m").ignoreCase()).list();
		} else if (accessjsp.equalsIgnoreCase("MDLevel")) {

			medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).add(Restrictions.eq("Status", "c").ignoreCase()).list();
		} else {

			medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).add(Restrictions.eq("Status", "p").ignoreCase()).list();
		}
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		//visit = hbt.find("from Visit as v where v.Id='" + visitId + "'");
		visit=session.createCriteria(Visit.class).add(Restrictions.eq("Id", visitId)).list();
		List<Integer> headerIdsInt = new ArrayList<Integer>();
		resultList = session.createCriteria(DgResultEntryHeader.class)
					.createAlias("SampleCollectionHeader", "smColl").createAlias("smColl.Order", "order")
					.createAlias("order.Visit","vst").add(Restrictions.eq("vst.Id", visitId)).add(
						Restrictions.eq("ResultStatus", "A")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
		.createAlias("Department","dept").add(Restrictions.eq("dept.Id", deptId)).list();
		if (employeeList.size() > 0) {
			map.put("employeeList", employeeList);
		}
		List<MasMaritalStatus> maritalStatusList = null;
		maritalStatusList=session.createCriteria(MasMaritalStatus.class).add(Restrictions.eq("Status", "y")).list();
		/*maritalStatusList = hbt
				.find("from MasMaritalStatus mms where mms.Status='y'");*/
		masRankList=session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
		/*masRankList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasRank ");*/
		List<MasServiceType> serviceTypeList = null;
	/*	serviceTypeList = hbt
				.find("from MasServiceType mst where mst.Status='y'");*/
		serviceTypeList=session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).list();
		map.put("serviceTypeList", serviceTypeList);
		if (resultList != null || resultList.size() > 0) {
			map.put("resultList", resultList);
		}

		investigationList = session.createCriteria(DgMasInvestigation.class)
				.add(Restrictions.eq("Status", "y")).list();
		if (investigationList.size() > 0) {
			map.put("investigationList", investigationList);
		}

		map.put("visit", visit);
		map.put("maritalStatusList", maritalStatusList);
		map.put("medExamList", medExamList);
		map.put("masRankList", masRankList);
		return map;

	}

	public Map<String, Object> submitUploadDocuments(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<UploadDocuments> uploadDocumentsList = new ArrayList<UploadDocuments>();
		String fileName = null;
		String fileExtension = null;
		String patientName = box.getString("patientName");
		String age = box.getString("age");
		String sex = box.getString("sex");
		String hinNo = box.getString("hinNo");
		String address = box.getString("address");
		String hin_no = box.getString("hin_no");

		int hinId = box.getInt("hinId");
		int inpatientId = box.getInt("inpatientId");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		int hospitalId = box.getInt("hospitalId");
		String userName = box.getString("userName");
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			// hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List uploadDocumentList = session.createCriteria(
					UploadDocuments.class).add(
					Restrictions.eq("FileName", hin_no)).list();
			if (uploadDocumentList.size() == 0) {
				UploadDocuments uploadDocuments = new UploadDocuments();
				// String dataInput = new String(bytes);
				// uploadDocuments.setPatientDocument(bytes);
				// uploadDocuments.setPatientDocument(is.toString());
				uploadDocuments.setPatientName(patientName);
				uploadDocuments.setSex(sex);
				uploadDocuments.setAge(age);
				if (address != null)
					uploadDocuments.setAddress(address);
				uploadDocuments.setFileExtension(fileExtension);
				uploadDocuments.setFileName(hin_no);

				if (hinId != 0) {
					Patient patient = new Patient();
					patient.setId(hinId);
					uploadDocuments.setHin(patient);
				}
				if (inpatientId != 0) {
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inpatientId);
					uploadDocuments.setInpatient(inpatient);
				}
				uploadDocuments.setUploadDate(date);
				uploadDocuments.setLastChgDate(date);
				uploadDocuments.setLastChgTime(time);
				uploadDocuments.setLastChgBy(userName);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				uploadDocuments.setHospital(masHospital);
				hbt.save(uploadDocuments);
			}
			// hbt.setFetchSize(16*1024*1024);
			/*
			 * File file = null; for (int i = 1; i <= 5; i++) { if
			 * (!box.getString("filename" + i).equals("0")) { file = new
			 * File(box.getString("uploadURL") + "/" + box.getString("filename"
			 * + i)); FileInputStream is = new FileInputStream(file); long
			 * length = file.length(); ByteBuffer byteBuff = null; // int
			 * modLength=length/ if (length > Integer.MAX_VALUE) { // File is
			 * too large }
			 * 
			 * // Create the byte array to hold the data byte[] bytes = new
			 * byte[(int) length]; int offset = 0; int numRead = 0; while
			 * (offset < bytes.length && (numRead = is.read(bytes, offset,
			 * bytes.length - offset)) >= 0) { offset += numRead;
			 * 
			 * }
			 * 
			 * while (offset < bytes.length && (numRead=is.read(bytes, offset,
			 * )) >= 0) { offset += 1000; if(offset>bytes.length)
			 * offset=offset-bytes.length; }
			 * 
			 * 
			 * if (offset < bytes.length) { throw new
			 * IOException("Could not completely read file " + file.getName());
			 * 
			 * }
			 * 
			 * is.close(); // Close the input stream and return bytes
			 * StringTokenizer strToken = new StringTokenizer(box
			 * .getString("filename" + i), ".");
			 * 
			 * fileName = strToken.nextToken(); fileExtension =
			 * strToken.nextToken(); UploadDocuments uploadDocuments = new
			 * UploadDocuments(); String dataInput = new String(bytes);
			 * //uploadDocuments.setPatientDocument(bytes); //
			 * uploadDocuments.setPatientDocument(is.toString());
			 * uploadDocuments.setPatientName(patientName);
			 * uploadDocuments.setSex(sex); uploadDocuments.setAge(age); if
			 * (address != null) uploadDocuments.setAddress(address);
			 * uploadDocuments.setFileExtension(fileExtension);
			 * uploadDocuments.setFileName(fileName);
			 * 
			 * if (hinId != 0) { Patient patient = new Patient();
			 * patient.setId(hinId); uploadDocuments.setHin(patient); } if
			 * (inpatientId != 0) { Inpatient inpatient = new Inpatient();
			 * inpatient.setId(inpatientId);
			 * uploadDocuments.setInpatient(inpatient); }
			 * uploadDocuments.setDescription(box.getString("description" + i));
			 * uploadDocuments.setUploadDate(date);
			 * uploadDocuments.setLastChgDate(date);
			 * uploadDocuments.setLastChgTime(time);
			 * uploadDocuments.setLastChgBy(userName); MasHospital masHospital =
			 * new MasHospital(); masHospital.setId(hospitalId);
			 * uploadDocuments.setHospital(masHospital);
			 * hbt.save(uploadDocuments);
			 * 
			 * //file.delete(); }// end of 'IF'
			 * 
			 * }// end of 'for' loop
			 */map.put("dataSaved", true);
		}// end of 'try' loop
		catch (Exception e) {

			e.printStackTrace();
			map.put("dataSaved", false);
		}

		return map;

	}

	public Map<String, Object> viewPatientDetails(Map<String, Object> map) {
		Session session = (Session) getSession();

		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Visit> visitList = new ArrayList<Visit>();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");

		String inputField = (String) map.get("inputField");
		String flag = (String) map.get("flag");
		String flag1 = (String) map.get("flag1");
		String message = null;
		String destUploadURL = "";
		if (map.get("destuploadURL") != null
				&& !map.get("destuploadURL").equals("")) {
			destUploadURL = (String) map.get("destuploadURL");
		}
		Criteria criteria = null;
		if (flag.equals("upload") && !flag1.equals("viewDocuments")) {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("Status", "y")).add(
					Restrictions.eq("HinNo", inputField)).list();

			if (patientList.size() == 0) {
				inpatientList = session.createCriteria(Inpatient.class).add(
						Restrictions.eq("Status", "y")).add(
						Restrictions.eq("AdNo", inputField)).list();
			}

			if (visitList.size() == 0 && inpatientList.size() == 0
					&& patientList.size() == 0) {
				message = "No record Found !!";
			}
			map.put("message", message);
			map.put("patientList", patientList);
			map.put("inpatientList", inpatientList);

		} else if (flag.equals("view") || flag1.equals("viewDocuments")) {
			String uploadURL = (String) map.get("uploadURL");
			patientList = session.createCriteria(UploadDocuments.class)
					.createAlias("Hin", "p").add(
							Restrictions.eq("p.HinNo", inputField)).list();

			if (patientList.size() == 0) {
				inpatientList = session.createCriteria(UploadDocuments.class)
						.createAlias("Inpatient", "ip").add(
								Restrictions.eq("ip.AdNo", inputField)).list();
			}

			if (inpatientList.size() == 0 && patientList.size() == 0) {
				message = "No record Found !!";
			}
			map.put("message", message);
			map.put("patientList", patientList);
			map.put("inpatientList", inpatientList);
			String[] files = null;
			if (patientList.size() > 0) {
				files = new String[patientList.size()];
				Iterator iterator = patientList.iterator();
				int counter = 0;
				while (iterator.hasNext()) {
					UploadDocuments uploadDocuments = (UploadDocuments) iterator
							.next();
					files[counter] = uploadDocuments.getFileName() + "."
							+ uploadDocuments.getFileExtension();
					try {
						/*
						 * FileOutputStream is = new
						 * FileOutputStream(destUploadURL +
						 * uploadDocuments.getFileName() + "." +
						 * uploadDocuments.getFileExtension()); is.write(out);
						 * is.flush(); is.close();
						 */
						HMSUtil.copyCompletlyFolder(new File(uploadURL),
								new File(destUploadURL));

					} catch (Exception e) {
						e.printStackTrace();
					}
					counter++;
				}

			}
			if (inpatientList.size() > 0) {
				files = new String[inpatientList.size()];
				Iterator iterator = inpatientList.iterator();
				int counter = 0;
				while (iterator.hasNext()) {
					UploadDocuments uploadDocuments = (UploadDocuments) iterator
							.next();
					files[counter] = uploadDocuments.getFileName() + "."
							+ uploadDocuments.getFileExtension();
					try {
						/*
						 * FileOutputStream is = new FileOutputStream(uploadURL
						 * + files[counter]);
						 * 
						 * 
						 * is.write(uploadDocuments.getPatientDocument());
						 * is.flush(); is.close();
						 */
						File srcFile = new File(uploadURL
								+ uploadDocuments.getFileName() + "."
								+ uploadDocuments.getFileExtension());
						File destFile = new File(destUploadURL
								+ uploadDocuments.getFileName() + "."
								+ uploadDocuments.getFileExtension());

						HMSUtil.copyfile(srcFile, destFile);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					counter++;
				}
			}

		}
		return map;

	}

	@Override
	public Map<String, Object> medicalBoardReports(Map<String, Object> mapofds) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int commandId = 0;
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		if (mapofds.get("commandId") != null) {
			commandId = (Integer) mapofds.get("commandId");
		}

		// crit =
		// session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("Status",
		// "c"));

		// patientDetailList = crit.list();
		List<MasTrade> tradeList = null;
		List<Object[]> unitList = null;
		List<MasRank> rankList = null;
		List<MasCommand> commandList = null;
		List<Disability> DisabilityList = null;
		List<Disabilitygroup> DisabilitygroupList = null;
		List<Category> CategoryList = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		/*rankList = hbt
				.find("from MasRank as rank where rank.Status='y'  order by rank.RankName ");*/
		rankList=session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("RankName")).list();
		unitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).createAlias("Station",
				"station").setProjection(
				Projections.projectionList().add(Projections.property("Id"))
						.add(Projections.property("UnitName")).add(
								Projections.property("station.StationName")))
				.addOrder(Order.asc("UnitName")).list();
		DisabilityList = session.createCriteria(Disability.class).list();
		DisabilitygroupList = session.createCriteria(Disabilitygroup.class)
				.list();
		CategoryList = session.createCriteria(Category.class).list();
		/*tradeList = hbt
				.find("from MasTrade mt where mt.Status='y' order by mt.TradeName");
		commandList = hbt
				.find("from MasCommand mas where mas.Status='y' order by mas.CommandName");*/
		tradeList=session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("TradeName")).list();
		commandList=session.createCriteria(MasCommand.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("CommandName")).list();
		List<MasBloodGroup> bloodGroupList = null;
		/*bloodGroupList = hbt
				.find("from MasBloodGroup as dist where dist.Status='y' order by dist.BloodGroupName");*/
		bloodGroupList=session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status", "y")).addOrder(Order.desc("BloodGroupName")).list();
		int rankId = 0;
		int unitId = 0;
		int commandid = 0;
		String CategoryId = null;
		int tradeId = 0;
		int disabilityId = 0;
		int disabilityGroupId = 0;
		String AgeFrom = null;
		String to = null;
		String group1 = null;
		Date DateAson = null;
		String weight = null;
		int bloodid = 0;
		String LifeStyleFactor = null;
		Date IntervalFrom = null;
		Date IntervalTo = null;
		int Interval = 0;
		String Gender = null;
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.eq("Status", "v")).add(
						Restrictions.eq("medicalType", "MedicalBoard"));

		if (mapofds.get("Gender") != null) {
			Gender = (String) mapofds.get("Gender");
		}

		if (mapofds.get("rankId") != null) {
			rankId = (Integer) mapofds.get("rankId");
		}
		if (rankId != 0) {
			crit = crit.createAlias("Rank", "r").add(
					Restrictions.eq("r.Id", rankId));
		}
		if (mapofds.get("unitId") != null) {
			unitId = (Integer) mapofds.get("unitId");
		}
		if (unitId != 0) {
			crit = crit.createAlias("Unit", "u").add(Restrictions.eq("u.Id", unitId));
		}
		if (mapofds.get("commandid") != null) {
			commandid = (Integer) mapofds.get("commandid");

		}
		if (commandid != 0) {
			crit = crit.createAlias("Command", "c").add(
					Restrictions.eq("c.Id", commandid));
		}
		if (mapofds.get("CategoryId") != null) {
			CategoryId = (String) mapofds.get("CategoryId");

		}
		if (CategoryId != null) {
			crit = crit.createAlias("PresentMedicalCategory", "pmc").add(
					Restrictions.eq("pmc.Categories", CategoryId));
		}
		if (mapofds.get("tradeId") != null) {
			tradeId = (Integer) mapofds.get("tradeId");

		}
		if (tradeId != 0) {
			crit = crit.createAlias("Trade", "t").add(
					Restrictions.eq("t.Id", tradeId));
		}
		if (mapofds.get("disabilityId") != null) {
			disabilityId = (Integer) mapofds.get("disabilityId");

		}
		if (disabilityId != 0)
			crit = crit.createAlias("Disability", "r").add(Restrictions.eq("r.Id", disabilityId));

		if (mapofds.get("disabilityGroupId") != null) {
			disabilityGroupId = (Integer) mapofds.get("disabilityGroupId");

		}
		if (disabilityGroupId != 0) {
			crit = crit.createAlias("Disabilitygroup", "r").add(
					Restrictions.eq("r.Id", disabilityGroupId));
		}
		if (mapofds.get("AgeFrom") != null) {
			AgeFrom = (String) mapofds.get("AgeFrom");

		}
		if (mapofds.get("to") != null && mapofds.get("AgeFrom") != null) {
			to = (String) mapofds.get("to");

		}
		if (AgeFrom != null && to != null)
			crit = crit.add(Restrictions.gt("ApparentAge", AgeFrom)).add(
					Restrictions.lt("ApparentAge", to));

		// if (mapofds.get("group1") != null) {
		// group1 = (String) mapofds.get("group1");

		// }
		if (Gender != null || bloodid != 0) {
			crit = crit.createAlias("Visit", "v").createAlias("v.Hin", "h");
		}
		// if(group1!=null && ! group1.equalsIgnoreCase("Both_Sex"))
		// crit = crit.createAlias("h.Sex",
		// "s").add(Restrictions.eq("s.AdministrativeSexName", group1));

		if (mapofds.get("DateAson") != null) {
			DateAson = (Date) mapofds.get("DateAson");

		}
		if (DateAson != null)
			crit = crit.add(Restrictions.eq("DateValidated", DateAson));

		if (mapofds.get("weight") != null) {
			weight = (String) mapofds.get("weight");

		}
		if (weight != null && !weight.equalsIgnoreCase("0"))
			crit = crit.add(Restrictions.eq("Idealweight", weight));
		if (mapofds.get("bloodid") != null) {
			bloodid = (Integer) mapofds.get("bloodid");

		}
		if (bloodid != 0)
			crit = crit.createAlias("h.BloodGroup", "b").add(
					Restrictions.eq("b.Id", bloodid));

		if (mapofds.get("LifeStyleFactor") != null) {
			LifeStyleFactor = (String) mapofds.get("LifeStyleFactor");

		}
		// if(LifeStyleFactor!=null)
		// crit = crit.add(Restrictions.eq("r.Id", rankId));

		if (Gender != null) {
			crit = crit.createAlias("h.Sex", "s").add(
					Restrictions.eq("s.AdministrativeSexName", Gender));
		}

		if (mapofds.get("searchtype") != null
				&& (mapofds.get("searchtype").equals("graph") || mapofds.get(
						"searchtype").equals("graphInjsp"))) {
			List<Object[]> dataList = new ArrayList<Object[]>();
			IntervalFrom = (Date) mapofds.get("IntervalFrom");
			IntervalTo = (Date) mapofds.get("IntervalTo");
			// Interval = (Integer) mapofds.get("Interval");
			String pattern = "MM/dd/yyyy";
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			// sdf.format(date)

			crit = crit.add(Restrictions.ge("DateValidated", IntervalFrom))
					.add(Restrictions.le("DateValidated", IntervalTo));

			crit = crit.setProjection(Projections.projectionList().add(
					Projections.rowCount()).add(
					Projections.groupProperty("DateValidated")));

			dataList = crit.list();

			// TimeSeries series1 = new TimeSeries("Temperature", Minute.class);
			// TimeSeries series2 = new TimeSeries("Pulse", Minute.class);
			// TimeSeriesCollection dataset = new TimeSeriesCollection();
			// DefaultPieDataset dataset1 = new DefaultPieDataset();
			DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
			if (dataList.size() > 0) {
				int count = 0;
				int m = 0;
				for (Object[] entry : dataList) {
					String yaxis = entry[0].toString();
					String xaxis = entry[1].toString();
					dataset2.setValue(Integer.parseInt(yaxis),
							"No.Of Service Persion Done Medical Board", xaxis);

				}
				final CategoryItemRenderer renderer = new BarRenderer();
				renderer.setItemLabelsVisible(true);
				final CategoryPlot plot = new CategoryPlot();
				plot.setDataset(dataset2);
				plot.setRenderer(renderer);

				plot.setDomainAxis(new CategoryAxis("Medical Board Date"));
				plot.setRangeAxis(new NumberAxis("Value"));

				plot.setOrientation(PlotOrientation.VERTICAL);
				plot.setRangeGridlinesVisible(true);
				plot.setDomainGridlinesVisible(true);
				final JFreeChart chart = new JFreeChart(plot);
				chart.setTitle("TREND ANALYSIS GRAPH");
				// chart.setLegend(new StandardLegend());
				chart.getBackgroundImage();
				// add the chart to a panel...
				// get ImageMap

				// populate the info

				final ChartPanel chartPanel = new ChartPanel(chart);
				chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
				// setContentPane(chartPanel);
				JFreeChartRenderer jfcRenderer = new JFreeChartRenderer(chart);
				map.put("jfcRenderer", jfcRenderer);
				map.put("chart", chart);
				Connection conn = session.connection();
				map.put("conn", conn);

			} else // if record not exists in ipd_input_output_chart
			{
				map.put("status", "nodata");
			}

		}
		/*
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
		 * =crit.setProjection(Projections.projectionList().add(Projections.rowCount
		 * ()).add(Projections.groupProperty("DateValidated")));
		 * 
		 * dataList = crit.list(); map.put("dataList", dataList); }
		 */

		/*
		 * if(mapofds.get("searchtype")!=null &&
		 * mapofds.get("searchtype").equals("search")) {
		 * 
		 * }
		 */
		patientDetailList = crit.list();
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("commandList", commandList);
		map.put("tradeList", tradeList);
		map.put("DisabilityList", DisabilityList);
		map.put("DisabilitygroupList", DisabilitygroupList);
		map.put("CategoryList", CategoryList);
		map.put("patientDetailList", patientDetailList);
		map.put("bloodGroupList", bloodGroupList);

		return map;
	}

	@Override
	public Map<String, Object> getMedicalBoardDetails(
			Map<String, Object> mapfordata) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int commandId = 0;
		List<MasMedicalExaminationReportOnEntry> medicalDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		String serviceNo = null;
		if (mapfordata.get("serviceNo") != null) {
			serviceNo = (String) mapfordata.get("serviceNo");
		}

		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.eq("medicalType", "MedicalBoard")).add(
						Restrictions.eq("YearlySerialNo", serviceNo)).add(
						Restrictions.eq("Status", "f")).addOrder(
						Order.asc("DateOfReporting"));
		medicalDetailList = crit.list();
		map.put("medicalDetailList", medicalDetailList);

		return map;
	}

	@Override
	public Map<String, Object> getCaseSheetDetails(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int commandId = 0;
		List<MasMedicalExaminationReportOnEntry> medicalDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		int medExamId = 0;
		int visitId = 0;
		if (mapForDS.get("medExamId") != null) {
			medExamId = (Integer) mapForDS.get("medExamId");
		}
		if (mapForDS.get("visitId") != null) {
			visitId = (Integer) mapForDS.get("visitId");
		}
		List<Visit> visit = null;
		visit = session.createCriteria(Visit.class).add(
				Restrictions.eq("Id", visitId)).list();

		List<DgOrderhd> resultList = null;
		resultList = session.createCriteria(DgResultEntryHeader.class)
				.createAlias("SampleCollectionHeader", "smColl").createAlias(
						"smColl.Order", "order").createAlias("order.Visit",
						"vst").add(Restrictions.eq("vst.Id", visitId)).add(
						Restrictions.eq("ResultStatus", "A")).list();
		List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
				.createCriteria(PatientInvestigationHeader.class).createAlias(
						"Visit", "v").add(Restrictions.eq("v.Id", visitId))
				.createAlias("Hin", "p").add(
						Restrictions.eq("p.Id", visit.get(0).getHin().getId()))
				.list();
		PatientInvestigationHeader patientInvestigationHeader = null;
		if (patientInvestigationHeaderList != null
				&& patientInvestigationHeaderList.size() > 0) {
			patientInvestigationHeader = patientInvestigationHeaderList.get(0);
			map.put("patientInvestigationHeader", patientInvestigationHeader);

		}
		if (resultList != null || resultList.size() > 0) {
			map.put("resultList", resultList);
		}

		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.eq("Id", medExamId));
		medicalDetailList = crit.list();
		List<MasEmployee> employeeList = null;
		employeeList = session.createCriteria(MasEmployee.class).list();
		List<MasRank> masRankList = null;
		masRankList = session.createCriteria(MasRank.class).list();
		List<MasUnit> masUnitList = null;
		masUnitList = session.createCriteria(MasUnit.class).list();
		map.put("employeeList", employeeList);
		map.put("masRankList", masRankList);
		map.put("masUnitList", masUnitList);
		map.put("medicalDetailList", medicalDetailList);

		return map;
	}

	@Override
	public Map<String, Object> SaveCaseSheetDetails(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings) {
		Map<String, Object> map = new HashMap<String, Object>();
		HibernateTemplate hbt = null;
		Transaction tx = null;
		Session session = (Session) getSession();
		tx = session.beginTransaction();
		hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masMedicalBoardProceedings);
		return map;
	}

	@Override
	public Map<String, Object> SpecialistOpinionList(int hospitalId) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Criteria crit = null;
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.eq("medicalType", "MedicalBoard")).add(
						Restrictions.eq("Specialistopinion", "NO"));
		patientDetailList = crit.list();
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	@Override
	public Map<String, Object> CommandofficerList(int hospitalId) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Criteria crit = null;
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.eq("medicalType", "MedicalBoard")).add(
						Restrictions.eq("CommandingOfficer", "NO"));
		patientDetailList = crit.list();
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	public Map<String, Object> showUploadViewDocumentJsp(
			Map<String, Object> mapDetails) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int visitId = 0;
		int medExamId = 0;
		if (mapDetails.get("visitId") != null) {
			visitId = (Integer) mapDetails.get("visitId");
		}
		if (mapDetails.get("medExamId") != null) {
			medExamId = (Integer) mapDetails.get("medExamId");
		}
		String flag = "";
		if (mapDetails.get("flag") != null) {
			flag = (String) mapDetails.get("flag");
		}
		List<MasMedicalExaminationReportOnEntry> medicalDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<Visit> patientDataList = new ArrayList<Visit>();
		try {
			patientDataList = session.createCriteria(Visit.class).add(
					Restrictions.eq("Id", visitId)).list();

			Criteria crit = null;
			crit = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.eq("Id", medExamId));
			medicalDetailList = crit.list();
			map.put("medicalDetailList", medicalDetailList);
			map.put("patientDataList", patientDataList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map showMedicalOfficerMedBoardJsp(Box box) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> submitUploadDocumentsMo(
			Map<String, Object> mapForDS) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<UploadDocuments> uploadDocumentsList = new ArrayList<UploadDocuments>();
		String fileName = null;
		String fileExtension = null;
		String hin_no = "";
		if (mapForDS.get("hin_no") != null) {
			hin_no = (String) mapForDS.get("hin_no");
		}
		MultipartFormDataRequest mrequest = (MultipartFormDataRequest) mapForDS
				.get("mrequest");
		int hinId = 0;
		if (mapForDS.get("hinId") != null) {
			hinId = Integer.parseInt("" + mapForDS.get("hinId"));
		}

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		int hospitalId = 0;
		String userName = "";
		if (mapForDS.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDS.get("hospitalId");
		}
		if (mapForDS.get("userName") != null) {
			userName = (String) mapForDS.get("userName");
		}
		String flag = "";
		if (mapForDS.get("flag") != null) {
			flag = (String) mapForDS.get("flag");
		}
		String uploadURL = "";
		int uploadCount = 0;
		String fileSeparator = "";
		if (mapForDS.get("fileSeparator") != null) {
			fileSeparator = (String) mapForDS.get("fileSeparator");
		}
		if (mapForDS.get("uploadURL") != null) {
			uploadURL = (String) mapForDS.get("uploadURL");
		}
		if (mapForDS.get("uploadCount") != null) {
			uploadCount = (Integer) mapForDS.get("uploadCount");
		}
		int visitId = 0;
		int medExamId = 0;
		int investigationId = 0;
		if (mapForDS.get("visitId") != null) {
			visitId = (Integer) mapForDS.get("visitId");
		}
		if (mapForDS.get("medExamId") != null) {
			medExamId = (Integer) mapForDS.get("medExamId");
		}
		if (mapForDS.get("investigationId") != null) {
			investigationId = (Integer) mapForDS.get("investigationId");
		}
		List<String> fileNameList = new ArrayList<String>();
		List<String> fileNameExtList = new ArrayList<String>();
		List<String> fileWhiteList = new ArrayList<String>();
		List<String> fileDescriptionList = new ArrayList<String>();
		List<String> fileModeList = new ArrayList<String>();
		if (mapForDS.get("fileNameList") != null) {
			fileNameList = (List<String>) mapForDS.get("fileNameList");
		}
		if (mapForDS.get("fileNameExtList") != null) {
			fileNameExtList = (List<String>) mapForDS.get("fileNameExtList");
		}
		if (mapForDS.get("fileWhiteList") != null) {
			fileWhiteList = (List<String>) mapForDS.get("fileWhiteList");
		}
		if (mapForDS.get("fileDescriptionList") != null) {
			fileDescriptionList = (List<String>) mapForDS
					.get("fileDescriptionList");
		}
		if (mapForDS.get("fileModeList") != null) {
			fileModeList = (List<String>) mapForDS.get("fileModeList");
		}
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// HMSUtil.createFolderFroDocument(hin_no, uploadURL);
			if (fileNameList.size() > 0) {
				for (int i = 0; i < fileNameList.size(); i++) {
					/*
					 * HMSUtil.uploadFile(mrequest, uploadURL + hin_no +
					 * fileSeparator, fileWhiteList.get(i), fileNameList.get(i),
					 * i);
					 */

					File file = null;
					file = new File(uploadURL + fileSeparator + hin_no
							+ fileSeparator + visitId + fileNameList.get(i)
							+ "." + fileNameExtList.get(i));

					File f = new File(uploadURL);
					MasMedicalUploadDocument masUploadDocuments = new MasMedicalUploadDocument();
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
							byte[] bytes = new byte[(int) length];
							int offset = 0;
							int numRead = 0;
							while (offset < bytes.length
									&& (numRead = is.read(bytes, offset,
											bytes.length - offset)) >= 0) {
								offset += numRead;
							}

							if (offset < bytes.length) {
								throw new IOException(
										"Could not completely read file "
												+ file.getName());
							}

							masUploadDocuments.setDocument(bytes);
							is.close();
						} else {
							f.mkdir();
							FileInputStream is = new FileInputStream(file);
							long length = file.length();
							// ByteBuffer byteBuff=null;
							// int modLength=length/
							if (length > Integer.MAX_VALUE) {
								// File is too large
							}
							// Create the byte array to hold the data
							byte[] bytes = new byte[(int) length];
							int offset = 0;
							int numRead = 0;
							while (offset < bytes.length
									&& (numRead = is.read(bytes, offset,
											bytes.length - offset)) >= 0) {
								offset += numRead;
							}

							if (offset < bytes.length) {
								throw new IOException(
										"Could not completely read file "
												+ file.getName());
							}
							is.close();

							masUploadDocuments.setDocument(bytes);
						}

						// fileExtension=strToken.nextToken();

					} catch (Exception e) {
						e.printStackTrace();
					}

					// String dataInput = new String(bytes);
					masUploadDocuments.setFileName(fileNameList.get(i));
					// masUploadDocuments.setFileName(visitId+fileNameList.get(i));
					masUploadDocuments.setFileExtension(fileNameExtList.get(i));
					// masUploadDocuments.setDocument(bytes);
					if (investigationId > 0) {
						DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
						dgMasInvestigation.setId(investigationId);
						masUploadDocuments
								.setDgMasInvestigation(dgMasInvestigation);
					}
					Patient patient = new Patient();
					patient.setId(hinId);
					masUploadDocuments.setHin(patient);
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					masUploadDocuments.setHospital(masHospital);
					if (medExamId > 0) {
						MasMedicalExaminationReportOnEntry masMedicalExamReport = new MasMedicalExaminationReportOnEntry();
						masMedicalExamReport.setId(medExamId);
						masUploadDocuments
								.setMasMedicalExamReport(masMedicalExamReport);
					}
					if (fileDescriptionList.get(i) != null) {
						masUploadDocuments.setDescription(fileDescriptionList
								.get(i));
					}
					masUploadDocuments.setFileFlag(fileModeList.get(i));
					masUploadDocuments.setIdFlag("n");
					masUploadDocuments.setMedDate(date);
					hbt.save(masUploadDocuments);
				}
			}
			map.put("dataSaved", true);

			List<MasMedicalExaminationReportOnEntry> medicalDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
			List<Visit> patientDataList = new ArrayList<Visit>();
			try {
				patientDataList = session.createCriteria(Visit.class).add(
						Restrictions.eq("Id", visitId)).list();

				Criteria crit = null;
				crit = session.createCriteria(
						MasMedicalExaminationReportOnEntry.class).add(
						Restrictions.eq("Id", medExamId));
				medicalDetailList = crit.list();
				map.put("medicalDetailList", medicalDetailList);
				map.put("patientDataList", patientDataList);
			} catch (HibernateException e) {
				e.printStackTrace();
			}

		}// end of 'try' loop
		catch (Exception e) {

			e.printStackTrace();
			map.put("dataSaved", false);
		}
		return map;
	}

	@Override
	public Map<String, Object> viewUploadDocumentsMo(
			Map<String, Object> mapDetails) {
		Session session = (Session) getSession();

		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTimeWithoutSc");

		int medExamId = 0;
		if (mapDetails.get("medExamId") != null) {
			medExamId = (Integer) mapDetails.get("medExamId");
		}
		int hinId = 0;
		if (mapDetails.get("hinId") != null) {
			hinId = (Integer) mapDetails.get("hinId");
		}
		String flag = (String) mapDetails.get("flag");
		String message = null;
		String destUploadURL = "";

		List<MasMedicalUploadDocument> masMedicalUploadDocumentList = new ArrayList<MasMedicalUploadDocument>();

		if (mapDetails.get("destUploadURL") != null
				&& !mapDetails.get("destUploadURL").equals("")) {
			destUploadURL = (String) mapDetails.get("destUploadURL");
		}
		Criteria criteria = null;
		String uploadURL = (String) mapDetails.get("uploadURL");
		if (medExamId > 0) {
			masMedicalUploadDocumentList = session.createCriteria(
					MasMedicalUploadDocument.class).createAlias(
					"MasMedicalExamReport", "med").add(
					Restrictions.eq("med.Id", medExamId)).add(Restrictions.eq("FileFlag", flag)).list();
		} else {
			masMedicalUploadDocumentList = session.createCriteria(
					MasMedicalUploadDocument.class).createAlias("Hin", "hin")
					.add(Restrictions.eq("hin.Id", hinId)).list();
		}

		if (masMedicalUploadDocumentList.size() == 0) {
			message = "No record Found !!";
		}
		map.put("message", message);
		map.put("masMedicalUploadDocumentList", masMedicalUploadDocumentList);
		String[] files = null;
		if (masMedicalUploadDocumentList.size() > 0) {
			files = new String[masMedicalUploadDocumentList.size()];
			Iterator iterator = masMedicalUploadDocumentList.iterator();
			int counter = 0;
			while (iterator.hasNext()) {
				MasMedicalUploadDocument uploadDocuments = (MasMedicalUploadDocument) iterator
						.next();
				files[counter] = uploadDocuments.getFileName() + "."
						+ uploadDocuments.getFileExtension();
				try {
					/*
					 * FileOutputStream is = new FileOutputStream(destUploadURL
					 * + uploadDocuments.getFileName() + "." +
					 * uploadDocuments.getFileExtension()); is.write(out);
					 * is.flush(); is.close();
					 */
					HMSUtil.copyCompletlyFolder(new File(uploadURL), new File(
							destUploadURL));

				} catch (Exception e) {
					e.printStackTrace();
				}
				counter++;
			}

		}

		int visitId = 0;
		if (mapDetails.get("visitId") != null) {
			visitId = (Integer) mapDetails.get("visitId");
		}
		List<MasMedicalExaminationReportOnEntry> medicalDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<Visit> patientDataList = new ArrayList<Visit>();
		try {
			patientDataList = session.createCriteria(Visit.class).add(
					Restrictions.eq("Id", visitId)).list();

			Criteria crit = null;
			crit = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.eq("Id", medExamId));
			medicalDetailList = crit.list();
			map.put("medicalDetailList", medicalDetailList);
			map.put("patientDataList", patientDataList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;

	}

	@Override
	public Map<String, Object> showMBCommandOfficerWaitList(int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> patientDetailCmdOfficerList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).list();
		String[] statusArr = { "md", "nr" };
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.in("Status", statusArr)).add(
						Restrictions.eq("medicalType", "MedicalBoard"))
				.createAlias("Hospital", "h").add(
						Restrictions.eq("h.Id", hospitalId)).addOrder(
						Order.desc("Id"));

		patientDetailCmdOfficerList = crit.list();
		map.put("patientDetailCmdOfficerList", patientDetailCmdOfficerList);
		map.put("rankList", rankList);

		return map;

	}

	@Override
	public Map<String, Object> showMBApproveAuthWaitList(int commandId) {
       System.out.println("commandId in Board DataServiceImple------->"+commandId);
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> patientDetailAppAuthList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).list();
       System.out.println("medicalBoardDataServiceImple--------->"+commandId);
		//String[] statusArr = { "v", "ar" };
		String[] statusArr = { "v","f", "ar" };
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.in("Status", statusArr)).add(Restrictions.eq("medicalType", "MedicalBoard"))
				//.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
				.createAlias("Command", "c").add(Restrictions.eq("c.Id", commandId))
				.addOrder(Order.desc("Id"));

		patientDetailAppAuthList = crit.list();
		map.put("patientDetailAppAuthList", patientDetailAppAuthList);
		map.put("rankList", rankList);

		return map;

	}

	@Override
	public Map<String, Object> showMBPerusingAuthWaitList(int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> patientDetailAppAuthList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		String[] statusArr = { "a" };
	    rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y"))
			.add(Restrictions.eq("ServiceType.Id", 2)).addOrder(Order.asc("RankName")).list(); // for airforce service type id is 2 

		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.in("Status", statusArr)).add(Restrictions.eq("medicalType", "MedicalBoard"))
				.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
				.addOrder(						Order.desc("Id"));;

		patientDetailAppAuthList = crit.list();
		 
		List<Object[]> unitList = null;
		unitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(Order.asc("UnitName")).list();
		
		map.put("patientDetailAppAuthList", patientDetailAppAuthList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		return map;

	}

	@Override
	public Map<String, Object> showMBAppAuthDetails(Map<String, Object> mapForDS) {
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
		int empId = 0;
		if (mapForDS.get("empId") != null) {
			empId = (Integer) mapForDS.get("empId");
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
		List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
		employeeMoList = session.createCriteria(MasEmployee.class).add(
				Restrictions.idEq(empId)).list();
		map.put("employeeMoList", employeeMoList);
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
		List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
		masMedicalExaminationDetailList = session.createCriteria(
				MasMedicalExaminationDetail.class).createAlias(
				"MasMedicalReport", "medReport").add(
				Restrictions.eq("medReport.Id", medExamId)).addOrder(Order.asc("Serviceid")).list();
		map.put("masMedicalExaminationDetailList",
				masMedicalExaminationDetailList);
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		//visit = hbt.find("from Visit as v where v.Id='" + visitId + "'");
		visit= session.createCriteria(Visit.class)
		.add(Restrictions.eq("Id", visitId)).list();

		List<Integer> headerIdsInt = new ArrayList<Integer>();
		resultList = session.createCriteria(DgResultEntryHeader.class)
				.createAlias("SampleCollectionHeader", "smColl").createAlias(
						"smColl.Order", "order").createAlias("order.Visit",
						"vst").add(Restrictions.eq("vst.Id", visitId)).add(
						Restrictions.eq("ResultStatus", "A")).list();
		employeeList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).createAlias("Department",
				"dept").add(Restrictions.eq("dept.Id", deptId)).list();
		if (employeeList.size() > 0) {
			map.put("employeeList", employeeList);
		}
		List<MasMaritalStatus> maritalStatusList = null;
		maritalStatusList =session.createCriteria(MasMaritalStatus.class)
		.add(Restrictions.eq("Status","y")).list();
			//hbt
				//.find("from MasMaritalStatus mms where mms.Status='y'");
		List<Disability> disabilityList = new ArrayList<Disability>();
		disabilityList =session.createCriteria(Disability.class).list(); 
			//getHibernateTemplate().find(
				//"from jkt.hms.masters.business.Disability ");
		List<Category> categoryList = new ArrayList<Category>();
		categoryList =session.createCriteria(Category.class).list(); 
			//getHibernateTemplate().find(
				//"from jkt.hms.masters.business.Category ");
		List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		/*
		 * patientInvestigationHeaderList = (List<PatientInvestigationHeader>)
		 * session
		 * .createCriteria(PatientInvestigationHeader.class).createAlias(
		 * "Visit", "v") .add(Restrictions.eq("v.Id",
		 * visitId)).createAlias("Hin", "p")
		 * .add(Restrictions.eq("p.Id",visit.get(0).getHin().getId())).list();
		 * PatientInvestigationHeader patientInvestigationHeader=null; if
		 * (patientInvestigationHeaderList != null &&
		 * patientInvestigationHeaderList.size() > 0) {
		 * patientInvestigationHeader = patientInvestigationHeaderList.get(0);
		 * map.put("patientInvestigationHeader",patientInvestigationHeader);
		 * 
		 * }
		 */
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
		serviceTypeList =session.createCriteria(MasServiceType.class)
		.add(Restrictions.eq("Status","y")).list();
			//hbt
				//.find("from MasServiceType mst where mst.Status='y'");
		map.put("serviceTypeList", serviceTypeList);
		if (resultList != null || resultList.size() > 0) {
			map.put("resultList", resultList);
		}

		investigationList = session.createCriteria(DgMasInvestigation.class)
				.add(Restrictions.eq("Status", "y")).list();
		if (investigationList.size() > 0) {
			map.put("investigationList", investigationList);
		}
		/**
		 * Commented By Ritu Date 08 May 2012
		 */
		/*
		 * List<MasRank> masRankList1 = new ArrayList<MasRank>(); masRankList1 =
		 * getHibernateTemplate
		 * ().find("from jkt.hms.masters.business.MasRank "); List<MasIcd>
		 * masIcdList = new ArrayList<MasIcd>(); masIcdList =
		 * getHibernateTemplate().find("from jkt.hms.masters.business.MasIcd");
		 * List<Disabilitygroup> disabilitygroupList = new
		 * ArrayList<Disabilitygroup>(); disabilitygroupList =
		 * getHibernateTemplate
		 * ().find("from jkt.hms.masters.business.Disabilitygroup");
		 * List<MasUnit> masUnitList = new ArrayList<MasUnit>(); masUnitList =
		 * getHibernateTemplate().find("from jkt.hms.masters.business.MasUnit");
		 */
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
	public Map<String, Object> showMedicalExamList(Map<String, Object> mapForDS) {
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

	// --------------------- Dinesh Dubey
	// --------------------------------------------------
/*	@Override commented by dipali
	public Map<String, Object> showMisMedicalBoardReport(Map<String, Object> mapofds) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int commandId = 0;
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		if (mapofds.get("commandId") != null) {
			commandId = (Integer) mapofds.get("commandId");
		}

		// crit =
		// session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("Status",
		// "c"));
		// patientDetailList = crit.list();
		List<MasTrade> tradeList = null;
		List<Object[]> unitList = null;
		List<MasRank> rankList = null;
		List<MasCommand> commandList = null;
		// List<Disability> DisabilityList = null;
		List<Disabilitygroup> DisabilitygroupList = null;
		List<Category> CategoryList = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		rankList = session.createCriteria(MasRank.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("RankName")).list();
			//hbt.find("from MasRank as rank where rank.Status='y'  order by rank.RankName ");
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y"))
					.createAlias("Station","station").setProjection(Projections.projectionList()
					.add(Projections.property("Id")).add(Projections.property("UnitName"))
					.add(Projections.property("station.StationName"))).addOrder(Order.asc("UnitName")).list();
		// DisabilityList = session.createCriteria(Disability.class).list();
		DisabilitygroupList = session.createCriteria(Disabilitygroup.class).list();
		CategoryList = session.createCriteria(Category.class).list();
		tradeList = session.createCriteria(MasTrade.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("TradeName")).list();
			//hbt
				//.find("from MasTrade mt where mt.Status='y' order by mt.TradeName");
		commandList =session.createCriteria(MasCommand.class).add(Restrictions.eq("Id", commandId)).list();
		List<MasBloodGroup> bloodGroupList = null;
		bloodGroupList =session.createCriteria(MasBloodGroup.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("BloodGroupName")).list(); 
			//hbt
				//.find("from MasBloodGroup as dist where dist.Status='y' order by dist.BloodGroupName");
		int rankId = 0;
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
		if (mapofds.get("systemDiagnosis") != null) {
			String systemDiag = (String) mapofds.get("systemDiagnosis");
			
			List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = session
							.createCriteria(MasMedicalExaminationDetail.class)
							.add(Restrictions.eq("Particular", "detail").ignoreCase())
							.add(Restrictions.eq("Principal", systemDiag)).addOrder(Order.asc("Serviceid")).list();
			
			for (MasMedicalExaminationDetail masMedicalExamDetail : masMedicalExaminationDetailList) {
			crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
			.add(Restrictions.eq("Status", "p")).add(Restrictions.eq("medicalType", "MedicalBoard"))
					.add(Restrictions.eq("Id", masMedicalExamDetail.getMasMedicalReport().getId()));
				if (mapofds.get("Gender") != null) {
					Gender = (String) mapofds.get("Gender");
					searchType = "search";
				}

				if (mapofds.get("rankId") != null) {
					rankId = (Integer) mapofds.get("rankId");
					searchType = "search";
				}
				if (rankId != 0) {
					crit = crit.createAlias("Rank", "r").add(Restrictions.eq("r.Id", rankId));
					searchType = "search";
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
					crit = crit.add(Restrictions.eq("DateValidated", DateAson));

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
				if (Gender != null || bloodid != 0) {
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
				if (Gender != null) {
					crit = crit.createAlias("h.Sex", "s").add(
							Restrictions.eq("s.AdministrativeSexName", Gender));
					searchType = "search";
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
			crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
			.add(Restrictions.eq("Status", "p")).add(Restrictions.eq("medicalType", "MedicalBoard"));
			if (mapofds.get("Gender") != null) {
				Gender = (String) mapofds.get("Gender");
				// searchType="search";
			}

			if (mapofds.get("rankId") != null) {
				rankId = (Integer) mapofds.get("rankId");
				// searchType="search";
			}
			if (rankId != 0) {
				crit = crit.createAlias("Rank", "r").add(Restrictions.eq("r.Id", rankId));
				searchType = "search";
			}
			if (mapofds.get("unitId") != null) {
				unitId = (Integer) mapofds.get("unitId");
				searchType="search";
			}
			if (unitId != 0) {
				crit = crit.createAlias("Unit", "u").add(Restrictions.eq("u.Id", unitId));
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
				// searchType="search";
			}
			if (DateAson != null)
				crit = crit.add(Restrictions.eq("DateValidated", DateAson));

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
		}
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("commandList", commandList);
		map.put("tradeList", tradeList);
		// map.put("DisabilityList", DisabilityList);
		map.put("DisabilitygroupList", DisabilitygroupList);
		map.put("CategoryList", CategoryList);
		map.put("patientDetailList", patientDetailList);
		map.put("bloodGroupList", bloodGroupList);

		return map;
	}*/
	@Override
	public Map<String, Object> showMisMedicalBoardReport(Map<String, Object> mapofds) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList = null;
		List<MasServiceStatus> serviceStatusList = null;
		Session session = (Session) getSession();
		int commandId=0; 
		if (mapofds.get("commandId") != null) {
			commandId = (Integer) mapofds.get("commandId");
		}
		List<MasRankCategory> rankCategoryList = null;
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
		rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("Id")).list();
		serviceTypeList = session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceTypeName")).list();
		serviceStatusList = session.createCriteria(MasServiceStatus.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("ServiceStatusName")).list();
		sectionList = session.createCriteria(MasSection.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("SectionName")).list();
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("UnitName")).list();
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();

		DisabilitygroupList = session.createCriteria(Disabilitygroup.class).list();
		CategoryList = session.createCriteria(Category.class).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("TradeName")).list();
		commandList =session.createCriteria(MasCommand.class).add(Restrictions.eq("Id", commandId)).list();
		List<MasBloodGroup> bloodGroupList = null;
		bloodGroupList = session.createCriteria(MasBloodGroup.class).add(Restrictions.eq("Status","y")).addOrder(Order.asc("BloodGroupName")).list();
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
		map.put("bloodGroupList", bloodGroupList);
		return map;
	}
	// --------Dinesh Dubey-----------------------
	@Override
	public Map<String, Object> showMISMedicalBoardReportGraph(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> medicalExamRegisterList = new ArrayList<Object[]>();
		Session session = (Session) getSession();
		// SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		// String fromDate
		// =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		// String toDate =
		// sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE)));
		String subQry = "";
		int hospitalId = (Integer) dataMap.get("hospitalId");
		String fromYear = (String) dataMap.get("fromYear");
		String toYear = (String) dataMap.get("toYear");

		String fromQtr1 = "'01-april-" + fromYear + "'";
		String toQtr1 = "'30-june-" + fromYear + "'";
		String fromQtr2 = "'01-july-" + fromYear + "'";
		String toQtr2 = "'30-sep-" + fromYear + "'";
		String fromQtr3 = "'01-oct-" + fromYear + "'";
		String toQtr3 = "'31-dec-" + fromYear + "'";
		String fromQtr4 = "'01-jan-" + toYear + "'";
		String toQtr4 = "'31-march-" + toYear + "'";

		try {/*
			String qry = "(select distinct (select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "
					+ fromQtr1
					+ " and "
					+ toQtr1
					+ " and mmer.hospital_id="
					+ hospitalId
					+ " and mmer.medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 20 and 30) qrt1,"
					+ "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "
					+ fromQtr2
					+ " and "
					+ toQtr2
					+ " and mmer.hospital_id="
					+ hospitalId
					+ " and mmer.medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 20 and 30) qrt2,"
					+ "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "
					+ fromQtr3
					+ " and "
					+ toQtr3
					+ " and mmer.hospital_id="
					+ hospitalId
					+ " and mmer.medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 20 and 30) qrt3,"
					+ "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "
					+ fromQtr4
					+ " and "
					+ toQtr4
					+ " and mmer.hospital_id="
					+ hospitalId
					+ " and mmer.medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 20 and 30) qrt4,"
					+ " '20' as name from  mas_medical_examination_report ) union "
					+ "(select distinct (select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "
					+ fromQtr1
					+ " and "
					+ toQtr1
					+ " and mmer.hospital_id="
					+ hospitalId
					+ " and mmer.medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 30 and 40) qrt1,"
					+ "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "
					+ fromQtr2
					+ " and "
					+ toQtr2
					+ " and mmer.hospital_id="
					+ hospitalId
					+ " and mmer.medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 30 and 40) qrt2,"
					+ "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "
					+ fromQtr3
					+ " and "
					+ toQtr3
					+ " and mmer.hospital_id="
					+ hospitalId
					+ " and mmer.medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 30 and 40) qrt3,"
					+ "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "
					+ fromQtr4
					+ " and "
					+ toQtr4
					+ " and mmer.hospital_id="
					+ hospitalId
					+ " and mmer.medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 30 and 40) qrt4,"
					+ "'30' as name from  mas_medical_examination_report) union "
					+ "(select distinct (select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "
					+ fromQtr1
					+ " and "
					+ toQtr1
					+ " and mmer.hospital_id="
					+ hospitalId
					+ " and mmer.medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 40 and 50) qrt1,"
					+ "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "
					+ fromQtr2
					+ " and "
					+ toQtr2
					+ " and mmer.hospital_id="
					+ hospitalId
					+ " and mmer.medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 40 and 50) qrt2,"
					+ "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "
					+ fromQtr3
					+ " and "
					+ toQtr3
					+ " and mmer.hospital_id="
					+ hospitalId
					+ " and mmer.medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 40 and 50) qrt3,"
					+ "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "
					+ fromQtr4
					+ " and "
					+ toQtr4
					+ " and mmer.hospital_id="
					+ hospitalId
					+ " and mmer.medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 40 and 50) qrt4,"
					+ " '40' as name from  mas_medical_examination_report) union "
					+ "(select distinct (select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "
					+ fromQtr1
					+ " and "
					+ toQtr1
					+ " and mmer.hospital_id="
					+ hospitalId
					+ " and mmer.medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 50 and 60) qrt1,"
					+ "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "
					+ fromQtr2
					+ " and "
					+ toQtr2
					+ " and mmer.hospital_id="
					+ hospitalId
					+ " and mmer.medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 50 and 60) qrt2,"
					+ "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "
					+ fromQtr3
					+ " and "
					+ toQtr3
					+ " and mmer.hospital_id="
					+ hospitalId
					+ " and mmer.medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 50 and 60) qrt3,"
					+ "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "
					+ fromQtr4
					+ " and "
					+ toQtr4
					+ " and mmer.hospital_id="
					+ hospitalId
					+ " and mmer.medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 50 and 60) qrt4,"
					+ " '50' as name from  mas_medical_examination_report) order by name";

			medicalExamRegisterList = session.createSQLQuery(qry).list();
		*/
			
			String qry ="(select distinct (select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr1+" and "+toQtr1+" and mmer.status='p' and mmer.hospital_id="+hospitalId +" and medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 20 and 30) qrt1,"+
	       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr2+" and "+toQtr2+" and mmer.hospital_id="+hospitalId+" and mmer.status='p' and medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 20 and 30) qrt2,"+
	       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr3+" and "+toQtr3+" and mmer.hospital_id="+hospitalId+" and mmer.status='p' and medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 20 and 30) qrt3,"+
	       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr4+" and "+toQtr4+" and mmer.hospital_id="+hospitalId+" and mmer.status='p' and medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 20 and 30) qrt4,"+
	       " '20' as name from  mas_medical_examination_report ) union "+
	       "(select distinct (select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr1+" and "+toQtr1+" and mmer.hospital_id="+hospitalId +" and mmer.status='p' and medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 30 and 40) qrt1,"+
	       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr2+" and "+toQtr2+" and mmer.hospital_id="+hospitalId+" and mmer.status='p' and medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 30 and 40) qrt2,"+
	       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr3+" and "+toQtr3+" and mmer.hospital_id="+hospitalId+" and mmer.status='p' and medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 30 and 40) qrt3,"+
	       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr4+" and "+toQtr4+" and mmer.hospital_id="+hospitalId+" and mmer.status='p' and medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 30 and 40) qrt4,"+
	       "'30' as name from  mas_medical_examination_report) union "+
	       "(select distinct (select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr1+" and "+toQtr1+" and mmer.hospital_id="+hospitalId +" and mmer.status='p' and medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 40 and 50) qrt1,"+
	       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr2+" and "+toQtr2+" and mmer.hospital_id="+hospitalId+" and mmer.status='p' and medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 40 and 50) qrt2,"+
	       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr3+" and "+toQtr3+" and mmer.hospital_id="+hospitalId+" and mmer.status='p' and medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 40 and 50) qrt3,"+
	       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr4+" and "+toQtr4+" and mmer.hospital_id="+hospitalId+" and mmer.status='p' and medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 40 and 50) qrt4,"+
	       " '40' as name from  mas_medical_examination_report) union "+
	       "(select distinct (select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr1+" and "+toQtr1+" and mmer.hospital_id="+hospitalId +" and mmer.status='p' and medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 50 and 60) qrt1,"+
	       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr2+" and "+toQtr2+" and mmer.hospital_id="+hospitalId+" and mmer.status='p' and medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 50 and 60) qrt2,"+
	       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr3+" and "+toQtr3+" and mmer.hospital_id="+hospitalId+" and mmer.status='p' and medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 50 and 60) qrt3,"+
	       "(select count(*) as name from  mas_medical_examination_report mmer left outer join patient on patient.hin_id=mmer.hin_id where mmer.date_of_reporting between "+fromQtr4+" and "+toQtr4+" and mmer.hospital_id="+hospitalId+" and mmer.status='p' and medicaltype='MedicalBoard' and (substr(age,0,2)+(extract(year from sysdate)-extract(year from reg_date))) between 50 and 60) qrt4,"+
	       " '50' as name from  mas_medical_examination_report) order by name";
			
			medicalExamRegisterList = session.createSQLQuery(qry).list();	
			
		} catch (HibernateException he) {
			he.printStackTrace();
		}
		map.put("medicalExamRegisterList", medicalExamRegisterList);
		return map;
	}

	public Map<String, Object> medicalBoardReports() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> searchMasDepartmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> searchMasEmployeeList = new ArrayList<MasEmployee>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		try {

			searchMasDepartmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment md where md.Status='y' order by md.DepartmentName asc");
			searchMasEmployeeList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.MasEmployee as emp where emp.EmpCategory.Id='1'");
			rankList = getHibernateTemplate().find("from jkt.hms.masters.business.MasRank md where md.Status='y' order by md.RankName asc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("searchMasDepartmentList", searchMasDepartmentList);
		map.put("searchMasEmployeeList", searchMasEmployeeList);
		map.put("rankList", rankList);
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

	public Map<String, Object> showCurrentMedicalBoardStatus(Map<String, Object> mapofds) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int commandId = 0;
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		int hospitalId = 1;
		if (mapofds.get("hospitalId") != null) {
			hospitalId = (Integer) mapofds.get("hospitalId");
		}

		if (mapofds.get("commandId") != null) {
			commandId = (Integer) mapofds.get("commandId");
		}
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.eq("medicalType", "MedicalBoard")).createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.desc("Id"));
		patientDetailList = crit.list();
		map.put("patientDetailList", patientDetailList);

		return map;
	}

	@Override
	public Map<String, Object> rejectMedicalBoardEntry(Map<String, Object> mapDetails) {

		Map<String, Object> map = new HashMap<String, Object>();
		String medRemarks = "";
		String authRemarks = "";
		String perusingRemarks = "";
		String rejectStatus = "";
		int visitId = 0;
		int medExamId = 0;
		if (mapDetails.get("visitId") != null) {
			visitId = (Integer) mapDetails.get("visitId");
		}
		if (mapDetails.get("medExamId") != null) {
			medExamId = (Integer) mapDetails.get("medExamId");
		}
		if (mapDetails.get("medRemarks") != null) {
			medRemarks = (String) mapDetails.get("medRemarks");
		}
		if (mapDetails.get("authRemarks") != null) {
			authRemarks = (String) mapDetails.get("authRemarks");
		}
		if (mapDetails.get("perusingRemarks") != null) {
			perusingRemarks = (String) mapDetails.get("perusingRemarks");
		}
		if (mapDetails.get("rejectStatus") != null) {
			rejectStatus = (String) mapDetails.get("rejectStatus");
		}
		MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry = new MasMedicalExaminationReportOnEntry();

		HibernateTemplate hbt = null;
		Transaction tx = null;
		Session session = (Session) getSession();
		try {
			tx = session.beginTransaction();
			hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			/*
			 * Code By Mukesh Date 03 Feb 2012
			 */
			Visit visitObj = (Visit) hbt.load(Visit.class, visitId);
			if (visitObj != null) {
				/*
				 * Code By Mukesh Date 03 Feb 2012
				 */
				/*
				 * Priority Color Coding By Mukesh Normal Urgent Very Urgent New
				 * Data 3 2 1 Pending For Result 6 5 4 Rejected By MO 9 8 7
				 */
				int priority = 0;
				if (visitObj.getPriority() != null) {
					if (visitObj.getPriority() == 1) {
						visitObj.setPriority(7);
						priority = 7;
					} else if (visitObj.getPriority() == 2) {
						visitObj.setPriority(8);
						priority = 8;
					} else if (visitObj.getPriority() == 3) {
						visitObj.setPriority(9);
						priority = 9;
					} else if (visitObj.getPriority() == 4) {
						visitObj.setPriority(7);
						priority = 7;
					} else if (visitObj.getPriority() == 5) {
						visitObj.setPriority(8);
						priority = 8;
					} else if (visitObj.getPriority() == 6) {
						visitObj.setPriority(9);
						priority = 9;
					} else if (visitObj.getPriority() == 7) {
						visitObj.setPriority(7);
						priority = 7;
					} else if (visitObj.getPriority() == 8) {
						visitObj.setPriority(8);
						priority = 8;
					} else if (visitObj.getPriority() == 9) {
						visitObj.setPriority(9);
						priority = 9;
					}
				}

				/*
				 * Code By Mukesh Status m MA Waiting List (Direct from
				 * visit/reception) f MO Waiting List (forwarded from MA) v
				 * Approving Authority Waiting List (validate from from Mo) a
				 * Perusing Authority Waiting List (validate from from Approving
				 * Authority) p Perusing Authority validated fr Rejected By Mo
				 * (Display In MA Waiting List) vr Rejected By Approving
				 * Authority(Display In MO Waiting List) ar Rejected Perusing
				 * Authority (Display In Approving Authority Waiting List)
				 */
				masMedicalExaminationReportOnEntry = (MasMedicalExaminationReportOnEntry) hbt
						.load(MasMedicalExaminationReportOnEntry.class,
								medExamId);
				if (rejectStatus.equalsIgnoreCase("fr")) {
					visitObj.setMedStatus("w");
					hbt.update(visitObj);
					masMedicalExaminationReportOnEntry.setPriority(priority);
					masMedicalExaminationReportOnEntry.setRemarks(medRemarks);
					masMedicalExaminationReportOnEntry.setStatus("fr");
				} else if (rejectStatus.equalsIgnoreCase("vr")) {
					masMedicalExaminationReportOnEntry.setRemarks(authRemarks);
					masMedicalExaminationReportOnEntry.setStatus("vr");
				} else if (rejectStatus.equalsIgnoreCase("ar")) {
					masMedicalExaminationReportOnEntry
							.setRemarks(perusingRemarks);
					masMedicalExaminationReportOnEntry.setStatus("ar");
				}

				hbt.update(masMedicalExaminationReportOnEntry);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> showMBPerusingAuthDetails(Map<String, Object> mapForDS) {
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
	
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
		String search = "";
		String accessjsp = "";
		if (mapForDS.get("search") != null) {
			search = (String) mapForDS.get("search");
		}
		if (mapForDS.get("accessjsp") != null) {
			accessjsp = (String) mapForDS.get("accessjsp");
		}
		Session session = (Session) getSession();
		int empId = 0;
		if (mapForDS.get("empId") != null) {
			empId = (Integer) mapForDS.get("empId");
		}
		
		employeeMoList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(empId)).list();
		map.put("employeeMoList", employeeMoList);
		
		if (search.equalsIgnoreCase("true")) {
			medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).list();
		} else if (search.equalsIgnoreCase("false")) {
			medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(
						Restrictions.idEq(medExamId)).list();
		} else {
			medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(
						Restrictions.idEq(medExamId)).list();
		}
		map.put("medExamList", medExamList);
		
		//List<Visit> visit = null;
		//	List<DgOrderhd> resultList = null;
		//List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		//List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		//List<Integer> headerIdsInt = new ArrayList<Integer>();
		//List<MasMaritalStatus> maritalStatusList = null;
	//	List<Category> categoryList = new ArrayList<Category>();
	//	List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		//List<Disability> disabilityList = new ArrayList<Disability>();
		//List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		//List<MasServiceType> serviceTypeList = null;
		//List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		//List<MasRank> masRankList1 = new ArrayList<MasRank>();
		//List<Disabilitygroup> disabilitygroupList = new ArrayList<Disabilitygroup>();
		//List<MasIcd> masIcdList = new ArrayList<MasIcd>();
		/**/
	/*	visit = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(
				Restrictions.idEq(visitId)).list();
			//hbt.find("from Visit as v where v.Id='" + visitId + "'");
		
		resultList = session.createCriteria(DgResultEntryHeader.class)
				.createAlias("SampleCollectionHeader", "smColl").createAlias("smColl.Order", "order")
				.createAlias("order.Visit","vst").add(Restrictions.eq("vst.Id", visitId))
				.add(Restrictions.eq("ResultStatus", "A")).list();
						
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
				.createAlias("Department","dept").add(Restrictions.eq("dept.Id", deptId)).list();
		if (employeeList.size() > 0) {
			map.put("employeeList", employeeList);
		}
		
		maritalStatusList =session.createCriteria(MasMaritalStatus.class)
		.add(Restrictions.eq("Status", "y")).list();
			//hbt.find("from MasMaritalStatus mms where mms.Status='y'");
		disabilityList = session.createCriteria(Disability.class).list();
			//getHibernateTemplate().find("from jkt.hms.masters.business.Disability ");
		categoryList = session.createCriteria(Category.class).list();
			//getHibernateTemplate().find("from jkt.hms.masters.business.Category ");
		
		 * patientInvestigationHeaderList = (List<PatientInvestigationHeader>)
		 * session
		 * .createCriteria(PatientInvestigationHeader.class).createAlias(
		 * "Visit", "v") .add(Restrictions.eq("v.Id",
		 * visitId)).createAlias("Hin", "p")
		 * .add(Restrictions.eq("p.Id",visit.get(0).getHin().getId())).list();
		 * PatientInvestigationHeader patientInvestigationHeader=null; if
		 * (patientInvestigationHeaderList != null &&
		 * patientInvestigationHeaderList.size() > 0) {
		 * patientInvestigationHeader = patientInvestigationHeaderList.get(0);
		 * map.put("patientInvestigationHeader",patientInvestigationHeader);
		 * 
		 * }
		 
				
		dgOrderhdList = (List<DgOrderhd>) session.createCriteria(DgOrderhd.class)
						.createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
		DgOrderhd dgOrderhd = null;
		if (dgOrderhdList != null && dgOrderhdList.size() > 0) {
			dgOrderhd = dgOrderhdList.get(0);
			map.put("dgOrderhd", dgOrderhd);
		}
		serviceTypeList = session.createCriteria(MasServiceType.class)
		.add(Restrictions.eq("Status", "y")).list();
			//hbt.find("from MasServiceType mst where mst.Status='y'");
		if (resultList != null || resultList.size() > 0) {
			map.put("resultList", resultList);
		}
		investigationList = session.createCriteria(DgMasInvestigation.class)
							.add(Restrictions.eq("Status", "y")).list();
		if (investigationList.size() > 0) {
			map.put("investigationList", investigationList);
		}
		masRankList1 = session.createCriteria(MasRank.class).list();
			//getHibernateTemplate().find("from jkt.hms.masters.business.MasRank ");
		masIcdList = session.createCriteria(MasIcd.class).list();
			//getHibernateTemplate().find("from jkt.hms.masters.business.MasIcd");
		disabilitygroupList = session.createCriteria(Disabilitygroup.class).list();
			//getHibernateTemplate().find("from jkt.hms.masters.business.Disabilitygroup");
		masUnitList = session.createCriteria(MasUnit.class).list();
			//getHibernateTemplate().find("from jkt.hms.masters.business.MasUnit");
		
		map.put("serviceTypeList", serviceTypeList);
		map.put("visit", visit);
		map.put("masRankList1", masRankList1);
		map.put("maritalStatusList", maritalStatusList);
		
		map.put("disabilityList", disabilityList);
		map.put("categoryList", categoryList);
		map.put("masIcdList", masIcdList);
		map.put("disabilitygroupList", disabilitygroupList);
		map.put("masUnitList", masUnitList);*/
		return map;
	}

	@Override
	public Map<String, Object> saveInitialMedicalBoardPerusingAuthJsp(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = 0;
		int visitId = 0;
		int medExamId = 0;
		if (mapForDS.get("visitId") != null) {
			visitId = (Integer) mapForDS.get("visitId");
		}
		if (mapForDS.get("medExamId") != null) {
			medExamId = (Integer) mapForDS.get("medExamId");
		}
		int deptId = 0;
		if (mapForDS.get("deptId") != null) {
			deptId = (Integer) mapForDS.get("deptId");
		}
		MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry = new MasMedicalExaminationReportOnEntry();
		if (mapForDS.get("masMedicalBoardProceedings") != null) {
			masMedicalExaminationReportOnEntry = (MasMedicalExaminationReportOnEntry) mapForDS
					.get("masMedicalBoardProceedings");
		}
		HibernateTemplate hbt = null;
		Transaction tx = null;
		Session session = (Session) getSession();
		boolean falg = false;
		try {
			tx = session.beginTransaction();
			hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masMedicalExaminationReportOnEntry);
			falg = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			falg = false;
			e.printStackTrace();
		}
		map.put("falg", falg);
		return map;

	}

	@Override
	public Map<String, Object> addMedicalBoardMA16(
			MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry,
			List<MasMedicalBoardExaminationDetail> masMedicalBoardExaminationDetail,
			Map<String, Object> mapForDS) {
		String date = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
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
			//saveinvestigation = saveInvestigationAdd(mapForDS);
			saveinvestigation = saveInvestigation(mapForDS);
			
			if (saveinvestigation) {
				hbt.save(masMedicalExaminationReportOnEntry);
				
				List<Integer> serialnolist = new ArrayList<Integer>();
				List<String> fromlist = new ArrayList<String>();
				List<String> tolist = new ArrayList<String>();
				List<String> placelist = new ArrayList<String>();
				List<String> pnolist = new ArrayList<String>();
				List<String> illnesslist = new ArrayList<String>();
				List<Date> particulardatelist = new ArrayList<Date>();
				List<Integer> rankidlist = new ArrayList<Integer>();
				List<String> treatedlist = new ArrayList<String>();
				List<Date> approximatedatelist = new ArrayList<Date>();
				List<Date> approximatedate2list = new ArrayList<Date>();
				List<String> beforeDisabilitylist = new ArrayList<String>();
				if (mapForDS.get("beforeDisabilitylist") != null) {
					beforeDisabilitylist = (List) mapForDS
							.get("beforeDisabilitylist");
				}
				List<Integer> serialnolist1 = new ArrayList<Integer>();
				List<String> placelist1 = new ArrayList<String>();
				List<String> principallist = new ArrayList<String>();
				List<Date> origindatelist = new ArrayList<Date>();
				List<Date> medicalcatdatelist = new ArrayList<Date>();
				List<Date> nextcatdatelist = new ArrayList<Date>();
				int hiddenValue = 1;
				int hiddenValue1 = 1;
				int hdbvalue = 1;
				int hdbvalue1 = 1;

				int visitId = (Integer) mapForDS.get("visitId");
				int hinId = (Integer) mapForDS.get("hinId");
				String permanentAddress = "";
				if (mapForDS.get("permanentAddress") != null) {
					permanentAddress = (String) mapForDS
							.get("permanentAddress");
				}
				List<String> batchNoList = (List<String>) mapForDS
						.get("batchNoList");
				approximatedatelist = (List) mapForDS
						.get("approximatedatelist");
				if (mapForDS.get("approximatedate2list") != null) {
					approximatedate2list = (List) mapForDS
							.get("approximatedate2list");
				}
				List<Integer> illnessICDBeforelist = new ArrayList<Integer>();
				if (mapForDS.get("illnessICDBeforelist") != null) {
					illnessICDBeforelist = (List) mapForDS
							.get("illnessICDBeforelist");
				}

				List<Integer> illnessICDlist = new ArrayList<Integer>();

				if (mapForDS.get("illnessICDlist") != null) {
					illnessICDlist = (List) mapForDS.get("illnessICDlist");
				}
				if (masMedicalExaminationReportOnEntry.getMedicalExamType()
						.equalsIgnoreCase("Medical Board AFMSF 16")) {
					/*
					 * Code for Disability Date 01 March 2012
					 */
					List<MasMedicalExaminationDetail> masMedicalExaminationDetailsDisabilityList = new ArrayList<MasMedicalExaminationDetail>();

					if (mapForDS
							.get("masMedicalExaminationDetailsDisabilityList") != null) {
						masMedicalExaminationDetailsDisabilityList = (List) mapForDS
								.get("masMedicalExaminationDetailsDisabilityList");
					}
					if (masMedicalExaminationDetailsDisabilityList.size() > 0) {
						for (MasMedicalExaminationDetail masMedicalExaminationDetail : masMedicalExaminationDetailsDisabilityList) {
							masMedicalExaminationDetail
									.setMasMedicalReport(masMedicalExaminationReportOnEntry);
							session.save(masMedicalExaminationDetail);
						}
					}
					/*
					 * End of Code for Disability Date 01 March 2012
					 */
					serialnolist = (List) mapForDS.get("serialnolist");
					fromlist = (List) mapForDS.get("fromlist");
					tolist = (List) mapForDS.get("tolist");
					placelist = (List) mapForDS.get("placelist");
					pnolist = (List) mapForDS.get("pnolist");
					hiddenValue = (Integer) mapForDS.get("hiddenValue");
					hdbvalue = (Integer) mapForDS.get("hdbvalue");
					principallist = (List) mapForDS.get("principallist");
					origindatelist = (List) mapForDS.get("origindatelist");
					medicalcatdatelist = (List) mapForDS
							.get("medicalcatdatelist");
					nextcatdatelist = (List) mapForDS.get("nextcatdatelist");

					// for (int i = 0; i < hdbvalue; i++) {
					for (int i = 0; i < fromlist.size(); i++) {
						MasMedicalExaminationDetail masmedical = new MasMedicalExaminationDetail();
						/*int serialNo = 0;
						if (serialnolist.get(i) != null) {
							serialNo = serialnolist.get(i);
						}
						if (serialNo > 0) {*///-----Commented by dipali (18-june-2012)
						//------Added by dipali(18-june-2012)
						if(fromlist.get(i) != null	&& fromlist.get(i) != ""){
							if (serialnolist.get(i) != null && !serialnolist.get(i).equals("")) {
								masmedical.setSerialno(serialnolist.get(i));
							}
							if (fromlist.get(i) != null
									&& fromlist.get(i) != "") {
								masmedical
										.setAddressfrom(HMSUtil
												.convertStringTypeDateToDateType(fromlist
														.get(i)));
							}
							if (tolist.get(i) != null && tolist.get(i) != "") {
								masmedical.setAddressto(HMSUtil
										.convertStringTypeDateToDateType(tolist
												.get(i)));
							}
							if (placelist.get(i) != null && !placelist.get(i).equals("")) {
								masmedical.setPlace(placelist.get(i));
							}
							if (pnolist.get(i) != null && !pnolist.get(i).equals("")) {
								masmedical.setPno(pnolist.get(i));
							}
							masmedical.setParticular("detail1");
							masmedical
									.setMasMedicalReport(masMedicalExaminationReportOnEntry);
							/*
							if(principallist.get(i)!=null){
								 masmedical.setPrincipal(principallist.get(i)); }
							 * if(principallist.get(i)!=null){
							 * masmedical.setPrincipal(principallist.get(i)); }
							 * if(origindatelist.get(i)!=null){
							 * masmedical.setOrigindate(origindatelist.get(i));
							 * } if(medicalcatdatelist.get(i)!=null){
							 * masmedical.
							 * setMedicalcatdate(medicalcatdatelist.get(i)); }
							 * if(nextcatdatelist.get(i)!=null){
							 * masmedical.setNextcatdate
							 * (nextcatdatelist.get(i)); }
							 * 
							 * if(beforeDisabilitylist.get(i)!=null){
							 * masmedical.
							 * setBeforeDisability(beforeDisabilitylist.get(i));
							 * } if(approximatedatelist.get(i)!=null){
							 * masmedical
							 * .setApproximatedate1(approximatedatelist.get(i));
							 * } if(approximatedate2list.get(i)!=null){
							 * masmedical
							 * .setApproximatedate2(approximatedate2list
							 * .get(i)); }
							 */
						}
						hbt.save(masmedical);
					}
					/*
					 * Code for Service Before Disibility
					 */
					List<Integer> serialnoBeforeList = new ArrayList<Integer>();
					List<String> illnessBeforeList = new ArrayList<String>();
					List<Date> particulardateBeforeList = new ArrayList<Date>();
					List<String> treatedBeforeList = new ArrayList<String>();
					List<String> placeBeforeList = new ArrayList<String>();
					List<String> beforeDisabilityBeforeList = new ArrayList<String>();
					int hdbBefore = 0;
					hdbBefore = (Integer) mapForDS.get("hdbBefore");
					if (mapForDS.get("serialnoBeforeList") != null) {
						serialnoBeforeList = (List) mapForDS
								.get("serialnoBeforeList");
					}
					if (mapForDS.get("illnessBeforeList") != null) {
						illnessBeforeList = (List) mapForDS
								.get("illnessBeforeList");
					}
					if (mapForDS.get("placeBeforeList") != null) {
						placeBeforeList = (List) mapForDS
								.get("placeBeforeList");
					}
					if (mapForDS.get("particulardateBeforeList") != null) {
						particulardateBeforeList = (List) mapForDS
								.get("particulardateBeforeList");
					}
					if (mapForDS.get("treatedBeforeList") != null) {
						treatedBeforeList = (List) mapForDS
								.get("treatedBeforeList");
					}
					if (mapForDS.get("beforeDisabilityBeforeList") != null) {
						beforeDisabilityBeforeList = (List) mapForDS
								.get("beforeDisabilityBeforeList");
					}
					for (int i = 0; i < illnessBeforeList.size(); i++) {
						MasMedicalExaminationDetail masmedical = new MasMedicalExaminationDetail();
						/*int serialNo = 0;
						if (serialnoBeforeList.get(i) != null) {
							serialNo = serialnoBeforeList.get(i);
						}
						if (serialNo > 0) {*///------Commented by dipali(18-june-2012)
						//------Added by dipali(18-june-2012)
						if(illnessICDBeforelist.get(i) != null	&& illnessICDBeforelist.get(i) != 0){
							if (serialnoBeforeList.get(i) != null && !serialnoBeforeList.get(i).equals("")) {
								masmedical.setSerialno(serialnoBeforeList
										.get(i));
							}
							if (illnessBeforeList.get(i) != null && !serialnoBeforeList.get(i).equals("")) {
								masmedical.setIllness(illnessBeforeList.get(i));
							}
							
							if(illnessICDBeforelist.get(i)>0){ 
								MasIcd masIcd=new MasIcd();
								masIcd.setId(illnessICDBeforelist.get(i));
								masmedical.setMasIcd(masIcd); 
							}
							 
							/*if (illnessICDBeforelist.get(i) > 0) {
								MasSystemDiagnosis sysDiagnosis = new MasSystemDiagnosis();
								sysDiagnosis.setId(illnessICDBeforelist.get(i));
								masmedical.setSystemDiagnosis(sysDiagnosis);
							}*/
							if (placeBeforeList.get(i) != null && !placeBeforeList.get(i).equals("")) {
								masmedical.setPlace(placeBeforeList.get(i));
							}
							/*
							 * Before Disability = n means after service Before
							 * Disability = y means before service
							 */
							if (beforeDisabilityBeforeList.get(i) != null && !beforeDisabilityBeforeList.get(i).equals("")) {
								masmedical
										.setBeforeDisability(beforeDisabilityBeforeList
												.get(i));
							}
							if (particulardateBeforeList.get(i) != null && !particulardateBeforeList.get(i).equals("")) {
								masmedical
										.setParticulardate(particulardateBeforeList
												.get(i));
							}
							if (treatedBeforeList.get(i) != null && !treatedBeforeList.get(i).equals("")) {
								masmedical.setTreated(treatedBeforeList.get(i));
							}
							masmedical.setParticular("particular");
							masmedical
									.setMasMedicalReport(masMedicalExaminationReportOnEntry);
							session.save(masmedical);
						}
					}
					/*
					 * End of Code Service Before Dislibility
					 */
				}
				if (masMedicalExaminationReportOnEntry.getMedicalExamType()
						.equalsIgnoreCase("Medical Board AFMSF 16")) {
					/*
					 * Code Service Dislibility
					 */
					serialnolist1 = (List) mapForDS.get("serialnolist1");
					illnesslist = (List) mapForDS.get("illnesslist");
					particulardatelist = (List) mapForDS
							.get("particulardatelist");
					rankidlist = (List) mapForDS.get("rankidlist");
					treatedlist = (List) mapForDS.get("treatedlist");

					hiddenValue1 = (Integer) mapForDS.get("hiddenValue1");
					hdbvalue1 = (Integer) mapForDS.get("hdbvalue1");
					placelist1 = (List) mapForDS.get("placelist1");
					// for (int i = 0; i < hdbvalue1; i++) {
					for (int i = 0; i < illnessICDlist.size(); i++) {
						/*int serialNo = 0;
						if (serialnolist1.get(i) != null) {
							serialNo = serialnolist1.get(i);
						}
						if (serialNo > 0) {*///------Commented by dipali(18-june-2012)
						
						if(illnessICDlist.get(i) != null && !illnessICDlist.get(i).equals("")){
							MasMedicalExaminationDetail masmedical1 = new MasMedicalExaminationDetail();
							if (serialnolist1.get(i) != null && !serialnolist1.get(i).equals("")) {
								masmedical1.setSerialNo1(serialnolist1.get(i));
							}
							if (illnesslist.get(i) != null && !illnesslist.get(i).equals("")) {
								masmedical1.setIllness(illnesslist.get(i));
							}
							
							if(illnessICDlist.get(i)>0){ 
								MasIcd masIcd=new MasIcd(); 
								masIcd.setId(illnessICDlist.get(i));
								masmedical1.setMasIcd(masIcd); 
							}
							 
							/*if (illnessICDlist.get(i) > 0) {
								MasSystemDiagnosis sysDiagnosis = new MasSystemDiagnosis();
								sysDiagnosis.setId(illnessICDlist.get(i));
								masmedical1.setSystemDiagnosis(sysDiagnosis);
							}*/
							if (particulardatelist.get(i) != null && !particulardatelist.get(i).equals("")) {
								masmedical1.setParticulardate(particulardatelist.get(i));
							}
							/*if (rankidlist.get(i) != null) {
								if (rankidlist.get(i) > 0) {
									MasRank masrank = new MasRank();
									masrank.setId(rankidlist.get(i));
									masmedical1.setRankIndividual(masrank);
								}
							}*/
							if (approximatedatelist.get(i) != null
									&& !approximatedatelist.get(i).equals("")) {
								masmedical1
										.setApproximatedate1(approximatedatelist
												.get(i));
							}
							if (approximatedate2list.get(i) != null
									&& !approximatedate2list.get(i) .equals("")) {
								masmedical1
										.setApproximatedate2(approximatedate2list
												.get(i));
							}

							if (placelist1.get(i) != null && !placelist1.get(i).equals("")) {
								masmedical1.setPlace1(placelist1.get(i));
							}
							if (treatedlist.get(i) != null && !treatedlist.get(i).equals("")) {
								masmedical1.setTreated(treatedlist.get(i));
							}
							if (beforeDisabilitylist.get(i) != null && !beforeDisabilitylist.get(i).equals("")) {
								masmedical1
										.setBeforeDisability(beforeDisabilitylist
												.get(i));
							}
							masmedical1.setParticular("particular");
							masmedical1
									.setMasMedicalReport(masMedicalExaminationReportOnEntry);
							hbt.save(masmedical1);
						}
						/*
						 * End of Code Service Dislibility
						 */
					}
				}
				hbt.refresh(masMedicalExaminationReportOnEntry);
				// ----Alcohal and otherFamilyHistory update in patient table(By
				// Dipali)
				String otherFamilyHistory = "";
				String alcohol = "";
				if (mapForDS.get("alcohol") != null && !mapForDS.get("alcohol").equals("")) {
					alcohol = (String) mapForDS.get("alcohol");
				}
				String allergies = "";
				if (mapForDS.get("allergies") != null && !mapForDS.get("allergies").equals("")) {
					allergies = (String) mapForDS.get("allergies");
				}
				Patient patient = (Patient) session.get(Patient.class, hinId);
				patient.setAlcohol(alcohol);
				patient.setPermanentAddress(permanentAddress);
				if (mapForDS.get("otherFamilyHistory") != null && !mapForDS.get("otherFamilyHistory").equals("")) {
					otherFamilyHistory = (String) mapForDS
							.get("otherFamilyHistory");
				}
				patient.setOtherFamilyHistory(otherFamilyHistory);
				patient.setDrugAllergies(allergies);
				hbt.update(patient);

				// ----------------------------------

				Visit visit = (Visit) session.get(Visit.class, visitId);
				if (visit != null) {
					/*
					 * Code By Mukesh Date 03 Feb 2012
					 */
					/*
					 * Priority Color Coding By Mukesh Normal Urgent Very Urgent
					 * New Data 3 2 1 Pending For Result 6 5 6 Rejected By MO 9
					 * 8 7
					 */
					if (visit.getPriority() != null) {
						if (visit.getPriority() == 1) {
							visit.setPriority(4);
						} else if (visit.getPriority() == 2) {
							visit.setPriority(5);
						} else if (visit.getPriority() == 3) {
							visit.setPriority(6);
						}
					}
					// visit.setPriority(1);

					hbt.update(visit);
				}

				successfullyAdded = true;
				medicalWorkNoList = session.createCriteria(
						TransactionSequence.class).add(
						Restrictions.eq("TransactionPrefix", "MED")).list();

				if (successfullyAdded) {
					for (TransactionSequence transactionSequence : medicalWorkNoList) {
						TransactionSequence obj = transactionSequence;
						int id2 = obj.getId();
						int seqNo = obj.getTransactionSequenceNumber();
						TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
								.load(TransactionSequence.class, id2);
						transactionSequenceObj
								.setTransactionSequenceNumber(++seqNo);
						if (currentMonth.equalsIgnoreCase("01")) {
							transactionSequenceObj
									.setTransactionSequenceNumber(1);
							seqNo = 1;
						}
						hbt.update(transactionSequenceObj);
					}
				}
				String[] familyHistoryArray = (String[]) mapForDS
						.get("familyHistoryArray");
				if (mapForDS.get("familyHistoryArray") != null) {
					familyHistoryArray = (String[]) mapForDS
							.get("familyHistoryArray");
				}
				if (familyHistoryArray != null && familyHistoryArray.length > 0) {
					for (int i = 0; i < familyHistoryArray.length; i++) {

						List<MasMedicalExamFamilyHis> existingFamilyHis = new ArrayList<MasMedicalExamFamilyHis>();
						existingFamilyHis = session
								.createCriteria(MasMedicalExamFamilyHis.class)
								.createAlias("Hin", "h")
								.add(Restrictions.eq("h.Id", hinId))
								.createAlias("PatientFamilyHistory", "pfh")
								.add(Restrictions.eq("pfh.Id",Integer.parseInt(""+ familyHistoryArray[i])))
								.list();
						if (existingFamilyHis.size() == 0) {
							MasMedicalExamFamilyHis masExamFamilyHis = new MasMedicalExamFamilyHis();
							Patient patientObj = new Patient();
							patientObj.setId(hinId);
							masExamFamilyHis.setHin(patientObj);
							PatientFamilyHistory familyHistory = new PatientFamilyHistory();
							familyHistory.setId(Integer.parseInt(""
									+ familyHistoryArray[i]));
							masExamFamilyHis
									.setPatientFamilyHistory(familyHistory);
							hbt.save(masExamFamilyHis);
						}
					}
				}
				int medicalExamId=masMedicalExaminationReportOnEntry.getId();
				List<MasMedicalUploadDocument> medUploadDocList = new ArrayList<MasMedicalUploadDocument>();
				medUploadDocList=session.createCriteria(MasMedicalUploadDocument.class)
								//.createAlias("MasMedicalExamReport", "hde").add(Restrictions.eq("hde.Id", medicalExamId))
								.createAlias("Hin", "h").add(Restrictions.eq("h.Id", hinId))
								.add(Restrictions.eq("IdFlag", "n")).add(Restrictions.eq("MedDate", HMSUtil.convertStringTypeDateToDateType(date)))
								.list();
				if (medUploadDocList.size() >0) {
					
					for(MasMedicalUploadDocument medUploadDocument :medUploadDocList){
					//	if(medUploadDocument.getIdFlag() !=null && !medUploadDocument.getIdFlag().equals("n")){
					//MasMedicalUploadDocument medUploadDocument=new MasMedicalUploadDocument();
					medUploadDocument.setIdFlag("y");
					medUploadDocument.setMasMedicalExamReport(masMedicalExaminationReportOnEntry);
					hbt.update(medUploadDocument);
					//	}
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

		}
		map.put("successfullyAdded", successfullyAdded);
		map.put("medExamId", masMedicalExaminationReportOnEntry.getId());
		return map;

	}

	public Boolean saveInvestigationAdd(Map mapForDS) {
		boolean saveinvestigation = false;
		int patientInvestigationHeaderId = 0;
		int dgOrderhdId = 0;
		String orderSeqNo =(String)mapForDS.get("orderSeqNo");
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
		int userId = (Integer) mapForDS.get("userId");
		String lastChangedBy = (String) mapForDS.get("lastChangedBy");
		Date lastChangedDate = (Date) mapForDS.get("lastChangedDate");
		String lastChangedTime = (String) mapForDS.get("lastChangedTime");
		departmentId = 117;
		String deleatedValue = (String) mapForDS.get("deleatedValue");
		String deleatedorderid = (String) mapForDS.get("deleatedorderid");
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
				dgOrderhd.setId(dgOrderhdId);
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
			patientInvestigationHeader.setInvestigationDate(new Date());
			// String time=new Date().getTime();
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			lastChangedTime= (String) utilMap.get("currentTimeWithoutSc");
			patientInvestigationHeader.setInvestigationTime(lastChangedTime);
			patientInvestigationHeader.setClinicalNotes(clinicalNotes1);
			hbt.saveOrUpdate(patientInvestigationHeader);

			dgOrderhd.setOrderDate(new Date());
			// dgOrderhd.setOrderTime(consultationTime);
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
			dgOrderhd.setOrderTime(lastChangedTime);
			dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
			hbt.saveOrUpdate(dgOrderhd);
			int length = 0;
			for (int i = 0; i < chargeCodeIdList.size(); i++) {
				PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
				patientInvestigationDetails
						.setInvestigationHeader(patientInvestigationHeader);
				DgOrderdt dgOrderdt = new DgOrderdt();
				if (patientInvestigationdetailsIdList.size() > 0
						&& length != patientInvestigationdetailsIdList.size()) {
					++length;
					patientInvestigationDetails
							.setId(patientInvestigationdetailsIdList.get(i));
					dgOrderdt.setId(dgOrderdtIdList.get(i));
				}
				MasChargeCode masChargeCode = new MasChargeCode();
				masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
				patientInvestigationDetails.setChargeCode(masChargeCode);
				hbt.saveOrUpdate(patientInvestigationDetails);
				dgOrderdt.setOrderhd(dgOrderhd);
				masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
				dgOrderdt.setChargeCode(masChargeCode);
				dgOrderdt.setCreatedby(userName);
				dgOrderdt.setCreatedon(new Date());
				dgOrderdt.setInvestigationToMH(investigationReferToMHList
						.get(i));
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
				hbt.saveOrUpdate(dgOrderdt);
				saveinvestigation = true;
			}
		}
		return saveinvestigation;
	}

	@Override
	public Boolean updateMedicalBoardMA16(Map<String, Object> mapForDS) {
		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int visitId = (Integer) mapForDS.get("visitId");
		String data = (String) mapForDS.get("data");
		String Labresult = (String) mapForDS.get("Labresult");
		String[] familyHistoryArray = (String[]) mapForDS.get("familyHistoryArray");
		List<Date> giveOnList = (List<Date>) mapForDS.get("giveOnList");
		List<Date> domList = (List<Date>) mapForDS.get("domList");
		List<Date> doeList = (List<Date>) mapForDS.get("doeList");
		List<String> batchNoList = (List<String>) mapForDS.get("batchNoList");
		int hinId = (Integer) mapForDS.get("hinId");
		String permanentAddress = "";
		if (mapForDS.get("permanentAddress") != null && !mapForDS.get("permanentAddress").equals("")) {
			permanentAddress = (String) mapForDS.get("permanentAddress");
		}
		MasMedicalExaminationReportOnEntry masMedicalBoardProceedings = new MasMedicalExaminationReportOnEntry();
		if (mapForDS.get("masMedicalBoardProceedings") != null) {
			masMedicalBoardProceedings = (MasMedicalExaminationReportOnEntry) mapForDS.get("masMedicalBoardProceedings");
		}

		try {
			boolean saveinvestigation = false;
			Session session = (Session) getSession();
			// saveinvestigation=saveInvestigation(mapForDS);
			/*
			 * Code Commented On 02 Apr 2012 By Mukesh
			 */

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
				List<String> principallist = new ArrayList<String>();
				List<Date> origindatelist = new ArrayList<Date>();
				List<Date> medicalcatdatelist = new ArrayList<Date>();
				List<Date> nextcatdatelist = new ArrayList<Date>();
				List<String> beforeDisabilitylist = new ArrayList<String>();
				if (mapForDS.get("beforeDisabilitylist") != null) {
					beforeDisabilitylist = (List) mapForDS
							.get("beforeDisabilitylist");
				}
				int hiddenValue = 1;
				int hdbvalue = 1;
				serviceidlist = (List) mapForDS.get("serviceidlist");
				serialnolist = (List) mapForDS.get("serialnolist");
				fromlist = (List) mapForDS.get("fromlist");
				tolist = (List) mapForDS.get("tolist");
				placelist = (List) mapForDS.get("placelist");
				pnolist = (List) mapForDS.get("pnolist");
				hdbvalue = (Integer) mapForDS.get("hdbvalue");
				hiddenValue = (Integer) mapForDS.get("hiddenValue");
				int medExamId = (Integer) mapForDS.get("medExamId");
				principallist = (List) mapForDS.get("principallist");
				origindatelist = (List) mapForDS.get("origindatelist");
				medicalcatdatelist = (List) mapForDS.get("medicalcatdatelist");
				nextcatdatelist = (List) mapForDS.get("nextcatdatelist");
				List<Date> approximatedatelist = new ArrayList<Date>();
				List<Date> approximatedate2list = new ArrayList<Date>();
				approximatedatelist = (List) mapForDS
						.get("approximatedatelist");
				if (mapForDS.get("approximatedate2list") != null) {
					approximatedate2list = (List) mapForDS
							.get("approximatedate2list");
				}
				if (masMedicalBoardProceedings.getMedicalExamType()
						.equalsIgnoreCase("Medical Board AFMSF 16")) {

					List<MasMedicalExaminationDetail> detailList = session
							.createCriteria(MasMedicalExaminationDetail.class)
							.add(Restrictions.eq("MasMedicalReport.Id",	medExamId)).add(
									Restrictions.eq("Particular", "detail1")).list();
					hbt.deleteAll(detailList);
					List<MasMedicalExaminationDetail> detailList1 = session
							.createCriteria(MasMedicalExaminationDetail.class)
							.add(Restrictions.eq("MasMedicalReport.Id",medExamId))
							.add(Restrictions.eq("Particular", "particular"))
							.list();
					hbt.deleteAll(detailList1);
					/*
					 * Code for Disability Date 01 March 2012
					 */
					List<MasMedicalExaminationDetail> detailListDisability = session
							.createCriteria(MasMedicalExaminationDetail.class)
							.add(Restrictions.eq("MasMedicalReport.Id",medExamId))
							.add(Restrictions.eq("Particular", "detail")).list();
					hbt.deleteAll(detailListDisability);
						List<MasMedicalExaminationDetail> masMedicalExaminationDetailsDisabilityList = new ArrayList<MasMedicalExaminationDetail>();
					if (mapForDS
							.get("masMedicalExaminationDetailsDisabilityList") != null) {
						masMedicalExaminationDetailsDisabilityList = (List) mapForDS
								.get("masMedicalExaminationDetailsDisabilityList");
					}
					
					
					if (masMedicalExaminationDetailsDisabilityList.size() > 0) {
						for (MasMedicalExaminationDetail masMedicalExaminationDetail : masMedicalExaminationDetailsDisabilityList) {
							masMedicalExaminationDetail
									.setMasMedicalReport(masMedicalBoardProceedings);
							session.save(masMedicalExaminationDetail);
						}
					}
					
					
					/*
					 * End of Code for Disability Date 01 March 2012
					 */
					// for (int i = 0; i <hdbvalue; i++) {
					// for (int i = 0; i <serialnolist.size(); i++) { --Commented by dipali
					for (int i = 0; i < fromlist.size(); i++) {
						MasMedicalExaminationDetail masmedical = new MasMedicalExaminationDetail();
						String fromDate = "";
						// --Commented by dipali
						/*
						int serialNo = 0;
						 * if(serialnolist.get(i)!=null){
						 * serialNo=serialnolist.get(i); } if(serialNo >0){
						 */
						// --added by dipali---
					if (fromlist.get(i) != null && !fromlist.get(i).equals("")) {

						if (serialnolist.get(i) != null && !serialnolist.get(i).equals("")) {
							masmedical.setSerialno(serialnolist.get(i));
						}
						
						if (fromlist.get(i) != null
								&& fromlist.get(i) != "") {
							masmedical.setAddressfrom(HMSUtil.convertStringTypeDateToDateType(fromlist
													.get(i)));
						}
						if (tolist.get(i) != null && tolist.get(i) != "") {
							masmedical.setAddressto(HMSUtil
									.convertStringTypeDateToDateType(tolist.get(i)));
						}
						if (placelist.get(i) != null && placelist.get(i) != "") {
							masmedical.setPlace(placelist.get(i));
						}
						if (pnolist.get(i) != null && pnolist.get(i) != "") {
							masmedical.setPno(pnolist.get(i));
						}
						
						masmedical
								.setMasMedicalReport(masMedicalBoardProceedings);
						// masmedical.setServiceid(serviceidlist.get(i));
						masmedical.setParticular("detail1");
						/*
						 * if(principallist.get(i)!=null){
							  masmedical.setPrincipal(principallist.get(i)); }
						 * if(origindatelist.get(i)!=null){
						 * masmedical.setOrigindate(origindatelist.get(i));
						 * } if(medicalcatdatelist.get(i)!=null){
						 * masmedical.
						 * setMedicalcatdate(medicalcatdatelist.get(i)); }
						 * if(nextcatdatelist.get(i)!=null){
						 * masmedical.setNextcatdate
						 * (nextcatdatelist.get(i)); }
						 * if(approximatedatelist.get(i)!=null){
						 * masmedical.setApproximatedate1
						 * (approximatedatelist.get(i)); }
						 * if(approximatedate2list.get(i)!=null){
						 * masmedical.
						 * setApproximatedate2(approximatedate2list.get(i));
						 * } if(beforeDisabilitylist.get(i)!=null){
						 * masmedical
						 * .setBeforeDisability(beforeDisabilitylist
						 * .get(i)); }
						 */

						hbt.save(masmedical);
						hbt.refresh(masmedical);
						hbt.flush();
					}

					}
					List<Integer> serialnoBeforeList = new ArrayList<Integer>();
					List<String> illnessBeforeList = new ArrayList<String>();

					List<Date> particulardateBeforeList = new ArrayList<Date>();
					List<String> treatedBeforeList = new ArrayList<String>();
					List<String> placeBeforeList = new ArrayList<String>();
					List<String> beforeDisabilityBeforeList = new ArrayList<String>();
					List<Integer> illnessICDBeforelist = new ArrayList<Integer>();
					if (mapForDS.get("illnessICDBeforelist") != null) {
						illnessICDBeforelist = (List) mapForDS
								.get("illnessICDBeforelist");
					}
					int hdbBefore = 0;
					hdbBefore = (Integer) mapForDS.get("hdbBefore");
					if (mapForDS.get("serialnoBeforeList") != null
							&& !mapForDS.get("serialnoBeforeList").equals("")) {
						serialnoBeforeList = (List) mapForDS
								.get("serialnoBeforeList");
					}
					if (mapForDS.get("illnessBeforeList") != null
							&& !mapForDS.get("illnessBeforeList").equals("")) {
						illnessBeforeList = (List) mapForDS
								.get("illnessBeforeList");
					}
					if (mapForDS.get("placeBeforeList") != null
							) {
						placeBeforeList = (List) mapForDS
								.get("placeBeforeList");
					}
					if (mapForDS.get("particulardateBeforeList") != null
							&& !mapForDS.get("particulardateBeforeList").equals("")) {
						particulardateBeforeList = (List) mapForDS
								.get("particulardateBeforeList");
					}
					if (mapForDS.get("treatedBeforeList") != null
							&& !mapForDS.get("treatedBeforeList").equals("")) {
						treatedBeforeList = (List) mapForDS
								.get("treatedBeforeList");
					}
					if (mapForDS.get("beforeDisabilityBeforeList") != null
							) {
						beforeDisabilityBeforeList = (List) mapForDS
								.get("beforeDisabilityBeforeList");
					}
					// for (int i = 0; i < hdbBefore; i++) {
					for (int i = 0; i < illnessBeforeList.size(); i++) {
						int serialNo = 0;
						// ---Commented By Dipali--
						/*
						 * if(serialnoBeforeList.get(i)!=null){
						 * serialNo=serialnoBeforeList.get(i); }
						 */
						try {
							// ---Commented By Dipali--
							// if(serialNo>0){
							if (illnessBeforeList.get(i) != null
									&& !illnessBeforeList.get(i).equals("")) {
								MasMedicalExaminationDetail masmedical2 = new MasMedicalExaminationDetail();
								if (serialnoBeforeList.get(i) != null&& !serialnoBeforeList.get(i).equals("")) {
									masmedical2.setSerialno(serialnoBeforeList.get(i));
								}
								if (illnessBeforeList.get(i) != null && !illnessBeforeList.get(i).equals("")) {
									masmedical2.setIllness(illnessBeforeList.get(i));
								}
								if (placeBeforeList.get(i) != null && !placeBeforeList.get(i).equals("")) {
									masmedical2.setPlace(placeBeforeList.get(i));
								}
								if (beforeDisabilityBeforeList.get(i) != null && !beforeDisabilityBeforeList.get(i).equals("")){
									masmedical2.setBeforeDisability(beforeDisabilityBeforeList.get(i));
								}
								if (particulardateBeforeList.get(i) != null && !particulardateBeforeList.get(i).equals("")) {
									masmedical2.setParticulardate(particulardateBeforeList.get(i));
								}
								if (treatedBeforeList.get(i) != null && !treatedBeforeList.get(i).equals("")) {
									masmedical2.setTreated(treatedBeforeList.get(i));
								}
								
								 if(illnessICDBeforelist.get(i)>0){ 
									 MasIcd masIcd=new MasIcd();
									 masIcd.setId(illnessICDBeforelist.get(i));
									 masmedical2.setMasIcd(masIcd); 
								}
								 
								/*if (illnessICDBeforelist.get(i) > 0) {
									MasSystemDiagnosis sysDiagnosis = new MasSystemDiagnosis();
									sysDiagnosis.setId(illnessICDBeforelist.get(i));
									masmedical2.setSystemDiagnosis(sysDiagnosis);
								}*/
								masmedical2.setParticular("particular");
								masmedical2.setMasMedicalReport(masMedicalBoardProceedings);
								session.save(masmedical2);
								// hbt1.refresh(masmedical2);
								// hbt1.flush();
							}
						} catch (Exception e) {

							e.printStackTrace();
						}
					}

				}
				if (masMedicalBoardProceedings.getMedicalExamType()
						.equalsIgnoreCase("Medical Board AFMSF 16")) {
					int hiddenValue1 = 1;
					int hdbvalue1 = 1;
					List<String> illnesslist = new ArrayList<String>();
					List<Date> particulardatelist = new ArrayList<Date>();
					List<Integer> rankidlist = new ArrayList<Integer>();
					List<String> treatedlist = new ArrayList<String>();
					List<Integer> serialnolist1 = new ArrayList<Integer>();
					List<String> placelist1 = new ArrayList<String>();
					List<Integer> illnessICDlist = new ArrayList<Integer>();

					if (mapForDS.get("illnessICDlist") != null) {
						illnessICDlist = (List) mapForDS.get("illnessICDlist");
					}
					serialnolist1 = (List) mapForDS.get("serialnolist1");
					illnesslist = (List) mapForDS.get("illnesslist");
					particulardatelist = (List) mapForDS
							.get("particulardatelist");
					rankidlist = (List) mapForDS.get("rankidlist");
					treatedlist = (List) mapForDS.get("treatedlist");
					approximatedatelist = (List) mapForDS
							.get("approximatedatelist");
					if (mapForDS.get("approximatedate2list") != null) {
						approximatedate2list = (List) mapForDS
								.get("approximatedate2list");
					}
					hiddenValue1 = (Integer) mapForDS.get("hiddenValue1");
					hdbvalue1 = (Integer) mapForDS.get("hdbvalue1");
					placelist1 = (List) mapForDS.get("placelist1");

					for (int i = 0; i < illnesslist.size(); i++) {
						MasMedicalExaminationDetail masmedical1 = new MasMedicalExaminationDetail();
						// ---Commented by dipali---
						/*
						 * int serialNo=0; if(serialnolist1.get(i)!=null){
						 * serialNo=serialnolist1.get(i); }
						 */
						// if(serialNo>0){
						if (illnesslist.get(i) != null
								&& !illnesslist.get(i).equals("")) {
							if (serialnolist1.get(i) != null && !serialnolist1.get(i).equals(""))
								masmedical1.setSerialNo1(serialnolist1.get(i));
							if (illnesslist.get(i) != null  && !illnesslist.get(i).equals(""))
								masmedical1.setIllness(illnesslist.get(i));
							if (rankidlist.get(i) != null && !rankidlist.get(i).equals("")) {
								if (rankidlist.get(i) > 0) {
									MasRank masrank = new MasRank();
									masrank.setId(rankidlist.get(i));
									masmedical1.setRankIndividual(masrank);
								}
							}
							
							 if(illnessICDlist.get(i)>0){ 
								 MasIcd masIcd=new MasIcd();
								 masIcd.setId(illnessICDlist.get(i));
								 masmedical1.setMasIcd(masIcd); 
							 }
							 
						/*	if (illnessICDlist.get(i) > 0) {
								MasSystemDiagnosis sysDiagnosis = new MasSystemDiagnosis();
								sysDiagnosis.setId(illnessICDlist.get(i));
								masmedical1.setSystemDiagnosis(sysDiagnosis);
							}*/
							if (particulardatelist.get(i) != null && !particulardatelist.get(i).equals("")) {
								masmedical1
										.setParticulardate(particulardatelist
												.get(i));
							}
							if (approximatedatelist.get(i) != null && !approximatedatelist.get(i).equals("")) {
								masmedical1
										.setApproximatedate1(approximatedatelist
												.get(i));
							}
							if (approximatedate2list.get(i) != null && !approximatedate2list.get(i).equals("")) {
								masmedical1
										.setApproximatedate2(approximatedate2list
												.get(i));
							}

							if (placelist1.get(i) != null && !placelist1.get(i).equals("")) {
								masmedical1.setPlace1(placelist1.get(i));
							}
							if (treatedlist.get(i) != null && !treatedlist.get(i).equals("")) {
								masmedical1.setTreated(treatedlist.get(i));
							}
							if (beforeDisabilitylist.get(i) != null && !beforeDisabilitylist.get(i).equals("")) {
								masmedical1.setBeforeDisability(beforeDisabilitylist
												.get(i));
							}
							masmedical1.setParticular("particular");
							masmedical1
									.setMasMedicalReport(masMedicalBoardProceedings);
							// if(beforeDisabilitylist.get(i)!=null){
							/*
							 * Before Disability = n means after service Before
							 * Disability = y means before service
							 */
							masmedical1.setBeforeDisability("n");
							// }
							hbt.save(masmedical1);
							hbt.refresh(masmedical1);
							hbt.flush();
						}
					}

				}
				if (Labresult.equalsIgnoreCase("present") && data != null) {
					Visit visit = (Visit) hbt.load(Visit.class, visitId);
					visit.setMedStatus("f");
					hbt.update(visit);
				}
				successfullyAdded = true;
			}
			if (masMedicalBoardProceedings != null) {
				List<MasMedicalExamReportDt> masMedicalExamReportDtList = session
						.createCriteria(MasMedicalExamReportDt.class).add(
								Restrictions.eq("MasMedicalExamReport.Id",
										masMedicalBoardProceedings.getId()))
						.list();
				for (MasMedicalExamReportDt masMedicalExamReportDt : masMedicalExamReportDtList) {
					hbt.delete(masMedicalExamReportDt);
				}

			}
			List<MasMedicalExamFamilyHis> masMedicalExamFamilyHisList = session
					.createCriteria(MasMedicalExamFamilyHis.class).add(
							Restrictions.eq("MasMedicalExamReport.Id",
									masMedicalBoardProceedings.getId())).list();
			if (masMedicalExamFamilyHisList.size() > 0) {
				for (MasMedicalExamFamilyHis masExamFamilyHis : masMedicalExamFamilyHisList) {
					hbt.delete(masExamFamilyHis);
				}
			}
			// ----Alcohal update in patient table(By Dipali)
			String alcohol = "";
			String otherFamilyHistory = "";
			if (mapForDS.get("alcohol") != null && !mapForDS.get("alcohol").equals("")) {
				alcohol = (String) mapForDS.get("alcohol");
				Patient patient = (Patient) session.get(Patient.class, hinId);
				if (mapForDS.get("otherFamilyHistory") != null && !mapForDS.get("otherFamilyHistory").equals("")) {
					otherFamilyHistory = (String) mapForDS
							.get("otherFamilyHistory");
				}
				patient.setPermanentAddress(permanentAddress);
				patient.setOtherFamilyHistory(otherFamilyHistory);
				patient.setAlcohol(alcohol);
				hbt.update(patient);
			}
			// ------------
			if (mapForDS.get("familyHistoryArray") != null) {
				familyHistoryArray = (String[]) mapForDS
						.get("familyHistoryArray");
			}
			if (familyHistoryArray != null && familyHistoryArray.length > 0) {
				for (int i = 0; i < familyHistoryArray.length; i++) {

					List<MasMedicalExamFamilyHis> existingFamilyHis = new ArrayList<MasMedicalExamFamilyHis>();
					existingFamilyHis = session.createCriteria(
							MasMedicalExamFamilyHis.class).createAlias("Hin",
							"h").add(Restrictions.eq("h.Id", hinId))
							.createAlias("PatientFamilyHistory", "pfh").add(
									Restrictions.eq("pfh.Id", Integer
											.parseInt(""
													+ familyHistoryArray[i])))
							.list();
					if (existingFamilyHis.size() == 0) {
						MasMedicalExamFamilyHis masExamFamilyHis = new MasMedicalExamFamilyHis();
						Patient patientObj = new Patient();
						patientObj.setId(hinId);
						masExamFamilyHis.setHin(patientObj);
						PatientFamilyHistory familyHistory = new PatientFamilyHistory();
						familyHistory.setId(Integer.parseInt(""
								+ familyHistoryArray[i]));
						masExamFamilyHis.setPatientFamilyHistory(familyHistory);
						hbt.save(masExamFamilyHis);
					}
				}
			}
			/*
			 * if(familyHistoryArray!=null) { for(String
			 * familyHistoryId:familyHistoryArray) { int
			 * familyHisId=Integer.parseInt(familyHistoryId);
			 * MasMedicalExamFamilyHis masMedicalExamFamilyHis=new
			 * MasMedicalExamFamilyHis(); PatientFamilyHistory
			 * patientFamilyHistory=new PatientFamilyHistory();
			 * patientFamilyHistory.setId(familyHisId);
			 * masMedicalExamFamilyHis.setPatientFamilyHistory
			 * (patientFamilyHistory);
			 * masMedicalExamFamilyHis.setMasMedicalExamReport
			 * (masMedicalBoardProceedings); hbt.save(masMedicalExamFamilyHis);
			 * } }
			 */
		} catch (Exception e) {

			e.printStackTrace();
			e.getMessage();
			e.getCause();
		}
		return successfullyAdded;
	}

	public Boolean saveInvestigationResult(Map mapForDS) {
		boolean saveinvestigation = false;
		int patientInvestigationHeaderId = 0;
		int dgOrderhdId = 0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<String> chargeCodeIdList = (List) mapForDS.get("chargeCodeIdList");
		List<String> investigationReferToMHList = (List) mapForDS
				.get("investigationReferToMHList");
		List<String> investResultList = (List) mapForDS.get("investResultList");
		String data = (String) mapForDS.get("data");
		
		Session session = (Session) getSession();
		int masExamId = (Integer) mapForDS.get("medExamId");
		//System.out.println("medExamId="+masExamId);
		//System.out.println("chargeCodeIdList="+chargeCodeIdList.size());
		//System.out.println("Result="+investResultList.get(0));
		//System.out.println("Result="+investResultList.get(0));
		//masMedicalExamInvestResult.setReferToMH(investigationReferToMHList.get(0));
		
		
		// if (data != null) { // commented by vinay
		if (true) {
			List<MasMedicalExamInvestResult> masMedicalExamInvestResultList = session
					.createCriteria(MasMedicalExamInvestResult.class).add(
							Restrictions.eq(
									"MasMedicalExaminationReportOnEntry.Id",
									masExamId)).list();
			if (masMedicalExamInvestResultList.size() > 0) {
				for (MasMedicalExamInvestResult masMedicalExam : masMedicalExamInvestResultList) {
					session.delete(masMedicalExam);
				}
			}
			if (chargeCodeIdList.size() > 0) {
				for (int i = 0; i < chargeCodeIdList.size(); i++) {
					//System.out.println("in side for loop");
					MasMedicalExamInvestResult masMedicalExamInvestResult = new MasMedicalExamInvestResult();
					masMedicalExamInvestResult.setReferToMH(investigationReferToMHList.get(i));
				//	System.out.println("Result="+investResultList.get(i));
					masMedicalExamInvestResult.setResult(investResultList.get(i));
					DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
					dgMasInvestigation.setId(Integer.parseInt(chargeCodeIdList
							.get(i)));
					masMedicalExamInvestResult
							.setDgMasInvestigation(dgMasInvestigation);
					MasMedicalExaminationReportOnEntry masMedicalExamReportEntry = new MasMedicalExaminationReportOnEntry();
					masMedicalExamReportEntry.setId(masExamId);
					masMedicalExamInvestResult
							.setMasMedicalExaminationReportOnEntry(masMedicalExamReportEntry);
					hbt.saveOrUpdate(masMedicalExamInvestResult);
					//saveinvestigation = true;

				}
				saveinvestigation = true;
			}
		}

		return saveinvestigation;
	}

	@Override
	public Map<String, Object> showMBCommandingOfficerJsp(Map<String, Object> mapForDS) {
		List<Visit> visit = null;
	//	List<MasServiceType> serviceTypeList = null;
		///List<MasState> stateList = null;
		//List<MasMaritalStatus> maritalStatusList = null;

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int visitId = (Integer) mapForDS.get("visitId");
		int deptId = (Integer) mapForDS.get("deptId");
		int empId = 0;
		if (mapForDS.get("empId") != null) {
			empId = (Integer) mapForDS.get("empId");
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		visit = session.createCriteria(Visit.class)
		.add(Restrictions.eq("Id", visitId)).list();
			///hbt.find("from Visit as v where v.Id='" + visitId + "'");
		/*List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		templateList = session.createCriteria(OpdTemplate.class).createAlias(
				"Department", "dept").add(Restrictions.eq("dept.Id", deptId))
				.add(Restrictions.eq("Status", "y")).list();
		serviceTypeList =session.createCriteria(MasServiceType.class)
		.add(Restrictions.eq("Status", "y")).list(); 
			//hbt
			//.find("from MasServiceType mst where mst.Status='y'");
		stateList = session.createCriteria(MasState.class)
		.add(Restrictions.eq("Status", "y")).list(); 
			//hbt.find("from MasState ms where ms.Status='y'");
		maritalStatusList = session.createCriteria(MasMaritalStatus.class)
		.add(Restrictions.eq("Status", "y")).list();
			//hbt
				//.find("from MasMaritalStatus mms where mms.Status='y'");
		List<MasRank> masRankList1 = new ArrayList<MasRank>();
		masRankList1 = session.createCriteria(MasRank .class)
		//.add(Restrictions.eq("Status", "y"))
		.list();
			//getHibernateTemplate().find(
				//"from jkt.hms.masters.business.MasRank ");
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		employeeList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).list();
		if (employeeList.size() > 0) {
			map.put("employeeList", employeeList);
		}*/
		List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
		employeeMoList = session.createCriteria(MasEmployee.class).add(
				Restrictions.idEq(empId)).list();
		map.put("employeeMoList", employeeMoList);
		/*List<Disability> disabilityList = new ArrayList<Disability>();
		disabilityList =session.createCriteria(Disability.class).list() ;*/
			//getHibernateTemplate().find(
				//"from jkt.hms.masters.business.Disability ");
		List<Category> categoryList = new ArrayList<Category>();
		categoryList =session.createCriteria(Category.class).list() ;
			//getHibernateTemplate().find(
			//	"from jkt.hms.masters.business.Category ");
		int medExamId = (Integer) mapForDS.get("medExamId");
		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		//List<MasMedicalExaminationDetail> masMedicalExaminationIllList = new ArrayList<MasMedicalExaminationDetail>();
		if (medExamId != 0) {
			medExamList = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).add(
					Restrictions.eq("Status", "md").ignoreCase()).list();
			/*masMedicalExaminationIllList = session.createCriteria(
					MasMedicalExaminationDetail.class).createAlias(
					"MasMedicalReport", "medReport").add(
					Restrictions.eq("medReport.Id", medExamId)).add(
					Restrictions.eq("Particular", "particular")).list();*/
		} else {
			medExamList = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.eq("Visit.Id", visitId)).add(
					Restrictions.eq("Status", "f").ignoreCase()).list();
			/*masMedicalExaminationIllList = session.createCriteria(
					MasMedicalExaminationDetail.class).createAlias(
					"MasMedicalReport", "medReport").add(
					Restrictions.eq("medReport.Id", medExamId)).add(
					Restrictions.eq("Particular", "particular")).list();*/
		}
		Visit visitdata = null;
		/*List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();*/

		if (visit != null && visit.size() > 0) {
			visitdata = visit.get(0);
		}
		/*patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
				.createCriteria(PatientInvestigationHeader.class).createAlias(
						"Visit", "v").add(Restrictions.eq("v.Id", visitId))
				.createAlias("Hin", "p").add(
						Restrictions.eq("p.Id", visitdata.getHin().getId()))
				.addOrder(Order.desc("Id")).list();
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
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		resultList = session.createCriteria(DgResultEntryHeader.class)
				.createAlias("SampleCollectionHeader", "smColl").createAlias(
						"smColl.Order", "order").createAlias("order.Visit",
						"vst").add(Restrictions.eq("vst.Id", visitId)).add(
						Restrictions.eq("ResultStatus", "A")).list();
		if (resultList != null || resultList.size() > 0) {
			map.put("resultList", resultList);
		}
		List<MasIcd> masIcdList = new ArrayList<MasIcd>();
		masIcdList = session.createCriteria(MasIcd.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("IcdName")).list();*/
			//getHibernateTemplate()
			//.find(
			//"from jkt.hms.masters.business.MasIcd as mi where mi.Status='y' order by mi.IcdName asc");
		/*List<Disabilitygroup> disabilitygroupList = new ArrayList<Disabilitygroup>();
		disabilitygroupList = session.createCriteria(Disabilitygroup.class).list(); 
			//getHibernateTemplate().find(
				//"from jkt.hms.masters.business.Disabilitygroup");
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		masUnitList = session.createCriteria(MasUnit.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("UnitName")).list();*/
			//getHibernateTemplate()
				//.find(
			//"from jkt.hms.masters.business.MasUnit as mu where mu.Status='y' order by mu.UnitName asc");

		List<MasSystemDiagnosis> masSystemDiagnosisList = new ArrayList<MasSystemDiagnosis>();
		masSystemDiagnosisList = session.createCriteria(MasSystemDiagnosis.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("SystemDiagnosisName")).list();
			//getHibernateTemplate()
//.find("from jkt.hms.masters.business.MasSystemDiagnosis as msd where msd.Status='y' order by msd.SystemDiagnosisName asc");
		List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
		masMedicalExaminationDetailList = session.createCriteria(MasMedicalExaminationDetail.class)
		.createAlias("MasMedicalReport", "medReport").add(Restrictions.eq("medReport.Id", medExamId)).list();
		
		map.put("masMedicalExaminationDetailList",masMedicalExaminationDetailList);
		map.put("medExamList", medExamList);
		map.put("masSystemDiagnosisList", masSystemDiagnosisList);
		map.put("visit", visit);
	/*	map.put("masMedicalExaminationIllList", masMedicalExaminationIllList);
		map.put("masRankList1", masRankList1);
		map.put("templateList", templateList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("stateList", stateList);
		map.put("maritalStatusList", maritalStatusList);
		map.put("disabilityList", disabilityList);
		map.put("categoryList", categoryList);
		map.put("masIcdList", masIcdList);
		map.put("disabilitygroupList", disabilitygroupList);
		map.put("masUnitList", masUnitList);*/
		return map;

	}

	@Override
	public Map<String, Object> validateMBCommandingOfficer(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = 0;
		int visitId = 0;
		int medExamId = 0;
		if (mapForDS.get("visitId") != null) {
			visitId = (Integer) mapForDS.get("visitId");
		}
		if (mapForDS.get("medExamId") != null) {
			medExamId = (Integer) mapForDS.get("medExamId");
		}
		int deptId = 0;
		if (mapForDS.get("deptId") != null) {
			deptId = (Integer) mapForDS.get("deptId");
		}
		MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry = new MasMedicalExaminationReportOnEntry();
		if (mapForDS.get("masMedicalBoardProceedings") != null) {
			masMedicalExaminationReportOnEntry = (MasMedicalExaminationReportOnEntry) mapForDS
					.get("masMedicalBoardProceedings");
		}
		List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = (List<MasMedicalExaminationDetail>) mapForDS
				.get("masMedicalExaminationDetailList");
		HibernateTemplate hbt = null;
		Transaction tx = null;
		Session session = (Session) getSession();
		boolean falg = false;
		try {
			tx = session.beginTransaction();
			hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masMedicalExaminationReportOnEntry);

			List<MasMedicalExaminationDetail> masMedicalExamDetailList = session
					.createCriteria(MasMedicalExaminationDetail.class).add(
							Restrictions.eq("MasMedicalReport.Id", medExamId))
					.add(Restrictions.eq("Particular", "DisabilityDetails"))
					.list();
			if (masMedicalExamDetailList.size() > 0) {
				for (MasMedicalExaminationDetail masMedicalExaminationDetail : masMedicalExamDetailList) {
					hbt.delete(masMedicalExaminationDetail);
				}
			}
			if (masMedicalExaminationDetailList.size() > 0) {
				for (MasMedicalExaminationDetail masMedicalExaminationDetail : masMedicalExaminationDetailList) {
					hbt.save(masMedicalExaminationDetail);
				}
			}
			falg = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			falg = false;
			e.printStackTrace();
		}
		map.put("falg", falg);
		return map;
	}

	@Override
	public Map<String, Object> showMedicalBoardOpinionWaitList(int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> medicalBoardOpinionList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).list();
		String[] statusArr = { "cd", "mr" };
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.in("Status", statusArr)).add(
						Restrictions.eq("medicalType", "MedicalBoard"))
				.createAlias("Hospital", "h").add(
						Restrictions.eq("h.Id", hospitalId)).addOrder(
						Order.desc("Id"));

		medicalBoardOpinionList = crit.list();
		map.put("medicalBoardOpinionList", medicalBoardOpinionList);
		map.put("rankList", rankList);
		return map;
	}

	@Override
	public Map showMedicalBoardForm16(Map<String, Object> mapForDS) {
		List<Visit> visit = null;
		// List<MasServiceType> serviceTypeList = null;
		// List<MasState> stateList = null;
		// List<MasMaritalStatus> maritalStatusList = null;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int visitId = (Integer) mapForDS.get("visitId");
		int deptId = (Integer) mapForDS.get("deptId");
		int empId = 0;
		if (mapForDS.get("empId") != null) {
			empId = (Integer) mapForDS.get("empId");
		}
		int hospitalId = 0;
		if (mapForDS.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDS.get("hospitalId");
		}
		List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
		employeeMoList = session.createCriteria(MasEmployee.class).add(
				Restrictions.idEq(empId)).list();
		map.put("employeeMoList", employeeMoList);

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		//visit = hbt.find("from Visit as v where v.Id='" + visitId + "'");
		visit= session.createCriteria(Visit.class)
		.add(Restrictions.eq("Id",visitId)).list();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		templateList = session.createCriteria(OpdTemplate.class).createAlias(
				"Department", "dept").add(Restrictions.eq("dept.Id", deptId))
				.add(Restrictions.eq("Status", "y")).list();
		/*
		 * serviceTypeList =
		 * hbt.find("from MasServiceType mst where mst.Status='y'"); stateList =
		 * hbt.find("from MasState ms where ms.Status='y'"); maritalStatusList =
		 * hbt.find("from MasMaritalStatus mms where mms.Status='y'");
		 */
		List<MasRank> masRankList = new ArrayList<MasRank>();
		masRankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).list();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		/*employeeList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).list();*/
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		employeeList = session.createCriteria(MasEmployee.class).add(
		Restrictions.eq("Status", "y")).createAlias("Hospital", "h")
		.createAlias("EmpCategory", "ec").add(Restrictions.eq("h.Id", hospitalId)).add(
				Restrictions.eq("ec.EmpCategoryCode",
						empCategoryCodeForDoctor)).addOrder(
				Order.asc("FirstName")).list();
		if (employeeList.size() > 0) {
			map.put("employeeList", employeeList);
		}
		/*
		 * List<Disability> disabilityList = new ArrayList<Disability>();
		 * disabilityList =
		 * getHibernateTemplate().find("from jkt.hms.masters.business.Disability "
		 * );
		 */
		List<Category> categoryList = new ArrayList<Category>();
		categoryList =session.createCriteria(Category.class).list(); 
			//getHibernateTemplate().find(
			//	"from jkt.hms.masters.business.Category ");
		int medExamId = (Integer) mapForDS.get("medExamId");
		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		if (medExamId != 0) {
			medExamList = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).add(
					Restrictions.eq("Status", "cd").ignoreCase()).list();
		} else {
			medExamList = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.eq("Visit.Id", visitId)).add(
					Restrictions.eq("Status", "p").ignoreCase()).list();
		}
		List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
		masMedicalExaminationDetailList = session.createCriteria(
				MasMedicalExaminationDetail.class).createAlias(
				"MasMedicalReport", "medReport").add(
				Restrictions.eq("medReport.Id", medExamId)).list();
		map.put("masMedicalExaminationDetailList",
				masMedicalExaminationDetailList);
		Visit visitdata = null;
		List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();

		if (visit != null && visit.size() > 0) {
			visitdata = visit.get(0);
		}
		patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
				.createCriteria(PatientInvestigationHeader.class).createAlias(
						"Visit", "v").add(Restrictions.eq("v.Id", visitId))
				.createAlias("Hin", "p").add(
						Restrictions.eq("p.Id", visitdata.getHin().getId()))
				.addOrder(Order.desc("Id")).list();

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
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		resultList = session.createCriteria(DgResultEntryHeader.class)
				.createAlias("SampleCollectionHeader", "smColl").createAlias(
						"smColl.Order", "order").createAlias("order.Visit",
						"vst").add(Restrictions.eq("vst.Id", visitId)).add(
						Restrictions.eq("ResultStatus", "A")).list();
		if (resultList != null || resultList.size() > 0) {
			map.put("resultList", resultList);
		}
		List<MasIcd> masIcdList = new ArrayList<MasIcd>();
		masIcdList = session.createCriteria(MasIcd.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("IcdName")).list(); 
			//getHibernateTemplate()
			//.find(
		//"from jkt.hms.masters.business.MasIcd as mi where mi.Status='y' order by mi.IcdName asc");
		/*
		 * List<Disabilitygroup> disabilitygroupList = new
		 * ArrayList<Disabilitygroup>(); disabilitygroupList =
		 * getHibernateTemplate
		 * ().find("from jkt.hms.masters.business.Disabilitygroup");
		 */
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		masUnitList = session.createCriteria(MasUnit.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("UnitName")).list(); 
			//getHibernateTemplate()
			//.find(
		//	"from jkt.hms.masters.business.MasUnit as mu where mu.Status='y' order by mu.UnitName asc");
		/*
		 * List<MasSystemDiagnosis> masSystemDiagnosisList = new
		 * ArrayList<MasSystemDiagnosis>(); masSystemDiagnosisList =
		 * getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.MasSystemDiagnosis as msd where msd.Status='y' order by msd.SystemDiagnosisName asc"
		 * ); map.put("masSystemDiagnosisList", masSystemDiagnosisList);
		 */
		map.put("medExamList", medExamList);
		map.put("masRankList", masRankList);
		map.put("templateList", templateList);
		/*
		 * map.put("serviceTypeList", serviceTypeList); map.put("stateList",
		 * stateList); map.put("maritalStatusList", maritalStatusList);
		 * map.put("disabilityList", disabilityList);
		 * map.put("disabilitygroupList", disabilitygroupList);
		 */
		map.put("visit", visit);
		map.put("categoryList", categoryList);
		map.put("masIcdList", masIcdList);
		map.put("masUnitList", masUnitList);
		return map;
	}

	@Override
	public Boolean updateMedicalBoardMO16(Map<String, Object> mapForDS) {
		boolean successfullyAdded = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int visitId = (Integer) mapForDS.get("visitId");
		String data = (String) mapForDS.get("data");
		String Labresult = (String) mapForDS.get("Labresult");
		String[] familyHistoryArray = (String[]) mapForDS
				.get("familyHistoryArray");
		List<Date> giveOnList = (List<Date>) mapForDS.get("giveOnList");
		List<Date> domList = (List<Date>) mapForDS.get("domList");
		List<Date> doeList = (List<Date>) mapForDS.get("doeList");
		List<String> batchNoList = (List<String>) mapForDS.get("batchNoList");
		int hinId = (Integer) mapForDS.get("hinId");
		MasMedicalExaminationReportOnEntry masMedicalBoardProceedings = new MasMedicalExaminationReportOnEntry();
		if (mapForDS.get("masMedicalBoardProceedings") != null) {
			masMedicalBoardProceedings = (MasMedicalExaminationReportOnEntry) mapForDS
					.get("masMedicalBoardProceedings");
		}

		try {
			boolean saveinvestigation = false;
			Session session = (Session) getSession();
			// saveinvestigation=saveInvestigation(mapForDS);
			// saveinvestigation=saveInvestigationAdd(mapForDS);
			/*
			 * Code Commented On 02 Apr 2012 By Mukesh
			 */
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
				List<String> principallist = new ArrayList<String>();
				List<Date> origindatelist = new ArrayList<Date>();
				List<Date> medicalcatdatelist = new ArrayList<Date>();
				List<Date> nextcatdatelist = new ArrayList<Date>();
				List<String> beforeDisabilitylist = new ArrayList<String>();
				if (mapForDS.get("beforeDisabilitylist") != null) {
					beforeDisabilitylist = (List) mapForDS
							.get("beforeDisabilitylist");
				}
				int hiddenValue = 1;
				int hdbvalue = 1;
				serviceidlist = (List) mapForDS.get("serviceidlist");
				serialnolist = (List) mapForDS.get("serialnolist");
				fromlist = (List) mapForDS.get("fromlist");
				tolist = (List) mapForDS.get("tolist");
				placelist = (List) mapForDS.get("placelist");
				pnolist = (List) mapForDS.get("pnolist");
				hdbvalue = (Integer) mapForDS.get("hdbvalue");
				hiddenValue = (Integer) mapForDS.get("hiddenValue");
				int medExamId = (Integer) mapForDS.get("medExamId");
				principallist = (List) mapForDS.get("principallist");
				origindatelist = (List) mapForDS.get("origindatelist");
				medicalcatdatelist = (List) mapForDS.get("medicalcatdatelist");
				nextcatdatelist = (List) mapForDS.get("nextcatdatelist");
				List<Date> approximatedatelist = new ArrayList<Date>();
				List<Date> approximatedate2list = new ArrayList<Date>();
				approximatedatelist = (List) mapForDS
						.get("approximatedatelist");
				if (mapForDS.get("approximatedate2list") != null) {
					approximatedate2list = (List) mapForDS
							.get("approximatedate2list");
				}
				List<Integer> illnessICDlist = new ArrayList<Integer>();
				List<Integer> illnessICDBeforelist = new ArrayList<Integer>();
				if (mapForDS.get("illnessICDlist") != null) {
					illnessICDlist = (List) mapForDS.get("illnessICDlist");
				}
				if (mapForDS.get("illnessICDBeforelist") != null) {
					illnessICDBeforelist = (List) mapForDS
							.get("illnessICDBeforelist");
				}
				if (masMedicalBoardProceedings.getMedicalExamType()
						.equalsIgnoreCase("Medical Board AFMSF 16")) {
					List<MasMedicalExaminationDetail> detailList = session
							.createCriteria(MasMedicalExaminationDetail.class)
							.add(
									Restrictions.eq("MasMedicalReport.Id",
											medExamId)).add(
									Restrictions.eq("Particular", "detail1"))
							.list();
					hbt.deleteAll(detailList);
					List<MasMedicalExaminationDetail> detailList1 = session
							.createCriteria(MasMedicalExaminationDetail.class)
							.add(
									Restrictions.eq("MasMedicalReport.Id",
											medExamId))
							.add(Restrictions.eq("Particular", "particular"))
							.list();
					hbt.deleteAll(detailList1);
					/*
					 * Code for Disability Date 01 March 2012
					 */
					List<MasMedicalExaminationDetail> detailListDisability = session
							.createCriteria(MasMedicalExaminationDetail.class)
							.add(
									Restrictions.eq("MasMedicalReport.Id",
											medExamId))
							.add(Restrictions.eq("Particular", "detail"))
							.list();
					hbt.deleteAll(detailListDisability);
					List<MasMedicalExaminationDetail> masMedicalExaminationDetailsDisabilityList = new ArrayList<MasMedicalExaminationDetail>();
					if (mapForDS
							.get("masMedicalExaminationDetailsDisabilityList") != null) {
						masMedicalExaminationDetailsDisabilityList = (List) mapForDS
								.get("masMedicalExaminationDetailsDisabilityList");
					}
					if (masMedicalExaminationDetailsDisabilityList.size() > 0) {
						for (MasMedicalExaminationDetail masMedicalExaminationDetail : masMedicalExaminationDetailsDisabilityList) {
							masMedicalExaminationDetail
									.setMasMedicalReport(masMedicalBoardProceedings);
							session.save(masMedicalExaminationDetail);
						}
					}
					/*
					 * End of Code for Disability Date 01 March 2012
					 */
					// for (int i = 0; i <hdbvalue; i++) {
					for (int i = 0; i < serialnolist.size(); i++) {
						MasMedicalExaminationDetail masmedical = new MasMedicalExaminationDetail();
						/*int serialNo = 0;
						if (serialnolist.get(i) != null) {
							serialNo = serialnolist.get(i);
						}
						if (serialNo > 0) {*///--commented by dipali
						if (fromlist.get(i) != null
								&& fromlist.get(i) != "") {//---Addeb by diplai
							if (serialnolist.get(i) != null) {
								masmedical.setSerialno(serialnolist.get(i));
							}
							if (fromlist.get(i) != null
									&& fromlist.get(i) != "") {
								masmedical.setAddressfrom(HMSUtil
										.convertStringTypeDateToDateType(fromlist.get(i)));
							}
							if (tolist.get(i) != null && tolist.get(i) != "") {
								masmedical.setAddressto(HMSUtil
										.convertStringTypeDateToDateType(tolist.get(i)));
							}
							if (placelist.get(i) != null) {
								masmedical.setPlace(placelist.get(i));
							}
							if (pnolist.get(i) != null) {
								masmedical.setPno(pnolist.get(i));
							}
							
							masmedical
									.setMasMedicalReport(masMedicalBoardProceedings);
							// masmedical.setServiceid(serviceidlist.get(i));
							masmedical.setParticular("detail1");
							/*
							 * if(principallist.get(i)!=null){
								masmedical.setPrincipal(principallist.get(i)); }
							 * if(origindatelist.get(i)!=null){
							 * masmedical.setOrigindate(origindatelist.get(i));
							 * } if(medicalcatdatelist.get(i)!=null){
							 * masmedical.
							 * setMedicalcatdate(medicalcatdatelist.get(i)); }
							 * if(nextcatdatelist.get(i)!=null){
							 * masmedical.setNextcatdate
							 * (nextcatdatelist.get(i)); }
							 * if(approximatedatelist.get(i)!=null){
							 * masmedical.setApproximatedate1
							 * (approximatedatelist.get(i)); }
							 * if(approximatedate2list.get(i)!=null){
							 * masmedical.
							 * setApproximatedate2(approximatedate2list.get(i));
							 * } if(beforeDisabilitylist.get(i)!=null){
							 * masmedical
							 * .setBeforeDisability(beforeDisabilitylist
							 * .get(i)); }
							 */

							hbt.save(masmedical);
							hbt.refresh(masmedical);
							hbt.flush();
						}

					}
					List<Integer> serialnoBeforeList = new ArrayList<Integer>();
					List<String> illnessBeforeList = new ArrayList<String>();
					List<Date> particulardateBeforeList = new ArrayList<Date>();
					List<String> treatedBeforeList = new ArrayList<String>();
					List<String> placeBeforeList = new ArrayList<String>();
					List<String> beforeDisabilityBeforeList = new ArrayList<String>();

					int hdbBefore = 0;
					hdbBefore = (Integer) mapForDS.get("hdbBefore");
					if (mapForDS.get("serialnoBeforeList") != null) {
						serialnoBeforeList = (List) mapForDS
								.get("serialnoBeforeList");
					}
					if (mapForDS.get("illnessBeforeList") != null) {
						illnessBeforeList = (List) mapForDS
								.get("illnessBeforeList");
					}
					if (mapForDS.get("placeBeforeList") != null) {
						placeBeforeList = (List) mapForDS
								.get("placeBeforeList");
					}
					if (mapForDS.get("particulardateBeforeList") != null) {
						particulardateBeforeList = (List) mapForDS
								.get("particulardateBeforeList");
					}
					if (mapForDS.get("treatedBeforeList") != null) {
						treatedBeforeList = (List) mapForDS
								.get("treatedBeforeList");
					}
					if (mapForDS.get("beforeDisabilityBeforeList") != null) {
						beforeDisabilityBeforeList = (List) mapForDS
								.get("beforeDisabilityBeforeList");
					}
					// for (int i = 0; i < hdbBefore; i++) {
			for (int i = 0; i < illnessBeforeList.size(); i++) {
				/*int serialNo = 0;
				if (serialnoBeforeList.get(i) != null) {
					serialNo = serialnoBeforeList.get(i);
				}*///--commented by dipali
				try {
					//if (serialNo > 0) {//--commented by dipali
				if (illnessBeforeList.get(i) != null && !(illnessBeforeList.get(i).equals(""))) {
					MasMedicalExaminationDetail masmedical2 = new MasMedicalExaminationDetail();
					if (serialnoBeforeList.get(i) != null) {
						masmedical2.setSerialno(serialnoBeforeList
								.get(i));
					}
					if (illnessBeforeList.get(i) != null) {
						masmedical2.setIllness(illnessBeforeList
								.get(i));
					}
					if (illnessICDBeforelist.get(i) > 0) {
						
						 MasIcd masIcd=new MasIcd();
						 masIcd.setId(illnessICDBeforelist.get(i)); 
						 masmedical2.setMasIcd(masIcd);
						 
						/*MasSystemDiagnosis masIcd = new MasSystemDiagnosis();
						masIcd.setId(illnessICDBeforelist.get(i));
						masmedical2.setSystemDiagnosis(masIcd);*/
					}
					if (placeBeforeList.get(i) != null) {
						masmedical2
								.setPlace(placeBeforeList.get(i));
					}
					if (beforeDisabilityBeforeList.get(i) != null) {
						masmedical2
								.setBeforeDisability(beforeDisabilityBeforeList
										.get(i));
					}
					if (particulardateBeforeList.get(i) != null) {
						masmedical2
								.setParticulardate(particulardateBeforeList
										.get(i));
						}
						if (treatedBeforeList.get(i) != null) {
							masmedical2.setTreated(treatedBeforeList
									.get(i));
						}
						masmedical2.setParticular("particular");
						masmedical2
								.setMasMedicalReport(masMedicalBoardProceedings);
						session.save(masmedical2);
						// hbt1.refresh(masmedical2);
						// hbt1.flush();
					}
				} catch (Exception e) {

					e.printStackTrace();
				}
			}

				}
				if (masMedicalBoardProceedings.getMedicalExamType()
						.equalsIgnoreCase("Medical Board AFMSF 16")) {
					int hiddenValue1 = 1;
					int hdbvalue1 = 1;
					List<String> illnesslist = new ArrayList<String>();
					List<Date> particulardatelist = new ArrayList<Date>();
					List<Integer> rankidlist = new ArrayList<Integer>();
					List<String> treatedlist = new ArrayList<String>();
					List<Integer> serialnolist1 = new ArrayList<Integer>();
					List<String> placelist1 = new ArrayList<String>();

					serialnolist1 = (List) mapForDS.get("serialnolist1");
					illnesslist = (List) mapForDS.get("illnesslist");
					particulardatelist = (List) mapForDS
							.get("particulardatelist");
					rankidlist = (List) mapForDS.get("rankidlist");
					treatedlist = (List) mapForDS.get("treatedlist");
					approximatedatelist = (List) mapForDS
							.get("approximatedatelist");
					if (mapForDS.get("approximatedate2list") != null) {
						approximatedate2list = (List) mapForDS
								.get("approximatedate2list");
					}
					hiddenValue1 = (Integer) mapForDS.get("hiddenValue1");
					hdbvalue1 = (Integer) mapForDS.get("hdbvalue1");
					placelist1 = (List) mapForDS.get("placelist1");

					for (int i = 0; i < illnesslist.size(); i++) {
						MasMedicalExaminationDetail masmedical1 = new MasMedicalExaminationDetail();
						/*int serialNo = 0;
						if (serialnolist1.get(i) != null) {
							serialNo = serialnolist1.get(i);
						}
						if (serialNo > 0) {*///--Commented by dipali--
						if(illnessICDlist.get(i) !=null && !illnessICDlist.get(i).equals("")){
							if (serialnolist1.get(i) != null)
								masmedical1.setSerialNo1(serialnolist1.get(i));
							
							if (illnesslist.get(i) != null) {
								masmedical1.setIllness(illnesslist.get(i));
							}
							if (illnessICDlist.get(i) > 0) {
								
								 MasIcd masIcd=new MasIcd();
								 masIcd.setId(illnessICDlist.get(i));
								 masmedical1.setMasIcd(masIcd);
								 
								/*MasSystemDiagnosis systemDiagnosis = new MasSystemDiagnosis();
								systemDiagnosis.setId(illnessICDlist.get(i));
								masmedical1.setSystemDiagnosis(systemDiagnosis);*/
							}

							if (rankidlist.get(i) != null) {
								if (rankidlist.get(i) > 0) {
									MasRank masrank = new MasRank();
									masrank.setId(rankidlist.get(i));
									masmedical1.setRankIndividual(masrank);
								}
							}
							if (particulardatelist.get(i) != null) {
								masmedical1
										.setParticulardate(particulardatelist
												.get(i));
							}
							if (approximatedatelist.get(i) != null) {
								masmedical1
										.setApproximatedate1(approximatedatelist
												.get(i));
							}
							if (approximatedate2list.get(i) != null) {
								masmedical1
										.setApproximatedate2(approximatedate2list
												.get(i));
							}

							if (placelist1.get(i) != null) {
								masmedical1.setPlace1(placelist1.get(i));
							}
							if (treatedlist.get(i) != null) {
								masmedical1.setTreated(treatedlist.get(i));
							}
							masmedical1.setParticular("particular");
							masmedical1
									.setMasMedicalReport(masMedicalBoardProceedings);
							// if(beforeDisabilitylist.get(i)!=null){
							/*
							 * Before Disability = n means after service Before
							 * Disability = y means before service
							 */
							masmedical1.setBeforeDisability("n");
							// }
							hbt.save(masmedical1);
							hbt.refresh(masmedical1);
							hbt.flush();
						}
					}

				}
				if (Labresult.equalsIgnoreCase("present") && data != null) {
					Visit visit = (Visit) hbt.load(Visit.class, visitId);
					visit.setMedStatus("f");
					hbt.update(visit);
				}
				successfullyAdded = true;
			}
			if (masMedicalBoardProceedings != null) {
				List<MasMedicalExamReportDt> masMedicalExamReportDtList = session
						.createCriteria(MasMedicalExamReportDt.class).add(
								Restrictions.eq("MasMedicalExamReport.Id",
										masMedicalBoardProceedings.getId()))
						.list();
				for (MasMedicalExamReportDt masMedicalExamReportDt : masMedicalExamReportDtList) {
					hbt.delete(masMedicalExamReportDt);
				}

			}
			List<MasMedicalExamFamilyHis> masMedicalExamFamilyHisList = session
					.createCriteria(MasMedicalExamFamilyHis.class).add(
							Restrictions.eq("MasMedicalExamReport.Id",
									masMedicalBoardProceedings.getId())).list();
			if (masMedicalExamFamilyHisList.size() > 0) {
				for (MasMedicalExamFamilyHis masExamFamilyHis : masMedicalExamFamilyHisList) {
					hbt.delete(masExamFamilyHis);
				}
			}
			// ----Alcohal update in patient table(By Dipali)
			String alcohol = "";
			String otherFamilyHistory = "";
			if (mapForDS.get("alcohol") != null) {
				alcohol = (String) mapForDS.get("alcohol");
				Patient patient = (Patient) session.get(Patient.class, hinId);
				if (mapForDS.get("otherFamilyHistory") != null) {
					otherFamilyHistory = (String) mapForDS
							.get("otherFamilyHistory");
				}
				patient.setOtherFamilyHistory(otherFamilyHistory);
				patient.setAlcohol(alcohol);
				hbt.update(patient);
			}
			// ------------
			if (familyHistoryArray != null) {
				for (String familyHistoryId : familyHistoryArray) {
					int familyHisId = Integer.parseInt(familyHistoryId);
					MasMedicalExamFamilyHis masMedicalExamFamilyHis = new MasMedicalExamFamilyHis();
					PatientFamilyHistory patientFamilyHistory = new PatientFamilyHistory();
					patientFamilyHistory.setId(familyHisId);
					masMedicalExamFamilyHis
							.setPatientFamilyHistory(patientFamilyHistory);
					masMedicalExamFamilyHis
							.setMasMedicalExamReport(masMedicalBoardProceedings);
					hbt.save(masMedicalExamFamilyHis);
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
			e.getMessage();
			e.getCause();
		}
		return successfullyAdded;
	}

	public Boolean addMedicalBoardMO16(
			MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry,
			List<MasMedicalBoardExaminationDetail> masMedicalBoardExaminationDetail,
			Map<String, Object> mapForDS) {
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
		String[] familyHistoryArray = (String[]) mapForDS
				.get("familyHistoryArray");
		try {
			tx = session.beginTransaction();
			hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			saveinvestigation = saveInvestigationAdd(mapForDS);

			if (saveinvestigation) {
				hbt.save(masMedicalExaminationReportOnEntry);
				List<Integer> serialnolist = new ArrayList<Integer>();
				List<String> fromlist = new ArrayList<String>();
				List<String> tolist = new ArrayList<String>();
				List<String> placelist = new ArrayList<String>();
				List<String> pnolist = new ArrayList<String>();
				List<String> illnesslist = new ArrayList<String>();
				List<Date> particulardatelist = new ArrayList<Date>();
				List<Integer> rankidlist = new ArrayList<Integer>();
				List<String> treatedlist = new ArrayList<String>();
				List<Date> approximatedatelist = new ArrayList<Date>();
				List<Date> approximatedate2list = new ArrayList<Date>();
				List<String> beforeDisabilitylist = new ArrayList<String>();
				if (mapForDS.get("beforeDisabilitylist") != null) {
					beforeDisabilitylist = (List) mapForDS
							.get("beforeDisabilitylist");
				}
				List<Integer> serialnolist1 = new ArrayList<Integer>();
				List<String> placelist1 = new ArrayList<String>();
				List<String> principallist = new ArrayList<String>();
				List<Date> origindatelist = new ArrayList<Date>();
				List<Date> medicalcatdatelist = new ArrayList<Date>();
				List<Date> nextcatdatelist = new ArrayList<Date>();

				List<Integer> illnessICDlist = new ArrayList<Integer>();
				List<Integer> illnessICDBeforelist = new ArrayList<Integer>();
				if (mapForDS.get("illnessICDlist") != null) {
					illnessICDlist = (List) mapForDS.get("illnessICDlist");
				}
				if (mapForDS.get("illnessICDBeforelist") != null) {
					illnessICDBeforelist = (List) mapForDS
							.get("illnessICDBeforelist");
				}
				int hiddenValue = 1;
				int hiddenValue1 = 1;
				int hdbvalue = 1;
				int hdbvalue1 = 1;

				int visitId = (Integer) mapForDS.get("visitId");
				int hinId = (Integer) mapForDS.get("hinId");
				List<String> batchNoList = (List<String>) mapForDS
						.get("batchNoList");
				approximatedatelist = (List) mapForDS
						.get("approximatedatelist");
				if (mapForDS.get("approximatedate2list") != null) {
					approximatedate2list = (List) mapForDS
							.get("approximatedate2list");
				}
				if (masMedicalExaminationReportOnEntry.getMedicalExamType()
						.equalsIgnoreCase("Medical Board AFMSF 16")) {
					/*
					 * Code for Disability Date 01 March 2012
					 */
					List<MasMedicalExaminationDetail> masMedicalExaminationDetailsDisabilityList = new ArrayList<MasMedicalExaminationDetail>();

					if (mapForDS
							.get("masMedicalExaminationDetailsDisabilityList") != null) {
						masMedicalExaminationDetailsDisabilityList = (List) mapForDS
								.get("masMedicalExaminationDetailsDisabilityList");
					}
					if (masMedicalExaminationDetailsDisabilityList.size() > 0) {
						for (MasMedicalExaminationDetail masMedicalExaminationDetail : masMedicalExaminationDetailsDisabilityList) {
							masMedicalExaminationDetail
									.setMasMedicalReport(masMedicalExaminationReportOnEntry);
							session.save(masMedicalExaminationDetail);
						}
					}
					/*
					 * End of Code for Disability Date 01 March 2012
					 */
					serialnolist = (List) mapForDS.get("serialnolist");
					fromlist = (List) mapForDS.get("fromlist");
					tolist = (List) mapForDS.get("tolist");
					placelist = (List) mapForDS.get("placelist");
					pnolist = (List) mapForDS.get("pnolist");
					hiddenValue = (Integer) mapForDS.get("hiddenValue");
					hdbvalue = (Integer) mapForDS.get("hdbvalue");
					principallist = (List) mapForDS.get("principallist");
					origindatelist = (List) mapForDS.get("origindatelist");
					medicalcatdatelist = (List) mapForDS
							.get("medicalcatdatelist");
					nextcatdatelist = (List) mapForDS.get("nextcatdatelist");

					// for (int i = 0; i < hdbvalue; i++) {
					for (int i = 0; i < serialnolist.size(); i++) {
						MasMedicalExaminationDetail masmedical = new MasMedicalExaminationDetail();
						int serialNo = 0;
						if (serialnolist.get(i) != null) {
							serialNo = serialnolist.get(i);
						}
						if (serialNo > 0) {
							if (serialnolist.get(i) != null) {
								masmedical.setSerialno(serialnolist.get(i));
							}
							if (fromlist.get(i) != null
									&& fromlist.get(i) != "") {
								masmedical
										.setAddressfrom(HMSUtil
												.convertStringTypeDateToDateType(fromlist
														.get(i)));
							}
							if (tolist.get(i) != null && tolist.get(i) != "") {
								masmedical.setAddressto(HMSUtil
										.convertStringTypeDateToDateType(tolist
												.get(i)));
							}

							if (placelist.get(i) != null) {
								masmedical.setPlace(placelist.get(i));
							}
							if (pnolist.get(i) != null) {
								masmedical.setPno(pnolist.get(i));
							}
							masmedical.setParticular("detail");
							masmedical
									.setMasMedicalReport(masMedicalExaminationReportOnEntry);
							/*
							 * if(principallist.get(i)!=null){
							 * masmedical.setPrincipal(principallist.get(i)); }
							 * if(origindatelist.get(i)!=null){
							 * masmedical.setOrigindate(origindatelist.get(i));
							 * } if(medicalcatdatelist.get(i)!=null){
							 * masmedical.
							 * setMedicalcatdate(medicalcatdatelist.get(i)); }
							 * if(nextcatdatelist.get(i)!=null){
							 * masmedical.setNextcatdate
							 * (nextcatdatelist.get(i)); }
							 * 
							 * if(beforeDisabilitylist.get(i)!=null){
							 * masmedical.
							 * setBeforeDisability(beforeDisabilitylist.get(i));
							 * } if(approximatedatelist.get(i)!=null){
							 * masmedical
							 * .setApproximatedate1(approximatedatelist.get(i));
							 * } if(approximatedate2list.get(i)!=null){
							 * masmedical
							 * .setApproximatedate2(approximatedate2list
							 * .get(i)); }
							 */
						}
						hbt.save(masmedical);
					}
					/*
					 * Code for Service Before Disibility
					 */
					List<Integer> serialnoBeforeList = new ArrayList<Integer>();
					List<String> illnessBeforeList = new ArrayList<String>();
					List<Date> particulardateBeforeList = new ArrayList<Date>();
					List<String> treatedBeforeList = new ArrayList<String>();
					List<String> placeBeforeList = new ArrayList<String>();
					List<String> beforeDisabilityBeforeList = new ArrayList<String>();
					int hdbBefore = 0;
					hdbBefore = (Integer) mapForDS.get("hdbBefore");
					if (mapForDS.get("serialnoBeforeList") != null) {
						serialnoBeforeList = (List) mapForDS
								.get("serialnoBeforeList");
					}
					if (mapForDS.get("illnessBeforeList") != null) {
						illnessBeforeList = (List) mapForDS
								.get("illnessBeforeList");
					}
					if (mapForDS.get("placeBeforeList") != null) {
						placeBeforeList = (List) mapForDS
								.get("placeBeforeList");
					}
					if (mapForDS.get("particulardateBeforeList") != null) {
						particulardateBeforeList = (List) mapForDS
								.get("particulardateBeforeList");
					}
					if (mapForDS.get("treatedBeforeList") != null) {
						treatedBeforeList = (List) mapForDS
								.get("treatedBeforeList");
					}
					if (mapForDS.get("beforeDisabilityBeforeList") != null) {
						beforeDisabilityBeforeList = (List) mapForDS
								.get("beforeDisabilityBeforeList");
					}

					for (int i = 0; i < serialnoBeforeList.size(); i++) {
						MasMedicalExaminationDetail masmedical = new MasMedicalExaminationDetail();
						int serialNo = 0;
						if (serialnoBeforeList.get(i) != null) {
							serialNo = serialnoBeforeList.get(i);
						}
						if (serialNo > 0) {
							if (serialnoBeforeList.get(i) != null) {
								masmedical.setSerialno(serialnoBeforeList
										.get(i));
							}
							if (illnessBeforeList.get(i) != null) {
								masmedical.setIllness(illnessBeforeList.get(i));
							}
							if (illnessICDBeforelist.get(i) > 0) {
								
								 MasIcd masIcd=new MasIcd();
								 masIcd.setId(illnessICDBeforelist.get(i));
								 masmedical.setMasIcd(masIcd);
								 
								/*MasSystemDiagnosis masIcd = new MasSystemDiagnosis();
								masIcd.setId(illnessICDBeforelist.get(i));
								masmedical.setSystemDiagnosis(masIcd);
*/
							}
							if (placeBeforeList.get(i) != null) {
								masmedical.setPlace(placeBeforeList.get(i));
							}
							/*
							 * Before Disability = n means after service Before
							 * Disability = y means before service
							 */
							if (beforeDisabilityBeforeList.get(i) != null) {
								masmedical
										.setBeforeDisability(beforeDisabilityBeforeList
												.get(i));
							}
							if (particulardateBeforeList.get(i) != null) {
								masmedical
										.setParticulardate(particulardateBeforeList
												.get(i));
							}
							if (treatedBeforeList.get(i) != null) {
								masmedical.setTreated(treatedBeforeList.get(i));
							}
							masmedical.setParticular("particular");
							masmedical
									.setMasMedicalReport(masMedicalExaminationReportOnEntry);
							session.save(masmedical);
						}
					}
					/*
					 * End of Code Service Before Dislibility
					 */
				}
				if (masMedicalExaminationReportOnEntry.getMedicalExamType()
						.equalsIgnoreCase("Medical Board AFMSF 16")) {
					/*
					 * Code Service Dislibility
					 */
					serialnolist1 = (List) mapForDS.get("serialnolist1");
					illnesslist = (List) mapForDS.get("illnesslist");
					particulardatelist = (List) mapForDS
							.get("particulardatelist");
					rankidlist = (List) mapForDS.get("rankidlist");
					treatedlist = (List) mapForDS.get("treatedlist");

					hiddenValue1 = (Integer) mapForDS.get("hiddenValue1");
					hdbvalue1 = (Integer) mapForDS.get("hdbvalue1");
					placelist1 = (List) mapForDS.get("placelist1");

					// for (int i = 0; i < hdbvalue1; i++) {
					for (int i = 0; i < serialnolist1.size(); i++) {
						int serialNo = 0;
						if (serialnolist1.get(i) != null) {
							serialNo = serialnolist1.get(i);
						}
						if (serialNo > 0) {

							MasMedicalExaminationDetail masmedical1 = new MasMedicalExaminationDetail();
							if (serialnolist1.get(i) != null) {
								masmedical1.setSerialNo1(serialnolist1.get(i));
							}
							if (illnesslist.get(i) != null) {
								masmedical1.setIllness(illnesslist.get(i));
							}
							if (illnessICDlist.get(i) > 0) {
								
								 MasIcd masIcd=new MasIcd();
								 masIcd.setId(illnessICDlist.get(i));
								 masmedical1.setMasIcd(masIcd);
								 
								/*MasSystemDiagnosis masIcd = new MasSystemDiagnosis();
								masIcd.setId(illnessICDlist.get(i));
								masmedical1.setSystemDiagnosis(masIcd);*/
							}
							if (particulardatelist.get(i) != null) {
								masmedical1
										.setParticulardate(particulardatelist
												.get(i));
							}
							if (rankidlist.get(i) != null) {
								if (rankidlist.get(i) > 0) {
									MasRank masrank = new MasRank();
									masrank.setId(rankidlist.get(i));
									masmedical1.setRankIndividual(masrank);
								}
							}
							if (approximatedatelist.get(i) != null) {
								masmedical1
										.setApproximatedate1(approximatedatelist
												.get(i));
							}
							if (approximatedate2list.get(i) != null) {
								masmedical1
										.setApproximatedate2(approximatedate2list
												.get(i));
							}

							if (placelist1.get(i) != null) {
								masmedical1.setPlace1(placelist1.get(i));
							}
							if (treatedlist.get(i) != null) {
								masmedical1.setTreated(treatedlist.get(i));
							}
							if (beforeDisabilitylist.get(i) != null) {
								masmedical1
										.setBeforeDisability(beforeDisabilitylist
												.get(i));
							}
							masmedical1.setParticular("particular");
							masmedical1
									.setMasMedicalReport(masMedicalExaminationReportOnEntry);
							hbt.save(masmedical1);
						}
						/*
						 * End of Code Service Dislibility
						 */
					}
				}
				hbt.refresh(masMedicalExaminationReportOnEntry);
				// ----Alcohal and otherFamilyHistory update in patient table(By
				// Dipali)
				String otherFamilyHistory = "";
				String alcohol = "";
				if (mapForDS.get("alcohol") != null) {
					alcohol = (String) mapForDS.get("alcohol");
				}
				Patient patient = (Patient) session.get(Patient.class, hinId);
				patient.setAlcohol(alcohol);
				if (mapForDS.get("otherFamilyHistory") != null) {
					otherFamilyHistory = (String) mapForDS
							.get("otherFamilyHistory");
				}
				patient.setOtherFamilyHistory(otherFamilyHistory);
				hbt.update(patient);

				// ----------------------------------

				Visit visit = (Visit) session.get(Visit.class, visitId);
				if (visit != null) {
					/*
					 * Code By Mukesh Date 03 Feb 2012
					 */
					/*
					 * Priority Color Coding By Mukesh Normal Urgent Very Urgent
					 * New Data 3 2 1 Pending For Result 6 5 6 Rejected By MO 9
					 * 8 7
					 */
					if (visit.getPriority() != null) {
						if (visit.getPriority() == 1) {
							visit.setPriority(4);
						} else if (visit.getPriority() == 2) {
							visit.setPriority(5);
						} else if (visit.getPriority() == 3) {
							visit.setPriority(6);
						}
					}
					// visit.setPriority(1);

					hbt.update(visit);
				}

				successfullyAdded = true;
				medicalWorkNoList = session.createCriteria(
						TransactionSequence.class).add(
						Restrictions.eq("TransactionPrefix", "MED")).list();

				if (successfullyAdded) {
					for (TransactionSequence transactionSequence : medicalWorkNoList) {
						TransactionSequence obj = transactionSequence;
						int id2 = obj.getId();
						int seqNo = obj.getTransactionSequenceNumber();
						TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
								.load(TransactionSequence.class, id2);
						transactionSequenceObj
								.setTransactionSequenceNumber(++seqNo);
						if (currentMonth.equalsIgnoreCase("01")) {
							transactionSequenceObj
									.setTransactionSequenceNumber(1);
							seqNo = 1;
						}
						hbt.update(transactionSequenceObj);
					}
				}
				if (familyHistoryArray != null) {
					for (String familyHistoryId : familyHistoryArray) {
						int familyHisId = Integer.parseInt(familyHistoryId);
						MasMedicalExamFamilyHis masMedicalExamFamilyHis = new MasMedicalExamFamilyHis();
						PatientFamilyHistory patientFamilyHistory = new PatientFamilyHistory();
						patientFamilyHistory.setId(familyHisId);
						masMedicalExamFamilyHis
								.setPatientFamilyHistory(patientFamilyHistory);
						masMedicalExamFamilyHis
								.setMasMedicalExamReport(masMedicalExaminationReportOnEntry);
						hbt.save(masMedicalExamFamilyHis);
					}
				}
				tx.commit();

			}
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}

		return successfullyAdded;

	}

	@Override
	public Map<String, Object> showMBForm16List(Map<String, Object> mapForDS) {/*
		List<Visit> visit = null;
		
		 * List<MasServiceType> serviceTypeList = null; List<MasState> stateList
		 * = null; List<MasMaritalStatus> maritalStatusList = null;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int visitId = (Integer) mapForDS.get("visitId");
		int deptId = (Integer) mapForDS.get("deptId");
		int empId = (Integer) mapForDS.get("empId");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		visit = hbt.find("from Visit as v where v.Id='" + visitId + "'");
		List<MasEmployee> loginEmployeeList = new ArrayList<MasEmployee>();
		if (empId > 0) {
			loginEmployeeList = hbt
					.find("from jkt.hms.masters.business.MasEmployee emp where emp.Status='y' and emp.Id="
							+ empId);		}
		map.put("loginEmployeeList", loginEmployeeList);
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		templateList = session.createCriteria(OpdTemplate.class).createAlias(
				"Department", "dept").add(Restrictions.eq("dept.Id", deptId))
				.add(Restrictions.eq("Status", "y")).list();
		
		 * serviceTypeList =
		 * hbt.find("from MasServiceType mst where mst.Status='y'"); stateList =
		 * hbt.find("from MasState ms where ms.Status='y'"); maritalStatusList =
		 * hbt.find("from MasMaritalStatus mms where mms.Status='y'");
		 * List<MasRank> masRankList1 = new ArrayList<MasRank>(); masRankList1 =
		 * getHibernateTemplate
		 * ().find("from jkt.hms.masters.business.MasRank ");
		 
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		employeeList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).list();
		if (employeeList.size() > 0) {
			map.put("employeeList", employeeList);
		}
		
		 * List<Disability> disabilityList = new ArrayList<Disability>();
		 * disabilityList =
		 * getHibernateTemplate().find("from jkt.hms.masters.business.Disability "
		 * );
		 
		List<Category> categoryList = new ArrayList<Category>();
		categoryList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.Category ");
		int medExamId = (Integer) mapForDS.get("medExamId");
		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();

		if (medExamId != 0) {
			medExamList = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).add(
					Restrictions.eq("Status", "f").ignoreCase()).list();
		} else {
			medExamList = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.eq("Visit.Id", visitId)).add(
					Restrictions.eq("Status", "p").ignoreCase()).list();
		}
		List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
		masMedicalExaminationDetailList = session.createCriteria(
				MasMedicalExaminationDetail.class).createAlias(
				"MasMedicalReport", "medReport").add(
				Restrictions.eq("medReport.Id", medExamId)).list();
		map.put("masMedicalExaminationDetailList",
				masMedicalExaminationDetailList);
		Visit visitdata = null;
		List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();

		if (visit != null && visit.size() > 0) {
			visitdata = visit.get(0);
		}
		patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
				.createCriteria(PatientInvestigationHeader.class).createAlias(
						"Visit", "v").add(Restrictions.eq("v.Id", visitId))
				.createAlias("Hin", "p").add(
						Restrictions.eq("p.Id", visitdata.getHin().getId()))
				.addOrder(Order.desc("Id")).list();
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
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		resultList = session.createCriteria(DgResultEntryHeader.class)
				.createAlias("SampleCollectionHeader", "smColl").createAlias(
						"smColl.Order", "order").createAlias("order.Visit",
						"vst").add(Restrictions.eq("vst.Id", visitId)).add(
						Restrictions.eq("ResultStatus", "A")).list();
		if (resultList != null || resultList.size() > 0) {
			map.put("resultList", resultList);
		}

		
		 * List<MasIcd> masIcdList = new ArrayList<MasIcd>(); masIcdList =
		 * getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.MasIcd as mi where mi.Status='y' order by mi.IcdName asc"
		 * ); List<Disabilitygroup> disabilitygroupList = new
		 * ArrayList<Disabilitygroup>(); disabilitygroupList =
		 * getHibernateTemplate
		 * ().find("from jkt.hms.masters.business.Disabilitygroup");
		 * List<MasUnit> masUnitList = new ArrayList<MasUnit>(); masUnitList =
		 * getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.MasUnit as mu where mu.Status='y' order by mu.UnitName asc"
		 * );
		 * 
		 * List<MasSystemDiagnosis> masSystemDiagnosisList = new
		 * ArrayList<MasSystemDiagnosis>(); masSystemDiagnosisList =
		 * getHibernateTemplate().find(
		 * "from jkt.hms.masters.business.MasSystemDiagnosis as msd where msd.Status='y' order by msd.SystemDiagnosisName asc"
		 * );
		 
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		masHospitalList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasHospital mh where mh.Status='y' order by mh.HospitalName asc");

		masDepartmentList = getHibernateTemplate()
				.find(
						"from jkt.hms.masters.business.MasDepartment md where md.Status='y' order by md.DepartmentName asc");
		map.put("masHospitalList", masHospitalList);
		map.put("masDepartmentList", masDepartmentList);

		map.put("medExamList", medExamList);
		map.put("templateList", templateList);
		map.put("visit", visit);
		map.put("categoryList", categoryList);
		
		 * map.put("masSystemDiagnosisList", masSystemDiagnosisList);
		 * map.put("masRankList1", masRankList1); map.put("serviceTypeList",
		 * serviceTypeList); map.put("stateList", stateList);
		 * map.put("maritalStatusList", maritalStatusList);
		 * map.put("disabilityList", disabilityList); map.put("masIcdList",
		 * masIcdList); map.put("disabilitygroupList", disabilitygroupList);
		 * map.put("masUnitList", masUnitList);
		 
		return map;

	*/

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Visit> visit = null;
		List<DgOrderhd> resultList = null;
		String search = "";
		String accessjsp = "";
		int medExamId = 0;
		int deptId = 0;
		int hospitalId = 0;
		int empId = 0;
		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		int visitId = 0;
		if (mapForDS.get("visitId") != null) {
			visitId = (Integer) mapForDS.get("visitId");
		}		
		if (mapForDS.get("medExamId") != null) {
			medExamId = (Integer) mapForDS.get("medExamId");
		}
		if (mapForDS.get("deptId") != null) {
			deptId = (Integer) mapForDS.get("deptId");
		}
		if (mapForDS.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDS.get("hospitalId");
		}
		if (mapForDS.get("search") != null) {
			search = (String) mapForDS.get("search");
		}
		if (mapForDS.get("accessjsp") != null) {
			accessjsp = (String) mapForDS.get("accessjsp");
		}
		if (mapForDS.get("empId") != null) {
			empId = (Integer) mapForDS.get("empId");
		}
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		templateList = session.createCriteria(OpdTemplate.class).createAlias(
				"Department", "dept").add(Restrictions.eq("dept.Id", deptId))
				.add(Restrictions.eq("Status", "y")).list();
		map.put("templateList", templateList);
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		if (search.equalsIgnoreCase("true")) {
			medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).list();

		} else if (search.equalsIgnoreCase("false")) {
			medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).list();
		} else {
			medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).list();
		}
		// --Added by dipali-(18-june-2012)-
		List<MasMedicalExaminationDetail> masMedicalExaminationIllList = new ArrayList<MasMedicalExaminationDetail>();

		masMedicalExaminationIllList = session.createCriteria(MasMedicalExaminationDetail.class)
		.createAlias("MasMedicalReport", "medReport").add(Restrictions.eq("medReport.Id", medExamId))
		.add(Restrictions.eq("Particular", "particular")).addOrder(Order.asc("Serviceid")).list();
		
		List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
		masMedicalExaminationDetailList = session.createCriteria(
				MasMedicalExaminationDetail.class).createAlias("MasMedicalReport", "medReport").add(
				Restrictions.eq("medReport.Id", medExamId)).addOrder(Order.asc("Serviceid")).list();
		map.put("masMedicalExaminationDetailList",masMedicalExaminationDetailList);
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		visit = hbt.find("from Visit as v where v.Id='" + visitId + "'");

		List<Integer> headerIdsInt = new ArrayList<Integer>();
		resultList = session.createCriteria(DgResultEntryHeader.class)
				.createAlias("SampleCollectionHeader", "smColl").createAlias(
						"smColl.Order", "order").createAlias("order.Visit",
						"vst").add(Restrictions.eq("vst.Id", visitId)).add(
						Restrictions.eq("ResultStatus", "A")).list();

		
		String empCategoryCodeForDoctor = properties
				.getProperty("empCategoryCodeForDoctor");
		employeeList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).createAlias("Hospital", "h")
				.createAlias("EmpCategory", "ec").add(
						Restrictions.eq("h.Id", hospitalId)).add(
						Restrictions.eq("ec.EmpCategoryCode",
								empCategoryCodeForDoctor)).addOrder(
						Order.asc("FirstName")).list();

		if (employeeList.size() > 0) {
			map.put("employeeList", employeeList);
		}
		
		List<Category> categoryList = new ArrayList<Category>();
		categoryList =session.createCriteria(Category.class)
		.addOrder(Order.asc("Categories")).list();
			//getHibernateTemplate()
			//.find(
			//"from jkt.hms.masters.business.Category as cat order by cat.Categories asc");
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

		if (resultList != null || resultList.size() > 0) {
			map.put("resultList", resultList);
		}

		investigationList = session.createCriteria(DgMasInvestigation.class)
				.add(Restrictions.eq("Status", "y")).addOrder(
						Order.asc("InvestigationName")).list();
		if (investigationList.size() > 0) {
			map.put("investigationList", investigationList);
		}
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		masHospitalList = session.createCriteria(MasHospital.class)
		.add(Restrictions.eq("Status", "y"))
		.addOrder(Order.asc("HospitalName")).list();
			//getHibernateTemplate()
		//.find("from jkt.hms.masters.business.MasHospital mh where mh.Status='y' order by mh.HospitalName asc");

		masDepartmentList =session.createCriteria(MasDepartment.class)
		.add(Restrictions.eq("Status", "y"))
		.addOrder(Order.asc("DepartmentName")).list();
			//getHibernateTemplate()
		//.find("from jkt.hms.masters.business.MasDepartment md where md.Status='y' order by md.DepartmentName asc");
		List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
		employeeMoList = session.createCriteria(MasEmployee.class).add(
				Restrictions.idEq(empId)).list();
		map.put("employeeMoList", employeeMoList);
		map.put("masMedicalExaminationIllList",masMedicalExaminationIllList);
		map.put("masHospitalList", masHospitalList);
		map.put("masDepartmentList", masDepartmentList);
		map.put("visit", visit);
		map.put("medExamList", medExamList);
		map.put("categoryList", categoryList);

		return map;
	
	}

	@Override
	public Map<String, Object> validateAppAuthForm16Jsp(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = 0;
		int visitId = 0;
		int medExamId = 0;
		if (mapForDS.get("visitId") != null) {
			visitId = (Integer) mapForDS.get("visitId");
		}
		if (mapForDS.get("medExamId") != null) {
			medExamId = (Integer) mapForDS.get("medExamId");
		}
		int deptId = 0;
		if (mapForDS.get("deptId") != null) {
			deptId = (Integer) mapForDS.get("deptId");
		}
		MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry = new MasMedicalExaminationReportOnEntry();
		if (mapForDS.get("masMedicalBoardProceedings") != null) {
			masMedicalExaminationReportOnEntry = (MasMedicalExaminationReportOnEntry) mapForDS
					.get("masMedicalBoardProceedings");
		}
		HibernateTemplate hbt = null;
		Transaction tx = null;
		Session session = (Session) getSession();
		boolean falg = false;
		try {
			tx = session.beginTransaction();
			hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masMedicalExaminationReportOnEntry);
			falg = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			falg = false;
			e.printStackTrace();
		}
		map.put("falg", falg);
		return map;

	}

	@Override
	public Map showMBAppAuthForm16List(Map<String, Object> mapForDS) {
		
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int visitId = (Integer) mapForDS.get("visitId");
		int deptId = (Integer) mapForDS.get("deptId");
		int medExamId = (Integer) mapForDS.get("medExamId");
		int empId = 0;
		if (mapForDS.get("empId") != null) {
			empId = (Integer) mapForDS.get("empId");
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		List<Visit> visit = null;
		Visit visitdata = null;
		DgOrderhd dgOrderhd = null;
		PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
		List<MasServiceType> serviceTypeList = null;
		List<MasState> stateList = null;
		List<MasMaritalStatus> maritalStatusList = null;
		List<MasIcd> masIcdList = new ArrayList<MasIcd>();
		List<MasRank> masRankList1 = new ArrayList<MasRank>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		List<MasSystemDiagnosis> masSystemDiagnosisList = new ArrayList<MasSystemDiagnosis>();
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<Disability> disabilityList = new ArrayList<Disability>();
		List<Category> categoryList = new ArrayList<Category>();
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
		
		visit = session.createCriteria(Visit.class)
		.add(Restrictions.eq("Id", visitId)).list(); 
			//hbt.find("from Visit as v where v.Id='" + visitId + "'");
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		templateList = session.createCriteria(OpdTemplate.class).createAlias("Department", "dept")
				.add(Restrictions.eq("dept.Id", deptId)).add(Restrictions.eq("Status", "y")).list();
		serviceTypeList = session.createCriteria(MasServiceType.class)
		.add(Restrictions.eq("Status", "y")).list(); 
			//hbt.find("from MasServiceType mst where mst.Status='y'");
		stateList = session.createCriteria(MasState.class)
		.add(Restrictions.eq("Status", "y")).list(); 
			//hbt.find("from MasState ms where ms.Status='y'");
		maritalStatusList = session.createCriteria(MasMaritalStatus.class)
		.add(Restrictions.eq("Status", "y")).list();
			//hbt.find("from MasMaritalStatus mms where mms.Status='y'");
		masRankList1 = session.createCriteria(MasRank.class).list(); 
			//getHibernateTemplate().find("from jkt.hms.masters.business.MasRank ");
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		disabilityList =  session.createCriteria(Disability.class).list();  
			//getHibernateTemplate().find("from jkt.hms.masters.business.Disability ");
		
		categoryList =  session.createCriteria(Category.class).list();  
			//getHibernateTemplate().find("from jkt.hms.masters.business.Category ");
		String[] statusArr = { "v", "ar" };
		if (medExamId != 0) {
			medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).add(Restrictions.in("Status", statusArr)).list();
		} else {
			medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(
			Restrictions.eq("Visit.Id", visitId)).add(Restrictions.eq("Status", "v").ignoreCase()).list();
		}
		if (visit != null && visit.size() > 0) {
			visitdata = visit.get(0);
		}
		patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
				.createCriteria(PatientInvestigationHeader.class).createAlias("Visit", "v")
						.add(Restrictions.eq("v.Id", visitId)).createAlias("Hin", "p").add(
						Restrictions.eq("p.Id", visitdata.getHin().getId()))
						.addOrder(Order.desc("Id")).list();
		if (patientInvestigationHeaderList != null && patientInvestigationHeaderList.size() > 0) {
			patientInvestigationHeader = patientInvestigationHeaderList.get(0);
			map.put("patientInvestigationHeader", patientInvestigationHeader);

		}
		dgOrderhdList = (List<DgOrderhd>) session.createCriteria(DgOrderhd.class).createAlias("Visit", "v")
			.add(Restrictions.eq("v.Id", visitId)).list();
		if (dgOrderhdList != null && dgOrderhdList.size() > 0) {
			dgOrderhd = dgOrderhdList.get(0);
			map.put("dgOrderhd", dgOrderhd);
		}
		resultList = session.createCriteria(DgResultEntryHeader.class)
				.createAlias("SampleCollectionHeader", "smColl").createAlias("smColl.Order", "order")
				.createAlias("order.Visit",	"vst").add(Restrictions.eq("vst.Id", visitId))
				.add(Restrictions.eq("ResultStatus", "A")).list();
		if (resultList != null || resultList.size() > 0) {
			map.put("resultList", resultList);
		}
		masIcdList = session.createCriteria(MasIcd.class)
		.add(Restrictions.eq("Status", "y"))
		.addOrder(Order.asc("IcdName")).list();
			//getHibernateTemplate()
		//.find("from jkt.hms.masters.business.MasIcd as mi where mi.Status='y' order by mi.IcdName asc");
		List<Disabilitygroup> disabilitygroupList = new ArrayList<Disabilitygroup>();
		disabilitygroupList = session.createCriteria(Disabilitygroup.class)
		.list(); 
			//getHibernateTemplate().find("from jkt.hms.masters.business.Disabilitygroup");
		masUnitList = session.createCriteria(MasUnit.class)
		.add(Restrictions.eq("Status", "y"))
		.addOrder(Order.asc("UnitName")).list();
			//getHibernateTemplate()
			//.find("from jkt.hms.masters.business.MasUnit as mu where mu.Status='y' order by mu.UnitName asc");
		masSystemDiagnosisList = session.createCriteria(MasSystemDiagnosis.class)
		.add(Restrictions.eq("Status", "y"))
		.addOrder(Order.asc("SystemDiagnosisName")).list(); 
			//getHibernateTemplate()
//.find("from jkt.hms.masters.business.MasSystemDiagnosis as msd where msd.Status='y' order by msd.SystemDiagnosisName asc");
		masHospitalList = session.createCriteria(MasHospital.class)
		.add(Restrictions.eq("Status", "y"))
		.addOrder(Order.asc("HospitalName")).list();  
		//getHibernateTemplate()
//.find("from jkt.hms.masters.business.MasHospital mh where mh.Status='y' order by mh.HospitalName asc");
		masDepartmentList = session.createCriteria(MasDepartment.class)
		.add(Restrictions.eq("Status", "y"))
		.addOrder(Order.asc("DepartmentName")).list();  
			//getHibernateTemplate()
	//.find("from jkt.hms.masters.business.MasDepartment md where md.Status='y' order by md.DepartmentName asc");
		
		employeeMoList = session.createCriteria(MasEmployee.class).add(Restrictions.idEq(empId)).list();
		map.put("employeeMoList", employeeMoList);
		if (employeeList.size() > 0) {
			map.put("employeeList", employeeList);
		}
		map.put("masHospitalList", masHospitalList);
		map.put("masDepartmentList", masDepartmentList);
		map.put("masSystemDiagnosisList", masSystemDiagnosisList);
		map.put("medExamList", medExamList);
		map.put("masRankList1", masRankList1);
		map.put("templateList", templateList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("stateList", stateList);
		map.put("maritalStatusList", maritalStatusList);
		map.put("visit", visit);
		map.put("disabilityList", disabilityList);
		map.put("categoryList", categoryList);
		map.put("masIcdList", masIcdList);
		map.put("disabilitygroupList", disabilitygroupList);
		map.put("masUnitList", masUnitList);
		return map;

	}

	@Override
	public Map showMBConfAuthForm16List(Map<String, Object> mapForDS) {
		List<Visit> visit = null;

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int visitId = (Integer) mapForDS.get("visitId");
		int deptId = (Integer) mapForDS.get("deptId");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int empId = 0;
		if (mapForDS.get("empId") != null) {
			empId = (Integer) mapForDS.get("empId");
		}
		List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
		employeeMoList = session.createCriteria(MasEmployee.class).add(
				Restrictions.idEq(empId)).list();
		map.put("employeeMoList", employeeMoList);

		visit = session.createCriteria(Visit.class)
		.add(Restrictions.eq("Id", visitId)).list();
		/*List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		employeeList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).list();
		if (employeeList.size() > 0) {
			map.put("employeeList", employeeList);
		}
		List<Disability> disabilityList = new ArrayList<Disability>();
		disabilityList = session.createCriteria(Disability.class)
		.list();  
			//getHibernateTemplate().find(
				//"from jkt.hms.masters.business.Disability ");
		List<Category> categoryList = new ArrayList<Category>();
		categoryList = session.createCriteria(Category.class)
		.list();   */
		int medExamId = (Integer) mapForDS.get("medExamId");
		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		String[] statusArr = { "ap", "pr" };
		if (medExamId != 0) {
			medExamList = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).add(
					Restrictions.in("Status", statusArr)).list();
		} else {
			medExamList = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.eq("Visit.Id", visitId)).add(
					Restrictions.eq("Status", "ap").ignoreCase()).list();
		}
		Visit visitdata = null;
		List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();

		if (visit != null && visit.size() > 0) {
			visitdata = visit.get(0);
		}
		/*patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
				.createCriteria(PatientInvestigationHeader.class).createAlias(
						"Visit", "v").add(Restrictions.eq("v.Id", visitId))
				.createAlias("Hin", "p").add(
						Restrictions.eq("p.Id", visitdata.getHin().getId()))
				.addOrder(Order.desc("Id")).list();
		if (patientInvestigationHeaderList != null
				&& patientInvestigationHeaderList.size() > 0) {
			patientInvestigationHeader = patientInvestigationHeaderList.get(0);
			map.put("patientInvestigationHeader", patientInvestigationHeader);

		}*/
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		dgOrderhdList = (List<DgOrderhd>) session.createCriteria(
				DgOrderhd.class).createAlias("Visit", "v").add(
				Restrictions.eq("v.Id", visitId)).list();

		DgOrderhd dgOrderhd = null;
		if (dgOrderhdList != null && dgOrderhdList.size() > 0) {
			dgOrderhd = dgOrderhdList.get(0);
			map.put("dgOrderhd", dgOrderhd);

		}
		/*List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		resultList = session.createCriteria(DgResultEntryHeader.class)
				.createAlias("SampleCollectionHeader", "smColl").createAlias(
						"smColl.Order", "order").createAlias("order.Visit",
						"vst").add(Restrictions.eq("vst.Id", visitId)).add(
						Restrictions.eq("ResultStatus", "A")).list();
		if (resultList != null || resultList.size() > 0) {
			map.put("resultList", resultList);
		}
		List<MasIcd> masIcdList = new ArrayList<MasIcd>();
		masIcdList = session.createCriteria(MasIcd.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("IcdName")).list();
			//getHibernateTemplate()
			//.find(
			//"from jkt.hms.masters.business.MasIcd as mi where mi.Status='y' order by mi.IcdName asc");
		List<Disabilitygroup> disabilitygroupList = new ArrayList<Disabilitygroup>();
		disabilitygroupList = session.createCriteria(Disabilitygroup.class).list(); 
			//getHibernateTemplate().find(
				//"from jkt.hms.masters.business.Disabilitygroup");
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		masUnitList = session.createCriteria(MasUnit.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("UnitName")).list(); 
			//getHibernateTemplate()
			//.find(
		//"from jkt.hms.masters.business.MasUnit as mu where mu.Status='y' order by mu.UnitName asc");

		List<MasSystemDiagnosis> masSystemDiagnosisList = new ArrayList<MasSystemDiagnosis>();
		masSystemDiagnosisList = session.createCriteria(MasSystemDiagnosis.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("SystemDiagnosisName")).list(); 
			//getHibernateTemplate()
			//.find(
		//"from jkt.hms.masters.business.MasSystemDiagnosis as msd where msd.Status='y' order by msd.SystemDiagnosisName asc");
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		masHospitalList =  session.createCriteria(MasHospital.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("HospitalName")).list();  
			//getHibernateTemplate()
		//.find(
		//"from jkt.hms.masters.business.MasHospital mh where mh.Status='y' order by mh.HospitalName asc");

		masDepartmentList =  session.createCriteria(MasDepartment.class)
		.add(Restrictions.eq("Status","y"))
		.addOrder(Order.asc("DepartmentName")).list(); */
			//getHibernateTemplate()
				//.find(
	//"from jkt.hms.masters.business.MasDepartment md where md.Status='y' order by md.DepartmentName asc");

		map.put("medExamList", medExamList);
		map.put("visit", visit);
		/*map.put("masHospitalList", masHospitalList);
		map.put("masDepartmentList", masDepartmentList);

		map.put("masSystemDiagnosisList", masSystemDiagnosisList);

		map.put("disabilityList", disabilityList);
		map.put("categoryList", categoryList);
		map.put("masIcdList", masIcdList);
		map.put("disabilitygroupList", disabilitygroupList);
		map.put("masUnitList", masUnitList);*/
		return map;

	}

	@Override
	public Map showMBAccpAuthForm16List(Map<String, Object> mapForDS) {
		List<Visit> visit = null;
		List<MasServiceType> serviceTypeList = null;
		List<MasState> stateList = null;
		List<MasMaritalStatus> maritalStatusList = null;

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int visitId = (Integer) mapForDS.get("visitId");
		int deptId = (Integer) mapForDS.get("deptId");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int empId = 0;
		if (mapForDS.get("empId") != null) {
			empId = (Integer) mapForDS.get("empId");
		}
		List<MasEmployee> employeeMoList = new ArrayList<MasEmployee>();
		employeeMoList = session.createCriteria(MasEmployee.class).add(
				Restrictions.idEq(empId)).list();
		map.put("employeeMoList", employeeMoList);

		visit = session.createCriteria(Visit.class).add(Restrictions.eq("Id", visitId)).list(); 
			//hbt.find("from Visit as v where v.Id='" + visitId + "'");
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		templateList = session.createCriteria(OpdTemplate.class).createAlias(
				"Department", "dept").add(Restrictions.eq("dept.Id", deptId))
				.add(Restrictions.eq("Status", "y")).list();
		serviceTypeList = session.createCriteria(MasServiceType.class)
		.add(Restrictions.eq("Status", "y")).list();  
			//hbt
			//.find("from MasServiceType mst where mst.Status='y'");
		stateList =  session.createCriteria(MasState.class)
		.add(Restrictions.eq("Status", "y")).list(); 
			//hbt.find("from MasState ms where ms.Status='y'");
		maritalStatusList =  session.createCriteria(MasMaritalStatus.class)
		.add(Restrictions.eq("Status", "y")).list();  
			//hbt
				//.find("from MasMaritalStatus mms where mms.Status='y'");
		List<MasRank> masRankList1 = new ArrayList<MasRank>();
		masRankList1 = session.createCriteria(MasRank.class).list();
			//getHibernateTemplate().find(
				//"from jkt.hms.masters.business.MasRank ");
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		employeeList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).list();
		if (employeeList.size() > 0) {
			map.put("employeeList", employeeList);
		}
		int medExamId = (Integer) mapForDS.get("medExamId");
		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();

		if (medExamId != 0) {
			medExamList = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).add(
					Restrictions.eq("Status", "cn").ignoreCase()).list();
		} else {
			medExamList = session.createCriteria(
					MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.eq("Visit.Id", visitId)).add(
					Restrictions.eq("Status", "cn").ignoreCase()).list();
		}
		Visit visitdata = null;
		/*List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();*/

		if (visit != null && visit.size() > 0) {
			visitdata = visit.get(0);
		}
		/*patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session
				.createCriteria(PatientInvestigationHeader.class).createAlias(
						"Visit", "v").add(Restrictions.eq("v.Id", visitId))
				.createAlias("Hin", "p").add(
						Restrictions.eq("p.Id", visitdata.getHin().getId()))
				.addOrder(Order.desc("Id")).list();
		if (patientInvestigationHeaderList != null
				&& patientInvestigationHeaderList.size() > 0) {
			patientInvestigationHeader = patientInvestigationHeaderList.get(0);
			map.put("patientInvestigationHeader", patientInvestigationHeader);

		}*/
		/*List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		dgOrderhdList = (List<DgOrderhd>) session.createCriteria(
				DgOrderhd.class).createAlias("Visit", "v").add(
				Restrictions.eq("v.Id", visitId)).list();

		DgOrderhd dgOrderhd = null;
		if (dgOrderhdList != null && dgOrderhdList.size() > 0) {
			dgOrderhd = dgOrderhdList.get(0);
			map.put("dgOrderhd", dgOrderhd);

		}
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		resultList = session.createCriteria(DgResultEntryHeader.class)
				.createAlias("SampleCollectionHeader", "smColl").createAlias(
						"smColl.Order", "order").createAlias("order.Visit",
						"vst").add(Restrictions.eq("vst.Id", visitId)).add(
						Restrictions.eq("ResultStatus", "A")).list();
		if (resultList != null || resultList.size() > 0) {
			map.put("resultList", resultList);
		}*/
		/*List<MasIcd> masIcdList = new ArrayList<MasIcd>();
		masIcdList = session.createCriteria(MasIcd.class)
		.add(Restrictions.eq("Status", "y"))
		.addOrder(Order.asc("IcdName")).list();*/
			//getHibernateTemplate()
			//.find(
	//"from jkt.hms.masters.business.MasIcd as mi where mi.Status='y' order by mi.IcdName asc");
	/*	List<Disabilitygroup> disabilitygroupList = new ArrayList<Disabilitygroup>();
		disabilitygroupList = session.createCriteria(Disabilitygroup.class)
		//.add(Restrictions.eq("Status", "y"))
		//.addOrder(Order.asc("IcdName"))
		.list(); 
			//getHibernateTemplate().find(
				//"from jkt.hms.masters.business.Disabilitygroup");
*/		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		masUnitList = session.createCriteria(MasUnit.class)
		.add(Restrictions.eq("Status", "y"))
		.addOrder(Order.asc("UnitName")).list();
			//getHibernateTemplate()
				//.find(
	//	"from jkt.hms.masters.business.MasUnit as mu where mu.Status='y' order by mu.UnitName asc");

		List<MasSystemDiagnosis> masSystemDiagnosisList = new ArrayList<MasSystemDiagnosis>();
		masSystemDiagnosisList = session.createCriteria(MasSystemDiagnosis.class)
		.add(Restrictions.eq("Status", "y"))
		.addOrder(Order.asc("SystemDiagnosisName")).list();
			//getHibernateTemplate()
				//.find(
//"from jkt.hms.masters.business.MasSystemDiagnosis as msd where msd.Status='y' order by msd.SystemDiagnosisName asc");
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		masHospitalList = session.createCriteria(MasHospital.class)
		.add(Restrictions.eq("Status", "y"))
		.addOrder(Order.asc("HospitalName")).list(); 
			//getHibernateTemplate()
				//.find(
	//"from jkt.hms.masters.business.MasHospital mh where mh.Status='y' order by mh.HospitalName asc");

		masDepartmentList =  session.createCriteria(MasDepartment.class)
		.add(Restrictions.eq("Status", "y"))
		.addOrder(Order.asc("DepartmentName")).list();
			//getHibernateTemplate()
				//.find(
	//"from jkt.hms.masters.business.MasDepartment md where md.Status='y' order by md.DepartmentName asc");

		map.put("masHospitalList", masHospitalList);
		map.put("masDepartmentList", masDepartmentList);

		map.put("masSystemDiagnosisList", masSystemDiagnosisList);

		map.put("medExamList", medExamList);
		map.put("masRankList1", masRankList1);
		map.put("templateList", templateList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("stateList", stateList);
		map.put("maritalStatusList", maritalStatusList);
		map.put("visit", visit);
		map.put("masUnitList", masUnitList);
		return map;

	}

	@Override
	public Map<String, Object> showMedicalBoardConfirmingAuthority(
			int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> mbConfirmAuthWaitList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).list();

		String[] statusArr = { "ap", "pr" };
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.in("Status", statusArr)).add(
						Restrictions.eq("medicalType", "MedicalBoard"))
				.createAlias("Hospital", "h").add(
						Restrictions.eq("h.Id", hospitalId)).addOrder(
						Order.desc("Id"));

		mbConfirmAuthWaitList = crit.list();
		map.put("mbConfirmAuthWaitList", mbConfirmAuthWaitList);
		map.put("rankList", rankList);

		return map;
	}

	public Map<String, Object> getCommandingStatementDetails(
			Map<String, Object> mapForDS) {
		List<Category> categoryList = new ArrayList<Category>();
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int medExamId = (Integer) mapForDS.get("medExamId");
		int visitId = (Integer) mapForDS.get("visitId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		try {
			MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry = (MasMedicalExaminationReportOnEntry) session
					.get(MasMedicalExaminationReportOnEntry.class, medExamId);
			List<MasMedicalExaminationDetail> masMedicalExamDetailList = session
					.createCriteria(MasMedicalExaminationDetail.class).add(
							Restrictions.eq("MasMedicalReport.Id", medExamId))
					.add(Restrictions.eq("Particular", "DisabilityDetails"))
					.list();
			categoryList = session.createCriteria(Category.class).list(); 
				//getHibernateTemplate().find(
				//	"from jkt.hms.masters.business.Category ");
			map.put("masMedicalExaminationReportOnEntry",
					masMedicalExaminationReportOnEntry);
			map.put("masMedicalExamDetailList", masMedicalExamDetailList);
			map.put("categoryList", categoryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> validateAcceptAuthForm16Jsp(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = 0;
		int visitId = 0;
		int medExamId = 0;
		if (mapForDS.get("visitId") != null) {
			visitId = (Integer) mapForDS.get("visitId");
		}
		if (mapForDS.get("medExamId") != null) {
			medExamId = (Integer) mapForDS.get("medExamId");
		}
		int deptId = 0;
		if (mapForDS.get("deptId") != null) {
			deptId = (Integer) mapForDS.get("deptId");
		}
		MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry = new MasMedicalExaminationReportOnEntry();
		if (mapForDS.get("masMedicalBoardProceedings") != null) {
			masMedicalExaminationReportOnEntry = (MasMedicalExaminationReportOnEntry) mapForDS
					.get("masMedicalBoardProceedings");
		}
		HibernateTemplate hbt = null;
		Transaction tx = null;
		Session session = (Session) getSession();
		boolean falg = false;
		try {
			tx = session.beginTransaction();
			hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masMedicalExaminationReportOnEntry);
			falg = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			falg = false;
			e.printStackTrace();
		}
		map.put("falg", falg);
		return map;

	}

	@Override
	public Map<String, Object> validateConfAuthForm16Jsp(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = 0;
		int visitId = 0;
		int medExamId = 0;
		if (mapForDS.get("visitId") != null) {
			visitId = (Integer) mapForDS.get("visitId");
		}
		if (mapForDS.get("medExamId") != null) {
			medExamId = (Integer) mapForDS.get("medExamId");
		}
		int deptId = 0;
		if (mapForDS.get("deptId") != null) {
			deptId = (Integer) mapForDS.get("deptId");
		}
		MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry = new MasMedicalExaminationReportOnEntry();
		if (mapForDS.get("masMedicalBoardProceedings") != null) {
			masMedicalExaminationReportOnEntry = (MasMedicalExaminationReportOnEntry) mapForDS
					.get("masMedicalBoardProceedings");
		}
		HibernateTemplate hbt = null;
		Transaction tx = null;
		Session session = (Session) getSession();
		boolean falg = false;
		try {
			tx = session.beginTransaction();
			hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masMedicalExaminationReportOnEntry);
			falg = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			falg = false;
			e.printStackTrace();
		}
		map.put("falg", falg);
		return map;

	}

	@Override
	public Map<String, Object> showMedicalBoardAcceptingAuthority(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> mbAcceptAuthWaitList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).list();

		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.eq("Status", "cn")).add(
						Restrictions.eq("medicalType", "MedicalBoard"))
				.createAlias("Hospital", "h").add(
						Restrictions.eq("h.Id", hospitalId)).addOrder(
						Order.desc("Id"));

		mbAcceptAuthWaitList = crit.list();
		map.put("mbAcceptAuthWaitList", mbAcceptAuthWaitList);
		map.put("rankList", rankList);

		return map;
	}

	@Override
	public Map<String, Object> rejectMBForm16Entry(
			Map<String, Object> mapDetails) {

		Map<String, Object> map = new HashMap<String, Object>();
		int visitId = 0;
		int medExamId = 0;
		if (mapDetails.get("visitId") != null) {
			visitId = (Integer) mapDetails.get("visitId");
		}
		if (mapDetails.get("medExamId") != null) {
			medExamId = (Integer) mapDetails.get("medExamId");
		}
		String moRemarks = "";
		String authRemarks = "";
		String confirmRemarks = "";
		String acceptRemarks = "";
		String rejectStatus = "";
		if (mapDetails.get("moRemarks") != null) {
			moRemarks = (String) mapDetails.get("moRemarks");
		}
		if (mapDetails.get("authRemarks") != null) {
			authRemarks = (String) mapDetails.get("authRemarks");
		}
		if (mapDetails.get("confirmRemarks") != null) {
			confirmRemarks = (String) mapDetails.get("confirmRemarks");
		}
		if (mapDetails.get("acceptRemarks") != null) {
			acceptRemarks = (String) mapDetails.get("acceptRemarks");
		}
		if (mapDetails.get("rejectStatus") != null) {
			rejectStatus = (String) mapDetails.get("rejectStatus");
		}
		MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry = new MasMedicalExaminationReportOnEntry();

		HibernateTemplate hbt = null;
		Transaction tx = null;
		Session session = (Session) getSession();
		try {
			tx = session.beginTransaction();
			hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			/*
			 * Code By Mukesh Date 03 Feb 2012
			 */
			Visit visitObj = (Visit) hbt.load(Visit.class, visitId);
			if (visitObj != null) {
				/*
				 * Code By Mukesh Date 03 Feb 2012
				 */
				/*
				 * Priority Color Coding By Mukesh Normal Urgent Very Urgent New
				 * Data 3 2 1 Pending For Result 6 5 4 Rejected By MO 9 8 7
				 */
				int priority = 0;
				if (visitObj.getPriority() != null) {
					if (visitObj.getPriority() == 1) {
						visitObj.setPriority(7);
						priority = 7;
					} else if (visitObj.getPriority() == 2) {
						visitObj.setPriority(8);
						priority = 8;
					} else if (visitObj.getPriority() == 3) {
						visitObj.setPriority(9);
						priority = 9;
					} else if (visitObj.getPriority() == 4) {
						visitObj.setPriority(7);
						priority = 7;
					} else if (visitObj.getPriority() == 5) {
						visitObj.setPriority(8);
						priority = 8;
					} else if (visitObj.getPriority() == 6) {
						visitObj.setPriority(9);
						priority = 9;
					} else if (visitObj.getPriority() == 7) {
						visitObj.setPriority(7);
						priority = 7;
					} else if (visitObj.getPriority() == 8) {
						visitObj.setPriority(8);
						priority = 8;
					} else if (visitObj.getPriority() == 9) {
						visitObj.setPriority(9);
						priority = 9;
					}
				}

				/*
				 * Code By Dipali Status m MA Waiting List (Direct from
				 * visit/reception) f MO Waiting List (forwarded from MA) md
				 * Commanding Waiting List (validate from MO) cd MB Opinion
				 * Waiting List (validate from Commanding) v Approving Authority
				 * Waiting List (validate from from MB Opinion) ap Confirming
				 * Authority Waiting List (validate from from Approving
				 * Authority) p Accepting Authority validated (validate from
				 * from Confirming Authority) fr Rejected By Mo (Display In MA
				 * Waiting List) mr Rejected By Approving Authority(Display In
				 * MB Opinion Waiting List) ar Rejected Confirming Authority
				 * (Display In Approving Authority Waiting List) pr Rejected
				 * Accepting Authority (Display In Confirming Authority Waiting
				 * List)
				 */
				masMedicalExaminationReportOnEntry = (MasMedicalExaminationReportOnEntry) hbt
						.load(MasMedicalExaminationReportOnEntry.class,
								medExamId);
				if (rejectStatus.equalsIgnoreCase("fr")) {
					visitObj.setMedStatus("w");
					hbt.update(visitObj);
					masMedicalExaminationReportOnEntry.setStatus("p");
					masMedicalExaminationReportOnEntry.setPriority(priority);
					masMedicalExaminationReportOnEntry.setRemarks(moRemarks);
				} else if (rejectStatus.equalsIgnoreCase("mr")) {
					masMedicalExaminationReportOnEntry.setRemarks(authRemarks);
					masMedicalExaminationReportOnEntry.setStatus("mr");
				} else if (rejectStatus.equalsIgnoreCase("ar")) {
					masMedicalExaminationReportOnEntry
							.setRemarks(confirmRemarks);
					masMedicalExaminationReportOnEntry.setStatus("ar");
				} else if (rejectStatus.equalsIgnoreCase("pr")) {
					masMedicalExaminationReportOnEntry
							.setRemarks(acceptRemarks);
					masMedicalExaminationReportOnEntry.setStatus("pr");
				}

				hbt.update(masMedicalExaminationReportOnEntry);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	// --------------------Dinesh Dubey
	// -----------------------------------------
	public Map<String, Object> getMedicalBoardDetailsForSearch(
			Map<String, Object> mapfordata) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int commandId = 0;
		List<MasMedicalExaminationReportOnEntry> medicalDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		String serviceNo = null;
		if (mapfordata.get("serviceNo") != null) {
			serviceNo = (String) mapfordata.get("serviceNo");
		}

		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.eq("medicalType", "MedicalBoard")).add(
						Restrictions.eq("YearlySerialNo", serviceNo)).add(
						Restrictions.eq("Status", "v")).addOrder(
						Order.desc("DateOfReporting"));
		medicalDetailList = crit.list();
		map.put("medicalDetailList", medicalDetailList);

		return map;

	}

	@Override
	public Map<String, Object> validateMBOpinion(Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = 0;
		int visitId = 0;
		int medExamId = 0;
		if (mapForDS.get("visitId") != null) {
			visitId = (Integer) mapForDS.get("visitId");
		}
		if (mapForDS.get("medExamId") != null) {
			medExamId = (Integer) mapForDS.get("medExamId");
		}
		int deptId = 0;
		if (mapForDS.get("deptId") != null) {
			deptId = (Integer) mapForDS.get("deptId");
		}
		int counter = 0;
		if (mapForDS.get("counter") != null) {
			counter = (Integer) mapForDS.get("counter");
		}
		Box box = null;
		if (mapForDS.get("box") != null) {
			box = (Box) mapForDS.get("box");
		}
		String releaseCatPeriod="";
		int releaseMedCat=0;
		if(mapForDS.get("releaseCatPeriod") !=null){
			releaseCatPeriod=(String)mapForDS.get("releaseCatPeriod");		
		}
		if(mapForDS.get("releaseMedCat") !=null){
			releaseMedCat=(Integer)mapForDS.get("releaseMedCat");		
		}
		List<MasMedicalExaminationDetail> masMedicalExaminationDetailsDisabilityList = new ArrayList<MasMedicalExaminationDetail>();
		if (mapForDS.get("masMedicalExaminationDetailsDisabilityList") != null) {
			masMedicalExaminationDetailsDisabilityList = (List<MasMedicalExaminationDetail>) mapForDS
					.get("masMedicalExaminationDetailsDisabilityList");
		}
		MasMedicalExaminationReportOnEntry masMedicalExaminationReportOnEntry = new MasMedicalExaminationReportOnEntry();
		if (mapForDS.get("masMedicalBoardProceedings") != null) {
			masMedicalExaminationReportOnEntry = (MasMedicalExaminationReportOnEntry) mapForDS
					.get("masMedicalBoardProceedings");
		}
		MasMedicalExaminationDetail medicalExaminationDetails=new MasMedicalExaminationDetail();
		if (mapForDS.get("medicalExaminationDetail") != null) {
			medicalExaminationDetails = (MasMedicalExaminationDetail) mapForDS
					.get("medicalExaminationDetail");
		}
		List<MasMedicalExaminationDetail> masMedicalExaminationDetailsPrasentList = new ArrayList<MasMedicalExaminationDetail>();
		if (mapForDS.get("masMedicalExaminationDetailsPrasentList") != null) {
			masMedicalExaminationDetailsPrasentList = (List<MasMedicalExaminationDetail>) mapForDS
					.get("masMedicalExaminationDetailsPrasentList");
		}
		List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = (List<MasMedicalExaminationDetail>) mapForDS
				.get("masMedicalExaminationDetailList");
		List<MasMedicalExaminationDetail> masMedicalExaminationDetailsCronicalList = new ArrayList<MasMedicalExaminationDetail>();
		if (mapForDS.get("masMedicalExaminationDetailsCronicalList") != null) {
			masMedicalExaminationDetailsCronicalList = (List<MasMedicalExaminationDetail>) mapForDS
					.get("masMedicalExaminationDetailsCronicalList");
		}
		HibernateTemplate hbt = null;
		Transaction tx = null;
		Session session = (Session) getSession();
		boolean falg = false;
		try {
			tx = session.beginTransaction();
			hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masMedicalExaminationReportOnEntry);
			int inc = 0;
			// ----For present degree of disablement grid---

			if (masMedicalExaminationDetailsPrasentList != null
					&& masMedicalExaminationDetailsPrasentList.size() > 0) {
				for (MasMedicalExaminationDetail medicalExaminationObj : masMedicalExaminationDetailsPrasentList) {
					MasMedicalExaminationDetail medicalExaminationDetail = (MasMedicalExaminationDetail) hbt
							.load(MasMedicalExaminationDetail.class,
									medicalExaminationObj.getServiceid());
					if(medicalExaminationObj !=null && !medicalExaminationObj.equals("0")){
						
					if(medicalExaminationObj
							.getDisablementPercentage() !=null){
					medicalExaminationDetail
							.setDisablementPercentage(medicalExaminationObj
									.getDisablementPercentage());}
					if(medicalExaminationObj.getDisablementYear() !=null){
					medicalExaminationDetail.setDisablementYear(medicalExaminationObj.getDisablementYear());
					}if(medicalExaminationObj.getDisablementMonth() !=null){
					medicalExaminationDetail.setDisablementMonth(medicalExaminationObj.getDisablementMonth());}
					if(medicalExaminationObj.getDisablityCompositeAssessment() !=null){
					medicalExaminationDetail.setDisablityCompositeAssessment(medicalExaminationObj
									.getDisablityCompositeAssessment());}
					if(medicalExaminationObj.getDisablityPension() !=null){
					medicalExaminationDetail.setDisablityPension(medicalExaminationObj
									.getDisablityPension());}
					if(medicalExaminationObj
							.getDisablityPensionYear() !=null){
					medicalExaminationDetail
							.setDisablityPensionYear(medicalExaminationObj
									.getDisablityPensionYear());}
					if(medicalExaminationObj
							.getDisablityPensionMonth() !=null){
					medicalExaminationDetail
							.setDisablityPensionMonth(medicalExaminationObj
									.getDisablityPensionMonth());}
					if(medicalExaminationObj
							.getDisablityNetAssessment() !=null){
					medicalExaminationDetail.setDisablityNetAssessment(medicalExaminationObj
									.getDisablityNetAssessment());}
					if(medicalExaminationObj
							.getDisablityAssessmentYear() !=null){
					medicalExaminationDetail.setDisablityAssessmentYear(medicalExaminationObj
									.getDisablityAssessmentYear());}
					if(medicalExaminationObj.getDisablityAssessmentMonth() !=null){
					medicalExaminationDetail.setDisablityAssessmentMonth(medicalExaminationObj
									.getDisablityAssessmentMonth());}

					hbt.saveOrUpdate(medicalExaminationDetail);
					hbt.refresh(medicalExaminationDetail);
				}
				}
			}
			/*
			 * Code for Casual Relationship of the Disability with Service
			 * Conditions or Otherwise
			 */
			if (masMedicalExaminationDetailsDisabilityList.size() > 0) {
				for (MasMedicalExaminationDetail medicalExaminationObj : masMedicalExaminationDetailsDisabilityList) {
					MasMedicalExaminationDetail medicalExaminationDetail = (MasMedicalExaminationDetail) hbt
							.load(MasMedicalExaminationDetail.class,
									medicalExaminationObj.getServiceid());
					medicalExaminationDetail
							.setAttributeService(medicalExaminationObj
									.getAttributeService());
					medicalExaminationDetail
							.setAggravarteService(medicalExaminationObj
									.getAggravarteService());
					medicalExaminationDetail
							.setNotConnectService(medicalExaminationObj
									.getNotConnectService());
					medicalExaminationDetail
							.setReasonVariation(medicalExaminationObj
									.getReasonVariation());
					medicalExaminationDetail
							.setToServicePeriod(medicalExaminationObj
									.getToServicePeriod());
					medicalExaminationDetail
							.setFromServicePeriod(medicalExaminationObj
									.getFromServicePeriod());
					hbt.saveOrUpdate(medicalExaminationDetail);
					hbt.refresh(medicalExaminationDetail);
				}
			}
			if (masMedicalExaminationDetailsCronicalList.size() > 0) {
				for (MasMedicalExaminationDetail medicalExaminationObj : masMedicalExaminationDetailsCronicalList) {
					
					int medChroServiceId=0;
					if(medicalExaminationObj.getServiceid() !=null && !medicalExaminationObj.getServiceid().equals("0")){
					medChroServiceId=medicalExaminationObj.getServiceid();
					
					if (medChroServiceId > 0) {
						MasMedicalExaminationDetail medicalExaminationDetail = (MasMedicalExaminationDetail) hbt
								.load(MasMedicalExaminationDetail.class,
										medicalExaminationObj.getServiceid());

					/*	medicalExaminationDetail
								.setAttributeService(medicalExaminationObj
										.getAttributeService());
						medicalExaminationDetail
								.setAggravarteService(medicalExaminationObj
										.getAggravarteService());
						medicalExaminationDetail
								.setNotConnectService(medicalExaminationObj
										.getNotConnectService());
						medicalExaminationDetail
								.setReasonVariation(medicalExaminationObj
										.getReasonVariation());
						medicalExaminationDetail
								.setToServicePeriod(medicalExaminationObj
										.getToServicePeriod());
						medicalExaminationDetail
								.setFromServicePeriod(medicalExaminationObj
										.getFromServicePeriod());*///--Commented by dipali

						// medicalExaminationDetail.setServiceid(disablementServiceId);
						medicalExaminationDetail.setPrincipal(medicalExaminationObj.getPrincipal());
						if (medicalExaminationObj.getSystemDiagnosis() != null) {
						medicalExaminationDetail
						.setSystemDiagnosis(medicalExaminationObj.getSystemDiagnosis());
						}
						medicalExaminationDetail.setOrigindate(medicalExaminationObj.getOrigindate());
						if (medicalExaminationObj.getRankDisability() != null) {
							medicalExaminationDetail.setRankDisability(medicalExaminationObj
											.getRankDisability());
						}
						if (medicalExaminationObj.getUnitDisability() != null) {

							medicalExaminationDetail
									.setUnitDisability(medicalExaminationObj
											.getUnitDisability());
						}
						medicalExaminationDetail
								.setPlaceDisability(medicalExaminationObj
										.getPlaceDisability());
						medicalExaminationDetail.setParticular("Cronical");
						if (medExamId > 0) {
							MasMedicalExaminationReportOnEntry masMedicalObj = new MasMedicalExaminationReportOnEntry();
							masMedicalObj.setId(medExamId);
							medicalExaminationDetail.setMasMedicalReport(masMedicalObj);
						}
						hbt.update(medicalExaminationDetail);
						hbt.refresh(medicalExaminationDetail);
					} }else {
						hbt.save(medicalExaminationObj);
						hbt.refresh(medicalExaminationObj);
					}
				}
			}
			/*
			 * End of Code for Casual Relationship of the Disability with
			 * Service Conditions or Otherwise Code By Mukesh 12/04/2012
			 */
			
			//---------Update Med Cat,Duration ,Date in patient table---
			Date currentDate=new Date();
			Patient patientUpdate = (Patient)hbt.load(Patient.class, masMedicalExaminationReportOnEntry.getHin().getId());
			if(releaseMedCat>0){
				Category category2=new Category();
				category2.setCategoryid(releaseMedCat);
				patientUpdate.setCategory(category2);
			}
			if(releaseCatPeriod !=null){
				patientUpdate.setMedCatPeriod(releaseCatPeriod);
			}
			patientUpdate.setMedCatDate(currentDate);
			hbt.update(patientUpdate);
			//------------------------------------------------------------
			falg = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			falg = false;
			e.printStackTrace();
		}
		map.put("falg", falg);
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
	public Map<String, Object> showMedicalBoardSpecialist(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		// String[] statusArr = {"f","vr"};
		String[] statusArr = { "s", "sr", };
		//rankList = getHibernateTemplate().find(
				//"from jkt.hms.masters.business.MasRank ");
		rankList = session.createCriteria(MasRank.class).list();
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
			 .add(Restrictions.in("Status", statusArr)).add(Restrictions.eq("medicalType", "MedicalBoard"))
			 .createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.desc("Id"));

		patientDetailList = crit.list();
		map.put("patientDetailList", patientDetailList);
		map.put("rankList", rankList);

		return map;
	}

	@Override
	public Map<String, Object> getMedicalBoardDetail(Map<String, Object> mapfordata) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int commandId = 0;
		List<MasMedicalExaminationReportOnEntry> medicalDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;
		String serviceNo = null;
		if (mapfordata.get("serviceNo") != null) {
			serviceNo = (String) mapfordata.get("serviceNo");
		}
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
			.add(Restrictions.eq("medicalType", "MedicalBoard")).add(
			Restrictions.eq("YearlySerialNo", serviceNo)).add(Restrictions.eq("Status", "p")).addOrder(
					Order.asc("MediceExamDate"));
		medicalDetailList = crit.list();
		map.put("medicalDetailList", medicalDetailList);
		List<MasMedicalExaminationReportOnEntry> medicalExamReportDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<MasMedicalExaminationDetail> masMedicalExamDetailsList = new ArrayList<MasMedicalExaminationDetail>();

		medicalExamReportDetailList = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.eq("medicalType", "MedicalBoard")).add(
				Restrictions.eq("YearlySerialNo", serviceNo)).add(
				Restrictions.eq("Status", "p")).addOrder(Order.desc("Id")).list();
		
		if (medicalExamReportDetailList.size() > 0) {
			MasMedicalExaminationReportOnEntry masMedicalExamReport = medicalExamReportDetailList.get(0);
			masMedicalExamDetailsList = session.createCriteria(MasMedicalExaminationDetail.class)
					.add(Restrictions.eq("MasMedicalReport.Id", masMedicalExamReport.getId()))
					.add(Restrictions.eq("Particular", "particular")).list();
		}
		map.put("masMedicalExamDetailsList", masMedicalExamDetailsList);
		return map;

	}

	@Override
	public Map<String, Object> getPatientDetailAndAddMedicalBoard(
			String serviceNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			List<MasCommand> commandList = new ArrayList<MasCommand>();
			List<Category> categoryList = new ArrayList<Category>();
			List<Patient> patientList = session.createCriteria(Patient.class)
							.add(Restrictions.eq("ServiceNo", serviceNo)).list();
			map.put("patientList", patientList);
			categoryList = session.createCriteria(Category.class).list(); 
				//getHibernateTemplate().find("from jkt.hms.masters.business.Category ");
			map.put("categoryList", categoryList);
			commandList = session.createCriteria(MasCommand.class)
			.add(Restrictions.eq("Status","y"))
			.addOrder(Order.asc("CommandName")).list();
				//hbt.find("from MasCommand mas where mas.Status='y' order by mas.CommandName");
			map.put("commandList", commandList);
			List<PatientFamilyHistory> patientFamilyHistoryList = session
					.createCriteria(PatientFamilyHistory.class).add(Restrictions.eq("Status", "y")).list();
			map.put("patientFamilyHistoryList", patientFamilyHistoryList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> addOldMedicalBoardData(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		boolean status = false;
		int masMedicalExamReportId = 0;
		int visitId = 0;
		try {
			tx = session.beginTransaction();
			int hospitalId = (Integer) dataMap.get("hospitalId");
			String serviceNo = (String) dataMap.get("serviceNo");
			int hinId = (Integer) dataMap.get("hinId");
			String smokerMore10 = (String) dataMap.get("smokerMore10");
			String smokerLess10 = (String) dataMap.get("smokerLess10");
			String alcohol = (String) dataMap.get("alcohol");
			String allergies = (String) dataMap.get("allergies");
			String[] familyHistoryArray = (String[]) dataMap
					.get("familyHistoryArray");
			String otherFamilyHistory = (String) dataMap
					.get("otherFamilyHistory");
			map.put("hinId", hinId);
			Patient patient = (Patient) session.load(Patient.class, hinId);
			patient.setAlcohol(alcohol);
			patient.setSmokerLess10(smokerLess10);
			patient.setSmokerMore10(smokerMore10);
			patient.setDrugAllergies(allergies);
			patient.setOtherFamilyHistory(otherFamilyHistory);
			hbt.update(patient);

			int genderId = (Integer) dataMap.get("genderId");
			int rankId = (Integer) dataMap.get("rankId");
			String patientName = (String) dataMap.get("patientName");
			int tradeId = 0;
			if (dataMap.get("tradeId") != null) {
				tradeId = (Integer) dataMap.get("tradeId");
			}
			Date dateofcommun = (Date) dataMap.get("dateofcommun");
			Category presentMedicalCategory = (Category) dataMap
					.get("presentMedicalCatId");
			String lastAmePlace = (String) dataMap.get("lastAmePlace");
			int commandId = (Integer) dataMap.get("commandId");
			Date reportedDate = (Date) dataMap.get("reportedDate");
			Date lastAmeDate = (Date) dataMap.get("lastAmeDate");
			String period = (String) dataMap.get("period");
			String waiver = (String) dataMap.get("waiver");
			String medExamType = (String) dataMap.get("medExamType");
			int unitId = (Integer) dataMap.get("unitId");
			BigDecimal height = (BigDecimal) dataMap.get("height");
			BigDecimal weight = (BigDecimal) dataMap.get("weight");
			BigDecimal idealWeight = (BigDecimal) dataMap.get("idealWeight");
			BigDecimal overWeight = (BigDecimal) dataMap.get("overWeight");
			// int deptId=(Integer)dataMap.get("deptId");
			String lastChangedBy = (String) dataMap.get("lastChangedBy");
			Date lastChangedDate = (Date) dataMap.get("lastChangedDate");
			String lastChangedTime = (String) dataMap.get("lastChangedTime");
			List<String> systemDiagnosisList = (List<String>) dataMap
					.get("systemDiagnosisList");
			List<Integer> systemDiagnosisIdList = (List<Integer>) dataMap
					.get("systemDiagnosisIdList");
			List<Visit> visitList = getVisitNo(patient.getHinNo());
			int visitNo = 1;
			Users user = (Users) dataMap.get("user");
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);

			if (visitList != null && visitList.size() > 0) {
				Visit visit = visitList.get(0);
				visitNo = visit.getVisitNo() + 1;
			}
			Visit visit = new Visit();
			visit.setHin(patient);
			visit.setVisitNo(visitNo);
			visit.setTokenNo(0);
			visit.setHospital(hospital);
			visit.setAge(patient.getAge());
			visit.setStatus("y");
			visit.setAppointmentType("D");
			visit.setMedExamType(medExamType);
			visit.setVisitStatus("c");
			visit.setMedStatus("f");
			visit.setReportingFor("MedBoard");
			visit.setAddEditBy(user);
			visit.setVisitDate(lastChangedDate);
			visit.setAddEditDate(lastChangedDate);
			visit.setAddEditTime(lastChangedTime);
			visit.setVisitTime(lastChangedTime);
			hbt.save(visit);
			map.put("visitId", visit.getId());
			MasMedicalExaminationReportOnEntry masMedicalExamReport = new MasMedicalExaminationReportOnEntry();
			masMedicalExamReport.setHospital(hospital);
			masMedicalExamReport.setAdmissionStatus("n");
			masMedicalExamReport.setSpecialistOpinnionStatus("n");
			masMedicalExamReport.setServiceNo(serviceNo);
			masMedicalExamReport.setYearlySerialNo(serviceNo);
			// Patient patient=new Patient();
			patient.setId(hinId);
			masMedicalExamReport.setHin(patient);
			MasRank rank = new MasRank();
			rank.setId(rankId);
			masMedicalExamReport.setRank(rank);
			// MasAdministrativeSex sex=new MasAdministrativeSex();
			// sex.setId(genderId);visit
			masMedicalExamReport.setVisit(visit);
			masMedicalExamReport.setNameInFull(patientName);
			if (tradeId > 0) {
				MasTrade trade = new MasTrade();
				trade.setId(tradeId);
				masMedicalExamReport.setTrade(trade);
			}
			masMedicalExamReport.setDateofcommun(dateofcommun);
			masMedicalExamReport
					.setPresentMedicalCategory(presentMedicalCategory);
			masMedicalExamReport.setLastame(lastAmePlace);
			MasCommand command = new MasCommand();
			command.setId(commandId);
			masMedicalExamReport.setCommand(command);
			masMedicalExamReport.setDateOfReporting(reportedDate);
			masMedicalExamReport.setDateMedicalBoardSubsequent(lastAmeDate);
			masMedicalExamReport.setPeriod(period);
			// masMedicalExamReport.setAggravMaterialPeriod(period);
			masMedicalExamReport.setWaiver(waiver);
			masMedicalExamReport.setMedicalExamType(medExamType);
			if (unitId > 0) {
				MasUnit unit = new MasUnit();
				unit.setId(unitId);
				masMedicalExamReport.setUnit(unit);
			}
			masMedicalExamReport.setHeight(height);
			masMedicalExamReport.setWeight(weight);
			masMedicalExamReport.setIdealweight("" + idealWeight);
			masMedicalExamReport.setOverweight("" + overWeight);
			masMedicalExamReport.setAllergies(allergies);
			masMedicalExamReport.setLastChangedBy(lastChangedBy);
			masMedicalExamReport.setLastChangedDate(lastChangedDate);
			masMedicalExamReport.setLastChangedTime(lastChangedTime);
			masMedicalExamReport.setStatus("p");
			masMedicalExamReport.setMedicalType("MedicalBoard");
			hbt.save(masMedicalExamReport);
			// List<String>
			// systemDiagnosisList=(List<String>)dataMap.get("systemDiagnosisIdList");
			// List<Integer>
			// systemDiagnosisIdList=(List<Integer>)dataMap.get("systemDiagnosisList");
			for (int i = 0; i < systemDiagnosisList.size(); i++) {
				MasMedicalExaminationDetail masMedicalExaminationDetail = new MasMedicalExaminationDetail();
				masMedicalExaminationDetail.setIllness(systemDiagnosisList
						.get(i));
				masMedicalExaminationDetail.setParticular("particular");
				if (systemDiagnosisIdList.get(i) != null) {
					MasSystemDiagnosis masSystemDiagnosis = new MasSystemDiagnosis();
					masSystemDiagnosis.setId(systemDiagnosisIdList.get(i));
					masMedicalExaminationDetail.setSystemDiagnosis(masSystemDiagnosis);
				}

				masMedicalExaminationDetail.setMasMedicalReport(masMedicalExamReport);
				hbt.save(masMedicalExaminationDetail);

			}
			if (familyHistoryArray != null && familyHistoryArray.length > 0) {
				for (String familyHistory : familyHistoryArray) {
					int familyHistoryId = Integer.parseInt(familyHistory);
					if (familyHistoryId != 0) {
						List<MasMedicalExamFamilyHis> existingFamilyHis = new ArrayList<MasMedicalExamFamilyHis>();
						existingFamilyHis = session
								.createCriteria(MasMedicalExamFamilyHis.class).createAlias("Hin", "h")
								.add(Restrictions.eq("h.Id", hinId)).createAlias("PatientFamilyHistory", "pfh")
								.add(Restrictions.eq("pfh.Id", familyHistoryId)).list();
								
						if (existingFamilyHis.size() == 0) {
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
			masMedicalExamReportId = masMedicalExamReport.getId();
			status = true;
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("masMedicalExamReportId", masMedicalExamReportId);
		map.put("status", status);
		return map;
	}

	@SuppressWarnings("unchecked")
	public List<Visit> getVisitNo(String hinNo) {
		Session session = (Session) getSession();
		List<Visit> visitList = new ArrayList<Visit>();
		try {
			visitList = session.createCriteria(Visit.class).createAlias("Hin","p").
					add(Restrictions.eq("p.HinNo", hinNo)).addOrder(Order.desc("VisitNo")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return visitList;
	}

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
	public Map<String, Object> getSystemDiagList(Map<String, Object> map) {
		List<MasIcd> itemList = new ArrayList<MasIcd>();
		Session session = (Session) getSession();
		try {
			String str =(String)map.get("autoHint") + "%";
	//String query = "from MasSystemDiagnosis as icd where upper (icd.SystemDiagnosisName) like upper('" + str
		//			+ "')";
			//Query q = session.createQuery(query);
			//q.setFirstResult(0);
			//q.setMaxResults(10);
			itemList = session.createCriteria(MasIcd.class)
			.add(Restrictions.like("IcdName", str).ignoreCase()).setMaxResults(10).list();
				//q.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	@Override
	public Map<String, Object> getMedicalExamDetails(
			Map<String, Object> mapfordata) {
		
		System.out.println("Inside");
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int commandId = 0;
		List<MasMedicalExaminationReportOnEntry> medicalDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<MasEmployee> sessionEmpList = new ArrayList<MasEmployee>();
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
        int sessionUnitId=0;
        sessionEmpList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Id", empId)).list();
        if(sessionEmpList.size() >0){
        	for(MasEmployee masEmployee:sessionEmpList){
        		sessionUnitId=masEmployee.getUnit().getId();
        	}
        }
        List<Patient> employeeList = new ArrayList<Patient>();
        employeeList=session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();
        int unitId = 0;
        if(employeeList.size() >0){
        	for(Patient patient :employeeList){
        		unitId=patient.getUnit().getId();
        	}
        }
        System.out.println("sessionUnitId="+sessionUnitId);
        System.out.println("unitId="+unitId);
        map.put("unitId",sessionUnitId);
        List<MasMedicalExaminationReportOnEntry> medicalExamReportDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
        List<MasMedicalExaminationDetail> masMedicalExamDetailsList = new ArrayList<MasMedicalExaminationDetail>();
        //if(sessionUnitId == unitId){
        if(true){
        	
     
	    
	    /**
	     * Added By Ritu
	     */
		List<MasMedicalExaminationReportOnEntry> medicalExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<MasMedicalExaminationReportOnEntry> medicalBoardList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		
		medicalExamList =  session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("medicalType", "MedicalExam"))
						.add(Restrictions.eq("ServiceNo", serviceNo))
						.addOrder(Order.asc("DateOfReporting")).add(Restrictions.eq("Status","f")).list();
		
		System.out.println("medicalExamList="+medicalExamList.size());
		
		medicalBoardList =  session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("medicalType", "MedicalBoard"))
						.add(Restrictions.eq("ServiceNo", serviceNo))
						.addOrder(Order.asc("DateOfReporting")).add(Restrictions.eq("Status","p")).list();
		
		System.out.println("medicalBoardList="+medicalBoardList.size());
	
		if(medicalExamList.size() >0){
			medicalDetailList.addAll(medicalExamList);
		}
		if(medicalBoardList.size() >0){
			medicalDetailList.addAll(medicalBoardList);
			
		}
	
        map.put("medicalDetailList", medicalDetailList);
       System.out.println("medicalDetailList="+medicalDetailList.size());
        
        if(medicalDetailList.size()>0)
        {
        	masMedicalExamDetailsList=session.createCriteria(MasMedicalExaminationDetail.class).createAlias("MasMedicalReport", "mmr")
    			.add(Restrictions.eq("Particular", "detail")).add(Restrictions.eq("mmr.ServiceNo", serviceNo)).list();
        	/*
        	 *   List<String> disabilityList = new ArrayList<String>();
        		List<Integer> disabilityIdList = new ArrayList<Integer>();
        	 * for(MasMedicalExaminationReportOnEntry medicalExamReport:medicalDetailList)
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
        	}
        	map.put("disabilityList",disabilityList);
        	map.put("disabilityIdList",disabilityIdList);
          */
        }
        }
        map.put("masMedicalExamDetailsList",masMedicalExamDetailsList);
        return map;

	}

	/*@Override
	public Map<String, Object> saveMIDData1(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		boolean saved = false;
		int masMedicalExamReportId = 0;
		int visitId = 0;
		try {
			tx = session.beginTransaction();
			int hospitalId = (Integer) dataMap.get("hospitalId");
			String serviceNo = (String) dataMap.get("serviceNo");
			int hinId = (Integer) dataMap.get("hinId");
			map.put("hinId", hinId);
			Patient patient = (Patient) session.load(Patient.class, hinId);
			String smokerMore10 = (String) dataMap.get("smokerMore10");
			String smokerLess10 = (String) dataMap.get("smokerLess10");
			String alcohol = (String) dataMap.get("alcohol");
			String allergies = (String) dataMap.get("allergies");
			String[] familyHistoryArray = (String[]) dataMap
					.get("familyHistoryArray");
			String otherFamilyHistory = (String) dataMap
					.get("otherFamilyHistory");
			patient.setAlcohol(alcohol);
			patient.setSmokerLess10(smokerLess10);
			patient.setSmokerMore10(smokerMore10);
			patient.setDrugAllergies(allergies);
			patient.setOtherFamilyHistory(otherFamilyHistory);
			hbt.update(patient);

			int genderId = (Integer) dataMap.get("genderId");
			int rankId = (Integer) dataMap.get("rankId");
			String patientName = (String) dataMap.get("patientName");
			int tradeId = 0;
			if (dataMap.get("tradeId") != null) {
				tradeId = (Integer) dataMap.get("tradeId");
			}
			Date dateofcommun = (Date) dataMap.get("dateofcommun");
			Category presentMedicalCategory = (Category) dataMap.get("presentMedicalCatId");
			String lastAmePlace = (String) dataMap.get("lastAmePlace");
			Date reportedDate = (Date) dataMap.get("reportedDate");
			Date lastAmeDate = (Date) dataMap.get("lastAmeDate");
			String period = (String) dataMap.get("period");
			String waiver = (String) dataMap.get("waiver");
			int commandId = (Integer) dataMap.get("commandId");
			String medExamType = (String) dataMap.get("medExamType");
			int unitId = (Integer) dataMap.get("unitId");
			BigDecimal height = (BigDecimal) dataMap.get("height");
			BigDecimal weight = (BigDecimal) dataMap.get("weight");
			BigDecimal idealWeight = (BigDecimal) dataMap.get("idealWeight");
			BigDecimal overWeight = (BigDecimal) dataMap.get("overWeight");
			// int deptId=(Integer)dataMap.get("deptId");
			String lastChangedBy = (String) dataMap.get("lastChangedBy");
			Date lastChangedDate = (Date) dataMap.get("lastChangedDate");
			String lastChangedTime = (String) dataMap.get("lastChangedTime");
			List<String> systemDiagnosisList = (List<String>) dataMap.get("systemDiagnosisList");
			List<Integer> systemDiagnosisIdList = (List<Integer>) dataMap.get("systemDiagnosisIdList");
			List<Visit> visitList = getVisitNo(patient.getHinNo());
			int visitNo = 1;
			Users user = (Users) dataMap.get("user");
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);

			if (visitList != null && visitList.size() > 0) {
				Visit visit = visitList.get(0);
				visitNo = visit.getVisitNo() + 1;
			}
			Visit visit = new Visit();
			visit.setHin(patient);
			visit.setVisitNo(visitNo);
			visit.setTokenNo(0);
			visit.setHospital(hospital);
			visit.setAge(patient.getAge());
			visit.setStatus("y");
			visit.setAppointmentType("D");
			visit.setMedExamType(medExamType);
			visit.setVisitStatus("c");
			visit.setMedStatus("f");
			visit.setReportingFor("MedBoard");
			visit.setAddEditBy(user);
			visit.setVisitDate(lastChangedDate);
			visit.setAddEditDate(lastChangedDate);
			visit.setAddEditTime(lastChangedTime);
			visit.setVisitTime(lastChangedTime);
			hbt.save(visit);
			map.put("visitId", visit.getId());
			MasMedicalExaminationReportOnEntry masMedicalExamReport = new MasMedicalExaminationReportOnEntry();
			masMedicalExamReport.setHospital(hospital);
			masMedicalExamReport.setAdmissionStatus("n");
			//masMedicalExamReport.setSpecialistOpinnionStatus("n");
			masMedicalExamReport.setServiceNo(serviceNo);
			masMedicalExamReport.setYearlySerialNo(serviceNo);
			// Patient patient=new Patient();
			patient.setId(hinId);
			masMedicalExamReport.setHin(patient);
			MasRank rank = new MasRank();
			rank.setId(rankId);
			masMedicalExamReport.setRank(rank);
			// MasAdministrativeSex sex=new MasAdministrativeSex();
			// sex.setId(genderId);visit
			masMedicalExamReport.setVisit(visit);
			masMedicalExamReport.setNameInFull(patientName);
			if (tradeId > 0) {
				MasTrade trade = new MasTrade();
				trade.setId(tradeId);
				masMedicalExamReport.setTrade(trade);
			}
			masMedicalExamReport.setDateofcommun(dateofcommun);
			masMedicalExamReport
					.setPresentMedicalCategory(presentMedicalCategory);
			MasCommand command = new MasCommand();
			command.setId(commandId);
			masMedicalExamReport.setCommand(command);
			
			masMedicalExamReport.setLastame(lastAmePlace);
			masMedicalExamReport.setDateOfReporting(reportedDate);
			masMedicalExamReport.setPeriod(period);
			masMedicalExamReport.setWaiver(waiver);
			masMedicalExamReport.setMedicalExamType(medExamType);
			if (unitId > 0) {
				MasUnit unit = new MasUnit();
				unit.setId(unitId);
				masMedicalExamReport.setUnit(unit);
			}
			masMedicalExamReport.setHeight(height);
			masMedicalExamReport.setWeight(weight);
			masMedicalExamReport.setIdealweight("" + idealWeight);
			masMedicalExamReport.setOverweight("" + overWeight);
			masMedicalExamReport.setLastChangedBy(lastChangedBy);
			masMedicalExamReport.setLastChangedDate(lastChangedDate);
			masMedicalExamReport.setLastChangedTime(lastChangedTime);
			masMedicalExamReport.setStatus("p");
			masMedicalExamReport.setMedicalType("MedicalBoard");
			hbt.save(masMedicalExamReport);
			for (int i = 0; i < systemDiagnosisList.size(); i++) {
				MasMedicalExaminationDetail masMedicalExaminationDetail = new MasMedicalExaminationDetail();
				masMedicalExaminationDetail.setPrincipal(systemDiagnosisList.get(i));
				masMedicalExaminationDetail.setParticular("detail");
				if (systemDiagnosisIdList.get(i) != null) {
					MasSystemDiagnosis masSystemDiagnosis = new MasSystemDiagnosis();
					masSystemDiagnosis.setId(systemDiagnosisIdList.get(i));
					masMedicalExaminationDetail.setSystemDiagnosis(masSystemDiagnosis);
				}
				masMedicalExaminationDetail.setMasMedicalReport(masMedicalExamReport);
				hbt.save(masMedicalExaminationDetail);

			}
			masMedicalExamReportId = masMedicalExamReport.getId();
			saved = true;
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("masMedicalExamReportId", masMedicalExamReportId);
		map.put("saved", saved);
		return map;
	}*/

	@Override
	public Map<String, Object> fillServiceDetail(Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasMedicalExaminationDetail> medicalDetailList = new ArrayList<MasMedicalExaminationDetail>();
		try {
		String str = "" + dataMap.get("serviceNo");
		Criteria c = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", str))
				.createAlias("Relation", "rel").add(Restrictions.eq("rel.RelationName", "Self"));
		patientList = c.list();
		map.put("patientList", patientList);
		
		medicalDetailList=session.createCriteria(MasMedicalExaminationDetail.class)
		.add(Restrictions.eq("Particular","detail")).createAlias("MasMedicalReport","mb")
		.add(Restrictions.eq("mb.ServiceNo", str)).addOrder(Order.desc("mb.DateOfReporting")).list();
		map.put("medicalDetailList",medicalDetailList);
		
		unitList=session.createCriteria(MasUnit.class).add(Restrictions.eq("Status","y")).list();
		map.put("unitList", unitList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	@Override
	public Map<String, Object> saveMIDData(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		boolean saved = false;
		String message="";
		int masMedicalExamReportId = 0;
		int visitId = 0;
		try {
			tx = session.beginTransaction();
			String serviceNo = (String) dataMap.get("serviceNo");
			int hospitalId = (Integer) dataMap.get("hospitalId");
			int deptId=(Integer)dataMap.get("deptId");
			int hinId = (Integer) dataMap.get("hinId");
			map.put("hinId", hinId);
			int genderId = (Integer) dataMap.get("genderId");
			int rankId = (Integer) dataMap.get("rankId");
			int commandId = 0;
			if (dataMap.get("commandId") != null) {
				commandId = (Integer) dataMap.get("commandId");
			}
			int unitId = (Integer) dataMap.get("unitId");
			Patient patient = (Patient) session.load(Patient.class, hinId);
			Date reportedDate = (Date) dataMap.get("reportedDate");
			Date lastChangedDate = (Date) dataMap.get("lastChangedDate");
			String patientName = (String) dataMap.get("patientName");
			String medcatId = (String) dataMap.get("medcatId");
			String waist = (String) dataMap.get("waist");
			String bp = (String) dataMap.get("bp");
			String lastChangedBy = (String) dataMap.get("lastChangedBy");
			String lastChangedTime = (String) dataMap.get("lastChangedTime");
			String systemDiagnosis=(String)dataMap.get("systemDiagnosis");
			BigDecimal height = (BigDecimal) dataMap.get("height");
			BigDecimal weight = (BigDecimal) dataMap.get("weight");
			List<String> systemDiagnosisList = (List<String>) dataMap.get("systemDiagnosisList");
			List<Integer> systemDiagnosisIdList = (List<Integer>) dataMap.get("systemDiagnosisIdList");
			
			List<MasMedicalExaminationDetail> medicalExamDetailList = new ArrayList<MasMedicalExaminationDetail>();
			medicalExamDetailList=session.createCriteria(MasMedicalExaminationDetail.class).
			add(Restrictions.eq("Principal", systemDiagnosis)).add(Restrictions.eq("Particular","detail"))
			.createAlias("MasMedicalReport","mb").add(Restrictions.eq("mb.ServiceNo", serviceNo))
			.add(Restrictions.eq("mb.DateOfReporting", reportedDate)).list();
			
			List<MasMedicalExaminationReportOnEntry> medicalExamReportList = new ArrayList<MasMedicalExaminationReportOnEntry>();
			medicalExamReportList=session.createCriteria(MasMedicalExaminationReportOnEntry.class).
			add(Restrictions.eq("ServiceNo", serviceNo)).add(Restrictions.eq("DateOfReporting", reportedDate))
			.list();
			
			if(medicalExamDetailList.size() >0){
				message="Data Already exist....";
				
			}else if(medicalExamReportList != null	&& medicalExamReportList.size() > 0){
				MasMedicalExaminationReportOnEntry masMedicalReport = medicalExamReportList.get(0);
				for (int i = 0; i < systemDiagnosisList.size(); i++) {
					MasMedicalExaminationDetail masMedicalExaminationDetail = new MasMedicalExaminationDetail();
					masMedicalExaminationDetail.setPrincipal(systemDiagnosisList.get(i));
					masMedicalExaminationDetail.setParticular("detail");
					if (systemDiagnosisIdList.get(i) != null) {
						MasSystemDiagnosis masSystemDiagnosis = new MasSystemDiagnosis();
						masSystemDiagnosis.setId(systemDiagnosisIdList.get(i));
						masMedicalExaminationDetail.setSystemDiagnosis(masSystemDiagnosis);
					}
					masMedicalExaminationDetail.setMasMedicalReport(masMedicalReport);
					hbt.save(masMedicalExaminationDetail);
				}
			}else{
			List<Visit> visitList = getVisitNo(patient.getHinNo());
			int visitNo = 1;
			Users user = (Users) dataMap.get("user");
			

			if (visitList != null && visitList.size() > 0) {
				Visit visit = visitList.get(0);
				visitNo = visit.getVisitNo() + 1;
			}
			Visit visit = new Visit();
			visit.setHin(patient);
			visit.setVisitNo(visitNo);
			visit.setTokenNo(0);
			
			
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			visit.setHospital(hospital);
			visit.setAge(patient.getAge());
			visit.setStatus("y");
			visit.setAppointmentType("D");
			visit.setVisitStatus("c");
			visit.setMedStatus("f");
		//	visit.setReportingFor("");
			visit.setAddEditBy(user);
			visit.setVisitDate(lastChangedDate);
			visit.setAddEditDate(lastChangedDate);
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			lastChangedTime = (String) utilMap.get("currentTimeWithoutSc");
			visit.setAddEditTime(lastChangedTime);
			visit.setVisitTime(lastChangedTime);
			hbt.save(visit);
			map.put("visitId", visit.getId());
			MasMedicalExaminationReportOnEntry masMedicalExamReport = new MasMedicalExaminationReportOnEntry();
			masMedicalExamReport.setHospital(hospital);
			masMedicalExamReport.setAdmissionStatus("n");
			//masMedicalExamReport.setSpecialistOpinnionStatus("n");
			masMedicalExamReport.setServiceNo(serviceNo);
			masMedicalExamReport.setYearlySerialNo(serviceNo);
			// Patient patient=new Patient();
			patient.setId(hinId);
			masMedicalExamReport.setHin(patient);
			MasRank rank = new MasRank();
			rank.setId(rankId);
			masMedicalExamReport.setRank(rank);
			// MasAdministrativeSex sex=new MasAdministrativeSex();
			// sex.setId(genderId);visit
			masMedicalExamReport.setVisit(visit);
			masMedicalExamReport.setNameInFull(patientName);
			MasCommand command = new MasCommand();
			command.setId(commandId);
			masMedicalExamReport.setCommand(command);
			
			masMedicalExamReport.setMedCatRec(medcatId);
			masMedicalExamReport.setDateOfReporting(reportedDate);
			if (unitId > 0) {
				MasUnit unit = new MasUnit();
				unit.setId(unitId);
				masMedicalExamReport.setUnit(unit);
			}
			masMedicalExamReport.setHeight(height);
			masMedicalExamReport.setWeight(weight);
			masMedicalExamReport.setWaist(waist);
			masMedicalExamReport.setBp(bp);
			masMedicalExamReport.setLastChangedBy(lastChangedBy);
			masMedicalExamReport.setLastChangedDate(lastChangedDate);
			masMedicalExamReport.setLastChangedTime(lastChangedTime);
			masMedicalExamReport.setStatus("p");
			hbt.save(masMedicalExamReport);
			for (int i = 0; i < systemDiagnosisList.size(); i++) {
				MasMedicalExaminationDetail masMedicalExaminationDetail = new MasMedicalExaminationDetail();
				masMedicalExaminationDetail.setPrincipal(systemDiagnosisList.get(i));
				masMedicalExaminationDetail.setParticular("detail");
				if (systemDiagnosisIdList.get(i) != null) {
					MasSystemDiagnosis masSystemDiagnosis = new MasSystemDiagnosis();
					masSystemDiagnosis.setId(systemDiagnosisIdList.get(i));
					masMedicalExaminationDetail.setSystemDiagnosis(masSystemDiagnosis);
				}
				masMedicalExaminationDetail.setMasMedicalReport(masMedicalExamReport);
				hbt.save(masMedicalExaminationDetail);

			}
			masMedicalExamReportId = masMedicalExamReport.getId();
			}
			saved = true;
			tx.commit();
			map.put("medicalExamDetailList",medicalExamDetailList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("masMedicalExamReportId", masMedicalExamReportId);
		map.put("saved", saved);
		return map;
	}

	@Override
	public Map<String, Object> showMidData() {
		Session session = (Session) getSession();
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	List<Category> categoryList=new ArrayList<Category>();
	unitList=session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
	categoryList=session.createCriteria(Category.class).addOrder(Order.asc("Categories")).list();
	map.put("unitList", unitList);
	map.put("categoryList",categoryList);
		return map;
	}

	@Override
	public Map<String, Object> updateMIDData(Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		boolean update = false;
		String message="";
		int medExamId= 0;
		int unitId=0;
		if(mapForDS.get("medExamId") !=null){
			medExamId = (Integer) mapForDS.get("medExamId");
		}
		if(mapForDS.get("unitId") !=null){
		unitId = (Integer) mapForDS.get("unitId");
		}
		MasMedicalExaminationReportOnEntry masMedExam = new MasMedicalExaminationReportOnEntry();
		try {

			masMedExam = (MasMedicalExaminationReportOnEntry) hbt.load(
					MasMedicalExaminationReportOnEntry.class, medExamId);
			if(unitId !=0){
			MasUnit masUnit=new MasUnit();
			masUnit.setId(unitId);
			masMedExam.setUnit(masUnit);
			}
			hbt.update(masMedExam);
			update=true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("update", update);
		return map;
	}

	@Override
	public Map<String, Object> showMedicalBoard16Jsp(Map<String, Object> dataMap) {
		List<Category> categoryList = new ArrayList<Category>();
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int medExamId = (Integer) dataMap.get("medExamId");
		int visitId = (Integer) dataMap.get("visitId");
		int hospitalId = (Integer) dataMap.get("hospitalId");
		try {
			List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
			List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
			medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).list();
			masMedicalExaminationDetailList = session.createCriteria(MasMedicalExaminationDetail.class)
			.createAlias("MasMedicalReport", "medReport").add(Restrictions.eq("medReport.Id", medExamId)).list();
			map.put("masMedicalExaminationDetailList",masMedicalExaminationDetailList);
			map.put("medExamList",medExamList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@Override
	public Map<String, Object> showPrintValidateMO(int hospitalId) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		Criteria crit = null;

		//String[] statusArr = { "v", "ar" };
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.eq("Status", "v")).add(Restrictions.eq("medicalType", "MedicalBoard"))
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
		//String[] statusArr = { "v", "ar" };
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
				.add(Restrictions.eq("Status", "v")).add(Restrictions.eq("medicalType", "MedicalBoard"))
				.add(Restrictions.eq("Visit.Id",visitId));

		medicalTypeList = crit.list();
		for(MasMedicalExaminationReportOnEntry medTypeReport:medicalTypeList){
			medicalType=medTypeReport.getVisit().getMedExamType();
		}
		map.put("medicalType", medicalType);
		map.put("medicalTypeList", medicalTypeList);

		return map;
	}

	/**
	 * Code By Ritu for search in perusing authority wait list
	 * 20 Nov 2012
	 */
	@Override
	public Map<String, Object> searchMedicalBoardPerAuthority(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> patientDetailAppAuthList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	    Criteria crit = null;
	    List<Object[]> unitList = null;
	    String[] statusArr = { "a" };
	    rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("ServiceType.Id", 2)).addOrder(Order.asc("RankName")).list(); // for airforce service type id is 2 
		
		crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
		.add(Restrictions.in("Status", statusArr)).add(Restrictions.eq("medicalType", "MedicalBoard"))
		.createAlias("Hospital", "h").add(Restrictions.eq("h.Id",  box.getInt("hospitalId")))
			.addOrder(Order.desc("Id"));;

		if(!box.getString(FROM_DATE).equals("") && !box.getString(TO_DATE).equals("")){
			crit = crit.add(Restrictions.between("DateOfReporting", HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)), HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE))));
		}
		if(box.getInt("rankId")!=0){
			crit = crit.add(Restrictions.eq("Rank.Id", box.getInt("rankId")));
		}
		if(box.getInt("unitId")!=0){
			crit = crit.add(Restrictions.eq("Unit.Id", box.getInt("unitId")));
		}
		
		patientDetailAppAuthList = crit.list();
		unitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(Order.asc("UnitName")).list();
		map.put("patientDetailAppAuthList", patientDetailAppAuthList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		return map;
		}

	//----Method for proceed Form 2A From Form -15 ---By Dipali---
	@Override
	public boolean initiateVisistFor2A(Map<String, Object> dataMap) {
		
		boolean successfullyAdded=false;
		Session session = (Session) getSession();
		Transaction tx=null;
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);  
		int medExamId=(Integer)dataMap.get("medExamId");
		int userId=(Integer)dataMap.get("userId");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String lastChangedTime = (String) utilMap.get("currentTimeWithoutSc");
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
			visit.setMedExamType("Primary/Extension Med. Exam(AFMSF-2A)");
			visit.setVisitStatus("c");
			visit.setMedStatus("w");
			visit.setReportingFor("MedExam");
			visit.setTokenDoctor("0#0");
			Users user=new Users();
			user.setId(userId);
			visit.setAddEditBy(user);
			visit.setVisitDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			visit.setVisitTime(lastChangedTime);
			visit.setAddEditDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			visit.setAddEditTime(lastChangedTime);
			hbt.save(visit);
		//	masExamEntry.setStatus("i");
			//hbt.update(masExamEntry);
			tx.commit();
			successfullyAdded=true;
		}catch (Exception e)
		{
			e.printStackTrace();
			tx.rollback();
			successfullyAdded=false;
		}
		return successfullyAdded;
	}

	@Override
	public Map<String, Object> getMedicalBoardList(
			Map<String, Object> parameters) {
		
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int visitId = (Integer) parameters.get("visit_id");
		List<MasMedicalExaminationDetail> examinationDetailList = new ArrayList<MasMedicalExaminationDetail>();
		examinationDetailList = session.createCriteria(MasMedicalExaminationDetail.class)
		.add(Restrictions.eq("Particular", "Detail")).createAlias("MasMedicalReport", "medReport")
		.createAlias("medReport.Visit", "vst").add(Restrictions.eq("vst.Id", visitId)).list();
		map.put("examinationDetailList",examinationDetailList);
		return map;
	}

	@Override
	public Map<String, Object> showMisMedBoardStatics(
			Map<String, Object> mapofds) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasMedicalExaminationReportOnEntry> patientDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		
		int commandId = 0;
		int rankId = 0;
		int unitId = 0;
		int commandid = 0;
		int tradeId = 0;
		int disabilityId = 0;
		int Interval = 0;
		int bloodid = 0;
		int disabilityGroupId = 0;
		String rejectStatus = "";
		String CategoryId = null;
		String AgeFrom = null;
		String to = null;
		String group1 = null;
		Date DateAson = null;
		String weight = null;
		String overWeight = null;
		String LifeStyleFactor = null;
		Date IntervalFrom = null;
		Date IntervalTo = null;
		String Gender = null;
		String searchType = null;
		String serviceNo = "";
		String icdDiag="";
		String obesity=null;
		Date fromDate = new Date();
		Date toDate = new Date();
		int icdId = 0;
		String overDue = "";
		int hospitalId=0;
		if(mapofds.get("hospitalId")!=null){
			hospitalId=(Integer)mapofds.get("hospitalId");
		}
		if(mapofds.get("icdId")!=null){
			icdId=(Integer)mapofds.get("icdId");
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
		int sectionId = 0;
		if(mapofds.get("sectionId")!=null){
			sectionId =(Integer)mapofds.get("sectionId");
		}
		if (mapofds.get("commandId") != null) {
			commandId = (Integer) mapofds.get("commandId");
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
					.add(Restrictions.eq("medicalType", "MedicalBoard"))
					.add(Restrictions.eq("Id", masMedicalExamDetail.getMasMedicalReport().getId()))
					.add(Restrictions.eq("Hospital.Id", hospitalId));
						//.add(Restrictions.eq("Status", "p"))	
		if(fromDate!=null && toDate!=null){
				crit = crit.add(Restrictions.between("DateOfCompletion",fromDate, toDate)); //normal date
				searchType = "search";
			}	
			if(fromrankId !=0 && toRankId !=0){
				crit = crit.createAlias("Rank", "r").add(Restrictions.between("r.Id", fromrankId, toRankId));
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
					if (rankCategoryId != 0) {
				crit = crit.createAlias("Rank", "r").createAlias("r.RankCategory", "rc").add(Restrictions.eq("rc.Id", rankCategoryId));
			}
			if (mapofds.get("unitId") != null) {unitId = (Integer) mapofds.get("unitId");
			}
			if (mapofds.get("tradeId") != null) {
				tradeId = (Integer) mapofds.get("tradeId");
				searchType = "search";
			}
			if (tradeId != 0) {
				crit = crit.createAlias("Trade", "t").add(Restrictions.eq("t.Id", tradeId));
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
			
			if (mapofds.get("Gender") != null) {
					Gender = (String) mapofds.get("Gender");
					searchType = "search";
				}
			if (Gender != null) {
				crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.Sex", "s").add(
						Restrictions.eq("s.AdministrativeSexName", Gender));
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

			if (sectionId != 0) {
				crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.Section", "section").add(Restrictions.eq("section.Id", sectionId));
			}
			if (mapofds.get("serviceNo") != null) {
				serviceNo = (String) mapofds.get("serviceNo");
				searchType = "search";
			}
			if(!serviceNo.equals("")){
				crit = crit.add(Restrictions.eq("ServiceNo", serviceNo));
				searchType = "search";
			}
					if (mapofds.get("overWeight") != null) {
				overWeight = (String) mapofds.get("overWeight");

			}
			/*if (overWeight != null && overWeight.equalsIgnoreCase("y")) {
				crit = crit.add(Restrictions.isNotNull("Overweight")).add(Restrictions.ne("Overweight",""));
				searchType = "search";
			}	*/
					
			
		   if (overWeight != null && overWeight.equalsIgnoreCase("1")) 
		   {
			 crit = crit.add(Restrictions.sqlRestriction("to_number(overweight)>=20.0 and to_number(overweight)<=30.0"));
			 searchType = "search";
			}
			System.out.println("overDue---->"+overDue);
			if (overDue != null && overDue.equalsIgnoreCase("1")) {
				crit = crit.add(Restrictions.sqlRestriction("select TRUNC(MONTHS_BETWEEN(TO_DATE(next_board_date, 'dd-mon-yyyy'), TO_DATE(sysdate,  'dd-mon-yyyy'))) from mas_medical_examination_report where TRUNC(MONTHS_BETWEEN(TO_DATE(next_board_date, 'dd-mon-yyyy'), TO_DATE(sysdate,  'dd-mon-yyyy'))) <=3 and select TRUNC(MONTHS_BETWEEN(TO_DATE(next_board_date, 'dd-mon-yyyy'), TO_DATE(sysdate,  'dd-mon-yyyy'))) from mas_medical_examination_report where TRUNC(MONTHS_BETWEEN(TO_DATE(next_board_date, 'dd-mon-yyyy'), TO_DATE(sysdate,  'dd-mon-yyyy'))) >0"));
				searchType = "search";
			}	System.out.println("crit --in ovwerdue---->"+crit.list().size());
			if (obesity != null && obesity.equalsIgnoreCase("o")) {
				crit = crit.add(Restrictions.eq("SD", "> + 3"));
				searchType = "search";
			}	
				
			
			if(rejectStatus !=null && !rejectStatus.equals("") && rejectStatus.equalsIgnoreCase("r")){
				List lst = new ArrayList();
				lst.add("fr");lst.add("vr");lst.add("ar");lst.add("nr");lst.add("mr");
				lst.add("ar");lst.add("pr");
				
				if(fromDate!=null && toDate!=null){
					crit = crit.add(Restrictions.in("Status", lst)).add(Restrictions.between("RejectDate",fromDate, toDate)); //reject date
					searchType = "search";
				}
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
			crit = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
					//.add(Restrictions.eq("Status", "f"))
					.add(Restrictions.eq("medicalType", "MedicalBoard"))
					.add(Restrictions.eq("Hospital.Id", hospitalId));;
			
			if(fromDate!=null && toDate!=null){
				crit = crit.add(Restrictions.between("DateOfCompletion",fromDate, toDate)); //normal date
				searchType = "search";
			}	
			if(fromrankId !=0 && toRankId !=0){
				crit = crit.createAlias("Rank", "r").add(Restrictions.between("r.Id", fromrankId, toRankId));
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
			
		/*if (fromTotalService != null && toTotalService != null && fromServUnit !=null && toServUnit !=null) {
		if (fromTotalService != null && toTotalService != null && fromServUnit !=null && toServUnit !=null) {
				crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h")
				.add(Restrictions.gt("h.ServiceYears", fromServUnit))
				.add(Restrictions.gt("h.TotalServicePeriod", fromServUnit))
				.add(Restrictions.lt("h.ServiceYears", toServUnit))
				.add(Restrictions.lt("h.TotalServicePeriod", toServUnit));
				searchType = "search";
			}*/
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
			}
			if (mapofds.get("unitId") != null) {unitId = (Integer) mapofds.get("unitId");
			}
			if (mapofds.get("tradeId") != null) {
				tradeId = (Integer) mapofds.get("tradeId");
				searchType = "search";
			}
			if (tradeId != 0) {
				crit = crit.createAlias("Trade", "t").add(Restrictions.eq("t.Id", tradeId));
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
			
			if (mapofds.get("Gender") != null) {
					Gender = (String) mapofds.get("Gender");
					searchType = "search";
				}
			if (Gender != null) {
				crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.Sex", "s").add(
						Restrictions.eq("s.AdministrativeSexName", Gender));
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

			if (sectionId != 0) {
				crit = crit.createAlias("Visit", "v").createAlias("v.Hin","h").createAlias("h.Section", "section").add(Restrictions.eq("section.Id", sectionId));
			}
			if (mapofds.get("serviceNo") != null) {
				serviceNo = (String) mapofds.get("serviceNo");
				searchType = "search";
			}
			if(!serviceNo.equals("")){
				crit = crit.add(Restrictions.eq("ServiceNo", serviceNo));
				searchType = "search";
			}
				if (mapofds.get("overWeight") != null) {
				overWeight = (String) mapofds.get("overWeight");
			}
				System.out.println("overWeight="+overWeight);
			if (overWeight != null && overWeight.equalsIgnoreCase("1")) {
				//crit = crit.add(Restrictions.isNotNull("Overweight")).add(Restrictions.ne("Overweight",""));
				crit = crit.add(Restrictions.sqlRestriction("to_number(overweight)>=20.0 and to_number(overweight)<=30.0"));
				searchType = "search";
			}	
			if (overDue != null && overDue.equalsIgnoreCase("1")) {
			//	crit = crit.add(Restrictions.sqlRestriction("TRUNC(MONTHS_BETWEEN(TO_DATE(next_board_date, 'dd-mon-yyyy'), TO_DATE(date_of_completion,  'dd-mon-yyyy'))) <=3 and TRUNC(MONTHS_BETWEEN(TO_DATE(next_board_date, 'dd-mon-yyyy'), TO_DATE(date_of_completion,  'dd-mon-yyyy'))) >0"));
				crit = crit.add(Restrictions.sqlRestriction("TRUNC(MONTHS_BETWEEN(TO_DATE(next_board_date, 'dd-mon-yyyy'), TO_DATE(date_of_completion,  'dd-mon-yyyy'))) <=3 "));
				searchType = "search";
			}	
			if (obesity != null && obesity.equalsIgnoreCase("o")) {
				crit = crit.add(Restrictions.eq("SD", "> + 3"));
				searchType = "search";
			}	
		
			
				if(rejectStatus !=null && !rejectStatus.equals("") && rejectStatus.equalsIgnoreCase("r")){
					List lst = new ArrayList();
					lst.add("fr");lst.add("vr");lst.add("ar");lst.add("nr");lst.add("mr");
					lst.add("ar");lst.add("pr");
					
				//	crit = crit.add(Restrictions.eq("RejectStatus", lst));
					if(fromDate!=null && toDate!=null){
						crit = crit.add(Restrictions.in("Status", lst)).add(Restrictions.between("RejectDate",fromDate, toDate)); //reject date
						searchType = "search";
					}
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
				

			/*
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
			 */
			/*
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
			 */

			/*
			 * if(mapofds.get("searchtype")!=null &&
			 * mapofds.get("searchtype").equals("search")) {
			 * 
			 * }
			 */
			if (searchType != null) {
				patientDetailList = crit.list();
			}
		}
		map.put("patientDetailList", patientDetailList);
		System.out.println("patientDetailList="+patientDetailList.size());

		return map;
	}

//--------Start By Mansi on 13 March 2013
	
	public Map<String, Object> showMedBoardForm10(Map<String, Object> mapForDS) {
		List<Visit> visit = null;

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int visitId = (Integer) mapForDS.get("visitId");
		int deptId = (Integer) mapForDS.get("deptId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		String medExamType = (String)mapForDS.get("medExamType");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		//visit = hbt.find("from Visit as v where v.Id='" + visitId + "'");
		visit=session.createCriteria(Visit.class).add(Restrictions.eq("Id", visitId)).list();
		int medExamId = (Integer) mapForDS.get("medExamId");
		List<MasMedicalExaminationReportOnEntry> medExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		if (medExamId != 0) {
			medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(
					Restrictions.idEq(medExamId)).add(Restrictions.eq("Status", "m").ignoreCase()).list();
		} else {
			medExamList = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
					.add(Restrictions.eq("Visit.Id", visitId)).add(Restrictions.eq("Status", "p").ignoreCase()).list();
		}

		Visit visitdata = null;

		if (visit != null && visit.size() > 0) {
			visitdata = visit.get(0);
		}
		int hinId = 0;
		hinId = visitdata.getHin().getId();
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

		List<MasTrade> tradeList = null;
		tradeList = session.createCriteria(MasTrade.class).addOrder(Order.asc("TradeName")).list();
		
		map.put("employeeList", employeeList);
		map.put("medExamList", medExamList);
		map.put("visit", visit);
		map.put("tradeList", tradeList);	

		return map;
	}

	@Override
	public Map<String, Object> addMedicalBoardForm10(
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings,int visitId) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(masMedicalBoardProceedings);
		
		Visit visit = (Visit) hbt.load(Visit.class, visitId);
		visit.setMedStatus("f");
		hbt.update(visit);
		
		successfullyAdded = true;
		map.put("medExamId", masMedicalBoardProceedings.getId());
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
	public Map<String, Object> autoCompleteForIcdDiagnosis(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasIcd> icdDiagnosisList = new ArrayList<MasIcd>();
		try {
			String icdName = "%" + dataMap.get("autoHint") + "%";
			icdDiagnosisList  = session.createCriteria(MasIcd.class)
			.add(Restrictions.like("IcdName", icdName).ignoreCase()).list();
			
			map.put("icdDiagnosisList", icdDiagnosisList);
			} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	
	
	//------by kiran form 44
	

	public Map<String, Object> showMbForm44JSP(Map<String, Object> generalMap) 
	{
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
			
		List<Visit> visit = null;
	
		int visitId=0;
		if(generalMap.get("visitId") != null )
		{
			visitId = (Integer)generalMap.get("visitId");
		}
		
		try {
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		//	visit =hbt.find("from Visit as v where v.Id='"+visitId+"'");
			visit=session.createCriteria(Visit.class).add(Restrictions.eq("Id", visitId)).list();					
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("visit", visit);

		return map;
	}
	
	public boolean submitMedicalBoardForm44(Map map)
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

	
//------form 44 interme
	
	public Map<String, Object> showMbForm44IntermeJSP(Map<String, Object> generalMap) 
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
		//	visit =hbt.find("from Visit as v where v.Id='"+visitId+"'");
			visit=session.createCriteria(Visit.class).add(Restrictions.eq("Id", visitId)).list();						
						
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("visit", visit);

		return map;

	}
	
	public boolean submitMedicalExamForm44Interme(Map map)
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

}
 