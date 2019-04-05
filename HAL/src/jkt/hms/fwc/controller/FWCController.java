package jkt.hms.fwc.controller;

import static jkt.hms.util.RequestConstants.*;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.FWC_WAITING_LIST_JSP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;

import jkt.hms.masters.business.BudgetExpenseEntryDetail;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.FwcGrowthChart;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasImmunization;
import jkt.hms.masters.business.MasMedicalUploadDocument;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.OpdAntenatalCard;
import jkt.hms.masters.business.OpdCardiologyDepartmentDetails;
import jkt.hms.masters.business.OpdCaseSheet;
import jkt.hms.masters.business.OpdEnt;
import jkt.hms.masters.business.OpdGastroEnterologyColonoscopy;
import jkt.hms.masters.business.OpdGastroEnterologyEndoscopy;
import jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesOne;
import jkt.hms.masters.business.OpdGravidagramGestationalDiabitiesTwo;
import jkt.hms.masters.business.OpdGravidagramHtn;
import jkt.hms.masters.business.OpdOphthalmology;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.OpdPatientHistory;
import jkt.hms.masters.business.OpdTemplate;
import jkt.hms.masters.business.OpdTemplateDepartmentWise;
import jkt.hms.masters.business.OpdUrology;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAllergicDrugsDt;
import jkt.hms.masters.business.PatientAllergicDrugsHd;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.PhysiotherapyVisitDetails;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.opd.handler.OPDHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hms.adt.handler.RegistrationHandlerService;
import jkt.hms.fwc.handler.FWCHandlerService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class FWCController extends MultiActionController {
	FWCHandlerService fwcHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	OPDHandlerService opdHandlerService = null;
	 public OPDHandlerService getOpdHandlerService() {
		return opdHandlerService;
	}

	public void setOpdHandlerService(OPDHandlerService opdHandlerService) {
		this.opdHandlerService = opdHandlerService;
	}

	HttpSession session = null;
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	String message = "";
	String code = "";
	String name = "";
	String changedBy = "";
	String jspName = "";
	String url = "";

	@SuppressWarnings("unchecked")
	public ModelAndView showWaitingPatientListJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		mapForDS.put("hospitalId", hospitalId);
		if (request.getParameter("filter") != null) {
			int empId = Integer.parseInt(request.getParameter("consultingDoc"));
			mapForDS.put("empId", empId);
		}

		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			// session.setAttribute("deptId", deptId);
			mapForDS.put("deptId", deptId);
		} else {
			deptId = (Integer) session.getAttribute("deptId");
			mapForDS.put("deptId", deptId);
		}
		String title = request.getParameter("title");
		map = fwcHandlerService.getWaitingPatientList(mapForDS);
		List patientList = (List) map.get("patientList");
		map.put("patientList", patientList);
		jsp = FWC_WAITING_LIST_JSP;
		jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unused")
	public ModelAndView searchWaitingPatientListJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		String serviceTypeName = "";

		int deptId = (Integer) session.getAttribute("deptId");
		
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String date = request.getParameter("date");
		mapForDS.put("hospitalId", hospitalId);
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);
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
		if (request.getParameter(SERVICE_TYPE_NAME) != null
				&& !(request.getParameter(SERVICE_TYPE_NAME).equals(""))) {
			serviceTypeName = request.getParameter(SERVICE_TYPE_NAME);
			mapForDS.put("serviceTypeName", serviceTypeName);
		}
		mapForDS.put("deptId", deptId);
		mapForDS.put("currentDate", currentDate);
		map = fwcHandlerService.searchWaitingPatientList(mapForDS);

		jsp = FWC_WAITING_LIST_JSP;
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		// return null;
	}

	@SuppressWarnings( { "unused", "unchecked" })
	public ModelAndView showFWCMainJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		MultipartFormDataRequest mrequest = null;
		int visitId = 0;
		/*if (request.getParameter("token") != null) {
			int token = Integer.parseInt(request.getParameter("token"));
			session.setAttribute("token", token);
		}*/
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
		//map = fwcHandlerService.getPatientDetails(visitId);
		int deptId = (Integer) session.getAttribute("deptId");
		Map<String, Object> mapForDS = new HashMap<String, Object>();

		map = fwcHandlerService.getPatientDetails(visitId);
		List patientDataList = (List) map.get("patientDataList");
		Visit visit = (Visit) patientDataList.get(0);
		int visitNo = visit.getVisitNo();
		int hinId = visit.getHin().getId();
		mapForDS.put("deptId", deptId);
		mapForDS.put("visitNo", visitNo);
		mapForDS.put("hinId", hinId);
		mapForDS.put("visitId", visitId);
		//map = fwcHandlerService.getFWCDetails(mapForDS);
		Map<String, Object> mapForToken = new HashMap<String, Object>();
		
		mapForToken.put("visitId", visitId);
		mapForToken.put("empId", empId);
		//mapForToken = fwcHandlerService.updateVistToken(mapForToken);
		map.put("patientDataList", patientDataList);
		jsp = FWC_MAIN_JSP;
		jsp += ".jsp";
		title = "Patient Details";
		map.put("visitId", visitId);
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public FWCHandlerService getFwcHandlerService() {
		return fwcHandlerService;
	}
	public void setFwcHandlerService(FWCHandlerService fwcHandlerService) {
		this.fwcHandlerService = fwcHandlerService;
	}
	
	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}
	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
	

//-------Methods start By Kiran
	

	//----Show Antenatal Card
	
	public ModelAndView showAntCardJsp(HttpServletRequest request,HttpServletResponse response) {
		MultipartFormDataRequest mrequest = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		 int visitId = 0;
		 if(request.getParameter("visitId") != null){
			 visitId = Integer.parseInt(request.getParameter("visitId"));
			 dataMap.put("visitId", visitId);
		 }
		 int deptId = (Integer) session.getAttribute("deptId");
		 dataMap.put("deptId", deptId);
		map = fwcHandlerService.showAntCardJsp(dataMap);
		
		jsp = "antenatalCard";
		jsp += ".jsp";
		
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
	
	public ModelAndView showAntentatalCardJsp(HttpServletRequest request,HttpServletResponse response) {
		MultipartFormDataRequest mrequest = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		 int visitId = 0;
		 if(request.getParameter("visitId") != null){
			 visitId = Integer.parseInt(request.getParameter("visitId"));
			 dataMap.put("visitId", visitId);
		 }
		 int hinId = 0;
		 if(request.getParameter("hinId") != null){
			 hinId = Integer.parseInt(request.getParameter("hinId"));
			 dataMap.put("hinId", hinId);
		 }
		 int deptId = (Integer) session.getAttribute("deptId");
		 dataMap.put("deptId", deptId);
		map = fwcHandlerService.showAntentatalCardJsp(dataMap);
		
		jsp = "antenatalCardJsp";
	
		
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		//map.put("contentJsp", jsp);
		//;map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}
	
	public ModelAndView showAntCardFollowUpJsp(HttpServletRequest request,HttpServletResponse response) {
		MultipartFormDataRequest mrequest = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		 int visitId = 0;
		 if(request.getParameter("visitId") != null){
			 visitId = Integer.parseInt(request.getParameter("visitId"));
			 dataMap.put("visitId", visitId);
		 }
		 int hinId = 0;
		 if(request.getParameter("hinId") != null){
			 hinId = Integer.parseInt(request.getParameter("hinId"));
			 dataMap.put("hinId", hinId);
		 }
		 int deptId = (Integer) session.getAttribute("deptId");
		 dataMap.put("deptId", deptId);
		map = fwcHandlerService.showAntCardJsp(dataMap);
		
		jsp = "antenatalCardFollowUp";
		jsp += ".jsp";
		
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}
	
	public ModelAndView submitAntenatalCard(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId  = 0;
		int userId = 0;
		int deptId = 0;
		boolean submitData = false;
		String flag = "";
		if (!request.getParameter("flag").equals("")) {
			flag = request.getParameter("flag");
		}
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			box.put("deptId", deptId);
		} else {
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
		}
		Users user = new Users();
		if(session.getAttribute("users")!=null){
			user = (Users)session.getAttribute("users");
			box.put("userId", user.getId());
			box.put("empId", user.getEmployee().getId());
		}
		String userName = "";
		if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
		box.put("userName", userName);
		}
		String orderSeqNo = opdHandlerService.generateOrderNumber(hospitalId);
		box.put("orderSeqNo", orderSeqNo);
		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		List<String> pvmsNoList = new ArrayList<String>();
		List<Integer> frequencyList = new ArrayList<Integer>();
		List<String> dosageList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();
		List<Integer> totalList = new ArrayList<Integer>();
		List<Integer> noOfDaysList = new ArrayList<Integer>();
		List<String> routeList = new ArrayList<String>();
		String[] pvmsArr = new String[hdb];
		String otherMedicine = "";
		List<String> otherMedicineList = new ArrayList<String>();
		List<String> ctList = new ArrayList<String>();
		
		//----------------code for investigation-----------------------//
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
						if(request.getParameter("referToMh" + i) != null && !request.getParameter("referToMh" + i).equals("")){
							String referToMh = request.getParameter("referToMh" + i);
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
		//------------------end of the code investegation-------------------//
		
		int j = 1;
		for (int i = 0; i < hdb; i++) {
			String pvmsNo = "";
			if (request.getParameter("nomenclature" + j) != null && !request.getParameter("nomenclature" + j).equals("")) {

				String nomenclature = request.getParameter("nomenclature" + j);
				int index1 = nomenclature.lastIndexOf("[");
				int index2 = nomenclature.lastIndexOf("]");
				index1++;
				pvmsNo = nomenclature.substring(index1, index2);
				if (!pvmsNo.equals("")) {
					pvmsArr[i] = pvmsNo;
				}
			}else{
				if(request.getParameter("otherMedicine"+ j) != null && !request.getParameter("otherMedicine"+ j).equals("")){
					otherMedicine = request.getParameter("otherMedicine"+ j);
					otherMedicineList.add(otherMedicine);
				}
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
			
			int frequenceValue = 0;
			if(request.getParameter("frequencyValue" + j) != null && !request.getParameter("frequencyValue" + j).equals("")){
				frequenceValue =Integer.parseInt(request.getParameter("frequencyValue" + j));
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
		
			if(!pvmsNo.equals("")){
				pvmsNoList.add(pvmsNo);
			}

			j++;
		}
		mapForDS.put("chargeCodeIdList", chargeCodeIdList);
		mapForDS.put("referToMhList", referToMhList);
		mapForDS.put("pvmsNoList", pvmsNoList);
		mapForDS.put("frequencyList", frequencyList);
		mapForDS.put("ctList", ctList);
		mapForDS.put("dosageList", dosageList);
		mapForDS.put("remarksList", remarksList);
		mapForDS.put("routeList", routeList);
		mapForDS.put("otherMedicineList", otherMedicineList);
		mapForDS.put("totalList", totalList);
		mapForDS.put("noOfDaysList", noOfDaysList);
		mapForDS.put("box", box);
		mapForDS.put("userId", userId);
		mapForDS.put("userName", userName);
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("deptId", deptId);
		mapForDS.put("empId", user.getEmployee().getId());
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean bool = false;
		returnMap = fwcHandlerService.submitAntenatalCard(box,mapForDS);
		if (returnMap.get("succesfullyAdded") != null) {
			bool = (Boolean) returnMap.get("succesfullyAdded");
		}
		if (returnMap.get("orderSeqNo") != null) {
			orderSeqNo = (String) returnMap.get("orderSeqNo");
		}

		String message = null;
		
		if (bool) {
			if (flag.equals("fwc")) {
				
				map = fwcHandlerService.getWaitingPatientList(mapForDS);
				message = "Patient Details Submitted.";
				jsp = "fwc_messgae";
				submitData = true;
			}
		} else {
			map = fwcHandlerService.getWaitingPatientList(mapForDS);
			message = "Error Occurred in Submitting Details.";
			jsp = FWC_WAITING_LIST_JSP;
		}
		jsp += ".jsp";
		if(request.getParameter("unitId")!=null && !(request.getParameter("unitId").equals(""))){
			map.put("unitId", Integer.parseInt(request.getParameter("unitId")));
		}
		map.put("message", message);
		map.put("submitData", submitData);
		map.put("deptId", deptId);
		map.put("visitNoForReport", box.getInt(VISIT_NUMBER));
		map.put("orderNoForReport", orderSeqNo);
		map.put("serviceNoForReport", box.getString(SERVICE_NO));
		map.put("visitId", box.getInt("visitId"));
		map.put("hinNoForReport", box.getString(HIN_NO));
		map.put("flag", flag);
		title = "Patient Details";
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView submitAntenatalCardFollowUp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId  = 0;
		int userId = 0;
		int deptId = 0;
		boolean submitData = false;
		String flag = "";
		if (!request.getParameter("flag").equals("")) {
			flag = request.getParameter("flag");
		}
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			box.put("deptId", deptId);
		} else {
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
		}
		Users user = new Users();
		if(session.getAttribute("users")!=null){
			user = (Users)session.getAttribute("users");
			box.put("userId", user.getId());
			box.put("empId", user.getEmployee().getId());
		}
		String userName = "";
		if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
		box.put("userName", userName);
		}
		String orderSeqNo = opdHandlerService.generateOrderNumber(hospitalId);
		box.put("orderSeqNo", orderSeqNo);
	
		

		String dateAnc = "";
		String dateNextVisit = "";

			String fundal = "";
				if(request.getParameter("fundal") != null && !request.getParameter("fundal").equals("")){
					fundal = request.getParameter("fundal");
			
				}
				int pog = 0;
				if(request.getParameter("pog" ) != null && !request.getParameter("pog" ).equals("")){
					pog =Integer.parseInt(request.getParameter("pog"));
				
				}
				String weight = "";
			if(request.getParameter("weight") != null && !request.getParameter("weight").equals("")){
				weight =request.getParameter("weight");
			
			}	
			String bp = "";
			if(request.getParameter("bp") != null && !request.getParameter("bp").equals("")){
				bp = request.getParameter("bp");
				
			}
			
			if (request.getParameter("dateAnc") != null
					&& !request.getParameter("dateAnc").equals("")) {
				dateAnc = request.getParameter("dateAnc");
			}
			if (request.getParameter("dateNextVisit") != null
					&& !request.getParameter("dateNextVisit").equals("")) {
				dateNextVisit = request.getParameter("dateNextVisit");
			}
			
			String pp = "";
			if(request.getParameter("pp") != null && !request.getParameter("pp").equals("")){
				pp = request.getParameter("pp");
				
			}
			
			String foetalHeart = "";
			if(request.getParameter("foetalHeart") != null && !request.getParameter("foetalHeart").equals("")){
				foetalHeart = request.getParameter("foetalHeart");
			
			}
			
			String foetalHeadEngaged = "";
			if(request.getParameter("foetalHeadEngaged") != null && !request.getParameter("foetalHeadEngaged").equals("")){
				foetalHeadEngaged = request.getParameter("foetalHeadEngaged");
			
			}
			
			
			String oedema = "";
			if(request.getParameter("oedema") != null && !request.getParameter("oedema").equals("")){
				oedema = request.getParameter("oedema");
			
			}
			
			
			String alb = "";
			if(request.getParameter("alb") != null && !request.getParameter("alb").equals("")){
				alb = request.getParameter("alb");
		
			}
			
			
			String sugar = "";
			if(request.getParameter("sugar") != null && !request.getParameter("sugar").equals("")){
				sugar = request.getParameter("sugar");
			
			}
			
			String hb = "";
			if(request.getParameter("hb") != null && !request.getParameter("hb").equals("")){
				hb = request.getParameter("hb");
		
			}
			
			String complaint = "";
			if(request.getParameter("complaint") != null && !request.getParameter("complaint").equals("")){
				complaint = request.getParameter("complaint");
				
			}
			
			String remarks = "";
			if(request.getParameter("remarks") != null && !request.getParameter("remarks").equals("")){
				remarks = request.getParameter("remarks");
				
			}
			String pollor = "";
			if(request.getParameter("pollor") != null && !request.getParameter("pollor").equals("")){
				pollor = request.getParameter("pollor");
			
			}
		
		

		
		infoMap.put("box", box);
		
		infoMap.put("pog",pog);
		infoMap.put("pollor",pollor);
		infoMap.put("remarks",remarks);
		infoMap.put("complaint",complaint);
		infoMap.put("hb",hb);
		infoMap.put("sugar",sugar);
		infoMap.put("alb",alb);
		infoMap.put("oedema",oedema);
		infoMap.put("foetalHeadEngaged",foetalHeadEngaged);
		infoMap.put("foetalHeart",foetalHeart);
		infoMap.put("pp",pp);
		infoMap.put("dateNextVisit",dateNextVisit);
		infoMap.put("dateAnc",dateAnc);
		infoMap.put("dateOfLastME",dateAnc);
		infoMap.put("bp",bp);
		infoMap.put("weight",weight);
		infoMap.put("fundal",fundal);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean bool = false;
		returnMap = fwcHandlerService.submitAntenatalCardFollowUp(box,infoMap);
		
		if (returnMap.get("succesfullyAdded") != null) {
			bool = (Boolean) returnMap.get("succesfullyAdded");
		}
		if (returnMap.get("orderSeqNo") != null) {
			orderSeqNo = (String) returnMap.get("orderSeqNo");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		 int visitId = 0;
		 if(request.getParameter("visitId") != null){
			 visitId = Integer.parseInt(request.getParameter("visitId"));
			 dataMap.put("visitId", visitId);
		 }
		
		 dataMap.put("deptId", deptId);
		map = fwcHandlerService.showAntCardJsp(dataMap);
		String message = null;
		message = "Patient Details Submitted.";
		jsp = "antenatalCardFollowUp";
		submitData = true;
		jsp += ".jsp";
		map.put("url",url);
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
		}
	
	public ModelAndView showAntentalCardReportJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int visitNo = 0;
		String serviceNo = "";
		String hinNo = "";
		int visitId = 0;
		if (request.getParameter(SERVICE_NO_FOR_REPORT) != null) {
			serviceNo = request.getParameter(SERVICE_NO_FOR_REPORT);
		}
		if (request.getParameter(VISIT_NUMBER_FOR_REPORT) != null) {
			visitNo = Integer.parseInt(request
					.getParameter(VISIT_NUMBER_FOR_REPORT));
		}
		if (request.getParameter(HIN_NO_FOR_REPORT) != null) {
			hinNo = request.getParameter(HIN_NO_FOR_REPORT);
		}
		if(request.getParameter(VISIT_ID)!= null){
			visitId = Integer.parseInt(request.getParameter(VISIT_ID));
		}
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = opdHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("hospitalId", hospitalId);
		parameters.put("visitId", visitId);
		parameters.put("visitNo", visitNo);
		parameters.put("serviceNo", serviceNo);
		parameters.put("hinNo", hinNo);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		
		
		HMSUtil.generateReport("Fwc_ANC", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		
		return null;
	}

	public ModelAndView showFwcUploadViewDocumentJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Map<String, Object> dataMap = new HashMap<String, Object>();
			//int deptId = (Integer) session.getAttribute("deptId");
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			int visitId = 0;
			int hinId = 0;
			if(request.getParameter("visitId")!=null){
				visitId =Integer.parseInt(request.getParameter("visitId"));
			}
			if(request.getParameter("hinId")!=null){
				hinId =Integer.parseInt(request.getParameter("hinId"));
			}
			String flag="";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag").trim();
			}
			dataMap.put("visitId", visitId);
			dataMap.put("flag", flag);
			dataMap.put("hinId", hinId);
			map = fwcHandlerService.showFwcUploadViewDocumentJsp(dataMap);
			map.put("hinId", hinId);
			map.put("visitId", visitId);
			map.put("hospitalId", hospitalId);
			//map.put("deptId", deptId);
			map.put("flag", flag);
			jsp = "fwc_uploadDocument";
			map.put("contentJsp", jsp);
			return new ModelAndView(jsp, "map", map);
		}
	public ModelAndView submitFwcUploadDocuments(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		MultipartFormDataRequest mrequest = null;
		String fileName = null;
		String message = null;
		String hin_no = "";
		String fileExtension = null;
		int hospitalId;
		int visitId = 0;
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
		HttpSession session = request.getSession();
		if (mrequest.getParameter("hin_no") != null) {
			hin_no = (String) mrequest.getParameter("hin_no");
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		if (request.getParameter("visitId") != null
				&& !request.getParameter("visitId").equals("0")) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		String fwcFlag = "";
		if(request.getParameter("fwcFlag") != null){
			fwcFlag = request.getParameter("fwcFlag");
		}
		Map<String, Object> uploadFileMap = new HashMap<String, Object>();
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome.substring(0, userHome
				.lastIndexOf(fileSeparator))
				+ fileSeparator
				+ "HMSDocumentFolder"
				+ fileSeparator
				+ "upload" + fileSeparator;
		HMSUtil.createFolderFroDocument(hin_no, uploadURL);
		List fileUploadedList = null;
		int uploadCount = box.getInt("uploadCount");
		int i = 1;
		for (i = 1; i <= uploadCount; i++) {
			if (!request.getParameter("filename" + i).equals("")) {
				StringTokenizer strToken = new StringTokenizer(request
						.getParameter("filename" + i), ".");

				fileName = strToken.nextToken();
				fileExtension = strToken.nextToken();

				String whiteList = "*." + fileExtension;

				fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL
						+ hin_no + fileSeparator, whiteList, request
						.getParameter("filename" + i), i);
				box.put("filename" + i, request.getParameter("filename" + i));
				box.put("description" + i, mrequest.getParameter("description"
						+ i));
				box.put("fileExtension" + i, fileExtension);
			} else {
				box.put("filename" + i, "0");
			}
		}
		if (mrequest.getParameter("hinId") != null)
			box.put("hinId", mrequest.getParameter("hinId"));
		else
			box.put("hinId", 0);
		
		box.put("patientName", mrequest.getParameter("patientName"));
		box.put("sex", mrequest.getParameter("sex"));
		box.put("age", mrequest.getParameter("age"));
		if (mrequest.getParameter("address") != null)
			box.put("address", mrequest.getParameter("address"));
		Boolean fileUploaded = false;
		if (fileUploadedList != null && fileUploadedList.size() != 0) {
			fileUploaded = (Boolean) fileUploadedList.get(0);
		}
		box.put("uploadURL", uploadURL);
		box.put("hin_no", hin_no);
		box.put("fwcFlag", fwcFlag);
		box.put("fileSeparator", fileSeparator);
		map = fwcHandlerService.submitFwcUploadDocuments(box);
		if (map.get("dataSaved").equals(true)) {
			message = "File Uploaded Sucessfully!!";
		} else {
			message = "Data Cannot be Saved !!";
		}
		map.put("message", message);
		map.put("visitId", visitId);
		jsp = "submitFwcUploadDocument";
		jsp += ".jsp";
		title = "Upload Documents";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("fwcFlag", fwcFlag);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView viewFwcDocument(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		String userName = "";
		String jsp = "";
		String inputField = "";
		String flag = "";
		String flag1 = "";
		String hin_no = "";
		int visitId = 0;
		MultipartFormDataRequest mrequest = null;
		Box box = HMSUtil.getBox(request);
		String fwcFlag = "";
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {

				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (mrequest.getParameter("inputField") != null
					&& !(mrequest.getParameter("inputField").equals(""))) {
				inputField = mrequest.getParameter("inputField");
			}
			if (mrequest.getParameter("hin_no") != null) {
				hin_no = mrequest.getParameter("hin_no");
			}
			if (mrequest.getParameter("flag") != null
					&& !(mrequest.getParameter("flag").equals(""))) {
				flag = mrequest.getParameter("flag");
			}
			if (mrequest.getParameter("flag1") != null
					&& !(mrequest.getParameter("flag1").equals(""))) {
				flag1 = mrequest.getParameter("flag1");
				if (mrequest.getParameter("hinNo") != null)
					inputField = mrequest.getParameter("hinNo");
				else
					inputField = mrequest.getParameter("adNo");
			}
			if (mrequest.getParameter("visitId") != null
					&& !(mrequest.getParameter("visitId").equals(""))) {
				visitId = Integer.parseInt(mrequest.getParameter("visitId"));
			}
			
			if(mrequest.getParameter("fwcFlag") != null){
				fwcFlag = request.getParameter("fwcFlag");
			}
		} else {

			if (request.getParameter("inputField") != null
					&& !(request.getParameter("inputField").equals(""))) {
				inputField = request.getParameter("inputField");
			}

			if (request.getParameter("flag") != null
					&& !(request.getParameter("flag").equals(""))) {
				flag = request.getParameter("flag");
			}
			if (request.getParameter("flag1") != null
					&& !(request.getParameter("flag1").equals(""))) {
				flag1 = request.getParameter("flag1");
				removeFilesInUploadFolder(request, response);
				if (request.getParameter("fieldValue") != null)
					inputField = request.getParameter("fieldValue");
				else
					inputField = request.getParameter("fieldValue");
			}
			if (request.getParameter("visitId") != null
					&& !(request.getParameter("visitId").equals(""))) {
				visitId = Integer.parseInt(request.getParameter("visitId"));
			}
			if(request.getParameter("fwcFlag") != null){
				fwcFlag = request.getParameter("fwcFlag");
			}
		}
		map.put("visitId", visitId);
		map.put("inputField", inputField);
		map.put("flag", flag);
		map.put("flag1", flag1);
		map.put("fwcFlag", fwcFlag);
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome.substring(0, userHome
				.lastIndexOf(fileSeparator))
				+ fileSeparator
				+ "HMSDocumentFolder"
				+ fileSeparator
				+ "upload" + fileSeparator;
		
		//String destuploadURL = getServletContext().getRealPath("/upload/");
	//	File urlName = new File(getServletContext().getRealPath("/upload/"));
	//	String getPathName = urlName.getPath();
	//	map.put("destUploadURL", destuploadURL + fileSeparator + hin_no);
		map.put("uploadURL", uploadURL + hin_no);
		map = fwcHandlerService.viewFwcPatientDetails(map);
		String[] files = null;
		try {
		//	File fileDir = new File(destuploadURL + fileSeparator + hin_no);
			File fileDir = new File(uploadURL + fileSeparator + hin_no);
			if (fileDir.exists()) {
				files = fileDir.list();
			}
		} catch (Exception exc) {
			exc.printStackTrace();

		}
		if (flag.equals("upload") && !flag1.equals("viewDocuments")) {
			jsp = "fwc_uploadDocument";
			jsp += ".jsp";
			title = "Cancel for Patient Appointments";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("indexB", "map", map);
		} else if (flag.equals("view")) {
			jsp = "fwcViewPatientDoc";
			jsp += ".jsp";
			title = "Cancel for Patient Appointments";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("files", files);
			return new ModelAndView("indexB", "map", map);
		} else {
			jsp = "fwcViewDocumentsPopUp";
			jsp += ".jsp";
			title = "Cancel for Patient Appointments";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("files", files);
			return new ModelAndView("indexB", "map", map);
		}

	}
	public ModelAndView removeFilesInUploadFolder(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		String filename = null;
		String fileExtension = null;
		Map<String, Object> uploadFileMap = new HashMap<String, Object>();

		String uploadURL = getServletContext().getRealPath("/upload/");

		// System.out.println("uploadURL==" + uploadURL);
		box.put("uploadURL", uploadURL);

		File f = new File(uploadURL);

		if (f.listFiles().length > 0) {
			File fd[] = f.listFiles();

			for (int i = 0; i < fd.length; i++) {
				if (fd[i].isFile())
					fd[i].delete();
			}
		}
		if (f.listFiles().length < 1) {
			if (!f.canWrite()) {
			}
		}

		jsp = "fwcViewPatientDoc";
		jsp += ".jsp";
		title = "Import CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView viewFWCPatientDocuments(HttpServletRequest request,
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
		String uploadURL = userHome.substring(0, userHome
				.lastIndexOf(fileSeparator))
				+ fileSeparator
				+ "HMSDocumentFolder"
				+ fileSeparator
				+ "upload" + fileSeparator;
		
		// String whiteList = "*.zip";
		// String whiteList = "*.jpg";

		// Long fileSizeLimit = 2097152l;

		/*
		 * List fileUploadedList = null; fileUploadedList =
		 * HMSUtil.uploadFile(mrequest,uploadURL, whiteList,
		 * box.getString("filename"));
		 * //System.out.println("fileUploadedList="+fileUploadedList.size());
		 * Boolean fileUploaded=false; if(fileUploadedList != null &&
		 * fileUploadedList.size()!=0) { fileUploaded = (Boolean)
		 * fileUploadedList.get(0); }
		 */
		box.put("uploadURL", uploadURL);
		StringTokenizer st1 = new StringTokenizer(box.getString("filename"),
				".");
		filename = st1.nextToken();
		fileExtension = st1.nextToken();

		box.put("filename", box.getString("filename"));
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
					+ java.net.URLEncoder.encode(box.getString("filename"))
					+ "");

			// System.out.println("box.getString(filename)==" + filename + "."+
			// fileExtension);
			// response.setContentType("image/"+fileExtension);
			// response.setHeader("Content-Disposition", "attachment;
			// filename="+filename+"."+fileExtension);

			File f = new File(uploadURL + "/" + filename + "." + fileExtension);
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

		jsp = "fwcViewPatientDoc";
		jsp += ".jsp";
		title = "Import CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	//-----Show Pediatrics
	
	public ModelAndView showPediatricJsp(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		MultipartFormDataRequest mrequest = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		 int visitId = 0;
		 if(request.getParameter("visitId") != null){
			 visitId = Integer.parseInt(request.getParameter("visitId"));
			 dataMap.put("visitId", visitId);
		 }
		 int deptId = (Integer) session.getAttribute("deptId");
		 dataMap.put("deptId", deptId);
		map = fwcHandlerService.showPediatricJsp(dataMap);
		jsp = "pediatrics12";
		jsp += ".jsp";
		
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public void getImmunizationId(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = fwcHandlerService.getImmunizationId(box);
		try {
			List<MasImmunization> immunizationList = new ArrayList<MasImmunization>();
			if(map.get("immunizationList")!=null){
				immunizationList = (List<MasImmunization>)map.get("immunizationList");
			}
			StringBuffer sb = new StringBuffer();
			if(immunizationList.size() > 0){
				for(MasImmunization immunization : immunizationList){
					sb.append("<item>");
					sb.append("<immunizationId>" + immunization.getId() + "</immunizationId>");
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
	public ModelAndView submitPediatricsDetail(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		List<Integer> immuDtIdList  = new ArrayList<Integer>();
		List<Integer> immuIdList  = new ArrayList<Integer>();
		List<String> immuDateList  = new ArrayList<String>();
		List<String> doseList  = new ArrayList<String>();
		List<String> routeList  = new ArrayList<String>();
		List<String> batchNoList  = new ArrayList<String>();
		List<String> dueDateList  = new ArrayList<String>();
		List<String> doeList  = new ArrayList<String>();
		List<String> immuNameList  = new ArrayList<String>();
		List<String> pvmsNoList = new ArrayList<String>();
		List<Integer> frequencyList = new ArrayList<Integer>();
		List<String> dosageList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();
		List<Integer> totalList = new ArrayList<Integer>();
		List<Integer> noOfDaysList = new ArrayList<Integer>();
		int hospitalId  = 0;
		int userId = 0;
		int deptId = 0;
		boolean submitData = false;
		String flag = "";
		if (!request.getParameter("flag").equals("")) {
			flag = request.getParameter("flag");
			mapForDS.put("flag", flag);
		}
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
			mapForDS.put("hospitalId", hospitalId);
		}
		if(session.getAttribute("deptId") != null){
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
			mapForDS.put("deptId", deptId);
		}
		Users user = new Users();
		if(session.getAttribute("users")!=null){
			user = (Users)session.getAttribute("users");
			box.put("userId", user.getId());
			box.put("empId", user.getEmployee().getId());
			mapForDS.put("userId", userId);
			mapForDS.put("empId", user.getEmployee().getId());
		}
		String userName = "";
		if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
		box.put("userName", userName);
		}
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			box.put("deptId", deptId);
		} else {
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
		}
		
		String orderSeqNo = opdHandlerService.generateOrderNumber(hospitalId);
		box.put("orderSeqNo", orderSeqNo);
		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		String[] pvmsArr = new String[hdb];
		String otherMedicine = "";
		List<String> otherMedicineList = new ArrayList<String>();
		List<String> ctList = new ArrayList<String>();
		
		
		int count = 0;
		if(request.getParameter("count")!=null)
		{
			count=Integer.parseInt(request.getParameter("count").toString());
		}
		for(int j = 1; j <= count; j++) 
		{
			
			if(request.getParameter("immunizationId"+j)!=null && !request.getParameter("immunizationId"+j).equals("")){
				immuDtIdList.add(Integer.parseInt(request.getParameter("immunizationId"+j)));
			}else{
				immuDtIdList.add(0);
			}
			if(request.getParameter("immuDate"+j)!=null){
				immuDateList.add(request.getParameter("immuDate"+j));
			}
			if(request.getParameter("dose"+j)!=null){
				doseList.add(request.getParameter("dose"+j));
			}
			if(request.getParameter("route"+j)!=null){
				routeList.add(request.getParameter("route"+j));
			}
			if(request.getParameter("dueDate"+j)!=null){
				dueDateList.add(request.getParameter("dueDate"+j));
			}
						
		}
		mapForDS.put("immuDtIdList", immuDtIdList);
		mapForDS.put("immuIdList", immuIdList);
		mapForDS.put("immuDateList", immuDateList);
		mapForDS.put("doseList", doseList);
		mapForDS.put("routeList", routeList);
		mapForDS.put("dueDateList", dueDateList);
		mapForDS.put("hospitalId",hospitalId);
		mapForDS.put("immuNameList",immuNameList);
		//----------------code for investigation-----------------------//
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
					if(request.getParameter("referToMh" + i) != null && !request.getParameter("referToMh" + i).equals("")){
						String referToMh = request.getParameter("referToMh" + i);
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
	//------------------end of the code investegation-------------------//
	
	int j = 1;
	for (int i = 0; i < hdb; i++) {
		String pvmsNo = "";
		if (request.getParameter("nomenclature" + j) != null && !request.getParameter("nomenclature" + j).equals("")) {

			String nomenclature = request.getParameter("nomenclature" + j);
			int index1 = nomenclature.lastIndexOf("[");
			int index2 = nomenclature.lastIndexOf("]");
			index1++;
			pvmsNo = nomenclature.substring(index1, index2);
			if (!pvmsNo.equals("")) {
				pvmsArr[i] = pvmsNo;
			}
		}else{
			if(request.getParameter("otherMedicine"+ j) != null && !request.getParameter("otherMedicine"+ j).equals("")){
				otherMedicine = request.getParameter("otherMedicine"+ j);
				otherMedicineList.add(otherMedicine);
			}
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
		
		int frequenceValue = 0;
		if(request.getParameter("frequencyValue" + j) != null && !request.getParameter("frequencyValue" + j).equals("")){
			frequenceValue =Integer.parseInt(request.getParameter("frequencyValue" + j));
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
	
		if(!pvmsNo.equals("")){
			pvmsNoList.add(pvmsNo);
		}

		j++;
	}
	mapForDS.put("chargeCodeIdList", chargeCodeIdList);
	mapForDS.put("referToMhList", referToMhList);
	mapForDS.put("pvmsNoList", pvmsNoList);
	mapForDS.put("frequencyList", frequencyList);
	mapForDS.put("ctList", ctList);
	mapForDS.put("dosageList", dosageList);
	mapForDS.put("remarksList", remarksList);
	mapForDS.put("routeList", routeList);
	mapForDS.put("otherMedicineList", otherMedicineList);
	mapForDS.put("totalList", totalList);
	mapForDS.put("noOfDaysList", noOfDaysList);
	mapForDS.put("box", box);
	mapForDS.put("userId", userId);
	mapForDS.put("userName", userName);
	mapForDS.put("hospitalId", hospitalId);
	mapForDS.put("deptId", deptId);
	mapForDS.put("empId", user.getEmployee().getId());
		boolean bool = false;
		map = fwcHandlerService.submitPediatricsDetail(box,mapForDS);
		String message = null;
		if (map.get("succesfullyAdded") != null) {
			bool = (Boolean) map.get("succesfullyAdded");
		}
		if (bool) {
			//if (flag.equals("fwc")) {
				
				//map = fwcHandlerService.getWaitingPatientList(mapForDS);
				message = "Patient Details Submitted.";
				map.put("message", message);
			//}
		} else {
			//map = fwcHandlerService.getWaitingPatientList(mapForDS);
			message = "Error Occurred in Submitting Details.";
			map.put("message", message);
		}
		jsp = "fwcMessage";
		jsp += ".jsp";
		title = "Patient Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("chieldGender", box.getString("chieldGender"));
		map.put("hinId", box.getInt("hinId"));
		map.put("visitId", box.getInt("visitId"));
		map.put("deptId", box.getInt("deptId"));
		return new ModelAndView("indexB", "map", map);
	} 
	public ModelAndView printpediatricCard(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int visitId = 0;
		if (request.getParameter("visitId") != null) {
			visitId =Integer.parseInt(request.getParameter("visitId"));
		}
		int hinId = 0;
		if (request.getParameter("hinId") != null) {
			hinId =Integer.parseInt(request.getParameter("hinId"));
		}
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = opdHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("hospitalId", hospitalId);
		parameters.put("visitId", visitId);
		parameters.put("hinId", hinId);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		HMSUtil.generateReport("Fwc_WellBaby", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	
		return null;
	}
	public ModelAndView printHealthCard(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int visitId = 0;
		if(request.getParameter("visitId") != null){
			visitId = Integer.parseInt(request.getParameter("visitId"));
		   requestParameters.put("visitId", visitId);
		}
		int hinId = 0;
		if(request.getParameter("hinId") != null){
			hinId = Integer.parseInt(request.getParameter("hinId"));
		   requestParameters.put("hinId", hinId);
		}
		parameters = fwcHandlerService.printHealthCard(requestParameters);
		parameters.put("hinId", hinId);
		HMSUtil.generateReport("pediatric_chart", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());

	return null;
}
	
	
	public ModelAndView printHealthCardHeight(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int visitId = 0;
		if(request.getParameter("visitId") != null){
			visitId = Integer.parseInt(request.getParameter("visitId"));
		   requestParameters.put("visitId", visitId);
		}
		int hinId = 0;
		if(request.getParameter("hinId") != null){
			hinId = Integer.parseInt(request.getParameter("hinId"));
		   requestParameters.put("hinId", hinId);
		}
		parameters = fwcHandlerService.printHealthCardHeight(requestParameters);
		parameters.put("hinId", hinId);
		HMSUtil.generateReport("pediatric_chart", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());

	return null;
}
	
	public ModelAndView printHealthCardHeadCircumference(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int visitId = 0;
		if(request.getParameter("visitId") != null){
			visitId = Integer.parseInt(request.getParameter("visitId"));
		   requestParameters.put("visitId", visitId);
		}
		int hinId = 0;
		if(request.getParameter("hinId") != null){
			hinId = Integer.parseInt(request.getParameter("hinId"));
		   requestParameters.put("hinId", hinId);
		}
		parameters = fwcHandlerService.printHealthCardHeadCircumference(requestParameters);
		parameters.put("hinId", hinId);
		HMSUtil.generateReport("pediatric_chart", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());

	return null;
}
	public ModelAndView printHealthCardB(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int visitId = 0;
		if(request.getParameter("visitId") != null){
			visitId = Integer.parseInt(request.getParameter("visitId"));
		   requestParameters.put("visitId", visitId);
		}
		int hinId = 0;
		if(request.getParameter("hinId") != null){
			hinId = Integer.parseInt(request.getParameter("hinId"));
		   requestParameters.put("hinId", hinId);
		}
		parameters = fwcHandlerService.printHealthCardB(requestParameters);
		parameters.put("hinId", hinId);
		HMSUtil.generateReport("pediatric_chart", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());

	return null;
}
	
	
	public ModelAndView printHealthCardHeightB(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int visitId = 0;
		if(request.getParameter("visitId") != null){
			visitId = Integer.parseInt(request.getParameter("visitId"));
		   requestParameters.put("visitId", visitId);
		}
		int hinId = 0;
		if(request.getParameter("hinId") != null){
			hinId = Integer.parseInt(request.getParameter("hinId"));
		   requestParameters.put("hinId", hinId);
		}
		parameters = fwcHandlerService.printHealthCardHeightB(requestParameters);
		parameters.put("hinId", hinId);
		HMSUtil.generateReport("pediatric_chart", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());

	return null;
}
	
	public ModelAndView printHealthCardHeadCircumferenceB(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int visitId = 0;
		if(request.getParameter("visitId") != null){
			visitId = Integer.parseInt(request.getParameter("visitId"));
		   requestParameters.put("visitId", visitId);
		}
		int hinId = 0;
		if(request.getParameter("hinId") != null){
			hinId = Integer.parseInt(request.getParameter("hinId"));
		   requestParameters.put("hinId", hinId);
		}
		parameters = fwcHandlerService.printHealthCardHeadCircumferenceB(requestParameters);
		parameters.put("hinId", hinId);
		HMSUtil.generateReport("pediatric_chart", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());

	return null;
}
	//-----Show PNC
	
	public ModelAndView showPNCJsp(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		 int visitId = 0;
		 MultipartFormDataRequest mrequest = null;
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		int empId = (Integer) session.getAttribute("userId");
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
				visitId = Integer.parseInt(request.getParameter("visitId"));
				dataMap.put("visitId", visitId);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		
		 if(request.getParameter("visitId") != null){
			 visitId = Integer.parseInt(request.getParameter("visitId"));
			 dataMap.put("visitId", visitId);
		 }
			int token = 0;
			if (request.getParameter("token") != null) {
				 token = Integer.parseInt(request.getParameter("token"));
				 session.setAttribute("token", token);
			}
		map=fwcHandlerService.getPNCDataList(dataMap);
		
		int deptId = (Integer) session.getAttribute("deptId");
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		List<OpdPatientDetails> opdDetailListForFollowUp = new ArrayList<OpdPatientDetails>();
		List<OpdPatientHistory> opdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
		List<PatientInvestigationHeader>patientInvestigationHeaderListForFollowUp = new ArrayList<PatientInvestigationHeader>();
		List<PatientPrescriptionHeader> patientPrescriptionHeaderList = new ArrayList<PatientPrescriptionHeader>();
		List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
		if(map.get("opdDetailListForFollowUp")!= null){
			opdDetailListForFollowUp = (List<OpdPatientDetails>)map.get("opdDetailListForFollowUp");
		}
		if(map.get("opdHistoryDetailsListForFollowUp")!= null){
			opdHistoryDetailsListForFollowUp = (List<OpdPatientHistory>)map.get("opdHistoryDetailsListForFollowUp");
		}
		if(map.get("patientInvestigationHeaderListForFollowUp")!= null){
			patientInvestigationHeaderListForFollowUp = (List<PatientInvestigationHeader>)map.get("patientInvestigationHeaderListForFollowUp");
		}
		if(map.get("patientPrescriptionHeaderList")!= null){
			patientPrescriptionHeaderList = (List<PatientPrescriptionHeader>)map.get("patientPrescriptionHeaderList");
		}
		if(map.get("dischargeIcdCodeList")!= null){
			dischargeIcdCodeList = (List<DischargeIcdCode>)map.get("dischargeIcdCodeList");
		}
		//map = opdHandlerService.getPatientDetails(visitId);
		List pncDataList = (List) map.get("pncDataList");
		Visit visit = (Visit) pncDataList.get(0);
		int visitNo = visit.getVisitNo();
		int hinId = visit.getHin().getId();
		mapForDS.put("deptId", deptId);
		mapForDS.put("visitNo", visitNo);
		mapForDS.put("hinId", hinId);
		mapForDS.put("visitId", visitId);
		map = opdHandlerService.getOPDDetails(mapForDS);
		Map<String, Object> mapForToken = new HashMap<String, Object>();
		mapForToken.put("token", token);
		mapForToken.put("visitId", visitId);
		mapForToken.put("empId", empId);
		mapForToken.put("hospitalId", hospitalId);
		mapForToken = opdHandlerService.updateVistToken(mapForToken);
		map.put("pncDataList", pncDataList);
		map.put("opdDetailListForFollowUp", opdDetailListForFollowUp);
		map.put("opdHistoryDetailsListForFollowUp", opdHistoryDetailsListForFollowUp);
		map.put("patientInvestigationHeaderListForFollowUp", patientInvestigationHeaderListForFollowUp);
		map.put("patientPrescriptionHeaderList", patientPrescriptionHeaderList);
		map.put("dischargeIcdCodeList", dischargeIcdCodeList);
		
		jsp = "pnc";
		jsp += ".jsp";
		
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView submitPncDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> mapForDSPro = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int departmentId = 0;
		if(session.getAttribute("departmentId") != null){
			departmentId = (Integer) session.getAttribute("departmentId");
		}
		int visitId = Integer.parseInt(request.getParameter("visitId"));
		// details captured for opd patient details table
		int empId = 0;
		if (request.getParameter("empId") != null
				&& request.getParameter("empId") != "") {
			empId = Integer.parseInt(request.getParameter("empId"));
		}
		int empIdCurrnet = 0;
		empIdCurrnet = (Integer) session.getAttribute("userId");
		String days = null;
		String disposal = "";
		String nextVisitDate = null;
		String afmsDescription = null;
		String userName = null;
		String flag = null;
		boolean submitData = false;
		String adviceOnDischarge = "";
		String pastDiagnosis = "";
		String pastdisposal = "";
		String DaysPhy = "";
		String DurationPhy = "";
		int threpytypeId = 0;
		String whr="";
		String allergies = "";
		String reviewAt = "";
		String dentalRemarks = "";
		String denatlToMH="";
		int totalTeeth = 0;
		int totalDefectiveTeeth = 0;
		int missingTeeth = 0;
		int DenstalPoint = 0;
		int unserviceableTeeth = 0;
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

		if (!request.getParameter("flag").equals("")) {
			flag = request.getParameter("flag");
		}
		//-----For dental added by dipali
		if (request.getParameter(TOTAL_NO_OF_TEETH) != null
				&& !(request.getParameter(TOTAL_NO_OF_TEETH).equals(""))) {
			totalTeeth =Integer.parseInt(request.getParameter(TOTAL_NO_OF_TEETH));

		}
		if (request.getParameter(DEFECTIVE_TEETH) != null
				&& !(request.getParameter(DEFECTIVE_TEETH).equals(""))) {
			totalDefectiveTeeth =Integer.parseInt(request.getParameter(DEFECTIVE_TEETH));

		}
		if (request.getParameter(MISSING_TEETH) != null
				&& !(request.getParameter(MISSING_TEETH).equals(""))) {
			missingTeeth =Integer.parseInt(request.getParameter(MISSING_TEETH));

		}
		if (request.getParameter(MISSING_UNSERVICABLE_TEETH) != null
				&& !(request.getParameter(MISSING_UNSERVICABLE_TEETH).equals(""))) {
			unserviceableTeeth =Integer.parseInt(request.getParameter(MISSING_UNSERVICABLE_TEETH));

		}
		if (request.getParameter(DENTSL_POINT) != null
				&& !(request.getParameter(DENTSL_POINT).equals(""))) {
			DenstalPoint =Integer.parseInt(request.getParameter(DENTSL_POINT));

		}
		
		// //////////////////////////////////

		if (request.getParameter(DUR_8) != null) {
			dur8 = (request.getParameter(DUR_8));

		} else {
			dur8 = "N";

		}

		if (request.getParameter(DUR_7) != null) {
			dur7 = (request.getParameter(DUR_7));

		} else {
			dur7 = "N";

		}
		if (request.getParameter(DUR_6) != null) {
			dur6 = (request.getParameter(DUR_6));

		} else {
			dur6 = "N";

		}
		if (request.getParameter(DUR_5) != null) {
			dur5 = (request.getParameter(DUR_5));

		} else {
			dur5 = "N";

		}

		if (request.getParameter(DUR_4) != null) {
			dur4 = (request.getParameter(DUR_4));
		} else {
			dur4 = "N";

		}
		if (request.getParameter(DUR_3) != null) {
			dur3 = (request.getParameter(DUR_3));

		} else {
			dur3 = "N";

		}
		if (request.getParameter(DUR_2) != null) {
			dur2 = (request.getParameter(DUR_2));

		} else {
			dur2 = "N";

		}
		if (request.getParameter(DUR_1) != null) {
			dur1 = (request.getParameter(DUR_1));

		} else {
			dur1 = "N";

		}

		if (request.getParameter(DUL_8) != null) {
			dul8 = (request.getParameter(DUL_8));
		} else {
			dul8 = "N";

		}
		if (request.getParameter(DUL_7) != null) {
			dul7 = (request.getParameter(DUL_7));

		} else {
			dul7 = "N";

		}
		if (request.getParameter(DUL_6) != null) {
			dul6 = (request.getParameter(DUL_6));
		} else {
			dul6 = "N";

		}
		if (request.getParameter(DUL_5) != null) {
			dul5 = (request.getParameter(DUL_5));
		} else {
			dul5 = "N";

		}
		if (request.getParameter(DUL_4) != null) {
			dul4 = (request.getParameter(DUL_4));
		} else {
			dul4 = "N";

		}
		if (request.getParameter(DUL_3) != null) {
			dul3 = (request.getParameter(DUL_3));
		} else {
			dul3 = "N";

		}
		if (request.getParameter(DUL_2) != null) {
			dul2 = (request.getParameter(DUL_2));
		} else {
			dul2 = "N";

		}
		if (request.getParameter(DUL_1) != null) {
			dul1 = (request.getParameter(DUL_1));
		} else {
			dul1 = "N";

		}

		if (request.getParameter(DLR_8) != null) {
			dlr8 = (request.getParameter(DLR_8));
		} else {
			dlr8 = "N";

		}
		if (request.getParameter(DLR_7) != null) {
			dlr7 = (request.getParameter(DLR_7));
		} else {
			dlr7 = "N";

		}
		if (request.getParameter(DLR_6) != null) {
			dlr6 = (request.getParameter(DLR_6));
		} else {
			dlr6 = "N";

		}
		if (request.getParameter(DLR_5) != null) {
			dlr5 = (request.getParameter(DLR_5));
		} else {
			dlr5 = "N";

		}
		if (request.getParameter(DLR_4) != null) {
			dlr4 = (request.getParameter(DLR_4));
		} else {
			dlr4 = "N";

		}
		if (request.getParameter(DLR_3) != null) {
			dlr3 = (request.getParameter(DLR_3));
		} else {
			dlr3 = "N";

		}
		if (request.getParameter(DLR_2) != null) {
			dlr2 = (request.getParameter(DLR_2));
		} else {
			dlr2 = "N";

		}

		if (request.getParameter(DLR_1) != null) {
			dlr1 = (request.getParameter(DLR_1));
		} else {
			dlr1 = "N";

		}

		if (request.getParameter(DLL_8) != null) {
			dll8 = (request.getParameter(DLL_8));
		} else {
			dll8 = "N";

		}
		if (request.getParameter(DLL_7) != null) {
			dll7 = (request.getParameter(DLL_7));
		} else {
			dll7 = "N";

		}

		if (request.getParameter(DLL_6) != null) {
			dll6 = (request.getParameter(DLL_6));
		} else {
			dll6 = "N";

		}
		if (request.getParameter(DLL_5) != null) {
			dll5 = (request.getParameter(DLL_5));
		} else {
			dll5 = "N";

		}
		if (request.getParameter(DLL_4) != null) {
			dll4 = (request.getParameter(DLL_4));
		} else {
			dll4 = "N";

		}
		if (request.getParameter(DLL_3) != null) {
			dll3 = (request.getParameter(DLL_3));
		} else {
			dll3 = "N";

		}
		if (request.getParameter(DLL_2) != null) {
			dll2 = (request.getParameter(DLL_2));
		} else {
			dll2 = "N";

		}
		if (request.getParameter(DLL_1) != null) {
			dll1 = (request.getParameter(DLL_1));
		} else {
			dll1 = "N";

		}
		// ///////////////////////////

		if (request.getParameter(UUR_8) != null) {
			uur8 = (request.getParameter(UUR_8));
		} else {
			uur8 = "N";

		}

		if (request.getParameter(UUR_7) != null) {
			uur7 = (request.getParameter(UUR_7));
		} else {
			uur7 = "N";

		}
		if (request.getParameter(UUR_6) != null) {
			uur6 = (request.getParameter(UUR_6));
		} else {
			uur6 = "N";

		}
		if (request.getParameter(UUR_5) != null) {
			uur5 = (request.getParameter(UUR_5));
		} else {
			uur5 = "N";

		}
		if (request.getParameter(UUR_4) != null) {
			uur4 = (request.getParameter(UUR_4));
		} else {
			uur4 = "N";

		}
		if (request.getParameter(UUR_3) != null) {
			uur3 = (request.getParameter(UUR_3));
		} else {
			uur3 = "N";

		}
		if (request.getParameter(UUR_2) != null) {
			uur2 = (request.getParameter(UUR_2));
		} else {
			uur2 = "N";

		}
		if (request.getParameter(UUR_1) != null) {
			uur1 = (request.getParameter(UUR_1));
		} else {
			uur1 = "N";

		}

		if (request.getParameter(UUL_8) != null) {
			uul8 = (request.getParameter(UUL_8));
		} else {
			uul8 = "N";

		}
		if (request.getParameter(UUL_7) != null) {
			uul7 = (request.getParameter(UUL_7));

		} else {
			uul7 = "N";

		}
		if (request.getParameter(UUL_6) != null) {
			uul6 = (request.getParameter(UUL_6));
		} else {
			uul6 = "N";

		}
		if (request.getParameter(UUL_5) != null) {
			uul5 = (request.getParameter(UUL_5));
		} else {
			uul5 = "N";

		}
		if (request.getParameter(UUL_4) != null) {
			uul4 = (request.getParameter(UUL_4));
		} else {
			uul4 = "N";

		}
		if (request.getParameter(UUL_3) != null) {
			uul3 = (request.getParameter(UUL_3));
		} else {
			uul3 = "N";

		}
		if (request.getParameter(UUL_2) != null) {
			uul2 = (request.getParameter(UUL_2));
		} else {
			uul2 = "N";

		}
		if (request.getParameter(UUL_1) != null) {
			uul1 = (request.getParameter(UUL_1));
		} else {
			uul1 = "N";

		}
		if (request.getParameter(ULR_8) != null) {
			ulr8 = (request.getParameter(ULR_8));
		} else {
			ulr8 = "N";

		}

		if (request.getParameter(ULR_7) != null) {
			ulr7 = (request.getParameter(ULR_7));
		} else {
			ulr7 = "N";

		}
		if (request.getParameter(ULR_6) != null) {
			ulr6 = (request.getParameter(ULR_6));
		} else {
			ulr6 = "N";

		}
		if (request.getParameter(ULR_5) != null) {
			ulr5 = (request.getParameter(ULR_5));
		} else {
			ulr5 = "N";

		}
		if (request.getParameter(ULR_4) != null) {
			ulr4 = (request.getParameter(ULR_4));
		} else {
			ulr4 = "N";

		}
		if (request.getParameter(ULR_3) != null) {
			ulr3 = (request.getParameter(ULR_3));
		} else {
			ulr3 = "N";

		}
		if (request.getParameter(ULR_2) != null) {
			ulr2 = (request.getParameter(ULR_2));
		} else {
			ulr2 = "N";

		}
		if (request.getParameter(ULR_1) != null) {
			ulr1 = (request.getParameter(ULR_1));
		} else {
			ulr1 = "N";

		}

		if (request.getParameter(ULL_8) != null) {
			ull8 = (request.getParameter(ULL_8));
		} else {
			ull8 = "N";

		}
		if (request.getParameter(ULL_7) != null) {
			ull7 = (request.getParameter(ULL_7));
		} else {
			ull7 = "N";

		}
		if (request.getParameter(ULL_6) != null) {
			ull6 = (request.getParameter(ULL_6));
		} else {
			ull6 = "N";

		}
		if (request.getParameter(ULL_5) != null) {
			ull5 = (request.getParameter(ULL_5));
		} else {
			ull5 = "N";

		}
		if (request.getParameter(ULL_4) != null) {
			ull4 = (request.getParameter(ULL_4));
		} else {
			ull4 = "N";

		}
		if (request.getParameter(ULL_3) != null) {
			ull3 = (request.getParameter(ULL_3));
		} else {
			ull3 = "N";

		}
		if (request.getParameter(ULL_2) != null) {
			ull2 = (request.getParameter(ULL_2));
		} else {
			ull2 = "N";

		}
		if (request.getParameter(ULL_1) != null) {
			ull1 = (request.getParameter(ULL_1));
		} else {
			ull1 = "N";

		}

		// ////////////////////////

		if (request.getParameter(MUR_8) != null) {
			mur8 = (request.getParameter(MUR_8));

		} else {
			mur8 = "N";

		}
		if (request.getParameter(MUR_7) != null) {
			mur7 = (request.getParameter(MUR_7));
		} else {
			mur7 = "N";

		}
		if (request.getParameter(MUR_6) != null) {
			mur6 = (request.getParameter(MUR_6));
		} else {
			mur6 = "N";

		}
		if (request.getParameter(MUR_5) != null) {
			mur5 = (request.getParameter(MUR_5));
		} else {
			mur5 = "N";

		}
		if (request.getParameter(MUR_4) != null) {
			mur4 = (request.getParameter(MUR_4));
		} else {
			mur4 = "N";

		}
		if (request.getParameter(MUR_3) != null) {
			mur3 = (request.getParameter(MUR_3));
		} else {
			mur3 = "N";

		}
		if (request.getParameter(MUR_2) != null) {
			mur2 = (request.getParameter(MUR_2));
		} else {
			mur2 = "N";

		}
		if (request.getParameter(MUR_1) != null) {
			mur1 = (request.getParameter(MUR_1));
		} else {
			mur1 = "N";

		}

		if (request.getParameter(MUL_8) != null) {
			mul8 = (request.getParameter(MUL_8));
		} else {
			mul8 = "N";

		}
		if (request.getParameter(MUL_7) != null) {
			mul7 = (request.getParameter(MUL_7));

		} else {
			mul7 = "N";

		}
		if (request.getParameter(MUL_6) != null) {
			mul6 = (request.getParameter(MUL_6));
		} else {
			mul6 = "N";

		}
		if (request.getParameter(MUL_5) != null) {
			mul5 = (request.getParameter(MUL_5));
		} else {
			mul5 = "N";

		}
		if (request.getParameter(MUL_4) != null) {
			mul4 = (request.getParameter(MUL_4));
		} else {
			mul4 = "N";

		}
		if (request.getParameter(MUL_3) != null) {
			mul3 = (request.getParameter(MUL_3));
		} else {
			mul3 = "N";

		}
		if (request.getParameter(MUL_2) != null) {
			mul2 = (request.getParameter(MUL_2));
		} else {
			mul2 = "N";

		}
		if (request.getParameter(MUL_1) != null) {
			mul1 = (request.getParameter(MUL_1));
		} else {
			mul1 = "N";

		}
		if (request.getParameter(MLR_8) != null) {
			mlr8 = (request.getParameter(MLR_8));
		} else {
			mlr8 = "N";

		}

		if (request.getParameter(MLR_7) != null) {
			mlr7 = (request.getParameter(MLR_7));
		} else {
			mlr7 = "N";

		}
		if (request.getParameter(MLR_6) != null) {
			mlr6 = (request.getParameter(MLR_6));
		} else {
			mlr6 = "N";

		}
		if (request.getParameter(MLR_5) != null) {
			mlr5 = (request.getParameter(MLR_5));
		} else {
			mlr5 = "N";

		}

		if (request.getParameter(MLR_4) != null) {
			mlr4 = (request.getParameter(MLR_4));
		} else {
			mlr4 = "N";

		}
		if (request.getParameter(MLR_3) != null) {
			mlr3 = (request.getParameter(MLR_3));
		} else {
			mlr3 = "N";

		}

		if (request.getParameter(MLR_2) != null) {
			mlr2 = (request.getParameter(MLR_2));
		} else {
			mlr2 = "N";

		}
		if (request.getParameter(MLR_1) != null) {
			mlr1 = (request.getParameter(MLR_1));
		} else {
			mlr1 = "N";

		}

		if (request.getParameter(MLL_8) != null) {
			mll8 = (request.getParameter(MLL_8));
		} else {
			mll8 = "N";

		}
		if (request.getParameter(MLL_7) != null) {
			mll7 = (request.getParameter(MLL_7));
		} else {
			mll7 = "N";

		}
		if (request.getParameter(MLL_6) != null) {
			mll6 = (request.getParameter(MLL_6));
		} else {
			mll6 = "N";

		}
		if (request.getParameter(MLL_5) != null) {
			mll5 = (request.getParameter(MLL_5));
		} else {
			mll5 = "N";

		}
		if (request.getParameter(MLL_4) != null) {
			mll4 = (request.getParameter(MLL_4));
		} else {
			mll4 = "N";

		}
		if (request.getParameter(MLL_3) != null) {
			mll3 = (request.getParameter(MLL_3));
		} else {
			mll3 = "N";

		}
		if (request.getParameter(MLL_2) != null) {
			mll2 = (request.getParameter(MLL_2));
		} else {
			mll2 = "N";

		}
		if (request.getParameter(MLL_1) != null) {
			mll1 = (request.getParameter(MLL_1));
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
		OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
		
		if (request.getParameter("dentalValue") != null
				&& !request.getParameter("dentalValue").equals("")) {
			opdPatientDetails.setDentalValue(request.getParameter("dentalValue"));
		}
		if (request.getParameter("dentalReferToMH") != null
				&& !(request.getParameter("dentalReferToMH").equals(""))) {
			denatlToMH = request.getParameter("dentalReferToMH");
			opdPatientDetails.setDentalReferToMH(denatlToMH);
		}
		
		if (request.getParameter("dentalValue") != null
				&& !request.getParameter("dentalValue").equals("")) {
			opdPatientDetails.setDentalValue(request.getParameter("dentalValue"));
		}
		String presentAdvice="";
		if (request.getParameter("presentAdvice") != null) {
			presentAdvice = request.getParameter("presentAdvice");
		}
	
		
		opdPatientDetails.setTotalMissingTeeth(box.getString("MissTeeth"));
		opdPatientDetails.setTotalUnsaveableTeeth(box.getString("UnserTeeth"));
		
		opdPatientDetails.setNoOfDefectiveTeeth(totalDefectiveTeeth);
		opdPatientDetails.setNoOfTeeth(totalTeeth);
		opdPatientDetails.setMissingTeeth(missingTeeth);
		opdPatientDetails.setUnSaveableTeeth(unserviceableTeeth);
		opdPatientDetails.setNoOfDentalPoints(DenstalPoint);
		opdPatientDetails.setUR1(sur1);
		opdPatientDetails.setUR2(sur2);
		opdPatientDetails.setUR3(sur3);
		opdPatientDetails.setUR4(sur4);
		opdPatientDetails.setUR5(sur5);
		opdPatientDetails.setUR6(sur6);
		opdPatientDetails.setUR7(sur7);
		opdPatientDetails.setUR8(sur8);

		opdPatientDetails.setUL1(sul1);
		opdPatientDetails.setUL2(sul2);
		opdPatientDetails.setUL3(sul3);
		opdPatientDetails.setUL4(sul4);
		opdPatientDetails.setUL5(sul5);
		opdPatientDetails.setUL6(sul6);
		opdPatientDetails.setUL7(sul7);
		opdPatientDetails.setUL8(sul8);

		opdPatientDetails.setLR1(slr1);
		opdPatientDetails.setLR2(slr2);
		opdPatientDetails.setLR3(slr3);
		opdPatientDetails.setLR4(slr4);
		opdPatientDetails.setLR5(slr5);
		opdPatientDetails.setLR6(slr6);
		opdPatientDetails.setLR7(slr7);
		opdPatientDetails.setLR8(slr8);

		opdPatientDetails.setLL1(sll1);
		opdPatientDetails.setLL2(sll2);
		opdPatientDetails.setLL3(sll3);
		opdPatientDetails.setLL4(sll4);
		opdPatientDetails.setLL5(sll5);
		opdPatientDetails.setLL6(sll6);
		opdPatientDetails.setLL7(sll7);
		opdPatientDetails.setLL8(sll8);
		
		if (request.getParameter(DENTAL_REMARKS) != null
				&& !request.getParameter(DENTAL_REMARKS).equals("")) {
			opdPatientDetails.setMissingTeethRemark(request.getParameter(DENTAL_REMARKS));
		}
		
		//----
		
		
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
		
		int systemDiagnosisId = 0;
		if(request.getParameter("systemDiagnosis") != null && !request.getParameter("systemDiagnosis").equals("")){
			String systemDiagnosis = request.getParameter("systemDiagnosis");
			int index1 = systemDiagnosis.lastIndexOf("[");
			int index2 = systemDiagnosis.lastIndexOf("]");
			index1++;
			systemDiagnosisId =Integer.parseInt(systemDiagnosis.substring(index1, index2));
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
		//Integer userId = user.getEmployee().getId();
		Integer userId = user.getId();
		box.put("userId", userId);

		String personalHistory = "";
		//String familyHistory = "";
		String otherDetails = "";

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
		

		if (request.getParameter("personalHistory") != null) {
			personalHistory = request.getParameter("personalHistory");
		}

		/*if (request.getParameter("familyHistory") != null) {
			familyHistory = request.getParameter("familyHistory");
		}*/
		/**
		 * Added By Anamika for multiple family history
		 */
		String[] familyHistoryArray = null;
		if(request.getParameterValues("familyHistory") !=null) {
			familyHistoryArray = request.getParameterValues("familyHistory");
			//objectMap.put("familyHistoryArray", familyHistoryArray);
		}
		String otherFamilyHistorty = "";
		if (request.getParameter("otherFamilyHistory") != null) {
			otherFamilyHistorty= request.getParameter("otherFamilyHistory");
			
		}
		if (request.getParameter("allergies") != null) {
			allergies= request.getParameter("allergies");
			
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

		/*if (!request.getParameter("onExamination").equals("")
				&& (request.getParameter("onExamination") != null)) {
			onExamination = request.getParameter("onExamination");
		}*/
		/*
		 * String remaks=""; if (request.getParameter("remaks") != null) {
		 * remaks = request.getParameter("remaks"); }
		 */

		String consultationDate = request.getParameter("consultationDate");
		String consultationTime = request.getParameter("consultationTime");

		// details captured for patient prescription header and detail table
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
		String orderSeqNo = opdHandlerService.generateOrderNumber(hospitalId);
		box.put("orderSeqNo", orderSeqNo);
		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		String[] pvmsArr = new String[hdb];
		String otherMedicine = "";
		List<String> otherMedicineList = new ArrayList<String>();
		List<String> ctList = new ArrayList<String>();
		//List injCategoryList = new ArrayList();
		int j = 1;
		for (int i = 0; i < hdb; i++) {
			String pvmsNo = "";
			if (request.getParameter("nomenclature" + j) != null && !request.getParameter("nomenclature" + j).equals("")) {

				String nomenclature = request.getParameter("nomenclature" + j);
				int index1 = nomenclature.lastIndexOf("[");
				int index2 = nomenclature.lastIndexOf("]");
				index1++;
				pvmsNo = nomenclature.substring(index1, index2);
				if (!pvmsNo.equals("")) {
					pvmsArr[i] = pvmsNo;
				}
			}else{
				if(request.getParameter("otherMedicine"+ j) != null && !request.getParameter("otherMedicine"+ j).equals("")){
					otherMedicine = request.getParameter("otherMedicine"+ j);
					otherMedicineList.add(otherMedicine);
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
			
			int frequenceValue = 0;
			if(request.getParameter("frequencyValue" + j) != null && !request.getParameter("frequencyValue" + j).equals("")){
				frequenceValue =Integer.parseInt(request.getParameter("frequencyValue" + j));
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

		
			if(!pvmsNo.equals("")){
				pvmsNoList.add(pvmsNo);
			}
			//	pvmsNoList.add(pvmsArr[i]);

			j++;
		}
		// -------------------fetching values for Investigation
		// template---------------
		// -------------------fetching values for Investigation
		// template---------------
		List<String> chargeCodeIdList = new ArrayList<String>();
	//	List<Integer> quantityList = new ArrayList<Integer>();
		List<String> referToMhList = new ArrayList<String>();
		
		// List<String> clinicalList = new ArrayList<String>();
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
					// int
					// qty=Integer.parseInt(request.getParameter("qty"+temp));
					// String clinicalNotes =
					// request.getParameter("clinicalNotes" + temp);
					if(request.getParameter("referToMh" + i) != null && !request.getParameter("referToMh" + i).equals("")){
						String referToMh = request.getParameter("referToMh" + i);
						referToMhList.add(referToMh);
					}else{
						String referToMh = "n";
						referToMhList.add(referToMh);
					}
					chargeCodeIdList.add(chargeCodeIdArr[i]);
					//quantityList.add(qty);
					// clinicalList.add(clinicalNotes);
					
					
				}
			}
			temp++;
		}
		
		
		if(request.getParameter("procedureHeaderId")!=null && !request.getParameter("procedureHeaderId").equals("0")){
			mapForDS.put("procedureHeaderId", Integer.parseInt(request.getParameter("procedureHeaderId")));
		}
		if(request.getParameter("physioRequisitionHeaderId")!=null && !request.getParameter("physioRequisitionHeaderId").equals("0")){
			mapForDS.put("physioRequisitionHeaderId", Integer.parseInt(request.getParameter("physioRequisitionHeaderId")));
		}
		mapForDS.put("deptId",  (Integer)session.getAttribute("deptId"));
		mapForDS.put("referredDoctars", referredDoctars);
		mapForDS.put("pvmsNoList", pvmsNoList);
		mapForDS.put("frequencyList", frequencyList);
		mapForDS.put("ctList", ctList);
		mapForDS.put("dosageList", dosageList);
		mapForDS.put("typeLeftRightList", typeLeftRightList);
		mapForDS.put("instructionList", instructionList);
		mapForDS.put("routeList", routeList);
		
		mapForDS.put("totalList", totalList);
		mapForDS.put("noOfDaysList", noOfDaysList);
		mapForDS.put("hinId", hinId);
		mapForDS.put("departmentId", departmentId);
		mapForDS.put("remarksList", remarksList);
		mapForDS.put("userId", userId);
		mapForDS.put("visitId", visitId);
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("userName", userName);
		mapForDSPro.put("visitId", box.getInt("visitId"));
		mapForDSPro.put("consultationDate", consultationDate);
		mapForDSPro.put("diagnosisIdAray", diagnosisIdAray);
		mapForDSPro.put("disposal", disposal);
		mapForDS.put("otherMedicineList", otherMedicineList);
		mapForDS.put("itemConversionList", itemConversionList);
		mapForDS.put("presentAdvice", presentAdvice);
		//mapForDS.put("injCategoryList", injCategoryList);
		
		
		// ----------data for investigation template------

		mapForDS.put("chargeCodeIdList", chargeCodeIdList);
		//mapForDS.put("quantityList", quantityList);
		mapForDS.put("clinicalNotes1", clinicalNotes1);
		mapForDS.put("referToMhList", referToMhList);
		
		// ------------data for opd patient details----------
		mapForDS.put("empId", empId);
		mapForDS.put("empIdCurrnet", empIdCurrnet);
		mapForDS.put("disposal", disposal);
		//mapForDS.put("disposalDays",disposalDays);
		mapForDS.put("consultationDate", consultationDate);
		mapForDS.put("consultationTime", consultationTime);
		mapForDS.put("afmsDescription", afmsDescription);
		mapForDS.put("systemDiagnosisId", systemDiagnosisId);
		//mapForDS.put("referredDept", referredDept);
		mapForDS.put("nextVisitDate", nextVisitDate);

		mapForDS.put("personalHistory", personalHistory);
		mapForDS.put("familyHistoryArray", familyHistoryArray);
		mapForDS.put("otherFamilyHistorty", otherFamilyHistorty);
		mapForDS.put("allergies", allergies);
		mapForDS.put("reviewAt", reviewAt);
		mapForDS.put("otherDetails", otherDetails);
		//mapForDS.put("onExamination", onExamination);
		mapForDS.put("referedToMH", referedToMH);
		mapForDS.put("mh", mh);
		mapForDS.put("mhDepartment", mhDepartment);
		mapForDS.put("mhReferredFor", mhReferredFor);
		// --------- data for diagnosis------------
		mapForDS.put("diagnosisIdAray", diagnosisIdAray);
		//mapForDS.put("deptId", departmentId);
		mapForDS.put("adviceOnDischarge", adviceOnDischarge);
		mapForDS.put("pastDiagnosis", pastDiagnosis);
		mapForDS.put("pastdisposal", pastdisposal);
		mapForDS.put("threpytypeId", threpytypeId);
		mapForDS.put("DaysPhy", DaysPhy);
		mapForDS.put("DurationPhy", DurationPhy);
		mapForDS.put("mapForDSPro", mapForDSPro);
		mapForDS.put("opdPatientDetails", opdPatientDetails);
		//mapForDS.put("currentDate",HMSUtil.convertStringTypeDateToDateType(box.getString("consultationDate")));

		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean bool = false;

		returnMap = fwcHandlerService.submitPncPatientDetails(mapForDS,box);

		if (returnMap.get("succesfullyAdded") != null) {
			bool = (Boolean) returnMap.get("succesfullyAdded");
		}
		if (returnMap.get("orderSeqNo") != null) {
			orderSeqNo = (String) returnMap.get("orderSeqNo");
		}

		String message = null;
		
		if (bool) {
			if (flag.equals("pnc")) {
				
				map = fwcHandlerService.getWaitingPatientList(mapForDS);
				message = "Patient Details Submitted.";
				jsp = "fwc_messgae";
				submitData = true;
			}
		} else {
			map = fwcHandlerService.getWaitingPatientList(mapForDS);
			message = "Error Occurred in Submitting Details.";
			jsp = FWC_WAITING_LIST_JSP;
		}
		if(request.getParameter("unitId")!=null && !(request.getParameter("unitId").equals(""))){
			map.put("unitId", Integer.parseInt(request.getParameter("unitId")));
		}
		jsp += ".jsp";
		map.put("message", message);
		map.put("submitData", submitData);
		map.put("departmentId", departmentId);
		map.put("visitNoForReport", box.getInt(VISIT_NUMBER));
		map.put("orderNoForReport", orderSeqNo);
		map.put("serviceNoForReport", box.getString(SERVICE_NO));
		map.put("visitId", box.getInt("visitId"));
		map.put("hinNoForReport", box.getString(HIN_NO));
		map.put("flag", flag);
		title = "Patient Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}  
	public ModelAndView showPncReportJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int visitNo = 0;
		String serviceNo = "";
		String hinNo = "";
		int visitId = 0;
		if (request.getParameter(SERVICE_NO_FOR_REPORT) != null) {
			serviceNo = request.getParameter(SERVICE_NO_FOR_REPORT);
		}
		if (request.getParameter(VISIT_NUMBER_FOR_REPORT) != null) {
			visitNo = Integer.parseInt(request
					.getParameter(VISIT_NUMBER_FOR_REPORT));
		}
		if (request.getParameter(HIN_NO_FOR_REPORT) != null) {
			hinNo = request.getParameter(HIN_NO_FOR_REPORT);
		}
		if (request.getParameter(VISIT_ID) != null) {
			visitId =Integer.parseInt(request.getParameter(VISIT_ID));
		}
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = opdHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("visitId", visitId);
		parameters.put("hospitalId", hospitalId);
		parameters.put("visitNo", visitNo);
		parameters.put("serviceNo", serviceNo);
		parameters.put("hinNo", hinNo);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("Fwc_PNC_test"), parameters,
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
		return null;
	}
	
	
	//-----Show Immunization
	
	public ModelAndView showImmunisationJsp(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		MultipartFormDataRequest mrequest = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		 int visitId = 0;
		 if(request.getParameter("visitId") != null){
			 visitId = Integer.parseInt(request.getParameter("visitId"));
			 dataMap.put("visitId", visitId);
		 }
		map = fwcHandlerService.showImmunisationJsp(dataMap);
		
		jsp = "immunisation";
		jsp += ".jsp";
		
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView submitFwcImmunizationDetail(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		List<Integer> immuDtIdList  = new ArrayList<Integer>();
		List<Integer> immuIdList  = new ArrayList<Integer>();
		List<String> immuDateList  = new ArrayList<String>();
		List<String> doseList  = new ArrayList<String>();
		List<String> routeList  = new ArrayList<String>();
		List<String> batchNoList  = new ArrayList<String>();
		List<String> dueDateList  = new ArrayList<String>();
		List<String> immuNameList  = new ArrayList<String>();
		Box box = HMSUtil.getBox(request);
		int hospitalId  = 0;
		int userId = 0;
		int hinId = 0;
		int deptId = 0;
		String flag = "";
		int visitId = 0;
		boolean submitData = false;
		if (!request.getParameter("flag").equals("")) {
			flag = request.getParameter("flag");
		}
		
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			mapForDS.put("hospitalId", hospitalId);
		}
		if(session.getAttribute("deptId") != null){
			deptId = (Integer) session.getAttribute("deptId");
			mapForDS.put("deptId", deptId);
		}
		if(request.getParameter("visitId") != null){
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		
		if(request.getParameter("hinId")!=null)
		{
			hinId=Integer.parseInt(request.getParameter("hinId").toString());
			mapForDS.put("hinId", hinId);
		}
		Users user = new Users();
		if(session.getAttribute("users")!=null){
			user = (Users)session.getAttribute("users");
			mapForDS.put("userId", user.getId());
			mapForDS.put("empId", user.getEmployee().getId());
		}
		int count = 0;
		int cnt = 0;
		if(request.getParameter("count")!=null)
		{
			count=Integer.parseInt(request.getParameter("count").toString());
		}
		if(request.getParameter("cnt")!=null){
			cnt=Integer.parseInt(request.getParameter("cnt").toString());
		}
		
		String immunizationType = "";
		if(request.getParameter("immunizationType") != null){
			immunizationType = request.getParameter("immunizationType");
		}
		if(immunizationType.equals("Infant")){
		  for(int j = 1; j <= count; j++) {
				if(request.getParameter("immunizationName"+j)!=null){
					immuNameList.add(request.getParameter("immunizationName"+j));
				
				
				if(request.getParameter("immuDate"+j)!=null){
					immuDateList.add(request.getParameter("immuDate"+j));
				}
				if(request.getParameter("dose"+j)!=null){
					doseList.add(request.getParameter("dose"+j));
				}
				if(request.getParameter("route"+j)!=null){
					routeList.add(request.getParameter("route"+j));
				}
				if(request.getParameter("dueDate"+j)!=null){
					dueDateList.add(request.getParameter("dueDate"+j));
				}
			  }
			}
		  }
		if(immunizationType.equals("ANC")){ 
		 for(int k = 1; k <= cnt; k++){
				if(request.getParameter("immunizationNameAnc"+k)!=null){
					immuNameList.add(request.getParameter("immunizationNameAnc"+k));
				
				if(request.getParameter("immuDateAnc"+k)!=null){
					immuDateList.add(request.getParameter("immuDateAnc"+k));
				}
				if(request.getParameter("doseAnc"+k)!=null){
					doseList.add(request.getParameter("doseAnc"+k));
				}
				if(request.getParameter("routeAnc"+k)!=null){
					routeList.add(request.getParameter("routeAnc"+k));
				}
				if(request.getParameter("dueDateAnc"+k)!=null){
					dueDateList.add(request.getParameter("dueDateAnc"+k));
				}
		      }
		    }
		  }
		mapForDS.put("immunizationType", immunizationType);
		mapForDS.put("immuDtIdList", immuDtIdList);
		mapForDS.put("immuDateList", immuDateList);
		mapForDS.put("doseList", doseList);
		mapForDS.put("routeList", routeList);
		mapForDS.put("dueDateList", dueDateList);
		mapForDS.put("hospitalId",hospitalId);
		mapForDS.put("hinId",hinId);
		mapForDS.put("visitId",visitId);
		mapForDS.put("immuNameList",immuNameList);
		boolean bool = false;
		
		map = fwcHandlerService.submitFwcImmunizationDetail(mapForDS);
		if (map.get("status") != null) {
			bool = (Boolean) map.get("status");
		}
		
		String message = null;
		if (bool) {
			if (flag.equals("immunization")) {
				
				//map = fwcHandlerService.getWaitingPatientList(mapForDS);
				message = "Immunization Details Submitted.";
				map.put("message", message);
				
			}
		} else {
			//map = fwcHandlerService.getWaitingPatientList(mapForDS);
			message = "Error Occurred in Submitting Details.";
			map.put("message", message);
		
		}

		jsp = "fwcImmunization";
		jsp += ".jsp";
		title = "Patient Details";
		map.put("contentJsp", jsp);
		map.put("flag", flag);
		map.put("title", title);
		map.put("hinId", hinId);
		map.put("visitId", visitId);
		return new ModelAndView("indexB", "map", map);
	}
	//-----Show Family Planning
	
	public ModelAndView showFamilyPlanningJsp(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		MultipartFormDataRequest mrequest = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int deptId = 0;
		if(session.getAttribute("deptId") != null){
			deptId = (Integer) session.getAttribute("deptId");
			generalMap.put("deptId", deptId);
		}
		 int visitId = 0;
		 if(request.getParameter("visitId") != null){
			 visitId = Integer.parseInt(request.getParameter("visitId"));
			 generalMap.put("visitId", visitId);
		 }
		int hospitalId = 0;
		if(session.getAttribute("hospitalId") != null){
			hospitalId = (Integer) session.getAttribute("hospitalId");
			generalMap.put("hospitalId", hospitalId);
		}
		map = fwcHandlerService.showFamilyPlanningJsp(generalMap);
		jsp = "familyPlanning";
		jsp += ".jsp";
		
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView submitfamilyPlanningDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId  = 0;
		int userId = 0;
		int deptId = 0;
		String flag = "";
		if(request.getParameter("flag")!= null){
			flag = request.getParameter("flag");
		}
		if(session.getAttribute("hospitalId") != null){
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		if(session.getAttribute("deptId") != null){
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
		}
		 int visitId = 0;
		 if(request.getParameter("visitId") != null){
			 visitId = Integer.parseInt(request.getParameter("visitId"));
			 generalMap.put("visitId", visitId);
		 }
		
		Users user = new Users();
		if(session.getAttribute("users")!=null){
			user = (Users)session.getAttribute("users");
			box.put("userId", user.getId());
			box.put("empId", user.getEmployee().getId());
		}
		String userName = "";
		if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
		box.put("userName", userName);
		}
		String orderSeqNo = opdHandlerService.generateOrderNumber(hospitalId);
		box.put("orderSeqNo", orderSeqNo);
		//----------------code for investigation-----------------------//
		List<String> chargeCodeIdList = new ArrayList<String>();
		List<String> referToMhList = new ArrayList<String>();
		
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
					if(request.getParameter("referToMh" + i) != null && !request.getParameter("referToMh" + i).equals("")){
						String referToMh = request.getParameter("referToMh" + i);
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
	//------------------end of the code investegation-------------------//
		generalMap.put("chargeCodeIdList", chargeCodeIdList);
		generalMap.put("referToMhList", referToMhList);
		
		boolean bool = false;
		map = fwcHandlerService.submitfamilyPlanningDetails(box,generalMap);
		String message = null;
		if (map.get("sucessfullyAdded") != null) {
			bool = (Boolean) map.get("sucessfullyAdded");
		}
		if (bool) {
			//if (flag.equals("fwc")) {
				
				//map = fwcHandlerService.getWaitingPatientList(mapForDS);
				message = "Patient Details Submitted.";
				map.put("message", message);
			//}
		} else {
			//map = fwcHandlerService.getWaitingPatientList(mapForDS);
			message = "Error Occurred in Submitting Details.";
			map.put("message", message);
		}
		jsp = "fwcMessage";
		jsp += ".jsp";
	//	map = fwcHandlerService.showFamilyPlanningJsp(generalMap);
		message = "Record Added Successfully!";
		/*jsp = "familyPlanning";
		jsp += ".jsp";*/
		map.put("flag", flag);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	//-----Show Report
	
	public ModelAndView showReportJsp(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		MultipartFormDataRequest mrequest = null;
		
		//int empId = (Integer) session.getAttribute("userId");
		//int deptId = (Integer) session.getAttribute("deptId");
		
		jsp = "report";
		jsp += ".jsp";
		
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
//-----Show Contingent Bills
	
	public ModelAndView showContingentBillsJsp(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		MultipartFormDataRequest mrequest = null;
		
		//int empId = (Integer) session.getAttribute("userId");
		//int deptId = (Integer) session.getAttribute("deptId");
		
		jsp = "contingentBill";
		jsp += ".jsp";
		
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	public ModelAndView forwardToMoFamilyPlanning(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = fwcHandlerService.forwardToMoFamilyPlanning(box);
		String message = null;
		boolean saved = false;
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
				message = "Record forwarded to MO.";
				map.put("message", message);
		} else {
			message = "Error Occurred in Submitting Details.";
			map.put("message", message);
		}
		jsp = "fwcMessage";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
	
	//-----Show Sterilization Certificate
	
	public ModelAndView showSterilisationWaitinglistJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int hinId = 0;
		int visitId = 0;
		if(request.getParameter("hinId") != null){
			hinId = Integer.parseInt(request.getParameter("hinId"));
		}
		if(request.getParameter("visitId") != null){
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		generalMap.put("hinId", hinId);
		generalMap.put("visitId", visitId);
		generalMap.put("hospitalId", hospitalId);
		map = fwcHandlerService.showSterilisationWaitinglistJsp(generalMap);
		//int empId = (Integer) session.getAttribute("userId");
		//int deptId = (Integer) session.getAttribute("deptId");
		
		jsp = "sterilizationWaitingList";
		jsp += ".jsp";
		
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView showIssueSterilizationCertificateJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Box box = HMSUtil.getBox(request);
		
		map = fwcHandlerService.showIssueSterilizationCertificateJsp(box);
		
		jsp = "sterilizationCertificate";
		jsp += ".jsp";
		
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	//-----Show Conception Case
	
	public ModelAndView showConceptionCaseJsp(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		MultipartFormDataRequest mrequest = null;
		
		//int empId = (Integer) session.getAttribute("userId");
		//int deptId = (Integer) session.getAttribute("deptId");
		
		jsp = "conceptionCase";
		jsp += ".jsp";
		
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	//-----Show Delivery Details
	
	public ModelAndView showDeliveryDetailsJsp(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		MultipartFormDataRequest mrequest = null;
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		 int visitId = 0;
		 if(request.getParameter("visitId") != null){
			 visitId = Integer.parseInt(request.getParameter("visitId"));
			 dataMap.put("visitId", visitId);
		 }
		 int hinId = 0;
		 if(request.getParameter("hinId") != null){
			 hinId = Integer.parseInt(request.getParameter("hinId"));
			 dataMap.put("hinId", hinId);
		 }
		 int deptId = (Integer) session.getAttribute("deptId");
		 dataMap.put("deptId", deptId);
		map = fwcHandlerService.showDeliveryDetails(dataMap);
		jsp = "deliveryDetails";
		jsp += ".jsp";
		
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView getDeliveryDetailsPatientData(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hinId = 0;
		 hinId = box.getInt("hinId");
		box.put("hinId", hinId);
		int visitId=0;
		box.put("visitId", visitId);
		map = fwcHandlerService.getPatientDetails(box);
		String jsp = "fwc_deliveryDetailsVisitEntry";
		map.put("hinId", hinId);
		map.put("visitId", visitId);
		return new ModelAndView(jsp, "map", map);
	}
	
	//-----Show IUD, Oral Pill
	
	public ModelAndView showIudOralPillJsp(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		MultipartFormDataRequest mrequest = null;
		
		//int empId = (Integer) session.getAttribute("userId");
		//int deptId = (Integer) session.getAttribute("deptId");
		
		jsp = "iudOralPill";
		jsp += ".jsp";
		
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	
	//-----Show Budget and Expense Entry
	
	public ModelAndView showBudgetExpenseJsp(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		MultipartFormDataRequest mrequest = null;
		
		//int empId = (Integer) session.getAttribute("userId");
		//int deptId = (Integer) session.getAttribute("deptId");
		
		jsp = "budgetExpense";
		jsp += ".jsp";
		
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}
	

	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile.getPath());

		return jasperReport;
	}

//---FWC Help
	
public void showFwcHelp(HttpServletRequest request,HttpServletResponse response) {

		
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome
				+ fileSeparator
				+ "help"
				+ fileSeparator;
				
	
		
		try {
			
			response.setContentType("application/pdf");
			
			response.setHeader("Content-Disposition", "attachment;filename="
					+ java.net.URLEncoder.encode("FWC.pdf")
					+ "");

			File f = new File(uploadURL + "/FWC.pdf");
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
	
	public ModelAndView issueSterilisationCertificate(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = fwcHandlerService.issueSterilisationCertificate(box);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = fwcHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("famPlanId", box.getInt("famPlanId"));
		parameters.put("IssuedBy",  box.getString("issuedBy"));
		HMSUtil.generateReport("sterilization_certificate", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());	
		
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		generalMap.put("hospitalId", hospitalId);
		map = fwcHandlerService.showSterilisationWaitinglistJsp(generalMap);
		
		jsp = "sterilizationWaitingList";
		jsp += ".jsp";
	
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
		
	}
	
	
	public ModelAndView viewUlterSoundTestForOrderNo(HttpServletRequest request,
			HttpServletResponse response) {
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> orderDetailMap = new HashMap<String, Object>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		int visitId = 0;
		int inPatientId = 0;
		if (request.getParameter("visitId") != null) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
			mapForDs.put("visitId", visitId);
		}
		if (request.getParameter("hinId") != null) {
			int hinId = Integer.parseInt(request.getParameter("hinId"));
			mapForDs.put("hinId", hinId);
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			inPatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			mapForDs.put("inPatientId", inPatientId);
		}

		// orderNoList = labHandlerService.getOrderNoList(mapForDs);

		orderDetailMap = fwcHandlerService.viewUlterSoundTestForOrderNo(mapForDs);

		jsp = "viewUSGDetailsForOrderNo";

		map.put("orderDetailMap", orderDetailMap);
		map.put("orderNoList", orderNoList);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView viewOtherInvTestForOrderNo(HttpServletRequest request,
			HttpServletResponse response) {
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> orderDetailMap = new HashMap<String, Object>();

		if (request.getSession(false) == null) {
			return new ModelAndView("login");
		}

		HttpSession session = request.getSession();
		String deptName = "";
		String jsp = "";

		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		int visitId = 0;
		int inPatientId = 0;
		if (request.getParameter("visitId") != null) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
			mapForDs.put("visitId", visitId);
		}
		if (request.getParameter("hinId") != null) {
			int hinId = Integer.parseInt(request.getParameter("hinId"));
			mapForDs.put("hinId", hinId);
		}
		if (request.getParameter(INPATIENT_ID) != null) {
			inPatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			mapForDs.put("inPatientId", inPatientId);
		}

		// orderNoList = labHandlerService.getOrderNoList(mapForDs);

		orderDetailMap = fwcHandlerService.viewOtherInvTestForOrderNo(mapForDs);

		jsp = "viewUSGDetailsForOrderNo";

		map.put("orderDetailMap", orderDetailMap);
		map.put("orderNoList", orderNoList);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView submitFollowUp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId  = 0;
		int userId = 0;
		int deptId = 0;
		boolean submitData = false;
		String flag = "";
		if (!request.getParameter("flag").equals("")) {
			flag = request.getParameter("flag");
		}
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			box.put("deptId", deptId);
		} else {
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
		}
		Users user = new Users();
		if(session.getAttribute("users")!=null){
			user = (Users)session.getAttribute("users");
			box.put("userId", user.getId());
			box.put("empId", user.getEmployee().getId());
		}
		String userName = "";
		if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
		box.put("userName", userName);
		}
		String orderSeqNo = opdHandlerService.generateOrderNumber(hospitalId);
		box.put("orderSeqNo", orderSeqNo);
		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}
		List<String> pvmsNoList = new ArrayList<String>();
		List<Integer> frequencyList = new ArrayList<Integer>();
		List<String> dosageList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();
		List<Integer> totalList = new ArrayList<Integer>();
		List<Integer> noOfDaysList = new ArrayList<Integer>();
		List<String> routeList = new ArrayList<String>();
		String[] pvmsArr = new String[hdb];
		String otherMedicine = "";
		List<String> otherMedicineList = new ArrayList<String>();
		List<String> ctList = new ArrayList<String>();
		
		//----------------code for investigation-----------------------//
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
						if(request.getParameter("referToMh" + i) != null && !request.getParameter("referToMh" + i).equals("")){
							String referToMh = request.getParameter("referToMh" + i);
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
		//------------------end of the code investegation-------------------//
		
		int j = 1;
		for (int i = 0; i < hdb; i++) {
			String pvmsNo = "";
			if (request.getParameter("nomenclature" + j) != null && !request.getParameter("nomenclature" + j).equals("")) {

				String nomenclature = request.getParameter("nomenclature" + j);
				int index1 = nomenclature.lastIndexOf("[");
				int index2 = nomenclature.lastIndexOf("]");
				index1++;
				pvmsNo = nomenclature.substring(index1, index2);
				if (!pvmsNo.equals("")) {
					pvmsArr[i] = pvmsNo;
				}
			}else{
				if(request.getParameter("otherMedicine"+ j) != null && !request.getParameter("otherMedicine"+ j).equals("")){
					otherMedicine = request.getParameter("otherMedicine"+ j);
					otherMedicineList.add(otherMedicine);
				}
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
			
			int frequenceValue = 0;
			if(request.getParameter("frequencyValue" + j) != null && !request.getParameter("frequencyValue" + j).equals("")){
				frequenceValue =Integer.parseInt(request.getParameter("frequencyValue" + j));
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
		
			if(!pvmsNo.equals("")){
				pvmsNoList.add(pvmsNo);
			}

			j++;
		}
		
		
		

	
	
		

		String dateAnc = "";
		String dateNextVisit = "";

			String fundal = "";
				if(request.getParameter("fundal") != null && !request.getParameter("fundal").equals("")){
					fundal = request.getParameter("fundal");
			
				}
				int pog = 0;
				if(request.getParameter("pog" ) != null && !request.getParameter("pog" ).equals("")){
					pog =Integer.parseInt(request.getParameter("pog"));
				
				}
				String weight = "";
			if(request.getParameter("weight") != null && !request.getParameter("weight").equals("")){
				weight =request.getParameter("weight");
			
			}	
			String bp = "";
			if(request.getParameter("bp") != null && !request.getParameter("bp").equals("")){
				bp = request.getParameter("bp");
				
			}
			
			if (request.getParameter("dateAnc") != null
					&& !request.getParameter("dateAnc").equals("")) {
				dateAnc = request.getParameter("dateAnc");
			}
			if (request.getParameter("dateNextVisit") != null
					&& !request.getParameter("dateNextVisit").equals("")) {
				dateNextVisit = request.getParameter("dateNextVisit");
			}
			
			String pp = "";
			if(request.getParameter("pp") != null && !request.getParameter("pp").equals("")){
				pp = request.getParameter("pp");
				
			}
			
			String foetalHeart = "";
			if(request.getParameter("foetalHeart") != null && !request.getParameter("foetalHeart").equals("")){
				foetalHeart = request.getParameter("foetalHeart");
			
			}
			
			String foetalHeadEngaged = "";
			if(request.getParameter("foetalHeadEngaged") != null && !request.getParameter("foetalHeadEngaged").equals("")){
				foetalHeadEngaged = request.getParameter("foetalHeadEngaged");
			
			}
			
			
			String oedema = "";
			if(request.getParameter("oedema") != null && !request.getParameter("oedema").equals("")){
				oedema = request.getParameter("oedema");
			
			}
			
			
			String alb = "";
			if(request.getParameter("alb") != null && !request.getParameter("alb").equals("")){
				alb = request.getParameter("alb");
		
			}
			
			
			String sugar = "";
			if(request.getParameter("sugar") != null && !request.getParameter("sugar").equals("")){
				sugar = request.getParameter("sugar");
			
			}
			
			String hb = "";
			if(request.getParameter("hb") != null && !request.getParameter("hb").equals("")){
				hb = request.getParameter("hb");
		
			}
			
			String complaint = "";
			if(request.getParameter("complaint") != null && !request.getParameter("complaint").equals("")){
				complaint = request.getParameter("complaint");
				
			}
			
			String remarks = "";
			if(request.getParameter("remarks") != null && !request.getParameter("remarks").equals("")){
				remarks = request.getParameter("remarks");
				
			}
			String pollor = "";
			if(request.getParameter("pollor") != null && !request.getParameter("pollor").equals("")){
				pollor = request.getParameter("pollor");
			
			}
		
		
			if(request.getParameter("procedureHeaderId")!=null && !request.getParameter("procedureHeaderId").equals("0")){
				mapForDS.put("procedureHeaderId", Integer.parseInt(request.getParameter("procedureHeaderId")));
			}
			if(request.getParameter("physioRequisitionHeaderId")!=null && !request.getParameter("physioRequisitionHeaderId").equals("0")){
				mapForDS.put("physioRequisitionHeaderId", Integer.parseInt(request.getParameter("physioRequisitionHeaderId")));
			}
		
			mapForDS.put("box", box);
		
		mapForDS.put("pog",pog);
		mapForDS.put("pollor",pollor);
		mapForDS.put("remarks",remarks);
		mapForDS.put("complaint",complaint);
		mapForDS.put("hb",hb);
		mapForDS.put("sugar",sugar);
		mapForDS.put("alb",alb);
		mapForDS.put("oedema",oedema);
		mapForDS.put("foetalHeadEngaged",foetalHeadEngaged);
		mapForDS.put("foetalHeart",foetalHeart);
		mapForDS.put("pp",pp);
		mapForDS.put("dateNextVisit",dateNextVisit);
		mapForDS.put("dateAnc",dateAnc);
		mapForDS.put("dateOfLastME",dateAnc);
		mapForDS.put("bp",bp);
		mapForDS.put("weight",weight);
		mapForDS.put("fundal",fundal);
		
		mapForDS.put("chargeCodeIdList", chargeCodeIdList);
		mapForDS.put("referToMhList", referToMhList);
		mapForDS.put("pvmsNoList", pvmsNoList);
		mapForDS.put("frequencyList", frequencyList);
		mapForDS.put("ctList", ctList);
		mapForDS.put("dosageList", dosageList);
		mapForDS.put("remarksList", remarksList);
		mapForDS.put("routeList", routeList);
		mapForDS.put("otherMedicineList", otherMedicineList);
		mapForDS.put("totalList", totalList);
		mapForDS.put("noOfDaysList", noOfDaysList);
		mapForDS.put("box", box);
		mapForDS.put("userId", userId);
		mapForDS.put("userName", userName);
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("deptId", deptId);
		mapForDS.put("empId", user.getEmployee().getId());
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean bool = false;
		returnMap = fwcHandlerService.submitAntenatalCardFollowUp(box,mapForDS);
		if (returnMap.get("succesfullyAdded") != null) {
			bool = (Boolean) returnMap.get("succesfullyAdded");
		}
		if (returnMap.get("orderSeqNo") != null) {
			orderSeqNo = (String) returnMap.get("orderSeqNo");
		}

		String message = null;
		
		if (bool) {
			if (flag.equals("fp")) {
				
				map = fwcHandlerService.getWaitingPatientList(mapForDS);
				message = "Patient Details Submitted.";
				jsp = "fwc_messgae";
				submitData = true;
			}
		} else {
			map = fwcHandlerService.getWaitingPatientList(mapForDS);
			message = "Error Occurred in Submitting Details.";
			jsp = FWC_WAITING_LIST_JSP;
		}
		jsp += ".jsp";
		if(request.getParameter("unitId")!=null && !(request.getParameter("unitId").equals(""))){
			map.put("unitId", Integer.parseInt(request.getParameter("unitId")));
		}
		map.put("message", message);
		map.put("submitData", submitData);
		map.put("deptId", deptId);
		map.put("visitNoForReport", box.getInt(VISIT_NUMBER));
		map.put("orderNoForReport", orderSeqNo);
		map.put("serviceNoForReport", box.getString(SERVICE_NO));
		map.put("visitId", box.getInt("visitId"));
		map.put("hinNoForReport", box.getString(HIN_NO));
		map.put("flag", flag);
		title = "Patient Details";
		//map.put("empId", empId);
		//map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showFpReportJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int visitNo = 0;
		String serviceNo = "";
		String hinNo = "";
		int visitId = 0;
		if (request.getParameter(SERVICE_NO_FOR_REPORT) != null) {
			serviceNo = request.getParameter(SERVICE_NO_FOR_REPORT);
		}
		if (request.getParameter(VISIT_NUMBER_FOR_REPORT) != null) {
			visitNo = Integer.parseInt(request
					.getParameter(VISIT_NUMBER_FOR_REPORT));
		}
		if (request.getParameter(HIN_NO_FOR_REPORT) != null) {
			hinNo = request.getParameter(HIN_NO_FOR_REPORT);
		}
		if(request.getParameter(VISIT_ID)!= null){
			visitId = Integer.parseInt(request.getParameter(VISIT_ID));
		}
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = opdHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		parameters.put("hospitalId", hospitalId);
		parameters.put("visitId", visitId);
		parameters.put("visitNo", visitNo);
		parameters.put("serviceNo", serviceNo);
		parameters.put("hinNo", hinNo);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("Fwc_ANC_FOLLOW_UP"), parameters,
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
		return null;
	}
	public void displayVaccine(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<MasImmunization> immunizationList = new ArrayList<MasImmunization>();
		String vaccineAge = "";
		int vaccineId = 0;
		if(request.getParameter("vaccineAge") != null){
			vaccineAge = request.getParameter("vaccineAge");
		}
		dataMap.put("vaccineAge",vaccineAge);
		map = fwcHandlerService.displayVaccine(dataMap);
		if(map.get("immunizationList") != null){
			immunizationList=(List<MasImmunization>)map.get("immunizationList");
		}
		String vaccine = "";
		StringBuffer sb = new StringBuffer();
		if(immunizationList.size()>0){
			sb.append("<item>");
			sb.append("<vacs>");
			for(MasImmunization masImmunization : immunizationList){
				vaccine = (String)masImmunization.getImmunizationName();
				vaccineId = (Integer)masImmunization.getId();
				sb.append("<vac>");		
				sb.append("<vaccineId>" +vaccineId + "</vaccineId>");
				sb.append("<vaccine>" +vaccine + "</vaccine>");
			sb.append("</vac>");
			}
			sb.append("</vacs>");
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
		
	}
	public void displayGrowthChartValue(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Object[]> growthChartList = new ArrayList<Object[]>();
		int genderId =0;
		String growthChartAge = "";
		if(request.getParameter("growthChartAge") != null){
			growthChartAge = request.getParameter("growthChartAge");
		}
		if(request.getParameter("genderId") != null){
			genderId =Integer.parseInt(request.getParameter("genderId"));
		}
		dataMap.put("growthChartAge",growthChartAge);
		dataMap.put("genderId",genderId);
		map = fwcHandlerService.displayGrowthChartValue(dataMap);
		if(map.get("growthChartList") != null){
			growthChartList=(List<Object[]>)map.get("growthChartList");
		}
		String expectedWeight ="";
		String expectedHeight = "";
		String expectedBmi = "";
		if(growthChartList.size()>0){
		for(Object[] obj: growthChartList){
			expectedWeight =(String)obj[0];
			expectedHeight =(String)obj[1];
			expectedBmi =(String)obj[2];
		  }
		 }
		
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<expectedWeight>" +expectedWeight + "</expectedWeight>");
		sb.append("<expectedHeight>" +expectedHeight + "</expectedHeight>");
		sb.append("<expectedBmi>" +expectedBmi + "</expectedBmi>");
	    sb.append("</item>");


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
	  }
	
	
	public ModelAndView printImmunisation(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int visitId = 0;
		if (request.getParameter("visitId") != null) {
			visitId =Integer.parseInt(request.getParameter("visitId"));
		}
		int hinId = 0;
		if (request.getParameter("hinId") != null) {
			hinId =Integer.parseInt(request.getParameter("hinId"));
		}
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = fwcHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("hospitalId", hospitalId);
		parameters.put("visitId", visitId);
		parameters.put("hinId", hinId);
		
		HMSUtil.generateReport("Fwc_Immunisation", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	
		return null;
	}
	
	public ModelAndView showImmunisationReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "fwc_ImmunisationReportJsp.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	
	public void immunisationReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		String qry = "";
		if(request.getParameter(SERVICE_NO)!=null && !request.getParameter(SERVICE_NO).equals("")){
			qry += " and p.service_no='"+request.getParameter(SERVICE_NO)+"'";
		}
		if(request.getParameter(HIN_NO)!=null && !request.getParameter(HIN_NO).equals("")){
			qry += " and p.hin_no='"+request.getParameter(HIN_NO)+"'";
		}
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = fwcHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		parameters.put("hospitalId", hospitalId);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);
		
		HMSUtil.generateReport("immunisationReport", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	}


	public ModelAndView displayFileUploadInvestigation(HttpServletRequest request,HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int invest_id = 0;
		int hinId = 0;
		String hinNo="";

		int visitId=0;
	
		
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
		
		dataMap.put("hinId", hinId);
		dataMap.put("visitId", visitId);
		
		map=fwcHandlerService.displayFileUploadData(dataMap);
		String jsp = "fwc_uploadInvestdoc";
	

		
		map.put("hinId", hinId);
		map.put("hinNo", hinNo);
		map.put("visitId", visitId);
		map.put("invest_id", invest_id);
	
		return new ModelAndView(jsp, "map", map);
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
		map=fwcHandlerService.submitUploadDocumentsInvestForMedicalExam(dataMap);
		
	
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
		map=fwcHandlerService.displayFileUploadData(dataMap12);
		map.put("message", message);
		map.put("visitId", visitId);
		map.put("hinNo", hin_no);
		map.put("hinId", hinId);
		map.put("invest_id", investId);
		String jsp = "fwc_uploadInvestdoc";
		
		
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
     
		
	
           map=fwcHandlerService.getUploadDocumentInvestigationDetails(dataMap);
			String jsp = "fwcViewDocumentInvestigation";
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
        int hospitalId=0;
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
	   dataMap.put("hospitalId", hospitalId);	
	   map =fwcHandlerService.getUploadDocumentMedicalExamInvestigationData(dataMap);
	  
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
	public ModelAndView printpediatricCardTest(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int visitId = 0;
		if (request.getParameter("visitId") != null) {
			visitId =Integer.parseInt(request.getParameter("visitId"));
			requestParameters.put("visitId", visitId);
		}
		int hinId = 0;
		if (request.getParameter("hinId") != null) {
			hinId =Integer.parseInt(request.getParameter("hinId"));
			requestParameters.put("hinId", hinId);
			
		}
		String chieldGender = "";
		if (request.getParameter("chieldGender") != null) {
			chieldGender =request.getParameter("chieldGender");
		}
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = opdHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		if(chieldGender.equals("Female")){
			//detailsMap = fwcHandlerService.printHealthCard(requestParameters);
			//detailsMap = fwcHandlerService.printHealthCardHeight(requestParameters);
			//detailsMap = fwcHandlerService.printHealthCardHeadCircumference(requestParameters);
			parameters.put("hospitalId", hospitalId);
			parameters.put("visitId", visitId);
			parameters.put("hinId", hinId);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			
		HMSUtil.generateReport("Fwc_WellBabyFemale", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		}else{
			
			//detailsMap = fwcHandlerService.printHealthCardB(requestParameters);
			//detailsMap = fwcHandlerService.printHealthCardHeightB(requestParameters);
			//detailsMap = fwcHandlerService.printHealthCardHeadCircumferenceB(requestParameters);
			parameters.put("hospitalId", hospitalId);
			parameters.put("visitId", visitId);
			parameters.put("hinId", hinId);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			
			HMSUtil.generateReport("Fwc_WellBabyMale", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		}
		return null;
	}
	
	//-------------------- By Mansi on 30 April 2013
	
	public ModelAndView showRegForIUD(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> visitMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int deptId = (Integer) session.getAttribute("deptId");
		
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		map = fwcHandlerService.showRegForIUD(box);
		String jsp = "fwcVisitEntryDirect";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("deptId", deptId);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getPatientDetailsFordirectVisitEntry(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String serviceNo = box.getString("serviceNo");
		map = fwcHandlerService.getPatientDetailsFordirectVisitEntry(serviceNo);
		
		String jsp = "fwc_responseForFwcHinNo";
		//String jsp = "responseForDirectVisitEntry";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getPatientData(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hinId = 0;
		 hinId = box.getInt("hinId");
		box.put("hinId", hinId);
		map = fwcHandlerService.getPatientDetails(box);
		String jsp = "fwc_responseForDirectVisitEntry";
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView saveRegisterForIUD(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		Users user = (Users)session.getAttribute("users");
		box.put("userId", user.getId());
		int physioRequisitionHeaderId = 0;
		String jsp = "";
		int hinId = 0;
		if(box.getInt("hinId") != 0){
			hinId = box.getInt("hinId");
		}
		box.put("hinId", hinId);
		
		map = fwcHandlerService.saveRegisterForIUD(box);
		boolean saved = false;
		boolean appointmentFlag = false;
		if(map.get("saved")!=null){
			saved = (Boolean)map.get("saved");
		}
		if(map.get("appointmentFlag")!=null){
			appointmentFlag = (Boolean)map.get("appointmentFlag");
		}
		
		String message="";
		if(saved){
			
			message = "Record Saved Successfully.!";
			
		}else{
			message = "Some Problem Occurred";
		}
		
		 jsp = "fwc_regMessage";
		map.put("message", message);
		
		map.put("hinId", hinId);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showRegisterForIUDReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session= request.getSession();
		
		int hospitalId = 0;
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		map = fwcHandlerService.showRegisterForIUDReportJsp(hospitalId);
		String jsp = "RegisterForIUDReport.jsp";
	
		map.put("contentJsp", jsp);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index","map",map);
	}
	public void printRegisterForIUDReportJsp(HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		String qry = "";
		
		if(request.getParameter(UNIT_ID)!=null && !request.getParameter(UNIT_ID).equals("0")){
			qry += " and p.unit_id="+Integer.parseInt(request.getParameter(UNIT_ID));
		}
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = fwcHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("0")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		parameters.put("hospitalId", hospitalId);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("qry", qry);
		
		HMSUtil.generateReport("RegisterForIUDReportJsp", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	}
	public ModelAndView showAntentatalCardFollowUpJsp(HttpServletRequest request,HttpServletResponse response) {
		MultipartFormDataRequest mrequest = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		 int visitId = 0;
		 if(request.getParameter("visitId") != null){
			 visitId = Integer.parseInt(request.getParameter("visitId"));
			 dataMap.put("visitId", visitId);
		 }
		 int hinId = 0;
		 if(request.getParameter("hinId") != null){
			 hinId = Integer.parseInt(request.getParameter("hinId"));
			 dataMap.put("hinId", hinId);
		 }
		 int deptId = (Integer) session.getAttribute("deptId");
		 dataMap.put("deptId", deptId);
		map = fwcHandlerService.showAntentatalCardFollowUpJsp(dataMap);
		
		jsp = "CardFollowUpJsp";
		return new ModelAndView(jsp, "map", map);

	}
	
	public ModelAndView showDeliveryDetails(HttpServletRequest request,HttpServletResponse response) {
		MultipartFormDataRequest mrequest = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		 int visitId = 0;
		 if(request.getParameter("visitId") != null){
			 visitId = Integer.parseInt(request.getParameter("visitId"));
			 dataMap.put("visitId", visitId);
		 }
		 int hinId = 0;
		 if(request.getParameter("hinId") != null){
			 hinId = Integer.parseInt(request.getParameter("hinId"));
			 dataMap.put("hinId", hinId);
		 }
		 int deptId = (Integer) session.getAttribute("deptId");
		 dataMap.put("deptId", deptId);
		map = fwcHandlerService.showDeliveryDetails(dataMap);
		
		jsp = "deliveryDetailsJsp";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView submitDeliveryDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		List<String> dateDeliveryList  = new ArrayList<String>();
		List<String> timeDeliveryList  = new ArrayList<String>();
		List<String> placeDeliveryList  = new ArrayList<String>();
		List<String> typeDeliveryList  = new ArrayList<String>();
		List<Integer> slNoList  = new ArrayList<Integer>();
		List<Integer> visitList  = new ArrayList<Integer>();
		List<Integer> hinList  = new ArrayList<Integer>();
		List<Integer> hospitalList  = new ArrayList<Integer>();
		int visitId=0;
		int hospitalId  = 0;
		int userId = 0;
		int deptId = 0;
		boolean submitData = false;
		/*String flag = "";
		if (!request.getParameter("flag").equals("")) {
			flag = request.getParameter("flag");
			mapForDS.put("flag", flag);
		}*/
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
			mapForDS.put("hospitalId", hospitalId);
		}
		if(session.getAttribute("deptId") != null){
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
			mapForDS.put("deptId", deptId);
		}
	
		 if(request.getParameter("visitId") != null){
			 visitId = Integer.parseInt(request.getParameter("visitId"));
			 map.put("visitId", visitId);
		 }
		Users user = new Users();
		if(session.getAttribute("users")!=null){
			user = (Users)session.getAttribute("users");
			box.put("userId", user.getId());
			box.put("empId", user.getEmployee().getId());
			mapForDS.put("userId", userId);
			mapForDS.put("empId", user.getEmployee().getId());
		}
		String userName = "";
		if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
		box.put("userName", userName);
		}
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			box.put("deptId", deptId);
		} else {
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
		}
		
		String orderSeqNo = opdHandlerService.generateOrderNumber(hospitalId);
		box.put("orderSeqNo", orderSeqNo);
		int hiddenValue = 1;
		if (Integer.parseInt(request.getParameter("hiddenValue")) != 1) {
			hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
		}
		
	int j = 1;
	for (int i = 1; i <= hiddenValue; i++) {

	

		String time = "";
		if(request.getParameter("time" + j) != null && !request.getParameter("time" + j).equals("")){
			time = request.getParameter("time" + j);
			timeDeliveryList.add(time);
		}	else {
			timeDeliveryList.add("");
		}
		
		if(request.getParameter("givenOn"+j)!=null){
			dateDeliveryList.add(request.getParameter("givenOn"+j));
		}
		
		String place = "";
		if(request.getParameter("place" + j) != null && !request.getParameter("place" + j).equals("")){
			place = request.getParameter("place" + j);
			placeDeliveryList.add(place);
		}else{
			placeDeliveryList.add("");
		}
		
		if(request.getParameter("slNo" + j) != null && !request.getParameter("slNo" + j).equals("")){
			int slNo = Integer.parseInt(request.getParameter("slNo"+ j));
			slNoList.add(slNo);
							
		}else {
			slNoList.add(0);
		}
	
		String typeDelivery = "";
		if(request.getParameter("typeDelivery" + j) != null && !request.getParameter("typeDelivery" + j).equals("")){
			typeDelivery = request.getParameter("typeDelivery" + j);
			typeDeliveryList.add(typeDelivery);
		}else {
			typeDeliveryList.add("");
		}
	
	

		j++;
	}
	mapForDS.put("dateDeliveryList", dateDeliveryList);
	mapForDS.put("typeDeliveryList", typeDeliveryList);
	mapForDS.put("slNoList", slNoList);
	mapForDS.put("placeDeliveryList", placeDeliveryList);
	mapForDS.put("timeDeliveryList", timeDeliveryList);
	mapForDS.put("box", box);
	mapForDS.put("userId", userId);
	mapForDS.put("userName", userName);
	mapForDS.put("hospitalId", hospitalId);
	mapForDS.put("deptId", deptId);
	mapForDS.put("empId", user.getEmployee().getId());
		boolean bool = false;
		map = fwcHandlerService.submitDeliveryDetails(box,mapForDS);
		String message = null;
		if (map.get("succesfullyAdded") != null) {
			bool = (Boolean) map.get("succesfullyAdded");
		}
		if (bool) {
			
				message = "Patient Details Submitted.Do you want to print?";
				map.put("message", message);
			//}
		} else {
		
			message = "Error Occurred in Submitting Details.";
			map.put("message", message);
		}
		jsp = "fwc_deliveryMessage";
		jsp += ".jsp";
		title = "Patient Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
	//	map.put("visitId", box.getInt("visitId"));
		//map.put("visitId", visitId);
		map.put("deptId", box.getInt("deptId"));
		return new ModelAndView("indexB", "map", map);
	}
	
	public ModelAndView printDeliveryDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int visitId = 0;
		if (request.getParameter("visitId") != null) {
			visitId =Integer.parseInt(request.getParameter("visitId"));
			requestParameters.put("visitId", visitId);
		}

	
	
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = opdHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
			
		
			parameters.put("hospitalId", hospitalId);
			parameters.put("visitId", visitId);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
			
			HMSUtil.generateReport("Fwc_deliveryDetails", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
	
		return null;
	}
	

	
}



