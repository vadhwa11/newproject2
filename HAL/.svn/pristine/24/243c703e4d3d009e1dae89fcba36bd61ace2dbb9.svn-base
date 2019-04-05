package jkt.hms.appointment.controller;

/**
 * @ author: Priyanka Garg
 * Made on: 9th July 2008
 */

import static jkt.hms.util.RequestConstants.AGE;
import static jkt.hms.util.RequestConstants.AGE_UNIT;
import static jkt.hms.util.RequestConstants.APMT_DATE;
import static jkt.hms.util.RequestConstants.APPOINTMENT_CANCELLATION_REPORT_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_INVESTIGATION_CANCELLATION_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_INVESTIGATION_CANCELLATION_LIST;
import static jkt.hms.util.RequestConstants.APPOINTMENT_INVESTIGATION_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_INVESTIGATION_SETUP_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_INV_SLIP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_LIST_REPORT_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_MESSAGE_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_PATIENTS_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_PATIENT_CANCELLATION_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_PATIENT_CANCELLATION_LIST;
import static jkt.hms.util.RequestConstants.APPOINTMENT_REGISTERED_PATIENTS_FOR_DOCTORS_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_REGISTERED_PATIENTS_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_SETUP_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_SLIP;
import static jkt.hms.util.RequestConstants.APP_APP_SETUP;
import static jkt.hms.util.RequestConstants.APP_BLOCK;
import static jkt.hms.util.RequestConstants.APP_BLOCK_ID;
import static jkt.hms.util.RequestConstants.APP_INVESTIGATION_CANCELLATION_LIST_REP;
import static jkt.hms.util.RequestConstants.APP_INVEST_SETUP;
import static jkt.hms.util.RequestConstants.APP_INVEST_SETUP_DAY_WISE_JSP;
import static jkt.hms.util.RequestConstants.APP_INVEST_SETUP_DAY_WISE_REP;
import static jkt.hms.util.RequestConstants.APP_SETUP_ALL;
import static jkt.hms.util.RequestConstants.APP_SETUP_DAY_WISE_JSP;
import static jkt.hms.util.RequestConstants.APP_SETUP_DAY_WISE_REP;
import static jkt.hms.util.RequestConstants.BLOCK_FROM_DATE;
import static jkt.hms.util.RequestConstants.BLOCK_TO_DATE;
import static jkt.hms.util.RequestConstants.DAY;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DEPT_ID;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.EQUIPMENT_ID;
import static jkt.hms.util.RequestConstants.EQUIP_ID;
import static jkt.hms.util.RequestConstants.FROMTIMESLOT;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INVESTIGATION_LIST_REPORT_JSP;
import static jkt.hms.util.RequestConstants.INVESTIGATION_PATIENT_LIST;
import static jkt.hms.util.RequestConstants.LOGIN_NAME;
import static jkt.hms.util.RequestConstants.MOBILE_NO;
import static jkt.hms.util.RequestConstants.PASSWORD;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.PATIENT_TYPE;
import static jkt.hms.util.RequestConstants.REASON;
import static jkt.hms.util.RequestConstants.RESPONSE_APPOINTMENT_DAYS_FOR_DEPT_EQUIPMENT_JSP;
import static jkt.hms.util.RequestConstants.RESPONSE_APPOINTMENT_DETAILS_FOR_DEPARTMENT_JSP;
import static jkt.hms.util.RequestConstants.RESPONSE_FOR_INVESTIGATION_EQUIPMENT_JSP;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SEX;
import static jkt.hms.util.RequestConstants.TOTIMESLOT;
import static jkt.hms.util.RequestConstants.VALID_FROM_DATE;
import static jkt.hms.util.RequestConstants.VALID_TO_DATE;
import static jkt.hms.util.RequestConstants.WARD_ID;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.appointment.handler.AppointmentHandlerService;
import jkt.hms.masters.business.AppBlock;
import jkt.hms.masters.business.AppSetup;
import jkt.hms.masters.business.MasApplicationgroup;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.UserDepartment;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AppointmentController extends MultiActionController {

	/**
	 * ------------------- GETTER AND SETTER METHODS -----------------------
	 * 
	 * @return
	 */
	public AppointmentHandlerService getAppointmentHandlerService() {
		return appointmentHandlerService;
	}

	public void setAppointmentHandlerService(
			AppointmentHandlerService appointmentHandlerService) {
		this.appointmentHandlerService = appointmentHandlerService;
	}

	/**
	 * ----------------------------------------------------------------------
	 * ------------------ Start of coding --------------------
	 */

	AppointmentHandlerService appointmentHandlerService = null;
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = null;
	String title = null;

	/**
	 * ---------------------------- APPOINTMENT SET UP JSP -------------------
	 */
	public ModelAndView showAppSetupJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map = appointmentHandlerService.showAppSetupJsp();
		map.put("deptIdinMap", session.getAttribute("deptId"));
		jsp = APPOINTMENT_SETUP_JSP;
		jsp += ".jsp";
		title = "Appointment Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getRecords(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		Box box = HMSUtil.getBox(request);
		int departmentId=box.getInt(DEPARTMENT_ID);

		HttpSession session = request.getSession();
		if (box.getInt(DEPARTMENT_ID) == 0) {
			box.put(DEPARTMENT_ID, (Integer) session.getAttribute("deptId"));
		}

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		
		map = appointmentHandlerService.getRecords(box);
		map.put("deptIdinMap", box.getInt(DEPARTMENT_ID));
		jsp = APPOINTMENT_SETUP_JSP;
		jsp += ".jsp";
		title = "Appointment Setup";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getRecordsForReception(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		Box box = HMSUtil.getBox(request);
		int departmentId=box.getInt(DEPARTMENT_ID);

		HttpSession session = request.getSession();
		if (box.getInt(DEPARTMENT_ID) == 0) {
			box.put(DEPARTMENT_ID, (Integer) session.getAttribute("deptId"));
		}

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		
		map = appointmentHandlerService.getRecords(box);
		map.put("deptIdinMap", box.getInt(DEPARTMENT_ID));
		
		jsp = "appointmentSetupForReception.jsp";
		title = "Appointment Setup";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	
	
	public ModelAndView getDoctorDetails(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> userMap = new HashMap<String, Object>();
	//	List<MasEmployee> docList =  new ArrayList<MasEmployee>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
		box.put("hospitalId", hospitalId);
		map = appointmentHandlerService.getDoctorList(box);
		
	     jsp = "responseForAppointSetupDoctorList";
//}
		map.put("jsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		
	}
	
	public ModelAndView getDoctorDetailsForReferral(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> userMap = new HashMap<String, Object>();
	//	List<MasEmployee> docList =  new ArrayList<MasEmployee>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
		box.put("hospitalId", hospitalId);
		map = appointmentHandlerService.getDoctorList(box);
		
	     jsp = "responseForReferralDoctorList";
//}
		map.put("jsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		
	}
	
	public ModelAndView getDoctorAndSessionDetails(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> userMap = new HashMap<String, Object>();
	//	List<MasEmployee> docList =  new ArrayList<MasEmployee>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
		box.put("hospitalId", hospitalId);
		map = appointmentHandlerService.getDoctorAndSessionDetails(box);
		
	     jsp = "responseForDoctorAndSessionList";
//}
		map.put("jsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		
	}
	public ModelAndView getDoctorList(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> userMap = new HashMap<String, Object>();
	//	List<MasEmployee> docList =  new ArrayList<MasEmployee>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int toWard = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
		if (request.getParameter("toWard") != null ) {
			toWard = Integer.parseInt(request.getParameter("toWard"));
			
		}
		
		if (request.getParameter("doctorIdName") != null ) {
			String doctorIdName = request.getParameter("doctorIdName");
			if (request.getParameter(doctorIdName+"toWard") != null ) 
			toWard = Integer.parseInt(request.getParameter(doctorIdName+"toWard"));
			
		}
		
		box.put("hospitalId", hospitalId);
		box.put(DEPARTMENT_ID, toWard);
		map = appointmentHandlerService.getDoctorList(box);
	/*	System.out.println("jjd"+box.getString("doctorIdName"));
		System.out.println("jdjd"+box.getString("toWardId"));*/
	     jsp = "responseOfDoctorList";
//}
	 	map.put("doctorIdName", box.getString("doctorIdName"));
		/*map.put("bedNoFieldId", box.getString("bedNoFieldId"));
			map.put("bedNoFieldId", box.getString("bedNoFieldId"));*/
			
		map.put("jsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		
	}
	
	 public void getAppDetails(HttpServletRequest request,
				HttpServletResponse response) throws IOException {
			
			Map<String, Object> map = new HashMap<String, Object>();
	
			HttpSession session=request.getSession();
			Box box = HMSUtil.getBox(request);
			int hospitalId=0;
			int userId = 0;
		
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				box.put("hospitalId", hospitalId);
			}
			
		
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt(session.getAttribute("id").toString());
				box.put("userId", userId);
			}
			
			
			List<AppSetup> appSetupList = new ArrayList<AppSetup>();
			
			map=appointmentHandlerService.getAppDetails(box);
			if(null !=map.get("setupList")){
				appSetupList=(List<AppSetup>)map.get("setupList");
			}
			StringBuffer sb = null;
			sb = new StringBuffer();
			
			String tokenStartNo1="";
	    	 String tokenInterval1="";
	    	 String totalToken1="";
	    	 String totalOnlineToken1="";
	    	 String maxNo1="";
	    	 String minNo1="";
	    	 String day="";
	    	 String timeTaken1="";
			if(null !=appSetupList && appSetupList.size()>0 ){
				for(AppSetup appSetup:appSetupList)
				{
					tokenStartNo1="";
			    	  tokenInterval1="";
			    	  totalToken1="";
			    	  totalOnlineToken1="";
			    	  maxNo1="";
			    	  minNo1="";
			    	  timeTaken1="";
		     		if(null !=appSetup.getStartToken()){
		     	 	tokenStartNo1=String.valueOf(appSetup.getStartToken());
		     		}
		     		if(null !=appSetup.getTotalInterval()){
		     			tokenInterval1=String.valueOf(appSetup.getTotalInterval());
		         		}
		     		if(null !=appSetup.getTotalToken()){
		     			totalToken1=String.valueOf(appSetup.getTotalToken());
		         		}
		     		if(null !=appSetup.getTotalOnlineToken()){
		     			totalOnlineToken1=String.valueOf(appSetup.getTotalOnlineToken());
		         		}
		     		
		     		if(null !=appSetup.getMaxNoOfDays() && appSetup.getMaxNoOfDays()>0){
		     			maxNo1=String.valueOf(appSetup.getMaxNoOfDays());
		         		}
		     		if(null !=appSetup.getMinNoOfDays() && appSetup.getMinNoOfDays()>0){
		     			minNo1=String.valueOf(appSetup.getMinNoOfDays());
		         		}
		     		if(null !=appSetup.getTimeTaken() && appSetup.getTimeTaken()>0){
		     			timeTaken1=String.valueOf(appSetup.getTimeTaken());
		         		}
		     		
		     		if(null !=appSetup.getDays() && appSetup.getDays().equalsIgnoreCase("Sunday")){
		     			day="0";
		         		}
		     		if(null !=appSetup.getDays() && appSetup.getDays().equalsIgnoreCase("Monday")){
		     			day="1";
		         		}
		     		if(null !=appSetup.getDays() && appSetup.getDays().equalsIgnoreCase("Tuesday")){
		     			day="2";
		         		}
		     		if(null !=appSetup.getDays() && appSetup.getDays().equalsIgnoreCase("Wednesday")){
		     			day="3";
		         		}
		     		if(null !=appSetup.getDays() && appSetup.getDays().equalsIgnoreCase("Thursday")){
		     			day="4";
		         		}
		     		if(null !=appSetup.getDays() && appSetup.getDays().equalsIgnoreCase("Friday")){
		     			day="5";
		         		}
		     		if(null !=appSetup.getDays() && appSetup.getDays().equalsIgnoreCase("Saturday")){
		     			day="6";
		         		}
		     	
		     		
					sb.append("<item>");
					sb.append("<appId>"+appSetup.getId() + "</appId>");
					sb.append("<day>"+day + "</day>");
					sb.append("<tokenStartNo>"+tokenStartNo1+ "</tokenStartNo>");
					sb.append("<tokenInterval>"+tokenInterval1 + "</tokenInterval>");
					sb.append("<totalToken>"+totalToken1+ "</totalToken>");
					sb.append("<totalOnlineToken>"+totalOnlineToken1+ "</totalOnlineToken>");
					sb.append("<maxDaysNo>"+maxNo1 + "</maxDaysNo>");
					sb.append("<minDaysNo>"+minNo1 + "</minDaysNo>");
					sb.append("<timeTaken>"+(appSetup.getTimeTaken()!=null?appSetup.getTimeTaken():"")+ "</timeTaken>");
					sb.append("<startTime>"+(appSetup.getStartTime()!=null?appSetup.getStartTime():"")+ "</startTime>");
					sb.append("<endTime>"+(appSetup.getEndTime()!=null?appSetup.getEndTime():"")+ "</endTime>");
					sb.append("</item>");
					 
				}
			}
			else{
				for(int i=0; i<7;i++){
				sb.append("<item>");
				
				sb.append("<appId>"+"" + "</appId>");
				sb.append("<day>"+""+ "</day>");
				sb.append("<tokenStartNo>"+""+ "</tokenStartNo>");
				sb.append("<tokenInterval>"+"" + "</tokenInterval>");
				sb.append("<totalToken>"+""+ "</totalToken>");
				sb.append("<totalOnlineToken>"+""+ "</totalOnlineToken>");
				sb.append("<maxDaysNo>"+"" + "</maxDaysNo>");
				sb.append("<minDaysNo>"+""+ "</minDaysNo>");
				sb.append("<timeTaken>"+""+ "</timeTaken>");
				sb.append("<startTime>"+""+ "</startTime>");
				sb.append("<endTime>"+""+ "</endTime>");
				sb.append("</item>");
			}
			
			}
			
			 
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	
		
		
		}	
	
	public ModelAndView submitAppointmentSetup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		String userName = "";
		int userId = 0;
		String message = null;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt(session.getAttribute("id").toString());
			box.put("userId", userId);
		}
		
		
		dataSaved = appointmentHandlerService.submitAppointmentSetup(box);
		if (dataSaved == true) {
			message = "Data Successfully Saved !!";

		} else {
			message = "Data cannot be saved !!";
		}
		
		map = appointmentHandlerService.showAppSetupJsp();
/*		map
				.put("deptIdinMap", Integer.parseInt(request
						.getParameter("wardId")));*/
		map.put("message", message);
		jsp = APPOINTMENT_SETUP_JSP;
		jsp += ".jsp";
		title = "Appointment Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateAppointmentSetup(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int hospitalId;
		String userName = "";
		int userId = 0;
		String message = null;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		if (session.getAttribute("id") != null) {
			userId = Integer.parseInt(session.getAttribute("id").toString());
			box.put("userId", userId);
		}
		
	 	dataSaved = appointmentHandlerService.updateAppointmentSetup(box);
		if (dataSaved == true) {
			message = "Data Successfully Saved!!";
			map = appointmentHandlerService.showAppSetupJsp();
		} else {
			message = "Data cannot be saved!!";
		}

	/*	map
				.put("deptIdinMap", Integer.parseInt(request
						.getParameter("wardId")));*/
		map.put("message", message);
		jsp = APPOINTMENT_SETUP_JSP;
		jsp += ".jsp";
		title = "Appointment Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ---------------------------- PATIENT APPOINTMENTS -------------------
	 */
	public ModelAndView showAppointmentPatientJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		int departmentId = 0;
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
			mapForDs.put("departmentId", departmentId);
		}
		map = appointmentHandlerService.showAppointmentPatientJsp(mapForDs);
		jsp = APPOINTMENT_PATIENTS_JSP;
		jsp += ".jsp";
		title = "Patient Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showPatientAppointmentSelectedDepartmentJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = appointmentHandlerService
				.showPatientAppointmentSelectedDepartmentJsp(box);
		jsp = RESPONSE_APPOINTMENT_DETAILS_FOR_DEPARTMENT_JSP;

		title = "Patient Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showInvestigationAppointmentSelectedDeptEquipment(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = appointmentHandlerService
				.showInvestigationAppointmentSelectedDeptEquipment(box);
		jsp = RESPONSE_APPOINTMENT_DAYS_FOR_DEPT_EQUIPMENT_JSP;

		title = "Patient Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showAppointmentPatientDepartmentWise(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = appointmentHandlerService
				.showAppointmentPatientDepartmentWise(box);
		jsp = APPOINTMENT_PATIENTS_JSP;
		jsp += ".jsp";
		title = "Patient Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showExistingPatients(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean recordExists = true;
		String message = null;
		Box box = HMSUtil.getBox(request);

		map = appointmentHandlerService.showExistingPatients(box);

		recordExists = (Boolean) map.get("recordExists");
		if (recordExists == false) {
			message = "No Data Found!!";
			map.put("message", message);
		}
		jsp = APPOINTMENT_REGISTERED_PATIENTS_JSP;
		title = "Patient Appointments";
		map.put("rowCount", box.getInt("counter"));
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showExistingPatientsForDoctors(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean recordExists = true;
		String message = null;
		Box box = HMSUtil.getBox(request);

		map = appointmentHandlerService.showExistingPatientsForDoctors(box);

		if (recordExists == false) {
			message = "No Data Found!!";
			map.put("message", message);
		}
		jsp = APPOINTMENT_REGISTERED_PATIENTS_FOR_DOCTORS_JSP;
		title = "Patient Appointments";
		map.put("rowCount", box.getInt("counter"));
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showListBasedonHinNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean hinNoExist = true;
		String message = null;
		Box box = HMSUtil.getBox(request);
		String hinNo = box.getString("hinNo");
		map = appointmentHandlerService.showListBasedonHinNo(box);

		hinNoExist = (Boolean) map.get("hinNoExist");
		int inc = box.getInt("inc");
		if (hinNoExist == false) {
			message = "No Data Found!!";
			map.put("message", message);
		}
		jsp = "appointmentPatientDetails";
		map.put("inc", inc);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitPatientAppointment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId;
		String userName = "";
		String message = null;
		String appointmentNo = null;
		String flag = "appointment";
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		int departId = 0;
		String fromTimeSlot = box.getString(FROMTIMESLOT);
		String toTimeSlot = box.getString(TOTIMESLOT);
		//System.out.println(fromTimeSlot + "-" + toTimeSlot);
		int departmentId = box.getInt(WARD_ID);
		String appointmentDate = box.get(APMT_DATE);
		String patientName = box.getString(PATIENT_NAME);
		String sex = box.getString(SEX);
		String age = box.getString(AGE);
		String ageUnit = box.getString(AGE_UNIT);
		String mobileNo = box.getString(MOBILE_NO);
		int doctorId = box.getInt(EMPLOYEE_ID);
		String serviceNo = box.getString(SERVICE_NO);
		String rank = box.get("rank");
		String servicePerson = box.getString("servicePerson");
		String hinId = box.getString(HIN_ID);

		String url = null;

		boolean dataSaved = false;
		boolean duplicateRecord = false;

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		if (session.getAttribute("deptId") != null) {
			departId = (Integer) session.getAttribute("deptId");
			mapForDs.put("departmentId", departId);
		}

		map = appointmentHandlerService.submitPatientAppointment(box);
		dataSaved = (Boolean) map.get("dataSaved");
		duplicateRecord = (Boolean) map.get("duplicateRecord");
		appointmentNo = (String) map.get("appointmentNo");
		boolean patientNameExist = (Boolean) map.get("patientNameExist");
		boolean recordExists = (Boolean) map.get("recordExists");
		String existingDept = (String) map.get("existingDept");
		String existingStartTime = (String) map.get("existingStartTime");
		String existingEndTime = (String) map.get("existingEndTime");
		if (dataSaved == true) {
			message = "Your Appointment No. is " + appointmentNo;
			url = "submitForm('message','appointment?method=showAppointmentPatientJsp');";
			map.put("url", url);
			map.put("message", message);
			jsp = APPOINTMENT_MESSAGE_JSP;

		} else if (duplicateRecord == true) {

			message = "Already taken Appointment!!";
			map = appointmentHandlerService.showAppointmentPatientJsp(mapForDs);
			map.put("message", message);
			jsp = APPOINTMENT_PATIENTS_JSP;
		} else {
			if (patientNameExist == false && recordExists == false) {
				message = "Data cannot be saved !!";
			}

			map = appointmentHandlerService.showAppointmentPatientJsp(mapForDs);
			map.put("fromTimeSlot", fromTimeSlot);
			map.put("toTimeSlot", toTimeSlot);
			map.put("departmentId", departmentId);
			map.put("appointmentDate", appointmentDate);
			map.put("patientName", patientName);
			map.put("sex", sex);
			map.put("age", age);
			map.put("ageUnit", ageUnit);
			map.put("mobileNo", mobileNo);
			map.put("doctorId", doctorId);
			map.put("serviceNo", serviceNo);
			map.put("rank", rank);
			map.put("hinId", hinId);
			map.put("servicePerson", servicePerson);
			map.put("existingDept", existingDept);
			map.put("existingStartTime", existingStartTime);
			map.put("existingEndTime", existingEndTime);

			map.put("message", message);
			jsp = APPOINTMENT_PATIENTS_JSP;
		}
		// -----------------------Vishal Code Start----------
		map.put("flag", flag);
		map.put("appointmentNo", appointmentNo);
		// -----------------------Vishal Code End----------

		jsp += ".jsp";
		title = "Appointment Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("patientNameExist", patientNameExist);
		map.put("recordExists", recordExists);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitDulicatePatientNameAppointment(
			HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("In controller");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId;
		String userName = "";
		String message = null;
		String appointmentNo = null;
		String flag = "appointment";
		String url = null;
		int departId = 0;
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		boolean dataSaved = false;

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		if (session.getAttribute("deptId") != null) {
			departId = (Integer) session.getAttribute("deptId");
			mapForDs.put("departmentId", departId);
		}

		map = appointmentHandlerService
				.submitDulicatePatientNameAppointment(box);
		if (map.get("dataSaved") != null) {
			dataSaved = (Boolean) map.get("dataSaved");
		}
		appointmentNo = (String) map.get("appointmentNo");

		if (dataSaved == true) {
			message = "Your Appointment No. is " + appointmentNo;
			url = "submitForm('message','appointment?method=showAppointmentPatientJsp');";
			map.put("url", url);
			map.put("message", message);
			jsp = APPOINTMENT_MESSAGE_JSP;

		} else {
			message = "Data cannot be saved !!";
			map = appointmentHandlerService.showAppointmentPatientJsp(mapForDs);
			map.put("message", message);
			jsp = APPOINTMENT_PATIENTS_JSP;
		}

		jsp += ".jsp";
		title = "Appointment Setup";
		map.put("contentJsp", jsp);
		map.put("flag", flag);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ---------------------------- INVESTIGATION SET UP JSP -------------------
	 */
	public ModelAndView showAppointmentInvestigationSetupJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = appointmentHandlerService.showAppointmentInvestigationSetupJsp();
		jsp = APPOINTMENT_INVESTIGATION_SETUP_JSP;
		jsp += ".jsp";
		title = "Appointment Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ------------- get list of investigation equipments through ajax
	 * ---------------
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getInvestigationList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// map=appointmentHandlerService.getInvestigationList();
		jsp = RESPONSE_FOR_INVESTIGATION_EQUIPMENT_JSP;
		jsp += ".jsp";
		title = "Appointment Investigation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAppointmentInvestigationSetupDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		map = appointmentHandlerService
				.showAppointmentInvestigationSetupDetails(box);
		jsp = APPOINTMENT_INVESTIGATION_SETUP_JSP;
		jsp += ".jsp";
		title = "Appointment Setup";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitAppointmentInvestigationSetup(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		String userName = "";
		String message = null;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}

		dataSaved = appointmentHandlerService
				.submitAppointmentInvestigationSetup(box);
		if (dataSaved == true) {
			message = "Data Successfully Saved !!";

		} else {
			message = "Data cannot be saved !!";
		}
		map = appointmentHandlerService.showAppointmentInvestigationSetupJsp();
		map.put("message", message);
		jsp = APPOINTMENT_INVESTIGATION_SETUP_JSP;
		jsp += ".jsp";
		title = "Appointment Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateAppointmentInvestigationSetup(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		String userName = "";
		String message = null;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}

		dataSaved = appointmentHandlerService
				.updateAppointmentInvestigationSetup(box);
		if (dataSaved == true) {
			message = "Data Successfully Saved !!";
			map = appointmentHandlerService
					.showAppointmentInvestigationSetupJsp();
		} else {
			message = "Data cannot be saved !!";
		}
		map.put("message", message);
		jsp = APPOINTMENT_INVESTIGATION_SETUP_JSP;
		jsp += ".jsp";
		title = "Investigation Appointment Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ----------------------------------- APPOINTMENT INVSTIGATION
	 * ---------------------------------- started on 26th Aug 2008 Author :
	 * Priyanka Garg
	 */
	public ModelAndView showAppointmentInvestigationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = appointmentHandlerService.showAppointmentInvestigationJsp();
		jsp = APPOINTMENT_INVESTIGATION_JSP;
		jsp += ".jsp";
		title = "Investigation Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAppointmentInvestigationWise(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = appointmentHandlerService.showAppointmentInvestigationWise(box);
		jsp = APPOINTMENT_INVESTIGATION_JSP;
		jsp += ".jsp";
		title = "Patient Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitInvestigationAppointment(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		String userName = "";
		String message = null;
		String appointmentNo = null;
		String flag = "investigation";
		StringBuffer stf = new StringBuffer();
		String newLine = System.getProperties().getProperty("line.separator");
		Box box = HMSUtil.getBox(request);

		String fromTimeSlot = box.getString(FROMTIMESLOT);
		String toTimeSlot = box.getString(TOTIMESLOT);
		int departmentId = box.getInt(WARD_ID);
		int equipId = box.getInt(EQUIP_ID);
		String appointmentDate = box.get(APMT_DATE);
		String patientName = box.getString(PATIENT_NAME);
		String sex = box.getString(SEX);
		String age = box.getString(AGE);
		String ageUnit = box.getString(AGE_UNIT);
		String mobileNo = box.getString(MOBILE_NO);
		int doctorId = box.getInt(EMPLOYEE_ID);
		String serviceNo = box.getString(SERVICE_NO);
		String servicePerson = box.getString("servicePerson");
		String hinId = box.getString(HIN_ID);
		String patientType = box.getString(PATIENT_TYPE);

		String url = null;

		boolean dataSaved = false;
		boolean duplicateRecord = false;

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}

		map = appointmentHandlerService.submitInvestigationAppointment(box);
		dataSaved = (Boolean) map.get("dataSaved");
		duplicateRecord = (Boolean) map.get("duplicateRecord");
		appointmentNo = (String) map.get("appointmentNo");
		boolean patientNameExist = (Boolean) map.get("patientNameExist");
		boolean recordExists = (Boolean) map.get("recordExists");
		String existingDept = (String) map.get("existingDept");
		String existingStartTime = (String) map.get("existingStartTime");
		String existingEndTime = (String) map.get("existingEndTime");

		if (dataSaved == true) {
			message = "Your Investigation Appointment No. is " + appointmentNo;
			url = "submitForm('message','appointment?method=showAppointmentInvestigationJsp');";
			map.put("url", url);
			map.put("message", message);
			jsp = APPOINTMENT_MESSAGE_JSP;

		}

		else if (duplicateRecord == true) {
			message = "Already taken Appointment!!";
			map = appointmentHandlerService.showAppointmentInvestigationJsp();
			map.put("message", message);
			jsp = APPOINTMENT_INVESTIGATION_JSP;
		} else {
			if (patientNameExist == false && recordExists == false) {
				message = "Data cannot be saved !!";
			}

			map = appointmentHandlerService.showAppointmentInvestigationJsp();
			map.put("fromTimeSlot", fromTimeSlot);
			map.put("toTimeSlot", toTimeSlot);
			map.put("departmentId", departmentId);
			map.put("equipId", equipId);
			map.put("appointmentDate", appointmentDate);
			map.put("patientName", patientName);
			map.put("sex", sex);
			map.put("age", age);
			map.put("ageUnit", ageUnit);
			map.put("mobileNo", mobileNo);
			map.put("doctorId", doctorId);
			map.put("serviceNo", serviceNo);
			map.put("hinId", hinId);
			map.put("patientType", patientType);
			map.put("servicePerson", servicePerson);
			map.put("existingDept", existingDept);
			map.put("existingStartTime", existingStartTime);
			map.put("existingEndTime", existingEndTime);

			map.put("message", message);
			jsp = APPOINTMENT_INVESTIGATION_JSP;
		}
		// -----------------------Vishal Code Start----------
		map.put("flag", flag);
		map.put("appointmentNo", appointmentNo);
		// -----------------------Vishal Code End----------

		jsp += ".jsp";
		title = "Investigation Appointment";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("patientNameExist", patientNameExist);
		map.put("recordExists", recordExists);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitDulicatePatientNameInvAppointment(
			HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("In controller");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId;
		String userName = "";
		String message = null;
		String appointmentNo = null;

		String url = null;

		boolean dataSaved = false;

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}

		map = appointmentHandlerService
				.submitDulicatePatientNameInvAppointment(box);
		if (map.get("dataSaved") != null) {
			dataSaved = (Boolean) map.get("dataSaved");
		}
		appointmentNo = (String) map.get("appointmentNo");

		if (dataSaved == true) {
			message = "Your Appointment No. is " + appointmentNo;
			url = "submitForm('message','appointment?method=showAppointmentInvestigationJsp');";
			map.put("url", url);
			map.put("message", message);
			jsp = APPOINTMENT_MESSAGE_JSP;

		} else {
			message = "Data cannot be saved !!";
			map = appointmentHandlerService.showAppointmentInvestigationJsp();
			map.put("message", message);
			jsp = APPOINTMENT_INVESTIGATION_JSP;
		}

		jsp += ".jsp";
		title = "Appointment Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ----------------------------------- CANCELLATION FOR PATIENT AAPOINTMENTS
	 * ---------------------------------- started on 1st Sept 2008 Author :
	 * Priyanka Garg
	 */
	public ModelAndView showAppointmentPatientCancellationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = appointmentHandlerService.showAppointmentPatientCancellationJsp();
		jsp = APPOINTMENT_PATIENT_CANCELLATION_JSP;
		jsp += ".jsp";
		title = "Cancel for Patient Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView patientAppointmentList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		String userName = "";
		String jsp = "";
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		map = appointmentHandlerService.patientAppointmentList(box);
		jsp = APPOINTMENT_PATIENT_CANCELLATION_JSP;
		jsp += ".jsp";
		title = "Cancel for Patient Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitCancelPatientAppointment(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		String userName = "";
		String message = null;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}

		dataSaved = appointmentHandlerService
				.submitCancelPatientAppointment(box);
		if (dataSaved == true) {
			message = "Data Successfully Saved !!";
		} else {
			message = "Data cannot be saved !!";
		}
		map = appointmentHandlerService.showAppointmentPatientCancellationJsp();
		map.put("message", message);
		jsp = APPOINTMENT_PATIENT_CANCELLATION_JSP;
		jsp += ".jsp";
		title = "Cancel for Patient Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ----------------------------------- CANCELLATION FOR INVESTIGATION
	 * APOINTMENTS ---------------------------------- started on 4st Sept 2008
	 * Author : Priyanka Garg
	 */
	public ModelAndView showAppointmentInvestigationCancellationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = appointmentHandlerService
				.showAppointmentInvestigationCancellationJsp();
		jsp = APPOINTMENT_INVESTIGATION_CANCELLATION_JSP;
		jsp += ".jsp";
		title = "Cancel for Investigation Appointment";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView investigationAppointmentList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		String userName = "";
		String jsp = "";
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		map = appointmentHandlerService.investigationAppointmentList(box);
		jsp = APPOINTMENT_INVESTIGATION_CANCELLATION_JSP;
		jsp += ".jsp";
		title = "Cancel for Investigation Appointment";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitCancelInvestigationAppointment(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		String userName = "";
		String message = null;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}

		dataSaved = appointmentHandlerService
				.submitCancelInvestigationAppointment(box);
		if (dataSaved == true) {
			message = "Data Successfully Saved !!";
		} else {
			message = "Data cannot be saved !!";
		}
		map = appointmentHandlerService.showAppointmentPatientCancellationJsp();
		map.put("message", message);
		jsp = APPOINTMENT_INVESTIGATION_CANCELLATION_JSP;
		jsp += ".jsp";
		title = "Cancel for Investigation Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ------------------ uploading documents JSP-----------------
	 */
	public ModelAndView showUploadingDocumentsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "upload_documents" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitUploadDocuments(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		MultipartFormDataRequest mrequest = null;

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Map<String, Object> uploadFileMap = new HashMap<String, Object>();

		String uploadURL = getServletContext().getRealPath("/upload/");

		String whiteList = "*.jpg";

		// Long fileSizeLimit = 2097152l;

		List fileUploadedList = null;
		fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL, whiteList,
				box.getString("filename"));
		Boolean fileUploaded = false;
		if (fileUploadedList != null && fileUploadedList.size() != 0) {
			fileUploaded = (Boolean) fileUploadedList.get(0);
		}
		box.put("uploadURL", uploadURL);
		box.put("filename", box.getString("filename"));
		map = appointmentHandlerService.submitUploadDocuments(box);
		jsp = "upload_documents";
		jsp += ".jsp";
		title = "Import CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView viewUploadDocuments(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		MultipartFormDataRequest mrequest = null;

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Map<String, Object> uploadFileMap = new HashMap<String, Object>();

		String uploadURL = getServletContext().getRealPath("/upload/");

		box.put("uploadURL", uploadURL);

		box.put("filename", box.getString("filename"));
		map = appointmentHandlerService.viewUploadDocuments(box);
		try {
			response.setContentType("image/jpg");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ box.getString("filename") + ".jpg");

			File f = new File(uploadURL + "/" + box.getString("filename")
					+ ".jpg");
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

		jsp = "upload_documents";
		jsp += ".jsp";
		title = "Import CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ---------------------------- Start code for Report by Vishal
	 * -------------------
	 */
	// ---------------------------Print Appointment
	// Setup---------------------------------------------
	public ModelAndView printAppointmentSetupJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int departmentId = 0;
		String period = null;
		String query = "";

		try {
			if (request.getParameter(DEPT_ID) != null
					&& !(request.getParameter(DEPT_ID).equals("0"))) {
				departmentId = Integer.parseInt(""
						+ request.getParameter(DEPT_ID));
				query = "where app_setup.`dept_id` = " + departmentId;
			}
			requestParameters.put("QUERY", query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = appointmentHandlerService
				.getConnectionForReport();
		byte[] bytes = null;

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(APP_APP_SETUP), requestParameters,
					(Connection) connectionMap.get("con"));
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ APP_APP_SETUP + ".pdf");
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

		return new ModelAndView("index", "map", map);
	}

	// -------------------Print Investigation
	// Setup-----------------------------------
	public ModelAndView printInvestigationSetupJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int departmentId = 0;
		int equipmentId = 0;
		String period = null;
		String query = "";

		try {
			if (request.getParameter(DEPT_ID) != null
					&& !(request.getParameter(DEPT_ID).equals("0"))
					&& request.getParameter(EQUIP_ID) != null
					&& !(request.getParameter(EQUIP_ID).equals("0"))) {
				departmentId = Integer.parseInt(""
						+ request.getParameter(DEPT_ID));
				equipmentId = Integer.parseInt(""
						+ request.getParameter(EQUIP_ID));
				query = "where app_investigation_setup.`department_id` = "
						+ departmentId
						+ " and app_investigation_setup.`equipment_id` = "
						+ equipmentId;
			}
			if (request.getParameter(DEPT_ID) == null
					&& request.getParameter(DEPT_ID).equals("0")
					&& request.getParameter(EQUIP_ID) != null
					&& !(request.getParameter(EQUIP_ID).equals("0"))) {
				equipmentId = Integer.parseInt(""
						+ request.getParameter(EQUIP_ID));
				query = "where app_investigation_setup.`equipment_id` = "
						+ equipmentId;
			}

			if (request.getParameter(DEPT_ID) != null
					&& !(request.getParameter(DEPT_ID).equals("0"))
					&& request.getParameter(EQUIP_ID) == null
					&& request.getParameter(EQUIP_ID).equals("0")) {
				departmentId = Integer.parseInt(""
						+ request.getParameter(DEPT_ID));
				query = "where app_investigation_setup.`department_id` = "
						+ departmentId;
			}

			requestParameters.put("QUERY", query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = appointmentHandlerService
				.getConnectionForReport();
		byte[] bytes = null;

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(APP_INVEST_SETUP), requestParameters,
					(Connection) connectionMap.get("con"));
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ APP_INVEST_SETUP + ".pdf");
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

		return new ModelAndView("index", "map", map);
	}

	// -------------Jasper Compiled Report
	// --------------------------------------
	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());

		return jasperReport;
	}

	// ----------------Print OPD Appointment List-------------------------
	public ModelAndView showOPDAppointmentListReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = appointmentHandlerService.getEmployeeDepartmentCategory();

		jsp = APPOINTMENT_LIST_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateOPDAppointmentReport(
			HttpServletRequest request, HttpServletResponse response) {

		String fromDate = null;
		String toDate = null;
		int department = 0;
		int doctor = 0;
		int status = 0;
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> parameters = new HashMap<String, Object>();

		try {
			if (request.getParameter(VALID_FROM_DATE) != null
					&& !(request.getParameter(VALID_FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(VALID_FROM_DATE)));
				parameters.put("fromDate", HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(VALID_FROM_DATE)));
			}
			if (request.getParameter(VALID_TO_DATE) != null
					&& !(request.getParameter(VALID_TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(VALID_TO_DATE)));
				parameters.put("toDate", HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(VALID_TO_DATE)));
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				department = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				query = " where app_patient_appointments.appointment_date between '"
						+ fromDate
						+ "' and '"
						+ toDate
						+ "'and app_patient_appointments.`department_id` = "
						+ department;
			} else {
				query = " where app_patient_appointments.appointment_date between '"
						+ fromDate + "' and '" + toDate + "'";
			}
			if (request.getParameter(EMPLOYEE_ID) != null
					&& !(request.getParameter(EMPLOYEE_ID).equals("0"))) {
				doctor = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
				query = query + " and app_patient_appointments.employee_id = "
						+ doctor;
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals("0"))) {
				status = Integer.parseInt(request.getParameter(SELECTED_RADIO));
				if (status == 1) {
					query = query
							+ " and app_patient_appointments.appointment_status = 'v'";
				} else if (status == 2) {
					query = query
							+ " and app_patient_appointments.appointment_status = 'y'";
				} else if (status == 3) {
					query = query
							+ " and app_patient_appointments.appointment_status != 'c'";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = appointmentHandlerService.getConnectionForReport();

		parameters.put("QUERY", query);
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("app_patient_list_common"),
						parameters, (Connection) detailsMap.get("con"));

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
		return null;
	}

	// ----------------Print OPD Investigation List-------------------------

	public ModelAndView showOPDInvestigationListReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = appointmentHandlerService.getEquipmentDepartmentCategory();
		jsp = INVESTIGATION_LIST_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateOPDInvestigationReport(
			HttpServletRequest request, HttpServletResponse response) {

		String fromDate = null;
		String toDate = null;
		int department = 0;
		int equipment = 0;
		String query = "";
		int status = 0;
		int wardId = 0;
		Map<String, Object> parameters = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			if (request.getParameter(VALID_FROM_DATE) != null
					&& !(request.getParameter(VALID_FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(VALID_FROM_DATE)));
				parameters.put("fromDate", HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(VALID_FROM_DATE)));
			}

			if (request.getParameter(VALID_TO_DATE) != null
					&& !(request.getParameter(VALID_TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(VALID_TO_DATE)));
				parameters.put("toDate", HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(VALID_TO_DATE)));
			}

			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				department = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				query = " where app_investigation_appointments.`investigation_date` between '"
						+ fromDate
						+ "' and '"
						+ toDate
						+ "'and app_investigation_appointments.`department_id` = "
						+ department;
			} else {
				query = " where app_investigation_appointments.`investigation_date` between '"
						+ fromDate + "' and '" + toDate + "'";
			}
			if (request.getParameter(WARD_ID) != null
					&& !(request.getParameter(WARD_ID).equals(""))
					&& !(request.getParameter(WARD_ID).equals("0"))) {
				wardId = Integer.parseInt(request.getParameter(WARD_ID));
				query = query + " and inpatient.department_id= " + wardId;
			}
			if (request.getParameter(EQUIPMENT_ID) != null
					&& !(request.getParameter(EQUIPMENT_ID).equals("0"))) {
				equipment = Integer
						.parseInt(request.getParameter(EQUIPMENT_ID));
				query = query
						+ " and app_investigation_appointments.equipment_id = "
						+ equipment;
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals("0"))) {
				status = Integer.parseInt(request.getParameter(SELECTED_RADIO));
				if (status == 1) {
					query = query
							+ " and app_investigation_appointments.`investigation_status` = 'v'";
				} else if (status == 2) {
					query = query
							+ " and app_investigation_appointments.`investigation_status` = 'y'";
				} else if (status == 3) {
					query = query
							+ " and app_investigation_appointments.`investigation_status` != 'c'";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = appointmentHandlerService.getConnectionForReport();

		parameters.put("QUERY", query);
		//System.out.println("Query :" + query);
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport(INVESTIGATION_PATIENT_LIST),
						parameters, (Connection) detailsMap.get("con"));

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
		return null;
	}

	// ---------------------------report for Appointment
	// Cancellation------------------------------------

	public ModelAndView showOPDAppointmentCancellationReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = appointmentHandlerService.getEmployeeDepartmentCategory();

		jsp = APPOINTMENT_CANCELLATION_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateOPDAppointmentCancellationReport(
			HttpServletRequest request, HttpServletResponse response) {

		String fromDate = null;
		String toDate = null;
		int department = 0;
		int doctor = 0;
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			if (request.getParameter(VALID_FROM_DATE) != null
					&& !(request.getParameter(VALID_FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(VALID_FROM_DATE)));
			}
			if (request.getParameter(VALID_TO_DATE) != null
					&& !(request.getParameter(VALID_TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(VALID_TO_DATE)));
			}
			query = " where app_patient_appointments.`appointment_cancel_date` between '"
					+ fromDate
					+ "' and '"
					+ toDate
					+ "' and app_patient_appointments.`appointment_status` = 'c' ";
			/*
			 * if(request.getParameter(REPORT_TYPE).equals("appointment")){
			 * query =
			 * " where app_patient_appointments.appointment_date between '"+
			 * fromDate +"' and '"
			 * +toDate+"'and app_patient_appointments.`appointment_status` = 'c' "
			 * ; } if(request.getParameter(REPORT_TYPE).equals("cancellation")){
			 * query =
			 * " where app_patient_appointments.`appointment_cancel_date` between '"
			 * + fromDate +"' and '"
			 * +toDate+"' and app_patient_appointments.`appointment_status` = 'c' "
			 * ; }
			 */
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				department = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				query = query + " AND  mas_department.`department_id` = "
						+ department;
			}
			if (request.getParameter(EMPLOYEE_ID) != null
					&& !(request.getParameter(EMPLOYEE_ID).equals("0"))) {
				doctor = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
				query = query + " AND mas_employee.`employee_id` = " + doctor;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = appointmentHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("QUERY", query);

		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager
						.runReportToPdf(
								getCompiledReport(APPOINTMENT_PATIENT_CANCELLATION_LIST),
								parameters, (Connection) detailsMap.get("con"));

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
		return null;
	}

	// ------------------------Report for Investigation
	// Cancellation------------------------------------------

	public ModelAndView showOPDInvestigationCancellationReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = appointmentHandlerService.getEquipmentDepartmentCategory();
		jsp = APPOINTMENT_INVESTIGATION_CANCELLATION_LIST + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateOPDInvestigationCancellationReport(
			HttpServletRequest request, HttpServletResponse response) {

		String fromDate = null;
		String toDate = null;
		int department = 0;
		int employee = 0;
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			if (request.getParameter(VALID_FROM_DATE) != null
					&& !(request.getParameter(VALID_FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(VALID_FROM_DATE)));
			}
			if (request.getParameter(VALID_TO_DATE) != null
					&& !(request.getParameter(VALID_TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(VALID_TO_DATE)));
			}

			query = " where app_investigation_appointments.investigation_cancel_date between '"
					+ fromDate
					+ "' and '"
					+ toDate
					+ "'and app_investigation_appointments.`investigation_status` = 'c' ";

			/*
			 * if(request.getParameter(REPORT_TYPE).equals("appointment")){
			 * query =
			 * " where app_investigation_appointments.investigation_date between '"
			 * + fromDate +"' and '"+toDate+
			 * "'and app_investigation_appointments.`investigation_status` = 'c' "
			 * ; } if(request.getParameter(REPORT_TYPE).equals("cancellation")){
			 * query =
			 * " where app_investigation_appointments.investigation_cancel_date between '"
			 * + fromDate +"' and '"+toDate+
			 * "'and app_investigation_appointments.`investigation_status` = 'c' "
			 * ; }
			 */

			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				department = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				query = query + " AND  mas_department.`department_id` = "
						+ department;
			}
			if (request.getParameter(EQUIPMENT_ID) != null
					&& !(request.getParameter(EQUIPMENT_ID).equals("0"))) {
				employee = Integer.parseInt(request.getParameter(EQUIPMENT_ID));
				query = query + " AND app_equipment_master.`equipment_id` = "
						+ employee;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = appointmentHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("QUERY", query);

		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager
						.runReportToPdf(
								getCompiledReport(APP_INVESTIGATION_CANCELLATION_LIST_REP),
								parameters, (Connection) detailsMap.get("con"));

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
		return null;
	}

	// ----------------Print OPD Appointment Setup Day Wise
	// List-------------------------
	public ModelAndView showAppointmentSetupDayWiseReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = appointmentHandlerService.getEmployeeDepartmentCategory();
		jsp = APP_SETUP_DAY_WISE_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateAppointmentSetupDayWiseReport(
			HttpServletRequest request, HttpServletResponse response) {

		int department = 0;
		String day = "";
		String query = "";
		int status = 0;
		try {
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals("0"))) {
				status = Integer.parseInt(request.getParameter(SELECTED_RADIO));
				if (status == 1) {
					if (request.getParameter(DAY) != null
							&& !(request.getParameter(DAY).equals(""))) {
						day = (request.getParameter(DAY));
						query = query + "and app_setup.days = '" + day + "'";
					}
				} else if (status == 2) {
					if (request.getParameter(DEPT_ID) != null
							&& !(request.getParameter(DEPT_ID).equals(""))) {
						department = Integer.parseInt((request
								.getParameter(DEPT_ID)));
						query = query
								+ " where mas_department.department_id = '"
								+ department + "'";
					}
					if (request.getParameter(DAY) != null
							&& !(request.getParameter(DAY).equals(""))) {
						day = (request.getParameter(DAY));
						query = query + "and app_setup.days = '" + day + "'";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = appointmentHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("QUERY", query);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));

		try {
			byte[] bytes = null;
			try {
				if (status == 1) {
					bytes = JasperRunManager.runReportToPdf(
							getCompiledReport(APP_SETUP_ALL), parameters,
							(Connection) detailsMap.get("con"));
				} else {
					bytes = JasperRunManager.runReportToPdf(
							getCompiledReport(APP_SETUP_DAY_WISE_REP),
							parameters, (Connection) detailsMap.get("con"));
				}

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
		return null;
	}

	// ----------------Print OPD Appointment Investigation Setup Day Wise
	// List-------------------------
	public ModelAndView showAppointmentInvestigationSetupDayWiseReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = appointmentHandlerService.getEmployeeDepartmentCategory();
		jsp = APP_INVEST_SETUP_DAY_WISE_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateAppointmentInvestigationSetupDayWiseReport(
			HttpServletRequest request, HttpServletResponse response) {

		int department = 0;
		String day = "";
		String query = "";

		try {

			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				department = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				query = "where app_investigation_setup.`department_id` = "
						+ department;
			}
			if (request.getParameter(DAY) != null
					&& !(request.getParameter(DAY).equals(""))) {
				day = (request.getParameter(DAY));
				query = query + " and app_investigation_setup.`days` = '" + day
						+ "'";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = appointmentHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();

		try {
			byte[] bytes = null;
			try {
				/*
				 * if(day.equals("") && department != 0) {
				 * parameters.put("QUERY","query"); bytes =
				 * JasperRunManager.runReportToPdf
				 * (getCompiledReport(APP_INVEST_SETUP_DAY_WISE_REP
				 * ),parameters,(Connection)detailsMap.get("con")); } else {
				 */
				parameters.put("QUERY", query);

				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport(APP_INVEST_SETUP_DAY_WISE_REP),
						parameters, (Connection) detailsMap.get("con"));

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
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------Print Appointment slip
	// ------------------------------------------
	public ModelAndView printAppointmentSlip(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String appointmentNo = null;
		String query = "";
		try {
			if (request.getParameter("appointmentNo") != null
					&& !(request.getParameter("appointmentNo").equals(""))) {
				appointmentNo = (request.getParameter("appointmentNo"));
				query = "where app_patient_appointments.`appointment_no` = '"
						+ appointmentNo + "'";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = appointmentHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("QUERY", query);
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport(APPOINTMENT_SLIP), parameters,
						(Connection) detailsMap.get("con"));

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
		return null;
	}

	// ---------------------------Print Appointment Investigation slip
	// ------------------------------------------
	public ModelAndView printAppointmentInvestigationSlip(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String appointmentNo = null;
		String query = "";
		try {
			if (request.getParameter("appointmentNo") != null
					&& !(request.getParameter("appointmentNo").equals(""))) {
				appointmentNo = (request.getParameter("appointmentNo"));
				query = "where app_investigation_appointments.`investigation_appointment_no` = '"
						+ appointmentNo + "'";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = appointmentHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("QUERY", query);
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport(APPOINTMENT_INV_SLIP), parameters,
						(Connection) detailsMap.get("con"));

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
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ----------------------------------------------- END OF CLASS
	 * -------------------------------------
	 */

	// ------Appointment Block by Dipali
	public ModelAndView showAppBlockJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = appointmentHandlerService.showAppBlockJsp();
		jsp = APP_BLOCK;
		jsp += ".jsp";
		title = "Appointment Block";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitAppointmentBlock(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		session = request.getSession();
		String userName = (String) session.getAttribute("userName");

		boolean dataSaved = false;

		int departmentId = -1;
		String date = "";
		String time = "";
		String blockFromDate = "";
		String blockToDate = "";
		String message = null;
		String confirmMessage = "";
		String reason = "";

		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		String cancelAppointment = request.getParameter("cancelAppointment");
		if (cancelAppointment == null) {
			AppBlock appBlock = new AppBlock();
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			appBlock.setHospital(masHospital);

			if (request.getParameter(DEPARTMENT_ID) != null
					&& !request.getParameter(DEPARTMENT_ID).equals("0")) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				appBlock.setDepartment(masDepartment);
			}
			if (request.getParameter(BLOCK_FROM_DATE) != null
					&& !(request.getParameter(BLOCK_FROM_DATE).equals(""))) {
				blockFromDate = request.getParameter(BLOCK_FROM_DATE);
				appBlock.setBlockFromDate(HMSUtil
						.convertStringTypeDateToDateType(blockFromDate));
			}

			if (request.getParameter(BLOCK_TO_DATE) != null
					&& !(request.getParameter(BLOCK_TO_DATE).equals(""))) {
				blockToDate = request.getParameter(BLOCK_TO_DATE);
				appBlock.setBlockToDate(HMSUtil
						.convertStringTypeDateToDateType(blockToDate));
			}

			if (request.getParameter(REASON) != null
					&& request.getParameter(REASON) != "") {
				reason = request.getParameter(REASON);
				appBlock.setReason(reason);
				appBlock.setLastChgBy(userName);
				appBlock.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(date));
				appBlock.setLastChgTime(time);
			}
			List patientAppointments = appointmentHandlerService
					.getPatientAppointments(
							request.getParameter(DEPARTMENT_ID), blockFromDate,
							blockToDate);
			if (patientAppointments.size() > 0) {
				request.getSession().setAttribute("appBlock", appBlock);
				request.getSession().setAttribute("patientBlockAppointments",
						patientAppointments);
				confirmMessage = "Patient appointments are present on these date(s). cancel all appointments ?";
				request.setAttribute("confirmMessage", confirmMessage);
			} else {
				dataSaved = appointmentHandlerService
						.submitAppointmentBlock(appBlock);
			}
			if (dataSaved) {
				message = "Data Successfully Saved !!";
			} else {
				message = "Data cannot be saved !!";
			}

		} else {
			if (cancelAppointment.equalsIgnoreCase("yes")) {
				AppBlock appBlock = (AppBlock) request.getSession()
						.getAttribute("appBlock");
				// cancel all appointments and save block data
				List patientAppointments = (List) request.getSession()
						.getAttribute("patientBlockAppointments");
				//System.out.println("patientAppointments:"+ patientAppointments.size());
				appointmentHandlerService
						.cancelAppointmentBlock(patientAppointments);
				dataSaved = appointmentHandlerService
						.submitAppointmentBlock(appBlock);
			}
			if (dataSaved) {
				message = "Data Successfully Saved !!";
			} else {
				message = "Data cannot be saved !!";
			}
		}

		try {
			map = appointmentHandlerService.showAppBlockJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = APP_BLOCK;
		jsp += ".jsp";
		title = "Appointment block";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

public ModelAndView updateAppointmentBlock(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	HttpSession session = request.getSession();
	session = request.getSession();
	String userName = (String) session.getAttribute("userName");

	boolean dataSaved = false;

	int departmentId = -1;
	int appointmentBlockId = 0;
	String date = "";
	String time = "";
	String blockFromDate = "";
	String blockToDate = "";
	String message = null;
	String confirmMessage = "";
	String reason = "";

	date = (String) utilMap.get("currentDate");
	time = (String) utilMap.get("currentTime");

	String cancelAppointment = request.getParameter("cancelAppointment");
	if (cancelAppointment == null) {
		AppBlock appBlock = new AppBlock();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		appBlock.setHospital(masHospital);
		
		if (request.getParameter(APP_BLOCK_ID) != null	&& !request.getParameter(APP_BLOCK_ID).equals("0")) {
			appointmentBlockId = Integer.parseInt(request.getParameter(APP_BLOCK_ID));
			appBlock.setId(appointmentBlockId);
		}
		
		if (request.getParameter(DEPARTMENT_ID) != null&& !request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			appBlock.setDepartment(masDepartment);
		}
		if (request.getParameter(BLOCK_FROM_DATE) != null && !(request.getParameter(BLOCK_FROM_DATE).equals(""))) {
			blockFromDate = request.getParameter(BLOCK_FROM_DATE);
			appBlock.setBlockFromDate(HMSUtil.convertStringTypeDateToDateType(blockFromDate));
		}

		if (request.getParameter(BLOCK_TO_DATE) != null	&& !(request.getParameter(BLOCK_TO_DATE).equals(""))) {
			blockToDate = request.getParameter(BLOCK_TO_DATE);
			appBlock.setBlockToDate(HMSUtil.convertStringTypeDateToDateType(blockToDate));
		}

		if (request.getParameter(REASON) != null && request.getParameter(REASON) != "") {
			reason = request.getParameter(REASON);
			appBlock.setReason(reason);
			appBlock.setLastChgBy(userName);
			appBlock.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			appBlock.setLastChgTime(time);
		}
		List patientAppointments = appointmentHandlerService.getPatientAppointments(
						request.getParameter(DEPARTMENT_ID),
						blockFromDate,
						blockToDate);
		if (patientAppointments.size() > 0) {
			request.getSession().setAttribute("appBlock", appBlock);
			request.getSession().setAttribute("patientBlockAppointments",patientAppointments);
			confirmMessage = "Patient appointments are present on these date(s). cancel all appointments ?";
			request.setAttribute("confirmMessage", confirmMessage);
			request.setAttribute("confirmMessageUpdate","confirmMessageUpdate" );
		} else {
			dataSaved = appointmentHandlerService.updateAppointmentBlock(appBlock);
		}
		if (dataSaved) {
			message = "Data Successfully updated !!";
		} else {
			message = "Data cannot be updated !!";
		}

	} else {
		if (cancelAppointment.equalsIgnoreCase("yes")) {
			AppBlock appBlock = (AppBlock) request.getSession().getAttribute("appBlock");
			// cancel all appointments and save block data
			List patientAppointments = (List) request.getSession().getAttribute("patientBlockAppointments");
			appointmentHandlerService.cancelAppointmentBlock(patientAppointments);
			dataSaved = appointmentHandlerService.updateAppointmentBlock(appBlock);
		}
		if (dataSaved) {
			message = "Data Successfully updated !!";
		} else {
			message = "Data cannot be updated !!";
		}
	}

	try {
		map = appointmentHandlerService.showAppBlockJsp();

	} catch (Exception e) {
		e.printStackTrace();
	}
	jsp = APP_BLOCK;
	jsp += ".jsp";
	title = "Appointment block";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}

public ModelAndView deleteAppointmentBlock(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	HttpSession session = request.getSession();
	session = request.getSession();
	String userName = (String) session.getAttribute("userName");
	String date="";
	String time="";
	date = (String) utilMap.get("currentDate");
	time = (String) utilMap.get("currentTime");
	
	boolean dataDeleted = false;
	
	int appointmentBlockId = 0;
	String message = null;

	String cancelAppointment = request.getParameter("cancelAppointment");
	
	AppBlock appBlock = new AppBlock();
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	MasHospital masHospital = new MasHospital();
	masHospital.setId(hospitalId);
	appBlock.setHospital(masHospital);
	
	if (request.getParameter(APP_BLOCK_ID) != null	&& !request.getParameter(APP_BLOCK_ID).equals("0")) {
		appointmentBlockId = Integer.parseInt(request.getParameter(APP_BLOCK_ID));
		appBlock.setId(appointmentBlockId);
	}
	
	dataDeleted = appointmentHandlerService.deleteAppointmentBlock(appBlock);
	
try {
		map = appointmentHandlerService.showAppBlockJsp();

	} catch (Exception e) {
		e.printStackTrace();
	}
	if (dataDeleted) {
		message = "Data deleted successfully !!";
	} else {
		message = "Data cannot be deleted !!";
	}
	jsp = APP_BLOCK;
	jsp += ".jsp";
	title = "Appointment block";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}

public ModelAndView getLoginDoctorDetailsByDepartment(HttpServletRequest request,
		HttpServletResponse response) {
	HttpSession session = request.getSession();
	Map<String, Object> map = new HashMap<String, Object>();
	//Map<String, Object> userMap = new HashMap<String, Object>();
//	List<MasEmployee> docList =  new ArrayList<MasEmployee>();
	Box box = HMSUtil.getBox(request);
	int hospitalId = 0;
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	

	if (session.getAttribute("empId") != null) {
		box.put("docId", (Integer)session.getAttribute("empId"));
	}
	box.put("hospitalId", hospitalId);
	map.put("box", box);
	map = appointmentHandlerService.getLoginDoctorDetailsByDepartment(map);
	
     jsp = "responseForAppointSetupDoctorList";
//}
	map.put("jsp", jsp);
	map.put("title", title);
	return new ModelAndView(jsp, "map", map);
	
}




}