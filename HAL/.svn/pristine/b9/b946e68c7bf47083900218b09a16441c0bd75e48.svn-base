package jkt.hms.aviationMedicine.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.adt.handler.RegistrationHandlerService;
import jkt.hms.aviationMedicine.handler.AviationMedicineHandlerService;
import jkt.hms.lab.handler.LabHandlerService;
import jkt.hms.masters.business.AvAccident;
import jkt.hms.masters.business.AvAircraftAccident;
import jkt.hms.masters.business.AvAircrewRationHd;
import jkt.hms.masters.business.AvFlyingIncident;
import jkt.hms.masters.business.AvMedicalExamMaMo;
import jkt.hms.masters.business.AvMedicalUploadDocument;
import jkt.hms.masters.business.AvPilotRegistrationHd;
import jkt.hms.masters.business.AvPreFlight;
import jkt.hms.masters.business.AvPreFlightDt;
import jkt.hms.masters.business.AvSpecialLocalFeature;
import jkt.hms.masters.business.AvTrainingStatusAircrew;
import jkt.hms.masters.business.AviAircrewMedicalLectures;
import jkt.hms.masters.business.AviCa34;
import jkt.hms.masters.business.AviCasualtyAirEvacuation;
import jkt.hms.masters.business.AviFlyingClothingInspection;
import jkt.hms.masters.business.Category;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAircraftType;
import jkt.hms.masters.business.MasCaLicence;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AviationMedicineController extends MultiActionController{
	//-----------------------------------------------------------------------
	AviationMedicineHandlerService aviationMedicineHandlerService = null;
	RegistrationHandlerService registrationHandlerService = null;
	LabHandlerService labHandlerService = null;
	public AviationMedicineHandlerService getAviationMedicineHandlerService() {
		return aviationMedicineHandlerService;
	}
	public void setAviationMedicineHandlerService(
			AviationMedicineHandlerService aviationMedicineHandlerService) {
		this.aviationMedicineHandlerService = aviationMedicineHandlerService;
	}
	public RegistrationHandlerService getRegistrationHandlerService() {
		return registrationHandlerService;
	}

	public void setRegistrationHandlerService(
			RegistrationHandlerService registrationHandlerService) {
		this.registrationHandlerService = registrationHandlerService;
	}
	public LabHandlerService getLabHandlerService() {
		return labHandlerService;
	}

	public void setLabHandlerService(LabHandlerService labHandlerService) {
		this.labHandlerService = labHandlerService;
	}
	//-------------------------------------------------------------------------------
	String jsp="";

	public ModelAndView showCAForm34AJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showCAForm34AJsp(hospitalId);
		
		String jsp = "av_caForm34A.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showRenewableApplicationJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showRenewableApplicationJsp(hospitalId);
		
		String jsp = "av_renewableApplication.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showWaitingListForExaminationMA(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		//---Waiting list for MA by Dipali
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map=aviationMedicineHandlerService.showWaitingListForExaminationMA(hospitalId);
		//----
		jsp = "av_waitingForExaminationMA.jsp";
	
		title = "Waiting List Examination (MA)";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchForAviationMA(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		detailsMap.put("hospitalId",hospitalId);
		Date appointmentDate = new Date();
		String name="";
		String licenceNo="";
		if (request.getParameter(APPOINTMENT_DATE) != null
				&& !(request.getParameter(APPOINTMENT_DATE).equals(""))) {
			appointmentDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(APPOINTMENT_DATE));
			detailsMap.put("appointmentDate", appointmentDate);
		}
		if (request.getParameter(NAME) != null
				&& !(request.getParameter(NAME).equals(""))) {
			name =request.getParameter(NAME);
			detailsMap.put("name", name);
		}
		if (request.getParameter(LICENCE_NO) != null
				&& !(request.getParameter(LICENCE_NO).equals(""))) {
			licenceNo =request.getParameter(LICENCE_NO);
			detailsMap.put("licenceNo", licenceNo);
		}
		map = aviationMedicineHandlerService.getForAviationMA(detailsMap);
		String jsp = "av_waitingForExaminationMA.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showCivilAviationMedExamMAJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		int avica34Id=0;
		int visitId=0;
		HttpSession session = request.getSession();
		int	deptId = (Integer) session.getAttribute("deptId");
		dataMap.put("deptId", deptId);
		if(request.getParameter("avica34Id") !=null && !request.getParameter("avica34Id").equals("0")){
			avica34Id=Integer.parseInt(request.getParameter("avica34Id"));
		}
		dataMap.put("avica34Id", avica34Id);
		if (request.getParameter("visitId") != null && !request.getParameter("visitId").equals("0")){
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		dataMap.put("visitId", visitId);
		map=aviationMedicineHandlerService.showCivilAviationMedExamMAJsp(dataMap);
		jsp = "av_civilAviationMedExamMA.jsp";
		title = "Civil Aviation Med Exam (MA)";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showWaitingListForExaminationMO(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		//---Waiting list for MA by Dipali
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map=aviationMedicineHandlerService.showWaitingListForExaminationMO(hospitalId);
		//----
		jsp = "av_waitListForExamMO.jsp";
	
		title = "Waiting List Examination (MO)";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showCivilAviationMedExamMOJsp(HttpServletRequest request,
			HttpServletResponse response) {
		

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		int medExamMaMoId=0;
		int visitId=0;
		HttpSession session = request.getSession();
		int	deptId = (Integer) session.getAttribute("deptId");
		dataMap.put("deptId", deptId);
		if(request.getParameter("medExamMaMoId") !=null && !request.getParameter("medExamMaMoId").equals("0")){
			medExamMaMoId=Integer.parseInt(request.getParameter("medExamMaMoId"));
		}
		dataMap.put("medExamMaMoId", medExamMaMoId);
		if (request.getParameter("visitId") != null && !request.getParameter("visitId").equals("0")){
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		dataMap.put("visitId", visitId);
		map=aviationMedicineHandlerService.showCivilAviationMedExamMOJsp(dataMap);

		jsp = "av_civilAviationMedExamMO.jsp";
	
		title = "Civil Aviation Med Exam (MO)";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showCAForm34AReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		jsp = "av_cAForm34AReportJsp.jsp";
	
		title = "CA Form 34A Report Jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView generateCAForm34AReport(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		Box box = null;
		if(session.getAttribute("box")!=null){
			box = (Box)session.getAttribute("box");
		}else{
			box = HMSUtil.getBox(request);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (!box.getString(FROM_DATE).equals("")) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE));
		}
		
		if (!box.getString(TO_DATE).equals("")) {
			toDate = HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE));
		}
		String qry = "";
		
		/*if(box.getInt(TYPE_OF_LICENCE)!=0){
			qry += " and B.TYPE_OF_LICENCE_APPLIED = "+box.getInt(TYPE_OF_LICENCE)+"";
		}*/
		if (!(box.getString(FIRST_NAME).equals(""))) {
			qry += " and B.FIRST_NAME='"+HMSUtil.restrictMetaChar(box.getString(FIRST_NAME))+"'";
		}
		if (!(box.getString(LAST_AME).equals(""))) {
			qry += " and B.LAST_NAME='"+HMSUtil.restrictMetaChar(box.getString(LAST_AME))+"'";
		}
		if (!(box.getString(LICENCE_NO).equals(""))) {
			qry += " and B.LICENCE_NO='"+HMSUtil.restrictMetaChar(box.getString(LICENCE_NO))+"'";
		}
		detailsMap = aviationMedicineHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);
		parameters.put("hospitalId", hospitalId);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		HMSUtil.generateReport("av_caForm34A", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}

	public ModelAndView showCAForm35ReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map=aviationMedicineHandlerService.showCAForm34AReportJsp(hospitalId);
		jsp = "av_cAForm35ReportJsp.jsp";
	
		title = "CA Form 35 Report Jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView generateCAForm35Report(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		Box box = null;
		if(session.getAttribute("box")!=null){
			box = (Box)session.getAttribute("box");
		}else{
			box = HMSUtil.getBox(request);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (!box.getString(FROM_DATE).equals("")) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE));
		}
		
		if (!box.getString(TO_DATE).equals("")) {
			toDate = HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE));
		}
		String qry = "";
		if(box.getInt(TYPE_OF_LICENCE)!=0){
			qry = qry
			+  " and B.TYPE_OF_LICENCE_APPLIED = "+box.getInt(TYPE_OF_LICENCE)+"";
		}
		if(box.getInt(TYPE_OF_LICENCE)!=0){
			qry = qry
			+  " and B.TYPE_OF_LICENCE_APPLIED = "+box.getInt(TYPE_OF_LICENCE)+"";
		}
		if (!(box.getString(FIRST_NAME).equals(""))) {
			qry = qry
			+  " and B.First_name='"+box.getString(FIRST_NAME)+"'";
		}
		if (!(box.getString(LAST_AME).equals(""))) {
			qry = qry
			+ " and B.Last_name='"+box.getString(LAST_AME)+"'";
		}
		if (!(box.getString(LICENCE_NO).equals(""))) {
			qry = qry
			+ " and B.LICENCE_NO='"+box.getString(LICENCE_NO)+"'";
		}
		detailsMap = aviationMedicineHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("hospitalId", hospitalId);
		parameters.put("qry", qry);
		HMSUtil.generateReport("caForm35", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	public ModelAndView showAppointmentForMedExam(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int	deptId = (Integer) session.getAttribute("deptId");
		
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("deptId", deptId);
		
		map = aviationMedicineHandlerService.getWaitingAppointMedExamList(mapForDS);
		String jsp = "av_appointmentForMedExam.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	public ModelAndView showPMRFileTrackingJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		map = aviationMedicineHandlerService.getForPMRList(mapForDS);
		String jsp = "av_pmrFileTracking.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView showAircrewMedicalLectureJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showAircrewMedicalLectureJsp(hospitalId);
		
		jsp = "av_aircrewMedicalLectures.jsp";
	
		title = "Aircrew Medical Lecture";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showMOWiseLectureDetailsReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showAircrewLectureRpt(hospitalId,infoMap);
		jsp = "av_moWiseLectureReport.jsp";
	
		title = "MO Wise Lecture Details Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView generateMOLectureSummaryRpt(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date from_date = null;
		Date to_date = null;
		String summary_detail="";
		String reportName="";
		HttpSession session = request.getSession();
		Box box = null;
		if(session.getAttribute("box")!=null){
			box = (Box)session.getAttribute("box");
		}else{
			box = HMSUtil.getBox(request);
		}
		//int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			from_date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null
						&& !(request.getParameter(TO_DATE).equals(""))) {
					to_date = HMSUtil.convertStringTypeDateToDateType(request
							.getParameter(TO_DATE));
				}
		String qry = "";
		int hospitalId=0;
		if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("") && request.getParameter("hospitalId").equals("0")){
			
			qry += "  and h.command_id="+Integer.parseInt(request.getParameter("cmdId"));
		}else{
			if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("")){
				hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
			}else{
				hospitalId = (Integer)session.getAttribute("hospitalId");
			}
			qry += "  and l.hospital_id="+hospitalId;
		}
		parameters.put("hospitalId", hospitalId);
		
		if(box.getInt(MO_NAME)!=0){
			qry += " and L.MO_NAME = "+box.getInt(MO_NAME)+"";
		}
		parameters.put("toDate", to_date);
		parameters.put("fromDate", from_date);
		parameters.put("query", qry);
		
	detailsMap = aviationMedicineHandlerService.getConnectionForReport();
		HMSUtil.generateReport("av_medLectureStats", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	
	public ModelAndView showFlyingClothingInspectionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showFlyingClothingInspectionJsp(hospitalId);
		jsp = "av_flyingClothingInspection.jsp";
	
		title = "Flying Clothing Inspection";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showItemWiseFlyingClothingDetailsReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";

		jsp = "av_itemWiseFlyingClothingDetailReport.jsp";
	
		title = "Item Wise Flying Clothing Check Details Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView generateItemWiseFlyClothReport(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date from_date = null;
		Date to_date = null;
		String query="";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		parameters.put("hospitalId", hospitalId);
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			from_date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
					to_date = HMSUtil.convertStringTypeDateToDateType(request
							.getParameter(TO_DATE));
				}
		parameters.put("to_date", to_date);
		parameters.put("from_date", from_date);
		detailsMap = aviationMedicineHandlerService.getConnectionForReport();
		HMSUtil.generateReport("itemWiseFlyingClothingCheckDetails", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	
	
	public ModelAndView showUnitFlyingClothingDetailsReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showAircrewMedicalLectureJsp(hospitalId);
		jsp = "av_unitWiseFlyingClothingDetailReport.jsp";
	
		title = "Unit Wise Flying Clothing Check Details Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView generateUnitWiseFlyingClothingCheckDetailsReport(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date from_date = null;
		Date to_date = null;

		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		parameters.put("hospitalId", hospitalId);
		if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
			from_date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
			to_date = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		parameters.put("to_date", to_date);
		parameters.put("from_date", from_date);
		detailsMap = aviationMedicineHandlerService.getConnectionForReport();
		HMSUtil.generateReport("unitWiseFlyingClothingCheckDetails", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	
	
	public ModelAndView showCasualtyAirEvacuationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showCasualtyAirEvacuationJsp(hospitalId);
		jsp = "av_casualtyAirEvacuation.jsp";
	
		title = "Casualty Air Evacuation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	
	public ModelAndView showCasualtyAirEvacuationReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";

		jsp = "av_casualtyAirEvacuationReport.jsp";
	
		title = "Casualty Air Evacuation Reports";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView generateCasualtyAirEvacuationReport(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Date from_date = null;
		Date to_date = null;
		
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			from_date = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null
						&& !(request.getParameter(TO_DATE).equals(""))) {
					to_date = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
				}
		detailsMap = aviationMedicineHandlerService.getConnectionForReport();
		parameters.put("to_date", to_date);
		parameters.put("from_date", from_date);
		HMSUtil.generateReport("av_casualty_Air_evacuation", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	public ModelAndView showAircraftAccidentInvestigationJsp(HttpServletRequest request,
			HttpServletResponse response) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showAircraftAccidentInvestigationJsp(hospitalId);
		jsp = "aircraftAccidentInvestigation.jsp";
	
		title = "Aircraft Accident Investigation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showAccidentInvestigationJsp(HttpServletRequest request,
			HttpServletResponse response) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showAircraftAccidentInvestigationJsp(hospitalId);
		jsp = "av_accidentInvestigation.jsp";
			title = "Accident Investigation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showEquipmentInUseJsp(HttpServletRequest request,HttpServletResponse response) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showAircraftAccidentInvestigationJsp(hospitalId);
		jsp = "av_equipmentInUse.jsp";
	
		title = "Equipment In Use";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showMedicalHistoryJsp(HttpServletRequest request,HttpServletResponse response) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showAircraftAccidentInvestigationJsp(hospitalId);
		jsp = "medicalHistory.jsp";
	
		title = "Medical History";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPhysiologicalAndPsychologicalFactorsJsp(HttpServletRequest request,
			HttpServletResponse response) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showAircraftAccidentInvestigationJsp(hospitalId);
		jsp = "physiologicalAndPsychologicalFactors.jsp";
	
		title = "Physiological And Psychological Factors";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showExternalMedicalExaminationJsp(HttpServletRequest request,
			HttpServletResponse response) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showAircraftAccidentInvestigationJsp(hospitalId);
		jsp = "av_externalMedicalExamination.jsp";
	
		title = "External Medical Examination";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showPostMortemJsp(HttpServletRequest request,
			HttpServletResponse response) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showAircraftAccidentInvestigationJsp(hospitalId);
		jsp = "av_postMortem.jsp";
	
		title = "Post Mortem";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showAnUnassistedEscapeFromAnAircraftInFlightJsp(HttpServletRequest request,
			HttpServletResponse response) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showAircraftAccidentInvestigationJsp(hospitalId);
		jsp = "av_unassistEscapeAircraftInFlight.jsp";
	
		title = "An Unassisted Escape From An Aircraft In Flight";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showUseOfEjectionSeatJsp(HttpServletRequest request,
			HttpServletResponse response) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showAircraftAccidentInvestigationJsp(hospitalId);
		jsp = "av_useOfEjectionSeat.jsp";
	
		title = "Use Of Ejection Seat";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showSurvivalFromAnAircraftAccidentJsp(HttpServletRequest request,
			HttpServletResponse response) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = aviationMedicineHandlerService.showAircraftAccidentInvestigationJsp(hospitalId);
		jsp = "av_survivalAircraftAccident.jsp";
	
		title = "Survival From An Aircraft Accident";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	

//-------RenewableApplication---By Dipali-(21/march/2012)----
public ModelAndView submitRenewableApplication(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	AviCa34 aviCa34 = new AviCa34();
	Date lastChgDate = null;
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String time = (String)utilMap.get("currentTimeWithoutSc");
	String lastChgTime = "";
	String lastChgBy = "";
	String message = "";
	String jsp = "";
	Users user = (Users) session.getAttribute("users");
	int userId = user.getId();
	Users userObj = new Users();
	userObj.setId(userId);

	int departmentId = (Integer) session.getAttribute("deptId");
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	//---------------------------------------------------------------
	Patient patient = new Patient();
	
	MasRelation masRelation =new MasRelation();
	masRelation.setId(8);
	patient.setRelation(masRelation);
	
	patient.setRank(new MasRank(179));
	patient.setUnit(new MasUnit(257));
	patient.setServiceType(new MasServiceType(44));
	
	MasServiceStatus serviceStatus=new MasServiceStatus();
	serviceStatus.setId(1);
	patient.setServiceStatus(serviceStatus);

		if (request.getParameter(OCCUPATION_ID) != null && !request.getParameter(OCCUPATION_ID).equals("0")) {
		int occupationId = Integer.parseInt(request
				.getParameter(OCCUPATION_ID));
		MasOccupation masOccupation = new MasOccupation();
		masOccupation.setId(occupationId);
		patient.setOccupation(masOccupation);
	}
	
		patient.setPFirstName(request.getParameter(P_FIRST_NAME));
		patient.setSFirstName(request.getParameter(P_FIRST_NAME));
		
		if (request.getParameter(P_LAST_NAME) != null && !request.getParameter(P_LAST_NAME).equals("")) {
			patient.setPLastName(request.getParameter(P_LAST_NAME));
			patient.setSLastName(request.getParameter(P_LAST_NAME));
		}
		if (request.getParameter(TITLE_ID) != null && !request.getParameter(TITLE_ID).equals("0")) {
			int titleId = Integer.parseInt(request.getParameter(TITLE_ID));
			MasTitle masTitle = new MasTitle();
			masTitle.setId(titleId);
			patient.setTitle(masTitle);
		}
		if (request.getParameter(SR_SEX) != null && !request.getParameter(SR_SEX).equals("0")) {
			int sexId = Integer.parseInt(request.getParameter(SR_SEX));
			MasAdministrativeSex masGender = new MasAdministrativeSex();
			masGender.setId(sexId);
			patient.setSex(masGender);
		}
		if(request.getParameter(SR_DOB) != null && !(request.getParameter(SR_DOB).equals(""))){
			patient.setDateOfBirth(HMSUtil.convertStringTypeDateToDateType(request.getParameter(SR_DOB)));
		}
		if (request.getParameter(SR_AGE) != null && !(request.getParameter(SR_AGE).equals(""))){
			if (request.getParameter(SR_AGE_UNIT) != null) {
				String ageUnit = request.getParameter(SR_AGE_UNIT);
				String srage = request.getParameter(SR_AGE).concat(" ").concat(ageUnit);
				patient.setAge(srage);
			}
		}
		patient.setPatientStatus("Out Patient");
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
		}
		int serviceTypeId = 44;//---for civilan pilot
		
		int relationId = 8; //---For Self
		
		int serviceStatusId = 1; //---Serving
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String currentDate = "";
		String currentTime = "";

		Date date = new Date();
		String datetime = dateFormat.format(date);
		StringTokenizer s = new StringTokenizer(datetime, " ");
		while (s.hasMoreTokens()) {
			currentDate = s.nextToken();
			currentTime = s.nextToken();
		}

		if (serviceTypeId == 44) {
			String serviceNoTemp = "no"; 
			
			try {
				System.out.println("serviceTypeId-->"+currentTime);
				System.out.println("currentTime-->"+currentTime);
				serviceNoTemp = currentDate.substring(0, currentDate
						.indexOf("/"))
						+ currentDate.substring(currentDate.indexOf("/") + 1,
								currentDate.lastIndexOf("/"))
						+ currentDate.substring(
								currentDate.lastIndexOf("/") + 3, currentDate
										.length())
						+ currentTime.substring(0, currentTime.indexOf(":"))
						+ currentTime.substring(currentTime.indexOf(":") + 1,
								currentTime.lastIndexOf(":"))
						+ currentTime.substring(
								currentTime.lastIndexOf(":") + 1, currentTime
										.length());
				serviceNo = serviceNoTemp;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Map<String, Object> serviceAndRelationMap = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("serviceTypeId", serviceTypeId);
		parameterMap.put("relationId", relationId);
		parameterMap.put("serviceStatusId", serviceStatusId);

		serviceAndRelationMap = registrationHandlerService
				.getServiceTypeAndRelation(parameterMap);
		String relationCode = "8";
		String serviceTypeCode = (String) serviceAndRelationMap
				.get("serviceTypeCode");
		String serviceStatusCode = (String) serviceAndRelationMap
				.get("serviceStatusCode");
		String maxSequenceNo = "";
		maxSequenceNo = registrationHandlerService.getHinId(serviceNo,serviceTypeId);
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
		patient.setAddEditBy(user);
		patient.setStatus("y");
		patient.setServiceNo(serviceNo);
		patient.setRegDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		patient.setRegTime(request.getParameter(CHANGED_TIME));
		patient.setHinNo(hinNo);
		Date addEditDate = null;
		if (request.getParameter(CHANGED_DATE) != null) {
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			patient.setAddEditDate(addEditDate);
		}
		String addEditTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			addEditTime = request.getParameter(CHANGED_TIME);
			patient.setAddEditTime(addEditTime);
		}
		patient.setCurrentVisitNo(1);
		//--------Save detail in visit table--
		
		Visit visit=new Visit();
		if (request.getParameter(SR_AGE) != null && !(request.getParameter(SR_AGE).equals(""))){
			if (request.getParameter(SR_AGE_UNIT) != null) {
				String ageUnit = request.getParameter(SR_AGE_UNIT);
				String srage = request.getParameter(SR_AGE).concat(" ").concat(ageUnit);
				visit.setAge(srage);
			}
		}
		visit.setStatus("y");
		visit.setVisitDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		visit.setVisitTime(request.getParameter(CHANGED_TIME));
		visit.setVisitStatus("y");
		Date editDate = null;
		if (request.getParameter(CHANGED_DATE) != null) {
			editDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			visit.setAddEditDate(editDate);
		}
		String editTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			editTime = request.getParameter(CHANGED_TIME);
			visit.setAddEditTime(editTime);
		}
		visit.setAddEditBy(user);
		visit.setVisitNo(1);
		visit.setVisitStatus("C");
		visit.setTokenNo(0);
		visit.setAppointmentType("D");
		visit.setReportingFor("Aviation");
		visit.setPriority(3);
		//-----------------
	if(departmentId !=0){
	MasDepartment masDepartment = new MasDepartment();
	masDepartment.setId(departmentId);
	aviCa34.setDepartment(masDepartment);}
	
	if(hospitalId !=0){
	MasHospital masHospital = new MasHospital();
	masHospital.setId(hospitalId);
	patient.setHospital(masHospital);
	visit.setHospital(masHospital);
	aviCa34.setHospital(masHospital);
	}
	if(request.getParameter(LICENCE_NO) != null){
		aviCa34.setLicenceNo((request.getParameter(LICENCE_NO)));
		dataMap.put("licenceNo", request.getParameter(LICENCE_NO));
	}
	if (request.getParameter(TITLE_ID) != null && !request.getParameter(TITLE_ID).equals("0")) {
		int titleId = Integer.parseInt(request.getParameter(TITLE_ID));
		MasTitle masTitle = new MasTitle();
		masTitle.setId(titleId);
		aviCa34.setTitle(masTitle);
	}
	if (request.getParameter(SR_SEX) != null && !request.getParameter(SR_SEX).equals("0")) {
		int sexId = Integer.parseInt(request.getParameter(SR_SEX));
		MasAdministrativeSex masGender = new MasAdministrativeSex();
		masGender.setId(sexId);
		aviCa34.setSex(masGender);
	}
	if(request.getParameter(P_FIRST_NAME) != null){
		aviCa34.setFirstName(request.getParameter(P_FIRST_NAME));
	}
	if (request.getParameter(P_LAST_NAME) != null) {
		aviCa34.setLastName(request.getParameter(P_LAST_NAME));
	}
	if (request.getParameter(NATIONALITY) != null) {
		aviCa34.setNationality(request.getParameter(NATIONALITY));
}
	if (request.getParameter(PLACE_OF_BIRTH) != null) {
		aviCa34.setPlaceOfBirth((request.getParameter(PLACE_OF_BIRTH)));
	}
	if(request.getParameter(SR_DOB) != null && !(request.getParameter(SR_DOB).equals(""))){
		aviCa34.setDob(HMSUtil.convertStringTypeDateToDateType(request.getParameter(SR_DOB)));
	}
	if (request.getParameter(SR_AGE) != null) {
		if (request.getParameter(SR_AGE_UNIT) != null) {
			String ageUnit = request.getParameter(SR_AGE_UNIT);
			String srage = request.getParameter(SR_AGE).concat(" ").concat(ageUnit);
			aviCa34.setAge(srage);
		}
	}
	if (request.getParameter(OCCUPATION_ID) != null && !request.getParameter(OCCUPATION_ID).equals("0")) {
		int occupationId = Integer.parseInt(request
				.getParameter(OCCUPATION_ID));
		MasOccupation masOccupation = new MasOccupation();
		masOccupation.setId(occupationId);
		aviCa34.setOccupation(masOccupation);
	}
	if (request.getParameter(DISTRICT) != null && !request.getParameter(DISTRICT).equals("0")) {
		int districtId = Integer.parseInt(request.getParameter(DISTRICT));
		MasDistrict masDistrict = new MasDistrict();
		masDistrict.setId(districtId);
		aviCa34.setLocalDistrict(masDistrict);
	}
	if (request.getParameter(ADDRESS) != null) {
		aviCa34.setLocalAddress(request.getParameter(ADDRESS));
	}

	if(request.getParameter(STATE) != null && !request.getParameter(STATE).equals("0")){
		int stateId = Integer.parseInt(request.getParameter(STATE));
		MasState masState = new MasState();
		masState.setId(stateId);
		aviCa34.setLocalState(masState);
	}
	
	if (request.getParameter(TELEPHONE_NO) != null) {
		aviCa34.setTelephoneNo(request.getParameter(TELEPHONE_NO));
	}
	if (request.getParameter(MOBILE_NO) != null) {
		aviCa34.setMobileNo(request.getParameter(MOBILE_NO));
	}
	if(request.getParameter(PERMANENT_ADDRESS) != null ){
		aviCa34.setPermanentAddress(request.getParameter(PERMANENT_ADDRESS));
	}
	if(request.getParameter(PERMANENT_CITY_ID) != null && !request.getParameter(PERMANENT_CITY_ID).equals("0")){
		int pdistrictId = Integer.parseInt(request.getParameter(PERMANENT_CITY_ID));
		MasDistrict permanentDistrict = new MasDistrict();
		permanentDistrict.setId(pdistrictId);
		aviCa34.setPermanentDistrict(permanentDistrict);
	}
	if(request.getParameter(PERMANENT_STATE_ID) != null && !request.getParameter(PERMANENT_STATE_ID).equals("0")){
		int pstateId = Integer.parseInt(request.getParameter(PERMANENT_STATE_ID));
		MasState permanentState = new MasState();
		permanentState.setId(pstateId);
		aviCa34.setPermanentState(permanentState);
	}

	if(request.getParameter(TYPE_OF_LICENCE) != null && !request.getParameter(TYPE_OF_LICENCE).equals("0")){
		MasCaLicence typeOfLicenceApplied = new MasCaLicence();
		typeOfLicenceApplied.setId(Integer.parseInt(request.getParameter(TYPE_OF_LICENCE)));
		aviCa34.setTypeOfLicenceApplied(typeOfLicenceApplied);
	}
	if(request.getParameter(LICENCE_HELD) != null && !request.getParameter(LICENCE_HELD).equals("0")){
		MasCaLicence licenceHeld = new MasCaLicence();
		licenceHeld.setId(Integer.parseInt(request.getParameter(LICENCE_HELD)));
		aviCa34.setLicenceHeld(licenceHeld);
	}
	if(request.getParameter(RENEWAL_DATE) != null && !(request.getParameter(RENEWAL_DATE).equals(""))){
		aviCa34.setRenewalDueDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(RENEWAL_DATE)));
	}
	if (request.getParameter(CHANGED_DATE) != null) {
		lastChgDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(CHANGED_DATE));
		aviCa34.setLastChgDate(lastChgDate);
	}
	if (request.getParameter(CHANGED_BY) != null) {
		lastChgBy = (request.getParameter(CHANGED_BY));
		aviCa34.setLastChgBy(lastChgBy);
	}

	if (request.getParameter(CHANGED_TIME) != null) {
		lastChgTime = request.getParameter(CHANGED_TIME);
		aviCa34.setLastChgTime(time);
	}
	int hinId=0;
	if (request.getParameter("hinId") != null && !request.getParameter("hinId").equals("")) {
		hinId = Integer.parseInt(request.getParameter("hinId"));
		dataMap.put("hinId", hinId);
	}
	int visitId=0;
	if (request.getParameter("visitId") != null && !request.getParameter("visitId").equals("")) {
		visitId = Integer.parseInt(request.getParameter("visitId"));
		dataMap.put("visitId", visitId);
	}
	int avCA34=0;
	if (request.getParameter("avCA34") != null && !request.getParameter("avCA34").equals("0")) {
		avCA34 = Integer.parseInt(request.getParameter("avCA34"));
		dataMap.put("avCA34", avCA34);
	}
	aviCa34.setStatus("w");
	Boolean successfullyAdded = false;
	
	successfullyAdded = aviationMedicineHandlerService.submitRenewableApplication(aviCa34,patient,visit,dataMap);
	
	if(successfullyAdded){
		message="Renewable Application saved Successfully !!";
	}
	else{
		message="Try Again !!";
	}
	String url="";
	url="/hms/hms/aviationMedicine?method=showRenewableApplicationJsp";
	jsp = AV_MESSAGE + ".jsp";
	map.put("url",url);
	map.put("contentJsp", jsp);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
	}
//----Appointment waiting by Dipali(21/march/2012)
public ModelAndView searchMedExamWaitningList(
		HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> mapForDs = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Date fromAppDate = new Date();
	Date toAppDate = new Date();
	Box box = HMSUtil.getBox(request);
	session.setAttribute("box", box);
	session = request.getSession();
	int typeOfLicence=0;
	if (request.getParameter("fromAppDate") != null && !(request.getParameter("fromAppDate").equals(""))) {
		fromAppDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("fromAppDate"));
		mapForDs.put("fromAppDate", fromAppDate);
	}
	if (request.getParameter("toAppDate") != null && !(request.getParameter("toAppDate").equals(""))) {
		toAppDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("toAppDate"));
		mapForDs.put("toAppDate", toAppDate);
	}
	if (request.getParameter(TYPE_OF_LICENCE) != null && !(request.getParameter(TYPE_OF_LICENCE).equals(""))) {
		typeOfLicence = Integer.parseInt(request.getParameter(TYPE_OF_LICENCE));
		mapForDs.put("typeOfLicence", typeOfLicence);
	}
	String jsp = "av_responseAppointMedExam";
	patientMap = aviationMedicineHandlerService.getMedExamWaitningList(mapForDs);
	map.put("patientMap", patientMap);
	return new ModelAndView(jsp, "map", map);

}
//----for Appointment date--By dipali(22/march/2012)----
public ModelAndView submitCheckedAppointment(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> mapForDS = new HashMap<String, Object>();
	Box box = HMSUtil.getBox(request);
	HttpSession session = request.getSession();
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	int	deptId = (Integer) session.getAttribute("deptId");
	
	mapForDS.put("hospitalId", hospitalId);
	mapForDS.put("deptId", deptId);
	String message="";
	Boolean successfullyAdded = false;
	successfullyAdded = aviationMedicineHandlerService.submitCheckedAppointment(box);
	
	if(successfullyAdded){
		message="Appointment Done Successfully !!";
	}
	else{
		message="Try Again !!";
	}
	map = aviationMedicineHandlerService.getWaitingAppointMedExamList(mapForDS);
	String jsp = "av_appointmentForMedExam.jsp";
	map.put("contentJsp", jsp);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}
public ModelAndView submitCancelAppointment(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box = HMSUtil.getBox(request);
	String message="";
	Boolean successfullyAdded = false;
	successfullyAdded = aviationMedicineHandlerService.submitCancelAppointment(box);
	
	if(successfullyAdded){
		message="Appointment Cancel Successfully !!";
	}
	else{
		message="Try Again !!";
	}
	String jsp = "av_appointmentForMedExam.jsp";
	map.put("contentJsp", jsp);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}
public ModelAndView getDetailBasedLicenceNo(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> mapForDs = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	String licenceNo="";
	Box box = HMSUtil.getBox(request);
	session.setAttribute("box", box);
	session = request.getSession();
	if (request.getParameter(LICENCE_NO) != null && !(request.getParameter(LICENCE_NO).equals(""))) {
		licenceNo = request.getParameter(LICENCE_NO);
		mapForDs.put("licenceNo", licenceNo);
	}
	map = aviationMedicineHandlerService.getDetailBasedLicenceNo(mapForDs);
	String jsp = "av_responseBasedLicenceNo";
	return new ModelAndView(jsp, "map", map);

}
//----Submit CA form 34--By dipali(22/march/2012)----
public ModelAndView submitCAForm34A(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> mapForDS = new HashMap<String, Object>();
	Box box = HMSUtil.getBox(request);
	HttpSession session = request.getSession();
	int departmentId = (Integer) session.getAttribute("deptId");
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	mapForDS.put("departmentId", departmentId);
	mapForDS.put("hospitalId", hospitalId);
    int avCA34Id=0;
    if (request.getParameter("avCA34") != null && !(request.getParameter("avCA34").equals(""))) {
    	avCA34Id = Integer.parseInt(request.getParameter("avCA34"));
    	mapForDS.put("avCA34Id", avCA34Id);
	}
    mapForDS.put("box", box);
	Boolean successfullyAdded = false;
	String message="";
	successfullyAdded = aviationMedicineHandlerService.submitCAForm34A(mapForDS);
	
	if(successfullyAdded){
		message="Data saved Successfully !!";
	}
	else{
		message="Try Again !!";
	}
	jsp = AV_MESSAGE + ".jsp";
	map.put("contentJsp", jsp);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
	
}
//---WaitingForACForm34 By dipali(23/mqrch/2012)---
public ModelAndView showWaitingForACForm34Jsp(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String, Object> mapForDs = new HashMap<String, Object>();
	
	map = aviationMedicineHandlerService.getWaitingCurrentCAForm34(mapForDs);
	
	String jsp = "av_appointmentWaiting.jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
//---SearchWaitingForACForm34 By dipali(23/mqrch/2012)---
public ModelAndView searchAppointmentList(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Date fromDate = new Date();
	Date toDate = new Date();
	if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
		fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		detailsMap.put("fromDate", fromDate);
	}
	if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
		toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		detailsMap.put("toDate", toDate);
	}
	map = aviationMedicineHandlerService.getWaitingForACForm34(detailsMap);
	String jsp = "av_appointmentWaiting.jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
public ModelAndView showAvCA34FromWaitingJsp(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> mapForDs = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	int avCA34Id=0;
	Box box = HMSUtil.getBox(request);
	session.setAttribute("box", box);
	session = request.getSession();
	if (request.getParameter("avCA34Id") != null && !(request.getParameter("avCA34Id").equals(""))) {
		avCA34Id = Integer.parseInt(request.getParameter("avCA34Id"));
		mapForDs.put("avCA34Id", avCA34Id);
	}
	map = aviationMedicineHandlerService.getDetailBasedLicenceNo(mapForDs);
	String jsp = "av_caForm34A.jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
//----------By Mansi-(21/march/2012)----	
public ModelAndView submitAircrewMedicalLecture(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String time = (String)utilMap.get("currentTimeWithoutSc");
	AviAircrewMedicalLectures aviAircrewMedicalLectures = new AviAircrewMedicalLectures();
	String message = "";
	String jsp = "";
	String url="";
	
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	MasHospital masHospital = new MasHospital();
	masHospital.setId(hospitalId);
	aviAircrewMedicalLectures.setHospital(masHospital);
	
	int departmentId = (Integer) session.getAttribute("deptId");
	MasDepartment masDepartment = new MasDepartment();
	masDepartment.setId(departmentId);
	aviAircrewMedicalLectures.setDepartment(masDepartment);
	
	if(request.getParameter(LECTURE_SUBJECT) != null && !request.getParameter(LECTURE_SUBJECT).equalsIgnoreCase("")){
		aviAircrewMedicalLectures.setLectureSubject(request.getParameter(LECTURE_SUBJECT));
	}
	if (request.getParameter(MO_NAME) != null && !request.getParameter(MO_NAME).equals("0")) {
		int employeeId = Integer.parseInt(request.getParameter(MO_NAME));
		MasEmployee moName = new MasEmployee();
		moName.setId(employeeId);
		aviAircrewMedicalLectures.setMoName(moName);
	}
	if (request.getParameter(PLACE_OF_LECTURE) != null && !request.getParameter(PLACE_OF_LECTURE).equals("0")) {
		int unitId = Integer.parseInt(request.getParameter(PLACE_OF_LECTURE));
		MasUnit placeOfLecture = new MasUnit();
		placeOfLecture.setId(unitId);
		aviAircrewMedicalLectures.setPlaceOfLecture(placeOfLecture);
	}
	if (request.getParameter(TIME) != null && !request.getParameter(LECTURE_SUBJECT).equalsIgnoreCase("")){
		//aviAircrewMedicalLectures.setTimeStarted((request.getParameter(TIME)));
		aviAircrewMedicalLectures.setTimeStarted(time);
	}

	if(request.getParameter(DATE) != null && !(request.getParameter(DATE).equals(""))){
		aviAircrewMedicalLectures.setAircrewDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE)));
	}
	if (request.getParameter(NUMBER_ATTENDED) != null  && !request.getParameter(NUMBER_ATTENDED).equalsIgnoreCase("")){
		aviAircrewMedicalLectures.setNumberAttended(Integer.parseInt(request.getParameter(NUMBER_ATTENDED)));
	}

	if (request.getParameter(DURATION) != null && !request.getParameter(DURATION).equalsIgnoreCase("")){
		aviAircrewMedicalLectures.setDuration(Integer.parseInt(request.getParameter(DURATION)));
	}
	if (request.getParameter(REMARKS) != null && !request.getParameter(REMARKS).equalsIgnoreCase("")){
		aviAircrewMedicalLectures.setRemarks(request.getParameter(REMARKS));
	}
	Date lastChgDate = null;
	if (request.getParameter(CHANGED_DATE) != null && !request.getParameter(CHANGED_DATE).equalsIgnoreCase("")){
		lastChgDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
		aviAircrewMedicalLectures.setLastChgDate(lastChgDate);
	}

	String lastChgTime = "";
	if (request.getParameter(CHANGED_TIME) != null && !request.getParameter(CHANGED_TIME).equalsIgnoreCase("")){
		lastChgTime = request.getParameter(CHANGED_TIME);
	//	aviAircrewMedicalLectures.setLastChgTime(lastChgTime);
		aviAircrewMedicalLectures.setLastChgTime(time);
	}

	aviAircrewMedicalLectures.setStatus("y");
	
	int hdb = 0;
	if (request.getParameter("hdb") != null) {
		hdb = Integer.parseInt(request.getParameter("hdb"));
	}
	List<String> serviceNoList = new ArrayList<String>();
	List<Integer> rankList = new ArrayList<Integer>();
	List<Integer> hinList = new ArrayList<Integer>();
	List<String> nameList = new ArrayList<String>();
	int j = 1;
	for (int i = 0; i < hdb; i++) {
		String serviceNo = "";
			if(request.getParameter("serviceNo"+ j ) != null && !request.getParameter("serviceNo"+ j ).equals("")){
				serviceNo = request.getParameter("serviceNo"+ j );
				serviceNoList.add(serviceNo);
			}
		int rankId = 0;
		if(request.getParameter("rankId" + j) != null && !request.getParameter("rankId" + j).equals("")){
			rankId =Integer.parseInt(request.getParameter("rankId" + j));
			rankList.add(rankId);
		}else {
			rankList.add(0);
		}	
		int hinId = 0;
		if(request.getParameter("hinId" + j) != null && !request.getParameter("hinId" + j).equals("")){
			hinId = Integer.parseInt(request.getParameter("hinId" + j));
			hinList.add(hinId);
		}else {
			hinList.add(0);
		}

		String name = "";
		if(request.getParameter("sName" + j) != null && !request.getParameter("sName" + j).equals("")){
			name = request.getParameter("sName" +j);
			nameList.add(name);
		}	else {
			nameList.add("");
		}
		j++;
	}
	infoMap.put("nameList",nameList);
	infoMap.put("hinList",hinList);
	infoMap.put("rankList",rankList);
	infoMap.put("nameList",nameList);
	infoMap.put("serviceNoList",serviceNoList);
	Boolean successfullyAdded = false;	
	successfullyAdded = aviationMedicineHandlerService.submitAircrewMedicalLecture(aviAircrewMedicalLectures,infoMap);
	
	if(successfullyAdded){
		message="Aircrew Medical Lecture Information saved Successfully !!";
	}
	else{
		message="Try Again !!";
	}
	url="/hms/hms/aviationMedicine?method=showAircrewMedicalLectureJsp";
	jsp = "av_messageForAircrew";
	jsp += ".jsp";
	map.put("url",url);
	map.put("contentJsp", jsp);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
	}

//---------Submit data For Flying Clothing-----------	
public ModelAndView submitFlyingClothingInspectionJsp(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String time = (String)utilMap.get("currentTimeWithoutSc");
	AviFlyingClothingInspection aviFlyingClothingInspection = new AviFlyingClothingInspection();
	String message = "";
	String jsp = "";
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	MasHospital masHospital = new MasHospital();
	Patient patient = new Patient();
	int hinId=0;
	
	if(request.getParameter("hinId") !=null && !request.getParameter("hinId").equals("")){
		hinId=Integer.parseInt(request.getParameter("hinId"));
		infoMap.put("hinId",hinId);
	}
	if(hinId ==0){
	masHospital.setId(hospitalId);
	patient.setHospital(masHospital);
	
	MasRelation masRelation =new MasRelation();
	masRelation.setId(8);
	patient.setRelation(masRelation);
	
	patient.setServiceType(new MasServiceType(2));
	
	MasServiceStatus serviceStatus=new MasServiceStatus();
	serviceStatus.setId(1);
	patient.setServiceStatus(serviceStatus);
	
		if(request.getParameter(P_FIRST_NAME) != null && !request.getParameter(P_FIRST_NAME).equals("")) {
			patient.setPFirstName(request.getParameter(P_FIRST_NAME));
			patient.setSFirstName(request.getParameter(P_FIRST_NAME));
		}
		if (request.getParameter(P_MIDDLE_NAME) != null&& !request.getParameter(P_MIDDLE_NAME).equals("")) {
			patient.setPMiddleName(request.getParameter(P_MIDDLE_NAME));
		}		
		if (request.getParameter(P_LAST_NAME) != null&& !request.getParameter(P_LAST_NAME).equals("")) {
			patient.setPLastName(request.getParameter(P_LAST_NAME));
		}
		if(request.getParameter(P_FIRST_NAME) != null && !request.getParameter(P_FIRST_NAME).equals("")) {
			patient.setSFirstName(request.getParameter(P_FIRST_NAME));
		}
		if (request.getParameter(P_MIDDLE_NAME) != null&& !request.getParameter(P_MIDDLE_NAME).equals("")) {
			patient.setSMiddleName(request.getParameter(P_MIDDLE_NAME));
		}		
		if (request.getParameter(P_LAST_NAME) != null&& !request.getParameter(P_LAST_NAME).equals("")) {
			patient.setSLastName(request.getParameter(P_LAST_NAME));
		}
		if (request.getParameter(SEX_ID) != null && !request.getParameter(SEX_ID).equals("0")) {
			int sexId = Integer.parseInt(request.getParameter(SEX_ID));
			MasAdministrativeSex masGender = new MasAdministrativeSex();
			masGender.setId(sexId);
			patient.setSex(masGender);
		}
		if (request.getParameter(SR_AGE) != null && !(request.getParameter(SR_AGE).equals(""))){
			if (request.getParameter(SR_AGE_UNIT) != null) {
				String ageUnit = request.getParameter(SR_AGE_UNIT);
				String srage = request.getParameter(SR_AGE).concat(" ").concat(ageUnit);
				patient.setAge(srage);
			}
		}
		if (request.getParameter(RANK_ID) != null && !request.getParameter(RANK_ID).equals("0")) {
			int rankId = Integer.parseInt(request.getParameter(RANK_ID));
			MasRank masRank = new MasRank();
			masRank.setId(rankId);
			patient.setRank(masRank);
		}
		if (request.getParameter(UNIT_ID) != null && !request.getParameter(UNIT_ID).equals("0")) {
			int unitId = Integer.parseInt(request.getParameter(UNIT_ID));
			MasUnit masUnit = new MasUnit();
			masUnit.setId(unitId);
			patient.setUnit(masUnit);
		}
		patient.setPatientStatus("Out Patient");
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
		}
		int serviceTypeId =2;//---for Airforce
		
		int relationId = 8; //---For Self
		
		int serviceStatusId = 1; //---Serving
		
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String currentTime = (String) utilMap.get("currentTime");
		if (serviceTypeId == 2) {
			String serviceNoTemp = "no"; 
			/*
			try {

				serviceNoTemp = currentDate.substring(0, currentDate
						.indexOf("/"))
						+ currentDate.substring(currentDate.indexOf("/") + 1,
								currentDate.lastIndexOf("/"))
						+ currentDate.substring(
								currentDate.lastIndexOf("/") + 3, currentDate
										.length())
						+ currentTime.substring(0, currentTime.indexOf(":"))
						+ currentTime.substring(currentTime.indexOf(":") + 1,
								currentTime.lastIndexOf(":"))
						+ currentTime.substring(
								currentTime.lastIndexOf(":") + 1, currentTime
										.length());
				serviceNo = serviceNoTemp;
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			if(request.getParameter(SERVICE_NO) != null && !request.getParameter(SERVICE_NO).equals("0")) {
				serviceNo=request.getParameter(SERVICE_NO);
			}
		}
		Map<String, Object> serviceAndRelationMap = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("serviceTypeId", serviceTypeId);
		parameterMap.put("relationId", relationId);
		parameterMap.put("serviceStatusId", serviceStatusId);

		serviceAndRelationMap = registrationHandlerService
				.getServiceTypeAndRelation(parameterMap);
		String relationCode = "8";
		String serviceTypeCode = (String) serviceAndRelationMap
				.get("serviceTypeCode");
		String serviceStatusCode = (String) serviceAndRelationMap
				.get("serviceStatusCode");
		String maxSequenceNo = "";
		maxSequenceNo = registrationHandlerService.getHinId(serviceNo,serviceTypeId);
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
		patient.setStatus("y");
		patient.setServiceNo(serviceNo);
		patient.setRegDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		patient.setRegTime(request.getParameter(CHANGED_TIME));
		patient.setHinNo(hinNo);
		Date addEditDate = null;
		if (request.getParameter(CHANGED_DATE) != null) {
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			patient.setAddEditDate(addEditDate);
		}
		String addEditTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			addEditTime = request.getParameter(CHANGED_TIME);
			patient.setAddEditTime(addEditTime);
	}
		infoMap.put("patient",patient);
	}
	int avAccidentId=0;
	if(request.getParameter("avAccidentId") !=null && !request.getParameter("avAccidentId").equals("")){
		avAccidentId=Integer.parseInt(request.getParameter("avAccidentId"));
		infoMap.put("avAccidentId", avAccidentId);
		aviFlyingClothingInspection = aviationMedicineHandlerService.loadFlyingClothing(avAccidentId);
	}
	masHospital.setId(hospitalId);
	aviFlyingClothingInspection.setHospital(masHospital);
	
	int departmentId = (Integer) session.getAttribute("deptId");
	MasDepartment masDepartment = new MasDepartment();
	masDepartment.setId(departmentId);
	aviFlyingClothingInspection.setDepartment(masDepartment);
	
	if(hinId !=0){
	Patient hinPatient=new Patient();
	hinPatient.setId(hinId);
	aviFlyingClothingInspection.setHin(hinPatient);
	}
	if(request.getParameter(SERVICE_NO) != null){
		aviFlyingClothingInspection.setServiceNo(request.getParameter(SERVICE_NO));
	}
	Date flyingDate = null;
	if (request.getParameter(DATE) != null) {
		flyingDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(DATE));
		aviFlyingClothingInspection.setFlyingDate(flyingDate);
	
	}
	if (request.getParameter(RANK_ID) != null && !request.getParameter(RANK_ID).equals("0")) {
		int rankId = Integer.parseInt(request.getParameter(RANK_ID));
		MasRank masRank = new MasRank();
		masRank.setId(rankId);
		aviFlyingClothingInspection.setRank(masRank);
	}
	if (request.getParameter(UNIT_ID) != null && !request.getParameter(UNIT_ID).equals("0")) {
		int unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		MasUnit masUnit = new MasUnit();
		masUnit.setId(unitId);
		aviFlyingClothingInspection.setUnit(masUnit);
	}
	if (request.getParameter(TRADE_ID) != null && !request.getParameter(TRADE_ID).equals("0")) {
		int tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
		MasTrade masTrade = new MasTrade();
		masTrade.setId(tradeId);
		aviFlyingClothingInspection.setTrade(masTrade);
	}
	
	if(request.getParameter(P_FIRST_NAME) != null && !request.getParameter(P_FIRST_NAME).equals("")) {
		aviFlyingClothingInspection.setFirstName(request.getParameter(P_FIRST_NAME));
	}
/*	if (request.getParameter(P_MIDDLE_NAME) != null&& !request.getParameter(P_MIDDLE_NAME).equals("")) {
		aviFlyingClothingInspection.setMiddleName((request.getParameter(P_MIDDLE_NAME).trim()).toUpperCase());
	}
	
*/	if (request.getParameter(P_LAST_NAME) != null&& !request.getParameter(P_LAST_NAME).equals("")) {
		aviFlyingClothingInspection.setLastName(request.getParameter(P_LAST_NAME));
	}
	if(request.getParameter(MASK_STATUS) != null && !request.getParameter(MASK_STATUS).equals("")) {
		aviFlyingClothingInspection.setMaskStatus("y");
	}else{
		aviFlyingClothingInspection.setMaskStatus("n");
	}
	if(request.getParameter(MASK_DATE) != null&& !request.getParameter(MASK_DATE).equals("")) {
		aviFlyingClothingInspection.setMaskDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(MASK_DATE)));
	}
	if(request.getParameter("maskRemarks") != null&& !request.getParameter("maskRemarks").equals("")) {
		aviFlyingClothingInspection.setMaskRemarks(request.getParameter("maskRemarks"));
	}
	if(request.getParameter(HELMET_STATUS) != null&& !request.getParameter(HELMET_STATUS).equals("")) {
		aviFlyingClothingInspection.setHelmetStatus("y");
	}else{
		aviFlyingClothingInspection.setHelmetStatus("n");
	}
	if(request.getParameter(HELMET_DATE) != null&& !request.getParameter(HELMET_DATE).equals("")) {
		aviFlyingClothingInspection.setHelmetDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(HELMET_DATE)));
	}
	if(request.getParameter("helmetRemarks") != null&& !request.getParameter("helmetRemarks").equals("")) {
		aviFlyingClothingInspection.setHelmetRemarks(request.getParameter("helmetRemarks"));
	}
	
	if(request.getParameter(ANTI_G_SUIT_STATUS) != null&& !request.getParameter(ANTI_G_SUIT_STATUS).equals("")) {
		aviFlyingClothingInspection.setAntiGSuitStatus("y");
	}else{
		aviFlyingClothingInspection.setAntiGSuitStatus("n");
	}
	if(request.getParameter(ANTI_G_SUIT_DATE) != null&& !request.getParameter(ANTI_G_SUIT_DATE).equals("")) {
		aviFlyingClothingInspection.setAntiGSuitDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(ANTI_G_SUIT_DATE)));
	}
	if(request.getParameter("antiGSuitRemarks") != null&& !request.getParameter("antiGSuitRemarks").equals("")) {
		aviFlyingClothingInspection.setAntiGSuitRemarks(request.getParameter("antiGSuitRemarks"));
	}
	
	if(request.getParameter(OTHERS_STATUS) != null&& !request.getParameter(OTHERS_STATUS).equals("")) {
		aviFlyingClothingInspection.setOtherStatus("y");
	}else{
		aviFlyingClothingInspection.setOtherStatus("n");
	}
	if(request.getParameter(OTHER_DATE) != null&& !request.getParameter(OTHER_DATE).equals("")) {
		aviFlyingClothingInspection.setOtherDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(OTHER_DATE)));
	}
	if(request.getParameter("otherRemarks") != null&& !request.getParameter("otherRemarks").equals("")) {
		aviFlyingClothingInspection.setOtherRemarks(request.getParameter("otherRemarks"));
	}
	if (request.getParameter(MO_NAME) != null && !request.getParameter(MO_NAME).equals("0")) {
		int employeeId = Integer.parseInt(request.getParameter(MO_NAME));
		MasEmployee moName = new MasEmployee();
		moName.setId(employeeId);
		aviFlyingClothingInspection.setInspectedBy(moName);
	}
	if (request.getParameter(SEX_ID) != null && !request.getParameter(SEX_ID).equals("0")) {
		int sexId = Integer.parseInt(request.getParameter(SEX_ID));
		MasAdministrativeSex masGender = new MasAdministrativeSex();
		masGender.setId(sexId);
		aviFlyingClothingInspection.setSex(masGender);
	}
	if (request.getParameter(SR_AGE) != null && !(request.getParameter(SR_AGE).equals(""))){
		if (request.getParameter(SR_AGE_UNIT) != null) {
			String ageUnit = request.getParameter(SR_AGE_UNIT);
			String srage = request.getParameter(SR_AGE).concat(" ").concat(ageUnit);
			aviFlyingClothingInspection.setAge(srage);
		}
	}
	Date lastChgDate = null;
	if (request.getParameter(CHANGED_DATE) != null) {
		lastChgDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
		aviFlyingClothingInspection.setLastChgDate(lastChgDate);
	}

	String lastChgTime = "";
	if (request.getParameter(CHANGED_TIME) != null) {
		lastChgTime = request.getParameter(CHANGED_TIME);
		aviFlyingClothingInspection.setLastChgTime(time);
	}

	aviFlyingClothingInspection.setStatus("y");
	
	infoMap.put("aviFlyingClothingInspection",aviFlyingClothingInspection);
	Boolean saved = false;
	
	map = aviationMedicineHandlerService.submitFlyingClothingInspectionJsp(infoMap);
	if(map.get("saved") !=null){
		saved=(Boolean)map.get("saved");
	}
	if(saved){
		message="Flying Clothing Inspection Information Saved Successfully !!";
	}
	else{
		message="Try Again !!";
	}
	String url="";
	url="/hms/hms/aviationMedicine?method=showFlyingClothingInspectionJsp";
	jsp = AV_MESSAGE + ".jsp";
	map.put("url", url);
	map.put("contentJsp", jsp);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
	}
//----------By Mansi-(22/march/2012)----	
public ModelAndView updateFlyingClothingInspectionJsp(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String time = (String)utilMap.get("currentTimeWithoutSc");
	AviFlyingClothingInspection aviFlyingClothingInspection = new AviFlyingClothingInspection();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	String message = "";
	String jsp = "";
	/*
	Users user = (Users) session.getAttribute("users");
	patient.setAddEditBy(user);
	objectMap.put("user", user);*/
	
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	MasHospital masHospital = new MasHospital();
	masHospital.setId(hospitalId);
	
	
	aviFlyingClothingInspection.setHospital(masHospital);
	generalMap.put("hospitalId", hospitalId);
	
	int aviFlyingClothingInspectionId=0;
	int departmentId = (Integer) session.getAttribute("deptId");
	
	MasDepartment masDepartment = new MasDepartment();
	masDepartment.setId(departmentId);
	aviFlyingClothingInspection.setDepartment(masDepartment);
	generalMap.put("departmentId", departmentId);
	if(request.getParameter(SERVICE_NO) != null){
		aviFlyingClothingInspection.setServiceNo(request.getParameter(SERVICE_NO));
		String serviceNo=request.getParameter(SERVICE_NO);
		generalMap.put("serviceNo", serviceNo);
	}
	
	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
	//	aviFlyingClothingInspection.setId(Integer.parseInt( request.getParameter(COMMON_ID)));
		aviFlyingClothingInspectionId=Integer.parseInt( request.getParameter(COMMON_ID));
		generalMap.put("aviFlyingClothingInspectionId", aviFlyingClothingInspectionId);
	}
	
	if (request.getParameter(RANK_ID) != null && !request.getParameter(RANK_ID).equals("0")) {
		int rankId = Integer.parseInt(request.getParameter(RANK_ID));
		MasRank masRank = new MasRank();
		masRank.setId(rankId);
		aviFlyingClothingInspection.setRank(masRank);
		generalMap.put("rankId", rankId);
	}
	if (request.getParameter(UNIT_ID) != null && !request.getParameter(UNIT_ID).equals("0")) {
		int unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		MasUnit masUnit = new MasUnit();
		masUnit.setId(unitId);
		aviFlyingClothingInspection.setUnit(masUnit);

		generalMap.put("unitId", unitId);
	}
	if (request.getParameter(TRADE_ID) != null && !request.getParameter(TRADE_ID).equals("0")) {
		int tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
		MasTrade masTrade = new MasTrade();
		masTrade.setId(tradeId);
		aviFlyingClothingInspection.setTrade(masTrade);
		generalMap.put("tradeId", tradeId);
	}
	
	if(request.getParameter(P_FIRST_NAME) != null){
		aviFlyingClothingInspection.setFirstName(request.getParameter(P_FIRST_NAME));
		String fName =request.getParameter(P_FIRST_NAME);
		generalMap.put("fName", fName);
	}
	if (request.getParameter(P_MIDDLE_NAME) != null) {
		aviFlyingClothingInspection.setMiddleName(request.getParameter(P_MIDDLE_NAME));
		String mName =request.getParameter(P_MIDDLE_NAME);
		generalMap.put("mName", mName);
	}
	
	if (request.getParameter(P_LAST_NAME) != null) {
		aviFlyingClothingInspection.setLastName(request.getParameter(P_LAST_NAME));
		String lName =request.getParameter(P_LAST_NAME);
		generalMap.put("lName", lName);
	}
	if(request.getParameter(MASK_STATUS) != null){
		aviFlyingClothingInspection.setMaskStatus(request.getParameter(MASK_STATUS));
		String maskStatus =request.getParameter(MASK_STATUS);
		generalMap.put("maskStatus", maskStatus);
	}
	
	if(request.getParameter("maskRemarks") != null){
		aviFlyingClothingInspection.setMaskRemarks(request.getParameter("maskRemarks"));
		String maskRemarks =request.getParameter("maskRemarks");
		generalMap.put("maskRemarks", maskRemarks);
	}
	if(request.getParameter(HELMET_STATUS) != null){
		aviFlyingClothingInspection.setHelmetStatus(request.getParameter(HELMET_STATUS));
		String helmetStatus =request.getParameter(HELMET_STATUS);
		generalMap.put("helmetStatus", helmetStatus);
	}
	if(request.getParameter("helmetRemarks") != null){
		aviFlyingClothingInspection.setHelmetRemarks(request.getParameter("helmetRemarks"));
		String helmetRemarks =request.getParameter("helmetRemarks");
		generalMap.put("helmetRemarks", helmetRemarks);
	}
	
	if(request.getParameter(ANTI_G_SUIT_STATUS) != null){
		aviFlyingClothingInspection.setAntiGSuitStatus(request.getParameter(ANTI_G_SUIT_STATUS));
		String antiGSuitStatus =request.getParameter(ANTI_G_SUIT_STATUS);
		generalMap.put("antiGSuitStatus", antiGSuitStatus);
	}
	if(request.getParameter("antiGSuitRemarks") != null){
		aviFlyingClothingInspection.setAntiGSuitRemarks(request.getParameter("antiGSuitRemarks"));
		String antiGSuitRemarks =request.getParameter("antiGSuitRemarks");
		generalMap.put("antiGSuitRemarks", antiGSuitRemarks);
	}
	
	if(request.getParameter(OTHERS_STATUS) != null){
		aviFlyingClothingInspection.setOtherStatus(request.getParameter(OTHERS_STATUS));
		String otherStatus =request.getParameter(OTHERS_STATUS);
		generalMap.put("otherStatus", otherStatus);
	}
	if(request.getParameter(REMARKS) != null){
		aviFlyingClothingInspection.setOtherRemarks(request.getParameter(REMARKS));
		String otherRemarks =request.getParameter(REMARKS);
		generalMap.put("otherRemarks", otherRemarks);
	}
	Date flyingDate = null;
	if (request.getParameter(DATE) != null) {
		flyingDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(DATE));
		aviFlyingClothingInspection.setFlyingDate(flyingDate);
	
		generalMap.put("flyingDate", flyingDate);
	}
	
	Date lastChgDate = null;
	if (request.getParameter(CHANGED_DATE) != null) {
		lastChgDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
		aviFlyingClothingInspection.setLastChgDate(lastChgDate);
		generalMap.put("lastChgDate", lastChgDate);
	}

	String lastChgTime = "";
	if (request.getParameter(CHANGED_TIME) != null) {
		lastChgTime = request.getParameter(CHANGED_TIME);
		//aviFlyingClothingInspection.setLastChgTime(lastChgTime);
		aviFlyingClothingInspection.setLastChgTime(time);
		generalMap.put("lastChgTime", lastChgTime);
	}

	aviFlyingClothingInspection.setStatus("y");
	Boolean successfullyAdded = false;
	successfullyAdded = aviationMedicineHandlerService.updateFlyingClothingInspectionJsp(aviFlyingClothingInspection,generalMap);
	
	if(successfullyAdded){
		message="Flying Clothing Inspection Information Updated Successfully !!";
	}
	else{
		message="Try Again !!";
	}
	
	jsp = "av_messageForFlying";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
	}

//----------By Mansi-(22/march/2012)----	
public ModelAndView getServiceNoDetailsForReg(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box  = HMSUtil.getBox(request);
	HttpSession session = request.getSession();
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	box.put("hospitalId", hospitalId);
	map = aviationMedicineHandlerService.getServiceNoDetailsForReg(box);
	
	return new ModelAndView("av_responseForSrNoFlying","map",map);
}

//----------By Mansi-(22/march/2012)----	
public ModelAndView submitCasualtyAirEvacuationJsp(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String time = (String)utilMap.get("currentTimeWithoutSc");
	AviCasualtyAirEvacuation aviCasualtyAirEvacuation = new AviCasualtyAirEvacuation();
	String message = "";
	String jsp = "";
	
/*	Users user = (Users) session.getAttribute("users");
	patient.setAddEditBy(user);
	objectMap.put("user", user);*/
	int avAccidentId=0;
	if(request.getParameter("avAccidentId") !=null && !request.getParameter("avAccidentId").equals("")){
		avAccidentId=Integer.parseInt(request.getParameter("avAccidentId"));
		infoMap.put("avAccidentId", avAccidentId);
		aviCasualtyAirEvacuation = aviationMedicineHandlerService.loadCasualAirEvac(avAccidentId);
	}
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	MasHospital masHospital = new MasHospital();
	masHospital.setId(hospitalId);
	aviCasualtyAirEvacuation.setHospital(masHospital);
	
	int departmentId = (Integer) session.getAttribute("deptId");
	MasDepartment masDepartment = new MasDepartment();
	masDepartment.setId(departmentId);
	aviCasualtyAirEvacuation.setDepartment(masDepartment);
	
	if(request.getParameter(SERVICE_NO) != null && !request.getParameter(SERVICE_NO).equals("0")) {
		aviCasualtyAirEvacuation.setServiceNo(request.getParameter(SERVICE_NO));
	}
	Date casualtyAirEvacuationDate = null;
	if (request.getParameter(DATE) != null && !request.getParameter(DATE).equals("")) {
		casualtyAirEvacuationDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE));
		aviCasualtyAirEvacuation.setCasualtyAirEvacuationDate(casualtyAirEvacuationDate);		
	}
	
	if (request.getParameter(TIME) != null && !request.getParameter(TIME).equals("")) {
		//aviCasualtyAirEvacuation.setCasualtyAirEvacuationTime((request.getParameter(TIME)));
		aviCasualtyAirEvacuation.setCasualtyAirEvacuationTime(time);
	}
	if (request.getParameter(RANK_ID) != null && !request.getParameter(RANK_ID).equals("0")) {
		int rankId = Integer.parseInt(request.getParameter(RANK_ID));
		MasRank masRank = new MasRank();
		masRank.setId(rankId);
		aviCasualtyAirEvacuation.setRank(masRank);
	}
	if (request.getParameter(UNIT_ID) != null && !request.getParameter(UNIT_ID).equals("0")) {
		int unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		MasUnit masUnit = new MasUnit();
		masUnit.setId(unitId);
		aviCasualtyAirEvacuation.setUnit(masUnit);
	}
	if (request.getParameter(TRADE_ID) != null && !request.getParameter(TRADE_ID).equals("0")) {
		int tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
		MasTrade masTrade = new MasTrade();
		masTrade.setId(tradeId);
		aviCasualtyAirEvacuation.setTrade(masTrade);
	}
	
	if(request.getParameter(P_FIRST_NAME) != null && !request.getParameter(P_FIRST_NAME).equals("")) {
		aviCasualtyAirEvacuation.setFirstName(request.getParameter(P_FIRST_NAME));
	}
	if (request.getParameter(P_MIDDLE_NAME) != null && !request.getParameter(P_MIDDLE_NAME).equals("")) {
		aviCasualtyAirEvacuation.setMiddleName(request.getParameter(P_MIDDLE_NAME));
	}
	
	if (request.getParameter(P_LAST_NAME) != null && !request.getParameter(P_LAST_NAME).equals("")) {
		aviCasualtyAirEvacuation.setLastName(request.getParameter(P_LAST_NAME));
	}
	if(request.getParameter(TOTAL_SERVICE) != null && !request.getParameter(TOTAL_SERVICE).equals("")){
		aviCasualtyAirEvacuation.setTotalService(Integer.parseInt(request.getParameter(TOTAL_SERVICE)));
		
	}
	if (request.getParameter(SR_AGE) != null && !request.getParameter(SR_AGE).equals("")) {
		if (request.getParameter(SR_AGE_UNIT) != null) {
			String ageUnit = request.getParameter(SR_AGE_UNIT);
			String srage = request.getParameter(SR_AGE).concat(" ").concat(ageUnit);
			aviCasualtyAirEvacuation.setAge(srage);
		}
	}
	if (request.getParameter(SR_SEX) != null && !request.getParameter(SR_SEX).equals("0")) {

		int genderId = Integer.parseInt(request.getParameter(SR_SEX));
		MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
		masAdministrativeSex.setId(genderId);
		aviCasualtyAirEvacuation.setGender(masAdministrativeSex);
	}
	Date dateCasualtyArrival = null;
	if (request.getParameter(DATE_CASUALTY_ARRIVAL) != null && !request.getParameter(DATE_CASUALTY_ARRIVAL).equals("")) {
		dateCasualtyArrival = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(DATE_CASUALTY_ARRIVAL));
		aviCasualtyAirEvacuation.setDateCasualtyArrival(dateCasualtyArrival);
	}
	
	if (request.getParameter(TIME_CASUALTY_ARRIVAL) != null && !request.getParameter(TIME_CASUALTY_ARRIVAL).equals("")) {
		aviCasualtyAirEvacuation.setTimeCasualtyArrival((request.getParameter(TIME_CASUALTY_ARRIVAL)));
	}
	if (request.getParameter(CLINICAL) != null && !request.getParameter(CLINICAL).equals("")) {
		aviCasualtyAirEvacuation.setClinical((request.getParameter(CLINICAL)));
	}
	if (request.getParameter(DIAGNOSIS) != null && !request.getParameter(DIAGNOSIS).equals("")) {
		aviCasualtyAirEvacuation.setDiagnosis((request.getParameter(DIAGNOSIS)));
	}
	if (request.getParameter(CONDITION) != null && !request.getParameter(CONDITION).equals("")) {
		aviCasualtyAirEvacuation.setCondition((request.getParameter(CONDITION)));
	}
		if (request.getParameter(CONDITION_STATUS) != null && !request.getParameter(CONDITION_STATUS).equals("")) {
		aviCasualtyAirEvacuation.setConditionStatus((request.getParameter(CONDITION_STATUS)));
	}
	Date dateCondition = null;
	if (request.getParameter(LIST_DATE) != null && !request.getParameter(LIST_DATE).equals("")) {
		dateCondition = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(LIST_DATE));
		aviCasualtyAirEvacuation.setDateCondition(dateCondition);
	}
	
	if (request.getParameter(LIST_TIME) != null && !request.getParameter(LIST_TIME).equals("")) {
		aviCasualtyAirEvacuation.setTimeCondition((request.getParameter(LIST_TIME)));
	}
	
	if (request.getParameter(CASUALTY) != null && !request.getParameter(CASUALTY).equals("")) {
		aviCasualtyAirEvacuation.setCasualty((request.getParameter(CASUALTY)));
	}
	
	Date dateCasualty = null;
	if (request.getParameter(DATE_CASUALTY) != null && !request.getParameter(DATE_CASUALTY).equals("")) {
		dateCasualty = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(DATE_CASUALTY));
		aviCasualtyAirEvacuation.setDateCasualty(dateCasualty);
	}
	
	if (request.getParameter(TIME_CASUALTY) != null && !request.getParameter(TIME_CASUALTY).equals("")) {
		aviCasualtyAirEvacuation.setTimeCasualty((request.getParameter(TIME_CASUALTY)));
	}
	if (request.getParameter(DIFFCULTIES) != null && !request.getParameter(DIFFCULTIES).equals("")) {
		aviCasualtyAirEvacuation.setDiffculties((request.getParameter(DIFFCULTIES)));
	}
	if (request.getParameter(DISPOSAL) != null && !request.getParameter(DISPOSAL).equals("")) {
		aviCasualtyAirEvacuation.setDisposal((request.getParameter(DISPOSAL)));
	}
	if(request.getParameter(REMARKS) != null && !request.getParameter(REMARKS).equals("")) {
		aviCasualtyAirEvacuation.setRemarks(request.getParameter(REMARKS));
	
	}
	if (request.getParameter(AIRCRAFT_TYPE_ID) != null && !request.getParameter(AIRCRAFT_TYPE_ID).equals("0")) {
		int aircraftTypeId = Integer.parseInt(request.getParameter(AIRCRAFT_TYPE_ID));
		MasAircraftType masAircraftType = new MasAircraftType();
		masAircraftType.setId(aircraftTypeId);
		aviCasualtyAirEvacuation.setAircraftType(masAircraftType);
	}
	if(request.getParameter(RADIO_FOR_TABLE) != null && !request.getParameter(RADIO_FOR_TABLE).equals("")) {
		aviCasualtyAirEvacuation.setRadioForTable(request.getParameter(RADIO_FOR_TABLE));
	
	}
	if(request.getParameter(TOTAL_DURATION) != null && !request.getParameter(TOTAL_DURATION).equals("")) {
		aviCasualtyAirEvacuation.setTotalDuration(Integer.parseInt(request.getParameter(TOTAL_DURATION)));
		
	}
	if(request.getParameter(DURATION_HOLDING) != null && !request.getParameter(DURATION_HOLDING).equals("")) {
		aviCasualtyAirEvacuation.setDurationHolding(Integer.parseInt(request.getParameter(DURATION_HOLDING)));
	}
	
	if (request.getParameter(ENROUTE_HOLDING_UNIT) != null && !request.getParameter(ENROUTE_HOLDING_UNIT).equals("0")) {
		int enrouteHoldingUnitId = Integer.parseInt(request.getParameter(ENROUTE_HOLDING_UNIT));
		MasUnit enrouteHoldingUnit = new MasUnit();
		enrouteHoldingUnit.setId(enrouteHoldingUnitId);
		aviCasualtyAirEvacuation.setEnrouteHoldingUnit(enrouteHoldingUnit);
	}
	/*if(request.getParameter(HIN_NO) != null && !request.getParameter(HIN_NO).equals("")) {
		aviCasualtyAirEvacuation.setHinNo(request.getParameter(HIN_NO));
	}
	if (request.getParameter(SERVICE_STATUS_ID) != null && !request.getParameter(SERVICE_STATUS_ID).equals("0")) {
		int serviceStatusId = Integer.parseInt(request.getParameter(SERVICE_STATUS_ID));
		MasServiceStatus serviceStatus = new MasServiceStatus();
		serviceStatus.setId(serviceStatusId);
		aviCasualtyAirEvacuation.setServiceStatus(serviceStatus);
	}
	if (request.getParameter(SERVICE_TYPE_ID) != null && !request.getParameter(SERVICE_TYPE_ID).equals("0")) {
		int serviceTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
		MasServiceType serviceType = new MasServiceType();
		serviceType.setId(serviceTypeId);
		aviCasualtyAirEvacuation.setServiceType(serviceType);
	}
	if (request.getParameter(SECTION_ID) != null && !request.getParameter(SECTION_ID).equals("0")) {
		int sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
		MasSection masSection = new MasSection();
		masSection.setId(sectionId);
		aviCasualtyAirEvacuation.setSection(masSection);
	}
	if (request.getParameter(STATION) != null && !request.getParameter(STATION).equals("0")) {
		int stationId = Integer.parseInt(request.getParameter(STATION));
		MasStation masStation = new MasStation();
		masStation.setId(stationId);
		aviCasualtyAirEvacuation.setStation(masStation);
	}
	if (request.getParameter(COMMAND) != null && !request.getParameter(COMMAND).equals("0")) {
		int commandId = Integer.parseInt(request.getParameter(COMMAND));
		MasCommand masCommand = new MasCommand();
		masCommand.setId(commandId);
		aviCasualtyAirEvacuation.setCommand(masCommand);
	}
	if (request.getParameter(RECORD_OFFICE_ADDRESS_ID) != null && !request.getParameter(RECORD_OFFICE_ADDRESS_ID).equals("0")) {
		int recordOfficeId = Integer.parseInt(request.getParameter(RECORD_OFFICE_ADDRESS_ID));
		MasRecordOfficeAddress officeAddress = new MasRecordOfficeAddress();
		officeAddress.setId(recordOfficeId);
		aviCasualtyAirEvacuation.setRecordOffice(officeAddress);
	}*/
	Date lastChgDate = null;
	if (request.getParameter(CHANGED_DATE) != null && !request.getParameter(CHANGED_DATE).equals("")) {
		lastChgDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
		aviCasualtyAirEvacuation.setLastChgDate(lastChgDate);
	}

	String lastChgTime = "";
	if (request.getParameter(CHANGED_TIME) != null && !request.getParameter(CHANGED_TIME).equals("")) {
		lastChgTime = request.getParameter(CHANGED_TIME);
		aviCasualtyAirEvacuation.setLastChgTime(time);
	}
	String flag="";
	if(request.getParameter("flag") !=null && !request.getParameter("flag").equals("")){
		flag=request.getParameter("flag");
	}
	aviCasualtyAirEvacuation.setStatus("y");
	infoMap.put("aviCasualtyAirEvacuation",aviCasualtyAirEvacuation);
	map = aviationMedicineHandlerService.submitCasualtyAirEvacuationJsp(infoMap);
	Boolean saved = false;
	if(map.get("saved") !=null){
		saved=(Boolean)map.get("saved");
	}
	
	if(saved){
		message="Casualty Air Evacuation Information Saved Successfully !!";
	}
	else{
		message="Try Again !!";
	}
	int avAccidentIdd=0;
	if(map.get("avAccidentIdd") !=null){
		avAccidentIdd=(Integer)map.get("avAccidentIdd");
	}
	String url="";
	url = "/hms/hms/aviationMedicine?method=showCasualtyAirEvacuationJsp";
	jsp = AV_MESSAGE + ".jsp";

	map.put("flag", flag);
	map.put("avAccidentId", avAccidentIdd);
	map.put("url", url);
	map.put("message", message);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
	}

public ModelAndView updateCasualtyAirEvacuationJsp(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	AviCasualtyAirEvacuation aviCasualtyAirEvacuation = new AviCasualtyAirEvacuation();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	String message = "";
	String jsp = "";
	/*
	Users user = (Users) session.getAttribute("users");
	patient.setAddEditBy(user);
	objectMap.put("user", user);*/
	
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	MasHospital masHospital = new MasHospital();
	masHospital.setId(hospitalId);
	
	
	aviCasualtyAirEvacuation.setHospital(masHospital);
	generalMap.put("hospitalId", hospitalId);
	
	int aviCasualtyAirEvacuationId=0;
	int departmentId = (Integer) session.getAttribute("deptId");
	
	MasDepartment masDepartment = new MasDepartment();
	masDepartment.setId(departmentId);
	aviCasualtyAirEvacuation.setDepartment(masDepartment);
	generalMap.put("departmentId", departmentId);
	if(request.getParameter(SERVICE_NO) != null){
		aviCasualtyAirEvacuation.setServiceNo(request.getParameter(SERVICE_NO));
		String serviceNo=request.getParameter(SERVICE_NO);
		generalMap.put("serviceNo", serviceNo);
	}
	
	if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
	//	aviFlyingClothingInspection.setId(Integer.parseInt( request.getParameter(COMMON_ID)));
		aviCasualtyAirEvacuationId=Integer.parseInt( request.getParameter(COMMON_ID));
		generalMap.put("aviCasualtyAirEvacuationId", aviCasualtyAirEvacuationId);
	}
	Date casualtyAirEvacuationDate = null;
	if (request.getParameter(DATE) != null) {
		casualtyAirEvacuationDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE));
		aviCasualtyAirEvacuation.setCasualtyAirEvacuationDate(casualtyAirEvacuationDate);
		generalMap.put("casualtyAirEvacuationDate", casualtyAirEvacuationDate);
		
	}
	String casualtyAirEvacuationTime="";
	if (request.getParameter(TIME) != null) {
		aviCasualtyAirEvacuation.setCasualtyAirEvacuationTime((request.getParameter(TIME)));
		casualtyAirEvacuationTime=request.getParameter(TIME);
		generalMap.put("casualtyAirEvacuationTime", casualtyAirEvacuationTime);
	}
	
	if (request.getParameter(RANK_ID) != null && !request.getParameter(RANK_ID).equals("0")) {
		int rankId = Integer.parseInt(request.getParameter(RANK_ID));
		MasRank masRank = new MasRank();
		masRank.setId(rankId);
		aviCasualtyAirEvacuation.setRank(masRank);
		generalMap.put("rankId", rankId);
	}
	if (request.getParameter(UNIT_ID) != null && !request.getParameter(UNIT_ID).equals("0")) {
		int unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		MasUnit masUnit = new MasUnit();
		masUnit.setId(unitId);
		aviCasualtyAirEvacuation.setUnit(masUnit);

		generalMap.put("unitId", unitId);
	}
	if (request.getParameter(TRADE_ID) != null && !request.getParameter(TRADE_ID).equals("0")) {
		int tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
		MasTrade masTrade = new MasTrade();
		masTrade.setId(tradeId);
		aviCasualtyAirEvacuation.setTrade(masTrade);
		generalMap.put("tradeId", tradeId);
	}
	
	if(request.getParameter(P_FIRST_NAME) != null){
		aviCasualtyAirEvacuation.setFirstName(request.getParameter(P_FIRST_NAME));
		String fName =request.getParameter(P_FIRST_NAME);
		generalMap.put("fName", fName);
	}
	if (request.getParameter(P_MIDDLE_NAME) != null) {
		aviCasualtyAirEvacuation.setMiddleName(request.getParameter(P_MIDDLE_NAME));
		String mName =request.getParameter(P_MIDDLE_NAME);
		generalMap.put("mName", mName);
	}
	
	if (request.getParameter(P_LAST_NAME) != null) {
		aviCasualtyAirEvacuation.setLastName(request.getParameter(P_LAST_NAME));
		String lName =request.getParameter(P_LAST_NAME);
		generalMap.put("lName", lName);
	}	
	
	int totalService=0;
	if(request.getParameter(TOTAL_SERVICE) != null){
		aviCasualtyAirEvacuation.setTotalService(Integer.parseInt(request.getParameter(TOTAL_SERVICE)));
		totalService=Integer.parseInt(request.getParameter(TOTAL_SERVICE));
		generalMap.put("totalService", totalService);
	}
	if (request.getParameter(SR_AGE) != null) {
		if (request.getParameter(SR_AGE_UNIT) != null) {
			String ageUnit = request.getParameter(SR_AGE_UNIT);
			String srage = request.getParameter(SR_AGE).concat(" ").concat(ageUnit);
			aviCasualtyAirEvacuation.setAge(srage);
			generalMap.put("srage", srage);
		}
	}
	if (request.getParameter(SR_SEX) != null && !request.getParameter(SR_SEX).equals("0")) {
		int genderId = Integer.parseInt(request.getParameter(SR_SEX));
		MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
		masAdministrativeSex.setId(genderId);
		aviCasualtyAirEvacuation.setGender(masAdministrativeSex);
		
		generalMap.put("genderId", genderId);
	}
	Date dateCasualtyArrival = null;
	if (request.getParameter(DATE_CASUALTY_ARRIVAL) != null && !request.getParameter(DATE_CASUALTY_ARRIVAL).equals("")) {
		dateCasualtyArrival = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(DATE_CASUALTY_ARRIVAL));
		aviCasualtyAirEvacuation.setDateCasualtyArrival(dateCasualtyArrival);
		generalMap.put("dateCasualtyArrival", dateCasualtyArrival);
	}
	String timeCasualtyArrival="";
	if (request.getParameter(TIME_CASUALTY_ARRIVAL) != null && !request.getParameter(TIME_CASUALTY_ARRIVAL).equals("")) {
		aviCasualtyAirEvacuation.setTimeCasualtyArrival((request.getParameter(TIME_CASUALTY_ARRIVAL)));
		timeCasualtyArrival=request.getParameter(TIME_CASUALTY_ARRIVAL);
		generalMap.put("timeCasualtyArrival", timeCasualtyArrival);
	}
	String clinical="";
	if (request.getParameter(CLINICAL) != null && !request.getParameter(CLINICAL).equals("")) {
		aviCasualtyAirEvacuation.setClinical((request.getParameter(CLINICAL)));
		clinical=request.getParameter(CLINICAL);
		generalMap.put("clinical", clinical);
	}
	String diagnosis="";
	if (request.getParameter(DIAGNOSIS) != null && !request.getParameter(DIAGNOSIS).equals("")) {
		aviCasualtyAirEvacuation.setDiagnosis((request.getParameter(DIAGNOSIS)));
		diagnosis=request.getParameter(DIAGNOSIS);
		generalMap.put("diagnosis", diagnosis);
	}
	String condition="";
	if (request.getParameter(CONDITION) != null && !request.getParameter(CONDITION).equals("")) {
		aviCasualtyAirEvacuation.setCondition((request.getParameter(CONDITION)));
		condition=request.getParameter(CONDITION);
		generalMap.put("condition", condition);
	}
	String conditionStatus="";
		if (request.getParameter(CONDITION_STATUS) != null && !request.getParameter(CONDITION_STATUS).equals("")) {
		aviCasualtyAirEvacuation.setConditionStatus((request.getParameter(CONDITION_STATUS)));
		conditionStatus=request.getParameter(CONDITION_STATUS);
		generalMap.put("conditionStatus", conditionStatus);
	}
	Date dateCondition = null;
	if (request.getParameter(LIST_DATE) != null && !request.getParameter(LIST_DATE).equals("")) {
		dateCondition = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(LIST_DATE));
		aviCasualtyAirEvacuation.setDateCondition(dateCondition);
		generalMap.put("dateCondition", dateCondition);
	}
	String timeCondition="";
	if (request.getParameter(LIST_TIME) != null && !request.getParameter(LIST_DATE).equals("")) {
		aviCasualtyAirEvacuation.setTimeCondition((request.getParameter(LIST_TIME)));
		timeCondition=request.getParameter(LIST_TIME);
		generalMap.put("timeCondition", timeCondition);
	}
	String casualty="";
	if (request.getParameter(CASUALTY) != null && !request.getParameter(CASUALTY).equals("")) {
		aviCasualtyAirEvacuation.setCasualty((request.getParameter(CASUALTY)));
		casualty=request.getParameter(CASUALTY);
		generalMap.put("casualty", casualty);
	}
	
	Date dateCasualty = null;
	if (request.getParameter(DATE_CASUALTY) != null && !request.getParameter(DATE_CASUALTY).equals("")) {
		dateCasualty = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(DATE_CASUALTY));
		aviCasualtyAirEvacuation.setDateCasualty(dateCasualty);
		generalMap.put("dateCasualty", dateCasualty);
	}
	String timeCasualty="";
	if (request.getParameter(TIME_CASUALTY) != null && !request.getParameter(TIME_CASUALTY).equals("")) {
		aviCasualtyAirEvacuation.setTimeCasualty((request.getParameter(TIME_CASUALTY)));
		timeCasualty=request.getParameter(TIME_CASUALTY);
		generalMap.put("timeCasualty", timeCasualty);
	}
	String diffculties="";
	if (request.getParameter(DIFFCULTIES) != null && !request.getParameter(DIFFCULTIES).equals("")) {
		aviCasualtyAirEvacuation.setDiffculties((request.getParameter(DIFFCULTIES)));
		diffculties=request.getParameter(DIFFCULTIES);
		generalMap.put("diffculties", diffculties);
	}
	String disposal="";
	if (request.getParameter(DISPOSAL) != null && !request.getParameter(DISPOSAL).equals("")) {
		aviCasualtyAirEvacuation.setDisposal((request.getParameter(DISPOSAL)));
		disposal=request.getParameter(DISPOSAL);
		generalMap.put("disposal", disposal);
	}
	String remarks="";
	if(request.getParameter(REMARKS) != null && !request.getParameter(REMARKS).equals("")) {
		aviCasualtyAirEvacuation.setRemarks(request.getParameter(REMARKS));
		remarks=request.getParameter(REMARKS);
		generalMap.put("remarks", remarks);
	
	}
	if (request.getParameter(AIRCRAFT_TYPE_ID) != null && !request.getParameter(AIRCRAFT_TYPE_ID).equals("0")) {
		int aircraftTypeId = Integer.parseInt(request.getParameter(AIRCRAFT_TYPE_ID));
		MasAircraftType masAircraftType = new MasAircraftType();
		masAircraftType.setId(aircraftTypeId);
		aviCasualtyAirEvacuation.setAircraftType(masAircraftType);
		generalMap.put("aircraftTypeId", aircraftTypeId);
	}
	String radioForTable="";
	if(request.getParameter(RADIO_FOR_TABLE) != null && !request.getParameter(RADIO_FOR_TABLE).equals("")) {
		aviCasualtyAirEvacuation.setRadioForTable(request.getParameter(RADIO_FOR_TABLE));
		radioForTable=request.getParameter(RADIO_FOR_TABLE);
		generalMap.put("radioForTable", radioForTable);
	
	}
	int totalDuration=0;
	if(request.getParameter(TOTAL_DURATION) != null && !request.getParameter(TOTAL_DURATION).equals("")) {
		aviCasualtyAirEvacuation.setTotalDuration(Integer.parseInt(request.getParameter(TOTAL_DURATION)));
		totalDuration = Integer.parseInt(request.getParameter(TOTAL_DURATION));
		generalMap.put("totalDuration", totalDuration);
		
	}
	int durationHolding=0;
	if(request.getParameter(DURATION_HOLDING) != null && !request.getParameter(DURATION_HOLDING).equals("")) {
		aviCasualtyAirEvacuation.setDurationHolding(Integer.parseInt(request.getParameter(DURATION_HOLDING)));
		durationHolding = Integer.parseInt(request.getParameter(DURATION_HOLDING));
		generalMap.put("durationHolding", durationHolding);
		
	}
	
	if (request.getParameter(ENROUTE_HOLDING_UNIT) != null && !request.getParameter(ENROUTE_HOLDING_UNIT).equals("0")) {
		int enrouteHoldingUnitId = Integer.parseInt(request.getParameter(ENROUTE_HOLDING_UNIT));
		MasUnit enrouteHoldingUnit = new MasUnit();
		enrouteHoldingUnit.setId(enrouteHoldingUnitId);
		aviCasualtyAirEvacuation.setEnrouteHoldingUnit(enrouteHoldingUnit);
		generalMap.put("enrouteHoldingUnitId", enrouteHoldingUnitId);
	}
	
	Date lastChgDate = null;
	if (request.getParameter(CHANGED_DATE) != null&& !request.getParameter(CHANGED_DATE).equals("0")) {
		lastChgDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(CHANGED_DATE));
		aviCasualtyAirEvacuation.setLastChgDate(lastChgDate);
	
		generalMap.put("lastChgDate", lastChgDate);
	}

	String lastChgTime = "";
	if (request.getParameter(CHANGED_TIME) != null&& !request.getParameter(CHANGED_TIME).equals("0")) {
		lastChgTime = request.getParameter(CHANGED_TIME);
		aviCasualtyAirEvacuation.setLastChgTime(lastChgTime);
		generalMap.put("lastChgTime", lastChgTime);
	}

	aviCasualtyAirEvacuation.setStatus("y");
	Boolean successfullyAdded = false;	
	successfullyAdded = aviationMedicineHandlerService.updateCasualtyAirEvacuationJsp(aviCasualtyAirEvacuation,generalMap);
	
	if(successfullyAdded){
		message="Casualty Air Evacuation Information Updated Successfully !!";
	}
	else{
		message="Try Again !!";
	}
	
	jsp = "av_messageForCasualty";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
	}
//----------By Mansi-(22/march/2012)----	
public ModelAndView getServiceNoDetailsForRegCasualty(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box  = HMSUtil.getBox(request);
	map = aviationMedicineHandlerService.getServiceNoDetailsForRegCasualty(box);
	
	return new ModelAndView("av_responseForSrNoCasualty","map",map);
}


public ModelAndView submitAviationMA(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	AvMedicalExamMaMo avMedicalExamMaMo=new AvMedicalExamMaMo();
	HttpSession session = request.getSession();
	int deptId = (Integer) session.getAttribute("deptId");
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	int userId = 0;
	Users user = (Users)session.getAttribute("users");
	userId = user.getId();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	//---For PHYSICAL AND MENTAL DETAILS Tab-----
	try {
		avMedicalExamMaMo.setAvStatus("p");
		avMedicalExamMaMo.setMaDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		if(request.getParameter(HEIGHT) !=null && !request.getParameter(HEIGHT).equals("")){
			avMedicalExamMaMo.setHeight(new BigDecimal(request.getParameter(HEIGHT)));
		}
		if(request.getParameter(WEIGHT) !=null && !request.getParameter(WEIGHT).equals("")){
			avMedicalExamMaMo.setWeight(new BigDecimal(request.getParameter(WEIGHT)));
		}
		if(request.getParameter(BMI) !=null && !request.getParameter(BMI).equals("")){
			avMedicalExamMaMo.setBmi(new BigDecimal(request.getParameter(BMI)));
		}
		if(request.getParameter(CHEST) !=null && !request.getParameter(CHEST).equals("")){
			avMedicalExamMaMo.setChestCircumference(new BigDecimal(request.getParameter(CHEST)));
		}
		if(request.getParameter(EXPIRATION) !=null && !request.getParameter(EXPIRATION).equals("")){
			avMedicalExamMaMo.setExpiration(new BigDecimal(request.getParameter(EXPIRATION)));
		}
		if(request.getParameter(PULSE) !=null && !request.getParameter(PULSE).equals("")){
			avMedicalExamMaMo.setPulseSeated(request.getParameter(PULSE));
		}
		if(request.getParameter(PULSE_EXERCISE) !=null && !request.getParameter(PULSE_EXERCISE).equals("")){
			avMedicalExamMaMo.setPulseExercise(request.getParameter(PULSE_EXERCISE));
		}
		if(request.getParameter(PULSE_NORMAL) !=null && !request.getParameter(PULSE_NORMAL).equals("")){
			avMedicalExamMaMo.setMinPulseNormal(request.getParameter(PULSE_NORMAL));
		}
		if(request.getParameter(BP) !=null && !request.getParameter(BP).equals("")){
			avMedicalExamMaMo.setBp(request.getParameter(BP));
		}
		if(request.getParameter(ELECTROCARDIOGRAM) !=null && !request.getParameter(ELECTROCARDIOGRAM).equals("")){
			avMedicalExamMaMo.setElectrocardiogram(request.getParameter(ELECTROCARDIOGRAM));
		}
		if(request.getParameter(SKIN) !=null && !request.getParameter(SKIN).equals("")){
			avMedicalExamMaMo.setSystemicSkin(request.getParameter(SKIN));
		}
		if(request.getParameter(REMARKS_SKIN) !=null && !request.getParameter(REMARKS_SKIN).equals("")){
			avMedicalExamMaMo.setRemarksSkin(request.getParameter(REMARKS_SKIN));
		}
		if(request.getParameter(LYMPHNODES_YMPHATICS) !=null && !request.getParameter(LYMPHNODES_YMPHATICS).equals("")){
			avMedicalExamMaMo.setSystemLymphnodeLymphatic(request.getParameter(LYMPHNODES_YMPHATICS));
		}
		if(request.getParameter(REMARKS_LYMPHNODES_LYMPHATICS) !=null && !request.getParameter(REMARKS_LYMPHNODES_LYMPHATICS).equals("")){
			avMedicalExamMaMo.setRemarksLymphnodeLymphatic(request.getParameter(REMARKS_LYMPHNODES_LYMPHATICS));
		}
		if(request.getParameter(HEAD_FACE_NECK_SCALP) !=null && !request.getParameter(HEAD_FACE_NECK_SCALP).equals("")){
			avMedicalExamMaMo.setSystemHeadFaceNeck(request.getParameter(HEAD_FACE_NECK_SCALP));
		}
		if(request.getParameter(REMARKS_HEAD_FACE_NECK_SCALP) !=null && !request.getParameter(REMARKS_HEAD_FACE_NECK_SCALP).equals("")){
			avMedicalExamMaMo.setRemarksHeadFaceNeck(request.getParameter(REMARKS_HEAD_FACE_NECK_SCALP));
		}
		if(request.getParameter(UPPER_LOWER_EXTRMITIES) !=null && !request.getParameter(UPPER_LOWER_EXTRMITIES).equals("")){
			avMedicalExamMaMo.setSystemUperLowerExtremitie(request.getParameter(UPPER_LOWER_EXTRMITIES));
		}
		if(request.getParameter(REMARKS_UPPER_LOWER_EXTRMITIES) !=null && !request.getParameter(REMARKS_UPPER_LOWER_EXTRMITIES).equals("")){
			avMedicalExamMaMo.setRemarksUperLowerExtremitie(request.getParameter(REMARKS_UPPER_LOWER_EXTRMITIES));
		}
		if(request.getParameter(SPINE_MUSCULO_SKELETAL) !=null && !request.getParameter(SPINE_MUSCULO_SKELETAL).equals("")){
			avMedicalExamMaMo.setSystemSpineMusculo(request.getParameter(SPINE_MUSCULO_SKELETAL));
		}
		if(request.getParameter(REMARKS_SPINE_MUSCULO_SKELETAL) !=null && !request.getParameter(REMARKS_SPINE_MUSCULO_SKELETAL).equals("")){
			avMedicalExamMaMo.setRemarksSpineMusculo(request.getParameter(REMARKS_SPINE_MUSCULO_SKELETAL));
		}
		if(request.getParameter(CHEST_AND_LUNGS) !=null && !request.getParameter(CHEST_AND_LUNGS).equals("")){
			avMedicalExamMaMo.setSystemChestLungs(request.getParameter(CHEST_AND_LUNGS));
		}
		if(request.getParameter(REMARKS_CHEST_AND_LUNGS) !=null && !request.getParameter(REMARKS_CHEST_AND_LUNGS).equals("")){
			avMedicalExamMaMo.setRemarksChestLungs(request.getParameter(REMARKS_CHEST_AND_LUNGS));
		}
		if(request.getParameter(HEART) !=null && !request.getParameter(HEART).equals("")){
			avMedicalExamMaMo.setSystemHeart(request.getParameter(HEART));
		}
		if(request.getParameter(REMARKS_HEART) !=null && !request.getParameter(REMARKS_HEART).equals("")){
			avMedicalExamMaMo.setRemarksHeart(request.getParameter(REMARKS_HEART));
		}
		if(request.getParameter(VASCULAR_SYSTEM) !=null && !request.getParameter(VASCULAR_SYSTEM).equals("")){
			avMedicalExamMaMo.setSystemVascular(request.getParameter(VASCULAR_SYSTEM));
		}
		if(request.getParameter(REMARKS_VASCULAR_SYSTEM) !=null && !request.getParameter(REMARKS_VASCULAR_SYSTEM).equals("")){
			avMedicalExamMaMo.setRemarksVascular(request.getParameter(REMARKS_VASCULAR_SYSTEM));
		}
		if(request.getParameter(ABDOMEN_VISCERA) !=null && !request.getParameter(ABDOMEN_VISCERA).equals("")){
			avMedicalExamMaMo.setSystemAbdomenViscera(request.getParameter(ABDOMEN_VISCERA));
		}
		if(request.getParameter(REMARKS_ABDOMEN_VISCERA) !=null && !request.getParameter(REMARKS_ABDOMEN_VISCERA).equals("")){
			avMedicalExamMaMo.setRemarksAbdomenViscera(request.getParameter(REMARKS_ABDOMEN_VISCERA));
		}
		if(request.getParameter(PERINCUM_ANUS) !=null && !request.getParameter(PERINCUM_ANUS).equals("")){
			avMedicalExamMaMo.setSystemPerincumAnus(request.getParameter(PERINCUM_ANUS));
		}
		if(request.getParameter(REMARKS_PERINCUM_ANUS) !=null && !request.getParameter(REMARKS_PERINCUM_ANUS).equals("")){
			avMedicalExamMaMo.setRemarksPerincumAnus(request.getParameter(REMARKS_PERINCUM_ANUS));
		}
		
		if(request.getParameter(GENITOURINARY_SYSTEM) !=null && !request.getParameter(GENITOURINARY_SYSTEM).equals("")){
			avMedicalExamMaMo.setSystemGenitourinary(request.getParameter(GENITOURINARY_SYSTEM));
		}
		if(request.getParameter(REMARKS_GENITOURINARY_SYSTEM) !=null && !request.getParameter(REMARKS_GENITOURINARY_SYSTEM).equals("")){
			avMedicalExamMaMo.setRemarksGenitourinary(request.getParameter(REMARKS_GENITOURINARY_SYSTEM));
		}
		if(request.getParameter(ENDOCRINE_SYSTEM) !=null && !request.getParameter(ENDOCRINE_SYSTEM).equals("")){
			avMedicalExamMaMo.setSystemEndocrine(request.getParameter(ENDOCRINE_SYSTEM));
		}
		if(request.getParameter(REMARKS_ENDOCRINE_SYSTEM) !=null && !request.getParameter(REMARKS_ENDOCRINE_SYSTEM).equals("")){
			avMedicalExamMaMo.setRemarksEndocrine(request.getParameter(REMARKS_ENDOCRINE_SYSTEM));
		}
		if(request.getParameter(NEUROLOGIC) !=null && !request.getParameter(NEUROLOGIC).equals("")){
			avMedicalExamMaMo.setSystemNeurologic(request.getParameter(NEUROLOGIC));
		}
		if(request.getParameter(REMARKS_NEUROLOGIC) !=null && !request.getParameter(REMARKS_NEUROLOGIC).equals("")){
			avMedicalExamMaMo.setRemarksNeurologic(request.getParameter(REMARKS_NEUROLOGIC));
		}
		if(request.getParameter(PSYCHIARTRIC) !=null && !request.getParameter(PSYCHIARTRIC).equals("")){
			avMedicalExamMaMo.setSystemPsychiartric(request.getParameter(PSYCHIARTRIC));
		}
		if(request.getParameter(REMARKS_PSYCHIARTRIC) !=null && !request.getParameter(REMARKS_PSYCHIARTRIC).equals("")){
			avMedicalExamMaMo.setRemarksPsychiartric(request.getParameter(REMARKS_PSYCHIARTRIC));
		}
		if(request.getParameter(REMARKS) !=null && !request.getParameter(REMARKS).equals("")){
		 avMedicalExamMaMo.setPhysicalMentalRemarks(request.getParameter(REMARKS));
			}
		
		
		//---For Eye Tab----
		if(request.getParameter(LIDS) !=null && !request.getParameter(LIDS).equals("")){
			 avMedicalExamMaMo.setEyeLidsLachrymal(request.getParameter(LIDS));
		}
		if(request.getParameter(VISUAL_FIELDS) !=null && !request.getParameter(VISUAL_FIELDS).equals("")){
			 avMedicalExamMaMo.setEyeVisualFields(request.getParameter(VISUAL_FIELDS));
		}
		if(request.getParameter(OCULAR_MOTILITY) !=null && !request.getParameter(OCULAR_MOTILITY).equals("")){
			 avMedicalExamMaMo.setEyeOcularMotility(request.getParameter(OCULAR_MOTILITY));
		}
		if(request.getParameter(VISUAL_ACUITY) !=null && !request.getParameter(VISUAL_ACUITY).equals("")){
			 avMedicalExamMaMo.setEyeVisualAcuity(request.getParameter(VISUAL_ACUITY));
		}
		if(request.getParameter(WITHOUT_GLASSES_RT) !=null && !request.getParameter(WITHOUT_GLASSES_RT).equals("")){
			 avMedicalExamMaMo.setWthoutGlassesRDistant(request.getParameter(WITHOUT_GLASSES_RT));
		}
		if(request.getParameter(WITHOUT_GLASSES_LT) !=null && !request.getParameter(WITHOUT_GLASSES_LT).equals("")){
			 avMedicalExamMaMo.setWthoutGlassesLDistant(request.getParameter(WITHOUT_GLASSES_LT));
		}
		if(request.getParameter(WITHOUT_GLASSES_BOTH) !=null && !request.getParameter(WITHOUT_GLASSES_BOTH).equals("")){
			 avMedicalExamMaMo.setWthoutGlassesBothDistant(request.getParameter(WITHOUT_GLASSES_BOTH));
		}
		if(request.getParameter(WITH_GLASSES_RT) !=null && !request.getParameter(WITH_GLASSES_RT).equals("")){
			 avMedicalExamMaMo.setWithGlassesRDistant(request.getParameter(WITH_GLASSES_RT));
		}
		if(request.getParameter(WITH_GLASSES_BOTH) !=null && !request.getParameter(WITH_GLASSES_BOTH).equals("")){
			 avMedicalExamMaMo.setWithGlassesBothDistant(request.getParameter(WITH_GLASSES_BOTH));
		}
		if(request.getParameter(WITH_GLASSES_LT) !=null && !request.getParameter(WITH_GLASSES_LT).equals("")){
			 avMedicalExamMaMo.setWithGlassesLDistant(request.getParameter(WITH_GLASSES_LT));
		}
		if(request.getParameter(NEAR_VISION) !=null && !request.getParameter(NEAR_VISION).equals("")){
			 avMedicalExamMaMo.setNearVision(new BigDecimal(request.getParameter(NEAR_VISION)));
		}
		if(request.getParameter(ABLE_TO_READ_N5) !=null && !request.getParameter(ABLE_TO_READ_N5).equals("")){
			 avMedicalExamMaMo.setN5Read(request.getParameter(ABLE_TO_READ_N5));
		}
		if(request.getParameter(INTERMEDIATE_VISION) !=null && !request.getParameter(INTERMEDIATE_VISION).equals("")){
			 avMedicalExamMaMo.setIntermediateVision(new BigDecimal(request.getParameter(INTERMEDIATE_VISION)));
		}
		if(request.getParameter(ABLE_TO_READ_N14) !=null && !request.getParameter(ABLE_TO_READ_N14).equals("")){
			 avMedicalExamMaMo.setN14Read(request.getParameter(ABLE_TO_READ_N14));
		}
		if(request.getParameter(WITHOUT_GLASSES) !=null && !request.getParameter(WITHOUT_GLASSES).equals("")){
			 avMedicalExamMaMo.setAcomodationWithoutglass(new BigDecimal(request.getParameter(WITHOUT_GLASSES)));
		}
		if(request.getParameter(WITH_GLASSES) !=null && !request.getParameter(WITH_GLASSES).equals("")){
			 avMedicalExamMaMo.setAcomodationWithglass(new BigDecimal(request.getParameter(WITH_GLASSES)));
		}
		if(request.getParameter(CANDIDATE_POSSES_GLASSES) !=null && !request.getParameter(CANDIDATE_POSSES_GLASSES).equals("")){
			 avMedicalExamMaMo.setCandidatePossesGlasses(request.getParameter(CANDIDATE_POSSES_GLASSES));
		}
		if(request.getParameter(DISTANT_RT_S) !=null && !request.getParameter(DISTANT_RT_S).equals("")){
			 avMedicalExamMaMo.setDistantRightS(new BigDecimal(request.getParameter(DISTANT_RT_S)));
		}
		if(request.getParameter(DISTANT_RT_C) !=null && !request.getParameter(DISTANT_RT_C).equals("")){
			 avMedicalExamMaMo.setDistantRightC(new BigDecimal(request.getParameter(DISTANT_RT_C)));
		}
		if(request.getParameter(DISTANT_RT_A) !=null && !request.getParameter(DISTANT_RT_A).equals("")){
			 avMedicalExamMaMo.setDistantRightA(new BigDecimal(request.getParameter(DISTANT_RT_A)));
		}
		if(request.getParameter(DISTANT_LT_S) !=null && !request.getParameter(DISTANT_LT_S).equals("")){
			 avMedicalExamMaMo.setDistantLeftS(new BigDecimal(request.getParameter(DISTANT_LT_S)));
		}
		if(request.getParameter(DISTANT_LT_C) !=null && !request.getParameter(DISTANT_LT_C).equals("")){
			 avMedicalExamMaMo.setDistantLeftC(new BigDecimal(request.getParameter(DISTANT_LT_C)));
		}
		if(request.getParameter(DISTANT_LT_A) !=null && !request.getParameter(DISTANT_LT_A).equals("")){
			 avMedicalExamMaMo.setDistantLeftA(new BigDecimal(request.getParameter(DISTANT_LT_A)));
		}
		if(request.getParameter(NEAR_RT_S) !=null && !request.getParameter(NEAR_LT_S).equals("")){
			 avMedicalExamMaMo.setNearRightS(new BigDecimal(request.getParameter(NEAR_LT_S)));
		}
		if(request.getParameter(NEAR_RT_C) !=null && !request.getParameter(NEAR_LT_C).equals("")){
			 avMedicalExamMaMo.setNearRightC(new BigDecimal(request.getParameter(NEAR_LT_C)));
		}
		if(request.getParameter(NEAR_RT_A) !=null && !request.getParameter(NEAR_LT_A).equals("")){
			 avMedicalExamMaMo.setNearRightA(new BigDecimal(request.getParameter(NEAR_LT_A)));
		}		
		if(request.getParameter(NEAR_LT_S) !=null && !request.getParameter(NEAR_LT_S).equals("")){
			 avMedicalExamMaMo.setNearLeftS(new BigDecimal(request.getParameter(NEAR_LT_S)));
		}
		if(request.getParameter(NEAR_LT_C) !=null && !request.getParameter(NEAR_LT_C).equals("")){
			 avMedicalExamMaMo.setNearLeftC(new BigDecimal(request.getParameter(NEAR_LT_C)));
		}
		if(request.getParameter(NEAR_LT_A) !=null && !request.getParameter(NEAR_LT_A).equals("")){
			 avMedicalExamMaMo.setNearLeftA(new BigDecimal(request.getParameter(NEAR_LT_A)));
		}		
		if(request.getParameter(POWER_CONVERGENCE_C) !=null && !request.getParameter(POWER_CONVERGENCE_C).equals("")){
			 avMedicalExamMaMo.setPowerConvergenceC(new BigDecimal(request.getParameter(POWER_CONVERGENCE_C)));
		}
		if(request.getParameter(POWER_CONVERGENCE_SC) !=null && !request.getParameter(POWER_CONVERGENCE_SC).equals("")){
			 avMedicalExamMaMo.setPowerConvergenceSc(new BigDecimal(request.getParameter(POWER_CONVERGENCE_SC)));
		}
		if(request.getParameter(RESULT_COVER_TEST_AT6) !=null && !request.getParameter(RESULT_COVER_TEST_AT6).equals("")){
			 avMedicalExamMaMo.setResultCoverTestAt6(new BigDecimal(request.getParameter(RESULT_COVER_TEST_AT6)));
		}
		if(request.getParameter(RESULT_COVER_TEST_AT33) !=null && !request.getParameter(RESULT_COVER_TEST_AT33).equals("")){
			 avMedicalExamMaMo.setResultCoverTestAt33(new BigDecimal(request.getParameter(RESULT_COVER_TEST_AT33)));
		}
		if(request.getParameter(MADDOX_ROD_AT6) !=null && !request.getParameter(MADDOX_ROD_AT6).equals("")){
			 avMedicalExamMaMo.setMaddoxRodAt6(new BigDecimal(request.getParameter(MADDOX_ROD_AT6)));
		}
		if(request.getParameter(MADDOX_ROD_AT33) !=null && !request.getParameter(MADDOX_ROD_AT33).equals("")){
			 avMedicalExamMaMo.setMaddoxRodAt33(new BigDecimal(request.getParameter(MADDOX_ROD_AT33)));
		}
		//---------For Colour Prescription Tab--
		if(request.getParameter(PSEUDOISCHROMATIC) !=null && !request.getParameter(PSEUDOISCHROMATIC).equals("")){
			avMedicalExamMaMo.setEyePseudoischromatic(request.getParameter(PSEUDOISCHROMATIC));
		}
		if(request.getParameter(ABNORMAL_TEST_RESULT) !=null && !request.getParameter(ABNORMAL_TEST_RESULT).equals("")){
			avMedicalExamMaMo.setEyeDistinguishingReadily(request.getParameter(ABNORMAL_TEST_RESULT));
		}
		if(request.getParameter(COLOUR_REMARKS) !=null && !request.getParameter(COLOUR_REMARKS).equals("")){
			avMedicalExamMaMo.setEyeRemarks(request.getParameter(COLOUR_REMARKS));
		}
		//---------For Ent Tab--
		if(request.getParameter(TYMPANUM_EXTERNAL_EARS) !=null && !request.getParameter(TYMPANUM_EXTERNAL_EARS).equals("")){
			avMedicalExamMaMo.setEntExternalTympanum(request.getParameter(TYMPANUM_EXTERNAL_EARS));
		}
		if(request.getParameter(EUSTACHEAN_TUBE_EXTERNAL) !=null && !request.getParameter(EUSTACHEAN_TUBE_EXTERNAL).equals("")){
			avMedicalExamMaMo.setExternalEustacheanTube(request.getParameter(EUSTACHEAN_TUBE_EXTERNAL));
		}
		if(request.getParameter(MASTOID_EXTERNAL_EARS) !=null && !request.getParameter(MASTOID_EXTERNAL_EARS).equals("")){
			avMedicalExamMaMo.setExternalMastoid(request.getParameter(MASTOID_EXTERNAL_EARS));
		}
		if(request.getParameter(TYMPANUM_MIDDLE_EARS) !=null && !request.getParameter(TYMPANUM_MIDDLE_EARS).equals("")){
			avMedicalExamMaMo.setEntMiddleTympanum(request.getParameter(TYMPANUM_MIDDLE_EARS));
		}
		if(request.getParameter(EUSTACHEAN_TUBE_MIDDLE) !=null && !request.getParameter(EUSTACHEAN_TUBE_MIDDLE).equals("")){
			avMedicalExamMaMo.setMiddleEustacheanTube(request.getParameter(EUSTACHEAN_TUBE_MIDDLE));
		}
		
		if(request.getParameter(MASTOID_MIDDLE_EARS) !=null && !request.getParameter(MASTOID_MIDDLE_EARS).equals("")){
			avMedicalExamMaMo.setEntMastoid(request.getParameter(MASTOID_MIDDLE_EARS));
		}
		
		if(request.getParameter(COCHLEAR_FUNCTIONS) !=null && !request.getParameter(COCHLEAR_FUNCTIONS).equals("")){
			avMedicalExamMaMo.setEntCochlear(request.getParameter(COCHLEAR_FUNCTIONS));
		}
		if(request.getParameter(VESTIBULAR_FUNCTIONS) !=null && !request.getParameter(VESTIBULAR_FUNCTIONS).equals("")){
			avMedicalExamMaMo.setEntVestibular(request.getParameter(VESTIBULAR_FUNCTIONS));
		}	
		if(request.getParameter(NOSE_PARANASAL_SINUSES) !=null && !request.getParameter(NOSE_PARANASAL_SINUSES).equals("")){
			avMedicalExamMaMo.setEntNoseParanasal(request.getParameter(NOSE_PARANASAL_SINUSES));
		}
		
		if(request.getParameter(MOUTH_TEETH_THROAT) !=null && !request.getParameter(MOUTH_TEETH_THROAT).equals("")){
			avMedicalExamMaMo.setMouthTeethThroat(request.getParameter(MOUTH_TEETH_THROAT));
		}
		if(request.getParameter(SPEECH) !=null && !request.getParameter(SPEECH).equals("")){
			avMedicalExamMaMo.setSpeech(request.getParameter(SPEECH));
		}
		if(request.getParameter(RT_EAR_RINNE) !=null && !request.getParameter(RT_EAR_RINNE).equals("")){
			avMedicalExamMaMo.setTunningRtRinnie(request.getParameter(RT_EAR_RINNE));
		}
		if(request.getParameter(RT_EAR_WEBER) !=null && !request.getParameter(RT_EAR_WEBER).equals("")){
			avMedicalExamMaMo.setTunningRtWebe(request.getParameter(RT_EAR_WEBER));
		}
		if(request.getParameter(RT_ABC) !=null && !request.getParameter(RT_ABC).equals("")){
			avMedicalExamMaMo.setTunningRtAbc(request.getParameter(RT_ABC));
		}
		if(request.getParameter(LT_EAR_RINNE) !=null && !request.getParameter(LT_EAR_RINNE).equals("")){
			avMedicalExamMaMo.setTunningLtRinnie(request.getParameter(LT_EAR_RINNE));
		}
		if(request.getParameter(LT_EAR_WEBER) !=null && !request.getParameter(LT_EAR_WEBER).equals("")){
			avMedicalExamMaMo.setTunningLtRinnie(request.getParameter(LT_EAR_WEBER));
		}
		if(request.getParameter(LT_ABC) !=null && !request.getParameter(LT_ABC).equals("")){
			avMedicalExamMaMo.setTunningLtAbc(request.getParameter(LT_ABC));
		}
		if(request.getParameter(SCORE_RT_EAR) !=null && !request.getParameter(SCORE_RT_EAR).equals("")){
			avMedicalExamMaMo.setSpeechIntelligiblRt(request.getParameter(SCORE_RT_EAR));
		}
		if(request.getParameter(SCORE_LT_EAR) !=null && !request.getParameter(SCORE_LT_EAR).equals("")){
			avMedicalExamMaMo.setSpeechIntelligiblLt(request.getParameter(SCORE_RT_EAR));
		}
		if(request.getParameter(RESULT_RT_EAR) !=null && !request.getParameter(RESULT_RT_EAR).equals("")){
			avMedicalExamMaMo.setSpeechRtResult(request.getParameter(RESULT_RT_EAR));
		}
		if(request.getParameter(RESULT_LT_EAR) !=null && !request.getParameter(RESULT_LT_EAR).equals("")){
			avMedicalExamMaMo.setSpeechLtResult(request.getParameter(RESULT_LT_EAR));
		}
		if(request.getParameter(REMARKS_ENT) !=null && !request.getParameter(REMARKS_ENT).equals("")){
			avMedicalExamMaMo.setRemarksEar(request.getParameter(REMARKS_ENT));
		}
		
		if(request.getParameter(CV_RT) !=null && !request.getParameter(CV_RT).equals("")){
			 avMedicalExamMaMo.setHearRtCv(new BigDecimal(request.getParameter(CV_RT)));
		}
		if(request.getParameter(CV_LT) !=null && !request.getParameter(CV_LT).equals("")){
			avMedicalExamMaMo.setHearLtCv(new BigDecimal(request.getParameter(CV_LT)));
		}
		if(request.getParameter(CV_BOTH) !=null && !request.getParameter(CV_BOTH).equals("")){
			avMedicalExamMaMo.setHearLtBoth(new BigDecimal(request.getParameter(CV_BOTH)));
		}
		if(request.getParameter(FWV_RT) !=null && !request.getParameter(FWV_RT).equals("")){
			 avMedicalExamMaMo.setHearRtFwv(new BigDecimal(request.getParameter(FWV_RT)));
		}
		if(request.getParameter(FWV_LT) !=null && !request.getParameter(FWV_LT).equals("")){
			 avMedicalExamMaMo.setHearLtFwv(new BigDecimal(request.getParameter(FWV_LT)));
		}
		if(request.getParameter(FWV_BOTH) !=null && !request.getParameter(FWV_BOTH).equals("")){
			 avMedicalExamMaMo.setHearRtBoth(new BigDecimal(request.getParameter(FWV_BOTH)));
		}
		
		if(request.getParameter(RT_EAR_250) !=null && !request.getParameter(RT_EAR_250).equals("")){
			 avMedicalExamMaMo.setAudioRt250(new BigDecimal(request.getParameter(RT_EAR_250)));
		}
		if(request.getParameter(LT_EAR_250) !=null && !request.getParameter(LT_EAR_250).equals("")){
			 avMedicalExamMaMo.setAudioLt250(new BigDecimal(request.getParameter(LT_EAR_250)));
		}
		if(request.getParameter(RT_EAR_500) !=null && !request.getParameter(RT_EAR_500).equals("")){
			 avMedicalExamMaMo.setAudioRt500(new BigDecimal(request.getParameter(RT_EAR_500)));
		}
		if(request.getParameter(LT_EAR_250) !=null && !request.getParameter(LT_EAR_250).equals("")){
			 avMedicalExamMaMo.setAudioLt500(new BigDecimal(request.getParameter(LT_EAR_250)));
		}
		
		if(request.getParameter(RT_EAR_1000) !=null && !request.getParameter(RT_EAR_1000).equals("")){
			 avMedicalExamMaMo.setAudioRt1000(new BigDecimal(request.getParameter(RT_EAR_1000)));
		}
		if(request.getParameter(LT_EAR_1000) !=null && !request.getParameter(LT_EAR_1000).equals("")){
			 avMedicalExamMaMo.setAudioLt1000(new BigDecimal(request.getParameter(LT_EAR_1000)));
		}
		
		if(request.getParameter(RT_EAR_2000) !=null && !request.getParameter(RT_EAR_2000).equals("")){
			 avMedicalExamMaMo.setAudioRt2000(new BigDecimal(request.getParameter(RT_EAR_2000)));
		}
		if(request.getParameter(LT_EAR_2000) !=null && !request.getParameter(LT_EAR_2000).equals("")){
			 avMedicalExamMaMo.setAudioLt2000(new BigDecimal(request.getParameter(LT_EAR_2000)));
		}
		
		if(request.getParameter(RT_EAR_3000) !=null && !request.getParameter(RT_EAR_3000).equals("")){
			 avMedicalExamMaMo.setAudioRt3000(new BigDecimal(request.getParameter(RT_EAR_3000)));
		}
		if(request.getParameter(LT_EAR_3000) !=null && !request.getParameter(LT_EAR_3000).equals("")){
			 avMedicalExamMaMo.setAudioLt3000(new BigDecimal(request.getParameter(LT_EAR_3000)));
		}
		int hinId=0;
		int visitId=0;
		if (request.getParameter("hinId") != null ) {
			hinId  = Integer.parseInt(request.getParameter("hinId"));
		}
		if (request.getParameter("visitId") != null ) {
			visitId  = Integer.parseInt(request.getParameter("visitId"));
		}
		if(hinId !=0){
			Patient patient=new Patient();
			patient.setId(hinId);
			avMedicalExamMaMo.setHin(patient);
			}
		if(visitId !=0){
		Visit visit=new Visit();
		visit.setId(visitId);
		avMedicalExamMaMo.setVisit(visit);
		}
		if(hospitalId !=0){
			MasHospital hospital=new MasHospital();
			hospital.setId(hospitalId);
			avMedicalExamMaMo.setHospital(hospital);
		}
		List<String> chargeCodeIdList = new ArrayList<String>();
		List<Integer> quantityList = new ArrayList<Integer>();
		List<String> investigationReferToMHList=new ArrayList<String>();
		String clinicalNotes1="";
		if (request.getParameter("clinicalNotes1") != null
				&& !(request.getParameter("clinicalNotes1").equals(""))) {
			clinicalNotes1 = request.getParameter("clinicalNotes1");
		}

		int hiddenValue = 1;
		if (Integer.parseInt(request.getParameter("hiddenValue")) != 1) 
		{
			hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
		}
		String deleatedValue = "";
		if (request.getParameter("deleatedValue") != "")
		{
			deleatedValue = request.getParameter("deleatedValue");

		}
		infoMap.put("deleatedValue",deleatedValue);
		int temp = 1;
		List<Integer> patientInvestigationdetailsIdList = new ArrayList<Integer>();
		List<Integer> dgOrderdtIdList = new ArrayList<Integer>();
		String[] chargeCodeIdArr = new String[hiddenValue];
		for (int i = 0; i < hiddenValue; i++) {
			if (request.getParameter("chargeCodeName" + temp) != null
					&& !request.getParameter("chargeCodeName" + temp)
					.equals("")) {

				String chargeCodeNameWithId = request
				.getParameter("chargeCodeName" + temp);
				int index1 = chargeCodeNameWithId.lastIndexOf("[");
				int index2 = chargeCodeNameWithId.lastIndexOf("]");
				index1++;
				String chargeCodeId = chargeCodeNameWithId.substring(index1,
						index2);
				if (!chargeCodeId.equals("")) {
					chargeCodeIdArr[i] = chargeCodeId;
					int qty = 1;

					if (request.getParameter("investigationReferToMH" + temp) != null && !request.getParameter("investigationReferToMH" + temp).equals(""))
					{
						investigationReferToMHList.add(request.getParameter("investigationReferToMH" + temp));
					}else
					{
						investigationReferToMHList.add("n");
					}
					
					// int
					// qty=Integer.parseInt(request.getParameter("qty"+temp));
					//	String clinicalNotes = request.getParameter("clinicalNotes"	+ temp);

					chargeCodeIdList.add(chargeCodeIdArr[i]);
					quantityList.add(qty);
					//clinicalList.add(clinicalNotes);
				}
			}
			if (request.getParameter("patientInvestigationdetailsId" + temp) != null
					&& !request.getParameter("patientInvestigationdetailsId" + temp)
					.equals("")) {
				patientInvestigationdetailsIdList.add(Integer.parseInt(request.getParameter("patientInvestigationdetailsId" + temp)));
			}
			if (request.getParameter("dgOrderdtId" + temp) != null
					&& !request.getParameter("dgOrderdtId" + temp)
					.equals("")) {
				dgOrderdtIdList.add(Integer.parseInt(request.getParameter("dgOrderdtId" + temp)));
			}
			temp++;
		}
		String lastChangedTime = (String) utilMap.get("currentTime");
		infoMap.put("hinId",hinId);
		infoMap.put("visitId", visitId);
		infoMap.put("patientInvestigationHeaderId", 0);
		infoMap.put("dgOrderhdId", 0);
		infoMap.put("patientInvestigationdetailsIdList", patientInvestigationdetailsIdList);
		infoMap.put("dgOrderdtIdList", dgOrderdtIdList);
		infoMap.put("chargeCodeIdList", chargeCodeIdList);
		infoMap.put("quantityList", quantityList);
		infoMap.put("clinicalNotes1", clinicalNotes1);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("deptId", deptId);
		infoMap.put("userId",userId);
		infoMap.put("empId",user.getEmployee().getId());
		infoMap.put("lastChangedTime", lastChangedTime);
		infoMap.put("investigationReferToMHList",investigationReferToMHList);
	} catch (NumberFormatException e) {
		e.printStackTrace();
	}
	String orderSeqNo = "";
	orderSeqNo=labHandlerService.generateOrderNumber(hospitalId);
	infoMap.put("orderSeqNo",orderSeqNo);
	String message="";
	Boolean successfullyAdded = false;
	successfullyAdded = aviationMedicineHandlerService.submitAviationMA(avMedicalExamMaMo,infoMap);
	
	if(successfullyAdded){
		message="Record Added Successfully !!";
	}
	else{
		message="Try Again !!";
	}
	jsp = AV_MESSAGE;
	/*try {
		//	map = medicalExaminationBoardHandlerService.showMedicalExaminationBoardJsp();
	} catch (Exception e) {
		e.printStackTrace();
	}*/
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("message", message);
	return new ModelAndView("indexB", "map", map);
}
public ModelAndView updateAviationMA(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	int deptId = (Integer) session.getAttribute("deptId");
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	int userId = 0;
	String message="";
	Users user = (Users)session.getAttribute("users");
	userId = user.getId();
	int medExamMaMoId=0;
		medExamMaMoId=Integer.parseInt(request.getParameter("medExamMaMoId"));
	AvMedicalExamMaMo avMedicalExamMaMo=new AvMedicalExamMaMo();
	avMedicalExamMaMo = aviationMedicineHandlerService.loadAviationExamObj(medExamMaMoId);
	//---For PHYSICAL AND MENTAL DETAILS Tab-----
	if(request.getParameter("medExamMaMoId") != null && (Integer.parseInt(request.getParameter("medExamMaMoId")) != 0 )){
		avMedicalExamMaMo.setMaDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
	if(request.getParameter(HEIGHT) !=null && !request.getParameter(HEIGHT).equals("")){
		avMedicalExamMaMo.setHeight(new BigDecimal(request.getParameter(HEIGHT)));
	}
	if(request.getParameter(WEIGHT) !=null && !request.getParameter(WEIGHT).equals("")){
		avMedicalExamMaMo.setWeight(new BigDecimal(request.getParameter(WEIGHT)));
	}
	if(request.getParameter(BMI) !=null && !request.getParameter(BMI).equals("")){
		avMedicalExamMaMo.setBmi(new BigDecimal(request.getParameter(BMI)));
	}
	if(request.getParameter(CHEST) !=null && !request.getParameter(CHEST).equals("")){
		avMedicalExamMaMo.setChestCircumference(new BigDecimal(request.getParameter(CHEST)));
	}
	if(request.getParameter(EXPIRATION) !=null && !request.getParameter(EXPIRATION).equals("")){
		avMedicalExamMaMo.setExpiration(new BigDecimal(request.getParameter(EXPIRATION)));
	}
	if(request.getParameter(PULSE) !=null && !request.getParameter(PULSE).equals("")){
		avMedicalExamMaMo.setPulseSeated(request.getParameter(PULSE));
	}
	if(request.getParameter(PULSE_EXERCISE) !=null && !request.getParameter(PULSE_EXERCISE).equals("")){
		avMedicalExamMaMo.setPulseExercise(request.getParameter(PULSE_EXERCISE));
	}
	if(request.getParameter(PULSE_NORMAL) !=null && !request.getParameter(PULSE_NORMAL).equals("")){
		avMedicalExamMaMo.setMinPulseNormal(request.getParameter(PULSE_NORMAL));
	}
	if(request.getParameter(BP) !=null && !request.getParameter(BP).equals("")){
		avMedicalExamMaMo.setBp(request.getParameter(BP));
	}
	if(request.getParameter(ELECTROCARDIOGRAM) !=null && !request.getParameter(ELECTROCARDIOGRAM).equals("")){
		avMedicalExamMaMo.setElectrocardiogram(request.getParameter(ELECTROCARDIOGRAM));
	}
	if(request.getParameter(SKIN) !=null && !request.getParameter(SKIN).equals("")){
		avMedicalExamMaMo.setSystemicSkin(request.getParameter(SKIN));
	}
	if(request.getParameter(REMARKS_SKIN) !=null && !request.getParameter(REMARKS_SKIN).equals("")){
		avMedicalExamMaMo.setRemarksSkin(request.getParameter(REMARKS_SKIN));
	}
	if(request.getParameter(LYMPHNODES_YMPHATICS) !=null && !request.getParameter(LYMPHNODES_YMPHATICS).equals("")){
		avMedicalExamMaMo.setSystemLymphnodeLymphatic(request.getParameter(LYMPHNODES_YMPHATICS));
	}
	if(request.getParameter(REMARKS_LYMPHNODES_LYMPHATICS) !=null && !request.getParameter(REMARKS_LYMPHNODES_LYMPHATICS).equals("")){
		avMedicalExamMaMo.setRemarksLymphnodeLymphatic(request.getParameter(REMARKS_LYMPHNODES_LYMPHATICS));
	}
	if(request.getParameter(HEAD_FACE_NECK_SCALP) !=null && !request.getParameter(HEAD_FACE_NECK_SCALP).equals("")){
		avMedicalExamMaMo.setSystemHeadFaceNeck(request.getParameter(HEAD_FACE_NECK_SCALP));
	}
	if(request.getParameter(REMARKS_HEAD_FACE_NECK_SCALP) !=null && !request.getParameter(REMARKS_HEAD_FACE_NECK_SCALP).equals("")){
		avMedicalExamMaMo.setRemarksHeadFaceNeck(request.getParameter(REMARKS_HEAD_FACE_NECK_SCALP));
	}
	if(request.getParameter(UPPER_LOWER_EXTRMITIES) !=null && !request.getParameter(UPPER_LOWER_EXTRMITIES).equals("")){
		avMedicalExamMaMo.setSystemUperLowerExtremitie(request.getParameter(UPPER_LOWER_EXTRMITIES));
	}
	if(request.getParameter(REMARKS_UPPER_LOWER_EXTRMITIES) !=null && !request.getParameter(REMARKS_UPPER_LOWER_EXTRMITIES).equals("")){
		avMedicalExamMaMo.setRemarksUperLowerExtremitie(request.getParameter(REMARKS_UPPER_LOWER_EXTRMITIES));
	}
	if(request.getParameter(SPINE_MUSCULO_SKELETAL) !=null && !request.getParameter(SPINE_MUSCULO_SKELETAL).equals("")){
		avMedicalExamMaMo.setSystemSpineMusculo(request.getParameter(SPINE_MUSCULO_SKELETAL));
	}
	if(request.getParameter(REMARKS_SPINE_MUSCULO_SKELETAL) !=null && !request.getParameter(REMARKS_SPINE_MUSCULO_SKELETAL).equals("")){
		avMedicalExamMaMo.setRemarksSpineMusculo(request.getParameter(REMARKS_SPINE_MUSCULO_SKELETAL));
	}
	if(request.getParameter(CHEST_AND_LUNGS) !=null && !request.getParameter(CHEST_AND_LUNGS).equals("")){
		avMedicalExamMaMo.setSystemChestLungs(request.getParameter(CHEST_AND_LUNGS));
	}
	if(request.getParameter(REMARKS_CHEST_AND_LUNGS) !=null && !request.getParameter(REMARKS_CHEST_AND_LUNGS).equals("")){
		avMedicalExamMaMo.setRemarksChestLungs(request.getParameter(REMARKS_CHEST_AND_LUNGS));
	}
	if(request.getParameter(HEART) !=null && !request.getParameter(HEART).equals("")){
		avMedicalExamMaMo.setSystemHeart(request.getParameter(HEART));
	}
	if(request.getParameter(REMARKS_HEART) !=null && !request.getParameter(REMARKS_HEART).equals("")){
		avMedicalExamMaMo.setRemarksHeart(request.getParameter(REMARKS_HEART));
	}
	if(request.getParameter(VASCULAR_SYSTEM) !=null && !request.getParameter(VASCULAR_SYSTEM).equals("")){
		avMedicalExamMaMo.setSystemVascular(request.getParameter(VASCULAR_SYSTEM));
	}
	if(request.getParameter(REMARKS_VASCULAR_SYSTEM) !=null && !request.getParameter(REMARKS_VASCULAR_SYSTEM).equals("")){
		avMedicalExamMaMo.setRemarksVascular(request.getParameter(REMARKS_VASCULAR_SYSTEM));
	}
	if(request.getParameter(ABDOMEN_VISCERA) !=null && !request.getParameter(ABDOMEN_VISCERA).equals("")){
		avMedicalExamMaMo.setSystemAbdomenViscera(request.getParameter(ABDOMEN_VISCERA));
	}
	if(request.getParameter(REMARKS_ABDOMEN_VISCERA) !=null && !request.getParameter(REMARKS_ABDOMEN_VISCERA).equals("")){
		avMedicalExamMaMo.setRemarksAbdomenViscera(request.getParameter(REMARKS_ABDOMEN_VISCERA));
	}
	if(request.getParameter(PERINCUM_ANUS) !=null && !request.getParameter(PERINCUM_ANUS).equals("")){
		avMedicalExamMaMo.setSystemPerincumAnus(request.getParameter(PERINCUM_ANUS));
	}
	if(request.getParameter(REMARKS_PERINCUM_ANUS) !=null && !request.getParameter(REMARKS_PERINCUM_ANUS).equals("")){
		avMedicalExamMaMo.setRemarksPerincumAnus(request.getParameter(REMARKS_PERINCUM_ANUS));
	}
	
	if(request.getParameter(GENITOURINARY_SYSTEM) !=null && !request.getParameter(GENITOURINARY_SYSTEM).equals("")){
		avMedicalExamMaMo.setSystemGenitourinary(request.getParameter(GENITOURINARY_SYSTEM));
	}
	if(request.getParameter(REMARKS_GENITOURINARY_SYSTEM) !=null && !request.getParameter(REMARKS_GENITOURINARY_SYSTEM).equals("")){
		avMedicalExamMaMo.setRemarksGenitourinary(request.getParameter(REMARKS_GENITOURINARY_SYSTEM));
	}
	if(request.getParameter(ENDOCRINE_SYSTEM) !=null && !request.getParameter(ENDOCRINE_SYSTEM).equals("")){
		avMedicalExamMaMo.setSystemEndocrine(request.getParameter(ENDOCRINE_SYSTEM));
	}
	if(request.getParameter(REMARKS_ENDOCRINE_SYSTEM) !=null && !request.getParameter(REMARKS_ENDOCRINE_SYSTEM).equals("")){
		avMedicalExamMaMo.setRemarksEndocrine(request.getParameter(REMARKS_ENDOCRINE_SYSTEM));
	}
	if(request.getParameter(NEUROLOGIC) !=null && !request.getParameter(NEUROLOGIC).equals("")){
		avMedicalExamMaMo.setSystemNeurologic(request.getParameter(NEUROLOGIC));
	}
	if(request.getParameter(REMARKS_NEUROLOGIC) !=null && !request.getParameter(REMARKS_NEUROLOGIC).equals("")){
		avMedicalExamMaMo.setRemarksNeurologic(request.getParameter(REMARKS_NEUROLOGIC));
	}
	if(request.getParameter(PSYCHIARTRIC) !=null && !request.getParameter(PSYCHIARTRIC).equals("")){
		avMedicalExamMaMo.setSystemPsychiartric(request.getParameter(PSYCHIARTRIC));
	}
	if(request.getParameter(REMARKS_PSYCHIARTRIC) !=null && !request.getParameter(REMARKS_PSYCHIARTRIC).equals("")){
		avMedicalExamMaMo.setRemarksPsychiartric(request.getParameter(REMARKS_PSYCHIARTRIC));
	}
	//----------In case of women--
	if(request.getParameter(EXAMINATION_OF_BREASTS) !=null && !request.getParameter(EXAMINATION_OF_BREASTS).equals("")){
		avMedicalExamMaMo.setExaminationBreasts(request.getParameter(EXAMINATION_OF_BREASTS));
	}
	if(request.getParameter(LAST_MENSTRUATION_DATE) !=null && !request.getParameter(LAST_MENSTRUATION_DATE).equals("")){
		avMedicalExamMaMo.setMenstruationDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(LAST_MENSTRUATION_DATE)));
	}
	if(request.getParameter(PELVIC_EXAMINATION) !=null && !request.getParameter(PELVIC_EXAMINATION).equals("")){
		avMedicalExamMaMo.setPelvicExamination(request.getParameter(PELVIC_EXAMINATION));
		}
	if(request.getParameter(REMARKS) !=null && !request.getParameter(REMARKS).equals("")){
	 avMedicalExamMaMo.setPhysicalMentalRemarks(request.getParameter(REMARKS));
		}
	//---For Eye Tab----
	if(request.getParameter(LIDS) !=null && !request.getParameter(LIDS).equals("")){
		 avMedicalExamMaMo.setEyeLidsLachrymal(request.getParameter(LIDS));
	}
	if(request.getParameter(VISUAL_FIELDS) !=null && !request.getParameter(VISUAL_FIELDS).equals("")){
		 avMedicalExamMaMo.setEyeVisualFields(request.getParameter(VISUAL_FIELDS));
	}
	if(request.getParameter(OCULAR_MOTILITY) !=null && !request.getParameter(OCULAR_MOTILITY).equals("")){
		 avMedicalExamMaMo.setEyeOcularMotility(request.getParameter(OCULAR_MOTILITY));
	}
	if(request.getParameter(VISUAL_ACUITY) !=null && !request.getParameter(VISUAL_ACUITY).equals("")){
		 avMedicalExamMaMo.setEyeVisualAcuity(request.getParameter(VISUAL_ACUITY));
	}
	if(request.getParameter(WITHOUT_GLASSES_RT) !=null && !request.getParameter(WITHOUT_GLASSES_RT).equals("")){
		 avMedicalExamMaMo.setWthoutGlassesRDistant(request.getParameter(WITHOUT_GLASSES_RT));
	}
	if(request.getParameter(WITHOUT_GLASSES_LT) !=null && !request.getParameter(WITHOUT_GLASSES_LT).equals("")){
		 avMedicalExamMaMo.setWthoutGlassesLDistant(request.getParameter(WITHOUT_GLASSES_LT));
	}
	if(request.getParameter(WITHOUT_GLASSES_BOTH) !=null && !request.getParameter(WITHOUT_GLASSES_BOTH).equals("")){
		 avMedicalExamMaMo.setWthoutGlassesBothDistant(request.getParameter(WITHOUT_GLASSES_BOTH));
	}
	if(request.getParameter(WITH_GLASSES_RT) !=null && !request.getParameter(WITH_GLASSES_RT).equals("")){
		 avMedicalExamMaMo.setWithGlassesRDistant(request.getParameter(WITH_GLASSES_RT));
	}
	if(request.getParameter(WITH_GLASSES_BOTH) !=null && !request.getParameter(WITH_GLASSES_BOTH).equals("")){
		 avMedicalExamMaMo.setWithGlassesBothDistant(request.getParameter(WITH_GLASSES_BOTH));
	}
	if(request.getParameter(WITH_GLASSES_LT) !=null && !request.getParameter(WITH_GLASSES_LT).equals("")){
		 avMedicalExamMaMo.setWithGlassesLDistant(request.getParameter(WITH_GLASSES_LT));
	}
	if(request.getParameter(NEAR_VISION) !=null && !request.getParameter(NEAR_VISION).equals("")){
		 avMedicalExamMaMo.setNearVision(new BigDecimal(request.getParameter(NEAR_VISION)));
	}
	if(request.getParameter(ABLE_TO_READ_N5) !=null && !request.getParameter(ABLE_TO_READ_N5).equals("")){
		 avMedicalExamMaMo.setN5Read(request.getParameter(ABLE_TO_READ_N5));
	}
	if(request.getParameter(INTERMEDIATE_VISION) !=null && !request.getParameter(INTERMEDIATE_VISION).equals("")){
		 avMedicalExamMaMo.setIntermediateVision(new BigDecimal(request.getParameter(INTERMEDIATE_VISION)));
	}
	if(request.getParameter(ABLE_TO_READ_N14) !=null && !request.getParameter(ABLE_TO_READ_N14).equals("")){
		 avMedicalExamMaMo.setN14Read(request.getParameter(ABLE_TO_READ_N14));
	}
	if(request.getParameter(WITHOUT_GLASSES) !=null && !request.getParameter(WITHOUT_GLASSES).equals("")){
		 avMedicalExamMaMo.setAcomodationWithoutglass(new BigDecimal(request.getParameter(WITHOUT_GLASSES)));
	}
	if(request.getParameter(WITH_GLASSES) !=null && !request.getParameter(WITH_GLASSES).equals("")){
		 avMedicalExamMaMo.setAcomodationWithglass(new BigDecimal(request.getParameter(WITH_GLASSES)));
	}
	if(request.getParameter(CANDIDATE_POSSES_GLASSES) !=null && !request.getParameter(CANDIDATE_POSSES_GLASSES).equals("")){
		 avMedicalExamMaMo.setCandidatePossesGlasses(request.getParameter(CANDIDATE_POSSES_GLASSES));
	}
	if(request.getParameter(DISTANT_RT_S) !=null && !request.getParameter(DISTANT_RT_S).equals("")){
		 avMedicalExamMaMo.setDistantRightS(new BigDecimal(request.getParameter(DISTANT_RT_S)));
	}
	if(request.getParameter(DISTANT_RT_C) !=null && !request.getParameter(DISTANT_RT_C).equals("")){
		 avMedicalExamMaMo.setDistantRightC(new BigDecimal(request.getParameter(DISTANT_RT_C)));
	}
	if(request.getParameter(DISTANT_RT_A) !=null && !request.getParameter(DISTANT_RT_A).equals("")){
		 avMedicalExamMaMo.setDistantRightA(new BigDecimal(request.getParameter(DISTANT_RT_A)));
	}
	if(request.getParameter(DISTANT_LT_S) !=null && !request.getParameter(DISTANT_LT_S).equals("")){
		 avMedicalExamMaMo.setDistantLeftS(new BigDecimal(request.getParameter(DISTANT_LT_S)));
	}
	if(request.getParameter(DISTANT_LT_C) !=null && !request.getParameter(DISTANT_LT_C).equals("")){
		 avMedicalExamMaMo.setDistantLeftC(new BigDecimal(request.getParameter(DISTANT_LT_C)));
	}
	if(request.getParameter(DISTANT_LT_A) !=null && !request.getParameter(DISTANT_LT_A).equals("")){
		 avMedicalExamMaMo.setDistantLeftA(new BigDecimal(request.getParameter(DISTANT_LT_A)));
	}
	if(request.getParameter(NEAR_RT_S) !=null && !request.getParameter(NEAR_LT_S).equals("")){
		 avMedicalExamMaMo.setNearRightS(new BigDecimal(request.getParameter(NEAR_LT_S)));
	}
	if(request.getParameter(NEAR_RT_C) !=null && !request.getParameter(NEAR_LT_C).equals("")){
		 avMedicalExamMaMo.setNearRightC(new BigDecimal(request.getParameter(NEAR_LT_C)));
	}
	if(request.getParameter(NEAR_RT_A) !=null && !request.getParameter(NEAR_LT_A).equals("")){
		 avMedicalExamMaMo.setNearRightA(new BigDecimal(request.getParameter(NEAR_LT_A)));
	}
	
	if(request.getParameter(NEAR_LT_S) !=null && !request.getParameter(NEAR_LT_S).equals("")){
		 avMedicalExamMaMo.setNearLeftS(new BigDecimal(request.getParameter(NEAR_LT_S)));
	}
	if(request.getParameter(NEAR_LT_C) !=null && !request.getParameter(NEAR_LT_C).equals("")){
		 avMedicalExamMaMo.setNearLeftC(new BigDecimal(request.getParameter(NEAR_LT_C)));
	}
	if(request.getParameter(NEAR_LT_A) !=null && !request.getParameter(NEAR_LT_A).equals("")){
		 avMedicalExamMaMo.setNearLeftA(new BigDecimal(request.getParameter(NEAR_LT_A)));
	}
	if(request.getParameter(POWER_CONVERGENCE_C) !=null && !request.getParameter(POWER_CONVERGENCE_C).equals("")){
		 avMedicalExamMaMo.setPowerConvergenceC(new BigDecimal(request.getParameter(POWER_CONVERGENCE_C)));
	}
	if(request.getParameter(POWER_CONVERGENCE_SC) !=null && !request.getParameter(POWER_CONVERGENCE_SC).equals("")){
		 avMedicalExamMaMo.setPowerConvergenceSc(new BigDecimal(request.getParameter(POWER_CONVERGENCE_SC)));
	}
	if(request.getParameter(RESULT_COVER_TEST_AT6) !=null && !request.getParameter(RESULT_COVER_TEST_AT6).equals("")){
		 avMedicalExamMaMo.setResultCoverTestAt6(new BigDecimal(request.getParameter(RESULT_COVER_TEST_AT6)));
	}
	if(request.getParameter(RESULT_COVER_TEST_AT33) !=null && !request.getParameter(RESULT_COVER_TEST_AT33).equals("")){
		 avMedicalExamMaMo.setResultCoverTestAt33(new BigDecimal(request.getParameter(RESULT_COVER_TEST_AT33)));
	}
	if(request.getParameter(MADDOX_ROD_AT6) !=null && !request.getParameter(MADDOX_ROD_AT6).equals("")){
		 avMedicalExamMaMo.setMaddoxRodAt6(new BigDecimal(request.getParameter(MADDOX_ROD_AT6)));
	}
	if(request.getParameter(MADDOX_ROD_AT33) !=null && !request.getParameter(MADDOX_ROD_AT33).equals("")){
		 avMedicalExamMaMo.setMaddoxRodAt33(new BigDecimal(request.getParameter(MADDOX_ROD_AT33)));
	}
	//---------For Colour Prescription Tab--
	if(request.getParameter(PSEUDOISCHROMATIC) !=null && !request.getParameter(PSEUDOISCHROMATIC).equals("")){
		avMedicalExamMaMo.setEyePseudoischromatic(request.getParameter(PSEUDOISCHROMATIC));
	}
	if(request.getParameter(ABNORMAL_TEST_RESULT) !=null && !request.getParameter(ABNORMAL_TEST_RESULT).equals("")){
		avMedicalExamMaMo.setEyeDistinguishingReadily(request.getParameter(ABNORMAL_TEST_RESULT));
	}
	if(request.getParameter(COLOUR_REMARKS) !=null && !request.getParameter(COLOUR_REMARKS).equals("")){
		avMedicalExamMaMo.setEyeRemarks(request.getParameter(COLOUR_REMARKS));
	}
	//---------For Ent Tab--
	if(request.getParameter(TYMPANUM_EXTERNAL_EARS) !=null && !request.getParameter(TYMPANUM_EXTERNAL_EARS).equals("")){
		avMedicalExamMaMo.setEntExternalTympanum(request.getParameter(TYMPANUM_EXTERNAL_EARS));
	}
	if(request.getParameter(EUSTACHEAN_TUBE_EXTERNAL) !=null && !request.getParameter(EUSTACHEAN_TUBE_EXTERNAL).equals("")){
		avMedicalExamMaMo.setExternalEustacheanTube(request.getParameter(EUSTACHEAN_TUBE_EXTERNAL));
	}
	if(request.getParameter(MASTOID_EXTERNAL_EARS) !=null && !request.getParameter(MASTOID_EXTERNAL_EARS).equals("")){
		avMedicalExamMaMo.setExternalMastoid(request.getParameter(MASTOID_EXTERNAL_EARS));
	}
	if(request.getParameter(TYMPANUM_MIDDLE_EARS) !=null && !request.getParameter(TYMPANUM_MIDDLE_EARS).equals("")){
		avMedicalExamMaMo.setEntMiddleTympanum(request.getParameter(TYMPANUM_MIDDLE_EARS));
	}
	if(request.getParameter(EUSTACHEAN_TUBE_MIDDLE) !=null && !request.getParameter(EUSTACHEAN_TUBE_MIDDLE).equals("")){
		avMedicalExamMaMo.setMiddleEustacheanTube(request.getParameter(EUSTACHEAN_TUBE_MIDDLE));
	}
	
	if(request.getParameter(MASTOID_MIDDLE_EARS) !=null && !request.getParameter(MASTOID_MIDDLE_EARS).equals("")){
		avMedicalExamMaMo.setEntMastoid(request.getParameter(MASTOID_MIDDLE_EARS));
	}
	
	if(request.getParameter(COCHLEAR_FUNCTIONS) !=null && !request.getParameter(COCHLEAR_FUNCTIONS).equals("")){
		avMedicalExamMaMo.setEntCochlear(request.getParameter(COCHLEAR_FUNCTIONS));
	}
	if(request.getParameter(VESTIBULAR_FUNCTIONS) !=null && !request.getParameter(VESTIBULAR_FUNCTIONS).equals("")){
		avMedicalExamMaMo.setEntVestibular(request.getParameter(VESTIBULAR_FUNCTIONS));
	}	
	if(request.getParameter(NOSE_PARANASAL_SINUSES) !=null && !request.getParameter(NOSE_PARANASAL_SINUSES).equals("")){
		avMedicalExamMaMo.setEntNoseParanasal(request.getParameter(NOSE_PARANASAL_SINUSES));
	}
	
	if(request.getParameter(MOUTH_TEETH_THROAT) !=null && !request.getParameter(MOUTH_TEETH_THROAT).equals("")){
		avMedicalExamMaMo.setMouthTeethThroat(request.getParameter(MOUTH_TEETH_THROAT));
	}
	if(request.getParameter(SPEECH) !=null && !request.getParameter(SPEECH).equals("")){
		avMedicalExamMaMo.setSpeech(request.getParameter(SPEECH));
	}
	if(request.getParameter(RT_EAR_RINNE) !=null && !request.getParameter(RT_EAR_RINNE).equals("")){
		avMedicalExamMaMo.setTunningRtRinnie(request.getParameter(RT_EAR_RINNE));
	}
	if(request.getParameter(RT_EAR_WEBER) !=null && !request.getParameter(RT_EAR_WEBER).equals("")){
		avMedicalExamMaMo.setTunningRtWebe(request.getParameter(RT_EAR_WEBER));
	}
	if(request.getParameter(RT_ABC) !=null && !request.getParameter(RT_ABC).equals("")){
		avMedicalExamMaMo.setTunningRtAbc(request.getParameter(RT_ABC));
	}
	if(request.getParameter(LT_EAR_RINNE) !=null && !request.getParameter(LT_EAR_RINNE).equals("")){
		avMedicalExamMaMo.setTunningLtRinnie(request.getParameter(LT_EAR_RINNE));
	}
	if(request.getParameter(LT_EAR_WEBER) !=null && !request.getParameter(LT_EAR_WEBER).equals("")){
		avMedicalExamMaMo.setTunningLtWebe(request.getParameter(LT_EAR_WEBER));
	}
	if(request.getParameter(LT_ABC) !=null && !request.getParameter(LT_ABC).equals("")){
		avMedicalExamMaMo.setTunningLtAbc(request.getParameter(LT_ABC));
	}
	if(request.getParameter(SCORE_RT_EAR) !=null && !request.getParameter(SCORE_RT_EAR).equals("")){
		avMedicalExamMaMo.setSpeechIntelligiblRt(request.getParameter(SCORE_RT_EAR));
	}
	if(request.getParameter(SCORE_LT_EAR) !=null && !request.getParameter(SCORE_LT_EAR).equals("")){
		avMedicalExamMaMo.setSpeechIntelligiblLt(request.getParameter(SCORE_RT_EAR));
	}
	if(request.getParameter(RESULT_RT_EAR) !=null && !request.getParameter(RESULT_RT_EAR).equals("")){
		avMedicalExamMaMo.setSpeechRtResult(request.getParameter(RESULT_RT_EAR));
	}
	if(request.getParameter(RESULT_LT_EAR) !=null && !request.getParameter(RESULT_LT_EAR).equals("")){
		avMedicalExamMaMo.setSpeechLtResult(request.getParameter(RESULT_LT_EAR));
	}
	if(request.getParameter(REMARKS_ENT) !=null && !request.getParameter(REMARKS_ENT).equals("")){
		avMedicalExamMaMo.setRemarksEar(request.getParameter(REMARKS_ENT));
	}
	
	if(request.getParameter(CV_RT) !=null && !request.getParameter(CV_RT).equals("")){
		 avMedicalExamMaMo.setHearRtCv(new BigDecimal(request.getParameter(CV_RT)));
	}
	if(request.getParameter(CV_LT) !=null && !request.getParameter(CV_LT).equals("")){
		avMedicalExamMaMo.setHearLtCv(new BigDecimal(request.getParameter(CV_LT)));
	}
	if(request.getParameter(CV_BOTH) !=null && !request.getParameter(CV_BOTH).equals("")){
		avMedicalExamMaMo.setHearLtBoth(new BigDecimal(request.getParameter(CV_BOTH)));
	}
	if(request.getParameter(FWV_RT) !=null && !request.getParameter(FWV_RT).equals("")){
		 avMedicalExamMaMo.setHearRtFwv(new BigDecimal(request.getParameter(FWV_RT)));
	}
	if(request.getParameter(FWV_LT) !=null && !request.getParameter(FWV_LT).equals("")){
		 avMedicalExamMaMo.setHearLtFwv(new BigDecimal(request.getParameter(FWV_LT)));
	}
	if(request.getParameter(CV_BOTH) !=null && !request.getParameter(CV_BOTH).equals("")){
		 avMedicalExamMaMo.setHearLtBoth(new BigDecimal(request.getParameter(CV_BOTH)));
	}
	if(request.getParameter(FWV_BOTH) !=null && !request.getParameter(FWV_BOTH).equals("")){
		 avMedicalExamMaMo.setHearRtBoth(new BigDecimal(request.getParameter(FWV_BOTH)));
	}
	if(request.getParameter(RT_EAR_250) !=null && !request.getParameter(RT_EAR_250).equals("")){
		 avMedicalExamMaMo.setAudioRt250(new BigDecimal(request.getParameter(RT_EAR_250)));
	}
	if(request.getParameter(LT_EAR_250) !=null && !request.getParameter(LT_EAR_250).equals("")){
		 avMedicalExamMaMo.setAudioLt250(new BigDecimal(request.getParameter(LT_EAR_250)));
	}
	if(request.getParameter(RT_EAR_500) !=null && !request.getParameter(RT_EAR_500).equals("")){
		 avMedicalExamMaMo.setAudioRt500(new BigDecimal(request.getParameter(RT_EAR_500)));
	}
	if(request.getParameter(LT_EAR_500) !=null && !request.getParameter(LT_EAR_500).equals("")){
		 avMedicalExamMaMo.setAudioLt500(new BigDecimal(request.getParameter(LT_EAR_500)));
	}
	
	if(request.getParameter(RT_EAR_1000) !=null && !request.getParameter(RT_EAR_1000).equals("")){
		 avMedicalExamMaMo.setAudioRt1000(new BigDecimal(request.getParameter(RT_EAR_1000)));
	}
	if(request.getParameter(LT_EAR_1000) !=null && !request.getParameter(LT_EAR_1000).equals("")){
		 avMedicalExamMaMo.setAudioLt1000(new BigDecimal(request.getParameter(LT_EAR_1000)));
	}
	
	if(request.getParameter(RT_EAR_2000) !=null && !request.getParameter(RT_EAR_2000).equals("")){
		 avMedicalExamMaMo.setAudioRt2000(new BigDecimal(request.getParameter(RT_EAR_2000)));
	}
	if(request.getParameter(LT_EAR_2000) !=null && !request.getParameter(LT_EAR_2000).equals("")){
		 avMedicalExamMaMo.setAudioLt2000(new BigDecimal(request.getParameter(LT_EAR_2000)));
	}
	
	if(request.getParameter(RT_EAR_3000) !=null && !request.getParameter(RT_EAR_3000).equals("")){
		 avMedicalExamMaMo.setAudioRt3000(new BigDecimal(request.getParameter(RT_EAR_3000)));
	}
	if(request.getParameter(LT_EAR_3000) !=null && !request.getParameter(LT_EAR_3000).equals("")){
		 avMedicalExamMaMo.setAudioLt3000(new BigDecimal(request.getParameter(LT_EAR_3000)));
	}
	int hinId=0;
	int visitId=0;
	int avica34Id=0;
	if (request.getParameter("avica34Id") != null ) {
		avica34Id  = Integer.parseInt(request.getParameter("avica34Id"));
	}
	if (request.getParameter("hinId") != null ) {
		hinId  = Integer.parseInt(request.getParameter("hinId"));
	}
	if (request.getParameter("visitId") != null ) {
		visitId  = Integer.parseInt(request.getParameter("visitId"));
	}
	if(avica34Id !=0){
		AviCa34 aviCa34=new AviCa34();
		aviCa34.setId(avica34Id);
		avMedicalExamMaMo.setAviCa34(aviCa34);
	}
	if(hinId !=0){
		Patient patient=new Patient();
		patient.setId(hinId);
		avMedicalExamMaMo.setHin(patient);
		}
	if(visitId !=0){
	Visit visit=new Visit();
	visit.setId(visitId);
	avMedicalExamMaMo.setVisit(visit);
	}
	if(hospitalId !=0){
		MasHospital hospital=new MasHospital();
		hospital.setId(hospitalId);
		avMedicalExamMaMo.setHospital(hospital);
	}
	List<String> chargeCodeIdList = new ArrayList<String>();
	List<Integer> quantityList = new ArrayList<Integer>();
	List<Integer> patientInvestigationdetailsIdList = new ArrayList<Integer>();
	List<Integer> dgOrderdtIdList = new ArrayList<Integer>();
	List<String> investigationReferToMHList=new ArrayList<String>();
	List<String> investResultList=new ArrayList<String>();
	String clinicalNotes1="";
			if (request.getParameter("clinicalNotes1") != null
					&& !(request.getParameter("clinicalNotes1").equals(""))) {
				clinicalNotes1 = request.getParameter("clinicalNotes1");
			}

	int hiddenValue = 1;
	String data=null;
	if(request.getParameter("data") != null && !request.getParameter("data").equals(""))
	{
		data=(String)request.getParameter("data");
	}
			if (Integer.parseInt(request.getParameter("hiddenValue")) != 1) {
				hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
			}
			 String deleatedorderid = "";
				if (request.getParameter("deleatedorderid") != "") {
					deleatedorderid = request.getParameter("deleatedorderid");
				}
				infoMap.put("deleatedorderid",deleatedorderid);
				 String deleatedValue = "";
					if (request.getParameter("deleatedValue") != "") {
						deleatedValue = request.getParameter("deleatedValue");
					}
					infoMap.put("deleatedValue",deleatedValue);
//----------------------------------------------------------------------------------------------------
			String dlc="",hb="",tlc="",urinalysis="",xrayChest="";
			int temp = 1;
			String[] chargeCodeIdArr = new String[hiddenValue];
			for (int i = 0; i < hiddenValue; i++) {
				if (request.getParameter("chargeCodeName" + temp) != null
						&& !request.getParameter("chargeCodeName" + temp)
								.equals("")) {
  				String chargeCodeNameWithId = request.getParameter("chargeCodeName" + temp);
					int index1 = chargeCodeNameWithId.lastIndexOf("[");
					int index2 = chargeCodeNameWithId.lastIndexOf("]");
					index1++;
					String chargeCodeName=chargeCodeNameWithId.substring(0,(index1-1));
						
					String chargeCodeId = chargeCodeNameWithId.substring(index1,
							index2);
					if (!chargeCodeId.equals("")) {
						chargeCodeIdArr[i] = chargeCodeId;
						int qty = 1;
						if (request.getParameter("investigationReferToMH" + temp) != null && !request.getParameter("investigationReferToMH" + temp).equals(""))
						{
							investigationReferToMHList.add(request.getParameter("investigationReferToMH" + temp));
							map.put("investigationReferToMHList", investigationReferToMHList);
							
						}else
						{
							investigationReferToMHList.add("n");
						}
						if(data!=null)
						{
						    String resultVal="";
						    
							if (request.getParameter("Result" + temp) != null && !request.getParameter("Result" + temp).equals(""))
							{
							  investResultList.add(request.getParameter("Result" + temp));
							  resultVal=request.getParameter("Result" + temp);
							}else
							{
								investResultList.add(" ");
								resultVal=" ";
							}
						  if(chargeCodeName.equalsIgnoreCase("dlc"))
						  {
							  dlc=resultVal;
						  }else if(chargeCodeName.equalsIgnoreCase("Hb"))
						  {
							  hb=resultVal;
						  }else if(chargeCodeName.equalsIgnoreCase("tlc"))
						  {
							  tlc=resultVal;
						  }else if(chargeCodeName.equalsIgnoreCase("Xray Chest"))
						  {
							  xrayChest=resultVal;
						  }else if(chargeCodeName.equalsIgnoreCase("Urinalysis"))
						  {
							  urinalysis=resultVal;
						
						}
						chargeCodeIdList.add(chargeCodeIdArr[i]);
						quantityList.add(qty);
						//clinicalList.add(clinicalNotes);
					}
					}
					
				}
				if (request.getParameter("patientInvestigationdetailsId" + temp) != null
						&& !request.getParameter("patientInvestigationdetailsId" + temp)
								.equals("")) {
					patientInvestigationdetailsIdList.add(Integer.parseInt(request.getParameter("patientInvestigationdetailsId" + temp)));
				}
				if (request.getParameter("dgOrderdtId" + temp) != null
						&& !request.getParameter("dgOrderdtId" + temp)
								.equals("")) {
					dgOrderdtIdList.add(Integer.parseInt(request.getParameter("dgOrderdtId" + temp)));
				}
				temp++;
			}
			if(data!=null)
			{
			   
				avMedicalExamMaMo.setDlc(dlc);
				avMedicalExamMaMo.setHb(hb);
				avMedicalExamMaMo.setTlc(tlc);
				avMedicalExamMaMo.setUrinalysis(urinalysis);
				avMedicalExamMaMo.setXrayChest(xrayChest);
			
			}
			/*String moName="";
			
			if(user.getEmployee() !=null){
				moName=user.getEmployee().getFirstName();
				if(user.getEmployee().getMiddleName() !=null){
					moName=moName+" "+user.getEmployee().getMiddleName();
				}
				if(user.getEmployee().getLastName() !=null){
					moName=moName+" "+user.getEmployee().getLastName();
				}
			moName=user.getEmployee().getRank().getRankName()+" "+moName;
			avMedicalExamMaMo.setMoName(moName);
			}*/
			 if(request.getParameter("Labresult").equalsIgnoreCase("present")&& data!=null)
				{	
	        	   if(data.equalsIgnoreCase("farwarded")){
	        		   avMedicalExamMaMo.setAvStatus("f");
	        	   } else  if(data.equalsIgnoreCase("validate")){
	        		   avMedicalExamMaMo.setAvStatus("v");
	        		   avMedicalExamMaMo.setMoDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
	        	   } else{
	        		   avMedicalExamMaMo.setAvStatus("p");
	        	   }
	        	   //avMedicalExamMaMo.setModate(new Date());
				}
	          /* else if(!avMedicalExamMaMo.getAvStatus().equalsIgnoreCase("p"))
	            {
					//masMedicalBoardProceedings.setStatus("p");
				}*/
			String investigationDataStatus=null;
			if(request.getParameter("investigationDataStatus") != null ){
				investigationDataStatus=request.getParameter("investigationDataStatus");
			}
	String lastChangedTime = (String) utilMap.get("currentTime");
	infoMap.put("avica34Id",avica34Id);
	infoMap.put("investigationDataStatus",investigationDataStatus);
	infoMap.put("avMedicalExamMaMo", avMedicalExamMaMo);
	infoMap.put("investResultList",investResultList);
	infoMap.put("medExamMaMoId", medExamMaMoId);
	infoMap.put("hinId",hinId);
	infoMap.put("visitId", visitId);
	infoMap.put("patientInvestigationHeaderId", 0);
	infoMap.put("dgOrderhdId", 0);
	infoMap.put("patientInvestigationdetailsIdList", patientInvestigationdetailsIdList);
	infoMap.put("dgOrderdtIdList", dgOrderdtIdList);
	infoMap.put("chargeCodeIdList", chargeCodeIdList);
	infoMap.put("quantityList", quantityList);
	infoMap.put("clinicalNotes1", clinicalNotes1);
	infoMap.put("hospitalId", hospitalId);
	infoMap.put("deptId", deptId);
	infoMap.put("userId",userId);
	infoMap.put("empId",userId);
	infoMap.put("visitId", visitId);
	infoMap.put("data", data);
	infoMap.put("lastChangedTime", lastChangedTime);
	infoMap.put("Labresult", request.getParameter("Labresult"));
	infoMap.put("investigationReferToMHList",investigationReferToMHList);
	
	Boolean successfullyAdded = false;
	successfullyAdded = aviationMedicineHandlerService.updateAviationMA(infoMap);
		message="Record Updated Successfully !!";
		jsp = AV_MESSAGE;
		if (!successfullyAdded) {
			message = "Some Problem Occured !!!";
			jsp = AV_MESSAGE;
		}else if(data!=null)
		{if(request.getParameter("Labresult").equalsIgnoreCase("NotPresent"))
		{
			message = "Lab Result is not Found ! You Can Forward to Medical Officer After Lab Result.";

		}else{
			message = "Record  Forwarded Successfully !!";	
		}		
		}
	
	}else
	{
	message = "You can forward to Medical Officer only after entering Investigation Reports";
	jsp = AV_MESSAGE;
	}
	
	/*try {
		//	map = medicalExaminationBoardHandlerService.showMedicalExaminationBoardJsp();
	} catch (Exception e) {
		e.printStackTrace();
	}*/
	jsp += ".jsp";
	
	map.put("contentJsp", jsp);
	map.put("message", message);
	return new ModelAndView("indexB", "map", map);
}

public void fillItemsForLicenceNo(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	String licenceNo = "";
	int cnt=0;
	List<AviCa34> aviCa34List = new ArrayList<AviCa34>();
	try {
		if (request.getParameter(LICENCE_NO) != null) {
			licenceNo = request.getParameter(LICENCE_NO);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	dataMap.put("licenceNo", licenceNo);

	map = aviationMedicineHandlerService.fillItemsForLicenceNo(dataMap);
	if (map.get("aviCa34List") != null) {
		aviCa34List = (List) map.get("aviCa34List");
	}
	String lastName="";
	StringBuffer sb = new StringBuffer();
	sb.append("<items>");
	for (AviCa34 aviCa34 : aviCa34List) {
		sb.append("<item>");
		sb.append("<avic34Id>" + aviCa34.getId() + "</avic34Id>");
		if(aviCa34.getLastName() !=null){
			lastName=aviCa34.getLastName() ;
		}
		sb.append("<name>" + (aviCa34.getFirstName()+" "+lastName) + "</name>");
		if(aviCa34.getAppointmentDate() !=null){
		sb.append("<appointmentDate>"+ (HMSUtil.changeDateToddMMyyyy(aviCa34.getAppointmentDate()))
				+ "</appointmentDate>");
		}else{
			sb.append("<appointmentDate>"+""+ "</appointmentDate>");	
		}
		if(aviCa34.getMedExamDate() !=null){
		sb.append("<examinationDate>"+ (HMSUtil.changeDateToddMMyyyy(aviCa34.getMedExamDate()))
				+ "</examinationDate>");}else{
					sb.append("<examinationDate>"+""+ "</examinationDate>");	
				}
		
		
		if(aviCa34.getPmrReceivedDate() !=null){
			sb.append("<receivedDate>"+ (HMSUtil.changeDateToddMMyyyy(aviCa34.getPmrReceivedDate()))
					+ "</receivedDate>");}else{
						sb.append("<receivedDate>"+""+ "</receivedDate>");	
					}
		
		
		if(aviCa34.getPmrReceiveBy() !=null){
			String recName="";
			recName=aviCa34.getPmrReceiveBy().getFirstName();
			if(aviCa34.getPmrReceiveBy().getLastName() !=null){
				recName=recName+" "+aviCa34.getPmrReceiveBy().getLastName();
			}
			if(aviCa34.getPmrReceiveBy().getRank() !=null){
				recName=recName+" "+aviCa34.getPmrReceiveBy().getRank();
			}
			sb.append("<receivedBy>"+ recName + "</receivedBy>");}else{
						sb.append("<receivedBy>"+""+ "</receivedBy>");	
					}
		
		
		if(aviCa34.getPmrDispatchDate() !=null){
			sb.append("<dispatchDate>"+ (HMSUtil.changeDateToddMMyyyy(aviCa34.getPmrDispatchDate()))
					+ "</dispatchDate>");}else{
						sb.append("<dispatchDate>"+""+ "</dispatchDate>");	
					}
		if(aviCa34.getPmrDispatchBy() !=null){
			String dispatchByName="";
			dispatchByName=aviCa34.getPmrDispatchBy().getFirstName();
			if(aviCa34.getPmrDispatchBy().getLastName() !=null){
				dispatchByName=dispatchByName+" "+aviCa34.getPmrDispatchBy().getLastName();
			}
			if(aviCa34.getPmrDispatchBy().getRank() !=null){
				dispatchByName=dispatchByName+" "+aviCa34.getPmrDispatchBy().getRank();
			}
			sb.append("<dispatchedBy>"+ dispatchByName + "</dispatchedBy>");}else{
						sb.append("<dispatchedBy>"+""+ "</dispatchedBy>");	
					}
		
		
		if(aviCa34.getPmrRemarks() !=null){
			sb.append("<remarks>"+aviCa34.getPmrRemarks()
					+ "</remarks>");}else{
						sb.append("<remarks>"+""+ "</remarks>");	
					}
		sb.append("</item>");
	}
	sb.append("</items>");
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

public ModelAndView submitPMRFileTracking(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> parameterMap = new HashMap<String, Object>();
	Box box = HMSUtil.getBox(request);
	int hospitalId = 0;
	String userName = "";
	HttpSession session = request.getSession();
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		parameterMap.put("hospitalId", hospitalId);
	}
	if (session.getAttribute(LOGIN_NAME) != null) {
		userName = (String) session.getAttribute(LOGIN_NAME);
		parameterMap.put("userName", userName);
	}
	parameterMap.put("box", box);
	boolean successfullyUpdated = false;
	successfullyUpdated = aviationMedicineHandlerService.submitPMRFileTracking(parameterMap);
	String message = "";
	if (successfullyUpdated) {
		message = "Done Successfully !!";
	} else {
		message = "Some Problem Occured !! Try Again ..";
	}
	String url="";
	url="/hms/hms/aviationMedicine?method=showPMRFileTrackingJsp";
	String jsp = AV_MESSAGE + ".jsp";
	map.put("url", url);
	map.put("message", message);
	map.put("contentJsp", jsp);
	return new ModelAndView("indexB", "map", map);
}
public ModelAndView getDetailAfterSearch(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> mapForDs = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	String searchLicenceNo="";
	String searchName="";
	Date searchExamDate=null;
	Date searchAppointDate=null;
	Box box = HMSUtil.getBox(request);
	session.setAttribute("box", box);
	session = request.getSession();
	if (request.getParameter("searchLicenceNo") != null && !(request.getParameter("searchLicenceNo").equals(""))) {
		searchLicenceNo = request.getParameter("searchLicenceNo");
		mapForDs.put("searchLicenceNo", searchLicenceNo);
	}
	if (request.getParameter("searchName") != null && !(request.getParameter("searchName").equals(""))) {
		searchName =request.getParameter("searchName");
		mapForDs.put("searchName", searchName);
	}
	if (request.getParameter("searchExamDate") != null && !(request.getParameter("searchExamDate").equals(""))) {
		searchExamDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("searchExamDate"));
		mapForDs.put("searchExamDate", searchExamDate);
	}
	if (request.getParameter("searchAppointDate") != null && !(request.getParameter("searchAppointDate").equals(""))) {
		searchAppointDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("searchAppointDate"));
		mapForDs.put("searchAppointDate", searchAppointDate);
	}
	String jsp = "av_responsePMR";
	map = aviationMedicineHandlerService.getDetailAfterSearch(mapForDs);
	return new ModelAndView(jsp, "map", map);

}
public ModelAndView showPaymentStatusJsp(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	map=aviationMedicineHandlerService.showPaymentStatusJsp();
	jsp = "av_paymentStatusJsp.jsp";

	title = "Payment Status Report Jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}
//----Aviation---Accident (28-march-2012) By Dipali
public ModelAndView submitAviationAccidentEntry(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	infoMap.put("box", box);
	String url="";
	String message="";
	AvAccident avAccident = new AvAccident();
	
	if (session.getAttribute(HOSPITAL_ID) != null) 
	{
		MasHospital masHospital=new MasHospital();
		masHospital.setId((Integer)session.getAttribute(HOSPITAL_ID));
		avAccident.setHospital(masHospital);
		
	}
	if (session.getAttribute("deptId") != null) 
	{
		MasDepartment masDept=new MasDepartment();
		masDept.setId((Integer)session.getAttribute("deptId"));
		avAccident.setDepartment(masDept);
		
	}
	if(request.getParameter(DATE) !=null && !request.getParameter(DATE).equals("")){
		avAccident.setDetailDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE)));
	}
	if(request.getParameter(TIME) !=null && !request.getParameter(TIME).equals("")){
		avAccident.setDetailTime(request.getParameter(TIME));
	}
	if(request.getParameter(PLACE) !=null && !request.getParameter(PLACE).equals("")){
		avAccident.setPlace(request.getParameter(PLACE));
	}
	if(request.getParameter(MARK) !=null && !request.getParameter(MARK).equals("")){
		avAccident.setMark(request.getParameter(MARK));
	}
	if(request.getParameter("purposeOfFlight") !=null && !request.getParameter("purposeOfFlight").equals("")){
		avAccident.setFlightPurpose(request.getParameter("purposeOfFlight"));
	}
	if(request.getParameter(UNIT_ID) !=null && !request.getParameter(UNIT_ID).equals("0")){
		MasUnit masUnit=new MasUnit();
		masUnit.setId(Integer.parseInt(request.getParameter(UNIT_ID)));
		avAccident.setUnit(masUnit);
	}
	if(request.getParameter(AIRCRAFT_TYPE) !=null && !request.getParameter(AIRCRAFT_TYPE).equals("0")){
		MasAircraftType aircraftType=new MasAircraftType();
		aircraftType.setId(Integer.parseInt(request.getParameter(AIRCRAFT_TYPE)));
		avAccident.setAircrftType(aircraftType);
	}
	if(request.getParameter(SERIAL_NO) !=null && !request.getParameter(SERIAL_NO).equals("")){
		avAccident.setSerialNumber(request.getParameter(SERIAL_NO));
	}
	
	if(request.getParameter("numberAccident") !=null && !request.getParameter("numberAccident").equals("")){
		avAccident.setNumberAccident(request.getParameter("numberAccident"));
	}
	if(request.getParameter("numberCasualties") !=null && !request.getParameter("numberCasualties").equals("")){
		avAccident.setNumberCasualties(request.getParameter("numberCasualties"));
	}
	if(request.getParameter("numberOtherEnclosurses") !=null && !request.getParameter("numberOtherEnclosurses").equals("")){
		avAccident.setNumberOtherEnclosurses(request.getParameter("numberOtherEnclosurses"));
	}
	if(request.getParameter("escapeInFlight") !=null && !request.getParameter("escapeInFlight").equals("")){
		avAccident.setEscapeFlight(request.getParameter("escapeInFlight"));
	}
	if(request.getParameter("circumstanceAccident") !=null && !request.getParameter("circumstanceAccident").equals("")){
		avAccident.setAccidentCircumstances1(request.getParameter("circumstanceAccident"));
	}
	if(request.getParameter("circumstanceAccidentOne") !=null && !request.getParameter("circumstanceAccidentOne").equals("")){
		avAccident.setAccidentCircumstances2(request.getParameter("circumstanceAccidentOne"));
	}
	if(request.getParameter("majorStructuralFailure") !=null && !request.getParameter("majorStructuralFailure").equals("")){
		avAccident.setMajorStructuralFailure(request.getParameter("majorStructuralFailure"));
	}
	if(request.getParameter("lossControl") !=null && !request.getParameter("lossControl").equals("")){
		avAccident.setLossControl(request.getParameter("lossControl"));
	}
	if(request.getParameter("lossPower") !=null && !request.getParameter("lossPower").equals("")){
		avAccident.setLossPower(request.getParameter("lossPower"));
	}
	if(request.getParameter("lossService") !=null && !request.getParameter("lossService").equals("")){
		avAccident.setLossService(request.getParameter("lossService"));
	}
	if(request.getParameter("instruments") !=null && !request.getParameter("instruments").equals("")){
		avAccident.setRadioOther(request.getParameter("instruments"));
	}
	String enemyAction="";
	if(request.getParameter("enemyAction") !=null && !request.getParameter("enemyAction").equals("")){
		enemyAction="y";
	}else{
		enemyAction="n";
	}
	avAccident.setEnemyAction(enemyAction);
	if(request.getParameter("otherCircumstanceSpecify") !=null && !request.getParameter("otherCircumstanceSpecify").equals("")){
		avAccident.setOtherCircumstances(request.getParameter("otherCircumstanceSpecify"));
	}
	if(request.getParameter("operatingConditions") !=null && !request.getParameter("operatingConditions").equals("")){
		avAccident.setOperatingCondition1(request.getParameter("operatingConditions"));
	}
	if(request.getParameter("operatingConditionsOne") !=null && !request.getParameter("operatingConditionsOne").equals("")){
		avAccident.setOperatingCondition2(request.getParameter("operatingConditionsOne"));
	}
	if(request.getParameter("undergroundControl") !=null && !request.getParameter("undergroundControl").equals("")){
		avAccident.setUndergroundControl(request.getParameter("undergroundControl"));
	}
	if(request.getParameter("intenderedForSortie") !=null && !request.getParameter("intenderedForSortie").equals("")){
		avAccident.setIntenderedSortie(request.getParameter("intenderedForSortie"));
	}
	if(request.getParameter("atTimeOfEmergency") !=null && !request.getParameter("atTimeOfEmergency").equals("")){
		avAccident.setIntenderedSortieEmergency(request.getParameter("atTimeOfEmergency"));
	}
	if (request.getParameter(LAST_CHANGED_BY) != null)
	{	avAccident.setLastChgBy(request.getParameter(LAST_CHANGED_BY));
	}
	if (request.getParameter(LAST_CHANGED_DATE) != null)
	{
		avAccident.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(LAST_CHANGED_DATE)));
	}
	if (request.getParameter(LAST_CHANGED_TIME) != null)
	{	avAccident.setLastChgTime(request.getParameter(LAST_CHANGED_TIME));
	}
	String flag="";
	if(request.getParameter("flag") !=null && !request.getParameter("flag").equals("")){
		flag=request.getParameter("flag");
	}
	infoMap.put("avAccident", avAccident);
	boolean saved = false;
	int avAccidentId=0;
	map = aviationMedicineHandlerService.submitAviationAccidentEntry(infoMap);
	if (map.get("saved") != null) {
		saved = (Boolean) map.get("saved");
	}
	if (saved) {
		message = "Data saved Successfully !!";
	} else {
		message = "Try Again!";
	}
	if(map.get("avAccidentId") !=null){
		avAccidentId=(Integer)map.get("avAccidentId");
	}
	
	map.put("message", message);
	url = "/hms/hms/aviationMedicine?method=showAccidentInvestigationJsp";
	jsp = AV_MESSAGE + ".jsp";
	map.put("avAccidentId",avAccidentId);
	map.put("flag", flag);
	map.put("url", url);
	map.put("message", message);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
public ModelAndView submitEquipmentFactors(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	infoMap.put("box", box);
	String url="";
	String message="";
	AvAccident avAccident = new AvAccident();
	int avAccidentId=0;
	if(request.getParameter("avAccidentId") !=null && !request.getParameter("avAccidentId").equals("")){
		avAccidentId=Integer.parseInt(request.getParameter("avAccidentId"));
	avAccident = aviationMedicineHandlerService.loadAviationAccident(avAccidentId);
	}
	if (session.getAttribute(HOSPITAL_ID) != null) 
	{
		MasHospital masHospital=new MasHospital();
		masHospital.setId((Integer)session.getAttribute(HOSPITAL_ID));
		avAccident.setHospital(masHospital);
		
	}
	if (session.getAttribute("deptId") != null) 
	{
		MasDepartment masDept=new MasDepartment();
		masDept.setId((Integer)session.getAttribute("deptId"));
		avAccident.setDepartment(masDept);
		
	}
	//-----------For Person Detail--Block--
	if(request.getParameter(SERVICE_NO) !=null && !request.getParameter(SERVICE_NO).equals("")){
		avAccident.setServiceNo(request.getParameter(SERVICE_NO));
	}
	if(request.getParameter(FIRST_NAME) !=null && !request.getParameter(FIRST_NAME).equals("")){
		avAccident.setFirstName(request.getParameter(FIRST_NAME));
	}
	if(request.getParameter("surname") !=null && !request.getParameter("surname").equals("")){
		avAccident.setSurname(request.getParameter("surname"));
	}
	if(request.getParameter("crewDuty") !=null && !request.getParameter("crewDuty").equals("")){
		avAccident.setCrewDuty(request.getParameter("crewDuty"));
	}
	if(request.getParameter("hinId") !=null && !request.getParameter("hinId").equals("")){
		Patient patient=new Patient();
		patient.setId(Integer.parseInt(request.getParameter("hinId")));
		avAccident.setHin(patient);
	}
	if(request.getParameter(RANK_ID) !=null && !request.getParameter(RANK_ID).equals("0")){
		MasRank masRank=new MasRank();
		masRank.setId(Integer.parseInt(request.getParameter(RANK_ID)));
		avAccident.setRank(masRank);
	}
	
	infoMap.put("avAccidentId",avAccidentId);
	//---For Part I - Equipment in Use Block----
	if(request.getParameter(UNINJURED) !=null && !request.getParameter(UNINJURED).equals("")){
		avAccident.setUninjured(request.getParameter(UNINJURED));
	}
	if(request.getParameter(INJURED_FATAL) !=null && !request.getParameter(INJURED_FATAL).equals("")){
		avAccident.setInjuredFatal(request.getParameter(INJURED_FATAL));
	}
	if(request.getParameter(MISSING) !=null && !request.getParameter(MISSING).equals("")){
		avAccident.setMissing(request.getParameter(MISSING));
	}
	if(request.getParameter(GROUND_IMPACT_AIRCRAFT) !=null && !request.getParameter(GROUND_IMPACT_AIRCRAFT).equals("")){
		avAccident.setGroundImpactAircraft(request.getParameter(GROUND_IMPACT_AIRCRAFT));
	}
	if(request.getParameter(DISPLACEMENT_CASUALTY) !=null && !request.getParameter(DISPLACEMENT_CASUALTY).equals("")){
		avAccident.setDisplacementCasualty(request.getParameter(DISPLACEMENT_CASUALTY));
	}
	if(request.getParameter(IF_OTHER1) !=null && !request.getParameter(IF_OTHER1).equals("")){
		avAccident.setIfOther1(request.getParameter(IF_OTHER1));
	}
	if(request.getParameter(IF_OTHER2) !=null && !request.getParameter(IF_OTHER2).equals("")){
		avAccident.setIfOther2(request.getParameter(IF_OTHER2));
	}
	//--For seat block
	
	if(request.getParameter(SEAT_FACING) !=null && !request.getParameter(SEAT_FACING).equals("")){
		avAccident.setSeatFacing(request.getParameter(SEAT_FACING));
	}
	if(request.getParameter(SEAT_CONDITION) !=null && !request.getParameter(SEAT_CONDITION).equals("")){
		avAccident.setSeatCondition(request.getParameter(SEAT_CONDITION));
	}
	//----For----HEARNESS block---
	if(request.getParameter(HEAR_TYPE) !=null && !request.getParameter(HEAR_TYPE).equals("")){
		avAccident.setHearnessType(request.getParameter(HEAR_TYPE));
	}
	if(request.getParameter("hearTypeOther") !=null && !request.getParameter("hearTypeOther").equals("")){
		avAccident.setHearTypeOther(request.getParameter("hearTypeOther"));
	}
	if(request.getParameter(HEAR_ADJUSTMENT) !=null && !request.getParameter(HEAR_ADJUSTMENT).equals("")){
		avAccident.setHearAdjustments(request.getParameter(HEAR_ADJUSTMENT));
	}
	if(request.getParameter("releaseBox") !=null && !request.getParameter("releaseBox").equals("")){
		avAccident.setHearRelaxBox(request.getParameter("releaseBox"));
	}
	if(request.getParameter("effectiveness") !=null && !request.getParameter("effectiveness").equals("")){
		avAccident.setHearEffectiveness(request.getParameter("effectiveness"));
	}
	if(request.getParameter("causeOfFailure") !=null && !request.getParameter("causeOfFailure").equals("")){
		avAccident.setHearCauseFailure(request.getParameter("causeOfFailure"));
	}
	//----For --ESCAPE APPARATUS
	if(request.getParameter("typeEscape") !=null && !request.getParameter("typeEscape").equals("")){
		avAccident.setEscapeType(request.getParameter("typeEscape"));
	}
	if(request.getParameter("stowing") !=null && !request.getParameter("stowing").equals("")){
		avAccident.setEscapStowing(request.getParameter("stowing"));
	}
	if(request.getParameter("use") !=null && !request.getParameter("use").equals("")){
		avAccident.setEscapUse(request.getParameter("use"));
	}
	//----OXYGEN --Block------
	//---For mask---
	if(request.getParameter("maskMark") !=null && !request.getParameter("maskMark").equals("")){
		avAccident.setOxygenMask(request.getParameter("maskMark"));
	}
	if(request.getParameter("maskSize") !=null && !request.getParameter("maskSize").equals("")){
		avAccident.setOxygenSize(request.getParameter("maskSize"));
	}
	//----For===--Regulater----
	if(request.getParameter("regulaterMark") !=null && !request.getParameter("regulaterMark").equals("")){
		avAccident.setRegulaterMark(request.getParameter("regulaterMark"));
	}
	if(request.getParameter("regulaterSetting") !=null && !request.getParameter("regulaterSetting").equals("")){
		avAccident.setRegulaterSetting(request.getParameter("regulaterSetting"));
	}
	if(request.getParameter("notProived") !=null && !request.getParameter("notProived").equals("")){
		avAccident.setRegulaterNotProvide(request.getParameter("notProived"));
	}
	if(request.getParameter("emergencyPortableEquipment") !=null && 
						!request.getParameter("emergencyPortableEquipment").equals("")){
		avAccident.setEmergencyPortableEquipment(request.getParameter("emergencyPortableEquipment"));
	}
	if(request.getParameter("outerClothing") !=null && !request.getParameter("outerClothing").equals("")){
		avAccident.setOuterClothing(request.getParameter("outerClothing"));
	}
	if(request.getParameter("outerClothingDamaged") !=null && !request.getParameter("outerClothingDamaged").equals("")){
		avAccident.setOuterTypeOther(request.getParameter("outerClothingDamaged"));
	}
	//---------For PROTECTIVE HELMET block------
	if(request.getParameter("protectiveHelmetMark") !=null && !request.getParameter("protectiveHelmetMark").equals("")){
		avAccident.setHelmetMark(request.getParameter("protectiveHelmetMark"));
	}
	if(request.getParameter("escapeImpact") !=null && !request.getParameter("escapeImpact").equals("")){
		avAccident.setHelmetEscapeImpact(request.getParameter("escapeImpact"));
	}
	if(request.getParameter("chinStep") !=null && !request.getParameter("chinStep").equals("")){
		avAccident.setHelmetChinStep(request.getParameter("chinStep"));
	}
	if(request.getParameter("innerHelmet") !=null && !request.getParameter("innerHelmet").equals("")){
		avAccident.setHelmetInner(request.getParameter("innerHelmet"));
	}
	if(request.getParameter("outerHelmet") !=null && !request.getParameter("outerHelmet").equals("")){
		avAccident.setHelmetOuter(request.getParameter("outerHelmet"));
	}
	if(request.getParameter("markVizor") !=null && !request.getParameter("markVizor").equals("")){
		avAccident.setHelmetVizorMark(request.getParameter("markVizor"));
	}
	if(request.getParameter("commentHelmet") !=null && !request.getParameter("commentHelmet").equals("")){
		avAccident.setHelmetComment(request.getParameter("commentHelmet"));
	}
//------For ---PRESSURE CLOTHING---block---	
	if(request.getParameter("partialPressuresuit") !=null && !request.getParameter("partialPressuresuit").equals("")){
		avAccident.setClothingPressuresuit(request.getParameter("partialPressuresuit"));
	}
	if(request.getParameter("markPressuresuit") !=null && !request.getParameter("markPressuresuit").equals("")){
		avAccident.setClothingPressuresuitMark(request.getParameter("markPressuresuit"));
	}
	if(request.getParameter("jerkin") !=null && !request.getParameter("jerkin").equals("")){
		avAccident.setClothingJerkin(request.getParameter("jerkin"));
	}
	if(request.getParameter("markJerkin") !=null && !request.getParameter("markJerkin").equals("")){
		avAccident.setClothingJerkinMark(request.getParameter("markJerkin"));
	}
	if(request.getParameter("fullPressureSuit") !=null && !request.getParameter("fullPressureSuit").equals("")){
		avAccident.setClothingFullSuit(request.getParameter("fullPressureSuit"));
	}
	if(request.getParameter("markFullPressureSuit") !=null && !request.getParameter("markFullPressureSuit").equals("")){
		avAccident.setClothingFullSuitMark(request.getParameter("markFullPressureSuit"));
	}
	if(request.getParameter("antiGSuit") !=null && !request.getParameter("antiGSuit").equals("")){
		avAccident.setClothingAntiG(request.getParameter("antiGSuit"));
	}
	if(request.getParameter("markAntiGSuit") !=null && !request.getParameter("markAntiGSuit").equals("")){
		avAccident.setClothingAntiGMark(request.getParameter("markAntiGSuit"));
	}
	if(request.getParameter("specifyFunction") !=null && !request.getParameter("specifyFunction").equals("")){
		avAccident.setClothingReleventAccident(request.getParameter("specifyFunction"));
	}
	//---For---OTHER EQUIPMENT----
	if(request.getParameter("airVentilatedSuit") !=null && !request.getParameter("airVentilatedSuit").equals("")){
		avAccident.setEquipVentilated(request.getParameter("airVentilatedSuit"));
	}
	if(request.getParameter("markAirVentilated") !=null && !request.getParameter("markAirVentilated").equals("")){
		avAccident.setEquipVentilatedMark(request.getParameter("markAirVentilated"));
	}
	if(request.getParameter("lifeJacket") !=null && !request.getParameter("lifeJacket").equals("")){
		avAccident.setEquipLifeJacket(request.getParameter("lifeJacket"));
	}
	if(request.getParameter("markLifeJacket") !=null && !request.getParameter("markLifeJacket").equals("")){
		avAccident.setEquipLifeJacketMark(request.getParameter("markLifeJacket"));
	}
	if(request.getParameter("dinghy") !=null && !request.getParameter("antiGSuit").equals("")){
		avAccident.setEquipDinghy(request.getParameter("dinghy"));
	}
	if(request.getParameter("markDinghy") !=null && !request.getParameter("markDinghy").equals("")){
		avAccident.setEquipDinghyMark(request.getParameter("markDinghy"));
	}
	if(request.getParameter("survivalPacks") !=null && !request.getParameter("survivalPacks").equals("")){
		avAccident.setEquipSurvivalPacks(request.getParameter("survivalPacks"));
	}
	if(request.getParameter("typeSurvivalPacks") !=null && !request.getParameter("typeSurvivalPacks").equals("")){
		avAccident.setEquipType(request.getParameter("typeSurvivalPacks"));
	}
	//--------------Part I - Medical History---Block-----
	
	String age = "";
	if (request.getParameter(SR_AGE) != null) {
		if (request.getParameter(SR_AGE_UNIT) != null) {
			String ageUnit = request.getParameter(SR_AGE_UNIT);
			age = request.getParameter(SR_AGE).concat(" ").concat(ageUnit);
			avAccident.setAge(age);
		}
	}
	if(request.getParameter(HEIGHT) !=null && !request.getParameter(HEIGHT).equals("")){
		avAccident.setHeight(new BigDecimal(request.getParameter(HEIGHT)));
	}
	if(request.getParameter(WEIGHT) !=null && !request.getParameter(WEIGHT).equals("")){
		avAccident.setWeight(new BigDecimal(request.getParameter(WEIGHT)));
	}
	if (request.getParameter(MARITAL_STATUS_ID) != null && !request.getParameter(MARITAL_STATUS_ID).equals("0")) {
		int maritalStatusId = Integer.parseInt(request
				.getParameter(MARITAL_STATUS_ID));
		MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
		masMaritalStatus.setId(maritalStatusId);
		avAccident.setMaritalStatus(masMaritalStatus);
	}
	if(request.getParameter("medicalCategory") !=null && !request.getParameter("medicalCategory").equals("0")){
		Category category=new Category();
		category.setCategoryid(Integer.parseInt(request.getParameter("medicalCategory")));
		avAccident.setMedicalCategory(category);
	}
	if(request.getParameter(DATE_OF_MB) !=null && !request.getParameter(DATE_OF_MB).equals("")){
		avAccident.setMedicalDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE_OF_MB)));
	}
	if(request.getParameter("reason") !=null && !request.getParameter("reason").equals("")){
		avAccident.setMedicalReason(request.getParameter("reason"));
	}
	if(request.getParameter(MEDICAL_CONDITION) !=null && !request.getParameter(MEDICAL_CONDITION).equals("")){
		avAccident.setMedicalCondition(request.getParameter(MEDICAL_CONDITION));
	}
	if(request.getParameter(REASON_MEDICAL_CONDITION) !=null && !request.getParameter(REASON_MEDICAL_CONDITION).equals("")){
		avAccident.setMedicalConditionReson(request.getParameter(REASON_MEDICAL_CONDITION));
	}
	if(request.getParameter("medication") !=null && !request.getParameter("medication").equals("")){
		avAccident.setMedication(request.getParameter("medication"));
	}
	if(request.getParameter("bodyBuild") !=null && !request.getParameter("bodyBuild").equals("")){
		avAccident.setBodyBuild(request.getParameter("bodyBuild"));
	}
	if(request.getParameter("alcohol") !=null && !request.getParameter("alcohol").equals("")){
		avAccident.setAlcohol(request.getParameter("alcohol"));
	}
	if(request.getParameter("tobacco") !=null && !request.getParameter("tobacco").equals("")){
		avAccident.setTobacco(request.getParameter("tobacco"));
	}
	if(request.getParameter("tobaccoTxt") !=null && !request.getParameter("tobaccoTxt").equals("")){
		avAccident.setPerDay(request.getParameter("tobaccoTxt"));
	}
	//---For----Part III - Physiological And Psychological Factors Block
	if(request.getParameter("employment") !=null && !request.getParameter("employment").equals("")){
		avAccident.setEmployment(request.getParameter("employment"));
	}
	if(request.getParameter("extraQualifications") !=null && !request.getParameter("extraQualifications").equals("")){
		avAccident.setExtraQualifications(request.getParameter("extraQualifications"));
	}
	if(request.getParameter(DATE_RENEWAL) !=null && !request.getParameter(DATE_RENEWAL).equals("")){
		avAccident.setRenewalDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE_RENEWAL)));
	}
	//-For --FLYING TIME---block------
	if(request.getParameter("24FlyingfirstPilot") !=null && !request.getParameter("24FlyingfirstPilot").equals("")){
		avAccident.setFly241pilot(request.getParameter("24FlyingfirstPilot"));
	}
	if(request.getParameter("24FlyingSecPilot") !=null && !request.getParameter("24FlyingSecPilot").equals("")){
		avAccident.setFly242pilot(request.getParameter("24FlyingSecPilot"));
	}
	if(request.getParameter("24FlyingCrew") !=null && !request.getParameter("24FlyingCrew").equals("")){
		avAccident.setFly24Crew(request.getParameter("24FlyingCrew"));
	}
	if(request.getParameter("24FlyingType") !=null && !request.getParameter("24FlyingType").equals("")){
		avAccident.setFly24Type(request.getParameter("24FlyingType"));
	}
	if(request.getParameter("30FlyingfirstPilot") !=null && !request.getParameter("30FlyingfirstPilot").equals("")){
		avAccident.setFly301pilot(request.getParameter("30FlyingfirstPilot"));
	}
	if(request.getParameter("30FlyingSecPilot") !=null && !request.getParameter("30FlyingSecPilot").equals("")){
		avAccident.setFly302pilot(request.getParameter("30FlyingSecPilot"));
	}
	if(request.getParameter("30FlyingCrew") !=null && !request.getParameter("30FlyingCrew").equals("")){
		avAccident.setFly30Crew(request.getParameter("30FlyingCrew"));
	}
	if(request.getParameter("30FlyingType") !=null && !request.getParameter("30FlyingType").equals("")){
		avAccident.setFly30Type(request.getParameter("30FlyingType"));
	}
	if(request.getParameter("flyingfirstPilot") !=null && !request.getParameter("flyingfirstPilot").equals("")){
		avAccident.setFlyPosted1pilot(request.getParameter("flyingfirstPilot"));
	}
	if(request.getParameter("flyingSecPilot") !=null && !request.getParameter("flyingSecPilot").equals("")){
		avAccident.setFlyPosted2pilot(request.getParameter("flyingSecPilot"));
	}
	if(request.getParameter("flyingCrew") !=null && !request.getParameter("flyingCrew").equals("")){
		avAccident.setFlyPostedCrew(request.getParameter("flyingCrew"));
	}
	if(request.getParameter("flyingType") !=null && !request.getParameter("flyingType").equals("")){
		avAccident.setFlyPostedType(request.getParameter("flyingType"));
	}
	//-----------------For PRESENT POSTING--block------
	if(request.getParameter("flownfirstPilot") !=null && !request.getParameter("flownfirstPilot").equals("")){
		avAccident.setFlyOther1pilot(request.getParameter("flownfirstPilot"));
	}
	if(request.getParameter("flownSecPilot") !=null && !request.getParameter("flownSecPilot").equals("")){
		avAccident.setFlyOther2pilot(request.getParameter("flownSecPilot"));
	}
	if(request.getParameter("flownCrew") !=null && !request.getParameter("flownCrew").equals("")){
		avAccident.setFlyOtherCrew(request.getParameter("flownCrew"));
	}
	if(request.getParameter("flownType") !=null && !request.getParameter("flownType").equals("")){
		avAccident.setFlyOtherType(request.getParameter("flownType"));
	}
	
	//-------For --PRESENT POSTING---Block----------
	if(request.getParameter("lengthTimeStation") !=null && !request.getParameter("lengthTimeStation").equals("")){
		avAccident.setLengthTimeStation(request.getParameter("lengthTimeStation"));
	}
	if(request.getParameter("months") !=null && !request.getParameter("months").equals("")){
		avAccident.setLengthTimeMonth(request.getParameter("months"));
	}
	if(request.getParameter("accommodationStation") !=null && !request.getParameter("accommodationStation").equals("")){
		avAccident.setAccommodationStation(request.getParameter("accommodationStation"));
	}
	if(request.getParameter("typeAccommodation") !=null && !request.getParameter("typeAccommodation").equals("")){
		avAccident.setTypeAccommodation(request.getParameter("typeAccommodation"));
	}
	if(request.getParameter("assessmentFlying") !=null && !request.getParameter("assessmentFlying").equals("")){
		avAccident.setCurrnetFlyingAassessmen(request.getParameter("assessmentFlying"));
	}
	if(request.getParameter("relevantRemarks") !=null && !request.getParameter("relevantRemarks").equals("")){
		avAccident.setReleventRemarks(request.getParameter("relevantRemarks"));
	}
	//----For-----PREVIOUS ACCDIENT HISTORY-----------
	if(request.getParameter("aircraftAccident") !=null && !request.getParameter("aircraftAccident").equals("")){
		avAccident.setAircraftAccident(request.getParameter("aircraftAccident"));
	}
	if(request.getParameter("aircraftDescription") !=null && !request.getParameter("aircraftDescription").equals("")){
		avAccident.setAirAccidentDescription(request.getParameter("aircraftDescription"));
	}
	if(request.getParameter(DATE_TWO) !=null && !request.getParameter(DATE_TWO).equals("")){
		avAccident.setAirAccDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE_TWO)));
	}
	if(request.getParameter("severity") !=null && !request.getParameter("severity").equals("")){
		avAccident.setAirAccSeverity(request.getParameter("severity"));
	}
	if(request.getParameter("responsibility") !=null && !request.getParameter("responsibility").equals("")){
		avAccident.setResponsibility(request.getParameter("responsibility"));
	}
	if(request.getParameter("motoringAccident") !=null && !request.getParameter("motoringAccident").equals("")){
		avAccident.setMotoringAccident(request.getParameter("motoringAccident"));
	}
	
	if(request.getParameter("otherAccident") !=null && !request.getParameter("otherAccident").equals("")){
		avAccident.setOtherAccidentInvolve(request.getParameter("otherAccident"));
	}
	//-----For-FATIGUE------Block-------
	if(request.getParameter("timeControlsFlight") !=null && !request.getParameter("timeControlsFlight").equals("")){
		avAccident.setTimeControls(request.getParameter("timeControlsFlight"));
	}
	if(request.getParameter("noTakeOffs") !=null && !request.getParameter("noTakeOffs").equals("")){
		avAccident.setNoTakeLanding(request.getParameter("noTakeOffs"));
	}
	if(request.getParameter("noOfSorties") !=null && !request.getParameter("noOfSorties").equals("")){
		avAccident.setNoLast24hrs(request.getParameter("noOfSorties"));
	}
	if(request.getParameter("7days") !=null && !request.getParameter("7days").equals("")){
		avAccident.setNoLast7days(request.getParameter("7days"));
	}
	if(request.getParameter("noOfSorties24") !=null && !request.getParameter("noOfSorties24").equals("")){
		avAccident.setNoDuty24hrs(request.getParameter("noOfSorties24"));
	}
	if(request.getParameter("amountOfSleep") !=null && !request.getParameter("amountOfSleep").equals("")){
		avAccident.setAmountSleep(request.getParameter("amountOfSleep"));
	}
	if(request.getParameter("amount") !=null && !request.getParameter("amount").equals("")){
		avAccident.setAmountSleepHrs(request.getParameter("amount"));
	}
	if(request.getParameter("recentFactors") !=null && !request.getParameter("recentFactors").equals("")){
		avAccident.setLiableIncreaseFatigue(request.getParameter("recentFactors"));
	}
	if(request.getParameter("recentOtherFactors") !=null && !request.getParameter("recentOtherFactors").equals("")){
		avAccident.setLiableIncreaseOther(request.getParameter("recentOtherFactors"));
	}
	if(request.getParameter("amountOfLeave") !=null && !request.getParameter("amountOfLeave").equals("")){
		avAccident.setAmountLeaveTaken(request.getParameter("amountOfLeave"));
	}
	//------For food Block--------
	
	if(request.getParameter("lastMealHours") !=null && !request.getParameter("lastMealHours").equals("")){
		avAccident.setFoodLastMeal(request.getParameter("lastMealHours"));
	}
	if(request.getParameter("whichWas") !=null && !request.getParameter("whichWas").equals("")){
		avAccident.setFoodWhichWas(request.getParameter("whichWas"));
	}
	if(request.getParameter("dispersalCanteen") !=null && !request.getParameter("dispersalCanteen").equals("")){
		avAccident.setFoodDispersal(request.getParameter("dispersalCanteen"));
	}
	if(request.getParameter("inFlightFeeding") !=null && !request.getParameter("inFlightFeeding").equals("")){
		avAccident.setFoodFlightFeeding(request.getParameter("inFlightFeeding"));
	}
	if(request.getParameter("abnormalfeeding") !=null && !request.getParameter("abnormalfeeding").equals("")){
		avAccident.setFoodSpecifyFeedings(request.getParameter("abnormalfeeding"));
	}
	//------For----OTHER PHYSIOLOGICAL FACTORS---BLock
	if(request.getParameter("intoxication") !=null && !request.getParameter("intoxication").equals("")){
		avAccident.setPhysioIntoxication(request.getParameter("intoxication"));
	}
	if(request.getParameter("hypoxia") !=null && !request.getParameter("hypoxia").equals("")){
		avAccident.setPhysioHypoxia(request.getParameter("hypoxia"));
	}
	if(request.getParameter("disorientation") !=null && !request.getParameter("disorientation").equals("")){
		avAccident.setPhysioDisorientation(request.getParameter("disorientation"));
	}
	if(request.getParameter("airSickness") !=null && !request.getParameter("airSickness").equals("")){
		avAccident.setPhysioAirSick(request.getParameter("airSickness"));
	}
	if(request.getParameter("decompressionSickness") !=null && !request.getParameter("decompressionSickness").equals("")){
		avAccident.setPhysioDecompression(request.getParameter("decompressionSickness"));
	}
	if(request.getParameter("heatStress") !=null && !request.getParameter("heatStress").equals("")){
		avAccident.setPhysioHeatStress(request.getParameter("heatStress"));
	}
	if(request.getParameter("coldInjury") !=null && !request.getParameter("coldInjury").equals("")){
		avAccident.setPhysioColdInjury(request.getParameter("coldInjury"));
	}
	if(request.getParameter("accelerations") !=null && !request.getParameter("accelerations").equals("")){
		avAccident.setPhysioAccelerations(request.getParameter("accelerations"));
	}
	if(request.getParameter("hyperventilation") !=null && !request.getParameter("hyperventilation").equals("")){
		avAccident.setPhysioHyperventilation(request.getParameter("hyperventilation"));
	}
	if(request.getParameter("hypoglycaemin") !=null && !request.getParameter("hypoglycaemin").equals("")){
		avAccident.setPhysioHypoglycaemin(request.getParameter("hypoglycaemin"));
	}
	if(request.getParameter("sycope") !=null && !request.getParameter("sycope").equals("")){
		avAccident.setPhysioSycope(request.getParameter("sycope"));
	}
	if(request.getParameter("visualFactorsInAircraft") !=null && !request.getParameter("visualFactorsInAircraft").equals("")){
		avAccident.setPhysioVascularFactor(request.getParameter("visualFactorsInAircraft"));
	}
	if(request.getParameter("noiseVibration") !=null && !request.getParameter("noiseVibration").equals("")){
		avAccident.setPhysioNose(request.getParameter("noiseVibration"));
	}
	if(request.getParameter("alcoholDesc") !=null && !request.getParameter("alcoholDesc").equals("")){
		avAccident.setPhysioAlcohol(request.getParameter("alcoholDesc"));
	}
	//----For-PHYCHOLOGICAL STRESS---BLock
	if(request.getParameter("willingness") !=null && !request.getParameter("willingness").equals("")){
		avAccident.setStressWill(request.getParameter("willingness"));
	}
	if(request.getParameter("willingReason") !=null && !request.getParameter("willingReason").equals("")){
		avAccident.setStressWillReason(request.getParameter("willingReason"));
	}
	if(request.getParameter("attitudeService") !=null && !request.getParameter("attitudeService").equals("")){
		avAccident.setStressAttService(request.getParameter("attitudeService"));
	}
	if(request.getParameter("shinUnit") !=null && !request.getParameter("shinUnit").equals("")){
		avAccident.setStressAttUnitShine(request.getParameter("shinUnit"));
	}
	if(request.getParameter("attitudeFlying") !=null && !request.getParameter("attitudeFlying").equals("")){
		avAccident.setStressAttFlying(request.getParameter("attitudeFlying"));
	}
	if(request.getParameter("temperamentEmotional") !=null && !request.getParameter("temperamentEmotional").equals("")){
		avAccident.setStressTemperament(request.getParameter("temperamentEmotional"));
	}
	if(request.getParameter("discipline") !=null && !request.getParameter("discipline").equals("")){
		avAccident.setStressDisciplinePunish(request.getParameter("discipline"));
	}
	if(request.getParameter("confidenceAbility") !=null && !request.getParameter("confidenceAbility").equals("")){
		avAccident.setStressConfidence(request.getParameter("confidenceAbility"));
	}
	if(request.getParameter("remarksConfidence") !=null && !request.getParameter("remarksConfidence").equals("")){
		avAccident.setStressConfidenceRemarks(request.getParameter("remarksConfidence"));
	}
	if(request.getParameter("evidenceAccident") !=null && !request.getParameter("evidenceAccident").equals("")){
		avAccident.setStressEvidence(request.getParameter("evidenceAccident"));
	}
	if(request.getParameter("trendConversation") !=null && !request.getParameter("trendConversation").equals("")){
		avAccident.setStressConversation(request.getParameter("trendConversation"));
	}
	if(request.getParameter("remarksTrend") !=null && !request.getParameter("remarksTrend").equals("")){
		avAccident.setSTRESSConversationREMARKS(request.getParameter("remarksTrend"));
	}
	if(request.getParameter("engineeringFactors") !=null && !request.getParameter("engineeringFactors").equals("")){
		avAccident.setStressHuamnEngFactor(request.getParameter("engineeringFactors"));
	}
	if(request.getParameter("hasteApprehension") !=null && !request.getParameter("hasteApprehension").equals("")){
		avAccident.setStressSortieApprehension(request.getParameter("hasteApprehension"));
	}
	if(request.getParameter("humanEngineering") !=null && !request.getParameter("humanEngineering").equals("")){
		avAccident.setStressMoInvolve(request.getParameter("humanEngineering"));
	}
	//---------For---TABLE OF INJURIES----Block----
	
	if(request.getParameter("scalp") !=null && !request.getParameter("scalp").equals("")){
		avAccident.setScalp(request.getParameter("scalp"));
	}
	if(request.getParameter("remarksScalp") !=null && !request.getParameter("remarksScalp").equals("")){
		avAccident.setScalpRemarks(request.getParameter("remarksScalp"));
	}
	if(request.getParameter("face") !=null && !request.getParameter("face").equals("")){
		avAccident.setNeck(request.getParameter("face"));
	}
	if(request.getParameter("remarksFace") !=null && !request.getParameter("remarksFace").equals("")){
		avAccident.setScalpRemarks(request.getParameter("remarksFace"));
	}
	if(request.getParameter("neck") !=null && !request.getParameter("neck").equals("")){
		avAccident.setNeck(request.getParameter("neck"));
	}
	if(request.getParameter("remarksNeck") !=null && !request.getParameter("remarksNeck").equals("")){
		avAccident.setNeckRemarks(request.getParameter("remarksNeck"));
	}
	if(request.getParameter("throaxAnt") !=null && !request.getParameter("throaxAnt").equals("")){
		avAccident.setThroxAnt(request.getParameter("throaxAnt"));
	}
	if(request.getParameter("throaxPost") !=null && !request.getParameter("throaxPost").equals("")){
		avAccident.setThroxPost(request.getParameter("throaxPost"));
	}
	if(request.getParameter("throaxRemarks") !=null && !request.getParameter("throaxRemarks").equals("")){
		avAccident.setThroxRemarks(request.getParameter("throaxRemarks"));
	}
	if(request.getParameter("ltHandWrist") !=null && !request.getParameter("ltHandWrist").equals("")){
		avAccident.setHandWristLt(request.getParameter("ltHandWrist"));
	}
	if(request.getParameter("rtHandWrist") !=null && !request.getParameter("rtHandWrist").equals("")){
		avAccident.setHandWristRt(request.getParameter("rtHandWrist"));
	}
	if(request.getParameter("remarksLtRtHandWrist") !=null && !request.getParameter("remarksLtRtHandWrist").equals("")){
		avAccident.setHandWristRemarks(request.getParameter("remarksLtRtHandWrist"));
	}
	if(request.getParameter("ltForearmAndElbow") !=null && !request.getParameter("ltForearmAndElbow").equals("")){
		avAccident.setForearnElbowLt(request.getParameter("ltForearmAndElbow"));
	}
	if(request.getParameter("rtForearmAndElbow") !=null && !request.getParameter("rtForearmAndElbow").equals("")){
		avAccident.setForearnElbowRt(request.getParameter("rtForearmAndElbow"));
	}
	if(request.getParameter("remarksLtRtForearmElbow") !=null && !request.getParameter("remarksLtRtForearmElbow").equals("")){
		avAccident.setForearnElbowRemarks(request.getParameter("remarksLtRtForearmElbow"));
	}
	if(request.getParameter("ltArmAndShoulder") !=null && !request.getParameter("ltArmAndShoulder").equals("")){
		avAccident.setArmSholderLt(request.getParameter("ltArmAndShoulder"));
	}
	if(request.getParameter("rtArmAndShoulder") !=null && !request.getParameter("rtArmAndShoulder").equals("")){
		avAccident.setArmSholderRt(request.getParameter("rtArmAndShoulder"));
	}
	if(request.getParameter("remarksLtRtArmShoulder") !=null && !request.getParameter("remarksLtRtArmShoulder").equals("")){
		avAccident.setArmRemarks(request.getParameter("remarksLtRtArmShoulder"));
	}
	if(request.getParameter("abdomenAntPost") !=null && !request.getParameter("abdomenAntPost").equals("")){
		avAccident.setAbdoment(request.getParameter("abdomenAntPost"));
	}
	if(request.getParameter("remarksAbdomenAntPost") !=null && !request.getParameter("remarksAbdomenAntPost").equals("")){
		avAccident.setAbdomentRemarks(request.getParameter("remarksAbdomenAntPost"));
	}
	if(request.getParameter("ltFootAndAnkle") !=null && !request.getParameter("ltFootAndAnkle").equals("")){
		avAccident.setFootAnkleLt(request.getParameter("ltFootAndAnkle"));
	}
	if(request.getParameter("rtFootAndAnkle") !=null && !request.getParameter("rtFootAndAnkle").equals("")){
		avAccident.setFootAnkleRt(request.getParameter("rtFootAndAnkle"));
	}
	if(request.getParameter("remarksLtRtFootAnkle") !=null && !request.getParameter("remarksLtRtFootAnkle").equals("")){
		avAccident.setFootAnkleRemarks(request.getParameter("remarksLtRtFootAnkle"));
	}
	if(request.getParameter("ltLegAndKnee") !=null && !request.getParameter("ltLegAndKnee").equals("")){
		avAccident.setLegKneeLt(request.getParameter("ltLegAndKnee"));
	}
	if(request.getParameter("rtLegAndKnee") !=null && !request.getParameter("rtLegAndKnee").equals("")){
		avAccident.setLegKneeRt(request.getParameter("rtLegAndKnee"));
	}
	if(request.getParameter("remarksLtRtLegKnee") !=null && !request.getParameter("remarksLtRtLegKnee").equals("")){
		avAccident.setLegKneeRemarks(request.getParameter("remarksLtRtLegKnee"));
	}
	if(request.getParameter("ltThighAndHip") !=null && !request.getParameter("ltThighAndHip").equals("")){
		avAccident.setThighHipLt(request.getParameter("ltThighAndHip"));
	}
	if(request.getParameter("rtThighAndHip") !=null && !request.getParameter("rtThighAndHip").equals("")){
		avAccident.setThighHipRl(request.getParameter("rtThighAndHip"));
	}
	if(request.getParameter("remarksLtRtThighHip") !=null && !request.getParameter("remarksLtRtThighHip").equals("")){
		avAccident.setThighHipRemarks(request.getParameter("remarksLtRtThighHip"));
	}
	if(request.getParameter("ltButtocks") !=null && !request.getParameter("ltButtocks").equals("")){
		avAccident.setButtockLt(request.getParameter("ltButtocks"));
	}
	if(request.getParameter("rtButtocks") !=null && !request.getParameter("rtButtocks").equals("")){
		avAccident.setButtockRt(request.getParameter("rtButtocks"));
	}
	if(request.getParameter("remarksLtRtButtocks") !=null && !request.getParameter("remarksLtRtButtocks").equals("")){
		avAccident.setButtockRemarks(request.getParameter("remarksLtRtButtocks"));
	}
	if(request.getParameter("perineumGenitalia") !=null && !request.getParameter("perineumGenitalia").equals("")){
		avAccident.setPerineumGenit(request.getParameter("perineumGenitalia"));
	}
	if(request.getParameter("remarksPerineumGenitalia") !=null && !request.getParameter("remarksPerineumGenitalia").equals("")){
		avAccident.setPerineumRemarks(request.getParameter("remarksPerineumGenitalia"));
	}
	if (request.getParameter(LAST_CHANGED_BY) != null)
	{	avAccident.setLastChgBy(request.getParameter(LAST_CHANGED_BY));
	}
	if (request.getParameter(LAST_CHANGED_DATE) != null)
	{
		avAccident.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(LAST_CHANGED_DATE)));
	}
	if (request.getParameter(LAST_CHANGED_TIME) != null)
	{	avAccident.setLastChgTime(request.getParameter(LAST_CHANGED_TIME));
	}
	String flag="";
	if(request.getParameter("flag") !=null && !request.getParameter("flag").equals("")){
		flag=request.getParameter("flag");
	}
	infoMap.put("avAccident", avAccident);
	boolean saved = false;
	map = aviationMedicineHandlerService.submitEquipmentFactors(infoMap);
	if (map.get("saved") != null) {
		saved = (Boolean) map.get("saved");
	}
	if (saved) {
		message = "Data saved Successfully !!";
	} else {
		message = "Try Again!";
	}
	map.put("message", message);
	url = "/hms/hms/aviationMedicine?method=showEquipmentInUseJsp";
	int avAccidentIdd=0;
	if(map.get("avAccidentIdd") !=null){
		avAccidentIdd=(Integer)map.get("avAccidentIdd");
	}
	jsp = AV_MESSAGE + ".jsp";
	map.put("avAccidentId",avAccidentIdd);
	map.put("flag",flag);
	map.put("url", url);
	map.put("message", message);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}


public ModelAndView submitExternalMedExam(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	infoMap.put("box", box);
	String url="";
	String message="";
	AvAccident avAccident = new AvAccident();
	int avAccidentId=0;
	if(request.getParameter("avAccidentId") !=null && !request.getParameter("avAccidentId").equals("0")){
		avAccidentId=Integer.parseInt(request.getParameter("avAccidentId"));
	avAccident = aviationMedicineHandlerService.loadAviationAccident(avAccidentId);
	}
	if (session.getAttribute(HOSPITAL_ID) != null) 
	{
		MasHospital masHospital=new MasHospital();
		masHospital.setId((Integer)session.getAttribute(HOSPITAL_ID));
		avAccident.setHospital(masHospital);
		
	}
	if (session.getAttribute("deptId") != null) 
	{
		MasDepartment masDept=new MasDepartment();
		masDept.setId((Integer)session.getAttribute("deptId"));
		avAccident.setDepartment(masDept);
		
	}
	//-----------For Person Detail--Block--
	if(request.getParameter(SERVICE_NO) !=null && !request.getParameter(SERVICE_NO).equals("")){
		avAccident.setServiceNo(request.getParameter(SERVICE_NO));
	}
	if(request.getParameter(FIRST_NAME) !=null && !request.getParameter(FIRST_NAME).equals("")){
		avAccident.setFirstName(request.getParameter(FIRST_NAME));
	}
	if(request.getParameter("surname") !=null && !request.getParameter("surname").equals("")){
		avAccident.setSurname(request.getParameter("surname"));
	}
	if(request.getParameter("crewDuty") !=null && !request.getParameter("crewDuty").equals("")){
		avAccident.setCrewDuty(request.getParameter("crewDuty"));
	}
	if(request.getParameter("hinId") !=null && !request.getParameter("hinId").equals("")){
		Patient patient=new Patient();
		patient.setId(Integer.parseInt(request.getParameter("hinId")));
		avAccident.setHin(patient);
	}
	if(request.getParameter(RANK_ID) !=null && !request.getParameter(RANK_ID).equals("0")){
		MasRank masRank=new MasRank();
		masRank.setId(Integer.parseInt(request.getParameter(RANK_ID)));
		avAccident.setRank(masRank);
	}
	
	infoMap.put("avAccidentId",avAccidentId);
	if(request.getParameter(FATAL) !=null && !request.getParameter(FATAL).equals("")){
		avAccident.setFatal(request.getParameter(FATAL));
	}
	if(request.getParameter("burns") !=null && !request.getParameter("burns").equals("")){
		avAccident.setBurns(request.getParameter("burns"));
	}
	if(request.getParameter("haemorrhage") !=null && !request.getParameter("haemorrhage").equals("")){
		avAccident.setHaemorrhage(request.getParameter("haemorrhage"));
	}
	if(request.getParameter("shock") !=null && !request.getParameter("shock").equals("")){
		avAccident.setShock(request.getParameter("shock"));
	}
	if(request.getParameter("concussion") !=null && !request.getParameter("concussion").equals("")){
		avAccident.setConcussion(request.getParameter("concussion"));
	}
	if(request.getParameter("lostConcussion") !=null && !request.getParameter("lostConcussion").equals("")){
		avAccident.setDurationConcussion(request.getParameter("lostConcussion"));
	}
	if(request.getParameter("retrogradeAmnesia") !=null && !request.getParameter("retrogradeAmnesia").equals("")){
		avAccident.setDurationRetrograde(request.getParameter("retrogradeAmnesia"));
	}
	
	if(request.getParameter("internalInjuriesDiagnosed") !=null && !request.getParameter("internalInjuriesDiagnosed").equals("")){
		avAccident.setInternalInjuriesDiagnosed(request.getParameter("internalInjuriesDiagnosed"));
	}
	if(request.getParameter("moAssessment") !=null && !request.getParameter("moAssessment").equals("")){
		avAccident.setMoAssessment(request.getParameter("moAssessment"));
	}
	if(request.getParameter("disposalCasualty") !=null && !request.getParameter("disposalCasualty").equals("")){
		avAccident.setDisposalCasualty(request.getParameter("disposalCasualty"));
	}
	if(request.getParameter("ssqSickBay") !=null && !request.getParameter("ssqSickBay").equals("")){
		avAccident.setSsqSickBay(request.getParameter("ssqSickBay"));
	}
	if(request.getParameter("admittedHospital") !=null && !request.getParameter("admittedHospital").equals("")){
		avAccident.setAdmitHospital(request.getParameter("admittedHospital"));
	}
	if(request.getParameter("deadFirstSeen") !=null && !request.getParameter("deadFirstSeen").equals("")){
		avAccident.setDeadFirstSeen(request.getParameter("deadFirstSeen"));
	}
	if(request.getParameter("causeDeath") !=null && !request.getParameter("causeDeath").equals("")){
		avAccident.setCauseDeath(request.getParameter("causeDeath"));
	}
	if(request.getParameter("skullVault") !=null && !request.getParameter("skullVault").equals("")){
		avAccident.setSkulVault(request.getParameter("skullVault"));
	}
	if(request.getParameter("skullBase") !=null && !request.getParameter("skullBase").equals("")){
		avAccident.setSkulBase(request.getParameter("skullBase"));
	}
	if(request.getParameter("skullInjuries") !=null && !request.getParameter("skullInjuries").equals("")){
		avAccident.setSkulInjuries(request.getParameter("skullInjuries"));
	}
	if(request.getParameter("faceVault") !=null && !request.getParameter("faceVault").equals("")){
		avAccident.setFaceVault(request.getParameter("faceVault"));
	}
	if(request.getParameter("faceBase") !=null && !request.getParameter("faceBase").equals("")){
		avAccident.setFaceBase(request.getParameter("faceBase"));
	}
	if(request.getParameter("faceInjuries") !=null && !request.getParameter("faceInjuries").equals("")){
		avAccident.setFaceInjuries(request.getParameter("faceInjuries"));
	}
	if(request.getParameter("cervialSpineVault") !=null && !request.getParameter("cervialSpineVault").equals("")){
		avAccident.setCervialSpineVault(request.getParameter("cervialSpineVault"));
	}
	if(request.getParameter("cervialSpineBase") !=null && !request.getParameter("cervialSpineBase").equals("")){
		avAccident.setCervialSpineBase(request.getParameter("cervialSpineBase"));
	}
	if(request.getParameter("cervialSpineInjuries") !=null && !request.getParameter("cervialSpineInjuries").equals("")){
		avAccident.setCervialSpineInjuries(request.getParameter("cervialSpineInjuries"));
	}
	if(request.getParameter("dorsalSpineVault") !=null && !request.getParameter("dorsalSpineVault").equals("")){
		avAccident.setDorsalSpineVault(request.getParameter("dorsalSpineVault"));
	}
	if(request.getParameter("dorsalSpineBase") !=null && !request.getParameter("dorsalSpineBase").equals("")){
		avAccident.setDorsalSpineBase(request.getParameter("dorsalSpineBase"));
	}
	if(request.getParameter("dorsalSpineInjuries") !=null && !request.getParameter("dorsalSpineInjuries").equals("")){
		avAccident.setDorsalSpineInjuries(request.getParameter("dorsalSpineInjuries"));
	}
	if(request.getParameter("lumbarSpineVault") !=null && !request.getParameter("lumbarSpineVault").equals("")){
		avAccident.setLumbarSpineVault(request.getParameter("lumbarSpineVault"));
	}
	if(request.getParameter("lumbarSpineBase") !=null && !request.getParameter("lumbarSpineBase").equals("")){
		avAccident.setLumbarSpineBase(request.getParameter("lumbarSpineBase"));
	}
	if(request.getParameter("lumbarSpineInjuries") !=null && !request.getParameter("lumbarSpineInjuries").equals("")){
		avAccident.setLumbarSpineInjuries(request.getParameter("lumbarSpineInjuries"));
	}
	if(request.getParameter("sacrumVault") !=null && !request.getParameter("sacrumVault").equals("")){
		avAccident.setSacrumVault(request.getParameter("sacrumVault"));
	}
	if(request.getParameter("sacrumBase") !=null && !request.getParameter("sacrumBase").equals("")){
		avAccident.setSacrumBase(request.getParameter("sacrumBase"));
	}
	if(request.getParameter("sacrumInjuries") !=null && !request.getParameter("sacrumInjuries").equals("")){
		avAccident.setSacrumInjuries(request.getParameter("sacrumInjuries"));
	}
	if(request.getParameter("pelvisVault") !=null && !request.getParameter("pelvisVault").equals("")){
		avAccident.setPelvisVault(request.getParameter("pelvisVault"));
	}
	if(request.getParameter("pelvisBase") !=null && !request.getParameter("pelvisBase").equals("")){
		avAccident.setPelvisBase(request.getParameter("pelvisBase"));
	}
	if(request.getParameter("pelvisInjuries") !=null && !request.getParameter("pelvisInjuries").equals("")){
		avAccident.setPelvisInjuries(request.getParameter("pelvisInjuries"));
	}
	if (request.getParameter(LAST_CHANGED_BY) != null)
	{	avAccident.setLastChgBy(request.getParameter(LAST_CHANGED_BY));
	}
	if (request.getParameter(LAST_CHANGED_DATE) != null)
	{
		avAccident.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(LAST_CHANGED_DATE)));
	}
	if (request.getParameter(LAST_CHANGED_TIME) != null)
	{	avAccident.setLastChgTime(request.getParameter(LAST_CHANGED_TIME));
	}
	if(request.getParameter("ltHandWrist") !=null && !request.getParameter("ltHandWrist").equals("")){
		avAccident.setHandWristLt(request.getParameter("ltHandWrist"));
	}
	if(request.getParameter("rtHandWrist") !=null && !request.getParameter("rtHandWrist").equals("")){
		avAccident.setHandWristRt(request.getParameter("rtHandWrist"));
	}
	if(request.getParameter("remarksLtRtHandWrist") !=null && !request.getParameter("remarksLtRtHandWrist").equals("")){
		avAccident.setHandWristRemarks(request.getParameter("remarksLtRtHandWrist"));
	}
	if(request.getParameter("ltForearmAndElbow") !=null && !request.getParameter("ltForearmAndElbow").equals("")){
		avAccident.setForearnElbowLt(request.getParameter("ltForearmAndElbow"));
	}
	if(request.getParameter("rtForearmAndElbow") !=null && !request.getParameter("rtForearmAndElbow").equals("")){
		avAccident.setForearnElbowRt(request.getParameter("rtForearmAndElbow"));
	}
	if(request.getParameter("remarksLtRtForearmElbow") !=null && !request.getParameter("remarksLtRtForearmElbow").equals("")){
		avAccident.setForearnElbowRemarks(request.getParameter("remarksLtRtForearmElbow"));
	}
	if(request.getParameter("ltArmAndShoulder") !=null && !request.getParameter("ltArmAndShoulder").equals("")){
		avAccident.setArmSholderLt(request.getParameter("ltArmAndShoulder"));
	}
	if(request.getParameter("rtArmAndShoulder") !=null && !request.getParameter("rtArmAndShoulder").equals("")){
		avAccident.setArmSholderRt(request.getParameter("rtArmAndShoulder"));
	}
	if(request.getParameter("remarksLtRtArmShoulder") !=null && !request.getParameter("remarksLtRtArmShoulder").equals("")){
		avAccident.setArmRemarks(request.getParameter("remarksLtRtArmShoulder"));
	}
	if(request.getParameter("ltFootAndAnkle") !=null && !request.getParameter("ltFootAndAnkle").equals("")){
		avAccident.setFootAnkleLt(request.getParameter("ltFootAndAnkle"));
	}
	if(request.getParameter("rtFootAndAnkle") !=null && !request.getParameter("rtFootAndAnkle").equals("")){
		avAccident.setFootAnkleRt(request.getParameter("rtFootAndAnkle"));
	}
	if(request.getParameter("remarksLtRtFootAnkle") !=null && !request.getParameter("remarksLtRtFootAnkle").equals("")){
		avAccident.setFootAnkleRemarks(request.getParameter("remarksLtRtFootAnkle"));
	}
	if(request.getParameter("ltLegAndKnee") !=null && !request.getParameter("ltLegAndKnee").equals("")){
		avAccident.setLegKneeLt(request.getParameter("ltLegAndKnee"));
	}
	if(request.getParameter("rtLegAndKnee") !=null && !request.getParameter("rtLegAndKnee").equals("")){
		avAccident.setLegKneeRt(request.getParameter("rtLegAndKnee"));
	}
	if(request.getParameter("remarksLtRtLegKnee") !=null && !request.getParameter("remarksLtRtLegKnee").equals("")){
		avAccident.setLegKneeRemarks(request.getParameter("remarksLtRtLegKnee"));
	}
	if(request.getParameter("ltThighAndHip") !=null && !request.getParameter("ltThighAndHip").equals("")){
		avAccident.setThighHipLt(request.getParameter("ltThighAndHip"));
	}
	if(request.getParameter("rtThighAndHip") !=null && !request.getParameter("rtThighAndHip").equals("")){
		avAccident.setThighHipRl(request.getParameter("rtThighAndHip"));
	}
	if(request.getParameter("remarksLtRtThighHip") !=null && !request.getParameter("remarksLtRtThighHip").equals("")){
		avAccident.setThighHipRemarks(request.getParameter("remarksLtRtThighHip"));
	}
	String flag="";
	if(request.getParameter("flag") !=null && !request.getParameter("flag").equals("")){
		flag=request.getParameter("flag");
	}
	infoMap.put("avAccident", avAccident);
	boolean saved = false;
	map = aviationMedicineHandlerService.submitEquipmentFactors(infoMap);
	if (map.get("saved") != null) {
		saved = (Boolean) map.get("saved");
	}
	if (saved) {
		message = "Data saved Successfully !!";
	} else {
		message = "Try Again!";
	}
	int avAccidentIdd=0;
	if(map.get("avAccidentIdd") !=null){
		avAccidentIdd=(Integer)map.get("avAccidentIdd");
	}
	map.put("message", message);
	url = "/hms/hms/aviationMedicine?method=showExternalMedicalExaminationJsp";
	jsp = AV_MESSAGE + ".jsp";
	map.put("flag",flag);
	map.put("url", url);
	map.put("avAccidentId",avAccidentIdd);
	map.put("message", message);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
public ModelAndView submitPostMortem(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	infoMap.put("box", box);
	String url="";
	String message="";
	AvAccident avAccident = new AvAccident();
	int avAccidentId=0;
	if(request.getParameter("avAccidentId") !=null && !request.getParameter("avAccidentId").equals("0")){
		avAccidentId=Integer.parseInt(request.getParameter("avAccidentId"));
	avAccident = aviationMedicineHandlerService.loadAviationAccident(avAccidentId);
	}
	if (session.getAttribute(HOSPITAL_ID) != null) 
	{
		MasHospital masHospital=new MasHospital();
		masHospital.setId((Integer)session.getAttribute(HOSPITAL_ID));
		avAccident.setHospital(masHospital);
		
	}
	if (session.getAttribute("deptId") != null) 
	{
		MasDepartment masDept=new MasDepartment();
		masDept.setId((Integer)session.getAttribute("deptId"));
		avAccident.setDepartment(masDept);
		
	}
	//-----------For Person Detail--Block--
	if(request.getParameter(SERVICE_NO) !=null && !request.getParameter(SERVICE_NO).equals("")){
		avAccident.setServiceNo(request.getParameter(SERVICE_NO));
	}
	if(request.getParameter(FIRST_NAME) !=null && !request.getParameter(FIRST_NAME).equals("")){
		avAccident.setFirstName(request.getParameter(FIRST_NAME));
	}
	if(request.getParameter("surname") !=null && !request.getParameter("surname").equals("")){
		avAccident.setSurname(request.getParameter("surname"));
	}
	if(request.getParameter("crewDuty") !=null && !request.getParameter("crewDuty").equals("")){
		avAccident.setCrewDuty(request.getParameter("crewDuty"));
	}
	if(request.getParameter("hinId") !=null && !request.getParameter("hinId").equals("")){
		Patient patient=new Patient();
		patient.setId(Integer.parseInt(request.getParameter("hinId")));
		avAccident.setHin(patient);
	}
	if(request.getParameter(RANK_ID) !=null && !request.getParameter(RANK_ID).equals("0")){
		MasRank masRank=new MasRank();
		masRank.setId(Integer.parseInt(request.getParameter(RANK_ID)));
		avAccident.setRank(masRank);
	}
	
	infoMap.put("avAccidentId",avAccidentId);
	if(request.getParameter(DATE_OF_DEATH) !=null && !request.getParameter(DATE_OF_DEATH).equals("")){
		avAccident.setDateDeath(HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE_OF_DEATH)));
	}
	if(request.getParameter("timeOfDeath") !=null && !request.getParameter("timeOfDeath").equals("")){
		avAccident.setTimeDeath(request.getParameter("timeOfDeath"));
	}
	if(request.getParameter("dateOfAutopsy") !=null && !request.getParameter("dateOfAutopsy").equals("")){
		avAccident.setDateAutopsy(HMSUtil.convertStringTypeDateToDateType(request.getParameter("dateOfAutopsy")));
	}
	if(request.getParameter("timeOfAutopsy") !=null && !request.getParameter("timeOfAutopsy").equals("")){
		avAccident.setTimeAutopsy(request.getParameter("timeOfAutopsy"));
	}
	if(request.getParameter("casualtySurvived") !=null && !request.getParameter("casualtySurvived").equals("")){
		avAccident.setCasualtySurvived(request.getParameter("casualtySurvived"));
	}
	if(request.getParameter("conditionBodyAutopsy") !=null && !request.getParameter("conditionBodyAutopsy").equals("")){
		avAccident.setConditionAutopsy(request.getParameter("conditionBodyAutopsy"));
	}
	if(request.getParameter("conditionBody") !=null && !request.getParameter("conditionBody").equals("")){
		avAccident.setInjuryHrsDay(request.getParameter("conditionBody"));
	}
	
	if(request.getParameter("conditionOfBodyFound") !=null && !request.getParameter("conditionOfBodyFound").equals("")){
		avAccident.setConditionBodyWas(request.getParameter("conditionOfBodyFound"));
	}
	if(request.getParameter("conditionBodywas") !=null && !request.getParameter("conditionBodywas").equals("")){
		avAccident.setConditionBodyCold(request.getParameter("conditionBodywas"));
	}
	if(request.getParameter("otherConditionOfBodywas") !=null && !request.getParameter("otherConditionOfBodywas").equals("")){
		avAccident.setConditionBodyOther(request.getParameter("otherConditionOfBodywas"));
	}
	if(request.getParameter("brainWeight") !=null && !request.getParameter("brainWeight").equals("")){
		avAccident.setBrainWeight(request.getParameter("brainWeight"));
	}
	if(request.getParameter("remarksBrain") !=null && !request.getParameter("remarksBrain").equals("")){
		avAccident.setBrainWeightRemarks(request.getParameter("remarksBrain"));
	}
	if(request.getParameter("spinalCord") !=null && !request.getParameter("spinalCord").equals("")){
		avAccident.setSpinalCordc(request.getParameter("spinalCord"));
	}
	if(request.getParameter("anyPreExistingLesion") !=null && !request.getParameter("anyPreExistingLesion").equals("")){
		avAccident.setPreExistLesion(request.getParameter("anyPreExistingLesion"));
	}
	if(request.getParameter("damageSustainedInAccident") !=null && !request.getParameter("damageSustainedInAccident").equals("")){
		avAccident.setDamageSustained(request.getParameter("damageSustainedInAccident"));
	}
	if(request.getParameter("middleEar") !=null && !request.getParameter("middleEar").equals("")){
		avAccident.setMiddleEar(request.getParameter("middleEar"));
	}
	if(request.getParameter("glottis") !=null && !request.getParameter("glottis").equals("")){
		avAccident.setGlottis(request.getParameter("glottis"));
	}
	if(request.getParameter("fractureOfCartilage") !=null && !request.getParameter("fractureOfCartilage").equals("")){
		avAccident.setFractureCartilage(request.getParameter("fractureOfCartilage"));
	}
	if(request.getParameter("pleuralSpace") !=null && !request.getParameter("pleuralSpace").equals("")){
		avAccident.setPleuraSpace(request.getParameter("pleuralSpace"));
	}
	if(request.getParameter("remarksPleuralSpaceRt") !=null && !request.getParameter("remarksPleuralSpaceRt").equals("")){
		avAccident.setPleuraSpaceRemarkRt(request.getParameter("remarksPleuralSpaceRt"));
	}
	if(request.getParameter("remarksPleuralSpaceLt") !=null && !request.getParameter("remarksPleuralSpaceLt").equals("")){
		avAccident.setPleuraSpaceRemarkLt(request.getParameter("remarksPleuralSpaceLt"));
	}
	if(request.getParameter("hydrothoraxRt") !=null && !request.getParameter("hydrothoraxRt").equals("")){
		avAccident.setHydrothoraxCcsRt(request.getParameter("hydrothoraxRt"));
	}
	if(request.getParameter("hydrothoraxLt") !=null && !request.getParameter("hydrothoraxLt").equals("")){
		avAccident.setHydrothoraxCcsLt(request.getParameter("hydrothoraxLt"));
	}
	if(request.getParameter("haemothoraxRt") !=null && !request.getParameter("haemothoraxRt").equals("")){
		avAccident.setHaemothoraxRt(request.getParameter("haemothoraxRt"));
	}
	if(request.getParameter("haemothoraxLt") !=null && !request.getParameter("haemothoraxLt").equals("")){
		avAccident.setHaemothoraxLt(request.getParameter("haemothoraxLt"));
	}
	if(request.getParameter("petechiae_present") !=null && !request.getParameter("petechiae_present").equals("")){
		avAccident.setPetechiaePresent(request.getParameter("petechiae_present"));
	}
	if(request.getParameter("trachea") !=null && !request.getParameter("trachea").equals("")){
		avAccident.setTrachea(request.getParameter("trachea"));
	}
	if(request.getParameter("tracheaRemarks") !=null && !request.getParameter("tracheaRemarks").equals("")){
		avAccident.setTracheaRemarks(request.getParameter("tracheaRemarks"));
	}
	if(request.getParameter("lungsRight") !=null && !request.getParameter("lungsRight").equals("")){
		avAccident.setLungResultRt(request.getParameter("lungsRight"));
	}
	if(request.getParameter("remarksLungsRight") !=null && !request.getParameter("remarksLungsRight").equals("")){
		avAccident.setLungResultRtRemarks(request.getParameter("remarksLungsRight"));
	}
	if(request.getParameter("lungsLeft") !=null && !request.getParameter("lungsLeft").equals("")){
		avAccident.setLungResultLt(request.getParameter("lungsLeft"));
	}
	if(request.getParameter("remarksLungsLeft") !=null && !request.getParameter("remarksLungsLeft").equals("")){
		avAccident.setLungResultLtRemarks(request.getParameter("remarksLungsLeft"));
	}
	if(request.getParameter("lungOedemaRt") !=null && !request.getParameter("lungOedemaRt").equals("")){
		avAccident.setLungOedemaRt(request.getParameter("lungOedemaRt"));
	}
	if(request.getParameter("lungOedemaDegreeRt") !=null && !request.getParameter("lungOedemaDegreeRt").equals("")){
		avAccident.setLungOedemaDegreeRt(request.getParameter("lungOedemaDegreeRt"));
	}
	if(request.getParameter("lungOedemaLt") !=null && !request.getParameter("lungOedemaLt").equals("")){
		avAccident.setLungOedemaLt(request.getParameter("lungOedemaLt"));
	}
	if(request.getParameter("lungHaemorrhageRt") !=null && !request.getParameter("lungHaemorrhageRt").equals("")){
		avAccident.setLungHaemorrhageRt(request.getParameter("lungHaemorrhageRt"));
	}
	if(request.getParameter("lungHaemorrhageLt") !=null && !request.getParameter("lungHaemorrhageLt").equals("")){
		avAccident.setLungHaemorrhageLt(request.getParameter("lungHaemorrhageLt"));
	}
	if(request.getParameter("lungHaemorrhageDegreeRt") !=null && !request.getParameter("lungHaemorrhageDegreeRt").equals("")){
		avAccident.setLungHaemorrhageDegreeRt(request.getParameter("lungHaemorrhageDegreeRt"));
	}
	if(request.getParameter("lungHaemorrhageDegreeLt") !=null && !request.getParameter("lungHaemorrhageDegreeLt").equals("")){
		avAccident.setLungHaemorrhageDegreeLt(request.getParameter("lungHaemorrhageDegreeLt"));
	}
	if(request.getParameter("lungTraumaticRt") !=null && !request.getParameter("lungTraumaticRt").equals("")){
		avAccident.setLungTraumaticRt(request.getParameter("lungTraumaticRt"));
	}
	if(request.getParameter("lungTraumaticLt") !=null && !request.getParameter("lungTraumaticLt").equals("")){
		avAccident.setLungTraumaticLt(request.getParameter("lungTraumaticLt"));
	}
	if(request.getParameter("lungCollapseRt") !=null && !request.getParameter("lungCollapseRt").equals("")){
		avAccident.setLungCollapseRt(request.getParameter("lungCollapseRt"));
	}
	if(request.getParameter("lungCollapseRtDegree") !=null && !request.getParameter("lungCollapseRtDegree").equals("")){
		avAccident.setLungCollapseRtDegree(request.getParameter("lungCollapseRtDegree"));
	}
	if(request.getParameter("lungCollapseLt") !=null && !request.getParameter("lungCollapseLt").equals("")){
		avAccident.setLungCollapseLt(request.getParameter("lungCollapseLt"));
	}
	if(request.getParameter("lungCollapseLtDegree") !=null && !request.getParameter("lungCollapseLtDegree").equals("")){
		avAccident.setLungCollapseLtDegree(request.getParameter("lungCollapseLtDegree"));
	}
	if(request.getParameter("lungRuptureRt") !=null && !request.getParameter("lungRuptureRt").equals("")){
		avAccident.setLungRuptureRt(request.getParameter("lungRuptureRt"));
	}
	if(request.getParameter("lungRuptureLt") !=null && !request.getParameter("lungRuptureLt").equals("")){
		avAccident.setLungRuptureLt(request.getParameter("lungRuptureLt"));
	}
	if(request.getParameter("lungFatMarrowRt") !=null && !request.getParameter("lungFatMarrowRt").equals("")){
		avAccident.setLungFatMarrowRt(request.getParameter("lungFatMarrowRt"));
	}
	if(request.getParameter("lungFatMarrowLt") !=null && !request.getParameter("lungFatMarrowLt").equals("")){
		avAccident.setLungFatMarrowLt(request.getParameter("lungFatMarrowLt"));
	}
	
	if(request.getParameter("pericardium") !=null && !request.getParameter("pericardium").equals("")){
		avAccident.setPericardium(request.getParameter("pericardium"));
	}
	if(request.getParameter("remarksPericardium") !=null && !request.getParameter("remarksPericardium").equals("")){
		avAccident.setPericardiumRemarks(request.getParameter("remarksPericardium"));
	}
	if(request.getParameter("bruisingDegree") !=null && !request.getParameter("bruisingDegree").equals("")){
		avAccident.setBruisingDegree(request.getParameter("bruisingDegree"));
	}
	if(request.getParameter("haemopericardiumOf") !=null && !request.getParameter("haemopericardiumOf").equals("")){
		avAccident.setHaemopericardium(request.getParameter("haemopericardiumOf"));
	}
	if(request.getParameter("hydropcricardiumOf") !=null && !request.getParameter("hydropcricardiumOf").equals("")){
		avAccident.setHydropcricardium(request.getParameter("hydropcricardiumOf"));
	}
	
	if(request.getParameter("lacerations") !=null && !request.getParameter("lacerations").equals("")){
		avAccident.setLacerations(request.getParameter("lacerations"));
	}
	if(request.getParameter("heartSituDisplced") !=null && !request.getParameter("heartSituDisplced").equals("")){
		avAccident.setHeartSituDisplced(request.getParameter("heartSituDisplced"));
	}
	if(request.getParameter("heart") !=null && !request.getParameter("heart").equals("")){
		avAccident.setHeart(request.getParameter("heart"));
	}
	if(request.getParameter("remarksHeart") !=null && !request.getParameter("remarksHeart").equals("")){
		avAccident.setHeartRemarks(request.getParameter("remarksHeart"));
	}
	if(request.getParameter("weight") !=null && !request.getParameter("weight").equals("")){
		avAccident.setWeight(new BigDecimal(request.getParameter("weight")));
	}
	if(request.getParameter("endocardialRupture") !=null && !request.getParameter("endocardialRupture").equals("")){
		avAccident.setLungHaemorrhageDegreeLt(request.getParameter("endocardialRupture"));
	}
	if(request.getParameter("pentratingWound") !=null && !request.getParameter("pentratingWound").equals("")){
		avAccident.setPentratingWound(request.getParameter("pentratingWound"));
	}
	if(request.getParameter("degree_cause") !=null && !request.getParameter("degree_cause").equals("")){
		avAccident.setDegreeCause(request.getParameter("degree_cause"));
	}
	if(request.getParameter("involving") !=null && !request.getParameter("involving").equals("")){
		avAccident.setInvolving(request.getParameter("involving"));
	}
	if(request.getParameter("fullThickness") !=null && !request.getParameter("fullThickness").equals("")){
		avAccident.setFullThickness(request.getParameter("fullThickness"));
	}
	if(request.getParameter("coronaryArteries") !=null && !request.getParameter("coronaryArteries").equals("")){
		avAccident.setCoronaryArteries(request.getParameter("coronaryArteries"));
	}
	if(request.getParameter("remarksCoronary") !=null && !request.getParameter("remarksCoronary").equals("")){
		avAccident.setCoronaryRemarks(request.getParameter("remarksCoronary"));
	}
	if(request.getParameter("aorta") !=null && !request.getParameter("aorta").equals("")){
		avAccident.setAorta(request.getParameter("aorta"));
	}
	if(request.getParameter("remarksAorta") !=null && !request.getParameter("remarksAorta").equals("")){
		avAccident.setAortaRemarks(request.getParameter("remarksAorta"));
	}
	if(request.getParameter("traumaInvolving") !=null && !request.getParameter("traumaInvolving").equals("")){
		avAccident.setTraumaInvolving(request.getParameter("traumaInvolving"));
	}
	if(request.getParameter("lacerationLocation") !=null && !request.getParameter("lacerationLocation").equals("")){
		avAccident.setLacerationLocation(request.getParameter("lacerationLocation"));
	}
	
	if(request.getParameter("otherGreatVessels") !=null && !request.getParameter("otherGreatVessels").equals("")){
		avAccident.setOtherGreatVessels(request.getParameter("otherGreatVessels"));
	}
	if(request.getParameter("remarksOtherGreatVessels") !=null && !request.getParameter("remarksOtherGreatVessels").equals("")){
		avAccident.setOtherGreatRemarks(request.getParameter("remarksOtherGreatVessels"));
	}
	if(request.getParameter("traumaInvolvingVessels") !=null && !request.getParameter("traumaInvolvingVessels").equals("")){
		avAccident.setTraumaInvolving1(request.getParameter("traumaInvolvingVessels"));
	}
	if(request.getParameter("diaphragam") !=null && !request.getParameter("diaphragam").equals("")){
		avAccident.setDiaphragam(request.getParameter("diaphragam"));
	}
	if(request.getParameter("specifyDiaphragam") !=null && !request.getParameter("specifyDiaphragam").equals("")){
		avAccident.setDiaphragamSpecify(request.getParameter("specifyDiaphragam"));
	}
	
	if(request.getParameter("peritoneum") !=null && !request.getParameter("peritoneum").equals("")){
		avAccident.setPeritoneum(request.getParameter("peritoneum"));
	}
	if(request.getParameter("remarksPeritoneum") !=null && !request.getParameter("remarksPeritoneum").equals("")){
		avAccident.setPeritoneumRemarks(request.getParameter("remarksPeritoneum"));
	}
	if(request.getParameter("retromesentericHaemo") !=null && !request.getParameter("retromesentericHaemo").equals("")){
		avAccident.setRetromesenteric(request.getParameter("retromesentericHaemo"));
	}
	
	if(request.getParameter("haemoperitoneumOf") !=null && !request.getParameter("haemoperitoneumOf").equals("")){
		avAccident.setHaemoperitoneum(request.getParameter("haemoperitoneumOf"));
	}
	if(request.getParameter("hydroperitoneumOf") !=null && !request.getParameter("hydroperitoneumOf").equals("")){
		avAccident.setAorta(request.getParameter("hydroperitoneumOf"));
	}
	if(request.getParameter("hydroperitoneumOf") !=null && !request.getParameter("hydroperitoneumOf").equals("")){
		avAccident.setHydroperitoneum(request.getParameter("hydroperitoneumOf"));
	}
	if(request.getParameter("lacerationPeritoncumAt") !=null && !request.getParameter("lacerationPeritoncumAt").equals("")){
		avAccident.setLacerationPeritoncum(request.getParameter("lacerationPeritoncumAt"));
	}
	if(request.getParameter("oesophagus") !=null && !request.getParameter("oesophagus").equals("")){
		avAccident.setOesophagus(request.getParameter("oesophagus"));
	}
	
	if(request.getParameter("remarksOesophagus") !=null && !request.getParameter("remarksOesophagus").equals("")){
		avAccident.setOesophagusRemarks(request.getParameter("remarksOesophagus"));
	}
	if(request.getParameter("stomach") !=null && !request.getParameter("stomach").equals("")){
		avAccident.setStomach(request.getParameter("stomach"));
	}
	if(request.getParameter("remarksStomach") !=null && !request.getParameter("remarksStomach").equals("")){
		avAccident.setStomachRemarks(request.getParameter("remarksStomach"));
	}
	if(request.getParameter("intestines") !=null && !request.getParameter("intestines").equals("")){
		avAccident.setIntestines(request.getParameter("intestines"));
	}
	if(request.getParameter("remarksIntestines") !=null && !request.getParameter("remarksIntestines").equals("")){
		avAccident.setIntestinesRemarks(request.getParameter("remarksIntestines"));
	}
	
	if(request.getParameter("distensionRuptureAt") !=null && !request.getParameter("distensionRuptureAt").equals("")){
		avAccident.setDistensionRupture(request.getParameter("distensionRuptureAt"));
	}
	if(request.getParameter("haemorrhage") !=null && !request.getParameter("haemorrhage").equals("")){
		avAccident.setHaemorrhage(request.getParameter("haemorrhage"));
	}
	if(request.getParameter("liver") !=null && !request.getParameter("liver").equals("")){
		avAccident.setLiver(request.getParameter("liver"));
	}
	
	if(request.getParameter("remarksLiver") !=null && !request.getParameter("remarksLiver").equals("")){
		avAccident.setLiverRemarks(request.getParameter("remarksLiver"));
	}
	if(request.getParameter("weightLiver") !=null && !request.getParameter("weightLiver").equals("")){
		avAccident.setWeight1(request.getParameter("weightLiver"));
	}
	if(request.getParameter("traumaOf") !=null && !request.getParameter("traumaOf").equals("")){
		avAccident.setTrauma(request.getParameter("traumaOf"));
	}
	if(request.getParameter("degreeTraumaOf") !=null && !request.getParameter("degreeTraumaOf").equals("")){
		avAccident.setDegreeCause(request.getParameter("degreeTraumaOf"));
	}
	
	if(request.getParameter("pancreas") !=null && !request.getParameter("pancreas").equals("")){
		avAccident.setPancreas(request.getParameter("pancreas"));
	}
	if(request.getParameter("remarksPancreas") !=null && !request.getParameter("remarksPancreas").equals("")){
		avAccident.setPancreasRemarks(request.getParameter("remarksPancreas"));
	}
	if(request.getParameter("weightPancreas") !=null && !request.getParameter("weightPancreas").equals("")){
		avAccident.setWeight2(request.getParameter("weightPancreas"));
	}
	if(request.getParameter("traumaOfPancreas") !=null && !request.getParameter("traumaOfPancreas").equals("")){
		avAccident.setTrauma1(request.getParameter("traumaOfPancreas"));
	}
	if(request.getParameter("degreeTraumaPancreas") !=null && !request.getParameter("degreeTraumaPancreas").equals("")){
		avAccident.setDegreeCause1(request.getParameter("degreeTraumaPancreas"));
	}
	
	if(request.getParameter("adrenalRt") !=null && !request.getParameter("adrenalRt").equals("")){
		avAccident.setAdrenalResultRt(request.getParameter("adrenalRt"));
	}
	if(request.getParameter("adrenalLt") !=null && !request.getParameter("adrenalLt").equals("")){
		avAccident.setAdrenalResultLt(request.getParameter("adrenalLt"));
	}
	if(request.getParameter("remarksAdrenalRt") !=null && !request.getParameter("remarksAdrenalRt").equals("")){
		avAccident.setAdrenalRemarksRt(request.getParameter("remarksAdrenalRt"));
	}
	if(request.getParameter("remarksAdrenalLt") !=null && !request.getParameter("remarksAdrenalLt").equals("")){
		avAccident.setAdrenalRemarksLt(request.getParameter("remarksAdrenalLt"));
	}
	if(request.getParameter("adrenalLaccrationRt") !=null && !request.getParameter("adrenalLaccrationRt").equals("")){
		avAccident.setAdrenalLaccrationRt(request.getParameter("adrenalLaccrationRt"));
	}
	if(request.getParameter("adrenalLaccRtDegree") !=null && !request.getParameter("adrenalLaccRtDegree").equals("")){
		avAccident.setAdrenalLaccRtDegree(request.getParameter("adrenalLaccRtDegree"));
	}
	if(request.getParameter("adrenalLaccrationLt") !=null && !request.getParameter("adrenalLaccrationLt").equals("")){
		avAccident.setAdrenalLaccrationLt(request.getParameter("adrenalLaccrationLt"));
	}
	if(request.getParameter("adrenalLaccLtDegree") !=null && !request.getParameter("adrenalLaccLtDegree").equals("")){
		avAccident.setAdrenalLaccLtDegree(request.getParameter("adrenalLaccLtDegree"));
	}
	if(request.getParameter("adrenalPeriglandularRt") !=null && !request.getParameter("adrenalPeriglandularRt").equals("")){
		avAccident.setAdrenalPeriglandularRt(request.getParameter("adrenalPeriglandularRt"));
	}
	if(request.getParameter("adrenalPeriglandularLt") !=null && !request.getParameter("adrenalPeriglandularLt").equals("")){
		avAccident.setAdrenalPeriglandularLt(request.getParameter("adrenalPeriglandularLt"));
	}
	if(request.getParameter("adrenalIntraglandularRt") !=null && !request.getParameter("adrenalIntraglandularRt").equals("")){
		avAccident.setAdrenalIntraglandularRt(request.getParameter("adrenalIntraglandularRt"));
	}
	if(request.getParameter("adrenalIntraglandularLt") !=null && !request.getParameter("adrenalIntraglandularLt").equals("")){
		avAccident.setAdrenalIntraglandularLt(request.getParameter("adrenalIntraglandularLt"));
	}
	
	if(request.getParameter("pelvicOrgans") !=null && !request.getParameter("pelvicOrgans").equals("")){
		avAccident.setPelvicOrgans(request.getParameter("pelvicOrgans"));
	}
	if(request.getParameter("remarksPelvicOrgans") !=null && !request.getParameter("remarksPelvicOrgans").equals("")){
		avAccident.setPelvicOrgansRemarks(request.getParameter("remarksPelvicOrgans"));
	}
	if(request.getParameter("anyBonyInjury") !=null && !request.getParameter("anyBonyInjury").equals("")){
		avAccident.setBonyInjury(request.getParameter("anyBonyInjury"));
	}
	if(request.getParameter("pituitary") !=null && !request.getParameter("pituitary").equals("")){
		avAccident.setPituitary(request.getParameter("pituitary"));
	}
	if(request.getParameter("remarksPituitary") !=null && !request.getParameter("remarksPituitary").equals("")){
		avAccident.setPituitaryRemarks(request.getParameter("remarksPituitary"));
	}
	
	if(request.getParameter("haemorrhageDegree") !=null && !request.getParameter("haemorrhageDegree").equals("")){
		avAccident.setHaemorrhageDegree(request.getParameter("haemorrhageDegree"));
	}
	if(request.getParameter("thymus") !=null && !request.getParameter("thymus").equals("")){
		avAccident.setThymus(request.getParameter("thymus"));
	}
	if(request.getParameter("weightThymus") !=null && !request.getParameter("weightThymus").equals("")){
		avAccident.setThymusWeight(request.getParameter("weightThymus"));
	}
	if(request.getParameter("thymusHaemorrhage") !=null && !request.getParameter("thymusHaemorrhage").equals("")){
		avAccident.setThymusHaemorrhage(request.getParameter("thymusHaemorrhage"));
	}
	if(request.getParameter("thyroid") !=null && !request.getParameter("thyroid").equals("")){
		avAccident.setThyroid(request.getParameter("thyroid"));
	}
	if(request.getParameter("remarksThyroid") !=null && !request.getParameter("remarksThyroid").equals("")){
		avAccident.setThyroidRemarks(request.getParameter("remarksThyroid"));
	}
	if(request.getParameter("remarksThyroidTraumatic") !=null && !request.getParameter("remarksThyroidTraumatic").equals("")){
		avAccident.setThyroidRemarksTraumatic(request.getParameter("remarksThyroidTraumatic"));
	}
	if(request.getParameter("weightThyroid") !=null && !request.getParameter("weightThyroid").equals("")){
		avAccident.setThyroidWeight(request.getParameter("weightThyroid"));
	}
	if(request.getParameter("lymphGlands") !=null && !request.getParameter("lymphGlands").equals("")){
		avAccident.setLymphGlands(request.getParameter("lymphGlands"));
	}
	if(request.getParameter("remarksLymphGlands") !=null && !request.getParameter("remarksLymphGlands").equals("")){
		avAccident.setLymphGlandsRemarks(request.getParameter("remarksLymphGlands"));
	}
	if(request.getParameter("foundAt") !=null && !request.getParameter("foundAt").equals("")){
		avAccident.setAirEmbolismFound(request.getParameter("foundAt"));
	}
	if(request.getParameter("fatEmbolism") !=null && !request.getParameter("fatEmbolism").equals("")){
		avAccident.setFatEmbolism(request.getParameter("fatEmbolism"));
	}
	if(request.getParameter("remarksFatEmbolism") !=null && !request.getParameter("remarksFatEmbolism").equals("")){
		avAccident.setFatEmbolismRemarks(request.getParameter("remarksFatEmbolism"));
	}
	
	if(request.getParameter("carbon") !=null && !request.getParameter("carbon").equals("")){
		avAccident.setCarbonMonoxide(request.getParameter("carbon"));
	}
	if(request.getParameter("remarksCarbon") !=null && !request.getParameter("remarksCarbon").equals("")){
		avAccident.setCarbonMonoxideRemarks(request.getParameter("remarksCarbon"));
	}
	if(request.getParameter("estimatedAt") !=null && !request.getParameter("estimatedAt").equals("")){
		avAccident.setEstimated(request.getParameter("estimatedAt"));
	}
	if(request.getParameter("labratory") !=null && !request.getParameter("labratory").equals("")){
		avAccident.setLabratory(request.getParameter("labratory"));
	}
	if(request.getParameter("otherPoisonings") !=null && !request.getParameter("otherPoisonings").equals("")){
		avAccident.setPoisonings(request.getParameter("otherPoisonings"));
	}
	
	if(request.getParameter("remarksOtherPoisonings") !=null && !request.getParameter("remarksOtherPoisonings").equals("")){
		avAccident.setPoisoningRemarks(request.getParameter("remarksOtherPoisonings"));
	}
	if(request.getParameter("poisonings_labratory") !=null && !request.getParameter("poisonings_labratory").equals("")){
		avAccident.setPoisoningsLabratory(request.getParameter("poisonings_labratory"));
	}
	if(request.getParameter("hypoxia") !=null && !request.getParameter("hypoxia").equals("")){
		avAccident.setHypoxia(request.getParameter("hypoxia"));
	}
	if(request.getParameter("remarksHypoxia") !=null && !request.getParameter("remarksHypoxia").equals("")){
		avAccident.setHypoxiaRemarks(request.getParameter("remarksHypoxia"));
	}
	if(request.getParameter("otherConditions") !=null && !request.getParameter("otherConditions").equals("")){
		avAccident.setOtherConditions(request.getParameter("otherConditions"));
	}
	if(request.getParameter("injuriesSummaries") !=null && !request.getParameter("injuriesSummaries").equals("")){
		avAccident.setSummaries(request.getParameter("injuriesSummaries"));
	}
	if(request.getParameter("summariesPhysicalCondition") !=null && !request.getParameter("summariesPhysicalCondition").equals("")){
		avAccident.setSummariesPhysicalCondition(request.getParameter("summariesPhysicalCondition"));
	}
	if(request.getParameter("histological") !=null && !request.getParameter("histological").equals("")){
		avAccident.setHistological(request.getParameter("histological"));
	}
	if(request.getParameter("material_histology") !=null && !request.getParameter("material_histology").equals("")){
		avAccident.setMaterialHistology(request.getParameter("material_histology"));
	}
	if(request.getParameter("histological_examinated") !=null && !request.getParameter("histological_examinated").equals("")){
		avAccident.setHistologyExaminated(request.getParameter("histological_examinated"));
	}
	if(request.getParameter("toxicological") !=null && !request.getParameter("toxicological").equals("")){
		avAccident.setToxicological(request.getParameter("toxicological"));
	}
	if(request.getParameter("specimens_exam") !=null && !request.getParameter("specimens_exam").equals("")){
		avAccident.setSpecimensExam(request.getParameter("specimens_exam"));
	}
	if(request.getParameter("specimens_estimation1") !=null && !request.getParameter("specimens_estimation1").equals("")){
		avAccident.setSpecimensEstimation1(request.getParameter("specimens_estimation1"));
	}
	if(request.getParameter("specimens_estimation2") !=null && !request.getParameter("specimens_estimation2").equals("")){
		avAccident.setSpecimensEstimation2(request.getParameter("specimens_estimation2"));
	}
	if(request.getParameter("specimens_estimation3") !=null && !request.getParameter("specimens_estimation3").equals("")){
		avAccident.setSpecimensEstimation3(request.getParameter("specimens_estimation3"));
	}
	if(request.getParameter("specimens_estimation_for1") !=null && !request.getParameter("specimens_estimation_for1").equals("")){
		avAccident.setSpecimensEstimationFor1(request.getParameter("specimens_estimation_for1"));
	}
	if(request.getParameter("specimens_estimation_for2") !=null && !request.getParameter("specimens_estimation_for2").equals("")){
		avAccident.setSpecimensEstimationFor2(request.getParameter("specimens_estimation_for2"));
	}
	if(request.getParameter("specimens_estimation_for3") !=null && !request.getParameter("specimens_estimation_for3").equals("")){
		avAccident.setSpecimensEstimationFor3(request.getParameter("specimens_estimation_for3"));
	}
	if(request.getParameter("causeDeath") !=null && !request.getParameter("causeDeath").equals("")){
		avAccident.setCauseDeath(request.getParameter("causeDeath"));
	}
	if(request.getParameter("DeathDiseaseCondition") !=null && !request.getParameter("DeathDiseaseCondition").equals("")){
		avAccident.setDeathDiseaseCondition(request.getParameter("DeathDiseaseCondition"));
	}
	if(request.getParameter("Antecedent") !=null && !request.getParameter("Antecedent").equals("")){
		avAccident.setAntecedent(request.getParameter("Antecedent"));
	}
	if(request.getParameter("causes") !=null && !request.getParameter("causes").equals("")){
		avAccident.setCauses(request.getParameter("causes"));
	}
	if(request.getParameter("summariesAnyPhysical") !=null && !request.getParameter("summariesAnyPhysical").equals("")){
		avAccident.setOtherSingCondition(request.getParameter("summariesAnyPhysical"));
	}
	if(request.getParameter("capitalName") !=null && !request.getParameter("capitalName").equals("")){
		avAccident.setCapitalName(request.getParameter("capitalName"));
	}
	if(request.getParameter("appointment") !=null && !request.getParameter("appointment").equals("")){
		avAccident.setAppointment(request.getParameter("appointment"));
	}
	if(request.getParameter("kidneyRt") !=null && !request.getParameter("kidneyRt").equals("")){
		avAccident.setKidneyResultRt(request.getParameter("kidneyRt"));
	}
	if(request.getParameter("kidneyLt") !=null && !request.getParameter("kidneyLt").equals("")){
		avAccident.setKidneyResultLt(request.getParameter("kidneyLt"));
	}
	if(request.getParameter("remarksKidneyRt") !=null && !request.getParameter("remarksKidneyRt").equals("")){
		avAccident.setKidneyRemarksRt(request.getParameter("remarksKidneyRt"));
	}
	if(request.getParameter("remarksKidneyLt") !=null && !request.getParameter("remarksKidneyLt").equals("")){
		avAccident.setKidneyRemarksLt(request.getParameter("remarksKidneyLt"));
	}
	if(request.getParameter("kidneyLaccrationRt") !=null && !request.getParameter("kidneyLaccrationRt").equals("")){
		avAccident.setKidneyLaccrationRt(request.getParameter("kidneyLaccrationRt"));
	}
	if(request.getParameter("kidneyLaccRtDegree") !=null && !request.getParameter("kidneyLaccRtDegree").equals("")){
		avAccident.setKidneyLaccRtDegree(request.getParameter("kidneyLaccRtDegree"));
	}
	if(request.getParameter("kidneyLaccrationLt") !=null && !request.getParameter("kidneyLaccrationLt").equals("")){
		avAccident.setKidneyLaccrationLt(request.getParameter("kidneyLaccrationLt"));
	}
	if(request.getParameter("kidneyLaccLtDegree") !=null && !request.getParameter("kidneyLaccLtDegree").equals("")){
		avAccident.setKidneyLaccLtDegree(request.getParameter("kidneyLaccLtDegree"));
	}
	if(request.getParameter("kidneyPeriglandularRt") !=null && !request.getParameter("kidneyPeriglandularRt").equals("")){
		avAccident.setKidneyPeriglandularRt(request.getParameter("kidneyPeriglandularRt"));
	}
	if(request.getParameter("kidneyPeriglandularLt") !=null && !request.getParameter("kidneyPeriglandularLt").equals("")){
		avAccident.setKidneyPeriglandularLt(request.getParameter("kidneyPeriglandularLt"));
	}
	if(request.getParameter("kidneyIntraglandularRt") !=null && !request.getParameter("kidneyIntraglandularRt").equals("")){
		avAccident.setKidneyIntraglandularRt(request.getParameter("kidneyIntraglandularRt"));
	}
	if(request.getParameter("kidneyIntraglandularLt") !=null && !request.getParameter("kidneyIntraglandularLt").equals("")){
		avAccident.setKidneyIntraglandularLt(request.getParameter("kidneyIntraglandularLt"));
	}
	if(request.getParameter("anteMortemAir") !=null && !request.getParameter("anteMortemAir").equals("")){
		avAccident.setAnteMortemAir(request.getParameter("anteMortemAir"));
	}
	if(request.getParameter("postMortemAir") !=null && !request.getParameter("postMortemAir").equals("")){
		avAccident.setPostMortemAir(request.getParameter("postMortemAir"));
	}
	if(request.getParameter("ante_mortem_alt_escap") !=null && !request.getParameter("ante_mortem_alt_escap").equals("")){
		avAccident.setAnteMortemAltEscap(request.getParameter("ante_mortem_alt_escap"));
	}
	if(request.getParameter("post_mortem_alt_escap") !=null && !request.getParameter("post_mortem_alt_escap").equals("")){
		avAccident.setPostMortemAltEscap(request.getParameter("post_mortem_alt_escap"));
	}
	if(request.getParameter("ante_ground_impact") !=null && !request.getParameter("ante_ground_impact").equals("")){
		avAccident.setAnteGroundImpact(request.getParameter("ante_ground_impact"));
	}
	if(request.getParameter("post_ground_impact") !=null && !request.getParameter("post_ground_impact").equals("")){
		avAccident.setPostGroundImpact(request.getParameter("post_ground_impact"));
	}
	
	if(request.getParameter("ante_ground_escape") !=null && !request.getParameter("ante_ground_escape").equals("")){
		avAccident.setAnteGroundEscape(request.getParameter("ante_ground_escape"));
	}
	if(request.getParameter("post_ground_escape") !=null && !request.getParameter("post_ground_escape").equals("")){
		avAccident.setPostGroundEscape(request.getParameter("post_ground_escape"));
	}
	if(request.getParameter("ante_aircraft_impact") !=null && !request.getParameter("ante_aircraft_impact").equals("")){
		avAccident.setAnteAircraftImpact(request.getParameter("ante_aircraft_impact"));
	}
	if(request.getParameter("post_aircraft_impact") !=null && !request.getParameter("post_aircraft_impact").equals("")){
		avAccident.setPostAircraftImpact(request.getParameter("post_aircraft_impact"));
	}
	if(request.getParameter("presenceConfirmedAt") !=null && !request.getParameter("presenceConfirmedAt").equals("")){
		avAccident.setPresenceConfirmd(request.getParameter("presenceConfirmedAt"));
	}
	if (request.getParameter(LAST_CHANGED_BY) != null)
	{	avAccident.setLastChgBy(request.getParameter(LAST_CHANGED_BY));
	}
	if (request.getParameter(LAST_CHANGED_DATE) != null)
	{
		avAccident.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(LAST_CHANGED_DATE)));
	}
	if (request.getParameter(LAST_CHANGED_TIME) != null)
	{	avAccident.setLastChgTime(request.getParameter(LAST_CHANGED_TIME));
	}
	String flag="";
	if(request.getParameter("flag") !=null && !request.getParameter("flag").equals("")){
		flag=request.getParameter("flag");
	}
	infoMap.put("avAccident", avAccident);
	boolean saved = false;
	map = aviationMedicineHandlerService.submitEquipmentFactors(infoMap);
	if (map.get("saved") != null) {
		saved = (Boolean) map.get("saved");
	}
	if (saved) {
		message = "Data saved Successfully !!";
	} else {
		message = "Try Again!";
	}
	int avAccidentIdd=0;
	if(map.get("avAccidentIdd") !=null){
		avAccidentIdd=(Integer)map.get("avAccidentIdd");
	}
	map.put("message", message);
	url = "/hms/hms/aviationMedicine?method=showPostMortemJsp";
	jsp = AV_MESSAGE + ".jsp";
	map.put("url", url);
	map.put("flag", flag);
	map.put("avAccidentId", avAccidentIdd);
	map.put("message", message);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
public ModelAndView submitUnassistedEscape(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	infoMap.put("box", box);
	String url="";
	String message="";
	AvAccident avAccident = new AvAccident();
	int avAccidentId=0;
	if(request.getParameter("avAccidentId") !=null && !request.getParameter("avAccidentId").equals("0")){
		avAccidentId=Integer.parseInt(request.getParameter("avAccidentId"));
	avAccident = aviationMedicineHandlerService.loadAviationAccident(avAccidentId);
	}
	if (session.getAttribute(HOSPITAL_ID) != null) 
	{
		MasHospital masHospital=new MasHospital();
		masHospital.setId((Integer)session.getAttribute(HOSPITAL_ID));
		avAccident.setHospital(masHospital);
		
	}
	if (session.getAttribute("deptId") != null) 
	{
		MasDepartment masDept=new MasDepartment();
		masDept.setId((Integer)session.getAttribute("deptId"));
		avAccident.setDepartment(masDept);
		
	}
	//-----------For Person Detail--Block--
	if(request.getParameter(SERVICE_NO) !=null && !request.getParameter(SERVICE_NO).equals("")){
		avAccident.setServiceNo(request.getParameter(SERVICE_NO));
	}
	if(request.getParameter(FIRST_NAME) !=null && !request.getParameter(FIRST_NAME).equals("")){
		avAccident.setFirstName(request.getParameter(FIRST_NAME));
	}
	if(request.getParameter("surname") !=null && !request.getParameter("surname").equals("")){
		avAccident.setSurname(request.getParameter("surname"));
	}
	if(request.getParameter("crewDuty") !=null && !request.getParameter("crewDuty").equals("")){
		avAccident.setCrewDuty(request.getParameter("crewDuty"));
	}
	if(request.getParameter("hinId") !=null && !request.getParameter("hinId").equals("")){
		Patient patient=new Patient();
		patient.setId(Integer.parseInt(request.getParameter("hinId")));
		avAccident.setHin(patient);
	}
	if(request.getParameter(RANK_ID) !=null && !request.getParameter(RANK_ID).equals("0")){
		MasRank masRank=new MasRank();
		masRank.setId(Integer.parseInt(request.getParameter(RANK_ID)));
		avAccident.setRank(masRank);
	}
	
	infoMap.put("avAccidentId",avAccidentId);
	if(request.getParameter("escapeFlight") !=null && !request.getParameter("escapeFlight").equals("")){
		avAccident.setEvidenceEscapeFlight(request.getParameter("escapeFlight"));
	}
	if(request.getParameter("escapeFlightRemarks") !=null && !request.getParameter("escapeFlightRemarks").equals("")){
		avAccident.setEscapeFlight(request.getParameter("escapeFlightRemarks"));
	}
	if(request.getParameter("briefDesEscape") !=null && !request.getParameter("briefDesEscape").equals("")){
		avAccident.setDescEscape(request.getParameter("briefDesEscape"));
	}
	if(request.getParameter("distressCalls") !=null && !request.getParameter("distressCalls").equals("")){
		avAccident.setDistressCalls(request.getParameter("distressCalls"));
	}
	if(request.getParameter("damageAircraftPrior") !=null && !request.getParameter("damageAircraftPrior").equals("")){
		avAccident.setDamageAircraftPrior(request.getParameter("damageAircraftPrior"));
	}
	if(request.getParameter("remarksDamageAircraft") !=null && !request.getParameter("remarksDamageAircraft").equals("")){
		avAccident.setDamageAircraftPriorRemarks(request.getParameter("remarksDamageAircraft"));
	}
	if(request.getParameter("canopyJettison") !=null && !request.getParameter("canopyJettison").equals("")){
		avAccident.setCanopyJettison(request.getParameter("canopyJettison"));
	}
	
	if(request.getParameter("remarksCanopyJettison") !=null && !request.getParameter("remarksCanopyJettison").equals("")){
		avAccident.setCanopyJettisonReamrks(request.getParameter("remarksCanopyJettison"));
	}
	if(request.getParameter("attitude_canopy") !=null && !request.getParameter("attitude_canopy").equals("")){
		avAccident.setAttitudeCanopy(request.getParameter("attitude_canopy"));
	}
	if(request.getParameter("speed_canopy") !=null && !request.getParameter("speed_canopy").equals("")){
		avAccident.setSpeedCanopy(request.getParameter("speed_canopy"));
	}
	if(request.getParameter("aircraft_canopy") !=null && !request.getParameter("aircraft_canopy").equals("")){
		avAccident.setAircraftCanopy(request.getParameter("aircraft_canopy"));
	}
	if(request.getParameter("distance_canopy") !=null && !request.getParameter("distance_canopy").equals("")){
		avAccident.setDistanceCanopy(request.getParameter("distance_canopy"));
	}
	if(request.getParameter("time_emergency_escape") !=null && !request.getParameter("time_emergency_escape").equals("")){
		avAccident.setTimeEmergencyEscape(request.getParameter("time_emergency_escape"));
	}
	if(request.getParameter("altitude_time_escape") !=null && !request.getParameter("altitude_time_escape").equals("")){
		avAccident.setAltitudeTimeEscape(request.getParameter("altitude_time_escape"));
	}
	if(request.getParameter("cabin_immediate_escape") !=null && !request.getParameter("cabin_immediate_escape").equals("")){
		avAccident.setCabinAimmediateEscape(request.getParameter("cabin_immediate_escape"));
	}
	if(request.getParameter("speed_time_escape") !=null && !request.getParameter("speed_time_escape").equals("")){
		avAccident.setSpeedTimeEscape(request.getParameter("speed_time_escape"));
	}
	if(request.getParameter("flightPath_time_escape") !=null && !request.getParameter("flightPath_time_escape").equals("")){
		avAccident.setFlightpathTimeEscape(request.getParameter("flightPath_time_escape"));
	}
	if(request.getParameter("aircraft_time_escape") !=null && !request.getParameter("aircraft_time_escape").equals("")){
		avAccident.setAircraftTimeEscape(request.getParameter("aircraft_time_escape"));
	}
	if(request.getParameter("config_time_escape") !=null && !request.getParameter("config_time_escape").equals("")){
		avAccident.setConfigTimeEscape(request.getParameter("config_time_escape"));
	}
	if(request.getParameter("accele_time_escape") !=null && !request.getParameter("accele_time_escape").equals("")){
		avAccident.setAcceleTimeEscape(request.getParameter("accele_time_escape"));
	}
	if(request.getParameter("accele_time_escape_p") !=null && !request.getParameter("accele_time_escape_p").equals("")){
		avAccident.setEstimedAcceleEscapeP(request.getParameter("accele_time_escape_p"));
	}
	if(request.getParameter("accele_time_escape_n") !=null && !request.getParameter("accele_time_escape_n").equals("")){
		avAccident.setEstimedAcceleEscapeN(request.getParameter("accele_time_escape_n"));
	}
	if(request.getParameter("aircraftUnderControl") !=null && !request.getParameter("aircraftUnderControl").equals("")){
		avAccident.setAircraftControl(request.getParameter("aircraftUnderControl"));
	}
	if(request.getParameter("aircraftFouling") !=null && !request.getParameter("aircraftFouling").equals("")){
		avAccident.setAircraftFouling(request.getParameter("aircraftFouling"));
	}
	if(request.getParameter("remarksAircraftFouling") !=null && !request.getParameter("remarksAircraftFouling").equals("")){
		avAccident.setAircraftFoulingRemark(request.getParameter("remarksAircraftFouling"));
	}
	if(request.getParameter("type_parachute") !=null && !request.getParameter("type_parachute").equals("")){
		avAccident.setTypeParachute(request.getParameter("type_parachute"));
	}
	if(request.getParameter("remarksTypeParachute") !=null && !request.getParameter("remarksTypeParachute").equals("")){
		avAccident.setTypeParachuteRemarks(request.getParameter("remarksTypeParachute"));
	}
	if(request.getParameter("parachute") !=null && !request.getParameter("parachute").equals("")){
		avAccident.setParachute(request.getParameter("parachute"));
	}
	if(request.getParameter("parachuteCanopy") !=null && !request.getParameter("parachuteCanopy").equals("")){
		avAccident.setParachuteCanopy(request.getParameter("parachuteCanopy"));
	}
	if(request.getParameter("parachute_deployment") !=null && !request.getParameter("parachute_deployment").equals("")){
		avAccident.setParachuteDeployment(request.getParameter("parachute_deployment"));
	}
	if(request.getParameter("altitude") !=null && !request.getParameter("altitude").equals("")){
		avAccident.setAltitude(request.getParameter("altitude"));
	}
	if(request.getParameter("parachute_harness") !=null && !request.getParameter("parachute_harness").equals("")){
		avAccident.setParachuteHarness(request.getParameter("parachute_harness"));
	}
	if(request.getParameter("terrain_landing") !=null && !request.getParameter("terrain_landing").equals("")){
		avAccident.setTerrainLanding(request.getParameter("terrain_landing"));
	}
	if(request.getParameter("depth_crater_subject") !=null && !request.getParameter("depth_crater_subject").equals("")){
		avAccident.setDepthCraterSubject(request.getParameter("depth_crater_subject"));
	}
	if(request.getParameter("wind_speed") !=null && !request.getParameter("wind_speed").equals("")){
		avAccident.setWindSpeed(request.getParameter("wind_speed"));
	}
	if(request.getParameter("verticalVisibility") !=null && !request.getParameter("verticalVisibility").equals("")){
		avAccident.setVerticalVisibility(request.getParameter("verticalVisibility"));
	}
	if(request.getParameter("condition_landing") !=null && !request.getParameter("condition_landing").equals("")){
		avAccident.setConditionLanding(request.getParameter("condition_landing"));
	}
	if(request.getParameter("otherConditions") !=null && !request.getParameter("otherConditions").equals("")){
		avAccident.setOtherConditions(request.getParameter("otherConditions"));
	}
	if(request.getParameter("effectiveness_landing") !=null && !request.getParameter("effectiveness_landing").equals("")){
		avAccident.setEffectivenessLanding(request.getParameter("effectiveness_landing"));
	}
	if(request.getParameter("remarksEffectivLanding") !=null && !request.getParameter("remarksEffectivLanding").equals("")){
		avAccident.setEffectivenessLandingRemarks(request.getParameter("remarksEffectivLanding"));
	}
	if(request.getParameter("partBodySustainInitial") !=null && !request.getParameter("partBodySustainInitial").equals("")){
		avAccident.setPartofbodyImpact(request.getParameter("partBodySustainInitial"));
	}
	if(request.getParameter("effectiveness") !=null && !request.getParameter("effectiveness").equals("")){
		avAccident.setEffectiveness(request.getParameter("effectiveness"));
	}
	if(request.getParameter("remarksEffectiveness") !=null && !request.getParameter("remarksEffectiveness").equals("")){
		avAccident.setEffectivenessRemarks(request.getParameter("remarksEffectiveness"));
	}
	if(request.getParameter("casualty_contacted") !=null && !request.getParameter("casualty_contacted").equals("")){
		avAccident.setCasualtyContacted(request.getParameter("casualty_contacted"));
	}
	if(request.getParameter("casualty_incapacitated") !=null && !request.getParameter("casualty_incapacitated").equals("")){
		avAccident.setCasualtyIncapacitated(request.getParameter("casualty_incapacitated"));
	}
	if(request.getParameter("rescued_by") !=null && !request.getParameter("rescued_by").equals("")){
		avAccident.setRescuedBy(request.getParameter("rescued_by"));
	}
	if(request.getParameter("time_scapem_med_treatment") !=null && !request.getParameter("time_scapem_med_treatment").equals("")){
		avAccident.setTimeScapemMedTreatment(request.getParameter("time_scapem_med_treatment"));
	}
	if(request.getParameter("DamageProHelmetMark") !=null && !request.getParameter("DamageProHelmetMark").equals("")){
		avAccident.setDamageProHelmetMark(request.getParameter("DamageProHelmetMark"));
	}
	if(request.getParameter("damage_pro_helmet_status") !=null && !request.getParameter("damage_pro_helmet_status").equals("")){
		avAccident.setDamageProHelmetStatus(request.getParameter("damage_pro_helmet_status"));
	}
	
	if(request.getParameter("damage_pro_helmet_detail") !=null && !request.getParameter("damage_pro_helmet_detail").equals("")){
		avAccident.setDamageProHelmetDetail(request.getParameter("damage_pro_helmet_detail"));
	}
	if(request.getParameter("damage_fly_helmet_mark") !=null && !request.getParameter("damage_fly_helmet_mark").equals("")){
		avAccident.setDamageFlyHelmetMark(request.getParameter("damage_fly_helmet_mark"));
	}
	if(request.getParameter("damage_fly_helmet_status") !=null && !request.getParameter("damage_fly_helmet_status").equals("")){
		avAccident.setDamageFlyHelmetStatus(request.getParameter("damage_fly_helmet_status"));
	}
	if(request.getParameter("damage_fly_helmet_detail") !=null && !request.getParameter("damage_fly_helmet_detail").equals("")){
		avAccident.setDamageFlyHelmetDetail(request.getParameter("damage_fly_helmet_detail"));
	}
	if(request.getParameter("HELMET_Vizor_Mark") !=null && !request.getParameter("HELMET_Vizor_Mark").equals("")){
		avAccident.setHelmetVizorMark(request.getParameter("HELMET_Vizor_Mark"));
	}
	if(request.getParameter("damage_vizor_status") !=null && !request.getParameter("damage_vizor_status").equals("")){
		avAccident.setDamageVizorStatus(request.getParameter("damage_vizor_status"));
	}
	if(request.getParameter("damage_vizor_detail") !=null && !request.getParameter("damage_vizor_detail").equals("")){
		avAccident.setDamageVizorDetail(request.getParameter("damage_vizor_detail"));
	}
	
	if(request.getParameter("damage_life_jkt_detail") !=null && !request.getParameter("damage_life_jkt_detail").equals("")){
		avAccident.setDamageLifeJktDetail(request.getParameter("damage_life_jkt_detail"));
	}
	if(request.getParameter("Equip_life_Jacket_mark") !=null && !request.getParameter("Equip_life_Jacket_mark").equals("")){
		avAccident.setEquipLifeJacketMark(request.getParameter("Equip_life_Jacket_mark"));
	}
	if(request.getParameter("Equip_life_Jacket") !=null && !request.getParameter("Equip_life_Jacket").equals("")){
		avAccident.setEquipLifeJacket(request.getParameter("Equip_life_Jacket"));
	}
	if(request.getParameter("damage_boot_mark") !=null && !request.getParameter("damage_boot_mark").equals("")){
		avAccident.setDamageBootMark(request.getParameter("damage_boot_mark"));
	}
	if(request.getParameter("damage_boot_status") !=null && !request.getParameter("damage_boot_status").equals("")){
		avAccident.setDamageBootStatus(request.getParameter("damage_boot_status"));
	}
	if(request.getParameter("damage_boot_detail") !=null && !request.getParameter("damage_boot_detail").equals("")){
		avAccident.setDamageBootDetail(request.getParameter("damage_boot_detail"));
	}
	if(request.getParameter("damage_oxygen_mark") !=null && !request.getParameter("damage_oxygen_mark").equals("")){
		avAccident.setDamageOxygenMark(request.getParameter("damage_oxygen_mark"));
	}
	if(request.getParameter("damage_oxygen_status") !=null && !request.getParameter("damage_oxygen_status").equals("")){
		avAccident.setDamageOxygenStatus(request.getParameter("damage_oxygen_status"));
	}
	if(request.getParameter("damage_oxygen_detail") !=null && !request.getParameter("damage_oxygen_detail").equals("")){
		avAccident.setDamageOxygenDetail(request.getParameter("damage_oxygen_detail"));
	}
	if(request.getParameter("damage_other_mark") !=null && !request.getParameter("damage_other_mark").equals("")){
		avAccident.setDamageOtherMark(request.getParameter("damage_other_mark"));
	}
	if(request.getParameter("damage_other_status") !=null && !request.getParameter("damage_other_status").equals("")){
		avAccident.setDamageOtherStatus(request.getParameter("damage_other_status"));
	}
	if(request.getParameter("damage_other_detail") !=null && !request.getParameter("damage_other_detail").equals("")){
		avAccident.setDamageOtherDetail(request.getParameter("damage_other_detail"));
	}
	if(request.getParameter("InjuryReceiveEvidence") !=null && !request.getParameter("InjuryReceiveEvidence").equals("")){
		avAccident.setInjuryReceiveEvidence(request.getParameter("InjuryReceiveEvidence"));
	}
	if(request.getParameter("damage_aircraft_in_cocpit") !=null && !request.getParameter("damage_aircraft_in_cocpit").equals("")){
		avAccident.setDamageAircraftInCocpit(request.getParameter("damage_aircraft_in_cocpit"));
	}
	if(request.getParameter("parachute_opening") !=null && !request.getParameter("parachute_opening").equals("")){
		avAccident.setParachuteOpening(request.getParameter("parachute_opening"));
	}
	if(request.getParameter("dragging") !=null && !request.getParameter("dragging").equals("")){
		avAccident.setDragging(request.getParameter("dragging"));
	}
	if(request.getParameter("parachute_fouling_sea") !=null && !request.getParameter("parachute_fouling_sea").equals("")){
		avAccident.setParachuteFoulingSea(request.getParameter("parachute_fouling_sea"));
	}
	if(request.getParameter("other_causes") !=null && !request.getParameter("other_causes").equals("")){
		avAccident.setOtherCauses(request.getParameter("other_causes"));
	}
	if(request.getParameter("pre_escape") !=null && !request.getParameter("pre_escape").equals("")){
		avAccident.setPreEscape(HMSUtil.convertStringTypeDateToDateType(request.getParameter("pre_escape")));
	}
	if(request.getParameter("pre_escape_degree") !=null && !request.getParameter("pre_escape_degree").equals("")){
		avAccident.setPreEscapeDegree(request.getParameter("pre_escape_degree"));
	}
	if(request.getParameter("forced_landing_ditching") !=null && !request.getParameter("forced_landing_ditching").equals("")){
		avAccident.setForcedLandingDitching(request.getParameter("forced_landing_ditching"));
	}
	
	if(request.getParameter("unassisted_escape") !=null && !request.getParameter("unassisted_escape").equals("")){
		avAccident.setUnassistedEscape(request.getParameter("unassisted_escape"));
	}
	if(request.getParameter("ejection_seat_escape") !=null && !request.getParameter("ejection_seat_escape").equals("")){
		avAccident.setEjectionSeatEscape(request.getParameter("ejection_seat_escape"));
	}
	if (request.getParameter(LAST_CHANGED_BY) != null)
	{	avAccident.setLastChgBy(request.getParameter(LAST_CHANGED_BY));
	}
	if (request.getParameter(LAST_CHANGED_DATE) != null)
	{
		avAccident.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(LAST_CHANGED_DATE)));
	}
	if (request.getParameter(LAST_CHANGED_TIME) != null)
	{	avAccident.setLastChgTime(request.getParameter(LAST_CHANGED_TIME));
	}
	String flag="";
	if(request.getParameter("flag") !=null && !request.getParameter("flag").equals("")){
		flag=request.getParameter("flag");
	}
	infoMap.put("avAccident", avAccident);
	boolean saved = false;
	map = aviationMedicineHandlerService.submitEquipmentFactors(infoMap);
	if (map.get("saved") != null) {
		saved = (Boolean) map.get("saved");
	}
	if (saved) {
		message = "Data saved Successfully !!";
	} else {
		message = "Try Again!";
	}
	int avAccidentIdd=0;
	if(map.get("avAccidentIdd") !=null){
		avAccidentIdd=(Integer)map.get("avAccidentIdd");
	}
	map.put("message", message);
	url = "/hms/hms/aviationMedicine?method=showAnUnassistedEscapeFromAnAircraftInFlightJsp";
	jsp = AV_MESSAGE + ".jsp";
	
	map.put("avAccidentId", avAccidentIdd);
	map.put("flag", flag);
	map.put("url", url);
	map.put("message", message);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
public ModelAndView submitUseEjectionSeat(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	infoMap.put("box", box);
	String url="";
	String message="";
	AvAccident avAccident = new AvAccident();
	int avAccidentId=0;
	if(request.getParameter("avAccidentId") !=null && !request.getParameter("avAccidentId").equals("")){
		avAccidentId=Integer.parseInt(request.getParameter("avAccidentId"));
	avAccident = aviationMedicineHandlerService.loadAviationAccident(avAccidentId);
	}
	if (session.getAttribute(HOSPITAL_ID) != null) 
	{
		MasHospital masHospital=new MasHospital();
		masHospital.setId((Integer)session.getAttribute(HOSPITAL_ID));
		avAccident.setHospital(masHospital);
		
	}
	if (session.getAttribute("deptId") != null) 
	{
		MasDepartment masDept=new MasDepartment();
		masDept.setId((Integer)session.getAttribute("deptId"));
		avAccident.setDepartment(masDept);
		
	}
	//-----------For Person Detail--Block--
	if(request.getParameter(SERVICE_NO) !=null && !request.getParameter(SERVICE_NO).equals("")){
		avAccident.setServiceNo(request.getParameter(SERVICE_NO));
	}
	if(request.getParameter(FIRST_NAME) !=null && !request.getParameter(FIRST_NAME).equals("")){
		avAccident.setFirstName(request.getParameter(FIRST_NAME));
	}
	if(request.getParameter("surname") !=null && !request.getParameter("surname").equals("")){
		avAccident.setSurname(request.getParameter("surname"));
	}
	if(request.getParameter("crewDuty") !=null && !request.getParameter("crewDuty").equals("")){
		avAccident.setCrewDuty(request.getParameter("crewDuty"));
	}
	if(request.getParameter("hinId") !=null && !request.getParameter("hinId").equals("")){
		Patient patient=new Patient();
		patient.setId(Integer.parseInt(request.getParameter("hinId")));
		avAccident.setHin(patient);
	}
	if(request.getParameter(RANK_ID) !=null && !request.getParameter(RANK_ID).equals("0")){
		MasRank masRank=new MasRank();
		masRank.setId(Integer.parseInt(request.getParameter(RANK_ID)));
		avAccident.setRank(masRank);
	}
	
	infoMap.put("avAccidentId",avAccidentId);
	if(request.getParameter("voluntaryEjection") !=null && !request.getParameter("voluntaryEjection").equals("")){
		avAccident.setVoluntaryEjection(request.getParameter("voluntaryEjection"));
	}
	if(request.getParameter("voluntaryEjectionOne") !=null && !request.getParameter("voluntaryEjectionOne").equals("")){
		avAccident.setVolunatrySubject(request.getParameter("voluntaryEjectionOne"));
	}
	
	if(request.getParameter("evidenceEjectionSeat") !=null && !request.getParameter("evidenceEjectionSeat").equals("")){
		avAccident.setEvidenceEjectionSeat(request.getParameter("evidenceEjectionSeat"));
	}
	if(request.getParameter("remarksEvidenceEjection") !=null && !request.getParameter("remarksEvidenceEjection").equals("")){
		avAccident.setEvidenceEjectionReamrks(request.getParameter("remarksEvidenceEjection"));
	}
	if(request.getParameter("distressCalls") !=null && !request.getParameter("distressCalls").equals("")){
		avAccident.setDistressCalls(request.getParameter("distressCalls"));
	}
	if(request.getParameter("remarksDistressCalls") !=null && !request.getParameter("remarksDistressCalls").equals("")){
		avAccident.setDistressCallApplicable(request.getParameter("remarksDistressCalls"));
	}
	if(request.getParameter("damageAircraftPrior") !=null && !request.getParameter("damageAircraftPrior").equals("")){
		avAccident.setDamageAircraftPrior(request.getParameter("damageAircraftPrior"));
	}
	if(request.getParameter("remarksDamageAircraft") !=null && !request.getParameter("remarksDamageAircraft").equals("")){
		avAccident.setDamageAircraftPriorRemarks(request.getParameter("remarksDamageAircraft"));
	}
	if(request.getParameter("damageToSeatEjection") !=null && !request.getParameter("damageToSeatEjection").equals("")){
		avAccident.setDamageSeatEjection(request.getParameter("damageToSeatEjection"));
	}
	if(request.getParameter("appliDamageToSeatEjection") !=null && !request.getParameter("appliDamageToSeatEjection").equals("")){
		avAccident.setDamageSeatEjectionAppli(request.getParameter("appliDamageToSeatEjection"));
	}
	if(request.getParameter("canopyHatchJettison") !=null && !request.getParameter("canopyHatchJettison").equals("")){
		avAccident.setCanopyJettison(request.getParameter("canopyHatchJettison"));
	}
	
	if(request.getParameter("remarksCanopyHatchJettison") !=null && !request.getParameter("remarksCanopyHatchJettison").equals("")){
		avAccident.setCanopyJettisonReamrks(request.getParameter("remarksCanopyHatchJettison"));
	}
	if(request.getParameter("attitudeAtCanopyJettison") !=null && !request.getParameter("attitudeAtCanopyJettison").equals("")){
		avAccident.setAttitudeCanopy(request.getParameter("attitudeAtCanopyJettison"));
	}
	if(request.getParameter("speed_canopy") !=null && !request.getParameter("speed_canopy").equals("")){
		avAccident.setSpeedCanopy(request.getParameter("speed_canopy"));
	}
	
	if(request.getParameter("distanceOfCanopyWreekage") !=null && !request.getParameter("distanceOfCanopyWreekage").equals("")){
		avAccident.setDistanceCanopy(request.getParameter("distanceOfCanopyWreekage"));
	}
	if(request.getParameter("deliberateDelayEjection") !=null && !request.getParameter("deliberateDelayEjection").equals("")){
		avAccident.setDeliberateDelayEjection(request.getParameter("deliberateDelayEjection"));
	}
	if(request.getParameter("remarksDeliberateDelay") !=null && !request.getParameter("remarksDeliberateDelay").equals("")){
		avAccident.setDeliberateDelayRemarks(request.getParameter("remarksDeliberateDelay"));
	}
	if(request.getParameter("time_emergency_ejection") !=null && !request.getParameter("time_emergency_ejection").equals("")){
		avAccident.setTimeEmergencyEjection(request.getParameter("time_emergency_ejection"));
	}
	if(request.getParameter("altitudeEjection") !=null && !request.getParameter("altitudeEjection").equals("")){
		avAccident.setAltitudeEjection(request.getParameter("altitudeEjection"));
	}
	if(request.getParameter("Altitude_immediate_ejection") !=null && !request.getParameter("Altitude_immediate_ejection").equals("")){
		avAccident.setSpeedTimeEscape(request.getParameter("Altitude_immediate_ejection"));
	}
	if(request.getParameter("speedAtTimeEjection") !=null && !request.getParameter("speedAtTimeEjection").equals("")){
		avAccident.setSpeedTimeEjection(request.getParameter("speedAtTimeEjection"));
	}
	if(request.getParameter("aircraftAttitudeEjection") !=null && !request.getParameter("aircraftAttitudeEjection").equals("")){
		avAccident.setAircraftAttitudeEject(request.getParameter("aircraftAttitudeEjection"));
	}
	if(request.getParameter("aircraftAttitudeEjectionOne") !=null && !request.getParameter("aircraftAttitudeEjectionOne").equals("")){
		avAccident.setAircraftAttitudeEject1(request.getParameter("aircraftAttitudeEjectionOne"));
	}
	if(request.getParameter("aircraftAttitudeEjectionTwo") !=null && !request.getParameter("aircraftAttitudeEjectionTwo").equals("")){
		avAccident.setAircraftAttitudeEject2(request.getParameter("aircraftAttitudeEjectionTwo"));
	}
	if(request.getParameter("accelrAircraftTimeEjection") !=null && !request.getParameter("accelrAircraftTimeEjection").equals("")){
		avAccident.setAccelrAircraftTimeEjection(request.getParameter("accelrAircraftTimeEjection"));
	}
	if(request.getParameter("accelrAircraftEstimate") !=null && !request.getParameter("accelrAircraftEstimate").equals("")){
		avAccident.setAccelrAircraftEstimate(request.getParameter("accelrAircraftEstimate"));
	}
	if(request.getParameter("aircraftUndercontrolEjection") !=null && !request.getParameter("aircraftUndercontrolEjection").equals("")){
		avAccident.setAircraftUndercontrolEjection(request.getParameter("aircraftUndercontrolEjection"));
	}
	if(request.getParameter("typeOfSeat") !=null && !request.getParameter("typeOfSeat").equals("")){
		avAccident.setSeatType(request.getParameter("typeOfSeat"));
	}
	if(request.getParameter("typeSurvivalPack") !=null && !request.getParameter("typeSurvivalPack").equals("")){
		avAccident.setSeatType(request.getParameter("typeSurvivalPack"));
	}
	if(request.getParameter("typeCushion") !=null && !request.getParameter("typeCushion").equals("")){
		avAccident.setSeatCushion(request.getParameter("typeCushion"));
	}
	if(request.getParameter("noted") !=null && !request.getParameter("noted").equals("")){
		avAccident.setSeatNote(request.getParameter("noted"));
	}
	if(request.getParameter("seatFiring") !=null && !request.getParameter("seatFiring").equals("")){
		avAccident.setSeatFiring(request.getParameter("seatFiring"));
	}
	if(request.getParameter("alernativeSeatRemark") !=null && !request.getParameter("alernativeSeatRemark").equals("")){
		avAccident.setSeatRemarks(request.getParameter("alernativeSeatRemark"));
	}
	if(request.getParameter("legRestraint") !=null && !request.getParameter("legRestraint").equals("")){
		avAccident.setLegRestraint(request.getParameter("legRestraint"));
	}
	if(request.getParameter("aircraftFouling") !=null && !request.getParameter("aircraftFouling").equals("")){
		avAccident.setAircraftFouling(request.getParameter("aircraftFouling"));
	}
	if(request.getParameter("foulingOtherAircraft") !=null && !request.getParameter("foulingOtherAircraft").equals("")){
		avAccident.setFoulingOtherAircraft(request.getParameter("foulingOtherAircraft"));
	}
	if(request.getParameter("aircraftFoulingOne") !=null && !request.getParameter("aircraftFoulingOne").equals("")){
		avAccident.setFoulingOtherPart(request.getParameter("aircraftFoulingOne"));
	}
	if(request.getParameter("remarksAircraftFoulingOne") !=null && !request.getParameter("remarksAircraftFoulingOne").equals("")){
		avAccident.setFoulingOtherRemarks(request.getParameter("remarksAircraftFoulingOne"));
	}
	if(request.getParameter("delayDrogueGunSeparation") !=null && !request.getParameter("delayDrogueGunSeparation").equals("")){
		avAccident.setDelayDrogueGun(request.getParameter("delayDrogueGunSeparation"));
	}
	if(request.getParameter("gStopSetting") !=null && !request.getParameter("gStopSetting").equals("")){
		avAccident.setGStopSetting(request.getParameter("gStopSetting"));
	}
	if(request.getParameter("scissorShackle") !=null && !request.getParameter("scissorShackle").equals("")){
		avAccident.setScissorShackle(request.getParameter("scissorShackle"));
	}
	if(request.getParameter("scissorShackleRemarks") !=null && !request.getParameter("scissorShackleRemarks").equals("")){
		avAccident.setScissorShackleRemarks(request.getParameter("scissorShackleRemarks"));
	}
	if(request.getParameter("headRest") !=null && !request.getParameter("headRest").equals("")){
		avAccident.setHeadRest(request.getParameter("headRest"));
	}
	if(request.getParameter("remarksHeadRest") !=null && !request.getParameter("remarksHeadRest").equals("")){
		avAccident.setHeadRestRemarks(request.getParameter("remarksHeadRest"));
	}
	if(request.getParameter("seatHarness") !=null && !request.getParameter("seatHarness").equals("")){
		avAccident.setSeatHarness(request.getParameter("seatHarness"));
	}
	if(request.getParameter("remarksSeatHarness") !=null && !request.getParameter("remarksSeatHarness").equals("")){
		avAccident.setSeatHarnessRemarks(request.getParameter("remarksSeatHarness"));
	}
	if(request.getParameter("altitudeAtSeparationRequired") !=null && !request.getParameter("altitudeAtSeparationRequired").equals("")){
		avAccident.setAltSeparationRequired(request.getParameter("altitudeAtSeparationRequired"));
	}
	if(request.getParameter("separationManual") !=null && !request.getParameter("separationManual").equals("")){
		avAccident.setManualSeparation(request.getParameter("separationManual"));
	}
	if(request.getParameter("remarksSeparationManual") !=null && !request.getParameter("remarksSeparationManual").equals("")){
		avAccident.setManualSeparationRemarks(request.getParameter("remarksSeparationManual"));
	}
	if(request.getParameter("manualAltSeparation") !=null && !request.getParameter("manualAltSeparation").equals("")){
		avAccident.setManualAltSeparation(request.getParameter("manualAltSeparation"));
	}
	if(request.getParameter("automatic") !=null && !request.getParameter("automatic").equals("")){
		avAccident.setAutomatic(request.getParameter("automatic"));
	}
	if(request.getParameter("specifyAutomatic") !=null && !request.getParameter("specifyAutomatic").equals("")){
		avAccident.setAutomaticSpecify(request.getParameter("specifyAutomatic"));
	}
	if(request.getParameter("manualOperationRequCheck") !=null && !request.getParameter("manualOperationRequCheck").equals("")){
		avAccident.setManualOperReq(request.getParameter("manualOperationRequCheck"));
	}
	
	if(request.getParameter("manualOperCombo") !=null && !request.getParameter("manualOperCombo").equals("")){
		avAccident.setManualOperCombo(request.getParameter("manualOperCombo"));
	}
	if(request.getParameter("manualOperComboSpecify") !=null && !request.getParameter("manualOperComboSpecify").equals("")){
		avAccident.setFailureSpecify(request.getParameter("manualOperComboSpecify"));
	}
	if(request.getParameter("altitudeParachuteDeployment") !=null && !request.getParameter("altitudeParachuteDeployment").equals("")){
		avAccident.setParachuteDeployment(request.getParameter("altitudeParachuteDeployment"));
	}
	if(request.getParameter("distanceSeatGround") !=null && !request.getParameter("distanceSeatGround").equals("")){
		avAccident.setDistanceSeatGround(request.getParameter("distanceSeatGround"));
	}
	if(request.getParameter("parachuteCanopy") !=null && !request.getParameter("parachuteCanopy").equals("")){
		avAccident.setParachuteCanopy(request.getParameter("parachuteCanopy"));
	}
	if(request.getParameter("deployment") !=null && !request.getParameter("deployment").equals("")){
		avAccident.setParachuteDeployment1(request.getParameter("deployment"));
	}
	if(request.getParameter("deploymentOne") !=null && !request.getParameter("deploymentOne").equals("")){
		avAccident.setDeployParaDamage(request.getParameter("deploymentOne"));
	}
	
	if(request.getParameter("parachuteHarness") !=null && !request.getParameter("parachuteHarness").equals("")){
		avAccident.setParachuteHarness(request.getParameter("parachuteHarness"));
	}
	if(request.getParameter("releasBoxModification") !=null && !request.getParameter("releasBoxModification").equals("")){
		avAccident.setReleasBoxModification(request.getParameter("releasBoxModification"));
	}
	if(request.getParameter("specifyTypeOfModification") !=null && !request.getParameter("specifyTypeOfModification").equals("")){
		avAccident.setReleasBoxModifiy2(request.getParameter("specifyTypeOfModification"));
	}
	if(request.getParameter("descritptionOfHarness") !=null && !request.getParameter("descritptionOfHarness").equals("")){
		avAccident.setHarnessOverridesReleasebox(request.getParameter("descritptionOfHarness"));
	}
	if(request.getParameter("terrainForLanding") !=null && !request.getParameter("terrainForLanding").equals("")){
		avAccident.setTerrainLanding(request.getParameter("terrainForLanding"));
	}
	if(request.getParameter("specifyTerrainForLanding") !=null && !request.getParameter("specifyTerrainForLanding").equals("")){
		avAccident.setTerrainSpecify(request.getParameter("specifyTerrainForLanding"));
	}
	if(request.getParameter("depthOfCraterMadeBySubject") !=null && !request.getParameter("depthOfCraterMadeBySubject").equals("")){
		avAccident.setDepthCraterSubject(request.getParameter("depthOfCraterMadeBySubject"));
	}
	if(request.getParameter("wind_speed") !=null && !request.getParameter("wind_speed").equals("")){
		avAccident.setWindSpeed(request.getParameter("wind_speed"));
	}
	if(request.getParameter("verticalVisibility") !=null && !request.getParameter("verticalVisibility").equals("")){
		avAccident.setVerticalVisibility(request.getParameter("verticalVisibility"));
	}
	if(request.getParameter("condition_landing") !=null && !request.getParameter("condition_landing").equals("")){
		avAccident.setConditionLanding(request.getParameter("condition_landing"));
	}
	if(request.getParameter("otherConditions") !=null && !request.getParameter("otherConditions").equals("")){
		avAccident.setOtherConditions(request.getParameter("otherConditions"));
	}
	if(request.getParameter("effectiveness_landing") !=null && !request.getParameter("effectiveness_landing").equals("")){
		avAccident.setEffectivenessLanding(request.getParameter("effectiveness_landing"));
	}
	if(request.getParameter("effectivenessOfLandingOne") !=null && !request.getParameter("effectivenessOfLandingOne").equals("")){
		avAccident.setEffectivenessLanding1(request.getParameter("effectivenessOfLandingOne"));
	}
	if(request.getParameter("effectivenessOfLandingTwo") !=null && !request.getParameter("effectivenessOfLandingTwo").equals("")){
		avAccident.setEffectivenessLanding2(request.getParameter("effectivenessOfLandingTwo"));
	}
	if(request.getParameter("partofbodyImpact") !=null && !request.getParameter("partofbodyImpact").equals("")){
		avAccident.setPartofbodyImpact(request.getParameter("partofbodyImpact"));
	}
	if(request.getParameter("effectiveness") !=null && !request.getParameter("effectiveness").equals("")){
		avAccident.setEffectiveness(request.getParameter("effectiveness"));
	}
	if(request.getParameter("remarksEffectiveness") !=null && !request.getParameter("remarksEffectiveness").equals("")){
		avAccident.setEffectivenessRemarks(request.getParameter("remarksEffectiveness"));
	}
	if(request.getParameter("DamageProHelmetMark") !=null && !request.getParameter("DamageProHelmetMark").equals("")){
		avAccident.setDamageProHelmetMark(request.getParameter("DamageProHelmetMark"));
	}
	if(request.getParameter("damage_pro_helmet_status") !=null && !request.getParameter("damage_pro_helmet_status").equals("")){
		avAccident.setDamageProHelmetStatus(request.getParameter("damage_pro_helmet_status"));
	}
	
	if(request.getParameter("damage_pro_helmet_detail") !=null && !request.getParameter("damage_pro_helmet_detail").equals("")){
		avAccident.setDamageProHelmetDetail(request.getParameter("damage_pro_helmet_detail"));
	}
	if(request.getParameter("damage_fly_helmet_mark") !=null && !request.getParameter("damage_fly_helmet_mark").equals("")){
		avAccident.setDamageFlyHelmetMark(request.getParameter("damage_fly_helmet_mark"));
	}
	if(request.getParameter("damage_fly_helmet_status") !=null && !request.getParameter("damage_fly_helmet_status").equals("")){
		avAccident.setDamageFlyHelmetStatus(request.getParameter("damage_fly_helmet_status"));
	}
	if(request.getParameter("damage_fly_helmet_detail") !=null && !request.getParameter("damage_fly_helmet_detail").equals("")){
		avAccident.setDamageFlyHelmetDetail(request.getParameter("damage_fly_helmet_detail"));
	}
	if(request.getParameter("HELMET_Vizor_Mark") !=null && !request.getParameter("HELMET_Vizor_Mark").equals("")){
		avAccident.setHelmetVizorMark(request.getParameter("HELMET_Vizor_Mark"));
	}
	if(request.getParameter("damage_vizor_status") !=null && !request.getParameter("damage_vizor_status").equals("")){
		avAccident.setDamageVizorStatus(request.getParameter("damage_vizor_status"));
	}
	if(request.getParameter("damage_vizor_detail") !=null && !request.getParameter("damage_vizor_detail").equals("")){
		avAccident.setDamageVizorDetail(request.getParameter("damage_vizor_detail"));
	}
	
	if(request.getParameter("damage_life_jkt_detail") !=null && !request.getParameter("damage_life_jkt_detail").equals("")){
		avAccident.setDamageLifeJktDetail(request.getParameter("damage_life_jkt_detail"));
	}
	if(request.getParameter("Equip_life_Jacket_mark") !=null && !request.getParameter("Equip_life_Jacket_mark").equals("")){
		avAccident.setEquipLifeJacketMark(request.getParameter("Equip_life_Jacket_mark"));
	}
	if(request.getParameter("Equip_life_Jacket") !=null && !request.getParameter("Equip_life_Jacket").equals("")){
		avAccident.setEquipLifeJacket(request.getParameter("Equip_life_Jacket"));
	}
	if(request.getParameter("damage_boot_mark") !=null && !request.getParameter("damage_boot_mark").equals("")){
		avAccident.setDamageBootMark(request.getParameter("damage_boot_mark"));
	}
	if(request.getParameter("damage_boot_status") !=null && !request.getParameter("damage_boot_status").equals("")){
		avAccident.setDamageBootStatus(request.getParameter("damage_boot_status"));
	}
	if(request.getParameter("damage_boot_detail") !=null && !request.getParameter("damage_boot_detail").equals("")){
		avAccident.setDamageBootDetail(request.getParameter("damage_boot_detail"));
	}
	if(request.getParameter("damage_oxygen_mark") !=null && !request.getParameter("damage_oxygen_mark").equals("")){
		avAccident.setDamageOxygenMark(request.getParameter("damage_oxygen_mark"));
	}
	if(request.getParameter("damage_oxygen_status") !=null && !request.getParameter("damage_oxygen_status").equals("")){
		avAccident.setDamageOxygenStatus(request.getParameter("damage_oxygen_status"));
	}
	if(request.getParameter("damage_oxygen_detail") !=null && !request.getParameter("damage_oxygen_detail").equals("")){
		avAccident.setDamageOxygenDetail(request.getParameter("damage_oxygen_detail"));
	}
	if(request.getParameter("damage_other_mark") !=null && !request.getParameter("damage_other_mark").equals("")){
		avAccident.setDamageOtherMark(request.getParameter("damage_other_mark"));
	}
	if(request.getParameter("damage_other_status") !=null && !request.getParameter("damage_other_status").equals("")){
		avAccident.setDamageOtherStatus(request.getParameter("damage_other_status"));
	}
	if(request.getParameter("damage_other_detail") !=null && !request.getParameter("damage_other_detail").equals("")){
		avAccident.setDamageOtherDetail(request.getParameter("damage_other_detail"));
	}
	if(request.getParameter("casualtyContacted") !=null && !request.getParameter("casualtyContacted").equals("")){
		avAccident.setCasualtyContacted(request.getParameter("casualtyContacted"));
	}
	if(request.getParameter("casualtyIncapacitated") !=null && !request.getParameter("casualtyIncapacitated").equals("")){
		avAccident.setCasualtyIncapacitated(request.getParameter("casualtyIncapacitated"));
	}
	if(request.getParameter("casualtyContacted") !=null && !request.getParameter("casualtyContacted").equals("")){
		avAccident.setCasualtyContacted(request.getParameter("casualtyContacted"));
	}
	if(request.getParameter("rescued_by") !=null && !request.getParameter("rescued_by").equals("")){
		avAccident.setRescuedBy(request.getParameter("rescued_by"));
	}
	if(request.getParameter("time_scapem_med_treatment") !=null && !request.getParameter("time_scapem_med_treatment").equals("")){
		avAccident.setTimeScapemMedTreatment(request.getParameter("time_scapem_med_treatment"));
	}
	if(request.getParameter("damage_aircraft_in_cocpit") !=null && !request.getParameter("damage_aircraft_in_cocpit").equals("")){
		avAccident.setDamageAircraftInCocpit(request.getParameter("damage_aircraft_in_cocpit"));
	}
	if(request.getParameter("aircraft_fouling") !=null && !request.getParameter("aircraft_fouling").equals("")){
		avAccident.setInjuryAircraftFouling(request.getParameter("aircraft_fouling"));
	}
	if(request.getParameter("acceleration_seat") !=null && !request.getParameter("acceleration_seat").equals("")){
		avAccident.setAccelerationSeat(request.getParameter("acceleration_seat"));
	}
	if(request.getParameter("air_blast") !=null && !request.getParameter("air_blast").equals("")){
		avAccident.setAirBlast(request.getParameter("air_blast"));
	}
	if(request.getParameter("parachute_opening") !=null && !request.getParameter("parachute_opening").equals("")){
		avAccident.setParachuteOpening(request.getParameter("parachute_opening"));
	}
	if(request.getParameter("dragging") !=null && !request.getParameter("dragging").equals("")){
		avAccident.setDragging(request.getParameter("dragging"));
	}
	if(request.getParameter("ground_impact") !=null && !request.getParameter("ground_impact").equals("")){
		avAccident.setInjuriesGroundImpact(request.getParameter("ground_impact"));
	}
	if(request.getParameter("other_causes") !=null && !request.getParameter("other_causes").equals("")){
		avAccident.setOtherCauses(request.getParameter("other_causes"));
	}
	if(request.getParameter("training_ejection_seat") !=null && !request.getParameter("training_ejection_seat").equals("")){
		avAccident.setTrainingEjectionSeat(request.getParameter("training_ejection_seat"));
	}
	if(request.getParameter("parachute_training") !=null && !request.getParameter("parachute_training").equals("")){
		avAccident.setParachuteTraining(request.getParameter("parachute_training"));
	}
	
	if(request.getParameter("forced_landing_ditching") !=null && !request.getParameter("forced_landing_ditching").equals("")){
		avAccident.setForcedLandingDitching(request.getParameter("forced_landing_ditching"));
	}
	if(request.getParameter("unassisted_escape") !=null && !request.getParameter("unassisted_escape").equals("")){
		avAccident.setUnassistedEscape(request.getParameter("unassisted_escape"));
	}
	
	if(request.getParameter("ejection_seat_escape") !=null && !request.getParameter("ejection_seat_escape").equals("")){
		avAccident.setEjectionSeatEscape(request.getParameter("ejection_seat_escape"));
	}
	if(request.getParameter("speed_impact") !=null && !request.getParameter("speed_impact").equals("")){
		avAccident.setSpeedImpact(request.getParameter("speed_impact"));
	}
	if(request.getParameter("depth_water") !=null && !request.getParameter("depth_water").equals("")){
		avAccident.setDepthWater(request.getParameter("depth_water"));
	}
	if(request.getParameter("aircraft_alt_impact") !=null && !request.getParameter("aircraft_alt_impact").equals("")){
		avAccident.setAircraftAltImpact(request.getParameter("aircraft_alt_impact"));
	}
	if(request.getParameter("no_flooding") !=null && !request.getParameter("no_flooding").equals("")){
		avAccident.setNoFlooding(request.getParameter("no_flooding"));
	}
	if(request.getParameter("flooding_of") !=null && !request.getParameter("flooding_of").equals("")){
		avAccident.setFloodingOf(request.getParameter("flooding_of"));
	}
	
	if(request.getParameter("degree_result_of") !=null && !request.getParameter("degree_result_of").equals("")){
		avAccident.setDegreeResultOf(request.getParameter("degree_result_of"));
	}
	if(request.getParameter("canopy") !=null && !request.getParameter("canopy").equals("")){
		avAccident.setCanopy(request.getParameter("canopy"));
	}
	if(request.getParameter("voluntaryJettison") !=null && !request.getParameter("voluntaryJettison").equals("")){
		avAccident.setVoluntaryJettison(request.getParameter("voluntaryJettison"));
	}
	if(request.getParameter("secureUntilPenetrated") !=null && !request.getParameter("secureUntilPenetrated").equals("")){
		avAccident.setSecureUntilPenetrated(request.getParameter("secureUntilPenetrated"));
	}
	if(request.getParameter("blind_linked_jettison") !=null && !request.getParameter("blind_linked_jettison").equals("")){
		avAccident.setBlindLinkedJettison(request.getParameter("blind_linked_jettison"));
	}
	if(request.getParameter("difficult_observa_canopy") !=null && !request.getParameter("difficult_observa_canopy").equals("")){
		avAccident.setDifficultyObservationCanopy(request.getParameter("difficult_observa_canopy"));
	}
	
	if(request.getParameter("delay_ejection") !=null && !request.getParameter("delay_ejection").equals("")){
		avAccident.setDelayEjection(request.getParameter("delay_ejection"));
	}
	if(request.getParameter("reason_delay") !=null && !request.getParameter("reason_delay").equals("")){
		avAccident.setReasonDelay(request.getParameter("reason_delay"));
	}
	if(request.getParameter("extend_delay") !=null && !request.getParameter("extend_delay").equals("")){
		avAccident.setExtendDelay(request.getParameter("extend_delay"));
	}
	if(request.getParameter("estimated_depth") !=null && !request.getParameter("estimated_depth").equals("")){
		avAccident.setEstimatedDepth(request.getParameter("estimated_depth"));
	}
	if(request.getParameter("ejection") !=null && !request.getParameter("ejection").equals("")){
		avAccident.setEjection(request.getParameter("ejection"));
	}
	if(request.getParameter("ejection_specify") !=null && !request.getParameter("ejection_specify").equals("")){
		avAccident.setEjectionSpecify(request.getParameter("ejection_specify"));
	}
	
	if(request.getParameter("noRotation") !=null && !request.getParameter("noRotation").equals("")){
		avAccident.setNoRotation(request.getParameter("noRotation"));
	}
	if(request.getParameter("rotationOf") !=null && !request.getParameter("rotationOf").equals("")){
		avAccident.setRotation(request.getParameter("rotationOf"));
	}
	if(request.getParameter("rotationOf2") !=null && !request.getParameter("rotationOf2").equals("")){
		avAccident.setRotationOf(request.getParameter("rotationOf2"));
	}
	if(request.getParameter("resubmerged") !=null && !request.getParameter("resubmerged").equals("")){
		avAccident.setResubmerged(request.getParameter("resubmerged"));
	}
	if(request.getParameter("resubmerged_consciousnes") !=null && !request.getParameter("resubmerged_consciousnes").equals("")){
		avAccident.setResubmergedConsciousnes(request.getParameter("resubmerged_consciousnes"));
	}
	if(request.getParameter("manualReleaseEjection") !=null && !request.getParameter("manualReleaseEjection").equals("")){
		avAccident.setManualReleaseEjection(request.getParameter("manualReleaseEjection"));
	}
	if(request.getParameter("associateHarnessRelease") !=null && !request.getParameter("associateHarnessRelease").equals("")){
		avAccident.setAssociateHarnessRelease(request.getParameter("associateHarnessRelease"));
	}
	
	if(request.getParameter("parachute_harness_ragging") !=null && !request.getParameter("parachute_harness_ragging").equals("")){
		avAccident.setParachuteHarnessRagging(request.getParameter("parachute_harness_ragging"));
	}
	if(request.getParameter("parachute_harness") !=null && !request.getParameter("parachute_harness").equals("")){
		avAccident.setParachuteHarness(request.getParameter("parachute_harness"));
	}
	if(request.getParameter("parachute_harness2") !=null && !request.getParameter("parachute_harness2").equals("")){
		avAccident.setParachuteHarness2(request.getParameter("parachute_harness2"));
	}
	if(request.getParameter("lifeJacket") !=null && !request.getParameter("lifeJacket").equals("")){
		avAccident.setEjectionLifeJacket(request.getParameter("lifeJacket"));
	}
	if(request.getParameter("dinghy") !=null && !request.getParameter("dinghy").equals("")){
		avAccident.setDinghy(request.getParameter("dinghy"));
	}
	if(request.getParameter("dinghyUsed") !=null && !request.getParameter("dinghyUsed").equals("")){
		avAccident.setDinghyUsed(request.getParameter("dinghyUsed"));
	}
	if(request.getParameter("timeEjectionSurface") !=null && !request.getParameter("timeEjectionSurface").equals("")){
		avAccident.setTimeEjectionSurface(request.getParameter("timeEjectionSurface"));
	}
	if(request.getParameter("breath_experience") !=null && !request.getParameter("breath_experience").equals("")){
		avAccident.setBreathExperience(request.getParameter("breath_experience"));
	}
	
	if(request.getParameter("survival") !=null && !request.getParameter("survival").equals("")){
		avAccident.setSurvival(request.getParameter("survival"));
	}
	if(request.getParameter("disabilities_underwater") !=null && !request.getParameter("disabilities_underwater").equals("")){
		avAccident.setDisabilitiesUnderwater(request.getParameter("disabilities_underwater"));
	}
	if(request.getParameter("pre_train_exp_underwater") !=null && !request.getParameter("pre_train_exp_underwater").equals("")){
		avAccident.setPreTrainExpUnderwater(request.getParameter("pre_train_exp_underwater"));
	}
	if (request.getParameter(LAST_CHANGED_BY) != null)
	{	avAccident.setLastChgBy(request.getParameter(LAST_CHANGED_BY));
	}
	if (request.getParameter(LAST_CHANGED_DATE) != null)
	{
		avAccident.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(LAST_CHANGED_DATE)));
	}
	if (request.getParameter(LAST_CHANGED_TIME) != null)
	{	avAccident.setLastChgTime(request.getParameter(LAST_CHANGED_TIME));
	}
	String flag="";
	if(request.getParameter("flag") !=null && !request.getParameter("flag").equals("")){
		flag=request.getParameter("flag");
	}
	infoMap.put("avAccident", avAccident);
	boolean saved = false;
	map = aviationMedicineHandlerService.submitEquipmentFactors(infoMap);
	if (map.get("saved") != null) {
		saved = (Boolean) map.get("saved");
	}
	if (saved) {
		message = "Data saved Successfully !!";
	} else {
		message = "Try Again!";
	}
	int avAccidentIdd=0;
	if(map.get("avAccidentIdd") !=null){
		avAccidentIdd=(Integer)map.get("avAccidentIdd");
	}
	map.put("message", message);
	url = "/hms/hms/aviationMedicine?method=showUseOfEjectionSeatJsp";
	jsp = AV_MESSAGE + ".jsp";
    map.put("avAccidentId", avAccidentIdd);
	map.put("flag", flag);
	map.put("url", url);
	map.put("message", message);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
public ModelAndView submitSurvivalAircraftAccident(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	infoMap.put("box", box);
	String url="";
	String message="";
	AvAccident avAccident = new AvAccident();
	int avAccidentId=0;
	if(request.getParameter("avAccidentId") !=null && !request.getParameter("avAccidentId").equals("")){
		avAccidentId=Integer.parseInt(request.getParameter("avAccidentId"));
	avAccident = aviationMedicineHandlerService.loadAviationAccident(avAccidentId);
	}
	if (session.getAttribute(HOSPITAL_ID) != null) 
	{
		MasHospital masHospital=new MasHospital();
		masHospital.setId((Integer)session.getAttribute(HOSPITAL_ID));
		avAccident.setHospital(masHospital);
		
	}
	if (session.getAttribute("deptId") != null) 
	{
		MasDepartment masDept=new MasDepartment();
		masDept.setId((Integer)session.getAttribute("deptId"));
		avAccident.setDepartment(masDept);
		
	}
	//-----------For Person Detail--Block--
	if(request.getParameter(SERVICE_NO) !=null && !request.getParameter(SERVICE_NO).equals("")){
		avAccident.setServiceNo(request.getParameter(SERVICE_NO));
	}
	if(request.getParameter(FIRST_NAME) !=null && !request.getParameter(FIRST_NAME).equals("")){
		avAccident.setFirstName(request.getParameter(FIRST_NAME));
	}
	if(request.getParameter("surname") !=null && !request.getParameter("surname").equals("")){
		avAccident.setSurname(request.getParameter("surname"));
	}
	if(request.getParameter("crewDuty") !=null && !request.getParameter("crewDuty").equals("")){
		avAccident.setCrewDuty(request.getParameter("crewDuty"));
	}
	if(request.getParameter("hinId") !=null && !request.getParameter("hinId").equals("")){
		Patient patient=new Patient();
		patient.setId(Integer.parseInt(request.getParameter("hinId")));
		avAccident.setHin(patient);
	}
	if(request.getParameter(RANK_ID) !=null && !request.getParameter(RANK_ID).equals("0")){
		MasRank masRank=new MasRank();
		masRank.setId(Integer.parseInt(request.getParameter(RANK_ID)));
		avAccident.setRank(masRank);
	}
	
	if(request.getParameter("waterCasualty") !=null && !request.getParameter("waterCasualty").equals("")){
		avAccident.setWaterDitching(request.getParameter("waterCasualty"));
	}
	if(request.getParameter("uninjured") !=null && !request.getParameter("uninjured").equals("")){
		avAccident.setWaterUninjured(request.getParameter("uninjured"));
	}
	
	if(request.getParameter("injured") !=null && !request.getParameter("injured").equals("")){
		avAccident.setWaterInjuried(request.getParameter("injured"));
	}
	if(request.getParameter("dead") !=null && !request.getParameter("dead").equals("")){
		avAccident.setDead(request.getParameter("dead"));
	}
	if(request.getParameter("escapeDitchingWitnessed") !=null && !request.getParameter("escapeDitchingWitnessed").equals("")){
		avAccident.setEscapeDitchWitness(request.getParameter("escapeDitchingWitnessed"));
	}
	if(request.getParameter("descentIntoSeat") !=null && !request.getParameter("descentIntoSeat").equals("")){
		avAccident.setDescentSeat(request.getParameter("descentIntoSeat"));
	}
	if(request.getParameter("witnessedChk") !=null && !request.getParameter("witnessedChk").equals("")){
		avAccident.setWitnessed(request.getParameter("witnessedChk"));
	}
	if(request.getParameter("maintainedContactChk") !=null && !request.getParameter("maintainedContactChk").equals("")){
		avAccident.setMaintainedContact(request.getParameter("maintainedContactChk"));
	}
	if(request.getParameter("lostContactAfter") !=null && !request.getParameter("lostContactAfter").equals("")){
		avAccident.setLostContactMin(request.getParameter("lostContactAfter"));
	}
	if(request.getParameter("conditionSubjectLastSeenWitness") !=null && !request.getParameter("conditionSubjectLastSeenWitness").equals("")){
		avAccident.setConditionSeenLastWitness(request.getParameter("conditionSubjectLastSeenWitness"));
	}
	if(request.getParameter("timeEscapeDitchingTxt") !=null && !request.getParameter("timeEscapeDitchingTxt").equals("")){
		avAccident.setTimeEscapeDitch(request.getParameter("timeEscapeDitchingTxt"));
	}
	
	if(request.getParameter("rTCallBeforeInident") !=null && !request.getParameter("rTCallBeforeInident").equals("")){
		avAccident.setRtCallInident(request.getParameter("rTCallBeforeInident"));
	}
	if(request.getParameter("substanceOfCallc") !=null && !request.getParameter("substanceOfCall").equals("")){
		avAccident.setSubstanceCall(request.getParameter("substanceOfCall"));
	}
	if(request.getParameter("notificationWitness") !=null && !request.getParameter("notificationWitness").equals("")){
		avAccident.setNotificationCall(request.getParameter("notificationWitness"));
	}
	
	if(request.getParameter("noDelay") !=null && !request.getParameter("noDelay").equals("")){
		avAccident.setNoDelay(request.getParameter("noDelay"));
	}
	if(request.getParameter("after") !=null && !request.getParameter("after").equals("")){
		avAccident.setAfter(request.getParameter("after"));
	}
	if(request.getParameter("remarksDeliberateDelay") !=null && !request.getParameter("remarksDeliberateDelay").equals("")){
		avAccident.setDeliberateDelayRemarks(request.getParameter("remarksDeliberateDelay"));
	}
	if(request.getParameter("overdueActionTakenAt") !=null && !request.getParameter("overdueActionTakenAt").equals("")){
		avAccident.setOverdueAction(request.getParameter("overdueActionTakenAt"));
	}
	if(request.getParameter("otherNotificaton") !=null && !request.getParameter("otherNotificaton").equals("")){
		avAccident.setOtherNotification(request.getParameter("otherNotificaton"));
	}
	if(request.getParameter("sea") !=null && !request.getParameter("sea").equals("")){
		avAccident.setSea(request.getParameter("sea"));
	}
	if(request.getParameter("shallowDepth") !=null && !request.getParameter("shallowDepth").equals("")){
		avAccident.setShallowDepth(request.getParameter("shallowDepth"));
	}
	if(request.getParameter("distanceFromShore") !=null && !request.getParameter("distanceFromShore").equals("")){
		avAccident.setDistanceShore(request.getParameter("distanceFromShore"));
	}
	if(request.getParameter("distanceNearsestShip") !=null && !request.getParameter("distanceNearsestShip").equals("")){
		avAccident.setDistanceNearShip(request.getParameter("distanceNearsestShip"));
	}
	if(request.getParameter("wind") !=null && !request.getParameter("wind").equals("")){
		avAccident.setWind(request.getParameter("wind"));
	}
	if(request.getParameter("fromWind") !=null && !request.getParameter("fromWind").equals("")){
		avAccident.setWindFrom(request.getParameter("fromWind"));
	}
	if(request.getParameter("windList") !=null && !request.getParameter("windList").equals("")){
		avAccident.setWindFromList(request.getParameter("windList"));
	}
	if(request.getParameter("waterTemp") !=null && !request.getParameter("waterTemp").equals("")){
		avAccident.setWaterTemprature(request.getParameter("waterTemp"));
	}
	if(request.getParameter("airTempAtSeaLevel") !=null && !request.getParameter("airTempAtSeaLevel").equals("")){
		avAccident.setAirTempSeaLevel(request.getParameter("airTempAtSeaLevel"));
	}
	if(request.getParameter("clouds") !=null && !request.getParameter("clouds").equals("")){
		avAccident.setCloud(request.getParameter("clouds"));
	}
	if(request.getParameter("cloudAt") !=null && !request.getParameter("cloudAt").equals("")){
		avAccident.setCloudAt(request.getParameter("cloudAt"));
	}
	if(request.getParameter("cloudFt") !=null && !request.getParameter("cloudFt").equals("")){
		avAccident.setCloudFt(request.getParameter("cloudFt"));
	}
	if(request.getParameter("visibilityAtSeaLevel") !=null && !request.getParameter("visibilityAtSeaLevel").equals("")){
		avAccident.setVisibiltySeaLevel(request.getParameter("visibilityAtSeaLevel"));
	}
	if(request.getParameter("verticalVisibilityFromAir") !=null && !request.getParameter("verticalVisibilityFromAir").equals("")){
		avAccident.setVerticalVisibileAir(request.getParameter("verticalVisibilityFromAir"));
	}
	if(request.getParameter("immersionSuitMark") !=null && !request.getParameter("immersionSuitMark").equals("")){
		avAccident.setImmersionSuitMark(request.getParameter("immersionSuitMark"));
	}
	if(request.getParameter("immersionStatus") !=null && !request.getParameter("immersionStatus").equals("")){
		avAccident.setImmersionSuitStatus(request.getParameter("immersionStatus"));
	}
	if(request.getParameter("immersionDetails") !=null && !request.getParameter("immersionDetails").equals("")){
		avAccident.setImmersionSuitDetail(request.getParameter("immersionDetails"));
	}
	if(request.getParameter("exposureMark") !=null && !request.getParameter("exposureMark").equals("")){
		avAccident.setExposureSuitMark(request.getParameter("exposureMark"));
	}
	if(request.getParameter("exposureStatus") !=null && !request.getParameter("exposureStatus").equals("")){
		avAccident.setExposureSuitStatus(request.getParameter("exposureStatus"));
	}
	if(request.getParameter("exposureDescribe") !=null && !request.getParameter("exposureDescribe").equals("")){
		avAccident.setExposureSuitDetail(request.getParameter("exposureDescribe"));
	}
	if(request.getParameter("lifeJacketMark") !=null && !request.getParameter("lifeJacketMark").equals("")){
		avAccident.setEquipLifeJacketMark(request.getParameter("lifeJacketMark"));
	}
	if(request.getParameter("lifeJacketStatus") !=null && !request.getParameter("lifeJacketStatus").equals("")){
		avAccident.setEquipLifeJacket(request.getParameter("lifeJacketStatus"));
	}
	if(request.getParameter("lifeJacketDescribe") !=null && !request.getParameter("lifeJacketDescribe").equals("")){
		avAccident.setDamageLifeJktDetail(request.getParameter("lifeJacketDescribe"));
	}
	if(request.getParameter("dinghy") !=null && !request.getParameter("dinghy").equals("")){
		avAccident.setDinghy(request.getParameter("dinghy"));
	}
	if(request.getParameter("dinghyOne") !=null && !request.getParameter("dinghyOne").equals("")){
		avAccident.setDinghyOne(request.getParameter("dinghyOne"));
	}
	if(request.getParameter("detailDiffcultyWithActivation") !=null && !request.getParameter("detailDiffcultyWithActivation").equals("")){
		avAccident.setDiffcultyWithActivation(request.getParameter("detailDiffcultyWithActivation"));
	}
	if(request.getParameter("inflatableFloor") !=null && !request.getParameter("inflatableFloor").equals("")){
		avAccident.setInflatableFloor(request.getParameter("inflatableFloor"));
	}
	if(request.getParameter("commentBoarding") !=null && !request.getParameter("commentBoarding").equals("")){
		avAccident.setComentBoardServiceDefects(request.getParameter("commentBoarding"));
	}
	if(request.getParameter("ration") !=null && !request.getParameter("ration").equals("")){
		avAccident.setRation(request.getParameter("ration"));
	}
	if(request.getParameter("rationtype") !=null && !request.getParameter("rationtype").equals("")){
		avAccident.setRationType(request.getParameter("rationtype"));
	}
	if(request.getParameter("rationOne") !=null && !request.getParameter("rationOne").equals("")){
		avAccident.setRationType2(request.getParameter("rationOne"));
	}
	if(request.getParameter("rationDetail") !=null && !request.getParameter("rationDetail").equals("")){
		avAccident.setRationType(request.getParameter("rationDetail"));
	}
	if(request.getParameter("waterAvaiable") !=null && !request.getParameter("waterAvaiable").equals("")){
		avAccident.setWaterAvailable(request.getParameter("waterAvaiable"));
	}
	if(request.getParameter("quantity") !=null && !request.getParameter("quantity").equals("")){
		avAccident.setWaterAvailableQty(request.getParameter("quantity"));
	}
	
	if(request.getParameter("waterAvaiableOne") !=null && !request.getParameter("waterAvaiableOne").equals("")){
		avAccident.setWaterAvailableUsed(request.getParameter("waterAvaiableOne"));
	}
	if(request.getParameter("waterObtained") !=null && !request.getParameter("waterObtained").equals("")){
		avAccident.setWaterObtained(request.getParameter("waterObtained"));
	}
	if(request.getParameter("byDistillationPints") !=null && !request.getParameter("byDistillationPints").equals("")){
		avAccident.setWaterObtainedDetails(request.getParameter("byDistillationPints"));
	}
	if(request.getParameter("bySolarStillPints") !=null && !request.getParameter("bySolarStillPints").equals("")){
		avAccident.setWaterObtainedDetails(request.getParameter("bySolarStillPints"));
	}
	if(request.getParameter("byRainCollectionPints") !=null && !request.getParameter("byRainCollectionPints").equals("")){
		avAccident.setWaterObtainedDetails(request.getParameter("byRainCollectionPints"));
	}
	if(request.getParameter("foodObtainedNaturalSources") !=null && !request.getParameter("foodObtainedNaturalSources").equals("")){
		avAccident.setDistanceSeatGround(request.getParameter("foodObtainedNaturalSources"));
	}
	if(request.getParameter("foodNaturalSources") !=null && !request.getParameter("foodNaturalSources").equals("")){
		avAccident.setFoodNaturalSources(request.getParameter("foodNaturalSources"));
	}
	if(request.getParameter("radioAids") !=null && !request.getParameter("radioAids").equals("")){
		avAccident.setRadioAds(request.getParameter("radioAids"));
	}
	if(request.getParameter("radioAidsType") !=null && !request.getParameter("radioAidsType").equals("")){
		avAccident.setRadioAdsType(request.getParameter("radioAidsType"));
	}
	
	if(request.getParameter("radioAidsOne") !=null && !request.getParameter("radioAidsOne").equals("")){
		avAccident.setRadioAdsUsed(request.getParameter("radioAidsOne"));
	}
	if(request.getParameter("describeEfficiencyItem") !=null && !request.getParameter("describeEfficiencyItem").equals("")){
		avAccident.setDescribeEfficiencyItem(request.getParameter("describeEfficiencyItem"));
	}
	if(request.getParameter("rescuersContactedBy") !=null && !request.getParameter("rescuersContactedBy").equals("")){
		avAccident.setRescuersContactedBy(request.getParameter("rescuersContactedBy"));
	}
	if(request.getParameter("rescuersContactedByDetail") !=null && !request.getParameter("rescuersContactedByDetail").equals("")){
		avAccident.setRescuersContactedOther(request.getParameter("rescuersContactedByDetail"));
	}
	if(request.getParameter("helicopterType") !=null && !request.getParameter("helicopterType").equals("")){
		avAccident.setHelicopterType(request.getParameter("helicopterType"));
	}
	if(request.getParameter("helicopterMark") !=null && !request.getParameter("helicopterMark").equals("")){
		avAccident.setHelicopterMark(request.getParameter("helicopterMark"));
	}
	if(request.getParameter("helicopterNoContactMade") !=null && !request.getParameter("helicopterNoContactMade").equals("")){
		avAccident.setNoContactMade(request.getParameter("helicopterNoContactMade"));
	}
	if(request.getParameter("casualtyLocatedAt") !=null && !request.getParameter("casualtyLocatedAt").equals("")){
		avAccident.setCasualtyLocatedAt(request.getParameter("casualtyLocatedAt"));
	}
	if(request.getParameter("casualtyMaintained") !=null && !request.getParameter("casualtyMaintained").equals("")){
		avAccident.setCasualtyMaintained(request.getParameter("casualtyMaintained"));
	}
	if(request.getParameter("casualtyLostAt") !=null && !request.getParameter("casualtyLostAt").equals("")){
		avAccident.setCasualtyLostAt(request.getParameter("casualtyLostAt"));
	}
	if(request.getParameter("casualtyRegainedAt") !=null && !request.getParameter("casualtyRegainedAt").equals("")){
		avAccident.setCasualtyRegainedAt(request.getParameter("casualtyRegainedAt"));
	}
	if(request.getParameter("helicopterRecusedBy") !=null && !request.getParameter("helicopterRecusedBy").equals("")){
		avAccident.setHelicopterRecusedBy(request.getParameter("helicopterRecusedBy"));
	}
	if(request.getParameter("rescuedBySpecify") !=null && !request.getParameter("rescuedBySpecify").equals("")){
		avAccident.setHelicopterRecusedSpecify(request.getParameter("rescuedBySpecify"));
	}
	if(request.getParameter("rescued") !=null && !request.getParameter("rescued").equals("")){
		avAccident.setRescued(request.getParameter("rescued"));
	}
	if(request.getParameter("notRescued") !=null && !request.getParameter("notRescued").equals("")){
		avAccident.setNoRescued(request.getParameter("notRescued"));
	}
	if(request.getParameter("detail_assosiate_operation") !=null && !request.getParameter("detail_assosiate_operation").equals("")){
		avAccident.setDetailAssosiateOperation(request.getParameter("detail_assosiate_operation"));
	}
	if(request.getParameter("typeOfVessel") !=null && !request.getParameter("typeOfVessel").equals("")){
		avAccident.setVesselType(request.getParameter("typeOfVessel"));
	}
	if(request.getParameter("vesselNoContactMade") !=null && !request.getParameter("vesselNoContactMade").equals("")){
		avAccident.setVesselNoContact(request.getParameter("vesselNoContactMade"));
	}
	if(request.getParameter("vesselCasualtyLocatedAt") !=null && !request.getParameter("vesselCasualtyLocatedAt").equals("")){
		avAccident.setVesselCasualtyLocated(request.getParameter("vesselCasualtyLocatedAt"));
	}
	
	if(request.getParameter("vesselCasualtyMaintained") !=null && !request.getParameter("v").equals("")){
		avAccident.setVesselCasualtyMaintained(request.getParameter("vesselCasualtyMaintained"));
	}
	if(request.getParameter("vesselCasualtyLostAt") !=null && !request.getParameter("vesselCasualtyLostAt").equals("")){
		avAccident.setVesselCasualtyLostAt(request.getParameter("vesselCasualtyLostAt"));
	}
	if(request.getParameter("vesselCasualtyRegainedAt") !=null && !request.getParameter("vesselCasualtyRegainedAt").equals("")){
		avAccident.setVesselCasualtyRegained(request.getParameter("vesselCasualtyRegainedAt"));
	}
	if(request.getParameter("vessel_recused_by") !=null && !request.getParameter("vessel_recused_by").equals("")){
		avAccident.setVesselRecusedBy(request.getParameter("vessel_recused_by"));
	}
	if(request.getParameter("vesselRescuedBySpecify") !=null && !request.getParameter("vesselRescuedBySpecify").equals("")){
		avAccident.setVesselRecusedSpecify(request.getParameter("vesselRescuedBySpecify"));
	}
	if(request.getParameter("surfaceVesselRescued") !=null && !request.getParameter("surfaceVesselRescued").equals("")){
		avAccident.setVesselRescued(request.getParameter("surfaceVesselRescued"));
	}
	if(request.getParameter("surfaceVesselNotRescued") !=null && !request.getParameter("surfaceVesselNotRescued").equals("")){
		avAccident.setVesselNoRescued(request.getParameter("surfaceVesselNotRescued"));
	}
	if(request.getParameter("surfaceVesselNotRescuedDetail") !=null && !request.getParameter("surfaceVesselNotRescuedDetail").equals("")){
		avAccident.setVesselAssosiateOperation(request.getParameter("surfaceVesselNotRescuedDetail"));
	}
	if(request.getParameter("detailRescueOperation1314") !=null && !request.getParameter("detailRescueOperation1314").equals("")){
		avAccident.setDetailRescueOperation1314(request.getParameter("detailRescueOperation1314"));
	}
	if(request.getParameter("casualtyReached") !=null && !request.getParameter("casualtyReached").equals("")){
		avAccident.setCasulityReached(request.getParameter("casualtyReached"));
	}
	if(request.getParameter("totalTimeInWaterNotDinghy") !=null && !request.getParameter("totalTimeInWaterNotDinghy").equals("")){
		avAccident.setTotalTimeWater(request.getParameter("totalTimeInWaterNotDinghy"));
	}
	if(request.getParameter("totalTimeInDinghy") !=null && !request.getParameter("totalTimeInDinghy").equals("")){
		avAccident.setTotalTimeDinghy(request.getParameter("totalTimeInDinghy"));
	}
	if(request.getParameter("failureSearchAbandonedAt") !=null && !request.getParameter("failureSearchAbandonedAt").equals("")){
		avAccident.setFailureSearchDetails(request.getParameter("failureSearchAbandonedAt"));
	}
	if(request.getParameter("failureRescueAbandonedAt") !=null && !request.getParameter("failureRescueAbandonedAt").equals("")){
		avAccident.setRescueAbandonedDetail(request.getParameter("failureRescueAbandonedAt"));
	}
	if(request.getParameter("describeCauseOfFailure") !=null && !request.getParameter("describeCauseOfFailure").equals("")){
		avAccident.setCauseFailure(request.getParameter("describeCauseOfFailure"));
	}
	if(request.getParameter("characterDegreeEffectExposure") !=null && !request.getParameter("characterDegreeEffectExposure").equals("")){
		avAccident.setCharacterDegreeEffect(request.getParameter("characterDegreeEffectExposure"));
	}
	if(request.getParameter("conditionOfCascualtyOnRescue") !=null && !request.getParameter("conditionOfCascualtyOnRescue").equals("")){
		avAccident.setConditionCascualtyRescue(request.getParameter("conditionOfCascualtyOnRescue"));
	}
	if(request.getParameter("effectInjuriesSustainedAccident") !=null && !request.getParameter("effectInjuriesSustainedAccident").equals("")){
		avAccident.setEffectInjuriesAccident(request.getParameter("effectInjuriesSustainedAccident"));
	}
	if(request.getParameter("conditionStatic") !=null && !request.getParameter("conditionStatic").equals("")){
		avAccident.setConditionStatic(request.getParameter("conditionStatic"));
	}
	if(request.getParameter("reached") !=null && !request.getParameter("reached").equals("")){
		avAccident.setReached(request.getParameter("reached"));
	}
	if(request.getParameter("hospitalAt") !=null && !request.getParameter("hospitalAt").equals("")){
		avAccident.setHospitalAt(request.getParameter("hospitalAt"));
	}
	if(request.getParameter("treatmentRescueCraft") !=null && !request.getParameter("treatmentRescueCraft").equals("")){
		avAccident.setTreatmentRescueCraft(request.getParameter("treatmentRescueCraft"));
	}
	if(request.getParameter("swimmingAbility") !=null && !request.getParameter("swimmingAbility").equals("")){
		avAccident.setSwimmingAbility(request.getParameter("swimmingAbility"));
	}
	if(request.getParameter("dateLastDinghy") !=null && !request.getParameter("dateLastDinghy").equals("")){
		avAccident.setDateLastDinghy(HMSUtil.convertStringTypeDateToDateType(request.getParameter("dateLastDinghy")));
	}
	if(request.getParameter("date_actual_ditching") !=null && !request.getParameter("date_actual_ditching").equals("")){
		avAccident.setDateActualDitching(HMSUtil.convertStringTypeDateToDateType(request.getParameter("date_actual_ditching")));
	}
	if(request.getParameter("detail_prevs_ditching") !=null && !request.getParameter("detail_prevs_ditching").equals("")){
		avAccident.setDetailPrevsDitching(request.getParameter("detail_prevs_ditching"));
	}
	if(request.getParameter("annotate_na") !=null && !request.getParameter("annotate_na").equals("")){
		avAccident.setAnnotateNa(request.getParameter("annotate_na"));
	}
	if(request.getParameter("trainingDetailNature") !=null && !request.getParameter("trainingDetailNature").equals("")){
		avAccident.setTraingDetailNature(request.getParameter("trainingDetailNature"));
	}
	if(request.getParameter("dateOfSurvival") !=null && !request.getParameter("dateOfSurvival").equals("")){
		avAccident.setTraingDetailDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter("dateOfSurvival")));
	}
	if(request.getParameter("approxWeightLoss") !=null && !request.getParameter("approxWeightLoss").equals("")){
		avAccident.setApproxWeightLoss(request.getParameter("approxWeightLoss"));
	}
	if(request.getParameter("treatmentByRecuse") !=null && !request.getParameter("treatmentByRecuse").equals("")){
		avAccident.setTreatmentByRecuse(request.getParameter("treatmentByRecuse"));
	}
	if(request.getParameter("conditionCascualtySpecify") !=null && !request.getParameter("conditionCascualtySpecify").equals("")){
		avAccident.setConditionCascualtySpecify(request.getParameter("conditionCascualtySpecify"));
	}
	if(request.getParameter("dateTreatmentByRecuse") !=null && !request.getParameter("dateTreatmentByRecuse").equals("")){
		avAccident.setDateTreatmentByRecuse(HMSUtil.convertStringTypeDateToDateType(request.getParameter("dateTreatmentByRecuse")));
	}
	if(request.getParameter("effectInjuriesAccident") !=null && !request.getParameter("effectInjuriesAccident").equals("")){
		avAccident.setEffectInjuriesAccident1(request.getParameter("effectInjuriesAccident"));
	}
	if(request.getParameter("injuriBetAccidentRescue") !=null && !request.getParameter("injuriBetAccidentRescue").equals("")){
		avAccident.setInjuriBetAccidentRescue(request.getParameter("injuriBetAccidentRescue"));
	}
	if(request.getParameter("landUninjuried") !=null && !request.getParameter("landUninjuried").equals("")){
		avAccident.setLandUninjured(request.getParameter("landUninjuried"));
	}
	
	if(request.getParameter("landInjuried") !=null && !request.getParameter("landInjuried").equals("")){
		avAccident.setLandInjuried(request.getParameter("landInjuried"));
	}
	
	if(request.getParameter("characterDegreeEffectExpLand") !=null && !request.getParameter("characterDegreeEffectExpLand").equals("")){
		avAccident.setCharacterDegreeEffect1(request.getParameter("characterDegreeEffectExpLand"));
	}
	if(request.getParameter("conditionOfLandCascualty") !=null && !request.getParameter("conditionOfLandCascualty").equals("")){
		avAccident.setForcedLandingDitching(request.getParameter("conditionOfLandCascualty"));
	}
	if(request.getParameter("conditionForFit") !=null && !request.getParameter("conditionForFit").equals("")){
		avAccident.setConditionForFit(request.getParameter("conditionForFit"));
	}
	if(request.getParameter("failure_search_date") !=null && !request.getParameter("failure_search_date").equals("")){
		avAccident.setFailureSearchDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter("failure_search_date")));
	}
	if(request.getParameter("failure_search_land") !=null && !request.getParameter("failure_search_land").equals("")){
		avAccident.setFailureSearchLand(request.getParameter("failure_search_land"));
	}
	if(request.getParameter("dateRescueAbandoned") !=null && !request.getParameter("dateRescueAbandoned").equals("")){
		avAccident.setRescueAbandonedDate1(HMSUtil.convertStringTypeDateToDateType(request.getParameter("dateRescueAbandoned")));
	}
	if(request.getParameter("rescue_abandoned_detail1") !=null && !request.getParameter("rescue_abandoned_detail1").equals("")){
		avAccident.setRescueAbandonedDetail1(request.getParameter("rescue_abandoned_detail1"));
	}
	if(request.getParameter("cause_failure1") !=null && !request.getParameter("cause_failure1").equals("")){
		avAccident.setCauseFailure1(request.getParameter("cause_failure1"));
	}
	if(request.getParameter("landParty") !=null && !request.getParameter("landParty").equals("")){
		avAccident.setLandParty(request.getParameter("landParty"));
	}
	if(request.getParameter("localPopulation") !=null && !request.getParameter("localPopulation").equals("")){
		avAccident.setLocalPopulation(request.getParameter("localPopulation"));
	}
	if(request.getParameter("localConvence") !=null && !request.getParameter("localConvence").equals("")){
		avAccident.setLocalConvence(request.getParameter("localConvence"));
	}
	if(request.getParameter("reached_by_rescuers") !=null && !request.getParameter("reached_by_rescuers").equals("")){
		avAccident.setReachedByRescuers(request.getParameter("reached_by_rescuers"));
	}
	if(request.getParameter("reached_rscuers_date") !=null && !request.getParameter("reached_rscuers_date").equals("")){
		avAccident.setReachedRscuersDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter("reached_rscuers_date")));
	}
	
	if(request.getParameter("casualty_unassist") !=null && !request.getParameter("casualty_unassist").equals("")){
		avAccident.setCasualtyUnassist(request.getParameter("casualty_unassist"));
	}
	if(request.getParameter("casualty_unassist_date") !=null && !request.getParameter("casualty_unassist_date").equals("")){
		avAccident.setCasualtyUnassistDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter("casualty_unassist_date")));
	}
	if(request.getParameter("land_radio_ads") !=null && !request.getParameter("land_radio_ads").equals("")){
		avAccident.setLandRadioAds(request.getParameter("land_radio_ads"));
	}
	if(request.getParameter("land_radio_other") !=null && !request.getParameter("land_radio_other").equals("")){
		avAccident.setLandRadioOther(request.getParameter("land_radio_other"));
	}
	if(request.getParameter("land_efficiency_item") !=null && !request.getParameter("land_efficiency_item").equals("")){
		avAccident.setLandEfficiencyItem(request.getParameter("land_efficiency_item"));
	}
	if(request.getParameter("supplies_dropped") !=null && !request.getParameter("supplies_dropped").equals("")){
		avAccident.setSuppliesDropped(request.getParameter("supplies_dropped"));
	}
	if(request.getParameter("location_radio_ads") !=null && !request.getParameter("location_radio_ads").equals("")){
		avAccident.setLocationRadioAds(request.getParameter("location_radio_ads"));
	}
	if(request.getParameter("located_date") !=null && !request.getParameter("located_date").equals("")){
		avAccident.setLocatedDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter("located_date")));
	}
	if(request.getParameter("location_radio_combo") !=null && !request.getParameter("location_radio_combo").equals("")){
		avAccident.setLocationRadioCombo(request.getParameter("location_radio_combo"));
	}
	if(request.getParameter("located_time") !=null && !request.getParameter("located_time").equals("")){
		avAccident.setLocatedTime(request.getParameter("located_time"));
	}
	if(request.getParameter("landRation2") !=null && !request.getParameter("landRation2").equals("")){
		avAccident.setLandRation2(request.getParameter("landRation2"));
	}
	if(request.getParameter("landRation") !=null && !request.getParameter("landRation").equals("")){
		avAccident.setLandRation(request.getParameter("landRation"));
	}
	if(request.getParameter("rationTwoDetail") !=null && !request.getParameter("rationTwoDetail").equals("")){
		avAccident.setLandRation2Detail(request.getParameter("rationTwoDetail"));
	}
	
	if(request.getParameter("waterAvaiable") !=null && !request.getParameter("waterAvaiable").equals("")){
		avAccident.setLandWaterAvilable(request.getParameter("waterAvaiable"));
	}
	if(request.getParameter("purificationMethod") !=null && !request.getParameter("purificationMethod").equals("")){
		avAccident.setPurificationMethod(request.getParameter("purificationMethod"));
	}
	if(request.getParameter("foodFromNaturalSource") !=null && !request.getParameter("foodFromNaturalSource").equals("")){
		avAccident.setLandFoodNaturalSrc(request.getParameter("foodFromNaturalSource"));
	}
	if(request.getParameter("fullyMobile") !=null && !request.getParameter("fullyMobile").equals("")){
		avAccident.setFullyMobile(request.getParameter("fullyMobile"));
	}
	if(request.getParameter("partiallyIncapacitatedBy") !=null && !request.getParameter("partiallyIncapacitatedBy").equals("")){
		avAccident.setPartialIncapicated(request.getParameter("partiallyIncapacitatedBy"));
	}
	if(request.getParameter("objective") !=null && !request.getParameter("objective").equals("")){
		avAccident.setObjective(request.getParameter("objective"));
	}
	if(request.getParameter("approx_distance_cover") !=null && !request.getParameter("approx_distance_cover").equals("")){
		avAccident.setApproxDistanceCover(request.getParameter("approx_distance_cover"));
	}
	
	if(request.getParameter("approx_distance_cover") !=null && !request.getParameter("approx_distance_cover").equals("")){
		avAccident.setApprDistanceHrs(request.getParameter("approx_distance_cover"));
	}
	if(request.getParameter("navigation") !=null && !request.getParameter("navigation").equals("")){
		avAccident.setNaviagtion(request.getParameter("navigation"));
	}
	if(request.getParameter("any_difficulty") !=null && !request.getParameter("any_difficulty").equals("")){
		avAccident.setAnyDifficulty(request.getParameter("any_difficulty"));
	}
	if(request.getParameter("personalKit") !=null && !request.getParameter("personalKit").equals("")){
		avAccident.setPersonalKit(request.getParameter("personalKit"));
	}
	if(request.getParameter("personalKitType") !=null && !request.getParameter("personalKitType").equals("")){
		avAccident.setPersonalKitType(request.getParameter("personalKitType"));
	}
	if(request.getParameter("survivalKit") !=null && !request.getParameter("survivalKit").equals("")){
		avAccident.setSurvivalKit(request.getParameter("survivalKit"));
	}
	if(request.getParameter("survivalKitType") !=null && !request.getParameter("survivalKitType").equals("")){
		avAccident.setSurvivalKitType(request.getParameter("survivalKitType"));
	}
	if(request.getParameter("item_used_found") !=null && !request.getParameter("item_used_found").equals("")){
		avAccident.setItemUsedFound(request.getParameter("item_used_found"));
	}
	if(request.getParameter("item_not_used") !=null && !request.getParameter("item_not_used").equals("")){
		avAccident.setItemNotUsed(request.getParameter("item_not_used"));
	}
	
	if(request.getParameter("item_not_provide") !=null && !request.getParameter("item_not_provide").equals("")){
		avAccident.setItemNotProvide(request.getParameter("item_not_provide"));
	}
	if(request.getParameter("first_aid_mark") !=null && !request.getParameter("first_aid_mark").equals("")){
		avAccident.setFirstAidMark(request.getParameter("first_aid_mark"));
	}
	if(request.getParameter("first_aid_mark_combo") !=null && !request.getParameter("first_aid_mark_combo").equals("")){
		avAccident.setFirstAidMarkCombo(request.getParameter("first_aid_mark_combo"));
	}
	if(request.getParameter("itemdeficiencie_noted") !=null && !request.getParameter("itemdeficiencie_noted").equals("")){
		avAccident.setItemdeficiencieNoted(request.getParameter("itemdeficiencie_noted"));
	}
	if(request.getParameter("land_terrain") !=null && !request.getParameter("land_terrain").equals("")){
		avAccident.setLandTerrain(request.getParameter("land_terrain"));
	}
	if(request.getParameter("terrainSpecify") !=null && !request.getParameter("terrainSpecify").equals("")){
		avAccident.setLandTerrainSpecify(request.getParameter("terrainSpecify"));
	}
	if(request.getParameter("land_location") !=null && !request.getParameter("land_location").equals("")){
		avAccident.setLandLocation(request.getParameter("land_location"));
	}
	if(request.getParameter("temperature_day") !=null && !request.getParameter("temperature_day").equals("")){
		avAccident.setTemperatureDay(new BigDecimal(request.getParameter("temperature_day")));
	}
	if(request.getParameter("temperature_night") !=null && !request.getParameter("temperature_night").equals("")){
		avAccident.setTemperatureNight(new BigDecimal(request.getParameter("temperature_night")));
	}
	if(request.getParameter("temperature_measure") !=null && !request.getParameter("temperature_measure").equals("")){
		avAccident.setTemperatureMeasure(request.getParameter("temperature_measure"));
	}
	if(request.getParameter("witnessedChk") !=null && !request.getParameter("witnessedChk").equals("")){
		avAccident.setWitnessed(request.getParameter("witnessedChk"));
	}
	if(request.getParameter("maintainedContactChk") !=null && !request.getParameter("maintainedContactChk").equals("")){
		avAccident.setMaintainedContact(request.getParameter("maintainedContactChk"));
	}
	if(request.getParameter("land_witnessed") !=null && !request.getParameter("land_witnessed").equals("")){
		avAccident.setLandWitnessed(request.getParameter("land_witnessed"));
	}
	if(request.getParameter("land_maintain_cntct") !=null && !request.getParameter("land_maintain_cntct").equals("")){
		avAccident.setLandMaintainCntct(request.getParameter("land_maintain_cntct"));
	}
	if(request.getParameter("land_lost_contact_min") !=null && !request.getParameter("land_lost_contact_min").equals("")){
		avAccident.setLandLostContactMin(request.getParameter("land_lost_contact_min"));
	}
	
	if(request.getParameter("conditionOfSubject") !=null && !request.getParameter("conditionOfSubject").equals("")){
		avAccident.setLandSeenLastWitness(request.getParameter("conditionOfSubject"));
	}
	if(request.getParameter("time_escape_landing") !=null && !request.getParameter("time_escape_landing").equals("")){
		avAccident.setTimeEscapeLanding(request.getParameter("time_escape_landing"));
	}
	if(request.getParameter("time_escape_landing2") !=null && !request.getParameter("time_escape_landing2").equals("")){
		avAccident.setTimeEscapeLanding2(request.getParameter("time_escape_landing2"));
	}
	if(request.getParameter("conditionsOfEscape") !=null && !request.getParameter("conditionsOfEscape").equals("")){
		avAccident.setConditionOfEscape(request.getParameter("conditionsOfEscape"));
	}
	if(request.getParameter("land_casulty") !=null && !request.getParameter("land_casulty").equals("")){
		avAccident.setLandCasulty(request.getParameter("land_casulty"));
	}
	if(request.getParameter("landCasualtyMissing") !=null && !request.getParameter("landCasualtyMissing").equals("")){
		avAccident.setMissing(request.getParameter("landCasualtyMissing"));
	}
	if(request.getParameter("landCasualtyDead") !=null && !request.getParameter("landCasualtyDead").equals("")){
		avAccident.setDead(request.getParameter("landCasualtyDead"));
	}
	if (request.getParameter(LAST_CHANGED_BY) != null)
	{	avAccident.setLastChgBy(request.getParameter(LAST_CHANGED_BY));
	}
	if (request.getParameter(LAST_CHANGED_DATE) != null)
	{
		avAccident.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(LAST_CHANGED_DATE)));
	}
	if (request.getParameter(LAST_CHANGED_TIME) != null)
	{	avAccident.setLastChgTime(request.getParameter(LAST_CHANGED_TIME));
	}
	String flag="";
	if(request.getParameter("flag") !=null && !request.getParameter("flag").equals("")){
		flag=request.getParameter("flag");
	}
	infoMap.put("avAccidentId",avAccidentId);
	infoMap.put("avAccident", avAccident);
	boolean saved = false;
	map = aviationMedicineHandlerService.submitEquipmentFactors(infoMap);
	if (map.get("saved") != null) {
		saved = (Boolean) map.get("saved");
	}
	if (saved) {
		message = "Data saved Successfully !!";
	} else {
		message = "Try Again!";
	}
	int avAccidentIdd=0;
	if(map.get("avAccidentIdd") !=null){
		avAccidentIdd=(Integer)map.get("avAccidentIdd");
	}
	map.put("message", message);
	url = "/hms/hms/aviationMedicine?method=showSurvivalFromAnAircraftAccidentJsp";
	jsp = AV_MESSAGE + ".jsp";

	map.put("flag", flag);
	map.put("avAccidentId", avAccidentIdd);
	map.put("url", url);
	map.put("message", message);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
public ModelAndView generateAviationMedReport(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> parameters = new HashMap<String, Object>();
	String reportName="";
	String flag="";
	if(request.getParameter("flag") !=null && !request.getParameter("flag").equals("")){
		flag=request.getParameter("flag");
	}
	if(flag.equalsIgnoreCase("accident")){
	reportName="av_accidentInvestigation";
	}else if(flag.equalsIgnoreCase("equipment")){
	reportName="av_equipmentInUse";
	}else if(flag.equalsIgnoreCase("external")){
	reportName="av_externalMedicalExamination";
	}else if(flag.equalsIgnoreCase("postMortem")){
	reportName="av_postMortem";
	}else if(flag.equalsIgnoreCase("unassisted")){
	reportName="av_anUnassistedEscapeFromAnAircraftInFlight";
	}else if(flag.equalsIgnoreCase("ejectionSeat")){
	reportName="av_useOfEjectionSeat";
	}else if(flag.equalsIgnoreCase("survival")){
	reportName="av_survivalFromAnAircraftAccident";
	}
	int avAccidentId=0;
	if(request.getParameter("avAccidentId") !=null && !request.getParameter("avAccidentId").equals("0")){
		avAccidentId=Integer.parseInt(request.getParameter("avAccidentId"));
	}
	detailsMap = aviationMedicineHandlerService.getConnectionForReport();
	parameters.put("AV_ACCIDENT_ID", avAccidentId);
	parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
	HMSUtil.generateReport(reportName, parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
	return null;
}
public ModelAndView generatePaymentStatusReport(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Box box = null;
		Date fromDate = null;
		Date toDate = null;
		String qry = "";
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("box")!=null){
			box = (Box)session.getAttribute("box");
		}else{
			box = HMSUtil.getBox(request);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (!box.getString(FROM_DATE).equals("")) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE));
		}
		if (!box.getString(TO_DATE).equals("")) {
			toDate = HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE));
		}
		if(box.getInt(BANK_ID)!=0){
			qry += " and B.BANK_ID = "+box.getInt(BANK_ID)+"";
		}
		if (!(box.getString(LICENCE_NO).equals(""))) {
			qry += " and B.LICENCE_NO ='"+HMSUtil.restrictMetaChar(request.getParameter(LICENCE_NO))+"'";
		}
		detailsMap = aviationMedicineHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);
		parameters.put("hospitalId", hospitalId);
		HMSUtil.generateReport("payment_status", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
public ModelAndView showExaminationStats(
		HttpServletRequest request, HttpServletResponse response) {
	String jsp = "";
	Map<String, Object> map = new HashMap<String, Object>();
	jsp = "av_examinationStats";
	jsp = jsp + ".jsp";
	map.put("contentJsp", jsp);
	
	return new ModelAndView("indexB", "map", map);
}

public ModelAndView generateExamStatsReport(
		HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> parameters = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Date from_date = null;
	Date to_date = null;
		
	if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) {
		from_date = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
	}
	if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
		to_date = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
	}
	String qry = "";
	int hospitalId=0;
	if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("") && request.getParameter("hospitalId").equals("0")){
		
		qry += "  and H.command_id="+Integer.parseInt(request.getParameter("cmdId"));
	}else{
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		qry += "  and A.hospital_id="+hospitalId;
	}
	parameters.put("hospitalId", hospitalId);
	
	Map<String, Object> detailsMap = aviationMedicineHandlerService.getConnectionForReport();
	parameters.put("fromDate", from_date);
	parameters.put("toDate", to_date);
	parameters.put("query", qry);
    HMSUtil.generateReport("av_Medical_Board_register", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
      		return null;
}
public ModelAndView showFlyingIncident(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	
	jsp = "av_FlyingIncident.jsp";

	title = "Aircrew Training Status";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}
public ModelAndView showAircraftAccident(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	
	jsp = "av_aircraftAccident.jsp";

	title = "Aircrew Training Status";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}
public ModelAndView submitAircraftAccident(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	AvAircraftAccident aircraftAccident = new AvAircraftAccident();
	String message = "";
	String jsp = "";
	int avAccidentId=0;
	// Commented by Vinay
	/*if(request.getParameter("avAccidentId") !=null && !request.getParameter("avAccidentId").equals("")){
		avAccidentId=Integer.parseInt(request.getParameter("avAccidentId"));
		infoMap.put("avAccidentId", avAccidentId);
		aircraftAccident = aviationMedicineHandlerService.loadAircraftAccident(avAccidentId);
	}*/
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	MasHospital masHospital = new MasHospital();
	masHospital.setId(hospitalId);
	aircraftAccident.setHospital(masHospital);
	
	int departmentId = (Integer) session.getAttribute("deptId");
	MasDepartment masDepartment = new MasDepartment();
	masDepartment.setId(departmentId);
	aircraftAccident.setDepartment(masDepartment);
	
	if(request.getParameter(SERVICE_NO) != null && !request.getParameter(SERVICE_NO).equals("0")) {
		aircraftAccident.setServiceNo(request.getParameter(SERVICE_NO));
	}
	Date aircraftDate = null;
	if (request.getParameter(DATE) != null && !request.getParameter(DATE).equals("")) {
		aircraftDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE));
		aircraftAccident.setAircraftDate(aircraftDate);
	
	}
	if (request.getParameter(HIN_ID) != null && !request.getParameter(HIN_ID).equals("0")) {
		int hinId = Integer.parseInt(request.getParameter(HIN_ID));
		Patient patient = new Patient();
		patient.setId(hinId);
		aircraftAccident.setHin(patient);
	}
		
	if (request.getParameter(TIME) != null && !request.getParameter(TIME).equals("")) {
		aircraftAccident.setAircraftTime(request.getParameter(TIME));
	}
	if (request.getParameter(RANK_ID) != null && !request.getParameter(RANK_ID).equals("0")) {
		int rankId = Integer.parseInt(request.getParameter(RANK_ID));
		MasRank masRank = new MasRank();
		masRank.setId(rankId);
		aircraftAccident.setRank(masRank);
	}
	if (request.getParameter(UNIT_ID) != null && !request.getParameter(UNIT_ID).equals("0")) {
		int unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		MasUnit masUnit = new MasUnit();
		masUnit.setId(unitId);
		aircraftAccident.setUnit(masUnit);
	}
		
	if(request.getParameter("fullName") != null && !request.getParameter("fullName").equals("")) {
		aircraftAccident.setFullName(request.getParameter("fullName"));
	}

	if (request.getParameter(SR_AGE) != null && !request.getParameter(SR_AGE).equals("")) {
		if (request.getParameter(SR_AGE_UNIT) != null) {
			String ageUnit = request.getParameter(SR_AGE_UNIT);
			String srage = request.getParameter(SR_AGE).concat(" ").concat(ageUnit);
			aircraftAccident.setAge(srage);
		}
	}
	if (request.getParameter(SEX_ID) != null && !request.getParameter(SEX_ID).equals("0")) {

		int genderId = Integer.parseInt(request.getParameter(SEX_ID));
		MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
		masAdministrativeSex.setId(genderId);
		aircraftAccident.setSex(masAdministrativeSex);
	}
	
	if (request.getParameter("accidentNature") != null && !request.getParameter("accidentNature").equals("")) {
		aircraftAccident.setNatureAccident(request.getParameter("accidentNature"));
	}
	if (request.getParameter("outcome") != null && !request.getParameter("outcome").equals("")) {
		aircraftAccident.setOutcome(request.getParameter("outcome"));
	}
	if (request.getParameter("accidentRemarks") != null && !request.getParameter("accidentRemarks").equals("")) {
		aircraftAccident.setAccidentRemarks(request.getParameter("accidentRemarks"));
	}
	
	/*if (request.getParameter("aircraftType") != null && !request.getParameter("aircraftType").equals("")) {
		aircraftAccident.setAircraftType(request.getParameter("aircraftType"));
	}*/
	if (request.getParameter(AIRCRAFT_TYPE_ID) != null && !request.getParameter(AIRCRAFT_TYPE_ID).equals("0")) {
		int aircraftTypeId = Integer.parseInt(request.getParameter(AIRCRAFT_TYPE_ID));
		MasAircraftType masAircraftType = new MasAircraftType();
		masAircraftType.setId(aircraftTypeId);
		aircraftAccident.setAircraftType(masAircraftType);
			
	}

	Date lastChgDate = null;
	if (request.getParameter(CHANGED_DATE) != null && !request.getParameter(CHANGED_DATE).equals("")) {
		lastChgDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(CHANGED_DATE));
		aircraftAccident.setLastChgDate(lastChgDate);
	}

	String lastChgTime = "";
	if (request.getParameter(CHANGED_TIME) != null && !request.getParameter(CHANGED_TIME).equals("")) {
		lastChgTime = request.getParameter(CHANGED_TIME);
		aircraftAccident.setLastChgTime(lastChgTime);
	}
	String lastChgBy = "";
	if (request.getParameter(CHANGED_BY) != null && !request.getParameter(CHANGED_BY).equals("")) {
		lastChgBy = request.getParameter(CHANGED_BY);
		aircraftAccident.setLastChgBy(lastChgBy);
	}
	String flag="";
	if(request.getParameter("flag") !=null && !request.getParameter("flag").equals("")){
		flag=request.getParameter("flag");
	}
	infoMap.put("aircraftAccident", aircraftAccident);
	Boolean saved = false;
	
	map = aviationMedicineHandlerService.submitAircraftAccident(infoMap);
	if(map.get("saved") !=null){
		saved=(Boolean)map.get("saved");
	}
	if(saved){
		message="Data Saved Successfully !Print Report?";
	}
	else{
		message="Try Again !!";
	}
	int avAccidentIdd=0;
	if(map.get("avAccidentIdd") !=null){
		avAccidentIdd=(Integer)map.get("avAccidentIdd");
	}
	String url="";
	url = "/hms/hms/aviationMedicine?method=showAircraftAccidentJsp";
	jsp = AV_MESSAGE + ".jsp";

	map.put("flag", flag);
	map.put("avAccidentId", avAccidentIdd);
	map.put("url", url);
	map.put("message", message);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
	}
public ModelAndView submitFlyingIncident(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	AvFlyingIncident flyingIncident = new AvFlyingIncident();
	String message = "";
	String jsp = "";
	int avAccidentId=0;
	// commented by Vinay we have to insert the new data for pilot each time
	/*if(request.getParameter("avAccidentId") !=null && !request.getParameter("avAccidentId").equals("")){
		avAccidentId=Integer.parseInt(request.getParameter("avAccidentId"));
		infoMap.put("avAccidentId", avAccidentId);
		flyingIncident = aviationMedicineHandlerService.loadFlyingIncident(avAccidentId);
	}*/
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	MasHospital masHospital = new MasHospital();
	masHospital.setId(hospitalId);
	flyingIncident.setHospital(masHospital);
	
	int departmentId = (Integer) session.getAttribute("deptId");
	MasDepartment masDepartment = new MasDepartment();
	masDepartment.setId(departmentId);
	flyingIncident.setDepartment(masDepartment);
	
	if(request.getParameter(SERVICE_NO) != null && !request.getParameter(SERVICE_NO).equals("0")) {
		flyingIncident.setServiceNo(request.getParameter(SERVICE_NO));
	}
	Date flyingDate = null;
	if (request.getParameter(DATE) != null && !request.getParameter(DATE).equals("")) {
		flyingDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE));
		flyingIncident.setFlyingDate(flyingDate);
	
	}
	if (request.getParameter(HIN_ID) != null && !request.getParameter(HIN_ID).equals("")) {
		int hinId = Integer.parseInt(request.getParameter(HIN_ID));
		Patient patient = new Patient();
		patient.setId(hinId);
		flyingIncident.setHin(patient);
	}
		
	if (request.getParameter(TIME) != null && !request.getParameter(TIME).equals("")) {
		flyingIncident.setFlyingTime(request.getParameter(TIME));
	}
	if (request.getParameter(RANK_ID) != null && !request.getParameter(RANK_ID).equals("0")) {
		int rankId = Integer.parseInt(request.getParameter(RANK_ID));
		MasRank masRank = new MasRank();
		masRank.setId(rankId);
		flyingIncident.setRank(masRank);
	}
	if (request.getParameter(UNIT_ID) != null && !request.getParameter(UNIT_ID).equals("0")) {
		int unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		MasUnit masUnit = new MasUnit();
		masUnit.setId(unitId);
		flyingIncident.setUnit(masUnit);
	}
		
	if(request.getParameter("fullName") != null && !request.getParameter("fullName").equals("")) {
		flyingIncident.setFlyingName(request.getParameter("fullName"));
	}

	if (request.getParameter(SR_AGE) != null && !request.getParameter(SR_AGE).equals("")) {
		if (request.getParameter(SR_AGE_UNIT) != null) {
			String ageUnit = request.getParameter(SR_AGE_UNIT);
			String srage = request.getParameter(SR_AGE).concat(" ").concat(ageUnit);
			flyingIncident.setAge(srage);
		}
	}
	if (request.getParameter(SEX_ID) != null && !request.getParameter(SEX_ID).equals("0")) {

		int genderId = Integer.parseInt(request.getParameter(SEX_ID));
		MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
		masAdministrativeSex.setId(genderId);
		flyingIncident.setSex(masAdministrativeSex);
	}
	
	if (request.getParameter("incidentNature") != null && !request.getParameter("incidentNature").equals("")) {
		flyingIncident.setNatureIncident(request.getParameter("incidentNature"));
	}
	if (request.getParameter("outcome") != null && !request.getParameter("outcome").equals("")) {
		flyingIncident.setOutcome(request.getParameter("outcome"));
	}
	if (request.getParameter("incidentRemarks") != null && !request.getParameter("incidentRemarks").equals("")) {
		flyingIncident.setFlyingRemarks(request.getParameter("incidentRemarks"));
	}
	/*if (request.getParameter("aircraftType") != null && !request.getParameter("aircraftType").equals("")) {
		flyingIncident.setAircraftType(request.getParameter("aircraftType"));
	}*/
	if (request.getParameter(AIRCRAFT_TYPE_ID) != null && !request.getParameter(AIRCRAFT_TYPE_ID).equals("0")) {
		int aircraftTypeId = Integer.parseInt(request.getParameter(AIRCRAFT_TYPE_ID));
		MasAircraftType masAircraftType = new MasAircraftType();
		masAircraftType.setId(aircraftTypeId);
		flyingIncident.setAircraftType(masAircraftType);
			
	}

	Date lastChgDate = null;
	if (request.getParameter(CHANGED_DATE) != null && !request.getParameter(CHANGED_DATE).equals("")) {
		lastChgDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(CHANGED_DATE));
		flyingIncident.setLastChgDate(lastChgDate);
	}

	String lastChgTime = "";
	if (request.getParameter(CHANGED_TIME) != null && !request.getParameter(CHANGED_TIME).equals("")) {
		lastChgTime = request.getParameter(CHANGED_TIME);
		flyingIncident.setLastChgTime(lastChgTime);
	}
	String lastChgBy = "";
	if (request.getParameter(CHANGED_BY) != null && !request.getParameter(CHANGED_BY).equals("")) {
		lastChgBy = request.getParameter(CHANGED_BY);
		flyingIncident.setLastChgBy(lastChgBy);
	}
	String flag="";
	if(request.getParameter("flag") !=null && !request.getParameter("flag").equals("")){
		flag=request.getParameter("flag");
	}
	infoMap.put("flyingIncident", flyingIncident);
	Boolean saved = false;
	
	map = aviationMedicineHandlerService.submitFlyingIncident(infoMap);
	if(map.get("saved") !=null){
		saved=(Boolean)map.get("saved");
	}
	if(saved){
		message="Data Saved Successfully !Print Report?";
	}
	else{
		message="Try Again !!";
	}
	int avAccidentIdd=0;
	if(map.get("avAccidentIdd") !=null){
		avAccidentIdd=(Integer)map.get("avAccidentIdd");
	}
	String url="";
	url = "/hms/hms/aviationMedicine?method=showFlyingIncidentJsp";
	jsp = AV_MESSAGE + ".jsp";

	map.put("flag", flag);
	map.put("avAccidentId", avAccidentIdd);
	map.put("url", url);
	map.put("message", message);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
	}
public ModelAndView submitTrainingStatusAirCrew(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	AvTrainingStatusAircrew trainingStatusAircrew = new AvTrainingStatusAircrew();
	String message = "";
	String jsp = "";
	int avAccidentId=0;
	if(request.getParameter("avAccidentId") !=null && !request.getParameter("avAccidentId").equals("")){
		avAccidentId=Integer.parseInt(request.getParameter("avAccidentId"));
		infoMap.put("avAccidentId", avAccidentId);
		trainingStatusAircrew = aviationMedicineHandlerService.loadTrainingStatusAircrew(avAccidentId);
	}
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	MasHospital masHospital = new MasHospital();
	masHospital.setId(hospitalId);
	trainingStatusAircrew.setHospital(masHospital);
	
	int departmentId = (Integer) session.getAttribute("deptId");
	MasDepartment masDepartment = new MasDepartment();
	masDepartment.setId(departmentId);
	trainingStatusAircrew.setDepartment(masDepartment);
	
	if(request.getParameter(SERVICE_NO) != null && !request.getParameter(SERVICE_NO).equals("0")) {
		trainingStatusAircrew.setServiceNo(request.getParameter(SERVICE_NO));
	}
	if (request.getParameter(HIN_ID) != null && !request.getParameter(HIN_ID).equals("0")) {
		int hinId = Integer.parseInt(request.getParameter(HIN_ID));
		Patient patient = new Patient();
		patient.setId(hinId);
		trainingStatusAircrew.setHin(patient);
	}
		
	if (request.getParameter(RANK_ID) != null && !request.getParameter(RANK_ID).equals("0")) {
		int rankId = Integer.parseInt(request.getParameter(RANK_ID));
		MasRank masRank = new MasRank();
		masRank.setId(rankId);
		trainingStatusAircrew.setRank(masRank);
	}
	if (request.getParameter(UNIT_ID) != null && !request.getParameter(UNIT_ID).equals("0")) {
		int unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		MasUnit masUnit = new MasUnit();
		masUnit.setId(unitId);
		trainingStatusAircrew.setUnit(masUnit);
	}
		
	if(request.getParameter("fullName") != null && !request.getParameter("fullName").equals("")) {
		trainingStatusAircrew.setAircrewName(request.getParameter("fullName"));
	}

	if (request.getParameter(SR_AGE) != null && !request.getParameter(SR_AGE).equals("")) {
		if (request.getParameter(SR_AGE_UNIT) != null) {
			String ageUnit = request.getParameter(SR_AGE_UNIT);
			String srage = request.getParameter(SR_AGE).concat(" ").concat(ageUnit);
			trainingStatusAircrew.setAge(srage);
		}
	}
	if (request.getParameter(SEX_ID) != null && !request.getParameter(SEX_ID).equals("0")) {

		int genderId = Integer.parseInt(request.getParameter(SEX_ID));
		MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
		masAdministrativeSex.setId(genderId);
		trainingStatusAircrew.setSex(masAdministrativeSex);
	}
	
	if (request.getParameter("flyingExp") != null && !request.getParameter("flyingExp").equals("")) {
		trainingStatusAircrew.setFlyingExp(request.getParameter("flyingExp"));
	}
	if (request.getParameter("aircraftFlown") != null && !request.getParameter("aircraftFlown").equals("")) {
		trainingStatusAircrew.setAircraftFlown(request.getParameter("aircraftFlown"));
	}
	if (request.getParameter("currentType") != null && !request.getParameter("currentType").equals("")) {
		trainingStatusAircrew.setCurrentOnType(request.getParameter("currentType"));
	}
	if (request.getParameter("expType") != null && !request.getParameter("expType").equals("")) {
		trainingStatusAircrew.setExpOnType(request.getParameter("expType"));
	}
	if (request.getParameter("currentRating") != null && !request.getParameter("currentRating").equals("")) {
		trainingStatusAircrew.setCurrentRating(request.getParameter("currentRating"));
	}
	if (request.getParameter("basicIntro") != null && !request.getParameter("basicIntro").equals("")) {
		trainingStatusAircrew.setBasicIntroduction("y");
	}else{
		trainingStatusAircrew.setBasicIntroduction("n");
	}
	if (request.getParameter("ejectionTrainer") != null && !request.getParameter("ejectionTrainer").equals("")) {
		trainingStatusAircrew.setEjectionTrainer("y");
	}else{
		trainingStatusAircrew.setEjectionTrainer("n");
	}
	if (request.getParameter("diso") != null && !request.getParameter("diso").equals("")) {
		trainingStatusAircrew.setDiso("y");
	}else{
		trainingStatusAircrew.setDiso("n");
	}
	if (request.getParameter("optram") != null && !request.getParameter("optram").equals("")) {
		trainingStatusAircrew.setOptram("y");
	}else{
		trainingStatusAircrew.setOptram("n");
	}
	if (request.getParameter("nvg") != null && !request.getParameter("nvg").equals("")) {
		trainingStatusAircrew.setNvg("y");
	}else{
		trainingStatusAircrew.setNvg("n");
	}
	if (request.getParameter("localLecture") != null && !request.getParameter("localLecture").equals("")) {
		trainingStatusAircrew.setLocalLecture("y");
	}else{
		trainingStatusAircrew.setLocalLecture("n");
	}
	Date localLecDate = null;
	/*if (request.getParameter("localLecDate") != null && !request.getParameter("localLecDate").equals("")) {
		
		localLecDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter("localLecDate"));
		System.out.println("localLecDate"+localLecDate);
		trainingStatusAircrew.setTrainingDate(localLecDate);
	}*/
	
if (request.getParameter("localLectureDate") != null && !request.getParameter("localLectureDate").equals("")) {
		
		localLecDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter("localLectureDate"));
		System.out.println("localLecDate"+localLecDate);
		trainingStatusAircrew.setTrainingDate(localLecDate);
	}
	
	System.out.println("loca3lLecDate"+localLecDate);
	if (request.getParameter("content") != null && !request.getParameter("content").equals("")) {
		trainingStatusAircrew.setContent(request.getParameter("content"));
	}
	Date lastChgDate = null;
	if (request.getParameter(CHANGED_DATE) != null && !request.getParameter(CHANGED_DATE).equals("")) {
		lastChgDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(CHANGED_DATE));
		trainingStatusAircrew.setLastChgDate(lastChgDate);
	}

	String lastChgTime = "";
	if (request.getParameter(CHANGED_TIME) != null && !request.getParameter(CHANGED_TIME).equals("")) {
		lastChgTime = request.getParameter(CHANGED_TIME);
		trainingStatusAircrew.setLastChgTime(lastChgTime);
	}
	String lastChgBy = "";
	if (request.getParameter(CHANGED_BY) != null && !request.getParameter(CHANGED_BY).equals("")) {
		lastChgBy = request.getParameter(CHANGED_BY);
		trainingStatusAircrew.setLastChgBy(lastChgBy);
	}
	String flag="";
	if(request.getParameter("flag") !=null && !request.getParameter("flag").equals("")){
		flag=request.getParameter("flag");
	}
	infoMap.put("trainingStatusAircrew", trainingStatusAircrew);
	Boolean saved = false;
	
	map = aviationMedicineHandlerService.submitTrainingStatusAirCrew(infoMap);
	if(map.get("saved") !=null){
		saved=(Boolean)map.get("saved");
	}
	if(saved){
		message="Data Saved Successfully !Print Report?";
	}
	else{
		message="Try Again !!";
	}
	int avAccidentIdd=0;
	if(map.get("avAccidentIdd") !=null){
		avAccidentIdd=(Integer)map.get("avAccidentIdd");
	}
	String url="";
	url = "/hms/hms/aviationMedicine?method=showAircrewTrainingStatusJsp";
	jsp = AV_MESSAGE + ".jsp";

	map.put("flag", flag);
	map.put("avAccidentId", avAccidentIdd);
	map.put("url", url);
	map.put("message", message);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
	}

public ModelAndView submitSpecialLocalFeature(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	AvSpecialLocalFeature specialLocalFeature = new AvSpecialLocalFeature();
	String message = "";
	String jsp = "";
	int avAccidentId=0;
	if(request.getParameter("avAccidentId") !=null && !request.getParameter("avAccidentId").equals("")){
		avAccidentId=Integer.parseInt(request.getParameter("avAccidentId"));
		infoMap.put("avAccidentId", avAccidentId);
		specialLocalFeature = aviationMedicineHandlerService.loadLocalFeature(avAccidentId);
	}
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	MasHospital masHospital = new MasHospital();
	masHospital.setId(hospitalId);
	specialLocalFeature.setHospital(masHospital);
	
	int departmentId = (Integer) session.getAttribute("deptId");
	MasDepartment masDepartment = new MasDepartment();
	masDepartment.setId(departmentId);
	specialLocalFeature.setDepartment(masDepartment);
	
	if(request.getParameter("specialLocalFeature") != null && !request.getParameter("specialLocalFeature").equals("0")) {
		specialLocalFeature.setSpecialLocalFeature(request.getParameter("specialLocalFeature"));
	}
	Date lastChgDate = null;
	if (request.getParameter(CHANGED_DATE) != null && !request.getParameter(CHANGED_DATE).equals("")) {
		lastChgDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(CHANGED_DATE));
		specialLocalFeature.setLastChgDate(lastChgDate);
	}

	String lastChgTime = "";
	if (request.getParameter(CHANGED_TIME) != null && !request.getParameter(CHANGED_TIME).equals("")) {
		lastChgTime = request.getParameter(CHANGED_TIME);
		specialLocalFeature.setLastChgTime(lastChgTime);
	}
	String lastChgBy = "";
	if (request.getParameter(CHANGED_BY) != null && !request.getParameter(CHANGED_BY).equals("")) {
		lastChgBy = request.getParameter(CHANGED_BY);
		specialLocalFeature.setLastChgBy(lastChgBy);
	}
	infoMap.put("specialLocalFeature", specialLocalFeature);
	Boolean saved = false;
	
	map = aviationMedicineHandlerService.submitSpecialLocalFeature(infoMap);
	if(map.get("saved") !=null){
		saved=(Boolean)map.get("saved");
	}
	if(saved){
		message="Data Saved Successfully !";
	}
	else{
		message="Try Again !!";
	}
	String url="";
	url = "/hms/hms/aviationMedicine?method=showSpecialLocalFeatureJsp";
	jsp = AV_MESSAGE + ".jsp";
	map.put("url", url);
	map.put("message", message);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
public ModelAndView submitPreFlight(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	AvPreFlight preFlight = new AvPreFlight();
	String message = "";
	String jsp = "";
	int avAccidentId=0;
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	MultipartFormDataRequest mrequest = null;
	String filename="";
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
	//--------------------Save data in pateint table-------------------------------------------
	/*Patient patient = new Patient();
	
	patient.setHospital(masHospital);
	
	MasRelation masRelation =new MasRelation();
	masRelation.setId(8);
	patient.setRelation(masRelation);
	
	patient.setServiceType(new MasServiceType(2));
	
	MasServiceStatus serviceStatus=new MasServiceStatus();
	serviceStatus.setId(1);
	patient.setServiceStatus(serviceStatus);
	
		patient.setPFirstName(request.getParameter("fullName"));
		if (request.getParameter(SEX_ID) != null && !request.getParameter(SEX_ID).equals("0")) {
			int sexId = Integer.parseInt(request.getParameter(SEX_ID));
			MasAdministrativeSex masGender = new MasAdministrativeSex();
			masGender.setId(sexId);
			patient.setSex(masGender);
		}
		if (request.getParameter(SR_AGE) != null && !(request.getParameter(SR_AGE).equals(""))){
			if (request.getParameter(SR_AGE_UNIT) != null) {
				String ageUnit = request.getParameter(SR_AGE_UNIT);
				String srage = request.getParameter(SR_AGE).concat(" ").concat(ageUnit);
				patient.setAge(srage);
			}
		}
		if (request.getParameter(RANK_ID) != null && !request.getParameter(RANK_ID).equals("0")) {
			int rankId = Integer.parseInt(request.getParameter(RANK_ID));
			MasRank masRank = new MasRank();
			masRank.setId(rankId);
			patient.setRank(masRank);
		}
		if (request.getParameter(UNIT_ID) != null && !request.getParameter(UNIT_ID).equals("0")) {
			int unitId = Integer.parseInt(request.getParameter(UNIT_ID));
			MasUnit masUnit = new MasUnit();
			masUnit.setId(unitId);
			patient.setUnit(masUnit);
		}
		patient.setPatientStatus("Out Patient");
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
		}
		int serviceTypeId =2;//---for Airforce
		
		int relationId = 8; //---For Self
		
		int serviceStatusId = 1; //---Serving
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String currentTime = (String) utilMap.get("currentTime");
		if (serviceTypeId == 2) {
			String serviceNoTemp = "no"; 
			
			try {

				serviceNoTemp = currentDate.substring(0, currentDate
						.indexOf("/"))
						+ currentDate.substring(currentDate.indexOf("/") + 1,
								currentDate.lastIndexOf("/"))
						+ currentDate.substring(
								currentDate.lastIndexOf("/") + 3, currentDate
										.length())
						+ currentTime.substring(0, currentTime.indexOf(":"))
						+ currentTime.substring(currentTime.indexOf(":") + 1,
								currentTime.lastIndexOf(":"))
						+ currentTime.substring(
								currentTime.lastIndexOf(":") + 1, currentTime
										.length());
				serviceNo = serviceNoTemp;
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(request.getParameter(SERVICE_NO) != null && !request.getParameter(SERVICE_NO).equals("0")) {
				serviceNo=request.getParameter(SERVICE_NO);
			}
		}
		Map<String, Object> serviceAndRelationMap = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("serviceTypeId", serviceTypeId);
		parameterMap.put("relationId", relationId);
		parameterMap.put("serviceStatusId", serviceStatusId);

		serviceAndRelationMap = registrationHandlerService
				.getServiceTypeAndRelation(parameterMap);
		String relationCode = "8";
		String serviceTypeCode = (String) serviceAndRelationMap
				.get("serviceTypeCode");
		String serviceStatusCode = (String) serviceAndRelationMap
				.get("serviceStatusCode");
		String maxSequenceNo = "";
		maxSequenceNo = registrationHandlerService.getHinId(serviceNo,serviceTypeId);
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
		patient.setStatus("y");
		patient.setServiceNo(serviceNo);
		patient.setRegDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		patient.setRegTime(request.getParameter(CHANGED_TIME));
		patient.setHinNo(hinNo);
		Date addEditDate = null;
		if (request.getParameter(CHANGED_DATE) != null) {
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
			patient.setAddEditDate(addEditDate);
		}
		String addEditTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			addEditTime = request.getParameter(CHANGED_TIME);
			patient.setAddEditTime(addEditTime);
		}*/
	
	//----------------------------------
	if(mrequest.getParameter("avAccidentId") !=null && !mrequest.getParameter("avAccidentId").equals("")){
		avAccidentId=Integer.parseInt(mrequest.getParameter("avAccidentId"));
		infoMap.put("avAccidentId", avAccidentId);
		preFlight = aviationMedicineHandlerService.loadPreFlight(avAccidentId);
	}
	MasHospital masHospital = new MasHospital();
	masHospital.setId(hospitalId);
	preFlight.setHospital(masHospital);
	
	int departmentId = (Integer) session.getAttribute("deptId");
	MasDepartment masDepartment = new MasDepartment();
	masDepartment.setId(departmentId);
	preFlight.setDepartment(masDepartment);
	Date flyingDate = null;
	if (mrequest.getParameter(DATE) != null && !mrequest.getParameter(DATE).equals("")) {
		flyingDate = HMSUtil.convertStringTypeDateToDateType(mrequest.getParameter(DATE));
		preFlight.setFlightDate(flyingDate);
	
	}
	int unitId=0;
	if (mrequest.getParameter("unitNameId") != null && !mrequest.getParameter("unitNameId").equals("0")) {
		unitId = Integer.parseInt(mrequest.getParameter("unitNameId"));
		MasUnit masUnit=new MasUnit();
		masUnit.setId(unitId);
		preFlight.setUnit(masUnit);
	}
	int medOfficer=0;
	if (mrequest.getParameter("medOfficer") != null && !mrequest.getParameter("medOfficer").equals("0")) {
		medOfficer = Integer.parseInt(mrequest.getParameter("medOfficer"));
		MasEmployee masEmployee=new MasEmployee();
		masEmployee.setId(medOfficer);
		preFlight.setMoName(masEmployee);
	}
	if (mrequest.getParameter(TIME) != null && !mrequest.getParameter(TIME).equals("")) {
		preFlight.setFlightTime(mrequest.getParameter(TIME));
	}
	if (mrequest.getParameter("wgcdr") != null && !mrequest.getParameter("wgcdr").equals("")) {
		preFlight.setRectifiedWgcdr("y");
	}
	else{
		preFlight.setRectifiedWgcdr("n");
	}
	if (mrequest.getParameter("mo") != null && !mrequest.getParameter("mo").equals("")) {
		preFlight.setRectifiedMo("y");
	}
	else{
		preFlight.setRectifiedMo("n");
	}
	if(mrequest.getParameter("unfitRemarks") != null && !mrequest.getParameter("unfitRemarks").equals("")) {
		preFlight.setUnfitRemarks(mrequest.getParameter("unfitRemarks"));
	}
	Date lastChgDate = null;
	if (mrequest.getParameter(CHANGED_DATE) != null && !mrequest.getParameter(CHANGED_DATE).equals("")) {
		lastChgDate = HMSUtil.convertStringTypeDateToDateType(mrequest
				.getParameter(CHANGED_DATE));
		preFlight.setLastChgDate(lastChgDate);
	}

	String lastChgTime = "";
	if (mrequest.getParameter(CHANGED_TIME) != null && !mrequest.getParameter(CHANGED_TIME).equals("")) {
		lastChgTime = mrequest.getParameter(CHANGED_TIME);
		preFlight.setLastChgTime(lastChgTime);
	}
	String lastChgBy = "";
	if (mrequest.getParameter(CHANGED_BY) != null && !mrequest.getParameter(CHANGED_BY).equals("")) {
		lastChgBy = mrequest.getParameter(CHANGED_BY);
		preFlight.setLastChgBy(lastChgBy);
	}
	/*int hinId=0;
	if (mrequest.getParameter(HIN_ID) != null && !request.getParameter(HIN_ID).equals("")) {
		 hinId = Integer.parseInt(request.getParameter(HIN_ID));
		patient.setId(hinId);
		preFlight.setHin(patient);
	}
		
	if (request.getParameter(RANK_ID) != null && !request.getParameter(RANK_ID).equals("0")) {
		int rankId = Integer.parseInt(request.getParameter(RANK_ID));
		MasRank masRank = new MasRank();
		masRank.setId(rankId);
		preFlight.setRank(masRank);
	}
	if (request.getParameter(UNIT_ID) != null && !request.getParameter(UNIT_ID).equals("0")) {
		int unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		MasUnit masUnit = new MasUnit();
		masUnit.setId(unitId);
		preFlight.setUnit(masUnit);
	}
		
	if(request.getParameter("fullName") != null && !request.getParameter("fullName").equals("")) {
		preFlight.setFullName(request.getParameter("fullName"));
	}

	if (request.getParameter(SR_AGE) != null && !request.getParameter(SR_AGE).equals("")) {
		if (request.getParameter(SR_AGE_UNIT) != null) {
			String ageUnit = request.getParameter(SR_AGE_UNIT);
			String srage = request.getParameter(SR_AGE).concat(" ").concat(ageUnit);
			preFlight.setAge(srage);
		}
	}
	if (request.getParameter(SEX_ID) != null && !request.getParameter(SEX_ID).equals("0")) {

		int genderId = Integer.parseInt(request.getParameter(SEX_ID));
		MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
		masAdministrativeSex.setId(genderId);
		preFlight.setSex(masAdministrativeSex);
	}
	
	if (request.getParameter("shortiDay") != null && !request.getParameter("shortiDay").equals("")) {
		preFlight.setShortiDay(request.getParameter("shortiDay"));
	}
	//infoMap.put("hinId", hinId);
	
	//infoMap.put("patient", patient);
	if (request.getParameter("visualInspectiion") != null && !request.getParameter("visualInspectiion").equals("")) {
		preFlight.setVisualInspetion(request.getParameter("visualInspectiion"));
	}*/
	
	String flag="";
	if(request.getParameter("flag") !=null && !request.getParameter("flag").equals("")){
		flag=request.getParameter("flag");
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
	int immCount=1;
	if (Integer.parseInt(mrequest.getParameter("immCount")) != 1) {
		immCount = Integer.parseInt(mrequest.getParameter("immCount"));
	}
	for (int i = 1; i <=immCount; i++) {
		
		
		if(mrequest.getParameter(SERVICE_NO+ i) != null ){
			serviceNoList.add(mrequest.getParameter(SERVICE_NO+ i));
		}else{
			serviceNoList.add(null);
		}
		if(mrequest.getParameter("flightId"+ i) != null &&(!mrequest.getParameter("flightId"+ i).equals("0"))){
			flightIdList.add(Integer.parseInt(mrequest.getParameter("flightId"+ i)));
		}else{
			flightIdList.add(0);
		}
		if(mrequest.getParameter(CATEGORY_ID+ i) != null &&(!mrequest.getParameter(CATEGORY_ID+ i).equals("0"))){
			categoryIdList.add(Integer.parseInt(mrequest.getParameter(CATEGORY_ID+ i)));
		}else{
			categoryIdList.add(0);
		}
		if(mrequest.getParameter(RANK_ID+ i) != null &&(!mrequest.getParameter(RANK_ID+ i).equals("0"))){
			rankIdList.add(Integer.parseInt(mrequest.getParameter(RANK_ID+ i)));
		}else{
			rankIdList.add(null);
		}
		if(mrequest.getParameter(HIN_ID+ i) != null &&(!mrequest.getParameter(HIN_ID+ i).equals("0"))){
			hinIdList.add(Integer.parseInt(mrequest.getParameter(HIN_ID+ i)));
		}else{
			hinIdList.add(null);
		}
		if(mrequest.getParameter("pilotName"+ i) != null &&(!mrequest.getParameter("pilotName"+ i).equals(""))){
			fullNameList.add(mrequest.getParameter("pilotName"+ i));
		}else{
			fullNameList.add("");
		}
		if(mrequest.getParameter(SEX_ID+ i) != null &&(!mrequest.getParameter(SEX_ID+ i).equals("0"))){
			sexIdList.add(Integer.parseInt(mrequest.getParameter(SEX_ID+ i)));
		}else{
			sexIdList.add(null);
		}
		if(mrequest.getParameter(AGE+ i) != null && !mrequest.getParameter(AGE+ i).equals("")){
			ageList.add(mrequest.getParameter(AGE+ i));
		}else{
			ageList.add("");
		}
		if(mrequest.getParameter(UNIT_ID+ i) != null &&(!mrequest.getParameter(UNIT_ID+ i).equals("0"))){
			unitIdList.add(Integer.parseInt(mrequest.getParameter(UNIT_ID+ i)));
		}else{
			unitIdList.add(null);
		}
		if(mrequest.getParameter("sortiDay"+ i) != null && !mrequest.getParameter("sortiDay"+ i).equals("")){
			sortieList.add(mrequest.getParameter("sortiDay"+ i));
		}else{
			sortieList.add("");	
		}
		if(mrequest.getParameter("visualInspec"+ i) != null && (!mrequest.getParameter("visualInspec"+ i).equals(""))){
			visualInspectList.add(mrequest.getParameter("visualInspec"+ i));
		}else{
			visualInspectList.add(null);
		}
		
		String fileExtension=null;
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome+fileSeparator+"photo"+fileSeparator;
		List fileUploadedList = null;
		if(request.getParameter("filename"+ i) != null && (!request.getParameter("filename"+ i).equals(""))){
			filename=request.getParameter("filename"+ i);
		}
		if(request.getParameter("filename" + i) !=null){
		StringTokenizer strToken = new StringTokenizer(request.getParameter("filename" + i), ".");

		filename = strToken.nextToken();
		fileExtension = strToken.nextToken();
		String whiteList = "*." + fileExtension;
		fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL, whiteList, mrequest.getParameter(SERVICE_NO+ i)+"."+fileExtension, i);
		
		infoMap.put("fileUploadedList", fileUploadedList);
		infoMap.put("uploadURL", uploadURL);
		infoMap.put("extension", "jpg");
	}
	}
	infoMap.put("categoryIdList", categoryIdList);
	infoMap.put("flightIdList",flightIdList);
	infoMap.put("preFlight", preFlight);
	infoMap.put("hdbvalue", immCount);
	infoMap.put("rankIdList", rankIdList);
	infoMap.put("sexIdList", sexIdList);
	infoMap.put("hinIdList", hinIdList);
	infoMap.put("unitIdList", unitIdList);
	infoMap.put("fullNameList", fullNameList);
	infoMap.put("serviceNoList", serviceNoList);
	infoMap.put("ageList", ageList);
	infoMap.put("visualInspectList", visualInspectList);
	infoMap.put("sortieList", sortieList);
	
	System.out.println("serviceNoList in controller="+serviceNoList.size());
	Boolean saved = false;
	
	map = aviationMedicineHandlerService.submitPreFlight(infoMap);
	if(map.get("saved") !=null){
		saved=(Boolean)map.get("saved");
	}
	if(saved){
		message="Data Saved Successfully !Print Report?";
	}
	else{
		message="Try Again !!";
	}
	int avAccidentIdd=0;
	if(map.get("avAccidentIdd") !=null){
		avAccidentIdd=(Integer)map.get("avAccidentIdd");
	}
	String url="";
	url = "/hms/hms/aviationMedicine?method=showPreFlightMedicalCheckupJsp";
	jsp = AV_MESSAGE + ".jsp";

	System.out.println("flag="+flag);
	map.put("flag", flag);
/*	map.put("hinNo", hinNo);
	map.put("serviceNo",serviceNo);*/
	map.put("avAccidentId", avAccidentIdd);
	map.put("url", url);
	map.put("message", message);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
	}
public ModelAndView submitAircrewRation(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	AvAircrewRationHd aircrewRationHd = new AvAircrewRationHd();
	Box box = null;
	if(session.getAttribute("box")!=null){
		box = (Box)session.getAttribute("box");
	}else{
		box = HMSUtil.getBox(request);
	}
	String message = "";
	String jsp = "";
	int avAccidentId=0;
	if(request.getParameter("avAccidentId") !=null && !request.getParameter("avAccidentId").equals("")){
		avAccidentId=Integer.parseInt(request.getParameter("avAccidentId"));
		infoMap.put("avAccidentId", avAccidentId);
		aircrewRationHd = aviationMedicineHandlerService.loadAircrewRationHd(avAccidentId);
	}
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	MasHospital masHospital = new MasHospital();
	masHospital.setId(hospitalId);
	aircrewRationHd.setHospital(masHospital);
	
	int departmentId = (Integer) session.getAttribute("deptId");
	MasDepartment masDepartment = new MasDepartment();
	masDepartment.setId(departmentId);
	aircrewRationHd.setDepartment(masDepartment);
	
	if(request.getParameter(SERVICE_NO) != null && !request.getParameter(SERVICE_NO).equals("0")) {
		aircrewRationHd.setServiceNo(request.getParameter(SERVICE_NO));
	}
	Date flyingDate = null;
	if (request.getParameter(DATE) != null && !request.getParameter(DATE).equals("")) {
		flyingDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE));
		aircrewRationHd.setAircrewDate(flyingDate);
	
	}
	if (request.getParameter(HIN_ID) != null && !request.getParameter(HIN_ID).equals("0")) {
		int hinId = Integer.parseInt(request.getParameter(HIN_ID));
		Patient patient = new Patient();
		patient.setId(hinId);
		aircrewRationHd.setHin(patient);
	}
		
	if (request.getParameter(TIME) != null && !request.getParameter(TIME).equals("")) {
		aircrewRationHd.setAircrewTime(request.getParameter(TIME));
	}
	if (request.getParameter(RANK_ID) != null && !request.getParameter(RANK_ID).equals("0")) {
		int rankId = Integer.parseInt(request.getParameter(RANK_ID));
		MasRank masRank = new MasRank();
		masRank.setId(rankId);
		aircrewRationHd.setRank(masRank);
	}
	if (request.getParameter(UNIT_ID) != null && !request.getParameter(UNIT_ID).equals("0")) {
		int unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		MasUnit masUnit = new MasUnit();
		masUnit.setId(unitId);
		aircrewRationHd.setUnit(masUnit);
	}
		
	if(request.getParameter("fullName") != null && !request.getParameter("fullName").equals("")) {
		aircrewRationHd.setFullName(request.getParameter("fullName"));
	}

	if (request.getParameter(SR_AGE) != null && !request.getParameter(SR_AGE).equals("")) {
		if (request.getParameter(SR_AGE_UNIT) != null) {
			String ageUnit = request.getParameter(SR_AGE_UNIT);
			String srage = request.getParameter(SR_AGE).concat(" ").concat(ageUnit);
			aircrewRationHd.setAge(srage);
		}
	}
	if (request.getParameter(SEX_ID) != null && !request.getParameter(SEX_ID).equals("0")) {

		int genderId = Integer.parseInt(request.getParameter(SEX_ID));
		MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
		masAdministrativeSex.setId(genderId);
		aircrewRationHd.setSex(masAdministrativeSex);
	}
	

	Date lastChgDate = null;
	if (request.getParameter(CHANGED_DATE) != null && !request.getParameter(CHANGED_DATE).equals("")) {
		lastChgDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(CHANGED_DATE));
		aircrewRationHd.setLastChgDate(lastChgDate);
	}

	String lastChgTime = "";
	if (request.getParameter(CHANGED_TIME) != null && !request.getParameter(CHANGED_TIME).equals("")) {
		lastChgTime = request.getParameter(CHANGED_TIME);
		aircrewRationHd.setLastChgTime(lastChgTime);
	}
	String lastChgBy = "";
	if (request.getParameter(CHANGED_BY) != null && !request.getParameter(CHANGED_BY).equals("")) {
		lastChgBy = request.getParameter(CHANGED_BY);
		aircrewRationHd.setLastChgBy(lastChgBy);
	}
	String flag="";
	if(request.getParameter("flag") !=null && !request.getParameter("flag").equals("")){
		flag=request.getParameter("flag");
	}
	infoMap.put("aircrewRationHd", aircrewRationHd);
	infoMap.put("box", box);
	Boolean saved = false;
	
	map = aviationMedicineHandlerService.submitAircrewRation(infoMap);
	if(map.get("saved") !=null){
		saved=(Boolean)map.get("saved");
	}
	if(saved){
		message="Data Saved Successfully !Print Report?";
	}
	else{
		message="Try Again !!";
	}
	int avAccidentIdd=0;
	if(map.get("avAccidentIdd") !=null){
		avAccidentIdd=(Integer)map.get("avAccidentIdd");
	}
	String url="";
	url = "/hms/hms/aviationMedicine?method=showAircrewRationJsp";
	jsp = AV_MESSAGE + ".jsp";

	map.put("flag", flag);
	map.put("avAccidentId", avAccidentIdd);
	map.put("url", url);
	map.put("message", message);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
	}
public ModelAndView getSerNoDetailForIncident(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box  = HMSUtil.getBox(request);
	String serviceNo="";
	if (request.getParameter("serviceNo") != null	&& !(request.getParameter("serviceNo").equals(""))) {
		serviceNo =request.getParameter("serviceNo");
		box.put("serviceNo", serviceNo);
	}
	map = aviationMedicineHandlerService.getSerNoDetailForIncident(box);
	
	return new ModelAndView("av_respSrNoIncident","map",map);
}
public ModelAndView getSerNoDetailForAccident(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box  = HMSUtil.getBox(request);
	String serviceNo="";
	if (request.getParameter("serviceNo") != null	&& !(request.getParameter("serviceNo").equals(""))) {
		serviceNo =request.getParameter("serviceNo");
		box.put("serviceNo", serviceNo);
	}
	map = aviationMedicineHandlerService.getSerNoDetailForAccident(box);
	
	return new ModelAndView("av_respSrNoAccident","map",map);
}

public ModelAndView getSerNoDetailForTraining(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box  = HMSUtil.getBox(request);
	String serviceNo="";
	if (request.getParameter("serviceNo") != null	&& !(request.getParameter("serviceNo").equals(""))) {
		serviceNo =request.getParameter("serviceNo");
		box.put("serviceNo", serviceNo);
	}
	map = aviationMedicineHandlerService.getSerNoDetailForTraining(box);
	
	return new ModelAndView("av_respSrNoTraining","map",map);
}
public ModelAndView getSerNoDetailPreFlight(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box  = HMSUtil.getBox(request);
	String serviceNo="";
	if (request.getParameter("serviceNo") != null	&& !(request.getParameter("serviceNo").equals(""))) {
		serviceNo =request.getParameter("serviceNo");
		box.put("serviceNo", serviceNo);
	}
	map = aviationMedicineHandlerService.getSerNoDetailPreFlight(box);
	
	return new ModelAndView("av_respSrNoPreFlight","map",map);
}
public ModelAndView getSerNoDetailForRation(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box  = HMSUtil.getBox(request);
	String serviceNo="";
	if (request.getParameter("serviceNo") != null	&& !(request.getParameter("serviceNo").equals(""))) {
		serviceNo =request.getParameter("serviceNo");
		box.put("serviceNo", serviceNo);
	}
	map = aviationMedicineHandlerService.getSerNoDetailForRation(box);
	
	return new ModelAndView("av_respSrNoRation","map",map);
}
public ModelAndView generateFlyingIncident(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> parameters = new HashMap<String, Object>();
	String query = "";
	if (request.getParameter("avAccidentId") != null
			&& (!request.getParameter("avAccidentId").equals("0"))) {
		
		query = "where F.FLYING_INCIDENT_ID = '"
				+ request.getParameter("avAccidentId") + "' ";
	}
	detailsMap = aviationMedicineHandlerService.getConnectionForReport();
	parameters.put("query", query);
	HMSUtil.generateReport("av_Flying_incident", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
	return null;
}
public ModelAndView generateFlyingIncidentRpt(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> parameters = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Date fromDate = null;
	Date toDate = null;
	Box box = null;
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
	detailsMap = aviationMedicineHandlerService.getConnectionForReport();
	parameters.put("fromDate", fromDate);
	parameters.put("toDate", toDate);
	HMSUtil.generateReport("av_Flying_incidentDate", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
	return null;
}
public ModelAndView generateAircraftAccident(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> parameters = new HashMap<String, Object>();
	String query = "";
	if (request.getParameter("avAccidentId") != null
			&& (!request.getParameter("avAccidentId").equals("0"))) {
		
		query = "where AIRCRAFT_ACCIDENT_ID = '"
				+ request.getParameter("avAccidentId") + "' ";
	}
	detailsMap = aviationMedicineHandlerService.getConnectionForReport();
	parameters.put("query", query);
	HMSUtil.generateReport("av_Aircraft_Accident", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
	return null;
}
public ModelAndView generateAircraftAccidentRpt(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> parameters = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Date fromDate = null;
	Date toDate = null;
	Box box = null;
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
	detailsMap = aviationMedicineHandlerService.getConnectionForReport();
	parameters.put("fromDate", fromDate);
	parameters.put("toDate", toDate);
	HMSUtil.generateReport("av_Aircraft_AccidentDate", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
	return null;
}
public ModelAndView generateTrainingStatus(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> parameters = new HashMap<String, Object>();
	String query = "";
	if (request.getParameter("avAccidentId") != null
			&& (!request.getParameter("avAccidentId").equals("0"))) {
		
		query = "where AV_TRAINING_ID= '"
				+ request.getParameter("avAccidentId") + "' ";
	}
	detailsMap = aviationMedicineHandlerService.getConnectionForReport();
	parameters.put("query", query);
	HMSUtil.generateReport("av_aircrewTrainingStatus", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
	return null;
}
public ModelAndView generateTrainingStatusRpt(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> parameters = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Date fromDate = null;
	Date toDate = null;
	Box box = null;
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
	detailsMap = aviationMedicineHandlerService.getConnectionForReport();
	parameters.put("fromDate", fromDate);
	parameters.put("toDate", toDate);
	HMSUtil.generateReport("av_aircrewTrainingStatusDate", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
	return null;
}
public ModelAndView generateAircrewRation(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> parameters = new HashMap<String, Object>();
	String query = "";
	if (request.getParameter("avAccidentId") != null
			&& (!request.getParameter("avAccidentId").equals("0"))) {
		
		query = "where ID = '"
				+ request.getParameter("avAccidentId") + "' ";
	}

	detailsMap = aviationMedicineHandlerService.getConnectionForReport();
	parameters.put("query", query);
	parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
	HMSUtil.generateReport("av_AircrewRation", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
	return null;
}
public ModelAndView generateAircrewRationRpt(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> parameters = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Date fromDate = null;
	Date toDate = null;
	Box box = null;
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
	detailsMap = aviationMedicineHandlerService.getConnectionForReport();
	parameters.put("fromDate", fromDate);
	parameters.put("toDate", toDate);
	parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
	HMSUtil.generateReport("av_AircrewRationDate", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
	return null;
}
public ModelAndView generatePreFlightRpt(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> parameters = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Date fromDate = null;
	Date toDate = null;
	Box box = null;
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
	int hospitalId=0;
	if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("") && request.getParameter("hospitalId").equals("0")){
		
		qry += "  and h.command_id="+Integer.parseInt(request.getParameter("cmdId"));
	}else{
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		qry += "  and pf.hospital_id="+hospitalId;
	}
	parameters.put("hospitalId", hospitalId);
	
	detailsMap = aviationMedicineHandlerService.getConnectionForReport();
	parameters.put("fromDate", fromDate);
	parameters.put("toDate", toDate);
	parameters.put("query", qry);
	HMSUtil.generateReport("av_pre_flight_med_checkupDate", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
	return null;
}
public ModelAndView generatePreFlight(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> parameters = new HashMap<String, Object>();
	String query = "";
	int avAccidentId =0;
	if (request.getParameter("avAccidentId") != null
			&& (!request.getParameter("avAccidentId").equals("0"))) {
		
		avAccidentId = Integer.parseInt(request.getParameter("avAccidentId"));
	}

	detailsMap = aviationMedicineHandlerService.getConnectionForReport();
	
	parameters.put("avAccidentId", avAccidentId);
	parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
	HMSUtil.generateReport("av_pre_flight_med_checkup", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
	return null;
}
//----------By Mansi-(22/march/2012)----	
public ModelAndView getServiceNoDetailsForRegEquipmentInUse(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box  = HMSUtil.getBox(request);
	map = aviationMedicineHandlerService.getServiceNoDetailsForRegEquipmentInUse(box);
	
	return new ModelAndView("av_responseForSrNoEquipmentInUse","map",map);
}

//----------Method written by Kiran -(9/May/2012)-----

	public ModelAndView showAircrewTrainingStatusJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = aviationMedicineHandlerService.showFlyingIncidentJsp();
		jsp = "av_aircrewTrainingStatus.jsp";
	
		title = "Aircrew Training Status";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showFlyingIncidentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = aviationMedicineHandlerService.showFlyingIncidentJsp();
		jsp = "av_flyingIncident.jsp";
	
		title = "Flying Incident";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAircraftAccidentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = aviationMedicineHandlerService.showFlyingIncidentJsp();
		jsp = "av_aircraftAccident.jsp";
	
		title = "Aircraft Accident";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showSpecialLocalFeatureJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = aviationMedicineHandlerService.showSpecialLocalFeatureJsp();
		jsp = "av_specialLocalFeature.jsp";
	
		title = "Special Local Feature";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAircrewRationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		map = aviationMedicineHandlerService.showAircrewRationJsp();
		jsp = "av_aircrewRation.jsp";
	
		title = "Aircrew Ration";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPreFlightMedicalCheckupJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String jsp = "";
		String title = "";
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		dataMap.put("hospitalId",hospitalId);
		map = aviationMedicineHandlerService.showPreFlightMedical(dataMap);
		jsp = "av_preFlightMedicalCheckup.jsp";
		title = "Pre Flight Medical Checkup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
//-----Reports	
	
	public ModelAndView showFlyIncidentRpt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		
		jsp = "av_FlyIncidentRpt.jsp";
	
		title = "Flying Incident Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showAirAccidentRpt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";		
		jsp = "av_AirAccidentRpt.jsp";	
		title = "Aircraft Accident Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showTrainingStatusRpt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		
		jsp = "av_TrainingStatusRpt.jsp";
	
		title = "Training Status of Aircraft Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showAirRationRpt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		
		jsp = "av_AirRationRpt.jsp";
	
		title = "Aircrew Ration Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPreFlightRpt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		
		jsp = "av_PreFlightRpt.jsp";
	
		title = "Pre Flight Medical Checkup Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	private void uploadPhoto(HttpServletRequest request) {
		String url = "";
		String hinNo = "";
		if (request.getParameter("photoUrl") != null) {
			url = request.getParameter("photoUrl");
		}
		if (request.getParameter(SERVICE_NO) != null) {
			hinNo = request.getParameter(SERVICE_NO);
		}

		String str = "\\";
		String fileName = url.substring(url.lastIndexOf(str) + 1);
		String imageType = fileName.substring(fileName.lastIndexOf(".") + 1);
		String newFileName = hinNo.concat(".").concat(imageType);

		try {
			int count;
			if (!url.equals("")) {
				FileInputStream fis = new FileInputStream(url);
				File file = new File(url);
				int length = (int) file.length();

				byte data[] = new byte[length];

				File reportFile = new File(getServletContext().getRealPath(
						"/patientphoto/" + newFileName));
				if (!reportFile.exists()) {
					new File(newFileName).createNewFile();
				}

				FileOutputStream fos = new FileOutputStream(reportFile);
				while ((count = fis.read(data, 0, length)) != -1) {
					fos.write(data, 0, count);
				}
				fos.flush();
				fos.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public ModelAndView displayPreFlightPhoto(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		String serviceNo = "";
		if(request.getParameter(HIN_NO)!= null){
			hinNo = request.getParameter(HIN_NO);
		}
		if(request.getParameter("serviceNo")!= null){
			serviceNo = request.getParameter("serviceNo");
		}
		map = aviationMedicineHandlerService.displayPreFlightPhoto(hinNo);
		String jsp = AV_PHOTO_POPUP_JSP;
		map.put("serviceNo", serviceNo);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView getServicePersonName(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		int serviceTypeId = 0; 
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(SERVICE_TYPE_ID)!= null && !request.getParameter(SERVICE_TYPE_ID).equals("0")) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
		}
		String type = "";
		if(request.getParameter("type") != null){
			type = request.getParameter("type");
		}
		map = registrationHandlerService.getServicePersonName(serviceNo,
				serviceTypeId);
		if(request.getParameter(SERVICE_STATUS_ID)!=null)
			map.put("serviceStatusId", Integer.parseInt(request.getParameter(SERVICE_STATUS_ID)));
		if(request.getParameter("prefix")!=null)
			map.put("prefix",request.getParameter("prefix"));
		if(request.getParameter("suffix")!=null)
			map.put("suffix",request.getParameter("suffix"));
		
		map.put("serviceNo",serviceNo);
		if(request.getParameter("echs")!=null){
			map.put("echs",request.getParameter("echs"));
		}
		String jsp = "";
			jsp = "av_respServPersonName";
		
		return new ModelAndView(jsp, "map", map);

	}
	
	public void fillAVServiceDetail(HttpServletRequest request,
			HttpServletResponse response) {
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
		map = aviationMedicineHandlerService.fillAVServiceDetail(dataMap);
		if (map.get("patientList") != null) {
			patientList = (List) map.get("patientList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (Patient patient : patientList) {
				sb.append("<item>");
				if (patient.getRank() != null) {
					sb.append("<rankName>" + patient.getRank().getRankName()+ "</rankName>");
					sb.append("<rankId>" + patient.getRank().getId()+ "</rankId>");
				} else {
					sb.append("<rankName>-</rankName>");
					sb.append("<rankId>-</rankId>");
				}
				String name="";
				name=patient.getPFirstName();
				if(patient.getPLastName() !=null ){
					name=name+" "+patient.getPLastName();
				}
				sb.append("<sName>" + name + "</sName>");
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
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());

		return jasperReport;
	}
	
	public void fillRegisterDetail(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		
		String serviceNo="";
		if(request.getParameter(SERVICE_NO) !=null && !request.getParameter(SERVICE_NO).equals("")){
			serviceNo=request.getParameter(SERVICE_NO) ;
		}
		dataMap.put("serviceNo", serviceNo);
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		dataMap.put("hospitalId", hospitalId);
		map = aviationMedicineHandlerService.fillRegisterDetail(dataMap);
		if (map.get("patientList") != null) {
			patientList = (List) map.get("patientList");
		}
		MasMedicalExaminationReportOnEntry examiationReportOnEntry=new MasMedicalExaminationReportOnEntry();
		if(map.get("examinationReportOnEntry") !=null){
		examiationReportOnEntry=(MasMedicalExaminationReportOnEntry)map.get("examinationReportOnEntry");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (Patient patient : patientList) {
				sb.append("<item>");
				sb.append("<hinId>" + patient.getId() + "</hinId>");
				
				String name="";
				name=patient.getPFirstName();
				if(patient.getPLastName() !=null){
				name=name+" "+patient.getPLastName();
				}
				sb.append("<name>" +name+ "</name>");
				sb.append("<age>" + patient.getAge() + "</age>");
				if (patient.getSex() != null) {
					sb
							.append("<sexId>" + patient.getSex().getId()+ "</sexId>");
				} else {
					sb.append("<sexId>-</sexId>");
				}

				if (patient.getRank() != null) {
					sb.append("<rankId>" + patient.getRank().getId()+ "</rankId>");
				} else {
					sb.append("<rankId>-</rankId>");
				}
				if (patient.getUnit() != null) {
					sb.append("<unitId>" + patient.getUnit().getId()+ "</unitId>");
				} else {
					sb.append("<unitId>-</unitId>");
				}
				if(patient.getServiceNo().equals(examiationReportOnEntry.getServiceNo())){
				if(examiationReportOnEntry.getPresentMedicalCategory() !=null){
					sb.append("<categoryId>" + examiationReportOnEntry.getPresentMedicalCategory().getCategoryid()+ "</categoryId>");
				}else{
					sb.append("<categoryId></categoryId>");
				}}else{
					sb.append("<categoryId></categoryId>");
				}
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
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ModelAndView inactivePreFlight(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		List<String> checkList = new ArrayList<String>();
		List<Integer> flightIdList = new ArrayList<Integer>();
		int hdbvalue=1;
		if (request.getParameter("hdb") !=null && Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdbvalue = Integer.parseInt(request.getParameter("hdb"));
		}
		for (int i = 1; i <=hdbvalue; i++) {
			if (request.getParameter("check" + i) != null ) {
				checkList.add("y");
			} else {
				checkList.add("n");
			}
			if(request.getParameter("flightId"+ i) != null &&(!request.getParameter("flightId"+ i).equals("0"))){
				flightIdList.add(Integer.parseInt(request.getParameter("flightId"+ i)));
			}else{
				flightIdList.add(0);
			}
	}
		infoMap.put("checkList",checkList);
		infoMap.put("flightIdList",flightIdList);
		Boolean saved = false;
		String message="";
		map = aviationMedicineHandlerService.inactivePreFlight(infoMap);
		if(map.get("saved") !=null){
			saved=(Boolean)map.get("saved");
		}
		if(saved){
			message="Inactivated Successfully....";
			if (request.getParameter("image") != null) {
				uploadPhoto(request);
			}
		}
		else{
			message="Try Again !!";
		}
		int avAccidentIdd=0;
		if(map.get("avAccidentIdd") !=null){
			avAccidentIdd=(Integer)map.get("avAccidentIdd");
		}
		String url="";
		url = "/hms/hms/aviationMedicine?method=showPreFlightMedicalCheckupJsp";
		jsp = AV_MESSAGE + ".jsp";

	/*	map.put("hinNo", hinNo);
		map.put("serviceNo",serviceNo);*/
		map.put("avAccidentId", avAccidentIdd);
		map.put("url", url);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
}
	public ModelAndView displayRegisPhoto(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		String serviceNo = "";
	/*	if(request.getParameter(HIN_NO)!= null){
			hinNo = request.getParameter(HIN_NO);
		}*/
		if(request.getParameter("serviceNo")!= null){
			serviceNo = request.getParameter("serviceNo");
		}
		map = aviationMedicineHandlerService.displayAVRegisPhoto(serviceNo);
		String jsp = AV_PHOTO_POPUP_JSP;
		map.put("serviceNo", serviceNo);
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView addPhotoFile(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MultipartFormDataRequest mrequest = null;
		HttpSession session = request.getSession();
		
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
		String fileExtension=null;
		//String uploadURL = getServletContext().getRealPath("/photo/");
		String userHome = getServletContext().getRealPath("");
 		String fileSeparator = System.getProperty("file.separator");
// 		String uploadURL = userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"HMS"+fileSeparator+"photo"+fileSeparator;
 		String uploadURL = userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"photo"+fileSeparator;
		String filename = "";
		int hospitalId=0;
		String userName="";
		String age="";
		String gender="";
		String serviceNo = "";
		List fileUploadedList = null;
		
			if(request.getParameter("filename")!= null){
				filename = request.getParameter("filename");
			}
			if(mrequest.getParameter("serviceNo")!= null){
				serviceNo = mrequest.getParameter("serviceNo");
				generalMap.put("serviceNo", serviceNo);
			}
			if(mrequest.getParameter("age")!= null){
				age = mrequest.getParameter("age");
				generalMap.put("age", age);
			}
			if(mrequest.getParameter("gender")!= null){
				gender = mrequest.getParameter("gender");
				generalMap.put("gender", gender);
			}
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				generalMap.put("hospitalId", hospitalId);
			}
			if (session.getAttribute(LOGIN_NAME) != null) {
				userName = (String) session.getAttribute(LOGIN_NAME);
				generalMap.put("userName", userName);
			}
			
			StringTokenizer strToken=new StringTokenizer(filename,".");
			filename=strToken.nextToken();
		   	fileExtension=strToken.nextToken();
		   	
		   	String whiteList = "*."+fileExtension;
		   	filename = serviceNo+"."+fileExtension;
//		   	filename = serviceNo+"."+fileExtension;
		   	
		   	generalMap.put("filename", filename);
		   	try {
				fileUploadedList = HMSUtil.uploadTicketFile(mrequest,uploadURL, whiteList,filename);
			} catch (Exception e) {
				e.printStackTrace();
			}
		   	
			generalMap.put("uploadURL", uploadURL);
			boolean fileUploaded = false;
			if (fileUploadedList != null && fileUploadedList.size() != 0) {
				fileUploaded = (Boolean) fileUploadedList.get(0);
			}
			generalMap.put("extension", fileExtension);
		map = registrationHandlerService.updatePatientImage(generalMap);
		String jsp = AV_PHOTO_POPUP_JSP;
		map.put("filename", filename);
		map.put("serviceNo", serviceNo);
		map.put("contentJsp", jsp);
		
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView updatePatientImage(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetails = new HashMap<String, Object>();
 		String serviceNo="";
 		if(request.getParameter("serviceNo")!= null){
 			serviceNo = request.getParameter("serviceNo");
			mapDetails.put("serviceNo", serviceNo);
		}
 		String userHome = getServletContext().getRealPath("");
 		String fileSeparator = System.getProperty("file.separator");
 		String uploadURL = userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"HMS"+fileSeparator+"photo"+fileSeparator;
 		
 		//String uploadURL = userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"uploadedImage"+fileSeparator;
 		//String filePath = uploadURL+fileSeparator+hinNo+fileSeparator+hinNo+".jpg";
 		//String uploadURL = userHome+fileSeparator+"photo"+fileSeparator;
 		mapDetails.put("uploadURL", uploadURL);
 		mapDetails.put("extension", "jpg");
		map = aviationMedicineHandlerService.updatePatientImage(mapDetails);
		String jsp = "";
		jsp = "";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView viewUploadImage(HttpServletRequest request,
			HttpServletResponse response) {
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
       
        String serviceNo="";
        if(request.getParameter("serviceNo")!=null )
        {
        	serviceNo = request.getParameter("serviceNo");
        }
        int preFlightId=0;
        if(request.getParameter("preFlightId")!=null )
        {
        	preFlightId = Integer.parseInt(request.getParameter("preFlightId"));
        }int hospitalId=0;
        if (session.getAttribute(HOSPITAL_ID) != null) 
		{
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
	   dataMap.put("filename", filename);
	   dataMap.put("fileExtension", fileExtension);
	   dataMap.put("serviceNo", serviceNo);
	   dataMap.put("preFlightId", preFlightId);
	   dataMap.put("hospitalId", hospitalId);	
	   map =aviationMedicineHandlerService.getViewUploadImage(dataMap);
	  
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

			List<AvPreFlightDt> preFlDtList=(List<AvPreFlightDt>)map.get("preFlDtList");
			if(preFlDtList.size()>0)
			{
				AvPreFlightDt flightDt=preFlDtList.get(0);
						
				byte[] bytes =flightDt.getServiceImage();
			    response.getOutputStream().flush();
			    ServletOutputStream outs = response.getOutputStream();
			    outs.write(bytes);
			} 

		  } catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return null;
	
	}
	
	public ModelAndView getLectureDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Date from_date = null;
		Date to_date = null;
		int moName=0;
		if (request.getParameter("fromDate") != null && !(request.getParameter("fromDate").equals(""))) {
			from_date = HMSUtil.convertStringTypeDateToDateType(request.getParameter("fromDate"));
		}
		if (request.getParameter("toDate") != null && !(request.getParameter("toDate").equals(""))) {
			to_date = HMSUtil.convertStringTypeDateToDateType(request.getParameter("toDate"));
		}
		if (request.getParameter(MO_NAME) != null && !(request.getParameter(MO_NAME).equals(""))) {
			moName = Integer.parseInt(request.getParameter(MO_NAME));
		}
		dataMap.put("moName", moName);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("from_date", from_date);
		dataMap.put("to_date", to_date);
		map = aviationMedicineHandlerService.getLectureDate(dataMap);
		//jsp = "av_respLectureDate";
		jsp = "av_moWiseLectureReport.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView generateMOLectureDetailsRpt(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int parent=0;
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		parameters.put("hospitalId", hospitalId);
		if (request.getParameter("parent") != null
				&& !(request.getParameter("parent").equals(""))) {
			parent = Integer.parseInt(request.getParameter("parent"));
		}
		parameters.put("lectureId", parent);
		
		detailsMap = aviationMedicineHandlerService.getConnectionForReport();
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		HMSUtil.generateReport("av_medLectureStatsDetail", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	public void showViewAviationHelp(HttpServletRequest request,
			HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		String filename = null;
		String fileExtension = null;
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

	//	String uploadURL = getServletContext().getRealPath("/upload/");
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome
				+ fileSeparator
				+ "help"
				+ fileSeparator;
		try {
			
			response.setContentType("application/pdf");
			
			response.setHeader("Content-Disposition", "attachment;filename="
					+ java.net.URLEncoder.encode("Aviation Medicine.pdf")
					+ "");

			File f = new File(uploadURL + "/Aviation Medicine.pdf");
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
		}}
	
	public ModelAndView displayFileUploadInvestigation(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		int avExamId = 0;
		int invest_id = 0;
		int hinId = 0;
		String hinNo="";
		if(request.getParameter("hinId")!=null )
        {
			hinId = Integer.parseInt( request.getParameter("hinId"));
        }
		if(request.getParameter("hinNo")!=null )
        {
			hinNo = request.getParameter("hinNo");
        }
		if(request.getParameter("invest_id")!=null && !request.getParameter("invest_id").equals("") )
		{
			invest_id=Integer.parseInt(request.getParameter("invest_id"));
		}
		if(request.getParameter("avExamId")!= null )
		{
			avExamId = Integer.parseInt(request.getParameter("avExamId"));
		}
		String jsp = "av_fileuploadPopupMedicalBoardInvest";
		
		map.put("avExamId", avExamId);
		map.put("hinId", hinId);
		map.put("hinNo", hinNo);
		map.put("invest_id", invest_id);
	
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView submitInvestigationUploadDocuments(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MultipartFormDataRequest mrequest = null;
		HttpSession session = request.getSession();
		
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
		String fileExtension=null;
			
		String filename = "";
		int hospitalId=0;
		int hinId=0;
		int investigationId=0;
		int avExamId=0;
		if(request.getParameter("filename")!= null)
		{
				filename = request.getParameter("filename");
		}
		if (session.getAttribute(HOSPITAL_ID) != null) 
		{
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
		if(request.getParameter("hinId")!= null && !request.getParameter("hinId").equals(""))
		{
				hinId= Integer.parseInt(request.getParameter("hinId"));
				
		}if(request.getParameter("invest_id")!= null && !request.getParameter("invest_id").equals(""))
		{
			investigationId= Integer.parseInt(request.getParameter("invest_id"));
			
	     }
		String hinNo="";
		if(request.getParameter("hinNo")!= null && !request.getParameter("hinNo").equals(""))
		{
			hinNo=request.getParameter("hinNo");
			
	     }
		if(request.getParameter("avExamId")!= null && !request.getParameter("avExamId").equals(""))
		{
			avExamId= Integer.parseInt(request.getParameter("avExamId"));
			
	     }
			StringTokenizer strToken=new StringTokenizer(filename,".");
			filename=strToken.nextToken();
		   	fileExtension=strToken.nextToken();
		   	
			generalMap.put("filename", filename);
		   	generalMap.put("fileExtension", fileExtension);
		   	generalMap.put("hinId", hinId);
		   	generalMap.put("hospitalId", hospitalId);
		   	generalMap.put("investigationId", investigationId);
		   	generalMap.put("avExamId", avExamId);
		   	generalMap.put("mrequest", mrequest);
	     map = aviationMedicineHandlerService.submitUploadDocuments(generalMap);
		 boolean status=false;
		 status=(Boolean)map.get("status");
	     String message="";
		 if(status==true)
	     {	 
			 message="Document is uploaded successfully";
	     }else
	     {
	    	 message="Document is not uploaded successfully";
	     }
	     String jsp = "av_fileuploadPopupMedicalBoardInvest";
		// jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("hinNo", hinNo);
		map.put("hinId", hinId);
		map.put("invest_id", investigationId);
		map.put("avExamId", avExamId);
		
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView viewUploadDocumentsDetailsInvest(HttpServletRequest request,
			HttpServletResponse response)
	{		
		int hospitalId=0;
		int avExamId = 0;
		int hinId=0;
		String hin_no="";
		int InvestId=0;
		HttpSession session = request.getSession();

        Map<String,Object> dataMap=new HashMap<String,Object>();
        if(request.getParameter("hinNo")!=null )
        {
        	hin_no = (String) request.getParameter("hinNo");
        }
        if(request.getParameter("hinId")!=null )
        {
        	hinId = Integer.parseInt(request.getParameter("hinId"));
        }
        if(request.getParameter("InvestId")!=null )
        {
        	InvestId = Integer.parseInt(request.getParameter("InvestId"));
        }
        if(request.getParameter("avExamId")!=null )
        {
        	avExamId = Integer.parseInt(request.getParameter("avExamId"));
        }
        if (session.getAttribute(HOSPITAL_ID) != null) 
		{
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
        dataMap.put("hinId", hinId);
        dataMap.put("InvestId", InvestId);
        dataMap.put("avExamId", avExamId);
        dataMap.put("hospitalId", hospitalId);
        
        Map<String,Object> map=new HashMap<String,Object>();
          
        map=aviationMedicineHandlerService.viewUploadJsp(dataMap);
		String jsp = "av_medicalBoardInvestViewDocumentsPopUp";
		//jsp += ".jsp";
		map.put("hin_no", hin_no);	
		return new ModelAndView(jsp, "map", map);
		
	}
	public ModelAndView viewMedicalExamInvestDocuments(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		String filename = null;
		String fileExtension = null;
		String hin_no="";
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
        int invest_id=0;
        if(request.getParameter("invest_id")!=null )
        {
        	invest_id = Integer.parseInt(request.getParameter("invest_id"));
        }
        int hinId=0;
        if(request.getParameter("hinId")!=null )
        {
        	hinId = Integer.parseInt(request.getParameter("hinId"));
        }
        int avExamId=0;
        if(request.getParameter("avExamId")!=null )
        {
        	avExamId = Integer.parseInt(request.getParameter("avExamId"));
        }int hospitalId=0;
        if (session.getAttribute(HOSPITAL_ID) != null) 
		{
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
	   dataMap.put("filename", filename);
	   dataMap.put("fileExtension", fileExtension);
	   dataMap.put("invest_id", invest_id);
	   dataMap.put("hinId", hinId);
	   dataMap.put("avExamId", avExamId);
	   dataMap.put("hospitalId", hospitalId);	
	   map=aviationMedicineHandlerService.viewUploadInvestDocument(dataMap);
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

			List<AvMedicalUploadDocument> avUploadDocumentList=(List<AvMedicalUploadDocument>)map.get("avUploadDocumentList");
			if(avUploadDocumentList.size()>0)
			{
				AvMedicalUploadDocument avMedicalUploadDocument=avUploadDocumentList.get(0);
						
				byte[] bytes =avMedicalUploadDocument.getDocument();
			    response.getOutputStream().flush();
			    ServletOutputStream outs = response.getOutputStream();
			    outs.write(bytes);
			} 

		  } catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return null;
	}

//---Aviation Help	
	
public void showAviationHelp(HttpServletRequest request,HttpServletResponse response) {

		
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome
				+ fileSeparator
				+ "help"
				+ fileSeparator;
				
	
		
		try {
			
			response.setContentType("application/pdf");
			
			response.setHeader("Content-Disposition", "attachment;filename="
					+ java.net.URLEncoder.encode("Aviation Medicine.pdf")
					+ "");

			File f = new File(uploadURL + "/Aviation Medicine.pdf");
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

public ModelAndView showPilotRegistrationJsp(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	HttpSession session = request.getSession();
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	map = aviationMedicineHandlerService.showPilotRegistrationJsp(hospitalId);
	
	jsp = "av_pilotRegistration.jsp";

	title = "Aircrew Medical Lecture";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public void fillAVPilotRegServiceDetail(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	List<Patient> patientList = new ArrayList<Patient>();
	String serviceNo = "";
	int unitId=0;
	try {
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
		}
		if (request.getParameter(UNIT) != null) {
			unitId = Integer.parseInt(request.getParameter(UNIT));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	dataMap.put("unitId", unitId);
	dataMap.put("serviceNo", serviceNo);
	map = aviationMedicineHandlerService.fillAVPilotRegServiceDetail(dataMap);
	if (map.get("patientList") != null) {
		patientList = (List) map.get("patientList");
	}
	StringBuffer sb = new StringBuffer();
	try {
		sb.append("<items>");
		for (Patient patient : patientList) {
			sb.append("<item>");
			if (patient.getRank() != null) {
				sb.append("<rankId>" + patient.getRank().getId()+ "</rankId>");
			} else {
				sb.append("<rankId>-</rankId>");
			}
			String name="";
			name=patient.getPFirstName();
			if(patient.getPLastName() !=null ){
				name=name+" "+patient.getPLastName();
			}
			sb.append("<sName>" + name + "</sName>");
			int hinId=0;
			if(patient.getId() !=null && patient.getId() !=0){
				hinId=patient.getId();}
			sb.append("<hinId>" + hinId + "</hinId>");
			
			String age="";
			
			if(patient.getAge() !=null ){
				age=patient.getAge();
			}
			sb.append("<age>" + age + "</age>");
			
			
			if (patient.getCategory() != null) {
				sb.append("<medCatId>" + patient.getCategory().getCategoryid()+ "</medCatId>");
			} else {
				sb.append("<medCatId>-</medCatId>");
			}
			
			
			
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
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<chargeCodes>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</chargeCodes>");

	} catch (Exception e) {
		e.printStackTrace();
	}

}

public ModelAndView submitPilotRegistration(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String time = (String)utilMap.get("currentTimeWithoutSc");
	AvPilotRegistrationHd avPilotRegistrationHd = new AvPilotRegistrationHd();
	String message = "";
	String jsp = "";
	String url="";
	
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	MasHospital masHospital = new MasHospital();
	masHospital.setId(hospitalId);
	avPilotRegistrationHd.setHospital(masHospital);

	if (request.getParameter(UNIT) != null && !request.getParameter(UNIT).equals("0")) {
		int unitId = Integer.parseInt(request.getParameter(UNIT));
		MasUnit unit = new MasUnit();
		unit.setId(unitId);
		avPilotRegistrationHd.setUnit(unit);
		infoMap.put("unitId",unitId);
	}
	
	Date lastChgDate = null;
	if (request.getParameter(CHANGED_DATE) != null && !request.getParameter(CHANGED_DATE).equalsIgnoreCase("")){
		lastChgDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
		avPilotRegistrationHd.setLastChgDate(lastChgDate);
	}

	String lastChgTime = "";
	if (request.getParameter(CHANGED_TIME) != null && !request.getParameter(CHANGED_TIME).equalsIgnoreCase("")){
		lastChgTime = request.getParameter(CHANGED_TIME);
	//	aviAircrewMedicalLectures.setLastChgTime(lastChgTime);
		avPilotRegistrationHd.setLastChgTime(time);
	}


	
	int hdb = 0;
	if (request.getParameter("hdb") != null) {
		hdb = Integer.parseInt(request.getParameter("hdb"));
	}
	List<String> serviceNoList = new ArrayList<String>();
	List<Integer> rankList = new ArrayList<Integer>();
	List<Integer> hinList = new ArrayList<Integer>();
	List<String> nameList = new ArrayList<String>();
	List<String> ageList = new ArrayList<String>();
	List<Integer> categoryIdList = new ArrayList<Integer>();
	String dateOfLastME = "";
	int j = 1;
	for (int i = 0; i < hdb; i++) {
		String serviceNo = "";
			if(request.getParameter("serviceNo"+ j ) != null && !request.getParameter("serviceNo"+ j ).equals("")){
				serviceNo = request.getParameter("serviceNo"+ j );
				serviceNoList.add(serviceNo);
			}
		int rankId = 0;
		if(request.getParameter("rankId" + j) != null && !request.getParameter("rankId" + j).equals("")){
			rankId =Integer.parseInt(request.getParameter("rankId" + j));
			rankList.add(rankId);
		}else {
			rankList.add(0);
		}	
		int hinId = 0;
		if(request.getParameter("hinId" + j) != null && !request.getParameter("hinId" + j).equals("")){
			hinId = Integer.parseInt(request.getParameter("hinId" + j));
			hinList.add(hinId);
		}else {
			hinList.add(0);
		}
		if(request.getParameter("medCatId"+ j) != null &&(!request.getParameter("medCatId"+ j).equals("0"))){
			categoryIdList.add(Integer.parseInt(request.getParameter("medCatId"+ j)));
		}else{
			categoryIdList.add(0);
		}
		if(request.getParameter("age"+ j) != null && !request.getParameter("age"+ j).equals("")){
			ageList.add(request.getParameter("age"+ j));
		}else{
			ageList.add("");
		}

		if (request.getParameter("dateOfLastME" + j) != null
				&& !request.getParameter("dateOfLastME" + j).equals("")) {
			dateOfLastME = request.getParameter("dateOfLastME" + j);
		}
		String name = "";
		if(request.getParameter("sName" + j) != null && !request.getParameter("sName" + j).equals("")){
			name = request.getParameter("sName" +j);
			nameList.add(name);
		}	else {
			nameList.add("");
		}
		j++;
	}
	infoMap.put("nameList",nameList);
	infoMap.put("hinList",hinList);
	infoMap.put("rankList",rankList);
	infoMap.put("nameList",nameList);
	infoMap.put("serviceNoList",serviceNoList);
	infoMap.put("ageList",ageList);
	infoMap.put("categoryIdList",categoryIdList);
	infoMap.put("dateOfLastME",dateOfLastME);
	Boolean successfullyAdded = false;	
	successfullyAdded = aviationMedicineHandlerService.submitPilotRegistration(avPilotRegistrationHd,infoMap);
	
	if(successfullyAdded){
		message="Pilot Registration Information saved Successfully !!";
	}
	else{
		message="Try Again !!";
	}
	url="/hms/hms/aviationMedicine?method=showPilotRegistrationJsp";
	jsp = "av_messageForPilotRegistration";
	jsp += ".jsp";
	map.put("url",url);
	map.put("contentJsp", jsp);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAvPilotRegistrationRpt(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	map = aviationMedicineHandlerService.showPilotRegistrationJsp(hospitalId);
	String jsp = "";
	String title = "";
	
	jsp = "av_PilotRegistrationRpt.jsp";

	title = "Pilot Registration Report";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}
	public ModelAndView generatePilotRegistrationRpt(HttpServletRequest request, HttpServletResponse  response) throws JRException, IOException {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int unit_id  = 0;
		Box box = null;
		if(session.getAttribute("box")!=null){
			box = (Box)session.getAttribute("box");
		}else{
			box = HMSUtil.getBox(request);
		}
		if(box.getInt(UNIT)!=0){
			unit_id = box.getInt(UNIT);
		}
	
		detailsMap = aviationMedicineHandlerService.getConnectionForReport();
		parameters.put("unit_id", unit_id);
		HMSUtil.generateReport("av_pilot_registration", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null;
	}
	
	//---Added by dipali---
	
	public ModelAndView findPilotDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		String choice = "";
		int radio_str = 0;

		if (request.getParameter("unitNameId") != null) {
			radio_str = Integer.parseInt("" + request.getParameter("unitNameId"));
		}


			box.put("unitNameId", radio_str);
			map = (Map) aviationMedicineHandlerService.findPilotDetail(box);

		jsp = "av_pilotDetailUnitWise";
		return new ModelAndView(jsp, "map", map);
	}
	
	
	public ModelAndView responsePilotList(HttpServletRequest request,HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		
		int radio_str = 0;
		
		
		int pageNo = 1;
		if (request.getParameter("pilot_hd_id") != null) {
			radio_str = Integer.parseInt(request.getParameter("pilot_hd_id"));
		}
		
			map = (Map) aviationMedicineHandlerService.getAdjustmentList(radio_str,pageNo);
	

		jsp = "gridPilot";
		return new ModelAndView(jsp, "map", map);
	}

}