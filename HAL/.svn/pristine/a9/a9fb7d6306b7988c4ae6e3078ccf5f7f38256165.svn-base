package jkt.hms.medicalExam.controller;
import static jkt.hms.util.RequestConstants.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.lab.handler.LabHandlerService;
import jkt.hms.masters.business.Category;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.MasCommand;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasMedicalBoardExaminationDetail;
import jkt.hms.masters.business.MasMedicalExaminationDetail;
import jkt.hms.masters.business.MasMedicalExaminationReportOnEntry;
import jkt.hms.masters.business.MasMedicalUploadDocument;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MbTypeOfEntryMaster;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.OpdPatientHistory;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.medicalExam.handler.MedicalExamHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import jkt.hms.opd.handler.OPDHandlerService;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MedicalExamController extends MultiActionController{
	
	MedicalExamHandlerService medicalExamHandlerService = null;
	LabHandlerService labHandlerService = null;
	OPDHandlerService opdHandlerService = null;
	public MedicalExamHandlerService getMedicalExamHandlerService() {
		return medicalExamHandlerService;
	}

	public void setMedicalExamHandlerService(
			MedicalExamHandlerService medicalExamHandlerService) {
		this.medicalExamHandlerService = medicalExamHandlerService;
	}
	public ModelAndView showMedicalExamRegistrationJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = medicalExamHandlerService.showMedicalExamRegistrationJsp(hospitalId);
		String jsp = "";
		jsp = "medicalExamRegistration.jsp";		
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView showMedicalExamWaitingList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		//mapp = medicalExamHandlerService.showMedicalExamWaitingList(hospitalId);
		String jsp = "";
		System.out.println("call method");
		//jsp = "mb_medicalExamWaitingList.jsp";
		jsp = "mb_medicalExamWaitingList_new.jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView getListOfMedicalExam(HttpServletRequest request,HttpServletResponse response)
	
	{
		
		Map<String,Object> map = new HashMap<String,Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		List<Visit> meVisitList = new ArrayList<Visit>();
		Box box = HMSUtil.getBox(request);
		
		box.put("hospitalId", hospitalId);
		
		String ExamType="MedExam";
		box.put("ExamType", ExamType);
		
		
		map = medicalExamHandlerService.getListOfMedicalExam(box);	
		
		if(map.get("meVisitList")!= null)
		{
			meVisitList =(ArrayList) map.get("meVisitList");
		}
		List<String> labResultStausList = new ArrayList<String>();
		
		if(map.get("labResultStausList") != null)
		{
			labResultStausList=(List<String>)map.get("labResultStausList");
		}
		
		int totalRecords = 0;
		if(map.get("totalRecords")!= null)
		{
			totalRecords = (Integer) map.get("totalRecords");
		}
		
		try
		{
			PrintWriter pw = response.getWriter();	
			
			pw.write("[");
			int counter=1;
			int i=0;
			
			for(Visit list : meVisitList)
			{
				
				
			    if(counter != meVisitList.size())
			    {
			    	String servicepatientName="";
			    	if(list.getHin().getPFirstName()!= null){
			    		servicepatientName=list.getHin().getSFirstName();
			    	}
			    	
			    	if(list.getHin().getSMiddleName()!= null){
			    		servicepatientName=servicepatientName+" "+list.getHin().getSMiddleName();
			    	}
			    	if(list.getHin().getSLastName()!= null)
			    	{
			    		servicepatientName=servicepatientName+" "+list.getHin().getSLastName();
			    	}
			    	
			    	String labResultStatus=labResultStausList.get(i);
			    	String ma_status="";
					if(labResultStatus.equalsIgnoreCase("no"))
					{
						ma_status="New";
					}else if(labResultStatus.equalsIgnoreCase("pending"))
					{
						ma_status="Investigation Pending";
					}else if(labResultStatus.equalsIgnoreCase("validated"))
					{
						ma_status="Result Validated";
					}
					
			    	
			    		pw.write("{\"Id\": \""+list.getId()+"\",\"visitDate\": \""+(list.getVisitDate() !=null?HMSUtil.changeDateToddMMyyyy(list.getVisitDate()):"")+"\",\"visitTime\": \""+(list.getVisitTime()!=null?list.getVisitTime():"")+"\",\"serviceNo\": \""+(list.getHin() != null?list.getHin().getServiceNo():"")+"\",\"rank\": \""+(list.getHin().getRank() != null?list.getHin().getRank().getRankName():"")+"\",\"name\": \""+servicepatientName+"\",\"unit\": \""+(list.getHin().getUnit()!=null?list.getHin().getUnit().getUnitName():"-")+"\",\"examType\":\""+(list.getMedExamType()!=null?list.getMedExamType():"")+"\",\"contactNo\": \""+(list.getHin().getMobileNumber()!=null?list.getHin().getMobileNumber():"")+"\",\"ma_status\":\""+ma_status+"\",\"totalRecords\":\""+totalRecords+"\"},");
			    	
			    }
			    else
			    {		    	
			    	String servicepatientName="";
			    	if(list.getHin().getPFirstName()!= null){
			    		servicepatientName=list.getHin().getSFirstName();
			    	}
			    	
			    	if(list.getHin().getSMiddleName()!= null){
			    		servicepatientName=servicepatientName+" "+list.getHin().getSMiddleName();
			    	}
			    	if(list.getHin().getSLastName()!= null)
			    	{
			    		servicepatientName=servicepatientName+" "+list.getHin().getSLastName();
			    	}
			    	
			    	String labResultStatus=labResultStausList.get(i);
			    	String ma_status="";
					if(labResultStatus.equalsIgnoreCase("no"))
					{
						ma_status="New";
					}else if(labResultStatus.equalsIgnoreCase("pending"))
					{
						ma_status="Investigation Pending";
					}else if(labResultStatus.equalsIgnoreCase("validated"))
					{
						ma_status="Result Validated";
					}
			    	
					pw.write("{\"Id\": \""+list.getId()+"\",\"visitDate\": \""+(list.getVisitDate() !=null?HMSUtil.changeDateToddMMyyyy(list.getVisitDate()):"")+"\",\"visitTime\": \""+(list.getVisitTime()!=null?list.getVisitTime():"")+"\",\"serviceNo\": \""+(list.getHin() != null?list.getHin().getServiceNo():"")+"\",\"rank\": \""+(list.getHin().getRank() != null?list.getHin().getRank().getRankName():"")+"\",\"name\": \""+servicepatientName+"\",\"unit\": \""+(list.getHin().getUnit()!=null?list.getHin().getUnit().getUnitName():"-")+"\",\"examType\":\""+(list.getMedExamType()!=null?list.getMedExamType():"")+"\",\"contactNo\": \""+(list.getHin().getMobileNumber()!=null?list.getHin().getMobileNumber():"")+"\",\"ma_status\":\""+ma_status+"\",\"totalRecords\":\""+totalRecords+"\"}");
			    	
			    	
			    }
			
			    counter++;	
			    i++;
			}
			
			
			pw.write("]");
			
			
		}
		
		catch(Exception e)
		{
			meVisitList.clear();
			labResultStausList.clear();
			e.printStackTrace();
		}	
		meVisitList.clear();
		labResultStausList.clear();
		return null;		
		

	}
	
	public ModelAndView showPrimaryExtMedExamJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		  int visitId=0;
		  if (request.getParameter("visitId") != null) {
		  			visitId = Integer.parseInt(request.getParameter("visitId"));
		  		}
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
	//	box.put("hospitalId", hospitalId);
		map = medicalExamHandlerService.showPrimaryExtMedExamJsp(box);
		List<MasMedicalExaminationReportOnEntry> existingMedExamList = new ArrayList<MasMedicalExaminationReportOnEntry>();
		existingMedExamList = medicalExamHandlerService.getExistingMedExamList(box);
		if(existingMedExamList.size() > 0){
			map.put("existingMedExamList", existingMedExamList);
		}
		String jsp = "";
		jsp = "mb_primaryExtMedExam.jsp";
		map.put("visitId", visitId);
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView showAnnualMedExamJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		HttpSession session = request.getSession();
		
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map map = new HashMap();
        int visitId=0;
		String jspheading=null;
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
		  hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
        if (request.getParameter("visitId") != null && !request.getParameter("visitId").equals("")) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		if (request.getParameter("medExamType") != null) {
			jspheading = request.getParameter("medExamType");
		}
		int medExamId=0;
		if (request.getParameter("medExamId") != null && !request.getParameter("medExamId").equals("")) {
		        	medExamId = Integer.parseInt(request.getParameter("medExamId"));
				}

        int deptId=0;
		if(session.getAttribute("deptId")!=null)
		{	
          deptId = (Integer) session.getAttribute("deptId");
		}
        mapForDS.put("visitId", visitId);
		mapForDS.put("deptId", deptId);
		mapForDS.put("medExamId", medExamId);
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("medExamType", jspheading);
		map = medicalExamHandlerService.showAnnualMedExamJsp(mapForDS);
		jsp = "mb_medicalBoardExaminationOnAnnual";
		jsp += ".jsp";
		map.put("jspheading", jspheading);
		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
	//--------------------------------------------------------
	public ModelAndView addMedicalExaminationBoardAnnual(HttpServletRequest req,HttpServletResponse res)
	{
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String serviceNo = "";
		String rank = "";
		String name = "";
		String unit = "";
		String serviceiaf = "";
		String branch = "";
		Date dob = null;
		String age = "";
		String typeOfCommunication = "";
		Date dateofcommun = null;
		String totalservice = "";
		String pastmedicalhistory = "";
		String presentmedicalhistory = "";
		String idealweight = "";
		String overweight = "";
		String waist = "";
		String chestfullexpansion = "";
		String bhi = "";
		String rangeofexpansion = "";
		String bodyfat = "";
		String signfoldthickness = "";
		String sportman = "";
		String actualweight="";
		String lastame = "";		
		Date entryDate = null;
		Date medicinExamDate = null;
		String lastChangedBy = "";
		String lastChangedTime = "";
		Date lastChangedDate = null;
		Date surgeyDate = null;
		int typeOfEntry = 0;
		String betchNo = "";
		String chestNo = "";
		String rollNo = "";
		int medicalExamHeld = 0;
		String medicalStatus = "";
		String fullName = "";
		Date dateOfBirth = null;
		int maritialStatus = 0;
		String service = "";
		String pNo = "";
	//	String rank = "";
		String hoursOfFlown = "";
		String permanentAddress = "";
		String identification1 = "";
		String identification2 = "";
		String armsCrops = "";
		Date dateOfReporting = null;
		Date dateOfCompletion = null;
		Date documentForwardDate = null;
		String documentForwardTo = "";
		String fromWhereHeReport = "";
		String hypertension = "";
		String heartDisease = "";
		String diabetes = "";
		String bleedingDisorder = "";
		String mentalDisease = "";
		String nightBlindness = "";
		String asthama = "";
		String dischargeFrom = "";
		String plesury = "";
		String earDieses = "";
		String rheumatism = "";
		String frequentCough = "";
		String chronicIndigestion = "";
		String nervousBrakdown = "";
		String kidenyBladder = "";
		String fitsFaintinngAttacks = "";
		String std = "";
		String serveHeadInjury = "";
		String joundice = "";
		String sickness = "";
		String breastDisease = "";
		String trachoma = "";
		String amenorrhoea = "";
		String nightbindness = "";
		String menirrhagia = "";
		String laserTeartement = "";
		String pregnancy = "";
		String abortion = "";
		String eyeDisease = "";
		String rejectedAsUnfit = "";
		String dischargeMedicallyUnfit = "";
		String adimmitedInHospitalFirIllness = "";
		String stateNature = "";
		String otherInform = "";
		BigDecimal height = new BigDecimal(0);
		BigDecimal weight = new BigDecimal(0);
		BigDecimal acceptableKg = new BigDecimal(0);
		BigDecimal leglength = new BigDecimal(0);
		String appereance = "";
		String albumin = "";
		String sugar = "";
		String spGraviry = "";
		String hbPercentage = "";
		String physique = "";
		String anyOtherInv = "";
		String skin = "";
		String abdomen = "";
		String heartSize = "";
		String sound = "";
		String rhythm = "";
		String arterialWalls = "";
		String pulseRates = "";
		String bp = "";
		String fullExpension = "";
		String rangeOfExpension = "";
		String selfBalR = "";
		String selfBalL = "";
		String speechMental = "";
		String endocrinCond = "";
		String otherAbnormalities = "";
		String medicinRemarks = "";
		String finger = "";
		String hand = "";
		String wrist = "";
		String elbows = "";
		String shoulderGridles = "";
		String cercival = "";
		String dorsalVertebrate = "";
		String hullux = "";
		String valgus = "";
		String riggus = "";
		String flatFeet = "";
		String joints = "";
		String pelvis = "";
		String gail = "";
		String lumberScaler = "";
		String roccyxVericose = "";
		String hydrocele = "";
		String varicocele = "";
		String underScende = "";
		String hemonhoids = "";
		String herinaMusic = "";
		String breasts = "";
		String surgeryRemarks = "";
		String respatorySystem = "";

		String withGlassesDistantR = "";
		String withglassesDistantL = "";
		String withGlassesNearR = "";
		String withGlassesNearL = "";
		String withGlassesNearCP = "";
		String withoutGlassesDistantR = "";
		String withoutGlassesDistantL = "";
		String withoutGlassesNearR = "";
		String withoutGlassesNearL = "";
		String withoutGlassesNearCP = "";
		BigDecimal convergenceCP = new BigDecimal(0);

		BigDecimal convergenceC = new BigDecimal(0);
		String accommodationR = "";
		String accommodationL = "";
		String eyeRemarks = "";
		Date eyeDate = null;
		BigDecimal hearingRFW = new BigDecimal(0);
		BigDecimal hearingLFW = new BigDecimal(0);
		BigDecimal hearingBothFW = new BigDecimal(0);
		BigDecimal hearingRCV = new BigDecimal(0);
		BigDecimal hearingLCV = new BigDecimal(0);
		BigDecimal hearingBothCV = new BigDecimal(0);
       
		String innerEarR = "";
		String innerEarL = "";
		String audiometryRecord = "";
		String nose = "";
		String throatEar = "";
		String earReamrks = "";
		Date earDate = null;
		String externalEarR = "";
		String externalEarL = "";
		String middleEarR = "";
		String middleEarL = "";
		String evidienceOfTrachoma = "";
		String binocular = "";
		String manifestHypermetropia = "";
		String coverTest = "";
		String diaphragmTest = "";
		String fundMedia = "";
		String fields = "";
		String nightVisualCapacity = "";

		String dentalRemarks = "";
		String denatlToMH="no";
		Date dentalDate = null;
		String menstrualHistory = "";
		int noOfPregnancy = 0;
		int noOfAbortion = 0;
		int noOfChildren = 0;
		Date lastCondinement = null;
		String vaginalDischarge = "";
		String prolapse = "";
		String usgAbortion = "";
		String gyanaecologyRemarks = "";
		Date gyanaecologyDate = null;
		String medicalBoardExamination = "";
		int medicalBoardExaminationPlace = 0;
		Date medicalBoardExaminationDate = new Date();
		String subsequentMedicalBoardExam = "";
		int subsequentMedicalBoardExamPlace = 0;
		Date subsequentMedicalBoardExamDate = null;
		String ApprovingAuthority = "";
		int ApprovingAuthorityPlace = 0;
		Date ApprovingAuthorityDate = null;
		Date lmp = null;
		String totalTeeth = "";
		String totalDefectiveTeeth = "";
		String missingTeeth = "";
		String DenstalPoint = "";
		String unserviceableTeeth = "";
		String CocatHicNevreData="";

		String dur8 = "";
		String dur7 = "";
		String dur6 = "";
		String dur5 = "";
		String dur4 = "";
		String dur3 = "";
		String dur2 = "";
		String dur1 = "";
		String dul8 = "";
		String dul7 = "";
		String dul6 = "";
		String dul5 = "";
		String dul4 = "";
		String dul3 = "";
		String dul2 = "";
		String dul1 = "";
		String dlr8 = "";
		String dlr7 = "";
		String dlr6 = "";
		String dlr5 = "";
		String dlr4 = "";
		String dlr3 = "";
		String dlr2 = "";
		String dlr1 = "";
		String dll8 = "";
		String dll7 = "";
		String dll6 = "";
		String dll5 = "";
		String dll4 = "";
		String dll3 = "";
		String dll2 = "";
		String dll1 = "";
		String mur8 = "";
		String mur7 = "";
		String mur6 = "";
		String mur5 = "";
		String mur4 = "";
		String mur3 = "";
		String mur2 = "";
		String mur1 = "";
		String mul8 = "";
		String mul7 = "";
		String mul6 = "";
		String mul5 = "";
		String mul4 = "";
		String mul3 = "";
		String mul2 = "";
		String mul1 = "";
		String mlr8 = "";
		String mlr7 = "";
		String mlr6 = "";
		String mlr5 = "";
		String mlr4 = "";
		String mlr3 = "";
		String mlr2 = "";
		String mlr1 = "";
		String mll8 = "";
		String mll7 = "";
		String mll6 = "";
		String mll5 = "";
		String mll4 = "";
		String mll3 = "";
		String mll2 = "";
		String mll1 = "";
		String uur8 = "";
		String uur7 = "";
		String uur6 = "";
		String uur5 = "";
		String uur4 = "";
		String uur3 = "";
		String uur2 = "";
		String uur1 = "";
		String uul8 = "";
		String uul7 = "";
		String uul6 = "";
		String uul5 = "";
		String uul4 = "";
		String uul3 = "";
		String uul2 = "";
		String uul1 = "";
		String ulr8 = "";
		String ulr7 = "";
		String ulr6 = "";
		String ulr5 = "";
		String ulr4 = "";
		String ulr3 = "";
		String ulr2 = "";
		String ulr1 = "";
		String ull8 = "";
		String ull7 = "";
		String ull6 = "";
		String ull5 = "";
		String ull4 = "";
		String ull3 = "";
		String ull2 = "";
		String ull1 = "";

		String sur8 = "";
		String sur7 = "";
		String sur6 = "";
		String sur5 = "";
		String sur4 = "";
		String sur3 = "";
		String sur2 = "";
		String sur1 = "";
		String sul8 = "";
		String sul7 = "";
		String sul6 = "";
		String sul5 = "";
		String sul4 = "";
		String sul3 = "";
		String sul2 = "";
		String sul1 = "";

		String slr8 = "";
		String slr7 = "";
		String slr6 = "";
		String slr5 = "";
		String slr4 = "";
		String slr3 = "";
		String slr2 = "";
		String slr1 = "";
		String sll8 = "";
		String sll7 = "";
		String sll6 = "";

		String sll5 = "";
		String sll4 = "";
		String sll3 = "";
		String sll2 = "";
		String sll1 = "";
		String allergies = "";
		// Added By Vinay
		
		Date dentalcheckupdate = null;
		String DentalOfficer ="";
		HttpSession session = req.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int userId = 0;
		Users user = (Users)session.getAttribute("users");
		userId = user.getId();
		
		int commandId = (Integer) session.getAttribute("commandId");

		Map<String, Object> map = new HashMap<String, Object>();
//		Box box = HMSUtil.getBox(req);
		MasMedicalExaminationReportOnEntry masMedicalBoardProceedings = new MasMedicalExaminationReportOnEntry();

		Map<String, Object> generalMap = new HashMap<String, Object>();
		List<MasMedicalBoardExaminationDetail> masMedicalBoardDetails = new ArrayList<MasMedicalBoardExaminationDetail>();

		// Added By Vinay
		
		if (req.getParameter("DentalOfficer") != null) {
			DentalOfficer= req.getParameter("DentalOfficer");
			
		}
		
		if (req.getParameter("dentalcheckupdate") != null
				&& !(req.getParameter("dentalcheckupdate").equals(""))) {
			dentalcheckupdate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter("dentalcheckupdate"));
		}
		
		if (req.getParameter("allergies") != null) {
			allergies= req.getParameter("allergies");
			
		}
		if (req.getParameter(SERVICE_NO) != null) {
			serviceNo = req.getParameter(SERVICE_NO);
		}
		if (req.getParameter(AGE) != null ) {
			age = req.getParameter(AGE);
		}
		if (req.getParameter(TOTAL_SERVICE) != null ) {
			totalservice = req.getParameter(TOTAL_SERVICE);
		}
		if (req.getParameter("serviceiaf") != null ) {
			serviceiaf = req.getParameter("serviceiaf");
		}
		
		if (req.getParameter("typeOfCommunication") != null ) {
			typeOfCommunication = req.getParameter("typeOfCommunication");
		}if (req.getParameter(DATE_COMMENCEMENT) != null &&  !req.getParameter(DATE_COMMENCEMENT).equals("")) 
		{
			dateofcommun =HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_COMMENCEMENT));
		}
		if (req.getParameter(PAST_MEDICAL_HISTORY) != null ) {
			pastmedicalhistory  = req.getParameter(PAST_MEDICAL_HISTORY);
		}if (req.getParameter(PRESENT_MEDICAL_CATEGORY) != null &&  !req.getParameter(PRESENT_MEDICAL_CATEGORY).equals("0")) 
		{
			Category categ2 = new Category();
			categ2.setCategoryid(Integer.parseInt(req.getParameter(PRESENT_MEDICAL_CATEGORY)));
			masMedicalBoardProceedings.setPresentMedicalCategory(categ2);
			mapForDS.put("presentMedicalCategoryId", Integer.parseInt(req.getParameter(PRESENT_MEDICAL_CATEGORY)));
		}if (req.getParameter(LAST_AME) != null ) {
			lastame = req.getParameter(LAST_AME);
		}//if (req.getParameter(HEIGHT_WITHOUT_SHOOSE) != null ) {
		//	weight = req.getParameter(HEIGHT_WITHOUT_SHOOSE);
		//}
		if (req.getParameter(ACTUAL_WEIGHT) != null ) {
			actualweight = req.getParameter(ACTUAL_WEIGHT);
		}if (req.getParameter(IDEAL_WEIGHT) != null ) {
			idealweight  = req.getParameter(IDEAL_WEIGHT);
		}if (req.getParameter(OVER_WEIGHT) != null ) {
			overweight  = req.getParameter(OVER_WEIGHT);
		}if (req.getParameter(WAIST) != null ) {
			waist = req.getParameter(WAIST);
		}if (req.getParameter(CHEST_FULL) != null ) {
			chestfullexpansion  = req.getParameter(CHEST_FULL);
		}if (req.getParameter(RANGE_EXPANSION) != null ) {
			rangeofexpansion  = req.getParameter(RANGE_EXPANSION);
		}if (req.getParameter(BHI) != null ) {
			bhi = req.getParameter(BHI);
		}
		if (req.getParameter(BODY_FAT) != null ) {
			bodyfat  = req.getParameter(BODY_FAT);
		}
		if (req.getParameter(THICKNESS) != null ) {
			signfoldthickness  = req.getParameter(THICKNESS);
		}
		if (req.getParameter(SPORTS) != null ) {
			sportman  = req.getParameter(SPORTS);
		}
		int deptId=0;
		int empId=0;
		int hinId=0;
		int visitId=0;
		if (req.getParameter("deptId") != null ) {
			deptId  = Integer.parseInt(req.getParameter("deptId"));
		}
		if (req.getParameter("empId") != null ) {
			empId  = Integer.parseInt(req.getParameter("empId"));
		}
		if (req.getParameter("hinId") != null ) {
			hinId  = Integer.parseInt(req.getParameter("hinId"));
		}
		if (req.getParameter("visitId") != null ) {
			visitId  = Integer.parseInt(req.getParameter("visitId"));
		}
		int departmentId = 0;
		if (req.getParameter(DEPARTMENT_ID) != null ) {
			departmentId  = Integer.parseInt(req.getParameter(DEPARTMENT_ID));
		}
		int medicalOfficer = 0;
		if (req.getParameter("medicalOfficer") != null ) {
			medicalOfficer  = Integer.parseInt(req.getParameter("medicalOfficer"));
		}
		List<String> chargeCodeIdList = new ArrayList<String>();
		List<Integer> quantityList = new ArrayList<Integer>();
		List<String> investigationReferToMHList=new ArrayList<String>();
		String clinicalNotes1="";
				if (req.getParameter("clinicalNotes1") != null
						&& !(req.getParameter("clinicalNotes1").equals(""))) {
					clinicalNotes1 = req.getParameter("clinicalNotes1");
				}
				
		       int hiddenValue = 1;
				if (Integer.parseInt(req.getParameter("hiddenValue")) != 1) 
				{
					hiddenValue = Integer.parseInt(req.getParameter("hiddenValue"));
				}
				String deleatedValue = "";
				if (req.getParameter("deleatedValue") != "")
				{
					deleatedValue = req.getParameter("deleatedValue");
					
				}
				mapForDS.put("deleatedValue",deleatedValue);
				int temp = 1;
				List<Integer> patientInvestigationdetailsIdList = new ArrayList<Integer>();
				List<Integer> dgOrderdtIdList = new ArrayList<Integer>();
				String[] chargeCodeIdArr = new String[hiddenValue];
				for (int i = 0; i < hiddenValue; i++) {
					if (req.getParameter("chargeCodeName" + temp) != null
							&& !req.getParameter("chargeCodeName" + temp)
									.equals("")) {

						String chargeCodeNameWithId = req
								.getParameter("chargeCodeName" + temp);
						int index1 = chargeCodeNameWithId.lastIndexOf("[");
						int index2 = chargeCodeNameWithId.lastIndexOf("]");
						index1++;
						String chargeCodeId = chargeCodeNameWithId.substring(index1,
								index2);
						if (!chargeCodeId.equals("")) {
							chargeCodeIdArr[i] = chargeCodeId;
							int qty = 1;
							if (req.getParameter("investigationReferToMH" + temp) != null )
							{
								investigationReferToMHList.add("y");
								
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
					if (req.getParameter("patientInvestigationdetailsId" + temp) != null
							&& !req.getParameter("patientInvestigationdetailsId" + temp)
									.equals("")) {
						patientInvestigationdetailsIdList.add(Integer.parseInt(req.getParameter("patientInvestigationdetailsId" + temp)));
						}
					if (req.getParameter("dgOrderdtId" + temp) != null
							&& !req.getParameter("dgOrderdtId" + temp)
									.equals("")) {
						dgOrderdtIdList.add(Integer.parseInt(req.getParameter("dgOrderdtId" + temp)));
					}
					temp++;
				}

//----------------------------------------------------------------------------------------------
			String alcohol="";
			if(req.getParameter("alcohol") != null && !req.getParameter("alcohol").equals("")){
				alcohol=req.getParameter("alcohol");
			}
		/*	if(req.getParameter("smokerLess10") != null && !req.getParameter("smokerLess10").equals("")){
				smokerLess10=req.getParameter("smokerLess10");
			}
			if(req.getParameter("smokerMore10") != null && !req.getParameter("smokerMore10").equals("")){
				smokerMore10=req.getParameter("smokerMore10");
			}*/
			mapForDS.put("alcohol",alcohol);
			mapForDS.put("smokerLess10",req.getParameter("smokerLess10"));
			mapForDS.put("smokerMore10",req.getParameter("smokerMore10"));
//-----------------------------------------------------------------------
String[] familyHistoryArray = null;
if (req.getParameterValues(FM_DM) != null
		&& !(req.getParameterValues(FM_DM).equals(""))) 
{
	familyHistoryArray =(String[])req.getParameterValues(FM_DM);
	mapForDS.put("familyHistoryArray", familyHistoryArray);
}
String otherFamilyHistory="";
if (req.getParameter("otherFamilyHistory") != null) {
	otherFamilyHistory=req.getParameter("otherFamilyHistory");
	mapForDS.put("otherFamilyHistory", otherFamilyHistory);
}

//-----------------------------------------------------------------------------------------------
		

		if (req.getParameter(ENTRY_OF_DATE) != null
				&& !(req.getParameter(ENTRY_OF_DATE).equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(ENTRY_OF_DATE));
		}
		if (req.getParameter(TYPE_OF_ENTRY) != null
				&& !(req.getParameter(TYPE_OF_ENTRY).equals(""))) {
			typeOfEntry = Integer.parseInt(req.getParameter(TYPE_OF_ENTRY));
		}
		if (req.getParameter(BATCH1_NO) != null
				&& !(req.getParameter(BATCH1_NO).equals(""))) {
			betchNo = req.getParameter(BATCH1_NO);
		}
		if (req.getParameter(CHEST_NO) != null
				&& !(req.getParameter(CHEST_NO).equals(""))) {
			chestNo = req.getParameter(CHEST_NO);
		}

		if (req.getParameter(ROLL_NO) != null
				&& !(req.getParameter(ROLL_NO).equals(""))) {
			rollNo = req.getParameter(ROLL_NO);
		}

		if (req.getParameter(MEDICAL_EXAM_HELD_AT) != null) {
			medicalExamHeld = Integer.parseInt(req
					.getParameter(MEDICAL_EXAM_HELD_AT));
		}

		if (req.getParameter(MEDICAL_STATUS) != null
				&& !(req.getParameter(MEDICAL_STATUS).equals(""))) {
			medicalStatus = req.getParameter(MEDICAL_STATUS);
		}
		if (req.getParameter(FULL_NAME) != null
				&& !(req.getParameter(FULL_NAME).equals(""))) {
			fullName = req.getParameter(FULL_NAME);
		}

		if (req.getParameter(DATE_OF_BIRTH) != null
				&& !(req.getParameter(DATE_OF_BIRTH).equals(""))) {
			dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_BIRTH));
		}

		if (req.getParameter(MARITIAL_STATUS) != null
				&& !(req.getParameter(MARITIAL_STATUS).equals(""))) {
			maritialStatus = Integer
					.parseInt(req.getParameter(MARITIAL_STATUS));
		}

		if (req.getParameter(SERVICE) != null
				&& !(req.getParameter(SERVICE).equals(""))) {
			service = req.getParameter(SERVICE);
		}

		if (req.getParameter(P_NO) != null
				&& !(req.getParameter(P_NO).equals(""))) {
			pNo = req.getParameter(P_NO);
		}

		if (req.getParameter(RANK) != null
				&& !(req.getParameter(RANK).equals(""))) {
			rank = req.getParameter(RANK);
		}

		if (req.getParameter(HOURS_OF_FLOWN) != null
				&& !(req.getParameter(HOURS_OF_FLOWN).equals(""))) {
			hoursOfFlown = req.getParameter(HOURS_OF_FLOWN);
		}
		if (req.getParameter(PERMANENT_ADDRESS) != null
				&& !(req.getParameter(PERMANENT_ADDRESS).equals(""))) {
			permanentAddress = req.getParameter(PERMANENT_ADDRESS);
		}

		if (req.getParameter(IDENTIFICATION_MARKS1) != null
				&& !(req.getParameter(IDENTIFICATION_MARKS1).equals(""))) {
			identification1 = req.getParameter(IDENTIFICATION_MARKS1);
		}

		if (req.getParameter(IDENTIFICATION_MARKS2) != null
				&& !(req.getParameter(IDENTIFICATION_MARKS2).equals(""))) {
			identification2 = req.getParameter(IDENTIFICATION_MARKS2);
		}

		if (req.getParameter(ARMS_CROPS) != null
				&& !(req.getParameter(ARMS_CROPS).equals(""))) {
			armsCrops = req.getParameter(ARMS_CROPS);
		}

		if (req.getParameter(DATE_OF_COMPLETION) != null
				&& !(req.getParameter(DATE_OF_COMPLETION).equals(""))) {
			dateOfCompletion = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_COMPLETION));
		}

		if (req.getParameter(DOCUMENT_FORWARD_DATE1) != null
				&& !(req.getParameter(DOCUMENT_FORWARD_DATE1).equals(""))) {
			documentForwardDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DOCUMENT_FORWARD_DATE1));

		}

		if (req.getParameter(DOCUMENT_FORWARD_TO) != null
				&& !(req.getParameter(DOCUMENT_FORWARD_TO).equals(""))) {
			documentForwardTo = req.getParameter(DOCUMENT_FORWARD_TO);
		}
		if (req.getParameter(DATE_OF_REPORTING) != null
				&& !(req.getParameter(DATE_OF_REPORTING).equals(""))) {
			dateOfReporting = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_REPORTING));

		}

		if (req.getParameter(FROM_WHERE_HE_REPORT) != null
				&& !(req.getParameter(FROM_WHERE_HE_REPORT).equals(""))) {
			fromWhereHeReport = req.getParameter(FROM_WHERE_HE_REPORT);
		}
		if (req.getParameter(HYPERTENSION) != null
				&& !(req.getParameter(HYPERTENSION).equals(""))) {
			hypertension = req.getParameter(HYPERTENSION);
		}
		if (req.getParameter(HEAR_DISEASE) != null
				&& !(req.getParameter(HEAR_DISEASE).equals(""))) {
			heartDisease = req.getParameter(HEAR_DISEASE);
		}
		if (req.getParameter(DIABETES) != null
				&& !(req.getParameter(DIABETES).equals(""))) {
			diabetes = req.getParameter(DIABETES);
		}
		if (req.getParameter(BLEEDING_DIORDER) != null
				&& !(req.getParameter(BLEEDING_DIORDER).equals(""))) {
			bleedingDisorder = req.getParameter(BLEEDING_DIORDER);
		}
		if (req.getParameter(MENTAL_DISEASE) != null
				&& !(req.getParameter(MENTAL_DISEASE).equals(""))) {
			mentalDisease = req.getParameter(MENTAL_DISEASE);
		}
		if (req.getParameter(NIGHT_BLINDNESS) != null
				&& !(req.getParameter(NIGHT_BLINDNESS).equals(""))) {
			nightBlindness = req.getParameter(NIGHT_BLINDNESS);
		}

		if (req.getParameter(ASTHAMA) != null
				&& !(req.getParameter(ASTHAMA).equals(""))) {
			asthama = req.getParameter(ASTHAMA);
		}

		if (req.getParameter(DISCHARGE_FROM) != null
				&& !(req.getParameter(DISCHARGE_FROM).equals(""))) {
			dischargeFrom = req.getParameter(DISCHARGE_FROM);

		}

		if (req.getParameter(PLEURISY) != null
				&& !(req.getParameter(PLEURISY).equals(""))) {
			plesury = req.getParameter(PLEURISY);
		}

		if (req.getParameter(EAR_DISEASE) != null
				&& !(req.getParameter(EAR_DISEASE).equals(""))) {
			earDieses = req.getParameter(EAR_DISEASE);
		}

		if (req.getParameter(RHEUMATISM) != null
				&& !(req.getParameter(RHEUMATISM).equals(""))) {
			rheumatism = req.getParameter(RHEUMATISM);
		}
		if (req.getParameter(FREQUENT_CAUGH) != null
				&& !(req.getParameter(FREQUENT_CAUGH).equals(""))) {
			frequentCough = req.getParameter(FREQUENT_CAUGH);
		}

		if (req.getParameter(CHRONIC_INDIGESTION) != null
				&& !(req.getParameter(CHRONIC_INDIGESTION).equals(""))) {
			chronicIndigestion = req.getParameter(CHRONIC_INDIGESTION);
		}
		if (req.getParameter(NERVOUS_BRAKDOWN) != null
				&& !(req.getParameter(NERVOUS_BRAKDOWN).equals(""))) {
			nervousBrakdown = req.getParameter(NERVOUS_BRAKDOWN);
		}

		if (req.getParameter(KIDENY_BLADDER) != null
				&& !(req.getParameter(KIDENY_BLADDER).equals(""))) {
			kidenyBladder = req.getParameter(KIDENY_BLADDER);
		}
		if (req.getParameter(FITS_FAINTING_ATTACKS) != null
				&& !(req.getParameter(FITS_FAINTING_ATTACKS).equals(""))) {
			fitsFaintinngAttacks = req.getParameter(FITS_FAINTING_ATTACKS);
		}
		if (req.getParameter(STD) != null
				&& !(req.getParameter(STD).equals(""))) {
			std = req.getParameter(STD);
		}

		if (req.getParameter(SEVERE_HEAD_INJURY) != null
				&& !(req.getParameter(SEVERE_HEAD_INJURY).equals(""))) {
			serveHeadInjury = req.getParameter(SEVERE_HEAD_INJURY);
		}

		if (req.getParameter(JOUNDICE) != null
				&& !(req.getParameter(JOUNDICE).equals(""))) {
			joundice = req.getParameter(JOUNDICE);
		}
		if (req.getParameter(SICKNESS) != null
				&& !(req.getParameter(SICKNESS).equals(""))) {
			sickness = req.getParameter(SICKNESS);
		}
		if (req.getParameter(BREAST_DISEASE) != null
				&& !(req.getParameter(BREAST_DISEASE).equals(""))) {
			breastDisease = req.getParameter(BREAST_DISEASE);
		}
		if (req.getParameter(TRACHOMA) != null
				&& !(req.getParameter(TRACHOMA).equals(""))) {
			trachoma = req.getParameter(TRACHOMA);
		}

		if (req.getParameter(AMENORRHOEA) != null
				&& !(req.getParameter(AMENORRHOEA).equals(""))) {
			amenorrhoea = req.getParameter(AMENORRHOEA);
		}
		if (req.getParameter(NIGHT_BINDNESS) != null
				&& !(req.getParameter(NIGHT_BINDNESS).equals(""))) {
			nightbindness = req.getParameter(NIGHT_BINDNESS);
		}
		if (req.getParameter(MENORRHAGIA) != null
				&& !(req.getParameter(MENORRHAGIA).equals(""))) {
			menirrhagia = req.getParameter(MENORRHAGIA);
		}
		if (req.getParameter(LASER_TREATEMENT) != null
				&& !(req.getParameter(LASER_TREATEMENT).equals(""))) {
			laserTeartement = req.getParameter(LASER_TREATEMENT);
		}
		if (req.getParameter(PREGNANCY) != null
				&& !(req.getParameter(PREGNANCY).equals(""))) {
			pregnancy = req.getParameter(PREGNANCY);
		}
		if (req.getParameter(EYE_DISEASE) != null
				&& !(req.getParameter(EYE_DISEASE).equals(""))) {
			eyeDisease = req.getParameter(EYE_DISEASE);
		}
		if (req.getParameter(REJECTED_AS_UNFIT) != null
				&& !(req.getParameter(REJECTED_AS_UNFIT).equals(""))) {
			rejectedAsUnfit = req.getParameter(REJECTED_AS_UNFIT);
		}
		if (req.getParameter(DISCHARGE_MEDICALLY_UNFIT) != null
				&& !(req.getParameter(DISCHARGE_MEDICALLY_UNFIT).equals(""))) {
			dischargeMedicallyUnfit = req
					.getParameter(DISCHARGE_MEDICALLY_UNFIT);
		}
		if (req.getParameter(ADIMMITED_IN_HOSPITAL_FOR_ILLNESS) != null
				&& !(req.getParameter(ADIMMITED_IN_HOSPITAL_FOR_ILLNESS)
						.equals(""))) {
			adimmitedInHospitalFirIllness = req
					.getParameter(ADIMMITED_IN_HOSPITAL_FOR_ILLNESS);
		}
		if (req.getParameter(ABORTION) != null
				&& !(req.getParameter(ABORTION).equals(""))) {
			abortion = req.getParameter(ABORTION);
		}

		if (req.getParameter(STATE_NATURE_OF_THE_DISEASE) != null
				&& !(req.getParameter(STATE_NATURE_OF_THE_DISEASE).equals(""))) {
			stateNature = req.getParameter(STATE_NATURE_OF_THE_DISEASE);
		}
		if (req.getParameter(OTHER_INFORMATION) != null
				&& !(req.getParameter(OTHER_INFORMATION).equals(""))) {
			otherInform = req.getParameter(OTHER_INFORMATION);
		}
		if (req.getParameter(HEIGHT_WITHOUT_SHOOSE) != null
				&& !(req.getParameter(HEIGHT_WITHOUT_SHOOSE).equals(""))) {
			height = (new BigDecimal(req.getParameter(HEIGHT_WITHOUT_SHOOSE)));
		}
		if (req.getParameter(ACTUAL_WEIGHT) != null
				&& !(req.getParameter(ACTUAL_WEIGHT).equals(""))) {
			weight = (new BigDecimal(req.getParameter(ACTUAL_WEIGHT)));
		}
		if (req.getParameter(ACCEPTABLE_KG) != null
				&& !(req.getParameter(ACCEPTABLE_KG).equals(""))) {
			acceptableKg = (new BigDecimal(req.getParameter(ACCEPTABLE_KG)));
		}
		if (req.getParameter(LEG_LENGTH) != null
				&& !(req.getParameter(LEG_LENGTH).equals(""))) {
			leglength = (new BigDecimal(req.getParameter(LEG_LENGTH)));
		}
		if (req.getParameter(APPEREANCE) != null
				&& !(req.getParameter(APPEREANCE).equals(""))) {
			appereance = req.getParameter(APPEREANCE);
		}
		if (req.getParameter(ALBUMIN) != null
				&& !(req.getParameter(ALBUMIN).equals(""))) {
			albumin = req.getParameter(ALBUMIN);
		}
		if (req.getParameter(SUGAR) != null
				&& !(req.getParameter(SUGAR).equals(""))) {
			sugar = req.getParameter(SUGAR);
		}
		if (req.getParameter(SP_GRAVITY) != null
				&& !(req.getParameter(SP_GRAVITY).equals(""))) {
			spGraviry = req.getParameter(SP_GRAVITY);
		}
		if (req.getParameter(HB_PERCENTAGE) != null
				&& !(req.getParameter(HB_PERCENTAGE).equals(""))) {
			hbPercentage = req.getParameter(HB_PERCENTAGE);
		}
		if (req.getParameter(PHYSIQUE) != null
				&& !(req.getParameter(PHYSIQUE).equals(""))) {
			physique = req.getParameter(PHYSIQUE);
		}

		if (req.getParameter(ANYOTHER_INV_CARRIED_OUT) != null
				&& !(req.getParameter(ANYOTHER_INV_CARRIED_OUT).equals(""))) {
			anyOtherInv = req.getParameter(ANYOTHER_INV_CARRIED_OUT);
		}
		if (req.getParameter(SKIN) != null
				&& !(req.getParameter(SKIN).equals(""))) {
			skin = req.getParameter(SKIN);
		}
		if (req.getParameter(ABDOMEN) != null
				&& !(req.getParameter(ABDOMEN).equals(""))) {
			abdomen = req.getParameter(ABDOMEN);
		}
		if (req.getParameter(HEART_SIZE) != null
				&& !(req.getParameter(HEART_SIZE).equals(""))) {
			heartSize = req.getParameter(HEART_SIZE);
		}
		if (req.getParameter(SOUND) != null
				&& !(req.getParameter(SOUND).equals(""))) {
			sound = req.getParameter(SOUND);
		}
		if (req.getParameter(RHYTHM) != null
				&& !(req.getParameter(RHYTHM).equals(""))) {
			rhythm = req.getParameter(RHYTHM);
		}
		if (req.getParameter(ARTERIAL_WALLS) != null
				&& !(req.getParameter(ARTERIAL_WALLS).equals(""))) {
			arterialWalls = req.getParameter(ARTERIAL_WALLS);
		}
		if (req.getParameter(PULSE_RATES) != null
				&& !(req.getParameter(PULSE_RATES).equals(""))) {
			pulseRates = req.getParameter(PULSE_RATES);
		}
		if (req.getParameter(BP1) != null
				&& !(req.getParameter(BP1).equals(""))) {
			bp = req.getParameter(BP1);
		}
		if (req.getParameter(FULL_EXPENSION) != null
				&& !(req.getParameter(FULL_EXPENSION).equals(""))) {
			fullExpension = req.getParameter(FULL_EXPENSION);
		}
		if (req.getParameter(RANGE_OF_EXPENSION) != null
				&& !(req.getParameter(RANGE_OF_EXPENSION).equals(""))) {
			rangeOfExpension = req.getParameter(RANGE_OF_EXPENSION);
		}

		if (req.getParameter(SELF_BALANCINF_R) != null
				&& !(req.getParameter(SELF_BALANCINF_R).equals(""))) {
			selfBalR = req.getParameter(SELF_BALANCINF_R);
		}
		if (req.getParameter(SELF_BALANCING_L) != null
				&& !(req.getParameter(SELF_BALANCING_L).equals(""))) {
			selfBalL = req.getParameter(SELF_BALANCING_L);
		}
		if (req.getParameter(SPEECH_MENTAL_CAPACITY) != null
				&& !(req.getParameter(SPEECH_MENTAL_CAPACITY).equals(""))) {
			speechMental = req.getParameter(SPEECH_MENTAL_CAPACITY);
		}
		if (req.getParameter(ENDOCRINE_CONDITION) != null
				&& !(req.getParameter(ENDOCRINE_CONDITION).equals(""))) {
			endocrinCond = req.getParameter(ENDOCRINE_CONDITION);
		}
		if (req.getParameter(OTHER_ABNORMALITIES) != null
				&& !(req.getParameter(OTHER_ABNORMALITIES).equals(""))) {
			otherAbnormalities = req.getParameter(OTHER_ABNORMALITIES);
		}
		if (req.getParameter(MEDICIN_REMARKS) != null
				&& !(req.getParameter(MEDICIN_REMARKS).equals(""))) {
			medicinRemarks = req.getParameter(MEDICIN_REMARKS);
		}
		if (req.getParameter(FINGER) != null
				&& !(req.getParameter(FINGER).equals(""))) {
			finger = req.getParameter(FINGER);
		}
		if (req.getParameter(HAND) != null
				&& !(req.getParameter(HAND).equals(""))) {
			hand = req.getParameter(HAND);
		}
		if (req.getParameter(WRIST) != null
				&& !(req.getParameter(WRIST).equals(""))) {
			wrist = req.getParameter(WRIST);
		}
		if (req.getParameter(ELBOWS) != null
				&& !(req.getParameter(ELBOWS).equals(""))) {
			elbows = req.getParameter(ELBOWS);
		}
		if (req.getParameter(SHOULDER_GIRDLES) != null
				&& !(req.getParameter(SHOULDER_GIRDLES).equals(""))) {
			shoulderGridles = req.getParameter(SHOULDER_GIRDLES);
		}
		if (req.getParameter(CERCIVAL) != null
				&& !(req.getParameter(CERCIVAL).equals(""))) {
			cercival = req.getParameter(CERCIVAL);
		}
		if (req.getParameter(DORSAL_VERTEBRATE) != null
				&& !(req.getParameter(DORSAL_VERTEBRATE).equals(""))) {
			dorsalVertebrate = req.getParameter(DORSAL_VERTEBRATE);
		}
		if (req.getParameter(HULLUX) != null
				&& !(req.getParameter(HULLUX).equals(""))) {
			hullux = req.getParameter(HULLUX);
		}
		if (req.getParameter(VALGUS) != null
				&& !(req.getParameter(VALGUS).equals(""))) {
			valgus = req.getParameter(VALGUS);
		}
		if (req.getParameter(RIGGUS) != null
				&& !(req.getParameter(RIGGUS).equals(""))) {
			riggus = req.getParameter(RIGGUS);
		}
		if (req.getParameter(FLAT_FEET) != null
				&& !(req.getParameter(FLAT_FEET).equals(""))) {
			flatFeet = req.getParameter(FLAT_FEET);
		}
		if (req.getParameter(JOINTS) != null
				&& !(req.getParameter(JOINTS).equals(""))) {
			joints = req.getParameter(JOINTS);
		}
		if (req.getParameter(PELVIS) != null
				&& !(req.getParameter(PELVIS).equals(""))) {
			pelvis = req.getParameter(PELVIS);
		}
		if (req.getParameter(GAIL) != null
				&& !(req.getParameter(GAIL).equals(""))) {
			gail = req.getParameter(GAIL);
		}
		if (req.getParameter(LUMBER_SCALER_VERTABRAC) != null
				&& !(req.getParameter(LUMBER_SCALER_VERTABRAC).equals(""))) {
			lumberScaler = req.getParameter(LUMBER_SCALER_VERTABRAC);
		}
		if (req.getParameter(ROCCYX_VARICOSE_VENIS) != null
				&& !(req.getParameter(ROCCYX_VARICOSE_VENIS).equals(""))) {
			roccyxVericose = req.getParameter(ROCCYX_VARICOSE_VENIS);
		}
		if (req.getParameter(HYDROCELE) != null
				&& !(req.getParameter(HYDROCELE).equals(""))) {
			hydrocele = req.getParameter(HYDROCELE);
			CocatHicNevreData+=req.getParameter(HYDROCELE)+",";
		}
		if (req.getParameter(VARICOCELE) != null
				&& !(req.getParameter(VARICOCELE).equals(""))) {
			varicocele = req.getParameter(VARICOCELE);
		}
		if (req.getParameter(UNDER_SCENDED_TESTES) != null
				&& !(req.getParameter(UNDER_SCENDED_TESTES).equals(""))) {
			underScende = req.getParameter(UNDER_SCENDED_TESTES);
		}
		if (req.getParameter(HEMONHOIDS) != null
				&& !(req.getParameter(HEMONHOIDS).equals(""))) {
			hemonhoids = req.getParameter(HEMONHOIDS);
			CocatHicNevreData+=req.getParameter(HEMONHOIDS)+",";
		}
		if (req.getParameter(HERNIA_MUSCLE) != null
				&& !(req.getParameter(HERNIA_MUSCLE).equals(""))) {
			herinaMusic = req.getParameter(HERNIA_MUSCLE);
			
			
		}
		if (req.getParameter(BREASTS) != null
				&& !(req.getParameter(BREASTS).equals(""))) {
			breasts = req.getParameter(BREASTS);
			CocatHicNevreData+=req.getParameter(BREASTS)+",";
		}
		if (req.getParameter(SURGERY_REMARKS) != null
				&& !(req.getParameter(SURGERY_REMARKS).equals(""))) {
			surgeryRemarks = req.getParameter(SURGERY_REMARKS);
		}
		if (req.getParameter(RESPIRATORY_SYSTEM) != null
				&& !(req.getParameter(RESPIRATORY_SYSTEM).equals(""))) {
			respatorySystem = req.getParameter(RESPIRATORY_SYSTEM);
		}

		if (req.getParameter(WITH_GLASSES_DISTANT_R) != null
				&& !(req.getParameter(WITH_GLASSES_DISTANT_R).equals(""))) {
			withGlassesDistantR = req.getParameter(WITH_GLASSES_DISTANT_R);
		}
		if (req.getParameter(WITH_GLASSES_DISTANT_L) != null
				&& !(req.getParameter(WITH_GLASSES_DISTANT_L).equals(""))) {
			withglassesDistantL = req.getParameter(WITH_GLASSES_DISTANT_L);
		}
		if (req.getParameter(WITH_GLASSES_NEAR_R) != null
				&& !(req.getParameter(WITH_GLASSES_NEAR_R).equals(""))) {
			withGlassesNearR = req.getParameter(WITH_GLASSES_NEAR_R);
		}
		if (req.getParameter(WITH_GLASSES_NEAR_L) != null
				&& !(req.getParameter(WITH_GLASSES_NEAR_L).equals(""))) {
			withGlassesNearL = req.getParameter(WITH_GLASSES_NEAR_L);
		}
		if (req.getParameter(WITH_GLASSES_NEAR_CP) != null
				&& !(req.getParameter(WITH_GLASSES_NEAR_CP).equals(""))) {
			withGlassesNearCP = req.getParameter(WITH_GLASSES_NEAR_CP);

		}
		if (req.getParameter(WITHOUT_GLASSES_DISTANT_R) != null
				&& !(req.getParameter(WITHOUT_GLASSES_DISTANT_R).equals(""))) {
			withoutGlassesDistantR = req
					.getParameter(WITHOUT_GLASSES_DISTANT_R);
		}
		if (req.getParameter(WITHOUT_GLASSES_DISTANT_L) != null
				&& !(req.getParameter(WITHOUT_GLASSES_DISTANT_L).equals(""))) {
			withoutGlassesDistantL = req
					.getParameter(WITHOUT_GLASSES_DISTANT_L);
		}
		if (req.getParameter(WITHOUT_GLASSES_NEAR_R) != null
				&& !(req.getParameter(WITHOUT_GLASSES_NEAR_R).equals(""))) {
			withoutGlassesNearR = req.getParameter(WITHOUT_GLASSES_NEAR_R);
		}
		if (req.getParameter(WITHOUT_GLASSES_NEAR_L) != null
				&& !(req.getParameter(WITHOUT_GLASSES_NEAR_L).equals(""))) {
			withoutGlassesNearL = req.getParameter(WITHOUT_GLASSES_NEAR_L);
		}
		if (req.getParameter(WITHOUT_GLASSES_NEAR_CP) != null
				&& !(req.getParameter(WITHOUT_GLASSES_NEAR_CP).equals(""))) {
			withoutGlassesNearCP = req.getParameter(WITHOUT_GLASSES_NEAR_CP);
		}
		if (req.getParameter(CONVERGENCE_SC) != null
				&& !(req.getParameter(CONVERGENCE_SC).equals(""))) {
			convergenceCP = new BigDecimal(req.getParameter(CONVERGENCE_SC));
		}
		if (req.getParameter(CONVERGENCE_C) != null
				&& !(req.getParameter(CONVERGENCE_C).equals(""))) {
			convergenceC = new BigDecimal(req.getParameter(CONVERGENCE_C));

		}
		if (req.getParameter(ACCOMMODATION_R) != null
				&& !(req.getParameter(ACCOMMODATION_R).equals(""))) {
			accommodationR = req.getParameter(ACCOMMODATION_R);
		}
		if (req.getParameter(ACCOMMODATION_L) != null
				&& !(req.getParameter(ACCOMMODATION_L).equals(""))) {
			accommodationL = req.getParameter(ACCOMMODATION_L);
		}

		if (req.getParameter(EYE_REMARKS) != null
				&& !(req.getParameter(EYE_REMARKS).equals(""))) {
			eyeRemarks = req.getParameter(EYE_REMARKS);
		}
		if (req.getParameter(EYE_DATE) != null
				&& !(req.getParameter(EYE_DATE).equals(""))) {
			eyeDate = HMSUtil.dateFormatterDDMMYYYY(req.getParameter(EYE_DATE));
		}
		if (req.getParameter(HEARING_R_F_W) != null
				&& !(req.getParameter(HEARING_R_F_W).equals(""))) {
			hearingRFW = new BigDecimal(req.getParameter(HEARING_R_F_W));
		}
		if (req.getParameter(HEARING_L_F_W) != null
				&& !(req.getParameter(HEARING_L_F_W).equals(""))) {
			hearingLFW = new BigDecimal(req.getParameter(HEARING_L_F_W));
		}
		if (req.getParameter(HEARING_BOTH_FW) != null
				&& !(req.getParameter(HEARING_BOTH_FW).equals(""))) {
			hearingBothFW = new BigDecimal(req.getParameter(HEARING_BOTH_FW));
		}

		if (req.getParameter(HEARING_R_C_V) != null
				&& !(req.getParameter(HEARING_R_C_V).equals(""))) {
			hearingRCV = new BigDecimal(req.getParameter(HEARING_R_C_V));
		}
		if (req.getParameter(HEARING_L_C_V) != null
				&& !(req.getParameter(HEARING_L_C_V).equals(""))) {
			hearingLCV = new BigDecimal(req.getParameter(HEARING_L_C_V));
		}
		if (req.getParameter(HEARING_BOTH_CV) != null
				&& !(req.getParameter(HEARING_BOTH_CV).equals(""))) {
			hearingBothCV = new BigDecimal(req.getParameter(HEARING_BOTH_CV));
		}
		if (req.getParameter(INNER_EAR_R) != null
				&& !(req.getParameter(INNER_EAR_R).equals(""))) {
			innerEarR = req.getParameter(INNER_EAR_R);
		}
		if (req.getParameter(INNER_EAR_L) != null
				&& !(req.getParameter(INNER_EAR_L).equals(""))) {
			innerEarL = req.getParameter(INNER_EAR_L);
		}

		if (req.getParameter(AUDIOMETRY_RECORD) != null
				&& !(req.getParameter(AUDIOMETRY_RECORD).equals(""))) {
			audiometryRecord = req.getParameter(AUDIOMETRY_RECORD);
		}
		if (req.getParameter(NOSE) != null
				&& !(req.getParameter(NOSE).equals(""))) {
			nose = req.getParameter(NOSE);
		}
		if (req.getParameter(THROAT_EAR) != null
				&& !(req.getParameter(THROAT_EAR).equals(""))) {
			throatEar = req.getParameter(THROAT_EAR);
		}
		if (req.getParameter(EAR_REMARKS) != null
				&& !(req.getParameter(EAR_REMARKS).equals(""))) {
			earReamrks = req.getParameter(EAR_REMARKS);
		}
		if (req.getParameter(EAR_DATE) != null
				&& !(req.getParameter(EAR_DATE).equals(""))) {
			earDate = HMSUtil.dateFormatterDDMMYYYY(req.getParameter(EAR_DATE));
		}

		if (req.getParameter(EXTERNAL_EAR_R) != null
				&& !(req.getParameter(EXTERNAL_EAR_R).equals(""))) {
			externalEarR = req.getParameter(EXTERNAL_EAR_R);
		}
		if (req.getParameter(EXTERNAL_EAR_L) != null
				&& !(req.getParameter(EXTERNAL_EAR_L).equals(""))) {
			externalEarL = req.getParameter(EXTERNAL_EAR_L);
		}
		if (req.getParameter(MIDDLE_EAR_R) != null
				&& !(req.getParameter(MIDDLE_EAR_R).equals(""))) {
			middleEarR = req.getParameter(MIDDLE_EAR_R);
		}
		if (req.getParameter(MIDDLE_EAR_L) != null
				&& !(req.getParameter(MIDDLE_EAR_L).equals(""))) {
			middleEarL = req.getParameter(MIDDLE_EAR_L);
		}
		if (req.getParameter(ANY_EVIDENCE_OF_TRACHOMA) != null
				&& !(req.getParameter(ANY_EVIDENCE_OF_TRACHOMA).equals(""))) {
			evidienceOfTrachoma = req.getParameter(ANY_EVIDENCE_OF_TRACHOMA);
		}
		if (req.getParameter(BINOCULAR_VISION_GRADE) != null
				&& !(req.getParameter(BINOCULAR_VISION_GRADE).equals(""))) {
			binocular = req.getParameter(BINOCULAR_VISION_GRADE);
		}
		if (req.getParameter(MANIFEST_HYPERMETROPIA) != null
				&& !(req.getParameter(MANIFEST_HYPERMETROPIA).equals(""))) {
			manifestHypermetropia = req.getParameter(MANIFEST_HYPERMETROPIA);
		}
		if (req.getParameter(COVER_TEST) != null
				&& !(req.getParameter(COVER_TEST).equals(""))) {
			coverTest = req.getParameter(COVER_TEST);
		}
		if (req.getParameter(DIAPHRAGM_TEST) != null
				&& !(req.getParameter(DIAPHRAGM_TEST).equals(""))) {
			diaphragmTest = req.getParameter(DIAPHRAGM_TEST);
		}
		if (req.getParameter(FUND_MEDIA) != null
				&& !(req.getParameter(FUND_MEDIA).equals(""))) {
			fundMedia = req.getParameter(FUND_MEDIA);
		}
		if (req.getParameter(FIELDS) != null
				&& !(req.getParameter(FIELDS).equals(""))) {
			fields = req.getParameter(FIELDS);
		}
		if (req.getParameter(NIGHT_VISUAL_CAPACITY) != null
				&& !(req.getParameter(NIGHT_VISUAL_CAPACITY).equals(""))) {
			nightVisualCapacity = req.getParameter(NIGHT_VISUAL_CAPACITY);
		}
		if (req.getParameter(DENTAL_REMARKS) != null
				&& !(req.getParameter(DENTAL_REMARKS).equals(""))) {
			dentalRemarks = req.getParameter(DENTAL_REMARKS);
		}
		if (req.getParameter("dentalReferToMH") != null
				&& !(req.getParameter("dentalReferToMH").equals(""))) {
			denatlToMH = req.getParameter("dentalReferToMH");
		}
		if (req.getParameter(DENTAL_DATE) != null
				&& !(req.getParameter(DENTAL_DATE).equals(""))) {
			dentalDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DENTAL_DATE));
		}
		if (req.getParameter(MENSTRUAL_HISTORY) != null
				&& !(req.getParameter(MENSTRUAL_HISTORY).equals(""))) {
			menstrualHistory = req.getParameter(MENSTRUAL_HISTORY);
		}
		if (req.getParameter(NO_OF_PREGNANCY) != null
				&& !(req.getParameter(NO_OF_PREGNANCY).equals(""))) {
			noOfPregnancy = Integer.parseInt(req.getParameter(NO_OF_PREGNANCY));
		}
		if (req.getParameter(NO_OF_ABORTION) != null
				&& !(req.getParameter(NO_OF_ABORTION).equals(""))) {
			noOfAbortion = Integer.parseInt(req.getParameter(NO_OF_ABORTION));
		}
		if (req.getParameter(NO_OF_CHILDREN) != null
				&& !(req.getParameter(NO_OF_CHILDREN).equals(""))) {
			noOfChildren = Integer.parseInt(req.getParameter(NO_OF_CHILDREN));
		}
		if (req.getParameter(DATE_OF_LASTCONFINEMENT) != null
				&& !(req.getParameter(DATE_OF_LASTCONFINEMENT).equals(""))) {
			lastCondinement = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_LASTCONFINEMENT));
		}
		if (req.getParameter(VAGINAL_DISCHARGE) != null
				&& !(req.getParameter(VAGINAL_DISCHARGE).equals(""))) {
			vaginalDischarge = req.getParameter(VAGINAL_DISCHARGE);
		}
		if (req.getParameter(PROLAPSE) != null
				&& !(req.getParameter(PROLAPSE).equals(""))) {
			prolapse = req.getParameter(PROLAPSE);
		}
		if (req.getParameter(USG_ABORTION) != null
				&& !(req.getParameter(USG_ABORTION).equals(""))) {
			usgAbortion = req.getParameter(USG_ABORTION);
		}
		if (req.getParameter(GYANAECOLOGY_RAMARKS) != null
				&& !(req.getParameter(GYANAECOLOGY_RAMARKS).equals(""))) {
			gyanaecologyRemarks = req.getParameter(GYANAECOLOGY_RAMARKS);
		}
		if (req.getParameter(GYANAECOLOGY_DATE) != null
				&& !(req.getParameter(GYANAECOLOGY_DATE).equals(""))) {
			gyanaecologyDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(GYANAECOLOGY_DATE));
		}
		if (req.getParameter(GYANAECOLOGY_RAMARKS) != null
				&& !(req.getParameter(GYANAECOLOGY_RAMARKS).equals(""))) {
			gyanaecologyRemarks = req.getParameter(GYANAECOLOGY_RAMARKS);
		}
		if (req.getParameter(MEDICAL_BOARD_EXAMINATION) != null
				&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION).equals(""))) {
			medicalBoardExamination = req
					.getParameter(MEDICAL_BOARD_EXAMINATION);
		}
		if (req.getParameter(MEDICAL_BOARD_EXAMINATION_PLACE) != null
				&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION_PLACE)
						.equals(""))) {

			medicalBoardExaminationPlace = Integer.parseInt(req
					.getParameter(MEDICAL_BOARD_EXAMINATION_PLACE));

		}
		if (req.getParameter(MEDICAL_BOARD_EXAMINATION_DATE) != null
				&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION_DATE)
						.equals(""))) {
			medicalBoardExaminationDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(MEDICAL_BOARD_EXAMINATION_DATE)));
		}
		if (req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION) != null
				&& !(req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION)
						.equals(""))) {
			subsequentMedicalBoardExam = req
					.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION);
		}
		if (req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE) != null
				&& !(req
						.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE)
						.equals(""))) {
			subsequentMedicalBoardExamPlace = Integer.parseInt(req
					.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE));
		}
		if (req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE) != null
				&& !(req
						.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE)
						.equals(""))) {
			subsequentMedicalBoardExamDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE)));
		}

		if (req.getParameter(APPROVING_AUTHORITY) != null
				&& !(req.getParameter(APPROVING_AUTHORITY).equals(""))) {
			ApprovingAuthority = req.getParameter(APPROVING_AUTHORITY);
		}
		if (req.getParameter(APPROVING_AUTHORITY_PLACE) != null
				&& !(req.getParameter(APPROVING_AUTHORITY_PLACE).equals(""))) {
			ApprovingAuthorityPlace = Integer.parseInt(req
					.getParameter(APPROVING_AUTHORITY_PLACE));
		}
		if (req.getParameter(APPROVING_AUTHORITY_DATE) != null
				&& !(req.getParameter(APPROVING_AUTHORITY_DATE).equals(""))) {
			ApprovingAuthorityDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(APPROVING_AUTHORITY_DATE)));
		}
		if (req.getParameter(LMP) != null
				&& !(req.getParameter(LMP).equals(""))) {
			lmp = HMSUtil.dateFormatterDDMMYYYY((req.getParameter(LMP)));
		}

		if (req.getParameter(SURGERY_DATE) != null
				&& !(req.getParameter(SURGERY_DATE).equals(""))) {
			surgeyDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(SURGERY_DATE)));
		}

		if (req.getParameter(MEDICIN_EXAM_DATE) != null
				&& !(req.getParameter(MEDICIN_EXAM_DATE).equals(""))) {
			medicinExamDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(MEDICIN_EXAM_DATE)));

		}
		if (req.getParameter(TOTAL_NO_OF_TEETH) != null
				&& !(req.getParameter(TOTAL_NO_OF_TEETH).equals(""))) {
			totalTeeth = req.getParameter(TOTAL_NO_OF_TEETH);

		}
		if (req.getParameter(DEFECTIVE_TEETH) != null
				&& !(req.getParameter(DEFECTIVE_TEETH).equals(""))) {
			totalDefectiveTeeth = req.getParameter(DEFECTIVE_TEETH);

		}
		if (req.getParameter(MISSING_TEETH) != null
				&& !(req.getParameter(MISSING_TEETH).equals(""))) {
			missingTeeth = req.getParameter(MISSING_TEETH);

		}
		if (req.getParameter(MISSING_UNSERVICABLE_TEETH) != null
				&& !(req.getParameter(MISSING_UNSERVICABLE_TEETH).equals(""))) {
			unserviceableTeeth = req.getParameter(MISSING_UNSERVICABLE_TEETH);

		}
		if (req.getParameter(DENTSL_POINT) != null
				&& !(req.getParameter(DENTSL_POINT).equals(""))) {
			DenstalPoint = req.getParameter(DENTSL_POINT);

		}

		if (req.getParameter(LAST_CHANGED_BY) != null) {
			lastChangedBy = req.getParameter(LAST_CHANGED_BY);
		}
		if (req.getParameter(LAST_CHANGED_DATE) != null) {
			lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(LAST_CHANGED_DATE));
		}
		if (req.getParameter(LAST_CHANGED_TIME) != null) {
			lastChangedTime = req.getParameter(LAST_CHANGED_TIME);
		}
		// //////////////////////////////////

		if (req.getParameter(DUR_8) != null) {
			dur8 = (req.getParameter(DUR_8));

		} else {
			dur8 = "N";

		}

		if (req.getParameter(DUR_7) != null) {
			dur7 = (req.getParameter(DUR_7));

		} else {
			dur7 = "N";

		}
		if (req.getParameter(DUR_6) != null) {
			dur6 = (req.getParameter(DUR_6));

		} else {
			dur6 = "N";

		}
		if (req.getParameter(DUR_5) != null) {
			dur5 = (req.getParameter(DUR_5));

		} else {
			dur5 = "N";

		}

		if (req.getParameter(DUR_4) != null) {
			dur4 = (req.getParameter(DUR_4));
		} else {
			dur4 = "N";

		}
		if (req.getParameter(DUR_3) != null) {
			dur3 = (req.getParameter(DUR_3));

		} else {
			dur3 = "N";

		}
		if (req.getParameter(DUR_2) != null) {
			dur2 = (req.getParameter(DUR_2));

		} else {
			dur2 = "N";

		}
		if (req.getParameter(DUR_1) != null) {
			dur1 = (req.getParameter(DUR_1));

		} else {
			dur1 = "N";

		}

		if (req.getParameter(DUL_8) != null) {
			dul8 = (req.getParameter(DUL_8));
		} else {
			dul8 = "N";

		}
		if (req.getParameter(DUL_7) != null) {
			dul7 = (req.getParameter(DUL_7));

		} else {
			dul7 = "N";

		}
		if (req.getParameter(DUL_6) != null) {
			dul6 = (req.getParameter(DUL_6));
		} else {
			dul6 = "N";

		}
		if (req.getParameter(DUL_5) != null) {
			dul5 = (req.getParameter(DUL_5));
		} else {
			dul5 = "N";

		}
		if (req.getParameter(DUL_4) != null) {
			dul4 = (req.getParameter(DUL_4));
		} else {
			dul4 = "N";

		}
		if (req.getParameter(DUL_3) != null) {
			dul3 = (req.getParameter(DUL_3));
		} else {
			dul3 = "N";

		}
		if (req.getParameter(DUL_2) != null) {
			dul2 = (req.getParameter(DUL_2));
		} else {
			dul2 = "N";

		}
		if (req.getParameter(DUL_1) != null) {
			dul1 = (req.getParameter(DUL_1));
		} else {
			dul1 = "N";

		}

		if (req.getParameter(DLR_8) != null) {
			dlr8 = (req.getParameter(DLR_8));
		} else {
			dlr8 = "N";

		}
		if (req.getParameter(DLR_7) != null) {
			dlr7 = (req.getParameter(DLR_7));
		} else {
			dlr7 = "N";

		}
		if (req.getParameter(DLR_6) != null) {
			dlr6 = (req.getParameter(DLR_6));
		} else {
			dlr6 = "N";

		}
		if (req.getParameter(DLR_5) != null) {
			dlr5 = (req.getParameter(DLR_5));
		} else {
			dlr5 = "N";

		}
		if (req.getParameter(DLR_4) != null) {
			dlr4 = (req.getParameter(DLR_4));
		} else {
			dlr4 = "N";

		}
		if (req.getParameter(DLR_3) != null) {
			dlr3 = (req.getParameter(DLR_3));
		} else {
			dlr3 = "N";

		}
		if (req.getParameter(DLR_2) != null) {
			dlr2 = (req.getParameter(DLR_2));
		} else {
			dlr2 = "N";

		}

		if (req.getParameter(DLR_1) != null) {
			dlr1 = (req.getParameter(DLR_1));
		} else {
			dlr1 = "N";

		}

		if (req.getParameter(DLL_8) != null) {
			dll8 = (req.getParameter(DLL_8));
		} else {
			dll8 = "N";

		}
		if (req.getParameter(DLL_7) != null) {
			dll7 = (req.getParameter(DLL_7));
		} else {
			dll7 = "N";

		}

		if (req.getParameter(DLL_6) != null) {
			dll6 = (req.getParameter(DLL_6));
		} else {
			dll6 = "N";

		}
		if (req.getParameter(DLL_5) != null) {
			dll5 = (req.getParameter(DLL_5));
		} else {
			dll5 = "N";

		}
		if (req.getParameter(DLL_4) != null) {
			dll4 = (req.getParameter(DLL_4));
		} else {
			dll4 = "N";

		}
		if (req.getParameter(DLL_3) != null) {
			dll3 = (req.getParameter(DLL_3));
		} else {
			dll3 = "N";

		}
		if (req.getParameter(DLL_2) != null) {
			dll2 = (req.getParameter(DLL_2));
		} else {
			dll2 = "N";

		}
		if (req.getParameter(DLL_1) != null) {
			dll1 = (req.getParameter(DLL_1));
		} else {
			dll1 = "N";

		}
		// ///////////////////////////

		if (req.getParameter(UUR_8) != null) {
			uur8 = (req.getParameter(UUR_8));
		} else {
			uur8 = "N";

		}

		if (req.getParameter(UUR_7) != null) {
			uur7 = (req.getParameter(UUR_7));
		} else {
			uur7 = "N";

		}
		if (req.getParameter(UUR_6) != null) {
			uur6 = (req.getParameter(UUR_6));
		} else {
			uur6 = "N";

		}
		if (req.getParameter(UUR_5) != null) {
			uur5 = (req.getParameter(UUR_5));
		} else {
			uur5 = "N";

		}
		if (req.getParameter(UUR_4) != null) {
			uur4 = (req.getParameter(UUR_4));
		} else {
			uur4 = "N";

		}
		if (req.getParameter(UUR_3) != null) {
			uur3 = (req.getParameter(UUR_3));
		} else {
			uur3 = "N";

		}
		if (req.getParameter(UUR_2) != null) {
			uur2 = (req.getParameter(UUR_2));
		} else {
			uur2 = "N";

		}
		if (req.getParameter(UUR_1) != null) {
			uur1 = (req.getParameter(UUR_1));
		} else {
			uur1 = "N";

		}

		if (req.getParameter(UUL_8) != null) {
			uul8 = (req.getParameter(UUL_8));
		} else {
			uul8 = "N";

		}
		if (req.getParameter(UUL_7) != null) {
			uul7 = (req.getParameter(UUL_7));

		} else {
			uul7 = "N";

		}
		if (req.getParameter(UUL_6) != null) {
			uul6 = (req.getParameter(UUL_6));
		} else {
			uul6 = "N";

		}
		if (req.getParameter(UUL_5) != null) {
			uul5 = (req.getParameter(UUL_5));
		} else {
			uul5 = "N";

		}
		if (req.getParameter(UUL_4) != null) {
			uul4 = (req.getParameter(UUL_4));
		} else {
			uul4 = "N";

		}
		if (req.getParameter(UUL_3) != null) {
			uul3 = (req.getParameter(UUL_3));
		} else {
			uul3 = "N";

		}
		if (req.getParameter(UUL_2) != null) {
			uul2 = (req.getParameter(UUL_2));
		} else {
			uul2 = "N";

		}
		if (req.getParameter(UUL_1) != null) {
			uul1 = (req.getParameter(UUL_1));
		} else {
			uul1 = "N";

		}
		if (req.getParameter(ULR_8) != null) {
			ulr8 = (req.getParameter(ULR_8));
		} else {
			ulr8 = "N";

		}

		if (req.getParameter(ULR_7) != null) {
			ulr7 = (req.getParameter(ULR_7));
		} else {
			ulr7 = "N";

		}
		if (req.getParameter(ULR_6) != null) {
			ulr6 = (req.getParameter(ULR_6));
		} else {
			ulr6 = "N";

		}
		if (req.getParameter(ULR_5) != null) {
			ulr5 = (req.getParameter(ULR_5));
		} else {
			ulr5 = "N";

		}
		if (req.getParameter(ULR_4) != null) {
			ulr4 = (req.getParameter(ULR_4));
		} else {
			ulr4 = "N";

		}
		if (req.getParameter(ULR_3) != null) {
			ulr3 = (req.getParameter(ULR_3));
		} else {
			ulr3 = "N";

		}
		if (req.getParameter(ULR_2) != null) {
			ulr2 = (req.getParameter(ULR_2));
		} else {
			ulr2 = "N";

		}
		if (req.getParameter(ULR_1) != null) {
			ulr1 = (req.getParameter(ULR_1));
		} else {
			ulr1 = "N";

		}

		if (req.getParameter(ULL_8) != null) {
			ull8 = (req.getParameter(ULL_8));
		} else {
			ull8 = "N";

		}
		if (req.getParameter(ULL_7) != null) {
			ull7 = (req.getParameter(ULL_7));
		} else {
			ull7 = "N";

		}
		if (req.getParameter(ULL_6) != null) {
			ull6 = (req.getParameter(ULL_6));
		} else {
			ull6 = "N";

		}
		if (req.getParameter(ULL_5) != null) {
			ull5 = (req.getParameter(ULL_5));
		} else {
			ull5 = "N";

		}
		if (req.getParameter(ULL_4) != null) {
			ull4 = (req.getParameter(ULL_4));
		} else {
			ull4 = "N";

		}
		if (req.getParameter(ULL_3) != null) {
			ull3 = (req.getParameter(ULL_3));
		} else {
			ull3 = "N";

		}
		if (req.getParameter(ULL_2) != null) {
			ull2 = (req.getParameter(ULL_2));
		} else {
			ull2 = "N";

		}
		if (req.getParameter(ULL_1) != null) {
			ull1 = (req.getParameter(ULL_1));
		} else {
			ull1 = "N";

		}

		// ////////////////////////

		if (req.getParameter(MUR_8) != null) {
			mur8 = (req.getParameter(MUR_8));

		} else {
			mur8 = "N";

		}
		if (req.getParameter(MUR_7) != null) {
			mur7 = (req.getParameter(MUR_7));
		} else {
			mur7 = "N";

		}
		if (req.getParameter(MUR_6) != null) {
			mur6 = (req.getParameter(MUR_6));
		} else {
			mur6 = "N";

		}
		if (req.getParameter(MUR_5) != null) {
			mur5 = (req.getParameter(MUR_5));
		} else {
			mur5 = "N";

		}
		if (req.getParameter(MUR_4) != null) {
			mur4 = (req.getParameter(MUR_4));
		} else {
			mur4 = "N";

		}
		if (req.getParameter(MUR_3) != null) {
			mur3 = (req.getParameter(MUR_3));
		} else {
			mur3 = "N";

		}
		if (req.getParameter(MUR_2) != null) {
			mur2 = (req.getParameter(MUR_2));
		} else {
			mur2 = "N";

		}
		if (req.getParameter(MUR_1) != null) {
			mur1 = (req.getParameter(MUR_1));
		} else {
			mur1 = "N";

		}

		if (req.getParameter(MUL_8) != null) {
			mul8 = (req.getParameter(MUL_8));
		} else {
			mul8 = "N";

		}
		if (req.getParameter(MUL_7) != null) {
			mul7 = (req.getParameter(MUL_7));

		} else {
			mul7 = "N";

		}
		if (req.getParameter(MUL_6) != null) {
			mul6 = (req.getParameter(MUL_6));
		} else {
			mul6 = "N";

		}
		if (req.getParameter(MUL_5) != null) {
			mul5 = (req.getParameter(MUL_5));
		} else {
			mul5 = "N";

		}
		if (req.getParameter(MUL_4) != null) {
			mul4 = (req.getParameter(MUL_4));
		} else {
			mul4 = "N";

		}
		if (req.getParameter(MUL_3) != null) {
			mul3 = (req.getParameter(MUL_3));
		} else {
			mul3 = "N";

		}
		if (req.getParameter(MUL_2) != null) {
			mul2 = (req.getParameter(MUL_2));
		} else {
			mul2 = "N";

		}
		if (req.getParameter(MUL_1) != null) {
			mul1 = (req.getParameter(MUL_1));
		} else {
			mul1 = "N";

		}
		if (req.getParameter(MLR_8) != null) {
			mlr8 = (req.getParameter(MLR_8));
		} else {
			mlr8 = "N";

		}

		if (req.getParameter(MLR_7) != null) {
			mlr7 = (req.getParameter(MLR_7));
		} else {
			mlr7 = "N";

		}
		if (req.getParameter(MLR_6) != null) {
			mlr6 = (req.getParameter(MLR_6));
		} else {
			mlr6 = "N";

		}
		if (req.getParameter(MLR_5) != null) {
			mlr5 = (req.getParameter(MLR_5));
		} else {
			mlr5 = "N";

		}

		if (req.getParameter(MLR_4) != null) {
			mlr4 = (req.getParameter(MLR_4));
		} else {
			mlr4 = "N";

		}
		if (req.getParameter(MLR_3) != null) {
			mlr3 = (req.getParameter(MLR_3));
		} else {
			mlr3 = "N";

		}

		if (req.getParameter(MLR_2) != null) {
			mlr2 = (req.getParameter(MLR_2));
		} else {
			mlr2 = "N";

		}
		if (req.getParameter(MLR_1) != null) {
			mlr1 = (req.getParameter(MLR_1));
		} else {
			mlr1 = "N";

		}

		if (req.getParameter(MLL_8) != null) {
			mll8 = (req.getParameter(MLL_8));
		} else {
			mll8 = "N";

		}
		if (req.getParameter(MLL_7) != null) {
			mll7 = (req.getParameter(MLL_7));
		} else {
			mll7 = "N";

		}
		if (req.getParameter(MLL_6) != null) {
			mll6 = (req.getParameter(MLL_6));
		} else {
			mll6 = "N";

		}
		if (req.getParameter(MLL_5) != null) {
			mll5 = (req.getParameter(MLL_5));
		} else {
			mll5 = "N";

		}
		if (req.getParameter(MLL_4) != null) {
			mll4 = (req.getParameter(MLL_4));
		} else {
			mll4 = "N";

		}
		if (req.getParameter(MLL_3) != null) {
			mll3 = (req.getParameter(MLL_3));
		} else {
			mll3 = "N";

		}
		if (req.getParameter(MLL_2) != null) {
			mll2 = (req.getParameter(MLL_2));
		} else {
			mll2 = "N";

		}
		if (req.getParameter(MLL_1) != null) {
			mll1 = (req.getParameter(MLL_1));
		} else {
			mll1 = "N";

		}

		sur8 = dur8 + "" + mur8 + "" + uur8;

		sur7 = dur7 + "" + mur7 + "" + uur7;

		sur6 = dur6 + "" + mur6 + "" + uur6;
		sur5 = dur5 + "" + mur5 + "" + uur5;
		sur4 = dur4 + "" + mur4 + "" + uur4;
		sur3 = dur3 + "" + mur3 + "" + uur3;
		sur2 = dur2 + "" + mur2 + "" + uur2;
		sur1 = dur1 + "" + mur2 + "" + uur1;

		sul8 = dul8 + "" + mul8 + "" + uul8;
		sul7 = dul7 + "" + mul7 + "" + uul7;

		sul6 = dul6 + "" + mul6 + "" + uul6;
		sul5 = dul5 + "" + mul5 + "" + uul5;
		sul4 = dul4 + "" + mul4 + "" + uul4;
		sul3 = dul3 + "" + mul3 + "" + uul3;
		sul2 = dul2 + "" + mul2 + "" + uul2;
		sul1 = dul1 + "" + mul1 + "" + uul1;

		slr8 = dlr8 + "" + mlr8 + "" + ulr8;
		slr7 = dlr7 + "" + mlr7 + "" + ulr7;
		slr6 = dlr6 + "" + mlr6 + "" + ulr6;
		slr5 = dlr5 + "" + mlr5 + "" + ulr5;
		slr4 = dlr4 + "" + mlr4 + "" + ulr4;
		slr3 = dlr3 + "" + mlr3 + "" + ulr3;
		slr2 = dlr2 + "" + mlr2 + "" + ulr2;
		slr1 = dlr1 + "" + mlr2 + "" + ulr1;

		sll8 = dll8 + "" + mll8 + "" + ull8;
		sll7 = dll7 + "" + mll7 + "" + ull7;
		sll6 = dll6 + "" + mll6 + "" + ull6;
		sll5 = dll5 + "" + mll5 + "" + ull5;
		sll4 = dll4 + "" + mll4 + "" + ull4;
		sll3 = dll3 + "" + mll3 + "" + ull3;
		sll2 = dll2 + "" + mll2 + "" + ull2;
		sll1 = dll1 + "" + mll2 + "" + ull1;
		MbTypeOfEntryMaster mbTypeOfEntryMaster = new MbTypeOfEntryMaster();
		mbTypeOfEntryMaster.setId(typeOfEntry);
		generalMap.put("serviceNo", serviceNo);
		generalMap.put("allergies", allergies);
		generalMap.put("pojoPropertyCode", "serviceNo");
		generalMap.put("pojoName", "MasMedicalExaminationReportOnEntry");
		String message = "";
		String jsp = "";
		Boolean successfullyAdded = false;
		
		// Added By Vinay
		String DoctorAdviceFlag="n";
				if(req.getParameter("DoctorAdviceFlag") != null)
				{
					DoctorAdviceFlag = req.getParameter("DoctorAdviceFlag");
				}
				System.out.println("DoctorAdviceFlag="+DoctorAdviceFlag);
			masMedicalBoardProceedings.setDoctorAdviceFlag(DoctorAdviceFlag);
		    masMedicalBoardProceedings.setDentalOfficer(DentalOfficer);
		    masMedicalBoardProceedings.setDentalCheckupDate(dentalcheckupdate);
			masMedicalBoardProceedings.setInnerEarL(innerEarL);
			masMedicalBoardProceedings.setHearingBothCv(hearingBothCV);
			masMedicalBoardProceedings.setDateSpecialExam(eyeDate);
			masMedicalBoardProceedings
		 			.setTotalDefectiveTeeth(totalDefectiveTeeth);
			masMedicalBoardProceedings.setTotalTeeth(totalTeeth);
			masMedicalBoardProceedings.setMissingTeeth(missingTeeth);
			masMedicalBoardProceedings.setUnservisableTeeth(unserviceableTeeth);
			masMedicalBoardProceedings.setDenstlPoint(DenstalPoint);
			masMedicalBoardProceedings.setYearlySerialNo(serviceNo);
			//	masMedicalBoardProceedings.setMonthlySerialNo(rank);
			masMedicalBoardProceedings.setEntryDate(entryDate);

			masMedicalBoardProceedings.setTypeOfEntry(mbTypeOfEntryMaster);
			//masMedicalBoardProceedings.setBatchNo(betchNo);
			masMedicalBoardProceedings.setChestNo(chestNo);
			masMedicalBoardProceedings.setRollNo(rollNo);
			masMedicalBoardProceedings.setMedicalStatus(medicalStatus);
			masMedicalBoardProceedings.setNameInFull(fullName);
			masMedicalBoardProceedings.setDateOfBirth(dateOfBirth);
			if(maritialStatus != 0){
				MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
				masMaritalStatus.setId(maritialStatus);
				masMedicalBoardProceedings.setMaritalStatus(masMaritalStatus);
			}
			masMedicalBoardProceedings.setPNo(pNo);			
			masMedicalBoardProceedings.setHoursOfFlown(hoursOfFlown);
			masMedicalBoardProceedings.setParmanentAddress(permanentAddress);
			masMedicalBoardProceedings.setIdentificationMarks1(identification1);
			masMedicalBoardProceedings.setIdentificationMarks2(identification2);
			masMedicalBoardProceedings.setArmsCorps(armsCrops);
			masMedicalBoardProceedings.setDateOfCompletion(dateOfCompletion);
			masMedicalBoardProceedings
					.setDocumentForwardDate(documentForwardDate);
			masMedicalBoardProceedings.setDateOfReporting(dateOfReporting);
			masMedicalBoardProceedings.setDocumentForwardTo(documentForwardTo);
			masMedicalBoardProceedings.setFromWhereHeReport(fromWhereHeReport);
			masMedicalBoardProceedings.setHypertension(hypertension);
			masMedicalBoardProceedings.setHeartDiabetes(heartDisease);
			masMedicalBoardProceedings.setDiabetes(diabetes);
			masMedicalBoardProceedings.setBleedingDisorder(bleedingDisorder);
			masMedicalBoardProceedings.setMentalDisease(mentalDisease);
			masMedicalBoardProceedings.setNightBlindness(nightBlindness);
			masMedicalBoardProceedings.setChronicBronchitis(asthama);
			masMedicalBoardProceedings.setDischargeFromEars(dischargeFrom);
			masMedicalBoardProceedings.setPleurisy(plesury);
			masMedicalBoardProceedings.setAnyOtherEarDisease(earDieses);
			masMedicalBoardProceedings
					.setRheumatismFrequentSorethroats(rheumatism);
			masMedicalBoardProceedings
					.setFrequentCoughColdSinusitis(frequentCough);
			masMedicalBoardProceedings
					.setChronicIndigestion(chronicIndigestion);
			masMedicalBoardProceedings
					.setNervousBreakdownMentalIllness(nervousBrakdown);
			masMedicalBoardProceedings.setKidneyBladderTrouble(kidenyBladder);
			masMedicalBoardProceedings
					.setFitsFaintingAttack(fitsFaintinngAttacks);
			masMedicalBoardProceedings.setStd(std);
			masMedicalBoardProceedings.setSevereHeadInjury(serveHeadInjury);
			masMedicalBoardProceedings.setJaundice(joundice);
			masMedicalBoardProceedings.setAirSeaCarTrainSickness(sickness);
			masMedicalBoardProceedings.setBreastDiseaseDischarge(breastDisease);
			masMedicalBoardProceedings.setTrachoma(trachoma);
			masMedicalBoardProceedings.setAmenorrhoeaDysmenonhoea(amenorrhoea);
			masMedicalBoardProceedings.setNightBindness(nightbindness);
			masMedicalBoardProceedings.setMenonhagia(menirrhagia);
			masMedicalBoardProceedings
					.setLaserTreatementSurgeryForEye(laserTeartement);
			masMedicalBoardProceedings.setPregnancy(pregnancy);
			masMedicalBoardProceedings.setAnyOtherEyeDisease(eyeDisease);
			masMedicalBoardProceedings.setAbortion(abortion);
			masMedicalBoardProceedings
					.setBeenrejectedAsMedicallyUnfitForAnyBranch(rejectedAsUnfit);
			masMedicalBoardProceedings
					.setDischargeAsMedicallyUnfitForAnyBranch(dischargeMedicallyUnfit);
			masMedicalBoardProceedings
					.setAdmittedInHospitalForAnyIllnessOperationOrInjury(adimmitedInHospitalFirIllness);

			masMedicalBoardProceedings
					.setStateTheNatureOfDiseaseDuration(stateNature);
			masMedicalBoardProceedings
					.setAnyOtherInformationAboutYourHealth(otherInform);
			masMedicalBoardProceedings.setHeight(height);
			masMedicalBoardProceedings.setWeight(weight);
			masMedicalBoardProceedings.setAcceptable(acceptableKg);
			masMedicalBoardProceedings.setLegLength(leglength);
			masMedicalBoardProceedings.setAppearance(appereance);
			masMedicalBoardProceedings.setAlbumin(albumin);
			masMedicalBoardProceedings.setSugar(sugar);
			masMedicalBoardProceedings.setAdmissionStatus("n");
			masMedicalBoardProceedings.setSpecialistOpinnionStatus("n");
								
			masMedicalBoardProceedings.setSpGravity(spGraviry);
			masMedicalBoardProceedings.setHbPercentage(hbPercentage);
			masMedicalBoardProceedings.setAnyOtherInvCarriedOut(anyOtherInv);
			masMedicalBoardProceedings.setPhysique(physique);
			masMedicalBoardProceedings.setSkin(skin);
			masMedicalBoardProceedings.setAbdomen(abdomen);
			masMedicalBoardProceedings.setHeartSize(heartSize);
			masMedicalBoardProceedings.setSounds(sound);
			masMedicalBoardProceedings.setRhythm(rhythm);
			masMedicalBoardProceedings.setArterialWalls(arterialWalls);
			masMedicalBoardProceedings.setPulseRates(pulseRates);
			masMedicalBoardProceedings.setBp(bp);
			masMedicalBoardProceedings.setChestMeasurement(fullExpension);
			masMedicalBoardProceedings.setRangeOfExpension(rangeOfExpension);
			masMedicalBoardProceedings.setSelfBalancingR(selfBalR);
			masMedicalBoardProceedings.setSelfBalancingL(selfBalL);
			masMedicalBoardProceedings.setSpeechMentalCapacity(speechMental);
			masMedicalBoardProceedings.setEndocrineCondition(endocrinCond);
			masMedicalBoardProceedings
					.setAnyOtheAbnormalities(otherAbnormalities);
			masMedicalBoardProceedings.setRemarks(medicinRemarks);
			masMedicalBoardProceedings.setFingers(finger);
			masMedicalBoardProceedings.setHand(hand);
			masMedicalBoardProceedings.setWrists(wrist);
			masMedicalBoardProceedings.setElbows(elbows);
			masMedicalBoardProceedings.setShoulderGirdles(shoulderGridles);
			masMedicalBoardProceedings.setCervical(cercival);
			masMedicalBoardProceedings.setDorsalVertebrate(dorsalVertebrate);
			masMedicalBoardProceedings.setHullux(hullux);
			masMedicalBoardProceedings.setValgus(valgus);
			masMedicalBoardProceedings.setRigigus(riggus);
			masMedicalBoardProceedings.setFlatFeet(flatFeet);
			masMedicalBoardProceedings.setJoints(joints);
			masMedicalBoardProceedings.setPelvis(pelvis);
			masMedicalBoardProceedings.setGail(gail);
			masMedicalBoardProceedings.setLumber(lumberScaler);
			masMedicalBoardProceedings.setRoccyxVarocose(roccyxVericose);
			masMedicalBoardProceedings.setHydrocele(hydrocele);
			masMedicalBoardProceedings.setVaricocele(varicocele);
			masMedicalBoardProceedings.setUnderscendedTest(underScende);
			masMedicalBoardProceedings.setHemorrhoids(hemonhoids);
			masMedicalBoardProceedings.setHerniaMusic(herinaMusic);
			masMedicalBoardProceedings.setBreasts(breasts);
			masMedicalBoardProceedings.setRemarksLowerlimbs(surgeryRemarks);
			masMedicalBoardProceedings.setRespiratorySystem(respatorySystem);
			masMedicalBoardProceedings
					.setWithGlassesLDistant(withglassesDistantL);
			masMedicalBoardProceedings
					.setWithGlassesRDistant(withGlassesDistantR);
			masMedicalBoardProceedings
					.setWithoutGlassesLDistant(withoutGlassesDistantL);
			masMedicalBoardProceedings
					.setWthoutGlassesRDistant(withoutGlassesDistantR);
			masMedicalBoardProceedings
					.setWithGlassesLNearvision(withGlassesNearL);
			masMedicalBoardProceedings
					.setWithGlassesRNearvision(withGlassesNearR);
			masMedicalBoardProceedings
					.setWithoutGlassesLNearvision(withoutGlassesNearL);
			masMedicalBoardProceedings
					.setWithoutGlassesRNearvision(withoutGlassesNearR);
			masMedicalBoardProceedings
					.setEvidenceOfTrachoma(evidienceOfTrachoma);
			masMedicalBoardProceedings.setBinocularVisionGrade(binocular);
			masMedicalBoardProceedings
					.setManifestHypermetropia(manifestHypermetropia);
			masMedicalBoardProceedings.setCoverTest(coverTest);
			masMedicalBoardProceedings.setDiaphragmTest(diaphragmTest);
			masMedicalBoardProceedings.setFundAndMedia(fundMedia);
			masMedicalBoardProceedings.setFields(fields);
			masMedicalBoardProceedings
					.setNightVisualCapacity(nightVisualCapacity);
			masMedicalBoardProceedings.setConvergenceC(convergenceC);
			masMedicalBoardProceedings.setConvergenceSc(convergenceCP);
			masMedicalBoardProceedings.setAccommodationR(accommodationR);
			masMedicalBoardProceedings.setAccommodationL(accommodationL);
			masMedicalBoardProceedings.setRemarksSpecialExam(eyeRemarks);
			masMedicalBoardProceedings.setHearingRcv(hearingRCV);
			masMedicalBoardProceedings.setHearingLcv(hearingLCV);
			masMedicalBoardProceedings.setEarHearingRfw(hearingRFW);
			masMedicalBoardProceedings.setEarHearingLfw(hearingLFW);
			masMedicalBoardProceedings.setEarHearingBothFw(hearingBothFW);
			masMedicalBoardProceedings.setExternalEarR(externalEarR);
			masMedicalBoardProceedings.setExternalEarL(externalEarL);
			masMedicalBoardProceedings.setMiddleEarR(middleEarR);
			masMedicalBoardProceedings.setMiddleEar(middleEarL);

			masMedicalBoardProceedings.setInnerEarR(innerEarR);
			masMedicalBoardProceedings.setAudiometryRecord(audiometryRecord);
			masMedicalBoardProceedings.setNose(nose);
			masMedicalBoardProceedings.setThroat(throatEar);
			masMedicalBoardProceedings.setRemarksEar(earReamrks);
			masMedicalBoardProceedings.setEarDate(earDate);
			masMedicalBoardProceedings.setDateTeath(dentalDate);
			masMedicalBoardProceedings.setRemarksTeath(dentalRemarks);
			masMedicalBoardProceedings.setReferToMH(denatlToMH);
			masMedicalBoardProceedings.setMenstrualHistory(menstrualHistory);
			masMedicalBoardProceedings.setNoOfPregnancies(noOfPregnancy);
			masMedicalBoardProceedings.setNoOfAbortions(noOfAbortion);
			masMedicalBoardProceedings.setNoOfChildren(noOfChildren);
			masMedicalBoardProceedings.setLastConfinementDate(lastCondinement);
			masMedicalBoardProceedings.setVaginalDischarge(vaginalDischarge);
			masMedicalBoardProceedings.setProlapse(prolapse);
			masMedicalBoardProceedings.setUsgAbdomen(usgAbortion);
			masMedicalBoardProceedings.setGynaecologyDate(gyanaecologyDate);
			masMedicalBoardProceedings.setRemarksGynaecology(gyanaecologyRemarks);
			
			masMedicalBoardProceedings
					.setMedicalBoardFindings(medicalBoardExamination);
			masMedicalBoardProceedings
					.setDateMedicalBoardExam(medicalBoardExaminationDate);
			masMedicalBoardProceedings.setLmp(lmp);
			if (medicalBoardExaminationPlace != 0) {
				MasUnit masUnit1 = new MasUnit();
				masUnit1.setId(medicalBoardExaminationPlace);
				masMedicalBoardProceedings.setPlaceMedicalBoardExam(masUnit1);
			}
			masMedicalBoardProceedings
					.setMedicalBoardSubsequentFind(subsequentMedicalBoardExam);
			masMedicalBoardProceedings
					.setDateMedicalBoardSubsequent(subsequentMedicalBoardExamDate);
			if (subsequentMedicalBoardExamPlace != 0) {
				MasUnit masUnit2 = new MasUnit();
				masUnit2.setId(subsequentMedicalBoardExamPlace);
				masMedicalBoardProceedings
						.setPlaceMedicalBoardSubsequent(masUnit2);
			}
			masMedicalBoardProceedings
					.setApprovingAuthority(ApprovingAuthority);
			masMedicalBoardProceedings
					.setDateApprovingAuthority(ApprovingAuthorityDate);
			if (ApprovingAuthorityPlace != 0) {
				MasUnit masUnit3 = new MasUnit();
				masUnit3.setId(ApprovingAuthorityPlace);
				masMedicalBoardProceedings.setPlaceApprovingAuthority(masUnit3);
			}
			masMedicalBoardProceedings.setSurgeryDate(surgeyDate);
			masMedicalBoardProceedings.setMediceExamDate(medicinExamDate);
			masMedicalBoardProceedings
					.setNearVisionWithGlassCp(withGlassesNearCP);
			masMedicalBoardProceedings
					.setNearVisionWithoutGlassCp(withoutGlassesNearCP);
			masMedicalBoardProceedings.setUR1(sur1);
			masMedicalBoardProceedings.setUR2(sur2);
			masMedicalBoardProceedings.setUR3(sur3);
			masMedicalBoardProceedings.setUR4(sur4);
			masMedicalBoardProceedings.setUR5(sur5);
			masMedicalBoardProceedings.setUR6(sur6);
			masMedicalBoardProceedings.setUR7(sur7);
			masMedicalBoardProceedings.setUR8(sur8);

			masMedicalBoardProceedings.setUL1(sul1);
			masMedicalBoardProceedings.setUL2(sul2);
			masMedicalBoardProceedings.setUL3(sul3);
			masMedicalBoardProceedings.setUL4(sul4);
			masMedicalBoardProceedings.setUL5(sul5);
			masMedicalBoardProceedings.setUL6(sul6);
			masMedicalBoardProceedings.setUL7(sul7);
			masMedicalBoardProceedings.setUL8(sul8);

			masMedicalBoardProceedings.setLR1(slr1);
			masMedicalBoardProceedings.setLR2(slr2);
			masMedicalBoardProceedings.setLR3(slr3);
			masMedicalBoardProceedings.setLR4(slr4);
			masMedicalBoardProceedings.setLR5(slr5);
			masMedicalBoardProceedings.setLR6(slr6);
			masMedicalBoardProceedings.setLR7(slr7);
			masMedicalBoardProceedings.setLR8(slr8);

			masMedicalBoardProceedings.setLL1(sll1);
			masMedicalBoardProceedings.setLL2(sll2);
			masMedicalBoardProceedings.setLL3(sll3);
			masMedicalBoardProceedings.setLL4(sll4);
			masMedicalBoardProceedings.setLL5(sll5);
			masMedicalBoardProceedings.setLL6(sll6);
			masMedicalBoardProceedings.setLL7(sll7);
			masMedicalBoardProceedings.setLL8(sll8);
			masMedicalBoardProceedings.setLastChangedBy(lastChangedBy);
			masMedicalBoardProceedings.setLastChangedDate(lastChangedDate);
			masMedicalBoardProceedings.setLastChangedTime(lastChangedTime);
			masMedicalBoardProceedings.setServiceNo(serviceNo);
			masMedicalBoardProceedings.setServiceiaf(serviceiaf); 
			
			masMedicalBoardProceedings.setTypeofcommision(typeOfCommunication);
			masMedicalBoardProceedings.setDateofcommun(dateofcommun);
			masMedicalBoardProceedings.setTotalService(totalservice);
			masMedicalBoardProceedings.setPastmedicalhistory(pastmedicalhistory);
			masMedicalBoardProceedings.setPresentmedicalhistory(presentmedicalhistory);
			masMedicalBoardProceedings.setIdealweight(idealweight);
			masMedicalBoardProceedings.setOverweight(overweight);
			masMedicalBoardProceedings.setWaist(waist);
			masMedicalBoardProceedings.setChestfullexpansion(chestfullexpansion);
			masMedicalBoardProceedings.setBhi(bhi);
			masMedicalBoardProceedings.setRangeofexpansion(rangeofexpansion);
			masMedicalBoardProceedings.setBodyfat(bodyfat);
			masMedicalBoardProceedings.setSignfoldthickness(signfoldthickness);
			masMedicalBoardProceedings.setSportman(sportman);
			masMedicalBoardProceedings.setLastame(lastame);
			masMedicalBoardProceedings.setActualweight(actualweight);
			masMedicalBoardProceedings.setSourceOfData("MEDNET");
			masMedicalBoardProceedings.setHicStatus("n");	
			// Added By Vinay
			
			
			if(req.getParameter(SERVICE_TYPE_ID) != null && !(req.getParameter(SERVICE_TYPE_ID)).equals("0")){
				MasServiceType serviceType = new MasServiceType();
				serviceType.setId(Integer.parseInt(req.getParameter(SERVICE_TYPE_ID)));
				masMedicalBoardProceedings.setServiceType(serviceType);
			}
			if(req.getParameter(RANK_ID) != null && !(req.getParameter(RANK_ID)).equals("0")){
				MasRank masRank = new MasRank();
				masRank.setId(Integer.parseInt(req.getParameter(RANK_ID)));
				masMedicalBoardProceedings.setRank(masRank);
			}
			if(req.getParameter(TRADE_ID) != null ){
				MasTrade masTrade = new MasTrade();
				masTrade.setId(Integer.parseInt(req.getParameter(TRADE_ID)));
				masMedicalBoardProceedings.setTrade(masTrade);
			}	
			if(req.getParameter(UNIT_ID) != null && !(req.getParameter(UNIT_ID)).equals("0")){
				MasUnit unitObj = new MasUnit();
				unitObj.setId(Integer.parseInt(req.getParameter(UNIT_ID)));
				masMedicalBoardProceedings.setUnit(unitObj);
			}	
			if(req.getParameter("apparentAge") != null && !req.getParameter("apparentAge").equals("")){
				String aparentage=req.getParameter("apparentAge");
				masMedicalBoardProceedings.setApparentAge(aparentage.substring(0, 2));
			}
			if(req.getParameter(VISIT_ID) != null && !(req.getParameter(VISIT_ID)).equals("0")){
				Visit visit = new Visit();
				visit.setId(Integer.parseInt(req.getParameter(VISIT_ID)));
				if(req.getParameter("apparentAge") == null )
				{
					if(masMedicalBoardProceedings.getVisit()!=null &&masMedicalBoardProceedings.getVisit().getAge()!=null)
					{
						
					masMedicalBoardProceedings.setApparentAge(masMedicalBoardProceedings.getVisit().getAge().substring(0, 2));
					}
				}
				masMedicalBoardProceedings.setVisit(visit);
			}		
			if(req.getParameter(HIN_ID) != null && !(req.getParameter(HIN_ID)).equals("0")){
				Patient patient= new Patient();
				patient.setId(Integer.parseInt(req.getParameter(HIN_ID)));
				masMedicalBoardProceedings.setHin(patient);
				mapForDS.put("hinId", Integer.parseInt(req.getParameter(HIN_ID)));
			}	
			if(req.getParameter(FATHER_NAME) != null){
				masMedicalBoardProceedings.setFatherName(req.getParameter(FATHER_NAME));
			}
			if(req.getParameter(RELEVANT_FAMILY_HISTORY) != null){
				masMedicalBoardProceedings.setRelevantFamilyHistory(req.getParameter(RELEVANT_FAMILY_HISTORY));
			}
			if(req.getParameter(DEFECTS_NOT_TO_CAUSE_REJECTION) != null){
				masMedicalBoardProceedings.setDefectNotToCauseRejection(req.getParameter(DEFECTS_NOT_TO_CAUSE_REJECTION));
			}
			if(req.getParameter(FOUND_FIT_IN_CATEGORY) != null){
				masMedicalBoardProceedings.setFoundFitInCategory(req.getParameter(FOUND_FIT_IN_CATEGORY));
			}
			if(req.getParameter(APPOINTMENT_DATE) != null && !req.getParameter(APPOINTMENT_DATE).equals("")){
				masMedicalBoardProceedings.setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(req.getParameter(APPOINTMENT_DATE)));
			}
			if(req.getParameter(APPOINTMENT_TIME) != null && !req.getParameter(APPOINTMENT_TIME).equals("")){
				masMedicalBoardProceedings.setAppointmentTime(req.getParameter(APPOINTMENT_TIME));
			}
			if (req.getParameter("particularOfPreviousService") != null
					&& !(req.getParameter("particularOfPreviousService").equals(""))) {
				    masMedicalBoardProceedings.setParticularOfPreviousService(req.getParameter("particularOfPreviousService"));
			}
			if (req.getParameter("Hips") != null
					&& !(req.getParameter("Hips").equals(""))) {
				    masMedicalBoardProceedings.setHips(req.getParameter("Hips"));
			}
			if (req.getParameter("WHR") != null
					&& !(req.getParameter("WHR").equals(""))) {
				    masMedicalBoardProceedings.setWhr(req.getParameter("WHR"));
			}
			if(req.getParameter("medicalExamType") != null && !req.getParameter("medicalExamType").equals("")){
				masMedicalBoardProceedings.setMedicalExamType(req.getParameter("medicalExamType"));
				mapForDS.put("medicalExamType", req.getParameter("medicalExamType"));
			}
			if(req.getParameter("MissTeeth") != null && !req.getParameter("MissTeeth").equals("")){
				masMedicalBoardProceedings.setMissTeeth(req.getParameter("MissTeeth"));
			}
			if(req.getParameter("UnserTeeth") != null && !req.getParameter("UnserTeeth").equals("")){
				masMedicalBoardProceedings.setUnserTeeth(req.getParameter("UnserTeeth"));
			}
			if(req.getParameter("Investigated") != null && !req.getParameter("Investigated").equals("")){
				masMedicalBoardProceedings.setInvestigated(req.getParameter("Investigated"));
			}
			if(req.getParameter(APPOINTMENT_TIME) != null && !req.getParameter(APPOINTMENT_TIME).equals("")){
				masMedicalBoardProceedings.setAppointmentTime(req.getParameter(APPOINTMENT_TIME));
			}
			if(req.getParameter(HIGHER_MENTAL_FUNCTION) != null && !req.getParameter(HIGHER_MENTAL_FUNCTION).equals("")){
				masMedicalBoardProceedings.setHigherMentalFunction(req.getParameter(HIGHER_MENTAL_FUNCTION));
			}
			if(req.getParameter(SPEECH) != null && !req.getParameter(SPEECH).equals("")){
				masMedicalBoardProceedings.setSpeech(req.getParameter(SPEECH));
			}
			if(req.getParameter(REFLEXES) != null && !req.getParameter(REFLEXES).equals("")){
				masMedicalBoardProceedings.setReflexes(req.getParameter(REFLEXES));
			}
			if(req.getParameter(TREMORS) != null && !req.getParameter(TREMORS).equals("")){
				masMedicalBoardProceedings.setTremors(req.getParameter(TREMORS));
			}
			if(req.getParameter(SELF_BALANCING_TEST) != null && !req.getParameter(SELF_BALANCING_TEST).equals("")){
				masMedicalBoardProceedings.setSelfBalancingTest(req.getParameter(SELF_BALANCING_TEST));
			}
			
			if(req.getParameter(CORONORY_RISK_FACTOR) != null && !req.getParameter(CORONORY_RISK_FACTOR).equals("")){
				masMedicalBoardProceedings.setCoronaryRiskFactor(req.getParameter(CORONORY_RISK_FACTOR));
			}
			if(req.getParameter("familyHistoryOther") != null && !req.getParameter("familyHistoryOther").equals(""))
			{
				masMedicalBoardProceedings.setFmdm(req.getParameter("familyHistoryOther"));
			}
			if(req.getParameter(SIGNED_BY) != null && !req.getParameter(SIGNED_BY).equals("")){
				masMedicalBoardProceedings.setSignedBy(req.getParameter(SIGNED_BY));
			}
			if(req.getParameter(APPROVED_BY) != null && !req.getParameter(APPROVED_BY).equals("")){
				masMedicalBoardProceedings.setApprovedBy(req.getParameter(APPROVED_BY));
			}
			if(req.getParameter(SEND_TO) != null && !req.getParameter(SEND_TO).equals("")){
				masMedicalBoardProceedings.setSendTo(req.getParameter(SEND_TO));
			}
			if(req.getParameter("liver") != null && !req.getParameter("liver").equals("")){
				masMedicalBoardProceedings.setLiver(req.getParameter("liver"));
			}
			if(req.getParameter("spleen") != null && !req.getParameter("spleen").equals("")){
				masMedicalBoardProceedings.setSpleen(req.getParameter("spleen"));
			}
			if(req.getParameter("upperLimbs") != null && !req.getParameter("upperLimbs").equals("")){
				masMedicalBoardProceedings.setUpperLimbs(req.getParameter("upperLimbs"));
			}
			if(req.getParameter("locomotion") != null && !req.getParameter("locomotion").equals("")){
				masMedicalBoardProceedings.setLocomotion(req.getParameter("locomotion"));
			}
			if(req.getParameter("chestMeasurement") != null && !req.getParameter("chestMeasurement").equals("")){
				masMedicalBoardProceedings.setChestMeasurement(req.getParameter("chestMeasurement"));
			}
			if(req.getParameter("fullExpiration") != null && !req.getParameter("fullExpiration").equals("")){
				masMedicalBoardProceedings.setFullExpiration(req.getParameter("fullExpiration"));
			}
			if(req.getParameter("abnormalities") != null && !req.getParameter("abnormalities").equals("")){
				masMedicalBoardProceedings.setAbnormalities(req.getParameter("abnormalities"));
			}
			if(req.getParameter("otherAbnormalities") != null && !req.getParameter("otherAbnormalities").equals("")){
				masMedicalBoardProceedings.setAnyOtheAbnormalities(req.getParameter("otherAbnormalities"));
			}
			if(req.getParameter("anyEvidenceOfSkin") != null && !req.getParameter("anyEvidenceOfSkin").equals("")){
				masMedicalBoardProceedings.setAnyEvidenceOfSkin(req.getParameter("anyEvidenceOfSkin"));
			}
			if(req.getParameter("centralNervousSystem") != null && !req.getParameter("centralNervousSystem").equals("")){
				masMedicalBoardProceedings.setCentralNervousSystem(req.getParameter("centralNervousSystem"));
			}
			if(req.getParameter("mentalInstability") != null && !req.getParameter("mentalInstability").equals("")){
				masMedicalBoardProceedings.setMentalInstability(req.getParameter("mentalInstability"));
			}
			if(req.getParameter("essentialInstability") != null && !req.getParameter("essentialInstability").equals("")){
				masMedicalBoardProceedings.setEssentialInstability(req.getParameter("essentialInstability"));
			}
			if(req.getParameter("smoker") != null && !req.getParameter("smoker").equals("")){
				masMedicalBoardProceedings.setSmoker(req.getParameter("smoker"));
			}
			if(req.getParameter("drinker") != null && !req.getParameter("drinker").equals("")){
				masMedicalBoardProceedings.setDrinker(req.getParameter("drinker"));
			}
			if(req.getParameter("allergies") != null && !req.getParameter("allergies").equals("")){
				masMedicalBoardProceedings.setAllergies(req.getParameter("allergies"));
			}
			if(req.getParameter("locomoterSystem") != null && !req.getParameter("locomoterSystem").equals("")){
				masMedicalBoardProceedings.setLocomoterSystem(req.getParameter("locomoterSystem"));
				CocatHicNevreData="LocomoterSystem"+":"+req.getParameter("locomoterSystem")+"/ ";
			}
			else{
				CocatHicNevreData="LocomoterSystem"+":"+"NA"+"/ ";
			}
			
			if(req.getParameter("spine") != null && !req.getParameter("spine").equals("")){
				masMedicalBoardProceedings.setSpine(req.getParameter("spine"));
				CocatHicNevreData+="Spine"+":"+req.getParameter("spine")+"/ ";
			}
			else
			{
				CocatHicNevreData+="Spine"+":"+"NA"+"/ ";
			}
			if(req.getParameter("tympanicMembranceIntact") != null && !req.getParameter("tympanicMembranceIntact").equals("")){
				masMedicalBoardProceedings.setTympanicMembranceIntact(req.getParameter("tympanicMembranceIntact"));
			}
			if(req.getParameter(MOBILITYR) != null && !req.getParameter(MOBILITYR).equals("")){
				masMedicalBoardProceedings.setMobilityR(req.getParameter(MOBILITYR));
			}
			if(req.getParameter("noseThroatSinuses") != null && !req.getParameter("noseThroatSinuses").equals("")){
				masMedicalBoardProceedings.setNoseThroatSinuses(req.getParameter("noseThroatSinuses"));
			}

			if(req.getParameter(KNOWN_ALLERGY) != null && !req.getParameter(KNOWN_ALLERGY).equals("")){
				masMedicalBoardProceedings.setAllergies(req.getParameter(KNOWN_ALLERGY));
			}
			if(req.getParameter(BATCH_NO) != null && !req.getParameter(BATCH_NO).equals("")){
				masMedicalBoardProceedings.setBatchNo(req.getParameter(BATCH_NO));
			}
			if(req.getParameter("cmMdRemarks") != null && !req.getParameter("cmMdRemarks").equals("")){
				masMedicalBoardProceedings.setMdRemarks(req.getParameter("cmMdRemarks"));
			}
			if(req.getParameter(AUTHORITY_OF_BOARD) != null && !req.getParameter(AUTHORITY_OF_BOARD).equals("")){
				masMedicalBoardProceedings.setAuthority(req.getParameter(AUTHORITY_OF_BOARD));
			}
			if(req.getParameter(PLACE) != null && !req.getParameter(PLACE).equals("")){
				masMedicalBoardProceedings.setPlace(req.getParameter(PLACE));
			}
			if(req.getParameter(DATE_DISCHARGE) != null && !req.getParameter(DATE_DISCHARGE).equals("")){
				masMedicalBoardProceedings.setDateDischarge(HMSUtil.convertStringTypeDateToDateType(req.getParameter(DATE_DISCHARGE)));
			}
			if(req.getParameter(DATE_OF_RELEASE) != null && !req.getParameter(DATE_OF_RELEASE).equals("")){
				masMedicalBoardProceedings.setDateRelease(HMSUtil.convertStringTypeDateToDateType(req.getParameter(DATE_OF_RELEASE)));
			}
			if(req.getParameter(MARITAL_STATUS_ID) != null && !req.getParameter(MARITAL_STATUS_ID).equals("")){
				MasMaritalStatus maritalstatus = new MasMaritalStatus();
				maritalstatus.setId(Integer.parseInt(req.getParameter(MARITAL_STATUS_ID)));
				masMedicalBoardProceedings.setMaritalStatus(maritalstatus);
				
			}
			
		//	if(req.getParameter(SERVICE_TYPE_ID) != null && !req.getParameter(SERVICE_TYPE_ID).equals("")){
		//		masMedicalBoardProceedings.setBatchNo(req.getParameter(SERVICE_TYPE_ID));
		//	}
			if(req.getParameter(DATE_DISEASE) != null && !req.getParameter(DATE_DISEASE).equals("")){
				masMedicalBoardProceedings.setDateDisease(HMSUtil.convertStringTypeDateToDateType(req.getParameter(DATE_DISEASE)));
			}
			if(req.getParameter(PLACE_DISEASE) != null && !req.getParameter(PLACE_DISEASE).equals("")){
				masMedicalBoardProceedings.setPlacedisease(req.getParameter(PLACE_DISEASE));
			}
			if(req.getParameter(WHERE_TREATED) != null && !req.getParameter(WHERE_TREATED).equals("")){
				masMedicalBoardProceedings.setWheretreated(req.getParameter(WHERE_TREATED));
			}
			if(req.getParameter(DATE_APPROXIMATE) != null && !req.getParameter(DATE_APPROXIMATE).equals("")){
				masMedicalBoardProceedings.setDateapproximate(HMSUtil.convertStringTypeDateToDateType(req.getParameter(DATE_APPROXIMATE)));
			}
			if(req.getParameter(DISABILITY_BEFORE) != null && !req.getParameter(DISABILITY_BEFORE).equals("")){
				masMedicalBoardProceedings.setDisabilitybefore(req.getParameter(DISABILITY_BEFORE));
			}
			if(req.getParameter(DISABILITY) != null && !req.getParameter(DISABILITY).equals("")){
				masMedicalBoardProceedings.setDisability(req.getParameter(DISABILITY));
			}
			if(req.getParameter(CLAMING_DISABILITY) != null && !req.getParameter(CLAMING_DISABILITY).equals("")){
				masMedicalBoardProceedings.setClamingdisability(req.getParameter(CLAMING_DISABILITY));
			}
			if(req.getParameter(DATE_DISCHARGE) != null && !req.getParameter(DATE_DISCHARGE).equals("")){
				masMedicalBoardProceedings.setDateDischarge(HMSUtil.convertStringTypeDateToDateType(req.getParameter(DATE_DISCHARGE)));
			}
			if(req.getParameter(UPLOADED_DATE) != null && !req.getParameter(UPLOADED_DATE).equals("")){
				masMedicalBoardProceedings.setUploadeddate(HMSUtil.convertStringTypeDateToDateType(req.getParameter(UPLOADED_DATE)));
			}
			if(req.getParameter(REPORTED_DATE) != null && !req.getParameter(REPORTED_DATE).equals("")){
				masMedicalBoardProceedings.setDateOfReporting(HMSUtil.convertStringTypeDateToDateType(req.getParameter(REPORTED_DATE)));
			}
			if(req.getParameter(CONDITION_OF_GUMS) != null && !req.getParameter(CONDITION_OF_GUMS).equals("")){
				masMedicalBoardProceedings.setConditionOfGums(req.getParameter(CONDITION_OF_GUMS));
			}
			if(req.getParameter(TYMPANIC_L) != null && !req.getParameter(TYMPANIC_L).equals("")){
				masMedicalBoardProceedings.setTympanicL(req.getParameter(TYMPANIC_L));
			}
			if(req.getParameter(TYMPANIC_R) != null && !req.getParameter(TYMPANIC_R).equals("")){
				masMedicalBoardProceedings.setTympanicR(req.getParameter(TYMPANIC_R));
			}
			if(req.getParameter(MOBILITYL) != null && !req.getParameter(MOBILITYL).equals("")){
				masMedicalBoardProceedings.setMobilityL(req.getParameter(MOBILITYL));
			}
			if(req.getParameter(NOSE_THROAT) != null && !req.getParameter(NOSE_THROAT).equals("")){
				masMedicalBoardProceedings.setNosethroat(req.getParameter(NOSE_THROAT));
			}
			if(req.getParameter(DATE_OF_AME) != null && !req.getParameter(DATE_OF_AME).equals("")){
				masMedicalBoardProceedings.setDateMedicalBoardSubsequent(HMSUtil.convertStringTypeDateToDateType(req.getParameter(DATE_OF_AME)));
			}
			
			if(req.getParameter(HERNIA_MUSCLE)!=null && !req.getParameter(HERNIA_MUSCLE).equals("")){
			CocatHicNevreData+="HerniaMuscle"+":"+req.getParameter(HERNIA_MUSCLE)+"/ ";
			}else
			{
				CocatHicNevreData+="HerniaMuscle"+":"+"NA"+"/ ";	
			}
			if(req.getParameter(HYDROCELE)!=null && !req.getParameter(HYDROCELE).equals("")){
			CocatHicNevreData+="Hydrocele"+":"+req.getParameter(HYDROCELE)+"/ ";
			}else
			{
			CocatHicNevreData+="Hydrocele"+":"+"NA"+"/ ";
			}
			if(req.getParameter(HEMONHOIDS)!=null && !req.getParameter(HEMONHOIDS).equals("")){
			CocatHicNevreData+="Hemonhoids"+" :"+req.getParameter(HEMONHOIDS)+"/ ";
			}else
			{
				CocatHicNevreData+="Hemonhoids"+":"+"NA"+"/ ";	
			}
			if(req.getParameter(BREASTS)!=null && !req.getParameter(BREASTS).equals("")){
			CocatHicNevreData+="Breasts"+":"+req.getParameter(BREASTS)+"/ ";
			}else
			{
				CocatHicNevreData+="Breasts"+":"+"NA"+"/ ";	
			}
			if(CocatHicNevreData!=null && !CocatHicNevreData.equals("")){
			masMedicalBoardProceedings.setDataOfNurveHic(CocatHicNevreData);
			}
			if(req.getParameter("dentalValue") != null && !req.getParameter("dentalValue").equals("")){
				masMedicalBoardProceedings.setDentalValue(req.getParameter("dentalValue"));
			}
			int visitNumberForReport=0;
			if(req.getParameter("visitNumberForReport") != null && !req.getParameter("visitNumberForReport").equals("")){
				visitNumberForReport=Integer.parseInt(req.getParameter("visitNumberForReport"));
			}
			String hinNoForreport=null;
			if(req.getParameter("hinNoForreport") != null && !req.getParameter("hinNoForreport").equals("")){
				hinNoForreport=req.getParameter("hinNoForreport");
			}
			if(req.getParameter(PAST_MEDICAL_CATEGORY) != null && !(req.getParameter(PAST_MEDICAL_CATEGORY)).equals("0")){
				Category categ1 = new Category();
				//String categ1 ="";
				//categ1= req.getParameter(PAST_MEDICAL_CATEGORY);
				categ1.setCategoryid(Integer.parseInt(req.getParameter(PAST_MEDICAL_CATEGORY)));
				masMedicalBoardProceedings.setPastMedicalCategory(categ1);
				//masMedicalBoardProceedings.setMedicalCategory(categ1);
			}
			if(req.getParameter(PRESENT_MEDICAL_CATEGORY) != null && !(req.getParameter(PRESENT_MEDICAL_CATEGORY)).equals("0")){
				Category categ2 = new Category();
				categ2.setCategoryid(Integer.parseInt(req.getParameter(PRESENT_MEDICAL_CATEGORY)));
				masMedicalBoardProceedings.setPresentMedicalCategory(categ2);
			}
			/**
			 * Added By Ritu
			 */
			if(req.getParameter("sd") != null && !req.getParameter("sd").equals("")){
				masMedicalBoardProceedings.setSD(req.getParameter("sd"));
			}
			/**
			 * End
			 */
			
			String medicaltype=masMedicalBoardProceedings.getMedicalExamType();
					MasMedicalExaminationDetail medicaldetail=new MasMedicalExaminationDetail();
				int temp1 = 1;
				List<Integer> serialnolist = new ArrayList<Integer>();
				List<String> fromlist = new ArrayList<String>();
				List<String> tolist = new ArrayList<String>();
				List<String> placelist = new ArrayList<String>();
				List<String> pnolist = new ArrayList<String>();
				List<Integer> serialnolist1 = new ArrayList<Integer>();
				List<String> illnessIcdlist = new ArrayList<String>();
				List<Date> particulardatelist = new ArrayList<Date>();
				//List<Integer> rankidlist = new ArrayList<Integer>();
				List<String> treatedlist = new ArrayList<String>();
				List<String> approximatedatelist = new ArrayList<String>();
				List<String> approximatedatelist1 = new ArrayList<String>();
				List<String> placelist1 = new ArrayList<String>();
				List<String> principallist = new ArrayList<String>();
				List<Date> origindatelist = new ArrayList<Date>();
				List<Date> medicalcatdatelist = new ArrayList<Date>();
				List<Date> nextcatdatelist = new ArrayList<Date>();
				
				int hdbvalue1 = 1;
				int hiddenValue1 = 1;
				int hdbvalue = 1;
				if(medicaltype.equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
				{
					if(req.getParameter("hdb") != null)
					{
						if (Integer.parseInt(req.getParameter("hdb")) != 1) {
							hdbvalue = Integer.parseInt(req.getParameter("hdb"));
						}
					}
					
					int k=0;
					for (int i = 1; i <=hdbvalue; i++) {
							
						if(req.getParameter(SIRIAL_NO+ i) == "" ){
							   serialnolist.add(i);
							}else if(req.getParameter(SIRIAL_NO+ i) != null ){
							serialnolist.add(Integer.parseInt(req.getParameter(SIRIAL_NO+ i)));
						}
						
						if(req.getParameter(FROM+ i) != null && !req.getParameter(FROM+ i).equals("") ){
							fromlist.add(req.getParameter(FROM+ i));
						}
						
						if(req.getParameter(TO+ i) != null && !req.getParameter(TO+ i).equals("") ){
							tolist.add(req.getParameter(TO+ i));
						}
						if(req.getParameter(PLACE+ i) != null ){
							placelist.add(req.getParameter(PLACE+ i));
						}
						if(req.getParameter(P_NO+ i) != null ){
							pnolist.add(req.getParameter(P_NO+ i));
						}
				//-----------------commented by anamika-----------
						/*
						if(req.getParameter(PRINCIPAL+ i) != null ){
							principallist.add(req.getParameter(PRINCIPAL+ i));
						}*/
						if(req.getParameter(ORIGIN_DATE+ i) != null &&(!req.getParameter(ORIGIN_DATE+ i).equals(""))){
							origindatelist.add(HMSUtil.convertStringTypeDateToDateType(req.getParameter(ORIGIN_DATE+ i)));
						}
						if(req.getParameter(MEDICAL_CAT_DATE+ i) != null &&(!req.getParameter(MEDICAL_CAT_DATE+ i).equals(""))){
							medicalcatdatelist.add(HMSUtil.convertStringTypeDateToDateType(req.getParameter(MEDICAL_CAT_DATE+ i)));
						}
						if(req.getParameter(NEXT_CAT_DATE+ i) != null &&(!req.getParameter(NEXT_CAT_DATE+ i).equals(""))){
							nextcatdatelist.add(HMSUtil.convertStringTypeDateToDateType(req.getParameter(NEXT_CAT_DATE+ i)));
						}					
						
						}
					mapForDS.put("alcohol",alcohol);
					mapForDS.put("hdbvalue", hdbvalue);
					mapForDS.put("hiddenValue", hiddenValue);
					mapForDS.put("serialnolist", serialnolist);
					mapForDS.put("fromlist", fromlist);
					mapForDS.put("tolist", tolist);
					mapForDS.put("placelist", placelist);
					mapForDS.put("pnolist", pnolist);
					//mapForDS.put("principallist", principallist);
					mapForDS.put("origindatelist", origindatelist);
					mapForDS.put("medicalcatdatelist", medicalcatdatelist);
					mapForDS.put("nextcatdatelist", nextcatdatelist);

					if (req.getParameter("hdb1") != null) {
						if (Integer.parseInt(req.getParameter("hdb1")) != 1) {
							hdbvalue1 = Integer.parseInt(req.getParameter("hdb1"));
						}
					}
				
				/*    Code by  sk yadav            */
				for (int i = 1; i <= hdbvalue1; i++) {
					if (req.getParameter(PRINCIPAL+i) != null && !req.getParameter(PRINCIPAL+i).equals("")) {
						String icdNameWithId = req.getParameter(PRINCIPAL+i);
						int index1 = icdNameWithId.lastIndexOf("[");
						int index2 = icdNameWithId.lastIndexOf("]");
						index1++;
						String icdId = icdNameWithId.substring(index1,
								index2);
						if (!icdId.equals("")) {
							//chargeCodeIdArr[i] = icdId;
							illnessIcdlist.add(icdId);

							if(req.getParameter(SIRIAL_NO1+ i) == "" ){
								serialnolist1.add(i);
							}else if(req.getParameter(SIRIAL_NO1+ i) != null ){
								serialnolist1.add(Integer.parseInt(req.getParameter(SIRIAL_NO1+ i)));
							}

							/*if(req.getParameter(ILLNESS+ i) != null ){
											illnesslist.add(req.getParameter(ILLNESS+ i));
										}*/

							if(req.getParameter(PARTICULAR_DATE+ i) != null ){
								particulardatelist.add(HMSUtil.convertStringTypeDateToDateType(req.getParameter(PARTICULAR_DATE+ i)));
							}
							/*if(req.getParameter(RANK_INDIVIDUAL_ID+ i) != null ){
											rankidlist.add(Integer.parseInt(req.getParameter(RANK_INDIVIDUAL_ID+ i)));
										}*/
							if(req.getParameter(TREATED+ i) != null ){
								treatedlist.add(req.getParameter(TREATED+ i));
							}
							if(req.getParameter(PLACE1+ i) != null ){
								placelist1.add(req.getParameter(PLACE1+ i));
							}
							if(req.getParameter(APPROXIMATE_DATE+ i) != null ){
								approximatedatelist.add(req.getParameter(APPROXIMATE_DATE+ i));
							}
							if(req.getParameter(APPROXIMATE_DATE2+ i) != null ){
								approximatedatelist1.add(req.getParameter(APPROXIMATE_DATE2+ i));
							}
							//	temp2=temp2+1;
						}
					}
				}
			//----------------grid for Before joining-the armed forces--------------------
				List<Integer> srNoList = new ArrayList<Integer>();
				List<String> icdIdList = new ArrayList<String>();
				List<String> pDateList = new ArrayList<String>();
				List<String> particularPlaceList = new ArrayList<String>();
				List<String> whereTreatedList = new ArrayList<String>();
				List<String> beforeDisabilityBeforeList = new ArrayList<String>();
				
				
				int hdbBefore = 1;
				 if(req.getParameter("hdbBefore") != null)
				 {
					 if (Integer.parseInt(req.getParameter("hdbBefore")) != 0) {
							hdbBefore = Integer.parseInt(req.getParameter("hdbBefore"));
						}
				 }
				
				for (int i = 1; i <=hdbBefore; i++) {
					if (req.getParameter(ICD_ID+i) != null && !req.getParameter(ICD_ID+i).equals("")) {
						String icdNameWithId = req.getParameter(ICD_ID+i);
						int index1 = icdNameWithId.lastIndexOf("[");
						int index2 = icdNameWithId.lastIndexOf("]");
						index1++;
						String icdId = icdNameWithId.substring(index1,
								index2);
						if (!icdId.equals("")) {
							//chargeCodeIdArr[i] = icdId;
							icdIdList.add(icdId);
					if(req.getParameter(SR_NO+ i) == "" ){
						srNoList.add(i);
						}else if(req.getParameter(SR_NO+ i) != null ){
							srNoList.add(Integer.parseInt(req.getParameter(SR_NO+ i)));
					}
					
					if(req.getParameter("pDate"+ i) != null ){
						pDateList.add(req.getParameter("pDate"+ i));
										}
					if(req.getParameter("whereTreated"+ i) != null ){
						whereTreatedList.add(req.getParameter("whereTreated"+ i));
										}
					if(req.getParameter("particularPlace"+ i) != null ){
						particularPlaceList.add(req.getParameter("particularPlace"+ i));
					}
					if(req.getParameter("beforeDisability11"+i) != null ){
						beforeDisabilityBeforeList.add(req.getParameter("beforeDisability11"+i));
					}else{
						beforeDisabilityBeforeList.add("n");
					}
				
				}
			  }
			}
				mapForDS.put("hdbBefore", hdbBefore);
				mapForDS.put("srNoList", srNoList);
				mapForDS.put("icdIdList", icdIdList);
				mapForDS.put("pDateList", pDateList);
				mapForDS.put("particularPlaceList", particularPlaceList);
				mapForDS.put("whereTreatedList", whereTreatedList);
				mapForDS.put("beforeDisabilityBeforeList", beforeDisabilityBeforeList);
				mapForDS.put("hdbvalue1", hdbvalue1);
				mapForDS.put("hiddenValue1", hiddenValue1);
				mapForDS.put("serialnolist1", serialnolist1);
				mapForDS.put("illnessIcdlist", illnessIcdlist);
				mapForDS.put("particulardatelist", particulardatelist);
				//mapForDS.put("rankidlist", rankidlist);
				mapForDS.put("treatedlist", treatedlist);
				mapForDS.put("approximatedatelist", approximatedatelist);
				mapForDS.put("approximatedatelist1", approximatedatelist1);
				mapForDS.put("placelist1", placelist1);		
				}

			
			
			Users maUser = new Users();
			maUser.setId(userId);
			masMedicalBoardProceedings.setMaUser(maUser);
			
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			masMedicalBoardProceedings.setHospital(hospital);
			
			MasCommand command = new MasCommand();
			command.setId(commandId);
			masMedicalBoardProceedings.setCommand(command);		

			masMedicalBoardProceedings.setStatus("p");
			masMedicalBoardProceedings.setMedicalType("MedicalExam");
			mapForDS.put("chargeCodeIdList", chargeCodeIdList);
			mapForDS.put("quantityList", quantityList);
			mapForDS.put("clinicalNotes1", clinicalNotes1);
			mapForDS.put("lastChangedBy", lastChangedBy);
			mapForDS.put("lastChangedDate", lastChangedDate);
			mapForDS.put("lastChangedTime", lastChangedTime);
			mapForDS.put("investigationReferToMHList", investigationReferToMHList);
			mapForDS.put("allergies", allergies);
			mapForDS.put("hospitalId", hospitalId);
			mapForDS.put("deptId", deptId);
			mapForDS.put("empId", empId);
			mapForDS.put("hinId", hinId);
			mapForDS.put("visitId", visitId);
			mapForDS.put("medicalOfficer", medicalOfficer);
			mapForDS.put("departmentId", departmentId);
			mapForDS.put("patientInvestigationHeaderId", 0);
			mapForDS.put("dgOrderhdId", 0);
			mapForDS.put("patientInvestigationdetailsIdList", patientInvestigationdetailsIdList);
			mapForDS.put("dgOrderdtIdList", dgOrderdtIdList);
			mapForDS.put("identification1", identification1);
			mapForDS.put("identification2", identification2);
			String orderSeqNo = "";
			orderSeqNo=labHandlerService.generateOrderNumber(hospitalId);
			mapForDS.put("orderSeqNo",orderSeqNo);
			
			try {
				Visit visit = new Visit();

				visit.setTokenNo(0);
				if (hinId != 0) {
					Patient patient = new Patient();
					patient.setId(hinId);
					visit.setHin(patient);
				}
				if (hospitalId != 0) {
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					visit.setHospital(masHospital);
				}
				if (deptId != 0) {
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(deptId);
					visit.setDepartment(masDepartment);
				}
				if (empId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(empId);
					visit.setDoctor(masEmployee);
				}
				String ageId = "";
				if (req.getParameter("ageId") != null) {
					ageId = req.getParameter("ageId");
				}
				visit.setAge(ageId);
				visit.setAddEditBy(user);
				visit.setAddEditDate(lastChangedDate);
				visit.setAddEditTime(lastChangedTime);
				visit.setVisitDate(lastChangedDate);
				visit.setVisitTime(lastChangedTime);
				visit.setVisitStatus("w");
				visit.setReportingFor("Dental");
				visit.setAppointmentType("D");
			   	visit.setPriority(3);
				visit.setStatus("y");
				if(req.getParameter("medicalExamType").equals("Annual Medical Exam(AFMSF-3B)") 
						|| req.getParameter("medicalExamType").equals("Prior To Proceedings Abroad Med. Exam(AFMSF-3B)")
						|| req.getParameter("medicalExamType").equals("High Altitude Med. Exam(AFMSF-3B)")){
					visit.setDentalFlag("MedExam3B");
				}
				else if(req.getParameter("medicalExamType").equals("Med. Exam On Release/Discharge(AFMSF-18)")){
					visit.setDentalFlag("MedExam18");
				}
				
				mapForDS.put("visit", visit);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
			map = medicalExamHandlerService
					.addMedicalExaminationBoardAnnual(masMedicalBoardProceedings,masMedicalBoardDetails,mapForDS);
			if(map.get("successfullyAdded") !=null){
				successfullyAdded=(Boolean)map.get("successfullyAdded");
			}
			message = "Record Added Successfully!";
			jsp = MEDICAL_BOARD_EXAM_MSG;
			if (!successfullyAdded) {
				message = "Some Problem Occured !!!";
				jsp = MEDICAL_BOARD_ERROR_MSG;
			}
		//}
		try {
		//	map = medicalExaminationBoardHandlerService.showMedicalExaminationBoardJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String medicalEntryNo = "";
		String medicalEntryNo1 = "";
		String userName = "";
		String userName1 = "";
	//	medicalEntryNo = medicalExaminationBoardHandlerService.generateMedicalEntryNumber(userName);
	//	medicalEntryNo1 = medicalExaminationBoardHandlerService.generateMedicalEntryNumber1(userName1);
		jsp += ".jsp";
		map.put("medicalEntryNo", medicalEntryNo);
		map.put("medicalEntryNo1", medicalEntryNo1);
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("hinNoForreport", hinNoForreport);
		map.put("visitNumberForReport", visitNumberForReport);
		map.put("serviceNo", serviceNo);
		map.put("visitId",visitId);
		map.put("denatlToMH", denatlToMH);
		map.put("investigationReferToMHList",investigationReferToMHList);
		return new ModelAndView("indexB", "map", map);
	
	}
//-------------------- End addMedicalExam Method -----------------------------
	public ModelAndView showMedicalOfficerAppointment(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{	
		  hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		  mapForDS.put("hospitalId", hospitalId);
		}
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
		map = medicalExamHandlerService.showMedicalOfficerAppointment(mapForDS);
		jsp = "mb_medicalBoardSearchMedicalOfficerAppointment";
		
		jsp += ".jsp";
		title = "Medical Board Proceeding Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView searchMedicalExamMedicalOfficer(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String patientFName = "";
		String orderStatus = "";
		String serviceNo = "";
		int rankId=0;
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		mapForDs.put("hospitalId", hospitalId);
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals(""))) {
			rankId = Integer.parseInt(request
					.getParameter(RANK_ID));
			mapForDs.put("rankId", rankId);
		}

		if (request.getParameter(TO_DATE) != null
						&& !(request.getParameter(TO_DATE).equals(""))) {
					toDate = HMSUtil.dateFormatterDDMMYYYY(request
							.getParameter(TO_DATE));
					mapForDs.put("toDate", toDate);
				}
		if (request.getParameter(SERVICE_NO) != null
						&& !(request.getParameter(SERVICE_NO).equals(""))) {
					serviceNo = request.getParameter(SERVICE_NO);
					mapForDs.put("serviceNo", serviceNo);
				}
		
		if (request.getParameter(P_FIRST_NAME) != null
						&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
					patientFName = request.getParameter(P_FIRST_NAME);
					mapForDs.put("patientFName", patientFName);
		}


		map = medicalExamHandlerService.searchMedicalExamMedicalOfficer(mapForDs);
		jsp = "mb_medicalExamSearchData";
		
		jsp += ".jsp";
		title = "Medical Board Proceeding Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showMedicalOfficerMedExamJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
        int visitId=0;
        
        String jspheading=null;
        String search="false";
        if (request.getParameter("medExamType") != null)
        {		jspheading = request.getParameter("medExamType");
        }
        if (request.getParameter("search") != null)
        {     	search = request.getParameter("search");
		}
       
		if (request.getParameter("visitId") != null && request.getParameter("visitId") != "" ) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		int empId = (Integer) session.getAttribute("empId");
		box.put("empId", empId);
		box.put("deptId", deptId);
		box.put("visitId", visitId);
		box.put("search", search);
		map = medicalExamHandlerService.showMedicalOfficerMedExamJsp(box);		
		if(search.equalsIgnoreCase("true"))
		{			jsp = "mb_medicalBoardExaminationOnAnnualMedicalOfficer";	
		}
		else
		{	jsp = "mb_medicalBoardExaminationOnAnnualMO";
		}
		
		jsp += ".jsp";
	
		map.put("visitId", visitId);
	    map.put("jspheading", jspheading);
	    map.put("search", search);
		map.put("contentJsp", jsp);
		map.put("deptId", deptId);
		// map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView showMOPrimaryMedExamJsp(HttpServletRequest request, HttpServletResponse response) 
	{
       Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		Box box = HMSUtil.getBox(request);
		String jspheading=null;
	    if (request.getParameter("medExamType") != null) 
	    {
	     jspheading = request.getParameter("medExamType");
	    }
	    HttpSession session = request.getSession();
	    int visitId=0;
	    if (request.getParameter("visitId") != null && request.getParameter("visitId") != "" ) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
	    int deptId = (Integer) session.getAttribute("deptId");
	    int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	    int empId = (Integer) session.getAttribute("empId");
	    box.put("empId", empId);
	    box.put("hospitalId", hospitalId);
	    box.put("deptId", deptId);
		map = medicalExamHandlerService.showMOPrimaryMedExamJsp(box);
		jsp = "mb_primaryExtMedExamMO";
		jsp += ".jsp";
		map.put("visitId", visitId);
		map.put("jspheading", jspheading);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}
	@SuppressWarnings("unchecked")
	public ModelAndView showPrimaryMedExamAAJsp(HttpServletRequest request, HttpServletResponse response) 
	{
       Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		Box box = HMSUtil.getBox(request);
		String jspheading=null;
	    if (request.getParameter("medExamType") != null) 
	    {
	     jspheading = request.getParameter("medExamType");
	    }
	    HttpSession session = request.getSession();
	    int visitId=0;
	    if (request.getParameter("visitId") != null && request.getParameter("visitId") != "" ) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
	    int deptId = (Integer) session.getAttribute("deptId");
	    box.put("deptId", deptId);
	    int empId = (Integer) session.getAttribute("empId");
	    box.put("empId", empId);	

		map = medicalExamHandlerService.showMOPrimaryMedExamJsp(box);
		jsp = "mb_primaryExtMedExamAA";
		jsp += ".jsp";
		map.put("visitId", visitId);
		map.put("jspheading", jspheading);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}
	@SuppressWarnings("unchecked")
	public ModelAndView showPrimaryMedExamPAJsp(HttpServletRequest request, HttpServletResponse response) 
	{
       Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		Box box = HMSUtil.getBox(request);
		String jspheading=null;
	    if (request.getParameter("medExamType") != null) 
	    {
	     jspheading = request.getParameter("medExamType");
	    }
	    HttpSession session = request.getSession();
	    int visitId=0;
	    if (request.getParameter("visitId") != null && request.getParameter("visitId") != "" ) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
	    int deptId = (Integer) session.getAttribute("deptId");
	    box.put("deptId", deptId);
	    int empId = (Integer) session.getAttribute("empId");
	    box.put("empId", empId);	
		map = medicalExamHandlerService.showMOPrimaryMedExamJsp(box);
		jsp = "mb_primaryExtMedExamPA";
		jsp += ".jsp";
		map.put("visitId", visitId);
		map.put("jspheading", jspheading);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView updateMedicalExamEntry(HttpServletRequest req,
			HttpServletResponse res) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String serviceNo = "";		
		String data=null;
		String serviceiaf = "";
		String age = "";
		String typeOfCommunication = "";
		Date dateofcommun = null;
		String totalservice = "";
		String pastmedicalhistory = "";
		String presentmedicalhistory = "";
		String idealweight = "";
		String overweight = "";
		String waist = "";
		String chestfullexpansion = "";
		String bhi = "";
		String rangeofexpansion = "";
		String bodyfat = "";
		String signfoldthickness = "";
		String sportman = "";
		String actualweight="";
		String lastame = "";
		
		Date entryDate = null;
		Date medicinExamDate = null;
		String lastChangedBy = "";
		String lastChangedTime = "";
		Date lastChangedDate = null;
		Date surgeyDate = null;
		int typeOfEntry = 0;
		String betchNo = "";
		String chestNo = "";
		String rollNo = "";
		int medicalExamHeld = 0;
		String medicalStatus = "";
		String fullName = "";
		Date dateOfBirth = null;
		int maritialStatus = 0;
		String service = "";
		String pNo = "";
	//	String rank = "";
		String hoursOfFlown = "";
		String permanentAddress = "";
		String identification1 = "";
		String identification2 = "";
		String armsCrops = "";
		Date dateOfReporting = null;
		Date dateOfCompletion = null;
		Date documentForwardDate = null;
		String documentForwardTo = "";
		String fromWhereHeReport = "";
		String hypertension = "";
		String heartDisease = "";
		String diabetes = "";
		String bleedingDisorder = "";
		String mentalDisease = "";
		String nightBlindness = "";

		String asthama = "";
		String dischargeFrom = "";
		String plesury = "";
		String earDieses = "";
		String rheumatism = "";
		String frequentCough = "";
		String chronicIndigestion = "";
		String nervousBrakdown = "";
		String kidenyBladder = "";
		String fitsFaintinngAttacks = "";
		String std = "";
		String serveHeadInjury = "";
		String joundice = "";
		String sickness = "";
		String breastDisease = "";
		String trachoma = "";
		String amenorrhoea = "";
		String nightbindness = "";
		String menirrhagia = "";
		String laserTeartement = "";
		String pregnancy = "";
		String abortion = "";
		String eyeDisease = "";
		String rejectedAsUnfit = "";
		String dischargeMedicallyUnfit = "";
		String adimmitedInHospitalFirIllness = "";
		String stateNature = "";
		String otherInform = "";
		BigDecimal height = new BigDecimal(0);
		BigDecimal weight = new BigDecimal(0);
		BigDecimal acceptableKg = new BigDecimal(0);
		BigDecimal leglength = new BigDecimal(0);
		String appereance = "";
		String albumin = "";
		String sugar = "";
		String spGraviry = "";
		String hbPercentage = "";
		String physique = "";
		String anyOtherInv = "";
		String skin = "";
		String abdomen = "";
		String heartSize = "";
		String sound = "";
		String rhythm = "";
		String arterialWalls = "";
		String pulseRates = "";
		String bp = "";
		String fullExpension = "";
		String rangeOfExpension = "";
		String selfBalR = "";
		String selfBalL = "";
		String speechMental = "";
		String endocrinCond = "";
		String otherAbnormalities = "";
		String medicinRemarks = "";
		String finger = "";
		String hand = "";
		String wrist = "";
		String elbows = "";
		String shoulderGridles = "";
		String cercival = "";
		String dorsalVertebrate = "";
		String hullux = "";
		String valgus = "";
		String riggus = "";
		String flatFeet = "";
		String joints = "";
		String pelvis = "";
		String gail = "";
		String lumberScaler = "";
		String roccyxVericose = "";
		String hydrocele = "";
		String varicocele = "";
		String underScende = "";
		String hemonhoids = "";
		String herinaMusic = "";
		String breasts = "";
		String surgeryRemarks = "";
		String respatorySystem = "";

		String withGlassesDistantR = "";
		String withglassesDistantL = "";
		String withGlassesNearR = "";
		String withGlassesNearL = "";
		String withGlassesNearCP = "";
		String withoutGlassesDistantR = "";
		String withoutGlassesDistantL = "";
		String withoutGlassesNearR = "";
		String withoutGlassesNearL = "";
		String withoutGlassesNearCP = "";
		BigDecimal convergenceCP = new BigDecimal(0);

		BigDecimal convergenceC = new BigDecimal(0);
		String accommodationR = "";
		String accommodationL = "";
		String eyeRemarks = "";
		Date eyeDate = null;
		BigDecimal hearingRFW = new BigDecimal(0);
		BigDecimal hearingLFW = new BigDecimal(0);
		BigDecimal hearingBothFW = new BigDecimal(0);
		BigDecimal hearingRCV = new BigDecimal(0);
		BigDecimal hearingLCV = new BigDecimal(0);
		BigDecimal hearingBothCV = new BigDecimal(0);
       
		String innerEarR = "";
		String innerEarL = "";
		String audiometryRecord = "";
		String nose = "";
		String throatEar = "";
		String earReamrks = "";
		Date earDate = null;
		String externalEarR = "";
		String externalEarL = "";
		String middleEarR = "";
		String middleEarL = "";
		String evidienceOfTrachoma = "";
		String binocular = "";
		String manifestHypermetropia = "";
		String coverTest = "";
		String diaphragmTest = "";
		String fundMedia = "";
		String fields = "";
		String nightVisualCapacity = "";

		String dentalRemarks = "";
		Date dentalDate = null;
		String menstrualHistory = "";
		int noOfPregnancy = 0;
		int noOfAbortion = 0;
		int noOfChildren = 0;
		Date lastCondinement = null;
		String vaginalDischarge = "";
		String prolapse = "";
		String usgAbortion = "";
		String gyanaecologyRemarks = "";
		Date gyanaecologyDate = null;
		String medicalBoardExamination = "";
		int medicalBoardExaminationPlace = 0;
		Date medicalBoardExaminationDate = new Date();
		String subsequentMedicalBoardExam = "";
		int subsequentMedicalBoardExamPlace = 0;
		Date subsequentMedicalBoardExamDate = null;
		String ApprovingAuthority = "";
		int ApprovingAuthorityPlace = 0;
		Date ApprovingAuthorityDate = null;
		Date lmp = null;
		String totalTeeth = "";
		String totalDefectiveTeeth = "";
		String missingTeeth = "";
		String DenstalPoint = "";
		String unserviceableTeeth = "";
		List<String> investigationReferToMHList=new ArrayList<String>();
		String dur8 = "";
		String dur7 = "";
		String dur6 = "";
		String dur5 = "";
		String dur4 = "";
		String dur3 = "";
		String dur2 = "";
		String dur1 = "";
		String dul8 = "";
		String dul7 = "";
		String dul6 = "";
		String dul5 = "";
		String dul4 = "";
		String dul3 = "";
		String dul2 = "";
		String dul1 = "";
		String dlr8 = "";
		String dlr7 = "";
		String dlr6 = "";
		String dlr5 = "";
		String dlr4 = "";
		String dlr3 = "";
		String dlr2 = "";
		String dlr1 = "";
		String dll8 = "";
		String dll7 = "";
		String dll6 = "";
		String dll5 = "";
		String dll4 = "";
		String dll3 = "";
		String dll2 = "";
		String dll1 = "";
		String mur8 = "";
		String mur7 = "";
		String mur6 = "";
		String mur5 = "";
		String mur4 = "";
		String mur3 = "";
		String mur2 = "";
		String mur1 = "";
		String mul8 = "";
		String mul7 = "";
		String mul6 = "";
		String mul5 = "";
		String mul4 = "";
		String mul3 = "";
		String mul2 = "";
		String mul1 = "";
		String mlr8 = "";
		String mlr7 = "";
		String mlr6 = "";
		String mlr5 = "";
		String mlr4 = "";
		String mlr3 = "";
		String mlr2 = "";
		String mlr1 = "";
		String mll8 = "";
		String mll7 = "";
		String mll6 = "";
		String mll5 = "";
		String mll4 = "";
		String mll3 = "";
		String mll2 = "";
		String mll1 = "";
		String uur8 = "";
		String uur7 = "";
		String uur6 = "";
		String uur5 = "";
		String uur4 = "";
		String uur3 = "";
		String uur2 = "";
		String uur1 = "";
		String uul8 = "";
		String uul7 = "";
		String uul6 = "";
		String uul5 = "";
		String uul4 = "";
		String uul3 = "";
		String uul2 = "";
		String uul1 = "";
		String ulr8 = "";
		String ulr7 = "";
		String ulr6 = "";
		String ulr5 = "";
		String ulr4 = "";
		String ulr3 = "";
		String ulr2 = "";
		String ulr1 = "";
		String ull8 = "";
		String ull7 = "";
		String ull6 = "";
		String ull5 = "";
		String ull4 = "";
		String ull3 = "";
		String ull2 = "";
		String ull1 = "";

		String sur8 = "";
		String sur7 = "";
		String sur6 = "";
		String sur5 = "";
		String sur4 = "";
		String sur3 = "";
		String sur2 = "";
		String sur1 = "";
		String sul8 = "";
		String sul7 = "";
		String sul6 = "";
		String sul5 = "";
		String sul4 = "";
		String sul3 = "";
		String sul2 = "";
		String sul1 = "";

		String slr8 = "";
		String slr7 = "";
		String slr6 = "";
		String slr5 = "";
		String slr4 = "";
		String slr3 = "";
		String slr2 = "";
		String slr1 = "";
		String sll8 = "";
		String sll7 = "";
		String sll6 = "";

		String sll5 = "";
		String sll4 = "";
		String sll3 = "";
		String sll2 = "";
		String sll1 = "";
		
		String DentalOfficer="";
		Date  dentalcheckupdate = null;
		HttpSession session = req.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		int userId = 0;
		Users user = (Users)session.getAttribute("users");
		userId = user.getId();
		
		int commandId = (Integer) session.getAttribute("commandId");
		
		Map<String, Object> map = new HashMap<String, Object>();
//		Box box = HMSUtil.getBox(req);
		int medExamId = 0;
		String message = "";
		String jsp = "";
		int visitId=0;	
		String investigationReferToMH = "";
	
	//	if(req.getParameter("medExamId")) != null && !(req.getParameter("medExamId")).equals("0") )){
			
			if(req.getParameter("medExamId")!=null && !req.getParameter("medExamId").equals("0")){
				if(req.getParameter("medExamId")!=null && !req.getParameter("medExamId").equals("0")){
					medExamId =  Integer.parseInt(req.getParameter("medExamId"));}
			if (req.getParameter("investigationReferToMH" ) != null && !req.getParameter("investigationReferToMH<%=inc %>" ).equals(""))
			{
				investigationReferToMH = req.getParameter("investigationReferToMH" );
			}
				
		MasMedicalExaminationReportOnEntry masMedicalBoardProceedings = new MasMedicalExaminationReportOnEntry();
		masMedicalBoardProceedings = medicalExamHandlerService.loadMedicalExamObj(medExamId);
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List<MasMedicalBoardExaminationDetail> masMedicalBoardDetails = new ArrayList<MasMedicalBoardExaminationDetail>();

		if (req.getParameter("DentalOfficer") != null) {
			DentalOfficer= req.getParameter("DentalOfficer");
			
		}
		//System.out.println("dentaldateupdate="+req.getParameter("dentalcheckupdate"));
		if (req.getParameter("dentalcheckupdate") != null
				&& !(req.getParameter("dentalcheckupdate").equals(""))) {
			dentalcheckupdate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter("dentalcheckupdate"));
		}
		
		
		if (req.getParameter(SERVICE_NO) != null) {
			serviceNo = req.getParameter(SERVICE_NO);
		}
		
		if (req.getParameter(AGE) != null ) {
			age = req.getParameter(AGE);
		}
		if (req.getParameter(TOTAL_SERVICE) != null ) {
			totalservice = req.getParameter(TOTAL_SERVICE);
		}
		if (req.getParameter("serviceiaf") != null ) {
			serviceiaf = req.getParameter("serviceiaf");
		}		
		if (req.getParameter("typeOfCommunication") != null ) {
			typeOfCommunication = req.getParameter("typeOfCommunication");
		}if (req.getParameter(DATE_COMMENCEMENT) != null && !req.getParameter(DATE_COMMENCEMENT).equals(""))
		{
			dateofcommun =HMSUtil.dateFormatterDDMMYYYY(req.getParameter(DATE_COMMENCEMENT));
		}
		if (req.getParameter(PAST_MEDICAL_HISTORY) != null ) {
			pastmedicalhistory  = req.getParameter(PAST_MEDICAL_HISTORY);
		}if (req.getParameter(PRESENT_MEDICAL_CATEGORY) != null && !req.getParameter(PRESENT_MEDICAL_CATEGORY).equals("0"))
		{
			Category category = new Category();
			category.setCategoryid(Integer.parseInt(req.getParameter(PRESENT_MEDICAL_CATEGORY)));
			masMedicalBoardProceedings.setPresentMedicalCategory(category)	;
			
		}if (req.getParameter(LAST_AME) != null ) {
			lastame = req.getParameter(LAST_AME);
		}
		/*if (req.getParameter(HEIGHT_WITHOUT_SHOOSE) != null ) {
			height = req.getParameter(HEIGHT_WITHOUT_SHOOSE);
		}*/
		if (req.getParameter(ACTUAL_WEIGHT) != null ) {
			actualweight = req.getParameter(ACTUAL_WEIGHT);
		}if (req.getParameter(IDEAL_WEIGHT) != null ) {
			idealweight  = req.getParameter(IDEAL_WEIGHT);
		}if (req.getParameter(OVER_WEIGHT) != null ) {
			overweight  = req.getParameter(OVER_WEIGHT);
		}if (req.getParameter(WAIST) != null ) {
			waist = req.getParameter(WAIST);
		}if (req.getParameter(CHEST_FULL) != null ) {
			chestfullexpansion  = req.getParameter(CHEST_FULL);
		}if (req.getParameter(RANGE_EXPANSION) != null ) {
			rangeofexpansion  = req.getParameter(RANGE_EXPANSION);
		}if (req.getParameter(BHI) != null ) {
			bhi = req.getParameter(BHI);
		}if (req.getParameter(BODY_FAT) != null ) {
			bodyfat  = req.getParameter(BODY_FAT);
		}if (req.getParameter(THICKNESS) != null ) {
			signfoldthickness  = req.getParameter(THICKNESS);
		}if (req.getParameter(SPORTS) != null ) {
			sportman  = req.getParameter(SPORTS);
		}
		int deptId=0;
		int empId=0;
		int hinId=0;
		
		if (req.getParameter("deptId") != null ) {
			deptId  = Integer.parseInt(req.getParameter("deptId"));
		}
		if (req.getParameter("empId") != null ) {
			empId  = Integer.parseInt(req.getParameter("empId"));
		}
		if (req.getParameter("hinId") != null ) {
			hinId  = Integer.parseInt(req.getParameter("hinId"));
		}
		if (req.getParameter("visitId") != null ) {
			visitId  = Integer.parseInt(req.getParameter("visitId"));
		}
		List<String> chargeCodeIdList = new ArrayList<String>();
		List<Integer> quantityList = new ArrayList<Integer>();
		List<Integer> dgOrderdtIdList = new ArrayList<Integer>();
		
		List<String> investResultList=new ArrayList<String>();
		List<Integer> patientInvestigationdetailsIdList = new ArrayList<Integer>();
		int patientInvestigationHeaderId=0;                                                             
		if(req.getParameter("patientInvestigationHeaderId") != null && !req.getParameter("patientInvestigationHeaderId").equals(""))
		{
			patientInvestigationHeaderId=Integer.parseInt(req.getParameter("patientInvestigationHeaderId"));
		}
		int dgOrderhdId=0;		
		if(req.getParameter("dgOrderhdId") != null && !req.getParameter("dgOrderhdId").equals(""))
		{ dgOrderhdId=Integer.parseInt(req.getParameter("dgOrderhdId"));
		}
		String clinicalNotes1="";
				if (req.getParameter("clinicalNotes1") != null
						&& !(req.getParameter("clinicalNotes1").equals(""))) {
					clinicalNotes1 = req.getParameter("clinicalNotes1");
				}
		int hiddenValue = 1;
		if(req.getParameter("data") != null && !req.getParameter("data").equals(""))
		{
			data=(String)req.getParameter("data");
		}
		if (req.getParameter("hiddenValue")!=null && Integer.parseInt(req.getParameter("hiddenValue")) != 1)
		{	hiddenValue = Integer.parseInt(req.getParameter("hiddenValue"));
		}
		System.out.println("hiddenValue="+hiddenValue);
		System.out.println("data="+hiddenValue);
		 String deleatedorderid = "";
			if (req.getParameter("deleatedorderid") != "")
			{ deleatedorderid = req.getParameter("deleatedorderid");
			}					 
			mapForDS.put("deleatedorderid",deleatedorderid);					
			String deleatedValue = "";
			if (req.getParameter("deleatedValue") !=null && req.getParameter("deleatedValue") != "")
			{ deleatedValue = req.getParameter("deleatedValue");					
			}
			mapForDS.put("deleatedValue",deleatedValue);
//----------------------------------------------------------------------------------------------------
				String dlc="",hb="",tlc="",esr="",spGravity="",albumen="",sugarR="";
				String sugarF="",sugarPP="",urea="",uricAcid="",srCreatine="",cholesterol="";
				String triglycerids="",hdl="",vldl="";
				int temp = 1;
				String[] chargeCodeIdArr = new String[hiddenValue];
				for (int i = 0; i < hiddenValue; i++) {
					if (req.getParameter("chargeCodeName" + temp) != null && !req.getParameter("chargeCodeName" + temp).equals(""))
					{       
						String chargeCodeNameWithId = req.getParameter("chargeCodeName" + temp);
						int index1 = chargeCodeNameWithId.lastIndexOf("[");
						int index2 = chargeCodeNameWithId.lastIndexOf("]");
						index1++;
						String chargeCodeName=chargeCodeNameWithId.substring(0,(index1-1));
						String chargeCodeId = chargeCodeNameWithId.substring(index1,index2);
						//patientInvestigationdetailsIdList
						if (!chargeCodeId.equals(""))
						 {
							chargeCodeIdArr[i] = chargeCodeId;
							int qty = 1;
							//if (req.getParameter("investigationReferToMH" + temp) != null && !req.getParameter("investigationReferToMH" + temp).equals(""))
							if (req.getParameter("investigationReferToMH" + temp) != null)
							{  
								investigationReferToMHList.add("y");
							}else
							{
								investigationReferToMHList.add("n");
							}
							if(data!=null)
							{
							   String resultVal="";
							   if (req.getParameter("Result" + temp) != null && !req.getParameter("Result" + temp).equals(""))
								{
								  investResultList.add(req.getParameter("Result" + temp));
								  resultVal=req.getParameter("Result" + temp);
								}else
								{
									investResultList.add(" ");
									resultVal=" ";	}
							 if(chargeCodeName.equalsIgnoreCase("dlc"))
							  {
								  dlc=resultVal;
							  }else if(chargeCodeName.equalsIgnoreCase("Hb"))
							  {
								  hb=resultVal;
							  }else if(chargeCodeName.equalsIgnoreCase("tlc"))
							  {
								  tlc=resultVal;
							  }else if(chargeCodeName.equalsIgnoreCase("esr"))
							  {
								  esr=resultVal;
							  }else if(chargeCodeName.equalsIgnoreCase("Gravity"))
							  {
								  spGravity=resultVal;
							  }else if(chargeCodeName.equalsIgnoreCase("ALBUMIN"))
							  {
								  albumen=resultVal;
							  }else if(chargeCodeName.equalsIgnoreCase("SUGAR R"))
							  {
								  sugarR=resultVal;
							  }else if(chargeCodeName.equalsIgnoreCase("SUGAR F"))
							  {
								  sugarF=resultVal;
							  }else if(chargeCodeName.equalsIgnoreCase("SUGAR PP"))
							  {
								  sugarPP=resultVal;
							  }else if(chargeCodeName.equalsIgnoreCase("Urea"))
							  {
								  urea=resultVal;
							  }else if(chargeCodeName.equalsIgnoreCase("URIC ACID"))
							  {
								  uricAcid=resultVal;
							  }else if(chargeCodeName.equalsIgnoreCase("CREATININE"))
							  {
								  srCreatine=resultVal;
							  }else if(chargeCodeName.equalsIgnoreCase("CHOLESTEROL"))
							  {
								  cholesterol=resultVal;
							  }else if(chargeCodeName.equalsIgnoreCase("TRIGLYCERIDE"))
							  {
								  triglycerids=resultVal;
							  }else if(chargeCodeName.equalsIgnoreCase("HDL"))
							  {
								  hdl=resultVal;
							  }else if(chargeCodeName.equalsIgnoreCase("VLDL"))
							  {
								  vldl=resultVal;
							  }
							}
							chargeCodeIdList.add(chargeCodeIdArr[i]);
							quantityList.add(qty);
							//clinicalList.add(clinicalNotes);
						}
					}
					/*if (req.getParameter("patientInvestigationdetailsId" + i) != null && !req.getParameter("patientInvestigationdetailsId" + i).equals(""))
					{
						patientInvestigationdetailsIdList.add(Integer.parseInt(req.getParameter("patientInvestigationdetailsId" + i)));
					}
					if (req.getParameter("dgOrderdtId" + i) != null && !req.getParameter("dgOrderdtId" + i).equals("")) 
					{
						dgOrderdtIdList.add(Integer.parseInt(req.getParameter("dgOrderdtId" + i)));
					}*/
					if (req.getParameter("patientInvestigationdetailsId" + temp) != null && !req.getParameter("patientInvestigationdetailsId" + temp).equals(""))
					{
						patientInvestigationdetailsIdList.add(Integer.parseInt(req.getParameter("patientInvestigationdetailsId" + temp)));
					}else{
						patientInvestigationdetailsIdList.add(new Integer(0));
					}
					if (req.getParameter("dgOrderdtId" + temp) != null && !req.getParameter("dgOrderdtId" + temp).equals("")) 
					{
						dgOrderdtIdList.add(Integer.parseInt(req.getParameter("dgOrderdtId" + temp)));
					}else{
						dgOrderdtIdList.add(new Integer(0));
					}
					temp++;

							
				}
		String alcohol="";
		if(req.getParameter("alcohol") != null && !req.getParameter("alcohol").equals("")){
			alcohol=req.getParameter("alcohol");
		}
				
		mapForDS.put("alcohol", alcohol);
		mapForDS.put("smokerLess10",req.getParameter("smokerLess10"));
		mapForDS.put("smokerMore10",req.getParameter("smokerMore10"));
//----------------------------------------------------------------------------------
			String[] familyHistoryArray = null;
			if (req.getParameterValues(FM_DM) != null
					&& !(req.getParameterValues(FM_DM).equals(""))) 
			{
				familyHistoryArray =(String[])req.getParameterValues(FM_DM);
			}
			String otherFamilyHistory="";
			if (req.getParameter("otherFamilyHistory") != null) {
				otherFamilyHistory=req.getParameter("otherFamilyHistory");
				mapForDS.put("otherFamilyHistory", otherFamilyHistory);
			}
//-------------------------------------------------------------------------------------
		if (req.getParameter(ENTRY_OF_DATE) != null
				&& !(req.getParameter(ENTRY_OF_DATE).equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(ENTRY_OF_DATE));
		}
		if (req.getParameter(TYPE_OF_ENTRY) != null
				&& !(req.getParameter(TYPE_OF_ENTRY).equals(""))) {
			typeOfEntry = Integer.parseInt(req.getParameter(TYPE_OF_ENTRY));
		}
		if (req.getParameter(BATCH1_NO) != null
				&& !(req.getParameter(BATCH1_NO).equals(""))) {
			betchNo = req.getParameter(BATCH1_NO);
		}
		if (req.getParameter(CHEST_NO) != null
				&& !(req.getParameter(CHEST_NO).equals(""))) {
			chestNo = req.getParameter(CHEST_NO);
		}

		if (req.getParameter(ROLL_NO) != null
				&& !(req.getParameter(ROLL_NO).equals(""))) {
			rollNo = req.getParameter(ROLL_NO);
		}

		if (req.getParameter(MEDICAL_EXAM_HELD_AT) != null) {
			medicalExamHeld = Integer.parseInt(req
					.getParameter(MEDICAL_EXAM_HELD_AT));
		}

		if (req.getParameter(MEDICAL_STATUS) != null
				&& !(req.getParameter(MEDICAL_STATUS).equals(""))) {
			medicalStatus = req.getParameter(MEDICAL_STATUS);
		}
		if (req.getParameter(FULL_NAME) != null
				&& !(req.getParameter(FULL_NAME).equals(""))) {
			fullName = req.getParameter(FULL_NAME);
		}

		if (req.getParameter(DATE_OF_BIRTH) != null
				&& !(req.getParameter(DATE_OF_BIRTH).equals(""))) {
			dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_BIRTH));
		}

		if (req.getParameter(MARITIAL_STATUS) != null
				&& !(req.getParameter(MARITIAL_STATUS).equals(""))) {
			maritialStatus = Integer
					.parseInt(req.getParameter(MARITIAL_STATUS));
		}

		if (req.getParameter(SERVICE) != null
				&& !(req.getParameter(SERVICE).equals(""))) {
			service = req.getParameter(SERVICE);
		}

		if (req.getParameter(P_NO) != null
				&& !(req.getParameter(P_NO).equals(""))) {
			pNo = req.getParameter(P_NO);
		}

		if (req.getParameter(HOURS_OF_FLOWN) != null
				&& !(req.getParameter(HOURS_OF_FLOWN).equals(""))) {
			hoursOfFlown = req.getParameter(HOURS_OF_FLOWN);
		}
		if (req.getParameter(PERMANENT_ADDRESS) != null
				&& !(req.getParameter(PERMANENT_ADDRESS).equals(""))) {
			permanentAddress = req.getParameter(PERMANENT_ADDRESS);
		}

		if (req.getParameter(IDENTIFICATION_MARKS1) != null
				&& !(req.getParameter(IDENTIFICATION_MARKS1).equals(""))) {
			identification1 = req.getParameter(IDENTIFICATION_MARKS1);
		}

		if (req.getParameter(IDENTIFICATION_MARKS2) != null
				&& !(req.getParameter(IDENTIFICATION_MARKS2).equals(""))) {
			identification2 = req.getParameter(IDENTIFICATION_MARKS2);
		}

		if (req.getParameter(ARMS_CROPS) != null
				&& !(req.getParameter(ARMS_CROPS).equals(""))) {
			armsCrops = req.getParameter(ARMS_CROPS);
		}

		if (req.getParameter(DATE_OF_COMPLETION) != null
				&& !(req.getParameter(DATE_OF_COMPLETION).equals(""))) {
			dateOfCompletion = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_COMPLETION));
		}

		if (req.getParameter(DOCUMENT_FORWARD_DATE1) != null
				&& !(req.getParameter(DOCUMENT_FORWARD_DATE1).equals(""))) {
			documentForwardDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DOCUMENT_FORWARD_DATE1));

		}

		if (req.getParameter(DOCUMENT_FORWARD_TO) != null
				&& !(req.getParameter(DOCUMENT_FORWARD_TO).equals(""))) {
			documentForwardTo = req.getParameter(DOCUMENT_FORWARD_TO);
		}
		/*if (req.getParameter(DATE_OF_REPORTING) != null
				&& !(req.getParameter(DATE_OF_REPORTING).equals(""))) {
			dateOfReporting = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_REPORTING));

		}*/

		if (req.getParameter(FROM_WHERE_HE_REPORT) != null
				&& !(req.getParameter(FROM_WHERE_HE_REPORT).equals(""))) {
			fromWhereHeReport = req.getParameter(FROM_WHERE_HE_REPORT);
		}
		if (req.getParameter(HYPERTENSION) != null
				&& !(req.getParameter(HYPERTENSION).equals(""))) {
			hypertension = req.getParameter(HYPERTENSION);
		}
		if (req.getParameter(HEAR_DISEASE) != null
				&& !(req.getParameter(HEAR_DISEASE).equals(""))) {
			heartDisease = req.getParameter(HEAR_DISEASE);
		}
		if (req.getParameter(DIABETES) != null
				&& !(req.getParameter(DIABETES).equals(""))) {
			diabetes = req.getParameter(DIABETES);
		}
		if (req.getParameter(BLEEDING_DIORDER) != null
				&& !(req.getParameter(BLEEDING_DIORDER).equals(""))) {
			bleedingDisorder = req.getParameter(BLEEDING_DIORDER);
		}
		if (req.getParameter(MENTAL_DISEASE) != null
				&& !(req.getParameter(MENTAL_DISEASE).equals(""))) {
			mentalDisease = req.getParameter(MENTAL_DISEASE);
		}
		if (req.getParameter(NIGHT_BLINDNESS) != null
				&& !(req.getParameter(NIGHT_BLINDNESS).equals(""))) {
			nightBlindness = req.getParameter(NIGHT_BLINDNESS);
		}

		if (req.getParameter(ASTHAMA) != null
				&& !(req.getParameter(ASTHAMA).equals(""))) {
			asthama = req.getParameter(ASTHAMA);
		}

		if (req.getParameter(DISCHARGE_FROM) != null
				&& !(req.getParameter(DISCHARGE_FROM).equals(""))) {
			dischargeFrom = req.getParameter(DISCHARGE_FROM);

		}

		if (req.getParameter(PLEURISY) != null
				&& !(req.getParameter(PLEURISY).equals(""))) {
			plesury = req.getParameter(PLEURISY);
		}

		if (req.getParameter(EAR_DISEASE) != null
				&& !(req.getParameter(EAR_DISEASE).equals(""))) {
			earDieses = req.getParameter(EAR_DISEASE);
		}

		if (req.getParameter(RHEUMATISM) != null
				&& !(req.getParameter(RHEUMATISM).equals(""))) {
			rheumatism = req.getParameter(RHEUMATISM);
		}
		if (req.getParameter(FREQUENT_CAUGH) != null
				&& !(req.getParameter(FREQUENT_CAUGH).equals(""))) {
			frequentCough = req.getParameter(FREQUENT_CAUGH);
		}

		if (req.getParameter(CHRONIC_INDIGESTION) != null
				&& !(req.getParameter(CHRONIC_INDIGESTION).equals(""))) {
			chronicIndigestion = req.getParameter(CHRONIC_INDIGESTION);
		}
		if (req.getParameter(NERVOUS_BRAKDOWN) != null
				&& !(req.getParameter(NERVOUS_BRAKDOWN).equals(""))) {
			nervousBrakdown = req.getParameter(NERVOUS_BRAKDOWN);
		}

		if (req.getParameter(KIDENY_BLADDER) != null
				&& !(req.getParameter(KIDENY_BLADDER).equals(""))) {
			kidenyBladder = req.getParameter(KIDENY_BLADDER);
		}
		if (req.getParameter(FITS_FAINTING_ATTACKS) != null
				&& !(req.getParameter(FITS_FAINTING_ATTACKS).equals(""))) {
			fitsFaintinngAttacks = req.getParameter(FITS_FAINTING_ATTACKS);
		}
		if (req.getParameter(STD) != null
				&& !(req.getParameter(STD).equals(""))) {
			std = req.getParameter(STD);
		}

		if (req.getParameter(SEVERE_HEAD_INJURY) != null
				&& !(req.getParameter(SEVERE_HEAD_INJURY).equals(""))) {
			serveHeadInjury = req.getParameter(SEVERE_HEAD_INJURY);
		}

		if (req.getParameter(JOUNDICE) != null
				&& !(req.getParameter(JOUNDICE).equals(""))) {
			joundice = req.getParameter(JOUNDICE);
		}
		if (req.getParameter(SICKNESS) != null
				&& !(req.getParameter(SICKNESS).equals(""))) {
			sickness = req.getParameter(SICKNESS);
		}
		if (req.getParameter(BREAST_DISEASE) != null
				&& !(req.getParameter(BREAST_DISEASE).equals(""))) {
			breastDisease = req.getParameter(BREAST_DISEASE);
		}
		if (req.getParameter(TRACHOMA) != null
				&& !(req.getParameter(TRACHOMA).equals(""))) {
			trachoma = req.getParameter(TRACHOMA);
		}

		if (req.getParameter(AMENORRHOEA) != null
				&& !(req.getParameter(AMENORRHOEA).equals(""))) {
			amenorrhoea = req.getParameter(AMENORRHOEA);
		}
		if (req.getParameter(NIGHT_BINDNESS) != null
				&& !(req.getParameter(NIGHT_BINDNESS).equals(""))) {
			nightbindness = req.getParameter(NIGHT_BINDNESS);
		}
		if (req.getParameter(MENORRHAGIA) != null
				&& !(req.getParameter(MENORRHAGIA).equals(""))) {
			menirrhagia = req.getParameter(MENORRHAGIA);
		}
		if (req.getParameter(LASER_TREATEMENT) != null
				&& !(req.getParameter(LASER_TREATEMENT).equals(""))) {
			laserTeartement = req.getParameter(LASER_TREATEMENT);
		}
		if (req.getParameter(PREGNANCY) != null
				&& !(req.getParameter(PREGNANCY).equals(""))) {
			pregnancy = req.getParameter(PREGNANCY);
		}
		if (req.getParameter(EYE_DISEASE) != null
				&& !(req.getParameter(EYE_DISEASE).equals(""))) {
			eyeDisease = req.getParameter(EYE_DISEASE);
		}
		if (req.getParameter(REJECTED_AS_UNFIT) != null
				&& !(req.getParameter(REJECTED_AS_UNFIT).equals(""))) {
			rejectedAsUnfit = req.getParameter(REJECTED_AS_UNFIT);
		}
		if (req.getParameter(DISCHARGE_MEDICALLY_UNFIT) != null
				&& !(req.getParameter(DISCHARGE_MEDICALLY_UNFIT).equals(""))) {
			dischargeMedicallyUnfit = req
					.getParameter(DISCHARGE_MEDICALLY_UNFIT);
		}
		if (req.getParameter(ADIMMITED_IN_HOSPITAL_FOR_ILLNESS) != null
				&& !(req.getParameter(ADIMMITED_IN_HOSPITAL_FOR_ILLNESS)
						.equals(""))) {
			adimmitedInHospitalFirIllness = req
					.getParameter(ADIMMITED_IN_HOSPITAL_FOR_ILLNESS);
		}
		if (req.getParameter(ABORTION) != null
				&& !(req.getParameter(ABORTION).equals(""))) {
			abortion = req.getParameter(ABORTION);
		}

		if (req.getParameter(STATE_NATURE_OF_THE_DISEASE) != null
				&& !(req.getParameter(STATE_NATURE_OF_THE_DISEASE).equals(""))) {
			stateNature = req.getParameter(STATE_NATURE_OF_THE_DISEASE);
		}
		if (req.getParameter(OTHER_INFORMATION) != null
				&& !(req.getParameter(OTHER_INFORMATION).equals(""))) {
			otherInform = req.getParameter(OTHER_INFORMATION);
		}
		if (req.getParameter(HEIGHT_WITHOUT_SHOOSE) != null
				&& !(req.getParameter(HEIGHT_WITHOUT_SHOOSE).equals(""))) {
			height = (new BigDecimal(req.getParameter(HEIGHT_WITHOUT_SHOOSE)));
		}
		if (req.getParameter(ACTUAL_WEIGHT) != null
				&& !(req.getParameter(ACTUAL_WEIGHT).equals(""))) {
			weight = (new BigDecimal(req.getParameter(ACTUAL_WEIGHT)));
		}
		if (req.getParameter(ACCEPTABLE_KG) != null
				&& !(req.getParameter(ACCEPTABLE_KG).equals(""))) {
			acceptableKg = (new BigDecimal(req.getParameter(ACCEPTABLE_KG)));
		}
		if (req.getParameter(LEG_LENGTH) != null
				&& !(req.getParameter(LEG_LENGTH).equals(""))) {
			leglength = (new BigDecimal(req.getParameter(LEG_LENGTH)));
		}
		if (req.getParameter(APPEREANCE) != null
				&& !(req.getParameter(APPEREANCE).equals(""))) {
			appereance = req.getParameter(APPEREANCE);
		}
		if (req.getParameter(ALBUMIN) != null
				&& !(req.getParameter(ALBUMIN).equals(""))) {
			albumin = req.getParameter(ALBUMIN);
		}
		if (req.getParameter(SUGAR) != null
				&& !(req.getParameter(SUGAR).equals(""))) {
			sugar = req.getParameter(SUGAR);
		}
		if (req.getParameter(SP_GRAVITY) != null
				&& !(req.getParameter(SP_GRAVITY).equals(""))) {
			spGraviry = req.getParameter(SP_GRAVITY);
		}
		if (req.getParameter(HB_PERCENTAGE) != null
				&& !(req.getParameter(HB_PERCENTAGE).equals(""))) {
			hbPercentage = req.getParameter(HB_PERCENTAGE);
		}
		if (req.getParameter(PHYSIQUE) != null
				&& !(req.getParameter(PHYSIQUE).equals(""))) {
			physique = req.getParameter(PHYSIQUE);
		}

		if (req.getParameter(ANYOTHER_INV_CARRIED_OUT) != null
				&& !(req.getParameter(ANYOTHER_INV_CARRIED_OUT).equals(""))) {
			anyOtherInv = req.getParameter(ANYOTHER_INV_CARRIED_OUT);
		}
		if (req.getParameter(SKIN) != null
				&& !(req.getParameter(SKIN).equals(""))) {
			skin = req.getParameter(SKIN);
		}
		if (req.getParameter(ABDOMEN) != null
				&& !(req.getParameter(ABDOMEN).equals(""))) {
			abdomen = req.getParameter(ABDOMEN);
		}
		if (req.getParameter(HEART_SIZE) != null
				&& !(req.getParameter(HEART_SIZE).equals(""))) {
			heartSize = req.getParameter(HEART_SIZE);
		}
		if (req.getParameter(SOUND) != null
				&& !(req.getParameter(SOUND).equals(""))) {
			sound = req.getParameter(SOUND);
		}
		if (req.getParameter(RHYTHM) != null
				&& !(req.getParameter(RHYTHM).equals(""))) {
			rhythm = req.getParameter(RHYTHM);
		}
		if (req.getParameter(ARTERIAL_WALLS) != null
				&& !(req.getParameter(ARTERIAL_WALLS).equals(""))) {
			arterialWalls = req.getParameter(ARTERIAL_WALLS);
		}
		if (req.getParameter(PULSE_RATES) != null
				&& !(req.getParameter(PULSE_RATES).equals(""))) {
			pulseRates = req.getParameter(PULSE_RATES);
		}
		if (req.getParameter(BP1) != null
				&& !(req.getParameter(BP1).equals(""))) {
			bp = req.getParameter(BP1);
		}
		if (req.getParameter(FULL_EXPENSION) != null
				&& !(req.getParameter(FULL_EXPENSION).equals(""))) {
			fullExpension = req.getParameter(FULL_EXPENSION);
		}
		if (req.getParameter(RANGE_OF_EXPENSION) != null
				&& !(req.getParameter(RANGE_OF_EXPENSION).equals(""))) {
			rangeOfExpension = req.getParameter(RANGE_OF_EXPENSION);
		}

		if (req.getParameter(SELF_BALANCINF_R) != null
				&& !(req.getParameter(SELF_BALANCINF_R).equals(""))) {
			selfBalR = req.getParameter(SELF_BALANCINF_R);
		}
		if (req.getParameter(SELF_BALANCING_L) != null
				&& !(req.getParameter(SELF_BALANCING_L).equals(""))) {
			selfBalL = req.getParameter(SELF_BALANCING_L);
		}
		if (req.getParameter(SPEECH_MENTAL_CAPACITY) != null
				&& !(req.getParameter(SPEECH_MENTAL_CAPACITY).equals(""))) {
			speechMental = req.getParameter(SPEECH_MENTAL_CAPACITY);
		}
		if (req.getParameter(ENDOCRINE_CONDITION) != null
				&& !(req.getParameter(ENDOCRINE_CONDITION).equals(""))) {
			endocrinCond = req.getParameter(ENDOCRINE_CONDITION);
		}
		if (req.getParameter(OTHER_ABNORMALITIES) != null
				&& !(req.getParameter(OTHER_ABNORMALITIES).equals(""))) {
			otherAbnormalities = req.getParameter(OTHER_ABNORMALITIES);
		}
		if (req.getParameter(MEDICIN_REMARKS) != null
				&& !(req.getParameter(MEDICIN_REMARKS).equals(""))) {
			medicinRemarks = req.getParameter(MEDICIN_REMARKS);
		}
		if (req.getParameter(FINGER) != null
				&& !(req.getParameter(FINGER).equals(""))) {
			finger = req.getParameter(FINGER);
		}
		if (req.getParameter(HAND) != null
				&& !(req.getParameter(HAND).equals(""))) {
			hand = req.getParameter(HAND);
		}
		if (req.getParameter(WRIST) != null
				&& !(req.getParameter(WRIST).equals(""))) {
			wrist = req.getParameter(WRIST);
		}
		if (req.getParameter(ELBOWS) != null
				&& !(req.getParameter(ELBOWS).equals(""))) {
			elbows = req.getParameter(ELBOWS);
		}
		if (req.getParameter(SHOULDER_GIRDLES) != null
				&& !(req.getParameter(SHOULDER_GIRDLES).equals(""))) {
			shoulderGridles = req.getParameter(SHOULDER_GIRDLES);
		}
		if (req.getParameter(CERCIVAL) != null
				&& !(req.getParameter(CERCIVAL).equals(""))) {
			cercival = req.getParameter(CERCIVAL);
		}
		if (req.getParameter(DORSAL_VERTEBRATE) != null
				&& !(req.getParameter(DORSAL_VERTEBRATE).equals(""))) {
			dorsalVertebrate = req.getParameter(DORSAL_VERTEBRATE);
		}
		if (req.getParameter(HULLUX) != null
				&& !(req.getParameter(HULLUX).equals(""))) {
			hullux = req.getParameter(HULLUX);
		}
		if (req.getParameter(VALGUS) != null
				&& !(req.getParameter(VALGUS).equals(""))) {
			valgus = req.getParameter(VALGUS);
		}
		if (req.getParameter(RIGGUS) != null
				&& !(req.getParameter(RIGGUS).equals(""))) {
			riggus = req.getParameter(RIGGUS);
		}
		if (req.getParameter(FLAT_FEET) != null
				&& !(req.getParameter(FLAT_FEET).equals(""))) {
			flatFeet = req.getParameter(FLAT_FEET);
		}
		if (req.getParameter(JOINTS) != null
				&& !(req.getParameter(JOINTS).equals(""))) {
			joints = req.getParameter(JOINTS);
		}
		if (req.getParameter(PELVIS) != null
				&& !(req.getParameter(PELVIS).equals(""))) {
			pelvis = req.getParameter(PELVIS);
		}
		if (req.getParameter(GAIL) != null
				&& !(req.getParameter(GAIL).equals(""))) {
			gail = req.getParameter(GAIL);
		}
		if (req.getParameter(LUMBER_SCALER_VERTABRAC) != null
				&& !(req.getParameter(LUMBER_SCALER_VERTABRAC).equals(""))) {
			lumberScaler = req.getParameter(LUMBER_SCALER_VERTABRAC);
		}
		if (req.getParameter(ROCCYX_VARICOSE_VENIS) != null
				&& !(req.getParameter(ROCCYX_VARICOSE_VENIS).equals(""))) {
			roccyxVericose = req.getParameter(ROCCYX_VARICOSE_VENIS);
		}
		if (req.getParameter(HYDROCELE) != null
				&& !(req.getParameter(HYDROCELE).equals(""))) {
			hydrocele = req.getParameter(HYDROCELE);
		}
		if (req.getParameter(VARICOCELE) != null
				&& !(req.getParameter(VARICOCELE).equals(""))) {
			varicocele = req.getParameter(VARICOCELE);
		}
		if (req.getParameter(UNDER_SCENDED_TESTES) != null
				&& !(req.getParameter(UNDER_SCENDED_TESTES).equals(""))) {
			underScende = req.getParameter(UNDER_SCENDED_TESTES);
		}
		if (req.getParameter(HEMONHOIDS) != null
				&& !(req.getParameter(HEMONHOIDS).equals(""))) {
			hemonhoids = req.getParameter(HEMONHOIDS);
		}
		if (req.getParameter(HERNIA_MUSCLE) != null
				&& !(req.getParameter(HERNIA_MUSCLE).equals(""))) {
			herinaMusic = req.getParameter(HERNIA_MUSCLE);
		}
		if (req.getParameter(BREASTS) != null
				&& !(req.getParameter(BREASTS).equals(""))) {
			breasts = req.getParameter(BREASTS);
		}
		if (req.getParameter(SURGERY_REMARKS) != null
				&& !(req.getParameter(SURGERY_REMARKS).equals(""))) {
			surgeryRemarks = req.getParameter(SURGERY_REMARKS);
		}
		if (req.getParameter(RESPIRATORY_SYSTEM) != null
				&& !(req.getParameter(RESPIRATORY_SYSTEM).equals(""))) {
			respatorySystem = req.getParameter(RESPIRATORY_SYSTEM);
		}

		if (req.getParameter(WITH_GLASSES_DISTANT_R) != null
				&& !(req.getParameter(WITH_GLASSES_DISTANT_R).equals(""))) {
			withGlassesDistantR = req.getParameter(WITH_GLASSES_DISTANT_R);
		}
		if (req.getParameter(WITH_GLASSES_DISTANT_L) != null
				&& !(req.getParameter(WITH_GLASSES_DISTANT_L).equals(""))) {
			withglassesDistantL = req.getParameter(WITH_GLASSES_DISTANT_L);
		}
		if (req.getParameter(WITH_GLASSES_NEAR_R) != null
				&& !(req.getParameter(WITH_GLASSES_NEAR_R).equals(""))) {
			withGlassesNearR = req.getParameter(WITH_GLASSES_NEAR_R);
		}
		if (req.getParameter(WITH_GLASSES_NEAR_L) != null
				&& !(req.getParameter(WITH_GLASSES_NEAR_L).equals(""))) {
			withGlassesNearL = req.getParameter(WITH_GLASSES_NEAR_L);
		}
		if (req.getParameter(WITH_GLASSES_NEAR_CP) != null
				&& !(req.getParameter(WITH_GLASSES_NEAR_CP).equals(""))) {
			withGlassesNearCP = req.getParameter(WITH_GLASSES_NEAR_CP);

		}
		if (req.getParameter(WITHOUT_GLASSES_DISTANT_R) != null
				&& !(req.getParameter(WITHOUT_GLASSES_DISTANT_R).equals(""))) {
			withoutGlassesDistantR = req
					.getParameter(WITHOUT_GLASSES_DISTANT_R);
		}
		if (req.getParameter(WITHOUT_GLASSES_DISTANT_L) != null
				&& !(req.getParameter(WITHOUT_GLASSES_DISTANT_L).equals(""))) {
			withoutGlassesDistantL = req
					.getParameter(WITHOUT_GLASSES_DISTANT_L);
		}
		if (req.getParameter(WITHOUT_GLASSES_NEAR_R) != null
				&& !(req.getParameter(WITHOUT_GLASSES_NEAR_R).equals(""))) {
			withoutGlassesNearR = req.getParameter(WITHOUT_GLASSES_NEAR_R);
		}
		if (req.getParameter(WITHOUT_GLASSES_NEAR_L) != null
				&& !(req.getParameter(WITHOUT_GLASSES_NEAR_L).equals(""))) {
			withoutGlassesNearL = req.getParameter(WITHOUT_GLASSES_NEAR_L);
		}
		if (req.getParameter(WITHOUT_GLASSES_NEAR_CP) != null
				&& !(req.getParameter(WITHOUT_GLASSES_NEAR_CP).equals(""))) {
			withoutGlassesNearCP = req.getParameter(WITHOUT_GLASSES_NEAR_CP);
		}
		if (req.getParameter(CONVERGENCE_SC) != null
				&& !(req.getParameter(CONVERGENCE_SC).equals(""))) {
			convergenceCP = new BigDecimal(req.getParameter(CONVERGENCE_SC));
		}
		if (req.getParameter(CONVERGENCE_C) != null
				&& !(req.getParameter(CONVERGENCE_C).equals(""))) {
			convergenceC = new BigDecimal(req.getParameter(CONVERGENCE_C));

		}
		if (req.getParameter(ACCOMMODATION_R) != null
				&& !(req.getParameter(ACCOMMODATION_R).equals(""))) {
			accommodationR = req.getParameter(ACCOMMODATION_R);
		}
		if (req.getParameter(ACCOMMODATION_L) != null
				&& !(req.getParameter(ACCOMMODATION_L).equals(""))) {
			accommodationL = req.getParameter(ACCOMMODATION_L);
		}

		if (req.getParameter(EYE_REMARKS) != null
				&& !(req.getParameter(EYE_REMARKS).equals(""))) {
			eyeRemarks = req.getParameter(EYE_REMARKS);
		}
		if (req.getParameter(EYE_DATE) != null
				&& !(req.getParameter(EYE_DATE).equals(""))) {
			eyeDate = HMSUtil.dateFormatterDDMMYYYY(req.getParameter(EYE_DATE));
		}
		if (req.getParameter(HEARING_R_F_W) != null
				&& !(req.getParameter(HEARING_R_F_W).equals(""))) {
			hearingRFW = new BigDecimal(req.getParameter(HEARING_R_F_W));
		}
		if (req.getParameter(HEARING_L_F_W) != null
				&& !(req.getParameter(HEARING_L_F_W).equals(""))) {
			hearingLFW = new BigDecimal(req.getParameter(HEARING_L_F_W));
		}
		if (req.getParameter(HEARING_BOTH_FW) != null
				&& !(req.getParameter(HEARING_BOTH_FW).equals(""))) {
			hearingBothFW = new BigDecimal(req.getParameter(HEARING_BOTH_FW));
		}

		if (req.getParameter(HEARING_R_C_V) != null
				&& !(req.getParameter(HEARING_R_C_V).equals(""))) {
			hearingRCV = new BigDecimal(req.getParameter(HEARING_R_C_V));
		}
		if (req.getParameter(HEARING_L_C_V) != null
				&& !(req.getParameter(HEARING_L_C_V).equals(""))) {
			hearingLCV = new BigDecimal(req.getParameter(HEARING_L_C_V));
		}
		if (req.getParameter(HEARING_BOTH_CV) != null
				&& !(req.getParameter(HEARING_BOTH_CV).equals(""))) {
			hearingBothCV = new BigDecimal(req.getParameter(HEARING_BOTH_CV));
		}
		if (req.getParameter(INNER_EAR_R) != null
				&& !(req.getParameter(INNER_EAR_R).equals(""))) {
			innerEarR = req.getParameter(INNER_EAR_R);
		}
		if (req.getParameter(INNER_EAR_L) != null
				&& !(req.getParameter(INNER_EAR_L).equals(""))) {
			innerEarL = req.getParameter(INNER_EAR_L);
		}

		if (req.getParameter(AUDIOMETRY_RECORD) != null
				&& !(req.getParameter(AUDIOMETRY_RECORD).equals(""))) {
			audiometryRecord = req.getParameter(AUDIOMETRY_RECORD);
		}
		if (req.getParameter(NOSE) != null
				&& !(req.getParameter(NOSE).equals(""))) {
			nose = req.getParameter(NOSE);
		}
		if (req.getParameter(THROAT_EAR) != null
				&& !(req.getParameter(THROAT_EAR).equals(""))) {
			throatEar = req.getParameter(THROAT_EAR);
		}
		if (req.getParameter(EAR_REMARKS) != null
				&& !(req.getParameter(EAR_REMARKS).equals(""))) {
			earReamrks = req.getParameter(EAR_REMARKS);
		}
		if (req.getParameter(EAR_DATE) != null
				&& !(req.getParameter(EAR_DATE).equals(""))) {
			earDate = HMSUtil.dateFormatterDDMMYYYY(req.getParameter(EAR_DATE));
		}

		if (req.getParameter(EXTERNAL_EAR_R) != null
				&& !(req.getParameter(EXTERNAL_EAR_R).equals(""))) {
			externalEarR = req.getParameter(EXTERNAL_EAR_R);
		}
		if (req.getParameter(EXTERNAL_EAR_L) != null
				&& !(req.getParameter(EXTERNAL_EAR_L).equals(""))) {
			externalEarL = req.getParameter(EXTERNAL_EAR_L);
		}
		if (req.getParameter(MIDDLE_EAR_R) != null
				&& !(req.getParameter(MIDDLE_EAR_R).equals(""))) {
			middleEarR = req.getParameter(MIDDLE_EAR_R);
		}
		if (req.getParameter(MIDDLE_EAR_L) != null
				&& !(req.getParameter(MIDDLE_EAR_L).equals(""))) {
			middleEarL = req.getParameter(MIDDLE_EAR_L);
		}
		if (req.getParameter(ANY_EVIDENCE_OF_TRACHOMA) != null
				&& !(req.getParameter(ANY_EVIDENCE_OF_TRACHOMA).equals(""))) {
			evidienceOfTrachoma = req.getParameter(ANY_EVIDENCE_OF_TRACHOMA);
		}
		if (req.getParameter(BINOCULAR_VISION_GRADE) != null
				&& !(req.getParameter(BINOCULAR_VISION_GRADE).equals(""))) {
			binocular = req.getParameter(BINOCULAR_VISION_GRADE);
		}
		if (req.getParameter(MANIFEST_HYPERMETROPIA) != null
				&& !(req.getParameter(MANIFEST_HYPERMETROPIA).equals(""))) {
			manifestHypermetropia = req.getParameter(MANIFEST_HYPERMETROPIA);
		}
		if (req.getParameter(COVER_TEST) != null
				&& !(req.getParameter(COVER_TEST).equals(""))) {
			coverTest = req.getParameter(COVER_TEST);
		}
		if (req.getParameter(DIAPHRAGM_TEST) != null
				&& !(req.getParameter(DIAPHRAGM_TEST).equals(""))) {
			diaphragmTest = req.getParameter(DIAPHRAGM_TEST);
		}
		if (req.getParameter(FUND_MEDIA) != null
				&& !(req.getParameter(FUND_MEDIA).equals(""))) {
			fundMedia = req.getParameter(FUND_MEDIA);
		}
		if (req.getParameter(FIELDS) != null
				&& !(req.getParameter(FIELDS).equals(""))) {
			fields = req.getParameter(FIELDS);
		}
		if (req.getParameter(NIGHT_VISUAL_CAPACITY) != null
				&& !(req.getParameter(NIGHT_VISUAL_CAPACITY).equals(""))) {
			nightVisualCapacity = req.getParameter(NIGHT_VISUAL_CAPACITY);
		}
		if (req.getParameter(DENTAL_REMARKS) != null
				&& !(req.getParameter(DENTAL_REMARKS).equals(""))) {
			dentalRemarks = req.getParameter(DENTAL_REMARKS);
		}

		if (req.getParameter(DENTAL_DATE) != null
				&& !(req.getParameter(DENTAL_DATE).equals(""))) {
			dentalDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DENTAL_DATE));
		}
		if (req.getParameter(MENSTRUAL_HISTORY) != null
				&& !(req.getParameter(MENSTRUAL_HISTORY).equals(""))) {
			menstrualHistory = req.getParameter(MENSTRUAL_HISTORY);
		}
		if (req.getParameter(NO_OF_PREGNANCY) != null
				&& !(req.getParameter(NO_OF_PREGNANCY).equals(""))) {
			noOfPregnancy = Integer.parseInt(req.getParameter(NO_OF_PREGNANCY));
		}
		if (req.getParameter(NO_OF_ABORTION) != null
				&& !(req.getParameter(NO_OF_ABORTION).equals(""))) {
			noOfAbortion = Integer.parseInt(req.getParameter(NO_OF_ABORTION));
		}
		if (req.getParameter(NO_OF_CHILDREN) != null
				&& !(req.getParameter(NO_OF_CHILDREN).equals(""))) {
			noOfChildren = Integer.parseInt(req.getParameter(NO_OF_CHILDREN));
		}
		if (req.getParameter(DATE_OF_LASTCONFINEMENT) != null
				&& !(req.getParameter(DATE_OF_LASTCONFINEMENT).equals(""))) {
			lastCondinement = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(DATE_OF_LASTCONFINEMENT));
		}
		if (req.getParameter(VAGINAL_DISCHARGE) != null
				&& !(req.getParameter(VAGINAL_DISCHARGE).equals(""))) {
			vaginalDischarge = req.getParameter(VAGINAL_DISCHARGE);
		}
		if (req.getParameter(PROLAPSE) != null
				&& !(req.getParameter(PROLAPSE).equals(""))) {
			prolapse = req.getParameter(PROLAPSE);
		}
		if (req.getParameter(USG_ABORTION) != null
				&& !(req.getParameter(USG_ABORTION).equals(""))) {
			usgAbortion = req.getParameter(USG_ABORTION);
		}
		if (req.getParameter(GYANAECOLOGY_RAMARKS) != null
				&& !(req.getParameter(GYANAECOLOGY_RAMARKS).equals(""))) {
			gyanaecologyRemarks = req.getParameter(GYANAECOLOGY_RAMARKS);
		}
		if (req.getParameter(GYANAECOLOGY_DATE) != null
				&& !(req.getParameter(GYANAECOLOGY_DATE).equals(""))) {
			gyanaecologyDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(GYANAECOLOGY_DATE));
		}
		if (req.getParameter(GYANAECOLOGY_RAMARKS) != null
				&& !(req.getParameter(GYANAECOLOGY_RAMARKS).equals(""))) {
			gyanaecologyRemarks = req.getParameter(GYANAECOLOGY_RAMARKS);
		}
		if (req.getParameter(MEDICAL_BOARD_EXAMINATION) != null
				&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION).equals(""))) {
			medicalBoardExamination = req
					.getParameter(MEDICAL_BOARD_EXAMINATION);
		}
		
		if (req.getParameter(MEDICAL_BOARD_EXAMINATION_PLACE) != null
				&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION_PLACE)
						.equals(""))) {

			medicalBoardExaminationPlace = Integer.parseInt(req
					.getParameter(MEDICAL_BOARD_EXAMINATION_PLACE));
			

		}
		if (req.getParameter(MEDICAL_BOARD_EXAMINATION_DATE) != null
				&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION_DATE)
						.equals(""))) {
			medicalBoardExaminationDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(MEDICAL_BOARD_EXAMINATION_DATE)));
		}
		if (req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION) != null
				&& !(req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION)
						.equals(""))) {
			subsequentMedicalBoardExam = req
					.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION);
		}
		if (req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE) != null
				&& !(req
						.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE)
						.equals(""))) {
			subsequentMedicalBoardExamPlace = Integer.parseInt(req
					.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_PLACE));
		}
		if (req.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE) != null
				&& !(req
						.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE)
						.equals(""))) {
			subsequentMedicalBoardExamDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(SUBSEQUENT_MEDICAL_BOARD_EXAMINATION_DATE)));
		}

		if (req.getParameter(APPROVING_AUTHORITY) != null
				&& !(req.getParameter(APPROVING_AUTHORITY).equals(""))) {
			ApprovingAuthority = req.getParameter(APPROVING_AUTHORITY);
		}
		if (req.getParameter(APPROVING_AUTHORITY_PLACE) != null
				&& !(req.getParameter(APPROVING_AUTHORITY_PLACE).equals(""))) {
			ApprovingAuthorityPlace = Integer.parseInt(req
					.getParameter(APPROVING_AUTHORITY_PLACE));
		}
		if (req.getParameter(APPROVING_AUTHORITY_DATE) != null
				&& !(req.getParameter(APPROVING_AUTHORITY_DATE).equals(""))) {
			ApprovingAuthorityDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(APPROVING_AUTHORITY_DATE)));
		}
		if (req.getParameter(LMP) != null
				&& !(req.getParameter(LMP).equals(""))) {
			lmp = HMSUtil.dateFormatterDDMMYYYY((req.getParameter(LMP)));
		}

		if (req.getParameter(SURGERY_DATE) != null
				&& !(req.getParameter(SURGERY_DATE).equals(""))) {
			surgeyDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(SURGERY_DATE)));
		}

		if (req.getParameter(MEDICIN_EXAM_DATE) != null
				&& !(req.getParameter(MEDICIN_EXAM_DATE).equals(""))) {
			medicinExamDate = HMSUtil.dateFormatterDDMMYYYY((req
					.getParameter(MEDICIN_EXAM_DATE)));

		}
		if (req.getParameter(TOTAL_NO_OF_TEETH) != null
				&& !(req.getParameter(TOTAL_NO_OF_TEETH).equals(""))) {
			totalTeeth = req.getParameter(TOTAL_NO_OF_TEETH);

		}
		if (req.getParameter(DEFECTIVE_TEETH) != null
				&& !(req.getParameter(DEFECTIVE_TEETH).equals(""))) {
			totalDefectiveTeeth = req.getParameter(DEFECTIVE_TEETH);

		}
		if (req.getParameter(MISSING_TEETH) != null
				&& !(req.getParameter(MISSING_TEETH).equals(""))) {
			missingTeeth = req.getParameter(MISSING_TEETH);

		}
		if (req.getParameter(MISSING_UNSERVICABLE_TEETH) != null
				&& !(req.getParameter(MISSING_UNSERVICABLE_TEETH).equals(""))) {
			unserviceableTeeth = req.getParameter(MISSING_UNSERVICABLE_TEETH);

		}
		if (req.getParameter(DENTSL_POINT) != null
				&& !(req.getParameter(DENTSL_POINT).equals(""))) {
			DenstalPoint = req.getParameter(DENTSL_POINT);

		}

		if (req.getParameter(LAST_CHANGED_BY) != null) {
			lastChangedBy = req.getParameter(LAST_CHANGED_BY);
		}
		if (req.getParameter(LAST_CHANGED_DATE) != null) {
			lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
					.getParameter(LAST_CHANGED_DATE));
		}
		if (req.getParameter(LAST_CHANGED_TIME) != null) {
			lastChangedTime = req.getParameter(LAST_CHANGED_TIME);
		}
		// //////////////////////////////////

		if (req.getParameter(DUR_8) != null) {
			dur8 = (req.getParameter(DUR_8));

		} else {
			dur8 = "N";

		}

		if (req.getParameter(DUR_7) != null) {
			dur7 = (req.getParameter(DUR_7));

		} else {
			dur7 = "N";

		}
		if (req.getParameter(DUR_6) != null) {
			dur6 = (req.getParameter(DUR_6));

		} else {
			dur6 = "N";

		}
		if (req.getParameter(DUR_5) != null) {
			dur5 = (req.getParameter(DUR_5));

		} else {
			dur5 = "N";

		}

		if (req.getParameter(DUR_4) != null) {
			dur4 = (req.getParameter(DUR_4));
		} else {
			dur4 = "N";

		}
		if (req.getParameter(DUR_3) != null) {
			dur3 = (req.getParameter(DUR_3));

		} else {
			dur3 = "N";

		}
		if (req.getParameter(DUR_2) != null) {
			dur2 = (req.getParameter(DUR_2));

		} else {
			dur2 = "N";

		}
		if (req.getParameter(DUR_1) != null) {
			dur1 = (req.getParameter(DUR_1));

		} else {
			dur1 = "N";

		}

		if (req.getParameter(DUL_8) != null) {
			dul8 = (req.getParameter(DUL_8));
		} else {
			dul8 = "N";

		}
		if (req.getParameter(DUL_7) != null) {
			dul7 = (req.getParameter(DUL_7));

		} else {
			dul7 = "N";

		}
		if (req.getParameter(DUL_6) != null) {
			dul6 = (req.getParameter(DUL_6));
		} else {
			dul6 = "N";

		}
		if (req.getParameter(DUL_5) != null) {
			dul5 = (req.getParameter(DUL_5));
		} else {
			dul5 = "N";

		}
		if (req.getParameter(DUL_4) != null) {
			dul4 = (req.getParameter(DUL_4));
		} else {
			dul4 = "N";

		}
		if (req.getParameter(DUL_3) != null) {
			dul3 = (req.getParameter(DUL_3));
		} else {
			dul3 = "N";

		}
		if (req.getParameter(DUL_2) != null) {
			dul2 = (req.getParameter(DUL_2));
		} else {
			dul2 = "N";

		}
		if (req.getParameter(DUL_1) != null) {
			dul1 = (req.getParameter(DUL_1));
		} else {
			dul1 = "N";

		}

		if (req.getParameter(DLR_8) != null) {
			dlr8 = (req.getParameter(DLR_8));
		} else {
			dlr8 = "N";

		}
		if (req.getParameter(DLR_7) != null) {
			dlr7 = (req.getParameter(DLR_7));
		} else {
			dlr7 = "N";

		}
		if (req.getParameter(DLR_6) != null) {
			dlr6 = (req.getParameter(DLR_6));
		} else {
			dlr6 = "N";

		}
		if (req.getParameter(DLR_5) != null) {
			dlr5 = (req.getParameter(DLR_5));
		} else {
			dlr5 = "N";

		}
		if (req.getParameter(DLR_4) != null) {
			dlr4 = (req.getParameter(DLR_4));
		} else {
			dlr4 = "N";

		}
		if (req.getParameter(DLR_3) != null) {
			dlr3 = (req.getParameter(DLR_3));
		} else {
			dlr3 = "N";

		}
		if (req.getParameter(DLR_2) != null) {
			dlr2 = (req.getParameter(DLR_2));
		} else {
			dlr2 = "N";

		}

		if (req.getParameter(DLR_1) != null) {
			dlr1 = (req.getParameter(DLR_1));
		} else {
			dlr1 = "N";

		}

		if (req.getParameter(DLL_8) != null) {
			dll8 = (req.getParameter(DLL_8));
		} else {
			dll8 = "N";

		}
		if (req.getParameter(DLL_7) != null) {
			dll7 = (req.getParameter(DLL_7));
		} else {
			dll7 = "N";

		}

		if (req.getParameter(DLL_6) != null) {
			dll6 = (req.getParameter(DLL_6));
		} else {
			dll6 = "N";

		}
		if (req.getParameter(DLL_5) != null) {
			dll5 = (req.getParameter(DLL_5));
		} else {
			dll5 = "N";

		}
		if (req.getParameter(DLL_4) != null) {
			dll4 = (req.getParameter(DLL_4));
		} else {
			dll4 = "N";

		}
		if (req.getParameter(DLL_3) != null) {
			dll3 = (req.getParameter(DLL_3));
		} else {
			dll3 = "N";

		}
		if (req.getParameter(DLL_2) != null) {
			dll2 = (req.getParameter(DLL_2));
		} else {
			dll2 = "N";

		}
		if (req.getParameter(DLL_1) != null) {
			dll1 = (req.getParameter(DLL_1));
		} else {
			dll1 = "N";

		}
		// ///////////////////////////

		if (req.getParameter(UUR_8) != null) {
			uur8 = (req.getParameter(UUR_8));
		} else {
			uur8 = "N";

		}

		if (req.getParameter(UUR_7) != null) {
			uur7 = (req.getParameter(UUR_7));
		} else {
			uur7 = "N";

		}
		if (req.getParameter(UUR_6) != null) {
			uur6 = (req.getParameter(UUR_6));
		} else {
			uur6 = "N";

		}
		if (req.getParameter(UUR_5) != null) {
			uur5 = (req.getParameter(UUR_5));
		} else {
			uur5 = "N";

		}
		if (req.getParameter(UUR_4) != null) {
			uur4 = (req.getParameter(UUR_4));
		} else {
			uur4 = "N";

		}
		if (req.getParameter(UUR_3) != null) {
			uur3 = (req.getParameter(UUR_3));
		} else {
			uur3 = "N";

		}
		if (req.getParameter(UUR_2) != null) {
			uur2 = (req.getParameter(UUR_2));
		} else {
			uur2 = "N";

		}
		if (req.getParameter(UUR_1) != null) {
			uur1 = (req.getParameter(UUR_1));
		} else {
			uur1 = "N";

		}

		if (req.getParameter(UUL_8) != null) {
			uul8 = (req.getParameter(UUL_8));
		} else {
			uul8 = "N";

		}
		if (req.getParameter(UUL_7) != null) {
			uul7 = (req.getParameter(UUL_7));

		} else {
			uul7 = "N";

		}
		if (req.getParameter(UUL_6) != null) {
			uul6 = (req.getParameter(UUL_6));
		} else {
			uul6 = "N";

		}
		if (req.getParameter(UUL_5) != null) {
			uul5 = (req.getParameter(UUL_5));
		} else {
			uul5 = "N";

		}
		if (req.getParameter(UUL_4) != null) {
			uul4 = (req.getParameter(UUL_4));
		} else {
			uul4 = "N";

		}
		if (req.getParameter(UUL_3) != null) {
			uul3 = (req.getParameter(UUL_3));
		} else {
			uul3 = "N";

		}
		if (req.getParameter(UUL_2) != null) {
			uul2 = (req.getParameter(UUL_2));
		} else {
			uul2 = "N";

		}
		if (req.getParameter(UUL_1) != null) {
			uul1 = (req.getParameter(UUL_1));
		} else {
			uul1 = "N";

		}
		if (req.getParameter(ULR_8) != null) {
			ulr8 = (req.getParameter(ULR_8));
		} else {
			ulr8 = "N";

		}

		if (req.getParameter(ULR_7) != null) {
			ulr7 = (req.getParameter(ULR_7));
		} else {
			ulr7 = "N";

		}
		if (req.getParameter(ULR_6) != null) {
			ulr6 = (req.getParameter(ULR_6));
		} else {
			ulr6 = "N";

		}
		if (req.getParameter(ULR_5) != null) {
			ulr5 = (req.getParameter(ULR_5));
		} else {
			ulr5 = "N";

		}
		if (req.getParameter(ULR_4) != null) {
			ulr4 = (req.getParameter(ULR_4));
		} else {
			ulr4 = "N";

		}
		if (req.getParameter(ULR_3) != null) {
			ulr3 = (req.getParameter(ULR_3));
		} else {
			ulr3 = "N";

		}
		if (req.getParameter(ULR_2) != null) {
			ulr2 = (req.getParameter(ULR_2));
		} else {
			ulr2 = "N";

		}
		if (req.getParameter(ULR_1) != null) {
			ulr1 = (req.getParameter(ULR_1));
		} else {
			ulr1 = "N";

		}

		if (req.getParameter(ULL_8) != null) {
			ull8 = (req.getParameter(ULL_8));
		} else {
			ull8 = "N";

		}
		if (req.getParameter(ULL_7) != null) {
			ull7 = (req.getParameter(ULL_7));
		} else {
			ull7 = "N";

		}
		if (req.getParameter(ULL_6) != null) {
			ull6 = (req.getParameter(ULL_6));
		} else {
			ull6 = "N";

		}
		if (req.getParameter(ULL_5) != null) {
			ull5 = (req.getParameter(ULL_5));
		} else {
			ull5 = "N";

		}
		if (req.getParameter(ULL_4) != null) {
			ull4 = (req.getParameter(ULL_4));
		} else {
			ull4 = "N";

		}
		if (req.getParameter(ULL_3) != null) {
			ull3 = (req.getParameter(ULL_3));
		} else {
			ull3 = "N";

		}
		if (req.getParameter(ULL_2) != null) {
			ull2 = (req.getParameter(ULL_2));
		} else {
			ull2 = "N";

		}
		if (req.getParameter(ULL_1) != null) {
			ull1 = (req.getParameter(ULL_1));
		} else {
			ull1 = "N";

		}

		// ////////////////////////

		if (req.getParameter(MUR_8) != null) {
			mur8 = (req.getParameter(MUR_8));

		} else {
			mur8 = "N";

		}
		if (req.getParameter(MUR_7) != null) {
			mur7 = (req.getParameter(MUR_7));
		} else {
			mur7 = "N";

		}
		if (req.getParameter(MUR_6) != null) {
			mur6 = (req.getParameter(MUR_6));
		} else {
			mur6 = "N";

		}
		if (req.getParameter(MUR_5) != null) {
			mur5 = (req.getParameter(MUR_5));
		} else {
			mur5 = "N";

		}
		if (req.getParameter(MUR_4) != null) {
			mur4 = (req.getParameter(MUR_4));
		} else {
			mur4 = "N";

		}
		if (req.getParameter(MUR_3) != null) {
			mur3 = (req.getParameter(MUR_3));
		} else {
			mur3 = "N";

		}
		if (req.getParameter(MUR_2) != null) {
			mur2 = (req.getParameter(MUR_2));
		} else {
			mur2 = "N";

		}
		if (req.getParameter(MUR_1) != null) {
			mur1 = (req.getParameter(MUR_1));
		} else {
			mur1 = "N";

		}

		if (req.getParameter(MUL_8) != null) {
			mul8 = (req.getParameter(MUL_8));
		} else {
			mul8 = "N";

		}
		if (req.getParameter(MUL_7) != null) {
			mul7 = (req.getParameter(MUL_7));

		} else {
			mul7 = "N";

		}
		if (req.getParameter(MUL_6) != null) {
			mul6 = (req.getParameter(MUL_6));
		} else {
			mul6 = "N";

		}
		if (req.getParameter(MUL_5) != null) {
			mul5 = (req.getParameter(MUL_5));
		} else {
			mul5 = "N";

		}
		if (req.getParameter(MUL_4) != null) {
			mul4 = (req.getParameter(MUL_4));
		} else {
			mul4 = "N";

		}
		if (req.getParameter(MUL_3) != null) {
			mul3 = (req.getParameter(MUL_3));
		} else {
			mul3 = "N";

		}
		if (req.getParameter(MUL_2) != null) {
			mul2 = (req.getParameter(MUL_2));
		} else {
			mul2 = "N";

		}
		if (req.getParameter(MUL_1) != null) {
			mul1 = (req.getParameter(MUL_1));
		} else {
			mul1 = "N";

		}
		if (req.getParameter(MLR_8) != null) {
			mlr8 = (req.getParameter(MLR_8));
		} else {
			mlr8 = "N";

		}

		if (req.getParameter(MLR_7) != null) {
			mlr7 = (req.getParameter(MLR_7));
		} else {
			mlr7 = "N";

		}
		if (req.getParameter(MLR_6) != null) {
			mlr6 = (req.getParameter(MLR_6));
		} else {
			mlr6 = "N";

		}
		if (req.getParameter(MLR_5) != null) {
			mlr5 = (req.getParameter(MLR_5));
		} else {
			mlr5 = "N";

		}

		if (req.getParameter(MLR_4) != null) {
			mlr4 = (req.getParameter(MLR_4));
		} else {
			mlr4 = "N";

		}
		if (req.getParameter(MLR_3) != null) {
			mlr3 = (req.getParameter(MLR_3));
		} else {
			mlr3 = "N";

		}

		if (req.getParameter(MLR_2) != null) {
			mlr2 = (req.getParameter(MLR_2));
		} else {
			mlr2 = "N";

		}
		if (req.getParameter(MLR_1) != null) {
			mlr1 = (req.getParameter(MLR_1));
		} else {
			mlr1 = "N";

		}

		if (req.getParameter(MLL_8) != null) {
			mll8 = (req.getParameter(MLL_8));
		} else {
			mll8 = "N";

		}
		if (req.getParameter(MLL_7) != null) {
			mll7 = (req.getParameter(MLL_7));
		} else {
			mll7 = "N";

		}
		if (req.getParameter(MLL_6) != null) {
			mll6 = (req.getParameter(MLL_6));
		} else {
			mll6 = "N";

		}
		if (req.getParameter(MLL_5) != null) {
			mll5 = (req.getParameter(MLL_5));
		} else {
			mll5 = "N";

		}
		if (req.getParameter(MLL_4) != null) {
			mll4 = (req.getParameter(MLL_4));
		} else {
			mll4 = "N";

		}
		if (req.getParameter(MLL_3) != null) {
			mll3 = (req.getParameter(MLL_3));
		} else {
			mll3 = "N";

		}
		if (req.getParameter(MLL_2) != null) {
			mll2 = (req.getParameter(MLL_2));
		} else {
			mll2 = "N";

		}
		if (req.getParameter(MLL_1) != null) {
			mll1 = (req.getParameter(MLL_1));
		} else {
			mll1 = "N";

		}

		sur8 = dur8 + "" + mur8 + "" + uur8;

		sur7 = dur7 + "" + mur7 + "" + uur7;

		sur6 = dur6 + "" + mur6 + "" + uur6;
		sur5 = dur5 + "" + mur5 + "" + uur5;
		sur4 = dur4 + "" + mur4 + "" + uur4;
		sur3 = dur3 + "" + mur3 + "" + uur3;
		sur2 = dur2 + "" + mur2 + "" + uur2;
		sur1 = dur1 + "" + mur2 + "" + uur1;

		sul8 = dul8 + "" + mul8 + "" + uul8;
		sul7 = dul7 + "" + mul7 + "" + uul7;

		sul6 = dul6 + "" + mul6 + "" + uul6;
		sul5 = dul5 + "" + mul5 + "" + uul5;
		sul4 = dul4 + "" + mul4 + "" + uul4;
		sul3 = dul3 + "" + mul3 + "" + uul3;
		sul2 = dul2 + "" + mul2 + "" + uul2;
		sul1 = dul1 + "" + mul1 + "" + uul1;

		slr8 = dlr8 + "" + mlr8 + "" + ulr8;
		slr7 = dlr7 + "" + mlr7 + "" + ulr7;
		slr6 = dlr6 + "" + mlr6 + "" + ulr6;
		slr5 = dlr5 + "" + mlr5 + "" + ulr5;
		slr4 = dlr4 + "" + mlr4 + "" + ulr4;
		slr3 = dlr3 + "" + mlr3 + "" + ulr3;
		slr2 = dlr2 + "" + mlr2 + "" + ulr2;
		slr1 = dlr1 + "" + mlr2 + "" + ulr1;

		sll8 = dll8 + "" + mll8 + "" + ull8;
		sll7 = dll7 + "" + mll7 + "" + ull7;
		sll6 = dll6 + "" + mll6 + "" + ull6;
		sll5 = dll5 + "" + mll5 + "" + ull5;
		sll4 = dll4 + "" + mll4 + "" + ull4;
		sll3 = dll3 + "" + mll3 + "" + ull3;
		sll2 = dll2 + "" + mll2 + "" + ull2;
		sll1 = dll1 + "" + mll1 + "" + ull1;
		MbTypeOfEntryMaster mbTypeOfEntryMaster = new MbTypeOfEntryMaster();
		mbTypeOfEntryMaster.setId(typeOfEntry);
		generalMap.put("serviceNo", serviceNo);
			generalMap.put("pojoPropertyCode", "serviceNo");
		generalMap.put("pojoName", "MasMedicalExaminationReportOnEntry");
		
		
		//Map listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		Boolean successfullyAdded = false;
	//	List codeList = (List) listMap.get("duplicateGeneralCodeList");
		// List nameList = (List) listMap.get("duplicateGeneralNameList");
		// List typeOfEntryList = (List)
		// listMap.get("duplicateGeneralAddressList");
	/*	if (codeList != null && codeList.size() > 0) {
			message = "Yearly Serial No Already Exist!";
			jsp = MEDICAL_BOARD_ERROR_MSG;
		} else {*/
		
		String DoctorAdviceFlag="n";
		if(req.getParameter("DoctorAdviceFlag") != null)
		{
			DoctorAdviceFlag = req.getParameter("DoctorAdviceFlag");
		}
		System.out.println("DoctorAdviceFlagin update="+DoctorAdviceFlag);
		masMedicalBoardProceedings.setDoctorAdviceFlag(DoctorAdviceFlag);
		
		masMedicalBoardProceedings.setDentalOfficer(DentalOfficer);
	    masMedicalBoardProceedings.setDentalCheckupDate(dentalcheckupdate);
		if (req.getParameter("dentalReferToMH") != null && !(req.getParameter("dentalReferToMH").equals(""))) {
			masMedicalBoardProceedings.setReferToMH(req.getParameter("dentalReferToMH"));
		}

			masMedicalBoardProceedings.setInnerEarL(innerEarL);
			masMedicalBoardProceedings.setHearingBothCv(hearingBothCV);
			masMedicalBoardProceedings.setDateSpecialExam(eyeDate);
			masMedicalBoardProceedings
					.setTotalDefectiveTeeth(totalDefectiveTeeth);
			masMedicalBoardProceedings.setTotalTeeth(totalTeeth);
			masMedicalBoardProceedings.setMissingTeeth(missingTeeth);
			masMedicalBoardProceedings.setUnservisableTeeth(unserviceableTeeth);
			masMedicalBoardProceedings.setDenstlPoint(DenstalPoint);
			masMedicalBoardProceedings.setYearlySerialNo(serviceNo);
		//	masMedicalBoardProceedings.setMonthlySerialNo(rank);
			masMedicalBoardProceedings.setEntryDate(entryDate);
//----------------------------------------------------------------------------------------
			if(data!=null)
			{
			   
				masMedicalBoardProceedings.setDlc(dlc);
				masMedicalBoardProceedings.setHb(hb);
				masMedicalBoardProceedings.setTlc(tlc);
				masMedicalBoardProceedings.setEsr(esr);
				masMedicalBoardProceedings.setSpGravity(spGravity);
				masMedicalBoardProceedings.setAlbumin(albumen);
				masMedicalBoardProceedings.setSugar(sugarR);
				masMedicalBoardProceedings.setSugarF(sugarF);
				masMedicalBoardProceedings.setSugarPP(sugarPP);
				masMedicalBoardProceedings.setUrea(urea);
				masMedicalBoardProceedings.setUricAcid(uricAcid);
				masMedicalBoardProceedings.setSrCreatine(srCreatine);
				masMedicalBoardProceedings.setCholesterol(cholesterol);
				masMedicalBoardProceedings.setTriglycerides(triglycerids);
				masMedicalBoardProceedings.setHld(hdl);
				masMedicalBoardProceedings.setVldl(vldl);
			
			}   
//----------------------------------------------------------------------------------------		
			masMedicalBoardProceedings.setTypeOfEntry(mbTypeOfEntryMaster);
			//masMedicalBoardProceedings.setBatchNo(betchNo);
			masMedicalBoardProceedings.setChestNo(chestNo);
			masMedicalBoardProceedings.setRollNo(rollNo);
	/*		MasUnit masUnit = new MasUnit();
			masUnit.setId(medicalExamHeld);
			masMedicalBoardProceedings.setMedicalExamHeldAt(masUnit);*/
			masMedicalBoardProceedings.setMedicalStatus(medicalStatus);
			masMedicalBoardProceedings.setNameInFull(fullName);
			masMedicalBoardProceedings.setDateOfBirth(dateOfBirth);
			if(maritialStatus != 0){
				MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
				masMaritalStatus.setId(maritialStatus);
				masMedicalBoardProceedings.setMaritalStatus(masMaritalStatus);
			}
			masMedicalBoardProceedings.setPNo(pNo);
			
			masMedicalBoardProceedings.setHoursOfFlown(hoursOfFlown);
			masMedicalBoardProceedings.setParmanentAddress(permanentAddress);
			masMedicalBoardProceedings.setIdentificationMarks1(identification1);
			masMedicalBoardProceedings.setIdentificationMarks2(identification2);
			masMedicalBoardProceedings.setArmsCorps(armsCrops);
			masMedicalBoardProceedings.setDateOfCompletion(dateOfCompletion);
			masMedicalBoardProceedings
					.setDocumentForwardDate(documentForwardDate);
		//	masMedicalBoardProceedings.setDateOfReporting(dateOfReporting);
			masMedicalBoardProceedings.setDocumentForwardTo(documentForwardTo);
			masMedicalBoardProceedings.setFromWhereHeReport(fromWhereHeReport);
			masMedicalBoardProceedings.setHypertension(hypertension);
			masMedicalBoardProceedings.setHeartDiabetes(heartDisease);
			masMedicalBoardProceedings.setDiabetes(diabetes);
			masMedicalBoardProceedings.setBleedingDisorder(bleedingDisorder);
			masMedicalBoardProceedings.setMentalDisease(mentalDisease);
			masMedicalBoardProceedings.setNightBlindness(nightBlindness);
			masMedicalBoardProceedings.setChronicBronchitis(asthama);
			masMedicalBoardProceedings.setDischargeFromEars(dischargeFrom);
			masMedicalBoardProceedings.setPleurisy(plesury);
			masMedicalBoardProceedings.setAnyOtherEarDisease(earDieses);
			masMedicalBoardProceedings
					.setRheumatismFrequentSorethroats(rheumatism);
			masMedicalBoardProceedings
					.setFrequentCoughColdSinusitis(frequentCough);
			masMedicalBoardProceedings
					.setChronicIndigestion(chronicIndigestion);
			masMedicalBoardProceedings
					.setNervousBreakdownMentalIllness(nervousBrakdown);
			masMedicalBoardProceedings.setKidneyBladderTrouble(kidenyBladder);
			masMedicalBoardProceedings
					.setFitsFaintingAttack(fitsFaintinngAttacks);
			masMedicalBoardProceedings.setStd(std);
			masMedicalBoardProceedings.setSevereHeadInjury(serveHeadInjury);
			masMedicalBoardProceedings.setJaundice(joundice);
			masMedicalBoardProceedings.setAirSeaCarTrainSickness(sickness);
			masMedicalBoardProceedings.setBreastDiseaseDischarge(breastDisease);
			masMedicalBoardProceedings.setTrachoma(trachoma);
			masMedicalBoardProceedings.setAmenorrhoeaDysmenonhoea(amenorrhoea);
			masMedicalBoardProceedings.setNightBindness(nightbindness);
			masMedicalBoardProceedings.setMenonhagia(menirrhagia);
			masMedicalBoardProceedings
					.setLaserTreatementSurgeryForEye(laserTeartement);
			masMedicalBoardProceedings.setPregnancy(pregnancy);
			masMedicalBoardProceedings.setAnyOtherEyeDisease(eyeDisease);
			masMedicalBoardProceedings.setAbortion(abortion);
			masMedicalBoardProceedings
					.setBeenrejectedAsMedicallyUnfitForAnyBranch(rejectedAsUnfit);
			masMedicalBoardProceedings
					.setDischargeAsMedicallyUnfitForAnyBranch(dischargeMedicallyUnfit);
			masMedicalBoardProceedings
					.setAdmittedInHospitalForAnyIllnessOperationOrInjury(adimmitedInHospitalFirIllness);

			masMedicalBoardProceedings
					.setStateTheNatureOfDiseaseDuration(stateNature);
			masMedicalBoardProceedings
					.setAnyOtherInformationAboutYourHealth(otherInform);
			masMedicalBoardProceedings.setHeight(height);
			masMedicalBoardProceedings.setWeight(weight);
			masMedicalBoardProceedings.setAcceptable(acceptableKg);
			masMedicalBoardProceedings.setLegLength(leglength);
			masMedicalBoardProceedings.setAppearance(appereance);
			masMedicalBoardProceedings.setAlbumin(albumin);
			masMedicalBoardProceedings.setSugar(sugar);
			masMedicalBoardProceedings.setSpGravity(spGraviry);
			masMedicalBoardProceedings.setHbPercentage(hbPercentage);
			masMedicalBoardProceedings.setAnyOtherInvCarriedOut(anyOtherInv);
			masMedicalBoardProceedings.setPhysique(physique);
			masMedicalBoardProceedings.setSkin(skin);
			masMedicalBoardProceedings.setAbdomen(abdomen);
			masMedicalBoardProceedings.setHeartSize(heartSize);
			masMedicalBoardProceedings.setSounds(sound);
			masMedicalBoardProceedings.setRhythm(rhythm);
			masMedicalBoardProceedings.setArterialWalls(arterialWalls);
			masMedicalBoardProceedings.setPulseRates(pulseRates);
			masMedicalBoardProceedings.setBp(bp);
			masMedicalBoardProceedings.setChestMeasurement(fullExpension);
			masMedicalBoardProceedings.setRangeOfExpension(rangeOfExpension);
			masMedicalBoardProceedings.setSelfBalancingR(selfBalR);
			masMedicalBoardProceedings.setSelfBalancingL(selfBalL);
			masMedicalBoardProceedings.setSpeechMentalCapacity(speechMental);
			masMedicalBoardProceedings.setEndocrineCondition(endocrinCond);
			masMedicalBoardProceedings
					.setAnyOtheAbnormalities(otherAbnormalities);
			masMedicalBoardProceedings.setRemarks(medicinRemarks);
			masMedicalBoardProceedings.setFingers(finger);
			masMedicalBoardProceedings.setHand(hand);
			masMedicalBoardProceedings.setWrists(wrist);
			masMedicalBoardProceedings.setElbows(elbows);
			masMedicalBoardProceedings.setShoulderGirdles(shoulderGridles);
			masMedicalBoardProceedings.setCervical(cercival);
			masMedicalBoardProceedings.setDorsalVertebrate(dorsalVertebrate);
			masMedicalBoardProceedings.setHullux(hullux);
			masMedicalBoardProceedings.setValgus(valgus);
			masMedicalBoardProceedings.setRigigus(riggus);
			masMedicalBoardProceedings.setFlatFeet(flatFeet);
			masMedicalBoardProceedings.setJoints(joints);
			masMedicalBoardProceedings.setPelvis(pelvis);
			masMedicalBoardProceedings.setGail(gail);
			masMedicalBoardProceedings.setLumber(lumberScaler);
			masMedicalBoardProceedings.setRoccyxVarocose(roccyxVericose);
			masMedicalBoardProceedings.setHydrocele(hydrocele);
			masMedicalBoardProceedings.setVaricocele(varicocele);
			masMedicalBoardProceedings.setUnderscendedTest(underScende);
			masMedicalBoardProceedings.setHemorrhoids(hemonhoids);
			masMedicalBoardProceedings.setHerniaMusic(herinaMusic);
			masMedicalBoardProceedings.setBreasts(breasts);
			masMedicalBoardProceedings.setRemarksLowerlimbs(surgeryRemarks);
			masMedicalBoardProceedings.setRespiratorySystem(respatorySystem);
			masMedicalBoardProceedings
					.setWithGlassesLDistant(withglassesDistantL);
			masMedicalBoardProceedings
					.setWithGlassesRDistant(withGlassesDistantR);
			masMedicalBoardProceedings
					.setWithoutGlassesLDistant(withoutGlassesDistantL);
			masMedicalBoardProceedings
					.setWthoutGlassesRDistant(withoutGlassesDistantR);
			masMedicalBoardProceedings
					.setWithGlassesLNearvision(withGlassesNearL);
			masMedicalBoardProceedings
					.setWithGlassesRNearvision(withGlassesNearR);
			masMedicalBoardProceedings
					.setWithoutGlassesLNearvision(withoutGlassesNearL);
			masMedicalBoardProceedings
					.setWithoutGlassesRNearvision(withoutGlassesNearR);
			masMedicalBoardProceedings
					.setEvidenceOfTrachoma(evidienceOfTrachoma);
			masMedicalBoardProceedings.setBinocularVisionGrade(binocular);
			masMedicalBoardProceedings
					.setManifestHypermetropia(manifestHypermetropia);
			masMedicalBoardProceedings.setCoverTest(coverTest);
			masMedicalBoardProceedings.setDiaphragmTest(diaphragmTest);
			masMedicalBoardProceedings.setFundAndMedia(fundMedia);
			masMedicalBoardProceedings.setFields(fields);
			masMedicalBoardProceedings
					.setNightVisualCapacity(nightVisualCapacity);
			masMedicalBoardProceedings.setConvergenceC(convergenceC);
			masMedicalBoardProceedings.setConvergenceSc(convergenceCP);
			masMedicalBoardProceedings.setAccommodationR(accommodationR);
			masMedicalBoardProceedings.setAccommodationL(accommodationL);
			masMedicalBoardProceedings.setRemarksSpecialExam(eyeRemarks);
			masMedicalBoardProceedings.setHearingRcv(hearingRCV);
			masMedicalBoardProceedings.setHearingLcv(hearingLCV);
			masMedicalBoardProceedings.setEarHearingRfw(hearingRFW);
			masMedicalBoardProceedings.setEarHearingLfw(hearingLFW);
			masMedicalBoardProceedings.setEarHearingBothFw(hearingBothFW);
			masMedicalBoardProceedings.setExternalEarR(externalEarR);
			masMedicalBoardProceedings.setExternalEarL(externalEarL);
			masMedicalBoardProceedings.setMiddleEarR(middleEarR);
			masMedicalBoardProceedings.setMiddleEar(middleEarL);

			masMedicalBoardProceedings.setInnerEarR(innerEarR);
			masMedicalBoardProceedings.setAudiometryRecord(audiometryRecord);
			masMedicalBoardProceedings.setNose(nose);
			masMedicalBoardProceedings.setThroat(throatEar);
			masMedicalBoardProceedings.setRemarksEar(earReamrks);
			masMedicalBoardProceedings.setEarDate(earDate);
			masMedicalBoardProceedings.setDateTeath(dentalDate);
			masMedicalBoardProceedings.setRemarksTeath(dentalRemarks);
			masMedicalBoardProceedings.setMenstrualHistory(menstrualHistory);
			masMedicalBoardProceedings.setNoOfPregnancies(noOfPregnancy);
			masMedicalBoardProceedings.setNoOfAbortions(noOfAbortion);
			masMedicalBoardProceedings.setNoOfChildren(noOfChildren);
			masMedicalBoardProceedings.setLastConfinementDate(lastCondinement);
			masMedicalBoardProceedings.setVaginalDischarge(vaginalDischarge);
			masMedicalBoardProceedings.setProlapse(prolapse);
			masMedicalBoardProceedings.setUsgAbdomen(usgAbortion);
			masMedicalBoardProceedings.setGynaecologyDate(gyanaecologyDate);
			masMedicalBoardProceedings
					.setRemarksGynaecology(gyanaecologyRemarks);
			masMedicalBoardProceedings
					.setMedicalBoardFindings(medicalBoardExamination);
			masMedicalBoardProceedings
					.setDateMedicalBoardExam(medicalBoardExaminationDate);
			masMedicalBoardProceedings.setLmp(lmp);
			if (medicalBoardExaminationPlace != 0) {
				MasUnit masUnit1 = new MasUnit();
				masUnit1.setId(medicalBoardExaminationPlace);
				masMedicalBoardProceedings.setPlaceMedicalBoardExam(masUnit1);
			}
			masMedicalBoardProceedings
					.setMedicalBoardSubsequentFind(subsequentMedicalBoardExam);
			masMedicalBoardProceedings
					.setDateMedicalBoardSubsequent(subsequentMedicalBoardExamDate);
			if (subsequentMedicalBoardExamPlace != 0) {
				MasUnit masUnit2 = new MasUnit();
				masUnit2.setId(subsequentMedicalBoardExamPlace);
				masMedicalBoardProceedings
						.setPlaceMedicalBoardSubsequent(masUnit2);
			}
			masMedicalBoardProceedings
					.setApprovingAuthority(ApprovingAuthority);
			masMedicalBoardProceedings
					.setDateApprovingAuthority(ApprovingAuthorityDate);
			if (ApprovingAuthorityPlace != 0) {
				MasUnit masUnit3 = new MasUnit();
				masUnit3.setId(ApprovingAuthorityPlace);
				masMedicalBoardProceedings.setPlaceApprovingAuthority(masUnit3);
			}
			masMedicalBoardProceedings.setSurgeryDate(surgeyDate);
			masMedicalBoardProceedings.setMediceExamDate(medicinExamDate);
			masMedicalBoardProceedings
					.setNearVisionWithGlassCp(withGlassesNearCP);
			masMedicalBoardProceedings
					.setNearVisionWithoutGlassCp(withoutGlassesNearCP);
			masMedicalBoardProceedings.setUR1(sur1);
			masMedicalBoardProceedings.setUR2(sur2);
			masMedicalBoardProceedings.setUR3(sur3);
			masMedicalBoardProceedings.setUR4(sur4);
			masMedicalBoardProceedings.setUR5(sur5);
			masMedicalBoardProceedings.setUR6(sur6);
			masMedicalBoardProceedings.setUR7(sur7);
			masMedicalBoardProceedings.setUR8(sur8);

			masMedicalBoardProceedings.setUL1(sul1);
			masMedicalBoardProceedings.setUL2(sul2);
			masMedicalBoardProceedings.setUL3(sul3);
			masMedicalBoardProceedings.setUL4(sul4);
			masMedicalBoardProceedings.setUL5(sul5);
			masMedicalBoardProceedings.setUL6(sul6);
			masMedicalBoardProceedings.setUL7(sul7);
			masMedicalBoardProceedings.setUL8(sul8);

			masMedicalBoardProceedings.setLR1(slr1);
			masMedicalBoardProceedings.setLR2(slr2);
			masMedicalBoardProceedings.setLR3(slr3);
			masMedicalBoardProceedings.setLR4(slr4);
			masMedicalBoardProceedings.setLR5(slr5);
			masMedicalBoardProceedings.setLR6(slr6);
			masMedicalBoardProceedings.setLR7(slr7);
			masMedicalBoardProceedings.setLR8(slr8);

			masMedicalBoardProceedings.setLL1(sll1);
			masMedicalBoardProceedings.setLL2(sll2);
			masMedicalBoardProceedings.setLL3(sll3);
			masMedicalBoardProceedings.setLL4(sll4);
			masMedicalBoardProceedings.setLL5(sll5);
			masMedicalBoardProceedings.setLL6(sll6);
			masMedicalBoardProceedings.setLL7(sll7);
			masMedicalBoardProceedings.setLL8(sll8);
			masMedicalBoardProceedings.setLastChangedBy(lastChangedBy);
			masMedicalBoardProceedings.setLastChangedDate(lastChangedDate);
			masMedicalBoardProceedings.setLastChangedTime(lastChangedTime);
			masMedicalBoardProceedings.setServiceNo(serviceNo);
	//		masMedicalBoardProceedings.setName(name);
	//		masMedicalBoardProceedings.setUnit(unit);
			masMedicalBoardProceedings.setServiceiaf(serviceiaf);
//			masMedicalBoardProceedings.setBranch(branch);
	//		masMedicalBoardProceedings.setDob(dob);
			
			masMedicalBoardProceedings.setTypeofcommision(typeOfCommunication);
			masMedicalBoardProceedings.setDateofcommun(dateofcommun);
			masMedicalBoardProceedings.setTotalService(totalservice);
			masMedicalBoardProceedings.setPastmedicalhistory(pastmedicalhistory);
			masMedicalBoardProceedings.setPresentmedicalhistory(presentmedicalhistory);
			masMedicalBoardProceedings.setIdealweight(idealweight);
			masMedicalBoardProceedings.setOverweight(overweight);
			masMedicalBoardProceedings.setWaist(waist);
			masMedicalBoardProceedings.setChestfullexpansion(chestfullexpansion);
			masMedicalBoardProceedings.setBhi(bhi);
			masMedicalBoardProceedings.setRangeofexpansion(rangeofexpansion);
			masMedicalBoardProceedings.setBodyfat(bodyfat);
			masMedicalBoardProceedings.setSignfoldthickness(signfoldthickness);
			masMedicalBoardProceedings.setSportman(sportman);
			masMedicalBoardProceedings.setLastame(lastame);
			masMedicalBoardProceedings.setActualweight(actualweight);
			/**
			 * Added By Ritu
			 */
			if(req.getParameter("sd") != null && !req.getParameter("sd").equals("")){
				masMedicalBoardProceedings.setSD(req.getParameter("sd"));
			}
			/**
			 * End
			 */
			if(req.getParameter(SERVICE_TYPE_ID) != null && !(req.getParameter(SERVICE_TYPE_ID)).equals("0")){
				MasServiceType serviceType = new MasServiceType();
				serviceType.setId(Integer.parseInt(req.getParameter(SERVICE_TYPE_ID)));
				masMedicalBoardProceedings.setServiceType(serviceType);
			}
			if(req.getParameter(RANK_ID) != null && !(req.getParameter(RANK_ID)).equals("0")){
				MasRank masRank = new MasRank();
				masRank.setId(Integer.parseInt(req.getParameter(RANK_ID)));
				masMedicalBoardProceedings.setRank(masRank);
			}
			if(req.getParameter(TRADE_ID) != null && !(req.getParameter(TRADE_ID)).equals("")){
				MasTrade masTrade = new MasTrade();
				masTrade.setId(Integer.parseInt(req.getParameter(TRADE_ID)));
				masMedicalBoardProceedings.setTrade(masTrade);
			}	
			if(req.getParameter(UNIT_ID) != null && !(req.getParameter(UNIT_ID)).equals("0")){
				MasUnit unitObj = new MasUnit();
				unitObj.setId(Integer.parseInt(req.getParameter(UNIT_ID)));
				masMedicalBoardProceedings.setUnit(unitObj);
			}	
			if(req.getParameter("apparentAge") != null && !req.getParameter("apparentAge").equals("")){
				String aparentage=req.getParameter("apparentAge");
				masMedicalBoardProceedings.setApparentAge(aparentage.substring(0, 2));
			}
			if(req.getParameter(VISIT_ID) != null && !(req.getParameter(VISIT_ID)).equals("0")){
				Visit visit = new Visit();
				visit.setId(Integer.parseInt(req.getParameter(VISIT_ID)));
				if(req.getParameter("apparentAge") == null )
				{
					if(masMedicalBoardProceedings.getVisit().getAge()!=null )
					{
					masMedicalBoardProceedings.setApparentAge(masMedicalBoardProceedings.getVisit().getAge().substring(0, 2));
					}
				}
				masMedicalBoardProceedings.setVisit(visit);
			}	
			if(req.getParameter(HIN_ID) != null && !(req.getParameter(HIN_ID)).equals("0")){
				Patient patient= new Patient();
				patient.setId(Integer.parseInt(req.getParameter(HIN_ID)));
				masMedicalBoardProceedings.setHin(patient);
				mapForDS.put("hinId", Integer.parseInt(req.getParameter(HIN_ID)));
			}	
			if(req.getParameter(FATHER_NAME) != null){
				masMedicalBoardProceedings.setFatherName(req.getParameter(FATHER_NAME));
			}
			if(req.getParameter(RELEVANT_FAMILY_HISTORY) != null){
				masMedicalBoardProceedings.setRelevantFamilyHistory(req.getParameter(RELEVANT_FAMILY_HISTORY));
			}
			if(req.getParameter(DEFECTS_NOT_TO_CAUSE_REJECTION) != null){
				masMedicalBoardProceedings.setDefectNotToCauseRejection(req.getParameter(DEFECTS_NOT_TO_CAUSE_REJECTION));
			}
			if(req.getParameter(FOUND_FIT_IN_CATEGORY) != null){
				masMedicalBoardProceedings.setFoundFitInCategory(req.getParameter(FOUND_FIT_IN_CATEGORY));
			}
			if(req.getParameter(APPOINTMENT_DATE) != null && !req.getParameter(APPOINTMENT_DATE).equals("")){
				masMedicalBoardProceedings.setAppointmentDate(HMSUtil.convertStringTypeDateToDateType(req.getParameter(APPOINTMENT_DATE)));
			}
			if(req.getParameter(APPOINTMENT_TIME) != null && !req.getParameter(APPOINTMENT_TIME).equals("")){
				masMedicalBoardProceedings.setAppointmentTime(req.getParameter(APPOINTMENT_TIME));
			}
			if(req.getParameter("medicalExamType") != null && !req.getParameter("medicalExamType").equals("")){
				masMedicalBoardProceedings.setMedicalExamType(req.getParameter("medicalExamType"));
			}
			if (req.getParameter("Hips") != null&& !(req.getParameter("Hips").equals(""))) {
				    masMedicalBoardProceedings.setHips(req.getParameter("Hips"));
			}
			if (req.getParameter("WHR") != null && !(req.getParameter("WHR").equals(""))) {
				    masMedicalBoardProceedings.setWhr(req.getParameter("WHR"));
			}
					if(req.getParameter(APPOINTMENT_TIME) != null && !req.getParameter(APPOINTMENT_TIME).equals("")){
				masMedicalBoardProceedings.setAppointmentTime(req.getParameter(APPOINTMENT_TIME));
			}
			if(req.getParameter(HIGHER_MENTAL_FUNCTION) != null && !req.getParameter(HIGHER_MENTAL_FUNCTION).equals("")){
				masMedicalBoardProceedings.setHigherMentalFunction(req.getParameter(HIGHER_MENTAL_FUNCTION));
			}
			if(req.getParameter(SPEECH) != null && !req.getParameter(SPEECH).equals("")){
				masMedicalBoardProceedings.setSpeech(req.getParameter(SPEECH));
			}
			if(req.getParameter(REFLEXES) != null && !req.getParameter(REFLEXES).equals("")){
				masMedicalBoardProceedings.setReflexes(req.getParameter(REFLEXES));
			}
			if(req.getParameter(TREMORS) != null && !req.getParameter(TREMORS).equals("")){
				masMedicalBoardProceedings.setTremors(req.getParameter(TREMORS));
			}
			if(req.getParameter(SELF_BALANCING_TEST) != null && !req.getParameter(SELF_BALANCING_TEST).equals("")){
				masMedicalBoardProceedings.setSelfBalancingTest(req.getParameter(SELF_BALANCING_TEST));
			}
			
			if(req.getParameter(DISABILITY) != null && !req.getParameter(DISABILITY).equals("")){
				masMedicalBoardProceedings.setDisability(req.getParameter(DISABILITY));
			}
			if(req.getParameter(CORONORY_RISK_FACTOR) != null && !req.getParameter(CORONORY_RISK_FACTOR).equals("")){
				masMedicalBoardProceedings.setCoronaryRiskFactor(req.getParameter(CORONORY_RISK_FACTOR));
			}
			if(req.getParameter("familyHistoryOther") != null && !req.getParameter("familyHistoryOther").equals(""))
			{
				masMedicalBoardProceedings.setFmdm(req.getParameter("familyHistoryOther"));
			}
			if(req.getParameter("commutationOfPensionRemarks") != null && !req.getParameter("commutationOfPensionRemarks").equals(""))
			{
				masMedicalBoardProceedings.setCommandRemarks(req.getParameter("commutationOfPensionRemarks"));
			}
			//String finalObservation = "";
			if(req.getParameter(FINAL_OBSERVATION) != null && !req.getParameter(FINAL_OBSERVATION).equals(""))
			{
				masMedicalBoardProceedings.setFinalObservation(req.getParameter(FINAL_OBSERVATION));
				//finalObservation = req.getParameter(FINAL_OBSERVATION);
				//mapForDS.put("finalObservation", finalObservation);
			}
			if(req.getParameter(SIGNED_BY) != null && !req.getParameter(SIGNED_BY).equals("")){
				masMedicalBoardProceedings.setSignedBy(req.getParameter(SIGNED_BY));
			}
			if(req.getParameter(APPROVED_BY) != null && !req.getParameter(APPROVED_BY).equals("")){
				masMedicalBoardProceedings.setApprovedBy(req.getParameter(APPROVED_BY));
			}
				String admissionStatus="";
				String specialistOpinion="";
				if (req.getParameter("admissionStatus") != null) 
				{
					admissionStatus ="y";
				} else {
					admissionStatus = "n";

				}
				
				if (req.getParameter("specialistOpinion") != null) 
				{
					specialistOpinion = "y";
				} else {
					specialistOpinion = "n";

				}
				
				masMedicalBoardProceedings.setAdmissionStatus(admissionStatus);
				masMedicalBoardProceedings.setSpecialistOpinnionStatus(specialistOpinion);
					
			
			if(req.getParameter("liver") != null && !req.getParameter("liver").equals("")){
				masMedicalBoardProceedings.setLiver(req.getParameter("liver"));
			}
			if(req.getParameter("spleen") != null && !req.getParameter("spleen").equals("")){
				masMedicalBoardProceedings.setSpleen(req.getParameter("spleen"));
			}
			if(req.getParameter("upperLimbs") != null && !req.getParameter("upperLimbs").equals("")){
				masMedicalBoardProceedings.setUpperLimbs(req.getParameter("upperLimbs"));
			}
			if(req.getParameter("locomotion") != null && !req.getParameter("locomotion").equals("")){
				masMedicalBoardProceedings.setLocomotion(req.getParameter("locomotion"));
			}
			if(req.getParameter("chestMeasurement") != null && !req.getParameter("chestMeasurement").equals("")){
				masMedicalBoardProceedings.setChestMeasurement(req.getParameter("chestMeasurement"));
			}
			if(req.getParameter("fullExpiration") != null && !req.getParameter("fullExpiration").equals("")){
				masMedicalBoardProceedings.setFullExpiration(req.getParameter("fullExpiration"));
			}
			if(req.getParameter("abnormalities") != null && !req.getParameter("abnormalities").equals("")){
				masMedicalBoardProceedings.setAbnormalities(req.getParameter("abnormalities"));
			}
			if(req.getParameter("otherAbnormalities") != null && !req.getParameter("otherAbnormalities").equals("")){
				masMedicalBoardProceedings.setAnyOtheAbnormalities(req.getParameter("otherAbnormalities"));
			}
			if(req.getParameter("anyEvidenceOfSkin") != null && !req.getParameter("anyEvidenceOfSkin").equals("")){
				masMedicalBoardProceedings.setAnyEvidenceOfSkin(req.getParameter("anyEvidenceOfSkin"));
			}
			if(req.getParameter("centralNervousSystem") != null && !req.getParameter("centralNervousSystem").equals("")){
				masMedicalBoardProceedings.setCentralNervousSystem(req.getParameter("centralNervousSystem"));
			}
			if(req.getParameter("mentalInstability") != null && !req.getParameter("mentalInstability").equals("")){
				masMedicalBoardProceedings.setMentalInstability(req.getParameter("mentalInstability"));
			}
			if(req.getParameter("essentialInstability") != null && !req.getParameter("essentialInstability").equals("")){
				masMedicalBoardProceedings.setEssentialInstability(req.getParameter("essentialInstability"));
			}
			if(req.getParameter("smoker") != null && !req.getParameter("smoker").equals("")){
				masMedicalBoardProceedings.setSmoker(req.getParameter("smoker"));
			}
			if(req.getParameter("drinker") != null && !req.getParameter("drinker").equals("")){
				masMedicalBoardProceedings.setDrinker(req.getParameter("drinker"));
			}
			if(req.getParameter("allergies") != null && !req.getParameter("allergies").equals("")){
				masMedicalBoardProceedings.setAllergies(req.getParameter("allergies"));
			}
			if(req.getParameter("locomoterSystem") != null && !req.getParameter("locomoterSystem").equals("")){
				masMedicalBoardProceedings.setLocomoterSystem(req.getParameter("locomoterSystem"));
			}
			if(req.getParameter("spine") != null && !req.getParameter("spine").equals("")){
				masMedicalBoardProceedings.setSpine(req.getParameter("spine"));
			}
			if(req.getParameter("tympanicMembranceIntact") != null && !req.getParameter("tympanicMembranceIntact").equals("")){
				masMedicalBoardProceedings.setTympanicMembranceIntact(req.getParameter("tympanicMembranceIntact"));
			}
			if(req.getParameter(MOBILITYR) != null && !req.getParameter(MOBILITYR).equals("")){
				masMedicalBoardProceedings.setMobilityR(req.getParameter(MOBILITYR));
			}
			if(req.getParameter("noseThroatSinuses") != null && !req.getParameter("noseThroatSinuses").equals("")){
				masMedicalBoardProceedings.setNoseThroatSinuses(req.getParameter("noseThroatSinuses"));
			}
			if(req.getParameter(KNOWN_ALLERGY) != null && !req.getParameter(KNOWN_ALLERGY).equals("")){
				masMedicalBoardProceedings.setAllergies(req.getParameter(KNOWN_ALLERGY));
			}
			if(req.getParameter(BATCH_NO) != null && !req.getParameter(BATCH_NO).equals("")){
				masMedicalBoardProceedings.setBatchNo(req.getParameter(BATCH_NO));
			}
			if(req.getParameter("cmMdRemarks") != null && !req.getParameter("cmMdRemarks").equals("")){
				masMedicalBoardProceedings.setMdRemarks(req.getParameter("cmMdRemarks"));
			}
			if(req.getParameter(AUTHORITY_OF_BOARD) != null && !req.getParameter(AUTHORITY_OF_BOARD).equals("")){
				masMedicalBoardProceedings.setAuthority(req.getParameter(AUTHORITY_OF_BOARD));
			}
			if(req.getParameter(PLACE) != null && !req.getParameter(PLACE).equals("")){
				masMedicalBoardProceedings.setPlace(req.getParameter(PLACE));
			}
			if(req.getParameter(DATE_DISCHARGE) != null && !req.getParameter(DATE_DISCHARGE).equals("")){
				masMedicalBoardProceedings.setDateDischarge(HMSUtil.convertStringTypeDateToDateType(req.getParameter(DATE_DISCHARGE)));
			}
			if(req.getParameter(DATE_OF_RELEASE) != null && !req.getParameter(DATE_OF_RELEASE).equals("")){
				masMedicalBoardProceedings.setDateRelease(HMSUtil.convertStringTypeDateToDateType(req.getParameter(DATE_OF_RELEASE)));
			}
			if(req.getParameter(MARITAL_STATUS_ID) != null && !req.getParameter(MARITAL_STATUS_ID).equals("")){
				MasMaritalStatus maritalstatus = new MasMaritalStatus();
				maritalstatus.setId(Integer.parseInt(req.getParameter(MARITAL_STATUS_ID)));
				masMedicalBoardProceedings.setMaritalStatus(maritalstatus);
				
			}
			
		//	if(req.getParameter(SERVICE_TYPE_ID) != null && !req.getParameter(SERVICE_TYPE_ID).equals("")){
		//		masMedicalBoardProceedings.setBatchNo(req.getParameter(SERVICE_TYPE_ID));
		//	}
			if(req.getParameter(DATE_DISEASE) != null && !req.getParameter(DATE_DISEASE).equals("")){
				masMedicalBoardProceedings.setDateDisease(HMSUtil.convertStringTypeDateToDateType(req.getParameter(DATE_DISEASE)));
			}
			if(req.getParameter(PLACE_DISEASE) != null && !req.getParameter(PLACE_DISEASE).equals("")){
				masMedicalBoardProceedings.setPlacedisease(req.getParameter(PLACE_DISEASE));
			}
			if(req.getParameter(WHERE_TREATED) != null && !req.getParameter(WHERE_TREATED).equals("")){
				masMedicalBoardProceedings.setWheretreated(req.getParameter(WHERE_TREATED));
			}
			if(req.getParameter(DATE_APPROXIMATE) != null && !req.getParameter(DATE_APPROXIMATE).equals("")){
				masMedicalBoardProceedings.setDateapproximate(HMSUtil.convertStringTypeDateToDateType(req.getParameter(DATE_APPROXIMATE)));
			}
			if(req.getParameter(DISABILITY_BEFORE) != null && !req.getParameter(DISABILITY_BEFORE).equals("")){
				masMedicalBoardProceedings.setDisabilitybefore(req.getParameter(DISABILITY_BEFORE));
			}
			if(req.getParameter(CLAMING_DISABILITY) != null && !req.getParameter(CLAMING_DISABILITY).equals("")){
				masMedicalBoardProceedings.setClamingdisability(req.getParameter(CLAMING_DISABILITY));
			}
			if(req.getParameter(DATE_DISCHARGE) != null && !req.getParameter(DATE_DISCHARGE).equals("")){
				masMedicalBoardProceedings.setDateDischarge(HMSUtil.convertStringTypeDateToDateType(req.getParameter(DATE_DISCHARGE)));
			}
			if(req.getParameter(UPLOADED_DATE) != null && !req.getParameter(UPLOADED_DATE).equals("")){
				masMedicalBoardProceedings.setUploadeddate(HMSUtil.convertStringTypeDateToDateType(req.getParameter(UPLOADED_DATE)));
			}
			if(req.getParameter(CONDITION_OF_GUMS) != null && !req.getParameter(CONDITION_OF_GUMS).equals("")){
				masMedicalBoardProceedings.setConditionOfGums(req.getParameter(CONDITION_OF_GUMS));
			}
			if(req.getParameter(TYMPANIC_L) != null && !req.getParameter(TYMPANIC_L).equals("")){
				masMedicalBoardProceedings.setTympanicL(req.getParameter(TYMPANIC_L));
			}
			if(req.getParameter(TYMPANIC_R) != null && !req.getParameter(TYMPANIC_R).equals("")){
				masMedicalBoardProceedings.setTympanicR(req.getParameter(TYMPANIC_R));
			}
			if(req.getParameter(MOBILITYL) != null && !req.getParameter(MOBILITYL).equals("")){
				masMedicalBoardProceedings.setMobilityL(req.getParameter(MOBILITYL));
			}
			if(req.getParameter(NOSE_THROAT) != null && !req.getParameter(NOSE_THROAT).equals("")){
				masMedicalBoardProceedings.setNosethroat(req.getParameter(NOSE_THROAT));
			}
			if(req.getParameter(DATE_OF_AME) != null && !req.getParameter(DATE_OF_AME).equals("")){
				masMedicalBoardProceedings.setDateMedicalBoardSubsequent(HMSUtil.convertStringTypeDateToDateType(req.getParameter(DATE_OF_AME)));
			}
			if(req.getParameter("MissTeeth") != null && !req.getParameter("MissTeeth").equals("")){
				masMedicalBoardProceedings.setMissTeeth(req.getParameter("MissTeeth"));
			}
			if(req.getParameter("UnserTeeth") != null && !req.getParameter("UnserTeeth").equals("")){
				masMedicalBoardProceedings.setUnserTeeth(req.getParameter("UnserTeeth"));
			}
			if(req.getParameter("Investigated") != null && !req.getParameter("Investigated").equals("")){
				masMedicalBoardProceedings.setInvestigated(req.getParameter("Investigated"));
			}
			
			
			
			String medicaltype=masMedicalBoardProceedings.getMedicalExamType();
				MasMedicalExaminationDetail medicaldetail=new MasMedicalExaminationDetail();
			    int temp1 = 1;
				List<Integer> serialnolist = new ArrayList<Integer>();
				List<String> fromlist = new ArrayList<String>();
				List<String> tolist = new ArrayList<String>();
				List<String> placelist = new ArrayList<String>();
				List<String> pnolist = new ArrayList<String>();
				List<Integer> serialnolist1 = new ArrayList<Integer>();
				List<String> illnesslist = new ArrayList<String>();
				List<Date> particulardatelist = new ArrayList<Date>();
				List<Integer> rankidlist = new ArrayList<Integer>();
				List<String> treatedlist = new ArrayList<String>();
				List<String> approximatedatelist = new ArrayList<String>();
				List<String> approximatedate2list = new ArrayList<String>();
				List<String> placelist1 = new ArrayList<String>();
				List<String> principallist = new ArrayList<String>();
				List<Date> origindatelist = new ArrayList<Date>();
				List<Date> medicalcatdatelist = new ArrayList<Date>();
				List<Date> nextcatdatelist = new ArrayList<Date>();
				int k=0;
				int hdbvalue = 1;
				if(req.getParameter("dentalValue") != null && !req.getParameter("dentalValue").equals("")){
					masMedicalBoardProceedings.setDentalValue(req.getParameter("dentalValue"));
				}
				if(req.getParameter(PAST_MEDICAL_CATEGORY) != null && !(req.getParameter(PAST_MEDICAL_CATEGORY)).equals("0")){
					Category categ1 = new Category();
					//String categ1 = "";
					//categ1 = req.getParameter(PAST_MEDICAL_CATEGORY);
					categ1.setCategoryid(Integer.parseInt(req.getParameter(PAST_MEDICAL_CATEGORY)));
					//masMedicalBoardProceedings.setMedicalCategory(categ1);
					masMedicalBoardProceedings.setPastMedicalCategory(categ1);
				}
				if(req.getParameter(PRESENT_MEDICAL_CATEGORY) != null && !(req.getParameter(PRESENT_MEDICAL_CATEGORY)).equals("0")){
					Category categ2 = new Category();
					/*String categ2 = "";
					categ2 = req.getParameter(PRESENT_MEDICAL_CATEGORY);
				    Category category = new Category();
					if(categ2.equals(category.getCategoryid()))
					{
						masMedicalBoardProceedings.setMedicalCategory(categ2);
					}*/
					categ2.setCategoryid(Integer.parseInt(req.getParameter(PRESENT_MEDICAL_CATEGORY)));
					masMedicalBoardProceedings.setPresentMedicalCategory(categ2);
				}
				if(medicaltype.equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
				{
					
					if (Integer.parseInt(req.getParameter("hdb")) != 1) {
						hdbvalue = Integer.parseInt(req.getParameter("hdb"));
					}
				for (int i = 1; i <=hdbvalue; i++) {
						
					if(req.getParameter(SIRIAL_NO+ temp1) == "" ){
						   serialnolist.add(k);
						}else if(req.getParameter(SIRIAL_NO+ i) != null ){
						serialnolist.add(Integer.parseInt(req.getParameter(SIRIAL_NO+ i)));
					}
					
					if(req.getParameter(FROM+ i) != null && !req.getParameter(FROM+ i).equals("") ){
						fromlist.add(req.getParameter(FROM+ i));
					}
					
					if(req.getParameter(TO+ i) != null && !req.getParameter(TO+ i).equals("") ){
						tolist.add(req.getParameter(TO+ i));
					}
					if(req.getParameter(PLACE+ i) != null ){
						placelist.add(req.getParameter(PLACE+ i));
					}
					if(req.getParameter(P_NO+ i) != null ){
						pnolist.add(req.getParameter(P_NO+ i));
					}
					//----------commented by anamika-----------
					/*if(req.getParameter(PRINCIPAL+ i) != null ){
						principallist.add(req.getParameter(PRINCIPAL+ i));
					}*/
					if(req.getParameter(ORIGIN_DATE+ i) != null ){
						origindatelist.add(HMSUtil.convertStringTypeDateToDateType(req.getParameter(ORIGIN_DATE+ i)));
					}
					if(req.getParameter(MEDICAL_CAT_DATE+ i) != null &&(!req.getParameter(MEDICAL_CAT_DATE+ i).equals(""))){
						medicalcatdatelist.add(HMSUtil.convertStringTypeDateToDateType(req.getParameter(MEDICAL_CAT_DATE+ i)));
					}
					if(req.getParameter(NEXT_CAT_DATE+ i) != null &&(!req.getParameter(NEXT_CAT_DATE+ i).equals(""))){
						nextcatdatelist.add(HMSUtil.convertStringTypeDateToDateType(req.getParameter(NEXT_CAT_DATE+ i)));
					}
				//	temp1=temp1+1;
					
					}
	}            map.put("admissionStatus", admissionStatus);
				mapForDS.put("hdbvalue", hdbvalue);
				mapForDS.put("hiddenValue", hiddenValue);
				mapForDS.put("serialnolist", serialnolist);
				mapForDS.put("fromlist", fromlist);
				mapForDS.put("tolist", tolist);
				mapForDS.put("placelist", placelist);
				mapForDS.put("pnolist", pnolist);
				//mapForDS.put("principallist", principallist);
				mapForDS.put("origindatelist", origindatelist);
				mapForDS.put("medicalcatdatelist", medicalcatdatelist);
				mapForDS.put("nextcatdatelist", nextcatdatelist);
				int hdbvalue1 = 1;
				int hiddenValue1 = 1;
				List<Integer> illnessICDlist = new ArrayList<Integer>();
				if(medicaltype.equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
				{
				if (Integer.parseInt(req.getParameter("hdb1")) != 1) {
					hdbvalue1 = Integer.parseInt(req.getParameter("hdb1"));
				}
				int temp2 = 1;
				for (int i = 1; i <= hdbvalue1; i++) {
				
					if(req.getParameter(SIRIAL_NO1+ i) == "" ){
						serialnolist1.add(k);
						}else if(req.getParameter(SIRIAL_NO1+ i) != null ){
							serialnolist1.add(Integer.parseInt(req.getParameter(SIRIAL_NO1+ i)));
					}

					String str="";
					if(req.getParameter(PRINCIPAL+ i) != null ){
						//illnesslist.add(req.getParameter(ILLNESS+ i));
						str=req.getParameter(PRINCIPAL+ i);
					}else{
						//illnesslist.add("");
						str="";
					}
					
					int icdId =0;
					if(str!=""){
					String illness="";
					int lastIndex=str.indexOf("[");
					if(lastIndex>0)
					{   
						illness=str.substring(0, lastIndex);
						illnesslist.add(illness);
					}else
					{
						illness=str;
						illnesslist.add("");
					}
					int index1 = str.lastIndexOf("[");
				    int index2 = str.lastIndexOf("]");
				    //icdId =Integer.parseInt(str.substring((index1+1),index2));
				    try {
						icdId =Integer.parseInt(str.substring((index1+1),index2));
					} catch (NumberFormatException e) {
						
						e.printStackTrace();
					}
				    illnessICDlist.add(icdId);
					}else{
						illnessICDlist.add(icdId);
						illnesslist.add("");
					}
					if(req.getParameter(PARTICULAR_DATE+ i) != null ){
											particulardatelist.add(HMSUtil.convertStringTypeDateToDateType(req.getParameter(PARTICULAR_DATE+ i)));
					}else{
						particulardatelist.add(null);
					}
					if(req.getParameter(RANK_INDIVIDUAL_ID+ i) != null ){
											rankidlist.add(Integer.parseInt(req.getParameter(RANK_INDIVIDUAL_ID+ i)));
										}
					if(req.getParameter(TREATED+ i) != null ){
											treatedlist.add(req.getParameter(TREATED+ i));
					}else{
						treatedlist.add("");
					}
					
					if(req.getParameter(PLACE1+ i) != null ){
						placelist1.add(req.getParameter(PLACE1+ i));
					}else{
						placelist1.add("");
					}
					if(req.getParameter(APPROXIMATE_DATE+ i) != null && (!req.getParameter(APPROXIMATE_DATE+ i).equals("")) ){
						approximatedatelist.add(req.getParameter(APPROXIMATE_DATE+ i));
					}else{
						approximatedatelist.add(null);
					}
					if(req.getParameter(APPROXIMATE_DATE2+ i) != null && (!req.getParameter(APPROXIMATE_DATE2+ i).equals(""))){
						approximatedate2list.add(req.getParameter(APPROXIMATE_DATE2+ i));
					}else{
						approximatedate2list.add(null);
					}
					//temp2=temp2+1;
				}
				mapForDS.put("hdbvalue1", hdbvalue1);
				mapForDS.put("hiddenValue1", hiddenValue1);
				mapForDS.put("serialnolist1", serialnolist1);
				mapForDS.put("illnesslist", illnesslist);
				mapForDS.put("particulardatelist", particulardatelist);
				mapForDS.put("rankidlist", rankidlist);
				mapForDS.put("treatedlist", treatedlist);
				mapForDS.put("approximatedatelist", approximatedatelist);
				mapForDS.put("approximatedate2list", approximatedate2list);
				mapForDS.put("placelist1", placelist1);	
				mapForDS.put("illnessICDlist", illnessICDlist);	
				
				
				/*
				 * Code for Disability Before Service
				 * Date 27 Feb 2012 
				 */
				List<Integer> serialnoBeforeList = new ArrayList<Integer>();
				List<String> illnessBeforeList = new ArrayList<String>();
				List<Date> particulardateBeforeList = new ArrayList<Date>();
				List<String> treatedBeforeList = new ArrayList<String>();
				List<String> placeBeforeList = new ArrayList<String>();
				List<String> beforeDisabilityBeforeList = new ArrayList<String>();
				List<Integer> illnessICDBeforelist = new ArrayList<Integer>();
				int hdbBefore=0;
				
				if (Integer.parseInt(req.getParameter("hdbBefore")) != 0) {
					hdbBefore = Integer.parseInt(req.getParameter("hdbBefore"));
				}
				for (int i = 1; i <=hdbBefore; i++) {

					if(req.getParameter(SR_NO+i) == "" ){
						serialnoBeforeList.add(i);
					}else if(req.getParameter(SR_NO+i) != null ){
						serialnoBeforeList.add(Integer.parseInt(req.getParameter(SR_NO+i)));
					}else{
						serialnoBeforeList.add(0);
					}
					String beforeStr="";
					if(req.getParameter(ICD_ID+i) != null && !req.getParameter(ICD_ID+i).equals("")){
						beforeStr=req.getParameter(ICD_ID+i);
					}else{
						//illnessBeforeList.add("");
						beforeStr="";
					}
					
					int icdId =0;
					if(beforeStr!=""){
					String illness="";
					int lastIndex=beforeStr.indexOf("[");
					if(lastIndex>0)
					{   
						illness=beforeStr.substring(0, lastIndex);
						illnessBeforeList.add(illness);
					}else
					{
						illness=beforeStr;
						illnessBeforeList.add("");
					}
					int index1 = beforeStr.lastIndexOf("[");
				    int index2 = beforeStr.lastIndexOf("]");
				    //icdId =Integer.parseInt(beforeStr.substring((index1+1),index2));
				    try {
						icdId =Integer.parseInt(beforeStr.substring((index1+1),index2));
					} catch (NumberFormatException e) {
						
						e.printStackTrace();
					}
				    illnessICDBeforelist.add(icdId);
					}else{
						illnessICDBeforelist.add(icdId);
						illnessBeforeList.add("");
					}
					if(req.getParameter("pDate"+i) != null && (!req.getParameter("pDate"+i).equals(""))){
						particulardateBeforeList.add(HMSUtil.convertStringTypeDateToDateType(req.getParameter("pDate"+i)));
					}else{
						particulardateBeforeList.add(null);
					}
					if(req.getParameter("whereTreated"+i) != null ){
						treatedBeforeList.add(req.getParameter("whereTreated"+i));
					}else{
						treatedBeforeList.add("");
					}
					if(req.getParameter("particularPlace"+i) != null ){
						placeBeforeList.add(req.getParameter("particularPlace"+i));
					}else{
						placeBeforeList.add("");	
					}
					if(req.getParameter("beforeDisability11"+i) != null ){
						beforeDisabilityBeforeList.add(req.getParameter("beforeDisability11"+i));
					}else{
						beforeDisabilityBeforeList.add("y");
					}
				}
				mapForDS.put("illnessICDBeforelist", illnessICDBeforelist);
				mapForDS.put("hdbBefore", hdbBefore);
				mapForDS.put("serialnoBeforeList", serialnoBeforeList);
				mapForDS.put("illnessBeforeList", illnessBeforeList);
				mapForDS.put("particulardateBeforeList", particulardateBeforeList);
				mapForDS.put("treatedBeforeList", treatedBeforeList);
				mapForDS.put("placeBeforeList", placeBeforeList);
				mapForDS.put("beforeDisabilityBeforeList", beforeDisabilityBeforeList);

				/*
				 * End of Code for Disability Before Service
				 * Date 27 Feb 2012 
				 */
			}
			
			Users moUser = new Users();
			moUser.setId(userId);
			masMedicalBoardProceedings.setMoUser(moUser);
			
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			masMedicalBoardProceedings.setHospital(hospital);
			
			MasCommand command = new MasCommand();
			command.setId(commandId);
			masMedicalBoardProceedings.setCommand(command);
			if (req.getParameter("medicalOfficer") != null
					&& !(req.getParameter("medicalOfficer").equals("0"))) {
				MasEmployee employee = new MasEmployee();
				employee.setId(Integer.parseInt(req.getParameter("medicalOfficer")));
				masMedicalBoardProceedings.setForwardMO(employee);
			}
			int medicalOfficerId = 0;
			if (req.getParameter("medicalOfficer") != null ) {
				medicalOfficerId  = Integer.parseInt(req.getParameter("medicalOfficer"));
			}
			int departmentId = 0;
			if (req.getParameter(DEPARTMENT_ID) != null ) {
				departmentId  = Integer.parseInt(req.getParameter(DEPARTMENT_ID));
			}			
			
		//	if(req.getParameter("Labresult").equalsIgnoreCase("present")){
			if(req.getParameter("Labresult").equalsIgnoreCase("present")&& data!=null)
			{
				if(req.getParameter("ReportingForExamBoard") != null && req.getParameter("ReportingForExamBoard").equals("MedExam")){
			masMedicalBoardProceedings.setStatus("m");
			}else if(req.getParameter("ReportingForExamBoard").equals("MedBoard")){
				masMedicalBoardProceedings.setStatus("s");
			}
			masMedicalBoardProceedings.setModate(new Date());		
			
			
			}else if(!masMedicalBoardProceedings.getStatus().equalsIgnoreCase("m")){
				
				masMedicalBoardProceedings.setStatus("p");
			}
			
			if(req.getParameter("fstatus")!=null && req.getParameter("fstatus").equals("s")){
				masMedicalBoardProceedings.setStatus("s");
			}
			String investigationDataStatus=null;
			if(req.getParameter("investigationDataStatus") != null ){
				investigationDataStatus=req.getParameter("investigationDataStatus");
			}			
			if (req.getParameter("investigationReferToMH" + temp) != null && !req.getParameter("investigationReferToMH" + temp).equals(""))
			{
				investigationReferToMH =(req.getParameter("investigationReferToMH" + temp));
			}
			if(req.getParameter("ReportingForExamBoard") != null && req.getParameter("ReportingForExamBoard").equals("MedExam")){
			masMedicalBoardProceedings.setMedicalType("MedicalExam");
			}else if(req.getParameter("ReportingForExamBoard") != null && req.getParameter("ReportingForExamBoard").equals("MedBoard")){
				masMedicalBoardProceedings.setMedicalType("MedicalBoard");
			}
			mapForDS.put("masMedicalBoardProceedings", masMedicalBoardProceedings);

			mapForDS.put("chargeCodeIdList", chargeCodeIdList);
			mapForDS.put("quantityList", quantityList);
			mapForDS.put("clinicalNotes1", clinicalNotes1);
			mapForDS.put("investigationDataStatus",investigationDataStatus);
			mapForDS.put("lastChangedBy", lastChangedBy);
			mapForDS.put("lastChangedDate", lastChangedDate);
			mapForDS.put("lastChangedTime", lastChangedTime);
			mapForDS.put("hospitalId", hospitalId);
			mapForDS.put("deptId", deptId);
			mapForDS.put("empId", empId);
			mapForDS.put("hinId", hinId);
			mapForDS.put("visitId", visitId);
			mapForDS.put("data", data);
			mapForDS.put("dgOrderdtIdList", dgOrderdtIdList);
			mapForDS.put("patientInvestigationHeaderId", patientInvestigationHeaderId);
			mapForDS.put("patientInvestigationdetailsIdList", patientInvestigationdetailsIdList);
			mapForDS.put("dgOrderhdId", dgOrderhdId);
			mapForDS.put("Labresult", req.getParameter("Labresult"));
			
			mapForDS.put("investigationReferToMHList", investigationReferToMHList);
			mapForDS.put("investResultList", investResultList);
			mapForDS.put("familyHistoryArray", familyHistoryArray);
			mapForDS.put("medicalOfficerId", medicalOfficerId);
			mapForDS.put("departmentId", departmentId);
			mapForDS.put("user", user);
			mapForDS.put("medExamId", medExamId);
			mapForDS.put("data", data);
			mapForDS.put("dgOrderhdId", dgOrderhdId);
			mapForDS.put("investigationReferToMH ", investigationReferToMH );
			mapForDS.put("identification1", identification1);
			mapForDS.put("identification2", identification2);
			successfullyAdded = medicalExamHandlerService
					.updateMedicalExaminationBoardAnnual(mapForDS);
			
			message = "Record Updated Successfully!!";
			jsp = MEDICAL_BOARD_EXAM_MSG;
			if (!successfullyAdded) {
				message = "Some Problem Occured !!!";
				jsp = MEDICAL_BOARD_ERROR_MSG;
			}else if(data!=null)
			{if(req.getParameter("Labresult").equalsIgnoreCase("NotPresent"))
			{
				message = "Lab Result is not Found ! You Can Forward to Medical Officer After Lab Result.";
	
			}else{
				message = "Record  Forwarded Successfully !!";
				//message = "Record Updated Successfully!!";
			}
				
			
			}
		
	}else
	{
		message = "You can forward to Medical Officer only after entering Investigation or Dental Reports";
		jsp = MEDICAL_BOARD_EXAM_MSG;
	}
		//}
		try {
		//	map = medicalExaminationBoardHandlerService.showMedicalExaminationBoardJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String medicalEntryNo = "";
		String medicalEntryNo1 = "";
		String userName = "";
		String userName1 = "";
	//	medicalEntryNo = medicalExaminationBoardHandlerService.generateMedicalEntryNumber(userName);
	//	medicalEntryNo1 = medicalExaminationBoardHandlerService.generateMedicalEntryNumber1(userName1);
		jsp += ".jsp";
		String denatlToMH= "";
		if (req.getParameter("dentalReferToMH") != null
				&& !(req.getParameter("dentalReferToMH").equals(""))) {
			  denatlToMH = req.getParameter("dentalReferToMH");
		}
		map.put("investigationReferToMHList", investigationReferToMHList);
		map.put("medicalEntryNo", medicalEntryNo);
		map.put("medicalEntryNo1", medicalEntryNo1);
		map.put("medicalExamType", req.getParameter("medicalExamType"));
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("medExamId", medExamId); 
		map.put("hinNoForreport", req.getParameter("hinNoForreport"));
		map.put("visitNumberForReport", Integer.parseInt(req.getParameter("visitNumberForReport")));
		map.put("serviceNo", serviceNo);
		map.put("visitId", visitId);
		map.put("denatlToMH", denatlToMH);
		map.put("data", data);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView pendingClwatingList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapofds = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{	
		  hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapofds.put("hospitalId",hospitalId);
		int commandId = (Integer) session.getAttribute("commandId");
		mapofds.put("commandId",commandId);
		map = medicalExamHandlerService.pendingClwatingList(mapofds);
		jsp = "mb_medicalCommandLevelList.jsp";
		
	//	jsp += ".jsp";
		title = "Medical Board Proceeding Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView validateMedExam(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int userId = 0;
		int hin_id=0;
		String medicalType=null;		
	    String investigationReferToMH = "";
		Users user = (Users)session.getAttribute("users");
		userId = user.getId(); 
		int visitNumberForReport = 0;
		String hinNoForreport = "";
		int visitId = 0;
		/*if(request.getParameter(FM_DM) != null && !request.getParameter(FM_DM).equals("")){
			box.put("FM_DM",request.getParameter(FM_DM));
		}*/
		//------Added by dipali for form18
		if(request.getParameter(FINAL_OBSERVATION) != null && !request.getParameter(SIGNED_BY).equals("")){
			box.put("FINAL_OBSERVATION",request.getParameter(FINAL_OBSERVATION));
		}
		//-----
		if(request.getParameter(SIGNED_BY) != null && !request.getParameter(SIGNED_BY).equals("")){
			box.put("SIGNED_BY",request.getParameter(SIGNED_BY));
		}
		if(request.getParameter(APPROVED_BY) != null && !request.getParameter(APPROVED_BY).equals("")){
			box.put("APPROVED_BY",request.getParameter(APPROVED_BY));
		}
		if(request.getParameter(SEND_TO) != null && !request.getParameter(SEND_TO).equals("")){
			box.put("SEND_TO",request.getParameter(SEND_TO));
		}
		if(request.getParameter(MED_CAT_REC) != null && !request.getParameter(MED_CAT_REC).equals("")){
			box.put("MED_CAT_REC",request.getParameter(MED_CAT_REC));
		}
		if(request.getParameter(MEDICIN_REMARKS) != null && !request.getParameter(MEDICIN_REMARKS).equals("")){
			box.put("MEDICIN_REMARKS",request.getParameter(MEDICIN_REMARKS));
		}
		
		if(request.getParameter("MissTeeth") != null && !request.getParameter("MissTeeth").equals("")){
			box.put("MissTeeth",request.getParameter("MissTeeth"));
		}
		if(request.getParameter("UnserTeeth") != null && !request.getParameter("UnserTeeth").equals("")){
			box.put("UnserTeeth",request.getParameter("UnserTeeth"));
		}
		int medExamId =0; 
		if(request.getParameter("medExamId") != null){
			medExamId = Integer.parseInt(request.getParameter("medExamId").toString());
		}
		if(request.getParameter("visitId") != null){
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		if(request.getParameter("visitNumberForReport") != null){
			visitNumberForReport = Integer.parseInt(request.getParameter("visitNumberForReport").toString());
		}
		if(request.getParameter("hinNoForreport")!= null){
			hinNoForreport = (String)request.getParameter("hinNoForreport");
		}
		String medicalExamType = "";
		if(request.getParameter("medicalExamType")!= null){
			medicalExamType = (String)request.getParameter("medicalExamType");
		}
		String dgOrderNO = "";
		if(request.getParameter("dgOrderNO")!= null){
			dgOrderNO = (String)request.getParameter("dgOrderNO");
		}
		if(request.getParameter("medicalType")!= null){
			medicalType = (String)request.getParameter("medicalType");
		}
		String serviceNo = "";
		if(request.getParameter(SERVICE_NO)!= null){
			serviceNo = (String)request.getParameter(SERVICE_NO);
		}
		int unitId = 0;
		if(request.getParameter(UNIT_ID)!= null)
		{
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		}
		if(request.getParameter("hin_id")!= null)
		{
			hin_id= Integer.parseInt(request.getParameter("hin_id"));
		}
		if(request.getParameter("investigationReferToMH") != null)
		{
			investigationReferToMH = request.getParameter("investigationReferToMH");
		}
		box.put("userId", userId);
		String userSrNo = (String)session.getAttribute("userSrNo");
		box.put("userSrNo",userSrNo);
		
		map = medicalExamHandlerService.validateMedExam(box);
		boolean successfullyAdded =false;
		
		if(map.get("successfullyAdded") != null){
			successfullyAdded = (Boolean)map.get("successfullyAdded");
		}
		String message = "";
		String jsp = "";
		if(successfullyAdded)
			message = "Record Validated Successfully";
		else
			message = "Some Problem Occured !!";
		if(map.get("dataMessage")!=null && map.get("dataMessage")!="")
			message=(String)map.get("dataMessage");
		
		//------------------------------------------------------
		if(medicalExamType.equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)"))
		{
			
		     message="Print Report";
		     jsp="mb_annualmedicalExamPrintForMo";
			
		}else if(medicalExamType.equalsIgnoreCase("Primary/Extension Med. Exam(AFMSF-2A)"))
		 {
			message = "Print Report";
			jsp="mb_primaryExtensionMedExam";
	    }
		else if(medicalExamType.equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
	    {	
			message = "Print Report";
		      jsp="mb_examOnReleaseDiscahrge";
			//jsp = "mb_medicalExamPerAuWating";			
	    }	
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		//String jsp = MEDICAL_BOARD_EXAM_MSG;
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{	
		  hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		  mapForDS.put("hospitalId", hospitalId);
		}
		if (request.getParameter("consultingDoc") != null) {
			int empId = Integer.parseInt(request.getParameter("consultingDoc"));
			mapForDS.put("empId", empId);
		}else{
			if(session.getAttribute("users")!=null){
				user = (Users)session.getAttribute("users");
			}
			mapForDS.put("empId", user.getEmployee().getId());
		}
		map = medicalExamHandlerService.showMedicalOfficerAppointment(mapForDS);
		//String jsp = "mb_medicalBoardSearchMedicalOfficerAppointment";
		jsp += ".jsp";
		map.put("printReport", "yes");
		map.put("medExamId", medExamId);
		map.put("hin_id",hin_id);
		map.put("medicalExamType", medicalExamType);
		map.put("serviceNo", serviceNo);
		map.put("unitId", unitId);
		map.put("dgOrderNO", dgOrderNO);
		map.put("medicalType", medicalType);
		map.put("visitNumberForReport", visitNumberForReport);
		map.put("hinNoForreport", hinNoForreport);
		map.put("visitId", visitId);
		map.put("message", message);
		map.put("investigationReferToMH", investigationReferToMH);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView rejectMedExam(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int userId = 0;
		int visitId=0;
		Users user = (Users)session.getAttribute("users");
		userId = user.getId();
	
		if (request.getParameter("visitId") != null) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		box.put("userId", userId);
		box.put("visitId", visitId);
		map = medicalExamHandlerService.rejectMedExam(box);
		boolean successfullyAdded =false;
		if(map.get("successfullyAdded") != null){
			successfullyAdded = (Boolean)map.get("successfullyAdded");
		}
		String message = "";
		if(successfullyAdded)
			message = "Record Rejected!!!";
		else
			message = "Some Problem Occured !!";
		
		map.put("message", message);
		String jsp = MEDICAL_BOARD_EXAM_MSG;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showCommandLevelJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
        int visitId=0;
        String accessjsp=null;
        String jspheading=null;
        if (request.getParameter("medExamType") != null) {
        			jspheading = request.getParameter("medExamType");
        		}
        
		if (request.getParameter("visitId") != null) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		if (request.getParameter("jsp") != null) {
			accessjsp = request.getParameter("jsp");
		}
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		box.put("accessjsp", accessjsp);
		box.put("deptId", deptId);
		map = medicalExamHandlerService.showMedicalOfficerMedExamJsp(box);
		jsp = "mb_medicalBoardExaminationOnAnnualCommandLevelValidation";
		jsp += ".jsp";
		map.put("jspheading", jspheading);
		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView showMedExamRegister(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
        String jsp= "";
		jsp = MEDICAL_EXAM_REGISTER_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
		} 
	public ModelAndView printMedicalExamRegisterReport(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Date from_date = null;
		Date to_date = null;
		if(request.getParameter(FROM_DATE) != null){
		from_date = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if(request.getParameter(TO_DATE) != null){
		to_date = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = medicalExamHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("from_date", from_date);
		parameters.put("hospitalId",hospitalId);
		parameters.put("to_date", to_date);
		HMSUtil.generateReport("medical_exam_register_ame", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
		return null; 
		
	}
	public ModelAndView pendingMDWatingList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapofds = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String searchtype="search";
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int commandId = (Integer) session.getAttribute("commandId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		mapofds.put("commandId",commandId);
		mapofds.put("hospitalId",hospitalId);
		/*int fromrankId=0;
		int toRankId=0;
		int unitId=0;
		int commandid=0;
		String CategoryId=null;
		int tradeId=0;
		int disabilityId=0;
		int disabilityGroupId=0;
		int icdId = 0;
		String AgeFrom=null;
		String to=null;
		String fromTotalService=null;
		String toTotalService=null;
		String group1=null;
		Date DateAson=new Date();
		String weight=null;
		int bloodid=0;
		String LifeStyleFactor=null;
		
		Date IntervalFrom=new Date();
		Date IntervalTo=new Date();
		int Interval=0;
		String gender=null;
		String serviceNo = "";
		
		
		Date fromDate = new Date();
		if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			mapofds.put("fromDate", fromDate);
		}
		Date toDate = new Date();
		if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			mapofds.put("toDate", toDate);
		}
		if (request.getParameter("fromrankId") != null && !(request.getParameter("fromrankId").equals(""))) {
			fromrankId = Integer.parseInt(request.getParameter("fromrankId"));
			mapofds.put("fromrankId", fromrankId);
		}
		if (request.getParameter("toRankId") != null && !(request.getParameter("toRankId").equals(""))) {
			toRankId = Integer.parseInt(request.getParameter("toRankId"));
			mapofds.put("toRankId", toRankId);
		}
		if (request.getParameter("AgeFrom") != null
				&& !(request.getParameter("AgeFrom").equals(""))) {
			AgeFrom = (request.getParameter("AgeFrom"));
			
			mapofds.put("AgeFrom", AgeFrom);
		}if (request.getParameter(TO) != null
				&& !(request.getParameter(TO).equals(""))) {
			to = (request
					.getParameter(TO));
			mapofds.put("to", to);
		}
		if (request.getParameter("fromServ") != null && !(request.getParameter("fromServ").equals(""))) {
			fromTotalService = (request.getParameter("fromServ"));
			mapofds.put("fromTotalService", fromTotalService);
		}
		if (request.getParameter("toServ") != null && !(request.getParameter("toServ").equals(""))) {
			toTotalService = (request.getParameter("toServ"));
			mapofds.put("toTotalService", toTotalService);
		}
		int serviceTypeId = 0;
		if (request.getParameter(SERVICE_TYPE_ID) != null && !(request.getParameter(SERVICE_TYPE_ID).equals(""))) {
			serviceTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
			mapofds.put("serviceTypeId", serviceTypeId);
		}
		int serviceStatusId = 0;
		if (request.getParameter(SERVICE_STATUS_ID) != null && !(request.getParameter(SERVICE_STATUS_ID).equals(""))) {
			serviceStatusId = Integer.parseInt(request.getParameter(SERVICE_STATUS_ID));
			mapofds.put("serviceStatusId", serviceStatusId);
		}
		int rankCategoryId = 0;
		if (request.getParameter(RANK_CATEGORY_ID) != null && !(request.getParameter(RANK_CATEGORY_ID).equals(""))) {
			rankCategoryId = Integer.parseInt(request.getParameter(RANK_CATEGORY_ID));
			mapofds.put("rankCategoryId", rankCategoryId);
		}
		if (request.getParameter(TRADE_ID) != null && !(request.getParameter(TRADE_ID).equals(""))) {
			tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
			mapofds.put("tradeId", tradeId);
		}
		if (request.getParameter("CategoryId") != null && !(request.getParameter("CategoryId").equals(""))) {
			CategoryId = (request.getParameter("CategoryId"));
			mapofds.put("CategoryId", CategoryId);
		}
		
		if (request.getParameter("Gender") != null && !(request.getParameter("Gender").equals(""))) {
			gender = (request.getParameter("Gender"));
			mapofds.put("Gender", gender);
		}
		if (request.getParameter(UNIT_ID) != null && !(request.getParameter(UNIT_ID).equals(""))) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
			mapofds.put("unitId", unitId);
		}
		
		if (request.getParameter(COMMAND) != null && !(request.getParameter(COMMAND).equals(""))) {
			commandid = Integer.parseInt(request.getParameter(COMMAND));
			mapofds.put("commandid", commandid);
		}
		int sectionId = 0;
		if (request.getParameter(SECTION_ID) != null && !(request.getParameter(SECTION_ID).equals(""))) {
			sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
			mapofds.put("sectionId", sectionId);
		}
		
		if(request.getParameter("icd")!= null && !(request.getParameter("icd").equals("")))
		   {
			icdId = Integerrequest.getParameter("icd");
		   }
		if(request.getParameter(SERVICE_NO) != null){
			serviceNo = request.getParameter(SERVICE_NO);
			mapofds.put("serviceNo", serviceNo);
		}
		String rejectStatus = "";
		if(request.getParameter("rejection") != null){
		 rejectStatus = request.getParameter("rejection");
		 mapofds.put("rejectStatus", rejectStatus);
		}
		String overDue = "";
		if(request.getParameter("overdue") != null){
			overDue = request.getParameter("overdue");
			 mapofds.put("overDue", overDue);
		}
		String overWeight = "";
		if(request.getParameter("overWeight") != null){
			overWeight = request.getParameter("overWeight");
			 mapofds.put("overWeight", overWeight);
		}
		
		
		String icdDiag="";
		String systemDiagnosis="";
		if (request.getParameter("icd") != null	&& !(request.getParameter("icd").equals(""))) 
		{
			String str=request.getParameter("icd");
			int lastIndex=str.indexOf("[");
			if(lastIndex>0)
			{   
		    	systemDiagnosis=str.substring(0, lastIndex);
		    	mapofds.put("systemDiagnosis", systemDiagnosis);
		    	icdDiag=systemDiagnosis;
		    	mapofds.put("icdDiag", icdDiag);
			}else{
				systemDiagnosis=str;
			}
			int index1 = str.lastIndexOf("[");
		    int index2 = str.lastIndexOf("]");		    
		    try {
				icdId =Integer.parseInt(str.substring((index1+1),index2));
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			}
			mapofds.put("icdId", icdId); 
			
		}
		
		if (request.getParameter("disabilityId") != null
				&& !(request.getParameter("disabilityId").equals(""))) {
			disabilityId = Integer.parseInt(request
					.getParameter("disabilityId"));
			mapofds.put("disabilityId", disabilityId);
		}
		if (request.getParameter("disabilityGroupId") != null
				&& !(request.getParameter("disabilityGroupId").equals(""))) {
			disabilityGroupId = Integer.parseInt(request
					.getParameter("disabilityGroupId"));
			mapofds.put("disabilityGroupId", disabilityGroupId);
		}
		
		if (request.getParameter("DateAson") != null
				&& !(request.getParameter("DateAson").equals(""))) {
			DateAson = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("DateAson"));
			mapofds.put("DateAson", DateAson);
		}
		
		
		if (request.getParameter("group1") != null
				&& !(request.getParameter("group1").equals(""))) {
			group1 = (request
					.getParameter("group1"));
			mapofds.put("group1", group1);
		}
		if (request.getParameter(WEIGHT) != null
				&& !(request.getParameter(WEIGHT).equals(""))) {
			weight = (request
					.getParameter(WEIGHT));
			mapofds.put("weight", weight);
		}
		if (request.getParameter("LifeStyleFactor") != null
				&& !(request.getParameter("LifeStyleFactor").equals(""))) {
			LifeStyleFactor = (request
					.getParameter("LifeStyleFactor"));
			mapofds.put("LifeStyleFactor", LifeStyleFactor); 
		}
		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& !(request.getParameter(BLOOD_GROUP_ID).equals(""))) {
			bloodid = Integer.parseInt(request
					.getParameter(BLOOD_GROUP_ID));
			mapofds.put("bloodid", bloodid);
		}  
		
		if (request.getParameter("searchtype") != null
				&& !(request.getParameter("searchtype").equals(""))) {
			searchtype = (request
					.getParameter("searchtype"));
			mapofds.put("searchtype", searchtype);
		} 
		if (request.getParameter("IntervalTo") != null
				&& !(request.getParameter("IntervalTo").equals(""))) {
			IntervalTo = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("IntervalTo"));
			mapofds.put("IntervalTo", IntervalTo);
		}
		if (request.getParameter("IntervalFrom") != null
				&& !(request.getParameter("IntervalFrom").equals(""))) {
			IntervalFrom = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("IntervalFrom"));
			mapofds.put("IntervalFrom", IntervalFrom);
		}
		if (request.getParameter("Interval") != null
				&& !(request.getParameter("Interval").equals(""))) {
			Interval = Integer.parseInt(request
					.getParameter("Interval"));
			mapofds.put("Interval", Interval);
		}*/ 
		map = medicalExamHandlerService.pendingMDWatingList(mapofds);
		/*if(mapofds.get("searchtype")!=null && mapofds.get("searchtype").equals("graph"))
         {
			 
			 HMSUtil.generateReport("Clinical_Sheet_Report", map,
						(Connection) map.get("conn"), response,
						getServletContext());
			

        
         }
		 
		
		 if(mapofds.get("searchtype")!=null && mapofds.get("searchtype").equals("graphInjsp"))
         {
			 			ChartRenderingInfo info = new ChartRenderingInfo();
			 
			 

            try {
            	OutputStream out = response.getOutputStream();
			    response.setContentType("image/png");
				ChartUtilities.writeChartAsPNG(out,(JFreeChart)map.get("chart"),600,500,info);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
         }*/
		
		 
			jsp = "mb_medicalExamSearchData.jsp";
			title = "Medical Board Proceeding Search";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("searchtype", searchtype);
			return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView serchPendingMDWatingList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapofds = new HashMap<String, Object>();
		int hospitalId = 0;
		int fromrankId=0;
		int toRankId=0;
		int unitId=0;
		//int commandid=0;
		String CategoryId="";
		int tradeId=0;
		int disabilityId=0;
		int disabilityGroupId=0;
		int icdId = 0;
		String AgeFrom=null;
		String to=null;
		Float fromTotalService=null;
		Float toTotalService=null;
		String group1=null;
		Date DateAson=new Date();
		String weight=null;
		int bloodid=0;
		String LifeStyleFactor=null;
		Date IntervalFrom=new Date();
		Date IntervalTo=new Date();
		int Interval=0;
		int genderId=0;
		String serviceNo = "";
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			mapofds.put("hospitalId",hospitalId);
		}
		/*int commandId = (Integer) session.getAttribute("commandId");
		mapofds.put("commandId",commandId);*/
		
		Date fromDate = new Date();
		if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			mapofds.put("fromDate", fromDate);
		}
		Date toDate = new Date();
		if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			mapofds.put("toDate", toDate);
		}
		if (request.getParameter("fromrankId") != null && !(request.getParameter("fromrankId").equals(""))) {
			fromrankId = Integer.parseInt(request.getParameter("fromrankId"));
			mapofds.put("fromrankId", fromrankId);
		}
		if (request.getParameter("toRankId") != null && !(request.getParameter("toRankId").equals(""))) {
			toRankId = Integer.parseInt(request.getParameter("toRankId"));
			mapofds.put("toRankId", toRankId);
		}
		if (request.getParameter("AgeFrom") != null
				&& !(request.getParameter("AgeFrom").equals(""))) {
			AgeFrom = (request.getParameter("AgeFrom"));
			mapofds.put("AgeFrom", AgeFrom);
		}
		if (request.getParameter(TO) != null
				&& !(request.getParameter(TO).equals(""))) {
			to = (request
					.getParameter(TO));
			mapofds.put("to", to);
		}
		if (request.getParameter("fromServ") != null && !(request.getParameter("fromServ").equals(""))) {
			fromTotalService = Float.parseFloat(request.getParameter("fromServ"));
			mapofds.put("fromTotalService", fromTotalService);
		}
		if (request.getParameter("toServ") != null && !(request.getParameter("toServ").equals(""))) {
			toTotalService = Float.parseFloat(request.getParameter("toServ"));
			mapofds.put("toTotalService", toTotalService);
		}
		String fromServUnit=null;
		String toServUnit=null;
		if (request.getParameter("fromServUnit") != null && !(request.getParameter("fromServUnit").equals(""))) {
			fromServUnit = (request.getParameter("fromServUnit"));
			mapofds.put("fromServUnit", fromServUnit);
		}
		if (request.getParameter("toServUnit") != null && !(request.getParameter("toServUnit").equals(""))) {
			toServUnit = (request.getParameter("toServUnit"));
			mapofds.put("toServUnit", toServUnit);
		}
		int serviceTypeId = 0;
		if (request.getParameter(SERVICE_TYPE_ID) != null && !(request.getParameter(SERVICE_TYPE_ID).equals(""))) {
			serviceTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
			mapofds.put("serviceTypeId", serviceTypeId);
		}
		int serviceStatusId = 0;
		if (request.getParameter(SERVICE_STATUS_ID) != null && !(request.getParameter(SERVICE_STATUS_ID).equals(""))) {
			serviceStatusId = Integer.parseInt(request.getParameter(SERVICE_STATUS_ID));
			mapofds.put("serviceStatusId", serviceStatusId);
		}
		int rankCategoryId = 0;
		if (request.getParameter(RANK_CATEGORY_ID) != null && !(request.getParameter(RANK_CATEGORY_ID).equals(""))) {
			rankCategoryId = Integer.parseInt(request.getParameter(RANK_CATEGORY_ID));
			mapofds.put("rankCategoryId", rankCategoryId);
		}
		if (request.getParameter(TRADE_ID) != null && !(request.getParameter(TRADE_ID).equals(""))) {
			tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
			mapofds.put("tradeId", tradeId);
		}
		if (request.getParameter("CategoryId") != null && !(request.getParameter("CategoryId").equals(""))) {
			CategoryId = request.getParameter("CategoryId");
			mapofds.put("CategoryId", CategoryId);
		}
		
		if (request.getParameter(GENDER) != null && !(request.getParameter(GENDER).equals(""))) {
			genderId =Integer.parseInt(request.getParameter(GENDER));
			mapofds.put("genderId", genderId);
		}
		if (request.getParameter(UNIT_ID) != null && !(request.getParameter(UNIT_ID).equals(""))) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
			mapofds.put("unitId", unitId);
		}
		int commandid = 0;
		if (request.getParameter(COMMAND) != null && !(request.getParameter(COMMAND).equals(""))) {
			commandid = Integer.parseInt(request.getParameter(COMMAND));
			mapofds.put("commandid", commandid);
		}
		int sectionId = 0;
		if (request.getParameter(SECTION_ID) != null && !(request.getParameter(SECTION_ID).equals(""))) {
			sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
			mapofds.put("sectionId", sectionId);
		}
		
		
		if(request.getParameter(SERVICE_NO) != null){
			serviceNo = request.getParameter(SERVICE_NO);
			mapofds.put("serviceNo", serviceNo);
		}
		String rejectStatus = "";
		if(request.getParameter("rejection") != null){
		 rejectStatus = request.getParameter("rejection");
		 mapofds.put("rejectStatus", rejectStatus);
		}
		String overDue = "";
		if(request.getParameter("overdue") != null){
			overDue = request.getParameter("overdue");
			 mapofds.put("overDue", overDue);
		}
		String overWeight = "";
		if(request.getParameter("overWeight") != null){
			overWeight = request.getParameter("overWeight");
			 mapofds.put("overWeight", overWeight);
		}
		
		
		String icdDiag="";
		String systemDiagnosis="";
		if (request.getParameter("icd") != null	&& !(request.getParameter("icd").equals(""))) 
		{
			String str=request.getParameter("icd");
			int lastIndex=str.indexOf("[");
			if(lastIndex>0)
			{   
		    	systemDiagnosis=str.substring(0, lastIndex);
		    	mapofds.put("systemDiagnosis", systemDiagnosis);
		    	icdDiag=systemDiagnosis;
		    	mapofds.put("icdDiag", icdDiag);
			}else{
				systemDiagnosis=str;
			}
			int index1 = str.lastIndexOf("[");
		    int index2 = str.lastIndexOf("]");		    
		    try {
				icdId =Integer.parseInt(str.substring((index1+1),index2));
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			}
			mapofds.put("icdId", icdId); 
			
		}
		
		if (request.getParameter("disabilityId") != null
				&& !(request.getParameter("disabilityId").equals(""))) {
			disabilityId = Integer.parseInt(request
					.getParameter("disabilityId"));
			mapofds.put("disabilityId", disabilityId);
		}
		if (request.getParameter("disabilityGroupId") != null
				&& !(request.getParameter("disabilityGroupId").equals(""))) {
			disabilityGroupId = Integer.parseInt(request
					.getParameter("disabilityGroupId"));
			mapofds.put("disabilityGroupId", disabilityGroupId);
		}
		
		if (request.getParameter("DateAson") != null
				&& !(request.getParameter("DateAson").equals(""))) {
			DateAson = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("DateAson"));
			mapofds.put("DateAson", DateAson);
		}		
		
		if (request.getParameter("group1") != null
				&& !(request.getParameter("group1").equals(""))) {
			group1 = (request
					.getParameter("group1"));
			mapofds.put("group1", group1);
		}
		if (request.getParameter(WEIGHT) != null
				&& !(request.getParameter(WEIGHT).equals(""))) {
			weight = (request
					.getParameter(WEIGHT));
			mapofds.put("weight", weight);
		}
		if (request.getParameter("LifeStyleFactor") != null
				&& !(request.getParameter("LifeStyleFactor").equals(""))) {
			LifeStyleFactor = (request
					.getParameter("LifeStyleFactor"));
			mapofds.put("LifeStyleFactor", LifeStyleFactor); 
		}
		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& !(request.getParameter(BLOOD_GROUP_ID).equals(""))) {
			bloodid = Integer.parseInt(request
					.getParameter(BLOOD_GROUP_ID));
			mapofds.put("bloodid", bloodid);
		}  
		String searchtype="search";
		if (request.getParameter("searchtype") != null
				&& !(request.getParameter("searchtype").equals(""))) {
			searchtype = (request
					.getParameter("searchtype"));
			mapofds.put("searchtype", searchtype);
		} 
		if (request.getParameter("IntervalTo") != null
				&& !(request.getParameter("IntervalTo").equals(""))) {
			IntervalTo = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("IntervalTo"));
			mapofds.put("IntervalTo", IntervalTo);
		}
		if (request.getParameter("IntervalFrom") != null
				&& !(request.getParameter("IntervalFrom").equals(""))) {
			IntervalFrom = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("IntervalFrom"));
			mapofds.put("IntervalFrom", IntervalFrom);
		}
		if (request.getParameter("Interval") != null
				&& !(request.getParameter("Interval").equals(""))) {
			Interval = Integer.parseInt(request
					.getParameter("Interval"));
			mapofds.put("Interval", Interval);
		} 
	
		map = medicalExamHandlerService.serchPendingMDWatingList(mapofds);
		String jsp = "medicalExamStat.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView getICDList(HttpServletRequest request,
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
			map = medicalExamHandlerService.getICDList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "medicalexam_responseForAutoCompleteICD";
		return new ModelAndView(jsp, "map", map);
	}

	
	public ModelAndView showMDLevelJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
        int visitId=0;
        String accessjsp=null;
        String jspheading=null;
        if (request.getParameter("medExamType") != null) {
        			jspheading = request.getParameter("medExamType");
        		}
		if (request.getParameter("visitId") != null) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		if (request.getParameter("jsp") != null) {
			accessjsp = request.getParameter("jsp");
		}
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		box.put("accessjsp", accessjsp);
		box.put("deptId", deptId);
		map = medicalExamHandlerService.showMedicalOfficerMedExamJsp(box);
		jsp = "mb_medicalBoardExaminationOnAnnualMDLevelValidation";
		jsp += ".jsp";
		map.put("jspheading", jspheading);
		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView showReleaseDischargeJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map map = new HashMap();
        int visitId=0;
        String medExamType ="";
		if (request.getParameter("visitId") != null) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		 String search="false"; 
		 if (request.getParameter("search") != null) {
		         	search = request.getParameter("search");
		 		}
		 if (request.getParameter("medExamType") != null) {
			 medExamType = request.getParameter("medExamType");
 		}
		 mapForDS.put("search", search);
		int medExamId=0;
		if (request.getParameter("medExamId") != null) {
		        	medExamId = Integer.parseInt(request.getParameter("medExamId"));
				}
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
		  hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		int deptId = (Integer) session.getAttribute("deptId");
		mapForDS.put("visitId", visitId);
		mapForDS.put("deptId", deptId);
		mapForDS.put("medExamId", medExamId);
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("medExamType", medExamType);
		map = medicalExamHandlerService.showAnnualMedExamJsp(mapForDS);
		jsp = "mb_medicalBoardExaminationOnReleaseDischarge";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search", search);
		map.put("visitId", visitId);
		map.put("jspheading", medExamType);
		// map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView showMedicalOfficerReleaseDischarge(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
        int visitId=0;
        String search="false";
       if (request.getParameter("search") != null) {
              	search = request.getParameter("search");
      		}
      box.put("search", search);
     

		if (request.getParameter("visitId") != null) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		int empId = (Integer) session.getAttribute("empId");
		box.put("empId", empId);	
		box.put("deptId", deptId);
		map = medicalExamHandlerService.showMedicalOfficerMedExamJsp(box);
		if(search.equalsIgnoreCase("true"))
		{
			jsp = "mb_medicalBoardExaminationOnReleaseDischargeMedicalOfficer";
		}else{
			jsp = "mb_medicalBoardExaminationOnReleaseDischargeMO";
		}
		
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		 map.put("search", search);
		// map.put("title", title);
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView showCLReleaseDischarge(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
        int visitId=0;
        String accessjsp=null;
		if (request.getParameter("visitId") != null) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		if (request.getParameter("jsp") != null) {
			accessjsp = request.getParameter("jsp");
		}
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		box.put("accessjsp", accessjsp);
		box.put("deptId", deptId);
		map = medicalExamHandlerService.showMedicalOfficerMedExamJsp(box);
		jsp = "mb_medicalBoardExaminationOnReleaseDischargeCL";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView ReleaseDischargeMD(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
        int visitId=0;
        String accessjsp=null;
		if (request.getParameter("visitId") != null) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		if (request.getParameter("jsp") != null) {
			accessjsp = request.getParameter("jsp");
		}
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		box.put("accessjsp", accessjsp);
		box.put("deptId", deptId);
		map = medicalExamHandlerService.showMedicalOfficerMedExamJsp(box);
		jsp = "mb_medicalBoardExaminationOnReleaseDischargeMD";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	
	@SuppressWarnings("unchecked")
	public ModelAndView showPrimaryMedExamCommandJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
        String accessjsp=null;
		
		if (request.getParameter("jsp") != null) {
			accessjsp = request.getParameter("jsp");
		}
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		box.put("accessjsp", accessjsp);
		box.put("deptId", deptId);
		map = medicalExamHandlerService.showMedicalOfficerMedExamJsp(box);
		jsp = "mb_primaryExtMedExamCommand";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}
	@SuppressWarnings("unchecked")
	public ModelAndView showPrimaryMedExamMDJsp(HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
        String accessjsp=null;
		
		if (request.getParameter("jsp") != null) {
			accessjsp = request.getParameter("jsp");
		}
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		box.put("accessjsp", accessjsp);
		box.put("deptId", deptId);
		map = medicalExamHandlerService.showMedicalOfficerMedExamJsp(box);
		jsp = "mb_primaryExtMedExamMD";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView pendingMedicalExamReport(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalExamHandlerService.pendingMedicalExamReport();
		
		jsp = "pendingMedicalExamjsp";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		

		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showPatientInvestigationReport(
			HttpServletRequest request, HttpServletResponse response) {
		String query = "";
		int hospitalId = 0;
		HttpSession session = request.getSession();
		int visiNo = 0;
		String serviceNo = "";
		String hinNo = "";
		String deptName="";
		int medical_examination_id = 0;
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		try {
			if(request.getParameter("medExamId")!= null){
				medical_examination_id = Integer.parseInt(request.getParameter("medExamId"));
			}
			if (request.getParameter(SERVICE_NO_FOR_REPORT) != null) {
				serviceNo = request.getParameter(SERVICE_NO_FOR_REPORT);
			}
			if (request.getParameter(VISIT_NUMBER_FOR_REPORT) != null) {
				visiNo = Integer.parseInt(request
						.getParameter(VISIT_NUMBER_FOR_REPORT));
			}
			if (request.getParameter(HIN_NO_FOR_REPORT) != null) {
				hinNo = request.getParameter(HIN_NO_FOR_REPORT);
			}
			if(session.getAttribute("deptName")!=null){
				deptName=(String)session.getAttribute("deptName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = medicalExamHandlerService.getConnectionForReport();
        parameters.put("medical_examination_id", medical_examination_id);
		parameters.put("hospitalId", hospitalId);
		parameters.put("visitNo", visiNo);
		parameters.put("serviceNo", serviceNo);
		parameters.put("hinNo", hinNo);
		parameters.put("deptName", deptName);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		// parameters.put("QUERY", query);
		// parameters.put("SUBREPORT_DIR",
		// getServletContext().getRealPath("/reports/"));
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("PatientInvestigationFormatForMed"),
						parameters, (Connection) detailsMap.get("conn"));

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
	public ModelAndView generateCatRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String patientFName = "";
		String orderStatus = "";
		String serviceNo = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		parameters.put("hospitalId", hospitalId);
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
			parameters.put("fromDate", fromDate);
		}

		if (request.getParameter(TO_DATE) != null
						&& !(request.getParameter(TO_DATE).equals(""))) {
					toDate = HMSUtil.convertStringTypeDateToDateType(request
							.getParameter(TO_DATE));
					parameters.put("toDate", toDate);
				}
		if (request.getParameter(SERVICE_NO) != null
						&& !(request.getParameter(SERVICE_NO).equals(""))) {
					serviceNo = request.getParameter(SERVICE_NO);
					parameters.put("serviceNo", serviceNo);
				}
		
		if (request.getParameter(P_FIRST_NAME) != null
						&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
					patientFName = request.getParameter(P_FIRST_NAME);
					parameters.put("patientFName", patientFName);
		}  
		int rankid=0;
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals(""))) {
			rankid = Integer.parseInt(request.getParameter(RANK_ID));
			
} 
		String query="";
		if (toDate != null) {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String today = formatter.format(toDate);
			
			query = query + "where  masmed.categorydate <= to_date('"+ today + "','dd/MM/yyyy' )";
			//query = query + "where masmed.categorydate <= to_date('"+ toDate + "','dd/MM/yyyy') ";
		}
		if (serviceNo != "") {
			query = query + "AND masmed.yearly_serial_no = '"
					+ serviceNo + "' ";
		}
		if (hospitalId != 0) {
			query = query + "AND mas_hospital.hospital_id = '"
					+ hospitalId + "' ";
		}
		
		if (rankid != 0) {
			query = query + "AND mas_rank.rank_id = '"
					+ rankid + "' ";
		}
		String medicaltype="MedicalBoard";
		query = query + "AND masmed.medicalType = '"
		+ medicaltype + "' ";
		
		parameters.put("medicalType","MedicalBoard");
		parameters.put("QUERY", query);
		Map<String, Object> detailsMap = medicalExamHandlerService.getConnectionForReport();
		  try {
              byte[] bytes = null;
              try {
                  bytes = JasperRunManager
                          .runReportToPdf(
                                  getCompiledReport("catRegisterReport"),
                                  parameters, (Connection) detailsMap
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

          } catch (Exception e) {
              e.printStackTrace();
              
          }
 
          return new ModelAndView("indexB", "map", map);
	}
	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());

		return jasperReport;
	}
	
	public ModelAndView catRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalExamHandlerService.pendingMedicalExamReport();
		
		jsp = "catRegisterReportjsp";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		

		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView medBoardRegister(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalExamHandlerService.pendingMedicalExamReport();
		
		jsp = "medBoardRegisterjsp";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		

		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView pendingMedicalBoardReport(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalExamHandlerService.pendingMedicalExamReport();
		
		jsp = "pendingMedicalBoardReportjsp";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		

		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView generatemedBoardRegister(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String patientFName = "";
		String orderStatus = "";
		String serviceNo = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		parameters.put("hospitalId", hospitalId);
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
			parameters.put("fromDate", fromDate);
		}

		if (request.getParameter(TO_DATE) != null
						&& !(request.getParameter(TO_DATE).equals(""))) {
					toDate = HMSUtil.dateFormatterDDMMYYYY(request
							.getParameter(TO_DATE));
					parameters.put("toDate", toDate);
				}
		if (request.getParameter(SERVICE_NO) != null
						&& !(request.getParameter(SERVICE_NO).equals(""))) {
					serviceNo = request.getParameter(SERVICE_NO);
					parameters.put("serviceNo", serviceNo);
				}
		
		if (request.getParameter(P_FIRST_NAME) != null
						&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
					patientFName = request.getParameter(P_FIRST_NAME);
					parameters.put("patientFName", patientFName);
		}
		int rankid=0;
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals(""))) {
			rankid = Integer.parseInt(request.getParameter(RANK_ID));
			
} 
		String query="";
		if (toDate != null) {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String today = formatter.format(toDate);
			
			query = query + "where  masmed.categorydate <= to_date('"+ today + "','dd/MM/yyyy' )";
			//query = query + "where masmed.categorydate <= to_date('"+ toDate + "','dd/MM/yyyy') ";
		}
		if (serviceNo != "") {
			query = query + "AND masmed.yearly_serial_no = '"
					+ serviceNo + "' ";
		}
		if (hospitalId != 0) {
			query = query + "AND mas_hospital.hospital_id = '"
					+ hospitalId + "' ";
		}
		
		if (rankid != 0) {
			query = query + "AND mas_rank.rank_id = '"
					+ rankid + "' ";
		}
		String medicaltype="MedicalBoard";
		query = query + "AND masmed.medicalType = '"
		+ medicaltype + "' ";
		
		parameters.put("medicalType","MedicalBoard");
		parameters.put("QUERY", query);
		parameters.put("medicalType","MedicalBoard");
		Map<String, Object> detailsMap = medicalExamHandlerService.getConnectionForReport();
		  try {
              byte[] bytes = null;
              try {
                  bytes = JasperRunManager
                          .runReportToPdf(
                                  getCompiledReport("RecatRegisterReport"),
                                  parameters, (Connection) detailsMap
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

          } catch (Exception e) {
              e.printStackTrace();
              
          }
 
          return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generatependingMedicalBoardReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String patientFName = "";
		String orderStatus = "";
		String serviceNo = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		parameters.put("hospitalId", hospitalId);
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
			parameters.put("fromDate", fromDate);
		}

		if (request.getParameter(TO_DATE) != null
						&& !(request.getParameter(TO_DATE).equals(""))) {
					toDate = HMSUtil.dateFormatterDDMMYYYY(request
							.getParameter(TO_DATE));
					parameters.put("toDate", toDate);
				}
		if (request.getParameter(SERVICE_NO) != null
						&& !(request.getParameter(SERVICE_NO).equals(""))) {
					serviceNo = request.getParameter(SERVICE_NO);
					parameters.put("serviceNo", serviceNo);
				}
		
		if (request.getParameter(P_FIRST_NAME) != null
						&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
					patientFName = request.getParameter(P_FIRST_NAME);
					parameters.put("patientFName", patientFName);
		}
		int rankid=0;
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals(""))) {
			rankid = Integer.parseInt(request.getParameter(RANK_ID));
			
} 
		String query="";
		if (toDate != null) {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String today = formatter.format(toDate);
			
			query = query + "where  masmed.categorydate > to_date('"+ today + "','dd/MM/yyyy' )";
			//query = query + "where masmed.categorydate <= to_date('"+ toDate + "','dd/MM/yyyy') ";
		}
		if (serviceNo != "") {
			query = query + "AND masmed.yearly_serial_no = '"
					+ serviceNo + "' ";
		}
		if (hospitalId != 0) {
			query = query + "AND mas_hospital.hospital_id = '"
					+ hospitalId + "' ";
		}
		
		if (rankid != 0) {
			query = query + "AND mas_rank.rank_id = '"
					+ rankid + "' ";
		}
		String medicaltype="MedicalBoard";
		query = query + "AND masmed.medicalType = '"
		+ medicaltype + "' ";
		
		parameters.put("medicalType","MedicalBoard");
		parameters.put("QUERY", query);
		parameters.put("medicalType","MedicalBoard");
		Map<String, Object> detailsMap = medicalExamHandlerService.getConnectionForReport();
		  try {
              byte[] bytes = null;
              try {
                  bytes = JasperRunManager
                          .runReportToPdf(
                                  getCompiledReport("MedicalBoardPendingReport"),
                                  parameters, (Connection) detailsMap
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

          } catch (Exception e) {
              e.printStackTrace();
              
          }
 
          return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateMedicalExamReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String patientFName = "";
		String orderStatus = "";
		String serviceNo = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		parameters.put("hospitalId", hospitalId);
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(FROM_DATE));
			parameters.put("fromDate", fromDate);
		}

		if (request.getParameter(TO_DATE) != null
						&& !(request.getParameter(TO_DATE).equals(""))) {
					toDate = HMSUtil.dateFormatterDDMMYYYY(request
							.getParameter(TO_DATE));
					parameters.put("toDate", toDate);
				}
		if (request.getParameter(SERVICE_NO) != null
						&& !(request.getParameter(SERVICE_NO).equals(""))) {
					serviceNo = request.getParameter(SERVICE_NO);
					parameters.put("serviceNo", serviceNo);
				}
		
		if (request.getParameter(P_FIRST_NAME) != null
						&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
					patientFName = request.getParameter(P_FIRST_NAME);
					parameters.put("patientFName", patientFName);
		}
		int rankid=0;
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals(""))) {
			rankid = Integer.parseInt(request.getParameter(RANK_ID));
			
} 
		String query="";
		if (toDate != null) {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String today = formatter.format(toDate);
			
			query = query + "where  masmed.categorydate > to_date('"+ today + "','dd/MM/yyyy' )";
			//query = query + "where masmed.categorydate <= to_date('"+ toDate + "','dd/MM/yyyy') ";
		}
		if (serviceNo != "") {
			query = query + "AND masmed.yearly_serial_no = '"
					+ serviceNo + "' ";
		}
		if (hospitalId != 0) {
			query = query + "AND mas_hospital.hospital_id = '"
					+ hospitalId + "' ";
		}
		
		if (rankid != 0) {
			query = query + "AND mas_rank.rank_id = '"
					+ rankid + "' ";
		}
		String medicaltype="MedicalBoard";
		query = query + "AND masmed.medicalType = '"
		+ medicaltype + "' ";
		
		parameters.put("medicalType","MedicalBoard");
		parameters.put("QUERY", query);
		
		parameters.put("medicalType","MedicalBoard");
		Map<String, Object> detailsMap = medicalExamHandlerService.getConnectionForReport();
		  try {
              byte[] bytes = null;
              try {
                  bytes = JasperRunManager
                          .runReportToPdf(
                                  getCompiledReport("MedicalBoardPendingReport"),
                                  parameters, (Connection) detailsMap
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

          } catch (Exception e) {
              e.printStackTrace();
              
          }
 
          return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView medicalExamDetails(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		Map<String, Object> map = new HashMap<String, Object>();
		//map = medicalExamHandlerService.pendingMedicalExamReport();
		
		jsp = "MedicalExamDetailsjsp";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		

		return new ModelAndView("indexB", "map", map);
	}  
	public ModelAndView getMedicalExamDetails(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		String serviceNo=null;
		Map<String, Object> mapfordata = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		mapfordata.put("hospitalId", hospitalId);
	
			if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		mapfordata.put("serviceNo", serviceNo);
		Users user = (Users)session.getAttribute("users");
		int empId =user.getEmployee().getId();
		int userId=user.getId();
		mapfordata.put("empId", empId);
		map = medicalExamHandlerService.getMedicalExamDetails(mapfordata);
		
		jsp = "medicalExamDetailsForSearch.jsp";
		//jsp="MedicalExamDetailsjsp";
		//jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		

		return new ModelAndView("indexB", "map", map);
	} 
	public void xmlForGraph(List<Object[]> dataList) {
		Map<String, Object> map = new HashMap<String, Object>();

		String ENCODING = "ISO-8859-1";
			try {
				OutputStreamWriter out = new OutputStreamWriter(
						new FileOutputStream(getServletContext().getRealPath(
								"/jsp/chart/amcolumn_data.xml")));
		//		File file=new File("D:\ANUJ\data.xml");
		//		FileOutputStream fio=new FileOutputStream();
				out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING
						+ "\"?>");
				out.write("<chart>");
				out.write("<series>");
				int i=1;
				int j=1;
				  for(Object[] entry:dataList)
           	   {
           		  
           		  String xaxis=entry[1].toString();
				out.write("<value xid="+i+">"+xaxis+"</value>");
           	    i=i+1;
           	   }
				    out.write("</series>");
					out.write("<graphs>");
					out.write("<graph gid='1'>");
				  for(Object[] entry:dataList)
           	   {
            		  String yaxis=entry[0].toString();
            		 out.write("<value yid="+j+" color='FF0F00'>"+yaxis+"</value>");
            	    j=j+1;
            	   }
				
				//out.write("<value xid='0' color='FF0F00'>" + totalReg+ "</value>");
			
				out.write("</graph>");
				out.write("</graphs>");
				out.write("</chart>");
				out.close();
			} catch (RuntimeException e) {
				
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}
	
	public ModelAndView getPrevMedExamFromHIC(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapSmc = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int token = 0;
		String url ="";
		int visitId=0;
		String hinNo="";
		String backFlag = "";
		String serviceNo = request.getParameter("serviceNo");
		mapForDS.put("serviceNo", serviceNo);
		if(request.getParameter("visitId")!=null){
			 visitId = Integer.parseInt(request.getParameter("visitId"));
			
		}
		if(request.getParameter("hinNo")!=null){
			hinNo = request.getParameter("hinNo");
			
		}
		
		mapForDS.put("hinNo", hinNo);
		if(request.getParameter("token")!=null){
			 token = Integer.parseInt(request.getParameter("token"));
			
		}
		if(request.getParameter("backFlag")!=null){
			backFlag = request.getParameter("backFlag");
			
		}
		String medExamType = "";
		if(request.getParameter("jspheading")!= null)
		  {
			medExamType = request.getParameter("jspheading");
		  }
		String FlagFOrMedExamMa="";
		if(request.getParameter("FlagFOrMedExamMa")!= null )
		{
			FlagFOrMedExamMa = request.getParameter("FlagFOrMedExamMa");
		}
		 int medExamId=0;
			if (request.getParameter("medExamId") != null && !request.getParameter("medExamId").equals("") && !request.getParameter("medExamId").equals("null")) {
			        	medExamId = Integer.parseInt(request.getParameter("medExamId"));
					}
		//map = medicalExamHandlerService.getPrevMedExamFromHIC(mapForDS);
		mapSmc = medicalExamHandlerService.getPrevMedExamFromSMC(mapForDS);
		url="/hms/hms/medicalExam?method=showAnnualMedExamJsp";
		if(FlagFOrMedExamMa.equals("medExamMADischarge"))
	     {
		   url = "/hms/hms/medicalExam?method=showReleaseDischargeJsp";
	     }
		String jsp = "";
		if(backFlag.equals("OPD") || backFlag.equals("dental") || backFlag.equals("ipd")){
			 jsp = "opd_previousVisitForMedicalExamp";
			 
		}else{
			map.put("contentJsp", "opd_previousVisitForMedicalExamp.jsp");
			jsp = "index";
		}
		
		
		
		map.put("token", token);
		map.put("mapSmc", mapSmc);
		map.put("url",url);
		map.put("visitId", visitId);
		map.put("backFlag", backFlag);
		map.put("medExamId", medExamId);
		map.put("medExamType",medExamType);
		map.put("FlagFOrMedExamMa", FlagFOrMedExamMa);
		return new ModelAndView(jsp, "map", map);
		
		
		
	}
	public ModelAndView getPrevMedBoardFromHIC(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapSmc = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int visitId = 0;
		int token = 0;
		String backFlag = "";
		String serviceNo = request.getParameter("serviceNo");
		if(request.getParameter("visitId")!=null){
			 visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		if(request.getParameter("token")!=null){
			 token = Integer.parseInt(request.getParameter("token"));
		}
		if(request.getParameter("backFlag")!=null){
			backFlag = request.getParameter("backFlag");
		}
		String medExamType = "";
		if(request.getParameter("jspheading")!= null)
		  {
			medExamType = request.getParameter("jspheading");
		  }
		String FlagFOrMedExamMa="";
		if(request.getParameter("FlagFOrMedExamMa")!= null )
		{
			FlagFOrMedExamMa = request.getParameter("FlagFOrMedExamMa");
		}
		 serviceNo = request.getParameter("serviceNo");
		mapForDS.put("serviceNo", serviceNo);
		mapSmc = medicalExamHandlerService.getPrevMedBoardFromSMC(mapForDS);
		//map = medicalExamHandlerService.getPrevMedBoardFromHIC(mapForDS);		
		String url = "/hms/hms/medicalExam?method=showAnnualMedExamJsp";
		String jsp = "";
		if(backFlag.equals("OPD") || backFlag.equals("dental") || backFlag.equals("ipd")){
			jsp = "opd_previousVisitForMedicalBoard";
		}else{
			
			map.put("contentJsp", "opd_previousVisitForMedicalBoard.jsp");
			jsp = "index";
		}
/*		String jsp = "opd_previousVisitForMedicalBoard";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
*/		
		map.put("visitId", visitId);
		map.put("token", token);
		map.put("backFlag", backFlag);
		map.put("medExamType",medExamType);
		map.put("FlagFOrMedExamMa", FlagFOrMedExamMa);
		map.put("url", url);
	    map.put("mapSmc", mapSmc);
		return new ModelAndView(jsp, "map", map);
		
		
		
	}
	public ModelAndView generateDentalReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		int visit_id=0;
		if (request.getParameter("visit_id") != null
				&& !(request.getParameter("visit_id").equals(""))) {
			visit_id = Integer.parseInt(request.getParameter("visit_id"));
			
} 
		
		
		parameters.put("visit_id", visit_id);
		Map<String, Object> detailsMap = medicalExamHandlerService.getConnectionForReport();
		  try {
              byte[] bytes = null;
              try {
                  bytes = JasperRunManager
                          .runReportToPdf(
                                  getCompiledReport("BlankDentalReport"),
                                  parameters, (Connection) detailsMap
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
              }catch (IOException e) {
                  e.printStackTrace();
                  
              }

          } catch (Exception e) {
              e.printStackTrace();
              
          }
 
          return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView showApprovingAWatingList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId=0;
		if(session.getAttribute("hospitalId")!=null)
		{	
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		map = medicalExamHandlerService.showApprovingAWatingList(hospitalId);
		jsp = "mb_medicalExamAprovalAuWating";
		
		jsp += ".jsp";
		title = "Medical Exam Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showOCUnitWatingList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{	
		  hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = medicalExamHandlerService.showOCUnitWatingList(hospitalId);
		jsp = "mb_medicalExamOCUnit.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showMedicalExamApprovingAuthorityJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
        int visitId=0;
        
        String jspheading=null;
        String search="false";
        if (request.getParameter("medExamType") != null) {
        			jspheading = request.getParameter("medExamType");
        		}
        if (request.getParameter("search") != null) {
        	search = request.getParameter("search");
		}
       
		if (request.getParameter("visitId") != null && request.getParameter("visitId") != "" ) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		int empId = (Integer) session.getAttribute("empId");
		box.put("deptId", deptId);
		box.put("visitId", visitId);
		box.put("search", search);
		box.put("empId", empId);
		map = medicalExamHandlerService.showMedicalOfficerMedExamJsp(box);
		
		if(search.equalsIgnoreCase("true"))
		{
			jsp = "mb_medicalBoardExaminationOnAnnualMedicalOfficer";	
		}else{
			jsp = "mb_medicalBoardExaminationOnAnnualAA";
		}
		
		jsp += ".jsp";
		
		map.put("visitId", visitId);
	    map.put("jspheading", jspheading);
	    map.put("search", search);
		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView showPatientPreviousVisitForViewScreen(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		String title = "";
		if(request.getParameter("deptId")!=null){
			int deptId = Integer.parseInt(request.getParameter("deptId"));
			mapForDS.put("deptId", deptId);
		}
		int visitNo = 0;
		if(request.getParameter("visitNo")!=null){
		Integer.parseInt(request.getParameter("visitNo"));
			mapForDS.put("visitNo", visitNo);
		}
	
		mapForDS.put("hinId", hinId);
	
		map = opdHandlerService.getPreviousPatientVisit(mapForDS);
		if(request.getParameter("visitId")!=null){
			int visitId = Integer.parseInt(request.getParameter("visitId"));
			map.put("visitId", visitId);
		}
		if(request.getParameter("token")!=null){
			int token = Integer.parseInt(request.getParameter("token"));
			map.put("token", token);
		}
		if(request.getParameter("flag")!=null){
			map.put("flag", request.getParameter("flag"));
		}
		map.put("visitNoForJsp", visitNo);
		String jsp = "opd_preVisitForViewMEAA";
	//	jsp += ".jsp";
		title = "Patient Previous Visit";
	/*	map.put("contentJsp", jsp);
		map.put("title", title);*/

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showMedicalExamOCUnitJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
        int visitId=0;
        
        String jspheading=null;
        String search="false";
        if (request.getParameter("medExamType") != null) {
        			jspheading = request.getParameter("medExamType");
        		}
        if (request.getParameter("search") != null) {
        	search = request.getParameter("search");
		}
       
		if (request.getParameter("visitId") != null && request.getParameter("visitId") != "" ) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		int empId = (Integer) session.getAttribute("empId");
		box.put("empId", empId);	

		box.put("deptId", deptId);
		box.put("visitId", visitId);
		box.put("search", search);
		map = medicalExamHandlerService.showMedicalOfficerMedExamJsp(box);

		jsp = "mb_medicalBoardExaminationOnReleaseDischargeOCUnit.jsp";
		map.put("visitId", visitId);
	    map.put("jspheading", jspheading);
	    map.put("search", search);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView validateMedExamApprovingAuthority(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int userId = 0;
		String medicalType=null;
		int medExamId =0; 
		int hin_id = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if(request.getParameter("medExamId") != null){
			medExamId = Integer.parseInt(request.getParameter("medExamId").toString());
		}
		
		if(request.getParameter("hin_id")!= null && !(request.getParameter("hin_id").equals(0)))
		  {    hin_id=Integer.parseInt(request.getParameter("hin_id"));	
		  }
		Users user = (Users)session.getAttribute("users");
		userId = user.getId(); 
		
		box.put("medExamId", medExamId);
		box.put("userId", userId);
		map = medicalExamHandlerService.validateMedExamApprovingAuthority(box);
		boolean successfullyAdded =false;		
		if(map.get("successfullyAdded") != null){
			successfullyAdded = (Boolean)map.get("successfullyAdded");
		}
		String masExamType="";
		if(map.get("masExamType") != null){
			masExamType = (String)map.get("masExamType");
		}
		String message = "";
		if(successfullyAdded)
			message = "Record Validated Successfully !!";
		else
			message = "Some Problem Occured !!";	
		
		String jsp = "";
		String title = "";
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{	
		  hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		/*if(masExamType.equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
		{	
			map = medicalExamHandlerService.showOCUnitWatingList(hospitalId);
			jsp = "mb_medicalExamOCUnit";
		}else
		{
			map = medicalExamHandlerService.showMedicalOfficerAppointment(hospitalId);
			jsp = "mb_medicalExamAprovalAuWating";
		}*/
		if(masExamType.equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)"))
		{
		message="Print Report";
		jsp="mb_annualmedicalExamPrintForAA";
		}
		else if(masExamType.equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
		{
			message = "Print Report";
		      jsp="mb_examOnReleaseDiscahrge";
		}else
		{
			map = medicalExamHandlerService.showApprovingAWatingList(hospitalId);
			jsp = "mb_medicalExamAprovalAuWating";
		}
		jsp += ".jsp";
		map.put("medExamId", medExamId);
		map.put("hin_id", hin_id);
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showMedicalExamPerAuthority(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{	
		  hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = medicalExamHandlerService.showMedicalExamPerAuthority(hospitalId);
		jsp = "mb_medicalExamPerAuWating";
		
		jsp += ".jsp";
		title = "Medical Board Proceeding Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showMedicalExamPersuingAuthorityJsp(
			HttpServletRequest request, HttpServletResponse response)
	{
		String jsp = "";
		
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
        int visitId=0;
        
        String jspheading=null;
        String search="false";
        if (request.getParameter("medExamType") != null) {
        			jspheading = request.getParameter("medExamType");
        		}
        if (request.getParameter("search") != null) {
        	search = request.getParameter("search");
		}
       
		if (request.getParameter("visitId") != null && request.getParameter("visitId") != "" ) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		int empId = (Integer) session.getAttribute("empId");
		box.put("empId", empId);
		box.put("deptId", deptId);
		box.put("visitId", visitId);
		box.put("search", search);
		map = medicalExamHandlerService.showMedicalOfficerMedExamJsp(box);
		if(jspheading.equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
		{
			jsp = "mb_medicalBoardExaminationOnReleaseDischargePA";
		}else{
		jsp = "mb_medicalBoardExaminationOnAnnualPA";
		}
		jsp += ".jsp";
		
		map.put("visitId", visitId);
	    map.put("jspheading", jspheading);
	    map.put("search", search);
		map.put("contentJsp", jsp);
		// map.put("title", title);
		return new ModelAndView("index", "map", map);

	}
	public ModelAndView validateMedExamPersusingAuthority(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int userId = 0;
		String medicalType=null;
		Users user = (Users)session.getAttribute("users");
		userId = user.getId();
		String date="";
		int hin_id=0;
		if(request.getParameter("paFinalObservation") != null && !request.getParameter("paFinalObservation").equals("")){
			dataMap.put("paFinalObservation",request.getParameter("paFinalObservation"));
		}
		if(request.getParameter("paRemarks") != null && !request.getParameter("paRemarks").equals("")){
			dataMap.put("paRemarks",request.getParameter("paRemarks"));
		}
		if(request.getParameter("paSignedBy") != null && !request.getParameter("paSignedBy").equals("")){
			dataMap.put("paSignedBy",request.getParameter("paSignedBy"));
		}
		if(request.getParameter("paSendTo") != null && !request.getParameter("paSendTo").equals("")){
			dataMap.put("paSendTo",request.getParameter("paSendTo"));
		}
		String dgOrderNO = "";
		if(request.getParameter("dgOrderNO")!= null){
			dgOrderNO = (String)request.getParameter("dgOrderNO");
			
		}
		if(request.getParameter(LAST_CHANGED_DATE)!=null){
			date=request.getParameter(LAST_CHANGED_DATE);
		}
		String medicalExamType = "";
		if(request.getParameter("medicalExamType")!= null){
			medicalExamType = (String)request.getParameter("medicalExamType");
		}
		int medExamId =0; 
		if(request.getParameter("medExamId") != null){
			medExamId = Integer.parseInt(request.getParameter("medExamId").toString());
			dataMap.put("medExamId",medExamId);
		}
		if(request.getParameter("hin_id") != null)
		{
			hin_id= Integer.parseInt(request.getParameter("hin_id"));
		}
		dataMap.put("userId", userId);
		dataMap.put("date", date);
		map = medicalExamHandlerService.validateMedExamPersusingAuthority(dataMap);
		boolean successfullyAdded =false;
		
		if(map.get("successfullyAdded") != null){
			successfullyAdded = (Boolean)map.get("successfullyAdded");
		}
		String message = "";
		if(successfullyAdded)
			message = "Record Validated Successfully !!";
		else
			message = "Some Problem Occured !!";
		
		
		String jsp = "";
		String title = "";
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{	
		  hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = medicalExamHandlerService.showMedicalExamPerAuthority(hospitalId);
		jsp = "mb_medicalExamPerAuWating";
		if(medicalExamType.equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)"))
		{
		message=" Print Report";
		jsp="mb_annualmedicalExamPrint";
		}else if(medicalExamType.equalsIgnoreCase("Primary/Extension Med. Exam(AFMSF-2A)"))
		 {
			message = " Print Report ";
			jsp="mb_primaryExtensionMedExam";
	    }else if(medicalExamType.equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
	    {
	    	message = "Print Report";
	    	jsp="mb_examOnReleaseDiscahrge";
	    	//map = medicalExamHandlerService.showMedicalExamPerAuthority(hospitalId);
			//jsp = "mb_medicalExamPerAuWating";
			
	    }
	    	
		
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("printReport", "yes");
		map.put("medExamId", medExamId);
		map.put("hin_id", hin_id);
		map.put("medicalExamType", medicalExamType);
		map.put("dgOrderNO", dgOrderNO);
		map.put("medicalType", medicalType);
		map.put("message", message);
		map.put("date", date);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView rejectMedExamAA(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int userId = 0;
		int visitId=0;
		Users user = (Users)session.getAttribute("users");
		userId = user.getId();
	
		box.put("userId", userId);
		map = medicalExamHandlerService.rejectMedExamAA(box);
		boolean successfullyAdded =false;
		if(map.get("successfullyAdded") != null){
			successfullyAdded = (Boolean)map.get("successfullyAdded");
		}
		String message = "";
		if(successfullyAdded)
			message = "Record Rejected.";
		else
			message = "Some Problem Occured.";
		int hospitalId=0;
		
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{	
		  hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		  mapForDS.put("hospitalId", hospitalId);
		}
		if (request.getParameter("consultingDoc") != null) {
			int empId = Integer.parseInt(request.getParameter("consultingDoc"));
			mapForDS.put("empId", empId);
		}else{
			if(session.getAttribute("users")!=null){
				user = (Users)session.getAttribute("users");
			}
			mapForDS.put("empId", user.getEmployee().getId());
		}
		String masExamType="";
		String jsp="";
		if(map.get("masExamType") != null){
			masExamType = (String)map.get("masExamType");
		}
		if(masExamType.equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
		{	
			map = medicalExamHandlerService.showOCUnitWatingList(hospitalId);
			jsp = "mb_medicalExamOCUnit";
		}else
		{
			map = medicalExamHandlerService.showMedicalOfficerAppointment(mapForDS);
			jsp = "mb_medicalExamAprovalAuWating";
		}
		map.put("message", message);
		//String jsp = "messageForMedicalExamRejected";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView rejectMedExamPA(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int userId = 0;
		int visitId=0;
		Users user = (Users)session.getAttribute("users");
		userId = user.getId();
		int medExamId =0; 
		if(request.getParameter("medExamId") != null){
			medExamId = Integer.parseInt(request.getParameter("medExamId").toString());
			
		}
		if(request.getParameter("paFinalObservation") != null && !request.getParameter("paFinalObservation").equals("")){
			dataMap.put("paFinalObservation",request.getParameter("paFinalObservation"));
		}
		if(request.getParameter("paRemarks") != null && !request.getParameter("paRemarks").equals("")){
			dataMap.put("paRemarks",request.getParameter("paRemarks"));
		}
		if(request.getParameter("paSignedBy") != null && !request.getParameter("paSignedBy").equals("")){
			dataMap.put("paSignedBy",request.getParameter("paSignedBy"));
		}
		dataMap.put("medExamId",medExamId);
		dataMap.put("userId", userId);
		map = medicalExamHandlerService.rejectMedExamPA(dataMap);
		boolean successfullyAdded =false;
		if(map.get("successfullyAdded") != null)
		{
			successfullyAdded = (Boolean)map.get("successfullyAdded");
		}
		String message = "";
		if(successfullyAdded)
			message = "Record Rejected.";
		else
			message = "Some Problem Occured.";
		
		
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{	
		  hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		String jsp="";
		map = medicalExamHandlerService.showMedicalExamPerAuthority(hospitalId);
		jsp = "mb_medicalExamPerAuWating";
		
		jsp += ".jsp";
		map.put("message", message);
	    map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printAnnualMedicalExam(HttpServletRequest request,HttpServletResponse response)
	{
		 int medical_examination_id = 0;
		 String order_no = "";
		 String IAF="";
		 String ProceedingAbroad="";
		 String FitnessProceedingAbroad="";
		 String MedicalCard="";
		 String proceedingoncourse="";
		 int hin_id=0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> parameters= new HashMap<String,Object>();
		if(request.getParameter("medExamId")!= null){
			medical_examination_id = Integer.parseInt(request.getParameter("medExamId"));
			
		}
		if(request.getParameter("hin_id")!= null)
		 {
			hin_id= Integer.parseInt(request.getParameter("hin_id"));
		 }
		if(request.getParameter("order_no")!= null)
		  {
			order_no = request.getParameter("order_no");
			
		  }
		if(request.getParameter("IAFPrint") != null)
		  {
			IAF = request.getParameter("IAFPrint");			
			parameters.put("IAF", IAF);
		  }
		if(request.getParameter("ProceedingAbroad") != null)
		  {
			 ProceedingAbroad = request.getParameter("ProceedingAbroad");			
			 parameters.put("ProceedingAbroad", ProceedingAbroad); 			
		  }
		 if(request.getParameter("FitnessProceedingAbroad") != null)
		  { 			 
			 FitnessProceedingAbroad = request.getParameter("FitnessProceedingAbroad");				 
			 parameters.put("FitnessProceedingAbroad", FitnessProceedingAbroad);			 
		  }
		 if(request.getParameter("MedicalCard") != null)
		  {  
			 MedicalCard = request.getParameter("MedicalCard");				
			 parameters.put("MedicalCard", MedicalCard);
		  }
		 if(request.getParameter("proceedingoncourse") != null)
		  { 
			 proceedingoncourse = request.getParameter("proceedingoncourse");
			 parameters.put("proceedingoncourse", proceedingoncourse);			 
		  }
		Map<String,Object> detailsMap=new HashMap<String,Object>();
		detailsMap = medicalExamHandlerService.getConnectionForReport();		
		parameters.put("medical_examination_id", medical_examination_id);
		parameters.put("order_no", order_no);
		parameters.put("hin_id", hin_id);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
		"/reports/")); 		  
		HMSUtil.generateReport("AnnualMedicalExaminationReport", parameters, (Connection)detailsMap.get("conn") , response, getServletContext());			
		return null;
		
	}
	public ModelAndView printReportForMa(HttpServletRequest request,HttpServletResponse response)
	{  
		String medicalExamType = "";
		int medical_examination_id = 0;
		if(request.getParameter("medExamId")!= null)
		{
			medical_examination_id = Integer.parseInt(request.getParameter("medExamId"));
		}
		if(request.getParameter("medicalExamType") != null)
		{
			medicalExamType = request.getParameter("medicalExamType");
			Map<String,Object>  detailsMap=new HashMap<String,Object>();
			detailsMap = medicalExamHandlerService.getConnectionForReport();
			Map<String,Object>  parameters = new HashMap<String,Object>();
			parameters.put("medical_examination_id", medical_examination_id);			
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
			"/reports/"));
	        if(medicalExamType.equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)"))
	        {	
			  HMSUtil.generateReport("AnnualMedicalExaminationReport", parameters, (Connection)detailsMap.get("conn") , response, getServletContext());
	        }else if(medicalExamType.equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
	        {
			 HMSUtil.generateReport("MedicalExamReportonreleasedischarge", parameters, (Connection)detailsMap.get("conn") , response, getServletContext());
	        }
	        else if(medicalExamType.equalsIgnoreCase("Primary/Extension Med. Exam(AFMSF-2A)"))
	         { 
	        	HMSUtil.generateReport("primarymedical_examinationreport", parameters, (Connection)detailsMap.get("conn"), response, getServletContext());
	         }
		}
		return null;
	}
	public ModelAndView printExamOnReleaseDischarge(HttpServletRequest request,HttpServletResponse response)
	{
		int medical_examination_id = 0;
		 String order_no = "";
		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getParameter("medExamId")!= null){
			medical_examination_id = Integer.parseInt(request.getParameter("medExamId"));
		}
		if(request.getParameter("order_no")!= null)
		  {
			order_no = request.getParameter("order_no");
		  }
		Map<String,Object> detailsMap=new HashMap<String,Object>();
		detailsMap = medicalExamHandlerService.getConnectionForReport();
		Map<String,Object> parameters= new HashMap<String,Object>();
		parameters.put("medical_examination_id", medical_examination_id);
		parameters.put("order_no", order_no);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
		"/reports/"));
		 HMSUtil.generateReport("MedicalExamReportonreleasedischarge", parameters, (Connection)detailsMap.get("conn") , response, getServletContext());
		return null;
	}
	public ModelAndView printPrimaryExtensionReport(HttpServletRequest request,HttpServletResponse response)
	{
		int medical_examination_id = 0;
		 String order_no = "";
		 String nightBlindness="";
		 String interrogationForm="";
		 String priorToRecruitment="";
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> parameters= new HashMap<String,Object>();
		if(request.getParameter("medExamId")!= null)
		{
			medical_examination_id = Integer.parseInt(request.getParameter("medExamId"));
		}
		if(request.getParameter("NightBlindness")!= null)
		  {
			nightBlindness = request.getParameter("NightBlindness");
			parameters.put("nightBlindness", nightBlindness);
		  }
		if(request.getParameter("Interrogationform")!= null)
		  {
			interrogationForm = request.getParameter("Interrogationform");
			parameters.put("interrogationForm", interrogationForm);
		  }
		if (request.getParameter("PriorRecruit")!= null)
		  {
			priorToRecruitment = request.getParameter("PriorRecruit");
			parameters.put("priorToRecruitment", priorToRecruitment);
		  }
		Map <String,Object> detailsMap= new HashMap<String,Object>();
		detailsMap = medicalExamHandlerService.getConnectionForReport();
		parameters.put("medical_examination_id", medical_examination_id);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
		"/reports/")); 
		HMSUtil.generateReport("primarymedical_examinationreport", parameters, (Connection)detailsMap.get("conn") , response, getServletContext());			
		return null;
	}
	public ModelAndView displayFileUpload(HttpServletRequest request,HttpServletResponse response) 
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
		if(request.getParameter("folder")!= null)
		{
			folderName = request.getParameter("folder");
		}
	
		map=medicalExamHandlerService.displayFileUploadData(dataMap);
		String jsp = "medicalExam_uploadpatientdoc";
		//String jsp = "fileuploadPopupMedicalExam";
		map.put("hinNo", hinNo);
		map.put("folderName", folderName);
		map.put("hinId", hinId);
		map.put("masExamId",masExamId);
		map.put("visitId", visitId);
	
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView displayFileUploadInvestigation(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int invest_id = 0;
		int hinId = 0;
		String hinNo="";
		int masExamId=0;
		int visitId=0;
		if(request.getParameter("masExamId")!=null )
        {
			masExamId = Integer.parseInt( request.getParameter("masExamId"));
			
        }
		
		if(request.getParameter("visitId")!=null )
		{
		   	visitId=Integer.parseInt(request.getParameter("visitId"));
		   	
		}
		if(request.getParameter("hinNo")!= null)
		{
			hinNo = request.getParameter("hinNo");
		}
		if(request.getParameter("hinId")!=null )
        {
			hinId = Integer.parseInt( request.getParameter("hinId"));
        }
		
		if(request.getParameter("invest_id")!=null )
		{
			invest_id=Integer.parseInt(request.getParameter("invest_id"));
		}
		dataMap.put("masExamId", masExamId);
		dataMap.put("hinId", hinId);
		dataMap.put("visitId", visitId);
		
		map=medicalExamHandlerService.displayFileUploadData(dataMap);
		String jsp = "medicalExam_uploadInvestdoc";
	
		//String jsp = "fileuploadPopupMedicalExamInvest";
		
		map.put("masExamId", masExamId);
		map.put("hinId", hinId);
		map.put("hinNo", hinNo);
		map.put("visitId", visitId);
		map.put("invest_id", invest_id);
	
		return new ModelAndView(jsp, "map", map);
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
        if(request.getParameter("hin_id")!=null )
        {
        	hinId = Integer.parseInt(request.getParameter("hin_id"));
        	dataMap.put("hinId", hinId);
        }
        String folderName="";
        if(request.getParameter("folderName")!=null )
        {
        	folderName =request.getParameter("folderName");
        	dataMap.put("folderName", folderName);
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
        
       // Map<String, Object> uploadFileMap = new HashMap<String, Object>();
		/*String userHome = getServletContext().getRealPath("");
 		String fileSeparator = System.getProperty("file.separator");
 		String uploadURL = userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"HMSDocumentFolder"+fileSeparator+"upload"+fileSeparator+folderName+fileSeparator;
 		HMSUtil.createFolderFroDocument(hin_no, uploadURL);
		List fileUploadedList = null;
		*/
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
				/*	String whiteList = "*." + fileExtension;

				  fileUploadedList=HMSUtil.uploadFileMedicalExam(mrequest,uploadURL+hin_no+fileSeparator, whiteList, request.getParameter("filename" + i),i);
					
				fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL
						+ hin_no + fileSeparator, whiteList, request
						.getParameter("filename" + i), i);
				box.put("filename" + i, request.getParameter("filename" + i));
				box.put("description" + i, mrequest.getParameter("description"
						+ i));
				box.put("fileExtension" + i, fileExtension);*/
			}
		}
		
		dataMap.put("fileNameList", fileNameList);
		dataMap.put("fileExtensionList", fileExtensionList);
		dataMap.put("descriptionList", descriptionList);
		dataMap.put("counterList", counterList);
		map=medicalExamHandlerService.submitUploadDocumentsForMedicalExam(dataMap);
		
	/*	if (request.getParameter("filename")!=null)
		{
			
		  StringTokenizer strToken = new StringTokenizer(request.getParameter("filename"), ".");
		  fileName = strToken.nextToken();
		  fileExtension = strToken.nextToken();
		  String whiteList = "*." + fileExtension;
		  fileUploadedList=HMSUtil.uploadFileMedicalExam(mrequest,uploadURL+hin_no+fileSeparator, whiteList, request.getParameter("filename"));
		//  box.put("filename", request.getParameter("filename"));
		}
		
		Boolean fileUploaded = false;
		if (fileUploadedList != null && fileUploadedList.size() != 0) {
			fileUploaded = (Boolean) fileUploadedList.get(0);
		}*/
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
		map=medicalExamHandlerService.displayFileUploadData(dataMap12);
		map.put("message", message);
		map.put("visitId", visitId);
		map.put("hinNo", hin_no);
		map.put("hinId", hinId);
		map.put("folderName", folderName);
		map.put("masExamId",masExamId);
		String jsp = "medicalExam_uploadpatientdoc";
		//String jsp = "fileuploadPopupMedicalExam";
		//jsp += ".jsp";
		
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
		int masMedicalExamId=0;
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
		if(request.getParameter("masExamId")!= null && !request.getParameter("masExamId").equals(""))
		{
			masMedicalExamId= Integer.parseInt(request.getParameter("masExamId"));
			
	     }
			StringTokenizer strToken=new StringTokenizer(filename,".");
			filename=strToken.nextToken();
		   	fileExtension=strToken.nextToken();
		   	
			generalMap.put("filename", filename);
		   	generalMap.put("fileExtension", fileExtension);
		   	generalMap.put("hinId", hinId);
		   	generalMap.put("hospitalId", hospitalId);
		   	generalMap.put("investigationId", investigationId);
		   	generalMap.put("masMedicalExamId", masMedicalExamId);
		   	generalMap.put("mrequest", mrequest);
	     map = medicalExamHandlerService.submitUploadDocuments(generalMap);
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
	     String jsp = "fileuploadPopupMedicalExamInvest";
		// jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("hinNo", hinNo);
		map.put("hinId", hinId);
		map.put("invest_id", investigationId);
		map.put("masExamId", masMedicalExamId);
		
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
        String flagForm="";
        if(request.getParameter("folderName")!=null )
        {
        	folderName = request.getParameter("folderName");
        	dataMap.put("folderName",folderName);
        }
        if(request.getParameter("flagForm")!=null )
        {
        	flagForm = request.getParameter("flagForm");
        	dataMap.put("flagForm",flagForm);
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
        if(request.getParameter("masExam_Id")!=null )
        {
        	masExamId=Integer.parseInt(request.getParameter("masExam_Id"));
        	dataMap.put("masExamId",masExamId);
        }
		
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
     
           map=medicalExamHandlerService.getUploadDocumentDetails(dataMap);
			//String jsp = "medicalExamViewDocumentsPopUp";
			String jsp = "medicalExamViewDocument";
			map.put("hinId", hinId);
			map.put("flagForm", flagForm);
			map.put("folderName", folderName);
			map.put("visitId", visitId);
			map.put("contentJsp", jsp);
			return new ModelAndView(jsp, "map", map);
		
	}
	public ModelAndView viewUploadDocumentsDetailsInvest(HttpServletRequest request,
			HttpServletResponse response)
	{		
		int hospitalId=0;
		int masExamId = 0;
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
        if(request.getParameter("masExamId")!=null )
        {
        	masExamId = Integer.parseInt(request.getParameter("masExamId"));
        }
        if (session.getAttribute(HOSPITAL_ID) != null) 
		{
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
        dataMap.put("hinId", hinId);
        dataMap.put("InvestId", InvestId);
        dataMap.put("masExamId", masExamId);
        dataMap.put("hospitalId", hospitalId);
        
        Map<String,Object> map=new HashMap<String,Object>();
          
        map=medicalExamHandlerService.viewUploadJsp(dataMap);
		String jsp = "medicalExamInvestViewDocumentsPopUp";
		//jsp += ".jsp";
		map.put("hin_no", hin_no);	
		return new ModelAndView(jsp, "map", map);
		
	}
	public ModelAndView viewMedicalExamDocuments(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		String filename = null;
		String fileExtension = null;
		String hin_no="";
		HttpSession session = request.getSession();
        if(request.getParameter("hinNo")!=null )
        {
        	hin_no = (String) request.getParameter("hinNo");
        }
        String fileNameFinal="";
        if(request.getParameter("filename")!=null )
        {
        	filename = (String) request.getParameter("filename");
        }
        String folderName="";
        if(request.getParameter("folderName")!=null )
        {
        	folderName = (String) request.getParameter("folderName");
        }
		//String uploadURL = getServletContext().getRealPath("/upload/");
        String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
	
        String uploadURL = userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"HMSDocumentFolder"+fileSeparator+"upload"+fileSeparator+folderName+fileSeparator+hin_no;
		
        StringTokenizer st1 = new StringTokenizer(filename,".");
		fileNameFinal = st1.nextToken();
		fileExtension = st1.nextToken();

		try {
			if (fileExtension == "doc" || fileExtension == "docx") {
				response.setContentType("application/vnd.ms-word");
			} else if (fileExtension == "xls" || fileExtension == "xlsx") {
				response.setContentType("application/vnd.ms-excel");
			} else if (fileExtension == "pdf") {
				response.setContentType("application/pdf");
			} else if (fileExtension.trim().equalsIgnoreCase("txt")) {
				response.setContentType("text/plain");
			} else if (fileExtension.trim().equalsIgnoreCase("ppt")) {
				response.setContentType("application/ppt");
			} else if (fileExtension == "png") {
				response.setContentType("image/png");
			} else if (fileExtension == "jpeg") {
				response.setContentType("image/jpeg");
			} else if (fileExtension == "wbmp") {
				response.setContentType("image/vnd.wap.wbmp");
			} else if (fileExtension == "gif") {
				response.setContentType("image/gif");
			} else if (fileExtension == "jpg") {
				response.setContentType("image/jpg");
			} else {
				response.setContentType("application/octet-stream");
			}
			// set the header and also the Name by which user will be prompted
			// to save
			response.setHeader("Content-Disposition", "attachment;filename="
					+ java.net.URLEncoder.encode(filename)
					+ "");

		
			File f = new File(uploadURL + "/" + fileNameFinal + "." + fileExtension);
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

		return null;
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
        int medExamId=0;
        if(request.getParameter("medExamId")!=null )
        {
        	medExamId = Integer.parseInt(request.getParameter("medExamId"));
        }int hospitalId=0;
        if (session.getAttribute(HOSPITAL_ID) != null) 
		{
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
	   dataMap.put("filename", filename);
	   dataMap.put("fileExtension", fileExtension);
	   dataMap.put("invest_id", invest_id);
	   dataMap.put("hinId", hinId);
	   dataMap.put("medExamId", medExamId);
	   dataMap.put("hospitalId", hospitalId);	
	   map=medicalExamHandlerService.viewUploadInvestDocument(dataMap);
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
	public ModelAndView showMedicalExamPerAuthorityAFRO(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String title = "";
		HttpSession session = request.getSession();
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{	
		  hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = medicalExamHandlerService.showMedicalExamPerAuthorityAFRO(hospitalId);
		jsp = "mb_medicalExamPerAuWatingAFRO";		
		jsp += ".jsp";
		title = "Medical Board Proceeding Search";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showMedicalExamPersuingAuthorityAFROJsp(
			HttpServletRequest request, HttpServletResponse response)
	{
		String jsp = "";
		
		Map map = new HashMap();
		Box box = HMSUtil.getBox(request);
        int visitId=0;
        
        String jspheading=null;
        String search="false";
        if (request.getParameter("medExamType") != null) {
        			jspheading = request.getParameter("medExamType");
        		}
        if (request.getParameter("search") != null) {
        	search = request.getParameter("search");
		}
       
		if (request.getParameter("visitId") != null && request.getParameter("visitId") != "" ) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		int empId = (Integer) session.getAttribute("empId");
		box.put("empId", empId);	

		box.put("deptId", deptId);
		box.put("visitId", visitId);
		box.put("search", search);
		map = medicalExamHandlerService.showMedicalOfficerMedExamJsp(box);
		jsp = "mb_medicalBoardExaminationOnReleaseDischargePAAFRO";
		
		jsp += ".jsp";
		
		map.put("visitId", visitId);
	    map.put("jspheading", jspheading);
	    map.put("search", search);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}
	
	public ModelAndView validateMedExamPersusingAuthorityAFRO(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int userId = 0;
		String medicalType=null;
		Users user = (Users)session.getAttribute("users");
		userId = user.getId(); 
		if(request.getParameter("paAFROFinalObservation") != null && !request.getParameter("paAFROFinalObservation").equals("")){
			dataMap.put("paAFROFinalObservation",request.getParameter("paAFROFinalObservation"));
		}
		if(request.getParameter("paAFRORemarks") != null && !request.getParameter("paAFRORemarks").equals("")){
			dataMap.put("paAFRORemarks",request.getParameter("paAFRORemarks"));
		}
		if(request.getParameter("paAFROSignedBy") != null && !request.getParameter("paAFROSignedBy").equals("")){
			dataMap.put("paAFROSignedBy",request.getParameter("paAFROSignedBy"));
		}
		int medExamId =0; 
		if(request.getParameter("medExamId") != null){
			medExamId = Integer.parseInt(request.getParameter("medExamId").toString());
			dataMap.put("medExamId",medExamId);
		}
		String medicalExamType = "";
		if(request.getParameter("medicalExamType") != null)
		{
			medicalExamType = request.getParameter("medicalExamType");
		}
		dataMap.put("userId", userId);
		map = medicalExamHandlerService.validateMedExamPersusingAuthorityAFRO(dataMap);
		boolean successfullyAdded =false;
		
		if(map.get("successfullyAdded") != null){
			successfullyAdded = (Boolean)map.get("successfullyAdded");
		}
		String message = "";
		if(successfullyAdded)
			message = "Record Validated Successfully !!";
		else
			message = "Some Problem Occured !!";
		
		
		String jsp = "";
		String title = "";
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{	
		  hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = medicalExamHandlerService.showMedicalExamPerAuthorityAFRO(hospitalId);
	    jsp = "mb_medicalExamPerAuWatingAFRO";
		
	/*	if(medicalExamType.equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)"))
		{
		message="Do You Want To Print Report?";
		jsp="mb_annualmedicalExamPrint";
		}*/ 
		if(medicalExamType.equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
		{
			message = "Do You Want Print Report ?";
		      jsp="mb_examOnReleaseDiscahrge";

		}
		     
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("printReport", "yes");
		map.put("medExamId", medExamId);
		map.put("medicalExamType", medicalExamType);
		//map.put("dgOrderNO", dgOrderNO);
		map.put("medicalType", medicalType);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView rejectMedExamPAAFRO(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int userId = 0;
		int visitId=0;
		Users user = (Users)session.getAttribute("users");
		userId = user.getId();
		int medExamId =0; 
		if(request.getParameter("medExamId") != null){
			medExamId = Integer.parseInt(request.getParameter("medExamId").toString());
			
		}
		if(request.getParameter("paAFROFinalObservation") != null && !request.getParameter("paAFROFinalObservation").equals("")){
			dataMap.put("paAFROFinalObservation",request.getParameter("paAFROFinalObservation"));
		}
		if(request.getParameter("paAFRORemarks") != null && !request.getParameter("paAFRORemarks").equals("")){
			dataMap.put("paAFRORemarks",request.getParameter("paAFRORemarks"));
		}
		if(request.getParameter("paAFROSignedBy") != null && !request.getParameter("paAFROSignedBy").equals("")){
			dataMap.put("paAFROSignedBy",request.getParameter("paAFROSignedBy"));
		}
		
		dataMap.put("medExamId",medExamId);
		dataMap.put("userId", userId);
		map = medicalExamHandlerService.rejectMedExamPAAFRO(dataMap);
		boolean successfullyAdded =false;
		if(map.get("successfullyAdded") != null)
		{
			successfullyAdded = (Boolean)map.get("successfullyAdded");
		}
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{	
		  hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		String message = "";
		if(successfullyAdded)
			message = "Record Rejected.";
		else
			message = "Some Problem Occured.";
		
		
		map = medicalExamHandlerService.showMedicalExamPerAuthorityAFRO(hospitalId);
		String jsp = "mb_medicalExamPerAuWatingAFRO";
			jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView printAnnualMedicalExamReport(HttpServletRequest request,HttpServletResponse response)
	{
		 int medical_examination_id = 0;
		 int visit_id=0;
		 String order_no = "";
		 String medicalExamType = "";
		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getParameter("medExamId")!= null){
			medical_examination_id = Integer.parseInt(request.getParameter("medExamId"));
						
		}
		if(request.getParameter("medicalExamType")!= null )
		  {
			medicalExamType = request.getParameter("medicalExamType");
		  }
		System.out.println("medicalExamType="+medicalExamType);
		System.out.println("medical_examination_id="+medical_examination_id);
		Map<String,Object> detailsMap=new HashMap<String,Object>();
		List<MasMedicalExaminationReportOnEntry> masMedicalExamList=medicalExamHandlerService.getMedicalExamRecord(medical_examination_id);
		String masExamType="";
		if(masMedicalExamList.size()>0)
		{
			MasMedicalExaminationReportOnEntry masMedicalExam=masMedicalExamList.get(0);
			masExamType=masMedicalExam.getMedicalExamType();
			visit_id = masMedicalExam.getVisit().getId();
		}
		detailsMap = medicalExamHandlerService.getConnectionForReport();
		Map<String,Object> parameters= new HashMap<String,Object>();
		parameters.put("medical_examination_id", medical_examination_id);
		System.out.println("medical_examination_id="+medical_examination_id);
		parameters.put("visit_id", visit_id);
		
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
		"/reports/"));
        if(masExamType != null && masExamType.equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)"))
        {	
		  HMSUtil.generateReport("AnnualMedicalExaminationReport", parameters, (Connection)detailsMap.get("conn") , response, getServletContext());
        }else if(masExamType != null && masExamType.equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)"))
        {
		 HMSUtil.generateReport("MedicalExamReportonreleasedischarge", parameters, (Connection)detailsMap.get("conn") , response, getServletContext());
        }
        else if(masExamType != null && masExamType.equalsIgnoreCase("Initial Medical Board AFMSF 15"))
        {
		 HMSUtil.generateReport("mb_proceeding_initial_afmsfNew", parameters, (Connection)detailsMap.get("conn") , response, getServletContext());
        }
        else if(masExamType != null && masExamType.equalsIgnoreCase("Medical Board Review AFMSF 15"))
        {
		 HMSUtil.generateReport("mb_proceeding_initial_afmsfNew", parameters, (Connection)detailsMap.get("conn") , response, getServletContext());
        }
        else if (masExamType != null && masExamType.equalsIgnoreCase("Primary/Extension Med. Exam(AFMSF-2A)")) 
        {
    		HMSUtil.generateReport("primarymedical_examinationreport", parameters,(Connection) detailsMap.get("conn"), response,getServletContext());
    	}
       
		 return null;
	}
	
		public ModelAndView showMedicalExamRegisterGraph(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute(HOSPITAL_ID) != null)
		{
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		dataMap.put("hospitalId", hospitalId);
		String year="";
		if(request.getParameter("year")!= null)
		{
			year= request.getParameter("year");
		}
		String fromYear=year.substring(0,4);
	    String toYear=year.substring(5);
	    dataMap.put("fromYear", fromYear);
	    dataMap.put("toYear", toYear);
		
	    map = medicalExamHandlerService.getMedicalExamRegisterGraph(dataMap);
		List<Object[]> medicalExamRegisterList = new ArrayList<Object[]>();
		medicalExamRegisterList = (List<Object[]>)map.get("medicalExamRegisterList");
		String ENCODING = "ISO-8859-1";
		try {
								
					SAXBuilder  builder = new SAXBuilder();
					File xmlFile = new File(getServletContext().getRealPath("/jsp/chart/amcolumn_medical_exam_settings.xml"));

					Document doc = (Document) builder.build(xmlFile);
					Element rootNode = doc.getRootElement();

					Element graphs = rootNode.getChild("graphs");
					
					int graphsChildsNo = graphs.getChildren().size();
					
					if(graphsChildsNo >0) {
						for (int i = 0; i < graphsChildsNo; i++) {
							graphs.removeChild("graph");
						}
					}
			int j=0;
			for(Object[] objVal : medicalExamRegisterList) {
				Element graph = new Element("graph");
				graph.setAttribute("id", ""+j);
				graphs.addContent(graph);
				String qtrVal=""+objVal[4]+"0-"+(Integer.parseInt(""+objVal[4])+1)+"0";
				Element title = new Element("title").setText(qtrVal);
				graph.addContent(title);
				j++;
			}
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter(getServletContext().getRealPath("/jsp/chart/amcolumn_medical_exam_settings.xml")));
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(getServletContext().getRealPath(
							"/jsp/chart/amcolumn_medical_exam_data.xml")));
		
			out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING
					+ "\"?>");
			out.write("<chart>");
			int i =0;
				out.write("<series>");
				for(int k=1;k<=4;k++)
				{	
					String qtr="";
					qtr="Qtr"+k;
					out.write("<value xid='"+i+"'>"+qtr+"</value>");
					i++;
				}
				out.write("</series>");
				out.write("<graphs>");
				
				int k=0;
				
				for(Object[] objVal : medicalExamRegisterList){
					out.write("<graph gid='"+k+"'>");
					out.write("<value xid='0' >"+objVal[0]+"</value>");
					out.write("<value xid='1' >"+objVal[1]+"</value>");
					out.write("<value xid='2' >"+objVal[2]+"</value>");
					out.write("<value xid='3' >"+objVal[3]+"</value>");
					out.write("</graph>");
					k++;
				}
				out.write("</graphs>");
			out.write("</chart>");
			out.close();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "medicalExamRegisterGraph";
		
		return new ModelAndView(jsp,"map",map);
	}
	//-------------------------- start addMedicalExam method for 2A------------------------
		public ModelAndView addMedicalExaminationBoardAnnual2A(HttpServletRequest req,
				HttpServletResponse res) {
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			String serviceNo = "";
			String rank = "";
			String name = "";
			String unit = "";
			String serviceiaf = "";
			String branch = "";
			Date dob = null;
			String age = "";
			String typeOfCommunication = "";
			Date dateofcommun = null;
			String totalservice = "";
			String pastmedicalhistory = "";
			String presentmedicalhistory = "";
			
			Date entryDate = null;
			Date medicinExamDate = null;
			String lastChangedBy = "";
			String lastChangedTime = "";
			Date lastChangedDate = null;
			int medicalExamHeld = 0;
			String medicalStatus = "";
			String fullName = "";
			Date dateOfBirth = null;
			int maritialStatus = 0;
			String service = "";
			String pNo = "";
			String permanentAddress = "";
			String identification1 = "";
			String identification2 = "";
			Date dateOfReporting = null;

			String withGlassesDistantR = "";
			String withglassesDistantL = "";
			String withGlassesNearR = "";
			String withGlassesNearL = "";
			String withGlassesNearCP = "";
			String withoutGlassesDistantR = "";
			String withoutGlassesDistantL = "";
			String withoutGlassesNearR = "";
			String withoutGlassesNearL = "";
			String withoutGlassesNearCP = "";
			BigDecimal convergenceCP = new BigDecimal(0);

			BigDecimal convergenceC = new BigDecimal(0);
			String accommodationR = "";
			String accommodationL = "";
			String eyeRemarks = "";
			Date eyeDate = null;
			BigDecimal hearingRFW = new BigDecimal(0);
			BigDecimal hearingLFW = new BigDecimal(0);
			BigDecimal hearingBothFW = new BigDecimal(0);
			BigDecimal hearingRCV = new BigDecimal(0);
			BigDecimal hearingLCV = new BigDecimal(0);
			BigDecimal hearingBothCV = new BigDecimal(0);
	       
		
			String dentalRemarks = "";
			String denatlToMH="";
			String totalTeeth = "";
			String totalDefectiveTeeth = "";
			String missingTeeth = "";
			String DenstalPoint = "";
			String unserviceableTeeth = "";
			String CocatHicNevreData="";

			String dur8 = "";
			String dur7 = "";
			String dur6 = "";
			String dur5 = "";
			String dur4 = "";
			String dur3 = "";
			String dur2 = "";
			String dur1 = "";
			String dul8 = "";
			String dul7 = "";
			String dul6 = "";
			String dul5 = "";
			String dul4 = "";
			String dul3 = "";
			String dul2 = "";
			String dul1 = "";
			String dlr8 = "";
			String dlr7 = "";
			String dlr6 = "";
			String dlr5 = "";
			String dlr4 = "";
			String dlr3 = "";
			String dlr2 = "";
			String dlr1 = "";
			String dll8 = "";
			String dll7 = "";
			String dll6 = "";
			String dll5 = "";
			String dll4 = "";
			String dll3 = "";
			String dll2 = "";
			String dll1 = "";
			String mur8 = "";
			String mur7 = "";
			String mur6 = "";
			String mur5 = "";
			String mur4 = "";
			String mur3 = "";
			String mur2 = "";
			String mur1 = "";
			String mul8 = "";
			String mul7 = "";
			String mul6 = "";
			String mul5 = "";
			String mul4 = "";
			String mul3 = "";
			String mul2 = "";
			String mul1 = "";
			String mlr8 = "";
			String mlr7 = "";
			String mlr6 = "";
			String mlr5 = "";
			String mlr4 = "";
			String mlr3 = "";
			String mlr2 = "";
			String mlr1 = "";
			String mll8 = "";
			String mll7 = "";
			String mll6 = "";
			String mll5 = "";
			String mll4 = "";
			String mll3 = "";
			String mll2 = "";
			String mll1 = "";
			String uur8 = "";
			String uur7 = "";
			String uur6 = "";
			String uur5 = "";
			String uur4 = "";
			String uur3 = "";
			String uur2 = "";
			String uur1 = "";
			String uul8 = "";
			String uul7 = "";
			String uul6 = "";
			String uul5 = "";
			String uul4 = "";
			String uul3 = "";
			String uul2 = "";
			String uul1 = "";
			String ulr8 = "";
			String ulr7 = "";
			String ulr6 = "";
			String ulr5 = "";
			String ulr4 = "";
			String ulr3 = "";
			String ulr2 = "";
			String ulr1 = "";
			String ull8 = "";
			String ull7 = "";
			String ull6 = "";
			String ull5 = "";
			String ull4 = "";
			String ull3 = "";
			String ull2 = "";
			String ull1 = "";

			String sur8 = "";
			String sur7 = "";
			String sur6 = "";
			String sur5 = "";
			String sur4 = "";
			String sur3 = "";
			String sur2 = "";
			String sur1 = "";
			String sul8 = "";
			String sul7 = "";
			String sul6 = "";
			String sul5 = "";
			String sul4 = "";
			String sul3 = "";
			String sul2 = "";
			String sul1 = "";

			String slr8 = "";
			String slr7 = "";
			String slr6 = "";
			String slr5 = "";
			String slr4 = "";
			String slr3 = "";
			String slr2 = "";
			String slr1 = "";
			String sll8 = "";
			String sll7 = "";
			String sll6 = "";

			String sll5 = "";
			String sll4 = "";
			String sll3 = "";
			String sll2 = "";
			String sll1 = "";
			String medicalBoardExamination = "";
			int medicalBoardExaminationPlace = 0;
			Date medicalBoardExaminationDate = new Date();
			String subsequentMedicalBoardExam = "";
			int subsequentMedicalBoardExamPlace = 0;
			Date subsequentMedicalBoardExamDate = null;
			HttpSession session = req.getSession();
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			int userId = 0;
			Users user = (Users)session.getAttribute("users");
			userId = user.getId();
			
			int commandId = (Integer) session.getAttribute("commandId");

			Map<String, Object> map = new HashMap<String, Object>();
//			Box box = HMSUtil.getBox(req);
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings = new MasMedicalExaminationReportOnEntry();

			Map<String, Object> generalMap = new HashMap<String, Object>();
			List<MasMedicalBoardExaminationDetail> masMedicalBoardDetails = new ArrayList<MasMedicalBoardExaminationDetail>();

		
			if (req.getParameter(SERVICE_NO) != null) {
				serviceNo = req.getParameter(SERVICE_NO);
			}
		if (req.getParameter(AGE) != null ) {
				age = req.getParameter(AGE);
			}
			if (req.getParameter(TOTAL_SERVICE) != null ) {
				totalservice = req.getParameter(TOTAL_SERVICE);
			}
			if (req.getParameter("serviceiaf") != null ) {
				serviceiaf = req.getParameter("serviceiaf");
			}
			
			
			if (req.getParameter(PAST_MEDICAL_HISTORY) != null ) {
				pastmedicalhistory  = req.getParameter(PAST_MEDICAL_HISTORY);
			}
			String lastame="";
			if (req.getParameter(LAST_AME) != null ) {
				lastame = req.getParameter(LAST_AME);
			}
			int deptId=0;
			int empId=0;
			int hinId=0;
			int visitId=0;
			if (req.getParameter("deptId") != null ) {
				deptId  = Integer.parseInt(req.getParameter("deptId"));
			}
			if (req.getParameter("empId") != null ) {
				empId  = Integer.parseInt(req.getParameter("empId"));
			}
			if (req.getParameter("hinId") != null ) {
				hinId  = Integer.parseInt(req.getParameter("hinId"));
			}
			if (req.getParameter("visitId") != null ) {
				visitId  = Integer.parseInt(req.getParameter("visitId"));
			}
			List<String> chargeCodeIdList = new ArrayList<String>();
			List<Integer> quantityList = new ArrayList<Integer>();
			List<String> investigationReferToMHList=new ArrayList<String>();
			String clinicalNotes1="";
					if (req.getParameter("clinicalNotes1") != null
							&& !(req.getParameter("clinicalNotes1").equals(""))) {
						clinicalNotes1 = req.getParameter("clinicalNotes1");
					}
					
			       int hiddenValue = 1;
					if (Integer.parseInt(req.getParameter("hiddenValue")) != 1) 
					{
						hiddenValue = Integer.parseInt(req.getParameter("hiddenValue"));
					}
					String deleatedValue = "";
					if (req.getParameter("deleatedValue") != "") {
						deleatedValue = req.getParameter("deleatedValue");
						
					}
					mapForDS.put("deleatedValue",deleatedValue);
					int temp = 1;
					List<Integer> patientInvestigationdetailsIdList = new ArrayList<Integer>();
					List<Integer> dgOrderdtIdList = new ArrayList<Integer>();
					String[] chargeCodeIdArr = new String[hiddenValue];
					for (int i = 0; i < hiddenValue; i++) {
						if (req.getParameter("chargeCodeName" + temp) != null
								&& !req.getParameter("chargeCodeName" + temp)
										.equals("")) {

							String chargeCodeNameWithId = req
									.getParameter("chargeCodeName" + temp);
							int index1 = chargeCodeNameWithId.lastIndexOf("[");
							int index2 = chargeCodeNameWithId.lastIndexOf("]");
							index1++;
							String chargeCodeId = chargeCodeNameWithId.substring(index1,
									index2);
							if (!chargeCodeId.equals("")) {
								chargeCodeIdArr[i] = chargeCodeId;
								int qty = 1;
								
								if (req.getParameter("investigationReferToMH" + temp) != null)
								{
									investigationReferToMHList.add("y");
								}else
								{
									investigationReferToMHList.add("n");
								}
							
								chargeCodeIdList.add(chargeCodeIdArr[i]);
								quantityList.add(qty);
							}
						}
						if (req.getParameter("patientInvestigationdetailsId" + temp) != null
								&& !req.getParameter("patientInvestigationdetailsId" + temp)
										.equals("")) {
							patientInvestigationdetailsIdList.add(Integer.parseInt(req.getParameter("patientInvestigationdetailsId" + temp)));
							}
						if (req.getParameter("dgOrderdtId" + temp) != null
								&& !req.getParameter("dgOrderdtId" + temp)
										.equals("")) {
							dgOrderdtIdList.add(Integer.parseInt(req.getParameter("dgOrderdtId" + temp)));
						}
						temp++;
					}

	//----------------------------------------------------------------------------------------------

			

			if (req.getParameter(ENTRY_OF_DATE) != null
					&& !(req.getParameter(ENTRY_OF_DATE).equals(""))) {
				entryDate = HMSUtil.dateFormatterDDMMYYYY(req
						.getParameter(ENTRY_OF_DATE));
			}
			

			if (req.getParameter(MEDICAL_STATUS) != null
					&& !(req.getParameter(MEDICAL_STATUS).equals(""))) {
				medicalStatus = req.getParameter(MEDICAL_STATUS);
			}
			if (req.getParameter(FULL_NAME) != null
					&& !(req.getParameter(FULL_NAME).equals(""))) {
				fullName = req.getParameter(FULL_NAME);
			}

			if (req.getParameter(DATE_OF_BIRTH) != null
					&& !(req.getParameter(DATE_OF_BIRTH).equals(""))) {
				dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(req
						.getParameter(DATE_OF_BIRTH));
			}

			if (req.getParameter(MARITIAL_STATUS) != null
					&& !(req.getParameter(MARITIAL_STATUS).equals(""))) {
				maritialStatus = Integer
						.parseInt(req.getParameter(MARITIAL_STATUS));
			}

			if (req.getParameter(SERVICE) != null
					&& !(req.getParameter(SERVICE).equals(""))) {
				service = req.getParameter(SERVICE);
			}

			
			if (req.getParameter(RANK) != null
					&& !(req.getParameter(RANK).equals(""))) {
				rank = req.getParameter(RANK);
			}

			if (req.getParameter(PERMANENT_ADDRESS) != null
					&& !(req.getParameter(PERMANENT_ADDRESS).equals(""))) {
				permanentAddress = req.getParameter(PERMANENT_ADDRESS);
			}

			if (req.getParameter(IDENTIFICATION_MARKS1) != null
					&& !(req.getParameter(IDENTIFICATION_MARKS1).equals(""))) {
				identification1 = req.getParameter(IDENTIFICATION_MARKS1);
			}

			if (req.getParameter(IDENTIFICATION_MARKS2) != null
					&& !(req.getParameter(IDENTIFICATION_MARKS2).equals(""))) {
				identification2 = req.getParameter(IDENTIFICATION_MARKS2);
			}

			if (req.getParameter(WITH_GLASSES_DISTANT_R) != null
					&& !(req.getParameter(WITH_GLASSES_DISTANT_R).equals(""))) {
				withGlassesDistantR = req.getParameter(WITH_GLASSES_DISTANT_R);
			}
			if (req.getParameter(WITH_GLASSES_DISTANT_L) != null
					&& !(req.getParameter(WITH_GLASSES_DISTANT_L).equals(""))) {
				withglassesDistantL = req.getParameter(WITH_GLASSES_DISTANT_L);
			}
			if (req.getParameter(WITH_GLASSES_NEAR_R) != null
					&& !(req.getParameter(WITH_GLASSES_NEAR_R).equals(""))) {
				withGlassesNearR = req.getParameter(WITH_GLASSES_NEAR_R);
			}
			if (req.getParameter(WITH_GLASSES_NEAR_L) != null
					&& !(req.getParameter(WITH_GLASSES_NEAR_L).equals(""))) {
				withGlassesNearL = req.getParameter(WITH_GLASSES_NEAR_L);
			}
			if (req.getParameter(WITH_GLASSES_NEAR_CP) != null
					&& !(req.getParameter(WITH_GLASSES_NEAR_CP).equals(""))) {
				withGlassesNearCP = req.getParameter(WITH_GLASSES_NEAR_CP);
			}
			if (req.getParameter(WITHOUT_GLASSES_DISTANT_R) != null
					&& !(req.getParameter(WITHOUT_GLASSES_DISTANT_R).equals(""))) {
				withoutGlassesDistantR = req
						.getParameter(WITHOUT_GLASSES_DISTANT_R);
			}
			if (req.getParameter(WITHOUT_GLASSES_DISTANT_L) != null
					&& !(req.getParameter(WITHOUT_GLASSES_DISTANT_L).equals(""))) {
				withoutGlassesDistantL = req
						.getParameter(WITHOUT_GLASSES_DISTANT_L);
			}
			if (req.getParameter(WITHOUT_GLASSES_NEAR_R) != null
					&& !(req.getParameter(WITHOUT_GLASSES_NEAR_R).equals(""))) {
				withoutGlassesNearR = req.getParameter(WITHOUT_GLASSES_NEAR_R);
			}
			if (req.getParameter(WITHOUT_GLASSES_NEAR_L) != null
					&& !(req.getParameter(WITHOUT_GLASSES_NEAR_L).equals(""))) {
				withoutGlassesNearL = req.getParameter(WITHOUT_GLASSES_NEAR_L);
			}
			if (req.getParameter(WITHOUT_GLASSES_NEAR_CP) != null
					&& !(req.getParameter(WITHOUT_GLASSES_NEAR_CP).equals(""))) {
				withoutGlassesNearCP = req.getParameter(WITHOUT_GLASSES_NEAR_CP);
			}
			String evidienceOfTrachoma="";
			if (req.getParameter(ANY_EVIDENCE_OF_TRACHOMA) != null
					&& !(req.getParameter(ANY_EVIDENCE_OF_TRACHOMA).equals(""))) 
	          {
				evidienceOfTrachoma = req.getParameter(ANY_EVIDENCE_OF_TRACHOMA);
	          }
	        String binocular="";
			if (req.getParameter(BINOCULAR_VISION_GRADE) != null
					&& !(req.getParameter(BINOCULAR_VISION_GRADE).equals("")))
	        {
				binocular = req.getParameter(BINOCULAR_VISION_GRADE);
			}

	       masMedicalBoardProceedings.setEvidenceOfTrachoma(evidienceOfTrachoma);
		   masMedicalBoardProceedings.setBinocularVisionGrade(binocular);

					
			if (req.getParameter(HEARING_R_F_W) != null
					&& !(req.getParameter(HEARING_R_F_W).equals(""))) {
				hearingRFW = new BigDecimal(req.getParameter(HEARING_R_F_W));
			}
			if (req.getParameter(HEARING_L_F_W) != null
					&& !(req.getParameter(HEARING_L_F_W).equals(""))) {
				hearingLFW = new BigDecimal(req.getParameter(HEARING_L_F_W));
			}
			if (req.getParameter(HEARING_BOTH_FW) != null
					&& !(req.getParameter(HEARING_BOTH_FW).equals(""))) {
				hearingBothFW = new BigDecimal(req.getParameter(HEARING_BOTH_FW));
			}
			String OtitisMedia="";
			if (req.getParameter("OtitisMedia") != null
					&& !(req.getParameter("OtitisMedia").equals(""))) {
				OtitisMedia =req.getParameter("OtitisMedia");
			}
			BigDecimal height = new BigDecimal(0);
			if (req.getParameter(HEIGHT_WITHOUT_SHOOSE) != null
							&& !(req.getParameter(HEIGHT_WITHOUT_SHOOSE).equals(""))) 
			{
			  height = (new BigDecimal(req.getParameter(HEIGHT_WITHOUT_SHOOSE)));
			}
			BigDecimal weight = new BigDecimal(0);
			if (req.getParameter(ACTUAL_WEIGHT) != null
					&& !(req.getParameter(ACTUAL_WEIGHT).equals(""))) 
			{
				weight = (new BigDecimal(req.getParameter(ACTUAL_WEIGHT)));
			}
			if (req.getParameter(DATE_OF_REPORTING) != null
					&& !(req.getParameter(DATE_OF_REPORTING).equals(""))) {
				dateOfReporting = HMSUtil.dateFormatterDDMMYYYY(req
						.getParameter(DATE_OF_REPORTING));

			}
			
			if (req.getParameter(CONVERGENCE_SC) != null
					&& !(req.getParameter(CONVERGENCE_SC).equals(""))) {
				convergenceCP = new BigDecimal(req.getParameter(CONVERGENCE_SC));
			}
			if (req.getParameter(CONVERGENCE_C) != null
					&& !(req.getParameter(CONVERGENCE_C).equals(""))) {
				convergenceC = new BigDecimal(req.getParameter(CONVERGENCE_C));

			}
                
			if (req.getParameter(DENTAL_REMARKS) != null
					&& !(req.getParameter(DENTAL_REMARKS).equals(""))) {
				dentalRemarks = req.getParameter(DENTAL_REMARKS);
			}
			
			if (req.getParameter(MEDICAL_BOARD_EXAMINATION) != null
					&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION).equals(""))) {
				medicalBoardExamination = req
						.getParameter(MEDICAL_BOARD_EXAMINATION);
			}
					

			if (req.getParameter(LAST_CHANGED_BY) != null) {
				lastChangedBy = req.getParameter(LAST_CHANGED_BY);
			}
			if (req.getParameter(LAST_CHANGED_DATE) != null) {
				lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
						.getParameter(LAST_CHANGED_DATE));
			}
			if (req.getParameter(LAST_CHANGED_TIME) != null) {
				lastChangedTime = req.getParameter(LAST_CHANGED_TIME);
			}
			//-----For dental added by dipali
			if (req.getParameter(TOTAL_NO_OF_TEETH) != null
					&& !(req.getParameter(TOTAL_NO_OF_TEETH).equals(""))) {
				totalTeeth = req.getParameter(TOTAL_NO_OF_TEETH);

			}
			if (req.getParameter(DEFECTIVE_TEETH) != null
					&& !(req.getParameter(DEFECTIVE_TEETH).equals(""))) {
				totalDefectiveTeeth = req.getParameter(DEFECTIVE_TEETH);

			}
			if (req.getParameter(MISSING_TEETH) != null
					&& !(req.getParameter(MISSING_TEETH).equals(""))) {
				missingTeeth = req.getParameter(MISSING_TEETH);

			}
			if (req.getParameter(MISSING_UNSERVICABLE_TEETH) != null
					&& !(req.getParameter(MISSING_UNSERVICABLE_TEETH).equals(""))) {
				unserviceableTeeth = req.getParameter(MISSING_UNSERVICABLE_TEETH);

			}
			if (req.getParameter(DENTSL_POINT) != null
					&& !(req.getParameter(DENTSL_POINT).equals(""))) {
				DenstalPoint = req.getParameter(DENTSL_POINT);

			}

			if (req.getParameter(LAST_CHANGED_BY) != null) {
				lastChangedBy = req.getParameter(LAST_CHANGED_BY);
			}
			if (req.getParameter(LAST_CHANGED_DATE) != null) {
				lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
						.getParameter(LAST_CHANGED_DATE));
			}
			if (req.getParameter(LAST_CHANGED_TIME) != null) {
				lastChangedTime = req.getParameter(LAST_CHANGED_TIME);
			}
			// //////////////////////////////////

			if (req.getParameter(DUR_8) != null) {
				dur8 = (req.getParameter(DUR_8));

			} else {
				dur8 = "N";

			}

			if (req.getParameter(DUR_7) != null) {
				dur7 = (req.getParameter(DUR_7));

			} else {
				dur7 = "N";

			}
			if (req.getParameter(DUR_6) != null) {
				dur6 = (req.getParameter(DUR_6));

			} else {
				dur6 = "N";

			}
			if (req.getParameter(DUR_5) != null) {
				dur5 = (req.getParameter(DUR_5));

			} else {
				dur5 = "N";

			}

			if (req.getParameter(DUR_4) != null) {
				dur4 = (req.getParameter(DUR_4));
			} else {
				dur4 = "N";

			}
			if (req.getParameter(DUR_3) != null) {
				dur3 = (req.getParameter(DUR_3));

			} else {
				dur3 = "N";

			}
			if (req.getParameter(DUR_2) != null) {
				dur2 = (req.getParameter(DUR_2));

			} else {
				dur2 = "N";

			}
			if (req.getParameter(DUR_1) != null) {
				dur1 = (req.getParameter(DUR_1));

			} else {
				dur1 = "N";

			}

			if (req.getParameter(DUL_8) != null) {
				dul8 = (req.getParameter(DUL_8));
			} else {
				dul8 = "N";

			}
			if (req.getParameter(DUL_7) != null) {
				dul7 = (req.getParameter(DUL_7));

			} else {
				dul7 = "N";

			}
			if (req.getParameter(DUL_6) != null) {
				dul6 = (req.getParameter(DUL_6));
			} else {
				dul6 = "N";

			}
			if (req.getParameter(DUL_5) != null) {
				dul5 = (req.getParameter(DUL_5));
			} else {
				dul5 = "N";

			}
			if (req.getParameter(DUL_4) != null) {
				dul4 = (req.getParameter(DUL_4));
			} else {
				dul4 = "N";

			}
			if (req.getParameter(DUL_3) != null) {
				dul3 = (req.getParameter(DUL_3));
			} else {
				dul3 = "N";

			}
			if (req.getParameter(DUL_2) != null) {
				dul2 = (req.getParameter(DUL_2));
			} else {
				dul2 = "N";

			}
			if (req.getParameter(DUL_1) != null) {
				dul1 = (req.getParameter(DUL_1));
			} else {
				dul1 = "N";

			}

			if (req.getParameter(DLR_8) != null) {
				dlr8 = (req.getParameter(DLR_8));
			} else {
				dlr8 = "N";

			}
			if (req.getParameter(DLR_7) != null) {
				dlr7 = (req.getParameter(DLR_7));
			} else {
				dlr7 = "N";

			}
			if (req.getParameter(DLR_6) != null) {
				dlr6 = (req.getParameter(DLR_6));
			} else {
				dlr6 = "N";

			}
			if (req.getParameter(DLR_5) != null) {
				dlr5 = (req.getParameter(DLR_5));
			} else {
				dlr5 = "N";

			}
			if (req.getParameter(DLR_4) != null) {
				dlr4 = (req.getParameter(DLR_4));
			} else {
				dlr4 = "N";

			}
			if (req.getParameter(DLR_3) != null) {
				dlr3 = (req.getParameter(DLR_3));
			} else {
				dlr3 = "N";

			}
			if (req.getParameter(DLR_2) != null) {
				dlr2 = (req.getParameter(DLR_2));
			} else {
				dlr2 = "N";

			}

			if (req.getParameter(DLR_1) != null) {
				dlr1 = (req.getParameter(DLR_1));
			} else {
				dlr1 = "N";

			}

			if (req.getParameter(DLL_8) != null) {
				dll8 = (req.getParameter(DLL_8));
			} else {
				dll8 = "N";

			}
			if (req.getParameter(DLL_7) != null) {
				dll7 = (req.getParameter(DLL_7));
			} else {
				dll7 = "N";

			}

			if (req.getParameter(DLL_6) != null) {
				dll6 = (req.getParameter(DLL_6));
			} else {
				dll6 = "N";

			}
			if (req.getParameter(DLL_5) != null) {
				dll5 = (req.getParameter(DLL_5));
			} else {
				dll5 = "N";

			}
			if (req.getParameter(DLL_4) != null) {
				dll4 = (req.getParameter(DLL_4));
			} else {
				dll4 = "N";

			}
			if (req.getParameter(DLL_3) != null) {
				dll3 = (req.getParameter(DLL_3));
			} else {
				dll3 = "N";

			}
			if (req.getParameter(DLL_2) != null) {
				dll2 = (req.getParameter(DLL_2));
			} else {
				dll2 = "N";

			}
			if (req.getParameter(DLL_1) != null) {
				dll1 = (req.getParameter(DLL_1));
			} else {
				dll1 = "N";

			}
			// ///////////////////////////

			if (req.getParameter(UUR_8) != null) {
				uur8 = (req.getParameter(UUR_8));
			} else {
				uur8 = "N";

			}

			if (req.getParameter(UUR_7) != null) {
				uur7 = (req.getParameter(UUR_7));
			} else {
				uur7 = "N";

			}
			if (req.getParameter(UUR_6) != null) {
				uur6 = (req.getParameter(UUR_6));
			} else {
				uur6 = "N";

			}
			if (req.getParameter(UUR_5) != null) {
				uur5 = (req.getParameter(UUR_5));
			} else {
				uur5 = "N";

			}
			if (req.getParameter(UUR_4) != null) {
				uur4 = (req.getParameter(UUR_4));
			} else {
				uur4 = "N";

			}
			if (req.getParameter(UUR_3) != null) {
				uur3 = (req.getParameter(UUR_3));
			} else {
				uur3 = "N";

			}
			if (req.getParameter(UUR_2) != null) {
				uur2 = (req.getParameter(UUR_2));
			} else {
				uur2 = "N";

			}
			if (req.getParameter(UUR_1) != null) {
				uur1 = (req.getParameter(UUR_1));
			} else {
				uur1 = "N";

			}

			if (req.getParameter(UUL_8) != null) {
				uul8 = (req.getParameter(UUL_8));
			} else {
				uul8 = "N";

			}
			if (req.getParameter(UUL_7) != null) {
				uul7 = (req.getParameter(UUL_7));

			} else {
				uul7 = "N";

			}
			if (req.getParameter(UUL_6) != null) {
				uul6 = (req.getParameter(UUL_6));
			} else {
				uul6 = "N";

			}
			if (req.getParameter(UUL_5) != null) {
				uul5 = (req.getParameter(UUL_5));
			} else {
				uul5 = "N";

			}
			if (req.getParameter(UUL_4) != null) {
				uul4 = (req.getParameter(UUL_4));
			} else {
				uul4 = "N";

			}
			if (req.getParameter(UUL_3) != null) {
				uul3 = (req.getParameter(UUL_3));
			} else {
				uul3 = "N";

			}
			if (req.getParameter(UUL_2) != null) {
				uul2 = (req.getParameter(UUL_2));
			} else {
				uul2 = "N";

			}
			if (req.getParameter(UUL_1) != null) {
				uul1 = (req.getParameter(UUL_1));
			} else {
				uul1 = "N";

			}
			if (req.getParameter(ULR_8) != null) {
				ulr8 = (req.getParameter(ULR_8));
			} else {
				ulr8 = "N";

			}

			if (req.getParameter(ULR_7) != null) {
				ulr7 = (req.getParameter(ULR_7));
			} else {
				ulr7 = "N";

			}
			if (req.getParameter(ULR_6) != null) {
				ulr6 = (req.getParameter(ULR_6));
			} else {
				ulr6 = "N";

			}
			if (req.getParameter(ULR_5) != null) {
				ulr5 = (req.getParameter(ULR_5));
			} else {
				ulr5 = "N";

			}
			if (req.getParameter(ULR_4) != null) {
				ulr4 = (req.getParameter(ULR_4));
			} else {
				ulr4 = "N";

			}
			if (req.getParameter(ULR_3) != null) {
				ulr3 = (req.getParameter(ULR_3));
			} else {
				ulr3 = "N";

			}
			if (req.getParameter(ULR_2) != null) {
				ulr2 = (req.getParameter(ULR_2));
			} else {
				ulr2 = "N";

			}
			if (req.getParameter(ULR_1) != null) {
				ulr1 = (req.getParameter(ULR_1));
			} else {
				ulr1 = "N";

			}

			if (req.getParameter(ULL_8) != null) {
				ull8 = (req.getParameter(ULL_8));
			} else {
				ull8 = "N";

			}
			if (req.getParameter(ULL_7) != null) {
				ull7 = (req.getParameter(ULL_7));
			} else {
				ull7 = "N";

			}
			if (req.getParameter(ULL_6) != null) {
				ull6 = (req.getParameter(ULL_6));
			} else {
				ull6 = "N";

			}
			if (req.getParameter(ULL_5) != null) {
				ull5 = (req.getParameter(ULL_5));
			} else {
				ull5 = "N";

			}
			if (req.getParameter(ULL_4) != null) {
				ull4 = (req.getParameter(ULL_4));
			} else {
				ull4 = "N";

			}
			if (req.getParameter(ULL_3) != null) {
				ull3 = (req.getParameter(ULL_3));
			} else {
				ull3 = "N";

			}
			if (req.getParameter(ULL_2) != null) {
				ull2 = (req.getParameter(ULL_2));
			} else {
				ull2 = "N";

			}
			if (req.getParameter(ULL_1) != null) {
				ull1 = (req.getParameter(ULL_1));
			} else {
				ull1 = "N";

			}

			// ////////////////////////

			if (req.getParameter(MUR_8) != null) {
				mur8 = (req.getParameter(MUR_8));

			} else {
				mur8 = "N";

			}
			if (req.getParameter(MUR_7) != null) {
				mur7 = (req.getParameter(MUR_7));
			} else {
				mur7 = "N";

			}
			if (req.getParameter(MUR_6) != null) {
				mur6 = (req.getParameter(MUR_6));
			} else {
				mur6 = "N";

			}
			if (req.getParameter(MUR_5) != null) {
				mur5 = (req.getParameter(MUR_5));
			} else {
				mur5 = "N";

			}
			if (req.getParameter(MUR_4) != null) {
				mur4 = (req.getParameter(MUR_4));
			} else {
				mur4 = "N";

			}
			if (req.getParameter(MUR_3) != null) {
				mur3 = (req.getParameter(MUR_3));
			} else {
				mur3 = "N";

			}
			if (req.getParameter(MUR_2) != null) {
				mur2 = (req.getParameter(MUR_2));
			} else {
				mur2 = "N";

			}
			if (req.getParameter(MUR_1) != null) {
				mur1 = (req.getParameter(MUR_1));
			} else {
				mur1 = "N";

			}

			if (req.getParameter(MUL_8) != null) {
				mul8 = (req.getParameter(MUL_8));
			} else {
				mul8 = "N";

			}
			if (req.getParameter(MUL_7) != null) {
				mul7 = (req.getParameter(MUL_7));

			} else {
				mul7 = "N";

			}
			if (req.getParameter(MUL_6) != null) {
				mul6 = (req.getParameter(MUL_6));
			} else {
				mul6 = "N";

			}
			if (req.getParameter(MUL_5) != null) {
				mul5 = (req.getParameter(MUL_5));
			} else {
				mul5 = "N";

			}
			if (req.getParameter(MUL_4) != null) {
				mul4 = (req.getParameter(MUL_4));
			} else {
				mul4 = "N";

			}
			if (req.getParameter(MUL_3) != null) {
				mul3 = (req.getParameter(MUL_3));
			} else {
				mul3 = "N";

			}
			if (req.getParameter(MUL_2) != null) {
				mul2 = (req.getParameter(MUL_2));
			} else {
				mul2 = "N";

			}
			if (req.getParameter(MUL_1) != null) {
				mul1 = (req.getParameter(MUL_1));
			} else {
				mul1 = "N";

			}
			if (req.getParameter(MLR_8) != null) {
				mlr8 = (req.getParameter(MLR_8));
			} else {
				mlr8 = "N";

			}

			if (req.getParameter(MLR_7) != null) {
				mlr7 = (req.getParameter(MLR_7));
			} else {
				mlr7 = "N";

			}
			if (req.getParameter(MLR_6) != null) {
				mlr6 = (req.getParameter(MLR_6));
			} else {
				mlr6 = "N";

			}
			if (req.getParameter(MLR_5) != null) {
				mlr5 = (req.getParameter(MLR_5));
			} else {
				mlr5 = "N";

			}

			if (req.getParameter(MLR_4) != null) {
				mlr4 = (req.getParameter(MLR_4));
			} else {
				mlr4 = "N";

			}
			if (req.getParameter(MLR_3) != null) {
				mlr3 = (req.getParameter(MLR_3));
			} else {
				mlr3 = "N";

			}

			if (req.getParameter(MLR_2) != null) {
				mlr2 = (req.getParameter(MLR_2));
			} else {
				mlr2 = "N";

			}
			if (req.getParameter(MLR_1) != null) {
				mlr1 = (req.getParameter(MLR_1));
			} else {
				mlr1 = "N";

			}

			if (req.getParameter(MLL_8) != null) {
				mll8 = (req.getParameter(MLL_8));
			} else {
				mll8 = "N";

			}
			if (req.getParameter(MLL_7) != null) {
				mll7 = (req.getParameter(MLL_7));
			} else {
				mll7 = "N";

			}
			if (req.getParameter(MLL_6) != null) {
				mll6 = (req.getParameter(MLL_6));
			} else {
				mll6 = "N";

			}
			if (req.getParameter(MLL_5) != null) {
				mll5 = (req.getParameter(MLL_5));
			} else {
				mll5 = "N";

			}
			if (req.getParameter(MLL_4) != null) {
				mll4 = (req.getParameter(MLL_4));
			} else {
				mll4 = "N";

			}
			if (req.getParameter(MLL_3) != null) {
				mll3 = (req.getParameter(MLL_3));
			} else {
				mll3 = "N";

			}
			if (req.getParameter(MLL_2) != null) {
				mll2 = (req.getParameter(MLL_2));
			} else {
				mll2 = "N";

			}
			if (req.getParameter(MLL_1) != null) {
				mll1 = (req.getParameter(MLL_1));
			} else {
				mll1 = "N";

			}

			sur8 = dur8 + "" + mur8 + "" + uur8;

			sur7 = dur7 + "" + mur7 + "" + uur7;

			sur6 = dur6 + "" + mur6 + "" + uur6;
			sur5 = dur5 + "" + mur5 + "" + uur5;
			sur4 = dur4 + "" + mur4 + "" + uur4;
			sur3 = dur3 + "" + mur3 + "" + uur3;
			sur2 = dur2 + "" + mur2 + "" + uur2;
			sur1 = dur1 + "" + mur2 + "" + uur1;

			sul8 = dul8 + "" + mul8 + "" + uul8;
			sul7 = dul7 + "" + mul7 + "" + uul7;

			sul6 = dul6 + "" + mul6 + "" + uul6;
			sul5 = dul5 + "" + mul5 + "" + uul5;
			sul4 = dul4 + "" + mul4 + "" + uul4;
			sul3 = dul3 + "" + mul3 + "" + uul3;
			sul2 = dul2 + "" + mul2 + "" + uul2;
			sul1 = dul1 + "" + mul1 + "" + uul1;

			slr8 = dlr8 + "" + mlr8 + "" + ulr8;
			slr7 = dlr7 + "" + mlr7 + "" + ulr7;
			slr6 = dlr6 + "" + mlr6 + "" + ulr6;
			slr5 = dlr5 + "" + mlr5 + "" + ulr5;
			slr4 = dlr4 + "" + mlr4 + "" + ulr4;
			slr3 = dlr3 + "" + mlr3 + "" + ulr3;
			slr2 = dlr2 + "" + mlr2 + "" + ulr2;
			slr1 = dlr1 + "" + mlr2 + "" + ulr1;

			sll8 = dll8 + "" + mll8 + "" + ull8;
			sll7 = dll7 + "" + mll7 + "" + ull7;
			sll6 = dll6 + "" + mll6 + "" + ull6;
			sll5 = dll5 + "" + mll5 + "" + ull5;
			sll4 = dll4 + "" + mll4 + "" + ull4;
			sll3 = dll3 + "" + mll3 + "" + ull3;
			sll2 = dll2 + "" + mll2 + "" + ull2;
			sll1 = dll1 + "" + mll2 + "" + ull1;
			masMedicalBoardProceedings.setTotalDefectiveTeeth(totalDefectiveTeeth);
			masMedicalBoardProceedings.setTotalTeeth(totalTeeth);
			masMedicalBoardProceedings.setMissingTeeth(missingTeeth);
			masMedicalBoardProceedings.setUnservisableTeeth(unserviceableTeeth);
			masMedicalBoardProceedings.setDenstlPoint(DenstalPoint);
			masMedicalBoardProceedings.setUR1(sur1);
			masMedicalBoardProceedings.setUR2(sur2);
			masMedicalBoardProceedings.setUR3(sur3);
			masMedicalBoardProceedings.setUR4(sur4);
			masMedicalBoardProceedings.setUR5(sur5);
			masMedicalBoardProceedings.setUR6(sur6);
			masMedicalBoardProceedings.setUR7(sur7);
			masMedicalBoardProceedings.setUR8(sur8);

			masMedicalBoardProceedings.setUL1(sul1);
			masMedicalBoardProceedings.setUL2(sul2);
			masMedicalBoardProceedings.setUL3(sul3);
			masMedicalBoardProceedings.setUL4(sul4);
			masMedicalBoardProceedings.setUL5(sul5);
			masMedicalBoardProceedings.setUL6(sul6);
			masMedicalBoardProceedings.setUL7(sul7);
			masMedicalBoardProceedings.setUL8(sul8);

			masMedicalBoardProceedings.setLR1(slr1);
			masMedicalBoardProceedings.setLR2(slr2);
			masMedicalBoardProceedings.setLR3(slr3);
			masMedicalBoardProceedings.setLR4(slr4);
			masMedicalBoardProceedings.setLR5(slr5);
			masMedicalBoardProceedings.setLR6(slr6);
			masMedicalBoardProceedings.setLR7(slr7);
			masMedicalBoardProceedings.setLR8(slr8);

			masMedicalBoardProceedings.setLL1(sll1);
			masMedicalBoardProceedings.setLL2(sll2);
			masMedicalBoardProceedings.setLL3(sll3);
			masMedicalBoardProceedings.setLL4(sll4);
			masMedicalBoardProceedings.setLL5(sll5);
			masMedicalBoardProceedings.setLL6(sll6);
			masMedicalBoardProceedings.setLL7(sll7);
			masMedicalBoardProceedings.setLL8(sll8);
			masMedicalBoardProceedings.setRemarksTeath(dentalRemarks);
			//----
			generalMap.put("serviceNo", serviceNo);
			generalMap.put("pojoPropertyCode", "serviceNo");
			generalMap.put("pojoName", "MasMedicalExaminationReportOnEntry");
			String message = "";
			String jsp = "";
			Boolean successfullyAdded = false;
				masMedicalBoardProceedings.setHearingBothCv(hearingBothCV);
				masMedicalBoardProceedings.setDateSpecialExam(eyeDate);
				masMedicalBoardProceedings.setYearlySerialNo(serviceNo);
				masMedicalBoardProceedings.setEntryDate(entryDate);
				masMedicalBoardProceedings.setHeight(height);
				masMedicalBoardProceedings.setWeight(weight);


				masMedicalBoardProceedings.setMedicalStatus(medicalStatus);
				masMedicalBoardProceedings.setNameInFull(fullName);
				masMedicalBoardProceedings.setDateOfBirth(dateOfBirth);
				if(maritialStatus != 0){
					MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
					masMaritalStatus.setId(maritialStatus);
					masMedicalBoardProceedings.setMaritalStatus(masMaritalStatus);
				}
				masMedicalBoardProceedings.setParmanentAddress(permanentAddress);
				masMedicalBoardProceedings.setIdentificationMarks1(identification1);
				masMedicalBoardProceedings.setIdentificationMarks2(identification2);
				masMedicalBoardProceedings.setDateOfReporting(dateOfReporting);
				masMedicalBoardProceedings
						.setWithGlassesLDistant(withglassesDistantL);
				masMedicalBoardProceedings
						.setWithGlassesRDistant(withGlassesDistantR);
			
				masMedicalBoardProceedings
						.setWithoutGlassesLDistant(withoutGlassesDistantL);
				masMedicalBoardProceedings
						.setWthoutGlassesRDistant(withoutGlassesDistantR);
				masMedicalBoardProceedings
						.setWithGlassesLNearvision(withGlassesNearL);
				masMedicalBoardProceedings
						.setWithGlassesRNearvision(withGlassesNearR);
				masMedicalBoardProceedings
						.setWithoutGlassesLNearvision(withoutGlassesNearL);
				masMedicalBoardProceedings
						.setWithoutGlassesRNearvision(withoutGlassesNearR);
				masMedicalBoardProceedings.setAccommodationR(accommodationR);
				masMedicalBoardProceedings.setAccommodationL(accommodationL);
				masMedicalBoardProceedings.setRemarksSpecialExam(eyeRemarks);
				masMedicalBoardProceedings.setHearingRcv(hearingRCV);
				masMedicalBoardProceedings.setHearingLcv(hearingLCV);
				masMedicalBoardProceedings.setEarHearingRfw(hearingRFW);
				masMedicalBoardProceedings.setEarHearingLfw(hearingLFW);
				masMedicalBoardProceedings.setEarHearingBothFw(hearingBothFW);
				masMedicalBoardProceedings.setFundAndMedia(OtitisMedia);
				if (medicalBoardExaminationPlace != 0) {
					MasUnit masUnit1 = new MasUnit();
					masUnit1.setId(medicalBoardExaminationPlace);
					masMedicalBoardProceedings.setPlaceMedicalBoardExam(masUnit1);
				}
				masMedicalBoardProceedings
						.setMedicalBoardSubsequentFind(subsequentMedicalBoardExam);
				masMedicalBoardProceedings
						.setDateMedicalBoardSubsequent(subsequentMedicalBoardExamDate);
				if (subsequentMedicalBoardExamPlace != 0) {
					MasUnit masUnit2 = new MasUnit();
					masUnit2.setId(subsequentMedicalBoardExamPlace);
					masMedicalBoardProceedings
							.setPlaceMedicalBoardSubsequent(masUnit2);
				}
				masMedicalBoardProceedings.setMediceExamDate(medicinExamDate);
				masMedicalBoardProceedings
						.setNearVisionWithGlassCp(withGlassesNearCP);
				masMedicalBoardProceedings
						.setNearVisionWithoutGlassCp(withoutGlassesNearCP);
				masMedicalBoardProceedings.setLastChangedBy(lastChangedBy);
				masMedicalBoardProceedings.setLastChangedDate(lastChangedDate);
				masMedicalBoardProceedings.setLastChangedTime(lastChangedTime);
				masMedicalBoardProceedings.setServiceNo(serviceNo);
				masMedicalBoardProceedings.setServiceiaf(serviceiaf); 
	    		masMedicalBoardProceedings.setTypeofcommision(typeOfCommunication);
				masMedicalBoardProceedings.setDateofcommun(dateofcommun);
				masMedicalBoardProceedings.setTotalService(totalservice);
				masMedicalBoardProceedings.setPastmedicalhistory(pastmedicalhistory);
				masMedicalBoardProceedings.setPresentmedicalhistory(presentmedicalhistory);
				masMedicalBoardProceedings.setSourceOfData("MEDNET");
				masMedicalBoardProceedings.setHicStatus("n");			
				if(req.getParameter(SERVICE_TYPE_ID) != null && !(req.getParameter(SERVICE_TYPE_ID)).equals("0")){
					MasServiceType serviceType = new MasServiceType();
					serviceType.setId(Integer.parseInt(req.getParameter(SERVICE_TYPE_ID)));
					masMedicalBoardProceedings.setServiceType(serviceType);
				}
				if(req.getParameter(RANK_ID) != null && !(req.getParameter(RANK_ID)).equals("0")){
					MasRank masRank = new MasRank();
					masRank.setId(Integer.parseInt(req.getParameter(RANK_ID)));
					masMedicalBoardProceedings.setRank(masRank);
				}
				
				if(req.getParameter(TRADE_ID) != null && !(req.getParameter(TRADE_ID)).equals("0")){
					MasTrade masTrade = new MasTrade();
					masTrade.setId(Integer.parseInt(req.getParameter(TRADE_ID)));
					masMedicalBoardProceedings.setTrade(masTrade);
				}	
				if(req.getParameter(UNIT_ID) != null && !(req.getParameter(UNIT_ID)).equals("0")){
					MasUnit unitObj = new MasUnit();
					unitObj.setId(Integer.parseInt(req.getParameter(UNIT_ID)));
					masMedicalBoardProceedings.setUnit(unitObj);
				}	
				if(req.getParameter("apparentAge") != null && !req.getParameter("apparentAge").equals("")){
					String aparentage=req.getParameter("apparentAge");
					masMedicalBoardProceedings.setApparentAge(aparentage.substring(0, 2));
				}
				if(req.getParameter(VISIT_ID) != null && !(req.getParameter(VISIT_ID)).equals("0")){
					Visit visit = new Visit();
					visit.setId(Integer.parseInt(req.getParameter(VISIT_ID)));
					if(req.getParameter("apparentAge") == null )
					{
						if(masMedicalBoardProceedings.getVisit()!=null &&masMedicalBoardProceedings.getVisit().getAge()!=null)
						{
							
						masMedicalBoardProceedings.setApparentAge(masMedicalBoardProceedings.getVisit().getAge().substring(0, 2));
						}
					}
					masMedicalBoardProceedings.setVisit(visit);
				}		
				if(req.getParameter(HIN_ID) != null && !(req.getParameter(HIN_ID)).equals("0")){
					Patient patient= new Patient();
					patient.setId(Integer.parseInt(req.getParameter(HIN_ID)));
					masMedicalBoardProceedings.setHin(patient);
					mapForDS.put("hinId", Integer.parseInt(req.getParameter(HIN_ID)));
				}	
				if(req.getParameter(FATHER_NAME) != null){
					masMedicalBoardProceedings.setFatherName(req.getParameter(FATHER_NAME));
				}
				if(req.getParameter(RELEVANT_FAMILY_HISTORY) != null){
					masMedicalBoardProceedings.setRelevantFamilyHistory(req.getParameter(RELEVANT_FAMILY_HISTORY));
				}
				if(req.getParameter("medicalExamType") != null && !req.getParameter("medicalExamType").equals("")){
					masMedicalBoardProceedings.setMedicalExamType(req.getParameter("medicalExamType"));
					mapForDS.put("medicalExamType", req.getParameter("medicalExamType"));
				}
				if(req.getParameter("MissTeeth") != null && !req.getParameter("MissTeeth").equals("")){
					masMedicalBoardProceedings.setMissTeeth(req.getParameter("MissTeeth"));
				}
				if(req.getParameter("UnserTeeth") != null && !req.getParameter("UnserTeeth").equals("")){
					masMedicalBoardProceedings.setUnserTeeth(req.getParameter("UnserTeeth"));
				}
				if(req.getParameter("Investigated") != null && !req.getParameter("Investigated").equals("")){
					masMedicalBoardProceedings.setInvestigated(req.getParameter("Investigated"));
				}
				if(req.getParameter(MARITAL_STATUS_ID) != null && !req.getParameter(MARITAL_STATUS_ID).equals("")){
					MasMaritalStatus maritalstatus = new MasMaritalStatus();
					maritalstatus.setId(Integer.parseInt(req.getParameter(MARITAL_STATUS_ID)));
					masMedicalBoardProceedings.setMaritalStatus(maritalstatus);
					
				}
				
				if(req.getParameter(REPORTED_DATE) != null && !req.getParameter(REPORTED_DATE).equals("")){
					masMedicalBoardProceedings.setDateOfReporting(HMSUtil.convertStringTypeDateToDateType(req.getParameter(REPORTED_DATE)));
				}
				
				
				if(req.getParameter("dentalValue") != null && !req.getParameter("dentalValue").equals("")){
					masMedicalBoardProceedings.setDentalValue(req.getParameter("dentalValue"));
				}
				String denstalPoint="";
				if (req.getParameter(DENTSL_POINT) != null
						&& !(req.getParameter(DENTSL_POINT).equals(""))) {
					denstalPoint = req.getParameter(DENTSL_POINT);

				}
				masMedicalBoardProceedings.setDenstlPoint(denstalPoint);
				if(req.getParameter(CONDITION_OF_GUMS) != null && !req.getParameter(CONDITION_OF_GUMS).equals("")){
					masMedicalBoardProceedings.setConditionOfGums(req.getParameter(CONDITION_OF_GUMS));
				}
				masMedicalBoardProceedings.setAdmissionStatus("n");
				masMedicalBoardProceedings.setSpecialistOpinnionStatus("n");
				int visitNumberForReport=0;
				if(req.getParameter("visitNumberForReport") != null && !req.getParameter("visitNumberForReport").equals("")){
					visitNumberForReport=Integer.parseInt(req.getParameter("visitNumberForReport"));
				}
				String hinNoForreport=null;
				if(req.getParameter("hinNoForreport") != null && !req.getParameter("hinNoForreport").equals("")){
					hinNoForreport=req.getParameter("hinNoForreport");
				}
				String medicaltype=masMedicalBoardProceedings.getMedicalExamType();
		    	MasMedicalExaminationDetail medicaldetail=new MasMedicalExaminationDetail();
				Users maUser = new Users();
				maUser.setId(userId);
				masMedicalBoardProceedings.setMaUser(maUser);
				
				MasHospital hospital = new MasHospital();
				hospital.setId(hospitalId);
				masMedicalBoardProceedings.setHospital(hospital);
			
				masMedicalBoardProceedings.setStatus("p");
				if(req.getParameter("ReportingForExamBoard") != null && req.getParameter("ReportingForExamBoard").equals("MedExam")){
					masMedicalBoardProceedings.setMedicalType("MedicalExam");
					}else if(req.getParameter("ReportingForExamBoard") != null && req.getParameter("ReportingForExamBoard").equals("MedBoard")){
						masMedicalBoardProceedings.setMedicalType("MedicalBoard");
					}
				if (req.getParameter("dentalReferToMH") != null
						&& !(req.getParameter("dentalReferToMH").equals(""))) {
					denatlToMH = req.getParameter("dentalReferToMH");
				}
				masMedicalBoardProceedings.setReferToMH(denatlToMH);
				mapForDS.put("chargeCodeIdList", chargeCodeIdList);
				mapForDS.put("quantityList", quantityList);
				mapForDS.put("clinicalNotes1", clinicalNotes1);
				mapForDS.put("lastChangedBy", lastChangedBy);
				mapForDS.put("lastChangedDate", lastChangedDate);
				mapForDS.put("lastChangedTime", lastChangedTime);
				mapForDS.put("investigationReferToMHList", investigationReferToMHList);
				mapForDS.put("identification1", identification1);
				mapForDS.put("identification2", identification2);
				mapForDS.put("hospitalId", hospitalId);
				mapForDS.put("deptId", deptId);
				mapForDS.put("empId", empId);
				mapForDS.put("hinId", hinId);
				mapForDS.put("visitId", visitId);
				mapForDS.put("patientInvestigationHeaderId", 0);
				mapForDS.put("dgOrderhdId", 0);
				mapForDS.put("patientInvestigationdetailsIdList", patientInvestigationdetailsIdList);
				mapForDS.put("dgOrderdtIdList", dgOrderdtIdList);
				
				try {
					Visit visit = new Visit();

					visit.setTokenNo(0);
					if (hinId != 0) {
						Patient patient = new Patient();
						patient.setId(hinId);
						visit.setHin(patient);
					}
					if (hospitalId != 0) {
						MasHospital masHospital = new MasHospital();
						masHospital.setId(hospitalId);
						visit.setHospital(masHospital);
					}
					if (deptId != 0) {
						MasDepartment masDepartment = new MasDepartment();
						masDepartment.setId(deptId);
						visit.setDepartment(masDepartment);
					}
					if (empId != 0) {
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(empId);
						visit.setDoctor(masEmployee);
					}
					String ageId = "";
					if (req.getParameter("ageId") != null) {
						ageId = req.getParameter("ageId");
					}
					visit.setAge(ageId);
					visit.setAddEditBy(user);
					visit.setAddEditDate(lastChangedDate);
					visit.setAddEditTime(lastChangedTime);
					visit.setVisitDate(lastChangedDate);
					visit.setVisitTime(lastChangedTime);
					visit.setVisitStatus("w");
					visit.setReportingFor("Dental");
					visit.setAppointmentType("D");
				   	visit.setPriority(3);
					visit.setStatus("y");
					visit.setDentalFlag("MedExam2A");
					mapForDS.put("visit", visit);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				String orderSeqNo = "";
				orderSeqNo=labHandlerService.generateOrderNumber(hospitalId);
				mapForDS.put("orderSeqNo",orderSeqNo);
				
				successfullyAdded = medicalExamHandlerService
						.addMedicalExaminationBoardAnnual2A(masMedicalBoardProceedings,mapForDS);
				message = "Record Added Successfully!";
				jsp = MEDICAL_BOARD_EXAM_MSG;
				if (!successfullyAdded) {
					message = "Some Problem Occured !!!";
					jsp = MEDICAL_BOARD_ERROR_MSG;
				}
				
			String medicalEntryNo = "";
			String medicalEntryNo1 = "";
			String userName = "";
			String userName1 = "";
			jsp += ".jsp";
			map.put("medicalEntryNo", medicalEntryNo);
			map.put("medicalEntryNo1", medicalEntryNo1);
			map.put("contentJsp", jsp);
			map.put("message", message);
			map.put("denatlToMH", denatlToMH);
			map.put("hinNoForreport", hinNoForreport);
			map.put("visitNumberForReport", visitNumberForReport);
			map.put("serviceNo", serviceNo);
			map.put("visitId",visitId);
			
			return new ModelAndView("indexB", "map", map);
		}
	//-------------------- End addMedicalExam Method for 2A-----------------------------
		//-------------------------- start updateMedicalExam method for 2A------------------------
		public ModelAndView updateMedicalExaminationBoardAnnual2A(HttpServletRequest req,
				HttpServletResponse res) {
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			String serviceNo = "";
			String rank = "";
			String name = "";
			String unit = "";
			String serviceiaf = "";
			String branch = "";
			Date dob = null;
			String age = "";
			String typeOfCommunication = "";
			Date dateofcommun = null;
			String totalservice = "";
			String pastmedicalhistory = "";
			String presentmedicalhistory = "";
			String chestMeasurment = "";
			
			Date entryDate = null;
			Date medicinExamDate = null;
			String lastChangedBy = "";
			String lastChangedTime = "";
			Date lastChangedDate = null;
			int medicalExamHeld = 0;
			String medicalStatus = "";
			String fullName = "";
			Date dateOfBirth = null;
			int maritialStatus = 0;
			String service = "";
			String pNo = "";
			String permanentAddress = "";
			String identification1 = "";
			String identification2 = "";
			Date dateOfReporting = null;

			String withGlassesDistantR = "";
			String withglassesDistantL = "";
			String withGlassesNearR = "";
			String withGlassesNearL = "";
			String withGlassesNearCP = "";
			String withoutGlassesDistantR = "";
			String withoutGlassesDistantL = "";
			String withoutGlassesNearR = "";
			String withoutGlassesNearL = "";
			String withoutGlassesNearCP = "";
			BigDecimal convergenceCP = new BigDecimal(0);

			BigDecimal convergenceC = new BigDecimal(0);
			String accommodationR = "";
			String accommodationL = "";
			String eyeRemarks = "";
			Date eyeDate = null;
			BigDecimal hearingRFW = new BigDecimal(0);
			BigDecimal hearingLFW = new BigDecimal(0);
			BigDecimal hearingBothFW = new BigDecimal(0);
			BigDecimal hearingRCV = new BigDecimal(0);
			BigDecimal hearingLCV = new BigDecimal(0);
			BigDecimal hearingBothCV = new BigDecimal(0);
	       
			List<String> investigationReferToMHList=new ArrayList<String>();
			String dentalRemarks = "";
			String denatlToMH="";
			String medicalBoardExamination = "";
			int medicalBoardExaminationPlace = 0;
			Date medicalBoardExaminationDate = new Date();
			String subsequentMedicalBoardExam = "";
			int subsequentMedicalBoardExamPlace = 0;
			Date subsequentMedicalBoardExamDate = null;
			HttpSession session = req.getSession();
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			int userId = 0;
			Users user = (Users)session.getAttribute("users");
			userId = user.getId();
			String jsp="";
			String message="";
			int commandId = (Integer) session.getAttribute("commandId");
            int medExamId=0;
			Map<String, Object> map = new HashMap<String, Object>();

			int visitId=0;
			
			if((req.getParameter("medExamId")) != null && !req.getParameter("medExamId").equals("0")
					&& !(req.getParameter("medExamId")).equals("") )
			{
				
				medExamId =  Integer.parseInt(req.getParameter("medExamId"));
					
			MasMedicalExaminationReportOnEntry masMedicalBoardProceedings = new MasMedicalExaminationReportOnEntry();
			masMedicalBoardProceedings = medicalExamHandlerService.loadMedicalExamObj(medExamId);
			
			Map<String, Object> generalMap = new HashMap<String, Object>();
			List<MasMedicalBoardExaminationDetail> masMedicalBoardDetails = new ArrayList<MasMedicalBoardExaminationDetail>();

		
			if (req.getParameter(SERVICE_NO) != null) {
				serviceNo = req.getParameter(SERVICE_NO);
			}
		if (req.getParameter(AGE) != null ) {
				age = req.getParameter(AGE);
			}
			if (req.getParameter(TOTAL_SERVICE) != null ) {
				totalservice = req.getParameter(TOTAL_SERVICE);
			}
			if (req.getParameter("serviceiaf") != null ) {
				serviceiaf = req.getParameter("serviceiaf");
			}
			
			
			if (req.getParameter(PAST_MEDICAL_HISTORY) != null ) {
				pastmedicalhistory  = req.getParameter(PAST_MEDICAL_HISTORY);
			}
			String lastame="";
			if (req.getParameter(LAST_AME) != null ) {
				lastame = req.getParameter(LAST_AME);
			}
			int deptId=0;
			int empId=0;
			int hinId=0;
			
			if (req.getParameter("deptId") != null ) {
				deptId  = Integer.parseInt(req.getParameter("deptId"));
			}
			if (req.getParameter("empId") != null ) {
				empId  = Integer.parseInt(req.getParameter("empId"));
			}
			if (req.getParameter("hinId") != null ) {
				hinId  = Integer.parseInt(req.getParameter("hinId"));
			}
			if (req.getParameter("visitId") != null ) {
				visitId  = Integer.parseInt(req.getParameter("visitId"));
			}
			String investigationDataStatus=null;
			if(req.getParameter("investigationDataStatus") != null ){
				investigationDataStatus=req.getParameter("investigationDataStatus");
			}
			
			
			List<String> chargeCodeIdList = new ArrayList<String>();
			List<Integer> quantityList = new ArrayList<Integer>();
			List<Integer> patientInvestigationdetailsIdList = new ArrayList<Integer>();
			List<Integer> dgOrderdtIdList = new ArrayList<Integer>();
		//	List<String> investigationReferToMHList=new ArrayList<String>();
			List<String> investResultList=new ArrayList<String>();
			String clinicalNotes1="";
					if (req.getParameter("clinicalNotes1") != null
							&& !(req.getParameter("clinicalNotes1").equals(""))) {
						clinicalNotes1 = req.getParameter("clinicalNotes1");
					}

			int hiddenValue = 1;
			String data=null;
			if(req.getParameter("data") != null && !req.getParameter("data").equals(""))
			{
				data=(String)req.getParameter("data");
			}
					if (Integer.parseInt(req.getParameter("hiddenValue")) != 1) {
						hiddenValue = Integer.parseInt(req.getParameter("hiddenValue"));
					}
						 String deleatedorderid = "";
						if (req.getParameter("deleatedorderid") != "") {
							deleatedorderid = req.getParameter("deleatedorderid");
						}
						mapForDS.put("deleatedorderid",deleatedorderid);
						 String deleatedValue = "";
							if (req.getParameter("deleatedValue") != "") {
								deleatedValue = req.getParameter("deleatedValue");
							}
							mapForDS.put("deleatedValue",deleatedValue);
	//----------------------------------------------------------------------------------------------------
					String dlc="",hb="",tlc="",esr="",spGravity="",albumen="",sugarR="";
					String sugarF="",sugarPP="",urea="",uricAcid="",srCreatine="",cholesterol="";
					String triglycerids="",hdl="",vldl="";
					int temp = 1;
					String[] chargeCodeIdArr = new String[hiddenValue];
					for (int i = 0; i < hiddenValue; i++) {
						if (req.getParameter("chargeCodeName" + temp) != null
								&& !req.getParameter("chargeCodeName" + temp)
										.equals("")) {
	      				String chargeCodeNameWithId = req
									.getParameter("chargeCodeName" + temp);
							int index1 = chargeCodeNameWithId.lastIndexOf("[");
							int index2 = chargeCodeNameWithId.lastIndexOf("]");
							index1++;
							String chargeCodeName=chargeCodeNameWithId.substring(0,(index1-1));
								
							String chargeCodeId = chargeCodeNameWithId.substring(index1,
									index2);
							if (!chargeCodeId.equals("")) {
								chargeCodeIdArr[i] = chargeCodeId;
								int qty = 1;
			
								if (req.getParameter("investigationReferToMH" + temp) != null )
								{
									investigationReferToMHList.add("y");
								}else
								{
									investigationReferToMHList.add("n");
								}
								if(data!=null)
								{
								    String resultVal="";
								    
									if (req.getParameter("Result" + temp) != null && !req.getParameter("Result" + temp).equals(""))
									{
									  investResultList.add(req.getParameter("Result" + temp));
									  resultVal=req.getParameter("Result" + temp);
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
								  }else if(chargeCodeName.equalsIgnoreCase("esr"))
								  {
									  esr=resultVal;
								  }else if(chargeCodeName.equalsIgnoreCase("Gravity"))
								  {
									  spGravity=resultVal;
								  }else if(chargeCodeName.equalsIgnoreCase("ALBUMIN"))
								  {
									  albumen=resultVal;
								  }else if(chargeCodeName.equalsIgnoreCase("SUGAR R"))
								  {
									  sugarR=resultVal;
								  }else if(chargeCodeName.equalsIgnoreCase("SUGAR F"))
								  {
									  sugarF=resultVal;
								  }else if(chargeCodeName.equalsIgnoreCase("SUGAR PP"))
								  {
									  sugarPP=resultVal;
								  }else if(chargeCodeName.equalsIgnoreCase("Urea"))
								  {
									  urea=resultVal;
								  }else if(chargeCodeName.equalsIgnoreCase("URIC ACID"))
								  {
									  uricAcid=resultVal;
								  }else if(chargeCodeName.equalsIgnoreCase("CREATININE"))
								  {
									  srCreatine=resultVal;
								  }else if(chargeCodeName.equalsIgnoreCase("CHOLESTEROL"))
								  {
									  cholesterol=resultVal;
								  }else if(chargeCodeName.equalsIgnoreCase("TRIGLYCERIDE"))
								  {
									  triglycerids=resultVal;
								  }else if(chargeCodeName.equalsIgnoreCase("HDL"))
								  {
									  hdl=resultVal;
								  }else if(chargeCodeName.equalsIgnoreCase("VLDL"))
								  {
									  vldl=resultVal;
								  }
								
								}
								chargeCodeIdList.add(chargeCodeIdArr[i]);
								quantityList.add(qty);
								//clinicalList.add(clinicalNotes);
							}
						}
						if (req.getParameter("patientInvestigationdetailsId" + temp) != null
								&& !req.getParameter("patientInvestigationdetailsId" + temp)
										.equals("")) {
							patientInvestigationdetailsIdList.add(Integer.parseInt(req.getParameter("patientInvestigationdetailsId" + temp)));
						}
						if (req.getParameter("dgOrderdtId" + temp) != null
								&& !req.getParameter("dgOrderdtId" + temp)
										.equals("")) {
							dgOrderdtIdList.add(Integer.parseInt(req.getParameter("dgOrderdtId" + temp)));
						}
						temp++;
					}
						


	//----------------------------------------------------------------------------------------------

			

			if (req.getParameter(ENTRY_OF_DATE) != null
					&& !(req.getParameter(ENTRY_OF_DATE).equals(""))) {
				entryDate = HMSUtil.dateFormatterDDMMYYYY(req
						.getParameter(ENTRY_OF_DATE));
			}
			

			if (req.getParameter(MEDICAL_STATUS) != null
					&& !(req.getParameter(MEDICAL_STATUS).equals(""))) {
				medicalStatus = req.getParameter(MEDICAL_STATUS);
			}
			if (req.getParameter(FULL_NAME) != null
					&& !(req.getParameter(FULL_NAME).equals(""))) {
				fullName = req.getParameter(FULL_NAME);
			}

			if (req.getParameter(DATE_OF_BIRTH) != null
					&& !(req.getParameter(DATE_OF_BIRTH).equals(""))) {
				dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(req
						.getParameter(DATE_OF_BIRTH));
			}

			if (req.getParameter(MARITIAL_STATUS) != null
					&& !(req.getParameter(MARITIAL_STATUS).equals(""))) {
				maritialStatus = Integer
						.parseInt(req.getParameter(MARITIAL_STATUS));
			}

			if (req.getParameter(SERVICE) != null
					&& !(req.getParameter(SERVICE).equals(""))) {
				service = req.getParameter(SERVICE);
			}

			
			if (req.getParameter(RANK) != null
					&& !(req.getParameter(RANK).equals(""))) {
				rank = req.getParameter(RANK);
			}

			if (req.getParameter(PERMANENT_ADDRESS) != null
					&& !(req.getParameter(PERMANENT_ADDRESS).equals(""))) {
				permanentAddress = req.getParameter(PERMANENT_ADDRESS);
			}

			if (req.getParameter(IDENTIFICATION_MARKS1) != null
					&& !(req.getParameter(IDENTIFICATION_MARKS1).equals(""))) {
				identification1 = req.getParameter(IDENTIFICATION_MARKS1);
			}

			if (req.getParameter(IDENTIFICATION_MARKS2) != null
					&& !(req.getParameter(IDENTIFICATION_MARKS2).equals(""))) {
				identification2 = req.getParameter(IDENTIFICATION_MARKS2);
			}

			if (req.getParameter(WITH_GLASSES_DISTANT_R) != null
					&& !(req.getParameter(WITH_GLASSES_DISTANT_R).equals(""))) {
				withGlassesDistantR = req.getParameter(WITH_GLASSES_DISTANT_R);
			}
			if (req.getParameter(WITH_GLASSES_DISTANT_L) != null
					&& !(req.getParameter(WITH_GLASSES_DISTANT_L).equals(""))) {
				withglassesDistantL = req.getParameter(WITH_GLASSES_DISTANT_L);
			}
			if (req.getParameter(WITH_GLASSES_NEAR_R) != null
					&& !(req.getParameter(WITH_GLASSES_NEAR_R).equals(""))) {
				withGlassesNearR = req.getParameter(WITH_GLASSES_NEAR_R);
			}
			if (req.getParameter(WITH_GLASSES_NEAR_L) != null
					&& !(req.getParameter(WITH_GLASSES_NEAR_L).equals(""))) {
				withGlassesNearL = req.getParameter(WITH_GLASSES_NEAR_L);
			}
			if (req.getParameter(WITH_GLASSES_NEAR_CP) != null
					&& !(req.getParameter(WITH_GLASSES_NEAR_CP).equals(""))) {
				withGlassesNearCP = req.getParameter(WITH_GLASSES_NEAR_CP);
			}
			if (req.getParameter(WITHOUT_GLASSES_DISTANT_R) != null
					&& !(req.getParameter(WITHOUT_GLASSES_DISTANT_R).equals(""))) {
				withoutGlassesDistantR = req
						.getParameter(WITHOUT_GLASSES_DISTANT_R);
			}
			if (req.getParameter(WITHOUT_GLASSES_DISTANT_L) != null
					&& !(req.getParameter(WITHOUT_GLASSES_DISTANT_L).equals(""))) {
				withoutGlassesDistantL = req
						.getParameter(WITHOUT_GLASSES_DISTANT_L);
			}
			if (req.getParameter(WITHOUT_GLASSES_NEAR_R) != null
					&& !(req.getParameter(WITHOUT_GLASSES_NEAR_R).equals(""))) {
				withoutGlassesNearR = req.getParameter(WITHOUT_GLASSES_NEAR_R);
			}
			if (req.getParameter(WITHOUT_GLASSES_NEAR_L) != null
					&& !(req.getParameter(WITHOUT_GLASSES_NEAR_L).equals(""))) {
				withoutGlassesNearL = req.getParameter(WITHOUT_GLASSES_NEAR_L);
			}
			if (req.getParameter(WITHOUT_GLASSES_NEAR_CP) != null
					&& !(req.getParameter(WITHOUT_GLASSES_NEAR_CP).equals(""))) {
				withoutGlassesNearCP = req.getParameter(WITHOUT_GLASSES_NEAR_CP);
			}
			String evidienceOfTrachoma="";
			if (req.getParameter(ANY_EVIDENCE_OF_TRACHOMA) != null
					&& !(req.getParameter(ANY_EVIDENCE_OF_TRACHOMA).equals(""))) 
          {
			evidienceOfTrachoma = req.getParameter(ANY_EVIDENCE_OF_TRACHOMA);
          }
	        String binocular="";
			if (req.getParameter(BINOCULAR_VISION_GRADE) != null
					&& !(req.getParameter(BINOCULAR_VISION_GRADE).equals("")))
	        {
				binocular = req.getParameter(BINOCULAR_VISION_GRADE);
			}

	       masMedicalBoardProceedings.setEvidenceOfTrachoma(evidienceOfTrachoma);
		   masMedicalBoardProceedings.setBinocularVisionGrade(binocular);

					
			if (req.getParameter(HEARING_R_F_W) != null
					&& !(req.getParameter(HEARING_R_F_W).equals(""))) {
				hearingRFW = new BigDecimal(req.getParameter(HEARING_R_F_W));
			}
			if (req.getParameter(HEARING_L_F_W) != null
					&& !(req.getParameter(HEARING_L_F_W).equals(""))) {
				hearingLFW = new BigDecimal(req.getParameter(HEARING_L_F_W));
			}
			if (req.getParameter(HEARING_BOTH_FW) != null
					&& !(req.getParameter(HEARING_BOTH_FW).equals(""))) {
				hearingBothFW = new BigDecimal(req.getParameter(HEARING_BOTH_FW));
			}
			String OtitisMedia="";
			if (req.getParameter("OtitisMedia") != null
					&& !(req.getParameter("OtitisMedia").equals(""))) {
				OtitisMedia =req.getParameter("OtitisMedia");
			}
			BigDecimal height = new BigDecimal(0);
			if (req.getParameter(HEIGHT_WITHOUT_SHOOSE) != null
							&& !(req.getParameter(HEIGHT_WITHOUT_SHOOSE).equals(""))) 
			{
			  height = (new BigDecimal(req.getParameter(HEIGHT_WITHOUT_SHOOSE)));
			}
			BigDecimal weight = new BigDecimal(0);
			if (req.getParameter(ACTUAL_WEIGHT) != null
					&& !(req.getParameter(ACTUAL_WEIGHT).equals(""))) 
			{
				weight = (new BigDecimal(req.getParameter(ACTUAL_WEIGHT)));
			}
			if (req.getParameter(DATE_OF_REPORTING) != null
					&& !(req.getParameter(DATE_OF_REPORTING).equals(""))) {
				dateOfReporting = HMSUtil.dateFormatterDDMMYYYY(req
						.getParameter(DATE_OF_REPORTING));

			}
			int patientInvestigationHeaderId=0;
			if(req.getParameter("patientInvestigationHeaderId") != null && !req.getParameter("patientInvestigationHeaderId").equals("")){
				patientInvestigationHeaderId=Integer.parseInt(req.getParameter("patientInvestigationHeaderId"));
			}
			int dgOrderhdId=0;
			if(req.getParameter("dgOrderhdId") != null && !req.getParameter("dgOrderhdId").equals("")){
				dgOrderhdId=Integer.parseInt(req.getParameter("dgOrderhdId"));
			}
			if (req.getParameter(CONVERGENCE_SC) != null
					&& !(req.getParameter(CONVERGENCE_SC).equals(""))) {
				convergenceCP = new BigDecimal(req.getParameter(CONVERGENCE_SC));
			}
			if (req.getParameter(CONVERGENCE_C) != null
					&& !(req.getParameter(CONVERGENCE_C).equals(""))) {
				convergenceC = new BigDecimal(req.getParameter(CONVERGENCE_C));

			}

			if (req.getParameter(DENTAL_REMARKS) != null
					&& !(req.getParameter(DENTAL_REMARKS).equals(""))) {
				dentalRemarks = req.getParameter(DENTAL_REMARKS);
			}
			
			if (req.getParameter(MEDICAL_BOARD_EXAMINATION) != null
					&& !(req.getParameter(MEDICAL_BOARD_EXAMINATION).equals(""))) {
				medicalBoardExamination = req
						.getParameter(MEDICAL_BOARD_EXAMINATION);
			}					

			if (req.getParameter(LAST_CHANGED_BY) != null) {
				lastChangedBy = req.getParameter(LAST_CHANGED_BY);
			}
			if (req.getParameter(LAST_CHANGED_DATE) != null) {
				lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
						.getParameter(LAST_CHANGED_DATE));
			}
			if (req.getParameter(LAST_CHANGED_TIME) != null) {
				lastChangedTime = req.getParameter(LAST_CHANGED_TIME);
			}
			if (req.getParameter("chestMeasurment") != null) {
				chestMeasurment = req.getParameter("chestMeasurment");
			}
			generalMap.put("serviceNo", serviceNo);
			generalMap.put("pojoPropertyCode", "serviceNo");
			generalMap.put("pojoName", "MasMedicalExaminationReportOnEntry");
		
			Boolean successfullyAdded = false;
				masMedicalBoardProceedings.setHearingBothCv(hearingBothCV);
				masMedicalBoardProceedings.setDateSpecialExam(eyeDate);
				masMedicalBoardProceedings.setYearlySerialNo(serviceNo);
				masMedicalBoardProceedings.setEntryDate(entryDate);
				masMedicalBoardProceedings.setHeight(height);
				masMedicalBoardProceedings.setWeight(weight);
				masMedicalBoardProceedings.setChestMeasurement(chestMeasurment);

				masMedicalBoardProceedings.setMedicalStatus(medicalStatus);
				masMedicalBoardProceedings.setNameInFull(fullName);
				masMedicalBoardProceedings.setDateOfBirth(dateOfBirth);
				if(maritialStatus != 0){
					MasMaritalStatus masMaritalStatus = new MasMaritalStatus();
					masMaritalStatus.setId(maritialStatus);
					masMedicalBoardProceedings.setMaritalStatus(masMaritalStatus);
				}
				masMedicalBoardProceedings.setParmanentAddress(permanentAddress);
				masMedicalBoardProceedings.setIdentificationMarks1(identification1);
				masMedicalBoardProceedings.setIdentificationMarks2(identification2);
				masMedicalBoardProceedings.setDateOfReporting(dateOfReporting);
				masMedicalBoardProceedings
						.setWithGlassesLDistant(withglassesDistantL);
				masMedicalBoardProceedings
						.setWithGlassesRDistant(withGlassesDistantR);
				masMedicalBoardProceedings
						.setWithoutGlassesLDistant(withoutGlassesDistantL);
				masMedicalBoardProceedings
						.setWthoutGlassesRDistant(withoutGlassesDistantR);
				masMedicalBoardProceedings
						.setWithGlassesLNearvision(withGlassesNearL);
				masMedicalBoardProceedings
						.setWithGlassesRNearvision(withGlassesNearR);
				masMedicalBoardProceedings
						.setWithoutGlassesLNearvision(withoutGlassesNearL);
				masMedicalBoardProceedings
						.setWithoutGlassesRNearvision(withoutGlassesNearR);
				masMedicalBoardProceedings.setAccommodationR(accommodationR);
				masMedicalBoardProceedings.setAccommodationL(accommodationL);
				masMedicalBoardProceedings.setRemarksSpecialExam(eyeRemarks);
				masMedicalBoardProceedings.setHearingRcv(hearingRCV);
				masMedicalBoardProceedings.setHearingLcv(hearingLCV);
				masMedicalBoardProceedings.setEarHearingRfw(hearingRFW);
				masMedicalBoardProceedings.setEarHearingLfw(hearingLFW);
				masMedicalBoardProceedings.setEarHearingBothFw(hearingBothFW);
				masMedicalBoardProceedings.setFundAndMedia(OtitisMedia);
				if (medicalBoardExaminationPlace != 0) {
					MasUnit masUnit1 = new MasUnit();
					masUnit1.setId(medicalBoardExaminationPlace);
					masMedicalBoardProceedings.setPlaceMedicalBoardExam(masUnit1);
				}
				
				
				if(data!=null)
				{
							   
								masMedicalBoardProceedings.setDlc(dlc);
								masMedicalBoardProceedings.setHb(hb);
								masMedicalBoardProceedings.setTlc(tlc);
								masMedicalBoardProceedings.setEsr(esr);
								masMedicalBoardProceedings.setSpGravity(spGravity);
								masMedicalBoardProceedings.setAlbumin(albumen);
								masMedicalBoardProceedings.setSugar(sugarR);
								masMedicalBoardProceedings.setSugarF(sugarF);
								masMedicalBoardProceedings.setSugarPP(sugarPP);
								masMedicalBoardProceedings.setUrea(urea);
								masMedicalBoardProceedings.setUricAcid(uricAcid);
								masMedicalBoardProceedings.setSrCreatine(srCreatine);
								masMedicalBoardProceedings.setCholesterol(cholesterol);
								masMedicalBoardProceedings.setTriglycerides(triglycerids);
								masMedicalBoardProceedings.setHld(hdl);
								masMedicalBoardProceedings.setVldl(vldl);
								int medicalOfficerId = 0;
								if (req.getParameter("medicalOfficer") != null
										&& !(req.getParameter("medicalOfficer").equals("0"))) {
									MasEmployee employee = new MasEmployee();
									medicalOfficerId =Integer.parseInt(req.getParameter("medicalOfficer")); 
									employee.setId(Integer.parseInt(req.getParameter("medicalOfficer")));
									masMedicalBoardProceedings.setForwardMO(employee);
									mapForDS.put("medicalOfficerId", medicalOfficerId);
								}
								int departmentId = 0;
								if (req.getParameter(DEPARTMENT_ID) != null ) {
									departmentId  = Integer.parseInt(req.getParameter(DEPARTMENT_ID));
								}
								mapForDS.put("departmentId", departmentId);
							
			     } 
				
				masMedicalBoardProceedings
						.setMedicalBoardSubsequentFind(subsequentMedicalBoardExam);
				masMedicalBoardProceedings
						.setDateMedicalBoardSubsequent(subsequentMedicalBoardExamDate);
				if (subsequentMedicalBoardExamPlace != 0) {
					MasUnit masUnit2 = new MasUnit();
					masUnit2.setId(subsequentMedicalBoardExamPlace);
					masMedicalBoardProceedings
							.setPlaceMedicalBoardSubsequent(masUnit2);
				}
				masMedicalBoardProceedings.setMediceExamDate(medicinExamDate);
				masMedicalBoardProceedings
						.setNearVisionWithGlassCp(withGlassesNearCP);
				masMedicalBoardProceedings
						.setNearVisionWithoutGlassCp(withoutGlassesNearCP);
				masMedicalBoardProceedings.setLastChangedBy(lastChangedBy);
				masMedicalBoardProceedings.setLastChangedDate(lastChangedDate);
				masMedicalBoardProceedings.setLastChangedTime(lastChangedTime);
				masMedicalBoardProceedings.setServiceNo(serviceNo);
				masMedicalBoardProceedings.setServiceiaf(serviceiaf); 
	    		masMedicalBoardProceedings.setTypeofcommision(typeOfCommunication);
				masMedicalBoardProceedings.setDateofcommun(dateofcommun);
				masMedicalBoardProceedings.setTotalService(totalservice);
				masMedicalBoardProceedings.setPastmedicalhistory(pastmedicalhistory);
				masMedicalBoardProceedings.setPresentmedicalhistory(presentmedicalhistory);
				masMedicalBoardProceedings.setSourceOfData("MEDNET");
				masMedicalBoardProceedings.setHicStatus("n");			
				if(req.getParameter(SERVICE_TYPE_ID) != null && !(req.getParameter(SERVICE_TYPE_ID)).equals("0")){
					MasServiceType serviceType = new MasServiceType();
					serviceType.setId(Integer.parseInt(req.getParameter(SERVICE_TYPE_ID)));
					masMedicalBoardProceedings.setServiceType(serviceType);
				}
				if(req.getParameter(RANK_ID) != null && !(req.getParameter(RANK_ID)).equals("0")){
					MasRank masRank = new MasRank();
					masRank.setId(Integer.parseInt(req.getParameter(RANK_ID)));
					masMedicalBoardProceedings.setRank(masRank);
				}
				if(req.getParameter(TRADE_ID) != null && !(req.getParameter(TRADE_ID)).equals("0")){
					MasTrade masTrade = new MasTrade();
					masTrade.setId(Integer.parseInt(req.getParameter(TRADE_ID)));
					masMedicalBoardProceedings.setTrade(masTrade);
				}	
				if(req.getParameter(UNIT_ID) != null && !(req.getParameter(UNIT_ID)).equals("0")){
					MasUnit unitObj = new MasUnit();
					unitObj.setId(Integer.parseInt(req.getParameter(UNIT_ID)));
					masMedicalBoardProceedings.setUnit(unitObj);
				}	
				if(req.getParameter("apparentAge") != null && !req.getParameter("apparentAge").equals("")){
					String aparentage=req.getParameter("apparentAge");
					masMedicalBoardProceedings.setApparentAge(aparentage.substring(0, 2));
				}
				if(req.getParameter(VISIT_ID) != null && !(req.getParameter(VISIT_ID)).equals("0")){
					Visit visit = new Visit();
					visit.setId(Integer.parseInt(req.getParameter(VISIT_ID)));
					if(req.getParameter("apparentAge") == null )
					{
						if(masMedicalBoardProceedings.getVisit()!=null &&masMedicalBoardProceedings.getVisit().getAge()!=null)
						{
							
						masMedicalBoardProceedings.setApparentAge(masMedicalBoardProceedings.getVisit().getAge().substring(0, 2));
						}
					}
					masMedicalBoardProceedings.setVisit(visit);
				}		
				if(req.getParameter(HIN_ID) != null && !(req.getParameter(HIN_ID)).equals("0")){
					Patient patient= new Patient();
					patient.setId(Integer.parseInt(req.getParameter(HIN_ID)));
					masMedicalBoardProceedings.setHin(patient);
					mapForDS.put("hinId", Integer.parseInt(req.getParameter(HIN_ID)));
				}	
				if(req.getParameter(FATHER_NAME) != null){
					masMedicalBoardProceedings.setFatherName(req.getParameter(FATHER_NAME));
				}
				if(req.getParameter(RELEVANT_FAMILY_HISTORY) != null){
					masMedicalBoardProceedings.setRelevantFamilyHistory(req.getParameter(RELEVANT_FAMILY_HISTORY));
				}
				if(req.getParameter("medicalExamType") != null && !req.getParameter("medicalExamType").equals("")){
					
					masMedicalBoardProceedings.setMedicalExamType(req.getParameter("medicalExamType"));
					mapForDS.put("medicalExamType", req.getParameter("medicalExamType"));
				}
				if(req.getParameter("MissTeeth") != null && !req.getParameter("MissTeeth").equals("")){
					masMedicalBoardProceedings.setMissTeeth(req.getParameter("MissTeeth"));
				}
				if(req.getParameter("UnserTeeth") != null && !req.getParameter("UnserTeeth").equals("")){
					masMedicalBoardProceedings.setUnserTeeth(req.getParameter("UnserTeeth"));
				}
				if(req.getParameter("Investigated") != null && !req.getParameter("Investigated").equals("")){
					masMedicalBoardProceedings.setInvestigated(req.getParameter("Investigated"));
				}
				if(req.getParameter(MARITAL_STATUS_ID) != null && !req.getParameter(MARITAL_STATUS_ID).equals("")){
					MasMaritalStatus maritalstatus = new MasMaritalStatus();
					maritalstatus.setId(Integer.parseInt(req.getParameter(MARITAL_STATUS_ID)));
					masMedicalBoardProceedings.setMaritalStatus(maritalstatus);
					
				}
				
				if(req.getParameter(REPORTED_DATE) != null && !req.getParameter(REPORTED_DATE).equals("")){
					masMedicalBoardProceedings.setDateOfReporting(HMSUtil.convertStringTypeDateToDateType(req.getParameter(REPORTED_DATE)));
				}
				
				
				if(req.getParameter("dentalValue") != null && !req.getParameter("dentalValue").equals("")){
					masMedicalBoardProceedings.setDentalValue(req.getParameter("dentalValue"));
				}
				String denstalPoint="";
				if (req.getParameter(DENTSL_POINT) != null
						&& !(req.getParameter(DENTSL_POINT).equals(""))) {
					denstalPoint = req.getParameter(DENTSL_POINT);

				}
				masMedicalBoardProceedings.setDenstlPoint(denstalPoint);
				if(req.getParameter(CONDITION_OF_GUMS) != null && !req.getParameter(CONDITION_OF_GUMS).equals("")){
					masMedicalBoardProceedings.setConditionOfGums(req.getParameter(CONDITION_OF_GUMS));
				}

				String admissionStatus="";
								String specialistOpinion="";
								if (req.getParameter("admissionStatus") != null) 
								{
									admissionStatus ="y";
								} else {
									admissionStatus = "n";

								}
								
								if (req.getParameter("specialistOpinion") != null) 
								{
									specialistOpinion = "y";
								} else {
									specialistOpinion = "n";

								}
								if(req.getParameter("upperLimbs") != null && !req.getParameter("upperLimbs").equals("")){
									masMedicalBoardProceedings.setUpperLimbs(req.getParameter("upperLimbs"));
								}
					if(req.getParameter("locomotion") != null && !req.getParameter("locomotion").equals("")){
									masMedicalBoardProceedings.setLocomotion(req.getParameter("locomotion"));
					}
					if(req.getParameter("fullExpiration") != null && !req.getParameter("fullExpiration").equals("")){
							masMedicalBoardProceedings.setFullExpiration(req.getParameter("fullExpiration"));
					}
					String rangeofexpansion="";
					if (req.getParameter(RANGE_EXPANSION) != null )
					{
						rangeofexpansion  = req.getParameter(RANGE_EXPANSION);
					}
							
					masMedicalBoardProceedings.setRangeofexpansion(rangeofexpansion);
				
					if(req.getParameter("abnormalities") != null && !req.getParameter("abnormalities").equals("")){
							masMedicalBoardProceedings.setAbnormalities(req.getParameter("abnormalities"));
					}
					String albumin="";
					if (req.getParameter(ALBUMIN) != null && !(req.getParameter(ALBUMIN).equals("")))
					{
						albumin = req.getParameter(ALBUMIN);
					}
					masMedicalBoardProceedings.setAlbumin(albumin);
					String sugar="";
					if (req.getParameter(SUGAR) != null && !(req.getParameter(SUGAR).equals("")))
					{
						sugar = req.getParameter(SUGAR);
					}
							masMedicalBoardProceedings.setSugar(sugar);
					String otherAbnormalities="";		
					if (req.getParameter(OTHER_ABNORMALITIES) != null && !(req.getParameter(OTHER_ABNORMALITIES).equals(""))) 
					{
						otherAbnormalities = req.getParameter(OTHER_ABNORMALITIES);
					 }
					masMedicalBoardProceedings.setAnyOtheAbnormalities(otherAbnormalities);
					if(req.getParameter("anyEvidenceOfSkin") != null && !req.getParameter("anyEvidenceOfSkin").equals(""))
					{
						masMedicalBoardProceedings.setAnyEvidenceOfSkin(req.getParameter("anyEvidenceOfSkin"));
					}
					String pulseRates="";
					if (req.getParameter(PULSE_RATES) != null && !(req.getParameter(PULSE_RATES).equals(""))) {
								pulseRates = req.getParameter(PULSE_RATES);
					}
						masMedicalBoardProceedings.setPulseRates(pulseRates);
					String	bp="";
						if (req.getParameter(BP1) != null
										&& !(req.getParameter(BP1).equals("")))
						{
						  bp = req.getParameter(BP1);
						}
						masMedicalBoardProceedings.setBp(bp);
						if(req.getParameter("centralNervousSystem") != null && !req.getParameter("centralNervousSystem").equals(""))
						{
										masMedicalBoardProceedings.setCentralNervousSystem(req.getParameter("centralNervousSystem"));
						}
						String abdomen="";
						if (req.getParameter(ABDOMEN) != null
										&& !(req.getParameter(ABDOMEN).equals(""))) {
									abdomen = req.getParameter(ABDOMEN);
							}
						masMedicalBoardProceedings.setAbdomen(abdomen);		
						if(req.getParameter("liver") != null && !req.getParameter("liver").equals("")){
									masMedicalBoardProceedings.setLiver(req.getParameter("liver"));
								}
						if(req.getParameter("spleen") != null && !req.getParameter("spleen").equals("")){
									masMedicalBoardProceedings.setSpleen(req.getParameter("spleen"));
								}
						String CocatHicNevreData="";
						String hernia = "";
						if(req.getParameter(HERNIA_MUSCLE)!=null && !req.getParameter(HERNIA_MUSCLE).equals("")){
							hernia = req.getParameter(HERNIA_MUSCLE);
							masMedicalBoardProceedings.setHerniaMusic(hernia);
							CocatHicNevreData+="HerniaMuscle"+":"+req.getParameter(HERNIA_MUSCLE)+"/ ";
							}else
							{
								CocatHicNevreData+="HerniaMuscle"+":"+"NA"+"/ ";	
							}
						if(CocatHicNevreData!=null && !CocatHicNevreData.equals("")){
								masMedicalBoardProceedings.setDataOfNurveHic(CocatHicNevreData);
								}
								
						if(req.getParameter(SPEECH) != null && !req.getParameter(SPEECH).equals("")){
									masMedicalBoardProceedings.setSpeech(req.getParameter(SPEECH));
								}
						if(req.getParameter("mentalInstability") != null && !req.getParameter("mentalInstability").equals("")){
									masMedicalBoardProceedings.setMentalInstability(req.getParameter("mentalInstability"));
								}
						if(req.getParameter("essentialInstability") != null && !req.getParameter("essentialInstability").equals("")){
									masMedicalBoardProceedings.setEssentialInstability(req.getParameter("essentialInstability"));
								}
						if(req.getParameter("smoker") != null && !req.getParameter("smoker").equals("")){
									masMedicalBoardProceedings.setSmoker(req.getParameter("smoker"));
								}
								if(req.getParameter("drinker") != null && !req.getParameter("drinker").equals("")){
									masMedicalBoardProceedings.setDrinker(req.getParameter("drinker"));
								}
						if(req.getParameter(DEFECTS_NOT_TO_CAUSE_REJECTION) != null){
									masMedicalBoardProceedings.setDefectNotToCauseRejection(req.getParameter(DEFECTS_NOT_TO_CAUSE_REJECTION));
								}
						if(req.getParameter(FOUND_FIT_IN_CATEGORY) != null){
									masMedicalBoardProceedings.setFoundFitInCategory(req.getParameter(FOUND_FIT_IN_CATEGORY));
								}
						if(req.getParameter(SIGNED_BY) != null && !req.getParameter(SIGNED_BY).equals("")){
										masMedicalBoardProceedings.setSignedBy(req.getParameter(SIGNED_BY));
								}
						String medicinRemarks="";		
						if (req.getParameter(MEDICIN_REMARKS) != null
									&& !(req.getParameter(MEDICIN_REMARKS).equals(""))) {
								medicinRemarks = req.getParameter(MEDICIN_REMARKS);
							}
						masMedicalBoardProceedings.setRemarks(medicinRemarks);
										
								masMedicalBoardProceedings.setAdmissionStatus(admissionStatus);
								masMedicalBoardProceedings.setSpecialistOpinnionStatus(specialistOpinion);
                int visitNumberForReport=0;
				if(req.getParameter("visitNumberForReport") != null && !req.getParameter("visitNumberForReport").equals("")){
					visitNumberForReport=Integer.parseInt(req.getParameter("visitNumberForReport"));
				}
				String hinNoForreport=null;
				if(req.getParameter("hinNoForreport") != null && !req.getParameter("hinNoForreport").equals("")){
					hinNoForreport=req.getParameter("hinNoForreport");
				}
				String drugAllergy = "";
				if(req.getParameter("allergies") != null && !req.getParameter("allergies").equals("")){
					drugAllergy= req.getParameter("allergies");
					mapForDS.put("drugAllergy", drugAllergy);
				}
				String alcohol = "";
				if(req.getParameter("drinker") != null && !req.getParameter("drinker").equals("")){
					alcohol= req.getParameter("drinker");
					mapForDS.put("alcohol", alcohol);
				}
				if(req.getParameter("smokerLess10") != null){
					mapForDS.put("smokerLess10", "y");
				}else{
					mapForDS.put("smokerLess10", "n");
				}
				if(req.getParameter("smokerMore10") != null){
					mapForDS.put("smokerMore10", "y");
				}else{
					mapForDS.put("smokerMore10", "n");
				}
				
				String medicaltype=masMedicalBoardProceedings.getMedicalExamType();
		    	MasMedicalExaminationDetail medicaldetail=new MasMedicalExaminationDetail();
				Users maUser = new Users();
				maUser.setId(userId);
				masMedicalBoardProceedings.setMaUser(maUser);
				
				MasHospital hospital = new MasHospital();
				hospital.setId(hospitalId);
				masMedicalBoardProceedings.setHospital(hospital);
				if(req.getParameter("ReportingForExamBoard") != null && req.getParameter("ReportingForExamBoard").equals("MedExam")){
					masMedicalBoardProceedings.setMedicalType("MedicalExam");
					}else if(req.getParameter("ReportingForExamBoard") != null && req.getParameter("ReportingForExamBoard").equals("MedBoard")){
						
						masMedicalBoardProceedings.setMedicalType("MedicalBoard");
					}
				mapForDS.put("investigationDataStatus",investigationDataStatus);
				mapForDS.put("chargeCodeIdList", chargeCodeIdList);
				mapForDS.put("quantityList", quantityList);
				mapForDS.put("clinicalNotes1", clinicalNotes1);
				mapForDS.put("lastChangedBy", lastChangedBy);
				mapForDS.put("lastChangedDate", lastChangedDate);
				mapForDS.put("lastChangedTime", lastChangedTime);
				mapForDS.put("investigationReferToMHList", investigationReferToMHList);
				mapForDS.put("data", data);
				mapForDS.put("hospitalId", hospitalId);
				mapForDS.put("deptId", deptId);
				mapForDS.put("empId", empId);
				mapForDS.put("hinId", hinId);
				mapForDS.put("user", user);
				mapForDS.put("visitId", visitId);
				mapForDS.put("Labresult", req.getParameter("Labresult"));
				mapForDS.put("patientInvestigationHeaderId", patientInvestigationHeaderId);
				mapForDS.put("dgOrderhdId", dgOrderhdId);
				mapForDS.put("investResultList", investResultList);
				mapForDS.put("patientInvestigationdetailsIdList", patientInvestigationdetailsIdList);
				mapForDS.put("dgOrderdtIdList", dgOrderdtIdList);
				mapForDS.put("identification1", identification1);
				mapForDS.put("identification2", identification2);
				
				if(req.getParameter("Labresult").equalsIgnoreCase("present")&& data!=null)
				{
					
				if(req.getParameter("ReportingForExamBoard").equals("MedExam")){
					masMedicalBoardProceedings.setStatus("m");
					}else if(req.getParameter("ReportingForExamBoard").equals("MedBoard")){
						masMedicalBoardProceedings.setStatus("s");
					}
				masMedicalBoardProceedings.setModate(new Date());
				}else if(!masMedicalBoardProceedings.getStatus().equalsIgnoreCase("m")){
					masMedicalBoardProceedings.setStatus("p");
				}
				if (req.getParameter("dentalReferToMH") != null
						&& !(req.getParameter("dentalReferToMH").equals(""))) {
					denatlToMH = req.getParameter("dentalReferToMH");
					masMedicalBoardProceedings.setReferToMH(denatlToMH);
				}
				mapForDS.put("investigationDataStatus", investigationDataStatus);
				mapForDS.put("medExamId", medExamId); 
				//masMedicalBoardProceedings.setMedicalType("MedicalExam");
				mapForDS.put("masMedicalBoardProceedings", masMedicalBoardProceedings);
				
    	successfullyAdded = medicalExamHandlerService
						.updateMedicalExaminationBoardAnnual2A(mapForDS);
				message = "Record Updated Successfully!!";
				jsp = MEDICAL_BOARD_EXAM_MSG;
				if (!successfullyAdded) {
					message = "Some Problem Occured !!!";
					jsp = MEDICAL_BOARD_ERROR_MSG;
				}else if(data!=null)
				{if(req.getParameter("Labresult").equalsIgnoreCase("NotPresent"))
				{
					message = "Lab Result is not Found ! You Can Forward to Medical Officer After Lab Result.";
		
				}else{
					message = "Record  Forwarded Successfully !!";	
				}
					
				
				}
			
		}else
		{
			message = "You can forward to Medical Officer only after entering Investigation or Dental Reports";
			jsp = MEDICAL_BOARD_EXAM_MSG;
			
		}
			
			String investigationReferToMH="";
			
			String medicalEntryNo = "";
			String medicalEntryNo1 = "";
			jsp += ".jsp";
			map.put("investigationReferToMHList", investigationReferToMHList);	
			map.put("medicalEntryNo", medicalEntryNo);
			map.put("medicalEntryNo1", medicalEntryNo1);
			map.put("medicalExamType", req.getParameter("medicalExamType"));
			map.put("contentJsp", jsp);
			map.put("message", message);
			map.put("medExamId", medExamId); 
			map.put("hinNoForreport", req.getParameter("hinNoForreport"));
			map.put("visitNumberForReport", Integer.parseInt(req.getParameter("visitNumberForReport")));
			map.put("serviceNo", serviceNo);
			map.put("visitId", visitId);
			map.put("denatlToMH", denatlToMH);
			//map.put("investigationReferToMH", investigationReferToMH);
			return new ModelAndView("indexB", "map", map);
			
		
		}
	//-------------------- End updateMedicalExam Method for 2A-----------------------------
		public ModelAndView viewMedicalExamUploadDocument(HttpServletRequest request,
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
		   map =medicalExamHandlerService.getUploadDocumentMedicalExamData(dataMap);
		  
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
		public ModelAndView submitUploadDocumentsInvestigation(HttpServletRequest request,
				HttpServletResponse response) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> dataMap = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			MultipartFormDataRequest mrequest = null;
			String fileName = null;
			String message = null;
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
			map=medicalExamHandlerService.submitUploadDocumentsInvestForMedicalExam(dataMap);
			
		
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
			map=medicalExamHandlerService.displayFileUploadData(dataMap12);
			map.put("message", message);
			map.put("visitId", visitId);
			map.put("hinNo", hin_no);
			map.put("hinId", hinId);
			map.put("invest_id", investId);
			map.put("masExamId",masExamId);
			String jsp = "medicalExam_uploadInvestdoc";
			
			
			return new ModelAndView(jsp, "map", map);
		}
		public ModelAndView viewUploadDocumentsInvestigationDetails(HttpServletRequest request,
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
	        int investId=0;
	        if(request.getParameter("invest_id")!=null )
	        {
	        	investId = Integer.parseInt(request.getParameter("invest_id"));
	        	dataMap.put("investId",investId);
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
	        if(request.getParameter("masExam_Id")!=null )
	        {
	        	masExamId=Integer.parseInt(request.getParameter("masExam_Id"));
	        	dataMap.put("masExamId",masExamId);
	        }
			
		
	           map=medicalExamHandlerService.getUploadDocumentInvestigationDetails(dataMap);
				String jsp = "medicalExamViewDocumentInvestigation";
				map.put("hinId", hinId);
				map.put("invest_id", investId);
				map.put("visitId", visitId);
				map.put("contentJsp", jsp);
				return new ModelAndView(jsp, "map", map);
			
		}
		public ModelAndView viewMedicalExamInvestigationUploadDocument(HttpServletRequest request,
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
	        int investId=0;
	        if(request.getParameter("investId")!=null )
	        {
	        	investId =Integer.parseInt(request.getParameter("investId"));
	        }
	        dataMap.put("investId", investId);
		   dataMap.put("filename", filename);
		   dataMap.put("fileExtension", fileExtension);
		   dataMap.put("hinId", hinId);
		   dataMap.put("medExamId", medExamId);
		   dataMap.put("hospitalId", hospitalId);	
		   map =medicalExamHandlerService.getUploadDocumentMedicalExamInvestigationData(dataMap);
		  
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
		public ModelAndView initiateNewMedicalExam(HttpServletRequest request,HttpServletResponse response) 
		{
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> dataMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int userId = 0;
			Users user = (Users)session.getAttribute("users");
			userId = user.getId(); 
			Date lastChangedDate=null;
			String lastChangedTime="";
			int medExamId =0; 
			if(request.getParameter("medExamId") != null){
				medExamId = Integer.parseInt(request.getParameter("medExamId").toString());
			}
			Map<String, Object> mapForDS = new HashMap<String, Object>();
			//String jsp = MEDICAL_BOARD_EXAM_MSG;
			int hospitalId=0;
			if(session.getAttribute(HOSPITAL_ID)!=null)
			{	
			  hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			  mapForDS.put("hospitalId", hospitalId);
			}
			if (request.getParameter("consultingDoc") != null) {
				int empId = Integer.parseInt(request.getParameter("consultingDoc"));
				mapForDS.put("empId", empId);
			}else{
				if(session.getAttribute("users")!=null){
					user = (Users)session.getAttribute("users");
				}
				mapForDS.put("empId", user.getEmployee().getId());
			}
	        
	        if (request.getParameter(LAST_CHANGED_DATE) != null) {
				lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(LAST_CHANGED_DATE));
			}
			if (request.getParameter(LAST_CHANGED_TIME) != null) {
				lastChangedTime = request.getParameter(LAST_CHANGED_TIME);
			}
			dataMap.put("lastChangedDate", lastChangedDate);
		    dataMap.put("lastChangedTime", lastChangedTime);
			dataMap.put("userId", userId);
	        dataMap.put("hospitalId", hospitalId);
	        dataMap.put("medExamId", medExamId);
	        boolean successfullyAdded =false;
	        successfullyAdded=medicalExamHandlerService.initiateNewMedicalExam(dataMap);
			
			String message = "";
			String jsp = "";
			if(successfullyAdded)
				message = "Initiate New Medical Exam Successfully";
			else
				message = "Some Problem Occured !!";
		
			map = medicalExamHandlerService.showMedicalOfficerAppointment(mapForDS);
			jsp = "mb_medicalBoardSearchMedicalOfficerAppointment.jsp";
			
			map.put("message", message);
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
	
	}

public ModelAndView ShowMID_MedicalExam(HttpServletRequest request, HttpServletResponse response) {
	String jsp = "";
	
	Map map = new HashMap();
	Box box = HMSUtil.getBox(request);
    int visitId=0;
    String search="false";
    
    jsp = "MID_MedicalExam";
	jsp += ".jsp";
	
	map.put("contentJsp", jsp);
	 map.put("search", search);
	// map.put("title", title);
	return new ModelAndView("indexB", "map", map);

}

public ModelAndView getMID_MedicalExam(
		HttpServletRequest request, HttpServletResponse response) {
	String jsp = "";
	String serviceNo=null;
	Map<String, Object> mapfordata = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getParameter(SERVICE_NO) != null) {
		serviceNo = request.getParameter(SERVICE_NO);
	}
	mapfordata.put("serviceNo", serviceNo);
	map = medicalExamHandlerService.getMedicalExamDetails(mapfordata);
	
	//jsp = "MedicalExamDetailsResponse";
	jsp="MID_MedicalExam";
	jsp = jsp + ".jsp";
	map.put("contentJsp", jsp);
	

	return new ModelAndView("indexB", "map", map);
}

public ModelAndView editMID_MedicalExam(
		HttpServletRequest request, HttpServletResponse response) {
	String jsp = "";
	String serviceNo=null;
	Map<String, Object> mapfordata = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getParameter(SERVICE_NO) != null) {
		serviceNo = request.getParameter(SERVICE_NO);
	}
	mapfordata.put("serviceNo", serviceNo);
	map = medicalExamHandlerService.editMID_MedicalExam(mapfordata);
	
	//jsp = "MedicalExamDetailsResponse";
	jsp="editMID_MedicalExam";
	jsp = jsp + ".jsp";
	map.put("contentJsp", jsp);
	

	return new ModelAndView("indexB", "map", map);
}


public ModelAndView addMID_MedicalExam(	HttpServletRequest req, HttpServletResponse response) {
	Map<String, Object> mapForDS = new HashMap<String, Object>();
		
	Date medicalDate = null;
	String Height="";
	String waist="";
	String hips="";
	String whr="";
	String bp="";
	String pulseRates="";
	String serviceNo="";
	String lastChangedBy = "";
	String lastChangedTime = "";
	String name="";
	
	Date lastChangedDate = null;
	HttpSession session = req.getSession();
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	int userId = 0;
	Users user = (Users)session.getAttribute("users");
	userId = user.getId();
	int commandId = (Integer) session.getAttribute("commandId");

	Map<String, Object> map = new HashMap<String, Object>();
	MasMedicalExaminationReportOnEntry masMedicalBoardProceedings = new MasMedicalExaminationReportOnEntry();
	
	Map<String, Object> generalMap = new HashMap<String, Object>();
	List<MasMedicalBoardExaminationDetail> masMedicalBoardDetails = new ArrayList<MasMedicalBoardExaminationDetail>();

	if (req.getParameter(SERVICE_NO) != null) {
		serviceNo = req.getParameter(SERVICE_NO);
	}
	BigDecimal height = new BigDecimal(0);
	if (req.getParameter(HEIGHT) != null && !(req.getParameter(HEIGHT).equals(""))) 
	{
		height = (new BigDecimal(req.getParameter(HEIGHT)));
	}
	
	if (req.getParameter(DATE_TWO) != null) {
		medicalDate = HMSUtil.dateFormatterDDMMYYYY(req
				.getParameter(DATE_TWO));
	}
	if (req.getParameter(PULSE) != null) {
		pulseRates = req.getParameter(PULSE);
	}
	if (req.getParameter(WAIST) != null) {
		waist = req.getParameter(WAIST);
	}
	if (req.getParameter(HIPS) != null) {
		hips = req.getParameter(HIPS);
	}
	if (req.getParameter("WHR") != null) {
		whr = req.getParameter("WHR");
	}
	if (req.getParameter(BP) != null) {
		bp = req.getParameter(BP);
	}
	if (req.getParameter(LAST_CHANGED_BY) != null) {
		lastChangedBy = req.getParameter(LAST_CHANGED_BY);
	}
	if (req.getParameter(LAST_CHANGED_DATE) != null) {
		lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req.getParameter(LAST_CHANGED_DATE));
	}
	if (req.getParameter(LAST_CHANGED_TIME) != null) {
			lastChangedTime = req.getParameter(LAST_CHANGED_TIME);
	}
	String fullName="";
	if (req.getParameter(FULL_NAME) != null
			&& !(req.getParameter(FULL_NAME).equals(""))) {
		fullName = req.getParameter(FULL_NAME);
	}
	String message = "";
	String jsp = "";
	Boolean successfullyAdded = false;
	
	masMedicalBoardProceedings.setYearlySerialNo(serviceNo);
	masMedicalBoardProceedings.setNameInFull(fullName);

	masMedicalBoardProceedings.setDateOfReporting(medicalDate);
	masMedicalBoardProceedings.setHeight(height);
	//masMedicalBoardProceedings.setWeight(weight);
	masMedicalBoardProceedings.setPulseRates(pulseRates);
	masMedicalBoardProceedings.setBp(bp);

		masMedicalBoardProceedings.setLastChangedBy(lastChangedBy);
	masMedicalBoardProceedings.setLastChangedDate(lastChangedDate);
	masMedicalBoardProceedings.setLastChangedTime(lastChangedTime);
	masMedicalBoardProceedings.setServiceNo(serviceNo);
	masMedicalBoardProceedings.setWaist(waist);
	if(req.getParameter(RANK_ID) != null && !(req.getParameter(RANK_ID)).equals("0")){
		MasRank masRank = new MasRank();
		masRank.setId(Integer.parseInt(req.getParameter(RANK_ID)));
		masMedicalBoardProceedings.setRank(masRank);
	}
	if(req.getParameter(TRADE_ID) != null ){
		MasTrade masTrade = new MasTrade();
		masTrade.setId(Integer.parseInt(req.getParameter(TRADE_ID)));
		masMedicalBoardProceedings.setTrade(masTrade);
	}	
	if(req.getParameter(UNIT_ID) != null && !(req.getParameter(UNIT_ID)).equals("0")){
		MasUnit unitObj = new MasUnit();
		unitObj.setId(Integer.parseInt(req.getParameter(UNIT_ID)));
		masMedicalBoardProceedings.setUnit(unitObj);
	}	
	if(req.getParameter("apparentAge") != null && !req.getParameter("apparentAge").equals("")){
		String aparentage=req.getParameter("apparentAge");
		masMedicalBoardProceedings.setApparentAge(aparentage.substring(0, 2));
	}
	if(req.getParameter(VISIT_ID) != null && !(req.getParameter(VISIT_ID)).equals("0")){
		Visit visit = new Visit();
		visit.setId(Integer.parseInt(req.getParameter(VISIT_ID)));
		if(req.getParameter("apparentAge") == null )
		{
			if(masMedicalBoardProceedings.getVisit()!=null &&masMedicalBoardProceedings.getVisit().getAge()!=null)
			{
				
			masMedicalBoardProceedings.setApparentAge(masMedicalBoardProceedings.getVisit().getAge().substring(0, 2));
			}
		}
		masMedicalBoardProceedings.setVisit(visit);
	}		
	if(req.getParameter(HIN_ID) != null && !(req.getParameter(HIN_ID)).equals("0")){
		Patient patient= new Patient();
		patient.setId(Integer.parseInt(req.getParameter(HIN_ID)));
		masMedicalBoardProceedings.setHin(patient);
		mapForDS.put("hinId", Integer.parseInt(req.getParameter(HIN_ID)));
	}	
	
	if (req.getParameter("Hips") != null
			&& !(req.getParameter("Hips").equals(""))) {
		    masMedicalBoardProceedings.setHips(req.getParameter("Hips"));
	}
	if (req.getParameter("WHR") != null
			&& !(req.getParameter("WHR").equals(""))) {
		    masMedicalBoardProceedings.setWhr(req.getParameter("WHR"));
	}
	
	if(req.getParameter(PRESENT_MEDICAL_CATEGORY) != null && !(req.getParameter(PRESENT_MEDICAL_CATEGORY)).equals("0")){
		Category categ2 = new Category();
		categ2.setCategoryid(Integer.parseInt(req.getParameter(PRESENT_MEDICAL_CATEGORY)));
		masMedicalBoardProceedings.setPresentMedicalCategory(categ2);
	}

	masMedicalBoardProceedings.setServiceNo(serviceNo);
	masMedicalBoardProceedings.setYearlySerialNo(serviceNo);
	//smasMedicalBoardProceedings.setStatus("v");
	masMedicalBoardProceedings.setHeight(height);
	masMedicalBoardProceedings.setWaist(waist);
	masMedicalBoardProceedings.setHips(hips);
	masMedicalBoardProceedings.setBp(bp);
	masMedicalBoardProceedings.setPulseRates(pulseRates);
	masMedicalBoardProceedings.setDateOfReporting(medicalDate);

	if(req.getParameter(RANK_ID) != null && !(req.getParameter(RANK_ID)).equals("0")){
		MasRank masRank = new MasRank();
		masRank.setId(Integer.parseInt(req.getParameter(RANK_ID)));
		masMedicalBoardProceedings.setRank(masRank);
	}
	
	if(req.getParameter(TRADE_ID) != null ){
		MasTrade masTrade = new MasTrade();
		masTrade.setId(Integer.parseInt(req.getParameter(TRADE_ID)));
		masMedicalBoardProceedings.setTrade(masTrade);
	}
	if(req.getParameter(UNIT_ID) != null && !(req.getParameter(UNIT_ID)).equals("0")){
		MasUnit unitObj = new MasUnit();
		unitObj.setId(Integer.parseInt(req.getParameter(UNIT_ID)));
		masMedicalBoardProceedings.setUnit(unitObj);
	}	
	if(req.getParameter(PRESENT_MEDICAL_CATEGORY) != null && !(req.getParameter(PRESENT_MEDICAL_CATEGORY)).equals("0")){
		Category category = new Category();
		category.setCategoryid(Integer.parseInt(req.getParameter(PRESENT_MEDICAL_CATEGORY)));
		masMedicalBoardProceedings.setPresentMedicalCategory(category);
	}		
	
	MasHospital hospital = new MasHospital();
	hospital.setId(hospitalId);
	masMedicalBoardProceedings.setHospital(hospital);

	masMedicalBoardProceedings.setMedicalType("MedicalExam");
	mapForDS.put("lastChangedBy", lastChangedBy);
	mapForDS.put("lastChangedDate", lastChangedDate);
	mapForDS.put("lastChangedTime", lastChangedTime);
	mapForDS.put("hospitalId", hospitalId);
	successfullyAdded = medicalExamHandlerService.addMID_MedicalExam(masMedicalBoardProceedings,mapForDS);
	message = "Record Added Successfully!";
	jsp = MEDICAL_BOARD_EXAM_MSG;
	if (!successfullyAdded) {
		message = "Some Problem Occured !!!";
		jsp = MEDICAL_BOARD_ERROR_MSG;
	}
	
jsp += ".jsp";
map.put("contentJsp", jsp);
map.put("message", message);
map.put("serviceNo", serviceNo);

return new ModelAndView("indexB", "map", map);

}
public ModelAndView getPatientDetailAndAddMedicalExam(	HttpServletRequest req, HttpServletResponse response) 
{
	Map<String, Object> map= new HashMap<String, Object>();
	HttpSession session = req.getSession();
	String serviceNo="";
	if(req.getParameter(SERVICE_NO) != null && !(req.getParameter(SERVICE_NO).equals("")))
	{
		serviceNo=req.getParameter(SERVICE_NO);
	}
	
	map=medicalExamHandlerService.getPatientDetailAndAddMedicalExam(serviceNo);
	String jsp="";
	jsp="medicalExamAddDetailsJsp.jsp";
	map.put("contentJsp", jsp);
	

	return new ModelAndView("indexB", "map", map);

}
//-------------------------------------------------------------------------------

public ModelAndView addOldMedicalExamData(HttpServletRequest req, HttpServletResponse response) 
{
	Map<String, Object> dataMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();

    String allergies = "";
    HttpSession session = req.getSession();
    int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
    dataMap.put("hospitalId", hospitalId);
    int userId = 0;
    try
    {
    Users user = (Users)session.getAttribute("users");
    userId = user.getId();
    dataMap.put("user", user);
     if (req.getParameter(SERVICE_NO) != null)
    {
      String serviceNo = req.getParameter(SERVICE_NO);
      dataMap.put("serviceNo", serviceNo);
    }
    if (req.getParameter("hinId") != null)
    {
      int hinId = Integer.parseInt(""+req.getParameter("hinId"));
      dataMap.put("hinId", hinId);
    }
    if (req.getParameter("genderId") != null)
    {
      int genderId = Integer.parseInt(""+req.getParameter("genderId"));
      dataMap.put("genderId", genderId);
    }
    if (req.getParameter("presentRank") != null)
    {
      int rankId = Integer.parseInt(""+req.getParameter("presentRank"));
      dataMap.put("rankId", rankId);
    }
    if (req.getParameter("patientName") != null)
    {
      String patientName =req.getParameter("patientName");
      dataMap.put("patientName", patientName);
    }
    if (req.getParameter("tradeId") != null)
    {
      int tradeId = Integer.parseInt(""+req.getParameter("tradeId"));
      dataMap.put("tradeId", tradeId);
    }
    if (req.getParameter("ageId") != null)
    {
      String age = req.getParameter("ageId");
      dataMap.put("age", age);
    }
  
    if (req.getParameter("presentUnit") != null)
    {
      int unitId = Integer.parseInt(""+req.getParameter("presentUnit"));
      dataMap.put("unitId", unitId);
    }
    if (req.getParameter("genderId") != null)
    {
      int genderId = Integer.parseInt(""+req.getParameter("genderId"));
      dataMap.put("genderId", genderId);
    }
    
    if (req.getParameter(DATE_COMMENCEMENT) != null &&  !req.getParameter(DATE_COMMENCEMENT).equals("")) 
    {
    	Date dateofcommun =HMSUtil.dateFormatterDDMMYYYY(req.getParameter(DATE_COMMENCEMENT));
    	dataMap.put("dateofcommun", dateofcommun);
    }

   if(req.getParameter(PRESENT_MEDICAL_CATEGORY) != null && !req.getParameter(PRESENT_MEDICAL_CATEGORY).equals("0")) 
   {
	Category categ2 = new Category();
	categ2.setCategoryid(Integer.parseInt(req.getParameter(PRESENT_MEDICAL_CATEGORY)));
	dataMap.put("presentMedicalCatId", categ2);
   }
   if (req.getParameter(LAST_AME) != null ) {
	String lastAmePlace = req.getParameter(LAST_AME);
	dataMap.put("lastAmePlace", lastAmePlace);
   }
  if (req.getParameter("commandId") != null)
  {
   int commandId = Integer.parseInt(""+req.getParameter("commandId"));
   dataMap.put("commandId", commandId);
   }
  
  if (req.getParameter(REPORTED_DATE) != null &&  !req.getParameter(REPORTED_DATE).equals("")) 
  {
  	Date reportedDate =HMSUtil.dateFormatterDDMMYYYY(req.getParameter(REPORTED_DATE));
  	dataMap.put("reportedDate", reportedDate);
  }
   if (req.getParameter(DATE_OF_AME) != null &&  !req.getParameter(DATE_OF_AME).equals("")) 
   {
   	Date lastAmeDate =HMSUtil.dateFormatterDDMMYYYY(req.getParameter(DATE_OF_AME));
   	dataMap.put("lastAmeDate", lastAmeDate);
   }
   
   if (req.getParameter("period") != null ) {
		String period = req.getParameter("period");
		dataMap.put("period",period);
	   }
   if (req.getParameter("waiver") != null ) {
		String waiver = req.getParameter("waiver");
		dataMap.put("waiver",waiver);
	   }
	 if (req.getParameter("medExamType") != null ) 
	 {
		String medExamType = req.getParameter("medExamType");
		dataMap.put("medExamType",medExamType);
	 }
	 String waist = "";
	 if (req.getParameter("waist") != null
				&& !(req.getParameter("waist").equals("")))
	 {
		 waist = req.getParameter("waist");
			 
	}dataMap.put("waist", waist);
     String hip = "";
		 if (req.getParameter("hip") != null
					&& !(req.getParameter("hip").equals("")))
		 {
			 hip = req.getParameter("hip");
				 
			}dataMap.put("hip", hip);
		String whr ="";
			 if (req.getParameter("whr") != null
						&& !(req.getParameter("whr").equals("")))
			 {
				 whr =req.getParameter("whr");
					 
				}dataMap.put("whr", whr);	
		String pulse ="";
			if (req.getParameter("pulse") != null
			&& !(req.getParameter("pulse").equals("")))
				 {
				pulse =req.getParameter("pulse");
						 
			}dataMap.put("pulse", pulse);	
	String bp ="";
			 if (req.getParameter("bp") != null
						&& !(req.getParameter("bp").equals("")))
			 {
				 bp =req.getParameter("bp");
					 
			}
			 dataMap.put("bp", bp);	
		
					
	BigDecimal height = new BigDecimal(0);
	 if (req.getParameter(HEIGHT_WITHOUT_SHOOSE) != null
				&& !(req.getParameter(HEIGHT_WITHOUT_SHOOSE).equals("")))
	 {
			height = (new BigDecimal(req.getParameter(HEIGHT_WITHOUT_SHOOSE)));
			 
		}dataMap.put("height", height);
	 BigDecimal weight = new BigDecimal(0);
		if (req.getParameter(ACTUAL_WEIGHT) != null
				&& !(req.getParameter(ACTUAL_WEIGHT).equals(""))) 
		{
			weight = (new BigDecimal(req.getParameter(ACTUAL_WEIGHT)));
			
		} dataMap.put("weight", weight);
		BigDecimal idealWeight = new BigDecimal(0);
		if (req.getParameter(IDEAL_WEIGHT) != null
				&& !(req.getParameter(IDEAL_WEIGHT).equals(""))) 
		{
			idealWeight = (new BigDecimal(req.getParameter(IDEAL_WEIGHT)));
			
		}
		 dataMap.put("idealWeight", idealWeight);
		BigDecimal overWeight = new BigDecimal(0);
		if (req.getParameter(OVER_WEIGHT) != null
				&& !(req.getParameter(OVER_WEIGHT).equals(""))) 
		{
			overWeight = (new BigDecimal(req.getParameter(OVER_WEIGHT)));
			 
		}dataMap.put("overWeight", overWeight);
		if (req.getParameter("smokerMore10") != null)
	   {
			if(req.getParameter("smokerMore10").equalsIgnoreCase("y"))
			{
				dataMap.put("smokerMore10", "y");
			}else
			{
				dataMap.put("smokerMore10", "n");
			}
		}else
		{
			dataMap.put("smokerMore10", "n");
		}
		if (req.getParameter("smokerLess10") != null)
		{
			if(req.getParameter("smokerLess10").equalsIgnoreCase("y"))
			{
				dataMap.put("smokerLess10", "y");
			}else
			{
				dataMap.put("smokerLess10", "n");
			}
		}else
		{
			dataMap.put("smokerLess10", "n");
		}
		
		if (req.getParameter("alcohol") != null) 
		{
			String alcohol= req.getParameter("alcohol");
			dataMap.put("alcohol", alcohol);
		}
   if(req.getParameter("allergies") != null) 
   {
	allergies= req.getParameter("allergies");
	dataMap.put("allergies", allergies);
   }
int deptId=0;
if (req.getParameter("deptId") != null ) {
	deptId  = Integer.parseInt(req.getParameter("deptId"));
	dataMap.put("deptId", deptId);
}


//-----------------------------------------------------------------------
    String[] familyHistoryArray = null;
   if (req.getParameterValues(FM_DM) != null && !(req.getParameterValues(FM_DM).equals(""))) 
   {
        familyHistoryArray =(String[])req.getParameterValues(FM_DM);
    }
    dataMap.put("familyHistoryArray", familyHistoryArray);
    String otherFamilyHistory="";
    if (req.getParameter("otherFamilyHistory") != null)
    {
       otherFamilyHistory=req.getParameter("otherFamilyHistory");
       dataMap.put("otherFamilyHistory", otherFamilyHistory);
    }

//-----------------------------------------------------------------------------------------------

   String lastChangedBy="";
   Date lastChangedDate=null;
   String lastChangedTime="";
   if (req.getParameter(LAST_CHANGED_BY) != null) 
   {
	lastChangedBy = req.getParameter(LAST_CHANGED_BY);
	dataMap.put("lastChangedBy", lastChangedBy);
}
if (req.getParameter(LAST_CHANGED_DATE) != null) {
	lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
			.getParameter(LAST_CHANGED_DATE));
	dataMap.put("lastChangedDate", lastChangedDate);
}
if (req.getParameter(LAST_CHANGED_TIME) != null) {
	lastChangedTime = req.getParameter(LAST_CHANGED_TIME);
	dataMap.put("otherFamilyHistory", otherFamilyHistory);
	
}
dataMap.put("lastChangedTime", lastChangedTime);
	//masMedicalBoardProceedings.setAdmissionStatus("n");
//	masMedicalBoardProceedings.setSpecialistOpinnionStatus("n");
	
int hdbDisability=0;

if (req.getParameter("hdbDisability") != null)
{
	hdbDisability = Integer.parseInt(req.getParameter("hdbDisability"));
}
List<String> systemDiagnosisList=new ArrayList<String>();
List<Integer> systemDiagnosisIdList=new ArrayList<Integer>();

for (int i = 1; i <=hdbDisability; i++)
{
	String str="";
	if(req.getParameter("systemDiagnosis"+i) != null )
	{
	str=req.getParameter("systemDiagnosis"+i);
	}else
	{
	str="";
	}
	/*if(req.getParameter("icdDisability"+i) != null ){
		str=req.getParameter("icdDisability"+i);
		}else{
		str="";
		}*/
	if(str!=""){
	String systemDiagnosis="";
	int lastIndex=str.indexOf("[");
	if(lastIndex>0)
	{   
	systemDiagnosis=str.substring(0, lastIndex);
	}else
	{
	systemDiagnosis=str;
	}
	int index1 = str.lastIndexOf("[");
    int index2 = str.lastIndexOf("]");
     int systemDiagnosisId =0;
    systemDiagnosisList.add(systemDiagnosis);
    try {
    	systemDiagnosisId =Integer.parseInt(str.substring((index1+1),index2));
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(systemDiagnosisId>0)
	{
		systemDiagnosisIdList.add(systemDiagnosisId);
	}
	//masMedicalExaminationDetail.setPrincipal(systemDiagnosis);
	//masMedicalExaminationDetail.setParticular("Disability");
	
	}
	}
dataMap.put("systemDiagnosisIdList", systemDiagnosisIdList);
dataMap.put("systemDiagnosisList", systemDiagnosisList);
map=medicalExamHandlerService.addOldMedicalExamData(dataMap);
}catch (Exception e)
{
	e.printStackTrace();
}
String message="";
boolean status=false;
status=(Boolean)map.get("status");
if(status==true)
{
	message="Record Added Successfully.";
}else
{
	message="Some Problem Occured!";
}
String jsp="";
//jsp="MedicalExamDetailsjsp.jsp";
jsp="messageForAddManualMedicalExam.jsp";
map.put("contentJsp", jsp);
map.put("message", message);
return new ModelAndView("indexB", "map", map);

}
//-----------------------------------------------------------------------------


public ModelAndView printMedicalCaseSheetForMedicalExam(HttpServletRequest request,HttpServletResponse response)
{
		Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> parameters= new HashMap<String,Object>();
	int MedExamId=0;
	if(request.getParameter("medExamId")!= null)
	{
		MedExamId = Integer.parseInt(request.getParameter("medExamId"));
		
	}
	int hospitalId=0;
	    HttpSession session = request.getSession();
	    if(session.getAttribute(HOSPITAL_ID)!=null)
	    	hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	 int visit_id=0;   
	if(request.getParameter("visitId")!= null)
	 {
		visit_id= Integer.parseInt(request.getParameter("visitId"));
	 }
		Map<String,Object> detailsMap=new HashMap<String,Object>();
	detailsMap = medicalExamHandlerService.getConnectionForReport();		
	parameters.put("MedExamId", MedExamId);
	parameters.put("hospitalId", hospitalId);
	parameters.put("visit_id", visit_id);
	parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
	"/reports/")); 		  
	HMSUtil.generateReport("mb_med_case_sheet_for_exam", parameters, (Connection)detailsMap.get("conn") , response, getServletContext());			
	return null;
	
}
public ModelAndView printSpecialistOpinionForMedicalExam(HttpServletRequest request,HttpServletResponse response)
{
		Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> parameters= new HashMap<String,Object>();
	int MedExamId=0;
	if(request.getParameter("medExamId")!= null)
	{
		MedExamId = Integer.parseInt(request.getParameter("medExamId"));
		
	}
	int hospitalId=0;
	    HttpSession session = request.getSession();
	    if(session.getAttribute(HOSPITAL_ID)!=null)
	    	hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	 int visit_id=0;   
	if(request.getParameter("visitId")!= null)
	 {
		visit_id= Integer.parseInt(request.getParameter("visitId"));
	 }
		Map<String,Object> detailsMap=new HashMap<String,Object>();
	detailsMap = medicalExamHandlerService.getConnectionForReport();		
	parameters.put("Medical_exam_id", MedExamId);
	parameters.put("hospitalId", hospitalId);
	parameters.put("visit_id", visit_id);
	parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
	"/reports/")); 		  
	HMSUtil.generateReport("mb_specialist_opinion", parameters, (Connection)detailsMap.get("conn") , response, getServletContext());			
	return null;
	
}


//Method By Tirath



public LabHandlerService getLabHandlerService() {
	return labHandlerService;
}

public void setLabHandlerService(LabHandlerService labHandlerService) {
	this.labHandlerService = labHandlerService;
}
public void showHelpForExam(HttpServletRequest request,HttpServletResponse response) {

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
			
	
	// String whiteList = "*.zip";
	// String whiteList = "*.jpg";

	// Long fileSizeLimit = 2097152l;

	/*
	 * List fileUploadedList = null; fileUploadedList =
	 * HMSUtil.uploadFile(mrequest,uploadURL, whiteList,
	 * box.getString("filename"));
	 * Boolean fileUploaded=false; if(fileUploadedList != null &&
	 * fileUploadedList.size()!=0) { fileUploaded = (Boolean)
	 * fileUploadedList.get(0); }
	 */
	
	try {
		
		response.setContentType("application/pdf");
		
		response.setHeader("Content-Disposition", "attachment;filename="
				+ java.net.URLEncoder.encode("Medical Exam.pdf")
				+ "");

		// response.setContentType("image/"+fileExtension);
		// response.setHeader("Content-Disposition", "attachment;
		// filename="+filename+"."+fileExtension);

		File f = new File(uploadURL + "/Medical Exam.pdf");
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

/**
 * Code By Ritu for search in perusing authority wait list
 * 20 Nov 2012
 */
public ModelAndView searchMedicalExamPerAuthority(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	int hospitalId=0;
	if(session.getAttribute(HOSPITAL_ID)!=null)
	{	
	  hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	box.put("hospitalId", hospitalId);
	map = medicalExamHandlerService.searchMedicalExamPerAuthority(box);
	jsp = "mb_medicalExamPerAuWating";
	
	jsp += ".jsp";
	title = "Medical Board Proceeding Search";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("indexB", "map", map);
}

//--------------------Specialist Opinion Code by anamika-------------------------
public void forwardMedExamSpecialOpinion(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box = HMSUtil.getBox(request);
	HttpSession session = request.getSession();
	int userId = 0;
	String medicalType = null;
	Users user = (Users) session.getAttribute("users");
	userId = user.getId();
	int medExamId = 0;
	if (request.getParameter("medExamId") != null
			&& !request.getParameter("medExamId").equals("0")) {
		medExamId = Integer.parseInt(request.getParameter("medExamId")
				.toString());
	}
	int visitId = 0;
	if (request.getParameter("visitId") != null
			&& !request.getParameter("visitId").equals("0")) {
		visitId = Integer.parseInt(request.getParameter("visitId")
				.toString());
	}
	box.put("userId", userId);
	String flagForward = "";
	if (request.getParameter("flagForward") != null
			&& !request.getParameter("flagForward").equals("")) {
		flagForward = request.getParameter("flagForward");
	}
	box.put("flagForward", flagForward);
	int hospitalId = 0;
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}

	map = medicalExamHandlerService.validateMedExamSpecialOpinion(box);
	boolean successfullyAdded = false;

	if (map.get("successfullyAdded") != null) {
		successfullyAdded = (Boolean) map.get("successfullyAdded");
	}
	String message = "";
	if (flagForward.equalsIgnoreCase("s")) {
		message = "Forwarded to Specialist Successfully....";
	} else {
		message = "Specialist Opinion Validated Successfully....";
	}
	map.put("message", message);

	try {
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<msg>" + message + "</msg>");
		sb.append("</item>");
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

public ModelAndView showMedicalExamSpecialist(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	String jsp = "";
	String title = "";

	int hospitalId = 0;
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	map = medicalExamHandlerService.showMedicalExamSpecialist(hospitalId);

	title = "Medical Board  Specialist Opinion Waiting List";
	jsp = "mb_medicalExamSpecialist";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}
public ModelAndView showSpecialistOpinionJspForExam(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	int medExamId = 0;
	if (request.getParameter("medExamId") != null) {
		medExamId = Integer.parseInt(request.getParameter("medExamId"));
	}
	int visitId = 0;
	if (request.getParameter("visitId") != null) {
		visitId = Integer.parseInt(request.getParameter("visitId"));
	}
	String directFlag = "";
	if (request.getParameter("directFlag") != null) {
		directFlag = request.getParameter("directFlag");
	}
	String SecialFlag = "";
	if (request.getParameter("SecialFlag") != null) {
		SecialFlag = request.getParameter("SecialFlag");
	}
	dataMap.put("medExamId", medExamId);
	dataMap.put("visitId", visitId);
	HttpSession session = request.getSession();
	int deptId = (Integer) session.getAttribute("deptId");
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	dataMap.put("hospitalId", hospitalId);
	dataMap.put("deptId", deptId);
	map = medicalExamHandlerService.showMedicalExamListForSpecialist(dataMap);
	map.put("SecialFlag", SecialFlag);
	String jsp = "medExam_specialistOpinion";
	if (directFlag.equalsIgnoreCase("D")) {
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("directFlag", "D");
		return new ModelAndView("index", "map", map);
	} else {
		map.put("directFlag", "N");
		return new ModelAndView(jsp, "map", map);
	}
}


public ModelAndView validateMedicalExamSpecialOpinion(
		HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box = HMSUtil.getBox(request);
	HttpSession session = request.getSession();
	int userId = 0;
	String medicalType = null;
	Users user = (Users) session.getAttribute("users");
	userId = user.getId();
	int medExamId = 0;
	if (request.getParameter("medExamId") != null
			&& !request.getParameter("medExamId").equals("0")) {
		medExamId = Integer.parseInt(request.getParameter("medExamId")
				.toString());
	}
	String directFlag = "";
	if (request.getParameter("directFlag") != null) {
		directFlag = request.getParameter("directFlag");
	}
	int visitId = 0;
	if (request.getParameter("visitId") != null) {
		visitId = Integer.parseInt(request.getParameter("visitId")
				.toString());
	}
	box.put("userId", userId);
	int hospitalId = 0;
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	box.put("hospitalId", hospitalId);
	int hinId = 0;
	if (request.getParameter("hinId") != null
			&& request.getParameter("hinId") != "") {
		hinId = Integer.parseInt(request.getParameter("hinId"));
	}
	// String orderNo="";
	int orderNo = 0;
	if (request.getParameter("dgOrderhdId") != null
			&& request.getParameter("dgOrderhdId") != "") {
		orderNo = Integer.parseInt(request.getParameter("dgOrderhdId"));
	}
	map = medicalExamHandlerService.updateMedicalExamEntryBySpecialist(box);
	boolean updated = false;
	if (map.get("successfullyAdded") != null) {
		updated = (Boolean) map.get("successfullyAdded");
	}
	boolean successfullyAdded = false;

	if (updated) {
		map = medicalExamHandlerService.validateMedExamSpecialistOpinion(box);
	}
	if (map.get("successfullyAdded") != null) {
		successfullyAdded = (Boolean) map.get("successfullyAdded");
	}
	String jsp = "";

	if (directFlag.equalsIgnoreCase("D")) {
		/*
		 * map =
		 * medicalBoardHandlerService.showMedicalBoardSpecialist(hospitalId
		 * );
		 * 
		 * title = "Medical Board  Specialist Opinion Waiting List"; jsp =
		 * "mb_medicalBoardSpecialist"; jsp += ".jsp";
		 */
		String message = "Specialist Opinion Validated Successfully....";
		map.put("message", message);
		map.put("medExamId", medExamId);
		map.put("visitId", visitId);
		map.put("hinId", hinId);
		map.put("dgOrderhdOrderNo", orderNo);
		jsp = "mb_medicalExamSpecialistMsg";
		jsp = jsp + ".jsp";

		map.put("contentJsp", jsp);
		map.put("directFlag", "D");
		return new ModelAndView("index", "map", map);
	} else {
		// String message="Specialist Opinion Validated Successfully....";
		String message = "";
		map.put("message", message);
		jsp = "mb_medicalExamSpMsg";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("directFlag", "N");
		map.put("hinId", hinId);
		map.put("dgOrderhdOrderNo", orderNo);
		return new ModelAndView("indexB", "map", map);
	}

	// return new ModelAndView("indexB", "map", map);
}

public ModelAndView updateMedicalExamEntryBySpecialist(
		HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box = HMSUtil.getBox(request);
	boolean successfullyAdded = false;
	HttpSession session = request.getSession();
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	box.put("hospitalId", hospitalId);
	int userId = 0;
	Users user = (Users) session.getAttribute("users");
	userId = user.getId();
	box.put("userId", userId);
	map = medicalExamHandlerService.updateMedicalExamEntryBySpecialist(box);
	if (map.get("successfullyAdded") != null) {
		successfullyAdded = (Boolean) map.get("successfullyAdded");
	}
	List<String> investigationReferToMHList = new ArrayList<String>();
	if (map.get("investigationReferToMHList") != null) {
		investigationReferToMHList = (List) map
				.get("investigationReferToMHList");
	}
	String message = "";
	String jsp = "";
	if (successfullyAdded) {
		message = "Record Updated Successfully.";
		jsp = MEDICAL_BOARD_EXAM_MSG + ".jsp";
	} else if (!successfullyAdded) {
		message = "Some Problem Occured !!!";
		jsp = MEDICAL_BOARD_ERROR_MSG + ".jsp";
	}
	map.put("investigationReferToMHList", investigationReferToMHList);
	map.put("message", message);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}


//By Mansi on 20 March 2013
public ModelAndView showMeStaticsReport(HttpServletRequest request,
		HttpServletResponse response) {
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
	
	
	if (!box.getString(FROM_DATE).equals("")) {
		fromDate = HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE));
	}
	
	if (!box.getString(TO_DATE).equals("")) {
		toDate = HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE));
	}
	String qry = "";

	if(request.getParameter("cmdId")!=null && !request.getParameter("cmdId").equals("0") && !request.getParameter("cmdId").equals("") && request.getParameter("hospitalId").equals("0") && request.getParameter("hospitalId").equals("")){
		
		qry += "  and mh.command_id="+Integer.parseInt(request.getParameter("cmdId"));
	}else{
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0") && !request.getParameter("hospitalId").equals("")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		qry += "  and mas_medical_examination_report.hospital_id="+hospitalId;
	}
System.out.println("qry---"+qry);
	if(box.getInt(SERVICE_TYPE_ID)!=0){
		qry += " and mas_medical_examination_report.service_type_id = "+box.getInt(SERVICE_TYPE_ID)+"";
	}
   if(box.getInt("fromRankId")!=0 && box.getInt("toRankId")!=0){
		qry += " and mas_medical_examination_report.rank_id between "+box.getInt("fromRankId")+" and "+box.getInt("toRankId");
	}
   if(box.getString("fromServ")!="" && box.getString("toServ")!=""){
		qry += " and mas_medical_examination_report.total_service between "+box.getString("fromServ")+" and "+box.getString("toServ");
	}
   
	if(box.getInt(TRADE_ID)!=0){
		qry += " and mas_medical_examination_report.branch_id = "+box.getInt(TRADE_ID)+"";
	}
	if(box.getInt(UNIT_ID)!=0){
		qry += " and mas_medical_examination_report.unit_id = "+box.getInt(UNIT_ID)+"";
	}
	if(box.getInt(SECTION_ID)!=0){
		qry += " and mas_medical_examination_report.section_id = "+box.getInt(SECTION_ID)+"";
	}
		if (!(box.getString(SERVICE_NO).equals(""))) {
		qry += " and mas_medical_examination_report.serviceno='"+box.getString(SERVICE_NO)+"'";
	}
	System.out.println("overweight="+box.getString("overWeight"));
		if (box.getString("overWeight").equals("y")) {
			System.out.println("overweiht checked");
			qry += " and to_number(mas_medical_examination_report.overweight)>=20.0 and to_number(mas_medical_examination_report.overweight)<=30.0";
		}
	if(box.getInt("CategoryId")!=0){
				qry += " and mas_medical_examination_report.presentMedicalCategory = "+box.getInt("CategoryId")+"";
			}
	if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
			&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
		String fromAge = box.getString("fromAge");
		String toAge = box.getString("toAge");
		qry +=" and substr(mas_medical_examination_report.apparent_age,0,INSTR(mas_medical_examination_report.apparent_age,' ')) >="+fromAge+" " +
				" and  substr(mas_medical_examination_report.apparent_age,INSTR(mas_medical_examination_report.apparent_age,' ')+1,length(mas_medical_examination_report.apparent_age))='"+box.getString("fromAgeUnit")+"'" +
				" and substr(mas_medical_examination_report.apparent_age,0,INSTR(mas_medical_examination_report.apparent_age,' ')) <="+toAge+" " +
				" and  substr(mas_medical_examination_report.apparent_age,INSTR(mas_medical_examination_report.apparent_age,' ')+1,length(mas_medical_examination_report.apparent_age))='"+box.getString("toAgeUnit")+"'";
		
	}
	System.out.println(qry);
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	detailsMap = medicalExamHandlerService.getConnectionForReport();
	Map<String, Object> parameters = new HashMap<String, Object>();
	parameters.put("fromDate", fromDate);
	parameters.put("toDate", toDate);
	parameters.put("qry", qry);
	parameters.put("hospitalId", hospitalId);
	HMSUtil.generateReport("MESTATISTICS", parameters,
			(Connection) detailsMap.get("conn"), response,
			getServletContext());
	return null;
}

public ModelAndView showForm44Jsp(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	int hospitalId = 0;
	HttpSession session = request.getSession();
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	map = medicalExamHandlerService.showForm44Jsp(hospitalId);
	String jsp = "me_form44.jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);

}	

public ModelAndView showForm44Report(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> parameters = new HashMap<String, Object>();
	/*if(request.getParameter(UNIT_ID)!=null && !request.getParameter(UNIT_ID).equals("")){
		parameters.put("unitId", Integer.parseInt(request.getParameter(UNIT_ID)));
	}
	String serviceNo = "";
	if(request.getParameter("serviceNo") != null){
		serviceNo = request.getParameter("serviceNo");
		parameters.put("serviceNo", serviceNo);
	}
	int rankId = 0;
	if(request.getParameter("rank") != null){
		rankId =Integer.parseInt(request.getParameter("rank"));
		parameters.put("rankId", rankId);
	}
	int tradeId = 0;
	if(request.getParameter("trade") != null){
		tradeId =Integer.parseInt(request.getParameter("trade"));
	}
	map = medicalExamHandlerService.getRankList(rankId,tradeId);
	String rankName = "";
	String tradeName = "";
	if(map.get("rankName") != null){
		rankName = (String)map.get("rankName");
		parameters.put("rankName", rankName);
	}
	if(map.get("tradeName") != null){
		tradeName = (String)map.get("tradeName");
		parameters.put("tradeName", tradeName);
	}
	String totalServYrs = "";
	String name = "";
	if(request.getParameter("name") != null){
		name = request.getParameter("name");
	}
	String lastName = "";
	if(request.getParameter("lastName") != null){
		lastName = request.getParameter("lastName");
	}
	String sName = "";
	if(name != null && lastName != null){
		sName = name+" "+lastName;
		parameters.put("sName", sName);
	}else{
		sName = name;
		parameters.put("sName", sName);
	}
	String age = "";
	if(request.getParameter("age") != null){
		age = request.getParameter("age");
		parameters.put("age", age);
	}
	if(request.getParameter("totalServYrs") != null){
		totalServYrs =request.getParameter("totalServYrs");
		parameters.put("totalServYrs", totalServYrs);
	}*/
	int vId=0;
	if(request.getParameter("vId") != null){
		vId =  (Integer.parseInt(request.getParameter("vId")));
		parameters.put("vId", vId);
	}
	
	
	detailsMap = medicalExamHandlerService.getConnectionForReport();

	
	HMSUtil.generateReport("mb_form44Report", parameters,
			(Connection) detailsMap.get("conn"), response,
			getServletContext());
	return null;
}


public ModelAndView showAFMSF7AReportJsp(
		HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "me_AFMSF7A.jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("indexB", "map", map);
}

@SuppressWarnings( { "unchecked", "unchecked" })
public ModelAndView AFMSF7AReport(
		HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> parameters = new HashMap<String, Object>();
	int visiNo = 0;
	String hinNo = "";
	int visitId =0;
	HttpSession session = request.getSession();
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	String hospitalName = medicalExamHandlerService.getHospitalName(hospitalId);
	parameters.put("hospitalName", hospitalName);
	if(request.getParameter(UNIT_ID)!=null && !request.getParameter(UNIT_ID).equals("")){
		parameters.put("unitId", Integer.parseInt(request.getParameter(UNIT_ID)));
	}
	String serviceNo = "";
	if(request.getParameter("serviceNo") != null){
		serviceNo = request.getParameter("serviceNo");
		parameters.put("serviceNo", serviceNo);
	}
	int rankId = 0;
	if(request.getParameter("rank") != null){
		rankId =Integer.parseInt(request.getParameter("rank"));
		parameters.put("rankId", rankId);
	}
	int tradeId = 0;
	if(request.getParameter("trade") != null){
		tradeId =Integer.parseInt(request.getParameter("trade"));
	}

	if(request.getParameter("visitId") != null){
		visitId =Integer.parseInt(request.getParameter("visitId"));
		parameters.put("visitId", visitId);
	}
	
	map = medicalExamHandlerService.getRankList(rankId,tradeId);
	String rankName = "";
	String tradeName = "";
	if(map.get("rankName") != null){
		rankName = (String)map.get("rankName");
		parameters.put("rankName", rankName);
	}
	if(map.get("tradeName") != null){
		tradeName = (String)map.get("tradeName");
		parameters.put("tradeName", tradeName);
	}
	String totalServYrs = "";
	String name = "";
	if(request.getParameter("name") != null){
		name = request.getParameter("name");
	}
	String lastName = "";
	if(request.getParameter("lastName") != null){
		lastName = request.getParameter("lastName");
	}
	String sName = "";
	if(name != null && lastName != null){
		sName = name+" "+lastName;
		parameters.put("sName", sName);
	}else{
		sName = name;
		parameters.put("sName", sName);
	}
	String age = "";
	if(request.getParameter("age") != null){
		age = request.getParameter("age");
		parameters.put("age", age);
	}
	
	parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(	"/reports/"));
	Map<String, Object> detailsMap = new HashMap<String, Object>();

	detailsMap = medicalExamHandlerService.getConnectionForReport();
	HMSUtil.generateReport("afmsf7a", parameters,
			(Connection) detailsMap.get("conn"), response,
			getServletContext());
	return null;
}
public ModelAndView showPrintValidateMOMedicalExam
(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	HttpSession session = request.getSession();
	int hospitalId = 0;
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	
	map = medicalExamHandlerService.showPrintValidateMOMedicalExam(hospitalId);
	jsp = "mb_toPrintValidateMOMedicaExam";

	jsp += ".jsp";
	title = "Approving Authority Waiting List";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("indexB", "map", map);
 }

public ModelAndView generateMBToPrint(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> infoMap = new HashMap<String, Object>();
	Map<String, Object> parameters = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	detailsMap = medicalExamHandlerService.getConnectionForReport();
	int visit_id = 0;

	if (request.getParameter("parent") != null
			&& !(request.getParameter("parent").equals(""))) {
		visit_id = Integer.parseInt(request.getParameter("parent"));
	}
	
	parameters.put("visit_id", visit_id);
	map = medicalExamHandlerService.getMedicalType(visit_id);
	String medicalType = "";
	if (map.get("medicalType") != null) {
		medicalType = (String) map.get("medicalType");
	}
	int medical_examination_id = 0;
	if(request.getParameter("medExamid") != null){
		medical_examination_id = Integer.parseInt(request.getParameter("medExamid"));
		parameters.put("medical_examination_id", medical_examination_id);
	}
	parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
	if (medicalType.equalsIgnoreCase("Annual Medical Exam(AFMSF-3B)") || medicalType.equalsIgnoreCase("High Altitude Med. Exam(AFMSF-3B)")) {
		HMSUtil.generateReport("AnnualMedicalExaminationReportToPrint", parameters,
				(Connection) detailsMap.get("conn"), response,getServletContext());
	} else if (medicalType.equalsIgnoreCase("Med. Exam On Release/Discharge(AFMSF-18)")) {
		
		HMSUtil.generateReport("MedicalExamReportonreleasedischarge", parameters,
				(Connection) detailsMap.get("conn"), response,getServletContext());
	}else if (medicalType.equalsIgnoreCase("Primary/Extension Med. Exam(AFMSF-2A)")) {
		HMSUtil.generateReport("primarymedical_examinationreport", parameters,
				(Connection) detailsMap.get("conn"), response,getServletContext());
	}

	return null;
}

public ModelAndView showAFMSF7AJsp(HttpServletRequest request, HttpServletResponse response) {
	HttpSession session = request.getSession();
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	MultipartFormDataRequest mrequest = null;
	int visitId = 0;

	int hospitalId = (Integer) session.getAttribute("hospitalId");
	int empId = (Integer) session.getAttribute("userId");
	if (MultipartFormDataRequest.isMultipartFormData(request)) {
		try {
			mrequest = new MultipartFormDataRequest(request);
			visitId = Integer.parseInt(request.getParameter("visitId"));
		} catch (UploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} else {
		visitId = Integer.parseInt(request.getParameter("visitId"));
	}
	int deptId = (Integer) session.getAttribute("deptId");
	Map<String, Object> mapForDS = new HashMap<String, Object>();
    if (request.getParameter("visitId") != null && !request.getParameter("visitId").equals("")) {
		visitId = Integer.parseInt(request.getParameter("visitId"));
	}
    mapForDS.put("deptId", deptId);
	mapForDS.put("visitId", visitId);
	map = medicalExamHandlerService.showAFMSF7AJsp(mapForDS);

	List patientDataList = (List) map.get("patientDataList");
	Visit visit = (Visit) patientDataList.get(0);
	int visitNo = visit.getVisitNo();
	int hinId = visit.getHin().getId();
	mapForDS.put("deptId", deptId);
	mapForDS.put("visitNo", visitNo);
	mapForDS.put("hinId", hinId);
	mapForDS.put("visitId", visitId);
	
	
	jsp = "mb_AFMSF7AJsp";
	jsp += ".jsp";
	title = "Patient Details";
	map.put("visitId", visitId);
	map.put("deptId", deptId);
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("indexB", "map", map);



}
@SuppressWarnings("unused")
public ModelAndView submitAFMSF7AJsp(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> mapForDS = new HashMap<String, Object>();
	Map<String, Object> mapForDSPro = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	int hinId = Integer.parseInt(request.getParameter("hinId"));
	//int departmentId = Integer.parseInt(request.getParameter("departmentId"));
	int departmentId = (Integer) session.getAttribute("deptId");
	int visitId = Integer.parseInt(request.getParameter("visitId"));
	
	int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));

	int empId = 0;
	if (request.getParameter("empId") != null
			&& request.getParameter("empId") != "") {
		empId = Integer.parseInt(request.getParameter("empId"));
	}
	int empIdCurrnet = 0;
	empIdCurrnet = (Integer) session.getAttribute("userId");
	String gpe_examination = null;
	String systamicExam = null;
	String height = null;
	String weight = null;
	String pulse = null;
	int visitNo = 0;
	String days = null;
	String bp = null;
	String rr = null;
	String temperature = null;
	String serviceNo = null;
	String hinNo = null;
	String plan = null;
	String name="";
	String initialDiagnosis = null;
	//String disposal = "";
	String nextVisitDate = null;
	String afmsDescription = null;
	String userName = null;
	String flag = null;
	boolean submitData = false;
	String urlDept = "";
	String departmentName = "";
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	
	String whr="";
	String allergies = "";
	String reviewAt = "";
	String pName="";
	if (request.getParameter("pName") != null) {
		pName = request.getParameter("pName");
	}

	if (request.getParameter("height") != null) {
		height = request.getParameter("height");
	}
	if (request.getParameter("whr") != null) {
		whr = request.getParameter("whr");
	}
		
	if (request.getParameter("weight") != null) {
		weight = request.getParameter("weight");
	}
	if (request.getParameter("pulse") != null) {
		pulse = request.getParameter("pulse");
	}
	if (request.getParameter(VISIT_NUMBER) != null) {
		visitNo = Integer.parseInt(request.getParameter(VISIT_NUMBER));
	}
	int priority = 0;
	if(request.getParameter("urgent") != null){
		priority = Integer.parseInt(request.getParameter("urgent"));
	}
	if (request.getParameter("bp") != null) {
		bp = request.getParameter("bp");
	}
	if (request.getParameter("temperature") != null) {
		temperature = request.getParameter("temperature");
	}
	if (request.getParameter(SERVICE_NO) != null) {
		serviceNo = request.getParameter(SERVICE_NO);
	}
	if (request.getParameter(HIN_NO) != null) {
		hinNo = request.getParameter(HIN_NO);
	}
	if (request.getParameter("plan") != null) {
		plan = request.getParameter("plan");
	}

	String referedToMH="";
	
	if (request.getParameter("referedToMH") != null && !request.getParameter("referedToMH").equals("")) {
		referedToMH = request.getParameter("referedToMH");
	}else{
		referedToMH="n";
	}
	String mh = "";
	if (request.getParameter("mh") != null) {
		mh = request.getParameter("mh");
	}
	String mhDepartment = "";
	if (request.getParameter("mhDepartment") != null) {
		mhDepartment = request.getParameter("mhDepartment");
	}
	String mhReferredFor = "";
	if (request.getParameter("mhReferredFor") != null) {
		mhReferredFor = request.getParameter("mhReferredFor");
	}
	
	
	if (request.getParameter("gpe_examination") != null) {
		gpe_examination = request.getParameter("gpe_examination");
	}
	if (request.getParameter("systamicExam") != null) {
		systamicExam = request.getParameter("systamicExam");
	}
	if (request.getParameter("rr") != null) {
		rr = request.getParameter("rr");
	}
	
	
	String referredDoctars = "";
	String[] referredDoctarsArray = null;

	if (request.getParameterValues("referredDoctarsId") != null) {
		referredDoctarsArray = (String[]) request
				.getParameterValues("referredDoctarsId");
		for (int i = 0; i < referredDoctarsArray.length; i++) {
			if (i == 0)
				referredDoctars = referredDoctarsArray[i];
			else
				referredDoctars = referredDoctars + ","
						+ referredDoctarsArray[i];
		}
	}
	if (request.getParameter("initialDiagnosis") != null) {
		initialDiagnosis = request.getParameter("initialDiagnosis");
	}

	if (request.getParameter("days") != null) {
		days = request.getParameter("days");
	}
	String disposalDays= "";
	if (request.getParameter("disposalDays") != null) {
		disposalDays = request.getParameter("disposalDays");
	}
	

	if (request.getParameter("nextVisitDate") != null) {
		nextVisitDate = request.getParameter("nextVisitDate");
	}
	if (request.getParameter("afmsDescription") != null) {
		afmsDescription = request.getParameter("afmsDescription");
	}
	if (request.getParameter("userName") != null) {
		userName = request.getParameter("userName");
	}
	Users user = (Users) session.getAttribute("users");

	Integer userId = user.getId();

	String presentComplain = "";
	
	String onExamination = "";
	String otherDetails = "";

	String riskFactor = "";
	String bmi = "";
	String idealWeight = "";

	if (request.getParameter("presentComplain") != null) {
		presentComplain = request.getParameter("presentComplain");
	}

	if (request.getParameter("riskFactor") != null) {
		riskFactor = request.getParameter("riskFactor");
	}
	if (request.getParameter("bmi") != null) {
		bmi = request.getParameter("bmi");
	}
	if (request.getParameter("idealWeight") != null) {
		idealWeight = request.getParameter("idealWeight");
	}

	
	if (request.getParameter("reviewAt") != null) {
		reviewAt= request.getParameter("reviewAt");
		
	}
	
	/**
	 * End
	 */
	

	if (request.getParameter("OtherDetails") != null) {
		otherDetails = request.getParameter("OtherDetails");
	}

	if (!request.getParameter("onExamination").equals("")
			&& (request.getParameter("onExamination") != null)) {
		onExamination = request.getParameter("onExamination");
	}


	String consultationDate = request.getParameter("consultationDate");
	String consultationTime = request.getParameter("consultationTime");


	List<String> pvmsNoList = new ArrayList<String>();
	List<Integer> frequencyList = new ArrayList<Integer>();
	List<String> dosageList = new ArrayList<String>();
	List<String> remarksList = new ArrayList<String>();
	List<String> typeLeftRightList = new ArrayList<String>();
	List<String> instructionList = new ArrayList<String>();
	List<Integer> totalList = new ArrayList<Integer>();
	List<Integer> noOfDaysList = new ArrayList<Integer>();
	List<String> routeList = new ArrayList<String>();
	List<Integer> itemConversionList = new ArrayList<Integer>();
	
	String[] diagnosisIdAray = null;
	
	if (request.getParameterValues(DIAGNOSIS_ID) != null) {
		diagnosisIdAray = (String[]) request.getParameterValues(DIAGNOSIS_ID);
	}

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

	int j = 1;
	for (int i = 0; i < hdb; i++) {
		String pvmsNo = "";
		int itemId = 0;
		if (request.getParameter("nomenclature" + j) != null && !request.getParameter("nomenclature" + j).equals("")) {
			String nomenclature = request.getParameter("nomenclature" + j);
			String nomen = request.getParameter("nomenclature" + j).substring(0, request.getParameter("nomenclature" + j).indexOf("["));
			nomenclatureList.add(nomen);

			 int index1 = nomenclature.lastIndexOf("(");
			 int index2 = nomenclature.lastIndexOf(")");
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

		j++;
	}

	String otherTreatment =  "";
	if(request.getParameter("otherTreatment")!=null && !request.getParameter("otherTreatment").equals("")){
		otherTreatment = request.getParameter("otherTreatment");
		mapForDS.put("otherTreatment", otherTreatment);
	}
	String otherInvestigation =  "";
	if(request.getParameter("otherInvestigation")!=null && !request.getParameter("otherInvestigation").equals("")){
		otherInvestigation = request.getParameter("otherInvestigation");
		mapForDS.put("otherInvestigation", otherInvestigation);
	}
	
	
	List<String> chargeCodeIdList = new ArrayList<String>();

	List<String> referToMhList = new ArrayList<String>();
	String clinicalNotes1 = "";
	if (request.getParameter("clinicalNotes1") != null
			&& !(request.getParameter("clinicalNotes1").equals(""))) {
		clinicalNotes1 = request.getParameter("clinicalNotes1");
	}
	int hiddenValue = 1;
	if (Integer.parseInt(request.getParameter("hiddenValue")) != 1) {
		hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
	}
	int temp = 1;
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
			
				if(request.getParameter("referToMh" + temp) != null && !request.getParameter("referToMh" +temp).equals("")){
					String referToMh = request.getParameter("referToMh" + temp);
					referToMhList.add(referToMh);
				}else{
					String referToMh = "n";
					referToMhList.add(referToMh);
				}
				chargeCodeIdList.add(chargeCodeIdArr[i]);
			}
		}
		temp++;
	}
	
int catId=0;
	if (request.getParameter(PRESENT_MEDICAL_CATEGORY) != null &&  !request.getParameter(PRESENT_MEDICAL_CATEGORY).equals("0")) 
	{
		catId=Integer.parseInt(request.getParameter(PRESENT_MEDICAL_CATEGORY));
	}String lastame="";
	if (request.getParameter(LAST_AME) != null ) {
		lastame = request.getParameter(LAST_AME);
	}
	
	String conditionOfGums="";
	if (request.getParameter("conditionOfGums") != null ) {
		conditionOfGums = request.getParameter("conditionOfGums");
	}
	String dateLast="";
	if(request.getParameter(DATE_OF_AME) != null && !request.getParameter(DATE_OF_AME).equals("")){
		dateLast= request.getParameter(DATE_OF_AME);
	}
	int rankId=0;
	if (request.getParameter(RANK_ID) != null &&  !request.getParameter(RANK_ID).equals("0")) 
	{
		rankId=Integer.parseInt(request.getParameter(RANK_ID));
	}
	
	int tradeId=0;
	if (request.getParameter(TRADE_ID) != null &&  !request.getParameter(TRADE_ID).equals("0")) 
	{
		tradeId=Integer.parseInt(request.getParameter(TRADE_ID));
	}
	
	mapForDS.put("catId", catId);
	mapForDS.put("rankId", rankId);
	mapForDS.put("tradeId", tradeId);
	mapForDS.put("lastame", lastame);
	mapForDS.put("dateLast", dateLast);
	mapForDS.put("conditionOfGums", conditionOfGums);
	mapForDS.put("deptId",  (Integer)session.getAttribute("deptId"));
	mapForDS.put("referredDoctars", referredDoctars);
	mapForDS.put("itemIdList", itemIdList);
	mapForDS.put("frequencyList", frequencyList);
	mapForDS.put("ctList", ctList);
	mapForDS.put("dosageList", dosageList);
	mapForDS.put("typeLeftRightList", typeLeftRightList);
	mapForDS.put("instructionList", instructionList);
	mapForDS.put("routeList", routeList);
	
	mapForDS.put("pName", pName);
	mapForDS.put("serviceNo", serviceNo);
	mapForDS.put("totalList", totalList);
	mapForDS.put("noOfDaysList", noOfDaysList);
	mapForDS.put("hinId", hinId);
	mapForDS.put("departmentId", departmentId);
	mapForDS.put("remarksList", remarksList);
	mapForDS.put("userId", userId);
	mapForDS.put("visitId", visitId);
	mapForDS.put("hospitalId", hospitalId);
	mapForDS.put("userName", userName);
	mapForDSPro.put("visitId", visitId);
	mapForDSPro.put("consultationDate", consultationDate);
	mapForDSPro.put("diagnosisIdAray", diagnosisIdAray);
	
	
	String userSrNo = (String)session.getAttribute("userSrNo");
	mapForDSPro.put("userSrNo",userSrNo);
	
	mapForDS.put("otherMedicineList", otherMedicineList);
	mapForDS.put("nomenclatureList", nomenclatureList);
	mapForDS.put("itemConversionList", itemConversionList);
	
	// ----------data for investigation template------

	mapForDS.put("chargeCodeIdList", chargeCodeIdList);
	mapForDS.put("clinicalNotes1", clinicalNotes1);
	mapForDS.put("referToMhList", referToMhList);
	
	// ------------data for opd patient details----------
	mapForDS.put("empId", empId);
	mapForDS.put("empIdCurrnet", empIdCurrnet);
	
	mapForDS.put("height", height);
	mapForDS.put("whr", whr);
	
	mapForDS.put("days", days);
	mapForDS.put("disposalDays",disposalDays);
	mapForDS.put("weight", weight);
	mapForDS.put("pulse", pulse);
	mapForDS.put("bp", bp);
	mapForDS.put("consultationDate", consultationDate);
	mapForDS.put("consultationTime", consultationTime);
	mapForDS.put("temperature", temperature);
	mapForDS.put("afmsDescription", afmsDescription);
	mapForDS.put("plan", plan);
	mapForDS.put("initialDiagnosis", initialDiagnosis);
	//mapForDS.put("referredDept", referredDept);
	mapForDS.put("nextVisitDate", nextVisitDate);
	mapForDS.put("presentComplain", presentComplain);

	mapForDS.put("allergies", allergies);
	mapForDS.put("reviewAt", reviewAt);
	mapForDS.put("otherDetails", otherDetails);
	mapForDS.put("onExamination", onExamination);
	mapForDS.put("days", days);

	mapForDS.put("referedToMH", referedToMH);
	mapForDS.put("mh", mh);
	mapForDS.put("mhDepartment", mhDepartment);
	mapForDS.put("mhReferredFor", mhReferredFor);


	mapForDS.put("gpe_examination", gpe_examination);
	mapForDS.put("rr", rr);
	mapForDS.put("systamicExam", systamicExam);
	mapForDS.put("riskFactor", riskFactor);
	mapForDS.put("bmi", bmi);
	mapForDS.put("idealWeight", idealWeight);
	// --------- data for diagnosis------------
	mapForDS.put("diagnosisIdAray", diagnosisIdAray);
	mapForDS.put("deptId", departmentId);
	mapForDS.put("mapForDSPro", mapForDSPro);
	mapForDS.put("priority", priority);
	
	Map<String, Object> returnMap = new HashMap<String, Object>();
	Map<String, Object> returnPro1 = new HashMap<String, Object>();
	Map<String, Object> returnPro2 = new HashMap<String, Object>();
	Map<String, Object> returnPro3 = new HashMap<String, Object>();
	boolean bool = false;
	
	returnMap = medicalExamHandlerService.submitAFMSF7AJsp(mapForDS);
	String message = null;
	if (returnMap.get("succesfullyAdded") != null) {
		bool = (Boolean) returnMap.get("succesfullyAdded");
		message = "AFMSF-7A Details Submitted.Do you want to print?";
		jsp="mb_7AMessage";
	}
	
	else {
		
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = medicalExamHandlerService.showMedicalExamWaitingList(hospitalId);
		message = "Error Occurred in Submitting Details.";
		jsp = "mb_medicalExamWaitingList";
	}
	jsp += ".jsp";
	
	map.put("message", message);
	map.put("deptId", departmentId);
	map.put("visitNoForReport", visitNo);
	map.put("serviceNoForReport", serviceNo);
	map.put("visitId", visitId);
	map.put("hinNoForReport", hinNo);
	title = "Patient Details";
	map.put("urlDept", urlDept);
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("referedToMH", referedToMH);
	map.put("submitData", submitData);
	return new ModelAndView("indexB", "map", map);
}


//----------By Kiran Form 44 jsp after clicking on waiting list

public ModelAndView showMeForm44JSP(HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		int hospitalId=0;
		int visitId=0;
		if
		(request.getParameter("visitId")!= null)
		{
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("visitId", visitId);
	
		String jsp = "";
		String title = "";
		
		map = medicalExamHandlerService.showMeForm44JSP(generalMap);
		jsp = "me_form44WaitingList";
		jsp += ".jsp";
		title = "form 44 Waiting List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

public ModelAndView submitMedicalExamForm44(HttpServletRequest request,HttpServletResponse response) 
{
	HttpSession session = request.getSession();
	Map<String, Object> map = new HashMap<String, Object>();
	session = request.getSession();
	int hinNumber = 0;
	//int basisOfDiagnosis = 0;
	
	
	String clinical = "";
	String disposal = "";
	
   int hospitalId =0;
   
   int hinId=0;
   int visitId=0;
   
   if(session.getAttribute("hospitalId")!= null)
     {	   hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
     }
   
   /*int empId = 0;
	if (request.getParameter("empId") != null && request.getParameter("empId") != "") 
	{
		empId = Integer.parseInt(request.getParameter("empId"));
	}*/
	if (request.getParameter("hinNumber") != null
			&& !(request.getParameter("hinNumber").equals(""))) {
		hinNumber = Integer.parseInt(request.getParameter("hinNumber"));
	}
		
	if (request.getParameter("clinical") != null
			&& !(request.getParameter("clinical").equals(""))) {
		clinical = request.getParameter("clinical");
	}
	
	if (request.getParameter("disposal") != null
			&& !(request.getParameter("disposal").equals(""))) {
		disposal = request.getParameter("disposal");
	}
		
	if(request.getParameter("hinId") != null && !(request.getParameter("hinId").equals("")))
	{
		hinId=(Integer.parseInt(request.getParameter("hinId")));
	}
	
	if(request.getParameter("visitId") != null && !(request.getParameter("visitId").equals("")))
	{
		visitId=(Integer.parseInt(request.getParameter("visitId")));
	}
	
	
	map.put("hinNumber", hinNumber);
	
	map.put("hospitalId", hospitalId);
	//map.put("empId", empId);

	map.put("hinId", hinId);
	map.put("visitId", visitId);
	
	map.put("clinical", clinical);
	map.put("disposal", disposal);
	
	boolean successfullyAdded = medicalExamHandlerService.submitMedicalExamForm44(map);
	
	int vId = 0;
	if(map.get("vId")!=null)
	{
		vId= (Integer)map.get("vId");
	}
	
	String message = "";
	String jsp = "";
	String title = "";
	
	if (successfullyAdded) {
		message = "Record Added Successfully. Do You Want Print !!";
	} else {
		message = "Try Again !!";
	}
	jsp = "messageForForm44";
	title = "Submit Form 44";
	jsp += ".jsp";

	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("vId", vId);
	map.put("message", message);

	return new ModelAndView("indexB", "map", map);
}

//----------------------------- AME Data Entry------------------------------


public ModelAndView showAmeDataEntryList(HttpServletRequest request,
		HttpServletResponse response) {

	Map<String, Object> map = new HashMap<String, Object>();
	map = medicalExamHandlerService.showAmeDataEntryList();
	String jsp = "ameDataEntry.jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}

public ModelAndView getServiceNo(HttpServletRequest request, HttpServletResponse response) {
	
System.out.println("in method");
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	Box box  = HMSUtil.getBox(request);
	String serviceNo = "";
	if (request.getParameter(SERVICE_NO) != null
			&& !request.getParameter(SERVICE_NO).equals("")) {
		serviceNo = request.getParameter(SERVICE_NO);
	}
	dataMap.put("serviceNo", serviceNo);
	map = medicalExamHandlerService.getServiceNo(dataMap);
	
	return new ModelAndView("responseForServiceNoDetails","map",map);
}

//--------------------------------------------------------
public ModelAndView addAmeDataEntry(HttpServletRequest req,HttpServletResponse res)
{
	Map<String, Object> mapForDS = new HashMap<String, Object>();
	String serviceNo = "";
	String rank = "";
	String name = "";
	String trade = "";
	String place = "";
	Date dateAmeData = null;
	Date medicinExamDate = null;
	String lastChangedBy = "";
	String lastChangedTime = "";
	Date lastChangedDate = null;
	
	HttpSession session = req.getSession();
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	int userId = 0;
	Users user = (Users)session.getAttribute("users");
	userId = user.getId();
	
	int commandId = (Integer) session.getAttribute("commandId");

	Map<String, Object> map = new HashMap<String, Object>();

	MasMedicalExaminationReportOnEntry masMedicalBoardProceedings = new MasMedicalExaminationReportOnEntry();

	Map<String, Object> generalMap = new HashMap<String, Object>();
	List<MasMedicalBoardExaminationDetail> masMedicalBoardDetails = new ArrayList<MasMedicalBoardExaminationDetail>();

	if (req.getParameter(SERVICE_NO) != null) {
		serviceNo = req.getParameter(SERVICE_NO);
	}

	
	String  fullName="";
	if (req.getParameter(FULL_NAME) != null
			&& !(req.getParameter(FULL_NAME).equals(""))) {
		fullName = req.getParameter(FULL_NAME);
	}
	if (req.getParameter("place") != null
			&& !(req.getParameter("place").equals(""))) {
		place = req.getParameter("place");
	}

	
	if (req.getParameter(RANK) != null
			&& !(req.getParameter(RANK).equals(""))) {
		rank = req.getParameter(RANK);
	}

	if (req.getParameter(LAST_CHANGED_BY) != null) {
		lastChangedBy = req.getParameter(LAST_CHANGED_BY);
	}
	if (req.getParameter(LAST_CHANGED_DATE) != null) {
		lastChangedDate = HMSUtil.dateFormatterDDMMYYYY(req
				.getParameter(LAST_CHANGED_DATE));
	}
	if (req.getParameter(LAST_CHANGED_TIME) != null) {
		lastChangedTime = req.getParameter(LAST_CHANGED_TIME);
	}
	
	generalMap.put("serviceNo", serviceNo);
	generalMap.put("pojoPropertyCode", "serviceNo");
	generalMap.put("pojoName", "MasMedicalExaminationReportOnEntry");
	String message = "";
	String jsp = "";
	Boolean successfullyAdded = false;
		
		masMedicalBoardProceedings.setYearlySerialNo(serviceNo);
		masMedicalBoardProceedings.setServiceNo(serviceNo);
		masMedicalBoardProceedings.setNameInFull(fullName);
	
		if(req.getParameter(RANK_ID) != null && !(req.getParameter(RANK_ID)).equals("0")){
			MasRank masRank = new MasRank();
			masRank.setId(Integer.parseInt(req.getParameter(RANK_ID)));
			masMedicalBoardProceedings.setRank(masRank);
		}
		if(req.getParameter(TRADE_ID) != null ){
			MasTrade masTrade = new MasTrade();
			masTrade.setId(Integer.parseInt(req.getParameter(TRADE_ID)));
			masMedicalBoardProceedings.setTrade(masTrade);
		}	
		
		if(req.getParameter("presentMedCat") != null && !req.getParameter("presentMedCat").equals("0")){
			Category category = new Category();
			category.setCategoryid(Integer.parseInt(req.getParameter("presentMedCat")));
			masMedicalBoardProceedings.setPastMedicalCategory(category);
			
		}

		if(req.getParameter(DATE_OF_AME) != null && !req.getParameter(DATE_OF_AME).equals("")){
			masMedicalBoardProceedings.setDateMedicalBoardExam(HMSUtil.convertStringTypeDateToDateType(req.getParameter(DATE_OF_AME)));
		}
		
		if(req.getParameter(PRESENT_MEDICAL_CATEGORY) != null && !(req.getParameter(PRESENT_MEDICAL_CATEGORY)).equals("0")){
			Category categ2 = new Category();
			categ2.setCategoryid(Integer.parseInt(req.getParameter(PRESENT_MEDICAL_CATEGORY)));
			masMedicalBoardProceedings.setPresentMedicalCategory(categ2);
		}
		
			
		if (req.getParameter("medCatPeriod") != null  && !req.getParameter("medCatPeriod").equals("")) {
			if (req.getParameter("medCatDuration") != null) {
				String medCatDuration = req.getParameter("medCatDuration");
				String finalMedCat = req.getParameter("medCatPeriod").concat(" ").concat(medCatDuration);
				masMedicalBoardProceedings.setPeriod(finalMedCat);
			
			}
		}
		
		
		Users maUser = new Users();
		maUser.setId(userId);
		masMedicalBoardProceedings.setMaUser(maUser);
		
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		masMedicalBoardProceedings.setHospital(hospital);
		
		MasCommand command = new MasCommand();
		command.setId(commandId);
		masMedicalBoardProceedings.setCommand(command);		

		
		masMedicalBoardProceedings.setPlace(place);
		
		masMedicalBoardProceedings.setStatus("p");
		masMedicalBoardProceedings.setMedicalType("MedicalExam");
		masMedicalBoardProceedings.setMedicalExamType("Annual Medical Exam(AFMSF-3B)");
		mapForDS.put("lastChangedBy", lastChangedBy);
		mapForDS.put("lastChangedDate", lastChangedDate);
		mapForDS.put("lastChangedTime", lastChangedTime);
		mapForDS.put("hospitalId", hospitalId);

		
		map = medicalExamHandlerService.addAmeDataEntry(masMedicalBoardProceedings);
		if(map.get("successfullyAdded") !=null){
			successfullyAdded=(Boolean)map.get("successfullyAdded");
		}
		message = "Record Added Successfully!";
		jsp = "msgAmeDataEntry";
		if (!successfullyAdded) {
			message = "Some Problem Occured !!!";
			jsp = "msgAmeDataEntry";
		}
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("message", message);
	map.put("serviceNo", serviceNo);
	return new ModelAndView("indexB", "map", map);

}
}


