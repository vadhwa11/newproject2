//------------------------------BLOOD BANK BY DIPALI--------------------------------
package jkt.hms.bloodBank.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.bloodBank.handler.BloodBankHandlerService;
import jkt.hms.masters.business.BloodDiscardEntry;
import jkt.hms.masters.business.BloodDonationEntryDetail;
import jkt.hms.masters.business.BloodDonationEntryHeader;
import jkt.hms.masters.business.BloodDonorSampleScreeningHeader;
import jkt.hms.masters.business.BloodIssueHeader;
import jkt.hms.masters.business.BloodMasComponent;
import jkt.hms.masters.business.BloodReactionEntry;
import jkt.hms.masters.business.BloodRequestEntryHeader;
import jkt.hms.masters.business.BloodSampleCollection;
import jkt.hms.masters.business.BloodSampleScreeningHeader;
import jkt.hms.masters.business.BloodStockDetail;
import jkt.hms.masters.business.BloodStockMain;
import jkt.hms.masters.business.BloodTestEntryHeader;
import jkt.hms.masters.business.BloodTransfusion;
import jkt.hms.masters.business.BloodTransfussionReactionHd;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class BloodBankController extends MultiActionController {
	BloodBankHandlerService bloodBankHandlerService;
	CommonMasterHandlerService commonMasterHandlerService;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String jsp = "";
	String title = "";
	String message = "";
	String url = "";
	String code = "";
	String name = "";
	String jspName = "";
	String pojoName = "";
	Date currentDate = new Date();
	String currentTime = "";
	HttpSession session = null;
	String userName = "";
	String changedBy = "";

	// ----------Blood Component Master-----------------
	@SuppressWarnings("unchecked")
	public ModelAndView showBloodComponentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = (Map<String, Object>) bloodBankHandlerService
				.showBloodComponentJsp();
		jsp = BLOOD_COMPONENT;
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchBloodComponent(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String bloodComponentCode = null;
		String bloodComponentName = null;
		String searchField = null;
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bloodComponentCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bloodComponentName = request.getParameter(SEARCH_NAME);
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
			bloodComponentCode = searchField;
			bloodComponentName = null;

		} else {
			bloodComponentCode = null;
			bloodComponentName = searchField;
		}
		map = bloodBankHandlerService.searchBloodComponent(bloodComponentCode,
				bloodComponentName);
		jsp = BLOOD_COMPONENT;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("bloodComponentCode", bloodComponentCode);
		map.put("bloodComponentName", bloodComponentName);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBloodComponent(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		BloodMasComponent bloodMasComponent = new BloodMasComponent();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String wholeBlood = "";
		int qtyUnit = 0;
		int temperature = 0;
		int lifeSpan = 0;

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(LIFE_SPAN) != null
				&& !request.getParameter(LIFE_SPAN).equals("")) {
			lifeSpan = Integer.parseInt(request.getParameter(LIFE_SPAN));
		}
		if (request.getParameter(TEMPERATURE) != null
				&& !request.getParameter(TEMPERATURE).equals("")) {
			temperature = Integer.parseInt(request.getParameter(TEMPERATURE));
		}
		if (request.getParameter(QTY_PER_UNIT) != null
				&& !request.getParameter(QTY_PER_UNIT).equals("")) {
			qtyUnit = Integer.parseInt(request.getParameter(QTY_PER_UNIT));
		}
		if (request.getParameter(WHOLE_BLOOD) != null) {
			wholeBlood = request.getParameter(WHOLE_BLOOD);
		}
		String days = "";
		if (request.getParameter(DAYS) != null) {
			days = request.getParameter(DAYS);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
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

		List bloodComponentCodeList = new ArrayList();
		List bloodComponentNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			bloodComponentCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			bloodComponentNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((bloodComponentCodeList.size() == 0 || bloodComponentCodeList == null)
				&& (bloodComponentNameList.size() == 0 || bloodComponentNameList == null)) {
			bloodMasComponent.setComponentCode(code);
			bloodMasComponent.setComponentName(name);
			bloodMasComponent.setTemperature(temperature);
			bloodMasComponent.setLifeSpan(lifeSpan);
			bloodMasComponent.setQtyUnit(qtyUnit);
			bloodMasComponent.setPeriod(days);
			bloodMasComponent.setWholeBlood(wholeBlood);
			bloodMasComponent.setStatus("y");
			bloodMasComponent.setLastChgBy(changedBy);
			bloodMasComponent.setLastChgDate(currentDate);
			bloodMasComponent.setLastChgTime(currentTime);
			successfullyAdded = bloodBankHandlerService
					.addBloodComponent(bloodMasComponent);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((bloodComponentCodeList.size() != 0 || bloodComponentCodeList != null)
				|| (bloodComponentNameList.size() != 0)
				|| bloodComponentNameList != null) {
			if ((bloodComponentCodeList.size() != 0 || bloodComponentCodeList != null)
					&& (bloodComponentNameList.size() == 0 || bloodComponentNameList == null)) {
				message = "Component Code  already exists.";
			} else if ((bloodComponentNameList.size() != 0 || bloodComponentNameList != null)
					&& (bloodComponentCodeList.size() == 0 || bloodComponentCodeList == null)) {
				message = "Component Name already exists.";
			} else if ((bloodComponentCodeList.size() != 0 || bloodComponentCodeList != null)
					&& (bloodComponentNameList.size() != 0 || bloodComponentNameList != null)) {
				message = "Component Code and Component Name already exist.";
			}
		}
		url = "/hms/hms/bloodBank?method=showBloodComponentJsp";
		try {
			map = bloodBankHandlerService.showBloodComponentJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BLOOD_COMPONENT;
		title = "Add Blood Component";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView editBloodComponent(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String bloodComponentCode = "";
		String bloodComponentName = "";
		String wholeBlood = "";
		int qtyUnit = 0;
		int temperature = 0;
		int lifeSpan = 0;
		int bloodComponentId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		Date currentDate = new Date();

		if (request.getParameter(BLOOD_COMPONENT_ID) != null
				&& !(request.getParameter(BLOOD_COMPONENT_ID).equals(""))) {
			bloodComponentId = Integer.parseInt(request
					.getParameter(BLOOD_COMPONENT_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bloodComponentCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bloodComponentName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(LIFE_SPAN) != null
				&& !(request.getParameter(LIFE_SPAN).equals(""))) {
			lifeSpan = Integer.parseInt(request.getParameter(LIFE_SPAN));
		}
		if (request.getParameter(TEMPERATURE) != null
				&& !(request.getParameter(TEMPERATURE).equals(""))) {
			temperature = Integer.parseInt(request.getParameter(TEMPERATURE));
		}
		if (request.getParameter(QTY_PER_UNIT) != null
				&& !(request.getParameter(TEMPERATURE).equals("0"))) {
			qtyUnit = Integer.parseInt(request.getParameter(QTY_PER_UNIT));
		}
		if (request.getParameter(WHOLE_BLOOD) != null) {
			wholeBlood = request.getParameter(WHOLE_BLOOD);
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

		generalMap.put("id", bloodComponentId);
		generalMap.put("bloodComponentCode", bloodComponentCode);
		generalMap.put("name", bloodComponentName);
		generalMap.put("lifeSpan", lifeSpan);
		generalMap.put("temperature", temperature);
		generalMap.put("qtyUnit", qtyUnit);
		generalMap.put("wholeBlood", wholeBlood);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBloodComponentNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingBloodComponentNameList.size() == 0) {
			dataUpdated = bloodBankHandlerService
					.editBloodComponent(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBloodComponentNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/bloodBank?method=showBloodComponentJsp";
		try {
			map = bloodBankHandlerService.showBloodComponentJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BLOOD_COMPONENT;
		title = "Update Blood Component";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView deleteBloodComponent(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int bloodComponentId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(BLOOD_COMPONENT_ID) != null
				&& !(request.getParameter(BLOOD_COMPONENT_ID).equals(""))) {
			bloodComponentId = Integer.parseInt(request
					.getParameter(BLOOD_COMPONENT_ID));
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
		dataDeleted = bloodBankHandlerService.deleteBloodComponent(
				bloodComponentId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/bloodBank?method=showBloodComponentJsp";
		try {
			map = bloodBankHandlerService.showBloodComponentJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BLOOD_COMPONENT;
		title = "Delete Blood Component";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// --------Consent for Blood TransfusionEntry------------

	public ModelAndView showPatientSearchForBloodTransfusionJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = bloodBankHandlerService.showPatientSearchForBloodTransfusionJsp();
		jsp = SEARCH_BLOOD_TRANSFUSION + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchPatientForBloodTransfusion(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		String patientFName = "";
		String patientLName = "";
		int inpatientId = 0;
		int hinId = 0;
		int rankId = 0;
		String deptName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			mapForDs.put("inpatientId", inpatientId);
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
		if (request.getParameter(AD_NO) != null
				&& !(request.getParameter(AD_NO).equals(""))) {
			adNo = request.getParameter(AD_NO);
			mapForDs.put("adNo", adNo);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals("0"))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			mapForDs.put("hinId", hinId);
		}
		if (request.getParameter(RANK_ID) != null
				&& !(request.getParameter(RANK_ID).equals(""))) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			mapForDs.put("rankId", rankId);
		}
		patientMap = bloodBankHandlerService
				.getPatientForBloodTransfusion(mapForDs);
		map = bloodBankHandlerService.showPatientSearchForBloodTransfusionJsp();

		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showConsentBloodTransfusion(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int inpatientId = 0;
		if (request.getParameter("inpatientId") != null
				&& !(request.getParameter("inpatientId").equals("0"))) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			mapForDS.put("inpatientId", inpatientId);
		}
		if (inpatientId != 0) {
			map = bloodBankHandlerService
					.showConsentBloodTransfusion(inpatientId);
			int entrySeqNo = 0;
			entrySeqNo = bloodBankHandlerService
					.getTransfusionEntrySeqForDisplay("TEN");
			if (entrySeqNo != 0) {
				map.put("entrySeqNo", entrySeqNo);
			}
		}
		jsp = BLOOD_TRANSFUSION_ENTRY + ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitBloodTransfusion(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();

		int inpatientId = 0;
		int hinId = 0;
		int componentId = 0;
		int entrySeqNo = 0;

		String witnessName = "";
		String date = "";
		String time = "";
		String hinNo = "";
		String adNo = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(BLOOD_COMPONENT_ID) != null
				&& !request.getParameter(BLOOD_COMPONENT_ID).equals("0")) {
			componentId = Integer.parseInt(request
					.getParameter(BLOOD_COMPONENT_ID));
		}
		if (request.getParameter(ENTRY_NO) != null
				&& !request.getParameter(ENTRY_NO).equals("")) {
			entrySeqNo = Integer.parseInt(request.getParameter(ENTRY_NO));
		}
		if (request.getParameter(WITNESS_NAME) != null
				&& !request.getParameter(WITNESS_NAME).equals("")) {
			witnessName = request.getParameter(WITNESS_NAME);
		}
		if (request.getParameter(HIN_NO) != null
				&& !request.getParameter(HIN_NO).equals("")) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter(AD_NO) != null
				&& !request.getParameter(AD_NO).equals("")) {
			adNo = request.getParameter(AD_NO);
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

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		BloodTransfusion bloodTransfusion = new BloodTransfusion();
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			bloodTransfusion.setHin(patient);
		}
		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			bloodTransfusion.setInpatient(inpatient);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			bloodTransfusion.setDepartment(masDepartment);
		}
		if (componentId != 0) {
			BloodMasComponent bloodMasComponent = new BloodMasComponent();
			bloodMasComponent.setId(componentId);
			bloodTransfusion.setComponent(bloodMasComponent);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			bloodTransfusion.setHospital(masHospital);
		}
		bloodTransfusion.setWitnessName(witnessName);

		bloodTransfusion.setEntryNo(entrySeqNo);
		int temp = bloodBankHandlerService.generateTransfusionEntryNumber();

		bloodTransfusion.setEntryDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		bloodTransfusion.setLasChgBy(userName);
		bloodTransfusion.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		bloodTransfusion.setLastChgTime(time);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("componentId", componentId);
		infoMap.put("hinId", hinId);
		infoMap.put("inpatientId", inpatientId);
		infoMap.put("entrySeqNo", entrySeqNo);

		String jsp = "";
		String message = "";
		if (returnMap.get("entrySeqNo") != null) {
			entrySeqNo = (Integer) returnMap.get("entrySeqNo");
		}

		boolean saved = false;
		saved = bloodBankHandlerService
				.submitBloodTransfusion(bloodTransfusion);
		if (saved) {
			message = "Blood Transfusion entry has been done Successfully !! Do you want to print ?";
		} else {
			message = "Try Again!";
		}

		jsp = BLD_MSG_TRANSFUSION_ENTRY + ".jsp";
		map.put("hinNo", hinNo);
		map.put("adNo", adNo);
		map.put("entrySeqNo", entrySeqNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printBloodTransfusion(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";

		try {

			if (request.getParameter("entryNo") != null
					&& (!request.getParameter("entryNo").equals(""))) {
				query = "where blood_transfusion.`entry_no` = '"
						+ request.getParameter("entryNo") + "' ";
			}
			if (request.getParameter("adNo") != null
					&& (!request.getParameter("adNo").equals(""))) {
				query = query + "AND inpatient.`ad_no` = '"
						+ request.getParameter("adNo") + "' ";
			}
			if (request.getParameter("hinNo") != null
					&& (!request.getParameter("hinNo").equals(""))) {
				query = query + "AND patient.`hin_no` = '"
						+ request.getParameter("hinNo") + "' ";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = bloodBankHandlerService.getDBConnection();
		parameters.put("QUERY", query);
		try {
			response.setContentType("application/pdf");
			HMSUtil.generateReport("blood_consenttransfusion", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ------Blood Request Entry----------------------------------------
	public ModelAndView showPatientSearchForBloodRequestJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = bloodBankHandlerService.showPatientSearchForBloodRequestJsp();
		jsp = BLOOD_REQUEST_ENTRY + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchPatientForBloodRequest(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		String pType = "";
		String patientFName = "";
		String patientLName = "";
		int inpatientId = 0;
		int rankId = 0;
		int hinId = 0;
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			mapForDs.put("inpatientId", inpatientId);
		}
		if (request.getParameter(PATIENT_TYPE) != null
				&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
			pType = request.getParameter(PATIENT_TYPE);
			mapForDs.put("pType", pType);
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
				&& !(request.getParameter("hinId").equals("0"))) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
			mapForDs.put("hinId", hinId);
		}
		patientMap = bloodBankHandlerService
				.getPatientForBloodRequest(mapForDs);
		map = bloodBankHandlerService.showPatientSearchForBloodRequestJsp();
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getComponentNameForAutoComplete(HttpServletRequest request, HttpServletResponse response) {
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
		map = bloodBankHandlerService.getComponentNameForAutoComplete(parameterMap);
		String jsp = "";
		jsp = "bld_responseForComponentName";
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView getComponentNameDonationForAutoComplete(HttpServletRequest request, HttpServletResponse response) {
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
		map = bloodBankHandlerService.getComponentNameDonationForAutoComplete(parameterMap);
		String jsp = "";
		jsp = "bld_responseForComponentName";
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView getComponentNameSeparationForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {
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
		map = bloodBankHandlerService
				.getComponentNameSeparationForAutoComplete(parameterMap);
		String jsp = "";
		jsp = "bld_responseForComponentName";
		return new ModelAndView(jsp, "map", map);
	}

	public void fillItemsForComponentname(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String componentName = "";
		Calendar cal = Calendar.getInstance();
		Date myDate = null;
		int month = 0;
		int day = 0;
		String newDate ="";
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		try {
			if (request.getParameter("componentName") != null) {
				componentName = request.getParameter("componentName");
			}
			if (request.getParameter("myDate") != null) {
				myDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("myDate"));
				cal.setTime(myDate);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("componentName", componentName);

		map = bloodBankHandlerService.fillItemsForComponentname(dataMap);
		if (map.get("componentList") != null) {
			componentList = (List) map.get("componentList");
		}
		StringBuffer sb = new StringBuffer();

		sb.append("<items>");
		for (BloodMasComponent bloodMasComponent : componentList) {
			if(bloodMasComponent.getPeriod() != null)
			{
				if(bloodMasComponent.getPeriod().equalsIgnoreCase("d")){
					day = bloodMasComponent.getLifeSpan();
					cal.add(Calendar.DATE, day);
					newDate = HMSUtil.convertDateToStringWithoutTime(cal.getTime());
				 }
				else{
					month  = bloodMasComponent.getLifeSpan();
					cal.add(Calendar.MONTH, month);
					newDate = HMSUtil.convertDateToStringWithoutTime(cal.getTime());
				}

			}

			sb.append("<item>");
			sb.append("<componentId>" + bloodMasComponent.getId()
					+ "</componentId>");
			// sb.append("<componentCode>" +
			// bloodMasComponent.getComponentCode() + "</componentCode>");
			sb.append("<quantity>" + bloodMasComponent.getQtyUnit()
					+ "</quantity>");
			sb.append("<expiryDate>" + newDate	+ "</expiryDate>");

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
		//---------------------------------


	}

	public ModelAndView showBloodRequestEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int hinId = 0;
		if (request.getParameter("hinId") != null
				&& !(request.getParameter("hinId").equals("0"))) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
			mapForDS.put("hinId", hinId);
		}
		if (hinId != 0) {
			map = bloodBankHandlerService.showBloodRequestEntryJsp(hinId);
			String orderSeqNo = "";
			orderSeqNo = bloodBankHandlerService.getOrderSeqForDisplay("RON");
			if (orderSeqNo != null) {
				map.put("orderSeqNo", orderSeqNo);
			}
		}
		jsp = BLOOD_REQUEST + ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitBloodRequestEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		int componentMainIdFromRequest = 0;
		int noOfRecords = 0;
		int inpatientId = 0;
		int pageNo = 1;
		int hinId = 0;

		String orderSeqNo = "";
		String requestStatus = "";
		String hinNo = "";
		String date = "";
		String time = "";
		String requestType = "";
		String noOfBottles = "";
		String hb = "";
		String presence1 = "";
		String fever = "";
		String ofTime = "";
		String ifAny = "";
		String pregnancies = "";
		String specificReference = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		List componentList = new ArrayList();
		List qtyList = new ArrayList();

		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("BloodhdId") != null) {
			componentMainIdFromRequest = Integer.parseInt(request
					.getParameter("BloodhdId"));
		}
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(HIN_NO) != null
				&& !request.getParameter(HIN_NO).equals("")) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(ORDER_NO) != null
				&& !request.getParameter(ORDER_NO).equals("")) {
			orderSeqNo = request.getParameter(ORDER_NO);
		}
		if (request.getParameter(REQUEST_TYPE) != null
				&& !request.getParameter(REQUEST_TYPE).equals("")) {
			requestType = request.getParameter(REQUEST_TYPE);
		}
		if (request.getParameter(BOTTLES_NO) != null
				&& !request.getParameter(BOTTLES_NO).equals("")) {
			noOfBottles = request.getParameter(BOTTLES_NO);
		}
		if (request.getParameter(HB) != null
				&& !request.getParameter(HB).equals("")) {
			hb = request.getParameter(HB);
		}
		if (request.getParameter(PRESENCE1) != null
				&& !request.getParameter(PRESENCE1).equals("")) {
			presence1 = request.getParameter(PRESENCE1);
		}
		if (request.getParameter(FEVER) != null
				&& !request.getParameter(FEVER).equals("")) {
			fever = request.getParameter(FEVER);
		}
		if (request.getParameter(OF_TIME) != null
				&& !request.getParameter(OF_TIME).equals("")) {
			ofTime = request.getParameter(OF_TIME);
		}
		if (request.getParameter(IF_ANY) != null
				&& !request.getParameter(IF_ANY).equals("")) {
			ifAny = request.getParameter(IF_ANY);
		}
		if (request.getParameter(PREGNANCIES) != null
				&& !(request.getParameter(PREGNANCIES).equals(""))) {
			pregnancies = request.getParameter(PREGNANCIES);
		}
		if (request.getParameter(SPECIFIC_REFERENCE) != null
				&& !(request.getParameter(SPECIFIC_REFERENCE).equals(""))) {
			specificReference = request.getParameter(SPECIFIC_REFERENCE);
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
		if (request.getParameter(REQUEST_STATUS) != null
				&& !(request.getParameter(REQUEST_STATUS).equals(""))) {
			requestStatus = request.getParameter(REQUEST_STATUS);
		}
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		BloodRequestEntryHeader bloodEntryHeader = new BloodRequestEntryHeader();
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			bloodEntryHeader.setHin(patient);
		}
		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			bloodEntryHeader.setInpatient(inpatient);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			bloodEntryHeader.setDepartment(masDepartment);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			bloodEntryHeader.setHospital(masHospital);
		}

		bloodEntryHeader.setOrderNo(orderSeqNo);
		String temp = bloodBankHandlerService.generateOrderNumber();

		bloodEntryHeader.setOrderDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		bloodEntryHeader.setOrderTime(time);
		bloodEntryHeader.setRequestType(requestType);
		bloodEntryHeader
				.setDate1(HMSUtil.convertStringTypeDateToDateType(date));
		bloodEntryHeader.setNoBottles(noOfBottles);
		bloodEntryHeader.setHb(hb);
		bloodEntryHeader.setPresence1(presence1);
		bloodEntryHeader.setFever(fever);
		bloodEntryHeader.setOfTime(ofTime);
		bloodEntryHeader.setIfAny(ifAny);
		bloodEntryHeader.setPregnancies(pregnancies);
		bloodEntryHeader.setSpecificReference(specificReference);
		bloodEntryHeader.setRequestStatus("P");
		bloodEntryHeader.setLastChgBy(userName);
		bloodEntryHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		bloodEntryHeader.setLastChgTime(time);
		infoMap.put("bloodEntryHeader", bloodEntryHeader);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("hinId", hinId);
		infoMap.put("orderSeqNo", orderSeqNo);

		try {
			List quantity = new ArrayList();
			// Vector component_id = new Vector();
			List req_date = new ArrayList();
			int rowCount = box.getInt("rowCount");

			/* commented by yogesh
			 * if (rowCount > 0) {
				for (int i = 1; i <= rowCount; i++) {
					if (box.getInt(BLOOD_COMPONENT_ID + i) != 0) {
						componentList.add(box.getInt(BLOOD_COMPONENT_ID + i));
						quantity.add(box.getString(QUANTITY + i));
						req_date.add(box.getString(REQUIRED_DATE + i));
					}
				}

			}*/
			Vector componnentId = box.getVector(BLOOD_COMPONENT_ID);
			Vector quatity = box.getVector(QUANTITY);
			Vector requiredDate = box.getVector(REQUIRED_DATE);
			for (int i = 0 ; i<componnentId.size();i++){
				if(!componnentId.get(i).equals("") && !quatity.get(i).equals("") && !requiredDate.get(i).equals("")){
					componentList.add(componnentId.get(i));
					quantity.add(quatity.get(i));
					req_date.add(requiredDate.get(i));
				}
			}

			/*
			 * Vector quantity = box.getVector(QUANTITY); Vector component_id =
			 * box.getVector(BLOOD_COMPONENT_ID); Vector req_date =
			 * box.getVector(REQUIRED_DATE); int counter = 0;
			 *
			 * for (int i = 0; i < component_id.size(); i++) { if
			 * (!component_id.get(i).toString().equals("")) counter++; }
			 * noOfRecords = counter; for (int i = 0; i < noOfRecords; i++) {
			 * componentList.add(component_id.get(i)); }
			 */
			infoMap.put("componentMainIdFromRequest",
					componentMainIdFromRequest);
			infoMap.put("componentList", componentList);
			infoMap.put("quantity", quantity);
			infoMap.put("req_date", req_date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		infoMap.put("box", box);
		String jsp = "";
		String message = "";
		if (returnMap.get("orderSeqNo") != null) {
			orderSeqNo = (String) returnMap.get("orderSeqNo");
		}

		boolean saved = false;
		saved = bloodBankHandlerService.submitBloodRequestEntry(infoMap);
		if (saved) {
			message = "Blood Request Entry has been done Successfully !!";
		} else {
			message = "Try Again !!";
		}

		jsp = BLD_MSG_REQ_ENTRY + ".jsp";
		map.put("orderSeqNo", orderSeqNo);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// -------------Pending Sample Collection----------------------------------
	public ModelAndView showPendingSampleCollectionJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		detailsMap = bloodBankHandlerService.getDetailsForSampleCollection();
		patientMap = bloodBankHandlerService.getSampleCollectionGrid(mapForDs);
		jsp = PENDING_BLOOD_SAMPLE_COLLECTION + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForSampleCollection(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String patientFName = "";
		String patientLName = "";
		String requestStatus = "";
		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		String pType = "";

		int rankId = 0;
		int requestId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int hinId = 0;
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();

		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
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
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}

			if (request.getParameter(REQUEST_STATUS) != null
					&& !(request.getParameter(REQUEST_STATUS).equals("0"))) {
				requestStatus = request.getParameter(REQUEST_STATUS);
				mapForDs.put("requestStatus", requestStatus);
			}
			if (request.getParameter(RANK_ID) != null
					&& !(request.getParameter(RANK_ID).equals("0"))) {
				rankId = new Integer(request.getParameter(RANK_ID));
				mapForDs.put("rankId", rankId);
			}
			if (request.getParameter(BLOOD_REQUEST_ID) != null
					&& !(request.getParameter(BLOOD_REQUEST_ID).equals("0"))) {
				requestId = new Integer(request.getParameter(BLOOD_REQUEST_ID));
				mapForDs.put("requestId", requestId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = bloodBankHandlerService
				.getPatientDetailSampleCollection(mapForDs);
		detailsMap = bloodBankHandlerService.getDetailsForSampleCollection();
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView submitBloodSampleCollection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		boolean saved = false;
		int hospitalId = 0;
		String diagSeqNo = "";
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
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		int hinId = box.getInt(HIN_ID);
		int requestHeaderId = 0;
		int newRequestId = 0;

		requestHeaderId = Integer.parseInt(request
				.getParameter(BLOOD_REQUEST_ID));
		List<BloodRequestEntryHeader> patientDetailList = new ArrayList<BloodRequestEntryHeader>();
		parameterMap.put("box", box);
		map = bloodBankHandlerService.submitBloodSampleCollection(parameterMap);
		saved = (Boolean) map.get("saved");
		String messageTOBeVisibleToTheUser = "";
		if (saved) {
			messageTOBeVisibleToTheUser = "Sample Collection Done Successfully !!";
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured !! Try Again ..";
		}
		String url1 = "";
		url = "/hms/hms/bloodBank?method=showPendingSampleCollectionJsp";
		url1 = "/hms/hms/bloodBank?method=showPendingSampleValidationJsp";

		String jsp = MSG_BLOOD_SAMPLE_COLLETION + ".jsp";

		map.put("requestHeaderId", requestHeaderId);
		map.put("newRequestId", newRequestId);
		map.put("url", url);
		map.put("url1", url1);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showBloodSampleColletionJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int requestId = 0;
		if (request.getParameter("requestId") != null
				&& !(request.getParameter("requestId").equals("0"))) {
			requestId = Integer.parseInt(request.getParameter("requestId"));
			mapForDS.put("requestId", requestId);
		}
		if (requestId != 0) {
			map = bloodBankHandlerService
					.showBloodSampleColletionJsp(requestId);
			String collectionSeqNo = "";
			collectionSeqNo = bloodBankHandlerService
					.getSampleCollectionSeqForDisplay("SCN");
			if (collectionSeqNo != null) {
				map.put("collectionSeqNo", collectionSeqNo);
			}
		}
		jsp = BLOOD_SAMPLE_COLLECTION + ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// ------------------------------Pending Sample
	// Validation--------------------------
	public ModelAndView showPendingSampleValidationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		detailsMap = bloodBankHandlerService.getDetailsForSampleValidation();
		patientMap = bloodBankHandlerService.getSampleValidationGrid(mapForDs);
		jsp = BLOOD_PENDING_SAMPLE_VALIDATION + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForSampleValidation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String patientFName = "";
		String patientLName = "";
		String requestStatus = "";
		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		String flag = "";
		String pType = "";

		int sampleId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int hinId = 0;
		String deptName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();

		try {

			if (session.getAttribute("deptName") != null)
				deptName = (String) session.getAttribute("deptName");

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
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
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}

			if (request.getParameter(REQUEST_STATUS) != null
					&& !(request.getParameter(REQUEST_STATUS).equals("0"))) {
				requestStatus = request.getParameter(REQUEST_STATUS);
				mapForDs.put("requestStatus", requestStatus);
			}

			if (request.getParameter(SAMPLE_COLLECTION_ID) != null
					&& !(request.getParameter(SAMPLE_COLLECTION_ID).equals("0"))) {
				sampleId = new Integer(request
						.getParameter(SAMPLE_COLLECTION_ID));
				mapForDs.put("sampleId", sampleId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = bloodBankHandlerService
				.getPatientDetailSampleValidation(mapForDs);
		detailsMap = bloodBankHandlerService.getDetailsForSampleValidation();
		jsp = BLOOD_PENDING_SAMPLE_VALIDATION + ".jsp";
		map.put("box", box);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showBloodSampleValidationJsp(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int sampleId = 0;
		if (request.getParameter("sampleId") != null
				&& !(request.getParameter("sampleId").equals("0"))) {
			sampleId = Integer.parseInt(request.getParameter("sampleId"));
			mapForDS.put("sampleId", sampleId);
		}
		if (sampleId != 0) {
			map = bloodBankHandlerService.showBloodSampleValidationJsp(sampleId);
		}
		jsp = BLOOD_SAMPLE_VALIDATION + ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView submitBloodSampleValidation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		boolean saved = false;
		int hospitalId = 0;
		String diagSeqNo = "";
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
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		int sampleCollectionId = 0;
		int newRequestId = 0;

		sampleCollectionId = Integer.parseInt(request
				.getParameter(SAMPLE_COLLECTION_ID));
		List<BloodSampleCollection> patientDetailList = new ArrayList<BloodSampleCollection>();
		parameterMap.put("box", box);
		boolean successfullyUpdated = false;
		successfullyUpdated = bloodBankHandlerService
				.submitBloodSampleValidation(parameterMap);
		String message = "";
		if (successfullyUpdated) {
			message = "Sample Validation Done Successfully !!";
		} else {
			message = "Some Problem Occured !! Try Again ..";
		}
		String url1 = "";
		url = "/hms/hms/bloodBank?method=showPendingSampleValidationJsp";
		url1 = "/hms/hms/bloodBank?method=showPendingSampleValidationJsp";

		String jsp = MSG_BLOOD_SAMPLE_VALIDATION + ".jsp";

		map.put("sampleCollectionId", sampleCollectionId);
		map.put("newRequestId", newRequestId);
		map.put("url", url);
		map.put("url1", url1);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ---------method to Show Pending Blood Sample
	 * Screening-------------------------------------
	 */
	public ModelAndView showPendingSampleScreeningTestJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		detailsMap = bloodBankHandlerService.getDetailsForSampleScreeningTest();
		patientMap = bloodBankHandlerService
				.getSampleScreeningTestGrid(mapForDs);
		jsp = BLOOD_PENDING_SAMPLE_SCREENING_TEST + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// ----method to search Blood Sample Screening----

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForBloodSampleScreening(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String patientFName = "";
		String sampleStatus = "";
		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		String pType = "";

		int sampleId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int hinId = 0;
		int deptId = 0;
		String deptName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();

		try {

			if (session.getAttribute("deptName") != null)
				deptName = (String) session.getAttribute("deptName");
			if (session.getAttribute("deptId") != null)
				deptId = (Integer) session.getAttribute("deptId");

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
			}
			if (request.getParameter(SERVICE_NO) != null
					&& !(request.getParameter(SERVICE_NO).equals(""))) {
				serviceNo = request.getParameter(SERVICE_NO);
				mapForDs.put("serviceNo", serviceNo);
			}
			if (request.getParameter(S_FIRST_NAME) != null
					&& !(request.getParameter(S_FIRST_NAME).equals(""))) {
				serPersonFName = request.getParameter(S_FIRST_NAME);
				mapForDs.put("serPersonFName", serPersonFName);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}

			if (request.getParameter(SAMPLE_STATUS) != null
					&& !(request.getParameter(SAMPLE_STATUS).equals("0"))) {
				sampleStatus = request.getParameter(SAMPLE_STATUS);
				mapForDs.put("sampleStatus", sampleStatus);
			}

			if (request.getParameter(SAMPLE_COLLECTION_ID) != null
					&& !(request.getParameter(SAMPLE_COLLECTION_ID).equals("0"))) {
				sampleId = new Integer(request
						.getParameter(SAMPLE_COLLECTION_ID));
				mapForDs.put("sampleId", sampleId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = bloodBankHandlerService
				.getPatientDetailBloodSampleScreening(mapForDs);
		detailsMap = bloodBankHandlerService.getDetailsForSampleScreeningTest();
		map.put("box", box);
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// -----------method to Show Blood Sample Screening

	public ModelAndView showBloodSampleScreeningTest(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = (String) session.getAttribute("deptName");
		int deptId = (Integer) session.getAttribute("deptId");
		int sampleId = 0;
		if (request.getParameter("sampleId") != null
				&& !(request.getParameter("sampleId").equals("0"))) {
			sampleId = Integer.parseInt(request.getParameter("sampleId"));
			mapForDS.put("sampleId", sampleId);
		}
		if (sampleId != 0) {
			map = bloodBankHandlerService.showBloodSampleScreening(sampleId);
			String testSeqNo = "";
			testSeqNo = bloodBankHandlerService
					.getSampleTestSeqForDisplay("STN");
			if (testSeqNo != null) {
				map.put("testSeqNo", testSeqNo);
			}
		}
		jsp = SAMPLE_SCREENING_TEST + ".jsp";

		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * ----------------------------------method to get test name
	 * -------------------------------------
	 */
	public ModelAndView getTestName(HttpServletRequest request,
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

		map = bloodBankHandlerService.getTestName(parameterMap);
		String jsp = "";
		jsp = "bld_responseForInvestigationName";
		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * ----------------------------------method to get data regarding selected
	 * Test -------------------------------------
	 */
	public void fillItemsForInvestigationName(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String investigationName = "";
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		try {
			if (request.getParameter("investigationName") != null) {
				investigationName = request.getParameter("investigationName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("investigationName", investigationName);
		map = bloodBankHandlerService.fillItemsForInvestigationName(dataMap);
		if (map.get("investigationList") != null) {
			investigationList = (List) map.get("investigationList");
		}
		StringBuffer sb = new StringBuffer();

		sb.append("<items>");
		for (DgMasInvestigation masInvestigation : investigationList) {
			sb.append("<item>");
			sb.append("<investigationCodeId>" + masInvestigation.getId()
					+ "</investigationCodeId>");
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

	/**
	 * ----------------------------------method to submit Blood Sample Screening
	 * -------------------------------------
	 */
	public ModelAndView submitBloodSampleScreeningTest(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		int componentMainIdFromRequest = 0;
		int noOfRecords = 0;
		int inpatientId = 0;
		int sampleTestBy = 0;
		int sampleColelctionId = 0;
		int pageNo = 1;
		int hinId = 0;
		int crossmatchBy = 0;

		String fitBloodIssue = "";
		String testSeqNo = "";
		String hinNo = "";
		String date = "";
		String time = "";
		String compatibility = "";
		String minorRsDc = "";
		String majorRsDc = "";

		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		List investigationList = new ArrayList();

		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("scrneeinghdId") != null) {
			componentMainIdFromRequest = Integer.parseInt(request
					.getParameter("scrneeinghdId"));
		}
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(HIN_NO) != null
				&& !request.getParameter(HIN_NO).equals("")) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(SAMPLE_TEST_NO) != null
				&& !request.getParameter(SAMPLE_TEST_NO).equals("")) {
			testSeqNo = request.getParameter(SAMPLE_TEST_NO);
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !request.getParameter(EMPLOYEE_ID).equals("0")) {
			sampleTestBy = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(CROSS_MATCHED_BY) != null
				&& !request.getParameter(CROSS_MATCHED_BY).equals("0")) {
			crossmatchBy = Integer.parseInt(request
					.getParameter(CROSS_MATCHED_BY));
		}
		if (request.getParameter(SAMPLE_COLLECTION_ID) != null
				&& !request.getParameter(SAMPLE_COLLECTION_ID).equals("0")) {
			sampleColelctionId = Integer.parseInt(request
					.getParameter(SAMPLE_COLLECTION_ID));
		}
		if (request.getParameter(BLOOD_ISSUE) != null
				&& !(request.getParameter(BLOOD_ISSUE).equals(""))) {
			fitBloodIssue = request.getParameter(BLOOD_ISSUE);
		}
		if (request.getParameter(COMPATIBILITY) != null
				&& !(request.getParameter(COMPATIBILITY).equals(""))) {
			compatibility = request.getParameter(COMPATIBILITY);
		}

		if (request.getParameter(MAJOR_RS_DC) != null) {
			majorRsDc = "y";
		} else {
			majorRsDc = "n";
		}
		if (request.getParameter(MINOR_RS_DC) != null) {
			minorRsDc = "y";
		} else {
			minorRsDc = "n";
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

		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		BloodSampleScreeningHeader sampleScreeningHeader = new BloodSampleScreeningHeader();
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			sampleScreeningHeader.setHin(patient);
		}
		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			sampleScreeningHeader.setInpatient(inpatient);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			sampleScreeningHeader.setDepartment(masDepartment);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			sampleScreeningHeader.setHospital(masHospital);
		}

		if (sampleTestBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(sampleTestBy);
			sampleScreeningHeader.setSampleTestBy(masEmployee);
		}
		if (crossmatchBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(crossmatchBy);
			sampleScreeningHeader.setCrossMatchBy(masEmployee);
		}

		if (sampleColelctionId != 0) {
			BloodSampleCollection bloodSampleCollection = new BloodSampleCollection();
			bloodSampleCollection.setId(sampleColelctionId);
			sampleScreeningHeader.setSampleCollection(bloodSampleCollection);
		}
		sampleScreeningHeader.setSampleTestNo(testSeqNo);
		String temp = bloodBankHandlerService.generateSampleTestNumber();

		sampleScreeningHeader.setCompatibility(compatibility);
		sampleScreeningHeader.setMajorRsDc(majorRsDc);
		sampleScreeningHeader.setMinorRsDc(minorRsDc);
		sampleScreeningHeader.setBloodIssue("n");
		sampleScreeningHeader.setSampleTestDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		sampleScreeningHeader.setSampleTestTime(time);
		sampleScreeningHeader.setFitBloodIssue(fitBloodIssue);
		sampleScreeningHeader.setLastChgBy(userName);
		sampleScreeningHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		sampleScreeningHeader.setLastChgTime(time);
		infoMap.put("sampleScreeningHeader", sampleScreeningHeader);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("hinId", hinId);
		infoMap.put("testSeqNo", testSeqNo);

		try {

			Vector result = box.getVector(RESULT);
			Vector investigation_id = box.getVector(INVESTIGATION_ID);
			int counter = 0;

			for (int i = 0; i < investigation_id.size(); i++) {
				if (!investigation_id.get(i).toString().equals(""))
					counter++;
			}
			noOfRecords = counter;
			for (int i = 0; i < noOfRecords; i++) {
				investigationList.add(investigation_id.get(i));
			}
			infoMap.put("componentMainIdFromRequest",componentMainIdFromRequest);
			infoMap.put("investigationList", investigationList);
			infoMap.put("result", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		infoMap.put("box", box);
		boolean success = false;
		String jsp = "";
		String message = "";
		if (returnMap.get("testSeqNo") != null) {
			testSeqNo = (String) returnMap.get("testSeqNo");
		}

		boolean saved = false;
		saved = bloodBankHandlerService.submitBloodSampleScreeningTest(infoMap);
		if (saved) {
			message = "Screening Test has been done Successfully !!";
		} else {
			message = "Try Again!";
		}

		jsp = MSG_BLOOD_SCRREEING_TEST + ".jsp";
		map.put("testSeqNo", testSeqNo);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showPendingBloodIssueJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		detailsMap = bloodBankHandlerService.getDetailsForBloodIssue();
		patientMap = bloodBankHandlerService.getBloodIssueGrid(mapForDs);
		jsp = BLD_PENDING_BLOOD_ISSUE + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	/**
	 * -----------------method to search Blood Issue -------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForBloodIssue(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientLName = "";
		String patientFName = "";
		String bloodIssue = "";
		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		String pType = "";
		String orderNo = "";

		int screeningId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int hinId = 0;
		int deptId = 0;
		String deptName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();

		try {

			if (session.getAttribute("deptName") != null)
				deptName = (String) session.getAttribute("deptName");
			if (session.getAttribute("deptId") != null)
				deptId = (Integer) session.getAttribute("deptId");

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
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
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}

			if (request.getParameter(BLOOD_ISSUE) != null
					&& !(request.getParameter(BLOOD_ISSUE).equals("0"))) {
				bloodIssue = request.getParameter(BLOOD_ISSUE);
				mapForDs.put("bloodIssue", bloodIssue);
			}
			if (request.getParameter(ORDER_NO) != null
					&& !(request.getParameter(ORDER_NO).equals(""))) {
				orderNo = request.getParameter(ORDER_NO);
				mapForDs.put("orderNo", orderNo);
			}
			if (request.getParameter(SAMPLE_SCREENING_HD_ID) != null
					&& !(request.getParameter(SAMPLE_SCREENING_HD_ID)
							.equals("0"))) {
				screeningId = new Integer(request
						.getParameter(SAMPLE_SCREENING_HD_ID));
				mapForDs.put("screeningId", screeningId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = bloodBankHandlerService
				.getPatientDetailBloodIssue(mapForDs);
		detailsMap = bloodBankHandlerService.getDetailsForBloodIssue();
		map.put("box", box);
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showBloodIssueJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = (String) session.getAttribute("deptName");
		int deptId = (Integer) session.getAttribute("deptId");
		int screeningId = 0;
		if (request.getParameter("screeningId") != null
				&& !(request.getParameter("screeningId").equals("0"))) {
			screeningId = Integer.parseInt(request.getParameter("screeningId"));
			mapForDS.put("screeningId", screeningId);
		}
		if (screeningId != 0) {
			map = bloodBankHandlerService.showBloodIssueJsp(screeningId);
			String monthlySeqNo = "";
			monthlySeqNo = bloodBankHandlerService
					.getBloodIssueSeqForDisplay("MIN");
			if (monthlySeqNo != null) {
				map.put("monthlySeqNo", monthlySeqNo);
			}
		}
		jsp = BLD_BLOOD_ISSUE + ".jsp";

		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitBloodIssue(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		int componentMainIdFromRequest = 0;
		int noOfRecords = 0;
		int issuedBy = 0;
		int crossMatchedBy = 0;
		int receivedBy = 0;
		int bloodGroupId = 0;
		int pageNo = 1;
		int hinId = 0;
		int screeningId = 0;

		String monthlySeqNo = "";
		String salRt = "";
		String sal = "";
		String alb = "";
		String ahg = "";
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		List stockList = new ArrayList();

		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("issuehdId") != null) {
			componentMainIdFromRequest = Integer.parseInt(request
					.getParameter("issuehdId"));
		}
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(MONTHLY_ISSUE_NO) != null
				&& !request.getParameter(MONTHLY_ISSUE_NO).equals("")) {
			monthlySeqNo = request.getParameter(MONTHLY_ISSUE_NO);
		}
		if (request.getParameter(ISSUED_BY) != null
				&& !request.getParameter(ISSUED_BY).equals("0")) {
			issuedBy = Integer.parseInt(request.getParameter(ISSUED_BY));
		}
		if (request.getParameter(RECEIVED_BY) != null
				&& !request.getParameter(RECEIVED_BY).equals("0")) {
			receivedBy = Integer.parseInt(request.getParameter(RECEIVED_BY));
		}
		if (request.getParameter(CROSS_MATCHED_BY) != null
				&& !request.getParameter(CROSS_MATCHED_BY).equals("0")) {
			crossMatchedBy = Integer.parseInt(request
					.getParameter(CROSS_MATCHED_BY));
		}
		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& !request.getParameter(BLOOD_GROUP_ID).equals("0")) {
			bloodGroupId = Integer.parseInt(request
					.getParameter(BLOOD_GROUP_ID));
		}

		if (request.getParameter(SAL) != null) {
			sal = "y";
		} else {
			sal = "n";
		}
		if (request.getParameter(SAL_RT) != null) {
			salRt = "y";
		} else {
			salRt = "n";
		}
		if (request.getParameter(AHG) != null) {
			ahg = "y";
		} else {
			ahg = "n";
		}
		if (request.getParameter(ALB) != null) {
			alb = "y";
		} else {
			alb = "n";
		}
		if (request.getParameter(SAMPLE_SCREENING_HD_ID) != null
				&& !request.getParameter(SAMPLE_SCREENING_HD_ID).equals("0")) {
			screeningId = Integer.parseInt(request
					.getParameter(SAMPLE_SCREENING_HD_ID));
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

		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		BloodIssueHeader bloodIssueHeader = new BloodIssueHeader();
		if (screeningId != 0) {
			BloodSampleScreeningHeader sampleScreeningHeader = new BloodSampleScreeningHeader();
			sampleScreeningHeader.setId(screeningId);
			bloodIssueHeader.setScreeningHd(sampleScreeningHeader);
		}
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			bloodIssueHeader.setHin(patient);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			bloodIssueHeader.setDepartment(masDepartment);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			bloodIssueHeader.setHospital(masHospital);
		}

		if (issuedBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(issuedBy);
			bloodIssueHeader.setIssuedBy(masEmployee);
		}

		if (receivedBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(receivedBy);
			bloodIssueHeader.setReceivedBy(masEmployee);
		}
		if (crossMatchedBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(crossMatchedBy);
			bloodIssueHeader.setMatchedBy(masEmployee);
		}
		if (bloodGroupId != 0) {
			MasBloodGroup masBloodGroup = new MasBloodGroup();
			masBloodGroup.setId(bloodGroupId);
			bloodIssueHeader.setBloodGroup(masBloodGroup);
		}
		bloodIssueHeader.setMonthlyNo(monthlySeqNo);
		String temp = bloodBankHandlerService.generateMonthlyNumber();

		bloodIssueHeader.setSal(sal);
		bloodIssueHeader.setSalRt(salRt);
		bloodIssueHeader.setAhg(ahg);
		bloodIssueHeader.setAlb(alb);
		bloodIssueHeader.setIssueDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		bloodIssueHeader.setIssueTime(time);
		bloodIssueHeader.setLastChgBy(userName);
		bloodIssueHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		bloodIssueHeader.setLastChgTime(time);
		infoMap.put("bloodIssueHeader", bloodIssueHeader);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("screeningId", screeningId);
		infoMap.put("hinId", hinId);
		infoMap.put("monthlySeqNo", monthlySeqNo);

		try {

			Vector stock_detail_id = box.getVector(STOCK_DETAIL_ID);
			for (int i = 0; i < stock_detail_id.size(); i++) {
				if (!stock_detail_id.get(i).equals(""))
					stockList.add(stock_detail_id.get(i));
			}

			infoMap.put("componentMainIdFromRequest",
					componentMainIdFromRequest);
			infoMap.put("stockList", stockList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		infoMap.put("box", box);
		String jsp = "";
		String message = "";
		if (returnMap.get("monthlySeqNo") != null) {
			monthlySeqNo = (String) returnMap.get("monthlySeqNo");
		}

		boolean saved = false;
		saved = bloodBankHandlerService.submitBloodIssue(infoMap);
		if (saved) {
			message = "Blood Issue has been done Successfully !!";
		} else {
			message = "Try Again!";
		}
		url = "/hms/hms/bloodBank?method=showPendingBloodIssueJsp";

		jsp = BLD_MSG_BLOOD_ISSUE + ".jsp";
		map.put("monthlySeqNo", monthlySeqNo);
		map.put("url", url);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// ----------Blood Strock Opening Balance---------------
	@SuppressWarnings("unchecked")
	public ModelAndView showStockOpeningBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = bloodBankHandlerService.showStockOpeningBalance();
		session = request.getSession();
		String stockSeqNo = "";
		stockSeqNo = bloodBankHandlerService.getStockSeqNoForDisplay("SN");
		jsp = BLD_STOCK_OPENING_BALANCE;
		jsp += ".jsp";
		map.put("stockSeqNo", stockSeqNo);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView submitStockOpeningBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> paraMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean saved = false;
		String message = "";
		int hospitalId = 0;
		int noOfRecords = 0;
		int deptId = 0;

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			infoMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			infoMap.put("deptId", deptId);
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		infoMap.put("box", box);
		map = bloodBankHandlerService.submitStockOpeningBalance(infoMap);
		saved = (Boolean) map.get("saved");

		if (saved == true) {
			message = "Data saved Successfully !!";
		} else {
			message = "Try Again!";
		}

		/*
		 * String stockSeqNo = ""; if (infoMap.get("stockSeqNo") != null) {
		 * stockSeqNo = (String) infoMap.get("stockSeqNo"); }
		 */
		url = "/hms/hms/bloodBank?method=showStockOpeningBalance";

		String jsp = BLD_MSG_STOCK_OPENING + ".jsp";

		map.put("message", message);
		// map.put("stockSeqNo", stockSeqNo);
		map.put("url", url);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);

	}

	// ----------Blood Donation Entry---------------
	public ModelAndView showBloodDonationEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();

		map = (Map<String, Object>) bloodBankHandlerService.showBloodDonationEntryJsp();
		String donationSeqNo = "";
		donationSeqNo = bloodBankHandlerService.getDonationSeqNoForDisplay("BDN");
		if (donationSeqNo != null) {
			map.put("donationSeqNo", donationSeqNo);
		}
		jsp = BLOOD_DONATION_ENTRY;
		jsp += ".jsp";
		title = "BloodDonationEntry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	// -------------------Blood Discrad Entry-----------------------------------
	public ModelAndView showPendingBloodDiscard(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		patientMap = bloodBankHandlerService.showPendingBloodDiscard(mapForDs);
		jsp = BLD_PND_DISCARD + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showBloodDiscardJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int bloodStockDetailId = 0;
		if (request.getParameter("bloodStockDetailId") != null
				&& !(request.getParameter("bloodStockDetailId").equals("0"))) {
			bloodStockDetailId = Integer.parseInt(request
					.getParameter("bloodStockDetailId"));
			mapForDS.put("bloodStockDetailId", bloodStockDetailId);
		}
		if (bloodStockDetailId != 0) {
			map = bloodBankHandlerService
					.showBloodDiscardJsp(bloodStockDetailId);
			String discardSeqNo = "";
			discardSeqNo = bloodBankHandlerService
					.getDiscardSeqForDisplay("DSN");
			if (discardSeqNo != null) {
				map.put("discardSeqNo", discardSeqNo);
			}
		}
		jsp = BLD_DISCARD_ENTRY + ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView submitBloodDiscard(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		BloodDiscardEntry bloodDiscardEntry = new BloodDiscardEntry();
		Date currentDate = new Date();
		Date discardDate = new Date();

		String changedBy = "";
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		Box box = HMSUtil.getBox(request);
		map.put("box", box);
		String discardSeqNo = "";
		String remarks = "";
		int approvedBy = 0;
		int stockDetailId = 0;
		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			bloodDiscardEntry.setHospital(masHospital);
		}
		bloodDiscardEntry.setDiscardNo(discardSeqNo);
		String temp = bloodBankHandlerService.generateDiscardNumber();

		if (request.getParameter(REMARKS) != null
				&& !request.getParameter(REMARKS).equals("")) {
			remarks = request.getParameter(REMARKS);
			bloodDiscardEntry.setRemarks(remarks);
		}

		if (request.getParameter(APPROVED_BY) != null
				&& !request.getParameter(APPROVED_BY).equals("0")) {
			approvedBy = Integer.parseInt(request.getParameter(APPROVED_BY));
			if (approvedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(approvedBy);
				bloodDiscardEntry.setApprovedBy(masEmployee);
			}
		}
		if (deptId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			bloodDiscardEntry.setDepartment(masDepartment);
		}
		if (request.getParameter(STOCK_DETAIL_ID) != null
				&& !request.getParameter(STOCK_DETAIL_ID).equals("0")) {
			stockDetailId = Integer.parseInt(request
					.getParameter(STOCK_DETAIL_ID));
		}
		if (stockDetailId != 0) {
			BloodStockDetail stockDetail = new BloodStockDetail();
			stockDetail.setId(stockDetailId);
			bloodDiscardEntry.setStockDetail(stockDetail);

		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
			bloodDiscardEntry.setLastChgBy(userName);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			bloodDiscardEntry.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			bloodDiscardEntry.setLastChgTime(time);
		}
		if (request.getParameter(DISCARD_DATE) != null
				&& !(request.getParameter(DISCARD_DATE).equals(""))) {
			discardDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DISCARD_DATE));
			bloodDiscardEntry.setDiscardDate(HMSUtil
					.convertStringTypeDateToDateType(date));
		}
		if (session.getAttribute(CHANGED_BY) != null) {
			userName = (String) session.getAttribute(CHANGED_BY);
		}
		parameterMap.put("stockDetailId", stockDetailId);
		parameterMap.put("bloodDiscardEntry", bloodDiscardEntry);
		boolean saved = false;
		saved = bloodBankHandlerService.submitBloodDiscard(parameterMap);
		patientMap = bloodBankHandlerService.showPendingBloodDiscard(mapForDs);
		if (saved) {
			message = "Blood Discard Entry has been done Successfully !!";
		} else {
			message = "Try Again!";
		}

		jsp = BLD_PND_DISCARD + ".jsp";
		map.put("url", url);
		map.put("approvedBy", approvedBy);
		map.put("userName", userName);
		map.put("hospitalId", hospitalId);
		map.put("deptId", deptId);
		map.put("discardSeqNo", discardSeqNo);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// -----------------Blood Test Entry-----------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showBloodTestEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = bloodBankHandlerService.showBloodTestEntryJsp();
		String serialSeqNo = "";
		serialSeqNo = bloodBankHandlerService.getSerialSeqForDisplay("TSN");
		if (serialSeqNo != null) {
			map.put("serialSeqNo", serialSeqNo);
		}
		jsp = BLD_TEST_ENTRY;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getPatientList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		String serviceNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
		}

		map.put("serviceNo", serviceNo);
		map = bloodBankHandlerService.getPatientList(serviceNo);
		jsp = BLD_TEST_ENTRY;
		jsp += ".jsp";
		// map.put("hinId",hinId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	// --------------------------Reports-----------------------------------------
	// ----------------------Stock Ledger----------------------------------
	public ModelAndView showStockLedgerJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "blood Stock Ledger";

		jsp = BLD_STOCK_LEDGER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printStockLedger(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

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
		map = bloodBankHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		try {
			HMSUtil.generateReport("blood_stockLedger", map, (Connection) map
					.get("con"), response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ----------------------ABO & RH Grouping-------------------------
	public ModelAndView showAboRhReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Abo Rh Grouping";

		jsp = BLD_ABORH_GROUPING;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printAboRhReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

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
		map = bloodBankHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		try {
			HMSUtil.generateReport("blood_AboRhReport", map, (Connection) map
					.get("con"), response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// --------------------------Blood Issue
	// Register----------------------------
	public ModelAndView showBloodIssueRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "blood Issue register";

		jsp = BLD_ISSUE_REGISTER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printBloodIssueRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

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
		map = bloodBankHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		try {
			HMSUtil.generateReport("blood_issue_register", map,
					(Connection) map.get("con"), response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printBloodCollectionIssueRegister(
			HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

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
		map = bloodBankHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		try {
			HMSUtil.generateReport("blood_collectionIssueRegister", map,
					(Connection) map.get("con"), response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ---------Compatibility Register----------------------------
	public ModelAndView showCompatibilityRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Compatibility Register";

		jsp = BLD_COMPATIBILITY_REGISTER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	// --------------------------"Direct Indirect Test
	// Register----------------------------
	public ModelAndView showDirectIndirectRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = bloodBankHandlerService.showDirectIndirectRegisterReport();
		title = "Direct Indirect Test Register";
		jsp = BLD_DIRECT_INDIRECT_TEST_REGISTER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printDirectIndirectRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();
		String investigationName = "";
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
			if (request.getParameter(INVESTIGATION_NAME) != null
					&& !(request.getParameter(INVESTIGATION_NAME).equals(""))) {
				investigationName = request.getParameter(INVESTIGATION_NAME);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map = bloodBankHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("investigationName", investigationName);
		try {
			HMSUtil.generateReport("blood_directIndirectTestRegister", map,
					(Connection) map.get("con"), response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// --------Cell Serum Screening Register-----------
	public ModelAndView showCellSerumScreeningReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Cell Serum Screening Register";

		jsp = BLD_CELL_SERUM_SCREENING_REGISTER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	// -------------------------Vdrl Test Register---------------------------
	public ModelAndView showVdrlTestRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Vdrl Test Register";

		jsp = BLD_VDRL_TEST_REGISTER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView printVdrlTestRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

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
		map = bloodBankHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		try {
			HMSUtil.generateReport("blood_vdrlTestRegister", map,
					(Connection) map.get("con"), response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ------Collection Issue Register---------------------------
	public ModelAndView showCollectionIssueRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Collection Issue Register";

		jsp = BLD_COLLECTION_ISSUE_REGISTER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	// -----Record Proforma Register----------------------------
	public ModelAndView showRecordProformaRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Record Proforma Register";

		jsp = BLD_RECORD_PROFORMA_REGISTER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView getPateintDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		String flag = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			map.put("flag", flag);
		}
		patientList = bloodBankHandlerService.getPateintDetail(serviceNo);
		if (patientList.size() > 0) {
			map.put("patientList", patientList);
		}
		String jsp = BLD_STOCK_OPENING_BALANCE;
		return new ModelAndView(jsp, "map", map);
	}

	// ----------------For Submit to bloodDonation Entry--------------------
	public ModelAndView submitBloodDonationEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		BloodDonationEntryHeader donationEntryHeader = new BloodDonationEntryHeader();

		int donationhdId = 0;
		int donationMainIdFromRequest = 0;
		int noOfRecords = 0;
		int hinId = 0;
		int inpatientId = 0;
		int pageNo = 1;
		int componentId = 0;
		int rankId = 0;

		int occupationId = 0;
		int stateId = 0;
		int numberOfTime = 0;

		int sexId = 0;
		String organization = "";
		String teleNo = "";
		String mobNo = "";
		String date = "";
		String time = "";
		String donationSeqNo = "";
		String donerName = "";
		String donerType = "";
		String fatherName = "";
		String husbandName = "";
		String unitAddress = "";
		String previouslyDonated = "";
		String discomfort = "";
		String smthingEat = "";
		String sleepWell = "";
		String lastDonated = "";
		String disease = "";
		String weightLoss = "";
		String repeatedDiarrhoeas = "";
		String swollenGlands = "";

		String lowGradeFever = "";
		String heartDisease = "";

		String lungDisease = "";
		String kidneyDisease = "";
		String epilepsy = "";
		String cdiabetes = "";
		String tuberculosis = "";
		String hepatitisBc = "";
		String abnormalBleeding = "";
		String allergicDisease = "";
		String sexuallyDisease = "";
		String jaundiceLastYear = "";
		String typhoidLastYear = "";
		String malariaSixMonth = "";
		String faintingSpells = "";
		String leprosy = "";
		String schizophernia = "";
		String endocrineDisorders = "";
		String abortions = "";
		String cancerDisease = "";
		String acuteNephritis = "";
		String Immunozalic = "";
		String rabiesVaccination = "";
		String hoHepatitis = "";
		String immunoglobulinNephritis = "";
		String hoMalaria = "";
		String breastFeeding = "";
		String tattooing = "";
		String typhoid = "";
		String alcholism = "";
		String abnormalTestResult = "";
		String general = "";
		String phlebotomySite = "";
		String dentalExtraction = "";
		String n_a1 = "";
		int bloodDonationId = 0;
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		List componentList = new ArrayList();
		List qtyList = new ArrayList();

		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			donationEntryHeader.setHospital(masHospital);
		}
		if (request.getParameter("donationhdId") != null) {
			donationMainIdFromRequest = Integer.parseInt(request
					.getParameter("donationhdId"));
		}
		if (request.getParameter(BLOOD_DONATION_ENTRY_HEADER_ID) != null
				&& !request.getParameter(BLOOD_DONATION_ENTRY_HEADER_ID)
						.equals("0")) {
			bloodDonationId = Integer.parseInt(request
					.getParameter(BLOOD_DONATION_ENTRY_HEADER_ID));
			donationEntryHeader.setId(bloodDonationId);
		}

		if (request.getParameter(DONATION_NO) != null
				&& !request.getParameter(DONATION_NO).equals("")) {
			donationSeqNo = request.getParameter(DONATION_NO);
		}
		donationEntryHeader.setDonationNo(donationSeqNo);
		String temp = bloodBankHandlerService.generateDonationNumber();

		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			if (hinId != 0) {
				Patient patient = new Patient();
				patient.setId(hinId);
				donationEntryHeader.setHin(patient);
			}
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			if (inpatientId != 0) {
				Inpatient patient = new Inpatient();
				patient.setId(inpatientId);
				donationEntryHeader.setInpatient(patient);
			}
		}
		if (request.getParameter(DONER_NAME) != null
				&& !request.getParameter(DONER_NAME).equals("")) {
			donerName = request.getParameter(DONER_NAME);
			donationEntryHeader.setDonerName(donerName);
		}
		if (request.getParameter(DONER_TYPE) != null
				&& !request.getParameter(DONER_TYPE).equals("")) {
			donerType = request.getParameter(DONER_TYPE);
			donationEntryHeader.setDonerType(donerType);
		}
		if (request.getParameter(FATHER_NAME) != null
				&& !request.getParameter(FATHER_NAME).equals("")) {
			fatherName = request.getParameter(FATHER_NAME);
			donationEntryHeader.setFatherName(fatherName);
		}
		if (request.getParameter(HUSBAND_NAME) != null
				&& !request.getParameter(HUSBAND_NAME).equals("")) {
			husbandName = request.getParameter(HUSBAND_NAME);
			donationEntryHeader.setHusbandName(husbandName);
		}
		if (request.getParameter(OCCUPATION_ID) != null
				&& !request.getParameter(OCCUPATION_ID).equals("0")) {
			occupationId = Integer
					.parseInt(request.getParameter(OCCUPATION_ID));
			if (occupationId != 0) {
				MasOccupation masOccupation = new MasOccupation();
				masOccupation.setId(occupationId);
				donationEntryHeader.setOccupation(masOccupation);
			}
		}
		if (request.getParameter(RANK_ID) != null
				&& !request.getParameter(RANK_ID).equals("0")) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
			if (rankId != 0) {
				MasRank masRank = new MasRank();
				masRank.setId(rankId);
				donationEntryHeader.setRank(masRank);
			}
		}
		if (request.getParameter(SEX_ID) != null
				&& !request.getParameter(SEX_ID).equals("0")) {
			sexId = Integer.parseInt(request.getParameter(SEX_ID));
			if (rankId != 0) {
				MasAdministrativeSex administrativeSex = new MasAdministrativeSex();
				administrativeSex.setId(sexId);
				donationEntryHeader.setSex(administrativeSex);
			}
		}
		if (request.getParameter(AGE) != null
				&& !request.getParameter(AGE).equals("")) {
			String age = request.getParameter(AGE);
			donationEntryHeader.setAge(age);

		}
		if (request.getParameter(UNIT_ADDRESS) != null
				&& !request.getParameter(UNIT_ADDRESS).equals("")) {
			unitAddress = request.getParameter(UNIT_ADDRESS);
			donationEntryHeader.setUnitAddress(unitAddress);
		}
		if (request.getParameter(STATE_ID) != null
				&& !request.getParameter(STATE_ID).equals("0")) {
			stateId = Integer.parseInt(request.getParameter(STATE_ID));
			if (stateId != 0) {
				MasState masState = new MasState();
				masState.setId(stateId);
				donationEntryHeader.setState(masState);
			}
		}
		if (request.getParameter(TELE_NO) != null) {
			teleNo = request.getParameter(TELE_NO);
			donationEntryHeader.setTelNo(teleNo);
		}
		if (request.getParameter(MOBILE_NO) != null
				&& !request.getParameter(MOBILE_NO).equals("")) {
			mobNo = request.getParameter(MOBILE_NO);
			donationEntryHeader.setMobNo(mobNo);
		}
		if (request.getParameter(PREVIOUSLY_DONATED) != null
				&& !request.getParameter(PREVIOUSLY_DONATED).equals("")) {
			previouslyDonated = request.getParameter(PREVIOUSLY_DONATED);
			donationEntryHeader.setPreviouslyDonated(previouslyDonated);
		}
		if (request.getParameter(NUMBER_OF_TIME) != null
				&& !request.getParameter(NUMBER_OF_TIME).equals("")) {
			numberOfTime = Integer.parseInt(request
					.getParameter(NUMBER_OF_TIME));
			donationEntryHeader.setNoTimes(numberOfTime);
		}
		String lastMealTime = "";
		if (request.getParameter(LAST_MEAL_TIME) != null
				&& !request.getParameter(LAST_MEAL_TIME).equals("")) {
			lastMealTime = request.getParameter(LAST_MEAL_TIME);
			donationEntryHeader.setTimeLastMeal(lastMealTime);
		}
		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& !request.getParameter(BLOOD_GROUP_ID).equals("0")) {
			int bloodGroupId = Integer.parseInt(request
					.getParameter(BLOOD_GROUP_ID));
			if (bloodGroupId != 0) {
				MasBloodGroup masBloodGroup = new MasBloodGroup();
				masBloodGroup.setId(bloodGroupId);
				donationEntryHeader.setBloodGroup(masBloodGroup);
			}
		}

		if (request.getParameter(DISCOMFORT) != null
				&& !(request.getParameter(DISCOMFORT).equals(""))) {
			discomfort = request.getParameter(DISCOMFORT);
			donationEntryHeader.setDiscomfort(discomfort);
		}
		if (request.getParameter(SOMTHING_EAT) != null
				&& !request.getParameter(SOMTHING_EAT).equals("")) {
			smthingEat = request.getParameter(SOMTHING_EAT);
			donationEntryHeader.setSmthingEat(smthingEat);
		}
		if (request.getParameter(SLEEP_LAST) != null
				&& !request.getParameter(SLEEP_LAST).equals("")) {
			sleepWell = request.getParameter(SLEEP_LAST);
			donationEntryHeader.setSleepLastNight(sleepWell);
		}
		/*if (request.getParameter(ORGANIZATION) != null
				&& !request.getParameter(ORGANIZATION).equals("")) {
			organization = request.getParameter(ORGANIZATION);
			donationEntryHeader.setOrganization(organization);
		}*/
		if (request.getParameter(INFECTED_DISEASE) != null
				&& !request.getParameter(INFECTED_DISEASE).equals("")) {
			disease = request.getParameter(INFECTED_DISEASE);
			donationEntryHeader.setDisease(disease);
		}
		String wellToday = "";
		if (request.getParameter(WELL_TODAY) != null) {
			wellToday = "y";
		} else {
			wellToday = "n";
		}
		donationEntryHeader.setWellToday(wellToday);
		if (request.getParameter(WEIGHT_LOSS) != null) {
			weightLoss = "y";
		} else {
			weightLoss = "n";
		}
		donationEntryHeader.setWeightLoss(weightLoss);
		String minorSurgery = "";
		if (request.getParameter(MINOR_SURGERY) != null) {
			minorSurgery = "y";
		} else {
			minorSurgery = "n";
		}
		donationEntryHeader.setMinorSurgery(minorSurgery);
		String majorSurgery = "";
		if (request.getParameter(MAJOR_SURGERY) != null) {
			majorSurgery = "y";
		} else {
			majorSurgery = "n";
		}
		donationEntryHeader.setMajorSurgery(majorSurgery);
		if (request.getParameter(DIARROCES) != null) {
			repeatedDiarrhoeas = "y";
		} else {
			repeatedDiarrhoeas = "n";
		}
		donationEntryHeader.setDiasrrhoes(repeatedDiarrhoeas);
		if (request.getParameter(SWOLLEN) != null) {
			swollenGlands = "y";
		} else {
			swollenGlands = "n";
		}
		donationEntryHeader.setSwollwn(swollenGlands);

		if (request.getParameter(LOW_GRADE_FEVER) != null) {
			lowGradeFever = "y";
		} else {
			lowGradeFever = "n";
		}
		donationEntryHeader.setLowGradeFever(lowGradeFever);

		if (request.getParameter(N_A1) != null) {
			n_a1 = "y";
		} else {
			n_a1 = "n";
		}
		donationEntryHeader.setNA1(n_a1);
		String hoBloodTransfusion = "";
		if (request.getParameter(BLOOD_TRANSFUSION_HO) != null) {
			hoBloodTransfusion = "y";
		} else {
			hoBloodTransfusion = "n";
		}
		donationEntryHeader.setHoBloodTransfusion(hoBloodTransfusion);
		if (request.getParameter(TATTOOING) != null) {
			tattooing = "y";
		} else {
			tattooing = "n";
		}
		donationEntryHeader.setTattoing(tattooing);
		String earPiercing = "";
		if (request.getParameter(EAR_PIERCING) != null) {
			earPiercing = "y";
		} else {
			earPiercing = "n";
		}
		donationEntryHeader.setEarPiercing(earPiercing);

		if (request.getParameter(DENTAL_EXTRACTION) != null) {
			dentalExtraction = "y";
		} else {
			dentalExtraction = "n";
		}
		donationEntryHeader.setDentalExtraction(dentalExtraction);

		String n_a2 = "";
		if (request.getParameter(N_A2) != null) {
			n_a2 = "y";
		} else {
			n_a2 = "n";
		}
		donationEntryHeader.setNA2(n_a2);
		if (request.getParameter(HEART_DISEASE) != null) {
			heartDisease = "y";
		} else {
			heartDisease = "n";
		}
		donationEntryHeader.setHeartDisease(heartDisease);

		if (request.getParameter(LUNG_DISEASE) != null) {
			lungDisease = "y";
		} else {
			lungDisease = "n";
		}
		donationEntryHeader.setLungDisease(lungDisease);

		if (request.getParameter(KIDNEY_DISEASE) != null) {
			kidneyDisease = "y";
		} else {
			kidneyDisease = "n";
		}
		donationEntryHeader.setKidneyDisease(kidneyDisease);
		if (request.getParameter(CANCER_DISEASE) != null) {
			cancerDisease = "y";
		} else {
			cancerDisease = "n";
		}
		donationEntryHeader.setCancerDisease(cancerDisease);
		if (request.getParameter(EPILEPSY) != null) {
			epilepsy = "y";
		} else {
			epilepsy = "n";
		}
		donationEntryHeader.setEpilepsy(epilepsy);
		if (request.getParameter(CDIABETES) != null) {
			cdiabetes = "y";
		} else {
			cdiabetes = "n";
		}
		donationEntryHeader.setCdiabetes(cdiabetes);

		if (request.getParameter(TUBERCULOSIS) != null) {
			tuberculosis = "y";
		} else {
			tuberculosis = "n";
		}
		donationEntryHeader.setTuberculosis(tuberculosis);
		if (request.getParameter(ABNORMAL_BLEEDING) != null) {
			abnormalBleeding = "y";
		} else {
			abnormalBleeding = "n";
		}
		donationEntryHeader.setAbnormalBleeding(abnormalBleeding);
		if (request.getParameter(HEPATITIS_BC) != null) {
			hepatitisBc = "y";
		} else {
			hepatitisBc = "n";
		}
		donationEntryHeader.setHepatitis(hepatitisBc);

		if (request.getParameter(ALLERGIC_DISEASE) != null) {
			allergicDisease = "y";
		} else {
			allergicDisease = "n";
		}
		donationEntryHeader.setAllergicDisease(allergicDisease);

		String dentalExtraction1 = "";
		if (request.getParameter(DENTAL_EXTRACTION1) != null) {
			dentalExtraction1 = "y";
		} else {
			dentalExtraction1 = "n";
		}
		donationEntryHeader.setDentalExtraction1(dentalExtraction1);
		if (request.getParameter(SEXUALLY_TRANSMITTED_DISEASE) != null) {
			sexuallyDisease = "y";
		} else {
			sexuallyDisease = "n";
		}
		donationEntryHeader.setSexuallyDisease(sexuallyDisease);
		String jaundice = "";
		if (request.getParameter(JAUNDICE) != null) {
			jaundice = "y";
		} else {
			jaundice = "n";
		}
		donationEntryHeader.setJaundice(jaundice);
		if (request.getParameter(JAUNDICE_LAST) != null) {
			jaundiceLastYear = "y";
		} else {
			jaundiceLastYear = "n";
		}
		donationEntryHeader.setJaundiceLastYear(jaundiceLastYear);
		if (request.getParameter(TYPHOID) != null) {
			typhoid = "y";
		} else {
			typhoid = "n";
		}
		donationEntryHeader.setTyphoid(typhoid);
		if (request.getParameter(TYPHOID_LAST) != null) {
			typhoidLastYear = "y";
		} else {
			typhoidLastYear = "n";
		}
		donationEntryHeader.setTyphoidLastOne(typhoidLastYear);
		if (request.getParameter(MALARIA_LAST) != null) {
			malariaSixMonth = "y";
		} else {
			malariaSixMonth = "n";
		}
		donationEntryHeader.setMalariaSixMonth(malariaSixMonth);
		String malaria = "";
		if (request.getParameter(MALARIA) != null) {
			malaria = "y";
		} else {
			malaria = "n";
		}
		donationEntryHeader.setMalaria(malaria);
		if (request.getParameter(FAINTING_SPELL) != null) {
			faintingSpells = "y";
		} else {
			faintingSpells = "n";
		}
		donationEntryHeader.setFaintingSpells(faintingSpells);
		if (request.getParameter(LEPROSY) != null) {
			leprosy = "y";
		} else {
			leprosy = "n";
		}
		donationEntryHeader.setLeprosy(leprosy);
		if (request.getParameter(SCHIZOPHERNIA) != null) {
			schizophernia = "y";
		} else {
			schizophernia = "n";
		}
		donationEntryHeader.setSchizophernia(schizophernia);
		if (request.getParameter(ENDOCRING_DISORDERS) != null) {
			endocrineDisorders = "y";
		} else {
			endocrineDisorders = "n";
		}
		donationEntryHeader.setEndocrineDisorders(endocrineDisorders);

		String n_a3 = "";
		if (request.getParameter(N_A3) != null) {
			n_a3 = "y";
		} else {
			n_a3 = "n";
		}
		donationEntryHeader.setNA3(n_a3);

		if (request.getParameter(ABORTION) != null) {
			abortions = "y";
		} else {
			abortions = "n";
		}
		donationEntryHeader.setAbortion(abortions);
		if (request.getParameter(ACUTE_NERPHRITIS) != null) {
			acuteNephritis = "y";
		} else {
			acuteNephritis = "n";
		}
		donationEntryHeader.setAcuteNephritis(acuteNephritis);

		if (request.getParameter(IMMUNOZALIC) != null) {
			Immunozalic = "y";
		} else {
			Immunozalic = "n";
		}
		donationEntryHeader.setIImmunozalic(Immunozalic);
		if (request.getParameter(RABIES_VACCINATION) != null) {
			rabiesVaccination = "y";
		} else {
			rabiesVaccination = "n";
		}
		donationEntryHeader.setRabieVaccination(rabiesVaccination);
		if (request.getParameter(HO_HEPATITIS) != null) {
			hoHepatitis = "y";
		} else {
			hoHepatitis = "n";
		}
		donationEntryHeader.setHoHapatitis(hoHepatitis);
		if (request.getParameter(IMMUNOGLOBULIN_NEPHRITIS) != null) {
			immunoglobulinNephritis = "y";
		} else {
			immunoglobulinNephritis = "n";
		}
		donationEntryHeader.setImmunoglobulinNephritis(immunoglobulinNephritis);
		if (request.getParameter(HO_MALARIA) != null) {
			hoMalaria = "y";
		} else {
			hoMalaria = "n";
		}
		donationEntryHeader.setHoMalaria(hoMalaria);
		if (request.getParameter(BREAST_FEEDING) != null) {
			breastFeeding = "y";
		} else {
			breastFeeding = "n";
		}
		donationEntryHeader.setBreastFeeding(breastFeeding);
		String tattooing1 = "";
		if (request.getParameter(TATTOOING1) != null) {
			tattooing1 = "y";
		} else {
			tattooing1 = "n";
		}
		donationEntryHeader.setTattoing1(tattooing1);

		String typhoid1 = "";
		if (request.getParameter(TYPHOID) != null) {
			typhoid1 = "y";
		} else {
			typhoid1 = "n";
		}
		donationEntryHeader.setTyphoid(typhoid);
		if (request.getParameter(ALCHOLISM) != null) {
			alcholism = "y";
		} else {
			alcholism = "n";
		}
		donationEntryHeader.setAlcholism(alcholism);
		String bloodTransfusionSix = "";
		if (request.getParameter(SELECTED_RADIO) != null) {
			bloodTransfusionSix = "y";
		} else {
			bloodTransfusionSix = "n";
		}
		donationEntryHeader.setBloodTransfusionSix(bloodTransfusionSix);
		if (request.getParameter(PREGNENT) != null) {
			donationEntryHeader.setPregnent(request.getParameter(PREGNENT));
		}
		if (request.getParameter(ABORTION1) != null) {
			donationEntryHeader.setAbortionLastThree(request
					.getParameter(ABORTION1));
		}
		if (request.getParameter(N_A5) != null) {
			donationEntryHeader.setNA5(request.getParameter(N_A5));
		}
		if (request.getParameter(CHILD_LESS) != null) {
			donationEntryHeader.setChildLess(request.getParameter(CHILD_LESS));
		}
		if (request.getParameter(MENSES) != null) {
			donationEntryHeader.setMenses(request.getParameter(MENSES));
		}
		String n_a4 = "";
		if (request.getParameter(N_A4) != null) {
			n_a4 = "y";
		} else {
			n_a4 = "n";
		}
		donationEntryHeader.setNA4(n_a4);
		if (request.getParameter(ABNORMAL_TEST_RESULT) != null) {
			abnormalTestResult = "y";
		} else {
			abnormalTestResult = "n";
		}
		donationEntryHeader.setAbnormalTestResult(abnormalTestResult);
		if (request.getParameter(GENERAL) != null
				&& !(request.getParameter(GENERAL).equals(""))) {
			general = request.getParameter(GENERAL);
		}
		donationEntryHeader.setGeneral(general);
		int height = 0;
		if (request.getParameter(HEIGHT) != null
				&& !request.getParameter(HEIGHT).equals("")) {
			height = Integer.parseInt(request.getParameter(HEIGHT));
		}
		donationEntryHeader.setHeight(height);
		int weight = 0;
		if (request.getParameter(WEIGHT) != null
				&& !(request.getParameter(WEIGHT).equals(""))) {
			weight = Integer.parseInt(request.getParameter(WEIGHT));
		}
		donationEntryHeader.setWeight(weight);
		float pulse = 0;
		if (request.getParameter(PULSE) != null
				&& !(request.getParameter(PULSE).equals(""))) {
			pulse = Float.parseFloat(request.getParameter(PULSE));

		}
		donationEntryHeader.setPulse(pulse);
		if (request.getParameter(HB_DL) != null
				&& !request.getParameter(HB_DL).equals("")) {
			float hbDl = Float.parseFloat(request.getParameter(HB_DL));
			donationEntryHeader.setHbDl(hbDl);
		}
		if (request.getParameter(TEMPERATURE) != null
				&& !request.getParameter(TEMPERATURE).equals("")) {
			float temprature = Float.parseFloat(request
					.getParameter(TEMPERATURE));
			donationEntryHeader.setTemp(temprature);
		}
		if (request.getParameter(BP) != null
				&& !request.getParameter(BP).equals("")) {
			String bp = request.getParameter(BP);
			donationEntryHeader.setBp(bp);
		}
		if (request.getParameter(PHLEBOTOMY_SITE) != null
				&& !request.getParameter(PHLEBOTOMY_SITE).equals("")) {
			phlebotomySite = request.getParameter(PHLEBOTOMY_SITE);
			donationEntryHeader.setPhlebotomy(phlebotomySite);
		}
		if (request.getParameter(VOL_REP) != null
				&& !request.getParameter(VOL_REP).equals("")) {
			String volRep = request.getParameter(VOL_REP);
			donationEntryHeader.setVolRep(volRep);
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !request.getParameter(EMPLOYEE_ID).equals("")) {
			int collectedBy = Integer.parseInt(request
					.getParameter(EMPLOYEE_ID));
			if (collectedBy != 0) {
				MasEmployee masemployee = new MasEmployee();
				masemployee.setId(collectedBy);
				donationEntryHeader.setCollectedBy(masemployee);
			}
		}

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		// Users user = (Users) session.getAttribute("users");
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
			donationEntryHeader.setLastChgBy(userName);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			donationEntryHeader.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
		}

		if (request.getParameter(LAST_DONATED_DATE) != null
				&& !(request.getParameter(LAST_DONATED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(LAST_DONATED_DATE));
			donationEntryHeader.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
		}
		if (request.getParameter(COLLECTION_DATE) != null
				&& !(request.getParameter(COLLECTION_DATE).equals(""))) {
			lastDonated = request.getParameter(COLLECTION_DATE);
			donationEntryHeader.setCollectionDate(HMSUtil
					.convertStringTypeDateToDateType(lastDonated));
		}
		if (request.getParameter(EXPIRY_DATE) != null
				&& !(request.getParameter(EXPIRY_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(EXPIRY_DATE));
			donationEntryHeader.setExpiryDate(HMSUtil
					.convertStringTypeDateToDateType(date));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			donationEntryHeader.setLastChgTime(time);
		}
		if (request.getParameter(COLLECTION_TIME) != null
				&& !(request.getParameter(COLLECTION_TIME).equals(""))) {
			currentTime = request.getParameter(COLLECTION_TIME);
			donationEntryHeader.setCollectionTime(time);
		}
		donationEntryHeader.setSampleScreening("n");

		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		if (bloodDonationId != 0) {
			infoMap.put("bloodDonationId", bloodDonationId);
		}
		infoMap.put("donationhdId", donationhdId);
		infoMap.put("donationEntryHeader", donationEntryHeader);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("hinId", hinId);
		infoMap.put("donationSeqNo", donationSeqNo);

		try {
			Vector blood_Bag_No = box.getVector(BLOOD_BAG_NO);
			Vector quantity = box.getVector(QUANTITY);
			Vector expDate = box.getVector(EXPIRY_DATE);
			Vector component_id = box.getVector(BLOOD_COMPONENT_ID);
			Vector blood_donation_detail_id = box
					.getVector(BLOOD_DONATION_ENTRY_DETAIL_ID);
			int counter = 0;
			for (int i = 0; i < component_id.size(); i++) {
				if (!component_id.get(i).toString().equals(""))
					counter++;
			}
			noOfRecords = counter;
			for (int i = 0; i < noOfRecords; i++) {
				componentList.add(component_id.get(i));
			}
			infoMap.put("blood_donation_detail_id", blood_donation_detail_id);
			infoMap.put("blood_Bag_No", blood_Bag_No);
			infoMap.put("quantity", quantity);
			infoMap.put("expDate", expDate);
			infoMap.put("donationMainIdFromRequest", donationMainIdFromRequest);
			infoMap.put("componentList", componentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		infoMap.put("box", box);
		boolean success = false;
		String jsp = "";
		String message = "";

		if (returnMap.get("donationSeqNo") != null) {
			donationSeqNo = (String) returnMap.get("donationSeqNo");
		}

		boolean saved = false;
		saved = bloodBankHandlerService.submitBloodDonationEntry(infoMap);
		if (saved) {
			message = "Blood Doantion has been done Successfully !!";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		url = "/hms/hms/bloodBank?method=showBloodDonationEntryJsp";
		jsp = BLD_MSG_DONATION + ".jsp";

		map.put("donationhdId", donationhdId);
		map.put("donationSeqNo", donationSeqNo);
		map.put("url", url);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// ------Donor Blood Pending For Sample Screening-------
	public ModelAndView showDonorPendingSampleScreeningJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null)
			deptName = (String) session.getAttribute("deptName");
		detailsMap = bloodBankHandlerService.getDetailsForDonorSampleScreening();
		patientMap = bloodBankHandlerService.getDonorSampleScreeningGrid(mapForDs);
		jsp = DONOR_PENDING_SAMPLE_SCREENING + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// ------Search -Donor Deatil For Sample
	// Screening--------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView searchDonorForBloodSampleScreening(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		String screeningStatus = "";
		String serviceNo = "";
		String hinNo = "";
		String adNo = "";
		String donationNo = "";
		String patName = "";

		int donationId = 0;
		int hinId = 0;
		String deptName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();

		try {

			if (session.getAttribute("deptName") != null)
				deptName = (String) session.getAttribute("deptName");

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
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
			if (request.getParameter(DONATION_NO) != null
					&& !(request.getParameter(DONATION_NO).equals(""))) {
				donationNo = request.getParameter(DONATION_NO);
				mapForDs.put("donationNo", donationNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DONOR_NAME) != null
					&& !(request.getParameter(DONOR_NAME).equals(""))) {
				patName = request.getParameter(DONOR_NAME);
				mapForDs.put("patName", patName);
			}
			if (request.getParameter(SCREENING_STATUS) != null
					&& !(request.getParameter(SCREENING_STATUS).equals("0"))) {
				screeningStatus = request.getParameter(SCREENING_STATUS);
				mapForDs.put("screeningStatus", screeningStatus);
			}

			if (request.getParameter(BLOOD_DONATION_ENTRY_HEADER_ID) != null
					&& !(request.getParameter(BLOOD_DONATION_ENTRY_HEADER_ID)
							.equals("0"))) {
				donationId = new Integer(request
						.getParameter(BLOOD_DONATION_ENTRY_HEADER_ID));
				mapForDs.put("donationId", donationId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = bloodBankHandlerService
				.getDonorDetailBloodSampleScreening(mapForDs);
		map.put("box", box);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showDonorSampleScreeningJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = (String) session.getAttribute("deptName");
		int deptId = (Integer) session.getAttribute("deptId");
		int donationId = 0;
		if (request.getParameter("donationId") != null
				&& !(request.getParameter("donationId").equals("0"))) {
			donationId = Integer.parseInt(request.getParameter("donationId"));
			mapForDS.put("donationId", donationId);
		}
		if (donationId != 0) {
			map = bloodBankHandlerService.showDonorBloodSampleScreeningTest(donationId);
			String testSeqNo = "";
			testSeqNo = bloodBankHandlerService.getDonorSampleTestSeqForDisplay("DSTN");
			if (testSeqNo != null) {
				map.put("testSeqNo", testSeqNo);
			}
		}
		jsp = DONOR_SAMPLE_SCREENING + ".jsp";

		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView submitDonorBloodSampleScreeningTest(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		int componentMainIdFromRequest = 0;
		int noOfRecords = 0;
		int sampleTestBy = 0;
		int donationId = 0;
		int pageNo = 1;
		int hinId = 0;

		String testSeqNo = "";
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		List investigationList = new ArrayList();
		List resultList = new ArrayList();

		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("scrneeinghdId") != null) {
			componentMainIdFromRequest = Integer.parseInt(request
					.getParameter("scrneeinghdId"));
		}
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(SAMPLE_TEST_NO) != null
				&& !request.getParameter(SAMPLE_TEST_NO).equals("")) {
			testSeqNo = request.getParameter(SAMPLE_TEST_NO);
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !request.getParameter(EMPLOYEE_ID).equals("0")) {
			sampleTestBy = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(BLOOD_DONATION_ENTRY_DETAIL_ID) != null
				&& !request.getParameter(BLOOD_DONATION_ENTRY_DETAIL_ID)
						.equals("0")) {
			donationId = Integer.parseInt(request
					.getParameter(BLOOD_DONATION_ENTRY_DETAIL_ID));
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
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		BloodDonorSampleScreeningHeader donorSampleScreeningHeader = new BloodDonorSampleScreeningHeader();
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			donorSampleScreeningHeader.setHin(patient);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			donorSampleScreeningHeader.setDepartment(masDepartment);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			donorSampleScreeningHeader.setHospital(masHospital);
		}

		if (sampleTestBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(sampleTestBy);
			donorSampleScreeningHeader.setSampleTestBy(masEmployee);
		}

		if (donationId != 0) {
			BloodDonationEntryDetail donationEntryDetail = new BloodDonationEntryDetail();
			donationEntryDetail.setId(donationId);
			donorSampleScreeningHeader.setDonationDetail(donationEntryDetail);
		}
		donorSampleScreeningHeader.setSampleTestNo(testSeqNo);
		String temp = bloodBankHandlerService.generateDonorSampleTestNumber();

		donorSampleScreeningHeader.setSampleTestDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		donorSampleScreeningHeader.setLastChgBy(userName);
		donorSampleScreeningHeader.setBloodIssue("n");
		donorSampleScreeningHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		donorSampleScreeningHeader.setLastChgTime(time);
		infoMap.put("donorSampleScreeningHeader", donorSampleScreeningHeader);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("donationId", donationId);
		infoMap.put("hinId", hinId);
		infoMap.put("testSeqNo", testSeqNo);
		infoMap.put("componentMainIdFromRequest",componentMainIdFromRequest);

		try {

			Vector result = box.getVector(RESULT);
			Vector investigation_id = box.getVector(INVESTIGATION_ID);
			Vector donation_id = box.getVector(BLOOD_DONATION_ID);
			int counter = 0;

			for (int i = 0; i < investigation_id.size(); i++) {
				if (!investigation_id.get(i).toString().equals(""))
					counter++;
			}
			noOfRecords = counter;
			for (int i = 0; i < noOfRecords; i++) {
				investigationList.add(investigation_id.get(i));
			}
			infoMap.put("donation_id", donation_id);
			infoMap.put("result", result);
			infoMap.put("componentMainIdFromRequest",
					componentMainIdFromRequest);
			infoMap.put("investigationList", investigationList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		infoMap.put("box", box);
		String jsp = "";
		String message = "";
		if (returnMap.get("testSeqNo") != null) {
			testSeqNo = (String) returnMap.get("testSeqNo");
		}

		boolean saved = false;
		saved = bloodBankHandlerService
				.submitDonorBloodSampleScreeningTest(infoMap);
		if (saved) {
			message = "Screening Test has been done Successfully !!";
		} else {
			message = "Try Again!";
		}
		url = "/hms/hms/bloodBank?method=showDonorPendingSampleScreeningJsp";

		jsp = BLD_DONOR_MSG_REQ_ENTRY + ".jsp";
		map.put("testSeqNo", testSeqNo);
		map.put("url", url);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// --------------------------Blood Component Separation
	// -------------------------------
	public ModelAndView showBloodComponentSeparationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		map = (Map<String, Object>) bloodBankHandlerService
				.showBloodComponentSeparationJsp();
		jsp = BLOOD_COMPONENT_SEPERATION;
		jsp += ".jsp";
		title = "BloodComponentSeperation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView submitBloodTestEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		int componentMainIdFromRequest = 0;
		int noOfRecords = 0;
		int inpatientId = 0;
		int pageNo = 1;
		int hinId = 0;
		int componentId = 0;
		int rankId = 0;
		int relationId = 0;
		int unitId = 0;
		int sexId = 0;
		int receivedBy = 0;

		String patientType = "";
		String date = "";
		String time = "";
		String serialSeqNo = "";
		String name = "";
		String teleNo = "";
		String age = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		List investigationList = new ArrayList();

		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter(RANK_ID) != null
				&& !request.getParameter(RANK_ID).equals("0")) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));

		}
		if (request.getParameter(RELATION_ID) != null
				&& !request.getParameter(RELATION_ID).equals("0")) {
			relationId = Integer.parseInt(request.getParameter(RELATION_ID));
		}
		if (request.getParameter(UNIT_ID) != null
				&& !request.getParameter(UNIT_ID).equals("0")) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		}
		if (request.getParameter(SEX_ID) != null
				&& !request.getParameter(SEX_ID).equals("0")) {
			sexId = Integer.parseInt(request.getParameter(SEX_ID));
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !request.getParameter(EMPLOYEE_ID).equals("0")) {
			receivedBy = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(SERIAL_NO) != null
				&& !request.getParameter(SERIAL_NO).equals("")) {
			serialSeqNo = request.getParameter(SERIAL_NO);
		}
		if (request.getParameter(NAME) != null
				&& !request.getParameter(NAME).equals("")) {
			name = request.getParameter(NAME);
		}
		if (request.getParameter(PATIENT_TYPE) != null
				&& !request.getParameter(PATIENT_TYPE).equals("")) {
			patientType = request.getParameter(PATIENT_TYPE);
		}
		if (request.getParameter(AGE) != null
				&& !request.getParameter(AGE).equals("")) {
			age = request.getParameter(AGE);
		}
		if (request.getParameter(CONTACT_NUMBER) != null
				&& !request.getParameter(CONTACT_NUMBER).equals("")) {
			teleNo = request.getParameter(CONTACT_NUMBER);
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
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		BloodTestEntryHeader testEntryHeader = new BloodTestEntryHeader();
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			testEntryHeader.setHin(patient);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			testEntryHeader.setDepartment(masDepartment);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			testEntryHeader.setHospital(masHospital);
		}
		if (rankId != 0) {
			MasRank masRank = new MasRank();
			masRank.setId(rankId);
			testEntryHeader.setRank(masRank);
		}
		if (relationId != 0) {
			MasRelation masRelation = new MasRelation();
			masRelation.setId(relationId);
			testEntryHeader.setRelation(masRelation);
		}
		if (unitId != 0) {
			MasUnit masUnit = new MasUnit();
			masUnit.setId(unitId);
			testEntryHeader.setUnit(masUnit);
		}
		if (sexId != 0) {
			MasAdministrativeSex administrativeSex = new MasAdministrativeSex();
			administrativeSex.setId(sexId);
			testEntryHeader.setSex(administrativeSex);
		}
		if (receivedBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(receivedBy);
			testEntryHeader.setReceivedBy(masEmployee);
		}
		testEntryHeader.setSerialNo(serialSeqNo);
		String temp = bloodBankHandlerService.generateSerialNumber();

		testEntryHeader.setType(patientType);
		testEntryHeader.setName(name);
		testEntryHeader.setTestDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		testEntryHeader.setAge(age);
		testEntryHeader.setTeleNo(teleNo);
		testEntryHeader.setLastChgBy(userName);
		testEntryHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		testEntryHeader.setLastChgTime(time);
		infoMap.put("testEntryHeader", testEntryHeader);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("hinId", hinId);
		infoMap.put("serialSeqNo", serialSeqNo);

		try {

			/*
			 * Vector result = box.getVector(RESULT); Vector investigation_id =
			 * box.getVector(INVESTIGATION_ID); int counter = 0;
			 *
			 * for (int i = 0; i < investigation_id.size(); i++) { if
			 * (!investigation_id.get(i).toString().equals("")) counter++; }
			 * noOfRecords = counter; for (int i = 0; i < noOfRecords; i++) {
			 * investigationList.add(investigation_id.get(i)); }
			 */

			Vector result = new Vector();

			int rowCount = box.getInt("rowCount");
			if (rowCount > 0) {
				for (int i = 1; i <= rowCount; i++) {
					if (box.getInt(INVESTIGATION_ID + i) != 0) {
						investigationList.add(box.getInt(INVESTIGATION_ID + i));
						result.add(box.getString(RESULT + i));
					}
				}

			}
			infoMap.put("result", result);
			infoMap.put("componentMainIdFromRequest",
					componentMainIdFromRequest);
			infoMap.put("investigationList", investigationList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		infoMap.put("box", box);
		boolean success = false;
		String jsp = "";
		String message = "";
		if (returnMap.get("serialSeqNo") != null) {
			serialSeqNo = (String) returnMap.get("serialSeqNo");
		}

		boolean saved = false;
		saved = bloodBankHandlerService.submitBloodTestEntry(infoMap);
		if (saved) {
			message = "Blood Test Entry has been done Successfully !!";
		} else {
			message = "Try Again!";
		}
		url = "/hms/hms/bloodBank?method=showBloodTestEntryJsp";

		jsp = BLD_MSG_TEST_ENTRY + ".jsp";
		map.put("serialSeqNo", serialSeqNo);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// ---------------Blood Reaction Form Entry ---------------------------
	public ModelAndView showSearchPatientForReactionJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = bloodBankHandlerService.showSearchPatientForReactionJsp();
		jsp = BLD_SEARCH_REACTION_FORM + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchPatientForBloodReaction(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String serviceNo = "";
		String patientFName = "";
		String patientLName = "";
		String hinNo = "";
		String adNo = "";
		String pType = "";
		int inpatientId = 0;
		int departmentId = 0;
		int deptId = 0;
		String deptName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
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
		if (request.getParameter(AD_NO) != null
				&& !(request.getParameter(AD_NO).equals(""))) {
			adNo = request.getParameter(AD_NO);
			mapForDs.put("adNo", adNo);
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
		if (request.getParameter("inpatientId") != null
				&& !(request.getParameter("inpatientIds").equals("0"))) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			mapForDs.put("inpatientId", inpatientId);
		}

		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
			mapForDs.put("departmentId", departmentId);
		}

		patientMap = bloodBankHandlerService
				.searchPatientForBloodReaction(mapForDs);
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		if (patientMap.get("wardList") != null) {
			wardList = (List<MasDepartment>) patientMap.get("wardList");
			map.put("wardList", wardList);
		}
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showReactionFormEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int inpatientId = 0;
		if (request.getParameter("inpatientId") != null
				&& !(request.getParameter("inpatientId").equals("0"))) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			mapForDS.put("inpatientId", inpatientId);
		}
		if (inpatientId != 0) {
			map = bloodBankHandlerService.showReactionFormEntryJsp(inpatientId);
			String entrySeqNo = "";
			entrySeqNo = bloodBankHandlerService.getEntrySeqForDisplay("EN");
			if (entrySeqNo != null) {
				map.put("entrySeqNo", entrySeqNo);
			}
		}
		jsp = BLD_REACTION_FORM_ENTRY + ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView submitBloodReactionEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		BloodReactionEntry bldReactionEntry = new BloodReactionEntry();
		Date currentDate = new Date();
		Date reactionDate = new Date();
		Date issuedDate = new Date();
		Date dateTransfussion = new Date();

		String changedBy = "";
		String date = "";
		String time = "";
		String issuedTime = "";
		String donorName = "";
		String issuedTo = "";
		String entrySeqNo = "";
		String pyrexia = "";
		String itching = "";
		String urticarla = "";
		String elseWehere = "";
		String painBack = "";
		String head = "";
		String chest = "";
		String jaundice = "";
		String anaphylaxia = "";
		String fallOfBp = "";
		String rigor = "";
		String riseTemp = "";
		String haemoglobinuria = "";
		String timeCompleted = "";
		String anuria = "";
		String bloodBagNo = "";
		String tempTransfussion = "";
		String wdNo = "";
		String timeStarted = "";
		String untowardReaction = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		int hinId = 0;
		int inpatientId = 0;
		int issuedBy = 0;
		int crossMatchedBy = 0;
		int stockDetailId = 0;
		int bloodGroupId = 0;

		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			bldReactionEntry.setHospital(masHospital);
		}
		if (deptId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			bldReactionEntry.setDepartment(masDepartment);
		}
		if (request.getParameter(ENTRY_NO) != null
				&& !(request.getParameter(ENTRY_NO).equals(""))) {
			entrySeqNo = request.getParameter(ENTRY_NO);
		}
		bldReactionEntry.setEntryNo(entrySeqNo);
		String temp = bloodBankHandlerService.generateEntryNumber();

		if (request.getParameter(REACTION_DATE) != null
				&& !(request.getParameter(REACTION_DATE).equals(""))) {
			reactionDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(REACTION_DATE));
			bldReactionEntry.setRactionDate(HMSUtil
					.convertStringTypeDateToDateType(date));
		}
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			if (hinId != 0) {
				Patient patient = new Patient();
				patient.setId(hinId);
				bldReactionEntry.setHin(patient);
			}
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			if (hinId != 0) {
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				bldReactionEntry.setInpatient(inpatient);
			}
		}
		if (request.getParameter(BLOOD_BAG_NO) != null
				&& !request.getParameter(BLOOD_BAG_NO).equals("")) {
			bloodBagNo = request.getParameter(BLOOD_BAG_NO);
			bldReactionEntry.setBloodBagNo(bloodBagNo);
		}
		if (request.getParameter(ISSUED_DATE) != null
				&& !(request.getParameter(ISSUED_DATE).equals(""))) {
			issuedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ISSUED_DATE));
			bldReactionEntry.setIssuedDate(HMSUtil
					.convertStringTypeDateToDateType(date));
		}
		if (request.getParameter(ISSUED_TIME) != null
				&& !(request.getParameter(ISSUED_TIME).equals(""))) {
			issuedTime = request.getParameter(ISSUED_TIME);
			bldReactionEntry.setIssuedTime(issuedTime);
		}
		if (request.getParameter(DONOR_NAME) != null
				&& !(request.getParameter(DONOR_NAME).equals(""))) {
			donorName = request.getParameter(DONOR_NAME);
			bldReactionEntry.setDonorName(donorName);
		}

		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& !request.getParameter(BLOOD_GROUP_ID).equals("0")&& !request.getParameter(BLOOD_GROUP_ID).equals("")) {
			bloodGroupId = Integer.parseInt(request.getParameter(BLOOD_GROUP_ID));
				MasBloodGroup masBloodGroup = new MasBloodGroup();
				masBloodGroup.setId(bloodGroupId);
				bldReactionEntry.setBloodGroup(masBloodGroup);
		}
		if (request.getParameter(CROSS_MATCHED_BY) != null
				&& !request.getParameter(CROSS_MATCHED_BY).equals("0")) {
			crossMatchedBy = Integer.parseInt(request
					.getParameter(CROSS_MATCHED_BY));
			if (crossMatchedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(crossMatchedBy);
				bldReactionEntry.setCrossMatchedBy(masEmployee);
			}
		}
		if (request.getParameter(ISSUED_TO) != null
				&& !(request.getParameter(ISSUED_TO).equals(""))) {
			issuedTo = request.getParameter(ISSUED_TO);
			bldReactionEntry.setIssuedTo(issuedTo);
		}
		if (request.getParameter(ISSUED_BY) != null
				&& !request.getParameter(ISSUED_BY).equals("0")) {
			issuedBy = Integer.parseInt(request.getParameter(ISSUED_BY));
			if (issuedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(issuedBy);
				bldReactionEntry.setIssuedBy(masEmployee);
			}
		}

		if (request.getParameter(WD_NO) != null
				&& !(request.getParameter(WD_NO).equals(""))) {
			wdNo = request.getParameter(WD_NO);
			bldReactionEntry.setWdNo(wdNo);
		}

		if (request.getParameter(TEMP_TRANSFUSSION) != null
				&& !(request.getParameter(TEMP_TRANSFUSSION).equals(""))) {
			tempTransfussion = request.getParameter(TEMP_TRANSFUSSION);
			bldReactionEntry.setTransfussion(tempTransfussion);
		}
		if (request.getParameter(TRANSFUSSION_DATE) != null
				&& !(request.getParameter(TRANSFUSSION_DATE).equals(""))) {
			dateTransfussion = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TRANSFUSSION_DATE));
			bldReactionEntry.setDateTransfussion(HMSUtil
					.convertStringTypeDateToDateType(date));
		}

		if (request.getParameter(STARTED_TIME) != null
				&& !(request.getParameter(STARTED_TIME).equals(""))) {
			timeStarted = request.getParameter(STARTED_TIME);
			bldReactionEntry.setTimeStarted(timeStarted);
		}

		if (request.getParameter(COMPLETED_TIME) != null
				&& !(request.getParameter(COMPLETED_TIME).equals(""))) {
			timeCompleted = request.getParameter(COMPLETED_TIME);
			bldReactionEntry.setTimeCompleted(timeCompleted);
		}
		if (request.getParameter(PYREXIA) != null) {
			bldReactionEntry.setPyrexia(request.getParameter(PYREXIA));

		}
		if (request.getParameter(RIGOR) != null) {
			bldReactionEntry.setRigor(request.getParameter(RIGOR));
		}

		if (request.getParameter(RISE_TEMP) != null) {

			bldReactionEntry.setRiseTemp(request.getParameter(RISE_TEMP));
		}

		if (request.getParameter(FALL_BP) != null) {
			bldReactionEntry.setFallOfBp(request.getParameter(FALL_BP));
		}

		if (request.getParameter(ITCHING) != null
				&& !(request.getParameter(ITCHING).equals(""))) {
			bldReactionEntry.setItching(request.getParameter(ITCHING));
		}

		if (request.getParameter(URTICARLA) != null
				&& !(request.getParameter(URTICARLA).equals(""))) {
			bldReactionEntry.setUrticarla(request.getParameter(URTICARLA));
		}

		if (request.getParameter(ANAPHYLAXIA) != null
				&& !(request.getParameter(ANAPHYLAXIA).equals(""))) {
			bldReactionEntry.setAnaphylaxia(request.getParameter(ANAPHYLAXIA));
		}

		if (request.getParameter(PAIN_BACK) != null
				&& !(request.getParameter(PAIN_BACK).equals(""))) {
			bldReactionEntry.setPainBack(request.getParameter(PAIN_BACK));
		}

		if (request.getParameter(HEAD) != null
				&& !(request.getParameter(HEAD).equals(""))) {
			bldReactionEntry.setHead(request.getParameter(HEAD));
		}

		if (request.getParameter(CHEST) != null) {
			bldReactionEntry.setChest(request.getParameter(CHEST));
		}

		if (request.getParameter(ELSE_WHERE) != null
				&& !(request.getParameter(ELSE_WHERE).equals(""))) {
			bldReactionEntry.setElseWehere(request.getParameter(ELSE_WHERE));
		}

		if (request.getParameter(JAUNDICE) != null
				&& !(request.getParameter(JAUNDICE).equals(""))) {
			bldReactionEntry.setJaundice(request.getParameter(JAUNDICE));
		}

		if (request.getParameter(HEMOGLOBIN) != null
				&& !(request.getParameter(HEMOGLOBIN).equals(""))) {
			bldReactionEntry.setHaemoglobinuria(request
					.getParameter(HEMOGLOBIN));
		}

		if (request.getParameter(ANURIA) != null
				&& !(request.getParameter(ANURIA).equals(""))) {
			bldReactionEntry.setAnuria(request.getParameter(ANURIA));
		}

		if (request.getParameter(UNTOWARD_REACTION) != null
				&& !(request.getParameter(UNTOWARD_REACTION).equals(""))) {
			untowardReaction = request.getParameter(UNTOWARD_REACTION);
			bldReactionEntry.setUntowardReaction(untowardReaction);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			bldReactionEntry.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			bldReactionEntry.setLastChgTime(time);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			map.put("userName", userName);
		}
		// Users user = (Users) session.getAttribute("users");
		if (session.getAttribute(CHANGED_BY) != null) {
			userName = (String) session.getAttribute(CHANGED_BY);
			bldReactionEntry.setLastChgBy(userName);
		}
		bldReactionEntry.setScreening("n");
		boolean saved = false;
		saved = bloodBankHandlerService
				.submitBloodReactionEntry(bldReactionEntry);
		if (saved) {
			message = "Blood Reaction Entry has been done Successfully !!";
		} else {
			message = "Try Again!";
		}

		jsp = BLD_MSG_REACTION_ENTRY + ".jsp";
		map.put("userName", userName);
		map.put("hospitalId", hospitalId);
		map.put("deptId", deptId);
		map.put("entrySeqNo", entrySeqNo);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public void fillPatientDetail(HttpServletRequest request,
			HttpServletResponse response) {

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
		map = bloodBankHandlerService.fillPatientDetail(dataMap);
		if (map.get("patientList") != null) {
			patientList = (List) map.get("patientList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (Patient patient : patientList) {
				sb.append("<item>");
				sb.append("<hinId>" + patient.getId() + "</hinId>");
				sb.append("<donerName>" + patient.getPFirstName()
						+ "</donerName>");
				if (patient.getRank() != null) {
					sb.append("<rankId>" + patient.getRank().getId()
							+ "</rankId>");
				} else {
					sb.append("<rankId>-</rankId>");
				}
				if (patient.getBloodGroup() != null) {
					sb.append("<bloodGroupId>"
							+ patient.getBloodGroup().getId()
							+ "</bloodGroupId>");
				} else {
					sb.append("<bloodGroupId>-</bloodGroupId>");
				}

				if (patient.getUnit() != null
						&& !("" + patient.getUnit()).trim().equals("")) {
					sb.append("<unitAddress>"
							+ patient.getUnit().getUnitAddress()
							+ "</unitAddress>");
				} else {
					sb.append("<unitAddress>-</unitAddress>");
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

	// ----------------------For update Donation
	// entryForm-----------------------------------
	public ModelAndView showPatientSearchForDonationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = BLOOD_SEARCH_DONATION + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchPatientForUpdateDonation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String serviceNo = "";
		String donationNo = "";
		String adNo = "";
		String pType = "";
		String deptType = "";
		int bloodDonationId = 0;
		int departmentId = 0;
		int hinId = 0;
		int deptId = 0;
		String deptName = "";
		String donorName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		if (request.getParameter(DONATION_NO) != null
				&& !(request.getParameter(DONATION_NO).equals(""))) {
			donationNo = request.getParameter(DONATION_NO);
			mapForDs.put("donationNo", donationNo);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}
		if (request.getParameter(DONOR_NAME) != null
				&& !(request.getParameter(DONOR_NAME).equals(""))) {
			donorName = request.getParameter(DONOR_NAME);
			mapForDs.put("donorName", donorName);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals("0"))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			mapForDs.put("hinId", hinId);
		}
		if (request.getParameter("bloodDonationId") != null
				&& !(request.getParameter("bloodDonationId").equals("0"))) {
			bloodDonationId = Integer.parseInt(request
					.getParameter("bloodDonationId"));
			mapForDs.put("bloodDonationId", bloodDonationId);
		}

		patientMap = bloodBankHandlerService
				.getPatientForUpdateDonation(mapForDs);

		map.put("deptType", deptType);
		map.put("deptName", deptName);
		map.put("deptId", deptId);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		jsp = BLOOD_SEARCH_DONATION + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateDonationEntry(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int bloodDonationId = 0;
		if (request.getParameter("bloodDonationId") != null
				&& !(request.getParameter("bloodDonationId").equals("0"))) {
			bloodDonationId = Integer.parseInt(request
					.getParameter("bloodDonationId"));
			mapForDS.put("bloodDonationId", bloodDonationId);
		}
		if (bloodDonationId != 0) {
			map = bloodBankHandlerService
					.showUpdateDonationEntry(bloodDonationId);
		}
		jsp = BLOOD_UPDATE_DONATION + ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showPopUpBloodIssueJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		int bloodComponentId = 0;
		int rowNo = 0;

		if (request.getParameter("bloodComponentId") != null) {
			bloodComponentId = Integer.parseInt(request
					.getParameter("bloodComponentId"));
		}
		if (request.getParameter("rowNo") != null) {
			rowNo = Integer.parseInt(request.getParameter("rowNo"));
		}
		map.put("bloodComponentId", bloodComponentId);
		dataMap = bloodBankHandlerService.showPopUpBloodIssueJsp(map);
		;
		jsp = BLOOD_POP_UP_ISSUE;
		jsp += ".jsp";
		title = "BloodComponent";
		dataMap.put("rowNo", rowNo);
		dataMap.put("contentJsp", jsp);
		dataMap.put("title", title);
		return new ModelAndView(BLOOD_POP_UP_ISSUE, "map", dataMap);
	}

	public ModelAndView showPatientSearchForReactionJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = BLOOD_SEARCH_REACTION + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchPatientForUpdateReaction(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String serviceNo = "";
		String entryNo = "";
		String hinNo = "";
		int reactionId = 0;
		int departmentId = 0;
		int hinId = 0;
		String patientName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		if (request.getParameter(ENTRY_NO) != null
				&& !(request.getParameter(ENTRY_NO).equals(""))) {
			entryNo = request.getParameter(ENTRY_NO);
			mapForDs.put("entryNo", entryNo);
		}
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
		if (request.getParameter(PATIENT_NAME) != null
				&& !(request.getParameter(PATIENT_NAME).equals(""))) {
			patientName = request.getParameter(PATIENT_NAME);
			mapForDs.put("patientName", patientName);
		}
		if (request.getParameter(BLOOD_REACTION_ID) != null
				&& !(request.getParameter(BLOOD_REACTION_ID).equals("0"))) {
			reactionId = Integer.parseInt(request
					.getParameter(BLOOD_REACTION_ID));
			mapForDs.put("reactionId", reactionId);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals("0"))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			mapForDs.put("hinId", hinId);
		}
		patientMap = bloodBankHandlerService
				.searchPatientForUpdateReaction(mapForDs);

		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateTestEntry(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int bloodTestId = 0;
		if (request.getParameter(BLOOD_TEST_ID) != null
				&& !(request.getParameter(BLOOD_TEST_ID).equals("0"))) {
			bloodTestId = Integer.parseInt(request.getParameter(BLOOD_TEST_ID));
			mapForDS.put("bloodTestId", bloodTestId);
		}
		if (bloodTestId != 0) {
			map = bloodBankHandlerService.showUpdateTestEntry(bloodTestId);
		}
		jsp = BLOOD_UPDATE_TEST + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateBloodReaction(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		BloodReactionEntry bldReactionEntry = new BloodReactionEntry();
		Date currentDate = new Date();
		Date reactionDate = new Date();
		Date issuedDate = new Date();
		Date dateTransfussion = new Date();

		String changedBy = "";
		String date = "";
		String time = "";
		String issuedTime = "";
		String donorName = "";
		String issuedTo = "";
		String entrySeqNo = "";
		String pyrexia = "";
		String itching = "";
		String urticarla = "";
		String elseWehere = "";
		String painBack = "";
		String head = "";
		String chest = "";
		String jaundice = "";
		String anaphylaxia = "";
		String fallOfBp = "";
		String rigor = "";
		String riseTemp = "";
		String haemoglobinuria = "";
		String timeCompleted = "";
		String anuria = "";
		String bloodBagNo = "";
		String tempTransfussion = "";
		String wdNo = "";
		String timeStarted = "";
		String untowardReaction = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		int hinId = 0;
		int inpatientId = 0;
		int issuedBy = 0;
		int crossMatchedBy = 0;
		int stockDetailId = 0;
		int bloodGroupId = 0;

		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		if (hospitalId != 0) {

		}
		if (deptId != 0) {

		}
		if (request.getParameter(ENTRY_NO) != null
				&& !(request.getParameter(ENTRY_NO).equals(""))) {
			entrySeqNo = request.getParameter(ENTRY_NO);
		}
		if (request.getParameter(REACTION_DATE) != null
				&& !(request.getParameter(REACTION_DATE).equals(""))) {
			reactionDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(REACTION_DATE));

		}
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));

		}
		if (request.getParameter(BLOOD_BAG_NO) != null
				&& !request.getParameter(BLOOD_BAG_NO).equals("")) {
			bloodBagNo = request.getParameter(BLOOD_BAG_NO);

		}
		if (request.getParameter(ISSUED_DATE) != null
				&& !(request.getParameter(ISSUED_DATE).equals(""))) {
			issuedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ISSUED_DATE));

		}
		if (request.getParameter(ISSUED_TIME) != null
				&& !(request.getParameter(ISSUED_TIME).equals(""))) {
			issuedTime = request.getParameter(ISSUED_TIME);

		}
		if (request.getParameter(DONOR_NAME) != null
				&& !(request.getParameter(DONOR_NAME).equals(""))) {
			donorName = request.getParameter(DONOR_NAME);

		}

		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& !request.getParameter(BLOOD_GROUP_ID).equals("0")) {
			bloodGroupId = Integer.parseInt(request
					.getParameter(BLOOD_GROUP_ID));
		}
		if (request.getParameter(CROSS_MATCHED_BY) != null
				&& !request.getParameter(CROSS_MATCHED_BY).equals("0")) {
			crossMatchedBy = Integer.parseInt(request
					.getParameter(CROSS_MATCHED_BY));
		}
		if (request.getParameter(ISSUED_TO) != null
				&& !(request.getParameter(ISSUED_TO).equals(""))) {
			issuedTo = request.getParameter(ISSUED_TO);

		}
		if (request.getParameter(ISSUED_BY) != null
				&& !request.getParameter(ISSUED_BY).equals("0")) {
			issuedBy = Integer.parseInt(request.getParameter(ISSUED_BY));

		}

		if (request.getParameter(WD_NO) != null
				&& !(request.getParameter(WD_NO).equals(""))) {
			wdNo = request.getParameter(WD_NO);

		}

		if (request.getParameter(TEMP_TRANSFUSSION) != null
				&& !(request.getParameter(TEMP_TRANSFUSSION).equals(""))) {
			tempTransfussion = request.getParameter(TEMP_TRANSFUSSION);

		}
		if (request.getParameter(TRANSFUSSION_DATE) != null
				&& !(request.getParameter(TRANSFUSSION_DATE).equals(""))) {
			dateTransfussion = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TRANSFUSSION_DATE));

		}

		if (request.getParameter(STARTED_TIME) != null
				&& !(request.getParameter(STARTED_TIME).equals(""))) {
			timeStarted = request.getParameter(STARTED_TIME);

		}

		if (request.getParameter(COMPLETED_TIME) != null
				&& !(request.getParameter(COMPLETED_TIME).equals(""))) {
			timeCompleted = request.getParameter(COMPLETED_TIME);

		}
		if (request.getParameter(PYREXIA) != null) {
			pyrexia = request.getParameter(PYREXIA);
		}
		if (request.getParameter(RIGOR) != null) {
			rigor = request.getParameter(RIGOR);
		}
		if (request.getParameter(RISE_TEMP) != null) {
			riseTemp = request.getParameter(RISE_TEMP);
		}

		if (request.getParameter(FALL_BP) != null) {
			fallOfBp = request.getParameter(FALL_BP);
		}

		if (request.getParameter(ITCHING) != null
				&& !(request.getParameter(ITCHING).equals(""))) {
			itching = request.getParameter(ITCHING);
		}

		if (request.getParameter(URTICARLA) != null
				&& !(request.getParameter(URTICARLA).equals(""))) {
			urticarla = request.getParameter(URTICARLA);
		}
		if (request.getParameter(ANAPHYLAXIA) != null
				&& !(request.getParameter(ANAPHYLAXIA).equals(""))) {
			anaphylaxia = request.getParameter(ANAPHYLAXIA);
		}

		if (request.getParameter(PAIN_BACK) != null
				&& !(request.getParameter(PAIN_BACK).equals(""))) {
			painBack = request.getParameter(PAIN_BACK);
		}

		if (request.getParameter(HEAD) != null
				&& !(request.getParameter(HEAD).equals(""))) {
			head = request.getParameter(HEAD);
		}

		if (request.getParameter(CHEST) != null) {
			chest = request.getParameter(CHEST);
		}

		if (request.getParameter(ELSE_WHERE) != null
				&& !(request.getParameter(ELSE_WHERE).equals(""))) {
			elseWehere = request.getParameter(ELSE_WHERE);
		}
		if (request.getParameter(JAUNDICE) != null
				&& !(request.getParameter(JAUNDICE).equals(""))) {
			jaundice = request.getParameter(JAUNDICE);
		}

		if (request.getParameter(HEMOGLOBIN) != null
				&& !(request.getParameter(HEMOGLOBIN).equals(""))) {
			haemoglobinuria = request.getParameter(HEMOGLOBIN);
		}

		if (request.getParameter(ANURIA) != null
				&& !(request.getParameter(ANURIA).equals(""))) {
			anuria = request.getParameter(ANURIA);
		}

		if (request.getParameter(UNTOWARD_REACTION) != null
				&& !(request.getParameter(UNTOWARD_REACTION).equals(""))) {
			untowardReaction = request.getParameter(UNTOWARD_REACTION);

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
		int blooReactionId = 0;
		if (request.getParameter(BLOOD_REACTION_ID) != null
				&& !(request.getParameter(BLOOD_REACTION_ID).equals(""))) {
			blooReactionId = Integer.parseInt(request
					.getParameter(BLOOD_REACTION_ID));
		}
		if (session.getAttribute(CHANGED_BY) != null) {
			userName = (String) session.getAttribute(CHANGED_BY);
		}
		generalMap.put("blooReactionId", blooReactionId);
		generalMap.put("entrySeqNo", entrySeqNo);
		generalMap.put("hinId", hinId);
		generalMap.put("inpatientId", inpatientId);
		generalMap.put("bloodGroupId", bloodGroupId);
		generalMap.put("haemoglobinuria", haemoglobinuria);
		generalMap.put("anaphylaxia", anaphylaxia);
		generalMap.put("bloodBagNo", bloodBagNo);
		generalMap.put("wdNo", wdNo);
		generalMap.put("tempTransfussion", tempTransfussion);
		generalMap.put("currentDate", dateTransfussion);
		generalMap.put("issuedTo", issuedTo);
		generalMap.put("timeCompleted", timeCompleted);
		generalMap.put("timeStarted", timeStarted);
		generalMap.put("pyrexia", pyrexia);
		generalMap.put("riseTemp", riseTemp);
		generalMap.put("fallOfBp", fallOfBp);
		generalMap.put("rigor", rigor);
		generalMap.put("reactionDate", reactionDate);
		generalMap.put("itching", itching);
		generalMap.put("crossMatchedBy", crossMatchedBy);
		generalMap.put("issuedBy", issuedBy);
		generalMap.put("urticarla", urticarla);
		generalMap.put("donorName", donorName);
		generalMap.put("reactionDate", reactionDate);
		generalMap.put("itching", itching);
		generalMap.put("crossMatchedBy", crossMatchedBy);
		generalMap.put("urticarla", urticarla);
		generalMap.put("currentDate", issuedDate);
		generalMap.put("painBack", painBack);
		generalMap.put("head", head);
		generalMap.put("chest", chest);
		generalMap.put("elseWehere", elseWehere);
		generalMap.put("untowardReaction", untowardReaction);
		generalMap.put("issuedTime", issuedTime);
		generalMap.put("jaundice", jaundice);
		generalMap.put("anuria", anuria);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		boolean dataUpdated = false;
		dataUpdated = bloodBankHandlerService.updateBloodReaction(generalMap);
		if (dataUpdated) {
			message = "Blood Reaction Entry has been Updated Successfully !!";
		} else {
			message = "Try Again!";
		}

		jsp = BLD_MSG_REACTION_ENTRY + ".jsp";
		map.put("userName", userName);
		map.put("blooReactionId", blooReactionId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptId", deptId);
		map.put("entrySeqNo", entrySeqNo);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	// ------Show--Investigation Pending Transfusion Reaction-----------
	public ModelAndView showPendingForTransfussionReaction(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		map = bloodBankHandlerService.showPendingForTransfussionReaction();
		patientMap = bloodBankHandlerService.getTransfusionReactionGrid(mapForDs);
		jsp = BLOOD_PND_TRANS_REACTION + ".jsp";
		map.put("patientMap", patientMap);
		map.put("mapForDs", mapForDs);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// ---------Search Patient For Transfusion Reaction----
	public ModelAndView searchPatientForTransfussionReaction(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String bloodBagNo = "";
		String entryNo = "";
		String adNo = "";
		String pType = "";
		String deptType = "";
		int reactionId = 0;
		int departmentId = 0;
		int hinId = 0;
		int deptId = 0;
		int rankId = 0;
		String deptName = "";
		String patientFName = "";
		String patientLName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		if (request.getParameter(ENTRY_NO) != null
				&& !(request.getParameter(ENTRY_NO).equals(""))) {
			entryNo = request.getParameter(ENTRY_NO);
			mapForDs.put("entryNo", entryNo);
		}
		if (request.getParameter(BLOOD_BAG_NO) != null
				&& !(request.getParameter(BLOOD_BAG_NO).equals(""))) {
			bloodBagNo = request.getParameter(BLOOD_BAG_NO);
			mapForDs.put("bloodBagNo", bloodBagNo);
		}
		/*
		 * String reactionDate = null; if (request.getParameter(REACTION_DATE)
		 * != null && !(request.getParameter(REACTION_DATE).equals("0"))) {
		 * reactionDate = request.getParameter(REACTION_DATE);
		 * mapForDs.put("reactionDate", reactionDate); }
		 */
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
		if (request.getParameter(BLOOD_REACTION_ID) != null
				&& !(request.getParameter(BLOOD_REACTION_ID).equals("0"))) {
			reactionId = Integer.parseInt(request
					.getParameter(BLOOD_REACTION_ID));
			mapForDs.put("reactionId", reactionId);
		}
		String donorName = "";
		if (request.getParameter(DONOR_NAME) != null
				&& !(request.getParameter(DONOR_NAME).equals(""))) {
			donorName = request.getParameter(DONOR_NAME);
			mapForDs.put("donorName", donorName);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals("0"))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			mapForDs.put("hinId", hinId);
		}

		patientMap = bloodBankHandlerService
				.searchPatientForTransfussionReaction(mapForDs);

		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView submitTransfussionReaction(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		int componentMainIdFromRequest = 0;
		int noOfRecords = 0;
		int inpatientId = 0;
		int testBy = 0;
		int reactionId = 0;
		int pageNo = 1;
		int hinId = 0;
		int crossmatchBy = 0;
		int testSeqNo = 0;

		String fitBloodIssue = "";
		String hinNo = "";
		String date = "";
		String time = "";
		String compatibility = "";
		String minorRsDc = "";
		String majorRsDc = "";

		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		List investigationList = new ArrayList();

		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("bloodReactionId") != null) {
			componentMainIdFromRequest = Integer.parseInt(request
					.getParameter("bloodReactionId"));
		}
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(HIN_NO) != null
				&& !request.getParameter(HIN_NO).equals("")) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(TEST_NO) != null
				&& !request.getParameter(TEST_NO).equals("0")) {
			testSeqNo = Integer.parseInt(request.getParameter(TEST_NO));
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !request.getParameter(EMPLOYEE_ID).equals("0")) {
			testBy = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(CROSS_MATCHED_BY) != null
				&& !request.getParameter(CROSS_MATCHED_BY).equals("0")) {
			crossmatchBy = Integer.parseInt(request
					.getParameter(CROSS_MATCHED_BY));
		}
		if (request.getParameter(BLOOD_REACTION_ID) != null
				&& !request.getParameter(BLOOD_REACTION_ID).equals("0")) {
			reactionId = Integer.parseInt(request
					.getParameter(BLOOD_REACTION_ID));
		}
		if (request.getParameter(BLOOD_ISSUE) != null
				&& !(request.getParameter(BLOOD_ISSUE).equals(""))) {
			fitBloodIssue = request.getParameter(BLOOD_ISSUE);
		}
		if (request.getParameter(COMPATIBILITY) != null
				&& !(request.getParameter(COMPATIBILITY).equals(""))) {
			compatibility = request.getParameter(COMPATIBILITY);
		}
		String majorRs = "";
		if (request.getParameter(MAJOR_RS_DC) != null) {
			majorRs = "y";
		} else {
			majorRs = "n";
		}
		String majorDsDc = "";
		if (request.getParameter(MAJOR_DS_RC) != null) {
			majorDsDc = "y";
		} else {
			majorDsDc = "n";
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

		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		BloodTransfussionReactionHd transfussionReactionHd = new BloodTransfussionReactionHd();
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			transfussionReactionHd.setHin(patient);
		}
		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			transfussionReactionHd.setInpatient(inpatient);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			transfussionReactionHd.setDepartment(masDepartment);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			transfussionReactionHd.setHospital(masHospital);
		}

		if (testBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(testBy);
			transfussionReactionHd.setTestBy(masEmployee);
		}
		if (crossmatchBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(crossmatchBy);
			transfussionReactionHd.setCrossMatchBy(masEmployee);
		}

		if (reactionId != 0) {
			BloodReactionEntry bloodReactionEntry = new BloodReactionEntry();
			bloodReactionEntry.setId(reactionId);
			transfussionReactionHd.setReaction(bloodReactionEntry);
		}
		transfussionReactionHd.setTestNo(testSeqNo);
		int temp = bloodBankHandlerService.generateTransfusionTestNumber();

		transfussionReactionHd.setCompatibility(compatibility);
		transfussionReactionHd.setMajorRs(majorRs);
		transfussionReactionHd.setMajorDs(majorDsDc);
		transfussionReactionHd.setTestDate(HMSUtil.convertStringTypeDateToDateType(date));
		transfussionReactionHd.setLastChgBy(userName);
		transfussionReactionHd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
		transfussionReactionHd.setLastChgTime(time);
		infoMap.put("transfussionReactionHd", transfussionReactionHd);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("hinId", hinId);
		infoMap.put("testSeqNo", testSeqNo);
		infoMap.put("reactionId", reactionId);

		try {

			Vector result = box.getVector(RESULT);
			Vector investigation_id = box.getVector(INVESTIGATION_ID);
			int counter = 0;

			for (int i = 0; i < investigation_id.size(); i++) {
				if (!investigation_id.get(i).toString().equals(""))
					counter++;
			}
			noOfRecords = counter;
			for (int i = 0; i < noOfRecords; i++) {
				investigationList.add(investigation_id.get(i));
			}

			infoMap.put("componentMainIdFromRequest",
					componentMainIdFromRequest);
			infoMap.put("investigationList", investigationList);
			infoMap.put("result", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		infoMap.put("box", box);
		boolean success = false;
		String jsp = "";
		String message = "";
		if (returnMap.get("testSeqNo") != null) {
			testSeqNo = (Integer) returnMap.get("testSeqNo");
		}

		boolean saved = false;
		saved = bloodBankHandlerService.submitTransfussionReaction(infoMap);
		if (saved) {
			message = "Transfusion Reaction been done Successfully !!";
		} else {
			message = "Try Again!";
		}

		jsp = BLD_MSG_REACTION_TRNASFUSION + ".jsp";
		map.put("testSeqNo", testSeqNo);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// ---------show Transfusion Reaction---Screen----------
	public ModelAndView showTransfussionReaction(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = (String) session.getAttribute("deptName");
		int deptId = (Integer) session.getAttribute("deptId");
		int bloodReactionId = 0;
		if (request.getParameter(BLOOD_REACTION_ID) != null
				&& !(request.getParameter(BLOOD_REACTION_ID).equals("0"))) {
			bloodReactionId = Integer.parseInt(request
					.getParameter(BLOOD_REACTION_ID));
			mapForDS.put("bloodReactionId", bloodReactionId);
		}
		if (bloodReactionId != 0) {
			map = bloodBankHandlerService
					.showTransfussionReaction(bloodReactionId);
			String testSeqNo = "";
			testSeqNo = bloodBankHandlerService
					.getTransfussionTestSeqForDisplay("TRN");
			if (testSeqNo != null) {
				map.put("testSeqNo", testSeqNo);
			}
		}
		jsp = BLOOD_TRANSFUSSION_REACTION + ".jsp";

		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	// ------fill donor detail related Service Number---
	public void fillDonorDetail(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		String hinNo = "";

		try {
			if (request.getParameter("hinNo") != null) {
				hinNo = request.getParameter("hinNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("hinNo", hinNo);
		map = bloodBankHandlerService.fillDonorDetail(dataMap);
		if (map.get("patientList") != null) {
			patientList = (List) map.get("patientList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (Patient patient : patientList) {
				sb.append("<item>");
				sb.append("<hinId>" + patient.getId() + "</hinId>");
				sb.append("<donorName>" + patient.getPFirstName()+" "+patient.getPLastName()
						+ "</donorName>");
				if(patient.getPhoneNumber()!=null && !patient.getPhoneNumber().equals("")){
					sb.append("<teleNo>" + patient.getPhoneNumber() + "</teleNo>");
				}else{
					sb.append("<teleNo>" + "-" + "</teleNo>");
				}
				sb.append("<age>" + patient.getAge() + "</age>");
				if (patient.getMobileNumber() != null) {
					sb.append("<mobNo>" + patient.getMobileNumber()+ "</mobNo>");
				}
				if (patient.getBloodGroup() != null) {
					sb.append("<bloodGroupId>"+ patient.getBloodGroup().getId()+ "</bloodGroupId>");
				} else {
					sb.append("<bloodGroupId>-</bloodGroupId>");
				}
				if (patient.getState() != null) {
					sb.append("<stateId>" + patient.getState().getId()+ "</stateId>");
				} else {
					sb.append("<stateId>-</stateId>");
				}
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
				if (patient.getUnit() != null
						&& !("" + patient.getUnit()).trim().equals("")) {
					sb.append("<unitAddress>"
							+ patient.getUnit().getUnitAddress()
							+ "</unitAddress>");
				} else {
					sb.append("<unitAddress>-</unitAddress>");
				}
				if (patient.getOccupation() != null
						&& !("" + patient.getOccupation()).trim().equals("")) {
					sb.append("<occupId>"
							+ patient.getOccupation().getId()
							+ "</occupId>");
				} else {
					sb.append("<occupId>-</occupId>");
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

	@SuppressWarnings("unchecked")
	public ModelAndView submitPopbloodIssue(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int stockDetailId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(STOCK_DETAIL_ID) != null
				&& !(request.getParameter(STOCK_DETAIL_ID).equals(""))) {
			stockDetailId = Integer.parseInt(request
					.getParameter(STOCK_DETAIL_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		boolean dataDeleted = false;
		dataDeleted = bloodBankHandlerService.submitPopbloodIssue(
				stockDetailId, generalMap);
		if (dataDeleted == true) {
			message = "Blood Bag Issued successfully !!";
		} else {
			message = "Try Again!!";
		}
		url = "/hms/hms/bloodBank?method=showPopUpBloodIssueJsp";
		try {
			map = bloodBankHandlerService.showPopUpBloodIssueJsp(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BLOOD_POP_UP_ISSUE;
		title = "Pop Blood issue";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateBloodDonation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		boolean bool = bloodBankHandlerService.updateBloodDonation(box);
		if (bool) {
			message = "Data  updated Successfully!!";
		} else {
			message = "Eror Occurred !! Try Again !!";
		}
		jsp = BLOOD_SEARCH_DONATION;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);

	}

	// ----method for fill detials of particular service No............
	public void fillTestPatientDetail(HttpServletRequest request,
			HttpServletResponse response) {

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
		map = bloodBankHandlerService.fillPatientTestDetail(dataMap);
		if (map.get("patientList") != null) {
			patientList = (List) map.get("patientList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (Patient patient : patientList) {
				sb.append("<item>");
				sb.append("<hinId>" + patient.getId() + "</hinId>");
				String firstName="";
				String lastName="";
				firstName=patient.getPFirstName();
				lastName=patient.getPLastName();
				String patientName="";
				patientName=firstName+" "+lastName;
				sb.append("<name>" + patientName+ "</name>");
				sb.append("<age>" + patient.getAge() + "</age>");
				sb.append("<pType>" + patient.getPatientStatus() + "</pType>");
				if (patient.getPhoneNumber() != null) {
					sb.append("<teleNo>" + patient.getPhoneNumber()
							+ "</teleNo>");
				} else {
					sb.append("<teleNo>-</teleNo>");
				}
				if (patient.getState() != null) {
					sb.append("<relationId>" + patient.getRelation().getId()
							+ "</relationId>");
				} else {
					sb.append("<relationId>-</relationId>");
				}
				if (patient.getSex() != null) {
					sb
							.append("<sexId>" + patient.getSex().getId()
									+ "</sexId>");
				} else {
					sb.append("<sexId>-</sexId>");
				}

				if (patient.getRank() != null) {
					sb.append("<rankId>" + patient.getRank().getId()
							+ "</rankId>");
				} else {
					sb.append("<rankId>-</rankId>");
				}
				if (patient.getUnit() != null) {
					sb.append("<unitId>" + patient.getUnit().getId()
							+ "</unitId>");
				} else {
					sb.append("<unitId>-</unitId>");
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

	// -------Methods for update test Entry------
	public ModelAndView showUpdateBloodTestEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = BLOOD_SEARCH_TEST + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView searchPatientForUpdateTest(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String serviceNo = "";
		String entryNo = "";
		String adNo = "";
		String pType = "";
		int reactionId = 0;
		int departmentId = 0;
		int hinId = 0;
		String patientName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		if (request.getParameter(ENTRY_NO) != null
				&& !(request.getParameter(ENTRY_NO).equals(""))) {
			entryNo = request.getParameter(ENTRY_NO);
			mapForDs.put("entryNo", entryNo);
		}
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDs.put("serviceNo", serviceNo);
		}
		if (request.getParameter(PATIENT_NAME) != null
				&& !(request.getParameter(PATIENT_NAME).equals(""))) {
			patientName = request.getParameter(PATIENT_NAME);
			mapForDs.put("patientName", patientName);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals("0"))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			mapForDs.put("hinId", hinId);
		}
		int bloodTestId = 0;
		if (request.getParameter("bloodTestId") != null
				&& !(request.getParameter("bloodTestId").equals("0"))) {
			bloodTestId = Integer.parseInt(request.getParameter("bloodTestId"));
			mapForDs.put("bloodTestId", bloodTestId);
		}

		patientMap = bloodBankHandlerService
				.searchPatientForUpdateTest(mapForDs);

		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView showUpdateReactionEntry(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int reactionId = 0;
		if (request.getParameter(BLOOD_REACTION_ID) != null
				&& !(request.getParameter(BLOOD_REACTION_ID).equals("0"))) {
			reactionId = Integer.parseInt(request
					.getParameter(BLOOD_REACTION_ID));
			mapForDS.put("bloodReactionId", reactionId);
		}
		if (reactionId != 0) {
			map = bloodBankHandlerService.showUpdateReactonEntry(reactionId);
		}
		jsp = BLOOD_UPDATE_REACTION + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("indexB", "map", map);
	}

	public ModelAndView updateBloodTestEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		boolean bool = bloodBankHandlerService.updateBloodTestEntry(box);
		if (bool) {
			message = "Data  updated Successfully!!";
		} else {
			message = "Eror Occurred !! Try Again !!";
		}
		jsp = BLD_MSG_UPDATE_TEST;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("indexB", "map", map);
	}

	public void fillBloodbagForDiscrad(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<BloodStockDetail> bagList = new ArrayList<BloodStockDetail>();
		String bloodbagNo = "";

		try {
			if (request.getParameter("bloodbagNo") != null) {
				bloodbagNo = request.getParameter("bloodbagNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("bloodbagNo", bloodbagNo);
		map = bloodBankHandlerService.fillBloodbagForDiscrad(dataMap);
		if (map.get("bagList") != null) {
			bagList = (List) map.get("bagList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (BloodStockDetail bloodStockDetail : bagList) {
				sb.append("<item>");
				sb
						.append("<stockId>" + bloodStockDetail.getId()
								+ "</stockId>");
				sb.append("<serviceNo>"
						+ bloodStockDetail.getStockMain().getHin()
								.getServiceNo() + "</serviceNo>");
				sb.append("<hinId>"
						+ bloodStockDetail.getStockMain().getHin().getId()
						+ "</hinId>");
				sb
						.append("<collDate>"
								+ HMSUtil
										.convertDateToStringWithoutTime(bloodStockDetail
												.getStockMain()
												.getCollectionDate())
								+ "</collDate>");
				sb
						.append("<expiryDate>"
								+ HMSUtil
										.convertDateToStringWithoutTime(bloodStockDetail
												.getStockMain().getExpiryDate())
								+ "</expiryDate>");
				sb.append("<quantity>" + bloodStockDetail.getQty()
						+ "</quantity>");
				sb.append("<name>" + bloodStockDetail.getStockMain().getName()
						+ "</name>");
				if (bloodStockDetail.getStockMain().getHin().getRank() != null) {
					sb.append("<rankId>"
							+ bloodStockDetail.getStockMain().getHin()
									.getRank().getId() + "</rankId>");
				} else {
					sb.append("<rankId>-</rankId>");
				}
				if (bloodStockDetail.getStockMain().getHin().getUnit() != null) {
					sb.append("<unitAddress>"
							+ bloodStockDetail.getStockMain().getHin()
									.getUnit().getUnitAddress()
							+ "</unitAddress>");
				} else {
					sb.append("<unitAddress>-</unitAddress>");
				}

				if (bloodStockDetail.getStockMain().getHin().getBloodGroup() != null) {
					sb.append("<bloodGroupId>"
							+ bloodStockDetail.getStockMain().getHin()
									.getBloodGroup().getBloodGroupName()
							+ "</bloodGroupId>");
				} else {
					sb.append("<bloodGroupId>-</bloodGroupId>");
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

	// --------Fill recod for reaction form related blood bag no--
	public void fillBloodbagForReaction(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<BloodStockDetail> bagList = new ArrayList<BloodStockDetail>();
		String bloodBagNo = "";

		try {
			if (request.getParameter("bloodBagNo") != null) {
				bloodBagNo = request.getParameter("bloodBagNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("bloodBagNo", bloodBagNo);
		map = bloodBankHandlerService.fillBloodbagForReaction(dataMap);
		if (map.get("bagList") != null) {
			bagList = (List) map.get("bagList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (BloodStockDetail bloodStockDetail : bagList) {
				sb.append("<item>");
				sb
						.append("<stockId>" + bloodStockDetail.getId()
								+ "</stockId>");
				sb.append("<donorName>"
						+ bloodStockDetail.getStockMain().getName()
						+ "</donorName>");
				if (bloodStockDetail.getStockMain().getBloodGroup()  != null) {
					sb.append("<bloodGroupId>"
							+ bloodStockDetail.getStockMain().getBloodGroup() .getId()
							+ "</bloodGroupId>");
				} else {
					sb.append("<bloodGroupId>-</bloodGroupId>");
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

	public void checkBloodBagNo(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String bloodBagId = "";
		String exists = "no";
		if (request.getParameter("bloodBagId") != null) {
			bloodBagId = (request.getParameter("bloodBagId"));
		}
		dataMap.put("bloodBagId", bloodBagId);
		map = bloodBankHandlerService.chechBloodBag(dataMap);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fillItemsForComponentnameSeperation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String componentName = "";
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		try {
			if (request.getParameter("componentName") != null) {
				componentName = request.getParameter("componentName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("componentName", componentName);

		map = bloodBankHandlerService
				.fillItemsForComponentnameSeparation(dataMap);
		if (map.get("componentList") != null) {
			componentList = (List) map.get("componentList");
		}
		StringBuffer sb = new StringBuffer();

		sb.append("<items>");
		for (BloodMasComponent bloodMasComponent : componentList) {
			sb.append("<item>");
			sb.append("<componentId>" + bloodMasComponent.getId()
					+ "</componentId>");
			sb.append("<componentCode>" + bloodMasComponent.getComponentCode()
					+ "</componentCode>");
			sb.append("<quantity>" + bloodMasComponent.getQtyUnit()
					+ "</quantity>");
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

	public ModelAndView submitBloodComponentSeperation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		int noOfRecords = 0;
		int stockMainId = 0;
		int componentMainIdFromRequest = 0;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		List componentList = new ArrayList();
		List qtyList = new ArrayList();
		BloodStockMain stockMain = new BloodStockMain();
		int stockDtId = 0;
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		if (request.getParameter(BLOOD_STOCK_MAIN_ID) != null
				&& !(request.getParameter(BLOOD_STOCK_MAIN_ID).equals(""))) {
			stockMainId = Integer.parseInt(request
					.getParameter(BLOOD_STOCK_MAIN_ID));
		}
		if (request.getParameter("stockDtId") != null
				&& !request.getParameter("stockDtId").equals("")) {
			stockDtId = Integer.parseInt(request.getParameter("stockDtId"));
		}
		dataMap.put("stockMainId", stockMainId);
		dataMap.put("stockDtId", stockDtId);
		dataMap.put("stockMain", stockMain);

		try {
			int counter = 0;
			Vector blood_bag_no = box.getVector(BLOOD_BAG_NO);
			Vector stock_mainId = box.getVector("smainId");
			Vector quantity = box.getVector(QUANTITY);
			Vector component_id = box.getVector(BLOOD_COMPONENT_ID);
			Vector bloodComponentName = box.getVector("bloodComponentName");
			component_id.clear();
			for (int cnt = 0; cnt < bloodComponentName.size(); cnt++) {
				if (!bloodComponentName.get(cnt).equals("")) {
					String name = (String) bloodComponentName.get(cnt);

					int index = name.lastIndexOf("[");
					index++;
					int id = Integer.parseInt(name.substring(index, (name
							.length() - 1)));
					counter++;
					component_id.add(id);
				}
			}

			noOfRecords = counter;
			for (int i = 0; i < noOfRecords; i++) {
				componentList.add(component_id.get(i));
				qtyList.add(quantity.get(i));
			}
			dataMap.put("stock_mainId", stock_mainId);
			dataMap.put("blood_bag_no", blood_bag_no);
			dataMap.put("quantity", quantity);
			dataMap.put("componentMainIdFromRequest",
					componentMainIdFromRequest);
			dataMap.put("componentList", componentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("box", box);
		map = bloodBankHandlerService.submitBloodComponentSeperation(box,
				dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Component Seperation Done Successfully !!";
		} else {
			message = "Try Again !!";
		}
		jsp = BLD_MSG_COMP_SEPRATION;
		jsp += ".jsp";
		title = "Blood Component separation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("indexB", "map", map);
	}
//---------Blood Stock Report---

	 public ModelAndView showBloodStockReportjsp(HttpServletRequest request,HttpServletResponse response) {
         Map<String, Object> map = new HashMap<String, Object>();
         session = request.getSession();
         map = bloodBankHandlerService.showBloodStockRegisterjsp();

         jsp = BLOOD_STOCK_REGISTER_JSP;

         jsp += ".jsp";

         title = "Total Admission";

         map.put("contentJsp", jsp);

         map.put("title", title);

         return new ModelAndView("indexB", "map", map);

   }
	 public ModelAndView printBloodStockReport(HttpServletRequest request,
				HttpServletResponse response) {
		 Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			String detailSummry="";
			  String bloodComponentName = "All";
			  String query = "";
			  if( (!request.getParameter(BLOOD_COMPONENT_ID).equals("0")) && (request.getParameter(BLOOD_COMPONENT_ID)!= null)){
					if (request.getParameter(BLOOD_COMPONENT_NAME) != null) {
						query = "where blood_mas_component.`component_name` = '"
							+ request.getParameter(BLOOD_COMPONENT_NAME)+ "' ";
					}
			  }
			if (request.getParameter("summaryDetail") != null) {
				detailSummry = request.getParameter("summaryDetail");
			}
			detailsMap = bloodBankHandlerService.getDBConnection();
			parameters.put("QUERY", query);
			if(detailSummry.equals("summary")){
				HMSUtil.generateReport("bld_stock_report", parameters,(Connection) detailsMap.get("con"), response,
						getServletContext());
			}
			if(detailSummry.equals("details")){
				HMSUtil.generateReport("bld_stock_dt_report", parameters,(Connection) detailsMap.get("con"), response,
						getServletContext());

			}
		 return null;
	 }
		public ModelAndView getHinNoForDonor(
				HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			String serviceNo = "";
			String flag = "";
			List<Patient> patientList = new ArrayList<Patient>();
			if (request.getParameter(SERVICE_NO) != null) {
				serviceNo = request.getParameter(SERVICE_NO);
			}
			patientList = bloodBankHandlerService.getHinNoForDonor(serviceNo);
			if (patientList.size() > 0) {
				map.put("patientList", patientList);
			}
			String jsp = "bld_populateHinNoDonor";
			return new ModelAndView(jsp, "map", map);
		}

		public ModelAndView getDonorDetails(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Patient> patientList = new ArrayList<Patient>();
			String hinNo = "";
			if (request.getParameter(HIN_NO) != null) {
				hinNo = request.getParameter(HIN_NO);
			}
			map.put("flag", "lab");
			patientList = bloodBankHandlerService.getDonorDetails(hinNo);
			String jsp = "bld_donorDetails";
			map.put("patientList", patientList);
			return new ModelAndView(jsp, "map", map);
		}

	// ----------------------------------------------------------------------------------------------------
	public BloodBankHandlerService getBloodBankHandlerService() {
		return bloodBankHandlerService;
	}

	public void setBloodBankHandlerService(
			BloodBankHandlerService bloodBankHandlerService) {
		this.bloodBankHandlerService = bloodBankHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
