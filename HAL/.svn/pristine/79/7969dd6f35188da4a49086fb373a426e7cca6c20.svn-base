package jkt.hms.ot.controller;

import static jkt.hms.util.RequestConstants.ADDRESS;
import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.AD_STATUS;
import static jkt.hms.util.RequestConstants.BED_ID;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.DIAGNOSIS_ID;
import static jkt.hms.util.RequestConstants.DISTRICT_ID;
import static jkt.hms.util.RequestConstants.FROM_BED;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.FROM_DOCTOR;
import static jkt.hms.util.RequestConstants.FROM_WARD;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.LOGIN_NAME;
import static jkt.hms.util.RequestConstants.OPD_RESPONSE_FOR_SURGEON_JSP;
import static jkt.hms.util.RequestConstants.OPD_RESPONSE_FOR_SURGEY_JSP;
import static jkt.hms.util.RequestConstants.OT_BOOKING_JSP;
import static jkt.hms.util.RequestConstants.OT_EMERGENCY_OT_BOOKING_JSP;
import static jkt.hms.util.RequestConstants.OT_GET_ENTRY_NO_FOR_HUMAN_BODY_PARTS_DISPOSAL_JSP;
import static jkt.hms.util.RequestConstants.OT_GET_HIN_FOR_HUMAN_BODY_PARTS_DISPOSAL_JSP;
import static jkt.hms.util.RequestConstants.OT_HUMAN_BODY_PARTS_DISPOSAL_JSP;
import static jkt.hms.util.RequestConstants.OT_MSG_HUMAN_BODY_DISPOSAL;
import static jkt.hms.util.RequestConstants.OT_MSG_OT_PROCEDURE;
import static jkt.hms.util.RequestConstants.OT_MSG_OT_PROCEDURE_UPDATE;
import static jkt.hms.util.RequestConstants.OT_MSG_PAC_CLEARANCE;
import static jkt.hms.util.RequestConstants.OT_MSG_POST_ANESTHESIA_PROCEDURE;
import static jkt.hms.util.RequestConstants.OT_MSG_PRE_ANESTHESIA;
import static jkt.hms.util.RequestConstants.OT_PAC_CLEARANCE_LIST_JSP;
import static jkt.hms.util.RequestConstants.OT_PAC_CLEARED_LIST_FOR_OT_BOOKING_JSP;
import static jkt.hms.util.RequestConstants.OT_PATIENT_SEARCH_FOR_DISPOSAL_JSP;
import static jkt.hms.util.RequestConstants.OT_PATIENT_SEARCH_FOR_EMERGENCY_OT_BOOKING_JSP;
import static jkt.hms.util.RequestConstants.OT_PATIENT_SEARCH_FOR_PRE_ANESTHESIA;
import static jkt.hms.util.RequestConstants.OT_POP_UP_FOR_INVESTIGATION;
import static jkt.hms.util.RequestConstants.OT_POST_ANAESTHESIA_FOR_INPATIENT_JSP;
import static jkt.hms.util.RequestConstants.OT_POST_ANAESTHESIA_PATIENT_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.OT_PRE_ANESTHESIA_JSP;
import static jkt.hms.util.RequestConstants.OT_RESPONSE_FOR_CHARGE_CODE_NAME_JSP;
import static jkt.hms.util.RequestConstants.OT_RESPONSE_FOR_EMP_NAME_FOR_POST_ANESTHESIA_JSP;
import static jkt.hms.util.RequestConstants.OT_RESPONSE_FOR_EMP_NAME_JSP;
import static jkt.hms.util.RequestConstants.OT_SEARCH_HUMAN_BODY_PARTS_DISPOSAL_JSP;
import static jkt.hms.util.RequestConstants.OT_SPECIMEN_DISPATCH_ENTRY_FOR_INPATIENT_JSP;
import static jkt.hms.util.RequestConstants.OT_SPECIMEN_DISPATCH_ENTRY_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.OT_SURGEON_LIST_JSP;
import static jkt.hms.util.RequestConstants.OT_VIEW_PRE_ANESTHESIA_DETAILS;
import static jkt.hms.util.RequestConstants.OT_WORK_LOAD_REGISTER;
import static jkt.hms.util.RequestConstants.PATIENT_LIST_JSP;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.PATIENT_STATUS;
import static jkt.hms.util.RequestConstants.PATIENT_TYPE;
import static jkt.hms.util.RequestConstants.P_FIRST_NAME;
import static jkt.hms.util.RequestConstants.P_LAST_NAME;
import static jkt.hms.util.RequestConstants.P_MIDDLE_NAME;
import static jkt.hms.util.RequestConstants.RANK_ID;
import static jkt.hms.util.RequestConstants.RESPONSE_FOR_OT_ENTRY_HIN_NO;
import static jkt.hms.util.RequestConstants.RESPONSE_FOR_OT_ENTRY_NO;
import static jkt.hms.util.RequestConstants.RESPONSE_FOR_OT_HIN_NO;
import static jkt.hms.util.RequestConstants.RESPONSE_FOR_OT_VISIT_NO;
import static jkt.hms.util.RequestConstants.SEARCH_OT_POST_ANESTHESIA_PROCEDURE_FOR_MAIN_JSP;
import static jkt.hms.util.RequestConstants.SEARCH_OT_POST_ANESTHESIA_PROCEDURE_JSP;
import static jkt.hms.util.RequestConstants.SEARCH_OT_SPECIMEN_DISPATCH_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.SEARCH_SHOW_OT_POST_ANESTHESIA_PROCEDURE_JSP;
import static jkt.hms.util.RequestConstants.SEARCH_SHOW_OT_SPECIMEN_DISPATCH_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SERVICE_PERSON_NAME;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID;
import static jkt.hms.util.RequestConstants.START_DATE;
import static jkt.hms.util.RequestConstants.STATE_ID;
import static jkt.hms.util.RequestConstants.S_FIRST_NAME;
import static jkt.hms.util.RequestConstants.S_LAST_NAME;
import static jkt.hms.util.RequestConstants.S_MIDDLE_NAME;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TO_DOCTOR;
import static jkt.hms.util.RequestConstants.TO_WARD;
import static jkt.hms.util.RequestConstants.TRANSFER_DATE;
import static jkt.hms.util.RequestConstants.TRANSFER_NO;
import static jkt.hms.util.RequestConstants.TRANSFER_TIME;
import static jkt.hms.util.RequestConstants.UNIT_ID;
import static jkt.hms.util.RequestConstants.VISIT_NUMBER;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.GENDER;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.OT_ID;
import static jkt.hms.util.RequestConstants.SURGERY_DATE;
import static jkt.hms.util.RequestConstants.OT_BOOKING_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;








































import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.ipd.handler.IPDHandlerService;
import jkt.hms.masters.business.AnesthesiaRecordDocument;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasOt;
import jkt.hms.masters.business.MasOtDistribution;
import jkt.hms.masters.business.OtAnesthesiologist;
import jkt.hms.masters.business.OtBed;
import jkt.hms.masters.business.OtBooking;
import jkt.hms.masters.business.OtPostAnaesthesiaProcedure;
import jkt.hms.masters.business.OtPreOpInstruction;
import jkt.hms.masters.business.OtSpecimenDispatchEntry;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Transfer;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.ot.handler.OTHandlerService;
import jkt.hms.pacs.dataservice.PacsHL7Service;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class OTController extends MultiActionController {

	OTHandlerService otHandlerService = null;
	IPDHandlerService ipdHandlerService = null;
	String jsp = "";
	String title = "";
	String message = "";
	String userName = "";
	Map<String, Object> map = new HashMap<String, Object>();

	public OTHandlerService getOtHandlerService() {
		return otHandlerService;
	}

	public void setOtHandlerService(OTHandlerService otHandlerService) {
		this.otHandlerService = otHandlerService;
	}

	public IPDHandlerService getIpdHandlerService() {
		return ipdHandlerService;
	}

	public void setIpdHandlerService(IPDHandlerService ipdHandlerService) {
		this.ipdHandlerService = ipdHandlerService;
	}

	// ---------------------- methods changed by vikas--------------------
	public ModelAndView showPACClearanceList(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			mapForDS.put(HOSPITAL_ID, hospitalId);
		}
		if(request.getParameter(EMPLOYEE_ID) !=null && !request.getParameter(EMPLOYEE_ID).equals("")){
			mapForDS.put(EMPLOYEE_ID,  request.getParameter(EMPLOYEE_ID));
		}
	
	/*	if(request.getParameter("uhid")!=null && !request.getParameter("uhid").equals(""))
		{
			mapForDS.put(HIN_NO, request.getParameter("uhid"));
		}
		*/
		if(request.getParameter("pname")!=null && !request.getParameter("pname").equals(""))
		{
			mapForDS.put(PATIENT_NAME, request.getParameter("pname"));
		}
		
		/*if(request.getParameter("ipno")!=null && !request.getParameter("ipno").equals(""))
		{
			mapForDS.put(AD_NO, request.getParameter("ipno"));
		}*/
		
		if(request.getParameter("gender")!=null && !request.getParameter("gender").equals("") && !request.getParameter("gender").equals("0"))
		{
			mapForDS.put(GENDER , Integer.parseInt(request.getParameter("gender")));
		}
		map = otHandlerService.getPacClearanceList(mapForDS);
		jsp = OT_PAC_CLEARANCE_LIST_JSP;
		jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
		// return null;
	}

	@SuppressWarnings("unused")
	public ModelAndView searchPatient(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		String patientType = "";

		int deptId = (Integer) session.getAttribute("deptId");

		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDS.put("hinNo", hinNo);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDS.put("serviceNo", serviceNo);
		}
		if (request.getParameter(PATIENT_TYPE) != null
				&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
			patientType = request.getParameter(PATIENT_TYPE);
			mapForDS.put("patientType", patientType);
		}
		mapForDS.put("deptId", deptId);

		map = otHandlerService.searchpatient(mapForDS);
		jsp = OT_PAC_CLEARANCE_LIST_JSP;
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPreAnesthesiaForm(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
	//	int  todaySeqNo=0;
		HttpSession session = request.getSession();
		int opdSurgeryId = Integer.parseInt(request.getParameter("opdSurgeryId"));
	/*	if(request.getParameter("todaySeqNo")!=null){
		todaySeqNo = Integer.parseInt(request.getParameter("todaySeqNo").trim());
		}*/
/*
		mapForDS.put("todaySeqNo", todaySeqNo);*/
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int departmentId = 0;
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}
		int docId = 0;
		if (session.getAttribute("empId") != null) {
			docId = (Integer) session.getAttribute("empId");
		}
		mapForDS.put(EMPLOYEE_ID, docId);
		mapForDS.put(DEPARTMENT_ID, departmentId);
		mapForDS.put(HOSPITAL_ID, hospitalId);
		mapForDS.put("opdSurgeryId", opdSurgeryId);
		map = otHandlerService.showPreAnesthesiaForm(mapForDS);

		jsp = OT_PRE_ANESTHESIA_JSP;
		jsp += ".jsp";
		title = "Pre-Anesthesia Form";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView openPopUPWindowForInvestigationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		int visitId = 0;
		int hinId = 0;
		int inpatientId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String patientStatus = request.getParameter("patientStatus");

		hinId = Integer.parseInt(request.getParameter("hinId"));
		if (patientStatus.equals("Out Patient")) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
			dataMap.put("visitId", visitId);
		} else {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			dataMap.put("inpatientId", inpatientId);
		}
		dataMap.put("hinId", hinId);
		dataMap.put("patientStatus", patientStatus);
		// //System.out.println("patientStatus==============="+patientStatus+"===visitId=="+visitId+"====inpatientId=="+inpatientId+"===hinId===="+hinId);
		map = otHandlerService.getInvestigationDetails(dataMap);

		jsp = OT_POP_UP_FOR_INVESTIGATION;
		return new ModelAndView(jsp, "map", map);
		// return null;
	}

	
	public ModelAndView showAllergy(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int requestId=0;
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getParameter("requestId")!=null){
			requestId = Integer.parseInt(""+request.getParameter("requestId"));
		}
		 
		map = otHandlerService.showAllergy(box, dataMap);
		jsp = "allergyList";
		map.put("contentJsp", jsp);
		map.put("requestId", requestId);
		return new ModelAndView(jsp, "map", map);
	}
	
	//added by Babita
	public ModelAndView openPopupWindowForOPDHistory(HttpServletRequest request,
			HttpServletResponse response)
	{
		/*Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box =HMSUtil.getBox(request);
		
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		int inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		box.put("parent", inpatientId);
		box.put("hinId", hinId);
		if(session.getAttribute("deptId")!=null)
		box.put("deptId", (Integer)session.getAttribute("deptId"));
		if(session.getAttribute("hospitalId")!=null)
			box.put("hospitalId", (Integer)session.getAttribute("hospitalId"));
//		map = ipdHandlerService.showCaseSheetJsp(box);
		map = ipdHandlerService.showNewCaseSheetJsp(box);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = ipdHandlerService.getPatientLatestDiagnosisAndDisability(box.getInt("parent"));
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		System.out.println(box.getInt("parent") +" ddd ");
		
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		map.put("opdSurgeryId", box.getInt("opdSurgeryId"));
//		String jsp = "ipdCaseSheet.jsp";
		//String jsp = "ipdCaseSheetNew.jsp";
		String jsp = "otWindowForOPD";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);*/
		Map<String, Object> DataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box =HMSUtil.getBox(request);
		if(session.getAttribute("deptId")!=null)
		box.put("deptId", (Integer)session.getAttribute("deptId"));
		
		int opdSurgeryId = 0;
		if(box.get("opdSurgeryId")!=null)
			opdSurgeryId = box.getInt("opdSurgeryId");
		
		if(session.getAttribute("hospitalId")!=null)
			box.put("hospitalId", (Integer)session.getAttribute("hospitalId"));
//		map = ipdHandlerService.showCaseSheetJsp(box);
		int inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		box.put("parent", inpatientId);
		DataMap.put("box", box);
		map = otHandlerService.showNewCaseSheetJsp(DataMap);
		map.put("opdSurgeryId", opdSurgeryId);
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		/*detailsMap = ipdHandlerService.getPatientLatestDiagnosisAndDisability(box.getInt("parent"));*/
		
		
		if(detailsMap.get("diagnosisList")!=null){
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if(detailsMap.get("disabilityList")!=null){
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
//		String jsp = "ipdCaseSheet.jsp";
		String jsp = "otWindowForOPD";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
		
/*		
		map = ipdHandlerService.getPrevCaseNoteDiagnosis(box);
		
		String jsp="responseCaseNotesDiagnosis";*/
		
	}
	
	public ModelAndView getPrevCaseNoteDiagnosis(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		
		map = ipdHandlerService.getPrevCaseNoteDiagnosis(box);
		
		String jsp="otResponseCaseNotesDiagnosis";
		return new ModelAndView(jsp, "map", map);
	}
	/**
	 * Method to get prev treatment details for new IPD Case Sheet
	 */
	public ModelAndView getPrevTreatmentDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		
		map = ipdHandlerService.getPrevTreatmentDetails(box);
		
		//String jsp="responseTreatmentDetailsCaseSheet";
		String jsp="otResponseTreatmentDetailsCaseSheet";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getPrevInvestigationDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		Box box =HMSUtil.getBox(request);
		map = ipdHandlerService.getPrevInvestigationDetails(box);
		String jsp="responseInvestigationDetailsCaseSheet";
		//String jsp="otResponseInvestigationDetailsCaseSheet";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getPrevProcedureDetails(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		
		map = ipdHandlerService.getPrevProcedureDetails(box);
		
		String jsp="otResponseProcedureDetailsCaseSheet";
		return new ModelAndView(jsp, "map", map);
	}
	
	@SuppressWarnings("unused")
	public ModelAndView submitPreAnesthesiaDetails(HttpServletRequest request,
			HttpServletResponse response) {

		
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		
		String [] surgeryDtStringArrary = request.getParameterValues("surgerydt");
		mapForDS.put("surgeryDtStringArrary", surgeryDtStringArrary); 
		
		// Map<String, Object> map = new HashMap<String, Object>();.
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
	
		int userId = 0;
		if (session.getAttribute(USER_ID) != null) {
			userId = (Integer) session.getAttribute(USER_ID);
		}
		int docId = 0;
		if (session.getAttribute("empId") != null) {
			docId = (Integer) session.getAttribute("empId");
		}
		
		String[] bloodDetails=null;
		if(request.getParameterValues("blood")!=null ){
			bloodDetails=request.getParameterValues("blood");
		}
		String blood="";
		if(bloodDetails!=null && bloodDetails.length>0){
		for(String str:bloodDetails){
			blood=blood+","+str;
		}
		}
		int unitForBloodComponent=0;
		if(request.getParameter("unitForBloodComponent")!=null && !request.getParameter("unitForBloodComponent").equals("")){
			unitForBloodComponent=Integer.parseInt(request.getParameter("unitForBloodComponent"));
		}
	
		mapForDS.put(USER_ID, userId);
		mapForDS.put(EMPLOYEE_ID, docId);
		mapForDS.put(HOSPITAL_ID, hospitalId);
		mapForDS.put("box", box);
		box.put("blood",blood);
		box.put("unitForBloodComponent",unitForBloodComponent);

		int mhcount = 0;
		List<Integer> fhIdList = new ArrayList<Integer>();
		List<String> statusList = new ArrayList<String>();
		List<String> durationList = new ArrayList<String>();
		
		if (request.getParameter("mhcount") != null
				&& !request.getParameter("mhcount").equals("")) {
			mhcount = Integer.parseInt(request.getParameter("mhcount"));
		}
		for (int i = 1; i <= mhcount; i++) {
			int fhId = Integer.parseInt(request.getParameter("fhId" + i));
			fhIdList.add(fhId);
			String status = request.getParameter("mhStatus" + i);
				statusList.add(status);
			String duration = request.getParameter("mhDuration" + i);
			durationList.add(duration);
		}
		mapForDS.put("fhIdList", fhIdList);
		mapForDS.put("statusList", statusList);
		mapForDS.put("durationList", durationList);
		
		try {
			
			map = otHandlerService
					.submitPreAnesthesiaDetails(mapForDS);
			boolean bool = false;
			if(map.get("succesfullyAdded")!=null)
			bool = (Boolean) map.get("succesfullyAdded");
			if (bool) {
				//System.out.println("id "+map.get("otPreAnesthesiahdId"));
				//map = otHandlerService.getPacClearanceList(mapForDS);
			/*	System.out.println("orderNo"+box.getInt("orderNo"));
				System.out.println("hinId"+box.getInt("hinId"));
				System.out.println("pastHistory"+box.getInt("pastHistory"));
				System.out.println("presentHistory"+box.getInt("presentHistory"));
				System.out.println("drugTherapy"+box.getInt("drugTherapy"));*/
				//map.put("orderNo", box.getInt("orderNo"));
				//map.put("hinId", box.getInt("hinId"));
				//map.put("pastHistory", box.getString("pastHistory"));
				//map.put("presentHistory", box.getString("presentHistory"));
				//map.put("drugTherapy", box.getString("drugTherapy"));
				jsp = OT_MSG_PAC_CLEARANCE;
//				message = "PAC Form Completed Successfully!! Do you want to print?";
				message = "PAC Form Completed Successfully.";

			} else {
				map = otHandlerService.getPacClearanceList(mapForDS);
				message = "Error occured!! Try Again ?";
				jsp = OT_PAC_CLEARANCE_LIST_JSP;
			}

			jsp += ".jsp";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
			//pacsTest(request, response);
		} catch (RuntimeException e) {

			e.printStackTrace();
		}

		return new ModelAndView("index", "map", map);
		// return null;

		/*
		 * 
		 * Box box = HMSUtil.getBox(request); HttpSession session =
		 * request.getSession(); Map<String, Object> mapForDS = new
		 * HashMap<String, Object>(); // Map<String, Object> map = new
		 * HashMap<String, Object>();.
		 * 
		 * mapForDS.put("box", box);
		 * 
		 * try { boolean bool = otHandlerService
		 * .submitPreAnesthesiaDetails(mapForDS); if (bool) { map =
		 * otHandlerService.getPacClearanceList(mapForDS); map.put("orderNo",
		 * box.getInt("orderNo")); map.put("hinId", box.getInt("hinId")); //
		 * map.put("pastHistory", box.getString("pastHistory"));
		 * map.put("pastRecords", box.getString("pastHistory"));
		 * map.put("presentHistory", box.getString("presentHistory"));
		 * map.put("drugTherapy", box.getString("drugTreatment")); jsp =
		 * OT_MSG_PAC_CLEARANCE; message =
		 * "PAC Form Completed Successfully!! Do you want to print?";
		 * 
		 * } else { map = otHandlerService.getPacClearanceList(mapForDS);
		 * message = "Error occured!! Try Again ?"; jsp =
		 * OT_PAC_CLEARANCE_LIST_JSP; }
		 * 
		 * jsp += ".jsp"; map.put("message", message); map.put("contentJsp",
		 * jsp); map.put("title", title); } catch (RuntimeException e) {
		 * 
		 * e.printStackTrace(); }
		 * 
		 * return new ModelAndView("index", "map", map); // return null;
		 */

	}

	public ModelAndView updatePreAnesthesiaDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
/*		List<String> itemIdList = new ArrayList<String>();
		List<String> dosageList = new ArrayList<String>();
		List<String> routeList = new ArrayList<String>();
		List<String> timeList = new ArrayList<String>();*/

		mapForDS.put("box", box);
		String pastHistory = "";
		String presentHistory = "";
		String drugTherapy = "";
		Date changedDate=null;
		//int todaySeqNo=0;
		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hiddenValue")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hiddenValue"));
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			mapForDS.put(HOSPITAL_ID, (Integer) session.getAttribute(HOSPITAL_ID));
		}
		
		int userId = 0;
		if (session.getAttribute(USER_ID) != null) {
			userId = (Integer) session.getAttribute(USER_ID);
			mapForDS.put(USER_ID, userId);
		}
		int docId = 0;
		if (session.getAttribute("empId") != null) {
			docId = (Integer) session.getAttribute("empId");
		}
	
		
		String [] surgeryDtStringArrary = request.getParameterValues("surgerydt");
		
		
		mapForDS.put(EMPLOYEE_ID, docId);
		mapForDS.put("surgeryDtStringArrary", surgeryDtStringArrary); 
		
		int otPreAnesthesiaDetailsId = 0;
		if (request.getParameter("otPreAnesthesiaDetailsId") != null) {
			otPreAnesthesiaDetailsId = Integer.parseInt(request.getParameter("otPreAnesthesiaDetailsId").trim());
			mapForDS.put("otPreAnesthesiaDetailsId", otPreAnesthesiaDetailsId);
			map.put("otPreAnesthesiahdId", otPreAnesthesiaDetailsId);
			
			
		}
		if (request.getParameter("changedDate") != null) {
			changedDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter("changedDate"));
			mapForDS.put("changedDate", changedDate);
		}

		int mhcount = 0;
		List<Integer> fhIdList = new ArrayList<Integer>();
		List<String> statusList = new ArrayList<String>();
		List<String> durationList = new ArrayList<String>();
		
		if (request.getParameter("mhcount") != null
				&& !request.getParameter("mhcount").equals("")) {
			mhcount = Integer.parseInt(request.getParameter("mhcount"));
		}
		for (int i = 1; i <= mhcount; i++) {
			int fhId = Integer.parseInt(request.getParameter("fhId" + i));
			fhIdList.add(fhId);
			String status = request.getParameter("mhStatus" + i);
				statusList.add(status);
			String duration = request.getParameter("mhDuration" + i);
			durationList.add(duration);
		}
		mapForDS.put("fhIdList", fhIdList);
		mapForDS.put("statusList", statusList);
		mapForDS.put("durationList", durationList);
		//String[] itemIdArr = new String[hdb + 1];

	/*	for (int i = 1; i <= hdb; i++) {
			if (request.getParameter("itemName" + i) != null
					&& !request.getParameter("itemName" + i).equals("")) {

				String nomenclature = request.getParameter("itemName" + i);
				String dose = request.getParameter("dose" + i);
				String route = request.getParameter("route" + i);
				String time = request.getParameter("time" + i);

				int index1 = nomenclature.lastIndexOf("[");
				int index2 = nomenclature.lastIndexOf("]");
				index1++;
				itemIdArr[i] = nomenclature.substring(index1, index2);

				itemIdList.add(itemIdArr[i]);
				dosageList.add(dose);
				routeList.add(route);
				timeList.add(time);

			}

		}*/
		/*mapForDS.put("itemIdList", itemIdList);
		mapForDS.put("dosageList", dosageList);
		mapForDS.put("routeList", routeList);
		mapForDS.put("timeList", timeList);*/
		try {
			boolean bool = otHandlerService
					.updatePreAnesthesiaDetails(mapForDS);
			if (bool) {
				//map = otHandlerService.getPacClearanceList(mapForDS);
				map.put("todaySeqNo", box.getInt("todaySeqNo"));
				map.put("orderNo", box.getInt("orderNo"));
				map.put("hinId", box.getInt("hinId"));
				map.put("pastHistory", pastHistory);
				map.put("presentHistory", presentHistory);
				map.put("drugTherapy", drugTherapy);
				jsp = OT_MSG_PAC_CLEARANCE;
				message = "PAC Form Completed Successfully";

			} else {
				//map = otHandlerService.getPacClearanceList(mapForDS);
				message = "Error occured!! Try Again ?";
				jsp = OT_MSG_PAC_CLEARANCE;
			}

			jsp += ".jsp";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
			//pacsTest(request, response);
		} catch (RuntimeException e) {

			e.printStackTrace();
		}

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView surgeryWaitingList(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		String hinNo = "";
		int empId = 0;
		String pname = "";
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		Map<String, Object> mapForDS = new HashMap<String, Object>();
	/*	if(request.getParameter("pname") !=null){
			pname = request.getParameter("pname");
			mapForDS.put("pname", pname);
		}*/
		
		if(request.getParameter(PATIENT_NAME)!=null && !request.getParameter(PATIENT_NAME).equals(""))
		{
			mapForDS.put(PATIENT_NAME, request.getParameter(PATIENT_NAME));
		}
		if(request.getParameter(EMPLOYEE_ID) !=null && !request.getParameter(EMPLOYEE_ID).equals("")){
			mapForDS.put(EMPLOYEE_ID, request.getParameter(EMPLOYEE_ID));
		}
/*		if(request.getParameter(HIN_NO) !=null  && !request.getParameter(HIN_NO).equals("")){
			hinNo = request.getParameter(HIN_NO);
			mapForDS.put(HIN_NO, hinNo);
		}*/

		mapForDS.put(HOSPITAL_ID, hospitalId);	
	
		map = otHandlerService.showWaitingListForSurgery(mapForDS);

		jsp = "waiting_list_for_surgery";
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	 }
	
	
	public ModelAndView showPacClearedListForOTBookingJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		//String hinNo = "";
		//int empId = 0;
		int otId = 0;
		String pname = "";
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			mapForDS.put(HOSPITAL_ID, hospitalId);
		}
		
		if(request.getParameter("pname") !=null){
			pname = request.getParameter("pname");
			mapForDS.put("pname", pname);
		}
		
		if(request.getParameter(PATIENT_NAME)!=null && !request.getParameter(PATIENT_NAME).equals(""))
		{
			mapForDS.put(PATIENT_NAME, request.getParameter(PATIENT_NAME));
		}
		
		if(request.getParameter(EMPLOYEE_ID) !=null && !request.getParameter(EMPLOYEE_ID).equals("")){
			mapForDS.put(EMPLOYEE_ID, request.getParameter(EMPLOYEE_ID));
		}
	/*	if(request.getParameter(HIN_NO) !=null  && !request.getParameter(HIN_NO).equals("")){
			hinNo = request.getParameter(HIN_NO);
			mapForDS.put(HIN_NO, hinNo);
		}
		*/
		if(request.getParameter(SURGERY_DATE) !=null  && !request.getParameter(SURGERY_DATE).equals("")){
			mapForDS.put(SURGERY_DATE, request.getParameter(SURGERY_DATE));
		}
		
		if(request.getParameter(OT_ID) !=null  && !request.getParameter(OT_ID).equals("")){
			otId = Integer.parseInt(request.getParameter(OT_ID));
			mapForDS.put(OT_ID, otId);
		}
		map = otHandlerService.showPACClearedListForOTBooking(mapForDS);
		jsp = OT_PAC_CLEARED_LIST_FOR_OT_BOOKING_JSP;
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView searchPatientForOTBooking(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		String patientType = "";

		int deptId = (Integer) session.getAttribute("deptId");

		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDS.put("hinNo", hinNo);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDS.put("serviceNo", serviceNo);
		}
		if (request.getParameter(PATIENT_TYPE) != null
				&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
			patientType = request.getParameter(PATIENT_TYPE);
			mapForDS.put("patientType", patientType);
		}
		mapForDS.put("deptId", deptId);

		map = otHandlerService.searchpatientForOTBooking(mapForDS);
		jsp = OT_PAC_CLEARED_LIST_FOR_OT_BOOKING_JSP;
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOTBookingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int PacHdId = 0;
		if(request.getParameter("PacHdId")!=null)
		{
			try
			{
				PacHdId = Integer.parseInt(request.getParameter("PacHdId"));
			}
			
			catch(NumberFormatException e)
			{
				e.getStackTrace();
			}
		}
		
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		int deptId = 0;
		if (session.getAttribute(DEPARTMENT_ID) != null) {
			deptId = (Integer) session.getAttribute(DEPARTMENT_ID);
		}
		
		int empId = 0;
		if (session.getAttribute("empId") != null) {
			empId = (Integer) session.getAttribute("empId");
		}
		
		mapForDS.put(HOSPITAL_ID, hospitalId);
		mapForDS.put("PacHdId", PacHdId);
		mapForDS.put(DEPARTMENT_ID, deptId);
		mapForDS.put("empId", empId);
		map = otHandlerService.showOTBookingJsp(mapForDS);

		jsp = OT_BOOKING_JSP;
		jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView getSurgeonListForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String departmentIdField = "";
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			map.put("autoHint", autoHint);
			map = otHandlerService.getSurgeonListForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OT_SURGEON_LIST_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitOTBookingDetails(HttpServletRequest request,
			HttpServletResponse response) {
		String jsp = "";
		Box box = HMSUtil.getBox(request);
		
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List empIdList = new ArrayList();
		List<String> roleList = new ArrayList<String>();
		mapForDS.put("box", box);
		String date = box.getString("surgeryDate");
		int deptId = Integer.parseInt(request.getParameter("departmentId"));
		/*int deptId = (Integer) (session.getAttribute("deptId"));*/
		int hospitalId = 0;
		int userId = 0;
		String [] surgeryDtStringArrary = request.getParameterValues("surgerydt");
		mapForDS.put("surgeryDtStringArrary", surgeryDtStringArrary); 
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		if (session.getAttribute(USER_ID) != null) {
			userId = (Integer) session.getAttribute(USER_ID);
		}
		int bookedById = 0;
		if (session.getAttribute("empId") != null) {
			bookedById = (Integer) session.getAttribute("empId");
		}
		mapForDS.put(HOSPITAL_ID, hospitalId);
		mapForDS.put(USER_ID, userId);
		mapForDS.put("departmentId", deptId);
		box.put("bookedById", bookedById);
		int hiddenValue = 0;
		if (request.getParameter("hiddenValue") != null
				&& !request.getParameter("hiddenValue").equals("")) {
			hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
		}
		for (int i = 1; i <= hiddenValue; i++) {
			String surgeonName = request.getParameter("surgeonName" + i);
			if (surgeonName!=null && !surgeonName.equals("")) {
				int index1 = surgeonName.indexOf("[");
				index1 = index1 + 1;
				int index2 = surgeonName.lastIndexOf("]");
				String surgeonId = surgeonName.substring(index1, index2);
				int empId = Integer.parseInt(surgeonId);
				empIdList.add(empId);
			}
			String role = request.getParameter("role" + i);
			if (!role.equals("")) {
				roleList.add(role);
			}
			
		}
		mapForDS.put("empIdList", empIdList);
		mapForDS.put("roleList", roleList);
		try {
			map = otHandlerService.submitOTBookingDetails(mapForDS);
			String succesfullyAdded = (String) map.get("succesfullyAdded");
			String value = (String) map.get("value");
			if (map.get("succesfullyAdded") != null) {
				if (succesfullyAdded.equalsIgnoreCase("true")) {
				
					//map = otHandlerService
						//	.showPACClearedListForOTBooking(mapForDS);
					message = value;
				} else {
					//map = otHandlerService
							//.showPACClearedListForOTBooking(mapForDS);
					message = value;
				}
			} else {
				//map = otHandlerService.showPACClearedListForOTBooking(mapForDS);
				message = "Error In Submitting OT details.";

			}
			jsp = "OT_bookingMsg";
			jsp += ".jsp";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unused")
	public ModelAndView showOTPatientSearchForDisposalJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp = OT_PATIENT_SEARCH_FOR_DISPOSAL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showHumanBodyPartsDisposalJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int otBookingId = Integer.parseInt(request.getParameter("hinNo"));
		mapForDS.put("otBookingId", otBookingId);

		try {
			/*
			 * if(request.getParameter("flag")!= null){
			 * if(request.getParameter("flag").equals("existingRecord")){ int
			 * entryNo=Integer.parseInt(request.getParameter("entryNo"));
			 * mapForDS.put("entryNo", entryNo);
			 * map=otHandlerService.searchHumanBodyPartsDisposal(mapForDS); }
			 * }else{
			 */
			map = otHandlerService.showHumanBodyPartsDisposalJsp(mapForDS);
			// }

			jsp = OT_HUMAN_BODY_PARTS_DISPOSAL_JSP;
			jsp += ".jsp";
			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientDetailsForDisposal(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";

		String serviceFName = "";
		String serviceMName = "";
		String serviceLName = "";

		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put("hinNo", hinNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDS.put("serviceNo", serviceNo);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDS.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDS.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDS.put("patientLName", patientLName);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serviceFName = request.getParameter(S_FIRST_NAME);
				mapForDS.put("serviceFName", serviceFName);
			}
			if (request.getParameter(S_MIDDLE_NAME) != null
					&& !(request.getParameter(S_MIDDLE_NAME).equals(""))) {
				serviceMName = request.getParameter(S_MIDDLE_NAME);
				mapForDS.put("serviceMName", serviceMName);
			}
			if (request.getParameter(S_LAST_NAME) != null
					&& !(request.getParameter(S_LAST_NAME).equals(""))) {
				serviceLName = request.getParameter(S_LAST_NAME);
				mapForDS.put("serviceLName", serviceLName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = otHandlerService.searchPatientDetailsForDisposal(mapForDS);
		String jsp = "";
		jsp = OT_PATIENT_SEARCH_FOR_DISPOSAL_JSP + ".jsp";
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitHumanBodyPartsDisposal(
			HttpServletRequest request, HttpServletResponse response) {
		String message = "";
		int entryNo = 0;
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getParameter("entryNo") != null
				&& !request.getParameter("entryNo").equals("")) {
			entryNo = Integer.parseInt(request.getParameter("entryNo"));
		}
		mapForDS.put("entryNo", entryNo);
		mapForDS.put("box", box);
		try {
			boolean bool = otHandlerService
					.submitHumanBodyPartsDisposal(mapForDS);
			if (bool) {
				message = "HumanBodyPartsDisposal Submitted Successfully!! Do you want to print?";
			} else {
				message = "Error Ocurred!! Try Again !!";
			}
			String jsp = OT_MSG_HUMAN_BODY_DISPOSAL;
			jsp += ".jsp";
			map.put("entryNo", entryNo);
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateHumanBodyPartsDisposal(
			HttpServletRequest request, HttpServletResponse response) {
		String message = "";
		int entryNo = 0;
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getParameter("entryNo") != null
				&& !request.getParameter("entryNo").equals("")) {
			entryNo = Integer.parseInt(request.getParameter("entryNo"));
		}
		mapForDS.put("entryNo", entryNo);
		mapForDS.put("box", box);
		try {
			boolean bool = otHandlerService
					.updateHumanBodyPartsDisposal(mapForDS);
			if (bool) {
				message = "HumanBodyPartsDisposal Submitted Successfully!! Do you want to print?";
			} else {
				message = "Error Ocurred!! Try Again !!";
			}
			String jsp = OT_MSG_HUMAN_BODY_DISPOSAL;
			jsp += ".jsp";
			map.put("entryNo", entryNo);
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchHumanBodyPartsDisposal(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = OT_SEARCH_HUMAN_BODY_PARTS_DISPOSAL_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getHinNoList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";

		try {
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				detailsMap.put("serviceNo", serviceNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				detailsMap.put("hinNo", hinNo);
			}
			List<Object> hinNoList = new ArrayList<Object>();
			List<Object> entryNoList = new ArrayList<Object>();
			String flag = "";

			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("hin")) {
				hinNoList = otHandlerService.getHinNoList(serviceNo);
				map.put("hinNoList", hinNoList);
				jsp = OT_GET_HIN_FOR_HUMAN_BODY_PARTS_DISPOSAL_JSP;
			}
			if (flag.equals("entry")) {
				mapForDS.put("hinNo", hinNo);
				map = otHandlerService
						.getEntryNoListForHumanBodyPartsDisposal(mapForDS);
				jsp = OT_GET_ENTRY_NO_FOR_HUMAN_BODY_PARTS_DISPOSAL_JSP;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView showEmergencyOTBookingPatientSearch(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp = OT_PATIENT_SEARCH_FOR_EMERGENCY_OT_BOOKING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientDetailsForEmergencyOTBooking(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";

		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put("hinNo", hinNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDS.put("serviceNo", serviceNo);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDS.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDS.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDS.put("patientLName", patientLName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = otHandlerService
				.searchPatientDetailsForEmergencyOTBooking(mapForDS);
		String jsp = "";
		jsp = OT_PATIENT_SEARCH_FOR_EMERGENCY_OT_BOOKING_JSP + ".jsp";

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showEmergencyOTBookingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int deptId = (Integer) session.getAttribute("deptId");
		int hinId = Integer.parseInt(request.getParameter("hinNo"));
		mapForDS.put("hinId", hinId);
		mapForDS.put("deptId", deptId);

		map = otHandlerService.showEmergencyOTBookingJsp(mapForDS);

		jsp = OT_EMERGENCY_OT_BOOKING_JSP;
		jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
		// return null;
	}

	public ModelAndView submitEmergencyOTBookingDetails(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List empIdList = new ArrayList();
		mapForDS.put("box", box);
		String date = box.getString("surgeryDate");
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		mapForDS.put("deptId", deptId);
		int hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
		for (int i = 1; i <= hiddenValue; i++) {
			String surgeonName = request.getParameter("surgeonName" + i);
			if (!surgeonName.equals("")) {
				int index1 = surgeonName.indexOf("[");
				index1 = index1 + 1;
				int index2 = surgeonName.lastIndexOf("]");
				String surgeonId = surgeonName.substring(index1, index2);
				int empId = Integer.parseInt(surgeonId);
				empIdList.add(empId);
			}
		}
		mapForDS.put("empIdList", empIdList);
		try {
			boolean succesfullyAdded = otHandlerService
					.submitEmergencyOTBookingDetails(mapForDS);
			if (succesfullyAdded) {
				message = "OT Booked For the Patient.";
			} else {
				message = "OT is Not booked For the patient.";

			}

			jsp = OT_PATIENT_SEARCH_FOR_EMERGENCY_OT_BOOKING_JSP;
			jsp += ".jsp";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView showOTPatientSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp = OT_PATIENT_SEARCH_FOR_PRE_ANESTHESIA;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showPatientDetailsForPreAnesthesia(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";

		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put("hinNo", hinNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDS.put("serviceNo", serviceNo);
			}

			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDS.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDS.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDS.put("patientLName", patientLName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = otHandlerService.viewPreAnesthesiaDetails(mapForDS);
		String jsp = "";
		jsp = OT_PATIENT_SEARCH_FOR_PRE_ANESTHESIA + ".jsp";

		map.put("patientMap", patientMap);

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
		
		
	}

	public ModelAndView viewPreAnesthesiaDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();

		int preAnesthesiaDetailId = Integer.parseInt(request
				.getParameter("preAnesthesiaDetailId"));
		//System.out.println("preAnesthesiaDetailId============="+ preAnesthesiaDetailId);
		mapForDS.put("preAnesthesiaDetailId", preAnesthesiaDetailId);

		map = otHandlerService.viewPreAnesthesiaDetails(mapForDS);
		jsp = OT_VIEW_PRE_ANESTHESIA_DETAILS;
		jsp += ".jsp";
		title = "Pre-Anesthesia Form";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
		// return null;
	}

	// ---------------------methods changed by
	// vikas-----------------------------------
	/**
	 * --------------------------------------- Priyanka
	 * Garg----------------------------------
	 * -------------------------------------OT List
	 * Change-----------------------------------
	 */

	public ModelAndView showOTListChangeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = otHandlerService.getOtListData();
		jsp = "otListChange";
		jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showActualSurgeryPerformedList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = otHandlerService.getOtListData();
		jsp = "otActualSurgeryPerformedList";
		jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getOTSchedule(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		mapForDS.put("deptId", deptId);
		String bookingDate = new String();
		int otId = 0;

		if (request.getParameter("bookingDate") != null)
			bookingDate = (String) request.getParameter("bookingDate");

		if (request.getParameter("OtName") != null)
			otId = Integer.parseInt("" + request.getParameter("OtName"));

		mapForDS.put("bookingDate", bookingDate);
		mapForDS.put("otId", otId);
		map = otHandlerService.getOTSchedule(mapForDS);

		jsp = "otListChange";
		jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("bookingDate", bookingDate);
		map.put("contentJsp", jsp);
		map.put("otName", otId);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
		// return null;
	}

	public ModelAndView getActualOTPerformedSchedule(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		mapForDS.put("deptId", deptId);
		String bookingDate = new String();

		if (request.getParameter("bookingDate") != null)
			bookingDate = (String) request.getParameter("bookingDate");

		//System.out.println("::::::::::::" + bookingDate);
		mapForDS.put("bookingDate", bookingDate);
		map = otHandlerService.getActualOTPerformedSchedule(mapForDS);

		jsp = "otActualSurgeryPerformedList";
		jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("bookingDate", bookingDate);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
		// return null;
	}

	public ModelAndView changeOTSchedule(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int bookingId = 0;
		int deptId = (Integer) session.getAttribute("deptId");
		String bookingDate = new String();
		map.put("deptId", deptId);
		if (request.getParameter("bookingId") != null) {
			bookingId = Integer.parseInt(request.getParameter("bookingId"));
		}
		if (request.getParameter("date") != null) {
			bookingDate = request.getParameter("date");
		}
		map.put("bookingId", bookingId);
		map.put("bookingDate", bookingDate);
		map = otHandlerService.changeOTSchedule(map);
		jsp = "otListChangeSub";
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	
	public ModelAndView showOTScheduleForUpdation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int bookingId = 0;
		int deptId = (Integer) session.getAttribute("deptId");
		String bookingDate = new String();
		map.put("deptId", deptId);
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			map.put("hospitalId", hospitalId);
		}
		if (request.getParameter("bookingId") != null) {
			bookingId = Integer.parseInt(request.getParameter("bookingId"));
		}
		if (request.getParameter("date") != null) {
			bookingDate = request.getParameter("date");
		}
		
		map.put("bookingId", bookingId);
		map.put("bookingDate", bookingDate);
		map = otHandlerService.getOTScheduleForUpdation(map);
		jsp = "updateOTSchedule";
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateOTSchedule(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = Integer.parseInt(request.getParameter("deptId1"));
		
Box box = HMSUtil.getBox(request);
		
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List empIdList = new ArrayList();
		List<String> roleList = new ArrayList<String>();
		mapForDS.put("box", box);
		String date = box.getString("surgeryDate");

		//int deptId = (Integer) (re.getAttribute("deptId"));
		
		
		int hospitalId = 0;
		int userId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		if (session.getAttribute(USER_ID) != null) {
			userId = (Integer) session.getAttribute(USER_ID);
		}
		int bookedById = 0;
		if (session.getAttribute("empId") != null) {
			bookedById = (Integer) session.getAttribute("empId");
		}
		mapForDS.put(HOSPITAL_ID, hospitalId);
		mapForDS.put(USER_ID, userId);
	    mapForDS.put("departmentId", deptId);
		box.put("bookedById", bookedById);
		int hiddenValue = 0;
		if (request.getParameter("hiddenValue") != null
				&& !request.getParameter("hiddenValue").equals("")) {
			hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
		}
		for (int i = 1; i <= hiddenValue; i++) {
			String surgeonName = request.getParameter("surgeonName" + i);
			if (surgeonName!=null && !surgeonName.equals("")) {
				int index1 = surgeonName.indexOf("[");
				index1 = index1 + 1;
				int index2 = surgeonName.lastIndexOf("]");
				String surgeonId = surgeonName.substring(index1, index2);
				int empId = Integer.parseInt(surgeonId);
				empIdList.add(empId);
				String role = request.getParameter("role" + i);
				if (!role.equals("")) {
					roleList.add(role);
				}
			}
			
			//System.out.println("ff"+surgeonName +empIdList.size());
		}
		mapForDS.put("empIdList", empIdList);
		mapForDS.put("roleList", roleList);

		map = otHandlerService.updateOTSchedule(mapForDS);
		boolean dataSaved = false;
		if (map.get("succesfullyAdded") != null)
			dataSaved = (Boolean) map.get("succesfullyAdded");

		if (dataSaved == true) {
			message= "Data Updated Successfully";
		}
		else
		{
			message= "Error In Submitting OT details.";
		}
		
		map = otHandlerService.showPACClearedListForOTBooking(mapForDS);
		map.put("message", message);
		jsp = OT_PAC_CLEARED_LIST_FOR_OT_BOOKING_JSP;
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		
	/*	jsp = "otListChange";
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);*/
	}

	public ModelAndView updateSurgeryDoneStatus(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		map = otHandlerService.updateSurgeryDoneStatus(box);

		boolean dataSaved = false;
		if (map.get("dataSaved") != null)
			dataSaved = (Boolean) map.get("dataSaved");

		if (dataSaved == true) {
			map.put("message", "Surgery Status Updated Successfully");
		}
		jsp = "otActualSurgeryPerformedList";
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView cancelOTSchedule(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int bookingId = 0;
		int deptId = (Integer) session.getAttribute("deptId");
		String bookingDate = new String();
		map.put("deptId", deptId);
		if (request.getParameter("bookingId") != null) {
			bookingId = Integer.parseInt(request.getParameter("bookingId"));
			box.put("bookingId", bookingId);
		}
		if (request.getParameter("date") != null) {
			bookingDate = request.getParameter("date");
		}
		map = otHandlerService.cancelOTSchedule(box);
		map.put("bookingId", bookingId);
		map.put("bookingDate", bookingDate);
		boolean dataSaved = false;
		if (map.get("dataSaved") != null) {
			dataSaved = (Boolean) map.get("dataSaved");
		}
		
		try
		{	
			PrintWriter pw = response.getWriter();
			pw.write("success~~~"+dataSaved);				
			
		}
		
		catch(Exception e)
		{		
			e.printStackTrace();
		}
		
		return null;
		
	/*	boolean dataSaved = false;
		if (map.get("dataSaved") != null)
			dataSaved = (Boolean) map.get("dataSaved");
		if (dataSaved == true) {
			map.put("message", "Data Updated Successfully");
		}
		jsp = "otListChange";
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);*/
	}

	/**
	 * -------------------------- PRE- ANAESTHESIA NOTES ENTRY PROCEDURE
	 * ----------------------
	 */
	public ModelAndView showOtPatientDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		String otProcedure = "";
		String serviceFName = "";
		String serviceMName = "";
		String serviceLName = "";
		Date surgeryDate = new Date();

		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put("hinNo", hinNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDS.put("serviceNo", serviceNo);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDS.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDS.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDS.put("patientLName", patientLName);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serviceFName = request.getParameter(S_FIRST_NAME);
				mapForDS.put("serviceFName", serviceFName);
			}
			if (request.getParameter(S_MIDDLE_NAME) != null
					&& !(request.getParameter(S_MIDDLE_NAME).equals(""))) {
				serviceMName = request.getParameter(S_MIDDLE_NAME);
				mapForDS.put("serviceMName", serviceMName);
			}
			if (request.getParameter(S_LAST_NAME) != null
					&& !(request.getParameter(S_LAST_NAME).equals(""))) {
				serviceLName = request.getParameter(S_LAST_NAME);
				mapForDS.put("serviceLName", serviceLName);
			}
			if (request.getParameter("surgeryDate") != null
					&& !(request.getParameter("surgeryDate").equals(""))) {
				surgeryDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter("surgeryDate"));
				mapForDS.put("surgeryDate", surgeryDate);
			}

			if (request.getParameter("otProcedure") != null
					&& !(request.getParameter("otProcedure").equals(""))) {
				otProcedure = request.getParameter("otProcedure");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if ((request.getParameter(HIN_NO) != null && !request.getParameter(
				HIN_NO).equals(""))
				|| (request.getParameter(SERVICE_NO) != null && !request
						.getParameter(SERVICE_NO).equals(""))
				|| (request.getParameter(P_FIRST_NAME) != null && !request
						.getParameter(P_FIRST_NAME).equals(""))
				|| (request.getParameter(P_MIDDLE_NAME) != null && !request
						.getParameter(P_MIDDLE_NAME).equals(""))
				|| (request.getParameter(P_LAST_NAME) != null && !request
						.getParameter(P_LAST_NAME).equals(""))
				|| (request.getParameter(S_FIRST_NAME) != null && !request
						.getParameter(S_FIRST_NAME).equals(""))
				|| (request.getParameter(S_MIDDLE_NAME) != null && !request
						.getParameter(S_MIDDLE_NAME).equals(""))
				|| (request.getParameter(S_LAST_NAME) != null && !request
						.getParameter(S_LAST_NAME).equals(""))
				|| (request.getParameter("surgeryDate") != null && !request
						.getParameter("surgeryDate").equals(""))) {
			patientMap = otHandlerService.searchOtPatientDetails(mapForDS);
		}
		map.put("otProcedure", otProcedure);
		String jsp = "";
		jsp = "ot_patientSearch" + ".jsp";

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOtProcedureNotesEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String otBookingId = "";
		if (request.getParameter("hinNo") != null) {
			otBookingId = request.getParameter("hinNo");
		}
		String yearlySerialNo = "";
		if (request.getParameter("yearlySerialNo") != null) {
			yearlySerialNo = request.getParameter("yearlySerialNo");
			mapForDS.put("yearlySerialNo", yearlySerialNo);
		}

		mapForDS.put("otBookingId", otBookingId);

		try {
			map = otHandlerService.showOtProcedureNotesEntryJsp(mapForDS);
			jsp = "OT_ProcedureNotesEntry";

			jsp += ".jsp";
			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getStoreItemForAutoComplete(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String itemNameField = "";
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}

			map.put("autoHint", autoHint);
			map = otHandlerService.getStoreItemForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "ot_responseForPvmsNo";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView fillStoreItem(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String rowVal = request.getParameter("rowVal");
		String itemNameWithId = request.getParameter("itemName" + rowVal);
		int index1 = itemNameWithId.lastIndexOf("[");
		int index2 = itemNameWithId.lastIndexOf("]");

		String storeItem = itemNameWithId.substring(0, index1);
		map = otHandlerService.getNomenclature(storeItem);
		jsp = "ot_responseForStoreItem";

		title = "Store Item Details";
		map.put("rowVal", rowVal);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitPreAneaesthesiaProcNotesEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String hinNo = request.getParameter("hinNo");
		String otProcedure = null;
		int hospitalId = 0;
		String yearlySerialNo = "";
		String[] pvmsNoId = request.getParameterValues("pvmsNoId");
		List<Integer> pvmsNoList = new ArrayList<Integer>();
		boolean dataSaved = false;

		int totalMasterIns = 0;
		int totalBanks = 0;
		int OpNotesId =0;
		String actualString ="";
		String receivedString ="";
		List<String> PreOpInstructionList = new ArrayList<String>();
		if (request.getParameter("totalPrevOPInstruction") !=null) {
			totalMasterIns = Integer.parseInt(request.getParameter("totalPrevOPInstruction"));
		}
			//totalMasterIns	
		for(int i= 1; i<=totalMasterIns;i++)
		{
			receivedString = null;
			actualString = null;
			
		   	if(request.getParameter("OpNotesId"+i)!=null && (request.getParameter("OpNotesId"+i)!=""))
		   	{
		   		OpNotesId = Integer.parseInt(request.getParameter("OpNotesId"+i));
		   		actualString = request.getParameter("actualValue"+i);
		   		receivedString ="";
		   		if(request.getParameter("totalBlank"+i)!=null && request.getParameter("totalBlank"+i)!="" &&  request.getParameter("totalBlank"+i)!="0" )
		   		{
		   			totalBanks = Integer.parseInt(request.getParameter("totalBlank"+i));
		   			for(int j=0;j<=totalBanks-1;j++)
		   			{
		   				if(request.getParameter(OpNotesId+"blank"+j)!=null && request.getParameter(OpNotesId+"blank"+j)!="")
		   				{
		   					//System.out.println("string "+request.getParameter(OpNotesId+"blank"+j) +" "+ OpNotesId+"blank"+j);
		   					String s = request.getParameter(OpNotesId+"blank"+j);
		   					receivedString +=request.getParameter(OpNotesId+"blank"+j)+" ";
		   				}
		   			}
		   		}
		   		
		 	}
		   	if(receivedString!=null && receivedString!="")
		   	{
		   		receivedString.trim();
		   		PreOpInstructionList.add(receivedString);
		   	}
		   	else
		   		PreOpInstructionList.add(actualString);
		  	
		 
		}
		
		int opHiddenValue = box.getInt("opHiddenValue");
		if(opHiddenValue>0)
		{
			for(int i=1; i<= opHiddenValue;i++)
			{
				if(box.getString("opInstruction" +i)!=null)
				{
					PreOpInstructionList.add(box.getString("opInstruction" +i));
					
				}
			}
			
			//hbt.saveOrUpdateAll(opInstructionList);
		}
		
		
		//List<String> pvmsNoList = new ArrayList<String>();
		List<Integer> frequencyList = new ArrayList<Integer>();
		List<String> dosageList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();
		List<String> typeLeftRightList = new ArrayList<String>();
		List<String> instructionList = new ArrayList<String>();
		List<Integer> totalList = new ArrayList<Integer>();
		List<Integer> noOfDaysList = new ArrayList<Integer>();
		List<String> routeList = new ArrayList<String>();
		List<Integer> itemConversionList = new ArrayList<Integer>();
		List<Integer> itemClassList = new ArrayList<Integer>();
		List<String> itemDispensaryList = new ArrayList<String>();

	/*	String[] diagnosisIdAray = null;

		if (request.getParameterValues(DIAGNOSIS_ID) != null) {
			diagnosisIdAray = (String[]) request
					.getParameterValues(DIAGNOSIS_ID);
		}*/

		int nomenclaturehdb = 1;
		if (Integer.parseInt(request.getParameter("nomenclaturehdb")) != 1) {
			nomenclaturehdb = Integer.parseInt(request.getParameter("nomenclaturehdb"));
		}
		//String[] pvmsArr = new String[nomenclaturehdb];
		//Integer[] itemIdArr = new Integer[nomenclaturehdb];
		String otherMedicine = "";
		List<String> otherMedicineList = new ArrayList<String>();
		List<String> ctList = new ArrayList<String>();
		// List<String> nomenclatureList = new ArrayList<String>();
		List<Integer> itemIdList = new ArrayList<Integer>();
		List<Integer> classificationList = new ArrayList<Integer>();
		// List injCategoryList = new ArrayList();
		int j = 1;
		for (int i = 0; i < nomenclaturehdb; i++) {
		//	String pvmsNo = "";
			int itemId = 0;
	

			if (request.getParameter("itemId" + j) != null
					&& !request.getParameter("nomenclature" + j).equals("")) {
				itemId = Integer.parseInt(request.getParameter("itemId" + j));
				if (itemId != 0) {
					itemIdList.add(itemId);
				}

				if (request.getParameter("itemIdClassificationId" + j) != null
						&& !request.getParameter("itemIdClassificationId" + j)
								.equals("")) {
					classificationList.add(Integer.parseInt(request
							.getParameter("itemIdClassificationId" + j)));
				} else
					classificationList.add(0);
				/*otherMedicineList.add(otherMedicine);*/
			} else {
				if (request.getParameter("otherMedicine" + j) != null
						&& !request.getParameter("otherMedicine" + j)
								.equals("")) {
					otherMedicine = request.getParameter("otherMedicine" + j);
					otherMedicineList.add(otherMedicine);

				}

			}
			
			if((request.getParameter("itemId" + j) != null && !request.getParameter("nomenclature" + j).equals("")) || (request.getParameter("otherMedicine" + j) != null && !request.getParameter("otherMedicine" + j).equals("")) )
			{
			int itemConversionId = 0;
			if (request.getParameter("itemConversionId" + j) != null
					&& !request.getParameter("itemConversionId" + j).equals("")) {
				itemConversionId = Integer.parseInt(request
						.getParameter("itemConversionId" + j));
				itemConversionList.add(itemConversionId);
			}
			else
				itemConversionList.add(0);
			if (request.getParameter("itemClass" + j) != null
					&& !request.getParameter("itemClass" + j).equals("")) {
				itemClassList.add(Integer.parseInt(request
						.getParameter("itemClass" + j)));
			}
			else
				itemClassList.add(0);

			if (request.getParameter("dispensingUnit" + j) != null) {
				itemDispensaryList.add(request.getParameter("dispensingUnit"
						+ j));
			}
			else
				itemDispensaryList.add("");
			int frequencyId = 0;
			if (request.getParameter("frequency" + j) != null
					&& !request.getParameter("frequency" + j).equals("")) {
				frequencyId = Integer.parseInt(request.getParameter("frequency"
						+ j));
				frequencyList.add(frequencyId);
			} else {
				frequencyList.add(0);
			}
			if (request.getParameter("ct" + j) != null) {
				ctList.add("y");
			} else {
				ctList.add("n");
			}

			String route = "";
			if (request.getParameter("route" + j) != null
					&& !request.getParameter("route" + j).equals("")) {
				route = request.getParameter("route" + j);
				routeList.add(route);
			} else {
				routeList.add("");
			}

			BigDecimal frequenceValue = new BigDecimal("0");
			if (request.getParameter("frequencyValue" + j) != null
					&& !request.getParameter("frequencyValue" + j).equals("")) {
				frequenceValue = new BigDecimal(
						request.getParameter("frequencyValue" + j));
			}

			String dosage = "";
			if (request.getParameter("dosage" + j) != null
					&& !request.getParameter("dosage" + j).equals("")) {
				dosage = request.getParameter("dosage" + j);
				dosageList.add(dosage);
			} else {
				dosageList.add("");
			}
			if (request.getParameter("noOfDays" + j) != null
					&& !request.getParameter("noOfDays" + j).equals("")) {
				int noOfDays = Integer.parseInt(request.getParameter("noOfDays"
						+ j));
				noOfDaysList.add(noOfDays);
				// int noOfdoges=1;
				// if(dosage!=null && dosage!=""){
				// noOfdoges=Integer.parseInt(dosage);
				// }
				// int total = noOfDays * frequenceValue*noOfdoges;
				// totalList.add(total);

			} else {
				noOfDaysList.add(0);
			}
			if (request.getParameter("total" + j) != null
					&& !request.getParameter("total" + j).equals("")) {
				int total = Math.round(Float.parseFloat(request
						.getParameter("total" + j)));
				totalList.add(total);
			} else {
				totalList.add(0);
			}

			String remarks = "";
			if (request.getParameter("remarks" + j) != null
					&& !request.getParameter("remarks" + j).equals("")) {
				remarks = request.getParameter("remarks" + j);
				remarksList.add(remarks);
			} else {
				remarksList.add("");
			}
		}
			// if(!pvmsNo.equals("")){
			// pvmsNoList.add(pvmsNo);
			// }
			// pvmsNoList.add(pvmsArr[i]);

			j++;
		}
		
		

		
		//capture NIP
					j =500;
					int n=itemIdList.size();
							int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		
		for ( j = 500; j <=hdb; j++) {
		//	String pvmsNo = "";
			int itemId = 0;

			if (request.getParameter("itemId" + j) != null
					&& !request.getParameter("nomenclature" + j).equals("")) {
				itemId = Integer.parseInt(request.getParameter("itemId" + j));
				if (itemId != 0) {
					itemIdList.add(itemId);
				}

				if (request.getParameter("itemIdClassificationId" + j) != null
						&& !request.getParameter("itemIdClassificationId" + j)
								.equals("")) {
					classificationList.add(Integer.parseInt(request
							.getParameter("itemIdClassificationId" + j)));
				} else
					classificationList.add(0);
				/*otherMedicineList.add(otherMedicine);*/
			} else {
				if (request.getParameter("otherMedicine" + j) != null
						&& !request.getParameter("otherMedicine" + j)
								.equals("")) {
					otherMedicine = request.getParameter("otherMedicine" + j);
					otherMedicineList.add(otherMedicine);
					/*otherMedicineList.add(n,otherMedicine);*/

				}

			}
			
			if((request.getParameter("itemId" + j) != null && !request.getParameter("nomenclature" + j).equals("")) || (request.getParameter("otherMedicine" + j) != null && !request.getParameter("otherMedicine" + j).equals("")) )
			{
			int itemConversionId = 0;
			if (request.getParameter("itemConversionId" + j) != null
					&& !request.getParameter("itemConversionId" + j).equals("")) {
				itemConversionId = Integer.parseInt(request
						.getParameter("itemConversionId" + j));
				itemConversionList.add(itemConversionId);
			}
			else
				itemConversionList.add(0);
			if (request.getParameter("itemClass" + j) != null
					&& !request.getParameter("itemClass" + j).equals("")) {
				itemClassList.add(Integer.parseInt(request
						.getParameter("itemClass" + j)));
			}
			else
				itemClassList.add(0);
			if (request.getParameter("dispensingUnit" + j) != null) {
				itemDispensaryList.add(request.getParameter("dispensingUnit"
						+ j));
			}
			else
				itemDispensaryList.add("");
			
			int frequencyId = 0;
			if (request.getParameter("frequency" + j) != null
					&& !request.getParameter("frequency" + j).equals("")) {
				frequencyId = Integer.parseInt(request.getParameter("frequency"
						+ j));
				frequencyList.add(frequencyId);
			} else {
				frequencyList.add(0);
			}
			if (request.getParameter("ct" + j) != null) {
				ctList.add("y");
			} else {
				ctList.add("n");
			}

			String route = "";
			if (request.getParameter("route" + j) != null
					&& !request.getParameter("route" + j).equals("")) {
				route = request.getParameter("route" + j);
				routeList.add(route);
			} else {
				routeList.add("");
			}

			/*BigDecimal frequenceValue = new BigDecimal("0");
			if (request.getParameter("frequencyValue" + j) != null
					&& !request.getParameter("frequencyValue" + j).equals("")) {
				frequenceValue = new BigDecimal(
						request.getParameter("frequencyValue" + j));
			}*/

			String dosage = "";
			if (request.getParameter("dosage" + j) != null
					&& !request.getParameter("dosage" + j).equals("")) {
				dosage = request.getParameter("dosage" + j);
				dosageList.add(dosage);
			} else {
				dosageList.add("");
			}
			if (request.getParameter("noOfDays" + j) != null
					&& !request.getParameter("noOfDays" + j).equals("")) {
				int noOfDays = Integer.parseInt(request.getParameter("noOfDays"
						+ j));
				noOfDaysList.add(noOfDays);
				// int noOfdoges=1;
				// if(dosage!=null && dosage!=""){
				// noOfdoges=Integer.parseInt(dosage);
				// }
				// int total = noOfDays * frequenceValue*noOfdoges;
				// totalList.add(total);

			} else {
				noOfDaysList.add(0);
			}
			if (request.getParameter("total" + j) != null
					&& !request.getParameter("total" + j).equals("")) {
				int total = Math.round(Float.parseFloat(request
						.getParameter("total" + j)));
				totalList.add(total);
			} else {
				totalList.add(0);
			}

			String remarks = "";
			if (request.getParameter("remarks" + j) != null
					&& !request.getParameter("remarks" + j).equals("")) {
				remarks = request.getParameter("remarks" + j);
				remarksList.add(remarks);
			} else {
				remarksList.add("");
			}
		}
			// if(!pvmsNo.equals("")){
			// pvmsNoList.add(pvmsNo);
			// }
			// pvmsNoList.add(pvmsArr[i]);

			//j++;
			//n++;
		}
		
		mapForDS.put("routeList", routeList);
		mapForDS.put("frequencyList", frequencyList);
		mapForDS.put("ctList", ctList);
		mapForDS.put("dosageList", dosageList);
		mapForDS.put("itemIdList", itemIdList);
		mapForDS.put("classificationList", classificationList);
		mapForDS.put("totalList", totalList);
		mapForDS.put("noOfDaysList", noOfDaysList);
		mapForDS.put("remarksList", remarksList);
		mapForDS.put("otherMedicineList", otherMedicineList);
		// mapForDS.put("nomenclatureList", nomenclatureList);
		mapForDS.put("itemConversionList", itemConversionList);
		mapForDS.put("itemClassList", itemClassList);
		mapForDS.put("itemDispensaryList", itemDispensaryList);
		
		 int empId = 0;
/*		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		String[] pvmsArr = new String[hdb];
		Integer[] itemIdArr = new Integer[hdb];
		String otherMedicine = "";
		List<String> otherMedicineList = new ArrayList<String>();
		List<String> ctList = new ArrayList<String>();
		List<String> nomenclatureList = new ArrayList<String>();
		List<Integer> itemIdList = new ArrayList<Integer>();
		
		
		List<Integer> frequencyList = new ArrayList<Integer>();
		List<String> dosageList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();
		List<String> typeLeftRightList = new ArrayList<String>();
		List<String> instructionList = new ArrayList<String>();
		List<Integer> totalList = new ArrayList<Integer>();
		List<Integer> noOfDaysList = new ArrayList<Integer>();
		List<String> routeList = new ArrayList<String>();
		List<Integer> itemConversionList = new ArrayList<Integer>();
		List<Integer> itemClassList = new ArrayList<Integer>();
		List<String> itemDispensaryList = new ArrayList<String>();
		
	
			int j = 1;
			for (int i = 0; i < hdb; i++) {
				String pvmsNo = "";
				int itemId = 0;
				
				if (request.getParameter("itemId" + j) != null && !request.getParameter("nomenclature" + j).equals("")) {
					 itemId =Integer.parseInt(request.getParameter("itemId" + j));
					if (itemId != 0) {
						itemIdList.add(itemId);
					}
					
				}
				else{
					if(request.getParameter("otherMedicine"+ j) != null && !request.getParameter("otherMedicine"+ j).equals("")){
						otherMedicine = request.getParameter("otherMedicine"+ j);
						otherMedicineList.add(otherMedicine);
					}

					
				}
				int itemConversionId = 0;
				if(request.getParameter("itemConversionId" + j) != null && !request.getParameter("itemConversionId" + j).equals("")){
					itemConversionId =Integer.parseInt(request.getParameter("itemConversionId" + j));
					itemConversionList.add(itemConversionId);
				}	
				
				if(request.getParameter("itemClass"+ j) != null && !request.getParameter("itemClass"+ j).equals("")){
					itemClassList.add(Integer.parseInt(request.getParameter("itemClass"+ j)));
				}
				
				
				if(request.getParameter("dispensingUnit"+ j) != null ){
					itemDispensaryList.add(request.getParameter("dispensingUnit"+ j));
				}
			
				
				int frequencyId = 0;
				if(request.getParameter("frequency" + j) != null && !request.getParameter("frequency" + j).equals("")){
					frequencyId = Integer.parseInt(request.getParameter("frequency" + j));
					frequencyList.add(frequencyId);
				}
				if(request.getParameter("ct" + j) != null){
					ctList.add("y");
				}	else {
					ctList.add("n");
				}

				String route = "";
				if(request.getParameter("route" + j) != null && !request.getParameter("route" + j).equals("")){
					route = request.getParameter("route" + j);
					routeList.add(route);
				}	else {
					routeList.add("");
				}
				
				BigDecimal frequenceValue = new BigDecimal("0");
				if(request.getParameter("frequencyValue" + j) != null && !request.getParameter("frequencyValue" + j).equals("")){
					frequenceValue = new BigDecimal(request.getParameter("frequencyValue" + j));
				}	
				
				String dosage = "";
				if(request.getParameter("dosage" + j) != null && !request.getParameter("dosage" + j).equals("")){
					dosage = request.getParameter("dosage" + j);
					dosageList.add(dosage);
				}else{
					dosageList.add("");
				}
				if(request.getParameter("noOfDays" + j) != null && !request.getParameter("noOfDays" + j).equals("")){
					int noOfDays = Integer.parseInt(request.getParameter("noOfDays" + j));
					noOfDaysList.add(noOfDays);
					//int noOfdoges=1;
					//if(dosage!=null && dosage!=""){
						//noOfdoges=Integer.parseInt(dosage);
					//}
					//int total = noOfDays * frequenceValue*noOfdoges;
					//totalList.add(total);
					
				}else {
					noOfDaysList.add(0);
				}
				if(request.getParameter("total" + j) != null && !request.getParameter("total" + j).equals("")){
					int total = Math.round(Float.parseFloat(request.getParameter("total" + j)));
					totalList.add(total);
				}else {
					totalList.add(0);
				}
				
			
				String remarks = "";
				if(request.getParameter("remarks" + j) != null && !request.getParameter("remarks" + j).equals("")){
					remarks = request.getParameter("remarks" + j);
					remarksList.add(remarks);
				}else {
					remarksList.add("");
				}

			
				//if(!pvmsNo.equals("")){
					//pvmsNoList.add(pvmsNo);
				//}
				//	pvmsNoList.add(pvmsArr[i]);

				j++;
			}
		
		mapForDS.put("itemIdList", itemIdList);
		mapForDS.put("frequencyList", frequencyList);
		mapForDS.put("ctList", ctList);
		mapForDS.put("dosageList", dosageList);
		mapForDS.put("typeLeftRightList", typeLeftRightList);
		mapForDS.put("instructionList", instructionList);
		mapForDS.put("routeList", routeList);
		mapForDS.put("totalList", totalList);
		mapForDS.put("noOfDaysList", noOfDaysList);
		mapForDS.put("otherMedicineList", otherMedicineList);
		mapForDS.put("nomenclatureList", nomenclatureList);
		mapForDS.put("itemConversionList", itemConversionList);
		mapForDS.put("itemClassList", itemClassList);
		mapForDS.put("itemDispensaryList", itemDispensaryList);
		mapForDS.put("remarksList", remarksList);*/
		
		mapForDS.put("PreOpInstructionList", PreOpInstructionList);
		
	/*	for (int i = 0; i < pvmsNoId.length; i++) {
			int pvmsNo = Integer.parseInt(pvmsNoId[i]);
			pvmsNoList.add(pvmsNo);
		}*/
		if (request.getParameter("otProcedure") != null
				&& !(request.getParameter("otProcedure").equals(""))) {
			otProcedure = request.getParameter("otProcedure");
		}

		if (request.getParameter("yearlySqNo") != null) {
			yearlySerialNo = request.getParameter("yearlySqNo");
			mapForDS.put("yearlySerialNo", yearlySerialNo);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			mapForDS.put("userName", userName);
		}
		mapForDS.put("hinNo", hinNo);

	
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			mapForDS.put(HOSPITAL_ID, hospitalId);
		}


		if (session.getAttribute("empId") != null) {
			empId = (Integer)session.getAttribute("empId");
			mapForDS.put("empId", empId);
			
		}
		
	
		int departmentId = 0;
		if (session.getAttribute("deptId") != null) {
			 departmentId = (Integer) session.getAttribute("deptId");
				mapForDS.put("deptId", departmentId);
			
		}
		
		int userId = 0;
		if (session.getAttribute(USER_ID) != null) {
			userId = (Integer) session.getAttribute(USER_ID);
			mapForDS.put(USER_ID, userId);
			
		}
		
		mapForDS.put("box", box);
		
		
		
		try {
			map = otHandlerService.submitPreAneaesthesiaProcNotesEntryJsp(mapForDS);
				
			map.put("otProcedure", "no");
			if (map.get("dataSaved") != null) {
				dataSaved = (Boolean) map.get("dataSaved");
			}
			if (dataSaved == true) {
//				message = "Data Saved Sucessfully!! Do you want to print?";
				message = "Data Saved Sucessfully!!";
				map.put("message", message);
			}
			jsp = OT_MSG_PRE_ANESTHESIA;
			jsp += ".jsp";
			map.put("yearlySerialNo", yearlySerialNo);
			//map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			map.put("title", title);
			//pacsTest(request, response);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ------------------------------- OT PROCEDURE NOTES ENTRY
	 * --------------------
	 */
	public ModelAndView showPreAneaesthesiaProcNotesEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
	    Map<String, Object> mapForDS = new HashMap<String, Object>();
		int bookingId = Integer.parseInt(request.getParameter("surgeryHdId"));
		String yearlySerialNo = "";
		if (request.getParameter("yearlySerialNo") != null) {
			yearlySerialNo = request.getParameter("yearlySerialNo");
			mapForDS.put("yearlySerialNo", yearlySerialNo);
		}
		 
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDS.put(HOSPITAL_ID, hospitalId);
		mapForDS.put("bookingId", bookingId);
		try {
			map = otHandlerService
					.showPreAneaesthesiaProcNotesEntryJsp(mapForDS);
			jsp = "OT_preAnaesthesiaProcedureNotesEntry";

			jsp += ".jsp";
		 
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getEmpNameForAutoComplete(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String itemNameField = "";
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			map.put("autoHint", autoHint);
			map = otHandlerService.getEmpNameForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "ot_responseForEmployee";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitOtProcedureNotesEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String hinNo = request.getParameter("hinNo");

		int count = Integer.parseInt(request.getParameter("hiddenValue"));
		List<Integer> employeeId = new ArrayList<Integer>();
		String employeeName = null;
		String otProcedure = null;
		boolean dataSaved = false;

		for (int i = 1; i <= count; i++) {
			if (request.getParameter("empName" + i) != null) {
				int start = 0;
				int end = 0;
				employeeName = request.getParameter("empName" + i);
				start = employeeName.lastIndexOf("[");
				end = employeeName.lastIndexOf("]");
				employeeId.add(Integer.parseInt(employeeName.substring(
						start + 1, end)));
			}
		}

		if (request.getParameter("otProcedure") != null
				&& !(request.getParameter("otProcedure").equals(""))) {
			otProcedure = request.getParameter("otProcedure");
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", session.getAttribute("hospitalId"));
		try {
			map = otHandlerService.submitOtProcedureNotesEntryJsp(box,
					employeeId);
			if (map.get("dataSaved") != null) {
				dataSaved = (Boolean) map.get("dataSaved");
			}
			if (dataSaved == true) {
				message = "Post OP Notes (Surgery) Saved Sucessfully!!";
				map.put("message", message);
			}
			jsp = OT_MSG_OT_PROCEDURE;

			jsp += ".jsp";
			map.put("deptId", deptId);
			map.put("otProcedure", otProcedure);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateOtProcedureNotesEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");

		int count = Integer.parseInt(request.getParameter("hiddenValue"));
		List<Integer> employeeId = new ArrayList<Integer>();
		String employeeName = null;

		boolean dataSaved = false;

		for (int i = 1; i <= count; i++) {
			if (request.getParameter("empName" + i) != null) {
				int start = 0;
				int end = 0;
				employeeName = request.getParameter("empName" + i);
				start = employeeName.lastIndexOf("[");
				end = employeeName.lastIndexOf("]");
				employeeId.add(Integer.parseInt(employeeName.substring(
						start + 1, end)));
			}
		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", session.getAttribute("hospitalId"));
		try {
			map = otHandlerService.updateOtProcedureNotesEntryJsp(box,
					employeeId);
			if (map.get("dataSaved") != null) {
				dataSaved = (Boolean) map.get("dataSaved");
			}
			if (dataSaved == true) {
				message = "Post OP Notes (Surgery) Entry Updated Sucessfully!!";
				map.put("message", message);
			}
			jsp = OT_MSG_OT_PROCEDURE_UPDATE;

			jsp += ".jsp";
			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	
	
	public ModelAndView searchOtProcedureNotes(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "ot_procedureNotesSearch" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getOtProcedureDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		String yearlyNo = "";
		try {
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				detailsMap.put("serviceNo", serviceNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				detailsMap.put("hinNo", hinNo);
			}
			if (request.getParameter("yearlySerialNo") != null
					&& !(request.getParameter("yearlySerialNo").equals(""))) {
				yearlyNo = request.getParameter("yearlySerialNo");
				detailsMap.put("yearlySerialNo", yearlyNo);
			}
			List<Object> yearlySerialNoList = new ArrayList<Object>();
			List<String> hinNoList = new ArrayList<String>();
			List<Object> patientDetailList = new ArrayList<Object>();
			String flag = "";

			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("yearlySerialNo")) {
				yearlySerialNoList = otHandlerService
						.getYearlySerialNoList(detailsMap);
				map.put("yearlySerialNoList", yearlySerialNoList);
				jsp = "ot_responseForYearlySerialNo";

			} else if (flag.equals("hin")) {
				hinNoList = otHandlerService.getOtProcHinNoList(serviceNo);
				map.put("hinNoList", hinNoList);

				jsp = "ot_responseForProcHinNo";

			} else if (flag.equals("patientDetail")) {
				patientDetailList = otHandlerService
						.getOtProcPatientDetailList(detailsMap);
				map.put("patientDetailList", patientDetailList);

				jsp = "ot_responseForPatientDetails";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView searchPreAnaesthesiaProcedureNotes(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "ot_PreAnaesthesiaProcedureNotesSearch" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPreAnaesthesiaProcedureDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		String yearlyNo = "";
		try {
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				detailsMap.put("serviceNo", serviceNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				detailsMap.put("hinNo", hinNo);
			}
			if (request.getParameter("yearlySerialNo") != null
					&& !(request.getParameter("yearlySerialNo").equals(""))) {
				yearlyNo = request.getParameter("yearlySerialNo");
				detailsMap.put("yearlySerialNo", yearlyNo);
			}
			List<Object> yearlySerialNoList = new ArrayList<Object>();
			List<String> hinNoList = new ArrayList<String>();
			List<Object> patientDetailList = new ArrayList<Object>();
			String flag = "";

			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("yearlySerialNo")) {
				yearlySerialNoList = otHandlerService
						.getPreAnaesthesiaYearlySerialNoList(detailsMap);
				map.put("yearlySerialNoList", yearlySerialNoList);
				jsp = "ot_responseForPreAnasesthesiaYearlySerialNo";

			} else if (flag.equals("hin")) {
				hinNoList = otHandlerService
						.getPreAnaesthesiaHinNoList(serviceNo);
				map.put("hinNoList", hinNoList);

				jsp = "ot_responseForPreAnasesthesiaProcHinNo";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);

	}

	/*
	 * ------------------------------------------------ Post Anaesthesia
	 * Patient---------------------------
	 */
	public ModelAndView showOtPostAnaesthesiaPatientSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();

		//Map<String, Object> detailsMap = new HashMap<String, Object>();

		// String serviceNo = "";
	
		int otId = 0;

		try {
			
			if(request.getParameter(PATIENT_NAME)!=null && !request.getParameter(PATIENT_NAME).equals(""))
			{
				mapForDS.put(PATIENT_NAME, request.getParameter(PATIENT_NAME));
			}
			
			if(request.getParameter(EMPLOYEE_ID) !=null && !request.getParameter(EMPLOYEE_ID).equals("")){
				mapForDS.put(EMPLOYEE_ID, request.getParameter(EMPLOYEE_ID));
			}
			if(request.getParameter(SURGERY_DATE) !=null  && !request.getParameter(SURGERY_DATE).equals("")){
				mapForDS.put(SURGERY_DATE, request.getParameter(SURGERY_DATE));
			}
			
			if(request.getParameter(OT_ID) !=null  && !request.getParameter(OT_ID).equals("")){
				otId = Integer.parseInt(request.getParameter(OT_ID));
				mapForDS.put(OT_ID, otId);
			}
			
			mapForDS.put(HOSPITAL_ID, (Integer)session.getAttribute(HOSPITAL_ID));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		map = otHandlerService.searchPostAnaesthesiaPatientDetails(mapForDS);

		String jsp = OT_POST_ANAESTHESIA_PATIENT_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		//map.put("patientMap", patientMap);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showPostAnaesthesiaPatientDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		Date surgeryDate = new Date();
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		String serviceFName = "";
		String serviceMName = "";
		String serviceLName = "";

		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put("hinNo", hinNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDS.put("serviceNo", serviceNo);
			}

			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDS.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDS.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDS.put("patientLName", patientLName);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serviceFName = request.getParameter(S_FIRST_NAME);
				mapForDS.put("serviceFName", serviceFName);
			}
			if (request.getParameter(S_MIDDLE_NAME) != null
					&& !(request.getParameter(S_MIDDLE_NAME).equals(""))) {
				serviceMName = request.getParameter(S_MIDDLE_NAME);
				mapForDS.put("serviceMName", serviceMName);
			}
			if (request.getParameter(S_LAST_NAME) != null
					&& !(request.getParameter(S_LAST_NAME).equals(""))) {
				serviceLName = request.getParameter(S_LAST_NAME);
				mapForDS.put("serviceLName", serviceLName);
			}
			if (request.getParameter("surgeryDate") != null
					&& !(request.getParameter("surgeryDate").equals(""))) {
				surgeryDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter("surgeryDate"));
				mapForDS.put("surgeryDate", surgeryDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = otHandlerService
				.searchPostAnaesthesiaPatientDetails(mapForDS);
		String jsp = "";
		jsp = OT_POST_ANAESTHESIA_PATIENT_SEARCH_JSP + ".jsp";

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView showPostAnaesthesiaJspFromPatientList(
			HttpServletRequest request, HttpServletResponse response) {

			HttpSession session = request.getSession();
		    Map<String, Object> mapForDS = new HashMap<String, Object>();
			int bookingId = Integer.parseInt(request.getParameter("bookingId"));
			String yearlySerialNo = "";
			if (request.getParameter("yearlySerialNo") != null) {
				yearlySerialNo = request.getParameter("yearlySerialNo");
				mapForDS.put("yearlySerialNo", yearlySerialNo);
			}
			 
			int hospitalId = 0;
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			mapForDS.put(HOSPITAL_ID, hospitalId);
			mapForDS.put("bookingId", bookingId);
			try {
				map = otHandlerService
						.showPostAneaesthesiaProcNotesEntryJsp(mapForDS);
				jsp = "ot_PostAnaesthesiaForInpatient";
				
//OT_preAnaesthesiaProcedureNotesEntry
				jsp += ".jsp";
			 
				map.put("contentJsp", jsp);
				map.put("title", title);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			return new ModelAndView("index", "map", map);

	}

	public ModelAndView showPACDetailJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		int visitId = 0;
		int inpatientId = 0;
		if (request.getParameter("visitId") != null) {
			//System.out.println("entered in visit");
			visitId = Integer.parseInt(request.getParameter("visitId"));
			map = otHandlerService.showPACDetailJsp(orderNo, hinId, visitId);
			map.put("visitId", visitId);
		} else if (request.getParameter("inpatientId") != null) {
			//System.out.println("entered in inpatient");
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			map = otHandlerService.showPACDetailInJsp(orderNo, hinId,
					inpatientId);
			map.put("inpatientId", inpatientId);
		}
		jsp = "pacDetail";
		jsp = jsp + ".jsp";
		title = "PAC List";
		map.put("orderNo", orderNo);
		map.put("hinId", hinId);

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unused")
	public ModelAndView fillChargeCode(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String rowVal = request.getParameter("rowVal");
		String chargeCodeNameWithId = request.getParameter("chargeCodeName"
				+ rowVal);

		int index1 = chargeCodeNameWithId.lastIndexOf("[");
		int index2 = chargeCodeNameWithId.lastIndexOf("]");

		String chargeCodeName = chargeCodeNameWithId.substring(0, index1);
		map = otHandlerService.getChargeCodeValue(chargeCodeName);

		jsp = OT_RESPONSE_FOR_CHARGE_CODE_NAME_JSP;

		title = "Patient Surgey Details";
		map.put("rowVal", rowVal);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	@SuppressWarnings("unused")
	public ModelAndView getSurgeyForAutoComplete(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
				//System.out.println("itemNameField---->" + itemNameField);
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}

			map.put("autoHint", autoHint);
			map = otHandlerService.getSurgeyForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_RESPONSE_FOR_SURGEY_JSP;

		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView fillEmpNameAnesthesiologist(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String rowVal = request.getParameter("rowVal");
		String empNameWithId = request.getParameter("empName" + rowVal);

		int index1 = empNameWithId.lastIndexOf("[");
		int index2 = empNameWithId.lastIndexOf("]");

		String empName = empNameWithId.substring(0, index1);
		map = otHandlerService.getEmpValue(empName);

		jsp = OT_RESPONSE_FOR_EMP_NAME_JSP;

		title = "Patient Surgeon Details";
		map.put("rowVal", rowVal);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	@SuppressWarnings("unused")
	public ModelAndView getAnesthesiologistForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}

			map.put("autoHint", autoHint);
			map = otHandlerService.getAnesthesiologistForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_RESPONSE_FOR_SURGEON_JSP;

		return new ModelAndView(jsp, "map", map);
	}
	@SuppressWarnings("unused")
	public ModelAndView fillEmpNameSergon(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String rowVal = request.getParameter("rowVal");
		String empNameWithId = request.getParameter("empNameS" + rowVal);

		int index1 = empNameWithId.lastIndexOf("[");
		int index2 = empNameWithId.lastIndexOf("]");

		String empName = empNameWithId.substring(0, index1);
		map = otHandlerService.getEmpValue(empName);

		jsp = OT_RESPONSE_FOR_EMP_NAME_JSP;

		title = "Patient Surgeon Details";
		map.put("rowVal", rowVal);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView fillEmpNameSergonForPostAnesthesia(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String rowVal = request.getParameter("rowVal");
		String empNameWithId = request.getParameter("empNameS" + rowVal);
		Integer empId = 0;
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		int index1 = empNameWithId.lastIndexOf("[");
		int index2 = empNameWithId.lastIndexOf("]");

		index1++;
		empId = Integer.parseInt(empNameWithId.substring(index1, index2));
		mapForDs.put("empId", empId);

		String empName = empNameWithId.substring(0, index1);
		mapForDs.put("empName", empName);

		map = otHandlerService.getEmpValueForPostAnesthesia(mapForDs);

		jsp = OT_RESPONSE_FOR_EMP_NAME_FOR_POST_ANESTHESIA_JSP;

		title = "Patient Surgeon Details";
		map.put("rowVal", rowVal);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView fillEmpNameAnesthesiologistForPostAnesthesia(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String rowVal = request.getParameter("rowVal");
		String empNameWithId = request.getParameter("empName" + rowVal);
		Integer empId = 0;
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		int index1 = empNameWithId.lastIndexOf("[");
		int index2 = empNameWithId.lastIndexOf("]");

		index1++;
		empId = Integer.parseInt(empNameWithId.substring(index1, index2));
		mapForDs.put("empId", empId);

		String empName = empNameWithId.substring(0, index1);
		mapForDs.put("empName", empName);

		map = otHandlerService.getEmpValueForPostAnesthesia(mapForDs);

		jsp = OT_RESPONSE_FOR_EMP_NAME_FOR_POST_ANESTHESIA_JSP;

		title = "Patient Surgeon Details";
		map.put("rowVal", rowVal);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView getSergonForAutoComplete(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}

			map.put("autoHint", autoHint);
			map = otHandlerService.getSurgeonForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_RESPONSE_FOR_SURGEON_JSP;

		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView submitOtPostAnesthesiaProcedure(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		//String hinNo = request.getParameter("hinNo");
		String otProcedure = null;
		int hospitalId = 0;
		String yearlySerialNo = "";
		String[] pvmsNoId = request.getParameterValues("pvmsNoId");
		List<Integer> pvmsNoList = new ArrayList<Integer>();
		boolean dataSaved = false;
/*
		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		String[] pvmsArr = new String[hdb];
		Integer[] itemIdArr = new Integer[hdb];
		String otherMedicine = "";
		List<String> otherMedicineList = new ArrayList<String>();
		List<String> ctList = new ArrayList<String>();
		List<String> nomenclatureList = new ArrayList<String>();
		List<Integer> itemIdList = new ArrayList<Integer>();
		
		
		List<Integer> frequencyList = new ArrayList<Integer>();
		List<String> dosageList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();
		List<String> typeLeftRightList = new ArrayList<String>();
		List<String> instructionList = new ArrayList<String>();
		List<Integer> totalList = new ArrayList<Integer>();
		List<Integer> noOfDaysList = new ArrayList<Integer>();
		List<String> routeList = new ArrayList<String>();
		List<Integer> itemConversionList = new ArrayList<Integer>();
		List<Integer> itemClassList = new ArrayList<Integer>();
		List<String> itemDispensaryList = new ArrayList<String>();

		//List injCategoryList = new ArrayList();
		
		
		int j = 1;
		for (int i = 0; i < hdb; i++) {
			String pvmsNo = "";
			int itemId = 0;
			
			if (request.getParameter("itemId" + j) != null && !request.getParameter("nomenclature" + j).equals("")) {
				 itemId =Integer.parseInt(request.getParameter("itemId" + j));
				if (itemId != 0) {
					itemIdList.add(itemId);
				}
				
			}
			else{
				if(request.getParameter("otherMedicine"+ j) != null && !request.getParameter("otherMedicine"+ j).equals("")){
					otherMedicine = request.getParameter("otherMedicine"+ j);
					otherMedicineList.add(otherMedicine);
				}

				
			}
			int itemConversionId = 0;
			if(request.getParameter("itemConversionId" + j) != null && !request.getParameter("itemConversionId" + j).equals("")){
				itemConversionId =Integer.parseInt(request.getParameter("itemConversionId" + j));
				itemConversionList.add(itemConversionId);
			}	
			
			if(request.getParameter("itemClass"+ j) != null && !request.getParameter("itemClass"+ j).equals("")){
				itemClassList.add(Integer.parseInt(request.getParameter("itemClass"+ j)));
			}
			
			
			if(request.getParameter("dispensingUnit"+ j) != null ){
				itemDispensaryList.add(request.getParameter("dispensingUnit"+ j));
			}
			
			
			int frequencyId = 0;
			if(request.getParameter("frequency" + j) != null && !request.getParameter("frequency" + j).equals("")){
				frequencyId = Integer.parseInt(request.getParameter("frequency" + j));
				frequencyList.add(frequencyId);
			}else {
				frequencyList.add(0);
			}
			if(request.getParameter("ct" + j) != null){
				ctList.add("y");
			}	else {
				ctList.add("n");
			}

			String route = "";
			if(request.getParameter("route" + j) != null && !request.getParameter("route" + j).equals("")){
				route = request.getParameter("route" + j);
				routeList.add(route);
			}	else {
				routeList.add("");
			}
			
			BigDecimal frequenceValue = new BigDecimal("0");
			if(request.getParameter("frequencyValue" + j) != null && !request.getParameter("frequencyValue" + j).equals("")){
				frequenceValue = new BigDecimal(request.getParameter("frequencyValue" + j));
			}	
			
			String dosage = "";
			if(request.getParameter("dosage" + j) != null && !request.getParameter("dosage" + j).equals("")){
				dosage = request.getParameter("dosage" + j);
				dosageList.add(dosage);
			}else{
				dosageList.add("");
			}
			if(request.getParameter("noOfDays" + j) != null && !request.getParameter("noOfDays" + j).equals("")){
				int noOfDays = Integer.parseInt(request.getParameter("noOfDays" + j));
				noOfDaysList.add(noOfDays);
				//int noOfdoges=1;
				//if(dosage!=null && dosage!=""){
					//noOfdoges=Integer.parseInt(dosage);
				//}
				//int total = noOfDays * frequenceValue*noOfdoges;
				//totalList.add(total);
				
			}else {
				noOfDaysList.add(0);
			}
			if(request.getParameter("total" + j) != null && !request.getParameter("total" + j).equals("")){
				int total = Math.round(Float.parseFloat(request.getParameter("total" + j)));
				totalList.add(total);
			}else {
				totalList.add(0);
			}
			
		
			String remarks = "";
			if(request.getParameter("remarks" + j) != null && !request.getParameter("remarks" + j).equals("")){
				remarks = request.getParameter("remarks" + j);
				remarksList.add(remarks);
			}else {
				remarksList.add("");
			}

		
			//if(!pvmsNo.equals("")){
				//pvmsNoList.add(pvmsNo);
			//}
			//	pvmsNoList.add(pvmsArr[i]);

			j++;
		}

		
		mapForDS.put("itemIdList", itemIdList);
		mapForDS.put("frequencyList", frequencyList);
		mapForDS.put("ctList", ctList);
		mapForDS.put("dosageList", dosageList);
		mapForDS.put("typeLeftRightList", typeLeftRightList);
		mapForDS.put("instructionList", instructionList);
		mapForDS.put("routeList", routeList);
		mapForDS.put("totalList", totalList);
		mapForDS.put("noOfDaysList", noOfDaysList);
		mapForDS.put("otherMedicineList", otherMedicineList);
		mapForDS.put("nomenclatureList", nomenclatureList);
		mapForDS.put("itemConversionList", itemConversionList);
		mapForDS.put("itemClassList", itemClassList);
		mapForDS.put("itemDispensaryList", itemDispensaryList);
		mapForDS.put("remarksList", remarksList);*/
		
		List<Integer> frequencyList = new ArrayList<Integer>();
		List<String> dosageList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();
		List<String> typeLeftRightList = new ArrayList<String>();
		List<String> instructionList = new ArrayList<String>();
		List<Integer> totalList = new ArrayList<Integer>();
		List<Integer> noOfDaysList = new ArrayList<Integer>();
		List<String> routeList = new ArrayList<String>();
		List<Integer> itemConversionList = new ArrayList<Integer>();
		List<Integer> itemClassList = new ArrayList<Integer>();
		List<String> itemDispensaryList = new ArrayList<String>();

		 int empId = 0;
			int totalMasterIns = 0;
			int totalBanks = 0;
			int OpNotesId =0;
			String actualString ="";
			String receivedString ="";
			List<String> PreOpInstructionList = new ArrayList<String>();
			if (request.getParameter("totalPrevOPInstruction") !=null) {
				totalMasterIns = Integer.parseInt(request.getParameter("totalPrevOPInstruction"));
			}
				//totalMasterIns	
			for(int i= 1; i<=totalMasterIns;i++)
			{
			   	if(request.getParameter("OpNotesId"+i)!=null && (request.getParameter("OpNotesId"+i)!=""))
			   	{
			   		OpNotesId = Integer.parseInt(request.getParameter("OpNotesId"+i));
			   		actualString = request.getParameter("actualValue"+i);
			   		receivedString ="";
			   		if(request.getParameter("totalBlank"+i)!=null && request.getParameter("totalBlank"+i)!="" &&  request.getParameter("totalBlank"+i)!="0" )
			   		{
			   			totalBanks = Integer.parseInt(request.getParameter("totalBlank"+i));
			   			for(int j=0;j<=totalBanks-1;j++)
			   			{
			   				if(request.getParameter(OpNotesId+"blank"+j)!=null && request.getParameter(OpNotesId+"blank"+j)!="")
			   				{
			   					//System.out.println("string "+request.getParameter(OpNotesId+"blank"+j) +" "+ OpNotesId+"blank"+j);
			   					String s = request.getParameter(OpNotesId+"blank"+j);
			   					receivedString +=request.getParameter(OpNotesId+"blank"+j)+" ";
			   				}
			   			}
			   		}
				   	if(receivedString!=null && receivedString!="")
				   	{
				   		receivedString.trim();
				   		PreOpInstructionList.add(receivedString);
				   	}
				   	else if(actualString!=null)
				   		PreOpInstructionList.add(actualString);
			   		
			 	}
		
			}
			
			int opHiddenValue = box.getInt("opHiddenValue");
			if(opHiddenValue>0)
			{
				for(int i=1; i<= opHiddenValue;i++)
				{
					if(box.getString("opInstruction" +i)!=null && box.getString("opInstruction" +i)!="")
					{
						PreOpInstructionList.add(box.getString("opInstruction" +i));
						
					}
				}
				
			}
		
	/*	String[] diagnosisIdAray = null;

		if (request.getParameterValues(DIAGNOSIS_ID) != null) {
			diagnosisIdAray = (String[]) request
					.getParameterValues(DIAGNOSIS_ID);
		}*/

		int nomenclaturehdb = 1;
		if (Integer.parseInt(request.getParameter("nomenclaturehdb")) != 1) {
			nomenclaturehdb = Integer.parseInt(request.getParameter("nomenclaturehdb"));
		}
		//String[] pvmsArr = new String[nomenclaturehdb];
		//Integer[] itemIdArr = new Integer[nomenclaturehdb];
		String otherMedicine = "";
		List<String> otherMedicineList = new ArrayList<String>();
		List<String> ctList = new ArrayList<String>();
		// List<String> nomenclatureList = new ArrayList<String>();
		List<Integer> itemIdList = new ArrayList<Integer>();
		List<Integer> classificationList = new ArrayList<Integer>();
		// List injCategoryList = new ArrayList();
		int j = 1;
		for (int i = 0; i < nomenclaturehdb; i++) {
		//	String pvmsNo = "";
			int itemId = 0;
	

			if (request.getParameter("itemId" + j) != null
					&& !request.getParameter("nomenclature" + j).equals("")) {
				itemId = Integer.parseInt(request.getParameter("itemId" + j));
				if (itemId != 0) {
					itemIdList.add(itemId);
				}

				if (request.getParameter("itemIdClassificationId" + j) != null
						&& !request.getParameter("itemIdClassificationId" + j)
								.equals("")) {
					classificationList.add(Integer.parseInt(request
							.getParameter("itemIdClassificationId" + j)));
				} else
					classificationList.add(0);
				/*otherMedicineList.add(otherMedicine);*/
			} else {
				if (request.getParameter("otherMedicine" + j) != null
						&& !request.getParameter("otherMedicine" + j)
								.equals("")) {
					otherMedicine = request.getParameter("otherMedicine" + j);
					otherMedicineList.add(otherMedicine);

				}

			}
			
			if((request.getParameter("itemId" + j) != null && !request.getParameter("nomenclature" + j).equals("")) || (request.getParameter("otherMedicine" + j) != null && !request.getParameter("otherMedicine" + j).equals("")) )
			{
			int itemConversionId = 0;
			if (request.getParameter("itemConversionId" + j) != null
					&& !request.getParameter("itemConversionId" + j).equals("")) {
				itemConversionId = Integer.parseInt(request
						.getParameter("itemConversionId" + j));
				itemConversionList.add(itemConversionId);
			}
			else
				itemConversionList.add(0);
			if (request.getParameter("itemClass" + j) != null
					&& !request.getParameter("itemClass" + j).equals("")) {
				itemClassList.add(Integer.parseInt(request
						.getParameter("itemClass" + j)));
			}
			else
				itemClassList.add(0);

			if (request.getParameter("dispensingUnit" + j) != null) {
				itemDispensaryList.add(request.getParameter("dispensingUnit"
						+ j));
			}
			else
				itemDispensaryList.add("");
			int frequencyId = 0;
			if (request.getParameter("frequency" + j) != null
					&& !request.getParameter("frequency" + j).equals("")) {
				frequencyId = Integer.parseInt(request.getParameter("frequency"
						+ j));
				frequencyList.add(frequencyId);
			} else {
				frequencyList.add(0);
			}
			if (request.getParameter("ct" + j) != null) {
				ctList.add("y");
			} else {
				ctList.add("n");
			}

			String route = "";
			if (request.getParameter("route" + j) != null
					&& !request.getParameter("route" + j).equals("")) {
				route = request.getParameter("route" + j);
				routeList.add(route);
			} else {
				routeList.add("");
			}

			BigDecimal frequenceValue = new BigDecimal("0");
			if (request.getParameter("frequencyValue" + j) != null
					&& !request.getParameter("frequencyValue" + j).equals("")) {
				frequenceValue = new BigDecimal(
						request.getParameter("frequencyValue" + j));
			}

			String dosage = "";
			if (request.getParameter("dosage" + j) != null
					&& !request.getParameter("dosage" + j).equals("")) {
				dosage = request.getParameter("dosage" + j);
				dosageList.add(dosage);
			} else {
				dosageList.add("");
			}
			if (request.getParameter("noOfDays" + j) != null
					&& !request.getParameter("noOfDays" + j).equals("")) {
				int noOfDays = Integer.parseInt(request.getParameter("noOfDays"
						+ j));
				noOfDaysList.add(noOfDays);
				// int noOfdoges=1;
				// if(dosage!=null && dosage!=""){
				// noOfdoges=Integer.parseInt(dosage);
				// }
				// int total = noOfDays * frequenceValue*noOfdoges;
				// totalList.add(total);

			} else {
				noOfDaysList.add(0);
			}
			if (request.getParameter("total" + j) != null
					&& !request.getParameter("total" + j).equals("")) {
				int total = Math.round(Float.parseFloat(request
						.getParameter("total" + j)));
				totalList.add(total);
			} else {
				totalList.add(0);
			}

			String remarks = "";
			if (request.getParameter("remarks" + j) != null
					&& !request.getParameter("remarks" + j).equals("")) {
				remarks = request.getParameter("remarks" + j);
				remarksList.add(remarks);
			} else {
				remarksList.add("");
			}
		}
			// if(!pvmsNo.equals("")){
			// pvmsNoList.add(pvmsNo);
			// }
			// pvmsNoList.add(pvmsArr[i]);

			j++;
		}
		
		

		
		//capture NIP
					j =500;
					int n=itemIdList.size();
							int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		
		for ( j = 500; j <=hdb; j++) {
		//	String pvmsNo = "";
			int itemId = 0;

			if (request.getParameter("itemId" + j) != null
					&& !request.getParameter("nomenclature" + j).equals("")) {
				itemId = Integer.parseInt(request.getParameter("itemId" + j));
				if (itemId != 0) {
					itemIdList.add(itemId);
				}

				if (request.getParameter("itemIdClassificationId" + j) != null
						&& !request.getParameter("itemIdClassificationId" + j)
								.equals("")) {
					classificationList.add(Integer.parseInt(request
							.getParameter("itemIdClassificationId" + j)));
				} else
					classificationList.add(0);
				/*otherMedicineList.add(otherMedicine);*/
			} else {
				if (request.getParameter("otherMedicine" + j) != null
						&& !request.getParameter("otherMedicine" + j)
								.equals("")) {
					otherMedicine = request.getParameter("otherMedicine" + j);
					otherMedicineList.add(otherMedicine);
					/*otherMedicineList.add(n,otherMedicine);*/

				}

			}
			
			if((request.getParameter("itemId" + j) != null && !request.getParameter("nomenclature" + j).equals("")) || (request.getParameter("otherMedicine" + j) != null && !request.getParameter("otherMedicine" + j).equals("")) )
			{
			int itemConversionId = 0;
			if (request.getParameter("itemConversionId" + j) != null
					&& !request.getParameter("itemConversionId" + j).equals("")) {
				itemConversionId = Integer.parseInt(request
						.getParameter("itemConversionId" + j));
				itemConversionList.add(itemConversionId);
			}
			else
				itemConversionList.add(0);
			if (request.getParameter("itemClass" + j) != null
					&& !request.getParameter("itemClass" + j).equals("")) {
				itemClassList.add(Integer.parseInt(request
						.getParameter("itemClass" + j)));
			}
			else
				itemClassList.add(0);
			if (request.getParameter("dispensingUnit" + j) != null) {
				itemDispensaryList.add(request.getParameter("dispensingUnit"
						+ j));
			}
			else
				itemDispensaryList.add("");
			
			int frequencyId = 0;
			if (request.getParameter("frequency" + j) != null
					&& !request.getParameter("frequency" + j).equals("")) {
				frequencyId = Integer.parseInt(request.getParameter("frequency"
						+ j));
				frequencyList.add(frequencyId);
			} else {
				frequencyList.add(0);
			}
			if (request.getParameter("ct" + j) != null) {
				ctList.add("y");
			} else {
				ctList.add("n");
			}

			String route = "";
			if (request.getParameter("route" + j) != null
					&& !request.getParameter("route" + j).equals("")) {
				route = request.getParameter("route" + j);
				routeList.add(route);
			} else {
				routeList.add("");
			}

			/*BigDecimal frequenceValue = new BigDecimal("0");
			if (request.getParameter("frequencyValue" + j) != null
					&& !request.getParameter("frequencyValue" + j).equals("")) {
				frequenceValue = new BigDecimal(
						request.getParameter("frequencyValue" + j));
			}*/

			String dosage = "";
			if (request.getParameter("dosage" + j) != null
					&& !request.getParameter("dosage" + j).equals("")) {
				dosage = request.getParameter("dosage" + j);
				dosageList.add(dosage);
			} else {
				dosageList.add("");
			}
			if (request.getParameter("noOfDays" + j) != null
					&& !request.getParameter("noOfDays" + j).equals("")) {
				int noOfDays = Integer.parseInt(request.getParameter("noOfDays"
						+ j));
				noOfDaysList.add(noOfDays);
				// int noOfdoges=1;
				// if(dosage!=null && dosage!=""){
				// noOfdoges=Integer.parseInt(dosage);
				// }
				// int total = noOfDays * frequenceValue*noOfdoges;
				// totalList.add(total);

			} else {
				noOfDaysList.add(0);
			}
			if (request.getParameter("total" + j) != null
					&& !request.getParameter("total" + j).equals("")) {
				int total = Math.round(Float.parseFloat(request
						.getParameter("total" + j)));
				totalList.add(total);
			} else {
				totalList.add(0);
			}

			String remarks = "";
			if (request.getParameter("remarks" + j) != null
					&& !request.getParameter("remarks" + j).equals("")) {
				remarks = request.getParameter("remarks" + j);
				remarksList.add(remarks);
			} else {
				remarksList.add("");
			}
		}
			// if(!pvmsNo.equals("")){
			// pvmsNoList.add(pvmsNo);
			// }
			// pvmsNoList.add(pvmsArr[i]);

			//j++;
			//n++;
		}
		
		mapForDS.put("routeList", routeList);
		mapForDS.put("frequencyList", frequencyList);
		mapForDS.put("ctList", ctList);
		mapForDS.put("dosageList", dosageList);
		mapForDS.put("itemIdList", itemIdList);
		mapForDS.put("classificationList", classificationList);
		mapForDS.put("totalList", totalList);
		mapForDS.put("noOfDaysList", noOfDaysList);
		mapForDS.put("remarksList", remarksList);
		mapForDS.put("otherMedicineList", otherMedicineList);
		// mapForDS.put("nomenclatureList", nomenclatureList);
		mapForDS.put("itemConversionList", itemConversionList);
		mapForDS.put("itemClassList", itemClassList);
		mapForDS.put("itemDispensaryList", itemDispensaryList);
		mapForDS.put("PreOpInstructionList", PreOpInstructionList);
		
		
	/*	for (int i = 0; i < pvmsNoId.length; i++) {
			int pvmsNo = Integer.parseInt(pvmsNoId[i]);
			pvmsNoList.add(pvmsNo);
		}*/
		if (request.getParameter("otProcedure") != null
				&& !(request.getParameter("otProcedure").equals(""))) {
			otProcedure = request.getParameter("otProcedure");
		}

		if (request.getParameter("yearlySqNo") != null) {
			yearlySerialNo = request.getParameter("yearlySqNo");
			mapForDS.put("yearlySerialNo", yearlySerialNo);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			mapForDS.put("userName", userName);
		}
/*		mapForDS.put("hinNo", hinNo);*/

	
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			mapForDS.put(HOSPITAL_ID, hospitalId);
		}


		if (session.getAttribute("empId") != null) {
			empId = (Integer)session.getAttribute("empId");
			mapForDS.put("empId", empId);
			
		}
		
	
		int departmentId = 0;
		if (session.getAttribute("deptId") != null) {
			 departmentId = (Integer) session.getAttribute("deptId");
				mapForDS.put("deptId", departmentId);
			
		}
		
		int userId = 0;
		if (session.getAttribute(USER_ID) != null) {
			userId = (Integer) session.getAttribute(USER_ID);
			mapForDS.put(USER_ID, userId);
			
		}
		
		//mapForDS.put("box", box);
		
		
		map =  otHandlerService.submitOtPostAnesthesiaProcedure(mapForDS, box);
		//pacsTest(request, response);
		String message = null;
		if (map.get("dataSaved")!=null) {
			if((Boolean)map.get("dataSaved"))
			{//postAnaesthesiaProcedureId
			 message = "Post OP Notes (Anaesthesia) Submitted Successfully !!Do you want to print ?";
			 
			}
			else
			{
				message = "Data could not saved";
			}

		} else {
			message = "Error Occurred !! Try Again !!";
		}

		
		
		/*String value = (String) map.get("value");
		if (map.get("dataSaved") != null) {
			boolean succesfullyAdded = (Boolean) map.get("dataSaved");
			if (succesfullyAdded ==true) {
				System.out.println("ddd"+map.get("bookingId"));
				//map = otHandlerService
					//	.showPACClearedListForOTBooking(mapForDS);
				message = value;
			} else {
				//map = otHandlerService
						//.showPACClearedListForOTBooking(mapForDS);
				message = value;
			}
		} else {
			//map = otHandlerService.showPACClearedListForOTBooking(mapForDS);
			message = "Error In Submitting OT details.";

		}*/
		
		jsp = OT_MSG_POST_ANESTHESIA_PROCEDURE;
		jsp += ".jsp";
		//map.put("yearlySlNo", yearlySlNo);
		//map.put("deptId", departmentId);
		map.put("message", message);
		title = "Post Anesthesia Procedure Details";
		map.put("contentJsp", jsp);
		map.put("title", title);

		//map.put("submitData", submitData);
		return new ModelAndView("index", "map", map);
	}
	@SuppressWarnings("unused")
	public ModelAndView getItemListForAutoComplete(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("deptId") != null) {
				deptId = Integer.parseInt(request.getParameter("deptId"));
			}
			map.put("deptId", deptId);
			map.put("autoHint", autoHint);
			map = otHandlerService.getItemListForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "opd_responseInGrid";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getItemList(HttpServletRequest request,
			HttpServletResponse response) {

		String itemNameField = "";
		int visitId = 0;
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}

			map.put("autoHint", autoHint);
			map = otHandlerService.getItemList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseInGrid";
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView getItemPrListForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("deptId") != null) {
				deptId = Integer.parseInt(request.getParameter("deptId"));
			}
			map.put("deptId", deptId);
			map.put("autoHint", autoHint);
			map = otHandlerService.getItemListForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "opd_responseInGrid";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getItemPrList(HttpServletRequest request,
			HttpServletResponse response) {

		String itemNameField = "";
		int visitId = 0;
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}

			map.put("autoHint", autoHint);
			map = otHandlerService.getItemList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseInGrid";
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView getItemPListForAutoComplete(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("deptId") != null) {
				deptId = Integer.parseInt(request.getParameter("deptId"));
			}
			map.put("deptId", deptId);
			map.put("autoHint", autoHint);
			map = otHandlerService.getItemListForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "opd_responseInGrid";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getItemPList(HttpServletRequest request,
			HttpServletResponse response) {

		String itemNameField = "";
		int visitId = 0;
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}

			map.put("autoHint", autoHint);
			map = otHandlerService.getItemList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseInGrid";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchOtPostAnesthesiaProcedure(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = SEARCH_OT_POST_ANESTHESIA_PROCEDURE_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchOtPostAnesthesiaProcedureForMain(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = SEARCH_OT_POST_ANESTHESIA_PROCEDURE_FOR_MAIN_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView showOtPostAnesthesiaProcedure(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String visitNo = "";
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDS.put("serviceNo", serviceNo);
		}
		if (request.getParameter(VISIT_NUMBER) != null) {
			visitNo = request.getParameter(VISIT_NUMBER);
			mapForDS.put("visitNo", visitNo);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			mapForDS.put("hinNo", hinNo);
		}

		map = otHandlerService.showOtPostAnesthesiaProcedure(mapForDS);

		jsp = SEARCH_SHOW_OT_POST_ANESTHESIA_PROCEDURE_JSP;
		jsp += ".jsp";
		title = "show Ot Post Anesthesia Procedure";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getOpdReportList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		int departmentId = 0;
		String submitData = "";
		try {
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				detailsMap.put("serviceNo", serviceNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				detailsMap.put("hinNo", hinNo);
			}
			List<Object> visitNoList = new ArrayList<Object>();
			List<Object> hinNoList = new ArrayList<Object>();
			String flag = "";

			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("visit")) {
				visitNoList = otHandlerService.getVisitNoList(detailsMap);
				map.put("visitNoList", visitNoList);
				jsp = RESPONSE_FOR_OT_VISIT_NO;

			} else if (flag.equals("hin")) {
				hinNoList = otHandlerService.getHinNoList(serviceNo);
				//System.out.println("hin No in con ---->" + hinNoList.size());

				map.put("hinNoList", hinNoList);

				jsp = RESPONSE_FOR_OT_HIN_NO;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView updateOtPostAnesthesiaProcedure(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		int departmentId = Integer.parseInt(request
				.getParameter("departmentId"));
		/*
		 * if(request.getParameter("visitId")){
		 *
		 * } int visitId=Integer.parseInt(request.getParameter("visitId"));
		 */
		int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		// details captured for Ot Post Anesthesia Procedure table
		// int anesthesia_id =0;
		int postId = 0;
		String yearlySlNo = "";
		String monthlySlNo = "";
		String surgey_from_time = "";
		String surgey_to_time = "";
		String asa_grade_details = "";
		String anaesthesia_from_time = "";
		String anaesthesia_to_time = "";
		String ett_lma = "";
		int ett_lma_text = 0;
		String userName = null;
		String ecg = null;
		String nibp = null;
		String cvp = null;
		String temp = null;
		String sp02 = null;
		String labp = null;
		boolean submitData = false;
		String uo = "";
		int neostigmine = 0;
		int glycophyrrolate = 0;
		int others = 0;
		String recovery = "";
		String risk_grade = "";
		String e_others = "";
		String remarks = "";
		String dateOfPost = "";
		String anesthesia_value = "";
		String pre_assessment = "";
		if (request.getParameter(START_DATE) != null) {
			dateOfPost = request.getParameter(START_DATE);
		}
		if ((request.getParameter("postId")) != null
				&& !(request.getParameter("postId").equals("0"))) {
			postId = Integer.parseInt(request.getParameter("postId"));

		}
		if ((request.getParameter("anesthesia_id")) != null
				&& !(request.getParameter("anesthesia_id").equals("0"))) {
			anesthesia_value = request.getParameter("anesthesia_id");

		}
		if (!request.getParameter("remarks").equals("")) {
			remarks = request.getParameter("remarks");
		}
		if (!request.getParameter("e_others").equals("")) {
			e_others = request.getParameter("e_others");
		}

		if (!request.getParameter("risk_grade").equals("")) {
			risk_grade = request.getParameter("risk_grade");
		}
		if (!request.getParameter("recovery").equals("")) {
			recovery = request.getParameter("recovery");
		}
		if (!request.getParameter("others").equals("")) {
			others = Integer.parseInt(request.getParameter("others"));
		}
		if (!request.getParameter("temp").equals("")) {
			temp = request.getParameter("temp");
		}
		if (!request.getParameter("sp02").equals("")) {
			sp02 = request.getParameter("sp02");
		}
		if (!request.getParameter("labp").equals("")) {
			labp = request.getParameter("labp");
		}
		if (!request.getParameter("glycophyrrolate").equals("")) {
			glycophyrrolate = Integer.parseInt(request
					.getParameter("glycophyrrolate"));
		}
		if (!request.getParameter("uo").equals("")) {
			uo = request.getParameter("uo");
		}
		if (!request.getParameter("neostigmine").equals("")) {
			neostigmine = Integer.parseInt(request.getParameter("neostigmine"));
		}

		if (!request.getParameter("yearlySlNo").equals("")) {
			yearlySlNo = request.getParameter("yearlySlNo");
		}
		if (!request.getParameter("monthlySlNo").equals("")) {
			monthlySlNo = request.getParameter("monthlySlNo");
		}
		if (!request.getParameter("surgey_from_time").equals("")) {
			surgey_from_time = request.getParameter("surgey_from_time");
		}
		if (!request.getParameter("surgey_to_time").equals("")) {
			surgey_to_time = request.getParameter("surgey_to_time");
		}
		if (request.getParameter("asa_grade_details") != null
				|| request.getParameter("asa_grade_details") != "") {
			asa_grade_details = request.getParameter("asa_grade_details");
		}
		if (request.getParameter("anaesthesia_from_time") != null
				|| request.getParameter("anaesthesia_from_time") != "") {
			anaesthesia_from_time = request
					.getParameter("anaesthesia_from_time");
		}
		if (!request.getParameter("anaesthesia_to_time").equals("")) {
			anaesthesia_to_time = request.getParameter("anaesthesia_to_time");
		}
		if (!request.getParameter("ett_lma").equals("")) {
			ett_lma = request.getParameter("ett_lma");
		}

		if (!request.getParameter("ett_lma_text").equals("")) {
			ett_lma_text = Integer.parseInt(request
					.getParameter("ett_lma_text"));

		}
		if (!request.getParameter("userName").equals("")) {
			userName = request.getParameter("userName");
		}

		if (!request.getParameter("ecg").equals("")) {
			ecg = request.getParameter("ecg");
		}
		if (!request.getParameter("nibp").equals("")) {
			nibp = request.getParameter("nibp");
		}
		if (!request.getParameter("cvp").equals("")) {
			cvp = request.getParameter("cvp");
		}
		if ((request.getParameter("pre_assessment")) != null && !(request.getParameter("pre_assessment").equals(""))) {
			pre_assessment = request.getParameter("pre_assessment");
		}
		// details captured for Iv Fluids header table
		List<String> pvmsNoList = new ArrayList<String>();
		List<Integer> volumeList = new ArrayList<Integer>();
		List<String> fluidNameList = new ArrayList<String>();
		int hiddenValueFluids = 1;
		if (Integer.parseInt(request.getParameter("hiddenValueFluids")) != 1) {
			hiddenValueFluids = Integer.parseInt(request
					.getParameter("hiddenValueFluids"));
		}
		String[] pvmsArr = new String[hiddenValueFluids];
		int j = 1;
		for (int i = 1; i <= hiddenValueFluids; i++) {
			if (request.getParameter("nomenclature" + j) != null)

				if (!request.getParameter("nomenclature" + j).equals("")) {

					String nomenclature = request.getParameter("nomenclature"
							+ j);
					int volume = 0;
					if (request.getParameter("v" + j) != null
							&& !request.getParameter("v" + j).equals("")) {
						volume = Integer
								.parseInt(request.getParameter("v" + j));
					}

					String fluidName = request.getParameter("fluidName" + j);
					int index1 = nomenclature.lastIndexOf("[");
					int index2 = nomenclature.lastIndexOf("]");
					index1++;
					// pvmsArr[i]=;
					pvmsNoList.add(nomenclature.substring(index1, index2));
					volumeList.add(volume);
					fluidNameList.add(fluidName);
				}
			j++;
		}

		// details captured for Procedure Details table
		List<String> pvmsNoProList = new ArrayList<String>();
		List<String> anesthesiaList = new ArrayList<String>();
		List<String> dosageList = new ArrayList<String>();
		List<String> levelList = new ArrayList<String>();
		List<String> catheterList = new ArrayList<String>();

		int hiddenValueProcedure = 1;
		if (Integer.parseInt(request.getParameter("hiddenValueProcedure")) != 1) {
			hiddenValueProcedure = Integer.parseInt(request
					.getParameter("hiddenValueProcedure"));
		}
		String[] pvmsProArr = new String[hiddenValueProcedure];
		int x = 1;
		for (int y = 1; y <= hiddenValueProcedure; y++) {
			if (request.getParameter("nomenclatureP" + x) != null
					&& !request.getParameter("nomenclatureP" + x).equals("")) {

				String nomenclature = request.getParameter("nomenclatureP" + x);
				String anesthesia = request.getParameter("anesthesia" + x);
				String dosage = request.getParameter("d" + x);
				String level = request.getParameter("level" + x);
				String catheter = request.getParameter("c" + x);

				int index1 = nomenclature.lastIndexOf("[");
				int index2 = nomenclature.lastIndexOf("]");
				index1++;
				// pvmsProArr[y]=;

				pvmsNoProList.add(nomenclature.substring(index1, index2));
				anesthesiaList.add(anesthesia);
				dosageList.add(dosage);
				levelList.add(level);
				catheterList.add(catheter);
			}
			x++;
		}

		// details captured for Premedication/Induction/Maintenance Details
		// table
		List<String> pvmsNoPrList = new ArrayList<String>();
		List<String> typeList = new ArrayList<String>();
		List<String> agePrList = new ArrayList<String>();
		List<String> routeList = new ArrayList<String>();

		int hiddenValuePremedication = 1;
		if (Integer.parseInt(request.getParameter("hiddenValuePremedication")) != 1) {
			hiddenValuePremedication = Integer.parseInt(request
					.getParameter("hiddenValuePremedication"));
		}
		String[] pvmsPrArr = new String[hiddenValuePremedication];
		int t = 1;
		for (int r = 1; r <= hiddenValuePremedication; r++) {
			if (request.getParameter("nomenclaturePr" + t) != null
					&& !request.getParameter("nomenclaturePr" + t).equals("")) {

				String nomenclature = request
						.getParameter("nomenclaturePr" + t);
				String typePIM = request.getParameter("typePIM" + t);
				String agePr = request.getParameter("dv" + t);
				String route = request.getParameter("route" + t);

				int index1 = nomenclature.lastIndexOf("[");
				int index2 = nomenclature.lastIndexOf("]");
				index1++;
				// pvmsPrArr[r]=;

				pvmsNoPrList.add(nomenclature.substring(index1, index2));
				typeList.add(typePIM);
				agePrList.add(agePr);
				routeList.add(route);

			}
			t++;
		}

		// details captured for Anesthesiologist(s) table
		List<String> empNameList = new ArrayList<String>();

		int hiddenValueAnesthesiologist = 1;
		if (Integer.parseInt(request
				.getParameter("hiddenValueAnesthesiologist")) != 1) {
			hiddenValueAnesthesiologist = Integer.parseInt(request
					.getParameter("hiddenValueAnesthesiologist"));
		}
		String[] empArr = new String[hiddenValueAnesthesiologist];
		int w = 1;
		for (int q = 1; q <= hiddenValueAnesthesiologist; q++) {
			if (request.getParameter("empName" + w) != null
					&& !request.getParameter("empName" + w).equals("")) {

				String empName = request.getParameter("empName" + w);

				int index1 = empName.lastIndexOf("[");
				int index2 = empName.lastIndexOf("]");
				index1++;
				// empArr[q]=;

				empNameList.add(empName.substring(index1, index2));
			}
			w++;
		}

		// details captured for Sergon(s) table
		List<String> empNameSList = new ArrayList<String>();

		int hiddenValueSergon = 1;
		if (Integer.parseInt(request.getParameter("hiddenValueSergon")) != 1) {
			hiddenValueSergon = Integer.parseInt(request
					.getParameter("hiddenValueSergon"));
		}
		String[] empArrS = new String[hiddenValueSergon];
		int e = 1;
		for (int o = 1; o <= hiddenValueSergon; o++) {
			if (request.getParameter("empNameS" + e) != null
					&& !request.getParameter("empNameS" + e).equals("")) {

				String empName = request.getParameter("empNameS" + e);

				int index1 = empName.lastIndexOf("[");
				int index2 = empName.lastIndexOf("]");
				index1++;
				// empArrS[o]=;
				empNameSList.add(empName.substring(index1, index2));
			}
			e++;
		}

		// details captured for Surgery Details table
		List<String> chargeCodeList = new ArrayList<String>();

		int hiddenValue = 1;
		if (Integer.parseInt(request.getParameter("hiddenValue")) != 1) {
			hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
		}
		String[] chargeCodeArr = new String[hiddenValue];
		int b = 1;
		for (int n = 1; n <= hiddenValue; n++) {
			if (request.getParameter("chargeCodeName" + b) != null
					&& !request.getParameter("chargeCodeName" + b).equals("")) {

				String chargeCodeName = request.getParameter("chargeCodeName"
						+ b);

				int index1 = chargeCodeName.lastIndexOf("[");
				int index2 = chargeCodeName.lastIndexOf("]");
				index1++;
				// chargeCodeArr[n]=;

				chargeCodeList.add(chargeCodeName.substring(index1, index2));
			}
			b++;
		}

		// ----------data for Surgery------
		mapForDS.put("chargeCodeList", chargeCodeList);
		// ----------data for Anesthesiologist------
		mapForDS.put("empNameList", empNameList);
		// ----------data for Sergon------
		mapForDS.put("empNameSList", empNameSList);
		// ----------data for Premedication------
		mapForDS.put("typeList", typeList);
		mapForDS.put("routeList", routeList);
		mapForDS.put("pvmsNoPrList", pvmsNoPrList);
		mapForDS.put("agePrList", agePrList);
		// ----------data for Procedure------
		mapForDS.put("pvmsNoProList", pvmsNoProList);
		mapForDS.put("catheterList", catheterList);
		mapForDS.put("anesthesiaList", anesthesiaList);
		mapForDS.put("levelList", levelList);
		mapForDS.put("dosageList", dosageList);
		// ----------data for IV Fuide------
		mapForDS.put("pvmsNoList", pvmsNoList);
		mapForDS.put("volumeList", volumeList);
		mapForDS.put("fluidNameList", fluidNameList);

		// ----------data for Post Anesthesia Procedure ------
		mapForDS.put("dateOfPost", dateOfPost);
		mapForDS.put("postId", postId);
		mapForDS.put("anesthesia_value", anesthesia_value);
		mapForDS.put("hinId", hinId);
		mapForDS.put("departmentId", departmentId);
		// mapForDS.put("visitId", visitId);
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("anaesthesia_from_time", anaesthesia_from_time);
		mapForDS.put("anaesthesia_to_time", anaesthesia_to_time);
		mapForDS.put("yearlySlNo", yearlySlNo);
		mapForDS.put("monthlySlNo", monthlySlNo);
		mapForDS.put("surgey_from_time", surgey_from_time);
		mapForDS.put("surgey_to_time", surgey_to_time);
		mapForDS.put("ett_lma", ett_lma);
		mapForDS.put("ett_lma_text", ett_lma_text);
		mapForDS.put("ecg", ecg);
		mapForDS.put("nibp", nibp);
		mapForDS.put("cvp", cvp);
		mapForDS.put("temp", temp);
		mapForDS.put("sp02", sp02);
		mapForDS.put("userName", userName);
		mapForDS.put("labp", labp);
		mapForDS.put("uo", uo);
		mapForDS.put("neostigmine", neostigmine);
		mapForDS.put("glycophyrrolate", glycophyrrolate);
		mapForDS.put("others", others);
		mapForDS.put("recovery", recovery);
		mapForDS.put("risk_grade", risk_grade);
		mapForDS.put("e_others", e_others);
		mapForDS.put("remarks", remarks);
		mapForDS.put("pre_assessment",pre_assessment);
		boolean bool = otHandlerService
				.updateOtPostAnesthesiaProcedure(mapForDS);
		String message = null;
		if (bool) {
			message = "Post OP Notes (Anesthesia) Updated successfully!! Do you want to Print ?";
		} else {

			message = "Error Occurred!! Try Again !!";
		}
		jsp = "postAnesthesiaProcedureJsp";
		jsp += ".jsp";

		map.put("deptId", departmentId);
		map.put("yearlySlNo", yearlySlNo);
		map.put("message", message);
		title = "Post Anesthesia Procedure Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("submitData", submitData);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------------Specimen Dispatch
	// Entry---------------------------

	public ModelAndView showSpecimenDispatchEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp = OT_SPECIMEN_DISPATCH_ENTRY_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showSpecimenDispatchEntryPatientDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		String serviceFName = "";
		String serviceMName = "";
		String serviceLName = "";

		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put("hinNo", hinNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDS.put("serviceNo", serviceNo);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDS.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDS.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDS.put("patientLName", patientLName);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serviceFName = request.getParameter(S_FIRST_NAME);
				mapForDS.put("serviceFName", serviceFName);
			}
			if (request.getParameter(S_MIDDLE_NAME) != null
					&& !(request.getParameter(S_MIDDLE_NAME).equals(""))) {
				serviceMName = request.getParameter(S_MIDDLE_NAME);
				mapForDS.put("serviceMName", serviceMName);
			}
			if (request.getParameter(S_LAST_NAME) != null
					&& !(request.getParameter(S_LAST_NAME).equals(""))) {
				serviceLName = request.getParameter(S_LAST_NAME);
				mapForDS.put("serviceLName", serviceLName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = otHandlerService
				.searchSpecimenDispatchEntryPatientDetails(mapForDS);
		String jsp = "";
		jsp = OT_SPECIMEN_DISPATCH_ENTRY_SEARCH_JSP + ".jsp";
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView showSpecimenDispatchEntryJspFromPatientList(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String otBookingId = request.getParameter("hinNo");
		String orderNo = request.getParameter("orderNo");
		List<OtSpecimenDispatchEntry> otSpecimenDispatchEntryList = new ArrayList<OtSpecimenDispatchEntry>();

		String entryNo = "";
		mapForDS.put("otBookingId", otBookingId);
		mapForDS.put("orderNo", orderNo);
		try {
			map = otHandlerService.showSpecimenDispatchEntryJspForHin(mapForDS);
			otSpecimenDispatchEntryList = (List) map
					.get("otSpecimenDispatchEntryList");

			if (otSpecimenDispatchEntryList.size() > 0) {
				jsp = SEARCH_SHOW_OT_SPECIMEN_DISPATCH_ENTRY_JSP;
			} else {
				entryNo = otHandlerService.getEntryNoForDisplay();
				if (entryNo != null) {
					map.put("entryNo", entryNo);
				}
				jsp = OT_SPECIMEN_DISPATCH_ENTRY_FOR_INPATIENT_JSP;
			}
			jsp += ".jsp";
			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView submitOtSpecimenDispatchEntry(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		int departmentId = Integer.parseInt(request
				.getParameter("departmentId"));

		int visitId = 0;
		if ((request.getParameter("visitId")) != null
				&& !(request.getParameter("visitId").equals(""))) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		int empBy = 0;
		int empRev = 0;
		int otBookingId = 0;
		String entryNo = "";
		String timeOfDispatch = "";
		String examinationRequired = "";
		String clinicalNotes = "";
		String tissueOrgan = "";
		String dateOfDispatch = "";
		String userName = null;

		boolean submitData = false;

		if ((request.getParameter("empBy")) != null
				&& !(request.getParameter("empBy").equals("0"))) {
			empBy = Integer.parseInt(request.getParameter("empBy"));

		}
		if (!request.getParameter("userName").equals("")) {
			userName = request.getParameter("userName");
		}
		if ((request.getParameter("empRev")) != null
				&& !(request.getParameter("empRev").equals("0"))) {
			empRev = Integer.parseInt(request.getParameter("empRev"));
		}
		if (!request.getParameter("entryNo").equals("")) {
			entryNo = request.getParameter("entryNo");
		}
		if (!request.getParameter("timeOfDispatch").equals("")) {
			timeOfDispatch = request.getParameter("timeOfDispatch");
		}
		if (request.getParameter("dateOfDispatch") != null) {
			dateOfDispatch = request.getParameter("dateOfDispatch");
		}
		if (!request.getParameter("examinationRequired").equals("")) {
			examinationRequired = request.getParameter("examinationRequired");
		}
		if (!request.getParameter("clinicalNotes").equals("")) {
			clinicalNotes = request.getParameter("clinicalNotes");
		}
		if (!request.getParameter("tissueOrgan").equals("")) {
			tissueOrgan = request.getParameter("tissueOrgan");
		}
		if (request.getParameter("otBookingId") != null
				&& !request.getParameter("otBookingId").equals("")) {
			otBookingId = Integer.parseInt(request.getParameter("otBookingId"));
		}

		// ----------data for Post Anesthesia Procedure ------
		mapForDS.put("tissueOrgan", tissueOrgan);
		mapForDS.put("hinId", hinId);
		mapForDS.put("departmentId", departmentId);
		mapForDS.put("visitId", visitId);
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("clinicalNotes", clinicalNotes);
		mapForDS.put("examinationRequired", examinationRequired);
		mapForDS.put("timeOfDispatch", timeOfDispatch);
		mapForDS.put("entryNo", entryNo);
		mapForDS.put("empRev", empRev);
		mapForDS.put("empBy", empBy);
		mapForDS.put("userName", userName);
		mapForDS.put("dateOfDispatch", dateOfDispatch);
		mapForDS.put("otBookingId", otBookingId);

		boolean bool = otHandlerService.submitOtSpecimenDispatchEntry(mapForDS);
		String message = null;
		if (bool) {
			message = "Specimen Dispatch Entry Submitted Successfully!!Do you want to print ? ";
		} else {

			message = " Try Again !!";
		}
		jsp = "specimenDispatchEntryJsp";
		jsp += ".jsp";

		map.put("deptId", departmentId);
		map.put("message", message);
		title = "Specimen Dispatch EntryDetails";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("submitData", submitData);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchOtSpecimenDispatchEntry(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = SEARCH_OT_SPECIMEN_DISPATCH_ENTRY_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings( { "unchecked", "unchecked" })
	public ModelAndView showOtSpecimenDispatchEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String visitNo = "";
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDS.put("serviceNo", serviceNo);
		}
		if (request.getParameter(VISIT_NUMBER) != null) {
			visitNo = request.getParameter(VISIT_NUMBER);
			mapForDS.put("visitNo", visitNo);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			mapForDS.put("hinNo", hinNo);
		}

		map = otHandlerService.showOtSpecimenDispatchEntry(mapForDS);

		jsp = SEARCH_SHOW_OT_SPECIMEN_DISPATCH_ENTRY_JSP;
		jsp += ".jsp";
		title = "Show Ot Specimen Dispatch Entry";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getOTSpecimenDispatchList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		try {
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				detailsMap.put("serviceNo", serviceNo);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				detailsMap.put("hinNo", hinNo);
			}
			List<Object> visitNoList = new ArrayList<Object>();
			List<Object> hinNoList = new ArrayList<Object>();
			String flag = "";

			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("visit")) {
				visitNoList = otHandlerService.getEntryNoList(detailsMap);
				map.put("visitNoList", visitNoList);
				jsp = RESPONSE_FOR_OT_ENTRY_NO;

			} else if (flag.equals("hin")) {
				hinNoList = otHandlerService.getEntryHinNoList(serviceNo);
				map.put("hinNoList", hinNoList);

				jsp = RESPONSE_FOR_OT_ENTRY_HIN_NO;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView updateOtSpecimenDispatchEntry(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		int departmentId = Integer.parseInt(request
				.getParameter("departmentId"));
		int visitId = Integer.parseInt(request.getParameter("visitId"));
		int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		// details captured for Ot Post Anesthesia Procedure table
		int empBy = 0;
		int empRev = 0;
		String entryNo = "";
		String timeOfDispatch = "";
		String examinationRequired = "";
		String clinicalNotes = "";
		String tissueOrgan = "";
		String dateOfDispatch = "";
		String userName = null;
		int specimenId = 0;
		boolean submitData = false;

		if ((request.getParameter("specimenId")) != null
				&& !(request.getParameter("specimenId").equals("0"))) {
			specimenId = Integer.parseInt(request.getParameter("specimenId"));

		}
		if ((request.getParameter("empBy")) != null
				&& !(request.getParameter("empBy").equals("0"))) {
			empBy = Integer.parseInt(request.getParameter("empBy"));

		}
		if (!request.getParameter("userName").equals("")) {
			userName = request.getParameter("userName");
		}
		if ((request.getParameter("empRev")) != null
				&& !(request.getParameter("empRev").equals("0"))) {
			empRev = Integer.parseInt(request.getParameter("empRev"));

		}
		if (!request.getParameter("entryNo").equals("")) {
			entryNo = request.getParameter("entryNo");
		}
		if (!request.getParameter("timeOfDispatch").equals("")) {
			timeOfDispatch = request.getParameter("timeOfDispatch");
		}
		if (request.getParameter("dateOfDispatch") != null) {
			dateOfDispatch = request.getParameter("dateOfDispatch");
		}
		if (!request.getParameter("examinationRequired").equals("")) {
			examinationRequired = request.getParameter("examinationRequired");
		}
		if (!request.getParameter("clinicalNotes").equals("")) {
			clinicalNotes = request.getParameter("clinicalNotes");
		}
		if (!request.getParameter("tissueOrgan").equals("")) {
			tissueOrgan = request.getParameter("tissueOrgan");
		}

		// ----------data for Post Anesthesia Procedure ------
		mapForDS.put("tissueOrgan", tissueOrgan);
		mapForDS.put("specimenId", specimenId);
		mapForDS.put("hinId", hinId);
		mapForDS.put("departmentId", departmentId);
		mapForDS.put("visitId", visitId);
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("clinicalNotes", clinicalNotes);
		mapForDS.put("examinationRequired", examinationRequired);
		mapForDS.put("timeOfDispatch", timeOfDispatch);
		mapForDS.put("entryNo", entryNo);
		mapForDS.put("empRev", empRev);
		mapForDS.put("empBy", empBy);
		mapForDS.put("userName", userName);
		mapForDS.put("dateOfDispatch", dateOfDispatch);

		boolean bool = otHandlerService.updateOtSpecimenDispatchEntry(mapForDS);
		String message = null;
		if (bool) {
			message = "Specimen Dispatch Entry updated successfully!!Do you want to print ?";
		} else {
			message = "Error Occurred !!Try Again !!";
		}
		jsp = "specimenDispatchEntryJsp";
		jsp += ".jsp";

		map.put("deptId", departmentId);
		map.put("message", message);
		map.put("entryNo", entryNo);
		title = "Specimen Dispatch EntryDetails";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("submitData", submitData);
		return new ModelAndView("index", "map", map);

	}

	/**
	 * -------------------- COMMON METHOD FOR REPORT ----------------
	 */
	// -------------Jasper Compiled Report
	// --------------------------------------
	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());

		return jasperReport;
	}

	/**
	 * --------------------- OT LIST REPORT ----------------------
	 */
	public ModelAndView showOtListReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "otListReport" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateOtListReport(HttpServletRequest request,
			HttpServletResponse response) {

		Date fromDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			if (request.getParameter("bookingDate") != null
					&& !(request.getParameter("bookingDate").equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter("bookingDate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> otMap = new HashMap<String, Object>();
		detailsMap = otHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		otMap = otHandlerService.getotAnesDetails(fromDate);

		String summary = (String) otMap.get("anesData");
		//System.out.println("::::::::::::" + summary);
		parameters.put("surgeryDate", fromDate);
		parameters.put("summary", summary);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("ot_list"), parameters,
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

	/**
	 * --------------------- OT Post Anaesthesia REPORT ----------------------
	 */
	public ModelAndView showOtPostAnaesthesiaReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Post Anaesthesia Report";
		jsp = "showOtPostAnaesthesiaReportJsp";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView generateOtPostAnaesthesiaReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("FROM_DATE", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("TO_DATE", toDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("otPostMain", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;
	}
	public ModelAndView showOtDailyPacReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Post Anaesthesia Report";
		jsp = "ot_daily_pac_done";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}
	public ModelAndView generateOtDailyPacReport(HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("from_date", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("to_date", toDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("daily_pac_status_report", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;
	}

	/**
	 * --------------------- OT Specimen Dispatch REPORT ----------------------
	 */
	public ModelAndView showSpecimenDispatchReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Specimen Dispatch Report";
		jsp = "ot_specimenDispatchReport";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateSpecimenDispatchReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("FROM_DATE", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("TO_DATE", toDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("ot_SpecimenDispatchReport", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;
	}

	// ---------------------printHumanBodyDisposal BY
	// Dipali----------------------
	public ModelAndView printHumanBodyDisposal(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		int entryNo = 0;
		try {
			if (request.getParameter("entryNo") != null
					&& !request.getParameter("entryNo").equals("")) {
				entryNo = Integer.parseInt(request.getParameter("entryNo"));
				requestParameters.put("entryNo", entryNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("ot_HumanBodyPartsDisposalEntryNOReport",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return null;
	}

	// -------------generateHumanBodyPartsReport By
	// Dipali--------------------------------
	public ModelAndView generateHumanBodyPartsReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("FROM_DATE", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("TO_DATE", toDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("ot_HumanBodyPartsDisposalReport",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return null;
	}

	// -------------------printSpecimenDispatchEntry---By
	// Dipali--------------------

	public ModelAndView printSpecimenDispatchEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		String entryNo = "";
		try {
			if (request.getParameter("entryNo") != null
					&& !request.getParameter("entryNo").equals("")) {
				entryNo = (request.getParameter("entryNo"));
				requestParameters.put("entryNo", entryNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("ot_SpecimenDispatchEntryNoReport",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return null;
	}

	// ---------------------HumanBodyPartsDisposalReport---By
	// Dipali---------------------------------------
	public ModelAndView showHumanBodyPartsDisposalReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "HumanBodyPartsDisposal";
		jsp = "ot_HumanBodyPartDisposalReport";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	// -------------------printSpecimenDispatchEntry---By
	// Dipali--------------------

	public ModelAndView printOtProcedureNotesEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		String YearlySrNo = "";
		try {
			if (request.getParameter("YearlySrNo") != null
					&& !request.getParameter("YearlySrNo").equals("")) {
				YearlySrNo = (request.getParameter("YearlySrNo"));
				requestParameters.put("YearlySrNo", YearlySrNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));

		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("OT_procedureNotesEntry", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;
	}

	// -------------------printOtPostAnesthesiaProcedureReport---By
	// Dipali--------------------

	public ModelAndView printOtPostAnesthesiaProcedureReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		String yearlySlNo = "";
		try {
			if (request.getParameter("yearlySlNo") != null
					&& !request.getParameter("yearlySlNo").equals("")) {
				yearlySlNo = (request.getParameter("yearlySlNo"));
				requestParameters.put("YearlySrNo", yearlySlNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));

		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("OT_postAnaesthesiaProcedureNotesEntry",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return null;
	}

	// ---------------------WorkLoadRegisterReportReport---By
	// Dipali---------------------------------------
	public ModelAndView showWorkLoadRegisterReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "WorkLoadRegisterReport";
		jsp = OT_WORK_LOAD_REGISTER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateWorkLoadRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		int postYear = 0;
		Box box = HMSUtil.getBox(request);
		postYear = box.getInt("postYear");

		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		requestParameters.put("postYear", postYear);
		HMSUtil.generateReport("ot_WorkLoadReport", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;
	}

	/**
	 * ----------------------- Print PAC Report
	 * -----------------------------------
	 */
	public ModelAndView printPAC(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		int orderNo = 0;
		int hinId = 0;
		String pastRecords = "";
		String presentHistory = "";
		String drugTherapy = "";
		try {
			if (request.getParameter("orderNo") != null) {
				orderNo = Integer.parseInt(request.getParameter("orderNo"));
				//System.out.println("orderNo--->" + orderNo);
				requestParameters.put("orderNo", orderNo);
			}
			if (request.getParameter("hinId") != null) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				requestParameters.put("hinId", hinId);
			}

			if (request.getParameter("pastRecords") != null) {
				pastRecords = (String) request.getParameter("pastRecords");
				requestParameters.put("pastRecords", pastRecords);
			} else {
				requestParameters.put("pastRecords", "");
			}

			if (request.getParameter("presentHistory") != null) {
				presentHistory = (String) request
						.getParameter("presentHistory");
				requestParameters.put("presentHistory", presentHistory);
			} else {
				requestParameters.put("presentHistory", "");
			}

			if (request.getParameter("drugTherapy") != null) {
				drugTherapy = (String) request.getParameter("drugTherapy");
				requestParameters.put("drugTherapy", drugTherapy);
			} else {
				requestParameters.put("drugTherapy", "");
			}
			map = otHandlerService.printPAC(hinId);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		// requestParameters.put("SUBREPORT_DIR",
		// getServletContext().getRealPath("/reports/"));
		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		// if(map.get("PatientStatus").equals("inpatient"))
		// {
		// //System.out.println("entered in inpatient");
		// HMSUtil.generateReport("OT_preAnaestheticAssesmentFormEntryForIP",requestParameters,(Connection)connectionMap.get("con"),response,
		// getServletContext());
		// }
		// else if(map.get("PatientStatus").equals("outpatient"))
		// {
		// //System.out.println("entered in out patient");
		HMSUtil.generateReport("OT_preAnaestheticAssesmentFormEntry",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		// }
		return null;

	}

	public ModelAndView printOtPreAnesthesiaNotesEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		String YearlySrNo = "";
		try {
			if (request.getParameter("yearlySerialNo") != null
					&& !request.getParameter("yearlySerialNo").equals("")) {
				YearlySrNo = (request.getParameter("yearlySerialNo"));
				requestParameters.put("YearlySrNo", YearlySrNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("YearlySrNo----in cotroller>>>>>>>>." + YearlySrNo);
		requestParameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));

		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("ot_preAnaesthesiaProcedureNotes",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSurgeryEnquiryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		String jsp = "";
		map = otHandlerService.getDetailsForSurgeryEnquiry();

		jsp = "surgeryEnquiry";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchsurgeryForEnquiry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> enquiryMap = new HashMap<String, Object>();
		Map<String, Object> surgeryMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonName = "";

		String patientName = "";
		String patientMiddleName = "";
		String patientLastName = "";

		String serPersonFirstName = "";
		String serPersonMiddleName = "";
		String serPersonLastName = "";

		int hinId = 0;
		String address = "";
		int districtId = 0;
		int stateId = 0;
		String patientStatus = "";
		@SuppressWarnings("unused")
		Box box = HMSUtil.getBox(request);
		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				enquiryMap.put("hinNo", hinNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				enquiryMap.put("adNo", adNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				enquiryMap.put("serviceNo", serviceNo);
			}
			if (!(request.getParameter(SERVICE_TYPE_ID).equals("0"))) {
				serviceTypeId = Integer.parseInt(request
						.getParameter(SERVICE_TYPE_ID));
				enquiryMap.put("serviceTypeId", serviceTypeId);
			}
			if (!(request.getParameter(RANK_ID).equals("0"))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				enquiryMap.put("rankId", rankId);
			}
			if (!(request.getParameter(UNIT_ID).equals("0"))) {
				unitId = Integer.parseInt(request.getParameter(UNIT_ID));
				enquiryMap.put("unitId", unitId);
			}

			if (request.getParameter(SERVICE_PERSON_NAME) != null
					&& !(request.getParameter(SERVICE_PERSON_NAME).equals(""))) {
				serPersonFirstName = request.getParameter(SERVICE_PERSON_NAME);
				enquiryMap.put("serPersonFirstName", serPersonFirstName);
			}
			if (request.getParameter(S_MIDDLE_NAME) != null
					&& !(request.getParameter(S_MIDDLE_NAME).equals(""))) {
				serPersonMiddleName = request.getParameter(S_MIDDLE_NAME);
				enquiryMap.put("serPersonMiddleName", serPersonMiddleName);
			}
			if (request.getParameter(S_LAST_NAME) != null
					&& !(request.getParameter(S_LAST_NAME).equals(""))) {
				serPersonLastName = request.getParameter(S_LAST_NAME);
				enquiryMap.put("serPersonLastName", serPersonLastName);
			}

			if (request.getParameter(PATIENT_NAME) != null
					&& !(request.getParameter(PATIENT_NAME).equals(""))) {
				patientName = request.getParameter(PATIENT_NAME);
				enquiryMap.put("patientName", patientName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMiddleName = request.getParameter(P_MIDDLE_NAME);
				enquiryMap.put("patientMiddleName", patientMiddleName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLastName = request.getParameter(P_LAST_NAME);
				enquiryMap.put("patientLastName", patientLastName);
			}

			if (request.getParameter(ADDRESS) != null
					&& !(request.getParameter(ADDRESS).equals(""))) {
				address = request.getParameter(ADDRESS);
				enquiryMap.put("address", address);
			}
			if (!(request.getParameter(DISTRICT_ID).equals("0"))) {
				districtId = Integer
						.parseInt(request.getParameter(DISTRICT_ID));
				enquiryMap.put("districtId", districtId);
			}
			if (!(request.getParameter(STATE_ID).equals("0"))) {
				stateId = Integer.parseInt(request.getParameter(STATE_ID));
				enquiryMap.put("stateId", stateId);
			}
			if (request.getParameter("hinId") != null) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				enquiryMap.put("hinId", hinId);
			}
			if (request.getParameter(PATIENT_STATUS) != null
					&& !(request.getParameter(PATIENT_STATUS).equals(""))) {
				patientStatus = request.getParameter(PATIENT_STATUS);
				enquiryMap.put("patientStatus", patientStatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		surgeryMap = otHandlerService.getSurgeryDetailsForEnquiry(enquiryMap);
		map = otHandlerService.getDetailsForSurgeryEnquiry();

		String jsp = "surgeryEnquiry";
		jsp += ".jsp";
		map.put("surgeryMap", surgeryMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getSurgeryDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = otHandlerService.getSurgeryDetails(box);
		jsp = "surgeryDetails";
		// jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView orderSeqchange(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int bookingId = 0;
		int deptId = (Integer) session.getAttribute("deptId");
		String bookingDate = null;
		int otId = 0;
		int seqId = 0;
		// String bookingTime =null;
		mapForDS.put("deptId", deptId);
		if (request.getParameter("bookingId") != null) {
			bookingId = Integer.parseInt(request.getParameter("bookingId"));
		}
		if (request.getParameter("otId") != null) {
			otId = Integer.parseInt(request.getParameter("otId"));
		}
		if (request.getParameter("seqId") != null) {
			seqId = Integer.parseInt(request.getParameter("seqId"));
		}
		if (request.getParameter("bookingDate") != null) {
			bookingDate = request.getParameter("bookingDate");
		}

		mapForDS.put("bookingId", bookingId);
		mapForDS.put("bookingDate", bookingDate);
		mapForDS.put("otId", otId);
		mapForDS.put("seqId", seqId);
		// mapForDS.put("bookingTime", bookingTime);
		map = otHandlerService.orderSeqChange(mapForDS);
		jsp = "otListChange";
		jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("otName", otId);
		map.put("bookingDate", bookingDate);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateOTChanges(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int bookingId = 0;
		int deptId = (Integer) session.getAttribute("deptId");
		String bookingDate = null;
		int otId = 0;
		int seqId = 0;
		String changeCriteria = null;
		// String bookingTime =null;
		mapForDS.put("deptId", deptId);
		if (request.getParameter("otId") != null) {
			otId = Integer.parseInt(request.getParameter("otId"));
		}
		if (request.getParameter("seqId") != null) {
			seqId = Integer.parseInt(request.getParameter("seqId"));
		}
		if (request.getParameter("bookingDate") != null) {
			bookingDate = request.getParameter("bookingDate");
		}

		if (request.getParameter("changeCriteria") != null) {
			changeCriteria = request.getParameter("changeCriteria");
		}
		if (request.getParameter("bookingId") != null) {
			bookingId = Integer.parseInt(request.getParameter("bookingId"));
		}

		mapForDS.put("bookingId", bookingId);
		mapForDS.put("bookingDate", bookingDate);
		mapForDS.put("otId", otId);
		mapForDS.put("seqId", seqId);
		mapForDS.put("changeCriteria", changeCriteria);
		// mapForDS.put("bookingTime", bookingTime);
		// //System.out.println("::bookingId:::::"+bookingId);
		// //System.out.println("::bookingDate:::::"+bookingDate);
		// //System.out.println("::otId:::::"+otId);
		// //System.out.println("::seqId:::::"+seqId);
		map = otHandlerService.updateOTChanges(mapForDS);
		jsp = "otListChange";
		jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("otName", otId);
		map.put("bookingDate", bookingDate);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitAnesthesiologist(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Box box = HMSUtil.getBox(request);
		//System.out.println("box contents" + box);

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		List<OtAnesthesiologist> otAnesList = new ArrayList<OtAnesthesiologist>();
		HttpSession session = request.getSession();
		int bookingId = 0;
		String bookingDate = null;
		int otId = 0;
		int seqId = 0;
		String date = "";
		String time = "";
		int panesI = 0;
		int panesII = 0;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		int deptId = (Integer) session.getAttribute("deptId");
		String userName = (String) session.getAttribute("userName");

		Vector anesIArr = box.getVector("anesI");
		Vector anesIIArr = box.getVector("anesII");
		Vector otanesArr = box.getVector("otanesId");

		// String bookingTime =null;
		mapForDS.put("deptId", deptId);

		if (request.getParameter("bookingDate") != null) {
			bookingDate = request.getParameter("bookingDate");
		}
		if (request.getParameter("otId") != null) {
			otId = Integer.parseInt(request.getParameter("otId"));
		}

		if (request.getParameter("panesI") != null) {
			panesI = Integer.parseInt(request.getParameter("panesI"));
		}
		if (request.getParameter("panesII") != null) {
			panesII = Integer.parseInt(request.getParameter("panesII"));
		}
		//System.out.println("::::::::::" + anesIIArr.size());
		for (int i = 0; i < anesIIArr.size(); i++) {
			if (!anesIArr.get(i).toString().equals("0")
					|| !anesIIArr.get(i).toString().equals("0")) {
				OtAnesthesiologist otAnes = new OtAnesthesiologist();
				otAnes.setSurgeryDate(HMSUtil
						.convertStringTypeDateToDateType(bookingDate));
				otAnes.setOt(new MasOt(Integer.parseInt(otanesArr.get(i)
						.toString())));
				if (!anesIArr.get(i).toString().equals("0")) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(Integer.parseInt(anesIArr.get(i)
							.toString()));
					// masEmployee.setId(5);
					otAnes.setAnes1Id(masEmployee);
				}

				if (!anesIIArr.get(i).toString().equals("0")) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(Integer.parseInt(anesIIArr.get(i)
							.toString()));
					// masEmployee.setId(7);
					otAnes.setAnes2Id(masEmployee);
				}
				otAnes.setLastChgdBy(userName);
				otAnes.setLastChgdDate(HMSUtil
						.convertStringTypeDateToDateType(date));
				otAnes.setLastChgdTime(time);
				otAnesList.add(otAnes);
			}
		}

		if (panesI != 0 || panesII != 0) {
			OtAnesthesiologist otAnes = new OtAnesthesiologist();
			otAnes.setSurgeryDate(HMSUtil
					.convertStringTypeDateToDateType(bookingDate));
			// otAnes.setOt(new MasOt(otId));
			otAnes.setPac("P");

			if (panesI != 0) {
				MasEmployee masEmployee1 = new MasEmployee();
				masEmployee1.setId(panesI);
				otAnes.setAnes1Id(masEmployee1);
			}
			if (panesII != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(panesII);
				otAnes.setAnes2Id(masEmployee);
			}
			otAnes.setLastChgdBy(userName);
			otAnes.setLastChgdDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			otAnes.setLastChgdTime(time);
			otAnesList.add(otAnes);
		}

		mapForDS.put("otAnesList", otAnesList);
		mapForDS.put("bookingDate", bookingDate);
		mapForDS.put("otId", otId);
		// mapForDS.put("bookingTime", bookingTime);
		map = otHandlerService.submitAnesthesiologist(mapForDS);
		jsp = "otListChange";
		jsp += ".jsp";
		title = "";
		map.put("otName", otId);
		map.put("bookingDate", bookingDate);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSurgeryStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		mapForDS.put("deptId", deptId);
		String bookingDate = new String();
		int nextOt = 0;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");

		if (request.getParameter("bookingDate") != null)
			bookingDate = (String) request.getParameter("bookingDate");

		if (request.getParameter("nextOt") != null) {
			nextOt = (Integer.parseInt(request.getParameter("nextOt")));
		}
		mapForDS.put("bookingDate", currentDate);
		mapForDS.put("nextOt", nextOt);
		map = otHandlerService.getActualOTPerformedScheduleForDisplay(mapForDS);

		jsp = "SurgeryStatus";
		// jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("bookingDate", currentDate);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView(jsp, "map", map);
	}

	public void displayDepartmentOT(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasOtDistribution> DeptOTList = new ArrayList<MasOtDistribution>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
/*		int deptId = 0;
		if (session.getAttribute(DEPARTMENT_ID) != null) {
			deptId = (Integer) session.getAttribute(DEPARTMENT_ID);
			box.put("deptId", deptId);
		}
		*/
	/*	int unitId = 0;
		if (request.getParameter("unitId") != null) {
			unitId =Integer.parseInt(request.getParameter("unitId"));
			box.put("unitId", unitId);
		}*/
		map = otHandlerService.displayDepartmentOT(box);
		if(map.get("MasOTList") != null){
			DeptOTList = (List)map.get("MasOTList");
		}
		StringBuffer sb = new StringBuffer();
		try {
				sb.append("<item>");
				sb.append("<tables>");
				for (MasOtDistribution DeptOTList1 : DeptOTList) {
					sb.append("<table>");
					//System.out.println("11111111==="+otMasUnitDay.getMasBed().getId());
					//System.out.println("11222==="+otMasUnitDay.getMasBed().getBedNo());
					sb.append("<tableId>" +DeptOTList1.getOt().getId() + "</tableId>");
					sb.append("<tableNo>" + DeptOTList1.getOt().getOtName()
							+ "</tableNo>");
					sb.append("</table>");
				}
				sb.append("</tables>");

				// sb.append("<brands>");
				// for (MasStoreBrand brand : brandList) {
				// sb.append("<brand>");
				// sb.append("<brandId>" + brand.getId() + "</brandId>");
				// sb.append("<brandName>" + brand.getBrandName()
				// + "</brandName>");
				// sb.append("</brand>");
				// }
				// sb.append("</brands>");

				sb.append("</item>");
			

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public void displayOtTableForDepartmentWiseOT(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
	
		List<OtBed> OtBedList = new ArrayList<OtBed>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
		}
		
	//	System.out.println(deptId +"ddd" +session.getAttribute("deptId") +session.getAttribute("deptId"));
		int otId = 0;
		if (request.getParameter("otId") != null) {
			otId =Integer.parseInt(request.getParameter("otId"));
			box.put("otId", otId);
		}
		map = otHandlerService.displayOtTable(box);
		if(map.get("OtBedList") != null){
			OtBedList = (List)map.get("OtBedList");
		}
		StringBuffer sb = new StringBuffer();
		try {
				sb.append("<item>");
				sb.append("<tables>");
				for (OtBed OtBedList1 : OtBedList) {
					sb.append("<table>");
					//System.out.println("11111111==="+otMasUnitDay.getMasBed().getId());
					//System.out.println("11222==="+otMasUnitDay.getMasBed().getBedNo());
					sb.append("<tableId>" +OtBedList1.getBed().getId() + "</tableId>");
					sb.append("<tableNo>" + OtBedList1.getBed().getBedNo()
							+ "</tableNo>");
					sb.append("</table>");
				}
				sb.append("</tables>");

				// sb.append("<brands>");
				// for (MasStoreBrand brand : brandList) {
				// sb.append("<brand>");
				// sb.append("<brandId>" + brand.getId() + "</brandId>");
				// sb.append("<brandName>" + brand.getBrandName()
				// + "</brandName>");
				// sb.append("</brand>");
				// }
				// sb.append("</brands>");

				sb.append("</item>");
			

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	 public void fillMemberForName(HttpServletRequest request,HttpServletResponse response) {
         Map<String, Object> map = new HashMap<String, Object>();
         
         Map<String, Object> dataMap = new HashMap<String, Object>();
         String nameMember = "";
         int empId = 0;
         try {
             if (request.getParameter("nameMember") != null) {
                 nameMember = request.getParameter("nameMember");
             }
             
            if(nameMember!="" && nameMember.contains("[")){
            	
            	 int index1 = nameMember.lastIndexOf("[");
    			 int index2 = nameMember.lastIndexOf("]");
    			 index1++;
    			 try
    			 {
    			 empId =  Integer.parseInt(nameMember.substring(index1, index2));
    			 }
    			 catch(Exception e)
    			 {
    				 e.printStackTrace();
    			 }
            	
            }
             List<MasEmployee> eList = new ArrayList<MasEmployee>();
             
             dataMap.put("nameMember", nameMember);
             dataMap.put("empId", empId);
             map =otHandlerService.fillMemberForName(dataMap);
         
             if (map.get("eList") != null) {
                 eList = (List) map.get("eList");
             }
             StringBuffer sb = new StringBuffer();
          if(eList.size()>0){
                 for (MasEmployee e : eList) {
                     sb.append("<item>");
                     sb.append("<nameMember>" + e.getFirstName() + "</nameMember>");
                     sb.append("<idMember>" + e.getId() + "</idMember>");
                     sb.append("<designation>");
                     if (e.getRank()!= null)
                     {
                         sb.append("<drt>");
                       //  System.out.println("e.getRank().getRankName()=="+e.getRank().getRankName());
                         sb.append("<dName>"+e.getRank().getRankName()+ "</dName>");
                    sb.append("</drt>");
                     }
                     else{
                         sb.append("<drt>");
                         sb.append("<dName>" + "NA" + "</dName>");
                         //sb.append("<designationId>" + "0" + "</designationId>");
                         sb.append("</drt>");
                     }
                     sb.append("</designation>");
                     sb.append("</item>");
                 }
                 }
             //System.out.println("sb>>>>"+sb);
             response.setContentType("text/xml");
             response.setHeader("Cache-Control", "no-cache");

             response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
             response.getWriter().write("<items>");
             response.getWriter().write(sb.toString());
             response.getWriter().write("</items>");
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
	 
	 public ModelAndView showOtDashboard(HttpServletRequest request,HttpServletResponse response) {
			HttpSession session = request.getSession();
			
			int hospitalId = 0;
			String opdFlag =null;
			int surgeryId=0;
			int deptId=0;
			int empId=0;
			int month=0;
			int year=0;
			int ot=0;
			String surgeonName="";
			Calendar calendar=Calendar.getInstance();

		
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			if (session.getAttribute(DEPARTMENT_ID) != null) {
				deptId = (Integer) session.getAttribute(DEPARTMENT_ID);
			}
			if (session.getAttribute("empId") != null) {
				empId = (Integer) session.getAttribute("empId");
			}
			
			
			if (request.getParameter("opdFlag") != null) {
				opdFlag =request.getParameter("opdFlag");
			}
			
			
			
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			

		/*	if(request.getParameter("surgeryId") !=null){
				surgeryId = Integer.parseInt(request.getParameter("surgeryId"));
			}*/
			if(request.getParameter("month") !=null){
				month = Integer.parseInt(request.getParameter("month"));
			}
			else
			{
				month=calendar.get(Calendar.MONTH);
			}
			if(request.getParameter("year") !=null){
				year = Integer.parseInt(request.getParameter("year"));
			}
			else
			{
				year=calendar.get(Calendar.YEAR);
			}

			if(request.getParameter(OT_ID) !=null){
				ot = Integer.parseInt(request.getParameter(OT_ID));
			}
			mapForDS.put(OT_ID, ot);
			mapForDS.put("empId", empId);
			mapForDS.put(DEPARTMENT_ID, deptId);
			mapForDS.put(HOSPITAL_ID, hospitalId);
			mapForDS.put("surgeryId", surgeryId);
			mapForDS.put("month", month);
			mapForDS.put("year", year);

			map = otHandlerService.showCalenderForOt(mapForDS);
			map.put(OT_ID, ot);
			
			jsp = "otCalendar";
			if(opdFlag==null)
			{
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			}
			title = "Ot Schedule";

		
			map.put("title", title);
			map.put("month", month);
			map.put("year", year);
			map.put("surgeryId", surgeryId);
			map.put("opdFlag", opdFlag);
			if(opdFlag==null)
			     return new ModelAndView("index", "map", map);
			else
				return new ModelAndView(jsp, "map", map);
         
	 }
	 public ModelAndView showPreAnesthesiaWaitingList(HttpServletRequest request,
				HttpServletResponse response) {
			HttpSession session = request.getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			//Map<String, Object> patientMap = new HashMap<String, Object>();
			//Map<String, Object> detailsMap = new HashMap<String, Object>();

			int hospitalId = 0;
		//String hinNo = "";
		int empId = 0;
		int otId = 0;
		//String pname = "";
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			mapForDS.put(HOSPITAL_ID, hospitalId);
		}
		
/*		if(request.getParameter("pname") !=null){
			pname = request.getParameter("pname");
			mapForDS.put("pname", pname);
		}*/
		
		if(request.getParameter(PATIENT_NAME)!=null && !request.getParameter(PATIENT_NAME).equals(""))
		{
			mapForDS.put(PATIENT_NAME, request.getParameter(PATIENT_NAME));
		}
		
		if(request.getParameter(EMPLOYEE_ID) !=null && !request.getParameter(EMPLOYEE_ID).equals("")){
			mapForDS.put(EMPLOYEE_ID, request.getParameter(EMPLOYEE_ID));
		}
/*		if(request.getParameter(HIN_NO) !=null  && !request.getParameter(HIN_NO).equals("")){
			hinNo = request.getParameter(HIN_NO);
			mapForDS.put(HIN_NO, hinNo);
		}*/
		
		if(request.getParameter(SURGERY_DATE) !=null  && !request.getParameter(SURGERY_DATE).equals("")){
			mapForDS.put(SURGERY_DATE, request.getParameter(SURGERY_DATE));
		}
		
		if(request.getParameter(OT_ID) !=null  && !request.getParameter(OT_ID).equals("")){
			otId = Integer.parseInt(request.getParameter(OT_ID));
			mapForDS.put(OT_ID, otId);
		}
		
		
		
		map = otHandlerService.searchOtPatientDetails(mapForDS);

			//map.put("otProcedure", otProcedure);
			String jsp = "";
			jsp = "ot_patientSearch" + ".jsp";

			map.put("map", map);
			//map.put("detailsMap", detailsMap);
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
	 
	 public void checkAvailabilityForSurgeryTime(HttpServletRequest request,
				HttpServletResponse response) {
		 HttpSession session = request.getSession();
		 Map<String, Object> mapForDS = new HashMap<String, Object>();
	
		 
		 mapForDS.put("startTime", request.getParameter("startTime"));
		 mapForDS.put("endTime", request.getParameter("endTime"));
		 mapForDS.put("surgeryDate", request.getParameter("surgeryDate"));
		 if(request.getParameter("otBookingId")!=null && request.getParameter("otBookingId")!="")
		 mapForDS.put("otBookingId", Integer.parseInt(request.getParameter("otBookingId")));
		 map = otHandlerService.checkSurgeryTime(mapForDS);
		 String jsp = "";
		 jsp = "ot_patientSearch" + ".jsp";
	
		 boolean matched=false;
			if(map.get("matched")!=null){
				matched=(Boolean)map.get("matched");
			}
			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			sb.append("<timeAllotted>" + matched + "</timeAllotted>");
			
			if(matched)
			{
			    OtBooking booking = (OtBooking) map.get("bookList");	
				sb.append("<startTimeAllotted>" + booking.getSurgeryStartTime() + "</startTimeAllotted>");
				sb.append("<endTimeAllotted>" + booking.getSurgeryEndTime() + "</endTimeAllotted>");
			}
			
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
		 
		 
/*		boolean result = false;
		if (map.get("result") != null)
			result = (Boolean) map.get("result");

		if (result == true) {
			map.put("message", "Time slot is available");
		}
		else
			map.put("message", "Time slot is not available");*/

		
		
		//map.put("contentJsp", jsp);
		//return new ModelAndView("index", "map", map);
	 }
	 
	
	 public ModelAndView requestFromPAClearance(HttpServletRequest request,
				HttpServletResponse response) {
		 HttpSession session = request.getSession();
		 Map<String, Object> mapForDS = new HashMap<String, Object>();
		 //int docId = 0;
		 int deptId=0;
		 int hospitalId = 0;
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				mapForDS.put(HOSPITAL_ID, hospitalId);
			}
	
			if (session.getAttribute("deptId") != null) {
				 deptId =  (Integer) session.getAttribute("deptId");
					mapForDS.put("deptId", deptId);
					
				}
		/*	if (session.getAttribute("empId") != null) {
				docId = (Integer)session.getAttribute("empId");
				mapForDS.put("docId", docId);
				
			}*/
			
		 map = otHandlerService.PACClearanceListForConsultation(mapForDS);
		 String jsp = "";
		 jsp = "PACClearanceListForConsultation" + ".jsp";
		
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	 }
	 
	 
	 public ModelAndView showPreAnethesiaFormForAdvice(HttpServletRequest request,
				HttpServletResponse response) {
		 HttpSession session = request.getSession();
		 Map<String, Object> mapForDS = new HashMap<String, Object>();
		 int surgeryId = 0;
		 int hospitalId = 0;
		 int deptId=0;
		// int docId = 0;
			/*if (session.getAttribute("empId") != null) {
				docId = (Integer)session.getAttribute("empId");
				mapForDS.put("docId", docId);
				
			}*/
		 if (session.getAttribute("deptId") != null) {
			 deptId =  (Integer) session.getAttribute("deptId");
				mapForDS.put("deptId", deptId);
				
			}
		 
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				mapForDS.put(HOSPITAL_ID, hospitalId);
			}
			if (request.getParameter("surgeryId") != null) {
				surgeryId = Integer.parseInt(request.getParameter("surgeryId"));
				mapForDS.put("surgeryId", surgeryId);
			}

			map = otHandlerService.viewPreAnesthesiaDetails(mapForDS);
			jsp = OT_VIEW_PRE_ANESTHESIA_DETAILS;
			jsp += ".jsp";
			title = "Pre-Anesthesia Form";

			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
	 }

	 
	 public ModelAndView submitDoctorAdviceForPACClearance(HttpServletRequest request,
				HttpServletResponse response) {
		 HttpSession session = request.getSession();
		 Map<String, Object> mapForDS = new HashMap<String, Object>();
		 int surgeryId = 0;
		 int hospitalId = 0;
		 int docId = 0;
		 int hbt = 0;
		 int deptId=0;

			List<Integer> dtIdList = new ArrayList<Integer>();
			List<String> adviceList = new ArrayList<String>();
		 
		 if (request.getParameter("hbt") != null) {
				hbt = Integer.parseInt(request.getParameter("hbt"));
				
				for(int i =1; i<=hbt;i++)
				{
					
					if(request.getParameter("question"+i)!=null && !request.getParameter("question"+i).equals(""))
					{
					dtIdList.add( Integer.parseInt(request.getParameter("question"+i)));
					adviceList.add( request.getParameter("answer"+i));
					}
				}
				
				mapForDS.put("dtIdList", dtIdList);
				mapForDS.put("adviceList", adviceList);
			}
		 
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				mapForDS.put(HOSPITAL_ID, hospitalId);
			}
			

			 if (session.getAttribute("deptId") != null) {
					 deptId =  (Integer) session.getAttribute("deptId");
						mapForDS.put("deptId", deptId);
						
					}
			if (session.getAttribute("empId") != null) {
				docId = (Integer)session.getAttribute("empId");
				mapForDS.put("docId", docId);
				
			}

			if (request.getParameter("surgeryId") != null) {
				surgeryId = Integer.parseInt(request.getParameter("surgeryId"));
				
				mapForDS.put("surgeryId", surgeryId);
			}
				mapForDS.put("doctorAdvice", request.getParameter("doctorAdvice"));
	
				boolean succesfullyAdded =otHandlerService.submitDoctorAdviceForPACClearance(mapForDS);
				if (succesfullyAdded) {
					message = "Advice captured sucessfully";
				} else {
					message = "Advice could not saved";

				}
		
			 map = otHandlerService.PACClearanceListForConsultation(mapForDS);
			 map.put("message", message);
			 String jsp = "";
			 jsp = "PACClearanceListForConsultation" + ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
	 }
	 
	 
	 
	 
	 public ModelAndView anesthesiaRecordWaitingList(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			
			int hospitalId = 0;
		//	String hinNo = "";
			int empId = 0;
			int otId = 0;
			String pname = "";
			
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				mapForDS.put(HOSPITAL_ID, hospitalId);
			}
			
		
			if(request.getParameter(PATIENT_NAME)!=null && !request.getParameter(PATIENT_NAME).equals(""))
			{
				mapForDS.put(PATIENT_NAME, request.getParameter(PATIENT_NAME));
			}
			
			if(request.getParameter(EMPLOYEE_ID) !=null && !request.getParameter(EMPLOYEE_ID).equals("")){
				mapForDS.put(EMPLOYEE_ID, request.getParameter(EMPLOYEE_ID));
			}
			/*if(request.getParameter(HIN_NO) !=null  && !request.getParameter(HIN_NO).equals("")){
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put(HIN_NO, hinNo);
			}
			*/
			if(request.getParameter(SURGERY_DATE) !=null  && !request.getParameter(SURGERY_DATE).equals("")){
				mapForDS.put(SURGERY_DATE, request.getParameter(SURGERY_DATE));
			}
			
			if(request.getParameter(OT_ID) !=null  && !request.getParameter(OT_ID).equals("")){
				otId = Integer.parseInt(request.getParameter(OT_ID));
				mapForDS.put(OT_ID, otId);
			}
			
			
		 map = otHandlerService.getAnesthesiaRecordWaitingList(mapForDS);
		 String jsp = "";
		 jsp = "anesthesiaRecordWaitingList" + ".jsp";
		
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	 }

public ModelAndView showUploadingDocumentsJspForAnesthesiaRecord(HttpServletRequest request,
				HttpServletResponse response) {
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		details.put("bookingId", bookingId);
		details.put("flag", "n");
		
		int userId = 0;
		if (session.getAttribute(USER_ID) != null) {
			userId = (Integer) session.getAttribute(USER_ID);
			details.put(USER_ID, userId);
		}
		
		details.put("uploadType", "record");
		
		map = otHandlerService.submitDocumentForOT(details);
		//map.put("opdSurgeryId", opdSurgeryId);
		
		 String jsp = "";
		 jsp = "uploadAndViewAnesthesiaRecordDocuments" + ".jsp";
		
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView uploadAndViewDocuments(HttpServletRequest request,
				HttpServletResponse response) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> details = new HashMap<String, Object>();

			HttpSession session = request.getSession();
			int departmentId = 0;
			int hospitalId = 0;
			int hinId=0;
			String flag="n";	
			String uploadFrom ="NA";
			int bookingId = 0;
			
			 MultipartFormDataRequest mrequest = null;
		     if (MultipartFormDataRequest.isMultipartFormData(request))
		        {
		             try
		             {
		                 mrequest = new MultipartFormDataRequest(request);
		             }
		             catch (UploadException e)
		             {
		                 e.printStackTrace();
		             }
		             catch (IOException e)
		             {
		                 e.printStackTrace();
		             }
		        }
		     if(mrequest.getParameter("hinId")!=null){
		    	 hinId= Integer.parseInt((String)mrequest.getParameter("hinId"));
		       	 details.put("hinId", Integer.parseInt((String)mrequest.getParameter("hinId")));
		        }
		     
		     if(mrequest.getParameter("uploadFrom")!=null){
		    	 uploadFrom= (String)mrequest.getParameter("uploadFrom");
		       	 details.put("uploadFrom", (String)mrequest.getParameter("uploadFrom"));
		        }
		    
		     if(mrequest.getParameter("bookingId")!=null){
		    	 bookingId = Integer.parseInt(mrequest.getParameter("bookingId"));
		       	 details.put("bookingId", bookingId );
		        }
		     int userId = 0;
		     if (session.getAttribute(USER_ID) != null) {
					userId = (Integer) session.getAttribute(USER_ID);
					details.put(USER_ID, userId);
				}
				

		     String filename = "";
		     String uploadURL="";
//		     if(uploadFrom.equalsIgnoreCase("OPD"))
//		     {
//		    	 uploadURL = getServletContext().getRealPath("/UploadedDocuments/OPD/"+hinId+"/");
//		     }
		     if(uploadFrom.equalsIgnoreCase("OT"))
		     {
		    	 uploadURL = getServletContext().getRealPath("/UploadedDocuments/OT/"+bookingId+"/");
		     }
		 
		     String comments = "";
		     String fileExtension=null;
		     
		     if (mrequest.getParameter("department") != null) {
		 		departmentId = Integer.parseInt(request.getParameter("department"));
		 	}if (departmentId!=0) {
		 		details.put("departmentId", departmentId);
		 	}
		 	if(mrequest.getParameter("fileName")!= null){
		        filename = mrequest.getParameter("fileName");
		    }
		    
		    if(mrequest.getParameter("flag")!=null){
		      	 flag = (String)mrequest.getParameter("flag");
		       }
		    details.put("flag", flag);
		    
		    if( mrequest.getParameter("comments")!= null){
		        comments = mrequest.getParameter("comments");
		        details.put("comments", comments);
		    }
		    details.put("uploadURL", uploadURL);
		    if(flag.equalsIgnoreCase("y"))
		    {    
		      
		            List fileUploadedList = null;           
		            details.put("filename", filename);
		            StringTokenizer strToken=new StringTokenizer(filename,".");
		            Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
		            filename=strToken.nextToken();
		            fileExtension=strToken.nextToken();
		            String whiteList = "*."+fileExtension;             
		            fileUploadedList = HMSUtil.uploadFileMaintenance(mrequest,uploadURL, whiteList,fileSizeLimit,filename);
		    }    
		        
			details.put("uploadType", mrequest.getParameter("uploadType"));
		     map = otHandlerService.submitDocumentForOT(details);
		     
		     String jsp = "";
			 jsp = "uploadAndViewAnesthesiaRecordDocuments" + ".jsp";
			  String msg="File Successfuly Uploaded.";
			
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);

		}
		
		public ModelAndView viewUploadDocuments(HttpServletRequest request ,HttpServletResponse response) throws SQLException {
		  	Map<String, Object> map = new HashMap<String, Object>();
	    	List<UploadDocuments> uploadDocuments = new ArrayList<UploadDocuments>();
	    	
	    	String filename=null;
	    	String fileExtension=null;
	    	String viewFrom="";
	    	int hinId=0;
	    	int uploadedDocumentId =0;
	    
	    	    Map<String, Object> uploadFileMap = new HashMap<String, Object>();
	    	   
	    	    if(request.getParameter("uploadedDocumentId")!= null){
	    	    	uploadedDocumentId = Integer.parseInt(request.getParameter("uploadedDocumentId"));
	    		}

	    	    uploadDocuments = otHandlerService.getDocumentList(uploadedDocumentId);
	    	    if(request.getParameter("filename")!= null){
	    			filename = request.getParameter("filename");
	    		}
	    		
	    	    StringTokenizer st1=new StringTokenizer(filename,".");
	    		filename=st1.nextToken();
	    		fileExtension=st1.nextToken();
	    	   
	    		try
	    		   {
	    			   if (fileExtension =="doc" || fileExtension =="docx" )
	    			   {
	    			   response.setContentType( "application/vnd.ms-word" );
	    			   }
	    			   else if (fileExtension == "xls" || fileExtension == "xlsx")
	    				   
	    			   {
	    			   response.setContentType( "application/vnd.ms-excel" );
	    			   }
	    			   else if (fileExtension == "pdf")
	    			   {
	    			   response.setContentType( "application/pdf" );
	    			   }else if (fileExtension.trim().equalsIgnoreCase("txt"))
	    			   {
	    			   response.setContentType( "text/plain" );
	    			   }else if (fileExtension.trim().equalsIgnoreCase("ppt"))
	    			   {
	    			   response.setContentType( "application/ppt" );
	    			   }else if (fileExtension == "png" )
	    			   {
	    			   response.setContentType( "image/png" );
	    			   }else if (fileExtension == "jpeg" )
	    			   {
	    				   
	    			   response.setContentType( "image/jpeg" );
	    			   }else if (fileExtension == "wbmp" )
	    			   {
	    			   response.setContentType( "image/vnd.wap.wbmp" );
	    			   }else if (fileExtension == "gif" )
	    			   {
	    			   response.setContentType( "image/gif");
	    			   }else if (fileExtension == "jpg" )
	    			   {
	    			   response.setContentType( "image/jpg" );
	    			   }
	    			   else
	    			   {
	    			   response.setContentType( "application/octet-stream" );
	    			   }
	    		   
	    		   response.setHeader ("Content-Disposition", "attachment;filename="+java.net.URLEncoder.encode(request.getParameter("filename"))+"");
	    		   //File f = new File(uploadURL+""+filename+"."+fileExtension);
	    		   for(UploadDocuments doc: uploadDocuments)
	    		   {
	    			   byte[] bytes = doc.getPatientDocument();
	    			   Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
	    			   InputStream in = blob.getBinaryStream();
	                 
	    	       
	    	       response.getOutputStream().flush();
	    	      ServletOutputStream outs = response.getOutputStream();
	    	      
	    	      // Create the byte array to hold the data
	        	 
	        
	        	     int offset = 0;
	        	     int numRead = 0;
	        	     while (offset < bytes.length
	        	    		 && (numRead=in.read(bytes, offset, bytes.length-offset)) >= 0) {
	        	    	 offset += numRead;
	        	     }
	        
	        	     if (offset < bytes.length) {
	        	     }
	        	     outs.write(bytes);
	        	     in.close();
	    	   } 
	    		   }
	    	   catch (IOException ioe) 
	    	   {
	    		   ioe.printStackTrace();
	    	   }
	    	
	    		return null;
		}
		
		public ModelAndView showPreOperativeCheckList(HttpServletRequest request,
				HttpServletResponse response) {
			HttpSession session=request.getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			Map<String, Object> patientMap = new HashMap<String, Object>();
			//Map<String, Object> detailsMap = new HashMap<String, Object>();

			// String serviceNo = "";
			String patientFName = "";
			String patientMName = "";
			String patientLName = "";
			String otProcedure = "";
			int otId = 0;

			try {
				
				if(request.getParameter(PATIENT_NAME)!=null && !request.getParameter(PATIENT_NAME).equals(""))
				{
					mapForDS.put(PATIENT_NAME, request.getParameter(PATIENT_NAME));
				}
				
				if(request.getParameter(EMPLOYEE_ID) !=null && !request.getParameter(EMPLOYEE_ID).equals("")){
					mapForDS.put(EMPLOYEE_ID, request.getParameter(EMPLOYEE_ID));
				}
			/*	if(request.getParameter(HIN_NO) !=null  && !request.getParameter(HIN_NO).equals("")){
					hinNo = request.getParameter(HIN_NO);
					mapForDS.put(HIN_NO, hinNo);
				}*/
				
				if(request.getParameter(SURGERY_DATE) !=null  && !request.getParameter(SURGERY_DATE).equals("")){
					mapForDS.put(SURGERY_DATE, request.getParameter(SURGERY_DATE));
				}
				
				if(request.getParameter(OT_ID) !=null  && !request.getParameter(OT_ID).equals("")){
					otId = Integer.parseInt(request.getParameter(OT_ID));
					mapForDS.put(OT_ID, otId);
				}
				
				mapForDS.put(HOSPITAL_ID, (Integer)session.getAttribute(HOSPITAL_ID));

			} catch (Exception e) {
				e.printStackTrace();
			}

			map = otHandlerService.searchPreOperativeCheckList(mapForDS);
		//	map.put("otProcedure", otProcedure);
			String jsp = "";
			jsp = "ot_patientSearchForPreOperative" + ".jsp";

			//map.put("patientMap", patientMap);
			//map.put("detailsMap", detailsMap);
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView showPreOperativeCheckListEntryJsp(
				HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession();
			int deptId = (Integer) session.getAttribute("deptId");
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			String hinNo = request.getParameter("hinNo");
			
			int bookingId = Integer.parseInt(request.getParameter("bookingId"));
			String yearlySerialNo = "";
			if (request.getParameter("yearlySerialNo") != null) {
				yearlySerialNo = request.getParameter("yearlySerialNo");
				mapForDS.put("yearlySerialNo", yearlySerialNo);
			}
			mapForDS.put("hinNo", hinNo);
			mapForDS.put("bookingId", bookingId);

			try {
				map = otHandlerService.showPreOperativeCheckListEntryJsp(mapForDS);
				
			  	jsp = "OT_PreOperativeDetails";
				//jsp = "OT_preAnaesthesiaProcedureNotesEntry";

				jsp += ".jsp";
				// map.put("yearlySerialNo", yearlySerialNo);
				map.put("deptId", deptId);
				map.put("contentJsp", jsp);
				map.put("title", title);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView submitPreOperativeCheckList(
				HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String hinNo = request.getParameter("hinNo");
			String otProcedure = null;
			int hospitalId = 0;
			String yearlySerialNo = "";
			String[] pvmsNoId = request.getParameterValues("pvmsNoId");
			List<Integer> pvmsNoList = new ArrayList<Integer>();
			boolean dataSaved = false;

		/*	int hdb = 1;
			if (Integer.parseInt(request.getParameter("hdb")) != 1) {
				hdb = Integer.parseInt(request.getParameter("hdb"));
			}*/

		
			//List injCategoryList = new ArrayList();
			
			 int empId = 0;
			
			 
				int hdb = 1;
				if (Integer.parseInt(request.getParameter("hdb")) != 1) {
					hdb = Integer.parseInt(request.getParameter("hdb"));
				}
				
			
				List<Integer> itemList = new ArrayList<Integer>();
				List<String> batchList = new ArrayList<String>();
				List<Integer> issuedStockList = new ArrayList<Integer>();
				for (int j = 1; j <=hdb; j++) {
					String pvmsNo = "";
					int itemId = 0;
					if (request.getParameter("nomenclature" + j) != null && !request.getParameter("nomenclature" + j).equals("")) {

						if (request.getParameter("itemId" + j) != null && !request.getParameter("nomenclature" + j).equals("")) {
							 itemId =Integer.parseInt(request.getParameter("itemId" + j));
							if (itemId != 0) {
								  itemList.add(itemId);
							}
						
						}
						 
							String batch = "";
							if(request.getParameter("batch" + j) != null && !request.getParameter("batch" + j).equals("")){
								batch = request.getParameter("batch" + j);
							}
							
							int issuedStock = 0;
							if(request.getParameter("dosage" + j) != null && !request.getParameter("dosage" + j).equals("")){
								issuedStock = Integer.parseInt(request.getParameter("dosage" + j));
							}
							 
					
							  issuedStockList.add(issuedStock);
							  batchList.add(batch);
						 
					}
				}
				
				mapForDS.put("itemList",itemList);
				mapForDS.put("issuedStockList",issuedStockList);
				mapForDS.put("batchList",batchList);
				
				
				List<String> nomenclatureList = new ArrayList<String>();
				List<Integer> itemIdList = new ArrayList<Integer>();
				List<Integer> frequencyList = new ArrayList<Integer>();
				List<String> dosageList = new ArrayList<String>();
				List<String> remarksList = new ArrayList<String>();
				List<String> instructionList = new ArrayList<String>();
				List<Integer> totalList = new ArrayList<Integer>();
				List<Integer> noOfDaysList = new ArrayList<Integer>();
				
				int nomenclaturehdb = 1;
				if (Integer.parseInt(request.getParameter("nomenclaturehdb")) != 1) {
					nomenclaturehdb = Integer.parseInt(request.getParameter("nomenclaturehdb"));
				}
				String[] pvmsArr = new String[nomenclaturehdb];
				Integer[] itemIdArr = new Integer[nomenclaturehdb];
	
				// List<String> nomenclatureList = new ArrayList<String>();
				List<Integer> classificationList = new ArrayList<Integer>();
				// List injCategoryList = new ArrayList();
				//int j = 500;
				for (int j = 500; j <=nomenclaturehdb; j++) {
					String pvmsNo = "";
					int itemId = 0;
					if (request.getParameter("itemId" + j) != null
							&& !request.getParameter("nomenclature" + j).equals("")) {
						itemId = Integer.parseInt(request.getParameter("itemId" + j));
						if (itemId != 0) {
							itemIdList.add(itemId);
						

						if (request.getParameter("itemIdClassificationId" + j) != null
								&& !request.getParameter("itemIdClassificationId" + j)
										.equals("")) {
							classificationList.add(Integer.parseInt(request
									.getParameter("itemIdClassificationId" + j)));
						} else
							classificationList.add(0);
						}
					} 
					
					if((request.getParameter("itemId" + j) != null && !request.getParameter("nomenclature" + j).equals("")) )
					{
					int frequencyId = 0;
					if (request.getParameter("frequency" + j) != null
							&& !request.getParameter("frequency" + j).equals("")) {
						frequencyId = Integer.parseInt(request.getParameter("frequency"
								+ j));
						frequencyList.add(frequencyId);
					} else {
						frequencyList.add(0);
					}

					BigDecimal frequenceValue = new BigDecimal("0");
					if (request.getParameter("frequencyValue" + j) != null
							&& !request.getParameter("frequencyValue" + j).equals("")) {
						frequenceValue = new BigDecimal(
								request.getParameter("frequencyValue" + j));
					}

					String dosage = "";
					if (request.getParameter("dosage" + j) != null
							&& !request.getParameter("dosage" + j).equals("")) {
						dosage = request.getParameter("dosage" + j);
						dosageList.add(dosage);
					} else {
						dosageList.add("");
					}
					if (request.getParameter("noOfDays" + j) != null
							&& !request.getParameter("noOfDays" + j).equals("")) {
						int noOfDays = Integer.parseInt(request.getParameter("noOfDays"
								+ j));
						noOfDaysList.add(noOfDays);

					} else {
						noOfDaysList.add(0);
					}
					if (request.getParameter("total" + j) != null
							&& !request.getParameter("total" + j).equals("")) {
						int total = Math.round(Float.parseFloat(request
								.getParameter("total" + j)));
						totalList.add(total);
					} else {
						totalList.add(0);
					}

					String remarks = "";
					if (request.getParameter("remarks" + j) != null
							&& !request.getParameter("remarks" + j).equals("")) {
						remarks = request.getParameter("remarks" + j);
						remarksList.add(remarks);
					} else {
						remarksList.add("");
					}
				}
		

					
				}
				
				
			
				mapForDS.put("frequencyList", frequencyList);
				mapForDS.put("dosageList", dosageList);
				mapForDS.put("itemIdList", itemIdList);
				mapForDS.put("classificationList", classificationList);
				mapForDS.put("totalList", totalList);
				mapForDS.put("noOfDaysList", noOfDaysList);
				mapForDS.put("remarksList", remarksList);

			 
		/*	int j = 1;
			for (int i = 0; i < hdb; i++) {
				String pvmsNo = "";
				int itemId = 0;
				if (request.getParameter("nomenclature" + j) != null && !request.getParameter("nomenclature" + j).equals("")) {

					String nomenclature = request.getParameter("nomenclature" + j);
					StringTokenizer strToken = new StringTokenizer(c, "[");
					String nomen= strToken.nextToken();
					String nomen = request.getParameter("nomenclature" + j).substring(0, request.getParameter("nomenclature" + j).indexOf("["));
					nomenclatureList.add(nomen);
					//int index1 = nomenclature.lastIndexOf("[");
					//int index2 = nomenclature.lastIndexOf("]");
					//System.out.println("index1=="+index1);
					//System.out.println("index2=="+index2);
					//index1++;
					//pvmsNo = nomenclature.substring(index1, index2);
					 int index1 = nomenclature.lastIndexOf("(");
					 int index2 = nomenclature.lastIndexOf(")");
					 //System.out.println("index1=="+index1);
					// System.out.println("index2=="+index2);
					 index1++;
					 itemId =Integer.parseInt(nomenclature.substring(index1, index2));
					if (itemId != 0) {
						itemIdList.add(itemId);
					}
					otherMedicineList.add("");
				}else{
					if(request.getParameter("otherMedicine"+ j) != null && !request.getParameter("otherMedicine"+ j).equals("")){
						otherMedicine = request.getParameter("otherMedicine"+ j);
						otherMedicineList.add(otherMedicine);
						itemIdList.add(0);
					}
				}
				int itemConversionId = 0;
				if(request.getParameter("itemConversionId" + j) != null && !request.getParameter("itemConversionId" + j).equals("")){
					itemConversionId =Integer.parseInt(request.getParameter("itemConversionId" + j));
					itemConversionList.add(itemConversionId);
				}	else {
					itemConversionList.add(0);
				}
				
				int frequencyId = 0;
				if(request.getParameter("frequency" + j) != null && !request.getParameter("frequency" + j).equals("")){
					frequencyId = Integer.parseInt(request.getParameter("frequency" + j));
					frequencyList.add(frequencyId);
				}else {
					frequencyList.add(0);
				}
				if(request.getParameter("ct" + j) != null){
					ctList.add("y");
				}	else {
					ctList.add("n");
				}

				String route = "";
				if(request.getParameter("route" + j) != null && !request.getParameter("route" + j).equals("")){
					route = request.getParameter("route" + j);
					routeList.add(route);
				}	else {
					routeList.add("");
				}
				
				BigDecimal frequenceValue = new BigDecimal("0");
				if(request.getParameter("frequencyValue" + j) != null && !request.getParameter("frequencyValue" + j).equals("")){
					frequenceValue = new BigDecimal(request.getParameter("frequencyValue" + j));
				}	
				
				String dosage = "";
				if(request.getParameter("dosage" + j) != null && !request.getParameter("dosage" + j).equals("")){
					dosage = request.getParameter("dosage" + j);
					dosageList.add(dosage);
				}else{
					dosageList.add("");
				}
				if(request.getParameter("noOfDays" + j) != null && !request.getParameter("noOfDays" + j).equals("")){
					int noOfDays = Integer.parseInt(request.getParameter("noOfDays" + j));
					noOfDaysList.add(noOfDays);
					//int noOfdoges=1;
					//if(dosage!=null && dosage!=""){
						//noOfdoges=Integer.parseInt(dosage);
					//}
					//int total = noOfDays * frequenceValue*noOfdoges;
					//totalList.add(total);
					
				}else {
					noOfDaysList.add(0);
				}
				if(request.getParameter("total" + j) != null && !request.getParameter("total" + j).equals("")){
					
					int total = Math.round(Float.parseFloat(request.getParameter("total" + j)));
					totalList.add(total);
				}else {
					totalList.add(0);
				}
				
			
				String remarks = "";
				if(request.getParameter("remarks" + j) != null && !request.getParameter("remarks" + j).equals("")){
					remarks = request.getParameter("remarks" + j);
					remarksList.add(remarks);
				}else {
					remarksList.add("");
				}

			
				//if(!pvmsNo.equals("")){
					//pvmsNoList.add(pvmsNo);
				//}
				//	pvmsNoList.add(pvmsArr[i]);

				j++;
			}
			
			mapForDS.put("itemIdList", itemIdList);
			mapForDS.put("frequencyList", frequencyList);
			mapForDS.put("ctList", ctList);
			mapForDS.put("dosageList", dosageList);
			mapForDS.put("typeLeftRightList", typeLeftRightList);
			mapForDS.put("instructionList", instructionList);
			mapForDS.put("routeList", routeList);
			mapForDS.put("totalList", totalList);
			mapForDS.put("noOfDaysList", noOfDaysList);
			mapForDS.put("otherMedicineList", otherMedicineList);
			mapForDS.put("nomenclatureList", nomenclatureList);
			mapForDS.put("itemConversionList", itemConversionList);*/
			
	/*		List empIdList = new ArrayList();
			List<String> roleList = new ArrayList<String>();
			int surgeonHiddenValue = 0;
			if (request.getParameter("surgeonHiddenValue") != null
					&& !request.getParameter("surgeonHiddenValue").equals("")) {
				surgeonHiddenValue = Integer.parseInt(request.getParameter("surgeonHiddenValue"));
				if(surgeonHiddenValue >1)
					surgeonHiddenValue -=1;
			}*/
		
	/*		for (int i = 1; i <= surgeonHiddenValue; i++) {
				String surgeonName = request.getParameter("surgeonName" + i);
			
				if (surgeonName!=null && !surgeonName.equals("")) {
					int index1 = surgeonName.indexOf("[");
					index1 = index1 + 1;
					int index2 = surgeonName.lastIndexOf("]");
					String surgeonId = surgeonName.substring(index1, index2);
				     empId = Integer.parseInt(surgeonId);
					empIdList.add(empId);
					String role = request.getParameter("role" + i);
					if (!role.equals("")) {
						roleList.add(role);
					}
				}
				
			}
			mapForDS.put("empIdList", empIdList);
			mapForDS.put("roleList", roleList);*/
			
			
		/*	for (int i = 0; i < pvmsNoId.length; i++) {
				int pvmsNo = Integer.parseInt(pvmsNoId[i]);
				pvmsNoList.add(pvmsNo);
			}*/
			if (request.getParameter("otProcedure") != null
					&& !(request.getParameter("otProcedure").equals(""))) {
				otProcedure = request.getParameter("otProcedure");
			}

			if (request.getParameter("yearlySqNo") != null) {
				yearlySerialNo = request.getParameter("yearlySqNo");
				mapForDS.put("yearlySerialNo", yearlySerialNo);
			}
			if (session.getAttribute(LOGIN_NAME) != null) {
				userName = (String) session.getAttribute(LOGIN_NAME);
				mapForDS.put("userName", userName);
			}
			mapForDS.put("hinNo", hinNo);

		
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				mapForDS.put(HOSPITAL_ID, hospitalId);
			}


			if (session.getAttribute("empId") != null) {
				empId = (Integer)session.getAttribute("empId");
				mapForDS.put("empId", empId);
				
			}
			
		
			int departmentId = 0;
			if (session.getAttribute("deptId") != null) {
				 departmentId = (Integer) session.getAttribute("deptId");
					mapForDS.put("deptId", departmentId);
				
			}
			
			int userId = 0;
			if (session.getAttribute(USER_ID) != null) {
				userId = (Integer) session.getAttribute(USER_ID);
				mapForDS.put(USER_ID, userId);
				
			}
			
			mapForDS.put("box", box);
			
			
			
			try {
				map = otHandlerService.submitPreOperativeCheckList(mapForDS);
					
				map.put("otProcedure", "no");
				if (map.get("dataSaved") != null) {
					dataSaved = (Boolean) map.get("dataSaved");
				}
				if (dataSaved == true) {
//					message = "Data Saved Sucessfully!! Do you want to print?";
					message = "Data Saved Sucessfully!!";
					map.put("message", message);
				}
				jsp = "Ot_msgSurgeryOperativeNotes";
				jsp += ".jsp";
				map.put("yearlySerialNo", yearlySerialNo);
				//map.put("deptId", deptId);
				map.put("contentJsp", jsp);
				map.put("title", title);
				//pacsTest(request, response);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			return new ModelAndView("index", "map", map);
		}
		
		
		
		public ModelAndView showConsentEntryJsp(HttpServletRequest request,
				HttpServletResponse response) {
			HttpSession session = request.getSession();
			int deptId = (Integer) session.getAttribute("deptId");
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			//String hinNo = request.getParameter("hinNo");
			int bookingId = 0;
			if(request.getParameter("bookingId")!=null && !request.getParameter("bookingId").trim().equals("")){
				bookingId = Integer.parseInt(request.getParameter("bookingId"));
			}
			
			String yearlySerialNo = "";
			if (request.getParameter("yearlySerialNo") != null) {
				yearlySerialNo = request.getParameter("yearlySerialNo");
				mapForDS.put("yearlySerialNo", yearlySerialNo);
			}
			
		     int userId = 0;
		     if (session.getAttribute(USER_ID) != null) {
					userId = (Integer) session.getAttribute(USER_ID);
					mapForDS.put(USER_ID, userId);
				}
			mapForDS.put("bookingId", bookingId);
			mapForDS.put("uploadType", "consent");
			try {
			//	map = otHandlerService.showConsentFormEntryJsp(mapForDS);
				map = otHandlerService.submitDocumentForOT(mapForDS);
				jsp = "OT_ConsentEntryDetails";

				jsp += ".jsp";
				// map.put("yearlySerialNo", yearlySerialNo);
				map.put("deptId", deptId);
			//	map.put("inpatientId", inpatientId);
				map.put("contentJsp", jsp);
				map.put("title", title);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			return new ModelAndView("index", "map", map);
			
			
		}
		
		public ModelAndView showOtConsentDetails(HttpServletRequest request,
				HttpServletResponse response) {
			HttpSession session=request.getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			//Map<String, Object> detailsMap = new HashMap<String, Object>();

			// String serviceNo = "";
		
			int otId = 0;

			try {
				
				if(request.getParameter(PATIENT_NAME)!=null && !request.getParameter(PATIENT_NAME).equals(""))
				{
					mapForDS.put(PATIENT_NAME, request.getParameter(PATIENT_NAME));
				}
				
				if(request.getParameter(EMPLOYEE_ID) !=null && !request.getParameter(EMPLOYEE_ID).equals("")){
					mapForDS.put(EMPLOYEE_ID, request.getParameter(EMPLOYEE_ID));
				}
				if(request.getParameter(SURGERY_DATE) !=null  && !request.getParameter(SURGERY_DATE).equals("")){
					mapForDS.put(SURGERY_DATE, request.getParameter(SURGERY_DATE));
				}
				
				if(request.getParameter(OT_ID) !=null  && !request.getParameter(OT_ID).equals("")){
					otId = Integer.parseInt(request.getParameter(OT_ID));
					mapForDS.put(OT_ID, otId);
				}
				
				mapForDS.put(HOSPITAL_ID, (Integer)session.getAttribute(HOSPITAL_ID));
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			map = otHandlerService.searchOtPatientConsentDetails(mapForDS);

			String jsp = "ot_patientSearchForConsent";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			//map.put("patientMap", patientMap);
			return new ModelAndView("index", "map", map);
		}

		
		public ModelAndView showTransferToWardWaitingList(HttpServletRequest request,
				HttpServletResponse response) {
			HttpSession session=request.getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapForDS = new HashMap<String, Object>();

			//Map<String, Object> detailsMap = new HashMap<String, Object>();

			// String serviceNo = "";
		
			int otId = 0;

			try {
				
				if(request.getParameter(PATIENT_NAME)!=null && !request.getParameter(PATIENT_NAME).equals(""))
				{
					mapForDS.put(PATIENT_NAME, request.getParameter(PATIENT_NAME));
				}
				
				if(request.getParameter(EMPLOYEE_ID) !=null && !request.getParameter(EMPLOYEE_ID).equals("")){
					mapForDS.put(EMPLOYEE_ID, request.getParameter(EMPLOYEE_ID));
				}
				if(request.getParameter(SURGERY_DATE) !=null  && !request.getParameter(SURGERY_DATE).equals("")){
					mapForDS.put(SURGERY_DATE, request.getParameter(SURGERY_DATE));
				}
				
				if(request.getParameter(OT_ID) !=null  && !request.getParameter(OT_ID).equals("")){
					otId = Integer.parseInt(request.getParameter(OT_ID));
					mapForDS.put(OT_ID, otId);
				}
				
				mapForDS.put(HOSPITAL_ID, (Integer)session.getAttribute(HOSPITAL_ID));
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			map = otHandlerService.transferToWardWaitingList(mapForDS);
			String jsp = "ot_transfer_to_ward";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			//map.put("patientMap", patientMap);
			return new ModelAndView("index", "map", map);
	
		}
		
		public ModelAndView showOtPatientToWard(HttpServletRequest request,
				HttpServletResponse response) {
			HttpSession session = request.getSession();
			int deptId = (Integer) session.getAttribute("deptId");
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			//String hinNo = request.getParameter("hinNo");
			int bookingId = 0;
			if(request.getParameter("bookingId")!=null && !request.getParameter("bookingId").trim().equals("")){
				bookingId = Integer.parseInt(request.getParameter("bookingId"));
			}
			
		     int userId = 0;
		     if (session.getAttribute(USER_ID) != null) {
					userId = (Integer) session.getAttribute(USER_ID);
					mapForDS.put(USER_ID, userId);
				}
		     
				int hospitalId = 0;
				if (session.getAttribute(HOSPITAL_ID) != null) {
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					mapForDS.put(HOSPITAL_ID, hospitalId);
				}
			mapForDS.put("bookingId", bookingId);
			try {
			//	map = otHandlerService.showConsentFormEntryJsp(mapForDS);
				map = otHandlerService.showOtPatientToWard(mapForDS);
				jsp = "show_OtPatientDetailsForWardTransfer";

				jsp += ".jsp";
				// map.put("yearlySerialNo", yearlySerialNo);
				map.put("deptId", deptId);
			//	map.put("inpatientId", inpatientId);
				map.put("contentJsp", jsp);
				map.put("title", title);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView submitTransferInformation(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
		//	Transfer transfer = new Transfer();
			int hinId = 0;
			//int fromWardId = 0;
			int toWardId = 0;
			//int fromDoctorId = 0;
			int toDoctorId = 0;
			//int fromBedId = 0;
			int toBedId = 0;
			//int authorizerId = 0;
			int otBookingId =0;
			int inpatientId = 0;
			Map<String, Object> transferMap = new HashMap<String, Object>();
			if(request.getParameter("otBookingId")!=null)
			{
				otBookingId = Integer.parseInt((request.getParameter("otBookingId")));
				
			}
			
	
			
		/*	String adNo = "";
			if(request.getParameter(TRANSFER_NO) != null){
				transfer.setTransferNo(Integer.parseInt(request.getParameter(TRANSFER_NO)));
				
			}*/
			if(request.getParameter(HIN_ID) != null){
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
			}
	/*		if(request.getParameter(AD_NO) != null){
				adNo = request.getParameter(AD_NO);
				transfer.setAdNo(adNo);
			}*/
		/*	if(request.getParameter(FROM_WARD) != null){
				fromWardId = Integer.parseInt(request.getParameter(FROM_WARD));
				MasDepartment fromWardObj = new MasDepartment();
				fromWardObj.setId(fromWardId);
				transfer.setFromWard(fromWardObj);
			}*/
			if(request.getParameter(TO_WARD) != null && !request.getParameter(TO_WARD).equals("0")){
				toWardId = Integer.parseInt(request.getParameter(TO_WARD));
			
			}
	
		/*	if(request.getParameter(FROM_DOCTOR) != null){
				fromDoctorId = Integer.parseInt(request.getParameter(FROM_DOCTOR));
				MasEmployee fromDoctorObj = new MasEmployee();
				fromDoctorObj.setId(fromDoctorId);
				transfer.setFromDoctor(fromDoctorObj);
			}*/
			if( request.getParameter(TO_DOCTOR)!=null && !request.getParameter(TO_DOCTOR).equals("0")){
				toDoctorId = Integer.parseInt(request.getParameter(TO_DOCTOR));
			}
	/*		if(request.getParameter(FROM_BED) != null){
				fromBedId = Integer.parseInt(request.getParameter(FROM_BED));
				MasBed fromBedObj = new MasBed();
				fromBedObj.setId(fromBedId);
				transfer.setFromBed(fromBedObj);
			}*/
			if(request.getParameter(INPATIENT_ID) != null && !request.getParameter(INPATIENT_ID).trim().equals("0")){
				inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			}
			if(request.getParameter(BED_ID)!= null && !request.getParameter(BED_ID).equals("0") && !request.getParameter(BED_ID).equals("")){
				toBedId = Integer.parseInt(request.getParameter(BED_ID));
			}
		
	
		/*	if(request.getParameter(AD_STATUS) != null){
				transfer.setAdStatus(request.getParameter(AD_STATUS));
			}*/


			//Users user = (Users)session.getAttribute("users");
			//int userId = user.getId();
		//	Users userObj = new Users();
			//userObj.setId(userId);
			//transfer.setAddEditBy(userObj);

			int hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			//transfer.setHospital(masHospital);
			
			
			if(request.getParameter("currentDate") != null){
				//Date addEditDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("currentDate"));
				String currentDate = request.getParameter("currentDate");
				transferMap.put("currentDate", currentDate);
			
			}
			if(request.getParameter("currentTime") != null){
				String currentTime = request.getParameter("currentTime");
				transferMap.put("currentTime", currentTime);
	
			}
			//transfer.setStatus("y");
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				transferMap.put(HOSPITAL_ID, hospitalId);
			}
		     if (session.getAttribute(USER_ID) != null) {
							transferMap.put("userId", (Integer) session.getAttribute(USER_ID));
						}
		/*	transferMap.put("adNo", adNo);
			transferMap.put("transfer",transfer);
			transferMap.put("fromBedId", fromBedId);*/
			transferMap.put("toBedId", toBedId);		
			transferMap.put("toDoctorId", toDoctorId);
			transferMap.put("toWardId", toWardId);
			transferMap.put("hospitalId", hospitalId);
			transferMap.put("otBookingId", otBookingId);
			transferMap.put("inpatientId", inpatientId);
			transferMap.put("transferReason", request.getParameter("transferReason"));
			boolean transferedSuccessfully = false;
			transferedSuccessfully = otHandlerService.submitTransferInformation(transferMap);
		/*	int deptId = (Integer)session.getAttribute("deptId");
			String message = "";
			map = ipdHandlerService.getPatientList(deptId,hospitalId);
			List set = (List) map.get("inpatientSet");
			map.put("inPatientSet", set);
			jsp = PATIENT_LIST_JSP+".jsp";*/
		
		
			
			map = otHandlerService.transferToWardWaitingList(transferMap);
			String jsp = "ot_transfer_to_ward"+".jsp";
			if (transferedSuccessfully) {
				message=" Transfer has been completed Successfully.";
			}else{
				message = "Some problem Occured! Try Again.";
			}
			map.put("contentJsp", jsp);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView showOtBookingRegisterJsp(
				HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			map = otHandlerService.showOtBookingRegisterJsp();
			title = "Ot Booking Register";
			jsp = "otBookingRegister";
			jsp = jsp + ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);

			return new ModelAndView("indexB", "map", map);
		}
		// Javed khan
			public ModelAndView generateOtBookingRegister(HttpServletRequest request, HttpServletResponse response) {
				Map<String, Object> requestParameters = new HashMap<String, Object>();
		
				int hospitalId = 0;
				String hospitalName = "";
				String qry="";
				
				HttpSession session = request.getSession();
				try {
					if (session.getAttribute("hospitalId") != null) {
						hospitalId = (Integer) session.getAttribute("hospitalId");
						requestParameters.put("hospitalId", hospitalId);
						hospitalName = otHandlerService.getHospitalName(hospitalId);
						requestParameters.put("HOSP_NAME", hospitalName);
					}
					String userHome = getServletContext().getRealPath("");	         
			        String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
			        requestParameters.put("path", imagePath);
			        if (request.getParameter(EMPLOYEE_ID) != null
							&& !(request.getParameter(EMPLOYEE_ID).equals("0"))) {
						qry += " and me.employee_id = "
								+ Integer.parseInt(request.getParameter(EMPLOYEE_ID)) + "";
					}
			       
			        if (request.getParameter("statusVal") != null
							&& !(request.getParameter("statusVal").equals(""))) {
						qry += " and ob.ot_booking_status = '" + request.getParameter("statusVal") + "'";
					}
			        requestParameters.put("qry", qry);
					Date fromDate = null;
					Date toDate = null;
					if (request.getParameter(FROM_DATE) != null
							&& !(request.getParameter(FROM_DATE).equals(""))) {
						fromDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE));
						requestParameters.put("fromDate", fromDate);
					}
					if (request.getParameter(TO_DATE) != null
							&& !(request.getParameter(TO_DATE).equals(""))) {
						toDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE));
						requestParameters.put("toDate", toDate);
					}
				
				} catch (Exception e) {
					e.printStackTrace();
				}

				
					Map<String, Object> connectionMap = otHandlerService.getConnectionForReport();
					HMSUtil.generateReport("otBookingRegister", requestParameters,
							(Connection) connectionMap.get("con"), response,
							getServletContext());
					return new ModelAndView("indexB", "map", map);

			}
			

			public ModelAndView generatePreAnesthesiaPrint(HttpServletRequest request, HttpServletResponse response) {
				Map<String, Object> requestParameters = new HashMap<String, Object>();
		
				int hospitalId = 0;
				String hospitalName = "";
				String qry="";
				int otPreAnesthesiahdId=0;
				HttpSession session = request.getSession();
				try {
				if (request.getParameter("otPreAnesthesiahdId") != null
						&& !(request.getParameter("otPreAnesthesiahdId").equals(""))) {
					otPreAnesthesiahdId = Integer.parseInt(request.getParameter("otPreAnesthesiahdId"));
				}
				if (session.getAttribute("hospitalId") != null) {
						hospitalId = (Integer) session.getAttribute("hospitalId");
						hospitalName = otHandlerService.getHospitalName(hospitalId);
						requestParameters.put("HOSP_NAME", hospitalName);
						requestParameters.put("hospitalId", hospitalId);
					}
				 	requestParameters.put("oshId", otPreAnesthesiahdId);
		        	String userHome = getServletContext().getRealPath("");	         
		            String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
		            requestParameters.put("path", imagePath);
		            requestParameters.put("HOSP_NAME", hospitalName);
		            requestParameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
				} catch (Exception e) {
				e.printStackTrace();
			}

			
				Map<String, Object> connectionMap = otHandlerService.getConnectionForReport();
				HMSUtil.generateReport("Preanesthesia_assessment", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
				return new ModelAndView("indexB", "map", map);

		

		}

			public ModelAndView generateSurgeryDetailsPrint(HttpServletRequest request, HttpServletResponse response) {
				Map<String, Object> requestParameters = new HashMap<String, Object>();
		
				int hospitalId = 0;
				String hospitalName = "";
				String qry="";
				int bookingId=0;
				HttpSession session = request.getSession();
				try {
				if (request.getParameter("bookingId") != null
						&& !(request.getParameter("bookingId").equals(""))) {
					bookingId = Integer.parseInt(request.getParameter("bookingId"));
				}
				if (session.getAttribute("hospitalId") != null) {
						hospitalId = (Integer) session.getAttribute("hospitalId");
						hospitalName = otHandlerService.getHospitalName(hospitalId);
						requestParameters.put("HOSP_NAME", hospitalName);
						requestParameters.put("hospitalId", hospitalId);
					}
				 	requestParameters.put("bookingId", bookingId);
		        	String userHome = getServletContext().getRealPath("");	         
		            String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
		            requestParameters.put("path", imagePath);
		            requestParameters.put("HOSP_NAME", hospitalName);
		            requestParameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
				} catch (Exception e) {
				e.printStackTrace();
			}

			
				Map<String, Object> connectionMap = otHandlerService.getConnectionForReport();
				HMSUtil.generateReport("Surgery_detail", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
				return new ModelAndView("indexB", "map", map);

		

		}
			public ModelAndView generateOperativeNotesReport(HttpServletRequest request, HttpServletResponse response) {
				Map<String, Object> requestParameters = new HashMap<String, Object>();
		
				int hospitalId = 0;
				String hospitalName = "";
				String qry="";
				int bookingId=0;
				HttpSession session = request.getSession();
				try {
				if (request.getParameter("bookingId") != null
						&& !(request.getParameter("bookingId").equals(""))) {
					bookingId = Integer.parseInt(request.getParameter("bookingId"));
				}
				if (session.getAttribute("hospitalId") != null) {
						hospitalId = (Integer) session.getAttribute("hospitalId");
						hospitalName = otHandlerService.getHospitalName(hospitalId);
						requestParameters.put("HOSP_NAME", hospitalName);
						requestParameters.put("hospitalId", hospitalId);
					}
				 	requestParameters.put("bookingId", bookingId);
		        	String userHome = getServletContext().getRealPath("");	         
		            String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
		            requestParameters.put("path", imagePath);
		            requestParameters.put("HOSP_NAME", hospitalName);
		            requestParameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
				} catch (Exception e) {
				e.printStackTrace();
			}

			
				Map<String, Object> connectionMap = otHandlerService.getConnectionForReport();
				HMSUtil.generateReport("operativeNotesReport", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
				return new ModelAndView("indexB", "map", map);

		

		}
			public ModelAndView generateOtPostAnesthesiaProcedurePrint(HttpServletRequest request, HttpServletResponse response) {
				Map<String, Object> requestParameters = new HashMap<String, Object>();
		
				int hospitalId = 0;
				String hospitalName = "";
				String qry="";
				int mainId=0;
				HttpSession session = request.getSession();
				try {
				if (request.getParameter("mainId") != null
						&& !(request.getParameter("mainId").equals(""))) {
					mainId = Integer.parseInt(request.getParameter("mainId"));
				}
				if (session.getAttribute("hospitalId") != null) {
						hospitalId = (Integer) session.getAttribute("hospitalId");
						hospitalName = otHandlerService.getHospitalName(hospitalId);
						requestParameters.put("HOSP_NAME", hospitalName);
						requestParameters.put("hospitalId", hospitalId);
					}
				 	requestParameters.put("mainId", mainId);
		        	String userHome = getServletContext().getRealPath("");	         
		            String imagePath = userHome+"/jsp/images/logonew-hal.jpg";
		            requestParameters.put("path", imagePath);
		            requestParameters.put("HOSP_NAME", hospitalName);
		            requestParameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
				} catch (Exception e) {
				e.printStackTrace();
			}

			
				Map<String, Object> connectionMap = otHandlerService.getConnectionForReport();
				HMSUtil.generateReport("Anethesia_detail_report", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
				return new ModelAndView("indexB", "map", map);
		}
			
		
			public ModelAndView viewPreAnesthesiaDeials(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> mapForDS = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				int visitId = 0;
				int inpatientId = 0;
				int hospitalId = 0;
				int bookingId = 0;
				String remarks =null;
					if(request.getParameter("visitId")!=null)
					{
						visitId= Integer.parseInt(request.getParameter("visitId"));
								
					}
					
					if(request.getParameter("inpatientId")!=null)
					{
						inpatientId= Integer.parseInt(request.getParameter("inpatientId"));
								
					}
					if(request.getParameter("bookingId")!=null)
					{
						bookingId= Integer.parseInt(request.getParameter("bookingId"));
								
					}
					
					if (session.getAttribute(HOSPITAL_ID) != null) {
						hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					}
				//System.out.println("preAnesthesiaDetailId============="+ preAnesthesiaDetailId);
				mapForDS.put("visitId", visitId);
				mapForDS.put(HOSPITAL_ID, hospitalId);
				mapForDS.put("inpatientId", inpatientId);
				mapForDS.put("bookingId", bookingId);
				map = otHandlerService.getPreAnesthesiaDeials(mapForDS);
				//jsp = OT_VIEW_PRE_ANESTHESIA_DETAILS;
				jsp ="OT_viewPreAnesthesia";
				//jsp += ".jsp";
				title = "Pre-Anesthesia Form";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView(jsp, "map", map);
		}	
			
public ModelAndView viewPostAnesthesiaDeials(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> mapForDS = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				int visitId = 0;
				int inpatientId = 0;
				int hospitalId = 0;
				int bookingId = 0;
				String remarks =null;
					if(request.getParameter("visitId")!=null)
					{
						visitId= Integer.parseInt(request.getParameter("visitId"));
								
					}
					
					if(request.getParameter("inpatientId")!=null)
					{
						inpatientId= Integer.parseInt(request.getParameter("inpatientId"));
								
					}
					if(request.getParameter("bookingId")!=null)
					{
						bookingId= Integer.parseInt(request.getParameter("bookingId"));
								
					}
					
					if (session.getAttribute(HOSPITAL_ID) != null) {
						hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					}
				//System.out.println("preAnesthesiaDetailId============="+ preAnesthesiaDetailId);
				mapForDS.put("visitId", visitId);
				mapForDS.put(HOSPITAL_ID, hospitalId);
				mapForDS.put("inpatientId", inpatientId);
				mapForDS.put("bookingId", bookingId);
				map = otHandlerService.getPostAnesthesiaDeials(mapForDS);
				//jsp = OT_VIEW_PRE_ANESTHESIA_DETAILS;
				jsp ="OT_viewPostAnesthesia";
				//jsp += ".jsp";
				title = "Pre-Anesthesia Form";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView(jsp, "map", map);
		}

public ModelAndView pacsTest(HttpServletRequest request,
		HttpServletResponse response) {
	//System.out.println("R---->");

	PacsHL7Service pacsHL7Service = new PacsHL7Service();
	String query = "";
	// String query="and dt.amount='0.00' and dg.visit_id="+visitId;
	try {
		pacsHL7Service.sendService(query);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}


	return null;
}

}

