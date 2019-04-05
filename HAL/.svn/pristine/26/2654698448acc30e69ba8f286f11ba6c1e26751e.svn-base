package jkt.hms.mis.controller;


/**
 * @author Priyanka Garg
 * 
 */

import static jkt.hms.util.RequestConstants.*;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;

import jkt.hms.masters.business.Birthdeathreg;
import jkt.hms.masters.business.Category;
import jkt.hms.masters.business.EmpAfmsfDet;
import jkt.hms.masters.business.ExpiryDetails;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasImmunization;
import jkt.hms.masters.business.ShoMonthlyWorkLoad;
import jkt.hms.masters.business.MasMedicalExamFamilyHis;
import jkt.hms.masters.business.MasMedicalUploadDocument;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.ShoBreakDown;
import jkt.hms.masters.business.MisFrw;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.ShoBiomedicalWaste;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.mis.handler.MISHandlerService;
import jkt.hms.stores.handler.StoresHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.poi.util.SystemOutLogger;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MISController extends MultiActionController {

	MISHandlerService misHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> map = new HashMap<String, Object>();
	StoresHandlerService storesHandlerService = null;
	HttpSession session = null;
	String jsp = "";
	String title = "";
	String url = "";
	String message = "";
	String currentTime = "";

	// -------------------- ED Returns Form -----------------
	public StoresHandlerService getStoresHandlerService() {
		return storesHandlerService;
	}

	public void setStoresHandlerService(
			StoresHandlerService storesHandlerService) {
		this.storesHandlerService = storesHandlerService;
	}

	public ModelAndView showEDReturnsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		@SuppressWarnings("unused")
		Date edDate = null;
		int hospitalId = 0;
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
			System.out.println("hospitalId in MIS Controller"+hospitalId);
		}
		/*else if(session.getAttribute("hospitalId")!=null){
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}*/
		map = misHandlerService.showEDReturnsJsp();

		jsp = EDRETURNS_JSP;
		jsp += ".jsp";
		title = "EDReturnForm";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showEDReturns(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// session = request.getSession();
		String toDate = null;
		String fromDate = null;
		//String category = null;
		String edStatus = null;
		int hospitalId = 0;
		int category = 0;
		try {
			if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
				hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
			}else{
				hospitalId = (Integer)session.getAttribute("hospitalId");
			}
			if (request.getParameter("toDate") != null
					&& !(request.getParameter("toDate").equals(""))) {
				toDate = request.getParameter("toDate");
			}
			if (request.getParameter("fromDate") != null
					&& !(request.getParameter("fromDate").equals(""))) {
				fromDate = (request.getParameter("fromDate"));
			}
			if (request.getParameter("category") != null
					&& !(request.getParameter("category").equals("0"))) {
				category =Integer.parseInt(request.getParameter("category"));
			}
			/*if (request.getParameter("category") != null
					&& !(request.getParameter("category").equals(""))) {
				category = request.getParameter("category");
			}*/
			/*
			 * if (request.getParameter("edStatus") != null &&
			 * !(request.getParameter("edStatus").equals(""))) { edStatus =
			 * request.getParameter("edStatus"); } else { edStatus="n"; }
			 */
		//	edStatus = "n";
			dataMap.put("fromDate",fromDate);
			dataMap.put("toDate",toDate);
			dataMap.put("category",category);
			dataMap.put("hospitalId",hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.showEDReturns(dataMap);
		jsp = EDRETURNS_DETAILS_JSP;
		map.put("title", title);
		map.put("toDate", HMSUtil.convertStringTypeDateToDateType(toDate));
		map.put("fromDate", HMSUtil.convertStringTypeDateToDateType(fromDate));
		map.put("category", category);
		map.put("edStatus", edStatus);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView editEDReturns(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		/*
		 * Date currentDate = new Date(); int visitId = 0; int edDays = 0;
		 * String dispose = null;
		 * 
		 * String edDate = null; Date toDate = null; Date fromDate = null; Date
		 * edDate1 = new Date(); Date edDate2 = new Date(); Date edDate3 = new
		 * Date(); Date ldDate = new Date(); String category = null; String ed =
		 * null; String ld = null; String diagnosis = ""; int ldDays = 0;
		 * 
		 * Date edDateTemp = new Date(); if (request.getParameter("visitId") !=
		 * null && !(request.getParameter("visitId").equals(""))) { visitId =
		 * Integer.parseInt(request.getParameter("visitId")); }
		 * 
		 * if (request.getParameter("edDays") != null &&
		 * !(request.getParameter("edDays").equals(""))) { edDays =
		 * Integer.parseInt(request.getParameter("edDays")); } if
		 * (request.getParameter("edDate") != null &&
		 * !(request.getParameter("edDate").equals(""))) { edDateTemp =
		 * HMSUtil.convertStringTypeDateToDateType(request
		 * .getParameter("edDate")); } if (request.getParameter("edDispose") !=
		 * null && !(request.getParameter("edDispose").equals(""))) { dispose =
		 * request.getParameter("edDispose"); } if
		 * (request.getParameter("edDate1") != null &&
		 * !(request.getParameter("edDate1").equals(""))) { edDate1 =
		 * HMSUtil.convertStringTypeDateToDateType(request
		 * .getParameter("edDate1")); } if (request.getParameter("edDate2") !=
		 * null && !(request.getParameter("edDate2").equals(""))) { edDate2 =
		 * HMSUtil.convertStringTypeDateToDateType(request
		 * .getParameter("edDate2")); } if (request.getParameter("edDate3") !=
		 * null && !(request.getParameter("edDate3").equals(""))) { edDate3 =
		 * HMSUtil.convertStringTypeDateToDateType(request
		 * .getParameter("edDate3")); }
		 * 
		 * if (request.getParameter(DIAGNOSIS_ID) != null &&
		 * !(request.getParameter(DIAGNOSIS_ID).equals(""))) { diagnosis =
		 * request.getParameter(DIAGNOSIS_ID); } if
		 * (request.getParameter("title") != null) { title =
		 * request.getParameter("title"); } if (request.getParameter(ED) != null
		 * && !(request.getParameter(ED).equals(""))) { ed =
		 * request.getParameter(ED); }
		 * 
		 * generalMap.put("id", visitId); generalMap.put("edDate", edDateTemp);
		 * generalMap.put("edDays", new Integer(edDays));
		 * generalMap.put("dispose", dispose); generalMap.put("edStatus", "y");
		 * generalMap.put("edDate1", edDate1); generalMap.put("edDate2",
		 * edDate2); generalMap.put("edDate3", edDate3);
		 * generalMap.put("diagnosis", diagnosis);
		 */
		boolean dataUpdated = false;

		dataUpdated = misHandlerService.editEDReturnsToDatabase(box);

		if (dataUpdated == true) {
			message = "Data updated Successfully";

		} else {
			message = "Data Cant be updated";

		}
		map.put("message", message);
		url = "/hms/hms/mis?method=showEDReturnsJsp";

		try {
			map = misHandlerService.showEDReturnsJsp();

		} catch (Exception e) {

		}
		jsp = EDRETURNS_JSP;

		title = "update ED Returns";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("indexB", "map", map);

	}

	// ----------------------------- ED Reports Form
	// --------------------------------
	public ModelAndView showEDreportsjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = misHandlerService.showEDreportsjsp();
		jsp = EDREPORT_JSP;
		jsp += ".jsp";
		title = "edReport";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showEDreports(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Date toDate = new Date();
		Date fromDate = new Date();
		String query = "";
		int service_type_id = 0;
		String dispose = "";
		String rankCategory = "";
		session = request.getSession();
		List<MasRankCategory> masRankCategoryList = new ArrayList<MasRankCategory>();
		map = misHandlerService.showEDreports(map);
		masRankCategoryList = (List<MasRankCategory>) map
				.get("masRankCategoryList");
		int hospitalId = 0;
		String hospitalName = "";
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			}
			String qry = "";
			
			
			try {
				if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("") && !request.getParameter("cmdId").equals("0") && request.getParameter("hospitalId")!=null && request.getParameter("hospitalId").equals("0") && request.getParameter("hospitalId").equals("")){
					
					query += "  and h.command_id="+Integer.parseInt(request.getParameter("cmdId"));
				}else{
					if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("") && !request.getParameter("hospitalId").equals("0")){
						hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
					}else{
						hospitalId = (Integer)session.getAttribute("hospitalId");
					}
					query += "  and opd.hospital_id="+hospitalId;
					
					
				}

				hospitalName = misHandlerService.getHospitalName(hospitalId);
				
				if (request.getParameter(CATEGORY_ID) != null
						&& !(request.getParameter(CATEGORY_ID).equals("0"))) {
					int category_id = Integer.parseInt(request
							.getParameter(CATEGORY_ID));
					query += " and mrc.rank_category_id="
							+ category_id;
					map.put("query", query);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Box box = HMSUtil.getBox(request);
		Map<String, Object> dmap = new HashMap<String, Object>();

		dmap = misHandlerService.updateDiagnosis(box);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("query", query);
	//	map.put("hospital_id", hospitalId);
		//map.put("HOS_NAME", hospitalName);
		HMSUtil.generateReport("ed_Return_Reprt", map, (Connection) map.get("conn"),
				response, getServletContext());
		return null;
	}

	// ----------------------------- Patient Movement Order Reports Form
	// --------------------------------
	public ModelAndView showPatientMovementOrderjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = misHandlerService.showPatientMovementOrderjsp();
		jsp = PATIENTMOVEMENTORDER_JSP;
		jsp += ".jsp";
		title = "patientMovementOrder";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView printNotifiableDisease(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
 	    Map<String, Object> map = new HashMap<String, Object>();
 	    int notifiableId = 0;
 	    if(request.getParameter("notifiableId")!= null)
 	    {
 	    	notifiableId =Integer.parseInt( request.getParameter("notifiableId"));
 	    }
 	    
 	     map= misHandlerService.getConnectionForReport();
 	    Map<String, Object> parameters = new HashMap<String, Object>();
 	     parameters.put("notifiableId", notifiableId);
 	    //parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports"));
 	     HMSUtil.generateReport("NotifiableDisease", parameters,(Connection)map.get("conn"),response,getServletContext());
 	     return null;
	}
	public ModelAndView printMonitoryofAds(HttpServletRequest request,HttpServletResponse response)
	 { session = request.getSession();
	   Map<String,Object> map = new HashMap<String,Object>();
	   int hin_id =0;
	   if(request.getParameter("hinId")!= null)
	    {
	      hin_id =Integer.parseInt( request.getParameter("hinId"));	      
	    }	    
	     map= misHandlerService.getConnectionForReport();
	    Map<String, Object> parameters = new HashMap<String, Object>();
	      parameters.put("hin_id", hin_id);
	      parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports"));
	      HMSUtil.generateReport("Monitoring_Of_Ads_Cases", parameters, (Connection)map.get("conn"), response, getServletContext());
	    return null;
	 }
	public ModelAndView printMentalPhysicalRetarded(HttpServletRequest request, HttpServletResponse response)
	  {  session = request.getSession();
	    Map<String,Object> map = new HashMap<String,Object>();
	  int hin_id =0;
	  if(request.getParameter("hinId")!= null)
	    {
	      hin_id =Integer.parseInt( request.getParameter("hinId"));
	      
	    }	    
	     map= misHandlerService.getConnectionForReport();
	    Map<String, Object> parameters = new HashMap<String, Object>();
	      parameters.put("hin_id", hin_id);
	      parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports"));
	      HMSUtil.generateReport("Mental_Physical_Retarted", parameters, (Connection)map.get("conn"), response, getServletContext());
		 
	  
	      return null;
	  }
	public ModelAndView printForSchoolInspection(HttpServletRequest request,HttpServletResponse response)
	 { session = request.getSession();
	  Map<String,Object> map = new HashMap<String,Object>();
	  String school_name = "";
	  if(request.getParameter("nameofSchool")!= null)
	   {
		 school_name = request.getParameter("nameofSchool");     
	   }
		map =  misHandlerService.getConnectionForReport();
		Map<String,Object>  parameters = new HashMap<String,Object>();
		parameters.put("school_name", school_name);
		parameters.put("SUBREPORT_DIR",getServletContext().getRealPath("/reports"));
		HMSUtil.generateReport("SchoolInspectionEntry", parameters, (Connection)map.get("conn"), response, getServletContext());
		return null;
	 }
	public ModelAndView printNutritionExamination(HttpServletRequest request,HttpServletResponse response)
	 {  session = request.getSession();
	    Map<String,Object> map = new HashMap<String,Object>();
	    map = misHandlerService.getConnectionForReport();
	    Map<String,Object> parameters = new HashMap<String,Object>();
	    
		return null;
	 }
	public ModelAndView printAutomaticChloroformEntry(HttpServletRequest request,HttpServletResponse response)
	 {
		Map<String,Object> map = new HashMap<String,Object>();
		map = misHandlerService.getConnectionForReport();
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports"));
		HMSUtil.generateReport("AutomaticChloronomes", parameters, (Connection)map.get("conn"), response, getServletContext());
		return null;
	 }

	public ModelAndView printPreventableDisease(HttpServletRequest request,HttpServletResponse response)
	{   
		session = request.getSession();
	    
 	    Map<String, Object> map = new HashMap<String, Object>();
 	 	   
 	    map= misHandlerService.getConnectionForReport();
 	    Map<String, Object> parameters = new HashMap<String, Object>();
 	    
 	    parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports"));
 	    HMSUtil.generateReport("IncidenceOfPreventable", parameters,(Connection)map.get("conn"),response,getServletContext());
 	    return null;
		
	}
	public ModelAndView printMonthlyWorkloadReport(HttpServletRequest request,HttpServletResponse response)
	{   session = request.getSession();
	    Date from_date = null;
	    Date to_date = null;
	    if(request.getParameter(FROM_DATE) != null)
	    {
	     from_date = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
	     
      	}
	   if(request.getParameter(TO_DATE) != null)
	   {
	     to_date = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
	    
	    }
 	    Map<String, Object> map = new HashMap<String, Object>();
 	   // int hin_id=Integer.parseInt( request.getParameter("hinId"));
 	   
 	     map= misHandlerService.getConnectionForReport();
 	    Map<String, Object> parameters = new HashMap<String, Object>();
 	     //parameters.put("hin_id", hin_id);
 	     //parameters.put("from_date", from_date);
 	   // parameters.put("to_date",to_date);
 	    parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports"));
 	     HMSUtil.generateReport("Workload_Of_Monthly", parameters,(Connection)map.get("conn"),response,getServletContext());
 	     return null;
		
	}
	
	
	
	
	public  ModelAndView printSroEntry(HttpServletRequest request, HttpServletResponse response)
	  {  session = request.getSession();
	     int departmentId= 0;
	     departmentId = Integer.parseInt(""+session.getAttribute("deptId")); 
		Map<String, Object> map = new HashMap<String,Object>();
		map = misHandlerService.getConnectionForReport();
		Map<String,Object> parameters = new HashMap<String,Object>();
		   parameters.put("departmentId", departmentId);
		   parameters.put("SUBREPORT_DIR",getServletContext().getRealPath("/reports"));
		   HMSUtil.generateReport("SroEntry", parameters, (Connection)map.get("conn"), response, getServletContext());
		return null;
	  }
	public ModelAndView printActivityDetail(HttpServletRequest request,HttpServletResponse response)
	  {   session = request.getSession();
	       Date activityDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("activityDate"));
	      Map<String,Object>  map = new HashMap<String,Object>();
 		  map = misHandlerService.getConnectionForReport();
 		  Map<String,Object>  parameters = new HashMap<String,Object>();
 		  parameters.put("activityDate", activityDate);
 		  parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports"));
 		  HMSUtil.generateReport("ActivityDetail", parameters, (Connection)map.get("conn"), response,getServletContext());
 		  return null;
	  }
	public ModelAndView printFRW(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String frwDate = null;
		session = request.getSession();

		try {
			frwDate = request.getParameter(FROM_DATE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			String hospitalName = storesHandlerService
					.getHospitalName(hospitalId);
			
			map.put("HOS_NAME", hospitalName);
		}

		map.put("date", frwDate);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		HMSUtil.generateReport("frw_sick_report", map, (Connection) map
				.get("conn"), response, getServletContext());

		return null;
	}

	// ------------------- Afmsf-1 Def ---------------------------

	public ModelAndView showAfmsfDefjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//map = misHandlerService.showAfmsfDefjsp();
		jsp = AFMSFDEF_JSP;
		jsp += ".jsp";
		title = "Deficient Afmsf-1";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showAfmsfDef(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = null;

		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		map.put("serviceNo", serviceNo);
		map = misHandlerService.showAfmsfDef(map);
		jsp = AFMSFDEF_JSP;
		jsp += ".jsp";
		title = "Deficient Afmsf-1";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editAfmsfDef(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> testMap = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId = 0;
		String currentDate = null;
		//String currentDatetoStr = null;
		int rankId = 0;
		int empId = 0;
		int tradeId = 0;
		int medicalcategory = 0;
		String letterNo = "";
		String disletterNo = "";
		String remarks = "";
		String disRemarks = "";
		//String suffix = "";
		String serviceNo = null;
		String changedBy = "";
		//int presentUnit = 0;
		String employeeName = null;
		Date receiptDate = null;
		Date dispatchDate = null;
		Date nextreviewDate = null;
		String status = "";
		String datePostingIn = null;
		String datePostingOut = null;
		String diagnosis = null;
		String lastName = null;
		String unitName = null;
		//String unitAddress = null;
		//String localUnit = null;
		String presentUnit = null ;
		int bloodGroupId = 0;

		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));

		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
			empId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			
		}
		if (request.getParameter(RECEIPTDATE) != null
				&& !(request.getParameter(RECEIPTDATE).equals(""))) {
			receiptDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(RECEIPTDATE));
			
		}

		if (request.getParameter(DISPATCHDATE) != null
				&& !(request.getParameter(DISPATCHDATE).equals(""))) {
			dispatchDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DISPATCHDATE));
			
		}
		if (request.getParameter(NEXT_REVIEW_DATE) != null
				&& !(request.getParameter(NEXT_REVIEW_DATE).equals(""))) {
			nextreviewDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(NEXT_REVIEW_DATE));
			
		}

		if (request.getParameter(EMPLOYEE_FIRST_NAME) != null
				&& !(request.getParameter(EMPLOYEE_FIRST_NAME).equals(""))) {
			employeeName = request.getParameter(EMPLOYEE_FIRST_NAME);
			
		}
		if (request.getParameter(EMPLOYEE_LAST_NAME) != null
				&& !(request.getParameter(EMPLOYEE_LAST_NAME).equals(""))) {
			lastName = request.getParameter(EMPLOYEE_LAST_NAME);
			
		}

		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals(""))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			
		}

		/*if (request.getParameter(PRESENT_UNIT) != null
				&& !(request.getParameter(PRESENT_UNIT).equals(""))) {
			presentUnit = Integer.parseInt(request.getParameter(PRESENT_UNIT));
			
		}*/

		if (request.getParameter(RECEIPT_LETTER_NO) != null
				&& !(request.getParameter(RECEIPT_LETTER_NO).equals(""))) {
			letterNo = request.getParameter(RECEIPT_LETTER_NO);
			
		}
		if (request.getParameter(DISPATCH_LETTER_NO) != null
				&& !(request.getParameter(DISPATCH_LETTER_NO).equals(""))) {
			disletterNo = request.getParameter(DISPATCH_LETTER_NO);
			
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
			
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = request.getParameter(CHANGED_DATE);
			
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			
		}
		if (request.getParameter("status") != null
				&& !(request.getParameter("status").equals(""))) {
			status = request.getParameter("status");
			
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
			
		}

		if (request.getParameter(DIS_REMARKS) != null) {
			disRemarks = request.getParameter(DIS_REMARKS);
			
		}

		if (request.getParameter(TRADE) != null
				&& !(request.getParameter(TRADE).equals(""))) {
			tradeId = Integer.parseInt(request.getParameter(TRADE));
			
		}

		if (request.getParameter(MEDICAL_CATEGORY) != null
				&& !(request.getParameter(MEDICAL_CATEGORY).equals(""))) {
			medicalcategory = Integer.parseInt(request
					.getParameter(MEDICAL_CATEGORY));
			
		}

		if (request.getParameter(POST_IN_DATE) != null
				&& !(request.getParameter(POST_IN_DATE).equals(""))) {
			datePostingIn = request.getParameter(POST_IN_DATE);
			
		}
		if (request.getParameter(DATE_OF_POSTING) != null
				&& !(request.getParameter(DATE_OF_POSTING).equals(""))) {
			datePostingIn = request.getParameter(DATE_OF_POSTING);
			
		}

		if (request.getParameter(POST_OUT_DATE) != null
				&& !(request.getParameter(POST_OUT_DATE).equals(""))) {
			datePostingOut = request.getParameter(POST_OUT_DATE);
			
		}

		if (request.getParameter(DIAGNOSIS) != null) {
			diagnosis = request.getParameter(DIAGNOSIS);
			
		}
		
		if (request.getParameter("bloodGroupId") != null
				&& !(request.getParameter("bloodGroupId").equals(""))) {
			bloodGroupId = Integer.parseInt(request
					.getParameter("bloodGroupId"));
			
		}
		/*
		 * if (request.getParameter(RADIO_FOR_TABLE) != null &&
		 * !(request.getParameter(RADIO_FOR_TABLE).equals(""))) { status =
		 * request.getParameter(RADIO_FOR_TABLE); }
		 */
		@SuppressWarnings("unused")
		String postedFromId = null;
		@SuppressWarnings("unused")
		String postedToId = null;
		String auth = "";
		String authpostingOut = "";
		int empAfmsId = 0;
		String docStatus = "";
		if (request.getParameter(PRESENT_UNIT) != null
				&& !(request.getParameter(PRESENT_UNIT).equals(""))) {
			presentUnit = request.getParameter(PRESENT_UNIT);
					}
		if (request.getParameter(POSTED_FROM) != null
				&& !(request.getParameter(POSTED_FROM).equals(""))) {
			postedFromId = (request.getParameter(POSTED_FROM));
			
		}
		if (request.getParameter(POSTED_TO) != null
				&& !(request.getParameter(POSTED_TO).equals(""))) {
			postedToId = (request.getParameter(POSTED_TO));
			
		}
		if (request.getParameter(AUTHORITY) != null
				&& !(request.getParameter(AUTHORITY).equals(""))) {
			auth = request.getParameter(AUTHORITY);
			
		}

		if (request.getParameter(AUTHORITY_POSTED_OUT) != null
				&& !(request.getParameter(AUTHORITY_POSTED_OUT).equals(""))) {
			authpostingOut = request.getParameter(AUTHORITY_POSTED_OUT);
			
		}

		if (request.getParameter("docStatus") != null
				&& !(request.getParameter("docStatus").equals(""))) {
			docStatus = request.getParameter("docStatus");
			
		}
		if (request.getParameter(EMP_AFMS_ID) != null
				&& !(request.getParameter(EMP_AFMS_ID).equals(""))) {
			empAfmsId = Integer.parseInt(request.getParameter(EMP_AFMS_ID));
			
		}
		String docReceived = "";
		if (request.getParameter("docReceived") != null) {
			docReceived = request.getParameter("docReceived");
		}
		/*if (request.getParameter("suffix") != null) {
			suffix = request.getParameter("suffix");
		}*/

		if (request.getParameter(UNIT_NAME) != null) {
			unitName = request.getParameter(UNIT_NAME);
		}
	String amaArrival="";
	if (request.getParameter("amaArrival") != null) {
		amaArrival = request.getParameter("amaArrival");
	}
	String amaClear="";
	if (request.getParameter("amaClear") != null) {
		amaClear = request.getParameter("amaClear");
	}
		/*if (request.getParameter(UNIT_ADDRESS) != null) {
			unitAddress = request.getParameter(UNIT_ADDRESS);
		}

		if (request.getParameter(LOCAL_UNIT) != null) {
			localUnit = request.getParameter(LOCAL_UNIT);
		}*/

		generalMap.put("empAfmsId", empAfmsId);
		generalMap.put("status", status);
		generalMap.put("employeeName", employeeName);
		generalMap.put("employeeId", empId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("serviceNo", serviceNo);
		generalMap.put("receiptdate", receiptDate);
		generalMap.put("rankId", rankId);
		generalMap.put("letterNo", letterNo);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("auth", auth);
		generalMap.put("postedToId", postedToId);
		generalMap.put("postedFromId", postedFromId);
		generalMap.put("tradeId", tradeId);
		generalMap.put("bloodGroupId", bloodGroupId);
		generalMap.put("medicalcategory", medicalcategory);
		generalMap.put("remarks", remarks);
		generalMap.put("docStatus", docStatus);
		generalMap.put("disRemarks", disRemarks);
		generalMap.put("disletterNo", disletterNo);
		generalMap.put("dispatchdate", dispatchDate);
		generalMap.put("presentUnit", presentUnit);
		generalMap.put("datePostingIn", datePostingIn);
		generalMap.put("datePostingOut", datePostingOut);
		generalMap.put("authpostingOut", authpostingOut);
		//generalMap.put("suffix", suffix);
		generalMap.put("nextreviewDate", nextreviewDate);
		generalMap.put("diagnosis", diagnosis);
		generalMap.put("docReceived", docReceived);
		generalMap.put("lastName", lastName);
		generalMap.put("unitName", unitName);
		generalMap.put("amaArrival", amaArrival);
		generalMap.put("amaClear", amaClear);
		
		//generalMap.put("unitAddress", unitAddress);
		//generalMap.put("localUnit", localUnit);
		boolean dataUpdated = false;

		dataUpdated = misHandlerService.editAfmsfDef(generalMap);

		if (dataUpdated == true) {
			message = "Data Saved Successfully";
		} else {
			message = "Data Updated Successfully";

		}

		/***********************************************************************
		 * when record is updated, it will show the MasEmployee table records
		 * for fetching from MasEmployee the value of receiptStatusRadio is set
		 * to constant 2
		 **********************************************************************/

		url = "/hms/hms/mis?method=showAfmsfDefjsp";
		generalMap.put("status", status);
		map = misHandlerService.showAfmsfDef(generalMap);

		if (status != null) {
			if (status.equals("arrival")) {
				jsp = "arrivalEntry";
				title = "update AFMSF-1 ArrivalEntry";
			} else if (status.equals("receipt")) {
				String afmsfType = "receipt";
				testMap = misHandlerService.showAfmsfDefjsp(afmsfType);
				jsp = "receiptEntryJsp";
				title = "update AFMSF-1 ReceiptEntry";
			} else if (status.equals("clearance")) {
				jsp = "clearanceFormJsp";
				title = "update AFMSF-1 ClearanceForm";
			} else if (status.equals("dispatch")) {
				jsp = "dispatchDetailsJsp";
				title = "update AFMSF-1 DispatchDetails";
			}
		}
		title = "update AFMSF-1 Def";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("indexB", "map", map);

	}

	// -------------------------- Afmsf-1 Surplus
	// -------------------------------

	public ModelAndView showAfmsfSurplusjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showAfmsfSurplusjsp();
		jsp = AFMSFSURPLUS_JSP;
		jsp += ".jsp";
		title = "Surplus Afmsf-1";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showAfmsfSurplus(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = null;

		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		map.put("serviceNo", serviceNo);
		map = misHandlerService.showAfmsfSurplus(map);
		jsp = AFMSFSURPLUS_JSP;
		jsp += ".jsp";
		title = "Surplus Afmsf-1";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editAfmsfSurplus(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String currentDate = null;
		String currentDatetoStr = null;
		int hospitalId = 0;
		int rankId = 0;
		int empId = 0;
		String letterNo = "0";

		String serviceNo = null;
		String changedBy = "";
		int LastUnit = 0;
		String employeeName = null;
		Date receiptDate = new Date();
		String status = "";
		hospitalId = (Integer) session.getAttribute("hospitalId");
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
			empId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(RECEIPT_DATE) != null
				&& !(request.getParameter(RECEIPT_DATE).equals(""))) {
			receiptDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(RECEIPT_DATE));
		}
		if (request.getParameter(EMPLOYEE_FIRST_NAME) != null
				&& !(request.getParameter(EMPLOYEE_FIRST_NAME).equals(""))) {
			employeeName = request.getParameter(EMPLOYEE_FIRST_NAME);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals(""))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}

		if (request.getParameter(LAST_UNIT) != null
				&& !(request.getParameter(LAST_UNIT).equals(""))) {
			LastUnit = Integer.parseInt(request.getParameter(LAST_UNIT));
		}

		if (request.getParameter(LETTER_NO) != null
				&& !(request.getParameter(LETTER_NO).equals(""))) {
			letterNo = request.getParameter(LETTER_NO);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = request.getParameter(CHANGED_DATE);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(RADIO_FOR_TABLE) != null
				&& !(request.getParameter(RADIO_FOR_TABLE).equals(""))) {
			status = request.getParameter(RADIO_FOR_TABLE);
		}
		@SuppressWarnings("unused")
		int postedFromId = 0;
		@SuppressWarnings("unused")
		int postedToId = 0;
		String auth = "";
		String medicalCat = "";
		int empAfmsId = 0;
		int tradeId = 0;
		String description = "";
		if (request.getParameter(TRADE_ID) != null
				&& !(request.getParameter(TRADE_ID).equals(""))) {
			tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
		}
		if (request.getParameter(POSTED_FROM) != null
				&& !(request.getParameter(POSTED_FROM).equals(""))) {
			postedFromId = Integer.parseInt(request.getParameter(POSTED_FROM));
		}
		if (request.getParameter(POSTED_TO) != null
				&& !(request.getParameter(POSTED_TO).equals(""))) {
			postedToId = Integer.parseInt(request.getParameter(POSTED_TO));
		}
		if (request.getParameter(DESCRIPTION) != null
				&& !(request.getParameter(DESCRIPTION).equals(""))) {
			description = request.getParameter(DESCRIPTION);
		}
		if (request.getParameter(MEDICAL_CATEGORY) != null
				&& !(request.getParameter(MEDICAL_CATEGORY).equals(""))) {
			medicalCat = request.getParameter(MEDICAL_CATEGORY);
		}
		if (request.getParameter(EMP_AFMS_ID) != null
				&& !(request.getParameter(EMP_AFMS_ID).equals(""))) {
			empAfmsId = Integer.parseInt(request.getParameter(EMP_AFMS_ID));
		}
		generalMap.put("empAfmsId", empAfmsId);
		generalMap.put("description", description);
		generalMap.put("status", status);
		generalMap.put("tradeId", tradeId);
		generalMap.put("employeeName", employeeName);
		generalMap.put("employeeId", empId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("serviceNo", serviceNo);
		generalMap.put("receiptDate", receiptDate);
		generalMap.put("rankId", rankId);
		generalMap.put("LastUnit", LastUnit);
		generalMap.put("letterNo", letterNo);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("medicalCat", medicalCat);
		generalMap.put("postedToId", postedToId);
		generalMap.put("postedFromId", postedFromId);

		boolean dataUpdated = false;
		boolean duplicateRecord = false;
		dataUpdated = misHandlerService.editAfmsfSurplus(generalMap);
		if (dataUpdated == true) {
			message = "Data Saved Successfully";
		} else {
			message = "Data Updated Successfully";

		}

		/***********************************************************************
		 * when record is updated, it will show the MasEmployee table records
		 * for fetching from MasEmployee the value of receiptStatusRadio is set
		 * to constant 2
		 **********************************************************************/

		url = "/hms/hms/mis?method=showAfmsfDefjsp";
		map = misHandlerService.showAfmsfDef(generalMap);

		jsp = AFMSFSURPLUS_JSP;
		title = "update AFMSF-1 Def";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("indexB", "map", map);

	}

	/**
	 * --------------------- AfmsfAnnualMedicalExamination
	 * -------------------------*
	 */
	public ModelAndView showAfmsfAnnualMedicalExaminationjsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.getMedicalCategory();
		// map = misHandlerService.showAfmsfAnnualMedicalExaminationjsp();
		jsp = AFMSFANNUALMEDICALEXAMINATION_JSP;
		jsp += ".jsp";
		title = "Annual Medical Examination Afmsf-1";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showAfmsfAnnualMedicalExamination(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = null;
		session = request.getSession();
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}

		session.setAttribute("serviceNo", serviceNo);

		map = misHandlerService.showAfmsfAnnualMedicalExamination(serviceNo);
		jsp = AFMSFANNUALMEDICALEXAMINATION_JSP;
		jsp += ".jsp";
		title = "Annual Medical Examination Afmsf-1";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editAfmsfAnnualMedicalExamination(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Date ameDate = null;
		Date nextReviewDate = null;
		int empAfmsfDetId = 0;
		int ameId = 0;
		if (request.getParameter(AME_ID) != null
				&& !(request.getParameter(AME_ID).equals(""))) {
			ameId = Integer.parseInt(request.getParameter(AME_ID));
		}
		if (request.getParameter(EMP_AFMS_ID) != null
				&& !(request.getParameter(EMP_AFMS_ID).equals(""))) {
			empAfmsfDetId = Integer.parseInt(request.getParameter(EMP_AFMS_ID));
		}
		if (request.getParameter(AME_DATE) != null
				&& !(request.getParameter(AME_DATE).equals(""))) {
			ameDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(AME_DATE));
			generalMap.put("ameDate", HMSUtil
					.convertDateToStringWithoutTime(ameDate));
		}
		if (request.getParameter(NEXT_REVIEW_DATE) != null
				&& !(request.getParameter(NEXT_REVIEW_DATE).equals(""))) {
			nextReviewDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(NEXT_REVIEW_DATE));
			generalMap.put("nextReviewDate", HMSUtil
					.convertDateToStringWithoutTime(nextReviewDate));
		}
		String currentDate = null;
		String currentTime = "";
		String changedBy = "";
		int categoryId = 0;
		String period = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = request.getParameter(CHANGED_DATE);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(CATEGORY_ID) != null
				&& !(request.getParameter(CATEGORY_ID).equals(""))) {
			categoryId = Integer.parseInt(request.getParameter(CATEGORY_ID));
		}
		if (request.getParameter(PERIOD) != null
				&& !(request.getParameter(PERIOD).equals(""))) {
			period = request.getParameter(PERIOD);
		}
		generalMap.put("empAfmsfDetId", empAfmsfDetId);
		generalMap.put("categoryId", categoryId);
		generalMap.put("period", period);
		generalMap.put("ameId", ameId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		map = misHandlerService.editAfmsfAnnualMedicalExamination(generalMap,
				box);
		/***********************************************************************
		 * when record is updated, it will show the MasEmployee table records
		 * for fetching from MasEmployee the value of surplusStatus is set to
		 * constant 2
		 **********************************************************************/
		url = "/hms/hms/mis?method=showAfmsfAnnualMedicalexaminationjsp";
		// map = misHandlerService.showAfmsfAnnualMedicalExamination(serviceNo);
		boolean saved = false;
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Data saved successfully !!  Do you want to print ?";
		} else {
			message = "Try Again !!";
		}
		jsp = MSG_AFMSFANNUALMEDICALEXAMINATION_JSP;
		title = "Annual Medical Examination Afmsf-1";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/*
	 * public ModelAndView editAfmsfAnnualMedicalExamination( HttpServletRequest
	 * request, HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); Map<String, Object> generalMap = new
	 * HashMap<String, Object>(); Box box = HMSUtil.getBox(request); session =
	 * request.getSession(); Date ameDate = null; Date nextReviewDate = null;
	 * int empAfmsfDetId = 0; int ameId = 0; if (request.getParameter(AME_ID) !=
	 * null && !(request.getParameter(AME_ID).equals(""))) { ameId =
	 * Integer.parseInt(request.getParameter(AME_ID)); } if
	 * (request.getParameter(EMP_AFMS_ID) != null &&
	 * !(request.getParameter(EMP_AFMS_ID).equals(""))) { empAfmsfDetId =
	 * Integer.parseInt(request.getParameter(EMP_AFMS_ID)); } if
	 * (request.getParameter(AME_DATE) != null &&
	 * !(request.getParameter(AME_DATE).equals(""))) { ameDate =
	 * HMSUtil.convertStringTypeDateToDateType(request.getParameter(AME_DATE));
	 * generalMap.put("ameDate",
	 * HMSUtil.convertDateToStringWithoutTime(ameDate)); } if
	 * (request.getParameter(NEXT_REVIEW_DATE) != null &&
	 * !(request.getParameter(NEXT_REVIEW_DATE).equals(""))) { nextReviewDate =
	 * HMSUtil
	 * .convertStringTypeDateToDateType(request.getParameter(NEXT_REVIEW_DATE));
	 * generalMap.put("nextReviewDate",
	 * HMSUtil.convertDateToStringWithoutTime(nextReviewDate)); } String
	 * currentDate = null; String currentTime = ""; String changedBy = ""; int
	 * categoryId = 0; String period = ""; if (request.getParameter(CHANGED_BY)
	 * != null && !(request.getParameter(CHANGED_BY).equals(""))) { changedBy =
	 * request.getParameter(CHANGED_BY); } if
	 * (request.getParameter(CHANGED_DATE) != null &&
	 * !(request.getParameter(CHANGED_DATE).equals(""))) { currentDate =
	 * request.getParameter(CHANGED_DATE); } if
	 * (request.getParameter(CHANGED_TIME) != null &&
	 * !(request.getParameter(CHANGED_TIME).equals(""))) { currentTime =
	 * request.getParameter(CHANGED_TIME); } if
	 * (request.getParameter(CATEGORY_ID) != null &&
	 * !(request.getParameter(CATEGORY_ID).equals(""))) { categoryId =
	 * Integer.parseInt(request.getParameter(CATEGORY_ID)); } if
	 * (request.getParameter(PERIOD) != null &&
	 * !(request.getParameter(PERIOD).equals(""))) { period =
	 * request.getParameter(PERIOD); } generalMap.put("empAfmsfDetId",
	 * empAfmsfDetId); generalMap.put("categoryId", categoryId);
	 * generalMap.put("period", period); generalMap.put("ameId", ameId);
	 * generalMap.put("changedBy", changedBy); generalMap.put("changedBy",
	 * changedBy); generalMap.put("currentDate", currentDate);
	 * generalMap.put("currentTime", currentTime);
	 *  map =
	 * misHandlerService.editAfmsfAnnualMedicalExamination(generalMap,box);
	 *//***********************************************************************
	 * when record is updated, it will show the MasEmployee table records for
	 * fetching from MasEmployee the value of surplusStatus is set to constant 2
	 **********************************************************************/
	/*
	 * url = "/hms/hms/mis?method=showAfmsfAnnualMedicalexaminationjsp"; // map
	 * = misHandlerService.showAfmsfAnnualMedicalExamination(serviceNo); jsp =
	 * AFMSFANNUALMEDICALEXAMINATION_JSP; title =
	 * "Annual Medical Examination Afmsf-1"; jsp += ".jsp";
	 * map.put("contentJsp", jsp); map.put("title", title); map.put("url", url);
	 * return new ModelAndView("indexB", "map", map); }
	 */

	// --------------------- Fatal Case Document -------------------------

	public ModelAndView showFatalCasejsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String hinNo = null;
		int inpatientId = 0;
		session = request.getSession();
		if (request.getParameter(AD_NO) != null
				&& !(request.getParameter(AD_NO).equals(""))) {
			inpatientId = Integer.parseInt(request.getParameter(AD_NO));
		}
		session.setAttribute("hinNo", hinNo);
		dataMap.put("inpatientId", inpatientId);
		map = misHandlerService.showFatalCasejsp(dataMap);
		jsp = FATALCASE_JSP;
		jsp += ".jsp";
		title = "Fatal Case Document";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showFatalCase(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String serviceNo="";

		session = request.getSession();
		
		/*int inpatientid = 0;
		 * if (request.getParameter(AD_NO) != null
				&& !(request.getParameter(AD_NO).equals(""))) {
			inpatientid = Integer.parseInt(request.getParameter(AD_NO));
		}commented By dipali*/
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		dataMap.put("serviceNo", serviceNo);
		map = misHandlerService.showFatalCasejsp(dataMap);
		jsp = FATALCASE_DETAILS_JSP;
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView editFatalCase(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String currentDate = null;
		String currentDatetoStr = null;
		int hospitalId = 0;
		int hinId = 0;
		int inpatientId = 0;
		int misFatalId = 0;
		String changedBy = "";
		String adNo = null;
		String postmortem = null;

		Date dateOfDeath = null;
		Date dateOfPostmortem = null;
		Date dateOfConcerned = null;
		Date dateOfOpinion = null;
		Date dateOfWardMaster = null;
		Date dateOfMoWard = null;
		Date dateOfHOD = null;
		Date dateOfStats = null;
		Date dateOfCommandant = null;
		Date dateOfPathology = null;
		Date dateOfSA1 = null;
		Date dateOfSA2 = null;
		Date dateOfSA3 = null;
		Date dateOfSA4 = null;
		Date dateOfConcernedCommand = null;

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
		String serviceNo="";
		String concernedCommandDateRemark = null;
		if (session.getAttribute("hospitalId") != null)
			hospitalId = (Integer) session.getAttribute("hospitalId");

		if (request.getParameter("hinId") != null
				&& !(request.getParameter("hinId").equals(""))) {
			hinId = Integer.parseInt("" + request.getParameter("hinId"));
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(DATE_OF_DEATH) != null
				&& !(request.getParameter(DATE_OF_DEATH).equals(""))) {
			dateOfDeath = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_DEATH));
		}
		if (request.getParameter(DEATH_REMARK) != null
				&& !(request.getParameter(DEATH_REMARK).equals(""))) {
			deathRemark = request.getParameter(DEATH_REMARK);
		}
		if (request.getParameter(DATE_OF_POSTMORTEM) != null
				&& !(request.getParameter(DATE_OF_POSTMORTEM).equals(""))) {
			dateOfPostmortem = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_POSTMORTEM));
		}
		if (request.getParameter(POSTMORTEM_DATE_REMARK) != null
				&& !(request.getParameter(POSTMORTEM_DATE_REMARK).equals(""))) {
			postmortemDateRemark = request.getParameter(POSTMORTEM_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_CONCERNED) != null
				&& !(request.getParameter(DATE_OF_CONCERNED).equals(""))) {
			dateOfConcerned = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_CONCERNED));
		}
		if (request.getParameter(CONCERNED_DATE_REMARK) != null
				&& !(request.getParameter(CONCERNED_DATE_REMARK).equals(""))) {
			concernedDateRemark = request.getParameter(CONCERNED_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_OPINION) != null
				&& !(request.getParameter(DATE_OF_OPINION).equals(""))) {
			dateOfOpinion = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_OPINION));
		}
		if (request.getParameter(OPINION_DATE_REMARK) != null
				&& !(request.getParameter(OPINION_DATE_REMARK).equals(""))) {
			opinionDateRemark = request.getParameter(OPINION_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_WARD_MASTER) != null
				&& !(request.getParameter(DATE_OF_WARD_MASTER).equals(""))) {
			dateOfWardMaster = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_WARD_MASTER));
		}
		if (request.getParameter(WARD_MASTER_DATE_REMARK) != null
				&& !(request.getParameter(WARD_MASTER_DATE_REMARK).equals(""))) {
			wardMasterDateRemark = request
					.getParameter(WARD_MASTER_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_MO_WARD) != null
				&& !(request.getParameter(DATE_OF_MO_WARD).equals(""))) {
			dateOfMoWard = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_MO_WARD));
		}
		if (request.getParameter(WARD_REMARK) != null
				&& !(request.getParameter(WARD_REMARK).equals(""))) {
			wardDateRemark = request.getParameter(WARD_REMARK);
		}
		if (request.getParameter(DATE_OF_HOD) != null
				&& !(request.getParameter(DATE_OF_HOD).equals(""))) {
			dateOfHOD = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_HOD));
		}
		if (request.getParameter(HOD_DATE_REMARK) != null
				&& !(request.getParameter(HOD_DATE_REMARK).equals(""))) {
			hodDateRemark = request.getParameter(HOD_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_STATS) != null
				&& !(request.getParameter(DATE_OF_STATS).equals(""))) {
			dateOfStats = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_STATS));
		}
		if (request.getParameter(STATS_DATE_REMARK) != null
				&& !(request.getParameter(STATS_DATE_REMARK).equals(""))) {
			statsDateRemark = request.getParameter(STATS_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_COMMANDANT) != null
				&& !(request.getParameter(DATE_OF_COMMANDANT).equals(""))) {
			dateOfCommandant = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_COMMANDANT));
		}
		if (request.getParameter(COMMANDANT_DATE_REMARK) != null
				&& !(request.getParameter(COMMANDANT_DATE_REMARK).equals(""))) {
			commandantDateRemark = request.getParameter(COMMANDANT_DATE_REMARK);
		}

		if (request.getParameter(DATE_OF_PATHOLOGY) != null
				&& !(request.getParameter(DATE_OF_PATHOLOGY).equals(""))) {
			dateOfPathology = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_PATHOLOGY));
		}
		if (request.getParameter(PATHOLOGY_DATE_REMARK) != null
				&& !(request.getParameter(PATHOLOGY_DATE_REMARK).equals(""))) {
			pathologyDateRemark = request.getParameter(PATHOLOGY_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_SENIOR_ADVISOR_1) != null
				&& !(request.getParameter(DATE_OF_SENIOR_ADVISOR_1).equals(""))) {
			dateOfSA1 = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_SENIOR_ADVISOR_1));
		}
		if (request.getParameter(SA1_DATE_REMARK) != null
				&& !(request.getParameter(SA1_DATE_REMARK).equals(""))) {
			sa1DateRemark = request.getParameter(SA1_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_SENIOR_ADVISOR_2) != null
				&& !(request.getParameter(DATE_OF_SENIOR_ADVISOR_2).equals(""))) {
			dateOfSA2 = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_SENIOR_ADVISOR_2));
		}
		if (request.getParameter(SA2_DATE_REMARK) != null
				&& !(request.getParameter(SA2_DATE_REMARK).equals(""))) {
			sa2DateRemark = request.getParameter(SA2_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_SENIOR_ADVISOR_3) != null
				&& !(request.getParameter(DATE_OF_SENIOR_ADVISOR_3).equals(""))) {
			dateOfSA3 = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_SENIOR_ADVISOR_3));
		}
		if (request.getParameter(SA3_DATE_REMARK) != null
				&& !(request.getParameter(SA3_DATE_REMARK).equals(""))) {
			sa3DateRemark = request.getParameter(SA3_DATE_REMARK);
		}
		if (request.getParameter(DATE_OF_SENIOR_ADVISOR_4) != null
				&& !(request.getParameter(DATE_OF_SENIOR_ADVISOR_4).equals(""))) {
			dateOfSA4 = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_SENIOR_ADVISOR_4));
		}
		if (request.getParameter(SA4_DATE_REMARK) != null
				&& !(request.getParameter(SA4_DATE_REMARK).equals(""))) {
			sa4DateRemark = request.getParameter(SA4_DATE_REMARK);
		}

		if (request.getParameter(DATE_OF_CONCERNED_COMMAND) != null
				&& !(request.getParameter(DATE_OF_CONCERNED_COMMAND).equals(""))) {
			dateOfConcernedCommand = HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(DATE_OF_CONCERNED_COMMAND));
		}
		if (request.getParameter(CONCERNED_COMMAND_DATE_REMARK) != null
				&& !(request.getParameter(CONCERNED_COMMAND_DATE_REMARK)
						.equals(""))) {
			concernedCommandDateRemark = request
					.getParameter(CONCERNED_COMMAND_DATE_REMARK);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = request.getParameter(CHANGED_DATE);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		if (request.getParameter(POSTMORTEM) != null
				&& !(request.getParameter(POSTMORTEM).equals(""))) {
			postmortem = request.getParameter(POSTMORTEM);
		}
		if (request.getParameter(POSTMORTEM_REMARK) != null
				&& !(request.getParameter(POSTMORTEM_REMARK).equals(""))) {
			postmortemRemark = request.getParameter(POSTMORTEM_REMARK);
		}
		if (request.getParameter(AD_NO) != null
				&& !(request.getParameter(AD_NO).equals(""))) {
			inpatientId = Integer.parseInt(request.getParameter(AD_NO));
		}
		if (request.getParameter(MIS_FATAL_ID) != null
				&& !(request.getParameter(MIS_FATAL_ID).equals(""))) {
			misFatalId = Integer.parseInt(request.getParameter(MIS_FATAL_ID));
		}
		int trackId = 0;
		if (request.getParameter("trackId") != null
				&& !(request.getParameter("trackId").equals(""))) {
			trackId = Integer.parseInt(request.getParameter("trackId"));
		}
		generalMap.put("adNo", adNo);
		if (dateOfDeath != null)
			generalMap.put("dateOfDeath", HMSUtil
					.convertDateToStringWithoutTime(dateOfDeath));
		if (dateOfPostmortem != null)
			generalMap.put("dateOfPostmortem", HMSUtil
					.convertDateToStringWithoutTime(dateOfPostmortem));
		if (dateOfConcerned != null)
			generalMap.put("dateOfConcerned", HMSUtil
					.convertDateToStringWithoutTime(dateOfConcerned));
		if (dateOfOpinion != null)
			generalMap.put("dateOfOpinion", HMSUtil
					.convertDateToStringWithoutTime(dateOfOpinion));
		if (dateOfWardMaster != null)
			generalMap.put("dateOfWardMaster", HMSUtil
					.convertDateToStringWithoutTime(dateOfWardMaster));
		if (dateOfMoWard != null)
			generalMap.put("dateOfMoWard", HMSUtil
					.convertDateToStringWithoutTime(dateOfMoWard));
		if (dateOfHOD != null)
			generalMap.put("dateOfHOD", HMSUtil
					.convertDateToStringWithoutTime(dateOfHOD));
		if (dateOfStats != null)
			generalMap.put("dateOfStats", HMSUtil
					.convertDateToStringWithoutTime(dateOfStats));
		if (dateOfCommandant != null)
			generalMap.put("dateOfCommandant", HMSUtil
					.convertDateToStringWithoutTime(dateOfCommandant));
		if (dateOfPathology != null)
			generalMap.put("dateOfPathology", HMSUtil
					.convertDateToStringWithoutTime(dateOfPathology));
		if (dateOfSA1 != null)
			generalMap.put("dateOfSA1", HMSUtil
					.convertDateToStringWithoutTime(dateOfSA1));
		if (dateOfSA2 != null)
			generalMap.put("dateOfSA2", HMSUtil
					.convertDateToStringWithoutTime(dateOfSA2));
		if (dateOfSA3 != null)
			generalMap.put("dateOfSA3", HMSUtil
					.convertDateToStringWithoutTime(dateOfSA3));
		if (dateOfSA4 != null)
			generalMap.put("dateOfSA4", HMSUtil
					.convertDateToStringWithoutTime(dateOfSA4));
		if (dateOfConcernedCommand != null)
			generalMap.put("dateOfConcernedCommand", HMSUtil
					.convertDateToStringWithoutTime(dateOfConcernedCommand));
		if (postmortem != null)
			generalMap.put("postmortem", postmortem);

		generalMap.put("hospitalId", hospitalId);
		generalMap.put("hinId", hinId);
		generalMap.put("adNo", adNo);
		generalMap.put("serviceNo", serviceNo);
		generalMap.put("postmortem", postmortem);
		generalMap.put("deathRemark", deathRemark);
		generalMap.put("postmortemRemark", postmortemRemark);
		generalMap.put("postmortemDateRemark", postmortemDateRemark);
		generalMap.put("concernedDateRemark", concernedDateRemark);
		generalMap.put("opinionDateRemark", opinionDateRemark);
		generalMap.put("wardMasterDateRemark", wardMasterDateRemark);
		generalMap.put("wardDateRemark", wardDateRemark);
		generalMap.put("hodDateRemark", hodDateRemark);
		generalMap.put("statsDateRemark", statsDateRemark);
		generalMap.put("commandantDateRemark", commandantDateRemark);
		generalMap.put("pathologyDateRemark", pathologyDateRemark);
		generalMap.put("sa1DateRemark", sa1DateRemark);
		generalMap.put("sa2DateRemark", sa2DateRemark);
		generalMap.put("sa3DateRemark", sa3DateRemark);
		generalMap.put("sa4DateRemark", sa4DateRemark);
		generalMap
				.put("concernedCommandDateRemark", concernedCommandDateRemark);
		generalMap.put("inpatientId", inpatientId);

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("misFatalId", misFatalId);
		generalMap.put("trackId",trackId);
		boolean dataUpdated = false;

		dataUpdated = misHandlerService.editFatalcase(generalMap);
		String messageType = "";
		if (dataUpdated == true) {
			message = "Data updated Successfully.";
			messageType = "success";
		} else {
			message = "Data Can not be updated";
			messageType = "failure";
		}

		/***********************************************************************
		 * when record is updated, it will show the MasEmployee table records
		 * for fetching from MasEmployee the value of surplusStatus is set to
		 * constant 2
		 **********************************************************************/
		Map<String, Object> dataMap = new HashMap<String, Object>();
		url = "/hms/hms/mis?method=showAfmsfAnnualMedicalexaminationjsp";
		dataMap.put("inpatientId",inpatientId);
		map = misHandlerService.showFatalCasejsp(dataMap);

		jsp = MESSAGE_FOR_FDT;
		title = "update Fatal Case Document";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		map.put("messageType", messageType);
		map.put("inpatientId", inpatientId);
		return new ModelAndView("indexB", "map", map);

	}

	// ----------------------------Total Admissions Date Wise
	// --------------------------------------
	public ModelAndView showTotalAdmissionjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = null;
		session = request.getSession();
		map = misHandlerService.showTotalAdmissionjsp();
		jsp = TOTALADMISSION_JSP;
		jsp += ".jsp";
		title = "Total Admission";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchTotalAdmission(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate1 = null;
		Date toDate1 = null;
		String serviceType = "";
		String serviceTypeId = "";
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate1 = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate1 = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(SERVICE_TYPE_NAME) != null
					&& !(request.getParameter(SERVICE_TYPE_NAME).equals(""))) {
				serviceTypeId = request.getParameter(SERVICE_TYPE_NAME);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!serviceTypeId.equals("0")) {
			serviceType = " and  mas_service_type.service_type_id="
					+ serviceTypeId;
		}

		map = misHandlerService.getDBConnection();

		map.put("fromDate", fromDate1);
		map.put("toDate", toDate1);
		String stName = "All";
		if (request.getParameter("stName") != null
				&& !(request.getParameter("stName").equals(""))) {
			stName = request.getParameter("stName");
		}
		map.put("serviceType", serviceType);
		map.put("formCode", stName + " Personal in CHAF Bangalore -7");
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));

		// byte[] bytes = null;
		// try {

		// bytes = JasperRunManager.runReportToPdf(
		// getCompiledReport("TotalAdmissionDateWise1"), map,
		// (Connection) map.get("conn"));
		// HMSUtil.generateReport("TotalAdmissionDateWise1", map,
		// (Connection)map.get("conn"), response, getServletContext());
		// } catch (JRException e) {

		// e.printStackTrace();
		// }
		// response.setContentType("application/pdf");
		// response.setContentLength(bytes.length);
		// ServletOutputStream ouputStream;
		// try {
		// ouputStream = response.getOutputStream();
		// ouputStream.write(bytes, 0, bytes.length);
		// ouputStream.flush();
		// ouputStream.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		try {
			HMSUtil
					.generateReport("TotalAdmissionDateWise1", map,
							(Connection) map.get("conn"), response,
							getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ------------------------ Total Discharge Date Wise
	// --------------------------------------
	public ModelAndView showTotalDischargejsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		String hinNo = null;
		session = request.getSession();
		map = misHandlerService.showTotalDischargejsp();
		jsp = TOTALDISCHARGEREPORT_JSP;
		jsp += ".jsp";
		title = "Total Admission";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchTotalDischarge(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String subPath = "";
		File reportFile = new File(getServletContext().getRealPath("/reports/"));
		String toDate = null;
		String fromDate = null;
		String criteria = "";
		Date fromDateDate = null;
		Date toDateDate = null;
		String serviceType = "";
		String serviceTypeName = "All";
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = request.getParameter(TO_DATE);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = request.getParameter(FROM_DATE);
			}
			if (request.getParameter(SERVICE_TYPE_ID) != null
					&& !(request.getParameter(SERVICE_TYPE_ID).equals(""))) {
				serviceType = request.getParameter(SERVICE_TYPE_ID);
			}
			if (request.getParameter(SERVICE_TYPE_NAME) != null
					&& !(request.getParameter(SERVICE_TYPE_NAME).equals(""))) {
				serviceTypeName = request.getParameter(SERVICE_TYPE_NAME);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		fromDateDate = HMSUtil.convertStringTypeDateToDateType(fromDate);
		toDateDate = HMSUtil.convertStringTypeDateToDateType(toDate);
		map.put(fromDate, fromDateDate);
		map.put(toDate, toDateDate);

		if (!serviceType.equals("0")) {
			criteria = " and mas_service_type.service_type_id=" + serviceType;
		}
		
		map = misHandlerService.getDBConnection();
		byte[] bytes = null;
		subPath = reportFile.toString();
		map.put("SUBREPORT_DIR", subPath);
		map.put("toDate", toDateDate);
		map.put("fromDate", fromDateDate);
		map.put("criteria", criteria);
		map.put("formCode", serviceTypeName
				+ " Personnel in CHAF Bangalore - 7");
		// try {
		// bytes =
		// JasperRunManager.runReportToPdf(getCompiledReport("TotalDischargeDateWise"),
		// map,(Connection) map.get("conn"));

		// } catch (Exception e) {

		// e.printStackTrace();
		// }
		// response.setContentType("application/pdf");
		// response.setContentLength(bytes.length);
		// ServletOutputStream ouputStream;
		// try {
		// ouputStream = response.getOutputStream();
		// ouputStream.write(bytes, 0, bytes.length);
		// ouputStream.flush();
		// ouputStream.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		HMSUtil.generateReport("TotalDischargeDateWise", map, (Connection) map
				.get("conn"), response, getServletContext());
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ---------------------------------- Monthly Sick for Admissions
	 * -------------------------------
	 */
	public ModelAndView showMonthlySickReportsjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = misHandlerService.showMonthlySickReportsjsp();
		jsp = MONTHLYSICKREPORT_JSP;
		jsp += ".jsp";
		title = "monthlySick";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/*
	 * public ModelAndView searchMonthlySickReport(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); Box box = HMSUtil.getBox(request); Date toDate
	 * = null; Date fromDate = null; String outputType = null; String
	 * category_ids = null; String temp = ""; StringBuffer category_queryString
	 * = new StringBuffer(); StringBuffer unit_queryString = new StringBuffer();
	 * byte[] bytes = null; try { if (request.getParameter(TO_DATE) != null &&
	 * !(request.getParameter(TO_DATE).equals(""))) { toDate =
	 * HMSUtil.convertStringTypeDateToDateType(request .getParameter(TO_DATE));
	 * } if (request.getParameter(FROM_DATE) != null &&
	 * !(request.getParameter(FROM_DATE).equals(""))) { fromDate =
	 * HMSUtil.convertStringTypeDateToDateType(request
	 * .getParameter(FROM_DATE)); }
	 * 
	 * if (request.getParameter("outputType") != null &&
	 * !(request.getParameter("outputType").equals(""))) { outputType =
	 * request.getParameter("outputType"); } if (request.getParameter("nc") !=
	 * null && !(request.getParameter("nc").equals(""))) { if
	 * (request.getParameter("nc").equalsIgnoreCase("nc")) temp =
	 * "and c.rank_id =19"; else temp = "and c.rank_id !=19"; } // category_ids
	 * = box.getVector(CATEGORY_ID).toString(); // unit_ids =
	 * box.getVector("unit").toString(); // if (category_ids.length() > 0) // {
	 * // category_ids = category_ids.substring(1,category_ids.length()-1); //
	 * category_queryString.append("and i.rank_category_id in ("); //
	 * category_queryString.append(category_ids); //
	 * category_queryString.append(")"); // } // if (unit_ids.length() > 0) // {
	 * // unit_ids = unit_ids.substring(1,unit_ids.length()-1); //
	 * unit_queryString.append("and f.unit_id in ("); //
	 * unit_queryString.append(unit_ids); // unit_queryString.append(")"); // }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } map =
	 * misHandlerService.getDBConnection(); map.put("fromDate", fromDate);
	 * map.put("toDate", toDate); 
	 * map.put("temp", temp); map.put("SUBREPORT_DIR",
	 * getServletContext().getRealPath("/reports/"));
	 * 
	 * if (outputType.equals("Excel")) { try
	 * 
	 * {
	 * 
	 * JRXlsExporter exporter = new JRXlsExporter(); JasperPrint jasperPrint =
	 * JasperFillManager.fillReport( getCompiledReport("MonthlySickReport"),
	 * map, (Connection) map.get("conn")); ByteArrayOutputStream xlsReport = new
	 * ByteArrayOutputStream();
	 * exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	 * exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, xlsReport);
	 * exporter .setParameter(
	 * JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
	 * Boolean.TRUE); exporter.setParameter(
	 * JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
	 * exporter.setParameter(JRExporterParameter.OUTPUT_FILE,
	 * getServletContext().getRealPath("/reports/")); exporter.exportReport();
	 * bytes = xlsReport.toByteArray();
	 * response.setContentType("application/vnd.ms-excel");
	 * response.setContentLength(bytes.length); xlsReport.close();
	 * 
	 * } catch (JRException e) { e.printStackTrace(); } catch (IOException e) {
	 * e.printStackTrace(); } } else if (outputType.equals("Pdf")) {
	 * 
	 * try {
	 * 
	 * HMSUtil.generateReport("MonthlySickReport", map, (Connection)
	 * map.get("conn"), response, getServletContext()); } catch (Exception e) {
	 * 
	 * e.printStackTrace(); } } return null; }
	 */
	// add by nirul on 03-04-2010
	/*public ModelAndView searchMonthlySickReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		Date toDate = null;
		Date fromDate = null;
		String outputType = null;
		String category_ids = null;
		String temp = "";
		StringBuffer category_queryString = new StringBuffer();
		StringBuffer unit_queryString = new StringBuffer();
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}

			if (request.getParameter("outputType") != null
					&& !(request.getParameter("outputType").equals(""))) {
				outputType = request.getParameter("outputType");
			}
		
			if (request.getParameter("nc") != null
					&& !(request.getParameter("nc").equals(""))) {
				if (request.getParameter("nc").equalsIgnoreCase("nc"))
					temp = "and c.rank_id =19";
				else
					temp = "and c.rank_id !=19";
			}
			// category_ids = box.getVector(CATEGORY_ID).toString();
			// unit_ids = box.getVector("unit").toString();
			// if (category_ids.length() > 0)
			// {
			// category_ids = category_ids.substring(1,category_ids.length()-1);
			// category_queryString.append("and i.rank_category_id in (");
			// category_queryString.append(category_ids);
			// category_queryString.append(")");
			// }
			// if (unit_ids.length() > 0)
			// {
			// unit_ids = unit_ids.substring(1,unit_ids.length()-1);
			// unit_queryString.append("and f.unit_id in (");
			// unit_queryString.append(unit_ids);
			// unit_queryString.append(")");
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);		
		//map.put("temp", temp);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));

		if (outputType.equals("Excel")) {
			try

			{

				JRXlsExporter exporter = new JRXlsExporter();
				JasperPrint jasperPrint = JasperFillManager.fillReport(
						getCompiledReport("MonthlySickReport"), map,
						(Connection) map.get("conn"));

				ByteArrayOutputStream xlsReport = new ByteArrayOutputStream();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT,
						jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
						xlsReport);
				// exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,Boolean.TRUE);
				// exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,Boolean.TRUE);
				// exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE,
						getServletContext().getRealPath("/reports/"));
				exporter.exportReport();
				bytes = xlsReport.toByteArray();
				response.setContentType("application/vnd.ms-excel");
				response.setContentLength(bytes.length);
				xlsReport.close();

			} catch (JRException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (outputType.equals("Pdf")) {

			try {

				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("MonthlySickReport"), map,
						(Connection) map.get("conn"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
		}
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
	public ModelAndView searchMonthlySickReport(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		Date fromDate = HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate"));
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		Calendar cal = Calendar.getInstance();
		cal.setTime(fromDate);
		int month = cal.get(Calendar.MONTH)+1;
		int year =cal.get(Calendar.YEAR);
		String qry="";
		if(box.getInt(CATEGORY_ID)!=0){
			qry += " and mr.rank_category_id="+box.getInt(CATEGORY_ID);
		}
			
		SimpleDateFormat formatterOut = new SimpleDateFormat("MMM-yyyy");
		String monthName = formatterOut.format(fromDate);
		map = misHandlerService.getDBConnection();
		map.put("month", month);
		map.put("monthName", monthName);
		map.put("rankCatName", box.getString("rankCatName"));
		map.put("qry", qry);
		map.put("hospitalId", hospitalId);
		map.put("year", year);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = misHandlerService.getConnectionForReport();
		HMSUtil.generateReport("MonthlySickAdmReport", map,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	/**
	 * ----------------------------------- Monthly Sick For Discharge
	 * ----------------------------
	 */
	public ModelAndView showMonthlySickDischargeReportjsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = misHandlerService.showMonthlySickDischargeReportjsp();
		jsp = MONTHLYSICKDISCHARGEREPORT_JSP;
		jsp += ".jsp";
		title = "monthlySickDischarge";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
/*
	public ModelAndView searchMonthlySickDischargeReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		Date toDate = null;
		Date fromDate = null;
		String category = null;
		String outputType = null;
		byte[] bytes = null;
		String temp = "";
		String unit_ids = null;
		StringBuffer category_queryString = new StringBuffer();
		StringBuffer unit_queryString = new StringBuffer();
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(CATEGORY_ID) != null
					&& !(request.getParameter(CATEGORY_ID).equals(""))) {
				category = request.getParameter(CATEGORY_ID);
			}
			if (request.getParameter("outputType") != null
					&& !(request.getParameter("outputType").equals(""))) {
				outputType = request.getParameter("outputType");
			}
			if (request.getParameter("nc") != null
					&& !(request.getParameter("nc").equals(""))) {
				if (request.getParameter("nc").equalsIgnoreCase("nc"))
					temp = "and c.rank_id =19";
				else
					temp = "and c.rank_id !=19";
			}
			// category_ids = box.getVector(CATEGORY_ID).toString();
			// unit_ids = box.getVector("unit").toString();
			// if (category_ids.length() > 0)
			// {
			// category_ids = category_ids.substring(1,category_ids.length()-1);
			// category_queryString.append("and i.rank_category_id in (");
			// category_queryString.append(category_ids);
			// category_queryString.append(")");
			// }
			// if (unit_ids.length() > 0)
			// {
			// unit_ids = unit_ids.substring(1,unit_ids.length()-1);
			// unit_queryString.append("and f.unit_id in (");
			// unit_queryString.append(unit_ids);
			// unit_queryString.append(")");
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.showMonthlySickDischargeReportjsp();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		//map.put("temp", temp);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));

		if (outputType.equals("Excel")) {
			try

			{

				JRXlsExporter exporter = new JRXlsExporter();
				JasperPrint jasperPrint = JasperFillManager.fillReport(
						getCompiledReport("MonthlySickDischargeReport"), map,
						(Connection) map.get("conn"));

				ByteArrayOutputStream xlsReport = new ByteArrayOutputStream();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT,
						jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
						xlsReport);
				// exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,Boolean.TRUE);
				// exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,Boolean.TRUE);
				// exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE,
						getServletContext().getRealPath("/reports/"));
				exporter.exportReport();
				bytes = xlsReport.toByteArray();
				response.setContentType("application/vnd.ms-excel");
				response.setContentLength(bytes.length);
				xlsReport.close();

			} catch (JRException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (outputType.equals("Pdf")) {

			try {

				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("MonthlySickDischargeReport"), map,
						(Connection) map.get("conn"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
		}
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ModelAndView("indexB", "map", map);
	}*/
	
	public ModelAndView searchMonthlySickDischargeReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		Date fromDate = HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate"));
		HttpSession session = request.getSession();
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		Calendar cal = Calendar.getInstance();
		cal.setTime(fromDate);
		int month = cal.get(Calendar.MONTH)+1;
		int year =cal.get(Calendar.YEAR);
		String qry="";
		if(box.getInt(CATEGORY_ID)!=0){
			qry += " and mr.rank_category_id="+box.getInt(CATEGORY_ID);
		}
			
		SimpleDateFormat formatterOut = new SimpleDateFormat("MMM-yyyy");
		String monthName = formatterOut.format(fromDate);
		map = misHandlerService.getDBConnection();
		map.put("month", month);
		map.put("monthName", monthName);
		map.put("rankCatName", box.getString("rankCatName"));
		map.put("qry", qry);
		map.put("hospitalId", hospitalId);
		map.put("year", year);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = misHandlerService.getConnectionForReport();
		HMSUtil.generateReport("MonthlySickDischargeReportNew", map,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	/**
	 * ------------------------ Fatal Document Panchnama Report
	 * --------------------------
	 */
	public ModelAndView showFatalDocumentPanchnamaReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = FATAL_DOCUMENT_PANCHNAMA + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showFatalDocumentPanchnamaReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int inpatient_id = 0;

		if (request.getParameter(AD_NO) != null) {
			inpatient_id = Integer.parseInt("" + request.getParameter(AD_NO));
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("inpatient_id", inpatient_id);
		HMSUtil.generateReport("FatalDocumentPanchnama", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getAdmissionNoList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";

		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
			detailsMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			detailsMap.put("hinNo", hinNo);
		}
		List<Object> admissionNoList = new ArrayList<Object>();
		List<Object> hinNoList = new ArrayList<Object>();
		String flag = "";
		String fatalCase = "";
		String onlyReport = "";		
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (request.getParameter("fatalCase") != null) {
			fatalCase = request.getParameter("fatalCase");
			map.put("fatalCase", fatalCase);
			detailsMap.put("fatalCase", "fatalCase");
		}
		if (request.getParameter("onlyReport") != null) {
			onlyReport = request.getParameter("onlyReport");
			map.put("onlyReport", onlyReport);
			detailsMap.put("onlyReport", "yes");
		}
		if (flag.equals("admission")) {
			admissionNoList = misHandlerService.getAdmissionNoList(detailsMap);
			map.put("admissionNoList", admissionNoList);
			jsp = MIS_RESPONSE_FOR_ADMISSION_NO;
		} else if (flag.equals("hin")) {
			hinNoList = misHandlerService.getHinNoList(serviceNo);
			map.put("onlyReport", onlyReport);
			map.put("hinNoList", hinNoList);
			jsp = MIS_RESPONSE_FOR_HIN_NO;
		} else if (fatalCase.equals("yes")) {
			admissionNoList = misHandlerService.getAdmissionNoList(detailsMap);
			map.put("admissionNoList", admissionNoList);
			jsp = MIS_RESPONSE_FOR_ADNO_FATALCASE;
		} else if (onlyReport.equals("yes")) {
			admissionNoList = misHandlerService.getAdmissionNoList(detailsMap);
			map.put("admissionNoList", admissionNoList);
			map.put("onlyReport", onlyReport);
			jsp = MIS_RESPONSE_FOR_ADNO_BIRTH_DEATH_REPORT;
		}
		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * ------------------------------ DEATH INFORMATION
	 * REPORT----------------------------
	 * 
	 */
	public ModelAndView showDeathInformationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = DEATH_INFORMATION + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showDeathInformation(HttpServletRequest request,
			HttpServletResponse response) {
		int inpatientId = 0;
		String radioValue = null;
		String to = null;
		String info1 = "";
		String info2 = "";
		String info3 = "";

		String channel1 = "";
		String channel2 = "";
		String channel3 = "";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		if (request.getParameter(AD_NO) != null) {
			inpatientId = Integer.parseInt("" + request.getParameter(AD_NO));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			radioValue = request.getParameter(SELECTED_RADIO);
		}
		if (request.getParameter(TO) != null) {
			to = request.getParameter(TO);
		}
		if (request.getParameter(INFO1) != null) {
			info1 = request.getParameter(INFO1);
		}
		if (request.getParameter(INFO2) != null) {
			info2 = request.getParameter(INFO2);
		}
		if (request.getParameter(INFO3) != null) {
			info3 = request.getParameter(TO);
		}

		if (request.getParameter(CHANNEL1) != null) {
			channel1 = request.getParameter(CHANNEL1);
		}
		if (request.getParameter(CHANNEL2) != null) {
			channel2 = request.getParameter(CHANNEL2);
		}
		if (request.getParameter(CHANNEL3) != null) {
			channel3 = request.getParameter(CHANNEL3);
		}
		String drafterName = "";
		String rank = "";
		String name = "";
		String nok = "";
		if (request.getParameter(RANK) != null) {
			rank = request.getParameter(RANK);
		}
		if (request.getParameter(NAME) != null) {
			name = request.getParameter(NAME);
		}
		if (request.getParameter(DRAFTER_NAME) != null) {
			drafterName = request.getParameter(DRAFTER_NAME);
		}
		if (request.getParameter("nok") != null) {
			nok = request.getParameter("nok");
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap.put("inpatientId", inpatientId);
		detailsMap = misHandlerService.showDeathInformation(detailsMap);
		inpatientList = (List<Inpatient>) detailsMap.get("inpatientList");
		@SuppressWarnings("unused")
		List<ExpiryDetails> expiryDetailsList = new ArrayList<ExpiryDetails>();
		expiryDetailsList = (List<ExpiryDetails>) detailsMap
				.get("expiryDetailsList");
		String ptName = "";
		String serviceNo = "";
		String age = "";
		String doa = "";
		String toa = "";
		String expDate = "";
		String expTime = "";
		String diagnosisConclusionName = "";
		String relation = "";
		String serName = "";
		String address = "";
		if (inpatientList.size() > 0) {
			for (Inpatient inpatient : inpatientList) {
				ptName = inpatient.getHin().getPFirstName() + " "
						+ inpatient.getHin().getPMiddleName() + " "
						+ inpatient.getHin().getPLastName();
				serviceNo = inpatient.getHin().getServiceNo();
				age = inpatient.getHin().getAge();
				doa = "" + inpatient.getDateOfAddmission();
				toa = inpatient.getTimeOfAddmission();
				relation = inpatient.getHin().getRelation().getRelationName();
				serName = inpatient.getHin().getSFirstName() + " "
						+ inpatient.getHin().getSMiddleName() + " "
						+ inpatient.getHin().getSLastName();
				diagnosisConclusionName = inpatient.getInitDiagnosis();
			}
		}
		if (expiryDetailsList.size() > 0) {
			for (ExpiryDetails expiryDetails : expiryDetailsList) {
				expDate = "" + expiryDetails.getExpiryDate();
				expTime = expiryDetails.getExpiryTime();

			}
		}
		@SuppressWarnings("unused")
		String information = "DEATH INFORMATION: SERVING PERSONNEL (.) REGRET TO INFORM  "
				+ ptName
				+ " ("
				+ serviceNo
				+ ") AGED"
				+ age
				+ " YRS OF FIRST ADDRESSE ADMITTED TO ORIG ON "
				+ doa
				+ " AT "
				+ toa
				+ " HRS (.) EXPIRED ON "
				+ expDate
				+ " AT "
				+ expTime
				+ " HRS (.) DIAGNOSIS (.) "
				+ diagnosisConclusionName
				+ " NOK (.) "
				+ relation
				+ " (.) "
				+ " (.) ADDRESS(.) "
				+ address
				+ " NOK "
				+ nok
				+ " (.) ORIG TELEPHONE NO 080-25369030 EXTN 203 CMA FAX NO 080-25514406";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("information", information);
		parameters.put("info1", info1);
		parameters.put("info2", info2);
		parameters.put("info3", info3);

		parameters.put("channel1", channel1);
		parameters.put("channel2", channel2);
		parameters.put("channel3", channel3);

		if (radioValue.equals("Navy")) {
			parameters.put("line1", to);
			parameters.put("line2", "NAVAL HQ (DGMS)");
			parameters.put("line3", "AIR HQ RK PURAM, DGMS(AIR)");
			parameters.put("line4", "NAVAL HQ (DPO)");
			parameters.put("line5", "AIR HQ RK PURAM, (MED-7)");
			parameters.put("line6", "HQ SOUTHERN NAVAL COMMAND");
			parameters.put("line7", "NAVAL GROUP INSURANCE SCHEME");
			parameters.put("line8", "(SENA BHAVAN)");
			parameters.put("line7", "HQ TC IAF (Dy PMO)");
			parameters.put("line9", "NAVAL DETACHMENT IST MAIN ROAD");
			parameters.put("line10", "SK GARDENS BENSON TOWN B'LORE 46");
			parameters.put("line12", "BY D/R (BY ORIG)");
			parameters.put("line21", "BY ARMY CHANNEL");
			parameters.put("line31", "BY ARMY CHANNEL");
			parameters.put("line41", "BY ARMY CHANNEL");
			parameters.put("line51", "BY ARMY CHANNEL");
			parameters.put("line61", "BY ARMY CHANNEL");
			parameters.put("line71", "BY ARMY CHANNEL");
			parameters.put("line81", "BY D/R");
			parameters.put("line91", "BY D/R (ORIG)");
			parameters.put("line101", "");
			parameters.put("line111", "");
			parameters.put("param", "MWO KPG ILLAI");
		} else if (radioValue.equals("Army")) {
			parameters.put("line1", to);
			parameters.put("line2", "ARMY HQ (DGMS) MED DTE");
			parameters.put("line3", "AIR HQ RK RURAM, DGMS (AIR)");
			parameters.put("line4", "AIR HQ RK PURAM, (MED-7)");
			parameters.put("line5", "AGI ARMY HQ NEW DELHI");
			parameters.put("line6", "HQ TC IAF (PMO)");
			parameters.put("line7", "HQ SC PUNE(MED)");
			parameters.put("line8", "HQ ATN K & K AREA (MED)");
			parameters.put("line9", "HQ SUB AREA K & K  (COL A)");
			parameters.put("line10", "ARTY DEPOT & RECORDS NASIK RD");

			parameters.put("line12", "BY ARMY CHANNEL");

			parameters.put("line21", "BY ARMY CHANNEL");
			parameters.put("line31", "BY AF CHANNEL");
			parameters.put("line41", "BY AF CHANNEL");
			parameters.put("line51", "BY ARMY CHANNEL");
			parameters.put("line61", "BY D/R (ORIG)");
			parameters.put("line71", "BY ARMY CHANNEL");
			parameters.put("line81", "BY ARMY CHANNEL");
			parameters.put("line91", "BY D/R (ORIG)");
			parameters.put("line101", "BY ARMY CHANNEL");
			parameters.put("param", "MWO KPG PILLAI");
		} else if (radioValue.equals("airForce")) {
			parameters.put("line1", to);
			parameters.put("line2", "AIR HQ RK RURAM, DGMS (AIR)");
			parameters.put("line3", "AIR HQ RK RURAM (MED-7)");
			parameters.put("line4", "AFRO (MED WING)");
			parameters.put("line5", "AFRO (RW)");
			parameters.put("line6", "AFCAO");
			parameters.put("line7", "AFGIS");
			parameters.put("line8", "IAFBA");
			parameters.put("line9", "AFWWA (C)");
			parameters.put("line10", "HQ TC (DY PMO)");
			parameters.put("line11", "IAM");
			parameters.put("line12", "BY D/R");
			parameters.put("line21", "BY AF CHANNEL");
			parameters.put("line31", "BY AF CHANNEL");
			parameters.put("line41", "BY AF CHANNEL");
			parameters.put("line51", "BY AF CHANNEL");
			parameters.put("line61", "BY AF CHANNEL");
			parameters.put("line71", "BY AF CHANNEL");
			parameters.put("line81", "BY AF CHANNEL");
			parameters.put("line91", "BY AF CHANNEL");
			parameters.put("line101", "BY D/R");
			parameters.put("line111", "BY D/R");
			parameters.put("param", "MWO (HONY FG OFFR) KPG PILLAI");

		}
		parameters.put("name", name);
		parameters.put("rank", rank);
		parameters.put("drafterName", drafterName);
		HMSUtil.generateReport("DeathInformationReport", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	/**
	 * -------------------------- DEFICIENT / SURPLUS / ANNUAL
	 * REPORT----------------------------
	 * 
	 */
	public ModelAndView showDeficientSurplusAnnualJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = DEFICIENT_SURPLUS_ANNUAL + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showDeficientSurplusAnnual(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date toDate = null;
		Date fromDate = null;
		String selectedRadio = null;
		String selectedStatus = null;
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				selectedRadio = request.getParameter(SELECTED_RADIO);
			}

			if (request.getParameter(SELECTED_STATUS) != null
					&& !(request.getParameter(SELECTED_STATUS).equals(""))) {
				selectedStatus = request.getParameter(SELECTED_STATUS);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);		
		map.put("afmsfType", selectedRadio);
		map.put("status", selectedStatus);

		if (selectedRadio.equals("R"))
			map.put("deficient_surplus", "Deficient Employee");
		else if (selectedRadio.equals("D"))
			map.put("deficient_surplus", "Surplus Employee");
		try {
			if (selectedRadio.equals("R")) {
				HMSUtil.generateReport("deficientSurplusAnnualReport", map,
						(Connection) map.get("conn"), response,
						getServletContext());
			} else if (selectedRadio.equals("D")) {
				HMSUtil.generateReport("deficientSurplusAnnualReportStatusNo",
						map, (Connection) map.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * -------------------------- DEFICIENT / SURPLUS / ANNUAL
	 * REPORT----------------------------
	 * 
	 */
	public ModelAndView showSilDilReportJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		map = misHandlerService.showSilDilReportJsp();

		jsp = SIL_DIL_REPORT + ".jsp";

		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showSilDilReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		Date toDate = null;

		Date fromDate = null;

		String to = null;

		String to2 = null;

		String rank = null;

		String name = null;

		String drafterName = null;

		String check = null;

		String criteria = "";

		String serviceType = "";

		String serviceTypeName = "All";

		try {

			if (request.getParameter(TO_DATE) != null

			&& !(request.getParameter(TO_DATE).equals(""))) {

				toDate = HMSUtil.convertStringTypeDateToDateType(request

				.getParameter(TO_DATE));

			}

			if (request.getParameter(FROM_DATE) != null

			&& !(request.getParameter(FROM_DATE).equals(""))) {

				fromDate = HMSUtil.convertStringTypeDateToDateType(request

				.getParameter(FROM_DATE));

			}

			if (request.getParameter("to") != null

			&& !(request.getParameter("to").equals(""))) {

				to = request.getParameter("to");

			}

			if (request.getParameter("to2") != null

			&& !(request.getParameter("to2").equals(""))) {

				to2 = request.getParameter("to2");

			}

			if (request.getParameter(SERVICE_TYPE_ID) != null

			&& !(request.getParameter(SERVICE_TYPE_ID).equals(""))) {

				serviceType = request.getParameter(SERVICE_TYPE_ID);

			}

			if (request.getParameter(SERVICE_TYPE_NAME) != null

			&& !(request.getParameter(SERVICE_TYPE_NAME).equals(""))) {

				serviceTypeName = request.getParameter(SERVICE_TYPE_NAME);

			}

			if (request.getParameter("rank") != null

			&& !(request.getParameter("rank").equals(""))) {

				rank = request.getParameter("rank");

			}

			if (request.getParameter("name") != null

			&& !(request.getParameter("name").equals(""))) {

				name = request.getParameter("name");

			}

			if (request.getParameter("drafterName") != null

			&& !(request.getParameter("drafterName").equals(""))) {

				drafterName = request.getParameter("drafterName");

			}

			if (request.getParameter(SELECTED_RADIO) != null

			&& !(request.getParameter(SELECTED_RADIO).equals(""))) {

				check = request.getParameter(SELECTED_RADIO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!serviceType.equals("0")) {
			criteria = " and patient.service_type_id=" + serviceType;
		}
		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("rank", rank);
		map.put("name", name);
		map.put("drafterName", drafterName);
		map.put("to", to);
		map.put("to2", to2);
		map.put("serviceType", serviceType);
		map.put("criteria", criteria);
		map.put("formCode", serviceTypeName + " Personnel in CHAF Bangalore - 7");
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));

		if (check.equalsIgnoreCase("1")) {

			HMSUtil.generateReport("silDilReport", map, (Connection) map

			.get("conn"), response, getServletContext());

		} else if (check.equalsIgnoreCase("2")) {

			HMSUtil.generateReportInWord("silDilReport", map, (Connection) map

			.get("conn"), response, getServletContext());

		}

		return null;

	}

	/**
	 * -------------------------- FATAL CASE DOCUMENT
	 * REPORT----------------------------
	 * 
	 */
	public ModelAndView showFatalCaseReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = FATAL_CASE_REPORT + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showFatalCaseReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date toDate = null;
		Date fromDate = null;
		String to = null;
		String discharge = null;
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO) != null
					&& !(request.getParameter(TO).equals(""))) {
				to = request.getParameter(TO);
			}

			if (request.getParameter(DISCHARGE_STATUS_ID) != null
					&& !(request.getParameter(DISCHARGE_STATUS_ID).equals(""))) {
				discharge = request.getParameter(DISCHARGE_STATUS_ID);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("discharge", discharge);
		map.put("to", to);
		try {

			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport("fatalCaseReport"), map, (Connection) map
							.get("conn"));

		} catch (JRException e) {

			e.printStackTrace();
		}
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------- FRW CASES SCREEN ----------------------------
	 * 
	 */
	public ModelAndView showFrwCasesJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showFrwCases();
		jsp = FRW_CASES + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView submitFrwCases(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		int hinId = 0;
		int disposalId = 0;
		Date frwDate = null;
		String to = null;
		String toClass = null;
		String frwSerialNo = "";
		String por = null;
		String serviceNo = "";
		String sickLeave = null;
		String leaveAddress = null;
		int toUnit = 0;
		String review = null;
		Date fromDate = null;
		Date toDate = null;
		String ad_no = null;

		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals(""))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(DISPOSAL_ID) != null
				&& !(request.getParameter(DISPOSAL_ID).equals(""))) {
			disposalId = Integer.parseInt(request.getParameter(DISPOSAL_ID));
		}
		if (request.getParameter(AD_NO) != null
				&& !(request.getParameter(AD_NO).equals(""))) {
			ad_no = request.getParameter(AD_NO);
		}
		String otherHospital = "";
		if (disposalId == 12)
			if (request.getParameter(HOSPITAL_NAME) != null
					&& !(request.getParameter(HOSPITAL_NAME).equals(""))) {
				otherHospital = (request.getParameter(HOSPITAL_NAME));
			}
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			frwDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}

		if (request.getParameter(SICK_FROM_DATE) != null
				&& !(request.getParameter(SICK_FROM_DATE).equals(""))) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(SICK_FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}

		if (request.getParameter(REVIEW_AT) != null
				&& !(request.getParameter(REVIEW_AT).equals(""))) {
			review = request.getParameter(REVIEW_AT);
		}

		if (request.getParameter(TO) != null
				&& !(request.getParameter(TO).equals(""))) {
			to = request.getParameter(TO);
		}
		if (request.getParameter(CLASS) != null
				&& !(request.getParameter(CLASS).equals(""))) {
			toClass = request.getParameter(CLASS);
		}
		if (request.getParameter(FRW_SR_NO) != null
				&& !(request.getParameter(FRW_SR_NO).equals(""))) {
			frwSerialNo = (request.getParameter(FRW_SR_NO));
		}
		if (request.getParameter(POR) != null
				&& !(request.getParameter(POR).equals(""))) {
			por = request.getParameter(POR);
		}

		if (request.getParameter(SICK_LEAVE) != null
				&& !(request.getParameter(SICK_LEAVE).equals(""))) {
			sickLeave = request.getParameter(SICK_LEAVE);
		}
		if (request.getParameter("toUnit") != null
				&& !(request.getParameter("toUnit").equals(""))) {
			toUnit = Integer.parseInt(request.getParameter("toUnit"));
		}
		if (request.getParameter(LEAVE_ADDRESS) != null
				&& !(request.getParameter(LEAVE_ADDRESS).equals(""))) {
			leaveAddress = request.getParameter(LEAVE_ADDRESS);
		}

		
		generalMap.put("toUnit", toUnit);
		generalMap.put("hinId", hinId);
		generalMap.put("disposalId", disposalId);
		generalMap.put("frwDate", frwDate);
		generalMap.put("to", to);
		generalMap.put("toClass", toClass);
		generalMap.put("frwSerialNo", frwSerialNo);
		generalMap.put("por", por);
		generalMap.put("otherHospital", otherHospital);
		generalMap.put("sickLeave", sickLeave);
		generalMap.put("review", review);
		generalMap.put("fromDate", fromDate);
		generalMap.put("toDate", toDate);
		generalMap.put("leaveAddress", leaveAddress);
		generalMap.put("ad_no", ad_no);

		boolean dataUpdated = false;

		map = misHandlerService.submitFrwCases(generalMap);

		map.put("hinId", hinId);
		map.put("serviceNo", serviceNo);
		map.put("ad_no", ad_no);
		map.put("disposalId", disposalId);
		jsp = "messageForMisFrw";
		title = "updateF-1 Def";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);

		return new ModelAndView("indexB", "map", map);

	}

	// ---------- Common Method for Report ---------------------------

	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());

		return jasperReport;
	}

	/**
	 * -------------------------- Notifiable Disease entry Form ----------------
	 * 
	 * @return
	 */

	public ModelAndView showNotifiableDiseaseJsp(HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}
		//String HinId = request.getParameter("HIN_ID");
		//Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		generalMap.put("hospitalId", hospitalId);
		
		map = misHandlerService.showNotifiableDiseaseJsp(generalMap);
		jsp = "notifiableDiseas";
		jsp += ".jsp";
		title = "Notifiable Disease";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		
	}
	public ModelAndView printQtlyCounselingRecords(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		if(request.getParameter(FROM_DATE) != null){
		fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));		
		}
		if(request.getParameter(TO_DATE) != null){
		toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));		
		}
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = misHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("hospitalId",hospitalId);
		parameters.put("toDate", toDate);
		HMSUtil.generateReport("sho_counclngRecords", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null; 
		
	}
	public ModelAndView showPreventableDiseases(HttpServletRequest request,
			HttpServletResponse response) {
		String HinId = request.getParameter("HIN_ID");		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		//map = misHandlerService.showNotifiableDiseaseJsp(generalMap);
		jsp = "preventableDiseaseentry";
		jsp += ".jsp";
		title = "Preventable Disease";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showQtlyCounselingRecords(HttpServletRequest request,HttpServletResponse response)
	 {  Map<String,Object> map = new HashMap<String,Object>();
		jsp = "qtlyCounselingRecords";
		jsp += ".jsp";
		title = "QtlyCounselingRecords";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	 }
	public ModelAndView showFeedBackOfCounselor(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		//map = shoHandler.showFeedBackOfCounselor(mapDetail);
		jsp = FEEDBACK_COUNSELOR;
		jsp = jsp + ".jsp";
		title = "Feedback of Counselor Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showMonitoringOfAds(HttpServletRequest request,HttpServletResponse response)
	 { Map<String,Object> map = new HashMap<String,Object>(); 
	     //HibernateTemplate hbt = getHibernateTemplate();
	    // List<Category> categoryList = new ArrayList<Category>();
		// categoryList = getHibernateTemplate().find("from jkt.hms.masters.business.Category ");
	    map = misHandlerService.showMonitoringOfAds(map);
		jsp= "monitoringofADScases";
		title = "Monitoring Of ADS";		
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		
		return new ModelAndView("indexB","map",map);
	 }
	public ModelAndView showAutomaticChloronomes(HttpServletRequest request,
			HttpServletResponse response) {
		String HinId = request.getParameter("HIN_ID");		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		//map = misHandlerService.showNotifiableDiseaseJsp(generalMap);
		jsp = "automaticChloroforms";
		jsp += ".jsp";
		title = "Preventable Disease";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showMotorCycleJsp(HttpServletRequest request,HttpServletResponse response)
	 {
		Map<String,Object> map = new HashMap<String,Object>();
		
		/*List<Category> categoryList = new ArrayList<Category>();
		categoryList = (List<Category>) map.get("categoryList");
		*/
		try{
		map = misHandlerService.showMotorCycleJsp();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "motorcyclescooteraccidentdetails";
		jsp += ".jsp";
		title = "Motor Cycle";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	 }
	
	
	public ModelAndView showAntimalaria(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "AntiMalaria";
		jsp += ".jsp";
		title = "Anti Malaria";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map", map);
	  }

	public ModelAndView showSroEntry(HttpServletRequest request,HttpServletResponse response)
	  { 
		session= request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int departmentId = 0;		
		jsp = "sroentry";
		jsp += ".jsp";
		title = "Sro Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map", map);
	  }
	public ModelAndView showSanitaryRound(HttpServletRequest request,HttpServletResponse response)
	 {  Map<String,Object> map = new HashMap<String,Object>();
	    jsp="sanitaryround";
		jsp += ".jsp";
		title = "Sanitary Round";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	 }
	public ModelAndView showWorkloadOfMonthlyReport(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> mapForData = new HashMap<String,Object>();
		int hospitalId=0;
		int unitId=0;
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID)!= null)
		{
		    hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if(session.getAttribute(UNIT_ID)!= null)
		 {  unitId = (Integer)session.getAttribute(UNIT_ID);
		 }
		mapForData.put("hospitalId", hospitalId);
		mapForData.put("unitId", unitId);
		map= misHandlerService.getMonthlyWorkloadDetails(mapForData);			
		
		jsp="monthlyWorkload";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", "title");
		map.put("unitId", unitId);
		return new ModelAndView("indexB","map",map);
		
	}
	public ModelAndView getServiceNoDetailsForSho(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);		
		map = misHandlerService.getServiceNoDetailsForSho(box);		
		return new ModelAndView("responseForSrNoForSho", "map", map);
	}
	/*public ModelAndView getServiceNoDetailsForAccident(HttpServletRequest request, HttpServletResponse response)
	   {   
		   Map<String,Object>  map = new HashMap<String,Object>();
		   Box box = HMSUtil.getBox(request);
		   map = misHandlerService.getServiceNoDetailsForSho(box);
		   return new ModelAndView("responseForSrNoForAccident","map",map);
	   }*/
	
	
	public ModelAndView getHinNoForAttemptSucide(HttpServletRequest request, HttpServletResponse  response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String serviceNo = box.getString("flag");
		
		map = misHandlerService.getHinNoForAttemptSucide(serviceNo);
		String jsp = "misResponseForAttemptSuicide";
		
		return new ModelAndView(jsp, "map", map);
	}
	
	
	public ModelAndView getServiceNoDetailsForAttemptSucide(HttpServletRequest request,HttpServletResponse response)
	 {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		
		int hinId = 0;
		if(request.getParameter(HIN_ID)!= null && !request.getParameter(HIN_ID).equals("")){
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			
			mapForDS.put("hinId", hinId);
		}
		
		map = misHandlerService.getServiceNoDetailsForAttemptSucide(mapForDS);	
		String jsp = "responseForSrNoForAttemptSucide";
		return new ModelAndView(jsp,"map",map);
		
	 }
	public ModelAndView getServiceNoDetailsForADS(HttpServletRequest request, HttpServletResponse response)
	   { Map<String,Object> map = new HashMap<String,Object>();
		  Box box= HMSUtil.getBox(request);		  
		  map = misHandlerService.getServiceNoDetailsForADS(box);
		  return new ModelAndView("responseForSrNoForAds","map",map);
	   }
	public ModelAndView getServiceNoDetailsForMentalPhysical(HttpServletRequest request,HttpServletResponse response)
	{ Map<String,Object> map = new HashMap<String,Object>();
		Box  box = HMSUtil.getBox(request);		
		map = misHandlerService.getServiceNoDetailsForMentalPhysical(box);
		return new ModelAndView("responseForSrNoMentalPhysical","map",map);
	}
	public void getServiceNoDetailsForSanitary(HttpServletRequest request, HttpServletResponse response)
	  {  
		Box box = HMSUtil.getBox(request);
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		session = request.getSession();
		if (session.getAttribute("userName") != null)
			userName = (String) session.getAttribute("userName");
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		// --------------------------------------------------------------------------------
		
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		try {
			if (request.getParameter("serviceNo") != null) {
				serviceNo = request.getParameter("serviceNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Patient> dependentList = new ArrayList<Patient>();
		box.put("serviceNo", serviceNo);
		box.put("deptId", deptId);
		box.put("userName", userName);
		box.put("hospitalId", hospitalId);

		map = misHandlerService.getServiceNoDetailsForSanitary(box);
		if (map.get("dependentList") != null) {
			dependentList = (List<Patient>) map.get("dependentList");
		}
		String patientName="";

		StringBuffer sb = new StringBuffer();
		for (Patient patient : dependentList) {
			patientName=patient.getPFirstName();
			if(patient.getPLastName()!=null)
			{
				patientName=patientName+" "+patient.getPLastName();
			}
			
			sb.append("<item>");
			sb.append("<id>" + patient.getId() + "</id>");
			sb.append("<name>" +patientName + "</name>");
			sb.append("<designation>" +patient.getRank().getRankName() + "</designation>");
			sb.append("<branch>" +patient.getTrade().getTradeName() + "</branch>");

			
			sb.append("</item>");
			
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return new ModelAndView(jsp, "map", map);
	}

	  

	public void displayPatientInfo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = misHandlerService.getPatientInfoForVisit(box);
		List<Patient> patientList = new ArrayList<Patient>();

		if (map.get("patientList") != null) {
			patientList = (List<Patient>) map.get("patientList");
		}
		StringBuffer sb = new StringBuffer();
		if (patientList.size() > 0) {
			for (Patient patient : patientList) {
				Set<MasMedicalExamFamilyHis> familyHisSet = new HashSet<MasMedicalExamFamilyHis>();
				sb.append("<item>");
				if (patient.getTitle() != null) {
					sb.append("<title>" + patient.getTitle().getId()
							+ "</title>");
				} else {
					sb.append("<title>" + "0" + "</title>");
				}
				sb.append("<fName>" + patient.getPFirstName() + "</fName>");
				if (patient.getPMiddleName() != null) {
					sb
							.append("<mName>" + patient.getPMiddleName()
									+ "</mName>");
				} else {
					sb.append("<mName>" + "" + "</mName>");
				}
				if (patient.getPLastName() != null) {
					sb.append("<lastName>" + patient.getPLastName()
							+ "</lastName>");
				} else {
					sb.append("<lastName>" + "" + "</lastName>");
				}
				if (patient.getSex() != null) {
					sb.append("<sex>" + patient.getSex().getId() + "</sex>");
				} else {
					sb.append("<sex>" + "0" + "</sex>");
				}
				if (patient.getDateOfBirth() != null) {
					sb.append("<dob>"
							+ HMSUtil.convertDateToStringWithoutTime(patient
									.getDateOfBirth()) + "</dob>");
				} else {
					sb.append("<dob>" + "" + "</dob>");
				}
				if (patient.getAge() != null) {
					String age = patient.getAge().substring(0,
							patient.getAge().indexOf(" "));
					String ageunit = patient.getAge().substring(
							patient.getAge().indexOf(" ") + 1);
					sb.append("<age>" + age + "</age>");
					sb.append("<ageunit>" + ageunit + "</ageunit>");
				} else {
					sb.append("<age>" + "" + "</age>");
					sb.append("<ageunit>" + "" + "</ageunit>");
				}
				if (patient.getOccupation() != null) {
					sb.append("<occu>" + patient.getOccupation().getId()
							+ "</occu>");
				} else {
					sb.append("<occu>" + "0" + "</occu>");
				}
				if (patient.getMaritalStatus() != null) {
					sb.append("<mrstatus>" + patient.getMaritalStatus().getId()
							+ "</mrstatus>");
				} else {
					sb.append("<mrstatus>" + "0" + "</mrstatus>");
				}
				if (patient.getRelation() != null) {
					sb.append("<relation>" + patient.getRelation().getId()
							+ "</relation>");
				} else {
					sb.append("<relation>" + "0" + "</relation>");
				}
				if (patient.getBloodGroup() != null) {
					sb.append("<bldGrp>" + patient.getBloodGroup().getId()
							+ "</bldGrp>");
				} else {
					sb.append("<bldGrp>" + "0" + "</bldGrp>");
				}
				if (patient.getAddress() != null) {
					sb.append("<add>" + patient.getAddress() + "</add>");
				} else {
					sb.append("<add>" + "" + "</add>");
				}
				if (patient.getDistrict() != null) {
					sb.append("<district>" + patient.getDistrict().getId()
							+ "</district>");
				} else {
					sb.append("<district>" + "0" + "</district>");
				}
				if (patient.getState() != null) {
					sb.append("<state>" + patient.getState().getId()
							+ "</state>");
				} else {
					sb.append("<state>" + "0" + "</state>");
				}
				if (patient.getContactNo() != null) {
					sb.append("<contactNo>" + patient.getContactNo()
							+ "</contactNo>");
				} else {
					sb.append("<contactNo>" + "" + "</contactNo>");
				}
				if (patient.getMobileNumber() != null) {
					sb.append("<mobileNo>" + patient.getMobileNumber()
							+ "</mobileNo>");
				} else {
					sb.append("<mobileNo>" + "" + "</mobileNo>");
				}
				if (patient.getIncome() != null) {
					sb.append("<income>" + patient.getIncome() + "</income>");
				} else {
					sb.append("<income>" + "" + "</income>");
				}
				if (patient.getDependencyDate() != null) {
					sb.append("<depDate>"
							+ HMSUtil.convertDateToStringWithoutTime(patient
									.getDependencyDate()) + "</depDate>");
				} else {
					sb.append("<depDate>" + "" + "</depDate>");
				}

				int visitNo = 0;
				int lastVisitNo = 0;
				if (patient.getCurrentVisitNo() != null) {
					lastVisitNo = patient.getCurrentVisitNo();
				}
				visitNo = lastVisitNo + 1;
				sb.append("<visitNo>" + visitNo + "</visitNo>");
				sb.append("<hinNo>" + patient.getHinNo() + "</hinNo>");
				sb.append("</item>");
			}
		}
		try {
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ModelAndView showNotifiableDisease(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String adNo = null;
		int inpatientId = 0;
		session = request.getSession();
		if (request.getParameter(AD_NO) != null
				&& !(request.getParameter(AD_NO).equals(""))) {
			inpatientId = Integer.parseInt(request.getParameter(AD_NO));
		}
		session.setAttribute("adNo", adNo);
		generalMap.put("inpatientId", inpatientId);

		map = misHandlerService.showNotifiableDisease(generalMap);

		jsp = SUBMIT_NOTIFIABLE_DISEASE_JSP;
		title = "Notifiable Disease";
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitNotifiableDiseaseJsp(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int hinNumber = 0;
		//int basisOfDiagnosis = 0;
		Date dateOfOnset = new Date();
		Date dateOfReportingSick = new Date();
		Date dateOfPreventive = new Date();
		Date dateOfNotifiable = new Date();
		String designation = "";
		String suspectedsourceofinfection = "";
		String measuresOfControl = "";
		String contact = "";
		String generalRemarks = "";
		String station = "";
		String patientName = "";
		String serviceNo = "";
		String rank = "";
		String age = "";
		String unit = "";
		String lenghtofService = "";
		String residence = "";
		String Detailsofcase = "";
		String clinical = "";
		String bacteriological = "";
		String disinfection = "";
		String dateofPreventive = "";
		String genaralRemarks = "";
       int hospitalId =0;
       int departmentId = 0;
       int hinId=0;
       int opdId=0;
       
       if(session.getAttribute("hospitalId")!= null)
         {	   hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
    	            }
       if(session.getAttribute("deptId")!= null)
         {
    	   departmentId = Integer.parseInt(""+session.getAttribute("deptId"));
         }
		if (request.getParameter("hinNumber") != null
				&& !(request.getParameter("hinNumber").equals(""))) {
			hinNumber = Integer.parseInt(request.getParameter("hinNumber"));
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo =  request.getParameter(SERVICE_NO);
           
		}
		if (request.getParameter("patientName") != null
				&& !(request.getParameter("patientName").equals(""))) {
			patientName = request.getParameter("patientName");
		}
		if (request.getParameter("rank") != null
				&& !(request.getParameter("rank").equals(""))) {
			rank = request.getParameter("rank");
		}
		if (request.getParameter("age") != null
				&& !(request.getParameter("age").equals(""))) {
			age = request.getParameter("age");
		}
		if (request.getParameter("lenghtofService") != null
				&& !(request.getParameter("lenghtofService").equals(""))) {
			lenghtofService = request.getParameter("lenghtofService");
		}
		if (request.getParameter("unit/Ship") != null
				&& !(request.getParameter("unit/Ship").equals(""))) {
			unit = request.getParameter("unit/Ship");
		}
		if (request.getParameter("residence") != null
				&& !(request.getParameter("residence").equals(""))) {
			residence = request.getParameter("residence");
		}
		if (request.getParameter(DATE_OF_ONSET) != null
				&& !(request.getParameter(DATE_OF_ONSET).equals(""))) {
			dateOfOnset = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_ONSET));
		}
		if (request.getParameter(DATE_OF_REPORTING_SICK) != null
				&& !(request.getParameter(DATE_OF_REPORTING_SICK).equals(""))) {
			dateOfReportingSick = HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(DATE_OF_REPORTING_SICK));
		}
		if (request.getParameter("Detailsofcase") != null
				&& !(request.getParameter("Detailsofcase").equals(""))) {
			Detailsofcase = request.getParameter("Detailsofcase");
		}
		if (request.getParameter("clinical") != null
				&& !(request.getParameter("clinical").equals(""))) {
			clinical = request.getParameter("clinical");
		}
		if (request.getParameter("bacteriological") != null
				&& !(request.getParameter("bacteriological").equals(""))) {
			bacteriological = request.getParameter("bacteriological");
		}
		if (request.getParameter("disinfection") != null
				&& !(request.getParameter("disinfection").equals(""))) {
			disinfection = request.getParameter("disinfection");
		}
		if (request.getParameter("dateofPreventive") != null
				&& !(request.getParameter("dateofPreventive").equals(""))) {
			dateofPreventive = request.getParameter("dateofPreventive");
		}
		if (request.getParameter("contact") != null
				&& !(request.getParameter("contact").equals(""))) {
			contact = request.getParameter("contact");
		}
		if (request.getParameter("genaralRemarks") != null
				&& !(request.getParameter("genaralRemarks").equals(""))) {
			genaralRemarks = request.getParameter("genaralRemarks");
			// map= misHandlerService.submitNotifiableDiseaseJsp();
		}
		if (request.getParameter("suspectedsourceofinfection") != null
				&& !(request.getParameter("suspectedsourceofinfection").equals(""))) {
			suspectedsourceofinfection = request.getParameter("suspectedsourceofinfection");
		}
		
		if (request.getParameter(NOTIFIABLE_DATE) != null
				&& !(request.getParameter(NOTIFIABLE_DATE).equals(""))) {
			dateOfNotifiable = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(NOTIFIABLE_DATE));
		}
		
		if(request.getParameter("hinId") != null && !(request.getParameter("hinId").equals("")))
		{
			hinId=(Integer.parseInt(request.getParameter("hinId")));
		}
		
		if(request.getParameter("opdId") != null && !(request.getParameter("opdId").equals("")))
		{
			opdId=(Integer.parseInt(request.getParameter("opdId")));
		}
		
		
		map.put("hinNumber", hinNumber);
		map.put("serviceNo", serviceNo);
		map.put("patientName", patientName);
		map.put("rank", rank);
		map.put("age", age);
		map.put("lenghtofService", lenghtofService);
		map.put("unit", unit);
		map.put("residence", residence);
		map.put("dateOfOnset", dateOfOnset);
		map.put("dateOfReportingSick", dateOfReportingSick);
		map.put("Detailsofcase", Detailsofcase);
		map.put("clinical", clinical);
		map.put("bacteriological", bacteriological);
		map.put("disinfection", disinfection);
		map.put("dateofPreventive", dateofPreventive);
		map.put("genaralRemarks", genaralRemarks);
		map.put("contact", contact);
		map.put("hospitalId", hospitalId);
		map.put("departmentId", departmentId);
		map.put("dateOfNotifiable", dateOfNotifiable);
		map.put("suspectedsourceofinfection", suspectedsourceofinfection);
		map.put("hinId", hinId);
		map.put("opdId", opdId);
		
		boolean successfullyAdded = misHandlerService.submitNotifiableDiseaseJsp(map);
		
		int notifiableId = 0;
		if(map.get("notifiableId")!=null)
		{
			notifiableId= (Integer)map.get("notifiableId");
		}
		if (successfullyAdded) {
			message = "Record Added Successfully. Do You Want Print !!";
		} else {
			message = "Try Again !!";
		}
		jsp = "messageForNotificationDisease";
		title = "update Notifiable Disease";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		map.put("notifiableId", notifiableId);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView submitSmoMalariaCase(HttpServletRequest request, HttpServletResponse response)
	  { 
		 Map<String,Object> map = new HashMap<String,Object>();
		   int hospitalId =0;
	       int departmentId = 0;
	       int hinId= 0;
	       String serviceNo = "";
	       String patientName = "";
	       Date onsetDate = new Date();
	       Date admissionDate = new Date();
	       String species = "";
	       String type = "";
	       String transmission = "";
	       String forwardTo = "";
	       if(session.getAttribute("hospitalId")!= null)
	         {	   hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	    	            }
	       if(session.getAttribute("deptId")!= null)
	         {
	    	    departmentId = Integer.parseInt(""+session.getAttribute("deptId"));
	         }
	       if (request.getParameter("hinId") != null
					&& !(request.getParameter("hinId").equals(""))) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
			}
	       if(request.getParameter("serviceNo")!= null)
	         {
	    	   serviceNo = request.getParameter("serviceNo");
	         } 
	       if(request.getParameter("patientName")!= null)
	        {
	    	   patientName = request.getParameter("patientName");
	        }
	       if(request.getParameter("onsetDate")!= null)
	        {
	    	   onsetDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("onsetDate")); 
	        }
	       if(request.getParameter("admissionDate")!= null)
	        {
	    	   admissionDate = HMSUtil.dateFormatterddmmyy(request.getParameter("admissionDate"));
	        }	       
	       if(request.getParameter("species")!= null)
	         {
	    	   species = request.getParameter("species");
	         }
	       if(request.getParameter("type")!= null)
	        {
	    	   type = request.getParameter("type");
	        }
	       if(request.getParameter("transmission")!= null)
	        {
	    	   transmission = request.getParameter("transmission");
	        }
	       if(request.getParameter("forwardTo")!= null)
	         {
	    	   forwardTo = request.getParameter("forwardTo");
	         }
	       map.put("hospitalId",  hospitalId);
	       map.put("departmentId", departmentId);
	       map.put("hinId", hinId);
	       map.put("serviceNo", serviceNo);
	       map.put("patientName", patientName);
	       map.put("onsetDate", onsetDate);
	       map.put("admissionDate", admissionDate);
	       map.put("species", species);
	       map.put("type", type);
	       map.put("transmission", transmission);
	       map.put("forwardTo", forwardTo);
	       boolean successfullyAdded = misHandlerService
			.submitSmoMalariaCase(map);
	if (successfullyAdded) {
		message = "Record Forwarded Successfully  ";
	} else {
		message = "Try Again !!";
	}
	jsp = "messageForMalariaCases";
	title = "update Notifiable Disease";
	jsp += ".jsp";

	map.put("contentJsp", jsp);
    map.put("message", message);
	  
	     return new ModelAndView("indexB", "map", map);
	  }
	
	public ModelAndView submitFoodHandlerJsp(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object> map = new HashMap<String,Object>();
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
	       String patientName= "";
	       String serviceNo = "";
	       int tradeId = 0;
	       String immunization = "";
	       Date fhdate = new Date();
	       String stoolTest = "";
	       
	       session = request.getSession();
	       if(session.getAttribute("hospitalId")!= null)
	         {	   hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	    	            }
	       if(session.getAttribute("deptId")!= null)
	         {
	    	    departmentId = Integer.parseInt(""+session.getAttribute("deptId"));
	         }
	       
	       if (request.getParameter("hinId") != null && !(request.getParameter("hinId").equals(""))) 
	       {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				 
			}
	       
	       if(request.getParameter("name")!= null)
	       {
	    	   name =  request.getParameter("name"); 
	       }
	       
	       if(request.getParameter("patientName")!=null)
	       {
	    	   patientName = request.getParameter("patientName");
	       }
	       
	       if(request.getParameter("serviceNo")!= null)
	       {
	    	   serviceNo = request.getParameter("serviceNo");
	       }
	       
	       if(request.getParameter("stoolTest")!= null)
	       {
	    	   stoolTest = request.getParameter("stoolTest");
	       }
	       
	       if (request.getParameter("tradeId") != null
					&& !(request.getParameter("tradeId").equals("0"))) {
	    	   tradeId = Integer.parseInt(request.getParameter("tradeId"));
			}
	       if(request.getParameter("immunization")!= null)
	       {
	    	   immunization =  request.getParameter("immunization"); 
	       }
	       if(request.getParameter("mess")!= null)
	       {
	    	   mess =  request.getParameter("mess"); 
	       }
	       if(request.getParameter("generalExam")!= null)
	       {
	    	   generalExam = request.getParameter("generalExam");
	       }
		   
	       if(request.getParameter("nailHair")!= null)
	       {
	    	   nailHair = request.getParameter("nailHair");
	       }
            
	       if(request.getParameter("skin")!= null)
	       {
	    	   skin = request.getParameter("skin");
	       }
	       if(request.getParameter("dewormingStatus")!= null)
	       {
	    	   dewormingStatus = request.getParameter("dewormingStatus");
	       }
	       if(request.getParameter("remarksFFI")!= null)
	       {
	    	   remarksFFI = request.getParameter("remarksFFI");
	       }
	       if(request.getParameter("fhdate")!=null && !request.getParameter("fhdate").equals("")){
	    	   fhdate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("fhdate"));
	       }
	       map.put("fhdate",fhdate);
	       map.put("name", name);
	       map.put("immunization", immunization);
	       map.put("serviceNo", serviceNo);
	       map.put("tradeId", tradeId);
	       map.put("hospitalId",  hospitalId);
	       map.put("departmentId", departmentId);
	       System.out.println("map  "+hinId);
	       map.put("hinId", hinId);
	       map.put("mess", mess);
	       map.put("generalExam", generalExam);
	       map.put("nailHair", nailHair);
	       map.put("skin", skin);
	       map.put("dewormingStatus", dewormingStatus);
	       map.put("remarksFFI", remarksFFI);
	       map.put("stoolTest", stoolTest);
	       map.put("patientName", patientName);

		boolean successfullyAdded = misHandlerService.submitFoodHandlerJsp(map);
        int FhId=0;
        if(map.get("FhId")!=null)
        {
        	FhId=  (Integer) map.get("FhId");
        }
		
          if (successfullyAdded)
             {
	             message = "Record save Successfully. Do you want to Print !!  ";
             } else {
	             message = "Try Again !!";
             }
           jsp = "messageForFoodHandler";
             title = "Food Handler";
             jsp += ".jsp";

            map.put("contentJsp", jsp);
            map.put("message", message);
  
     return new ModelAndView("indexB", "map", map);
		
		
		
	  }
	
	public ModelAndView submitCaseOfAttemptSuicideJsp(HttpServletRequest request,HttpServletResponse response)
	 {  Map<String,Object> map = new HashMap<String,Object>();
	    int hospitalId =0;
        int departmentId = 0;
        int hinId=0;
        Date dateofAttempt = new Date();
        Date dateOfDeath = null;  // javed khan for  dateOfDeath not mandatory on 03-10--2013
        String timeOfAttempt = "";
        String historyofPrev ="";
        String relevantDetailsofAttp ="";
        String informationfromFamily ="";
        String firstIndividual = "";
        String secondIndividual = "";
        String thirdIndividual = "";
        String firstFamily = "";
        String secondFamily ="";
        String thirdFamily ="";
        String historyofProb ="";
        String didtheIndvProb ="";
        String responseThePerson = "";
        String ifYes ="";
        String howDoesIndv ="";
        String weatherIndvCouncl ="";
        String ifYesByWhom ="";
        String resultCouncPerson = "";
        String coUnitInfEffective = "";
        String presenceofSignDepression ="";
        String ifReferedStateOutcomeCase ="";
        String enumerateActionSuicidePrevn ="";
        String reason = "";
         if(session.getAttribute("hospitalId")!= null)
           {	 
        	 hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
  	            }
       if(session.getAttribute("deptId")!= null)
           {
  	         departmentId = Integer.parseInt(""+session.getAttribute("deptId"));
           }
		if (request.getParameter("hinId") != null
				&& !(request.getParameter("hinId").equals("")))
		  {
			   hinId = Integer.parseInt(request.getParameter("hinId"));
		   }
		if(request.getParameter("dateofAttempt") != null && !(request.getParameter("dateofAttempt").equals("")))
		 {
			dateofAttempt = HMSUtil.convertStringTypeDateToDateType(request.getParameter("dateofAttempt"));
			
		 }
		if(request.getParameter("dateOfDeath") != null && !(request.getParameter("dateOfDeath").equals("")))
		 {
			dateOfDeath = HMSUtil.convertStringTypeDateToDateType(request.getParameter("dateOfDeath"));
			
		 }
		if(request.getParameter("timeOfAttempt")!= null && !(request.getParameter("timeOfAttempt").equals("")))
		 {
			timeOfAttempt = request.getParameter("timeOfAttempt");
		 }
		if(request.getParameter("historyofPrev")!= null && !(request.getParameter("historyofPrev").equals("")))
		{
			historyofPrev = request.getParameter("historyofPrev");
		}	
		if(request.getParameter("relevantDetailsofAttp")!= null && !(request.getParameter("relevantDetailsofAttp").equals("")))
		{  relevantDetailsofAttp = request.getParameter("relevantDetailsofAttp");
			
		}
		if(request.getParameter("informationfromFamily")!= null && !(request.getParameter("informationfromFamily").equals("")))
		  {
			informationfromFamily = request.getParameter("informationfromFamily");
		  }
		if(request.getParameter("firstIndividual")!= null && !(request.getParameter("firstIndividual").equals("")))
		 {
			firstIndividual = request.getParameter("firstIndividual");
		 }
		if(request.getParameter("secondIndividual")!= null && !(request.getParameter("secondIndividual").equals("")))
		 {
			secondIndividual = request.getParameter("secondIndividual");
		 }
		if(request.getParameter("thirdIndividual")!= null && !(request.getParameter("thirdIndividual").equals("")))
		  {
			thirdIndividual = request.getParameter("thirdIndividual");
		  }
		if(request.getParameter("firstFamily")!= null && !(request.getParameter("firstFamily").equals("")))
		{
			firstFamily = request.getParameter("firstFamily");
		}
		if(request.getParameter("secondFamily")!= null && !(request.getParameter("secondFamily").equals("")))
		{
			secondFamily = request.getParameter("secondFamily");
		}
		if(request.getParameter("thirdFamily")!= null && !(request.getParameter("thirdFamily").equals("")))
		 {
			thirdFamily = request.getParameter("thirdFamily");
		 }
		if(request.getParameter("historyofProb")!= null && !(request.getParameter("historyofProb").equals("")))
		 {
			historyofProb = request.getParameter("historyofProb");
		 }
		if(request.getParameter("didtheIndvProb")!= null && !(request.getParameter("didtheIndvProb").equals("")))
		{
			didtheIndvProb = request.getParameter("didtheIndvProb");
		}
		if(request.getParameter("responseThePerson")!= null && !(request.getParameter("responseThePerson").equals("")))
		 {
			responseThePerson = request.getParameter("responseThePerson");			
		 }
		if(request.getParameter("ifYes")!= null && !(request.getParameter("ifYes").equals("")))
		 {
			ifYes = request.getParameter("ifYes");
		 }
		
		if(request.getParameter("howDoesIndv")!= null && !(request.getParameter("howDoesIndv").equals("")))
		 {
			howDoesIndv = request.getParameter("howDoesIndv");
		 }
		if(request.getParameter("weatherIndvCouncl")!= null && !(request.getParameter("weatherIndvCouncl").equals("")))
		 {
			weatherIndvCouncl = request.getParameter("weatherIndvCouncl");
		 }
		if(request.getParameter("ifYesByWhom")!= null && !(request.getParameter("ifYesByWhom").equals("")))
		 {
			ifYesByWhom = request.getParameter("ifYesByWhom");
		 }
		if(request.getParameter("resultCouncPerson")!= null && !(request.getParameter("resultCouncPerson").equals("")))
		 {
			resultCouncPerson = request.getParameter("resultCouncPerson");
		 }
		if(request.getParameter("coUnitInfEffective")!= null && !(request.getParameter("coUnitInfEffective").equals("")))
		 {
			coUnitInfEffective = request.getParameter("coUnitInfEffective");
		 }
		if(request.getParameter("presenceofSignDepression")!= null && !(request.getParameter("presenceofSignDepression").equals("")))
		 {
			presenceofSignDepression = request.getParameter("presenceofSignDepression");
		 }
		if(request.getParameter("ifReferedStateOutcomeCase")!= null && !(request.getParameter("ifReferedStateOutcomeCase").equals("")))
		 {
			ifReferedStateOutcomeCase = request.getParameter("ifReferedStateOutcomeCase");
		 }
		if(request.getParameter("enumerateActionSuicidePrevn")!= null && !(request.getParameter("enumerateActionSuicidePrevn").equals("")))
		 {
			enumerateActionSuicidePrevn = request.getParameter("enumerateActionSuicidePrevn");
		 }
		
		if(request.getParameter("reason")!= null && !(request.getParameter("reason").equals("")))
		 {
			reason = request.getParameter("reason");
		 }
		map.put("hospitalId", hospitalId);
		map.put("departmentId", departmentId);
		map.put("hinId", hinId);
		map.put("dateofAttempt", dateofAttempt);
		map.put("dateOfDeath", dateOfDeath);
		map.put("timeOfAttempt", timeOfAttempt);
		map.put("historyofPrev", historyofPrev);
		map.put("relevantDetailsofAttp",relevantDetailsofAttp);
		map.put("informationfromFamily", informationfromFamily);
		map.put("firstIndividual", firstIndividual);
		map.put("secondIndividual", secondIndividual);
		map.put("thirdIndividual", thirdIndividual);
		map.put("firstFamily", firstFamily);
		map.put("secondFamily", secondFamily);
		map.put("thirdFamily", thirdFamily);
		map.put("historyofProb", historyofProb);
		map.put("didtheIndvProb", didtheIndvProb);
		map.put("responseThePerson", responseThePerson);
		map.put("ifYes", ifYes);
		map.put("howDoesIndv", howDoesIndv);
		map.put("weatherIndvCouncl", weatherIndvCouncl);
		map.put("ifYesByWhom",ifYesByWhom);
		map.put("resultCouncPerson", resultCouncPerson);
		map.put("coUnitInfEffective", coUnitInfEffective);
		map.put("presenceofSignDepression", presenceofSignDepression);
		map.put("ifReferedStateOutcomeCase", ifReferedStateOutcomeCase);
		map.put("enumerateActionSuicidePrevn", enumerateActionSuicidePrevn);
		map.put("reason", reason);
		boolean successfullyAdded = misHandlerService.submitCaseOfAttemptSuicideJsp(map);
		int suicideId=0;
		if(map.get("suicideId") != null){
			suicideId = (Integer)map.get("suicideId");
			
		}
		if(successfullyAdded)
		 {
			message ="Record Added Successfully. Do you want to print !!";
		 } 
		else 
		 {
			message = "Try Again !!";
		 }
		jsp="messageForCaseOfAttemptSuicide";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("indexB","map",map);
		
		
	 }
	public ModelAndView submitPreventableDiseaseEntry(HttpServletRequest request,HttpServletResponse response)
	  {Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();	
		String MalariaFresh="";
		String MalariaPresent="";
		String MalariaLast="";	
		String MalariaRemarks="";
		String DiarrhoeaDysentry="";
		String DiarrhoeaPresent="";
		String DiarrhoeaLast="";
		String DiarrhoeaRemarks="";
		String InfectiousHepatitis="";
	    String InfectiousPresent="";
	    String InfectiousLast="";
	    String InfectiousRemarks="";
	    String RespiratoryGroup="";
	    String RespiratoryPresent="";
	    String RespiratoryLast="";
	    String RespiratoryRemarks="";
	    String STD="";
	    String STDPresent="";
		String STDLast="";
		String STDRemarks="";
		String Injuries="";
		String InjuriesPresent="";
		String InjuriesLast="";
		String InjuriesRemarks="";
		String flyingAccidents="";
		String gamesAccidents="";
		String twoWheelersAccidents="";
		String mechanicalTransportAccident="";
		String otherAccidents="";
		String reasonsforanyincreaseinIncident="";
		int hospitalId = 0;
	    Date preventableDate = new Date();
	    preventableDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("preventableDate"));
		MalariaFresh = request.getParameter("MalariaFresh");
		InfectiousHepatitis = request.getParameter("InfectiousHepatitis");
		 RespiratoryGroup = request.getParameter("RespiratoryGroup");
		STD = request.getParameter("STD");
		Injuries = request.getParameter("Injuries");
		DiarrhoeaDysentry = request.getParameter("DiarrhoeaDysentry");
		if(request.getParameter("preventableDate")!= null)
		{
		 preventableDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("preventableDate"));
		}
		if(session.getAttribute("hospitalId")!= null)
		  {
			hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
			
		  }
		if(request.getParameter("MalariaPresent")!= null)
		  {
			MalariaPresent= request.getParameter("MalariaPresent");				
		  }
		if(request.getParameter("MalariaLast") != null)
		  {
			MalariaLast = request.getParameter("MalariaLast");			
		  }
		if(request.getParameter("MalariaRemarks")!= null)
		   {
			MalariaRemarks =request.getParameter("MalariaRemarks");			
		   }
		if(request.getParameter("DiarrhoeaPresent")!= null)
		   {
			DiarrhoeaPresent =request.getParameter("DiarrhoeaPresent");			
		   }
		if(request.getParameter("DiarrhoeaLast")!= null)
		   {
			DiarrhoeaLast =request.getParameter("DiarrhoeaLast");
			
		   }
		if(request.getParameter("DiarrhoeaRemarks")!= null)
		   {
			DiarrhoeaRemarks =request.getParameter("DiarrhoeaRemarks");
			
		   }
		if(request.getParameter("InfectiousPresent")!= null)
		   {
			InfectiousPresent =request.getParameter("InfectiousPresent");			
		   }
		if(request.getParameter("InfectiousLast")!= null)
		   {
			InfectiousLast =request.getParameter("InfectiousLast");
			
		   }
		if(request.getParameter("InfectiousRemarks")!= null)
		   {
			InfectiousRemarks =request.getParameter("InfectiousRemarks");			
		   }
		if(request.getParameter("RespiratoryPresent")!= null)
		   {
			RespiratoryPresent =request.getParameter("RespiratoryPresent");			
		   }
		if(request.getParameter("RespiratoryLast")!= null)
		   {
			RespiratoryLast =request.getParameter("RespiratoryLast");			
		   }
		if(request.getParameter("RespiratoryRemarks")!= null)
		   {
			RespiratoryRemarks =request.getParameter("RespiratoryRemarks");			
		   }
		if(request.getParameter("STDPresent")!= null)
		   {
			STDPresent =request.getParameter("STDPresent");			
		   }
		
		if(request.getParameter("STDLast")!= null)
		   {
			STDLast =request.getParameter("STDLast");			
		   }
		
		if(request.getParameter("STDRemarks")!= null)
		   {
			STDRemarks =request.getParameter("STDRemarks");			
		   }
		if(request.getParameter("InjuriesPresent")!= null)
		   {
			InjuriesPresent =request.getParameter("InjuriesPresent");			
		   }
		if(request.getParameter("InjuriesLast")!= null)
		   {
			InjuriesLast =request.getParameter("InjuriesLast");			
		   }
		if(request.getParameter("InjuriesRemarks")!= null)
		   {
			InjuriesRemarks =request.getParameter("InjuriesRemarks");			
		   }
		if(request.getParameter("flyingAccidents")!= null)
		   {
			flyingAccidents =request.getParameter("flyingAccidents");			
		   }
		
		if(request.getParameter("gamesAccidents")!= null)
		   {
			gamesAccidents =request.getParameter("gamesAccidents");
			
		   }
		
		if(request.getParameter("twoWheelersAccidents")!= null)
		   {
			twoWheelersAccidents =request.getParameter("twoWheelersAccidents");
			
		   }
		if(request.getParameter("mechanicalTransportAccident")!= null)
		   {
			mechanicalTransportAccident =request.getParameter("mechanicalTransportAccident");
			
		   }
		if(request.getParameter("otherAccidents")!= null)
		   {
			otherAccidents =request.getParameter("otherAccidents");		
			
		   }
		if(request.getParameter("reasonsforanyincreaseinIncident")!= null)
		   {
			reasonsforanyincreaseinIncident =request.getParameter("reasonsforanyincreaseinIncident");
			
		   }
		    map.put("MalariaFresh", MalariaFresh);
		    map.put("MalariaPresent", MalariaPresent);
		    map.put("MalariaLast", MalariaLast);
		    map.put("MalariaRemarks", MalariaRemarks);
		    map.put("DiarrhoeaDysentry", DiarrhoeaDysentry);
		    map.put("DiarrhoeaPresent", DiarrhoeaPresent);
		    map.put("DiarrhoeaLast", DiarrhoeaLast);
		    map.put("DiarrhoeaRemarks", DiarrhoeaRemarks);
		    map.put("InfectiousHepatitis", InfectiousHepatitis);
		    map.put("InfectiousPresent", InfectiousPresent);
		    map.put("InfectiousLast", InfectiousLast);
		    map.put("InfectiousRemarks", InfectiousRemarks);
		    map.put("RespiratoryGroup", RespiratoryGroup);
		    map.put("RespiratoryPresent", RespiratoryPresent);
		    map.put("RespiratoryLast", RespiratoryLast);
		    map.put("RespiratoryRemarks", RespiratoryRemarks);
		    map.put("STD", STD);
		    map.put("STDPresent", STDPresent);
		    map.put("STDLast", STDLast);
		    map.put("STDRemarks", STDRemarks);
		    map.put("Injuries", Injuries);
		    map.put("InjuriesPresent", InjuriesPresent);
		    map.put("InjuriesLast", InjuriesLast);
		    map.put("InjuriesRemarks", InjuriesRemarks);
		    map.put("flyingAccidents", flyingAccidents);
		    map.put("gamesAccidents", gamesAccidents);
		    map.put("twoWheelersAccidents", twoWheelersAccidents);
		    map.put("mechanicalTransportAccident", mechanicalTransportAccident);
		    map.put("otherAccidents", otherAccidents);
		    map.put("reasonsforanyincreaseinIncident", reasonsforanyincreaseinIncident);		
		    map.put("hospitalId", hospitalId);
		    map.put("preventableDate", preventableDate);
		boolean successfullyAdded = misHandlerService.submitPreventableDiseaseEntry(map);
        if (successfullyAdded)
               {
	                  message = "Preventable Disease Entry  has been Successfully Save";
            } else {
	                message = "Try Again !!";
                 }
            jsp = "messageForPreventableDisease";
            title = "update Notifiable Disease";
            jsp += ".jsp";
           map.put("contentJsp", jsp);
           map.put("title", title);
           map.put("url", url);
           map.put("message", message);
           return new ModelAndView("indexB", "map", map);
	  }
	
	public ModelAndView submitSanitaryRoundJSP(HttpServletRequest request,HttpServletResponse response)
	 {
		Map<String,Object> map = new HashMap<String,Object>();
		String sanitarytype = "";
		Date saniatrydate = new Date();
		 String serviceNo = "";
		 String nameofSanitaryRound = "";
		 String sanitaryDesignation = "";
		 String sanitaryBranch = "";
		 String sanitaryClassification ="";
		 String sanitaryarea = "";
		 String sanitaryplace = "";
		 String sanitaryobservation = "";
		 String sanitarysuggestion = "";
		 String remarksinchargesho ="";
		 String remarkssrmedofficer ="";
		 String remasrkofficerinchargeorg = "";
		 String remarkscadmo = "";
		 int departmentId =0;
		 int hospitalId =0;
		 session = request.getSession();
		 if(session.getAttribute("hospitalId")!= null)
		 {
			 hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
			 
		 }
		 if(session.getAttribute("deptId")!= null)
		 {
			 departmentId = Integer.parseInt(""+session.getAttribute("deptId"));
			 
		 }
		if(request.getParameter("sanitarytype")!= null)
		{
			sanitarytype = request.getParameter("sanitarytype");
			 
		}
		if(request.getParameter("saniatrydate")!= null)
		  {
			saniatrydate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("saniatrydate"));
			 
		  }
		if(request.getParameter("serviceNo")!= null)
		  {
			serviceNo = request.getParameter("serviceNo");
			
		  }
		if(request.getParameter("nameofSanitaryRound")!= null)
		  {
			nameofSanitaryRound = request.getParameter("nameofSanitaryRound");
			
		  }
		if(request.getParameter("sanitaryDesignation")!= null)
		{
			sanitaryDesignation = request.getParameter("sanitaryDesignation");
			
		}
		if(request.getParameter("sanitaryBranch")!= null)
		{
			sanitaryBranch = request.getParameter("sanitaryBranch");
			
		}
		if(request.getParameter("sanitaryClassification")!= null)
		  {
			sanitaryClassification = request.getParameter("sanitaryClassification");
			System.out.println("sanitary1Classification"+sanitaryClassification);


		  }
		System.out.println("sanitary2Classification"+sanitaryClassification);
		if(request.getParameter("sanitaryarea")!= null)
		{	sanitaryarea = request.getParameter("sanitaryarea");
		System.out.println("sanitary1area"+sanitaryarea);
		}
		System.out.println("sanitary2area"+sanitaryarea);
		if(request.getParameter("sanitaryplace")!= null)
		{	sanitaryplace = request.getParameter("sanitaryplace");			
		}
		if(request.getParameter("sanitaryobservation")!= null)
		{
			sanitaryobservation = request.getParameter("sanitaryobservation");			
		}
		if(request.getParameter("sanitarysuggestion")!= null)
		{
			sanitarysuggestion = request.getParameter("sanitarysuggestion");			
		}
		if(request.getParameter("remarksinchargesho")!= null)
		{
			remarksinchargesho = request.getParameter("remarksinchargesho");			
		}
		if(request.getParameter("remarkssrmedofficer")!= null)
		{	remarkssrmedofficer = request.getParameter("remarkssrmedofficer");			
		}
		if(request.getParameter("remasrkofficerinchargeorg")!= null)
		{
			remasrkofficerinchargeorg = request.getParameter("remasrkofficerinchargeorg");			
		}
		if(request.getParameter("remarkscadmo")!= null)
		{	remarkscadmo = request.getParameter("remarkscadmo");			
		}		
		map.put("hospitalId", hospitalId);
		map.put("departmentId", departmentId);
		map.put("sanitarytype", sanitarytype);
		map.put("saniatrydate", saniatrydate);
		map.put("serviceNo", serviceNo);
		map.put("nameofSanitaryRound", nameofSanitaryRound);
		map.put("sanitaryDesignation", sanitaryDesignation);
		map.put("sanitaryBranch", sanitaryBranch);
		map.put("sanitaryClassification", sanitaryClassification);
		map.put("sanitaryarea", sanitaryarea);
		map.put("sanitaryplace", sanitaryplace);
		map.put("sanitaryobservation", sanitaryobservation);
		map.put("sanitarysuggestion", sanitarysuggestion);
		map.put("remarksinchargesho", remarksinchargesho);
		map.put("remarkssrmedofficer", remarkssrmedofficer);
		map.put("remasrkofficerinchargeorg", remasrkofficerinchargeorg);
		map.put("remarkscadmo", remarkscadmo);
		boolean successfullyAdded = misHandlerService.submitSanitaryRoundJSP(map);
		 int sanitaryId=0;
	        if(map.get("sanitaryId")!=null)
	        {
	        	sanitaryId=  (Integer) map.get("sanitaryId");
	        }
		if(successfullyAdded)
		  {
			message ="Record Added Successfully. Do you want to print !!";
		  }
		else{
			message = "Try Again !!";
		}
		jsp = "messageForsanitaryRound";
		 jsp += ".jsp";
		 title = "Sanitary Round";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB","map",map);
		
	 }
	public ModelAndView submitAutomaticChloroform(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();	
		
		String noAuthorised="";
		String noInstalled="";
		String noUSduetoMechanicaldefect="";
		String noUSduetononavailabilityofchlorinegas="";
		String noUSduetononavailabilityofcylender="";
		String noofBPdoserinstalled="";
		String noofBPdoserUS="";
		String actionTaken="";
		String remarks="";
		int hospitalId= 0;
		int departmentId = 0;
		Date chloroformEntryDate = null;
		if(session.getAttribute("deptId")!= null )
		  {
			departmentId = Integer.parseInt(""+session.getAttribute("deptId"));
		  }
		if(session.getAttribute("hospitalId")!= null )
		{
			hospitalId= Integer.parseInt(""+session.getAttribute("hospitalId"));
		}
		if(request.getParameter("noAuthorised")!= null)
		  {
			noAuthorised= request.getParameter("noAuthorised");
		  }
		if(request.getParameter("noInstalled")!= null)
		  {
			noInstalled = request.getParameter("noInstalled");
		  }
		if(request.getParameter("noUSduetoMechanicaldefect")!= null)
		  {
			noUSduetoMechanicaldefect= request.getParameter("noUSduetoMechanicaldefect");
		  }
		if(request.getParameter("noUSduetononavailabilityofchlorinegas")!= null)
		  {
			noUSduetononavailabilityofchlorinegas = request.getParameter("noUSduetononavailabilityofchlorinegas");
		  }
		if(request.getParameter("noUSduetononavailabilityofcylender")!= null)
		  {
			noUSduetononavailabilityofcylender = request.getParameter("noUSduetononavailabilityofcylender");
		  }
		if(request.getParameter("noofBPdoserinstalled")!= null)
		  {
			noofBPdoserinstalled = request.getParameter("noofBPdoserinstalled");
		  }
		if(request.getParameter("noofBPdoserUS")!= null)
		  {
			noofBPdoserUS = request.getParameter("noofBPdoserUS");
		  }
		if(request.getParameter("actionTaken")!= null)
		  {
			actionTaken = request.getParameter("actionTaken");
		  }
		if(request.getParameter("remarks")!= null)
		  {
			remarks = request.getParameter("remarks");
		  }
		if(request.getParameter("chloroformEntryDate")!= null)
		  {
			chloroformEntryDate = HMSUtil.convertStringTypeDateToDateType( request.getParameter("chloroformEntryDate")); 
		  }
		map.put("noAuthorised", noAuthorised);
		map.put("noInstalled", noInstalled);
		map.put("noUSduetoMechanicaldefect", noUSduetoMechanicaldefect);
		map.put("noUSduetononavailabilityofchlorinegas", noUSduetononavailabilityofchlorinegas);
		map.put("noUSduetononavailabilityofcylender", noUSduetononavailabilityofcylender);
		map.put("noofBPdoserinstalled", noofBPdoserinstalled);
		map.put("noofBPdoserUS",noofBPdoserUS);
		map.put("actionTaken", actionTaken);
		map.put("remarks", remarks);
		map.put("hospitalId",hospitalId);
		map.put("chloroformEntryDate", chloroformEntryDate);
		map.put("departmentId", departmentId);
		boolean successfullyAdded = misHandlerService.submitAutomaticChloroform(map);
        if (successfullyAdded)
               {
	                  message = "Automatic Chloroform Entry  has been Successfully Save & Do you want print?";
            } else {
	                message = "Try Again !!";
                 }
            jsp = "messageForAutomaticChloroform";
            title = "update Notifiable Disease";
            jsp += ".jsp";
		map.put("contentJsp", jsp);
        map.put("title", title);
        map.put("url", url);
        map.put("message", message);
        return new ModelAndView("indexB", "map", map);
	  }
	public ModelAndView submitAntiMalariaJsp(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object> map = new HashMap<String,Object>();
		session = request.getSession();	
		String Numberofrounds = "";
		String Adoption ="";
		String AntiLarval = "";
		String AntiMalariameetings ="";
		String Suppressivetreatment="";
		String Typesofcases= "";
		String SpecimenofPlasmodium ="";
		String weatherInvestigated ="";
		String Remedicalspreventing="";
		String Flyproofing ="";
		String DisposalRefuse ="";
		String Frequencyofinsecticide ="";
		String Numberofbloodslides = "";
		String Detailsoftreatment = "";
		String AntiFilarialMeasures ="";
		int hospitalId = 0;
		Date DateOfAntiMalaria =  new Date() ;
		if(request.getParameter("Numberofrounds")!= null)
		{
			Numberofrounds = request.getParameter("Numberofrounds");
		}
		if(request.getParameter("Adoption")!= null)
		{
			Adoption = request.getParameter("Adoption");
		}
		if(request.getParameter("AntiLarval")!= null)
		{
			AntiLarval = request.getParameter("AntiLarval");
		}
		if(request.getParameter("AntiMalariameetings")!= null)
		{
			AntiMalariameetings = request.getParameter("AntiMalariameetings");
		}
		if(request.getParameter("Suppressivetreatment")!= null)
		{
			Suppressivetreatment = request.getParameter("Suppressivetreatment");
		}
		if(request.getParameter("Typesofcases")!= null)
		{
			Typesofcases = request.getParameter("Typesofcases");
		}
		if(request.getParameter("SpecimenofPlasmodium")!= null)
		{
			SpecimenofPlasmodium = request.getParameter("SpecimenofPlasmodium");
		}
		if(request.getParameter("weatherInvestigated")!= null)
		{
			weatherInvestigated = request.getParameter("weatherInvestigated");
		}
		if(request.getParameter("Remedicalspreventing")!= null)
		{
			Remedicalspreventing = request.getParameter("Remedicalspreventing");
		}
		if(request.getParameter("Flyproofing")!= null)
		{
			Flyproofing = request.getParameter("Flyproofing");
		}
		if(request.getParameter("DisposalRefuse")!= null)
		{
			DisposalRefuse = request.getParameter("DisposalRefuse");
		}
		if(request.getParameter("Frequencyofinsecticide")!= null)
		{
			Frequencyofinsecticide = request.getParameter("Frequencyofinsecticide");
		}
		if(request.getParameter("Numberofbloodslides")!= null)
		{
			Numberofbloodslides = request.getParameter("Numberofbloodslides");
		}
		if(request.getParameter("Detailsoftreatment")!= null)
		{
			Detailsoftreatment = request.getParameter("Detailsoftreatment");
		}
		if(request.getParameter("AntiFilarialMeasures")!= null)
		{
			AntiFilarialMeasures = request.getParameter("AntiFilarialMeasures");
		}
		if(session.getAttribute("hospitalId")!= null)
		  {
			hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId") );
		  }
		if(request.getParameter("DATE_OF_ANTIMALARIA")!= null)
		{
			DateOfAntiMalaria = HMSUtil.convertStringTypeDateToDateType(request.getParameter("DATE_OF_ANTIMALARIA"));
		}
		
		map.put("Numberofrounds", Numberofrounds);
		map.put("Adoption", Adoption);
		map.put("AntiLarval", AntiLarval);
		map.put("AntiMalariameetings", AntiMalariameetings);
		map.put("Suppressivetreatment", Suppressivetreatment);
		map.put("Typesofcases", Typesofcases);
		map.put("SpecimenofPlasmodium", SpecimenofPlasmodium);
		map.put("weatherInvestigated", weatherInvestigated);
		map.put("Remedicalspreventing", Remedicalspreventing);
		map.put("Flyproofing", Flyproofing);
		map.put("DisposalRefuse", DisposalRefuse);
		map.put("Frequencyofinsecticide", Frequencyofinsecticide);
		map.put("Numberofbloodslides", Numberofbloodslides);
		map.put("Detailsoftreatment",Detailsoftreatment);
		map.put("AntiFilarialMeasures", AntiFilarialMeasures);
		map.put("hospitalId", hospitalId);
		map.put("DateOfAntiMalaria", DateOfAntiMalaria);
		boolean successfullyAdded = misHandlerService.submitAntiMalariaJsp(map);
        if (successfullyAdded)
               {
	                  message = "Anty Malaria Entry  has been Successfully Save";
            } else {
	                message = "Try Again !!";
                 }
            jsp = "messageForAntiMalaria";
            title = "update Notifiable Disease";
            jsp += ".jsp";
		map.put("contentJsp", jsp);
        map.put("title", title);
        map.put("url", url);
        map.put("message", message);
        return new ModelAndView("indexB", "map", map);
	  }
	public ModelAndView submitActivitiesDetails(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object> map = new HashMap<String,Object>();
		session = request.getSession();	
		String activityOfficers="";
		String activityAirmen = "";
		String activityFamilies = "";
		String activityRemarks = "";
		String activityDate = "";
		String activityDetails = "";
		int hospitalId= 0;
		int departmentId = 0;
		if(session.getAttribute("deptId")!= null)
		 {
			departmentId = Integer.parseInt(""+session.getAttribute("deptId")); 
		 }
		if(session.getAttribute("hospitalId")!= null)
		  {
			hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
			
		  }
		if(request.getParameter("activityDate")!= null)
		{
		  activityDate = request.getParameter("activityDate");		  
		}
		if(request.getParameter("activityDetails")!= null)
		{
		 activityDetails = request.getParameter("activityDetails");
		}
		if(request.getParameter("activityOfficers")!= null)
		{
		 activityOfficers = request.getParameter("activityOfficers");
		}
		if(request.getParameter("activityAirmen")!= null)
		{
		 activityAirmen = request.getParameter("activityAirmen");	
		}
		if(request.getParameter("activityFamilies")!= null)
		{
		 activityFamilies = request.getParameter("activityFamilies");
		}
		if(request.getParameter("activityRemarks")!= null)
		{
		 activityRemarks = request.getParameter("activityRemarks");
		 
		}
		    map.put("activityDate", activityDate);
		    map.put("activityDetails", activityDetails);
		    map.put("activityOfficers", activityOfficers);
		    map.put("activityAirmen", activityAirmen);
		    map.put("activityFamilies", activityFamilies);
		    map.put("activityRemarks",  activityRemarks);
		    map.put("hospitalId", hospitalId);
		    map.put("departmentId", departmentId);
		boolean successfullyAdded = misHandlerService.submitActivitiesDetails(map);
		
        if (successfullyAdded)
               {
	                  message = "ActivitiesDetails  has been Successfully Save";
            } else {
	                message = "Try Again !!";
                 }
            jsp = "messageForActivitiesDetails";
            title = "update Notifiable Disease";
            jsp += ".jsp";
		map.put("contentJsp", jsp);
        map.put("title", title);
        map.put("url", url);
        map.put("message", message);
        map.put("activityDate", activityDate);
        return new ModelAndView("indexB", "map", map);
		
	  }
	public ModelAndView submitSroEntry(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object> map = new HashMap<String,Object>();
		session = request.getSession();	
		String sroEntryDate="";
		String sroEntryTime="";
		String sanitaryRound="";
		String sroEntryPlace="";
		String sroEntryArea="";
		String sroEntryRemarks="";
		int hospitalId = 0;
		int deptId = 0;
		 if(session.getAttribute("deptId")!= null)
		 {
		  deptId = (Integer) session.getAttribute("deptId");
		 }
		
		
		if(session.getAttribute("hospitalId")!= null)
		{
			hospitalId= Integer.parseInt(""+session.getAttribute("hospitalId"));
		}
		if(request.getParameter("sroEntryDate")!= null)
		{
			sroEntryDate = request.getParameter("sroEntryDate"); 
		}
		if(request.getParameter("sroEntryTime")!= null)
		{
			sroEntryTime = request.getParameter("sroEntryTime"); 
		}
		if(request.getParameter("sanitaryRound")!= null)
		{
			sanitaryRound = request.getParameter("sanitaryRound"); 
		}
		if(request.getParameter("sroEntryPlace")!= null)
		{
			sroEntryPlace = request.getParameter("sroEntryPlace"); 
		}
		if(request.getParameter("sroEntryArea")!= null)
		{
			sroEntryArea = request.getParameter("sroEntryArea"); 
		}
		if(request.getParameter("sroEntryRemarks")!= null)
		{
			sroEntryRemarks = request.getParameter("sroEntryRemarks"); 
		}
		map.put("sroEntryDate", sroEntryDate);
		map.put("sroEntryTime", sroEntryTime);
		map.put("sanitaryRound", sanitaryRound);
		map.put("sroEntryPlace", sroEntryPlace);
		map.put("sroEntryArea", sroEntryArea);
		map.put("sroEntryRemarks", sroEntryRemarks);
		map.put("hospitalId", hospitalId);
		map.put("deptId", deptId);
		boolean successfullyAdded = misHandlerService.submitSroEntry(map);
		
        if (successfullyAdded)
               {
	                  message = "Sro Entry Details  has been Successfully Save";
            } else {
	                message = "Try Again !!";
                 }
            jsp = "messageForSroEntryDetails";
            title = "Sro Entry Sanitary";
            jsp += ".jsp";
		map.put("contentJsp", jsp);
        map.put("title", title);
        map.put("url", url);
        map.put("message", message);
        return new ModelAndView("indexB", "map", map);
	  }
	public ModelAndView submitSanitaryDefectNotes(HttpServletRequest request,HttpServletResponse response)
	 {  Map<String,Object> map = new HashMap<String,Object>();
	    session= request.getSession();
	    String sanitaryDefectDate="";
	    String sanitaryDefectTime="";
	    String sanatarydefectPlace="";
	    String sanitarydefectArea="";
	    String sanataryDefectCheckedBy="";
	    String remarkBySho="";
	    int hospitalId= 0;
	    if(session.getAttribute("hospitalId")!= null)
	    {
	    	hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	    }
	    if(request.getParameter("sanitaryDefectDate")!= null)
	      {
	    	sanitaryDefectDate= request.getParameter("sanitaryDefectDate");
	      }
	    if(request.getParameter("sanitaryDefectTime")!= null)
	      {
	    	sanitaryDefectTime= request.getParameter("sanitaryDefectTime");
	      }
	    if(request.getParameter("sanatarydefectPlace")!= null)
	      {
	    	sanatarydefectPlace= request.getParameter("sanatarydefectPlace");
	      }
	    if(request.getParameter("sanitarydefectArea")!= null)
	      {
	    	sanitarydefectArea= request.getParameter("sanitarydefectArea");
	      }
	    if(request.getParameter("sanataryDefectCheckedBy")!= null)
	      {
	    	sanataryDefectCheckedBy= request.getParameter("sanataryDefectCheckedBy");
	      }
	    if(request.getParameter("remarkBySho")!= null)
	      {
	    	remarkBySho= request.getParameter("remarkBySho");
	      }
	     map.put("sanitaryDefectDate", sanitaryDefectDate);
	     map.put("sanitaryDefectTime", sanitaryDefectTime);
	     map.put("sanatarydefectPlace", sanatarydefectPlace);
	     map.put("sanitarydefectArea", sanitarydefectArea);
	     map.put("sanataryDefectCheckedBy", sanataryDefectCheckedBy);
	     map.put("remarkBySho", remarkBySho);
	     map.put("hospitalId", hospitalId);
	     boolean successfullyAdded = misHandlerService.submitSanitaryDefectNotes(map);
	     if(successfullyAdded)
	     {
	    	 message = "SanitaryDefectNotes has been successfully save";
	     }
	     else
	      {
	    	 message= "Try Again";
	      }
	     jsp = "messageForSroEntryDetails";
         title = "Sro Entry Sanitary";
         jsp += ".jsp";
		 map.put("contentJsp", jsp);
        map.put("title", title);
        map.put("url", url);
       map.put("message", message);
       return new ModelAndView("indexB", "map", map);
	     
		
	 }
	public ModelAndView submitSchoolInspectionEntry(HttpServletRequest request,HttpServletResponse response)
	 {
		Map<String,Object> map = new HashMap<String,Object>();
		session =request.getSession();
		int hospitalId= 0;
		int departmentId=0;
		Date inspectionDate = new Date();
		String nameofSchool ="";
		String nameofInspectingPerson = "";
		String noofChildrenMedicallyExamined ="";
		String dentalCarries ="";
		String defectiveVision ="";
		String waxEar = "";
		String enlargedGlands ="";
		String other = "";
		String actiontorectifythedefects ="";
		String detailsofprotective ="";
		if(session.getAttribute("hospitalId")!= null)
		{
			hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));			
		}
		if(session.getAttribute("deptId")!= null)
		  {
			departmentId = Integer.parseInt(""+session.getAttribute("deptId"));			
		  }
		if(request.getParameter("inspectionDate")!= null)
		{ inspectionDate = HMSUtil.convertStringTypeDateToDateType( request.getParameter("inspectionDate"));			
		}
		if(request.getParameter("nameofSchool")!= null)
		 {
			nameofSchool = request.getParameter("nameofSchool");			
		 }
		if(request.getParameter("nameofInspectingPerson")!= null)
		  {		nameofInspectingPerson = request.getParameter("nameofInspectingPerson");			
		  }
		if(request.getParameter("noofChildrenMedicallyExamined")!= null)
		{	noofChildrenMedicallyExamined = request.getParameter("noofChildrenMedicallyExamined");			
		}
		if(request.getParameter("dentalCarries")!= null)
		{	dentalCarries = request.getParameter("dentalCarries");			
		}	
		if(request.getParameter("defectiveVision")!= null)
		{	defectiveVision = request.getParameter("defectiveVision");			
		}
		if(request.getParameter("waxEar")!= null)
		{	waxEar = request.getParameter("waxEar");			
		}
		if(request.getParameter("enlargedGlands")!= null)
		  {	enlargedGlands = request.getParameter("enlargedGlands");			
		  }
		if(request.getParameter("other")!= null)
		{	other = request.getParameter("other");
			
		}
		if(request.getParameter("actiontorectifythedefects")!= null)
		  {	actiontorectifythedefects = request.getParameter("actiontorectifythedefects");			
		  }
		if(request.getParameter("detailsofprotective")!= null)
		{	detailsofprotective = request.getParameter("detailsofprotective");			
		}
		map.put("hospitalId", hospitalId);
		map.put("departmentId", departmentId);
		map.put("inspectionDate",inspectionDate);
		map.put("nameofSchool", nameofSchool);
		map.put("nameofInspectingPerson", nameofInspectingPerson);
		map.put("noofChildrenMedicallyExamined", noofChildrenMedicallyExamined);
		map.put("dentalCarries", dentalCarries);
		map.put("defectiveVision", defectiveVision);
		map.put("waxEar", waxEar);
		map.put("enlargedGlands", enlargedGlands);
		map.put("other", other);
		map.put("actiontorectifythedefects", actiontorectifythedefects);
		map.put("detailsofprotective", detailsofprotective);
		 boolean successfullyAdded = misHandlerService.submitSchoolInspectionEntry(map);
		 int schInsId = 0;
		 if(map.get("schInsId")!=null)
		 {
			 schInsId = (Integer)(map.get("schInsId"));
		 }
		 if(successfullyAdded)
		   {
			 message = "Record Added Successfully. Do you want to print!!";
		   }
		 else
		    {
			   message = "Try Again!!";
		    }
		 jsp = "messageForSchoolInspection";
		 title ="School Inspection";
		 jsp += ".jsp";
		 map.put("contentJsp",jsp);
		 map.put("title", title);	
		 map.put("message", message);
		 map.put("nameofSchool", nameofSchool);
		return new ModelAndView("indexB","map",map);
	 }

	public ModelAndView submitMonitoringofADS(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object> map = new HashMap<String,Object>();
		session = request.getSession();
		int hospitalId = 0;
		int departmentId = 0;
		String serviceNo = "";
		String rank = "";
		String name ="";
		String hinId = "";
		String trade = "";
		String unit ="";
		String age= "";
		Date diagnosisDate = new Date();
		String medicalCategory = "";
		Date lastMedBoardDate = new Date(); 
		Date counsellingDate = new Date();
		String warningLetter = "";
		String retentioninService  ="";
		Date postingDate = new Date();
		String freshOld ="";
		String remarks ="";
		
		 if(session.getAttribute("hospitalId")!= null)
		 {
			 hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));			 
		 }
		 if(session.getAttribute("deptId")!= null)
		    {
			 departmentId = Integer.parseInt(""+session.getAttribute("deptId"));			 
		    }
		 if(request.getParameter("hinId") != null && !(request.getParameter("hinId").equals("")))
			{
				hinId = request.getParameter("hinId");				
			}
		if(request.getParameter("SERVICE_NO")!= null)
		{
			serviceNo = request.getParameter("SERVICE_NO");			
		}	
		if(request.getParameter("rank")!= null)
		{
			rank = request.getParameter("rank");			
		}
		if(request.getParameter("name")!= null)
		{
			name = request.getParameter("name");			
		}
		
		if(request.getParameter("trade")!= null)
		{
			trade = request.getParameter("trade");			
		}
		if(request.getParameter("unit")!= null)
		{
			unit = request.getParameter("unit");			
		}
		if(request.getParameter("age")!= null)
		{
			age = request.getParameter("age");			
		} 
		if(request.getParameter("diagnosisDate")!= null)
		{	diagnosisDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("diagnosisDate"));
					}
		if(request.getParameter("medicalCategory")!= null)
		{
			medicalCategory = request.getParameter("medicalCategory");			
		}
		if(request.getParameter("lastMedBoardDate")!= null)
		{
			lastMedBoardDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("lastMedBoardDate"));			
		}
		if(request.getParameter("counsellingDate") != null)
		{
			counsellingDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("counsellingDate"));
					}
		if(request.getParameter("warningLetter")!= null)
		{
			warningLetter = request.getParameter("warningLetter");			
		}
		if(request.getParameter("retentioninService")!= null)
		{
			retentioninService = request.getParameter("retentioninService");			
		}
		if(request.getParameter("postingDate")!= null)
		{
			postingDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("postingDate"));
					}
		if(request.getParameter("freshOld")!= null)
		{
			freshOld = request.getParameter("freshOld");			
		}
		if(request.getParameter("remarks")!= null)
		{
			remarks = request.getParameter("remarks");			
		}
		map.put("hospitalId", hospitalId);
		map.put("departmentId", departmentId);
		map.put("hinId", hinId);
		map.put("serviceNo", serviceNo);		
		map.put("age", age);
		map.put("diagnosisDate", diagnosisDate);
		map.put("medicalCategory", medicalCategory);
		map.put("lastMedBoardDate", lastMedBoardDate);
		map.put("counsellingDate", counsellingDate);
		map.put("warningLetter", warningLetter);
		map.put("retentioninService", retentioninService);
		map.put("postingDate", postingDate);
		map.put("freshOld", freshOld);
		map.put("remarks", remarks);
		boolean successfullyAdded = misHandlerService.submitMonitoringofADS(map);
		if(successfullyAdded)
		   {
			 message = "Monitoring Of ADS is Successfully Added";
		   }
		 else
		    {
			   message = "Try Again";
		    }
		 jsp = "messageForMonitaryOfADS";
		 title ="School Inspection";
		 jsp += ".jsp";
		 map.put("contentJsp",jsp);
		 map.put("title", title);	
		 map.put("message", message);
		 map.put("hinId", hinId);
		return new ModelAndView("indexB","map",map);
	  }
	public ModelAndView submitmentalPhysicalRetarded(HttpServletRequest request, HttpServletResponse response)
	 {  Map<String,Object> map = new HashMap<String,Object>();
	     session = request.getSession();
	     int hospitalId = 0;
	     int departmentId = 0;
	     String hinId = "";
	     String serviceNo ="";
	     String name = "";
	     String relation = "";
	     String rank ="";
	     String age = "";
	     String branch = "";
	     String unit ="";
	     String hospitalName = "";
	     String diagnosis = "";
	     String mentalRetarted ="";
	     String childrenName = "";
	     String ChildrenAge = "";
	     String remarks = "";
	     if(session.getAttribute("deptId")!= null )
	     {
	    	 departmentId =Integer.parseInt(""+session.getAttribute("deptId"));	    	 
	     }
	     if(session.getAttribute("hospitalId")!= null)
	     {
	    	 hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	    	     }
	     if(request.getParameter("hinId")!= null && !(request.getParameter("hinId").equals("")))
	       {
	    	 hinId =request.getParameter("hinId") ;	    	
	       }
	     if(request.getParameter("serviceNo")!= null)
	       {
	    	 serviceNo = request.getParameter("serviceNo");	    	
	       }
	     if(request.getParameter("name")!= null)
	      {
	    	 name = request.getParameter("name"); 	    	
	      }
	     if(request.getParameter("relation")!= null)
	       {
	    	 relation = request.getParameter("relation");	    	
	       }
	     if(request.getParameter("rank")!= null)
	       {
	    	 rank = request.getParameter("rank");	    	 
	       }
	     if(request.getParameter("age")!= null)
	     {
	    	 age = request.getParameter("age");
	    		     }
	     if(request.getParameter("branch")!= null)
	     {
	    	 branch = request.getParameter("branch");	    	 
	     }
	     if(request.getParameter("unit")!= null)
	       {
	    	 unit = request.getParameter("unit");	    	
	       }
	     if(request.getParameter("hospitalName")!= null)
	       {
	    	 hospitalName = request.getParameter("hospitalName");	    	
	       }
	     if(request.getParameter("diagnosis")!= null)
	     {
	    	 diagnosis = request.getParameter("diagnosis");	    	
	     }
	     if(request.getParameter("mentalRetarted")!= null)
	       {
	    	 mentalRetarted = request.getParameter("mentalRetarted");	    	 
	       }
	     if(request.getParameter("childrenName")!= null)
	     {
	    	 childrenName = request.getParameter("childrenName");	    	 
	     }
	     if(request.getParameter("ChildrenAge")!= null)
	       {
	    	 ChildrenAge = request.getParameter("ChildrenAge");	    	 
	       }
	     if(request.getParameter("remarks")!= null)
	       {
	    	 remarks = request.getParameter("remarks");	    	
	       }
	     map.put("departmentId", departmentId);
	     map.put("hospitalId", hospitalId);
	     map.put("hinId", hinId);
	     map.put("serviceNo ", serviceNo);
	     map.put("name", name);
	     map.put("relation", relation);
	     map.put("rank", rank);
	     map.put("age", age);
	     map.put("branch", branch);	    
	     map.put("unit", unit);
	     map.put("hospitalName",hospitalName);
	     map.put("diagnosis", diagnosis);
	     map.put("mentalRetarted", mentalRetarted);
	     map.put("childrenName", childrenName);
	     map.put("ChildrenAge", ChildrenAge);
	     map.put("remarks", remarks);	
	   boolean successfullyAdded= misHandlerService.submitMentalPhysicalRetarded(map);
	   if(successfullyAdded)
	    { message= "Mental &And Physical Retarded successfully save";
		   
	    }
	   else
	     {
		   message = "Try Again";
	     }
	   jsp = "messageForMentalPhysicalRetarded";
		 title ="Mental Physical";
		 jsp += ".jsp";
		 map.put("contentJsp",jsp);
		 map.put("title", title);	
		 map.put("message", message);
	     map.put("hinId", hinId);
		return new ModelAndView("index","map",map);
	 }
	public ModelAndView submitNutritionExamination(HttpServletRequest request,HttpServletResponse response)
	  { Map<String,Object> map = new HashMap<String,Object>();
	     session = request.getSession();
	     int departmentId= 0;
	     int hospitalId = 0;
	     String qualityofRation = "";
	     String stateofPersonnel = "";
	     String cookingandmessing = "";
	     String unhygienicDefects ="";
	     String meatSupplySource = "";
	     String meatquality ="";
	     String milkSupply = "";
	     String milkquality ="";
	     String remarks = "";
	     String actionTaken = "";
	     Date examinationDate = new Date();
	     
	     if(session.getAttribute("deptId")!= null)
	      {
	    	 departmentId = Integer.parseInt(""+session.getAttribute("deptId"));
	      }
		if(session.getAttribute("hospitalId")!= null)
		{
			hospitalId  = Integer.parseInt(""+session.getAttribute("hospitalId"));
		}
		if(request.getParameter("qualityofRation")!= null)
		 {
			qualityofRation = request.getParameter("qualityofRation");
		 }
		if(request.getParameter("stateofPersonnel")!= null)
		  {
			stateofPersonnel = request.getParameter("stateofPersonnel");
		  }
		if(request.getParameter("cookingandmessing")!= null)
		  {
			cookingandmessing = request.getParameter("cookingandmessing");
		  }
		if(request.getParameter("unhygienicDefects")!= null)
		{
			unhygienicDefects = request.getParameter("unhygienicDefects");
		}
		if(request.getParameter("meatSupplySource")!= null)
		  {
			meatSupplySource = request.getParameter("meatSupplySource");
		  }
		if(request.getParameter("meatquality")!= null)
		  {
			meatquality = request.getParameter("meatquality");
		  }
		if(request.getParameter("milkSupply")!= null)
		{
			milkSupply = request.getParameter("milkSupply");
		}
		if(request.getParameter("milkquality")!= null)
		{
			milkquality = request.getParameter("milkquality");
		}
		if(request.getParameter("remarks")!= null)
		{
			remarks = request.getParameter("remarks");
		}
		if(request.getParameter("actionTaken")!= null)
		  {
			actionTaken =  request.getParameter("actionTaken");
		  }
		if(request.getParameter("examinationDate")!= null)
		 {
			examinationDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("examinationDate"));
			
		 }
		 map.put("departmentId", departmentId);
		 map.put("hospitalId", hospitalId);
		 map.put("qualityofRation", qualityofRation);
		 map.put("stateofPersonnel", stateofPersonnel);
		 map.put("cookingandmessing", cookingandmessing);
		 map.put("unhygienicDefects", unhygienicDefects);
		 map.put("meatSupplySource", meatSupplySource);
		 map.put("meatquality", meatquality);
		 map.put("milkSupply", milkSupply);
		 map.put("milkquality", milkquality);
		 map.put("remarks", remarks);
		 map.put("actionTaken", actionTaken);
		 map.put("examinationDate", examinationDate);
		 boolean successfullyAdded = misHandlerService.submitNutritionExamination(map);
		 if(successfullyAdded)
		  {
			 message = "Nutrition Examination save ";
		  }
		 else
		  {
			 message = "Try Again";
		  }
		 jsp = "messageForNutritionExamination";
		 title ="Nutrition Examination";
		 jsp += ".jsp";
		 map.put("contentJsp",jsp);
		 map.put("title", title);	
		 map.put("message", message);
		 
		return new ModelAndView("index","map",map);
	  }
	public ModelAndView submitFeedbackCounselorJsp(HttpServletRequest request,HttpServletResponse response)
	 {  
	   Map<String,Object> map = new HashMap<String,Object>();
	   int departmentId = 0;
	   int hospitalId = 0;
	   String visitNo ="";
	   String name = "";
	   String qualification = "";
	   String honorarium ="";
	   String totalHours = "";
	   String address = "";
	   String avgPersonCounsled = "";
	   String typesCasesCounseled = "";
	   String noOfLecture = "";
	   String counselingDone = "";
	   String alcholism = "";
	   String recordCases = "";
	   String employmentCounselor ="";
	   String problemFaced = "";
	   String administrativeAction ="";
	   String analysisPhychological ="";
	   String changeBy = "";
	   String changeTime = "";
	   Date changeDate = new Date();
	   Date employedDate = new Date();
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
	   
	   
	   int forwardedTo=0;
	    session = request.getSession();
	    if(session.getAttribute("deptId")!= null)
	    {
	    	departmentId = Integer.parseInt(""+session.getAttribute("deptId"));
	    		    }
	    if(session.getAttribute("hospitalId")!= null)
	     {	    	hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	    		     }
	    
	    if(request.getParameter(NAME)!= null)
	    {	    	name = request.getParameter(NAME);	    	
	    }
	    if(request.getParameter("qualification") != null )
	    {	    	qualification = request.getParameter("qualification");	    	
	    }

	    if(request.getParameter(VISIT_NUMBER)!= null && !(request.getParameter(VISIT_NUMBER).equals("")) )
	    {	    	visitNo =  request.getParameter(VISIT_NUMBER);	    	
	    }
	    if(request.getParameter(ADDRESS)!= null)
	    {	    	address = request.getParameter(ADDRESS);	    	
	    }
	    if(request.getParameter("toc")!= null)
	    {    	
	    	typesCasesCounseled = request.getParameter("toc"); 	    	
	    }
	    /*if(request.getParameter(VISIT_NUMBER)!= null && !(request.getParameter(VISIT_NUMBER).equals("")) )
	    {	    	visitNo =  request.getParameter(VISIT_NUMBER);	    	
	    }*/
	    if(request.getParameter(ADDRESS)!= null)
	    {	    	address = request.getParameter(ADDRESS);	    	
	    }
	    /*if(request.getParameter("toc")!= null)
	    {    	
	    	typesCasesCounseled = request.getParameter("toc"); 	    	
	    }*/
	    if(request.getParameter("remarks")!= null)
	    {    	remarks = request.getParameter("remarks"); 	    	
	    }
	    
	    if(request.getParameter("employedDate")!= null)
	    {	    	employedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("employedDate"));	    	
	    }
	    if(request.getParameter("forwardedTo")!= null)
	    {	    	forwardedTo = Integer.parseInt(request.getParameter("forwardedTo"));	    	
	    }
	    
	    if(request.getParameter("honorariumPerMonth")!= null)
	    {    	honorariumPerMonth = request.getParameter("honorariumPerMonth"); 	    	
	    }
	    
	    if(request.getParameter("avgNoPersonCounseled")!= null)
	    {    	avgNoPersonCounseled = request.getParameter("avgNoPersonCounseled"); 	    	
	    }
	    
	    if(request.getParameter("alcoholDependence")!= null)
	    {    	alcoholDependence = request.getParameter("alcoholDependence"); 	    	
	    }
	    
	    if(request.getParameter("domesticProblems")!= null)
	    {    	domesticProblems = request.getParameter("domesticProblems"); 	    	
	    }
	    
	    
	    if(request.getParameter("educationalIssue")!= null)
	    {    	educationalIssue = request.getParameter("educationalIssue"); 	    	
	    }
	    
	    
	    if(request.getParameter("financialIssue")!= null)
	    {    	financialIssue = request.getParameter("financialIssue"); 	    	
	    }
	    
	    if(request.getParameter("interPersonalProblem")!= null)
	    {    	interPersonalProblem = request.getParameter("interPersonalProblem"); 	    	
	    }
	    
	    if(request.getParameter("serviceRelatedIssue")!= null)
	    {    	serviceRelatedIssue = request.getParameter("serviceRelatedIssue"); 	    	
	    }
	    
	    if(request.getParameter("othersSpecify")!= null)
	    {    	othersSpecify = request.getParameter("othersSpecify"); 	    	
	    }
	    
	    if(request.getParameter("casesCounseled")!= null)
	    {    	casesCounseled = request.getParameter("casesCounseled"); 	    	
	    }
	    
	    if(request.getParameter("counselingAfterWorkingHour")!= null)
	    {    	counselingAfterWorkingHour = request.getParameter("counselingAfterWorkingHour"); 	    	
	    }
	    
	    if(request.getParameter("noOfCasesPerMonth")!= null)
	    {    	noOfCasesPerMonth = request.getParameter("noOfCasesPerMonth"); 	    	
	    }
	    
	    if(request.getParameter("phNoAfterWorkingHour")!= null)
	    {    	phNoAfterWorkingHour = request.getParameter("phNoAfterWorkingHour"); 	    	
	    }
	    
	    if(request.getParameter("signature")!= null)
	    {    	signature = request.getParameter("signature"); 	    	
	    }
	    
	    
	    map.put("departmentId", departmentId);
	    map.put("hospitalId", hospitalId);
	    map.put("name", name);
	    map.put("qualification", qualification);
	    map.put("visitNo", visitNo);
	    map.put("address", address);
	    map.put("remarks", remarks);
	    map.put("employedDate", employedDate);
	    map.put("forwardedTo", forwardedTo);
	    map.put("typesCasesCounseled",typesCasesCounseled);
	    
	    map.put("honorariumPerMonth", honorariumPerMonth);
	    map.put("avgNoPersonCounseled", avgNoPersonCounseled);
	    map.put("alcoholDependence", alcoholDependence);
	    map.put("domesticProblems", domesticProblems);
	    map.put("educationalIssue", educationalIssue);
	    map.put("financialIssue", financialIssue);
	    map.put("interPersonalProblem", interPersonalProblem);
	    map.put("serviceRelatedIssue", serviceRelatedIssue);
	    map.put("othersSpecify", othersSpecify);
	    map.put("casesCounseled",casesCounseled);
	    map.put("counselingAfterWorkingHour", counselingAfterWorkingHour);
	    map.put("noOfCasesPerMonth", noOfCasesPerMonth);
	    map.put("phNoAfterWorkingHour",phNoAfterWorkingHour);
	    map.put("signature",signature);
	    
	    
		boolean successfullyAdded = misHandlerService.submitFeedbackCounselorJsp(map);
		
		int feedBackId=0;
		if(map.get("feedBackId")!=null)
		{
			feedBackId= (Integer)map.get("feedBackId");
		}
		if(successfullyAdded)
		  {
			message = "Data saved Successfully. Do you want to print!! ";
		  }
		else
		 {
			message = "Try Again !!";
		 }
		jsp = "messageForFeedbakCounseloer";
		title = "Feedback Counselor";
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		 map.put("title", title);	
		 map.put("message", message);
		 
		return new ModelAndView("index","map",map);
	 }
	public ModelAndView submitMeetingHeldAgency(HttpServletRequest request,HttpServletResponse response)
	 {  
		Map<String,Object> map = new HashMap<String,Object>();
		int departmentId = 0;
		int hospitalId = 0;
		String particularsofMeeting = "";
		Date meetingDate = new Date();
		String subjectDiscussedinMeeting = "";
		String decisionimplementedFollow = "";
		String summaryofdecisiontaken = "";
		String remarksinMeeting = "";
		session = request.getSession();
		if(session.getAttribute("deptId")!= null)
		{
			departmentId = Integer.parseInt(""+session.getAttribute("deptId"));
		}
		if(session.getAttribute("hospitalId")!= null)
		 {
			hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
		 }
		if(request.getParameter("particularsofMeeting")!= null)
		{
			particularsofMeeting = request.getParameter("particularsofMeeting");
		}
		if(request.getParameter("meetingDate")!= null)
		{
			meetingDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("meetingDate"));
		}
		if(request.getParameter("subjectDiscussedinMeeting")!= null)
		{
			subjectDiscussedinMeeting = request.getParameter("subjectDiscussedinMeeting");
		}
		if(request.getParameter("decisionimplementedFollow")!= null)
		{
			decisionimplementedFollow = request.getParameter("decisionimplementedFollow");
		}
		if(request.getParameter("summaryofdecisiontaken")!= null)
		{
			summaryofdecisiontaken = request.getParameter("summaryofdecisiontaken");
		}
		if(request.getParameter("remarksinMeeting")!= null)
		{
			remarksinMeeting = request.getParameter("remarksinMeeting");
		}
		map.put("departmentId", departmentId);
		map.put("hospitalId", hospitalId);
		map.put("particularsofMeeting", particularsofMeeting);
		map.put("meetingDate", meetingDate);
		map.put("subjectDiscussedinMeeting", subjectDiscussedinMeeting);
		map.put("decisionimplementedFollow", decisionimplementedFollow);
		map.put("summaryofdecisiontaken", summaryofdecisiontaken);
		map.put("remarksinMeeting", remarksinMeeting);
		boolean successfullyAdded = misHandlerService.submitMeetingHeldAgency(map);
		if(successfullyAdded)
		  {
			message = "Record Save Successfully Save Do you want Print?";
		  }
		else
		  {
			message = "Try Again";
		  }
		jsp = "messageForMeetingHeldAgencies";
		jsp += ".jsp";
		title = "MeetingHeldAgency";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index","map",map);
	 }
	public ModelAndView editNotifiableDisease(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String currentDate = null;
		// String currentDatetoStr = null;
		int hospitalId = 0;
		int inpatientId = 0;
		int basisOfDiagnosis = 0;
		int hinId = 0;

		String changedBy = "";
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

		// inpatientId = (Integer) session.getAttribute("inpatientId");
		hospitalId = (Integer) session.getAttribute("hospitalId");

		// hinId = (Integer) session.getAttribute("hinId");
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals(""))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		
		if (request.getParameter(NOTIFIABLE_DATE) != null
				&& !(request.getParameter(NOTIFIABLE_DATE).equals(""))) {
			dateOfNotifiable = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(NOTIFIABLE_DATE));
		}

		if (request.getParameter(DATE_OF_ONSET) != null
				&& !(request.getParameter(DATE_OF_ONSET).equals(""))) {
			dateOfOnset = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_ONSET));
		}

		if (request.getParameter(DATE_OF_REPORTING_SICK) != null
				&& !(request.getParameter(DATE_OF_REPORTING_SICK).equals(""))) {
			dateOfReportingSick = HMSUtil
					.convertStringTypeDateToDateType(request
							.getParameter(DATE_OF_REPORTING_SICK));
		}

		if (request.getParameter(DATE_OF_PREVENTIVE) != null
				&& !(request.getParameter(DATE_OF_PREVENTIVE).equals(""))) {
			dateOfPreventive = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_PREVENTIVE));
		}
		if (request.getParameter(DESIGNATION) != null
				&& !(request.getParameter(DESIGNATION).equals(""))) {
			designation = request.getParameter(DESIGNATION);
		}
		if (request.getParameter(BASIS_OF_DIAGNOSIS) != null
				&& !(request.getParameter(BASIS_OF_DIAGNOSIS).equals(""))) {
			basisOfDiagnosis = Integer.parseInt(request
					.getParameter(BASIS_OF_DIAGNOSIS));
		}
		if (request.getParameter(SUSPECTED_SOURCE_OF_INFECTION) != null
				&& !(request.getParameter(SUSPECTED_SOURCE_OF_INFECTION)
						.equals(""))) {
			suspectedSource = request
					.getParameter(SUSPECTED_SOURCE_OF_INFECTION);
		}
		if (request.getParameter(MEASURES_OF_CONTROL) != null
				&& !(request.getParameter(MEASURES_OF_CONTROL).equals(""))) {
			measuresOfControl = request.getParameter(MEASURES_OF_CONTROL);
		}
		if (request.getParameter(CONTACT) != null
				&& !(request.getParameter(CONTACT).equals(""))) {
			contact = request.getParameter(CONTACT);
		}
		if (request.getParameter(GENERAL_REMARKS) != null
				&& !(request.getParameter(GENERAL_REMARKS).equals(""))) {
			generalRemarks = request.getParameter(GENERAL_REMARKS);
		}
		if (request.getParameter(STATION) != null
				&& !(request.getParameter(STATION).equals(""))) {
			station = request.getParameter(STATION);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = request.getParameter(CHANGED_DATE);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(AD_NO) != null
				&& !(request.getParameter(AD_NO).equals(""))) {
			inpatientId = Integer.parseInt(request.getParameter(AD_NO));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		String disinfection = "";
		String bacteriological = "";
		String clinical = "";

		if (request.getParameter(DISINFECTION) != null) {
			disinfection = request.getParameter(DISINFECTION).trim();
		}
		if (request.getParameter(BACTERIOLOGICAL) != null) {
			bacteriological = request.getParameter(BACTERIOLOGICAL).trim();
		}
		if (request.getParameter(CLINICAL) != null) {
			clinical = request.getParameter(CLINICAL).trim();
		}

		generalMap.put("disinfection", disinfection);
		generalMap.put("bacteriological", bacteriological);
		generalMap.put("clinical", clinical);
		generalMap.put("dateOfOnset", dateOfOnset);
		generalMap.put("dateOfReportingSick", dateOfReportingSick);
		generalMap.put("dateOfPreventive", dateOfPreventive);
		generalMap.put("dateOfNotifiable", dateOfNotifiable);

		generalMap.put("hospitalId", hospitalId);
		generalMap.put("hinId", hinId);
		generalMap.put("inpatientId", inpatientId);
		generalMap.put("basisOfDiagnosis", basisOfDiagnosis);
		generalMap.put("suspectedSource", suspectedSource);
		generalMap.put("measuresOfControl", measuresOfControl);
		generalMap.put("contact", contact);
		generalMap.put("generalRemarks", generalRemarks);
		generalMap.put("station", station);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("designation", designation);

		boolean dataUpdated = false;
		
		dataUpdated = misHandlerService.editNotifiableDisease(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully";
		} else {
			message = "Data Cant be updated";

		}
		// url = "/hms/hms/mis?method=showAfmsfAnnualMedicalexaminationjsp";
		map = misHandlerService.showNotifiableDiseaseJsp(generalMap);

		jsp = NOTIFIABLE_DISEASE_JSP;
		title = "update Notifiable Disease";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("indexB", "map", map);

	}
	
	

	/**
	 * ------------------- Occupational Hazards (HIV/HCV/HBV) --------------
	 * --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showOccupationalHazardsjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "occupationalhazards";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showOccupationalHazards(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- Motor Cycle/Scooter Accident Details --------------
	 * --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showmotorcyclescooterAccidentdetailsjsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "motorcyclescooteraccidentdetails";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showmotorcyclescooterAccidentdetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- Case of Attempted Suicide/Suicide--------------
	 * --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showCaseofAttemptedSuicidejsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "caseofattemptedsuicide";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showMeetingHeldWithCivil(HttpServletRequest request,HttpServletResponse response)
	 { Map<String,Object> map = new HashMap<String,Object>();
		session = request.getSession();
		jsp = "meetingHeldwithAgencies";
		jsp += ".jsp";
		title="MeetingHeldWithCivil";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	 }
	public ModelAndView showCaseofAttemptedSuicide(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- Bio Medical Waste Mgt--------------
	 * --------------------------
	 * 
	 * @return
	 */
	

	public ModelAndView showBiomedicalwastemgt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- Accommodation--------------
	 * --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showAccommodationjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "accommodatio";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
 public ModelAndView showPsychoneurosisCases(HttpServletRequest request,HttpServletResponse response)
    {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "psychoneurosisCase";
		jsp += ".jsp";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

    }
	public ModelAndView showAccommodation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- Meeting Held with Agencies--------------
	 * --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showMeetingHeldwithAgenciesjsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "meetingHeldwithAgencies";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showMeetingHeldwithAgencies(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- Psy-Patient Counseling--------------
	 * --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showPsypatientcounsjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "psyPatientCouns";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showPsypatientcouns(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- Nutrition Examination--------------
	 * --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showNutritionExaminationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "nutritionExamination";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showNutritionExamination(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- Mental Physical Retarded Children--------------
	 * --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showMentalPhysicalRetardedChildrenJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "mentalPhysical";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showNutritionExamonation(HttpServletRequest request,HttpServletResponse response)
	 { Map<String,Object> map = new HashMap<String,Object>();
		session = request.getSession();
		jsp = "nutritionExamination";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB","map",map);
	 }

	public ModelAndView showMentalPhysicalRetardedChildren(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- Monitoring of ADS Cases--------------
	 * --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showMonitoringofADSCasesJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "monitoringofADScases";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showshowMonitoringofADSCases(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- School Inspection Entry--------------
	 * --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showSchoolInspectionEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "schoolInspection";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showSchoolInspectionEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}

		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- Activities Details (Health,Flight Safety,
	 * HIV/ADS)-------------- --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showActivitiesDetailsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "activitiesDetails";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showMalariaCase(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		mapForDS.put("hospitalId", hospitalId);
		if (request.getParameter("consultingDoc") != null) {
			int empId = Integer.parseInt(request.getParameter("consultingDoc"));
			mapForDS.put("empId", empId);
		}else{
			
			Users user = new Users();
			if(session.getAttribute("users")!=null){
				user = (Users)session.getAttribute("users");
				
			}
			mapForDS.put("empId", user.getEmployee().getId());
		}

		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			
			mapForDS.put("deptId", deptId);
		} else {
			deptId = (Integer) session.getAttribute("deptId");
			mapForDS.put("deptId", deptId);
		}
		
		
		map = misHandlerService.getDoctorList(mapForDS);
		jsp = "sho_MalariaCase";
		jsp = jsp + ".jsp";
		title = "Malaria Case";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showActivitiesDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- Automatic Chloroforms / Bleaching Powder Doser
	 * Entry-------------- --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showautomaticChloroformsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "automaticChloroforms";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showautomaticChloroforms(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- preventableDiseaseentry--------------
	 * 
	 * 
	 * @return
	 */
	public ModelAndView showpreventableDiseaseentryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "preventableDiseaseentry";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showpreventableDiseaseentry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- Anti Malaria/ Fly/ Filaria Measures
	 * Entry-------------- --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showAntiMalariajsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "AntiMalaria";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showAntiMalaria(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- SRO ENTRY-------------- --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showsroentryjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "sroentry";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showsroentry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- Sanitary -------------- --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showsanitarydefectsnotesjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "sanitarydefectsnotes";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showsanitarydefectsnotes(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- Sanitary round --------------
	 * --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showsanitaryroundjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "sanitaryround";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showMortalityAmongstFamiliesReport(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object> map = new HashMap<String,Object>();
		jsp = "mortalityAmongstFamilies";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB","map",map);
		
	  }

	public ModelAndView showsanitaryround(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ------------------- Dental-------------- --------------------------
	 * 
	 * @return
	 */
	public ModelAndView showdentalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "dental";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showdental(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ----------------------------------- NOTIFIABLE DISEASE REPORT
	 * --------------------------
	 * 
	 * @return
	 */

	public ModelAndView showNotifiableDiseaseReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showNotifiableDiseaseReportJsp();
		jsp = NOTIFIABLE_DISEASE_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showNotifiableDiseaseReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int inpatientId = 0;
		int icdCode = 0;
		String to = null;

		if (request.getParameter(AD_NO) != null) {
			inpatientId = Integer.parseInt(request.getParameter(AD_NO));
		}
		if (request.getParameter(BASIS_OF_DIAGNOSIS) != null) {
			icdCode = Integer
					.parseInt(request.getParameter(BASIS_OF_DIAGNOSIS));
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		byte[] bytes = null;
		parameters.put("inpatientId", inpatientId);
		parameters.put("icdId", icdCode);

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport("notifiable_report"), parameters,
					(Connection) detailsMap.get("conn"));
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {

			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------------ MALARIA CASES REPORT
	 * -----------------------
	 * 
	 * @return
	 */
	public ModelAndView showMalariaCaseReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showMalariaCaseReportJsp();
		jsp = MALARIA_CASE_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
   
	
	
	public ModelAndView showMalariaCaseReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date toDate = null;
		Date fromDate = null;
		String icdName = null;

		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(ICD_CODE) != null
					&& !(request.getParameter(ICD_CODE).equals(""))) {
				icdName = request.getParameter(ICD_CODE);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("icdName", icdName);
		try {
			map.put("SUBREPORT_DIR", getServletContext().getRealPath(
					"/reports/"));
			HMSUtil
					.generateReport("malaria_cases_report", map,
							(Connection) map.get("conn"), response,
							getServletContext());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showUploadJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		// map = misHandlerService.showBedStatisticsSummary();
		jsp = "upload";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUploadFile(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		// map = misHandlerService.showBedStatisticsSummary();
		String contentType = request.getContentType();
		
		try {
			if ((contentType != null)
					&& (contentType.indexOf("multipart/form-data") >= 0)) {
				DataInputStream in = new DataInputStream(request
						.getInputStream());
				int formDataLength = request.getContentLength();
				byte dataBytes[] = new byte[formDataLength];
				int byteRead = 0;
				int totalBytesRead = 0;

				while (totalBytesRead < formDataLength) {
					byteRead = in.read(dataBytes, totalBytesRead,
							formDataLength);
					totalBytesRead += byteRead;
				}
				String file = new String(dataBytes);
				String saveFile = file
						.substring(file.indexOf("filename=\"") + 10);
				saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
				saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,
						saveFile.indexOf("\""));
				// out.print(dataBytes);

				int lastIndex = contentType.lastIndexOf("=");
				String boundary = contentType.substring(lastIndex + 1,
						contentType.length());
				// out.println(boundary);
				int pos;
				pos = file.indexOf("filename=\"");

				pos = file.indexOf("\n", pos) + 1;

				pos = file.indexOf("\n", pos) + 1;

				pos = file.indexOf("\n", pos) + 1;

				int boundaryLocation = file.indexOf(boundary, pos) - 4;
				int startPos = ((file.substring(0, pos)).getBytes()).length;
				int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;

				FileOutputStream fileOut = new FileOutputStream(saveFile);

				// fileOut.write(dataBytes);
				fileOut.write(dataBytes, startPos, (endPos - startPos));
				fileOut.flush();
				fileOut.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// out.println("File saved as " +saveFile);

		jsp = "upload";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -------------------------------------- BIRTH DEATH REGISTER
	 * --------------------------
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	public ModelAndView showBirthDeathRegisterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		jsp = "birthDeathRegister";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showBirthDeathRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
    	Date fromDate = null;
		Date toDate = null;
		String flag = "";
		String radioValue = null;
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("BirthDeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("DeathRegister", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * -------------------------------------- MIS DAILY
	 * REPORT--------------------------
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	public ModelAndView showMisDailyReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = misHandlerService.showMisDailyReportJsp();
		jsp = MIS_DAILY_REPORT;
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showMisDailyReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date toDate = null;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		byte[] bytes = null;
		parameters.put("toDate", toDate);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));

		try {

			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport("BedStatusReport"), parameters,
					(Connection) detailsMap.get("conn"));

			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("indexB", "map", map);
	}

	// ---------------------------II Bed State-----------------------
	public ModelAndView showIIBedStateJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// session = request.getSession();
		// map = misHandlerService.showBedStatisticsSummary();		
		jsp = II_BED_STATE_JSP;
		jsp += ".jsp";
		title = "IIBedStateReport";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showIIBedStateReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		Map<String, Object> map1 = new HashMap<String, Object>();

		Date toDate = null;
		Date fromDate = null;
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();

		map.put("fromDate", fromDate);
		map.put("toDate", toDate);

		try {
			map = misHandlerService.showIIBedStateReport(map);
			map.put("PATH_TO_SUBREPORTS", getServletContext().getRealPath(
					"/reports/"));
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport("IIBedState"), map, (Connection) map
							.get("conn"));
		} catch (JRException e) {
			e.printStackTrace();
		}
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView("indexB", "map", map);

	}

	// ---------------------------Bed Statistics Summary-----------------------
	public ModelAndView showBedStatisticsReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = misHandlerService.showBedStatisticsSummary();
		jsp = BED_STATISTICS_SUMMARY_REPORT_JSP;
		jsp += ".jsp";
		title = "bedsStatisticsStatisticsReport";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchBedStatisticsReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Date toDate = null;
		Date fromDate = null;
		int searchRadio = 1;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				dataMap.put("toDate", request.getParameter(TO_DATE));
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				dataMap.put("fromDate", request.getParameter(FROM_DATE));
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		
		try {
			if (searchRadio == 1) {
				parameters = misHandlerService.bedStatisticsSummary(dataMap);

				HMSUtil.generateReport("subBedStatisticsDetail4", parameters,
						(Connection) map.get("conn"), response,
						getServletContext());
			} else if (searchRadio == 2) {
				HMSUtil.generateReport("BedStatisticsDetailNew", parameters,
						(Connection) map.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// --------------------------Daily Ward Wise Bed -/
	// Status---------------------------------
	public ModelAndView showDailyBedStatusReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = misHandlerService.showDailyBedStatusReport();
		jsp = DAILY_BED_STATUS_JSP;
		jsp += ".jsp";
		title = "dailyBedStatus";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchDailyBedStatusReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date toDate = null;
		Date fromDate = null;
		String dept = null;
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			// if (request.getParameter(FROM_DATE) != null &&
			// !(request.getParameter(FROM_DATE).equals(""))) {
			// fromDate =
			// HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			// }
			// if (request.getParameter(DEPARTMENT_ID) != null &&
			// !(request.getParameter(DEPARTMENT_ID).equals(""))) {
			// dept = request.getParameter(DEPARTMENT_ID);
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		// map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		// map.put("Ward", dept);
		HMSUtil.generateReport("DailyBedStatus", map, (Connection) map
				.get("conn"), response, getServletContext());
		return null;
	}

	// -------------------------Birth
	// Certificate------------------------------------------
	public ModelAndView showBirthCertificateJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showBirthCertificateJsp();
		String jsp = BIRTH_CERTIFICATE;
		jsp += ".jsp";
		title = "birth Certificate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showBirth(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		int hintId = 0;
		int inpatientId = 0;

		session = request.getSession();
		if (request.getParameter(INPATIENT_ID) != null
				&& !(request.getParameter(INPATIENT_ID).equals(""))) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals(""))) {
			hintId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		map = misHandlerService.showBirth(inpatientId);
		if (map.get("empAfmsfDetList") != null) {
			empAfmsfDetList = (List<EmpAfmsfDet>) map.get("empAfmsfDetList");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String year = date.substring(date.lastIndexOf("/") + 1);
		Map<String, Object> regMap = new HashMap<String, Object>();
		regMap.put("year", year);
		regMap.put("bOrD", "birth");
		String regNo = "";
		int serNo = 0;
		if (empAfmsfDetList.size() == 0) {
			// ------------------- don't delete this for Birth Auto generation

			// tempMap = misHandlerService.generateRegNumber(regMap);
			// if(tempMap.get("regNo") !=null){
			// regNo =""+tempMap.get("regNo");
			// }
			// if(tempMap.get("serNo") !=null){
			// serNo =Integer.parseInt(""+tempMap.get("serNo"));
			// }
		} else
			message = "Already added";
		jsp = BIRTH;
		map.put("contentJsp", jsp);
		map.put("regNo", regNo);		
		map.put("serNo", serNo);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitBirthCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Birthdeathreg birthdeathreg = new Birthdeathreg();
		session = request.getSession();
		String regNo = "";
		int inpatientId = 0;
		String hintNo = "";
		String patientName = "";
		String motherName = "";
		String fatherName = "";
		int sexId = 0;
		Date dob = new Date();
		Date dor = new Date();
		String gender = "";
		String lastChgBy = "";
		String lastChgTime = "";
		int noOfCopies = 0;
		int amount = 0;
		Date lastChgDate = new Date();
		int hintId = 0;
		int employeeId = 0;
		int serNo = 0;
		String addressDeath = "";
		String addressPermanent = "";
		String remarks = "";
		Date issueDate = new Date();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		if (request.getParameter(INPATIENT_ID) != null) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(PATIENT_NAME) != null) {
			patientName = request.getParameter(PATIENT_NAME);
		}
		if (request.getParameter(SEX) != null
				&& !(request.getParameter(SEX).equals(""))) {
			gender = request.getParameter(SEX);
		}
		if (request.getParameter(MOTHER_NAME) != null) {
			motherName = request.getParameter(MOTHER_NAME);
		}
		if (request.getParameter(FATHER_NAME) != null) {
			fatherName = request.getParameter(FATHER_NAME);
		}
		if (request.getParameter(DATE_OF_BIRTH) != null
				&& !(request.getParameter(DATE_OF_BIRTH).equals(""))) {
			dob = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_BIRTH));
		}
		if (request.getParameter(REG_DATE) != null
				&& !(request.getParameter(REG_DATE).equals(""))) {
			dor = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(REG_DATE));
		}
		if (request.getParameter(REG_NO) != null) {
			regNo = request.getParameter(REG_NO);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lastChgBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			lastChgDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			lastChgTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hintNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals(""))) {
			hintId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(SEX_ID) != null
				&& !(request.getParameter(SEX_ID).equals(""))) {
			sexId = Integer.parseInt(request.getParameter(SEX_ID));
		}
		if (request.getParameter("serNo") != null
				&& !(request.getParameter("serNo").equals(""))) {
			serNo = Integer.parseInt(request.getParameter("serNo"));
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(NO_OF_COPIES) != null
				&& !request.getParameter(NO_OF_COPIES).equals("")) {
			noOfCopies = Integer.parseInt(""
					+ request.getParameter(NO_OF_COPIES));
		}
		if (request.getParameter(AMOUNT) != null
				&& !request.getParameter(AMOUNT).equals("")) {
			amount = Integer.parseInt("" + request.getParameter(AMOUNT));
		}
		String time = "";
		if (request.getParameter(TIME) != null
				&& !request.getParameter(TIME).equals("")) {
			time = ("" + request.getParameter(TIME));
		}
		if (request.getParameter(ADDRESS1) != null) {
			addressDeath = request.getParameter(ADDRESS1);
		}
		if (request.getParameter(ADDRESS2) != null) {
			addressPermanent = request.getParameter(ADDRESS2);
		}
		if (request.getParameter(ISSUE_DATE) != null
				&& !(request.getParameter(ISSUE_DATE).equals(""))) {
			issueDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ISSUE_DATE));
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}
		generalMap.put("time", time);
		generalMap.put("serNo", serNo);
		generalMap.put("noOfCopies", noOfCopies);
		generalMap.put("amount", amount);
		generalMap.put("patientName", patientName);
		generalMap.put("motherName", motherName);
		generalMap.put("fatherName", fatherName);
		generalMap.put("gender", gender);
		generalMap.put("regNo", regNo);
		generalMap.put("dob", dob);
		generalMap.put("dor", dor);
		generalMap.put("gender", gender);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("lastChgBy", lastChgBy);
		generalMap.put("currentDate", lastChgDate);
		generalMap.put("currentTime", lastChgTime);
		generalMap.put("inpatientId", inpatientId);
		generalMap.put("hintNo", hintNo);
		generalMap.put("hintId", hintId);
		generalMap.put("sexId", sexId);
		generalMap.put("employeeId", employeeId);
		generalMap.put("addressDeath", addressDeath);
		generalMap.put("addressPermanent", addressPermanent);
		generalMap.put("remarks", remarks);
		generalMap.put("issueDate", issueDate);
		@SuppressWarnings("unused")
		String message;
		String messageType = "";
		generalMap = misHandlerService.addBirthCertificate(generalMap);
		message = (String) generalMap.get("isRecordAlreadyExists");
		messageType = (String) generalMap.get("messageType");
		jsp = MESSAGE_FOR_MIS_JSP;
		title = "Add birthCertificate";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("flag", "birth");
		map.put("message", message);
		map.put("messageType", messageType);
		map.put("inpatientId", inpatientId);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getMotherAdmissionNumberList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
			detailsMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			detailsMap.put("hinNo", hinNo);
		}
		List<Object> admissionNoList = new ArrayList<Object>();
		List<Object> motherHinList = new ArrayList<Object>();
		String flag = "";
		String fatalCase = "";

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (request.getParameter("fatalCase") != null) {
			fatalCase = request.getParameter("fatalCase");
			map.put("fatalCase", fatalCase);
		}
		if (flag.equals("admission")) {
			admissionNoList = misHandlerService.getAdmissionNoList(detailsMap);
			map.put("admissionNoList", admissionNoList);
			jsp = MIS_RESPONSE_FOR_ADNO_BIRTH;
		} else if (flag.equals("hin")) {
			motherHinList = misHandlerService.getMotherHin(serviceNo);
			map.put("hinNol", motherHinList);
			map.put("birthJsp", "birthJsp");
			jsp = MIS_RESPONSE_FOR_HIN_NO;
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView updateBirthCertificateJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = UPDATE_BIRTH_CERTIFICATE_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateBirthCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String regNo = null;
		int inpatientId = 0;
		if (request.getParameter(REG_NO) != null) {
			regNo = request.getParameter(REG_NO);
		}
		map.put("regNo", regNo);
		map = misHandlerService.showUpdateBirthCertificate(map);
		jsp = MIS_RESPONSE_FOR_UPDATE_BIRTH;
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView submitUpdateBirthCertificate(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Birthdeathreg birthdeathreg = new Birthdeathreg();
		@SuppressWarnings("unused")
		int birthDeathId = 0;
		String patientName = "";
		String motherName = "";
		String fatherName = "";
		int inpatientId = 0;
		String hintNo = "";
		int sexId = 0;
		Date dod = new Date();
		Date dor = new Date();
		String gender = "";
		String lastChgBy = "";
		String lastChgTime = "";
		Date lastChgDate = new Date();
		session = request.getSession();
		String addressDeath = "";
		String addressPermanent = "";
		String remarks = "";
		Date issueDate = new Date();
		int hintId = 0;
		int employeeId = 0;
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		if (request.getParameter(PATIENT_NAME) != null) {
			patientName = request.getParameter(PATIENT_NAME);
		}
		if (request.getParameter(MOTHER_NAME) != null) {
			motherName = request.getParameter(MOTHER_NAME);
		}
		if (request.getParameter(FATHER_NAME) != null) {
			fatherName = request.getParameter(FATHER_NAME);
		}
		if (request.getParameter(REG_DATE) != null
				&& !(request.getParameter(REG_DATE).equals(""))) {
			dor = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(REG_DATE));
		}
		if (request.getParameter(BIRTHDEATHID) != null) {
			birthDeathId = Integer.parseInt(request.getParameter(BIRTHDEATHID));
		}
		if (request.getParameter(ADDRESS1) != null) {
			addressDeath = request.getParameter(ADDRESS1);
		}
		if (request.getParameter(ADDRESS2) != null) {
			addressPermanent = request.getParameter(ADDRESS2);
		}
		if (request.getParameter(ISSUE_DATE) != null
				&& !(request.getParameter(ISSUE_DATE).equals(""))) {
			issueDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ISSUE_DATE));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lastChgBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			lastChgDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			lastChgTime = request.getParameter(CHANGED_TIME);
		}
		String time = "";
		if (request.getParameter(TIME) != null
				&& !(request.getParameter(TIME).equals(""))) {
			time = request.getParameter(TIME);
		}
		int noOfCopies = 0;
		int amount = 0;
		int empId = 0;
		if (request.getParameter(NO_OF_COPIES) != null
				&& !request.getParameter(NO_OF_COPIES).equals("")) {
			noOfCopies = Integer.parseInt(""
					+ request.getParameter(NO_OF_COPIES));
		}
		if (request.getParameter(AMOUNT) != null
				&& !request.getParameter(AMOUNT).equals("")) {
			amount = Integer.parseInt("" + request.getParameter(AMOUNT));
		}
		if (request.getParameter(EMPLOYEE_ID) != null) {
			empId = Integer.parseInt("" + request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter("ipId") != null) {
			inpatientId = Integer.parseInt("" + request.getParameter("ipId"));
		}

		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}
		generalMap.put("time", time);
		generalMap.put("empId", empId);
		generalMap.put("amount", amount);
		generalMap.put("noOfCopies", noOfCopies);
		generalMap.put("patientName", patientName);
		generalMap.put("motherName", motherName);
		generalMap.put("fatherName", fatherName);
		generalMap.put("remarks", remarks);
		generalMap.put("dor", dor);
		generalMap.put("lastChgBy", lastChgBy);
		generalMap.put("currentDate", lastChgDate);
		generalMap.put("currentTime", lastChgTime);
		generalMap.put("birthDeathId", birthDeathId);
		generalMap.put("addressBirth", addressDeath);
		generalMap.put("addressPermanent", addressPermanent);
		generalMap.put("issueDate", issueDate);
		@SuppressWarnings("unused")
		String message;
		String message1;

		boolean dataUpdated = false;		
		dataUpdated = misHandlerService
				.submitUpdateBirthCertificate(generalMap);
		String messageType = "";
		if (dataUpdated == true) {
			messageType = "success";
			message = "Updated Birth Certificate  Successfully";
			map.put("flag", "birth");
			map.put("inpatientId", inpatientId);

		} else {
			messageType = "failure";
			message = "Data not Saved";

		}
		map.put("message", message);
		jsp = MESSAGE_FOR_MIS_JSP;
		title = "Update Birth Cerificate";
		jsp += ".jsp";
		map.put("message", message);
		map.put("messageType", messageType);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);

		return new ModelAndView("indexB", "map", map);
	}

	// ----------------------------Death
	// Certificate----------------------------------------
	public ModelAndView showDeathCertificateJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showDeathCertificateJsp();
		String jsp = DEATH_CERTIFICATE;
		jsp += ".jsp";
		title = "death Certificate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getExpiredAdmissionNumberList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
			detailsMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			detailsMap.put("hinNo", hinNo);
		}
		List<Object> admissionNoList = new ArrayList<Object>();
		List<Object> expiredHinNo = new ArrayList<Object>();
		String flag = "";
		String fatalCase = "";

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (request.getParameter("fatalCase") != null) {
			fatalCase = request.getParameter("fatalCase");
			map.put("fatalCase", fatalCase);
		}
		if (flag.equals("admission")) {
			admissionNoList = misHandlerService
					.getExpiredAdmissionNumberList(detailsMap);
			map.put("admissionNoList", admissionNoList);
			jsp = MIS_RESPONSE_FOR_ADNO_DEATH;
		} else if (flag.equals("hin")) {
			expiredHinNo = misHandlerService.getExpiredHin(serviceNo);
			map.put("hinNoList", expiredHinNo);
			map.put("deathJsp", "deathJsp");
			jsp = MIS_RESPONSE_FOR_HIN_NO;
		}

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showDeath(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		int hintId = 0;
		int inpatientId = 0;
		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		session = request.getSession();
		if (request.getParameter(INPATIENT_ID) != null
				&& !(request.getParameter(INPATIENT_ID).equals(""))) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}		
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals(""))) {
			hintId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		map = misHandlerService.showDeath(inpatientId);
		if (map.get("empAfmsfDetList") != null) {
			empAfmsfDetList = (List<EmpAfmsfDet>) map.get("empAfmsfDetList");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String year = date.substring(date.lastIndexOf("/") + 1);
		Map<String, Object> regMap = new HashMap<String, Object>();
		regMap.put("year", year);
		regMap.put("bOrD", "death");
		String regNo = "";
		int serNo = 0;
		if (empAfmsfDetList.size() == 0) {
			// tempMap = misHandlerService.generateRegNumber(regMap);
			// if(tempMap.get("regNo") !=null){
			// regNo =""+tempMap.get("regNo");
			// }
			// if(tempMap.get("serNo") !=null){
			// serNo =Integer.parseInt(""+tempMap.get("serNo"));
			// }
		}
		if (regNo != null) {
			map.put("regNo", regNo);
		}
		jsp = DEATH;
		map.put("contentJsp", jsp);
		map.put("regNo", regNo);
		map.put("serNo", serNo);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitDeathCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Birthdeathreg birthdeathreg = new Birthdeathreg();
		@SuppressWarnings("unused")
		String regNo = "";
		int serNo = 0;
		String patientName = "";
		String motherName = "";
		String fatherName = "";
		int inpatientId = 0;
		String hintNo = "";
		int sexId = 0;
		Date dod = new Date();
		Date dor = new Date();
		String gender = "";
		String lastChgBy = "";
		String lastChgTime = "";
		Date lastChgDate = new Date();
		session = request.getSession();
		String addressDeath = "";
		String addressPermanent = "";
		String remarks = "";
		Date issueDate = new Date();
		int hintId = 0;
		int employeeId = 0;
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		if (request.getParameter(REG_NO) != null) {
			regNo = request.getParameter(REG_NO);
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(PATIENT_NAME) != null) {
			patientName = request.getParameter(PATIENT_NAME);
		}
		if (request.getParameter(MOTHER_NAME) != null) {
			motherName = request.getParameter(MOTHER_NAME);
		}
		if (request.getParameter(FATHER_NAME) != null) {
			fatherName = request.getParameter(FATHER_NAME);
		}
		if (request.getParameter(DATE_OF_DEATH) != null
				&& !(request.getParameter(DATE_OF_DEATH).equals(""))) {
			dod = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_DEATH));
		}
		if (request.getParameter(REG_DATE) != null
				&& !(request.getParameter(REG_DATE).equals(""))) {
			dor = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(REG_DATE));
		}
		if (request.getParameter(ADDRESS1) != null) {
			addressDeath = request.getParameter(ADDRESS1);
		}
		if (request.getParameter(ADDRESS2) != null) {
			addressPermanent = request.getParameter(ADDRESS2);
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}
		if (request.getParameter(ISSUE_DATE) != null
				&& !(request.getParameter(ISSUE_DATE).equals(""))) {
			issueDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ISSUE_DATE));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lastChgBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			lastChgDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			lastChgTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hintNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals(""))) {
			hintId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(SEX_ID) != null
				&& !(request.getParameter(SEX_ID).equals(""))) {
			sexId = Integer.parseInt(request.getParameter(SEX_ID));
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		int noOfCopies = 0;
		int amount = 0;
		if (request.getParameter(NO_OF_COPIES) != null
				&& !(request.getParameter(NO_OF_COPIES).equals(""))) {
			noOfCopies = Integer.parseInt(request.getParameter(NO_OF_COPIES));
		}
		if (request.getParameter(AMOUNT) != null
				&& !(request.getParameter(AMOUNT).equals(""))) {
			amount = Integer.parseInt(request.getParameter(AMOUNT));
		}
		if (request.getParameter("serNo") != null
				&& !(request.getParameter("serNo").equals(""))) {
			serNo = Integer.parseInt(request.getParameter("serNo"));
		}
		String time = "";
		if (request.getParameter(TIME) != null
				&& !(request.getParameter(TIME).equals(""))) {
			time = (request.getParameter(TIME));
		}
		generalMap.put("time", time);
		generalMap.put("serNo", serNo);
		generalMap.put("noOfCopies", noOfCopies);
		generalMap.put("amount", amount);
		generalMap.put("patientName", patientName);
		generalMap.put("motherName", motherName);
		generalMap.put("fatherName", fatherName);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("dod", dod);
		generalMap.put("gender", gender);
		generalMap.put("regNo", regNo);
		generalMap.put("addressDeath", addressDeath);
		generalMap.put("addressPermanent", addressPermanent);
		generalMap.put("remarks", remarks);
		generalMap.put("issueDate", issueDate);
		generalMap.put("dor", dor);
		generalMap.put("lastChgBy", lastChgBy);
		generalMap.put("currentDate", lastChgDate);
		generalMap.put("currentTime", lastChgTime);
		generalMap.put("inpatientId", inpatientId);
		generalMap.put("hintNo", hintNo);
		generalMap.put("hintId", hintId);
		generalMap.put("sexId", sexId);
		generalMap.put("employeeId", employeeId);
		@SuppressWarnings("unused")
		String message;
		@SuppressWarnings("unused")
		String messageType = "";
		generalMap = misHandlerService.addDeathCertificate(generalMap);
		message = (String) generalMap.get("isRecordAlreadyExists");
		messageType = (String) generalMap.get("messageType");
		jsp = MESSAGE_FOR_MIS_JSP;
		title = "Add deathCertificate";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("flag", "death");
		map.put("message", message);
		map.put("messageType", messageType);
		map.put("inpatientId", inpatientId);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateDeathCertificateJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = UPDATE_DEATH_CERTIFICATE_JSP + ".jsp";
		// map = misHandlerService.showUpdateBirthCertificate(map);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateDeathCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String regNo = null;
		int inpatientId = 0;
		if (request.getParameter(REG_NO) != null) {
			regNo = request.getParameter(REG_NO);
		}
		map.put("regNo", regNo);
		map = misHandlerService.showUpdateDeathCertificate(map);
		jsp = MIS_RESPONSE_FOR_UPDATE_DEATH;
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView submitUpdateDeathCertificate(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Birthdeathreg birthdeathreg = new Birthdeathreg();
		@SuppressWarnings("unused")
		int birthDeathId = 0;
		String patientName = "";
		String motherName = "";
		String fatherName = "";
		int inpatientId = 0;
		String hintNo = "";
		int sexId = 0;
		Date dod = new Date();
		Date dor = new Date();
		String gender = "";
		String lastChgBy = "";
		String lastChgTime = "";
		Date lastChgDate = new Date();
		session = request.getSession();
		String addressDeath = "";
		String addressPermanent = "";
		String remarks = "";
		Date issueDate = new Date();
		int hintId = 0;
		int employeeId = 0;
		String time = "";
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter(TIME) != null) {
			time = request.getParameter(TIME);
		}
		if (request.getParameter(PATIENT_NAME) != null) {
			patientName = request.getParameter(PATIENT_NAME);
		}
		if (request.getParameter(MOTHER_NAME) != null) {
			motherName = request.getParameter(MOTHER_NAME);
		}
		if (request.getParameter(FATHER_NAME) != null) {
			fatherName = request.getParameter(FATHER_NAME);
		}
		if (request.getParameter(REG_DATE) != null
				&& !(request.getParameter(REG_DATE).equals(""))) {
			dor = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(REG_DATE));
		}
		if (request.getParameter(BIRTHDEATHID) != null) {
			birthDeathId = Integer.parseInt(request.getParameter(BIRTHDEATHID));
		}
		if (request.getParameter(ADDRESS1) != null) {
			addressDeath = request.getParameter(ADDRESS1);
		}
		if (request.getParameter(ADDRESS2) != null) {
			addressPermanent = request.getParameter(ADDRESS2);
		}
		if (request.getParameter(ISSUE_DATE) != null
				&& !(request.getParameter(ISSUE_DATE).equals(""))) {
			issueDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ISSUE_DATE));
		}
		if (request.getParameter(DATE_OF_DEATH) != null
				&& !(request.getParameter(DATE_OF_DEATH).equals(""))) {
			dod = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_DEATH));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lastChgBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			lastChgDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			lastChgTime = request.getParameter(CHANGED_TIME);
		}
		int amount = 0;
		int noOfCopies = 0;
		if (request.getParameter(AMOUNT) != null) {
			amount = Integer.parseInt(request.getParameter(AMOUNT));
		}
		if (request.getParameter(NO_OF_COPIES) != null) {
			noOfCopies = Integer.parseInt(request.getParameter(NO_OF_COPIES));
		}

		if (request.getParameter("ipId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("ipId"));
		}
		generalMap.put("amount", amount);
		generalMap.put("noOfCopies", noOfCopies);
		generalMap.put("time", time);
		generalMap.put("patientName", patientName);
		generalMap.put("motherName", motherName);
		generalMap.put("fatherName", fatherName);
		generalMap.put("remarks", remarks);
		generalMap.put("dor", dor);
		generalMap.put("dod", dod);
		generalMap.put("lastChgBy", lastChgBy);
		generalMap.put("currentDate", lastChgDate);
		generalMap.put("currentTime", lastChgTime);
		generalMap.put("birthDeathId", birthDeathId);
		generalMap.put("addressDeath", addressDeath);
		generalMap.put("addressPermanent", addressPermanent);
		@SuppressWarnings("unused")
		String message;
		String message1;

		boolean dataUpdated = false;

		dataUpdated = misHandlerService
				.submitUpdateDeathCertificate(generalMap);
		String messageType = "";
		if (dataUpdated == true) {
			messageType = "success";
			message = "Updated Death Certificate Successfully";
			map.put("inpatientId", inpatientId);
			map.put("flag", "death");
		} else {
			messageType = "failure";
			message = "Data not Saved";

		}
		map.put("message", message);
		jsp = MESSAGE_FOR_MIS_JSP;
		title = "Update Birth Cerificate";
		jsp += ".jsp";
		map.put("messageType", messageType);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);

		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ------------------------ Birth/Death Certificate Report*
	 * --------------------------
	 */
	public ModelAndView showBirthDeathCertificateJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = BIRTH_DEATH_CERTIFICATE + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showBirthDeathCertificate2(HttpServletRequest request,
			HttpServletResponse response) {
		
		@SuppressWarnings("unused")
		Map<String, Object> map = new HashMap<String, Object>();
		String flag = "";
		int inpatientId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(AD_NO) != null) {
			inpatientId = Integer.parseInt(request.getParameter(AD_NO));
		}
		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("inpatientId", inpatientId);

		try {
			if (flag.equals("birth")) {
				HMSUtil.generateReport("birth_certificate", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (flag.equals("death")) {
				HMSUtil.generateReport("death_certificate", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// =====================Added at bangalore===================
	public ModelAndView showDailyBedStats(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = null;
		session = request.getSession();
		// map = misHandlerService.showTotalAdmissionjsp();
		jsp = DAILY_BED_STATS;
		jsp += ".jsp";
		title = "Total Admission";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printDailyBedStats(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		@SuppressWarnings("unused")
		Date currDate = null;
		int serviceTypeId = 0;
		int departmentId = 0;
		String stringVariable = "";
		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName = "SilDil_As_On_Main";
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		parameters.put("toDate", toDate);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = misHandlerService.getConnectionForReport();
		try {
			byte bytes[] = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("DailyBedStatus"), parameters,
						(Connection) detailsMap.get("conn"));
			} catch (JRException e) {
				e.printStackTrace();
			}

			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("indexB", "map", map);
	}

	public void checkRegNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String regNo = "";
		String exists = "no";
		String type = "";
		if (request.getParameter("regNo") != null) {
			regNo = (request.getParameter("regNo"));
		}
		if (request.getParameter("type") != null) {
			type = (request.getParameter("type"));
		}
		dataMap.put("regNo", regNo);
		dataMap.put("type", type);
		map = misHandlerService.chechBed(dataMap);
		if (map.get("exists") != null) {
			exists = "" + map.get("exists");
		}
		StringBuffer sb = new StringBuffer();

		sb.append("<item>");
		
		sb.append("<exists>" + exists + "</exists>");
		sb.append("</item>");

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			// sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView printBirthDeathCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int ipId = 0;
		String flag = "";
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			ipId = Integer.parseInt("" + request.getParameter(FROM_DATE));
		}

		if (request.getParameter(SELECTED_RADIO) != null) {
			flag = request.getParameter(SELECTED_RADIO);
		}
		detailsMap = misHandlerService.getDBConnection();
		Map<String, Object> parameters = new HashMap<String, Object>();
		byte[] bytes = null;
		parameters.put("inpatientId", ipId);
		try {
			if (flag.equals("birth")) {

				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("birth_certificate"), parameters,
						(Connection) detailsMap.get("conn"));

			} else if (flag.equals("death")) {

				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("death_certificate"), parameters,
						(Connection) detailsMap.get("conn"));
			}

			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JRException e) {

			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printBDCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int inpatientId = 0;
		int dischargeId = 0;
		String bOrD = "";
		String formate = "old";
		try {
			
			// request.getParameter(AD_NO));
			if (request.getParameter(AD_NO) != null) {
				inpatientId = Integer.parseInt(request.getParameter(AD_NO));
			}
			if (request.getParameter("selectedRadio") != null) {
				bOrD = (request.getParameter("selectedRadio"));
			}

			if (request.getParameter("formate") != null) {
				formate = (request.getParameter("formate"));
			}

			
			parameters.put("inpatientId", inpatientId);
			detailsMap = misHandlerService.getConnectionForReport();			
			if (bOrD.equalsIgnoreCase("birth")) {
				HMSUtil.generateReport("birth_certificate_new", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
				/*
				 * if (formate.equals("new")) {
				 * HMSUtil.generateReport("b_new_certificate1", parameters,
				 * (Connection) detailsMap.get("conn"), response,
				 * getServletContext()); } else {
				 * HMSUtil.generateReport("b_certificate", parameters,
				 * (Connection) detailsMap.get("conn"), response,
				 * getServletContext()); }
				 */
			} else if (bOrD.equalsIgnoreCase("death")) {
				HMSUtil.generateReport("death_certificate_new", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
				/*
				 * HMSUtil.generateReport("d_certificate", parameters,
				 * (Connection) detailsMap.get("conn"), response,
				 * getServletContext());
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ModelAndView getPatientDetailForMalaria(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String hinNo = "";
		
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			mapForDS.put("hinNo", hinNo);
		}

		Map<String,Object> map = new HashMap<String,Object>();
		
		map = misHandlerService.getPatientDetailForMalaria(mapForDS);
		
		String jsp = "populatePatientDetailForMalaria";
		//map.put("patientList", patientList);		
		return new ModelAndView(jsp, "map", map);
	}	
	
	public ModelAndView getPatientDetailForFoodHandler(HttpServletRequest request,HttpServletResponse response)
	   {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String hinNo = "";
		
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			mapForDS.put("hinNo", hinNo);
		}

		Map<String,Object> map = new HashMap<String,Object>();
		
		map = misHandlerService.getPatientDetailForMalaria(mapForDS);
		
		String jsp = "populatePatientDetailForFoodHandler";
		//map.put("patientList", patientList);		
		return new ModelAndView(jsp, "map", map);
		
	   }
	
	/*public ModelAndView getPatientDetailForNotifiableDisease(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String hinNo = "";
		
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			mapForDS.put("hinNo", hinNo);
		}

		Map<String,Object> map = new HashMap<String,Object>();
		
		map = misHandlerService.getPatientDetailForMalaria(mapForDS);
		
		String jsp = "populatePatientDetailForNotifiableDisease";
		//map.put("patientList", patientList);		
		return new ModelAndView(jsp, "map", map);
	}	
		*/
	

	public ModelAndView getHinAdNoDetailsFatalCase(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		int hinId = 0;
		try {
			if (request.getParameter(SERVICE_NO) != null) {
				serviceNo = request.getParameter(SERVICE_NO);
				detailsMap.put("serviceNo", serviceNo);
			}
			
			if (request.getParameter(HIN_ID) != null
					&& !request.getParameter(HIN_ID).equals("")) {

				hinId = Integer.parseInt("" + request.getParameter(HIN_ID));
				detailsMap.put("hinId", hinId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String flag = "";

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (flag.equals("admission")) {
			map = misHandlerService.getHinAdNoDetailsFatalCase(detailsMap);
			map.put("flag", flag);
			jsp = MIS_RESPONSE_FOR_FATAl_HIN_ADNO;
		} else if (flag.equals("hin")) {
			map = misHandlerService.getHinAdNoDetailsFatalCase(detailsMap);
			map.put("flag", flag);
			jsp = MIS_RESPONSE_FOR_FATAl_HIN_ADNO;
		}
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Patient> patientList = new ArrayList<Patient>();

		if (map.get("inpatientList") != null)
			inpatientList = (List<Inpatient>) map.get("inpatientList");
		if (map.get("patientList") != null)
			patientList = (List<Patient>) map.get("patientList");

		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public void populateHinNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List objectList = new ArrayList();
		String serviceNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = (request.getParameter("serviceNo"));
		}
		dataMap.put("serviceNo", serviceNo);
		@SuppressWarnings("unused")
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		map = misHandlerService.populateHinNo(dataMap);
		inpatientList = (List) map.get("inpatientList");

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<hinLists>");
		try {
			if (inpatientList.size() > 0) {
				for (Inpatient inpatient : inpatientList) {
					// Inpatient inpatient = (Inpatient) inpatientList.get(0);
					sb.append("<hinList>");
					sb.append("<hinId>" + inpatient.getHin().getId()
							+ "</hinId>");
					sb.append("<hinNo>" + inpatient.getHin().getHinNo()
							+ "</hinNo>");
					sb.append("</hinList>");
					// }
				}
			} else {
				sb.append("<hinId>" + "no" + "</hinId>");
				sb.append("<hinNo>" + "no" + "</hinNo>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sb.append("</hinLists>");
		sb.append("</item>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");

		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void getFRWDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int hinId = 0;
		if (request.getParameter("hinId") != null) {
			hinId = Integer.parseInt("" + request.getParameter("hinId"));
		}
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		@SuppressWarnings("unused")
		List<MisFrw> misFrwList = new ArrayList<MisFrw>();
		dataMap.put("hinId", hinId);
		map = misHandlerService.getFRWDetails(dataMap);

		inpatientList = (List<Inpatient>) map.get("inpatientList");
		misFrwList = (List<MisFrw>) map.get("misFrwList");

		StringBuffer sb = new StringBuffer();
		for (Inpatient inpatient : inpatientList) {
			sb.append("<item>");

			if (inpatient.getHin().getRank() != null) {
				String rankStr = inpatient.getHin().getRank().getRankName();
				String rankStr1 = "";
				if (rankStr.contains("&apos;") || rankStr.contains("&amp;")
						|| rankStr.contains("&quot;")
						|| rankStr.contains("&gt;") || rankStr.contains("&lt;")) {
					rankStr1 = rankStr;
				} else {
					rankStr1 = rankStr.replaceAll("&", " &amp; ");
				}

				sb.append("<rank>" + rankStr1 + "</rank>");
			} else {
				sb.append("<rank>" + "-" + "</rank>");
			}

			String patientName = "";
			if (inpatient.getHin().getPFirstName() != null)
				patientName = patientName + inpatient.getHin().getPFirstName();
			if (inpatient.getHin().getPMiddleName() != null)
				patientName = patientName + " "
						+ inpatient.getHin().getPMiddleName();
			if (inpatient.getHin().getPLastName() != null)
				patientName = patientName + " "
						+ inpatient.getHin().getPLastName();
			sb.append("<pName>" + patientName + "</pName>");
			if (inpatient.getHin().getTrade() != null) {
				String tradeStr = inpatient.getHin().getTrade().getTradeName();
				String tradeStr1 = "";
				if (tradeStr.contains("&apos;") || tradeStr.contains("&amp;")
						|| tradeStr.contains("&quot;")
						|| tradeStr.contains("&gt;")
						|| tradeStr.contains("&lt;")) {
					tradeStr1 = tradeStr;
				} else {
					tradeStr1 = tradeStr.replaceAll("&", " &amp; ");
				}

				sb.append("<trade>" + tradeStr1 + "</trade>");
			} else {
				sb.append("<trade>" + "-" + "</trade>");
			}
			sb.append("<age>" + inpatient.getAge() + "</age>");
			if (inpatient.getHin().getSex() != null) {
				sb.append("<sex>"
						+ inpatient.getHin().getSex()
								.getAdministrativeSexName() + "</sex>");
			} else {
				sb.append("<sex>" + "-" + "</sex>");
			}

			if (inpatient.getHin().getUnit() != null) {
				String unitStr = inpatient.getHin().getUnit().getUnitName();
				String unitStr1 = "";
				if (unitStr.contains("&apos;") || unitStr.contains("&amp;")
						|| unitStr.contains("&quot;")
						|| unitStr.contains("&gt;") || unitStr.contains("&lt;")) {
					unitStr1 = unitStr;
				} else {
					unitStr1 = unitStr.replaceAll("&", " &amp; ");
				}

				sb.append("<unit>" + unitStr1 + "</unit>");
			} else {
				sb.append("<unit>" + "-" + "</unit>");
			}
			sb.append("<hinId>" + inpatient.getHin().getId() + "</hinId>");
			sb.append("</item>");
		}

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");

		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ModelAndView getHinAdNoFatalPanchanama(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		int hinId = 0;
		try {
			if (request.getParameter(SERVICE_NO) != null) {
				serviceNo = request.getParameter(SERVICE_NO);
				detailsMap.put("serviceNo", serviceNo);
			}
			if (request.getParameter(HIN_ID) != null
					&& !request.getParameter(HIN_ID).equals("")) {

				hinId = Integer.parseInt("" + request.getParameter(HIN_ID));
				detailsMap.put("hinId", hinId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String flag = "";

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (flag.equals("admission")) {
			map = misHandlerService.getHinAdNoFatalPanchanama(detailsMap);
			map.put("flag", flag);
			jsp = MIS_RESPONSE_FOR_FATAl_PANCHANAMA;
		} else if (flag.equals("hin")) {
			map = misHandlerService.getHinAdNoFatalPanchanama(detailsMap);
			map.put("flag", flag);
			jsp = MIS_RESPONSE_FOR_FATAl_PANCHANAMA;
		}

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getHinNoForDeficient(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List objectList = new ArrayList();
		String serviceNo = "";
		String respForm = "";
		session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));

		if (request.getParameter("serviceNo") != null) {
			serviceNo = (request.getParameter("serviceNo"));
		}
		if (request.getParameter("respForm") != null) {
			respForm = (request.getParameter("respForm"));
		}
		dataMap.put("serviceNo", serviceNo);
		dataMap.put("respForm", respForm);
		dataMap.put("hospitalId", hospitalId);
		@SuppressWarnings("unused")
		List<Patient> patientList = new ArrayList<Patient>();
		map = misHandlerService.getHinNoForDeficient(dataMap);
		if (respForm != null) {
			if (respForm.equals("arrival")) {
				jsp = "responceForDeficient";
			} else if (respForm.equals("receipt")) {
				jsp = "responceForReceiptEntry";
			} else if (respForm.equals("clearance")) {
				jsp = "responceForClearanceForm";
			} else if (respForm.equals("dispatch")) {
				jsp = "responceForDispatchDetails";
			
			}
		}
		map.put("serviceNo", serviceNo);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getHinNoForSurplus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List objectList = new ArrayList();
		String serviceNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = (request.getParameter("serviceNo"));
		}
		dataMap.put("serviceNo", serviceNo);
		@SuppressWarnings("unused")
		List<Patient> patientList = new ArrayList<Patient>();
		map = misHandlerService.getHinNoForSurplus(dataMap);
		jsp = "responceForSurplus";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showReportForDocuments(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = misHandlerService.showFrwCases();
		jsp = REPORT_FOR_DOCUMENTS + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView primtReportForDocuments(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		try {
			if (request.getParameter(SERVICE_NO) != null) {
				serviceNo = (request.getParameter(SERVICE_NO));
			}
			parameters.put("serviceNo", serviceNo);
			detailsMap = misHandlerService.getConnectionForReport();
			HMSUtil.generateReport("receiptForDocuments", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printMisDailyReport(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Date toDate = null;
		Date toDate1 = null;
		int Dept_ID = 0;
		String date4MySQL = "";
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			date4MySQL = formatterOut.format(formatterIn.parse(request
					.getParameter(TO_DATE)));
			dataMap.put("Date", date4MySQL);
		}
		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equals(""))) {
			Dept_ID = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}

		map = misHandlerService.getDBConnection();
		// dataMap.put("Date", toDate);
		dataMap.put("Dept_ID", Dept_ID);
		// parameters = misHandlerService.getTotalMisDailyReport(dataMap);		
		parameters.put("toDate", toDate);
		parameters.put("Dept_ID", Dept_ID);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		HMSUtil.generateReport("misDailyReport", parameters, (Connection) map
				.get("conn"), response, getServletContext());
		return null;
	}

	public ModelAndView showCommandentReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = COMMANDENT_REPORT + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printCommandentReport(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		Date toDate = null;
		int Dept_ID = 0;
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		
		map = misHandlerService.getDBConnection();
		parameters.put("toDate", toDate);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		HMSUtil.generateReport("BedStatusReport", parameters, (Connection) map
				.get("conn"), response, getServletContext());
		return null;
	}

	public ModelAndView getHinAdNoForND(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		int hinId = 0;
		try {
			if (request.getParameter(SERVICE_NO) != null) {
				serviceNo = request.getParameter(SERVICE_NO);
				detailsMap.put("serviceNo", serviceNo);
			}
			if (request.getParameter(HIN_ID) != null
					&& !request.getParameter(HIN_ID).equals("")) {

				hinId = Integer.parseInt("" + request.getParameter(HIN_ID));
				detailsMap.put("hinId", hinId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String flag = "";

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (flag.equals("admission")) {
			map = misHandlerService.getHinAdNoForND(detailsMap);
			map.put("flag", flag);
			jsp = MIS_RESPONSE_FOR_ND;
		} else if (flag.equals("hin")) {
			map = misHandlerService.getHinAdNoForND(detailsMap);
			map.put("flag", flag);
			jsp = MIS_RESPONSE_FOR_ND;
		}

		return new ModelAndView(jsp, "map", map);
	}
	 public ModelAndView getHinNoForMalariaCase(HttpServletRequest request, HttpServletResponse response)
	  {
		Map<String, Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		try { 
		     	if (request.getParameter("serviceNo") != null)
			    {
				   serviceNo = request.getParameter("serviceNo");
				   
				   
			     }
		    }
		catch(Exception e )
		 {
			e.printStackTrace();
		 }
		detailsMap.put("serviceNo", serviceNo);
		map = misHandlerService.getHinNoForMalariaCase(detailsMap);
		 jsp = MIS_RESPONSE_FOR_MALARIA_CASE;
		 return new ModelAndView(jsp,"map",map);
	  }
	 
	 public ModelAndView getHinNoForFoodHandler(HttpServletRequest request, HttpServletResponse response)
	 {
		 
		 Map<String, Object> map = new HashMap<String,Object>();
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			String serviceNo = "";
			try { 
			     	if (request.getParameter("serviceNo") != null)
				    {
					   serviceNo = request.getParameter("serviceNo");
					   
					   
				     }
			    }
			catch(Exception e )
			 {
				e.printStackTrace();
			 }
			detailsMap.put("serviceNo", serviceNo);
			map = misHandlerService.getHinNoForFoodHandler(detailsMap);
			 jsp = MIS_RESPONSE_FOR_FOOD_HANDLER;
			 return new ModelAndView(jsp,"map",map);
		 
		 
	 }
	 
	 
	 
	 /*
	  * By Ujjwal For Sho Notifiable Disease
	  */
		 
		 public ModelAndView getHinNoForNotifiableDisease(HttpServletRequest request, HttpServletResponse  response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Box box = HMSUtil.getBox(request);
				String serviceNo = box.getString("flag");
				
				map = misHandlerService.getHinNoForNotifiableDisease(serviceNo);
				String jsp = "misResponseForNotifiableDisease";
				
				return new ModelAndView(jsp, "map", map);
			}
		
//--By kiran------------
		 
public ModelAndView getPatientDetailForNotifiableDisease(HttpServletRequest request,HttpServletResponse response) 
{
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> mapForDS = new HashMap<String, Object>();
				
				int hinId = 0;
				if(request.getParameter(HIN_ID)!= null && !request.getParameter(HIN_ID).equals("")){
					hinId = Integer.parseInt(request.getParameter(HIN_ID));
					mapForDS.put("hinId", hinId);
				}
				
				map = misHandlerService.getPatientDetailForNotifiableDisease(mapForDS);	
				String jsp = "populatePatientDetailForNotifiableDisease";
				return new ModelAndView(jsp,"map",map);
				
}
		 

	/*
	 * public ModelAndView getResponceForAME(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String, Object> dataMap = new
	 * HashMap<String, Object>(); Map<String, Object> map = new HashMap<String,
	 * Object>(); String serviceNo = ""; if (request.getParameter("serviceNo")
	 * != null) { serviceNo = (request.getParameter("serviceNo")); }
	 * dataMap.put("serviceNo", serviceNo); map =
	 * misHandlerService.getResponceForAME(dataMap); jsp = "responceForAME";
	 * return new ModelAndView(jsp, "map", map); }
	 */
	// ----------------Changed by Dipali-------------
	public ModelAndView getResponceForAME(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = (request.getParameter("serviceNo"));
		}
		dataMap.put("serviceNo", serviceNo);
		map = misHandlerService.getResponceForAME(dataMap);

		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		if (map.get("empAfmsfDetList") != null) {
			empAfmsfDetList = (List<EmpAfmsfDet>) map.get("empAfmsfDetList");
		}
		if ((!serviceNo.equals("") && empAfmsfDetList.size() > 0)) {
			jsp = "responceForAME";
		} else {

			jsp = "responceForAMEEntry";
		}
		map.put("detailsMap", detailsMap);
		return new ModelAndView(jsp, "map", map);
	}

	// ---By Dipali--for AnnualMedicalExamination
	public ModelAndView submitAnnualMedicalExamination(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("box", box);
		map = misHandlerService.submitAnnualMedicalExamination(box, dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Data Added successfully !!";
		} else {
			message = "Try Again !!";
		}
		jsp = RequestConstants.AFMSFANNUALMEDICALEXAMINATION_JSP;
		jsp += ".jsp";
		title = "annual exam";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	/*
	 * public ModelAndView submitAnnualMedicalExamination(HttpServletRequest
	 * request, HttpServletResponse response) {
	 * 
	 * Map<String, Object> map = new HashMap<String, Object>(); Map<String,
	 * Object> dataMap = new HashMap<String, Object>(); boolean saved = false;
	 * Box box = HMSUtil.getBox(request); session = request.getSession(); int
	 * hospitalId=0; if (session.getAttribute("hospitalId") != null) hospitalId
	 * = Integer.parseInt("" + session.getAttribute("hospitalId"));
	 * dataMap.put("hospitalId", hospitalId); dataMap.put("box", box); map =
	 * misHandlerService.submitAnnualMedicalExamination(box, dataMap); saved =
	 * (Boolean) map.get("saved"); if (saved == true) { message =
	 * "Data Added successfully !!"; } else { message = "Try Again !!"; } jsp =
	 * RequestConstants.AFMSFANNUALMEDICALEXAMINATION_JSP; jsp += ".jsp"; title
	 * = "annual exam"; map.put("contentJsp", jsp); map.put("title", title);
	 * map.put("message", message); return new ModelAndView("indexB", "map",
	 * map); }
	 */
	public ModelAndView showAmeLmcReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		@SuppressWarnings("unused")
		String serviceNo = "";
		int rankId = 0;
		int unitId = 0;
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}
		if (request.getParameter(UNIT_ID) != null
				&& !(request.getParameter(UNIT_ID).equals("0"))) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		}
		map = misHandlerService.showAmeLmcReportJsp();

		jsp = AME_LMC_REPORT_JSP;
		jsp += ".jsp";
		title = "ameLmcReport";
		map.put("serviceNo", serviceNo);
		map.put("rankId", rankId);
		map.put("unitId", unitId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	/*
	 * public ModelAndView showAmeLmcReportJsp(HttpServletRequest
	 * request,HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); session = request.getSession();
	 * 
	 * @SuppressWarnings("unused") String serviceNo=""; int rankId=0; int
	 * unitId=0; if (request.getParameter(SERVICE_NO) != null&&
	 * !(request.getParameter(SERVICE_NO).equals(""))) { serviceNo =
	 * request.getParameter(SERVICE_NO); } if (request.getParameter(RANK_ID) !=
	 * null&& !(request.getParameter(RANK_ID).equals("0"))) { rankId =
	 * Integer.parseInt(request.getParameter(RANK_ID)); } if
	 * (request.getParameter(UNIT_ID) != null&&
	 * !(request.getParameter(UNIT_ID).equals("0"))) { unitId =
	 * Integer.parseInt(request.getParameter(UNIT_ID)); } map =
	 * misHandlerService.showAmeLmcReportJsp();
	 * 
	 * jsp = AME_LMC_REPORT_JSP; jsp += ".jsp"; title = "ameLmcReport";
	 * map.put("serviceNo", serviceNo); map.put("rankId", rankId);
	 * map.put("unitId", unitId); map.put("contentJsp", jsp); map.put("title",
	 * title); return new ModelAndView("indexB", "map", map); }
	 */
	public ModelAndView printAmeLmc(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String amcLmc = "";
		String flag = "n";
		String query = "where ";

		try {

			if (request.getParameter(SERVICE_NO) != null
					&& (!request.getParameter(SERVICE_NO).equals(""))) {
				query = query + "emp_afmsf_det.`service_no` = '"
						+ request.getParameter(SERVICE_NO) + "' ";
				flag = "y";
			}
			if (request.getParameter(RANK_ID) != null
					&& (!request.getParameter(RANK_ID).equals("0"))) {
				if (flag == "y") {
					query = query + "AND mas_rank.`rank_id` = '"
							+ request.getParameter(RANK_ID) + "' ";
				} else {
					query = query + "mas_rank.`rank_id` = '"
							+ request.getParameter(RANK_ID) + "' ";
					flag = "y";
				}
			}
			if (request.getParameter(UNIT_ID) != null
					&& (!request.getParameter(UNIT_ID).equals("0"))) {
				if (flag == "y") {
					query = query + "AND mas_unit.`unit_id` = '"
							+ request.getParameter(UNIT_ID) + "' ";
				} else {
					query = query + "mas_unit.`unit_id` = '"
							+ request.getParameter(UNIT_ID) + "' ";
					flag = "y";
				}
			}
			if (request.getParameter(AME_LMC) != null) {
				amcLmc = request.getParameter(AME_LMC);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = misHandlerService.getDBConnection();
		parameters.put("QUERY", query);
		try {
			response.setContentType("application/pdf");
			if (amcLmc.equalsIgnoreCase("a")) {
				HMSUtil.generateReport("ameReport", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (amcLmc.equalsIgnoreCase("l")) {
				HMSUtil.generateReport("lmcReport", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * public ModelAndView printAmeLmc(HttpServletRequest
	 * request,HttpServletResponse response) { Map<String, Object> detailsMap =
	 * new HashMap<String, Object>(); Map<String, Object> parameters = new
	 * HashMap<String, Object>(); String amcLmc=""; String flag = "n"; String
	 * query="where ";
	 * 
	 * try {
	 * 
	 * if (request.getParameter(SERVICE_NO) != null&&
	 * (!request.getParameter(SERVICE_NO).equals(""))) { query = query +
	 * "emp_afmsf_det.`service_no` = '"+ request.getParameter(SERVICE_NO) +
	 * "' "; flag="y"; } if (request.getParameter(RANK_ID) != null&&
	 * (!request.getParameter(RANK_ID).equals("0"))) { if(flag=="y"){ query =
	 * query + "AND mas_rank.`rank_id` = '" + request.getParameter(RANK_ID) +
	 * "' "; }else{ query = query + "mas_rank.`rank_id` = '" +
	 * request.getParameter(RANK_ID) + "' "; flag="y"; } } if
	 * (request.getParameter(UNIT_ID) != null&&
	 * (!request.getParameter(UNIT_ID).equals("0"))) { if(flag=="y"){ query =
	 * query + "AND mas_unit.`unit_id` = '"+ request.getParameter(UNIT_ID) +
	 * "' "; } else{ query = query + "mas_unit.`unit_id` = '"+
	 * request.getParameter(UNIT_ID) + "' "; flag="y"; } } if
	 * (request.getParameter(AME_LMC) != null) { amcLmc =
	 * request.getParameter(AME_LMC); } } catch (Exception e) {
	 * e.printStackTrace(); }
	 * detailsMap =
	 * misHandlerService.getDBConnection(); parameters.put("QUERY", query); try
	 * { response.setContentType("application/pdf");
	 * if(amcLmc.equalsIgnoreCase("a")){ HMSUtil.generateReport("ameReport",
	 * parameters,(Connection) detailsMap.get("conn"), response,
	 * getServletContext()); }else if(amcLmc.equalsIgnoreCase("l")){
	 * HMSUtil.generateReport("lmcReport", parameters,(Connection)
	 * detailsMap.get("conn"), response, getServletContext()); } } catch
	 * (IllegalStateException e) { e.printStackTrace(); } return null; }
	 */
	// -----------------Dipali Code end here------------------
	// Start... AFMSF-1 forms Add by kalyan
	public ModelAndView showAfmsfArrivalEntryjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String afmsfType = "arrival";
		map = misHandlerService.showAfmsfDefjsp(afmsfType);
		jsp = "arrivalEntry";
		jsp += ".jsp";
		title = "Afmsf-1 ArrivalEntry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showAfmsfReceiptEntryjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		String afmsfType = "receipt";
		map = misHandlerService.showAfmsfDefjsp(afmsfType);
		jsp = "receiptEntryJsp";
		jsp += ".jsp";
		title = "Afmsf-1 ReceiptEntry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showAfmsfClearanceFormjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String afmsfType = "clearance";
		map = misHandlerService.showAfmsfDefjsp(afmsfType);
		jsp = "clearanceFormJsp";
		jsp += ".jsp";
		title = "Afmsf-1 Clearance Form";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showAfmsfDispatchDetailsjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String afmsfType = "dispatch";
		map = misHandlerService.showAfmsfDefjsp(afmsfType);
		jsp = "dispatchDetailsJsp";
		jsp += ".jsp";
		title = "Afmsf-1 Dispatch Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showAMEReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "AMEReport";
		jsp += ".jsp";
		title = "Afmsf-1 Dispatch Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printAMEReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int inpatientId = 0;
		int dischargeId = 0;
		String aOrO = "";
		try {
			Date toDate = null;
			int Dept_ID = 0;
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(RADIO_FOR_TABLE) != null) {
				aOrO = (request.getParameter(RADIO_FOR_TABLE));
			}
			detailsMap = misHandlerService.getConnectionForReport();
			parameters.put("asOnDate", toDate);
			if (aOrO.equalsIgnoreCase("a"))
				HMSUtil.generateReport("annualReport", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			else if (aOrO.equalsIgnoreCase("o"))
				HMSUtil.generateReport("annualReport2", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showPMOReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "PMOReport";
		jsp += ".jsp";
		title = "Afmsf-1 Dispatch Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showFatalDocumentTrackingReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = FATAL_DOCUMENT_TRACKING_REPORT;
		jsp += ".jsp";
		title = FATAL_DOCUMENT_TRACKING_REPORT;
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printPMO(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int hin_id = 0;
		String seviceNo = null;
		String ad_no = null;
		int disposed_to_id = 0;
		try {
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals(""))) {
				hin_id = Integer.parseInt(request.getParameter(HIN_ID));
				detailsMap.put("hin_id", hin_id);
			}
			if (request.getParameter("serviceNo") != null
					&& !(request.getParameter("serviceNo").equals(""))) {
				seviceNo = (request.getParameter("serviceNo"));
				detailsMap.put("serviceNo", seviceNo);
			}

			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				ad_no = (request.getParameter(AD_NO));
				detailsMap.put("ad_no", ad_no);
			}

			List<MisFrw> misFrwList = new ArrayList<MisFrw>();
			detailsMap = misHandlerService.printPMO(detailsMap);
			if (detailsMap.get("misFrwList") != null) {
				misFrwList = (List<MisFrw>) detailsMap.get("misFrwList");
			}

			if (seviceNo != null) {
				if (detailsMap.get("hinId") != null) {
					hin_id = Integer.parseInt("" + detailsMap.get("hinId"));
				}
			}
			for (MisFrw misFrw : misFrwList) {
				disposed_to_id = misFrw.getDisposedTo().getId();
			}

			parameters.put("hin_id", hin_id);
			parameters.put("ad_no", ad_no);
			if (disposed_to_id == 13) {
				HMSUtil.generateReport("sick_leave_movement_order", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else {
				HMSUtil.generateReport("Patient_Movement_Order", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showAfmsfReports(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String form = "";
		String toDate = null;
		String fromDate = null;
		try {
			if (request.getParameter("form") != null
					&& !(request.getParameter("form").equals(""))) {
				form = request.getParameter("form");
			}
			
           if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = request
						.getParameter(TO_DATE);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = request
						.getParameter(FROM_DATE);
			}
			map = misHandlerService.getDBConnection();
			map.put("fromDate", fromDate);
			map.put("toDate", toDate);

			if (!form.equals("") && form.equals("Deficient")) {
				HMSUtil.generateReport("afmsf_deficient_report", map,
						(Connection) map.get("conn"), response,
						getServletContext());
			}
			if (!form.equals("") && form.equals("Equal")) {
				HMSUtil.generateReport("afmsf_equal_report", map,
						(Connection) map.get("conn"), response,
						getServletContext());
			}
			if (!form.equals("") && form.equals("Surplus")) {
				HMSUtil.generateReport("afmsf_surplus_report", map,
						(Connection) map.get("conn"), response,
						getServletContext());
			}

			if (!form.equals("") && form.equals("Dispatch")) {
				HMSUtil.generateReport("Dispatch_details_report", map,
						(Connection) map.get("conn"), response,
						getServletContext());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showAfmsfDispatchDetailsReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = DEFICIENT_SURPLUS_ANNUAL + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// End AFMSF-1
	public ModelAndView getHiAdListForBD(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		int hinId = 0;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (flag.equals("hin"))
			if (request.getParameter(SERVICE_NO) != null) {
				serviceNo = request.getParameter(SERVICE_NO);
				detailsMap.put("serviceNo", serviceNo);
			}
		if (flag.equals("ad"))
			if (request.getParameter("hinId") != null) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				detailsMap.put("hinId", hinId);
			}
		detailsMap.put("flag", flag);
		map = misHandlerService.getHiAdListForBD(detailsMap);
		if (flag.equals("hin")) {
			jsp = RESPONSE_BD;
		} else if (flag.equals("ad")) {
			jsp = RESPONSE_BD2;
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView printFDTReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int inpatientId = 0;
		String aOrO = "";
		try {
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				inpatientId = Integer.parseInt(request.getParameter(AD_NO));
			}
			detailsMap = misHandlerService.getConnectionForReport();
			parameters.put("inpatient_id", inpatientId);
			HMSUtil.generateReport("FDT", parameters, (Connection) detailsMap
					.get("conn"), response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printFRWForCurrentDate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Date frw_date = HMSUtil
				.convertStringTypeDateToDateType((String) utilMap
						.get("currentDate"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		map = misHandlerService.getDBConnection();
		parameters.put("frw_date", frw_date);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		HMSUtil.generateReport("FRWForCurrentDate", parameters,
				(Connection) map.get("conn"), response, getServletContext());
		return null;
	}

	// **Kalyan** for Excel Formate Report

	public ModelAndView totalAdmissionExcelSoftCopy(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		box.put("download_path", getServletContext().getRealPath("/download/"));
		map = misHandlerService.totalAdmissionExcelSoftCopy(box);
		if (map.get("flag") != null
				&& map.get("flag").toString().equalsIgnoreCase("NoData")) {
			map.put("message", "No Data Found!....");
		} else {
			try {
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition",
						"attachment; filename="
								+ map.get("download_path").toString());
				File f = new File(map.get("download_path").toString());
				InputStream in = new FileInputStream(f);
				ServletOutputStream outs = response.getOutputStream();
				int bit = 256;
				int i = 0;
				while ((bit) >= 0) {
					bit = in.read();
					outs.write(bit);
				}
				outs.flush();
				outs.close();
				in.close();
				if (f.exists())
					f.delete();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		title = "Export CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return null;
	}

	public ModelAndView totalDischargeExcelSoftCopy(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		box.put("download_path", getServletContext().getRealPath("/download/"));
		map = misHandlerService.totalDischargeExcelSoftCopy(box);
		if (map.get("flag") != null
				&& map.get("flag").toString().equalsIgnoreCase("NoData")) {
			map.put("message", "No Data Found!....");
		} else {
			try {
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition",
						"attachment; filename="
								+ map.get("download_path").toString());
				File f = new File(map.get("download_path").toString());
				InputStream in = new FileInputStream(f);
				ServletOutputStream outs = response.getOutputStream();
				int bit = 256;
				int i = 0;
				while ((bit) >= 0) {
					bit = in.read();
					outs.write(bit);
				}
				outs.flush();
				outs.close();
				in.close();
				if (f.exists())
					f.delete();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		title = "Export CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return null;
	}

	public ModelAndView closeExistingRecord(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = misHandlerService.closeExistingRecord(box);
		url = "/hms/hms/mis?method=showAfmsfAnnualMedicalexaminationjsp";
		// map = misHandlerService.showAfmsfAnnualMedicalExamination(serviceNo);
		jsp = AFMSFANNUALMEDICALEXAMINATION_JSP;
		title = "Annual Medical Examination Afmsf-1";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getExistingDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = misHandlerService.getExistingDetails(box);
		jsp = "ameDetails";
		// jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showSILDILStatusReportJSP(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		jsp = "sildil_cond_status_report.jsp";

		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printSILDILStatusReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		Date currDate = null;
		int serviceTypeId = 0;
		int departmentId = 0;
		String reportName = "";
		Map<String, Object> parameters = new HashMap<String, Object>();

		try {
			reportName = "sildil_cond_main";

			if (request.getParameter(FROM_DATE) != null) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(TO_DATE) != null) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}

			map = misHandlerService.printSILDILStatusReport(fromDate, toDate);

			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
					"/reports/"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = misHandlerService.getConnectionForReport();
		HMSUtil.generateReport(reportName, parameters, (Connection) detailsMap
				.get("conn"), response, getServletContext());
		return null;

	}

	public ModelAndView getAdNo1(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> admissionNoList = new ArrayList<Object>();
		int hinId = 0;
		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		map.put("hinId", hinId);
		admissionNoList = misHandlerService.getAdmissionNoList1(map);
		jsp = RESPONSE_FOR_ADMISSION_NO;
		map.put("admissionNoList", admissionNoList);
		return new ModelAndView(jsp, "map", map);
	}

	public void checkFRWDone(HttpServletRequest request,
			HttpServletResponse response) {
		String ADNumber = "";
		boolean condition = false;
		if (request.getParameter("ADNumber") != null) {
			ADNumber = (String) request.getParameter("ADNumber");
		}

		condition = misHandlerService.checkFRWDone(ADNumber);
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version='1.0' encoding='ISO-8859-1'?>");
		sb.append("<items><item><condition>");
		sb.append(condition);
		sb.append("</condition></item></items>");
		try {
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");

			response.getWriter().write(sb.toString());
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	// ---Form 38-A--in Excel Formate----By Dipali---

	public ModelAndView searchMonthlySickExcelReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId=0;
		String hospitalName="";
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
			hospitalName = misHandlerService.getHospitalName(hospitalId);
			box.put("hospitalName", hospitalName);
			box.put("hospitalId", hospitalId);
		}

		box.put("download_path", getServletContext().getRealPath("/download/"));
		map = misHandlerService.searchMonthlySickExcelReport(box);
		if (map.get("flag") != null
				&& map.get("flag").toString().equalsIgnoreCase("NoData")) {
			map.put("message", "No Data Found!....");
		} else {
			try {
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition",
						"attachment; filename="
								+ map.get("download_path").toString());
				File f = new File(map.get("download_path").toString());
				InputStream in = new FileInputStream(f);
				ServletOutputStream outs = response.getOutputStream();
				int bit = 256;
				int i = 0;
				while ((bit) >= 0) {
					bit = in.read();
					outs.write(bit);
				}
				outs.flush();
				outs.close();
				in.close();
				if (f.exists())
					f.delete();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		title = "Export CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return null;
	}

	// ---Form 38-B--in Excel Formate----By Dipali---
	public ModelAndView searchMonthlySickExcelForm38BReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId=0;
		String hospitalName="";
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
			hospitalName = misHandlerService.getHospitalName(hospitalId);
			box.put("hospitalName", hospitalName);
			box.put("hospitalId", hospitalId);
		}
		box.put("download_path", getServletContext().getRealPath("/download/"));
		map = misHandlerService.searchMonthlySickExcelForm38BReport(box);
		if (map.get("flag") != null
				&& map.get("flag").toString().equalsIgnoreCase("NoData")) {
			map.put("message", "No Data Found!....");
		} else {
			try {
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition",
						"attachment; filename="
								+ map.get("download_path").toString());
				File f = new File(map.get("download_path").toString());
				InputStream in = new FileInputStream(f);
				ServletOutputStream outs = response.getOutputStream();
				int bit = 256;
				int i = 0;
				while ((bit) >= 0) {
					bit = in.read();
					outs.write(bit);
				}
				outs.flush();
				outs.close();
				in.close();
				if (f.exists())
					f.delete();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		title = "Export CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return null;
	}

	// **End T.A Excel**

	/**
	 * ----------------------- CONTROLLER METHODS --------------------
	 * 
	 * @return
	 */
	public MISHandlerService getMisHandlerService() {
		return misHandlerService;
	}

	public void setMisHandlerService(MISHandlerService misHandlerService) {
		this.misHandlerService = misHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public ModelAndView showDefeicientReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int hospitalId = 0;
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = misHandlerService.showDefeicientReportJsp();

		jsp += "deficientReportJsp";
		jsp += ".jsp";
		title = "Deficient Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateDefeicientReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int deptId = 0;
		String hospitalName = "";
		String deptName = "";
		String query = "";

		session = request.getSession();
		try {

			

			String qry = "";
			
			if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("") && !request.getParameter("cmdId").equals("0") && request.getParameter("hospitalId")!=null && request.getParameter("hospitalId").equals("0") && request.getParameter("hospitalId").equals("")){
				
				qry += "  and mas_hospital.command_id="+Integer.parseInt(request.getParameter("cmdId"));
			}else{
				if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("") && !request.getParameter("hospitalId").equals("0")){
					hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
				}else{
					hospitalId = (Integer)session.getAttribute("hospitalId");
				}
				qry += "  and emp_afmsf_det.hospital_id="+hospitalId;
				hospitalName = storesHandlerService.getHospitalName(hospitalId);
				requestParameters.put("HOS_NAME", hospitalName);
				requestParameters.put("hospital_id", hospitalId);
				
			}
			if(box.getInt("rankId")!=0 ){
				qry += " and emp_afmsf_det.rank_id = "+box.getInt("rankId");
			}
			if(box.getInt("unitId")!=0 ){
				qry += " and emp_afmsf_det.unit_id = "+box.getInt("unitId");
			}
			if(box.getInt("tradeId")!=0 ){
				qry += " and emp_afmsf_det.trade_id = "+box.getInt("tradeId");
			}
			String fromDate = "";
			String toDate = "";
			fromDate = box.getString(FROM_DATE);
			toDate = box.getString(TO_DATE);
			requestParameters.put("from_date", fromDate);
			requestParameters.put("to_date", toDate);
			requestParameters.put("qry", qry);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = misHandlerService
				.getConnectionForReport();
		String reportName = "";
		//if (box.getString("reportType").equals("yes")) {
			reportName = "afmsf_deficient_yes_report";
		/*} else if (box.getString("reportType").equals("no")) {
			reportName = "afmsf_deficient_no_report";
		}*/

		HMSUtil.generateReport(reportName, requestParameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showSurplusReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int hospitalId = 0;
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = misHandlerService.showDefeicientReportJsp();

		jsp += "surplusReportJsp";
		jsp += ".jsp";
		title = "Surplus Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateSurplusReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int deptId = 0;
		String hospitalName = "";
		String deptName = "";
		String query = "";

		session = request.getSession();
		try {

	
		
		
			String qry = "";
			if(box.getInt("rankId")!=0 ){
				qry += " and emp_afmsf_det.rank_id = "+box.getInt("rankId");
			}
			if(box.getInt("unitId")!=0 ){
				qry += " and emp_afmsf_det.unit_id = "+box.getInt("unitId");
			}
			if(box.getInt("tradeId")!=0 ){
				qry += " and emp_afmsf_det.trade_id = "+box.getInt("tradeId");
			}

			if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("") && !request.getParameter("cmdId").equals("0") && request.getParameter("hospitalId")!=null && request.getParameter("hospitalId").equals("0") && request.getParameter("hospitalId").equals("")){
				
				qry += "  and mas_hospital.command_id="+Integer.parseInt(request.getParameter("cmdId"));
			}else{
				if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("") && !request.getParameter("hospitalId").equals("0")){
					hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
				}else{
					hospitalId = (Integer)session.getAttribute("hospitalId");
				}
				qry += "  and emp_afmsf_det.hospital_id="+hospitalId;
				hospitalName = storesHandlerService.getHospitalName(hospitalId);
				requestParameters.put("HOS_NAME", hospitalName);
			}

			
			String fromDate = "";
			String toDate = "";
			fromDate = box.getString(FROM_DATE);
			toDate = box.getString(TO_DATE);
			requestParameters.put("from_date", fromDate);
			requestParameters.put("to_date", toDate);
			requestParameters.put("qry", qry);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = misHandlerService
				.getConnectionForReport();
		String reportName = "";
		//if (box.getString("reportType").equals("yes")) {
			reportName = "afmsf_surplus_yes_report";
		/*} else if (box.getString("reportType").equals("no")) {
			reportName = "afmsf_surplus_no_report";
		}*/

		HMSUtil.generateReport(reportName, requestParameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showFatalDocumentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = misHandlerService.getRankUnitSexList();
		jsp += "fatalDocument";
		jsp += ".jsp";
		title = "Fatal Document";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	/*public ModelAndView submitFatalDocument(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		@SuppressWarnings("unused")
		Box box = HMSUtil.getBox(request);
		int hin_id = 0;
		dataMap = misHandlerService.submitFatalDocument(box);
		boolean status = (Boolean) dataMap.get("status");
		hin_id = (Integer) dataMap.get("hin_id");
		if(dataMap.get("hin_id")!= null && !(dataMap.get("hin_id").equals("")))
		{
		 hin_id = (Integer) dataMap.get("hin_id");
		}
		
		String message = "";
		if (status == true) {
			message = "Records are Added Successfully.";
		} else {
			message = "Records are not Added Successfully.";
		}
		map = misHandlerService.getRankUnitSexList();
		jsp = "messageFatalDocument";
		jsp += ".jsp";
		map.put("hin_id", hin_id);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}*/
	
	public ModelAndView submitFatalDocument(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		@SuppressWarnings("unused")
		Box box = HMSUtil.getBox(request);
		int hin_id = 0;
		dataMap = misHandlerService.submitFatalDocument(box);
		boolean status = (Boolean) dataMap.get("status");
		if(dataMap.get("hin_id")!=null){
		hin_id = (Integer) dataMap.get("hin_id");
		}
		/*if(dataMap.get("hin_id")!= null && !(dataMap.get("hin_id").equals("")))
		{
		 hin_id = (Integer) dataMap.get("hin_id");
		}*/
		
		String message = "";
		if (status == true) {
			message = "Records are Added Successfully.";
		} else {
			message = "Records are not Added Successfully.";
		}
		map = misHandlerService.getRankUnitSexList();
		jsp = "messageFatalDocument";
		jsp += ".jsp";
		map.put("hin_id", hin_id);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getPatientDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));

		if (request.getParameter("serviceNo") != null) {
			serviceNo = (request.getParameter("serviceNo"));
		}
		dataMap.put("serviceNo", serviceNo);
		dataMap.put("hospitalId", hospitalId);
		map = misHandlerService.getPatientDetails(dataMap);
		List<Patient> patientList = (List<Patient>) map.get("patientList");
		String message = null;
		if (patientList.size() == 0) {
			message = "Service Person are Not Registered";
		}
		String jsp = "";
		map.put("message", message);
		jsp = "responseForFatalDocument";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView genrateFatalDocument(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		String hospitalName = "";
		int hinId = 0;

		session = request.getSession();
		try {

			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				hospitalName = storesHandlerService.getHospitalName(hospitalId);
				requestParameters.put("HOS_NAME", hospitalName);
				requestParameters.put("hospital_id", hospitalId);
			}

			if (request.getParameter("hin_id") != null)
				hinId = Integer.parseInt(request.getParameter("hin_id"));
			requestParameters.put("hinId", hinId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = misHandlerService
				.getConnectionForReport();
		String reportName = "fatal_document02";
		requestParameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		HMSUtil.generateReport(reportName, requestParameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());

		return null;
	}

	public ModelAndView showMedicalClaimEntryForm(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		jsp += "medicalClaimEntry";
		jsp += ".jsp";
		title = "Medical claim entry";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showSchoolInspection(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "schoolInspection";
		String title = "";
		jsp += "";
		jsp += ".jsp";
		title = "School Inspection ";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showSanitaryDefectNotes(HttpServletRequest request,HttpServletResponse response)
	 {
		Map<String,Object> map = new HashMap<String,Object>();
		String jsp="sanitarydefectsnotes";
		String title = "";
		jsp +="";
		jsp +=".jsp";
		title = "Sanitary Defect Notes";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map",map);
	 }
	public ModelAndView showSMOwaitingList(HttpServletRequest request, HttpServletResponse response)
	 {  Map<String,Object>  mapForDS = new HashMap<String,Object>();
	    //Session session = request.getSession();
	    session = request.getSession();
	    int hospitalId = 0;
	    int deptId = 0;
	    if(session.getAttribute(HOSPITAL_ID)!= null)
	    {
	     hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	    }
	    if(session.getAttribute("deptId")!= null)
	    {
	     deptId = (Integer) session.getAttribute("deptId");
	    }
	    int userId = 0;
	    if(session.getAttribute("users")!= null)
	    {
		Users user = (Users)session.getAttribute("users");	    
		userId = user.getEmployee().getId();
	    }
		
		mapForDS.put("userId", userId);
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("deptId", deptId);
		map = misHandlerService.getWaitingPatientList(mapForDS);
		  List patientList =(List)map.get("patientList");
		   
		  //map.put("patientList", patientList);
	    String jsp = "smoWaitingJsp";
	    jsp += ".jsp";
		map.put("contentJsp", jsp);	
		
		return new ModelAndView("indexB","map",map);
	 }

	 /****************
	 * By Ujjwal For Waiting List SMO for feedbackCounselling
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showSMOwaitingListForCouncling(HttpServletRequest request, HttpServletResponse response)
	 {  Map<String,Object>  mapForDS = new HashMap<String,Object>();
	    //Session session = request.getSession();
	    session = request.getSession();
	    int hospitalId = 0;
	    int deptId = 0;
	    if(session.getAttribute(HOSPITAL_ID)!= null)
	    {
	     hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	    }
	    if(session.getAttribute("deptId")!= null)
	    {
	     deptId = (Integer) session.getAttribute("deptId");
	    }
	    int userId = 0;
	    if(session.getAttribute("users")!= null)
	    {
		Users user = (Users)session.getAttribute("users");	    
		userId = user.getEmployee().getId();
	    }
		
		mapForDS.put("userId", userId);
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("deptId", deptId);
		map = misHandlerService.getWaitingPatientListForcouncling(mapForDS);
		  List patientList =(List)map.get("patientList");
		   
		  //map.put("patientList", patientList);
	    String jsp = "smoWaitingJspForcouncling";
	    jsp += ".jsp";
		map.put("contentJsp", jsp);	
		
		return new ModelAndView("indexB","map",map);
	 }
	 

	/****************
	 * By Ujjwal For Waiting List SMO for feedbackCounselling
	 * @param request
	 * @param response
	 * @return
	 */
	/*public ModelAndView showSMOwaitingListForCouncling(HttpServletRequest request, HttpServletResponse response)
	 {  Map<String,Object>  mapForDS = new HashMap<String,Object>();
	    //Session session = request.getSession();
	    session = request.getSession();
	    int hospitalId = 0;
	    int deptId = 0;
	    if(session.getAttribute(HOSPITAL_ID)!= null)
	    {
	     hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	    }
	    if(session.getAttribute("deptId")!= null)
	    {
	     deptId = (Integer) session.getAttribute("deptId");
	    }
	    int userId = 0;
	    if(session.getAttribute("users")!= null)
	    {
		Users user = (Users)session.getAttribute("users");	    
		userId = user.getEmployee().getId();
	    }
		
		mapForDS.put("userId", userId);
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("deptId", deptId);
		map = misHandlerService.getWaitingPatientListForcouncling(mapForDS);
		  List patientList =(List)map.get("patientList");
		   
		  //map.put("patientList", patientList);
	    String jsp = "smoWaitingJspForcouncling";
	    jsp += ".jsp";
		map.put("contentJsp", jsp);	
		
		return new ModelAndView("indexB","map",map);
	 }*/


	public ModelAndView showMentalPhysicalRetarded(HttpServletRequest request,HttpServletResponse response)
	  {   Map<String,Object> map = new HashMap<String,Object>();
	      String jsp = "mentalAndPhysicalRetardedChildren";
		  String title = "";
		   jsp +=".jsp";
		   title = "MentalPhysicalRetarded";
		   map.put("contentJsp", jsp);
		   map.put("title", title);
		   return new ModelAndView("index","map",map);
	  }
	public ModelAndView showSMOWaitingJsp(HttpServletRequest request,HttpServletResponse response)
	   {
		   Map<String,Object> mapForDS = new HashMap<String,Object>();
		   int hospitalId = 0;
		   if(session.getAttribute(HOSPITAL_ID)!= null)
		    {
		     hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		    }
		   int hinId = Integer.parseInt(request.getParameter("hinId"));
		   mapForDS.put("hinId", hinId);
		   mapForDS.put("hospitalId", hospitalId);
		   map = misHandlerService.getPatientForValidate(mapForDS);
		   
		   String jsp = "shoMalariaValidate";
		   jsp +=".jsp";
		   map.put("contentJsp", jsp);
		   map.put("hinId", hinId );
		   return new ModelAndView("index","map",map);
	   }
	public ModelAndView showSMOWaitingJspForCounselling(HttpServletRequest request,HttpServletResponse response)
	   {
		   Map<String,Object> mapForDS = new HashMap<String,Object>();
		   int hospitalId = 0;
		   if(session.getAttribute(HOSPITAL_ID)!= null)
		    {
		     hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		    }
		   int counsellingId = Integer.parseInt(request.getParameter("counsellingId"));
		   mapForDS.put("counsellingId", counsellingId);
		   mapForDS.put("hospitalId", hospitalId);
		   map = misHandlerService.getPatientForValidateCounselling(mapForDS);
		   
		   String jsp = "shoCounsellingValidate";
		   jsp +=".jsp";
		   map.put("contentJsp", jsp);
		   map.put("counsellingId", counsellingId );
		   return new ModelAndView("index","map",map);
	   }
	
	
	public ModelAndView validateSmoMalariaCase(HttpServletRequest request,HttpServletResponse response)
	  {  Map<String,Object> map = new HashMap<String,Object>();
	     int hospitalId = 0;
	     if(session.getAttribute(HOSPITAL_ID)!= null)
	       {
	        hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	      }
	     int hinId = Integer.parseInt(request.getParameter("hinId"));
	     map.put("hinId", hinId);
	     map.put("hospitalId", hospitalId);
	     boolean successfullyAdded = misHandlerService.validateSmoMalariaCase(map);
			
	        if (successfullyAdded)
	               {
		                  message = "Validate Successfully ";
	            } else {
		                message = "Try Again !!";
	                 }
	            jsp = "messageForValidateSmo";
	            jsp += ".jsp";
	            map.put("contentJsp", jsp);
	            map.put("message", message);
	            return new ModelAndView("index","map",map);
	  }

	  public ModelAndView validateSmoCounseling(HttpServletRequest request,HttpServletResponse response)
	  {  Map<String,Object> map = new HashMap<String,Object>();
	     int hospitalId = 0;
	     if(session.getAttribute(HOSPITAL_ID)!= null)
	       {
	        hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	      }
	     int counselingId = Integer.parseInt(request.getParameter("counselingId"));
	     String rem1="";
	     if(request.getParameter("rem1")!=null){
	    	 rem1=(String)request.getParameter("rem1");
	     }
	     map.put("counselingId", counselingId);
	     map.put("hospitalId", hospitalId);
	     map.put("rem1", rem1);
	     
	     boolean successfullyAdded = misHandlerService.validateSmoCounseling(map);
			
	        if (successfullyAdded)
	               {
		                  message = "Validate Successfully ";
	            } else {
		                message = "Try Again !!";
	                 }
	            jsp = "messageForValidateSmo";
	            jsp += ".jsp";
	            map.put("contentJsp", jsp);
	            map.put("message", message);
	            return new ModelAndView("index","map",map);
	  }

	/*public ModelAndView validateSmoCounseling(HttpServletRequest request,HttpServletResponse response)
	  {  Map<String,Object> map = new HashMap<String,Object>();
	     int hospitalId = 0;
	     if(session.getAttribute(HOSPITAL_ID)!= null)
	       {
	        hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	      }
	     int counselingId = Integer.parseInt(request.getParameter("counselingId"));
	     String rem1="";
	     if(request.getParameter("rem1")!=null){
	    	 rem1=(String)request.getParameter("rem1");
	     }
	     map.put("counselingId", counselingId);
	     map.put("hospitalId", hospitalId);
	     map.put("rem1", rem1);
	     
	     boolean successfullyAdded = misHandlerService.validateSmoCounseling(map);
			
	        if (successfullyAdded)
	               {
		                  message = "Validate Successfully ";
	            } else {
		                message = "Try Again !!";
	                 }
	            jsp = "messageForValidateSmo";
	            jsp += ".jsp";
	            map.put("contentJsp", jsp);
	            map.put("message", message);
	            return new ModelAndView("index","map",map);
	  }*/
	

	public  ModelAndView showMonthlyMalariaCaseReport(HttpServletRequest request,HttpServletResponse response)
	  { Map<String,Object>  map = new HashMap<String,Object>();
		jsp = "malariaCaseReportJsp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	  }
	public ModelAndView showAntiMosquitoMeasuresReport(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object>  map = new HashMap<String,Object>();
		jsp = "AntiMosquitoMeasuresJsp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	  }
	public ModelAndView showPerformaAccidentDetail(HttpServletRequest request,HttpServletResponse response)
	  {  Map<String,Object> map = new HashMap<String,Object>();
	     jsp = "performaAccidentDetailJsp";
		 jsp += ".jsp";
		 map.put("contentJsp", jsp);
		 return new ModelAndView("index","map",map);
	  }
	public ModelAndView showFreeFromInfectionReport(HttpServletRequest request,HttpServletResponse response)
	  {  Map<String,Object> map = new HashMap<String,Object>();
	     jsp = "freeFormInfectionReportJsp";
	     jsp += ".jsp";
		 map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	  }
	public ModelAndView showHealthPromotionActivity(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object> map = new HashMap<String,Object>();
		jsp = "healthPromotionActivityJsp";
		jsp += ".jsp";
		map.put("contentJsp",jsp);
		return new ModelAndView("index","map",map);
	  }
	public ModelAndView showWaterSurveillanceReport(HttpServletRequest request,HttpServletResponse response)
	  {
		 Map<String,Object> map = new HashMap<String,Object>();
		 jsp = "waterSurveillanceReportJsp";
		 jsp +=  ".jsp";
		 map.put("contentJsp",jsp);
		 return new ModelAndView("index","map", map);
		 
	  }
	
	public ModelAndView showPermanentFlyingCatReport(HttpServletRequest request,HttpServletResponse response)
	  {
		 Map<String,Object> map = new HashMap<String,Object>();
		 jsp = "permanentFlyingCatReportJsp";
		 jsp +=  ".jsp";
		 map.put("contentJsp",jsp);
		 return new ModelAndView("index","map", map);
		 
	  }
	
	public ModelAndView showQtyIncidenceOfPreventableDiseases(HttpServletRequest request, HttpServletResponse response)
	  {
		Map<String,Object> map = new HashMap<String,Object>();
		jsp = "incidenceOfPreventableDiseases";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	  }
	public ModelAndView showMonthlyAccidentalDetail(HttpServletRequest request,HttpServletResponse response)
	   {
		  Map<String,Object> map = new HashMap<String,Object>();
		  jsp = "monthlyAccidentalDetail";
		  jsp += ".jsp";
		  map.put("contentJsp",jsp);
		  return new ModelAndView("index","map",map);
	   }
	public ModelAndView printMonthlyMalariaCaseReport(HttpServletRequest request,HttpServletResponse response)
	  {  Map<String,Object>  map = new HashMap<String,Object>();	    
		Date toDate = null;
		Date fromDate = null;
		int hospitalId =0;
         session = request.getSession();
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			
			if (session.getAttribute("hospitalId") != null)
			{
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			 

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("hospitalId", hospitalId);
		try {
			map.put("SUBREPORT_DIR", getServletContext().getRealPath(
					"/reports/"));
			HMSUtil
					.generateReport("sho_Malaria_case", map,
							(Connection) map.get("conn"), response,
							getServletContext());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
		
	  }
	public ModelAndView printantiMosquitoMeasureReport(HttpServletRequest request,HttpServletResponse response)
	 {
		Map<String,Object>  map = new HashMap<String,Object>();	    
		Date toDate = null;
		Date fromDate = null;
		int hospitalId =0;
         session = request.getSession();
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			
			if (session.getAttribute("hospitalId") != null)
			{
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			 

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("hospitalId", hospitalId);
		try {
			map.put("SUBREPORT_DIR", getServletContext().getRealPath(
					"/reports/"));
			HMSUtil
					.generateReport("AntiMosquitoMeasures", map,
							(Connection) map.get("conn"), response,
							getServletContext());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
		
	 }
	
	
	
	public ModelAndView printPerformaAccidentDetail(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object>  map = new HashMap<String,Object>();	    
		
		int accidentId =0;
         session = request.getSession();
		byte[] bytes = null;
		try {
			if (request.getParameter("accidentId") != null && !(request.getParameter("accidentId").equals(""))) {
				accidentId = Integer.parseInt(request.getParameter("accidentId"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("accidentId", accidentId);
		
		try {
			map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			HMSUtil.generateReport("sho_appendix", map,(Connection) map.get("conn"), response,getServletContext());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	  }
	
	public ModelAndView printFreeFromInfectionDetail(HttpServletRequest request, HttpServletResponse response)
	  { 
		Map<String,Object>  map = new HashMap<String,Object>();	    
		Date toDate = null;
		Date fromDate = null;
		int hospitalId =0;
         session = request.getSession();
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			
			if (session.getAttribute("hospitalId") != null)
			{
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			 

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("hospitalId", hospitalId);
		try {
			map.put("SUBREPORT_DIR", getServletContext().getRealPath(
					"/reports/"));
			HMSUtil
					.generateReport("sho_freeFromInfection", map,
							(Connection) map.get("conn"), response,
							getServletContext());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
		
		
	  }
	public ModelAndView printHealthPromotionActivityReport(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object>  map = new HashMap<String,Object>();	    
		Date toDate = null;
		Date fromDate = null;
		int hospitalId =0;
		String qry="";
		String RankCategory="";
         session = request.getSession();
		byte[] bytes = null;
		try {
			if (request.getParameter("RankCategory") != null && !(request.getParameter("RankCategory").equals(""))) {
				RankCategory = (request.getParameter("RankCategory"));
				
						qry +=" and hpa.rank_category ='"+RankCategory+"'";
						System.out.println("qry="+qry);
			}
			
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			
			if (session.getAttribute("hospitalId") != null)
			{
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			 

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("RankCategory", RankCategory);
		map.put("qry", qry);
		map.put("hospitalId", hospitalId);
		try {
			map.put("SUBREPORT_DIR", getServletContext().getRealPath(
					"/reports/"));
			HMSUtil
					.generateReport("sho_healthPromotion", map,
							(Connection) map.get("conn"), response,
							getServletContext());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
		

		
	  }
	public ModelAndView printWaterSurveillanceReport(HttpServletRequest request, HttpServletResponse response)
	  {
		Map<String,Object>  map = new HashMap<String,Object>();	    
		Date toDate = null;
		Date fromDate = null;
		int hospitalId =0;
         session = request.getSession();
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			
			if (session.getAttribute("hospitalId") != null)
			{
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			 

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("hospitalId", hospitalId);
		try {
			map.put("SUBREPORT_DIR", getServletContext().getRealPath(
					"/reports/"));
			HMSUtil
					.generateReport("sho_waterSurveillance", map,
							(Connection) map.get("conn"), response,
							getServletContext());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

		
		
	  }
	
	
	public ModelAndView printPermanentFlyingCatReport(HttpServletRequest request, HttpServletResponse response)
	  {
		Map<String,Object>  map = new HashMap<String,Object>();	    
		Date toDate = null;
		Date fromDate = null;
		int hospitalId =0;
       session = request.getSession();
		byte[] bytes = null;
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			
			if (session.getAttribute("hospitalId") != null)
			{
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			 

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("hospitalId", hospitalId);
		try {
			map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			
			HMSUtil.generateReport("sho_permanentFlying", map,
							(Connection) map.get("conn"), response,
							getServletContext());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

		
		
	  }
	
	
	public ModelAndView printQtyIncidenceOfPreventableDisease(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object>  map = new HashMap<String,Object>();	    
		Date toDate = null;
		Date fromDate = null;
		int hospitalId =0;
         session = request.getSession();
		byte[] bytes = null;
		try {
			    if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			    if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				    fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			
			    if (session.getAttribute("hospitalId") != null)
			       {
				          hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			      }
			 

		 } 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("hospitalId", hospitalId);
		try
		{
			map.put("SUBREPORT_DIR", getServletContext().getRealPath(
					"/reports/"));
			HMSUtil
					.generateReport("incidenceOfPreventable", map,
							(Connection) map.get("conn"), response,
							getServletContext());

		}
		catch (Exception e)
		{	e.printStackTrace();
		}
		return null;	
		
	  }
	
	public ModelAndView printmortlityAmongstFamilyReport(HttpServletRequest request, HttpServletResponse response)
	 {
		Map<String,Object>  map = new HashMap<String,Object>();	    
		Date toDate = null;
		Date fromDate = null;
		int hospitalId =0;
         session = request.getSession();
		byte[] bytes = null;
		try {
			    if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			    if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				    fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			
			    if (session.getAttribute("hospitalId") != null)
			       {
				          hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			      }
			 

		 } 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("hospitalId", hospitalId);
		try
		{
			map.put("SUBREPORT_DIR", getServletContext().getRealPath(
					"/reports/"));
			HMSUtil
					.generateReport("sho_MortalityAmongstFamilies", map,
							(Connection) map.get("conn"), response,
							getServletContext());

		}
		catch (Exception e)
		{	e.printStackTrace();
		}
		return null;	
		
	 }
	
  public ModelAndView printMonthlyAccidentalDetailReport(HttpServletRequest request,HttpServletResponse response)
    {
	  Map<String,Object>  map = new HashMap<String,Object>();	    
		Date toDate = null;
		Date fromDate = null;
		int hospitalId =0;
       session = request.getSession();
		byte[] bytes = null;
		try {
			    if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			    if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				    fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			
			    if (session.getAttribute("hospitalId") != null)
			       {
				          hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			      }
			 

		 } 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("hospitalId", hospitalId);
		try
		{
			map.put("SUBREPORT_DIR", getServletContext().getRealPath(
					"/reports/"));
			HMSUtil
					.generateReport("monthlyAccidentalDetail", map,
							(Connection) map.get("conn"), response,
							getServletContext());

		}
		catch (Exception e)
		{	e.printStackTrace();
		}
		return null;	  
	  
	  
    }	
  
  public ModelAndView printpsychoneurosisCasesReport(HttpServletRequest request, HttpServletResponse response)
     {
	  Map<String,Object>  map = new HashMap<String,Object>();	    
		Date toDate = null;
		Date fromDate = null;
		int hospitalId =0;
     session = request.getSession();
		byte[] bytes = null;
		try {
			    if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			    if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				    fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			
			    if (session.getAttribute("hospitalId") != null)
			       {
				          hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			      }
			 

		 } 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("hospitalId", hospitalId);
		try
		{
			map.put("SUBREPORT_DIR", getServletContext().getRealPath(
					"/reports/"));
			HMSUtil
					.generateReport("sho_phychoneurosisCase", map,
							(Connection) map.get("conn"), response,
							getServletContext());

		}
		catch (Exception e)
		{	e.printStackTrace();
		}
		return null;	  
	  
	  
     }
	public ModelAndView displayFileUpload(HttpServletRequest request, HttpServletResponse response)
	  {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		map=misHandlerService.displayFileUploadData(dataMap);
		String jsp = "shoVectorControl_uploadpatientdoc";
		//String jsp = "fileuploadPopupMedicalExam";
		//map.put("hinNo", hinNo);
		//map.put("folderName", folderName);
		//map.put("hinId", hinId);
		//map.put("masExamId",masExamId);
		//map.put("visitId", visitId);
	
		return new ModelAndView(jsp, "map", map);		
		
	  }
	public ModelAndView displayFileUploadArea(HttpServletRequest request,HttpServletResponse response )
	 {   
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String hinNo = "";
		int visitId = 0;
		int hinId = 0;
		String folderName="";
		int masExamId=0;
		if(request.getParameter("masExamId")!=null )
        {
			masExamId = Integer.parseInt( request.getParameter("masExamId"));
			dataMap.put("masExamId", masExamId);
        }
		if(request.getParameter("hinId")!=null )
        {
			hinId = Integer.parseInt( request.getParameter("hinId"));
			dataMap.put("hinId", hinId);
        }
		if(request.getParameter("visitId")!=null )
		{
		   	visitId=Integer.parseInt(request.getParameter("visitId"));
		   	dataMap.put("visitId", visitId);
		}
		if(request.getParameter("hinNo")!= null)
		{
			hinNo = request.getParameter("hinNo");
		}
		if(request.getParameter("folderName")!= null)
		{
			folderName = request.getParameter("folderName");
		}
	
		map=   misHandlerService.displayFileUploadData(dataMap);
		String jsp = "shoVectorControl_uploadpatientdoc";
		//String jsp = "fileuploadPopupMedicalExam";
		map.put("hinNo", hinNo);
		map.put("folderName", folderName);
		map.put("hinId", hinId);
		map.put("masExamId",masExamId);
		map.put("visitId", visitId);
	
		return new ModelAndView(jsp, "map", map);
		
		
	 }
	public ModelAndView showVectorControl(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		//map = shoHandler.showAccommodation(mapDetail);
		jsp = "sho_vectorControlActivity";
		jsp = jsp + ".jsp";
		title = "Vector Control Activity";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showMonCommandJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "mis.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showMontCommandJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		jsp = "mis1.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showHealthMonitoringJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		jsp = "mis2.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	public ModelAndView showMedExamBoardMonitoringJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		jsp = "mis3.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	
	public ModelAndView showStatsMonitoringJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		jsp = "mis4.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView showMedExamBoardCmdJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		jsp = "MedExamBoardCmd.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView showStatsCmdJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		jsp = "statsCmd.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView showMedExamBoardSMCJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		jsp = "MedExamBoardSMC.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	
	public ModelAndView showStatsSMCJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		jsp = "statsSMC.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView showAvMedicineJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		jsp = "av_Medicine.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView submitVectorControlActivity(HttpServletRequest request,HttpServletResponse response)
	 {
		 int hospitalId = 0 ;
		 int departmentId = 0;
		if(session.getAttribute("hospitalId")!= null)
        {	   hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));          
   	     }
      if(session.getAttribute("deptId")!= null)
        {
   	      departmentId = Integer.parseInt(""+session.getAttribute("deptId")); 	    
        }

		Map<String, Object> dataMap = new HashMap<String, Object>();	
		String countrytabs = "";
		Date FROM_DATE = new Date();
		List<String> larvalChemical = new ArrayList<String>();
		List<String> larvalarea = new ArrayList<String>();
		List<String> larvalsupervisor = new ArrayList<String>();
		//List<String> larvalsupervisor1 = new ArrayList<String>();
		List<String> larvalcarriedout = new ArrayList<String>();
		List<String> larvalbuildingscovered = new ArrayList<String>();
		List<String> larvalqtyOfHygiene = new ArrayList<String>();
		List<String> larvalchemicalUsed = new ArrayList<String>();
		List<String> larvalremarks = new ArrayList<String>();
		List<String> foggingarea = new ArrayList<String>();
		List<String> foggingsupervisor = new ArrayList<String>();
		List<String> foggingcarriedOut = new ArrayList<String>();
		List<String> foggingnoCovered = new ArrayList<String>();
		List<String> foggingreceive = new ArrayList<String>();
		List<String> foggingissue = new ArrayList<String>();
		List<String> foggingbalance = new ArrayList<String>();
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
		List<String> antiFlyChemical= new ArrayList<String>();
		List<String> flyarea = new ArrayList<String>();
		List<String> flysupervisor = new ArrayList<String>(); 
		List<String> flycarriedOut = new ArrayList<String>();
		List<String> flynoCovered = new ArrayList<String>();
		List<String> flyreceive = new ArrayList<String>();
		List<String> flyissued = new ArrayList<String>();
		List<String> flybalance = new ArrayList<String>();
		List<String> flyremarks = new ArrayList<String>();
		List<Date> debuggingDate = new ArrayList<Date>();
		List<String> debuggingChemical = new ArrayList<String>();
		List<String> debuggingarea = new ArrayList<String>();
		List<String> debuggingsupervisor = new ArrayList<String>();
		List<String> debuggingcarriedOut = new ArrayList<String>();
		List<String>  debuggingnoCovered = new ArrayList<String>();
		List<String> debuggingreceive = new ArrayList<String>();
		List<String> debuggingissued = new ArrayList<String>();
		List<String> debuggingbalance = new ArrayList<String>();
		List<String> debuggingremarks = new ArrayList<String>();
		List<Date> biologicalDate = new ArrayList<Date>();
		List<String> biologicalChemical = new ArrayList<String>();
		List<String> biologicalarea = new ArrayList<String>();
		List<String> biologicalsupervisor = new ArrayList<String>();
		List<String> biologicalcarriedOut = new ArrayList<String>();
		List<String> biologicalnoCovered =new ArrayList<String>();
		List<String> biologicalreceive = new ArrayList<String>();
		List<String> biologicalissued = new ArrayList<String>();
		List<String> biologicalbalance = new ArrayList<String>();
		List<String> biologicalremarks =new ArrayList<String>();
		List<String> country1 = new ArrayList<String>();	
		List<String> country2 = new ArrayList<String>();
		List<String> country3 = new ArrayList<String>();
		List<String> country4 = new ArrayList<String>();
		List<String> country5 = new ArrayList<String>();
		List<String> country6 = new ArrayList<String>();
		List<String> country7 = new ArrayList<String>();
		List<Date> larvalDate = new ArrayList<Date>();
		List<Date> adultDate = new ArrayList<Date>();
		List<String> adultChemical = new ArrayList<String>();
		List<String> adultarea = new ArrayList<String>();
		List<String> adultsupervisor =new ArrayList<String>();
		List<String> adultcarriedOut =new ArrayList<String>();
		List<String> adultnoCovered =new ArrayList<String>();
		List<String> adultrecieve = new ArrayList<String>();
		List<String> adultissue =new ArrayList<String>();
		List<String> adultbalance =new ArrayList<String>();
		List<String> adultremarks =new ArrayList<String>();
		List<String> larvalrecieve = new ArrayList<String>();
		List<String> larvalcarriedoutby = new ArrayList<String>();
		List<String> larvalnoCovered = new ArrayList<String>();
		List<String> larvalissue = new ArrayList<String>();
		List<String> larvalbalance = new ArrayList<String>();
		List<Date> foggingDate = new ArrayList<Date>();
		List<String> foggingChemical = new ArrayList<String>();
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
		 if(request.getParameter("srNo")!= null)
		  {
			 srNo = Integer.parseInt(request.getParameter("srNo"));
		  }
		 if(request.getParameter("srNo2")!= null)
		  {
			 srNo2 = Integer.parseInt(request.getParameter("srNo2"));
		  }
		 if(request.getParameter("srNo3")!= null)
		  {
			 srNo3 = Integer.parseInt(request.getParameter("srNo3"));
		  }
		 if(request.getParameter("srNo4")!= null)
		  {
			 srNo4 = Integer.parseInt(request.getParameter("srNo4"));
		  }
		 if(request.getParameter("srNo5")!= null)
		  {
			 srNo5 = Integer.parseInt(request.getParameter("srNo5"));
		  }
		 if(request.getParameter("srNo6")!= null)
		  {
			 srNo6 = Integer.parseInt(request.getParameter("srNo6"));
		  }
		 if(request.getParameter("srNo7")!= null)
		  {
			 srNo7 = Integer.parseInt(request.getParameter("srNo7"));
		  }
		 if(request.getParameter("srNo8")!= null)
		  {
			 srNo8 = Integer.parseInt(request.getParameter("srNo8"));
		  }
		 if(request.getParameter("srNo9")!= null)
		  {
			 srNo9 = Integer.parseInt(request.getParameter("srNo9"));
		  }
		 if(request.getParameter("srNo10")!= null)
		  {
			 srNo10 = Integer.parseInt(request.getParameter("srNo10"));
		  }
      for(int i=0; i<= srNo ; i++)	
      {
    	  
		if(request.getParameter("larvalDate"+i)!= null)
		   {
			larvalDate.add(HMSUtil.convertStringTypeDateToDateType(request.getParameter("larvalDate"+i)));
		   }
		if(request.getParameter("larvalChemical"+i)!= null)
		{
			larvalChemical.add((String) request.getParameter("larvalChemical"+i));			
		}
		if(request.getParameter("larvalarea"+i)!= null)
		{
			larvalarea.add(request.getParameter("larvalarea"+i));			
		}
		if(request.getParameter("larvalsupervisor"+i)!= null)
		 {
			larvalsupervisor.add(request.getParameter("larvalsupervisor"+i));			
		 }
		
		if(request.getParameter("larvalcarriedoutby"+i)!= null)
		   {
			larvalcarriedoutby.add(request.getParameter("larvalcarriedoutby"+i));			
		   }
		
		if(request.getParameter("larvalnoCovered"+i)!= null)
		   {
			larvalnoCovered.add(request.getParameter("larvalnoCovered"+i));			
		   }
		if(request.getParameter("larvalrecieve"+i)!= null)
		  {
			larvalrecieve.add(request.getParameter("larvalrecieve"+i));			
		  }
		if(request.getParameter("larvalissue"+i)!= null)
		  {
			larvalissue.add( request.getParameter("larvalissue"+i));			
		  }
		if(request.getParameter("larvalbalance"+i)!= null)
		  {
			larvalbalance.add(request.getParameter("larvalbalance"+i));			
		  }
		if(request.getParameter("larvalremarks"+i)!= null)
		{
			larvalremarks.add(request.getParameter("larvalremarks"+i));			
		}
      }
     for(int j=0; j<=srNo2; j++)
     {	
    	 
		if(request.getParameter("adultDate"+j)!= null)
		{
			adultDate.add( HMSUtil.convertStringTypeDateToDateType( request.getParameter("adultDate"+j)));
		}
		if(request.getParameter("adultChemical"+j)!= null)
		{
			adultChemical.add(request.getParameter("adultChemical"+j));
		}
		if(request.getParameter("adultarea"+j)!= null)
		{
			adultarea.add(request.getParameter("adultarea"+j));
		}
		if(request.getParameter("adultsupervisor"+j)!= null)
		{
			adultsupervisor.add(request.getParameter("adultsupervisor"+j));
		}
		if(request.getParameter("adultcarriedOut"+j)!= null)
		{
			adultcarriedOut.add( request.getParameter("adultcarriedOut"+j));
		}
		if(request.getParameter("adultnoCovered"+j)!= null)
		{
			adultnoCovered.add(request.getParameter("adultnoCovered"+j));
		}
		if(request.getParameter("adultrecieve"+j)!= null)
		{
			adultrecieve.add(request.getParameter("adultrecieve"+j));
		}
		if(request.getParameter("adultissue"+j)!= null)
		{
			adultissue.add(request.getParameter("adultissue"+j));
		}
		if(request.getParameter("adultbalance"+j)!= null)
		{
			adultbalance.add(request.getParameter("adultbalance"+j));
		}
		if(request.getParameter("adultremarks"+j)!= null)
		{
			adultremarks.add(request.getParameter("adultremarks"+j));
		}
     }
    for(int i=0; i<=srNo3; i++)
        {	
     
		if(request.getParameter("foggingDate"+i)!= null)
		   {
			foggingDate.add( HMSUtil.convertStringTypeDateToDateType(request.getParameter("foggingDate"+i)) );
		   }
		if(request.getParameter("foggingChemical"+i)!= null)
		  {
			foggingChemical.add(request.getParameter("foggingChemical"+i));
		  }
		if(request.getParameter("foggingarea"+i)!= null)
		 {
			foggingarea.add( request.getParameter("foggingarea"+i));
		 }
		if(request.getParameter("foggingsupervisor"+i)!= null)
		  {
			foggingsupervisor.add(request.getParameter("foggingsupervisor"+i));
		  }
		if(request.getParameter("foggingcarriedOut"+i)!= null)
		  {
			foggingcarriedOut.add(request.getParameter("foggingcarriedOut"+i)); 
		  }
		if(request.getParameter("foggingnoCovered"+i)!= null)
		  {
			foggingnoCovered.add(request.getParameter("foggingnoCovered"+i));
		  }
		if(request.getParameter("foggingreceive"+i)!= null)
		  {
			foggingreceive.add(request.getParameter("foggingreceive"+i));
		  }
		if(request.getParameter("foggingissue"+i) != null)
		  {
			foggingissue.add(request.getParameter("foggingissue"+i));
		  }
		if(request.getParameter("foggingbalance"+i)!= null)
		  {
			foggingbalance.add(request.getParameter("foggingbalance"+i));
		  }
		if(request.getParameter("foggingremarks"+i)!= null)
		  {
			foggingremarks.add(request.getParameter("foggingremarks"+i));
		  }
        }
    for(int i=0; i<=srNo4; i++)
    {	
		if(request.getParameter("ibnDate"+i)!= null)
		   {
			ibnDate.add( HMSUtil.convertStringTypeDateToDateType(request.getParameter("ibnDate"+i)));
		   }
		if(request.getParameter("ibnChemical"+i)!= null)
		   {
			ibnChemical.add(request.getParameter("ibnChemical"+i));
		   }
		if(request.getParameter("ibnarea"+i)!= null)
		   {
			ibnarea.add( request.getParameter("ibnarea"+i));
		   }
		if(request.getParameter("ibnsupervisor"+i)!= null)
		   {
			ibnsupervisor.add(request.getParameter("ibnsupervisor"+i));
		   }
		if(request.getParameter("ibncarriedOut"+i)!= null)
		  {
			ibncarriedOut.add(request.getParameter("ibncarriedOut"+i));
		  }
		if(request.getParameter("ibnnoCovered"+i)!= null)
		  {
			ibnnoCovered.add(request.getParameter("ibnnoCovered"+i));
		  }
		if(request.getParameter("ibnreceive"+i)!= null)
		  {
			ibnreceive.add(request.getParameter("ibnreceive"+i));
		  }
		if(request.getParameter("ibnissued"+i)!= null)
		  {
			ibnissued.add(request.getParameter("ibnissued"+i));
		  }
		if(request.getParameter("ibnbalance"+i)!= null)
		  {
			ibnbalance.add((String) request.getParameter("ibnbalance"+i));
		  }
		if(request.getParameter("ibnremarks"+i)!= null)
		  {
			ibnremarks.add(request.getParameter("ibnremarks"+i));
		  }
    }
    
     for(int i=0; i<=srNo5; i++)
     {	 
		if(request.getParameter("flyDate"+i)!= null)
		  {
			flyDate.add( (Date) HMSUtil.convertStringTypeDateToDateType(request.getParameter("flyDate"+i)));
		  }
		if(request.getParameter("antiFlyChemical"+i)!= null)
		  {
			antiFlyChemical.add(request.getParameter("antiFlyChemical"+i));
		  }
		if(request.getParameter("flyarea"+i)!= null)
		  {
			flyarea.add(request.getParameter("flyarea"+i));
		  }
		if(request.getParameter("flysupervisor"+i)!= null)
		  {
			flysupervisor.add(request.getParameter("flysupervisor"+i));			
		  }
		if(request.getParameter("flycarriedOut"+i)!= null)
		  {
			flycarriedOut.add(request.getParameter("flycarriedOut"+i));
		  }
		if(request.getParameter("flynoCovered"+i)!= null)
		  {
			flynoCovered.add(request.getParameter("flynoCovered"+i));
		  }
		if(request.getParameter("flyreceive"+i)!= null)
		  {
			flyreceive.add(request.getParameter("flyreceive"+i));
		  }
		if(request.getParameter("flyissued"+i)!= null)
		  {
			flyissued.add(request.getParameter("flyissued"+i));
		  }
		if(request.getParameter("flybalance"+i)!= null)
		  {
			flybalance.add(request.getParameter("flybalance"+i));
		  }
		if(request.getParameter("flyremarks"+i)!= null)
		  {
			flyremarks.add(request.getParameter("flyremarks"+i));
		  }
     }
     
     for(int i=0; i<=srNo6; i++)
     {
		if(request.getParameter("debuggingDate"+i)!= null)
		  {
			debuggingDate.add( HMSUtil.convertStringTypeDateToDateType(request.getParameter("debuggingDate"+i)));
		  }
		if(request.getParameter("debuggingChemical"+i)!= null)
		  {
			debuggingChemical.add(request.getParameter("debuggingChemical"+i));
		  }
		if(request.getParameter("debuggingarea"+i)!= null)
		  {
			debuggingarea.add(request.getParameter("debuggingarea"+i));
		  }
		if(request.getParameter("debuggingsupervisor"+i)!= null)
		  {
			debuggingsupervisor.add((String) request.getParameter("debuggingsupervisor"+i));
		  }
		if(request.getParameter("debuggingcarriedOut"+i)!= null)
		  {
			debuggingcarriedOut.add(request.getParameter("debuggingcarriedOut"+i));
		  }
		if(request.getParameter("debuggingnoCovered"+i)!= null)
		  {
			debuggingnoCovered.add( request.getParameter("debuggingnoCovered"+i));
		  }
		if(request.getParameter("debuggingreceive"+i)!= null)
		  {
			debuggingreceive.add(request.getParameter("debuggingreceive"+i));
		  }
		if(request.getParameter("debuggingissued"+i)!= null)
		  {
			debuggingissued.add( request.getParameter("debuggingissued"+i));
		  }
		if(request.getParameter("debuggingbalance"+i)!= null)
		  {
			debuggingbalance.add((String) request.getParameter("debuggingbalance"+i));
		  }
		if(request.getParameter("debuggingremarks"+i)!= null)
		  {
			debuggingremarks.add(request.getParameter("debuggingremarks"+i));
		  }
     }
     
     for(int i=0; i<=srNo7; i++)
     {
		if(request.getParameter("biologicalDate"+i)!= null)
		  {
			biologicalDate.add(HMSUtil.convertStringTypeDateToDateType(request.getParameter("biologicalDate"+i)));
		  }
		if(request.getParameter("biologicalChemical"+i)!= null)
		  {
			biologicalChemical.add(request.getParameter("biologicalChemical"+i));
		  }
		if(request.getParameter("biologicalarea"+i)!= null)
		  {
			biologicalarea.add(request.getParameter("biologicalarea"+i));
		  }
		if(request.getParameter("biologicalsupervisor"+i)!= null)
		  {
			biologicalsupervisor.add(request.getParameter("biologicalsupervisor"+i));
		  }
		if(request.getParameter("biologicalcarriedOut"+i)!= null)
		  {
			biologicalcarriedOut.add(request.getParameter("biologicalcarriedOut"+i));
		  }
		if(request.getParameter("biologicalnoCovered"+i)!= null)
		  {
			biologicalnoCovered.add(request.getParameter("biologicalnoCovered"+i));
		  }
		if(request.getParameter("biologicalreceive"+i)!= null)
		  {
			biologicalreceive.add(request.getParameter("biologicalreceive"+i));
		  }
		if(request.getParameter("biologicalissued"+i)!= null)
		  {
			biologicalissued.add(request.getParameter("biologicalissued"+i));
		  }
		if(request.getParameter("biologicalbalance"+i)!= null)
		  {
			biologicalbalance.add(request.getParameter("biologicalbalance"+i));
		  }
		if(request.getParameter("biologicalremarks"+i)!= null)
		  {
			biologicalremarks.add(request.getParameter("biologicalremarks"+i));
		  }
     }
     
     for(int i=0; i<=srNo8; i++)
     {
		if(request.getParameter("protectiveDate"+i)!= null)
		  {
			protectiveDate.add(HMSUtil.convertStringTypeDateToDateType(request.getParameter("protectiveDate"+i)));
		  }
		if(request.getParameter("protectiveMeasures"+i)!= null)
		  {
			protectiveMeasures.add(request.getParameter("protectiveMeasures"+i));
		  }
		if(request.getParameter("protectivesupervisor"+i)!= null)
		  {
			protectivesupervisor.add(request.getParameter("protectivesupervisor"+i));
		  }
		if(request.getParameter("protectiveremarks"+i)!= null)
		  {
			protectiveRemark.add(request.getParameter("protectiveremarks"+i));
		  }
		
     }
     
     for(int i=0; i<=srNo9; i++)
     {
		if(request.getParameter("antiMalariaDate"+i)!= null)
		  {
			antiMalariaDate.add(HMSUtil.convertStringTypeDateToDateType(request.getParameter("antiMalariaDate"+i)));
		  }
		if(request.getParameter("antiMalariaMeeting"+i)!= null)
		  {
			antiMalariaMeeting.add(request.getParameter("antiMalariaMeeting"+i));
		  }
		if(request.getParameter("suppressiveTreatment"+i)!= null)
		  {
			underSuppressiveTreatment.add(request.getParameter("suppressiveTreatment"+i));
		  }
		if(request.getParameter("antiMalariasupervisor"+i)!= null)
		  {
			antiMalariaSupervisor.add(request.getParameter("antiMalariasupervisor"+i));
		  }
		if(request.getParameter("antiMalariaremarks"+i)!= null)
		  {
			antiMalariaRemarks.add(request.getParameter("antiMalariaremarks"+i));
		  }
				
     }
     
     for(int i=0; i<=srNo10; i++)
     {
		if(request.getParameter("malariaCasesDate"+i)!= null)
		  {
			malariaCasesDate.add(HMSUtil.convertStringTypeDateToDateType(request.getParameter("malariaCasesDate"+i)));
		  }
		if(request.getParameter("examinedBloodSlides"+i)!= null)
		  {
			bloodSlidesExamined.add(request.getParameter("examinedBloodSlides"+i));
		  }
		if(request.getParameter("detectedMalariaCases"+i)!= null  && !request.getParameter("detectedMalariaCases"+i).equals(""))
		  {
			detectedMalariaCases.add(Integer.parseInt(request.getParameter("detectedMalariaCases"+i)));
		  }
		if(request.getParameter("type"+i)!= null)
		  {
			malariaCasesType.add(request.getParameter("type"+i));
		  }
		if(request.getParameter("category"+i)!= null)
		  {
			category.add(request.getParameter("category"+i));
		  }
		if(request.getParameter("plasmodium"+i)!= null)
		  {
			plasmodium.add(request.getParameter("plasmodium"+i));
		  }
		
		if(request.getParameter("properlyInvestigated"+i)!= null)
		  {
			properlyInvestigated.add(request.getParameter("properlyInvestigated"+i));
		  }
		if(request.getParameter("remedialMeasures"+i)!= null)
		  {
			remedialMeasures.add(request.getParameter("remedialMeasures"+i));
		  }
				
     }
		
     dataMap.put("hospitalId", hospitalId);
     dataMap.put("departmentId", departmentId);
     dataMap.put("larvalDate", larvalDate);
     dataMap.put("larvalarea", larvalarea);
     dataMap.put("larvalChemical", larvalChemical);
     dataMap.put("larvalsupervisor", larvalsupervisor);
     dataMap.put("larvalcarriedoutby", larvalcarriedoutby);
     dataMap.put("larvalnoCovered", larvalnoCovered);
     dataMap.put("larvalrecieve", larvalrecieve);
     dataMap.put("larvalissue", larvalissue);
     dataMap.put("larvalbalance", larvalbalance);
     dataMap.put("larvalremarks", larvalremarks);
     
     
     dataMap.put("adultDate", adultDate);
     dataMap.put("adultChemical", adultChemical);
     dataMap.put("adultarea", adultarea);
     dataMap.put("adultsupervisor", adultsupervisor);
     dataMap.put("adultcarriedOut", adultcarriedOut);
     dataMap.put("adultnoCovered", adultnoCovered);
     dataMap.put("adultrecieve", adultrecieve);
     dataMap.put("adultissue", adultissue);
     dataMap.put("adultbalance", adultbalance);
	 dataMap.put("adultremarks", adultremarks);
	 dataMap.put("foggingDate", foggingDate);
	 dataMap.put("foggingChemical", foggingChemical);
	 dataMap.put("foggingarea", foggingarea);
	 dataMap.put("foggingsupervisor", foggingsupervisor);
	 dataMap.put("foggingcarriedOut", foggingcarriedOut);
	 dataMap.put("foggingnoCovered", foggingnoCovered);
	 dataMap.put("foggingreceive", foggingreceive);
	 dataMap.put("foggingissue", foggingissue);
	 dataMap.put("foggingbalance", foggingbalance);
	 dataMap.put("foggingremarks", foggingremarks);
	 dataMap.put("ibnDate", ibnDate);
	 dataMap.put("ibnChemical", ibnChemical);
	 dataMap.put("ibnarea", ibnarea);
	 dataMap.put("ibnsupervisor", ibnsupervisor);
	 dataMap.put("ibncarriedOut", ibncarriedOut);
	 dataMap.put("ibnnoCovered", ibnnoCovered);
	 dataMap.put("ibnreceive", ibnreceive);
	 dataMap.put("ibnissued", ibnissued);
	 dataMap.put("ibnbalance", ibnbalance);
	 dataMap.put("ibnremarks", ibnremarks);
	 dataMap.put("flyDate", flyDate);
	 dataMap.put("antiFlyChemical", antiFlyChemical);
	 dataMap.put("flyarea", flyarea);
	 dataMap.put("flysupervisor", flysupervisor);
	 dataMap.put("flycarriedOut", flycarriedOut);
	 dataMap.put("flynoCovered", flynoCovered);
	 dataMap.put("flyreceive", flyreceive);
	 dataMap.put("flyissued", flyissued);
	 dataMap.put("flybalance", flybalance);
	 dataMap.put("flyremarks", flyremarks);
	 dataMap.put("debuggingDate", debuggingDate);
	 dataMap.put("debuggingChemical", debuggingChemical);
	 dataMap.put("debuggingarea", debuggingarea);
	 dataMap.put("debuggingsupervisor", debuggingsupervisor);
	 dataMap.put("debuggingcarriedOut", debuggingcarriedOut);
	 dataMap.put("debuggingnoCovered", debuggingnoCovered);
	 dataMap.put("debuggingreceive", debuggingreceive);		
	 dataMap.put("debuggingissued", debuggingissued);
	 dataMap.put("debuggingbalance", debuggingbalance);
	 dataMap.put("debuggingremarks", debuggingremarks);
	 dataMap.put("biologicalDate", biologicalDate);
	 dataMap.put("biologicalChemical", biologicalChemical);
	 dataMap.put("biologicalarea", biologicalarea);
	 dataMap.put("biologicalsupervisor", biologicalsupervisor);
	 dataMap.put("biologicalcarriedOut", biologicalcarriedOut);
	 dataMap.put("biologicalnoCovered", biologicalnoCovered);
	 dataMap.put("biologicalreceive", biologicalreceive);
	 dataMap.put("biologicalissued", biologicalissued);
	 dataMap.put("biologicalbalance", biologicalbalance);
	 dataMap.put("biologicalremarks", biologicalremarks);
	 dataMap.put("protectiveDate", protectiveDate); 
	 dataMap.put("protectiveMeasures", protectiveMeasures); 
	 dataMap.put("protectiveRemark", protectiveRemark); 
	 dataMap.put("protectivesupervisor", protectivesupervisor); 
	 
	 dataMap.put("antiMalariaDate", antiMalariaDate); 
	 dataMap.put("antiMalariaMeeting", antiMalariaMeeting); 
	 dataMap.put("antiMalariaSupervisor", antiMalariaSupervisor); 
	 dataMap.put("antiMalariaRemarks", antiMalariaRemarks); 
	 
	 dataMap.put("malariaCasesDate", malariaCasesDate); 
	 dataMap.put("bloodSlidesExamined", bloodSlidesExamined); 
	 dataMap.put("detectedMalariaCases", detectedMalariaCases); 
	 dataMap.put("malariaCasesType", malariaCasesType); 
	 dataMap.put("category", category); 
	 dataMap.put("plasmodium", plasmodium);
	 dataMap.put("properlyInvestigated", properlyInvestigated); 
	 dataMap.put("remedialMeasures", remedialMeasures); 
	 
	 
	 dataMap.put("srNo", srNo);
	 dataMap.put("srNo2",srNo2);
	 dataMap.put("srNo3", srNo3);
	 dataMap.put("srNo4", srNo4);
	 dataMap.put("srNo5", srNo5); 
	 dataMap.put("srNo6", srNo6);
	 dataMap.put("srNo7", srNo7);
	 dataMap.put("srNo8", srNo8);
	 dataMap.put("srNo9", srNo9);
	 dataMap.put("srNo10", srNo10);
		boolean successfullyAdded = misHandlerService.submitVectorControlActivity(dataMap);
		if(successfullyAdded)
		  {
			message = "Record Save Successfully Save ";
		  }
		else
		  {
			message = "Try Again";
		  }
		jsp = "messageForVectorControlActivity";
		jsp += ".jsp";
		title = "MeetingHeldAgency";
		map.put("contentJsp", jsp);
		map.put("message", message);
		
		return new ModelAndView("indexB","map", map);
	 }
	
	public ModelAndView submitMonthlyWorkload(HttpServletRequest request,HttpServletResponse response)
	{
		
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		session = request.getSession();
		
		int unitId = 0;
		int hospitalId = 0;
		String totalPopulation = "";
		String OffAirCrew = "";
		String OffGD = "";
		String airmenAirCrew = "";
		String airmenOthers = "";
		String ncs = "";
		String dsc = "";
		String allFamilies = "";
		String totalSick = "";
		String populationSick = "";
		String servicePerson = "";
		String families = "";
		String total = "";
		String populationServicePerson = "";
		String allPerson = "";
		String populationAll = "";
		String medicalBoard = "";
		String medicalExam = "";
		String month = "";
		String changedBy = "";
		String changedDate = "";
		String changedTime = "";
		
			if (session.getAttribute("hospitalId") != null)
		    {
			     hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		    }
			
			if (request.getParameter("unitId") != null && !(request.getParameter("unitId").equals(""))) 
			{
				unitId = (Integer.parseInt(request.getParameter("unitId")));
			}
			
			if (request.getParameter("totalPopulation") != null && !(request.getParameter("totalPopulation").equals(""))) 
			{
				totalPopulation = (request.getParameter("totalPopulation"));
			}
			
			if (request.getParameter("OffAirCrew") != null && !(request.getParameter("OffAirCrew").equals(""))) 
			{
				OffAirCrew = (request.getParameter("OffAirCrew"));
			}
			
			if (request.getParameter("OffGD") != null && !(request.getParameter("OffGD").equals(""))) 
			{
				OffGD = (request.getParameter("OffGD"));
			}
			
			if (request.getParameter("airmenAirCrew") != null && !(request.getParameter("airmenAirCrew").equals(""))) 
			{
				airmenAirCrew = (request.getParameter("airmenAirCrew"));
			}
			
			if (request.getParameter("airmenOthers") != null && !(request.getParameter("airmenOthers").equals(""))) 
			{
				airmenOthers = (request.getParameter("airmenOthers"));
			}
			
			if (request.getParameter("ncs") != null && !(request.getParameter("ncs").equals(""))) 
			{
				ncs = (request.getParameter("ncs"));
			}
			
			if (request.getParameter("dsc") != null && !(request.getParameter("dsc").equals(""))) 
			{
				dsc = (request.getParameter("dsc"));
			}
			
			if (request.getParameter("allFamilies") != null && !(request.getParameter("allFamilies").equals(""))) 
			{
				allFamilies = (request.getParameter("allFamilies"));
			}
			
			if (request.getParameter("totalSick") != null && !(request.getParameter("totalSick").equals(""))) 
			{
				totalSick = (request.getParameter("totalSick"));
			}
			
			if (request.getParameter("populationSick") != null && !(request.getParameter("populationSick").equals(""))) 
			{
				populationSick = (request.getParameter("populationSick"));
			}
			
			if (request.getParameter("servicePerson") != null && !(request.getParameter("servicePerson").equals(""))) 
			{
				servicePerson = (request.getParameter("servicePerson"));
			}
			
			if (request.getParameter("families") != null && !(request.getParameter("families").equals(""))) 
			{
				families = (request.getParameter("families"));
			}
			
			if (request.getParameter("total") != null && !(request.getParameter("total").equals(""))) 
			{
				total = (request.getParameter("total"));
			}
			
			if (request.getParameter("populationServicePerson") != null && !(request.getParameter("populationServicePerson").equals(""))) 
			{
				populationServicePerson = (request.getParameter("populationServicePerson"));
			}
			
			if (request.getParameter("allPerson") != null && !(request.getParameter("allPerson").equals(""))) 
			{
				allPerson = (request.getParameter("allPerson"));
			}
			
			if (request.getParameter("populationAll") != null && !(request.getParameter("populationAll").equals(""))) 
			{
				populationAll = (request.getParameter("populationAll"));
			}
			
			if (request.getParameter("medicalBoard") != null && !(request.getParameter("medicalBoard").equals(""))) 
			{
				medicalBoard = (request.getParameter("medicalBoard"));
			}
			
			if (request.getParameter("medicalExam") != null && !(request.getParameter("medicalExam").equals(""))) 
			{
				medicalExam = (request.getParameter("medicalExam"));
			}
			
			if (request.getParameter("month") != null && !(request.getParameter("month").equals(""))) 
			{
				month = (request.getParameter("month"));
			}
			
			if (request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))) 
			{
			   changedBy = (request.getParameter(CHANGED_BY));
			}
			
			
			if (request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))) 
			{
				changedDate = (request.getParameter(CHANGED_DATE));
			}
				
			if (request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))) 
			{
				changedTime = request.getParameter(CHANGED_TIME);
			}
		
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("month", month);
			dataMap.put("unitId", unitId);
			dataMap.put("totalPopulation", totalPopulation);
			dataMap.put("OffAirCrew", OffAirCrew);
		
			dataMap.put("OffGD", OffGD);
			dataMap.put("airmenAirCrew", airmenAirCrew);
			dataMap.put("airmenOthers", airmenOthers);
			dataMap.put("ncs", ncs);
		
			dataMap.put("dsc", dsc);
			dataMap.put("allFamilies", allFamilies);
			dataMap.put("totalSick", totalSick);
			dataMap.put("populationSick", populationSick);
		
			dataMap.put("servicePerson", servicePerson);
			dataMap.put("families", families);
			dataMap.put("total", total);
			dataMap.put("populationServicePerson", populationServicePerson);
		
			dataMap.put("allPerson", allPerson);
			dataMap.put("populationAll", populationAll);
			dataMap.put("medicalBoard", medicalBoard);
			dataMap.put("medicalExam", medicalExam);
			
			dataMap.put("changedBy", changedBy);
			dataMap.put("changedDate", changedDate);
			dataMap.put("changedTime", changedTime);
		
		boolean successfullyAdded = misHandlerService.submitMonthlyWorkload(dataMap);
		
		if(successfullyAdded)
		  {
			message = "Record saved Successfully.";
		  }
		else
		  {
			message = "Try Again !!";
		  }
		
		jsp = "messageForMonthlyWorkload";
		jsp += ".jsp";
		
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
		
	}
	
	public ModelAndView submitAccidentalDetailJsp(HttpServletRequest request,HttpServletResponse response)
	 {    
		Map<String,Object> map = new HashMap<String,Object>(); 
		session = request.getSession();
		  int hospitalId =0;
	       int departmentId = 0;
	       int hinId = 0;
	       int hinIdRider = 0;
	       Date dateOfAccident = new Date() ;
	       String timeOfAccident = "";
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
	       String headInjuryPerson1 = "";
	       String headInjuryPerson2 = "";
	       String headInjuryPerson3 = "";
	       String fracturesDriver ="";
	       String fracturesPillorR = "";
	       String fracturesPerson1 = "";
	       String fracturesPerson2 = "";
	       String fracturesPerson3 = "";
	       String minorInjDriver = "";
	       String minorInjPillorR = "";
	       String minorInjPerson1 ="";
	       String minorInjPerson2 ="";
	       String minorInjPerson3 = "";
	       String otherInjDriver = "";
	       String otherInjPillorR = "";
	       String otherInjPerson1 = "";
	       String otherInjPerson2 ="";
	       String otherInjPerson3 = "";
	       String crashHelmetInjuredPerson = "";
	       String isiDriver = "";
	       String crashHelmetUsedByPillionR = "";
	       String crashHelmetUsedByisiPillionR = "";
	       String chinStrapDriver = "";
	       String chinStrapPillionRider = "";
	       String comeOfHeadDuringAccidentDriver = "";
	       String comeOfHeadDuringAccidentPillionR = "";
	       String extentDamageDriver = "";
	       String extentDamagePillionRider = "";
	       String brakLightWorkingOrder = "";
	       String admittedToDriver = "";
	       String admittedToPillionR = "";
	       String admittedToOther = "";
	       String noDaySpentinHospitalDriver = "";
	       String noDaySpentinHospitalPillionR = "";
	       String noDaySpentinHospitalOther = "";
	       String noDayLowerMedCatDriver = "";
	       String noDayLowerMedCatPillionR = "";
	       String noDayLowerMedCatOther = "";
	       String noOfFlyHourDriver = "";
	       String noOfFlyHourPillionR = "";
	       String noOfFlyHourOther = "";
	       String finalCatInjDriver = "";
	       String finalCatInjPillionRider = "";
	       String finalCatInjOther = "";
	       String deathInjResponsibleDriver = "";
	       String deathInjResponsiblePillionR = "";
	       String deathInjResponsibleOther = "";
	       String Remarks = "";
	       String roadCondition ="";
	       String accidentType = "";
	       String otherPersonInjured = "";
	       String crashHelmetUsedByDriver ="";
	       String OtherCauseofAccident = "";
	       String deathCase = "";
	       
	       if(session.getAttribute("hospitalId")!= null)
	         {	   hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	    	            }
	       if(session.getAttribute("deptId")!= null)
	         {
	    	   departmentId = Integer.parseInt(""+session.getAttribute("deptId"));
	         }
			if (request.getParameter("hinId") != null
					&& !(request.getParameter("hinId").equals(""))) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
			}
			if (request.getParameter("hinIdRider") != null
					&& !(request.getParameter("hinIdRider").equals(""))) {
				hinIdRider = Integer.parseInt(request.getParameter("hinIdRider"));
			}
				
		    if(request.getParameter("dateOfAccident")!= null)
		      {
		    	dateOfAccident = HMSUtil.convertStringTypeDateToDateType(request.getParameter("dateOfAccident"));
		      }
		    if(request.getParameter("deathCase")!= null)
		      {
		    	deathCase = (request.getParameter("deathCase"));
		      }
		    if(request.getParameter("crashHelmetUsedByDriver")!= null)
		      {
		    	crashHelmetUsedByDriver = (request.getParameter("crashHelmetUsedByDriver"));
		      }
		    
		    if(request.getParameter("timeOfAccident") != null)
		     {
		    	timeOfAccident = request.getParameter("timeOfAccident");
		     }
		    if(request.getParameter("typeOfVehicle")!= null)
		    {
		    	typeOfVehicle = request.getParameter("typeOfVehicle");
		    }
		    if(request.getParameter("vehicleNo")!= null)
		    {
		    	vehicleNo = request.getParameter("vehicleNo");
		    }
		    if(request.getParameter("oldVehicle") != null)
		      {
		    	oldVehicle =  request.getParameter("oldVehicle");
		      }
		    if(request.getParameter("driverDutyStatus") != null)
		      {
		    	driverDutyStatus = request.getParameter("driverDutyStatus");
		      }
		    if(request.getParameter("pillionDutyStatus") != null)
		      {
		    	pillionDutyStatus = request.getParameter("pillionDutyStatus");
		      }
		    if(request.getParameter("placeOfAccident")!= null)
		    {
		    	placeOfAccident = request.getParameter("placeOfAccident");
		    }
		    if(request.getParameter("causeofAccident") != null)
		    {
		    	causeofAccident = request.getParameter("causeofAccident"); 
		    }
		    if(request.getParameter("approxSpeed")!= null)
		       {
		    	approxSpeed = request.getParameter("approxSpeed");
		       }
		    if(request.getParameter("headInjuryDriver")!= null)
		       {
		    	headInjuryDriver = request.getParameter("headInjuryDriver");
		       }
		    if(request.getParameter("headInjuryPillionR")!= null)
		       {
		    	headInjuryPillionR = request.getParameter("headInjuryPillionR");
		       }
		    if(request.getParameter("headInjuryPerson1")!= null)
		       {
		    	headInjuryPerson1 = request.getParameter("headInjuryPerson1");
		       }
		    if(request.getParameter("headInjuryPerson2")!= null)
		       {
		    	headInjuryPerson2 = request.getParameter("headInjuryPerson2");
		       }
		    if(request.getParameter("headInjuryPerson3")!= null)
		       {
		    	headInjuryPerson3 = request.getParameter("headInjuryPerson3");
		       }
		    if(request.getParameter("fracturesDriver")!= null)
		       {
		    	fracturesDriver = request.getParameter("fracturesDriver");
		       }
		    if(request.getParameter("fracturesPillorR")!= null)
		       {
		    	fracturesPillorR = request.getParameter("fracturesPillorR");
		       }
		    if(request.getParameter("fracturesPerson1")!= null)
		       {
		    	fracturesPerson1 = request.getParameter("fracturesPerson1");
		       }
		    if(request.getParameter("fracturesPerson2")!= null)
		       {
		    	fracturesPerson2 = request.getParameter("fracturesPerson2");
		       }
		    if(request.getParameter("fracturesPerson3")!= null)
		       {
		    	fracturesPerson3 = request.getParameter("fracturesPerson3");
		       }
		    if(request.getParameter("minorInjDriver")!= null)
		       {
		    	minorInjDriver = request.getParameter("minorInjDriver");
		       }
		    if(request.getParameter("minorInjPillorR")!= null)
		       {
		    	minorInjPillorR = request.getParameter("minorInjPillorR");
		       }
		    if(request.getParameter("minorInjPerson1")!= null)
		       {
		    	minorInjPerson1 = request.getParameter("minorInjPerson1");
		       }
		    if(request.getParameter("minorInjPerson2")!= null)
		       {
		    	minorInjPerson2 = request.getParameter("minorInjPerson2");
		       }
		    if(request.getParameter("minorInjPerson3")!= null)
		       {
		    	minorInjPerson3 = request.getParameter("minorInjPerson3");
		       }
		    if(request.getParameter("otherInjDriver")!= null)
		       {
		    	otherInjDriver = request.getParameter("otherInjDriver");
		       }
		    if(request.getParameter("otherInjPillorR")!= null)
		       {
		    	otherInjPillorR = request.getParameter("otherInjPillorR");
		       }
		    if(request.getParameter("otherInjPerson1")!= null)
		       {
		    	otherInjPerson1 = request.getParameter("otherInjPerson1");
		       }
		    if(request.getParameter("otherInjPerson2")!= null)
		       {
		    	otherInjPerson2 = request.getParameter("otherInjPerson2");
		       }
		    if(request.getParameter("otherInjPerson3")!= null)
		       {
		    	otherInjPerson3 = request.getParameter("otherInjPerson3");
		       }
		    if(request.getParameter("crashHelmetInjuredPerson")!= null)
		       {
		    	crashHelmetInjuredPerson = request.getParameter("crashHelmetInjuredPerson");
		       }
		    if(request.getParameter("isiDriver")!= null)
		       {
		    	isiDriver = request.getParameter("isiDriver");
		       }
		    if(request.getParameter("crashHelmetUsedByPillionR")!= null)
		       {
		    	crashHelmetUsedByPillionR = request.getParameter("crashHelmetUsedByPillionR");
		       }
		    if(request.getParameter("chinStrapDriver")!= null)
		       {
		    	chinStrapDriver = request.getParameter("chinStrapDriver");
		       }
		    if(request.getParameter("chinStrapPillionRider")!= null)
		       {
		    	chinStrapPillionRider = request.getParameter("chinStrapPillionRider");
		       }
		    if(request.getParameter("comeOfHeadDuringAccidentDriver")!= null)
		       {
		    	comeOfHeadDuringAccidentDriver = request.getParameter("comeOfHeadDuringAccidentDriver");
		       }
		    if(request.getParameter("extentDamageDriver")!= null)
		       {
		    	extentDamageDriver = request.getParameter("extentDamageDriver");
		       }
		    if(request.getParameter("extentDamagePillionRider")!= null)
		       {
		    	extentDamagePillionRider = request.getParameter("extentDamagePillionRider");
		       }
		    if(request.getParameter("brakLightWorkingOrder")!= null)
		       {
		    	brakLightWorkingOrder = request.getParameter("brakLightWorkingOrder");
		       }
		    if(request.getParameter("admittedToDriver")!= null)
		       {
		    	admittedToDriver = request.getParameter("admittedToDriver");
		       }
		    if(request.getParameter("admittedToPillionR")!= null)
		       {
		    	admittedToPillionR = request.getParameter("admittedToPillionR");
		       }
		    if(request.getParameter("admittedToOther")!= null)
		       {
		    	admittedToOther = request.getParameter("admittedToOther");
		       }
		    if(request.getParameter("noDaySpentinHospitalDriver")!= null)
		       {
		    	noDaySpentinHospitalDriver = request.getParameter("noDaySpentinHospitalDriver");
		       }
		    if(request.getParameter("noDaySpentinHospitalPillionR")!= null)
		       {
		    	noDaySpentinHospitalPillionR = request.getParameter("noDaySpentinHospitalPillionR");
		       }
		    if(request.getParameter("noDaySpentinHospitalOther")!= null)
		       {
		    	noDaySpentinHospitalOther = request.getParameter("noDaySpentinHospitalOther");
		       }
		    if(request.getParameter("noDayLowerMedCatDriver")!= null)
		       {
		    	noDayLowerMedCatDriver = request.getParameter("anoDayLowerMedCatDriver");
		       }
		    if(request.getParameter("noDayLowerMedCatPillionR")!= null)
		       {
		    	noDayLowerMedCatPillionR = request.getParameter("noDayLowerMedCatPillionR");
		       }
		    if(request.getParameter("noDayLowerMedCatOther")!= null)
		       {
		    	noDayLowerMedCatOther = request.getParameter("noDayLowerMedCatOther");
		       }
		    if(request.getParameter("noOfFlyHourDriver")!= null)
		       {
		    	noOfFlyHourDriver = request.getParameter("noOfFlyHourDriver");
		       }
		    if(request.getParameter("noOfFlyHourPillionR")!= null)
		       {
		    	noOfFlyHourPillionR = request.getParameter("noOfFlyHourPillionR");
		       }
		    if(request.getParameter("noOfFlyHourOther")!= null)
		       {
		    	noOfFlyHourOther = request.getParameter("noOfFlyHourOther");
		       }
		    if(request.getParameter("finalCatInjDriver")!= null)
		       {
		    	finalCatInjDriver = request.getParameter("finalCatInjDriver");
		       }
		    if(request.getParameter("finalCatInjPillionRider")!= null)
		       {
		    	finalCatInjPillionRider = request.getParameter("finalCatInjPillionRider");
		       }
		    if(request.getParameter("finalCatInjOther")!= null)
		       {
		    	finalCatInjOther = request.getParameter("finalCatInjOther");
		       }
		    if(request.getParameter("deathInjResponsibleDriver")!= null)
		       {
		    	deathInjResponsibleDriver = request.getParameter("deathInjResponsibleDriver");
		       }
		    if(request.getParameter("deathInjResponsiblePillionR")!= null)
		       {
		    	deathInjResponsiblePillionR = request.getParameter("deathInjResponsiblePillionR");
		       }
		    if(request.getParameter("deathInjResponsibleOther")!= null)
		       {
		    	deathInjResponsibleOther = request.getParameter("deathInjResponsibleOther");
		       }
		    if(request.getParameter("Remarks")!= null)
		       {
		    	Remarks = request.getParameter("Remarks");
		       }
		    if(request.getParameter("roadCondition")!= null)
		       {
		    	roadCondition = request.getParameter("roadCondition");
		       }
		    if(request.getParameter("accidentType")!= null)
		       {
		    	accidentType = request.getParameter("accidentType");
		       }
		    if(request.getParameter("otherPersonInjured")!= null)
		       {
		    	otherPersonInjured = request.getParameter("otherPersonInjured");
		       }
		    if(request.getParameter("OtherCauseofAccident")!= null)
		       {
		    	OtherCauseofAccident = request.getParameter("OtherCauseofAccident");
		       }
		    
		    
		    map.put("hospitalId", hospitalId);
		    map.put("departmentId", departmentId);
		    map.put("hinId", hinId);
		    map.put("hinIdRider", hinIdRider);
		    map.put("dateOfAccident", dateOfAccident);
		    map.put("timeOfAccident", timeOfAccident);
		    map.put("typeOfVehicle", typeOfVehicle);
		    map.put("vehicleNo", vehicleNo);
		    map.put("oldVehicle", oldVehicle);
		    map.put("driverDutyStatus", driverDutyStatus);
		    map.put("pillionDutyStatus", pillionDutyStatus);
		    map.put("placeOfAccident", placeOfAccident);
		    map.put("causeofAccident", causeofAccident);
		    map.put("approxSpeed", approxSpeed);
		    map.put("headInjuryDriver", headInjuryDriver);
		    map.put("headInjuryPillionR", headInjuryPillionR);
		    map.put("headInjuryPerson1", headInjuryPerson1);
		    map.put("headInjuryPerson2", headInjuryPerson2);
		    map.put("headInjuryPerson3", headInjuryPerson3);
		    map.put("fracturesDriver", fracturesDriver);
		    map.put("fracturesPillorR", fracturesPillorR);
		    map.put("fracturesPerson1", fracturesPerson1);
		    map.put("fracturesPerson2", fracturesPerson2);
		    map.put("fracturesPerson3", fracturesPerson3);
		    map.put("minorInjDriver", minorInjDriver);
		    map.put("minorInjPillorR", minorInjPillorR);
		    map.put("minorInjPerson1", minorInjPerson1);
		    map.put("minorInjPerson2", minorInjPerson2);
		    map.put("minorInjPerson3", minorInjPerson3);
		    map.put("otherInjDriver", otherInjDriver);
		    map.put("otherInjPillorR", otherInjPillorR);
		    map.put("otherInjPerson1", otherInjPerson1);
		    map.put("otherInjPerson2", otherInjPerson2);
		    map.put("otherInjPerson3", otherInjPerson3);
		    map.put("crashHelmetInjuredPerson", crashHelmetInjuredPerson);
		    map.put("isiDriver", isiDriver);
		    map.put("crashHelmetUsedByPillionR", crashHelmetUsedByPillionR);
		    map.put("chinStrapDriver", chinStrapDriver);
		    map.put("chinStrapPillionRider", chinStrapPillionRider);
		    map.put("comeOfHeadDuringAccidentDriver", comeOfHeadDuringAccidentDriver);
		    map.put("extentDamageDriver", extentDamageDriver);
		    map.put("extentDamagePillionRider", extentDamagePillionRider);
		    map.put("brakLightWorkingOrder", brakLightWorkingOrder);
		    map.put("admittedToDriver", admittedToDriver);
		    map.put("admittedToPillionR", admittedToPillionR);
		    map.put("admittedToOther", admittedToOther);
		    map.put("noDaySpentinHospitalDriver", noDaySpentinHospitalDriver);
		    map.put("noDaySpentinHospitalPillionR", noDaySpentinHospitalPillionR);
		    map.put("noDaySpentinHospitalOther", noDaySpentinHospitalOther);
		    map.put("noDayLowerMedCatDriver", noDayLowerMedCatDriver);
		    map.put("noDayLowerMedCatPillionR", noDayLowerMedCatPillionR);
		    map.put("noDayLowerMedCatOther", noDayLowerMedCatOther);
		    map.put("noOfFlyHourDriver", noOfFlyHourDriver);
		    map.put("noOfFlyHourPillionR", noOfFlyHourPillionR);
		    map.put("noOfFlyHourOther", noOfFlyHourOther);
		    map.put("finalCatInjDriver", finalCatInjDriver);
		    map.put("finalCatInjPillionRider", finalCatInjPillionRider);
		    map.put("finalCatInjOther", finalCatInjOther);
		    map.put("deathInjResponsibleDriver", deathInjResponsibleDriver);
		    map.put("deathInjResponsiblePillionR", deathInjResponsiblePillionR);
		    map.put("deathInjResponsibleOther", deathInjResponsibleOther);
		    map.put("Remarks", Remarks);
		    map.put("roadCondition", roadCondition);
		    map.put("accidentType", accidentType);
		    map.put("otherPersonInjured", otherPersonInjured);
		    map.put("crashHelmetUsedByDriver", crashHelmetUsedByDriver);
		    map.put("OtherCauseofAccident", OtherCauseofAccident);
		    map.put("deathCase", deathCase);
		    
		    
		    
		boolean successfullyAdded  = misHandlerService.submitAccidentalDetailJsp(map);
		int accidentId=0;
		if(map.get("accidentId") != null){
			accidentId = (Integer)map.get("accidentId");
		}
		if(successfullyAdded)
		  {
			message = "Record Save Successfully. Do you want to print!! ";
		  }
		else 
		  {
			message = "Try Again !!";
		  }
		jsp = "messageForAccidentalDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message",message);
		return new ModelAndView("indexB","map",map);
	 }
  public ModelAndView submitFreeFromInfection(HttpServletRequest request,HttpServletResponse response)
    {   HttpSession  session = request.getSession();
        int hospitalId = 0;
	    int departmentId = 0;
	    List<Integer> serialNoList = new ArrayList<Integer>() ; 
	    List<Date> infectionDateList = new ArrayList<Date>();
	    List<String> PurposeList = new ArrayList<String>();
	    List<String> particularIndList = new ArrayList<String>();
	    List<String> FitUnfitList = new ArrayList<String>();
	    List<String> placeList = new ArrayList<String>();
	    int hdb1 =1;
	  if(session.getAttribute("hospitalId")!= null)
      {	   hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));          
 	  }
    if(session.getAttribute("deptId")!= null)
      {
 	   departmentId = Integer.parseInt(""+session.getAttribute("deptId")); 	    
      }
    if(request.getParameter("srNo")!= null)
	   {
	      hdb1 = Integer.parseInt(request.getParameter("srNo"));
	   }

    for(int i=1; i<=hdb1; i++ )
    {
       if(request.getParameter("serialNo"+i)!= null)
       {
    	   serialNoList.add(Integer.parseInt(request.getParameter("serialNo"+i)));
    	   
       }
       if(request.getParameter("infectionDate"+i)!= null)
       {
    	   infectionDateList.add(HMSUtil.convertStringTypeDateToDateType(request.getParameter("infectionDate"+i)));
    	   
    	          }
       
       if(request.getParameter("place"+i)!= null)
       {
    	   placeList.add(request.getParameter("place"+i));
       }
      if(request.getParameter("Purpose"+i)!= null)
         {
    	  PurposeList.add(request.getParameter("Purpose"+i));
    	  
         }
      if(request.getParameter("particularInd"+i)!= null)
         {
    	  particularIndList.add(request.getParameter("particularInd"+i));    	  
    	  
         }
       if(request.getParameter("Fit_Unfit")!= null)
       {
    	   FitUnfitList.add(request.getParameter("Fit_Unfit"));    	   
    	   
       }
      
    }        
      map.put("hospitalId",hospitalId);
      map.put("departmentId",departmentId);
      map.put("serialNoList",serialNoList);
      map.put("infectionDateList",infectionDateList);
      map.put("PurposeList",PurposeList);
      map.put("particularIndList",particularIndList);
      map.put("FitUnfitList",FitUnfitList);
      map.put("placeList", placeList);
      map.put("hdb1",hdb1);
	  boolean successfullyAdded  = misHandlerService.submitFreeFromInfection(map); 
	  if(successfullyAdded)
	  {
		message = "Record Save Successfully ";
	  }
	else 
	  {
		message = "Try Again";
	  }
	  jsp = "messageForFreeFromInfection";
	  jsp += ".jsp";
	  map.put("contentJsp", jsp);
	  map.put("message", message);
	  return new ModelAndView("indexB","map",map);
    }
	
  public ModelAndView submitWaterSurveillanceJsp(HttpServletRequest request,HttpServletResponse response)
   {
	    HttpSession  session = request.getSession();
        int hospitalId = 0;
	    int departmentId = 0;
	    int hdb1 =1;
	    List<Integer> serialNoList = new ArrayList<Integer>() ; 
	    List<Date> waterSurveillancedateList = new ArrayList<Date>();
	    List<String> typeOfExaminationList = new ArrayList<String>();
	    List<String> sourceList = new ArrayList<String>();
	    List<String> placeList = new ArrayList<String>();
	    List<String> quantityList = new ArrayList<String>();
	    List<String> resultList = new ArrayList<String>();
	    List<String> remarksList = new ArrayList<String>();
	    
	    if(session.getAttribute("hospitalId")!= null)
	      {	   hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));          
	 	  }
	    if(session.getAttribute("deptId")!= null)
	      {
	 	   departmentId = Integer.parseInt(""+session.getAttribute("deptId")); 	    
	      }
	    if(request.getParameter("srNo")!= null)
		   {
		      hdb1 = Integer.parseInt(request.getParameter("srNo"));
		      
		   }
	    for(int i=1; i<= hdb1 ;i++)
	    {
	    	if(request.getParameter("serialNo"+i)!= null)
	        {
	    		
	     	   serialNoList.add(Integer.parseInt(request.getParameter("serialNo"+i)));
	     	   
	        }  
	        
	        if(request.getParameter("waterSurveillancedate"+i)!= null)
	        {
	        	waterSurveillancedateList.add(HMSUtil.convertStringTypeDateToDateType(request.getParameter("waterSurveillancedate"+i)));
	     	     
	     	          }
	        
	        if(request.getParameter("typeOfExamination"+i)!= null)
	        {
	        	typeOfExaminationList.add(request.getParameter("typeOfExamination"+i));
	        }
	       if(request.getParameter("source"+i)!= null)
	          {
	    	   sourceList.add(request.getParameter("source"+i));
	     	  
	          }
	       if(request.getParameter("place"+i)!= null)
	          {
	    	   placeList.add(request.getParameter("place"+i));
	     	  
	          }
	       
	       if(request.getParameter("quantity"+i)!= null)
	          {
	    	   quantityList.add(request.getParameter("quantity"+i));
	     	  
	          }
	       
	       if(request.getParameter("result"+i)!= null)
	          {
	    	   resultList.add(request.getParameter("result"+i));
	     	  
	          }
	       if(request.getParameter("remarks"+i)!= null)
	          {
	    	   remarksList.add(request.getParameter("remarks"+i));
	     	  
	          }    	
	    	
	    }
	     map.put("hospitalId",hospitalId);
	      map.put("departmentId",departmentId);
	      map.put("serialNoList",serialNoList);
	      map.put("waterSurveillancedateList",waterSurveillancedateList);
	      map.put("typeOfExaminationList",typeOfExaminationList);
	      map.put("sourceList",sourceList);
	      map.put("placeList",placeList);
	      map.put("resultList", resultList);
	      map.put("quantityList", quantityList);
	      map.put("remarksList", remarksList);
	      map.put("hdb1",hdb1);
	  boolean successfullyAdded= misHandlerService.submitWaterSurveillanceJsp(map);
	  if(successfullyAdded)
	  {
		  message = "Record Save Successfully";
	  }
	  else 
	  {
		  message= "Try Again";
	  }
	  jsp = "messageForWaterSurveillance";
	  jsp += ".jsp";
	  map.put("contentJsp", jsp);
	  map.put("message", message);
	  return new ModelAndView("indexB","map",map);
   }
  public ModelAndView submitHealthPromotionActivityJsp(HttpServletRequest request,HttpServletResponse response)
    {   HttpSession  session = request.getSession();
        int hospitalId = 0;
        int departmentId = 0;
        int serialNo = 0;
        int hdb=1;
        List<Date> approximatedate2 = new ArrayList<Date>();
        List<String> HealthPromotiontopic = new ArrayList<String>();
        
        List<String> HealthPromotionSubject = new ArrayList<String>();
        List<String> HealthPromotionRankCat = new ArrayList<String>();
        
        List<String> HealthPromotionplace = new ArrayList<String>();
        List<String> HealthPromotionattended = new ArrayList<String>() ;
        List<String> HealthPromotionremarks = new ArrayList<String>();
        if(session.getAttribute("hospitalId")!= null)
        {	   hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));          
   	     }
      if(session.getAttribute("deptId")!= null)
        {
   	      departmentId = Integer.parseInt(""+session.getAttribute("deptId")); 	    
        }
      for(int i=1; i<=hdb; i++)
      {
    	  if(request.getParameter("serialNo"+i)!= null)
    	  	{
    		  serialNo = Integer.parseInt(request.getParameter("serialNo"+i));
    	  	}
    	  if(request.getParameter("healthPromotionDate"+i)!= null)
    	  {    		  approximatedate2.add( HMSUtil.convertStringTypeDateToDateType(request.getParameter("healthPromotionDate"+i)));
    	  	}
    	  if(request.getParameter("HealthPromotiontopic"+i)!= null)
    	  	{
    		  HealthPromotiontopic.add(request.getParameter("HealthPromotiontopic"+i));
    	  	}	
    	  
    	  if(request.getParameter("HealthPromotionSubject"+i)!= null)
  	  	{
    		  HealthPromotionSubject.add(request.getParameter("HealthPromotionSubject"+i));
  	  	}
    	  
    	  if(request.getParameter("HealthPromotionRankCat"+i)!= null)
  	  	{
    		  HealthPromotionRankCat.add(request.getParameter("HealthPromotionRankCat"+i));
  	  	}
    	  
    	  if(request.getParameter("HealthPromotionplace"+i)!= null)
    	  	{
    		  HealthPromotionplace.add(request.getParameter("HealthPromotionplace"+i));
    	  	}
    	  if(request.getParameter("HealthPromotionattended"+i)!= null)
    	  	{
    		  HealthPromotionattended.add(request.getParameter("HealthPromotionattended"+i));
    	  	}
    	  if(request.getParameter("HealthPromotionremarks"+i)!= null)
    	  	{
    		  HealthPromotionremarks.add( request.getParameter("HealthPromotionremarks"+i));
    	  	}
    	  if(request.getParameter("srNo")!= null)
    	  	{
    		  hdb = Integer.parseInt(request.getParameter("srNo"));
	   	   }
      }
	  map.put("hospitalId",hospitalId);
	  map.put("departmentId",departmentId);
	  map.put("serialNo", serialNo);
	  map.put("approximatedate2",approximatedate2);
	  map.put("HealthPromotiontopic",HealthPromotiontopic);
	  
	  map.put("HealthPromotionSubject",HealthPromotionSubject);
	  map.put("HealthPromotionRankCat",HealthPromotionRankCat);
	  
	  map.put("HealthPromotionplace",HealthPromotionplace);
	  map.put("HealthPromotionattended",HealthPromotionattended);
	  map.put("HealthPromotionremarks",HealthPromotionremarks);
	  map.put("hdb",hdb);
	  boolean successfullyAdded  = misHandlerService.submitHealthPromotionActivityJsp(map); 
	  if(successfullyAdded)
	  {
		message = "Record Save Successfully ";
	  }
	else 
	  {
		message = "Try Again";
	  } 
	  
	  jsp = "messageForHealthPromotionActivity";
	  jsp += ".jsp";
	  map.put("contentJsp", jsp);
	  map.put("message", message);
	  return new ModelAndView("indexB","map",map);
    }
  
  public ModelAndView submitUploadDocuments(HttpServletRequest request,
			HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		MultipartFormDataRequest mrequest = null;
		String fileName = null;
		String message = null;
		String folderName="";
		String hin_no = "";
		String fileExtension = null;
		int hospitalId;
		int visitId = 0;
		int hinId=0;
		int masExamId=0;
		String userName = "";
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {

				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		dataMap.put("mrequest", mrequest);
		HttpSession session = request.getSession();
      if(request.getParameter("hin_no")!=null )
      {
      	hin_no = (String) request.getParameter("hin_no");
      	dataMap.put("hin_no", hin_no);
      }
      if(request.getParameter("folderName")!=null )
      {
    	  folderName = (String) request.getParameter("folderName");
      	dataMap.put("folderName",folderName);
      }
      if(request.getParameter("hin_id")!=null )
      {
      	hinId = Integer.parseInt(request.getParameter("hin_id"));
      	dataMap.put("hinId", hinId);
      }
      int investId=0;
      if(request.getParameter("invest_id")!=null )
      {
      	investId =Integer.parseInt(request.getParameter("invest_id"));
      	dataMap.put("investId", investId);
      }
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			dataMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			dataMap.put("userName", userName);
		}
      if(request.getParameter("visitId")!=null )
      {
      	visitId=Integer.parseInt(request.getParameter("visitId"));
      	dataMap.put("visitId", visitId);
      }
      if(request.getParameter("masExam_Id")!=null )
      {
      	masExamId=Integer.parseInt(request.getParameter("masExam_Id"));
      	dataMap.put("masMedicalExamId", masExamId);
      }
      
    
		int uploadCount =0;
		if(request.getParameter("uploadCount")!=null )
      {
			uploadCount =Integer.parseInt(request.getParameter("uploadCount"));
      }   
		List<String> fileNameList=new ArrayList<String>();
		List<String> fileExtensionList=new ArrayList<String>();
		List<String> descriptionList=new ArrayList<String>();
		List<Integer> counterList=new ArrayList<Integer>();
		int i = 1;
		for (i = 1; i <= uploadCount; i++)
		{
			if (!request.getParameter("filename" + i).equals("")) 
			{
				StringTokenizer strToken = new StringTokenizer(request.getParameter("filename" + i), ".");

				fileName = strToken.nextToken();
				fileExtension = strToken.nextToken();
				fileNameList.add(fileName);
				fileExtensionList.add(fileExtension);
				String description="";
				if(mrequest.getParameter("description" + i)!=null && !mrequest.getParameter("description" + i).equals(""))
				{	
					description=mrequest.getParameter("description"+ i);
				}   
				descriptionList.add(description);
				counterList.add(i);
				
			}
		}
		
		dataMap.put("fileNameList", fileNameList);
		dataMap.put("fileExtensionList", fileExtensionList);
		dataMap.put("descriptionList", descriptionList);
		dataMap.put("counterList", counterList);
		map=misHandlerService.submitUploadDocumentsVectorControlForSho(dataMap);
		
	
		Boolean fileUploaded = false;
		fileUploaded = (Boolean) map.get("status");
		if (fileUploaded) {
			message = "File Uploaded Sucessfully!!";
		} else {
			message = "Data Cannot be Saved !!";
		}
		Map<String, Object> dataMap12 = new HashMap<String, Object>();
		dataMap12.put("masExamId", masExamId);
		dataMap12.put("hinId", hinId);
		dataMap12.put("visitId", visitId);
		map= misHandlerService.displayFileUploadData(dataMap12);
		map.put("message", message);
		map.put("visitId", visitId);
		map.put("hinNo", hin_no);
		map.put("hinId", hinId);
		map.put("invest_id", investId);
		map.put("masExamId",masExamId);
		map.put("folderName", folderName);
		String jsp = "shoVectorControl_uploadpatientdoc";
		
		
		return new ModelAndView(jsp, "map", map);
	}
  
  public ModelAndView viewUploadDocumentsDetails(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int hospitalId=0;
		int visitId = 0;
		int hinId=0;
		int masExamId=0;
		HttpSession session = request.getSession();
      if(request.getParameter("hinId")!=null )
      {
      	hinId = Integer.parseInt(request.getParameter("hinId"));
      	dataMap.put("hinId",hinId);
      }
      String folderName="";
      if(request.getParameter("folderName")!=null )
      {
      	folderName = request.getParameter("folderName");
      	dataMap.put("folderName",folderName);
      }
      if (session.getAttribute(HOSPITAL_ID) != null) 
		{
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			dataMap.put("hospitalId",hospitalId);
		}
      if(request.getParameter("visitId")!=null )
      {
      	visitId=Integer.parseInt(request.getParameter("visitId"));
      	dataMap.put("visitId",visitId);
      }
     /* if(request.getParameter("masExam_Id")!=null )
      {
      	masExamId=Integer.parseInt(request.getParameter("masExam_Id"));
      	dataMap.put("masExamId",masExamId);
      }*/
		
		/*String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"HMSDocumentFolder"+fileSeparator+"upload"+fileSeparator+folderName+fileSeparator;
		String[] files = null;
		try {
			File fileDir = new File(uploadURL + fileSeparator + hin_no);
			
			if (fileDir.exists()) {
				files = fileDir.list();
			}
		} catch (Exception exc) {
			exc.printStackTrace();

		}*/
   
         map=misHandlerService.getUploadDocumentDetails(dataMap);
			//String jsp = "medicalExamViewDocumentsPopUp";
			//String jsp = "medicalExamViewDocument";
            String jsp = "shoViewDocument";
			map.put("hinId", hinId);
			map.put("folderName", folderName);
			map.put("visitId", visitId);
			map.put("contentJsp", jsp);
			return new ModelAndView(jsp, "map", map);
		
	}
  
  public ModelAndView viewShoUploadDocument(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		String filename = null;
		String fileExtension = null;
		HttpSession session = request.getSession();
		Map<String,Object> dataMap=new HashMap<String,Object>();
		Map<String,Object> map=new HashMap<String,Object>();
      if(request.getParameter("filename")!=null )
      {
      	filename = (String) request.getParameter("filename");
      }
      
      if(request.getParameter("fileExt")!=null )
      {
      	fileExtension = (String) request.getParameter("fileExt");
      }
     
      int hinId=0;
      if(request.getParameter("hinId")!=null )
      {
      	hinId = Integer.parseInt(request.getParameter("hinId"));
      }
      int medExamId=0;
      if(request.getParameter("medExamId")!=null )
      {
      	medExamId = Integer.parseInt(request.getParameter("medExamId"));
      }int hospitalId=0;
      if (session.getAttribute(HOSPITAL_ID) != null) 
		{
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
      String folderName="";
      if(request.getParameter("folderName")!=null )
      {
      	folderName = (String) request.getParameter("folderName");
      }
      dataMap.put("folderName", folderName);
	   dataMap.put("filename", filename);
	   dataMap.put("fileExtension", fileExtension);
	   dataMap.put("hinId", hinId);
	   dataMap.put("medExamId", medExamId);
	   dataMap.put("hospitalId", hospitalId);	
	   map =  misHandlerService.getUploadDocumentShoData(dataMap);
	  
	   try {
			if (fileExtension == "doc" || fileExtension == "docx") {
				response.setContentType("application/vnd.ms-word");
			} else if (fileExtension == "xls" || fileExtension == "xlsx") {
				response.setContentType("application/vnd.ms-excel");
			} else if (fileExtension == "pdf") {
				response.setContentType("application/pdf");
			} else if (fileExtension.trim().equalsIgnoreCase("txt")) {
				response.setContentType("text/plain");
			} else if (fileExtension.trim().equalsIgnoreCase("tiff")) {
				response.setContentType("image/tiff");
			}else if (fileExtension.trim().equalsIgnoreCase("bmp")) {
				response.setContentType("image/bmp");
			}
			else if (fileExtension.trim().equalsIgnoreCase("png"))
			{
				response.setContentType("image/png");
			} else if (fileExtension.trim().equalsIgnoreCase("jpeg")) {
				response.setContentType("image/jpeg");
			} else if (fileExtension.trim().equalsIgnoreCase("wbmp")) {
				response.setContentType("image/vnd.wap.wbmp");
			} else if (fileExtension.trim().equalsIgnoreCase("gif")) {
				response.setContentType("image/gif");
			} else if (fileExtension.trim().equalsIgnoreCase("jpg")){
				response.setContentType("image/jpg");
			} else {
				response.setContentType("application/octet-stream");
			}
			// set the header and also the Name by which user will be prompted
			// to save
			response.setHeader("Content-Disposition", "attachment;filename="
					+ java.net.URLEncoder.encode(filename+"."+fileExtension)
					+ "");

			List<MasMedicalUploadDocument> masMedicalUploadDocumentList=(List<MasMedicalUploadDocument>)map.get("masMedicalUploadDocumentList");
			if(masMedicalUploadDocumentList.size()>0)
			{
				MasMedicalUploadDocument masMedicalUploadDocument=masMedicalUploadDocumentList.get(0);						
				byte[] bytes =masMedicalUploadDocument.getDocument();
			    response.getOutputStream().flush();
			    ServletOutputStream outs = response.getOutputStream();
			    outs.write(bytes);
			} 

		  } catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return null;
	}
  public ModelAndView	saveWaterSurvillanceDetails(HttpServletRequest request,HttpServletResponse response)
	 {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		session = request.getSession();
		if(session.getAttribute("hospitalId")!=null){
		hospitalId=(Integer)session.getAttribute("hospitalId");
		}
		int departmentId= 0;
	    departmentId = Integer.parseInt(""+session.getAttribute("deptId"));
	    int userId = 0;
	    if(session.getAttribute("users")!= null)
	    {
		Users user = (Users)session.getAttribute("users");	    
		userId = user.getEmployee().getId();
	    }		
		box.put("hospitalId", hospitalId);
		box.put("departmentId", departmentId);
		box.put("userId", userId);
	    boolean successfullyAdded = misHandlerService.saveWaterSurvillanceDetails(box);
		if(successfullyAdded)
		{
			message = "Record Save Successfully Save ";
		}
		else
		{
			message = "Try Again";
		}
		jsp = "messageForVectorControlActivity";
		jsp += ".jsp";
		title = "MeetingHeldAgency";
		map.put("contentJsp", jsp);
		map.put("message", message);
	    return new ModelAndView("indexB","map", map);
	 }

  //---By Kiran for Monthly Sick Return...
  
  public ModelAndView showMonthlySickRpt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = misHandlerService.showEDReturnsJsp();
		jsp = "stats_sick_Rpt.jsp";
	
		title = "Monthly Sick Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
  public ModelAndView generateMonthlySickReport(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = null;
		Date toDate = null;
		Box box = null;
		int hospitalId=0;
		if(session.getAttribute("box")!=null){
			box = (Box)session.getAttribute("box");
		}else{
			box = HMSUtil.getBox(request);
		}
		if (!box.getString(FROM_DATE).equals("")) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE));
		}
		
		if (!box.getString(TO_DATE).equals("")) {
			toDate = HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE));
		}
		String qry = "";
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("") && !request.getParameter("cmdId").equals("0") && request.getParameter("hospitalId")!=null && request.getParameter("hospitalId").equals("0") && request.getParameter("hospitalId").equals("")){
			
			qry += "  and h.command_id="+Integer.parseInt(request.getParameter("cmdId"));
		}else{
			if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("") && !request.getParameter("hospitalId").equals("0")){
				hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
			}else{
				hospitalId = (Integer)session.getAttribute("hospitalId");
			}
			qry += "  and opd.hospital_id="+hospitalId;
			
		}
		if(request.getParameter(CATEGORY_ID)!=null && !request.getParameter(CATEGORY_ID).equals("")){
			qry += " and rc.rank_category_id="+Integer.parseInt(request.getParameter(CATEGORY_ID));
			
		}
		
		Map<String, Object> connectionMap = misHandlerService
		.getConnectionForReport();
 	    
 	     //parameters.put("hin_id", hin_id);
 	    parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports"));
 	     //HMSUtil.generateReport("NotifiableDisease", parameters,(Connection)map.get("conn"),response,getServletContext());
 	   parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);
		HMSUtil.generateReport("MonthlySickReturn", parameters,
				(Connection) connectionMap.get("conn"), response, getServletContext());		
		return null;
	}
  
  public  ModelAndView showFoodHandlerReportJsp(HttpServletRequest request,HttpServletResponse response)
  { Map<String,Object>  map = new HashMap<String,Object>();
	jsp = "foodHandlerReportJsp";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index","map",map);
  }
  
  public ModelAndView printFoodHandlerReport(HttpServletRequest request,HttpServletResponse response)
  {  Map<String,Object>  map = new HashMap<String,Object>();	    
	Date toDate = null;
	Date fromDate = null;
	int hospitalId =0;
     session = request.getSession();
	byte[] bytes = null;
	try {
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		
		if (session.getAttribute("hospitalId") != null)
		{
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		 

	} catch (Exception e) {
		e.printStackTrace();
	}
	map = misHandlerService.getDBConnection();
	map.put("fromDate", fromDate);
	map.put("toDate", toDate);
	map.put("hospitalId", hospitalId);
	try {
	
		HMSUtil
				.generateReport("foodHandler", map,
						(Connection) map.get("conn"), response,
						getServletContext());

	} catch (Exception e) {

		e.printStackTrace();
	}
	return null;
	
  }
  
  //-------By Kiran to print for Food handler 
  
  public ModelAndView printPerformaFoodHandlerDetail(HttpServletRequest request,HttpServletResponse response)
  {
	Map<String,Object>  map = new HashMap<String,Object>();	    
	
	int FhId =0;
     session = request.getSession();
	byte[] bytes = null;
	try {
		if (request.getParameter("FhId") != null && !(request.getParameter("FhId").equals(""))) {
			FhId = Integer.parseInt(request.getParameter("FhId"));
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	map = misHandlerService.getDBConnection();
	map.put("FhId", FhId);
	
	try {
			HMSUtil.generateReport("sho_FoodHandler", map,(Connection) map.get("conn"), response,getServletContext());

	} catch (Exception e) {

		e.printStackTrace();
	}
	return null;

  }
  
  //------to print school Inspection screen
  
  public ModelAndView printSchoolInspectionDetail(HttpServletRequest request,HttpServletResponse response)
  {
	Map<String,Object>  map = new HashMap<String,Object>();	    
	
	int  schInsId= 0;
     session = request.getSession();
	byte[] bytes = null;
	try {
		if (request.getParameter("schInsId") != null && !(request.getParameter("schInsId").equals(""))) {
			schInsId = Integer.parseInt(request.getParameter("schInsId"));
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	map = misHandlerService.getDBConnection();
	map.put("schInsId", schInsId);
	
	try {
			HMSUtil.generateReport("sho_SchInspection", map,(Connection) map.get("conn"), response,getServletContext());

	} catch (Exception e) {

		e.printStackTrace();
	}
	return null;

  }
  
  //------To print sanitary round screen
  
  public ModelAndView printSanitaryRoundDetail(HttpServletRequest request,HttpServletResponse response)
  {
	Map<String,Object>  map = new HashMap<String,Object>();	    
	
	int sanitaryId = 0;
     session = request.getSession();
	byte[] bytes = null;
	try {
		if (request.getParameter("sanitaryId") != null && !(request.getParameter("sanitaryId").equals(""))) {
			sanitaryId = Integer.parseInt(request.getParameter("sanitaryId"));
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	map = misHandlerService.getDBConnection();
	map.put("sanitaryId", sanitaryId);
	
	try {
			HMSUtil.generateReport("sho_sanitaryRound", map,(Connection) map.get("conn"), response,getServletContext());

	} catch (Exception e) {

		e.printStackTrace();
	}
	return null;

  }
  
  //-------- To print Attempt to suicide
  
  public ModelAndView printAttamptSuicideDetail(HttpServletRequest request,HttpServletResponse response)
  {
	Map<String,Object>  map = new HashMap<String,Object>();	    
	
	int suicideId = 0;
     session = request.getSession();
	byte[] bytes = null;
	try {
		if (request.getParameter("suicideId") != null && !(request.getParameter("suicideId").equals(""))) {
			suicideId = Integer.parseInt(request.getParameter("suicideId"));
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	map = misHandlerService.getDBConnection();
	map.put("suicideId", suicideId);
	
	try {
			HMSUtil.generateReport("sho_attamptSuicide", map,(Connection) map.get("conn"), response,getServletContext());

	} catch (Exception e) {

		e.printStackTrace();
	}
	return null;

  }
  
  //----attempted to suicide reports
  
  public ModelAndView showSuicideReportJsp(HttpServletRequest request,HttpServletResponse response)
  {  Map<String,Object> map = new HashMap<String,Object>();
     jsp = "suicideReportJsp";
     jsp += ".jsp";
	 map.put("contentJsp", jsp);
	return new ModelAndView("index","map",map);
  }
  
  //---print analetical report for suicide
  
  public ModelAndView generateSuicideReport(HttpServletRequest request,HttpServletResponse response)
  {
	Map<String,Object>  map = new HashMap<String,Object>();	    
	
	Date toDate = null;
	Date fromDate = null;
    session = request.getSession();
	byte[] bytes = null;
	int hospitalId=0;
	try {
		if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		
		if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		
		if(session.getAttribute("hospitalId")!= null)
        {	   
			hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
   	 	}

	} catch (Exception e) {
		e.printStackTrace();
	}
	map = misHandlerService.getDBConnection();
	map.put("fromDate", fromDate);
	map.put("toDate", toDate);
	map.put("hospitalId", hospitalId);
	
	try {
			HMSUtil.generateReport("suicideCaseReport", map,(Connection) map.get("conn"), response,getServletContext());

	} catch (Exception e) {

		e.printStackTrace();
	}
	return null;

  }

  //---school inspection report jsp
  
  public ModelAndView showSchoolInspectionReportJsp(HttpServletRequest request,HttpServletResponse response)
  {  Map<String,Object> map = new HashMap<String,Object>();
     jsp = "schoolInspectionReportJsp";
     jsp += ".jsp";
	 map.put("contentJsp", jsp);
	return new ModelAndView("index","map",map);
  }
  
  //---print analetical report for suicide
  
  public ModelAndView generateSchoolInspectionReport(HttpServletRequest request,HttpServletResponse response)
  {
	Map<String,Object>  map = new HashMap<String,Object>();	    
	
	Date toDate = null;
	Date fromDate = null;
    session = request.getSession();
	byte[] bytes = null;
	try {
		if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		
		if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	map = misHandlerService.getDBConnection();
	map.put("fromDate", fromDate);
	map.put("toDate", toDate);
	
	try {
			HMSUtil.generateReport("schoolHealthServices", map,(Connection) map.get("conn"), response,getServletContext());

	} catch (Exception e) {

		e.printStackTrace();
	}
	return null;

  }

 //----Sanitary round reports
  
  public ModelAndView showSanitaryRoundJsp(HttpServletRequest request,HttpServletResponse response)
  {  Map<String,Object> map = new HashMap<String,Object>();
     jsp = "sanitaryRoundReportJsp";
     jsp += ".jsp";
	 map.put("contentJsp", jsp);
	return new ModelAndView("index","map",map);
  }
  
  //---print Sanitary Round report
  
  public ModelAndView generateSanitaryRoundReport(HttpServletRequest request,HttpServletResponse response)
  {
	Map<String,Object>  map = new HashMap<String,Object>();	    
	
	Date toDate = null;
	Date fromDate = null;
	int year = 0;
    session = request.getSession();
	byte[] bytes = null;
	try {
		if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		
		if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	map = misHandlerService.getDBConnection();
	map.put("fromDate", fromDate);
	map.put("toDate", toDate);
	
	try {
			HMSUtil.generateReport("sanitary_round_report", map,(Connection) map.get("conn"), response,getServletContext());

	} catch (Exception e) {

		e.printStackTrace();
	}
	return null;

  }
  
  //-------- To print Attempt to suicide
  
  public ModelAndView printFeedBackCounselorDetail(HttpServletRequest request,HttpServletResponse response)
  {
	Map<String,Object>  map = new HashMap<String,Object>();	    
	
	int feedBackId = 0;
     session = request.getSession();
	byte[] bytes = null;
	try {
		if (request.getParameter("feedBackId") != null && !(request.getParameter("feedBackId").equals(""))) {
			feedBackId = Integer.parseInt(request.getParameter("feedBackId"));
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	map = misHandlerService.getDBConnection();
	map.put("feedBackId", feedBackId);
	
	try {
			HMSUtil.generateReport("sho_feedback_counselor", map,(Connection) map.get("conn"), response,getServletContext());

	} catch (Exception e) {

		e.printStackTrace();
	}
	return null;

  }
  
  //--------By Kiran for Family Health Programme
  
	public ModelAndView showFamilyHealthProgrammeJsp(HttpServletRequest request,HttpServletResponse response)
	 {
		Map<String,Object> map = new HashMap<String,Object>();
		
		/*List<Category> categoryList = new ArrayList<Category>();
		categoryList = (List<Category>) map.get("categoryList");
		System.out.println("categoryList--CON->"+categoryList.size());*/
		try{
		map = misHandlerService.showFamilyHealthProgrammeJsp();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		jsp = "sho_familyHealthProgramme";
		jsp += ".jsp";
		title = "Family Health Programme";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB","map",map);
	 }
	
	public ModelAndView submitFamilyHealthProgrammeJsp(HttpServletRequest request,HttpServletResponse response)
	 {    
		Map<String,Object> map = new HashMap<String,Object>(); 
		session = request.getSession();
		
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
		  int hospitalId =0;
		  Date healthDate = new Date();

		  if(request.getParameter("healthDate")!= null)
		  {
			  healthDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("healthDate"));
		  }
	       
		     if(request.getParameter("niddm")!= null)
	         {	   
		    	 niddm = (String)request.getParameter("niddm");
	    	 }
		     if(request.getParameter("dentalCaries")!= null)
	         {	   
		    	 dentalCaries = (String)request.getParameter("dentalCaries");
	    	 }
	       if(request.getParameter("unitname")!= null)
	         {	   
	    	   unitname = (Integer.parseInt(request.getParameter("unitname")));
	    	 }
	       
	       if(request.getParameter("halfYear")!= null)
	         {
	    	   halfYear = (String)request.getParameter("halfYear");
	         }
	       
	       if(request.getParameter("ageGroup")!= null)
	         {
	    	   ageGroup = (String)request.getParameter("ageGroup");
	         }
	       
	       if(request.getParameter("year")!= null)
	         {
	    	   year = (Integer.parseInt(request.getParameter("year")));
	         }
	         
	       if(request.getParameter("totalStrength")!= null)
	         {
	    	   totalStrength = (Integer.parseInt(request.getParameter("totalStrength")));
	         }
	       
	       if(request.getParameter("noSpouseExamined")!= null)
	         {
	    	   noSpouseExamined = (Integer.parseInt(request.getParameter("noSpouseExamined")));
	         }
	       
	       if(request.getParameter("noExamined")!= null)
	         {
	    	   noExamined = (Integer.parseInt(request.getParameter("noExamined")));
	         }
	       
	       if(request.getParameter("overWeight")!= null)
	         {
	    	   overWeight = (String)request.getParameter("overWeight");
	         }
	      
	       if(request.getParameter("obese")!= null)
	         {
	    	   obese = (String)request.getParameter("obese");
	         }
	       
	       if(request.getParameter("abdomenExam")!= null)
	         {
	    	   abdomenExam = (String)request.getParameter("abdomenExam");
	         }
	       
	       if(request.getParameter("breastExam")!= null)
	         {
	    	   breastExam = (String)request.getParameter("breastExam");
	         }
	       
	       if(request.getParameter("htn")!= null)
	         {
	    	   htn = (String)request.getParameter("htn");
	         }
	       
	       if(request.getParameter("cardiacAbnormal")!= null)
	         {
	    	   cardiacAbnormal = (String)request.getParameter("cardiacAbnormal");
	         }
	       
	       if(request.getParameter("ecgAbnormility")!= null)
	         {
	    	   ecgAbnormility = (String)request.getParameter("ecgAbnormility");
	         }
	       
	       if(request.getParameter("refractoryError")!= null)
	         {
	    	   refractoryError = (String)request.getParameter("refractoryError");
	         }
	       
	       if(request.getParameter("bloodAnaemia")!= null)
	         {
	    	   bloodAnaemia = (String)request.getParameter("bloodAnaemia");
	         }
	       
	       if(request.getParameter("bloodSugar")!= null)
	         {
	    	   bloodSugar = (String)request.getParameter("bloodSugar");
	         }
	       
	       if(request.getParameter("bloodThyroid")!= null)
	         {
	    	   bloodThyroid = (String)request.getParameter("bloodThyroid");
	         }
	       
	       if(request.getParameter("bloodLapid")!= null)
	         {
	    	   bloodLapid = (String)request.getParameter("bloodLapid");
		     }
	       
	       if(session.getAttribute("hospitalId")!= null)
	         {	   
	    	   hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	    	 }

		    map.put("unitname", unitname);
		    map.put("ageGroup", ageGroup);
		    map.put("year", year);
		    map.put("totalStrength", totalStrength);
		    map.put("noSpouseExamined", noSpouseExamined);
		    map.put("noExamined", noExamined);
		    map.put("overWeight", overWeight);
		    map.put("obese", obese);
		    map.put("abdomenExam", abdomenExam);
		    map.put("breastExam", breastExam);
		    map.put("htn", htn);
		    map.put("cardiacAbnormal", cardiacAbnormal);
		    map.put("ecgAbnormility", ecgAbnormility);
		    map.put("refractoryError", refractoryError);
		    map.put("bloodAnaemia", bloodAnaemia);
		    map.put("bloodSugar", bloodSugar);
		    map.put("bloodThyroid", bloodThyroid);
		    map.put("bloodLapid", bloodLapid);
		    map.put("hospitalId", hospitalId);
		    map.put("halfYear", halfYear);
		    map.put("niddm", niddm);
		    map.put("dentalCaries", dentalCaries);
		    map.put("healthDate", healthDate);
		    
		    
	
		boolean successfullyAdded  = misHandlerService.submitFamilyHealthProgrammeJsp(map);
		/*int accidentId=0;
		if(map.get("accidentId") != null){
			accidentId = (Integer)map.get("accidentId");
			//System.out.println("accidentId--Con->"+accidentId);
		}*/
		if(successfullyAdded)
		  {
			message = "Record added Successfully.";
		  }
		else 
		  {
			message = "Try Again !!";
		  }
		jsp = "messageForFamilyHealthProgramme";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message",message);
		return new ModelAndView("indexB","map",map);
	 }
	
	public  ModelAndView showFamilyHealthProgrammeReport(HttpServletRequest request,HttpServletResponse response)
	  { Map<String,Object>  map = new HashMap<String,Object>();
	  map = misHandlerService.showFamilyHealthProgrammeReport();
		jsp = "familyHealthProgrammeReportJsp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	  }
	
	 public ModelAndView generateFamilyHealthProgrammeReport(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object>  map = new HashMap<String,Object>();	    
		
		int year=0;
		String halfYear="";
		int unitname=0;
		String ageGroup="";
		int commandId=0;
		String commandName="";
	    session = request.getSession();
	    
		byte[] bytes = null;
		try {
			if (request.getParameter("year") != null && !(request.getParameter("year").equals(""))) {
				year = (Integer.parseInt(request.getParameter("year")));
			}
			
			if (request.getParameter("unitname") != null && !(request.getParameter("unitname").equals(""))) {
				unitname = (Integer.parseInt(request.getParameter("unitname")));
			}
			
			if (request.getParameter("halfYear") != null && !(request.getParameter("halfYear").equals(""))) {
				halfYear = (request.getParameter("halfYear"));
			}
			
			if (request.getParameter("ageGroup") != null && !(request.getParameter("ageGroup").equals(""))) {
				ageGroup = (request.getParameter("ageGroup"));
			}
			
			if(session.getAttribute("commandId")!= null)
	          {	 
				commandId = Integer.parseInt(""+session.getAttribute("commandId"));
				commandName = misHandlerService.getCommandName(commandId);
	 	      }

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("year", year);
		map.put("commandName", commandName);
		map.put("unitname", unitname);
		map.put("halfYear", halfYear);
		map.put("ageGroup", ageGroup);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports"));
		
		try {
				HMSUtil.generateReport("sho_familyHealthProgramme", map,(Connection) map.get("conn"), response,getServletContext());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	  }
	
	
	
	public ModelAndView submitMortalityAmongstFamiliesJsp(HttpServletRequest request,HttpServletResponse response)
	 {  
		Map<String,Object> map = new HashMap<String,Object>();
	    int hospitalId =0;
       String placeOfDeath = "";
       String causeOfDeath="";
       int hinId=0;
       int dischargeStatusId = 0;
       String diagnosis = "";
       String presentCondition = "";
       Date dateOfDeath = new Date();
       
        if(session.getAttribute("hospitalId")!= null)
          {	 
       	 hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
 	      }
      
		if (request.getParameter("hinId") != null && !(request.getParameter("hinId").equals("")))
		  {
			   hinId = Integer.parseInt(request.getParameter("hinId"));
		  }
		
		if (request.getParameter("dischargeStatusId") != null && !(request.getParameter("dischargeStatusId").equals("")))
		  {
			dischargeStatusId = Integer.parseInt(request.getParameter("dischargeStatusId"));
		  }
		
		if(request.getParameter("dateOfDeath") != null && !(request.getParameter("dateOfDeath").equals("")))
		 {
			dateOfDeath = HMSUtil.convertStringTypeDateToDateType(request.getParameter("dateOfDeath"));
		 }
		
		if(request.getParameter("placeOfDeath") != null && !(request.getParameter("placeOfDeath").equals("")))
		 {
			placeOfDeath = (request.getParameter("placeOfDeath"));
		 }
		
		if(request.getParameter("causeOfDeath") != null && !(request.getParameter("causeOfDeath").equals("")))
		 {
			causeOfDeath = (request.getParameter("causeOfDeath"));
		 }
		
		if(request.getParameter("presentCondition") != null && !(request.getParameter("presentCondition").equals("")))
		 {
			presentCondition = (request.getParameter("presentCondition"));
		 }
		
		map.put("hospitalId", hospitalId);
		map.put("diagnosis", diagnosis);
		map.put("hinId", hinId);
		map.put("dateOfDeath", dateOfDeath);
		map.put("placeOfDeath", placeOfDeath);
		map.put("causeOfDeath", causeOfDeath);
		map.put("dischargeStatusId", dischargeStatusId);
		map.put("presentCondition", presentCondition);
		
		
		boolean successfullyAdded = misHandlerService.submitMortalityAmongstFamiliesJsp(map);
		/*int suicideId=0;
		if(map.get("suicideId") != null){
			suicideId = (Integer)map.get("suicideId");
		}*/
		if(successfullyAdded)
		 {
			message ="Record Added Successfully.";
		 } 
		else 
		 {
			message = "Try Again !!";
		 }
		jsp="messageForMortalityAmongstFamily";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("indexB","map",map);
		
		
	 }
	//------submit hiv details
	
	public ModelAndView showActivityAgainstHiv(HttpServletRequest request,
			HttpServletResponse response) {
			
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		//map = misHandlerService.showNotifiableDiseaseJsp(generalMap);
		jsp = "activitiesDetails";
		jsp += ".jsp";
		title = "Preventable Disease";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView submitActivityAgainstHiv(HttpServletRequest request,HttpServletResponse response)
	 {  
		
	  Map<String,Object> map = new HashMap<String,Object>();
	  session = request.getSession();	
	  Date activityDate= new Date();
      String activityDetails = "";
      String officers = "";
      int hospitalId=0;
      String sncosAirmen = "";
      String families = "";
      String remarks="";
      
      try
      {
    	if(session.getAttribute("hospitalId")!= null)
		  {
			hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
		  }
		if (request.getParameter("activityDetails") != null && !(request.getParameter("activityDetails").equals("")))
		  {
			activityDetails = (request.getParameter("activityDetails"));
		  }
		
		if (request.getParameter("officers") != null && !(request.getParameter("officers").equals("")))
		  {
			officers = (request.getParameter("officers"));
		  }
		
		if(request.getParameter("activityDate") != null && !(request.getParameter("activityDate").equals("")))
		 {
			activityDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("activityDate"));
		 }
		
		if(request.getParameter("sncosAirmen") != null && !(request.getParameter("sncosAirmen").equals("")))
		 {
			sncosAirmen = (request.getParameter("sncosAirmen"));
		 }
		if(request.getParameter("families") != null && !(request.getParameter("families").equals("")))
		 {
			families = (request.getParameter("families"));
		 }
		
		if(request.getParameter("remarks") != null && !(request.getParameter("remarks").equals("")))
		 {
			remarks = (request.getParameter("remarks"));
		 }
      } catch (Exception e) {

			e.printStackTrace();
		}

		
		map.put("hospitalId", hospitalId);
		map.put("activityDetails", activityDetails);
		map.put("officers", officers);
		map.put("activityDate", activityDate);
		map.put("sncosAirmen", sncosAirmen);
		map.put("families", families);
		map.put("remarks", remarks);
		
		
		boolean successfullyAdded = misHandlerService.submitActivityAgainstHiv(map);
		
		if(successfullyAdded)
		 {
			message ="Record Added Successfully.";
		 } 
		else 
		 {
			message = "Try Again !!";
		 }
		jsp="messageForHivAidsDetails";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("indexB","map",map);
		
		
	 }
	
	//--biomedical jsp
	
	public ModelAndView showBiomedicalwastemgtjsp(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		
		int commandId=0;
		int userId=0;
		int hospitalId=0;
		
		if(session.getAttribute("commandId")!= null)
        {
		commandId=(Integer)session.getAttribute("commandId");
        }
		
		if(session.getAttribute("userId")!= null)
        {
		userId=(Integer)session.getAttribute("userId");
        }
		
		if(session.getAttribute("hospitalId")!= null)
        {
		hospitalId=(Integer)session.getAttribute("hospitalId");
        }
		
		map.put("commandId", commandId);
		map.put("userId", userId);
		map.put("hospitalId", hospitalId);
		
		map=misHandlerService.showBiomedicalwastemgtjsp(map);
		
		jsp = "biomedicalwastemgt";
		jsp += ".jsp";
		title = "upload";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}


	//-submit biomedical screen
	
	public ModelAndView submitBiomedicalwastemgtjsp(HttpServletRequest request,HttpServletResponse response)
	 {  
		
	  Map<String,Object> map = new HashMap<String,Object>();
	  ShoBiomedicalWaste shoBiomedicalWaste = new ShoBiomedicalWaste();
	  
	  session = request.getSession();	
	 
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
	  
     
try
{
   	
	if(session.getAttribute("hospitalId")!= null)
	{
		hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	}
   	
   	if (request.getParameter("dateOfInspection") != null && !(request.getParameter("dateOfInspection").equals(""))) 
   	{
   		dateOfInspection = HMSUtil.convertStringTypeDateToDateType(request.getParameter("dateOfInspection"));
	}
	  	
   	if (request.getParameter("nameoftheAuthorisedPerson") != null && !(request.getParameter("nameoftheAuthorisedPerson").equals("")))
	  {
   		nameoftheAuthorisedPerson = (request.getParameter("nameoftheAuthorisedPerson"));
	  }
		
   	if (request.getParameter("commandZone") != null && !(request.getParameter("commandZone").equals("")))
	  {
   		commandZone = (request.getParameter("commandZone"));
	  }
   	
   	if (request.getParameter("nameofCommandingOfficer") != null && !(request.getParameter("nameofCommandingOfficer").equals("")))
	  {
   		nameofCommandingOfficer = (request.getParameter("nameofCommandingOfficer"));
	  }
   	
   	if (request.getParameter("briefDetailTreatment") != null && !(request.getParameter("briefDetailTreatment").equals("")))
	  {
   		briefDetailTreatment = (request.getParameter("briefDetailTreatment"));
	  }
   	
   	if (request.getParameter("offsite") != null && !(request.getParameter("offsite").equals("")))
	  {
   		offsite = (request.getParameter("offsite"));
	  }
   	
   	if (request.getParameter("operatorName") != null && !(request.getParameter("operatorName").equals("")))
	  {
   		operatorName = (request.getParameter("operatorName"));
	  }
   	
   	if (request.getParameter("nameAddressFacility") != null && !(request.getParameter("nameAddressFacility").equals("")))
	  {
   		nameAddressFacility = (request.getParameter("nameAddressFacility"));
	  }
   	  	
   	if (request.getParameter("jan_cat_one_three") != null && !(request.getParameter("jan_cat_one_three").equals("")))
	  {
   		jan_cat_one_three = (request.getParameter("jan_cat_one_three"));
	  }
		
 	if (request.getParameter("jan_cat_four") != null && !(request.getParameter("jan_cat_four").equals("")))
	  {
 		jan_cat_four = (request.getParameter("jan_cat_four"));
	  }
 	
 	if (request.getParameter("jan_cat_five") != null && !(request.getParameter("jan_cat_five").equals("")))
	  {
 		jan_cat_five = (request.getParameter("jan_cat_five"));
	  }
 	
 	if (request.getParameter("jan_cat_six") != null && !(request.getParameter("jan_cat_six").equals("")))
	  {
 		jan_cat_six = (request.getParameter("jan_cat_six"));
	  }
 	
 	if (request.getParameter("jan_cat_seven") != null && !(request.getParameter("jan_cat_seven").equals("")))
	  {
 		jan_cat_seven = (request.getParameter("jan_cat_seven"));
	  }
 	
 	if (request.getParameter("jan_cat_eight") != null && !(request.getParameter("jan_cat_eight").equals("")))
	  {
 		jan_cat_eight = (request.getParameter("jan_cat_eight"));
	  }
 	
 	if (request.getParameter("jan_cat_nine_ten") != null && !(request.getParameter("jan_cat_nine_ten").equals("")))
	  {
 		jan_cat_nine_ten = (request.getParameter("jan_cat_nine_ten"));
	  }
 	
   	if (request.getParameter("feb_cat_one_three") != null && !(request.getParameter("feb_cat_one_three").equals("")))
	  {
   		feb_cat_one_three = (request.getParameter("feb_cat_one_three"));
	  }
		
	if (request.getParameter("feb_cat_four") != null && !(request.getParameter("feb_cat_four").equals("")))
	  {
		feb_cat_four = (request.getParameter("feb_cat_four"));
	  }
	
	if (request.getParameter("feb_cat_one_five") != null && !(request.getParameter("feb_cat_one_five").equals("")))
	  {
		feb_cat_five = (request.getParameter("feb_cat_one_five"));
	  }
	
	if (request.getParameter("feb_cat_six") != null && !(request.getParameter("feb_cat_six").equals("")))
	  {
		feb_cat_six = (request.getParameter("feb_cat_six"));
	  }
	
	if (request.getParameter("feb_cat_seven") != null && !(request.getParameter("feb_cat_seven").equals("")))
	  {
		feb_cat_seven = (request.getParameter("feb_cat_seven"));
	  }
	
	if (request.getParameter("feb_cat_eight") != null && !(request.getParameter("feb_cat_eight").equals("")))
	  {
		feb_cat_eight = (request.getParameter("feb_cat_eight"));
	  }
	
	if (request.getParameter("feb_cat_nine_ten") != null && !(request.getParameter("feb_cat_nine_ten").equals("")))
	  {
		feb_cat_nine_ten = (request.getParameter("feb_cat_nine_ten"));
	  }
 		
   	if (request.getParameter("mar_cat_one_three") != null && !(request.getParameter("mar_cat_one_three").equals("")))
	  {
   		mar_cat_one_three = (request.getParameter("mar_cat_one_three"));
	  }
		
	if (request.getParameter("mar_cat_four") != null && !(request.getParameter("mar_cat_four").equals("")))
	  {
		mar_cat_four = (request.getParameter("mar_cat_four"));
	  }
	
	if (request.getParameter("mar_cat_five") != null && !(request.getParameter("mar_cat_five").equals("")))
	  {
		mar_cat_five = (request.getParameter("mar_cat_five"));
	  }
	
	if (request.getParameter("mar_cat_six") != null && !(request.getParameter("mar_cat_six").equals("")))
	  {
		mar_cat_six = (request.getParameter("mar_cat_six"));
	  }
	
	if (request.getParameter("mar_cat_seven") != null && !(request.getParameter("mar_cat_seven").equals("")))
	  {
		mar_cat_seven = (request.getParameter("mar_cat_seven"));
	  }
	
	if (request.getParameter("mar_cat_eight") != null && !(request.getParameter("mar_cat_eight").equals("")))
	  {
		mar_cat_eight = (request.getParameter("mar_cat_eight"));
	  }
	
	if (request.getParameter("mar_cat_nine_ten") != null && !(request.getParameter("mar_cat_nine_ten").equals("")))
	  {
		mar_cat_nine_ten = (request.getParameter("mar_cat_nine_ten"));
	  }
		
   	if (request.getParameter("apr_cat_one_three") != null && !(request.getParameter("apr_cat_one_three").equals("")))
	  {
   		apr_cat_one_three = (request.getParameter("apr_cat_one_three"));
	  }
		
	if (request.getParameter("apr_cat_four") != null && !(request.getParameter("apr_cat_four").equals("")))
	  {
		apr_cat_four = (request.getParameter("apr_cat_four"));
	  }
	
	if (request.getParameter("apr_cat_five") != null && !(request.getParameter("apr_cat_five").equals("")))
	  {
		apr_cat_five = (request.getParameter("apr_cat_five"));
	  }
	
	if (request.getParameter("apr_cat_six") != null && !(request.getParameter("apr_cat_six").equals("")))
	  {
		apr_cat_six = (request.getParameter("apr_cat_six"));
	  }
	
	if (request.getParameter("apr_cat_seven") != null && !(request.getParameter("apr_cat_seven").equals("")))
	  {
		apr_cat_seven = (request.getParameter("apr_cat_seven"));
	  }
	
	if (request.getParameter("apr_cat_eight") != null && !(request.getParameter("apr_cat_eight").equals("")))
	  {
		apr_cat_eight = (request.getParameter("apr_cat_eight"));
	  }
	
	if (request.getParameter("apr_cat_nine_ten") != null && !(request.getParameter("apr_cat_nine_ten").equals("")))
	  {
		apr_cat_nine_ten = (request.getParameter("apr_cat_nine_ten"));
	  }
	
	if (request.getParameter("may_cat_one_three") != null && !(request.getParameter("may_cat_one_three").equals("")))
	  {
   		may_cat_one_three = (request.getParameter("may_cat_one_three"));
	  }
		
	if (request.getParameter("may_cat_four") != null && !(request.getParameter("may_cat_four").equals("")))
	  {
		may_cat_four = (request.getParameter("may_cat_four"));
	  }
	
	if (request.getParameter("may_cat_five") != null && !(request.getParameter("may_cat_five").equals("")))
	  {
		may_cat_five = (request.getParameter("may_cat_five"));
	  }
	
	if (request.getParameter("may_cat_six") != null && !(request.getParameter("may_cat_six").equals("")))
	  {
		may_cat_six = (request.getParameter("may_cat_six"));
	  }
	
	if (request.getParameter("may_cat_seven") != null && !(request.getParameter("may_cat_seven").equals("")))
	  {
		may_cat_seven = (request.getParameter("may_cat_seven"));
	  }
	
	if (request.getParameter("may_cat_eight") != null && !(request.getParameter("may_cat_eight").equals("")))
	  {
		may_cat_eight = (request.getParameter("may_cat_eight"));
	  }
	
	if (request.getParameter("may_cat_nine_ten") != null && !(request.getParameter("may_cat_nine_ten").equals("")))
	  {
		may_cat_nine_ten = (request.getParameter("may_cat_nine_ten"));
	  }
	
	if (request.getParameter("jun_cat_one_three") != null && !(request.getParameter("jun_cat_one_three").equals("")))
	  {
		jun_cat_one_three = (request.getParameter("jun_cat_one_three"));
	  }
		
	if (request.getParameter("jun_cat_four") != null && !(request.getParameter("jun_cat_four").equals("")))
	  {
		jun_cat_four = (request.getParameter("jun_cat_four"));
	  }
	
	if (request.getParameter("jun_cat_five") != null && !(request.getParameter("jun_cat_five").equals("")))
	  {
		jun_cat_five = (request.getParameter("jun_cat_five"));
	  }
	
	if (request.getParameter("jun_cat_six") != null && !(request.getParameter("jun_cat_six").equals("")))
	  {
		jun_cat_six = (request.getParameter("jun_cat_six"));
		
	  }
	
	if (request.getParameter("jun_cat_seven") != null && !(request.getParameter("jun_cat_seven").equals("")))
	  {
		jun_cat_seven = (request.getParameter("jun_cat_seven"));
	  }
	
	if (request.getParameter("jun_cat_eight") != null && !(request.getParameter("jun_cat_eight").equals("")))
	  {
		jun_cat_eight = (request.getParameter("jun_cat_eight"));
	  }
	
	if (request.getParameter("jun_cat_nine_ten") != null && !(request.getParameter("jun_cat_nine_ten").equals("")))
	  {
		jun_cat_nine_ten = (request.getParameter("jun_cat_nine_ten"));
	  }
	
	if (request.getParameter("jul_cat_one_three") != null && !(request.getParameter("jul_cat_one_three").equals("")))
	  {
		jul_cat_one_three = (request.getParameter("jul_cat_one_three"));
	  }
		
	if (request.getParameter("jul_cat_four") != null && !(request.getParameter("jul_cat_four").equals("")))
	  {
		jul_cat_four = (request.getParameter("jul_cat_four"));
	  }
	
	if (request.getParameter("jul_cat_five") != null && !(request.getParameter("jul_cat_five").equals("")))
	  {
		jul_cat_five = (request.getParameter("jul_cat_five"));
	  }
	
	if (request.getParameter("jul_cat_six") != null && !(request.getParameter("jul_cat_six").equals("")))
	  {
		jul_cat_six = (request.getParameter("jul_cat_six"));
	  }
	
	if (request.getParameter("jul_cat_seven") != null && !(request.getParameter("jul_cat_seven").equals("")))
	  {
		jul_cat_seven = (request.getParameter("jul_cat_seven"));
	  }
	
	if (request.getParameter("jul_cat_eight") != null && !(request.getParameter("jul_cat_eight").equals("")))
	  {
		jul_cat_eight = (request.getParameter("jul_cat_eight"));
	  }
	
	if (request.getParameter("jul_cat_nine_ten") != null && !(request.getParameter("jul_cat_nine_ten").equals("")))
	  {
		jul_cat_nine_ten = (request.getParameter("jul_cat_nine_ten"));
	  }
	
	if (request.getParameter("aug_cat_one_three") != null && !(request.getParameter("aug_cat_one_three").equals("")))
	  {
		aug_cat_one_three = (request.getParameter("aug_cat_one_three"));
	  }
		
	if (request.getParameter("aug_cat_four") != null && !(request.getParameter("aug_cat_four").equals("")))
	  {
		aug_cat_four = (request.getParameter("aug_cat_four"));
	  }
	
	if (request.getParameter("aug_cat_five") != null && !(request.getParameter("aug_cat_five").equals("")))
	  {
		aug_cat_five = (request.getParameter("aug_cat_five"));
	  }
	
	if (request.getParameter("aug_cat_six") != null && !(request.getParameter("aug_cat_six").equals("")))
	  {
		aug_cat_six = (request.getParameter("aug_cat_six"));
	  }
	
	if (request.getParameter("aug_cat_seven") != null && !(request.getParameter("aug_cat_seven").equals("")))
	  {
		aug_cat_seven = (request.getParameter("aug_cat_seven"));
	  }
	
	if (request.getParameter("aug_cat_eight") != null && !(request.getParameter("aug_cat_eight").equals("")))
	  {
		aug_cat_eight = (request.getParameter("aug_cat_eight"));
	  }
	
	if (request.getParameter("aug_cat_nine_ten") != null && !(request.getParameter("aug_cat_nine_ten").equals("")))
	  {
		aug_cat_nine_ten = (request.getParameter("aug_cat_nine_ten"));
	  }
	
	if (request.getParameter("sep_cat_one_three") != null && !(request.getParameter("sep_cat_one_three").equals("")))
	  {
		sep_cat_one_three = (request.getParameter("sep_cat_one_three"));
	  }
		
	if (request.getParameter("sep_cat_four") != null && !(request.getParameter("sep_cat_four").equals("")))
	  {
		sep_cat_four = (request.getParameter("sep_cat_four"));
	  }
	
	if (request.getParameter("sep_cat_five") != null && !(request.getParameter("sep_cat_five").equals("")))
	  {
		sep_cat_five = (request.getParameter("sep_cat_five"));
	  }
	
	if (request.getParameter("sep_cat_six") != null && !(request.getParameter("sep_cat_six").equals("")))
	  {
		sep_cat_six = (request.getParameter("sep_cat_six"));
	  }
	
	if (request.getParameter("sep_cat_seven") != null && !(request.getParameter("sep_cat_seven").equals("")))
	  {
		sep_cat_seven = (request.getParameter("sep_cat_seven"));
	  }
	
	if (request.getParameter("sep_cat_eight") != null && !(request.getParameter("sep_cat_eight").equals("")))
	  {
		sep_cat_eight = (request.getParameter("sep_cat_eight"));
	  }
	
	if (request.getParameter("sep_cat_nine_ten") != null && !(request.getParameter("sep_cat_nine_ten").equals("")))
	  {
		sep_cat_nine_ten = (request.getParameter("sep_cat_nine_ten"));
	  }
	
	if (request.getParameter("oct_cat_one_three") != null && !(request.getParameter("oct_cat_one_three").equals("")))
	  {
		oct_cat_one_three = (request.getParameter("oct_cat_one_three"));
	  }
		
	if (request.getParameter("oct_cat_four") != null && !(request.getParameter("oct_cat_four").equals("")))
	  {
		oct_cat_four = (request.getParameter("oct_cat_four"));
	  }
	
	if (request.getParameter("oct_cat_five") != null && !(request.getParameter("oct_cat_five").equals("")))
	  {
		oct_cat_five = (request.getParameter("oct_cat_five"));
	  }
	
	if (request.getParameter("oct_cat_six") != null && !(request.getParameter("oct_cat_six").equals("")))
	  {
		oct_cat_six = (request.getParameter("oct_cat_six"));
	  }
	
	if (request.getParameter("oct_cat_seven") != null && !(request.getParameter("oct_cat_seven").equals("")))
	  {
		oct_cat_seven = (request.getParameter("oct_cat_seven"));
	  }
	
	if (request.getParameter("oct_cat_eight") != null && !(request.getParameter("oct_cat_eight").equals("")))
	  {
		oct_cat_eight = (request.getParameter("oct_cat_eight"));
	  }
	
	if (request.getParameter("oct_cat_nine_ten") != null && !(request.getParameter("oct_cat_nine_ten").equals("")))
	  {
		oct_cat_nine_ten = (request.getParameter("oct_cat_nine_ten"));
	  }
	
	if (request.getParameter("nov_cat_one_three") != null && !(request.getParameter("nov_cat_one_three").equals("")))
	  {
		nov_cat_one_three = (request.getParameter("nov_cat_one_three"));
	  }
		
	if (request.getParameter("nov_cat_four") != null && !(request.getParameter("nov_cat_four").equals("")))
	  {
		nov_cat_four = (request.getParameter("nov_cat_four"));
	  }
	
	if (request.getParameter("nov_cat_five") != null && !(request.getParameter("nov_cat_five").equals("")))
	  {
		nov_cat_five = (request.getParameter("nov_cat_five"));
	  }
	
	if (request.getParameter("nov_cat_six") != null && !(request.getParameter("nov_cat_six").equals("")))
	  {
		nov_cat_six = (request.getParameter("nov_cat_six"));
	  }
	
	if (request.getParameter("nov_cat_seven") != null && !(request.getParameter("nov_cat_seven").equals("")))
	  {
		nov_cat_seven = (request.getParameter("nov_cat_seven"));
	  }
	
	if (request.getParameter("nov_cat_eight") != null && !(request.getParameter("nov_cat_eight").equals("")))
	  {
		nov_cat_eight = (request.getParameter("nov_cat_eight"));
	  }
	
	if (request.getParameter("nov_cat_nine_ten") != null && !(request.getParameter("nov_cat_nine_ten").equals("")))
	  {
		nov_cat_nine_ten = (request.getParameter("nov_cat_nine_ten"));
	  }
	
	if (request.getParameter("dec_cat_one_three") != null && !(request.getParameter("dec_cat_one_three").equals("")))
	  {
		dec_cat_one_three = (request.getParameter("dec_cat_one_three"));
	  }
		
	if (request.getParameter("dec_cat_four") != null && !(request.getParameter("dec_cat_four").equals("")))
	  {
		dec_cat_four = (request.getParameter("dec_cat_four"));
	  }
	
	if (request.getParameter("dec_cat_five") != null && !(request.getParameter("dec_cat_five").equals("")))
	  {
		dec_cat_five = (request.getParameter("dec_cat_five"));
	  }
	
	if (request.getParameter("dec_cat_six") != null && !(request.getParameter("dec_cat_six").equals("")))
	  {
		dec_cat_six = (request.getParameter("dec_cat_six"));
	  }
	
	if (request.getParameter("dec_cat_seven") != null && !(request.getParameter("dec_cat_seven").equals("")))
	  {
		dec_cat_seven = (request.getParameter("dec_cat_seven"));
	  }
	
	if (request.getParameter("dec_cat_eight") != null && !(request.getParameter("dec_cat_eight").equals("")))
	  {
		dec_cat_eight = (request.getParameter("dec_cat_eight"));
	  }
	
	if (request.getParameter("dec_cat_nine_ten") != null && !(request.getParameter("dec_cat_nine_ten").equals("")))
	  {
		dec_cat_nine_ten = (request.getParameter("dec_cat_nine_ten"));
	  }
	  
	if (request.getParameter("total_cat_one_three") != null && !(request.getParameter("total_cat_one_three").equals("")))
	  {
		total_cat_one_three = (request.getParameter("total_cat_one_three"));
	  }
		
	if (request.getParameter("total_cat_four") != null && !(request.getParameter("total_cat_four").equals("")))
	  {
		total_cat_four = (request.getParameter("total_cat_four"));
		shoBiomedicalWaste.setTotalCatFour(total_cat_four);
	  }
	
	if (request.getParameter("total_cat_five") != null && !(request.getParameter("total_cat_five").equals("")))
	  {
		total_cat_five = (request.getParameter("total_cat_five"));
	  }
	
	if (request.getParameter("total_cat_six") != null && !(request.getParameter("total_cat_six").equals("")))
	  {
		total_cat_six = (request.getParameter("total_cat_six"));
	  }
	
	if (request.getParameter("total_cat_seven") != null && !(request.getParameter("total_cat_seven").equals("")))
	  {
		total_cat_seven = (request.getParameter("total_cat_seven"));
	  }
	
	if (request.getParameter("total_cat_eight") != null && !(request.getParameter("total_cat_eight").equals("")))
	  {
		total_cat_eight = (request.getParameter("total_cat_eight"));
	  }
	
	if (request.getParameter("total_cat_nine_ten") != null && !(request.getParameter("total_cat_nine_ten").equals("")))
	  {
		total_cat_nine_ten = (request.getParameter("total_cat_nine_ten"));
	  }
	
	if (request.getParameter("collectionStorage") != null && !(request.getParameter("collectionStorage").equals("")))
	  {
		collectionStorage = (request.getParameter("collectionStorage"));
	  }
		
	if (request.getParameter("modeofTransportation") != null && !(request.getParameter("modeofTransportation").equals("")))
	  {
		modeofTransportation = (request.getParameter("modeofTransportation"));
		shoBiomedicalWaste.setModeOfTransportation(modeofTransportation);
	  }
	
	if (request.getParameter("knowledgeAttitude") != null && !(request.getParameter("knowledgeAttitude").equals("")))
	  {
		knowledgeAttitude = (request.getParameter("knowledgeAttitude"));
	  }
	
	if (request.getParameter("useofPersonal") != null && !(request.getParameter("useofPersonal").equals("")))
	  {
		useofPersonal = (request.getParameter("useofPersonal"));
	  }
	
	if (request.getParameter("incinerator") != null && !(request.getParameter("incinerator").equals("")))
	  {
		incinerator = (request.getParameter("incinerator"));
	  }
	
	if (request.getParameter("deepBru") != null && !(request.getParameter("deepBru").equals("")))
	  {
		deepBru = (request.getParameter("deepBru"));
		shoBiomedicalWaste.setDeepBurial(deepBru);
	  }
	
	if (request.getParameter("microwave") != null && !(request.getParameter("microwave").equals("")))
	  {
		microwave = (request.getParameter("microwave"));
	  }

	if (request.getParameter("autoclave") != null && !(request.getParameter("autoclave").equals("")))
	  {
		autoclave = (request.getParameter("autoclave"));
	  }
		
	if (request.getParameter("hydroclave") != null && !(request.getParameter("hydroclave").equals("")))
	  {
		hydroclave = (request.getParameter("hydroclave"));
	  }
	
	if (request.getParameter("shredder") != null && !(request.getParameter("shredder").equals("")))
	  {
		shredder = (request.getParameter("shredder"));
	  }
	
	if (request.getParameter("needleDes") != null && !(request.getParameter("needleDes").equals("")))
	  {
		needleDes = (request.getParameter("needleDes"));
	  }
	
	if (request.getParameter("anyOther") != null && !(request.getParameter("anyOther").equals("")))
	  {
		anyOther = (request.getParameter("anyOther"));
		
	  }
	
	if (request.getParameter("remarksofInsp") != null && !(request.getParameter("remarksofInsp").equals("")))
	  {
		remarksofInsp = (request.getParameter("remarksofInsp"));
		
	  }
	
	if (request.getParameter("finalObser") != null && !(request.getParameter("finalObser").equals("")))
	  {
		finalObser = (request.getParameter("finalObser"));
		
	  }
	
	if (request.getParameter("nameOfInstitution") != null && !(request.getParameter("nameOfInstitution").equals("")))
	  {
		nameOfInstitution = (request.getParameter("nameOfInstitution"));
		
	  }
	
} 
catch (Exception e) 
{
	e.printStackTrace();
}

map.put("hospitalId",hospitalId);
map.put("nameoftheAuthorisedPerson",nameoftheAuthorisedPerson);
map.put("commandZone",commandZone);
map.put("dateOfInspection",dateOfInspection);
map.put("nameofCommandingOfficer",nameofCommandingOfficer);
map.put("briefDetailTreatment",briefDetailTreatment);
map.put("offsite",offsite);
map.put("operatorName",operatorName);
map.put("nameAddressFacility",nameAddressFacility);

map.put("jan_cat_one_three",jan_cat_one_three);
map.put("jan_cat_four",jan_cat_four);
map.put("jan_cat_five",jan_cat_five);
map.put("jan_cat_six",jan_cat_six);
map.put("jan_cat_seven",jan_cat_seven);
map.put("jan_cat_eight",jan_cat_eight);
map.put("jan_cat_nine_ten",jan_cat_nine_ten);

map.put("feb_cat_one_three",feb_cat_one_three);
map.put("feb_cat_four",feb_cat_four);
map.put("feb_cat_five",feb_cat_five);
map.put("feb_cat_six",feb_cat_six);
map.put("feb_cat_seven",feb_cat_seven);
map.put("feb_cat_eight",feb_cat_eight);
map.put("feb_cat_nine_ten",feb_cat_nine_ten);

map.put("mar_cat_one_three",mar_cat_one_three);
map.put("mar_cat_four",mar_cat_four);
map.put("mar_cat_five",mar_cat_five);
map.put("mar_cat_six",mar_cat_six);
map.put("mar_cat_seven",mar_cat_seven);
map.put("mar_cat_eight",mar_cat_eight);
map.put("mar_cat_nine_ten",mar_cat_nine_ten);

map.put("apr_cat_one_three",apr_cat_one_three);
map.put("apr_cat_four",apr_cat_four);
map.put("apr_cat_five",apr_cat_five);
map.put("apr_cat_six",apr_cat_six);
map.put("apr_cat_seven",apr_cat_seven);
map.put("apr_cat_eight",apr_cat_eight);
map.put("apr_cat_nine_ten",apr_cat_nine_ten);

map.put("may_cat_one_three",may_cat_one_three);
map.put("may_cat_four",may_cat_four);
map.put("may_cat_five",may_cat_five);
map.put("may_cat_six",mar_cat_six);
map.put("may_cat_seven",may_cat_seven);
map.put("may_cat_eight",may_cat_eight);
map.put("may_cat_nine_ten",may_cat_nine_ten);

map.put("jun_cat_one_three",jun_cat_one_three);
map.put("jun_cat_four",jun_cat_four);
map.put("jun_cat_five",jun_cat_five);
map.put("jun_cat_six",jun_cat_six);
map.put("jun_cat_seven",jun_cat_seven);
map.put("jun_cat_eight",jun_cat_eight);
map.put("jun_cat_nine_ten",jun_cat_nine_ten);

map.put("jul_cat_one_three",jul_cat_one_three);
map.put("jul_cat_four",jul_cat_four);
map.put("jul_cat_five",jul_cat_five);
map.put("jul_cat_six",jul_cat_six);
map.put("jul_cat_seven",jul_cat_seven);
map.put("jul_cat_eight",jul_cat_eight);
map.put("jul_cat_nine_ten",jul_cat_nine_ten);

map.put("aug_cat_one_three",aug_cat_one_three);
map.put("aug_cat_four",aug_cat_four);
map.put("aug_cat_five",aug_cat_five);
map.put("aug_cat_six",aug_cat_six);
map.put("aug_cat_seven",aug_cat_seven);
map.put("aug_cat_eight",aug_cat_eight);
map.put("aug_cat_nine_ten",aug_cat_nine_ten);

map.put("sep_cat_one_three",sep_cat_one_three);
map.put("sep_cat_four",sep_cat_four);
map.put("sep_cat_five",sep_cat_five);
map.put("sep_cat_six",sep_cat_six);
map.put("sep_cat_seven",sep_cat_seven);
map.put("sep_cat_eight",sep_cat_eight);
map.put("sep_cat_nine_ten",sep_cat_nine_ten);

map.put("oct_cat_one_three",oct_cat_one_three);
map.put("oct_cat_four",oct_cat_four);
map.put("oct_cat_five",oct_cat_five);
map.put("oct_cat_six",oct_cat_six);
map.put("oct_cat_seven",oct_cat_seven);
map.put("oct_cat_eight",oct_cat_eight);
map.put("oct_cat_nine_ten",oct_cat_nine_ten);

map.put("nov_cat_one_three",nov_cat_one_three);
map.put("nov_cat_four",nov_cat_four);
map.put("nov_cat_five",nov_cat_five);
map.put("nov_cat_six",nov_cat_six);
map.put("nov_cat_seven",nov_cat_seven);
map.put("nov_cat_eight",nov_cat_eight);
map.put("nov_cat_nine_ten",nov_cat_nine_ten);

map.put("dec_cat_one_three",dec_cat_one_three);
map.put("dec_cat_four",dec_cat_four);
map.put("dec_cat_five",dec_cat_five);
map.put("dec_cat_six",dec_cat_six);
map.put("dec_cat_seven",dec_cat_seven);
map.put("dec_cat_eight",dec_cat_eight);
map.put("dec_cat_nine_ten",dec_cat_nine_ten);

map.put("total_cat_one_three",total_cat_one_three);
map.put("total_cat_four",total_cat_four);
map.put("total_cat_five",total_cat_five);
map.put("total_cat_six",total_cat_six);
map.put("total_cat_seven",total_cat_seven);
map.put("total_cat_eight",total_cat_eight);
map.put("total_cat_nine_ten",total_cat_nine_ten);

map.put("collectionStorage",collectionStorage);
map.put("modeofTransportation",modeofTransportation);
map.put("knowledgeAttitude",knowledgeAttitude);
map.put("useofPersonal",useofPersonal);
map.put("incinerator",incinerator);
map.put("deepBru",deepBru);
map.put("microwave",microwave);

map.put("autoclave",autoclave);
map.put("hydroclave",hydroclave);
map.put("shredder",shredder);
map.put("needleDes",needleDes);
map.put("anyOther",anyOther);
map.put("remarksofInsp",remarksofInsp);
map.put("finalObser",finalObser);
map.put("nameOfInstitution",nameOfInstitution);


boolean successfullyAdded = misHandlerService.submitBiomedicalwastemgtjsp(map);
int bioMedicalId = 0;
if(map.get("bioMedicalId") != null){
	bioMedicalId = (Integer)map.get("bioMedicalId");
}	
if(successfullyAdded)
{
	message ="Record Added Successfully. Do you want to Print !!";
} 
else 
{
	message = "Try Again !!";
}

jsp="messageForBioMedicalWaste";
jsp += ".jsp";
map.put("contentJsp", jsp);
map.put("message", message);

return new ModelAndView("indexB","map",map);
	
}

	//-----------print BMW Disposal----
	
	public ModelAndView printBioMedicalDetailForBMW(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object>  map = new HashMap<String,Object>();	    
		
		int bioMedicalId =0;
       session = request.getSession();
		byte[] bytes = null;
		try {
			if (request.getParameter("bioMedicalId") != null && !(request.getParameter("bioMedicalId").equals(""))) {
				bioMedicalId = Integer.parseInt(request.getParameter("bioMedicalId"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("bioMedicalId", bioMedicalId);
		
		try {
			map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			HMSUtil.generateReport("sho_biomedical_report_bmw", map,(Connection) map.get("conn"), response,getServletContext());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	  }
	
	//----print visiting officer report 
	
	public ModelAndView printBioMedicalDetailForVisitingOfficer(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object>  map = new HashMap<String,Object>();	    
		
		int bioMedicalId =0;
     session = request.getSession();
		byte[] bytes = null;
		try {
			if (request.getParameter("bioMedicalId") != null && !(request.getParameter("bioMedicalId").equals(""))) {
				bioMedicalId = Integer.parseInt(request.getParameter("bioMedicalId"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		map.put("bioMedicalId", bioMedicalId);
		
		try {
			map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			//map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			HMSUtil.generateReport("sho_biomedical_report_visiting_officer", map,(Connection) map.get("conn"), response,getServletContext());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	  }
	
	//---print annual report for Bio Medical JSP
	
	public ModelAndView showBioMedicalReport(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object>  map = new HashMap<String,Object>();
		jsp = "BioMedicalReportJsp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	  }
	
	
	//---print annual report for Bio Medical
	
	public  ModelAndView showAnnualBioMedicalReport(HttpServletRequest request,HttpServletResponse response)
	  { Map<String,Object>  map = new HashMap<String,Object>();
		jsp = "annualBioMedicalReportJsp";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	  }
	
	
	  public ModelAndView generateBioMedicalReport(HttpServletRequest request,HttpServletResponse response)
	  {
		Map<String,Object>  map = new HashMap<String,Object>();	    
		
		Date toDate = null;
		Date fromDate = null;
		int year = 0;
	    session = request.getSession();
		byte[] bytes = null;
		try {
			if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			}
			
			if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			}
			/*if (request.getParameter("year") != null && !(request.getParameter("year").equals(""))) {
				year = (Integer.parseInt(request.getParameter("year")));
				
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map = misHandlerService.getDBConnection();
		
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		
		try {
				HMSUtil.generateReport("sho_annual_report_biomedical", map,(Connection) map.get("conn"), response,getServletContext());

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	  }
	
	  //---Service Number details for Accidental Details...Rider...By Kiran..
	  
	  public ModelAndView getServiceNoDetailsForAccidentRider(HttpServletRequest request,HttpServletResponse response)
	  {   
		  Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			String serviceNo = box.getString("flag");
			map = misHandlerService.getServiceNoDetailsForAccidentRider(serviceNo);
			String jsp = "misResponseForAccidentalDetails";
			
			return new ModelAndView(jsp, "map", map);
		  
		   //map = misHandlerService.getServiceNoDetailsForSho(box);
		  // return new ModelAndView("responseForSrNoForAccidentRider","map",map);
	  }

	  public ModelAndView getPatientDetailForAccidentalDetails(HttpServletRequest request,HttpServletResponse response) 
	  {
	  				Map<String, Object> map = new HashMap<String, Object>();
	  				Map<String, Object> mapForDS = new HashMap<String, Object>();
	  				int hinId = 0;
	  				if(request.getParameter("hin")!= null && !request.getParameter("hin").equals("")){
	  					hinId = Integer.parseInt(request.getParameter("hin"));
	  					mapForDS.put("hinId", hinId);
	  				}
	  				
	  				map = misHandlerService.getPatientDetailForAccidentalDetails(mapForDS);	
	  				String jsp = "responseForSrNoForAccidentRider";
	  				return new ModelAndView(jsp,"map",map);
	  				
	  }
	
	  //---Service Number details for Accidental Details...Driver...By Kiran..
	  
	  public ModelAndView getServiceNoDetailsForAccident(HttpServletRequest request, HttpServletResponse response)
	   {   
		  Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			String serviceNo = box.getString("flag");
			map = misHandlerService.getServiceNoDetailsForAccident(serviceNo);
			String jsp = "misResponseForAccidentalDetailsDriver";
			
			return new ModelAndView(jsp, "map", map);
		   
	   }
	  
	  public ModelAndView getPatientDetailForAccidentalDetailsDriver(HttpServletRequest request,HttpServletResponse response) 
	  {
	  				Map<String, Object> map = new HashMap<String, Object>();
	  				Map<String, Object> mapForDS = new HashMap<String, Object>();
	  				int hinId = 0;
	  				if(request.getParameter("hin_id")!= null && !request.getParameter("hin_id").equals("")){
	  					hinId = Integer.parseInt(request.getParameter("hin_id"));
	  					mapForDS.put("hinId", hinId);
	  				}
	  				
	  				map = misHandlerService.getPatientDetailForAccidentalDetailsDriver(mapForDS);	
	  				String jsp = "responseForSrNoForAccident";
	  				return new ModelAndView(jsp,"map",map);
	  				
	  }
	  
	//--------JSP of Mortality Amongst Families. By Kiran 
		
		public ModelAndView showMortalityAmongstFamiliesjsp(
				HttpServletRequest request, HttpServletResponse response) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
			session = request.getSession();
			jsp = "mortalityAmongst";
			jsp += ".jsp";
			title = "upload";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB", "map", map);
		}
		
		public ModelAndView getServiceNoDetailsForMortalityAmongstFamilies(HttpServletRequest request,HttpServletResponse response)
		 {
			 Map<String, Object> map = new HashMap<String, Object>();
				Box box = HMSUtil.getBox(request);
				String serviceNo = box.getString("flag");
				map = misHandlerService.getServiceNoDetailsForMortalityAmongstFamilies(serviceNo);
				String jsp = "misResponseForMortality";
				
				return new ModelAndView(jsp, "map", map);
				
			
		 }
		
		public ModelAndView getPatientDetailForMortality(HttpServletRequest request,HttpServletResponse response) 
		  {
		  				Map<String, Object> map = new HashMap<String, Object>();
		  				Map<String, Object> mapForDS = new HashMap<String, Object>();
		  				int hinId = 0;
		  				String serviceNumber = "";
		  				if(request.getParameter("hinId")!= null && !request.getParameter("hinId").equals("")){
		  					hinId = Integer.parseInt(request.getParameter("hinId"));
		  					mapForDS.put("hinId", hinId);
		  				}
		  				
		  				if(request.getParameter("serviceNumber")!= null && !request.getParameter("serviceNumber").equals("")){
		  					serviceNumber = request.getParameter("serviceNumber");
		  					mapForDS.put("serviceNumber", serviceNumber);
		  				}
		  				
		  				map = misHandlerService.getPatientDetailForMortality(mapForDS);	
		  				String jsp = "responseForSrNoForMortalityAmongstFamilies";
		  				return new ModelAndView(jsp,"map",map);
		  				
		  }
		
		//-----Hin Number for Free From Infection
		
		public ModelAndView getHinNoForFreeFromInfection(HttpServletRequest request, HttpServletResponse  response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			String serviceNo = box.getString("flag");
			
			map = misHandlerService.getHinNoForAttemptSucide(serviceNo);
			String jsp = "misResponseForFreeFromInfection";
			
			return new ModelAndView(jsp, "map", map);
		}
		
		public ModelAndView getServiceNoDetailsForFreeFromInfection(HttpServletRequest request,HttpServletResponse response)
		 {
			
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			
			int hinId = 0;
			if(request.getParameter(HIN_ID)!= null && !request.getParameter(HIN_ID).equals("")){
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				
				mapForDS.put("hinId", hinId);
			}
			
			map = misHandlerService.getServiceNoDetailsForFreeFromInfection(mapForDS);	
			String jsp = "responseForSrNoForFreeFromInfection";
			return new ModelAndView(jsp,"map",map);
			
		 }
		
		//- monthly work load report jsp
		
		public  ModelAndView showMonthlyWorkLoadReport(HttpServletRequest request,HttpServletResponse response)
		  { 
			Map<String,Object>  map = new HashMap<String,Object>();
			map = misHandlerService.showMonthlyWorkLoadReport(map);
			jsp = "monthlyWorkLoadReportJsp";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index","map",map);
		  }
		
		
		public ModelAndView printMonthlyWorkLoadReport(HttpServletRequest request,HttpServletResponse response)
		  {  Map<String,Object>  map = new HashMap<String,Object>();	    
		
		  
		String monthReport = "";
		int unitId =0;
	    session = request.getSession();
	      
		byte[] bytes = null;
			try {
				if (request.getParameter("monthReport") != null	&& !(request.getParameter("monthReport").equals(""))) 
				{
					monthReport = request.getParameter("monthReport");
				}
					
				if (request.getParameter("unitId") != null	&& !(request.getParameter("unitId").equals(""))) 
				{
					unitId = (Integer.parseInt(request.getParameter("unitId")));
				}
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			map = misHandlerService.getDBConnection();
			
			map.put("month", monthReport);
			map.put("unitId", unitId);
		
			
			try {
				map.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
				HMSUtil.generateReport("Workload_Of_Monthly", map,(Connection) map.get("conn"), response,getServletContext());

			} catch (Exception e) {

				e.printStackTrace();
			}
			return null;
			
		  }
		  
		  public ModelAndView getMonthlySickAdmissionDetails(HttpServletRequest request,HttpServletResponse response){
			Map<String, Object> map = new HashMap<String, Object>();
			int hospitalId = (Integer)session.getAttribute("hospitalId");
			Box box = HMSUtil.getBox(request);
			box.put("hospitalId", hospitalId);
			map = misHandlerService.getMonthlySickAdmissionDetails(box);
			
			title = "monthlySick";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("responseForMonthlyAdm", "map", map);
		}
		public void getServiceNoDetails(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			map = misHandlerService.getServiceNoDetails(box);
			try {
				List<Patient> patientList = new ArrayList<Patient>();
				if(map.get("patientList")!=null){
					patientList = (List<Patient>)map.get("patientList");
				}
				StringBuffer sb = new StringBuffer();
				if(patientList.size() > 0){
					for(Patient patient : patientList){
						sb.append("<item>");
						sb.append("<rank>" + patient.getRank().getRankName() + "</rank>");
						sb.append("<name>" + patient.getPFirstName()+" "+(patient.getPMiddleName()!=null?patient.getPMiddleName():"")+" "+(patient.getPLastName()!=null?patient.getPLastName():"")+ "</name>");
						String age = "";
						String currentAge = "";
						age = patient.getAge();
						currentAge = HMSUtil.calculateAgeForADT(age, patient.getRegDate());
						
						sb.append("<age>" + (currentAge )+ "</age>");
						sb.append("<unit>" + patient.getUnit().getUnitName() + "</unit>");
						sb.append("<trade>" + (patient.getTrade()!=null?patient.getTrade().getTradeName():"")+ "</trade>");
						sb.append("<hinId>" + patient.getId()+"</hinId>");
						sb.append("</item>");
						
					}
					response.setContentType("text/xml");
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
					response.getWriter().write("<items>");
					response.getWriter().write(sb.toString());
					response.getWriter().write("</items>");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public ModelAndView submitMonthlySickAdmission(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId = (Integer)session.getAttribute("hospitalId");
			Box box = HMSUtil.getBox(request);
			box.put("hospitalId", hospitalId);
			int userId = 0;
		    if(session.getAttribute("users")!= null)
		    {
		    	Users user = (Users)session.getAttribute("users");	    
		    	userId = user.getId();
		    }
		    box.put("userId", userId);
			map = misHandlerService.submitMonthlySickAdmission(box);
			boolean flag = false;
			if(map.get("flag")!=null){
				flag = (Boolean)map.get("flag");
			}
			String message = "";
			if(flag){
				message = "Record saved successfully.";
			}else{
				message= "Some problem occurred.";
			}
			map = misHandlerService.showMonthlySickReportsjsp();
			map.put("message", message);
			jsp = MONTHLYSICKREPORT_JSP;
			jsp += ".jsp";
			title = "monthlySick";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB", "map", map);
		}
		public ModelAndView getMonthlySickDischargeDetails(HttpServletRequest request,HttpServletResponse response){
			Map<String, Object> map = new HashMap<String, Object>();
			int hospitalId = (Integer)session.getAttribute("hospitalId");
			Box box = HMSUtil.getBox(request);
			box.put("hospitalId", hospitalId);
			map = misHandlerService.getMonthlySickDischargeDetails(box);
			
			title = "monthlySick";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("responseForMonthlyDischarge", "map", map);
		}
		
		public ModelAndView submitMonthlySickDischarge(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospitalId = (Integer)session.getAttribute("hospitalId");
			Box box = HMSUtil.getBox(request);
			box.put("hospitalId", hospitalId);
			int userId = 0;
		    if(session.getAttribute("users")!= null)
		    {
		    	Users user = (Users)session.getAttribute("users");	    
		    	userId = user.getId();
		    }
		    box.put("userId", userId);
			map = misHandlerService.submitMonthlySickDischarge(box);
			boolean flag = false;
			if(map.get("flag")!=null){
				flag = (Boolean)map.get("flag");
			}
			String message = "";
			if(flag){
				message = "Record saved successfully.";
			}else{
				message= "Some problem occurred.";
			}
			map = misHandlerService.showMonthlySickDischargeReportjsp();
			
			map.put("message", message);
			jsp = MONTHLYSICKDISCHARGEREPORT_JSP;
			jsp += ".jsp";
			title = "monthlySick";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB", "map", map);
		}
	public ModelAndView showSILDILRegisterReportJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		map.put("contentJsp", "silDilRegister.jsp");
		map.put("title", title);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView printSILDILRegisterReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		HttpSession session = request.getSession();
	
		
		if (request.getParameter("fromDate") != null && !(request.getParameter("fromDate").equals(""))) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("fromDate"));
		}
		if (request.getParameter("toDate") != null && !(request.getParameter("toDate").equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("toDate"));
		}
		String qry = "";
		int hospitalId=0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("") && !request.getParameter("cmdId").equals("0") && request.getParameter("hospitalId")!=null && request.getParameter("hospitalId").equals("0") && request.getParameter("hospitalId").equals("")){
			
			qry += "  and hospital.command_id="+Integer.parseInt(request.getParameter("cmdId"));
		}else{
			if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("") && !request.getParameter("hospitalId").equals("0")){
				hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
			}else{
				hospitalId = (Integer)session.getAttribute("hospitalId");
			}
			qry += "  and inpatient.hospital_id="+hospitalId;
		}
		parameters.put("hospitalId", hospitalId);
		
		map = misHandlerService.getDBConnection();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("hospitalId",hospitalId);
		parameters.put("query",qry);
		
		HMSUtil.generateReport("SilDilRegister", parameters, (Connection) map
				.get("conn"), response, getServletContext());
		return null;
	}

	//----Notifiable Waiting List
	
	public ModelAndView showNotifiableWaitingListJsp(HttpServletRequest request, HttpServletResponse response)
	 {  Map<String,Object>  mapForDS = new HashMap<String,Object>();
	    //Session session = request.getSession();
	    session = request.getSession();
	    int hospitalId = 0;
	    int deptId = 0;
	    if(session.getAttribute(HOSPITAL_ID)!= null)
	    {
	     hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	    }
	    if(session.getAttribute("deptId")!= null)
	    {
	     deptId = (Integer) session.getAttribute("deptId");
	    }
	    int userId = 0;
	    if(session.getAttribute("users")!= null)
	    {
		Users user = (Users)session.getAttribute("users");	    
		userId = user.getEmployee().getId();
	    }
		
		mapForDS.put("userId", userId);
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("deptId", deptId);
		map = misHandlerService.getWaitingPatientListForNotifiable(mapForDS);
		  List patientList =(List)map.get("patientList");
		   
		  //map.put("patientList", patientList);
	    String jsp = "notifiableWaitingListJsp";
	    jsp += ".jsp";
		map.put("contentJsp", jsp);	
		
		return new ModelAndView("indexB","map",map);
	 }

//----notifiable jsp after clicking on waiting list
	
public ModelAndView showNotifiableDiseaseWLJsp(HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		int hospitalId=0;
		int opdId = Integer.parseInt(request.getParameter("opdId"));
	
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}

		Map<String, Object> generalMap = new HashMap<String, Object>();
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("opdId", opdId);
		
		map = misHandlerService.showNotifiableDiseaseWLJsp(generalMap);
		jsp = "notifiableDiseaseWLJsp";
		jsp += ".jsp";
		title = "Notifiable Disease";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		
	}

//----submit notifiable wl 

public ModelAndView submitNotifiableDiseaseWLJsp(HttpServletRequest request,HttpServletResponse response) 
{
	Map<String, Object> map = new HashMap<String, Object>();
	session = request.getSession();
	int hinNumber = 0;
	//int basisOfDiagnosis = 0;
	Date dateOfOnset = new Date();
	Date dateOfReportingSick = new Date();
	Date dateOfPreventive = new Date();
	Date dateOfNotifiable = new Date();
	String designation = "";
	String suspectedsourceofinfection = "";
	String measuresOfControl = "";
	String contact = "";
	String generalRemarks = "";
	String station = "";
	String patientName = "";
	String serviceNo = "";
	String rank = "";
	String age = "";
	String unit = "";
	String lenghtofService = "";
	String residence = "";
	String Detailsofcase = "";
	String clinical = "";
	String bacteriological = "";
	String disinfection = "";
	String dateofPreventive = "";
	String genaralRemarks = "";
   int hospitalId =0;
   int departmentId = 0;
   int hinId=0;
   int opdId=0;
   
   if(session.getAttribute("hospitalId")!= null)
     {	   hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	            }
   if(session.getAttribute("deptId")!= null)
     {
	   departmentId = Integer.parseInt(""+session.getAttribute("deptId"));
     }
	if (request.getParameter("hinNumber") != null
			&& !(request.getParameter("hinNumber").equals(""))) {
		hinNumber = Integer.parseInt(request.getParameter("hinNumber"));
	}
	if (request.getParameter(SERVICE_NO) != null
			&& !(request.getParameter(SERVICE_NO).equals(""))) {
		serviceNo =  request.getParameter(SERVICE_NO);
       
	}
	if (request.getParameter("patientName") != null
			&& !(request.getParameter("patientName").equals(""))) {
		patientName = request.getParameter("patientName");
	}
	if (request.getParameter("rank") != null
			&& !(request.getParameter("rank").equals(""))) {
		rank = request.getParameter("rank");
	}
	if (request.getParameter("age") != null
			&& !(request.getParameter("age").equals(""))) {
		age = request.getParameter("age");
	}
	if (request.getParameter("lenghtofService") != null
			&& !(request.getParameter("lenghtofService").equals(""))) {
		lenghtofService = request.getParameter("lenghtofService");
	}
	if (request.getParameter("unit/Ship") != null
			&& !(request.getParameter("unit/Ship").equals(""))) {
		unit = request.getParameter("unit/Ship");
	}
	if (request.getParameter("residence") != null
			&& !(request.getParameter("residence").equals(""))) {
		residence = request.getParameter("residence");
	}
	if (request.getParameter(DATE_OF_ONSET) != null
			&& !(request.getParameter(DATE_OF_ONSET).equals(""))) {
		dateOfOnset = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(DATE_OF_ONSET));
	}
	if (request.getParameter(DATE_OF_REPORTING_SICK) != null
			&& !(request.getParameter(DATE_OF_REPORTING_SICK).equals(""))) {
		dateOfReportingSick = HMSUtil
				.convertStringTypeDateToDateType(request
						.getParameter(DATE_OF_REPORTING_SICK));
	}
	if (request.getParameter("Detailsofcase") != null
			&& !(request.getParameter("Detailsofcase").equals(""))) {
		Detailsofcase = request.getParameter("Detailsofcase");
	}
	if (request.getParameter("clinical") != null
			&& !(request.getParameter("clinical").equals(""))) {
		clinical = request.getParameter("clinical");
	}
	if (request.getParameter("bacteriological") != null
			&& !(request.getParameter("bacteriological").equals(""))) {
		bacteriological = request.getParameter("bacteriological");
	}
	if (request.getParameter("disinfection") != null
			&& !(request.getParameter("disinfection").equals(""))) {
		disinfection = request.getParameter("disinfection");
	}
	if (request.getParameter("dateofPreventive") != null
			&& !(request.getParameter("dateofPreventive").equals(""))) {
		dateofPreventive = request.getParameter("dateofPreventive");
	}
	if (request.getParameter("contact") != null
			&& !(request.getParameter("contact").equals(""))) {
		contact = request.getParameter("contact");
	}
	if (request.getParameter("genaralRemarks") != null
			&& !(request.getParameter("genaralRemarks").equals(""))) {
		genaralRemarks = request.getParameter("genaralRemarks");
		// map= misHandlerService.submitNotifiableDiseaseJsp();
	}
	if (request.getParameter("suspectedsourceofinfection") != null
			&& !(request.getParameter("suspectedsourceofinfection").equals(""))) {
		suspectedsourceofinfection = request.getParameter("suspectedsourceofinfection");
	}
	
	if (request.getParameter(NOTIFIABLE_DATE) != null
			&& !(request.getParameter(NOTIFIABLE_DATE).equals(""))) {
		dateOfNotifiable = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(NOTIFIABLE_DATE));
	}
	
	if(request.getParameter("hinId") != null && !(request.getParameter("hinId").equals("")))
	{
		hinId=(Integer.parseInt(request.getParameter("hinId")));
	}
	
	if(request.getParameter("opdId") != null && !(request.getParameter("opdId").equals("")))
	{
		opdId=(Integer.parseInt(request.getParameter("opdId")));
	}
	
	
	map.put("hinNumber", hinNumber);
	map.put("serviceNo", serviceNo);
	map.put("patientName", patientName);
	map.put("rank", rank);
	map.put("age", age);
	map.put("lenghtofService", lenghtofService);
	map.put("unit", unit);
	map.put("residence", residence);
	map.put("dateOfOnset", dateOfOnset);
	map.put("dateOfReportingSick", dateOfReportingSick);
	map.put("Detailsofcase", Detailsofcase);
	map.put("clinical", clinical);
	map.put("bacteriological", bacteriological);
	map.put("disinfection", disinfection);
	map.put("dateofPreventive", dateofPreventive);
	map.put("genaralRemarks", genaralRemarks);
	map.put("contact", contact);
	map.put("hospitalId", hospitalId);
	map.put("departmentId", departmentId);
	map.put("dateOfNotifiable", dateOfNotifiable);
	map.put("suspectedsourceofinfection", suspectedsourceofinfection);
	map.put("hinId", hinId);
	map.put("opdId", opdId);
	
	boolean successfullyAdded = misHandlerService.submitNotifiableDiseaseWLJsp(map);
	
	int notifiableId = 0;
	if(map.get("notifiableId")!=null)
	{
		notifiableId= (Integer)map.get("notifiableId");
	}
	if (successfullyAdded) {
		message = "Record Added Successfully. Do You Want Print !!";
	} else {
		message = "Try Again !!";
	}
	jsp = "messageForNotificationDisease";
	title = "update Notifiable Disease";
	jsp += ".jsp";

	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("url", url);
	map.put("message", message);
	map.put("notifiableId", notifiableId);
	return new ModelAndView("indexB", "map", map);
}

//-----break down

public ModelAndView showBreakDown(HttpServletRequest request,HttpServletResponse response)
{  
	HttpSession session = request.getSession();
	
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> dataMap = new HashMap<String,Object>();
	
	int hospitalId=0;
	if(session.getAttribute(HOSPITAL_ID)!= null)
	{
	    hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}

	dataMap.put("hospitalId", hospitalId);
	
	map= misHandlerService.showBreakDown(dataMap);			
	
	jsp="breakDown";
	jsp += ".jsp";
	title = "Break Down";
	map.put("contentJsp", jsp);
	map.put("title", "title");
	return new ModelAndView("indexB","map",map);

}


public ModelAndView submitBreakDownJSP(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map = new HashMap<String,Object>();
	
	 int hospitalId =0;
	 
	 Date currentDate = new Date();
	 Date lastUpdatedDate = new Date();
		
	 String personnelOfficer = "";
	 String personnelAirmen = "";
	 String personnelNcs = "";
	 String personnelArmy = "";
	 String personnelCivilian = "";
	 String personnelTotal ="";
	 
	 String wivesOfficer = "";
	 String wivesAirmen = "";
	 String wivesNcs = "";
	 String wivesArmy = "";
	 String wivesCivilian ="";
	 String wivesTotal ="";
	 
	 String childrenOfficer = "";
	 String childrenAirmen = "";
	 String childrenNcs = "";
	 String childrenArmy = "";
	 String childrenCivilian ="";
	 String childrenTotal ="";
	 
	 String totalOfficer = "";
	 String totalAirmen = "";
	 String totalNcs = "";
	 String totalArmy = "";
	 String totalCivilian ="";
	 String totalTotal ="";
	 
	 	 
	 session = request.getSession();
	 
	 if(session.getAttribute("hospitalId")!= null)
	 {
		 hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	 }
	 
	if(request.getParameter("currentDate")!= null)
	  {
		currentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("currentDate"));
	  }
	
	if(request.getParameter("lastUpdatedDate")!= null)
	  {
		lastUpdatedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("lastUpdatedDate"));
	  }
	
	if(request.getParameter("personnelOfficer")!= null)
	  {
		personnelOfficer = request.getParameter("personnelOfficer");
	  }
	
	if(request.getParameter("personnelAirmen")!= null)
	  {
		personnelAirmen = request.getParameter("personnelAirmen");
	  }
	
	if(request.getParameter("personnelNcs")!= null)
	{
		personnelNcs = request.getParameter("personnelNcs");
	}
	
	if(request.getParameter("personnelArmy")!= null)
	{
		personnelArmy = request.getParameter("personnelArmy");
	}
	
	if(request.getParameter("personnelCivilian")!= null)
	  {
		personnelCivilian = request.getParameter("personnelCivilian");
	  }
	
	if(request.getParameter("personnelTotal")!= null)
	{	
		personnelTotal = request.getParameter("personnelTotal");			
	}
	
	if(request.getParameter("wivesOfficer")!= null)
	{	
		wivesOfficer = request.getParameter("wivesOfficer");			
	}
	
	if(request.getParameter("wivesAirmen")!= null)
	{
		wivesAirmen = request.getParameter("wivesAirmen");			
	}
	
	if(request.getParameter("wivesNcs")!= null)
	{
		wivesNcs = request.getParameter("wivesNcs");			
	}
	
	if(request.getParameter("wivesArmy")!= null)
	{
		wivesArmy = request.getParameter("wivesArmy");			
	}
	
	if(request.getParameter("wivesCivilian")!= null)
	{	
		wivesCivilian = request.getParameter("wivesCivilian");			
	}
	
	if(request.getParameter("wivesTotal")!= null)
	{
		wivesTotal = request.getParameter("wivesTotal");			
	}
	
	if(request.getParameter("childrenOfficer")!= null)
	{	
		childrenOfficer = request.getParameter("childrenOfficer");			
	}
	
	if(request.getParameter("childrenAirmen")!= null)
	{
		childrenAirmen = request.getParameter("childrenAirmen");			
	}
	
	if(request.getParameter("childrenNcs")!= null)
	{
		childrenNcs = request.getParameter("childrenNcs");			
	}
	
	if(request.getParameter("childrenArmy")!= null)
	{
		childrenArmy = request.getParameter("childrenArmy");			
	}
	
	if(request.getParameter("childrenCivilian")!= null)
	{	
		childrenCivilian = request.getParameter("childrenCivilian");			
	}
	
	if(request.getParameter("childrenTotal")!= null)
	{
		childrenTotal = request.getParameter("childrenTotal");			
	}
	
	if(request.getParameter("totalOfficer")!= null)
	{	
		totalOfficer = request.getParameter("totalOfficer");			
	}
	
	if(request.getParameter("totalAirmen")!= null)
	{
		totalAirmen = request.getParameter("totalAirmen");			
	}
	
	if(request.getParameter("totalNcs")!= null)
	{
		totalNcs = request.getParameter("totalNcs");			
	}
	
	if(request.getParameter("totalArmy")!= null)
	{
		totalArmy = request.getParameter("totalArmy");			
	}
	
	if(request.getParameter("totalCivilian")!= null)
	{	
		totalCivilian = request.getParameter("totalCivilian");			
	}
	
	if(request.getParameter("totalTotal")!= null)
	{
		totalTotal = request.getParameter("totalTotal");			
	}
	
	map.put("hospitalId", hospitalId);
	
	map.put("currentDate", currentDate);
	map.put("lastUpdatedDate", lastUpdatedDate);
	
	map.put("personnelOfficer", personnelOfficer);
	map.put("personnelAirmen", personnelAirmen);
	map.put("personnelNcs", personnelNcs);
	map.put("personnelArmy", personnelArmy);
	map.put("personnelCivilian", personnelCivilian);
	map.put("personnelTotal", personnelTotal);
	
	map.put("wivesOfficer", wivesOfficer);
	map.put("wivesAirmen", wivesAirmen);
	map.put("wivesNcs", wivesNcs);
	map.put("wivesArmy", wivesArmy);
	map.put("wivesCivilian", wivesCivilian);
	map.put("wivesTotal", wivesTotal);
	
	map.put("childrenOfficer", childrenOfficer);
	map.put("childrenAirmen", childrenAirmen);
	map.put("childrenNcs", childrenNcs);
	map.put("childrenArmy", childrenArmy);
	map.put("childrenCivilian", childrenCivilian);
	map.put("childrenTotal", childrenTotal);
	
	map.put("totalOfficer", totalOfficer);
	map.put("totalAirmen", totalAirmen);
	map.put("totalNcs", totalNcs);
	map.put("totalArmy", totalArmy);
	map.put("totalCivilian", totalCivilian);
	map.put("totalTotal", totalTotal);
	
	boolean successfullyAdded = misHandlerService.submitBreakDownJSP(map);
		     
	if(successfullyAdded)
	  {
		message ="Record Added Successfully.";
	  }
	
	else
	{
		message = "Try Again !!";
	}
	
	jsp = "messageForBreakDown";
	 jsp += ".jsp";
	 title = "Break Down";
	 
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	
	return new ModelAndView("indexB","map",map);
	
}

public ModelAndView showShoAccommodation(HttpServletRequest request,HttpServletResponse response)
{  
	HttpSession session = request.getSession();
	
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> dataMap = new HashMap<String,Object>();
	
	map= misHandlerService.showShoAccommodation(dataMap);			
	
	jsp="sho_accommodation";
	jsp += ".jsp";
	title = "Sho Accommodation";
	map.put("contentJsp", jsp);
	map.put("title", "title");
	return new ModelAndView("indexB","map",map);

}

public ModelAndView showShoAntiFilaria(HttpServletRequest request,HttpServletResponse response)
{  
	HttpSession session = request.getSession();
	
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> dataMap = new HashMap<String,Object>();
	
	int hospitalId=0;
	if(session.getAttribute(HOSPITAL_ID)!= null)
	{
	    hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}

	dataMap.put("hospitalId", hospitalId);
	
	map= misHandlerService.showShoAntiFilaria(dataMap);			
	
	jsp="sho_anti_filaria";
	jsp += ".jsp";
	title = "Sho Anti Filaria";
	map.put("contentJsp", jsp);
	map.put("title", "title");
	return new ModelAndView("indexB","map",map);

}
public ModelAndView submitShoAntiFilariaJSP(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map = new HashMap<String,Object>();
	
	 int hospitalId =0;
	 
	 Date currentDate = new Date();
	 Date lastUpdatedDate = new Date();
		
	 String flyProofing = "";
	 String disposalOfRefuse = "";
	 String frequencyOfInsecticide = "";
	 
	 	 
	 session = request.getSession();
	 
	 if(session.getAttribute("hospitalId")!= null)
	 {
		 hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	 }
	 
	if(request.getParameter("currentDate")!= null)
	  {
		currentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("currentDate"));
	  }
	
	if(request.getParameter("lastUpdatedDate")!= null)
	  {
		lastUpdatedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("lastUpdatedDate"));
	  }
	
	if(request.getParameter("flyProofing")!= null)
	  {
		flyProofing = request.getParameter("flyProofing");
	  }
	
	if(request.getParameter("disposalOfRefuse")!= null)
	  {
		disposalOfRefuse = request.getParameter("disposalOfRefuse");
	  }
	
	if(request.getParameter("frequencyOfInsecticide")!= null)
	{
		frequencyOfInsecticide = request.getParameter("frequencyOfInsecticide");
	}
	
	
	
	map.put("hospitalId", hospitalId);
	
	map.put("currentDate", currentDate);
	map.put("lastUpdatedDate", lastUpdatedDate);
	
	map.put("flyProofing", flyProofing);
	map.put("disposalOfRefuse", disposalOfRefuse);
	map.put("frequencyOfInsecticide", frequencyOfInsecticide);
		
	boolean successfullyAdded = misHandlerService.submitShoAntiFilariaJSP(map);
		     
	if(successfullyAdded)
	  {
		message ="Record Added Successfully.";
	  }
	
	else
	{
		message = "Try Again !!";
	}
	
	jsp = "messageForShoAntiFalaria";
	 jsp += ".jsp";
	 title = "SHO Anti Filaria";
	 
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	
	return new ModelAndView("indexB","map",map);
	
}


public ModelAndView submitShoAccommodationJSP(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map = new HashMap<String,Object>();
	
	 int hospitalId =0;
	 int unitId=0;
	 
	 Date currentDate = new Date();
	 
	 String officersSingleE = "";
	 String officersSingleD = "";
	 String officersMarriedE = "";
	 String officersMarriedD = "";
	 	  
	 String airmenSingleE = "";
	 String airmenSingleD ="";
	 String airmenMarriedE = "";
	 String airmenMarriedD = "";
	 
	 String ncsSingleE = "";
	 String ncsSingleD = "";
	 String ncsMarriedE ="";
	 String ncsMarriedD ="";
	 
	 String dscSingleE = "";
	 String dscSingleD = "";
	 String dscMarriedE = "";
	 String dscMarriedD = "";
	 
	 String lightingArrangement = "";
	 String ventilation = "";
	 String coolingArrangement = "";
	 String heatingArrangement = "";
	 String remarks = "";
	 
	 session = request.getSession();
	 
	 if(session.getAttribute("hospitalId")!= null)
	 {
		 hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	 }
	 
	 if(request.getParameter("unitId")!= null)
	 {
		 unitId = (Integer.parseInt(request.getParameter("unitId")));
	 }
	 
	if(request.getParameter("currentDate")!= null)
	  {
		currentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("currentDate"));
	  }
	
	if(request.getParameter("officersSingleE")!= null)
	  {
		officersSingleE = request.getParameter("officersSingleE");
	  }
	
	if(request.getParameter("officersSingleD")!= null)
	  {
		officersSingleD = request.getParameter("officersSingleD");
	  }
	
	if(request.getParameter("officersMarriedE")!= null)
	{
		officersMarriedE = request.getParameter("officersMarriedE");
	}
	
	if(request.getParameter("officersMarriedD")!= null)
	{
		officersMarriedD = request.getParameter("officersMarriedD");
	}
	
	if(request.getParameter("airmenSingleE")!= null)
	  {
		airmenSingleE = request.getParameter("airmenSingleE");
	  }
	
	if(request.getParameter("airmenSingleD")!= null)
	{	
		airmenSingleD = request.getParameter("airmenSingleD");			
	}
	
	if(request.getParameter("airmenMarriedE")!= null)
	{	
		airmenMarriedE = request.getParameter("airmenMarriedE");			
	}
	
	if(request.getParameter("airmenMarriedD")!= null)
	{
		airmenMarriedD = request.getParameter("airmenMarriedD");			
	}
	
	if(request.getParameter("ncsSingleE")!= null)
	{
		ncsSingleE = request.getParameter("ncsSingleE");			
	}
	
	if(request.getParameter("ncsSingleD")!= null)
	{
		ncsSingleD = request.getParameter("ncsSingleD");			
	}
	
	if(request.getParameter("ncsMarriedE")!= null)
	{	
		ncsMarriedE = request.getParameter("ncsMarriedE");			
	}
	
	if(request.getParameter("ncsMarriedD")!= null)
	{
		ncsMarriedD = request.getParameter("ncsMarriedD");			
	}
	
	if(request.getParameter("dscSingleE")!= null)
	{	
		dscSingleE = request.getParameter("dscSingleE");			
	}
	
	if(request.getParameter("dscSingleD")!= null)
	{
		dscSingleD = request.getParameter("dscSingleD");			
	}
	
	if(request.getParameter("dscMarriedE")!= null)
	{
		dscMarriedE = request.getParameter("dscMarriedE");			
	}
	
	if(request.getParameter("dscMarriedD")!= null)
	{
		dscMarriedD = request.getParameter("dscMarriedD");			
	}
	
	if(request.getParameter("lightingArrangement")!= null)
	{	
		lightingArrangement = request.getParameter("lightingArrangement");			
	}
	
	if(request.getParameter("ventilation")!= null)
	{
		ventilation = request.getParameter("ventilation");			
	}
	
	if(request.getParameter("coolingArrangement")!= null)
	{	
		coolingArrangement = request.getParameter("coolingArrangement");			
	}
	
	if(request.getParameter("heatingArrangement")!= null)
	{
		heatingArrangement = request.getParameter("heatingArrangement");			
	}
	
	if(request.getParameter("remarks")!= null)
	{
		remarks = request.getParameter("remarks");			
	}
	
	map.put("hospitalId", hospitalId);
	map.put("unitId", unitId);
	
	map.put("currentDate", currentDate);
	
	map.put("officersSingleE", officersSingleE);
	map.put("officersSingleD", officersSingleD);
	map.put("officersMarriedE", officersMarriedE);
	map.put("officersMarriedD", officersMarriedD);
	
	map.put("airmenSingleE", airmenSingleE);
	map.put("airmenSingleD", airmenSingleD);
	map.put("airmenMarriedE", airmenMarriedE);
	map.put("airmenMarriedD", airmenMarriedD);
	
	map.put("ncsSingleE", ncsSingleE);
	map.put("ncsSingleD", ncsSingleD);
	map.put("ncsMarriedE", ncsMarriedE);
	map.put("ncsMarriedD", ncsMarriedD);
	
	map.put("dscSingleE", dscSingleE);
	map.put("dscSingleD", dscSingleD);
	map.put("dscMarriedE", dscMarriedE);
	map.put("dscMarriedD", dscMarriedD);
	
	map.put("lightingArrangement", lightingArrangement);
	map.put("ventilation", ventilation);
	map.put("coolingArrangement", coolingArrangement);
	map.put("heatingArrangement", heatingArrangement);
	map.put("remarks", remarks);
	

	boolean successfullyAdded = misHandlerService.submitShoAccommodationJSP(map);
		     
	if(successfullyAdded)
	  {
		message ="Record Added Successfully.";
	  }
	
	else
	{
		message = "Try Again !!";
	}
	
	jsp = "messageForShoAccommodation";
	 jsp += ".jsp";
	 title = "SHO Accommodation";
	 
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	
	return new ModelAndView("indexB","map",map);
	
}

public ModelAndView showShoConservancy(HttpServletRequest request,HttpServletResponse response)
{  
	HttpSession session = request.getSession();
	
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> dataMap = new HashMap<String,Object>();
	
	int hospitalId=0;
	if(session.getAttribute(HOSPITAL_ID)!= null)
	{
	    hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}

	dataMap.put("hospitalId", hospitalId);
	
	map= misHandlerService.showShoConservancy(dataMap);			
	
	jsp="sho_conservancy";
	jsp += ".jsp";
	title = "Sho Conservancy";
	map.put("contentJsp", jsp);
	map.put("title", "title");
	return new ModelAndView("indexB","map",map);

}

public ModelAndView submitShoConservancyJSP(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map = new HashMap<String,Object>();
	
	 int hospitalId =0;
	 
	 Date dateOfConservancy = new Date();
	 Date lastUpdatedDate = new Date();
		
	 String disposal = "";
	 String methodOfDisposal = "";
	 String functioningAdequately = "";
	 String reason = "";
	 String actionTaken = "";
	 String disposalOfGarbage = "";
		 	 
	 session = request.getSession();
	 
	 if(session.getAttribute("hospitalId")!= null)
	 {
		 hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	 }
	 
	if(request.getParameter("dateOfConservancy")!= null)
	  {
		dateOfConservancy = HMSUtil.convertStringTypeDateToDateType(request.getParameter("dateOfConservancy"));
	  }
	
	if(request.getParameter("lastUpdatedDate")!= null)
	  {
		lastUpdatedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("lastUpdatedDate"));
	  }
	
	if(request.getParameter("disposal")!= null)
	  {
		disposal = request.getParameter("disposal");
	  }
	
	if(request.getParameter("methodOfDisposal")!= null)
	  {
		methodOfDisposal = request.getParameter("methodOfDisposal");
	  }
	
	if(request.getParameter("functioningAdequately")!= null)
	{
		functioningAdequately = request.getParameter("functioningAdequately");
	}
	
	if(request.getParameter("reason")!= null)
	{
		reason = request.getParameter("reason");
	}
	
	if(request.getParameter("actionTaken")!= null)
	{
		actionTaken = request.getParameter("actionTaken");
	}
	if(request.getParameter("disposalOfGarbage")!= null)
	{
		disposalOfGarbage = request.getParameter("disposalOfGarbage");
	}
	
	
	map.put("hospitalId", hospitalId);
	
	map.put("dateOfConservancy", dateOfConservancy);
	map.put("lastUpdatedDate", lastUpdatedDate);
	
	map.put("disposal", disposal);
	map.put("methodOfDisposal", methodOfDisposal);
	map.put("functioningAdequately", functioningAdequately);
	map.put("reason", reason);
	map.put("actionTaken", actionTaken);
	map.put("disposalOfGarbage", disposalOfGarbage);
	
	boolean successfullyAdded = misHandlerService.submitShoConservancyJSP(map);
		     
	if(successfullyAdded)
	  {
		message ="Record Added Successfully.";
	  }
	
	else
	{
		message = "Try Again !!";
	}
	
	jsp = "messageForShoConservancy";
	 jsp += ".jsp";
	 title = "SHO Anti Filaria";
	 
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	
	return new ModelAndView("indexB","map",map);
	
}
public ModelAndView showShoCatering(HttpServletRequest request,HttpServletResponse response)
{  
	HttpSession session = request.getSession();
	
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> dataMap = new HashMap<String,Object>();
	
	int hospitalId=0;
	if(session.getAttribute(HOSPITAL_ID)!= null)
	{
	    hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}

	dataMap.put("hospitalId", hospitalId);
	
	map= misHandlerService.showShoCatering(dataMap);			
	
	jsp="sho_catering";
	jsp += ".jsp";
	title = "Sho Catering";
	map.put("contentJsp", jsp);
	map.put("title", "title");
	return new ModelAndView("indexB","map",map);
	
}


public ModelAndView submitShoCateringJSP(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map = new HashMap<String,Object>();
	
	 int hospitalId =0;
	 
	 Date currentDate = new Date();
	 Date lastUpdatedDate = new Date();
		
	 String officerMess = "";
	 String sncoMess = "";
	 String airmenMess = "";
	 String flyProofing = "";
	 String rationStore = "";
		 	 
	 session = request.getSession();
	 
	 if(session.getAttribute("hospitalId")!= null)
	 {
		 hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	 }
	 
	if(request.getParameter("currentDate")!= null)
	  {
		currentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("currentDate"));
	  }
	
	if(request.getParameter("lastUpdatedDate")!= null)
	  {
		lastUpdatedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("lastUpdatedDate"));
	  }
	
	if(request.getParameter("officerMess")!= null)
	  {
		officerMess = request.getParameter("officerMess");
	  }
	
	if(request.getParameter("airmenMess")!= null)
	  {
		airmenMess = request.getParameter("airmenMess");
	  }
	
	if(request.getParameter("sncoMess")!= null)
	{
		sncoMess = request.getParameter("sncoMess");
	}
	
	if(request.getParameter("flyProofing")!= null)
	{
		flyProofing = request.getParameter("flyProofing");
	}
	
	if(request.getParameter("rationStore")!= null)
	{
		rationStore = request.getParameter("rationStore");
	}
	
	
	
	map.put("hospitalId", hospitalId);
	
	map.put("currentDate", currentDate);
	map.put("lastUpdatedDate", lastUpdatedDate);
	
	map.put("officerMess", officerMess);
	map.put("airmenMess", airmenMess);
	map.put("sncoMess", sncoMess);
	map.put("flyProofing", flyProofing);
	map.put("rationStore", rationStore);
	
	boolean successfullyAdded = misHandlerService.submitShoCateringJSP(map);
		     
	if(successfullyAdded)
	  {
		message ="Record Added Successfully";
	  }
	
	else
	{
		message = "Try Again !!";
	}
	
	jsp = "messageForShoCatering";
	 jsp += ".jsp";
	 title = "SHO Anti Filaria";
	 
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	
	return new ModelAndView("indexB","map",map);
	
}


public ModelAndView showSchoolHealth(HttpServletRequest request,HttpServletResponse response)
{  
	HttpSession session = request.getSession();
	
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> dataMap = new HashMap<String,Object>();
		
	int hospitalId=0;
	if(session.getAttribute(HOSPITAL_ID)!= null)
	{
	    hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}

	dataMap.put("hospitalId", hospitalId);
	
	map= misHandlerService.showSchoolHealth(dataMap);			
	
	jsp="sho_school_health";
	jsp += ".jsp";
	title = "Sho School Health";
	map.put("contentJsp", jsp);
	map.put("title", "title");
	return new ModelAndView("indexB","map",map);
	
}

public ModelAndView submitSchoolHealthJsp(HttpServletRequest request,HttpServletResponse response)
{
	
	
	Map<String,Object> map = new HashMap<String,Object>();
	
	 int hospitalId =0;
	 int unitId =0;
	 
	 Date schoolInspectionDate = new Date();
	 Date lastUpdatedDate = new Date();
		
	 String noOfChildren = "";
	 String defectOfChildren = "";
	 String dentalCaries = "";
	 String refractiveError = "";
	 String anaemia = "";
	 String waxEar = "";
	 String actionTaken = "";
	 
	 String bcgChildren = "";
	 String opvChildren = "";
	 String dptChildren = "";
	 String measlesChildren = "";
	 String dtChildren = "";
	 String taChildren = "";
	 String ttChildren = "";
	 String hepatitisChildren = "";
	 String pulsePolioChildren = "";
		 	 
	 session = request.getSession();
	 
	 if(session.getAttribute("hospitalId")!= null)
	 {
		 hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	 }
	 
	if(request.getParameter("unitId")!= null)
	  {
		unitId = Integer.parseInt(request.getParameter("unitId"));
	  }
	
	if(request.getParameter("schoolInspectionDate")!= null)
	{
		schoolInspectionDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("schoolInspectionDate"));
	}
	
	if(request.getParameter("lastUpdatedDate")!= null)
	  {
		lastUpdatedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("lastUpdatedDate"));
	  }
	
	if(request.getParameter("noOfChildren")!= null)
	  {
		noOfChildren = request.getParameter("noOfChildren");
	  }
	
	if(request.getParameter("defectOfChildren")!= null)
	  {
		defectOfChildren = request.getParameter("defectOfChildren");
	  }
	
	if(request.getParameter("dentalCaries")!= null)
	{
		dentalCaries = request.getParameter("dentalCaries");
	}
	
	if(request.getParameter("refractiveError")!= null)
	{
		refractiveError = request.getParameter("refractiveError");
	}
	
	if(request.getParameter("anaemia")!= null)
	{
		anaemia = request.getParameter("anaemia");
	}
	
	if(request.getParameter("waxEar")!= null)
	{
		waxEar = request.getParameter("waxEar");
	}
	
	if(request.getParameter("actionTaken")!= null)
	{
		actionTaken = request.getParameter("actionTaken");
	}
	
	if(request.getParameter("bcgChildren")!= null)
	{
		bcgChildren = request.getParameter("bcgChildren");
	}
	
	if(request.getParameter("opvChildren")!= null)
	{
		opvChildren = request.getParameter("opvChildren");
	}
	
	if(request.getParameter("dptChildren")!= null)
	{
		dptChildren = request.getParameter("dptChildren");
	}
	
	if(request.getParameter("measlesChildren")!= null)
	{
		measlesChildren = request.getParameter("measlesChildren");
	}
	
	if(request.getParameter("dtChildren")!= null)
	{
		dtChildren = request.getParameter("dtChildren");
	}
	
	if(request.getParameter("taChildren")!= null)
	{
		taChildren = request.getParameter("taChildren");
	}
	
	if(request.getParameter("ttChildren")!= null)
	{
		ttChildren = request.getParameter("ttChildren");
	}
	
	if(request.getParameter("hepatitisChildren")!= null)
	{
		hepatitisChildren = request.getParameter("hepatitisChildren");
	}
	
	if(request.getParameter("pulsePolioChildren")!= null)
	{
		pulsePolioChildren = request.getParameter("pulsePolioChildren");
	}
	
	
	
	map.put("hospitalId", hospitalId);
	
	map.put("unitId", unitId);
	map.put("schoolInspectionDate", schoolInspectionDate);
	
	map.put("lastUpdatedDate", lastUpdatedDate);
	map.put("noOfChildren", noOfChildren);
	map.put("defectOfChildren", defectOfChildren);
	map.put("dentalCaries", dentalCaries);
	map.put("refractiveError", refractiveError);
	map.put("anaemia", anaemia);
	map.put("waxEar", waxEar);
	map.put("actionTaken", actionTaken);
	
	map.put("bcgChildren", bcgChildren);
	map.put("opvChildren", opvChildren);
	map.put("dptChildren", dptChildren);
	map.put("measlesChildren", measlesChildren);
	map.put("dtChildren", dtChildren);
	map.put("taChildren", taChildren);
	map.put("ttChildren", ttChildren);
	map.put("hepatitisChildren", hepatitisChildren);
	map.put("pulsePolioChildren", pulsePolioChildren);
	
	
	
	boolean successfullyAdded = misHandlerService.submitSchoolHealthJsp(map);
		     
	if(successfullyAdded)
	  {
		message ="Record Added Successfully";
	  }
	
	else
	{
		message = "Try Again !!";
	}
	
	jsp = "messageForSchooHealth";
	 jsp += ".jsp";
	 title = "Submit Method of School Health Details";
	 
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	
	return new ModelAndView("indexB","map",map);
	
}

// By Mansi on 13 May 2013

public ModelAndView showAdmissionDeath(HttpServletRequest request,HttpServletResponse response) {
	HttpSession session = request.getSession();
	MultipartFormDataRequest mrequest = null;
	
	Map<String, Object> dataMap = new HashMap<String, Object>();
	 
	int deptId = (Integer) session.getAttribute("deptId");
	dataMap.put("deptId", deptId);
	map = misHandlerService.showAdmissionDeath(dataMap);
	jsp = "admissionDeath";
	jsp += ".jsp";
	
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("indexB", "map", map);

}


public ModelAndView submitAdmissionDeath(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> mapForDS = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
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
	

	int hiddenValue = 1;
	if (Integer.parseInt(request.getParameter("hiddenValue")) != 1) {
		hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
	}
	


	
for (int j = 1; j <= hiddenValue; j++) {


	String category = "";
	if(request.getParameter("category" + j) != null && !request.getParameter("category" + j).equals("")){
		category = request.getParameter("category" + j);
		categoryList.add(category);
	}	else {
		categoryList.add("");
	}
	String avg = "";
	if(request.getParameter("avg" + j) != null && !request.getParameter("avg" + j).equals("")){
		avg = request.getParameter("avg" + j);
		avgList.add(avg);
	}	else {
		avgList.add("");
	}
	
	String rate = "";
	if(request.getParameter("rate" + j) != null && !request.getParameter("rate" + j).equals("")){
		rate = request.getParameter("rate" + j);
		rateList.add(rate);
	}	else {
		rateList.add("");
	}
	
	String noOfAd = "";
	if(request.getParameter("noOfAd" + j) != null && !request.getParameter("noOfAd" + j).equals("")){
		noOfAd = request.getParameter("noOfAd" + j);
		noOfAdmissionList.add(noOfAd);
	}	else {
		noOfAdmissionList.add("");
	}
	
	if(request.getParameter("giveOn"+j)!=null){
		admissionDateList.add(request.getParameter("giveOn"+j));
	}
	
	
	if(request.getParameter("lastDate"+j)!=null){
		lastDateList.add(request.getParameter("lastDate"+j));
	}
	String noOfD = "";
	if(request.getParameter("noOfD" + j) != null && !request.getParameter("noOfD" + j).equals("")){
		noOfD = request.getParameter("noOfD" + j);
		noOfDeathList.add(noOfD);
	}else{
		noOfDeathList.add("");
	}
	
	if(request.getParameter("slNo" + j) != null && !request.getParameter("slNo" + j).equals("")){
		int slNo = Integer.parseInt(request.getParameter("slNo"+ j));
		slNoList.add(slNo);
						
	}else {
		slNoList.add(0);
	}


	if (request.getParameter(PRINCIPAL + j) != null
			&& !request.getParameter(PRINCIPAL + j).equals("")) {
		diagnosisList.add(request.getParameter(PRINCIPAL + j));
	} else {
		diagnosisList.add("");
	}
	int relationId = 0;
	if(request.getParameter("relation" + j) != null && !request.getParameter("relation" + j).equals("")){
		relationId = Integer.parseInt(request.getParameter("relation" + j));
		relationList.add(relationId);
	}else {
		relationList.add(0);
	}

}
int hospitalId=0;
if(session.getAttribute(HOSPITAL_ID) != null){
	hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	hospitalList.add(hospitalId);
	box.put("hospitalId", hospitalId);
	
}
else
{
	hospitalList.add(0);
}


mapForDS.put("slNoList", slNoList);
mapForDS.put("admissionDateList", admissionDateList);
mapForDS.put("lastDateList", lastDateList);
mapForDS.put("diagnosisList", diagnosisList);
mapForDS.put("categoryList", categoryList);
mapForDS.put("relationList", relationList);
mapForDS.put("noOfAdmissionList", noOfAdmissionList);
mapForDS.put("noOfDeathList", noOfDeathList);
mapForDS.put("avgList", avgList);
mapForDS.put("rateList", rateList);
mapForDS.put("hiddenValue", hiddenValue);
mapForDS.put("hospitalList", hospitalList);
mapForDS.put("hospitalId", hospitalId);

mapForDS.put("box", box);
boolean bool = false;
	map = misHandlerService.submitAdmissionDeath(box,mapForDS);
	String message = null;
	if (map.get("succesfullyAdded") != null) {
		bool = (Boolean) map.get("succesfullyAdded");
	}
	if (bool) {
		
			message = "Admissiom/Death Submitted.";
			map.put("message", message);
	
	} else {
	
		message = "Error Occurred in Submitting Details.";
		map.put("message", message);
	}
	jsp = "sho_message";
	jsp += ".jsp";

	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("deptId", box.getInt("deptId"));
	return new ModelAndView("indexB", "map", map);
}

//---by kiran

public ModelAndView showOfficerDetails(HttpServletRequest request,HttpServletResponse response) {
	HttpSession session = request.getSession();
	MultipartFormDataRequest mrequest = null;
	
	Map<String, Object> dataMap = new HashMap<String, Object>();
	 
	int hospitalId=0;
	if(session.getAttribute(HOSPITAL_ID)!= null)
	{
	    hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}

	dataMap.put("hospitalId", hospitalId);
	
	map = misHandlerService.showOfficerDetails(dataMap);
	jsp = "sho_lady_officer";
	jsp += ".jsp";
	
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("indexB", "map", map);

}

public ModelAndView submitLadyOfficerJsp(HttpServletRequest request,HttpServletResponse response)
{
	
	
	Map<String,Object> map = new HashMap<String,Object>();
	
	 int hospitalId =0;
	 int unitId =0;
	 
	 Date currentDate = new Date();
	 Date lastUpdatedDate = new Date();
		
	 String officerCataract = "";
	 String officerGlaucoma = "";
	 String airmenCataract = "";
	 String airmenGlaucoma = "";
	 String familyCataract = "";
	 String familyGlaucoma = "";
	 String servicemenCataract = "";
	 String servicemenGlaucoma="";
	 
	 String multiBacillary = "";
	 String pauciBacillary = "";
	 String hepatitisViral = "";
	 String otherViral = "";
	 String noOfDogBite = "";
	 String totalDoses = "";
	
		 	 
	 session = request.getSession();
	 
	 if(session.getAttribute("hospitalId")!= null)
	 {
		 hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	 }
	 
	if(request.getParameter("unitId")!= null)
	  {
		unitId = Integer.parseInt(request.getParameter("unitId"));
	  }
	
	if(request.getParameter("currentDate")!= null)
	{
		currentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("currentDate"));
	}
	
	if(request.getParameter("lastUpdatedDate")!= null)
	  {
		lastUpdatedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("lastUpdatedDate"));
	  }
	
	if(request.getParameter("officerCataract")!= null)
	  {
		officerCataract = request.getParameter("officerCataract");
	  }
	
	if(request.getParameter("officerGlaucoma")!= null)
	  {
		officerGlaucoma = request.getParameter("officerGlaucoma");
	  }
	
	if(request.getParameter("airmenCataract")!= null)
	{
		airmenCataract = request.getParameter("airmenCataract");
	}
	
	if(request.getParameter("airmenGlaucoma")!= null)
	{
		airmenGlaucoma = request.getParameter("airmenGlaucoma");
	}
	
	if(request.getParameter("familyCataract")!= null)
	{
		familyCataract = request.getParameter("familyCataract");
	}
	
	if(request.getParameter("familyGlaucoma")!= null)
	{
		familyGlaucoma = request.getParameter("familyGlaucoma");
	}
	
	if(request.getParameter("servicemenCataract")!= null)
	{
		servicemenCataract = request.getParameter("servicemenCataract");
	}
	
	if(request.getParameter("servicemenGlaucoma")!= null)
	{
		servicemenGlaucoma = request.getParameter("servicemenGlaucoma");
	}
	
	if(request.getParameter("multiBacillary")!= null)
	{
		multiBacillary = request.getParameter("multiBacillary");
	}
	
	if(request.getParameter("pauciBacillary")!= null)
	{
		pauciBacillary = request.getParameter("pauciBacillary");
	}
	
	if(request.getParameter("hepatitisViral")!= null)
	{
		hepatitisViral = request.getParameter("hepatitisViral");
	}
	
	if(request.getParameter("otherViral")!= null)
	{
		otherViral = request.getParameter("otherViral");
	}
	
	if(request.getParameter("noOfDogBite")!= null)
	{
		noOfDogBite = request.getParameter("noOfDogBite");
	}

	if(request.getParameter("totalDoses")!= null)
	{
		totalDoses = request.getParameter("totalDoses");
	}
	
	
	map.put("hospitalId", hospitalId);
	
	map.put("unitId", unitId);
	map.put("currentDate", currentDate);
	
	map.put("lastUpdatedDate", lastUpdatedDate);
	map.put("officerCataract", officerCataract);
	map.put("officerGlaucoma", officerGlaucoma);
	map.put("airmenCataract", airmenCataract);
	map.put("airmenGlaucoma", airmenGlaucoma);
	map.put("familyCataract", familyCataract);
	map.put("familyGlaucoma", familyGlaucoma);
	map.put("servicemenCataract", servicemenCataract);
	
	map.put("servicemenGlaucoma", servicemenGlaucoma);
	map.put("multiBacillary", multiBacillary);
	map.put("pauciBacillary", pauciBacillary);
	map.put("hepatitisViral", hepatitisViral);
	map.put("otherViral", otherViral);
	map.put("noOfDogBite", noOfDogBite);
	map.put("totalDoses", totalDoses);
	
	boolean successfullyAdded = misHandlerService.submitLadyOfficerJsp(map);
		     
	if(successfullyAdded)
	  {
		message ="Record Added Successfully";
	  }
	
	else
	{
		message = "Try Again !!";
	}
	
	jsp = "messageForLadyOfficerDetails";
	 jsp += ".jsp";
	 title = "Submit Method of Lady Officer Details";
	 
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	
	return new ModelAndView("indexB","map",map);
	
}

public ModelAndView showIndustrialDisease(HttpServletRequest request,HttpServletResponse response) {
	HttpSession session = request.getSession();
	MultipartFormDataRequest mrequest = null;
	
	Map<String, Object> dataMap = new HashMap<String, Object>();
	 
	int hospitalId=0;
	if(session.getAttribute(HOSPITAL_ID)!= null)
	{
	    hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}

	dataMap.put("hospitalId", hospitalId);
	
	map = misHandlerService.showIndustrialDisease(dataMap);
	jsp = "sho_industrial_disease";
	jsp += ".jsp";
	
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("indexB", "map", map);

}

public ModelAndView submitShoIndustrialDisease(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map = new HashMap<String,Object>();
	
	 int hospitalId =0;
	 
	 Date currentDate = new Date();
	 Date lastUpdatedDate = new Date();
		
	 String particuler = "";
	 String noOfCases = "";
	 String action = "";
	 String recreation = "";
	 String moral = "";
		 	 
	 session = request.getSession();
	 
	 if(session.getAttribute("hospitalId")!= null)
	 {
		 hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	 }
	 
	if(request.getParameter("currentDate")!= null)
	  {
		currentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("currentDate"));
	  }
	
	if(request.getParameter("lastUpdatedDate")!= null)
	  {
		lastUpdatedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("lastUpdatedDate"));
	  }
	
	if(request.getParameter("particuler")!= null)
	  {
		particuler = request.getParameter("particuler");
	  }
	
	if(request.getParameter("noOfCases")!= null)
	  {
		noOfCases = request.getParameter("noOfCases");
	  }
	
	if(request.getParameter("action")!= null)
	{
		action = request.getParameter("action");
	}
	
	if(request.getParameter("recreation")!= null)
	{
		recreation = request.getParameter("recreation");
	}
	
	if(request.getParameter("moral")!= null)
	{
		moral = request.getParameter("moral");
	}
	
		
	map.put("hospitalId", hospitalId);
	
	map.put("currentDate", currentDate);
	map.put("lastUpdatedDate", lastUpdatedDate);
	
	map.put("particuler", particuler);
	map.put("noOfCases", noOfCases);
	map.put("action", action);
	map.put("recreation", recreation);
	map.put("moral", moral);
	
	boolean successfullyAdded = misHandlerService.submitShoIndustrialDisease(map);
		     
	if(successfullyAdded)
	  {
		message ="Record Added Successfully";
	  }
	
	else
	{
		message = "Try Again !!";
	}
	
	jsp = "messageForShoIndustrialDisease";
	 jsp += ".jsp";
	 title = "Sho Industrial Disease";
	 
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	
	return new ModelAndView("indexB","map",map);
	
}


// ---By-----Mansi on 17 May 2013

public ModelAndView showFamilyWelfareActivities(HttpServletRequest request,HttpServletResponse response) {
	HttpSession session = request.getSession();
	MultipartFormDataRequest mrequest = null;
	
	Map<String, Object> dataMap = new HashMap<String, Object>();
	 
	int deptId = (Integer) session.getAttribute("deptId");
	dataMap.put("deptId", deptId);
	map = misHandlerService.showFamilyWelfareActivities(dataMap);
	jsp = "familyWelfareActivities";
	jsp += ".jsp";
	
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("indexB", "map", map);

}


public ModelAndView submitFamilyWelfareActivities(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> mapForDS = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	int visitId=0;
	int hospitalId  = 0;
	int userId = 0;
	int deptId = 0;
	boolean submitData = false;
	
	if(session.getAttribute(HOSPITAL_ID) != null){
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		mapForDS.put("hospitalId", hospitalId);
	}

	if(session.getAttribute(HOSPITAL_ID) != null){
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
	}
	String changedBy = "";
	String changedDate = "";
	String changedTime = "";
		
	if (request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))) 
	{
	   changedBy = (request.getParameter(CHANGED_BY));
	}
	
	
	if (request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))) 
	{
		changedDate = (request.getParameter(CHANGED_DATE));
	}
		
	if (request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))) 
	{
		changedTime = request.getParameter(CHANGED_TIME);
	}

mapForDS.put("box", box);
mapForDS.put("userId", userId);
mapForDS.put("changedTime", changedTime);
mapForDS.put("changedBy", changedBy);
mapForDS.put("changedDate", changedDate);
mapForDS.put("hospitalId", hospitalId);

	boolean bool = false;
	map = misHandlerService.submitFamilyWelfareActivities(box,mapForDS);
	String message = null;
	if (map.get("succesfullyAdded") != null) {
		bool = (Boolean) map.get("succesfullyAdded");
	}
	if (bool) {
		
			message = "Family Welfare Activities Submitted.";
			map.put("message", message);
		//}
	} else {
	
		message = "Error Occurred in Submitting Details.";
		map.put("message", message);
	}
	jsp = "mis_familyWelfareMessage";
	jsp += ".jsp";
	title = "Patient Details";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("indexB", "map", map);
}

//----------Generate Annual Health Report

public ModelAndView showAnnualHealthReportJsp(HttpServletRequest request,HttpServletResponse response) {
	
	Map<String,Object>  map = new HashMap<String,Object>();
	jsp = "annualHealthReport";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index","map",map);
	
}

public ModelAndView printAnnualHealthReport(HttpServletRequest request, HttpServletResponse response)
{
	Map<String, Object> map = new HashMap<String, Object>();
	Date fromDate = new Date();
	Date toDate = new Date();
	if(request.getParameter(FROM_DATE) != null){
	fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));		
	}
	if(request.getParameter(TO_DATE) != null){
	toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));		
	}
	HttpSession session = request.getSession();
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);		
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	detailsMap = misHandlerService.getConnectionForReport();
	Map<String, Object> parameters = new HashMap<String, Object>();
	parameters.put("fromDate", fromDate);
	parameters.put("toDate", toDate);
    parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports"));
	HMSUtil.generateReport("Quaterly_Annual_Health_Report", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
	return null; 
	
}

public ModelAndView showWorkService(HttpServletRequest request,HttpServletResponse response) 
{
	HttpSession session = request.getSession();
	MultipartFormDataRequest mrequest = null;
	
	Map<String, Object> dataMap = new HashMap<String, Object>();
	 
	int hospitalId=0;
	if(session.getAttribute(HOSPITAL_ID)!= null)
	{
	    hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}

	dataMap.put("hospitalId", hospitalId);
	
	map = misHandlerService.showWorkService(dataMap);
	jsp = "sho_workService";
	jsp += ".jsp";
	
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("indexB", "map", map);

}

public ModelAndView submitWorkService(HttpServletRequest request,HttpServletResponse response)
{
	Map<String,Object> map = new HashMap<String,Object>();
	
	 int hospitalId =0;
	 
	 Date currentDate = new Date();
	 Date lastUpdatedDate = new Date();
		
	 String nursingStaff = "";
	 String nursingStaffRemarks = "";
	 
	 String specialistCover = "";
	 String specialistCoverRemarks = "";
	 
	 String medicalStore = "";
	 String medicalStoreRemarks = "";
	
	 String hygineChemical = "";
	 String hygineChemicalRemarks = "";
	 
	 String dentalCarries = "";
	 String dentalCarriesRemarks = "";
	 
	 
	 session = request.getSession();
	 
	 if(session.getAttribute("hospitalId")!= null)
	 {
		 hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
	 }
	 
	if(request.getParameter("currentDate")!= null)
	  {
		currentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("currentDate"));
	  }
	
	if(request.getParameter("lastUpdatedDate")!= null)
	  {
		lastUpdatedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("lastUpdatedDate"));
	  }
	
	if(request.getParameter("nursingStaff")!= null)
	  {
		nursingStaff = request.getParameter("nursingStaff");
	  }
	
	if(request.getParameter("nursingStaffRemarks")!= null)
	  {
		nursingStaffRemarks = request.getParameter("nursingStaffRemarks");
	  }
	
	if(request.getParameter("specialistCover")!= null)
	{
		specialistCover = request.getParameter("specialistCover");
	}
	
	if(request.getParameter("specialistCoverRemarks")!= null)
	{
		specialistCoverRemarks = request.getParameter("specialistCoverRemarks");
	}
	
	if(request.getParameter("medicalStore")!= null)
	{
		medicalStore = request.getParameter("medicalStore");
	}
	
	if(request.getParameter("medicalStoreRemarks")!= null)
	{
		medicalStoreRemarks = request.getParameter("medicalStoreRemarks");
	}
	
	if(request.getParameter("hygineChemical")!= null)
	{
		hygineChemical = request.getParameter("hygineChemical");
	}
	
	if(request.getParameter("hygineChemicalRemarks")!= null)
	{
		hygineChemicalRemarks = request.getParameter("hygineChemicalRemarks");
	}
	
	if(request.getParameter("dentalCarries")!= null)
	{
		dentalCarries = request.getParameter("dentalCarries");
	}
	
	if(request.getParameter("dentalCarriesRemarks")!= null)
	{
		dentalCarriesRemarks = request.getParameter("dentalCarriesRemarks");
	}
	
	map.put("hospitalId", hospitalId);
	
	map.put("currentDate", currentDate);
	map.put("lastUpdatedDate", lastUpdatedDate);
	
	map.put("nursingStaff", nursingStaff);
	map.put("nursingStaffRemarks", nursingStaffRemarks);
	map.put("specialistCover", specialistCover);
	map.put("specialistCoverRemarks", specialistCoverRemarks);
	map.put("medicalStore", medicalStore);
	map.put("medicalStoreRemarks", medicalStoreRemarks);
	map.put("hygineChemical", hygineChemical);
	map.put("hygineChemicalRemarks", hygineChemicalRemarks);
	map.put("dentalCarries", dentalCarries);
	map.put("dentalCarriesRemarks", dentalCarriesRemarks);
	
	boolean successfullyAdded = misHandlerService.submitWorkService(map);
		     
	if(successfullyAdded)
	  {
		message ="Record Added Successfully";
	  }
	
	else
	{
		message = "Try Again !!";
	}
	
	jsp = "messageForWorkService";
	 jsp += ".jsp";
	 title = "Sho Work Service";
	 
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	
	return new ModelAndView("indexB","map",map);
	
}

public ModelAndView getSerNoDetailForIncident(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box  = HMSUtil.getBox(request);
	String serviceNo="";
	if (request.getParameter("serviceNo") != null	&& !(request.getParameter("serviceNo").equals(""))) {
		serviceNo =request.getParameter("serviceNo");
		box.put("serviceNo", serviceNo);
	}
	map = misHandlerService.getSerNoDetailForIncident(box);
	
	return new ModelAndView("sho_respSrNoIncident","map",map);
}


public void fillAVServiceDetail(HttpServletRequest request,HttpServletResponse response) {
	System.out.println("IN Controller");
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	List<Patient> patientList = new ArrayList<Patient>();
	String serviceNo = "";

	try {
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	dataMap.put("serviceNo", serviceNo);
	map = misHandlerService.fillAVServiceDetail(dataMap);
	if (map.get("patientList") != null) {
		patientList = (List) map.get("patientList");
	}
	StringBuffer sb = new StringBuffer();
	try {
		sb.append("<items>");
		for (Patient patient : patientList) {
			sb.append("<item>");
			if (patient.getTrade() != null) {
				sb.append("<sanitaryBranch>" + patient.getTrade().getTradeName()+ "</sanitaryBranch>");
				sb.append("<branchId>" + patient.getTrade().getId()+ "</branchId>");
			} else {
				sb.append("<sanitaryBranch>-</sanitaryBranch>");
				sb.append("<branchId>-</branchId>");
			}
			String name="";
			name=patient.getPFirstName();
			if(patient.getPLastName() !=null ){
				name=name+" "+patient.getPLastName();
			}
			sb.append("<nameofSanitaryRound>" + name + "</nameofSanitaryRound>");
			int hinId=0;
			if(patient.getId() !=null && patient.getId() !=0){
				hinId=patient.getId();}
			sb.append("<hinId>" + hinId + "</hinId>");
			
			
			sb.append("</item>");
			break;
		}
		sb.append("</items>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
	} catch (Exception e) {
		e.printStackTrace();
	}
	response.setContentType("text/xml");
	response.setHeader("Cache-Control", "no-cache");
	try {
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<chargeCodes>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</chargeCodes>");

	} catch (Exception e) {
		e.printStackTrace();
	}

}


//-----Statistics Help

public void showStatisticsHelp(HttpServletRequest request,HttpServletResponse response) {

	
	String userHome = getServletContext().getRealPath("");
	String fileSeparator = System.getProperty("file.separator");
	String uploadURL = userHome
			+ fileSeparator
			+ "help"
			+ fileSeparator;
			

	
	try {
		
		response.setContentType("application/pdf");
		
		response.setHeader("Content-Disposition", "attachment;filename="
				+ java.net.URLEncoder.encode("SHO.pdf")
				+ "");

		File f = new File(uploadURL + "/Statistics.pdf");
		InputStream in = new FileInputStream(f);
		response.getOutputStream().flush();
		ServletOutputStream outs = response.getOutputStream();

		long length = f.length();

		if (length > Integer.MAX_VALUE) {
			// File is too large
		}

		// Create the byte array to hold the data
		byte[] bytes = new byte[(int) length];

		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead = in.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		if (offset < bytes.length) {
		}
		outs.write(bytes);
		in.close();

	} catch (IOException ioe) {
		ioe.printStackTrace();
	}


}


}
