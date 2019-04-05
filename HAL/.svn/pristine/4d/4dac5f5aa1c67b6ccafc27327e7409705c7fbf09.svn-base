package jkt.hms.mediClaim.controller;

import static jkt.hms.util.RequestConstants.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MdBillMovement;
import jkt.hms.masters.business.MdCardicClaimAdvance;
import jkt.hms.masters.business.MdCardicContingentBillHd;
import jkt.hms.masters.business.MdContigentMedicalBillHd;
import jkt.hms.masters.business.MdMasAuthority;
import jkt.hms.masters.business.MdSpecialInvestigationHd;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.mediClaim.handler.MedicalClaimHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MedicalClaimController extends MultiActionController {
   MedicalClaimHandlerService medicalClaimHandlerService;
   CommonMasterHandlerService commonMasterHandlerService;
   /**
    * ------- common variables declaration------
    */
   Map<String, Object> map = new HashMap<String, Object>();
   Map<String, Object> generalMap = new HashMap<String, Object>();
   String code = "";
   String name = "";
   String currentDate = "";
   String currentTime = "";
   String jspName = "";
   String jsp = "";
   String title = "";
   String message = " ";
   String url = "";
   String viewPage = "";
   String pojoPropertyName = "";
   String pojoPropertyCode = "";
   String pojoName = "";
   String userName = "";
   String status = "";
   int id = 0;
   HttpSession session = null;

   // -------------------------Sanction Authority Master-------------------
   @SuppressWarnings("unchecked")
	public ModelAndView showAuthorityJsp(HttpServletRequest request,
			HttpServletResponse response) {
      Map<String, Object> map = new HashMap<String, Object>();
      session = request.getSession();
      map = medicalClaimHandlerService.showAuthorityJsp();
      jsp = MD_AUTHORITY_JSP;
      jsp += ".jsp";
      map.put("contentJsp", jsp);
      map.put("title", title);
      return new ModelAndView("indexB", "map", map);

   }

	public ModelAndView searchAuthority(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
      Map<String, Object> map = new HashMap<String, Object>();
      String authorityCode = null;
      String authorityName = null;
      String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
         authorityCode = request.getParameter(CODE);
      }
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
         authorityName = request.getParameter(SEARCH_NAME);
      }
      int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			authorityCode = searchField;
			authorityName = null;
		} else {
			authorityCode = null;
			authorityName = searchField;
		}
		map = medicalClaimHandlerService.searchAuthority(authorityCode,
				authorityName);

		jsp = MD_AUTHORITY_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("authorityCode", authorityCode);
		map.put("authorityName", authorityName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAuthority(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MdMasAuthority masAuthority = new MdMasAuthority();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String changedBy = "";

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
      generalMap.put("code", code);
      generalMap.put("name", name);

      generalMap.put("currentDate", currentDate);
      generalMap.put("currentTime", currentTime);

      generalMap.put("pojoPropertyName", pojoPropertyName);
      generalMap.put("pojoPropertyCode", pojoPropertyCode);
      generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List authorityCodeList = new ArrayList();
		List authorityNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			authorityCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			authorityNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((authorityCodeList.size() == 0 || authorityCodeList == null)
				&& (authorityNameList.size() == 0 || authorityNameList == null)) {
			masAuthority.setAuthorityCode(code);
			masAuthority.setAuthorityName(name);
			masAuthority.setStatus("y");
			masAuthority.setLastChgBy(changedBy);
			masAuthority.setLastChgDate(currentDate);
			masAuthority.setLastChgTime(currentTime);
			successfullyAdded = medicalClaimHandlerService
					.addAuthority(masAuthority);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((authorityCodeList.size() != 0 || authorityCodeList != null)
				|| (authorityNameList.size() != 0) || authorityNameList != null) {
			if ((authorityCodeList.size() != 0 || authorityCodeList != null)
					&& (authorityNameList.size() == 0 || authorityNameList == null)) {
				message = "Authority Code  already exists.";
			} else if ((authorityNameList.size() != 0 || authorityNameList != null)
					&& (authorityCodeList.size() == 0 || authorityCodeList == null)) {
				message = "Authority Name already exists.";
			} else if ((authorityCodeList.size() != 0 || authorityCodeList != null)
					&& (authorityNameList.size() != 0 || authorityNameList != null)) {
				message = "Authority Code and Authority Name already exist.";
			}
		}

		url = "/hms/hms/mediClaim?method=showAuthorityJsp";
		try {
			map = medicalClaimHandlerService.showAuthorityJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MD_AUTHORITY_JSP;
		title = "Add Authority";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editAuthority(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String authorityCode = "";
		String authorityName = "";
		int authorityId = 0;
		String changedBy = "";
		Date changedDate = null;
		Date currentDate = null;
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			authorityId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			authorityCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			authorityName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

      generalMap.put("id", authorityId);
      generalMap.put("authorityCode", authorityCode);
      generalMap.put("name", authorityName);
      generalMap.put("changedBy", changedBy);
      generalMap.put("currentDate", changedDate);
      generalMap.put("currentTime", changedTime);
      Map<String, Object> listMap = new HashMap<String, Object>();
      generalMap.put("pojoPropertyName", pojoPropertyName);
      generalMap.put("pojoName", pojoName);
      generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingAuthoritytyNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingAuthoritytyNameList.size() == 0) {

			dataUpdated = medicalClaimHandlerService.editAuthority(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingAuthoritytyNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/mediClaim?method=showAuthoritytyJsp";
		try {
			map = medicalClaimHandlerService.showAuthorityJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MD_AUTHORITY_JSP;
		title = "Update Authority";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteAuthority(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int authorityId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			authorityId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = medicalClaimHandlerService.deleteAuthority(authorityId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/mediClaim?method=showAuthoritytyJsp";
		try {
			map = medicalClaimHandlerService.showAuthorityJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
      jsp = MD_AUTHORITY_JSP;
      title = "Delete Authority";
      jsp += ".jsp";
      map.put("contentJsp", jsp);
      map.put("title", title);
      map.put("message", message);
      return new ModelAndView("indexB", "map", map);
   }

   // -----------Special Investigation------------------------------
   // Method for Showing search Screen of Special Investigation
	public ModelAndView showPatientSearchForSpecialinvestigationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalClaimHandlerService
				.showPatientSearchForSpecialinvestigationJsp();
		jsp = MD_SEARCH_SPECIAL_INV + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// Method for search Patient for Special Investigation
	@SuppressWarnings("unchecked")
	public ModelAndView showPatientDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		String serviceNo = "";
		String hinNo = "";
		int rankId = 0;
		String patientFName = "";
		String patientLName = "";
		String patientStatus = "";
		int hinId = 0;
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (request.getParameter(PATIENT_STATUS) != null
				&& !(request.getParameter(PATIENT_STATUS).equals(""))) {
			patientStatus = request.getParameter(PATIENT_STATUS);
			mapForDs.put("patientStatus", patientStatus);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			mapForDs.put("rankId", rankId);
		}
		if (request.getParameter(P_FIRST_NAME) != null
				&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
			patientFName = request.getParameter(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (request.getParameter(P_LAST_NAME) != null
				&& !(request.getParameter(P_LAST_NAME).equals(""))) {
			patientLName = request.getParameter(P_LAST_NAME);
			mapForDs.put("patientLName", patientLName);
		}
		if (request.getParameter("hinId") != null
				&& !request.getParameter("hinId").equals("0")) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
			detailsMap = medicalClaimHandlerService
					.getPatientforInvestigationDetails(hinId);

			patientList = (List) detailsMap.get("patientList");
			hospitalList = (List) detailsMap.get("hospitalList");
			String yearlySeqNo = "";
			yearlySeqNo = medicalClaimHandlerService
					.getyearlySeqForDisplay("YRN");
			map = medicalClaimHandlerService
					.showPatientSearchForSpecialinvestigationJsp();

			if (yearlySeqNo != null) {
				map.put("yearlySeqNo", yearlySeqNo);
			}
			jsp = MD_SPECIAL_INVESTIGATION + ".jsp";
			map.put("hospitalList", hospitalList);

		} else {
			patientMap = medicalClaimHandlerService.getPatientDetails(mapForDs);
			map = medicalClaimHandlerService
					.showPatientSearchForSpecialinvestigationJsp();
			jsp = MD_SEARCH_SPECIAL_INV + ".jsp";
		}
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		map.put("patientList", patientList);

		return new ModelAndView("indexB", "map", map);
	}

	// -----For Getting Charge Name for autocomplete------
	public ModelAndView getChargeName(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String nameField = "";
		String autoHint = "";
		Box box = HMSUtil.getBox(request);
		if (request.getParameter("requiredField") != null) {
			nameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(nameField) != null) {
			autoHint = (request.getParameter(nameField));
		}
		parameterMap.put("autoHint", autoHint);
		//parameterMap.put("testType", box.getString("testType"));

		map = medicalClaimHandlerService.getChargeName(parameterMap);
		String jsp = "";
		jsp = "responseForChargeCodeGrid";
		return new ModelAndView(jsp, "map", map);
	}

   // -----------Filling items for selected Charge name------
	public void fillItemsForChargeName(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String chargeName = "";
		List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
		try {
			if (request.getParameter("chargeName") != null) {
				chargeName = request.getParameter("chargeName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("chargeName", chargeName);

		map = medicalClaimHandlerService.fillItemsForChargeName(dataMap);
		if (map.get("chargeList") != null) {
			chargeList = (List) map.get("chargeList");
		}
		StringBuffer sb = new StringBuffer();

		sb.append("<items>");
		for (MasChargeCode masChargeCode : chargeList) {
			sb.append("<item>");
			sb.append("<chargeId>" + masChargeCode.getId() + "</chargeId>");
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

   // --------For getting Diagnosis in autocomplete-------------------
	public ModelAndView getDiagnosis(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String nameField = "";
		String autoHint = "";

		if (request.getParameter("requiredField") != null) {
			nameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(nameField) != null) {
			autoHint = (request.getParameter(nameField));
		}
		parameterMap.put("autoHint", autoHint);

		map = medicalClaimHandlerService.getDiagnosis(parameterMap);
		String jsp = "";
		jsp = "md_responseForIcdDiagnosis";
		return new ModelAndView(jsp, "map", map);
	}

   // -------------Save data in Special Investigation----
   @SuppressWarnings("unchecked")
	public ModelAndView submitSpecialinvestigation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
      HttpSession session = request.getSession();
      int chargeListLength = 1;

      List chargeList = new ArrayList();
      List specialDetailIdList = new ArrayList();

      String userName = (String) session.getAttribute("userName");
      String date = "";
      String time = "";
      String changedBy = "";
      date = (String) utilMap.get("currentDate");
      time = (String) utilMap.get("currentTime");
      String yearlySeqNo = "";
      int referredTo = 0;
      String refferedTo = "";
      String diagnosis ="" ;
      int hinId = 0;
      int inpatientId = 0;
      int departmentId = (Integer) session.getAttribute("deptId");
      int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

      MdSpecialInvestigationHd specialInvestigationHd = new MdSpecialInvestigationHd();

		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(DIAGNOSIS_ID) != null
				&& !(request.getParameter(DIAGNOSIS_ID).equals(""))) {
			diagnosis = request.getParameter(DIAGNOSIS_ID);
		}
		
		if (request.getParameter("refferedTo") != null) {
		refferedTo =request.getParameter("refferedTo");
	}
		if (request.getParameter(REFERRED_TO) != null
				&& !request.getParameter(REFERRED_TO).equals("0")) {
			referredTo = Integer.parseInt(request.getParameter(REFERRED_TO));
		}
		
		/*if (request.getParameter(REFERRED_TO) != null) {
			refferedTo =request.getParameter(REFERRED_TO);
		}
	*/

		if (request.getParameter(YEARLY_SR_NO) != null) {
			yearlySeqNo = request.getParameter(YEARLY_SR_NO);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		String appointmentTime = "";
		if (request.getParameter(APPOINTMENT_TIME) != null
				&& !(request.getParameter(APPOINTMENT_TIME).equals(""))) {
			appointmentTime = request.getParameter(APPOINTMENT_TIME);
		}
		Date appointmentDate = new Date();
		if (request.getParameter(APPOINTMENT_DATE) != null
				&& !(request.getParameter(APPOINTMENT_DATE).equals(""))) {
			appointmentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(APPOINTMENT_DATE));
		}
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			specialInvestigationHd.setHin(patient);
		}
		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			specialInvestigationHd.setInpatient(inpatient);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			specialInvestigationHd.setHospital(masHospital);
		}

		specialInvestigationHd.setWorkingDiagnosis(diagnosis);

		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			specialInvestigationHd.setDepartment(masDepartment);
		}
		if (referredTo != 0) {
			MasReference masHospital = new MasReference();
			masHospital.setId(referredTo);
			specialInvestigationHd.setReferredTo(masHospital);
		}
		
		// String temp = medicalClaimHandlerService.generateYearlyNumber();
		
		
		specialInvestigationHd.setSuggestTo(refferedTo);
		
		specialInvestigationHd.setYearlyNo(yearlySeqNo);
		specialInvestigationHd.setStatus("p");
		specialInvestigationHd.setSpecialDate(HMSUtil
				.convertStringTypeDateToDateType(date));

      specialInvestigationHd.setAppointmentDate(appointmentDate);
      specialInvestigationHd.setAppointmnetTime(appointmentTime);

      specialInvestigationHd.setLastChgBy(userName);
		specialInvestigationHd.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		specialInvestigationHd.setLastChgTime(time);

		infoMap.put("specialInvestigationHd", specialInvestigationHd);
		if (request.getParameter("hiddenValueCharge") != null) {
			chargeListLength = Integer.parseInt(request
					.getParameter("hiddenValueCharge"));
		}
		int i = 1;
		for (int a = 1; a <= chargeListLength; a++) {
			if (request.getParameter(CHARGE_CODE_ID + i) != null
					&& !request.getParameter(CHARGE_CODE_ID + i).equals("")) {
				chargeList.add(request.getParameter(CHARGE_CODE_ID + i));

			} else {
				chargeList.add("");
			}

			if (request.getParameter(SPECIAL_DETAIL_ID + i) != null) {
				specialDetailIdList.add(request.getParameter(SPECIAL_DETAIL_ID
						+ i));
			} else {
            specialDetailIdList.add("");
         }

         i++;
      }
      infoMap.put("yearlySeqNo", yearlySeqNo);
      infoMap.put("userName", userName);
      infoMap.put("chargeList", chargeList);
      infoMap.put("specialDetailIdList", specialDetailIdList);

      boolean saved = false;
      String message = "";
      String jsp = "";
		infoMap = medicalClaimHandlerService
				.submitSpecialinvestigation(infoMap);

		map = medicalClaimHandlerService
				.showPatientSearchForSpecialinvestigationJsp();
		if (infoMap.get("saved").equals(true)) {
			message = "Special Investigation has been done Successfully !! Do You want to print? ";
			jsp = RequestConstants.MEDICAL_CLAIM_REQUEST_SUBMIT_CONFIRM
					+ ".jsp";
		} else {
			message = "Try Again!";
			jsp = MD_SEARCH_SPECIAL_INV + ".jsp";
		}
		map.put("ID", infoMap.get("Id"));
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("yearlySeqNo", yearlySeqNo);
		return new ModelAndView("indexB", "map", map);
	}

	// ------- Contingent Bill for Reimbursement of Medical Bill Entry-----
	// ------method for show search screen for contingent Bill---------------
	public ModelAndView showPatientSearchForContingentBill(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalClaimHandlerService.showPatientSearchForContingentBill();
		jsp = MD_SEARCH_CONTIGENT_REM_MEDICAL_BILL + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// --search patient for Contingent Bill----
	@SuppressWarnings("unchecked")
	public ModelAndView showPatientDetailsForContingentBill(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int hospitalId = 0;
		session = request.getSession();
		hospitalId = (Integer)session.getAttribute("hospitalId");
		mapForDs.put("hospitalId", hospitalId);
		String serviceNo = "";
		String hinNo = "";
		int rankId = 0;
		String serPersonFName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientLName = "";
		String patientStatus = "";
		int hinId = 0;
		int specInvHdId = 0;
		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
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
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDs.put("patientLName", patientLName);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(S_LAST_NAME) != null
					&& !(request.getParameter(S_LAST_NAME).equals(""))) {
				serPersonLName = request.getParameter(S_LAST_NAME);
				mapForDs.put("serPersonLName", serPersonLName);
			}
			if (request.getParameter(RANK_ID) != null
					&& !(request.getParameter(RANK_ID).equals("0"))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				mapForDs.put("rankId", rankId);
			}
			if (request.getParameter("hinId") != null
					&& !(request.getParameter("hinId").equals("0"))) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter("specInvHdId") != null
					&& !(request.getParameter("specInvHdId").equals("0"))) {
				specInvHdId = Integer.parseInt(request
						.getParameter("specInvHdId"));

				mapForDs.put("specInvHdId", specInvHdId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = medicalClaimHandlerService
				.getPatientDetailsForContingentBill(mapForDs);
		String jsp = "";
      List<MdSpecialInvestigationHd> specialInvHdList = new ArrayList<MdSpecialInvestigationHd>();
    //  List<MdMasAuthority> authorityList = new ArrayList<MdMasAuthority>();
      List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

		if (specInvHdId != 0) {
			detailsMap = medicalClaimHandlerService
					.getPatientForContingentBillDetails(mapForDs);

			specialInvHdList = (List) detailsMap.get("specialInvHdList");
			//authorityList = (List) detailsMap.get("authorityList");
			employeeList = (List) detailsMap.get("employeeList");
			String entrySeqNo = "";
			entrySeqNo = medicalClaimHandlerService
					.getEntrySeqForDisplay("CMEN");
			if (entrySeqNo != null) {
				map.put("entrySeqNo", entrySeqNo);
			}
			
			jsp = MD_CONTIGENT_REM_MEDICAL_BILL + ".jsp";
		} else {
			map = medicalClaimHandlerService
					.showPatientSearchForContingentBill();
			jsp = MD_SEARCH_CONTIGENT_REM_MEDICAL_BILL + ".jsp";
		}
//		map.put("authorityList", authorityList);
		map.put("employeeList", employeeList);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		map.put("specialInvHdList", specialInvHdList);
		return new ModelAndView("indexB", "map", map);
	}

	// ----Save Data in medical contingent Bill----
	@SuppressWarnings("unchecked")
	public ModelAndView submitContingentBill(HttpServletRequest request,
			HttpServletResponse response) {
      Map<String, Object> map = new HashMap<String, Object>();
      Map<String, Object> infoMap = new HashMap<String, Object>();
      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
      HttpSession session = request.getSession();
      int chargeListLength = 0;
      int specialInvId=0;
      List chargeList = new ArrayList();
      List contingentDetailIdList = new ArrayList();
      String diagnosis =""; 
      String userName = (String) session.getAttribute("userName");
      String date = "";
      String time = "";
      String claimType = "";
      String changedBy = "";
      String submissionDate = "";
      submissionDate = (String) utilMap.get("currentDate");
      date = (String) utilMap.get("currentDate");
      time = (String) utilMap.get("currentTime");
      String entrySeqNo = "";
      String billNo = "";
      String payableTo = "";
      String accountOfficer = "";

      BigDecimal amount = null;
      BigDecimal qualifyigAmt = null;
      BigDecimal receivedRs = null;
      int fwtTo = 0;
      int hinId = 0;
      int inpatientId = 0;
      int departmentId = (Integer) session.getAttribute("deptId");
      int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

      MdContigentMedicalBillHd contigentMedicalBillHd = new MdContigentMedicalBillHd();

		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter("specialhdId") != null
				&& !request.getParameter("specialhdId").equals("")) {
			specialInvId = Integer
					.parseInt(request.getParameter("specialhdId"));
		}
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			contigentMedicalBillHd.setHin(patient);
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter("diagnosis") != null
				&& !request.getParameter("diagnosis").equals("0")) {
			diagnosis = request.getParameter("diagnosis");
		}
		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			contigentMedicalBillHd.setInpatient(inpatient);
		}
		contigentMedicalBillHd.setWorkingDiagnosis(diagnosis);
		if (request.getParameter(ENTRY_NO) != null) {
			entrySeqNo = request.getParameter(ENTRY_NO);
		}
		// String temp = medicalClaimHandlerService.generateEntryNumber();
		contigentMedicalBillHd.setEntryNo(entrySeqNo);

		contigentMedicalBillHd.setEntryDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		if (request.getParameter(CLAIM_TYPE) != null
				&& !(request.getParameter(CLAIM_TYPE).equals(""))) {
			claimType = request.getParameter(CLAIM_TYPE);
		}
		contigentMedicalBillHd.setClaimType(claimType);
		if (request.getParameter(BILL_NO) != null
				&& !request.getParameter(BILL_NO).equals("0")) {
			billNo = request.getParameter(BILL_NO);
		}
		contigentMedicalBillHd.setBillNo(billNo);
		contigentMedicalBillHd.setBillDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		if (request.getParameter(AMOUNT) != null) {
			amount = new BigDecimal(request.getParameter(AMOUNT));
		}
		contigentMedicalBillHd.setAmount(amount);
		if (request.getParameter(QUALIFYING_RS) != null) {
			qualifyigAmt = new BigDecimal(request.getParameter(QUALIFYING_RS));
		}
		contigentMedicalBillHd.setQualifyingAmount(qualifyigAmt);
		if (request.getParameter(RECEIVED_RS) != null) {
			receivedRs = new BigDecimal(request.getParameter(RECEIVED_RS));
		}
		contigentMedicalBillHd.setReceivedRs(receivedRs);
		if (request.getParameter(PAYABLE_TO) != null
				&& !request.getParameter(PAYABLE_TO).equals("0")) {
			payableTo = request.getParameter(PAYABLE_TO);
		}
		contigentMedicalBillHd.setPayableTo(payableTo);
		if (request.getParameter(NAME_PAY_OFFICER) != null
				&& !request.getParameter(NAME_PAY_OFFICER).equals("0")) {
			accountOfficer = request.getParameter(NAME_PAY_OFFICER);
		}
		contigentMedicalBillHd.setAccountOfficer(accountOfficer);
		contigentMedicalBillHd.setSubmissionDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		if (request.getParameter(AUTHORITY_ID) != null
				&& !request.getParameter(AUTHORITY_ID).equals("0")) {
			fwtTo = Integer.parseInt(request.getParameter(AUTHORITY_ID));
		}
	/*	MdMasAuthority masAuthority = new MdMasAuthority();
		masAuthority.setId(fwtTo);
		contigentMedicalBillHd.setFwtTo(masAuthority);
*/
		MasEmployee employee = new MasEmployee();
		employee.setId(fwtTo);
		contigentMedicalBillHd.setEmployee(employee);
		
		contigentMedicalBillHd.setReceivedRs(receivedRs);
		if (request.getParameter(PAYABLE_TO) != null
				&& !request.getParameter(PAYABLE_TO).equals("0")) {
			payableTo = request.getParameter(PAYABLE_TO);
		}
		contigentMedicalBillHd.setFwtDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		String hinNo = "";
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			contigentMedicalBillHd.setHospital(masHospital);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			contigentMedicalBillHd.setDepartment(masDepartment);
		}
		contigentMedicalBillHd.setDispatchStatus("P");
		contigentMedicalBillHd.setLastChgBy(userName);
		contigentMedicalBillHd.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		contigentMedicalBillHd.setLastChgTime(time);
		if (request.getParameter("cghsCode") != null) {
			contigentMedicalBillHd.setCghsCode(request.getParameter("cghsCode"));
		}
		if (request.getParameter("cghsRate") != null && !request.getParameter("cghsRate").equals("")) {
			contigentMedicalBillHd.setCghsRate(new BigDecimal(request.getParameter("cghsRate")));
		}
		infoMap.put("contigentMedicalBillHd", contigentMedicalBillHd);
		if (request.getParameter("hiddenValueCharge") != null) {
			chargeListLength = Integer.parseInt(request
					.getParameter("hiddenValueCharge"));
		}
		int i = 1;
		for (int a = 1; a <= chargeListLength; a++) {
			if (request.getParameter(CHARGE_CODE_ID + i) != null
					&& !request.getParameter(CHARGE_CODE_ID + i).equals("")) {
				chargeList.add(request.getParameter(CHARGE_CODE_ID + i));

			} else {
				chargeList.add("");
			}

			if (request.getParameter(CONTINGENT_BILL_DETAIL_ID + i) != null) {
				contingentDetailIdList.add(request
						.getParameter(CONTINGENT_BILL_DETAIL_ID + i));
			} else {
				contingentDetailIdList.add("");
			}

			i++;
		}

      infoMap.put("entrySeqNo", entrySeqNo);
      infoMap.put("userName", userName);
      infoMap.put("chargeList", chargeList);
      infoMap.put("contingentDetailIdList", contingentDetailIdList);
      infoMap.put("specialInvId", specialInvId);
      boolean saved = false;
      String message = "";
      infoMap = medicalClaimHandlerService.submitContingentBill(infoMap);
      map = medicalClaimHandlerService.showPatientSearchForContingentBill();
      String jsp ="";
		if (infoMap.get("saved")!=null && infoMap.get("saved").equals(true)) {
			message = "Data Saved Successfully !! Please select the report which you want to print. ";
			jsp = "md_contingentBillReembersementMsg" + ".jsp";
		} else {
			message = "Error Occured !! Try Again!";
			jsp = MD_SEARCH_CONTIGENT_REM_MEDICAL_BILL + ".jsp";
		}
		map.put("contigentMedicalBill_Id", infoMap
				.get("contigentMedicalBill_Id"));
		map.put("specialInvId", specialInvId);
		map.put("entrySeqNo", entrySeqNo);
		map.put("hinNo", hinNo);
		map.put("message", message);
		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	// ------------------for getting Unit name in Autocomplete----------------
	public ModelAndView getUnitName(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String nameField = "";
		String autoHint = "";
		if (request.getParameter("requiredField") != null) {
			nameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(nameField) != null) {
			autoHint = (request.getParameter(nameField));
		}
		parameterMap.put("autoHint", autoHint);

		map = medicalClaimHandlerService.getUnitName(parameterMap);
		String jsp = "";
		jsp = "md_responseForUnitName";
		return new ModelAndView(jsp, "map", map);
	}

	// ------------Show Covering Letter Unit---
	public ModelAndView showPatientForCoveringLetterUnit(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		map = medicalClaimHandlerService
				.showPatientForCoveringLetterUnit(dataMap);
		String entrySeqNo = request.getParameter("entrySeqNo");
		entrySeqNo = medicalClaimHandlerService
				.getCoveringEntrySeqForDisplay("CLEN");
		if (entrySeqNo != null) {
			map.put("entrySeqNo", entrySeqNo);
		}
		jsp = MD_COVERING_LETTER + ".jsp";
		map.put("hospitalId", hospitalId);
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public void fillItemsForUnitName(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String unitName = "";
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		try {
			if (request.getParameter("unitName") != null) {
				unitName = request.getParameter("unitName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("unitName", unitName);

		map = medicalClaimHandlerService.fillItemsForUnitName(dataMap);
		if (map.get("unitList") != null) {
			unitList = (List) map.get("unitList");
		}
		StringBuffer sb = new StringBuffer();

		sb.append("<items>");
		for (MasUnit masUnit : unitList) {
			sb.append("<item>");
			sb.append("<unitId>" + masUnit.getId() + "</unitId>");
			sb.append("<unitAddress>" + masUnit.getUnitAddress()
					+ "</unitAddress>");
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

	// -Save data in covering letter unit---
	public ModelAndView submitCoveringletter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		int noOfRecords = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		if (request.getParameter("counter") != null
				&& !request.getParameter("counter").equals("")) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		int hinId = box.getInt(HIN_ID);
		int contingentHdId = 0;
		contingentHdId = Integer.parseInt(request
				.getParameter(CONTINGENT_BILL_HD_ID));
		List<MdContigentMedicalBillHd> patientList = new ArrayList<MdContigentMedicalBillHd>();

		parameterMap.put("box", box);
		map = medicalClaimHandlerService.submitCoveringletter(parameterMap);
		saved = (Boolean) map.get("saved");
		String message = "";
		if (saved) {
			message = "Data Saved Successfully !!";
		} else {
			message = "Try Again ..";
		}

		String jsp = MD_MSG_COVERING_LETTER + ".jsp";

		map.put("contingentHdId", contingentHdId);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// -----------------Show--General Covering Letter----------------
	public ModelAndView showGeneralClaimCoveringLetter(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute("hospitalId");

		map = medicalClaimHandlerService
				.showGeneralClaimCoveringLetter(dataMap);

		String entrySeqNo = request.getParameter("entrySeqNo");
		entrySeqNo = medicalClaimHandlerService
				.getGenCoverEntryNoDisplay("GCEN");
		if (entrySeqNo != null) {
			map.put("entrySeqNo", entrySeqNo);
		}
		jsp = MD_GENERAL_COVERING_LETTER + ".jsp";
		map.put("hospitalId", hospitalId);
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// -Save data in General Covering Letter---
	public ModelAndView submitGeneralCoveringletter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		boolean saved = false;
		int hospitalId = 0;
		int deptId = 0;
		String userName = "";
		int noOfRecords = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			parameterMap.put("deptId", deptId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		String entrySeqNo = "";
		if (request.getParameter(ENTRY_NO) != null) {
			entrySeqNo = request.getParameter(ENTRY_NO);
		}
		parameterMap.put("box", box);
		map = medicalClaimHandlerService
				.submitGeneralCoveringletter(parameterMap);
		saved = (Boolean) map.get("saved");
		String message = "";
		if (saved) {
			message = "Data Saved Successfully !!";
		} else {
			message = "Try Again ..";
		}

		String jsp = MD_MSG_GENERAL + ".jsp";
		map.put("entrySeqNo", entrySeqNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// ----------Show-Search Screen for --GeneralClaimTracking
	public ModelAndView showPatinetGeneralClaimTracking(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalClaimHandlerService.showPatientForGeneralClaim();
		jsp = MD_SEARCH_GENERAL_CLAIM_TRACKING + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// -search for General claim tracking---
	@SuppressWarnings("unchecked")
	public ModelAndView showPatientDetailsForGeneralTracking(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		int rankId = 0;
		String serPersonFName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientLName = "";
		int hinId = 0;
		int contingentHdID = 0;
		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(RANK_ID) != null
					&& !(request.getParameter(RANK_ID).equals("0"))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				mapForDs.put("rankId", rankId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(S_LAST_NAME) != null
					&& !(request.getParameter(S_LAST_NAME).equals(""))) {
				serPersonLName = request.getParameter(S_LAST_NAME);
				mapForDs.put("serPersonLName", serPersonLName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDs.put("patientLName", patientLName);
			}
			if (request.getParameter("hinId") != null
					&& !(request.getParameter("hinId").equals("0"))) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter("contingentHdID") != null
					&& !(request.getParameter("contingentHdID").equals("0"))) {
				contingentHdID = Integer.parseInt(request
						.getParameter("contingentHdID"));
				mapForDs.put("contingentHdID", contingentHdID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = medicalClaimHandlerService
				.getPatientDetailsForGeneralTracking(mapForDs);
		String jsp = "";
		List<MdContigentMedicalBillHd> contingentHdList = new ArrayList<MdContigentMedicalBillHd>();
		if (contingentHdID != 0) {
			detailsMap = medicalClaimHandlerService
					.getPatientForGeneralTracking(mapForDs);
			contingentHdList = (List) detailsMap.get("contingentHdList");
			jsp = MD_GENERAL_CLAIM_TRACKING + ".jsp";
		} else {
			map = medicalClaimHandlerService.showPatientForGeneralClaim();
			jsp = MD_SEARCH_GENERAL_CLAIM_TRACKING + ".jsp";
		}
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		map.put("contingentHdList", contingentHdList);
		return new ModelAndView("indexB", "map", map);
	}

	// -------Search screen for CardicClaimAdvance----
	public ModelAndView showPatientCardicClaimAdvance(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalClaimHandlerService.showPatientCardicClaimAdvance();
		jsp = MD_SEARCH_CARDIC_CLAIM_ADVANCE + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// --search Patient for CardicClaimAdvance---------------
	@SuppressWarnings("unchecked")
	public ModelAndView showPatientDetailsCardicClaim(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();

		String serviceNo = "";
		String hinNo = "";
		int rankId = 0;
		String serPersonFName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientLName = "";

		int hinId = 0;
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}

		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			mapForDs.put("rankId", rankId);
		}
		if (request.getParameter(S_FIRST_NAME) != null
				&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
			serPersonFName = request.getParameter(S_FIRST_NAME);
			mapForDs.put("serPersonFName", serPersonFName);
		}
		if (request.getParameter(S_LAST_NAME) != null
				&& !(request.getParameter(S_LAST_NAME).equals(""))) {
			serPersonLName = request.getParameter(S_LAST_NAME);
			mapForDs.put("serPersonLName", serPersonLName);
		}
		if (request.getParameter(P_FIRST_NAME) != null
				&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
			patientFName = request.getParameter(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (request.getParameter(P_LAST_NAME) != null
				&& !(request.getParameter(P_LAST_NAME).equals(""))) {
			patientLName = request.getParameter(P_LAST_NAME);
			mapForDs.put("patientLName", patientLName);
		}
		if (request.getParameter("hinId") != null
				&& !(request.getParameter("hinId").equals("0"))) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
			detailsMap = medicalClaimHandlerService
					.getPatientforCardicAdvance(hinId);

			patientList = (List) detailsMap.get("patientList");
			hospitalList = (List) detailsMap.get("hospitalList");
			
			String entrySeqNo = "";
			entrySeqNo = medicalClaimHandlerService
					.getyearlyEntryForDisplay("CYEN");
			if (entrySeqNo != null) {
				map.put("entrySeqNo", entrySeqNo);
			}
			jsp = MD_CARDIC_CLAIM_ADVANCE + ".jsp";
		} else {
			patientMap = medicalClaimHandlerService
					.getPatientDetailsCardicClaim(mapForDs);
			map = medicalClaimHandlerService.showPatientCardicClaimAdvance();
			jsp = MD_SEARCH_CARDIC_CLAIM_ADVANCE + ".jsp";
		}
		map.put("hospitalList", hospitalList);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		map.put("patientList", patientList);
		return new ModelAndView("indexB", "map", map);
	}

	// ---- Save data in CardicClaimAdvance-----------------
	public ModelAndView submitCardicClaimAdvance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		String entrySeqNo = "";
		String date = "";
		String time = "";
		int hinId = 0;
		int inpatinetId = 0;
		String empName = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		MdCardicClaimAdvance cardicClaimAdvance = new MdCardicClaimAdvance();

		int departmentId = (Integer) session.getAttribute("deptId");
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		cardicClaimAdvance.setDepartment(masDepartment);

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		cardicClaimAdvance.setHospital(masHospital);

		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			Patient patient = new Patient();
			patient.setId(hinId);
			cardicClaimAdvance.setHin(patient);
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("0")) {
			inpatinetId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatinetId);
			cardicClaimAdvance.setInpatient(inpatient);
		}
		if (request.getParameter(ENTRY_NO) != null
				&& !request.getParameter(ENTRY_NO).equals("")) {
			entrySeqNo = request.getParameter(ENTRY_NO);
		}
		String temp = medicalClaimHandlerService.generateAdvanceEntryNumber();
		cardicClaimAdvance.setEntryNo(entrySeqNo);
		String entryDate = "";
		if (request.getParameter(ENTRY_DATE) != null
				&& !(request.getParameter(ENTRY_DATE).equals(""))) {
			entryDate = request.getParameter(ENTRY_DATE);
		}
		cardicClaimAdvance.setEntryDate(HMSUtil
				.convertStringTypeDateToDateType(entryDate));
		String diagnosis = "";
		if (request.getParameter("diagnosis") != null
				&& !request.getParameter("diagnosis").equals("")) {
			diagnosis = request.getParameter("diagnosis");

			cardicClaimAdvance.setWorkingDiagnosis(diagnosis);
		}

		if (request.getParameter("chargeCodeId") != null
				&& !request.getParameter("chargeCodeId").equals("")) {
			int treatmentDetail = Integer.parseInt(request
					.getParameter("chargeCodeId"));
			MasChargeCode masChargeCode = new MasChargeCode();
			masChargeCode.setId(treatmentDetail);
			cardicClaimAdvance.setTreatmentDetail(masChargeCode);
		}
		int specialistName = 0;
		if (request.getParameter(SPECIALIST_NAME) != null
				&& !request.getParameter(SPECIALIST_NAME).equals("0")) {
			specialistName = Integer.parseInt(request
					.getParameter(SPECIALIST_NAME));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(specialistName);
			cardicClaimAdvance.setSpecialistName(masEmployee);
		}
		BigDecimal advanceAmount = null;
		if (request.getParameter(ADVANCE_AMOUNT) != null
				&& !request.getParameter(ADVANCE_AMOUNT).equals("")) {
			advanceAmount = new BigDecimal(request.getParameter(ADVANCE_AMOUNT));
			cardicClaimAdvance.setAdvanceAmount(advanceAmount);
		}
		BigDecimal qualifyingAmount = null;
		if (request.getParameter(QUALIFYING_RS) != null
				&& !request.getParameter(QUALIFYING_RS).equals("")) {
			qualifyingAmount = new BigDecimal(request
					.getParameter(QUALIFYING_RS));
			cardicClaimAdvance.setQualifyingAmount(qualifyingAmount);
		}
		int payableTo = 0;
		if (request.getParameter(PAYABLE_TO) != null
				&& !request.getParameter(PAYABLE_TO).equals("")) {
			payableTo = Integer.parseInt(request.getParameter(PAYABLE_TO));
			MasReference hospital = new MasReference();
			hospital.setId(payableTo);
			cardicClaimAdvance.setPayableTo(hospital);
		}
		String refered_To = "";
		if (request.getParameter("sugestTo") != null
				&& !request.getParameter("sugestTo").equals("")) {
			refered_To = request.getParameter("sugestTo");
			cardicClaimAdvance.setSugestTo(refered_To);
		}
		
		String amountPayableToCivilHospital  = "";
		if (request.getParameter("amountPayableToCivilHospital") != null
				&& !request.getParameter("amountPayableToCivilHospital").equals("")) {
			amountPayableToCivilHospital = request.getParameter("amountPayableToCivilHospital");
			cardicClaimAdvance.setCivilHospital(amountPayableToCivilHospital);
		}
		/*int refferedTo = 0;
		if (request.getParameter(REFERRED_TO) != null
				&& !request.getParameter(REFERRED_TO).equals("")) {
			refferedTo = Integer.parseInt(request.getParameter(REFERRED_TO));
			MasReference hospital = new MasReference();
			hospital.setId(refferedTo);
			cardicClaimAdvance.setRefferedTo(hospital);
		}*/
		String payableToName = "";
		if (request.getParameter("ammoutPayableTo") != null
				&& !request.getParameter("ammoutPayableTo").equals("")) {
			payableToName = request.getParameter("ammoutPayableTo");
			cardicClaimAdvance.setPayableToName(payableToName);
		}

		String cdaName = null;
		if (request.getParameter(CDA_PAY_OFFICE) != null
				&& !request.getParameter(CDA_PAY_OFFICE).equals("")) {
			cdaName = request.getParameter(CDA_PAY_OFFICE);
			cardicClaimAdvance.setCdaName(cdaName);
		}
		String cghsCode = null;
		if (request.getParameter(CGHS_CODE) != null
				&& !request.getParameter(CGHS_CODE).equals("")) {
			cghsCode = request.getParameter(CGHS_CODE);
			cardicClaimAdvance.setCghsCode(cghsCode);
		}
		String is1 = "";
		if (request.getParameter(IS1) != null
				&& !request.getParameter(IS1).equals("")) {
			is1 = request.getParameter(IS1);
			cardicClaimAdvance.setIs1(is1);
		}
		String cghsRates = "";
		if (request.getParameter(CGHS_RATES) != null
				&& !request.getParameter(CGHS_RATES).equals("")) {
			cghsCode = request.getParameter(CGHS_RATES);
			cardicClaimAdvance.setCghsRate(cghsRates);
		}
		BigDecimal is2 = null;
		if (request.getParameter(IS2) != null
				&& !request.getParameter(IS2).equals("")) {
			is2 = new BigDecimal(Integer.parseInt(request.getParameter(IS2)));
			cardicClaimAdvance.setIs2(is2);
		}
		String retDate = "";
		if (request.getParameter(RETIREMENT_DATE) != null
				&& !(request.getParameter(RETIREMENT_DATE).equals(""))) {
			retDate = request.getParameter(RETIREMENT_DATE);
		}
		cardicClaimAdvance.setRetirementDate(HMSUtil
				.convertStringTypeDateToDateType(retDate));
		BigDecimal basicPay = null;
		if (request.getParameter(BASIC_PAY) != null
				&& !request.getParameter(BASIC_PAY).equals("")) {
			basicPay = new BigDecimal(request.getParameter(BASIC_PAY));
			cardicClaimAdvance.setBasicPay(basicPay);
		}
		String identificationMark = "";
		if (request.getParameter(IDENTIFICATION_MARKS1) != null
				&& !request.getParameter(IDENTIFICATION_MARKS1).equals("")) {
			identificationMark = request.getParameter(IDENTIFICATION_MARKS1);
			cardicClaimAdvance.setIdentificationMark(identificationMark);
		}
		String pao = "";
		if (request.getParameter(PAO) != null
				&& !request.getParameter(PAO).equals("")) {
			pao = request.getParameter(PAO);
			cardicClaimAdvance.setPao(pao);
		}
		String dgmsTo = "";
		if (request.getParameter(DGMS_TO) != null
				&& !request.getParameter(DGMS_TO).equals("")) {
			dgmsTo = request.getParameter(DGMS_TO);
			cardicClaimAdvance.setDgmsTo(dgmsTo);
		}
		String disDate = "";
		if (request.getParameter(DISPATCH_DATE) != null
				&& !(request.getParameter(DISPATCH_DATE).equals(""))) {
			disDate = request.getParameter(DISPATCH_DATE);
		}
		cardicClaimAdvance.setDgmsDispatchDate(HMSUtil
				.convertStringTypeDateToDateType(disDate));
		String copy1 = "";
		if (request.getParameter(COPY1) != null
				&& !request.getParameter(COPY1).equals("")) {
			copy1 = request.getParameter(COPY1);
			cardicClaimAdvance.setCopy1(copy1);
		}
		String copy2 = "";
		if (request.getParameter(COPY2) != null
				&& !request.getParameter(COPY2).equals("")) {
			copy2 = request.getParameter(COPY2);
			cardicClaimAdvance.setCopy2(copy2);
		}
		String copy3 = "";
		if (request.getParameter(COPY3) != null
				&& !request.getParameter(COPY3).equals("")) {
			copy3 = request.getParameter(COPY3);
			cardicClaimAdvance.setCopy3(copy3);
		}
		String unitDisDate = "";
		if (request.getParameter(UNIT_DISPATCH_DATE) != null
				&& !(request.getParameter(UNIT_DISPATCH_DATE).equals(""))) {
			unitDisDate = request.getParameter(UNIT_DISPATCH_DATE);
		}
		cardicClaimAdvance.setUnitDispatchDate(HMSUtil
				.convertStringTypeDateToDateType(unitDisDate));
		int unitId = 0;
		if (request.getParameter(UNIT_ID) != null
				&& !request.getParameter(UNIT_ID).equals("")) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
			MasUnit masUnit = new MasUnit();
			masUnit.setId(unitId);
			cardicClaimAdvance.setUnitTo(masUnit);
		}
		String exPost = null;
		if (request.getParameter(EX_POST) != null
				&& !request.getParameter(EX_POST).equals("")) {
			exPost = request.getParameter(EX_POST);
			cardicClaimAdvance.setExPost(exPost);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !request.getParameter(CHANGED_BY).equals("")) {
			userName = request.getParameter(CHANGED_BY);
		}
		String hinNo = "";
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		cardicClaimAdvance.setLastChgBy(userName);
		cardicClaimAdvance.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		cardicClaimAdvance.setLastChgTime(time);

		boolean successfullyAdded = false;
		map = medicalClaimHandlerService
				.submitCardicClaimAdvance(cardicClaimAdvance);
		successfullyAdded = (Boolean) map.get("sucessfullyAdded");
		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";

		}
		map.put("hinNo", hinNo);
		map.put("hinId", hinId);
		map.put("message", message);
		map.put("entrySeqNo", entrySeqNo);
		jsp = MD_MSG_CARDIC_CLAIM;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

   // ------- Cardiac claim – Contingent Bill for Reimbursement-----
   // ------show search Screen For Cardic Contingent Bill
	public ModelAndView showPatientCardicClaimContingentBill(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalClaimHandlerService
				.showPatientSearchForCardicReimbursement();
		jsp = MD_SEARCH_CARDIC_CONTINGENT_BILL + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// ---Search for Cardic Contingent Bill---------------
	@SuppressWarnings("unchecked")
	public ModelAndView showPatientDetailsForCardicReimbursement(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		int rankId = 0;
		String serPersonFName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientLName = "";
		String patientStatus = "";
		int hinId = 0;
		int cardicClaimId = 0;
		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(PATIENT_STATUS) != null
					&& !(request.getParameter(PATIENT_STATUS).equals(""))) {
				patientStatus = request.getParameter(PATIENT_STATUS);
				mapForDs.put("patientStatus", patientStatus);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(RANK_ID) != null
					&& !(request.getParameter(RANK_ID).equals("0"))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				mapForDs.put("rankId", rankId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(S_LAST_NAME) != null
					&& !(request.getParameter(S_LAST_NAME).equals(""))) {
				serPersonLName = request.getParameter(S_LAST_NAME);
				mapForDs.put("serPersonLName", serPersonLName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDs.put("patientLName", patientLName);
			}
			if (request.getParameter("hinId") != null
					&& !(request.getParameter("hinId").equals("0"))) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter("cardicClaimId") != null
					&& !(request.getParameter("cardicClaimId").equals("0"))) {
				cardicClaimId = Integer.parseInt(request
						.getParameter("cardicClaimId"));
				mapForDs.put("cardicClaimId", cardicClaimId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = medicalClaimHandlerService
				.getPatientDetailsForCardicAdvance(mapForDs);
		String jsp = "";
		List<MdCardicClaimAdvance> cardcAdvanceList = new ArrayList<MdCardicClaimAdvance>();
		if (cardicClaimId != 0) {
			detailsMap = medicalClaimHandlerService
					.getPatientForCardicAdvanceBill(mapForDs);

			cardcAdvanceList = (List) detailsMap.get("cardcAdvanceList");
			// authorityList = (List) detailsMap.get("authorityList");
			String entrySeqNo = "";
			entrySeqNo = medicalClaimHandlerService
					.getCardicEntryForDisplay("CREN");
			if (entrySeqNo != null) {
				map.put("entrySeqNo", entrySeqNo);
			}
			jsp = MD_CARDIC_CONTINGENT_BILL + ".jsp";
		} else {
			map = medicalClaimHandlerService
					.showPatientSearchForCardicReimbursement();
			jsp = MD_SEARCH_CARDIC_CONTINGENT_BILL + ".jsp";
		}
		map.put("cardcAdvanceList", cardcAdvanceList);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	// -Save data in CardicReimbursement for contingent bill
	@SuppressWarnings("unchecked")
	public ModelAndView submitCardicReimbursement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		List<MdCardicContingentBillHd> cardicContingentList = new ArrayList<MdCardicContingentBillHd>();
		boolean saved = false;
		int hospitalId = 0;
		int deptId = 0;
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			dataMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			dataMap.put("deptId", deptId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			dataMap.put("userName", userName);
		}
		String hinNo = "";
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		dataMap.put("box", box);
		String url = "";
		String entrySeqNo = "";
		map = medicalClaimHandlerService
				.submitCardicReimbursement(box, dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}

		entrySeqNo = medicalClaimHandlerService
				.generateEntryNoForContingentEntry(diagMap);
		if (entrySeqNo != "") {
			map.put("entrySeqNo", entrySeqNo);
		}
		// map =
		// medicalClaimHandlerService.showPatientSearchForContingentBill();
		jsp = RequestConstants.MD_MSG_CONTINGENT;
		jsp += ".jsp";
		title = "search contingent Bill";
		url = "/hms/hms/mediClaim?method=showPatientSearchForContingentBill";
		map.put("hinNo", hinNo);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("cardicContingentList", cardicContingentList);
		map.put("url", url);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView printContingentBill(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";
		int id = 0;
		try {

			if (request.getParameter("entryNo") != null
					&& (!request.getParameter("entryNo").equals(""))) {
				query = "where cc.entry_no = '"
						+ request.getParameter("entryNo") + "' ";
			}
			if (request.getParameter("hinNo") != null
					&& (!request.getParameter("hinNo").equals(""))) {
				query = query + "AND cc.hin_no = '"
						+ request.getParameter("hinNo") + "' ";
			}
			if (request.getParameter("cardicContigentId") != null
					&& (!request.getParameter("cardicContigentId").equals(""))) {
				id = Integer
						.parseInt(request.getParameter("cardicContigentId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("QUERY", query);
		parameters.put("id", id);
		try {

			HMSUtil.generateReport("md_contigenetbill", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView PrintPreFactoSanction(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		int serviceTypeId = 0;
		int cardicContigentId = 0;
		try {

			if (request.getParameter("id") != null
					&& (!request.getParameter("id").equals(""))) {
				cardicContigentId = Integer
						.parseInt(request.getParameter("id"));
			}
			if (request.getParameter("serviceTypeId") != null
					&& (!request.getParameter("serviceTypeId").equals(""))) {
				serviceTypeId = Integer.parseInt(request
						.getParameter("serviceTypeId"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("id", cardicContigentId);

		try {
			if (serviceTypeId == 1) {
				HMSUtil.generateReport("pre_facto_sanction_cardiac_ARMY",
						parameters, (Connection) detailsMap.get("con"),
						response, getServletContext());
			} else {
				HMSUtil.generateReport("pre_facto_sanction_cardiac_AIR",
						parameters, (Connection) detailsMap.get("con"),
						response, getServletContext());
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printPostFactoSanction(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		int serviceTypeId = 0;
		int cardicContigentId = 0;
		try {

			if (request.getParameter("cardicContigentId") != null
					&& (!request.getParameter("cardicContigentId").equals(""))) {
				cardicContigentId = Integer.parseInt(request
						.getParameter("cardicContigentId"));
			}
			if (request.getParameter("serviceTypeId") != null
					&& (!request.getParameter("serviceTypeId").equals(""))) {
				serviceTypeId = Integer.parseInt(request
						.getParameter("serviceTypeId"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("id", cardicContigentId);

		try {
			if (serviceTypeId == 1) {
				HMSUtil.generateReport("post_facto_sanction_cardiac_ARMY",
						parameters, (Connection) detailsMap.get("con"),
						response, getServletContext());
			} else {
				HMSUtil.generateReport("post_facto_sanction_cardiac_AIR",
						parameters, (Connection) detailsMap.get("con"),
						response, getServletContext());
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printSpecialisedCardiacTreatment(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		int serviceTypeId = 0;
		int id = 0;
		try {

			if (request.getParameter("Id") != null
					&& (!request.getParameter("Id").equals(""))) {
				id = Integer.parseInt(request.getParameter("Id"));
			}
			if (request.getParameter("serviceTypeId") != null
					&& (!request.getParameter("serviceTypeId").equals(""))) {
				serviceTypeId = Integer.parseInt(request
						.getParameter("serviceTypeId"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("id", id);

		try {

			HMSUtil.generateReport("specialised_cardiac_treatment", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ---------Show Search- Contingent bill movement entry-------------
	public ModelAndView showPatientContingentBillMovement(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalClaimHandlerService
				.showPatientSearchContingentBillMovement();
		jsp = MD_SEARCH_CONTINGENT_BILL_MOVEMENT + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// -------- Search- Contingent bill movement entry-------------
	@SuppressWarnings("unchecked")
	public ModelAndView showPatientDetailsForBillMovement(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		int rankId = 0;
		String serPersonFName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientLName = "";
		int hinId = 0;
		int contingentHdID = 0;
		try {

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(RANK_ID) != null
					&& !(request.getParameter(RANK_ID).equals("0"))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				mapForDs.put("rankId", rankId);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(S_LAST_NAME) != null
					&& !(request.getParameter(S_LAST_NAME).equals(""))) {
				serPersonLName = request.getParameter(S_LAST_NAME);
				mapForDs.put("serPersonLName", serPersonLName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDs.put("patientLName", patientLName);
			}
			if (request.getParameter("hinId") != null
					&& !(request.getParameter("hinId").equals("0"))) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter("contingentHdID") != null
					&& !(request.getParameter("contingentHdID").equals("0"))) {
				contingentHdID = Integer.parseInt(request
						.getParameter("contingentHdID"));
				mapForDs.put("contingentHdID", contingentHdID);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = "";
		List<MdCardicContingentBillHd> cardicBillList = new ArrayList<MdCardicContingentBillHd>();
		List<MdMasAuthority> authorityList = new ArrayList<MdMasAuthority>();
		List<MdBillMovement> billMovementList = new ArrayList<MdBillMovement>();
		if (contingentHdID != 0) {
			detailsMap = medicalClaimHandlerService
					.getPatientForCardicBillMovement(serviceNo, mapForDs);
			cardicBillList = (List) detailsMap.get("cardicBillList");
			authorityList = (List) detailsMap.get("authorityList");
			billMovementList = (List) detailsMap.get("billMovementList");
			jsp = MD_CONTINGENT_BILL_MOVEMENT + ".jsp";
			map.put("authorityList", authorityList);
			map.put("billMovementList", billMovementList);

		} else {
			patientMap = medicalClaimHandlerService
					.getPatientDetailsForBillMovement(mapForDs);
			map = medicalClaimHandlerService
					.showPatientSearchContingentBillMovement();

			jsp = MD_SEARCH_CONTINGENT_BILL_MOVEMENT + ".jsp";
		}
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		map.put("cardicBillList", cardicBillList);

		return new ModelAndView("indexB", "map", map);
	}

	// ---------Save Contingent bill movement entry-------------
	@SuppressWarnings("unchecked")
	public ModelAndView submitCardicBillMovement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> diagMap = new HashMap<String, Object>();
		List<MdBillMovement> billMovementList = new ArrayList<MdBillMovement>();
		boolean saved = false;
		int hospitalId = 0;
		int deptId = 0;
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			dataMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			dataMap.put("deptId", deptId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			dataMap.put("userName", userName);
		}
		dataMap.put("box", box);
		String url = "";
		map = medicalClaimHandlerService.submitCardicBillMovement(box, dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}

		map = medicalClaimHandlerService.showPatientSearchForContingentBill();
		jsp = RequestConstants.MD_SEARCH_CONTINGENT_BILL_MOVEMENT;
		jsp += ".jsp";
		title = "search contingent Bill Movement";
		url = "/hms/hms/mediClaim?method=showPatientContingentBillMovement";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("billMovementList", billMovementList);
		map.put("url", url);
		return new ModelAndView("indexB", "map", map);
	}

	// --------------Show---CardicClaimTracking---------------------

	public ModelAndView showPatientCardicClaimTracking(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalClaimHandlerService.showPatientForCardicClaim();
		jsp = MD_SEARCH_CARDIC_CLAIM_TRACKING + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// -----Search For -CardicClaimTracking----
	@SuppressWarnings("unchecked")
	public ModelAndView showPatientDetailsForCardicTracking(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MdBillMovement> billMovementList = new ArrayList<MdBillMovement>();
		String serviceNo = "";
		String hinNo = "";
		int rankId = 0;
		String serPersonFName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientLName = "";
		int hinId = 0;
		int billMovementID = 0;

		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			mapForDs.put("rankId", rankId);
		}
		if (request.getParameter(S_FIRST_NAME) != null
				&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
			serPersonFName = request.getParameter(S_FIRST_NAME);
			mapForDs.put("serPersonFName", serPersonFName);
		}
		if (request.getParameter(S_LAST_NAME) != null
				&& !(request.getParameter(S_LAST_NAME).equals(""))) {
			serPersonLName = request.getParameter(S_LAST_NAME);
			mapForDs.put("serPersonLName", serPersonLName);
		}
		if (request.getParameter(P_FIRST_NAME) != null
				&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
			patientFName = request.getParameter(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (request.getParameter(P_LAST_NAME) != null
				&& !(request.getParameter(P_LAST_NAME).equals(""))) {
			patientLName = request.getParameter(P_LAST_NAME);
			mapForDs.put("patientLName", patientLName);
		}
		if (request.getParameter("hinId") != null
				&& !(request.getParameter("hinId").equals("0"))) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
			mapForDs.put("hinId", hinId);
		}
		if (request.getParameter("billMovementID") != null
				&& !(request.getParameter("billMovementID").equals("0"))) {
			billMovementID = Integer.parseInt(request
					.getParameter("billMovementID"));
			detailsMap = medicalClaimHandlerService
					.getPatientForCardicTracking(billMovementID);
			billMovementList = (List) detailsMap.get("billMovementList");
			jsp = MD_CARDIC_CLAIM_TRACKING + ".jsp";
		} else {
			patientMap = medicalClaimHandlerService
					.getPatientDetailsForCardicTracking(mapForDs);

			map = medicalClaimHandlerService.showPatientForCardicClaim();
			jsp = MD_SEARCH_CARDIC_CLAIM_TRACKING + ".jsp";
		}
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		map.put("billMovementList", billMovementList);
		return new ModelAndView("indexB", "map", map);
	}

	// -------------------methods for updation ----------
	public ModelAndView showUpdateSearchForSpecialInvetigationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalClaimHandlerService.getDataForSpecialInvetigationJsp();
		jsp = MD_SEARCH_UPDATE_SPECIAL_INV;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showPatientUpdateSpecialInv(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientLName = "";
		String patientStatus = "";
		int rankId = 0;
		int hinId = 0;
		int specInvHdId = 0;

		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (request.getParameter(PATIENT_STATUS) != null
				&& !(request.getParameter(PATIENT_STATUS).equals(""))) {
			patientStatus = request.getParameter(PATIENT_STATUS);
			mapForDs.put("patientStatus", patientStatus);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			mapForDs.put("rankId", rankId);
		}
		if (request.getParameter(S_FIRST_NAME) != null
				&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
			serPersonFName = request.getParameter(S_FIRST_NAME);
			mapForDs.put("serPersonFName", serPersonFName);
		}
		if (request.getParameter(S_LAST_NAME) != null
				&& !(request.getParameter(S_LAST_NAME).equals(""))) {
			serPersonLName = request.getParameter(S_LAST_NAME);
			mapForDs.put("serPersonLName", serPersonLName);
		}
		if (request.getParameter(P_FIRST_NAME) != null
				&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
			patientFName = request.getParameter(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (request.getParameter(P_LAST_NAME) != null
				&& !(request.getParameter(P_LAST_NAME).equals(""))) {
			patientLName = request.getParameter(P_LAST_NAME);
			mapForDs.put("patientLName", patientLName);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals("0"))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			mapForDs.put("hinId", hinId);
		}
		if (request.getParameter("specInvHdId") != null
				&& !(request.getParameter("specInvHdId").equals("0"))) {
			specInvHdId = Integer.parseInt(request.getParameter("specInvHdId"));
			mapForDs.put("specInvHdId", specInvHdId);
		}
		patientMap = medicalClaimHandlerService
				.showPatientUpdateSpecialInv(mapForDs);
		map = medicalClaimHandlerService.getDataForSpecialInvetigationJsp();
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateSpecialInvestigation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		int specInvHdId = 0;
		if (request.getParameter("specInvHdId") != null
				&& !(request.getParameter("specInvHdId").equals("0"))) {
			specInvHdId = Integer.parseInt(request.getParameter("specInvHdId"));
			mapForDs.put("specInvHdId", specInvHdId);
		}
		if (specInvHdId != 0) {
			map = medicalClaimHandlerService
					.showUpdateSpecialInvestigation(specInvHdId);
		}
		jsp = MD_UPDATE_SPECIAL_INV + ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateSpecialInvestigation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		boolean successfullyAdded = false;
		map = medicalClaimHandlerService.updateSpecialInvestigation(box);
		if(map.get("successfullyAdded")!=null){
			successfullyAdded = (Boolean)map.get("successfullyAdded");
		}
		if (successfullyAdded) {
			message = "Special Investigation has been updated Successfully !! Do You want to print? ";
			jsp = RequestConstants.MEDICAL_CLAIM_REQUEST_SUBMIT_CONFIRM
					+ ".jsp";
		}else {
			message = "Error Occurred !! Try Again !!";
		}
//		map = medicalClaimHandlerService.getDataForSpecialInvetigationJsp();
//		jsp = MD_SEARCH_UPDATE_SPECIAL_INV;
//		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

   // ---------------update Cardic Advance---------
	public ModelAndView showPatientSearchForCardicAdvanceJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalClaimHandlerService.getPateintForCardicAdvance();
		jsp = MD_SEARCH_UPDATE_CARDIC_ADVANCE + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showPatientUpdateCardicAdvance(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		int rankId = 0;
		String serPersonFName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientLName = "";
		String patientStatus = "";
		int hinId = 0;
		int cardicClaimId = 0;
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (request.getParameter(PATIENT_STATUS) != null
				&& !(request.getParameter(PATIENT_STATUS).equals(""))) {
			patientStatus = request.getParameter(PATIENT_STATUS);
			mapForDs.put("patientStatus", patientStatus);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			mapForDs.put("rankId", rankId);
		}
		if (request.getParameter(S_FIRST_NAME) != null
				&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
			serPersonFName = request.getParameter(S_FIRST_NAME);
			mapForDs.put("serPersonFName", serPersonFName);
		}
		if (request.getParameter(S_LAST_NAME) != null
				&& !(request.getParameter(S_LAST_NAME).equals(""))) {
			serPersonLName = request.getParameter(S_LAST_NAME);
			mapForDs.put("serPersonLName", serPersonLName);
		}
		if (request.getParameter(P_FIRST_NAME) != null
				&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
			patientFName = request.getParameter(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (request.getParameter(P_LAST_NAME) != null
				&& !(request.getParameter(P_LAST_NAME).equals(""))) {
			patientLName = request.getParameter(P_LAST_NAME);
			mapForDs.put("patientLName", patientLName);
		}
		if (request.getParameter("cardicClaimId") != null
				&& !(request.getParameter("cardicClaimId").equals("0"))) {
			cardicClaimId = Integer.parseInt(request
					.getParameter("cardicClaimId"));
			mapForDs.put("cardicClaimId", cardicClaimId);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals("0"))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			mapForDs.put("hinId", hinId);
		}
		patientMap = medicalClaimHandlerService
				.showPatientUpdateCardicAdvance(mapForDs);
		map = medicalClaimHandlerService.getPateintForCardicAdvance();
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateAdvanceClaim(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		boolean bool = medicalClaimHandlerService.updateAdvanceClaim(box);
		if (bool) {
			message = "Data  updated Successfully!!";
		} else {
			message = "Eror Occurred !! Try Again !!";
		}
		map = medicalClaimHandlerService.getPateintForCardicAdvance();
		jsp = MD_SEARCH_UPDATE_CARDIC_ADVANCE;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateCardicClaim(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int cardicClaimId = 0;
		if (request.getParameter("cardicClaimId") != null
				&& !(request.getParameter("cardicClaimId").equals("0"))) {
			cardicClaimId = Integer.parseInt(request
					.getParameter("cardicClaimId"));
			mapForDS.put("cardicClaimId", cardicClaimId);
		}
		if (cardicClaimId != 0) {
			map = medicalClaimHandlerService
					.showUpdateCardicClaim(cardicClaimId);
		}
		jsp = MD_UPDATE_CARDIC_ADVANCE + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// -------------------update----cardicContingent Bill------

	public ModelAndView showPatientSearchForCardicBillJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalClaimHandlerService.getPateintForCardicBill();
		jsp = MD_SEARCH_UPDATE_CARDIC_BILL + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showPatientUpdateCardicBill(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		int rankId = 0;
		String serPersonFName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientLName = "";
		String patientStatus = "";
		int hinId = 0;
		int contingentHdID = 0;
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (request.getParameter(PATIENT_STATUS) != null
				&& !(request.getParameter(PATIENT_STATUS).equals(""))) {
			patientStatus = request.getParameter(PATIENT_STATUS);
			mapForDs.put("patientStatus", patientStatus);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			mapForDs.put("rankId", rankId);
		}
		if (request.getParameter(S_FIRST_NAME) != null
				&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
			serPersonFName = request.getParameter(S_FIRST_NAME);
			mapForDs.put("serPersonFName", serPersonFName);
		}
		if (request.getParameter(S_LAST_NAME) != null
				&& !(request.getParameter(S_LAST_NAME).equals(""))) {
			serPersonLName = request.getParameter(S_LAST_NAME);
			mapForDs.put("serPersonLName", serPersonLName);
		}
		if (request.getParameter(P_FIRST_NAME) != null
				&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
			patientFName = request.getParameter(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (request.getParameter(P_LAST_NAME) != null
				&& !(request.getParameter(P_LAST_NAME).equals(""))) {
			patientLName = request.getParameter(P_LAST_NAME);
			mapForDs.put("patientLName", patientLName);
		}
		if (request.getParameter("contingentHdID") != null
				&& !(request.getParameter("contingentHdID").equals("0"))) {
			contingentHdID = Integer.parseInt(request
					.getParameter("contingentHdID"));
			mapForDs.put("contingentHdID", contingentHdID);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals("0"))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			mapForDs.put("hinId", hinId);
		}
		patientMap = medicalClaimHandlerService
				.showPatientUpdateCardicBill(mapForDs);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateCardicBill(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int contingentHdID = 0;
		if (request.getParameter("contingentHdID") != null
				&& !(request.getParameter("contingentHdID").equals("0"))) {
			contingentHdID = Integer.parseInt(request
					.getParameter("contingentHdID"));
			mapForDS.put("contingentHdID", contingentHdID);
		}
		if (contingentHdID != 0) {
			map = medicalClaimHandlerService
					.showUpdateCardicBill(contingentHdID);
		}
		jsp = MD_UPDATE_CARDIC_BILL + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateCardicBill(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		boolean bool = medicalClaimHandlerService.updateCardicBill(box);
		if (bool) {
			message = "Data  Updated Successfully!!";
		} else {
			message = "Eror Occurred !! Try Again !!";
		}

		map = medicalClaimHandlerService.getPateintForCardicBill();
		jsp = MD_SEARCH_UPDATE_CARDIC_BILL + ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateSearchForMedicalBillJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalClaimHandlerService.getDataForMedicalBillJsp();
		jsp = MD_SEARCH_UPDATE_MEDICAL_BILL;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showPatientUpdateMedicalBill(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		String serviceNo = "";
		String hinNo = "";
		int rankId = 0;
		int contingentHdID = 0;
		String serPersonFName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientLName = "";
		int hinId = 0;
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals("0"))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			mapForDs.put("rankId", rankId);
		}
		if (request.getParameter(P_FIRST_NAME) != null
				&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
			patientFName = request.getParameter(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (request.getParameter(P_LAST_NAME) != null
				&& !(request.getParameter(P_LAST_NAME).equals(""))) {
			patientLName = request.getParameter(P_LAST_NAME);
			mapForDs.put("patientLName", patientLName);
		}
		if (request.getParameter(S_FIRST_NAME) != null
				&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
			serPersonFName = request.getParameter(S_FIRST_NAME);
			mapForDs.put("serPersonFName", serPersonFName);
		}
		if (request.getParameter(S_LAST_NAME) != null
				&& !(request.getParameter(S_LAST_NAME).equals(""))) {
			serPersonLName = request.getParameter(S_LAST_NAME);
			mapForDs.put("serPersonLName", serPersonLName);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals("0"))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			mapForDs.put("hinId", hinId);
		}
		if (request.getParameter("contingentHdID") != null
				&& !(request.getParameter("contingentHdID").equals("0"))) {
			contingentHdID = Integer.parseInt(request
					.getParameter("contingentHdID"));
			mapForDs.put("contingentHdID", contingentHdID);
		}

		patientMap = medicalClaimHandlerService
				.showPatientUpdateMedicalBill(mapForDs);
		map = medicalClaimHandlerService.getDataForMedicalBillJsp();
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateMedicalBill(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int contingentHdID = 0;
		if (request.getParameter("contingentHdID") != null
				&& !(request.getParameter("contingentHdID").equals("0"))) {
			contingentHdID = Integer.parseInt(request
					.getParameter("contingentHdID"));
			mapForDS.put("contingentHdID", contingentHdID);
		}
		if (contingentHdID != 0) {
			map = medicalClaimHandlerService
					.showUpdateMedicalBill(contingentHdID);
		}
		jsp = MD_UPDATE_MEDICAL_BILL + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/*
	 * public ModelAndView
	 * showUpdateSearchForCoveringLetterJsp(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); map =
	 * medicalClaimHandlerService.getDataForCoveringLetterJsp(); jsp =
	 * MD_SEARCH_UPDATE_COVERING_LETTER; jsp += ".jsp"; map.put("contentJsp",
	 * jsp); return new ModelAndView("indexB", "map", map); }
	 */
	public ModelAndView updateMedicalBill(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		boolean bool = medicalClaimHandlerService.updateMedicalBill(box);
		if (bool) {
			message = "Data  Updated Successfully!!";
		} else {
			message = "Eror Occurred !! Try Again !!";
		}

		map = medicalClaimHandlerService.getDataForMedicalBillJsp();
		jsp = MD_SEARCH_UPDATE_MEDICAL_BILL + ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView showUpdateSearchForCoveringLetterJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalClaimHandlerService.getDataForCoveringLettersp();
		jsp = MD_SEARCH_UPDATE_COVERING_LETTER;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showPatientUpdateCoveringLetter(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String entryNo = "";
		int unitId = 0;
		Date entryDate = new Date();
		int coveringLetterId = 0;

		if (request.getParameter(ENTRY_NO) != null
				&& !(request.getParameter(ENTRY_NO).equals(""))) {
			entryNo = request.getParameter(ENTRY_NO);
			mapForDs.put("entryNo", entryNo);
		}
		if (request.getParameter(ENTRY_DATE) != null
				&& !(request.getParameter(ENTRY_DATE).equals(""))) {
			entryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ENTRY_DATE));
			mapForDs.put("entryDate", entryDate);
		}
		if (request.getParameter(UNIT_ID) != null
				&& !(request.getParameter(UNIT_ID).equals("0"))) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
			mapForDs.put("unitId", unitId);
		}
		if (request.getParameter("coveringLetterId") != null
				&& !(request.getParameter("coveringLetterId").equals("0"))) {
			coveringLetterId = Integer.parseInt(request
					.getParameter("coveringLetterId"));
			mapForDs.put("coveringLetterId", coveringLetterId);
		}
		patientMap = medicalClaimHandlerService
				.showPatientUpdateCoveringLetter(mapForDs);

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateCoveringLetter(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int coveringLetterId = 0;
		if (request.getParameter("coveringLetterId") != null
				&& !(request.getParameter("coveringLetterId").equals("0"))) {
			coveringLetterId = Integer.parseInt(request
					.getParameter("coveringLetterId"));
			mapForDS.put("coveringLetterId", coveringLetterId);
		}
		if (coveringLetterId != 0) {
			map = medicalClaimHandlerService
					.showUpdateCoveringLetter(coveringLetterId);
		}
		jsp = MD_UPDATE_COVERING_LETTER + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

   // ---------------Report----------------------------------

	public ModelAndView showGeneralContingentBillReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Collection Issue Register";

		jsp = MD_GENERAL_CONTINEGEN_BILL_REPORT;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateGenerateContingentReport(
			HttpServletRequest request, HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
			}

			query = " where md_contigent_medical_bill_hd.entry_date between '"
					+ fromDate + "' and '" + toDate + "'";

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("QUERY", query);
		try {
			HMSUtil.generateReport("md_GeneralContingentBill", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView showCardicContingentBillReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Cardic Contingent Bill";

		jsp = MD_CARDIC_CONTINEGEN_BILL_REPORT;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView generateCardicContingentReport(
			HttpServletRequest request, HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE)));
			}

			query = " where md_cardic_contingent_bill_hd.entry_date between '"
					+ fromDate + "' and '" + toDate + "'";

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("QUERY", query);
		try {
			HMSUtil.generateReport("md_CardicContingentBill", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView UndertakingMedicalAdvance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";

		try {

			if (request.getParameter("entryNo") != null
					&& (!request.getParameter("entryNo").equals(""))) {
				query = "where md_cardic_claim_advance.`entry_no` = '"
						+ request.getParameter("entryNo") + "' ";
			}
			if (request.getParameter("hinNo") != null
					&& (!request.getParameter("hinNo").equals(""))) {
				query = query + "AND patient.`hin_no` = '"
						+ request.getParameter("hinNo") + "' ";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("QUERY", query);

		try {

			HMSUtil.generateReport("md_Undertaking_Medical_Advance",
					parameters, (Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printUndertakingIdentificationCardFamilies(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";
		int id = 0;
		try {

			if (request.getParameter("entryNo") != null
					&& (!request.getParameter("entryNo").equals(""))) {
				query = "where md_cardic_claim_advance.`entry_no` = '"
						+ request.getParameter("entryNo") + "' ";
			}
			if (request.getParameter("hinNo") != null
					&& (!request.getParameter("hinNo").equals(""))) {
				query = query + "AND patient.`hin_no` = '"
						+ request.getParameter("hinNo") + "' ";
			}
			if (request.getParameter("Id") != null
					&& (!request.getParameter("Id").equals(""))) {
				id = Integer.parseInt(request.getParameter("Id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("QUERY", query);
		parameters.put("id", id);

		try {

			HMSUtil.generateReport("md_Entitlement_Card_For_Families",
					parameters, (Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printAdvanceCoveringLetter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String entryNo = "";
		String hinNo = "";
		String query = "";
		int id = 0;

		try {
			if (request.getParameter("Id") != null
					&& !request.getParameter("Id").equalsIgnoreCase("")) {
				id = Integer.parseInt(request.getParameter("Id"));
				query = "where md_cardic_claim_advance.`id`= " + id;

			}
			if (request.getParameter("entryNo") != null
					&& (!request.getParameter("entryNo").equals(""))) {
				query = query + " and md_cardic_claim_advance.`entry_no` = '"
						+ request.getParameter("entryNo") + "' ";
				entryNo = request.getParameter("entryNo");

			}
			/*
			 * if (request.getParameter("hinNo") != null &&
			 * (!request.getParameter("hinNo").equals(""))) { query = query +
			 * "AND patient.`hin_no` = '" + request.getParameter("hinNo") +
			 * "' "; hinNo= request.getParameter("hinNo");
			 * 
			 * }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("QUERY", query);

		try {

			HMSUtil.generateReport("md_advance_Covering_Letter_Units",
					parameters, (Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printCoveringLetter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int id = 0;
		try {
			if (request.getParameter("coveringHdId") != null
					&& !request.getParameter("coveringHdId").equalsIgnoreCase(
							"")) {
				id = Integer.parseInt(request.getParameter("coveringHdId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("coveringId", id);
		try {
			HMSUtil.generateReport("md_covering_letter", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printMedicalAdvance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int id = 0;
		String query = "";
		try {

			/*
			 * if (request.getParameter("id") != null &&
			 * (!request.getParameter("id").equals(""))) { query =
			 * "where md_cardic_claim_advance.`id` = " +
			 * Integer.parseInt(request.getParameter("id").toString()) ; }
			 */
			if (request.getParameter("Id") != null
					&& (!request.getParameter("Id").equals(""))) {
				id = Integer.parseInt(request.getParameter("Id"));
			}
			/*
			 * if (request.getParameter("hinNo") != null &&
			 * (!request.getParameter("hinNo").equals(""))) { query = query +
			 * "AND patient.`hin_no` = '" + request.getParameter("hinNo") +
			 * "' "; }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("id", id);

		try {

			HMSUtil.generateReport("md_applicationformedicaladvance",
					parameters, (Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printWillingnessCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";
		int id = 0;
		try {

			if (request.getParameter("entryNo") != null
					&& (!request.getParameter("entryNo").equals(""))) {
				query = "where md_cardic_claim_advance.`entry_no` = '"
						+ request.getParameter("entryNo") + "' ";
			}
			if (request.getParameter("hinNo") != null
					&& (!request.getParameter("hinNo").equals(""))) {
				query = query + "AND patient.`hin_no` = '"
						+ request.getParameter("hinNo") + "' ";
			}
			if (request.getParameter("Id") != null
					&& (!request.getParameter("Id").equals(""))) {
				id = Integer.parseInt(request.getParameter("Id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = medicalClaimHandlerService.getConnectionForReport();

		parameters.put("QUERY", query);
		parameters.put("id", id);

		try {

			HMSUtil.generateReport("md_willingnesscertificate", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printAuthorisedmedicalAttendent(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";
		int id = 0;
		try {

			if (request.getParameter("cardicContigentId") != null
					&& (!request.getParameter("cardicContigentId").equals(""))) {
				id = Integer
						.parseInt(request.getParameter("cardicContigentId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("QUERY", query);
		parameters.put("id", id);
		try {

			HMSUtil.generateReport("md_Certificate_Of_Authorised_Attendant",
					parameters, (Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void printContingentBillReimb(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";
		int id = 0;

		try {

			if (request.getParameter("entryNo") != null
					&& (!request.getParameter("entryNo").equals(""))) {
				query = "where md_cardic_contingent_bill_hd.`entry_no` = '"
						+ request.getParameter("entryNo") + "' ";
			}
			if (request.getParameter("hinNo") != null
					&& (!request.getParameter("hinNo").equals(""))) {
				query = query + "AND patient.`hin_no` = '"
						+ request.getParameter("hinNo") + "' ";
			}
			if (request.getParameter("cardicContigentId") != null
					&& (!request.getParameter("cardicContigentId").equals(""))) {
				id = Integer
						.parseInt(request.getParameter("cardicContigentId"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("QUERY", query);
		parameters.put("id", id);

		try {

			HMSUtil.generateReport("md_After_Pre_Audit_return", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

	}

	public ModelAndView printPatientCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";
		int id = 0;

		try {

			if (request.getParameter("entryNo") != null
					&& (!request.getParameter("entryNo").equals(""))) {
				query = "where md_cardic_contingent_bill_hd.`entry_no` = '"
						+ request.getParameter("entryNo") + "' ";
			}
			if (request.getParameter("hinNo") != null
					&& (!request.getParameter("hinNo").equals(""))) {
				query = query + "AND patient.`hin_no` = '"
						+ request.getParameter("hinNo") + "' ";
			}
			if (request.getParameter("Id") != null
					&& (!request.getParameter("Id").equals(""))) {
				id = Integer.parseInt(request.getParameter("Id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("QUERY", query);
		parameters.put("id", id);
		try {

			HMSUtil.generateReport("md_Certificate_Patient", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printMedicalAdvanceForContingentBill(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";

		try {

			if (request.getParameter("entryNo") != null
					&& (!request.getParameter("entryNo").equals(""))) {
				query = "where md_cardic_contingent_bill_hd.`entry_no` = '"
						+ request.getParameter("entryNo") + "' ";
			}
			if (request.getParameter("hinNo") != null
					&& (!request.getParameter("hinNo").equals(""))) {
				query = query + "AND patient.`hin_no` = '"
						+ request.getParameter("hinNo") + "' ";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("QUERY", query);
		try {

			HMSUtil.generateReport("md_formedicaladvance", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printDependentCertificate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";
		int id = 0;
		try {

			if (request.getParameter("entryNo") != null
					&& (!request.getParameter("entryNo").equals(""))) {
				query = "where cc.entry_no = '"
						+ request.getParameter("entryNo") + "' ";
			}
			if (request.getParameter("hinNo") != null
					&& (!request.getParameter("hinNo").equals(""))) {
				query = query + "AND cc.hin_no = '"
						+ request.getParameter("hinNo") + "' ";
			}
			if (request.getParameter("cardicContigentId") != null
					&& (!request.getParameter("cardicContigentId").equals(""))) {
				id = Integer
						.parseInt(request.getParameter("cardicContigentId"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("QUERY", query);
		parameters.put("id", id);

		try {

			HMSUtil.generateReport("md_dependentcertificate", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printReimbursementmedicalClaim(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";

		try {

			if (request.getParameter("entryNo") != null
					&& (!request.getParameter("entryNo").equals(""))) {
				query = "where md_general_covering_hd.`entry_no` = '"
						+ request.getParameter("entryNo") + "' ";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("entryNo", query);
		try {

			HMSUtil.generateReport("md_reimbursementofmedicalclaim",
					parameters, (Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView printSpecialInvestigation(HttpServletRequest request,
			HttpServletResponse response) {
		int Id = 0;
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> connectionMap = medicalClaimHandlerService
				.getConnectionForReport();
		if (request.getParameter("Id") != null
				&& !request.getParameter("Id").equals("")) {
			Id = Integer.parseInt(request.getParameter("Id"));

		}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(			"/reports/"));
		parameters.put("id", Id);
		try {

			HMSUtil.generateReport("Special_Investigation_Admission",
					parameters, (java.sql.Connection) connectionMap.get("con"),
					response, getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView printCertificateByRegistrar(HttpServletRequest request,
			HttpServletResponse response) {
		int specialInvId = 0;
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> connectionMap = medicalClaimHandlerService
				.getConnectionForReport();
		if (request.getParameter("specialInvId") != null) {
			specialInvId = Integer.parseInt(request
					.getParameter("specialInvId"));

		}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));
		parameters.put("id", specialInvId);

		try {

			HMSUtil.generateReport("certificate_by-registrar", parameters,
					(java.sql.Connection) connectionMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView printContingentBillRem(HttpServletRequest request,
			HttpServletResponse response) {
		int contigentMedicalBill_Id = 0;
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> connectionMap = medicalClaimHandlerService
				.getConnectionForReport();
		if (request.getParameter("contigentMedicalBill_Id") != null
				&& !request.getParameter("contigentMedicalBill_Id").equals("")) {
			contigentMedicalBill_Id = Integer.parseInt(request
					.getParameter("contigentMedicalBill_Id"));

		}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		parameters.put("id", contigentMedicalBill_Id);

		try {

			HMSUtil.generateReport("Continent_Bill_Reimbursement", parameters,
					(java.sql.Connection) connectionMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView printIdentificationCard(HttpServletRequest request,
			HttpServletResponse response) {
		int contigentMedicalBill_Id = 0;
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> connectionMap = medicalClaimHandlerService
				.getConnectionForReport();
		if (request.getParameter("contigentMedicalBill_Id") != null) {
			contigentMedicalBill_Id = Integer.parseInt(request
					.getParameter("contigentMedicalBill_Id"));

		}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		parameters.put("id", contigentMedicalBill_Id);

		try {

			HMSUtil.generateReport("identification_for_service_personnel",
					parameters, (java.sql.Connection) connectionMap.get("con"),
					response, getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView printGeneralClaimReports(HttpServletRequest request,
			HttpServletResponse response) {
		int selectValue = 0;
		String specialInvId = "";
		String contigentMedicalBill_Id = "";
		String message = "";

		if (request.getParameter("specialInvId") != null
				&& !request.getParameter("specialInvId").equals("")) {
			specialInvId = request.getParameter("specialInvId");
		}
		if (request.getParameter("contigentMedicalBill_Id") != null
				&& !request.getParameter("contigentMedicalBill_Id").equals("")) {
			contigentMedicalBill_Id = request
					.getParameter("contigentMedicalBill_Id");
		}
		if (request.getParameter("message") != null
				&& !request.getParameter("message").equals("")) {
			message = request.getParameter("message");
		}
		if (request.getParameter("selectReport") != null
				&& !request.getParameter("selectReport").equals("")) {
			selectValue = Integer
					.parseInt(request.getParameter("selectReport"));
		}
		if (selectValue != 0) {
			if (selectValue == 1) {
				printCertificateByRegistrar(request, response);
			}
			if (selectValue == 2) {
				printContingentBillRem(request, response);
			}
			if (selectValue == 3) {
				printIdentificationCard(request, response);
			}
		}
		jsp = "md_contingentBillReembersementMsg" + ".jsp";
		map.put("contigentMedicalBill_Id", contigentMedicalBill_Id);
		map.put("specialInvId", specialInvId);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView printRembersementOfContingentBill(
			HttpServletRequest request, HttpServletResponse response) {
		String Id = "";
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> connectionMap = medicalClaimHandlerService
				.getConnectionForReport();
		if (request.getParameter("Id") != null) {
			Id = request.getParameter("Id");

		}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		parameters.put("entryno", Id);

		try {

			HMSUtil.generateReport("Reimbursement_Medical_Claims_Respect",
					parameters, (java.sql.Connection) connectionMap.get("con"),
					response, getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView printCardiacUndertakingDefencePer(
			HttpServletRequest request, HttpServletResponse response) {
		int Id = 0;
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> connectionMap = medicalClaimHandlerService
				.getConnectionForReport();
		if (request.getParameter("id") != null) {
			Id = Integer.parseInt(request.getParameter("id"));

		}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		parameters.put("id", Id);

		try {

			HMSUtil.generateReport(
					"Undertaking_Defence_personnel_for_obtaining", parameters,
					(java.sql.Connection) connectionMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView printCardiacCertificateToPatient(
			HttpServletRequest request, HttpServletResponse response) {
		int Id = 0;
		Map<String, Object> parameters = new HashMap();
		Map<String, Object> connectionMap = medicalClaimHandlerService
				.getConnectionForReport();
		if (request.getParameter("id") != null) {
			Id = Integer.parseInt(request.getParameter("id"));

		}
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/reports/"));
		parameters.put("id", Id);

		try {

			HMSUtil.generateReport("Certificate_The_Patient_Attendant",
					parameters, (java.sql.Connection) connectionMap.get("con"),
					response, getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView printCardiacClaimAdvanceReports(
			HttpServletRequest request, HttpServletResponse response) {
		int selectValue = 0;
		String hinNo = "";
		String entryNo = "";
		String message = "";
		String id = "";

		if (request.getParameter("hinNo") != null
				&& !request.getParameter("hinNo").equals("")) {
			hinNo = request.getParameter("hinNo");
		}
		if (request.getParameter("entryNo") != null
				&& !request.getParameter("entryNo").equals("")) {
			entryNo = request.getParameter("entryNo");
		}
		if (request.getParameter("message") != null
				&& !request.getParameter("message").equals("")) {
			message = request.getParameter("message");
		}
		if (request.getParameter("Id") != null
				&& !request.getParameter("Id").equals("")) {
			id = request.getParameter("Id");
		}

		if (request.getParameter("selectReport") != null
				&& !request.getParameter("selectReport").equals("")) {
			selectValue = Integer
					.parseInt(request.getParameter("selectReport"));
		}
		if (selectValue != 0) {
			if (selectValue == 1) {
				printAdvanceCoveringLetter(request, response);
			}
			if (selectValue == 2) {
				printMedicalAdvance(request, response);
			}
			if (selectValue == 3) {
				PrintPreFactoSanction(request, response);
			}
			if (selectValue == 4) {
				printWillingnessCertificate(request, response);
			}

			if (selectValue == 6) {
				printUndertakingIdentificationCardFamilies(request, response);
			}
			if (selectValue == 7) {
				printCardiacUndertakingDefencePer(request, response);
			}
			if (selectValue == 8) {
				printCardiacCertificateToPatient(request, response);
			}
			if (selectValue == 9) {
				printPatientCertificate(request, response);
			}
			if (selectValue == 10) {
				printSpecialisedCardiacTreatment(request, response);
			}
		}
		jsp = MD_MSG_CARDIC_CLAIM;
		jsp += ".jsp";

		map.put("hinNo", hinNo);
		map.put("entryNo", entryNo);
		map.put("id", id);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	public ModelAndView printCardiacClaimReimbrusmentReports(
			HttpServletRequest request, HttpServletResponse response) {
		int selectValue = 0;
		String hinNo = "";
		String entryNo = "";
		String message = "";
		String cardicContigentId = "";
		String serviceTypeId = "";

		if (request.getParameter("hinNo") != null
				&& !request.getParameter("hinNo").equals("")) {
			hinNo = request.getParameter("hinNo");
		}
		if (request.getParameter("entryNo") != null
				&& !request.getParameter("entryNo").equals("")) {
			entryNo = request.getParameter("entryNo");
		}
		if (request.getParameter("message") != null
				&& !request.getParameter("message").equals("")) {
			message = request.getParameter("message");
		}
		if (request.getParameter("cardicContigentId") != null
				&& !request.getParameter("cardicContigentId").equals("")) {
			cardicContigentId = request.getParameter("cardicContigentId");
		}
		if (request.getParameter("serviceTypeId") != null
				&& !request.getParameter("serviceTypeId").equals("")) {
			serviceTypeId = request.getParameter("serviceTypeId");
		}
		if (request.getParameter("selectReport") != null
				&& !request.getParameter("selectReport").equals("")) {
			selectValue = Integer
					.parseInt(request.getParameter("selectReport"));
		}
		if (selectValue != 0) {
			if (selectValue == 1) {
				printContingentBillReimb(request, response);
			}
			if (selectValue == 2) {
				printAuthorisedmedicalAttendent(request, response);
			}
			if (selectValue == 3) {
				printDependentCertificate(request, response);
			}
			/*
			 * if(selectValue==4) { printContingentBill(request,response); }
			 */
			if (selectValue == 5) {
				printWillingnessCertificate(request, response);
			}
			if (selectValue == 6) {
				printPostFactoSanction(request, response);
			}

		}
		jsp = RequestConstants.MD_MSG_CONTINGENT;
		jsp += ".jsp";

		map.put("hinNo", hinNo);
		map.put("entrySeqNo", entryNo);
		map.put("serviceTypeId", serviceTypeId);
		map.put("cardicContigentId", cardicContigentId);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}
	public ModelAndView showSpecInvReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Spec Inv Admission";

		jsp = MD_SPEC_INV_REPORT;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView printSpecialInvestigationReport1(HttpServletRequest request,HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();
		String query="";
		String serviceNo="";
		try {
		if(request.getParameter(FROM_DATE) != null  || request.getParameter("serviceNo") !=null){
				query="where";
		
		
			if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE)));
			
			   query =  query + " hd.date between '"+ fromDate + "' and '" + toDate + "'";
			}
			
			if (request.getParameter("serviceNo") != null && !(request.getParameter("serviceNo").equals(""))) {
				serviceNo = request.getParameter("serviceNo");
				if(query != "where")
				{		query = query +" and  p.service_no = '"+ serviceNo+ "'";
				
				}
				else{
					query = query +" p.service_no = '"+ serviceNo+ "'";
				}
				
			}
		}	

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("QUERY", query);
		try {
					HMSUtil.generateReport("md_Special_Investigation_Admission", parameters,
							(java.sql.Connection) detailsMap.get("con"), response,
							getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
	return null;

	}

public ModelAndView showContBillReimReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Cont Bill Reim";

		jsp = MD_CONTINGENT_BILL_REIMBUR;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView printContingentBillRemReport(HttpServletRequest request,HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		String query = "";
		String serviceNo="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap1 = new HashMap<String, Object>();

			Map<String, Object> detailsMap;
			try {
				if(request.getParameter(FROM_DATE) != null  || request.getParameter("serviceNo") !=null){
					query="where";
					
				if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
					fromDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)));
				}
				if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
					toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE)));
					query = query + " hd.entry_date between '"+ fromDate + "' and '" + toDate + "'";
				}

				
				if (request.getParameter("serviceNo") != null && !(request.getParameter("serviceNo").equals(""))) {
					serviceNo = request.getParameter("serviceNo");
					if(query != "where")
					{		query = query +" and  p.service_no = '"+ serviceNo+ "'";
					
					}
					else{
						query = query +" p.service_no = '"+ serviceNo+ "'";
					}
					
				}
			}	
			} catch (RuntimeException e1) {
				
				e1.printStackTrace();
			}
			detailsMap = medicalClaimHandlerService.getConnectionForReport();
			parameters.put("QUERY", query);
		try {

			HMSUtil.generateReport("md_Continent_Bill_Reimbursement", parameters,
					(java.sql.Connection) detailsMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

public ModelAndView showIdentificationServiceReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Identification Service personnel";

		jsp = MD_IDENT_SERVICE_PERSONNEL;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

public ModelAndView printIdentificationServiceReport(HttpServletRequest request,
			HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		String query = "";
		String serviceNo="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();

			Map<String, Object> detailsMap;
			try {
				
				if(request.getParameter(FROM_DATE) != null  || request.getParameter("serviceNo") !=null){
					query="where";
					
					if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
						fromDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)));
					}
					if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
						toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE)));
						query = query +" md_contigent_medical_bill_hd.entry_date between '"+ fromDate + "' and '" + toDate + "'";
					}
	
					if (request.getParameter("serviceNo") != null && !(request.getParameter("serviceNo").equals(""))) {
						serviceNo = request.getParameter("serviceNo");
						if(query != "where")
						{		
							query = query +" and  patient.service_no = '"+ serviceNo+ "'";
						
						}
						else{
							query = query +" patient.service_no = '"+ serviceNo+ "'";
						}
						
					}
			  }	// end if
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			}
			detailsMap = medicalClaimHandlerService.getConnectionForReport();
			parameters.put("QUERY", query);
		try {

			HMSUtil.generateReport("md_identification_for_service_personnel", parameters,
					(java.sql.Connection) detailsMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

public ModelAndView showGeneralCoveringLettereReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "General Covering Letter";

		jsp = MD_GENERAL_COVERING_LTR;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

public ModelAndView printGeneralCoveringLettereReport(HttpServletRequest request,HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();

			Map<String, Object> detailsMap;
			try {
				if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
					fromDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)));
				}
				if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
					toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE)));
				}

				query = " where md_covering_letter_unit_hd.entry_date between '"+ fromDate + "' and '" + toDate + "'";
				
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			}
			detailsMap = medicalClaimHandlerService.getConnectionForReport();
			parameters.put("QUERY", query);
		try {

			HMSUtil.generateReport("md_general_covering_letter", parameters,
					(java.sql.Connection) detailsMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

public ModelAndView showApplicationMedicalAdReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Application Medical Advance";

		jsp = MD_APP_MEDICAL_AD_REPORT;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView printApplicationMedicalAdReport(HttpServletRequest request,HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		String query = "";
		String serviceNo="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();

			Map<String, Object> detailsMap;
			try {
				if(request.getParameter(FROM_DATE) != null  || request.getParameter("serviceNo") !=null){
					query="where";
				if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
					fromDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)));
				}
				if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
					toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE)));
					query = query+ " md_cardic_claim_advance.entry_date between '"+ fromDate + "' and '" + toDate + "'";
				}

				
				if (request.getParameter("serviceNo") != null && !(request.getParameter("serviceNo").equals(""))) {
					serviceNo = request.getParameter("serviceNo");
					if(query != "where")
					{		
						query = query +" and  patient.service_no = '"+ serviceNo+ "'";
					
					}
					else{
						query = query +" patient.service_no = '"+ serviceNo+ "'";
					}
					
				}
		  }	// end if
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			}
			detailsMap = medicalClaimHandlerService.getConnectionForReport();
			parameters.put("QUERY", query);
		try {

			HMSUtil.generateReport("md_applicationformedicaladvanceReport", parameters,
					(java.sql.Connection) detailsMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

public ModelAndView showAdvanceCoveringLtrReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Advance covering letter";

		jsp = MD_ADVANCE_COVER_LTR_UNIT;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView printAdvanceCoveringLtrReport(HttpServletRequest request,HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		String query = "";
		String serviceNo="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();

			Map<String, Object> detailsMap;
			try {
				if(request.getParameter(FROM_DATE) != null  || request.getParameter("serviceNo") !=null){
					query="where";
					
				if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
					fromDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)));
				}
				if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
					toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE)));
					query = query + " md_cardic_claim_advance.entry_date between '"+ fromDate + "' and '" + toDate + "'";
				}
				
				if (request.getParameter("serviceNo") != null && !(request.getParameter("serviceNo").equals(""))) {
					serviceNo = request.getParameter("serviceNo");
					if(query != "where")
					{		
						query = query +" and  patient.service_no = '"+ serviceNo+ "'";
					
					}
					else{
						query = query +" patient.service_no = '"+ serviceNo+ "'";
					}
					
				}
		  }	// end if
				
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			}
			detailsMap = medicalClaimHandlerService.getConnectionForReport();
			parameters.put("QUERY", query);
		try {

			HMSUtil.generateReport("md_advance_Covering_Letter_UnitsReport", parameters,
					(java.sql.Connection) detailsMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}


public ModelAndView showPreFactoReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "pre facto sanction";

		jsp = MD_PRE_FACTO_SANCTION_REPORT;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView printPreFactoSanctionReport(HttpServletRequest request,HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		String query = "";
		String serviceNo="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();

			Map<String, Object> detailsMap;
			try {
				if(request.getParameter(FROM_DATE) != null  || request.getParameter("serviceNo") !=null){
					query="where";
				if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
					fromDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)));
				}
				if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
					toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE)));
					query = query +" md_cardic_claim_advance.entry_date between '"+ fromDate + "' and '" + toDate + "'";
					
				}
				if (request.getParameter("serviceNo") != null && !(request.getParameter("serviceNo").equals(""))) {
					serviceNo = request.getParameter("serviceNo");
					if(query != "where")
					{		
						query = query +" and  patient.service_no = '"+ serviceNo+ "'";
					
					}
					else{
						query = query +" patient.service_no = '"+ serviceNo+ "'";
					}
					
				}
		  }	// end if
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			}
			detailsMap = medicalClaimHandlerService.getConnectionForReport();
			parameters.put("QUERY", query);
		try {

			HMSUtil.generateReport("md_pre_facto_sanction_cardiac_ARMY", parameters,
					(java.sql.Connection) detailsMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}


public ModelAndView showPostFactoReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "post facto sanction";

		jsp = MD_POST_FACTO_SANCTION_REPORT;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView printPostFactoSanctionReport(HttpServletRequest request,HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		String query = "";
		String serviceNo="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();

			Map<String, Object> detailsMap;
			try {
				if(request.getParameter(FROM_DATE) != null  || request.getParameter("serviceNo") !=null){
					query="where";
				
				if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
					fromDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)));
				}
				if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
					toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE)));
					query = query+" md_cardic_contingent_bill_hd.entry_date between '"+ fromDate + "' and '" + toDate + "'";
				}

				if (request.getParameter("serviceNo") != null && !(request.getParameter("serviceNo").equals(""))) {
					serviceNo = request.getParameter("serviceNo");
					if(query != "where")
					{		
						query = query +" and  patient.service_no = '"+ serviceNo+ "'";
					
					}
					else{
						query = query +" patient.service_no = '"+ serviceNo+ "'";
					}
					
				}
		  }	// end if
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			}
			detailsMap = medicalClaimHandlerService.getConnectionForReport();
			parameters.put("QUERY", query);
		try {

			HMSUtil.generateReport("md_post_facto_sanction_cardiac_ARMY", parameters,
					(java.sql.Connection) detailsMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

public ModelAndView showEntitlementCardFamReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Application Medical Advance";

		jsp = MD_ENTITLE_CARD_FAMLY;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView printEntitlementCardFamReport(HttpServletRequest request,HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		String query = "";
		String serviceNo="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();

			Map<String, Object> detailsMap;
			try {
				if(request.getParameter(FROM_DATE) != null  || request.getParameter("serviceNo") !=null){
					query="where";
				if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
					fromDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)));
				}
				if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
					toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE)));
				}

				query = query+" md_cardic_claim_advance.entry_date between '"+ fromDate + "' and '" + toDate + "'";
				
				if (request.getParameter("serviceNo") != null && !(request.getParameter("serviceNo").equals(""))) {
					serviceNo = request.getParameter("serviceNo");
					if(query != "where")
					{		
						query = query +" and  patient.service_no = '"+ serviceNo+ "'";
					
					}
					else{
						query = query +" patient.service_no = '"+ serviceNo+ "'";
					}
					
				}
		  }	// end if
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			}
			detailsMap = medicalClaimHandlerService.getConnectionForReport();
			parameters.put("QUERY", query);
		try {

			HMSUtil.generateReport("md_Entitlement_Card_For_Families", parameters,
					(java.sql.Connection) detailsMap.get("con"), response,
					getServletContext());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public ModelAndView showSpecialisedTreatmentReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Specialised cardic Treatment";

		jsp = MD_SPEC_CARDIC_TREATMENT;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView printSpecialisedTreatmentReport(HttpServletRequest request,HttpServletResponse response) {
		String fromDate = null;
		String toDate = null;
		String query = "";
		String serviceNo="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();

		try {
			if(request.getParameter(FROM_DATE) != null  || request.getParameter("serviceNo") !=null){
				query="where";
			if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)));
			}
			if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE)));
			}
			query = query+" md_cardic_claim_advance.entry_date between '"+ fromDate + "' and '" + toDate + "'";
			
			if (request.getParameter("serviceNo") != null && !(request.getParameter("serviceNo").equals(""))) {
				serviceNo = request.getParameter("serviceNo");
				if(query != "where")
				{		
					query = query +" and  patient.service_no = '"+ serviceNo+ "'";
				
				}
				else{
					query = query +" patient.service_no = '"+ serviceNo+ "'";
				}
				
			}
	  }	// end if

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = medicalClaimHandlerService.getConnectionForReport();
		parameters.put("QUERY", query);
		try {
					HMSUtil.generateReport("md_specialised_cardiac_treatment", parameters,
							(java.sql.Connection) detailsMap.get("con"), response,
							getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
	return null;

	}
	@SuppressWarnings("unchecked")
	public ModelAndView validateContingentBill(HttpServletRequest request,
			HttpServletResponse response) {
      Map<String, Object> map = new HashMap<String, Object>();
      Map<String, Object> infoMap = new HashMap<String, Object>();
      Map<String, Object> utilMap = new HashMap<String, Object>();
      utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
      HttpSession session = request.getSession();
      int chargeListLength = 0;
      int specialInvId=0;
      List chargeList = new ArrayList();
      List contingentDetailIdList = new ArrayList();
      String diagnosis =""; 
      String userName = (String) session.getAttribute("userName");
      String date = "";
      String time = "";
      String claimType = "";
      String changedBy = "";
      String submissionDate = "";
      submissionDate = (String) utilMap.get("currentDate");
      date = (String) utilMap.get("currentDate");
      time = (String) utilMap.get("currentTime");
      String entrySeqNo = "";
      String billNo = "";
      String payableTo = "";
      String accountOfficer = "";

      BigDecimal amount = null;
      BigDecimal qualifyigAmt = null;
      BigDecimal receivedRs = null;
      int fwtTo = 0;
      int hinId = 0;
      int inpatientId = 0;
      int departmentId = (Integer) session.getAttribute("deptId");
      int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
      int contHdId = 0;
      if((request.getParameter("contHdId")) != null && (Integer.parseInt(request.getParameter("contHdId")) != 0 )){
    	  contHdId =  Integer.parseInt(request.getParameter("contHdId"));
      }
      MdContigentMedicalBillHd contigentMedicalBillHd = new MdContigentMedicalBillHd();
      contigentMedicalBillHd = medicalClaimHandlerService.loadContBillObj(contHdId);
      
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter("specialhdId") != null
				&& !request.getParameter("specialhdId").equals("")) {
			specialInvId = Integer
					.parseInt(request.getParameter("specialhdId"));
		}
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			contigentMedicalBillHd.setHin(patient);
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter("diagnosis") != null
				&& !request.getParameter("diagnosis").equals("0")) {
			diagnosis = request.getParameter("diagnosis");
		}
		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(hinId);
			contigentMedicalBillHd.setInpatient(inpatient);
		}
		contigentMedicalBillHd.setWorkingDiagnosis(diagnosis);
		if (request.getParameter(ENTRY_NO) != null) {
			entrySeqNo = request.getParameter(ENTRY_NO);
		}
		// String temp = medicalClaimHandlerService.generateEntryNumber();
		contigentMedicalBillHd.setEntryNo(entrySeqNo);

		contigentMedicalBillHd.setEntryDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		if (request.getParameter(CLAIM_TYPE) != null
				&& !(request.getParameter(CLAIM_TYPE).equals(""))) {
			claimType = request.getParameter(CLAIM_TYPE);
		}
		contigentMedicalBillHd.setClaimType(claimType);
		if (request.getParameter(BILL_NO) != null
				&& !request.getParameter(BILL_NO).equals("0")) {
			billNo = request.getParameter(BILL_NO);
		}
		contigentMedicalBillHd.setBillNo(billNo);
		contigentMedicalBillHd.setBillDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		if (request.getParameter(AMOUNT) != null) {
			amount = new BigDecimal(request.getParameter(AMOUNT));
		}
		contigentMedicalBillHd.setAmount(amount);
		if (request.getParameter(QUALIFYING_RS) != null) {
			qualifyigAmt = new BigDecimal(request.getParameter(QUALIFYING_RS));
		}
		contigentMedicalBillHd.setQualifyingAmount(qualifyigAmt);
		if (request.getParameter(RECEIVED_RS) != null) {
			receivedRs = new BigDecimal(request.getParameter(RECEIVED_RS));
		}
		contigentMedicalBillHd.setReceivedRs(receivedRs);
		if (request.getParameter(PAYABLE_TO) != null
				&& !request.getParameter(PAYABLE_TO).equals("0")) {
			payableTo = request.getParameter(PAYABLE_TO);
		}
		contigentMedicalBillHd.setPayableTo(payableTo);
		if (request.getParameter(NAME_PAY_OFFICER) != null
				&& !request.getParameter(NAME_PAY_OFFICER).equals("0")) {
			accountOfficer = request.getParameter(NAME_PAY_OFFICER);
		}
		contigentMedicalBillHd.setAccountOfficer(accountOfficer);
		contigentMedicalBillHd.setSubmissionDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		if (request.getParameter(AUTHORITY_ID) != null
				&& !request.getParameter(AUTHORITY_ID).equals("0")) {
			fwtTo = Integer.parseInt(request.getParameter(AUTHORITY_ID));
		}
		MdMasAuthority masAuthority = new MdMasAuthority();
		masAuthority.setId(fwtTo);
		contigentMedicalBillHd.setFwtTo(masAuthority);

		contigentMedicalBillHd.setReceivedRs(receivedRs);
		if (request.getParameter(PAYABLE_TO) != null
				&& !request.getParameter(PAYABLE_TO).equals("0")) {
			payableTo = request.getParameter(PAYABLE_TO);
		}
		contigentMedicalBillHd.setFwtDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		String hinNo = "";
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			contigentMedicalBillHd.setHospital(masHospital);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			contigentMedicalBillHd.setDepartment(masDepartment);
		}
		contigentMedicalBillHd.setDispatchStatus("A");
		contigentMedicalBillHd.setLastChgBy(userName);
		contigentMedicalBillHd.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		contigentMedicalBillHd.setLastChgTime(time);

		infoMap.put("contigentMedicalBillHd", contigentMedicalBillHd);
		if (request.getParameter("hiddenValueCharge") != null) {
			chargeListLength = Integer.parseInt(request
					.getParameter("hiddenValueCharge"));
		}
		int i = 1;
		for (int a = 1; a <= chargeListLength; a++) {
			if (request.getParameter(CHARGE_CODE_ID + i) != null
					&& !request.getParameter(CHARGE_CODE_ID + i).equals("")) {
				chargeList.add(request.getParameter(CHARGE_CODE_ID + i));

			} else {
				chargeList.add("");
			}

			if (request.getParameter(CONTINGENT_BILL_DETAIL_ID + i) != null) {
				contingentDetailIdList.add(request
						.getParameter(CONTINGENT_BILL_DETAIL_ID + i));
			} else {
				contingentDetailIdList.add("");
			}

			i++;
		}

      infoMap.put("entrySeqNo", entrySeqNo);
      infoMap.put("userName", userName);
      infoMap.put("chargeList", chargeList);
      infoMap.put("contingentDetailIdList", contingentDetailIdList);

      boolean saved = false;
      String message = "";
      infoMap = medicalClaimHandlerService.validateContBill(infoMap);
      map = medicalClaimHandlerService.showPatientSearchForContingentBill();
      String jsp ="";
		if (infoMap.get("saved").equals(true)) {
			message = "Data Updated Successfully !! Please select the report which you want to print. ";
			jsp = "md_contingentBillReembersementMsg" + ".jsp";
		} else {
			message = "Error Occured !! Try Again!";
			jsp = MD_SEARCH_CONTIGENT_REM_MEDICAL_BILL + ".jsp";
		}
		map.put("contigentMedicalBill_Id", infoMap
				.get("contigentMedicalBill_Id"));
		map.put("specialInvId", specialInvId);
		map.put("entrySeqNo", entrySeqNo);
		map.put("hinNo", hinNo);
		map.put("message", message);
		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}
	public ModelAndView showApprovePatientSearchContBill(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = medicalClaimHandlerService.showApprovePatientSearchContBill();
		jsp = MD_SEARCH_CONT_REM_MEDICAL + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView showApprovePatientContBill(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		int rankId = 0;
		String serPersonFName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientLName = "";
		String patientStatus = "";
		int hinId = 0;
		int contHdId = 0;
		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
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
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDs.put("patientLName", patientLName);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(S_LAST_NAME) != null
					&& !(request.getParameter(S_LAST_NAME).equals(""))) {
				serPersonLName = request.getParameter(S_LAST_NAME);
				mapForDs.put("serPersonLName", serPersonLName);
			}
			if (request.getParameter(RANK_ID) != null
					&& !(request.getParameter(RANK_ID).equals("0"))) {
				rankId = Integer.parseInt(request.getParameter(RANK_ID));
				mapForDs.put("rankId", rankId);
			}
			if (request.getParameter("hinId") != null
					&& !(request.getParameter("hinId").equals("0"))) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter("contHdId") != null
					&& !(request.getParameter("contHdId").equals("0"))) {
				contHdId = Integer.parseInt(request
						.getParameter("contHdId"));

				mapForDs.put("contHdId", contHdId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = medicalClaimHandlerService
				.getApprovePatientContBillDetails(mapForDs);
		String jsp = "";
      List<MdContigentMedicalBillHd> specialInvHdList = new ArrayList<MdContigentMedicalBillHd>();
      List<MdMasAuthority> authorityList = new ArrayList<MdMasAuthority>();

		if (contHdId != 0) {
			detailsMap = medicalClaimHandlerService
					.getApprovePatientContingentBill(mapForDs);
			
			specialInvHdList = (List) detailsMap.get("specialInvHdList");
			authorityList = (List) detailsMap.get("authorityList");
			/*String entrySeqNo = "";
			entrySeqNo = medicalClaimHandlerService
					.getEntrySeqForDisplay("CMEN");
			if (entrySeqNo != null) {
				map.put("entrySeqNo", entrySeqNo);
			}*/
			
			jsp = MD_APPROVE_CONT_REM_MEDICAL + ".jsp";
		} else {
			map = medicalClaimHandlerService
					.showApprovePatientSearchContBill();
			jsp = MD_SEARCH_CONT_REM_MEDICAL + ".jsp";
		}
		map.put("authorityList", authorityList);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		map.put("specialInvHdList", specialInvHdList);
		return new ModelAndView("indexB", "map", map);
	}
	// ----------------------------------------------------------------------------------------------
	public MedicalClaimHandlerService getMedicalClaimHandlerService() {
		return medicalClaimHandlerService;
	}

	public void setMedicalClaimHandlerService(
			MedicalClaimHandlerService medicalClaimHandlerService) {
		this.medicalClaimHandlerService = medicalClaimHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
