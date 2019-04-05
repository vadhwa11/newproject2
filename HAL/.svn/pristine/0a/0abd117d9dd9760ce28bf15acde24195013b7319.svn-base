package jkt.hms.mis.dataservice;

import static jkt.hms.util.RequestConstants.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadFile;
import jkt.hms.masters.business.AccidentalDetails;
import jkt.hms.masters.business.ActivityDetails;
import jkt.hms.masters.business.AmeLmc;
import jkt.hms.masters.business.AmeLmcHeader;
import jkt.hms.masters.business.AnnualMediacalExamination;
import jkt.hms.masters.business.AntiMalariaEntry;
import jkt.hms.masters.business.AutomaticBleachingEntry;
import jkt.hms.masters.business.AvFlyingIncident;
import jkt.hms.masters.business.Birthdeathreg;
import jkt.hms.masters.business.CaseOfAttemptedSuicide;
import jkt.hms.masters.business.Category;
import jkt.hms.masters.business.Complain;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.Discharge;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.EmpAfmsfDet;
import jkt.hms.masters.business.ExpiryDetails;
import jkt.hms.masters.business.FatalDocumentHeader;
import jkt.hms.masters.business.FeedbackOfCounselor;
import jkt.hms.masters.business.FoodHandler;
import jkt.hms.masters.business.FreeFromInfection;
import jkt.hms.masters.business.FwcDeliveryDetails;
import jkt.hms.masters.business.HealthPromotionActivity;
import jkt.hms.masters.business.HivAidsActivityDetails;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MalariaCase;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAircraftType;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDischargeStatus;
import jkt.hms.masters.business.MasDisposal;
import jkt.hms.masters.business.MasDisposedTo;
import jkt.hms.masters.business.MasEmpStatus;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasMedicalExaminationDetail;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.ShoFamilyWelfareActivities;
import jkt.hms.masters.business.ShoIndustrialDisease;
import jkt.hms.masters.business.ShoAdmissionDeath;
import jkt.hms.masters.business.ShoAntiFilaria;
import jkt.hms.masters.business.ShoCatering;
import jkt.hms.masters.business.ShoConservancy;
import jkt.hms.masters.business.ShoMonthlyWorkLoad;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasMedicalCategory;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.masters.business.MasMedicalUploadDocument;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasDiagnosisConclusion;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MeetingHeldAgencies;
import jkt.hms.masters.business.MentalPhysicalRetarded;
import jkt.hms.masters.business.MisAnnualMedicalExam;
import jkt.hms.masters.business.MisFatalTracking;
import jkt.hms.masters.business.MisFrw;
import jkt.hms.masters.business.MisNotifiable;
import jkt.hms.masters.business.MonitoringOfAds;
import jkt.hms.masters.business.MonthlyDischargeDt;
import jkt.hms.masters.business.MonthlyDischargeHd;
import jkt.hms.masters.business.MonthlySickAdmDetails;
import jkt.hms.masters.business.MonthlySickAdmHeader;
import jkt.hms.masters.business.NotifiableDisease;
import jkt.hms.masters.business.NutritionExamination;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.OpdPatientHistory;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientDischargeSlip;
import jkt.hms.masters.business.PreventableDiseaseEntry;
import jkt.hms.masters.business.SanitaryRound;
import jkt.hms.masters.business.SchoolInspectionEntry;
import jkt.hms.masters.business.ShoBiomedicalWaste;
import jkt.hms.masters.business.ShoFamilyHealthProgramme;
import jkt.hms.masters.business.ShoMonthlyWorkLoad;
import jkt.hms.masters.business.ShoOfficerDetails;
import jkt.hms.masters.business.ShoSchoolHealth;
import jkt.hms.masters.business.SroEntrySanitary;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.VectorControlActivity;
import jkt.hms.masters.business.Visit;
import jkt.hms.masters.business.WaterSurvillance;
import jkt.hms.masters.business.WorkloadMonthly;
import jkt.hms.masters.business.ShoBreakDown;
import jkt.hms.masters.business.ShoAccommodation;
import jkt.hms.masters.business.ShoAntiFilaria;
import jkt.hms.masters.business.ShoWorkService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.pdf.ByteBuffer;

public class MISDataServiceImpl extends HibernateDaoSupport implements
MISDataService {

	@SuppressWarnings("unchecked")
	/**
	 * showEDReturnsJsp() is used in ED returns form for displaying data in a
	 * JSP In EDReturnsJsp, Visit is the primary table for fetching data.
	 */
	public Map<String, Object> showEDReturnsJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		System.out.println("showEDReturnJsp");
		// List<Object> showList = new ArrayList<Object>();
		// List<MasDisposedTo> disposalList = new ArrayList<MasDisposedTo>();
		// Date currentDate = new Date();
		// String today;
		// today = HMSUtil.convertDateToStringWithoutTime(currentDate);

		// int toYear = 1900 + currentDate.getYear();
		// int toMonth = currentDate.getMonth() + 1;
		// today = Integer.toString(toYear) + "-" + Integer.toString(toMonth)
		// + "-" + Integer.toString(currentDate.getDate());

		try {
			rankCategoryList = session.createCriteria(MasRankCategory.class)
			.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("RankCategoryName")).list();
			// /disposalList = session.createCriteria(MasDisposedTo.class).add(
			// Restrictions.eq("Status", "y")).list();
			// /showList = getHibernateTemplate()
			// .find(
			// "from Visit v join v.Hin as p join p.Rank as r join r.RankCategory as rc join p.Trade as t join p.Unit as u join v.Disposal as d where  v.VisitDate between '"
			// + today
			// + "' and '"
			// + today
			// + "' and r.RankCategory='1' and v.EdStatus='n'");

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("rankCategoryList", rankCategoryList);
		// map.put("disposalList", disposalList);
		// map.put("showList", showList);

		return map;

	}

	/**
	 * showEDReturns() function is called when some criteria is passed for
	 * fetching data Visit is the primary table used.
	 */
	@SuppressWarnings( { "unchecked", "deprecation" })
	/*public Map<String, Object> showEDReturns(String toDate, String fromDate,
			String category, String edStatus,int hospitalId) {*/

	public Map<String, Object> showEDReturns(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		List<OpdPatientDetails> showList = new ArrayList<OpdPatientDetails>();
		@SuppressWarnings("unused")
		String fromDateStr = "";
		String toDateStr = "";
		String toDate = null;
		String fromDate = null;
		int category = 0;
		int hospitalId = 0;
		if(dataMap.get("fromDate") !=null){
			fromDate=(String)dataMap.get("fromDate");
		}
		if(dataMap.get("toDate") !=null){
			toDate=(String)dataMap.get("toDate");
		}
		if(dataMap.get("category") !=null){
			category=(Integer)dataMap.get("category");
		}
		if(dataMap.get("hospitalId") !=null){
			hospitalId=(Integer)dataMap.get("hospitalId");
		}
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fromDateStr = formatterOut.format(formatterIn.parse("" + fromDate));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		SimpleDateFormat formatterIn1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			toDateStr = formatterOut1.format(formatterIn1.parse("" + toDate));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		rankCategoryList = session.createCriteria(MasRankCategory.class).add(
				Restrictions.eq("Status", "y")).list();
		disposalList = session.createCriteria(MasDisposal.class).add(
				Restrictions.eq("Status", "y")).list();
		@SuppressWarnings("unused")
		String qry = null;
		try {
			if ((toDate != null) && (fromDate != null)  && category !=0) {
				showList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "vt")
				.add(Restrictions.eq("Disposal", "ED")).add(Restrictions.eq("Hospital.Id",hospitalId))
				.createAlias("vt.Hin", "pt").createAlias("pt.Rank", "rank").createAlias("rank.RankCategory", "rankCt")
				.add(Restrictions.eq("rankCt.Id", category)).createAlias("pt.ServiceType", "st")
				.add(Restrictions.eq("st.Id", 2)).createAlias("pt.Relation", "re")
				.add(Restrictions.eq("re.RelationName", "Self"))
				.add(Restrictions.between("OpdDate", java.sql.Date.valueOf(fromDateStr), java.sql.Date
						.valueOf(toDateStr))).list();
			}else if ((toDate != null) && (fromDate != null)){
				showList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "vt")
				.add(Restrictions.eq("Disposal", "ED")).add(Restrictions.eq("Hospital.Id",hospitalId))
				.createAlias("vt.Hin", "pt").createAlias("pt.ServiceType", "st")
				.add(Restrictions.eq("st.Id", 2)).createAlias("pt.Relation", "re")
				.add(Restrictions.eq("re.RelationName", "Self"))
				.add(Restrictions.between("OpdDate", java.sql.Date.valueOf(fromDateStr), java.sql.Date
						.valueOf(toDateStr))).list();
			}
			/*
			if ((toDate != null) && (fromDate != null) && (category != null)
					&& !category.equals("") && !category.equals("0")) {
				// showList = getHibernateTemplate()
				// //
				// .find("from Visit v join v.Hin as p left join p.Rank as r left join r.RankCategory as rc left join p.Trade as t left join p.Unit as u join p.Relation rel where  v.VisitDate between '"
				// + date4MySQL2
				// + "' and '"
				// + date4MySQL
				// + "' and r.RankCategory='"
				// + category
				// + "' and v.EdStatus='n'"
				// +" and rel.RelationName='Self'");
				showList = session.createCriteria(Visit.class).createAlias(
						"Hin", "pt").createAlias("pt.Rank", "rank")
						.createAlias("rank.RankCategory", "rankCt").add(
								Restrictions.eq("rankCt.Id", Integer
										.parseInt(category))).add(
								Restrictions.eq("EdStatus", "n")).add(
								Restrictions.eq("pt.Relation.Id", 8)).add(
								Restrictions.eq("Hospital.Id",hospitalId)).add(
								Restrictions.between("VisitDate", java.sql.Date
										.valueOf(fromDateStr), java.sql.Date
										.valueOf(toDateStr))).list();
			} else if ((toDate != null) && (fromDate != null)) {
				showList = session.createCriteria(Visit.class).createAlias(
						"Hin", "pt").add(Restrictions.eq("EdStatus", "n")).add(
						Restrictions.eq("pt.Relation.Id", 8)).add(
								Restrictions.eq("Hospital.Id",hospitalId)).add(
						Restrictions.between("VisitDate", java.sql.Date
								.valueOf(fromDateStr), java.sql.Date
								.valueOf(toDateStr))).list();
			}

			 */} catch (Exception e) {
				 e.printStackTrace();
			 }

			 map.put("rankCategoryList", rankCategoryList);
			 map.put("disposalList", disposalList);
			 map.put("showList", showList);

			 return map;
	}

	/**
	 * editEDReturnsToDatabase() is used for updating records on the ED Returns
	 * form. records are updated in the Visit table.
	 */
	@SuppressWarnings("unchecked")
	public boolean editEDReturnsToDatabase(Box box)
	{

		boolean dataUpdated = false;

		Vector visitId = box.getVector("visitId");
		Vector noOfDay = box.getVector("noOfDay");
		Vector disposalId = box.getVector("disposal_name");
		try
		{
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			for (int i = 0; i < visitId.size(); i++)
			{
				Vector date_of_ed = box.getVector("dateOfEd"+i);
				int visit_id=0;
				if((noOfDay.get(i)!=null) &&(!noOfDay.get(i).toString().equals("")))
				{
					visit_id=Integer.parseInt(visitId.get(i).toString());
					Visit visit = (Visit) hbt.load(Visit.class, visit_id);
					int edDays=Integer.parseInt(noOfDay.get(i).toString()) ;
					Date edDate=HMSUtil.convertStringTypeDateToDateType(date_of_ed.get(0).toString());
					int disposal=Integer.parseInt(disposalId.get(i).toString());
					// visit.setEdStartDate(edDate);
					// visit.setEdDays(edDays);
					MasDisposal masDisposal=new MasDisposal();
					masDisposal.setId(disposal);
					visit.setDisposal(masDisposal);
					//visit.setEdStatus("y");
					hbt.update(visit);
					dataUpdated = true;
				}
			}	

		}catch (Exception e) {
			e.printStackTrace();
		}	
		return dataUpdated;
	}

	// ------------------------ ED Return Report form
	// ----------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showEDreportsjsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List<MasServiceType> masServiceTypeList = new ArrayList<MasServiceType>();
		try {
			rankCategoryList = session.createCriteria(MasRankCategory.class)
			.add(Restrictions.eq("Status", "y")).list();
			masServiceTypeList = session.createCriteria(MasServiceType.class)
			.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("masServiceTypeList", masServiceTypeList);
		map.put("rankCategoryList", rankCategoryList);

		return map;

	}

	/**
	 * searchEDReturn() is used for fetching records from the database,
	 * according to the criteria that is passed on the criteria screen. Visit is
	 * the primary table that is used for fetching records.
	 */

	public Map<String, Object> searchEDReturn(Date toDate, Date fromDate,
			String category) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List showList = null;

		rankCategoryList = session.createCriteria(MasRankCategory.class).add(
				Restrictions.eq("Status", "y")).list();

		int toYear = 1900 + toDate.getYear();
		int fromYear = 1900 + fromDate.getYear();
		int toMonth = toDate.getMonth() + 1;
		int fromMonth = fromDate.getMonth() + 1;
		String dateTo = Integer.toString(toYear) + "-"
		+ Integer.toString(toMonth) + "-"
		+ Integer.toString(toDate.getDate());
		String dateFrom = Integer.toString(fromYear) + "-"
		+ Integer.toString(fromMonth) + "-"
		+ Integer.toString(fromDate.getDate());
		try {
			if ((toDate != null) && (fromDate != null) && (category != null)) {

				showList = getHibernateTemplate()
				.find(
						"Select rc.RankCategoryName,p.ServiceNo,p.PFirstName,p.PLastName,t.TradeName,d.DisposalName,u.UnitName,v.Age,v.EdDays,v.EdDate,dd.DiagnosisConclusionName,r.RankName from Visit v join v.Hin as p join p.Rank as r join r.RankCategory as rc join p.Trade as t join p.Unit as u join v.Disposal as d join v.Diagnosis as dd where  v.VisitDate between '"
						+ dateFrom
						+ "' and '"
						+ dateTo
						+ "' and r.RankCategory='"
						+ category
						+ "'");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("rankCategoryList", rankCategoryList);
		map.put("showList", showList);

		return map;
	}

	/**
	 * Patient Movement Order Report is the criteria screen which passed to the
	 * .jasper file. showPatientMovementOrderjsp, is used for showing the
	 * criteria JSP file.
	 */

	// ---------------------------- Patient Movement Order
	public Map<String, Object> showPatientMovementOrderjsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> serviceNoList = new ArrayList<Patient>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		try {
			// serviceNoList = session.createCriteria(Patient.class).add(
			// Restrictions.eq("Status", "y")).list();
			disposalList = session.createCriteria(MasDisposal.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("serviceNoList", serviceNoList);
		map.put("disposalList", disposalList);

		return map;
	}

	/**
	 * searchPatientMovementOrder() is used for fetching records from the
	 * database, according to the criteria that is passed on the criteria
	 * screen. Patient is the primary table that is used for fetching records.
	 */

	public Map<String, Object> searchPatientMovementOrder(String disposal,
			String serviceNo) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		List showList = null;

		disposalList = session.createCriteria(MasDisposal.class).add(
				Restrictions.eq("Status", "y")).list();
		try {
			if (disposal != null) {
				showList = getHibernateTemplate()
				.find(
						"select p.ServiceNo,p.PFirstName,p.PLastName,r.RankName,u.UnitName,d.DisposalName from Patient p join p.Visits as v join p.Unit as u join p.Rank as r join v.Disposal as d where p.ServiceNo='"
						+ serviceNo
						+ "' and v.EdDispose='"
						+ disposal + "'");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("disposalList", disposalList);
		map.put("showList", showList);
		return map;
	}

	/**
	 * Deficient AFMSF-1 is a screen used for displaying and updating records.
	 * Fetching records from two tables: 1)MasEmployee:- When there are no
	 * records in the EmpAfmsfDet table and the receipt status is 'No' selected
	 * in the form. 2)EmpAfmsfDet:- when there are records present in
	 * EmpAfmsfDet, and the receipt status selected is 'YES' in the form.
	 */

	// -------------------------- Afmsf-1 Def -------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showAfmsfDefjsp(String afmsfType) 
	{
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasMedicalCategory> masMedicalList = new ArrayList<MasMedicalCategory>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<EmpAfmsfDet> empAfmsfList = new ArrayList<EmpAfmsfDet>();
		try {
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("RankName")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("UnitName")).list();
			tradeList = session.createCriteria(MasTrade.class).add(
					Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
			masMedicalList = session.createCriteria(MasMedicalCategory.class)
			.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("MedicalCategoryName")).list();
			bloodGroupList = session.createCriteria(MasBloodGroup.class)
			.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BloodGroupName")).list();

			/**
			 * Code By Ritu
			 * Date 01-04-2013
			 */
			Criteria crit = null;
			crit = session.createCriteria(EmpAfmsfDet.class);
			if(afmsfType.equals("arrival")){
				crit = crit.add(Restrictions.eq("DocStatus", "s").ignoreCase()).add(Restrictions.eq("AfmsfType", "IN")).addOrder(Order.desc("Id"));
			}else if(afmsfType.equals("receipt")){
				crit = crit.add(Restrictions.eq("DocStatus", "d").ignoreCase()).add(Restrictions.eq("AfmsfType", "IN"));
			}else if(afmsfType.equals("dispatch")){
				crit = crit.add(Restrictions.eq("DocStatus", "s").ignoreCase()).add(Restrictions.eq("AfmsfType", "OUT")).addOrder(Order.desc("Id"));
			}

			empAfmsfList = crit.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("rankList", rankList);
		map.put("tradeList", tradeList);
		map.put("unitList", unitList);
		map.put("masMedicalList", masMedicalList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("empAfmsfList", empAfmsfList);
		return map;
	}

	public Map<String, Object> showAfmsfDef(Map<String, Object> generalMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<EmpAfmsfDet> empAfmsfList = new ArrayList<EmpAfmsfDet>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasMedicalCategory> masMedicalList = new ArrayList<MasMedicalCategory>();
		String serviceNo = null;
		String queryString = null;
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		String status = "";
		if(generalMap.get("status")!=null){
			status = (String)generalMap.get("status");
		}
		int hospitalId=0;
		try {
			serviceNo = (String) generalMap.get("serviceNo");
			hospitalId=(Integer)generalMap.get("hospitalId");
			queryString = "from MasEmployee where ServiceNo='" + serviceNo+"' and Hospital.Id="+hospitalId;

			employeeList = getHibernateTemplate().find(queryString);
			/*queryString = "from EmpAfmsfDet where ServiceNo='" + serviceNo+"'";

			empAfmsfDetList = getHibernateTemplate().find(queryString);*/
			Criteria crit = null;
			crit = session.createCriteria(EmpAfmsfDet.class);
			if(status.equals("arrival")){
				crit = crit.add(Restrictions.eq("DocStatus", "s").ignoreCase()).add(Restrictions.eq("AfmsfType", "IN"));
			}else if(status.equals("receipt")){
				crit = crit.add(Restrictions.eq("DocStatus", "d").ignoreCase()).add(Restrictions.eq("AfmsfType", "IN"));
			}else if(status.equals("clearance")){
				crit = crit.add(Restrictions.eq("DocStatus", "d").ignoreCase()).add(Restrictions.eq("AfmsfType", "OUT"));
			}else if(status.equals("dispatch")){
				crit = crit.add(Restrictions.eq("DocStatus", "s").ignoreCase()).add(Restrictions.eq("AfmsfType", "OUT"));
			}

			empAfmsfList = crit.list();

			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			tradeList = session.createCriteria(MasTrade.class).add(
					Restrictions.eq("Status", "y")).list();
			masMedicalList = session.createCriteria(MasMedicalCategory.class)
			.add(Restrictions.eq("Status", "y")).list();
			bloodGroupList = session.createCriteria(MasBloodGroup.class)
			.add(Restrictions.eq("Status", "y")).addOrder(Order.asc("BloodGroupName")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("serviceNo", serviceNo);
		map.put("empAfmsfList", empAfmsfList);
		map.put("employeeList", employeeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		map.put("masMedicalList", masMedicalList);
		map.put("bloodGroupList", bloodGroupList);

		return map;

	}

	public boolean submitNotifiableDiseaseJsp(Map map)
	{ 
		boolean succesfullyAdded = false;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Date  dateOfOnset=null;
		Date dateOfReportingSick= null;
		Date dateOfNotifiable = null;
		String dateofPreventive = "";
		int hospital_Id = 0;
		int departmentId = 0;
		int hinNumber = 0;
		String serviceNo = "";
		String patientName ="";
		String rank = "";
		String age  = "";
		String contact ="";
		String Detailsofcase = "";
		String clinical = "";
		String bacteriological = "";
		String disinfection ="";
		String  genaralRemarks="";
		String suspectedsourceofinfection="";
		int hinId = 0;
		int opdId=0;
		
		if(map.get("hospitalId")!= null)
		{
			hospital_Id = (Integer)map.get("hospitalId");
		}
		if(map.get("departmentId")!= null)
		{
			departmentId = (Integer)map.get("departmentId");
		}
		if(map.get("hinNumber")!= null)
		{ 
			hinNumber =(Integer) map.get("hinNumber");
		}
		if(map.get("serviceNo")!= null)
		{
			serviceNo = (String)map.get("serviceNo");
		}
		if(map.get("patientName")!= null)
		{	 
			patientName =  (String) map.get("patientName");
		}
		if(map.get("rank")!= null)
		{  
			rank =(String)map.get("rank");	
		}
		if(map.get("age")!= null)
		{
			age=(String)map.get("age");
		}
		if(map.get("contact")!= null)
		{	   
			contact = (String)map.get("contact");
		}
		if(map.get("dateOfOnset")!= null)
		{
			dateOfOnset = (Date) map.get("dateOfOnset");
		}
		if(map.get("dateOfReportingSick")!= null)
		{   
			dateOfReportingSick =(Date)map.get("dateOfReportingSick");		    
		}
		if(map.get("Detailsofcase")!= null)
		{   	    	   
			Detailsofcase =(String)map.get("Detailsofcase");	
		}
		if(map.get("clinical")!= null)
		{   
			clinical =(String)map.get("clinical");
		}
		if(map.get("bacteriological")!= null)
		{   
			bacteriological =(String)map.get("bacteriological");
		}
		if(map.get("disinfection")!= null)
		{   
			disinfection =(String)map.get("disinfection");
		}
		//String dateofPreventive =(String)map.get("dateofPreventive");
		if(map.get("genaralRemarks")!= null)
		{    genaralRemarks =(String)map.get("genaralRemarks");		  
		}
		if(map.get("dateOfNotifiable")!= null)
		{    dateOfNotifiable = (Date)map.get("dateOfNotifiable");		  
		}
		if(map.get("suspectedsourceofinfection")!= null)
		{    suspectedsourceofinfection = (String)map.get("suspectedsourceofinfection");		  
		}
		if(map.get("dateofPreventive")!= null)
		{    dateofPreventive = (String)map.get("dateofPreventive");		  
		}
		if(map.get("hinId")!= null)
		{    hinId = (Integer)map.get("hinId");		  
		}
		
		if(map.get("opdId") != null)
		{
			opdId = (Integer)map.get("opdId");
		}

		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			NotifiableDisease nd= new  NotifiableDisease();
			Patient p = new Patient();
			p.setId (hinId);
			nd.setHin_id(p);
			nd.setService_No(serviceNo);
			// nd.setPatientName(patientName);
			// nd.setRank(rank );
			// nd.setAge(age);
			// nd.setTotalService(lenghtofService);
			// nd.setUnit(unit);
			//nd.setResidance(residence);
			nd.setDateOfOnset(dateOfOnset);
			nd.setDateOfReportingSick(dateOfReportingSick);
			nd.setDetailsOfCase(Detailsofcase);
			nd.setClinical(clinical);
			nd.setBacteriological(bacteriological);
			nd.setDisinfection(disinfection);			
			nd.setGeneralRemarks(genaralRemarks);
			nd.setContact(contact);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospital_Id);
			nd.setHospital_Id(masHospital);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			nd.setDepartmentId(masDepartment);
			nd.setDateOfAdmission(dateOfNotifiable);
			nd.setSuspectedSourceOfInfection(suspectedsourceofinfection);
			nd.setDateOfPreventive(dateofPreventive);
			hbt.save(nd);
			hbt.refresh(nd);
			
			/*OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
			opdPatientDetails=(OpdPatientDetails) hbt.load(OpdPatientDetails.class, opdId);
			opdPatientDetails.setNotifiableStatus("submit");
			hbt.update(opdPatientDetails);
			hbt.refresh(opdPatientDetails);
*/
		
			succesfullyAdded = true;
			int notifiableId=0;
			notifiableId = nd.getId();
			map.put("notifiableId", notifiableId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return   succesfullyAdded;
	}

	public boolean submitSmoMalariaCase(Map map)
	{ 

		boolean successfullyAdded = false;
		int hospitalId =0;
		int departmentId =0;
		int hinId= 0;
		String serviceNo = "";
		String patientName ="";
		Date onsetDate = null;
		Date admissionDate = null;
		String species ="";
		String type = "";
		String transmission = "";
		String forwardTo = "";
		String n="n";
		if(map.get("hospitalId")!= null)
		{
			hospitalId =(Integer)map.get("hospitalId");
		}
		if(map.get("departmentId")!= null)
		{
			departmentId = (Integer)map.get("departmentId");
		}
		if(map.get("hinId")!= null)
		{
			hinId = (Integer)map.get("hinId"); 
		}
		if(map.get("serviceNo")!= null)
		{
			serviceNo = (String)map.get("serviceNo");
		}
		if(map.get("patientName")!= null)
		{
			patientName = (String)map.get("patientName");
		}
		if(map.get("onsetDate")!= null)
		{
			onsetDate = (Date) map.get("onsetDate");
		}
		if(map.get("admissionDate")!= null)
		{
			admissionDate = (Date)map.get("admissionDate");
		}
		if(map.get("species")!= null)
		{
			species = (String)map.get("species");
		}
		if(map.get("type")!= null)
		{
			type = (String)map.get("type");
		}
		if(map.get("transmission")!= null)
		{
			transmission = (String)map.get("transmission");
		}
		if(map.get("forwardTo")!= null)
		{
			forwardTo = (String)map.get("forwardTo");
		}
		try{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MalariaCase malariaCase = new MalariaCase();
			Patient patient = new Patient();
			patient.setId(hinId);
			malariaCase.setHinId(patient);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			malariaCase.setDepartmentId(masDepartment);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			malariaCase.setHospitalId(masHospital);
			malariaCase.setServiceNo(serviceNo);
			malariaCase.setPatientName(patientName);
			malariaCase.setDateOfOnset(onsetDate);
			malariaCase.setDateOfAdmission(admissionDate);
			malariaCase.setSpecies(species);
			malariaCase.setType(type);
			malariaCase.setTransmission(transmission);
			malariaCase.setForwardTo(forwardTo);
			malariaCase.setStatus(n);
			hbt.save(malariaCase);
			successfullyAdded = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return successfullyAdded;

	}

	public boolean submitFoodHandlerJsp(Map map)
	{
		int hospitalId =0;
		int departmentId = 0;
		int hinId= 0;
		String mess ="";
		String generalExam = "";
		String nailHair ="";
		String skin ="";
		String dewormingStatus ="";
		String remarksFFI = "";
		String name = "";
		String serviceNo = "";
		int tradeId = 0;
		Date fhdate = new Date();
		String immunization = "";
		String stoolTest = "";
		String patientName= "";

		if(map.get("hospitalId")!= null)
		{
			hospitalId =(Integer)map.get("hospitalId");
		}

		if(map.get("stoolTest")!= null)
		{
			stoolTest =(String)map.get("stoolTest");
		}

		if(map.get("departmentId")!= null)
		{
			departmentId = (Integer)map.get("departmentId");
		}
		
		if(map.get("hinId")!= null && !map.get("hinId").equals(""))  // change by javed khan on 25-09-2013
		{
			hinId = (Integer)map.get("hinId"); 
		}
		if(map.get("mess")!= null)
		{
			mess = (String)map.get("mess");
		}
		if(map.get("generalExam")!= null)
		{
			generalExam = (String)map.get("generalExam");
		}
		if(map.get("nailHair")!= null)
		{
			nailHair = (String)map.get("nailHair");
		}
		if(map.get("skin")!= null)
		{
			skin = (String)map.get("skin");
		}
		if(map.get("dewormingStatus")!= null)
		{
			dewormingStatus = (String)map.get("dewormingStatus");
		}
		if(map.get("remarksFFI")!= null)
		{
			remarksFFI = (String)map.get("remarksFFI");
		}

		if(map.get("tradeId")!= null)
		{
			tradeId = (Integer)map.get("tradeId"); 
		}
		if(map.get("name")!= null)
		{
			name = (String)map.get("name");
		}
		if(map.get("immunization")!= null)
		{
			immunization = (String)map.get("immunization");
		}
		if(map.get("serviceNo")!= null)
		{
			serviceNo = (String)map.get("serviceNo");
		}
		if(map.get("skin")!= null)
		{
			skin = (String)map.get("skin");
		}
		if(map.get("fhdate")!= null)
		{
			fhdate = (Date)map.get("fhdate");
		}
		
		if(map.get("patientName")!= null)
		{
			patientName = (String)map.get("patientName");
		}
		
		boolean successfullyAdded = false;
		try{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			FoodHandler foodHandler = new FoodHandler();
			
			Patient patient = new Patient();
			patient.setId(hinId);
			foodHandler.setHinId(patient);
			
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			foodHandler.setDepartmentId(masDepartment);
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			foodHandler.setHospitalId(masHospital);
			
			patient.setServiceNo(serviceNo);
			patient.setPFirstName(name);
			
			foodHandler.setMess(mess);
			foodHandler.setGeneralExam(generalExam);
			foodHandler.setNailsHair(nailHair);
			foodHandler.setSkin(skin);
			foodHandler.setDewormingStatus(dewormingStatus);
			foodHandler.setRemarksFfi(remarksFFI);
			foodHandler.setFhDate(fhdate);
			foodHandler.setName(name);
			foodHandler.setSerPassNo(serviceNo);
			foodHandler.setImmunization(immunization);
			foodHandler.setStoolTest(stoolTest);

			if(tradeId !=0 ){
				MasTrade trade = new MasTrade();
				trade.setId(tradeId);
				foodHandler.setTrade(trade);
			}

			hbt.save(foodHandler);
			hbt.refresh(foodHandler);
			successfullyAdded = true;

			int FhId=0;
			FhId=foodHandler.getId();
			map.put("FhId", FhId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return successfullyAdded;

	}

/*	public boolean submitVectorControlActivity(Map map)
	{
		int  hospitalId =0;
		int departmentId = 0;
		if(map.get("hospitalId")!= null)
		{
			hospitalId = (Integer)map.get("hospitalId");
		}
		if(map.get("departmentId")!= null)
		{
			departmentId = (Integer)map.get("departmentId");
		}
		List<Date> larvalDate = new ArrayList<Date>();
		List<String> larvalChemical = new ArrayList<String>();
		List<String> larvalarea =new ArrayList<String>();
		List<String> larvalsupervisor = new ArrayList<String>();
		List<String> larvalcarriedoutby =new ArrayList<String>();
		List<String> larvalnoCovered =new ArrayList<String>();
		List<String> larvalrecieve = new ArrayList<String>();
		List<String> larvalissue = new ArrayList<String>();
		List<String> larvalbalance =new ArrayList<String>();
		List<String> larvalremarks = new ArrayList<String>();
		List<Date> adultDate = new ArrayList<Date>();
		List<String> adultChemical = new ArrayList<String>();
		List<String> adultarea =new ArrayList<String>();
		List<String> adultsupervisor = new ArrayList<String>();
		List<String> adultcarriedOut = new ArrayList<String>();
		List<String> adultnoCovered = new ArrayList<String>();
		List<String> adultrecieve = new ArrayList<String>();
		List<String> adultissue = new ArrayList<String>();
		List<String> adultbalance = new ArrayList<String>();
		List<String> adultremarks = new ArrayList<String>();
		List<Date> foggingDate = new ArrayList<Date>();
		List<String> foggingarea = new ArrayList<String>();
		List<String> foggingsupervisor = new ArrayList<String>();
		List<String> foggingcarriedOut = new ArrayList<String>();
		List<String> foggingnoCovered = new ArrayList<String>();
		List<String> foggingreceive = new ArrayList<String>();
		List<String> foggingissue = new ArrayList<String>();
		List<String> foggingbalance =new ArrayList<String>();
		List<String> foggingremarks = new ArrayList<String>();		
		List<Date> ibnDate = new ArrayList<Date>();
		List<String> ibnChemical = new ArrayList<String>();
		List<String> ibnarea = new ArrayList<String>();
		List<String> ibnsupervisor = new ArrayList<String>();
		List<String> ibncarriedOut = new ArrayList<String>();
		List<String> ibnnoCovered = new ArrayList<String>();
		List<String> ibnreceive = new ArrayList<String>();
		List<String> ibnissued = new ArrayList<String>();
		List<String> ibnbalance = new ArrayList<String>();
		List<String> ibnremarks = new ArrayList<String>();
		List<Date> flyDate = new ArrayList<Date>();
		List<String> antiFlyChemical =new ArrayList<String>();
		List<String> flyarea = new ArrayList<String>();
		List<String> flysupervisor = new ArrayList<String>();
		List<String> flycarriedOut =new ArrayList<String>();
		List<String> flynoCovered = new ArrayList<String>();
		List<String> flyreceive =new ArrayList<String>();
		List<String> flyissued = new ArrayList<String>();
		List<String> flybalance = new ArrayList<String>();
		List<String> flyremarks =new ArrayList<String>();
		List<Date> debuggingDate = new ArrayList<Date>();
		List<String> debuggingChemical = new ArrayList<String>();
		List<String> debuggingarea =new ArrayList<String>();
		List<String> debuggingsupervisor =new ArrayList<String>();
		List<String> debuggingcarriedOut = new ArrayList<String>();
		List<String> debuggingnoCovered =new ArrayList<String>();	
		List<String> debuggingreceive =new ArrayList<String>();
		List<String> debuggingissued = new ArrayList<String>();
		List<String> debuggingbalance = new ArrayList<String>();
		List<String> debuggingremarks = new ArrayList<String>();
		List<Date> biologicalDate = new ArrayList<Date>();
		List<String> biologicalChemical = new ArrayList<String>();
		List<String> biologicalarea = new ArrayList<String>();
		List<String> biologicalsupervisor = new ArrayList<String>();
		List<String> biologicalcarriedOut = new ArrayList<String>();
		List<String> biologicalnoCovered = new ArrayList<String>();
		List<String> biologicalreceive = new ArrayList<String>();
		List<String> biologicalissued = new ArrayList<String>();
		List<String> biologicalbalance = new ArrayList<String>();
		List<String> biologicalremarks = new ArrayList<String>();
		List<String> foggingChemical =new ArrayList<String>();
		int srNo = 0;
		int srNo2 =0;
		int srNo3 =0;
		int srNo4 =0;
		int srNo5 =0;
		int srNo6=0;
		int srNo7 = 0;
		*//******************************End of Variable declaration**********************************//*
		if(map.get("srNo")!= null)
		{
			srNo = (Integer) map.get("srNo");
		}
		if(map.get("srNo2")!= null)
		{
			srNo2 = (Integer) map.get("srNo2");
		}
		if(map.get("srNo3")!= null)
		{
			srNo3 = (Integer) map.get("srNo3");
		}
		if(map.get("srNo4")!= null)
		{
			srNo4 = (Integer) map.get("srNo4");
		}
		if(map.get("srNo5")!= null)
		{
			srNo5 = (Integer) map.get("srNo5");
		}
		if(map.get("srNo6")!= null)
		{
			srNo6 = (Integer) map.get("srNo6");
		}
		if(map.get("srNo7")!= null)
		{
			srNo7 = (Integer) map.get("srNo7");
		}


	if(map.get("larvalDate")!= null)
		{
			larvalDate=(List) map.get("larvalDate");
		}
		if(map.get("larvalChemical")!= null)
		{
			larvalChemical = (List)map.get("larvalChemical");
		}
		if(map.get("larvalarea")!= null)
		{
			larvalarea =(List)map.get("larvalarea");
		}
		if(map.get("larvalsupervisor")!= null)
		{
			larvalsupervisor = (List)map.get("larvalsupervisor");
		}
		if(map.get("larvalcarriedoutby")!= null)
		{
			larvalcarriedoutby= (List)map.get("larvalcarriedoutby");
		}
		if(map.get("larvalnoCovered")!= null)
		{
			larvalnoCovered=(List) map.get("larvalnoCovered");
		}
		if(map.get("larvalrecieve")!= null)
		{
			larvalrecieve=(List) map.get("larvalrecieve");
		}
		if(map.get("larvalissue")!= null)
		{
			larvalissue = (List)map.get("larvalissue");
		}
		if(map.get("larvalbalance")!= null)
		{
			larvalbalance = (List)map.get("larvalbalance");
		}
		if(map.get("larvalremarks")!= null)
		{
			larvalremarks=(List) map.get("larvalremarks");
		}
		
		if(map.get("adultDate")!= null)
		{
			adultDate= (List)map.get("adultDate");
		}
		if(map.get("adultChemical")!= null)
		{
			adultChemical=(List) map.get("adultChemical");
		}
		if(map.get("adultarea")!= null)
		{
			adultarea = (List)map.get("adultarea");
		}
		if(map.get("adultsupervisor")!= null)
		{
			adultsupervisor = (List) map.get("adultsupervisor");
		}
		if(map.get("adultcarriedOut")!= null)
		{
			adultcarriedOut = (List) map.get("adultcarriedOut");
		}
		if(map.get("adultnoCovered")!= null)
		{
			adultnoCovered =(List) map.get("adultnoCovered");
		}
		if(map.get("adultrecieve")!= null)
		{
			adultrecieve =(List) map.get("adultrecieve");
		}
		if(map.get("adultissue")!= null)
		{
			adultissue = (List)map.get("adultissue");
		}
		if(map.get("adultbalance")!= null)
		{
			adultbalance = (List)map.get("adultbalance");
		}
		if(map.get("adultremarks")!= null)
		{
			adultremarks= (List)map.get("adultremarks");
		}
		if(map.get("foggingDate")!= null)
		{
			foggingDate = (List)map.get("foggingDate");
		}
		if(map.get("foggingChemical")!= null)
		{
			foggingChemical =(List) map.get("foggingChemical");
		}
		if(map.get("foggingarea")!= null)
		{	foggingarea = (List)map.get("foggingarea");
		}

		if(map.get("foggingsupervisor")!= null)
		{
			foggingsupervisor = (List)map.get("foggingsupervisor");
		}
		if(map.get("foggingcarriedOut")!= null)
		{
			foggingcarriedOut = (List)map.get("foggingcarriedOut");
		}
		if(map.get("foggingnoCovered")!= null)
		{
			foggingnoCovered= (List)map.get("foggingnoCovered");
		}
		if(map.get("foggingreceive")!= null)
		{
			foggingreceive= (List)map.get("foggingreceive");
		}
		if(map.get("foggingissue")!= null)
		{
			foggingissue = (List)map.get("foggingissue");
		}
		if(map.get("foggingbalance")!= null)
		{
			foggingbalance = (List)map.get("foggingbalance");
		}
		if(map.get("foggingremarks")!= null)
		{
			foggingremarks = (List)map.get("foggingremarks");
		}
		if(map.get("ibnDate")!= null)
		{
			ibnDate= (List)map.get("ibnDate");
		}
		if(map.get("ibnChemical")!= null)
		{
			ibnChemical= (List)map.get("ibnChemical");
		}
		if(map.get("ibnarea")!= null)
		{
			ibnarea = (List)map.get("ibnarea");
		}
		if(map.get("ibnsupervisor")!= null)
		{
			ibnsupervisor = (List)map.get("ibnsupervisor");
		}
		if(map.get("ibncarriedOut")!= null)
		{
			ibncarriedOut= (List)map.get("ibncarriedOut");
		}
		if(map.get("ibnnoCovered")!= null)
		{
			ibnnoCovered = (List)map.get("ibnnoCovered");
		}
		if(map.get("ibnreceive")!= null)
		{
			ibnreceive = (List)map.get("ibnreceive");
		}
		if(map.get("ibnissued")!= null)
		{
			ibnissued= (List)map.get("ibnissued");
		}
		if(map.get("ibnbalance")!= null)
		{
			ibnbalance= (List)map.get("ibnbalance");
		}
		if(map.get("ibnremarks")!= null)
		{
			ibnremarks= (List)map.get("ibnremarks");
		}
		if(map.get("flyDate")!= null)
		{
			flyDate= (List)map.get("flyDate");
		}
		if(map.get("antiFlyChemical")!= null)
		{
			antiFlyChemical = (List)map.get("antiFlyChemical");
		}
		if(map.get("flyarea")!= null)
		{
			flyarea = (List)map.get("flyarea");
		}
		if(map.get("flysupervisor")!= null)
		{
			flysupervisor= (List)map.get("flysupervisor");
		}
		if(map.get("flycarriedOut")!= null)
		{
			flycarriedOut = (List)map.get("flycarriedOut");
		}
		if(map.get("flynoCovered")!= null)
		{
			flynoCovered= (List)map.get("flynoCovered");
		}
		if(map.get("flyreceive")!= null)
		{
			flyreceive = (List)map.get("flyreceive");
		}
		if(map.get("flyissued")!= null)
		{
			flyissued = (List)map.get("flyissued");
		}
		if(map.get("flybalance")!= null)
		{
			flybalance = (List)map.get("flybalance");
		}
		if(map.get("flyremarks")!= null)
		{
			flyremarks = (List)map.get("flyremarks");
		}
		if(map.get("debuggingDate")!= null)
		{
			debuggingDate = (List)map.get("debuggingDate");
		}
		if(map.get("debuggingChemical")!= null)
		{
			debuggingChemical = (List)map.get("debuggingChemical");
		}
		if(map.get("debuggingarea")!= null)
		{
			debuggingarea = (List)map.get("debuggingarea");
		}
		if(map.get("debuggingsupervisor")!= null)
		{
			debuggingsupervisor = (List)map.get("debuggingsupervisor");
		}
		if(map.get("debuggingcarriedOut")!= null)
		{
			debuggingcarriedOut = (List)map.get("debuggingcarriedOut");
		}
		if(map.get("debuggingnoCovered")!= null)
		{
			debuggingnoCovered = (List)map.get("debuggingnoCovered");
		}
		if(map.get("debuggingreceive")!= null)
		{
			debuggingreceive = (List)map.get("debuggingreceive");
		}
		if(map.get("debuggingissued")!= null)
		{
			debuggingissued = (List)map.get("debuggingissued");
		}
		if(map.get("debuggingbalance")!= null)
		{
			debuggingbalance = (List)map.get("debuggingbalance");
		}
		if(map.get("debuggingremarks")!= null)
		{
			debuggingremarks = (List)map.get("debuggingremarks");
		}
		if(map.get("biologicalDate")!= null)
		{
			biologicalDate = (List)map.get("biologicalDate");
		}
		if(map.get("biologicalChemical")!= null)
		{
			biologicalChemical = (List)map.get("biologicalChemical");
		}
		if(map.get("biologicalarea")!= null)
		{
			biologicalarea = (List)map.get("biologicalarea");
		}
		if(map.get("biologicalsupervisor")!= null)
		{
			biologicalsupervisor = (List)map.get("biologicalsupervisor");
		}
		if(map.get("biologicalcarriedOut")!= null)
		{
			biologicalcarriedOut = (List)map.get("biologicalcarriedOut");
		}
		if(map.get("biologicalnoCovered")!= null)
		{
			biologicalnoCovered = (List)map.get("biologicalnoCovered");
		}
		if(map.get("biologicalreceive")!= null)
		{
			biologicalreceive = (List)map.get("biologicalreceive");
		}
		if(map.get("biologicalissued")!= null)
		{
			biologicalissued = (List)map.get("biologicalissued");
		}
		if(map.get("biologicalbalance")!= null)
		{
			biologicalbalance = (List)map.get("biologicalbalance");
		}
		if(map.get("biologicalremarks")!= null)
		{
			biologicalremarks = (List)map.get("biologicalremarks");
		}

		boolean successfullyAdded = false;	

		try
		{  
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			for(int i=0; i<=srNo; i++)
			{  
			VectorControlActivity vectorActivity = new VectorControlActivity();
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			vectorActivity.setHospitalId(masHospital);
			
			MasDepartment masdepartment = new MasDepartment();
			masdepartment.setId(departmentId);
			vectorActivity.setDepartmentId(masdepartment);
			
	        vectorActivity.setActivityDate(larvalDate.get(i));
			vectorActivity.setChemicalName(larvalChemical.get(i));
			vectorActivity.setArea(larvalarea.get(i));		    	  
			vectorActivity.setSupervisor(larvalsupervisor.get(i)); 	  
			vectorActivity.setCarriedOutBy(larvalcarriedoutby.get(i));
			vectorActivity.setNoOfBuildingCovered(larvalnoCovered.get(i));
			vectorActivity.setReceived(larvalrecieve.get(i));
			vectorActivity.setIssued(larvalissue.get(i));
			vectorActivity.setTotal(larvalbalance.get(i)) ; 
			vectorActivity.setRemarks(larvalremarks.get(i));
			//vectorActivity.setActivityName(country1);
			hbt.save(vectorActivity);
			successfullyAdded  = true;
			}
			
			for(int j=0; j<=srNo2; j++)
			{  
			VectorControlActivity vectorActivityAdult = new VectorControlActivity();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			vectorActivity.setHospitalId(masHospital);
			
			MasDepartment masdepartment = new MasDepartment();
			masdepartment.setId(departmentId);
			vectorActivity.setDepartmentId(masdepartment);	
			vectorActivityAdult.setAdultActivityDate(adultDate.get(j));
			vectorActivityAdult.setAdultChemicalName(adultChemical.get(j));
			vectorActivityAdult.setAdultArea(adultarea.get(j));
			vectorActivityAdult.setAdultSupervisor(adultsupervisor.get(j));
			vectorActivityAdult.setAdultCarriedOutBy(adultcarriedOut.get(j));
			vectorActivityAdult.setAdultNoOfBuildingCovered(adultnoCovered.get(j));
			vectorActivityAdult.setAdultReceived(adultrecieve.get(j));
			vectorActivityAdult.setAdultIssued(adultissue.get(j));
			vectorActivityAdult.setAdultBalance(adultbalance.get(j)) ; 
			vectorActivityAdult.setAdultRemarks(adultremarks.get(j));
			//vectorActivity.setAdultActivityName(country2);
			hbt.save(vectorActivityAdult);
			}
			
			for(int i=0; i<=srNo3 ; i++)
			{ 
			VectorControlActivity vectorActivity = new VectorControlActivity();
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			vectorActivity.setHospitalId(masHospital);
			
			MasDepartment masdepartment = new MasDepartment();
			masdepartment.setId(departmentId);
			vectorActivity.setDepartmentId(masdepartment);	
			
			vectorActivity.setFoggActivityDate(foggingDate.get(i));
			vectorActivity.setFoggChemicalName(foggingChemical.get(i));
			vectorActivity.setFoggArea(foggingarea.get(i));
			vectorActivity.setFoggSupervisor(foggingsupervisor.get(i));
			vectorActivity.setFoggCarriedOutBy(foggingcarriedOut.get(i));
			vectorActivity.setFoggNoOfBuildingCovered(foggingnoCovered.get(i));
			vectorActivity.setFoggReceived(foggingreceive.get(i));
			vectorActivity.setFoggIssued(foggingissue.get(i));
			vectorActivity.setFoggBalance(foggingbalance.get(i)) ; 
			vectorActivity.setFoggRemarks(foggingremarks.get(i));
			// vectorActivity.setFoggActivityName(country3);
			hbt.save(vectorActivity);
			}
			
			for(int i=0; i<=srNo4; i++)
			{ 
			VectorControlActivity vectorActivity = new VectorControlActivity();
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			vectorActivity.setHospitalId(masHospital);
			
			MasDepartment masdepartment = new MasDepartment();
			masdepartment.setId(departmentId);
			vectorActivity.setDepartmentId(masdepartment);	
			
			vectorActivity.setIbnActivityDate(ibnDate.get(i));
			vectorActivity.setIbnChemicalName(ibnChemical.get(i));
			vectorActivity.setIbnArea(ibnarea.get(i));
			vectorActivity.setIbnSupervisor(ibnsupervisor.get(i));
			vectorActivity.setIbnCarriedOutBy(ibncarriedOut.get(i));
			vectorActivity.setIbnNoOfBuildingCovered(ibnnoCovered.get(i));
			vectorActivity.setIbnReceived(ibnreceive.get(i));
			vectorActivity.setIbnIssued(ibnissued.get(i));
			vectorActivity.setIbnBalance(ibnbalance.get(i)) ;
			vectorActivity.setIbnRemarks(ibnremarks.get(i));
			// vectorActivity.setIbnActivityName(country4);
			hbt.save(vectorActivity);
			}
			
			for(int i=0; i<=srNo5; i++)
			{   
			VectorControlActivity vectorActivity = new VectorControlActivity();
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			vectorActivity.setHospitalId(masHospital);
			
			MasDepartment masdepartment = new MasDepartment();
			masdepartment.setId(departmentId);
			vectorActivity.setDepartmentId(masdepartment);
			
			vectorActivity.setFlyDate(flyDate.get(i));
			vectorActivity.setFlyChemicalName(antiFlyChemical.get(i));
			vectorActivity.setFlyArea(flyarea.get(i));
			vectorActivity.setFlySupervisor(flysupervisor.get(i));
			vectorActivity.setFlyCarriedOutBy(flycarriedOut.get(i));
			vectorActivity.setFlyNoOfBuildingCovered(flynoCovered.get(i));
			vectorActivity.setFlyReceived(flyreceive.get(i));
			vectorActivity.setFlyIssued(flyissued.get(i));
			vectorActivity.setFlyBalance(flybalance.get(i)) ; 
			vectorActivity.setFlyRemarks(flyremarks.get(i));
			//vectorActivity.setFlyActivityName(country5);
			hbt.save(vectorActivity);
			}

			for(int i=0; i<=srNo6; i++)
			{ 
			VectorControlActivity vectorActivity = new VectorControlActivity();
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			vectorActivity.setHospitalId(masHospital);
			
			MasDepartment masdepartment = new MasDepartment();
			masdepartment.setId(departmentId);
			vectorActivity.setDepartmentId(masdepartment);
			
			vectorActivity.setDebuggingDate(debuggingDate.get(i));
			vectorActivity.setDebuggingChemicalName(debuggingChemical.get(i));
			vectorActivity.setDebuggingArea(debuggingarea.get(i));
			vectorActivity.setDebuggingSupervisor(debuggingsupervisor.get(i));
			vectorActivity.setDebuggingCarriedOutBy(debuggingcarriedOut.get(i));
			vectorActivity.setDebuggingNoOfBuildingCovered(debuggingnoCovered.get(i));
			vectorActivity.setDebuggingReceived(debuggingreceive.get(i));
			vectorActivity.setDebuggingIssued(debuggingissued.get(i));
			vectorActivity.setDebuggingBalance(debuggingbalance.get(i)) ; 
			vectorActivity.setDebuggingRemarks(debuggingremarks.get(i));
			//vectorActivity.setDebuggingActivityName(country6);
			hbt.save(vectorActivity);
			}

			for(int i=0; i<=srNo7 ;i++)
			{  
			VectorControlActivity vectorActivity = new VectorControlActivity();
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			vectorActivity.setHospitalId(masHospital);
			
			MasDepartment masdepartment = new MasDepartment();
			masdepartment.setId(departmentId);
			vectorActivity.setDepartmentId(masdepartment);
			
			vectorActivity.setBioDate(biologicalDate.get(i));
			vectorActivity.setBioChemicalName( biologicalChemical.get(i));
			vectorActivity.setBioArea(biologicalarea.get(i));
			vectorActivity.setBioSupervisor(biologicalsupervisor.get(i));
			vectorActivity.setBioCarriedOutBy(biologicalcarriedOut.get(i));
			vectorActivity.setBioNoOfBuildingCovered(biologicalnoCovered.get(i));
			vectorActivity.setBioReceived(biologicalreceive.get(i));
			vectorActivity.setBioIssued(biologicalissued.get(i));
			vectorActivity.setBioBalance(biologicalbalance.get(i)) ; 
			vectorActivity.setBioRemarks(biologicalremarks.get(i));
			hbt.save(vectorActivity);
			}
			// vectorActivity.setBioActivityName(country7);


			// hbt.save(vectorActivity);
			successfullyAdded  = true;
		}
		catch(Exception e)
		{ e.printStackTrace();
		}

		return successfullyAdded;
	}*/

	public boolean submitAccidentalDetailJsp(Map map)
	{ 
		int hospitalId=0;
		int departmentId=0;
		int hinId = 0;
		int hinIdRider = 0;
		Date dateOfAccident =null;
		String timeOfAccident= "";
		String deathCase="";
		String typeOfVehicle = "";
		String vehicleNo = "";
		String oldVehicle = "";
		String driverDutyStatus = "";
		String pillionDutyStatus = "";
		String placeOfAccident = "";
		String causeofAccident = "";
		String approxSpeed = "";
		String headInjuryDriver = "";
		String headInjuryPillionR = "";
		String headInjuryPerson1 ="";
		String headInjuryPerson2 = "";
		String headInjuryPerson3 = "";
		String fracturesDriver = "";
		String fracturesPillorR = "";
		String fracturesPerson1 ="";
		String fracturesPerson2="";
		String fracturesPerson3 ="";
		String minorInjDriver ="";
		String minorInjPillorR ="";
		String minorInjPerson1 = "";
		String minorInjPerson2 ="";
		String minorInjPerson3 ="";
		String otherInjDriver ="";
		String otherInjPillorR = "";
		String otherInjPerson1 = "";
		String otherInjPerson2 = "";
		String otherInjPerson3 = "";
		String isiDriver = "";
		String crashHelmetUsedByPillionR= "";
		String crashHelmetInjuredPerson = "";
		String chinStrapDriver = "";
		String chinStrapPillionRider = "";
		String comeOfHeadDuringAccidentDriver = "";
		String extentDamageDriver ="";
		String extentDamagePillionRider = "";
		String brakLightWorkingOrder = "";
		String admittedToDriver = "";
		String admittedToPillionR = "";
		String admittedToOther = "";
		String noDaySpentinHospitalDriver ="";
		String noDaySpentinHospitalPillionR = "";
		String noDaySpentinHospitalOther ="";
		String noDayLowerMedCatDriver = "";
		String noDayLowerMedCatPillionR ="";
		String noDayLowerMedCatOther = "";
		String noOfFlyHourDriver = "";
		String noOfFlyHourPillionR ="";
		String noOfFlyHourOther ="";
		String finalCatInjDriver = "";
		String finalCatInjPillionRider = "";
		String finalCatInjOther = "";
		String deathInjResponsibleDriver = "";
		String deathInjResponsiblePillionR ="";
		String deathInjResponsibleOther = "";
		String Remarks = "";
		String roadCondition = "";
		String accidentType = "";
		String otherPersonInjured = "";
		String crashHelmetUsedByDriver ="";
		String OtherCauseofAccident="";

		if(map.get("deathCase")!=null)
		{
			deathCase = (String)(map.get("deathCase"));	
		}
		if(map.get("hospitalId")!= null)
		{
			hospitalId = (Integer)map.get("hospitalId");
		}
		if(map.get("departmentId")!= null)
		{
			departmentId = (Integer)map.get("departmentId");
		}
		if(map.get("hinId")!= null)
		{
			hinId = (Integer)map.get("hinId")  ;
		}
		if(map.get("hinIdRider")!= null)
		{
			hinIdRider = (Integer)map.get("hinIdRider")  ;
		}
		if(map.get("dateOfAccident")!= null)
		{
			dateOfAccident = (Date)map.get("dateOfAccident");
		}
		if(map.get("timeOfAccident")!= null)
		{
			timeOfAccident = (String)map.get("timeOfAccident");
		}
		if(map.get("typeOfVehicle")!= null)
		{
			typeOfVehicle = (String)map.get("typeOfVehicle");
		}
		if(map.get("vehicleNo")!= null)
		{
			vehicleNo = (String)map.get("vehicleNo");
		}
		if(map.get("oldVehicle")!= null)
		{
			oldVehicle = (String)map.get("oldVehicle");
		}
		if(map.get("driverDutyStatus")!= null)
		{
			driverDutyStatus = (String)map.get("driverDutyStatus");
		}
		if(map.get("pillionDutyStatus")!= null)
		{
			pillionDutyStatus = (String)map.get("pillionDutyStatus");
		}
		if(map.get("placeOfAccident")!= null)
		{
			placeOfAccident= (String)map.get("placeOfAccident");
		}
		if(map.get("causeofAccident")!= null)
		{
			causeofAccident = (String)map.get("causeofAccident");
		}
		if(map.get("approxSpeed")!= null)
		{	
			approxSpeed = (String)map.get("approxSpeed");
		}
		if(map.get("headInjuryDriver")!=null)
		{
			headInjuryDriver = (String)map.get("headInjuryDriver");
		}
		if(map.get("headInjuryPillionR")!= null)
		{
			headInjuryPillionR = (String)map.get("headInjuryPillionR");
		}
		if(map.get("headInjuryPerson1")!= null)
		{
			headInjuryPerson1 = (String)map.get("headInjuryPerson1");
		}
		if(map.get("headInjuryPerson2")!= null)
		{
			headInjuryPerson2 = (String)map.get("headInjuryPerson2");
		}
		if(map.get("headInjuryPerson3")!= null)
		{
			headInjuryPerson3 = (String)map.get("headInjuryPerson3");
		}
		if(map.get("fracturesDriver")!= null)
		{
			fracturesDriver = (String)map.get("fracturesDriver");
		}
		if(map.get("fracturesPillorR")!= null)
		{
			fracturesPillorR = (String)map.get("fracturesPillorR");
		}
		if(map.get("fracturesPerson1")!= null)
		{
			fracturesPerson1 = (String)map.get("fracturesPerson1");
		}
		if(map.get("fracturesPerson2")!= null)
		{
			fracturesPerson2 = (String)map.get("fracturesPerson2");
		}
		if(map.get("fracturesPerson3")!= null)
		{
			fracturesPerson3 = (String)map.get("fracturesPerson3");
		}
		if(map.get("minorInjDriver")!= null)
		{
			minorInjDriver = (String)map.get("minorInjDriver");
		}

		if(map.get("minorInjPillorR")!= null)
		{
			minorInjPillorR = (String)map.get("minorInjPillorR");
		}
		if(map.get("minorInjPerson1")!= null)
		{
			minorInjPerson1 = (String)map.get("minorInjPerson1");
		}
		if(map.get("minorInjPerson2")!= null)
		{
			minorInjPerson2 = (String)map.get("minorInjPerson2");
		}
		if(map.get("minorInjPerson3")!= null)
		{
			minorInjPerson3 = (String)map.get("minorInjPerson3");
		}
		if(map.get("otherInjDriver")!= null)
		{
			otherInjDriver = (String)map.get("otherInjDriver");
		}
		if(map.get("otherInjPillorR")!= null)
		{
			otherInjPillorR = (String)map.get("otherInjPillorR");
		}
		if(map.get("otherInjPerson1")!= null)
		{
			otherInjPerson1 = (String)map.get("otherInjPerson1");
		}
		if(map.get("otherInjPerson2")!= null)
		{
			otherInjPerson2 = (String)map.get("otherInjPerson2");
		}
		if(map.get("otherInjPerson3")!= null)
		{
			otherInjPerson3 = (String)map.get("otherInjPerson3");
		}
		if(map.get("crashHelmetInjuredPerson")!= null)
		{
			crashHelmetInjuredPerson = (String)map.get("crashHelmetInjuredPerson");
		}
		if(map.get("isiDriver")!= null)
		{
			isiDriver = (String)map.get("isiDriver");
		}
		if(map.get("crashHelmetUsedByPillionR")!= null)
		{
			crashHelmetUsedByPillionR = (String)map.get("crashHelmetUsedByPillionR");
		}
		if(map.get("chinStrapDriver")!= null)
		{
			chinStrapDriver = (String)map.get("chinStrapDriver");
		}

		if(map.get("chinStrapPillionRider")!= null)
		{
			chinStrapPillionRider = (String)map.get("chinStrapPillionRider");
		}
		if(map.get("comeOfHeadDuringAccidentDriver")!= null)
		{
			comeOfHeadDuringAccidentDriver = (String)map.get("comeOfHeadDuringAccidentDriver");
		}
		if(map.get("extentDamageDriver")!= null)
		{
			extentDamageDriver = (String)map.get("extentDamageDriver");
		}
		if(map.get("extentDamagePillionRider")!= null)
		{
			extentDamagePillionRider = (String)map.get("extentDamagePillionRider");
		}
		if(map.get("brakLightWorkingOrder")!= null)
		{
			brakLightWorkingOrder = (String)map.get("brakLightWorkingOrder");
		}
		if(map.get("admittedToDriver")!= null)
		{
			admittedToDriver = (String)map.get("admittedToDriver");
		}
		if(map.get("admittedToPillionR")!= null)
		{
			admittedToPillionR = (String)map.get("admittedToPillionR");
		}
		if(map.get("admittedToOther")!= null)
		{
			admittedToOther = (String)map.get("admittedToOther");
		}

		if(map.get("noDaySpentinHospitalDriver")!= null)
		{
			noDaySpentinHospitalDriver = (String)map.get("noDaySpentinHospitalDriver");
		}
		if(map.get("noDaySpentinHospitalPillionR")!= null)
		{
			noDaySpentinHospitalPillionR = (String)map.get("noDaySpentinHospitalPillionR");
		}
		if(map.get("noDaySpentinHospitalOther")!= null)
		{
			noDaySpentinHospitalOther = (String)map.get("noDaySpentinHospitalOther");
		}
		if(map.get("noDayLowerMedCatDriver")!= null)
		{
			noDayLowerMedCatDriver = (String)map.get("noDayLowerMedCatDriver");
		}
		if(map.get("noDayLowerMedCatPillionR")!= null)
		{
			noDayLowerMedCatPillionR = (String)map.get("noDayLowerMedCatPillionR");
		}
		if(map.get("noDayLowerMedCatOther")!= null)
		{
			noDayLowerMedCatOther = (String)map.get("noDayLowerMedCatOther");
		}
		if(map.get("noOfFlyHourDriver")!= null)
		{
			noOfFlyHourDriver = (String)map.get("noOfFlyHourDriver");
		}
		if(map.get("noOfFlyHourPillionR")!= null)
		{
			noOfFlyHourPillionR = (String)map.get("noOfFlyHourPillionR");
		}
		if(map.get("noOfFlyHourOther")!= null)
		{
			noOfFlyHourOther = (String)map.get("noOfFlyHourOther");
		}
		if(map.get("finalCatInjDriver")!= null)
		{
			finalCatInjDriver = (String)map.get("finalCatInjDriver");
		}
		if(map.get("finalCatInjPillionRider")!= null)
		{
			finalCatInjPillionRider = (String)map.get("finalCatInjPillionRider");
		}
		if(map.get("finalCatInjOther")!= null)
		{
			finalCatInjOther = (String)map.get("finalCatInjOther");
		}
		if(map.get("deathInjResponsibleDriver")!= null)
		{
			deathInjResponsibleDriver = (String)map.get("deathInjResponsibleDriver");
		}
		if(map.get("deathInjResponsiblePillionR")!= null)
		{
			deathInjResponsiblePillionR = (String)map.get("deathInjResponsiblePillionR");
		}
		if(map.get("deathInjResponsibleOther")!= null)
		{
			deathInjResponsibleOther = (String)map.get("deathInjResponsibleOther");
		}
		if(map.get("Remarks")!= null)
		{
			Remarks = (String)map.get("Remarks");
		}
		if(map.get("roadCondition")!= null)
		{
			roadCondition = (String)map.get("roadCondition");
		}
		if(map.get("accidentType")!= null)
		{
			accidentType = (String)map.get("accidentType");
		}
		if(map.get("otherPersonInjured")!= null)
		{
			otherPersonInjured = (String)map.get("otherPersonInjured");
		}
		if(map.get("crashHelmetUsedByDriver")!= null)
		{
			crashHelmetUsedByDriver = (String)map.get("crashHelmetUsedByDriver");
		}
		if(map.get("OtherCauseofAccident")!= null)
		{
			OtherCauseofAccident = (String)map.get("OtherCauseofAccident");
		}

		boolean successfullyAdded = false;	


		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			AccidentalDetails acidentDetails = new AccidentalDetails();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			acidentDetails.setHospitalId(masHospital);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			acidentDetails.setDepartmentId( masDepartment);
			Patient patient = new Patient();
			Patient patient2 = new Patient();
			patient.setId(hinId);
			patient2.setId(hinIdRider);
			acidentDetails.setDriverHinId(patient);
			acidentDetails.setPillorRidderHinId(patient2);
			acidentDetails.setDateOfAccident(dateOfAccident);
			acidentDetails.setTimeOfAccident(timeOfAccident);
			acidentDetails.setTypeOfVehical(typeOfVehicle);
			acidentDetails.setVehicleNo(vehicleNo);
			acidentDetails.setVehicleYearOld(oldVehicle);
			acidentDetails.setDriverDutyStatus(driverDutyStatus);
			acidentDetails.setPillorRiderDutyStatus(pillionDutyStatus);
			acidentDetails.setPlaceOfAccident(placeOfAccident);
			acidentDetails.setCauseOfAccident(causeofAccident);
			acidentDetails.setApproxTimeOfAccident(approxSpeed);
			acidentDetails.setHeadInjDriver(headInjuryDriver);
			acidentDetails.setHeadInjPillionRider(headInjuryPillionR);
			acidentDetails.setHeadInjPerson1(headInjuryPerson1);
			acidentDetails.setHeadInjPerson2(headInjuryPerson2);
			acidentDetails.setHeadInjPerson3(headInjuryPerson3);
			acidentDetails.setFracturesDriver(fracturesDriver);
			acidentDetails.setFracturesPillionRider(fracturesPillorR);
			acidentDetails.setFracturesPerson1(fracturesPerson1);
			acidentDetails.setFracturesPerson2(fracturesPerson2);
			acidentDetails.setFracturesPerson3( fracturesPerson3);
			acidentDetails.setMinorInjDriver(minorInjDriver);
			acidentDetails.setMinorInjPillionRider(minorInjPillorR);
			acidentDetails.setMinorInjPerson1(minorInjPerson1);
			acidentDetails.setMinorInjPerson2( minorInjPerson2);
			acidentDetails.setMinorInjPerson3(minorInjPerson3);
			acidentDetails.setOtherInjDriver(otherInjDriver);
			acidentDetails.setOtherInjPillionRider(otherInjPillorR);
			acidentDetails.setOtherInjPerson1(otherInjPerson1);
			acidentDetails.setOtherInjPerson2(otherInjPerson2);
			acidentDetails.setOtherInjPerson3(otherInjPerson3);
			acidentDetails.setCrashHelmet(crashHelmetInjuredPerson);
			acidentDetails.setCrashHelmetPillionRider(crashHelmetUsedByPillionR);
			acidentDetails.setCrashHelmetIst(isiDriver);
			acidentDetails.setChinStrapDriver(chinStrapDriver);
			acidentDetails.setChinStrapPillionRider(chinStrapPillionRider);
			acidentDetails.setDuringComeOffHeadDriver(comeOfHeadDuringAccidentDriver);
			acidentDetails.setExtDamageHelmetDriver(extentDamageDriver);
			acidentDetails.setExtDamageHelmetPillionR(extentDamagePillionRider);
			acidentDetails.setBraksLightIndWorking(brakLightWorkingOrder);
			acidentDetails.setAdmToDriver(admittedToDriver);
			acidentDetails.setAdmToPillionRider(admittedToPillionR);
			acidentDetails.setAdmToOther(admittedToOther);
			acidentDetails.setNoDaySpentHospitalDriver(noDaySpentinHospitalDriver);
			acidentDetails.setNoDaySpentHospitalPillionr(noDaySpentinHospitalPillionR);
			acidentDetails.setNoDaySpentHospitalOthers(noDaySpentinHospitalOther);
			acidentDetails.setNoInLowerMedcatDriver(noDayLowerMedCatDriver);
			acidentDetails.setNoInLowerMedcatPillionR(noDayLowerMedCatPillionR);
			acidentDetails.setNoInLowerMedcatOther(noDayLowerMedCatOther);
			acidentDetails.setNoFlyInjDriver(noOfFlyHourDriver);
			acidentDetails.setNoFlyInjPillionR(noOfFlyHourPillionR);
			acidentDetails.setNoFlyInjOther(noOfFlyHourOther);
			acidentDetails.setFinalCatInjDriver(finalCatInjDriver);
			acidentDetails.setFinalCatInjPillionR(finalCatInjPillionRider);
			acidentDetails.setFinalCatInjOther(finalCatInjOther);
			acidentDetails.setCaseOfDeathInjDriver(deathInjResponsibleDriver);
			acidentDetails.setCaseOfDeathInjPillionR(deathInjResponsiblePillionR);
			acidentDetails.setCaseOfDeathInjOther(deathInjResponsibleOther);
			acidentDetails.setRemarks(Remarks);	
			acidentDetails.setConditionOfRoad(roadCondition);
			acidentDetails.setTypeOfAccident(accidentType);
			acidentDetails.setOtherPersonInj(otherPersonInjured);
			acidentDetails.setCrashHelmetDriver(crashHelmetUsedByDriver);
			acidentDetails.setOtherCauseOfAccident(OtherCauseofAccident);
			acidentDetails.setDeathCase(deathCase);
			hbt.save(acidentDetails);
			hbt.refresh(acidentDetails);

			int accidentId=0;
			accidentId = acidentDetails.getACCIDENT_Id();

			map.put("accidentId", accidentId);
			successfullyAdded= true;
		}
		catch(Exception e)
		{ e.printStackTrace();
		}

		return successfullyAdded;
	}
	public boolean submitCaseOfAttemptSuicideJsp(Map map)
	{
		boolean successfullyAdded = false;
		int hospitalId =0;
		int departmentId =0;
		int hinId= 0;
		Date dateofAttempt = null;
		Date dateOfDeath = null;
		String timeOfAttempt = "";
		String historyofPrev ="";
		String relevantDetailsofAttp ="";
		String informationfromFamily="";
		String firstIndividual="";
		String secondIndividual ="";
		String thirdIndividual ="";
		String firstFamily = "";
		String secondFamily ="";
		String thirdFamily ="";
		String historyofProb ="";
		String didtheIndvProb ="";
		String responseThePerson ="";
		String ifYes = "";
		String howDoesIndv ="";
		String weatherIndvCouncl ="";
		String ifYesByWhom ="";
		String resultCouncPerson="";
		String coUnitInfEffective ="";
		String presenceofSignDepression ="";
		String ifReferedStateOutcomeCase ="";
		String enumerateActionSuicidePrevn ="";
		String reason ="";
		if(map.get("hospitalId")!= null)
		{ 		 hospitalId = (Integer)map.get("hospitalId");
		}
		if(map.get("departmentId")!= null)
		{		  departmentId = (Integer)map.get("departmentId");
		}
		if(map.get("hinId")!= null)
		{	hinId = (Integer)map.get("hinId");
		}
		if(map.get("dateofAttempt")!= null)
		{
			dateofAttempt = (Date)map.get("dateofAttempt");
		}
		if(map.get("dateOfDeath")!= null)
		{
			dateOfDeath = (Date)map.get("dateOfDeath");
		}
		if(map.get("timeOfAttempt")!= null)
		{
			timeOfAttempt = (String)map.get("timeOfAttempt");
		}
		if(map.get("historyofPrev")!= null)
		{
			historyofPrev = (String)map.get("historyofPrev");
		}
		if(map.get("relevantDetailsofAttp")!= null)
		{
			relevantDetailsofAttp = (String)map.get("relevantDetailsofAttp"); 
		}
		if(map.get("informationfromFamily") != null)
		{
			informationfromFamily = (String)map.get("informationfromFamily");
		}
		if(map.get("firstIndividual")!= null)
		{
			firstIndividual = (String)map.get("firstIndividual");
		}
		if(map.get("secondIndividual")!= null)
		{
			secondIndividual = (String)map.get("secondIndividual");
		}
		if(map.get("thirdIndividual")!= null)
		{
			thirdIndividual = (String)map.get("thirdIndividual");
		}
		if(map.get("firstFamily")!= null)
		{
			firstFamily = (String)map.get("firstFamily");
		}
		if(map.get("secondFamily")!= null)
		{
			secondFamily = (String)map.get("secondFamily");
		}
		if(map.get("thirdFamily")!= null)
		{
			thirdFamily = (String)map.get("thirdFamily");
		}
		if(map.get("historyofProb")!= null)
		{
			historyofProb = (String)map.get("historyofProb");
		}
		if(map.get("didtheIndvProb")!= null)
		{
			didtheIndvProb = (String)map.get("didtheIndvProb");
		}
		if(map.get("responseThePerson")!= null)
		{
			responseThePerson = (String)map.get("responseThePerson");
		}
		if(map.get("ifYes")!= null)
		{
			ifYes = (String)map.get("ifYes");
		}
		if(map.get("howDoesIndv") != null)
		{
			howDoesIndv = (String)map.get("howDoesIndv");
		}
		if(map.get("weatherIndvCouncl")!= null)
		{
			weatherIndvCouncl = (String)map.get("weatherIndvCouncl");
		}
		if(map.get("ifYesByWhom")!= null)
		{
			ifYesByWhom = (String)map.get("ifYesByWhom");
		}
		if(map.get("resultCouncPerson")!= null)
		{
			resultCouncPerson = (String)map.get("resultCouncPerson");
		}
		if(map.get("coUnitInfEffective")!= null)
		{
			coUnitInfEffective = (String)map.get("coUnitInfEffective");
		}
		if(map.get("presenceofSignDepression")!= null)
		{
			presenceofSignDepression = (String)map.get("presenceofSignDepression");
		}
		if(map.get("ifReferedStateOutcomeCase")!= null)
		{
			ifReferedStateOutcomeCase = (String)map.get("ifReferedStateOutcomeCase");
		}
		if(map.get("enumerateActionSuicidePrevn")!= null)
		{
			enumerateActionSuicidePrevn = (String)map.get("enumerateActionSuicidePrevn");
		}
		if(map.get("reason")!= null)
		{
			reason = (String)map.get("reason");
		}
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt= getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			CaseOfAttemptedSuicide caseOfAttemptedSuicide = new CaseOfAttemptedSuicide();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			caseOfAttemptedSuicide.setHospitalId(masHospital);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			caseOfAttemptedSuicide.setDepartmentId(masDepartment);
			Patient patient = new Patient();
			patient.setId(hinId);
			caseOfAttemptedSuicide.setHinId(patient);
			caseOfAttemptedSuicide.setDateOfAttempted(dateofAttempt);
			caseOfAttemptedSuicide.setDateOfDeath(dateOfDeath);
			caseOfAttemptedSuicide.setTimeOfAttempted(timeOfAttempt);
			caseOfAttemptedSuicide.setPreviousAttemptHistory(historyofPrev);			   
			caseOfAttemptedSuicide.setRelevantDetailsAttemptInfo(relevantDetailsofAttp);
			caseOfAttemptedSuicide.setInfoFamilyNeighbourColleag(informationfromFamily);
			caseOfAttemptedSuicide.setFirstIndividual(firstIndividual);
			caseOfAttemptedSuicide.setSecondIndividual(secondIndividual);
			caseOfAttemptedSuicide.setThirdIndividual(thirdIndividual);
			caseOfAttemptedSuicide.setFirstFamily(firstFamily);
			caseOfAttemptedSuicide.setSecondFamily(secondFamily);
			caseOfAttemptedSuicide.setThirdFamily(thirdFamily);
			caseOfAttemptedSuicide.setHistoryProblem(historyofProb);
			caseOfAttemptedSuicide.setIndividualProposeDealProb(didtheIndvProb);
			caseOfAttemptedSuicide.setResponsePerson(responseThePerson);
			caseOfAttemptedSuicide.setResponsePersonYes(ifYes);
			caseOfAttemptedSuicide.setIndividualProposeDealProb(howDoesIndv);
			caseOfAttemptedSuicide.setWeatherIndividualCounselled(weatherIndvCouncl);
			caseOfAttemptedSuicide.setResultCounsellingPerson(ifYesByWhom);
			caseOfAttemptedSuicide.setResultCounsellingPerson(resultCouncPerson);
			caseOfAttemptedSuicide.setCoUnitInformEffectiveMonit(coUnitInfEffective);
			caseOfAttemptedSuicide.setPresenceSignofDepression(presenceofSignDepression);
			caseOfAttemptedSuicide.setStateOutcomeCase(ifReferedStateOutcomeCase);
			caseOfAttemptedSuicide.setEnumerateActionTakSuicide(enumerateActionSuicidePrevn);
			caseOfAttemptedSuicide.setReason(reason);
			hbt.save(caseOfAttemptedSuicide);
			hbt.refresh(caseOfAttemptedSuicide);
			successfullyAdded = true;
			int suicideId=0;
			suicideId=caseOfAttemptedSuicide.getId();
			map.put("suicideId", suicideId);
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		return successfullyAdded;
	}

	public  boolean submitPreventableDiseaseEntry(Map map)
	{
		boolean succesfullyAdded = false;
		Date currentDate = new Date();
		Date preventableDate = null;
		int MalariaPresent =0;
		int MalariaLast =0;
		String MalariaRemarks ="";
		int DiarrhoeaPresent =0;
		int DiarrhoeaLast =0;
		String DiarrhoeaDysentry ="";
		String InfectiousHepatitis ="";
		int InfectiousPresent =0;
		int InfectiousLast =0;
		String InfectiousRemarks ="";
		String RespiratoryGroup ="";
		int RespiratoryPresent =0;
		int RespiratoryLast =0;
		String DiarrhoeaRemarks ="";
		String STD ="";
		int STDPresent =0;
		int STDLast =0;
		String STDRemarks ="";
		String Injuries ="";
		int InjuriesPresent =0;
		int InjuriesLast =0;
		int hospital_Id =0;
		String InjuriesRemarks="";
		String flyingAccidents="";
		String gamesAccidents ="";
		String twoWheelersAccidents ="";
		String mechanicalTransportAccident ="";
		String otherAccidents ="";
		String reasonsforanyincreaseinIncident="";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		String MalariaFresh =(String) map.get("MalariaFresh");
		if(map.get("MalariaPresent")!= null && !(map.get("MalariaPresent").equals("")))
		{
			MalariaPresent = Integer.parseInt( (String) map.get("MalariaPresent"));
		}
		if(map.get("MalariaLast")!= null && !(map.get("MalariaLast").equals("")))
		{
			MalariaLast = Integer.parseInt((String)map.get("MalariaLast"));
		}
		if(map.get("MalariaRemarks")!= null && !(map.get("MalariaRemarks").equals("")))
		{
			MalariaRemarks =(String) map.get("MalariaRemarks");
		}
		if(map.get("DiarrhoeaDysentry")!= null && !(map.get("DiarrhoeaDysentry").equals("")))
		{
			DiarrhoeaDysentry =(String) map.get("DiarrhoeaDysentry");
		}
		if(map.get("DiarrhoeaPresent")!= null && !(map.get("DiarrhoeaPresent").equals("")))
		{
			DiarrhoeaPresent = Integer.parseInt((String) map.get("DiarrhoeaPresent"));
		}
		if(map.get("DiarrhoeaLast")!= null && !(map.get("DiarrhoeaLast").equals("")))
		{
			DiarrhoeaLast =Integer.parseInt((String) map.get("DiarrhoeaLast"));
		}
		if(map.get("DiarrhoeaRemarks")!= null && !(map.get("DiarrhoeaRemarks").equals("")))
		{
			DiarrhoeaRemarks =(String) map.get("DiarrhoeaRemarks");
		}
		if(map.get("InfectiousHepatitis")!= null && !(map.get("InfectiousHepatitis").equals("")))
		{
			InfectiousHepatitis =(String) map.get("InfectiousHepatitis");
		}
		if(map.get("InfectiousPresent")!=null && !(map.get("InfectiousPresent").equals("")))
		{
			InfectiousPresent = Integer.parseInt((String) map.get("InfectiousPresent"));
		}
		if(map.get("InfectiousLast")!= null && !(map.get("InfectiousLast").equals("")))
		{
			InfectiousLast =Integer.parseInt((String) map.get("InfectiousLast"));
		}
		if(map.get("InfectiousRemarks")!= null && !(map.get("InfectiousRemarks").equals("")))
		{
			InfectiousRemarks =(String) map.get("InfectiousRemarks");
		}
		if(map.get("RespiratoryGroup")!= null && !(map.get("RespiratoryGroup").equals("")))
		{
			RespiratoryGroup =(String) map.get("RespiratoryGroup");
		}
		if(map.get("RespiratoryPresent")!= null && !(map.get("RespiratoryPresent").equals("")))
		{
			RespiratoryPresent =Integer.parseInt((String) map.get("RespiratoryPresent"));
		}
		if(map.get("RespiratoryLast")!= null && !(map.get("RespiratoryLast").equals("")))
		{
			RespiratoryLast =Integer.parseInt((String) map.get("RespiratoryLast"));
		}
		String RespiratoryRemarks =(String) map.get("RespiratoryRemarks");
		if( map.get("STD")!= null && !( map.get("STD").equals("")))
		{
			STD =(String) map.get("STD");
		}
		if(map.get("STDPresent")!=null && !(map.get("STDPresent").equals("")))
		{
			STDPresent =Integer.parseInt((String) map.get("STDPresent"));
		}
		if(map.get("STDLast")!= null && !(map.get("STDLast").equals("")))
		{
			STDLast = Integer.parseInt((String) map.get("STDLast"));
		}
		if(map.get("STDRemarks")!= null && !(map.get("STDRemarks").equals("")))
		{
			STDRemarks =(String) map.get("STDRemarks");
		}
		if(map.get("Injuries")!= null && !(map.get("Injuries").equals("")))
		{
			Injuries =(String) map.get("Injuries");
		}
		if(map.get("InjuriesPresent")!= null && !(map.get("InjuriesPresent").equals("")))
		{
			InjuriesPresent =Integer.parseInt((String) map.get("InjuriesPresent"));
		}
		if(map.get("InjuriesLast")!= null && !(map.get("InjuriesLast").equals("")))
		{
			InjuriesLast = Integer.parseInt((String) map.get("InjuriesLast"));
		}
		if(map.get("InjuriesRemarks")!= null && !(map.get("InjuriesRemarks").equals("")))
		{
			InjuriesRemarks =(String) map.get("InjuriesRemarks");
		}
		if(map.get("flyingAccidents")!= null && !(map.get("flyingAccidents").equals("")))
		{
			flyingAccidents =(String) map.get("flyingAccidents");
		}
		if(map.get("gamesAccidents")!= null && !(map.get("gamesAccidents").equals("")))
		{
			gamesAccidents =(String) map.get("gamesAccidents");
		}
		if(map.get("twoWheelersAccidents")!= null && !(map.get("twoWheelersAccidents").equals("")))
		{
			twoWheelersAccidents =(String) map.get("twoWheelersAccidents");
		}
		if(map.get("mechanicalTransportAccident")!= null && !(map.get("mechanicalTransportAccident").equals("")))
		{
			mechanicalTransportAccident =(String) map.get("mechanicalTransportAccident");
		}
		if(map.get("otherAccidents")!= null && !(map.get("otherAccidents").equals("")))
		{
			otherAccidents =(String) map.get("otherAccidents");
		}
		if(map.get("reasonsforanyincreaseinIncident")!= null && !(map.get("reasonsforanyincreaseinIncident").equals("")))
		{
			reasonsforanyincreaseinIncident =(String) map.get("reasonsforanyincreaseinIncident");
		}
		if(map.get("hospitalId")!= null && !(map.get("hospitalId").equals("")))
		{
			hospital_Id = (Integer)map.get("hospitalId");
		}
		preventableDate = (Date)map.get("preventableDate"); 
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			for(int i=1; i<=6;i++)
			{   PreventableDiseaseEntry preventable = new  PreventableDiseaseEntry();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospital_Id);
			if(i==1)
			{preventable.setPreventableDiseaseName(MalariaFresh);
			preventable.setPresentQuarter(MalariaPresent);
			preventable.setLastQuarter(MalariaLast);
			preventable.setRemarks(MalariaRemarks);
			preventable.setPreventDate(currentDate);
			preventable.setHospital_Id(masHospital);
			hbt.save(preventable);
			hbt.refresh(preventable);
			}
			if(i==2)
			{
				preventable.setPreventableDiseaseName(DiarrhoeaDysentry);
				preventable.setPresentQuarter(DiarrhoeaPresent);
				preventable.setLastQuarter(DiarrhoeaLast);
				preventable.setRemarks(DiarrhoeaRemarks);
				preventable.setPreventDate(currentDate);
				preventable.setHospital_Id(masHospital);
				hbt.save(preventable);
				hbt.refresh(preventable);
			}
			if(i==3)
			{
				preventable.setPreventableDiseaseName(InfectiousHepatitis); 
				preventable.setPresentQuarter(InfectiousPresent);
				preventable.setLastQuarter(InfectiousLast);
				preventable.setRemarks(InfectiousRemarks);
				preventable.setPreventDate(currentDate);
				preventable.setHospital_Id(masHospital);
				hbt.save(preventable);
				hbt.refresh(preventable);
			}
			if(i==4)
			{
				preventable.setPreventableDiseaseName(RespiratoryGroup); 
				preventable.setPresentQuarter(RespiratoryPresent);
				preventable.setLastQuarter(RespiratoryLast);
				preventable.setRemarks(RespiratoryRemarks); 
				preventable.setPreventDate(currentDate);
				preventable.setHospital_Id(masHospital);
				hbt.save(preventable);
				hbt.refresh(preventable);
			}
			if(i==5)
			{
				preventable.setPreventableDiseaseName(STD); 
				preventable.setPresentQuarter(STDPresent);
				preventable.setLastQuarter(STDLast);
				preventable.setRemarks(STDRemarks); 
				preventable.setPreventDate(currentDate);
				preventable.setHospital_Id(masHospital);
				hbt.save(preventable);
				hbt.refresh(preventable);
			}
			if(i==6)
			{preventable.setPreventableDiseaseName(Injuries); 
			preventable.setPresentQuarter(InjuriesPresent);
			preventable.setLastQuarter(InjuriesLast);
			preventable.setRemarks(InjuriesRemarks);         		 
			preventable.setPreventDate(currentDate);
			preventable.setHospital_Id(masHospital);  
			}	  
			preventable.setFlyingAccident(flyingAccidents);
			preventable.setGamesAccident(gamesAccidents);
			preventable.setTwoWheelerAccident(twoWheelersAccidents);
			preventable.setMechanicalTransportAccident(mechanicalTransportAccident);
			preventable.setOtherAccident(otherAccidents);
			preventable.setReasonForIncreaseInAcc(reasonsforanyincreaseinIncident);
			preventable.setHospital_Id(masHospital);  
			preventable.setPreventDate(preventableDate);
			hbt.save(preventable);
			hbt.refresh(preventable);

			}

			succesfullyAdded = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return   succesfullyAdded;

	}
	public boolean submitAutomaticChloroform(Map map)
	{
		boolean succesfullyAdded = false;
		Session session = (Session) getSession();
		Date currentDate = new Date();
		String noAuthorised= (String)map.get("noAuthorised");
		String noInstalled= (String)map.get("noInstalled");
		String noUSduetoMechanicaldefect = (String)map.get("noUSduetoMechanicaldefect");
		String noUSduetononavailabilityofchlorinegas = (String)map.get("noUSduetononavailabilityofchlorinegas");
		String noUSduetononavailabilityofcylender = (String)map.get("noUSduetononavailabilityofcylender");
		String noofBPdoserinstalled = (String)map.get("noofBPdoserinstalled");
		String noofBPdoserUS = (String)map.get("noofBPdoserUS");
		String actionTaken = (String)map.get("actionTaken");
		String remarks = (String)map.get("remarks");
		int hospitalId= (Integer)map.get("hospitalId");
		Date chloroformEntryDate = (Date)map.get("chloroformEntryDate");
		int departmentId = (Integer)map.get("departmentId");
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			AutomaticBleachingEntry ambe = new  AutomaticBleachingEntry();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			ambe.setHospitalId(masHospital);
			ambe.setNoAuthorised(noAuthorised);
			ambe.setNoInstalled(noInstalled);
			ambe.setNoMechanicalDefect(noUSduetoMechanicaldefect);
			ambe.setNoChlorineGas(noUSduetononavailabilityofchlorinegas);
			ambe.setNoCylinder(noUSduetononavailabilityofcylender);
			ambe.setNoBpDoserInstalled(noofBPdoserinstalled);
			ambe.setNoBpDoserUs(noofBPdoserUS);
			ambe.setActionTaken(actionTaken);
			ambe.setRemarks(remarks);
			ambe.setChloroformEntryDate(chloroformEntryDate);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			ambe.setDepartmentId(masDepartment);
			hbt.save(ambe);	          
			succesfullyAdded = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return   succesfullyAdded;


	}
	public boolean submitAntiMalariaJsp(Map map)
	{
		boolean succesfullyAdded = false;
		Session session = (Session) getSession();
		Date currentDate = new Date();
		Date    dateOfAntiMalaria = null;
		String Numberofrounds = "";
		String Adoption = "";
		String AntiLarval ="";
		String AntiMalariameetings = "";
		String Suppressivetreatment = "";
		String Typesofcases ="";
		String SpecimenofPlasmodium = "";
		String weatherInvestigated ="";
		String Remedicalspreventing ="";
		String Flyproofing = "";
		String DisposalRefuse ="";
		String Frequencyofinsecticide = "";
		String Numberofbloodslides = "";
		String Detailsoftreatment = "";
		String AntiFilarialMeasures = "";
		int hospitalId =0;
		if(map.get("Numberofrounds")!= null)
		{
			Numberofrounds = (String)map.get("Numberofrounds");
		}
		if(map.get("Adoption") != null)
		{
			Adoption = (String)map.get("Adoption");
		}
		if(map.get("AntiLarval")!= null)
		{
			AntiLarval = (String)map.get("AntiLarval");
		}
		if(map.get("AntiMalariameetings") != null)
		{
			AntiMalariameetings = (String)map.get("AntiMalariameetings");
		}
		if(map.get("Suppressivetreatment") != null)
		{
			Suppressivetreatment = (String)map.get("Suppressivetreatment");
		}
		if(map.get("Typesofcases") != null)
		{
			Typesofcases = (String)map.get("Typesofcases");
		}
		if(map.get("SpecimenofPlasmodium") != null)
		{
			SpecimenofPlasmodium = (String)map.get("SpecimenofPlasmodium");
		}
		if(map.get("weatherInvestigated") != null)
		{
			weatherInvestigated = (String)map.get("weatherInvestigated");
		}
		if(map.get("Remedicalspreventing") != null)
		{
			Remedicalspreventing = (String)map.get("Remedicalspreventing");
		}
		if(map.get("Flyproofing") != null)
		{
			Flyproofing = (String)map.get("Flyproofing");
		}
		if(map.get("DisposalRefuse") != null)
		{
			DisposalRefuse = (String)map.get("DisposalRefuse");
		}
		if(map.get("Frequencyofinsecticide") != null)
		{
			Frequencyofinsecticide = (String)map.get("Frequencyofinsecticide");
		}
		if(map.get("Numberofbloodslides") != null)
		{
			Numberofbloodslides = (String)map.get("Numberofbloodslides");
		}
		if(map.get("Detailsoftreatment") != null)
		{
			Detailsoftreatment = (String)map.get("Detailsoftreatment");
		}
		if(map.get("AntiFilarialMeasures") != null)
		{
			AntiFilarialMeasures = (String)map.get("AntiFilarialMeasures");
		}
		if(map.get("hospitalId") != null)
		{
			hospitalId = (Integer)map.get("hospitalId");
		}
		if(map.get("DateOfAntiMalaria") != null)
		{
			dateOfAntiMalaria =  (Date) map.get("DateOfAntiMalaria");
		}
		try{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			AntiMalariaEntry antiMalariaEntry =  new AntiMalariaEntry();
			antiMalariaEntry.setNoOfRoundsSpray(Numberofrounds);
			antiMalariaEntry.setAdpPerProtective(Adoption);
			antiMalariaEntry.setAntiLarvalMeasure(AntiLarval);
			antiMalariaEntry.setNoOfAntiMalaria(AntiMalariameetings);
			antiMalariaEntry.setSuppressiveTreatment( Suppressivetreatment);
			antiMalariaEntry.setTypesOfCases(Typesofcases);
			antiMalariaEntry.setSpecimenOfPlasmodium(SpecimenofPlasmodium);
			antiMalariaEntry.setWeatherInvestigated(weatherInvestigated);
			antiMalariaEntry.setRemedicalMeasure(Remedicalspreventing);
			antiMalariaEntry.setFlyProofingKitchen(Flyproofing);
			antiMalariaEntry.setDisposalRefuseGarbage(DisposalRefuse);
			antiMalariaEntry.setFrequencyOfInsecticide(Frequencyofinsecticide);
			antiMalariaEntry.setBloodSlidesExamined(Numberofbloodslides);
			antiMalariaEntry.setDetailsOfTreatment(Detailsoftreatment);
			antiMalariaEntry.setAntiFilarialMeasures(AntiFilarialMeasures);
			antiMalariaEntry.setHospital_Id(masHospital);
			antiMalariaEntry.setDateOfAntiMalaria(dateOfAntiMalaria);
			hbt.save(antiMalariaEntry);
			succesfullyAdded = true;
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

		return   succesfullyAdded;
	}

	public boolean submitActivitiesDetails(Map map)
	{ 	
		String activityDetails ="";
		String activityOfficers="";  		
		String activityAirmen= "";
		String activityFamilies = "";
		String activityRemarks ="";
		int hospitalId =0;
		int departmentId =0;

		Date activityDate = HMSUtil.convertStringTypeDateToDateType((String) map.get("activityDate"));
		if(map.get("activityDetails") != null)
		{
			activityDetails = (String)map.get("activityDetails");
		}
		if(map.get("activityOfficers") != null)
		{  activityOfficers = (String)map.get("activityOfficers");
		}
		if(map.get("activityAirmen") != null)
		{
			activityAirmen = (String)map.get("activityAirmen");
		}
		if(map.get("activityFamilies") != null)
		{
			activityFamilies = (String)map.get("activityFamilies");
		}
		if(map.get("activityRemarks") != null)
		{
			activityRemarks = (String)map.get("activityRemarks");
		}
		if(map.get("hospitalId") != null)
		{
			hospitalId = (Integer)map.get("hospitalId");
		}
		if(map.get("departmentId") != null)
		{
			departmentId = (Integer)map.get("departmentId");
		}
		boolean succesfullyAdded = false;
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);	        
			ActivityDetails activityDetail = new ActivityDetails();
			activityDetail.setHospital_id(masHospital);
			activityDetail.setActivityDetails(activityDetails);
			activityDetail.setActivityOfficers(activityOfficers);
			activityDetail.setActivityAirmen(activityAirmen);
			activityDetail.setActivityFamilies(activityFamilies);
			activityDetail.setActivityRemarks(activityRemarks);
			activityDetail.setActivityDate(activityDate);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			activityDetail.setDepartmentId(masDepartment);
			hbt.save(activityDetail);
			succesfullyAdded = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return   succesfullyAdded;

	}

	public boolean submitHealthPromotionActivityJsp(Map map)
	{  
		int hospitalId = 0; 
		int departmentId = 0;
		int serialNo = 0;
		int hdb = 0;
		List<Date> approximatedate2 = new ArrayList<Date>();
		List<String> HealthPromotiontopic = new ArrayList<String>();
		
		List<String> HealthPromotionSubject = new ArrayList<String>();
        List<String> HealthPromotionRankCat = new ArrayList<String>();
        
		List<String>HealthPromotionplace = new ArrayList<String>();
		List<String> HealthPromotionattended = new ArrayList<String>();
		List<String> HealthPromotionremarks = new ArrayList<String>();
		if(map.get("hospitalId")!= null)
		{
			hospitalId = (Integer)map.get("hospitalId");
		}
		if(map.get("departmentId")!= null)
		{
			departmentId = (Integer)map.get("departmentId");
		}
		if(map.get("serialNo")!= null)
		{
			serialNo = (Integer)map.get("serialNo");
		}
		if(map.get("approximatedate2")!= null && !(map.get("approximatedate2").equals("")))
		{
			approximatedate2 =(List)map.get("approximatedate2");
		}
		if(map.get("HealthPromotiontopic")!= null && !(map.get("HealthPromotiontopic").equals("")))
		{
			HealthPromotiontopic=(List)map.get("HealthPromotiontopic");
		}
		
		if(map.get("HealthPromotionSubject")!= null && !(map.get("HealthPromotionSubject").equals("")))
		{
			HealthPromotionSubject=(List)map.get("HealthPromotionSubject");
		}
		
		if(map.get("HealthPromotionRankCat")!= null && !(map.get("HealthPromotionRankCat").equals("")))
		{
			HealthPromotionRankCat=(List)map.get("HealthPromotionRankCat");
		}
		
		
		if(map.get("HealthPromotionplace")!= null && !(map.get("HealthPromotionplace").equals("")))
		{	  HealthPromotionplace=(List)map.get("HealthPromotionplace");
		}
		if(map.get("HealthPromotionattended")!= null && !(map.get("HealthPromotionattended").equals("")))
		{
			HealthPromotionattended = (List)map.get("HealthPromotionattended");
		}
		if(map.get("HealthPromotionremarks")!= null && !(map.get("HealthPromotionremarks").equals("")))
		{
			HealthPromotionremarks = (List)map.get("HealthPromotionremarks");
		}
		if(map.get("hdb")!= null)
		{
			hdb = (Integer)map.get("hdb");
		}

		boolean succesfullyAdded = false;

		try
		{ org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		for(int i=0; i<hdb; i++)
		{
			HealthPromotionActivity healthPromotionActivity = new HealthPromotionActivity();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			healthPromotionActivity.setHospitalId(masHospital);
			MasDepartment masdepartment = new MasDepartment();
			masdepartment.setId(departmentId);
			healthPromotionActivity.setDepartmentId(masdepartment);
			//healthPromotionActivity.setId(serialNo);
			healthPromotionActivity.setHealthPromotionDate(approximatedate2.get(i));
			healthPromotionActivity.setHealthPromotionTopic(HealthPromotiontopic.get(i));
			
			healthPromotionActivity.setSubject(HealthPromotionSubject.get(i));
			healthPromotionActivity.setRankCategory(HealthPromotionRankCat.get(i));
			
			healthPromotionActivity.setHealthPromotionPlace(HealthPromotionplace.get(i));
			if(HealthPromotionattended.get(i)!= null && !(HealthPromotionattended.get(i).equals("")))
			{
				healthPromotionActivity.setHealthPromotionAttended(HealthPromotionattended.get(i));
			}
			healthPromotionActivity.setHealthPromotionRemark(HealthPromotionremarks.get(i));
			hbt.save(healthPromotionActivity);
			succesfullyAdded = true;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		return   succesfullyAdded;	

	}
	public boolean submitSroEntry(Map map)
	{
		Date sroEntryDate = HMSUtil.convertStringTypeDateToDateType((String)map.get("sroEntryDate"));
		String formName = "SroEntry";
		String sroEntryTime = (String)map.get("sroEntryTime");
		String sanitaryRound = (String)map.get("sanitaryRound");
		String sroEntryPlace = (String)map.get("sroEntryPlace");
		String sroEntryArea = (String)map.get("sroEntryArea");
		String sroEntryRemarks= (String)map.get("sroEntryRemarks");
		int hospitalId = (Integer)map.get("hospitalId");
		int departmentId = (Integer)map.get("deptId");
		boolean succesfullyAdded = false;
		try{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			SroEntrySanitary sro = new SroEntrySanitary();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			sro.setHospitalId(masHospital);
			sro.setSroEntryDate(sroEntryDate);
			sro.setSroEntryTime(sroEntryTime);
			sro.setSanitaryRound(sanitaryRound);
			sro.setSroEntryPlace(sroEntryPlace);
			sro.setSroEntryArea(sroEntryArea);
			sro.setSroEntryRemarks(sroEntryRemarks);
			sro.setFormName(formName);
			MasDepartment masDepartment = new  MasDepartment();
			masDepartment.setId(departmentId);
			sro.setDepartmentId(masDepartment);
			hbt.save(sro);
			succesfullyAdded = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return   succesfullyAdded;
	}
	public boolean submitSanitaryDefectNotes(Map map)
	{   String formName ="SanitaryDefectNotes";
	Date sanitaryDefectDate = HMSUtil.convertStringTypeDateToDateType((String) map.get("sanitaryDefectDate"));
	String sanitaryDefectTime = (String)map.get("sanitaryDefectTime");
	String sanatarydefectPlace = (String)map.get("sanatarydefectPlace");
	String sanitarydefectArea = (String)map.get("sanitarydefectArea");
	String sanataryDefectCheckedBy = (String)map.get("sanataryDefectCheckedBy");
	String remarkBySho = (String)map.get("remarkBySho");
	int hospitalId = (Integer)map.get("hospitalId");
	boolean succesfullyAdded = false;
	try
	{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		SroEntrySanitary sroEntrySanitary = new SroEntrySanitary();
		sroEntrySanitary.setSroEntryDate(sanitaryDefectDate);
		sroEntrySanitary.setSroEntryTime(sanitaryDefectTime);
		sroEntrySanitary.setSroEntryPlace(sanatarydefectPlace);
		sroEntrySanitary.setSroEntryArea(sanitarydefectArea);
		sroEntrySanitary.setCheckedBy(sanataryDefectCheckedBy);
		sroEntrySanitary.setRemarkBySho(remarkBySho);
		sroEntrySanitary.setFormName(formName);
		sroEntrySanitary.setHospitalId(masHospital);
		hbt.save(sroEntrySanitary);
		succesfullyAdded = true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return succesfullyAdded;
	}
	@SuppressWarnings("unchecked")
	public boolean submitSanitaryRoundJSP(Map map)
	{ 

		Date saniatrydate = null;
		int hospitalId = (Integer)map.get("hospitalId");		
		int departmentId = (Integer)map.get("departmentId");		
		String sanitarytype = (String)map.get("sanitarytype");		
		saniatrydate = (Date) map.get("saniatrydate");		 
		String serviceNo =(String) map.get("serviceNo");		 
		String nameofSanitaryRound = (String)map.get("nameofSanitaryRound");		 
		String sanitaryDesignation = (String)map.get("sanitaryDesignation");		
		String sanitaryBranch = (String)map.get("sanitaryBranch");		 
		String sanitaryClassification = (String)map.get("sanitaryClassification");		 
		String sanitaryarea = (String)map.get("sanitaryarea");		 
		String sanitaryplace = (String)map.get("sanitaryplace");		 
		String sanitaryobservation = (String)map.get("sanitaryobservation");		
		String sanitarysuggestion = (String)map.get("sanitarysuggestion");		 
		String remarksinchargesho = (String)map.get("remarksinchargesho");		 
		String remarkssrmedofficer = (String)map.get("remarkssrmedofficer");		 
		String remasrkofficerinchargeorg = (String)map.get("remasrkofficerinchargeorg");		 
		String remarkscadmo = (String)map.get("remarkscadmo"); 
		int hinId = 0;
		boolean succesfullyAdded = false;		
		try{
			org.hibernate.Session session = getSession();
			List<Patient> dependentList = new ArrayList<Patient>();
			dependentList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo)).createAlias("Relation", "rel")
					.add(Restrictions.eq("rel.RelationName", "Self")).list();

			//String query = "select 'hin_id' from Patient where service_no='"+serviceNo+"'";
			// Query hinId =   session.createQuery(query);
			if(dependentList!= null)
			{
				for(Patient patient : dependentList  )
				{
					hinId = patient.getId();

				}
			}
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);			        
			SanitaryRound sanitaryRound = new SanitaryRound();
			sanitaryRound.setHospitalId(masHospital);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			Patient patient = new Patient();
			patient.setId(hinId);
			sanitaryRound.setHinId( patient);
			sanitaryRound.setDepartmentId(masDepartment);
			sanitaryRound.setRoundType(sanitarytype);
			sanitaryRound.setSanitaryRoundDate(saniatrydate);
			sanitaryRound.setClassification(sanitaryClassification);
			sanitaryRound.setSanitaryArea(sanitaryarea);
			sanitaryRound.setSanitaryPlace(sanitaryplace);
			sanitaryRound.setObservation(sanitaryobservation);
			sanitaryRound.setSuggestion(sanitarysuggestion);
			sanitaryRound.setRemarksBySho(remarksinchargesho);
			sanitaryRound.setRemarksByOfficerInCharge(remarkssrmedofficer);
			sanitaryRound.setRemarksBySrMedofficer(remasrkofficerinchargeorg);
			sanitaryRound.setRemarksByCadmo(remarkscadmo);
			hbt.save(sanitaryRound);
			hbt.refresh(sanitaryRound);
			succesfullyAdded = true;
			int sanitaryId=0;
			sanitaryId = sanitaryRound.getId();
			map.put("sanitaryId",sanitaryId);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return succesfullyAdded ;
	}

	public boolean submitSchoolInspectionEntry(Map map)
	{  boolean successfullyAdded = false;
	int hospitalId = (Integer)map.get("hospitalId");
	int departmentId = (Integer)map.get("departmentId");
	Date inspectionDate = null;
	inspectionDate = (Date) map.get("inspectionDate");
	String nameofSchool = (String)map.get("nameofSchool");
	String nameofInspectingPerson = (String)map.get("nameofInspectingPerson");
	String noofChildrenMedicallyExamined = (String)map.get("noofChildrenMedicallyExamined");
	String dentalCarries = (String)map.get("dentalCarries");
	String defectiveVision = (String)map.get("defectiveVision");
	String waxEar = (String)map.get("waxEar");
	String enlargedGlands = (String)map.get("enlargedGlands");
	String other =(String)map.get("other"); 
	String actiontorectifythedefects = (String)map.get("actiontorectifythedefects");
	String detailsofprotective = (String)map.get("detailsofprotective");
	try
	{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate(); 
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		SchoolInspectionEntry schoolInspectionEntry = new SchoolInspectionEntry(); 
		schoolInspectionEntry.setHospitalId(masHospital);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		schoolInspectionEntry.setDepartmentId(masDepartment);
		schoolInspectionEntry.setDateOfInspection(inspectionDate);
		schoolInspectionEntry.setNameOfSchool(nameofSchool);
		schoolInspectionEntry.setNameOfInspectingPerson(nameofInspectingPerson);
		schoolInspectionEntry.setNoChildrenMedicallyExamined(noofChildrenMedicallyExamined);
		schoolInspectionEntry.setDentalCarries(dentalCarries);
		schoolInspectionEntry.setDefectiveVision(defectiveVision);
		schoolInspectionEntry.setWaxEar(waxEar);
		schoolInspectionEntry.setEnlargedGlands(enlargedGlands);
		schoolInspectionEntry.setOther(other);
		schoolInspectionEntry.setActionRectifyDefects(actiontorectifythedefects);
		schoolInspectionEntry.setDetailsProtSchoolChild(detailsofprotective);
		hbt.save(schoolInspectionEntry);
		hbt.refresh(schoolInspectionEntry);
		successfullyAdded = true;
		int schInsId = 0;
		schInsId = schoolInspectionEntry.getId();
		map.put("schInsId",schInsId);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return successfullyAdded ;

	}
	public boolean submitMonitoringofADS(Map map)
	{  Date diagnosisDate = null;
	Date lastMedBoardDate = null;
	Date counsellingDate = null;
	Date postingDate = null;
	int hospitalId = (Integer)map.get("hospitalId");		 
	int departmentId = (Integer)map.get("departmentId");		  
	int hinId = Integer.parseInt(""+map.get("hinId")); 	  

	diagnosisDate = (Date)map.get("diagnosisDate");		  
	int medicalCategory = Integer.parseInt(""+map.get("medicalCategory"));

	lastMedBoardDate=(Date)map.get("lastMedBoardDate");

	counsellingDate = (Date)map.get("counsellingDate");

	String warningLetter = (String)map.get("warningLetter");

	String retentioninService =(String)map.get("retentioninService");

	postingDate = (Date)map.get("postingDate");

	String freshOld = (String)map.get("freshOld");

	String remarks = (String)map.get("remarks");

	boolean successfullyAdded =false;
	try {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		Patient patient = new Patient();
		patient.setId(hinId);
		MonitoringOfAds monitoringOfAds = new MonitoringOfAds();
		monitoringOfAds.setHospitalId(masHospital);
		monitoringOfAds.setDepartmentId(masDepartment);
		monitoringOfAds.setHinId(patient);
		monitoringOfAds.setDateOfDiagnosis(diagnosisDate);
		monitoringOfAds.setLastMedBoardDate(lastMedBoardDate);
		monitoringOfAds.setCounsellingDate(counsellingDate);
		monitoringOfAds.setWarningLetter(warningLetter);
		monitoringOfAds.setRetentionInService(retentioninService);
		monitoringOfAds.setDateOfPosting(postingDate);
		monitoringOfAds.setFresh(freshOld);
		monitoringOfAds.setRemarks(remarks);
		Category category = new Category();
		category.setCategoryid(medicalCategory);
		monitoringOfAds.setMedicalCategoryId(category);
		hbt.save(monitoringOfAds);
		successfullyAdded = true;
	}
	catch(Exception  e)
	{
		e.printStackTrace();
	}
	return successfullyAdded ;
	}
	public boolean submitMentalPhysicalRetarded(Map map)
	{   int hospitalId = (Integer)map.get("hospitalId");		 
	int departmentId = (Integer)map.get("departmentId");		  
	int hinId = Integer.parseInt(""+map.get("hinId"));
	// int serviceNo = (Integer)(""+map.get("serviceNo"));
	String name =(String) map.get("name");
	String relation = (String)map.get("relation");
	String rank = (String)map.get("rank");
	String age = (String)map.get("age");
	String branch = (String)map.get("branch");
	String unit = (String)map.get("unit");
	String hospitalName =(String)map.get("hospitalName");
	String diagnosis = (String)map.get("diagnosis");
	String mentalRetarted = (String)map.get("mentalRetarted");
	String childrenName = (String)map.get("childrenName");
	String childrenAge = (String)map.get("ChildrenAge");
	String remarks = (String)map.get("remarks");
	boolean successfullyAdded =false;
	try
	{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Patient patient = new Patient();
		patient.setId(hinId);
		MentalPhysicalRetarded mentalPhysicalRetarded = new MentalPhysicalRetarded();
		mentalPhysicalRetarded.setHinId(patient);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		mentalPhysicalRetarded.setDepartmentId(masDepartment);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		mentalPhysicalRetarded.setHospitalId(masHospital);
		mentalPhysicalRetarded.setHospitalName(hospitalName);
		mentalPhysicalRetarded.setDiagnosis(diagnosis);
		mentalPhysicalRetarded.setMentalPhysicalRetarted(mentalRetarted);
		mentalPhysicalRetarded.setChildrenName(childrenName);
		mentalPhysicalRetarded.setChildrenAge(childrenAge);
		mentalPhysicalRetarded.setRemarks(remarks);
		hbt.save(mentalPhysicalRetarded);
		successfullyAdded = true;	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return successfullyAdded ;
	}
	public boolean submitNutritionExamination(Map map)
	{   
		Date examinationDate = null;
		String qualityofRation = "";
		String stateofPersonnel = "";
		String cookingandmessing = "";
		String unhygienicDefects = "";
		String meatSupplySource = "";
		String meatquality = "";
		String milkSupply = "";
		String milkquality = "";
		int hospitalId = (Integer)map.get("hospitalId");		 
		int departmentId = (Integer)map.get("departmentId");
		if(map.get("qualityofRation")!= null)
		{
			qualityofRation = (String)map.get("qualityofRation");
		}
		if(map.get("stateofPersonnel")!= null)
		{
			stateofPersonnel = (String)map.get("stateofPersonnel");
		}
		if(map.get("cookingandmessing")!= null)
		{
			cookingandmessing = (String)map.get("cookingandmessing");
		}
		if(map.get("unhygienicDefects")!= null)
		{
			unhygienicDefects = (String)map.get("unhygienicDefects");
		}
		if(map.get("meatSupplySource")!= null)
		{
			meatSupplySource = (String)map.get("meatSupplySource");
		}
		if(map.get("meatquality")!= null)
		{
			meatquality = (String)map.get("meatquality");
		}
		if(map.get("milkSupply")!= null)
		{
			milkSupply = (String)map.get("milkSupply");
		}
		if(map.get("milkquality")!= null)
		{
			milkquality = (String)map.get("milkquality");
		}
		String remarks =(String)map.get("remarks");
		String actionTaken = (String)map.get("actionTaken");
		examinationDate = (Date)map.get("examinationDate");
		boolean successfullyAdded = false;
		try
		{  org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");  
		hbt.setCheckWriteOperations(false);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		NutritionExamination nutrationExamination = new NutritionExamination();
		nutrationExamination.setDepartmentId(masDepartment);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		nutrationExamination.setHospitalId(masHospital);
		nutrationExamination.setQualityOfRation(qualityofRation);
		nutrationExamination.setStateOfPersonnel(stateofPersonnel);
		nutrationExamination.setCookingMessagingArrang(cookingandmessing);
		nutrationExamination.setUnhygienicDefects(unhygienicDefects);
		nutrationExamination.setMeatSupplySource(meatSupplySource);
		nutrationExamination.setMeatQuality(meatquality);
		nutrationExamination.setMilkSupplySource(milkSupply);
		nutrationExamination.setMilkQuality(milkquality);
		nutrationExamination.setRemarks(remarks);
		nutrationExamination.setActionTaken(actionTaken);
		nutrationExamination.setExaminationDate(examinationDate);
		hbt.save(nutrationExamination);
		successfullyAdded = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean submitFeedbackCounselorJsp(Map map)
	{  String visitNo = "";
	String name = "";
	String qualification ="";
	String honorarium ="";
	Date employedDate = new Date();
	String totalHours ="";
	String   address ="";
	String avgPersonCounsled = "";
	String typesCasesCounseled = "";
	int forwardedTo=0;
	boolean successfullyAdded = false;
	int departmentId = (Integer)map.get("departmentId");	   
	int hospitalId = (Integer)map.get("hospitalId");
	String remarks="";
	
	  String honorariumPerMonth="";
	   String avgNoPersonCounseled="";
	   String alcoholDependence="";
	   String domesticProblems="";
	   String educationalIssue="";
	   String financialIssue="";
	   String interPersonalProblem="";
	   String serviceRelatedIssue="";
	   String othersSpecify="";
	   String casesCounseled="";
	   String counselingAfterWorkingHour="";
	   String noOfCasesPerMonth="";
	   String phNoAfterWorkingHour="";
	   String signature="";
	   
	if(map.get("name")!= null)
	{
		name = (String)map.get("name");
	}
	if(map.get("qualification")!= null)
	{
		qualification = (String)map.get("qualification");
	}
	if(map.get("honorarium")!= null)
	{
		honorarium = (String)map.get("honorarium");
	}
	if(map.get("visitNo")!= null)
	{
		visitNo = (String)map.get("visitNo");
	}
	if(map.get("employedDate")!= null)
	{
		employedDate = (Date)map.get("employedDate");
	}
	if(map.get("totalHours")!= null)
	{
		totalHours = (String)map.get("totalHours");
	}
	if(map.get("address")!= null)
	{	     
		address = (String)map.get("address");
	}

	if(map.get("remarks")!= null)
	{	     
		remarks = (String)map.get("remarks");
	}

	if(map.get("avgPersonCounsled")!= null)
	{
		avgPersonCounsled = (String)map.get("avgPersonCounsled");
	}
	if(map.get("typesCasesCounseled")!= null)
	{
		typesCasesCounseled = (String)map.get("typesCasesCounseled");
	}
	if(map.get("forwardedTo")!= null)
	{
		forwardedTo = (Integer)map.get("forwardedTo");
	}

	if(map.get("honorariumPerMonth")!= null)
	{	     
		honorariumPerMonth = (String)map.get("honorariumPerMonth");
	}
	
	if(map.get("avgNoPersonCounseled")!= null)
	{	     
		avgNoPersonCounseled = (String)map.get("avgNoPersonCounseled");
	}
	
	if(map.get("alcoholDependence")!= null)
	{	     
		alcoholDependence = (String)map.get("alcoholDependence");
	}
	
	if(map.get("domesticProblems")!= null)
	{	     
		domesticProblems = (String)map.get("domesticProblems");
	}
	
	if(map.get("educationalIssue")!= null)
	{	     
		educationalIssue = (String)map.get("educationalIssue");
	}
	
	if(map.get("financialIssue")!= null)
	{	     
		financialIssue = (String)map.get("financialIssue");
	}
	
	if(map.get("interPersonalProblem")!= null)
	{	     
		interPersonalProblem = (String)map.get("interPersonalProblem");
	}
	
	if(map.get("serviceRelatedIssue")!= null)
	{	     
		serviceRelatedIssue = (String)map.get("serviceRelatedIssue");
	}
	
	if(map.get("othersSpecify")!= null)
	{	     
		othersSpecify = (String)map.get("othersSpecify");
	}
	
	
	if(map.get("casesCounseled")!= null)
	{	     
		casesCounseled = (String)map.get("casesCounseled");
	}
	
	if(map.get("counselingAfterWorkingHour")!= null)
	{	     
		counselingAfterWorkingHour = (String)map.get("counselingAfterWorkingHour");
	}
	
	if(map.get("noOfCasesPerMonth")!= null)
	{	     
		noOfCasesPerMonth = (String)map.get("noOfCasesPerMonth");
	}
	
	if(map.get("phNoAfterWorkingHour")!= null)
	{	     
		phNoAfterWorkingHour = (String)map.get("phNoAfterWorkingHour");
	}
	
	if(map.get("signature")!= null)
	{	     
		signature = (String)map.get("signature");
	}
	
	   
	FeedbackOfCounselor feedBackCouncelor = new FeedbackOfCounselor();
	try
	{ 
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		feedBackCouncelor.setHospitalId(masHospital);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		feedBackCouncelor.setDepartmentId(masDepartment);
		feedBackCouncelor.setNameOfCounselor(name);
		feedBackCouncelor.setQualification( qualification);
		feedBackCouncelor.setNoOfVisitPerWeek(visitNo);
		feedBackCouncelor.setEmployedDate(employedDate);
		feedBackCouncelor.setPlaceOfCounseling(address);
		feedBackCouncelor.setAvgNoPersonCounseled(avgPersonCounsled);
		feedBackCouncelor.setTypeCasesCounseled(typesCasesCounseled);
		MasEmployee masEmployee=new MasEmployee();
		masEmployee.setId(forwardedTo);
		feedBackCouncelor.setForWardedTo(masEmployee);
		feedBackCouncelor.setMoStatus("Pending");
		feedBackCouncelor.setREMARKS(remarks);
		
		feedBackCouncelor.setHonorariumPerMonth(honorariumPerMonth);
		feedBackCouncelor.setAvgNoPersonCounseled(avgNoPersonCounseled);
		feedBackCouncelor.setAlcoholDependence(alcoholDependence);
		feedBackCouncelor.setDomesticProblems(domesticProblems);
		feedBackCouncelor.setEducationalIssue(educationalIssue);
		feedBackCouncelor.setFinancialIssue(financialIssue);
		feedBackCouncelor.setInterPersonalProblem(interPersonalProblem);
		feedBackCouncelor.setServiceRelatedIssue(serviceRelatedIssue);
		feedBackCouncelor.setOtherSpecify(othersSpecify);
		feedBackCouncelor.setCasesCounseled(casesCounseled);
		feedBackCouncelor.setCounselingAfterWorkingHour(counselingAfterWorkingHour);
		feedBackCouncelor.setNoOfCasesPerMonth(noOfCasesPerMonth);
		feedBackCouncelor.setPhNo(phNoAfterWorkingHour);
		feedBackCouncelor.setSignature(signature);
		
		
		hbt.save(feedBackCouncelor);
		hbt.refresh(feedBackCouncelor);
		successfullyAdded = true;
		int feedBackId=0;
		feedBackId = feedBackCouncelor.getId();
		map.put("feedBackId", feedBackId);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return successfullyAdded;
	}
	public boolean submitMeetingHeldAgency(Map map)
	{
		boolean successfullyAdded = false;
		int departmentId = 0;
		int hospitalId = 0;
		String particularsofMeeting = "";
		Date meetingDate = new Date();
		String subjectDiscussedinMeeting = "";
		String decisionimplementedFollow = "";
		String summaryofdecisiontaken = "";
		String remarksinMeeting = "";
		if(map.get("departmentId")!= null)
		{
			departmentId = (Integer)map.get("departmentId");
		}
		if(map.get("hospitalId")!= null)
		{
			hospitalId = (Integer)map.get("hospitalId");
		}
		if(map.get("particularsofMeeting")!= null)
		{
			particularsofMeeting = (String)map.get("particularsofMeeting");
		}
		if(map.get("meetingDate")!= null)
		{
			meetingDate = (Date)map.get("meetingDate");
		}
		if(map.get("subjectDiscussedinMeeting")!= null)
		{
			subjectDiscussedinMeeting = (String)map.get("subjectDiscussedinMeeting");
		}
		if(map.get("decisionimplementedFollow")!= null)
		{
			decisionimplementedFollow = (String)map.get("decisionimplementedFollow");
		}
		if(map.get("summaryofdecisiontaken")!= null)
		{
			summaryofdecisiontaken = (String)map.get("summaryofdecisiontaken");
		}
		if(map.get("remarksinMeeting")!= null)
		{
			remarksinMeeting = (String)map.get("remarksinMeeting");
		}
		try{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MeetingHeldAgencies meetingHeld = new MeetingHeldAgencies();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);			   
			meetingHeld.setHospitalId(masHospital);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			meetingHeld.setDepartmentId(masDepartment);
			meetingHeld.setParticularOfMeeting(particularsofMeeting);
			meetingHeld.setDateOfMeeting(meetingDate);
			meetingHeld.setSubjectDiscussedMeeting(subjectDiscussedinMeeting);
			meetingHeld.setDecisionImplementAction(decisionimplementedFollow);
			meetingHeld.setSummaryDecisionTaken(summaryofdecisiontaken);
			meetingHeld.setRemarks(remarksinMeeting);
			hbt.save( meetingHeld);			 
			successfullyAdded = true;			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public boolean submitFreeFromInfection(Map map)
	{ int hospitalId =0;
	int departmentId = 0;
	List<Integer> serialNoList = new ArrayList<Integer>();
	int hdb1 = 1;
	List<Date> infectionDateList = new ArrayList<Date>();
	List<String> PurposeList = new ArrayList<String>();
	List<String> particularIndList = new ArrayList<String>();
	List<String> FitUnfitList = new ArrayList<String>();
	List<String>   placeList = new ArrayList<String>();
	if(map.get("hospitalId")!= null && !(map.get("hospitalId")).equals(""))
	{
		hospitalId= (Integer)map.get("hospitalId");
	}
	if(map.get("departmentId")!= null && !(map.get("departmentId")).equals(""))
	{
		departmentId = (Integer)map.get("departmentId");
	}
	if(map.get("serialNoList")!= null && !(map.get("serialNoList")).equals(""))
	{
		serialNoList = (List)map.get("serialNoList");
	}
	if(map.get("infectionDateList")!= null && !(map.get("infectionDateList")).equals(""))
	{
		infectionDateList = (List)map.get("infectionDateList");
	}
	if(map.get("placeList")!= null && !(map.get("placeList")).equals(""))
	{
		placeList =  (List)map.get("placeList");
	}
	if(map.get("PurposeList")!= null && !(map.get("PurposeList")).equals(""))
	{
		PurposeList = (List)map.get("PurposeList");
	}
	if(map.get("particularIndList")!= null && !(map.get("particularIndList")).equals(""))
	{
		particularIndList = (List)map.get("particularIndList");
	}
	if(map.get("FitUnfitList")!= null && !(map.get("FitUnfitList")).equals(""))
	{
		FitUnfitList = (List)map.get("FitUnfitList");
	}
	if(map.get("hdb1")!= null && !(map.get("hdb1")).equals(""))
	{
		hdb1 = (Integer)map.get("hdb1");
	}
	boolean successfullyAdded = false;

	try
	{ 
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		for(int i=0;i< hdb1; i++  )
		{  
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			FreeFromInfection freeFromInfection = new FreeFromInfection();
			freeFromInfection.setHospitalId(masHospital);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			freeFromInfection.setDepartmentId(masDepartment);

			//freeFromInfection.setId(serialNoList.get(i));		

			freeFromInfection.setInfectionDate(infectionDateList.get(i));

			freeFromInfection.setInfPlace(placeList.get(i));

			freeFromInfection.setInfPurpose(PurposeList.get(i));


			freeFromInfection.setInfParticular(particularIndList.get(i));


			freeFromInfection.setInfFitUnfit(FitUnfitList.get(i));

			hbt.save(freeFromInfection);
		}
		successfullyAdded = true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return successfullyAdded;
	}
	public boolean submitWaterSurveillanceJsp(Map map)
	{
		int hospitalId = 0;
		int departmentId = 0;
		int hdb1 =1;
		List<Integer> serialNoList = new ArrayList<Integer>() ; 
		List<Date> waterSurveillancedateList = new ArrayList<Date>();
		List<String> typeOfExaminationList = new ArrayList<String>();
		List<String> sourceList = new ArrayList<String>();
		List<String> placeList = new ArrayList<String>();
		List<String> resultList = new ArrayList<String>();
		List<String> quantityList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();

		if(map.get("hospitalId")!= null && !(map.get("hospitalId")).equals(""))
		{
			hospitalId= (Integer)map.get("hospitalId");
		}
		if(map.get("departmentId")!= null && !(map.get("departmentId")).equals(""))
		{
			departmentId = (Integer)map.get("departmentId");
		}
		if(map.get("serialNoList")!= null && !(map.get("serialNoList")).equals(""))
		{
			serialNoList = (List)map.get("serialNoList");
		}
		if(map.get("waterSurveillancedateList")!= null && !(map.get("waterSurveillancedateList")).equals(""))
		{
			waterSurveillancedateList = (List)map.get("waterSurveillancedateList");
		}
		if(map.get("typeOfExaminationList")!= null && !(map.get("typeOfExaminationList")).equals(""))
		{
			typeOfExaminationList =  (List)map.get("typeOfExaminationList");
		}
		if(map.get("sourceList")!= null && !(map.get("sourceList")).equals(""))
		{
			sourceList = (List)map.get("sourceList");
		}
		if(map.get("placeList")!= null && !(map.get("placeList")).equals(""))
		{
			placeList = (List)map.get("placeList");
		}
		if(map.get("resultList")!= null && !(map.get("resultList")).equals(""))
		{
			resultList = (List)map.get("resultList");
		}
		if(map.get("quantityList")!= null && !(map.get("quantityList")).equals(""))
		{
			quantityList = (List)map.get("quantityList");
		}
		if(map.get("remarksList")!= null && !(map.get("remarksList")).equals(""))
		{
			remarksList = (List)map.get("remarksList");
		}
		if(map.get("hdb1")!= null && !(map.get("hdb1")).equals(""))
		{
			hdb1 = (Integer)map.get("hdb1");
		}
		boolean successfullyAdded = false;

		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			for(int i=0; i<hdb1; i++  )
			{  
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				WaterSurvillance  waterSurvillance = new WaterSurvillance();
				waterSurvillance.setHospitalId(masHospital);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				waterSurvillance.setDepartmentId(masDepartment);
				// waterSurvillance.setId(i);
				if(waterSurveillancedateList.get(i)!=null && !waterSurveillancedateList.get(i).equals("")){
					waterSurvillance.setSurvilanceDate(waterSurveillancedateList.get(i));
				}
				waterSurvillance.setTypeOfExamination(typeOfExaminationList.get(i));
				waterSurvillance.setSourceOfWaterSupply(sourceList.get(i));
				waterSurvillance.setPlaceOfCollection(placeList.get(i)); 
				waterSurvillance.setResult(resultList.get(i));
				waterSurvillance.setQuantity(quantityList.get(i)); 
				waterSurvillance.setRemarks(remarksList.get(i)); 
				hbt.save(waterSurvillance);
			}


			successfullyAdded = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}

		return successfullyAdded;

	}
	public Map<String, Object> getServiceNoDetailsForSho(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = box.getString("serviceNo");		
		int serviceTypeId = box.getInt(SERVICE_TYPE_ID);
		List<Patient> dependentList = new ArrayList<Patient>();
		Criteria objectList=null;

		org.hibernate.Session session = getSession();
		//String query = " select hin_id from Patient where service_no = '"+ serviceNo+" '";
		objectList = session.createCriteria(Patient.class).add(Restrictions.eq("serviceNo", serviceNo));

		dependentList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
		.add(Restrictions.eq("Status", "y")).list();
		//		List<MasEmployeeDependent> dependentList = new ArrayList<MasEmployeeDependent>();
		/*dependentList = session.createCriteria(MasEmployeeDependent.class).createAlias("Employee", "emp")
							.add(Restrictions.eq("emp.ServiceNo", serviceNo))
							.createAlias("emp.ServiceType", "st").add(Restrictions.eq("st.Id", serviceTypeId)).add(Restrictions.eq("Status", "y")).list();*/
		map.put("dependentList",dependentList);
		map.put("serviceNo",serviceNo);

		return map;
	}
	public Map<String,Object> getServiceNoDetailsForAttemptSucide(Box box)
	{ Map<String,Object> map = new HashMap<String,Object>();
	String serviceNo = box.getString("serviceNo");		
	List<Patient> dependentList = new ArrayList<Patient>();
	Criteria objectList=null;		
	org.hibernate.Session session = getSession();
	//String query = " select hin_id from Patient where service_no = '"+ serviceNo+" '";
	objectList = session.createCriteria(Patient.class).add(Restrictions.eq("serviceNo", serviceNo));

	dependentList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
	.add(Restrictions.eq("Status", "y")).list();
	map.put("dependentList",dependentList);
	map.put("serviceNo",serviceNo);

	return map;

	}
	public Map<String, Object> getServiceNoDetailsForADS(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = box.getString("serviceNo");	
		int serviceTypeId = box.getInt(SERVICE_TYPE_ID);
		List<Patient> dependentList = new ArrayList<Patient>();
		Criteria objectList=null;

		org.hibernate.Session session = getSession();
		//String query = " select hin_id from Patient where service_no = '"+ serviceNo+" '";
		objectList = session.createCriteria(Patient.class).add(Restrictions.eq("serviceNo", serviceNo));


		dependentList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
		.add(Restrictions.eq("Status", "y")).list();

		//		List<MasEmployeeDependent> dependentList = new ArrayList<MasEmployeeDependent>();
		/*dependentList = session.createCriteria(MasEmployeeDependent.class).createAlias("Employee", "emp")
							.add(Restrictions.eq("emp.ServiceNo", serviceNo))
							.createAlias("emp.ServiceType", "st").add(Restrictions.eq("st.Id", serviceTypeId)).add(Restrictions.eq("Status", "y")).list();*/
		map.put("dependentList",dependentList);
		map.put("serviceNo",serviceNo);

		return map;
	}
	public Map<String, Object> getServiceNoDetailsForMentalPhysical(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = box.getString("serviceNo");		
		int serviceTypeId = box.getInt(SERVICE_TYPE_ID);
		List<Patient> dependentList = new ArrayList<Patient>();
		Criteria objectList=null;

		org.hibernate.Session session = getSession();
		//String query = " select hin_id from Patient where service_no = '"+ serviceNo+" '";
		objectList = session.createCriteria(Patient.class).add(Restrictions.eq("serviceNo", serviceNo));


		dependentList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
		.add(Restrictions.eq("Status", "y")).list();

		//		List<MasEmployeeDependent> dependentList = new ArrayList<MasEmployeeDependent>();
		/*dependentList = session.createCriteria(MasEmployeeDependent.class).createAlias("Employee", "emp")
							.add(Restrictions.eq("emp.ServiceNo", serviceNo))
							.createAlias("emp.ServiceType", "st").add(Restrictions.eq("st.Id", serviceTypeId)).add(Restrictions.eq("Status", "y")).list();*/
		map.put("dependentList",dependentList);
		map.put("serviceNo",serviceNo);

		return map;
	}

	public Map<String,Object>	getServiceNoDetailsForSanitary(Box box)
	{ Map<String,Object> map = new HashMap<String,Object>(); 
	String serviceNo = box.getString("serviceNo");

	int serviceTypeId = box.getInt(SERVICE_TYPE_ID);
	List<Patient> dependentList = new ArrayList<Patient>();
	Criteria objectList=null;

	org.hibernate.Session session = getSession();
	//String query = " select hin_id from Patient where service_no = '"+ serviceNo+" '";
	objectList = session.createCriteria(Patient.class).add(Restrictions.eq("serviceNo", serviceNo));

	dependentList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();

	//		List<MasEmployeeDependent> dependentList = new ArrayList<MasEmployeeDependent>();
	/*dependentList = session.createCriteria(MasEmployeeDependent.class).createAlias("Employee", "emp")
							.add(Restrictions.eq("emp.ServiceNo", serviceNo))
							.createAlias("emp.ServiceType", "st").add(Restrictions.eq("st.Id", serviceTypeId)).add(Restrictions.eq("Status", "y")).list();*/
	map.put("dependentList",dependentList);
	map.put("serviceNo",serviceNo);

	return map;
	}

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
	/**
	 * editAfmsfDef()is used for:- 1) if fetching records from MasEmployee then
	 * enter a new record in EmpAfmsfDet table. 2) else, it is fetching records
	 * from the EmpAfmsfDet table, then update the selected record in
	 * EmpAfmsfDet table. Receipt Status is set to 'R'.
	 */

	/*public boolean editAfmsfDef(Map<String, Object> generalMap) {
		Session session = (Session) getSession();
		boolean dataUpdated = false;
		String currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String changedBy = "";

		session = (Session) getSession();
		Transaction tx = null;
		String postedFromId = null;
		String postedToId = null;
		//int presentUnit = 0;
		String presentUnit = null;
		String auth = "";
		String remarks = "";
		int medicalCat = 0;
		int hospitalId = 0;
		int rankId = 0;
		int empId = 0;
		int tradeId = 0;
		String letterNo = "0";
		String status = "";
		String serviceNo = null;
		String datePostingIn = null;
		String datePostingOut = null;
		String employeeName = null;
		Date receiptDate = null;
		String docStatus = "";
		Date postingInDate = null;
		Date datePostingDate = null;
		String authpostingOut = null;
		String disRemarks = null;
		String disletterNo = null;
		Date dispatchDate = null;
		String suffix = "";
		String lastName = null;
		String unitName = null;
		String unitAddress = null;
		String localUnit = null;

		// Date dispatchdate =null;
		Date nextreviewdate = null;
		String diagnosis = null;

		String receiptStatusChg;
		int empAfmsId = 0;
		serviceNo = (String) generalMap.get("serviceNo");

		receiptDate = (Date) generalMap.get("receiptdate");
		employeeName = (String) generalMap.get("employeeName");
		empId = (Integer) generalMap.get("employeeId");
		rankId = (Integer) generalMap.get("rankId");
		letterNo = (String) generalMap.get("letterNo");
		currentDate = (String) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		changedBy = (String) generalMap.get("changedBy");
		hospitalId = (Integer) generalMap.get("hospitalId");
		// empafmsfdetId = (Integer) generalMap.get("empafmsfdetId");
		status = (String) generalMap.get("status");
		Date currentDateDate = HMSUtil
				.convertStringTypeDateToDateType(currentDate);
		auth = (String) generalMap.get("auth");
		remarks = (String) generalMap.get("remarks");
		medicalCat = (Integer) generalMap.get("medicalcategory");
		postedToId = (String) generalMap.get("postedToId");
		postedFromId = (String) generalMap.get("postedFromId");
		presentUnit = (String) generalMap.get("presentUnit");
		//presentUnit = (Integer) generalMap.get("presentUnit");
		empAfmsId = (Integer) generalMap.get("empAfmsId");
		tradeId = (Integer) generalMap.get("tradeId");
		datePostingIn = (String) generalMap.get("datePostingIn");
		datePostingOut = (String) generalMap.get("datePostingOut");
		authpostingOut = (String) generalMap.get("authpostingOut");
		disRemarks = (String) generalMap.get("disRemarks");
		disletterNo = (String) generalMap.get("disletterNo");
		dispatchDate = (Date) generalMap.get("dispatchdate");
		nextreviewdate = (Date) generalMap.get("nextreviewDate");
		docStatus = (String) generalMap.get("docStatus");
		//suffix = (String) generalMap.get("suffix");
		diagnosis = (String) generalMap.get("diagnosis");
		lastName = (String) generalMap.get("lastName");
		unitName = (String) generalMap.get("unitName");
		unitAddress = (String) generalMap.get("unitAddress");
		localUnit = (String) generalMap.get("localUnit");

		if (datePostingIn != null) {
			postingInDate = HMSUtil
					.convertStringTypeDateToDateType(datePostingIn);
		}

		if (datePostingOut != null) {
			datePostingDate = HMSUtil
					.convertStringTypeDateToDateType(datePostingOut);
		}

		if (dispatchDate != null) {
			// dispatchdate =
			// HMSUtil.convertStringTypeDateToDateType(dispatchDate);
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			tx = session.beginTransaction();
			EmpAfmsfDet empAfmsfDet = new EmpAfmsfDet();
			if (empAfmsId == 0) {
				List<MasEmployee> EmployeeList = new ArrayList<MasEmployee>();
				EmployeeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee e where e.ServiceNo='"
								+ serviceNo + "'");
				int id = 0;
				List objectList = new ArrayList();
				String idqry = "SELECT max(empafmsfdet_id) FROM emp_afmsf_det";
				objectList = (List) session.createSQLQuery(idqry).list();

				if (objectList.get(0) != null) {
					id = 1 + Integer.parseInt("" + objectList.get(0));
				}

				if (EmployeeList.size() == 0) {
					List objectList2 = new ArrayList();
					String empCode = "";
					String eCode = "";
					int EMPid = 0;

					List objectList3 = new ArrayList();
					String EmpIdqry = "SELECT max(employee_id) FROM mas_employee e";
					objectList3 = (List) session.createSQLQuery(EmpIdqry)
							.list();
					if (objectList3.get(0) != null) {
						EMPid = 1 + Integer.parseInt("" + objectList3.get(0));
					}
					empCode = "E".concat(generateNumberForseq());

					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(EMPid);
					masEmployee.setEmployeeCode(empCode);
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					masEmployee.setHospital(masHospital);
					masEmployee.setFirstName(employeeName);
					masEmployee.setLastName(lastName);

					MasEmpStatus masEmpStatus = new MasEmpStatus();
					masEmpStatus.setId(1);
					masEmployee.setEmployeeStatus(masEmpStatus);

					masEmployee.setJoinDate(postingInDate);
					masEmployee.setStatus("n");
					masEmployee.setLastChgBy(changedBy);
					masEmployee.setLastChgDate(currentDateDate);
					masEmployee.setLastChgTime(currentTime);
					masEmployee.setServiceNo(serviceNo);

					MasRank masRank = new MasRank();
					masRank.setId(rankId);
					masEmployee.setRank(masRank);
					//masEmployee.setUnit(new MasUnit(presentUnit));
					//added by amit for unit
					masEmployee.setUnit(new MasUnit(Integer.parseInt(presentUnit)));
					MasTrade masTrade = new MasTrade();
					masTrade.setId(tradeId);
					masEmployee.setTrade(masTrade);
					hbt.save(masEmployee);
					hbt.refresh(masEmployee);

					empAfmsfDet.setEmployee(masEmployee);
				} else {
					MasEmployee masEmployee = (MasEmployee) EmployeeList.get(0);
					empAfmsfDet.setEmployee(masEmployee);
				}

				if (postedFromId != null && !postedFromId.equals("0")) {
					if (!postedFromId.equals("Other")) {
						empAfmsfDet.setPostedFrom(new MasUnit(Integer
								.parseInt(postedFromId)));
					} else if (postedFromId.equals("Other")) {
						Map<String, Object> tempmap = new HashMap<String, Object>();

						tempmap = unitTemp(unitName, unitAddress, localUnit,
								currentDateDate, currentTime, changedBy);
						MasUnit masunitObj = (MasUnit) tempmap
								.get("masUnitObj");
						empAfmsfDet.setPostedFrom(new MasUnit(masunitObj
								.getId()));
					}
				}

				//Added by amit as discussed with grijesh sir

				if (presentUnit != null && !presentUnit.equals("0")) {
						empAfmsfDet.setUnit(new MasUnit(Integer.parseInt(presentUnit)));

					} 


				if (postedToId != null && !postedToId.equals("0")) {
					if (!postedToId.equals("Other")) {
						empAfmsfDet.setPostedTo(new MasUnit(Integer
								.parseInt(postedToId)));
					} else if (postedToId.equals("Other")) {
						Map<String, Object> tempmap = new HashMap<String, Object>();
						tempmap = unitTemp(unitName, unitAddress, localUnit,
								currentDateDate, currentTime, changedBy);
						MasUnit masunitObj = (MasUnit) tempmap
								.get("masUnitObj");
						empAfmsfDet
								.setPostedTo(new MasUnit(masunitObj.getId()));
					}
				}

				if (presentUnit != 0)
					empAfmsfDet.setUnit(new MasUnit(presentUnit));

				if (rankId != 0)
					empAfmsfDet.setRank(new MasRank(rankId));

				if (tradeId != 0)
					empAfmsfDet.setTrade(new MasTrade(tradeId));

				if (hospitalId != 0)
					empAfmsfDet.setHospital(new MasHospital(hospitalId));

				if (status != null) {
					if (status.equals("arrival") || status.equals("receipt")) {
						empAfmsfDet.setAfmsfType("IN");
					} else if (status.equals("clearance")
							|| status.equals("dispatch")) {
						empAfmsfDet.setAfmsfType("OUT");
					}
				}
				if (docStatus != "" && docStatus != null)
					empAfmsfDet.setDocStatus(docStatus);

				if (receiptDate != null)
					empAfmsfDet.setRecDate(receiptDate);

				if (serviceNo != null && serviceNo !=""){
					empAfmsfDet.setServiceNo(serviceNo);
				}

				if (employeeName != null)
					empAfmsfDet.setEmpName(employeeName);

				if (lastName != null && !lastName.equals(""))
					empAfmsfDet.setEmpLastName(lastName);

				if (nextreviewdate != null)
					empAfmsfDet.setNextReview(nextreviewdate);

				if (diagnosis != null && !diagnosis.equals("")) {
					empAfmsfDet.setDiagnosis(diagnosis);
				}

				if (letterNo != "")
					empAfmsfDet.setLetterNo(letterNo);

				empAfmsfDet.setLastChgDate(currentDateDate);

				empAfmsfDet.setLastChgTime(currentTime);

				empAfmsfDet.setLastChgBy(changedBy);
				// empAfmsfDet.setFmsfDate(receiptDate);
				if (auth != "")
					empAfmsfDet.setAuthPosting(auth);
				empAfmsfDet.setStatus("y");

				if (remarks != "")
					empAfmsfDet.setRemarks(remarks);

				if (medicalCat != 0)
					empAfmsfDet.setMedicalCategory(new MasMedicalCategory(
							medicalCat));

				if (postingInDate != null)
					empAfmsfDet.setPostInDate(postingInDate);

				if (datePostingDate != null)
					empAfmsfDet.setPostOutDate(datePostingDate);

				if (authpostingOut != null)
					empAfmsfDet.setAuthPostOut(authpostingOut);

				if (disRemarks != null)
					empAfmsfDet.setDisRemarks(disRemarks);

				if (disletterNo != null)
					empAfmsfDet.setDisLetterNo(disletterNo);

				if (dispatchDate != null)
					empAfmsfDet.setDisDate(dispatchDate);

				if (suffix != "" && suffix != null)
					empAfmsfDet.setSuffix(suffix);
				hbt.save(empAfmsfDet);

	 * }catch (Exception e) {
	 * e.printStackTrace(); }

				dataUpdated = true;
			} else {
				empAfmsfDet = (EmpAfmsfDet) hbt.load(EmpAfmsfDet.class,
						empAfmsId);

				if (postedFromId != null && !postedFromId.equals("0")) {
					if (!postedFromId.equals("Other")) {
						empAfmsfDet.setPostedFrom(new MasUnit(Integer
								.parseInt(postedFromId)));
					} else if (postedFromId.equals("Other")) {
						Map<String, Object> tempmap = new HashMap<String, Object>();

						tempmap = unitTemp(unitName, unitAddress, localUnit,
								currentDateDate, currentTime, changedBy);
						MasUnit masunitObj = (MasUnit) tempmap
								.get("masUnitObj");
						empAfmsfDet.setPostedFrom(new MasUnit(masunitObj
								.getId()));
					}
				}

				if (postedToId != null && !postedToId.equals("0")) {
					if (!postedToId.equals("Other")) {
						empAfmsfDet.setPostedTo(new MasUnit(Integer
								.parseInt(postedToId)));
					} else if (postedToId.equals("Other")) {
						Map<String, Object> tempmap = new HashMap<String, Object>();
						tempmap = unitTemp(unitName, unitAddress, localUnit,
								currentDateDate, currentTime, changedBy);
						MasUnit masunitObj = (MasUnit) tempmap
								.get("masUnitObj");
						empAfmsfDet
								.setPostedTo(new MasUnit(masunitObj.getId()));
					}
				}
				if (presentUnit != 0)
					empAfmsfDet.setUnit(new MasUnit(presentUnit));

				if (rankId != 0)
					empAfmsfDet.setRank(new MasRank(rankId));

				if (tradeId != 0)
					empAfmsfDet.setTrade(new MasTrade(tradeId));

				if (hospitalId != 0)
					empAfmsfDet.setHospital(new MasHospital(hospitalId));

				if (status != null) {
					if (status.equals("arrival") || status.equals("receipt")) {
						empAfmsfDet.setAfmsfType("IN");
					} else if (status.equals("clearance")
							|| status.equals("dispatch")) {
						empAfmsfDet.setAfmsfType("OUT");
					}
				}

				if (docStatus != "" && docStatus != null) {
					empAfmsfDet.setDocStatus(docStatus);
				}

				if (receiptDate != null)
					empAfmsfDet.setRecDate(receiptDate);

				if (serviceNo != null && serviceNo != ""){
					empAfmsfDet.setServiceNo(serviceNo);
				}
				if (employeeName != null)
					empAfmsfDet.setEmpName(employeeName);

				if (lastName != null && !lastName.equals(""))
					empAfmsfDet.setEmpLastName(lastName);

				if (nextreviewdate != null)
					empAfmsfDet.setNextReview(nextreviewdate);

				if (diagnosis != null && !diagnosis.equals("")) {
					empAfmsfDet.setDiagnosis(diagnosis);
				}

				if (letterNo != "" && letterNo != null)
					empAfmsfDet.setLetterNo(letterNo);

				empAfmsfDet.setLastChgDate(currentDateDate);

				empAfmsfDet.setLastChgTime(currentTime);

				empAfmsfDet.setLastChgBy(changedBy);
				// empAfmsfDet.setFmsfDate(receiptDate);
				if (auth != "" && auth != null)
					empAfmsfDet.setAuthPosting(auth);

				empAfmsfDet.setStatus("y");

				if (remarks != "" && remarks != null)
					empAfmsfDet.setRemarks(remarks);

				if (medicalCat != 0)
					empAfmsfDet.setMedicalCategory(new MasMedicalCategory(
							medicalCat));

				if (postingInDate != null)
					empAfmsfDet.setPostInDate(postingInDate);

				if (datePostingDate != null)
					empAfmsfDet.setPostOutDate(datePostingDate);

				if (authpostingOut != null && authpostingOut != "")
					empAfmsfDet.setAuthPostOut(authpostingOut);

				if (disRemarks != null && disRemarks != "")
					empAfmsfDet.setDisRemarks(disRemarks);

				if (disletterNo != null && disletterNo != "")
					empAfmsfDet.setDisLetterNo(disletterNo);

				if (dispatchDate != null)
					empAfmsfDet.setDisDate(dispatchDate);

				if (suffix != "" && suffix != null)
					empAfmsfDet.setSuffix(suffix);

				hbt.update(empAfmsfDet);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return dataUpdated;
	}*/

	public boolean editAfmsfDef(Map<String, Object> generalMap) {
		Session session = (Session) getSession();
		boolean dataUpdated = false;
		String currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
		"currentTime");
		String changedBy = "";

		session = (Session) getSession();
		Transaction tx = null;
		String postedFromId = null;
		String postedToId = null;
		//int presentUnit = 0;
		String presentUnit = null;
		String auth = "";
		String remarks = "";
		int medicalCat = 0;
		int hospitalId = 0;
		int rankId = 0;
		int empId = 0;
		int tradeId = 0;
		String letterNo = "0";
		String status = "";
		String serviceNo = null;
		String datePostingIn = null;
		String datePostingOut = null;
		String employeeName = null;
		Date receiptDate = null;
		String docStatus = "";
		Date postingInDate = null;
		Date datePostingDate = null;
		String authpostingOut = null;
		String disRemarks = null;
		String disletterNo = null;
		Date dispatchDate = null;
		String suffix = "";
		String lastName = null;
		String unitName = null;
		String unitAddress = null;
		String localUnit = null;
		int bloodGroupId = 0;
		// Date dispatchdate =null;
		Date nextreviewdate = null;
		String diagnosis = null;

		String receiptStatusChg;
		int empAfmsId = 0;
		serviceNo = (String) generalMap.get("serviceNo");

		receiptDate = (Date) generalMap.get("receiptdate");

		employeeName = (String) generalMap.get("employeeName");
		empId = (Integer) generalMap.get("employeeId");
		rankId = (Integer) generalMap.get("rankId");
		letterNo = (String) generalMap.get("letterNo");
		currentDate = (String) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		changedBy = (String) generalMap.get("changedBy");
		hospitalId = (Integer) generalMap.get("hospitalId");
		// empafmsfdetId = (Integer) generalMap.get("empafmsfdetId");
		status = (String) generalMap.get("status");
		Date currentDateDate = HMSUtil
		.convertStringTypeDateToDateType(currentDate);
		auth = (String) generalMap.get("auth");
		remarks = (String) generalMap.get("remarks");
		medicalCat = (Integer) generalMap.get("medicalcategory");
		postedToId = (String) generalMap.get("postedToId");
		postedFromId = (String) generalMap.get("postedFromId");
		presentUnit = (String) generalMap.get("presentUnit");
		//presentUnit = (Integer) generalMap.get("presentUnit");
		empAfmsId = (Integer) generalMap.get("empAfmsId");
		tradeId = (Integer) generalMap.get("tradeId");
		datePostingIn = (String) generalMap.get("datePostingIn");
		datePostingOut = (String) generalMap.get("datePostingOut");
		authpostingOut = (String) generalMap.get("authpostingOut");
		disRemarks = (String) generalMap.get("disRemarks");
		disletterNo = (String) generalMap.get("disletterNo");
		dispatchDate = (Date) generalMap.get("dispatchdate");
		nextreviewdate = (Date) generalMap.get("nextreviewDate");
		docStatus = (String) generalMap.get("docStatus");
		//suffix = (String) generalMap.get("suffix");
		diagnosis = (String) generalMap.get("diagnosis");
		lastName = (String) generalMap.get("lastName");
		unitName = (String) generalMap.get("unitName");
		unitAddress = (String) generalMap.get("unitAddress");
		localUnit = (String) generalMap.get("localUnit");
		bloodGroupId = (Integer) generalMap.get("bloodGroupId");
		if (datePostingIn != null) {
			postingInDate = HMSUtil
			.convertStringTypeDateToDateType(datePostingIn);
		}

		if (datePostingOut != null) {
			datePostingDate = HMSUtil
			.convertStringTypeDateToDateType(datePostingOut);
		}

		/*if (dispatchDate != null) {
			// dispatchdate =
			// HMSUtil.convertStringTypeDateToDateType(dispatchDate);
		}*/

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			tx = session.beginTransaction();
			EmpAfmsfDet empAfmsfDet = new EmpAfmsfDet();
			if (empAfmsId == 0) {
				List<MasEmployee> EmployeeList = new ArrayList<MasEmployee>();
				EmployeeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee e where e.ServiceNo='"
						+ serviceNo + "'");
				int id = 0;
				List objectList = new ArrayList();
				String idqry = "SELECT max(empafmsfdet_id) FROM emp_afmsf_det";
				objectList = (List) session.createSQLQuery(idqry).list();

				if (objectList.get(0) != null) {
					id = 1 + Integer.parseInt("" + objectList.get(0));
				}

				if (EmployeeList.size() == 0) {
					List objectList2 = new ArrayList();
					String empCode = "";
					String eCode = "";
					int EMPid = 0;

					List objectList3 = new ArrayList();
					String EmpIdqry = "SELECT max(employee_id) FROM mas_employee e";
					objectList3 = (List) session.createSQLQuery(EmpIdqry)
					.list();
					if (objectList3.get(0) != null) {
						EMPid = 1 + Integer.parseInt("" + objectList3.get(0));
					}
					empCode = "E".concat(generateNumberForseq(hospitalId));

					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(EMPid);
					masEmployee.setEmployeeCode(empCode);
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					masEmployee.setHospital(masHospital);
					masEmployee.setFirstName(employeeName);
					masEmployee.setLastName(lastName);

					MasEmpStatus masEmpStatus = new MasEmpStatus();
					masEmpStatus.setId(1);
					masEmployee.setEmployeeStatus(masEmpStatus);

					masEmployee.setJoinDate(postingInDate);
					masEmployee.setStatus("n");
					masEmployee.setLastChgBy(changedBy);
					masEmployee.setLastChgDate(currentDateDate);
					masEmployee.setLastChgTime(currentTime);
					masEmployee.setServiceNo(serviceNo);

					MasRank masRank = new MasRank();
					masRank.setId(rankId);
					masEmployee.setRank(masRank);
					//masEmployee.setUnit(new MasUnit(presentUnit));
					//added by amit for unit
					masEmployee.setUnit(new MasUnit(Integer.parseInt(presentUnit)));
					MasTrade masTrade = new MasTrade();
					masTrade.setId(tradeId);
					masEmployee.setTrade(masTrade);

					if(bloodGroupId!=0){
						MasBloodGroup bloodGroup = new MasBloodGroup();
						bloodGroup.setId(bloodGroupId);
						masEmployee.setBloodGroup(bloodGroup);
					}


					hbt.save(masEmployee);
					hbt.refresh(masEmployee);


					empAfmsfDet.setEmployee(masEmployee);
				} else {
					MasEmployee masEmployee = (MasEmployee) EmployeeList.get(0);
					empAfmsfDet.setEmployee(masEmployee);
				}

				if (postedFromId != null && !postedFromId.equals("0")) {
					if (!postedFromId.equals("Other")) {
						empAfmsfDet.setPostedFrom(new MasUnit(Integer
								.parseInt(postedFromId)));
					} else if (postedFromId.equals("Other")) {
						Map<String, Object> tempmap = new HashMap<String, Object>();

						tempmap = unitTemp(unitName, unitAddress, localUnit,
								currentDateDate, currentTime, changedBy);
						MasUnit masunitObj = (MasUnit) tempmap
						.get("masUnitObj");
						empAfmsfDet.setPostedFrom(new MasUnit(masunitObj
								.getId()));
					}
				}

				//Added by amit as discussed with grijesh sir

				if (presentUnit != null && !presentUnit.equals("0")) {
					empAfmsfDet.setUnit(new MasUnit(Integer.parseInt(presentUnit)));

				} 


				if (postedToId != null && !postedToId.equals("0")) {
					if (!postedToId.equals("Other")) {
						empAfmsfDet.setPostedTo(new MasUnit(Integer
								.parseInt(postedToId)));
					} else if (postedToId.equals("Other")) {
						Map<String, Object> tempmap = new HashMap<String, Object>();
						tempmap = unitTemp(unitName, unitAddress, localUnit,
								currentDateDate, currentTime, changedBy);
						MasUnit masunitObj = (MasUnit) tempmap
						.get("masUnitObj");
						empAfmsfDet
						.setPostedTo(new MasUnit(masunitObj.getId()));
					}
				}

				/*if (presentUnit != 0)
					empAfmsfDet.setUnit(new MasUnit(presentUnit));*/

				if (rankId != 0)
					empAfmsfDet.setRank(new MasRank(rankId));

				if (tradeId != 0)
					empAfmsfDet.setTrade(new MasTrade(tradeId));

				if (hospitalId != 0)
					empAfmsfDet.setHospital(new MasHospital(hospitalId));

				if (status != null) {
					if (status.equals("arrival") || status.equals("receipt")) {
						empAfmsfDet.setAfmsfType("IN");
					} else if (status.equals("clearance")
							|| status.equals("dispatch")) {
						empAfmsfDet.setAfmsfType("OUT");
					}
				}
				if (docStatus != "" && docStatus != null)
					empAfmsfDet.setDocStatus(docStatus);

				if (receiptDate != null)
					empAfmsfDet.setRecDate(receiptDate);

				if (serviceNo != null && serviceNo !=""){
					empAfmsfDet.setServiceNo(serviceNo);
				}

				if (employeeName != null)
					empAfmsfDet.setEmpName(employeeName);

				if (lastName != null && !lastName.equals(""))
					empAfmsfDet.setEmpLastName(lastName);

				if (nextreviewdate != null)
					empAfmsfDet.setNextReview(nextreviewdate);

				if (diagnosis != null && !diagnosis.equals("")) {
					empAfmsfDet.setDiagnosis(diagnosis);
				}

				if (letterNo != "")
					empAfmsfDet.setLetterNo(letterNo);

				empAfmsfDet.setLastChgDate(currentDateDate);

				empAfmsfDet.setLastChgTime(currentTime);

				empAfmsfDet.setLastChgBy(changedBy);
				// empAfmsfDet.setFmsfDate(receiptDate);
				if (auth != "")
					empAfmsfDet.setAuthPosting(auth);

				empAfmsfDet.setStatus("y");

				if (remarks != "")
					empAfmsfDet.setRemarks(remarks);

				if (medicalCat != 0)
					empAfmsfDet.setMedicalCategory(new MasMedicalCategory(
							medicalCat));

				if (postingInDate != null)
					empAfmsfDet.setPostInDate(postingInDate);

				if (datePostingDate != null)
					empAfmsfDet.setPostOutDate(datePostingDate);

				if (authpostingOut != null)
					empAfmsfDet.setAuthPostOut(authpostingOut);

				if (disRemarks != null)
					empAfmsfDet.setDisRemarks(disRemarks);

				if (disletterNo != null)
					empAfmsfDet.setDisLetterNo(disletterNo);

				if (dispatchDate != null)
					empAfmsfDet.setDisDate(dispatchDate);
				if (generalMap.get("docReceived") != null){
					empAfmsfDet.setDocumentReceived((String)generalMap.get("docReceived"));
				}
				String amaArrival="";
				if(generalMap.get("amaArrival") !=null){
					amaArrival=(String)generalMap.get("amaArrival");
				}
				if (generalMap.get("amaArrival") != null){
					empAfmsfDet.setAmaArrival(amaArrival);
				}
				String amaClear="";
				if(generalMap.get("amaClear") !=null){
					amaClear=(String)generalMap.get("amaClear");
				}
				if (generalMap.get("amaClear") != null){
					empAfmsfDet.setAmaClear(amaClear);
				}
				/*if (suffix != "" && suffix != null)
					empAfmsfDet.setSuffix(suffix);*/
				hbt.save(empAfmsfDet);
				/*
				 * }catch (Exception e) {
				 * e.printStackTrace(); }
				 */
				dataUpdated = true;
			} else {
				empAfmsfDet = (EmpAfmsfDet) hbt.load(EmpAfmsfDet.class,
						empAfmsId);

				if (postedFromId != null && !postedFromId.equals("0")) {
					if (!postedFromId.equals("Other")) {
						empAfmsfDet.setPostedFrom(new MasUnit(Integer
								.parseInt(postedFromId)));
					} else if (postedFromId.equals("Other")) {
						Map<String, Object> tempmap = new HashMap<String, Object>();

						tempmap = unitTemp(unitName, unitAddress, localUnit,
								currentDateDate, currentTime, changedBy);
						MasUnit masunitObj = (MasUnit) tempmap
						.get("masUnitObj");
						empAfmsfDet.setPostedFrom(new MasUnit(masunitObj
								.getId()));
					}
				}

				if (postedToId != null && !postedToId.equals("0")) {
					if (!postedToId.equals("Other")) {
						empAfmsfDet.setPostedTo(new MasUnit(Integer
								.parseInt(postedToId)));
					} else if (postedToId.equals("Other")) {
						Map<String, Object> tempmap = new HashMap<String, Object>();
						tempmap = unitTemp(unitName, unitAddress, localUnit,
								currentDateDate, currentTime, changedBy);
						MasUnit masunitObj = (MasUnit) tempmap
						.get("masUnitObj");
						empAfmsfDet
						.setPostedTo(new MasUnit(masunitObj.getId()));
					}
				}
				/*if (presentUnit != 0)
					empAfmsfDet.setUnit(new MasUnit(presentUnit));*/

				if (rankId != 0)
					empAfmsfDet.setRank(new MasRank(rankId));

				if (tradeId != 0)
					empAfmsfDet.setTrade(new MasTrade(tradeId));

				if (hospitalId != 0)
					empAfmsfDet.setHospital(new MasHospital(hospitalId));

				if (status != null) {
					if (status.equals("arrival") || status.equals("receipt")) {
						empAfmsfDet.setAfmsfType("IN");
					} else if (status.equals("clearance")
							|| status.equals("dispatch")) {
						empAfmsfDet.setAfmsfType("OUT");
					}
				}

				if (docStatus != "" && docStatus != null) {
					empAfmsfDet.setDocStatus(docStatus);
				}

				if (receiptDate != null)
					empAfmsfDet.setRecDate(receiptDate);

				if (serviceNo != null && serviceNo != ""){
					empAfmsfDet.setServiceNo(serviceNo);
				}
				if (employeeName != null)
					empAfmsfDet.setEmpName(employeeName);

				if (lastName != null && !lastName.equals(""))
					empAfmsfDet.setEmpLastName(lastName);

				if (nextreviewdate != null)
					empAfmsfDet.setNextReview(nextreviewdate);

				if (diagnosis != null && !diagnosis.equals("")) {
					empAfmsfDet.setDiagnosis(diagnosis);
				}

				if (letterNo != "" && letterNo != null)
					empAfmsfDet.setLetterNo(letterNo);

				empAfmsfDet.setLastChgDate(currentDateDate);

				empAfmsfDet.setLastChgTime(currentTime);

				empAfmsfDet.setLastChgBy(changedBy);
				// empAfmsfDet.setFmsfDate(receiptDate);
				if (auth != "" && auth != null)
					empAfmsfDet.setAuthPosting(auth);

				empAfmsfDet.setStatus("y");

				if (remarks != "" && remarks != null)
					empAfmsfDet.setRemarks(remarks);

				if (medicalCat != 0)
					empAfmsfDet.setMedicalCategory(new MasMedicalCategory(
							medicalCat));

				if (postingInDate != null)
					empAfmsfDet.setPostInDate(postingInDate);

				if (datePostingDate != null)
					empAfmsfDet.setPostOutDate(datePostingDate);

				if (authpostingOut != null && authpostingOut != "")
					empAfmsfDet.setAuthPostOut(authpostingOut);

				if (disRemarks != null && disRemarks != "")
					empAfmsfDet.setDisRemarks(disRemarks);

				if (disletterNo != null && disletterNo != "")
					empAfmsfDet.setDisLetterNo(disletterNo);

				if (dispatchDate != null)
					empAfmsfDet.setDisDate(dispatchDate);

				/*if (suffix != "" && suffix != null)
					empAfmsfDet.setSuffix(suffix);*/
				String amaArrival="";
				if(generalMap.get("amaArrival") !=null){
					amaArrival=(String)generalMap.get("amaArrival");
				}
				if (amaArrival != null && amaArrival !=""){
					empAfmsfDet.setAmaArrival(amaArrival);
				}
				hbt.update(empAfmsfDet);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public Map<String, Object> unitTemp(String uName, String uAddress,
			String lUnit, Date crDate, String crTime, String chby) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> masTradeList = new ArrayList<MasTrade>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		MasUnit masUnitObj = new MasUnit();
		if (uName != null) {

			StringBuffer output_str1 = new StringBuffer();
			StringTokenizer s1 = new StringTokenizer(uName + "", "\'");

			while (s1.hasMoreTokens()) {
				output_str1.append(s1.nextToken());
				if (s1.hasMoreTokens()) {
					output_str1.append(" ");
				}
			}

			StringBuffer output_str2 = new StringBuffer();
			StringTokenizer s2 = new StringTokenizer(output_str1 + "", "\"");

			while (s2.hasMoreTokens()) {
				output_str2.append(s2.nextToken());
				if (s2.hasMoreTokens()) {
					output_str2.append(" ");
				}
			}
			masUnitObj.setUnitName("" + output_str2);
		}
		if (uAddress != null) {

			StringBuffer output_str3 = new StringBuffer();
			StringTokenizer s3 = new StringTokenizer(uAddress + "", "\'");

			while (s3.hasMoreTokens()) {
				output_str3.append(s3.nextToken());
				if (s3.hasMoreTokens()) {
					output_str3.append(" ");
				}
			}

			StringBuffer output_str4 = new StringBuffer();
			StringTokenizer s4 = new StringTokenizer(output_str3 + "", "\"");

			while (s4.hasMoreTokens()) {
				output_str4.append(s4.nextToken());
				if (s4.hasMoreTokens()) {
					output_str4.append(" ");
				}
			}
			masUnitObj.setUnitAddress("" + output_str4);
		}
		if (lUnit != null) {
			masUnitObj.setLocalUnit("y");
		} else {
			masUnitObj.setLocalUnit("n");
		}
		masUnitObj.setLastChgDate(crDate);
		masUnitObj.setLastChgTime(crTime);
		masUnitObj.setLastChgBy(chby);
		masUnitObj.setStatus("t");
		hbt.save(masUnitObj);
		map.put("masUnitObj", masUnitObj);
		return map;
	}

	/**
	 * Surplus AFMSF-1 is a screen used for displaying and updating records.
	 * Fetching records from two tables: 1)MasEmployee:- When there are no
	 * records in the EmpAfmsfDet table and the receipt status is 'No' selected
	 * in the form. 2)EmpAfmsfDet:- when there are records present in
	 * EmpAfmsfDet, and the receipt status selected is 'YES' in the form.
	 */

	// --------------------------- Afmsf-1 Surplus
	// -------------------------------

	public Map<String, Object> showAfmsfSurplusjsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> masTradeList = new ArrayList<MasTrade>();

		try {
			masTradeList = session.createCriteria(MasTrade.class).add(
					Restrictions.eq("Status", "y")).list();
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("masTradeList", masTradeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);

		return map;
	}

	public Map<String, Object> showAfmsfSurplus(Map<String, Object> generalMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		String serviceNo = null;
		String queryString = null;
		List<MasTrade> masTradeList = new ArrayList<MasTrade>();
		try {
			serviceNo = (String) generalMap.get("serviceNo");

			queryString = "from MasEmployee where ServiceNo=" + serviceNo;
			employeeList = getHibernateTemplate().find(queryString);

			queryString = "from EmpAfmsfDet ead where ServiceNo='" + serviceNo
			+ "' group by ead.EmpName";
			empAfmsfDetList = getHibernateTemplate().find(queryString);
			masTradeList = session.createCriteria(MasTrade.class).add(
					Restrictions.eq("Status", "y")).list();
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("empAfmsfDetList", empAfmsfDetList);
		map.put("employeeList", employeeList);
		map.put("serviceNo", serviceNo);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("masTradeList", masTradeList);
		return map;
	}

	/**
	 * editAfmsfSurplus()is used for:- 1) if fetching records from MasEmployee
	 * then enter a new record in EmpAfmsfDet table. 2) else, it is fetching
	 * records from the EmpAfmsfDet table, then update the selected record in
	 * EmpAfmsfDet table. Surplus Status is set to 'S'
	 */

	public boolean editAfmsfSurplus(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
		"currentTime");
		String changedBy = "";
		int postedFromId = 0;
		int postedToId = 0;
		String description = "";
		String medicalCat = "";
		int hospitalId = 0;
		int rankId = 0;
		int empId = 0;
		int tradeId = 0;
		String letterNo = "0";
		String status = "";
		String serviceNo = null;

		String employeeName = null;
		Date receiptDate = null;

		String receiptStatusChg;
		int empAfmsId = 0;
		serviceNo = (String) generalMap.get("serviceNo");
		receiptDate = (Date) generalMap.get("receiptDate");

		employeeName = (String) generalMap.get("employeeName");
		empId = (Integer) generalMap.get("employeeId");
		rankId = (Integer) generalMap.get("rankId");
		letterNo = (String) generalMap.get("letterNo");

		currentDate = (String) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		changedBy = (String) generalMap.get("changedBy");
		hospitalId = (Integer) generalMap.get("hospitalId");
		// empafmsfdetId = (Integer) generalMap.get("empafmsfdetId");
		status = (String) generalMap.get("status");
		Date currentDateDate = HMSUtil
		.convertStringTypeDateToDateType(currentDate);
		description = (String) generalMap.get("description");
		medicalCat = (String) generalMap.get("medicalCat");
		postedToId = (Integer) generalMap.get("postedToId");
		postedFromId = (Integer) generalMap.get("postedFromId");
		empAfmsId = (Integer) generalMap.get("empAfmsId");
		tradeId = (Integer) generalMap.get("tradeId");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			if (empAfmsId == 0) {
				EmpAfmsfDet empAfmsfDet = new EmpAfmsfDet();
				if (empId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(empId);
					empAfmsfDet.setEmployee(masEmployee);
				}
				if (postedFromId != 0) {
					MasUnit masUnit = new MasUnit();
					masUnit.setId(postedFromId);
					empAfmsfDet.setUnit(masUnit);
				}
				if (postedToId != 0)
					empAfmsfDet.setPostedTo(new MasUnit(postedToId));
				if (rankId != 0)
					empAfmsfDet.setRank(new MasRank(rankId));

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				empAfmsfDet.setHospital(masHospital);

				empAfmsfDet.setAfmsfType("D");
				empAfmsfDet.setDocStatus("y");
				empAfmsfDet.setVideWithDate(receiptDate);
				empAfmsfDet.setServiceNo(serviceNo);
				empAfmsfDet.setEmpName(employeeName);
				empAfmsfDet.setLetterNo(letterNo);

				empAfmsfDet.setLastChgDate(currentDateDate);
				empAfmsfDet.setLastChgTime(currentTime);
				empAfmsfDet.setLastChgBy(changedBy);
				empAfmsfDet.setFmsfDate(receiptDate);
				empAfmsfDet.setAuthPosting(description);
				empAfmsfDet.setStatus(status);
				if (tradeId != 0)
					empAfmsfDet.setTrade(new MasTrade(tradeId));
				hbt.save(empAfmsfDet);
				dataUpdated = true;
			} else {
				EmpAfmsfDet empAfmsfDet = (EmpAfmsfDet) hbt.load(
						EmpAfmsfDet.class, empAfmsId);
				empAfmsfDet.setStatus(status);
				hbt.update(empAfmsfDet);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	/**
	 * Surplus AFMSF-1 is a screen used for displaying and updating records.
	 * Fetching records from two tables: 1)MasEmployee:- When there are no
	 * records in the EmpAfmsfDet table and the receipt status is 'No' selected
	 * in the form. 2)EmpAfmsfDet:- when there are records present in
	 * EmpAfmsfDet, and the receipt status selected is 'YES' in the form.
	 */

	/**
	 * ------------------------------- Afmsf-1 AnnualMedicalExamination
	 * -------------------------------*
	 */

	public Map<String, Object> showAfmsfAnnualMedicalExaminationjsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MisAnnualMedicalExam> annualMedicalExamList = new ArrayList<MisAnnualMedicalExam>();

		try {
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			annualMedicalExamList = session.createCriteria(
					MisAnnualMedicalExam.class).add(
							Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("annualMedicalExamList", annualMedicalExamList);

		return map;
	}

	public Map<String, Object> getMedicalCategory() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasMedicalCategory> masMedicalCategoryList = new ArrayList<MasMedicalCategory>();


		try {
			masMedicalCategoryList = session.createCriteria(MasMedicalCategory.class).add(
					Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("masMedicalCategoryList", masMedicalCategoryList);
		return map;
	}

	public Map<String, Object> showAfmsfAnnualMedicalExamination(
			String serviceNo) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<EmpAfmsfDet> showList = new ArrayList<EmpAfmsfDet>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MisAnnualMedicalExam> annualMedicalExamList = new ArrayList<MisAnnualMedicalExam>();

		try {

			showList = getHibernateTemplate()
			.find(
					"from jkt.hms.masters.business.EmpAfmsfDet as e where e.AfmsfType='M' and e.ServiceNo='"
					+ serviceNo + "'");

			// if (showList.size() == 0) {
			// employeeList = getHibernateTemplate().find(
			// "from MasEmployee me where me.Id not in (select e.Employee from EmpAfmsfDet e where e.AfmsfType='M')) and me.ServiceNo='"+serviceNo+"'");
			employeeList = getHibernateTemplate().find(
					"from MasEmployee me where me.ServiceNo='" + serviceNo
					+ "'");
			rankList = session.createCriteria(MasRank.class).add(
					Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();
			annualMedicalExamList = session.createCriteria(
					MisAnnualMedicalExam.class).add(
							Restrictions.eq("Status", "y")).list();
			// }

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("annualMedicalExamList", annualMedicalExamList);
		map.put("showList", showList);
		map.put("employeeList", employeeList);
		map.put("serviceNo", serviceNo);
		return map;

	}

	/**
	 * editAfmsfSurplus()is used for:- 1) if fetching records from MasEmployee
	 * then enter a new record in EmpAfmsfDet table. 2) else, it is fetching
	 * records from the EmpAfmsfDet table, then update the selected record in
	 * EmpAfmsfDet table. Surplus Status is set to 'S'
	 */
	public Map<String, Object> editAfmsfAnnualMedicalExamination(Map<String, Object> generalMap,Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		String message = "";
		String messageType = "";
		String currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String changedBy = "";
		int recordcount = box.getInt("hdb"); 
		@SuppressWarnings("unused")
		int categoryId = 0;
		int empAfmsfDetId=0;
		String period = "";
		int ameId =0;
		Date nextReviewDateDate =null;
		Date ameDateDate = null;
		ameId = Integer.parseInt(""+generalMap.get("ameId"));
		categoryId = Integer.parseInt(""+generalMap.get("categoryId"));
		period = (String) generalMap.get("period");
		if( generalMap.get("ameDate") !=null && !generalMap.get("ameDate").equals("")){
			ameDateDate = HMSUtil.convertStringTypeDateToDateType(""+generalMap.get("ameDate"));
		}
		if(  generalMap.get("nextReviewDate") !=null && !generalMap.get("nextReviewDate").equals("")){
			nextReviewDateDate = HMSUtil.convertStringTypeDateToDateType(""+generalMap.get("nextReviewDate"));
		}
		currentDate = (String) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		changedBy = (String) generalMap.get("changedBy");
		empAfmsfDetId = Integer.parseInt(""+generalMap.get("empAfmsfDetId"));
		Date currentDateDate = HMSUtil.convertStringTypeDateToDateType(currentDate);
		Session session=(Session) getSession();
		Transaction transaction =null;
		try {
			transaction =session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if(ameId == 0){
				AnnualMediacalExamination annualMediacalExamination = new AnnualMediacalExamination();
				annualMediacalExamination.setNextReview(nextReviewDateDate);
				annualMediacalExamination.setLastBoard(ameDateDate);
				annualMediacalExamination.setAfmsfDet(new EmpAfmsfDet(empAfmsfDetId));
				annualMediacalExamination.setLastChgBy(changedBy);
				annualMediacalExamination.setLastChgDate(currentDateDate);
				annualMediacalExamination.setLastChgTime(currentTime);
				annualMediacalExamination.setStatus("y");
				annualMediacalExamination.setPeriod(period);
				if(!box.get("dduration").equals("") )
					annualMediacalExamination.setDuration(box.get("dduration"));

				if(!box.get("categoryId").equals(""))
					annualMediacalExamination.setCategory(new MasMedicalCategory(box.getInt("categoryId")));

				if(!box.get("newUnitId").equals("") )
					annualMediacalExamination.setLastBoardAt(new MasUnit(box.getInt("newUnitId")));

				try {
					hbt.save(annualMediacalExamination);
					hbt.refresh(annualMediacalExamination);
				} catch (RuntimeException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(empAfmsfDetId >0 ){
					EmpAfmsfDet empAfmsfDet =(EmpAfmsfDet)hbt.load(EmpAfmsfDet.class, empAfmsfDetId); 
					empAfmsfDet.setMedicalCategory(new MasMedicalCategory(box.getInt("categoryId")));
					hbt.update(empAfmsfDet);
				}


				AmeLmcHeader ameLmeHeader  =  new AmeLmcHeader();
				if( !box.getString("fwdLetterNo").equals("")){
					ameLmeHeader.setFwdLetterNo(box.getString("fwdLetterNo"));
				}
				if( !box.get("fwdLetterDate").equals("")){
					ameLmeHeader.setFwdLetterDate(HMSUtil.convertStringTypeDateToDateType(box.get("fwdLetterDate")));
				}
				if( !box.getString("recLetterNo").equals("")){
					ameLmeHeader.setReceiptLetterNo(box.getString("recLetterNo"));
				}
				if( !box.get("recLetterDate").equals("")){
					ameLmeHeader.setReceiptLetterDate(HMSUtil.convertStringTypeDateToDateType(box.get("recLetterDate")));
				}
				if(!box.get("remarks").equals("")){
					ameLmeHeader.setRemarks(box.getString("remarks"));
				}
				ameLmeHeader.setStatus("y");
				ameLmeHeader.setAme(annualMediacalExamination);
				try {
					hbt.save(ameLmeHeader);
				} catch (RuntimeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if(recordcount > 0 && ameId > 0){
					String hql = "delete from jkt.hms.masters.business.AmeLmc as a where a.Ame.Id ="+ameId;
					Query query = session.createQuery(hql);
					int row = query.executeUpdate();
				}

				for(int i=1; i <= recordcount;i++){
					AmeLmc ameLmc = new AmeLmc();
					if(!box.get("disabilityName"+i).equals("") || box.getInt("dcategory"+i)!=0
							||	!box.get("dduration"+i).equals("") || !box.get("permtemp"+i).equals("0")
							|| !box.get("dNextReview"+i).equals("") || !box.get("EmpRestriction"+i).equals("")){
						ameLmc.setDisabilityName(box.get("disabilityName"+i));

						if(box.getInt("dcategory"+i)!=0 ){
							ameLmc.setCategory(new MasMedicalCategory(box.getInt("dcategory"+i)));
						}

						ameLmc.setDuration(box.get("dduration"+i));
						ameLmc.setPermTemp(box.get("permtemp"+i));

						if(box.get("dNextReview"+i)!=null && !box.get("dNextReview"+i).equals("")){
							ameLmc.setDateOfNrv(HMSUtil.convertStringTypeDateToDateType(box.get("dNextReview"+i)));
						}
						ameLmc.setEmpRestriction(box.get("EmpRestriction"+i));
						ameLmc.setLmcHeaderId(ameLmeHeader);
						try {
							hbt.save(ameLmc);
							hbt.refresh(ameLmc);
						} catch (RuntimeException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}else{
				AnnualMediacalExamination annualMediacalExamination = (AnnualMediacalExamination) hbt.load(AnnualMediacalExamination.class, ameId);
				annualMediacalExamination.setNextReview(nextReviewDateDate);
				annualMediacalExamination.setLastBoard(ameDateDate);
				//annualMediacalExamination.setAfmsfDet(new EmpAfmsfDet(empAfmsfDetId));
				annualMediacalExamination.setLastChgBy(changedBy);
				annualMediacalExamination.setLastChgDate(currentDateDate);
				annualMediacalExamination.setLastChgTime(currentTime);
				annualMediacalExamination.setStatus("y");
				annualMediacalExamination.setPeriod(period);
				if(!box.get("dduration").equals("") )
					annualMediacalExamination.setDuration(box.get("dduration"));
				if(!box.get("categoryId").equals("")) 
					annualMediacalExamination.setCategory(new MasMedicalCategory(box.getInt("categoryId")));

				hbt.update(annualMediacalExamination);
				if(empAfmsfDetId >0 ){
					EmpAfmsfDet empAfmsfDet =(EmpAfmsfDet)hbt.load(EmpAfmsfDet.class, empAfmsfDetId); 
					empAfmsfDet.setMedicalCategory(new MasMedicalCategory(box.getInt("categoryId")));
					hbt.update(empAfmsfDet);
				}

				List<AmeLmcHeader> ameLmeHList = new ArrayList<AmeLmcHeader>();

				ameLmeHList = session.createCriteria(AmeLmcHeader.class).add(Restrictions.eq("Ame.Id", ameId))
				.add(Restrictions.eq("Status", "y")).list();
				AmeLmcHeader ameLmeHeader  =  new AmeLmcHeader();
				if(ameLmeHList.size() == 0){
					if( !box.getString("fwdLetterNo").equals("")){
						ameLmeHeader.setFwdLetterNo(box.getString("fwdLetterNo"));
					}
					if( !box.get("fwdLetterDate").equals("")){
						ameLmeHeader.setFwdLetterDate(HMSUtil.convertStringTypeDateToDateType(box.get("fwdLetterDate")));
					}
					if( !box.getString("recLetterNo").equals("")){
						ameLmeHeader.setReceiptLetterNo(box.getString("recLetterNo"));
					}
					if(!box.get("recLetterDate").equals("")){
						ameLmeHeader.setReceiptLetterDate(HMSUtil.convertStringTypeDateToDateType(box.get("recLetterDate")));
					}
					if(!box.get("remarks").equals("")){
						ameLmeHeader.setRemarks(box.getString("remarks"));
					}
					ameLmeHeader.setStatus("y");
					ameLmeHeader.setAme(annualMediacalExamination);
					try {
						hbt.save(ameLmeHeader);
						hbt.refresh(ameLmeHeader);
					} catch (RuntimeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					ameLmeHeader = (AmeLmcHeader) ameLmeHList.get(0);
					if(!box.get("fwdLetterNo").equals("")){
						ameLmeHeader.setFwdLetterNo(box.getString("fwdLetterNo"));
					}
					if(!box.get("fwdLetterDate").equals("")){
						ameLmeHeader.setFwdLetterDate(HMSUtil.convertStringTypeDateToDateType(box.get("fwdLetterDate")));
					}
					if( !box.getString("recLetterNo").equals("")){
						ameLmeHeader.setReceiptLetterNo(box.getString("recLetterNo"));
					}
					if( !box.get("recLetterDate").equals("")){
						ameLmeHeader.setReceiptLetterDate(HMSUtil.convertStringTypeDateToDateType(box.get("recLetterDate")));
					}
					if(!box.get("remarks").equals("")){
						ameLmeHeader.setRemarks(box.getString("remarks"));
					}
					try {
						hbt.update(ameLmeHeader);
						hbt.refresh(ameLmeHeader);
					} catch (RuntimeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if(recordcount > 0){
					String hql = "";
					if(ameLmeHList.size() > 0){
						int ameH = ameLmeHList.get(0).getId();
						hql = "delete from jkt.hms.masters.business.AmeLmc as a where a.LmcHeaderId.Id ="+ameH;
						Query query = session.createQuery(hql);
						int row = query.executeUpdate();
					}
				}
				for(int i=1; i <= recordcount;i++){
					AmeLmc ameLmc = new AmeLmc();
					if(!box.get("disabilityName"+i).equals("") || box.getInt("dcategory"+i)!=0
							||	!box.get("dduration"+i).equals("") || !box.get("permtemp"+i).equals("0")
							|| !box.get("dNextReview"+i).equals("") || !box.get("EmpRestriction"+i).equals("")){
						ameLmc.setDisabilityName(box.get("disabilityName"+i));

						if(box.getInt("dcategory"+i)!=0 ){
							ameLmc.setCategory(new MasMedicalCategory(box.getInt("dcategory"+i)));
						}

						ameLmc.setDuration(box.get("dduration"+i));
						ameLmc.setPermTemp(box.get("permtemp"+i));

						if(box.get("dNextReview"+i)!=null && !box.get("dNextReview"+i).equals("")){
							ameLmc.setDateOfNrv(HMSUtil.convertStringTypeDateToDateType(box.get("dNextReview"+i)));
						}
						ameLmc.setEmpRestriction(box.get("EmpRestriction"+i));
						ameLmc.setLmcHeaderId(ameLmeHeader);
						try {
							hbt.save(ameLmc);
							hbt.refresh(ameLmc);
						} catch (RuntimeException e) {
							e.printStackTrace();
						}
					}				
				}
			}

			transaction.commit();
			saved = true;
			//message = "Data saved successfully !!  Do you want to print ?";
			messageType = "success";
		} catch (Exception e) {
			if(transaction !=null)transaction.rollback();
			//message = "Some problem occurred";
			messageType = "failure";
			e.printStackTrace();
		}
		map.put("saved",saved);
		map.put("messageType",messageType);
		return map;
	}

	/*public Map<String, Object> editAfmsfAnnualMedicalExamination(Map<String, Object> generalMap,Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String message = "";
		String messageType = "";
		String currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String changedBy = "";
		int recordcount = box.getInt("hdb"); 
		@SuppressWarnings("unused")
		int categoryId = 0;
		int empAfmsfDetId=0;
		String period = "";
		int ameId =0;
		Date nextReviewDateDate =null;
		Date ameDateDate = null;
		ameId = Integer.parseInt(""+generalMap.get("ameId"));
		categoryId = Integer.parseInt(""+generalMap.get("categoryId"));
		period = (String) generalMap.get("period");
		if( generalMap.get("ameDate") !=null){
			ameDateDate = HMSUtil.convertStringTypeDateToDateType(""+generalMap.get("ameDate"));
		}
		if(  generalMap.get("nextReviewDate") !=null){
			nextReviewDateDate = HMSUtil.convertStringTypeDateToDateType(""+generalMap.get("nextReviewDate"));
		}
		currentDate = (String) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		changedBy = (String) generalMap.get("changedBy");
		empAfmsfDetId = Integer.parseInt(""+generalMap.get("empAfmsfDetId"));
		Date currentDateDate = HMSUtil.convertStringTypeDateToDateType(currentDate);
		Session session=(Session) getSession();
		Transaction transaction =null;
		try {
			transaction =session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if(ameId == 0){
				AnnualMediacalExamination annualMediacalExamination = new AnnualMediacalExamination();
				annualMediacalExamination.setNextReview(nextReviewDateDate);
				annualMediacalExamination.setLastBoard(ameDateDate);
				annualMediacalExamination.setAfmsfDet(new EmpAfmsfDet(empAfmsfDetId));
				annualMediacalExamination.setLastChgBy(changedBy);
				annualMediacalExamination.setLastChgDate(currentDateDate);
				annualMediacalExamination.setLastChgTime(currentTime);
				annualMediacalExamination.setStatus("y");
				annualMediacalExamination.setPeriod(period);
				if(!box.get("dduration").equals(""))
					annualMediacalExamination.setDuration(box.get("dduration"));
				if(!box.get("categoryId").equals(""))
					annualMediacalExamination.setCategory(new MasMedicalCategory(box.getInt("categoryId")));

				if(!box.get("newUnitId").equals(""))
					annualMediacalExamination.setLastBoardAt(new MasUnit(box.getInt("newUnitId")));
				hbt.save(annualMediacalExamination);
				hbt.refresh(annualMediacalExamination);
				if(empAfmsfDetId >0 ){
					EmpAfmsfDet empAfmsfDet =(EmpAfmsfDet)hbt.load(EmpAfmsfDet.class, empAfmsfDetId); 
					empAfmsfDet.setMedicalCategory(new MasMedicalCategory(box.getInt("categoryId")));
					hbt.update(empAfmsfDet);
				}


				AmeLmcHeader ameLmeHeader  =  new AmeLmcHeader();
				ameLmeHeader.setFwdLetterNo(box.getString("fwdLetterNo"));
				ameLmeHeader.setFwdLetterDate(HMSUtil.convertStringTypeDateToDateType(box.get("fwdLetterDate")));
				ameLmeHeader.setReceiptLetterNo(box.getString("recLetterNo"));
				ameLmeHeader.setReceiptLetterDate(HMSUtil.convertStringTypeDateToDateType(box.get("recLetterDate")));
				ameLmeHeader.setRemarks(box.getString("remarks"));
				ameLmeHeader.setStatus("y");
				ameLmeHeader.setAme(annualMediacalExamination);
				hbt.save(ameLmeHeader);

				if(recordcount > 0 && ameId > 0){
					String hql = "delete from jkt.hms.masters.business.AmeLmc as a where a.Ame.Id ="+ameId;
					Query query = session.createQuery(hql);
					int row = query.executeUpdate();
				}

				for(int i=1; i <= recordcount;i++){

					if(!box.get("disabilityName"+i).equals("") && !box.get("dcategory"+i).equals("") &&
							!box.get("dduration"+i).trim().equals("") && !box.get("permtemp"+i).equals("") &&
							!box.get("dNextReview"+i).equals("") && !box.get("EmpRestriction"+i).equals("")){
						AmeLmc ameLmc = new AmeLmc();
						ameLmc.setDisabilityName(box.get("disabilityName"+i));
						ameLmc.setCategory(new MasMedicalCategory(box.getInt("dcategory"+i)));
						ameLmc.setDuration(box.get("dduration"+i));
						ameLmc.setPermTemp(box.get("permtemp"+i));
						ameLmc.setDateOfNrv(HMSUtil.convertStringTypeDateToDateType(box.get("dNextReview"+i)));
						ameLmc.setEmpRestriction(box.get("EmpRestriction"+i));
						ameLmc.setLmcHeaderId(ameLmeHeader);
						hbt.save(ameLmc);
						hbt.refresh(ameLmc);
					}
				}
			}else{

				AnnualMediacalExamination annualMediacalExamination = (AnnualMediacalExamination) hbt.load(AnnualMediacalExamination.class, ameId);
				annualMediacalExamination.setNextReview(nextReviewDateDate);
				annualMediacalExamination.setLastBoard(ameDateDate);
				//annualMediacalExamination.setAfmsfDet(new EmpAfmsfDet(empAfmsfDetId));
				annualMediacalExamination.setLastChgBy(changedBy);
				annualMediacalExamination.setLastChgDate(currentDateDate);
				annualMediacalExamination.setLastChgTime(currentTime);
				annualMediacalExamination.setStatus("y");
				annualMediacalExamination.setPeriod(period);
				if(!box.get("dduration").equals(""))
					annualMediacalExamination.setDuration(box.get("dduration"));
				if(!box.get("categoryId").equals(""))
					annualMediacalExamination.setCategory(new MasMedicalCategory(box.getInt("categoryId")));

				hbt.update(annualMediacalExamination);
				if(empAfmsfDetId >0 ){
					EmpAfmsfDet empAfmsfDet =(EmpAfmsfDet)hbt.load(EmpAfmsfDet.class, empAfmsfDetId); 
					empAfmsfDet.setMedicalCategory(new MasMedicalCategory(box.getInt("categoryId")));
					hbt.update(empAfmsfDet);
				}

				List<AmeLmcHeader> ameLmeHList = new ArrayList<AmeLmcHeader>();

				ameLmeHList = session.createCriteria(AmeLmcHeader.class).add(Restrictions.eq("Ame.Id", ameId))
				                                                        .add(Restrictions.eq("Status", "y")).list();
				AmeLmcHeader ameLmeHeader  =  new AmeLmcHeader();
				if(ameLmeHList.size() == 0){
					ameLmeHeader.setFwdLetterNo(box.getString("fwdLetterNo"));
					ameLmeHeader.setFwdLetterDate(HMSUtil.convertStringTypeDateToDateType(box.get("fwdLetterDate")));
					ameLmeHeader.setReceiptLetterNo(box.getString("recLetterNo"));
					ameLmeHeader.setReceiptLetterDate(HMSUtil.convertStringTypeDateToDateType(box.get("recLetterDate")));
					ameLmeHeader.setRemarks(box.getString("remarks"));
					ameLmeHeader.setStatus("y");
					ameLmeHeader.setAme(annualMediacalExamination);
					hbt.save(ameLmeHeader);
					hbt.refresh(ameLmeHeader);
				}else{
					ameLmeHeader = (AmeLmcHeader) ameLmeHList.get(0);
					ameLmeHeader.setFwdLetterNo(box.getString("fwdLetterNo"));
					ameLmeHeader.setFwdLetterDate(HMSUtil.convertStringTypeDateToDateType(box.get("fwdLetterDate")));
					ameLmeHeader.setReceiptLetterNo(box.getString("recLetterNo"));
					ameLmeHeader.setReceiptLetterDate(HMSUtil.convertStringTypeDateToDateType(box.get("recLetterDate")));
					ameLmeHeader.setRemarks(box.getString("remarks"));
					hbt.update(ameLmeHeader);
					hbt.refresh(ameLmeHeader);
				}

				if(recordcount > 0){
					String hql = "";
					if(ameLmeHList.size() > 0){
						int ameH = ameLmeHList.get(0).getId();
						hql = "delete from jkt.hms.masters.business.AmeLmc as a where a.LmcHeaderId.Id ="+ameH;
						Query query = session.createQuery(hql);
						int row = query.executeUpdate();
					}
				}

				for(int i=1; i <= recordcount;i++){
					if(!box.get("disabilityName"+i).equals("") && !box.get("dcategory"+i).equals("") &&
							!box.get("dduration"+i).trim().equals("") && !box.get("permtemp"+i).equals("") &&
							!box.get("dNextReview"+i).equals("") && !box.get("EmpRestriction"+i).equals("")){
						AmeLmc ameLmc = new AmeLmc();

						ameLmc.setDisabilityName(box.get("disabilityName"+i));
						ameLmc.setCategory(new MasMedicalCategory(box.getInt("dcategory"+i)));
						ameLmc.setDuration(box.get("dduration"+i));
						ameLmc.setPermTemp(box.get("permtemp"+i));
						ameLmc.setDateOfNrv(HMSUtil.convertStringTypeDateToDateType(box.get("dNextReview"+i)));
						ameLmc.setEmpRestriction(box.get("EmpRestriction"+i));
						ameLmc.setLmcHeaderId(ameLmeHeader);
						hbt.save(ameLmc);
						hbt.refresh(ameLmc);
					}
				}
			}

			transaction.commit();
			message = "Data saved successfully. ";
			messageType = "success";
		} catch (Exception e) {
			if(transaction !=null)transaction.rollback();
			message = "Some problem occurred";
			messageType = "failure";
			e.printStackTrace();
		}
		map.put("message",message);
		map.put("messageType",messageType);
		return map;
	}
	 */
	// ------------------------------- Fatal Case Documentation
	// -------------------------------

	@SuppressWarnings("unchecked")
	//public Map<String, Object> showFatalCasejsp(int inpatientid) {
	public Map<String, Object> showFatalCasejsp(Map<String, Object> dataMap) {
		String serviceNo="";
		int inpatientid=0;
		if(dataMap.get("serviceNo") !=null){
			serviceNo=(String)dataMap.get("serviceNo");
		}
		if(dataMap.get("inpatientid") !=null){
			inpatientid=(Integer)dataMap.get("inpatientid");
		}
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<MisFatalTracking> misFatalTrackList = new ArrayList<MisFatalTracking>();
		List<FatalDocumentHeader> misFatalTrackingList = new ArrayList<FatalDocumentHeader>();

		try {
			inpatientList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("Id", inpatientid)).list();
			misFatalTrackList = session.createCriteria(
					MisFatalTracking.class).add(
							Restrictions.eq("ServiceNo", serviceNo)).list();
			misFatalTrackingList = session.createCriteria(
					FatalDocumentHeader.class).add(
							Restrictions.eq("ServiceNo", serviceNo)).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//map.put("inpatientList", inpatientList);
		map.put("misFatalTrackingList", misFatalTrackingList);
		map.put("misFatalTrackList", misFatalTrackList);
		return map;
	}

	/**
	 * editAfmsfSurplus()is used for:- 1) if fetching records from MasEmployee
	 * then enter a new record in EmpAfmsfDet table. 2) else, it is fetching
	 * records from the EmpAfmsfDet table, then update the selected record in
	 * EmpAfmsfDet table. Surplus Status is set to 'S'
	 */

	public boolean editFatalCase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
		"currentTime");
		String changedBy = "";

		@SuppressWarnings("unused")
		int hospitalId = 0;
		int hinId = 0;
		int inpatientId = 0;
		@SuppressWarnings("unused")
		int misFatalId = 0;
		@SuppressWarnings("unused")
		String adNo = null;
		String postmortem = null;

		String dateOfDeath = null;
		String dateOfPostmortem = null;
		String dateOfConcerned = null;
		String dateOfOpinion = null;
		String dateOfWardMaster = null;
		String dateOfMoWard = null;
		String dateOfHOD = null;
		String dateOfStats = null;
		String dateOfCommandant = null;
		String dateOfSA1 = null;
		String dateOfSA2 = null;
		String dateOfSA3 = null;
		String dateOfSA4 = null;
		String dateOfConcernedCommand = null;
		String dateOfPathology = "";
		String deathRemark = null;
		String postmortemRemark = null;
		String postmortemDateRemark = null;
		String concernedDateRemark = null;
		String opinionDateRemark = null;
		String wardMasterDateRemark = null;
		String wardDateRemark = null;
		String hodDateRemark = null;
		String statsDateRemark = null;
		String commandantDateRemark = null;
		String pathologyDateRemark = null;
		String sa1DateRemark = null;
		String sa2DateRemark = null;
		String sa3DateRemark = null;
		String sa4DateRemark = null;
		String concernedCommandDateRemark = null;
		String serviceNo="";
		misFatalId = Integer.parseInt("" + generalMap.get("misFatalId"));
		if (generalMap.get("serviceNo") != null)
			serviceNo = (String) generalMap.get("serviceNo");
		if (generalMap.get("dateOfDeath") != null)
			dateOfDeath = (String) generalMap.get("dateOfDeath");
		if (generalMap.get("dateOfPostmortem") != null)
			dateOfPostmortem = (String) generalMap.get("dateOfPostmortem");
		if (generalMap.get("dateOfConcerned") != null)
			dateOfConcerned = (String) generalMap.get("dateOfConcerned");
		if (generalMap.get("dateOfOpinion") != null)
			dateOfOpinion = (String) generalMap.get("dateOfOpinion");
		if (generalMap.get("dateOfWardMaster") != null)
			dateOfWardMaster = (String) generalMap.get("dateOfWardMaster");
		if (generalMap.get("dateOfMoWard") != null)
			dateOfMoWard = (String) generalMap.get("dateOfMoWard");
		if (generalMap.get("dateOfHOD") != null)
			dateOfHOD = (String) generalMap.get("dateOfHOD");
		if (generalMap.get("dateOfStats") != null)
			dateOfStats = (String) generalMap.get("dateOfStats");
		if (generalMap.get("dateOfCommandant") != null)
			dateOfCommandant = (String) generalMap.get("dateOfCommandant");
		if (generalMap.get("dateOfSA1") != null)
			dateOfSA1 = (String) generalMap.get("dateOfSA1");
		if (generalMap.get("dateOfSA2") != null)
			dateOfSA2 = (String) generalMap.get("dateOfSA2");
		if (generalMap.get("dateOfSA3") != null)
			dateOfSA3 = (String) generalMap.get("dateOfSA3");
		if (generalMap.get("dateOfSA4") != null)
			dateOfSA4 = (String) generalMap.get("dateOfSA4");
		if (generalMap.get("dateOfConcernedCommand") != null)
			dateOfConcernedCommand = (String) generalMap
			.get("dateOfConcernedCommand");
		if (generalMap.get("dateOfPathology") != null)
			dateOfPathology = (String) generalMap.get("dateOfPathology");

		if (generalMap.get("adNo") != null)
			adNo = (String) generalMap.get("adNo");
		if (generalMap.get("postmortem") != null)
			postmortem = (String) generalMap.get("postmortem");
		if (generalMap.get("hospitalId") != null)
			hospitalId = (Integer) generalMap.get("hospitalId");
		if (generalMap.get("hinId") != null)
			hinId = (Integer) generalMap.get("hinId");
		if (generalMap.get("inpatientId") != null)
			inpatientId = (Integer) generalMap.get("inpatientId");

		currentDate = (String) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		changedBy = (String) generalMap.get("changedBy");

		deathRemark = (String) generalMap.get("deathRemark");
		postmortemRemark = (String) generalMap.get("postmortemRemark");
		postmortemDateRemark = (String) generalMap.get("postmortemDateRemark");
		concernedDateRemark = (String) generalMap.get("concernedDateRemark");
		opinionDateRemark = (String) generalMap.get("opinionDateRemark");
		wardMasterDateRemark = (String) generalMap.get("wardMasterDateRemark");
		wardDateRemark = (String) generalMap.get("wardDateRemark");
		hodDateRemark = (String) generalMap.get("hodDateRemark");
		statsDateRemark = (String) generalMap.get("statsDateRemark");
		commandantDateRemark = (String) generalMap.get("commandantDateRemark");
		pathologyDateRemark = (String) generalMap.get("pathologyDateRemark");
		sa1DateRemark = (String) generalMap.get("sa1DateRemark");
		sa2DateRemark = (String) generalMap.get("sa2DateRemark");
		sa3DateRemark = (String) generalMap.get("sa3DateRemark");
		sa4DateRemark = (String) generalMap.get("sa4DateRemark");
		concernedCommandDateRemark = (String) generalMap
		.get("concernedCommandDateRemark");

		int trackId = 0;
		if(generalMap.get("trackId")!=null){
			trackId = (Integer)generalMap.get("trackId");
		}
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MisFatalTracking misFatalTracking = new MisFatalTracking();
			if(trackId!=0){
				misFatalTracking = (MisFatalTracking)hbt.load(MisFatalTracking.class, trackId);
			}
			if (misFatalId != 0){
			FatalDocumentHeader fatalDocumentHeader = new FatalDocumentHeader();
			fatalDocumentHeader.setId(misFatalId);
			misFatalTracking.setFatalDocumentHeader(fatalDocumentHeader);
			
			}
		
			MasHospital masHospital = new MasHospital();
			Patient patient = new Patient();
			Inpatient inpatient = new Inpatient();

			masHospital.setId(hospitalId);
			if(hinId !=0){
				patient.setId(hinId);
				misFatalTracking.setHin(patient);}
			if(inpatientId !=0){
				inpatient.setId(inpatientId);
				misFatalTracking.setInpatient(inpatient);}

			String status = "";
			Date statusDate = null;
			String statusRemarks = "";
			if (generalMap.get("serviceNo") != null) {
				misFatalTracking.setServiceNo(serviceNo);
			}
			if (generalMap.get("dateOfDeath") != null) {
				misFatalTracking.setDateofDeath(HMSUtil.convertStringTypeDateToDateType(dateOfDeath));
				status = "Date of Death";
				statusDate = HMSUtil
				.convertStringTypeDateToDateType(dateOfDeath);
				statusRemarks = deathRemark;
			}
			if (generalMap.get("dateOfPostmortem") != null) {
				misFatalTracking.setDateofPostRec(HMSUtil
						.convertStringTypeDateToDateType(dateOfPostmortem));
				status = "Date of Postmortem Received";
				statusDate = HMSUtil
				.convertStringTypeDateToDateType(dateOfPostmortem);
				statusRemarks = postmortemRemark;
			}
			if (generalMap.get("dateOfConcerned") != null) {
				misFatalTracking.setHoSplconceDate(HMSUtil
						.convertStringTypeDateToDateType(dateOfConcerned));
				status = "Documents H/O spl concerned Date";
				statusDate = HMSUtil
				.convertStringTypeDateToDateType(dateOfConcerned);
				statusRemarks = concernedDateRemark;
			}
			if (generalMap.get("dateOfOpinion") != null) {
				misFatalTracking.setRecSplOpDate(HMSUtil
						.convertStringTypeDateToDateType(dateOfOpinion));
				status = "Received from spl with opinion and Date";
				statusDate = HMSUtil
				.convertStringTypeDateToDateType(dateOfOpinion);
				statusRemarks = opinionDateRemark;
			}
			if (generalMap.get("dateOfWardMaster") != null) {
				misFatalTracking.setWardMaster(HMSUtil
						.convertStringTypeDateToDateType(dateOfWardMaster));
				status = "Completion of documents by Ward Master and Date";
				statusDate = HMSUtil
				.convertStringTypeDateToDateType(dateOfWardMaster);
				statusRemarks = wardMasterDateRemark;
			}
			if (generalMap.get("dateOfMoWard") != null) {
				misFatalTracking.setMoicWard(HMSUtil
						.convertStringTypeDateToDateType(dateOfMoWard));
				status = "Signature of MO i/c Ward";
				statusDate = HMSUtil
				.convertStringTypeDateToDateType(dateOfMoWard);
				statusRemarks = wardDateRemark;
			}
			if (generalMap.get("dateOfHOD") != null) {
				misFatalTracking.setHodPerusal(HMSUtil
						.convertStringTypeDateToDateType(dateOfHOD));
				status = "HOD persual on (Date)";
				statusDate = HMSUtil.convertStringTypeDateToDateType(dateOfHOD);
				statusRemarks = hodDateRemark;
			}
			if (generalMap.get("dateOfStats") != null) {
				misFatalTracking.setStatasWard(HMSUtil
						.convertStringTypeDateToDateType(dateOfStats));
				status = "Date of submission of Stats by Ward Master";
				statusDate = HMSUtil
				.convertStringTypeDateToDateType(dateOfStats);
				statusRemarks = statsDateRemark;
			}
			if (generalMap.get("dateOfCommandant") != null) {
				misFatalTracking.setCommanRemarks(HMSUtil
						.convertStringTypeDateToDateType(dateOfCommandant));
				status = "Date of submission for remarks of commandant";
				statusDate = HMSUtil
				.convertStringTypeDateToDateType(dateOfCommandant);
				statusRemarks = commandantDateRemark;
			}
			if (generalMap.get("dateOfPathology") != null) {
				misFatalTracking.setPatologyHead(HMSUtil
						.convertStringTypeDateToDateType(dateOfPathology));
				status = "Date of Dispatch to Senior Advisor Pathology for Persual";
				statusDate = HMSUtil
				.convertStringTypeDateToDateType(dateOfPathology);
				statusRemarks = pathologyDateRemark;
			}
			if (generalMap.get("dateOfSA1") != null) {
				misFatalTracking.setSeniorAdvisor1(HMSUtil
						.convertStringTypeDateToDateType(dateOfSA1));
				status = " 	Date of Dispatch to Senior Advisor for Persual";
				statusDate = HMSUtil.convertStringTypeDateToDateType(dateOfSA1);
				statusRemarks = sa1DateRemark;
			}
			if (generalMap.get("dateOfSA2") != null) {
				misFatalTracking.setSeniorAdvisor2(HMSUtil
						.convertStringTypeDateToDateType(dateOfSA2));
				status = "Date of Dispatch to Senior Advisor for Persual";
				statusDate = HMSUtil.convertStringTypeDateToDateType(dateOfSA2);
				statusRemarks = sa2DateRemark;
			}
			if (generalMap.get("dateOfSA3") != null) {
				misFatalTracking.setSeniorAdvisor3(HMSUtil
						.convertStringTypeDateToDateType(dateOfSA3));
				status = "Date of Dispatch to Senior Advisor for Persual";
				statusDate = HMSUtil.convertStringTypeDateToDateType(dateOfSA3);
				statusRemarks = sa3DateRemark;
			}
			if (generalMap.get("dateOfSA4") != null) {
				misFatalTracking.setSeniorAdvisor4(HMSUtil
						.convertStringTypeDateToDateType(dateOfSA4));
				status = "Date of Dispatch to Senior Advisor for Persual";
				statusDate = HMSUtil.convertStringTypeDateToDateType(dateOfSA4);
				statusRemarks = sa4DateRemark;
			}
			if (generalMap.get("dateOfConcernedCommand") != null) {
				misFatalTracking
				.setDespatchCommandant(HMSUtil
						.convertStringTypeDateToDateType(dateOfConcernedCommand));
				status = "Date of Dispatch to Concerned Command for Persual";
				statusDate = HMSUtil
				.convertStringTypeDateToDateType(dateOfConcernedCommand);
				statusRemarks = concernedCommandDateRemark;
			}
			if (generalMap.get("currentDate") != null)
				misFatalTracking.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(currentDate));

			misFatalTracking.setLatestStatus(status);
			misFatalTracking.setLatestStatusDate(statusDate);
			misFatalTracking.setLatestStatusRemarks(statusRemarks);

			misFatalTracking.setPostmortem(postmortem);
			misFatalTracking.setPostmortemRem(postmortemRemark);
			misFatalTracking.setDateofDeathRem(deathRemark);
			misFatalTracking.setDateofPostRecRem(postmortemDateRemark);
			misFatalTracking.setHoSplconceRem(concernedDateRemark);
			misFatalTracking.setRecSplOpRem(opinionDateRemark);
			misFatalTracking.setWardMasterRem(wardMasterDateRemark);
			misFatalTracking.setMoicWardRem(wardDateRemark);
			misFatalTracking.setHodPerusalRem(hodDateRemark);
			misFatalTracking.setStatasWardRem(statsDateRemark);
			misFatalTracking.setCommanRemarksRem(commandantDateRemark);
			misFatalTracking.setPatologyHeadRem(pathologyDateRemark);
			misFatalTracking.setSeniorAdvisor1Rem(sa1DateRemark);
			misFatalTracking.setSeniorAdvisor2Rem(sa2DateRemark);
			misFatalTracking.setSeniorAdvisor3Rem(sa3DateRemark);
			misFatalTracking.setSeniorAdvisor4Rem(sa4DateRemark);
			misFatalTracking
			.setDespatchCommandantRem(concernedCommandDateRemark);
			misFatalTracking.setLastChgBy(changedBy);
			misFatalTracking.setLastChgTime(currentTime);
			misFatalTracking.setHospital(masHospital);


			if (trackId == 0)
				hbt.save(misFatalTracking);
			else
				hbt.update(misFatalTracking);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	// ------------------ Total Admissions Date wise------------

	public Map<String, Object> showTotalAdmissionjsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		try {

			serviceTypeList = session.createCriteria(MasServiceType.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("serviceTypeList", serviceTypeList);

		return map;
	}

	public Map<String, Object> searchTotalAdmission(Date fromDate, Date toDate,
			String serviceType) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		try {

			serviceTypeList = session.createCriteria(MasServiceType.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("serviceTypeList", serviceTypeList);

		int toYear = 1900 + toDate.getYear();
		int fromYear = 1900 + fromDate.getYear();
		int toMonth = toDate.getMonth() + 1;
		int fromMonth = fromDate.getMonth() + 1;
		String dateTo = Integer.toString(toYear) + "-"
		+ Integer.toString(toMonth) + "-"
		+ Integer.toString(toDate.getDate());
		String dateFrom = Integer.toString(fromYear) + "-"
		+ Integer.toString(fromMonth) + "-"
		+ Integer.toString(fromDate.getDate());

		Connection conn = session.connection();
		map.put("conn", conn);

		return map;
	}

	/**
	 * ------------------------------- Total discharge Date Wise
	 * -----------------------
	 */
	public Map<String, Object> showTotalDischargejsp() {
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

	public Map<String, Object> searchTotalDischarge() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();

		Connection conn = session.connection();
		map.put("conn", conn);

		return map;
	}

	// --------------------------- Monthly Sick Report
	// ---------------------------
	public Map<String, Object> showMonthlySickReportsjsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();

		try {
			rankCategoryList = session.createCriteria(MasRankCategory.class)
			.add(Restrictions.eq("Status", "y")).list();
			masUnitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		Connection conn = session.connection();
		map.put("conn", conn);
		map.put("rankCategoryList", rankCategoryList);
		map.put("masUnitList", masUnitList);
		return map;

	}

	/**
	 * ---------------------- Monthly Sick Discharge Report
	 * --------------------------
	 */
	public Map<String, Object> showMonthlySickDischargeReportjsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();

		try {
			rankCategoryList = session.createCriteria(MasRankCategory.class)
			.add(Restrictions.eq("Status", "y")).list();
			masUnitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		Connection conn = session.connection();
		map.put("conn", conn);
		map.put("rankCategoryList", rankCategoryList);
		map.put("masUnitList", masUnitList);
		return map;
	}

	/**
	 * ---------------------- Fatal Document Panchnama
	 * --------------------------
	 */
	@SuppressWarnings("unchecked")
	public List getAdmissionNoList(Map<String, Object> detailsMap) {
		String serviceNo = "";
		String hinNo = "";
		String fatalCase = "";
		String onlyReport = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}
		if (detailsMap.get("fatalCase") != null) {
			fatalCase = (String) detailsMap.get("fatalCase");
		}
		if (detailsMap.get("onlyReport") != null) {
			onlyReport = (String) detailsMap.get("onlyReport");
		}
		List<Object> inpatientList = new ArrayList<Object>();

		try {
			if (!serviceNo.equals("")) {
				inpatientList = getHibernateTemplate().find(
						"from Inpatient ip join ip.Hin as p where p.ServiceNo = '"
						+ serviceNo + "'");
			}
			if (!hinNo.equals("")) {
				inpatientList = getHibernateTemplate().find(
						"from Inpatient ip join ip.Hin as p where  p.Id = '"
						+ hinNo + "'");
			}
			if (!fatalCase.equals("")) {
				inpatientList = getHibernateTemplate().find(
						"from ExpiryDetails e join e.Hin as p where p.HinNo = '"
						+ hinNo + "'");
			}
			// if(!onlyReport.equals("")){
			// inpatientList = getHibernateTemplate().find(
			// "from Birthdeathreg bd join bd.Hin as p where p.HinNo = '"
			// + hinNo + "'");
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
		return inpatientList;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getHinNoList(String serviceNo) {
		Session session = (Session) getSession();
		List<Object> patientList = new ArrayList<Object>();

		try {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).list();
			// inpatientList =
			// session.createCriteria(Inpatient.class).createAlias("Hin",
			// "p").add(Restrictions.eq("p.ServiceNo", serviceNo)).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientList;
	}

	public Map<String, Object> getDBConnection() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = session.connection();
		map.put("conn", conn);
		return map;
	}

	/**
	 * -------------------------------- FRW CASES
	 * -------------------------------
	 * 
	 * @return
	 */

	public Map<String, Object> showFrwCasesJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> serviceNoList = new ArrayList<Patient>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		try {
			serviceNoList = session.createCriteria(Patient.class).add(
					Restrictions.eq("Status", "y")).list();
			disposalList = session.createCriteria(MasDisposal.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("serviceNoList", serviceNoList);
		map.put("disposalList", disposalList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showFrwCases() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDisposedTo> disposalToList = new ArrayList<MasDisposedTo>();
		disposalToList = session.createCriteria(MasDisposedTo.class).add(
				Restrictions.eq("Status", "y")).list();
		List<MasUnit> masUnitList=session.createCriteria(MasUnit.class)
		.add(Restrictions.eq("Status","y")).list();
		map.put("masUnitList", masUnitList);
		map.put("disposalToList", disposalToList);
		return map;
	}

	public Map<String, Object> submitFrwCases(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean dataUpdated = false;
		String currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
		"currentTime");
		String changedBy = "";

		@SuppressWarnings("unused")
		int hinId = 0;
		int disposalId = 0;
		Date frwDate = new Date();
		String to = null;
		String toClass = null;
		String frwSerialNo = "";
		String por = null;
		String message = "";
		String messageType = "";
		String otherHospital = "";
		String sickleave = "";
		String leaveAddress = null;
		Date fromDate = null;
		Date toDate = null;
		String review = null;
		String ad_no = null;

		hinId = (Integer) generalMap.get("hinId");
		ad_no = (String)generalMap.get("ad_no");
		disposalId = (Integer) generalMap.get("disposalId");
		frwDate = (Date) generalMap.get("frwDate");
		fromDate = (Date) generalMap.get("fromDate");
		toDate = (Date) generalMap.get("toDate");
		to = (String) generalMap.get("to");
		toClass = (String) generalMap.get("toClass");
		frwSerialNo = "" + generalMap.get("frwSerialNo");
		por = (String) generalMap.get("por");
		if (generalMap.get("otherHospital") != null)
			otherHospital = (String) generalMap.get("otherHospital");

		if (generalMap.get("sickLeave") != null) {
			sickleave = (String) generalMap.get("sickLeave");
		}


		if (generalMap.get("leaveAddress") != null) {
			leaveAddress = (String) generalMap.get("leaveAddress");
		}


		if (generalMap.get("review") != null) {
			review = (String) generalMap.get("review");
		}

		Session session = (Session) getSession();
		List<Inpatient> misFrwList = new ArrayList<Inpatient>();
		misFrwList = session.createCriteria(MisFrw.class).add(
				Restrictions.eq("AdNo", ad_no)).list();
		try {
			if (misFrwList.size() == 0) {
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				MisFrw misFrw = new MisFrw();
				Patient patient = new Patient();
				MasDisposedTo masDisposed = new MasDisposedTo();
				masDisposed.setId(disposalId);
				misFrw.setDisposedTo(masDisposed);
				patient.setId(hinId);
				misFrw.setHin(patient);
				misFrw.setAdNo(ad_no);
				misFrw.setFrwDate(frwDate);
				misFrw.setToDesc(to);
				misFrw.setToClass(toClass);
				if (generalMap.get("toUnit") != null) 
				{
					int toUnit = (Integer) generalMap.get("toUnit");
					MasUnit masUnit=new MasUnit();
					masUnit.setId(toUnit);
					misFrw.setToUnit(masUnit);
				}
				misFrw.setFrwSerialNo(frwSerialNo);
				misFrw.setPor(por);
				misFrw.setOtherHospital(otherHospital);
				misFrw.setSickleave(sickleave);
				misFrw.setReview(review);
				misFrw.setFromdate(fromDate);
				misFrw.setTodate(toDate);
				misFrw.setFrwAddress(leaveAddress);
				hbt.save(misFrw);
				message = "FRW details Saved Successfully.Do want to print";
				messageType = "success";
			} else {
				message = "FRW details Already exists.Do want to print";
				messageType = "failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Error has occure .Try Again !!";
			messageType = "failure";
		}
		map.put("message", message);
		map.put("messageType", messageType);
		return map;
	}

	/**
	 * -------------------- NOTIFIABLE DISEASE ENTRY FORM ------------
	 */

	public Map<String, Object> showNotifiableDiseaseJsp(Map<String, Object> generalMap) 
	{
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIcd> diagnosisList = new ArrayList<MasIcd>();
		List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
	
		try {

			diagnosisList = session.createCriteria(MasIcd.class).add(
					Restrictions.eq("Status", "y")).list();

			masMedicalExaminationDetailList = session.createCriteria(MasMedicalExaminationDetail.class)
			.add(Restrictions.eq("Particular", "detail")).list();
			/*.createAlias("MasMedicalReport", "medReport").add(
			Restrictions.eq("medReport.Id", medExamId))*/
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		// map.put("showList", showList);

		map.put("diagnosisList", diagnosisList);
		map.put("masMedicalExaminationDetailList", masMedicalExaminationDetailList);
		return map;

	}

	public Map<String, Object> showNotifiableDisease(
			Map<String, Object> generalMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> showList = new ArrayList<Object>();
		List<MasIcd> diagnosisList = new ArrayList<MasIcd>();
		int inpatientId = 0;
		inpatientId = (Integer) generalMap.get("inpatientId");
		String adNo = null;
		adNo = (String) generalMap.get("adNo");
		try {

			showList = getHibernateTemplate()
			.find(
					"from Inpatient ip join ip.Hin as p left join p.Unit as u left join p.Rank as r "
					+ "where ip.Id='" + inpatientId + "'");
			diagnosisList = session.createCriteria(MasIcd.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("showList", showList);

		map.put("diagnosisList", diagnosisList);
		return map;

	}

	public boolean editNotifiableDisease(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
		"currentTime");
		String changedBy = "";

		@SuppressWarnings("unused")
		int hospitalId = 0;
		int hinId = 0;
		int basisOfDiagnosis = 0;
		int inpatientId = 0;

		String adNo = null;
		String postmortem = null;

		Date dateOfOnset = new Date();
		Date dateOfReportingSick = new Date();
		Date dateOfPreventive = new Date();
		Date dateOfNotifiable = new Date();

		String designation = null;
		String suspectedSource = null;
		String measuresOfControl = null;
		String contact = null;
		String generalRemarks = null;
		String station = null;

		dateOfOnset = (Date) generalMap.get("dateOfOnset");
		dateOfReportingSick = (Date) generalMap.get("dateOfReportingSick");
		dateOfPreventive = (Date) generalMap.get("dateOfPreventive");
		dateOfNotifiable = (Date) generalMap.get("dateOfNotifiable");
		basisOfDiagnosis = (Integer) generalMap.get("basisOfDiagnosis");
		designation = (String) generalMap.get("designation");
		suspectedSource = (String) generalMap.get("suspectedSource");
		measuresOfControl = (String) generalMap.get("measuresOfControl");
		contact = (String) generalMap.get("contact");
		generalRemarks = (String) generalMap.get("generalRemarks");
		station = (String) generalMap.get("station");

		inpatientId = (Integer) generalMap.get("inpatientId");
		hospitalId = (Integer) generalMap.get("hospitalId");
		hinId = (Integer) generalMap.get("hinId");

		String disinfection="";
		String bacteriological="";
		String clinical="";
		if(generalMap.get("disinfection")!=null){
			disinfection=(String)generalMap.get("disinfection");
		}
		if(generalMap.get("bacteriological")!=null){
			bacteriological=(String)generalMap.get("bacteriological");
		}
		if(generalMap.get("clinical")!=null){
			clinical=(String)generalMap.get("clinical");
		}
		currentDate = (String) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		changedBy = (String) generalMap.get("changedBy");

		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MisNotifiable misNotifiable = new MisNotifiable();
			MasHospital masHospital = new MasHospital();
			Patient patient = new Patient();
			MasIcd icd = new MasIcd();
			Inpatient inpatient = new Inpatient();

			icd.setId(basisOfDiagnosis);
			masHospital.setId(hospitalId);
			patient.setId(hinId);
			inpatient.setId(inpatientId);

			misNotifiable.setNotifiableDate(dateOfNotifiable);
			misNotifiable.setDateOnSetDate(dateOfOnset);
			misNotifiable.setDateOfReportingSick(dateOfReportingSick);
			misNotifiable.setDateOfPreventive(dateOfPreventive);
			misNotifiable.setDesignationOfQuaters(designation);
			misNotifiable.setIcd(icd);
			misNotifiable.setSuspectedSource(suspectedSource);
			misNotifiable.setMeasuresOfControl(measuresOfControl);
			misNotifiable.setContact(contact);
			misNotifiable.setGeneralRemarks(generalRemarks);

			misNotifiable.setLastChgBy(changedBy);
			misNotifiable.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(currentDate));
			misNotifiable.setLastChgTime(currentTime);

			misNotifiable.setHospital(masHospital);
			misNotifiable.setHin(patient);
			misNotifiable.setInpatient(inpatient);

			misNotifiable.setDisinfection(disinfection);
			misNotifiable.setClinical(clinical);
			misNotifiable.setBacteriological(bacteriological);
			hbt.saveOrUpdate(misNotifiable);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	/**
	 * -------------------- NOTIFIABLE DISEASE REPORT ------------
	 */

	public Map<String, Object> showNotifiableDiseaseReportJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIcd> diagnosisList = new ArrayList<MasIcd>();
		try {

			diagnosisList = session.createCriteria(MasIcd.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("diagnosisList", diagnosisList);
		return map;

	}

	/**
	 * -------------------- MALARIA CASE REPORT ------------
	 */

	public Map<String, Object> showMalariaCaseReportJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIcd> icdCodeList = new ArrayList<MasIcd>();
		try {

			icdCodeList = session.createCriteria(MasIcd.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("icdCodeList", icdCodeList);
		return map;

	}

	// ------------------------Daily Bed Status---------------------------------
	public Map<String, Object> showDailyBedStatusReport() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> showList = new ArrayList<Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		java.sql.Connection con = session.connection();
		map.put("departmentList", departmentList);
		map.put("con", con);
		return map;
	}

	public Map<String, Object> showBedStatisticsSummary() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> showList = new ArrayList<Object>();
		java.sql.Connection con = session.connection();
		map.put("con", con);
		String sql = "{call p_bedStats('2008-05-09')}";
		try {
			CallableStatement cals = con.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}

	// *************************** BIRTH CERTIFICATE
	// ***************************************
	public Map<String, Object> showBirthCertificateJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Birthdeathreg> searchBirthList = new ArrayList<Birthdeathreg>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		searchBirthList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.Birthdeathreg ");
		employeeList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.MasEmployee ");
		map.put("searchBirthList", searchBirthList);
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> addBirthCertificate(
			Map<String, Object> generalMap) {
		List<Birthdeathreg> birthList = new ArrayList<Birthdeathreg>();
		Map<String, Object> map = new HashMap<String, Object>();
		String isRecordAlreadyExists = "";
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		String lastChgBy = "";
		String regNo = "";
		int inpatientId = 0;
		inpatientId = (Integer) generalMap.get("inpatientId");
		String patientName = "";
		String motherName = "";
		String fatherName = "";
		Date dob = new Date();
		Date dor = new Date();
		String gender = "";
		Date currentDate = new Date();
		String currentTime = "";
		int serNo = 0;
		int hospitalId = 0;
		int sexId = 0;
		int employeeId = 0;
		String hintNo = "";
		int hintId = 0;
		int noOfCopies = 0;
		int amount = 0;
		String time = "";
		String messageType = "";
		String addressDeath = "";
		String addressPermanent = "";
		String remarks = "";
		Date issueDate = new Date();
		if (generalMap.get("serNo") != null)
			serNo = Integer.parseInt("" + generalMap.get("serNo"));
		if (generalMap.get("time") != null)
			time = ("" + generalMap.get("time"));
		try {
			birthList = hbt
			.find("from Birthdeathreg as ip where ip.Inpatient.Id='"
					+ inpatientId + "' and ip.Bdtype='b'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Transaction transaction = null;
		if (birthList.size() == 0) {
			inpatientId = (Integer) generalMap.get("inpatientId");
			noOfCopies = (Integer) generalMap.get("noOfCopies");
			amount = (Integer) generalMap.get("amount");
			patientName = (String) generalMap.get("patientName");
			motherName = (String) generalMap.get("motherName");
			fatherName = (String) generalMap.get("fatherName");
			currentTime = (String) generalMap.get("currentTime");
			currentDate = (Date) generalMap.get("currentDate");
			lastChgBy = (String) generalMap.get("lastChgBy");
			dob = (Date) generalMap.get("dob");
			dor = (Date) generalMap.get("dor");
			gender = (String) generalMap.get("gender");
			regNo = (String) generalMap.get("regNo");
			hospitalId = (Integer) generalMap.get("hospitalId");
			hintNo = (String) generalMap.get("hintNo");
			hintId = (Integer) generalMap.get("hintId");
			sexId = (Integer) generalMap.get("sexId");
			employeeId = (Integer) generalMap.get("employeeId");
			remarks = (String) generalMap.get("remarks");
			issueDate = (Date) generalMap.get("issueDate");
			addressPermanent = (String) generalMap.get("addressPermanent");
			addressDeath = (String) generalMap.get("addressDeath");
			try {
				transaction = session.beginTransaction();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				Birthdeathreg birthdeathreg = new Birthdeathreg();
				birthdeathreg.setBdtype("b");
				birthdeathreg.setDob(dob);
				birthdeathreg.setDor(dor);
				birthdeathreg.setName(patientName);
				birthdeathreg.setFname(fatherName);
				birthdeathreg.setMname(motherName);
				birthdeathreg.setRegno(regNo);
				birthdeathreg.setLastChgBy(lastChgBy);
				birthdeathreg.setLastChgDate(currentDate);
				birthdeathreg.setLastChgTime(currentTime);
				birthdeathreg.setAmount(amount);
				birthdeathreg.setNoOfCopies(noOfCopies);
				birthdeathreg.setTime(time);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				birthdeathreg.setHospital(masHospital);
				birthdeathreg.setAddressDeath(addressDeath);
				birthdeathreg.setAddressPermanent(addressPermanent);
				birthdeathreg.setRemarks(remarks);
				birthdeathreg.setDateOfIssue(issueDate);
				if (employeeId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(employeeId);
					birthdeathreg.setEmp(masEmployee);
				}
				Patient patient = new Patient();
				patient.setHinNo(hintNo);
				birthdeathreg.setHin(patient);

				Patient patient1 = new Patient();
				patient1.setId(hintId);
				birthdeathreg.setHin(patient1);

				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				birthdeathreg.setInpatient(inpatient);

				MasAdministrativeSex masAdministrativeSex1 = new MasAdministrativeSex();
				masAdministrativeSex1.setId(sexId);
				birthdeathreg.setAdministrativeSex(masAdministrativeSex1);

				hbt.save(birthdeathreg);

				// don't delete , this is for Birth certificate auto generation
				// TransactionSequence transactionSequence
				// =(TransactionSequence) hbt.load(TransactionSequence.class,
				// 7);
				// transactionSequence.setTransactionSequenceNumber(serNo);
				// hbt.update(transactionSequence);
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null)
					transaction.rollback();
				isRecordAlreadyExists = "Some problem Occured! Try Again.";
				messageType = "failure";
				e.printStackTrace();
			}
			isRecordAlreadyExists = "Information saved Successfully. Do you want to print Birth Certificate?";
			messageType = "success";
			map.put("birthList", birthList);

		} else {
			messageType = "failure";
			isRecordAlreadyExists = "Birth Certificate Already Exists.Do you want to print Birth Certificate?";
		}
		map.put("isRecordAlreadyExists", isRecordAlreadyExists);
		map.put("messageType", messageType);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showBirth(int inpatientId) {
		Session session = (Session) getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> showList = new ArrayList<Object>();
		List<Patient> motherList = new ArrayList<Patient>();
		List<Patient> fatherList = new ArrayList<Patient>();
		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		String motherName = "";
		String fatherName = "";
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		String serviceNo = "";
		try {

			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
			showList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.Inpatient as ip where ip.Id='"
					+ inpatientId + "'");

			if (showList.size() > 0) {
				if (showList != null) {
					int counter = 0;
					Iterator ite = showList.iterator();
					while (ite.hasNext()) {
						Inpatient inpatient = (Inpatient) ite.next();
						serviceNo = inpatient.getHin().getServiceNo();
						counter++;
					}
				}
				if (!serviceNo.equals("")) {
					motherList = getHibernateTemplate().find(
							"from Patient where ServiceNo='" + serviceNo
							+ "' and Relation.Id=3");
					fatherList = getHibernateTemplate().find(
							"from Patient where ServiceNo='" + serviceNo
							+ "' and Relation.Id=2");
				}
				if (motherList.size() > 0) {
					for (Patient patient : motherList) {
						motherName = "" + patient.getPFirstName() + " "
						+ patient.getPMiddleName() + " "
						+ patient.getPLastName();
					}
				}
				if (fatherList.size() > 0) {
					for (Patient patient2 : fatherList) {
						fatherName = "" + patient2.getPFirstName() + " "
						+ patient2.getPMiddleName() + " "
						+ patient2.getPLastName();
					}
				}
				map.put("fatherName", fatherName);
				map.put("motherName", motherName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("showList", showList);
		map.put("employeeList", employeeList);
		map.put("empAfmsfDetList", empAfmsfDetList);
		return map;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public List<Object> getMotherHin(String serviceNo) {
		Session session = (Session) getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> motherHinList = new ArrayList<Object>();
		try {
			motherHinList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("motherHinList", motherHinList);
		return motherHinList;

	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	public Map<String, Object> generateRegNumber(Map<String, Object> regMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String regNo = "";
		String bOrD = "";
		List<TransactionSequence> regList = new ArrayList<TransactionSequence>();
		String year = (String) regMap.get("year");
		int hospitalId = (Integer)regMap.get("hospitalId");
		Session session = (Session) getSession();
		if (regMap.get("bOrD") != null)
			bOrD = "" + regMap.get("bOrD");
		try {
			if (bOrD.equals("birth"))
				regList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "BC")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			else if (bOrD.equals("death"))
				regList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "DC")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int seqNo = 0;
		int yearTemp = 0;
		if (regList.size() > 0) {
			for (TransactionSequence transactionSequence : regList) {
				seqNo = transactionSequence.getTransactionSequenceNumber();
				yearTemp = Integer
				.parseInt("" + transactionSequence.getMonth());

			}
			if (year.equals("" + yearTemp)) {
				seqNo++;
				regNo = String.valueOf(seqNo).concat("/");
				regNo = regNo.concat(year);
			} else {
				seqNo = 1;
				try {
					TransactionSequence transactionSequence = (TransactionSequence) hbt
					.load(TransactionSequence.class, 16);
					transactionSequence.setMonth(Integer.parseInt("" + year));
					hbt.update(transactionSequence);
					TransactionSequence transactionSequence2 = (TransactionSequence) hbt
					.load(TransactionSequence.class, 7);
					transactionSequence2.setMonth(Integer.parseInt("" + year));
					hbt.update(transactionSequence2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				regNo = String.valueOf(seqNo).concat("/");
				regNo = regNo.concat(year);
			}

		} else if (regList.size() == 0) {

			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("birthdeathreg");
			if(bOrD.equals("birth")){
				tsObj.setTransactionPrefix("BC");
				tsObj.setTransactionSequenceName("Birth Certificate");
			}
			else if (bOrD.equals("death")){
				tsObj.setTransactionPrefix("DC");
				tsObj.setTransactionSequenceName("Death Certificate");
			}

			tsObj.setTransactionSequenceNumber(1);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			tsObj.setHospital(hospital);
			hbt.save(tsObj);

			seqNo = 1;
			regNo = String.valueOf(seqNo).concat("/");
			regNo = regNo.concat(year);
		}
		map.put("regNo", regNo);
		map.put("serNo", seqNo);
		return map;
	}

	public Map<String, Object> showUpdateBirthCertificate(
			Map<String, Object> map) {
		String regNo = null;
		List<Object> birthList = new ArrayList<Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		regNo = (String) map.get("regNo");
		Session session = (Session) getSession(true);
		try {
			birthList = getHibernateTemplate().find(
					"from Birthdeathreg as b where b.Regno='" + regNo
					+ "' and Bdtype='b'");
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		map.put("birthList", birthList);
		map.put("employeeList", employeeList);
		return map;
	}

	// --------------------Death
	// Certificate---------------------------------------

	public Map<String, Object> showDeathCertificateJsp() {
		Session session = (Session) getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Birthdeathreg> searchDeathList = new ArrayList<Birthdeathreg>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		employeeList = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Status", "y")).list();
		searchDeathList = getHibernateTemplate().find(
		"from jkt.hms.masters.business.Birthdeathreg ");
		map.put("searchDeathList", searchDeathList);
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> showDeath(int inpatientId) {
		Session session = (Session) getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> showList = new ArrayList<Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<Object> expiryList = new ArrayList<Object>();
		String Expired = "";
		String serviceNo = "";
		int expiredHinNo = 0;
		List<Patient> motherList = new ArrayList<Patient>();
		List<Patient> fatherList = new ArrayList<Patient>();
		String motherName = "";
		String fatherName = "";
		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
			inpatientList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("Id", inpatientId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		if (inpatientList.size() > 0) {
			if (inpatientList != null) {
				for (Inpatient inpatient : inpatientList) {
					serviceNo = inpatient.getHin().getServiceNo();
				}
			}
			if (!serviceNo.equals("")) {
				motherList = getHibernateTemplate().find(
						"from Patient where ServiceNo='" + serviceNo
						+ "' and Relation.Id=3");
				fatherList = getHibernateTemplate().find(
						"from Patient where ServiceNo='" + serviceNo
						+ "' and Relation.Id=2");
			}
			if (motherList.size() > 0) {
				for (Patient patient : motherList) {
					motherName = "" + patient.getPFirstName() + " "
					+ patient.getPMiddleName() + " "
					+ patient.getPLastName();
				}
			}
			if (fatherList.size() > 0) {
				for (Patient patient2 : fatherList) {
					fatherName = "" + patient2.getPFirstName() + " "
					+ patient2.getPMiddleName() + " "
					+ patient2.getPLastName();
				}
			}
		}
		map.put("fatherName", fatherName);
		map.put("motherName", motherName);
		map.put("inpatientList", inpatientList);
		map.put("employeeList", employeeList);

		return map;
	}

	public List<Object> getExpiredHin(String serviceNo) {
		Session session = (Session) getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> expiredHinNo = new ArrayList<Object>();
		try {

			expiredHinNo = getHibernateTemplate().find(
					"from Patient where ServiceNo='" + serviceNo
					+ "' and PatientStatus='Expired'");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("expiredHinNo", expiredHinNo);
		return expiredHinNo;

	}

	public Map<String, Object> addDeathCertificate(
			Map<String, Object> generalMap) {
		List<Birthdeathreg> deathList = new ArrayList<Birthdeathreg>();
		Map<String, Object> map = new HashMap<String, Object>();
		String messageType = "";
		String isRecordAlreadyExists = "";
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		String regNo = "";
		int inpatientId = 0;
		inpatientId = (Integer) generalMap.get("inpatientId");
		String patientName = "";
		String motherName = "";
		String fatherName = "";
		String addressDeath = "";
		String addressPermanent = "";
		String remarks = "";
		Date issueDate = new Date();
		Date dod = new Date();
		Date dor = new Date();
		String gender = "";
		String lastChgBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		int hospitalId = 0;
		int sexId = 0;
		int employeeId = 0;
		int noOfCopies = 0;
		int amount = 0;
		String hintNo = "";
		int hintId = 0;
		int serNo = 0;
		String time = "";
		if (generalMap.get("serNo") != null)
			serNo = Integer.parseInt("" + generalMap.get("serNo"));
		if (generalMap.get("time") != null)
			time = ("" + generalMap.get("time"));
		try {
			deathList = hbt
			.find("from Birthdeathreg as ip where ip.Inpatient.Id='"
					+ inpatientId + "' and ip.Bdtype='d'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (deathList.size() == 0) {
			noOfCopies = (Integer) generalMap.get("noOfCopies");
			amount = (Integer) generalMap.get("amount");
			inpatientId = (Integer) generalMap.get("inpatientId");
			patientName = (String) generalMap.get("patientName");
			gender = (String) generalMap.get("gender");
			sexId = (Integer) generalMap.get("sexId");
			dod = (Date) generalMap.get("dod");
			motherName = (String) generalMap.get("motherName");
			fatherName = (String) generalMap.get("fatherName");
			addressPermanent = (String) generalMap.get("addressPermanent");
			addressDeath = (String) generalMap.get("addressDeath");
			regNo = (String) generalMap.get("regNo");
			dor = (Date) generalMap.get("dor");
			remarks = (String) generalMap.get("remarks");
			issueDate = (Date) generalMap.get("issueDate");
			currentTime = (String) generalMap.get("currentTime");
			currentDate = (Date) generalMap.get("currentDate");
			lastChgBy = (String) generalMap.get("lastChgBy");
			hospitalId = (Integer) generalMap.get("hospitalId");
			hintNo = (String) generalMap.get("hintNo");
			hintId = (Integer) generalMap.get("hintId");
			employeeId = (Integer) generalMap.get("employeeId");

			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				Birthdeathreg birthdeathreg = new Birthdeathreg();
				birthdeathreg.setBdtype("d");

				birthdeathreg.setName(patientName);

				MasAdministrativeSex masAdministrativeSex1 = new MasAdministrativeSex();
				masAdministrativeSex1.setId(sexId);
				if (employeeId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(employeeId);
					birthdeathreg.setEmp(masEmployee);
				}
				birthdeathreg.setAdministrativeSex(masAdministrativeSex1);

				birthdeathreg.setFname(fatherName);
				birthdeathreg.setMname(motherName);
				birthdeathreg.setAddressDeath(addressDeath);
				birthdeathreg.setAddressPermanent(addressPermanent);
				birthdeathreg.setRegno(regNo);
				birthdeathreg.setDob(dod);
				birthdeathreg.setDor(dor);
				birthdeathreg.setRemarks(remarks);
				birthdeathreg.setDateOfIssue(issueDate);
				birthdeathreg.setLastChgBy(lastChgBy);
				birthdeathreg.setLastChgDate(currentDate);
				birthdeathreg.setLastChgTime(currentTime);
				birthdeathreg.setAmount(amount);
				birthdeathreg.setNoOfCopies(noOfCopies);
				birthdeathreg.setTime(time);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				birthdeathreg.setHospital(masHospital);

				Patient patient = new Patient();
				patient.setHinNo(hintNo);
				birthdeathreg.setHin(patient);

				Patient patient1 = new Patient();
				patient1.setId(hintId);
				birthdeathreg.setHin(patient1);

				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				birthdeathreg.setInpatient(inpatient);

				hbt.save(birthdeathreg);

				// -----------------don't delete, this is for death certificate
				// TransactionSequence transactionSequence
				// =(TransactionSequence) hbt.load(TransactionSequence.class,
				// 16);
				// transactionSequence.setTransactionSequenceNumber(serNo);
				// hbt.update(transactionSequence);
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null)
					transaction.rollback();
				isRecordAlreadyExists = "Some problem Occured! Try Again.";
				messageType = "failure";
				e.printStackTrace();
			}
			isRecordAlreadyExists = "Information saved Successfully. Do you want to print Death Certificate?";
			messageType = "success";
			map.put("deathList", deathList);

		} else {
			messageType = "failure";
			isRecordAlreadyExists = "Death Certificate Already Exists.Do you want to print Death Certificate?";

		}
		map.put("isRecordAlreadyExists", isRecordAlreadyExists);
		map.put("messageType", messageType);
		return map;
	}

	public boolean submitUpdateBirthCertificate(Map<String, Object> generalMap) {
		int birthDeathId = 0;
		String patientName;
		String motherName;
		String fatherName;
		String remarks;
		Date dor;
		String lastChgBy;
		Date lastChgDate;
		String lastChgTime;
		Date dod = null;
		int amount = 0;
		int noOfCopies = 0;
		int empId = 0;
		boolean dataUpdated = false;
		String time = "";
		String addressBirth = "";
		String addressPermanent = "";

		Date issueDate = new Date();

		Birthdeathreg birthdeathreg = new Birthdeathreg();
		birthdeathreg = (Birthdeathreg) generalMap.get("birthdeathreg");
		birthDeathId = (Integer) generalMap.get("birthDeathId");
		patientName = (String) generalMap.get("patientName");
		motherName = (String) generalMap.get("motherName");
		fatherName = (String) generalMap.get("fatherName");
		remarks = (String) generalMap.get("remarks");
		dor = (Date) generalMap.get("dor");
		lastChgBy = (String) generalMap.get("lastChgBy");
		lastChgDate = (Date) generalMap.get("currentDate");
		lastChgTime = (String) generalMap.get("currentTime");
		amount = Integer.parseInt("" + generalMap.get("amount"));
		noOfCopies = Integer.parseInt("" + generalMap.get("noOfCopies"));
		empId = Integer.parseInt("" + generalMap.get("empId"));
		dod = (Date) generalMap.get("dod");
		time = "" + generalMap.get("time");
		remarks = (String) generalMap.get("remarks");
		issueDate = (Date) generalMap.get("issueDate");
		addressPermanent = (String) generalMap.get("addressPermanent");
		addressBirth = (String) generalMap.get("addressBirth");
		HibernateTemplate hbt = getHibernateTemplate();
		Session session = (Session) getSession();
		hbt.setFlushModeName("FLUSH_EAGER");
		birthdeathreg = (Birthdeathreg) hbt.load(Birthdeathreg.class,
				birthDeathId);
		try {
			birthdeathreg.setName(patientName);
			birthdeathreg.setMname(motherName);
			birthdeathreg.setFname(fatherName);
			birthdeathreg.setRemarks(remarks);
			birthdeathreg.setDor(dor);
			birthdeathreg.setDod(dod);
			birthdeathreg.setLastChgBy(lastChgBy);
			birthdeathreg.setLastChgDate(lastChgDate);
			birthdeathreg.setLastChgTime(lastChgTime);
			birthdeathreg.setAmount(amount);
			birthdeathreg.setNoOfCopies(noOfCopies);
			birthdeathreg.setTime(time);
			birthdeathreg.setDateOfIssue(issueDate);
			birthdeathreg.setAddressDeath(addressBirth);
			birthdeathreg.setAddressPermanent(addressPermanent);
			if (empId != 0)
				birthdeathreg.setEmp(new MasEmployee(empId));
			hbt.saveOrUpdate(birthdeathreg);
		} catch (Exception e) {
			e.printStackTrace();
		}

		dataUpdated = true;
		return dataUpdated;
	}

	public boolean submitUpdateDeathCertificate(Map<String, Object> generalMap) {
		int birthDeathId = 0;
		String patientName;
		String motherName;
		String fatherName;
		String remarks;
		Date dor;
		Date dod;
		String lastChgBy;
		Date lastChgDate;
		String lastChgTime;

		String addressDeath = "";
		String addressPermanent = "";
		boolean dataUpdated = false;
		int amount = 0;
		int noOfCopies = 0;
		String time = "";
		Birthdeathreg birthdeathreg = new Birthdeathreg();
		birthdeathreg = (Birthdeathreg) generalMap.get("birthdeathreg");
		birthDeathId = (Integer) generalMap.get("birthDeathId");
		patientName = (String) generalMap.get("patientName");
		motherName = (String) generalMap.get("motherName");
		fatherName = (String) generalMap.get("fatherName");
		remarks = (String) generalMap.get("remarks");
		dor = (Date) generalMap.get("dor");
		dod = (Date) generalMap.get("dod");
		lastChgBy = (String) generalMap.get("lastChgBy");
		lastChgDate = (Date) generalMap.get("currentDate");
		lastChgTime = (String) generalMap.get("currentTime");
		addressDeath = (String) generalMap.get("addressDeath");
		addressPermanent = (String) generalMap.get("addressPermanent");

		amount = (Integer) generalMap.get("amount");
		noOfCopies = (Integer) generalMap.get("noOfCopies");
		time = "" + generalMap.get("time");
		HibernateTemplate hbt = getHibernateTemplate();
		Session session = (Session) getSession();
		hbt.setFlushModeName("FLUSH_EAGER");
		birthdeathreg = (Birthdeathreg) hbt.load(Birthdeathreg.class,
				birthDeathId);
		try {
			birthdeathreg.setName(patientName);
			birthdeathreg.setMname(motherName);
			birthdeathreg.setFname(fatherName);
			birthdeathreg.setRemarks(remarks);
			birthdeathreg.setDor(dor);
			birthdeathreg.setLastChgBy(lastChgBy);
			birthdeathreg.setLastChgDate(lastChgDate);
			birthdeathreg.setLastChgTime(lastChgTime);
			birthdeathreg.setAddressDeath(addressDeath);
			birthdeathreg.setAddressPermanent(addressPermanent);
			birthdeathreg.setDod(dod);
			birthdeathreg.setAmount(amount);
			birthdeathreg.setNoOfCopies(noOfCopies);
			birthdeathreg.setTime(time);
			hbt.saveOrUpdate(birthdeathreg);
		} catch (Exception e) {
			e.printStackTrace();
		}

		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> showUpdateDeathCertificate(
			Map<String, Object> map) {
		String regNo = null;
		List<Object> deathList = new ArrayList<Object>();
		Session session = (Session) getSession();
		regNo = (String) map.get("regNo");
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		try {
			deathList = getHibernateTemplate().find(
					"from Birthdeathreg as b where b.Regno='" + regNo
					+ "' and Bdtype='d'");
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).list();
		} catch (Exception e) {
		}
		map.put("deathList", deathList);
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> showBedStatisticsDetailReport(
			Map<String, Object> generalap) {
		List showList = new ArrayList();
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = session.connection();
		map.put("conn", conn);
		java.util.Date utilFromDate = (java.util.Date) generalap
		.get("fromDate");
		java.util.Date utilToDate = (java.util.Date) generalap.get("toDate");

		Calendar calFrom = Calendar.getInstance();
		Calendar calTo = Calendar.getInstance();
		calFrom.setTime(utilFromDate);
		calTo.setTime(utilToDate);

		java.sql.Date sqlFromDate = new java.sql.Date(calFrom.getTime()
				.getTime());
		java.sql.Date sqlToDate = new java.sql.Date(calTo.getTime().getTime());

		/*
		 * java.sql.Date sqlToDate = java.sql.Date.valueOf((String)
		 * map.get("toDate"));
		 */

		try {
			CallableStatement calstmt = conn
			.prepareCall("{call proc_to_from(?,?)}");

			calstmt.setDate("from_date", sqlFromDate);
			calstmt.setDate("to_date", sqlToDate);
			calstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return map;
	}

	public Map<String, Object> showIIBedStateReport(
			Map<String, Object> generalap) {
		List showList = new ArrayList();
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = session.connection();
		map.put("conn", conn);
		java.util.Date utilFromDate = (java.util.Date) generalap
		.get("fromDate");
		java.util.Date utilToDate = (java.util.Date) generalap.get("toDate");

		Calendar calFrom = Calendar.getInstance();
		Calendar calTo = Calendar.getInstance();
		calFrom.setTime(utilFromDate);
		calTo.setTime(utilToDate);

		java.sql.Date sqlFromDate = new java.sql.Date(calFrom.getTime()
				.getTime());
		java.sql.Date sqlToDate = new java.sql.Date(calTo.getTime().getTime());

		try {
			CallableStatement calstmt = conn
			.prepareCall("{call p_IIBedState(?,?)}");

			calstmt.setDate("from_date", sqlFromDate);
			calstmt.setDate("to_date", sqlToDate);
			calstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return map;
	}

	public Map<String, Object> chechBed(Map<String, Object> dataMap) {
		String regNo = "";
		String exists = "no";
		String type = "";
		List<Birthdeathreg> birthdeathregList = new ArrayList<Birthdeathreg>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (dataMap.get("regNo") != null) {
			regNo = "" + dataMap.get("regNo");
		}
		if (dataMap.get("type") != null) {
			type = "" + dataMap.get("type");
		}
		Session session = (Session) getSession();
		if (type.equalsIgnoreCase("birth")) {
			birthdeathregList = session.createCriteria(Birthdeathreg.class)
			.add(Restrictions.eq("Regno", regNo)).add(
					Restrictions.eq("Bdtype", "b")).list();
			if (birthdeathregList.size() > 0) {
				exists = "yes";
			}
		} else if (type.equalsIgnoreCase("death")) {
			birthdeathregList = session.createCriteria(Birthdeathreg.class)
			.add(Restrictions.eq("Regno", regNo)).add(
					Restrictions.eq("Bdtype", "d")).list();
			if (birthdeathregList.size() > 0) {
				exists = "yes";
			}
		}
		map.put("exists", exists);
		return map;
	}

	public List<Object> getExpiredAdmissionNumberList(
			Map<String, Object> detailsMap) {

		String serviceNo = "";
		String hinNo = "";
		String fatalCase = "";
		String onlyReport = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}
		if (detailsMap.get("fatalCase") != null) {
			fatalCase = (String) detailsMap.get("fatalCase");
		}
		if (detailsMap.get("onlyReport") != null) {
			onlyReport = (String) detailsMap.get("onlyReport");
		}
		List<Object> inpatientList = new ArrayList<Object>();

		try {
			if (!serviceNo.equals("")) {
				inpatientList = getHibernateTemplate().find(
						"from Inpatient ip join ip.Hin as p where p.ServiceNo = '"
						+ serviceNo + "'");
			}
			if (!hinNo.equals("")) {
				inpatientList = getHibernateTemplate().find(
						"from Inpatient ip join ip.Hin as p where  p.Id = '"
						+ hinNo + "'");
			}
			if (!fatalCase.equals("")) {
				inpatientList = getHibernateTemplate().find(
						"from ExpiryDetails e join e.Hin as p where p.HinNo = '"
						+ hinNo + "'");
			}
			// if(!onlyReport.equals("")){
			// inpatientList = getHibernateTemplate().find(
			// "from Birthdeathreg bd join bd.Hin as p where p.HinNo = '"
			// + hinNo + "'");
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
		return inpatientList;

	}

	public Map<String, Object> getHinAdNoDetailsFatalCase(
			Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		int hinId = 0;
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = "" + detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinId") != null) {
			hinId = Integer.parseInt("" + detailsMap.get("hinId"));
		}
		if (!serviceNo.equals("")) {
			/*patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).add(
					Restrictions.eq("PatientStatus", "Expired")).list();*/
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).list();
			map.put("patientList", patientList);
		}
		if (hinId != 0) {
			inpatientList = session.createCriteria(Inpatient.class)
			.createAlias("Hin", "pt").add(
					Restrictions.eq("pt.Id", hinId)).list();
			map.put("inpatientList", inpatientList);
		}

		return map;
	}

	public Map<String, Object> populateHinNo(Map<String, Object> dataMap) {
		String serviceNo = "";
		if (dataMap.get("serviceNo") != null) {
			serviceNo = "" + dataMap.get("serviceNo");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		inpatientList = session.createCriteria(Inpatient.class).createAlias(
				"Hin", "pt").add(Restrictions.eq("pt.ServiceNo", serviceNo))
				.add(Restrictions.ne("pt.PatientStatus", "Expired")).list();
		map.put("inpatientList", inpatientList);
		return map;
	}

	public Map<String, Object> getFRWDetails(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hinId = 0;
		if (dataMap.get("hinId") != null) {
			hinId = Integer.parseInt("" + dataMap.get("hinId"));
		}
		Session session = (Session) getSession();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Inpatient> misFrwList = new ArrayList<Inpatient>();
		inpatientList = session.createCriteria(Inpatient.class).createAlias(
				"Hin", "pt").add(Restrictions.eq("pt.Id", hinId)).list();

		misFrwList = session.createCriteria(MisFrw.class).add(
				Restrictions.eq("Hin.Id", hinId)).list();
		map.put("inpatientList", inpatientList);
		map.put("misFrwList", misFrwList);
		return map;
	}

	public Map<String, Object> getHinAdNoFatalPanchanama(
			Map<String, Object> detailsMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		int hinId = 0;
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = "" + detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinId") != null) {
			hinId = Integer.parseInt("" + detailsMap.get("hinId"));
		}
		if (!serviceNo.equals("")) {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).add(
							Restrictions.eq("PatientStatus", "Expired")).list();
			map.put("patientList", patientList);
		}
		if (hinId != 0) {
			inpatientList = session.createCriteria(Inpatient.class)
			.createAlias("Hin", "pt").add(
					Restrictions.eq("pt.Id", hinId)).add(
							Restrictions.eq("pt.PatientStatus", "Expired"))
							.list();
			map.put("inpatientList", inpatientList);
		}
		return map;

	}

	public Map<String, Object> showDeathInformation(
			Map<String, Object> detailsMap) {
		Session session = (Session) getSession();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<ExpiryDetails> expiryDetailsList = new ArrayList<ExpiryDetails>();
		int inpatientId = 0;
		if (detailsMap.get("inpatientId") != null) {
			inpatientId = Integer.parseInt("" + detailsMap.get("inpatientId"));
		}
		inpatientList = session.createCriteria(Inpatient.class).add(
				Restrictions.eq("Id", inpatientId)).list();
		expiryDetailsList = session.createCriteria(ExpiryDetails.class).add(
				Restrictions.eq("Inpatient.Id", inpatientId)).list();
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = session.connection();
		map.put("conn", conn);
		map.put("inpatientList", inpatientList);
		map.put("expiryDetailsList", expiryDetailsList);
		return map;
	}

	public Map<String, Object> showEDreports(Map<String, Object> map) {
		Session session = (Session) getSession();
		Map<String, Object> temp = new HashMap<String, Object>();
		Connection conn = session.connection();
		List<MasRankCategory> masRankCategoryList = new ArrayList<MasRankCategory>();
		masRankCategoryList = session.createCriteria(MasRankCategory.class)
		.add(Restrictions.eq("Status", "y")).list();
		map.put("conn", conn);
		map.put("masRankCategoryList", masRankCategoryList);
		return map;
	}

	public Map<String, Object> getHinNoForDeficient(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		String message = "";
		String respForm = "";
		int hospitalId=0;
		if (dataMap.get("serviceNo") != null) {
			serviceNo = "" + dataMap.get("serviceNo");
		}
		if (dataMap.get("respForm") != null) {
			respForm = "" + dataMap.get("respForm");
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+dataMap.get("hospitalId"));
		}
		Session session = (Session) getSession();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasUnit> presentUnitList = new ArrayList<MasUnit>();
		List<MasMedicalCategory> masMedicalList = new ArrayList<MasMedicalCategory>();
		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).list();
		unitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).list();
		tradeList = session.createCriteria(MasTrade.class).add(
				Restrictions.eq("Status", "y")).list();
		masMedicalList = session.createCriteria(MasMedicalCategory.class).add(
				Restrictions.eq("Status", "y")).list();
		empAfmsfDetList = session.createCriteria(EmpAfmsfDet.class).add(
				Restrictions.eq("ServiceNo", serviceNo)).add(
						Restrictions.eq("Hospital.Id", hospitalId)).list();

		bloodGroupList = session.createCriteria(MasBloodGroup.class).add(
				Restrictions.eq("Status", "y")).addOrder(Order.asc("BloodGroupName")).list();
		/*	List objectList = new ArrayList();
		objectList.add(31);
		objectList.add(184);
		objectList.add(160);
		objectList.add(59);

		presentUnitList = session.createCriteria(MasUnit.class).add(
				Restrictions.in("Id", objectList)).list();*/
		presentUnitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).list();
		if (empAfmsfDetList.size() > 0) {
			message = "This Personnel details already added";
		} else {
			message = "This Personnel not found";
		}
		map.put("message", message);
		map.put("employeeList", employeeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		map.put("masMedicalList", masMedicalList);
		map.put("empAfmsfDetList", empAfmsfDetList);
		map.put("presentUnitList", presentUnitList);
		map.put("bloodGroupList", bloodGroupList);
		return map;
	}

	public Map<String, Object> getHinNoForSurplus(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		if (dataMap.get("serviceNo") != null) {
			serviceNo = "" + dataMap.get("serviceNo");
		}
		Session session = (Session) getSession();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		tradeList = session.createCriteria(MasTrade.class).add(
				Restrictions.eq("Status", "y")).list();
		rankList = session.createCriteria(MasRank.class).add(
				Restrictions.eq("Status", "y")).list();
		unitList = session.createCriteria(MasUnit.class).add(
				Restrictions.eq("Status", "y")).list();
		empAfmsfDetList = session.createCriteria(EmpAfmsfDet.class).add(
				Restrictions.eq("AfmsfType", "D")).add(
						Restrictions.eq("ServiceNo", serviceNo)).list();
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		map.put("empAfmsfDetList", empAfmsfDetList);
		return map;

	}

	public Map<String, Object> showMisDailyReportJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		masDepartmentList = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("Status", "y")).list();
		map.put("masDepartmentList", masDepartmentList);
		return map;
	}

	public Map<String, Object> getHinAdNoForND(Map<String, Object> detailsMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		int hinId = 0;
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = "" + detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinId") != null) {
			hinId = Integer.parseInt("" + detailsMap.get("hinId"));
		}
		if (!serviceNo.equals("")) {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).list();
			map.put("patientList", patientList);
		}
		if (hinId != 0) {
			inpatientList = session.createCriteria(Inpatient.class)
			.createAlias("Hin", "pt").add(
					Restrictions.eq("pt.Id", hinId)).list();
			map.put("inpatientList", inpatientList);
		}
		return map;

	}
	public Map<String, Object> getHinNoForMalariaCase(Map<String,Object> detailsMap)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		String serviceNo = "";
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();

		if(detailsMap.get("serviceNo")!= null)

		{
			serviceNo = "" + detailsMap.get("serviceNo");

		}
		patientList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();

		map.put("patientList", patientList);
		map.put("serviceNo", serviceNo);
		return map;
	}

	public Map<String,Object> getHinNoForFoodHandler(Map<String,Object>   detailsMap)
	{

		Map<String,Object> map = new HashMap<String,Object>();
		String serviceNo = "";
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();

		if(detailsMap.get("serviceNo")!= null)

		{
			serviceNo = "" + detailsMap.get("serviceNo");

		}
		patientList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();

		map.put("patientList", patientList);
		map.put("serviceNo", serviceNo);
		return map;



	}

	public Map<String,Object> getPatientDetailForMalaria(Map<String,Object> mapForDS) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();	
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		String hinNo = (String) mapForDS.get("hinNo");
		@SuppressWarnings("unused")
		Patient patient = new Patient();
		int hinId=0;
		try{
			hinId=Integer.parseInt(hinNo);
		}catch(Exception e)
		{
			hinId=0;
		}
		patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
		//inpatientList= session.createCriteria(Inpatient.class).add(Restrictions.eq("Hin", hinId)).list();
		//String query = "select inpatient_id from Inpatient where hin_id="+hinId;
		inpatientList = session.createCriteria(Inpatient.class).add(
				Restrictions.eq("Hin.Id", hinId)).list();

		map.put("patientList", patientList);
		map.put("inpatientList", inpatientList);
		return map;
	}

	public Map<String,Object> getDoctorList(Map<String,Object> mapForDS)
	{  List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	int deptId = (Integer) mapForDS.get("deptId");
	int hospitalId = (Integer) mapForDS.get("hospitalId");
	doctorList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y"))
	.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId)).list();
	map.put("doctorList", doctorList);
	return map;
	}

	public Map<String, Object> getResponceForAME(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		String serviceNo ="";
		if(dataMap.get("serviceNo") !=null){
			serviceNo=""+dataMap.get("serviceNo"); 
		}
		Session session = (Session) getSession();
		List<AnnualMediacalExamination> annualMediacalExaminationList = new ArrayList<AnnualMediacalExamination>();
		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		List<MasMedicalCategory> masMedicalCategoryList = new ArrayList<MasMedicalCategory>();
		List<AmeLmc> ameLmcList = new ArrayList<AmeLmc>();
		List<AmeLmcHeader> ameLmcHList = new ArrayList<AmeLmcHeader>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<AmeLmcHeader> existAmeList = new ArrayList<AmeLmcHeader>();
		try{
			empAfmsfDetList =session.createCriteria(EmpAfmsfDet.class)
			.add(Restrictions.eq("AfmsfType", "IN"))
			.add(Restrictions.eq("ServiceNo", serviceNo)).list();

			empList = session.createCriteria(MasEmployee.class)
			.add(Restrictions.eq("ServiceNo", serviceNo))
			.add(Restrictions.eq("Status", "y")).list();

			annualMediacalExaminationList =session.createCriteria(AnnualMediacalExamination.class)
			.createAlias("AfmsfDet", "afmsfDet")
			.add(Restrictions.eq("afmsfDet.ServiceNo", serviceNo)).list();

			int ameId = 0;
			int ameLmcHId = 0;
			if(annualMediacalExaminationList.size() > 0){
				ameId = annualMediacalExaminationList.get(0).getId();
			}
			if(ameId >0){
				ameLmcHList = session.createCriteria(AmeLmcHeader.class).add(Restrictions.eq("Ame.Id", ameId))
				.add(Restrictions.eq("Status", "y")).list();
				if(ameLmcHList.size() > 0 ){
					ameLmcHId = ameLmcHList.get(0).getId();
				}
				if(ameLmcHId > 0){
					ameLmcList = session.createCriteria(AmeLmc.class).add(Restrictions.eq("LmcHeaderId.Id", ameLmcHId)).list();
				}
			}

			masMedicalCategoryList =session.createCriteria(MasMedicalCategory.class)
			.add(Restrictions.eq("Status", "y")).list();


			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();

			existAmeList = session.createCriteria(AmeLmcHeader.class).add(Restrictions.eq("Ame.Id", ameId))
			.add(Restrictions.eq("Status", "c")).list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("annualMediacalExaminationList", annualMediacalExaminationList);
		map.put("empAfmsfDetList", empAfmsfDetList);
		map.put("masMedicalCategoryList", masMedicalCategoryList);
		map.put("ameLmcList",ameLmcList);
		map.put("empList",empList);
		map.put("unitList",unitList);
		map.put("ameLmcHList", ameLmcHList);
		map.put("existAmeList",existAmeList);
		return map;
	}

	public Map<String, Object> getHiAdListForBD(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		int hinId = 0;
		String flag = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = "" + detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinId") != null) {
			hinId = Integer.parseInt("" + detailsMap.get("hinId"));
		}
		if (detailsMap.get("flag") != null) {
			flag = "" + detailsMap.get("flag");
		}
		Session session = (Session) getSession();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		if (flag.equals("hin")) {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).list();
		} else if (flag.equals("ad")) {
			inPatientList = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("Hin.Id", hinId)).list();
		}
		map.put("patientList", patientList);
		map.put("inPatientList", inPatientList);

		return map;
	}

	public Map<String, Object> printPMO(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		List<MisFrw> misFrwList = new ArrayList<MisFrw>();
		List<Patient> patientList = new ArrayList<Patient>();
		int hinId = 0;
		String serviceNo = null;
		String ad_no  = null;
		if (detailsMap.get("hin_id") != null) {
			hinId = Integer.parseInt("" + detailsMap.get("hin_id"));
		}
		if (detailsMap.get("serviceNo") != null
				&& !detailsMap.get("serviceNo").equals("")) {
			serviceNo = String.valueOf("" + detailsMap.get("serviceNo"));
		}

		if (detailsMap.get("ad_no") != null
				&& !detailsMap.get("ad_no").equals("")) {
			ad_no = String.valueOf("" + detailsMap.get("ad_no"));
		}


		/*if (serviceNo != null) {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).list();
			Patient patient = (Patient) patientList.get(0);
			hinId = patient.getId();
		}*/

		/*misFrwList = session.createCriteria(MisFrw.class).add(
				Restrictions.eq("Hin.Id", hinId)).list();*/

		misFrwList = session.createCriteria(MisFrw.class).add(
				Restrictions.eq("AdNo", ad_no)).list();


		map.put("conn", con);
		map.put("misFrwList", misFrwList);
		map.put("hinId", hinId);
		return map;
	}

	public Map<String, Object> bedStatisticsSummary(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		String fromDate = "";
		String toDate = "";
		Session session = (Session) getSession();
		if (dataMap.get("fromDate") != null) {
			fromDate = "" + dataMap.get("fromDate");
		}
		if (dataMap.get("toDate") != null) {
			toDate = "" + dataMap.get("toDate");
		}
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL = null;
		try {
			date4MySQL = formatterOut.format(formatterIn.parse(fromDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.sql.Date FROM_DATE = java.sql.Date.valueOf(date4MySQL);

		SimpleDateFormat formatterIn2 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut2 = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL2 = null;
		try {
			date4MySQL2 = formatterOut2.format(formatterIn2.parse(toDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.sql.Date TO_DATE = java.sql.Date.valueOf(date4MySQL2);

		List objectList1 = new ArrayList();
		List objectList2 = new ArrayList();
		try {
			String idqry = "select distinct(date_of_addmission) from inpatient where date_of_addmission between '"
				+ FROM_DATE
				+ "' and '"
				+ TO_DATE
				+ "' order by date_of_addmission";

			objectList1 = (List) session.createSQLQuery(idqry).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		BigDecimal no_days_of_month = new BigDecimal("0");
		String qry = "";
		BigDecimal off_max = new BigDecimal("0");
		BigDecimal off_total = new BigDecimal("0");
		BigDecimal off_avg = new BigDecimal("0");

		BigDecimal off_fam_max = new BigDecimal("0");
		BigDecimal off_fam_total = new BigDecimal("0");
		BigDecimal off_fam_avg = new BigDecimal("0");

		BigDecimal ors_max = new BigDecimal("0");
		BigDecimal ors_total = new BigDecimal("0");
		BigDecimal ors_avg = new BigDecimal("0");

		BigDecimal ors_fam_max = new BigDecimal("0");
		BigDecimal ors_fam_total = new BigDecimal("0");
		BigDecimal ors_fam_avg = new BigDecimal("0");

		BigDecimal af_max = new BigDecimal("0");
		BigDecimal af_min = new BigDecimal("0");
		BigDecimal af_avg = new BigDecimal("0");

		BigDecimal army_max = new BigDecimal("0");
		BigDecimal army_min = new BigDecimal("0");
		BigDecimal army_avg = new BigDecimal("0");

		BigDecimal navy_max = new BigDecimal("0");
		BigDecimal navy_min = new BigDecimal("0");
		BigDecimal navy_avg = new BigDecimal("0");

		BigDecimal total_death = new BigDecimal("0");
		BigDecimal total_death_avg = new BigDecimal("0");

		BigDecimal total_adm = new BigDecimal("0");
		BigDecimal total_adm_avg = new BigDecimal("0");

		BigDecimal total_discharge = new BigDecimal("0");
		BigDecimal total_discharge_avg = new BigDecimal("0");

		BigDecimal stay_of_patient_total = new BigDecimal("0");
		BigDecimal stay_of_patient_avg = new BigDecimal("0");

		BigDecimal occupency_rate_avg = new BigDecimal("0");
		BigDecimal min_bed = new BigDecimal("0");
		BigDecimal max_bed = new BigDecimal("0");
		BigDecimal internal_turnover = new BigDecimal("0");
		for (int i = 0; i < objectList1.size(); i++) {
			qry = " select  d.REMD,ADM,b.Death,c.DIS - ifnull(b.Death,0) as DIS,ifnull(a.ADM,0) + ifnull(d.REMD,0) - ifnull(c.DIS,0) as TOT"
				+ " ,e.OFF_AF,f.OFF_ARMY,g.OFF_NAVY,ifnull(e.OFF_AF,0)+ifnull(f.OFF_ARMY,0)+ifnull(g.OFF_NAVY,0)AS OFF_TOT,"
				+ " h.OFF_FAM_AF,i.OFF_FAM_ARMY,j.OFF_FAM_NAVY,ifnull(h.OFF_FAM_AF,0)+ifnull(i.OFF_FAM_ARMY,0)+ifnull(OFF_FAM_NAVY,0)AS OFF_FAM_TOT"
				+ " ,k.ORS_AF,l.ORS_ARMY,m.ORS_NAVY,ifnull(k.ORS_AF,0)+ifnull(l.ORS_ARMY,0)+ifnull(m.ORS_NAVY,0)AS ORS_TOT,"
				+ "  n.ORS_FAM_AF,o.ORS_FAM_ARMY,p.ORS_FAM_NAVY,ifnull(n.ORS_FAM_AF,0)+ifnull(o.ORS_FAM_ARMY,0)+ifnull(p.ORS_FAM_NAVY,0)AS ORS_FAM_TOT,"
				+

				" ifnull(e.OFF_AF,0) + ifnull(h.OFF_FAM_AF,0)+ifnull(k.ORS_AF,0) + ifnull(n.ORS_FAM_AF,0) AS AF_TOT,"
				+ " ifnull(f.OFF_ARMY,0) + ifnull(i.OFF_FAM_ARMY,0) + ifnull(l.ORS_ARMY,0) + ifnull(o.ORS_FAM_ARMY,0) AS ARMY_TOT,"
				+ " ifnull(g.OFF_NAVY,0) + ifnull(j.OFF_FAM_NAVY,0)+ifnull(m.ORS_NAVY,0) + ifnull(p.ORS_FAM_NAVY,0) AS NAVY_TOT,"
				+ " q.CE_NE AS CE_NE,r.FORG,ifnull(e.OFF_AF,0)+ifnull(h.OFF_FAM_AF,0)+ifnull(k.ORS_AF,0)+ifnull(n.ORS_FAM_AF,0)"
				+ " +ifnull(f.OFF_ARMY,0)+ifnull(i.OFF_FAM_ARMY,0)+ifnull(l.ORS_ARMY,0)+ifnull(o.ORS_FAM_ARMY,0)"
				+ " +ifnull(g.OFF_NAVY,0)+ifnull(j.OFF_FAM_NAVY,0)+ifnull(m.ORS_NAVY,0)+ifnull(p.ORS_FAM_NAVY,0)"
				+ " +ifnull(CE_NE,0)+ifnull(r.FORG,0) AS FINAL_TOT"
				+ " from "
				+ " (SELECT count(*) as ADM FROM inpatient inpatient  where inpatient.date_of_addmission = '"
				+ objectList1.get(i)
				+ "' and inpatient.ad_status !='C') a,"
				+ " (SELECT count(*) as Death FROM expiry_details expiry_details where expiry_details.expiry_date  = '"
				+ objectList1.get(i)
				+ "'  ) b,"
				+ " (SELECT count(*) as DIS FROM discharge discharge where discharge.date_of_discharge = '"
				+ objectList1.get(i)
				+ "') c,"
				+ " (SELECT count(*) as REMD FROM "
				+ " inpatient inp2 where inp2.date_of_addmission <= DATE_ADD('"
				+ objectList1.get(i)
				+ "',INTERVAL '-1'DAY)  and DATE_ADD('"
				+ objectList1.get(i)
				+ "',INTERVAL '0' DAY) <= ifNull(inp2.discharge_date,NOW()) and inp2.ad_status !='C') d,"
				+

				" (SELECT count(*) as OFF_AF FROM inpatient inp3 "
				+ " LEFT OUTER JOIN patient patient1 ON inp3.`hin_id` = patient1.`hin_id`"
				+ " left outer JOIN mas_rank rank1 ON rank1.`rank_id` = patient1.`rank_id`"
				+ " where inp3.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp3.discharge_date,NOW() ) and inp3.ad_status !='C' "
				+ " and rank1.`rank_category_id` =1 and patient1.`relation_id` =8 and patient1.`service_type_id` =2) e,"
				+

				"(SELECT count(*) as OFF_ARMY FROM inpatient inp4 "
				+ " LEFT OUTER JOIN patient patient2 ON inp4.`hin_id` = patient2.`hin_id`"
				+ " left outer JOIN mas_rank rank2 ON rank2.`rank_id` = patient2.`rank_id`"
				+ " where inp4.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp4.discharge_date,NOW()) "
				+ " and rank2.`rank_category_id` =1 and patient2.`relation_id` =8 and patient2.`service_type_id` =1 and inp4.ad_status !='C') f,"
				+

				"(SELECT count(*) as OFF_NAVY FROM inpatient inp5 "
				+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id`"
				+ " left outer JOIN mas_rank rank3 ON rank3.`rank_id` = patient3.`rank_id`"
				+ " where inp5.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C' "
				+ " and rank3.`rank_category_id` =1 and patient3.`relation_id` =8 and patient3.`service_type_id` IN (4,6)) g,"
				+

				"(SELECT count(*) as OFF_FAM_AF FROM inpatient inp3 "
				+ " LEFT OUTER JOIN patient patient1 ON inp3.`hin_id` = patient1.`hin_id`"
				+ " left outer JOIN mas_rank rank1 ON rank1.`rank_id` = patient1.`rank_id`"
				+ " where inp3.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp3.discharge_date,NOW()) and inp3.ad_status !='C' "
				+ " and rank1.`rank_category_id` =1 and patient1.`relation_id` !=8 and patient1.`service_type_id` =2) h,"
				+

				"(SELECT count(*) as OFF_FAM_ARMY FROM inpatient inp4 "
				+ " LEFT OUTER JOIN patient patient2 ON inp4.`hin_id` = patient2.`hin_id`"
				+ " left outer JOIN mas_rank rank2 ON rank2.`rank_id` = patient2.`rank_id`"
				+ " where inp4.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp4.discharge_date,NOW())  and inp4.ad_status !='C' "
				+ " and rank2.`rank_category_id` =1 and patient2.`relation_id`!=8 and patient2.`service_type_id` =1) i,"
				+

				"(SELECT count(*) as OFF_FAM_NAVY FROM inpatient inp5 "
				+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id`"
				+ " left outer JOIN mas_rank rank3 ON rank3.`rank_id` = patient3.`rank_id`"
				+ " where inp5.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C' "
				+ " and rank3.`rank_category_id` =1 and patient3.`relation_id` !=8 and patient3.`service_type_id` IN (4,6)) j,"
				+

				"(SELECT count(*) as ORS_AF FROM inpatient inp3 "
				+ " LEFT OUTER JOIN patient patient1 ON inp3.`hin_id` = patient1.`hin_id`"
				+ " left outer JOIN mas_rank rank1 ON rank1.`rank_id` = patient1.`rank_id`"
				+ " where inp3.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp3.discharge_date,NOW()) and inp3.ad_status !='C' "
				+ " and rank1.`rank_category_id` !=1 and patient1.`relation_id` =8 and patient1.`service_type_id` =2) k,"
				+

				"(SELECT count(*) as ORS_ARMY FROM inpatient inp4 "
				+ " LEFT OUTER JOIN patient patient2 ON inp4.`hin_id` = patient2.`hin_id`"
				+ " left outer JOIN mas_rank rank2 ON rank2.`rank_id` = patient2.`rank_id`"
				+ " where inp4.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "'and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp4.discharge_date,NOW()) and inp4.ad_status !='C' "
				+ " and rank2.`rank_category_id` !=1 and patient2.`relation_id` =8 and patient2.`service_type_id` =1) l,"
				+

				"(SELECT count(*) as ORS_NAVY FROM inpatient inp5 "
				+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id`"
				+ " left outer JOIN mas_rank rank3 ON rank3.`rank_id` = patient3.`rank_id`"
				+ " where inp5.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C' "
				+ " and rank3.`rank_category_id` !=1 and patient3.`relation_id` =8 and patient3.`service_type_id` IN (4,6)) m,"
				+

				"(SELECT count(*) as ORS_FAM_AF FROM inpatient inp3 "
				+ " LEFT OUTER JOIN patient patient1 ON inp3.`hin_id` = patient1.`hin_id`"
				+ " left outer JOIN mas_rank rank1 ON rank1.`rank_id` = patient1.`rank_id`"
				+ " where inp3.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp3.discharge_date,NOW()) and inp3.ad_status !='C'"
				+ " and rank1.`rank_category_id` !=1 and patient1.`relation_id` !=8 and patient1.`service_type_id` =2) n,"
				+

				"(SELECT count(*) as ORS_FAM_ARMY FROM inpatient inp4 "
				+ " LEFT OUTER JOIN patient patient2 ON inp4.`hin_id` = patient2.`hin_id`"
				+ " left outer JOIN mas_rank rank2 ON rank2.`rank_id` = patient2.`rank_id`"
				+ " where inp4.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp4.discharge_date,NOW()) and inp4.ad_status !='C' "
				+ " and rank2.`rank_category_id` !=1 and patient2.`relation_id`!=8 and patient2.`service_type_id` =1)o,"
				+

				"(SELECT count(*) as ORS_FAM_NAVY FROM inpatient inp5 "
				+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id`"
				+ " left outer JOIN mas_rank rank3 ON rank3.`rank_id` = patient3.`rank_id`"
				+ " where inp5.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C'"
				+ " and rank3.`rank_category_id` !=1 and patient3.`relation_id` !=8 and patient3.`service_type_id`IN (4,6)) p,"
				+

				"(SELECT count(*) as CE_NE FROM inpatient inp5 "
				+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id` and inp5.ad_status !='C'"
				+

				"where inp5.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C'"
				+ "and  patient3.`service_type_id` IN (3,7)) q,"
				+

				"(SELECT count(*) as FORG FROM inpatient inp5 "
				+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id`"
				+ "  where inp5.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C'"
				+ " and  patient3.`service_type_id` =5) r";
			no_days_of_month = no_days_of_month.add(new BigDecimal("1"));
			objectList2 = (List) session.createSQLQuery(qry).list();
			// for (Iterator iterator = objectList2.iterator();
			// iterator.hasNext();) {
			Object[] object = (Object[]) objectList2.get(0);

			// Block for officers Calculation
			if (off_max.compareTo(new BigDecimal("0")) == 0) {
				off_max = new BigDecimal("" + object[8]);
			} else if (off_max.compareTo(new BigDecimal("" + object[8])) == -1)
				off_max = new BigDecimal("" + object[8]);
			off_total = off_total.add(new BigDecimal("" + object[8]));

			// Block for officers family Calculation
			if (off_fam_max.compareTo(new BigDecimal("0")) == 0) {
				off_fam_max = new BigDecimal("" + object[12]);
			} else if (off_fam_max.compareTo(new BigDecimal("" + object[12])) == -1)
				off_fam_max = new BigDecimal("" + object[12]);
			off_fam_total = off_fam_total.add(new BigDecimal("" + object[12]));

			// Block for ors Calculation
			if (ors_max.compareTo(new BigDecimal("0")) == 0) {
				ors_max = new BigDecimal("" + object[16]);
			} else if (ors_max.compareTo(new BigDecimal("" + object[16])) == -1)
				ors_max = new BigDecimal("" + object[16]);
			ors_total = ors_total.add(new BigDecimal("" + object[16]));

			// Block for ors family Calculation
			if (ors_fam_max.compareTo(new BigDecimal("0")) == 0) {
				ors_fam_max = new BigDecimal("" + object[20]);
			} else if (ors_fam_max.compareTo(new BigDecimal("" + object[20])) == -1)
				ors_fam_max = new BigDecimal("" + object[20]);
			ors_fam_total = ors_fam_total.add(new BigDecimal("" + object[20]));

			// Block for AF Calculation
			if (af_min.compareTo(new BigDecimal("0")) == 0) {
				af_min = new BigDecimal("" + object[21]);
			} else if (af_min.compareTo(new BigDecimal("" + object[21])) == 1)
				af_min = new BigDecimal("" + object[21]);

			if (af_max.compareTo(new BigDecimal("" + object[21])) == -1)
				af_max = new BigDecimal("" + object[21]);

			// Block for Army Calculation
			if (army_min.compareTo(new BigDecimal("0")) == 0) {
				army_min = new BigDecimal("" + object[22]);
			} else if (army_min.compareTo(new BigDecimal("" + object[22])) == 1)
				army_min = new BigDecimal("" + object[22]);

			if (army_max.compareTo(new BigDecimal("" + object[22])) == -1)
				army_max = new BigDecimal("" + object[22]);

			// Block for Navy Calculation
			if (navy_min.compareTo(new BigDecimal("0")) == 0) {
				navy_min = new BigDecimal("" + object[23]);
			} else if (navy_min.compareTo(new BigDecimal("" + object[23])) == 1)
				navy_min = new BigDecimal("" + object[23]);

			if (navy_max.compareTo(new BigDecimal("" + object[23])) == -1)
				navy_max = new BigDecimal("" + object[23]);

			// Block for Navy Calculation
			total_death = total_death.add(new BigDecimal("" + object[3]));

			// Block for ADM Calculation
			total_adm = total_adm.add(new BigDecimal("" + object[1]));

			// Block for Discharge Calculation
			total_discharge = total_discharge
			.add(new BigDecimal("" + object[2]));

			// Block for stay of patient Calculation

			if (af_min.compareTo(new BigDecimal("0")) == 0) {
				min_bed = new BigDecimal("" + object[26]);
			} else if (af_min.compareTo(new BigDecimal("" + object[26])) == 1)
				min_bed = new BigDecimal("" + object[26]);
			if (max_bed.compareTo(new BigDecimal("" + object[26])) == -1)
				max_bed = new BigDecimal("" + object[26]);
			stay_of_patient_total = stay_of_patient_total.add(new BigDecimal(""
					+ object[26]));

			// }
		}
		// Final Caluculation
		off_avg = off_total.divide(no_days_of_month, 2, 0);
		off_fam_avg = off_fam_total.divide(no_days_of_month, 2, 0);
		ors_avg = ors_total.divide(no_days_of_month, 2, 0);
		ors_fam_avg = ors_fam_total.divide(no_days_of_month, 2, 0);
		af_avg = af_min.add(af_max).divide(new BigDecimal("2"), 2, 0);
		army_avg = army_min.add(army_max).divide(new BigDecimal("2"), 2, 0);
		navy_avg = navy_min.add(navy_max).divide(new BigDecimal("2"), 2, 0);
		BigDecimal af_army_navy_min = new BigDecimal("0");
		BigDecimal af_army_navy_max = new BigDecimal("0");
		af_army_navy_min = af_army_navy_min.add(af_min.add(army_min).add(
				navy_min));
		af_army_navy_max = af_army_navy_max.add(af_max.add(army_max).add(
				navy_max));
		BigDecimal death_avg = new BigDecimal("0");
		death_avg = total_death.divide(no_days_of_month, 2, 0);
		BigDecimal adm_avg = new BigDecimal("0");
		adm_avg = total_adm.divide(no_days_of_month, 2, 0);
		BigDecimal discharge_avg = new BigDecimal("0");
		discharge_avg = total_discharge.divide(no_days_of_month, 2, 0);
		stay_of_patient_avg = stay_of_patient_total.divide(total_discharge
				.add(total_adm), 2, 0);

		occupency_rate_avg = stay_of_patient_total.divide(
				no_days_of_month.multiply(new BigDecimal("800")), 2, 0)
				.multiply(new BigDecimal("100"));
		try {
			internal_turnover = no_days_of_month
			.multiply(new BigDecimal("800")).subtract(
					stay_of_patient_total).divide(
							total_discharge.add(total_death), 2, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("off_max", off_max);
		map.put("off_avg", off_avg);
		map.put("off_fam_max", off_fam_max);
		map.put("off_fam_avg", off_fam_avg);
		map.put("ors_max", ors_max);
		map.put("ors_avg", ors_avg);
		map.put("ors_fam_max", ors_fam_max);
		map.put("ors_fam_avg", ors_fam_avg);

		map.put("af_min", af_min);
		map.put("af_max", af_max);
		map.put("af_avg", af_avg);

		map.put("army_min", army_min);
		map.put("army_max", army_max);
		map.put("army_avg", army_avg);

		map.put("navy_min", navy_min);
		map.put("navy_max", navy_max);
		map.put("navy_avg", navy_avg);

		map.put("total_death", total_death);
		map.put("total_death_avg", death_avg);

		map.put("total_adm", total_adm);
		map.put("total_adm_avg", adm_avg);

		map.put("total_discharge", total_discharge);
		map.put("total_discharge_avg", discharge_avg);

		map.put("stay_of_patient_avg", stay_of_patient_avg);
		map.put("occupency_rate_avg", occupency_rate_avg);
		map.put("min_bed", min_bed);
		map.put("max_bed", max_bed);
		map.put("internal_turnover", internal_turnover);

		return map;
	}

	public Map<String, Object> bedStatisticsTotDetails(
			Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		String fromDate = "";
		String toDate = "";
		Session session = (Session) getSession();
		if (dataMap.get("fromDate") != null) {
			fromDate = "" + dataMap.get("fromDate");
		}
		if (dataMap.get("toDate") != null) {
			toDate = "" + dataMap.get("toDate");
		}
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL = null;
		try {
			date4MySQL = formatterOut.format(formatterIn.parse(fromDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.sql.Date FROM_DATE = java.sql.Date.valueOf(date4MySQL);
		SimpleDateFormat formatterIn2 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut2 = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL2 = null;
		try {
			date4MySQL2 = formatterOut2.format(formatterIn2.parse(toDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.sql.Date TO_DATE = java.sql.Date.valueOf(date4MySQL2);

		List objectList1 = new ArrayList();
		List objectList2 = new ArrayList();
		try {
			String idqry = "select distinct(date_of_addmission) from inpatient where date_of_addmission between '"
				+ FROM_DATE
				+ "' and '"
				+ TO_DATE
				+ "' order by date_of_addmission";

			objectList1 = (List) session.createSQLQuery(idqry).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		BigDecimal no_days_of_month = new BigDecimal("0");
		String qry = "";
		BigDecimal off_max = new BigDecimal("0");
		BigDecimal off_total = new BigDecimal("0");
		BigDecimal off_avg = new BigDecimal("0");

		BigDecimal off_fam_max = new BigDecimal("0");
		BigDecimal off_fam_total = new BigDecimal("0");
		BigDecimal off_fam_avg = new BigDecimal("0");

		BigDecimal ors_max = new BigDecimal("0");
		BigDecimal ors_total = new BigDecimal("0");
		BigDecimal ors_avg = new BigDecimal("0");

		BigDecimal ors_fam_max = new BigDecimal("0");
		BigDecimal ors_fam_total = new BigDecimal("0");
		BigDecimal ors_fam_avg = new BigDecimal("0");

		BigDecimal af_max = new BigDecimal("0");
		BigDecimal af_min = new BigDecimal("0");
		BigDecimal af_avg = new BigDecimal("0");

		BigDecimal army_max = new BigDecimal("0");
		BigDecimal army_min = new BigDecimal("0");
		BigDecimal army_avg = new BigDecimal("0");

		BigDecimal navy_max = new BigDecimal("0");
		BigDecimal navy_min = new BigDecimal("0");
		BigDecimal navy_avg = new BigDecimal("0");

		BigDecimal total_death = new BigDecimal("0");
		BigDecimal total_death_avg = new BigDecimal("0");

		BigDecimal total_adm = new BigDecimal("0");
		BigDecimal total_adm_avg = new BigDecimal("0");

		BigDecimal total_discharge = new BigDecimal("0");
		BigDecimal total_discharge_avg = new BigDecimal("0");

		BigDecimal stay_of_patient_total = new BigDecimal("0");
		BigDecimal stay_of_patient_avg = new BigDecimal("0");

		BigDecimal occupency_rate_avg = new BigDecimal("0");
		BigDecimal min_bed = new BigDecimal("0");
		BigDecimal max_bed = new BigDecimal("0");
		BigDecimal internal_turnover = new BigDecimal("0");
		for (int i = 0; i < objectList1.size(); i++) {
			qry = " select  d.REMD,ADM,b.Death,c.DIS - ifnull(b.Death,0) as DIS,ifnull(a.ADM,0) + ifnull(d.REMD,0) - ifnull(c.DIS,0) as TOT"
				+ " ,e.OFF_AF,f.OFF_ARMY,g.OFF_NAVY,ifnull(e.OFF_AF,0)+ifnull(f.OFF_ARMY,0)+ifnull(g.OFF_NAVY,0)AS OFF_TOT,"
				+ " h.OFF_FAM_AF,i.OFF_FAM_ARMY,j.OFF_FAM_NAVY,ifnull(h.OFF_FAM_AF,0)+ifnull(i.OFF_FAM_ARMY,0)+ifnull(OFF_FAM_NAVY,0)AS OFF_FAM_TOT"
				+ " ,k.ORS_AF,l.ORS_ARMY,m.ORS_NAVY,ifnull(k.ORS_AF,0)+ifnull(l.ORS_ARMY,0)+ifnull(m.ORS_NAVY,0)AS ORS_TOT,"
				+ "  n.ORS_FAM_AF,o.ORS_FAM_ARMY,p.ORS_FAM_NAVY,ifnull(n.ORS_FAM_AF,0)+ifnull(o.ORS_FAM_ARMY,0)+ifnull(p.ORS_FAM_NAVY,0)AS ORS_FAM_TOT,"
				+

				" ifnull(e.OFF_AF,0) + ifnull(h.OFF_FAM_AF,0)+ifnull(k.ORS_AF,0) + ifnull(n.ORS_FAM_AF,0) AS AF_TOT,"
				+ " ifnull(f.OFF_ARMY,0) + ifnull(i.OFF_FAM_ARMY,0) + ifnull(l.ORS_ARMY,0) + ifnull(o.ORS_FAM_ARMY,0) AS ARMY_TOT,"
				+ " ifnull(g.OFF_NAVY,0) + ifnull(j.OFF_FAM_NAVY,0)+ifnull(m.ORS_NAVY,0) + ifnull(p.ORS_FAM_NAVY,0) AS NAVY_TOT,"
				+ " q.CE_NE AS CE_NE,r.FORG,ifnull(e.OFF_AF,0)+ifnull(h.OFF_FAM_AF,0)+ifnull(k.ORS_AF,0)+ifnull(n.ORS_FAM_AF,0)"
				+ " +ifnull(f.OFF_ARMY,0)+ifnull(i.OFF_FAM_ARMY,0)+ifnull(l.ORS_ARMY,0)+ifnull(o.ORS_FAM_ARMY,0)"
				+ " +ifnull(g.OFF_NAVY,0)+ifnull(j.OFF_FAM_NAVY,0)+ifnull(m.ORS_NAVY,0)+ifnull(p.ORS_FAM_NAVY,0)"
				+ " +ifnull(CE_NE,0)+ifnull(r.FORG,0) AS FINAL_TOT"
				+ " from "
				+ " (SELECT count(*) as ADM FROM inpatient inpatient  where inpatient.date_of_addmission = '"
				+ objectList1.get(i)
				+ "' and inpatient.ad_status !='C') a,"
				+ " (SELECT count(*) as Death FROM expiry_details expiry_details where expiry_details.expiry_date  = '"
				+ objectList1.get(i)
				+ "'  ) b,"
				+ " (SELECT count(*) as DIS FROM discharge discharge where discharge.date_of_discharge = '"
				+ objectList1.get(i)
				+ "') c,"
				+ " (SELECT count(*) as REMD FROM "
				+ " inpatient inp2 where inp2.date_of_addmission <= DATE_ADD('"
				+ objectList1.get(i)
				+ "',INTERVAL '-1'DAY)  and DATE_ADD('"
				+ objectList1.get(i)
				+ "',INTERVAL '0' DAY) <= ifNull(inp2.discharge_date,NOW()) and inp2.ad_status !='C') d,"
				+

				" (SELECT count(*) as OFF_AF FROM inpatient inp3 "
				+ " LEFT OUTER JOIN patient patient1 ON inp3.`hin_id` = patient1.`hin_id`"
				+ " left outer JOIN mas_rank rank1 ON rank1.`rank_id` = patient1.`rank_id`"
				+ " where inp3.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp3.discharge_date,NOW() ) and inp3.ad_status !='C' "
				+ " and rank1.`rank_category_id` =1 and patient1.`relation_id` =8 and patient1.`service_type_id` =2) e,"
				+

				"(SELECT count(*) as OFF_ARMY FROM inpatient inp4 "
				+ " LEFT OUTER JOIN patient patient2 ON inp4.`hin_id` = patient2.`hin_id`"
				+ " left outer JOIN mas_rank rank2 ON rank2.`rank_id` = patient2.`rank_id`"
				+ " where inp4.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp4.discharge_date,NOW()) "
				+ " and rank2.`rank_category_id` =1 and patient2.`relation_id` =8 and patient2.`service_type_id` =1 and inp4.ad_status !='C') f,"
				+

				"(SELECT count(*) as OFF_NAVY FROM inpatient inp5 "
				+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id`"
				+ " left outer JOIN mas_rank rank3 ON rank3.`rank_id` = patient3.`rank_id`"
				+ " where inp5.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C' "
				+ " and rank3.`rank_category_id` =1 and patient3.`relation_id` =8 and patient3.`service_type_id` IN (4,6)) g,"
				+

				"(SELECT count(*) as OFF_FAM_AF FROM inpatient inp3 "
				+ " LEFT OUTER JOIN patient patient1 ON inp3.`hin_id` = patient1.`hin_id`"
				+ " left outer JOIN mas_rank rank1 ON rank1.`rank_id` = patient1.`rank_id`"
				+ " where inp3.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp3.discharge_date,NOW()) and inp3.ad_status !='C' "
				+ " and rank1.`rank_category_id` =1 and patient1.`relation_id` !=8 and patient1.`service_type_id` =2) h,"
				+

				"(SELECT count(*) as OFF_FAM_ARMY FROM inpatient inp4 "
				+ " LEFT OUTER JOIN patient patient2 ON inp4.`hin_id` = patient2.`hin_id`"
				+ " left outer JOIN mas_rank rank2 ON rank2.`rank_id` = patient2.`rank_id`"
				+ " where inp4.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp4.discharge_date,NOW())  and inp4.ad_status !='C' "
				+ " and rank2.`rank_category_id` =1 and patient2.`relation_id`!=8 and patient2.`service_type_id` =1) i,"
				+

				"(SELECT count(*) as OFF_FAM_NAVY FROM inpatient inp5 "
				+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id`"
				+ " left outer JOIN mas_rank rank3 ON rank3.`rank_id` = patient3.`rank_id`"
				+ " where inp5.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C' "
				+ " and rank3.`rank_category_id` =1 and patient3.`relation_id` !=8 and patient3.`service_type_id` IN (4,6)) j,"
				+

				"(SELECT count(*) as ORS_AF FROM inpatient inp3 "
				+ " LEFT OUTER JOIN patient patient1 ON inp3.`hin_id` = patient1.`hin_id`"
				+ " left outer JOIN mas_rank rank1 ON rank1.`rank_id` = patient1.`rank_id`"
				+ " where inp3.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp3.discharge_date,NOW()) and inp3.ad_status !='C' "
				+ " and rank1.`rank_category_id` !=1 and patient1.`relation_id` =8 and patient1.`service_type_id` =2) k,"
				+

				"(SELECT count(*) as ORS_ARMY FROM inpatient inp4 "
				+ " LEFT OUTER JOIN patient patient2 ON inp4.`hin_id` = patient2.`hin_id`"
				+ " left outer JOIN mas_rank rank2 ON rank2.`rank_id` = patient2.`rank_id`"
				+ " where inp4.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "'and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp4.discharge_date,NOW()) and inp4.ad_status !='C' "
				+ " and rank2.`rank_category_id` !=1 and patient2.`relation_id` =8 and patient2.`service_type_id` =1) l,"
				+

				"(SELECT count(*) as ORS_NAVY FROM inpatient inp5 "
				+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id`"
				+ " left outer JOIN mas_rank rank3 ON rank3.`rank_id` = patient3.`rank_id`"
				+ " where inp5.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C' "
				+ " and rank3.`rank_category_id` !=1 and patient3.`relation_id` =8 and patient3.`service_type_id` IN (4,6)) m,"
				+

				"(SELECT count(*) as ORS_FAM_AF FROM inpatient inp3 "
				+ " LEFT OUTER JOIN patient patient1 ON inp3.`hin_id` = patient1.`hin_id`"
				+ " left outer JOIN mas_rank rank1 ON rank1.`rank_id` = patient1.`rank_id`"
				+ " where inp3.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp3.discharge_date,NOW()) and inp3.ad_status !='C'"
				+ " and rank1.`rank_category_id` !=1 and patient1.`relation_id` !=8 and patient1.`service_type_id` =2) n,"
				+

				"(SELECT count(*) as ORS_FAM_ARMY FROM inpatient inp4 "
				+ " LEFT OUTER JOIN patient patient2 ON inp4.`hin_id` = patient2.`hin_id`"
				+ " left outer JOIN mas_rank rank2 ON rank2.`rank_id` = patient2.`rank_id`"
				+ " where inp4.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp4.discharge_date,NOW()) and inp4.ad_status !='C' "
				+ " and rank2.`rank_category_id` !=1 and patient2.`relation_id`!=8 and patient2.`service_type_id` =1)o,"
				+

				"(SELECT count(*) as ORS_FAM_NAVY FROM inpatient inp5 "
				+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id`"
				+ " left outer JOIN mas_rank rank3 ON rank3.`rank_id` = patient3.`rank_id`"
				+ " where inp5.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C'"
				+ " and rank3.`rank_category_id` !=1 and patient3.`relation_id` !=8 and patient3.`service_type_id`IN (4,6)) p,"
				+

				"(SELECT count(*) as CE_NE FROM inpatient inp5 "
				+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id` and inp5.ad_status !='C'"
				+

				"where inp5.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C'"
				+ "and  patient3.`service_type_id` IN (3,7)) q,"
				+

				"(SELECT count(*) as FORG FROM inpatient inp5 "
				+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id`"
				+ "  where inp5.date_of_addmission <= '"
				+ objectList1.get(i)
				+ "' and '"
				+ objectList1.get(i)
				+ "' < ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C'"
				+ " and  patient3.`service_type_id` =5) r";
			no_days_of_month = no_days_of_month.add(new BigDecimal("1"));
			objectList2 = (List) session.createSQLQuery(qry).list();
			// for (Iterator iterator = objectList2.iterator();
			// iterator.hasNext();) {
			Object[] object = (Object[]) objectList2.get(0);

			// Block for officers Calculation
			if (off_max.compareTo(new BigDecimal("0")) == 0) {
				off_max = new BigDecimal("" + object[8]);
			} else if (off_max.compareTo(new BigDecimal("" + object[8])) == -1)
				off_max = new BigDecimal("" + object[8]);
			off_total = off_total.add(new BigDecimal("" + object[8]));

			// Block for officers family Calculation
			if (off_fam_max.compareTo(new BigDecimal("0")) == 0) {
				off_fam_max = new BigDecimal("" + object[12]);
			} else if (off_fam_max.compareTo(new BigDecimal("" + object[12])) == -1)
				off_fam_max = new BigDecimal("" + object[12]);
			off_fam_total = off_fam_total.add(new BigDecimal("" + object[12]));

			// Block for ors Calculation
			if (ors_max.compareTo(new BigDecimal("0")) == 0) {
				ors_max = new BigDecimal("" + object[16]);
			} else if (ors_max.compareTo(new BigDecimal("" + object[16])) == -1)
				ors_max = new BigDecimal("" + object[16]);
			ors_total = ors_total.add(new BigDecimal("" + object[16]));

			// Block for ors family Calculation
			if (ors_fam_max.compareTo(new BigDecimal("0")) == 0) {
				ors_fam_max = new BigDecimal("" + object[20]);
			} else if (ors_fam_max.compareTo(new BigDecimal("" + object[20])) == -1)
				ors_fam_max = new BigDecimal("" + object[20]);
			ors_fam_total = ors_fam_total.add(new BigDecimal("" + object[20]));

			// Block for AF Calculation
			if (af_min.compareTo(new BigDecimal("0")) == 0) {
				af_min = new BigDecimal("" + object[21]);
			} else if (af_min.compareTo(new BigDecimal("" + object[21])) == 1)
				af_min = new BigDecimal("" + object[21]);

			if (af_max.compareTo(new BigDecimal("" + object[21])) == -1)
				af_max = new BigDecimal("" + object[21]);

			// Block for Army Calculation
			if (army_min.compareTo(new BigDecimal("0")) == 0) {
				army_min = new BigDecimal("" + object[22]);
			} else if (army_min.compareTo(new BigDecimal("" + object[22])) == 1)
				army_min = new BigDecimal("" + object[22]);

			if (army_max.compareTo(new BigDecimal("" + object[22])) == -1)
				army_max = new BigDecimal("" + object[22]);

			// Block for Navy Calculation
			if (navy_min.compareTo(new BigDecimal("0")) == 0) {
				navy_min = new BigDecimal("" + object[23]);
			} else if (navy_min.compareTo(new BigDecimal("" + object[23])) == 1)
				navy_min = new BigDecimal("" + object[23]);

			if (navy_max.compareTo(new BigDecimal("" + object[23])) == -1)
				navy_max = new BigDecimal("" + object[23]);

			// Block for Navy Calculation
			total_death = total_death.add(new BigDecimal("" + object[3]));

			// Block for ADM Calculation
			total_adm = total_adm.add(new BigDecimal("" + object[1]));

			// Block for Discharge Calculation
			total_discharge = total_discharge
			.add(new BigDecimal("" + object[2]));

			// Block for stay of patient Calculation

			if (af_min.compareTo(new BigDecimal("0")) == 0) {
				min_bed = new BigDecimal("" + object[26]);
			} else if (af_min.compareTo(new BigDecimal("" + object[26])) == 1)
				min_bed = new BigDecimal("" + object[26]);
			if (max_bed.compareTo(new BigDecimal("" + object[26])) == -1)
				max_bed = new BigDecimal("" + object[26]);
			stay_of_patient_total = stay_of_patient_total.add(new BigDecimal(""
					+ object[26]));

			// }
		}
		// Final Caluculation
		off_avg = off_total.divide(no_days_of_month, 2, 0);
		off_fam_avg = off_fam_total.divide(no_days_of_month, 2, 0);
		ors_avg = ors_total.divide(no_days_of_month, 2, 0);
		ors_fam_avg = ors_fam_total.divide(no_days_of_month, 2, 0);
		af_avg = af_min.add(af_max).divide(new BigDecimal("2"), 2, 0);
		army_avg = army_min.add(army_max).divide(new BigDecimal("2"), 2, 0);
		navy_avg = navy_min.add(navy_max).divide(new BigDecimal("2"), 2, 0);
		BigDecimal af_army_navy_min = new BigDecimal("0");
		BigDecimal af_army_navy_max = new BigDecimal("0");
		af_army_navy_min = af_army_navy_min.add(af_min.add(army_min).add(
				navy_min));
		af_army_navy_max = af_army_navy_max.add(af_max.add(army_max).add(
				navy_max));
		BigDecimal death_avg = new BigDecimal("0");
		death_avg = total_death.divide(no_days_of_month, 2, 0);
		BigDecimal adm_avg = new BigDecimal("0");
		adm_avg = total_adm.divide(no_days_of_month, 2, 0);
		BigDecimal discharge_avg = new BigDecimal("0");
		discharge_avg = total_discharge.divide(no_days_of_month, 2, 0);
		stay_of_patient_avg = stay_of_patient_total.divide(total_discharge
				.add(total_adm), 2, 0);

		occupency_rate_avg = stay_of_patient_total.divide(
				no_days_of_month.multiply(new BigDecimal("800")), 2, 0)
				.multiply(new BigDecimal("100"));
		try {
			internal_turnover = no_days_of_month
			.multiply(new BigDecimal("800")).subtract(
					stay_of_patient_total).divide(
							total_discharge.add(total_death), 2, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("off_max", off_max);
		map.put("off_avg", off_avg);
		map.put("off_fam_max", off_fam_max);
		map.put("off_fam_avg", off_fam_avg);
		map.put("ors_max", ors_max);
		map.put("ors_avg", ors_avg);
		map.put("ors_fam_max", ors_fam_max);
		map.put("ors_fam_avg", ors_fam_avg);

		map.put("af_min", af_min);
		map.put("af_max", af_max);
		map.put("af_avg", af_avg);

		map.put("army_min", army_min);
		map.put("army_max", army_max);
		map.put("army_avg", army_avg);

		map.put("navy_min", navy_min);
		map.put("navy_max", navy_max);
		map.put("navy_avg", navy_avg);

		map.put("total_death", total_death);
		map.put("total_death_avg", death_avg);

		map.put("total_adm", total_adm);
		map.put("total_adm_avg", adm_avg);

		map.put("total_discharge", total_discharge);
		map.put("total_discharge_avg", discharge_avg);

		map.put("stay_of_patient_avg", stay_of_patient_avg);
		map.put("occupency_rate_avg", occupency_rate_avg);
		map.put("min_bed", min_bed);
		map.put("max_bed", max_bed);
		map.put("internal_turnover", internal_turnover);

		return map;
	}

	public String generateNumberForseq(int hospitalId) {
		String regNo = "";
		List<TransactionSequence> regList = new ArrayList<TransactionSequence>();
		Session session = (Session) getSession();
		try {
			regList = session.createCriteria(TransactionSequence.class).add(
					Restrictions.eq("TransactionPrefix", "EMP")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int seqNo = 0;
		if (regList.size() > 0) {
			for (TransactionSequence transactionSequence : regList) {
				TransactionSequence obj = (TransactionSequence) regList.get(0);
				int id = obj.getId();
				seqNo = obj.getTransactionSequenceNumber();
				int temp = 0;
				temp = seqNo;
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
				.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);

				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);

				regNo = String.valueOf(temp);
			}
		} else if (regList.size() == 0) {
			seqNo = 1;
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("mas_employee");
			tsObj.setTransactionPrefix("EMP");
			tsObj.setTransactionSequenceName("Employee Master");
			tsObj.setTransactionSequenceNumber(seqNo);
			tsObj.setCreatedby("admin");
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			tsObj.setHospital(hospital);
			tsObj.setStatus("y");

			hbt.save(tsObj);

			regNo = String.valueOf(seqNo);
		}
		return regNo;
	}

	public Map<String, Object> totalAdmissionExcelSoftCopy(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String grp_name = "TOTALADMISSIONS";
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			String fromDateStr = "";
			String toDateStr = "";
			String ServiceType_id = "";
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			try {
				fromDateStr = formatterOut.format(formatterIn.parse(""
						+ box.getString(FROM_DATE)));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			SimpleDateFormat formatterIn1 = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				toDateStr = formatterOut1.format(formatterIn1.parse(""
						+ box.getString(TO_DATE)));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			ServiceType_id = box.getString(SERVICE_TYPE_NAME);
			List<Object> TotalAdmList = new ArrayList<Object>();
			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
			Criteria crit = null;
			crit = session.createCriteria(Inpatient.class).createAlias("Hin",
			"pt");
			if (!ServiceType_id.equals("0")) {
				crit = crit.add(Restrictions.eq("pt.ServiceType.Id", Integer
						.parseInt(ServiceType_id)));
			}
			crit = crit.add(
					Restrictions.between("DateOfAddmission", java.sql.Date
							.valueOf(fromDateStr), java.sql.Date
							.valueOf(toDateStr))).addOrder(Order.asc("Id"));
			inpatientList = crit.list();

			serviceTypeList = session.createCriteria(MasServiceType.class).add(
					Restrictions.eq("Id", Integer.parseInt(ServiceType_id)))
					.list();
			String serviceType = "";
			for (MasServiceType serv : serviceTypeList) {
				serviceType = serv.getServiceTypeName();
			}

			try {
				byte[] buffer = new byte[18024];
				HSSFWorkbook wb = new HSSFWorkbook();
				HSSFSheet sheet = wb.createSheet("TESTEXCEL");
				// Create a new font and alter it.
				HSSFFont font = wb.createFont();
				font.setFontHeightInPoints((short) 10);
				font.setFontName(HSSFFont.FONT_ARIAL);
				font.setColor((short) 62);
				font.setItalic(false);
				font.setStrikeout(false);
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

				HSSFFont font1 = wb.createFont();
				font1.setFontHeightInPoints((short) 10);
				font1.setFontName(HSSFFont.FONT_ARIAL);
				font1.setColor((short) 80);
				font1.setItalic(false);
				font1.setStrikeout(false);
				font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

				// Fonts are set into a style so create a new one to
				// use.
				HSSFCellStyle style = wb.createCellStyle();
				style.setFont(font);

				HSSFCellStyle style1 = wb.createCellStyle();
				style1.setFont(font1);
				style1.setLocked(true);

				HSSFRow row1 = sheet.createRow((short) 1);
				// Create a cell and put a value in it.
				HSSFCell cell10 = row1.createCell((short) 3);
				cell10
				.setCellValue("                                                                                                       AFMSF-40");
				cell10.setCellStyle(style1);
				sheet.addMergedRegion(new Region(1, (short) 3, 1, (short) 7));

				HSSFRow row2 = sheet.createRow((short) 2);
				// Create a cell and put a value in it.
				HSSFCell cell20 = row2.createCell((short) 3);
				cell20.setCellValue("COMMAND HOSPITAL AIR FORCE, BANGALORE -7");
				cell20.setCellStyle(style1);
				sheet.addMergedRegion(new Region(2, (short) 3, 2, (short) 7));

				HSSFRow row3 = sheet.createRow((short) 3);
				// Create a cell and put a value in it.
				HSSFCell cell30 = row3.createCell((short) 3);
				cell30.setCellValue("Hospital Admission Records of "
						+ serviceType + " Personnel in CHAF Bangalore -7");
				cell30.setCellStyle(style1);
				sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));

				HSSFRow row4 = sheet.createRow((short) 4);
				// Create a cell and put a value in it.
				HSSFCell cell40 = row4.createCell((short) 3);
				cell40.setCellValue("From Date :");
				cell40.setCellStyle(style1);
				HSSFCell cell43 = row4.createCell((short) 4);
				cell43.setCellValue(fromDateStr + "  To Date: " + toDateStr);
				cell43.setCellStyle(style1);
				sheet.addMergedRegion(new Region(4, (short) 3, 4, (short) 7));

				// Create a row and put some cells in it. Rows are 0
				// based.
				HSSFRow headingRow = sheet.createRow((short) 6);
				// Create a cell and put a value in it.
				HSSFCell cell50 = headingRow.createCell((short) 0);
				cell50.setCellValue("Sl.No");
				cell50.setCellStyle(style);
				HSSFCell cell51 = headingRow.createCell((short) 1);
				cell51.setCellValue("A&D No");
				cell51.setCellStyle(style);
				HSSFCell cell52 = headingRow.createCell((short) 2);
				cell52.setCellValue("Service No");
				cell52.setCellStyle(style);

				HSSFCell cell53 = headingRow.createCell((short) 3);
				cell53.setCellValue("Relation");
				cell53.setCellStyle(style);
				HSSFCell cell531 = headingRow.createCell((short) 4);
				cell531.setCellValue("Rank");
				cell531.setCellStyle(style);
				HSSFCell cell54 = headingRow.createCell((short) 5);
				cell54.setCellValue("Name");
				cell54.setCellStyle(style);
				HSSFCell cell55 = headingRow.createCell((short) 6);
				cell55.setCellValue("Trade");
				cell55.setCellStyle(style);
				HSSFCell cell56 = headingRow.createCell((short) 7);
				cell56.setCellValue("R/O");
				cell56.setCellStyle(style);
				HSSFCell cell57 = headingRow.createCell((short) 8);
				cell57.setCellValue("Total Serv");
				cell57.setCellStyle(style);
				HSSFCell cell58 = headingRow.createCell((short) 9);
				cell58.setCellValue("Age");
				cell58.setCellStyle(style);
				HSSFCell cell59 = headingRow.createCell((short) 10);
				cell59.setCellValue("Unit");
				cell59.setCellStyle(style);
				HSSFCell cell510 = headingRow.createCell((short) 11);
				cell510.setCellValue("Adm Date");
				cell510.setCellStyle(style);
				HSSFCell cell511 = headingRow.createCell((short) 12);
				cell511.setCellValue("Dis Date");
				cell511.setCellStyle(style);
				HSSFCell cell512 = headingRow.createCell((short) 13);
				cell512.setCellValue("Patient Diagnosis");
				cell512.setCellStyle(style);
				HSSFCell cell513 = headingRow.createCell((short) 14);
				cell513.setCellValue("Disposal");
				cell513.setCellStyle(style);

				int row = 7;
				int slno = 0;

				for (Iterator iterator = inpatientList.iterator(); iterator
				.hasNext();) {
					Inpatient inpatient = (Inpatient) iterator.next();

					sheet.createRow((short) row).createCell((short) 0)
					.setCellValue(++slno);
					sheet.createRow((short) row).createCell((short) 1)
					.setCellValue(inpatient.getAdNo());
					sheet.createRow((short) row).createCell((short) 2)
					.setCellValue(inpatient.getHin().getServiceNo());
					if (inpatient.getHin().getRelation() != null) {
						sheet.createRow((short) row).createCell((short) 3)
						.setCellValue(
								inpatient.getHin().getRelation()
								.getRelationName());
					} else {
						sheet.createRow((short) row).createCell((short) 3)
						.setCellValue("");
					}

					if (inpatient.getHin().getRank() != null) {
						sheet.createRow((short) row).createCell((short) 4)
						.setCellValue(
								inpatient.getHin().getRank()
								.getRankName());
					} else {
						sheet.createRow((short) row).createCell((short) 4)
						.setCellValue("");
					}
					String name = inpatient.getHin().getSFirstName() + "  "
					+ inpatient.getHin().getSMiddleName() + "  "
					+ inpatient.getHin().getSLastName();
					sheet.createRow((short) row).createCell((short) 5)
					.setCellValue(name);

					if (inpatient.getHin().getTrade() != null) {
						sheet.createRow((short) row).createCell((short) 6)
						.setCellValue(
								inpatient.getHin().getTrade()
								.getTradeName());
					} else {
						sheet.createRow((short) row).createCell((short) 6)
						.setCellValue("");
					}

					if (inpatient.getHin().getRecordOfficeAddress() != null) {
						sheet.createRow((short) row).createCell((short) 7)
						.setCellValue(
								inpatient.getHin()
								.getRecordOfficeAddress()
								.getAddress()
								+ "\n PtDt:"
								+ inpatient.getHin()
								.getDistrict()
								.getDistrictName());
					} else {
						sheet.createRow((short) row).createCell((short) 7)
						.setCellValue("");
					}
					sheet.createRow((short) row).createCell((short) 8)
					.setCellValue(
							inpatient.getHin().getServiceYears()
							+ inpatient.getHin()
							.getTotalServicePeriod());
					sheet.createRow((short) row).createCell((short) 9)
					.setCellValue(inpatient.getHin().getAge());

					if (inpatient.getHin().getUnit() != null) {
						sheet.createRow((short) row).createCell((short) 10)
						.setCellValue(
								inpatient.getHin().getUnit()
								.getUnitName());
					} else {
						sheet.createRow((short) row).createCell((short) 10)
						.setCellValue("");
					}

					SimpleDateFormat dateformatOut = new SimpleDateFormat(
					"dd-MM-yyyy");
					SimpleDateFormat dateformatIn = new SimpleDateFormat(
					"yyyy-MM-dd");

					if (inpatient.getDateOfAddmission() != null) {
						try {
							sheet
							.createRow((short) row)
							.createCell((short) 11)
							.setCellValue(
									dateformatOut
									.format(dateformatIn
											.parse(inpatient
													.getDateOfAddmission()
													.toString())));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					} else {
						sheet.createRow((short) row).createCell((short) 11)
						.setCellValue("");
					}

					if (inpatient.getDischargeDate() != null) {
						try {
							SimpleDateFormat formatOut1 = new SimpleDateFormat(
							"dd-MM-yyyy");
							SimpleDateFormat formatIn1 = new SimpleDateFormat(
							"yyyy-MM-dd");

							sheet.createRow((short) row).createCell((short) 12)
							.setCellValue(
									formatOut1.format(formatIn1
											.parse(inpatient
													.getDischargeDate()
													.toString())));
						} catch (ParseException e2) {
							e2.printStackTrace();
						}
					} else {
						sheet.createRow((short) row).createCell((short) 12)
						.setCellValue("still in hospital");
					}

					List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();

					icdList = session.createCriteria(DischargeIcdCode.class)
					.createAlias("Inpatient", "inpatient").add(
							Restrictions.eq("DiagnosisStatus", "f"))
							.add(
									Restrictions.eq("inpatient.Id", inpatient
											.getId()))
											.addOrder(Order.asc("Id")).list();
					String icdCode = "";
					int i = 1;
					if (icdList.size() > 0) {
						for (Iterator iterator1 = icdList.iterator(); iterator1
						.hasNext();) {
							DischargeIcdCode dischargeIcdCode = (DischargeIcdCode) iterator1
							.next();
							String SubicdCode = "";
							SubicdCode = ""
								+ i
								+ ")"
								+ dischargeIcdCode.getIcd()
								.getIcdSubCategory()
								.getIcdSubCategoryName() + " "
								+ dischargeIcdCode.getIcd().getIcdName()
								+ " ICD No "
								+ dischargeIcdCode.getIcd().getIcdCode();
							icdCode = icdCode + SubicdCode + "\n";
							i++;
						}
					}

					sheet.createRow((short) row).createCell((short) 13)
					.setCellValue(icdCode);

					List<Discharge> dischargeList = new ArrayList<Discharge>();

					dischargeList = session.createCriteria(Discharge.class)
					.add(Restrictions.eq("AdNo", inpatient.getAdNo()))
					.addOrder(Order.asc("Id")).list();

					if (dischargeList.size() > 0) {
						for (Iterator iterator2 = dischargeList.iterator(); iterator2
						.hasNext();) {
							Discharge discharge = (Discharge) iterator2.next();
							if (discharge.getDisposedTo() != null) {
								sheet.createRow((short) row).createCell(
										(short) 14).setCellValue(
												discharge.getDisposedTo()
												.getDisposedToName());
							} else {
								sheet.createRow((short) row).createCell(
										(short) 14).setCellValue("");
							}
						}
					} else {
						sheet.createRow((short) row).createCell((short) 14)
						.setCellValue("");
					}

					sheet.setColumnWidth((short) 0, (short) (6 * 256));
					sheet.setColumnWidth((short) 1, (short) (15 * 256));
					sheet.setColumnWidth((short) 2, (short) (15 * 256));
					sheet.setColumnWidth((short) 3, (short) (15 * 256));
					sheet.setColumnWidth((short) 4, (short) (15 * 256));
					sheet.setColumnWidth((short) 5, (short) (20 * 256));
					sheet.setColumnWidth((short) 6, (short) (25 * 256));
					sheet.setColumnWidth((short) 7, (short) (25 * 256));
					sheet.setColumnWidth((short) 8, (short) (10 * 256));
					sheet.setColumnWidth((short) 9, (short) (23 * 256));
					sheet.setColumnWidth((short) 10, (short) (10 * 256));
					sheet.setColumnWidth((short) 11, (short) (23 * 256));
					sheet.setColumnWidth((short) 12, (short) (30 * 256));
					sheet.setColumnWidth((short) 13, (short) (60 * 256));
					sheet.setColumnWidth((short) 14, (short) (20 * 256));
					row++;
				}
				// Write the output to a file
				grp_name = grp_name + ".xls";
				FileOutputStream fileOut = new FileOutputStream(grp_name);
				wb.write(fileOut);
				fileOut.close();

				map.put("flag", "DataFound");
				map.put("download_path", grp_name);
			} catch (IOException ioe) {
				ioe.printStackTrace();
				map.put("flag", "NoData");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			map.put("flag", "NoData");
		}
		return map;
	}
	//================This Modify By Diplai at 07-04-2010==============
	public Map<String, Object> totalDischargeExcelSoftCopy(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String grp_name = "TOTALDISCHARGE";
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			String fromDateStr = "";
			String toDateStr = "";
			String ServiceType_id = "";
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			try {
				fromDateStr = formatterOut.format(formatterIn.parse(""
						+ box.getString(FROM_DATE)));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			SimpleDateFormat formatterIn1 = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				toDateStr = formatterOut1.format(formatterIn1.parse(""
						+ box.getString(TO_DATE)));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			ServiceType_id = box.getString(SERVICE_TYPE_ID);
			List<Object> TotalAdmList = new ArrayList<Object>();
			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
			String query = "";
			query = "from Inpatient i where i.DischargeDate between '"
				+ java.sql.Date.valueOf(fromDateStr)
				+ "'"
				+ " and '"
				+ java.sql.Date.valueOf(toDateStr)
				+ "' and i.AdStatus = 'D' group by i.AdNo order by i.DischargeDate";
			inpatientList = getHibernateTemplate().find(query);
			serviceTypeList = session.createCriteria(MasServiceType.class).add(
					Restrictions.eq("Id", Integer.parseInt(ServiceType_id)))
					.list();
			String serviceType = "";
			for (MasServiceType serv : serviceTypeList) {
				serviceType = serv.getServiceTypeName();
			}

			try {
				byte[] buffer = new byte[18024];
				HSSFWorkbook wb = new HSSFWorkbook();
				HSSFSheet sheet = wb.createSheet("TESTEXCEL");
				// Create a new font and alter it.
				HSSFFont font = wb.createFont();
				font.setFontHeightInPoints((short) 10);
				font.setFontName(HSSFFont.FONT_ARIAL);
				font.setColor((short) 62);
				font.setItalic(false);
				font.setStrikeout(false);
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

				HSSFFont font1 = wb.createFont();
				font1.setFontHeightInPoints((short) 10);
				font1.setFontName(HSSFFont.FONT_ARIAL);
				font1.setColor((short) 80);
				font1.setItalic(false);
				font1.setStrikeout(false);
				font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

				// Fonts are set into a style so create a new one to
				// use.
				HSSFCellStyle style = wb.createCellStyle();
				style.setFont(font);

				HSSFCellStyle style1 = wb.createCellStyle();
				style1.setFont(font1);
				style1.setLocked(true);

				/*
				 * HSSFRow row1 = sheet.createRow((short) 1); // Create a cell
				 * and put a value in it. HSSFCell cell10 =
				 * row1.createCell((short) 3);cell10.setCellValue(
				 * "                                                                                                       AFMSF-40"
				 * ); cell10.setCellStyle(style1); sheet.addMergedRegion(new
				 * Region(1, (short) 3, 1, (short) 7));
				 */

				HSSFRow row1 = sheet.createRow((short) 1);
				// Create a cell and put a value in it.
				HSSFCell cell10 = row1.createCell((short) 3);
				cell10.setCellValue("COMMAND HOSPITAL AIR FORCE, BANGALORE -7");
				cell10.setCellStyle(style1);
				sheet.addMergedRegion(new Region(1, (short) 3, 1, (short) 7));

				HSSFRow row2 = sheet.createRow((short) 2);
				// Create a cell and put a value in it.
				HSSFCell cell20 = row2.createCell((short) 3);
				cell20
				.setCellValue("Statistical Registration No. AA/844 (b)      ");
				cell20.setCellStyle(style1);
				sheet.addMergedRegion(new Region(2, (short) 3, 2, (short) 7));

				HSSFRow row3 = sheet.createRow((short) 3);
				// Create a cell and put a value in it.
				HSSFCell cell30 = row3.createCell((short) 3);
				cell30
				.setCellValue(" Name of Medical Unit : Command Hospital   AF Bangalore       ");
				cell30.setCellStyle(style1);
				sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));

				HSSFRow row4 = sheet.createRow((short) 4);
				// Create a cell and put a value in it.
				HSSFCell cell40 = row4.createCell((short) 3);
				cell40
				.setCellValue(" Particulars of cases admitted before but disposed of or whose diagnosis changed \n during the period ending :");
				cell40.setCellStyle(style1);
				sheet.addMergedRegion(new Region(4, (short) 3, 4, (short) 7));

				HSSFRow row5 = sheet.createRow((short) 5);
				// Create a cell and put a value in it.
				HSSFCell cell50 = row5.createCell((short) 3);
				cell50
				.setCellValue("                                  RESTRICTED                                 AFMSF-42");
				cell50.setCellStyle(style1);
				sheet.addMergedRegion(new Region(5, (short) 3, 5, (short) 7));

				HSSFRow row6 = sheet.createRow((short) 6);
				// Create a cell and put a value in it.
				HSSFCell cell60 = row6.createCell((short) 3);
				cell60.setCellValue("Discharge Records of " + serviceType
						+ " Personnel in CHAF Bangalore -7");
				cell60.setCellStyle(style1);
				sheet.addMergedRegion(new Region(6, (short) 3, 6, (short) 7));

				HSSFRow row7 = sheet.createRow((short) 7);
				// Create a cell and put a value in it.
				HSSFCell cell70 = row7.createCell((short) 3);
				cell70.setCellValue("From Date :");
				cell70.setCellStyle(style1);
				HSSFCell cell73 = row7.createCell((short) 4);
				cell73.setCellValue(fromDateStr + "  To Date: " + toDateStr);
				cell73.setCellStyle(style1);
				sheet.addMergedRegion(new Region(7, (short) 3, 7, (short) 7));

				// Create a row and put some cells in it. Rows are 0
				// based.
				HSSFRow headingRow = sheet.createRow((short) 9);
				// Create a cell and put a value in it.
				HSSFCell cell80 = headingRow.createCell((short) 0);
				cell80.setCellValue("Sl.No");
				cell80.setCellStyle(style);
				HSSFCell cell81 = headingRow.createCell((short) 1);
				cell81
				.setCellValue("Ser No in A&D Book with Month and year of admission       ");
				cell81.setCellStyle(style);

				HSSFCell cell52 = headingRow.createCell((short) 2);
				cell52.setCellValue("Service No");
				cell52.setCellStyle(style);

				HSSFCell cell53 = headingRow.createCell((short) 3);
				cell53.setCellValue("Relation");
				cell53.setCellStyle(style);

				HSSFCell cell531 = headingRow.createCell((short) 4);
				cell531.setCellValue("Rank");
				cell531.setCellStyle(style);

				HSSFCell cell82 = headingRow.createCell((short)5);
				cell82.setCellValue("Name in full");
				cell82.setCellStyle(style);

				HSSFCell cell83 = headingRow.createCell((short) 6);
				cell83.setCellValue("Dt of Disposal");
				cell83.setCellStyle(style);
				HSSFCell cell831 = headingRow.createCell((short) 7);
				cell831.setCellValue("Discharged/Transferredto");
				cell831.setCellStyle(style);
				HSSFCell cell84 = headingRow.createCell((short) 8);
				cell84.setCellValue("No.Of Days Hospital");
				cell84.setCellStyle(style);
				HSSFCell cell85 = headingRow.createCell((short)9);
				cell85.setCellValue("Patient Diagnosis");
				cell85.setCellStyle(style);

				int row = 10;
				int slno = 0;

				/*
				 * for (Iterator iterator = inpatientList.iterator(); iterator
				 * .hasNext();) {
				 */

				// if(!ServiceType_id.equals("0") && ServiceType_id != null &&
				// ServiceType_id.equals("")){

				for (Inpatient inpatient : inpatientList) {
					if (Integer.parseInt(ServiceType_id) == inpatient.getHin()
							.getServiceType().getId()) {
						// Inpatient inpatient = (Inpatient) iterator.next();

						sheet.createRow((short) row).createCell((short) 0)
						.setCellValue(++slno);
						sheet.createRow((short) row).createCell((short) 1)
						.setCellValue(inpatient.getAdNo());
						sheet.createRow((short) row).createCell((short) 2)
						.setCellValue(inpatient.getHin().getServiceNo());

						if (inpatient.getHin().getRelation() != null) {
							sheet.createRow((short) row).createCell((short) 3)
							.setCellValue(
									inpatient.getHin().getRelation()
									.getRelationName());
						} else {
							sheet.createRow((short) row).createCell((short) 3)
							.setCellValue("");
						}

						if (inpatient.getHin().getRank() != null) {
							sheet.createRow((short) row).createCell((short) 4)
							.setCellValue(
									inpatient.getHin().getRank()
									.getRankName());
						} else {
							sheet.createRow((short) row).createCell((short) 4)
							.setCellValue("");
						}

						String name = inpatient.getHin().getSFirstName() + "  "
						+ inpatient.getHin().getSMiddleName() + "  "
						+ inpatient.getHin().getSLastName();
						sheet.createRow((short) row).createCell((short) 5)
						.setCellValue(name);
						if (inpatient.getDischargeDate() != null) {
							try {
								SimpleDateFormat formatOut1 = new SimpleDateFormat(
										"dd-MM-yyyy");
								SimpleDateFormat formatIn1 = new SimpleDateFormat(
								"yyyy-MM-dd");

								sheet.createRow((short) row).createCell(
										(short) 6).setCellValue(
												formatOut1.format(formatIn1
														.parse(inpatient
																.getDischargeDate()
																.toString())));
							} catch (ParseException e2) {
								e2.printStackTrace();
							}
						} else {
							sheet.createRow((short) row).createCell((short) 6)
							.setCellValue("");
						}

						List<Discharge> dischargeList = new ArrayList<Discharge>();
						dischargeList = session.createCriteria(Discharge.class)
						.add(
								Restrictions.eq("AdNo", inpatient
										.getAdNo())).addOrder(
												Order.asc("Id")).list();

						if (dischargeList.size() > 0) {
							for (Iterator iterator2 = dischargeList.iterator(); iterator2
							.hasNext();) {
								Discharge discharge = (Discharge) iterator2
								.next();
								if (discharge.getDisposedTo() != null) {
									sheet.createRow((short) row).createCell(
											(short) 7).setCellValue(
													discharge.getDisposedTo()
													.getDisposedToName());
								} else {
									sheet.createRow((short) row).createCell(
											(short) 7).setCellValue("");
								}
							}
						} else {
							sheet.createRow((short) row).createCell((short) 7)
							.setCellValue("");
						}
						long one_day = 1000 * 60 * 60 * 24;
						Double diffDays = Math.ceil((inpatient
								.getDischargeDate().getTime() - inpatient
								.getDateOfAddmission().getTime())
								/ one_day);
						int noDays = diffDays.intValue();

						sheet.createRow((short) row).createCell((short) 8)
						.setCellValue(noDays);

						List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
						icdList = session
						.createCriteria(DischargeIcdCode.class)
						.createAlias("Inpatient", "inpatient")
						.add(Restrictions.eq("DiagnosisStatus", "f"))
						.add(
								Restrictions.eq("inpatient.Id",
										inpatient.getId())).addOrder(
												Order.asc("Id")).list();
						String icdCode = "";
						int i = 1;
						if (icdList.size() > 0) {
							for (Iterator iterator1 = icdList.iterator(); iterator1
							.hasNext();) {
								DischargeIcdCode dischargeIcdCode = (DischargeIcdCode) iterator1
								.next();
								String SubicdCode = "";
								SubicdCode = ""
									+ i
									+ ")"
									+ dischargeIcdCode.getIcd()
									.getIcdSubCategory()
									.getIcdSubCategoryName()
									+ " "
									+ dischargeIcdCode.getIcd()
									.getIcdName()
									+ " [ICD No "
									+ dischargeIcdCode.getIcd()
									.getIcdCode() + "]";
								icdCode = icdCode + SubicdCode + "\n";
								i++;
							}
						}

						sheet.createRow((short) row).createCell((short) 9)
						.setCellValue(icdCode);

						sheet.setColumnWidth((short) 0, (short) (6 * 256));
						sheet.setColumnWidth((short) 1, (short) (15 * 256));
						sheet.setColumnWidth((short) 2, (short) (15 * 256));
						sheet.setColumnWidth((short) 3, (short) (15 * 256));
						sheet.setColumnWidth((short) 4, (short) (15 * 256));
						sheet.setColumnWidth((short) 5, (short) (20 * 256));
						sheet.setColumnWidth((short) 6, (short) (25 * 256));
						sheet.setColumnWidth((short) 7, (short) (25 * 256));
						sheet.setColumnWidth((short) 8, (short) (10 * 256));
						sheet.setColumnWidth((short) 9, (short) (23 * 256));
						sheet.setColumnWidth((short) 10, (short) (10 * 256));
						sheet.setColumnWidth((short) 11, (short) (23 * 256));
						sheet.setColumnWidth((short) 12, (short) (30 * 256));
						sheet.setColumnWidth((short) 13, (short) (60 * 256));
						sheet.setColumnWidth((short) 14, (short) (20 * 256));
						sheet.setColumnWidth((short) 15, (short) (20 * 256));
						sheet.setColumnWidth((short) 16, (short) (20 * 256));
						sheet.setColumnWidth((short) 17, (short) (20 * 256));
						row++;
					}
				}
				// }
				// Write the output to a file
				grp_name = grp_name + ".xls";
				FileOutputStream fileOut = new FileOutputStream(grp_name);
				wb.write(fileOut);
				fileOut.close();

				map.put("flag", "DataFound");
				map.put("download_path", grp_name);
			} catch (IOException ioe) {
				ioe.printStackTrace();
				map.put("flag", "NoData");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			map.put("flag", "NoData");
		}
		return map;
	}
	public Map<String, Object> getTotalMisDailyReport(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String toDate = "";
		String TO_DATE = null;
		int deptId = 0;
		Session session = (Session) getSession();

		if (dataMap.get("Date") != null) {
			TO_DATE = "" + dataMap.get("Date");
		}
		if (dataMap.get("Dept_ID") != null) {
			deptId = Integer.parseInt("" + dataMap.get("Dept_ID"));
		}

		// java.sql.Date TO_DATE = java.sql.Date.valueOf(date4MySQL2);

		List objectList1 = new ArrayList();
		List objectList2 = new ArrayList();
		try {
			String idqry = "SELECT mas_department.`department_id` , mas_department.`department_name` FROM "
				+ " `mas_department` mas_department , `mas_department_type` mas_dept_type "
				+ " where mas_department.department_type_id = mas_dept_type.department_type_id "
				+ " and mas_dept_type.department_type_code = 'WARD' and mas_department.`status` = 'y' ";
			objectList1 = (List) session.createSQLQuery(idqry).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String qry = "";
		BigDecimal REMD = new BigDecimal("0");
		BigDecimal ADM = new BigDecimal("0");
		BigDecimal DIS = new BigDecimal("0");

		BigDecimal TIN = new BigDecimal("0");
		BigDecimal TOUT = new BigDecimal("0");
		BigDecimal SIL = new BigDecimal("0");

		BigDecimal DIL = new BigDecimal("0");
		BigDecimal DINOUT = new BigDecimal("0");
		BigDecimal DEATH = new BigDecimal("0");

		BigDecimal REMG = new BigDecimal("0");
		for (int i = 0; i < objectList1.size(); i++) {
			Object[] object1 = (Object[]) objectList1.get(i);
			qry = "select  d.REMD,a.ADM,c.DIS,e.TIN,f.TOUT,g.SIL,h.DIL,b.Death,i.REMG from"
				+ " (SELECT count(*) as ADM FROM inpatient inpatient  where inpatient.date_of_addmission = '"
				+ TO_DATE
				+ "' and  inpatient.department_id = "
				+ object1[0]
				          + ") a, "
				          + " (SELECT count(*) as Death FROM expiry_details expiry_details where expiry_details.expiry_date  = '"
				          + TO_DATE
				          + "'  and  expiry_details.ward_id = "
				          + object1[0]
				                    + ") b, "
				                    + " (SELECT count(*) as DIS FROM discharge discharge where discharge.date_of_discharge = '"
				                    + TO_DATE
				                    + "' and  discharge.ward_id = "
				                    + object1[0]
				                              + ") c, "
				                              + " (SELECT count(*) as REMD FROM inpatient inp2 where inp2.date_of_addmission < '"
				                              + TO_DATE
				                              + "' and inp2.ad_status = 'A' and inp2.department_id = "
				                              + object1[0]
				                                        + ") d, "
				                                        + " (SELECT count(distinct(inp3.inpatient_id)) as TIN FROM inpatient inp3 where inp3.date_of_addmission = '"
				                                        + TO_DATE
				                                        + "' and inp3.department_id = "
				                                        + object1[0]
				                                                  + " and inp3.ad_ward_id !="
				                                                  + object1[0]
				                                                            + ") e, "
				                                                            + " (SELECT count(distinct(inp4.inpatient_id)) as TOUT FROM inpatient inp4 where inp4.date_of_addmission = '"
				                                                            + TO_DATE
				                                                            + "' and inp4.department_id != "
				                                                            + object1[0]
				                                                                      + " and inp4.ad_ward_id ="
				                                                                      + object1[0]
				                                                                                + ") f, "
				                                                                                + "(SELECT count(distinct(sil.inpatient_id)) as SIL FROM sil_dil_status sil where sil.last_chg_date = '"
				                                                                                + TO_DATE
				                                                                                + "' and sil.department_id = "
				                                                                                + object1[0]
				                                                                                          + " and sil.condition_status ='SIL' ) g,"
				                                                                                          + "(SELECT count(distinct(dil.inpatient_id)) as DIL FROM sil_dil_status dil where dil.last_chg_date = '"
				                                                                                          + TO_DATE
				                                                                                          + "' and dil.department_id = "
				                                                                                          + object1[0]
				                                                                                                    + " and dil.condition_status ='DIL' ) h,"
				                                                                                                    + " (SELECT count(*) as REMG FROM inpatient inp5 where inp5.date_of_addmission <= '"
				                                                                                                    + TO_DATE
				                                                                                                    + "' and inp5.ad_status = 'A' and inp5.department_id = "
				                                                                                                    + object1[0] + ") i";

			objectList2 = (List) session.createSQLQuery(qry).list();
			// for (Iterator iterator = objectList2.iterator();
			// iterator.hasNext();) {
			Object[] object = (Object[]) objectList2.get(0);

			// Block for officers Calculation
			if (REMD.compareTo(new BigDecimal("0")) == 0) {
				REMD = new BigDecimal("" + object[0]);
			} else if (REMD.compareTo(new BigDecimal("0")) == -1) {
				REMD = REMD.add(new BigDecimal("" + object[0]));
			}

			if (ADM.compareTo(new BigDecimal("0")) == 0) {
				ADM = new BigDecimal("" + object[1]);
			} else if (ADM.compareTo(new BigDecimal("0")) == -1) {
				ADM = ADM.add(new BigDecimal("" + object[1]));
			}
			if (DIS.compareTo(new BigDecimal("0")) == 0) {
				DIS = new BigDecimal("" + object[2]);
			} else if (DIS.compareTo(new BigDecimal("0")) == -1) {
				DIS = DIS.add(new BigDecimal("" + object[2]));
			}

			if (TIN.compareTo(new BigDecimal("0")) == 0) {
				TIN = new BigDecimal("" + object[3]);
			} else if (TIN.compareTo(new BigDecimal("0")) == -1) {
				TIN = TIN.add(new BigDecimal("" + object[3]));
			}

			if (TOUT.compareTo(new BigDecimal("0")) == 0) {
				TOUT = new BigDecimal("" + object[4]);
			} else if (TOUT.compareTo(new BigDecimal("0")) == -1) {
				TOUT = TOUT.add(new BigDecimal("" + object[4]));
			}
			if (SIL.compareTo(new BigDecimal("0")) == 0) {
				SIL = new BigDecimal("" + object[5]);
			} else if (SIL.compareTo(new BigDecimal("0")) == -1) {
				SIL = SIL.add(new BigDecimal("" + object[5]));
			}

			if (DIL.compareTo(new BigDecimal("0")) == 0) {
				DIL = new BigDecimal("" + object[6]);
			} else if (DIL.compareTo(new BigDecimal("0")) == -1) {
				DIL = DIL.add(new BigDecimal("" + object[6]));
			}

			if (DINOUT.compareTo(new BigDecimal("0")) == 0) {
				DINOUT = new BigDecimal("0");
			} else if (DINOUT.compareTo(new BigDecimal("0")) == -1) {
				DINOUT = new BigDecimal("0");
			}

			if (DEATH.compareTo(new BigDecimal("0")) == 0) {
				DEATH = new BigDecimal("" + object[7]);
			} else if (DEATH.compareTo(new BigDecimal("0")) == -1) {
				DEATH = DEATH.add(new BigDecimal("" + object[7]));
			}

			if (REMG.compareTo(new BigDecimal("0")) == 0) {
				REMG = new BigDecimal("" + object[8]);
			} else if (REMG.compareTo(new BigDecimal("0")) == -1) {
				REMG = REMG.add(new BigDecimal("" + object[8]));
			}
			// Block for officers family Calculation
		}

		map.put("REMD", REMD);
		map.put("ADM", ADM);
		map.put("DIS", DIS);
		map.put("TIN", TIN);
		map.put("TOUT", TOUT);
		map.put("SIL", SIL);
		map.put("DIL", DIL);
		map.put("DINOUT", DINOUT);
		map.put("DEATH", DEATH);
		map.put("REMG", REMG);
		return map;
	}

	public Map<String, Object> closeExistingRecord(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		int ameLmcH = 0;
		if(box.get("AMELMCH") != null)
			ameLmcH = box.getInt("AMELMCH");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		AmeLmcHeader ameH = (AmeLmcHeader) hbt.load(AmeLmcHeader.class, ameLmcH); 

		ameH.setStatus("c");
		hbt.update(ameH);

		return map;
	}

	public Map<String, Object> getExistingDetails(Box box) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<AmeLmc> lmcList = new ArrayList<AmeLmc>();
		int ameLmcH = 0;
		Session session = (Session) getSession();
		if(box.get("exitDetail") != null)
			ameLmcH = box.getInt("exitDetail");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		AmeLmcHeader ameH = (AmeLmcHeader) hbt.load(AmeLmcHeader.class, ameLmcH);

		lmcList = session.createCriteria(AmeLmc.class).add(Restrictions.eq("LmcHeaderId.Id", ameLmcH)).list();

		map.put("ameH", ameH);
		map.put("lmcList", lmcList);

		return map;
	}

	//-----By Dipali--Saving Data for AnnualMedicalExamination
	public Map<String, Object> submitAnnualMedicalExamination(Box box,Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		int hospitalId = box.getInt("hospitalId");
		int empId = box.getInt(RequestConstants.EMPLOYEE_ID);
		int medicalCategoryId = box.getInt(RequestConstants.MEDICAL_CATEGORY_ID);
		int rankId = box.getInt(RequestConstants.RANK_ID);
		int tradeId = box.getInt(RequestConstants.TRADE_ID);
		int unitId = box.getInt(RequestConstants.UNIT_ID);
		String serviceNo = box.getString(RequestConstants.SERVICE_NO);
		String empFirstName = box.getString(RequestConstants.FIRST_NAME);
		String empLastName = box.getString(RequestConstants.LAST_NAME);
		String period = box.getString(RequestConstants.PERIOD);
		String duration = box.getString(RequestConstants.DURATION);
		String changedBy =  box.getString(RequestConstants.CHANGED_BY);
		String currentTime = box.getString(RequestConstants.CHANGED_TIME);
		String afmsfType = box.getString(RequestConstants.AFMSF_TYPE);
		String nextReviewDate = box.getString(RequestConstants.NEXT_REVIEW_DATE);
		Date nReviewDate = HMSUtil.convertStringTypeDateToDateType(nextReviewDate);
		String ameDate = box.getString(RequestConstants.AME_DATE);
		Date amDate = HMSUtil.convertStringTypeDateToDateType(ameDate);
		String currentDate = box.getString(RequestConstants.CHANGED_DATE);
		Date currDate = HMSUtil.convertStringTypeDateToDateType(currentDate);


		EmpAfmsfDet afmsfDet = new EmpAfmsfDet();
		if (serviceNo != null) {
			afmsfDet.setServiceNo(serviceNo);
		}
		if (empFirstName != null) {
			afmsfDet.setEmpName(empFirstName);
		}
		if (empLastName != null) {
			afmsfDet.setEmpLastName(empLastName);
		}
		if (nextReviewDate != null) {
			afmsfDet.setNextReview(nReviewDate);
		}

		afmsfDet.setLastChgBy(changedBy);
		afmsfDet.setLastChgDate(currDate);
		afmsfDet.setLastChgTime(currentTime);
		afmsfDet.setAfmsfType(afmsfType);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		afmsfDet.setHospital(masHospital);

		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(empId);
		afmsfDet.setEmployee(masEmployee);

		if(rankId!=0){
			MasRank masRank = new MasRank();
			masRank.setId(rankId);
			afmsfDet.setRank(masRank);
		}
		if(tradeId!=0){
			MasTrade masTrade = new MasTrade();
			masTrade.setId(tradeId);
			afmsfDet.setTrade(masTrade);
		}
		if(medicalCategoryId!=0){
			MasMedicalCategory medicalCategory = new MasMedicalCategory();
			medicalCategory.setId(medicalCategoryId);
			afmsfDet.setMedicalCategory(medicalCategory);
		}
		if(unitId!=0){
			MasUnit masUnit = new MasUnit();
			masUnit.setId(unitId);
			afmsfDet.setUnit(masUnit);
		}
		afmsfDet.setStatus("y");
		afmsfDet.setNextReview(nReviewDate);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(afmsfDet);
			AnnualMediacalExamination anExamination=new AnnualMediacalExamination();
			anExamination.setAfmsfDet(afmsfDet);
			if(medicalCategoryId!=0){
				MasMedicalCategory medicalCategory = new MasMedicalCategory();
				medicalCategory.setId(medicalCategoryId);
				anExamination.setCategory(medicalCategory);
			}
			anExamination.setLastBoard(amDate);
			anExamination.setDuration(duration);
			anExamination.setLastChgBy(changedBy);
			anExamination.setLastChgDate(currDate);
			anExamination.setLastChgTime(currentTime);
			anExamination.setPeriod(period);
			anExamination.setNextReview(nReviewDate);
			anExamination.setStatus("y");
			hbt.save(anExamination);

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}
	/*public Map<String, Object> submitAnnualMedicalExamination(Box box,Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Session session = (Session) getSession();
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		int hospitalId = box.getInt("hospitalId");
		int empId = box.getInt(RequestConstants.EMPLOYEE_ID);
		int medicalCategoryId = box.getInt(RequestConstants.MEDICAL_CATEGORY_ID);
		int rankId = box.getInt(RequestConstants.RANK_ID);
		int tradeId = box.getInt(RequestConstants.TRADE_ID);
		int unitId = box.getInt(RequestConstants.UNIT_ID);
		String serviceNo = box.getString(RequestConstants.SERVICE_NO);
		String empFirstName = box.getString(RequestConstants.FIRST_NAME);
		String empLastName = box.getString(RequestConstants.LAST_NAME);
		String period = box.getString(RequestConstants.PERIOD);
		String duration = box.getString(RequestConstants.DURATION);
		String changedBy =  box.getString(RequestConstants.CHANGED_BY);
		String currentTime = box.getString(RequestConstants.CHANGED_TIME);
		String afmsfType = box.getString(RequestConstants.AFMSF_TYPE);
		String nextReviewDate = box.getString(RequestConstants.NEXT_REVIEW_DATE);
		Date nReviewDate = HMSUtil.convertStringTypeDateToDateType(nextReviewDate);
		String ameDate = box.getString(RequestConstants.AME_DATE);
		Date amDate = HMSUtil.convertStringTypeDateToDateType(ameDate);
		String currentDate = box.getString(RequestConstants.CHANGED_DATE);
		Date currDate = HMSUtil.convertStringTypeDateToDateType(currentDate);


		EmpAfmsfDet afmsfDet = new EmpAfmsfDet();
		if (serviceNo != null) {
			afmsfDet.setServiceNo(serviceNo);
		}
		if (empFirstName != null) {
			afmsfDet.setEmpName(empFirstName);
		}
		if (empLastName != null) {
			afmsfDet.setEmpLastName(empLastName);
		}
		if (nextReviewDate != null) {
			afmsfDet.setNextReview(nReviewDate);
		}

		afmsfDet.setLastChgBy(changedBy);
		afmsfDet.setLastChgDate(currDate);
		afmsfDet.setLastChgTime(currentTime);
		afmsfDet.setAfmsfType(afmsfType);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		afmsfDet.setHospital(masHospital);

		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(empId);
		afmsfDet.setEmployee(masEmployee);

		if(rankId!=0){
		MasRank masRank = new MasRank();
		masRank.setId(rankId);
		afmsfDet.setRank(masRank);
		}
		if(tradeId!=0){
		MasTrade masTrade = new MasTrade();
		masTrade.setId(tradeId);
		afmsfDet.setTrade(masTrade);
		}
		if(medicalCategoryId!=0){
		MasMedicalCategory medicalCategory = new MasMedicalCategory();
		medicalCategory.setId(medicalCategoryId);
		afmsfDet.setMedicalCategory(medicalCategory);
		}
		if(unitId!=0){
		MasUnit masUnit = new MasUnit();
		masUnit.setId(unitId);
		afmsfDet.setUnit(masUnit);
		}
		afmsfDet.setStatus("y");
		afmsfDet.setNextReview(nReviewDate);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(afmsfDet);
			AnnualMediacalExamination anExamination=new AnnualMediacalExamination();
			anExamination.setAfmsfDet(afmsfDet);
			if(medicalCategoryId!=0){
			MasMedicalCategory medicalCategory = new MasMedicalCategory();
			medicalCategory.setId(medicalCategoryId);
			anExamination.setCategory(medicalCategory);
			}
		anExamination.setLastBoard(amDate);
		anExamination.setDuration(duration);
		anExamination.setLastChgBy(changedBy);
		anExamination.setLastChgDate(currDate);
		anExamination.setLastChgTime(currentTime);
		anExamination.setPeriod(period);
		anExamination.setNextReview(nReviewDate);
		anExamination.setStatus("y");
		hbt.save(anExamination);

		saved = true;
		tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}
	 */
	public Map<String, Object> showAmeLmcReportJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		Session session = (Session) getSession();

		try {
			rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();

			map.put("rankList", rankList);
			map.put("unitList", unitList);

		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public Map<String, Object> showSilDilReportJsp() {

		Map<String, Object> map = new HashMap<String, Object>();

		Session session = (Session) getSession();

		List<MasServiceType> serviceTypeList = new
		ArrayList<MasServiceType>();

		serviceTypeList =
			session.createCriteria(MasServiceType.class).add(Restrictions.eq("Status",
					"y")).list();

		map.put("serviceTypeList", serviceTypeList);

		return map;

	}
	public Map<String, Object> printSILDILStatusReport(Date fromDate,Date toDate) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Connection con = session.connection();
		map.put("con", con);
		String sql = "{call SIL_DIL_COND_STATUS( '"+formatterOut.format(fromDate)+"' , '"+formatterOut.format(toDate)+"' )}";
		try {
			CallableStatement cals = con.prepareCall(sql);
			cals.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return map;
	}
	@SuppressWarnings("unchecked")
	public List getAdmissionNoList1(Map<String, Object> map) {
		Session session = (Session) getSession();
		int hinId = 0;
		if(map.get("hinId") != null){
			hinId = (Integer)map.get("hinId");
		}
		List<Object> inpatientList = new ArrayList<Object>();
		try {

			inpatientList = getHibernateTemplate().find("from Inpatient ip join ip.Hin as p where p.Id = '"+hinId+"'");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return inpatientList;
	}
	/*public Map<String, Object> showAmeLmcReportJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		Session session = (Session) getSession();

		try {
			rankList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();

			map.put("rankList", rankList);
			map.put("unitList", unitList);

		}catch (Exception e) {
			e.printStackTrace();
		}
	return map;
	}
	 */	
	//---Form 38-A--in Excel Formate----By Dipali---

	public Map<String, Object> searchMonthlySickExcelReport(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String hospitalName="";
		if(box.get("hospitalName") != null){
			hospitalName = (String)box.get("hospitalName");
		}
		String grp_name = "MONTHLYSICK";
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List lst = new ArrayList();
			String fromDateStr = "";
			String toDateStr = "";
			String temp = "";
			lst.add(31);
			lst.add(59);
			lst.add(184);
			lst.add(450);
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			try {
				fromDateStr = formatterOut.format(formatterIn.parse(""+ box.getString(FROM_DATE)));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			SimpleDateFormat formatterIn1 = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				toDateStr = formatterOut1.format(formatterIn1.parse(""+ box.getString(TO_DATE)));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			temp = box.getString("nc");

			List<Object> monthlySickList = new ArrayList<Object>();
			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			Criteria crit = null;
			if(temp.equals("nc")){
				crit = session.createCriteria(Inpatient.class).createAlias("Hin","pt")
				.add(Restrictions.eq("pt.Relation.Id", 8)).add(Restrictions.eq("pt.ServiceType.Id", 2))
				.add(Restrictions.ne("AdStatus", "C"));
				//.add(Restrictions.in("pt.Unit.Id", lst)).add(Restrictions.eq("pt.Rank.Id", 19));
			}else{
				crit = session.createCriteria(Inpatient.class).createAlias("Hin","pt")
				.add(Restrictions.eq("pt.Relation.Id", 8)).add(Restrictions.eq("pt.ServiceType.Id", 2))
				.add(Restrictions.ne("AdStatus", "C"));
				//.add(Restrictions.in("pt.Unit.Id", lst)).add(Restrictions.ne("pt.Rank.Id", 19));
			}
			crit = crit.add(Restrictions.between("DateOfAddmission", java.sql.Date
					.valueOf(fromDateStr), java.sql.Date
					.valueOf(toDateStr))).addOrder(Order.asc("Id"));
			inpatientList = crit.list();

			try {
				byte[] buffer = new byte[18024];
				HSSFWorkbook wb = new HSSFWorkbook();
				HSSFSheet sheet = wb.createSheet("TESTEXCEL");
				// Create a new font and alter it.
				HSSFFont font = wb.createFont();
				font.setFontHeightInPoints((short) 10);
				font.setFontName(HSSFFont.FONT_ARIAL);
				font.setColor((short) 62);
				font.setItalic(false);
				font.setStrikeout(false);
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

				HSSFFont font1 = wb.createFont();
				font1.setFontHeightInPoints((short) 10);
				font1.setFontName(HSSFFont.FONT_ARIAL);
				font1.setColor((short) 80);
				font1.setItalic(false);
				font1.setStrikeout(false);
				font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

				// Fonts are set into a style so create a new one to
				// use.
				HSSFCellStyle style = wb.createCellStyle();
				style.setFont(font);

				HSSFCellStyle style1 = wb.createCellStyle();
				style1.setFont(font1);
				style1.setLocked(true);

				HSSFRow row1 = sheet.createRow((short) 1);
				// Create a cell and put a value in it.
				HSSFCell cell10 = row1.createCell((short) 3);
				cell10
				.setCellValue("                                                                                                       AFMSF-40");
				cell10.setCellStyle(style1);
				sheet.addMergedRegion(new Region(1, (short) 3, 1, (short) 7));

				HSSFRow row2 = sheet.createRow((short) 2);
				// Create a cell and put a value in it.
				HSSFCell cell20 = row2.createCell((short) 3);
				cell20.setCellValue(hospitalName);
				cell20.setCellStyle(style1);
				sheet.addMergedRegion(new Region(2, (short) 3, 2, (short) 7));

				HSSFRow row3 = sheet.createRow((short) 3);
				// Create a cell and put a value in it.
				HSSFCell cell30 = row3.createCell((short) 3);
				cell30.setCellValue("Monthly Sick Report for Admissions for the period ("
						+ fromDateStr + " to "+toDateStr+")");
				cell30.setCellStyle(style1);
				sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));

				HSSFRow row4 = sheet.createRow((short) 4);
				// Create a cell and put a value in it.
				HSSFCell cell40 = row4.createCell((short) 3);
				cell40.setCellValue("OFFICERS / AIRMEN");
				cell40.setCellStyle(style1);
				sheet.addMergedRegion(new Region(4, (short) 3, 4, (short) 7));

				// Create a row and put some cells in it. Rows are 0
				// based.
				HSSFRow headingRow = sheet.createRow((short) 6);
				// Create a cell and put a value in it.
				HSSFCell cell50 = headingRow.createCell((short) 0);
				cell50.setCellValue("Sl.No");
				cell50.setCellStyle(style);
				HSSFCell cell51 = headingRow.createCell((short) 1);
				cell51.setCellValue("Name & Initial");
				cell51.setCellStyle(style);
				HSSFCell cell52 = headingRow.createCell((short) 2);
				cell52.setCellValue("Rank");
				cell52.setCellStyle(style);

				HSSFCell cell53 = headingRow.createCell((short) 3);
				cell53.setCellValue("Branch/Trade");
				cell53.setCellStyle(style);
				HSSFCell cell531 = headingRow.createCell((short) 4);
				cell531.setCellValue("Age");
				cell531.setCellStyle(style);
				HSSFCell cell54 = headingRow.createCell((short) 5);
				cell54.setCellValue("Service No");
				cell54.setCellStyle(style);
				HSSFCell cell55 = headingRow.createCell((short) 6);
				cell55.setCellValue("Unit");
				cell55.setCellStyle(style);
				HSSFCell cell56 = headingRow.createCell((short) 7);
				cell56.setCellValue("Diagnosis");
				cell56.setCellStyle(style);
				HSSFCell cell57 = headingRow.createCell((short) 8);
				cell57.setCellValue("DOA");
				cell57.setCellStyle(style);
				HSSFCell cell58 = headingRow.createCell((short) 9);
				cell58.setCellValue("How Disposed Off");
				cell58.setCellStyle(style);
				HSSFCell cell59 = headingRow.createCell((short) 10);
				cell59.setCellValue("DOD");
				cell59.setCellStyle(style);
				HSSFCell cell510 = headingRow.createCell((short) 11);
				cell510.setCellValue("No.of Days");
				cell510.setCellStyle(style);

				int row = 7;
				int slno = 0;

				for (Iterator iterator = inpatientList.iterator(); iterator
				.hasNext();) {
					Inpatient inpatient = (Inpatient) iterator.next();

					sheet.createRow((short) row).createCell((short) 0).setCellValue(++slno);

					String name = inpatient.getHin().getSFirstName() + "  "
					+ inpatient.getHin().getSMiddleName() + "  "
					+ inpatient.getHin().getSLastName();
					sheet.createRow((short) row).createCell((short) 1).setCellValue(name);

					if (inpatient.getHin().getRank() != null) {
						sheet.createRow((short) row).createCell((short) 2)
						.setCellValue(inpatient.getHin().getRank().getRankName());
					} else {
						sheet.createRow((short) row).createCell((short) 2).setCellValue("");
					}

					if (inpatient.getHin().getTrade() != null) {
						sheet.createRow((short) row).createCell((short) 3)
						.setCellValue(inpatient.getHin().getTrade().getTradeName());
					} else {
						sheet.createRow((short) row).createCell((short) 3).setCellValue("");
					}
					sheet.createRow((short) row).createCell((short) 4)
					.setCellValue(inpatient.getHin().getAge());

					sheet.createRow((short) row).createCell((short) 5)
					.setCellValue(inpatient.getHin().getServiceNo());

					if (inpatient.getHin().getUnit() != null) {
						sheet.createRow((short) row).createCell((short) 6)
						.setCellValue(
								inpatient.getHin().getUnit().getUnitAddress());
					} else {
						sheet.createRow((short) row).createCell((short)6)
						.setCellValue("");
					}

					List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();

					icdList = session.createCriteria(DischargeIcdCode.class)
					.createAlias("Inpatient", "inpatient").add(Restrictions.eq("DiagnosisStatus", "f"))
					.add(Restrictions.eq("inpatient.Id", inpatient.getId()))
					.addOrder(Order.asc("Id")).list();
					String icdCode = "";
					int i = 1;
					if (icdList.size() > 0) {
						for (Iterator iterator1 = icdList.iterator(); iterator1
						.hasNext();) {
							DischargeIcdCode dischargeIcdCode = (DischargeIcdCode) iterator1.next();
							String SubicdCode = "";
							SubicdCode = ""
								+ i
								+ ")"
								+ dischargeIcdCode.getIcd().getIcdSubCategory()
								.getIcdSubCategoryName() + " "
								+ dischargeIcdCode.getIcd().getIcdName()
								+ "( ICD No "
								+ dischargeIcdCode.getIcd().getIcdCode()
								+")";
							icdCode = icdCode + SubicdCode + "\n";
							i++;
						}
					}

					sheet.createRow((short) row).createCell((short) 7).setCellValue(icdCode);

					SimpleDateFormat dateformatOut = new SimpleDateFormat("dd-MM-yyyy");
					SimpleDateFormat dateformatIn = new SimpleDateFormat("yyyy-MM-dd");

					if (inpatient.getDateOfAddmission() != null) {
						try {
							sheet
							.createRow((short) row).createCell((short) 8)
							.setCellValue(dateformatOut.format(dateformatIn.parse(inpatient
									.getDateOfAddmission().toString())));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					} else {
						sheet.createRow((short) row).createCell((short) 8).setCellValue("");
					}
					List<Discharge> dischargeList = new ArrayList<Discharge>();

					dischargeList = session.createCriteria(Discharge.class)
					.add(Restrictions.eq("AdNo", inpatient.getAdNo()))
					.addOrder(Order.asc("Id")).list();

					if (dischargeList.size() > 0) {
						for (Iterator iterator2 = dischargeList.iterator(); iterator2
						.hasNext();) {
							Discharge discharge = (Discharge) iterator2.next();
							if (discharge.getDisposedTo() != null) {
								sheet.createRow((short) row).createCell(
										(short) 9).setCellValue(discharge.getDisposedTo().getDisposedToName());
							} else {
								sheet.createRow((short) row).createCell((short) 9).setCellValue("");
							}
						}
					} else {
						sheet.createRow((short) row).createCell((short) 9)
						.setCellValue("");
					}
					Date dischargedate=new Date();

					if (dischargeList.size() > 0) {
						for (Iterator iterator2 = dischargeList.iterator(); iterator2
						.hasNext();) {
							Discharge discharge = (Discharge) iterator2.next();
							if (discharge.getDateOfDischarge() != null) {
								try {
									sheet.createRow((short) row).createCell((short) 10)
									.setCellValue(dateformatOut.format(dateformatIn.parse(
											discharge.getDateOfDischarge().toString())));
								} catch (ParseException e1) {
									e1.printStackTrace();
								}
							} else {
								sheet.createRow((short) row).createCell((short) 10).setCellValue("");
							}
						}
					} else {
						sheet.createRow((short) row).createCell((short) 10)
						.setCellValue("");
					}

					if (dischargeList.size() > 0) {
						for (Iterator iterator2 = dischargeList.iterator(); iterator2
						.hasNext();) {
							Discharge discharge = (Discharge) iterator2.next();
							int difInDays = (int) ((discharge.getDateOfDischarge().getTime() - inpatient.getDateOfAddmission().getTime())/(1000*60*60*24));
							sheet.createRow((short) row).createCell((short) 11)
							.setCellValue(difInDays);
						}}

					sheet.setColumnWidth((short) 0, (short) (6 * 256));
					sheet.setColumnWidth((short) 1, (short) (15 * 256));
					sheet.setColumnWidth((short) 2, (short) (10 * 256));
					sheet.setColumnWidth((short) 3, (short) (10 * 256));
					sheet.setColumnWidth((short) 4, (short) (10 * 256));
					sheet.setColumnWidth((short) 5, (short) (10 * 256));
					sheet.setColumnWidth((short) 6, (short) (15 * 256));
					sheet.setColumnWidth((short) 7, (short) (25 * 256));
					sheet.setColumnWidth((short) 8, (short) (10 * 256));
					sheet.setColumnWidth((short) 9, (short) (15 * 256));
					sheet.setColumnWidth((short) 10, (short) (10 * 256));
					sheet.setColumnWidth((short) 11, (short) (6 * 256));
					row++;
				}
				// Write the output to a file
				grp_name = grp_name + ".xls";
				FileOutputStream fileOut = new FileOutputStream(grp_name);
				wb.write(fileOut);
				fileOut.close();

				map.put("flag", "DataFound");
				map.put("download_path", grp_name);
			} catch (IOException ioe) {
				ioe.printStackTrace();
				map.put("flag", "NoData");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			map.put("flag", "NoData");
		}
		return map;
	}
	//---Form 38-B--in Excel Formate----By Dipali---

	public Map<String, Object> searchMonthlySickExcelForm38BReport(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String hospitalName="";
		if(box.get("hospitalName") != null){
			hospitalName = (String)box.get("hospitalName");
		}
		String grp_name = "MONTHLYSICKFORM38B";
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List lst = new ArrayList();
			String fromDateStr = "";
			String toDateStr = "";
			String temp = "";
			lst.add(31);
			lst.add(59);
			lst.add(184);
			lst.add(450);
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			try {
				fromDateStr = formatterOut.format(formatterIn.parse(""+ box.getString(FROM_DATE)));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			SimpleDateFormat formatterIn1 = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				toDateStr = formatterOut1.format(formatterIn1.parse(""+ box.getString(TO_DATE)));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			temp = box.getString("nc");

			List<Object> monthlySickList = new ArrayList<Object>();
			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			Criteria crit = null;
			if(temp.equals("nc")){
				crit = session.createCriteria(Inpatient.class).createAlias("Hin","pt")
				.add(Restrictions.eq("pt.Relation.Id", 8)).add(Restrictions.eq("pt.ServiceType.Id", 2))
				.add(Restrictions.ne("AdStatus", "C"));
				//.add(Restrictions.in("pt.Unit.Id", lst)).add(Restrictions.eq("pt.Rank.Id", 19));
			}else{
				crit = session.createCriteria(Inpatient.class).createAlias("Hin","pt")
				.add(Restrictions.eq("pt.Relation.Id", 8)).add(Restrictions.eq("pt.ServiceType.Id", 2))
				.add(Restrictions.ne("AdStatus", "C"));
				//.add(Restrictions.in("pt.Unit.Id", lst)).add(Restrictions.ne("pt.Rank.Id", 19));
			}
			crit = crit.add(Restrictions.between("DischargeDate", java.sql.Date
					.valueOf(fromDateStr), java.sql.Date
					.valueOf(toDateStr))).addOrder(Order.asc("Id"));
			inpatientList = crit.list();

			try {
				byte[] buffer = new byte[18024];
				HSSFWorkbook wb = new HSSFWorkbook();
				HSSFSheet sheet = wb.createSheet("TESTEXCEL");
				// Create a new font and alter it.
				HSSFFont font = wb.createFont();
				font.setFontHeightInPoints((short) 10);
				font.setFontName(HSSFFont.FONT_ARIAL);
				font.setColor((short) 62);
				font.setItalic(false);
				font.setStrikeout(false);
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				HSSFFont font1 = wb.createFont();
				font1.setFontHeightInPoints((short) 10);
				font1.setFontName(HSSFFont.FONT_ARIAL);
				font1.setColor((short) 80);
				font1.setItalic(false);
				font1.setStrikeout(false);
				font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

				// Fonts are set into a style so create a new one to
				// use.
				HSSFCellStyle style = wb.createCellStyle();
				style.setFont(font);

				HSSFCellStyle style1 = wb.createCellStyle();
				style1.setFont(font1);
				style1.setLocked(true);

				HSSFRow row1 = sheet.createRow((short) 1);
				// Create a cell and put a value in it.
				HSSFCell cell10 = row1.createCell((short) 3);
				cell10.setCellValue("                                                                                                       AFMSF-40");
				cell10.setCellStyle(style1);
				sheet.addMergedRegion(new Region(1, (short) 3, 1, (short) 7));

				HSSFRow row2 = sheet.createRow((short) 2);
				// Create a cell and put a value in it.
				HSSFCell cell20 = row2.createCell((short) 3);
				cell20.setCellValue(hospitalName);
				cell20.setCellStyle(style1);
				sheet.addMergedRegion(new Region(2, (short) 3, 2, (short) 7));

				HSSFRow row3 = sheet.createRow((short) 3);
				// Create a cell and put a value in it.
				HSSFCell cell30 = row3.createCell((short) 3);
				cell30.setCellValue("SECTION - II DISCHARGE FROM HOSPITAL ("
						+ fromDateStr + " to "+toDateStr+")");
				cell30.setCellStyle(style1);
				sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));

				HSSFRow row4 = sheet.createRow((short) 4);
				// Create a cell and put a value in it.
				HSSFCell cell40 = row4.createCell((short) 3);
				cell40.setCellValue("OFFICERS/AIRMEN");
				cell40.setCellStyle(style1);
				sheet.addMergedRegion(new Region(4, (short) 3, 4, (short) 7));

				// Create a row and put some cells in it. Rows are 0
				// based.
				HSSFRow headingRow = sheet.createRow((short) 6);
				// Create a cell and put a value in it.
				HSSFCell cell50 = headingRow.createCell((short) 0);
				cell50.setCellValue("Sl.No");
				cell50.setCellStyle(style);
				HSSFCell cell51 = headingRow.createCell((short) 1);
				cell51.setCellValue("Name & Initial");
				cell51.setCellStyle(style);
				HSSFCell cell52 = headingRow.createCell((short) 2);
				cell52.setCellValue("Rank");
				cell52.setCellStyle(style);

				HSSFCell cell53 = headingRow.createCell((short) 3);
				cell53.setCellValue("Service No");
				cell53.setCellStyle(style);
				HSSFCell cell531 = headingRow.createCell((short) 4);
				cell531.setCellValue("Serial No of Form-38");
				cell531.setCellStyle(style);
				HSSFCell cell54 = headingRow.createCell((short) 5);
				cell54.setCellValue("Diagnosis");
				cell54.setCellStyle(style);
				HSSFCell cell55 = headingRow.createCell((short) 6);
				cell55.setCellValue("DOA");
				cell55.setCellStyle(style);
				HSSFCell cell56 = headingRow.createCell((short) 7);
				cell56.setCellValue("DOD");
				cell56.setCellStyle(style);
				HSSFCell cell57 = headingRow.createCell((short) 8);
				cell57.setCellValue("How Disposed Off");
				cell57.setCellStyle(style);
				HSSFCell cell58 = headingRow.createCell((short) 9);
				cell58.setCellValue("Whether Form 39 Submitted");
				cell58.setCellStyle(style);
				int row = 7;
				int slno = 0;

				for (Iterator iterator = inpatientList.iterator(); iterator.hasNext();) {
					Inpatient inpatient = (Inpatient) iterator.next();

					sheet.createRow((short) row).createCell((short) 0).setCellValue(++slno);

					String name = inpatient.getHin().getSFirstName() + "  "
					+ inpatient.getHin().getSMiddleName() + "  "
					+ inpatient.getHin().getSLastName();
					sheet.createRow((short) row).createCell((short) 1).setCellValue(name);

					if (inpatient.getHin().getRank() != null) {
						sheet.createRow((short) row).createCell((short) 2)
						.setCellValue(inpatient.getHin().getRank().getRankName());
					} else {
						sheet.createRow((short) row).createCell((short) 2).setCellValue("");
					}

					sheet.createRow((short) row).createCell((short) 3)
					.setCellValue(inpatient.getHin().getServiceNo());

					sheet.createRow((short) row).createCell((short) 4).setCellValue(" ");

					List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();

					icdList = session.createCriteria(DischargeIcdCode.class)
					.createAlias("Inpatient", "inpatient").add(Restrictions.eq("DiagnosisStatus", "f"))
					.add(Restrictions.eq("inpatient.Id", inpatient.getId()))
					.addOrder(Order.asc("Id")).list();
					String icdCode = "";
					int i = 1;
					if (icdList.size() > 0) {
						for (Iterator iterator1 = icdList.iterator(); iterator1
						.hasNext();) {
							DischargeIcdCode dischargeIcdCode = (DischargeIcdCode) iterator1.next();
							String SubicdCode = "";
							SubicdCode = ""
								+ i
								+ ")"
								+ dischargeIcdCode.getIcd().getIcdSubCategory()
								.getIcdSubCategoryName() + " "
								+ dischargeIcdCode.getIcd().getIcdName()
								+ "(ICD No "
								+ dischargeIcdCode.getIcd().getIcdCode()
								+")";
							icdCode = icdCode + SubicdCode + "\n";
							i++;
						}
					}

					sheet.createRow((short) row).createCell((short) 5).setCellValue(icdCode);

					SimpleDateFormat dateformatOut = new SimpleDateFormat("dd-MM-yyyy");
					SimpleDateFormat dateformatIn = new SimpleDateFormat("yyyy-MM-dd");

					if (inpatient.getDateOfAddmission() != null) {
						try {
							sheet
							.createRow((short) row).createCell((short) 6)
							.setCellValue(dateformatOut.format(dateformatIn.parse(inpatient
									.getDateOfAddmission().toString())));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					} else {
						sheet.createRow((short) row).createCell((short) 6).setCellValue("");
					}
					List<Discharge> dischargeList = new ArrayList<Discharge>();

					dischargeList = session.createCriteria(Discharge.class)
					.add(Restrictions.eq("AdNo", inpatient.getAdNo()))
					.addOrder(Order.asc("Id")).list();

					if (dischargeList.size() > 0) {
						for (Iterator iterator2 = dischargeList.iterator(); iterator2
						.hasNext();) {
							Discharge discharge = (Discharge) iterator2.next();
							if (discharge.getDateOfDischarge() != null) {
								try {
									sheet.createRow((short) row).createCell((short) 7)
									.setCellValue(dateformatOut.format(dateformatIn.parse(
											discharge.getDateOfDischarge().toString())));
								} catch (ParseException e1) {
									e1.printStackTrace();
								}	} else {
									sheet.createRow((short) row).createCell((short) 7).setCellValue("");
								}}} else {
									sheet.createRow((short) row).createCell((short) 7).setCellValue("");
								}

					if (dischargeList.size() > 0) {
						for (Iterator iterator2 = dischargeList.iterator(); iterator2
						.hasNext();) {
							Discharge discharge = (Discharge) iterator2.next();
							if (discharge.getDisposedTo() != null) {
								sheet.createRow((short) row).createCell(
										(short) 8).setCellValue(discharge.getDisposedTo().getDisposedToName());
							} else {
								sheet.createRow((short) row).createCell((short) 8).setCellValue("");
							}
						}
					} else {
						sheet.createRow((short) row).createCell((short) 8).setCellValue("");
					}
					sheet.createRow((short) row).createCell((short) 9).setCellValue(" ");

					sheet.setColumnWidth((short) 0, (short) (6 * 256));
					sheet.setColumnWidth((short) 1, (short) (15 * 256));
					sheet.setColumnWidth((short) 2, (short) (10 * 256));
					sheet.setColumnWidth((short) 3, (short) (10 * 256));
					sheet.setColumnWidth((short) 4, (short) (15 * 256));
					sheet.setColumnWidth((short) 5, (short) (30 * 256));
					sheet.setColumnWidth((short) 6, (short) (10 * 256));
					sheet.setColumnWidth((short) 7, (short) (10 * 256));
					sheet.setColumnWidth((short) 8, (short) (15 * 256));
					sheet.setColumnWidth((short) 9, (short) (15 * 256));
					row++;
				}
				// Write the output to a file
				grp_name = grp_name + ".xls";
				FileOutputStream fileOut = new FileOutputStream(grp_name);
				wb.write(fileOut);
				fileOut.close();

				map.put("flag", "DataFound");
				map.put("download_path", grp_name);
			} catch (IOException ioe) {
				ioe.printStackTrace();
				map.put("flag", "NoData");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			map.put("flag", "NoData");
		}
		return map;
	}	
	public boolean checkFRWDone(String ADNumber)
	{
		Session session = (Session) getSession();
		List<Inpatient> misFrwList = new ArrayList<Inpatient>();
		misFrwList = session.createCriteria(MisFrw.class).add(
				Restrictions.eq("AdNo", ADNumber)).list();

		if(misFrwList.size()==0)
		{
			return true;
		}else{
			return false;
		}
	}
	public  String getHospitalName(int hospitalId)
	{
		List<MasHospital> masHospitalList=new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		String hospitalName="";
		try
		{
			masHospitalList=session.createCriteria(MasHospital.class)
			.add(Restrictions.eq("Id", hospitalId)).list();
			if(masHospitalList.size()>0)
				hospitalName=masHospitalList.get(0).getHospitalName();	
		}catch(HibernateException he)
		{
			he.printStackTrace();
		}
		return hospitalName;
	}
	public Map<String, Object> getRankUnitSexList()
	{
		Map<String,Object> dataMap=new HashMap<String, Object>();
		Session session = (Session) getSession();
		try
		{
			List<MasUnit> unitList=session.createCriteria(MasUnit.class)
			.add(Restrictions.eq("Status","y")).addOrder(Order.asc("UnitName")).list();
			List<MasRank> rankList=session.createCriteria(MasRank.class)
			.add(Restrictions.eq("Status","y")).addOrder(Order.asc("RankName")).list();
			List<MasTrade> tradeList=session.createCriteria(MasTrade.class)
			.add(Restrictions.eq("Status","y")).addOrder(Order.asc("TradeName")).list();
			List<MasAdministrativeSex> sexList=session.createCriteria(MasAdministrativeSex.class)
			.add(Restrictions.eq("Status","y")).addOrder(Order.asc("AdministrativeSexName")).list();
			List<MasMedicalCategory> medicalCategoryList=session.createCriteria(MasMedicalCategory.class)
			.add(Restrictions.eq("Status","y")).addOrder(Order.asc("MedicalCategoryName")).list();
			//List<Patient> patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Status","y")).list();
			dataMap.put("unitList", unitList);
			dataMap.put("rankList", rankList);
			dataMap.put("tradeList", tradeList);
			dataMap.put("sexList", sexList);
			dataMap.put("medicalCategoryList", medicalCategoryList);
			//dataMap.put("patientList",patientList);
		}catch(HibernateException he)
		{
			he.printStackTrace();
		}
		return dataMap;
	}
	/*public Map<String,Object> submitFatalDocument(Box box)
		{
			Map<String, Object> map=new HashMap<String, Object>();
			boolean status=false;
			Session session = (Session) getSession();
			Transaction tx = null;

			try
			{			
			String service_no=box.getString("serviceNo");
			String ad_no=box.getString("adNo");
			int rank_id=Integer.parseInt(box.getString("rank"));
			String service_person_name=box.getString("sPerName");
			int unit_id=Integer.parseInt(box.getString("unit"));
			int trade_id=Integer.parseInt(box.getString(TRADE_ID));

			String dateOfBirth=box.getString(DATE_OF_BIRTH);
			String age=box.getString(AGE);
			String age_unit=box.getString(AGE_UNIT);
			String final_age=age+" "+age_unit;
			//String fatal_status=box.getString("fatalStatus");
			int sex_id=Integer.parseInt(box.getString("sex"));
			String commissionDate=box.getString("commissionDate");
			String total_service=box.getString(TOTAL_SERVICE);
			String total_service_period=box.getString(TOTAL_SERVICE_PERIOD);
			String final_total_service=total_service+" "+total_service_period;
			int medicalCategoryId=Integer.parseInt(box.getString("medicalCategory"));

			String dateOfAdmission=box.getString("dateOfAdmission");
			String preMedHistory=box.getString("preMedHistory");
			String diagnosis=box.getString("diagnosis");
			String hospitalName=box.getString("hospitalName");
			String timeOfAdmission=box.getString("timeOfAdmission");
			String fatalStatus=box.getString("status");
			String typeOfDeath=box.getString("typeOfDeath");
			String dateOfDeath=box.getString("dateOfDeath");
			String timeOfDeath=box.getString("timeOfDeath");
			String locationOfDeath=box.getString("locationOfDeath");
			String diseaseDeath=box.getString("diseaseDeath");
			String consequenceOf=box.getString("consequenceOf");
			String otherConditions=box.getString("otherConditions");

			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<MasRelation> masRelationList=session.createCriteria(MasRelation.class)
			 .add(Restrictions.eq("RelationName","Self")).list();
			MasRelation masRelation=masRelationList.get(0);
			if(fatalStatus.equalsIgnoreCase("u"))
			{
				Patient patient=new Patient();
				patient.setServiceNo(service_no);
				patient.setRelation(masRelation);
				patient.setPatientStatus("Expired");
				hbt.save(patient);
				//Integer hin_id=(Integer)hbt.save(patient);
				map.put("hin_id", patient.getId());
		    	FatalDocumentHeader fatalDocumentHeader=new FatalDocumentHeader();
			    fatalDocumentHeader.setHinId(patient);
			    fatalDocumentHeader.setAdNo(ad_no);
			    MasRank masRank=new MasRank();
		        masRank.setId(rank_id);
			    fatalDocumentHeader.setRankId(masRank);
			    MasUnit masUnit=new MasUnit();
			    masUnit.setId(rank_id);
			    fatalDocumentHeader.setUnitId(masUnit);
			    fatalDocumentHeader.setSPersonName(service_person_name);
			    MasTrade masTrade=new MasTrade();
			masTrade.setId(trade_id);
			fatalDocumentHeader.setTradeId(masTrade);
			fatalDocumentHeader.setDateOfBirth(new Date(dateOfBirth));
			fatalDocumentHeader.setAge(final_age);
			MasAdministrativeSex masAdministrativeSex=new MasAdministrativeSex();
			masAdministrativeSex.setId(sex_id);
			fatalDocumentHeader.setSexId(masAdministrativeSex);
			fatalDocumentHeader.setDateOfComm(new Date(commissionDate));
			fatalDocumentHeader.setTotalService(final_total_service);
			MasMedicalCategory masMedicalCategory=new MasMedicalCategory();
			masMedicalCategory.setId(medicalCategoryId);
			fatalDocumentHeader.setMedicalCategoryId(masMedicalCategory);
			if((dateOfAdmission!=null)&&(!dateOfAdmission.equals("")))
			fatalDocumentHeader.setDateOfAdmission(new Date(dateOfAdmission));
			fatalDocumentHeader.setPrevMedHistory(preMedHistory);
			fatalDocumentHeader.setDiagnosis(diagnosis);
			fatalDocumentHeader.setHospitalName(hospitalName);
			fatalDocumentHeader.setTimeOfAdmission(timeOfAdmission);
			fatalDocumentHeader.setStatus(fatalStatus);
			fatalDocumentHeader.setTypeOdDeath(typeOfDeath);
			fatalDocumentHeader.setDateOfDeath(new Date(dateOfDeath));
			fatalDocumentHeader.setTimeOfDeath(timeOfDeath);
			fatalDocumentHeader.setLocationOfDeath(locationOfDeath);
			fatalDocumentHeader.setConditionToDeath(diseaseDeath);
			fatalDocumentHeader.setDueConsequence(consequenceOf);
			fatalDocumentHeader.setOtherCondition(otherConditions);
			hbt.save(fatalDocumentHeader);			
			}else if(fatalStatus.equalsIgnoreCase("r"))
			{

				int hinId=box.getInt("hinId");
				map.put("hin_id", hinId);
				FatalDocumentHeader fatalDocumentHeader=new FatalDocumentHeader();
				Patient patient=(Patient)session.load(Patient.class,hinId);
			    fatalDocumentHeader.setHinId(patient);
			    fatalDocumentHeader.setDiagnosis(diagnosis);
			    fatalDocumentHeader.setStatus(fatalStatus);
			    fatalDocumentHeader.setTypeOdDeath(typeOfDeath);
			    fatalDocumentHeader.setDateOfDeath(new Date(dateOfDeath));
			    fatalDocumentHeader.setTimeOfDeath(timeOfDeath);
			    fatalDocumentHeader.setLocationOfDeath(locationOfDeath);
			    fatalDocumentHeader.setConditionToDeath(diseaseDeath);
			    fatalDocumentHeader.setDueConsequence(consequenceOf);
			    fatalDocumentHeader.setOtherCondition(otherConditions);
			hbt.save(fatalDocumentHeader);		
			}
			tx.commit();
		    status=true;
			}catch(Exception e)
			{
				if(tx !=null)
					tx.rollback();
				e.printStackTrace();
			}
			map.put("status", status);
			return map;

		}*/

	public Map<String,Object> submitFatalDocument(Box box)
	{
		Map<String, Object> map=new HashMap<String, Object>();
		boolean status=false;
		Session session = (Session) getSession();
		Transaction tx = null;

		try
		{			
			String service_no=box.getString("serviceNo");
			String ad_no=box.getString("adNo");
			int rank_id=Integer.parseInt(box.getString("rank"));
			String service_person_name=box.getString("sPerName");
			int unit_id=Integer.parseInt(box.getString("unit"));
			int trade_id=Integer.parseInt(box.getString(TRADE_ID));

			String dateOfBirth=box.getString(DATE_OF_BIRTH);
			String age=box.getString(AGE);
			String age_unit=box.getString(AGE_UNIT);
			String final_age=age+" "+age_unit;
			//String fatal_status=box.getString("fatalStatus");
			int sex_id=Integer.parseInt(box.getString("sex"));
			String commissionDate=box.getString("commissionDate");
			String total_service=box.getString(TOTAL_SERVICE);
			String total_service_period=box.getString(TOTAL_SERVICE_PERIOD);
			String final_total_service=total_service+" "+total_service_period;
			int medicalCategoryId=Integer.parseInt(box.getString("medicalCategory"));

			String dateOfAdmission=box.getString("dateOfAdmission");
			String preMedHistory=box.getString("preMedHistory");
			String diagnosis=box.getString("diagnosis");
			String hospitalName=box.getString("hospitalName");
			String timeOfAdmission=box.getString("timeOfAdmission");
			String fatalStatus=box.getString("status");
			String typeOfDeath=box.getString("typeOfDeath");
			String dateOfDeath=box.getString("dateOfDeath");
			String timeOfDeath=box.getString("timeOfDeath");
			String locationOfDeath=box.getString("locationOfDeath");
			String diseaseDeath=box.getString("diseaseDeath");
			String consequenceOf=box.getString("consequenceOf");
			String otherConditions=box.getString("otherConditions");

			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<MasRelation> masRelationList=session.createCriteria(MasRelation.class)
			.add(Restrictions.eq("RelationName","Self")).list();
			MasRelation masRelation=masRelationList.get(0);
			if(fatalStatus.equalsIgnoreCase("u"))
			{
				/*Patient patient=new Patient();
				patient.setServiceNo(service_no);
				patient.setRelation(masRelation);
				patient.setPatientStatus("Expired");
				hbt.save(patient);
				//Integer hin_id=(Integer)hbt.save(patient);
				map.put("hin_id", patient.getId());*/
				//   fatalDocumentHeader.setHinId(patient);
				FatalDocumentHeader fatalDocumentHeader=new FatalDocumentHeader();
				fatalDocumentHeader.setServiceNo(service_no);
				fatalDocumentHeader.setAdNo(ad_no);
				MasRank masRank=new MasRank();
				masRank.setId(rank_id);
				fatalDocumentHeader.setRankId(masRank);
				MasUnit masUnit=new MasUnit();
				masUnit.setId(unit_id);
				fatalDocumentHeader.setUnitId(masUnit);
				fatalDocumentHeader.setSPersonName(service_person_name);
				if(trade_id!=0){
					MasTrade masTrade=new MasTrade();
					masTrade.setId(trade_id);
					fatalDocumentHeader.setTradeId(masTrade);
				}
				if(!dateOfBirth.equals(""))
					fatalDocumentHeader.setDateOfBirth(HMSUtil.convertStringTypeDateToDateType(dateOfBirth));
				fatalDocumentHeader.setAge(final_age);
				MasAdministrativeSex masAdministrativeSex=new MasAdministrativeSex();
				masAdministrativeSex.setId(sex_id);
				fatalDocumentHeader.setSexId(masAdministrativeSex);
				if(!commissionDate.equals(""))
					fatalDocumentHeader.setDateOfComm(HMSUtil.convertStringTypeDateToDateType(commissionDate));
				fatalDocumentHeader.setTotalService(final_total_service);
				if(medicalCategoryId!=0){
					MasMedicalCategory masMedicalCategory=new MasMedicalCategory();
					masMedicalCategory.setId(medicalCategoryId);
					fatalDocumentHeader.setMedicalCategoryId(masMedicalCategory);
				}
				if((dateOfAdmission!=null)&&(!dateOfAdmission.equals("")))
					fatalDocumentHeader.setDateOfAdmission(HMSUtil.convertStringTypeDateToDateType(dateOfAdmission));
				fatalDocumentHeader.setPrevMedHistory(preMedHistory);
				fatalDocumentHeader.setDiagnosis(diagnosis);
				fatalDocumentHeader.setHospitalName(hospitalName);
				fatalDocumentHeader.setTimeOfAdmission(timeOfAdmission);
				fatalDocumentHeader.setStatus(fatalStatus);
				fatalDocumentHeader.setTypeOdDeath(typeOfDeath);
				fatalDocumentHeader.setDateOfDeath(HMSUtil.convertStringTypeDateToDateType(dateOfDeath));
				fatalDocumentHeader.setTimeOfDeath(timeOfDeath);
				fatalDocumentHeader.setLocationOfDeath(locationOfDeath);
				fatalDocumentHeader.setConditionToDeath(diseaseDeath);
				fatalDocumentHeader.setDueConsequence(consequenceOf);
				fatalDocumentHeader.setOtherCondition(otherConditions);
				if(!box.getString("mlcNo").equals("")){
					fatalDocumentHeader.setMlcNo(box.getString("mlcNo"));
				}

				hbt.save(fatalDocumentHeader);			
			}else if(fatalStatus.equalsIgnoreCase("r"))
			{

				int hinId=box.getInt("hinId");
				map.put("hin_id", hinId);
				FatalDocumentHeader fatalDocumentHeader=new FatalDocumentHeader();
				Patient patient=(Patient)session.load(Patient.class,hinId);
				fatalDocumentHeader.setServiceNo(service_no);
				fatalDocumentHeader.setHinId(patient);
				fatalDocumentHeader.setServiceNo(service_no);
				fatalDocumentHeader.setAdNo(ad_no);
				MasRank masRank=new MasRank();
				masRank.setId(rank_id);
				fatalDocumentHeader.setRankId(masRank);
				MasUnit masUnit=new MasUnit();
				masUnit.setId(unit_id);
				fatalDocumentHeader.setUnitId(masUnit);
				fatalDocumentHeader.setSPersonName(service_person_name);
				MasTrade masTrade=new MasTrade();
				masTrade.setId(trade_id);
				fatalDocumentHeader.setTradeId(masTrade);
				fatalDocumentHeader.setDateOfBirth(new Date(dateOfBirth));
				fatalDocumentHeader.setAge(final_age);
				MasAdministrativeSex masAdministrativeSex=new MasAdministrativeSex();
				masAdministrativeSex.setId(sex_id);
				fatalDocumentHeader.setSexId(masAdministrativeSex);
				fatalDocumentHeader.setDateOfComm(new Date(commissionDate));
				fatalDocumentHeader.setTotalService(final_total_service);
				MasMedicalCategory masMedicalCategory=new MasMedicalCategory();
				masMedicalCategory.setId(medicalCategoryId);
				fatalDocumentHeader.setMedicalCategoryId(masMedicalCategory);
				if((dateOfAdmission!=null)&&(!dateOfAdmission.equals("")))
					fatalDocumentHeader.setDateOfAdmission(new Date(dateOfAdmission));

				fatalDocumentHeader.setDiagnosis(diagnosis);
				fatalDocumentHeader.setStatus(fatalStatus);
				fatalDocumentHeader.setTypeOdDeath(typeOfDeath);
				fatalDocumentHeader.setDateOfDeath(new Date(dateOfDeath));
				fatalDocumentHeader.setTimeOfDeath(timeOfDeath);
				fatalDocumentHeader.setLocationOfDeath(locationOfDeath);
				fatalDocumentHeader.setConditionToDeath(diseaseDeath);
				fatalDocumentHeader.setDueConsequence(consequenceOf);
				fatalDocumentHeader.setOtherCondition(otherConditions);
				if(!box.getString("mlcNo").equals("")){
					fatalDocumentHeader.setMlcNo(box.getString("mlcNo"));
				}
				hbt.save(fatalDocumentHeader);		
			}else if(!fatalStatus.equals("")){
				Patient patient=new Patient();
				patient.setServiceNo(service_no);
				patient.setRelation(masRelation);
				patient.setPatientStatus("Expired");
				hbt.save(patient);
				//Integer hin_id=(Integer)hbt.save(patient);
				map.put("hin_id", patient.getId());
				FatalDocumentHeader fatalDocumentHeader=new FatalDocumentHeader();
				fatalDocumentHeader.setHinId(patient);
				fatalDocumentHeader.setAdNo(ad_no);
				MasRank masRank=new MasRank();
				masRank.setId(rank_id);
				fatalDocumentHeader.setRankId(masRank);
				MasUnit masUnit=new MasUnit();
				masUnit.setId(unit_id);
				fatalDocumentHeader.setUnitId(masUnit);
				fatalDocumentHeader.setSPersonName(service_person_name);
				MasTrade masTrade=new MasTrade();
				masTrade.setId(trade_id);
				fatalDocumentHeader.setTradeId(masTrade);
				fatalDocumentHeader.setDateOfBirth(new Date(dateOfBirth));
				fatalDocumentHeader.setAge(final_age);
				MasAdministrativeSex masAdministrativeSex=new MasAdministrativeSex();
				masAdministrativeSex.setId(sex_id);
				fatalDocumentHeader.setSexId(masAdministrativeSex);
				fatalDocumentHeader.setDateOfComm(new Date(commissionDate));
				fatalDocumentHeader.setTotalService(final_total_service);
				MasMedicalCategory masMedicalCategory=new MasMedicalCategory();
				masMedicalCategory.setId(medicalCategoryId);
				fatalDocumentHeader.setMedicalCategoryId(masMedicalCategory);
				if((dateOfAdmission!=null)&&(!dateOfAdmission.equals("")))
					fatalDocumentHeader.setDateOfAdmission(new Date(dateOfAdmission));
				fatalDocumentHeader.setPrevMedHistory(preMedHistory);
				fatalDocumentHeader.setDiagnosis(diagnosis);
				fatalDocumentHeader.setHospitalName(hospitalName);
				fatalDocumentHeader.setTimeOfAdmission(timeOfAdmission);
				fatalDocumentHeader.setStatus(fatalStatus);
				fatalDocumentHeader.setTypeOdDeath(typeOfDeath);
				fatalDocumentHeader.setDateOfDeath(new Date(dateOfDeath));
				fatalDocumentHeader.setTimeOfDeath(timeOfDeath);
				fatalDocumentHeader.setLocationOfDeath(locationOfDeath);
				fatalDocumentHeader.setConditionToDeath(diseaseDeath);
				fatalDocumentHeader.setDueConsequence(consequenceOf);
				fatalDocumentHeader.setOtherCondition(otherConditions);
				if(!box.getString("mlcNo").equals("")){
					fatalDocumentHeader.setMlcNo(box.getString("mlcNo"));
				}
				hbt.save(fatalDocumentHeader);	
			}
			tx.commit();
			status=true;
		}catch(Exception e)
		{
			if(tx !=null)
				tx.rollback();
			e.printStackTrace();
		}
		map.put("status", status);
		return map;

	}
	public Map<String,Object> getWaitingPatientList(Map mapForDS)
	{  Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	int deptId = (Integer) mapForDS.get("deptId");
	int hospitalId = (Integer) mapForDS.get("hospitalId");
	String userId = ""+mapForDS.get("userId");		
	String n="n";
	List<MalariaCase> patientList = new ArrayList<MalariaCase>();
	try
	{
		//String query = "select * from malaria_case where malaria_case.forward_to = "+userId;
		//patientList = session.createSQLQuery(query).list();
		patientList = session.createCriteria(MalariaCase.class).add(Restrictions.eq("ForwardTo",userId)).add(Restrictions.eq("Status",n)).list();  	 	

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}     
	map.put("patientList", patientList); 
	return  map;
	}
	public Map<String,Object> getWaitingPatientListForcouncling(Map mapForDS)
	{  Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	int deptId = (Integer) mapForDS.get("deptId");
	int hospitalId = (Integer) mapForDS.get("hospitalId");
	String userId = ""+mapForDS.get("userId");		
	int userId1=Integer.parseInt(userId);

	String n="n";
	List<FeedbackOfCounselor> patientList = new ArrayList<FeedbackOfCounselor>();
	try
	{
		//String query = "select * from malaria_case where malaria_case.forward_to = "+userId;
		//patientList = session.createSQLQuery(query).list();
		patientList = session.createCriteria(FeedbackOfCounselor.class).add(Restrictions.eq("ForWardedTo.Id",userId1)).add(Restrictions.eq("MoStatus","Pending")).list();  	 	

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}     
	map.put("patientList", patientList); 
	return  map;
	}

	public Map<String,Object> getPatientForValidate(Map mapForDS)
	{   Map<String,Object> map = new HashMap<String,Object>();
	Session session = (Session)getSession();
	List<MalariaCase> patientList = new ArrayList<MalariaCase>();
	List<Inpatient>  inpatientList = new ArrayList<Inpatient>();
	int hospitalId =0;
	int hinId =0;
	if(mapForDS.get("hinId")!= null)
	{
		hinId = (Integer)mapForDS.get("hinId"); 

	}
	if(mapForDS.get("hospitalId")!= null)
	{
		hospitalId = (Integer)mapForDS.get("hospitalId");
	}


	try
	{
		patientList = session.createCriteria(MalariaCase.class).add(Restrictions.eq("HinId.Id", hinId)).list();
		// inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Hin", hinId)).list();
		inpatientList = session.createCriteria(Inpatient.class).add(
				Restrictions.eq("Hin.Id", hinId)).list();
	}

	catch(Exception e)
	{
		e.printStackTrace();
	}

	map.put("patientList", patientList); 
	//map.put("inpatientList", inpatientList); 
	return  map;
	}
	public Map<String, Object> getPatientDetails(Map<String, Object> dataMap)
	{

		Session session = (Session) getSession();
		List<Object> patientList = new ArrayList<Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		int hospitalId=0;
		if (dataMap.get("serviceNo") != null)
		{
			serviceNo = "" + dataMap.get("serviceNo");
		}
		if (dataMap.get("hospitalId") != null)
		{
			hospitalId = Integer.parseInt(""+dataMap.get("hospitalId"));
		}     
		try {
			patientList = session.createCriteria(Patient.class).add(
					Restrictions.eq("ServiceNo", serviceNo)).add(
							Restrictions.eq("Relation.Id", 8)).list();
			int hin_id=0;
			if(patientList.size()>0)
			{
				Patient patient=(Patient)patientList.get(0);
				hin_id=patient.getId();
			}

			List<Inpatient> inpatientList=session.createCriteria(Inpatient.class)
			.add(Restrictions.eq("Hin.Id",hin_id)).list();
			List<OpdPatientHistory> opdPatientHistoryList=session.createCriteria(OpdPatientHistory.class)
			.add(Restrictions.eq("Hin.Id",hin_id)).list();
			List<MasMedicalExaminationReportOnEntry> masMedicalExaminationList=session.createCriteria(MasMedicalExaminationReportOnEntry.class)
			.add(Restrictions.eq("Hin.Id",hin_id)).list();
			List<FatalDocumentHeader> fatalDocumentHeader=session.createCriteria(FatalDocumentHeader.class)
			.add(Restrictions.eq("HinId.Id",hin_id)).list();
			List<MasUnit> unitList=session.createCriteria(MasUnit.class)
			.add(Restrictions.eq("Status","y")).list();
			List<MasRank> rankList=session.createCriteria(MasRank.class)
			.add(Restrictions.eq("Status","y")).list();
			List<MasTrade> tradeList=session.createCriteria(MasTrade.class)
			.add(Restrictions.eq("Status","y")).list();
			List<MasAdministrativeSex> sexList=session.createCriteria(MasAdministrativeSex.class)
			.add(Restrictions.eq("Status","y")).list();
			List<MasMedicalCategory> medicalCategoryList=session.createCriteria(MasMedicalCategory.class)
			.add(Restrictions.eq("Status","y")).list();

			map.put("masMedicalExaminationList",masMedicalExaminationList);
			map.put("opdPatientHistoryList",opdPatientHistoryList);
			map.put("inpatientList",inpatientList);
			map.put("fatalDocumentHeader", fatalDocumentHeader);
			map.put("patientList", patientList);
			map.put("unitList", unitList);
			map.put("rankList", rankList);
			map.put("tradeList", tradeList);
			map.put("sexList", sexList);
			map.put("medicalCategoryList", medicalCategoryList);	

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> showMonitoringOfAds(Map<String, Object> map)
	{
		Map<String, Object> map1 = new HashMap<String, Object>();
		List<Category>  categoryList = new ArrayList<Category>();
		categoryList = getHibernateTemplate().find("from jkt.hms.masters.business.Category");
		map.put("categoryList", categoryList);
		return map;
	}
	public boolean validateSmoMalariaCase(Map map)
	{   boolean succesfullyAdded = false;
	Session session = (Session) getSession();
	int  hinId =0;
	Criteria crit = null;	
	String v= "v";
	if(map.get("hinId")!= null)
	{ 
		hinId =(Integer) map.get("hinId");
	}

	try
	{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		//String query = "update MALARIA_CASE Status='v' where MALARIA_CASE.HinId = "+hinId;
		MalariaCase malariaCase = (MalariaCase)hbt.load(MalariaCase.class, hinId);
		malariaCase.setStatus(v) ;
		hbt.update( malariaCase);
		succesfullyAdded = true;
	}

	catch(Exception e)
	{
		e.printStackTrace();
	}

	return   succesfullyAdded;
	}
	public Map<String, Object> displayFileUploadData(Map<String, Object> dataMap)
	{
		int hinId=0;
		int visitId = 0;
		if(dataMap.get("hinId")!= null && !dataMap.get("hinId").equals(""))
		{
			hinId=(Integer)dataMap.get("hinId");
		}
		if(dataMap.get("visitId")!= null && !dataMap.get("visitId").equals(""))
		{
			visitId=(Integer)dataMap.get("visitId");
		}
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
	public Map<String, Object> submitUploadDocumentsAreaForSho(Map<String, Object> mapForDS)
	{				Map<String, Object> map = new HashMap<String, Object>();
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
				//MasMedicalUploadDocument masUploadDocuments = new MasMedicalUploadDocument();
				//String dataInput = new String(bytes);
				//masUploadDocuments.setFileName(fileName);
				//masUploadDocuments.setFileExtension(fileExtensionList.get(i));
				//masUploadDocuments.setDocument(bytes);
				//DgMasInvestigation dgMasInvestigation=new DgMasInvestigation();
				//dgMasInvestigation.setId(investId);
				//masUploadDocuments.setDgMasInvestigation(dgMasInvestigation);
				//Patient patient = new Patient();
				//patient.setId(hinId);
				//masUploadDocuments.setHin(patient);
				//MasHospital masHospital = new MasHospital();
				//masHospital.setId(hospitalId);
				//masUploadDocuments.setHospital(masHospital);
				//MasMedicalExaminationReportOnEntry masMedicalExamReport=new MasMedicalExaminationReportOnEntry();
				//masMedicalExamReport.setId(masMedicalExamId);
				//masUploadDocuments.setMasMedicalExamReport(masMedicalExamReport);
				//masUploadDocuments.setDescription(descriptionList.get(i));		
				//masUploadDocuments.setFileFlag(folderName); 
				// hbt.save(masUploadDocuments);
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

	@Override
	public Map<String, Object> getPatientForValidateCounselling(
			Map<String, Object> mapForDS) {   Map<String,Object> map = new HashMap<String,Object>();
			Session session = (Session)getSession();
			List<FeedbackOfCounselor> patientList = new ArrayList<FeedbackOfCounselor>();
			List<Inpatient>  inpatientList = new ArrayList<Inpatient>();
			int hospitalId =0;
			int counsellingId =0;
			if(mapForDS.get("counsellingId")!= null)
			{
				counsellingId = (Integer)mapForDS.get("counsellingId"); 

			}
			if(mapForDS.get("hospitalId")!= null)
			{
				hospitalId = (Integer)mapForDS.get("hospitalId");
			}


			try
			{
				patientList = session.createCriteria(FeedbackOfCounselor.class).add(Restrictions.eq("Id", counsellingId)).list();
				// inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Hin", hinId)).list();
				/*inpatientList = session.createCriteria(Inpatient.class).add(
								Restrictions.eq("Hin.Id", counsellingId)).list();*/
			}

			catch(Exception e)
			{
				e.printStackTrace();
			}

			map.put("patientList", patientList); 
			//map.put("inpatientList", inpatientList); 
			return  map;
	}


	@Override
	public boolean validateSmoCounseling(Map<String, Object> map) {
		boolean succesfullyAdded = false;
		Session session = (Session) getSession();
		int  counselingId =0;
		Criteria crit = null;	
		String rem1= "";
		if(map.get("counselingId")!= null)
		{ 
			counselingId =(Integer) map.get("counselingId");
		}
		if(map.get("rem1")!= null)
		{ 
			rem1 =(String) map.get("rem1");
		}
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			//String query = "update MALARIA_CASE Status='v' where MALARIA_CASE.HinId = "+hinId;
			FeedbackOfCounselor feedbackOfCounselor = (FeedbackOfCounselor)hbt.load(FeedbackOfCounselor.class, counselingId);
			feedbackOfCounselor.setMoStatus("Validated");
			feedbackOfCounselor.setSMOREMARKS(rem1);
			hbt.update( feedbackOfCounselor);
			succesfullyAdded = true;
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}

		return   succesfullyAdded;
	}

	public Map<String, Object> submitUploadDocumentsVectorControlForSho(Map<String, Object> mapForDS)
	{				Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	String folderName="";
	int hospitalId=0;
	List<String> fileNameList= new ArrayList<String>();
	List<String> fileExtensionList= new ArrayList<String>();
	List<String> descriptionList= new ArrayList<String>();
	List<Integer> counterList= new ArrayList<Integer>();
	//int hinId =(Integer)mapForDS.get("hinId");
	if(mapForDS.get("hospitalId")!= null)
	{
		hospitalId =(Integer)mapForDS.get("hospitalId");
	}
	//int investId=(Integer)mapForDS.get("investId");
	//int masMedicalExamId =(Integer)mapForDS.get("masMedicalExamId");
	if(mapForDS.get("fileNameList")!= null)
	{
		fileNameList=(List<String>)mapForDS.get("fileNameList");
	}
	if(mapForDS.get("fileExtensionList")!= null)
	{
		fileExtensionList=(List<String>)mapForDS.get("fileExtensionList");
	}
	if(mapForDS.get("descriptionList")!= null)
	{
		descriptionList=(List<String>)mapForDS.get("descriptionList");
	}
	if(mapForDS.get("counterList")!= null)
	{
		counterList=(List<Integer>)mapForDS.get("counterList");
	}
	if(mapForDS.get("folderName")!= null)
	{
		folderName=(String)mapForDS.get("folderName");
	}
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
				//dgMasInvestigation.setId(investId);
				//masUploadDocuments.setDgMasInvestigation(dgMasInvestigation);
				Patient patient = new Patient();
				//patient.setId(hinId);
				//masUploadDocuments.setHin(patient);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				masUploadDocuments.setHospital(masHospital);
				MasMedicalExaminationReportOnEntry masMedicalExamReport=new MasMedicalExaminationReportOnEntry();
				//masMedicalExamReport.setId(masMedicalExamId);
				//masUploadDocuments.setMasMedicalExamReport(masMedicalExamReport);
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
		//int hinId =(Integer)dataMap.get("hinId");
		int hospitalId =(Integer)dataMap.get("hospitalId");
		//int masExamId =(Integer)dataMap.get("masExamId");
		String folderName=(String)dataMap.get("folderName");
		//int visitId=(Integer)dataMap.get("visitId");
		try
		{
			List<MasMedicalUploadDocument> masMedicalUploadDocumentList=session.createCriteria(MasMedicalUploadDocument.class)
			//.add(Restrictions.eq("MasMedicalExamReport.Id",masExamId)).add(Restrictions.eq("Hin.Id",hinId)).add(Restrictions.eq("Hin.Id",hinId))
			.add(Restrictions.eq("Hospital.Id",hospitalId))
			.add(Restrictions.eq("FileFlag",folderName)).list();
			map.put("masMedicalUploadDocumentList", masMedicalUploadDocumentList);
			//Patient patient=(Patient)session.get(Patient.class,hinId);
			//Visit visit=(Visit)session.get(Visit.class, visitId);
			//map.put("patient", patient)	;
			//map.put("visit", visit)	;
		}
		catch (HibernateException he)
		{
			he.printStackTrace();
		}
		return map;
	}
	public Map<String, Object> getUploadDocumentShoData(Map<String, Object> dataMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int hospitalId=0;
		String fileName="";
		String folderName="";
		String fileExtension="";
		//int hinId =(Integer)dataMap.get("hinId");
		hospitalId =(Integer)dataMap.get("hospitalId");
		//int masExamId =(Integer)dataMap.get("medExamId");
		if(dataMap.get("filename")!= null)
		{
			fileName=(String)dataMap.get("filename");
		}
		fileExtension=(String)dataMap.get("fileExtension");
		try
		{
			List<MasMedicalUploadDocument> masMedicalUploadDocumentList=session.createCriteria(MasMedicalUploadDocument.class)
			//.add(Restrictions.eq("MasMedicalExamReport.Id",masExamId)).add(Restrictions.eq("Hin.Id",hinId)).add(Restrictions.eq("Hin.Id",hinId))
			.add(Restrictions.eq("Hospital.Id",hospitalId)).add(Restrictions.eq("FileFlag",folderName))
			.add(Restrictions.eq("FileName",fileName)).add(Restrictions.eq("FileExtension",fileExtension)).list();
			map.put("masMedicalUploadDocumentList", masMedicalUploadDocumentList);
		}catch (HibernateException he)
		{
			he.printStackTrace();
		}
		return map;
	}



	public boolean saveWaterSurvillanceDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		String message = "";
		String messageType = "";
		String currentDate = null;
		String currentTime = "";			
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		String changedBy = "";
		int recordcount = box.getInt("allergyCount"); 
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		for(int i=1;i<=recordcount;i++){

			//WaterSurvillance waterSurvillance=new WaterSurvillance();

			MasDepartment masDepartment=new MasDepartment();
			masDepartment.setId(box.getInt("departmentId"));
			//waterSurvillance.setDepartmentId(masDepartment);

			MasEmployee masEmployee=new MasEmployee();
			masEmployee.setId(box.getInt("userId"));
			//waterSurvillance.setLastChangeBy(masEmployee);

			MasHospital masHospital=new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			/*waterSurvillance.setHospitalId(masHospital);
			waterSurvillance.setTypeOfExamination(box.getString("toe"+i));
			waterSurvillance.setSourceOfWaterSupply(box.getString("source"+i));
			waterSurvillance.setPlaceOfCollection(box.getString("place"+i));
			waterSurvillance.setResult(box.getString("result"+i));
			waterSurvillance.setRemarks(box.getString("remarks"+i));

			waterSurvillance.setLastChangeTime(currentTime);
			hbt.save(waterSurvillance);*/
			saved=true;
		}
		return saved;
	}

	public boolean submitMonthlyWorkload(Map<String, Object> map)
	{
		
		boolean succesfullyAdded  = true;
		Session session = (Session) getSession();

		int unitId = 0;
		int hospitalId = 0;
		String totalPopulation = (String) map.get("totalPopulation");
		String OffAirCrew = (String) map.get("OffAirCrew");
		String OffGD = (String) map.get("OffGD");
		String airmenAirCrew = (String) map.get("airmenAirCrew");
		String airmenOthers = (String) map.get("airmenOthers");
		String ncs = (String) map.get("ncs");
		String dsc = (String) map.get("dsc");
		String allFamilies = (String) map.get("allFamilies");
		String totalSick = (String) map.get("totalSick");
		String populationSick = (String) map.get("populationSick");
		String servicePerson = (String) map.get("servicePerson");
		String families = (String) map.get("families");
		String total = (String) map.get("total");
		String populationServicePerson = (String) map.get("populationServicePerson");
		String allPerson = (String) map.get("allPerson");
		String populationAll = (String) map.get("populationAll");
		String medicalBoard = (String) map.get("medicalBoard");
		String medicalExam = (String) map.get("medicalExam");
		String month = (String) map.get("month");
		String changedBy = (String) map.get("changedBy");
		String changedDate = (String) map.get("changedDate");
		String changedTime = (String) map.get("changedTime");
	
		if(map.get("unitId")!= null && !(map.get("unitId").equals("")))
		{
			unitId=(Integer)(map.get("unitId"));
		}
		
		if(map.get("hospitalId")!= null && !(map.get("hospitalId").equals("")))
		{
			hospitalId=(Integer)(map.get("hospitalId"));
		}
		

		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			ShoMonthlyWorkLoad monthlyWorkLoad = new ShoMonthlyWorkLoad();  
			
			MasUnit masUnit = new MasUnit();
			masUnit.setId(unitId);
			monthlyWorkLoad.setUnit(masUnit);
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			monthlyWorkLoad.setHospital(masHospital);
			
			monthlyWorkLoad.setMonth(month);
			monthlyWorkLoad.setTotalPopulation(totalPopulation);
			monthlyWorkLoad.setOffAircrew(OffAirCrew);
			monthlyWorkLoad.setOffGd(OffGD);
			monthlyWorkLoad.setAirmenAircrew(airmenAirCrew);
			monthlyWorkLoad.setAirmenOthers(airmenOthers);
			monthlyWorkLoad.setNcs(ncs);
			monthlyWorkLoad.setDsc(dsc);
			monthlyWorkLoad.setAllFamlies(allFamilies);
			monthlyWorkLoad.setTotalSick(totalSick);
			monthlyWorkLoad.setPopulationSick(populationSick);
			monthlyWorkLoad.setServicePerson(servicePerson);
			monthlyWorkLoad.setFamlies(families);
			monthlyWorkLoad.setTotal(total);
			monthlyWorkLoad.setPopulationServicePerson(populationServicePerson);
			monthlyWorkLoad.setAllPerson(allPerson);
			monthlyWorkLoad.setPopulationAll(populationAll);
			monthlyWorkLoad.setMedcalBoard(medicalBoard);
			monthlyWorkLoad.setMedicalExam(medicalExam);
			monthlyWorkLoad.setLastChangedBy(changedBy);
			monthlyWorkLoad.setLastChangedDate(changedDate);
			monthlyWorkLoad.setLastChangedTime(changedTime);
			
			hbt.save(monthlyWorkLoad);
			hbt.refresh(monthlyWorkLoad);
				
			succesfullyAdded  = true;
			
			

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}			

		return succesfullyAdded;	


	}


	public Map<String,Object>  getMonthlyWorkloadDetails(Map<String,Object> mapForData)
	{

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int hospitalId=0;		
		List<String> officerAircrewList = new ArrayList<String>();
		List<String> officerGDList = new ArrayList<String>();
		List<String> airmenAircrewList = new ArrayList<String>();
		List<String> airmenOthersList = new ArrayList<String>();
		List<String>  ncsList = new ArrayList<String>();
		List<String> allFamiliesList = new ArrayList<String>();
		List<String> servicePersList = new ArrayList<String>();
		List<String> medicalBoardList = new ArrayList<String>();
		List<String> medicalExamList = new ArrayList<String>();
		List<Object[]> unitList = null;
		hospitalId =(Integer)mapForData.get("hospitalId");
		try
		{
			//String aitcrew="select count(*) from patient where rank_category_id=1 and trade_id in(29,78,595,596,597,589,322) ";

			String   officerAircrew = "select count(*) as count  from patient p left outer join mas_rank on mas_rank.RANK_ID=p.RANK_ID left outer join mas_rank_category on mas_rank_category.RANK_CATEGORY_ID= mas_rank.RANK_CATEGORY_ID where mas_rank.rank_category_id=1 and trade_id in(29,78,595 ,596,597,589,322)";
			officerAircrewList= session.createSQLQuery(officerAircrew).list();			

			String officerGD =  "select count(*) as count  from patient p left outer join mas_rank on mas_rank.RANK_ID=p.RANK_ID left outer join mas_rank_category on mas_rank_category.RANK_CATEGORY_ID= mas_rank.RANK_CATEGORY_ID where mas_rank.rank_category_id=1 and trade_id not in(29,78,595 ,596,597,589,322)";
			officerGDList=session.createSQLQuery(officerGD).list();

			String airmenAircrew = "select count(*) as count  from patient p left outer join mas_rank on mas_rank.RANK_ID=p.RANK_ID left outer join mas_rank_category on mas_rank_category.RANK_CATEGORY_ID= mas_rank.RANK_CATEGORY_ID where mas_rank.rank_category_id !=1 and trade_id  in(29,78,595 ,596,597,589,322)";
			airmenAircrewList=session.createSQLQuery(airmenAircrew).list();

			String airmenOthers="select count(*) as count  from patient p left outer join mas_rank on mas_rank.RANK_ID=p.RANK_ID left outer join mas_rank_category on mas_rank_category.RANK_CATEGORY_ID= mas_rank.RANK_CATEGORY_ID where mas_rank.rank_category_id !=1 and trade_id not in(29,78,595 ,596,597,589,322)and p.rank_id !=19";
			airmenOthersList=session.createSQLQuery(airmenOthers).list();
			
			String ncs="select count(*) from patient p where p.rank_id=19";
			ncsList= session.createSQLQuery(ncs).list();
			
			String allFamilies="select count(*) from patient p where p.relation_id !=8";
			allFamiliesList= session.createSQLQuery(allFamilies).list();
			
			String servicePers="select count(*)from patient p where p.relation_id=8";
			servicePersList= session.createSQLQuery(servicePers).list();
			
			unitList = session.createCriteria(MasUnit.class).add(
					Restrictions.eq("Status", "y")).createAlias("Station", "station",CriteriaSpecification.LEFT_JOIN).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("UnitName"))
							.add(Projections.property("station.StationName")).add(Projections.property("HicCode"))).addOrder(
									Order.asc("UnitName")).list();
			String medicalBoard ="select count(*)  from mas_medical_examination_report where medicaltype='MedicalBoard' and hospital_id="+hospitalId;
			
			medicalBoardList = session.createSQLQuery(medicalBoard).list();
			String medicalExam = "select count(*)  from mas_medical_examination_report where medicaltype='MedicalExam' and hospital_id="+hospitalId;
			
			medicalExamList = session.createSQLQuery(medicalExam).list();
			//List<MasTrade> masTradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq(propertyName, value)         .add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			// masTradeList = session.createCriteria(MasTrade.class).createAlias("MasRankCategory", "mrc").add(Restrictions.eq("mrc.Id", "1")).add(Restrictions.eq("Hospital.Id", hospitalId)).list();


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		map.put("officerAircrewList", officerAircrewList);
		map.put("officerGDList", officerGDList);
		map.put("airmenAircrewList", airmenAircrewList);
		map.put("airmenOthersList", airmenOthersList);
		map.put("ncsList", ncsList);				
		map.put("allFamiliesList", allFamiliesList);
		map.put("servicePersList", servicePersList);
		map.put("unitList", unitList);
		map.put("medicalBoardList",medicalBoardList);
		map.put("medicalExamList", medicalExamList);
		return map;

	}


	//----by Kiran to get category List for 2 wheeler JSp

	@Override
	public Map<String, Object> showMotorCycleJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		List<Category> categoryList = new ArrayList<Category>();

		try
		{
			categoryList = session.createCriteria(Category.class).list();
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		map.put("categoryList", categoryList);

		return map;
	}

	@Override
	public Map<String, Object> showFamilyHealthProgrammeJsp() {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		List<MasUnit> unitList = new ArrayList<MasUnit>();

		try
		{
			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		map.put("unitList", unitList);

		return map;
	}

	@Override
	public boolean submitFamilyHealthProgrammeJsp(Map map) {

		boolean succesfullyAdded = false;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();

		int unitname = 0;
		String ageGroup = "";
		int year = 0;
		int totalStrength = 0;
		int noSpouseExamined = 0;
		int noExamined = 0;
		String overWeight = "";
		String obese = "";
		String abdomenExam = "";
		String breastExam = "";
		String htn = "";
		String cardiacAbnormal = "";
		String ecgAbnormility = "";
		String refractoryError = "";
		String bloodAnaemia = "";
		String bloodSugar = "";
		String bloodThyroid = "";
		String bloodLapid = "";
		String halfYear = "";
		  String niddm="";
		  String dentalCaries="";
		int hospitalId = 0;
		Date healthDate = (Date) map.get("healthDate");

		if(map.get("unitname")!= null)
		{
			unitname = (Integer)map.get("unitname");
		}
		if(map.get("niddm")!= null)
		{
			niddm = (String)map.get("niddm");
		}
		if(map.get("dentalCaries")!= null)
		{
			dentalCaries = (String)map.get("dentalCaries");
		}
		if(map.get("ageGroup")!= null)
		{
			ageGroup = (String)map.get("ageGroup");
		}

		if(map.get("year")!= null)
		{ 
			year =(Integer) map.get("year");
		}

		if(map.get("totalStrength")!= null)
		{
			totalStrength = (Integer)map.get("totalStrength");
		}

		if(map.get("noSpouseExamined")!= null)
		{
			noSpouseExamined = (Integer)map.get("noSpouseExamined");
		}

		if(map.get("noExamined")!= null)
		{	 
			noExamined =  (Integer) map.get("noExamined");
		}

		if(map.get("overWeight")!= null)
		{  
			overWeight =(String)map.get("overWeight");	
		}

		if(map.get("obese")!= null)
		{
			obese=(String)map.get("obese");
		}

		if(map.get("halfYear")!= null)
		{
			halfYear=(String)map.get("halfYear");
		}

		if(map.get("abdomenExam")!= null)
		{
			abdomenExam = (String)map.get("abdomenExam");
		}

		if(map.get("refractoryError")!= null)
		{
			refractoryError = (String)map.get("refractoryError");
		}

		if(map.get("breastExam")!= null)
		{	 
			breastExam =  (String) map.get("breastExam");
		}

		if(map.get("htn")!= null)
		{  
			htn =(String)map.get("htn");	
		}

		if(map.get("cardiacAbnormal")!= null)
		{
			cardiacAbnormal=(String)map.get("cardiacAbnormal");
		}

		if(map.get("overWeight")!= null)
		{  
			overWeight =(String)map.get("overWeight");	
		}

		if(map.get("ecgAbnormility")!= null)
		{
			ecgAbnormility=(String)map.get("ecgAbnormility");
		}

		if(map.get("bloodAnaemia")!= null)
		{
			bloodAnaemia = (String)map.get("bloodAnaemia");
		}

		if(map.get("bloodSugar")!= null)
		{	 
			bloodSugar =  (String) map.get("bloodSugar");
		}

		if(map.get("bloodThyroid")!= null)
		{  
			bloodThyroid =(String)map.get("bloodThyroid");	
		}

		if(map.get("bloodLapid")!= null)
		{
			bloodLapid=(String)map.get("bloodLapid");
		}

		if(map.get("hospitalId")!= null)
		{
			hospitalId = (Integer)map.get("hospitalId");
		}
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			ShoFamilyHealthProgramme familyHealth = new ShoFamilyHealthProgramme();
			MasUnit unit = new MasUnit();
			unit.setId(unitname);
			familyHealth.setUnit(unit);

			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			familyHealth.setHospital(hospital);

			familyHealth.setAgeGroup(ageGroup);
			familyHealth.setYear(year);
			familyHealth.setTotalStrength(totalStrength);
			familyHealth.setSpouseExaminedHalfYear(noSpouseExamined);
			familyHealth.setNumberExamined(noExamined);
			familyHealth.setOverWeight(overWeight);
			familyHealth.setObese(obese);
			familyHealth.setAbdomenExam(abdomenExam);
			familyHealth.setBreastExam(breastExam);
			familyHealth.setHtn(htn);
			familyHealth.setCardicMurmur(cardiacAbnormal);
			familyHealth.setEcgAbnormality(ecgAbnormility);
			familyHealth.setRefractoryError(refractoryError);
			familyHealth.setBloodAnaemia(bloodAnaemia);
			familyHealth.setBloodSugar(bloodSugar);
			familyHealth.setBloodThyroid(bloodThyroid);
			familyHealth.setBloodLapid(bloodLapid);
			familyHealth.setHalfYear(halfYear);
			familyHealth.setNiddm(niddm);
			familyHealth.setDentalCaries(dentalCaries);
			familyHealth.setHealthDate(healthDate);

			hbt.save(familyHealth);
			hbt.refresh(familyHealth);
			succesfullyAdded = true;
			/*int notifiableId=0;
		notifiableId = nd.getId();
		map.put("notifiableId", notifiableId);*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return   succesfullyAdded;
	}

	public Map<String,Object> getServiceNoDetailsForMortalityAmongstFamilies(Box box)
	{ Map<String,Object> map = new HashMap<String,Object>();
	String serviceNo = box.getString("serviceNo");		
	List<Patient> dependentList = new ArrayList<Patient>();
	List<String> diagnosisList = new ArrayList<String>();
	Criteria objectList=null;		
	org.hibernate.Session session = getSession();

	String query = "select distinct icd_name from mas_icd i left outer join discharge_icd_code dis on i.icd_id = dis.icd_id left outer join patient_discharge_slip slip on slip.inpatient_id=dis.inpatient_id left outer join patient p on p.hin_id=slip.hin_id where p.service_no = '"+serviceNo+"'";
	//String query = " select hin_id from Patient where service_no = '"+ serviceNo+" '";

	diagnosisList = (List) session.createSQLQuery(query).list();
	objectList = session.createCriteria(Patient.class).add(Restrictions.eq("serviceNo", serviceNo));

	dependentList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
	.add(Restrictions.eq("Status", "y")).list();

	map.put("dependentList",dependentList);
	map.put("serviceNo",serviceNo);
	map.put("diagnosisList", diagnosisList);

	return map;

	}


	public boolean submitMortalityAmongstFamiliesJsp(Map map)
	{
		boolean successfullyAdded = false;
		int hospitalId =0;
		int hinId= 0; 
		int dischargeStatusId = 0;
		String diagnosis = "";
		String placeOfDeath = "";
		Date dateOfDeath = null;
		String presentCondition="";
		  String causeOfDeath="";

		if(map.get("hospitalId")!= null)
		{ 		
			hospitalId = (Integer)map.get("hospitalId");
		}

		if(map.get("dischargeStatusId")!= null)
		{	
			dischargeStatusId = (Integer)map.get("dischargeStatusId");
		}

		if(map.get("hinId")!= null)
		{	
			hinId = (Integer)map.get("hinId");
			 System.out.println("hinId--->"+hinId);
		}

		if(map.get("dateOfDeath")!= null)
		{
			dateOfDeath = (Date)map.get("dateOfDeath");
		}

		if(map.get("placeOfDeath")!= null)
		{
			placeOfDeath = (String)map.get("placeOfDeath");
		}
		 
		  
		  if(map.get("causeOfDeath")!= null)
			{
			  causeOfDeath = (String)map.get("causeOfDeath");
			}
		  
		if(map.get("presentCondition")!= null)
		{
			presentCondition = (String)map.get("presentCondition");
		}

		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt= getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			ExpiryDetails expiryDetails = new ExpiryDetails();


			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			expiryDetails.setHospital(masHospital);

			Patient patient = new Patient();
			patient.setId(hinId);
			expiryDetails.setHin(patient);

			MasDischargeStatus masDischargeStatus = new MasDischargeStatus();

			masDischargeStatus.setId(dischargeStatusId);

			//  hbt.update(masDischargeStatus);
			// hbt.refresh(masDischargeStatus);

			Discharge discharge = new Discharge();
			if(masDischargeStatus != null)
			{
				discharge.setDischargeStatus(masDischargeStatus);
				//hbt.update(discharge);
				// hbt.refresh(discharge);
			}



			PatientDischargeSlip patientDischargeSlip = new PatientDischargeSlip();
			if(presentCondition != null)
			{
				patientDischargeSlip.setPatientCondition(presentCondition);
				//hbt.update(patientDischargeSlip);
				//hbt.refresh(patientDischargeSlip);
			}
			if(dateOfDeath != null)
			{
				expiryDetails.setExpiryDate(dateOfDeath);
			}
			if(placeOfDeath != null)
			{
				expiryDetails.setPalceOfDeath(placeOfDeath);
			}
			expiryDetails.setCauseOfDeath(causeOfDeath);
			hbt.save(expiryDetails);
			hbt.refresh(expiryDetails);


			//hbt.refresh(discharge);

			/*hbt.update(patient);
		   hbt.refresh(patient);*/


			// hbt.refresh(masDischargeStatus);


			//hbt.refresh(patientDischargeSlip);

			successfullyAdded = true;
			/*	   int suicideId=0;
		   suicideId=caseOfAttemptedSuicide.getId();
		   map.put("suicideId", suicideId);*/
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		return successfullyAdded;
	}


	//-------report of family health programme

	public Map<String, Object> showFamilyHealthProgrammeReport() {

		Map<String, Object> map = new HashMap<String, Object>();

		Session session = (Session) getSession();

		List<MasUnit> unitList = new ArrayList<MasUnit>();

		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status","y")).list();

		map.put("unitList", unitList);

		return map;

	}

	//-------get command name

	public  String getCommandName(int commandId)
	{
		List<MasCommand> masCommandList=new ArrayList<MasCommand>();
		Session session = (Session) getSession();
		String CommandName="";
		try
		{
			masCommandList=session.createCriteria(MasCommand.class).add(Restrictions.eq("Id", commandId)).list();
			if(masCommandList.size()>0)
				CommandName=masCommandList.get(0).getCommandName();	
		}catch(HibernateException he)
		{
			he.printStackTrace();
		}
		return CommandName;
	}


	public boolean submitActivityAgainstHiv(Map map)
	{
		boolean successfullyAdded = false;

		Date activityDate= new Date();
		String activityDetails = "";
		String officers = "";
		int hospitalId=0;
		String sncosAirmen = "";
		String families = "";
		String remarks="";

		if(map.get("hospitalId")!= null)
		{ 		
			hospitalId = (Integer)map.get("hospitalId");
		}

		if(map.get("activityDetails")!= null)
		{	
			activityDetails = (String)map.get("activityDetails");
		}

		if(map.get("officers")!= null)
		{	
			officers = (String)map.get("officers");
		}

		if(map.get("activityDate")!= null)
		{
			activityDate = (Date)map.get("activityDate");
		}

		if(map.get("sncosAirmen")!= null)
		{
			sncosAirmen = (String)map.get("sncosAirmen");
		}
		if(map.get("families")!= null)
		{
			families = (String)map.get("families");
		}
		if(map.get("remarks")!= null)
		{
			remarks = (String)map.get("remarks");
		}

		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt= getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			HivAidsActivityDetails hivAidsActivityDetails = new HivAidsActivityDetails();

			hivAidsActivityDetails.setActivityDate(activityDate);
			hivAidsActivityDetails.setActivityDetails(activityDetails);
			hivAidsActivityDetails.setFamilies(families);
			hivAidsActivityDetails.setOfficers(officers);
			hivAidsActivityDetails.setRemarks(remarks);
			hivAidsActivityDetails.setSncoAirmen(sncosAirmen);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hivAidsActivityDetails.setHospital(masHospital);

			hbt.save(hivAidsActivityDetails);
			hbt.refresh(hivAidsActivityDetails);

			successfullyAdded = true;

		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		return successfullyAdded;
	}

	//-----by kiran to submit biomedical details



	@Override
	public boolean submitBiomedicalwastemgtjsp(Map map)
	{
		boolean successfullyAdded = false;

		int hospitalId=0;
		String nameoftheAuthorisedPerson="";
		String commandZone="";
		Date dateOfInspection = new Date();
		String nameofCommandingOfficer="";
		String briefDetailTreatment="";
		String offsite="";
		String operatorName="";
		String nameAddressFacility="";
		String nameOfInstitution="";

		String jan_cat_one_three="";
		String jan_cat_four="";
		String jan_cat_five="";
		String jan_cat_six="";
		String jan_cat_seven="";
		String jan_cat_eight="";
		String jan_cat_nine_ten="";

		String feb_cat_one_three="";
		String feb_cat_four="";
		String feb_cat_five="";
		String feb_cat_six="";
		String feb_cat_seven="";
		String feb_cat_eight="";
		String feb_cat_nine_ten="";

		String mar_cat_one_three="";
		String mar_cat_four="";
		String mar_cat_five="";
		String mar_cat_six="";
		String mar_cat_seven="";
		String mar_cat_eight="";
		String mar_cat_nine_ten="";

		String apr_cat_one_three="";
		String apr_cat_four="";
		String apr_cat_five="";
		String apr_cat_six="";
		String apr_cat_seven="";
		String apr_cat_eight="";
		String apr_cat_nine_ten="";

		String may_cat_one_three="";
		String may_cat_four="";
		String may_cat_five="";
		String may_cat_six="";
		String may_cat_seven="";
		String may_cat_eight="";
		String may_cat_nine_ten="";

		String jun_cat_one_three="";
		String jun_cat_four="";
		String jun_cat_five="";
		String jun_cat_six="";
		String jun_cat_seven="";
		String jun_cat_eight="";
		String jun_cat_nine_ten="";

		String jul_cat_one_three="";
		String jul_cat_four="";
		String jul_cat_five="";
		String jul_cat_six="";
		String jul_cat_seven="";
		String jul_cat_eight="";
		String jul_cat_nine_ten="";

		String aug_cat_one_three="";
		String aug_cat_four="";
		String aug_cat_five="";
		String aug_cat_six="";
		String aug_cat_seven="";
		String aug_cat_eight="";
		String aug_cat_nine_ten="";

		String sep_cat_one_three="";
		String sep_cat_four="";
		String sep_cat_five="";
		String sep_cat_six="";
		String sep_cat_seven="";
		String sep_cat_eight="";
		String sep_cat_nine_ten="";

		String oct_cat_one_three="";
		String oct_cat_four="";
		String oct_cat_five="";
		String oct_cat_six="";
		String oct_cat_seven="";
		String oct_cat_eight="";
		String oct_cat_nine_ten="";

		String nov_cat_one_three="";
		String nov_cat_four="";
		String nov_cat_five="";
		String nov_cat_six="";
		String nov_cat_seven="";
		String nov_cat_eight="";
		String nov_cat_nine_ten="";

		String dec_cat_one_three="";
		String dec_cat_four="";
		String dec_cat_five="";
		String dec_cat_six="";
		String dec_cat_seven="";
		String dec_cat_eight="";
		String dec_cat_nine_ten="";

		String total_cat_one_three="";
		String total_cat_four="";
		String total_cat_five="";
		String total_cat_six="";
		String total_cat_seven="";
		String total_cat_eight="";
		String total_cat_nine_ten="";

		String collectionStorage="";
		String modeofTransportation="";
		String knowledgeAttitude="";
		String useofPersonal="";
		String incinerator="";
		String deepBru="";
		String microwave="";

		String autoclave="";
		String hydroclave="";
		String shredder="";
		String needleDes="";
		String anyOther="";
		String remarksofInsp="";
		String finalObser="";

		if(map.get("hospitalId")!= null)
		{ 		
			hospitalId = (Integer)map.get("hospitalId");
		}

		if(map.get("nameoftheAuthorisedPerson")!= null)
		{	
			nameoftheAuthorisedPerson = (String)map.get("nameoftheAuthorisedPerson");
		}

		if(map.get("commandZone")!= null)
		{	
			commandZone = (String)map.get("commandZone");
		}

		if(map.get("dateOfInspection")!= null)
		{
			dateOfInspection = (Date)map.get("dateOfInspection");
		}

		if(map.get("nameofCommandingOfficer")!= null)
		{	
			nameofCommandingOfficer = (String)map.get("nameofCommandingOfficer");
		}

		if(map.get("briefDetailTreatment")!= null)
		{	
			briefDetailTreatment = (String)map.get("briefDetailTreatment");
		}

		if(map.get("offsite")!= null)
		{	
			offsite = (String)map.get("offsite");
		}

		if(map.get("operatorName")!= null)
		{	
			operatorName = (String)map.get("operatorName");
		}

		if(map.get("nameAddressFacility")!= null)
		{	
			nameAddressFacility = (String)map.get("nameAddressFacility");
		}

		if(map.get("jan_cat_one_three")!= null)
		{	
			jan_cat_one_three = (String)map.get("jan_cat_one_three");
		}

		if(map.get("jan_cat_four")!= null)
		{	
			jan_cat_four = (String)map.get("jan_cat_four");
		}

		if(map.get("jan_cat_five")!= null)
		{	
			jan_cat_five = (String)map.get("jan_cat_five");
		}

		if(map.get("jan_cat_six")!= null)
		{	
			jan_cat_six = (String)map.get("jan_cat_six");
		}

		if(map.get("jan_cat_seven")!= null)
		{	
			jan_cat_seven = (String)map.get("jan_cat_seven");
		}

		if(map.get("jan_cat_eight")!= null)
		{	
			jan_cat_eight = (String)map.get("jan_cat_eight");
		}

		if(map.get("jan_cat_nine_ten")!= null)
		{	
			jan_cat_nine_ten = (String)map.get("jan_cat_nine_ten");
		}

		if(map.get("feb_cat_one_three")!= null)
		{	
			feb_cat_one_three = (String)map.get("feb_cat_one_three");
		}

		if(map.get("feb_cat_four")!= null)
		{	
			feb_cat_four = (String)map.get("feb_cat_four");
		}

		if(map.get("feb_cat_five")!= null)
		{	
			feb_cat_five = (String)map.get("feb_cat_five");
		}

		if(map.get("feb_cat_six")!= null)
		{	
			feb_cat_six = (String)map.get("feb_cat_six");
		}

		if(map.get("feb_cat_seven")!= null)
		{	
			feb_cat_seven = (String)map.get("feb_cat_seven");
		}

		if(map.get("feb_cat_eight")!= null)
		{	
			feb_cat_eight = (String)map.get("feb_cat_eight");
		}

		if(map.get("feb_cat_nine_ten")!= null)
		{	
			feb_cat_nine_ten = (String)map.get("feb_cat_nine_ten");
		}

		if(map.get("mar_cat_one_three")!= null)
		{	
			mar_cat_one_three = (String)map.get("mar_cat_one_three");
		}

		if(map.get("mar_cat_four")!= null)
		{	
			mar_cat_four = (String)map.get("mar_cat_four");
		}

		if(map.get("mar_cat_five")!= null)
		{	
			mar_cat_five = (String)map.get("mar_cat_five");
		}

		if(map.get("mar_cat_six")!= null)
		{	
			mar_cat_six = (String)map.get("mar_cat_six");
		}

		if(map.get("mar_cat_seven")!= null)
		{	
			mar_cat_seven = (String)map.get("mar_cat_seven");
		}

		if(map.get("mar_cat_eight")!= null)
		{	
			mar_cat_eight = (String)map.get("mar_cat_eight");
		}

		if(map.get("mar_cat_nine_ten")!= null)
		{	
			mar_cat_nine_ten = (String)map.get("mar_cat_nine_ten");
		}

		if(map.get("apr_cat_one_three")!= null)
		{	
			apr_cat_one_three = (String)map.get("apr_cat_one_three");
		}

		if(map.get("apr_cat_four")!= null)
		{	
			apr_cat_four = (String)map.get("apr_cat_four");
		}

		if(map.get("apr_cat_five")!= null)
		{	
			apr_cat_five = (String)map.get("apr_cat_five");
		}

		if(map.get("apr_cat_six")!= null)
		{	
			apr_cat_six = (String)map.get("apr_cat_six");
		}

		if(map.get("apr_cat_seven")!= null)
		{	
			apr_cat_seven = (String)map.get("apr_cat_seven");
		}

		if(map.get("apr_cat_eight")!= null)
		{	
			apr_cat_eight = (String)map.get("apr_cat_eight");
		}

		if(map.get("apr_cat_nine_ten")!= null)
		{	
			apr_cat_nine_ten = (String)map.get("apr_cat_nine_ten");
		}

		if(map.get("may_cat_one_three")!= null)
		{	
			may_cat_one_three = (String)map.get("may_cat_one_three");
		}

		if(map.get("may_cat_four")!= null)
		{	
			may_cat_four = (String)map.get("may_cat_four");
		}

		if(map.get("may_cat_five")!= null)
		{	
			may_cat_five = (String)map.get("may_cat_five");
		}

		if(map.get("may_cat_six")!= null)
		{	
			may_cat_six = (String)map.get("may_cat_six");
		}

		if(map.get("may_cat_seven")!= null)
		{	
			may_cat_seven = (String)map.get("may_cat_seven");
		}

		if(map.get("may_cat_eight")!= null)
		{	
			may_cat_eight = (String)map.get("may_cat_eight");
		}

		if(map.get("may_cat_nine_ten")!= null)
		{	
			may_cat_nine_ten = (String)map.get("may_cat_nine_ten");
		}

		if(map.get("jun_cat_one_three")!= null)
		{	
			jun_cat_one_three = (String)map.get("jun_cat_one_three");
		}

		if(map.get("jun_cat_four")!= null)
		{	
			jun_cat_four = (String)map.get("jun_cat_four");
		}

		if(map.get("jun_cat_five")!= null)
		{	
			jun_cat_five = (String)map.get("jun_cat_five");
		}

		if(map.get("jun_cat_six")!= null)
		{	
			jun_cat_six = (String)map.get("jun_cat_six");
		}

		if(map.get("jun_cat_seven")!= null)
		{	
			jun_cat_seven = (String)map.get("jun_cat_seven");
		}

		if(map.get("jun_cat_eight")!= null)
		{	
			jun_cat_eight = (String)map.get("jun_cat_eight");
		}

		if(map.get("jun_cat_nine_ten")!= null)
		{	
			jun_cat_nine_ten = (String)map.get("jun_cat_nine_ten");
		}

		if(map.get("jul_cat_one_three")!= null)
		{	
			jul_cat_one_three = (String)map.get("jul_cat_one_three");
		}

		if(map.get("jul_cat_four")!= null)
		{	
			jul_cat_four = (String)map.get("jul_cat_four");
		}

		if(map.get("jul_cat_five")!= null)
		{	
			jul_cat_five = (String)map.get("jul_cat_five");
		}

		if(map.get("jul_cat_six")!= null)
		{	
			jul_cat_six = (String)map.get("jul_cat_six");
		}

		if(map.get("jul_cat_seven")!= null)
		{	
			jul_cat_seven = (String)map.get("jul_cat_seven");
		}

		if(map.get("jul_cat_eight")!= null)
		{	
			jul_cat_eight = (String)map.get("jul_cat_eight");
		}

		if(map.get("jul_cat_nine_ten")!= null)
		{	
			jul_cat_nine_ten = (String)map.get("jul_cat_nine_ten");
		}

		if(map.get("aug_cat_one_three")!= null)
		{	
			aug_cat_one_three = (String)map.get("aug_cat_one_three");
		}

		if(map.get("aug_cat_four")!= null)
		{	
			aug_cat_four = (String)map.get("aug_cat_four");
		}

		if(map.get("aug_cat_five")!= null)
		{	
			aug_cat_five = (String)map.get("aug_cat_five");
		}

		if(map.get("aug_cat_six")!= null)
		{	
			aug_cat_six = (String)map.get("aug_cat_six");
		}

		if(map.get("aug_cat_seven")!= null)
		{	
			aug_cat_seven = (String)map.get("aug_cat_seven");
		}

		if(map.get("aug_cat_eight")!= null)
		{	
			aug_cat_eight = (String)map.get("aug_cat_eight");
		}

		if(map.get("aug_cat_nine_ten")!= null)
		{	
			aug_cat_nine_ten = (String)map.get("aug_cat_nine_ten");
		}

		if(map.get("sep_cat_one_three")!= null)
		{	
			sep_cat_one_three = (String)map.get("sep_cat_one_three");
		}

		if(map.get("sep_cat_four")!= null)
		{	
			sep_cat_four = (String)map.get("sep_cat_four");
		}

		if(map.get("sep_cat_five")!= null)
		{	
			sep_cat_five = (String)map.get("sep_cat_five");
		}

		if(map.get("sep_cat_six")!= null)
		{	
			sep_cat_six = (String)map.get("sep_cat_six");
		}

		if(map.get("sep_cat_seven")!= null)
		{	
			sep_cat_seven = (String)map.get("sep_cat_seven");
		}

		if(map.get("sep_cat_eight")!= null)
		{	
			sep_cat_eight = (String)map.get("sep_cat_eight");
		}

		if(map.get("sep_cat_nine_ten")!= null)
		{	
			sep_cat_nine_ten = (String)map.get("sep_cat_nine_ten");
		}

		if(map.get("oct_cat_one_three")!= null)
		{	
			oct_cat_one_three = (String)map.get("oct_cat_one_three");
		}

		if(map.get("oct_cat_four")!= null)
		{	
			oct_cat_four = (String)map.get("oct_cat_four");
		}

		if(map.get("oct_cat_five")!= null)
		{	
			oct_cat_five = (String)map.get("oct_cat_five");
		}

		if(map.get("oct_cat_six")!= null)
		{	
			oct_cat_six = (String)map.get("oct_cat_six");
		}

		if(map.get("oct_cat_seven")!= null)
		{	
			oct_cat_seven = (String)map.get("oct_cat_seven");
		}

		if(map.get("oct_cat_eight")!= null)
		{	
			oct_cat_eight = (String)map.get("oct_cat_eight");
		}

		if(map.get("oct_cat_nine_ten")!= null)
		{	
			oct_cat_nine_ten = (String)map.get("oct_cat_nine_ten");
		}

		if(map.get("nov_cat_one_three")!= null)
		{	
			nov_cat_one_three = (String)map.get("nov_cat_one_three");
		}

		if(map.get("nov_cat_four")!= null)
		{	
			nov_cat_four = (String)map.get("nov_cat_four");
		}

		if(map.get("nov_cat_five")!= null)
		{	
			nov_cat_five = (String)map.get("nov_cat_five");
		}

		if(map.get("nov_cat_six")!= null)
		{	
			nov_cat_six = (String)map.get("nov_cat_six");
		}

		if(map.get("nov_cat_seven")!= null)
		{	
			nov_cat_seven = (String)map.get("nov_cat_seven");
		}

		if(map.get("nov_cat_eight")!= null)
		{	
			nov_cat_eight = (String)map.get("nov_cat_eight");
		}

		if(map.get("nov_cat_nine_ten")!= null)
		{	
			nov_cat_nine_ten = (String)map.get("nov_cat_nine_ten");
		}

		if(map.get("dec_cat_one_three")!= null)
		{	
			dec_cat_one_three = (String)map.get("dec_cat_one_three");
		}

		if(map.get("dec_cat_four")!= null)
		{	
			dec_cat_four = (String)map.get("dec_cat_four");
		}

		if(map.get("dec_cat_five")!= null)
		{	
			dec_cat_five = (String)map.get("dec_cat_five");
		}

		if(map.get("dec_cat_six")!= null)
		{	
			dec_cat_six = (String)map.get("dec_cat_six");
		}

		if(map.get("dec_cat_seven")!= null)
		{	
			dec_cat_seven = (String)map.get("dec_cat_seven");
		}

		if(map.get("dec_cat_eight")!= null)
		{	
			dec_cat_eight = (String)map.get("dec_cat_eight");
		}

		if(map.get("dec_cat_nine_ten")!= null)
		{	
			dec_cat_nine_ten = (String)map.get("dec_cat_nine_ten");
		}

		if(map.get("total_cat_one_three")!= null)
		{	
			total_cat_one_three = (String)map.get("total_cat_one_three");
		}

		if(map.get("total_cat_four")!= null)
		{	
			total_cat_four = (String)map.get("total_cat_four");
		}

		if(map.get("total_cat_five")!= null)
		{	
			total_cat_five = (String)map.get("total_cat_five");
		}

		if(map.get("total_cat_six")!= null)
		{	
			total_cat_six = (String)map.get("total_cat_six");
		}

		if(map.get("total_cat_seven")!= null)
		{	
			total_cat_seven = (String)map.get("total_cat_seven");
		}

		if(map.get("total_cat_eight")!= null)
		{	
			total_cat_eight = (String)map.get("total_cat_eight");
		}

		if(map.get("total_cat_nine_ten")!= null)
		{	
			total_cat_nine_ten = (String)map.get("total_cat_nine_ten");
		}

		if(map.get("collectionStorage")!= null)
		{	
			collectionStorage = (String)map.get("collectionStorage");
		}

		if(map.get("modeofTransportation")!= null)
		{	
			modeofTransportation = (String)map.get("modeofTransportation");
		}

		if(map.get("knowledgeAttitude")!= null)
		{	
			knowledgeAttitude = (String)map.get("knowledgeAttitude");
		}

		if(map.get("useofPersonal")!= null)
		{	
			useofPersonal = (String)map.get("useofPersonal");
		}

		if(map.get("incinerator")!= null)
		{	
			incinerator = (String)map.get("incinerator");
		}

		if(map.get("deepBru")!= null)
		{	
			deepBru = (String)map.get("deepBru");
		}

		if(map.get("microwave")!= null)
		{	
			microwave = (String)map.get("microwave");
		}

		if(map.get("autoclave")!= null)
		{	
			autoclave = (String)map.get("autoclave");
		}

		if(map.get("hydroclave")!= null)
		{	
			hydroclave = (String)map.get("hydroclave");
		}

		if(map.get("shredder")!= null)
		{	
			shredder = (String)map.get("shredder");
		}

		if(map.get("needleDes")!= null)
		{	
			needleDes = (String)map.get("needleDes");
		}

		if(map.get("anyOther")!= null)
		{	
			anyOther = (String)map.get("anyOther");
		}

		if(map.get("remarksofInsp")!= null)
		{	
			remarksofInsp = (String)map.get("remarksofInsp");
		}

		if(map.get("finalObser")!= null)
		{	
			finalObser = (String)map.get("finalObser");
		}

		if(map.get("nameOfInstitution")!= null)
		{	
			nameOfInstitution = (String)map.get("nameOfInstitution");
		}

		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt= getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			ShoBiomedicalWaste shoBiomedicalWaste = new ShoBiomedicalWaste();

			shoBiomedicalWaste.setDateOfInspection(dateOfInspection);
			shoBiomedicalWaste.setAuthorisedPersonName(nameoftheAuthorisedPerson);
			shoBiomedicalWaste.setCommandZone(commandZone);
			shoBiomedicalWaste.setCommandingOfficerName(nameofCommandingOfficer);
			shoBiomedicalWaste.setBriefDetail(briefDetailTreatment);
			shoBiomedicalWaste.setOffsite(offsite);
			shoBiomedicalWaste.setOperatorName(operatorName);
			shoBiomedicalWaste.setAddressOfFacility(nameAddressFacility);
			shoBiomedicalWaste.setJanCatOneThree(jan_cat_one_three);
			shoBiomedicalWaste.setJanCatFour(jan_cat_four);
			shoBiomedicalWaste.setJanCatFive(jan_cat_five);
			shoBiomedicalWaste.setJanCatSix(jan_cat_six);
			shoBiomedicalWaste.setJanCatSeven(jan_cat_seven);
			shoBiomedicalWaste.setJanCatEight(jan_cat_eight);
			shoBiomedicalWaste.setJanCatNineTen(jan_cat_nine_ten);
			shoBiomedicalWaste.setFebCatOneThree(feb_cat_one_three);
			shoBiomedicalWaste.setFebCatFour(feb_cat_four);
			shoBiomedicalWaste.setFebCatFive(feb_cat_five);
			shoBiomedicalWaste.setFebCatSix(feb_cat_six);
			shoBiomedicalWaste.setFebCatSeven(feb_cat_seven);
			shoBiomedicalWaste.setFebCatEight(feb_cat_eight);
			shoBiomedicalWaste.setFebCatNineTen(feb_cat_nine_ten);
			shoBiomedicalWaste.setMarCatOneThree(mar_cat_one_three);
			shoBiomedicalWaste.setMarCatFour(mar_cat_four);
			shoBiomedicalWaste.setMarCatFive(mar_cat_five);
			shoBiomedicalWaste.setMarCatSix(mar_cat_six);
			shoBiomedicalWaste.setMarCatSeven(mar_cat_seven);
			shoBiomedicalWaste.setMarCatEight(mar_cat_eight);
			shoBiomedicalWaste.setMarCatNineTen(mar_cat_nine_ten);
			shoBiomedicalWaste.setAprCatOneThree(apr_cat_one_three);
			shoBiomedicalWaste.setAprCatFour(apr_cat_four);
			shoBiomedicalWaste.setAprCatFive(apr_cat_five);
			shoBiomedicalWaste.setAprCatSix(apr_cat_six);
			shoBiomedicalWaste.setAprCatSeven(apr_cat_seven);
			shoBiomedicalWaste.setAprCatEight(apr_cat_eight);
			shoBiomedicalWaste.setAprCatNineTen(apr_cat_nine_ten);
			shoBiomedicalWaste.setMayCatOneThree(may_cat_one_three);
			shoBiomedicalWaste.setMayCatFour(may_cat_four);
			shoBiomedicalWaste.setMayCatFive(may_cat_five);
			shoBiomedicalWaste.setMayCatSix(may_cat_six);
			shoBiomedicalWaste.setMayCatSeven(may_cat_seven);
			shoBiomedicalWaste.setMayCatEight(may_cat_eight);
			shoBiomedicalWaste.setMayCatNineTen(may_cat_nine_ten);
			shoBiomedicalWaste.setJunCatOneThree(jun_cat_one_three);
			shoBiomedicalWaste.setJunCatFour(jun_cat_four);
			shoBiomedicalWaste.setJunCatFive(jun_cat_five);
			shoBiomedicalWaste.setJunCatSix(jun_cat_six);
			shoBiomedicalWaste.setJunCatSeven(jun_cat_seven);
			shoBiomedicalWaste.setJunCatEight(jun_cat_eight);
			shoBiomedicalWaste.setJunCatNineTen(jun_cat_nine_ten);
			shoBiomedicalWaste.setJulCatOneThree(jun_cat_one_three);
			shoBiomedicalWaste.setJulCatFour(jul_cat_four);
			shoBiomedicalWaste.setJulCatFive(jul_cat_five);
			shoBiomedicalWaste.setJulCatSix(jul_cat_six);
			shoBiomedicalWaste.setJulCatSeven(jul_cat_seven);
			shoBiomedicalWaste.setJulCatEight(jul_cat_eight);
			shoBiomedicalWaste.setJulCatNineTen(jul_cat_nine_ten);
			shoBiomedicalWaste.setAugCatOneThree(aug_cat_one_three);
			shoBiomedicalWaste.setAugCatFour(aug_cat_four);
			shoBiomedicalWaste.setAugCatFive(aug_cat_five);
			shoBiomedicalWaste.setAugCatSix(aug_cat_six);
			shoBiomedicalWaste.setAugCatSeven(aug_cat_seven);
			shoBiomedicalWaste.setAugCatEight(aug_cat_eight );
			shoBiomedicalWaste.setAugCatNineTen(aug_cat_nine_ten);
			shoBiomedicalWaste.setSepCatOneThree(sep_cat_one_three);
			shoBiomedicalWaste.setSepCatFour(sep_cat_four);
			shoBiomedicalWaste.setSepCatFive(sep_cat_five);
			shoBiomedicalWaste.setSepCatSix(sep_cat_six);
			shoBiomedicalWaste.setSepCatSeven(sep_cat_seven);
			shoBiomedicalWaste.setSepCatEight(sep_cat_eight);
			shoBiomedicalWaste.setSepCatNineTen(sep_cat_nine_ten);
			shoBiomedicalWaste.setOctCatOneThree(oct_cat_one_three);
			shoBiomedicalWaste.setOctCatFour(oct_cat_four);
			shoBiomedicalWaste.setOctCatFive(oct_cat_five);
			shoBiomedicalWaste.setOctCatSix(oct_cat_six);
			shoBiomedicalWaste.setOctCatSeven(oct_cat_seven);
			shoBiomedicalWaste.setOctCatEight(oct_cat_eight);
			shoBiomedicalWaste.setOctCatNineTen(oct_cat_nine_ten);
			shoBiomedicalWaste.setNovCatOneThree(nov_cat_one_three);
			shoBiomedicalWaste.setNovCatFour(nov_cat_four);
			shoBiomedicalWaste.setNovCatFive(nov_cat_five);
			shoBiomedicalWaste.setNovCatSix(nov_cat_six);
			shoBiomedicalWaste.setNovCatSeven(nov_cat_seven);
			shoBiomedicalWaste.setNovCatEight(nov_cat_eight);
			shoBiomedicalWaste.setNovCatNineTen(nov_cat_nine_ten);
			shoBiomedicalWaste.setDecCatOneThree(dec_cat_one_three);
			shoBiomedicalWaste.setDecCatFour(dec_cat_four);
			shoBiomedicalWaste.setDecCatFive(dec_cat_five);
			shoBiomedicalWaste.setDecCatSix(dec_cat_six);
			shoBiomedicalWaste.setDecCatSeven(dec_cat_seven);
			shoBiomedicalWaste.setDecCatEight(dec_cat_eight);
			shoBiomedicalWaste.setDecCatNineTen(dec_cat_nine_ten);
			shoBiomedicalWaste.setTotalCatOneThree(total_cat_one_three);
			shoBiomedicalWaste.setTotalCatFour(total_cat_four);
			shoBiomedicalWaste.setTotalCatFive(total_cat_five);
			shoBiomedicalWaste.setTotalCatSix(total_cat_six);
			shoBiomedicalWaste.setTotalCatSeven(total_cat_seven);
			shoBiomedicalWaste.setTotalCatEight(total_cat_eight);
			shoBiomedicalWaste.setTotalCatNineTen(total_cat_nine_ten);
			shoBiomedicalWaste.setCollectionStorage(collectionStorage);
			shoBiomedicalWaste.setModeOfTransportation(modeofTransportation);
			shoBiomedicalWaste.setKnowledgeAttitude(knowledgeAttitude);
			shoBiomedicalWaste.setUseOfPresonel(useofPersonal);
			shoBiomedicalWaste.setIncinerator(incinerator);
			shoBiomedicalWaste.setDeepBurial(deepBru);
			shoBiomedicalWaste.setMicrowave(microwave);
			shoBiomedicalWaste.setAutoclave(autoclave);
			shoBiomedicalWaste.setHydroclave(hydroclave);
			shoBiomedicalWaste.setShredder(shredder);
			shoBiomedicalWaste.setNeedleDestroyer(needleDes);
			shoBiomedicalWaste.setOtherFormOfHandling(anyOther);
			shoBiomedicalWaste.setRemarks(remarksofInsp);
			shoBiomedicalWaste.setFinalObservation(finalObser);
			shoBiomedicalWaste.setNameOfInstitution(nameOfInstitution);


			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			shoBiomedicalWaste.setHospital(masHospital);

			hbt.save(shoBiomedicalWaste);
			hbt.refresh(shoBiomedicalWaste);

			int bioMedicalId = 0;
			bioMedicalId = shoBiomedicalWaste.getBiomedicalId();
			map.put("bioMedicalId", bioMedicalId);

			successfullyAdded = true;

		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		return successfullyAdded;
	}



	@Override
	public Map<String, Object> showBiomedicalwastemgtjsp(Map<String, Object> map) {

		int commandId=0;
		int userId=0;
		int hospitalId=0;


		List<Users> userList = new ArrayList<Users>();
		List<MasCommand> masCommandList=new ArrayList<MasCommand>();

		Session session = (Session)getSession();

		try
		{

			if(map.get("commandId")!=null)
			{
				commandId=(Integer)map.get("commandId");
			}

			if(map.get("userId")!=null)
			{
				userId=(Integer)map.get("userId");
			}

			if(map.get("hospitalId")!=null)
			{
				hospitalId=(Integer)map.get("hospitalId");
			}

			userList=session.createCriteria(Users.class).add(Restrictions.eq("Employee.Id", userId)).add(Restrictions.eq("Status", "y")).list();
			masCommandList=session.createCriteria(MasCommand.class).add(Restrictions.eq("Id", commandId)).add(Restrictions.eq("Status", "y")).list();

			if(masCommandList.size()>0)
			{
				/*CommandName=masCommandList.get(0).getCommandName();*/
				map.put("masCommandList", masCommandList);
			}

			if(userList.size()>0)
			{
				map.put("userList", userList);
			}

		}
		catch(HibernateException he)
		{
			he.printStackTrace();
		}

		return map;

	}

	@Override
	public Map<String, Object> updateDiagnosis(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Vector opdIds = box.getVector("opdId");
		Vector diagnosis = box.getVector("diagnosis");
		Vector disposedOff = box.getVector("disposedOff");
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean flag = false;
		try {
			if(opdIds.size() > 0){
				for (int i = 0; i < opdIds.size(); i++) {
					if(Integer.parseInt(opdIds.get(i).toString())!=0){
						OpdPatientDetails patientDetails = (OpdPatientDetails)hbt.load(OpdPatientDetails.class, Integer.parseInt(opdIds.get(i).toString()));
						patientDetails.setInitialDiagnosis(diagnosis.get(i).toString());
						patientDetails.setDisposedOff(disposedOff.get(i).toString());
						hbt.update(patientDetails);
					}
				}
			}
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		map.put("flag", flag);
		return map;
	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getHinNoForNotifiableDisease(String serviceNo) {
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

	public Map<String,Object> getPatientDetailForNotifiableDisease(Map<String,Object> mapForDS) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();	
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		int hinId = 0;   
		hinId = (Integer) mapForDS.get("hinId");
		
		@SuppressWarnings("unused")
		Patient patient = new Patient();
		
		patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
		inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Hin.Id", hinId)).list();
		      
		map.put("patientList", patientList);
		map.put("inpatientList", inpatientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getServiceNoDetailsForAccidentRider(String serviceNo) {
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

	public Map<String,Object> getPatientDetailForAccidentalDetails(Map<String,Object> mapForDS) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();	
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		int hinId = 0;   
		hinId = (Integer) mapForDS.get("hinId");
		
		@SuppressWarnings("unused")
		Patient patient = new Patient();

		patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
		 inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Hin.Id", hinId)).list();
		      
		map.put("patientList", patientList);
		map.put("inpatientList", inpatientList);
		return map;
	}


	public Map<String, Object> getServiceNoDetailsForAccident(String serviceNo) {
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

	public Map<String,Object> getPatientDetailForAccidentalDetailsDriver(Map<String,Object> mapForDS) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();	
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		int hinId = 0;   
		hinId = (Integer) mapForDS.get("hinId");
		
		@SuppressWarnings("unused")
		Patient patient = new Patient();
		
		patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
		inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Hin.Id", hinId)).list();
		      
		map.put("patientList", patientList);
		map.put("inpatientList", inpatientList);
		return map;
	}

	//--------Mortality 

	public Map<String,Object> getServiceNoDetailsForMortalityAmongstFamilies(String serviceNo)
	{ 
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
			map.put("serviceNo", serviceNo);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String,Object> getPatientDetailForMortality(Map<String,Object> mapForDS) {
		
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Patient> patientList = new ArrayList<Patient>();	
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<String> diagnosisList = new ArrayList<String>();
		
		Criteria objectList=null;		
		//org.hibernate.Session session = getSession();
		
		int hinId = 0;   
		hinId = (Integer) mapForDS.get("hinId");
		String serviceNo = "";
		serviceNo=(String)mapForDS.get("serviceNumber");
		
		@SuppressWarnings("unused")
		Patient patient = new Patient();
		
		patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
		
		inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Hin.Id", hinId)).list();
		      
		String query = "select distinct icd_name from mas_icd i left outer join discharge_icd_code dis on i.icd_id = dis.icd_id left outer join patient_discharge_slip slip on slip.inpatient_id=dis.inpatient_id left outer join patient p on p.hin_id=slip.hin_id where p.hin_id = '"+hinId+"'";
		
		diagnosisList = (List) session.createSQLQuery(query).list();
		
		map.put("patientList", patientList);
		map.put("inpatientList", inpatientList);
		map.put("diagnosisList", diagnosisList);
		
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getHinNoForAttemptSucide(String serviceNo) {
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
	
	
	public Map<String,Object> getServiceNoDetailsForAttemptSucide(Map<String,Object> mapForDS)
	 { 
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();	
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		int hinId = 0;   
		hinId = (Integer) mapForDS.get("hinId");
		
		@SuppressWarnings("unused")
		Patient patient = new Patient();
		
		patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
		inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Hin.Id", hinId)).list();
		      
		map.put("patientList", patientList);
		map.put("inpatientList", inpatientList);
		return map;
		
	 }
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getHinNoForFreeFromInfection(String serviceNo) {
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
	public Map<String, Object> showDefeicientReportJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<Object[]> unitList = new ArrayList<Object[]>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		
		rankList = session.createCriteria(MasRank.class)
						  .add(Restrictions.eq("Status", "y"))
						  .addOrder(Order.asc("RankName"))
						  .list();
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).setProjection(Projections.projectionList()
					.add(Projections.property("Id")).add(Projections.property("UnitName"))).addOrder(Order.asc("UnitName")).list();
		tradeList = session.createCriteria(MasTrade.class).add(Restrictions.eq("Status", "y")).addOrder(Order.asc("TradeName")).list();
		map.put("rankList", rankList);
		map.put("tradeList", tradeList);
		map.put("unitList", unitList);
		return map;
	}

	
	
	public Map<String,Object> getServiceNoDetailsForFreeFromInfection(Map<String,Object> mapForDS)
	 { 
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();	
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		int hinId = 0;   
		hinId = (Integer) mapForDS.get("hinId");
		
		@SuppressWarnings("unused")
		Patient patient = new Patient();
		
		patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
		inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Hin.Id", hinId)).list();
		      
		map.put("patientList", patientList);
		map.put("inpatientList", inpatientList);
		return map;
		
	 }


	@Override
	public Map<String, Object> getMonthlySickAdmissionDetails(Box box) {
		
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		int month = cal.get(Calendar.MONTH)+1;
		int year =cal.get(Calendar.YEAR);
	
		List<MonthlySickAdmDetails> monthlyAdmList = new ArrayList<MonthlySickAdmDetails>();
		List<Object[]> admList = new ArrayList<Object[]>();
		List<Object[]> diagList = new ArrayList<Object[]>();
		String catQry = "";
		String monthlyQry = "";
		monthlyQry = "select msad from MonthlySickAdmDetails as msad join msad.MonthlySickAdmHeader as msah " +
					" where extract(month from msah.MonthlyAdmReportDate) = "+month+" and extract(year from msah.MonthlyAdmReportDate) = "+year+" and msah.Hospital.Id="+box.getInt("hospitalId");
	
		if(box.getInt(CATEGORY_ID)!=0){
			monthlyQry += " and msad.Hin.Rank.RankCategory.Id="+box.getInt(CATEGORY_ID);
			catQry += " and c.rank_category_id="+box.getInt(CATEGORY_ID);
		}
		
		monthlyAdmList = session.createQuery(monthlyQry).list();
		
		if(monthlyAdmList.size() == 0){
			String qry ="";
			
			qry = "select a.inpatient_id, (b.p_first_name ||' '|| b.p_middle_name ||' '|| b.p_last_name) patient_name," +
				" c.rank_name, d.trade_name, a.age, f.unit_name,(b.service_no ||' '||b.suffix) AS service_no," +
				" a.date_of_addmission, a.discharge_date, " +
				" i.rank_category_name," +
				" a.init_diagnosis, j.hospital_name," +
				" trunc(TO_DATE(discharge_date, 'DD-MM-YYYY'))- trunc(TO_DATE(date_of_addmission,'DD-MM-YYYY')) noOfDays,a.hin_id,a.ad_no" +
				" from inpatient a left outer join patient b on a.hin_id = b.hin_id" +
				" left outer join mas_rank c on b.rank_id = c.rank_id" +
				" left outer join mas_trade d on b.trade_id = d.trade_id" +
				" left outer join mas_relation e on b.relation_id = e.relation_id" +
				" left outer join mas_unit f on b.unit_id = f.unit_id" +
				" left outer join patient_discharge_slip g on g.ad_no = a.ad_no" +
				" left outer join mas_rank_category i on i.rank_category_id = c.rank_category_id" +
				" left outer join mas_hospital j on b.hospital_id=j.hospital_id" +
				" where extract(month from a.date_of_addmission)= "+month+" and extract(year from a.date_of_addmission) = "+year+
				" and a.ad_status!='C' and b.relation_id = 8  and b.service_type_id=2  and a.hospital_id="+box.getInt("hospitalId") +
				catQry+
				" order by a.date_of_addmission";

			admList = session.createSQLQuery(qry).list();

			String diagQry= "";
			diagQry = "select distinct  (b.icd_code ||' '||b.icd_name) icd_code_name,a.inpatient_id " +
				" from discharge_icd_code a" +
				" left outer join mas_icd b on a.icd_id = b.icd_id" +
				" left outer join inpatient i on a.inpatient_id=i.inpatient_id" +
				" left outer join patient p on i.hin_id = p.hin_id "+
				" where extract(month from i.date_of_addmission)= "+month+" and extract(year from i.date_of_addmission) = "+year+
				" and i.ad_status!='C' and p.relation_id = 8  and p.service_type_id=2   and i.hospital_id="+box.getInt("hospitalId")+
				" and a.icd_id is not null";
			diagList = session.createSQLQuery(diagQry).list();

			map.put("admList", admList);
			map.put("diagList", diagList);
		}
		map.put("monthlyAdmList", monthlyAdmList);
		return map;
	}

	@Override
	public Map<String, Object> getServiceNoDetails(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		patientList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", box.getString("serviceNo"))).add(Restrictions.eq("Relation.Id", 8)).list();
		map.put("patientList",patientList);
		return map;
	}

	@Override
	public Map<String, Object> submitMonthlySickAdmission(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		Transaction tx = null;
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		
		try {
			tx= session.beginTransaction();
			MonthlySickAdmHeader monthlySickAdmHeader = new MonthlySickAdmHeader();
			if(box.getInt("monthlySickAdmHdId")==0){
				monthlySickAdmHeader.setMonthlyAdmReportDate(HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate")));
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				monthlySickAdmHeader.setHospital(hospital);
				Users user = new Users();
				user.setId(box.getInt("userId"));
				monthlySickAdmHeader.setLastChgBy(user);
				monthlySickAdmHeader.setLastChgDate(new Date());
				monthlySickAdmHeader.setLastChgTime(time);
				hbt.save(monthlySickAdmHeader);
			}else{
				monthlySickAdmHeader.setId(box.getInt("monthlySickAdmHdId"));
			}
			int cnt = box.getInt("cnt");
			if(cnt > 0){
				for (int i =1; i <= cnt; i++) {
					if(!box.getString("serviceNo"+i).equals("")){
						if(box.getInt("monthlyAdmDtId"+i)!=0){
							MonthlySickAdmDetails monthlySickAdmDetails = (MonthlySickAdmDetails)hbt.load(MonthlySickAdmDetails.class, box.getInt("monthlyAdmDtId"+i));
							if(!box.getString("doa"+i).equals(""))
								monthlySickAdmDetails.setDateOfAdmission(HMSUtil.convertStringTypeDateToDateType(box.getString("doa"+i)));
							if(!box.getString("dod"+i).equals(""))
								monthlySickAdmDetails.setDateOfDischarge(HMSUtil.convertStringTypeDateToDateType(box.getString("dod"+i)));
							monthlySickAdmDetails.setDiagnosis(box.getString("diagnosis"+i));
							monthlySickAdmDetails.setDisposedOff(box.getString("disposedOff"+i));
							monthlySickAdmDetails.setNoOfDays(box.getInt("noOfDays"+i));

							hbt.update(monthlySickAdmDetails);
						}else{
							MonthlySickAdmDetails monthlySickAdmDetails = new MonthlySickAdmDetails();
							if(!box.getString("doa"+i).equals(""))
								monthlySickAdmDetails.setDateOfAdmission(HMSUtil.convertStringTypeDateToDateType(box.getString("doa"+i)));
							if(!box.getString("dod"+i).equals(""))
								monthlySickAdmDetails.setDateOfDischarge(HMSUtil.convertStringTypeDateToDateType(box.getString("dod"+i)));
							monthlySickAdmDetails.setDiagnosis(box.getString("diagnosis"+i));
							monthlySickAdmDetails.setDisposedOff(box.getString("disposedOff"+i));
							monthlySickAdmDetails.setNoOfDays(box.getInt("noOfDays"+i));
							if(box.getInt("hinId"+i)!=0){
								Patient patient = new Patient();
								patient.setId(box.getInt("hinId"+i));
								monthlySickAdmDetails.setHin(patient);
							}
							if(box.getInt("inpatientId"+i)!=0){
								Inpatient inpatient= new Inpatient();
								inpatient.setId(box.getInt("inpatientId"+i));
								monthlySickAdmDetails.setInpatient(inpatient);
							}
							monthlySickAdmDetails.setMonthlySickAdmHeader(monthlySickAdmHeader);
							monthlySickAdmDetails.setAdNo(box.getString("adNo"+i));
							monthlySickAdmDetails.setRemarks(box.getString("remarks"+i));
							
							hbt.save(monthlySickAdmDetails);
						}
					}
				}
			}
			flag = true;
			tx.commit();
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> getMonthlySickDischargeDetails(Box box) {
		
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE)));
		int month = cal.get(Calendar.MONTH)+1;
		int year = cal.get(Calendar.YEAR);
		
		List<MonthlyDischargeDt> monthlyDisList = new ArrayList<MonthlyDischargeDt>();
		List<Object[]> dischargeList = new ArrayList<Object[]>();
		List<Object[]> diagList = new ArrayList<Object[]>();
		String catQry = "";
		String monthlyQry = "";
		monthlyQry = "select msad from MonthlyDischargeDt as msad join msad.MonthlyDisHd as msah " +
					" where extract(month from msah.MonthlyDisReportDate) = "+month+" and extract(year from msah.MonthlyDisReportDate) = "+year+" and msah.Hospital.Id="+box.getInt("hospitalId");
	
		if(box.getInt(CATEGORY_ID)!=0){
			monthlyQry += " and msad.Hin.Rank.RankCategory.Id="+box.getInt(CATEGORY_ID);
			catQry += " and i.rank_category_id="+box.getInt(CATEGORY_ID);
		}
		
		monthlyDisList = session.createQuery(monthlyQry).list();
		
		if(monthlyDisList.size() == 0){
			String qry ="";
			
			qry = "select distinct a.inpatient_id, " +
					"(b.p_first_name ||' '|| b.p_middle_name||' '||b.p_last_name) patient_name," +
					" c.rank_name, d.trade_name, a.age, e.relation_name, f.unit_name, b.service_no," +
					" a.date_of_addmission, a.discharge_date, i.rank_category_name," +
					" k.hospital_name from inpatient a" +
					" left outer join patient b on a.hin_id = b.hin_id" +
					" left outer join mas_rank c on b.rank_id = c.rank_id" +
					" left outer join mas_trade d on b.trade_id = d.trade_id" +
					" left outer join mas_relation e on b.relation_id = e.relation_id" +
					" left outer join mas_unit f on b.unit_id = f.unit_id" +
					" left outer join patient_discharge_slip g on g.ad_no = a.ad_no" +
					" left outer join mas_rank_category i on i.rank_category_id = c.rank_category_id" +
					" left outer join discharge_icd_code j on j.inpatient_id = a.inpatient_id" +
					" left outer join mas_hospital k on b.hospital_id=k.hospital_id" +
					" where extract(month from g.dicharge_date)= "+month+" and extract(year from g.dicharge_date) = "+year+ 
					" and a.ad_status!='C' and b.relation_id = 8  and b.service_type_id=2" +
					" and j.icd_id is not null   and a.hospital_id="+box.getInt("hospitalId") +
					catQry+
					" order by a.discharge_date ";

			dischargeList = session.createSQLQuery(qry).list();

			String diagQry= "";
			diagQry = "select distinct  (b.icd_code ||' '||b.icd_name) icd_code_name,a.inpatient_id " +
				" from discharge_icd_code a" +
				" left outer join mas_icd b on a.icd_id = b.icd_id" +
				" left outer join inpatient i on a.inpatient_id=i.inpatient_id" +
				" left outer join patient p on i.hin_id = p.hin_id "+
				" where extract(month from i.date_of_addmission)= "+month+" and extract(year from i.date_of_addmission) = "+year+ 
				" and i.ad_status!='C' and p.relation_id = 8  and p.service_type_id=2   and i.hospital_id="+box.getInt("hospitalId")+
				" and a.icd_id is not null";
			diagList = session.createSQLQuery(diagQry).list();

			map.put("dischargeList", dischargeList);
			map.put("diagList", diagList);
		}
		map.put("monthlyDisList", monthlyDisList);
		return map;
	}

	@Override
	public Map<String, Object> submitMonthlySickDischarge(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		Transaction tx = null;
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		
		try {
			tx= session.beginTransaction();
			MonthlyDischargeHd monthlyDisHd = new MonthlyDischargeHd();
			if(box.getInt("monthlyDisHdId")==0){
				monthlyDisHd.setMonthlyDisReportDate(HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate")));
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				monthlyDisHd.setHospital(hospital);
				Users user = new Users();
				user.setId(box.getInt("userId"));
				monthlyDisHd.setLastChgBy(user);
				monthlyDisHd.setLastChgDate(new Date());
				monthlyDisHd.setLastChgTime(time);
				hbt.save(monthlyDisHd);
			}else{
				monthlyDisHd.setId(box.getInt("monthlyDisHdId"));
			}
			int cnt = box.getInt("cnt");
			if(cnt > 0){
				for (int i =1; i <= cnt; i++) {
					if(!box.getString("serviceNo"+i).equals("")){
						if(box.getInt("monthlyDisDtId"+i)!=0){
							MonthlyDischargeDt monthlyDisDt = (MonthlyDischargeDt)hbt.load(MonthlyDischargeDt.class, box.getInt("monthlyDisDtId"+i));
							if(!box.getString("dod"+i).equals(""))
								monthlyDisDt.setDateOfDischarge(HMSUtil.convertStringTypeDateToDateType(box.getString("dod"+i)));
							monthlyDisDt.setDiagnosis(box.getString("diagnosis"+i));
							monthlyDisDt.setDisposedOff(box.getString("disposedOff"+i));

							hbt.update(monthlyDisDt);
						}else{
							MonthlyDischargeDt monthlyDisDt = new MonthlyDischargeDt();
							if(!box.getString("dod"+i).equals(""))
								monthlyDisDt.setDateOfDischarge(HMSUtil.convertStringTypeDateToDateType(box.getString("dod"+i)));
							monthlyDisDt.setDiagnosis(box.getString("diagnosis"+i));
							monthlyDisDt.setDisposedOff(box.getString("disposedOff"+i));
							if(box.getInt("hinId"+i)!=0){
								Patient patient = new Patient();
								patient.setId(box.getInt("hinId"+i));
								monthlyDisDt.setHin(patient);
							}
							if(box.getInt("inpatientId"+i)!=0){
								Inpatient inpatient= new Inpatient();
								inpatient.setId(box.getInt("inpatientId"+i));
								monthlyDisDt.setInpatient(inpatient);
							}
							if(box.getInt("dischargeSlipId"+i)!=0){
								PatientDischargeSlip dischargeSlip= new PatientDischargeSlip();
								dischargeSlip.setId(box.getInt("dischargeSlipId"+i));
								monthlyDisDt.setDischargeSlip(dischargeSlip);
							}
							monthlyDisDt.setMonthlyDisHd(monthlyDisHd);
							monthlyDisDt.setAdNo(box.getString("adNo"+i));
							
							hbt.save(monthlyDisDt);
						}
					}
				}
			}
			flag = true;
			tx.commit();
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}


	
	@Override
	public Map<String, Object> showMonthlyWorkLoadReport(Map<String, Object> map) {
		
		Session session = (Session) getSession();

		List<MasUnit> unitList = new ArrayList<MasUnit>();
		
		try 
		{
			unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("unitList", unitList);
		return map;
		
	}
	
	public Map<String,Object> getWaitingPatientListForNotifiable(Map mapForDS)
	{  
	Map<String, Object> map = new HashMap<String, Object>();
	Session session = (Session) getSession();
	int deptId = (Integer) mapForDS.get("deptId");
	int hospitalId = (Integer) mapForDS.get("hospitalId");
	String userId = ""+mapForDS.get("userId");		
	int userId1=Integer.parseInt(userId);

	String n="n";
	List<OpdPatientDetails> patientList = new ArrayList<OpdPatientDetails>();
	try
	{
		patientList = session.createCriteria(OpdPatientDetails.class).add(Restrictions.eq("Hospital.Id",hospitalId)).add(Restrictions.eq("NotifiableStatus","y")).list();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}     
	map.put("patientList", patientList); 
	return  map;
	}
	
	//----notifiable
	
	public Map<String, Object> showNotifiableDiseaseWLJsp(Map<String, Object> generalMap) 
	{
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIcd> diagnosisList = new ArrayList<MasIcd>();
		List<MasMedicalExaminationDetail> masMedicalExaminationDetailList = new ArrayList<MasMedicalExaminationDetail>();
		List<OpdPatientDetails> opdPatientDetailsList = new ArrayList<OpdPatientDetails>();
	
		
		int opdId=0;
		if(generalMap.get("opdId") != null )
		{
			opdId = (Integer)generalMap.get("opdId");
		}
		
		try {

			String query = "select c.icd_name from opd_patient_details o left outer join visit v on o.visit_id=v.visit_id left outer join discharge_icd_code i on i.visit_id=v.visit_id left outer join mas_icd c on c.icd_id=i.icd_id where o.id = '"+opdId+"'";
			
			diagnosisList = (List) session.createSQLQuery(query).list();			
			
			
			
			//diagnosisList = session.createCriteria(MasIcd.class).add(Restrictions.eq("Status", "y")).list();

			masMedicalExaminationDetailList = session.createCriteria(MasMedicalExaminationDetail.class)
			.add(Restrictions.eq("Particular", "detail")).list();
			
			opdPatientDetailsList = session.createCriteria(OpdPatientDetails.class).add(Restrictions.eq("id", opdId)).list();
			
						
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("diagnosisList", diagnosisList);
		map.put("opdPatientDetailsList", opdPatientDetailsList);
		map.put("masMedicalExaminationDetailList", masMedicalExaminationDetailList);
		return map;

	}
	
	//- submit notifiable wl
	
	public boolean submitNotifiableDiseaseWLJsp(Map map)
	{ 
		boolean succesfullyAdded = false;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Date  dateOfOnset=null;
		Date dateOfReportingSick= null;
		Date dateOfNotifiable = null;
		String dateofPreventive = "";
		int hospital_Id = 0;
		int departmentId = 0;
		int hinNumber = 0;
		String serviceNo = "";
		String patientName ="";
		String rank = "";
		String age  = "";
		String contact ="";
		String Detailsofcase = "";
		String clinical = "";
		String bacteriological = "";
		String disinfection ="";
		String  genaralRemarks="";
		String suspectedsourceofinfection="";
		int hinId = 0;
		int opdId=0;
		
		if(map.get("hospitalId")!= null)
		{
			hospital_Id = (Integer)map.get("hospitalId");
		}
		if(map.get("departmentId")!= null)
		{
			departmentId = (Integer)map.get("departmentId");
		}
		if(map.get("hinNumber")!= null)
		{ 
			hinNumber =(Integer) map.get("hinNumber");
		}
		if(map.get("serviceNo")!= null)
		{
			serviceNo = (String)map.get("serviceNo");
		}
		if(map.get("patientName")!= null)
		{	 
			patientName =  (String) map.get("patientName");
		}
		if(map.get("rank")!= null)
		{  
			rank =(String)map.get("rank");	
		}
		if(map.get("age")!= null)
		{
			age=(String)map.get("age");
		}
		if(map.get("contact")!= null)
		{	   
			contact = (String)map.get("contact");
		}
		if(map.get("dateOfOnset")!= null)
		{
			dateOfOnset = (Date) map.get("dateOfOnset");
		}
		if(map.get("dateOfReportingSick")!= null)
		{   
			dateOfReportingSick =(Date)map.get("dateOfReportingSick");		    
		}
		if(map.get("Detailsofcase")!= null)
		{   	    	   
			Detailsofcase =(String)map.get("Detailsofcase");	
		}
		if(map.get("clinical")!= null)
		{   
			clinical =(String)map.get("clinical");
		}
		if(map.get("bacteriological")!= null)
		{   
			bacteriological =(String)map.get("bacteriological");
		}
		if(map.get("disinfection")!= null)
		{   
			disinfection =(String)map.get("disinfection");
		}
		//String dateofPreventive =(String)map.get("dateofPreventive");
		if(map.get("genaralRemarks")!= null)
		{    genaralRemarks =(String)map.get("genaralRemarks");		  
		}
		if(map.get("dateOfNotifiable")!= null)
		{    dateOfNotifiable = (Date)map.get("dateOfNotifiable");		  
		}
		if(map.get("suspectedsourceofinfection")!= null)
		{    suspectedsourceofinfection = (String)map.get("suspectedsourceofinfection");		  
		}
		if(map.get("dateofPreventive")!= null)
		{    dateofPreventive = (String)map.get("dateofPreventive");		  
		}
		if(map.get("hinId")!= null)
		{    hinId = (Integer)map.get("hinId");		  
		}
		
		if(map.get("opdId") != null)
		{
			opdId = (Integer)map.get("opdId");
		}

		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			NotifiableDisease nd= new  NotifiableDisease();
			Patient p = new Patient();
			p.setId (hinId);
			nd.setHin_id(p);
			nd.setService_No(serviceNo);
			// nd.setPatientName(patientName);
			// nd.setRank(rank );
			// nd.setAge(age);
			// nd.setTotalService(lenghtofService);
			// nd.setUnit(unit);
			//nd.setResidance(residence);
			nd.setDateOfOnset(dateOfOnset);
			nd.setDateOfReportingSick(dateOfReportingSick);
			nd.setDetailsOfCase(Detailsofcase);
			nd.setClinical(clinical);
			nd.setBacteriological(bacteriological);
			nd.setDisinfection(disinfection);			
			nd.setGeneralRemarks(genaralRemarks);
			nd.setContact(contact);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospital_Id);
			nd.setHospital_Id(masHospital);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			nd.setDepartmentId(masDepartment);
			nd.setDateOfAdmission(dateOfNotifiable);
			nd.setSuspectedSourceOfInfection(suspectedsourceofinfection);
			nd.setDateOfPreventive(dateofPreventive);
			hbt.save(nd);
			hbt.refresh(nd);
			
			OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
			opdPatientDetails=(OpdPatientDetails) hbt.load(OpdPatientDetails.class, opdId);
			opdPatientDetails.setNotifiableStatus("submit");
			hbt.update(opdPatientDetails);
			hbt.refresh(opdPatientDetails);

		
			succesfullyAdded = true;
			int notifiableId=0;
			notifiableId = nd.getId();
			map.put("notifiableId", notifiableId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return   succesfullyAdded;
	}
	
	public boolean submitVectorControlActivity(Map map)
	{
		int  hospitalId =0;
		int departmentId = 0;
		if(map.get("hospitalId")!= null)
		{
			hospitalId = (Integer)map.get("hospitalId");
		}
		if(map.get("departmentId")!= null)
		{
			departmentId = (Integer)map.get("departmentId");
		}
		List<Date> larvalDate = new ArrayList<Date>();
		List<String> larvalChemical = new ArrayList<String>();
		List<String> larvalarea =new ArrayList<String>();
		List<String> larvalsupervisor = new ArrayList<String>();
		List<String> larvalcarriedoutby =new ArrayList<String>();
		List<String> larvalnoCovered =new ArrayList<String>();
		List<String> larvalrecieve = new ArrayList<String>();
		List<String> larvalissue = new ArrayList<String>();
		List<String> larvalbalance =new ArrayList<String>();
		List<String> larvalremarks = new ArrayList<String>();
		List<Date> adultDate = new ArrayList<Date>();
		List<String> adultChemical = new ArrayList<String>();
		List<String> adultarea =new ArrayList<String>();
		List<String> adultsupervisor = new ArrayList<String>();
		List<String> adultcarriedOut = new ArrayList<String>();
		List<String> adultnoCovered = new ArrayList<String>();
		List<String> adultrecieve = new ArrayList<String>();
		List<String> adultissue = new ArrayList<String>();
		List<String> adultbalance = new ArrayList<String>();
		List<String> adultremarks = new ArrayList<String>();
		List<Date> foggingDate = new ArrayList<Date>();
		List<String> foggingarea = new ArrayList<String>();
		List<String> foggingsupervisor = new ArrayList<String>();
		List<String> foggingcarriedOut = new ArrayList<String>();
		List<String> foggingnoCovered = new ArrayList<String>();
		List<String> foggingreceive = new ArrayList<String>();
		List<String> foggingissue = new ArrayList<String>();
		List<String> foggingbalance =new ArrayList<String>();
		List<String> foggingremarks = new ArrayList<String>();		
		List<Date> ibnDate = new ArrayList<Date>();
		List<String> ibnChemical = new ArrayList<String>();
		List<String> ibnarea = new ArrayList<String>();
		List<String> ibnsupervisor = new ArrayList<String>();
		List<String> ibncarriedOut = new ArrayList<String>();
		List<String> ibnnoCovered = new ArrayList<String>();
		List<String> ibnreceive = new ArrayList<String>();
		List<String> ibnissued = new ArrayList<String>();
		List<String> ibnbalance = new ArrayList<String>();
		List<String> ibnremarks = new ArrayList<String>();
		List<Date> flyDate = new ArrayList<Date>();
		List<String> antiFlyChemical =new ArrayList<String>();
		List<String> flyarea = new ArrayList<String>();
		List<String> flysupervisor = new ArrayList<String>();
		List<String> flycarriedOut =new ArrayList<String>();
		List<String> flynoCovered = new ArrayList<String>();
		List<String> flyreceive =new ArrayList<String>();
		List<String> flyissued = new ArrayList<String>();
		List<String> flybalance = new ArrayList<String>();
		List<String> flyremarks =new ArrayList<String>();
		List<Date> debuggingDate = new ArrayList<Date>();
		List<String> debuggingChemical = new ArrayList<String>();
		List<String> debuggingarea =new ArrayList<String>();
		List<String> debuggingsupervisor =new ArrayList<String>();
		List<String> debuggingcarriedOut = new ArrayList<String>();
		List<String> debuggingnoCovered =new ArrayList<String>();	
		List<String> debuggingreceive =new ArrayList<String>();
		List<String> debuggingissued = new ArrayList<String>();
		List<String> debuggingbalance = new ArrayList<String>();
		List<String> debuggingremarks = new ArrayList<String>();
		List<Date> biologicalDate = new ArrayList<Date>();
		List<String> biologicalChemical = new ArrayList<String>();
		List<String> biologicalarea = new ArrayList<String>();
		List<String> biologicalsupervisor = new ArrayList<String>();
		List<String> biologicalcarriedOut = new ArrayList<String>();
		List<String> biologicalnoCovered = new ArrayList<String>();
		List<String> biologicalreceive = new ArrayList<String>();
		List<String> biologicalissued = new ArrayList<String>();
		List<String> biologicalbalance = new ArrayList<String>();
		List<String> biologicalremarks = new ArrayList<String>();
		List<String> foggingChemical =new ArrayList<String>();
		List<Date> protectiveDate = new ArrayList<Date>();
		List<String> protectiveMeasures = new ArrayList<String>();
		List<String> protectivesupervisor = new ArrayList<String>();
		List<String> protectiveRemark = new ArrayList<String>();
		List<Date> antiMalariaDate = new ArrayList<Date>();
		List<String> antiMalariaMeeting = new ArrayList<String>();
		List<String> underSuppressiveTreatment = new ArrayList<String>();
		List<String> antiMalariaSupervisor = new ArrayList<String>();
		List<String> antiMalariaRemarks = new ArrayList<String>();
		List<Date> malariaCasesDate = new ArrayList<Date>();
		List<String> bloodSlidesExamined = new ArrayList<String>();
		List<Integer> detectedMalariaCases = new ArrayList<Integer>();
		List<String> malariaCasesType = new ArrayList<String>();
		List<String> category = new ArrayList<String>();
		List<String> plasmodium = new ArrayList<String>();
		List<String> properlyInvestigated = new ArrayList<String>();
		List<String> remedialMeasures = new ArrayList<String>();
		int srNo = 0;
		int srNo2 =0;
		int srNo3 =0;
		int srNo4 =0;
		int srNo5 =0;
		int srNo6=0;
		int srNo7 = 0;
		int srNo8 = 0;
		int srNo9 = 0;
		int srNo10 = 0;
		/******************************End of Variable declaration**********************************/
		if(map.get("srNo")!= null)
		{
			srNo = (Integer) map.get("srNo");
		}
		if(map.get("srNo2")!= null)
		{
			srNo2 = (Integer) map.get("srNo2");
		}
		if(map.get("srNo3")!= null)
		{
			srNo3 = (Integer) map.get("srNo3");
		}
		if(map.get("srNo4")!= null)
		{
			srNo4 = (Integer) map.get("srNo4");
		}
		if(map.get("srNo5")!= null)
		{
			srNo5 = (Integer) map.get("srNo5");
		}
		if(map.get("srNo6")!= null)
		{
			srNo6 = (Integer) map.get("srNo6");
		}
		if(map.get("srNo7")!= null)
		{
			srNo7 = (Integer) map.get("srNo7");
		}
		if(map.get("srNo8")!= null)
		{
			srNo8 = (Integer) map.get("srNo8");
		}
		if(map.get("srNo9")!= null)
		{
			srNo9 = (Integer) map.get("srNo9");
		}
		if(map.get("srNo10")!= null)
		{
			srNo10 = (Integer) map.get("srNo10");
		}

	if(map.get("larvalDate")!= null)
		{
			larvalDate=(List) map.get("larvalDate");
		}
		if(map.get("larvalChemical")!= null)
		{
			larvalChemical = (List)map.get("larvalChemical");
		}
		if(map.get("larvalarea")!= null)
		{
			larvalarea =(List)map.get("larvalarea");
		}
		if(map.get("larvalsupervisor")!= null)
		{
			larvalsupervisor = (List)map.get("larvalsupervisor");
		}
		if(map.get("larvalcarriedoutby")!= null)
		{
			larvalcarriedoutby= (List)map.get("larvalcarriedoutby");
		}
		if(map.get("larvalnoCovered")!= null)
		{
			larvalnoCovered=(List) map.get("larvalnoCovered");
		}
		if(map.get("larvalrecieve")!= null)
		{
			larvalrecieve=(List) map.get("larvalrecieve");
		}
		if(map.get("larvalissue")!= null)
		{
			larvalissue = (List)map.get("larvalissue");
		}
		if(map.get("larvalbalance")!= null)
		{
			larvalbalance = (List)map.get("larvalbalance");
		}
		if(map.get("larvalremarks")!= null)
		{
			larvalremarks=(List) map.get("larvalremarks");
		}
		
		if(map.get("adultDate")!= null)
		{
			adultDate= (List)map.get("adultDate");
		}
		if(map.get("adultChemical")!= null)
		{
			adultChemical=(List) map.get("adultChemical");
		}
		if(map.get("adultarea")!= null)
		{
			adultarea = (List)map.get("adultarea");
		}
		if(map.get("adultsupervisor")!= null)
		{
			adultsupervisor = (List) map.get("adultsupervisor");
		}
		if(map.get("adultcarriedOut")!= null)
		{
			adultcarriedOut = (List) map.get("adultcarriedOut");
		}
		if(map.get("adultnoCovered")!= null)
		{
			adultnoCovered =(List) map.get("adultnoCovered");
		}
		if(map.get("adultrecieve")!= null)
		{
			adultrecieve =(List) map.get("adultrecieve");
		}
		if(map.get("adultissue")!= null)
		{
			adultissue = (List)map.get("adultissue");
		}
		if(map.get("adultbalance")!= null)
		{
			adultbalance = (List)map.get("adultbalance");
		}
		if(map.get("adultremarks")!= null)
		{
			adultremarks= (List)map.get("adultremarks");
		}
		if(map.get("foggingDate")!= null)
		{
			foggingDate = (List)map.get("foggingDate");
		}
		if(map.get("foggingChemical")!= null)
		{
			foggingChemical =(List) map.get("foggingChemical");
		}
		if(map.get("foggingarea")!= null)
		{	foggingarea = (List)map.get("foggingarea");
		}

		if(map.get("foggingsupervisor")!= null)
		{
			foggingsupervisor = (List)map.get("foggingsupervisor");
		}
		if(map.get("foggingcarriedOut")!= null)
		{
			foggingcarriedOut = (List)map.get("foggingcarriedOut");
		}
		if(map.get("foggingnoCovered")!= null)
		{
			foggingnoCovered= (List)map.get("foggingnoCovered");
		}
		if(map.get("foggingreceive")!= null)
		{
			foggingreceive= (List)map.get("foggingreceive");
		}
		if(map.get("foggingissue")!= null)
		{
			foggingissue = (List)map.get("foggingissue");
		}
		if(map.get("foggingbalance")!= null)
		{
			foggingbalance = (List)map.get("foggingbalance");
		}
		if(map.get("foggingremarks")!= null)
		{
			foggingremarks = (List)map.get("foggingremarks");
		}
		if(map.get("ibnDate")!= null)
		{
			ibnDate= (List)map.get("ibnDate");
		}
		if(map.get("ibnChemical")!= null)
		{
			ibnChemical= (List)map.get("ibnChemical");
		}
		if(map.get("ibnarea")!= null)
		{
			ibnarea = (List)map.get("ibnarea");
		}
		if(map.get("ibnsupervisor")!= null)
		{
			ibnsupervisor = (List)map.get("ibnsupervisor");
		}
		if(map.get("ibncarriedOut")!= null)
		{
			ibncarriedOut= (List)map.get("ibncarriedOut");
		}
		if(map.get("ibnnoCovered")!= null)
		{
			ibnnoCovered = (List)map.get("ibnnoCovered");
		}
		if(map.get("ibnreceive")!= null)
		{
			ibnreceive = (List)map.get("ibnreceive");
		}
		if(map.get("ibnissued")!= null)
		{
			ibnissued= (List)map.get("ibnissued");
		}
		if(map.get("ibnbalance")!= null)
		{
			ibnbalance= (List)map.get("ibnbalance");
		}
		if(map.get("ibnremarks")!= null)
		{
			ibnremarks= (List)map.get("ibnremarks");
		}
		if(map.get("flyDate")!= null)
		{
			flyDate= (List)map.get("flyDate");
		}
		if(map.get("antiFlyChemical")!= null)
		{
			antiFlyChemical = (List)map.get("antiFlyChemical");
		}
		if(map.get("flyarea")!= null)
		{
			flyarea = (List)map.get("flyarea");
		}
		if(map.get("flysupervisor")!= null)
		{
			flysupervisor= (List)map.get("flysupervisor");
		}
		if(map.get("flycarriedOut")!= null)
		{
			flycarriedOut = (List)map.get("flycarriedOut");
		}
		if(map.get("flynoCovered")!= null)
		{
			flynoCovered= (List)map.get("flynoCovered");
		}
		if(map.get("flyreceive")!= null)
		{
			flyreceive = (List)map.get("flyreceive");
		}
		if(map.get("flyissued")!= null)
		{
			flyissued = (List)map.get("flyissued");
		}
		if(map.get("flybalance")!= null)
		{
			flybalance = (List)map.get("flybalance");
		}
		if(map.get("flyremarks")!= null)
		{
			flyremarks = (List)map.get("flyremarks");
		}
		if(map.get("debuggingDate")!= null)
		{
			debuggingDate = (List)map.get("debuggingDate");
		}
		if(map.get("debuggingChemical")!= null)
		{
			debuggingChemical = (List)map.get("debuggingChemical");
		}
		if(map.get("debuggingarea")!= null)
		{
			debuggingarea = (List)map.get("debuggingarea");
		}
		if(map.get("debuggingsupervisor")!= null)
		{
			debuggingsupervisor = (List)map.get("debuggingsupervisor");
		}
		if(map.get("debuggingcarriedOut")!= null)
		{
			debuggingcarriedOut = (List)map.get("debuggingcarriedOut");
		}
		if(map.get("debuggingnoCovered")!= null)
		{
			debuggingnoCovered = (List)map.get("debuggingnoCovered");
		}
		if(map.get("debuggingreceive")!= null)
		{
			debuggingreceive = (List)map.get("debuggingreceive");
		}
		if(map.get("debuggingissued")!= null)
		{
			debuggingissued = (List)map.get("debuggingissued");
		}
		if(map.get("debuggingbalance")!= null)
		{
			debuggingbalance = (List)map.get("debuggingbalance");
		}
		if(map.get("debuggingremarks")!= null)
		{
			debuggingremarks = (List)map.get("debuggingremarks");
		}
		if(map.get("biologicalDate")!= null)
		{
			biologicalDate = (List)map.get("biologicalDate");
		}
		if(map.get("biologicalChemical")!= null)
		{
			biologicalChemical = (List)map.get("biologicalChemical");
		}
		if(map.get("biologicalarea")!= null)
		{
			biologicalarea = (List)map.get("biologicalarea");
		}
		if(map.get("biologicalsupervisor")!= null)
		{
			biologicalsupervisor = (List)map.get("biologicalsupervisor");
		}
		if(map.get("biologicalcarriedOut")!= null)
		{
			biologicalcarriedOut = (List)map.get("biologicalcarriedOut");
		}
		if(map.get("biologicalnoCovered")!= null)
		{
			biologicalnoCovered = (List)map.get("biologicalnoCovered");
		}
		if(map.get("biologicalreceive")!= null)
		{
			biologicalreceive = (List)map.get("biologicalreceive");
		}
		if(map.get("biologicalissued")!= null)
		{
			biologicalissued = (List)map.get("biologicalissued");
		}
		if(map.get("biologicalbalance")!= null)
		{
			biologicalbalance = (List)map.get("biologicalbalance");
		}
		if(map.get("biologicalremarks")!= null)
		{
			biologicalremarks = (List)map.get("biologicalremarks");
		}
		if(map.get("protectiveDate")!= null)
		{
			protectiveDate = (List)map.get("protectiveDate");
		}
		if(map.get("protectiveMeasures")!= null)
		{
			protectiveMeasures = (List)map.get("protectiveMeasures");
		}
		if(map.get("protectivesupervisor")!= null)
		{
			protectivesupervisor = (List)map.get("protectivesupervisor");
		}
		if(map.get("protectiveRemark")!= null)
		{
			protectiveRemark = (List)map.get("protectiveRemark");
		}
		if(map.get("antiMalariaDate")!= null)
		{
			antiMalariaDate = (List)map.get("antiMalariaDate");
		}
		if(map.get("antiMalariaMeeting")!= null)
		{
			antiMalariaMeeting = (List)map.get("antiMalariaMeeting");
		}
		if(map.get("antiMalariaSupervisor")!= null)
		{
			antiMalariaSupervisor = (List)map.get("antiMalariaSupervisor");
		}
		if(map.get("antiMalariaRemarks")!= null)
		{
			antiMalariaRemarks = (List)map.get("antiMalariaRemarks");
		}
		if(map.get("malariaCasesDate")!= null)
		{
			malariaCasesDate = (List)map.get("malariaCasesDate");
		}
		if(map.get("bloodSlidesExamined")!= null)
		{
			bloodSlidesExamined = (List)map.get("bloodSlidesExamined");
		}
		if(map.get("detectedMalariaCases")!= null)
		{
			detectedMalariaCases = (List)map.get("detectedMalariaCases");
		}

		if(map.get("malariaCasesType")!= null)
		{
			malariaCasesType = (List)map.get("malariaCasesType");
		}
		if(map.get("category")!= null)
		{
			category = (List)map.get("category");
		}
		if(map.get("plasmodium")!= null)
		{
			plasmodium = (List)map.get("plasmodium");
		}
		if(map.get("properlyInvestigated")!= null)
		{
			properlyInvestigated = (List)map.get("properlyInvestigated");
		}

		if(map.get("remedialMeasures")!= null)
		{
			remedialMeasures = (List)map.get("remedialMeasures");
		}




		boolean successfullyAdded = false;	

		try
		{  
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			for(int i=0; i<srNo; i++)
			{  
			VectorControlActivity vectorActivity = new VectorControlActivity();
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			vectorActivity.setHospitalId(masHospital);
			
			MasDepartment masdepartment = new MasDepartment();
			masdepartment.setId(departmentId);
			vectorActivity.setDepartmentId(masdepartment);
			
	        vectorActivity.setActivityDate(larvalDate.get(i));
			vectorActivity.setChemicalName(larvalChemical.get(i));
			vectorActivity.setArea(larvalarea.get(i));		    	  
			vectorActivity.setSupervisor(larvalsupervisor.get(i)); 	  
			vectorActivity.setCarriedOutBy(larvalcarriedoutby.get(i));
			vectorActivity.setNoOfBuildingCovered(larvalnoCovered.get(i));
			vectorActivity.setReceived(larvalrecieve.get(i));
			vectorActivity.setIssued(larvalissue.get(i));
			vectorActivity.setTotal(larvalbalance.get(i)) ; 
			vectorActivity.setRemarks(larvalremarks.get(i));
			//vectorActivity.setActivityName(country1);
			hbt.save(vectorActivity);
			successfullyAdded  = true;
			}
			
			for(int j=0; j <srNo2; j++)
			{  
			VectorControlActivity vectorActivityAdult = new VectorControlActivity();
			/*MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			vectorActivity.setHospitalId(masHospital);
			
			MasDepartment masdepartment = new MasDepartment();
			masdepartment.setId(departmentId);
			vectorActivity.setDepartmentId(masdepartment);	*/
			vectorActivityAdult.setAdultActivityDate(adultDate.get(j));
			vectorActivityAdult.setAdultChemicalName(adultChemical.get(j));
			vectorActivityAdult.setAdultArea(adultarea.get(j));
			vectorActivityAdult.setAdultSupervisor(adultsupervisor.get(j));
			vectorActivityAdult.setAdultCarriedOutBy(adultcarriedOut.get(j));
			vectorActivityAdult.setAdultNoOfBuildingCovered(adultnoCovered.get(j));
			vectorActivityAdult.setAdultReceived(adultrecieve.get(j));
			vectorActivityAdult.setAdultIssued(adultissue.get(j));
			vectorActivityAdult.setAdultBalance(adultbalance.get(j)) ; 
			vectorActivityAdult.setAdultRemarks(adultremarks.get(j));
			//vectorActivity.setAdultActivityName(country2);
			hbt.save(vectorActivityAdult);
			}
			
			for(int i=0; i<srNo3 ; i++)
			{ 
			VectorControlActivity vectorActivity = new VectorControlActivity();
			
			/*MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			vectorActivity.setHospitalId(masHospital);
			
			MasDepartment masdepartment = new MasDepartment();
			masdepartment.setId(departmentId);
			vectorActivity.setDepartmentId(masdepartment);*/	
			
			vectorActivity.setFoggActivityDate(foggingDate.get(i));
			vectorActivity.setFoggChemicalName(foggingChemical.get(i));
			vectorActivity.setFoggArea(foggingarea.get(i));
			vectorActivity.setFoggSupervisor(foggingsupervisor.get(i));
			vectorActivity.setFoggCarriedOutBy(foggingcarriedOut.get(i));
			vectorActivity.setFoggNoOfBuildingCovered(foggingnoCovered.get(i));
			vectorActivity.setFoggReceived(foggingreceive.get(i));
			vectorActivity.setFoggIssued(foggingissue.get(i));
			vectorActivity.setFoggBalance(foggingbalance.get(i)) ; 
			vectorActivity.setFoggRemarks(foggingremarks.get(i));
			// vectorActivity.setFoggActivityName(country3);
			hbt.save(vectorActivity);
			}
			
			for(int i=0; i< srNo4; i++)
			{ 
			VectorControlActivity vectorActivity = new VectorControlActivity();
			
			/*MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			vectorActivity.setHospitalId(masHospital);
			
			MasDepartment masdepartment = new MasDepartment();
			masdepartment.setId(departmentId);
			vectorActivity.setDepartmentId(masdepartment);	*/
			
			vectorActivity.setIbnActivityDate(ibnDate.get(i));
			vectorActivity.setIbnChemicalName(ibnChemical.get(i));
			vectorActivity.setIbnArea(ibnarea.get(i));
			vectorActivity.setIbnSupervisor(ibnsupervisor.get(i));
			vectorActivity.setIbnCarriedOutBy(ibncarriedOut.get(i));
			vectorActivity.setIbnNoOfBuildingCovered(ibnnoCovered.get(i));
			vectorActivity.setIbnReceived(ibnreceive.get(i));
			vectorActivity.setIbnIssued(ibnissued.get(i));
			vectorActivity.setIbnBalance(ibnbalance.get(i)) ;
			vectorActivity.setIbnRemarks(ibnremarks.get(i));
			// vectorActivity.setIbnActivityName(country4);
			hbt.save(vectorActivity);
			}
			
			for(int i=0; i<srNo5; i++)
			{   
			VectorControlActivity vectorActivity = new VectorControlActivity();
			
		/*	MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			vectorActivity.setHospitalId(masHospital);
			
			MasDepartment masdepartment = new MasDepartment();
			masdepartment.setId(departmentId);
			vectorActivity.setDepartmentId(masdepartment);*/
			
			vectorActivity.setFlyDate(flyDate.get(i));
			vectorActivity.setFlyChemicalName(antiFlyChemical.get(i));
			vectorActivity.setFlyArea(flyarea.get(i));
			vectorActivity.setFlySupervisor(flysupervisor.get(i));
			vectorActivity.setFlyCarriedOutBy(flycarriedOut.get(i));
			vectorActivity.setFlyNoOfBuildingCovered(flynoCovered.get(i));
			vectorActivity.setFlyReceived(flyreceive.get(i));
			vectorActivity.setFlyIssued(flyissued.get(i));
			vectorActivity.setFlyBalance(flybalance.get(i)) ; 
			vectorActivity.setFlyRemarks(flyremarks.get(i));
			//vectorActivity.setFlyActivityName(country5);
			hbt.save(vectorActivity);
			}

			for(int i=0; i<srNo6; i++)
			{ 
			VectorControlActivity vectorActivity = new VectorControlActivity();
			
	/*		MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			vectorActivity.setHospitalId(masHospital);
			
			MasDepartment masdepartment = new MasDepartment();
			masdepartment.setId(departmentId);
			vectorActivity.setDepartmentId(masdepartment);*/
			
			vectorActivity.setDebuggingDate(debuggingDate.get(i));
			vectorActivity.setDebuggingChemicalName(debuggingChemical.get(i));
			vectorActivity.setDebuggingArea(debuggingarea.get(i));
			vectorActivity.setDebuggingSupervisor(debuggingsupervisor.get(i));
			vectorActivity.setDebuggingCarriedOutBy(debuggingcarriedOut.get(i));
			vectorActivity.setDebuggingNoOfBuildingCovered(debuggingnoCovered.get(i));
			vectorActivity.setDebuggingReceived(debuggingreceive.get(i));
			vectorActivity.setDebuggingIssued(debuggingissued.get(i));
			vectorActivity.setDebuggingBalance(debuggingbalance.get(i)) ; 
			vectorActivity.setDebuggingRemarks(debuggingremarks.get(i));
			//vectorActivity.setDebuggingActivityName(country6);
			hbt.save(vectorActivity);
			}

			for(int i=0; i<srNo7 ;i++)
			{  
			VectorControlActivity vectorActivity = new VectorControlActivity();
			
		/*	MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			vectorActivity.setHospitalId(masHospital);
			
			MasDepartment masdepartment = new MasDepartment();
			masdepartment.setId(departmentId);
			vectorActivity.setDepartmentId(masdepartment);*/
			
			vectorActivity.setBioDate(biologicalDate.get(i));
			vectorActivity.setBioChemicalName( biologicalChemical.get(i));
			vectorActivity.setBioArea(biologicalarea.get(i));
			vectorActivity.setBioSupervisor(biologicalsupervisor.get(i));
			vectorActivity.setBioCarriedOutBy(biologicalcarriedOut.get(i));
			vectorActivity.setBioNoOfBuildingCovered(biologicalnoCovered.get(i));
			vectorActivity.setBioReceived(biologicalreceive.get(i));
			vectorActivity.setBioIssued(biologicalissued.get(i));
			vectorActivity.setBioBalance(biologicalbalance.get(i)) ; 
			vectorActivity.setBioRemarks(biologicalremarks.get(i));
			hbt.save(vectorActivity);
			}

			for(int i=0; i<srNo8 ;i++)
			{  
			VectorControlActivity vectorActivity = new VectorControlActivity();
			vectorActivity.setProtectiveDate(protectiveDate.get(i));
			vectorActivity.setProtectiveMeasures(protectiveMeasures.get(i));
			vectorActivity.setProtectiveSupervisor(protectivesupervisor.get(i));
			vectorActivity.setProtectiveRemarks(protectiveRemark.get(i));
			hbt.save(vectorActivity);
			}
			
			for(int i=0; i<srNo9 ;i++)
			{  
			VectorControlActivity vectorActivity = new VectorControlActivity();
			vectorActivity.setAntiMalariaDate(antiMalariaDate.get(i));
			vectorActivity.setAntiMalariaMeeting(antiMalariaMeeting.get(i));
			vectorActivity.setAntiMalariaSupervisor(antiMalariaSupervisor.get(i));
			vectorActivity.setAntiMalariaRemarks(antiMalariaRemarks.get(i));
			hbt.save(vectorActivity);
			}
			
			for(int i=0; i<srNo10 ;i++)
			{  
			VectorControlActivity vectorActivity = new VectorControlActivity();
			vectorActivity.setMalariaCasesDate(malariaCasesDate.get(i));
			vectorActivity.setBloodSlidesExamined(bloodSlidesExamined.get(i));
			vectorActivity.setMalariaCasesType(malariaCasesType.get(i));
			vectorActivity.setCategory(category.get(i));
			vectorActivity.setPlasmodium(plasmodium.get(i));
			vectorActivity.setDetectedMalariaCases(detectedMalariaCases.get(i));
			vectorActivity.setProperlyInvestigated(properlyInvestigated.get(i));
			vectorActivity.setRemedialMeasures(remedialMeasures.get(i));
			
			hbt.save(vectorActivity);
			}
			
			successfullyAdded  = true;
		}
		catch(Exception e)
		{ e.printStackTrace();
		}

		return successfullyAdded;
	}
	
	//----break down
	
	public boolean submitBreakDownJSP(Map map)
	{ 

		 int hospitalId =(Integer)map.get("hospitalId");
		 
		 Date currentDate = (Date) map.get("currentDate");	
		 Date lastUpdatedDate = (Date) map.get("lastUpdatedDate");	
			
		 String personnelOfficer = (String)map.get("personnelOfficer");	
		 String personnelAirmen = (String)map.get("personnelAirmen");	
		 String personnelNcs = (String)map.get("personnelNcs");	
		 String personnelArmy = (String)map.get("personnelArmy");	
		 String personnelCivilian = (String)map.get("personnelCivilian");	
		 String personnelTotal = (String)map.get("personnelTotal");	
		 
		 String wivesOfficer = (String)map.get("wivesOfficer");	
		 String wivesAirmen = (String)map.get("wivesAirmen");	
		 String wivesNcs = (String)map.get("wivesNcs");	
		 String wivesArmy = (String)map.get("wivesArmy");	
		 String wivesCivilian = (String)map.get("wivesCivilian");	
		 String wivesTotal = (String)map.get("wivesTotal");	
		 
		 String childrenOfficer = (String)map.get("childrenOfficer");	
		 String childrenAirmen = (String)map.get("childrenAirmen");	
		 String childrenNcs = (String)map.get("childrenNcs");	
		 String childrenArmy = (String)map.get("childrenArmy");	
		 String childrenCivilian = (String)map.get("childrenCivilian");	
		 String childrenTotal = (String)map.get("childrenTotal");	
		 
		 String totalOfficer = (String)map.get("totalOfficer");	
		 String totalAirmen = (String)map.get("totalAirmen");	
		 String totalNcs = (String)map.get("totalNcs");	
		 String totalArmy = (String)map.get("totalArmy");	
		 String totalCivilian = (String)map.get("totalCivilian");	
		 String totalTotal = (String)map.get("totalTotal");	
		
		
		
		boolean succesfullyAdded = false;		
		try{
			org.hibernate.Session session = getSession();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);	
			
			ShoBreakDown shoBreakDown = new ShoBreakDown();
			shoBreakDown.setHospital(masHospital);
			
			shoBreakDown.setCurrentDate(currentDate);
			shoBreakDown.setLastUpdatedDate(lastUpdatedDate);
			
			shoBreakDown.setPersonnelOfficer(personnelOfficer);
			shoBreakDown.setPersonnelAirmen(personnelAirmen);
			shoBreakDown.setPersonnelNcs(personnelNcs);
			shoBreakDown.setPersonnelArmy(personnelArmy);
			shoBreakDown.setPersonnelCivilian(personnelCivilian);
			shoBreakDown.setPersonnelTotal(personnelTotal);
			
			shoBreakDown.setWivesOfficer(wivesOfficer);
			shoBreakDown.setWivesAirmen(wivesAirmen);
			shoBreakDown.setWivesNcs(wivesNcs);
			shoBreakDown.setWivesArmy(wivesArmy);
			shoBreakDown.setWivesCivilian(wivesCivilian);
			shoBreakDown.setWivesTotal(wivesTotal);
			
			shoBreakDown.setChildrenOfficer(childrenOfficer);
			shoBreakDown.setChildrenAirmen(childrenAirmen);
			shoBreakDown.setChildrenNcs(childrenNcs);
			shoBreakDown.setChildrenArmy(childrenArmy);
			shoBreakDown.setChildrenCivilian(childrenCivilian);
			shoBreakDown.setChildrenTotal(childrenTotal);
			
			shoBreakDown.setTotalOfficer(totalOfficer);
			shoBreakDown.setTotalAirmen(totalAirmen);
			shoBreakDown.setTotalNcs(totalNcs);
			shoBreakDown.setTotalArmy(totalArmy);
			shoBreakDown.setTotalCivilian(totalCivilian);
			shoBreakDown.setTotalTotal(totalTotal);
			
			hbt.save(shoBreakDown);
			hbt.refresh(shoBreakDown);
			
			succesfullyAdded = true;
			
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return succesfullyAdded ;
	}


public Map<String, Object> showBreakDown(Map<String, Object> map)
{
	int hospitalId=0;		
	List<ShoBreakDown> shoBreakDownList = new ArrayList<ShoBreakDown>();
	Session session = (Session) getSession();
	
	if(map.get("hospitalId")!=null)
	{
		hospitalId=(Integer)map.get("hospitalId");
	}
	
	try
	{
		shoBreakDownList = session.createCriteria(ShoBreakDown.class).add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	map.put("shoBreakDownList", shoBreakDownList);
	
	return map;
}

public Map<String, Object> showShoAccommodation(Map<String, Object> map)
{
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	Session session = (Session) getSession();
	
	try
	{
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	map.put("unitList", unitList);
	
	return map;
}

//----Submit Accommodation JSP

public boolean submitShoAccommodationJSP(Map map)
{ 

	 int hospitalId =(Integer)map.get("hospitalId");
	 
	 Date currentDate = (Date) map.get("currentDate");	
		
	 int unitId = (Integer)map.get("unitId");
	 
	 String officersSingleE = (String)map.get("officersSingleE");
	 String officersSingleD = (String)map.get("officersSingleD");
	 String officersMarriedE = (String)map.get("officersMarriedE");
	 String officersMarriedD = (String)map.get("officersMarriedD");
	 	  
	 String airmenSingleE = (String)map.get("airmenSingleE");
	 String airmenSingleD = (String)map.get("airmenSingleD");
	 String airmenMarriedE = (String)map.get("airmenMarriedE");
	 String airmenMarriedD = (String)map.get("airmenMarriedD");
	 
	 String ncsSingleE = (String)map.get("ncsSingleE");
	 String ncsSingleD = (String)map.get("ncsSingleD");
	 String ncsMarriedE = (String)map.get("ncsMarriedE");
	 String ncsMarriedD = (String)map.get("ncsMarriedD");
	 
	 String dscSingleE = (String)map.get("dscSingleE");
	 String dscSingleD = (String)map.get("dscSingleD");
	 String dscMarriedE = (String)map.get("dscMarriedE");
	 String dscMarriedD = (String)map.get("dscMarriedD");
	 
	 String lightingArrangement = (String)map.get("lightingArrangement");
	 String ventilation = (String)map.get("ventilation");
	 String coolingArrangement = (String)map.get("coolingArrangement");
	 String heatingArrangement = (String)map.get("heatingArrangement");
	 String remarks = (String)map.get("remarks");
	 
	boolean succesfullyAdded = false;		
	try{
		org.hibernate.Session session = getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);	
		
		ShoAccommodation shoAccommodation = new ShoAccommodation();
		shoAccommodation.setHospital(masHospital);
		
		MasUnit masUnit = new MasUnit();
		masUnit.setId(unitId);	
		
		shoAccommodation.setUnit(masUnit);
		
		
		shoAccommodation.setCurrentDate(currentDate);
		
		shoAccommodation.setOfficerSingleE(officersSingleE);
		shoAccommodation.setOfficerSingleD(officersSingleD);
		shoAccommodation.setOfficerMarriedE(officersMarriedE);
		shoAccommodation.setOfficerMarriedD(officersMarriedD);
		
		shoAccommodation.setAirmenSingleE(airmenSingleE);
		shoAccommodation.setAirmenSingleD(airmenSingleD);
		shoAccommodation.setAirmenMarriedE(airmenMarriedE);
		shoAccommodation.setAirmenMarriedD(airmenMarriedD);
		
		shoAccommodation.setNcsSingleE(ncsSingleE);
		shoAccommodation.setNcsSingleD(ncsSingleD);
		shoAccommodation.setNcsMarriedE(ncsMarriedE);
		shoAccommodation.setNcsMarriedD(ncsMarriedD);
		
		shoAccommodation.setDscSingleE(dscSingleE);
		shoAccommodation.setDscSingleD(dscSingleD);
		shoAccommodation.setDscMarriedE(dscMarriedE);
		shoAccommodation.setDscMarriedD(dscMarriedD);
		
		shoAccommodation.setLightingArrangement(lightingArrangement);
		shoAccommodation.setVentilation(ventilation);
		shoAccommodation.setCoolingArrangement(coolingArrangement);
		shoAccommodation.setHeatingArrangement(heatingArrangement);
		shoAccommodation.setRemarks(remarks);
		
		hbt.save(shoAccommodation);
		hbt.refresh(shoAccommodation);
		
		succesfullyAdded = true;
		

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return succesfullyAdded ;
}

//----Submit Anti Filaria JSP

public boolean submitShoAntiFilariaJSP(Map map)
{ 

	 int hospitalId =(Integer)map.get("hospitalId");
	 
	 Date currentDate = (Date) map.get("currentDate");	
	 Date lastUpdatedDate = (Date) map.get("lastUpdatedDate");	
	
	 String flyProofing = (String)map.get("flyProofing");
	 String disposalOfRefuse = (String)map.get("disposalOfRefuse");
	 String frequencyOfInsecticide = (String)map.get("frequencyOfInsecticide");
	 
boolean succesfullyAdded = false;		

	try{
		org.hibernate.Session session = getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);	
		
		ShoAntiFilaria shoAntiFilaria = new ShoAntiFilaria();
		shoAntiFilaria.setHospital(masHospital);
		
		shoAntiFilaria.setCurrentDate(currentDate);
		shoAntiFilaria.setLastUpdatedDate(lastUpdatedDate);
		shoAntiFilaria.setFlyProofing(flyProofing);
		shoAntiFilaria.setDisposalOfRefuse(disposalOfRefuse);
		shoAntiFilaria.setFrequencyOfInsecticide(frequencyOfInsecticide);
		
		hbt.save(shoAntiFilaria);
		hbt.refresh(shoAntiFilaria);
		
		succesfullyAdded = true;
		

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return succesfullyAdded ;
}

@Override
public Map<String, Object> showShoAntiFilaria(Map<String, Object> dataMap) {
	
	
	Map<String,Object> map = new HashMap<String,Object>();
	
	int hospitalId=0;		
	List<ShoAntiFilaria> shoAntiFilariaList = new ArrayList<ShoAntiFilaria>();
	Session session = (Session) getSession();
	
	if(dataMap.get("hospitalId")!=null)
	{
		hospitalId=(Integer)dataMap.get("hospitalId");
	}
	
	try
	{
		shoAntiFilariaList = session.createCriteria(ShoAntiFilaria.class).add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	map.put("shoAntiFilariaList", shoAntiFilariaList);
	
	return map;
}

@Override
public Map<String, Object> showShoConservancy(Map<String, Object> dataMap) {
	
	Map<String,Object> map = new HashMap<String,Object>();
	
	int hospitalId=0;		
	List<ShoConservancy> shoConservancyList = new ArrayList<ShoConservancy>();
	Session session = (Session) getSession();
	
	if(dataMap.get("hospitalId")!=null)
	{
		hospitalId=(Integer)dataMap.get("hospitalId");
	}
	
	try
	{
		shoConservancyList = session.createCriteria(ShoConservancy.class).add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	map.put("shoConservancyList", shoConservancyList);
	
	return map;
}

@Override
public boolean submitShoConservancyJSP(Map<String, Object> map) {
	
	int hospitalId =(Integer)map.get("hospitalId");
	 
	 Date dateOfConservancy = (Date) map.get("dateOfConservancy");	
	 Date lastUpdatedDate = (Date) map.get("lastUpdatedDate");	
	 
	 String disposal = (String) map.get("disposal");
	 String methodOfDisposal = (String) map.get("methodOfDisposal");
	 String functioningAdequately = (String) map.get("functioningAdequately");
	 String reason = (String) map.get("reason");
	 String actionTaken = (String) map.get("actionTaken");
	 String disposalOfGarbage = (String) map.get("disposalOfGarbage");
	 
	 boolean succesfullyAdded = false;		
	 
	 try{
			org.hibernate.Session session = getSession();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);	
			
			ShoConservancy shoConservancy = new ShoConservancy();
			shoConservancy.setHospital(masHospital);
			
			shoConservancy.setDateOfConservancy(dateOfConservancy);
			shoConservancy.setLastUpdatedDate(lastUpdatedDate);
			shoConservancy.setDisposal(disposal);
			shoConservancy.setMethodOfDisposal(methodOfDisposal);
			shoConservancy.setFunctioningAdequately(functioningAdequately);
			shoConservancy.setReason(reason);
			shoConservancy.setAction(actionTaken);
			shoConservancy.setDisposalOfGarbage(disposalOfGarbage);
			
			hbt.save(shoConservancy);
			hbt.refresh(shoConservancy);
			
			succesfullyAdded = true;
			

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return succesfullyAdded ;
}

@Override
public Map<String, Object> showShoCatering(Map<String, Object> dataMap) {
	
	Map<String,Object> map = new HashMap<String,Object>();
	
	int hospitalId=0;		
	List<ShoCatering> shoCateringList = new ArrayList<ShoCatering>();
	Session session = (Session) getSession();
	
	if(dataMap.get("hospitalId")!=null)
	{
		hospitalId=(Integer)dataMap.get("hospitalId");
	}
	
	try
	{
		shoCateringList = session.createCriteria(ShoCatering.class).add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	map.put("shoCateringList", shoCateringList);
	
	return map;
}

@Override
public boolean submitShoCateringJSP(Map<String, Object> map) {
	
	 int hospitalId =(Integer)map.get("hospitalId");
	 Date currentDate =  (Date) map.get("currentDate");	
	 Date lastUpdatedDate = (Date) map.get("lastUpdatedDate");	
	 
	 String officerMess = (String) map.get("officerMess");
	 String sncoMess = (String) map.get("sncoMess");
	 String airmenMess = (String) map.get("airmenMess");
	 String flyProofing = (String) map.get("flyProofing");
	 String rationStore = (String) map.get("rationStore");
	
	 boolean succesfullyAdded = false;		
	 
	 try{
			org.hibernate.Session session = getSession();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);	
			
			ShoCatering shoCatering = new ShoCatering();
			shoCatering.setHospital(masHospital);
			
			shoCatering.setCurrentDate(currentDate);
			shoCatering.setLastUpdatedDate(lastUpdatedDate);
			shoCatering.setOfficerMess(officerMess);
			shoCatering.setSncoMess(sncoMess);
			shoCatering.setAirmenMess(airmenMess);
			shoCatering.setFlyProofing(flyProofing);
			shoCatering.setRationStore(rationStore);
			
			hbt.save(shoCatering);
			hbt.refresh(shoCatering);
			
			succesfullyAdded = true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return succesfullyAdded ;
}

@Override
public Map<String, Object> showSchoolHealth(Map<String, Object> dataMap) {
	
	Map<String,Object> map = new HashMap<String,Object>();
	
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	List<ShoSchoolHealth> shoSchoolHealthList = new ArrayList<ShoSchoolHealth>();
	
	int hospitalId=0;
	
	if(dataMap.get("hospitalId") !=null)
	{
		hospitalId=(Integer)dataMap.get("hospitalId");
	}
	
	Session session = (Session) getSession();
	
	try
	{
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();
		
		shoSchoolHealthList = session.createCriteria(ShoSchoolHealth.class).add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	map.put("unitList", unitList);
	map.put("shoSchoolHealthList", shoSchoolHealthList);
	
	return map;
	
}

@Override
public boolean submitSchoolHealthJsp(Map<String, Object> map) {
	
	int hospitalId =(Integer)map.get("hospitalId");
	int unitId = (Integer)map.get("unitId");
	 
	 Date schoolInspectionDate = (Date)map.get("schoolInspectionDate");
	 Date lastUpdatedDate = (Date)map.get("lastUpdatedDate");
		
	 String noOfChildren =  (String)map.get("noOfChildren");
	 String defectOfChildren =  (String)map.get("defectOfChildren");
	 String dentalCaries = (String)map.get("dentalCaries");
	 String refractiveError =  (String)map.get("refractiveError");
	 String anaemia =  (String)map.get("anaemia");
	 String waxEar = (String)map.get("waxEar");
	 String actionTaken =  (String)map.get("actionTaken");
	 
	 String bcgChildren = (String)map.get("bcgChildren");
	 String opvChildren = (String)map.get("opvChildren");
	 String dptChildren = (String)map.get("dptChildren");
	 String measlesChildren = (String)map.get("measlesChildren");
	 String dtChildren = (String)map.get("dtChildren");
	 String taChildren = (String)map.get("taChildren");
	 String ttChildren = (String)map.get("ttChildren");
	 String hepatitisChildren = (String)map.get("hepatitisChildren");
	 String pulsePolioChildren = (String)map.get("pulsePolioChildren");
	 
	 boolean succesfullyAdded = false;		
	 
	 try{
			org.hibernate.Session session = getSession();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			ShoSchoolHealth shoSchoolHealth = new ShoSchoolHealth();
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);	
			shoSchoolHealth.setHospital(masHospital);
			
			MasUnit masUnit = new MasUnit();
			masUnit.setId(unitId);	
			shoSchoolHealth.setUnit(masUnit);
						
			shoSchoolHealth.setSchoolInspectionDate(schoolInspectionDate);
			shoSchoolHealth.setLastUpdatedDate(lastUpdatedDate);
			shoSchoolHealth.setNoOfChildren(noOfChildren);
			shoSchoolHealth.setDefectOfChildren(defectOfChildren);
			shoSchoolHealth.setDentalCarried(dentalCaries);
			shoSchoolHealth.setRefractiveError(refractiveError);
			shoSchoolHealth.setAnaemia(anaemia);
			shoSchoolHealth.setWaxEar(waxEar);
			shoSchoolHealth.setActionTaken(actionTaken);
			
			shoSchoolHealth.setBcgChildren(bcgChildren);
			shoSchoolHealth.setOpvChildren(opvChildren);
			shoSchoolHealth.setDptChildren(dptChildren);
			shoSchoolHealth.setMeaslesChildren(measlesChildren);
			shoSchoolHealth.setDtChildren(dtChildren);
			shoSchoolHealth.setTaChildren(taChildren);
			shoSchoolHealth.setTtChildren(ttChildren);
			shoSchoolHealth.setHepatitisChildren(hepatitisChildren);
			shoSchoolHealth.setPulsePolioChildren(pulsePolioChildren);
			
			hbt.save(shoSchoolHealth);
			hbt.refresh(shoSchoolHealth);
			
			succesfullyAdded = true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return succesfullyAdded ;
}

//By Mansi on 13 may 2013


@Override
public Map<String, Object> showAdmissionDeath(Map<String, Object> dataMap) {

	Map<String, Object> map = new HashMap<String, Object>();
	List<MasIcd> masIcdList = new ArrayList<MasIcd>();
	List<MasRelation> masRelationList = new ArrayList<MasRelation>();
	List<ShoAdmissionDeath> shoAdmissionDeathList = new ArrayList<ShoAdmissionDeath>();
	Session session = (Session)getSession();

	int deptId = 0;
	if(dataMap.get("deptId") != null){
		deptId = (Integer)dataMap.get("deptId");
	}
	
	
	masIcdList = session.createCriteria(MasIcd.class).add(Restrictions.eq("Status", "y")).list();

	masRelationList=session.createCriteria(MasRelation.class).add(Restrictions.eq("Status", "y")).list();
	shoAdmissionDeathList =session.createCriteria(ShoAdmissionDeath.class).addOrder(Order.desc("Id")).setMaxResults(1).list();
	map.put("masIcdList", masIcdList);
	map.put("masRelationList", masRelationList);
	map.put("shoAdmissionDeathList", shoAdmissionDeathList);

	return map;

}

public Map<String, Object> submitAdmissionDeath(Box box,Map<String, Object> mapForDS) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<Integer> slNoList  = new ArrayList<Integer>();
	List<String> admissionDateList  = new ArrayList<String>();
	List<String> lastDateList  = new ArrayList<String>();
	List<String> diagnosisList  = new ArrayList<String>();
	List<String> categoryList  = new ArrayList<String>();
	List<Integer> relationList  = new ArrayList<Integer>();
	List<String> noOfAdmissionList  = new ArrayList<String>();
	List<String> noOfDeathList  = new ArrayList<String>();
	List<String> avgList  = new ArrayList<String>();
	List<String> rateList  = new ArrayList<String>();
	List<Integer> hospitalList  = new ArrayList<Integer>();
	
	String userName = (String) mapForDS.get("userName");
	Integer hiddenValue=(Integer) mapForDS.get("hiddenValue");
	if(mapForDS.get("admissionDateList")!=null){
		admissionDateList = (List<String>)mapForDS.get("admissionDateList");
	}
	if(mapForDS.get("slNoList")!=null){
		slNoList = (List<Integer>)mapForDS.get("slNoList");
	}
	if(mapForDS.get("lastDateList")!=null){
		lastDateList = (List<String>)mapForDS.get("lastDateList");
	}
	if(mapForDS.get("categoryList")!=null){
		categoryList = (List<String>)mapForDS.get("categoryList");
	}
	if(mapForDS.get("noOfAdmissionList")!=null){
		noOfAdmissionList = (List<String>)mapForDS.get("noOfAdmissionList");
	}
	if(mapForDS.get("avgList")!=null){
		avgList = (List<String>)mapForDS.get("avgList");
	}

	if(mapForDS.get("rateList")!=null){
		rateList = (List<String>)mapForDS.get("rateList");
	}
	if(mapForDS.get("noOfDeathList")!=null){
		noOfDeathList = (List<String>)mapForDS.get("noOfDeathList");
	}
	if(mapForDS.get("diagnosisList")!=null){
		diagnosisList = (List<String>)mapForDS.get("diagnosisList");
	}
	if(mapForDS.get("relationList")!=null){
		relationList = (List<Integer>)mapForDS.get("relationList");
	}
	if(mapForDS.get("hospitalList")!=null){
		hospitalList = (List<Integer>)mapForDS.get("hospitalList");
	}
	int hospitalId =(Integer)mapForDS.get("hospitalId");

	
	boolean succesfullyAdded = false;
	Transaction tx = null;
	Session session = (Session)getSession();


	try {
		tx = session.beginTransaction();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		int c = 0;
		
		for (int i=0; i<hiddenValue; i++) {
		
					ShoAdmissionDeath shoAdmissionDeath = new ShoAdmissionDeath();
				
					
				if (admissionDateList.get(i)!=null && !admissionDateList.get(i).equals("")) {
					shoAdmissionDeath.setAdmissionDate(HMSUtil.convertStringTypeDateToDateType(admissionDateList.get(i)));
					}
				if (lastDateList.get(i)!=null && !lastDateList.get(i).equals("")) {
					shoAdmissionDeath.setLastDate(HMSUtil.convertStringTypeDateToDateType(lastDateList.get(i)));
				}
				if (categoryList.get(i)!=null && !categoryList.get(i).equals("")) {
					shoAdmissionDeath.setCategory(categoryList.get(i));
				}
				if (noOfAdmissionList.get(i)!=null && !noOfAdmissionList.get(i).equals("")) {
					shoAdmissionDeath.setNoOfAd(noOfAdmissionList.get(i));
				}
				if (noOfDeathList.get(i)!=null && !noOfDeathList.get(i).equals("")) {
					shoAdmissionDeath.setNoOfD(noOfDeathList.get(i));
				}
					
				if (avgList.get(i)!=null && !avgList.get(i).equals("")) {
					shoAdmissionDeath.setAvg(avgList.get(i));
				}
					
				if (rateList.get(i)!=null && !rateList.get(i).equals("")) {
					shoAdmissionDeath.setRate(rateList.get(i));
				}
				
				if (slNoList.get(i)!=null && !slNoList.get(i).equals("")) {

					shoAdmissionDeath.setSlNo(slNoList.get(i));
				}
				
				

					
					if (diagnosisList.size() > 0) {
						String principalStr = "";
						principalStr = diagnosisList.get(i);
						int icdId = 0;
						if (!principalStr.equals("")) {
							
						}
										
						int index1 = principalStr.lastIndexOf("[");
						int index2 = principalStr.lastIndexOf("]");
				
						try {
							icdId = Integer.parseInt(principalStr
									.substring((index1 + 1), index2));
						} catch (NumberFormatException e) {

							e.printStackTrace();
						}
						
						if(icdId>0){ 
							MasIcd masIcd=new MasIcd();
							masIcd.setId(icdId);
							shoAdmissionDeath.setDiagnosis(masIcd); 
						}
					}
					if (relationList.get(i) != null && !relationList.get(i).equals("0")) {
						MasRelation masRelation = new MasRelation();
						masRelation.setId(relationList.get(i));
						shoAdmissionDeath.setRelation(masRelation);
						}
					/*if (hospitalList.get(i) != null && !hospitalList.get(i).equals("0")) {
						MasHospital masHospital = new MasHospital();
						masHospital.setId(hospitalList.get(i));
						shoAdmissionDeath.setHospital(masHospital);
						}*/
					if (hospitalId != 0) {
						MasHospital hospital = new MasHospital();
						hospital.setId(hospitalId);
						shoAdmissionDeath.setHospital(hospital);
					}
					
				hbt.save(shoAdmissionDeath);
				hbt.refresh(shoAdmissionDeath);
				
				succesfullyAdded = true;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
	
	map.put("succesfullyAdded", succesfullyAdded);
	return map;
}


@Override
public Map<String, Object> showOfficerDetails(Map<String, Object> dataMap) 
{
	Map<String, Object> map = new HashMap<String, Object>();

	List<ShoOfficerDetails> shoOfficerDetailsList = new ArrayList<ShoOfficerDetails>();
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	Session session = (Session)getSession();
	
	int hospitalId=0;
	
	if(dataMap.get("hospitalId") !=null)
	{
		hospitalId=(Integer)dataMap.get("hospitalId");
	}
	
	try
	{
		unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y")).list();
		shoOfficerDetailsList = session.createCriteria(ShoOfficerDetails.class).add(Restrictions.eq("Hospital.Id", hospitalId) ).addOrder(Order.desc("Id")).setMaxResults(1).list();
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	
	map.put("unitList", unitList);
	map.put("shoOfficerDetailsList", shoOfficerDetailsList);

	return map;
}

@Override
public boolean submitLadyOfficerJsp(Map<String, Object> map)
{
	int hospitalId =(Integer)map.get("hospitalId");
	int unitId = (Integer)map.get("unitId");
	 
	 Date currentDate = (Date)map.get("currentDate");
	 Date lastUpdatedDate = (Date)map.get("lastUpdatedDate");
		
	 String officerCataract = (String)map.get("officerCataract");
	 String officerGlaucoma = (String)map.get("officerGlaucoma");
	 String airmenCataract = (String)map.get("airmenCataract");
	 String airmenGlaucoma = (String)map.get("airmenGlaucoma");
	 String familyCataract = (String)map.get("familyCataract");
	 String familyGlaucoma = (String)map.get("familyGlaucoma");
	 String servicemenCataract = (String)map.get("servicemenCataract");
	 String servicemenGlaucoma = (String)map.get("servicemenGlaucoma");
	 String multiBacillary = (String)map.get("multiBacillary");
	 String pauciBacillary = (String)map.get("pauciBacillary");
	 String hepatitisViral = (String)map.get("hepatitisViral");
	 String otherViral = (String)map.get("otherViral");
	 String noOfDogBite = (String)map.get("noOfDogBite");
	 String totalDoses = (String)map.get("totalDoses");
	 
	 boolean succesfullyAdded = false;		
	 
	 try{
			org.hibernate.Session session = getSession();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			ShoOfficerDetails shoOfficerDetails = new ShoOfficerDetails();
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);	
			shoOfficerDetails.setHospital(masHospital);
			
			MasUnit masUnit = new MasUnit();
			masUnit.setId(unitId);	
			shoOfficerDetails.setUnit(masUnit);
				
			shoOfficerDetails.setCurrentDate(currentDate);
			shoOfficerDetails.setLastUpdatedDate(lastUpdatedDate);
			
			shoOfficerDetails.setOfficerCataract(officerCataract);
			shoOfficerDetails.setOfficerGlaucoma(officerGlaucoma);
			shoOfficerDetails.setAirmenCataract(airmenCataract);
			shoOfficerDetails.setAirmenGlaucoma(airmenGlaucoma);
			shoOfficerDetails.setFamilyCataract(familyCataract);
			shoOfficerDetails.setFamilyGlaucoma(familyGlaucoma);
			shoOfficerDetails.setServicemenCataract(servicemenCataract);
			shoOfficerDetails.setServicemenGlaucoma(servicemenGlaucoma);
			shoOfficerDetails.setMultiBacillary(multiBacillary);
			shoOfficerDetails.setPauciBacillary(pauciBacillary);
			shoOfficerDetails.setHepatitisViral(hepatitisViral);
			shoOfficerDetails.setOtherViral(otherViral);
			shoOfficerDetails.setNoOfDogBite(noOfDogBite);
			shoOfficerDetails.setTotalDoses(totalDoses);
			
			hbt.save(shoOfficerDetails);
			hbt.refresh(shoOfficerDetails);
			
			succesfullyAdded = true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return succesfullyAdded ;
}

@Override
public Map<String, Object> showIndustrialDisease(Map<String, Object> dataMap) {
	Map<String, Object> map = new HashMap<String, Object>();

	List<ShoIndustrialDisease> shoIndustrialDiseaseList = new ArrayList<ShoIndustrialDisease>();
	Session session = (Session)getSession();
	
	int hospitalId=0;
	
	if(dataMap.get("hospitalId") !=null)
	{
		hospitalId=(Integer)dataMap.get("hospitalId");
	}
	
	try
	{
		shoIndustrialDiseaseList = session.createCriteria(ShoIndustrialDisease.class).add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	
	map.put("shoIndustrialDiseaseList", shoIndustrialDiseaseList);

	return map;
}

@Override
public boolean submitShoIndustrialDisease(Map<String, Object> map) 
{
	 int hospitalId =(Integer)map.get("hospitalId");
		 
	 Date currentDate = (Date)map.get("currentDate");
	 Date lastUpdatedDate = (Date)map.get("lastUpdatedDate");
		
	 String particuler = (String)map.get("particuler");
	 String noOfCases = (String)map.get("noOfCases");
	 String action = (String)map.get("action");
	 String recreation = (String)map.get("recreation");
	 String moral = (String)map.get("moral");
	 	 
	 boolean succesfullyAdded = false;		
	 
	 try{
			org.hibernate.Session session = getSession();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			ShoIndustrialDisease shoIndustrialDisease = new ShoIndustrialDisease();
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);	
			shoIndustrialDisease.setHospital(masHospital);
			
			shoIndustrialDisease.setCurrentDate(currentDate);
			shoIndustrialDisease.setLastUpdatedDate(lastUpdatedDate);
			
			shoIndustrialDisease.setParticular(particuler);
			shoIndustrialDisease.setNoOfCases(noOfCases);
			shoIndustrialDisease.setAction(action);
			shoIndustrialDisease.setRecreation(recreation);
			shoIndustrialDisease.setMoral(moral);
						
			hbt.save(shoIndustrialDisease);
			hbt.refresh(shoIndustrialDisease);
			
			succesfullyAdded = true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return succesfullyAdded ;
}


@Override
public Map<String, Object> showFamilyWelfareActivities(
		Map<String, Object> dataMap) {


	Map<String, Object> map = new HashMap<String, Object>();
	List<ShoFamilyWelfareActivities> shoFamilyWelfareActivitiesList = new ArrayList<ShoFamilyWelfareActivities>();
	Session session = (Session)getSession();

	shoFamilyWelfareActivitiesList =session.createCriteria(ShoFamilyWelfareActivities.class).addOrder(Order.desc("Id")).setMaxResults(1).add(Restrictions.eq("Status", "y")).list();

	map.put("shoFamilyWelfareActivitiesList",shoFamilyWelfareActivitiesList);

	return map;


}

@Override
public Map<String, Object> submitFamilyWelfareActivities(Box box,
		Map<String, Object> mapForDS) {
	 Map<String, Object> map = new HashMap<String, Object>();
	 int hospitalId =(Integer)mapForDS.get("hospitalId");
	 
	String changedBy = (String) mapForDS.get("changedBy");
	String changedDate = (String) mapForDS.get("changedDate");
	String changedTime = (String) mapForDS.get("changedTime");
	 boolean succesfullyAdded = false;		
	 
	 try{
			org.hibernate.Session session = getSession();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			ShoFamilyWelfareActivities shoFamilyWelfareActivities = new ShoFamilyWelfareActivities();
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);	
			shoFamilyWelfareActivities.setHospital(masHospital);
			
			shoFamilyWelfareActivities.setWelFareDate(HMSUtil.convertStringTypeDateToDateType(box.getString("welFareDate")));
			
			shoFamilyWelfareActivities.setLastDate(HMSUtil.convertStringTypeDateToDateType(box.getString("lastDate")));
	
			shoFamilyWelfareActivities.setTSterilzation(box.getString("tSterilzation"));
			shoFamilyWelfareActivities.setTIuds(box.getString("tIuds"));
			shoFamilyWelfareActivities.setTCc(box.getString("tCc"));
			shoFamilyWelfareActivities.setTOralPills(box.getString("tOralPills"));
			
			shoFamilyWelfareActivities.setASterilzation(box.getString("aSterilzation"));
			shoFamilyWelfareActivities.setAIuds(box.getString("aIuds"));
			shoFamilyWelfareActivities.setACc(box.getString("aCc"));
			shoFamilyWelfareActivities.setAOralPills(box.getString("aOralPills"));
			
			shoFamilyWelfareActivities.setDoorVisits(box.getString("doorVisits"));
			shoFamilyWelfareActivities.setDVRemarks(box.getString("dVRemarks"));
			
			shoFamilyWelfareActivities.setHealthTalks(box.getString("healthTalks"));
			shoFamilyWelfareActivities.setHTRemarks(box.getString("hTRemarks"));
			
			shoFamilyWelfareActivities.setNationalPulse(box.getString("nationalPulse"));
			shoFamilyWelfareActivities.setNPRemarks(box.getString("nPRemarks"));
			
			shoFamilyWelfareActivities.setTotalPopulation(box.getString("totalPopulation"));
			
			shoFamilyWelfareActivities.setStatus("y");
			shoFamilyWelfareActivities.setLastChgBy(changedBy);
			shoFamilyWelfareActivities.setLastChgTime(changedTime);
			shoFamilyWelfareActivities.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(changedDate));
						
			hbt.save(shoFamilyWelfareActivities);
			hbt.refresh(shoFamilyWelfareActivities);
			
			succesfullyAdded = true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		map.put("succesfullyAdded", succesfullyAdded);
		return map;
}


@Override
public Map<String, Object> showWorkService(Map<String, Object> dataMap) {
	Map<String, Object> map = new HashMap<String, Object>();
	List<ShoWorkService> shoWorkServiceList = new ArrayList<ShoWorkService>();
	Session session = (Session)getSession();	
	int hospitalId=0;
	
	if(dataMap.get("hospitalId") !=null)
	{
		hospitalId=(Integer)dataMap.get("hospitalId");
	}
	
	try
	{
		shoWorkServiceList = session.createCriteria(ShoWorkService.class).add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	
	map.put("shoWorkServiceList", shoWorkServiceList);

	return map;
}

@Override
public boolean submitWorkService(Map<String, Object> map) {

		 int hospitalId =(Integer)map.get("hospitalId");
			 
		 Date currentDate = (Date)map.get("currentDate");
		 Date lastUpdatedDate = (Date)map.get("lastUpdatedDate");
			
		 String nursingStaff = (String)map.get("nursingStaff");
		 String nursingStaffRemarks = (String)map.get("nursingStaffRemarks");
		 
		 String specialistCover = (String)map.get("specialistCover");
		 String specialistCoverRemarks = (String)map.get("specialistCoverRemarks");
		 
		 String medicalStore = (String)map.get("medicalStore");
		 String medicalStoreRemarks =(String)map.get("medicalStoreRemarks");
		
		 String hygineChemical = (String)map.get("hygineChemical");
		 String hygineChemicalRemarks = (String)map.get("hygineChemicalRemarks");

		 String dentalCarries = (String)map.get("dentalCarries");
		 String dentalCarriesRemarks = (String)map.get("dentalCarriesRemarks");
		 
		 boolean succesfullyAdded = false;		
		 
		 try{
				org.hibernate.Session session = getSession();
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				
				ShoWorkService shoWorkService = new ShoWorkService();
				
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);	
				shoWorkService.setHospital(masHospital);
				
				shoWorkService.setCurrentDate(currentDate);
				shoWorkService.setLastUpdatedDate(lastUpdatedDate);
				
				shoWorkService.setNursingStaff(nursingStaff);
				shoWorkService.setNursingStaffRemarks(nursingStaffRemarks);
				
				shoWorkService.setSpecialistCover(specialistCover);
				shoWorkService.setSpecialistCoverRemarks(specialistCoverRemarks);
				
				shoWorkService.setMedicalStore(medicalStore);
				shoWorkService.setMedicalStoreRemarks(medicalStoreRemarks);
				
				shoWorkService.setHygineChemical(hygineChemical);
				shoWorkService.setHygineChemicalRemarks(hygineChemicalRemarks);
				
				shoWorkService.setDentalCaries(dentalCarries);
				shoWorkService.setDentalCariesRemarks(dentalCarriesRemarks);
				
				hbt.save(shoWorkService);
				hbt.refresh(shoWorkService);
				
				succesfullyAdded = true;
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return succesfullyAdded ;

}

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


@Override
public Map<String, Object> fillAVServiceDetail(Map<String, Object> dataMap) {
	Session session = (Session) getSession();
	Map<String, Object> map = new HashMap<String, Object>();
	List<Patient> patientList = new ArrayList<Patient>();
	@SuppressWarnings("unused")
	int deptId = 0;
	try {
		String str = "" + dataMap.get("serviceNo");
		Criteria c = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", str)).createAlias("Relation", "rel").add(Restrictions.eq("rel.RelationName", "Self"));
		patientList = c.list();
		map.put("patientList", patientList);
	} catch (Exception e) {
		e.printStackTrace();
	}

return map;}

}
