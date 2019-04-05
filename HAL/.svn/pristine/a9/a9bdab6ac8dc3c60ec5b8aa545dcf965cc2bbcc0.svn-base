package jkt.hms.fwc.dataservice;

import java.awt.Color;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadFile;

import static jkt.hms.util.RequestConstants.*;
import jkt.hms.masters.business.AvPilotRegistrationDt;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgResultEntryDetail;
import jkt.hms.masters.business.DgResultEntryHeader;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.FamilyPlanning;
import jkt.hms.masters.business.FwcDeliveryDetails;
import jkt.hms.masters.business.FwcGrowthChart;
import jkt.hms.masters.business.InjAppointmentDetails;
import jkt.hms.masters.business.InjAppointmentHeader;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.IpdTemperature;
import jkt.hms.masters.business.MasAircraftType;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasChildMilestone;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDisposal;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasImmunization;
import jkt.hms.masters.business.MasLocation;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasMedicalExamFamilyHis;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.masters.business.MasMedicalUploadDocument;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasStation;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemConversion;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasSystemDiagnosis;
import jkt.hms.masters.business.MasTherapyType;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.OpdPatientHistory;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientChildMilestoneDetail;
import jkt.hms.masters.business.PatientDetentionRegister;
import jkt.hms.masters.business.PatientFamilyHistory;
import jkt.hms.masters.business.PatientImmunizationDetails;
import jkt.hms.masters.business.PatientInvestigationDetails;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.PhysioRequisitionHeader;
import jkt.hms.masters.business.PhysioVisitEntryDetail;
import jkt.hms.masters.business.PhysioVisitEntryHeader;
import jkt.hms.masters.business.ProcedureHeader;
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
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lowagie.text.pdf.ByteBuffer;





public class FWCDataServiceImpl extends HibernateDaoSupport implements FWCDataService {

	@SuppressWarnings( { "unused", "unchecked" })
	public Map<String, Object> getWaitingPatientList(Map mapForDS) {

		Session session = (Session) getSession();
		List<Visit> patientList = new ArrayList<Visit>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = (Integer) mapForDS.get("deptId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		String deptName = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = new Date();
		String category = "Doctor";
		String reportingDept[] = {"FamilyWC","FollowUp"};
		String cat[] = {"PNC","ANC","ANC FOLLOW UP","WELL BABY","IMMUNIZATION","FAMILY PLANNING"};
		try {
			if (mapForDS.get("empId") != null
				&& (Integer) mapForDS.get("empId") > 0) {
			int empId = (Integer) mapForDS.get("empId");
			patientList = session.createCriteria(Visit.class).add(Restrictions.eq("VisitDate", date))
					.add(Restrictions.eq("VisitStatus", "w"))
					.add(Restrictions.eq("Doctor.Id", empId))
					.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.in("FwcCategory",cat))
					.add(Restrictions.in("ReportingFor", reportingDept)).addOrder(Order.asc("TokenNo")).list();
			map.put("empId", empId);
			} else {
				patientList = session.createCriteria(Visit.class).add(
						//Restrictions.eq("VisitDate", date)).add(
						Restrictions.eq("VisitStatus", "w"))
						.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId))
						.add(Restrictions.in("FwcCategory",cat))
						.add(Restrictions.in("ReportingFor", reportingDept)).addOrder(Order.asc("TokenNo")).list();
			}
			
			
			doctorList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
			.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
			Map<String, Object> deptMap = getDepartmentNameFromId(deptId);
			if (deptMap.get("deptName") != null) {
				deptName = (String) deptMap.get("deptName");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		map.put("doctorList", doctorList);
		map.put("deptName", deptName);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchWaitingPatientList(Map mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();


		String serviceNo = "";
		String hinNo = "";
		String serviceTypeName = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		Date currentDate = null;
		int deptId = 0; 
		int hospitalId = 0; 
		Session session = (Session) getSession();
		hospitalId = (Integer) mapForDS.get("hospitalId");
		if (mapForDS.get("deptId") != null) {
			deptId = (Integer) mapForDS.get("deptId");
		}
		if (mapForDS.get("serviceNo") != null) {
			serviceNo = (String) mapForDS.get("serviceNo");
		}
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		if (mapForDS.get("serviceTypeName") != null) {
			serviceTypeName = (String) mapForDS.get("serviceTypeName");
		}
		if (mapForDS.get("patientFName") != null) {
			patientFName = (String) mapForDS.get("patientFName");
		}
		if (mapForDS.get("patientMName") != null) {
			patientMName = (String) mapForDS.get("patientMName");
		}
		if (mapForDS.get("patientLName") != null) {
			patientLName = (String) mapForDS.get("patientLName");
		}
		if (mapForDS.get("currentDate") != null) {
			currentDate = (Date) mapForDS.get("currentDate");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Date vdate=new Date(sdf.format(currentDate));
		Criteria crit = session.createCriteria(Visit.class)
				.createAlias("Hin", "hin").add(
						Restrictions.eq("VisitDate", currentDate));
		if (hinNo.equals("")) {
			if (!serviceTypeName.equals("")) {
				crit = crit.createAlias("hin.ServiceType", "masService").add(
						Restrictions.eq("masService.ServiceTypeName",
								serviceTypeName));
			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo.trim()));
			}
			
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("hin.PFirstName",patientFName.trim()).ignoreCase()); 
					}
			if (!patientMName.equals("")) {
				crit = crit.add(Restrictions.like("hin.PMiddleName",patientMName.trim()).ignoreCase()); 
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("hin.PLastName", patientLName.trim()).ignoreCase()); 
			}
		} else {
			crit = crit.add(Restrictions.eq("hin.HinNo", hinNo.trim()));
		}
		patientList = crit.list();
		doctorList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
		.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).list();
		map.put("doctorList", doctorList);
		map.put("patientList", patientList);

		return map;
	}

	public Map<String, Object> getPatientDetails(int visitId) {
		Session session = (Session) getSession();
		List<Visit> patientDataList = new ArrayList<Visit>();
		Map<String, Object> map = new HashMap<String, Object>();

		try {

			// patientList=session.createQuery("select v from Visit as v where   v.VisitDate="+date
			// ).list();
			// v.VisitDate="+date ).list();
			patientDataList = session.createCriteria(Visit.class).add(
					Restrictions.eq("Id", visitId)).list();
			String currentYearVisitCountSql="select count(*) from visit where to_char(visit_date, 'YYYY')= to_char(sysdate, 'YYYY') and visit_id=:visitId";
		
			SQLQuery sqlQry = session.createSQLQuery(currentYearVisitCountSql);
			if(visitId!=0){
				sqlQry.setParameter("visitId", visitId);
			}
		
			
			List<Object> currentYearVisitCountList = new ArrayList<Object>();
			//currentYearVisitCountList=session.createSQLQuery(currentYearVisitCountSql).list();
			currentYearVisitCountList = sqlQry.list();
			int visitCount=0;
			if(currentYearVisitCountList.size()>0 && currentYearVisitCountList!=null){
				visitCount=Integer.parseInt(""+currentYearVisitCountList.get(0));
			}
			map.put("visitCount", visitCount);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDataList", patientDataList);

		return map;
	}
	@SuppressWarnings("unused")
	public Map<String, Object> getDepartmentNameFromId(int deptId) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		String deptName = null;
		String deptCode = null;
		try {

			Criteria crit = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Id", deptId));
			deptList = crit.list();
			MasDepartment masDepartment = deptList.get(0);
			deptName = masDepartment.getDepartmentName();
			deptCode = masDepartment.getDepartmentCode();
			returnMap.put("deptName", deptName);
			returnMap.put("deptCode", deptCode);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return returnMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showAntCardJsp(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit>fwcPatientDataList = new ArrayList<Visit>();
		List<OpdPatientDetails>opdPatientDetailsList = new ArrayList<OpdPatientDetails>();
		List<OpdPatientHistory>OpdPatientHistoryList = new ArrayList<OpdPatientHistory>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<MasMedicalExaminationReportOnEntry> medicalList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		List<PatientFamilyHistory> patientFamilyHistoryList=new ArrayList<PatientFamilyHistory>();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		Session session = (Session)getSession();
		int visitId = 0;
		if(dataMap.get("visitId") != null){
			visitId = (Integer)dataMap.get("visitId");
		}
		int deptId = 0;
		if(dataMap.get("deptId") != null){
			deptId = (Integer)dataMap.get("deptId");
		}
		int hinId = 0;
		if(dataMap.get("hinId") != null){
			hinId = (Integer)dataMap.get("hinId");
		}
		templateList = session.createCriteria(OpdTemplate.class).createAlias("Department", "dept").add(
				Restrictions.eq("dept.Id", deptId)).add(Restrictions.eq("Status", "y")).list();
		fwcPatientDataList = session.createCriteria(Visit.class).add(Restrictions.idEq(visitId)).list();
		medicalList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("Visit.Id",visitId )).list();
		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y")).list();
		disposalList = session.createCriteria(MasDisposal.class).add(Restrictions.eq("Status", "y")).list();
		patientFamilyHistoryList= session.createCriteria(PatientFamilyHistory.class).add(
				Restrictions.eq("Status", "y")).list();
		
	/*	opdPatientDetailsList=session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").add(Restrictions.eq("v.ReportingFor", "FamilyWC")).
		createAlias("v.Hin", "h").add(Restrictions.eq("h.Id",hinId)).list();
		if(opdPatientDetailsList.size()>0){
			map.put("opdPatientDetailsList", opdPatientDetailsList);	
		}*/
		OpdPatientHistoryList=session.createCriteria(OpdPatientHistory.class).createAlias("Hin", "h").add(Restrictions.eq("h.Id",hinId)).list();
		
		if(OpdPatientHistoryList.size()>0){
			map.put("OpdPatientHistoryList", OpdPatientHistoryList);	
		}
		
		
		
		
		opdPatientDetailsList = (List<OpdPatientDetails>) session.createCriteria(OpdPatientDetails.class)
				.createAlias("Visit", "v").add(Restrictions.eq("v.ReportingFor", "FamilyWC"))
				.add(Restrictions.eq("v.FwcCategory", "ANC FOLLOW UP")).
		createAlias("v.Hin", "h").add(Restrictions.eq("h.Id",hinId)).list();

		OpdPatientDetails opd = null;
		if (opdPatientDetailsList != null && opdPatientDetailsList.size() > 0) {
			opd = opdPatientDetailsList.get(0);
			map.put("opd", opd);
			map.put("opdPatientDetailsList", opdPatientDetailsList);

		}
		map.put("fwcPatientDataList", fwcPatientDataList);
		map.put("medicalList", medicalList);
		map.put("frequencyList", frequencyList);
		map.put("disposalList", disposalList);
		map.put("templateList", templateList);
		map.put("patientFamilyHistoryList", patientFamilyHistoryList);
		return map;
 }

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> submitAntenatalCard(Box box,Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Transaction tx = null;
		String orderSeqNo = "";
		//int userId = (Integer) mapForDS.get("userId");
		String userName = (String) mapForDS.get("userName");
		List pvmsNoList = (List) mapForDS.get("pvmsNoList");
		List<Integer> frequencyList = (List) mapForDS.get("frequencyList");
		List<String> otherMedicineList = (List) mapForDS.get("otherMedicineList");
		List<String> ctList = (List) mapForDS.get("ctList");
		List<String> dosageList = (List) mapForDS.get("dosageList");
		List<String> routeList= (List) mapForDS.get("routeList");
		List<Integer> totalList = (List) mapForDS.get("totalList");
		List<Integer> noOfDaysList = (List) mapForDS.get("noOfDaysList");
		List<String> remarksList = (List) mapForDS.get("remarksList");
		List<Integer> itemIdList = new ArrayList<Integer>();
		List<String> chargeCodeIdList = (List) mapForDS.get("chargeCodeIdList");
		List<String> referToMhList = new ArrayList<String>();
		if((List)mapForDS.get("referToMhList") != null){
			referToMhList = (List)mapForDS.get("referToMhList");
		}
		boolean succesfullyAdded = false;
		try {
			
			
			int physioRequisitionHeaderId = 0;
			int procedureHeaderId = 0;
			if(mapForDS.get("physioRequisitionHeaderId")!=null){
				physioRequisitionHeaderId = (Integer)mapForDS.get("physioRequisitionHeaderId");
			}
			if(mapForDS.get("procedureHeaderId")!=null){
				procedureHeaderId = (Integer)mapForDS.get("procedureHeaderId");
			}
			
		
			tx = session.beginTransaction();
			Patient patientObj = new Patient();
			MasHospital masHospital = new MasHospital();
			Visit visit=new Visit();
			MasDepartment masDepartment = new MasDepartment();
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentTimeWithoutSecond();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			OpdPatientDetails opdPatientDetails =  new OpdPatientDetails();
			if(mapForDS.get("opdPatientDetails") != null){
				opdPatientDetails =(OpdPatientDetails)mapForDS.get("opdPatientDetails");
			}
			
	

			OpdPatientHistory opdPatientHistory = new OpdPatientHistory();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if(box.getInt("visitId") != 0){
				Visit visitObj = new Visit();
				visitObj.setId(box.getInt("visitId"));
				opdPatientDetails.setVisit(visitObj);
			if(box.getInt("hospitalId") != 0){
				masHospital.setId(box.getInt("hospitalId"));
				opdPatientDetails.setHospital(masHospital);
			}
			if(box.getInt("empId") !=0){
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(box.getInt("empId"));
				opdPatientDetails.setEmployee(masEmployee);
			}
			if(!box.getString(LMP).equals(""))
				opdPatientDetails.setLmpDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LMP)));
			opdPatientDetails.setConsultationDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			opdPatientDetails.setConsultationTime(time);
			opdPatientDetails.setOpdDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			opdPatientDetails.setOpdTime(time);
			if(!box.getString(EDD).equals(""))
				opdPatientDetails.setEddDate(HMSUtil.convertStringTypeDateToDateType(box.getString(EDD)));
			opdPatientDetails.setMNoOfDays(box.getString("mNoOfDays").concat("days"));
			opdPatientDetails.setDurationOfCycle(box.getString("durationOfCycle").concat("days"));
			opdPatientDetails.setMFlow(box.getString("flow"));
			opdPatientDetails.setMPain(box.getString("pain"));
			opdPatientDetails.setMRegularity(box.getString("regularity"));
			opdPatientDetails.setGr(box.getInt("gr"));
			opdPatientDetails.setPARA(box.getInt("para"));
			opdPatientDetails.setAb(box.getInt("ab"));
			opdPatientDetails.setL(box.getInt("l"));
			opdPatientDetails.setS(box.getInt("s"));
			opdPatientDetails.setMedicalSurgicalHistory(box.getString("medicalSurgicalHistory"));
			opdPatientDetails.setPog(box.getInt("pog"));
			opdPatientDetails.setSystamicExam(box.getString("systExam"));
			
			
			opdPatientDetails.setGeneral(box.getString("general"));
			opdPatientDetails.setOtherFinding(box.getString("otherFinding"));
			opdPatientDetails.setPa(box.getString("PA"));
			opdPatientDetails.setFhs(box.getString("fhs"));
			if(!box.getString("dateOfNextReview").equals(""))
			{
			opdPatientDetails.setDateOfNextReview(HMSUtil.convertStringTypeDateToDateType(box.getString("dateOfNextReview")));
			}
			opdPatientDetails.setCvs(box.getString("cvs"));
			opdPatientDetails.setRespiratory(box.getString("respiratory"));
			opdPatientDetails.setThyroid(box.getString("thyroid"));
			opdPatientDetails.setBreast(box.getString("breast"));
			opdPatientDetails.setFirstTrimester(box.getString("firstTrimester"));
			opdPatientDetails.setSecondTrimester(box.getString("secondTrimester"));
			opdPatientDetails.setThirdTrimester(box.getString("thirdTrimester"));
			opdPatientDetails.setDisposal(box.getString("disposal"));
			opdPatientDetails.setDisposalDays(box.getString("diposalDays"));
			if(box.getInt("noOfPregn1") != 0){
			opdPatientDetails.setAChildNoOfPrag(box.getInt("noOfPregn1"));
			opdPatientDetails.setAChildYear(box.getInt("year1"));
			/*if(!box.getString("fromPeriodDate1").equals(""))
				opdPatientDetails.setAChildFromPeriod(HMSUtil.convertStringTypeDateToDateType(box.getString("fromPeriodDate1")));
			if(!box.getString("toPeriodDate1").equals(""))
				opdPatientDetails.setAChildToPeriod(HMSUtil.convertStringTypeDateToDateType(box.getString("toPeriodDate1")));*/
			opdPatientDetails.setAChildAntenatal(box.getString("antenatal1"));
			opdPatientDetails.setAChildLabourAndDelivery(box.getString("labourDelivery1"));
			opdPatientDetails.setAChildGender(box.getString("gender1"));
			opdPatientDetails.setAChildWeight(box.getString("weight1"));
			opdPatientDetails.setAChildRemark(box.getString("remarks1"));
			}
			if(box.getInt("noOfPregn2") != 0){
				opdPatientDetails.setBChildNoOfPrag(box.getInt("noOfPregn2"));
				opdPatientDetails.setBChildYear(box.getInt("year2"));
				/*if(!box.getString("fromPeriodDate2").equals(""))
					opdPatientDetails.setBChildFromPeriod(HMSUtil.convertStringTypeDateToDateType(box.getString("fromPeriodDate2")));
				if(!box.getString("toPeriodDate2").equals(""))
					opdPatientDetails.setBChildToPeriod(HMSUtil.convertStringTypeDateToDateType(box.getString("toPeriodDate2")));
				*/opdPatientDetails.setBChildAntenatal(box.getString("antenatal2"));
				opdPatientDetails.setBChildLabourAndDelivery(box.getString("labourDelivery2"));
				opdPatientDetails.setBChildGender(box.getString("gender2"));
				opdPatientDetails.setBChildWeight(box.getString("weight2"));
				opdPatientDetails.setBChildRemark(box.getString("remarks2"));
				}
			if(box.getInt("noOfPregn3") != 0){
				opdPatientDetails.setCChildNoOfPrag(box.getInt("noOfPregn3"));
				opdPatientDetails.setCChildYear(box.getInt("year3"));
				/*if(!box.getString("fromPeriodDate3").equals(""))
					opdPatientDetails.setCChildFromPeriod(HMSUtil.convertStringTypeDateToDateType(box.getString("fromPeriodDate3")));
				if(!box.getString("toPeriodDate3").equals(""))
					opdPatientDetails.setCChildToPeriod(HMSUtil.convertStringTypeDateToDateType(box.getString("toPeriodDate3")));
			*/	opdPatientDetails.setCChildLabourAndDelivery(box.getString("labourDelivery3"));
				opdPatientDetails.setCChildAntenatal(box.getString("antenatal3"));
				opdPatientDetails.setCChildGender(box.getString("gender3"));
				opdPatientDetails.setCChildWeight(box.getString("weight3"));
				opdPatientDetails.setCChildRemark(box.getString("remarks3"));
				}
				hbt.save(opdPatientDetails);
			if(box.getInt("hinId") != 0){
				patientObj.setId(box.getInt("hinId"));
				opdPatientHistory.setHin(patientObj);
			}
			if(box.getInt("departmentId") != 0){
				masDepartment.setId(box.getInt("departmentId"));
				opdPatientHistory.setDepartment(masDepartment);
			}
			opdPatientHistory.setVisitInpatientId(box.getInt("visitId"));
			opdPatientHistory.setRiskFactor(box.getString("riskFactors"));
			opdPatientHistory.setPresentAdvice(box.getString("presentAdvice"));
			opdPatientHistory.setPresentComplain(box.getString("presentComplain"));
			opdPatientHistory.setOpdPatientDetails(opdPatientDetails);
			hbt.save(opdPatientHistory);            
			
			//------------code for investigation------------------------------------
			String[] chargeCodeIdArr = new String[box.getInt("hiddenValue")];
			if (chargeCodeIdList.size() > 0) {
				Patient patient = new Patient();
				MasEmployee masEmployee2 = new MasEmployee();
				PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
				patient.setId(box.getInt("hinId"));
				patientInvestigationHeader.setHin(patient);
				masDepartment.setId(box.getInt("departmentId"));
				patientInvestigationHeader.setDepartment(masDepartment);
				visit.setId(box.getInt("visitId"));
				patientInvestigationHeader.setVisit(visit);
				masHospital.setId(box.getInt("hospitalId"));
				patientInvestigationHeader.setHospital(masHospital);
				patientInvestigationHeader.setStatus("p");
				patientInvestigationHeader
						.setInvestigationDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				patientInvestigationHeader.setInvestigationTime(time);
				patientInvestigationHeader.setClinicalNotes(box.getString("clinicalNotes1"));
				patientInvestigationHeader.setOpdPatientDetails(opdPatientDetails);
				hbt.save(patientInvestigationHeader);

				DgOrderhd dgOrderhd = new DgOrderhd();
				dgOrderhd.setOrderDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				dgOrderhd.setOrderTime(time);
				masHospital.setId(box.getInt("hospitalId"));
				dgOrderhd.setHospital(masHospital);
				patient.setId(box.getInt("hinId"));
				dgOrderhd.setHin(patient);
				masDepartment.setId(box.getInt("departmentId"));
				dgOrderhd.setDepartment(masDepartment);
				if (box.getInt("empId") != 0) {
					masEmployee2.setId(box.getInt("empId"));
					dgOrderhd.setPrescribedBy(masEmployee2);
				}
				dgOrderhd.setPatientType("OP");
				dgOrderhd.setTestType("Regular");
				dgOrderhd.setCreatedby(box.getString("userName"));
				dgOrderhd.setCreatedon(HMSUtil.convertStringTypeDateToDateType(currentDate));
				dgOrderhd.setOrderNo(box.getString("orderSeqNo"));
				if (box.getInt("visitId") != 0) {
					visit = new Visit();
					visit.setId(box.getInt("visitId"));
					dgOrderhd.setVisit(visit);
				}
				dgOrderhd.setClinicalNote(box.getString("clinicalNotes1"));
				dgOrderhd.setOrderStatus("P");
				dgOrderhd.setLabOrderStatus("P");
				dgOrderhd.setLastChgBy(box.getInt("userId"));
				dgOrderhd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				dgOrderhd.setLastChgTime(time);
				dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
				hbt.save(dgOrderhd);
				for (int i = 0; i < chargeCodeIdList.size(); i++) {
					PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
					patientInvestigationDetails
					.setInvestigationHeader(patientInvestigationHeader);
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
					patientInvestigationDetails.setChargeCode(masChargeCode);
					patientInvestigationDetails.setReferToMh(referToMhList.get(i));
					hbt.save(patientInvestigationDetails);

					DgOrderdt dgOrderdt = new DgOrderdt();
					dgOrderdt.setOrderhd(dgOrderhd);
					masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
					dgOrderdt.setChargeCode(masChargeCode);
					dgOrderdt.setCreatedby(box.getString("userName"));
					dgOrderdt.setCreatedon(HMSUtil.convertStringTypeDateToDateType(currentDate));
					dgOrderdt.setLastChgBy(box.getInt("userId"));
					dgOrderdt.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
					dgOrderdt.setLastChgTime(time);
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
					dgOrderdt.setInvestigationToMH("n");
					dgOrderdt.setReferToMh(referToMhList.get(i));
					hbt.saveOrUpdate(dgOrderdt);
			}
		}
			//---------------------end of the code for investigation-----------------
	//-----------------------code for Treatment -------------------------------//
			PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
			int item_category_id=0;
			if(pvmsNoList.size() > 0 || (otherMedicineList != null && otherMedicineList.size() > 0)){
				patientObj.setId(box.getInt("hinId"));
				patientPrescriptionHeader.setHin(patientObj);
				masDepartment.setId(box.getInt("departmentId"));
				patientPrescriptionHeader.setDepartment(masDepartment);
				visit.setId(box.getInt("visitId"));
				patientPrescriptionHeader.setVisit(visit);
				masHospital.setId(box.getInt("hospitalId"));
				patientPrescriptionHeader.setHospital(masHospital);
				patientPrescriptionHeader.setStatus("p");
				patientPrescriptionHeader
						.setPrescriptionDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				patientPrescriptionHeader.setPrescriptionTime(time);
				/**
				 * Code By Ritu 
				 * Created Foreign key relation for emp id in Database
				 */
				MasEmployee employee = new MasEmployee();
				employee.setId(box.getInt("empId"));
				patientPrescriptionHeader.setEmp(employee);
				
				/**
				 * End of code by Ritu
				 */
				int prescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);
				patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
				patientPrescriptionHeader.setOpdPatientDetails(opdPatientDetails);
				
				
				 /* This block is use for Check Injection in Prescription List*/
				 
				String sqlItemId="";
				
				for (int i = 0; i < pvmsNoList.size(); i++) {
					String pvmsNo = (String) pvmsNoList.get(i);
					int itemId = getItemIdFromPVMS(pvmsNo);
					if(i==0){
						sqlItemId=""+itemId;
					}else{
						sqlItemId +=" , "+itemId;
					}
					itemIdList.add(itemId);
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
				masItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id in ("+sqlItemId+") and ic.Id="+item_category_id);
				
			
		/*		{
				Query qry=session.createQuery("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id in (:sqlItemId) and ic.Id=:item_category_id");
			
				if(!sqlItemId.equals("")){
						qry.setParameter("sqlItemId", sqlItemId);
					}
				if(item_category_id!=0){
					qry.setParameter("item_category_id", item_category_id);
				}
				masItemList = qry.list();
			
				}*/
				if(masItemList.size()>0){
					patientPrescriptionHeader.setInjectionStatus("p");
				}else{
					patientPrescriptionHeader.setInjectionStatus("n");
				}
				
				/* End Of Code This block is use for Check Injection in Prescription List*/
				 
				
				hbt.save(patientPrescriptionHeader);
			}
			if (pvmsNoList.size() > 0 ) {
				for (int i = 0; i < itemIdList.size(); i++) {
					
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
						if (totalList.get(i) != null && !totalList.get(i).equals("")) {
							patientPrescriptionDetails.setTotal(totalList.get(i));
						}
						patientPrescriptionDetails.setGivenQty(0);
									
					patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
				
					patientPrescriptionDetails.setDetailStatus("a");
					List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
//					storeItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id="+itemIdList.get(i)+" and ic.Id="+item_category_id);
					Query qry=session.createQuery("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id=:itemId and ic.Id=:item_category_id");
					if(itemIdList.get(i)!=0 && !itemIdList.get(i).equals("")){
							qry.setParameter("itemId", itemIdList.get(i));
						}
					if(item_category_id!=0){
						qry.setParameter("item_category_id", item_category_id);
					}
					storeItemList = qry.list();
				
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
						Query qryOne =session.createQuery("select inj from jkt.hms.masters.business.InjAppointmentHeader as inj join inj.Visit as visit where visit.Id=:visitId");
						if(box.getInt("visitId")!=0){
							qryOne.setParameter("visitId", box.getInt("visitId"));
						}
						
						injectionRegisterList = qryOne.list();
					
						InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();
						
						  if(injectionRegisterList.size()>0) /*means , Data is already available In InjectionRegister table */ 
						 
						if(injectionRegisterList.size()>0){
							for (InjAppointmentHeader injectionRegisterTemp : injectionRegisterList) {
								injectionAppointment.setId(injectionRegisterTemp.getId());
							}
						}else{
							injectionAppointment.setAppointmentDate(new Date());
							Patient patientInj = new Patient();
							patientInj.setId(box.getInt("hinId"));
							injectionAppointment.setHin(patientInj);
							Visit visitInj = new Visit();
							visitInj.setId(box.getInt("visitId"));
							injectionAppointment.setVisit(visitInj);
							MasHospital masHospitalInj = new MasHospital();
							masHospitalInj.setId(box.getInt("hospitalId"));
							injectionAppointment.setHospital(masHospitalInj);
							
							injectionAppointment.setStatus("p");
							injectionAppointment.setLastChgTime(time);
							Users user = new Users();
							user.setId(box.getInt(""));
							injectionAppointment.setLastChgBy(user);
							//injectionAppointment.setLastChgDate(date);
							injectionAppointment.setPrescription(patientPrescriptionHeader);
							hbt.save(injectionAppointment);
						}
						int freqCount=0;
						if(frequencyList.get(i) > 10){
							freqCount = 1;  /*if frequency is greater than 10 then only one entry will go in Injection Appointment table */
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
			if(otherMedicineList != null && otherMedicineList.size() > 0){
				String sqlItemId="";
				int itemId = 0;
				List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
				String otherItem = "";
				if(otherMedicineList.size() >0){
				for(int i = 0; i < otherMedicineList.size(); i++){
					MasStoreItem masItem = new MasStoreItem();
					if(otherMedicineList.get(i) != null){
						otherItem =(String)otherMedicineList.get(i);
						masItem.setNomenclature(otherMedicineList.get(i));
						MasStoreSection masStoreSection = new MasStoreSection();
						masStoreSection.setId(1);
						masItem.setSection(masStoreSection);
						masItem.setStatus("y");
						masItem.setBrandedGeneric("B");
						MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
						masStoreItemConversion.setId(1);
						masItem.setItemConversion(masStoreItemConversion);
						itemCodeList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo", "NIV%"))
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
						}
						masItem.setPvmsNo(itemNo);
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
								
						Query qryTwo =session.createQuery("select inj from jkt.hms.masters.business.InjAppointmentHeader as inj join inj.Visit as visit where visit.Id=:visitId");
						if(box.getInt("visitId")!=0){
							qryTwo.setParameter("visitId", box.getInt("visitId"));
						}
						
						injectionRegisterList = qryTwo.list();
					
						InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();
						
						 /* if(injectionRegisterList.size()>0) means , Data is already available In InjectionRegister table  */
						 
						if(injectionRegisterList.size()>0){
							for (InjAppointmentHeader injectionRegisterTemp : injectionRegisterList) {
								injectionAppointment.setId(injectionRegisterTemp.getId());
							}
						}else{
							injectionAppointment.setAppointmentDate(new Date());
							Patient patientInj = new Patient();
							patientInj.setId(box.getInt("hinId"));
							injectionAppointment.setHin(patientInj);
							Visit visitInj = new Visit();
							visitInj.setId(box.getInt("visitId"));
							injectionAppointment.setVisit(visitInj);
							MasHospital masHospitalInj = new MasHospital();
							masHospitalInj.setId(box.getInt("hospitalId"));
							injectionAppointment.setHospital(masHospitalInj);
							injectionAppointment.setStatus("p");
							injectionAppointment.setLastChgTime(time);
							Users user = new Users();
							user.setId(box.getInt("userId"));
							injectionAppointment.setLastChgBy(user);
							injectionAppointment.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
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
	//----------------update visit table---------------------------------------------------
			Visit visitObjToUpdate = (Visit) hbt.load(Visit.class, box.getInt("visitId"));
			visitObjToUpdate.setVisitStatus("C");
			if(box.getInt("empId")>0){
				MasEmployee doctor=new MasEmployee();
				doctor.setId(box.getInt("empId"));
				visitObjToUpdate.setDoctor(doctor);
				visitObjToUpdate.setVisitStatus("C");
			
			}
			
			visitObjToUpdate.setDiagnosisString(box.getString("initialDiagnosis"));
			visitObjToUpdate.setDisposalName(box.getString("disposal"));
			visitObjToUpdate.setDisposalDays(box.getString("days"));
		
			hbt.update(visitObjToUpdate);
			//----------------------------------
			
		}
			
			if(physioRequisitionHeaderId!=0){
				PhysioRequisitionHeader requisitionHeader = (PhysioRequisitionHeader)hbt.load(PhysioRequisitionHeader.class, physioRequisitionHeaderId);
				requisitionHeader.setOpdPatientDetails(opdPatientDetails);
				requisitionHeader.setReqTime(time);
				requisitionHeader.setLastChgTime(time);
				hbt.update(requisitionHeader);
				
			}
			if(procedureHeaderId!=0){
				ProcedureHeader procedureHeader = (ProcedureHeader)hbt.load(ProcedureHeader.class, procedureHeaderId);
				procedureHeader.setOpdPatientDetails(opdPatientDetails);
				procedureHeader.setLastChgTime(time);
				hbt.update(procedureHeader);
				
			}
			
			succesfullyAdded = true;
			tx.commit();	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		map.put("succesfullyAdded", succesfullyAdded);
	//	map = showAntCardJsp(dataMap)
		return map;
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
	public int getTransactionSequenceNoForPrescriptionNo(Map mapForDS) {
		Session session = (Session) getSession();

		int userId = (Integer) mapForDS.get("userId");
		String userName = (String) mapForDS.get("userName");
		int hospitalId = (Integer)mapForDS.get("hospitalId");
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

		try {
				//	tx = session.beginTransaction();
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
         
		try {

			Criteria crit = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("Tablename", tableName)).add(Restrictions.eq("Hospital.Id", hospitalId));
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
	
	@SuppressWarnings("unchecked")
	public int getItemIdFromPVMS(String pvmsNo) {
		List<MasStoreItem> itemIdList = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		int itemId = 0;
		try {
			itemIdList = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", pvmsNo)).list();
			MasStoreItem masStoreItem = itemIdList.get(0);
			itemId = masStoreItem.getId();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return itemId;
	}

	@Override
	public Map<String, Object> showFwcUploadViewDocumentJsp(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		int visitId = 0;
		int hinId =0;
		if(dataMap.get("visitId")!=null){
			visitId=(Integer)dataMap.get("visitId");
		}
		if(dataMap.get("hinId")!=null){
			hinId=(Integer)dataMap.get("hinId");
		}
		String flag="";
		if(dataMap.get("flag")!=null){
			flag=(String)dataMap.get("flag");
		}
		List<Visit> patientDataList = new ArrayList<Visit>();
		try {
			patientDataList = session.createCriteria(Visit.class).add(
					Restrictions.eq("Id", visitId)).list();

			map.put("patientDataList", patientDataList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> submitFwcUploadDocuments(Box box) {
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
		int hospitalId = box.getInt("hospitalId");
		String userName = box.getString("userName");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		
		int uploadCount = box.getInt("uploadCount");
		String uploadURL = box.getString("uploadURL");
		String fileSeparator = box.getString("fileSeparator");
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			 hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
        /* List uploadDocumentList = session.createCriteria(UploadDocuments.class).add(Restrictions.eq("FileName", hin_no)).list();
         if(uploadDocumentList.size()==0)
         {
         	UploadDocuments uploadDocuments = new UploadDocuments();
				//String dataInput = new String(bytes);
				//uploadDocuments.setPatientDocument(bytes);
				//uploadDocuments.setPatientDocument(is.toString());
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
         }*/
			// hbt.setFetchSize(16*1024*1024);
			if(uploadCount>0){
				for (int i = 1; i <= uploadCount; i++) {
					UploadDocuments uploadDocuments = new UploadDocuments();
					File file=null;
					file = new File(uploadURL+fileSeparator+hin_no +fileSeparator+box.getString("filename"+i));

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
						
							uploadDocuments.setPatientDocument(bytes);
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
							
							uploadDocuments.setPatientDocument(bytes);
						}
						
						//fileExtension=strToken.nextToken();

					} catch (Exception e) {
						e.printStackTrace();
					}
					
					StringTokenizer strToken = new StringTokenizer(box
							.getString("filename" + i), ".");

					fileName = strToken.nextToken();
					fileExtension = strToken.nextToken();
					
					uploadDocuments.setPatientName(patientName);
					uploadDocuments.setSex(sex);
					uploadDocuments.setAge(age);
					if (address != null)
						uploadDocuments.setAddress(address);
					uploadDocuments.setFileExtension(fileExtension);
					uploadDocuments.setFileName(fileName);

					if (hinId != 0) {
						Patient patient = new Patient();
						patient.setId(hinId);
						uploadDocuments.setHin(patient);
					}
					if (box.getInt("visitId") != 0) {
						Visit visit= new Visit();
						visit.setId(box.getInt("visitId"));
						uploadDocuments.setVisit(visit);
					}
					
					if (inpatientId != 0) {
						Inpatient inpatient = new Inpatient();
						inpatient.setId(inpatientId);
						uploadDocuments.setInpatient(inpatient);
					}
					uploadDocuments.setDescription(box.getString("description"
							+ i));
					uploadDocuments.setUploadDate(date);
					uploadDocuments.setLastChgDate(date);
					uploadDocuments.setLastChgTime(time);
					uploadDocuments.setLastChgBy(userName);
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					uploadDocuments.setHospital(masHospital);
					uploadDocuments.setFwcFlag(box.getString("fwcFlag"));
					hbt.save(uploadDocuments);

					//file.delete();
				}// end of 'IF'

			}// end of 'for' loop
		    map.put("dataSaved", true);
         }// end of 'try' loop
		catch (Exception e) {
			//System.out.println("File not Saved....................");
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
			map.put("dataSaved", false);
		}
		return map;
	}

	@Override
	public Map<String, Object> viewFwcPatientDetails(Map<String, Object> map) {
		Session session = (Session) getSession();

		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Visit> visitList = new ArrayList<Visit>();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		int visitId = 0;
		if(map.get("visitId")!=null){
			visitId = (Integer)map.get("visitId");
		}
		String inputField = (String) map.get("inputField");
		String flag = (String) map.get("flag");
		String flag1 = (String) map.get("flag1");
		String fwcFlag = (String)map.get("fwcFlag");
		String message = null;
		String destUploadURL = "";
		if(map.get("destUploadURL")!=null && !map.get("destUploadURL").equals(""))
		{
			destUploadURL=(String)map.get("destUploadURL");
		}
		Criteria criteria = null;
		
		if (flag.equals("upload") && !flag1.equals("viewDocuments")) {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("Status", "y")).add(
					Restrictions.eq("HinNo", inputField)).list();

			if (visitList.size() == 0 && patientList.size() == 0) {
				message = "No record Found !!";
			}
			map.put("message", message);
			map.put("patientList", patientList);

		} else if (flag.equals("view") || flag1.equals("viewDocuments")) {
			String uploadURL = (String) map.get("uploadURL");
			patientList = session.createCriteria(UploadDocuments.class)
					.createAlias("Hin", "p").add(
							Restrictions.eq("p.HinNo", inputField)).add(Restrictions.isNull("Inpatient")).list();
			

			if (patientList.size() == 0) {
				message = "No record Found !!";
			}
			map.put("message", message);
			if(patientList.size() > 0){
			map.put("patientList", patientList);
			}
			
			/**
			 * Commented By Ritu as it is not required for view documents
			 */
			/*String[] files = null;
			if (patientList.size() > 0) {
				files = new String[patientList.size()];
				Iterator iterator = patientList.iterator();
				int counter = 0;
				while (iterator.hasNext()) {
					UploadDocuments uploadDocuments = (UploadDocuments) iterator
							.next();
					files[counter] = uploadDocuments.getFileName() + "."
							+ uploadDocuments.getFileExtension();
					// //System.out.println("filename="+files[counter]);
					try {
						FileOutputStream is = new FileOutputStream(destUploadURL
								+ uploadDocuments.getFileName() + "."
								+ uploadDocuments.getFileExtension());
						is.write(out);
						is.flush(); 
						is.close();
						HMSUtil.copyCompletlyFolder(new File(uploadURL),new File(destUploadURL));
						
					
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
						FileOutputStream is = new FileOutputStream(uploadURL
								 + files[counter]);
						

						is.write(uploadDocuments.getPatientDocument());
						is.flush();
						is.close();
						File srcFile=new File(uploadURL+uploadDocuments.getFileName() + "."
								+ uploadDocuments.getFileExtension());
						File destFile = new File(destUploadURL
								+ uploadDocuments.getFileName() + "."
								+ uploadDocuments.getFileExtension());
						
						HMSUtil.copyfile(srcFile , destFile);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					counter++;
				}
			}*/

		}

		/*
		 * //System.out.println("IN DATA SERVICE
		 * patientList="+patientList.size()); //System.out.println("IN DATA
		 * SERVICE inpatientList="+inpatientList.size());
		 */
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPNCDataList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit>pncDataList = new ArrayList<Visit>();
		List<Visit> patientLastVisitList = new ArrayList<Visit>();
		List<OpdPatientDetails> opdDetailListForFollowUp = new ArrayList<OpdPatientDetails>();
		List<OpdPatientHistory> opdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
		List<PatientInvestigationHeader>patientInvestigationHeaderListForFollowUp = new ArrayList<PatientInvestigationHeader>();
		List<PatientPrescriptionHeader> patientPrescriptionHeaderList = new ArrayList<PatientPrescriptionHeader>();
		List<MasFrequency>frequencyList = new ArrayList<MasFrequency>();
		List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
		List<PatientFamilyHistory> patientFamilyHistoryList = new ArrayList<PatientFamilyHistory>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		Session session = (Session)getSession();
		
		int visitId = 0;
		if(dataMap.get("visitId") != null){
			visitId = (Integer)dataMap.get("visitId");
		}
		try {
		pncDataList = session.createCriteria(Visit.class).add(Restrictions.idEq(visitId)).list();
		
	
		
		if(pncDataList.get(0).getReportingFor().equals("FollowUp")){
			 int hinId = pncDataList.get(0).getHin().getId();
			 String department =  pncDataList.get(0).getFollowUpDepartment();
			 if(department != null){
			 patientLastVisitList = session.createCriteria(Visit.class).add(Restrictions.eq("Hin.Id", hinId))
			 							.add(Restrictions.or(Restrictions.eq("ReportingFor",department), Restrictions.eq("FollowUpDepartment", department)))
			 							.add(Restrictions.eq("VisitStatus", "C")).add(Restrictions.ne("Id",visitId)).setMaxResults(1).addOrder(Order.desc("Id")).list();
			 if(patientLastVisitList.size()>0){
			 int lastVisitId = patientLastVisitList.get(0).getId();
		
			opdDetailListForFollowUp = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "visit")
				.add(Restrictions.eq("visit.Id", lastVisitId)).list();
		
		
			opdHistoryDetailsListForFollowUp = session.createCriteria(OpdPatientHistory.class).createAlias("OpdPatientDetails", "details")
							.createAlias("details.Visit", "visit").add(Restrictions.eq("visit.Id", lastVisitId)).list();
	
			patientInvestigationHeaderListForFollowUp = session.createCriteria(PatientInvestigationHeader.class).createAlias("Visit", "visit")
								.add(Restrictions.eq("visit.Id", lastVisitId)).list();
			patientPrescriptionHeaderList = session.createCriteria(PatientPrescriptionHeader.class).createAlias("Visit", "visit")
												.add(Restrictions.eq("visit.Id", lastVisitId)).list();
			dischargeIcdCodeList = session.createCriteria(DischargeIcdCode.class).createAlias("Visit", "visit")
										.add(Restrictions.eq("visit.Id", lastVisitId)).list();
			}
		}
	}
	} catch (HibernateException e) {
		e.printStackTrace();
	}
		frequencyList = session.createCriteria(MasFrequency.class).add(
				Restrictions.eq("Status", "y")).list();
		//dischargeIcdCodeList = session.createCriteria(DischargeIcdCode.class).list();
		patientFamilyHistoryList= session.createCriteria(PatientFamilyHistory.class).add(
				Restrictions.eq("Status", "y")).list();
		disposalList = session.createCriteria(MasDisposal.class).add(Restrictions.eq("Status", "y")).list();
		 Visit visitdata=null;
		  if(pncDataList!=null&&pncDataList.size()>0)
		  {
			  visitdata= pncDataList.get(0);
		  }
        
        /**
         * Getting data for dental from opd_patient_details
         * Code By Ritu
         * Date 03.12.2012
         */
        List<Visit> dentalVisitList = new ArrayList<Visit>();
        dentalVisitList = session.createCriteria(Visit.class).add(Restrictions.eq("Hin.Id", visitdata.getHin().getId())).addOrder(Order.desc("Id")).setMaxResults(1).list();
        if(dentalVisitList.size() > 0){
      	  List<OpdPatientDetails> opdDentalDetailsList = new ArrayList<OpdPatientDetails>();
      	  opdDentalDetailsList = session.createCriteria(OpdPatientDetails.class).add(Restrictions.eq("Visit.Id", dentalVisitList.get(0).getId())).list();
      	  map.put("opdDentalDetailsList", opdDentalDetailsList);
        }
        /**
         * End
         */
		map.put("disposalList", disposalList);
		map.put("pncDataList", pncDataList);
		map.put("patientFamilyHistoryList", patientFamilyHistoryList);
		map.put("frequencyList", frequencyList);
		map.put("dischargeIcdCodeList", dischargeIcdCodeList);
	
		map.put("opdDetailListForFollowUp", opdDetailListForFollowUp);
		map.put("opdHistoryDetailsListForFollowUp", opdHistoryDetailsListForFollowUp);
		map.put("patientInvestigationHeaderListForFollowUp", patientInvestigationHeaderListForFollowUp);
		map.put("patientPrescriptionHeaderList", patientPrescriptionHeaderList);
		
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitPncPatientDetails(Map<String, Object> mapForDS, Box box) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String orderSeqNo = "";
		List pvmsNoList = (List) mapForDS.get("pvmsNoList");
		List<Integer> frequencyList = (List) mapForDS.get("frequencyList");
		List<String> otherMedicineList = (List) mapForDS.get("otherMedicineList");
		List<Integer> itemConversionList = (List) mapForDS.get("itemConversionList");
		List<String> ctList = (List) mapForDS.get("ctList");
		//List<String> injCategoryList = (List) mapForDS.get("injCategoryList");
		List<String> dosageList = (List) mapForDS.get("dosageList");
		//List<String> typeLeftRightList = (List) mapForDS.get("typeLeftRightList");
		//List<String> instructionList = (List) mapForDS.get("instructionList");
		List<String> routeList = new ArrayList<String>();
		routeList= (List) mapForDS.get("routeList");
		List<Integer> totalList = (List) mapForDS.get("totalList");
		List<Integer> noOfDaysList = (List) mapForDS.get("noOfDaysList");
		List<String> remarksList = (List) mapForDS.get("remarksList");
		List<String> chargeCodeIdList = (List) mapForDS.get("chargeCodeIdList");
	//	List<Integer> quantityList = (List) mapForDS.get("quantityList");
		List<String> referToMhList = new ArrayList<String>();
		if((List)mapForDS.get("referToMhList") != null){
			referToMhList = (List)mapForDS.get("referToMhList");
		}
		//List<String> clinicalList = (List) mapForDS.get("clinicalList");
		String[] diagnosisIdAray = (String[]) mapForDS.get("diagnosisIdAray");
		int hinId = (Integer) mapForDS.get("hinId");
		int departmentId = (Integer) mapForDS.get("departmentId");
		int visitId = (Integer) mapForDS.get("visitId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		
		
		//String remaks = (String) mapForDS.get("remaks");
		int empId = (Integer) mapForDS.get("empId");
		int empIdCurrnet= (Integer) mapForDS.get("empIdCurrnet");
		int userId = (Integer) mapForDS.get("userId");
	//	departmentId=117;
		int deptId = (Integer) mapForDS.get("deptId");

		String userName = (String) mapForDS.get("userName");
		String temperature = (String) mapForDS.get("temperature");
		//String referredDept = (String) mapForDS.get("referredDept");
		String consultationTime = (String) mapForDS.get("consultationTime");
		String consultationDate = (String) mapForDS.get("consultationDate");
		Date consultationDateToInsert = HMSUtil
				.convertStringTypeDateToDateType(consultationDate);
		int systemDiagnosisId = 0;
		if(mapForDS.get("systemDiagnosisId") != null){
			systemDiagnosisId = (Integer)mapForDS.get("systemDiagnosisId");
		}

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		String nextVisitDate = (String) mapForDS.get("nextVisitDate");
		String pastHistory = (String) mapForDS.get("pastHistory");
		String personalHistory = (String) mapForDS.get("personalHistory");
		String otherDetails = (String) mapForDS.get("otherDetails");
		String[] familyHistoryArray  = (String[]) mapForDS.get("familyHistoryArray");
		String otherFamilyHistorty = "";
		if(mapForDS.get("otherFamilyHistorty")!= null){
			otherFamilyHistorty = (String)mapForDS.get("otherFamilyHistorty");
		}
		String allergies = "";
		if(mapForDS.get("allergies")!= null){
			allergies = (String)mapForDS.get("allergies");
		}
		String reviewAt = "";
		if(mapForDS.get("reviewAt")!= null){
			reviewAt = (String)mapForDS.get("reviewAt");
		}
		String referredDoctars = (String) mapForDS.get("referredDoctars");
		Date nextVisitDateToInsert = HMSUtil
				.convertStringTypeDateToDateType(nextVisitDate);
		List<Integer> itemIdList = new ArrayList<Integer>();

		String clinicalNotes1 = (String) mapForDS.get("clinicalNotes1");
		String referedToMH = (String) mapForDS.get("referedToMH");
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
		int threpytypeId = (Integer) mapForDS.get("threpytypeId");
		
		int physioRequisitionHeaderId = 0;
		int procedureHeaderId = 0;
		if(mapForDS.get("physioRequisitionHeaderId")!=null){
			physioRequisitionHeaderId = (Integer)mapForDS.get("physioRequisitionHeaderId");
		}
		if(mapForDS.get("procedureHeaderId")!=null){
			procedureHeaderId = (Integer)mapForDS.get("procedureHeaderId");
		}
		
		OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
		if(mapForDS.get("opdPatientDetails") != null){
			opdPatientDetails =(OpdPatientDetails)mapForDS.get("opdPatientDetails");
		}
		
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Visit visitsave = new Visit();
			visitsave=(Visit) hbt.load(Visit.class, box.getInt("visitId"));
			visitsave.setDiagnosisString(box.getString("initialDiagnosis"));
			visitsave.setDisposalName(box.getString("disposal"));
			visitsave.setDisposalDays(box.getString("days"));
			visitsave.setVisitStatus("C");
			hbt.update(visitsave);
			Visit visitObj = new Visit();
			visitObj.setId(box.getInt("visitId"));
						//visitObj.setDiagnosisString(initialDiagnosis);
			//hbt.update(visitObj);
			opdPatientDetails.setVisit(visitObj);
			if (empId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(empId);
				opdPatientDetails.setEmployee(masEmployee);
			}
			MasHospital masHospitalObj = new MasHospital();
			masHospitalObj.setId(box.getInt("hospitalId"));
			opdPatientDetails.setHospital(masHospitalObj);
			opdPatientDetails.setHeight(box.getString("height"));
			opdPatientDetails.setWhr(box.getString("whr"));
			opdPatientDetails.setDisposal(box.getString("disposal"));
			opdPatientDetails.setDays(box.getString("days"));
			opdPatientDetails.setDisposalDays(box.getString("days"));
			opdPatientDetails.setVweight(box.getString("weight"));
			opdPatientDetails.setPulse(box.getString("pulse"));
			opdPatientDetails.setBp(box.getString("bp"));
			if (temperature!=null) {
				opdPatientDetails.setTemperature(box.getString("temperature"));
			}
			opdPatientDetails.setAfmsDesc(box.getString("afmsDescription"));
			opdPatientDetails.setConsultationTime(time);
			opdPatientDetails.setConsultationDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			opdPatientDetails.setPlan(box.getString("plan"));
			opdPatientDetails.setInitialDiagnosis(box.getString("initialDiagnosis"));
			if(systemDiagnosisId != 0){
			MasSystemDiagnosis systemDiagnosis = new MasSystemDiagnosis();
			systemDiagnosis.setId(systemDiagnosisId);
			opdPatientDetails.setSystemDiagnosis(systemDiagnosis);
			}
			opdPatientDetails.setOpdDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			opdPatientDetails.setOpdTime(time);
			opdPatientDetails.setNextVisitDate(nextVisitDateToInsert);
			//opdPatientDetails.setReferredDept(referredDept);
			//System.out.println("referredDept---"+referredDept);
			
			opdPatientDetails.setNoOfChild(box.getInt("noOfChildren"));
			opdPatientDetails.setGender(box.getString("gender"));
			opdPatientDetails.setTypeOfDelivery(box.getString("delivery"));
			
			opdPatientDetails.setReferedDoctars(referredDoctars);
			opdPatientDetails.setOnExamination(box.getString("onExamination"));
			opdPatientDetails.setReturnfromHospital(box.getString("returnfromHospital"));
			opdPatientDetails.setMhRun(box.getString("referedToMH"));
			if(referedToMH.equals("y")){
				opdPatientDetails.setMh(mhString);
				opdPatientDetails.setMhDepartment(mhDepartment);
				opdPatientDetails.setMhReferredFor(mhReferredFor);
			}
			opdPatientDetails.setHospName(box.getString("hospName"));
			opdPatientDetails.setDoa(box.getString("doa"));
			opdPatientDetails.setDod(box.getString("dod"));
			opdPatientDetails.setGpe_examination(box.getString("gpe_examination"));
			opdPatientDetails.setRr(box.getString("rr"));
			opdPatientDetails.setSystamicExam(box.getString("systamicExam"));
			opdPatientDetails.setBmi(box.getString("bmi"));
			opdPatientDetails.setIdealWeight(box.getString("idealWeight"));
			opdPatientDetails.setAdviceOnDischarge(box.getString("adviceOnDischarge"));
			opdPatientDetails.setPastDiagnosis(box.getString("pastDiagnosis"));
			opdPatientDetails.setPastdisposal(box.getString("pastdisposal"));
			opdPatientDetails.setDaysPhy(box.getString("DaysPhy"));
			opdPatientDetails.setDurationPhy(box.getString("DurationPhy"));
			opdPatientDetails.setCaseNotes(box.getString("clinicalNotes1"));
			//System.out.println("threpytypeId---1"+threpytypeId);
			if(threpytypeId!=0)
			{
				//System.out.println("threpytypeId---"+threpytypeId);
			MasTherapyType thy=new MasTherapyType();
			thy.setId(box.getInt("threpytypeId"));
			opdPatientDetails.setTherapyType(thy);
			}
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
			opdPatientDetails.setDistantVision(box.getString("distantVision"));
			opdPatientDetails.setNearVision(box.getString("distantVision"));
			opdPatientDetails.setOthersVision(box.getString("othersVision"));
			opdPatientDetails.setBreastExam(box.getString("breastExam"));
			opdPatientDetails.setPapSmear(box.getString("papSmear"));
			opdPatientDetails.setOtherFinding(box.getString("otherObservation"));
			opdPatientDetails.setSystemicDisorder(box.getString("systemicDisorder"));
			//opdPatientDetails.setSpecialAdviseFollowup(box.getString("specialAdviseFollowup"));
			hbt.save(opdPatientDetails);

			// --------------- values to be Opd Patient
			// History--------------------

			OpdPatientHistory opdPatientHistory = new OpdPatientHistory();

			MasDepartment md = new MasDepartment();
			md.setId(box.getInt("deptId"));
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

			opdPatientHistory.setPersonalPastHistory(pastHistory);
			opdPatientHistory.setPersonalPresentHistory(personalHistory);
			opdPatientHistory.setPersonalOtherDetails(otherDetails);
			//-----commented by anamika-------------
			//opdPatientHistory.setFamilyPastHistory(familyHistory);
			opdPatientHistory.setRiskFactor(box.getString("riskFactor"));
			opdPatientHistory.setPastMedicalHistory(box.getString("pastMedicalHistory"));
			opdPatientHistory.setPresentComplain(box.getString("presentComplain"));
			opdPatientHistory.setPresentAdvice(box.getString("presentAdvice"));//fayaz added
			//opdPatientHistory.setPresentIllness(presentIllness);

			opdPatientHistory.setIpOpPacStatus("OP");

			opdPatientHistory.setOpdPatientDetails(opdPatientDetails);

			hbt.save(opdPatientHistory);
			
			if(familyHistoryArray!=null && familyHistoryArray.length > 0) {
				for (int i = 0; i < familyHistoryArray.length; i++) {
					List<MasMedicalExamFamilyHis> existingFamilyHis = new ArrayList<MasMedicalExamFamilyHis>();
					existingFamilyHis = session.createCriteria(MasMedicalExamFamilyHis.class).createAlias("Hin", "h").add(Restrictions.eq("h.Id", hinId)).createAlias("PatientFamilyHistory", "pfh").add(Restrictions.eq("pfh.Id", Integer.parseInt(""+familyHistoryArray[i]))).list();
					if(existingFamilyHis.size() == 0){
						MasMedicalExamFamilyHis masExamFamilyHis = new MasMedicalExamFamilyHis();
						Patient patientObj = new Patient();
						patientObj.setId(hinId);
						masExamFamilyHis.setHin(patientObj);
						PatientFamilyHistory familyHistory = new PatientFamilyHistory();
						familyHistory.setId(Integer.parseInt(""+familyHistoryArray[i]));
						masExamFamilyHis.setPatientFamilyHistory(familyHistory);
						hbt.save(masExamFamilyHis);
					}
				}
			}
			//------------update Patient Table for other Family History-------------------//
			
			Patient ptObj = (Patient)hbt.load(Patient.class, hinId);
			ptObj.setOtherFamilyHistory(otherFamilyHistorty);
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
			String query = "";
			List objectList = new ArrayList();
			if (diagnosisIdAray != null) {
				for (int i = 0; i < diagnosisIdAray.length; i++) {
					DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
					Patient patientObj = new Patient();
					patientObj.setId(hinId);
					dischargeIcdCode.setHin(patientObj);
					MasIcd masIcd = new MasIcd();
					//
					// masIcd.setId(Integer.parseInt(diagnosisIdAray[i]));
					// chnaget to Line Below

					if (diagnosisIdAray[i] != null) {
						if (!diagnosisIdAray[i].equals("0")) {
												
							Query qryOne =session.createQuery("select icd_id from mas_icd where icd_code=:diagnosisIdAray");
							if (!diagnosisIdAray[i].equals("0")) {
								qryOne.setParameter("diagnosisIdAray", diagnosisIdAray[i]);
							}
							
							objectList = qryOne.list();
						
							
							
							masIcd.setId(Integer.parseInt(""+ objectList.get(0)));
							dischargeIcdCode.setIcd(masIcd);
							dischargeIcdCode
									.setAddEditDate(consultationDateToInsert);
							dischargeIcdCode.setAddEditTime(consultationTime);
							dischargeIcdCode.setStatus("y");
							dischargeIcdCode.setDiagnosisStatus("p");
							Visit visit = new Visit();
							visit.setId(visitId);
							dischargeIcdCode.setVisit(visit);
							dischargeIcdCode.setOpdPatientDetails(opdPatientDetails);
							hbt.save(dischargeIcdCode);
						}
					}
				}
			}
			
			PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
			int item_category_id=0;
			if(pvmsNoList.size() > 0 || (otherMedicineList != null && otherMedicineList.size() > 0)){
				Patient patient = new Patient();
				patient.setId(hinId);
				patientPrescriptionHeader.setHin(patient);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
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
				String sqlItemId="";
				
				for (int i = 0; i < pvmsNoList.size(); i++) {
					String pvmsNo = (String) pvmsNoList.get(i);
					int itemId = getItemIdFromPVMS(pvmsNo);
					if(i==0){
						sqlItemId=""+itemId;
					}else{
						sqlItemId +=" , "+itemId;
					}
					itemIdList.add(itemId);
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
				masItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id in ("+sqlItemId+") and ic.Id="+item_category_id);
				/*{
					Query qry=session.createQuery("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id in (:sqlItemId) and ic.Id=:item_category_id");
				
				if(!sqlItemId.equals("")){
						qry.setParameter("sqlItemId", sqlItemId);
					}
				if(item_category_id!=0){
					qry.setParameter("item_category_id", item_category_id);
				}
				masItemList = qry.list();
				}*/
				
				if(masItemList.size()>0){
					patientPrescriptionHeader.setInjectionStatus("p");
				}else{
					patientPrescriptionHeader.setInjectionStatus("n");
				}
				/*
				 * End Of Code This block is use for Check Injection in Prescription List
				 */
				
				hbt.save(patientPrescriptionHeader);
			}
			if (pvmsNoList.size() > 0 ) {
				for (int i = 0; i < itemIdList.size(); i++) {
					
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
						/*if (totalList.get(i) != null && !totalList.get(i).equals("")) {
							patientPrescriptionDetails.setTotal(Math.round(totalList.get(i).floatValue()));
						}*/
						if (totalList.get(i) != null && !totalList.get(i).equals("")) {
							patientPrescriptionDetails.setTotal(totalList.get(i));
						}
						patientPrescriptionDetails.setGivenQty(0);
					
					//System.out.println("typeLeftRightList.get(i)------>>>"+typeLeftRightList.get(i));
					//patientPrescriptionDetails.setType(typeLeftRightList.get(i));
					
					//patientPrescriptionDetails.setInstruction(instructionList.get(i));
					
					
					patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
				
					patientPrescriptionDetails.setDetailStatus("a");
					List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
//						storeItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id="+itemIdList.get(i)+" and ic.Id="+item_category_id);
					Query qry=session.createQuery("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id=:itemId and ic.Id=:item_category_id");
					if(itemIdList.get(i)!=0 && !itemIdList.get(i).equals("")){
							qry.setParameter("itemId", itemIdList.get(i));
						}
					if(item_category_id!=0){
						qry.setParameter("item_category_id", item_category_id);
					}
					storeItemList = qry.list();
				
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
						Query qryOne =session.createQuery("select inj from jkt.hms.masters.business.InjAppointmentHeader as inj join inj.Visit as visit where visit.Id=:visitId");
						if(visitId!=0){
							qryOne.setParameter("visitId",visitId);
						}
						
						injectionRegisterList = qryOne.list();
					
						
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
			//-------------code by anamika for detention-----------------------//
			if(reviewAt != null){
			PatientDetentionRegister patientDetentionRegister =new PatientDetentionRegister();
			Patient patient =  new Patient();
			patient.setId(hinId);
			patientDetentionRegister.setHin(patient);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			//System.out.println("box.getInt(hospitalId)--->"+box.getInt("hospitalId"));
			patientDetentionRegister.setHospital(masHospital);
			
			MasEmployee medicalOfficer =new MasEmployee();
			//System.out.println("box.getInt(doctorId)--"+box.getInt("doctorId"));
			medicalOfficer.setId(empIdCurrnet);
			patientDetentionRegister.setMedicalOfficer(medicalOfficer);
			
			Visit visit=new Visit();
			visit.setId(visitId);
			patientDetentionRegister.setVisit(visit);
			
			patientDetentionRegister.setDetainedFrom(date);
			patientDetentionRegister.setDetentionRegisterDate(date);
			patientDetentionRegister.setDetainedTo(date);
			patientDetentionRegister.setFromTime(time);
			patientDetentionRegister.setToTime(time);
			//patientDetentionRegister.setTreatment(box.getString("treatment"));
			patientDetentionRegister.setRequisitionDate(date);
			Users user = new Users();
			user.setId(userId);
			patientDetentionRegister.setLastChgBy(user);
			patientDetentionRegister.setLastChgDate(date);
			patientDetentionRegister.setLastChgTime(time);
			patientDetentionRegister.setStatus("p");
			patientDetentionRegister.setReviewAt(reviewAt);
			
			hbt.save(patientDetentionRegister);
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
					if(otherMedicineList.get(i) != null){
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
						
						itemCodeList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo", "NIV%"))
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
						}
						masItem.setPvmsNo(itemNo);
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
						Query qryTwo =session.createQuery("select inj from jkt.hms.masters.business.InjAppointmentHeader as inj join inj.Visit as visit where visit.Id=:visitId");
						if(visitId!=0){
							qryTwo.setParameter("visitId",visitId);
						}
						
						injectionRegisterList = qryTwo.list();
					
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
			if (chargeCodeIdList.size() > 0) {
				MasDepartment masDepartment = new MasDepartment();
				MasHospital masHospital = new MasHospital();
				Patient patient = new Patient();
				MasEmployee masEmployee2 = new MasEmployee();

				PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();

				patient.setId(hinId);
				patientInvestigationHeader.setHin(patient);

				masDepartment.setId(deptId);
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
				dgOrderhd.setOrderTime(consultationTime);
				masHospital.setId(hospitalId);
				dgOrderhd.setHospital(masHospital);
				patient.setId(hinId);
				dgOrderhd.setHin(patient);
				masDepartment.setId(deptId);
				dgOrderhd.setDepartment(masDepartment);
				if (empId != 0) {
					masEmployee2.setId(empId);
					dgOrderhd.setPrescribedBy(masEmployee2);
				}
				dgOrderhd.setPatientType("OP");
				dgOrderhd.setTestType("Regular");
				dgOrderhd.setCreatedby(userName);
				dgOrderhd.setCreatedon(consultationDateToInsert);

				//orderSeqNo = generateOrderNumber();
				dgOrderhd.setOrderNo(box.getString("orderSeqNo"));
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
				//System.out.println("chargeCodeIdList.size()--"+chargeCodeIdList.size());
				for (int i = 0; i < chargeCodeIdList.size(); i++) {
					PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
					patientInvestigationDetails
					.setInvestigationHeader(patientInvestigationHeader);
					MasChargeCode masChargeCode = new MasChargeCode();
					//System.out.println("Integer.parseInt(chargeCodeIdList.get(i))--"+Integer.parseInt(chargeCodeIdList.get(i)));
					masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
					//System.out.println("Integer.parseInt(chargeCodeIdList.get(i))--");
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
					dgOrderdt.setInvestigationToMH("n");
					dgOrderdt.setReferToMh(referToMhList.get(i));
					hbt.saveOrUpdate(dgOrderdt);
				}

			}
			
			if(physioRequisitionHeaderId!=0){
				PhysioRequisitionHeader requisitionHeader = (PhysioRequisitionHeader)hbt.load(PhysioRequisitionHeader.class, physioRequisitionHeaderId);
				requisitionHeader.setOpdPatientDetails(opdPatientDetails);
				requisitionHeader.setReqTime(consultationTime);
				requisitionHeader.setLastChgTime(consultationTime);
				hbt.update(requisitionHeader);
				
			}
			if(procedureHeaderId!=0){
				ProcedureHeader procedureHeader = (ProcedureHeader)hbt.load(ProcedureHeader.class, procedureHeaderId);
				procedureHeader.setOpdPatientDetails(opdPatientDetails);
				procedureHeader.setLastChgTime(consultationTime);
				hbt.update(procedureHeader);
				
			}
			// }
			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		returnMap.put("succesfullyAdded", succesfullyAdded);
		returnMap.put("orderSeqNo", orderSeqNo);
		return returnMap;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPediatricJsp(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit>wellBabyDataList = new ArrayList<Visit>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<MasMedicalExaminationReportOnEntry> medicalList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		List<PatientFamilyHistory> patientFamilyHistoryList=new ArrayList<PatientFamilyHistory>(); 
		List<MasChildMilestone> masChildMilestoneList = new ArrayList<MasChildMilestone>();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		List<FwcGrowthChart> growthChartList = new ArrayList<FwcGrowthChart>();
		Session session = (Session)getSession();
		int visitId = 0;
		if(dataMap.get("visitId") != null){
			visitId = (Integer)dataMap.get("visitId");
		}
		int deptId = 0;
		if(dataMap.get("deptId") != null){
			deptId = (Integer)dataMap.get("deptId");
		}
		templateList = session.createCriteria(OpdTemplate.class).createAlias("Department", "dept").add(Restrictions.eq("dept.Id", deptId)).add(Restrictions.eq("Status", "y")).list();
		wellBabyDataList = session.createCriteria(Visit.class).add(Restrictions.idEq(visitId)).list();
		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y")).list();
		medicalList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("Visit.Id",visitId )).list();
		disposalList = session.createCriteria(MasDisposal.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("DisposalName")).list();
		
		patientFamilyHistoryList= session.createCriteria(PatientFamilyHistory.class).add(
				Restrictions.eq("Status", "y")).list();
		masChildMilestoneList = session.createCriteria(MasChildMilestone.class).add(Restrictions.eq("Status", "y")).list();
		growthChartList  = session.createCriteria(FwcGrowthChart.class).add(Restrictions.eq("Status", "y")).list();
		map.put("masChildMilestoneList", masChildMilestoneList);
		map.put("growthChartList", growthChartList);
		map.put("wellBabyDataList", wellBabyDataList);
		map.put("medicalList", medicalList);
		map.put("frequencyList", frequencyList);
		map.put("disposalList", disposalList);
		map.put("templateList", templateList);
		map.put("patientFamilyHistoryList", patientFamilyHistoryList);
		return map;
	}
	public Map<String, Object> getImmunizationId(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasImmunization> immunizationList = new ArrayList<MasImmunization>();
		String immunizationCode=  box.getString("immunizationCode");
		Session session = (Session)getSession();
		immunizationList = session.createCriteria(MasImmunization.class).add(Restrictions.eq("ImmunizationCode", immunizationCode)).add(Restrictions.eq("Flag", "C"))
		  				.list();
		map.put("immunizationList", immunizationList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> submitPediatricsDetail(Box box,Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> immuDtIdList  = new ArrayList<Integer>();
		List<Integer> immuIdList  = new ArrayList<Integer>();
		List<String> immuDateList  = new ArrayList<String>();
		List<String> doseList  = new ArrayList<String>();
		List<String> routeList  = new ArrayList<String>();
		List<String> dueDateList  = new ArrayList<String>();
		List<String> immuNameList=new ArrayList<String>();
		String userName = (String) mapForDS.get("userName");
		List pvmsNoList = (List) mapForDS.get("pvmsNoList");
		List<Integer> frequencyList = (List) mapForDS.get("frequencyList");
		List<String> otherMedicineList = (List) mapForDS.get("otherMedicineList");
		List<String> ctList = (List) mapForDS.get("ctList");
		List<String> dosageList = (List) mapForDS.get("dosageList");
		List<Integer> totalList = (List) mapForDS.get("totalList");
		List<Integer> noOfDaysList = (List) mapForDS.get("noOfDaysList");
		List<String> remarksList = (List) mapForDS.get("remarksList");
		List<Integer> itemIdList = new ArrayList<Integer>();
		List<String> chargeCodeIdList = (List) mapForDS.get("chargeCodeIdList");
		
		
		String referedToMH = "";
		if(mapForDS.get("referedToMH") != null){
		  referedToMH =(String) mapForDS.get("referedToMH");
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
		String disposal = "";
		if(mapForDS.get("disposal")!=null){
			disposal = (String) mapForDS.get("disposal");
		}
		String days = "";
		if(mapForDS.get("days")!=null){
			days = (String) mapForDS.get("days");
		}
		
		List<String> referToMhList = new ArrayList<String>();
		if((List)mapForDS.get("referToMhList") != null){
			referToMhList = (List)mapForDS.get("referToMhList");
		}
		if(mapForDS.get("immuDtIdList")!=null){
			immuDtIdList = (List<Integer>)mapForDS.get("immuDtIdList");
		}
		if(mapForDS.get("immuIdList")!=null){
			immuIdList = (List<Integer>)mapForDS.get("immuIdList");
		}
		if(mapForDS.get("immuDateList")!=null){
			immuDateList = (List<String>)mapForDS.get("immuDateList");
		}
		if(mapForDS.get("doseList")!=null){
			doseList = (List<String>)mapForDS.get("doseList");
		}
		if(mapForDS.get("routeList")!=null){
			routeList = (List<String>)mapForDS.get("routeList");
		}
		if(mapForDS.get("immuNameList")!=null){
			immuNameList = (List<String>)mapForDS.get("immuNameList");
		}
		if(mapForDS.get("dueDateList")!=null){
			dueDateList = (List<String>)mapForDS.get("dueDateList");
		}
		boolean succesfullyAdded = true;
		Transaction tx = null;
		Session session = (Session)getSession();

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Patient patientObj = new Patient();
			MasHospital masHospital = new MasHospital();
			Visit visit=new Visit();
			MasDepartment masDepartment = new MasDepartment();
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentTimeWithoutSecond();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			OpdPatientDetails opdPatientDetails =  new OpdPatientDetails();
			int mileStoneCount = box.getInt("hiddenValue");
			if(box.getInt("visitId") != 0){
				Visit visitObj = new Visit();
				visitObj.setId(box.getInt("visitId"));
				opdPatientDetails.setVisit(visitObj);
			}
			if(box.getInt("hospitalId") != 0){
				masHospital.setId(box.getInt("hospitalId"));
				opdPatientDetails.setHospital(masHospital);
			}
			if(box.getInt("empId") !=0){
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(box.getInt("empId"));
				opdPatientDetails.setEmployee(masEmployee);
			}
			opdPatientDetails.setConsultationDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			opdPatientDetails.setConsultationTime(time);
			opdPatientDetails.setOpdDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			opdPatientDetails.setOpdTime(time);
			
			opdPatientDetails.setAge(box.getString("growthAge"));
			opdPatientDetails.setExpectedWeight(box.getString("expectedWeight"));
			opdPatientDetails.setExpectedHeight(box.getString("expectedHeight"));
			opdPatientDetails.setExpectedBmi(box.getString("expectedBmi"));
			
			
			opdPatientDetails.setChildAge(box.getString("childAge"));
			opdPatientDetails.setAChildWeight(box.getString("childWeight"));
			opdPatientDetails.setChildHeight(box.getString("childHeight"));
			opdPatientDetails.setAChildGender(box.getString("chieldGender"));
			opdPatientDetails.setChildChest(box.getString("childchest"));
			opdPatientDetails.setChildHeadCircumference(box.getString("childHeadCircumference"));
			opdPatientDetails.setChildRr(box.getString("chilRespiratoryRate"));
			opdPatientDetails.setHospName(box.getString("hospitalName"));
			opdPatientDetails.setTimeOfBirth(box.getString("timeOfBirth"));
			opdPatientDetails.setGestationalAge(box.getString("gestationalAge"));
			opdPatientDetails.setTypeOfDelivery(box.getString("typeOfDelivery"));
			opdPatientDetails.setDisposal(box.getString("disposal"));
			opdPatientDetails.setDays(box.getString("diposalDays"));
			opdPatientDetails.setMhRun(box.getString("referedToMH"));
			opdPatientDetails.setHeight(box.getString("growthHeight"));
			opdPatientDetails.setVweight(box.getString("growthWeight"));
			opdPatientDetails.setBmi(box.getString("growthBmi"));
			if(!box.getString("nextVisiDate").equals("")){
				opdPatientDetails.setNextVisitDate(HMSUtil.convertStringTypeDateToDateType(box.getString("nextVisiDate")));
			}
			if(referedToMH.equals("y")){
				opdPatientDetails.setMh(mhString);
				opdPatientDetails.setMhDepartment(mhDepartment);
				opdPatientDetails.setMhReferredFor(mhReferredFor);
			}
			if(!box.getString("dateAnc").equals("")){
			opdPatientDetails.setOpdDate(HMSUtil.convertStringTypeDateToDateType(box.getString("dateAnc")));
			}
			
			if(!box.getString("ageGrid").equals("")){
				opdPatientDetails.setChildAge(box.getString("ageGrid"));
			}
			if(!box.getString("clinicalExamination").equals("")){
				opdPatientDetails.setClinicalExamination(box.getString("clinicalExamination"));
			}
			if(!box.getString("bp").equals("")){
				opdPatientDetails.setBp(box.getString("bp"));
			}
			if(!box.getString("hb").equals("")){
				opdPatientDetails.setHb(box.getString("hb"));
			}
			if(!box.getString("urine").equals("")){
				opdPatientDetails.setUrine(box.getString("urine"));
			}
			if(!box.getString("eye").equals("")){
				opdPatientDetails.setEyeRemark(box.getString("eye"));
			}
			if(!box.getString("ent").equals("")){
				opdPatientDetails.setEntRemark(box.getString("ent"));
			}
			if(!box.getString("dental").equals("")){
				opdPatientDetails.setDentalRemark(box.getString("dental"));
			}
				hbt.save(opdPatientDetails);
				
			OpdPatientHistory opdPatientHistory = new OpdPatientHistory();
			if(box.getInt("visitId") != 0){
				opdPatientHistory.setVisitInpatientId(box.getInt("visitId"));
			}
			if(box.getInt("hospitalId") != 0){
				masHospital.setId(box.getInt("hospitalId"));
				opdPatientDetails.setHospital(masHospital);
			}
			if(box.getInt("hinId") != 0){
				patientObj.setId(box.getInt("hinId"));
				opdPatientHistory.setHin(patientObj);
			}
			if(box.getInt("departmentId") != 0){
				masDepartment.setId(box.getInt("departmentId"));
				opdPatientHistory.setDepartment(masDepartment);
			}
			opdPatientHistory.setOpdPatientDetails(opdPatientDetails);
			//opdPatientHistory.setIpOpPacStatus("OP");
			opdPatientHistory.setRiskFactor(box.getString("riskFactor"));
			opdPatientHistory.setPastMedicalHistory(box.getString("pastMedicalHistory"));
			opdPatientHistory.setPresentComplain(box.getString("perinatalHistory"));
			opdPatientHistory.setPresentAdvice(box.getString("presentAdvice"));
			opdPatientHistory.setLastChgTime(time);
			opdPatientHistory.setLastChgBy("admin");


			
			
			opdPatientHistory.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			opdPatientHistory.setStatus("y");
			hbt.save(opdPatientHistory);
			
			
			
	



		

		

			

			hbt.save(opdPatientHistory);
			for(int i = 1; i<=mileStoneCount; i++){
				PatientChildMilestoneDetail patientChildMilestoneDetail = new PatientChildMilestoneDetail();
				if(box.getInt("hinId") != 0){
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				patientChildMilestoneDetail.setHin(patient);
				
				patientObj.setId(box.getInt("hinId"));
				}
				if(box.getInt("visitId") != 0){
				Visit visitObj = new Visit();
				visitObj.setId(box.getInt("visitId"));
				patientChildMilestoneDetail.setVisit(visitObj);
				}
				
				patientChildMilestoneDetail.setOpdPatientDetail(opdPatientDetails);
				if(box.getInt("childMilestone"+i) != 0){
				MasChildMilestone masChildMilestone = new MasChildMilestone();
				masChildMilestone.setId(box.getInt("childMilestone"+i));
				patientChildMilestoneDetail.setMilestone(masChildMilestone);
				}
				if(!box.getString("result"+i).equals("")){
					patientChildMilestoneDetail.setResult(box.getString("result"+i));
				}
				if(!box.getString("remarks"+i).equals("")){
					patientChildMilestoneDetail.setRemarks(box.getString("remarks"+i));
				}
				if(!box.getString("normalAgeRange"+i).equals("")){
					patientChildMilestoneDetail.setNormalAgeRange(box.getString("normalAgeRange"+i));
				}
				if(box.getInt("hospitalId") != 0){
					masHospital.setId(box.getInt("hospitalId"));
					patientChildMilestoneDetail.setHospital(masHospital);
				}
				patientChildMilestoneDetail.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				patientChildMilestoneDetail.setLastChgTime(time);
				patientChildMilestoneDetail.setStatus("y");
				hbt.save(patientChildMilestoneDetail);
			}
			System.out.println("immuDtIdList==="+immuDtIdList.size());
			 if(immuDtIdList.size() > 0){
				   for (int l = 0; l < immuDtIdList.size(); l++)
				   {
					if(!immuDtIdList.get(l).equals("") && immuDtIdList.get(l) != 0)
					{
						PatientImmunizationDetails immunizationDetails = new PatientImmunizationDetails();
						immunizationDetails.setHin(patientObj);
						immunizationDetails.setHospital(masHospital);
						MasImmunization immunization = new MasImmunization();
						immunization.setId(immuDtIdList.get(l));
						immunizationDetails.setImmunization(immunization);
						
						//immunizationDetails.setImmunizationDetail(immuNameList.get(i));
						immunizationDetails.setDose(doseList.get(l));
						immunizationDetails.setRoute(routeList.get(l));
						if(!immuDateList.get(l).equals(""))
							immunizationDetails.setImmunizationDate(HMSUtil.convertStringTypeDateToDateType(immuDateList.get(l)));
						if(!dueDateList.get(l).equals(""))
							immunizationDetails.setDueDate(HMSUtil.convertStringTypeDateToDateType(dueDateList.get(l)));
					  //	immunizationDetails.setRemarks(remarksList.get(i));
						//immunizationDetails.setLastChgBy(user);
						//immunizationDetails.setLastChgDate(new Date());
						//immunizationDetails.setLastChgTime(time);
						hbt.save(immunizationDetails);
				}
			 }
		 }
			//------------code for investigation------------------------------------
				String[] chargeCodeIdArr = new String[box.getInt("hiddenValue")];
				if (chargeCodeIdList.size() > 0) {
					Patient patient = new Patient();
					MasEmployee masEmployee2 = new MasEmployee();
					PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
					patient.setId(box.getInt("hinId"));
					patientInvestigationHeader.setHin(patient);
					masDepartment.setId(box.getInt("departmentId"));
					patientInvestigationHeader.setDepartment(masDepartment);
					visit.setId(box.getInt("visitId"));
					patientInvestigationHeader.setVisit(visit);
					masHospital.setId(box.getInt("hospitalId"));
					patientInvestigationHeader.setHospital(masHospital);
					patientInvestigationHeader.setStatus("p");
					patientInvestigationHeader
							.setInvestigationDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
					patientInvestigationHeader.setInvestigationTime(time);
					patientInvestigationHeader.setClinicalNotes(box.getString("clinicalNotes1"));
					patientInvestigationHeader.setOpdPatientDetails(opdPatientDetails);
					hbt.save(patientInvestigationHeader);

					DgOrderhd dgOrderhd = new DgOrderhd();
					dgOrderhd.setOrderDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
					dgOrderhd.setOrderTime(time);
					masHospital.setId(box.getInt("hospitalId"));
					dgOrderhd.setHospital(masHospital);
					patient.setId(box.getInt("hinId"));
					dgOrderhd.setHin(patient);
					masDepartment.setId(box.getInt("departmentId"));
					dgOrderhd.setDepartment(masDepartment);
					if (box.getInt("empId") != 0) {
						masEmployee2.setId(box.getInt("empId"));
						dgOrderhd.setPrescribedBy(masEmployee2);
					}
					dgOrderhd.setPatientType("OP");
					dgOrderhd.setTestType("Regular");
					dgOrderhd.setCreatedby(box.getString("userName"));
					dgOrderhd.setCreatedon(HMSUtil.convertStringTypeDateToDateType(currentDate));
					dgOrderhd.setOrderNo(box.getString("orderSeqNo"));
					if (box.getInt("visitId") != 0) {
						visit = new Visit();
						visit.setId(box.getInt("visitId"));
						dgOrderhd.setVisit(visit);
					}
					dgOrderhd.setClinicalNote(box.getString("clinicalNotes1"));
					dgOrderhd.setOrderStatus("P");
					dgOrderhd.setLabOrderStatus("P");
					dgOrderhd.setLastChgBy(box.getInt("userId"));
					dgOrderhd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
					dgOrderhd.setLastChgTime(time);
					dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
					hbt.save(dgOrderhd);
					for (int i = 0; i < chargeCodeIdList.size(); i++) {
						PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
						patientInvestigationDetails
						.setInvestigationHeader(patientInvestigationHeader);
						MasChargeCode masChargeCode = new MasChargeCode();
						masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
						patientInvestigationDetails.setChargeCode(masChargeCode);
						patientInvestigationDetails.setReferToMh(referToMhList.get(i));
						hbt.save(patientInvestigationDetails);

						DgOrderdt dgOrderdt = new DgOrderdt();
						dgOrderdt.setOrderhd(dgOrderhd);
						masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
						dgOrderdt.setChargeCode(masChargeCode);
						dgOrderdt.setCreatedby(box.getString("userName"));
						dgOrderdt.setCreatedon(HMSUtil.convertStringTypeDateToDateType(currentDate));
						dgOrderdt.setLastChgBy(box.getInt("userId"));
						dgOrderdt.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
						dgOrderdt.setLastChgTime(time);
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
						dgOrderdt.setInvestigationToMH("n");
						dgOrderdt.setReferToMh(referToMhList.get(i));
						hbt.saveOrUpdate(dgOrderdt);
				}
			}
				//---------------------end of the code for investigation-----------------
		//-----------------------code for Treatment -------------------------------//
				PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
				int item_category_id=0;
				if(pvmsNoList.size() > 0 || (otherMedicineList != null && otherMedicineList.size() > 0)){
					patientObj.setId(box.getInt("hinId"));
					patientPrescriptionHeader.setHin(patientObj);
					masDepartment.setId(box.getInt("departmentId"));
					patientPrescriptionHeader.setDepartment(masDepartment);
					visit.setId(box.getInt("visitId"));
					patientPrescriptionHeader.setVisit(visit);
					masHospital.setId(box.getInt("hospitalId"));
					patientPrescriptionHeader.setHospital(masHospital);
					patientPrescriptionHeader.setStatus("p");
					patientPrescriptionHeader
							.setPrescriptionDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
					patientPrescriptionHeader.setPrescriptionTime(time);
					/**
					 * Code By Ritu 
					 * Created Foreign key relation for emp id in Database
					 */
					MasEmployee employee = new MasEmployee();
					employee.setId(box.getInt("empId"));
					patientPrescriptionHeader.setEmp(employee);
					
					/**
					 * End of code by Ritu
					 */
					int prescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);
					patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
					patientPrescriptionHeader.setOpdPatientDetails(opdPatientDetails);
					
					
					 /* This block is use for Check Injection in Prescription List*/
					 
					String sqlItemId="";
					
					for (int i = 0; i < pvmsNoList.size(); i++) {
						String pvmsNo = (String) pvmsNoList.get(i);
						int itemId = getItemIdFromPVMS(pvmsNo);
						if(i==0){
							sqlItemId=""+itemId;
						}else{
							sqlItemId +=" , "+itemId;
						}
						itemIdList.add(itemId);
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
						masItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id in ("+sqlItemId+") and ic.Id="+item_category_id);
					/*
		{
						Query qry=session.createQuery("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id in (:sqlItemId) and ic.Id=:item_category_id");
					
					if(!sqlItemId.equals("")){
							qry.setParameter("sqlItemId", sqlItemId);
						}
					if(item_category_id!=0){
						qry.setParameter("item_category_id", item_category_id);
					}
					masItemList = qry.list();
					}*/
					if(masItemList.size()>0){
						patientPrescriptionHeader.setInjectionStatus("p");
					}else{
						patientPrescriptionHeader.setInjectionStatus("n");
					}
					
					/* End Of Code This block is use for Check Injection in Prescription List*/
					 
					
					hbt.save(patientPrescriptionHeader);
				}
				if (pvmsNoList.size() > 0 ) {
					for (int i = 0; i < itemIdList.size(); i++) {
						
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
							if (totalList.get(i) != null && !totalList.get(i).equals("")) {
								patientPrescriptionDetails.setTotal(totalList.get(i));
							}
							patientPrescriptionDetails.setGivenQty(0);
										
						patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
					
						patientPrescriptionDetails.setDetailStatus("a");
						List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
//						storeItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id="+itemIdList.get(i)+" and ic.Id="+item_category_id);
						Query qry =session.createQuery("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id=:itemId and ic.Id=:item_category_id");
						if(item_category_id!=0){
							qry.setParameter("item_category_id", item_category_id);
						}
						if(!itemIdList.get(i).equals("0")){
							qry.setParameter("itemId", itemIdList.get(i));
						}
						storeItemList = qry.list();
						
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
													
							Query qryOne =session.createQuery("select inj from jkt.hms.masters.business.InjAppointmentHeader as inj join inj.Visit as visit where visit.Id=:visitId");
							if(box.getInt("visitId")!=0){
								qryOne.setParameter("visitId", box.getInt("visitId"));
							}
							
							injectionRegisterList = qryOne.list();
							
							
							InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();
							
							  if(injectionRegisterList.size()>0) /*means , Data is already available In InjectionRegister table */ 
							 
							if(injectionRegisterList.size()>0){
								for (InjAppointmentHeader injectionRegisterTemp : injectionRegisterList) {
									injectionAppointment.setId(injectionRegisterTemp.getId());
								}
							}else{
								injectionAppointment.setAppointmentDate(new Date());
								Patient patientInj = new Patient();
								patientInj.setId(box.getInt("hinId"));
								injectionAppointment.setHin(patientInj);
								Visit visitInj = new Visit();
								visitInj.setId(box.getInt("visitId"));
								injectionAppointment.setVisit(visitInj);
								MasHospital masHospitalInj = new MasHospital();
								masHospitalInj.setId(box.getInt("hospitalId"));
								injectionAppointment.setHospital(masHospitalInj);
								
								injectionAppointment.setStatus("p");
								injectionAppointment.setLastChgTime(time);
								Users user = new Users();
								user.setId(box.getInt(""));
								injectionAppointment.setLastChgBy(user);
								//injectionAppointment.setLastChgDate(date);
								injectionAppointment.setPrescription(patientPrescriptionHeader);
								hbt.save(injectionAppointment);
							}
							int freqCount=0;
							if(frequencyList.get(i) > 10){
								freqCount = 1;  /*if frequency is greater than 10 then only one entry will go in Injection Appointment table */
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
				if(otherMedicineList != null && otherMedicineList.size() > 0){
					String sqlItemId="";
					int itemId = 0;
					List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
					String otherItem = "";
					if(otherMedicineList.size() >0){
					for(int i = 0; i < otherMedicineList.size(); i++){
						MasStoreItem masItem = new MasStoreItem();
						if(otherMedicineList.get(i) != null){
							otherItem =(String)otherMedicineList.get(i);
							masItem.setNomenclature(otherMedicineList.get(i));
							MasStoreSection masStoreSection = new MasStoreSection();
							masStoreSection.setId(1);
							masItem.setSection(masStoreSection);
							masItem.setStatus("y");
							masItem.setBrandedGeneric("B");
							MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
							masStoreItemConversion.setId(1);
							masItem.setItemConversion(masStoreItemConversion);
							itemCodeList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo", "NIV%"))
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
							}
							masItem.setPvmsNo(itemNo);
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
							Query qryTwo =session.createQuery("select inj from jkt.hms.masters.business.InjAppointmentHeader as inj join inj.Visit as visit where visit.Id=:visitId");
							if(box.getInt("visitId")!=0){
								qryTwo.setParameter("visitId", box.getInt("visitId"));
							}
							
							injectionRegisterList = qryTwo.list();
							InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();
							
							 /* if(injectionRegisterList.size()>0) means , Data is already available In InjectionRegister table  */
							 
							if(injectionRegisterList.size()>0){
								for (InjAppointmentHeader injectionRegisterTemp : injectionRegisterList) {
									injectionAppointment.setId(injectionRegisterTemp.getId());
								}
							}else{
								injectionAppointment.setAppointmentDate(new Date());
								Patient patientInj = new Patient();
								patientInj.setId(box.getInt("hinId"));
								injectionAppointment.setHin(patientInj);
								Visit visitInj = new Visit();
								visitInj.setId(box.getInt("visitId"));
								injectionAppointment.setVisit(visitInj);
								MasHospital masHospitalInj = new MasHospital();
								masHospitalInj.setId(box.getInt("hospitalId"));
								injectionAppointment.setHospital(masHospitalInj);
								injectionAppointment.setStatus("p");
								injectionAppointment.setLastChgTime(time);
								Users user = new Users();
								user.setId(box.getInt("userId"));
								injectionAppointment.setLastChgBy(user);
								injectionAppointment.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
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
				
			System.out.println("visitId==="+box.getInt("visitId"));	
			 Visit visitObjToUpdate = (Visit) hbt.load(Visit.class, box.getInt("visitId"));
				visitObjToUpdate.setVisitStatus("C");
				hbt.update(visitObjToUpdate);
			succesfullyAdded = true;
		tx.commit();	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
		map.put("succesfullyAdded", succesfullyAdded);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showFamilyPlanningJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit>familyPlanningList = new ArrayList<Visit>();
		List<MasReligion>religionList = new ArrayList<MasReligion>();
//		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
//		List<MasMedicalExaminationReportOnEntry> medicalList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
	    PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
	    List<MasChargeCode>chargeCodeList = new ArrayList<MasChargeCode>();
		Session session = (Session)getSession();
		int deptId = 0;
		if(generalMap.get("deptId") != null){
			deptId = (Integer)generalMap.get("deptId");
		}
		int visitId = 0;
		if(generalMap.get("visitId") != null){
			visitId = (Integer)generalMap.get("visitId");
		}
		int hospitalId = 0;
		if(generalMap.get("hospitalId") != null){
			hospitalId = (Integer)generalMap.get("hospitalId");
		}
		religionList = session.createCriteria(MasReligion.class).add(Restrictions.eq("Status", "y")).list();
		familyPlanningList = session.createCriteria(Visit.class).add(Restrictions.idEq(visitId)).list();
//		medicalList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("Visit.Id",visitId )).list();
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
				.add(Restrictions.eq("InvestigationHeader.Id",patientInvestigationHeader.getId())).addOrder(Order.asc("ReferToMh")).addOrder(Order.asc("ChargeCode.Id")).list();
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
			   map.put("dgOrderdtList", dgOrderdtList);
		}
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		resultList = session.createCriteria(DgResultEntryHeader.class)
		.createAlias("SampleCollectionHeader", "smColl").createAlias("smColl.Order", "order")
		.createAlias("order.Visit", "vst").add(Restrictions.eq("vst.Id", visitId))
		.add(Restrictions.eq("ResultStatus", "A"))
			.addOrder(Order.asc("DgMasInvestigation.Id")).list();
	//	.addOrder(Order.asc("LastChgdDate")).addOrder(Order.asc("LastChgdTime")).list();
       if (resultList != null || resultList.size() > 0) {
    	map.put("resultList", resultList);
        }
       List<FamilyPlanning>planningList = new ArrayList<FamilyPlanning>();
       
	   planningList = session.createCriteria(FamilyPlanning.class).add(Restrictions.eq("Visit.Id", visitId)).add(Restrictions.eq("Status", "p").ignoreCase()).list();
	   chargeCodeList = session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status", "y")).list();
		 
	    employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
		map.put("employeeList", employeeList);
	    map.put("familyPlanningList", familyPlanningList);
//		map.put("medicalList", medicalList);
		map.put("planningList", planningList);
		map.put("religionList", religionList);
		map.put("chargeCodeList", chargeCodeList);
		return map;
	}

	@Override
	public Map<String, Object> submitfamilyPlanningDetails(Box box, Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> chargeCodeIdList = new ArrayList<String>();
		List<String> referToMhList = new ArrayList<String>();
		List<FamilyPlanning>planningList = new ArrayList<FamilyPlanning>();
		if(generalMap.get("chargeCodeIdList") != null){
			chargeCodeIdList = (List)generalMap.get("chargeCodeIdList");
		}
		if(generalMap.get("referToMhList") != null){
			referToMhList = (List)generalMap.get("referToMhList");
		}
		boolean sucessfullyAdded = false;
		try {
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentTimeWithoutSecond();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			//------------code for investigation------------------------------------
			String[] chargeCodeIdArr = new String[box.getInt("hiddenValue")];
			if (chargeCodeIdList.size() > 0) {
				Patient patient = new Patient();
				MasEmployee masEmployee2 = new MasEmployee();
				PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
				patient.setId(box.getInt("hinId"));
				patientInvestigationHeader.setHin(patient);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(box.getInt("deptId"));
				patientInvestigationHeader.setDepartment(masDepartment);
				Visit visit = new Visit();
				visit.setId(box.getInt("visitId"));
				patientInvestigationHeader.setVisit(visit);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(box.getInt("hospitalId"));
				patientInvestigationHeader.setHospital(masHospital);
				patientInvestigationHeader.setStatus("p");
				patientInvestigationHeader
						.setInvestigationDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				patientInvestigationHeader.setInvestigationTime(time);
				//patientInvestigationHeader.setClinicalNotes(box.getString("clinicalNotes1"));
				//patientInvestigationHeader.setOpdPatientDetails(opdPatientDetails);
				hbt.save(patientInvestigationHeader);

				DgOrderhd dgOrderhd = new DgOrderhd();
				dgOrderhd.setOrderDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				dgOrderhd.setOrderTime(time);
				masHospital.setId(box.getInt("hospitalId"));
				dgOrderhd.setHospital(masHospital);
				patient.setId(box.getInt("hinId"));
				dgOrderhd.setHin(patient);
				masDepartment.setId(box.getInt("deptId"));
				dgOrderhd.setDepartment(masDepartment);
				if (box.getInt("empId") != 0) {
					masEmployee2.setId(box.getInt("empId"));
					dgOrderhd.setPrescribedBy(masEmployee2);
				}
				dgOrderhd.setPatientType("OP");
				dgOrderhd.setTestType("Regular");
				dgOrderhd.setCreatedby(box.getString("userName"));
				dgOrderhd.setCreatedon(HMSUtil.convertStringTypeDateToDateType(currentDate));
				dgOrderhd.setOrderNo(box.getString("orderSeqNo"));
				if (box.getInt("visitId") != 0) {
					visit = new Visit();
					visit.setId(box.getInt("visitId"));
					dgOrderhd.setVisit(visit);
				}
				//dgOrderhd.setClinicalNote(box.getString("clinicalNotes1"));
				dgOrderhd.setOrderStatus("P");
				dgOrderhd.setLabOrderStatus("P");
				dgOrderhd.setLastChgBy(box.getInt("userId"));
				dgOrderhd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				dgOrderhd.setLastChgTime(time);
				dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
				hbt.save(dgOrderhd);
				for (int i = 0; i < chargeCodeIdList.size(); i++) {
					PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
					patientInvestigationDetails
					.setInvestigationHeader(patientInvestigationHeader);
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
					patientInvestigationDetails.setChargeCode(masChargeCode);
					patientInvestigationDetails.setReferToMh(referToMhList.get(i));
					hbt.save(patientInvestigationDetails);

					DgOrderdt dgOrderdt = new DgOrderdt();
					dgOrderdt.setOrderhd(dgOrderhd);
					masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
					dgOrderdt.setChargeCode(masChargeCode);
					dgOrderdt.setCreatedby(box.getString("userName"));
					dgOrderdt.setCreatedon(HMSUtil.convertStringTypeDateToDateType(currentDate));
					dgOrderdt.setLastChgBy(box.getInt("userId"));
					dgOrderdt.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
					dgOrderdt.setLastChgTime(time);
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
					dgOrderdt.setInvestigationToMH("n");
					dgOrderdt.setReferToMh(referToMhList.get(i));
					hbt.saveOrUpdate(dgOrderdt);
			}
		}
			//---------------------end of the code for investigation-----------------
			FamilyPlanning familyPlanning = new FamilyPlanning();
			familyPlanning.setYearNo(box.getInt("yearNo"));
			familyPlanning.setMonthNo(box.getInt("monthNo"));
			familyPlanning.setFamilyPlanning(box.getString("familyPlanning"));
			familyPlanning.setRegistrationNo(box.getString("regNo"));
			familyPlanning.setPlanDate(HMSUtil.convertStringTypeDateToDateType(box.getString("planDate")));
			familyPlanning.setPlanTime(box.getString("planTime"));
			familyPlanning.setHusbandAge(box.getString("husbandAge").concat("Years"));
			familyPlanning.setHusbandEducation(box.getString("husbandEdu"));
			familyPlanning.setWifeEducation(box.getString("wifeEdu"));
			familyPlanning.setWifeAge(box.getString("wifeAge").concat("Years"));
			familyPlanning.setDoctorName(box.getString("doctorName"));
			familyPlanning.setHospitalName(box.getString("hospitalName"));
			familyPlanning.setAddress(box.getString("address"));
			familyPlanning.setNoOfChild(box.getInt("noOfChildren"));
			if(box.getInt("religionId")!=0){
			MasReligion masReligion = new MasReligion();
			masReligion.setId(box.getInt("religionId"));
			familyPlanning.setReligion(masReligion);
			}
			Users users = new Users();
			users.setId(box.getInt("userId"));
			familyPlanning.setLastChgBy(users);
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			familyPlanning.setHin(patient);
			Visit visit = new Visit();
			visit.setId(box.getInt("visitId"));
			familyPlanning.setVisit(visit);
			familyPlanning.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			familyPlanning.setLastChgTime(time);
			familyPlanning.setStatus("p");
			hbt.save(familyPlanning);
			/*Visit visitsave = new Visit();
			visitsave=(Visit) hbt.load(Visit.class, box.getInt("visitId"));
			visitsave.setVisitStatus("C");
			hbt.update(visitsave);*/
			sucessfullyAdded = true;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		map.put("sucessfullyAdded", sucessfullyAdded);
		return map;
	}

	@Override
	public Map<String, Object> showSterilisationWaitinglistJsp(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session =(Session)getSession();
		List<FamilyPlanning> familyPlanningList = new ArrayList<FamilyPlanning>();
		int hinId = 0;
		int visitId = 0;
		int hospitalId = 0;
		if(generalMap.get("hinId") != null){
			hinId = (Integer)generalMap.get("hinId");
		}
		if(generalMap.get("visitId") != null){
			visitId = (Integer)generalMap.get("visitId");
		}
		if(generalMap.get("hospitalId") != null){
			hospitalId = (Integer)generalMap.get("hospitalId");
		}
		/*familyPlanningList = session.createCriteria(FamilyPlanning.class).createAlias("Hin", "hin")
								.add(Restrictions.eq("hin.Id", hinId)).add(Restrictions.eq("Visit.Id", visitId)).add(Restrictions.eq("Status", "f")).list();
		*/
		
		familyPlanningList = session.createCriteria(FamilyPlanning.class).add(Restrictions.eq("Status", "f")).list();

		map.put("familyPlanningList", familyPlanningList);
		return map;
	}

	@Override
	public Map<String, Object> showImmunisationJsp(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<Visit> visitList = new ArrayList<Visit>();
		int visitId = 0;
		if(dataMap.get("visitId") != null){
			visitId =(Integer)dataMap.get("visitId");
		}
		visitList = session.createCriteria(Visit.class).add(Restrictions.idEq(visitId)).list();
		map.put("visitList", visitList);
		return map;
	}

	@Override
	public Map<String, Object> submitFwcImmunizationDetail(Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<Integer> immuDtIdList  = new ArrayList<Integer>();
		List<Integer> immuIdList  = new ArrayList<Integer>();
		List<String> immuDateList  = new ArrayList<String>();
		List<String> doseList  = new ArrayList<String>();
		List<String> routeList  = new ArrayList<String>();
		List<String> dueDateList  = new ArrayList<String>();
		List<String> immuNameList=new ArrayList<String>();
		boolean status=false;
		Session session = (Session)getSession();
		try{
			int hospitalId=0;
			int hinId=0;
			int visitId = 0;
		if(mapForDS.get("hospitalId")!=null){
			hospitalId = (Integer)mapForDS.get("hospitalId");
		}
		if(mapForDS.get("hinId")!=null){
			hinId = (Integer)mapForDS.get("hinId");
		}
		if(mapForDS.get("visitId")!=null){
			visitId = (Integer)mapForDS.get("visitId");
		}
		if(mapForDS.get("immuDtIdList")!=null){
			immuDtIdList = (List<Integer>)mapForDS.get("immuDtIdList");
		}
		if(mapForDS.get("immuIdList")!=null){
			immuIdList = (List<Integer>)mapForDS.get("immuIdList");
		}
		if(mapForDS.get("immuDateList")!=null){
			immuDateList = (List<String>)mapForDS.get("immuDateList");
		}
		if(mapForDS.get("doseList")!=null){
			doseList = (List<String>)mapForDS.get("doseList");
		}
		if(mapForDS.get("routeList")!=null){
			routeList = (List<String>)mapForDS.get("routeList");
		}
		if(mapForDS.get("immuNameList")!=null){
			immuNameList = (List<String>)mapForDS.get("immuNameList");
		}
		if(mapForDS.get("dueDateList")!=null){
			dueDateList = (List<String>)mapForDS.get("dueDateList");
		}
		String immunizationType = "";
		if(mapForDS.get("immunizationType")!=null){
			immunizationType = (String)mapForDS.get("immunizationType");
		}
		MasHospital masHospital=new MasHospital();
		masHospital.setId(hospitalId);
		Patient patientObj = new Patient();
		patientObj.setId(hinId);
	     if(immuNameList.size() > 0){
		   for (int i = 0; i < immuNameList.size(); i++)
		   {
			if(!immuNameList.get(i).equals(""))
			{
				PatientImmunizationDetails immunizationDetails = new PatientImmunizationDetails();
				immunizationDetails.setHin(patientObj);
				immunizationDetails.setHospital(masHospital);
			/*	MasImmunization immunization = new MasImmunization();
				immunization.setId(immuIdList.get(i));
				immunizationDetails.setImmunization(immunization);*/
				immunizationDetails.setImmunizationDetail(immuNameList.get(i));
				immunizationDetails.setDose(doseList.get(i));
				immunizationDetails.setRoute(routeList.get(i));
				immunizationDetails.setFlag(immunizationType);
				if(!immuDateList.get(i).equals(""))
					immunizationDetails.setImmunizationDate(HMSUtil.convertStringTypeDateToDateType(immuDateList.get(i)));
				if(!dueDateList.get(i).equals(""))
					immunizationDetails.setDueDate(HMSUtil.convertStringTypeDateToDateType(dueDateList.get(i)));
			  //	immunizationDetails.setRemarks(remarksList.get(i));
				//immunizationDetails.setLastChgBy(user);
				//immunizationDetails.setLastChgDate(new Date());
				//immunizationDetails.setLastChgTime(time);
				hbt.save(immunizationDetails);
				status=true;
			}
		 }
	   //----------------update visit table---------------------------------------------------
			Visit visitObjToUpdate = (Visit) hbt.load(Visit.class, visitId);
			visitObjToUpdate.setVisitStatus("C");
			hbt.update(visitObjToUpdate);
			//----------------------------------
			
	  }
			
	}catch (Exception e)
	{
	    e.printStackTrace();
	}
	map.put("status", status);
		return map;
	}

	@Override
	public Map<String, Object> printHealthCard(Map<String, Object> requestParameters) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientDetails> pediatricsChartList = new ArrayList<OpdPatientDetails>();
		Session session = (Session)getSession();
		int visitId =0;
		if(requestParameters.get("visitId") != null){
			visitId = (Integer)requestParameters.get("visitId");
		}
		int hinId =0;
		if(requestParameters.get("hinId") != null){
			hinId = (Integer)requestParameters.get("hinId");
		}
/*		pediatricsChartList =session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v")
								.add(Restrictions.eq("v.Id", visitId)).list();*/
		
		
		pediatricsChartList =session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").add(Restrictions.eq("v.ReportingFor", "FamilyWC"))
		.add(Restrictions.eq("v.FwcCategory", "WELL BABY")).createAlias("v.Hin", "h").add(Restrictions.eq("h.Id",hinId)).list();
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("Average Weight");
      	if (pediatricsChartList.size() > 0) {
			
			for (OpdPatientDetails opdPatientDetails: pediatricsChartList) {
			//	double temp = 0;
				String childWeight = "";
				String age = "";
				
				Hour hour = null;
				/*if (ipdTemperature.getTemperature() != null) 
					temp = ipdTemperature.getTemperature();
				}*/

				if (opdPatientDetails.getAChildWeight() != null) {
					childWeight = opdPatientDetails.getAChildWeight();
				}
				if (opdPatientDetails.getChildAge() != null) {
					age= opdPatientDetails.getChildAge();
				}
				if(!age.equals("") && !childWeight.equals("")){
					series1.addOrUpdate(Integer.parseInt(age), (Integer.parseInt(childWeight)));
				}

			}
			dataset.addSeries(series1);
		} else 
		{
			map.put("status", "nodata");
		}

      	JFreeChart chart = ChartFactory.createXYLineChart
      	("Weight for age Girls", "Age(completed months and years)", "Weight(kg)",
      			dataset, PlotOrientation.VERTICAL, true, true, false);
      /*	ChartFrame frame1=new ChartFrame("XYLine Chart",chart);
      	frame1.setVisible(true);
        frame1.setSize(300,300);*/
      	
    	chart.setBackgroundPaint(Color.white);

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		plot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
    
		XYItemRenderer pr = plot.getRenderer();
		if (pr instanceof XYLineAndShapeRenderer) {
			XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) pr;
			renderer.setBaseShapesVisible(true);
			renderer.setBaseShapesFilled(true);
			
		}
		NumberAxis paxis = (NumberAxis) plot.getDomainAxis();
		paxis.setAutoRange(true);
		JFreeChartRenderer jfcRenderer = new JFreeChartRenderer(chart);
		chart.getBackgroundImage();
		map.put("jfcRenderer", jfcRenderer);
		map.put("chart", chart);
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}
	
	@Override
	public Map<String, Object> printHealthCardHeight(Map<String, Object> requestParameters) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientDetails> pediatricsChartList = new ArrayList<OpdPatientDetails>();
		Session session = (Session)getSession();
		int visitId =0;
		if(requestParameters.get("visitId") != null){
			visitId = (Integer)requestParameters.get("visitId");
		}
		int hinId =0;
		if(requestParameters.get("hinId") != null){
			hinId = (Integer)requestParameters.get("hinId");
		}
/*		pediatricsChartList =session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v")
								.add(Restrictions.eq("v.Id", visitId)).list();*/
		
		
		pediatricsChartList =session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").add(Restrictions.eq("v.ReportingFor", "FamilyWC"))
		.add(Restrictions.eq("v.FwcCategory", "WELL BABY")).createAlias("v.Hin", "h").add(Restrictions.eq("h.Id",hinId)).list();
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("Average Weight");
      	if (pediatricsChartList.size() > 0) {
			
			for (OpdPatientDetails opdPatientDetails: pediatricsChartList) {
			//	double temp = 0;
				String childHeight = "";
				String age = "";
				
				Hour hour = null;
				/*if (ipdTemperature.getTemperature() != null) 
					temp = ipdTemperature.getTemperature();
				}*/

				if (opdPatientDetails.getChildHeight() != null) {
					childHeight = opdPatientDetails.getChildHeight();
				}
				if (opdPatientDetails.getChildAge() != null) {
					age= opdPatientDetails.getChildAge();
				}
				if(!age.equals("") && !childHeight.equals("")){
					series1.addOrUpdate(Integer.parseInt(age), (Integer.parseInt(childHeight)));
				}

			}
			dataset.addSeries(series1);
		} else 
		{
			map.put("status", "nodata");
		}

      	JFreeChart chart = ChartFactory.createXYLineChart
      	("Length/Height for age Girls", "Age(completed months and years)", "Length/Height(cm)",
      			dataset, PlotOrientation.VERTICAL, true, true, false);
      /*	ChartFrame frame1=new ChartFrame("XYLine Chart",chart);
      	frame1.setVisible(true);
        frame1.setSize(300,300);*/
      	
    	chart.setBackgroundPaint(Color.white);

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		plot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
    
		XYItemRenderer pr = plot.getRenderer();
		if (pr instanceof XYLineAndShapeRenderer) {
			XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) pr;
			renderer.setBaseShapesVisible(true);
			renderer.setBaseShapesFilled(true);
			
		}
		NumberAxis paxis = (NumberAxis) plot.getDomainAxis();
		paxis.setAutoRange(true);
		JFreeChartRenderer jfcRenderer = new JFreeChartRenderer(chart);
		chart.getBackgroundImage();
		map.put("jfcRenderer", jfcRenderer);
		map.put("chart", chart);
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}
	@Override
	public Map<String, Object> printHealthCardHeadCircumference(Map<String, Object> requestParameters) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientDetails> pediatricsChartList = new ArrayList<OpdPatientDetails>();
		Session session = (Session)getSession();
		int visitId =0;
		if(requestParameters.get("visitId") != null){
			visitId = (Integer)requestParameters.get("visitId");
		}
		int hinId =0;
		if(requestParameters.get("hinId") != null){
			hinId = (Integer)requestParameters.get("hinId");
		}
/*		pediatricsChartList =session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v")
								.add(Restrictions.eq("v.Id", visitId)).list();*/
		
		
		pediatricsChartList =session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").add(Restrictions.eq("v.ReportingFor", "FamilyWC"))
		.add(Restrictions.eq("v.FwcCategory", "WELL BABY")).createAlias("v.Hin", "h").add(Restrictions.eq("h.Id",hinId)).list();
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("Average Weight");
      	if (pediatricsChartList.size() > 0) {
			
			for (OpdPatientDetails opdPatientDetails: pediatricsChartList) {
			//	double temp = 0;
				String childHeadCircumference = "";
				String age = "";
				
				Hour hour = null;
				/*if (ipdTemperature.getTemperature() != null) 
					temp = ipdTemperature.getTemperature();
				}*/

				if (opdPatientDetails.getChildHeadCircumference() != null) {
					childHeadCircumference = opdPatientDetails.getChildHeadCircumference();
				}
				if (opdPatientDetails.getChildAge() != null) {
					age= opdPatientDetails.getChildAge();
				}
				if(!age.equals("") && !childHeadCircumference.equals("")){
					series1.addOrUpdate(Integer.parseInt(age), (Integer.parseInt(childHeadCircumference)));
				}

			}
			dataset.addSeries(series1);
		} else 
		{
			map.put("status", "nodata");
		}

      	JFreeChart chart = ChartFactory.createXYLineChart
      	("Head circumference for age Girls", "Age(completed months and years)", "Head circumference(cm)",
      			dataset, PlotOrientation.VERTICAL, true, true, false);
      /*	ChartFrame frame1=new ChartFrame("XYLine Chart",chart);
      	frame1.setVisible(true);
        frame1.setSize(300,300);*/
      	
    	chart.setBackgroundPaint(Color.white);

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		plot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
    
		XYItemRenderer pr = plot.getRenderer();
		if (pr instanceof XYLineAndShapeRenderer) {
			XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) pr;
			renderer.setBaseShapesVisible(true);
			renderer.setBaseShapesFilled(true);
			
		}
		NumberAxis paxis = (NumberAxis) plot.getDomainAxis();
		paxis.setAutoRange(true);
		JFreeChartRenderer jfcRenderer = new JFreeChartRenderer(chart);
		chart.getBackgroundImage();
		map.put("jfcRenderer", jfcRenderer);
		map.put("chart", chart);
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	@Override
	public Map<String, Object> forwardToMoFamilyPlanning(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int familyPlanningId = box.getInt("familyPlanningId");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx = null;
		Session session = (Session)getSession();
		boolean saved = false;
		try {
			tx = session.beginTransaction();
			FamilyPlanning familyPlanning = (FamilyPlanning)hbt.load(FamilyPlanning.class, familyPlanningId);
			familyPlanning.setStatus("f");
			MasEmployee mo = new MasEmployee();
			mo.setId(box.getInt("mo"));
			familyPlanning.setMo(mo);
			hbt.update(familyPlanning);
			
			Visit visitsave = new Visit();
			visitsave=(Visit) hbt.load(Visit.class, box.getInt("visitId"));
			visitsave.setVisitStatus("C");
			hbt.update(visitsave);
			saved = true;
			tx.commit();
		} catch (DataAccessException e) {
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		
		map.put("saved", saved);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showIssueSterilizationCertificateJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int visitId = box.getInt("visitId");
		Session session = (Session)getSession();
		List<PatientInvestigationHeader> patientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
		List<FamilyPlanning> planningList = new ArrayList<FamilyPlanning>();
	       
	    planningList = session.createCriteria(FamilyPlanning.class).add(Restrictions.eq("Visit.Id", visitId)).list();
		  
		patientInvestigationHeaderList = (List<PatientInvestigationHeader>) session.createCriteria(PatientInvestigationHeader.class)
						.createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId))
						.addOrder(Order.desc("Id")).list();
		if (patientInvestigationHeaderList != null && patientInvestigationHeaderList.size() > 0) {
			patientInvestigationHeader = patientInvestigationHeaderList.get(0);
			map.put("patientInvestigationHeader",patientInvestigationHeader);

		}
		if (patientInvestigationHeaderList != null && patientInvestigationHeaderList.size() > 0) {
			patientInvestigationHeader = patientInvestigationHeaderList.get(0);
			map.put("patientInvestigationHeader",patientInvestigationHeader);
			
			List<PatientInvestigationDetails> patientInvestigationDetailsList= new ArrayList<PatientInvestigationDetails>();
			patientInvestigationDetailsList = session.createCriteria(PatientInvestigationDetails.class)
				.add(Restrictions.eq("InvestigationHeader.Id",patientInvestigationHeader.getId())).addOrder(Order.asc("ReferToMh")).addOrder(Order.asc("ChargeCode.Id")).list();

			map.put("patientInvestigationDetailsList",patientInvestigationDetailsList);

		}
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		dgOrderhdList = (List<DgOrderhd>) session.createCriteria(DgOrderhd.class).createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();

		DgOrderhd dgOrderhd =null;
		if (dgOrderhdList != null && dgOrderhdList.size() > 0) {
			dgOrderhd = dgOrderhdList.get(0);

			map.put("dgOrderhd",dgOrderhd);
			List<DgOrderdt> dgOrderdtList=session.createCriteria(DgOrderdt.class).add(Restrictions.eq("Orderhd.Id", dgOrderhd.getId()))
				.addOrder(Order.asc("LastChgDate")).addOrder(Order.asc("LastChgTime")).list();
			map.put("dgOrderdtList", dgOrderdtList);
		}
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		resultList = session.createCriteria(DgResultEntryHeader.class).createAlias("SampleCollectionHeader", "smColl").createAlias("smColl.Order", "order")
					.createAlias("order.Visit", "vst").add(Restrictions.eq("vst.Id", visitId))
					.add(Restrictions.eq("ResultStatus", "A"))
					.addOrder(Order.asc("DgMasInvestigation.Id")).list();
		if (resultList != null || resultList.size() > 0) {
			map.put("resultList", resultList);
		}
		if(planningList.size() > 0){
			map.put("famPlanId", planningList.get(0).getId());
		}
		return map;
	}

	@Override
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	@Override
	public Map<String, Object> issueSterilisationCertificate(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int famPlanId =  box.getInt("famPlanId");
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean saved = false;
		FamilyPlanning familyPlanning = (FamilyPlanning)hbt.load(FamilyPlanning.class, famPlanId);
		familyPlanning.setStatus("c");
		hbt.update(familyPlanning);
		saved = true;
		map.put("saved", saved);
		return map;
	}

	@Override
	public Map<String, Object> showAntentatalCardJsp(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientDetails> fwcOpdDetailList = new ArrayList<OpdPatientDetails>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<MasMedicalExaminationReportOnEntry> medicalList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		List<PatientFamilyHistory> patientFamilyHistoryList=new ArrayList<PatientFamilyHistory>();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		List<OpdPatientHistory> fwcOpdDetailHistoryList = new ArrayList<OpdPatientHistory>();
		Session session = (Session)getSession();
		int visitId = 0;
		if(dataMap.get("visitId") != null){
			visitId = (Integer)dataMap.get("visitId");
		}
		int hinId = 0;
		if(dataMap.get("hinId") != null){
			hinId = (Integer)dataMap.get("hinId");
		}
		int deptId = 0;
		if(dataMap.get("deptId") != null){
			deptId = (Integer)dataMap.get("deptId");
		}
		String cat[] = {"ANC"};
		templateList = session.createCriteria(OpdTemplate.class).createAlias("Department", "dept").add(
				Restrictions.eq("dept.Id", deptId)).add(Restrictions.eq("Status", "y")).list();
		//fwcOpdDetailList =session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "visit").createAlias("visit.Hin", "hin").add(Restrictions.eq("hin.Id", hinId)).list();
		fwcOpdDetailList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "visit").createAlias("visit.Hin", "hin").add(Restrictions.eq("hin.Id", hinId))
		.add(Restrictions.in("visit.FwcCategory",cat)).add(Restrictions.eq("visit.ReportingFor", "FamilyWC")).add(Restrictions.ne("visit.Id",visitId)).setMaxResults(1).addOrder(Order.desc("visit.Id")).list();
	
		
		medicalList = session.createCriteria(MasMedicalExaminationReportOnEntry.class).add(Restrictions.eq("Visit.Id",visitId )).list();
		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y")).list();
		disposalList = session.createCriteria(MasDisposal.class).add(Restrictions.eq("Status", "y")).list();
		patientFamilyHistoryList= session.createCriteria(PatientFamilyHistory.class).add(
				Restrictions.eq("Status", "y")).list();
		fwcOpdDetailHistoryList=session.createCriteria(OpdPatientHistory.class).add(Restrictions.eq("Hin.Id", hinId)).list();
		map.put("fwcPatientDataList", fwcOpdDetailList);
		map.put("medicalList", medicalList);
		map.put("frequencyList", frequencyList);
		map.put("disposalList", disposalList);
		map.put("templateList", templateList);
		map.put("patientFamilyHistoryList", patientFamilyHistoryList);
		map.put("fwcOpdDetailHistoryList", fwcOpdDetailHistoryList);
		return map;
 
	}

	@Override
	public Map<String, Object> submitAntenatalCardFollowUp(Box box,
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Transaction tx = null;
		
		String orderSeqNo = "";
		

		String dateAnc = (String) mapForDS.get("dateAnc");
		String dateNextVisit = (String) mapForDS.get("dateNextVisit");
		String fundal = (String) mapForDS.get("fundal");
		int pog = (Integer) mapForDS.get("pog");
		String weight = (String) mapForDS.get("weight");
		String bp = (String) mapForDS.get("bp");
		String pp = (String) mapForDS.get("pp");
		String foetalHeart = (String) mapForDS.get("foetalHeart");
		String foetalHeadEngaged = (String) mapForDS.get("foetalHeadEngaged");
		String oedema = (String) mapForDS.get("oedema");
		String alb = (String) mapForDS.get("alb");
		String sugar = (String) mapForDS.get("sugar");
		String hb = (String) mapForDS.get("hb");
		String complaint = (String) mapForDS.get("complaint");
		String remarks = (String) mapForDS.get("remarks");
		String pollor = (String) mapForDS.get("pollor");
		
		
		//int userId = (Integer) mapForDS.get("userId");
		String userName = (String) mapForDS.get("userName");
		List pvmsNoList = (List) mapForDS.get("pvmsNoList");
		List<Integer> frequencyList = (List) mapForDS.get("frequencyList");
		List<String> otherMedicineList = (List) mapForDS.get("otherMedicineList");
		List<String> ctList = (List) mapForDS.get("ctList");
		List<String> dosageList = (List) mapForDS.get("dosageList");
		List<String> routeList= (List) mapForDS.get("routeList");
		List<Integer> totalList = (List) mapForDS.get("totalList");
		List<Integer> noOfDaysList = (List) mapForDS.get("noOfDaysList");
		List<String> remarksList = (List) mapForDS.get("remarksList");
		List<Integer> itemIdList = new ArrayList<Integer>();
		List<String> chargeCodeIdList = (List) mapForDS.get("chargeCodeIdList");
		List<String> referToMhList = new ArrayList<String>();
		if((List)mapForDS.get("referToMhList") != null){
			referToMhList = (List)mapForDS.get("referToMhList");
		}
		int physioRequisitionHeaderId = 0;
		int procedureHeaderId = 0;
		if(mapForDS.get("physioRequisitionHeaderId")!=null){
			physioRequisitionHeaderId = (Integer)mapForDS.get("physioRequisitionHeaderId");
		}
		if(mapForDS.get("procedureHeaderId")!=null){
			procedureHeaderId = (Integer)mapForDS.get("procedureHeaderId");
		}
	

		boolean succesfullyAdded = false;
		try {
			tx = session.beginTransaction();
			Patient patientObj = new Patient();
			MasHospital masHospital = new MasHospital();
			Visit visit=new Visit();
			MasDepartment masDepartment = new MasDepartment();
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentTimeWithoutSecond();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			OpdPatientDetails opdPatientDetails =  new OpdPatientDetails();
			OpdPatientHistory opdPatientHistory = new OpdPatientHistory();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
	
			if(box.getInt("visitId") != 0){
				Visit visitObj = new Visit();
				visitObj.setId(box.getInt("visitId"));
				opdPatientDetails.setVisit(visitObj);
			if(box.getInt("hospitalId") != 0){
				masHospital.setId(box.getInt("hospitalId"));
				opdPatientDetails.setHospital(masHospital);
			}
			if(box.getInt("empId") !=0){
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(box.getInt("empId"));
				opdPatientDetails.setEmployee(masEmployee);
			}
			
			if(mapForDS.get("opdPatientDetails") != null){
				opdPatientDetails =(OpdPatientDetails)mapForDS.get("opdPatientDetails");
			}
			
			opdPatientDetails.setDateAnc(HMSUtil.convertStringTypeDateToDateType(dateAnc));
			opdPatientDetails.setDateNextVisit(HMSUtil.convertStringTypeDateToDateType(dateNextVisit));
			opdPatientDetails.setFundal(fundal);
			opdPatientDetails.setPog(pog);
			opdPatientDetails.setVweight(weight);
			opdPatientDetails.setBp(bp);
			opdPatientDetails.setPp(pp);
			opdPatientDetails.setFoetalHeart(foetalHeart);
			opdPatientDetails.setFoetalHeadEngaged(foetalHeadEngaged);
			opdPatientDetails.setOedema(oedema);
			opdPatientDetails.setAlb(alb);
			opdPatientDetails.setSugar(sugar);
			opdPatientDetails.setHb(hb);
			opdPatientDetails.setRemarks(remarks);
			opdPatientDetails.setPollor(pollor);
			
			
			opdPatientHistory.setVisitInpatientId(box.getInt("visitId"));
			opdPatientHistory.setPresentComplain(complaint);
			opdPatientHistory.setPresentAdvice(box.getString("presentAdvice"));
			opdPatientDetails.setDisposal(box.getString("disposal"));
			opdPatientDetails.setDisposalDays(box.getString("diposalDays"));
			
			if(!box.getString("dateOfNextReview").equals(""))
			{
			opdPatientDetails.setDateOfNextReview(HMSUtil.convertStringTypeDateToDateType(box.getString("dateOfNextReview")));
			}
	
				hbt.save(opdPatientDetails);
			if(box.getInt("hinId") != 0){
				patientObj.setId(box.getInt("hinId"));
				opdPatientHistory.setHin(patientObj);
			}
			if(box.getInt("departmentId") != 0){
				masDepartment.setId(box.getInt("departmentId"));
				opdPatientHistory.setDepartment(masDepartment);
			}
			opdPatientHistory.setVisitInpatientId(box.getInt("visitId"));
			opdPatientHistory.setOpdPatientDetails(opdPatientDetails);
			hbt.save(opdPatientHistory);    
			
			
		
			
			//------------code for investigation------------------------------------
			String[] chargeCodeIdArr = new String[box.getInt("hiddenValue")];
			if (chargeCodeIdList.size() > 0) {
				Patient patient = new Patient();
				MasEmployee masEmployee2 = new MasEmployee();
				PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
				patient.setId(box.getInt("hinId"));
				patientInvestigationHeader.setHin(patient);
				masDepartment.setId(box.getInt("departmentId"));
				patientInvestigationHeader.setDepartment(masDepartment);
				visit.setId(box.getInt("visitId"));
				patientInvestigationHeader.setVisit(visit);
				masHospital.setId(box.getInt("hospitalId"));
				patientInvestigationHeader.setHospital(masHospital);
				patientInvestigationHeader.setStatus("p");
				patientInvestigationHeader
						.setInvestigationDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				patientInvestigationHeader.setInvestigationTime(time);
				patientInvestigationHeader.setClinicalNotes(box.getString("clinicalNotes1"));
				patientInvestigationHeader.setOpdPatientDetails(opdPatientDetails);
				hbt.save(patientInvestigationHeader);

				DgOrderhd dgOrderhd = new DgOrderhd();
				dgOrderhd.setOrderDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				dgOrderhd.setOrderTime(time);
				masHospital.setId(box.getInt("hospitalId"));
				dgOrderhd.setHospital(masHospital);
				patient.setId(box.getInt("hinId"));
				dgOrderhd.setHin(patient);
				masDepartment.setId(box.getInt("departmentId"));
				dgOrderhd.setDepartment(masDepartment);
				if (box.getInt("empId") != 0) {
					masEmployee2.setId(box.getInt("empId"));
					dgOrderhd.setPrescribedBy(masEmployee2);
				}
				dgOrderhd.setPatientType("OP");
				dgOrderhd.setTestType("Regular");
				dgOrderhd.setCreatedby(box.getString("userName"));
				dgOrderhd.setCreatedon(HMSUtil.convertStringTypeDateToDateType(currentDate));
				dgOrderhd.setOrderNo(box.getString("orderSeqNo"));
				if (box.getInt("visitId") != 0) {
					visit = new Visit();
					visit.setId(box.getInt("visitId"));
					dgOrderhd.setVisit(visit);
				}
				dgOrderhd.setClinicalNote(box.getString("clinicalNotes1"));
				dgOrderhd.setOrderStatus("P");
				dgOrderhd.setLabOrderStatus("P");
				dgOrderhd.setLastChgBy(box.getInt("userId"));
				dgOrderhd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				dgOrderhd.setLastChgTime(time);
				dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
				hbt.save(dgOrderhd);
				for (int i = 0; i < chargeCodeIdList.size(); i++) {
					PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
					patientInvestigationDetails
					.setInvestigationHeader(patientInvestigationHeader);
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
					patientInvestigationDetails.setChargeCode(masChargeCode);
					patientInvestigationDetails.setReferToMh(referToMhList.get(i));
					hbt.save(patientInvestigationDetails);

					DgOrderdt dgOrderdt = new DgOrderdt();
					dgOrderdt.setOrderhd(dgOrderhd);
					masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
					dgOrderdt.setChargeCode(masChargeCode);
					dgOrderdt.setCreatedby(box.getString("userName"));
					dgOrderdt.setCreatedon(HMSUtil.convertStringTypeDateToDateType(currentDate));
					dgOrderdt.setLastChgBy(box.getInt("userId"));
					dgOrderdt.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
					dgOrderdt.setLastChgTime(time);
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
					dgOrderdt.setInvestigationToMH("n");
					dgOrderdt.setReferToMh(referToMhList.get(i));
					hbt.saveOrUpdate(dgOrderdt);
			}
		}
			//---------------------end of the code for investigation-----------------
	//-----------------------code for Treatment -------------------------------//
			PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
			int item_category_id=0;
			if(pvmsNoList.size() > 0 || (otherMedicineList != null && otherMedicineList.size() > 0)){
				patientObj.setId(box.getInt("hinId"));
				patientPrescriptionHeader.setHin(patientObj);
				masDepartment.setId(box.getInt("departmentId"));
				patientPrescriptionHeader.setDepartment(masDepartment);
				visit.setId(box.getInt("visitId"));
				patientPrescriptionHeader.setVisit(visit);
				masHospital.setId(box.getInt("hospitalId"));
				patientPrescriptionHeader.setHospital(masHospital);
				patientPrescriptionHeader.setStatus("p");
				patientPrescriptionHeader
						.setPrescriptionDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				patientPrescriptionHeader.setPrescriptionTime(time);
				/**
				 * Code By Ritu 
				 * Created Foreign key relation for emp id in Database
				 */
				MasEmployee employee = new MasEmployee();
				employee.setId(box.getInt("empId"));
				patientPrescriptionHeader.setEmp(employee);
				
				/**
				 * End of code by Ritu
				 */
				int prescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);
				patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
				patientPrescriptionHeader.setOpdPatientDetails(opdPatientDetails);
				
				
				 /* This block is use for Check Injection in Prescription List*/
				 
				String sqlItemId="";
				
				for (int i = 0; i < pvmsNoList.size(); i++) {
					String pvmsNo = (String) pvmsNoList.get(i);
					int itemId = getItemIdFromPVMS(pvmsNo);
					if(i==0){
						sqlItemId=""+itemId;
					}else{
						sqlItemId +=" , "+itemId;
					}
					itemIdList.add(itemId);
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
					masItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id in ("+sqlItemId+") and ic.Id="+item_category_id);
/*				{
				Query qry=session.createQuery("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id in (:sqlItemId) and ic.Id=:item_category_id");
			
				if(!sqlItemId.equals("")){
						qry.setParameter("sqlItemId", sqlItemId);
					}
				if(item_category_id!=0){
					qry.setParameter("item_category_id", item_category_id);
				}
				masItemList = qry.list();
			
				}*/
				if(masItemList.size()>0){
					patientPrescriptionHeader.setInjectionStatus("p");
				}else{
					patientPrescriptionHeader.setInjectionStatus("n");
				}
				
				/* End Of Code This block is use for Check Injection in Prescription List*/
				 
				
				hbt.save(patientPrescriptionHeader);
			}
			if (pvmsNoList.size() > 0 ) {
				for (int i = 0; i < itemIdList.size(); i++) {
					
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
						if (totalList.get(i) != null && !totalList.get(i).equals("")) {
							patientPrescriptionDetails.setTotal(totalList.get(i));
						}
						patientPrescriptionDetails.setGivenQty(0);
									
					patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
				
					patientPrescriptionDetails.setDetailStatus("a");
					List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
//					storeItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id="+itemIdList.get(i)+" and ic.Id="+item_category_id);
					Query qry =session.createQuery("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id=:itemId and ic.Id=:item_category_id");
					if(item_category_id!=0){
						qry.setParameter("item_category_id", item_category_id);
					}
					if(!itemIdList.get(i).equals("0")){
						qry.setParameter("itemId", itemIdList.get(i));
					}
					storeItemList = qry.list();
					
					
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

						Query qryTwo =session.createQuery("select inj from jkt.hms.masters.business.InjAppointmentHeader as inj join inj.Visit as visit where visit.Id=:visitId");
						if(box.getInt("visitId")!=0){
							qryTwo.setParameter("visitId", box.getInt("visitId"));
						}
						
						injectionRegisterList = qryTwo.list();
						InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();
						
						  if(injectionRegisterList.size()>0) /*means , Data is already available In InjectionRegister table */ 
						 
						if(injectionRegisterList.size()>0){
							for (InjAppointmentHeader injectionRegisterTemp : injectionRegisterList) {
								injectionAppointment.setId(injectionRegisterTemp.getId());
							}
						}else{
							injectionAppointment.setAppointmentDate(new Date());
							Patient patientInj = new Patient();
							patientInj.setId(box.getInt("hinId"));
							injectionAppointment.setHin(patientInj);
							Visit visitInj = new Visit();
							visitInj.setId(box.getInt("visitId"));
							injectionAppointment.setVisit(visitInj);
							MasHospital masHospitalInj = new MasHospital();
							masHospitalInj.setId(box.getInt("hospitalId"));
							injectionAppointment.setHospital(masHospitalInj);
							
							injectionAppointment.setStatus("p");
							injectionAppointment.setLastChgTime(time);
							Users user = new Users();
							user.setId(box.getInt(""));
							injectionAppointment.setLastChgBy(user);
							//injectionAppointment.setLastChgDate(date);
							injectionAppointment.setPrescription(patientPrescriptionHeader);
							hbt.save(injectionAppointment);
						}
						int freqCount=0;
						if(frequencyList.get(i) > 10){
							freqCount = 1;  /*if frequency is greater than 10 then only one entry will go in Injection Appointment table */
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
			if(otherMedicineList != null && otherMedicineList.size() > 0){
				String sqlItemId="";
				int itemId = 0;
				List<MasStoreItem> itemCodeList = new ArrayList<MasStoreItem>();
				String otherItem = "";
				if(otherMedicineList.size() >0){
				for(int i = 0; i < otherMedicineList.size(); i++){
					MasStoreItem masItem = new MasStoreItem();
					if(otherMedicineList.get(i) != null){
						otherItem =(String)otherMedicineList.get(i);
						masItem.setNomenclature(otherMedicineList.get(i));
						MasStoreSection masStoreSection = new MasStoreSection();
						masStoreSection.setId(1);
						masItem.setSection(masStoreSection);
						masItem.setStatus("y");
						masItem.setBrandedGeneric("B");
						MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
						masStoreItemConversion.setId(1);
						masItem.setItemConversion(masStoreItemConversion);
						itemCodeList =session.createCriteria(MasStoreItem.class).add(Restrictions.like("PvmsNo", "NIV%"))
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
						}
						masItem.setPvmsNo(itemNo);
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
						Query qryOne =session.createQuery("select inj from jkt.hms.masters.business.InjAppointmentHeader as inj join inj.Visit as visit where visit.Id=:visitId");
						if(box.getInt("visitId")!=0){
							qryOne.setParameter("visitId", box.getInt("visitId"));
						}
						
						injectionRegisterList = qryOne.list();
						
						InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();
						
						 /* if(injectionRegisterList.size()>0) means , Data is already available In InjectionRegister table  */
						 
						if(injectionRegisterList.size()>0){
							for (InjAppointmentHeader injectionRegisterTemp : injectionRegisterList) {
								injectionAppointment.setId(injectionRegisterTemp.getId());
							}
						}else{
							injectionAppointment.setAppointmentDate(new Date());
							Patient patientInj = new Patient();
							patientInj.setId(box.getInt("hinId"));
							injectionAppointment.setHin(patientInj);
							Visit visitInj = new Visit();
							visitInj.setId(box.getInt("visitId"));
							injectionAppointment.setVisit(visitInj);
							MasHospital masHospitalInj = new MasHospital();
							masHospitalInj.setId(box.getInt("hospitalId"));
							injectionAppointment.setHospital(masHospitalInj);
							injectionAppointment.setStatus("p");
							injectionAppointment.setLastChgTime(time);
							Users user = new Users();
							user.setId(box.getInt("userId"));
							injectionAppointment.setLastChgBy(user);
							injectionAppointment.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
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
	//----------------update visit table---------------------------------------------------
			Visit visitObjToUpdate = (Visit) hbt.load(Visit.class, box.getInt("visitId"));
			visitObjToUpdate.setVisitStatus("C");
			if(box.getInt("empId")>0){
				MasEmployee doctor=new MasEmployee();
				doctor.setId(box.getInt("empId"));
				visitObjToUpdate.setDoctor(doctor);
				visitObjToUpdate.setVisitStatus("C");
			}
			visitObjToUpdate.setDiagnosisString(box.getString("initialDiagnosis"));
			visitObjToUpdate.setDisposalName(box.getString("disposal"));
			visitObjToUpdate.setDisposalDays(box.getString("days"));
			hbt.update(visitObjToUpdate);
			//----------------------------------
			
		}
			
			
			if(physioRequisitionHeaderId!=0){
				PhysioRequisitionHeader requisitionHeader = (PhysioRequisitionHeader)hbt.load(PhysioRequisitionHeader.class, physioRequisitionHeaderId);
				requisitionHeader.setOpdPatientDetails(opdPatientDetails);
				requisitionHeader.setReqTime(time);
				requisitionHeader.setLastChgTime(time);
				hbt.update(requisitionHeader);
				
			}
			if(procedureHeaderId!=0){
				ProcedureHeader procedureHeader = (ProcedureHeader)hbt.load(ProcedureHeader.class, procedureHeaderId);
				procedureHeader.setOpdPatientDetails(opdPatientDetails);
				procedureHeader.setLastChgTime(time);
				hbt.update(procedureHeader);
				
			}
			
			succesfullyAdded = true;
			tx.commit();	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
			
		map.put("succesfullyAdded", succesfullyAdded);
	//	map = showAntCardJsp(dataMap)
		return map;
	}

	public Map<String, Object> viewUlterSoundTestForOrderNo(Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		List<Integer> chargeCodeIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailsIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderIds = new ArrayList<Integer>();
		List<Integer> dgResultEntryDetailIdList = new ArrayList<Integer>();

		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();

		List<DgOrderdt> dgOrderdtList = new ArrayList<DgOrderdt>();
		List<DgMasInvestigation> dgMasInvestigationList = new ArrayList<DgMasInvestigation>();
	
		List<Integer> dgSampleCollectionDtTemplateIds = new ArrayList<Integer>();
		List<Integer> dgResultEntryDetailTemplateIdList = new ArrayList<Integer>();
		List<DgResultEntryHeader> dgResultEntryHeaderTemplateList = new ArrayList<DgResultEntryHeader>();
		
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		// session.setFlushMode(FlushMode.NEVER);
		int visitId = 0;
		int hinId = 0;
		Criteria crit = null;

		if (mapForDs.get("visitId") != null) {
			visitId = (Integer) mapForDs.get("visitId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}

		try {
			patientList = session.createCriteria(Patient.class).add(Restrictions.idEq(hinId)).list();
	
			if (visitId != 0) {
				crit = session.createCriteria(DgOrderdt.class)
				.createAlias("Orderhd", "orhd").createAlias("orhd.Hin", "p").
				add(Restrictions.eq("p.Id", hinId));
				
				dgOrderdtList = crit.list();
			}
			if (dgOrderdtList.size() > 0) {
				for (DgOrderdt dgOrderdt : dgOrderdtList) {
					chargeCodeIds.add(dgOrderdt.getChargeCode().getId());
				}
				crit = session.createCriteria(DgMasInvestigation.class).add(
						Restrictions.in("ChargeCode.Id", chargeCodeIds))					
				.add(Restrictions.like("InvestigationName", "USG%"))
						.addOrder(Order.asc("InvestigationName"));

				dgMasInvestigationList = crit.list();
			}


		} catch (HibernateException e) {
			e.printStackTrace();
		}

		detailsMap.put("dgSampleCollectionDetailsList",dgSampleCollectionDetailsList);
		detailsMap.put("dgOrderdtList", dgOrderdtList);
		detailsMap.put("dgMasInvestigationList", dgMasInvestigationList);
		detailsMap.put("patientList",patientList);
		return detailsMap;
	}
	
	public Map<String, Object> viewOtherInvTestForOrderNo(Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		List<Integer> chargeCodeIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailsIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderIds = new ArrayList<Integer>();
		List<Integer> dgResultEntryDetailIdList = new ArrayList<Integer>();

		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();

		List<DgOrderdt> dgOrderdtList = new ArrayList<DgOrderdt>();
		List<DgMasInvestigation> dgMasInvestigationList = new ArrayList<DgMasInvestigation>();
	
		List<Integer> dgSampleCollectionDtTemplateIds = new ArrayList<Integer>();
		List<Integer> dgResultEntryDetailTemplateIdList = new ArrayList<Integer>();
		List<DgResultEntryHeader> dgResultEntryHeaderTemplateList = new ArrayList<DgResultEntryHeader>();
		
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		// session.setFlushMode(FlushMode.NEVER);
		int visitId = 0;
		int hinId = 0;
		Criteria crit = null;

		if (mapForDs.get("visitId") != null) {
			visitId = (Integer) mapForDs.get("visitId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}

		try {
			patientList = session.createCriteria(Patient.class).add(Restrictions.idEq(hinId)).list();
	
			if (visitId != 0) {
				crit = session.createCriteria(DgOrderdt.class)
				.createAlias("Orderhd", "orhd").createAlias("orhd.Hin", "p").
				add(Restrictions.eq("p.Id", hinId));
				
				dgOrderdtList = crit.list();
			}
			if (dgOrderdtList.size() > 0) {
				for (DgOrderdt dgOrderdt : dgOrderdtList) {
					chargeCodeIds.add(dgOrderdt.getChargeCode().getId());
				}
				crit = session.createCriteria(DgMasInvestigation.class).add(
						Restrictions.in("ChargeCode.Id", chargeCodeIds))					
				.add(Restrictions.ne("InvestigationName", "USG%"))
						.addOrder(Order.asc("InvestigationName"));

				dgMasInvestigationList = crit.list();
			}


		} catch (HibernateException e) {
			e.printStackTrace();
		}

		detailsMap.put("dgSampleCollectionDetailsList",dgSampleCollectionDetailsList);
		detailsMap.put("dgOrderdtList", dgOrderdtList);
		detailsMap.put("dgMasInvestigationList", dgMasInvestigationList);
		detailsMap.put("patientList",patientList);
		return detailsMap;
	}

	@Override
	public Map<String, Object> displayVaccine(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasImmunization> immunizationList = new ArrayList<MasImmunization>();
		Session session = (Session)getSession();
		String vaccineAge = "";
		if(dataMap.get("vaccineAge") != null){
			vaccineAge = (String)dataMap.get("vaccineAge");
		}
		immunizationList = session.createCriteria(MasImmunization.class).add(Restrictions.eq("Age", vaccineAge)).add(Restrictions.eq("Status", "y")).list();
		map.put("immunizationList", immunizationList);
		return map;
	}
	
	@Override
	public Map<String, Object> printHealthCardB(Map<String, Object> requestParameters) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientDetails> pediatricsChartList = new ArrayList<OpdPatientDetails>();
		Session session = (Session)getSession();
		int visitId =0;
		if(requestParameters.get("visitId") != null){
			visitId = (Integer)requestParameters.get("visitId");
		}
		int hinId =0;
		if(requestParameters.get("hinId") != null){
			hinId = (Integer)requestParameters.get("hinId");
		}
/*		pediatricsChartList =session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v")
								.add(Restrictions.eq("v.Id", visitId)).list();*/
		
		
		pediatricsChartList =session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").add(Restrictions.eq("v.ReportingFor", "FamilyWC"))
		.add(Restrictions.eq("v.FwcCategory", "WELL BABY")).createAlias("v.Hin", "h").add(Restrictions.eq("h.Id",hinId)).list();
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("Average Weight");
      	if (pediatricsChartList.size() > 0) {
			
			for (OpdPatientDetails opdPatientDetails: pediatricsChartList) {
			//	double temp = 0;
				String childWeight = "";
				String age = "";
				
				Hour hour = null;
				/*if (ipdTemperature.getTemperature() != null) 
					temp = ipdTemperature.getTemperature();
				}*/

				if (opdPatientDetails.getAChildWeight() != null) {
					childWeight = opdPatientDetails.getAChildWeight();
				}
				if (opdPatientDetails.getChildAge() != null) {
					age= opdPatientDetails.getChildAge();
				}
				if(!age.equals("") && !childWeight.equals("")){
					series1.addOrUpdate(Integer.parseInt(age), (Integer.parseInt(childWeight)));
				}

			}
			dataset.addSeries(series1);
		} else 
		{
			map.put("status", "nodata");
		}

      	JFreeChart chart = ChartFactory.createXYLineChart
      	("Weight for age Boys", "Age(completed months and years)", "Weight(kg)",
      			dataset, PlotOrientation.VERTICAL, true, true, false);
      /*	ChartFrame frame1=new ChartFrame("XYLine Chart",chart);
      	frame1.setVisible(true);
        frame1.setSize(300,300);*/
      	
    	chart.setBackgroundPaint(Color.white);

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		plot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
    
		XYItemRenderer pr = plot.getRenderer();
		if (pr instanceof XYLineAndShapeRenderer) {
			XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) pr;
			renderer.setBaseShapesVisible(true);
			renderer.setBaseShapesFilled(true);
			
		}
		NumberAxis paxis = (NumberAxis) plot.getDomainAxis();
		paxis.setAutoRange(true);
		JFreeChartRenderer jfcRenderer = new JFreeChartRenderer(chart);
		chart.getBackgroundImage();
		map.put("jfcRenderer", jfcRenderer);
		map.put("chart", chart);
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}


	@Override
	public Map<String, Object> printHealthCardHeightB(Map<String, Object> requestParameters) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientDetails> pediatricsChartList = new ArrayList<OpdPatientDetails>();
		Session session = (Session)getSession();
		int visitId =0;
		if(requestParameters.get("visitId") != null){
			visitId = (Integer)requestParameters.get("visitId");
		}
		int hinId =0;
		if(requestParameters.get("hinId") != null){
			hinId = (Integer)requestParameters.get("hinId");
		}
/*		pediatricsChartList =session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v")
								.add(Restrictions.eq("v.Id", visitId)).list();*/
		
		
		pediatricsChartList =session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").add(Restrictions.eq("v.ReportingFor", "FamilyWC"))
		.add(Restrictions.eq("v.FwcCategory", "WELL BABY")).createAlias("v.Hin", "h").add(Restrictions.eq("h.Id",hinId)).list();
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("Average Weight");
      	if (pediatricsChartList.size() > 0) {
			
			for (OpdPatientDetails opdPatientDetails: pediatricsChartList) {
			//	double temp = 0;
				String childHeight = "";
				String age = "";
				
				Hour hour = null;
				/*if (ipdTemperature.getTemperature() != null) 
					temp = ipdTemperature.getTemperature();
				}*/

				if (opdPatientDetails.getChildHeight() != null) {
					childHeight = opdPatientDetails.getChildHeight();
				}
				if (opdPatientDetails.getChildAge() != null) {
					age= opdPatientDetails.getChildAge();
				}
				if(!age.equals("") && !childHeight.equals("")){
					series1.addOrUpdate(Integer.parseInt(age), (Integer.parseInt(childHeight)));
				}

			}
			dataset.addSeries(series1);
		} else 
		{
			map.put("status", "nodata");
		}

      	JFreeChart chart = ChartFactory.createXYLineChart
      	("Length/Height for age Boys", "Age(completed months and years)", "Length/Height(cm)",
      			dataset, PlotOrientation.VERTICAL, true, true, false);
      /*	ChartFrame frame1=new ChartFrame("XYLine Chart",chart);
      	frame1.setVisible(true);
        frame1.setSize(300,300);*/
      	
    	chart.setBackgroundPaint(Color.white);

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		plot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
    
		XYItemRenderer pr = plot.getRenderer();
		if (pr instanceof XYLineAndShapeRenderer) {
			XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) pr;
			renderer.setBaseShapesVisible(true);
			renderer.setBaseShapesFilled(true);
			
		}
		NumberAxis paxis = (NumberAxis) plot.getDomainAxis();
		paxis.setAutoRange(true);
		JFreeChartRenderer jfcRenderer = new JFreeChartRenderer(chart);
		chart.getBackgroundImage();
		map.put("jfcRenderer", jfcRenderer);
		map.put("chart", chart);
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}
	@Override
	public Map<String, Object> printHealthCardHeadCircumferenceB(Map<String, Object> requestParameters) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientDetails> pediatricsChartList = new ArrayList<OpdPatientDetails>();
		Session session = (Session)getSession();
		int visitId =0;
		if(requestParameters.get("visitId") != null){
			visitId = (Integer)requestParameters.get("visitId");
		}
		int hinId =0;
		if(requestParameters.get("hinId") != null){
			hinId = (Integer)requestParameters.get("hinId");
		}
/*		pediatricsChartList =session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v")
								.add(Restrictions.eq("v.Id", visitId)).list();*/
		
		
		pediatricsChartList =session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "v").add(Restrictions.eq("v.ReportingFor", "FamilyWC"))
		.add(Restrictions.eq("v.FwcCategory", "WELL BABY")).createAlias("v.Hin", "h").add(Restrictions.eq("h.Id",hinId)).list();
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("Average Weight");
      	if (pediatricsChartList.size() > 0) {
			
			for (OpdPatientDetails opdPatientDetails: pediatricsChartList) {
			//	double temp = 0;
				String childHeadCircumference = "";
				String age = "";
				
				Hour hour = null;
				/*if (ipdTemperature.getTemperature() != null) 
					temp = ipdTemperature.getTemperature();
				}*/

				if (opdPatientDetails.getChildHeadCircumference() != null) {
					childHeadCircumference = opdPatientDetails.getChildHeadCircumference();
				}
				if (opdPatientDetails.getChildAge() != null) {
					age= opdPatientDetails.getChildAge();
				}
				if(!age.equals("") && !childHeadCircumference.equals("")){
					series1.addOrUpdate(Integer.parseInt(age), (Integer.parseInt(childHeadCircumference)));
				}

			}
			dataset.addSeries(series1);
		} else 
		{
			map.put("status", "nodata");
		}

      	JFreeChart chart = ChartFactory.createXYLineChart
      	("Head circumference for age Boys", "Age(completed months and years)", "Head circumference(cm)",
      			dataset, PlotOrientation.VERTICAL, true, true, false);
      /*	ChartFrame frame1=new ChartFrame("XYLine Chart",chart);
      	frame1.setVisible(true);
        frame1.setSize(300,300);*/
      	
    	chart.setBackgroundPaint(Color.white);

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);
		plot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);
    
		XYItemRenderer pr = plot.getRenderer();
		if (pr instanceof XYLineAndShapeRenderer) {
			XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) pr;
			renderer.setBaseShapesVisible(true);
			renderer.setBaseShapesFilled(true);
			
		}
		NumberAxis paxis = (NumberAxis) plot.getDomainAxis();
		paxis.setAutoRange(true);
		JFreeChartRenderer jfcRenderer = new JFreeChartRenderer(chart);
		chart.getBackgroundImage();
		map.put("jfcRenderer", jfcRenderer);
		map.put("chart", chart);
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	@Override
	public Map<String, Object> displayGrowthChartValue(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> growthChartList = new ArrayList<Object[]>();
		Session session = (Session)getSession();
		int genderId =0;
		String growthChartAge = "";
		if(dataMap.get("growthChartAge") != null){
			growthChartAge =(String)dataMap.get("growthChartAge");	
		}
		if(dataMap.get("genderId") != null){
			genderId =(Integer)dataMap.get("genderId");	
		}
		//growthChartList = session.createCriteria(FwcGrowthChart.class).list();
		 String query = "select EXPECTED_WEIGHT_FOR_AGE,EXPECTED_HEIGHT_FOR_AGE,EXPECTED_BMI_FOR_AGE from fwc_growth_chart where age ='"+growthChartAge+"' and administrative_sex_id = "+genderId;
		 growthChartList = (List) session.createSQLQuery(query).list();
		 map.put("growthChartList", growthChartList);
		return map;
	}


	public Map<String, Object> displayFileUploadData(Map<String, Object> dataMap)
	{
		int hinId=(Integer)dataMap.get("hinId");
		int visitId=(Integer)dataMap.get("visitId");
		Session session=(Session)getSession();
		Map<String, Object> map=new HashMap<String, Object>();
		try
		{
			System.out.println("hinId===="+hinId);
			System.out.println("visitId===="+visitId);
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

	@Override
	public Map<String, Object> getUploadDocumentInvestigationDetails(
			Map<String, Object> dataMap) 
				{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int hinId =(Integer)dataMap.get("hinId");
		int hospitalId =(Integer)dataMap.get("hospitalId");
		int investId=(Integer)dataMap.get("investId");
		int visitId=(Integer)dataMap.get("visitId");
	    try
	    {
	    	List<MasMedicalUploadDocument> masMedicalUploadDocumentList=session.createCriteria(MasMedicalUploadDocument.class)
	    	   .add(Restrictions.eq("Hin.Id",hinId)).add(Restrictions.eq("Hin.Id",hinId))
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

	@Override
	public Map<String, Object> getUploadDocumentMedicalExamInvestigationData(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
	  
		int hinId =(Integer)dataMap.get("hinId");
		int hospitalId =(Integer)dataMap.get("hospitalId");
		int investId =(Integer)dataMap.get("investId");
		String fileName=(String)dataMap.get("filename");
		String folderName=(String)dataMap.get("folderName");
		String fileExtension=(String)dataMap.get("fileExtension");

	    try
	    {
	    	List<MasMedicalUploadDocument> masMedicalUploadDocumentList=session.createCriteria(MasMedicalUploadDocument.class)
	    	   .add(Restrictions.eq("Hin.Id",hinId)).add(Restrictions.eq("Hin.Id",hinId))
	    	   .add(Restrictions.eq("Hospital.Id",hospitalId)).add(Restrictions.eq("DgMasInvestigation.Id",investId))
	    	   .add(Restrictions.eq("FileName",fileName)).add(Restrictions.eq("FileExtension",fileExtension)).list();
	    	map.put("masMedicalUploadDocumentList", masMedicalUploadDocumentList);
	    	
	    }catch (HibernateException he)
	    {
		   he.printStackTrace();
	    }
	    return map;
	}

	@Override
	public Map<String, Object> submitUploadDocumentsInvestForMedicalExam(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		int hinId =(Integer)mapForDS.get("hinId");
		int hospitalId =(Integer)mapForDS.get("hospitalId");
		int investId=(Integer)mapForDS.get("investId");
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
		
						masUploadDocuments.setIdFlag("n");
						masUploadDocuments.setMedDate(currentDate);
				
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
	
	
	//-------------------- By Mansi on 30 April 2013

	@Override
	public Map<String, Object> showRegForIUD(Box box) {
		Map<String, Object>map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> getPatientDetails(Box box) {
		Map<String, Object>map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		patientList = session.createCriteria(Patient.class).add(Restrictions.idEq(box.getInt("hinId"))).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();
		map.put("employeeList", employeeList);
		map.put("patientList", patientList);
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
	public Map<String, Object> saveRegisterForIUD(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Transaction tx = null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean saved = false;
	
		Session session = (Session)getSession();
		
		OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
		try {
			tx = session.beginTransaction();
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
			visitForPhysio.setFwcCategory("IUD");
			visitForPhysio.setAppointmentType("D");
			MasHospital hosp = new MasHospital();
			hosp.setId(box.getInt("hospitalId"));
			visitForPhysio.setHospital(hosp);
			visitForPhysio.setReportingFor("FamilyWC");
			visitForPhysio.setTokenNo(0);
			MasDepartment md = new MasDepartment();
			md.setId(box.getInt("deptId"));
			visitForPhysio.setDepartment(md);
			//visitForPhysio.setPhyStatus("CV");
			//visitForPhysio.setPriority(3);
			hbt.save(visitForPhysio);
			}
			//=------------------------------------------------------------------------
			
			
			
			MasEmployee masEmployee = new MasEmployee();
			if(box.getInt("employee") != 0){
				masEmployee.setId(box.getInt("employee"));
				opdPatientDetails.setIssueTo(masEmployee);
			}
			opdPatientDetails.setNameOfContrac(box.getString("nameOfContrac"));
			opdPatientDetails.setQuantity(box.getInt("quantity"));
			opdPatientDetails.setLocation(box.getString("location"));
			if(box.getString("remarks") != null){
				opdPatientDetails.setRemarks(box.getString("remarks"));
			}
			
		
			if(box.getInt(VISIT_ID) != 0  && box.getInt("inpatientId")==0){
				Visit visit = new Visit();
				visit.setId(box.getInt(VISIT_ID));
				opdPatientDetails.setVisit(visit);
				}else if(box.getInt(VISIT_ID) == 0 && box.getInt("inpatientId")==0){
					opdPatientDetails.setVisit(visitForPhysio);
				}
			
			if(box.getInt(INPATIENT_ID)!=0){
				Inpatient inpatient = new Inpatient();
				inpatient.setId(box.getInt(INPATIENT_ID));
				opdPatientDetails.setInpatient(inpatient);
			}
		
			
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			opdPatientDetails.setHospital(hospital);
			
			opdPatientDetails.setInitialDiagnosis(box.getString("diagnosis"));
			opdPatientDetails.setOpdDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			opdPatientDetails.setOpdTime(box.getString(LAST_CHANGED_TIME));
			
			opdPatientDetails.setPhyStatus("c");
			hbt.save(opdPatientDetails);

		

			OpdPatientHistory opdPatientHistory = new OpdPatientHistory();

			MasDepartment md = new MasDepartment();
			md.setId(box.getInt("deptId"));
			opdPatientHistory.setDepartment(md);

			MasHospital mh = new MasHospital();
			mh.setId(box.getInt("hospitalId"));
			opdPatientHistory.setHospital(mh);
			
			Patient patient = new Patient();
			patient.setId(box.getInt(HIN_ID));
			opdPatientHistory.setHin(patient);
			
			
			if(box.getInt(VISIT_ID) != 0  && box.getInt("inpatientId")==0){
	
				opdPatientHistory.setVisitInpatientId(box.getInt(VISIT_ID));
		
				}else if(box.getInt(VISIT_ID) == 0 && box.getInt("inpatientId")==0){
					
					opdPatientHistory.setVisitInpatientId(visitForPhysio.getId());
				}
			
			opdPatientHistory.setLastChgBy("admin");
			opdPatientHistory.setStatus("y");
			opdPatientHistory.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(box.getString(LAST_CHANGED_DATE)));
			opdPatientHistory.setLastChgTime(box.getString(LAST_CHANGED_TIME));
			opdPatientHistory.setIpOpPacStatus("OP");

			opdPatientHistory.setOpdPatientDetails(opdPatientDetails);

			hbt.save(opdPatientHistory);

			
			hbt.flush();
		
			
			saved = true;
			tx.commit();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		map.put("saved", saved);

		return map;
	}

	@Override
	public Map<String, Object> showRegisterForIUDReportJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Object[]> unitList = new ArrayList<Object[]>();
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Session session = (Session)getSession();
		try {
			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status","y")).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(Order.asc("UnitName")).list();
		
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("unitList", unitList);
		return map;
	}
	@Override
	public Map<String, Object> showAntentatalCardFollowUpJsp(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientDetails> fwcOpdDetailList = new ArrayList<OpdPatientDetails>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<MasMedicalExaminationReportOnEntry> medicalList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		List<PatientFamilyHistory> patientFamilyHistoryList=new ArrayList<PatientFamilyHistory>();
		List<OpdTemplate> templateList = new ArrayList<OpdTemplate>();
		List<OpdPatientHistory> fwcOpdDetailHistoryList = new ArrayList<OpdPatientHistory>();
		Session session = (Session)getSession();
		int visitId = 0;
		if(dataMap.get("visitId") != null){
			visitId = (Integer)dataMap.get("visitId");
		}
		int hinId = 0;
		if(dataMap.get("hinId") != null){
			hinId = (Integer)dataMap.get("hinId");
		}
		int deptId = 0;
		if(dataMap.get("deptId") != null){
			deptId = (Integer)dataMap.get("deptId");
		}
		String cat[] = {"ANC","ANC FOLLOW UP"};
				templateList = session.createCriteria(OpdTemplate.class).createAlias("Department", "dept").add(Restrictions.eq("dept.Id", deptId)).add(Restrictions.eq("Status", "y")).list();
		
		/*Criteria critMaxVisitId =session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "visit").createAlias("visit.Hin", "hin").add(Restrictions.eq("hin.Id", hinId))
		.add(Restrictions.eq("visit.ReportingFor", "FamilyWC")).setProjection(Projections.max("visit.Id"))
		.add(Restrictions.in("visit.FwcCategory",cat));
			
		fwcOpdDetailList = critMaxVisitId.list();*/
		
		fwcOpdDetailList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "visit").createAlias("visit.Hin", "hin").add(Restrictions.eq("hin.Id", hinId))
		.add(Restrictions.in("visit.FwcCategory",cat)).add(Restrictions.eq("visit.ReportingFor", "FamilyWC")).add(Restrictions.ne("visit.Id",visitId)).setMaxResults(1).addOrder(Order.desc("visit.Id")).list();
	
	
		
		medicalList = session.createCriteria(MasMedicalExaminationReportOnEntry.class)
		.add(Restrictions.ne("Visit.Id",visitId)).setMaxResults(1).addOrder(Order.desc("Visit.Id")).list();
		//.add(Restrictions.eq("Visit.Id",visitId )).list();
		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y")).list();
		disposalList = session.createCriteria(MasDisposal.class).add(Restrictions.eq("Status", "y")).list();
		patientFamilyHistoryList= session.createCriteria(PatientFamilyHistory.class).add(Restrictions.eq("Status", "y")).list();
		fwcOpdDetailHistoryList=session.createCriteria(OpdPatientHistory.class).add(Restrictions.eq("Hin.Id", hinId)).list();
		map.put("fwcPatientDataList", fwcOpdDetailList);
		map.put("medicalList", medicalList);
		map.put("frequencyList", frequencyList);
		map.put("disposalList", disposalList);
		map.put("templateList", templateList);
		map.put("patientFamilyHistoryList", patientFamilyHistoryList);
		map.put("fwcOpdDetailHistoryList", fwcOpdDetailHistoryList);

		return map;
 
	}
	
	
	@Override
	public Map<String, Object> showDeliveryDetails(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientDetails> fwcOpdDetailList = new ArrayList<OpdPatientDetails>();
		List<OpdPatientHistory> fwcOpdDetailHistoryList = new ArrayList<OpdPatientHistory>();
		Session session = (Session)getSession();
		int visitId = 0;
		if(dataMap.get("visitId") != null){
			visitId = (Integer)dataMap.get("visitId");
		}
		int hinId = 0;
		if(dataMap.get("hinId") != null){
			hinId = (Integer)dataMap.get("hinId");
		}
		int deptId = 0;
		if(dataMap.get("deptId") != null){
			deptId = (Integer)dataMap.get("deptId");
		}
		
		
		fwcOpdDetailList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "visit").createAlias("visit.Hin", "hin").add(Restrictions.eq("hin.Id", hinId))
		.add(Restrictions.eq("visit.ReportingFor", "FamilyWC")).list();
		System.out.println("fwcOpdDetailList-->"+fwcOpdDetailList.size());
		fwcOpdDetailHistoryList=session.createCriteria(OpdPatientHistory.class).add(Restrictions.eq("Hin.Id", hinId)).list();
		map.put("fwcPatientDataList", fwcOpdDetailList);
		map.put("fwcOpdDetailHistoryList", fwcOpdDetailHistoryList);

		return map;
 
	}
	
	public Map<String, Object> submitDeliveryDetails(Box box,Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> dateDeliveryList  = new ArrayList<String>();
		List<String> timeDeliveryList  = new ArrayList<String>();
		List<String> placeDeliveryList  = new ArrayList<String>();
		List<String> typeDeliveryList  = new ArrayList<String>();
		List<Integer> slNoList  = new ArrayList<Integer>();
		List<Integer> visitList  = new ArrayList<Integer>();
		List<Integer> hinList  = new ArrayList<Integer>();
		List<Integer> hospitalList  = new ArrayList<Integer>();
		String userName = (String) mapForDS.get("userName");
		
		if(mapForDS.get("dateDeliveryList")!=null){
			dateDeliveryList = (List<String>)mapForDS.get("dateDeliveryList");
		}
		if(mapForDS.get("slNoList")!=null){
			slNoList = (List<Integer>)mapForDS.get("slNoList");
		}
		if(mapForDS.get("timeDeliveryList")!=null){
			timeDeliveryList = (List<String>)mapForDS.get("timeDeliveryList");
		}
		if(mapForDS.get("placeDeliveryList")!=null){
			placeDeliveryList = (List<String>)mapForDS.get("placeDeliveryList");
		}
		if(mapForDS.get("typeDeliveryList")!=null){
			typeDeliveryList = (List<String>)mapForDS.get("typeDeliveryList");
		}
	
		boolean succesfullyAdded = true;
		Transaction tx = null;
		Session session = (Session)getSession();

		
		OpdPatientDetails opd = new OpdPatientDetails();
		OpdPatientHistory oph = new OpdPatientHistory();
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MasHospital masHospital = new MasHospital();
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
				        Patient patientObj = new Patient();
	        patientObj.setId(box.getInt(HIN_ID));
			visitForPhysio.setHin(patientObj);	
			
				
			Users userObj = new Users();
			userObj.setId(box.getInt("userId"));
	
			visitForPhysio.setStatus("y");
			visitForPhysio.setVisitStatus("C");
		
			MasHospital hosp = new MasHospital();
			hosp.setId(box.getInt("hospitalId"));
			visitForPhysio.setHospital(hosp);
			visitForPhysio.setReportingFor("FamilyWC");
			visitForPhysio.setTokenNo(0);
			MasDepartment md = new MasDepartment();
			md.setId(box.getInt("deptId"));
			visitForPhysio.setDepartment(md);
			
			hbt.save(visitForPhysio);
		
			opd.setGender(box.getString("gender"));
			opd.setHospName(box.getString("hospName"));
			opd.setVweight(box.getString("weight"));
			opd.setUrine(box.getString("urine"));
			opd.setRespiratory(box.getString("respiratory"));
			opd.setRemarks(box.getString("remarks"));
			opd.setDrName(box.getString("drName"));
			opd.setHeadCirum(box.getString("headCirum"));
			opd.setChest(box.getString("chest"));
			opd.setCry(box.getString("cry"));
			opd.setReflexes(box.getString("reflexes"));
			opd.setObscure(box.getString("obscure"));
			opd.setSkinColor(box.getString("skinColor"));
			opd.setHeartRate(box.getString("heartRate"));
			opd.setPulses(box.getInt("pulses"));
			opd.setLiver(box.getString("liver"));
			opd.setSpleen(box.getString("spleen"));
			opd.setNervousSystem(box.getString("nervousSystem"));
			opd.setStatus(box.getString("status"));
			opd.setDomestic(box.getString("domestic"));
			
					for (int i = 0; i < slNoList.size(); i++) {
						FwcDeliveryDetails fwcDeliveryDetails = new FwcDeliveryDetails();
								
						fwcDeliveryDetails.setDateDelivery(HMSUtil.convertStringTypeDateToDateType(dateDeliveryList.get(i)));
						fwcDeliveryDetails.setPlaceDelivery(placeDeliveryList.get(i));
						fwcDeliveryDetails.setTimeDelivery(timeDeliveryList.get(i));
						fwcDeliveryDetails.setTypeDelivery(typeDeliveryList.get(i));
						fwcDeliveryDetails.setSlNo(slNoList.get(i));
						fwcDeliveryDetails.setVisit(visitForPhysio);
						fwcDeliveryDetails.setHin(patientObj);
						MasHospital hospa = new MasHospital();
						hospa.setId(box.getInt("hospitalId"));
						fwcDeliveryDetails.setHospital(hospa);
						hbt.save(fwcDeliveryDetails);
				}
					if(box.getInt(VISIT_ID) != 0){
						Visit visit = new Visit();
						visit.setId(box.getInt(VISIT_ID));
						opd.setVisit(visit);
						}else if(box.getInt(VISIT_ID) == 0){
							opd.setVisit(visitForPhysio);
							map.put("visitId",visitForPhysio.getId());
						}
					
					hbt.save(opd);
			
			}
		
			succesfullyAdded = true;
		tx.commit();	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
		map.put("succesfullyAdded", succesfullyAdded);
		return map;
	}
	

}
	

				
			
	